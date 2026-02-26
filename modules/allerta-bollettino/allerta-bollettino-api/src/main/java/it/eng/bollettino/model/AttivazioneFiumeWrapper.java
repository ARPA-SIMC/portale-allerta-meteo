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
 * This class is a wrapper for {@link AttivazioneFiume}.
 * </p>
 *
 * @author GFAVINI
 * @see AttivazioneFiume
 * @generated
 */
public class AttivazioneFiumeWrapper
	extends BaseModelWrapper<AttivazioneFiume>
	implements AttivazioneFiume, ModelWrapper<AttivazioneFiume> {

	public AttivazioneFiumeWrapper(AttivazioneFiume attivazioneFiume) {
		super(attivazioneFiume);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fiumeId", getFiumeId());
		attributes.put("attivo", isAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String fiumeId = (String)attributes.get("fiumeId");

		if (fiumeId != null) {
			setFiumeId(fiumeId);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public AttivazioneFiume cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivo of this attivazione fiume.
	 *
	 * @return the attivo of this attivazione fiume
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the fiume ID of this attivazione fiume.
	 *
	 * @return the fiume ID of this attivazione fiume
	 */
	@Override
	public String getFiumeId() {
		return model.getFiumeId();
	}

	/**
	 * Returns the primary key of this attivazione fiume.
	 *
	 * @return the primary key of this attivazione fiume
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this attivazione fiume is attivo.
	 *
	 * @return <code>true</code> if this attivazione fiume is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this attivazione fiume is attivo.
	 *
	 * @param attivo the attivo of this attivazione fiume
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets the fiume ID of this attivazione fiume.
	 *
	 * @param fiumeId the fiume ID of this attivazione fiume
	 */
	@Override
	public void setFiumeId(String fiumeId) {
		model.setFiumeId(fiumeId);
	}

	/**
	 * Sets the primary key of this attivazione fiume.
	 *
	 * @param primaryKey the primary key of this attivazione fiume
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AttivazioneFiumeWrapper wrap(AttivazioneFiume attivazioneFiume) {
		return new AttivazioneFiumeWrapper(attivazioneFiume);
	}

}