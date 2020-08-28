package it.eng.allerter.allerta.utils;

import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.portal.kernel.model.User;

/**
 * This is an enumeration of attributes that fortify/enhance the Liferay User entity.
 *
 */
public enum UserExpando {

	
	CODICE_FICALE("cf"),ROLE("ruolo"),SERVICE("servizio"),ENDOFTERMS("scadenza_utente");
     
	// Private Constants
	private static final String MODEL_CLASS_NAME = User.class.getName();

	// Private Data Members
	private int expandoType;
	private boolean indexable;
	private String name;

	private UserExpando(String name) {
		this(name, ExpandoColumnConstants.STRING, true);
	}

	private UserExpando(String name, int expandoType, boolean indexable) {
		this.name = name;
		this.expandoType = expandoType;
		this.indexable = indexable;
	}

	public boolean isIndexable() {
		return indexable;
	}

	public int getExpandoType() {
		return expandoType;
	}

	public String getModelClassName() {
		return MODEL_CLASS_NAME;
	}

	public String getName() {
		return name;
	}
}
