/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.Idrometro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Idrometro in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class IdrometroCacheModel
	implements CacheModel<Idrometro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IdrometroCacheModel)) {
			return false;
		}

		IdrometroCacheModel idrometroCacheModel = (IdrometroCacheModel)object;

		if (stazioneId.equals(idrometroCacheModel.stazioneId)) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{stazioneId=");
		sb.append(stazioneId);
		sb.append(", nomeBacino=");
		sb.append(nomeBacino);
		sb.append(", nomeSottobacino=");
		sb.append(nomeSottobacino);
		sb.append(", nomeRubrica=");
		sb.append(nomeRubrica);
		sb.append(", sogliaSpike=");
		sb.append(sogliaSpike);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Idrometro toEntityModel() {
		IdrometroImpl idrometroImpl = new IdrometroImpl();

		if (stazioneId == null) {
			idrometroImpl.setStazioneId("");
		}
		else {
			idrometroImpl.setStazioneId(stazioneId);
		}

		if (nomeBacino == null) {
			idrometroImpl.setNomeBacino("");
		}
		else {
			idrometroImpl.setNomeBacino(nomeBacino);
		}

		if (nomeSottobacino == null) {
			idrometroImpl.setNomeSottobacino("");
		}
		else {
			idrometroImpl.setNomeSottobacino(nomeSottobacino);
		}

		if (nomeRubrica == null) {
			idrometroImpl.setNomeRubrica("");
		}
		else {
			idrometroImpl.setNomeRubrica(nomeRubrica);
		}

		idrometroImpl.setSogliaSpike(sogliaSpike);

		idrometroImpl.resetOriginalValues();

		return idrometroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stazioneId = objectInput.readUTF();
		nomeBacino = objectInput.readUTF();
		nomeSottobacino = objectInput.readUTF();
		nomeRubrica = objectInput.readUTF();

		sogliaSpike = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (stazioneId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stazioneId);
		}

		if (nomeBacino == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeBacino);
		}

		if (nomeSottobacino == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeSottobacino);
		}

		if (nomeRubrica == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeRubrica);
		}

		objectOutput.writeDouble(sogliaSpike);
	}

	public String stazioneId;
	public String nomeBacino;
	public String nomeSottobacino;
	public String nomeRubrica;
	public double sogliaSpike;

}