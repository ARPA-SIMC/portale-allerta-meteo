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
 * This class is a wrapper for {@link Fonte}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Fonte
 * @generated
 */
@ProviderType
public class FonteWrapper implements Fonte, ModelWrapper<Fonte> {

	public FonteWrapper(Fonte fonte) {
		_fonte = fonte;
	}

	@Override
	public Class<?> getModelClass() {
		return Fonte.class;
	}

	@Override
	public String getModelClassName() {
		return Fonte.class.getName();
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
		return new FonteWrapper((Fonte)_fonte.clone());
	}

	@Override
	public int compareTo(allerta.catasto.model.Fonte fonte) {
		return _fonte.compareTo(fonte);
	}

	/**
	 * Returns the descrizione of this fonte.
	 *
	 * @return the descrizione of this fonte
	 */
	@Override
	public String getDescrizione() {
		return _fonte.getDescrizione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fonte.getExpandoBridge();
	}

	/**
	 * Returns the ID of this fonte.
	 *
	 * @return the ID of this fonte
	 */
	@Override
	public long getId() {
		return _fonte.getId();
	}

	/**
	 * Returns the primary key of this fonte.
	 *
	 * @return the primary key of this fonte
	 */
	@Override
	public long getPrimaryKey() {
		return _fonte.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fonte.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _fonte.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fonte.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fonte.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fonte.isNew();
	}

	@Override
	public void persist() {
		_fonte.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fonte.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this fonte.
	 *
	 * @param descrizione the descrizione of this fonte
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_fonte.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_fonte.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fonte.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fonte.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this fonte.
	 *
	 * @param id the ID of this fonte
	 */
	@Override
	public void setId(long id) {
		_fonte.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_fonte.setNew(n);
	}

	/**
	 * Sets the primary key of this fonte.
	 *
	 * @param primaryKey the primary key of this fonte
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fonte.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fonte.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.catasto.model.Fonte> toCacheModel() {

		return _fonte.toCacheModel();
	}

	@Override
	public allerta.catasto.model.Fonte toEscapedModel() {
		return new FonteWrapper(_fonte.toEscapedModel());
	}

	@Override
	public String toString() {
		return _fonte.toString();
	}

	@Override
	public allerta.catasto.model.Fonte toUnescapedModel() {
		return new FonteWrapper(_fonte.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _fonte.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FonteWrapper)) {
			return false;
		}

		FonteWrapper fonteWrapper = (FonteWrapper)obj;

		if (Objects.equals(_fonte, fonteWrapper._fonte)) {
			return true;
		}

		return false;
	}

	@Override
	public Fonte getWrappedModel() {
		return _fonte;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fonte.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fonte.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fonte.resetOriginalValues();
	}

	private final Fonte _fonte;

}