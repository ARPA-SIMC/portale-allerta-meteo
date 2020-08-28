package it.eng.allerta.backoffice.scheduler.bean;

import java.io.Serializable;
import java.util.Date;

public interface SchedulerJobBean extends Serializable {
	
	public static final String NULL_VALUE_DISPLAY = "-";

    public String getJobName();
    
    public void setJobName(String jobName);
    
    public String getGroupName();
    
    public void setGroupName(String groupName);
    
    public String getTriggerState();
    
    public void setTriggerState(String triggerState);
    
    public Date getStartTime();
    
    public void setStartTime(Date startTime);
    
    public Date getEndTime();
    
    public void setEndTime(Date endTime);
    
    public Date getPreviousFireTime();
    
    public void setPreviousFireTime(Date previousFireTime);
    
    public Date getNextFireTime();
    
    public void setNextFireTime(Date nextFireTime);
    
    public String getStorageType();
    
    public void setStorageType(String storageType);
    
    public String getShortName();
    
    public String getShortGroup();

}
