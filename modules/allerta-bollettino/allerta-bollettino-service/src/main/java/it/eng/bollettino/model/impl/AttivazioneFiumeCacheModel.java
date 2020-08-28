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

import it.eng.bollettino.model.AttivazioneFiume;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AttivazioneFiume in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AttivazioneFiumeCacheModel
	implements CacheModel<AttivazioneFiume>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttivazioneFiumeCacheModel)) {
			return false;
		}

		AttivazioneFiumeCacheModel attivazioneFiumeCacheModel =
			(AttivazioneFiumeCacheModel)obj;

		if (fiumeId.equals(attivazioneFiumeCacheModel.fiumeId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fiumeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fiumeId=");
		sb.append(fiumeId);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttivazioneFiume toEntityModel() {
		AttivazioneFiumeImpl attivazioneFiumeImpl = new AttivazioneFiumeImpl();

		if (fiumeId == null) {
			attivazioneFiumeImpl.setFiumeId("");
		}
		else {
			attivazioneFiumeImpl.setFiumeId(fiumeId);
		}

		attivazioneFiumeImpl.setAttivo(attivo);

		attivazioneFiumeImpl.resetOriginalValues();

		return attivazioneFiumeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fiumeId = objectInput.readUTF();

		attivo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (fiumeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fiumeId);
		}

		objectOutput.writeBoolean(attivo);
	}

	public String fiumeId;
	public boolean attivo;

}