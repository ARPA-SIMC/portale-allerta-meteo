/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaGruppoNominativi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaGruppoNominativiCacheModel
	implements CacheModel<RubricaGruppoNominativi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaGruppoNominativiCacheModel)) {
			return false;
		}

		RubricaGruppoNominativiCacheModel rubricaGruppoNominativiCacheModel =
			(RubricaGruppoNominativiCacheModel)object;

		if (rubricaGruppoNominativiPK.equals(
				rubricaGruppoNominativiCacheModel.rubricaGruppoNominativiPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rubricaGruppoNominativiPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{FK_GRUPPO=");
		sb.append(FK_GRUPPO);
		sb.append(", FK_NOMINATIVO=");
		sb.append(FK_NOMINATIVO);
		sb.append(", FK_RUOLO=");
		sb.append(FK_RUOLO);
		sb.append(", SPECIFICA_RUOLO=");
		sb.append(SPECIFICA_RUOLO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaGruppoNominativi toEntityModel() {
		RubricaGruppoNominativiImpl rubricaGruppoNominativiImpl =
			new RubricaGruppoNominativiImpl();

		rubricaGruppoNominativiImpl.setFK_GRUPPO(FK_GRUPPO);
		rubricaGruppoNominativiImpl.setFK_NOMINATIVO(FK_NOMINATIVO);
		rubricaGruppoNominativiImpl.setFK_RUOLO(FK_RUOLO);

		if (SPECIFICA_RUOLO == null) {
			rubricaGruppoNominativiImpl.setSPECIFICA_RUOLO("");
		}
		else {
			rubricaGruppoNominativiImpl.setSPECIFICA_RUOLO(SPECIFICA_RUOLO);
		}

		rubricaGruppoNominativiImpl.resetOriginalValues();

		return rubricaGruppoNominativiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		FK_GRUPPO = objectInput.readLong();

		FK_NOMINATIVO = objectInput.readLong();

		FK_RUOLO = objectInput.readLong();
		SPECIFICA_RUOLO = objectInput.readUTF();

		rubricaGruppoNominativiPK = new RubricaGruppoNominativiPK(
			FK_GRUPPO, FK_NOMINATIVO);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(FK_GRUPPO);

		objectOutput.writeLong(FK_NOMINATIVO);

		objectOutput.writeLong(FK_RUOLO);

		if (SPECIFICA_RUOLO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SPECIFICA_RUOLO);
		}
	}

	public long FK_GRUPPO;

	public long FK_NOMINATIVO;

	public long FK_RUOLO;

	public String SPECIFICA_RUOLO;

	public transient RubricaGruppoNominativiPK rubricaGruppoNominativiPK;

}