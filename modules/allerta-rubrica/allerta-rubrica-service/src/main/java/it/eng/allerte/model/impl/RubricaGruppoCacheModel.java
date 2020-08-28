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

import it.eng.allerte.model.RubricaGruppo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RubricaGruppo in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoCacheModel
	implements CacheModel<RubricaGruppo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaGruppoCacheModel)) {
			return false;
		}

		RubricaGruppoCacheModel rubricaGruppoCacheModel =
			(RubricaGruppoCacheModel)obj;

		if (ID_GRUPPO == rubricaGruppoCacheModel.ID_GRUPPO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_GRUPPO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ID_GRUPPO=");
		sb.append(ID_GRUPPO);
		sb.append(", NOME=");
		sb.append(NOME);
		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);
		sb.append(", NOTE=");
		sb.append(NOTE);
		sb.append(", FK_UTENTE_CREAZIONE=");
		sb.append(FK_UTENTE_CREAZIONE);
		sb.append(", DATA_CREAZIONE=");
		sb.append(DATA_CREAZIONE);
		sb.append(", FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);
		sb.append(", DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);
		sb.append(", DISABLED=");
		sb.append(DISABLED);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaGruppo toEntityModel() {
		RubricaGruppoImpl rubricaGruppoImpl = new RubricaGruppoImpl();

		rubricaGruppoImpl.setID_GRUPPO(ID_GRUPPO);

		if (NOME == null) {
			rubricaGruppoImpl.setNOME("");
		}
		else {
			rubricaGruppoImpl.setNOME(NOME);
		}

		rubricaGruppoImpl.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);

		if (NOTE == null) {
			rubricaGruppoImpl.setNOTE("");
		}
		else {
			rubricaGruppoImpl.setNOTE(NOTE);
		}

		rubricaGruppoImpl.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);

		if (DATA_CREAZIONE == Long.MIN_VALUE) {
			rubricaGruppoImpl.setDATA_CREAZIONE(null);
		}
		else {
			rubricaGruppoImpl.setDATA_CREAZIONE(new Date(DATA_CREAZIONE));
		}

		rubricaGruppoImpl.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);

		if (DATA_MODIFICA == Long.MIN_VALUE) {
			rubricaGruppoImpl.setDATA_MODIFICA(null);
		}
		else {
			rubricaGruppoImpl.setDATA_MODIFICA(new Date(DATA_MODIFICA));
		}

		rubricaGruppoImpl.setDISABLED(DISABLED);

		rubricaGruppoImpl.resetOriginalValues();

		return rubricaGruppoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_GRUPPO = objectInput.readLong();
		NOME = objectInput.readUTF();

		FK_SITO_PROPRIETARIO = objectInput.readLong();
		NOTE = objectInput.readUTF();

		FK_UTENTE_CREAZIONE = objectInput.readLong();
		DATA_CREAZIONE = objectInput.readLong();

		FK_UTENTE_MODIFICA = objectInput.readLong();
		DATA_MODIFICA = objectInput.readLong();

		DISABLED = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_GRUPPO);

		if (NOME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME);
		}

		objectOutput.writeLong(FK_SITO_PROPRIETARIO);

		if (NOTE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOTE);
		}

		objectOutput.writeLong(FK_UTENTE_CREAZIONE);
		objectOutput.writeLong(DATA_CREAZIONE);

		objectOutput.writeLong(FK_UTENTE_MODIFICA);
		objectOutput.writeLong(DATA_MODIFICA);

		objectOutput.writeBoolean(DISABLED);
	}

	public long ID_GRUPPO;

	public String NOME;

	public long FK_SITO_PROPRIETARIO;

	public String NOTE;

	public long FK_UTENTE_CREAZIONE;

	public long DATA_CREAZIONE;

	public long FK_UTENTE_MODIFICA;

	public long DATA_MODIFICA;

	public boolean DISABLED;

}