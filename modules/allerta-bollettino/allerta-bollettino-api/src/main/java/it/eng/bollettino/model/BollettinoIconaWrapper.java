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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BollettinoIcona}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoIcona
 * @generated
 */
@ProviderType
public class BollettinoIconaWrapper
	implements BollettinoIcona, ModelWrapper<BollettinoIcona> {

	public BollettinoIconaWrapper(BollettinoIcona bollettinoIcona) {
		_bollettinoIcona = bollettinoIcona;
	}

	@Override
	public Class<?> getModelClass() {
		return BollettinoIcona.class;
	}

	@Override
	public String getModelClassName() {
		return BollettinoIcona.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idBollettino", getIdBollettino());
		attributes.put("idIcona", getIdIcona());
		attributes.put("x", getX());
		attributes.put("y", getY());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idBollettino = (Long)attributes.get("idBollettino");

		if (idBollettino != null) {
			setIdBollettino(idBollettino);
		}

		Long idIcona = (Long)attributes.get("idIcona");

		if (idIcona != null) {
			setIdIcona(idIcona);
		}

		Double x = (Double)attributes.get("x");

		if (x != null) {
			setX(x);
		}

		Double y = (Double)attributes.get("y");

		if (y != null) {
			setY(y);
		}
	}

	@Override
	public Object clone() {
		return new BollettinoIconaWrapper(
			(BollettinoIcona)_bollettinoIcona.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIcona.compareTo(bollettinoIcona);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bollettinoIcona.getExpandoBridge();
	}

	/**
	 * Returns the ID of this bollettino icona.
	 *
	 * @return the ID of this bollettino icona
	 */
	@Override
	public long getId() {
		return _bollettinoIcona.getId();
	}

	/**
	 * Returns the id bollettino of this bollettino icona.
	 *
	 * @return the id bollettino of this bollettino icona
	 */
	@Override
	public long getIdBollettino() {
		return _bollettinoIcona.getIdBollettino();
	}

	/**
	 * Returns the id icona of this bollettino icona.
	 *
	 * @return the id icona of this bollettino icona
	 */
	@Override
	public long getIdIcona() {
		return _bollettinoIcona.getIdIcona();
	}

	/**
	 * Returns the primary key of this bollettino icona.
	 *
	 * @return the primary key of this bollettino icona
	 */
	@Override
	public long getPrimaryKey() {
		return _bollettinoIcona.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bollettinoIcona.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this bollettino icona.
	 *
	 * @return the uuid of this bollettino icona
	 */
	@Override
	public String getUuid() {
		return _bollettinoIcona.getUuid();
	}

	/**
	 * Returns the x of this bollettino icona.
	 *
	 * @return the x of this bollettino icona
	 */
	@Override
	public double getX() {
		return _bollettinoIcona.getX();
	}

	/**
	 * Returns the y of this bollettino icona.
	 *
	 * @return the y of this bollettino icona
	 */
	@Override
	public double getY() {
		return _bollettinoIcona.getY();
	}

	@Override
	public int hashCode() {
		return _bollettinoIcona.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bollettinoIcona.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bollettinoIcona.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bollettinoIcona.isNew();
	}

	@Override
	public void persist() {
		_bollettinoIcona.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bollettinoIcona.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bollettinoIcona.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bollettinoIcona.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bollettinoIcona.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this bollettino icona.
	 *
	 * @param id the ID of this bollettino icona
	 */
	@Override
	public void setId(long id) {
		_bollettinoIcona.setId(id);
	}

	/**
	 * Sets the id bollettino of this bollettino icona.
	 *
	 * @param idBollettino the id bollettino of this bollettino icona
	 */
	@Override
	public void setIdBollettino(long idBollettino) {
		_bollettinoIcona.setIdBollettino(idBollettino);
	}

	/**
	 * Sets the id icona of this bollettino icona.
	 *
	 * @param idIcona the id icona of this bollettino icona
	 */
	@Override
	public void setIdIcona(long idIcona) {
		_bollettinoIcona.setIdIcona(idIcona);
	}

	@Override
	public void setNew(boolean n) {
		_bollettinoIcona.setNew(n);
	}

	/**
	 * Sets the primary key of this bollettino icona.
	 *
	 * @param primaryKey the primary key of this bollettino icona
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bollettinoIcona.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bollettinoIcona.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this bollettino icona.
	 *
	 * @param uuid the uuid of this bollettino icona
	 */
	@Override
	public void setUuid(String uuid) {
		_bollettinoIcona.setUuid(uuid);
	}

	/**
	 * Sets the x of this bollettino icona.
	 *
	 * @param x the x of this bollettino icona
	 */
	@Override
	public void setX(double x) {
		_bollettinoIcona.setX(x);
	}

	/**
	 * Sets the y of this bollettino icona.
	 *
	 * @param y the y of this bollettino icona
	 */
	@Override
	public void setY(double y) {
		_bollettinoIcona.setY(y);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.BollettinoIcona> toCacheModel() {

		return _bollettinoIcona.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.BollettinoIcona toEscapedModel() {
		return new BollettinoIconaWrapper(_bollettinoIcona.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bollettinoIcona.toString();
	}

	@Override
	public it.eng.bollettino.model.BollettinoIcona toUnescapedModel() {
		return new BollettinoIconaWrapper(_bollettinoIcona.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bollettinoIcona.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoIconaWrapper)) {
			return false;
		}

		BollettinoIconaWrapper bollettinoIconaWrapper =
			(BollettinoIconaWrapper)obj;

		if (Objects.equals(
				_bollettinoIcona, bollettinoIconaWrapper._bollettinoIcona)) {

			return true;
		}

		return false;
	}

	@Override
	public BollettinoIcona getWrappedModel() {
		return _bollettinoIcona;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bollettinoIcona.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bollettinoIcona.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bollettinoIcona.resetOriginalValues();
	}

	private final BollettinoIcona _bollettinoIcona;

}