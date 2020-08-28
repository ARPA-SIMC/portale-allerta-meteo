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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CounterSms}.
 * </p>
 *
 * @author Giorgianni_F
 * @see CounterSms
 * @generated
 */
@ProviderType
public class CounterSmsWrapper implements CounterSms, ModelWrapper<CounterSms> {

	public CounterSmsWrapper(CounterSms counterSms) {
		_counterSms = counterSms;
	}

	@Override
	public Class<?> getModelClass() {
		return CounterSms.class;
	}

	@Override
	public String getModelClassName() {
		return CounterSms.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("counterId", getCounterId());
		attributes.put("date", getDate());
		attributes.put("numerosms", getNumerosms());
		attributes.put("nodo", getNodo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long counterId = (Long)attributes.get("counterId");

		if (counterId != null) {
			setCounterId(counterId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer numerosms = (Integer)attributes.get("numerosms");

		if (numerosms != null) {
			setNumerosms(numerosms);
		}

		String nodo = (String)attributes.get("nodo");

		if (nodo != null) {
			setNodo(nodo);
		}
	}

	@Override
	public Object clone() {
		return new CounterSmsWrapper((CounterSms)_counterSms.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerta.messages.services.model.CounterSms counterSms) {

		return _counterSms.compareTo(counterSms);
	}

	/**
	 * Returns the counter ID of this counter sms.
	 *
	 * @return the counter ID of this counter sms
	 */
	@Override
	public long getCounterId() {
		return _counterSms.getCounterId();
	}

	/**
	 * Returns the date of this counter sms.
	 *
	 * @return the date of this counter sms
	 */
	@Override
	public Date getDate() {
		return _counterSms.getDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _counterSms.getExpandoBridge();
	}

	/**
	 * Returns the nodo of this counter sms.
	 *
	 * @return the nodo of this counter sms
	 */
	@Override
	public String getNodo() {
		return _counterSms.getNodo();
	}

	/**
	 * Returns the numerosms of this counter sms.
	 *
	 * @return the numerosms of this counter sms
	 */
	@Override
	public int getNumerosms() {
		return _counterSms.getNumerosms();
	}

	/**
	 * Returns the primary key of this counter sms.
	 *
	 * @return the primary key of this counter sms
	 */
	@Override
	public long getPrimaryKey() {
		return _counterSms.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _counterSms.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _counterSms.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _counterSms.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _counterSms.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _counterSms.isNew();
	}

	@Override
	public void persist() {
		_counterSms.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_counterSms.setCachedModel(cachedModel);
	}

	/**
	 * Sets the counter ID of this counter sms.
	 *
	 * @param counterId the counter ID of this counter sms
	 */
	@Override
	public void setCounterId(long counterId) {
		_counterSms.setCounterId(counterId);
	}

	/**
	 * Sets the date of this counter sms.
	 *
	 * @param date the date of this counter sms
	 */
	@Override
	public void setDate(Date date) {
		_counterSms.setDate(date);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_counterSms.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_counterSms.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_counterSms.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_counterSms.setNew(n);
	}

	/**
	 * Sets the nodo of this counter sms.
	 *
	 * @param nodo the nodo of this counter sms
	 */
	@Override
	public void setNodo(String nodo) {
		_counterSms.setNodo(nodo);
	}

	/**
	 * Sets the numerosms of this counter sms.
	 *
	 * @param numerosms the numerosms of this counter sms
	 */
	@Override
	public void setNumerosms(int numerosms) {
		_counterSms.setNumerosms(numerosms);
	}

	/**
	 * Sets the primary key of this counter sms.
	 *
	 * @param primaryKey the primary key of this counter sms
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_counterSms.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_counterSms.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerta.messages.services.model.CounterSms> toCacheModel() {

		return _counterSms.toCacheModel();
	}

	@Override
	public it.eng.allerta.messages.services.model.CounterSms toEscapedModel() {
		return new CounterSmsWrapper(_counterSms.toEscapedModel());
	}

	@Override
	public String toString() {
		return _counterSms.toString();
	}

	@Override
	public it.eng.allerta.messages.services.model.CounterSms
		toUnescapedModel() {

		return new CounterSmsWrapper(_counterSms.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _counterSms.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CounterSmsWrapper)) {
			return false;
		}

		CounterSmsWrapper counterSmsWrapper = (CounterSmsWrapper)obj;

		if (Objects.equals(_counterSms, counterSmsWrapper._counterSms)) {
			return true;
		}

		return false;
	}

	@Override
	public CounterSms getWrappedModel() {
		return _counterSms;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _counterSms.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _counterSms.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_counterSms.resetOriginalValues();
	}

	private final CounterSms _counterSms;

}