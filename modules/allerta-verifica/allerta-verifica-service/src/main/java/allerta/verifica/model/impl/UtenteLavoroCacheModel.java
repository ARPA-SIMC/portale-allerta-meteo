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

package allerta.verifica.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.model.UtenteLavoro;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UtenteLavoro in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UtenteLavoroCacheModel
	implements CacheModel<UtenteLavoro>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UtenteLavoroCacheModel)) {
			return false;
		}

		UtenteLavoroCacheModel utenteLavoroCacheModel =
			(UtenteLavoroCacheModel)obj;

		if (id == utenteLavoroCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", documento=");
		sb.append(documento);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", ts=");
		sb.append(ts);
		sb.append(", attivita=");
		sb.append(attivita);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UtenteLavoro toEntityModel() {
		UtenteLavoroImpl utenteLavoroImpl = new UtenteLavoroImpl();

		utenteLavoroImpl.setId(id);
		utenteLavoroImpl.setDocumento(documento);

		if (utente == null) {
			utenteLavoroImpl.setUtente("");
		}
		else {
			utenteLavoroImpl.setUtente(utente);
		}

		if (ts == Long.MIN_VALUE) {
			utenteLavoroImpl.setTs(null);
		}
		else {
			utenteLavoroImpl.setTs(new Date(ts));
		}

		if (attivita == null) {
			utenteLavoroImpl.setAttivita("");
		}
		else {
			utenteLavoroImpl.setAttivita(attivita);
		}

		utenteLavoroImpl.resetOriginalValues();

		return utenteLavoroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		documento = objectInput.readLong();
		utente = objectInput.readUTF();
		ts = objectInput.readLong();
		attivita = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(documento);

		if (utente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utente);
		}

		objectOutput.writeLong(ts);

		if (attivita == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attivita);
		}
	}

	public long id;
	public long documento;
	public String utente;
	public long ts;
	public String attivita;

}