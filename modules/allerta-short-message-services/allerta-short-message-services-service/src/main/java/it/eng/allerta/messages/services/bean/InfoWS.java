package it.eng.allerta.messages.services.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class InfoWS {

	@SerializedName("myIp")
	@Expose
	private String myIp;
	
	@SerializedName("nameJVM")
	@Expose
	private String nameJVM;
	
	@SerializedName("smsInviati")
	@Expose
	private String smsInviati;
	
	@SerializedName("isSmsSend")
	@Expose
	private String isSmsSend;
	
	
	@SerializedName("isSchedulerStarted")
	@Expose
	private String isSchedulerStarted;

	@SerializedName("isSchedulerTerminated")
	@Expose
	private String isSchedulerTerminated;
	
	@SerializedName("isSchedulerShutdown")
	@Expose
	private String isSchedulerShutdown;
	
	@SerializedName("isSchedulerSendShutdown")
	@Expose
	private String isSchedulerSendShutdown;

	@SerializedName("isSchedulerReceiveShutdown")
	@Expose
	private String isSchedulerReceiveShutdown;

	@SerializedName("isSchedulerSendTerminated")
	@Expose
	private String isSchedulerSendTerminated;

	@SerializedName("isSchedulerReceiveTerminated")
	@Expose
	private String isSchedulerReceiveTerminated;
	
	
	@SerializedName("result")
	@Expose
	private String result;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public InfoWS() {
	}

	/**
	 * 
	 * @param result
	 * @param nameJVM
	 * @param myIp
	 * @param webServicesConnected
	 */
	public InfoWS(String myIp, String result, String nameJVM) {
		this.myIp = myIp;
		this.result = result;
		this.nameJVM = nameJVM;
	}

	public InfoWS(String myIp, String result, String nameJVM, String smsInviati, String isSchedulerTerminated, String isSchedulerShutdown) {
		this(myIp, result, nameJVM);
		this.smsInviati = smsInviati;
		this.isSchedulerTerminated = isSchedulerTerminated;
		this.isSchedulerShutdown = isSchedulerShutdown;
	}

	public String getMyIp() {
		return myIp;
	}

	public void setMyIp(String myIp) {
		this.myIp = myIp;
	}

	public String getNameJVM() {
		return nameJVM;
	}

	public void setNameJVM(String nameJVM) {
		this.nameJVM = nameJVM;
	}

	public String getSmsInviati() {
		return smsInviati;
	}

	public void setSmsInviati(String smsInviati) {
		this.smsInviati = smsInviati;
	}
	
	public String getIsSmsSend() {
		return isSmsSend;
	}

	public void setIsSmsSend(String isSmsSend) {
		this.isSmsSend = isSmsSend;
	}
	
	
	public String getIsSchedulerStarted() {
		return isSchedulerStarted;
	}

	public void setIsSchedulerStarted(String isSchedulerStarted) {
		this.isSchedulerStarted = isSchedulerStarted;
	}

	public String getIsSchedulerTerminated() {
		return isSchedulerTerminated;
	}

	public void setIsSchedulerTerminated(String isSchedulerTerminated) {
		this.isSchedulerTerminated = isSchedulerTerminated;
	}

	public String getIsSchedulerShutdown() {
		return isSchedulerShutdown;
	}

	public void setIsSchedulerShutdown(String isSchedulerShutdown) {
		this.isSchedulerShutdown = isSchedulerShutdown;
	}
	
	public String getIsSchedulerSendShutdown() {
		return isSchedulerSendShutdown;
	}

	public void setIsSchedulerSendShutdown(String isSchedulerSendShutdown) {
		this.isSchedulerSendShutdown = isSchedulerSendShutdown;
	}
	
	public String getIsSchedulerReceiveShutdown() {
		return isSchedulerReceiveShutdown;
	}

	public void setIsSchedulerReceiveShutdown(String isSchedulerReceiveShutdown) {
		this.isSchedulerReceiveShutdown = isSchedulerReceiveShutdown;
	}
	
	public String getIsSchedulerSendTerminated() {
		return isSchedulerSendTerminated;
	}

	public void setIsSchedulerSendTerminated(String isSchedulerSendTerminated) {
		this.isSchedulerSendTerminated = isSchedulerSendTerminated;
	}

	public String getIsSchedulerReceiveTerminated() {
		return isSchedulerReceiveTerminated;
	}

	public void setIsSchedulerReceiveTerminated(String isSchedulerReceiveTerminated) {
		this.isSchedulerReceiveTerminated = isSchedulerReceiveTerminated;
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("myIp", myIp).append("nameJVM", nameJVM).append("smsInviati", smsInviati)
				.append("isSmsSend", isSmsSend)
				.append("isSchedulerStarted", isSchedulerStarted)
				.append("isSchedulerTerminated",isSchedulerTerminated)
				.append("isSchedulerShutdown", isSchedulerShutdown)
				.append("isSchedulerSendShutdown", isSchedulerSendShutdown)
				.append("isSchedulerReceiveShutdown", isSchedulerReceiveShutdown)
				.append("isSchedulerSendTerminated", isSchedulerSendTerminated)
				.append("isSchedulerReceiveTerminated", isSchedulerReceiveTerminated)
				.append("result", result)
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(myIp).append(nameJVM).append(smsInviati)
				.append(isSmsSend)
				.append(isSchedulerStarted)
				.append(isSchedulerTerminated)
				.append(isSchedulerShutdown)
				.append(isSchedulerSendShutdown)
				.append(isSchedulerReceiveShutdown)
				.append(isSchedulerSendTerminated)
				.append(isSchedulerReceiveTerminated)
				.append(result)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof InfoWS) == false) {
			return false;
		}
		
		InfoWS rhs = ((InfoWS) other);
		
		return new EqualsBuilder()
				.append(myIp, rhs.myIp).append(nameJVM, rhs.nameJVM).append("smsInviati",rhs.smsInviati)
				.append(isSmsSend, rhs.isSmsSend)
				.append("isSchedulerStarted", rhs.isSchedulerStarted)
				.append("isSchedulerTerminated",rhs.isSchedulerTerminated)
				.append("isSchedulerShutdown",rhs.isSchedulerShutdown)
				.append("isSchedulerSendShutdown", rhs.isSchedulerSendShutdown)
				.append("isSchedulerReceiveShutdown", rhs.isSchedulerReceiveShutdown)
				.append("isSchedulerSendTerminated", rhs.isSchedulerSendTerminated)
				.append("isSchedulerReceiveTerminated", rhs.isSchedulerReceiveTerminated)
				.append(result, rhs.result)
				.isEquals();
	}

}