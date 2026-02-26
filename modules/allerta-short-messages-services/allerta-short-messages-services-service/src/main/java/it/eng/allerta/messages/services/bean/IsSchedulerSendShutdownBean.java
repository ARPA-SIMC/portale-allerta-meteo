package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerSendShutdownBean {

	@SerializedName("isSchedulerSendShutdown")
	@Expose
	private boolean isSchedulerSendShutdown;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerSendShutdownBean() {
	}

	/**
	 * 
	 * @param isSchedulerSendShutdown
	 */
	public IsSchedulerSendShutdownBean(Boolean isSchedulerSendShutdown) {
		super();
		this.isSchedulerSendShutdown = isSchedulerSendShutdown;
	}

	public boolean getIsSchedulerSendShutdown() {
		return isSchedulerSendShutdown;
	}

	public void setIsSchedulerSendShutdown(boolean isSchedulerSendShutdown) {
		this.isSchedulerSendShutdown = isSchedulerSendShutdown;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerSendShutdown", isSchedulerSendShutdown).toString();
	}
}
