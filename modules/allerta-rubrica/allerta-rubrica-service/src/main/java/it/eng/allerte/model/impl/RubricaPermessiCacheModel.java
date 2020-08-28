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

import it.eng.allerte.model.RubricaPermessi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaPermessi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaPermessiCacheModel
	implements CacheModel<RubricaPermessi>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaPermessiCacheModel)) {
			return false;
		}

		RubricaPermessiCacheModel rubricaPermessiCacheModel =
			(RubricaPermessiCacheModel)obj;

		if (ID_PERMESSO.equals(rubricaPermessiCacheModel.ID_PERMESSO)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_PERMESSO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ID_PERMESSO=");
		sb.append(ID_PERMESSO);
		sb.append(", NOME_PERMESSO=");
		sb.append(NOME_PERMESSO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaPermessi toEntityModel() {
		RubricaPermessiImpl rubricaPermessiImpl = new RubricaPermessiImpl();

		if (ID_PERMESSO == null) {
			rubricaPermessiImpl.setID_PERMESSO("");
		}
		else {
			rubricaPermessiImpl.setID_PERMESSO(ID_PERMESSO);
		}

		if (NOME_PERMESSO == null) {
			rubricaPermessiImpl.setNOME_PERMESSO("");
		}
		else {
			rubricaPermessiImpl.setNOME_PERMESSO(NOME_PERMESSO);
		}

		rubricaPermessiImpl.resetOriginalValues();

		return rubricaPermessiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_PERMESSO = objectInput.readUTF();
		NOME_PERMESSO = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (ID_PERMESSO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ID_PERMESSO);
		}

		if (NOME_PERMESSO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME_PERMESSO);
		}
	}

	public String ID_PERMESSO;

	public String NOME_PERMESSO;

}