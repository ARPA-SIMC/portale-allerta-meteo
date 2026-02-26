/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaRuoloRubrica;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaRuoloRubrica in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaRuoloRubricaCacheModel
	implements CacheModel<RubricaRuoloRubrica>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaRuoloRubricaCacheModel)) {
			return false;
		}

		RubricaRuoloRubricaCacheModel rubricaRuoloRubricaCacheModel =
			(RubricaRuoloRubricaCacheModel)object;

		if (ID_RUOLO == rubricaRuoloRubricaCacheModel.ID_RUOLO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_RUOLO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ID_RUOLO=");
		sb.append(ID_RUOLO);
		sb.append(", DESCRIZIONE=");
		sb.append(DESCRIZIONE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaRuoloRubrica toEntityModel() {
		RubricaRuoloRubricaImpl rubricaRuoloRubricaImpl =
			new RubricaRuoloRubricaImpl();

		rubricaRuoloRubricaImpl.setID_RUOLO(ID_RUOLO);

		if (DESCRIZIONE == null) {
			rubricaRuoloRubricaImpl.setDESCRIZIONE("");
		}
		else {
			rubricaRuoloRubricaImpl.setDESCRIZIONE(DESCRIZIONE);
		}

		rubricaRuoloRubricaImpl.resetOriginalValues();

		return rubricaRuoloRubricaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_RUOLO = objectInput.readLong();
		DESCRIZIONE = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_RUOLO);

		if (DESCRIZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DESCRIZIONE);
		}
	}

	public long ID_RUOLO;

	public String DESCRIZIONE;

}