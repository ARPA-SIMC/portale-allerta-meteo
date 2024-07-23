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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AllertaValangheStato service. Represents a row in the &quot;ALLERTER_AllertaValangheStato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.allerter.model.impl.AllertaValangheStatoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.allerter.model.impl.AllertaValangheStatoImpl</code>.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValangheStato
 * @generated
 */
@ProviderType
public interface AllertaValangheStatoModel
	extends BaseModel<AllertaValangheStato>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a allerta valanghe stato model instance should use the {@link AllertaValangheStato} interface instead.
	 */

	/**
	 * Returns the primary key of this allerta valanghe stato.
	 *
	 * @return the primary key of this allerta valanghe stato
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this allerta valanghe stato.
	 *
	 * @param primaryKey the primary key of this allerta valanghe stato
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this allerta valanghe stato.
	 *
	 * @return the uuid of this allerta valanghe stato
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this allerta valanghe stato.
	 *
	 * @param uuid the uuid of this allerta valanghe stato
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the allerta valanghe stato ID of this allerta valanghe stato.
	 *
	 * @return the allerta valanghe stato ID of this allerta valanghe stato
	 */
	public long getAllertaValangheStatoId();

	/**
	 * Sets the allerta valanghe stato ID of this allerta valanghe stato.
	 *
	 * @param allertaValangheStatoId the allerta valanghe stato ID of this allerta valanghe stato
	 */
	public void setAllertaValangheStatoId(long allertaValangheStatoId);

	/**
	 * Returns the group ID of this allerta valanghe stato.
	 *
	 * @return the group ID of this allerta valanghe stato
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this allerta valanghe stato.
	 *
	 * @param groupId the group ID of this allerta valanghe stato
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this allerta valanghe stato.
	 *
	 * @return the company ID of this allerta valanghe stato
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this allerta valanghe stato.
	 *
	 * @param companyId the company ID of this allerta valanghe stato
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this allerta valanghe stato.
	 *
	 * @return the user ID of this allerta valanghe stato
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this allerta valanghe stato.
	 *
	 * @param userId the user ID of this allerta valanghe stato
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this allerta valanghe stato.
	 *
	 * @return the user uuid of this allerta valanghe stato
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this allerta valanghe stato.
	 *
	 * @param userUuid the user uuid of this allerta valanghe stato
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this allerta valanghe stato.
	 *
	 * @return the user name of this allerta valanghe stato
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this allerta valanghe stato.
	 *
	 * @param userName the user name of this allerta valanghe stato
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this allerta valanghe stato.
	 *
	 * @return the create date of this allerta valanghe stato
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this allerta valanghe stato.
	 *
	 * @param createDate the create date of this allerta valanghe stato
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this allerta valanghe stato.
	 *
	 * @return the modified date of this allerta valanghe stato
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this allerta valanghe stato.
	 *
	 * @param modifiedDate the modified date of this allerta valanghe stato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nome of this allerta valanghe stato.
	 *
	 * @return the nome of this allerta valanghe stato
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this allerta valanghe stato.
	 *
	 * @param nome the nome of this allerta valanghe stato
	 */
	public void setNome(String nome);

	/**
	 * Returns the data inizio of this allerta valanghe stato.
	 *
	 * @return the data inizio of this allerta valanghe stato
	 */
	public Date getDataInizio();

	/**
	 * Sets the data inizio of this allerta valanghe stato.
	 *
	 * @param dataInizio the data inizio of this allerta valanghe stato
	 */
	public void setDataInizio(Date dataInizio);

	/**
	 * Returns the data fine of this allerta valanghe stato.
	 *
	 * @return the data fine of this allerta valanghe stato
	 */
	public Date getDataFine();

	/**
	 * Sets the data fine of this allerta valanghe stato.
	 *
	 * @param dataFine the data fine of this allerta valanghe stato
	 */
	public void setDataFine(Date dataFine);

	/**
	 * Returns the parent ID of this allerta valanghe stato.
	 *
	 * @return the parent ID of this allerta valanghe stato
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this allerta valanghe stato.
	 *
	 * @param parentId the parent ID of this allerta valanghe stato
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the allerta valanghe ID of this allerta valanghe stato.
	 *
	 * @return the allerta valanghe ID of this allerta valanghe stato
	 */
	public long getAllertaValangheId();

	/**
	 * Sets the allerta valanghe ID of this allerta valanghe stato.
	 *
	 * @param allertaValangheId the allerta valanghe ID of this allerta valanghe stato
	 */
	public void setAllertaValangheId(long allertaValangheId);

	/**
	 * Returns the stato ID of this allerta valanghe stato.
	 *
	 * @return the stato ID of this allerta valanghe stato
	 */
	public long getStatoId();

	/**
	 * Sets the stato ID of this allerta valanghe stato.
	 *
	 * @param statoId the stato ID of this allerta valanghe stato
	 */
	public void setStatoId(long statoId);

	/**
	 * Returns the evento ID of this allerta valanghe stato.
	 *
	 * @return the evento ID of this allerta valanghe stato
	 */
	public long getEventoId();

	/**
	 * Sets the evento ID of this allerta valanghe stato.
	 *
	 * @param eventoId the evento ID of this allerta valanghe stato
	 */
	public void setEventoId(long eventoId);

	/**
	 * Returns the area ID of this allerta valanghe stato.
	 *
	 * @return the area ID of this allerta valanghe stato
	 */
	public long getAreaId();

	/**
	 * Sets the area ID of this allerta valanghe stato.
	 *
	 * @param areaId the area ID of this allerta valanghe stato
	 */
	public void setAreaId(long areaId);

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
		it.eng.allerter.model.AllertaValangheStato allertaValangheStato);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.allerter.model.AllertaValangheStato>
		toCacheModel();

	@Override
	public it.eng.allerter.model.AllertaValangheStato toEscapedModel();

	@Override
	public it.eng.allerter.model.AllertaValangheStato toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}