package it.eng.allertaer.cruscotto.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletRequest;

public class CruscottoDisplayTerms extends DisplayTerms {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private String da;
	private String a;
	
	public CruscottoDisplayTerms(PortletRequest portletRequest) {
		
		super(portletRequest);
		da = ParamUtil.getString( portletRequest, "da");
		a = ParamUtil.getString( portletRequest, "a");
		
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	public Date getDataDa() {
		try {
			if (da!=null) return sdf.parse(da); else return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Date getDataA() {
		try {
			if (a!=null) return sdf.parse(a); else return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
