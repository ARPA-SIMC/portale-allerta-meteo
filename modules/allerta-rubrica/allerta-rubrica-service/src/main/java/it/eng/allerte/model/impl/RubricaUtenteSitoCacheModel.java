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

import it.eng.allerte.model.RubricaUtenteSito;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaUtenteSito in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaUtenteSitoCacheModel
	implements CacheModel<RubricaUtenteSito>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaUtenteSitoCacheModel)) {
			return false;
		}

		RubricaUtenteSitoCacheModel rubricaUtenteSitoCacheModel =
			(RubricaUtenteSitoCacheModel)obj;

		if (ID_UTENTE == rubricaUtenteSitoCacheModel.ID_UTENTE) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_UTENTE);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ID_UTENTE=");
		sb.append(ID_UTENTE);
		sb.append(", ID_SITO=");
		sb.append(ID_SITO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaUtenteSito toEntityModel() {
		RubricaUtenteSitoImpl rubricaUtenteSitoImpl =
			new RubricaUtenteSitoImpl();

		rubricaUtenteSitoImpl.setID_UTENTE(ID_UTENTE);
		rubricaUtenteSitoImpl.setID_SITO(ID_SITO);

		rubricaUtenteSitoImpl.resetOriginalValues();

		return rubricaUtenteSitoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_UTENTE = objectInput.readLong();

		ID_SITO = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_UTENTE);

		objectOutput.writeLong(ID_SITO);
	}

	public long ID_UTENTE;

	public long ID_SITO;

}