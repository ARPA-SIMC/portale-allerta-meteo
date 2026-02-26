/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CounterSms}.
 * </p>
 *
 * @author Giorgianni_F
 * @see CounterSms
 * @generated
 */
public class CounterSmsWrapper
	extends BaseModelWrapper<CounterSms>
	implements CounterSms, ModelWrapper<CounterSms> {

	public CounterSmsWrapper(CounterSms counterSms) {
		super(counterSms);
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
	public CounterSms cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the counter ID of this counter sms.
	 *
	 * @return the counter ID of this counter sms
	 */
	@Override
	public long getCounterId() {
		return model.getCounterId();
	}

	/**
	 * Returns the date of this counter sms.
	 *
	 * @return the date of this counter sms
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the nodo of this counter sms.
	 *
	 * @return the nodo of this counter sms
	 */
	@Override
	public String getNodo() {
		return model.getNodo();
	}

	/**
	 * Returns the numerosms of this counter sms.
	 *
	 * @return the numerosms of this counter sms
	 */
	@Override
	public int getNumerosms() {
		return model.getNumerosms();
	}

	/**
	 * Returns the primary key of this counter sms.
	 *
	 * @return the primary key of this counter sms
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the counter ID of this counter sms.
	 *
	 * @param counterId the counter ID of this counter sms
	 */
	@Override
	public void setCounterId(long counterId) {
		model.setCounterId(counterId);
	}

	/**
	 * Sets the date of this counter sms.
	 *
	 * @param date the date of this counter sms
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the nodo of this counter sms.
	 *
	 * @param nodo the nodo of this counter sms
	 */
	@Override
	public void setNodo(String nodo) {
		model.setNodo(nodo);
	}

	/**
	 * Sets the numerosms of this counter sms.
	 *
	 * @param numerosms the numerosms of this counter sms
	 */
	@Override
	public void setNumerosms(int numerosms) {
		model.setNumerosms(numerosms);
	}

	/**
	 * Sets the primary key of this counter sms.
	 *
	 * @param primaryKey the primary key of this counter sms
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CounterSmsWrapper wrap(CounterSms counterSms) {
		return new CounterSmsWrapper(counterSms);
	}

}