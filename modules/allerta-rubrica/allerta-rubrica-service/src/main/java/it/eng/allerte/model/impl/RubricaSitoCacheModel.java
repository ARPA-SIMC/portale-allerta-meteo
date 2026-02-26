/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaSito;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaSito in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaSitoCacheModel
	implements CacheModel<RubricaSito>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaSitoCacheModel)) {
			return false;
		}

		RubricaSitoCacheModel rubricaSitoCacheModel =
			(RubricaSitoCacheModel)object;

		if (ID_SITO == rubricaSitoCacheModel.ID_SITO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_SITO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ID_SITO=");
		sb.append(ID_SITO);
		sb.append(", NOME=");
		sb.append(NOME);
		sb.append(", FK_LIFERAY_SITE=");
		sb.append(FK_LIFERAY_SITE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaSito toEntityModel() {
		RubricaSitoImpl rubricaSitoImpl = new RubricaSitoImpl();

		rubricaSitoImpl.setID_SITO(ID_SITO);

		if (NOME == null) {
			rubricaSitoImpl.setNOME("");
		}
		else {
			rubricaSitoImpl.setNOME(NOME);
		}

		rubricaSitoImpl.setFK_LIFERAY_SITE(FK_LIFERAY_SITE);

		rubricaSitoImpl.resetOriginalValues();

		return rubricaSitoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_SITO = objectInput.readLong();
		NOME = objectInput.readUTF();

		FK_LIFERAY_SITE = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_SITO);

		if (NOME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME);
		}

		objectOutput.writeLong(FK_LIFERAY_SITE);
	}

	public long ID_SITO;

	public String NOME;

	public long FK_LIFERAY_SITE;

}