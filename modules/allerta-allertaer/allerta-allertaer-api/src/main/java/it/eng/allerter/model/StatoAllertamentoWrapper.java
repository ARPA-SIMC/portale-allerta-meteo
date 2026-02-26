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
 * This class is a wrapper for {@link StatoAllertamento}.
 * </p>
 *
 * @author GFAVINI
 * @see StatoAllertamento
 * @generated
 */
public class StatoAllertamentoWrapper
	extends BaseModelWrapper<StatoAllertamento>
	implements ModelWrapper<StatoAllertamento>, StatoAllertamento {

	public StatoAllertamentoWrapper(StatoAllertamento statoAllertamento) {
		super(statoAllertamento);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("statoId", getStatoId());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long statoId = (Long)attributes.get("statoId");

		if (statoId != null) {
			setStatoId(statoId);
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
	}

	@Override
	public StatoAllertamento cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this stato allertamento.
	 *
	 * @return the company ID of this stato allertamento
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this stato allertamento.
	 *
	 * @return the create date of this stato allertamento
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this stato allertamento.
	 *
	 * @return the data fine of this stato allertamento
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this stato allertamento.
	 *
	 * @return the data inizio of this stato allertamento
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the group ID of this stato allertamento.
	 *
	 * @return the group ID of this stato allertamento
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this stato allertamento.
	 *
	 * @return the modified date of this stato allertamento
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this stato allertamento.
	 *
	 * @return the nome of this stato allertamento
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the parent ID of this stato allertamento.
	 *
	 * @return the parent ID of this stato allertamento
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this stato allertamento.
	 *
	 * @return the primary key of this stato allertamento
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato ID of this stato allertamento.
	 *
	 * @return the stato ID of this stato allertamento
	 */
	@Override
	public long getStatoId() {
		return model.getStatoId();
	}

	/**
	 * Returns the user ID of this stato allertamento.
	 *
	 * @return the user ID of this stato allertamento
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this stato allertamento.
	 *
	 * @return the user name of this stato allertamento
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this stato allertamento.
	 *
	 * @return the user uuid of this stato allertamento
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this stato allertamento.
	 *
	 * @return the uuid of this stato allertamento
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
	 * Sets the company ID of this stato allertamento.
	 *
	 * @param companyId the company ID of this stato allertamento
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this stato allertamento.
	 *
	 * @param createDate the create date of this stato allertamento
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this stato allertamento.
	 *
	 * @param dataFine the data fine of this stato allertamento
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this stato allertamento.
	 *
	 * @param dataInizio the data inizio of this stato allertamento
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the group ID of this stato allertamento.
	 *
	 * @param groupId the group ID of this stato allertamento
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this stato allertamento.
	 *
	 * @param modifiedDate the modified date of this stato allertamento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this stato allertamento.
	 *
	 * @param nome the nome of this stato allertamento
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the parent ID of this stato allertamento.
	 *
	 * @param parentId the parent ID of this stato allertamento
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this stato allertamento.
	 *
	 * @param primaryKey the primary key of this stato allertamento
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato ID of this stato allertamento.
	 *
	 * @param statoId the stato ID of this stato allertamento
	 */
	@Override
	public void setStatoId(long statoId) {
		model.setStatoId(statoId);
	}

	/**
	 * Sets the user ID of this stato allertamento.
	 *
	 * @param userId the user ID of this stato allertamento
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this stato allertamento.
	 *
	 * @param userName the user name of this stato allertamento
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this stato allertamento.
	 *
	 * @param userUuid the user uuid of this stato allertamento
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this stato allertamento.
	 *
	 * @param uuid the uuid of this stato allertamento
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
	protected StatoAllertamentoWrapper wrap(
		StatoAllertamento statoAllertamento) {

		return new StatoAllertamentoWrapper(statoAllertamento);
	}

}