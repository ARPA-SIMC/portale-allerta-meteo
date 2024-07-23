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

package allerta.catasto.model;

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
 * This class is a wrapper for {@link Effetti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Effetti
 * @generated
 */
@ProviderType
public class EffettiWrapper implements Effetti, ModelWrapper<Effetti> {

	public EffettiWrapper(Effetti effetti) {
		_effetti = effetti;
	}

	@Override
	public Class<?> getModelClass() {
		return Effetti.class;
	}

	@Override
	public String getModelClassName() {
		return Effetti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Object clone() {
		return new EffettiWrapper((Effetti)_effetti.clone());
	}

	@Override
	public int compareTo(allerta.catasto.model.Effetti effetti) {
		return _effetti.compareTo(effetti);
	}

	/**
	 * Returns the descrizione of this effetti.
	 *
	 * @return the descrizione of this effetti
	 */
	@Override
	public String getDescrizione() {
		return _effetti.getDescrizione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _effetti.getExpandoBridge();
	}

	/**
	 * Returns the ID of this effetti.
	 *
	 * @return the ID of this effetti
	 */
	@Override
	public long getId() {
		return _effetti.getId();
	}

	/**
	 * Returns the primary key of this effetti.
	 *
	 * @return the primary key of this effetti
	 */
	@Override
	public long getPrimaryKey() {
		return _effetti.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _effetti.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _effetti.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _effetti.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _effetti.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _effetti.isNew();
	}

	@Override
	public void persist() {
		_effetti.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_effetti.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this effetti.
	 *
	 * @param descrizione the descrizione of this effetti
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_effetti.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_effetti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_effetti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_effetti.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this effetti.
	 *
	 * @param id the ID of this effetti
	 */
	@Override
	public void setId(long id) {
		_effetti.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_effetti.setNew(n);
	}

	/**
	 * Sets the primary key of this effetti.
	 *
	 * @param primaryKey the primary key of this effetti
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_effetti.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_effetti.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.catasto.model.Effetti> toCacheModel() {

		return _effetti.toCacheModel();
	}

	@Override
	public allerta.catasto.model.Effetti toEscapedModel() {
		return new EffettiWrapper(_effetti.toEscapedModel());
	}

	@Override
	public String toString() {
		return _effetti.toString();
	}

	@Override
	public allerta.catasto.model.Effetti toUnescapedModel() {
		return new EffettiWrapper(_effetti.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _effetti.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EffettiWrapper)) {
			return false;
		}

		EffettiWrapper effettiWrapper = (EffettiWrapper)obj;

		if (Objects.equals(_effetti, effettiWrapper._effetti)) {
			return true;
		}

		return false;
	}

	@Override
	public Effetti getWrappedModel() {
		return _effetti;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _effetti.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _effetti.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_effetti.resetOriginalValues();
	}

	private final Effetti _effetti;

}