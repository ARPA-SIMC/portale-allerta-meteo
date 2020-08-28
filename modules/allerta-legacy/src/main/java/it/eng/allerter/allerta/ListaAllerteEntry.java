package it.eng.allerter.allerta;

import java.util.Date;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import it.eng.allerter.model.Allerta;

public class ListaAllerteEntry {
	
	Allerta allerta;
	User compilatore;
	
	public ListaAllerteEntry(Allerta a) {
		this.allerta = a;
		this.compilatore = UserLocalServiceUtil.fetchUser(a.getUserId());
	}

	public Date getUltimaData() {
		Date ultima = null;
		ultima = allerta.getCreateDate();
		if (allerta.getModifiedDate() != null && allerta.getModifiedDate().after(ultima))
			ultima = allerta.getModifiedDate();
		if (allerta.getDataFirmaArpa() != null && allerta.getDataFirmaArpa().after(ultima))
			ultima = allerta.getDataFirmaArpa();
		if (allerta.getDataFirmaProt() != null && allerta.getDataFirmaProt().after(ultima))
			ultima = allerta.getDataFirmaProt();
		return ultima;
	}

	public String getStato() {
		switch (allerta.getStato()) {
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

	public Allerta getAllerta() {
		return allerta;
	}

	public void setAllerta(Allerta allerta) {
		this.allerta = allerta;
	}

	public User getCompilatore() {
		return compilatore;
	}

	public void setCompilatore(User compilatore) {
		this.compilatore = compilatore;
	}


}
