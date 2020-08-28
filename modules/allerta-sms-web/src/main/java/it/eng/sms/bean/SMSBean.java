package it.eng.sms.bean;

import java.util.Date;

import it.eng.allerter.model.SMS;

public class SMSBean {

	int trn;
	SMS sms;
	Date dataInvio = new Date();
	
	public SMSBean(int trn, SMS sms, Date dataInvio) {
		super();
		this.trn = trn;
		this.sms = sms;
		this.dataInvio = dataInvio;
	}
	
	public SMSBean(int trn, SMS sms) {
		super();
		this.trn = trn;
		this.sms = sms;
	}

	public int getTrn() {
		return trn;
	}

	public void setTrn(int trn) {
		this.trn = trn;
	}

	public SMS getSms() {
		return sms;
	}

	public void setSms(SMS sms) {
		this.sms = sms;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + trn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SMSBean other = (SMSBean) obj;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (trn != other.trn)
			return false;
		return true;
	}
}
