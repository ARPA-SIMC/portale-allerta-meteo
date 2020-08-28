package it.eng.parer.xmlGen.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.parer.service.ParametriLocalServiceUtil;

public class ConstansUtil {
	private static Log logger = LogFactoryUtil.getLog(ConstansUtil.class);

	//VERSATORE CONSTANTS
	public static String AMBIENTE;
	//public static final String AMBIENTE_PROD = "PARER";

	public static String VERSATORE_ALLERTA_USER_ID_PROT_CIVILE;
	public static String VERSATORE_ALLERTA_USER_ID_ARPA;

	public static String VERSATORE_PASS_PROT_CIV;
	public static String VERSATORE_PASS_ARPA;

	//URL INVIO
	public static String URL_PARER;

	static{
		try {
			AMBIENTE = ParametriLocalServiceUtil.fetchParametri("AMBIENTE").getValore();
			VERSATORE_ALLERTA_USER_ID_PROT_CIVILE = ParametriLocalServiceUtil.fetchParametri("VERSATORE_ALLERTA_USER_ID").getValore();
			VERSATORE_ALLERTA_USER_ID_ARPA = ParametriLocalServiceUtil.fetchParametri("VERSATORE_ALLERTA_USER_ID").getValore();
			VERSATORE_PASS_PROT_CIV = ParametriLocalServiceUtil.fetchParametri("VERSATORE_PASS").getValore();
			VERSATORE_PASS_ARPA = ParametriLocalServiceUtil.fetchParametri("VERSATORE_PASS").getValore();
			URL_PARER = ParametriLocalServiceUtil.fetchParametri("URL_PARER").getValore();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(),e);
		}
	}

}
