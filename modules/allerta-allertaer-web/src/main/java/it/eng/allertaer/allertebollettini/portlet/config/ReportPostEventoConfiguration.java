package it.eng.allertaer.allertebollettini.portlet.config;

import aQute.bnd.annotation.metatype.Meta; 

@Meta.OCD(id = "it.eng.allertaer.allertebollettini.portlet.configuration.ReportPostEvento") 
public interface ReportPostEventoConfiguration {

	@Meta.AD(required = false) 
	public String renderTypeItem();
	
}