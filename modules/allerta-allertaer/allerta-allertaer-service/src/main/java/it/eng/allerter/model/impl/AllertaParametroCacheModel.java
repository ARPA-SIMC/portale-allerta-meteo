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

import it.eng.allerter.model.AllertaParametro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AllertaParametro in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaParametroCacheModel
	implements CacheModel<AllertaParametro>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaParametroCacheModel)) {
			return false;
		}

		AllertaParametroCacheModel allertaParametroCacheModel =
			(AllertaParametroCacheModel)obj;

		if (parametroId.equals(allertaParametroCacheModel.parametroId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, parametroId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{parametroId=");
		sb.append(parametroId);
		sb.append(", valore=");
		sb.append(valore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AllertaParametro toEntityModel() {
		AllertaParametroImpl allertaParametroImpl = new AllertaParametroImpl();

		if (parametroId == null) {
			allertaParametroImpl.setParametroId("");
		}
		else {
			allertaParametroImpl.setParametroId(parametroId);
		}

		if (valore == null) {
			allertaParametroImpl.setValore("");
		}
		else {
			allertaParametroImpl.setValore(valore);
		}

		allertaParametroImpl.resetOriginalValues();

		return allertaParametroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parametroId = objectInput.readUTF();
		valore = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (parametroId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parametroId);
		}

		if (valore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valore);
		}
	}

	public String parametroId;
	public String valore;

}