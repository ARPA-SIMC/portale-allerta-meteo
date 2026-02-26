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
 * This class is a wrapper for {@link AllertaValangheStato}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValangheStato
 * @generated
 */
public class AllertaValangheStatoWrapper
	extends BaseModelWrapper<AllertaValangheStato>
	implements AllertaValangheStato, ModelWrapper<AllertaValangheStato> {

	public AllertaValangheStatoWrapper(
		AllertaValangheStato allertaValangheStato) {

		super(allertaValangheStato);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaValangheStatoId", getAllertaValangheStatoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("parentId", getParentId());
		attributes.put("allertaValangheId", getAllertaValangheId());
		attributes.put("statoId", getStatoId());
		attributes.put("eventoId", getEventoId());
		attributes.put("areaId", getAreaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allertaValangheStatoId = (Long)attributes.get(
			"allertaValangheStatoId");

		if (allertaValangheStatoId != null) {
			setAllertaValangheStatoId(allertaValangheStatoId);
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

		Long allertaValangheId = (Long)attributes.get("allertaValangheId");

		if (allertaValangheId != null) {
			setAllertaValangheId(allertaValangheId);
		}

		Long statoId = (Long)attributes.get("statoId");

		if (statoId != null) {
			setStatoId(statoId);
		}

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
		}

		Long areaId = (Long)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}
	}

	@Override
	public AllertaValangheStato cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allerta valanghe ID of this allerta valanghe stato.
	 *
	 * @return the allerta valanghe ID of this allerta valanghe stato
	 */
	@Override
	public long getAllertaValangheId() {
		return model.getAllertaValangheId();
	}

	/**
	 * Returns the allerta valanghe stato ID of this allerta valanghe stato.
	 *
	 * @return the allerta valanghe stato ID of this allerta valanghe stato
	 */
	@Override
	public long getAllertaValangheStatoId() {
		return model.getAllertaValangheStatoId();
	}

	/**
	 * Returns the area ID of this allerta valanghe stato.
	 *
	 * @return the area ID of this allerta valanghe stato
	 */
	@Override
	public long getAreaId() {
		return model.getAreaId();
	}

	/**
	 * Returns the company ID of this allerta valanghe stato.
	 *
	 * @return the company ID of this allerta valanghe stato
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta valanghe stato.
	 *
	 * @return the create date of this allerta valanghe stato
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this allerta valanghe stato.
	 *
	 * @return the data fine of this allerta valanghe stato
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this allerta valanghe stato.
	 *
	 * @return the data inizio of this allerta valanghe stato
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the evento ID of this allerta valanghe stato.
	 *
	 * @return the evento ID of this allerta valanghe stato
	 */
	@Override
	public long getEventoId() {
		return model.getEventoId();
	}

	/**
	 * Returns the group ID of this allerta valanghe stato.
	 *
	 * @return the group ID of this allerta valanghe stato
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this allerta valanghe stato.
	 *
	 * @return the modified date of this allerta valanghe stato
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this allerta valanghe stato.
	 *
	 * @return the nome of this allerta valanghe stato
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the parent ID of this allerta valanghe stato.
	 *
	 * @return the parent ID of this allerta valanghe stato
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this allerta valanghe stato.
	 *
	 * @return the primary key of this allerta valanghe stato
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato ID of this allerta valanghe stato.
	 *
	 * @return the stato ID of this allerta valanghe stato
	 */
	@Override
	public long getStatoId() {
		return model.getStatoId();
	}

	/**
	 * Returns the user ID of this allerta valanghe stato.
	 *
	 * @return the user ID of this allerta valanghe stato
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this allerta valanghe stato.
	 *
	 * @return the user name of this allerta valanghe stato
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta valanghe stato.
	 *
	 * @return the user uuid of this allerta valanghe stato
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this allerta valanghe stato.
	 *
	 * @return the uuid of this allerta valanghe stato
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
	 * Sets the allerta valanghe ID of this allerta valanghe stato.
	 *
	 * @param allertaValangheId the allerta valanghe ID of this allerta valanghe stato
	 */
	@Override
	public void setAllertaValangheId(long allertaValangheId) {
		model.setAllertaValangheId(allertaValangheId);
	}

	/**
	 * Sets the allerta valanghe stato ID of this allerta valanghe stato.
	 *
	 * @param allertaValangheStatoId the allerta valanghe stato ID of this allerta valanghe stato
	 */
	@Override
	public void setAllertaValangheStatoId(long allertaValangheStatoId) {
		model.setAllertaValangheStatoId(allertaValangheStatoId);
	}

	/**
	 * Sets the area ID of this allerta valanghe stato.
	 *
	 * @param areaId the area ID of this allerta valanghe stato
	 */
	@Override
	public void setAreaId(long areaId) {
		model.setAreaId(areaId);
	}

	/**
	 * Sets the company ID of this allerta valanghe stato.
	 *
	 * @param companyId the company ID of this allerta valanghe stato
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta valanghe stato.
	 *
	 * @param createDate the create date of this allerta valanghe stato
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this allerta valanghe stato.
	 *
	 * @param dataFine the data fine of this allerta valanghe stato
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this allerta valanghe stato.
	 *
	 * @param dataInizio the data inizio of this allerta valanghe stato
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the evento ID of this allerta valanghe stato.
	 *
	 * @param eventoId the evento ID of this allerta valanghe stato
	 */
	@Override
	public void setEventoId(long eventoId) {
		model.setEventoId(eventoId);
	}

	/**
	 * Sets the group ID of this allerta valanghe stato.
	 *
	 * @param groupId the group ID of this allerta valanghe stato
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this allerta valanghe stato.
	 *
	 * @param modifiedDate the modified date of this allerta valanghe stato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this allerta valanghe stato.
	 *
	 * @param nome the nome of this allerta valanghe stato
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the parent ID of this allerta valanghe stato.
	 *
	 * @param parentId the parent ID of this allerta valanghe stato
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta valanghe stato.
	 *
	 * @param primaryKey the primary key of this allerta valanghe stato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato ID of this allerta valanghe stato.
	 *
	 * @param statoId the stato ID of this allerta valanghe stato
	 */
	@Override
	public void setStatoId(long statoId) {
		model.setStatoId(statoId);
	}

	/**
	 * Sets the user ID of this allerta valanghe stato.
	 *
	 * @param userId the user ID of this allerta valanghe stato
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta valanghe stato.
	 *
	 * @param userName the user name of this allerta valanghe stato
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta valanghe stato.
	 *
	 * @param userUuid the user uuid of this allerta valanghe stato
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allerta valanghe stato.
	 *
	 * @param uuid the uuid of this allerta valanghe stato
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
	protected AllertaValangheStatoWrapper wrap(
		AllertaValangheStato allertaValangheStato) {

		return new AllertaValangheStatoWrapper(allertaValangheStato);
	}

}