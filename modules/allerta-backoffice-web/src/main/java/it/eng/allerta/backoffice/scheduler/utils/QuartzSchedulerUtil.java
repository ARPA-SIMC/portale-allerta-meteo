package it.eng.allerta.backoffice.scheduler.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.TriggerState; 
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.backoffice.scheduler.bean.SchedulerJobBean;
import it.eng.allerta.backoffice.scheduler.bean.impl.SchedulerJobBeanImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

public class QuartzSchedulerUtil {
	
	public static SchedulerJobBean getSchedulerJob(SchedulerResponse schedulerResponse) {
		
		SchedulerJobBean schedulerJobBean = new SchedulerJobBeanImpl();
				
		if( ! schedulerResponse.getJobName().startsWith("it.eng"))
			return null;
		
        TriggerState triggerState = SchedulerEngineHelperUtil.getJobState(schedulerResponse);
        
        Date startTime = SchedulerEngineHelperUtil.getStartTime(schedulerResponse);
        Date endTime = SchedulerEngineHelperUtil.getEndTime(schedulerResponse);
        Date previousFireTime = SchedulerEngineHelperUtil.getPreviousFireTime(schedulerResponse);
        Date nextFireTime = SchedulerEngineHelperUtil.getNextFireTime(schedulerResponse);
        
        StorageType storageType = schedulerResponse.getStorageType();
        
        schedulerJobBean.setJobName(schedulerResponse.getJobName());
        schedulerJobBean.setGroupName(schedulerResponse.getGroupName());
        schedulerJobBean.setTriggerState(triggerState == null ? SchedulerJobBean.NULL_VALUE_DISPLAY : triggerState.toString());
        schedulerJobBean.setStartTime(startTime);
        schedulerJobBean.setEndTime(endTime);
        schedulerJobBean.setPreviousFireTime(previousFireTime);
        schedulerJobBean.setNextFireTime(nextFireTime);
        schedulerJobBean.setStorageType(storageType == null ? SchedulerJobBean.NULL_VALUE_DISPLAY : storageType.toString().trim());
        
        return schedulerJobBean;
    }
	
	public static List<SchedulerJobBean> getSchedulerJobsList(List<SchedulerResponse> schedulerResponses) {
		
        List<SchedulerJobBean> schedulerJobBeans = new ArrayList<SchedulerJobBean>();
        
        for (SchedulerResponse scheduler : schedulerResponses) {
        	
        	SchedulerJobBean jb = getSchedulerJob(scheduler);
        	if( jb != null)
        		schedulerJobBeans.add( jb);
        }
        
        return schedulerJobBeans;
    }
	
	public static void scheduleJobServiceAction(String action) throws SchedulerException {
        
        if (action.equals(ACTION_SHUTDOWN)) {
            _log.info(LOG_SHUTDOWN_ACTION_MSG);
            SchedulerEngineHelperUtil.shutdown();
        }
    }
	
	public static void scheduleJobAction(PortletRequest request, String action) throws SchedulerException, ParseException {
		 
     // Checking all the rows to see which are selected
		String rowSelection;
	    for (int i = 0; (rowSelection = request.getParameter(PARAMETER_JOB_SELECTED + i)) != null; i++) {
	    	
	    	 
	        boolean rowSelected = GetterUtil.get(rowSelection, false);
	         
	        if (rowSelected) {
	             
	            String jobName = ParamUtil.getString(request, PARAMETER_JOB_NAME + i);
	            String groupName = ParamUtil.getString(request, PARAMETER_JOB_GROUP + i);
	            String storageTypeText = ParamUtil.getString(request, PARAMETER_STORAGE_TYPE + i);
	            StorageType storageType = StorageType.valueOf(storageTypeText);
	             
	             // Log debug messages
	            if (_log.isDebugEnabled()) {
	            	_log.debug(String.format(LOG_JOB_FORMAT, action, LOG_ACTION_MSG, jobName, groupName, storageType));
	            }
	            
	            if (action.equals(ACTION_PAUSE)) {
	                SchedulerEngineHelperUtil.pause(jobName, groupName, storageType);
	            } else if (action.equals(ACTION_RESUME)) {
	                
	            	SchedulerEngineHelperUtil.resume(jobName, groupName, storageType);
	            	
	            	/*
	            	SchedulerEngineHelperUtil.delete(jobName, groupName, storageType);
	            	
	            	 Trigger trigger = 
		        				TriggerFactoryUtil.createTrigger(jobName, groupName, 1, TimeUnit.MINUTE);
		                
	            	//SchedulerEngineHelperUtil.unschedule(jobName, groupName, storageType);
	            	//SchedulerEngineHelperUtil.update( jobName, groupName, storageType, jobName, "", null, 10);
	                
	          
	               
	                Message message = new Message ();
	               
	                //message.put(SchedulerEngine.SCHEDULER, jobName);
	                message.put(SchedulerEngine.JOB_NAME, jobName);
	                message.put(SchedulerEngine.GROUP_NAME , groupName);
	                //message.put(SchedulerEngine.DESTINATION_NAME, DestinationNames.SCHEDULER_DISPATCH);
	                
	             
	                
	                SchedulerEngineHelperUtil.schedule(trigger, storageType, "", "liferay/scheduler_dispatch", message, 5);  
	                
	              	
	                MessageBusUtil.registerMessageListener(DestinationNames.SCHEDULER_DISPATCH, new Cari);
	                
	                SchedulerEngineHelperUtil.schedule(
	                			trigger, 
	                			storageType, 
	                			jobName, 
	                			DestinationNames.SCHEDULER_DISPATCH, 
	                			message, 10);
	            	
	            	*/

	            } else if (action.equals(ACTION_RUN)) {
	                runScheduledJob(jobName, groupName);
	            }
	         }
	     }      
	}
	
	private static void runScheduledJob(String jobName, String groupName) {
		
    	Message message = new Message();
    	
        message.put(SchedulerEngine.JOB_NAME, jobName);
        message.put(SchedulerEngine.GROUP_NAME , groupName);
        message.put(SchedulerEngine.DESTINATION_NAME, DestinationNames.SCHEDULER_DISPATCH);
        
        MessageBusUtil.sendMessage(DestinationNames.SCHEDULER_DISPATCH, message);
    }
	
	public static List<SchedulerJobBean> subList(List<SchedulerJobBean> list, Integer start, Integer end) {
		
        if (list != null) {
            return ListUtil.subList(list, start, end);
        } else {
            return new ArrayList<SchedulerJobBean>();
        }
    }
	
	private static boolean checkRunSupported() {
		
        try {
        	
            QuartzSchedulerUtil.class.getClassLoader().loadClass("com.liferay.portal.kernel.scheduler.messaging.ReceiverKey");
            return true;
            
        } catch(ClassNotFoundException e) {
            if(_log.isDebugEnabled()) {
                _log.debug("Scheduled Job execution not supported.");
            }
            
            return false;
        }
        
    }
	
	public static void getSchedulerJobs(PortletRequest request) throws SchedulerException {
		
        // Scheduler List
        List<SchedulerResponse> schedulerJobs = SchedulerEngineHelperUtil.getScheduledJobs();
        List<SchedulerJobBean> schedulerJobBeans = getSchedulerJobsList(schedulerJobs);
        
        request.setAttribute(ATTRIBUTE_JOBS_LIST, schedulerJobBeans);
        request.setAttribute(ATTRIBUTE_COUNT, schedulerJobBeans.size());
    }
	
	public static final String ATTRIBUTE_JOBS_LIST = "schedulerJobsList";
    public static final String ATTRIBUTE_COUNT = "count";
	
	private static final Log _log = LogFactoryUtil.getLog(QuartzSchedulerUtil.class);
	
	private static final String LOG_ACTION_MSG = "action will be processed on job ";
    private static final String LOG_SHUTDOWN_ACTION_MSG = "Processing request for shutdown";
    private static final String LOG_JOB_FORMAT = "%s %s %s [%s, %s]";
    
    private static final String COLUMN_SHORT_NAME = "shortName";
    private static final String COLUMN_SHORT_GROUP = "shortGroup";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_START_TIME = "startTime";
    private static final String COLUMN_END_TIME = "endTime";
    private static final String COLUMN_PREVIOUS_FIRE_TIME = "previousFireTime";
    private static final String COLUMN_NEXT_FIRE_TIME = "nextFireTime";
    private static final String COLUMN_STORAGE_TYPE = "storageType";
    
    public static final boolean RUN_SUPPORTED = checkRunSupported();
    
    public static final String ACTION_RUN = "run";
    public static final String ACTION_PAUSE = "pause";
    public static final String ACTION_RESUME = "resume";
    public static final String ACTION_SHUTDOWN = "shutdown";
    public static final String ACTION_REFRESH = "refresh";

    public static final String PARAMETER_JOB_ACTION = "jobAction";
    public static final String PARAMETER_JOB_SELECTED = "jobSelected";
    public static final String PARAMETER_JOB_NAME = "jobName";
    public static final String PARAMETER_JOB_GROUP = "jobGroup";
    public static final String PARAMETER_STORAGE_TYPE = "jobStorageType";

    public static final String DEFAULT_ORDER_BY_TYPE = "asc";
    public static final String DEFAULT_ORDER_BY_COL = COLUMN_SHORT_NAME;

}
