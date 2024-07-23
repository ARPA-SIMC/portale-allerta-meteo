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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Segnalazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Segnalazione
 * @generated
 */
@ProviderType
public class SegnalazioneWrapper
	implements Segnalazione, ModelWrapper<Segnalazione> {

	public SegnalazioneWrapper(Segnalazione segnalazione) {
		_segnalazione = segnalazione;
	}

	@Override
	public Class<?> getModelClass() {
		return Segnalazione.class;
	}

	@Override
	public String getModelClassName() {
		return Segnalazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documentoAssociato", getDocumentoAssociato());
		attributes.put("dataEvento", getDataEvento());
		attributes.put("enteSegnalante", getEnteSegnalante());
		attributes.put("fonte", getFonte());
		attributes.put("categoria", getCategoria());
		attributes.put("sottocategoria", getSottocategoria());
		attributes.put("riferimento", getRiferimento());
		attributes.put("descrizione", getDescrizione());
		attributes.put("note", getNote());
		attributes.put("area", getArea());
		attributes.put("provincia", getProvincia());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("civico", getCivico());
		attributes.put("lat", getLat());
		attributes.put("lon", getLon());
		attributes.put("effetti", getEffetti());
		attributes.put("effettiSub", getEffettiSub());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		Long documentoAssociato = (Long)attributes.get("documentoAssociato");

		if (documentoAssociato != null) {
			setDocumentoAssociato(documentoAssociato);
		}

		Date dataEvento = (Date)attributes.get("dataEvento");

		if (dataEvento != null) {
			setDataEvento(dataEvento);
		}

		String enteSegnalante = (String)attributes.get("enteSegnalante");

		if (enteSegnalante != null) {
			setEnteSegnalante(enteSegnalante);
		}

		Long fonte = (Long)attributes.get("fonte");

		if (fonte != null) {
			setFonte(fonte);
		}

		Long categoria = (Long)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}

		Long sottocategoria = (Long)attributes.get("sottocategoria");

		if (sottocategoria != null) {
			setSottocategoria(sottocategoria);
		}

		String riferimento = (String)attributes.get("riferimento");

		if (riferimento != null) {
			setRiferimento(riferimento);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String civico = (String)attributes.get("civico");

		if (civico != null) {
			setCivico(civico);
		}

		Double lat = (Double)attributes.get("lat");

		if (lat != null) {
			setLat(lat);
		}

		Double lon = (Double)attributes.get("lon");

		if (lon != null) {
			setLon(lon);
		}

		Long effetti = (Long)attributes.get("effetti");

		if (effetti != null) {
			setEffetti(effetti);
		}

		Long effettiSub = (Long)attributes.get("effettiSub");

		if (effettiSub != null) {
			setEffettiSub(effettiSub);
		}
	}

	@Override
	public Object clone() {
		return new SegnalazioneWrapper((Segnalazione)_segnalazione.clone());
	}

	@Override
	public int compareTo(allerta.catasto.model.Segnalazione segnalazione) {
		return _segnalazione.compareTo(segnalazione);
	}

	/**
	 * Returns the area of this segnalazione.
	 *
	 * @return the area of this segnalazione
	 */
	@Override
	public String getArea() {
		return _segnalazione.getArea();
	}

	/**
	 * Returns the categoria of this segnalazione.
	 *
	 * @return the categoria of this segnalazione
	 */
	@Override
	public long getCategoria() {
		return _segnalazione.getCategoria();
	}

	/**
	 * Returns the civico of this segnalazione.
	 *
	 * @return the civico of this segnalazione
	 */
	@Override
	public String getCivico() {
		return _segnalazione.getCivico();
	}

	/**
	 * Returns the company ID of this segnalazione.
	 *
	 * @return the company ID of this segnalazione
	 */
	@Override
	public long getCompanyId() {
		return _segnalazione.getCompanyId();
	}

	/**
	 * Returns the comune of this segnalazione.
	 *
	 * @return the comune of this segnalazione
	 */
	@Override
	public String getComune() {
		return _segnalazione.getComune();
	}

	/**
	 * Returns the create date of this segnalazione.
	 *
	 * @return the create date of this segnalazione
	 */
	@Override
	public Date getCreateDate() {
		return _segnalazione.getCreateDate();
	}

	/**
	 * Returns the data evento of this segnalazione.
	 *
	 * @return the data evento of this segnalazione
	 */
	@Override
	public Date getDataEvento() {
		return _segnalazione.getDataEvento();
	}

	/**
	 * Returns the descrizione of this segnalazione.
	 *
	 * @return the descrizione of this segnalazione
	 */
	@Override
	public String getDescrizione() {
		return _segnalazione.getDescrizione();
	}

	/**
	 * Returns the documento associato of this segnalazione.
	 *
	 * @return the documento associato of this segnalazione
	 */
	@Override
	public long getDocumentoAssociato() {
		return _segnalazione.getDocumentoAssociato();
	}

	/**
	 * Returns the effetti of this segnalazione.
	 *
	 * @return the effetti of this segnalazione
	 */
	@Override
	public long getEffetti() {
		return _segnalazione.getEffetti();
	}

	/**
	 * Returns the effetti sub of this segnalazione.
	 *
	 * @return the effetti sub of this segnalazione
	 */
	@Override
	public long getEffettiSub() {
		return _segnalazione.getEffettiSub();
	}

	/**
	 * Returns the ente segnalante of this segnalazione.
	 *
	 * @return the ente segnalante of this segnalazione
	 */
	@Override
	public String getEnteSegnalante() {
		return _segnalazione.getEnteSegnalante();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _segnalazione.getExpandoBridge();
	}

	/**
	 * Returns the fonte of this segnalazione.
	 *
	 * @return the fonte of this segnalazione
	 */
	@Override
	public long getFonte() {
		return _segnalazione.getFonte();
	}

	/**
	 * Returns the group ID of this segnalazione.
	 *
	 * @return the group ID of this segnalazione
	 */
	@Override
	public long getGroupId() {
		return _segnalazione.getGroupId();
	}

	/**
	 * Returns the ID of this segnalazione.
	 *
	 * @return the ID of this segnalazione
	 */
	@Override
	public long getId() {
		return _segnalazione.getId();
	}

	/**
	 * Returns the indirizzo of this segnalazione.
	 *
	 * @return the indirizzo of this segnalazione
	 */
	@Override
	public String getIndirizzo() {
		return _segnalazione.getIndirizzo();
	}

	/**
	 * Returns the lat of this segnalazione.
	 *
	 * @return the lat of this segnalazione
	 */
	@Override
	public double getLat() {
		return _segnalazione.getLat();
	}

	/**
	 * Returns the lon of this segnalazione.
	 *
	 * @return the lon of this segnalazione
	 */
	@Override
	public double getLon() {
		return _segnalazione.getLon();
	}

	/**
	 * Returns the modified date of this segnalazione.
	 *
	 * @return the modified date of this segnalazione
	 */
	@Override
	public Date getModifiedDate() {
		return _segnalazione.getModifiedDate();
	}

	/**
	 * Returns the note of this segnalazione.
	 *
	 * @return the note of this segnalazione
	 */
	@Override
	public String getNote() {
		return _segnalazione.getNote();
	}

	/**
	 * Returns the primary key of this segnalazione.
	 *
	 * @return the primary key of this segnalazione
	 */
	@Override
	public long getPrimaryKey() {
		return _segnalazione.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segnalazione.getPrimaryKeyObj();
	}

	/**
	 * Returns the provincia of this segnalazione.
	 *
	 * @return the provincia of this segnalazione
	 */
	@Override
	public String getProvincia() {
		return _segnalazione.getProvincia();
	}

	/**
	 * Returns the riferimento of this segnalazione.
	 *
	 * @return the riferimento of this segnalazione
	 */
	@Override
	public String getRiferimento() {
		return _segnalazione.getRiferimento();
	}

	/**
	 * Returns the sottocategoria of this segnalazione.
	 *
	 * @return the sottocategoria of this segnalazione
	 */
	@Override
	public long getSottocategoria() {
		return _segnalazione.getSottocategoria();
	}

	/**
	 * Returns the user ID of this segnalazione.
	 *
	 * @return the user ID of this segnalazione
	 */
	@Override
	public long getUserId() {
		return _segnalazione.getUserId();
	}

	/**
	 * Returns the user name of this segnalazione.
	 *
	 * @return the user name of this segnalazione
	 */
	@Override
	public String getUserName() {
		return _segnalazione.getUserName();
	}

	/**
	 * Returns the user uuid of this segnalazione.
	 *
	 * @return the user uuid of this segnalazione
	 */
	@Override
	public String getUserUuid() {
		return _segnalazione.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _segnalazione.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _segnalazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _segnalazione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _segnalazione.isNew();
	}

	@Override
	public void persist() {
		_segnalazione.persist();
	}

	/**
	 * Sets the area of this segnalazione.
	 *
	 * @param area the area of this segnalazione
	 */
	@Override
	public void setArea(String area) {
		_segnalazione.setArea(area);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_segnalazione.setCachedModel(cachedModel);
	}

	/**
	 * Sets the categoria of this segnalazione.
	 *
	 * @param categoria the categoria of this segnalazione
	 */
	@Override
	public void setCategoria(long categoria) {
		_segnalazione.setCategoria(categoria);
	}

	/**
	 * Sets the civico of this segnalazione.
	 *
	 * @param civico the civico of this segnalazione
	 */
	@Override
	public void setCivico(String civico) {
		_segnalazione.setCivico(civico);
	}

	/**
	 * Sets the company ID of this segnalazione.
	 *
	 * @param companyId the company ID of this segnalazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		_segnalazione.setCompanyId(companyId);
	}

	/**
	 * Sets the comune of this segnalazione.
	 *
	 * @param comune the comune of this segnalazione
	 */
	@Override
	public void setComune(String comune) {
		_segnalazione.setComune(comune);
	}

	/**
	 * Sets the create date of this segnalazione.
	 *
	 * @param createDate the create date of this segnalazione
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_segnalazione.setCreateDate(createDate);
	}

	/**
	 * Sets the data evento of this segnalazione.
	 *
	 * @param dataEvento the data evento of this segnalazione
	 */
	@Override
	public void setDataEvento(Date dataEvento) {
		_segnalazione.setDataEvento(dataEvento);
	}

	/**
	 * Sets the descrizione of this segnalazione.
	 *
	 * @param descrizione the descrizione of this segnalazione
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_segnalazione.setDescrizione(descrizione);
	}

	/**
	 * Sets the documento associato of this segnalazione.
	 *
	 * @param documentoAssociato the documento associato of this segnalazione
	 */
	@Override
	public void setDocumentoAssociato(long documentoAssociato) {
		_segnalazione.setDocumentoAssociato(documentoAssociato);
	}

	/**
	 * Sets the effetti of this segnalazione.
	 *
	 * @param effetti the effetti of this segnalazione
	 */
	@Override
	public void setEffetti(long effetti) {
		_segnalazione.setEffetti(effetti);
	}

	/**
	 * Sets the effetti sub of this segnalazione.
	 *
	 * @param effettiSub the effetti sub of this segnalazione
	 */
	@Override
	public void setEffettiSub(long effettiSub) {
		_segnalazione.setEffettiSub(effettiSub);
	}

	/**
	 * Sets the ente segnalante of this segnalazione.
	 *
	 * @param enteSegnalante the ente segnalante of this segnalazione
	 */
	@Override
	public void setEnteSegnalante(String enteSegnalante) {
		_segnalazione.setEnteSegnalante(enteSegnalante);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_segnalazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_segnalazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_segnalazione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fonte of this segnalazione.
	 *
	 * @param fonte the fonte of this segnalazione
	 */
	@Override
	public void setFonte(long fonte) {
		_segnalazione.setFonte(fonte);
	}

	/**
	 * Sets the group ID of this segnalazione.
	 *
	 * @param groupId the group ID of this segnalazione
	 */
	@Override
	public void setGroupId(long groupId) {
		_segnalazione.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this segnalazione.
	 *
	 * @param id the ID of this segnalazione
	 */
	@Override
	public void setId(long id) {
		_segnalazione.setId(id);
	}

	/**
	 * Sets the indirizzo of this segnalazione.
	 *
	 * @param indirizzo the indirizzo of this segnalazione
	 */
	@Override
	public void setIndirizzo(String indirizzo) {
		_segnalazione.setIndirizzo(indirizzo);
	}

	/**
	 * Sets the lat of this segnalazione.
	 *
	 * @param lat the lat of this segnalazione
	 */
	@Override
	public void setLat(double lat) {
		_segnalazione.setLat(lat);
	}

	/**
	 * Sets the lon of this segnalazione.
	 *
	 * @param lon the lon of this segnalazione
	 */
	@Override
	public void setLon(double lon) {
		_segnalazione.setLon(lon);
	}

	/**
	 * Sets the modified date of this segnalazione.
	 *
	 * @param modifiedDate the modified date of this segnalazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_segnalazione.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_segnalazione.setNew(n);
	}

	/**
	 * Sets the note of this segnalazione.
	 *
	 * @param note the note of this segnalazione
	 */
	@Override
	public void setNote(String note) {
		_segnalazione.setNote(note);
	}

	/**
	 * Sets the primary key of this segnalazione.
	 *
	 * @param primaryKey the primary key of this segnalazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_segnalazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_segnalazione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the provincia of this segnalazione.
	 *
	 * @param provincia the provincia of this segnalazione
	 */
	@Override
	public void setProvincia(String provincia) {
		_segnalazione.setProvincia(provincia);
	}

	/**
	 * Sets the riferimento of this segnalazione.
	 *
	 * @param riferimento the riferimento of this segnalazione
	 */
	@Override
	public void setRiferimento(String riferimento) {
		_segnalazione.setRiferimento(riferimento);
	}

	/**
	 * Sets the sottocategoria of this segnalazione.
	 *
	 * @param sottocategoria the sottocategoria of this segnalazione
	 */
	@Override
	public void setSottocategoria(long sottocategoria) {
		_segnalazione.setSottocategoria(sottocategoria);
	}

	/**
	 * Sets the user ID of this segnalazione.
	 *
	 * @param userId the user ID of this segnalazione
	 */
	@Override
	public void setUserId(long userId) {
		_segnalazione.setUserId(userId);
	}

	/**
	 * Sets the user name of this segnalazione.
	 *
	 * @param userName the user name of this segnalazione
	 */
	@Override
	public void setUserName(String userName) {
		_segnalazione.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this segnalazione.
	 *
	 * @param userUuid the user uuid of this segnalazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_segnalazione.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.catasto.model.Segnalazione> toCacheModel() {

		return _segnalazione.toCacheModel();
	}

	@Override
	public allerta.catasto.model.Segnalazione toEscapedModel() {
		return new SegnalazioneWrapper(_segnalazione.toEscapedModel());
	}

	@Override
	public String toString() {
		return _segnalazione.toString();
	}

	@Override
	public allerta.catasto.model.Segnalazione toUnescapedModel() {
		return new SegnalazioneWrapper(_segnalazione.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _segnalazione.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegnalazioneWrapper)) {
			return false;
		}

		SegnalazioneWrapper segnalazioneWrapper = (SegnalazioneWrapper)obj;

		if (Objects.equals(_segnalazione, segnalazioneWrapper._segnalazione)) {
			return true;
		}

		return false;
	}

	@Override
	public Segnalazione getWrappedModel() {
		return _segnalazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _segnalazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _segnalazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_segnalazione.resetOriginalValues();
	}

	private final Segnalazione _segnalazione;

}