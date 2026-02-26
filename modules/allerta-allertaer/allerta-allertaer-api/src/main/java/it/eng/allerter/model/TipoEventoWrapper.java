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
 * This class is a wrapper for {@link TipoEvento}.
 * </p>
 *
 * @author GFAVINI
 * @see TipoEvento
 * @generated
 */
public class TipoEventoWrapper
	extends BaseModelWrapper<TipoEvento>
	implements ModelWrapper<TipoEvento>, TipoEvento {

	public TipoEventoWrapper(TipoEvento tipoEvento) {
		super(tipoEvento);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventoId", getEventoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("indice", getIndice());
		attributes.put("tabella", getTabella());
		attributes.put("split", isSplit());
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

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
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

		Integer indice = (Integer)attributes.get("indice");

		if (indice != null) {
			setIndice(indice);
		}

		Integer tabella = (Integer)attributes.get("tabella");

		if (tabella != null) {
			setTabella(tabella);
		}

		Boolean split = (Boolean)attributes.get("split");

		if (split != null) {
			setSplit(split);
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
	public TipoEvento cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this tipo evento.
	 *
	 * @return the company ID of this tipo evento
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the costiero of this tipo evento.
	 *
	 * @return the costiero of this tipo evento
	 */
	@Override
	public boolean getCostiero() {
		return model.getCostiero();
	}

	/**
	 * Returns the create date of this tipo evento.
	 *
	 * @return the create date of this tipo evento
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this tipo evento.
	 *
	 * @return the data fine of this tipo evento
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this tipo evento.
	 *
	 * @return the data inizio of this tipo evento
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the evento ID of this tipo evento.
	 *
	 * @return the evento ID of this tipo evento
	 */
	@Override
	public long getEventoId() {
		return model.getEventoId();
	}

	/**
	 * Returns the group ID of this tipo evento.
	 *
	 * @return the group ID of this tipo evento
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the indice of this tipo evento.
	 *
	 * @return the indice of this tipo evento
	 */
	@Override
	public int getIndice() {
		return model.getIndice();
	}

	/**
	 * Returns the modified date of this tipo evento.
	 *
	 * @return the modified date of this tipo evento
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this tipo evento.
	 *
	 * @return the nome of this tipo evento
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the parent ID of this tipo evento.
	 *
	 * @return the parent ID of this tipo evento
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this tipo evento.
	 *
	 * @return the primary key of this tipo evento
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the split of this tipo evento.
	 *
	 * @return the split of this tipo evento
	 */
	@Override
	public boolean getSplit() {
		return model.getSplit();
	}

	/**
	 * Returns the tabella of this tipo evento.
	 *
	 * @return the tabella of this tipo evento
	 */
	@Override
	public int getTabella() {
		return model.getTabella();
	}

	/**
	 * Returns the user ID of this tipo evento.
	 *
	 * @return the user ID of this tipo evento
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this tipo evento.
	 *
	 * @return the user name of this tipo evento
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this tipo evento.
	 *
	 * @return the user uuid of this tipo evento
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this tipo evento.
	 *
	 * @return the uuid of this tipo evento
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this tipo evento is costiero.
	 *
	 * @return <code>true</code> if this tipo evento is costiero; <code>false</code> otherwise
	 */
	@Override
	public boolean isCostiero() {
		return model.isCostiero();
	}

	/**
	 * Returns <code>true</code> if this tipo evento is split.
	 *
	 * @return <code>true</code> if this tipo evento is split; <code>false</code> otherwise
	 */
	@Override
	public boolean isSplit() {
		return model.isSplit();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this tipo evento.
	 *
	 * @param companyId the company ID of this tipo evento
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets whether this tipo evento is costiero.
	 *
	 * @param costiero the costiero of this tipo evento
	 */
	@Override
	public void setCostiero(boolean costiero) {
		model.setCostiero(costiero);
	}

	/**
	 * Sets the create date of this tipo evento.
	 *
	 * @param createDate the create date of this tipo evento
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this tipo evento.
	 *
	 * @param dataFine the data fine of this tipo evento
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this tipo evento.
	 *
	 * @param dataInizio the data inizio of this tipo evento
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the evento ID of this tipo evento.
	 *
	 * @param eventoId the evento ID of this tipo evento
	 */
	@Override
	public void setEventoId(long eventoId) {
		model.setEventoId(eventoId);
	}

	/**
	 * Sets the group ID of this tipo evento.
	 *
	 * @param groupId the group ID of this tipo evento
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the indice of this tipo evento.
	 *
	 * @param indice the indice of this tipo evento
	 */
	@Override
	public void setIndice(int indice) {
		model.setIndice(indice);
	}

	/**
	 * Sets the modified date of this tipo evento.
	 *
	 * @param modifiedDate the modified date of this tipo evento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this tipo evento.
	 *
	 * @param nome the nome of this tipo evento
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the parent ID of this tipo evento.
	 *
	 * @param parentId the parent ID of this tipo evento
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this tipo evento.
	 *
	 * @param primaryKey the primary key of this tipo evento
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this tipo evento is split.
	 *
	 * @param split the split of this tipo evento
	 */
	@Override
	public void setSplit(boolean split) {
		model.setSplit(split);
	}

	/**
	 * Sets the tabella of this tipo evento.
	 *
	 * @param tabella the tabella of this tipo evento
	 */
	@Override
	public void setTabella(int tabella) {
		model.setTabella(tabella);
	}

	/**
	 * Sets the user ID of this tipo evento.
	 *
	 * @param userId the user ID of this tipo evento
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this tipo evento.
	 *
	 * @param userName the user name of this tipo evento
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tipo evento.
	 *
	 * @param userUuid the user uuid of this tipo evento
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this tipo evento.
	 *
	 * @param uuid the uuid of this tipo evento
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
	protected TipoEventoWrapper wrap(TipoEvento tipoEvento) {
		return new TipoEventoWrapper(tipoEvento);
	}

}