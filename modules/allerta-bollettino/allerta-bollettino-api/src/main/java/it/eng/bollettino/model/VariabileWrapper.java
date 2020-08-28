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
 * This class is a wrapper for {@link Variabile}.
 * </p>
 *
 * @author GFAVINI
 * @see Variabile
 * @generated
 */
@ProviderType
public class VariabileWrapper implements Variabile, ModelWrapper<Variabile> {

	public VariabileWrapper(Variabile variabile) {
		_variabile = variabile;
	}

	@Override
	public Class<?> getModelClass() {
		return Variabile.class;
	}

	@Override
	public String getModelClassName() {
		return Variabile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("description_it", getDescription_it());
		attributes.put("level_t1", getLevel_t1());
		attributes.put("level_t2", getLevel_t2());
		attributes.put("level_v1", getLevel_v1());
		attributes.put("level_v2", getLevel_v2());
		attributes.put("trange_p1", getTrange_p1());
		attributes.put("trange_p2", getTrange_p2());
		attributes.put("trange_pind", getTrange_pind());
		attributes.put("unit", getUnit());
		attributes.put("bcode", getBcode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String description_it = (String)attributes.get("description_it");

		if (description_it != null) {
			setDescription_it(description_it);
		}

		Integer level_t1 = (Integer)attributes.get("level_t1");

		if (level_t1 != null) {
			setLevel_t1(level_t1);
		}

		Integer level_t2 = (Integer)attributes.get("level_t2");

		if (level_t2 != null) {
			setLevel_t2(level_t2);
		}

		Integer level_v1 = (Integer)attributes.get("level_v1");

		if (level_v1 != null) {
			setLevel_v1(level_v1);
		}

		Integer level_v2 = (Integer)attributes.get("level_v2");

		if (level_v2 != null) {
			setLevel_v2(level_v2);
		}

		Integer trange_p1 = (Integer)attributes.get("trange_p1");

		if (trange_p1 != null) {
			setTrange_p1(trange_p1);
		}

		Integer trange_p2 = (Integer)attributes.get("trange_p2");

		if (trange_p2 != null) {
			setTrange_p2(trange_p2);
		}

		Integer trange_pind = (Integer)attributes.get("trange_pind");

		if (trange_pind != null) {
			setTrange_pind(trange_pind);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		String bcode = (String)attributes.get("bcode");

		if (bcode != null) {
			setBcode(bcode);
		}
	}

	@Override
	public Object clone() {
		return new VariabileWrapper((Variabile)_variabile.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Variabile variabile) {
		return _variabile.compareTo(variabile);
	}

	/**
	 * Returns the bcode of this variabile.
	 *
	 * @return the bcode of this variabile
	 */
	@Override
	public String getBcode() {
		return _variabile.getBcode();
	}

	/**
	 * Returns the description_it of this variabile.
	 *
	 * @return the description_it of this variabile
	 */
	@Override
	public String getDescription_it() {
		return _variabile.getDescription_it();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _variabile.getExpandoBridge();
	}

	/**
	 * Returns the ID of this variabile.
	 *
	 * @return the ID of this variabile
	 */
	@Override
	public String getId() {
		return _variabile.getId();
	}

	/**
	 * Returns the level_t1 of this variabile.
	 *
	 * @return the level_t1 of this variabile
	 */
	@Override
	public int getLevel_t1() {
		return _variabile.getLevel_t1();
	}

	/**
	 * Returns the level_t2 of this variabile.
	 *
	 * @return the level_t2 of this variabile
	 */
	@Override
	public int getLevel_t2() {
		return _variabile.getLevel_t2();
	}

	/**
	 * Returns the level_v1 of this variabile.
	 *
	 * @return the level_v1 of this variabile
	 */
	@Override
	public int getLevel_v1() {
		return _variabile.getLevel_v1();
	}

	/**
	 * Returns the level_v2 of this variabile.
	 *
	 * @return the level_v2 of this variabile
	 */
	@Override
	public int getLevel_v2() {
		return _variabile.getLevel_v2();
	}

	/**
	 * Returns the primary key of this variabile.
	 *
	 * @return the primary key of this variabile
	 */
	@Override
	public String getPrimaryKey() {
		return _variabile.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _variabile.getPrimaryKeyObj();
	}

	/**
	 * Returns the trange_p1 of this variabile.
	 *
	 * @return the trange_p1 of this variabile
	 */
	@Override
	public int getTrange_p1() {
		return _variabile.getTrange_p1();
	}

	/**
	 * Returns the trange_p2 of this variabile.
	 *
	 * @return the trange_p2 of this variabile
	 */
	@Override
	public int getTrange_p2() {
		return _variabile.getTrange_p2();
	}

	/**
	 * Returns the trange_pind of this variabile.
	 *
	 * @return the trange_pind of this variabile
	 */
	@Override
	public int getTrange_pind() {
		return _variabile.getTrange_pind();
	}

	/**
	 * Returns the unit of this variabile.
	 *
	 * @return the unit of this variabile
	 */
	@Override
	public String getUnit() {
		return _variabile.getUnit();
	}

	/**
	 * Returns the uuid of this variabile.
	 *
	 * @return the uuid of this variabile
	 */
	@Override
	public String getUuid() {
		return _variabile.getUuid();
	}

	@Override
	public int hashCode() {
		return _variabile.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _variabile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _variabile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _variabile.isNew();
	}

	@Override
	public void persist() {
		_variabile.persist();
	}

	/**
	 * Sets the bcode of this variabile.
	 *
	 * @param bcode the bcode of this variabile
	 */
	@Override
	public void setBcode(String bcode) {
		_variabile.setBcode(bcode);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_variabile.setCachedModel(cachedModel);
	}

	/**
	 * Sets the description_it of this variabile.
	 *
	 * @param description_it the description_it of this variabile
	 */
	@Override
	public void setDescription_it(String description_it) {
		_variabile.setDescription_it(description_it);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_variabile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_variabile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_variabile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this variabile.
	 *
	 * @param id the ID of this variabile
	 */
	@Override
	public void setId(String id) {
		_variabile.setId(id);
	}

	/**
	 * Sets the level_t1 of this variabile.
	 *
	 * @param level_t1 the level_t1 of this variabile
	 */
	@Override
	public void setLevel_t1(int level_t1) {
		_variabile.setLevel_t1(level_t1);
	}

	/**
	 * Sets the level_t2 of this variabile.
	 *
	 * @param level_t2 the level_t2 of this variabile
	 */
	@Override
	public void setLevel_t2(int level_t2) {
		_variabile.setLevel_t2(level_t2);
	}

	/**
	 * Sets the level_v1 of this variabile.
	 *
	 * @param level_v1 the level_v1 of this variabile
	 */
	@Override
	public void setLevel_v1(int level_v1) {
		_variabile.setLevel_v1(level_v1);
	}

	/**
	 * Sets the level_v2 of this variabile.
	 *
	 * @param level_v2 the level_v2 of this variabile
	 */
	@Override
	public void setLevel_v2(int level_v2) {
		_variabile.setLevel_v2(level_v2);
	}

	@Override
	public void setNew(boolean n) {
		_variabile.setNew(n);
	}

	/**
	 * Sets the primary key of this variabile.
	 *
	 * @param primaryKey the primary key of this variabile
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_variabile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_variabile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the trange_p1 of this variabile.
	 *
	 * @param trange_p1 the trange_p1 of this variabile
	 */
	@Override
	public void setTrange_p1(int trange_p1) {
		_variabile.setTrange_p1(trange_p1);
	}

	/**
	 * Sets the trange_p2 of this variabile.
	 *
	 * @param trange_p2 the trange_p2 of this variabile
	 */
	@Override
	public void setTrange_p2(int trange_p2) {
		_variabile.setTrange_p2(trange_p2);
	}

	/**
	 * Sets the trange_pind of this variabile.
	 *
	 * @param trange_pind the trange_pind of this variabile
	 */
	@Override
	public void setTrange_pind(int trange_pind) {
		_variabile.setTrange_pind(trange_pind);
	}

	/**
	 * Sets the unit of this variabile.
	 *
	 * @param unit the unit of this variabile
	 */
	@Override
	public void setUnit(String unit) {
		_variabile.setUnit(unit);
	}

	/**
	 * Sets the uuid of this variabile.
	 *
	 * @param uuid the uuid of this variabile
	 */
	@Override
	public void setUuid(String uuid) {
		_variabile.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Variabile> toCacheModel() {

		return _variabile.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Variabile toEscapedModel() {
		return new VariabileWrapper(_variabile.toEscapedModel());
	}

	@Override
	public String toString() {
		return _variabile.toString();
	}

	@Override
	public it.eng.bollettino.model.Variabile toUnescapedModel() {
		return new VariabileWrapper(_variabile.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _variabile.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VariabileWrapper)) {
			return false;
		}

		VariabileWrapper variabileWrapper = (VariabileWrapper)obj;

		if (Objects.equals(_variabile, variabileWrapper._variabile)) {
			return true;
		}

		return false;
	}

	@Override
	public Variabile getWrappedModel() {
		return _variabile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _variabile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _variabile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_variabile.resetOriginalValues();
	}

	private final Variabile _variabile;

}