package it.eng.allerta.messages.services.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsSchedulerShutdownBean {

	@SerializedName("isSchedulerShutdown")
	@Expose
	private boolean isSchedulerShutdown;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerShutdownBean() {
	}

	/**
	 * 
	 * @param isSchedulerShutdown
	 */
	public IsSchedulerShutdownBean(Boolean isSchedulerShutdown) {
		super();
		this.isSchedulerShutdown = isSchedulerShutdown;
	}

	public boolean getIsSchedulerShutdown() {
		return isSchedulerShutdown;
	}

	public void setIsSchedulerShutdown(boolean isSchedulerShutdown) {
		this.isSchedulerShutdown = isSchedulerShutdown;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerShutdown", isSchedulerShutdown).toString();
	}
}
