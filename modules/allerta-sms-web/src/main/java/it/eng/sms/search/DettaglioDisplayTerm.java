package it.eng.sms.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

public class DettaglioDisplayTerm extends DisplayTerms {
	
	private String id;
	private String filtro;
	private String failed;
	private String evento;
	private String backTo;

	public DettaglioDisplayTerm(PortletRequest portletRequest) {
		
		super(portletRequest);
		
		filtro =  ParamUtil.getString(portletRequest, "filtro");
		failed = ParamUtil.getString( portletRequest, "failed");
		id = ParamUtil.getString( portletRequest, "id");
		evento = ParamUtil.getString( portletRequest, "evt");
		backTo = ParamUtil.getString( portletRequest, "backTo");
		
		if( Validator.isNull(id))
			id = PortalUtil
					.getOriginalServletRequest(
							PortalUtil.getHttpServletRequest(portletRequest))
								.getParameter("id");
		
		if( Validator.isNull(evento))
			evento = PortalUtil
					.getOriginalServletRequest(
							PortalUtil.getHttpServletRequest(portletRequest))
								.getParameter("evt");
		
		if( Validator.isNull(backTo))
			backTo = PortalUtil
					.getOriginalServletRequest(
							PortalUtil.getHttpServletRequest(portletRequest))
								.getParameter("backTo");
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getFailed() {
		return failed;
	}

	public void setFailed(String failed) {
		this.failed = failed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	
}
