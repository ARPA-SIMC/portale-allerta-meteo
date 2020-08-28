package it.eng.sms.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerta.messages.services.model.CounterSms;
import it.eng.allerta.messages.services.service.CounterSmsLocalServiceUtil;

public class SMSGrafico {
	
	private String lastMonthSms;
	private long totalSMS;
	private int daySMS;
	private static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private Date todayWithZeroTime;
	
	private Log _log = LogFactoryUtil.getLog(SMSGrafico.class);
	
	private String getDataSms(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -11);
		Date result = cal.getTime();
		
		List<CounterSms> findBydataBetween = CounterSmsLocalServiceUtil.findBydataGreather(result);
		Gson gson = new Gson();
		String json = gson.toJson(findBydataBetween);
		return json;
	}


	public String getLastMonthSms() {
	
		lastMonthSms = getDataSms();
		return lastMonthSms;
	}


	public void setLastMonthSms(String lastMonthSms) {
		this.lastMonthSms = lastMonthSms;
	}

	public Long getTotalSMS() {
		return CounterSmsLocalServiceUtil.getTotalSMS();
	}

	public int getDaySMS() {
		try {
			todayWithZeroTime = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		CounterSms smsSpeditiParziale = CounterSmsLocalServiceUtil.findBydata(todayWithZeroTime);
		daySMS = smsSpeditiParziale.getNumerosms();
		return daySMS;
	}
	
	
	//private CounterSmsLocalService _counterSmsService = AllertaTracker.getService(CounterSmsLocalService.class);

}
