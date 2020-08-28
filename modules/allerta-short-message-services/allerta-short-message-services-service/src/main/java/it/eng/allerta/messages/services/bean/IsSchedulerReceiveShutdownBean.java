package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerReceiveShutdownBean {

	@SerializedName("isSchedulerReceiveShutdown")
	@Expose
	private boolean isSchedulerReceiveShutdown;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerReceiveShutdownBean() {
	}

	/**
	 * 
	 * @param isSchedulerReceiveShutdown
	 */
	public IsSchedulerReceiveShutdownBean(Boolean isSchedulerReceiveShutdown) {
		super();
		this.isSchedulerReceiveShutdown = isSchedulerReceiveShutdown;
	}

	public boolean getIsSchedulerReceiveShutdown() {
		return isSchedulerReceiveShutdown;
	}

	public void setIsSchedulerReceiveShutdown(boolean isSchedulerReceiveShutdown) {
		this.isSchedulerReceiveShutdown = isSchedulerReceiveShutdown;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerReceiveShutdown", isSchedulerReceiveShutdown).toString();
	}
}
