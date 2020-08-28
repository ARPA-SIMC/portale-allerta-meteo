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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.FeedServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class FeedSoap implements Serializable {

	public static FeedSoap toSoapModel(Feed model) {
		FeedSoap soapModel = new FeedSoap();

		soapModel.setFeedId(model.getFeedId());
		soapModel.setTitolo(model.getTitolo());
		soapModel.setLink(model.getLink());
		soapModel.setAutore(model.getAutore());
		soapModel.setQuery(model.getQuery());

		return soapModel;
	}

	public static FeedSoap[] toSoapModels(Feed[] models) {
		FeedSoap[] soapModels = new FeedSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedSoap[][] toSoapModels(Feed[][] models) {
		FeedSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedSoap[] toSoapModels(List<Feed> models) {
		List<FeedSoap> soapModels = new ArrayList<FeedSoap>(models.size());

		for (Feed model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedSoap[soapModels.size()]);
	}

	public FeedSoap() {
	}

	public String getPrimaryKey() {
		return _feedId;
	}

	public void setPrimaryKey(String pk) {
		setFeedId(pk);
	}

	public String getFeedId() {
		return _feedId;
	}

	public void setFeedId(String feedId) {
		_feedId = feedId;
	}

	public String getTitolo() {
		return _titolo;
	}

	public void setTitolo(String titolo) {
		_titolo = titolo;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getAutore() {
		return _autore;
	}

	public void setAutore(String autore) {
		_autore = autore;
	}

	public String getQuery() {
		return _query;
	}

	public void setQuery(String query) {
		_query = query;
	}

	private String _feedId;
	private String _titolo;
	private String _link;
	private String _autore;
	private String _query;

}