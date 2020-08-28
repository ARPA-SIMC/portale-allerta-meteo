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

package it.eng.allerte.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerte.model.RubricaCanale;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaCanale in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaCanaleCacheModel
	implements CacheModel<RubricaCanale>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaCanaleCacheModel)) {
			return false;
		}

		RubricaCanaleCacheModel rubricaCanaleCacheModel =
			(RubricaCanaleCacheModel)obj;

		if (ID_CANALE == rubricaCanaleCacheModel.ID_CANALE) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_CANALE);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID_CANALE=");
		sb.append(ID_CANALE);
		sb.append(", NOME=");
		sb.append(NOME);
		sb.append(", ICONA=");
		sb.append(ICONA);
		sb.append(", REGEX=");
		sb.append(REGEX);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaCanale toEntityModel() {
		RubricaCanaleImpl rubricaCanaleImpl = new RubricaCanaleImpl();

		rubricaCanaleImpl.setID_CANALE(ID_CANALE);

		if (NOME == null) {
			rubricaCanaleImpl.setNOME("");
		}
		else {
			rubricaCanaleImpl.setNOME(NOME);
		}

		if (ICONA == null) {
			rubricaCanaleImpl.setICONA("");
		}
		else {
			rubricaCanaleImpl.setICONA(ICONA);
		}

		if (REGEX == null) {
			rubricaCanaleImpl.setREGEX("");
		}
		else {
			rubricaCanaleImpl.setREGEX(REGEX);
		}

		rubricaCanaleImpl.resetOriginalValues();

		return rubricaCanaleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_CANALE = objectInput.readLong();
		NOME = objectInput.readUTF();
		ICONA = objectInput.readUTF();
		REGEX = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_CANALE);

		if (NOME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME);
		}

		if (ICONA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ICONA);
		}

		if (REGEX == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REGEX);
		}
	}

	public long ID_CANALE;

	public String NOME;

	public String ICONA;

	public String REGEX;

}