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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Effetti service. Represents a row in the &quot;CATASTO_Effetti&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>allerta.catasto.model.impl.EffettiModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>allerta.catasto.model.impl.EffettiImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Effetti
 * @generated
 */
@ProviderType
public interface EffettiModel extends BaseModel<Effetti> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a effetti model instance should use the {@link Effetti} interface instead.
	 */

	/**
	 * Returns the primary key of this effetti.
	 *
	 * @return the primary key of this effetti
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this effetti.
	 *
	 * @param primaryKey the primary key of this effetti
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this effetti.
	 *
	 * @return the ID of this effetti
	 */
	public long getId();

	/**
	 * Sets the ID of this effetti.
	 *
	 * @param id the ID of this effetti
	 */
	public void setId(long id);

	/**
	 * Returns the descrizione of this effetti.
	 *
	 * @return the descrizione of this effetti
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this effetti.
	 *
	 * @param descrizione the descrizione of this effetti
	 */
	public void setDescrizione(String descrizione);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(allerta.catasto.model.Effetti effetti);

	@Override
	public int hashCode();

	@Override
	public CacheModel<allerta.catasto.model.Effetti> toCacheModel();

	@Override
	public allerta.catasto.model.Effetti toEscapedModel();

	@Override
	public allerta.catasto.model.Effetti toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}