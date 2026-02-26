/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UtenteLavoro}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoro
 * @generated
 */
public class UtenteLavoroWrapper
	extends BaseModelWrapper<UtenteLavoro>
	implements ModelWrapper<UtenteLavoro>, UtenteLavoro {

	public UtenteLavoroWrapper(UtenteLavoro utenteLavoro) {
		super(utenteLavoro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("documento", getDocumento());
		attributes.put("utente", getUtente());
		attributes.put("ts", getTs());
		attributes.put("attivita", getAttivita());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long documento = (Long)attributes.get("documento");

		if (documento != null) {
			setDocumento(documento);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		Date ts = (Date)attributes.get("ts");

		if (ts != null) {
			setTs(ts);
		}

		String attivita = (String)attributes.get("attivita");

		if (attivita != null) {
			setAttivita(attivita);
		}
	}

	@Override
	public UtenteLavoro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivita of this utente lavoro.
	 *
	 * @return the attivita of this utente lavoro
	 */
	@Override
	public String getAttivita() {
		return model.getAttivita();
	}

	/**
	 * Returns the documento of this utente lavoro.
	 *
	 * @return the documento of this utente lavoro
	 */
	@Override
	public long getDocumento() {
		return model.getDocumento();
	}

	/**
	 * Returns the ID of this utente lavoro.
	 *
	 * @return the ID of this utente lavoro
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this utente lavoro.
	 *
	 * @return the primary key of this utente lavoro
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ts of this utente lavoro.
	 *
	 * @return the ts of this utente lavoro
	 */
	@Override
	public Date getTs() {
		return model.getTs();
	}

	/**
	 * Returns the utente of this utente lavoro.
	 *
	 * @return the utente of this utente lavoro
	 */
	@Override
	public String getUtente() {
		return model.getUtente();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attivita of this utente lavoro.
	 *
	 * @param attivita the attivita of this utente lavoro
	 */
	@Override
	public void setAttivita(String attivita) {
		model.setAttivita(attivita);
	}

	/**
	 * Sets the documento of this utente lavoro.
	 *
	 * @param documento the documento of this utente lavoro
	 */
	@Override
	public void setDocumento(long documento) {
		model.setDocumento(documento);
	}

	/**
	 * Sets the ID of this utente lavoro.
	 *
	 * @param id the ID of this utente lavoro
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this utente lavoro.
	 *
	 * @param primaryKey the primary key of this utente lavoro
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ts of this utente lavoro.
	 *
	 * @param ts the ts of this utente lavoro
	 */
	@Override
	public void setTs(Date ts) {
		model.setTs(ts);
	}

	/**
	 * Sets the utente of this utente lavoro.
	 *
	 * @param utente the utente of this utente lavoro
	 */
	@Override
	public void setUtente(String utente) {
		model.setUtente(utente);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UtenteLavoroWrapper wrap(UtenteLavoro utenteLavoro) {
		return new UtenteLavoroWrapper(utenteLavoro);
	}

}