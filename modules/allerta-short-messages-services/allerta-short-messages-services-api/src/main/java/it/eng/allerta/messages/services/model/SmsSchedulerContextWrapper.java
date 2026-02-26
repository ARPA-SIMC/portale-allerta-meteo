/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SmsSchedulerContext}.
 * </p>
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContext
 * @generated
 */
public class SmsSchedulerContextWrapper
	extends BaseModelWrapper<SmsSchedulerContext>
	implements ModelWrapper<SmsSchedulerContext>, SmsSchedulerContext {

	public SmsSchedulerContextWrapper(SmsSchedulerContext smsSchedulerContext) {
		super(smsSchedulerContext);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("varId", getVarId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String varId = (String)attributes.get("varId");

		if (varId != null) {
			setVarId(varId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public SmsSchedulerContext cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this sms scheduler context.
	 *
	 * @return the primary key of this sms scheduler context
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this sms scheduler context.
	 *
	 * @return the value of this sms scheduler context
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	/**
	 * Returns the var ID of this sms scheduler context.
	 *
	 * @return the var ID of this sms scheduler context
	 */
	@Override
	public String getVarId() {
		return model.getVarId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this sms scheduler context.
	 *
	 * @param primaryKey the primary key of this sms scheduler context
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this sms scheduler context.
	 *
	 * @param value the value of this sms scheduler context
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	/**
	 * Sets the var ID of this sms scheduler context.
	 *
	 * @param varId the var ID of this sms scheduler context
	 */
	@Override
	public void setVarId(String varId) {
		model.setVarId(varId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SmsSchedulerContextWrapper wrap(
		SmsSchedulerContext smsSchedulerContext) {

		return new SmsSchedulerContextWrapper(smsSchedulerContext);
	}

}