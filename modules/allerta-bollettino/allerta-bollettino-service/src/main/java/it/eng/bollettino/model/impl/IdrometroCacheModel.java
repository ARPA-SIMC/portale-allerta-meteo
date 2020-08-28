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
@ProviderType
public class IdrometroCacheModel
	implements CacheModel<Idrometro>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IdrometroCacheModel)) {
			return false;
		}

		IdrometroCacheModel idrometroCacheModel = (IdrometroCacheModel)obj;

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