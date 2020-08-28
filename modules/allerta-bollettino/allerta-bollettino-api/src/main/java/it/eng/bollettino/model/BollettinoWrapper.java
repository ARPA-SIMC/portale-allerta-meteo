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
 * This class is a wrapper for {@link Bollettino}.
 * </p>
 *
 * @author GFAVINI
 * @see Bollettino
 * @generated
 */
@ProviderType
public class BollettinoWrapper implements Bollettino, ModelWrapper<Bollettino> {

	public BollettinoWrapper(Bollettino bollettino) {
		_bollettino = bollettino;
	}

	@Override
	public Class<?> getModelClass() {
		return Bollettino.class;
	}

	@Override
	public String getModelClassName() {
		return Bollettino.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bollettinoId", getBollettinoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stato", getStato());
		attributes.put("idApprovatore", getIdApprovatore());
		attributes.put("dataApprovazione", getDataApprovazione());
		attributes.put("numero", getNumero());
		attributes.put("progressivo", getProgressivo());
		attributes.put("anno", getAnno());
		attributes.put("dataEmissione", getDataEmissione());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("noteMeteo", getNoteMeteo());
		attributes.put("stringaMeteo", getStringaMeteo());
		attributes.put("link", getLink());
		attributes.put("ultimo", isUltimo());
		attributes.put("hash", getHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bollettinoId = (Long)attributes.get("bollettinoId");

		if (bollettinoId != null) {
			setBollettinoId(bollettinoId);
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

		String noteMeteo = (String)attributes.get("noteMeteo");

		if (noteMeteo != null) {
			setNoteMeteo(noteMeteo);
		}

		String stringaMeteo = (String)attributes.get("stringaMeteo");

		if (stringaMeteo != null) {
			setStringaMeteo(stringaMeteo);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Boolean ultimo = (Boolean)attributes.get("ultimo");

		if (ultimo != null) {
			setUltimo(ultimo);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public Object clone() {
		return new BollettinoWrapper((Bollettino)_bollettino.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Bollettino bollettino) {
		return _bollettino.compareTo(bollettino);
	}

	/**
	 * Returns the anno of this bollettino.
	 *
	 * @return the anno of this bollettino
	 */
	@Override
	public int getAnno() {
		return _bollettino.getAnno();
	}

	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoBacino>
		getBacini() {

		return _bollettino.getBacini();
	}

	/**
	 * Returns the bollettino ID of this bollettino.
	 *
	 * @return the bollettino ID of this bollettino
	 */
	@Override
	public long getBollettinoId() {
		return _bollettino.getBollettinoId();
	}

	/**
	 * Returns the company ID of this bollettino.
	 *
	 * @return the company ID of this bollettino
	 */
	@Override
	public long getCompanyId() {
		return _bollettino.getCompanyId();
	}

	/**
	 * Returns the create date of this bollettino.
	 *
	 * @return the create date of this bollettino
	 */
	@Override
	public Date getCreateDate() {
		return _bollettino.getCreateDate();
	}

	/**
	 * Returns the data approvazione of this bollettino.
	 *
	 * @return the data approvazione of this bollettino
	 */
	@Override
	public Date getDataApprovazione() {
		return _bollettino.getDataApprovazione();
	}

	/**
	 * Returns the data emissione of this bollettino.
	 *
	 * @return the data emissione of this bollettino
	 */
	@Override
	public Date getDataEmissione() {
		return _bollettino.getDataEmissione();
	}

	/**
	 * Returns the data fine of this bollettino.
	 *
	 * @return the data fine of this bollettino
	 */
	@Override
	public Date getDataFine() {
		return _bollettino.getDataFine();
	}

	/**
	 * Returns the data inizio of this bollettino.
	 *
	 * @return the data inizio of this bollettino
	 */
	@Override
	public Date getDataInizio() {
		return _bollettino.getDataInizio();
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFolder getDLFolder(
		String folderName) {

		return _bollettino.getDLFolder(folderName);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bollettino.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName) {

		return _bollettino.getFile(folderName, fileName);
	}

	@Override
	public String getFileLink(String folderName, String fileName) {
		return _bollettino.getFileLink(folderName, fileName);
	}

	@Override
	public String getFileLinkRelative(String folderName, String fileName) {
		return _bollettino.getFileLinkRelative(folderName, fileName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		String folderName) {

		return _bollettino.getFolder(folderName);
	}

	/**
	 * Returns the group ID of this bollettino.
	 *
	 * @return the group ID of this bollettino
	 */
	@Override
	public long getGroupId() {
		return _bollettino.getGroupId();
	}

	/**
	 * Returns the hash of this bollettino.
	 *
	 * @return the hash of this bollettino
	 */
	@Override
	public String getHash() {
		return _bollettino.getHash();
	}

	/**
	 * Returns the id approvatore of this bollettino.
	 *
	 * @return the id approvatore of this bollettino
	 */
	@Override
	public long getIdApprovatore() {
		return _bollettino.getIdApprovatore();
	}

	/**
	 * Returns the link of this bollettino.
	 *
	 * @return the link of this bollettino
	 */
	@Override
	public String getLink() {
		return _bollettino.getLink();
	}

	/**
	 * Returns the modified date of this bollettino.
	 *
	 * @return the modified date of this bollettino
	 */
	@Override
	public Date getModifiedDate() {
		return _bollettino.getModifiedDate();
	}

	/**
	 * Returns the note meteo of this bollettino.
	 *
	 * @return the note meteo of this bollettino
	 */
	@Override
	public String getNoteMeteo() {
		return _bollettino.getNoteMeteo();
	}

	/**
	 * Returns the numero of this bollettino.
	 *
	 * @return the numero of this bollettino
	 */
	@Override
	public String getNumero() {
		return _bollettino.getNumero();
	}

	/**
	 * Returns the primary key of this bollettino.
	 *
	 * @return the primary key of this bollettino
	 */
	@Override
	public long getPrimaryKey() {
		return _bollettino.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bollettino.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this bollettino.
	 *
	 * @return the progressivo of this bollettino
	 */
	@Override
	public int getProgressivo() {
		return _bollettino.getProgressivo();
	}

	/**
	 * Returns the stato of this bollettino.
	 *
	 * @return the stato of this bollettino
	 */
	@Override
	public int getStato() {
		return _bollettino.getStato();
	}

	/**
	 * Returns the stringa meteo of this bollettino.
	 *
	 * @return the stringa meteo of this bollettino
	 */
	@Override
	public String getStringaMeteo() {
		return _bollettino.getStringaMeteo();
	}

	/**
	 * Returns the ultimo of this bollettino.
	 *
	 * @return the ultimo of this bollettino
	 */
	@Override
	public boolean getUltimo() {
		return _bollettino.getUltimo();
	}

	/**
	 * Returns the user ID of this bollettino.
	 *
	 * @return the user ID of this bollettino
	 */
	@Override
	public long getUserId() {
		return _bollettino.getUserId();
	}

	/**
	 * Returns the user name of this bollettino.
	 *
	 * @return the user name of this bollettino
	 */
	@Override
	public String getUserName() {
		return _bollettino.getUserName();
	}

	/**
	 * Returns the user uuid of this bollettino.
	 *
	 * @return the user uuid of this bollettino
	 */
	@Override
	public String getUserUuid() {
		return _bollettino.getUserUuid();
	}

	/**
	 * Returns the uuid of this bollettino.
	 *
	 * @return the uuid of this bollettino
	 */
	@Override
	public String getUuid() {
		return _bollettino.getUuid();
	}

	@Override
	public int hashCode() {
		return _bollettino.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bollettino.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bollettino.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bollettino.isNew();
	}

	/**
	 * Returns <code>true</code> if this bollettino is ultimo.
	 *
	 * @return <code>true</code> if this bollettino is ultimo; <code>false</code> otherwise
	 */
	@Override
	public boolean isUltimo() {
		return _bollettino.isUltimo();
	}

	@Override
	public void persist() {
		_bollettino.persist();
	}

	/**
	 * Sets the anno of this bollettino.
	 *
	 * @param anno the anno of this bollettino
	 */
	@Override
	public void setAnno(int anno) {
		_bollettino.setAnno(anno);
	}

	/**
	 * Sets the bollettino ID of this bollettino.
	 *
	 * @param bollettinoId the bollettino ID of this bollettino
	 */
	@Override
	public void setBollettinoId(long bollettinoId) {
		_bollettino.setBollettinoId(bollettinoId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bollettino.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this bollettino.
	 *
	 * @param companyId the company ID of this bollettino
	 */
	@Override
	public void setCompanyId(long companyId) {
		_bollettino.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this bollettino.
	 *
	 * @param createDate the create date of this bollettino
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_bollettino.setCreateDate(createDate);
	}

	/**
	 * Sets the data approvazione of this bollettino.
	 *
	 * @param dataApprovazione the data approvazione of this bollettino
	 */
	@Override
	public void setDataApprovazione(Date dataApprovazione) {
		_bollettino.setDataApprovazione(dataApprovazione);
	}

	/**
	 * Sets the data emissione of this bollettino.
	 *
	 * @param dataEmissione the data emissione of this bollettino
	 */
	@Override
	public void setDataEmissione(Date dataEmissione) {
		_bollettino.setDataEmissione(dataEmissione);
	}

	/**
	 * Sets the data fine of this bollettino.
	 *
	 * @param dataFine the data fine of this bollettino
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_bollettino.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this bollettino.
	 *
	 * @param dataInizio the data inizio of this bollettino
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_bollettino.setDataInizio(dataInizio);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bollettino.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bollettino.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bollettino.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this bollettino.
	 *
	 * @param groupId the group ID of this bollettino
	 */
	@Override
	public void setGroupId(long groupId) {
		_bollettino.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this bollettino.
	 *
	 * @param hash the hash of this bollettino
	 */
	@Override
	public void setHash(String hash) {
		_bollettino.setHash(hash);
	}

	/**
	 * Sets the id approvatore of this bollettino.
	 *
	 * @param idApprovatore the id approvatore of this bollettino
	 */
	@Override
	public void setIdApprovatore(long idApprovatore) {
		_bollettino.setIdApprovatore(idApprovatore);
	}

	/**
	 * Sets the link of this bollettino.
	 *
	 * @param link the link of this bollettino
	 */
	@Override
	public void setLink(String link) {
		_bollettino.setLink(link);
	}

	/**
	 * Sets the modified date of this bollettino.
	 *
	 * @param modifiedDate the modified date of this bollettino
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_bollettino.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_bollettino.setNew(n);
	}

	/**
	 * Sets the note meteo of this bollettino.
	 *
	 * @param noteMeteo the note meteo of this bollettino
	 */
	@Override
	public void setNoteMeteo(String noteMeteo) {
		_bollettino.setNoteMeteo(noteMeteo);
	}

	/**
	 * Sets the numero of this bollettino.
	 *
	 * @param numero the numero of this bollettino
	 */
	@Override
	public void setNumero(String numero) {
		_bollettino.setNumero(numero);
	}

	/**
	 * Sets the primary key of this bollettino.
	 *
	 * @param primaryKey the primary key of this bollettino
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bollettino.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bollettino.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this bollettino.
	 *
	 * @param progressivo the progressivo of this bollettino
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_bollettino.setProgressivo(progressivo);
	}

	/**
	 * Sets the stato of this bollettino.
	 *
	 * @param stato the stato of this bollettino
	 */
	@Override
	public void setStato(int stato) {
		_bollettino.setStato(stato);
	}

	/**
	 * Sets the stringa meteo of this bollettino.
	 *
	 * @param stringaMeteo the stringa meteo of this bollettino
	 */
	@Override
	public void setStringaMeteo(String stringaMeteo) {
		_bollettino.setStringaMeteo(stringaMeteo);
	}

	/**
	 * Sets whether this bollettino is ultimo.
	 *
	 * @param ultimo the ultimo of this bollettino
	 */
	@Override
	public void setUltimo(boolean ultimo) {
		_bollettino.setUltimo(ultimo);
	}

	/**
	 * Sets the user ID of this bollettino.
	 *
	 * @param userId the user ID of this bollettino
	 */
	@Override
	public void setUserId(long userId) {
		_bollettino.setUserId(userId);
	}

	/**
	 * Sets the user name of this bollettino.
	 *
	 * @param userName the user name of this bollettino
	 */
	@Override
	public void setUserName(String userName) {
		_bollettino.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this bollettino.
	 *
	 * @param userUuid the user uuid of this bollettino
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_bollettino.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this bollettino.
	 *
	 * @param uuid the uuid of this bollettino
	 */
	@Override
	public void setUuid(String uuid) {
		_bollettino.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Bollettino> toCacheModel() {

		return _bollettino.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Bollettino toEscapedModel() {
		return new BollettinoWrapper(_bollettino.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bollettino.toString();
	}

	@Override
	public it.eng.bollettino.model.Bollettino toUnescapedModel() {
		return new BollettinoWrapper(_bollettino.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bollettino.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoWrapper)) {
			return false;
		}

		BollettinoWrapper bollettinoWrapper = (BollettinoWrapper)obj;

		if (Objects.equals(_bollettino, bollettinoWrapper._bollettino)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _bollettino.getStagedModelType();
	}

	@Override
	public Bollettino getWrappedModel() {
		return _bollettino;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bollettino.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bollettino.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bollettino.resetOriginalValues();
	}

	private final Bollettino _bollettino;

}