package it.eng.allerter.allerta;

import java.util.Date;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import it.eng.allerter.model.Allerta;
import it.eng.bollettino.model.Bollettino;

public class ListaBollettiniEntry {

	Bollettino bollettino;
	User compilatore;
	
	public ListaBollettiniEntry(Bollettino b) {
		this.bollettino = b;
		this.compilatore = UserLocalServiceUtil.fetchUser(b.getUserId());
	}
	
	public ListaBollettiniEntry() {
		
	}


	public Date getUltimaData() {
		Date ultima = null;
		ultima = bollettino.getCreateDate();
		if (bollettino.getModifiedDate()!=null && bollettino.getModifiedDate().after(ultima)) ultima = bollettino.getModifiedDate();
		if (bollettino.getDataApprovazione()!=null && bollettino.getDataApprovazione().after(ultima)) ultima = bollettino.getDataApprovazione();
		return ultima;
	}
	
	public String getStato() {
		switch (bollettino.getStato()) {
		case WorkflowConstants.STATUS_DRAFT: return "BOZZA";
		case WorkflowConstants.STATUS_PENDING:
			return "IN APPROVAZIONE";
		case WorkflowConstants.STATUS_DENIED:
			return "RESPINTO";
		}
		
		return "";
	}

	public Bollettino getAllerta() {
		return bollettino;
	}


	public void setAllerta(Bollettino bollettino) {
		this.bollettino = bollettino;

	}

	public User getCompilatore() {
		return compilatore;
	}

	public void setCompilatore(User compilatore) {
		this.compilatore = compilatore;
	}
	
}
