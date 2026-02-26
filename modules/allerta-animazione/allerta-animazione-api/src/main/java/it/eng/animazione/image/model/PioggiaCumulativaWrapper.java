/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PioggiaCumulativa}.
 * </p>
 *
 * @author UTENTE
 * @see PioggiaCumulativa
 * @generated
 */
public class PioggiaCumulativaWrapper
	extends BaseModelWrapper<PioggiaCumulativa>
	implements ModelWrapper<PioggiaCumulativa>, PioggiaCumulativa {

	public PioggiaCumulativaWrapper(PioggiaCumulativa pioggiaCumulativa) {
		super(pioggiaCumulativa);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("cumulazione", getCumulazione());
		attributes.put("inzioCumulazione", getInzioCumulazione());
		attributes.put("fineCumulazione", getFineCumulazione());
		attributes.put("imgData", getImgData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String cumulazione = (String)attributes.get("cumulazione");

		if (cumulazione != null) {
			setCumulazione(cumulazione);
		}

		Date inzioCumulazione = (Date)attributes.get("inzioCumulazione");

		if (inzioCumulazione != null) {
			setInzioCumulazione(inzioCumulazione);
		}

		Date fineCumulazione = (Date)attributes.get("fineCumulazione");

		if (fineCumulazione != null) {
			setFineCumulazione(fineCumulazione);
		}

		String imgData = (String)attributes.get("imgData");

		if (imgData != null) {
			setImgData(imgData);
		}
	}

	@Override
	public PioggiaCumulativa cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cumulazione of this pioggia cumulativa.
	 *
	 * @return the cumulazione of this pioggia cumulativa
	 */
	@Override
	public String getCumulazione() {
		return model.getCumulazione();
	}

	/**
	 * Returns the fine cumulazione of this pioggia cumulativa.
	 *
	 * @return the fine cumulazione of this pioggia cumulativa
	 */
	@Override
	public Date getFineCumulazione() {
		return model.getFineCumulazione();
	}

	/**
	 * Returns the ID of this pioggia cumulativa.
	 *
	 * @return the ID of this pioggia cumulativa
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the img data of this pioggia cumulativa.
	 *
	 * @return the img data of this pioggia cumulativa
	 */
	@Override
	public String getImgData() {
		return model.getImgData();
	}

	/**
	 * Returns the inzio cumulazione of this pioggia cumulativa.
	 *
	 * @return the inzio cumulazione of this pioggia cumulativa
	 */
	@Override
	public Date getInzioCumulazione() {
		return model.getInzioCumulazione();
	}

	/**
	 * Returns the nome of this pioggia cumulativa.
	 *
	 * @return the nome of this pioggia cumulativa
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this pioggia cumulativa.
	 *
	 * @return the primary key of this pioggia cumulativa
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cumulazione of this pioggia cumulativa.
	 *
	 * @param cumulazione the cumulazione of this pioggia cumulativa
	 */
	@Override
	public void setCumulazione(String cumulazione) {
		model.setCumulazione(cumulazione);
	}

	/**
	 * Sets the fine cumulazione of this pioggia cumulativa.
	 *
	 * @param fineCumulazione the fine cumulazione of this pioggia cumulativa
	 */
	@Override
	public void setFineCumulazione(Date fineCumulazione) {
		model.setFineCumulazione(fineCumulazione);
	}

	/**
	 * Sets the ID of this pioggia cumulativa.
	 *
	 * @param id the ID of this pioggia cumulativa
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the img data of this pioggia cumulativa.
	 *
	 * @param imgData the img data of this pioggia cumulativa
	 */
	@Override
	public void setImgData(String imgData) {
		model.setImgData(imgData);
	}

	/**
	 * Sets the inzio cumulazione of this pioggia cumulativa.
	 *
	 * @param inzioCumulazione the inzio cumulazione of this pioggia cumulativa
	 */
	@Override
	public void setInzioCumulazione(Date inzioCumulazione) {
		model.setInzioCumulazione(inzioCumulazione);
	}

	/**
	 * Sets the nome of this pioggia cumulativa.
	 *
	 * @param nome the nome of this pioggia cumulativa
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this pioggia cumulativa.
	 *
	 * @param primaryKey the primary key of this pioggia cumulativa
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PioggiaCumulativaWrapper wrap(
		PioggiaCumulativa pioggiaCumulativa) {

		return new PioggiaCumulativaWrapper(pioggiaCumulativa);
	}

}