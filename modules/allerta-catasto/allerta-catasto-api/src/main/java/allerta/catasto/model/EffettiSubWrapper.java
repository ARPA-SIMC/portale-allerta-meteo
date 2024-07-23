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
 * This class is a wrapper for {@link EffettiSub}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSub
 * @generated
 */
@ProviderType
public class EffettiSubWrapper implements EffettiSub, ModelWrapper<EffettiSub> {

	public EffettiSubWrapper(EffettiSub effettiSub) {
		_effettiSub = effettiSub;
	}

	@Override
	public Class<?> getModelClass() {
		return EffettiSub.class;
	}

	@Override
	public String getModelClassName() {
		return EffettiSub.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idEffetti", getIdEffetti());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idEffetti = (Long)attributes.get("idEffetti");

		if (idEffetti != null) {
			setIdEffetti(idEffetti);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Object clone() {
		return new EffettiSubWrapper((EffettiSub)_effettiSub.clone());
	}

	@Override
	public int compareTo(allerta.catasto.model.EffettiSub effettiSub) {
		return _effettiSub.compareTo(effettiSub);
	}

	/**
	 * Returns the descrizione of this effetti sub.
	 *
	 * @return the descrizione of this effetti sub
	 */
	@Override
	public String getDescrizione() {
		return _effettiSub.getDescrizione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _effettiSub.getExpandoBridge();
	}

	/**
	 * Returns the ID of this effetti sub.
	 *
	 * @return the ID of this effetti sub
	 */
	@Override
	public long getId() {
		return _effettiSub.getId();
	}

	/**
	 * Returns the id effetti of this effetti sub.
	 *
	 * @return the id effetti of this effetti sub
	 */
	@Override
	public long getIdEffetti() {
		return _effettiSub.getIdEffetti();
	}

	/**
	 * Returns the primary key of this effetti sub.
	 *
	 * @return the primary key of this effetti sub
	 */
	@Override
	public allerta.catasto.service.persistence.EffettiSubPK getPrimaryKey() {
		return _effettiSub.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _effettiSub.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _effettiSub.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _effettiSub.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _effettiSub.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _effettiSub.isNew();
	}

	@Override
	public void persist() {
		_effettiSub.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_effettiSub.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this effetti sub.
	 *
	 * @param descrizione the descrizione of this effetti sub
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_effettiSub.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_effettiSub.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_effettiSub.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_effettiSub.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this effetti sub.
	 *
	 * @param id the ID of this effetti sub
	 */
	@Override
	public void setId(long id) {
		_effettiSub.setId(id);
	}

	/**
	 * Sets the id effetti of this effetti sub.
	 *
	 * @param idEffetti the id effetti of this effetti sub
	 */
	@Override
	public void setIdEffetti(long idEffetti) {
		_effettiSub.setIdEffetti(idEffetti);
	}

	@Override
	public void setNew(boolean n) {
		_effettiSub.setNew(n);
	}

	/**
	 * Sets the primary key of this effetti sub.
	 *
	 * @param primaryKey the primary key of this effetti sub
	 */
	@Override
	public void setPrimaryKey(
		allerta.catasto.service.persistence.EffettiSubPK primaryKey) {

		_effettiSub.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_effettiSub.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.catasto.model.EffettiSub> toCacheModel() {

		return _effettiSub.toCacheModel();
	}

	@Override
	public allerta.catasto.model.EffettiSub toEscapedModel() {
		return new EffettiSubWrapper(_effettiSub.toEscapedModel());
	}

	@Override
	public String toString() {
		return _effettiSub.toString();
	}

	@Override
	public allerta.catasto.model.EffettiSub toUnescapedModel() {
		return new EffettiSubWrapper(_effettiSub.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _effettiSub.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EffettiSubWrapper)) {
			return false;
		}

		EffettiSubWrapper effettiSubWrapper = (EffettiSubWrapper)obj;

		if (Objects.equals(_effettiSub, effettiSubWrapper._effettiSub)) {
			return true;
		}

		return false;
	}

	@Override
	public EffettiSub getWrappedModel() {
		return _effettiSub;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _effettiSub.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _effettiSub.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_effettiSub.resetOriginalValues();
	}

	private final EffettiSub _effettiSub;

}