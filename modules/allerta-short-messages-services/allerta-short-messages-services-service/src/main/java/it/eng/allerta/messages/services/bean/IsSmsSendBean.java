package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class IsSmsSendBean {
	
	@SerializedName("isSmsSend")
	@Expose
	private boolean smsSend;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IsSmsSendBean() {
	}

	/**
	 * 
	 * @param isEnable
	 */
	public IsSmsSendBean(Boolean smsSend) {
		super();
		this.smsSend = smsSend;
	}

	public boolean isSmsSend() {
		return smsSend;
	}

	public void setSmsSend(boolean smsSend) {
		this.smsSend = smsSend;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isSmsSend", smsSend).toString();
	}
}
