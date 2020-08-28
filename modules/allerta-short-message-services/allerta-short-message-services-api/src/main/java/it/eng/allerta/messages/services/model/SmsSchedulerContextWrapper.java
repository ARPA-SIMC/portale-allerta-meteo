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

package it.eng.allerta.messages.services.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SmsSchedulerContext}.
 * </p>
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContext
 * @generated
 */
@ProviderType
public class SmsSchedulerContextWrapper
	implements SmsSchedulerContext, ModelWrapper<SmsSchedulerContext> {

	public SmsSchedulerContextWrapper(SmsSchedulerContext smsSchedulerContext) {
		_smsSchedulerContext = smsSchedulerContext;
	}

	@Override
	public Class<?> getModelClass() {
		return SmsSchedulerContext.class;
	}

	@Override
	public String getModelClassName() {
		return SmsSchedulerContext.class.getName();
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
	public Object clone() {
		return new SmsSchedulerContextWrapper(
			(SmsSchedulerContext)_smsSchedulerContext.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerta.messages.services.model.SmsSchedulerContext
			smsSchedulerContext) {

		return _smsSchedulerContext.compareTo(smsSchedulerContext);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _smsSchedulerContext.getExpandoBridge();
	}

	/**
	 * Returns the primary key of this sms scheduler context.
	 *
	 * @return the primary key of this sms scheduler context
	 */
	@Override
	public String getPrimaryKey() {
		return _smsSchedulerContext.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _smsSchedulerContext.getPrimaryKeyObj();
	}

	/**
	 * Returns the value of this sms scheduler context.
	 *
	 * @return the value of this sms scheduler context
	 */
	@Override
	public String getValue() {
		return _smsSchedulerContext.getValue();
	}

	/**
	 * Returns the var ID of this sms scheduler context.
	 *
	 * @return the var ID of this sms scheduler context
	 */
	@Override
	public String getVarId() {
		return _smsSchedulerContext.getVarId();
	}

	@Override
	public int hashCode() {
		return _smsSchedulerContext.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _smsSchedulerContext.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _smsSchedulerContext.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _smsSchedulerContext.isNew();
	}

	@Override
	public void persist() {
		_smsSchedulerContext.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_smsSchedulerContext.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_smsSchedulerContext.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_smsSchedulerContext.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_smsSchedulerContext.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_smsSchedulerContext.setNew(n);
	}

	/**
	 * Sets the primary key of this sms scheduler context.
	 *
	 * @param primaryKey the primary key of this sms scheduler context
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_smsSchedulerContext.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_smsSchedulerContext.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the value of this sms scheduler context.
	 *
	 * @param value the value of this sms scheduler context
	 */
	@Override
	public void setValue(String value) {
		_smsSchedulerContext.setValue(value);
	}

	/**
	 * Sets the var ID of this sms scheduler context.
	 *
	 * @param varId the var ID of this sms scheduler context
	 */
	@Override
	public void setVarId(String varId) {
		_smsSchedulerContext.setVarId(varId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerta.messages.services.model.SmsSchedulerContext>
			toCacheModel() {

		return _smsSchedulerContext.toCacheModel();
	}

	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		toEscapedModel() {

		return new SmsSchedulerContextWrapper(
			_smsSchedulerContext.toEscapedModel());
	}

	@Override
	public String toString() {
		return _smsSchedulerContext.toString();
	}

	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		toUnescapedModel() {

		return new SmsSchedulerContextWrapper(
			_smsSchedulerContext.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _smsSchedulerContext.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SmsSchedulerContextWrapper)) {
			return false;
		}

		SmsSchedulerContextWrapper smsSchedulerContextWrapper =
			(SmsSchedulerContextWrapper)obj;

		if (Objects.equals(
				_smsSchedulerContext,
				smsSchedulerContextWrapper._smsSchedulerContext)) {

			return true;
		}

		return false;
	}

	@Override
	public SmsSchedulerContext getWrappedModel() {
		return _smsSchedulerContext;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _smsSchedulerContext.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _smsSchedulerContext.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_smsSchedulerContext.resetOriginalValues();
	}

	private final SmsSchedulerContext _smsSchedulerContext;

}