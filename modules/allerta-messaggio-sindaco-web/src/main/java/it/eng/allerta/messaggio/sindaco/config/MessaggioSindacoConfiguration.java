package it.eng.allerta.messaggio.sindaco.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "allerta-meteo",
		scope = ExtendedObjectClassDefinition.Scope.COMPANY
	)
@Meta.OCD(
		id = "it.eng.allerta.messaggio.sindaco.config.MessaggioSindacoConfiguration"
		)
public interface MessaggioSindacoConfiguration {

	@Meta.AD(required = false)
    public String[] organization();
 
	@Meta.AD(required = false)
    public String canaleSms();
 
	@Meta.AD(required = false)
    public String canaleSmsSindaco();
 
	@Meta.AD(required = false)
    public String canaleSocial();
 	
	@Meta.AD(required = false)
    public String canaleTelefonico();
 
	@Meta.AD(required = false)
    public String canaleMail();
 
	@Meta.AD(required = false)
    public String canalePortale();
 
	@Meta.AD(required = false)
    public String paginaPieneFiumi();
 
	@Meta.AD(required = false)
    public String paginaFrane();
 
	@Meta.AD(required = false)
    public String paginaTemporali();
	
	@Meta.AD(required = false)
    public String paginaVento();
	
	@Meta.AD(required = false)
    public String paginaMareggiate();
	
	@Meta.AD(required = false)
    public String paginaNeve();
	
	@Meta.AD(required = false)
    public String paginaGhiaccio();
	
	@Meta.AD(required = false)
    public String paginaOndateCalore();
	
	@Meta.AD(required = false)
    public String paginaIncendio();
	
	@Meta.AD(required = false)
    public String paginaTerremoto();
	
	
}

