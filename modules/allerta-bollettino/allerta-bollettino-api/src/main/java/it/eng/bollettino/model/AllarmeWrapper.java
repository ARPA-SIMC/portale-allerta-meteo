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
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Allarme}.
 * </p>
 *
 * @author GFAVINI
 * @see Allarme
 * @generated
 */
@ProviderType
public class AllarmeWrapper implements Allarme, ModelWrapper<Allarme> {

	public AllarmeWrapper(Allarme allarme) {
		_allarme = allarme;
	}

	@Override
	public Class<?> getModelClass() {
		return Allarme.class;
	}

	@Override
	public String getModelClassName() {
		return Allarme.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allarmeId", getAllarmeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stato", getStato());
		attributes.put("idApprovatore", getIdApprovatore());
		attributes.put("dataApprovazione", getDataApprovazione());
		attributes.put("idRegola", getIdRegola());
		attributes.put("colore", getColore());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allarmeId = (Long)attributes.get("allarmeId");

		if (allarmeId != null) {
			setAllarmeId(allarmeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Long idApprovatore = (Long)attributes.get("idApprovatore");

		if (idApprovatore != null) {
			setIdApprovatore(idApprovatore);
		}

		Date dataApprovazione = (Date)attributes.get("dataApprovazione");

		if (dataApprovazione != null) {
			setDataApprovazione(dataApprovazione);
		}

		Long idRegola = (Long)attributes.get("idRegola");

		if (idRegola != null) {
			setIdRegola(idRegola);
		}

		Integer colore = (Integer)attributes.get("colore");

		if (colore != null) {
			setColore(colore);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}
	}

	@Override
	public Object clone() {
		return new AllarmeWrapper((Allarme)_allarme.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Allarme allarme) {
		return _allarme.compareTo(allarme);
	}

	/**
	 * Returns the allarme ID of this allarme.
	 *
	 * @return the allarme ID of this allarme
	 */
	@Override
	public long getAllarmeId() {
		return _allarme.getAllarmeId();
	}

	/**
	 * Returns the colore of this allarme.
	 *
	 * @return the colore of this allarme
	 */
	@Override
	public int getColore() {
		return _allarme.getColore();
	}

	/**
	 * Returns the company ID of this allarme.
	 *
	 * @return the company ID of this allarme
	 */
	@Override
	public long getCompanyId() {
		return _allarme.getCompanyId();
	}

	/**
	 * Returns the create date of this allarme.
	 *
	 * @return the create date of this allarme
	 */
	@Override
	public Date getCreateDate() {
		return _allarme.getCreateDate();
	}

	/**
	 * Returns the data approvazione of this allarme.
	 *
	 * @return the data approvazione of this allarme
	 */
	@Override
	public Date getDataApprovazione() {
		return _allarme.getDataApprovazione();
	}

	/**
	 * Returns the data fine of this allarme.
	 *
	 * @return the data fine of this allarme
	 */
	@Override
	public Date getDataFine() {
		return _allarme.getDataFine();
	}

	/**
	 * Returns the data inizio of this allarme.
	 *
	 * @return the data inizio of this allarme
	 */
	@Override
	public Date getDataInizio() {
		return _allarme.getDataInizio();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _allarme.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this allarme.
	 *
	 * @return the group ID of this allarme
	 */
	@Override
	public long getGroupId() {
		return _allarme.getGroupId();
	}

	/**
	 * Returns the id approvatore of this allarme.
	 *
	 * @return the id approvatore of this allarme
	 */
	@Override
	public long getIdApprovatore() {
		return _allarme.getIdApprovatore();
	}

	/**
	 * Returns the id regola of this allarme.
	 *
	 * @return the id regola of this allarme
	 */
	@Override
	public long getIdRegola() {
		return _allarme.getIdRegola();
	}

	/**
	 * Returns the modified date of this allarme.
	 *
	 * @return the modified date of this allarme
	 */
	@Override
	public Date getModifiedDate() {
		return _allarme.getModifiedDate();
	}

	/**
	 * Returns the primary key of this allarme.
	 *
	 * @return the primary key of this allarme
	 */
	@Override
	public long getPrimaryKey() {
		return _allarme.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _allarme.getPrimaryKeyObj();
	}

	/**
	 * Returns the stato of this allarme.
	 *
	 * @return the stato of this allarme
	 */
	@Override
	public int getStato() {
		return _allarme.getStato();
	}

	/**
	 * Returns the user ID of this allarme.
	 *
	 * @return the user ID of this allarme
	 */
	@Override
	public long getUserId() {
		return _allarme.getUserId();
	}

	/**
	 * Returns the user name of this allarme.
	 *
	 * @return the user name of this allarme
	 */
	@Override
	public String getUserName() {
		return _allarme.getUserName();
	}

	/**
	 * Returns the user uuid of this allarme.
	 *
	 * @return the user uuid of this allarme
	 */
	@Override
	public String getUserUuid() {
		return _allarme.getUserUuid();
	}

	/**
	 * Returns the uuid of this allarme.
	 *
	 * @return the uuid of this allarme
	 */
	@Override
	public String getUuid() {
		return _allarme.getUuid();
	}

	@Override
	public int hashCode() {
		return _allarme.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _allarme.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _allarme.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _allarme.isNew();
	}

	@Override
	public void persist() {
		_allarme.persist();
	}

	/**
	 * Sets the allarme ID of this allarme.
	 *
	 * @param allarmeId the allarme ID of this allarme
	 */
	@Override
	public void setAllarmeId(long allarmeId) {
		_allarme.setAllarmeId(allarmeId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_allarme.setCachedModel(cachedModel);
	}

	/**
	 * Sets the colore of this allarme.
	 *
	 * @param colore the colore of this allarme
	 */
	@Override
	public void setColore(int colore) {
		_allarme.setColore(colore);
	}

	/**
	 * Sets the company ID of this allarme.
	 *
	 * @param companyId the company ID of this allarme
	 */
	@Override
	public void setCompanyId(long companyId) {
		_allarme.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allarme.
	 *
	 * @param createDate the create date of this allarme
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_allarme.setCreateDate(createDate);
	}

	/**
	 * Sets the data approvazione of this allarme.
	 *
	 * @param dataApprovazione the data approvazione of this allarme
	 */
	@Override
	public void setDataApprovazione(Date dataApprovazione) {
		_allarme.setDataApprovazione(dataApprovazione);
	}

	/**
	 * Sets the data fine of this allarme.
	 *
	 * @param dataFine the data fine of this allarme
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_allarme.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this allarme.
	 *
	 * @param dataInizio the data inizio of this allarme
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_allarme.setDataInizio(dataInizio);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_allarme.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_allarme.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_allarme.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this allarme.
	 *
	 * @param groupId the group ID of this allarme
	 */
	@Override
	public void setGroupId(long groupId) {
		_allarme.setGroupId(groupId);
	}

	/**
	 * Sets the id approvatore of this allarme.
	 *
	 * @param idApprovatore the id approvatore of this allarme
	 */
	@Override
	public void setIdApprovatore(long idApprovatore) {
		_allarme.setIdApprovatore(idApprovatore);
	}

	/**
	 * Sets the id regola of this allarme.
	 *
	 * @param idRegola the id regola of this allarme
	 */
	@Override
	public void setIdRegola(long idRegola) {
		_allarme.setIdRegola(idRegola);
	}

	/**
	 * Sets the modified date of this allarme.
	 *
	 * @param modifiedDate the modified date of this allarme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_allarme.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_allarme.setNew(n);
	}

	/**
	 * Sets the primary key of this allarme.
	 *
	 * @param primaryKey the primary key of this allarme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_allarme.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_allarme.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the stato of this allarme.
	 *
	 * @param stato the stato of this allarme
	 */
	@Override
	public void setStato(int stato) {
		_allarme.setStato(stato);
	}

	/**
	 * Sets the user ID of this allarme.
	 *
	 * @param userId the user ID of this allarme
	 */
	@Override
	public void setUserId(long userId) {
		_allarme.setUserId(userId);
	}

	/**
	 * Sets the user name of this allarme.
	 *
	 * @param userName the user name of this allarme
	 */
	@Override
	public void setUserName(String userName) {
		_allarme.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allarme.
	 *
	 * @param userUuid the user uuid of this allarme
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_allarme.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allarme.
	 *
	 * @param uuid the uuid of this allarme
	 */
	@Override
	public void setUuid(String uuid) {
		_allarme.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Allarme> toCacheModel() {

		return _allarme.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Allarme toEscapedModel() {
		return new AllarmeWrapper(_allarme.toEscapedModel());
	}

	@Override
	public String toString() {
		return _allarme.toString();
	}

	@Override
	public it.eng.bollettino.model.Allarme toUnescapedModel() {
		return new AllarmeWrapper(_allarme.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _allarme.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllarmeWrapper)) {
			return false;
		}

		AllarmeWrapper allarmeWrapper = (AllarmeWrapper)obj;

		if (Objects.equals(_allarme, allarmeWrapper._allarme)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _allarme.getStagedModelType();
	}

	@Override
	public Allarme getWrappedModel() {
		return _allarme;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _allarme.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _allarme.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_allarme.resetOriginalValues();
	}

	private final Allarme _allarme;

}