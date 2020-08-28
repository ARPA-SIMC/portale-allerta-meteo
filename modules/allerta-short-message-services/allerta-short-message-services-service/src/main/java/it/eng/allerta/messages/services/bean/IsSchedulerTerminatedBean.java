package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSchedulerTerminatedBean {

	@SerializedName("isSchedulerTerminated")
	@Expose
	private boolean isSchedulerTerminated;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSchedulerTerminatedBean() {
	}

	/**
	 * 
	 * @param isSchedulerTerminated
	 */
	public IsSchedulerTerminatedBean(Boolean isSchedulerTerminated) {
		super();
		this.isSchedulerTerminated = isSchedulerTerminated;
	}

	public boolean getIsSchedulerTerminated() {
		return isSchedulerTerminated;
	}

	public void setIsSchedulerTerminated(boolean isSchedulerTerminated) {
		this.isSchedulerTerminated = isSchedulerTerminated;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSchedulerTerminated", isSchedulerTerminated).toString();
	}
}
