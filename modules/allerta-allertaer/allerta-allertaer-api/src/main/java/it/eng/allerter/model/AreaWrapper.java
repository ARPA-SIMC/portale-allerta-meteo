/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Area}.
 * </p>
 *
 * @author GFAVINI
 * @see Area
 * @generated
 */
public class AreaWrapper
	extends BaseModelWrapper<Area> implements Area, ModelWrapper<Area> {

	public AreaWrapper(Area area) {
		super(area);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("areaId", getAreaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("tipoArea", getTipoArea());
		attributes.put("costiero", isCostiero());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long areaId = (Long)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String tipoArea = (String)attributes.get("tipoArea");

		if (tipoArea != null) {
			setTipoArea(tipoArea);
		}

		Boolean costiero = (Boolean)attributes.get("costiero");

		if (costiero != null) {
			setCostiero(costiero);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public Area cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area ID of this area.
	 *
	 * @return the area ID of this area
	 */
	@Override
	public long getAreaId() {
		return model.getAreaId();
	}

	/**
	 * Returns the company ID of this area.
	 *
	 * @return the company ID of this area
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the costiero of this area.
	 *
	 * @return the costiero of this area
	 */
	@Override
	public boolean getCostiero() {
		return model.getCostiero();
	}

	/**
	 * Returns the create date of this area.
	 *
	 * @return the create date of this area
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this area.
	 *
	 * @return the data fine of this area
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this area.
	 *
	 * @return the data inizio of this area
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the group ID of this area.
	 *
	 * @return the group ID of this area
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this area.
	 *
	 * @return the modified date of this area
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this area.
	 *
	 * @return the nome of this area
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the parent ID of this area.
	 *
	 * @return the parent ID of this area
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this area.
	 *
	 * @return the primary key of this area
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo area of this area.
	 *
	 * @return the tipo area of this area
	 */
	@Override
	public String getTipoArea() {
		return model.getTipoArea();
	}

	/**
	 * Returns the user ID of this area.
	 *
	 * @return the user ID of this area
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this area.
	 *
	 * @return the user name of this area
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this area.
	 *
	 * @return the user uuid of this area
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this area.
	 *
	 * @return the uuid of this area
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this area is costiero.
	 *
	 * @return <code>true</code> if this area is costiero; <code>false</code> otherwise
	 */
	@Override
	public boolean isCostiero() {
		return model.isCostiero();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the area ID of this area.
	 *
	 * @param areaId the area ID of this area
	 */
	@Override
	public void setAreaId(long areaId) {
		model.setAreaId(areaId);
	}

	/**
	 * Sets the company ID of this area.
	 *
	 * @param companyId the company ID of this area
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets whether this area is costiero.
	 *
	 * @param costiero the costiero of this area
	 */
	@Override
	public void setCostiero(boolean costiero) {
		model.setCostiero(costiero);
	}

	/**
	 * Sets the create date of this area.
	 *
	 * @param createDate the create date of this area
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this area.
	 *
	 * @param dataFine the data fine of this area
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this area.
	 *
	 * @param dataInizio the data inizio of this area
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the group ID of this area.
	 *
	 * @param groupId the group ID of this area
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this area.
	 *
	 * @param modifiedDate the modified date of this area
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this area.
	 *
	 * @param nome the nome of this area
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the parent ID of this area.
	 *
	 * @param parentId the parent ID of this area
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this area.
	 *
	 * @param primaryKey the primary key of this area
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo area of this area.
	 *
	 * @param tipoArea the tipo area of this area
	 */
	@Override
	public void setTipoArea(String tipoArea) {
		model.setTipoArea(tipoArea);
	}

	/**
	 * Sets the user ID of this area.
	 *
	 * @param userId the user ID of this area
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this area.
	 *
	 * @param userName the user name of this area
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this area.
	 *
	 * @param userUuid the user uuid of this area
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this area.
	 *
	 * @param uuid the uuid of this area
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AreaWrapper wrap(Area area) {
		return new AreaWrapper(area);
	}

}