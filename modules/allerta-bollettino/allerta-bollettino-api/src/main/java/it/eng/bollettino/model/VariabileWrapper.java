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
 * This class is a wrapper for {@link Variabile}.
 * </p>
 *
 * @author GFAVINI
 * @see Variabile
 * @generated
 */
public class VariabileWrapper
	extends BaseModelWrapper<Variabile>
	implements ModelWrapper<Variabile>, Variabile {

	public VariabileWrapper(Variabile variabile) {
		super(variabile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("description_it", getDescription_it());
		attributes.put("level_t1", getLevel_t1());
		attributes.put("level_t2", getLevel_t2());
		attributes.put("level_v1", getLevel_v1());
		attributes.put("level_v2", getLevel_v2());
		attributes.put("trange_p1", getTrange_p1());
		attributes.put("trange_p2", getTrange_p2());
		attributes.put("trange_pind", getTrange_pind());
		attributes.put("unit", getUnit());
		attributes.put("bcode", getBcode());

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

		String description_it = (String)attributes.get("description_it");

		if (description_it != null) {
			setDescription_it(description_it);
		}

		Integer level_t1 = (Integer)attributes.get("level_t1");

		if (level_t1 != null) {
			setLevel_t1(level_t1);
		}

		Integer level_t2 = (Integer)attributes.get("level_t2");

		if (level_t2 != null) {
			setLevel_t2(level_t2);
		}

		Integer level_v1 = (Integer)attributes.get("level_v1");

		if (level_v1 != null) {
			setLevel_v1(level_v1);
		}

		Integer level_v2 = (Integer)attributes.get("level_v2");

		if (level_v2 != null) {
			setLevel_v2(level_v2);
		}

		Integer trange_p1 = (Integer)attributes.get("trange_p1");

		if (trange_p1 != null) {
			setTrange_p1(trange_p1);
		}

		Integer trange_p2 = (Integer)attributes.get("trange_p2");

		if (trange_p2 != null) {
			setTrange_p2(trange_p2);
		}

		Integer trange_pind = (Integer)attributes.get("trange_pind");

		if (trange_pind != null) {
			setTrange_pind(trange_pind);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		String bcode = (String)attributes.get("bcode");

		if (bcode != null) {
			setBcode(bcode);
		}
	}

	@Override
	public Variabile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bcode of this variabile.
	 *
	 * @return the bcode of this variabile
	 */
	@Override
	public String getBcode() {
		return model.getBcode();
	}

	/**
	 * Returns the description_it of this variabile.
	 *
	 * @return the description_it of this variabile
	 */
	@Override
	public String getDescription_it() {
		return model.getDescription_it();
	}

	/**
	 * Returns the ID of this variabile.
	 *
	 * @return the ID of this variabile
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the level_t1 of this variabile.
	 *
	 * @return the level_t1 of this variabile
	 */
	@Override
	public int getLevel_t1() {
		return model.getLevel_t1();
	}

	/**
	 * Returns the level_t2 of this variabile.
	 *
	 * @return the level_t2 of this variabile
	 */
	@Override
	public int getLevel_t2() {
		return model.getLevel_t2();
	}

	/**
	 * Returns the level_v1 of this variabile.
	 *
	 * @return the level_v1 of this variabile
	 */
	@Override
	public int getLevel_v1() {
		return model.getLevel_v1();
	}

	/**
	 * Returns the level_v2 of this variabile.
	 *
	 * @return the level_v2 of this variabile
	 */
	@Override
	public int getLevel_v2() {
		return model.getLevel_v2();
	}

	/**
	 * Returns the primary key of this variabile.
	 *
	 * @return the primary key of this variabile
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trange_p1 of this variabile.
	 *
	 * @return the trange_p1 of this variabile
	 */
	@Override
	public int getTrange_p1() {
		return model.getTrange_p1();
	}

	/**
	 * Returns the trange_p2 of this variabile.
	 *
	 * @return the trange_p2 of this variabile
	 */
	@Override
	public int getTrange_p2() {
		return model.getTrange_p2();
	}

	/**
	 * Returns the trange_pind of this variabile.
	 *
	 * @return the trange_pind of this variabile
	 */
	@Override
	public int getTrange_pind() {
		return model.getTrange_pind();
	}

	/**
	 * Returns the unit of this variabile.
	 *
	 * @return the unit of this variabile
	 */
	@Override
	public String getUnit() {
		return model.getUnit();
	}

	/**
	 * Returns the uuid of this variabile.
	 *
	 * @return the uuid of this variabile
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bcode of this variabile.
	 *
	 * @param bcode the bcode of this variabile
	 */
	@Override
	public void setBcode(String bcode) {
		model.setBcode(bcode);
	}

	/**
	 * Sets the description_it of this variabile.
	 *
	 * @param description_it the description_it of this variabile
	 */
	@Override
	public void setDescription_it(String description_it) {
		model.setDescription_it(description_it);
	}

	/**
	 * Sets the ID of this variabile.
	 *
	 * @param id the ID of this variabile
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the level_t1 of this variabile.
	 *
	 * @param level_t1 the level_t1 of this variabile
	 */
	@Override
	public void setLevel_t1(int level_t1) {
		model.setLevel_t1(level_t1);
	}

	/**
	 * Sets the level_t2 of this variabile.
	 *
	 * @param level_t2 the level_t2 of this variabile
	 */
	@Override
	public void setLevel_t2(int level_t2) {
		model.setLevel_t2(level_t2);
	}

	/**
	 * Sets the level_v1 of this variabile.
	 *
	 * @param level_v1 the level_v1 of this variabile
	 */
	@Override
	public void setLevel_v1(int level_v1) {
		model.setLevel_v1(level_v1);
	}

	/**
	 * Sets the level_v2 of this variabile.
	 *
	 * @param level_v2 the level_v2 of this variabile
	 */
	@Override
	public void setLevel_v2(int level_v2) {
		model.setLevel_v2(level_v2);
	}

	/**
	 * Sets the primary key of this variabile.
	 *
	 * @param primaryKey the primary key of this variabile
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trange_p1 of this variabile.
	 *
	 * @param trange_p1 the trange_p1 of this variabile
	 */
	@Override
	public void setTrange_p1(int trange_p1) {
		model.setTrange_p1(trange_p1);
	}

	/**
	 * Sets the trange_p2 of this variabile.
	 *
	 * @param trange_p2 the trange_p2 of this variabile
	 */
	@Override
	public void setTrange_p2(int trange_p2) {
		model.setTrange_p2(trange_p2);
	}

	/**
	 * Sets the trange_pind of this variabile.
	 *
	 * @param trange_pind the trange_pind of this variabile
	 */
	@Override
	public void setTrange_pind(int trange_pind) {
		model.setTrange_pind(trange_pind);
	}

	/**
	 * Sets the unit of this variabile.
	 *
	 * @param unit the unit of this variabile
	 */
	@Override
	public void setUnit(String unit) {
		model.setUnit(unit);
	}

	/**
	 * Sets the uuid of this variabile.
	 *
	 * @param uuid the uuid of this variabile
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
	protected VariabileWrapper wrap(Variabile variabile) {
		return new VariabileWrapper(variabile);
	}

}