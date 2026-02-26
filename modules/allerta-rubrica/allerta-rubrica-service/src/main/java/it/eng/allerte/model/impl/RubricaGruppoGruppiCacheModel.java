/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaGruppoGruppi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaGruppoGruppiCacheModel
	implements CacheModel<RubricaGruppoGruppi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaGruppoGruppiCacheModel)) {
			return false;
		}

		RubricaGruppoGruppiCacheModel rubricaGruppoGruppiCacheModel =
			(RubricaGruppoGruppiCacheModel)object;

		if (rubricaGruppoGruppiPK.equals(
				rubricaGruppoGruppiCacheModel.rubricaGruppoGruppiPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rubricaGruppoGruppiPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{FK_GRUPPO_PADRE=");
		sb.append(FK_GRUPPO_PADRE);
		sb.append(", FK_GRUPPO_FIGLIO=");
		sb.append(FK_GRUPPO_FIGLIO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaGruppoGruppi toEntityModel() {
		RubricaGruppoGruppiImpl rubricaGruppoGruppiImpl =
			new RubricaGruppoGruppiImpl();

		rubricaGruppoGruppiImpl.setFK_GRUPPO_PADRE(FK_GRUPPO_PADRE);
		rubricaGruppoGruppiImpl.setFK_GRUPPO_FIGLIO(FK_GRUPPO_FIGLIO);

		rubricaGruppoGruppiImpl.resetOriginalValues();

		return rubricaGruppoGruppiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		FK_GRUPPO_PADRE = objectInput.readLong();

		FK_GRUPPO_FIGLIO = objectInput.readLong();

		rubricaGruppoGruppiPK = new RubricaGruppoGruppiPK(
			FK_GRUPPO_PADRE, FK_GRUPPO_FIGLIO);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(FK_GRUPPO_PADRE);

		objectOutput.writeLong(FK_GRUPPO_FIGLIO);
	}

	public long FK_GRUPPO_PADRE;

	public long FK_GRUPPO_FIGLIO;

	public transient RubricaGruppoGruppiPK rubricaGruppoGruppiPK;

}