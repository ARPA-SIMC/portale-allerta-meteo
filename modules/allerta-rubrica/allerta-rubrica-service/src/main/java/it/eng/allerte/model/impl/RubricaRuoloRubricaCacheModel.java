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

import it.eng.allerte.model.RubricaRuoloRubrica;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaRuoloRubrica in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloRubricaCacheModel
	implements CacheModel<RubricaRuoloRubrica>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloRubricaCacheModel)) {
			return false;
		}

		RubricaRuoloRubricaCacheModel rubricaRuoloRubricaCacheModel =
			(RubricaRuoloRubricaCacheModel)obj;

		if (ID_RUOLO == rubricaRuoloRubricaCacheModel.ID_RUOLO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_RUOLO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ID_RUOLO=");
		sb.append(ID_RUOLO);
		sb.append(", DESCRIZIONE=");
		sb.append(DESCRIZIONE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaRuoloRubrica toEntityModel() {
		RubricaRuoloRubricaImpl rubricaRuoloRubricaImpl =
			new RubricaRuoloRubricaImpl();

		rubricaRuoloRubricaImpl.setID_RUOLO(ID_RUOLO);

		if (DESCRIZIONE == null) {
			rubricaRuoloRubricaImpl.setDESCRIZIONE("");
		}
		else {
			rubricaRuoloRubricaImpl.setDESCRIZIONE(DESCRIZIONE);
		}

		rubricaRuoloRubricaImpl.resetOriginalValues();

		return rubricaRuoloRubricaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_RUOLO = objectInput.readLong();
		DESCRIZIONE = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_RUOLO);

		if (DESCRIZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DESCRIZIONE);
		}
	}

	public long ID_RUOLO;

	public String DESCRIZIONE;

}