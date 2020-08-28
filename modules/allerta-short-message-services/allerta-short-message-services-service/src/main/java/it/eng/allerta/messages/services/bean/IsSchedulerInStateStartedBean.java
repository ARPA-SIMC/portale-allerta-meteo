package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerInStateStartedBean {

	@SerializedName("isSchedulerInStateStarted")
	@Expose
	private boolean isSchedulerInStateStarted;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerInStateStartedBean() {
	}

	/**
	 * 
	 * @param isSchedulerReceiveShutdown
	 */
	public IsSchedulerInStateStartedBean(Boolean isSchedulerInStateStarted) {
		this.isSchedulerInStateStarted = isSchedulerInStateStarted;
	}

	public boolean getIsSchedulerInStateStarted() {
		return isSchedulerInStateStarted;
	}

	public void setIsSchedulerInStateStarted(boolean isSchedulerInStateStarted) {
		this.isSchedulerInStateStarted = isSchedulerInStateStarted;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerInStateStarted", isSchedulerInStateStarted).toString();
	}
}
