/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaRuolo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaRuolo in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaRuoloCacheModel
	implements CacheModel<RubricaRuolo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaRuoloCacheModel)) {
			return false;
		}

		RubricaRuoloCacheModel rubricaRuoloCacheModel =
			(RubricaRuoloCacheModel)object;

		if (ID_RUOLO == rubricaRuoloCacheModel.ID_RUOLO) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{ID_RUOLO=");
		sb.append(ID_RUOLO);
		sb.append(", DESCRIZIONE=");
		sb.append(DESCRIZIONE);
		sb.append(", FK_RUOLO_LIFERAY=");
		sb.append(FK_RUOLO_LIFERAY);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaRuolo toEntityModel() {
		RubricaRuoloImpl rubricaRuoloImpl = new RubricaRuoloImpl();

		rubricaRuoloImpl.setID_RUOLO(ID_RUOLO);

		if (DESCRIZIONE == null) {
			rubricaRuoloImpl.setDESCRIZIONE("");
		}
		else {
			rubricaRuoloImpl.setDESCRIZIONE(DESCRIZIONE);
		}

		rubricaRuoloImpl.setFK_RUOLO_LIFERAY(FK_RUOLO_LIFERAY);

		rubricaRuoloImpl.resetOriginalValues();

		return rubricaRuoloImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_RUOLO = objectInput.readLong();
		DESCRIZIONE = objectInput.readUTF();

		FK_RUOLO_LIFERAY = objectInput.readLong();
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

		objectOutput.writeLong(FK_RUOLO_LIFERAY);
	}

	public long ID_RUOLO;

	public String DESCRIZIONE;

	public long FK_RUOLO_LIFERAY;

}