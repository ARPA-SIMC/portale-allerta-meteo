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
 * This class is a wrapper for {@link AllertaValanghe}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValanghe
 * @generated
 */
@ProviderType
public class AllertaValangheWrapper
	implements AllertaValanghe, ModelWrapper<AllertaValanghe> {

	public AllertaValangheWrapper(AllertaValanghe allertaValanghe) {
		_allertaValanghe = allertaValanghe;
	}

	@Override
	public Class<?> getModelClass() {
		return AllertaValanghe.class;
	}

	@Override
	public String getModelClassName() {
		return AllertaValanghe.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaValangheId", getAllertaValangheId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("creatorName", getCreatorName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dataEmissione", getDataEmissione());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("numero", getNumero());
		attributes.put("progressivo", getProgressivo());
		attributes.put("anno", getAnno());
		attributes.put("titolo", getTitolo());
		attributes.put("descrizioneFenomeni", getDescrizioneFenomeni());
		attributes.put("note", getNote());
		attributes.put("riferimenti", getRiferimenti());
		attributes.put("sintesi", getSintesi());
		attributes.put("utenteFirmaArpaId", getUtenteFirmaArpaId());
		attributes.put("dataFirmaArpa", getDataFirmaArpa());
		attributes.put("utenteFirmaProtId", getUtenteFirmaProtId());
		attributes.put("dataFirmaProt", getDataFirmaProt());
		attributes.put("parentId", getParentId());
		attributes.put("link", getLink());
		attributes.put("stato", getStato());
		attributes.put("tipoAllerta", isTipoAllerta());
		attributes.put("hash", getHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allertaValangheId = (Long)attributes.get("allertaValangheId");

		if (allertaValangheId != null) {
			setAllertaValangheId(allertaValangheId);
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

		String creatorName = (String)attributes.get("creatorName");

		if (creatorName != null) {
			setCreatorName(creatorName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dataEmissione = (Date)attributes.get("dataEmissione");

		if (dataEmissione != null) {
			setDataEmissione(dataEmissione);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String descrizioneFenomeni = (String)attributes.get(
			"descrizioneFenomeni");

		if (descrizioneFenomeni != null) {
			setDescrizioneFenomeni(descrizioneFenomeni);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String riferimenti = (String)attributes.get("riferimenti");

		if (riferimenti != null) {
			setRiferimenti(riferimenti);
		}

		String sintesi = (String)attributes.get("sintesi");

		if (sintesi != null) {
			setSintesi(sintesi);
		}

		Long utenteFirmaArpaId = (Long)attributes.get("utenteFirmaArpaId");

		if (utenteFirmaArpaId != null) {
			setUtenteFirmaArpaId(utenteFirmaArpaId);
		}

		Date dataFirmaArpa = (Date)attributes.get("dataFirmaArpa");

		if (dataFirmaArpa != null) {
			setDataFirmaArpa(dataFirmaArpa);
		}

		Long utenteFirmaProtId = (Long)attributes.get("utenteFirmaProtId");

		if (utenteFirmaProtId != null) {
			setUtenteFirmaProtId(utenteFirmaProtId);
		}

		Date dataFirmaProt = (Date)attributes.get("dataFirmaProt");

		if (dataFirmaProt != null) {
			setDataFirmaProt(dataFirmaProt);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Boolean tipoAllerta = (Boolean)attributes.get("tipoAllerta");

		if (tipoAllerta != null) {
			setTipoAllerta(tipoAllerta);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public Object clone() {
		return new AllertaValangheWrapper(
			(AllertaValanghe)_allertaValanghe.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return _allertaValanghe.compareTo(allertaValanghe);
	}

	/**
	 * Returns the allerta valanghe ID of this allerta valanghe.
	 *
	 * @return the allerta valanghe ID of this allerta valanghe
	 */
	@Override
	public long getAllertaValangheId() {
		return _allertaValanghe.getAllertaValangheId();
	}

	@Override
	public java.util.List<it.eng.allerter.model.AllertaValangheStato>
		getAllertaValangheStato() {

		return _allertaValanghe.getAllertaValangheStato();
	}

	/**
	 * Returns the anno of this allerta valanghe.
	 *
	 * @return the anno of this allerta valanghe
	 */
	@Override
	public int getAnno() {
		return _allertaValanghe.getAnno();
	}

	/**
	 * Returns the company ID of this allerta valanghe.
	 *
	 * @return the company ID of this allerta valanghe
	 */
	@Override
	public long getCompanyId() {
		return _allertaValanghe.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta valanghe.
	 *
	 * @return the create date of this allerta valanghe
	 */
	@Override
	public Date getCreateDate() {
		return _allertaValanghe.getCreateDate();
	}

	/**
	 * Returns the creator name of this allerta valanghe.
	 *
	 * @return the creator name of this allerta valanghe
	 */
	@Override
	public String getCreatorName() {
		return _allertaValanghe.getCreatorName();
	}

	/**
	 * Returns the data emissione of this allerta valanghe.
	 *
	 * @return the data emissione of this allerta valanghe
	 */
	@Override
	public Date getDataEmissione() {
		return _allertaValanghe.getDataEmissione();
	}

	/**
	 * Returns the data fine of this allerta valanghe.
	 *
	 * @return the data fine of this allerta valanghe
	 */
	@Override
	public Date getDataFine() {
		return _allertaValanghe.getDataFine();
	}

	/**
	 * Returns the data firma arpa of this allerta valanghe.
	 *
	 * @return the data firma arpa of this allerta valanghe
	 */
	@Override
	public Date getDataFirmaArpa() {
		return _allertaValanghe.getDataFirmaArpa();
	}

	/**
	 * Returns the data firma prot of this allerta valanghe.
	 *
	 * @return the data firma prot of this allerta valanghe
	 */
	@Override
	public Date getDataFirmaProt() {
		return _allertaValanghe.getDataFirmaProt();
	}

	/**
	 * Returns the data inizio of this allerta valanghe.
	 *
	 * @return the data inizio of this allerta valanghe
	 */
	@Override
	public Date getDataInizio() {
		return _allertaValanghe.getDataInizio();
	}

	/**
	 * Returns the descrizione fenomeni of this allerta valanghe.
	 *
	 * @return the descrizione fenomeni of this allerta valanghe
	 */
	@Override
	public String getDescrizioneFenomeni() {
		return _allertaValanghe.getDescrizioneFenomeni();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _allertaValanghe.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName) {

		return _allertaValanghe.getFile(folderName, fileName);
	}

	@Override
	public String getFileLinkRelative(String folderName, String fileName) {
		return _allertaValanghe.getFileLinkRelative(folderName, fileName);
	}

	/**
	 * Returns the group ID of this allerta valanghe.
	 *
	 * @return the group ID of this allerta valanghe
	 */
	@Override
	public long getGroupId() {
		return _allertaValanghe.getGroupId();
	}

	/**
	 * Returns the hash of this allerta valanghe.
	 *
	 * @return the hash of this allerta valanghe
	 */
	@Override
	public String getHash() {
		return _allertaValanghe.getHash();
	}

	/**
	 * Returns the link of this allerta valanghe.
	 *
	 * @return the link of this allerta valanghe
	 */
	@Override
	public String getLink() {
		return _allertaValanghe.getLink();
	}

	/**
	 * Returns the modified date of this allerta valanghe.
	 *
	 * @return the modified date of this allerta valanghe
	 */
	@Override
	public Date getModifiedDate() {
		return _allertaValanghe.getModifiedDate();
	}

	/**
	 * Returns the note of this allerta valanghe.
	 *
	 * @return the note of this allerta valanghe
	 */
	@Override
	public String getNote() {
		return _allertaValanghe.getNote();
	}

	/**
	 * Returns the numero of this allerta valanghe.
	 *
	 * @return the numero of this allerta valanghe
	 */
	@Override
	public String getNumero() {
		return _allertaValanghe.getNumero();
	}

	/**
	 * Returns the parent ID of this allerta valanghe.
	 *
	 * @return the parent ID of this allerta valanghe
	 */
	@Override
	public long getParentId() {
		return _allertaValanghe.getParentId();
	}

	/**
	 * Returns the primary key of this allerta valanghe.
	 *
	 * @return the primary key of this allerta valanghe
	 */
	@Override
	public long getPrimaryKey() {
		return _allertaValanghe.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _allertaValanghe.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this allerta valanghe.
	 *
	 * @return the progressivo of this allerta valanghe
	 */
	@Override
	public int getProgressivo() {
		return _allertaValanghe.getProgressivo();
	}

	@Override
	public java.io.File getReportAsFile() {
		return _allertaValanghe.getReportAsFile();
	}

	/**
	 * Returns the riferimenti of this allerta valanghe.
	 *
	 * @return the riferimenti of this allerta valanghe
	 */
	@Override
	public String getRiferimenti() {
		return _allertaValanghe.getRiferimenti();
	}

	/**
	 * Returns the sintesi of this allerta valanghe.
	 *
	 * @return the sintesi of this allerta valanghe
	 */
	@Override
	public String getSintesi() {
		return _allertaValanghe.getSintesi();
	}

	/**
	 * Returns the stato of this allerta valanghe.
	 *
	 * @return the stato of this allerta valanghe
	 */
	@Override
	public int getStato() {
		return _allertaValanghe.getStato();
	}

	/**
	 * Returns the tipo allerta of this allerta valanghe.
	 *
	 * @return the tipo allerta of this allerta valanghe
	 */
	@Override
	public boolean getTipoAllerta() {
		return _allertaValanghe.getTipoAllerta();
	}

	/**
	 * Returns the titolo of this allerta valanghe.
	 *
	 * @return the titolo of this allerta valanghe
	 */
	@Override
	public String getTitolo() {
		return _allertaValanghe.getTitolo();
	}

	@Override
	public String getUrl() {
		return _allertaValanghe.getUrl();
	}

	/**
	 * Returns the user ID of this allerta valanghe.
	 *
	 * @return the user ID of this allerta valanghe
	 */
	@Override
	public long getUserId() {
		return _allertaValanghe.getUserId();
	}

	/**
	 * Returns the user name of this allerta valanghe.
	 *
	 * @return the user name of this allerta valanghe
	 */
	@Override
	public String getUserName() {
		return _allertaValanghe.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta valanghe.
	 *
	 * @return the user uuid of this allerta valanghe
	 */
	@Override
	public String getUserUuid() {
		return _allertaValanghe.getUserUuid();
	}

	/**
	 * Returns the utente firma arpa ID of this allerta valanghe.
	 *
	 * @return the utente firma arpa ID of this allerta valanghe
	 */
	@Override
	public long getUtenteFirmaArpaId() {
		return _allertaValanghe.getUtenteFirmaArpaId();
	}

	/**
	 * Returns the utente firma prot ID of this allerta valanghe.
	 *
	 * @return the utente firma prot ID of this allerta valanghe
	 */
	@Override
	public long getUtenteFirmaProtId() {
		return _allertaValanghe.getUtenteFirmaProtId();
	}

	/**
	 * Returns the uuid of this allerta valanghe.
	 *
	 * @return the uuid of this allerta valanghe
	 */
	@Override
	public String getUuid() {
		return _allertaValanghe.getUuid();
	}

	@Override
	public int hashCode() {
		return _allertaValanghe.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _allertaValanghe.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _allertaValanghe.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _allertaValanghe.isNew();
	}

	/**
	 * Returns <code>true</code> if this allerta valanghe is tipo allerta.
	 *
	 * @return <code>true</code> if this allerta valanghe is tipo allerta; <code>false</code> otherwise
	 */
	@Override
	public boolean isTipoAllerta() {
		return _allertaValanghe.isTipoAllerta();
	}

	@Override
	public void persist() {
		_allertaValanghe.persist();
	}

	/**
	 * Sets the allerta valanghe ID of this allerta valanghe.
	 *
	 * @param allertaValangheId the allerta valanghe ID of this allerta valanghe
	 */
	@Override
	public void setAllertaValangheId(long allertaValangheId) {
		_allertaValanghe.setAllertaValangheId(allertaValangheId);
	}

	/**
	 * Sets the anno of this allerta valanghe.
	 *
	 * @param anno the anno of this allerta valanghe
	 */
	@Override
	public void setAnno(int anno) {
		_allertaValanghe.setAnno(anno);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_allertaValanghe.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this allerta valanghe.
	 *
	 * @param companyId the company ID of this allerta valanghe
	 */
	@Override
	public void setCompanyId(long companyId) {
		_allertaValanghe.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta valanghe.
	 *
	 * @param createDate the create date of this allerta valanghe
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_allertaValanghe.setCreateDate(createDate);
	}

	/**
	 * Sets the creator name of this allerta valanghe.
	 *
	 * @param creatorName the creator name of this allerta valanghe
	 */
	@Override
	public void setCreatorName(String creatorName) {
		_allertaValanghe.setCreatorName(creatorName);
	}

	/**
	 * Sets the data emissione of this allerta valanghe.
	 *
	 * @param dataEmissione the data emissione of this allerta valanghe
	 */
	@Override
	public void setDataEmissione(Date dataEmissione) {
		_allertaValanghe.setDataEmissione(dataEmissione);
	}

	/**
	 * Sets the data fine of this allerta valanghe.
	 *
	 * @param dataFine the data fine of this allerta valanghe
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_allertaValanghe.setDataFine(dataFine);
	}

	/**
	 * Sets the data firma arpa of this allerta valanghe.
	 *
	 * @param dataFirmaArpa the data firma arpa of this allerta valanghe
	 */
	@Override
	public void setDataFirmaArpa(Date dataFirmaArpa) {
		_allertaValanghe.setDataFirmaArpa(dataFirmaArpa);
	}

	/**
	 * Sets the data firma prot of this allerta valanghe.
	 *
	 * @param dataFirmaProt the data firma prot of this allerta valanghe
	 */
	@Override
	public void setDataFirmaProt(Date dataFirmaProt) {
		_allertaValanghe.setDataFirmaProt(dataFirmaProt);
	}

	/**
	 * Sets the data inizio of this allerta valanghe.
	 *
	 * @param dataInizio the data inizio of this allerta valanghe
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_allertaValanghe.setDataInizio(dataInizio);
	}

	/**
	 * Sets the descrizione fenomeni of this allerta valanghe.
	 *
	 * @param descrizioneFenomeni the descrizione fenomeni of this allerta valanghe
	 */
	@Override
	public void setDescrizioneFenomeni(String descrizioneFenomeni) {
		_allertaValanghe.setDescrizioneFenomeni(descrizioneFenomeni);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_allertaValanghe.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_allertaValanghe.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_allertaValanghe.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this allerta valanghe.
	 *
	 * @param groupId the group ID of this allerta valanghe
	 */
	@Override
	public void setGroupId(long groupId) {
		_allertaValanghe.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this allerta valanghe.
	 *
	 * @param hash the hash of this allerta valanghe
	 */
	@Override
	public void setHash(String hash) {
		_allertaValanghe.setHash(hash);
	}

	/**
	 * Sets the link of this allerta valanghe.
	 *
	 * @param link the link of this allerta valanghe
	 */
	@Override
	public void setLink(String link) {
		_allertaValanghe.setLink(link);
	}

	/**
	 * Sets the modified date of this allerta valanghe.
	 *
	 * @param modifiedDate the modified date of this allerta valanghe
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_allertaValanghe.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_allertaValanghe.setNew(n);
	}

	/**
	 * Sets the note of this allerta valanghe.
	 *
	 * @param note the note of this allerta valanghe
	 */
	@Override
	public void setNote(String note) {
		_allertaValanghe.setNote(note);
	}

	/**
	 * Sets the numero of this allerta valanghe.
	 *
	 * @param numero the numero of this allerta valanghe
	 */
	@Override
	public void setNumero(String numero) {
		_allertaValanghe.setNumero(numero);
	}

	/**
	 * Sets the parent ID of this allerta valanghe.
	 *
	 * @param parentId the parent ID of this allerta valanghe
	 */
	@Override
	public void setParentId(long parentId) {
		_allertaValanghe.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta valanghe.
	 *
	 * @param primaryKey the primary key of this allerta valanghe
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_allertaValanghe.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_allertaValanghe.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this allerta valanghe.
	 *
	 * @param progressivo the progressivo of this allerta valanghe
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_allertaValanghe.setProgressivo(progressivo);
	}

	/**
	 * Sets the riferimenti of this allerta valanghe.
	 *
	 * @param riferimenti the riferimenti of this allerta valanghe
	 */
	@Override
	public void setRiferimenti(String riferimenti) {
		_allertaValanghe.setRiferimenti(riferimenti);
	}

	/**
	 * Sets the sintesi of this allerta valanghe.
	 *
	 * @param sintesi the sintesi of this allerta valanghe
	 */
	@Override
	public void setSintesi(String sintesi) {
		_allertaValanghe.setSintesi(sintesi);
	}

	/**
	 * Sets the stato of this allerta valanghe.
	 *
	 * @param stato the stato of this allerta valanghe
	 */
	@Override
	public void setStato(int stato) {
		_allertaValanghe.setStato(stato);
	}

	/**
	 * Sets whether this allerta valanghe is tipo allerta.
	 *
	 * @param tipoAllerta the tipo allerta of this allerta valanghe
	 */
	@Override
	public void setTipoAllerta(boolean tipoAllerta) {
		_allertaValanghe.setTipoAllerta(tipoAllerta);
	}

	/**
	 * Sets the titolo of this allerta valanghe.
	 *
	 * @param titolo the titolo of this allerta valanghe
	 */
	@Override
	public void setTitolo(String titolo) {
		_allertaValanghe.setTitolo(titolo);
	}

	/**
	 * Sets the user ID of this allerta valanghe.
	 *
	 * @param userId the user ID of this allerta valanghe
	 */
	@Override
	public void setUserId(long userId) {
		_allertaValanghe.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta valanghe.
	 *
	 * @param userName the user name of this allerta valanghe
	 */
	@Override
	public void setUserName(String userName) {
		_allertaValanghe.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta valanghe.
	 *
	 * @param userUuid the user uuid of this allerta valanghe
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_allertaValanghe.setUserUuid(userUuid);
	}

	/**
	 * Sets the utente firma arpa ID of this allerta valanghe.
	 *
	 * @param utenteFirmaArpaId the utente firma arpa ID of this allerta valanghe
	 */
	@Override
	public void setUtenteFirmaArpaId(long utenteFirmaArpaId) {
		_allertaValanghe.setUtenteFirmaArpaId(utenteFirmaArpaId);
	}

	/**
	 * Sets the utente firma prot ID of this allerta valanghe.
	 *
	 * @param utenteFirmaProtId the utente firma prot ID of this allerta valanghe
	 */
	@Override
	public void setUtenteFirmaProtId(long utenteFirmaProtId) {
		_allertaValanghe.setUtenteFirmaProtId(utenteFirmaProtId);
	}

	/**
	 * Sets the uuid of this allerta valanghe.
	 *
	 * @param uuid the uuid of this allerta valanghe
	 */
	@Override
	public void setUuid(String uuid) {
		_allertaValanghe.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.AllertaValanghe> toCacheModel() {

		return _allertaValanghe.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.AllertaValanghe toEscapedModel() {
		return new AllertaValangheWrapper(_allertaValanghe.toEscapedModel());
	}

	@Override
	public String toString() {
		return _allertaValanghe.toString();
	}

	@Override
	public it.eng.allerter.model.AllertaValanghe toUnescapedModel() {
		return new AllertaValangheWrapper(_allertaValanghe.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _allertaValanghe.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaValangheWrapper)) {
			return false;
		}

		AllertaValangheWrapper allertaValangheWrapper =
			(AllertaValangheWrapper)obj;

		if (Objects.equals(
				_allertaValanghe, allertaValangheWrapper._allertaValanghe)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _allertaValanghe.getStagedModelType();
	}

	@Override
	public AllertaValanghe getWrappedModel() {
		return _allertaValanghe;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _allertaValanghe.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _allertaValanghe.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_allertaValanghe.resetOriginalValues();
	}

	private final AllertaValanghe _allertaValanghe;

}