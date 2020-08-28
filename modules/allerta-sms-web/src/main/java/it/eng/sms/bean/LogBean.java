package it.eng.sms.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogBean {
	
	@SerializedName("text")
	@Expose
	private String text;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public LogBean() {
	}

	/**
	 * 
	 * @param text
	 */
	public LogBean(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("text", text).toString();
	}


}
