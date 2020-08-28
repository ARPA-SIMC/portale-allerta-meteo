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

import it.eng.allerte.model.RubricaRuolo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaRuolo in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloCacheModel
	implements CacheModel<RubricaRuolo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloCacheModel)) {
			return false;
		}

		RubricaRuoloCacheModel rubricaRuoloCacheModel =
			(RubricaRuoloCacheModel)obj;

		if (ID_RUOLO == rubricaRuoloCacheModel.ID_RUOLO) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{ID_RUOLO=");
		sb.append(ID_RUOLO);
		sb.append(", DESCRIZIONE=");
		sb.append(DESCRIZIONE);
		sb.append(", FK_RUOLO_LIFERAY=");
		sb.append(FK_RUOLO_LIFERAY);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaRuolo toEntityModel() {
		RubricaRuoloImpl rubricaRuoloImpl = new RubricaRuoloImpl();

		rubricaRuoloImpl.setID_RUOLO(ID_RUOLO);

		if (DESCRIZIONE == null) {
			rubricaRuoloImpl.setDESCRIZIONE("");
		}
		else {
			rubricaRuoloImpl.setDESCRIZIONE(DESCRIZIONE);
		}

		rubricaRuoloImpl.setFK_RUOLO_LIFERAY(FK_RUOLO_LIFERAY);

		rubricaRuoloImpl.resetOriginalValues();

		return rubricaRuoloImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_RUOLO = objectInput.readLong();
		DESCRIZIONE = objectInput.readUTF();

		FK_RUOLO_LIFERAY = objectInput.readLong();
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

		objectOutput.writeLong(FK_RUOLO_LIFERAY);
	}

	public long ID_RUOLO;

	public String DESCRIZIONE;

	public long FK_RUOLO_LIFERAY;

}