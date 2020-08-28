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

import it.eng.bollettino.model.BollettinoParametro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BollettinoParametro in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoParametroCacheModel
	implements CacheModel<BollettinoParametro>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoParametroCacheModel)) {
			return false;
		}

		BollettinoParametroCacheModel bollettinoParametroCacheModel =
			(BollettinoParametroCacheModel)obj;

		if (parametroId.equals(bollettinoParametroCacheModel.parametroId)) {
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
	public BollettinoParametro toEntityModel() {
		BollettinoParametroImpl bollettinoParametroImpl =
			new BollettinoParametroImpl();

		if (parametroId == null) {
			bollettinoParametroImpl.setParametroId("");
		}
		else {
			bollettinoParametroImpl.setParametroId(parametroId);
		}

		if (valore == null) {
			bollettinoParametroImpl.setValore("");
		}
		else {
			bollettinoParametroImpl.setValore(valore);
		}

		bollettinoParametroImpl.resetOriginalValues();

		return bollettinoParametroImpl;
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