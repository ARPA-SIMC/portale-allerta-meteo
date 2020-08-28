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

package it.eng.radarMeteo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.radarMeteo.model.Comuni_bacini_ws;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Comuni_bacini_ws in entity cache.
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsCacheModel
	implements CacheModel<Comuni_bacini_ws>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comuni_bacini_wsCacheModel)) {
			return false;
		}

		Comuni_bacini_wsCacheModel comuni_bacini_wsCacheModel =
			(Comuni_bacini_wsCacheModel)obj;

		if (idBacini == comuni_bacini_wsCacheModel.idBacini) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idBacini);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{idBacini=");
		sb.append(idBacini);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", bacino=");
		sb.append(bacino);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comuni_bacini_ws toEntityModel() {
		Comuni_bacini_wsImpl comuni_bacini_wsImpl = new Comuni_bacini_wsImpl();

		comuni_bacini_wsImpl.setIdBacini(idBacini);

		if (comune == null) {
			comuni_bacini_wsImpl.setComune("");
		}
		else {
			comuni_bacini_wsImpl.setComune(comune);
		}

		if (provincia == null) {
			comuni_bacini_wsImpl.setProvincia("");
		}
		else {
			comuni_bacini_wsImpl.setProvincia(provincia);
		}

		if (bacino == null) {
			comuni_bacini_wsImpl.setBacino("");
		}
		else {
			comuni_bacini_wsImpl.setBacino(bacino);
		}

		comuni_bacini_wsImpl.resetOriginalValues();

		return comuni_bacini_wsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idBacini = objectInput.readInt();
		comune = objectInput.readUTF();
		provincia = objectInput.readUTF();
		bacino = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(idBacini);

		if (comune == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comune);
		}

		if (provincia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provincia);
		}

		if (bacino == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bacino);
		}
	}

	public int idBacini;
	public String comune;
	public String provincia;
	public String bacino;

}