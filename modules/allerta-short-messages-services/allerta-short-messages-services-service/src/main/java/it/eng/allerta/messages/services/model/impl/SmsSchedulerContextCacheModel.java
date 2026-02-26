/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class SmsSchedulerContextCacheModel
	implements CacheModel<SmsSchedulerContext>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmsSchedulerContextCacheModel)) {
			return false;
		}

		SmsSchedulerContextCacheModel smsSchedulerContextCacheModel =
			(SmsSchedulerContextCacheModel)object;

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