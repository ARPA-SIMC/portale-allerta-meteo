/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model.impl;

/**
 * @author Giorgianni_F
 */
public class SmsSchedulerContextImpl extends SmsSchedulerContextBaseImpl {
	

	private static final long serialVersionUID = -2010276714154940976L;
	
	public enum SmsSchedulerState {
		TRY_START,
		STARTED,
		NOT_STARTED,
		TRY_SHUTDOWN,
		SHUTDOWN,
		NOT_SHUTDOWN,
		FORCE_SHUTDOWN,
		DEAD,
		UNDEFINED;
	}
	
	public enum PortletContextState {
		INIT_EXECUTED,
		INIT_EXCEPTION,
		DESTROY_EXECUTED,
		DESTROY_EXCEPTION
	}
	
	public static final String VAR_ID_SMS_SCHEDULER_STATE = "SMS_SCHEDULER_STATE";
	
	public static final String VAR_ID_HEARTBEAT_INSTANT = "HEARTBEAT_INSTANT";
	public static final String VAR_ID_HEARTBEAT_PERIOD_TIMEUNIT = "HEARTBEAT_PERIOD_TIMEUNIT";	
	public static final String VAR_ID_HEARTBEAT_PERIOD = "HEARTBEAT_PERIOD";
	public static final String VAR_ID_HEARTBEAT_OCCURRENCES = "HEARTBEAT_OCCURRENCES";
	
	public static final String VAR_SERVER_VERIFY_PERIOD_TIMEUNIT = "SERVER_VERIFY_PERIOD_TIMEUNIT";
	public static final String VAR_SERVER_VERIFY_PERIOD_VALUE = "SERVER_VERIFY_PERIOD_VALUE";
	public static final String VAR_SERVER_VERIFY_DELAY_BETWEEN_CALL = "SERVER_VERIFY_DELAY_BETWEEN_CALL";
	public static final String VAR_SERVER_VERIFY_MAXERROR = "SERVER_VERIFY_MAXERROR";
	
	public static final String VAR_ID_SCHEDULER_DELAY_TIMEUNIT = "SCHEDULER_DELAY_TIMEUNIT";	
	public static final String VAR_ID_SCHEDULER_DELAY_VALUE = "SCHEDULER_DELAY_VALUE";
	public static final String VAR_ID_SCHEDULER_TASK_SENT_DELAY_VALUE = "SCHEDULER_TASK_SENT_DELAY_VALUE";
	public static final String VAR_ID_SCHEDULER_SMS_SIMULATION_SEND = "SCHEDULER_SMS_SIMULATION_SEND";
	
	public static final String VAR_ID_CURRENT_SCHEDULER_HOST_IP_AND_PORT = "CURRENT_SCHEDULER_HOST_IP_AND_PORT";
	public static final String VAR_ID_SMS_WATCHDOG_SUSPEND = "SMS_WATCHDOG_SUSPEND";
	
	public static final String VAR_ID_PORTAL_CONTEXT_STATE = "PORTAL_CONTEXT_STATE";
	
	public static final String VAR_ID_EMAIL_LIST = "EMAIL_LIST";
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a sms scheduler context model instance should use the {@link it.eng.allerta.sms.servlet.model.SmsSchedulerContext} interface instead.
	 */
	public SmsSchedulerContextImpl() {
	}
}