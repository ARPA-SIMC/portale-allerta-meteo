package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LogBean {
	
	@SerializedName("text")
	@Expose
	private String text;

	public LogBean() {
	}

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
