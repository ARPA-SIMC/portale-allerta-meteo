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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerta.messages.services.service.http.SmsSchedulerContextServiceSoap}.
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class SmsSchedulerContextSoap implements Serializable {

	public static SmsSchedulerContextSoap toSoapModel(
		SmsSchedulerContext model) {

		SmsSchedulerContextSoap soapModel = new SmsSchedulerContextSoap();

		soapModel.setVarId(model.getVarId());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static SmsSchedulerContextSoap[] toSoapModels(
		SmsSchedulerContext[] models) {

		SmsSchedulerContextSoap[] soapModels =
			new SmsSchedulerContextSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmsSchedulerContextSoap[][] toSoapModels(
		SmsSchedulerContext[][] models) {

		SmsSchedulerContextSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmsSchedulerContextSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmsSchedulerContextSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmsSchedulerContextSoap[] toSoapModels(
		List<SmsSchedulerContext> models) {

		List<SmsSchedulerContextSoap> soapModels =
			new ArrayList<SmsSchedulerContextSoap>(models.size());

		for (SmsSchedulerContext model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmsSchedulerContextSoap[soapModels.size()]);
	}

	public SmsSchedulerContextSoap() {
	}

	public String getPrimaryKey() {
		return _varId;
	}

	public void setPrimaryKey(String pk) {
		setVarId(pk);
	}

	public String getVarId() {
		return _varId;
	}

	public void setVarId(String varId) {
		_varId = varId;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _varId;
	private String _value;

}