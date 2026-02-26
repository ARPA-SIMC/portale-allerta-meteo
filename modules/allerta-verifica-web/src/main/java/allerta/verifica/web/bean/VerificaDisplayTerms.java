package allerta.verifica.web.bean;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class VerificaDisplayTerms extends DisplayTerms {
	
	private String dataDa;
	private String dataA;
	private String zona;
	private String evento;
	private String correttezza;
	private String magnitudo;
	private String localizzazione;
	private String colorePre;
	private String colorePost;

	
	public VerificaDisplayTerms(PortletRequest portletRequest) {
		
		super(portletRequest);
		dataDa = ParamUtil.getString( portletRequest, "dataInvioDa");
		dataA = ParamUtil.getString( portletRequest, "dataInvioA");
		zona = ParamUtil.getString( portletRequest, "zona");
		evento = ParamUtil.getString( portletRequest, "evento");
		correttezza = ParamUtil.getString( portletRequest, "correttezza");
		magnitudo = ParamUtil.getString( portletRequest, "magnitudo");
		localizzazione = ParamUtil.getString( portletRequest, "localizzazione");
		colorePre = ParamUtil.getString( portletRequest, "colorePre");
		colorePost = ParamUtil.getString( portletRequest, "colorePost");

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

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getCorrettezza() {
		return correttezza;
	}

	public void setCorrettezza(String correttezza) {
		this.correttezza = correttezza;
	}

	public String getMagnitudo() {
		return magnitudo;
	}

	public void setMagnitudo(String magnitudo) {
		this.magnitudo = magnitudo;
	}

	public String getLocalizzazione() {
		return localizzazione;
	}

	public void setLocalizzazione(String localizzazione) {
		this.localizzazione = localizzazione;
	}

	public String getColorePre() {
		return colorePre;
	}

	public void setColorePre(String colorePre) {
		this.colorePre = colorePre;
	}

	public String getColorePost() {
		return colorePost;
	}

	public void setColorePost(String colorePost) {
		this.colorePost = colorePost;
	}

}
