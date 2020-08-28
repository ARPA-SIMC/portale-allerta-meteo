package it.eng.allerta.backoffice.scheduler.bean.impl;

import java.util.Date;

import it.eng.allerta.backoffice.scheduler.bean.SchedulerJobBean;

public class SchedulerJobBeanImpl implements SchedulerJobBean {

	private static final long serialVersionUID = 5886615924709949479L;
	
	@Override
	public String getJobName() {
		 return jobName;
	}

	@Override
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String getGroupName() {
		return groupName;
	}

	@Override
	public void setGroupName(String groupName) {
		 this.groupName = groupName;
	}

	@Override
	public String getTriggerState() {
		return triggerState;
	}

	@Override
	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

	@Override
	public Date getStartTime() {
		 return startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Override
	public Date getEndTime() {
		return endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public Date getPreviousFireTime() {
		return previousFireTime;
	}

	@Override
	public void setPreviousFireTime(Date previousFireTime) {
		this.previousFireTime = previousFireTime;
	}

	@Override
	public Date getNextFireTime() {
		return nextFireTime;
	}

	@Override
	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	@Override
	public String getStorageType() {
		return storageType;
	}

	@Override
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	@Override
	public String getShortName() {
		
		 if (jobName != null && !jobName.isEmpty() && jobName.indexOf('.') > 0) {
	         return jobName.substring(jobName.lastIndexOf('.')).substring(1);
	     } else {
	         return null;
	     }
	}

	@Override
	public String getShortGroup() {
		
		if (groupName != null) {
            return groupName.substring(groupName.lastIndexOf(".") + 1);
        } else {
            return null;
        }
	}
	
	protected String jobName;
    protected String groupName;
    protected String triggerState;
    protected Date startTime;
    protected Date endTime;
    protected Date previousFireTime;
    protected Date nextFireTime;
    protected String storageType;

}
