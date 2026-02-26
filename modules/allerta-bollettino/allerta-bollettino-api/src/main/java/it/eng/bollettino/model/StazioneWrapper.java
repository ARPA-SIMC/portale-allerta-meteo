/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Stazione}.
 * </p>
 *
 * @author GFAVINI
 * @see Stazione
 * @generated
 */
public class StazioneWrapper
	extends BaseModelWrapper<Stazione>
	implements ModelWrapper<Stazione>, Stazione {

	public StazioneWrapper(Stazione stazione) {
		super(stazione);
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
	public Stazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivo of this stazione.
	 *
	 * @return the attivo of this stazione
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the height of this stazione.
	 *
	 * @return the height of this stazione
	 */
	@Override
	public double getHeight() {
		return model.getHeight();
	}

	/**
	 * Returns the ID of this stazione.
	 *
	 * @return the ID of this stazione
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the id basin of this stazione.
	 *
	 * @return the id basin of this stazione
	 */
	@Override
	public String getIdBasin() {
		return model.getIdBasin();
	}

	/**
	 * Returns the id country of this stazione.
	 *
	 * @return the id country of this stazione
	 */
	@Override
	public String getIdCountry() {
		return model.getIdCountry();
	}

	/**
	 * Returns the ident of this stazione.
	 *
	 * @return the ident of this stazione
	 */
	@Override
	public String getIdent() {
		return model.getIdent();
	}

	/**
	 * Returns the id macroarea of this stazione.
	 *
	 * @return the id macroarea of this stazione
	 */
	@Override
	public String getIdMacroarea() {
		return model.getIdMacroarea();
	}

	/**
	 * Returns the id municipality of this stazione.
	 *
	 * @return the id municipality of this stazione
	 */
	@Override
	public String getIdMunicipality() {
		return model.getIdMunicipality();
	}

	/**
	 * Returns the id province of this stazione.
	 *
	 * @return the id province of this stazione
	 */
	@Override
	public String getIdProvince() {
		return model.getIdProvince();
	}

	/**
	 * Returns the id region of this stazione.
	 *
	 * @return the id region of this stazione
	 */
	@Override
	public String getIdRegion() {
		return model.getIdRegion();
	}

	/**
	 * Returns the id subbasin of this stazione.
	 *
	 * @return the id subbasin of this stazione
	 */
	@Override
	public String getIdSubbasin() {
		return model.getIdSubbasin();
	}

	/**
	 * Returns the incluso of this stazione.
	 *
	 * @return the incluso of this stazione
	 */
	@Override
	public boolean getIncluso() {
		return model.getIncluso();
	}

	/**
	 * Returns the lat of this stazione.
	 *
	 * @return the lat of this stazione
	 */
	@Override
	public long getLat() {
		return model.getLat();
	}

	/**
	 * Returns the lon of this stazione.
	 *
	 * @return the lon of this stazione
	 */
	@Override
	public long getLon() {
		return model.getLon();
	}

	/**
	 * Returns the name of this stazione.
	 *
	 * @return the name of this stazione
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the name basin of this stazione.
	 *
	 * @return the name basin of this stazione
	 */
	@Override
	public String getNameBasin() {
		return model.getNameBasin();
	}

	/**
	 * Returns the name country of this stazione.
	 *
	 * @return the name country of this stazione
	 */
	@Override
	public String getNameCountry() {
		return model.getNameCountry();
	}

	/**
	 * Returns the name macroarea of this stazione.
	 *
	 * @return the name macroarea of this stazione
	 */
	@Override
	public String getNameMacroarea() {
		return model.getNameMacroarea();
	}

	/**
	 * Returns the name municipality of this stazione.
	 *
	 * @return the name municipality of this stazione
	 */
	@Override
	public String getNameMunicipality() {
		return model.getNameMunicipality();
	}

	/**
	 * Returns the name province of this stazione.
	 *
	 * @return the name province of this stazione
	 */
	@Override
	public String getNameProvince() {
		return model.getNameProvince();
	}

	/**
	 * Returns the name region of this stazione.
	 *
	 * @return the name region of this stazione
	 */
	@Override
	public String getNameRegion() {
		return model.getNameRegion();
	}

	/**
	 * Returns the name subbasin of this stazione.
	 *
	 * @return the name subbasin of this stazione
	 */
	@Override
	public String getNameSubbasin() {
		return model.getNameSubbasin();
	}

	/**
	 * Returns the network of this stazione.
	 *
	 * @return the network of this stazione
	 */
	@Override
	public String getNetwork() {
		return model.getNetwork();
	}

	/**
	 * Returns the primary key of this stazione.
	 *
	 * @return the primary key of this stazione
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this stazione.
	 *
	 * @return the progressivo of this stazione
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	/**
	 * Returns the uuid of this stazione.
	 *
	 * @return the uuid of this stazione
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this stazione is attivo.
	 *
	 * @return <code>true</code> if this stazione is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	/**
	 * Returns <code>true</code> if this stazione is incluso.
	 *
	 * @return <code>true</code> if this stazione is incluso; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncluso() {
		return model.isIncluso();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this stazione is attivo.
	 *
	 * @param attivo the attivo of this stazione
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets the height of this stazione.
	 *
	 * @param height the height of this stazione
	 */
	@Override
	public void setHeight(double height) {
		model.setHeight(height);
	}

	/**
	 * Sets the ID of this stazione.
	 *
	 * @param id the ID of this stazione
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the id basin of this stazione.
	 *
	 * @param idBasin the id basin of this stazione
	 */
	@Override
	public void setIdBasin(String idBasin) {
		model.setIdBasin(idBasin);
	}

	/**
	 * Sets the id country of this stazione.
	 *
	 * @param idCountry the id country of this stazione
	 */
	@Override
	public void setIdCountry(String idCountry) {
		model.setIdCountry(idCountry);
	}

	/**
	 * Sets the ident of this stazione.
	 *
	 * @param ident the ident of this stazione
	 */
	@Override
	public void setIdent(String ident) {
		model.setIdent(ident);
	}

	/**
	 * Sets the id macroarea of this stazione.
	 *
	 * @param idMacroarea the id macroarea of this stazione
	 */
	@Override
	public void setIdMacroarea(String idMacroarea) {
		model.setIdMacroarea(idMacroarea);
	}

	/**
	 * Sets the id municipality of this stazione.
	 *
	 * @param idMunicipality the id municipality of this stazione
	 */
	@Override
	public void setIdMunicipality(String idMunicipality) {
		model.setIdMunicipality(idMunicipality);
	}

	/**
	 * Sets the id province of this stazione.
	 *
	 * @param idProvince the id province of this stazione
	 */
	@Override
	public void setIdProvince(String idProvince) {
		model.setIdProvince(idProvince);
	}

	/**
	 * Sets the id region of this stazione.
	 *
	 * @param idRegion the id region of this stazione
	 */
	@Override
	public void setIdRegion(String idRegion) {
		model.setIdRegion(idRegion);
	}

	/**
	 * Sets the id subbasin of this stazione.
	 *
	 * @param idSubbasin the id subbasin of this stazione
	 */
	@Override
	public void setIdSubbasin(String idSubbasin) {
		model.setIdSubbasin(idSubbasin);
	}

	/**
	 * Sets whether this stazione is incluso.
	 *
	 * @param incluso the incluso of this stazione
	 */
	@Override
	public void setIncluso(boolean incluso) {
		model.setIncluso(incluso);
	}

	/**
	 * Sets the lat of this stazione.
	 *
	 * @param lat the lat of this stazione
	 */
	@Override
	public void setLat(long lat) {
		model.setLat(lat);
	}

	/**
	 * Sets the lon of this stazione.
	 *
	 * @param lon the lon of this stazione
	 */
	@Override
	public void setLon(long lon) {
		model.setLon(lon);
	}

	/**
	 * Sets the name of this stazione.
	 *
	 * @param name the name of this stazione
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the name basin of this stazione.
	 *
	 * @param nameBasin the name basin of this stazione
	 */
	@Override
	public void setNameBasin(String nameBasin) {
		model.setNameBasin(nameBasin);
	}

	/**
	 * Sets the name country of this stazione.
	 *
	 * @param nameCountry the name country of this stazione
	 */
	@Override
	public void setNameCountry(String nameCountry) {
		model.setNameCountry(nameCountry);
	}

	/**
	 * Sets the name macroarea of this stazione.
	 *
	 * @param nameMacroarea the name macroarea of this stazione
	 */
	@Override
	public void setNameMacroarea(String nameMacroarea) {
		model.setNameMacroarea(nameMacroarea);
	}

	/**
	 * Sets the name municipality of this stazione.
	 *
	 * @param nameMunicipality the name municipality of this stazione
	 */
	@Override
	public void setNameMunicipality(String nameMunicipality) {
		model.setNameMunicipality(nameMunicipality);
	}

	/**
	 * Sets the name province of this stazione.
	 *
	 * @param nameProvince the name province of this stazione
	 */
	@Override
	public void setNameProvince(String nameProvince) {
		model.setNameProvince(nameProvince);
	}

	/**
	 * Sets the name region of this stazione.
	 *
	 * @param nameRegion the name region of this stazione
	 */
	@Override
	public void setNameRegion(String nameRegion) {
		model.setNameRegion(nameRegion);
	}

	/**
	 * Sets the name subbasin of this stazione.
	 *
	 * @param nameSubbasin the name subbasin of this stazione
	 */
	@Override
	public void setNameSubbasin(String nameSubbasin) {
		model.setNameSubbasin(nameSubbasin);
	}

	/**
	 * Sets the network of this stazione.
	 *
	 * @param network the network of this stazione
	 */
	@Override
	public void setNetwork(String network) {
		model.setNetwork(network);
	}

	/**
	 * Sets the primary key of this stazione.
	 *
	 * @param primaryKey the primary key of this stazione
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this stazione.
	 *
	 * @param progressivo the progressivo of this stazione
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the uuid of this stazione.
	 *
	 * @param uuid the uuid of this stazione
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected StazioneWrapper wrap(Stazione stazione) {
		return new StazioneWrapper(stazione);
	}

}