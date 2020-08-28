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

import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaGruppoGruppi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiCacheModel
	implements CacheModel<RubricaGruppoGruppi>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaGruppoGruppiCacheModel)) {
			return false;
		}

		RubricaGruppoGruppiCacheModel rubricaGruppoGruppiCacheModel =
			(RubricaGruppoGruppiCacheModel)obj;

		if (rubricaGruppoGruppiPK.equals(
				rubricaGruppoGruppiCacheModel.rubricaGruppoGruppiPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rubricaGruppoGruppiPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{FK_GRUPPO_PADRE=");
		sb.append(FK_GRUPPO_PADRE);
		sb.append(", FK_GRUPPO_FIGLIO=");
		sb.append(FK_GRUPPO_FIGLIO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaGruppoGruppi toEntityModel() {
		RubricaGruppoGruppiImpl rubricaGruppoGruppiImpl =
			new RubricaGruppoGruppiImpl();

		rubricaGruppoGruppiImpl.setFK_GRUPPO_PADRE(FK_GRUPPO_PADRE);
		rubricaGruppoGruppiImpl.setFK_GRUPPO_FIGLIO(FK_GRUPPO_FIGLIO);

		rubricaGruppoGruppiImpl.resetOriginalValues();

		return rubricaGruppoGruppiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		FK_GRUPPO_PADRE = objectInput.readLong();

		FK_GRUPPO_FIGLIO = objectInput.readLong();

		rubricaGruppoGruppiPK = new RubricaGruppoGruppiPK(
			FK_GRUPPO_PADRE, FK_GRUPPO_FIGLIO);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(FK_GRUPPO_PADRE);

		objectOutput.writeLong(FK_GRUPPO_FIGLIO);
	}

	public long FK_GRUPPO_PADRE;

	public long FK_GRUPPO_FIGLIO;

	public transient RubricaGruppoGruppiPK rubricaGruppoGruppiPK;

}