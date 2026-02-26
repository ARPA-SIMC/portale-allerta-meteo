/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaNominativo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RubricaNominativo in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaNominativoCacheModel
	implements CacheModel<RubricaNominativo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaNominativoCacheModel)) {
			return false;
		}

		RubricaNominativoCacheModel rubricaNominativoCacheModel =
			(RubricaNominativoCacheModel)object;

		if (ID_NOMINATIVO == rubricaNominativoCacheModel.ID_NOMINATIVO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_NOMINATIVO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{ID_NOMINATIVO=");
		sb.append(ID_NOMINATIVO);
		sb.append(", COGNOME=");
		sb.append(COGNOME);
		sb.append(", NOME=");
		sb.append(NOME);
		sb.append(", INDIRIZZO=");
		sb.append(INDIRIZZO);
		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);
		sb.append(", FK_UTENTE_PORTALE=");
		sb.append(FK_UTENTE_PORTALE);
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
		sb.append(", MODIFICA_MINORE=");
		sb.append(MODIFICA_MINORE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaNominativo toEntityModel() {
		RubricaNominativoImpl rubricaNominativoImpl =
			new RubricaNominativoImpl();

		rubricaNominativoImpl.setID_NOMINATIVO(ID_NOMINATIVO);

		if (COGNOME == null) {
			rubricaNominativoImpl.setCOGNOME("");
		}
		else {
			rubricaNominativoImpl.setCOGNOME(COGNOME);
		}

		if (NOME == null) {
			rubricaNominativoImpl.setNOME("");
		}
		else {
			rubricaNominativoImpl.setNOME(NOME);
		}

		if (INDIRIZZO == null) {
			rubricaNominativoImpl.setINDIRIZZO("");
		}
		else {
			rubricaNominativoImpl.setINDIRIZZO(INDIRIZZO);
		}

		rubricaNominativoImpl.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
		rubricaNominativoImpl.setFK_UTENTE_PORTALE(FK_UTENTE_PORTALE);
		rubricaNominativoImpl.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);

		if (DATA_CREAZIONE == Long.MIN_VALUE) {
			rubricaNominativoImpl.setDATA_CREAZIONE(null);
		}
		else {
			rubricaNominativoImpl.setDATA_CREAZIONE(new Date(DATA_CREAZIONE));
		}

		rubricaNominativoImpl.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);

		if (DATA_MODIFICA == Long.MIN_VALUE) {
			rubricaNominativoImpl.setDATA_MODIFICA(null);
		}
		else {
			rubricaNominativoImpl.setDATA_MODIFICA(new Date(DATA_MODIFICA));
		}

		rubricaNominativoImpl.setDISABLED(DISABLED);
		rubricaNominativoImpl.setMODIFICA_MINORE(MODIFICA_MINORE);

		rubricaNominativoImpl.resetOriginalValues();

		return rubricaNominativoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_NOMINATIVO = objectInput.readLong();
		COGNOME = objectInput.readUTF();
		NOME = objectInput.readUTF();
		INDIRIZZO = objectInput.readUTF();

		FK_SITO_PROPRIETARIO = objectInput.readLong();

		FK_UTENTE_PORTALE = objectInput.readLong();

		FK_UTENTE_CREAZIONE = objectInput.readLong();
		DATA_CREAZIONE = objectInput.readLong();

		FK_UTENTE_MODIFICA = objectInput.readLong();
		DATA_MODIFICA = objectInput.readLong();

		DISABLED = objectInput.readBoolean();

		MODIFICA_MINORE = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_NOMINATIVO);

		if (COGNOME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COGNOME);
		}

		if (NOME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME);
		}

		if (INDIRIZZO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(INDIRIZZO);
		}

		objectOutput.writeLong(FK_SITO_PROPRIETARIO);

		objectOutput.writeLong(FK_UTENTE_PORTALE);

		objectOutput.writeLong(FK_UTENTE_CREAZIONE);
		objectOutput.writeLong(DATA_CREAZIONE);

		objectOutput.writeLong(FK_UTENTE_MODIFICA);
		objectOutput.writeLong(DATA_MODIFICA);

		objectOutput.writeBoolean(DISABLED);

		objectOutput.writeBoolean(MODIFICA_MINORE);
	}

	public long ID_NOMINATIVO;

	public String COGNOME;

	public String NOME;

	public String INDIRIZZO;

	public long FK_SITO_PROPRIETARIO;

	public long FK_UTENTE_PORTALE;

	public long FK_UTENTE_CREAZIONE;

	public long DATA_CREAZIONE;

	public long FK_UTENTE_MODIFICA;

	public long DATA_MODIFICA;

	public boolean DISABLED;

	public boolean MODIFICA_MINORE;

}