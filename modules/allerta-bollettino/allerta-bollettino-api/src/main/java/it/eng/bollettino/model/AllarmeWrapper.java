/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Allarme}.
 * </p>
 *
 * @author GFAVINI
 * @see Allarme
 * @generated
 */
public class AllarmeWrapper
	extends BaseModelWrapper<Allarme>
	implements Allarme, ModelWrapper<Allarme> {

	public AllarmeWrapper(Allarme allarme) {
		super(allarme);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allarmeId", getAllarmeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stato", getStato());
		attributes.put("idApprovatore", getIdApprovatore());
		attributes.put("dataApprovazione", getDataApprovazione());
		attributes.put("idRegola", getIdRegola());
		attributes.put("colore", getColore());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allarmeId = (Long)attributes.get("allarmeId");

		if (allarmeId != null) {
			setAllarmeId(allarmeId);
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

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Long idApprovatore = (Long)attributes.get("idApprovatore");

		if (idApprovatore != null) {
			setIdApprovatore(idApprovatore);
		}

		Date dataApprovazione = (Date)attributes.get("dataApprovazione");

		if (dataApprovazione != null) {
			setDataApprovazione(dataApprovazione);
		}

		Long idRegola = (Long)attributes.get("idRegola");

		if (idRegola != null) {
			setIdRegola(idRegola);
		}

		Integer colore = (Integer)attributes.get("colore");

		if (colore != null) {
			setColore(colore);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}
	}

	@Override
	public Allarme cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allarme ID of this allarme.
	 *
	 * @return the allarme ID of this allarme
	 */
	@Override
	public long getAllarmeId() {
		return model.getAllarmeId();
	}

	/**
	 * Returns the colore of this allarme.
	 *
	 * @return the colore of this allarme
	 */
	@Override
	public int getColore() {
		return model.getColore();
	}

	/**
	 * Returns the company ID of this allarme.
	 *
	 * @return the company ID of this allarme
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this allarme.
	 *
	 * @return the create date of this allarme
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data approvazione of this allarme.
	 *
	 * @return the data approvazione of this allarme
	 */
	@Override
	public Date getDataApprovazione() {
		return model.getDataApprovazione();
	}

	/**
	 * Returns the data fine of this allarme.
	 *
	 * @return the data fine of this allarme
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this allarme.
	 *
	 * @return the data inizio of this allarme
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the group ID of this allarme.
	 *
	 * @return the group ID of this allarme
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id approvatore of this allarme.
	 *
	 * @return the id approvatore of this allarme
	 */
	@Override
	public long getIdApprovatore() {
		return model.getIdApprovatore();
	}

	/**
	 * Returns the id regola of this allarme.
	 *
	 * @return the id regola of this allarme
	 */
	@Override
	public long getIdRegola() {
		return model.getIdRegola();
	}

	/**
	 * Returns the modified date of this allarme.
	 *
	 * @return the modified date of this allarme
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this allarme.
	 *
	 * @return the primary key of this allarme
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato of this allarme.
	 *
	 * @return the stato of this allarme
	 */
	@Override
	public int getStato() {
		return model.getStato();
	}

	/**
	 * Returns the user ID of this allarme.
	 *
	 * @return the user ID of this allarme
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this allarme.
	 *
	 * @return the user name of this allarme
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this allarme.
	 *
	 * @return the user uuid of this allarme
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this allarme.
	 *
	 * @return the uuid of this allarme
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
	 * Sets the allarme ID of this allarme.
	 *
	 * @param allarmeId the allarme ID of this allarme
	 */
	@Override
	public void setAllarmeId(long allarmeId) {
		model.setAllarmeId(allarmeId);
	}

	/**
	 * Sets the colore of this allarme.
	 *
	 * @param colore the colore of this allarme
	 */
	@Override
	public void setColore(int colore) {
		model.setColore(colore);
	}

	/**
	 * Sets the company ID of this allarme.
	 *
	 * @param companyId the company ID of this allarme
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allarme.
	 *
	 * @param createDate the create date of this allarme
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data approvazione of this allarme.
	 *
	 * @param dataApprovazione the data approvazione of this allarme
	 */
	@Override
	public void setDataApprovazione(Date dataApprovazione) {
		model.setDataApprovazione(dataApprovazione);
	}

	/**
	 * Sets the data fine of this allarme.
	 *
	 * @param dataFine the data fine of this allarme
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this allarme.
	 *
	 * @param dataInizio the data inizio of this allarme
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the group ID of this allarme.
	 *
	 * @param groupId the group ID of this allarme
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id approvatore of this allarme.
	 *
	 * @param idApprovatore the id approvatore of this allarme
	 */
	@Override
	public void setIdApprovatore(long idApprovatore) {
		model.setIdApprovatore(idApprovatore);
	}

	/**
	 * Sets the id regola of this allarme.
	 *
	 * @param idRegola the id regola of this allarme
	 */
	@Override
	public void setIdRegola(long idRegola) {
		model.setIdRegola(idRegola);
	}

	/**
	 * Sets the modified date of this allarme.
	 *
	 * @param modifiedDate the modified date of this allarme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this allarme.
	 *
	 * @param primaryKey the primary key of this allarme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato of this allarme.
	 *
	 * @param stato the stato of this allarme
	 */
	@Override
	public void setStato(int stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the user ID of this allarme.
	 *
	 * @param userId the user ID of this allarme
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this allarme.
	 *
	 * @param userName the user name of this allarme
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allarme.
	 *
	 * @param userUuid the user uuid of this allarme
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allarme.
	 *
	 * @param uuid the uuid of this allarme
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
	protected AllarmeWrapper wrap(Allarme allarme) {
		return new AllarmeWrapper(allarme);
	}

}