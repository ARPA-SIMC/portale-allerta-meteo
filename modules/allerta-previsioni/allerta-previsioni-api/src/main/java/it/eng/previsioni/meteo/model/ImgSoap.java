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

package it.eng.previsioni.meteo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.previsioni.meteo.service.http.ImgServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ImgSoap implements Serializable {

	public static ImgSoap toSoapModel(Img model) {
		ImgSoap soapModel = new ImgSoap();

		soapModel.setId(model.getId());
		soapModel.setDaypart(model.getDaypart());
		soapModel.setDay(model.getDay());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setInserted(model.getInserted());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static ImgSoap[] toSoapModels(Img[] models) {
		ImgSoap[] soapModels = new ImgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImgSoap[][] toSoapModels(Img[][] models) {
		ImgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImgSoap[] toSoapModels(List<Img> models) {
		List<ImgSoap> soapModels = new ArrayList<ImgSoap>(models.size());

		for (Img model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImgSoap[soapModels.size()]);
	}

	public ImgSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getDaypart() {
		return _daypart;
	}

	public void setDaypart(String daypart) {
		_daypart = daypart;
	}

	public String getDay() {
		return _day;
	}

	public void setDay(String day) {
		_day = day;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public Date getInserted() {
		return _inserted;
	}

	public void setInserted(Date inserted) {
		_inserted = inserted;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _id;
	private String _daypart;
	private String _day;
	private String _provincia;
	private Date _inserted;
	private String _data;

}