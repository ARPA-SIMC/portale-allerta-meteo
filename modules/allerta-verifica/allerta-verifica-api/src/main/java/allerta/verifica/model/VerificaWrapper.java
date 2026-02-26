/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Verifica}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Verifica
 * @generated
 */
public class VerificaWrapper
	extends BaseModelWrapper<Verifica>
	implements ModelWrapper<Verifica>, Verifica {

	public VerificaWrapper(Verifica verifica) {
		super(verifica);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documento", getDocumento());
		attributes.put("stato", getStato());
		attributes.put("titolo", getTitolo());
		attributes.put("fenomeni", getFenomeni());
		attributes.put("fenomeniDescritti", getFenomeniDescritti());
		attributes.put("note", getNote());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("link", getLink());
		attributes.put("hash", getHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		Long documento = (Long)attributes.get("documento");

		if (documento != null) {
			setDocumento(documento);
		}

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String fenomeni = (String)attributes.get("fenomeni");

		if (fenomeni != null) {
			setFenomeni(fenomeni);
		}

		String fenomeniDescritti = (String)attributes.get("fenomeniDescritti");

		if (fenomeniDescritti != null) {
			setFenomeniDescritti(fenomeniDescritti);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public Verifica cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this verifica.
	 *
	 * @return the company ID of this verifica
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this verifica.
	 *
	 * @return the create date of this verifica
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine of this verifica.
	 *
	 * @return the data fine of this verifica
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this verifica.
	 *
	 * @return the data inizio of this verifica
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the documento of this verifica.
	 *
	 * @return the documento of this verifica
	 */
	@Override
	public long getDocumento() {
		return model.getDocumento();
	}

	/**
	 * Returns the fenomeni of this verifica.
	 *
	 * @return the fenomeni of this verifica
	 */
	@Override
	public String getFenomeni() {
		return model.getFenomeni();
	}

	/**
	 * Returns the fenomeni descritti of this verifica.
	 *
	 * @return the fenomeni descritti of this verifica
	 */
	@Override
	public String getFenomeniDescritti() {
		return model.getFenomeniDescritti();
	}

	/**
	 * Returns the group ID of this verifica.
	 *
	 * @return the group ID of this verifica
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hash of this verifica.
	 *
	 * @return the hash of this verifica
	 */
	@Override
	public String getHash() {
		return model.getHash();
	}

	/**
	 * Returns the ID of this verifica.
	 *
	 * @return the ID of this verifica
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the link of this verifica.
	 *
	 * @return the link of this verifica
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this verifica.
	 *
	 * @return the modified date of this verifica
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note of this verifica.
	 *
	 * @return the note of this verifica
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the primary key of this verifica.
	 *
	 * @return the primary key of this verifica
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stato of this verifica.
	 *
	 * @return the stato of this verifica
	 */
	@Override
	public int getStato() {
		return model.getStato();
	}

	/**
	 * Returns the titolo of this verifica.
	 *
	 * @return the titolo of this verifica
	 */
	@Override
	public String getTitolo() {
		return model.getTitolo();
	}

	/**
	 * Returns the user ID of this verifica.
	 *
	 * @return the user ID of this verifica
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this verifica.
	 *
	 * @return the user name of this verifica
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this verifica.
	 *
	 * @return the user uuid of this verifica
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this verifica.
	 *
	 * @return the uuid of this verifica
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
	 * Sets the company ID of this verifica.
	 *
	 * @param companyId the company ID of this verifica
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this verifica.
	 *
	 * @param createDate the create date of this verifica
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this verifica.
	 *
	 * @param dataFine the data fine of this verifica
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this verifica.
	 *
	 * @param dataInizio the data inizio of this verifica
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the documento of this verifica.
	 *
	 * @param documento the documento of this verifica
	 */
	@Override
	public void setDocumento(long documento) {
		model.setDocumento(documento);
	}

	/**
	 * Sets the fenomeni of this verifica.
	 *
	 * @param fenomeni the fenomeni of this verifica
	 */
	@Override
	public void setFenomeni(String fenomeni) {
		model.setFenomeni(fenomeni);
	}

	/**
	 * Sets the fenomeni descritti of this verifica.
	 *
	 * @param fenomeniDescritti the fenomeni descritti of this verifica
	 */
	@Override
	public void setFenomeniDescritti(String fenomeniDescritti) {
		model.setFenomeniDescritti(fenomeniDescritti);
	}

	/**
	 * Sets the group ID of this verifica.
	 *
	 * @param groupId the group ID of this verifica
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this verifica.
	 *
	 * @param hash the hash of this verifica
	 */
	@Override
	public void setHash(String hash) {
		model.setHash(hash);
	}

	/**
	 * Sets the ID of this verifica.
	 *
	 * @param id the ID of this verifica
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the link of this verifica.
	 *
	 * @param link the link of this verifica
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this verifica.
	 *
	 * @param modifiedDate the modified date of this verifica
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note of this verifica.
	 *
	 * @param note the note of this verifica
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the primary key of this verifica.
	 *
	 * @param primaryKey the primary key of this verifica
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stato of this verifica.
	 *
	 * @param stato the stato of this verifica
	 */
	@Override
	public void setStato(int stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the titolo of this verifica.
	 *
	 * @param titolo the titolo of this verifica
	 */
	@Override
	public void setTitolo(String titolo) {
		model.setTitolo(titolo);
	}

	/**
	 * Sets the user ID of this verifica.
	 *
	 * @param userId the user ID of this verifica
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this verifica.
	 *
	 * @param userName the user name of this verifica
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this verifica.
	 *
	 * @param userUuid the user uuid of this verifica
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this verifica.
	 *
	 * @param uuid the uuid of this verifica
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
	protected VerificaWrapper wrap(Verifica verifica) {
		return new VerificaWrapper(verifica);
	}

}