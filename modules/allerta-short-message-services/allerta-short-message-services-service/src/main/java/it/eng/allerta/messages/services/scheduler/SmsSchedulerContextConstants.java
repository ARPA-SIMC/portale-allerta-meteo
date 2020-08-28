package it.eng.allerta.messages.services.scheduler;

import java.util.concurrent.TimeUnit;

public class SmsSchedulerContextConstants {

	public final static TimeUnit HEARTBEAT_PERIOD_TIMEUNIT = TimeUnit.SECONDS;
	public final static long HEARTBEAT_PERIOD_VALUE = 5;
	public final static long HEARTBEAT_OCCURRENCES = 7;
	
	public final static TimeUnit SERVER_VERIFY_PERIOD_TIMEUNIT = TimeUnit.MINUTES;
	public final static long SERVER_VERIFY_PERIOD_VALUE = 5;
	public final static long SERVER_VERIFY_DELAY_BETWEEN_CALL = 20000; // ms
	public final static long SERVER_VERIFY_MAXERROR = 15;
	
	public final static TimeUnit SCHEDULER_DELAY_TIMEUNIT = TimeUnit.SECONDS;
	public final static long SCHEDULER_DELAY_VALUE = 10;
	public final static long SCHEDULER_TASK_SENT_DELAY_VALUE = 100; // ms
	
	//public final static TimeUnit WATCHDOG_PERIOD_TIMEUNIT = TimeUnit.SECONDS;
	//public final static long WATCHDOG_PERIOD_VALUE = 5;

}
