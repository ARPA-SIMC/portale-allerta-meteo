package it.eng.allerter.allerta;

import java.util.Date;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaValanghe;

public class ListaAllerteValangheEntry {
	
	AllertaValanghe allertaValanghe;
	User compilatore;
	
	public ListaAllerteValangheEntry(AllertaValanghe allertaValanghe) {
		this.allertaValanghe = allertaValanghe;
		this.compilatore = UserLocalServiceUtil.fetchUser(allertaValanghe.getUserId());
	}

	public Date getUltimaData() {
		Date ultima = allertaValanghe.getCreateDate();
		
		if (allertaValanghe.getModifiedDate() != null && allertaValanghe.getModifiedDate().after(ultima))
			ultima = allertaValanghe.getModifiedDate();
		if (allertaValanghe.getDataFirmaArpa() != null && allertaValanghe.getDataFirmaArpa().after(ultima))
			ultima = allertaValanghe.getDataFirmaArpa();
		if (allertaValanghe.getDataFirmaProt() != null && allertaValanghe.getDataFirmaProt().after(ultima))
			ultima = allertaValanghe.getDataFirmaProt();
		
		return ultima;
	}

	public String getStato() {
		switch (allertaValanghe.getStato()) {
			case WorkflowConstants.STATUS_DRAFT:
				return "BOZZA";
			case WorkflowConstants.STATUS_PENDING:
				return "IN APPROVAZIONE ARPAE";	
			case 1000:
				return "IN APPROVAZIONE APC";
			case WorkflowConstants.STATUS_DENIED:
				return "RESPINTO";
		}

		return "";		
	}

	public AllertaValanghe getAllertaValanghe() {
		return allertaValanghe;
	}

	public void setAllertaValanghe(AllertaValanghe allertaValanghe) {
		this.allertaValanghe = allertaValanghe;
	}

	public User getCompilatore() {
		return compilatore;
	}

	public void setCompilatore(User compilatore) {
		this.compilatore = compilatore;
	}
}
