package it.eng.sms.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class SMSDisplayTerms extends DisplayTerms {
	
	private String tipo;
	private String sottoTipo;
	private String numero;
	private long stato;
	private String destinatario;
	
	private String dataInvioDa;
	private String dataInvioA;

	public SMSDisplayTerms(PortletRequest portletRequest) {
		
		super(portletRequest);
		
		tipo = ParamUtil.getString(portletRequest, "tipo");
		sottoTipo = ParamUtil.getString(portletRequest, "sottotipo");
		numero = ParamUtil.getString(portletRequest, "numero");
		stato = ParamUtil.getLong(portletRequest, "stato");
		destinatario =  ParamUtil.getString(portletRequest, "nome");
		dataInvioDa = ParamUtil.getString( portletRequest, "dataInvioDa");
		dataInvioA = ParamUtil.getString( portletRequest, "dataInvioA");
		
		//dataInvioDa = ParamUtil.getDate(portletRequest, "dataInvioDa", new SimpleDateFormat("yyyy-MM-dd HH:mm"));
		//dataInvioA = ParamUtil.getDate(portletRequest, "dataInvioDa",  new SimpleDateFormat("yyyy-MM-dd HH:mm"));
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSottoTipo() {
		return sottoTipo;
	}

	public void setSottoTipo(String sottoTipo) {
		this.sottoTipo = sottoTipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public long getStato() {
		return stato;
	}

	public void setStato(long stato) {
		this.stato = stato;
	}
	
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
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
