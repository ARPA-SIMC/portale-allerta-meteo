/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaRuoloPermessi;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaRuoloPermessi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaRuoloPermessiCacheModel
	implements CacheModel<RubricaRuoloPermessi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaRuoloPermessiCacheModel)) {
			return false;
		}

		RubricaRuoloPermessiCacheModel rubricaRuoloPermessiCacheModel =
			(RubricaRuoloPermessiCacheModel)object;

		if (rubricaRuoloPermessiPK.equals(
				rubricaRuoloPermessiCacheModel.rubricaRuoloPermessiPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rubricaRuoloPermessiPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{FK_ID_RUOLO=");
		sb.append(FK_ID_RUOLO);
		sb.append(", FK_ID_PERMESSO=");
		sb.append(FK_ID_PERMESSO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaRuoloPermessi toEntityModel() {
		RubricaRuoloPermessiImpl rubricaRuoloPermessiImpl =
			new RubricaRuoloPermessiImpl();

		rubricaRuoloPermessiImpl.setFK_ID_RUOLO(FK_ID_RUOLO);

		if (FK_ID_PERMESSO == null) {
			rubricaRuoloPermessiImpl.setFK_ID_PERMESSO("");
		}
		else {
			rubricaRuoloPermessiImpl.setFK_ID_PERMESSO(FK_ID_PERMESSO);
		}

		rubricaRuoloPermessiImpl.resetOriginalValues();

		return rubricaRuoloPermessiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		FK_ID_RUOLO = objectInput.readLong();
		FK_ID_PERMESSO = objectInput.readUTF();

		rubricaRuoloPermessiPK = new RubricaRuoloPermessiPK(
			FK_ID_RUOLO, FK_ID_PERMESSO);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(FK_ID_RUOLO);

		if (FK_ID_PERMESSO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FK_ID_PERMESSO);
		}
	}

	public long FK_ID_RUOLO;

	public String FK_ID_PERMESSO;

	public transient RubricaRuoloPermessiPK rubricaRuoloPermessiPK;

}