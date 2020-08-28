/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.bollettino.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class PluviometroCacheModel
	implements CacheModel<Pluviometro>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PluviometroCacheModel)) {
			return false;
		}

		PluviometroCacheModel pluviometroCacheModel =
			(PluviometroCacheModel)obj;

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