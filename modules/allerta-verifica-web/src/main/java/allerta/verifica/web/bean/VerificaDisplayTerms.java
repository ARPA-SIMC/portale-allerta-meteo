package allerta.verifica.web.bean;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class VerificaDisplayTerms extends DisplayTerms {
	
	private String dataDa;
	private String dataA;
	
	public VerificaDisplayTerms(PortletRequest portletRequest) {
		
		super(portletRequest);
		dataDa = ParamUtil.getString( portletRequest, "dataInvioDa");
		dataA = ParamUtil.getString( portletRequest, "dataInvioA");
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

	
}
