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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.VariabileServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class VariabileSoap implements Serializable {

	public static VariabileSoap toSoapModel(Variabile model) {
		VariabileSoap soapModel = new VariabileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setDescription_it(model.getDescription_it());
		soapModel.setLevel_t1(model.getLevel_t1());
		soapModel.setLevel_t2(model.getLevel_t2());
		soapModel.setLevel_v1(model.getLevel_v1());
		soapModel.setLevel_v2(model.getLevel_v2());
		soapModel.setTrange_p1(model.getTrange_p1());
		soapModel.setTrange_p2(model.getTrange_p2());
		soapModel.setTrange_pind(model.getTrange_pind());
		soapModel.setUnit(model.getUnit());
		soapModel.setBcode(model.getBcode());

		return soapModel;
	}

	public static VariabileSoap[] toSoapModels(Variabile[] models) {
		VariabileSoap[] soapModels = new VariabileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VariabileSoap[][] toSoapModels(Variabile[][] models) {
		VariabileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VariabileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VariabileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VariabileSoap[] toSoapModels(List<Variabile> models) {
		List<VariabileSoap> soapModels = new ArrayList<VariabileSoap>(
			models.size());

		for (Variabile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VariabileSoap[soapModels.size()]);
	}

	public VariabileSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getDescription_it() {
		return _description_it;
	}

	public void setDescription_it(String description_it) {
		_description_it = description_it;
	}

	public int getLevel_t1() {
		return _level_t1;
	}

	public void setLevel_t1(int level_t1) {
		_level_t1 = level_t1;
	}

	public int getLevel_t2() {
		return _level_t2;
	}

	public void setLevel_t2(int level_t2) {
		_level_t2 = level_t2;
	}

	public int getLevel_v1() {
		return _level_v1;
	}

	public void setLevel_v1(int level_v1) {
		_level_v1 = level_v1;
	}

	public int getLevel_v2() {
		return _level_v2;
	}

	public void setLevel_v2(int level_v2) {
		_level_v2 = level_v2;
	}

	public int getTrange_p1() {
		return _trange_p1;
	}

	public void setTrange_p1(int trange_p1) {
		_trange_p1 = trange_p1;
	}

	public int getTrange_p2() {
		return _trange_p2;
	}

	public void setTrange_p2(int trange_p2) {
		_trange_p2 = trange_p2;
	}

	public int getTrange_pind() {
		return _trange_pind;
	}

	public void setTrange_pind(int trange_pind) {
		_trange_pind = trange_pind;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public String getBcode() {
		return _bcode;
	}

	public void setBcode(String bcode) {
		_bcode = bcode;
	}

	private String _uuid;
	private String _id;
	private String _description_it;
	private int _level_t1;
	private int _level_t2;
	private int _level_v1;
	private int _level_v2;
	private int _trange_p1;
	private int _trange_p2;
	private int _trange_pind;
	private String _unit;
	private String _bcode;

}