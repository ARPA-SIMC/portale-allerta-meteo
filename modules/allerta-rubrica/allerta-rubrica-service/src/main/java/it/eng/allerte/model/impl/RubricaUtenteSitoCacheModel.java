/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class RubricaUtenteSitoCacheModel
	implements CacheModel<RubricaUtenteSito>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaUtenteSitoCacheModel)) {
			return false;
		}

		RubricaUtenteSitoCacheModel rubricaUtenteSitoCacheModel =
			(RubricaUtenteSitoCacheModel)object;

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