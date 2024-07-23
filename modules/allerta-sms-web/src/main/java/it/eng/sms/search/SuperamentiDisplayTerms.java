package it.eng.sms.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class SuperamentiDisplayTerms extends DisplayTerms {
	
	private String dataDa;
	private String dataA;
	
	private String tipo;
	
	private String comune;
	private String provincia;
	private String bacino;
	private String stazione;
	private String zona;
	private String soglia;

	public SuperamentiDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		// TODO Auto-generated constructor stub
		tipo = ParamUtil.getString(portletRequest, "tipo");
		dataDa = ParamUtil.getString( portletRequest, "dataDa");
		dataA = ParamUtil.getString( portletRequest, "dataA");
		provincia = ParamUtil.getString(portletRequest, "provincia");
		comune = ParamUtil.getString(portletRequest, "comune");
		bacino = ParamUtil.getString(portletRequest, "bacino");
		stazione = ParamUtil.getString(portletRequest, "stazione");
		zona = ParamUtil.getString(portletRequest, "zona");
		soglia = ParamUtil.getString(portletRequest, "soglia");
		
	}

	public String getDataDa() {
		return dataDa;
	}

	public void setDataDa(String dataDa) {
		this.dataDa = dataDa;
	}

	public String getDataA() {
		return dataA;
	}

	public void setDataA(String dataA) {
		this.dataA = dataA;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getBacino() {
		return bacino;
	}

	public void setBacino(String bacino) {
		this.bacino = bacino;
	}

	public String getStazione() {
		return stazione;
	}

	public void setStazione(String stazione) {
		this.stazione = stazione;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSoglia() {
		return soglia;
	}

	public void setSoglia(String soglia) {
		this.soglia = soglia;
	}
	
	
	
	
	

}
