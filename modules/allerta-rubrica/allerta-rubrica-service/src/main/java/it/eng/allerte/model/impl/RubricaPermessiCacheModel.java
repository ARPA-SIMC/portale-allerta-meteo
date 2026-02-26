/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaPermessi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaPermessi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaPermessiCacheModel
	implements CacheModel<RubricaPermessi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaPermessiCacheModel)) {
			return false;
		}

		RubricaPermessiCacheModel rubricaPermessiCacheModel =
			(RubricaPermessiCacheModel)object;

		if (ID_PERMESSO.equals(rubricaPermessiCacheModel.ID_PERMESSO)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_PERMESSO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ID_PERMESSO=");
		sb.append(ID_PERMESSO);
		sb.append(", NOME_PERMESSO=");
		sb.append(NOME_PERMESSO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaPermessi toEntityModel() {
		RubricaPermessiImpl rubricaPermessiImpl = new RubricaPermessiImpl();

		if (ID_PERMESSO == null) {
			rubricaPermessiImpl.setID_PERMESSO("");
		}
		else {
			rubricaPermessiImpl.setID_PERMESSO(ID_PERMESSO);
		}

		if (NOME_PERMESSO == null) {
			rubricaPermessiImpl.setNOME_PERMESSO("");
		}
		else {
			rubricaPermessiImpl.setNOME_PERMESSO(NOME_PERMESSO);
		}

		rubricaPermessiImpl.resetOriginalValues();

		return rubricaPermessiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_PERMESSO = objectInput.readUTF();
		NOME_PERMESSO = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (ID_PERMESSO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ID_PERMESSO);
		}

		if (NOME_PERMESSO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME_PERMESSO);
		}
	}

	public String ID_PERMESSO;

	public String NOME_PERMESSO;

}