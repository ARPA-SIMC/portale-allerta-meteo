package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerSendTerminatedBean {
	@SerializedName("isSchedulerSendTerminated")
	@Expose
	private boolean isSchedulerSendTerminated;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerSendTerminatedBean() {
	}

	/**
	 * 
	 * @param isSchedulerSendTerminated
	 */
	public IsSchedulerSendTerminatedBean(Boolean isSchedulerSendTerminated) {
		super();
		this.isSchedulerSendTerminated = isSchedulerSendTerminated;
	}

	public boolean getIsSchedulerSendTerminated() {
		return isSchedulerSendTerminated;
	}

	public void setIsSchedulerSendTerminated(boolean isSchedulerSendTerminated) {
		this.isSchedulerSendTerminated = isSchedulerSendTerminated;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerSendTerminated", isSchedulerSendTerminated).toString();
	}
}
