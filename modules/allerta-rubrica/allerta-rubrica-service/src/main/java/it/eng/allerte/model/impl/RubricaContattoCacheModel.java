/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaContatto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RubricaContatto in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaContattoCacheModel
	implements CacheModel<RubricaContatto>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaContattoCacheModel)) {
			return false;
		}

		RubricaContattoCacheModel rubricaContattoCacheModel =
			(RubricaContattoCacheModel)object;

		if (ID_CONTATTO == rubricaContattoCacheModel.ID_CONTATTO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_CONTATTO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ID_CONTATTO=");
		sb.append(ID_CONTATTO);
		sb.append(", FK_NOMINATIVO=");
		sb.append(FK_NOMINATIVO);
		sb.append(", FK_CANALE=");
		sb.append(FK_CANALE);
		sb.append(", CONTATTO=");
		sb.append(CONTATTO);
		sb.append(", ALLERTAMENTO=");
		sb.append(ALLERTAMENTO);
		sb.append(", FK_UTENTE_CREAZIONE=");
		sb.append(FK_UTENTE_CREAZIONE);
		sb.append(", DATA_CREAZIONE=");
		sb.append(DATA_CREAZIONE);
		sb.append(", FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);
		sb.append(", DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);
		sb.append(", DATA_FINE_VALIDITA=");
		sb.append(DATA_FINE_VALIDITA);
		sb.append(", MODIFICA_MINORE=");
		sb.append(MODIFICA_MINORE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaContatto toEntityModel() {
		RubricaContattoImpl rubricaContattoImpl = new RubricaContattoImpl();

		rubricaContattoImpl.setID_CONTATTO(ID_CONTATTO);
		rubricaContattoImpl.setFK_NOMINATIVO(FK_NOMINATIVO);
		rubricaContattoImpl.setFK_CANALE(FK_CANALE);

		if (CONTATTO == null) {
			rubricaContattoImpl.setCONTATTO("");
		}
		else {
			rubricaContattoImpl.setCONTATTO(CONTATTO);
		}

		rubricaContattoImpl.setALLERTAMENTO(ALLERTAMENTO);
		rubricaContattoImpl.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);

		if (DATA_CREAZIONE == Long.MIN_VALUE) {
			rubricaContattoImpl.setDATA_CREAZIONE(null);
		}
		else {
			rubricaContattoImpl.setDATA_CREAZIONE(new Date(DATA_CREAZIONE));
		}

		rubricaContattoImpl.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);

		if (DATA_MODIFICA == Long.MIN_VALUE) {
			rubricaContattoImpl.setDATA_MODIFICA(null);
		}
		else {
			rubricaContattoImpl.setDATA_MODIFICA(new Date(DATA_MODIFICA));
		}

		if (DATA_FINE_VALIDITA == Long.MIN_VALUE) {
			rubricaContattoImpl.setDATA_FINE_VALIDITA(null);
		}
		else {
			rubricaContattoImpl.setDATA_FINE_VALIDITA(
				new Date(DATA_FINE_VALIDITA));
		}

		rubricaContattoImpl.setMODIFICA_MINORE(MODIFICA_MINORE);

		rubricaContattoImpl.resetOriginalValues();

		return rubricaContattoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_CONTATTO = objectInput.readLong();

		FK_NOMINATIVO = objectInput.readLong();

		FK_CANALE = objectInput.readLong();
		CONTATTO = objectInput.readUTF();

		ALLERTAMENTO = objectInput.readBoolean();

		FK_UTENTE_CREAZIONE = objectInput.readLong();
		DATA_CREAZIONE = objectInput.readLong();

		FK_UTENTE_MODIFICA = objectInput.readLong();
		DATA_MODIFICA = objectInput.readLong();
		DATA_FINE_VALIDITA = objectInput.readLong();

		MODIFICA_MINORE = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_CONTATTO);

		objectOutput.writeLong(FK_NOMINATIVO);

		objectOutput.writeLong(FK_CANALE);

		if (CONTATTO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CONTATTO);
		}

		objectOutput.writeBoolean(ALLERTAMENTO);

		objectOutput.writeLong(FK_UTENTE_CREAZIONE);
		objectOutput.writeLong(DATA_CREAZIONE);

		objectOutput.writeLong(FK_UTENTE_MODIFICA);
		objectOutput.writeLong(DATA_MODIFICA);
		objectOutput.writeLong(DATA_FINE_VALIDITA);

		objectOutput.writeBoolean(MODIFICA_MINORE);
	}

	public long ID_CONTATTO;

	public long FK_NOMINATIVO;

	public long FK_CANALE;

	public String CONTATTO;

	public boolean ALLERTAMENTO;

	public long FK_UTENTE_CREAZIONE;

	public long DATA_CREAZIONE;

	public long FK_UTENTE_MODIFICA;

	public long DATA_MODIFICA;

	public long DATA_FINE_VALIDITA;

	public boolean MODIFICA_MINORE;

}