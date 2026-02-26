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
 * This class is a wrapper for {@link AllertaStato}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaStato
 * @generated
 */
public class AllertaStatoWrapper
	extends BaseModelWrapper<AllertaStato>
	implements AllertaStato, ModelWrapper<AllertaStato> {

	public AllertaStatoWrapper(AllertaStato allertaStato) {
		super(allertaStato);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaStatoId", getAllertaStatoId());
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
		attributes.put("allertaId", getAllertaId());
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

		Long allertaStatoId = (Long)attributes.get("allertaStatoId");

		if (allertaStatoId != null) {
			setAllertaStatoId(allertaStatoId);
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

		Long allertaId = (Long)attributes.get("allertaId");

		if (allertaId != null) {
			setAllertaId(allertaId);
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
	public AllertaStato cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allerta ID of this allerta stato.
	 *
	 * @return the allerta ID of this allerta stato
	 */
	@Override
	public long getAllertaId() {
		return model.getAllertaId();
	}

	/**
	 * Returns the allerta stato ID of this allerta stato.
	 *
	 * @return the allerta stato ID of this allerta stato
	 */
	@Override
	public long getAllertaStatoId() {
		return model.getAllertaStatoId();
	}

	/**
	 * Returns the area ID of this allerta stato.
	 *
	 * @return the area ID of this allerta stato
	 */
	@Override
	public long getAreaId() {
		return model.getAreaId();
	}

	/**
	 * Returns the company ID of this allerta stato.
	 *
	 * @return the company ID of this allerta stato
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta stato.
	 *
	 * @return the create date of this allerta stato
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this allerta stato.
	 *
	 * @return the data fine of this allerta stato
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this allerta stato.
	 *
	 * @return the data inizio of this allerta stato
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the evento ID of this allerta stato.
	 *
	 * @return the evento ID of this allerta stato
	 */
	@Override
	public long getEventoId() {
		return model.getEventoId();
	}

	/**
	 * Returns the group ID of this allerta stato.
	 *
	 * @return the group ID of this allerta stato
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this allerta stato.
	 *
	 * @return the modified date of this allerta stato
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this allerta stato.
	 *
	 * @return the nome of this allerta stato
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the parent ID of this allerta stato.
	 *
	 * @return the parent ID of this allerta stato
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this allerta stato.
	 *
	 * @return the primary key of this allerta stato
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato ID of this allerta stato.
	 *
	 * @return the stato ID of this allerta stato
	 */
	@Override
	public long getStatoId() {
		return model.getStatoId();
	}

	/**
	 * Returns the user ID of this allerta stato.
	 *
	 * @return the user ID of this allerta stato
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this allerta stato.
	 *
	 * @return the user name of this allerta stato
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta stato.
	 *
	 * @return the user uuid of this allerta stato
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this allerta stato.
	 *
	 * @return the uuid of this allerta stato
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
	 * Sets the allerta ID of this allerta stato.
	 *
	 * @param allertaId the allerta ID of this allerta stato
	 */
	@Override
	public void setAllertaId(long allertaId) {
		model.setAllertaId(allertaId);
	}

	/**
	 * Sets the allerta stato ID of this allerta stato.
	 *
	 * @param allertaStatoId the allerta stato ID of this allerta stato
	 */
	@Override
	public void setAllertaStatoId(long allertaStatoId) {
		model.setAllertaStatoId(allertaStatoId);
	}

	/**
	 * Sets the area ID of this allerta stato.
	 *
	 * @param areaId the area ID of this allerta stato
	 */
	@Override
	public void setAreaId(long areaId) {
		model.setAreaId(areaId);
	}

	/**
	 * Sets the company ID of this allerta stato.
	 *
	 * @param companyId the company ID of this allerta stato
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta stato.
	 *
	 * @param createDate the create date of this allerta stato
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this allerta stato.
	 *
	 * @param dataFine the data fine of this allerta stato
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this allerta stato.
	 *
	 * @param dataInizio the data inizio of this allerta stato
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the evento ID of this allerta stato.
	 *
	 * @param eventoId the evento ID of this allerta stato
	 */
	@Override
	public void setEventoId(long eventoId) {
		model.setEventoId(eventoId);
	}

	/**
	 * Sets the group ID of this allerta stato.
	 *
	 * @param groupId the group ID of this allerta stato
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this allerta stato.
	 *
	 * @param modifiedDate the modified date of this allerta stato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this allerta stato.
	 *
	 * @param nome the nome of this allerta stato
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the parent ID of this allerta stato.
	 *
	 * @param parentId the parent ID of this allerta stato
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta stato.
	 *
	 * @param primaryKey the primary key of this allerta stato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato ID of this allerta stato.
	 *
	 * @param statoId the stato ID of this allerta stato
	 */
	@Override
	public void setStatoId(long statoId) {
		model.setStatoId(statoId);
	}

	/**
	 * Sets the user ID of this allerta stato.
	 *
	 * @param userId the user ID of this allerta stato
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta stato.
	 *
	 * @param userName the user name of this allerta stato
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta stato.
	 *
	 * @param userUuid the user uuid of this allerta stato
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allerta stato.
	 *
	 * @param uuid the uuid of this allerta stato
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
	protected AllertaStatoWrapper wrap(AllertaStato allertaStato) {
		return new AllertaStatoWrapper(allertaStato);
	}

}