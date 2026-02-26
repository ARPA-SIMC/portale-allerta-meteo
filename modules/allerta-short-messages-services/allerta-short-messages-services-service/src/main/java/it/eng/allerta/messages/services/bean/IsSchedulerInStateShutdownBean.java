package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerInStateShutdownBean {

	@SerializedName("isSchedulerInStateShutdown")
	@Expose
	private boolean isSchedulerInStateShutdown;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerInStateShutdownBean() {
	}

	/**
	 * 
	 * @param isSchedulerReceiveShutdown
	 */
	public IsSchedulerInStateShutdownBean(Boolean isSchedulerInStateShutdown) {
		this.isSchedulerInStateShutdown = isSchedulerInStateShutdown;
	}

	public boolean getIsSchedulerInStateShutdown() {
		return isSchedulerInStateShutdown;
	}

	public void setIsSchedulerInStateShutdown(boolean isSchedulerInStateShutdown) {
		this.isSchedulerInStateShutdown = isSchedulerInStateShutdown;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerInStateShutdown", isSchedulerInStateShutdown).toString();
	}
}
