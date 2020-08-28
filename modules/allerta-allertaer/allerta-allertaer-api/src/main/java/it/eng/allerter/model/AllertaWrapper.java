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
 * This class is a wrapper for {@link Allerta}.
 * </p>
 *
 * @author GFAVINI
 * @see Allerta
 * @generated
 */
@ProviderType
public class AllertaWrapper implements Allerta, ModelWrapper<Allerta> {

	public AllertaWrapper(Allerta allerta) {
		_allerta = allerta;
	}

	@Override
	public Class<?> getModelClass() {
		return Allerta.class;
	}

	@Override
	public String getModelClassName() {
		return Allerta.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaId", getAllertaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("creatorName", getCreatorName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stato", getStato());
		attributes.put("numero", getNumero());
		attributes.put("progressivo", getProgressivo());
		attributes.put("anno", getAnno());
		attributes.put("dataEmissione", getDataEmissione());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("descrizioneMeteo", getDescrizioneMeteo());
		attributes.put("tendenza", getTendenza());
		attributes.put("note", getNote());
		attributes.put("riferimenti", getRiferimenti());
		attributes.put("utenteFirmaArpaId", getUtenteFirmaArpaId());
		attributes.put("dataFirmaArpa", getDataFirmaArpa());
		attributes.put("utenteFirmaProtId", getUtenteFirmaProtId());
		attributes.put("dataFirmaProt", getDataFirmaProt());
		attributes.put("parentId", getParentId());
		attributes.put("sintesi", getSintesi());
		attributes.put("link", getLink());
		attributes.put("titolo", getTitolo());
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

		Long allertaId = (Long)attributes.get("allertaId");

		if (allertaId != null) {
			setAllertaId(allertaId);
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

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
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

		String descrizioneMeteo = (String)attributes.get("descrizioneMeteo");

		if (descrizioneMeteo != null) {
			setDescrizioneMeteo(descrizioneMeteo);
		}

		Integer tendenza = (Integer)attributes.get("tendenza");

		if (tendenza != null) {
			setTendenza(tendenza);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String riferimenti = (String)attributes.get("riferimenti");

		if (riferimenti != null) {
			setRiferimenti(riferimenti);
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

		String sintesi = (String)attributes.get("sintesi");

		if (sintesi != null) {
			setSintesi(sintesi);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
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
		return new AllertaWrapper((Allerta)_allerta.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.Allerta allerta) {
		return _allerta.compareTo(allerta);
	}

	/**
	 * Returns the allerta ID of this allerta.
	 *
	 * @return the allerta ID of this allerta
	 */
	@Override
	public long getAllertaId() {
		return _allerta.getAllertaId();
	}

	@Override
	public java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStato() {

		return _allerta.getAllertaStato();
	}

	/**
	 * Returns the anno of this allerta.
	 *
	 * @return the anno of this allerta
	 */
	@Override
	public int getAnno() {
		return _allerta.getAnno();
	}

	/**
	 * Returns the company ID of this allerta.
	 *
	 * @return the company ID of this allerta
	 */
	@Override
	public long getCompanyId() {
		return _allerta.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta.
	 *
	 * @return the create date of this allerta
	 */
	@Override
	public Date getCreateDate() {
		return _allerta.getCreateDate();
	}

	/**
	 * Returns the creator name of this allerta.
	 *
	 * @return the creator name of this allerta
	 */
	@Override
	public String getCreatorName() {
		return _allerta.getCreatorName();
	}

	/**
	 * Returns the data emissione of this allerta.
	 *
	 * @return the data emissione of this allerta
	 */
	@Override
	public Date getDataEmissione() {
		return _allerta.getDataEmissione();
	}

	/**
	 * Returns the data fine of this allerta.
	 *
	 * @return the data fine of this allerta
	 */
	@Override
	public Date getDataFine() {
		return _allerta.getDataFine();
	}

	/**
	 * Returns the data firma arpa of this allerta.
	 *
	 * @return the data firma arpa of this allerta
	 */
	@Override
	public Date getDataFirmaArpa() {
		return _allerta.getDataFirmaArpa();
	}

	/**
	 * Returns the data firma prot of this allerta.
	 *
	 * @return the data firma prot of this allerta
	 */
	@Override
	public Date getDataFirmaProt() {
		return _allerta.getDataFirmaProt();
	}

	/**
	 * Returns the data inizio of this allerta.
	 *
	 * @return the data inizio of this allerta
	 */
	@Override
	public Date getDataInizio() {
		return _allerta.getDataInizio();
	}

	/**
	 * Returns the descrizione meteo of this allerta.
	 *
	 * @return the descrizione meteo of this allerta
	 */
	@Override
	public String getDescrizioneMeteo() {
		return _allerta.getDescrizioneMeteo();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _allerta.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName) {

		return _allerta.getFile(folderName, fileName);
	}

	@Override
	public String getFileLinkRelative(String folderName, String fileName) {
		return _allerta.getFileLinkRelative(folderName, fileName);
	}

	/**
	 * Returns the group ID of this allerta.
	 *
	 * @return the group ID of this allerta
	 */
	@Override
	public long getGroupId() {
		return _allerta.getGroupId();
	}

	/**
	 * Returns the hash of this allerta.
	 *
	 * @return the hash of this allerta
	 */
	@Override
	public String getHash() {
		return _allerta.getHash();
	}

	/**
	 * Returns the link of this allerta.
	 *
	 * @return the link of this allerta
	 */
	@Override
	public String getLink() {
		return _allerta.getLink();
	}

	/**
	 * Returns the modified date of this allerta.
	 *
	 * @return the modified date of this allerta
	 */
	@Override
	public Date getModifiedDate() {
		return _allerta.getModifiedDate();
	}

	/**
	 * Returns the note of this allerta.
	 *
	 * @return the note of this allerta
	 */
	@Override
	public String getNote() {
		return _allerta.getNote();
	}

	/**
	 * Returns the numero of this allerta.
	 *
	 * @return the numero of this allerta
	 */
	@Override
	public String getNumero() {
		return _allerta.getNumero();
	}

	/**
	 * Returns the parent ID of this allerta.
	 *
	 * @return the parent ID of this allerta
	 */
	@Override
	public long getParentId() {
		return _allerta.getParentId();
	}

	/**
	 * Returns the primary key of this allerta.
	 *
	 * @return the primary key of this allerta
	 */
	@Override
	public long getPrimaryKey() {
		return _allerta.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _allerta.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this allerta.
	 *
	 * @return the progressivo of this allerta
	 */
	@Override
	public int getProgressivo() {
		return _allerta.getProgressivo();
	}

	@Override
	public java.io.File getReportAsFile() {
		return _allerta.getReportAsFile();
	}

	/**
	 * Returns the riferimenti of this allerta.
	 *
	 * @return the riferimenti of this allerta
	 */
	@Override
	public String getRiferimenti() {
		return _allerta.getRiferimenti();
	}

	/**
	 * Returns the sintesi of this allerta.
	 *
	 * @return the sintesi of this allerta
	 */
	@Override
	public String getSintesi() {
		return _allerta.getSintesi();
	}

	/**
	 * Returns the stato of this allerta.
	 *
	 * @return the stato of this allerta
	 */
	@Override
	public int getStato() {
		return _allerta.getStato();
	}

	/**
	 * Returns the tendenza of this allerta.
	 *
	 * @return the tendenza of this allerta
	 */
	@Override
	public int getTendenza() {
		return _allerta.getTendenza();
	}

	/**
	 * Returns the tipo allerta of this allerta.
	 *
	 * @return the tipo allerta of this allerta
	 */
	@Override
	public boolean getTipoAllerta() {
		return _allerta.getTipoAllerta();
	}

	/**
	 * Returns the titolo of this allerta.
	 *
	 * @return the titolo of this allerta
	 */
	@Override
	public String getTitolo() {
		return _allerta.getTitolo();
	}

	@Override
	public String getUrl() {
		return _allerta.getUrl();
	}

	/**
	 * Returns the user ID of this allerta.
	 *
	 * @return the user ID of this allerta
	 */
	@Override
	public long getUserId() {
		return _allerta.getUserId();
	}

	/**
	 * Returns the user name of this allerta.
	 *
	 * @return the user name of this allerta
	 */
	@Override
	public String getUserName() {
		return _allerta.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta.
	 *
	 * @return the user uuid of this allerta
	 */
	@Override
	public String getUserUuid() {
		return _allerta.getUserUuid();
	}

	/**
	 * Returns the utente firma arpa ID of this allerta.
	 *
	 * @return the utente firma arpa ID of this allerta
	 */
	@Override
	public long getUtenteFirmaArpaId() {
		return _allerta.getUtenteFirmaArpaId();
	}

	/**
	 * Returns the utente firma prot ID of this allerta.
	 *
	 * @return the utente firma prot ID of this allerta
	 */
	@Override
	public long getUtenteFirmaProtId() {
		return _allerta.getUtenteFirmaProtId();
	}

	/**
	 * Returns the uuid of this allerta.
	 *
	 * @return the uuid of this allerta
	 */
	@Override
	public String getUuid() {
		return _allerta.getUuid();
	}

	@Override
	public int hashCode() {
		return _allerta.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _allerta.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _allerta.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _allerta.isNew();
	}

	/**
	 * Returns <code>true</code> if this allerta is tipo allerta.
	 *
	 * @return <code>true</code> if this allerta is tipo allerta; <code>false</code> otherwise
	 */
	@Override
	public boolean isTipoAllerta() {
		return _allerta.isTipoAllerta();
	}

	@Override
	public void persist() {
		_allerta.persist();
	}

	/**
	 * Sets the allerta ID of this allerta.
	 *
	 * @param allertaId the allerta ID of this allerta
	 */
	@Override
	public void setAllertaId(long allertaId) {
		_allerta.setAllertaId(allertaId);
	}

	/**
	 * Sets the anno of this allerta.
	 *
	 * @param anno the anno of this allerta
	 */
	@Override
	public void setAnno(int anno) {
		_allerta.setAnno(anno);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_allerta.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this allerta.
	 *
	 * @param companyId the company ID of this allerta
	 */
	@Override
	public void setCompanyId(long companyId) {
		_allerta.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta.
	 *
	 * @param createDate the create date of this allerta
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_allerta.setCreateDate(createDate);
	}

	/**
	 * Sets the creator name of this allerta.
	 *
	 * @param creatorName the creator name of this allerta
	 */
	@Override
	public void setCreatorName(String creatorName) {
		_allerta.setCreatorName(creatorName);
	}

	/**
	 * Sets the data emissione of this allerta.
	 *
	 * @param dataEmissione the data emissione of this allerta
	 */
	@Override
	public void setDataEmissione(Date dataEmissione) {
		_allerta.setDataEmissione(dataEmissione);
	}

	/**
	 * Sets the data fine of this allerta.
	 *
	 * @param dataFine the data fine of this allerta
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_allerta.setDataFine(dataFine);
	}

	/**
	 * Sets the data firma arpa of this allerta.
	 *
	 * @param dataFirmaArpa the data firma arpa of this allerta
	 */
	@Override
	public void setDataFirmaArpa(Date dataFirmaArpa) {
		_allerta.setDataFirmaArpa(dataFirmaArpa);
	}

	/**
	 * Sets the data firma prot of this allerta.
	 *
	 * @param dataFirmaProt the data firma prot of this allerta
	 */
	@Override
	public void setDataFirmaProt(Date dataFirmaProt) {
		_allerta.setDataFirmaProt(dataFirmaProt);
	}

	/**
	 * Sets the data inizio of this allerta.
	 *
	 * @param dataInizio the data inizio of this allerta
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_allerta.setDataInizio(dataInizio);
	}

	/**
	 * Sets the descrizione meteo of this allerta.
	 *
	 * @param descrizioneMeteo the descrizione meteo of this allerta
	 */
	@Override
	public void setDescrizioneMeteo(String descrizioneMeteo) {
		_allerta.setDescrizioneMeteo(descrizioneMeteo);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_allerta.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_allerta.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_allerta.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this allerta.
	 *
	 * @param groupId the group ID of this allerta
	 */
	@Override
	public void setGroupId(long groupId) {
		_allerta.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this allerta.
	 *
	 * @param hash the hash of this allerta
	 */
	@Override
	public void setHash(String hash) {
		_allerta.setHash(hash);
	}

	/**
	 * Sets the link of this allerta.
	 *
	 * @param link the link of this allerta
	 */
	@Override
	public void setLink(String link) {
		_allerta.setLink(link);
	}

	/**
	 * Sets the modified date of this allerta.
	 *
	 * @param modifiedDate the modified date of this allerta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_allerta.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_allerta.setNew(n);
	}

	/**
	 * Sets the note of this allerta.
	 *
	 * @param note the note of this allerta
	 */
	@Override
	public void setNote(String note) {
		_allerta.setNote(note);
	}

	/**
	 * Sets the numero of this allerta.
	 *
	 * @param numero the numero of this allerta
	 */
	@Override
	public void setNumero(String numero) {
		_allerta.setNumero(numero);
	}

	/**
	 * Sets the parent ID of this allerta.
	 *
	 * @param parentId the parent ID of this allerta
	 */
	@Override
	public void setParentId(long parentId) {
		_allerta.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta.
	 *
	 * @param primaryKey the primary key of this allerta
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_allerta.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_allerta.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this allerta.
	 *
	 * @param progressivo the progressivo of this allerta
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_allerta.setProgressivo(progressivo);
	}

	/**
	 * Sets the riferimenti of this allerta.
	 *
	 * @param riferimenti the riferimenti of this allerta
	 */
	@Override
	public void setRiferimenti(String riferimenti) {
		_allerta.setRiferimenti(riferimenti);
	}

	/**
	 * Sets the sintesi of this allerta.
	 *
	 * @param sintesi the sintesi of this allerta
	 */
	@Override
	public void setSintesi(String sintesi) {
		_allerta.setSintesi(sintesi);
	}

	/**
	 * Sets the stato of this allerta.
	 *
	 * @param stato the stato of this allerta
	 */
	@Override
	public void setStato(int stato) {
		_allerta.setStato(stato);
	}

	/**
	 * Sets the tendenza of this allerta.
	 *
	 * @param tendenza the tendenza of this allerta
	 */
	@Override
	public void setTendenza(int tendenza) {
		_allerta.setTendenza(tendenza);
	}

	/**
	 * Sets whether this allerta is tipo allerta.
	 *
	 * @param tipoAllerta the tipo allerta of this allerta
	 */
	@Override
	public void setTipoAllerta(boolean tipoAllerta) {
		_allerta.setTipoAllerta(tipoAllerta);
	}

	/**
	 * Sets the titolo of this allerta.
	 *
	 * @param titolo the titolo of this allerta
	 */
	@Override
	public void setTitolo(String titolo) {
		_allerta.setTitolo(titolo);
	}

	/**
	 * Sets the user ID of this allerta.
	 *
	 * @param userId the user ID of this allerta
	 */
	@Override
	public void setUserId(long userId) {
		_allerta.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta.
	 *
	 * @param userName the user name of this allerta
	 */
	@Override
	public void setUserName(String userName) {
		_allerta.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta.
	 *
	 * @param userUuid the user uuid of this allerta
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_allerta.setUserUuid(userUuid);
	}

	/**
	 * Sets the utente firma arpa ID of this allerta.
	 *
	 * @param utenteFirmaArpaId the utente firma arpa ID of this allerta
	 */
	@Override
	public void setUtenteFirmaArpaId(long utenteFirmaArpaId) {
		_allerta.setUtenteFirmaArpaId(utenteFirmaArpaId);
	}

	/**
	 * Sets the utente firma prot ID of this allerta.
	 *
	 * @param utenteFirmaProtId the utente firma prot ID of this allerta
	 */
	@Override
	public void setUtenteFirmaProtId(long utenteFirmaProtId) {
		_allerta.setUtenteFirmaProtId(utenteFirmaProtId);
	}

	/**
	 * Sets the uuid of this allerta.
	 *
	 * @param uuid the uuid of this allerta
	 */
	@Override
	public void setUuid(String uuid) {
		_allerta.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.Allerta> toCacheModel() {

		return _allerta.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.Allerta toEscapedModel() {
		return new AllertaWrapper(_allerta.toEscapedModel());
	}

	@Override
	public String toString() {
		return _allerta.toString();
	}

	@Override
	public it.eng.allerter.model.Allerta toUnescapedModel() {
		return new AllertaWrapper(_allerta.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _allerta.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaWrapper)) {
			return false;
		}

		AllertaWrapper allertaWrapper = (AllertaWrapper)obj;

		if (Objects.equals(_allerta, allertaWrapper._allerta)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _allerta.getStagedModelType();
	}

	@Override
	public Allerta getWrappedModel() {
		return _allerta;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _allerta.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _allerta.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_allerta.resetOriginalValues();
	}

	private final Allerta _allerta;

}