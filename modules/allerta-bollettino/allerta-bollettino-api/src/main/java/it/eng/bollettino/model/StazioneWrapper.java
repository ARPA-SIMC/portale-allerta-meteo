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
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Stazione}.
 * </p>
 *
 * @author GFAVINI
 * @see Stazione
 * @generated
 */
@ProviderType
public class StazioneWrapper implements Stazione, ModelWrapper<Stazione> {

	public StazioneWrapper(Stazione stazione) {
		_stazione = stazione;
	}

	@Override
	public Class<?> getModelClass() {
		return Stazione.class;
	}

	@Override
	public String getModelClassName() {
		return Stazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("ident", getIdent());
		attributes.put("name", getName());
		attributes.put("lon", getLon());
		attributes.put("lat", getLat());
		attributes.put("height", getHeight());
		attributes.put("idBasin", getIdBasin());
		attributes.put("idSubbasin", getIdSubbasin());
		attributes.put("idCountry", getIdCountry());
		attributes.put("idProvince", getIdProvince());
		attributes.put("idRegion", getIdRegion());
		attributes.put("idMunicipality", getIdMunicipality());
		attributes.put("idMacroarea", getIdMacroarea());
		attributes.put("nameBasin", getNameBasin());
		attributes.put("nameSubbasin", getNameSubbasin());
		attributes.put("nameCountry", getNameCountry());
		attributes.put("nameProvince", getNameProvince());
		attributes.put("nameRegion", getNameRegion());
		attributes.put("nameMunicipality", getNameMunicipality());
		attributes.put("nameMacroarea", getNameMacroarea());
		attributes.put("network", getNetwork());
		attributes.put("attivo", isAttivo());
		attributes.put("incluso", isIncluso());
		attributes.put("progressivo", getProgressivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ident = (String)attributes.get("ident");

		if (ident != null) {
			setIdent(ident);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long lon = (Long)attributes.get("lon");

		if (lon != null) {
			setLon(lon);
		}

		Long lat = (Long)attributes.get("lat");

		if (lat != null) {
			setLat(lat);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		String idBasin = (String)attributes.get("idBasin");

		if (idBasin != null) {
			setIdBasin(idBasin);
		}

		String idSubbasin = (String)attributes.get("idSubbasin");

		if (idSubbasin != null) {
			setIdSubbasin(idSubbasin);
		}

		String idCountry = (String)attributes.get("idCountry");

		if (idCountry != null) {
			setIdCountry(idCountry);
		}

		String idProvince = (String)attributes.get("idProvince");

		if (idProvince != null) {
			setIdProvince(idProvince);
		}

		String idRegion = (String)attributes.get("idRegion");

		if (idRegion != null) {
			setIdRegion(idRegion);
		}

		String idMunicipality = (String)attributes.get("idMunicipality");

		if (idMunicipality != null) {
			setIdMunicipality(idMunicipality);
		}

		String idMacroarea = (String)attributes.get("idMacroarea");

		if (idMacroarea != null) {
			setIdMacroarea(idMacroarea);
		}

		String nameBasin = (String)attributes.get("nameBasin");

		if (nameBasin != null) {
			setNameBasin(nameBasin);
		}

		String nameSubbasin = (String)attributes.get("nameSubbasin");

		if (nameSubbasin != null) {
			setNameSubbasin(nameSubbasin);
		}

		String nameCountry = (String)attributes.get("nameCountry");

		if (nameCountry != null) {
			setNameCountry(nameCountry);
		}

		String nameProvince = (String)attributes.get("nameProvince");

		if (nameProvince != null) {
			setNameProvince(nameProvince);
		}

		String nameRegion = (String)attributes.get("nameRegion");

		if (nameRegion != null) {
			setNameRegion(nameRegion);
		}

		String nameMunicipality = (String)attributes.get("nameMunicipality");

		if (nameMunicipality != null) {
			setNameMunicipality(nameMunicipality);
		}

		String nameMacroarea = (String)attributes.get("nameMacroarea");

		if (nameMacroarea != null) {
			setNameMacroarea(nameMacroarea);
		}

		String network = (String)attributes.get("network");

		if (network != null) {
			setNetwork(network);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}

		Boolean incluso = (Boolean)attributes.get("incluso");

		if (incluso != null) {
			setIncluso(incluso);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}
	}

	@Override
	public Object clone() {
		return new StazioneWrapper((Stazione)_stazione.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Stazione stazione) {
		return _stazione.compareTo(stazione);
	}

	/**
	 * Returns the attivo of this stazione.
	 *
	 * @return the attivo of this stazione
	 */
	@Override
	public boolean getAttivo() {
		return _stazione.getAttivo();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _stazione.getExpandoBridge();
	}

	/**
	 * Returns the height of this stazione.
	 *
	 * @return the height of this stazione
	 */
	@Override
	public double getHeight() {
		return _stazione.getHeight();
	}

	/**
	 * Returns the ID of this stazione.
	 *
	 * @return the ID of this stazione
	 */
	@Override
	public String getId() {
		return _stazione.getId();
	}

	/**
	 * Returns the id basin of this stazione.
	 *
	 * @return the id basin of this stazione
	 */
	@Override
	public String getIdBasin() {
		return _stazione.getIdBasin();
	}

	/**
	 * Returns the id country of this stazione.
	 *
	 * @return the id country of this stazione
	 */
	@Override
	public String getIdCountry() {
		return _stazione.getIdCountry();
	}

	/**
	 * Returns the ident of this stazione.
	 *
	 * @return the ident of this stazione
	 */
	@Override
	public String getIdent() {
		return _stazione.getIdent();
	}

	/**
	 * Returns the id macroarea of this stazione.
	 *
	 * @return the id macroarea of this stazione
	 */
	@Override
	public String getIdMacroarea() {
		return _stazione.getIdMacroarea();
	}

	/**
	 * Returns the id municipality of this stazione.
	 *
	 * @return the id municipality of this stazione
	 */
	@Override
	public String getIdMunicipality() {
		return _stazione.getIdMunicipality();
	}

	/**
	 * Returns the id province of this stazione.
	 *
	 * @return the id province of this stazione
	 */
	@Override
	public String getIdProvince() {
		return _stazione.getIdProvince();
	}

	/**
	 * Returns the id region of this stazione.
	 *
	 * @return the id region of this stazione
	 */
	@Override
	public String getIdRegion() {
		return _stazione.getIdRegion();
	}

	/**
	 * Returns the id subbasin of this stazione.
	 *
	 * @return the id subbasin of this stazione
	 */
	@Override
	public String getIdSubbasin() {
		return _stazione.getIdSubbasin();
	}

	/**
	 * Returns the incluso of this stazione.
	 *
	 * @return the incluso of this stazione
	 */
	@Override
	public boolean getIncluso() {
		return _stazione.getIncluso();
	}

	/**
	 * Returns the lat of this stazione.
	 *
	 * @return the lat of this stazione
	 */
	@Override
	public long getLat() {
		return _stazione.getLat();
	}

	/**
	 * Returns the lon of this stazione.
	 *
	 * @return the lon of this stazione
	 */
	@Override
	public long getLon() {
		return _stazione.getLon();
	}

	/**
	 * Returns the name of this stazione.
	 *
	 * @return the name of this stazione
	 */
	@Override
	public String getName() {
		return _stazione.getName();
	}

	/**
	 * Returns the name basin of this stazione.
	 *
	 * @return the name basin of this stazione
	 */
	@Override
	public String getNameBasin() {
		return _stazione.getNameBasin();
	}

	/**
	 * Returns the name country of this stazione.
	 *
	 * @return the name country of this stazione
	 */
	@Override
	public String getNameCountry() {
		return _stazione.getNameCountry();
	}

	/**
	 * Returns the name macroarea of this stazione.
	 *
	 * @return the name macroarea of this stazione
	 */
	@Override
	public String getNameMacroarea() {
		return _stazione.getNameMacroarea();
	}

	/**
	 * Returns the name municipality of this stazione.
	 *
	 * @return the name municipality of this stazione
	 */
	@Override
	public String getNameMunicipality() {
		return _stazione.getNameMunicipality();
	}

	/**
	 * Returns the name province of this stazione.
	 *
	 * @return the name province of this stazione
	 */
	@Override
	public String getNameProvince() {
		return _stazione.getNameProvince();
	}

	/**
	 * Returns the name region of this stazione.
	 *
	 * @return the name region of this stazione
	 */
	@Override
	public String getNameRegion() {
		return _stazione.getNameRegion();
	}

	/**
	 * Returns the name subbasin of this stazione.
	 *
	 * @return the name subbasin of this stazione
	 */
	@Override
	public String getNameSubbasin() {
		return _stazione.getNameSubbasin();
	}

	/**
	 * Returns the network of this stazione.
	 *
	 * @return the network of this stazione
	 */
	@Override
	public String getNetwork() {
		return _stazione.getNetwork();
	}

	/**
	 * Returns the primary key of this stazione.
	 *
	 * @return the primary key of this stazione
	 */
	@Override
	public String getPrimaryKey() {
		return _stazione.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stazione.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this stazione.
	 *
	 * @return the progressivo of this stazione
	 */
	@Override
	public int getProgressivo() {
		return _stazione.getProgressivo();
	}

	/**
	 * Returns the uuid of this stazione.
	 *
	 * @return the uuid of this stazione
	 */
	@Override
	public String getUuid() {
		return _stazione.getUuid();
	}

	@Override
	public int hashCode() {
		return _stazione.hashCode();
	}

	/**
	 * Returns <code>true</code> if this stazione is attivo.
	 *
	 * @return <code>true</code> if this stazione is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return _stazione.isAttivo();
	}

	@Override
	public boolean isCachedModel() {
		return _stazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _stazione.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this stazione is incluso.
	 *
	 * @return <code>true</code> if this stazione is incluso; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncluso() {
		return _stazione.isIncluso();
	}

	@Override
	public boolean isNew() {
		return _stazione.isNew();
	}

	@Override
	public void persist() {
		_stazione.persist();
	}

	/**
	 * Sets whether this stazione is attivo.
	 *
	 * @param attivo the attivo of this stazione
	 */
	@Override
	public void setAttivo(boolean attivo) {
		_stazione.setAttivo(attivo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stazione.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_stazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_stazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_stazione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the height of this stazione.
	 *
	 * @param height the height of this stazione
	 */
	@Override
	public void setHeight(double height) {
		_stazione.setHeight(height);
	}

	/**
	 * Sets the ID of this stazione.
	 *
	 * @param id the ID of this stazione
	 */
	@Override
	public void setId(String id) {
		_stazione.setId(id);
	}

	/**
	 * Sets the id basin of this stazione.
	 *
	 * @param idBasin the id basin of this stazione
	 */
	@Override
	public void setIdBasin(String idBasin) {
		_stazione.setIdBasin(idBasin);
	}

	/**
	 * Sets the id country of this stazione.
	 *
	 * @param idCountry the id country of this stazione
	 */
	@Override
	public void setIdCountry(String idCountry) {
		_stazione.setIdCountry(idCountry);
	}

	/**
	 * Sets the ident of this stazione.
	 *
	 * @param ident the ident of this stazione
	 */
	@Override
	public void setIdent(String ident) {
		_stazione.setIdent(ident);
	}

	/**
	 * Sets the id macroarea of this stazione.
	 *
	 * @param idMacroarea the id macroarea of this stazione
	 */
	@Override
	public void setIdMacroarea(String idMacroarea) {
		_stazione.setIdMacroarea(idMacroarea);
	}

	/**
	 * Sets the id municipality of this stazione.
	 *
	 * @param idMunicipality the id municipality of this stazione
	 */
	@Override
	public void setIdMunicipality(String idMunicipality) {
		_stazione.setIdMunicipality(idMunicipality);
	}

	/**
	 * Sets the id province of this stazione.
	 *
	 * @param idProvince the id province of this stazione
	 */
	@Override
	public void setIdProvince(String idProvince) {
		_stazione.setIdProvince(idProvince);
	}

	/**
	 * Sets the id region of this stazione.
	 *
	 * @param idRegion the id region of this stazione
	 */
	@Override
	public void setIdRegion(String idRegion) {
		_stazione.setIdRegion(idRegion);
	}

	/**
	 * Sets the id subbasin of this stazione.
	 *
	 * @param idSubbasin the id subbasin of this stazione
	 */
	@Override
	public void setIdSubbasin(String idSubbasin) {
		_stazione.setIdSubbasin(idSubbasin);
	}

	/**
	 * Sets whether this stazione is incluso.
	 *
	 * @param incluso the incluso of this stazione
	 */
	@Override
	public void setIncluso(boolean incluso) {
		_stazione.setIncluso(incluso);
	}

	/**
	 * Sets the lat of this stazione.
	 *
	 * @param lat the lat of this stazione
	 */
	@Override
	public void setLat(long lat) {
		_stazione.setLat(lat);
	}

	/**
	 * Sets the lon of this stazione.
	 *
	 * @param lon the lon of this stazione
	 */
	@Override
	public void setLon(long lon) {
		_stazione.setLon(lon);
	}

	/**
	 * Sets the name of this stazione.
	 *
	 * @param name the name of this stazione
	 */
	@Override
	public void setName(String name) {
		_stazione.setName(name);
	}

	/**
	 * Sets the name basin of this stazione.
	 *
	 * @param nameBasin the name basin of this stazione
	 */
	@Override
	public void setNameBasin(String nameBasin) {
		_stazione.setNameBasin(nameBasin);
	}

	/**
	 * Sets the name country of this stazione.
	 *
	 * @param nameCountry the name country of this stazione
	 */
	@Override
	public void setNameCountry(String nameCountry) {
		_stazione.setNameCountry(nameCountry);
	}

	/**
	 * Sets the name macroarea of this stazione.
	 *
	 * @param nameMacroarea the name macroarea of this stazione
	 */
	@Override
	public void setNameMacroarea(String nameMacroarea) {
		_stazione.setNameMacroarea(nameMacroarea);
	}

	/**
	 * Sets the name municipality of this stazione.
	 *
	 * @param nameMunicipality the name municipality of this stazione
	 */
	@Override
	public void setNameMunicipality(String nameMunicipality) {
		_stazione.setNameMunicipality(nameMunicipality);
	}

	/**
	 * Sets the name province of this stazione.
	 *
	 * @param nameProvince the name province of this stazione
	 */
	@Override
	public void setNameProvince(String nameProvince) {
		_stazione.setNameProvince(nameProvince);
	}

	/**
	 * Sets the name region of this stazione.
	 *
	 * @param nameRegion the name region of this stazione
	 */
	@Override
	public void setNameRegion(String nameRegion) {
		_stazione.setNameRegion(nameRegion);
	}

	/**
	 * Sets the name subbasin of this stazione.
	 *
	 * @param nameSubbasin the name subbasin of this stazione
	 */
	@Override
	public void setNameSubbasin(String nameSubbasin) {
		_stazione.setNameSubbasin(nameSubbasin);
	}

	/**
	 * Sets the network of this stazione.
	 *
	 * @param network the network of this stazione
	 */
	@Override
	public void setNetwork(String network) {
		_stazione.setNetwork(network);
	}

	@Override
	public void setNew(boolean n) {
		_stazione.setNew(n);
	}

	/**
	 * Sets the primary key of this stazione.
	 *
	 * @param primaryKey the primary key of this stazione
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_stazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_stazione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this stazione.
	 *
	 * @param progressivo the progressivo of this stazione
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_stazione.setProgressivo(progressivo);
	}

	/**
	 * Sets the uuid of this stazione.
	 *
	 * @param uuid the uuid of this stazione
	 */
	@Override
	public void setUuid(String uuid) {
		_stazione.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Stazione> toCacheModel() {

		return _stazione.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Stazione toEscapedModel() {
		return new StazioneWrapper(_stazione.toEscapedModel());
	}

	@Override
	public String toString() {
		return _stazione.toString();
	}

	@Override
	public it.eng.bollettino.model.Stazione toUnescapedModel() {
		return new StazioneWrapper(_stazione.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _stazione.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StazioneWrapper)) {
			return false;
		}

		StazioneWrapper stazioneWrapper = (StazioneWrapper)obj;

		if (Objects.equals(_stazione, stazioneWrapper._stazione)) {
			return true;
		}

		return false;
	}

	@Override
	public Stazione getWrappedModel() {
		return _stazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _stazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _stazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_stazione.resetOriginalValues();
	}

	private final Stazione _stazione;

}