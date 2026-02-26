/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EffettiSub}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSub
 * @generated
 */
public class EffettiSubWrapper
	extends BaseModelWrapper<EffettiSub>
	implements EffettiSub, ModelWrapper<EffettiSub> {

	public EffettiSubWrapper(EffettiSub effettiSub) {
		super(effettiSub);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idEffetti", getIdEffetti());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idEffetti = (Long)attributes.get("idEffetti");

		if (idEffetti != null) {
			setIdEffetti(idEffetti);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public EffettiSub cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this effetti sub.
	 *
	 * @return the descrizione of this effetti sub
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the ID of this effetti sub.
	 *
	 * @return the ID of this effetti sub
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id effetti of this effetti sub.
	 *
	 * @return the id effetti of this effetti sub
	 */
	@Override
	public long getIdEffetti() {
		return model.getIdEffetti();
	}

	/**
	 * Returns the primary key of this effetti sub.
	 *
	 * @return the primary key of this effetti sub
	 */
	@Override
	public allerta.catasto.service.persistence.EffettiSubPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the descrizione of this effetti sub.
	 *
	 * @param descrizione the descrizione of this effetti sub
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the ID of this effetti sub.
	 *
	 * @param id the ID of this effetti sub
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id effetti of this effetti sub.
	 *
	 * @param idEffetti the id effetti of this effetti sub
	 */
	@Override
	public void setIdEffetti(long idEffetti) {
		model.setIdEffetti(idEffetti);
	}

	/**
	 * Sets the primary key of this effetti sub.
	 *
	 * @param primaryKey the primary key of this effetti sub
	 */
	@Override
	public void setPrimaryKey(
		allerta.catasto.service.persistence.EffettiSubPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected EffettiSubWrapper wrap(EffettiSub effettiSub) {
		return new EffettiSubWrapper(effettiSub);
	}

}