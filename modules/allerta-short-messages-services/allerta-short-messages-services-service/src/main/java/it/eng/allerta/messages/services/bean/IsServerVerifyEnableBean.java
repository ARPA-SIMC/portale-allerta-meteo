package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsServerVerifyEnableBean {
	@SerializedName("isServerVerifyEnable")
	@Expose
	private boolean isServerVerifyEnable;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsServerVerifyEnableBean() {
	}

	/**
	 * 
	 * @param isEnable
	 */
	public IsServerVerifyEnableBean(Boolean isServerVerifyEnable) {
		super();
		this.isServerVerifyEnable = isServerVerifyEnable;
	}

	public boolean isServerVerifyEnable() {
		return isServerVerifyEnable;
	}

	public void setServerVerifyEnable(boolean isServerVerifyEnable) {
		this.isServerVerifyEnable = isServerVerifyEnable;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isServerVerifyEnable", isServerVerifyEnable).toString();
	}
}
