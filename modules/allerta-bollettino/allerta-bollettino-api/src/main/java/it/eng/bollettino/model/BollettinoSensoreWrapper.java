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
 * This class is a wrapper for {@link BollettinoSensore}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoSensore
 * @generated
 */
@ProviderType
public class BollettinoSensoreWrapper
	implements BollettinoSensore, ModelWrapper<BollettinoSensore> {

	public BollettinoSensoreWrapper(BollettinoSensore bollettinoSensore) {
		_bollettinoSensore = bollettinoSensore;
	}

	@Override
	public Class<?> getModelClass() {
		return BollettinoSensore.class;
	}

	@Override
	public String getModelClassName() {
		return BollettinoSensore.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idBollettino", getIdBollettino());
		attributes.put("idStazione", getIdStazione());
		attributes.put("idBollettinoBacino", getIdBollettinoBacino());
		attributes.put("progressivo", getProgressivo());
		attributes.put("nomeStazione", getNomeStazione());
		attributes.put("oreOsservazione", getOreOsservazione());
		attributes.put("osservazione", getOsservazione());
		attributes.put("tendenza", getTendenza());
		attributes.put("colmoPrevisto", getColmoPrevisto());
		attributes.put("oraPrevista", getOraPrevista());
		attributes.put("soglia1", getSoglia1());
		attributes.put("soglia2", getSoglia2());
		attributes.put("soglia3", getSoglia3());
		attributes.put("giornoPrevisto", getGiornoPrevisto());
		attributes.put("osservato", isOsservato());

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

		Long idBollettino = (Long)attributes.get("idBollettino");

		if (idBollettino != null) {
			setIdBollettino(idBollettino);
		}

		Long idStazione = (Long)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}

		Long idBollettinoBacino = (Long)attributes.get("idBollettinoBacino");

		if (idBollettinoBacino != null) {
			setIdBollettinoBacino(idBollettinoBacino);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		String nomeStazione = (String)attributes.get("nomeStazione");

		if (nomeStazione != null) {
			setNomeStazione(nomeStazione);
		}

		String oreOsservazione = (String)attributes.get("oreOsservazione");

		if (oreOsservazione != null) {
			setOreOsservazione(oreOsservazione);
		}

		Double osservazione = (Double)attributes.get("osservazione");

		if (osservazione != null) {
			setOsservazione(osservazione);
		}

		Integer tendenza = (Integer)attributes.get("tendenza");

		if (tendenza != null) {
			setTendenza(tendenza);
		}

		String colmoPrevisto = (String)attributes.get("colmoPrevisto");

		if (colmoPrevisto != null) {
			setColmoPrevisto(colmoPrevisto);
		}

		String oraPrevista = (String)attributes.get("oraPrevista");

		if (oraPrevista != null) {
			setOraPrevista(oraPrevista);
		}

		Double soglia1 = (Double)attributes.get("soglia1");

		if (soglia1 != null) {
			setSoglia1(soglia1);
		}

		Double soglia2 = (Double)attributes.get("soglia2");

		if (soglia2 != null) {
			setSoglia2(soglia2);
		}

		Double soglia3 = (Double)attributes.get("soglia3");

		if (soglia3 != null) {
			setSoglia3(soglia3);
		}

		String giornoPrevisto = (String)attributes.get("giornoPrevisto");

		if (giornoPrevisto != null) {
			setGiornoPrevisto(giornoPrevisto);
		}

		Boolean osservato = (Boolean)attributes.get("osservato");

		if (osservato != null) {
			setOsservato(osservato);
		}
	}

	@Override
	public Object clone() {
		return new BollettinoSensoreWrapper(
			(BollettinoSensore)_bollettinoSensore.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.BollettinoSensore bollettinoSensore) {

		return _bollettinoSensore.compareTo(bollettinoSensore);
	}

	/**
	 * Returns the colmo previsto of this bollettino sensore.
	 *
	 * @return the colmo previsto of this bollettino sensore
	 */
	@Override
	public String getColmoPrevisto() {
		return _bollettinoSensore.getColmoPrevisto();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bollettinoSensore.getExpandoBridge();
	}

	/**
	 * Returns the giorno previsto of this bollettino sensore.
	 *
	 * @return the giorno previsto of this bollettino sensore
	 */
	@Override
	public String getGiornoPrevisto() {
		return _bollettinoSensore.getGiornoPrevisto();
	}

	/**
	 * Returns the ID of this bollettino sensore.
	 *
	 * @return the ID of this bollettino sensore
	 */
	@Override
	public long getId() {
		return _bollettinoSensore.getId();
	}

	/**
	 * Returns the id bollettino of this bollettino sensore.
	 *
	 * @return the id bollettino of this bollettino sensore
	 */
	@Override
	public long getIdBollettino() {
		return _bollettinoSensore.getIdBollettino();
	}

	/**
	 * Returns the id bollettino bacino of this bollettino sensore.
	 *
	 * @return the id bollettino bacino of this bollettino sensore
	 */
	@Override
	public long getIdBollettinoBacino() {
		return _bollettinoSensore.getIdBollettinoBacino();
	}

	/**
	 * Returns the id stazione of this bollettino sensore.
	 *
	 * @return the id stazione of this bollettino sensore
	 */
	@Override
	public long getIdStazione() {
		return _bollettinoSensore.getIdStazione();
	}

	/**
	 * Returns the nome stazione of this bollettino sensore.
	 *
	 * @return the nome stazione of this bollettino sensore
	 */
	@Override
	public String getNomeStazione() {
		return _bollettinoSensore.getNomeStazione();
	}

	/**
	 * Returns the ora prevista of this bollettino sensore.
	 *
	 * @return the ora prevista of this bollettino sensore
	 */
	@Override
	public String getOraPrevista() {
		return _bollettinoSensore.getOraPrevista();
	}

	/**
	 * Returns the ore osservazione of this bollettino sensore.
	 *
	 * @return the ore osservazione of this bollettino sensore
	 */
	@Override
	public String getOreOsservazione() {
		return _bollettinoSensore.getOreOsservazione();
	}

	/**
	 * Returns the osservato of this bollettino sensore.
	 *
	 * @return the osservato of this bollettino sensore
	 */
	@Override
	public boolean getOsservato() {
		return _bollettinoSensore.getOsservato();
	}

	/**
	 * Returns the osservazione of this bollettino sensore.
	 *
	 * @return the osservazione of this bollettino sensore
	 */
	@Override
	public double getOsservazione() {
		return _bollettinoSensore.getOsservazione();
	}

	/**
	 * Returns the primary key of this bollettino sensore.
	 *
	 * @return the primary key of this bollettino sensore
	 */
	@Override
	public long getPrimaryKey() {
		return _bollettinoSensore.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bollettinoSensore.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this bollettino sensore.
	 *
	 * @return the progressivo of this bollettino sensore
	 */
	@Override
	public int getProgressivo() {
		return _bollettinoSensore.getProgressivo();
	}

	/**
	 * Returns the soglia1 of this bollettino sensore.
	 *
	 * @return the soglia1 of this bollettino sensore
	 */
	@Override
	public double getSoglia1() {
		return _bollettinoSensore.getSoglia1();
	}

	/**
	 * Returns the soglia2 of this bollettino sensore.
	 *
	 * @return the soglia2 of this bollettino sensore
	 */
	@Override
	public double getSoglia2() {
		return _bollettinoSensore.getSoglia2();
	}

	/**
	 * Returns the soglia3 of this bollettino sensore.
	 *
	 * @return the soglia3 of this bollettino sensore
	 */
	@Override
	public double getSoglia3() {
		return _bollettinoSensore.getSoglia3();
	}

	/**
	 * Returns the tendenza of this bollettino sensore.
	 *
	 * @return the tendenza of this bollettino sensore
	 */
	@Override
	public int getTendenza() {
		return _bollettinoSensore.getTendenza();
	}

	/**
	 * Returns the uuid of this bollettino sensore.
	 *
	 * @return the uuid of this bollettino sensore
	 */
	@Override
	public String getUuid() {
		return _bollettinoSensore.getUuid();
	}

	@Override
	public int hashCode() {
		return _bollettinoSensore.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bollettinoSensore.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bollettinoSensore.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bollettinoSensore.isNew();
	}

	/**
	 * Returns <code>true</code> if this bollettino sensore is osservato.
	 *
	 * @return <code>true</code> if this bollettino sensore is osservato; <code>false</code> otherwise
	 */
	@Override
	public boolean isOsservato() {
		return _bollettinoSensore.isOsservato();
	}

	@Override
	public void persist() {
		_bollettinoSensore.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bollettinoSensore.setCachedModel(cachedModel);
	}

	/**
	 * Sets the colmo previsto of this bollettino sensore.
	 *
	 * @param colmoPrevisto the colmo previsto of this bollettino sensore
	 */
	@Override
	public void setColmoPrevisto(String colmoPrevisto) {
		_bollettinoSensore.setColmoPrevisto(colmoPrevisto);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bollettinoSensore.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bollettinoSensore.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bollettinoSensore.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the giorno previsto of this bollettino sensore.
	 *
	 * @param giornoPrevisto the giorno previsto of this bollettino sensore
	 */
	@Override
	public void setGiornoPrevisto(String giornoPrevisto) {
		_bollettinoSensore.setGiornoPrevisto(giornoPrevisto);
	}

	/**
	 * Sets the ID of this bollettino sensore.
	 *
	 * @param id the ID of this bollettino sensore
	 */
	@Override
	public void setId(long id) {
		_bollettinoSensore.setId(id);
	}

	/**
	 * Sets the id bollettino of this bollettino sensore.
	 *
	 * @param idBollettino the id bollettino of this bollettino sensore
	 */
	@Override
	public void setIdBollettino(long idBollettino) {
		_bollettinoSensore.setIdBollettino(idBollettino);
	}

	/**
	 * Sets the id bollettino bacino of this bollettino sensore.
	 *
	 * @param idBollettinoBacino the id bollettino bacino of this bollettino sensore
	 */
	@Override
	public void setIdBollettinoBacino(long idBollettinoBacino) {
		_bollettinoSensore.setIdBollettinoBacino(idBollettinoBacino);
	}

	/**
	 * Sets the id stazione of this bollettino sensore.
	 *
	 * @param idStazione the id stazione of this bollettino sensore
	 */
	@Override
	public void setIdStazione(long idStazione) {
		_bollettinoSensore.setIdStazione(idStazione);
	}

	@Override
	public void setNew(boolean n) {
		_bollettinoSensore.setNew(n);
	}

	/**
	 * Sets the nome stazione of this bollettino sensore.
	 *
	 * @param nomeStazione the nome stazione of this bollettino sensore
	 */
	@Override
	public void setNomeStazione(String nomeStazione) {
		_bollettinoSensore.setNomeStazione(nomeStazione);
	}

	/**
	 * Sets the ora prevista of this bollettino sensore.
	 *
	 * @param oraPrevista the ora prevista of this bollettino sensore
	 */
	@Override
	public void setOraPrevista(String oraPrevista) {
		_bollettinoSensore.setOraPrevista(oraPrevista);
	}

	/**
	 * Sets the ore osservazione of this bollettino sensore.
	 *
	 * @param oreOsservazione the ore osservazione of this bollettino sensore
	 */
	@Override
	public void setOreOsservazione(String oreOsservazione) {
		_bollettinoSensore.setOreOsservazione(oreOsservazione);
	}

	/**
	 * Sets whether this bollettino sensore is osservato.
	 *
	 * @param osservato the osservato of this bollettino sensore
	 */
	@Override
	public void setOsservato(boolean osservato) {
		_bollettinoSensore.setOsservato(osservato);
	}

	/**
	 * Sets the osservazione of this bollettino sensore.
	 *
	 * @param osservazione the osservazione of this bollettino sensore
	 */
	@Override
	public void setOsservazione(double osservazione) {
		_bollettinoSensore.setOsservazione(osservazione);
	}

	/**
	 * Sets the primary key of this bollettino sensore.
	 *
	 * @param primaryKey the primary key of this bollettino sensore
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bollettinoSensore.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bollettinoSensore.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this bollettino sensore.
	 *
	 * @param progressivo the progressivo of this bollettino sensore
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_bollettinoSensore.setProgressivo(progressivo);
	}

	/**
	 * Sets the soglia1 of this bollettino sensore.
	 *
	 * @param soglia1 the soglia1 of this bollettino sensore
	 */
	@Override
	public void setSoglia1(double soglia1) {
		_bollettinoSensore.setSoglia1(soglia1);
	}

	/**
	 * Sets the soglia2 of this bollettino sensore.
	 *
	 * @param soglia2 the soglia2 of this bollettino sensore
	 */
	@Override
	public void setSoglia2(double soglia2) {
		_bollettinoSensore.setSoglia2(soglia2);
	}

	/**
	 * Sets the soglia3 of this bollettino sensore.
	 *
	 * @param soglia3 the soglia3 of this bollettino sensore
	 */
	@Override
	public void setSoglia3(double soglia3) {
		_bollettinoSensore.setSoglia3(soglia3);
	}

	/**
	 * Sets the tendenza of this bollettino sensore.
	 *
	 * @param tendenza the tendenza of this bollettino sensore
	 */
	@Override
	public void setTendenza(int tendenza) {
		_bollettinoSensore.setTendenza(tendenza);
	}

	/**
	 * Sets the uuid of this bollettino sensore.
	 *
	 * @param uuid the uuid of this bollettino sensore
	 */
	@Override
	public void setUuid(String uuid) {
		_bollettinoSensore.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.BollettinoSensore> toCacheModel() {

		return _bollettinoSensore.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.BollettinoSensore toEscapedModel() {
		return new BollettinoSensoreWrapper(
			_bollettinoSensore.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bollettinoSensore.toString();
	}

	@Override
	public it.eng.bollettino.model.BollettinoSensore toUnescapedModel() {
		return new BollettinoSensoreWrapper(
			_bollettinoSensore.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bollettinoSensore.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoSensoreWrapper)) {
			return false;
		}

		BollettinoSensoreWrapper bollettinoSensoreWrapper =
			(BollettinoSensoreWrapper)obj;

		if (Objects.equals(
				_bollettinoSensore,
				bollettinoSensoreWrapper._bollettinoSensore)) {

			return true;
		}

		return false;
	}

	@Override
	public BollettinoSensore getWrappedModel() {
		return _bollettinoSensore;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bollettinoSensore.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bollettinoSensore.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bollettinoSensore.resetOriginalValues();
	}

	private final BollettinoSensore _bollettinoSensore;

}