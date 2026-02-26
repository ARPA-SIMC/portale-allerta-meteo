package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

// Usato in SmsManager
public class IsShutdownBean {
	@SerializedName("isShutdown")
	@Expose
	private boolean isShutdown;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsShutdownBean() {
	}

	/**
	 * 
	 * @param isShutdown
	 */
	public IsShutdownBean(Boolean isShutdown) {
		super();
		this.isShutdown = isShutdown;
	}

	public boolean getIsShutdown() {
		return isShutdown;
	}

	public void setIsShutdown(boolean isShutdown) {
		this.isShutdown = isShutdown;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isShutdown", isShutdown).toString();
	}
}
