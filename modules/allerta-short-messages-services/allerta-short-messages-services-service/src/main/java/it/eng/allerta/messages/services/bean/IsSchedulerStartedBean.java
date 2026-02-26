package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerStartedBean {
	@SerializedName("isSchedulerStarted")
	@Expose
	private boolean isSchedulerStarted;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerStartedBean() {
	}

	/**
	 * 
	 * @param isSchedulerStarted
	 */
	public IsSchedulerStartedBean(Boolean isSchedulerStarted) {
		super();
		this.isSchedulerStarted = isSchedulerStarted;
	}

	public boolean getIsSchedulerStarted() {
		return isSchedulerStarted;
	}

	public void setIsSchedulerStarted(boolean isSchedulerStarted) {
		this.isSchedulerStarted = isSchedulerStarted;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerStarted", isSchedulerStarted).toString();
	}
}
