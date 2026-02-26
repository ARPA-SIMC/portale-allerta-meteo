/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Img}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Img
 * @generated
 */
public class ImgWrapper
	extends BaseModelWrapper<Img> implements Img, ModelWrapper<Img> {

	public ImgWrapper(Img img) {
		super(img);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("daypart", getDaypart());
		attributes.put("day", getDay());
		attributes.put("provincia", getProvincia());
		attributes.put("inserted", getInserted());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String daypart = (String)attributes.get("daypart");

		if (daypart != null) {
			setDaypart(daypart);
		}

		String day = (String)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		Date inserted = (Date)attributes.get("inserted");

		if (inserted != null) {
			setInserted(inserted);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public Img cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data of this img.
	 *
	 * @return the data of this img
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the day of this img.
	 *
	 * @return the day of this img
	 */
	@Override
	public String getDay() {
		return model.getDay();
	}

	/**
	 * Returns the daypart of this img.
	 *
	 * @return the daypart of this img
	 */
	@Override
	public String getDaypart() {
		return model.getDaypart();
	}

	/**
	 * Returns the ID of this img.
	 *
	 * @return the ID of this img
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the inserted of this img.
	 *
	 * @return the inserted of this img
	 */
	@Override
	public Date getInserted() {
		return model.getInserted();
	}

	/**
	 * Returns the primary key of this img.
	 *
	 * @return the primary key of this img
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia of this img.
	 *
	 * @return the provincia of this img
	 */
	@Override
	public String getProvincia() {
		return model.getProvincia();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data of this img.
	 *
	 * @param data the data of this img
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the day of this img.
	 *
	 * @param day the day of this img
	 */
	@Override
	public void setDay(String day) {
		model.setDay(day);
	}

	/**
	 * Sets the daypart of this img.
	 *
	 * @param daypart the daypart of this img
	 */
	@Override
	public void setDaypart(String daypart) {
		model.setDaypart(daypart);
	}

	/**
	 * Sets the ID of this img.
	 *
	 * @param id the ID of this img
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the inserted of this img.
	 *
	 * @param inserted the inserted of this img
	 */
	@Override
	public void setInserted(Date inserted) {
		model.setInserted(inserted);
	}

	/**
	 * Sets the primary key of this img.
	 *
	 * @param primaryKey the primary key of this img
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia of this img.
	 *
	 * @param provincia the provincia of this img
	 */
	@Override
	public void setProvincia(String provincia) {
		model.setProvincia(provincia);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ImgWrapper wrap(Img img) {
		return new ImgWrapper(img);
	}

}