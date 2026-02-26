/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerta.messages.services.model.CounterSms;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CounterSms in entity cache.
 *
 * @author Giorgianni_F
 * @generated
 */
public class CounterSmsCacheModel
	implements CacheModel<CounterSms>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CounterSmsCacheModel)) {
			return false;
		}

		CounterSmsCacheModel counterSmsCacheModel =
			(CounterSmsCacheModel)object;

		if (counterId == counterSmsCacheModel.counterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, counterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{counterId=");
		sb.append(counterId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", numerosms=");
		sb.append(numerosms);
		sb.append(", nodo=");
		sb.append(nodo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CounterSms toEntityModel() {
		CounterSmsImpl counterSmsImpl = new CounterSmsImpl();

		counterSmsImpl.setCounterId(counterId);

		if (date == Long.MIN_VALUE) {
			counterSmsImpl.setDate(null);
		}
		else {
			counterSmsImpl.setDate(new Date(date));
		}

		counterSmsImpl.setNumerosms(numerosms);

		if (nodo == null) {
			counterSmsImpl.setNodo("");
		}
		else {
			counterSmsImpl.setNodo(nodo);
		}

		counterSmsImpl.resetOriginalValues();

		return counterSmsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		counterId = objectInput.readLong();
		date = objectInput.readLong();

		numerosms = objectInput.readInt();
		nodo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(counterId);
		objectOutput.writeLong(date);

		objectOutput.writeInt(numerosms);

		if (nodo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nodo);
		}
	}

	public long counterId;
	public long date;
	public int numerosms;
	public String nodo;

}