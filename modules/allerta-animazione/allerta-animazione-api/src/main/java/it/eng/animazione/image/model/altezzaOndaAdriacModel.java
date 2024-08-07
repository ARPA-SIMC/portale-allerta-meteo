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

package it.eng.animazione.image.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the altezzaOndaAdriac service. Represents a row in the &quot;img_animazioni_altezzaOndaAdriac&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacImpl</code>.
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaAdriac
 * @generated
 */
@ProviderType
public interface altezzaOndaAdriacModel extends BaseModel<altezzaOndaAdriac> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a altezza onda adriac model instance should use the {@link altezzaOndaAdriac} interface instead.
	 */

	/**
	 * Returns the primary key of this altezza onda adriac.
	 *
	 * @return the primary key of this altezza onda adriac
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this altezza onda adriac.
	 *
	 * @param primaryKey the primary key of this altezza onda adriac
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this altezza onda adriac.
	 *
	 * @return the ID of this altezza onda adriac
	 */
	public long getId();

	/**
	 * Sets the ID of this altezza onda adriac.
	 *
	 * @param id the ID of this altezza onda adriac
	 */
	public void setId(long id);

	/**
	 * Returns the im of this altezza onda adriac.
	 *
	 * @return the im of this altezza onda adriac
	 */
	@AutoEscape
	public String getIm();

	/**
	 * Sets the im of this altezza onda adriac.
	 *
	 * @param im the im of this altezza onda adriac
	 */
	public void setIm(String im);

	/**
	 * Returns the text_loc of this altezza onda adriac.
	 *
	 * @return the text_loc of this altezza onda adriac
	 */
	@AutoEscape
	public String getText_LOC();

	/**
	 * Sets the text_loc of this altezza onda adriac.
	 *
	 * @param text_LOC the text_loc of this altezza onda adriac
	 */
	public void setText_LOC(String text_LOC);

	/**
	 * Returns the ts_utc of this altezza onda adriac.
	 *
	 * @return the ts_utc of this altezza onda adriac
	 */
	public long getTs_UTC();

	/**
	 * Sets the ts_utc of this altezza onda adriac.
	 *
	 * @param ts_UTC the ts_utc of this altezza onda adriac
	 */
	public void setTs_UTC(long ts_UTC);

	/**
	 * Returns the img data of this altezza onda adriac.
	 *
	 * @return the img data of this altezza onda adriac
	 */
	@AutoEscape
	public String getImgData();

	/**
	 * Sets the img data of this altezza onda adriac.
	 *
	 * @param imgData the img data of this altezza onda adriac
	 */
	public void setImgData(String imgData);

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
	public int compareTo(
		it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.animazione.image.model.altezzaOndaAdriac>
		toCacheModel();

	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac toEscapedModel();

	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}