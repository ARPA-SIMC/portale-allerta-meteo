package it.eng.sms.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletRequest;

public class CittadiniDisplayTerms extends DisplayTerms {

	Long userId;
	String comune;
	String cognome;
	String nome;
	String email;
	String tel;
	
	public CittadiniDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		// TODO Auto-generated constructor stub
		userId = PortalUtil.getUserId(portletRequest);
		comune = ParamUtil.getString(portletRequest, "comune");
		cognome = ParamUtil.getString(portletRequest, "cognome");
		nome = ParamUtil.getString(portletRequest, "nome");
		email = ParamUtil.getString(portletRequest, "email");
		tel = ParamUtil.getString(portletRequest, "tel");
		
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
