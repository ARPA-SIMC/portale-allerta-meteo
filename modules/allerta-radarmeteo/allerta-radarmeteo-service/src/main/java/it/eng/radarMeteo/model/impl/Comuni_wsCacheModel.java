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

import it.eng.radarMeteo.model.Comuni_ws;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Comuni_ws in entity cache.
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class Comuni_wsCacheModel
	implements CacheModel<Comuni_ws>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comuni_wsCacheModel)) {
			return false;
		}

		Comuni_wsCacheModel comuni_wsCacheModel = (Comuni_wsCacheModel)obj;

		if (idIstat.equals(comuni_wsCacheModel.idIstat)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idIstat);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idIstat=");
		sb.append(idIstat);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", sottozona=");
		sb.append(sottozona);
		sb.append(", zonaallerta=");
		sb.append(zonaallerta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comuni_ws toEntityModel() {
		Comuni_wsImpl comuni_wsImpl = new Comuni_wsImpl();

		if (idIstat == null) {
			comuni_wsImpl.setIdIstat("");
		}
		else {
			comuni_wsImpl.setIdIstat(idIstat);
		}

		if (comune == null) {
			comuni_wsImpl.setComune("");
		}
		else {
			comuni_wsImpl.setComune(comune);
		}

		if (provincia == null) {
			comuni_wsImpl.setProvincia("");
		}
		else {
			comuni_wsImpl.setProvincia(provincia);
		}

		if (sottozona == null) {
			comuni_wsImpl.setSottozona("");
		}
		else {
			comuni_wsImpl.setSottozona(sottozona);
		}

		if (zonaallerta == null) {
			comuni_wsImpl.setZonaallerta("");
		}
		else {
			comuni_wsImpl.setZonaallerta(zonaallerta);
		}

		comuni_wsImpl.resetOriginalValues();

		return comuni_wsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idIstat = objectInput.readUTF();
		comune = objectInput.readUTF();
		provincia = objectInput.readUTF();
		sottozona = objectInput.readUTF();
		zonaallerta = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (idIstat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idIstat);
		}

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

		if (sottozona == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sottozona);
		}

		if (zonaallerta == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zonaallerta);
		}
	}

	public String idIstat;
	public String comune;
	public String provincia;
	public String sottozona;
	public String zonaallerta;

}