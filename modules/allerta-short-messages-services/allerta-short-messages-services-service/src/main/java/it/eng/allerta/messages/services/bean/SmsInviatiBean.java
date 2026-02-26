package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SmsInviatiBean {
	@SerializedName("smsInviati")
	@Expose
	private long smsInviati;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SmsInviatiBean() {
	}

	/**
	 * 
	 * @param smsInviati
	 */
	public SmsInviatiBean(long smsInviati) {
		super();
		this.smsInviati = smsInviati;
	}

	public long getSmsInviati() {
		return smsInviati;
	}

	public void setSmsInviati(long smsInviati) {
		this.smsInviati = smsInviati;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("smsInviati", smsInviati).toString();
	}
}

