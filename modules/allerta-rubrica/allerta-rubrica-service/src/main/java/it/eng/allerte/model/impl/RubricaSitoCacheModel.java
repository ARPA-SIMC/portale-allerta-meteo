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
@ProviderType
public class RubricaSitoCacheModel
	implements CacheModel<RubricaSito>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaSitoCacheModel)) {
			return false;
		}

		RubricaSitoCacheModel rubricaSitoCacheModel =
			(RubricaSitoCacheModel)obj;

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