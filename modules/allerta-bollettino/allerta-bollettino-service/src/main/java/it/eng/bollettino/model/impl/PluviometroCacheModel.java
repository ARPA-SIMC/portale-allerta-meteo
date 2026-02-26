/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.Pluviometro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Pluviometro in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class PluviometroCacheModel
	implements CacheModel<Pluviometro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PluviometroCacheModel)) {
			return false;
		}

		PluviometroCacheModel pluviometroCacheModel =
			(PluviometroCacheModel)object;

		if (stazioneId.equals(pluviometroCacheModel.stazioneId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{stazioneId=");
		sb.append(stazioneId);
		sb.append(", nomeGruppo=");
		sb.append(nomeGruppo);
		sb.append(", nomeRubrica=");
		sb.append(nomeRubrica);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pluviometro toEntityModel() {
		PluviometroImpl pluviometroImpl = new PluviometroImpl();

		if (stazioneId == null) {
			pluviometroImpl.setStazioneId("");
		}
		else {
			pluviometroImpl.setStazioneId(stazioneId);
		}

		if (nomeGruppo == null) {
			pluviometroImpl.setNomeGruppo("");
		}
		else {
			pluviometroImpl.setNomeGruppo(nomeGruppo);
		}

		if (nomeRubrica == null) {
			pluviometroImpl.setNomeRubrica("");
		}
		else {
			pluviometroImpl.setNomeRubrica(nomeRubrica);
		}

		pluviometroImpl.resetOriginalValues();

		return pluviometroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stazioneId = objectInput.readUTF();
		nomeGruppo = objectInput.readUTF();
		nomeRubrica = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (stazioneId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stazioneId);
		}

		if (nomeGruppo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeGruppo);
		}

		if (nomeRubrica == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeRubrica);
		}
	}

	public String stazioneId;
	public String nomeGruppo;
	public String nomeRubrica;

}