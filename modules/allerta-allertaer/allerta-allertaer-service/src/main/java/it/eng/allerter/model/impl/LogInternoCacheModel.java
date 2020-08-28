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

import it.eng.allerter.model.LogInterno;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LogInterno in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class LogInternoCacheModel
	implements CacheModel<LogInterno>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogInternoCacheModel)) {
			return false;
		}

		LogInternoCacheModel logInternoCacheModel = (LogInternoCacheModel)obj;

		if (logId == logInternoCacheModel.logId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, logId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{logId=");
		sb.append(logId);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", thread=");
		sb.append(thread);
		sb.append(", cosa=");
		sb.append(cosa);
		sb.append(", dettaglio=");
		sb.append(dettaglio);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", risultato=");
		sb.append(risultato);
		sb.append(", eccezione=");
		sb.append(eccezione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogInterno toEntityModel() {
		LogInternoImpl logInternoImpl = new LogInternoImpl();

		logInternoImpl.setLogId(logId);

		if (timestamp == Long.MIN_VALUE) {
			logInternoImpl.setTimestamp(null);
		}
		else {
			logInternoImpl.setTimestamp(new Date(timestamp));
		}

		if (thread == null) {
			logInternoImpl.setThread("");
		}
		else {
			logInternoImpl.setThread(thread);
		}

		if (cosa == null) {
			logInternoImpl.setCosa("");
		}
		else {
			logInternoImpl.setCosa(cosa);
		}

		if (dettaglio == null) {
			logInternoImpl.setDettaglio("");
		}
		else {
			logInternoImpl.setDettaglio(dettaglio);
		}

		if (utente == null) {
			logInternoImpl.setUtente("");
		}
		else {
			logInternoImpl.setUtente(utente);
		}

		if (risultato == null) {
			logInternoImpl.setRisultato("");
		}
		else {
			logInternoImpl.setRisultato(risultato);
		}

		if (eccezione == null) {
			logInternoImpl.setEccezione("");
		}
		else {
			logInternoImpl.setEccezione(eccezione);
		}

		logInternoImpl.resetOriginalValues();

		return logInternoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		logId = objectInput.readLong();
		timestamp = objectInput.readLong();
		thread = objectInput.readUTF();
		cosa = objectInput.readUTF();
		dettaglio = objectInput.readUTF();
		utente = objectInput.readUTF();
		risultato = objectInput.readUTF();
		eccezione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(logId);
		objectOutput.writeLong(timestamp);

		if (thread == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thread);
		}

		if (cosa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cosa);
		}

		if (dettaglio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dettaglio);
		}

		if (utente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(utente);
		}

		if (risultato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(risultato);
		}

		if (eccezione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eccezione);
		}
	}

	public long logId;
	public long timestamp;
	public String thread;
	public String cosa;
	public String dettaglio;
	public String utente;
	public String risultato;
	public String eccezione;

}