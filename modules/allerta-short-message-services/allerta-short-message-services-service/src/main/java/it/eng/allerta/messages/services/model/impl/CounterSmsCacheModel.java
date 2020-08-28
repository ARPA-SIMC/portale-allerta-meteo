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

package it.eng.allerta.messages.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class CounterSmsCacheModel
	implements CacheModel<CounterSms>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CounterSmsCacheModel)) {
			return false;
		}

		CounterSmsCacheModel counterSmsCacheModel = (CounterSmsCacheModel)obj;

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