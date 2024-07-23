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

package allerta.verifica.model;

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
 * This class is a wrapper for {@link Verifica}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Verifica
 * @generated
 */
@ProviderType
public class VerificaWrapper implements Verifica, ModelWrapper<Verifica> {

	public VerificaWrapper(Verifica verifica) {
		_verifica = verifica;
	}

	@Override
	public Class<?> getModelClass() {
		return Verifica.class;
	}

	@Override
	public String getModelClassName() {
		return Verifica.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documento", getDocumento());
		attributes.put("stato", getStato());
		attributes.put("titolo", getTitolo());
		attributes.put("fenomeni", getFenomeni());
		attributes.put("fenomeniDescritti", getFenomeniDescritti());
		attributes.put("note", getNote());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("link", getLink());
		attributes.put("hash", getHash());

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

		Long documento = (Long)attributes.get("documento");

		if (documento != null) {
			setDocumento(documento);
		}

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String fenomeni = (String)attributes.get("fenomeni");

		if (fenomeni != null) {
			setFenomeni(fenomeni);
		}

		String fenomeniDescritti = (String)attributes.get("fenomeniDescritti");

		if (fenomeniDescritti != null) {
			setFenomeniDescritti(fenomeniDescritti);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public Object clone() {
		return new VerificaWrapper((Verifica)_verifica.clone());
	}

	@Override
	public int compareTo(allerta.verifica.model.Verifica verifica) {
		return _verifica.compareTo(verifica);
	}

	/**
	 * Returns the company ID of this verifica.
	 *
	 * @return the company ID of this verifica
	 */
	@Override
	public long getCompanyId() {
		return _verifica.getCompanyId();
	}

	/**
	 * Returns the create date of this verifica.
	 *
	 * @return the create date of this verifica
	 */
	@Override
	public Date getCreateDate() {
		return _verifica.getCreateDate();
	}

	/**
	 * Returns the data fine of this verifica.
	 *
	 * @return the data fine of this verifica
	 */
	@Override
	public Date getDataFine() {
		return _verifica.getDataFine();
	}

	/**
	 * Returns the data inizio of this verifica.
	 *
	 * @return the data inizio of this verifica
	 */
	@Override
	public Date getDataInizio() {
		return _verifica.getDataInizio();
	}

	/**
	 * Returns the documento of this verifica.
	 *
	 * @return the documento of this verifica
	 */
	@Override
	public long getDocumento() {
		return _verifica.getDocumento();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _verifica.getExpandoBridge();
	}

	/**
	 * Returns the fenomeni of this verifica.
	 *
	 * @return the fenomeni of this verifica
	 */
	@Override
	public String getFenomeni() {
		return _verifica.getFenomeni();
	}

	/**
	 * Returns the fenomeni descritti of this verifica.
	 *
	 * @return the fenomeni descritti of this verifica
	 */
	@Override
	public String getFenomeniDescritti() {
		return _verifica.getFenomeniDescritti();
	}

	/**
	 * Returns the group ID of this verifica.
	 *
	 * @return the group ID of this verifica
	 */
	@Override
	public long getGroupId() {
		return _verifica.getGroupId();
	}

	/**
	 * Returns the hash of this verifica.
	 *
	 * @return the hash of this verifica
	 */
	@Override
	public String getHash() {
		return _verifica.getHash();
	}

	/**
	 * Returns the ID of this verifica.
	 *
	 * @return the ID of this verifica
	 */
	@Override
	public long getId() {
		return _verifica.getId();
	}

	/**
	 * Returns the link of this verifica.
	 *
	 * @return the link of this verifica
	 */
	@Override
	public String getLink() {
		return _verifica.getLink();
	}

	/**
	 * Returns the modified date of this verifica.
	 *
	 * @return the modified date of this verifica
	 */
	@Override
	public Date getModifiedDate() {
		return _verifica.getModifiedDate();
	}

	/**
	 * Returns the note of this verifica.
	 *
	 * @return the note of this verifica
	 */
	@Override
	public String getNote() {
		return _verifica.getNote();
	}

	/**
	 * Returns the primary key of this verifica.
	 *
	 * @return the primary key of this verifica
	 */
	@Override
	public long getPrimaryKey() {
		return _verifica.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _verifica.getPrimaryKeyObj();
	}

	/**
	 * Returns the stato of this verifica.
	 *
	 * @return the stato of this verifica
	 */
	@Override
	public int getStato() {
		return _verifica.getStato();
	}

	/**
	 * Returns the titolo of this verifica.
	 *
	 * @return the titolo of this verifica
	 */
	@Override
	public String getTitolo() {
		return _verifica.getTitolo();
	}

	/**
	 * Returns the user ID of this verifica.
	 *
	 * @return the user ID of this verifica
	 */
	@Override
	public long getUserId() {
		return _verifica.getUserId();
	}

	/**
	 * Returns the user name of this verifica.
	 *
	 * @return the user name of this verifica
	 */
	@Override
	public String getUserName() {
		return _verifica.getUserName();
	}

	/**
	 * Returns the user uuid of this verifica.
	 *
	 * @return the user uuid of this verifica
	 */
	@Override
	public String getUserUuid() {
		return _verifica.getUserUuid();
	}

	/**
	 * Returns the uuid of this verifica.
	 *
	 * @return the uuid of this verifica
	 */
	@Override
	public String getUuid() {
		return _verifica.getUuid();
	}

	@Override
	public int hashCode() {
		return _verifica.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _verifica.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _verifica.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _verifica.isNew();
	}

	@Override
	public void persist() {
		_verifica.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_verifica.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this verifica.
	 *
	 * @param companyId the company ID of this verifica
	 */
	@Override
	public void setCompanyId(long companyId) {
		_verifica.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this verifica.
	 *
	 * @param createDate the create date of this verifica
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_verifica.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this verifica.
	 *
	 * @param dataFine the data fine of this verifica
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_verifica.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this verifica.
	 *
	 * @param dataInizio the data inizio of this verifica
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_verifica.setDataInizio(dataInizio);
	}

	/**
	 * Sets the documento of this verifica.
	 *
	 * @param documento the documento of this verifica
	 */
	@Override
	public void setDocumento(long documento) {
		_verifica.setDocumento(documento);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_verifica.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_verifica.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_verifica.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fenomeni of this verifica.
	 *
	 * @param fenomeni the fenomeni of this verifica
	 */
	@Override
	public void setFenomeni(String fenomeni) {
		_verifica.setFenomeni(fenomeni);
	}

	/**
	 * Sets the fenomeni descritti of this verifica.
	 *
	 * @param fenomeniDescritti the fenomeni descritti of this verifica
	 */
	@Override
	public void setFenomeniDescritti(String fenomeniDescritti) {
		_verifica.setFenomeniDescritti(fenomeniDescritti);
	}

	/**
	 * Sets the group ID of this verifica.
	 *
	 * @param groupId the group ID of this verifica
	 */
	@Override
	public void setGroupId(long groupId) {
		_verifica.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this verifica.
	 *
	 * @param hash the hash of this verifica
	 */
	@Override
	public void setHash(String hash) {
		_verifica.setHash(hash);
	}

	/**
	 * Sets the ID of this verifica.
	 *
	 * @param id the ID of this verifica
	 */
	@Override
	public void setId(long id) {
		_verifica.setId(id);
	}

	/**
	 * Sets the link of this verifica.
	 *
	 * @param link the link of this verifica
	 */
	@Override
	public void setLink(String link) {
		_verifica.setLink(link);
	}

	/**
	 * Sets the modified date of this verifica.
	 *
	 * @param modifiedDate the modified date of this verifica
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_verifica.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_verifica.setNew(n);
	}

	/**
	 * Sets the note of this verifica.
	 *
	 * @param note the note of this verifica
	 */
	@Override
	public void setNote(String note) {
		_verifica.setNote(note);
	}

	/**
	 * Sets the primary key of this verifica.
	 *
	 * @param primaryKey the primary key of this verifica
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_verifica.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_verifica.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the stato of this verifica.
	 *
	 * @param stato the stato of this verifica
	 */
	@Override
	public void setStato(int stato) {
		_verifica.setStato(stato);
	}

	/**
	 * Sets the titolo of this verifica.
	 *
	 * @param titolo the titolo of this verifica
	 */
	@Override
	public void setTitolo(String titolo) {
		_verifica.setTitolo(titolo);
	}

	/**
	 * Sets the user ID of this verifica.
	 *
	 * @param userId the user ID of this verifica
	 */
	@Override
	public void setUserId(long userId) {
		_verifica.setUserId(userId);
	}

	/**
	 * Sets the user name of this verifica.
	 *
	 * @param userName the user name of this verifica
	 */
	@Override
	public void setUserName(String userName) {
		_verifica.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this verifica.
	 *
	 * @param userUuid the user uuid of this verifica
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_verifica.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this verifica.
	 *
	 * @param uuid the uuid of this verifica
	 */
	@Override
	public void setUuid(String uuid) {
		_verifica.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.verifica.model.Verifica> toCacheModel() {

		return _verifica.toCacheModel();
	}

	@Override
	public allerta.verifica.model.Verifica toEscapedModel() {
		return new VerificaWrapper(_verifica.toEscapedModel());
	}

	@Override
	public String toString() {
		return _verifica.toString();
	}

	@Override
	public allerta.verifica.model.Verifica toUnescapedModel() {
		return new VerificaWrapper(_verifica.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _verifica.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VerificaWrapper)) {
			return false;
		}

		VerificaWrapper verificaWrapper = (VerificaWrapper)obj;

		if (Objects.equals(_verifica, verificaWrapper._verifica)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _verifica.getStagedModelType();
	}

	@Override
	public Verifica getWrappedModel() {
		return _verifica;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _verifica.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _verifica.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_verifica.resetOriginalValues();
	}

	private final Verifica _verifica;

}