package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerReceiveTerminatedBean {

	@SerializedName("isSchedulerReceiveTerminated")
	@Expose
	private boolean isSchedulerReceiveTerminated;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerReceiveTerminatedBean() {
	}

	/**
	 * 
	 * @param isSchedulerReceiveTerminated
	 */
	public IsSchedulerReceiveTerminatedBean(Boolean isSchedulerReceiveTerminated) {
		super();
		this.isSchedulerReceiveTerminated = isSchedulerReceiveTerminated;
	}

	public boolean getIsSchedulerReceiveTerminated() {
		return isSchedulerReceiveTerminated;
	}

	public void setIsSchedulerReceiveTerminated(boolean isSchedulerReceiveTerminated) {
		this.isSchedulerReceiveTerminated = isSchedulerReceiveTerminated;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerReceiveTerminated", isSchedulerReceiveTerminated).toString();
	}
}
