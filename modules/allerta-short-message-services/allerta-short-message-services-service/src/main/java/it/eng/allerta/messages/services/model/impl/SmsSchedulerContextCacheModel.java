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

import it.eng.allerta.messages.services.model.SmsSchedulerContext;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SmsSchedulerContext in entity cache.
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class SmsSchedulerContextCacheModel
	implements CacheModel<SmsSchedulerContext>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SmsSchedulerContextCacheModel)) {
			return false;
		}

		SmsSchedulerContextCacheModel smsSchedulerContextCacheModel =
			(SmsSchedulerContextCacheModel)obj;

		if (varId.equals(smsSchedulerContextCacheModel.varId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, varId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{varId=");
		sb.append(varId);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SmsSchedulerContext toEntityModel() {
		SmsSchedulerContextImpl smsSchedulerContextImpl =
			new SmsSchedulerContextImpl();

		if (varId == null) {
			smsSchedulerContextImpl.setVarId("");
		}
		else {
			smsSchedulerContextImpl.setVarId(varId);
		}

		if (value == null) {
			smsSchedulerContextImpl.setValue("");
		}
		else {
			smsSchedulerContextImpl.setValue(value);
		}

		smsSchedulerContextImpl.resetOriginalValues();

		return smsSchedulerContextImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		varId = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (varId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(varId);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String varId;
	public String value;

}