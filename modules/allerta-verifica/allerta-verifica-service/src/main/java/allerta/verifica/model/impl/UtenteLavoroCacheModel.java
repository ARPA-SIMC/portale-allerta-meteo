/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model.impl;

import allerta.verifica.model.UtenteLavoro;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class UtenteLavoroCacheModel
	implements CacheModel<UtenteLavoro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UtenteLavoroCacheModel)) {
			return false;
		}

		UtenteLavoroCacheModel utenteLavoroCacheModel =
			(UtenteLavoroCacheModel)object;

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