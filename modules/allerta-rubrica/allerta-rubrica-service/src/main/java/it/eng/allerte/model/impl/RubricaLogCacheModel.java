/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerte.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerte.model.RubricaLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RubricaLog in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaLogCacheModel
	implements CacheModel<RubricaLog>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaLogCacheModel)) {
			return false;
		}

		RubricaLogCacheModel rubricaLogCacheModel = (RubricaLogCacheModel)obj;

		if (ID_LOG == rubricaLogCacheModel.ID_LOG) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_LOG);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ID_LOG=");
		sb.append(ID_LOG);
		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);
		sb.append(", TABELLA=");
		sb.append(TABELLA);
		sb.append(", TIPO_OPERAZIONE=");
		sb.append(TIPO_OPERAZIONE);
		sb.append(", ID_OGGETTO=");
		sb.append(ID_OGGETTO);
		sb.append(", NUOVA_DESCRIZIONE=");
		sb.append(NUOVA_DESCRIZIONE);
		sb.append(", FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);
		sb.append(", DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaLog toEntityModel() {
		RubricaLogImpl rubricaLogImpl = new RubricaLogImpl();

		rubricaLogImpl.setID_LOG(ID_LOG);
		rubricaLogImpl.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);

		if (TABELLA == null) {
			rubricaLogImpl.setTABELLA("");
		}
		else {
			rubricaLogImpl.setTABELLA(TABELLA);
		}

		if (TIPO_OPERAZIONE == null) {
			rubricaLogImpl.setTIPO_OPERAZIONE("");
		}
		else {
			rubricaLogImpl.setTIPO_OPERAZIONE(TIPO_OPERAZIONE);
		}

		if (ID_OGGETTO == null) {
			rubricaLogImpl.setID_OGGETTO("");
		}
		else {
			rubricaLogImpl.setID_OGGETTO(ID_OGGETTO);
		}

		if (NUOVA_DESCRIZIONE == null) {
			rubricaLogImpl.setNUOVA_DESCRIZIONE("");
		}
		else {
			rubricaLogImpl.setNUOVA_DESCRIZIONE(NUOVA_DESCRIZIONE);
		}

		rubricaLogImpl.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);

		if (DATA_MODIFICA == Long.MIN_VALUE) {
			rubricaLogImpl.setDATA_MODIFICA(null);
		}
		else {
			rubricaLogImpl.setDATA_MODIFICA(new Date(DATA_MODIFICA));
		}

		rubricaLogImpl.resetOriginalValues();

		return rubricaLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_LOG = objectInput.readLong();

		FK_SITO_PROPRIETARIO = objectInput.readLong();
		TABELLA = objectInput.readUTF();
		TIPO_OPERAZIONE = objectInput.readUTF();
		ID_OGGETTO = objectInput.readUTF();
		NUOVA_DESCRIZIONE = objectInput.readUTF();

		FK_UTENTE_MODIFICA = objectInput.readLong();
		DATA_MODIFICA = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_LOG);

		objectOutput.writeLong(FK_SITO_PROPRIETARIO);

		if (TABELLA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TABELLA);
		}

		if (TIPO_OPERAZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPO_OPERAZIONE);
		}

		if (ID_OGGETTO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ID_OGGETTO);
		}

		if (NUOVA_DESCRIZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NUOVA_DESCRIZIONE);
		}

		objectOutput.writeLong(FK_UTENTE_MODIFICA);
		objectOutput.writeLong(DATA_MODIFICA);
	}

	public long ID_LOG;

	public long FK_SITO_PROPRIETARIO;

	public String TABELLA;

	public String TIPO_OPERAZIONE;

	public String ID_OGGETTO;

	public String NUOVA_DESCRIZIONE;

	public long FK_UTENTE_MODIFICA;

	public long DATA_MODIFICA;

}