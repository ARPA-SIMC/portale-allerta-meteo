package it.eng.sms.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class EventiDisplayTerms extends DisplayTerms  {
	
	private String filtro;
	private String dataInvioDa;
	private String dataInvioA;

	public EventiDisplayTerms(PortletRequest portletRequest) {
		
		super(portletRequest);
		
		filtro =  ParamUtil.getString(portletRequest, "filtro");
		dataInvioDa = ParamUtil.getString( portletRequest, "dataInvioDa");
		dataInvioA = ParamUtil.getString( portletRequest, "dataInvioA");
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getDataInvioDa() {
		return dataInvioDa;
	}

	public void setDataInvioDa(String dataInvioDa) {
		this.dataInvioDa = dataInvioDa;
	}

	public String getDataInvioA() {
		return dataInvioA;
	}

	public void setDataInvioA(String dataInvioA) {
		this.dataInvioA = dataInvioA;
	}
	
	

}
