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

package it.eng.allerter.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerter.model.Geografia;
import it.eng.allerter.service.persistence.GeografiaPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Geografia in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class GeografiaCacheModel
	implements CacheModel<Geografia>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeografiaCacheModel)) {
			return false;
		}

		GeografiaCacheModel geografiaCacheModel = (GeografiaCacheModel)obj;

		if (geografiaPK.equals(geografiaCacheModel.geografiaPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, geografiaPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{geografiaId=");
		sb.append(geografiaId);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", area=");
		sb.append(area);
		sb.append(", complessita=");
		sb.append(complessita);
		sb.append(", geometria=");
		sb.append(geometria);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Geografia toEntityModel() {
		GeografiaImpl geografiaImpl = new GeografiaImpl();

		if (geografiaId == null) {
			geografiaImpl.setGeografiaId("");
		}
		else {
			geografiaImpl.setGeografiaId(geografiaId);
		}

		if (tipo == null) {
			geografiaImpl.setTipo("");
		}
		else {
			geografiaImpl.setTipo(tipo);
		}

		if (area == null) {
			geografiaImpl.setArea("");
		}
		else {
			geografiaImpl.setArea(area);
		}

		if (complessita == null) {
			geografiaImpl.setComplessita("");
		}
		else {
			geografiaImpl.setComplessita(complessita);
		}

		if (geometria == null) {
			geografiaImpl.setGeometria("");
		}
		else {
			geografiaImpl.setGeometria(geometria);
		}

		geografiaImpl.resetOriginalValues();

		return geografiaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		geografiaId = objectInput.readUTF();
		tipo = objectInput.readUTF();
		area = objectInput.readUTF();
		complessita = objectInput.readUTF();
		geometria = objectInput.readUTF();

		geografiaPK = new GeografiaPK(geografiaId, tipo, area, complessita);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (geografiaId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(geografiaId);
		}

		if (tipo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipo);
		}

		if (area == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(area);
		}

		if (complessita == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(complessita);
		}

		if (geometria == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(geometria);
		}
	}

	public String geografiaId;
	public String tipo;
	public String area;
	public String complessita;
	public String geometria;
	public transient GeografiaPK geografiaPK;

}