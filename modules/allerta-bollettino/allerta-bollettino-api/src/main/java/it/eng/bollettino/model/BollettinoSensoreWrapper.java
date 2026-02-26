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
 * This class is a wrapper for {@link BollettinoSensore}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoSensore
 * @generated
 */
public class BollettinoSensoreWrapper
	extends BaseModelWrapper<BollettinoSensore>
	implements BollettinoSensore, ModelWrapper<BollettinoSensore> {

	public BollettinoSensoreWrapper(BollettinoSensore bollettinoSensore) {
		super(bollettinoSensore);
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
	public BollettinoSensore cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the colmo previsto of this bollettino sensore.
	 *
	 * @return the colmo previsto of this bollettino sensore
	 */
	@Override
	public String getColmoPrevisto() {
		return model.getColmoPrevisto();
	}

	/**
	 * Returns the giorno previsto of this bollettino sensore.
	 *
	 * @return the giorno previsto of this bollettino sensore
	 */
	@Override
	public String getGiornoPrevisto() {
		return model.getGiornoPrevisto();
	}

	/**
	 * Returns the ID of this bollettino sensore.
	 *
	 * @return the ID of this bollettino sensore
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id bollettino of this bollettino sensore.
	 *
	 * @return the id bollettino of this bollettino sensore
	 */
	@Override
	public long getIdBollettino() {
		return model.getIdBollettino();
	}

	/**
	 * Returns the id bollettino bacino of this bollettino sensore.
	 *
	 * @return the id bollettino bacino of this bollettino sensore
	 */
	@Override
	public long getIdBollettinoBacino() {
		return model.getIdBollettinoBacino();
	}

	/**
	 * Returns the id stazione of this bollettino sensore.
	 *
	 * @return the id stazione of this bollettino sensore
	 */
	@Override
	public long getIdStazione() {
		return model.getIdStazione();
	}

	/**
	 * Returns the nome stazione of this bollettino sensore.
	 *
	 * @return the nome stazione of this bollettino sensore
	 */
	@Override
	public String getNomeStazione() {
		return model.getNomeStazione();
	}

	/**
	 * Returns the ora prevista of this bollettino sensore.
	 *
	 * @return the ora prevista of this bollettino sensore
	 */
	@Override
	public String getOraPrevista() {
		return model.getOraPrevista();
	}

	/**
	 * Returns the ore osservazione of this bollettino sensore.
	 *
	 * @return the ore osservazione of this bollettino sensore
	 */
	@Override
	public String getOreOsservazione() {
		return model.getOreOsservazione();
	}

	/**
	 * Returns the osservato of this bollettino sensore.
	 *
	 * @return the osservato of this bollettino sensore
	 */
	@Override
	public boolean getOsservato() {
		return model.getOsservato();
	}

	/**
	 * Returns the osservazione of this bollettino sensore.
	 *
	 * @return the osservazione of this bollettino sensore
	 */
	@Override
	public double getOsservazione() {
		return model.getOsservazione();
	}

	/**
	 * Returns the primary key of this bollettino sensore.
	 *
	 * @return the primary key of this bollettino sensore
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this bollettino sensore.
	 *
	 * @return the progressivo of this bollettino sensore
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	/**
	 * Returns the soglia1 of this bollettino sensore.
	 *
	 * @return the soglia1 of this bollettino sensore
	 */
	@Override
	public double getSoglia1() {
		return model.getSoglia1();
	}

	/**
	 * Returns the soglia2 of this bollettino sensore.
	 *
	 * @return the soglia2 of this bollettino sensore
	 */
	@Override
	public double getSoglia2() {
		return model.getSoglia2();
	}

	/**
	 * Returns the soglia3 of this bollettino sensore.
	 *
	 * @return the soglia3 of this bollettino sensore
	 */
	@Override
	public double getSoglia3() {
		return model.getSoglia3();
	}

	/**
	 * Returns the tendenza of this bollettino sensore.
	 *
	 * @return the tendenza of this bollettino sensore
	 */
	@Override
	public int getTendenza() {
		return model.getTendenza();
	}

	/**
	 * Returns the uuid of this bollettino sensore.
	 *
	 * @return the uuid of this bollettino sensore
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this bollettino sensore is osservato.
	 *
	 * @return <code>true</code> if this bollettino sensore is osservato; <code>false</code> otherwise
	 */
	@Override
	public boolean isOsservato() {
		return model.isOsservato();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the colmo previsto of this bollettino sensore.
	 *
	 * @param colmoPrevisto the colmo previsto of this bollettino sensore
	 */
	@Override
	public void setColmoPrevisto(String colmoPrevisto) {
		model.setColmoPrevisto(colmoPrevisto);
	}

	/**
	 * Sets the giorno previsto of this bollettino sensore.
	 *
	 * @param giornoPrevisto the giorno previsto of this bollettino sensore
	 */
	@Override
	public void setGiornoPrevisto(String giornoPrevisto) {
		model.setGiornoPrevisto(giornoPrevisto);
	}

	/**
	 * Sets the ID of this bollettino sensore.
	 *
	 * @param id the ID of this bollettino sensore
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id bollettino of this bollettino sensore.
	 *
	 * @param idBollettino the id bollettino of this bollettino sensore
	 */
	@Override
	public void setIdBollettino(long idBollettino) {
		model.setIdBollettino(idBollettino);
	}

	/**
	 * Sets the id bollettino bacino of this bollettino sensore.
	 *
	 * @param idBollettinoBacino the id bollettino bacino of this bollettino sensore
	 */
	@Override
	public void setIdBollettinoBacino(long idBollettinoBacino) {
		model.setIdBollettinoBacino(idBollettinoBacino);
	}

	/**
	 * Sets the id stazione of this bollettino sensore.
	 *
	 * @param idStazione the id stazione of this bollettino sensore
	 */
	@Override
	public void setIdStazione(long idStazione) {
		model.setIdStazione(idStazione);
	}

	/**
	 * Sets the nome stazione of this bollettino sensore.
	 *
	 * @param nomeStazione the nome stazione of this bollettino sensore
	 */
	@Override
	public void setNomeStazione(String nomeStazione) {
		model.setNomeStazione(nomeStazione);
	}

	/**
	 * Sets the ora prevista of this bollettino sensore.
	 *
	 * @param oraPrevista the ora prevista of this bollettino sensore
	 */
	@Override
	public void setOraPrevista(String oraPrevista) {
		model.setOraPrevista(oraPrevista);
	}

	/**
	 * Sets the ore osservazione of this bollettino sensore.
	 *
	 * @param oreOsservazione the ore osservazione of this bollettino sensore
	 */
	@Override
	public void setOreOsservazione(String oreOsservazione) {
		model.setOreOsservazione(oreOsservazione);
	}

	/**
	 * Sets whether this bollettino sensore is osservato.
	 *
	 * @param osservato the osservato of this bollettino sensore
	 */
	@Override
	public void setOsservato(boolean osservato) {
		model.setOsservato(osservato);
	}

	/**
	 * Sets the osservazione of this bollettino sensore.
	 *
	 * @param osservazione the osservazione of this bollettino sensore
	 */
	@Override
	public void setOsservazione(double osservazione) {
		model.setOsservazione(osservazione);
	}

	/**
	 * Sets the primary key of this bollettino sensore.
	 *
	 * @param primaryKey the primary key of this bollettino sensore
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this bollettino sensore.
	 *
	 * @param progressivo the progressivo of this bollettino sensore
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the soglia1 of this bollettino sensore.
	 *
	 * @param soglia1 the soglia1 of this bollettino sensore
	 */
	@Override
	public void setSoglia1(double soglia1) {
		model.setSoglia1(soglia1);
	}

	/**
	 * Sets the soglia2 of this bollettino sensore.
	 *
	 * @param soglia2 the soglia2 of this bollettino sensore
	 */
	@Override
	public void setSoglia2(double soglia2) {
		model.setSoglia2(soglia2);
	}

	/**
	 * Sets the soglia3 of this bollettino sensore.
	 *
	 * @param soglia3 the soglia3 of this bollettino sensore
	 */
	@Override
	public void setSoglia3(double soglia3) {
		model.setSoglia3(soglia3);
	}

	/**
	 * Sets the tendenza of this bollettino sensore.
	 *
	 * @param tendenza the tendenza of this bollettino sensore
	 */
	@Override
	public void setTendenza(int tendenza) {
		model.setTendenza(tendenza);
	}

	/**
	 * Sets the uuid of this bollettino sensore.
	 *
	 * @param uuid the uuid of this bollettino sensore
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
	protected BollettinoSensoreWrapper wrap(
		BollettinoSensore bollettinoSensore) {

		return new BollettinoSensoreWrapper(bollettinoSensore);
	}

}