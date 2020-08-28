package it.eng.allerta.messages.services.scheduler;

public class SmsSchedulerContextException extends Exception {

	private static final long serialVersionUID = -802769713574899333L;
	
	public SmsSchedulerContextException(String msg) {
		super(msg);
	}
	
	public SmsSchedulerContextException(String msg, Throwable t) {
		super(msg, t);
	}
}
