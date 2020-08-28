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

package it.eng.parer.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.parer.model.Parametri;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Parametri in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class ParametriCacheModel
	implements CacheModel<Parametri>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParametriCacheModel)) {
			return false;
		}

		ParametriCacheModel parametriCacheModel = (ParametriCacheModel)obj;

		if (chiave.equals(parametriCacheModel.chiave)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, chiave);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{chiave=");
		sb.append(chiave);
		sb.append(", valore=");
		sb.append(valore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Parametri toEntityModel() {
		ParametriImpl parametriImpl = new ParametriImpl();

		if (chiave == null) {
			parametriImpl.setChiave("");
		}
		else {
			parametriImpl.setChiave(chiave);
		}

		if (valore == null) {
			parametriImpl.setValore("");
		}
		else {
			parametriImpl.setValore(valore);
		}

		parametriImpl.resetOriginalValues();

		return parametriImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chiave = objectInput.readUTF();
		valore = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (chiave == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chiave);
		}

		if (valore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valore);
		}
	}

	public String chiave;
	public String valore;

}