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
 * This class is a wrapper for {@link AllertaValanghe}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValanghe
 * @generated
 */
public class AllertaValangheWrapper
	extends BaseModelWrapper<AllertaValanghe>
	implements AllertaValanghe, ModelWrapper<AllertaValanghe> {

	public AllertaValangheWrapper(AllertaValanghe allertaValanghe) {
		super(allertaValanghe);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaValangheId", getAllertaValangheId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("creatorName", getCreatorName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dataEmissione", getDataEmissione());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("numero", getNumero());
		attributes.put("progressivo", getProgressivo());
		attributes.put("anno", getAnno());
		attributes.put("titolo", getTitolo());
		attributes.put("descrizioneFenomeni", getDescrizioneFenomeni());
		attributes.put("note", getNote());
		attributes.put("riferimenti", getRiferimenti());
		attributes.put("sintesi", getSintesi());
		attributes.put("utenteFirmaArpaId", getUtenteFirmaArpaId());
		attributes.put("dataFirmaArpa", getDataFirmaArpa());
		attributes.put("utenteFirmaProtId", getUtenteFirmaProtId());
		attributes.put("dataFirmaProt", getDataFirmaProt());
		attributes.put("parentId", getParentId());
		attributes.put("link", getLink());
		attributes.put("stato", getStato());
		attributes.put("tipoAllerta", isTipoAllerta());
		attributes.put("hash", getHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allertaValangheId = (Long)attributes.get("allertaValangheId");

		if (allertaValangheId != null) {
			setAllertaValangheId(allertaValangheId);
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

		String creatorName = (String)attributes.get("creatorName");

		if (creatorName != null) {
			setCreatorName(creatorName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dataEmissione = (Date)attributes.get("dataEmissione");

		if (dataEmissione != null) {
			setDataEmissione(dataEmissione);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String descrizioneFenomeni = (String)attributes.get(
			"descrizioneFenomeni");

		if (descrizioneFenomeni != null) {
			setDescrizioneFenomeni(descrizioneFenomeni);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String riferimenti = (String)attributes.get("riferimenti");

		if (riferimenti != null) {
			setRiferimenti(riferimenti);
		}

		String sintesi = (String)attributes.get("sintesi");

		if (sintesi != null) {
			setSintesi(sintesi);
		}

		Long utenteFirmaArpaId = (Long)attributes.get("utenteFirmaArpaId");

		if (utenteFirmaArpaId != null) {
			setUtenteFirmaArpaId(utenteFirmaArpaId);
		}

		Date dataFirmaArpa = (Date)attributes.get("dataFirmaArpa");

		if (dataFirmaArpa != null) {
			setDataFirmaArpa(dataFirmaArpa);
		}

		Long utenteFirmaProtId = (Long)attributes.get("utenteFirmaProtId");

		if (utenteFirmaProtId != null) {
			setUtenteFirmaProtId(utenteFirmaProtId);
		}

		Date dataFirmaProt = (Date)attributes.get("dataFirmaProt");

		if (dataFirmaProt != null) {
			setDataFirmaProt(dataFirmaProt);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Boolean tipoAllerta = (Boolean)attributes.get("tipoAllerta");

		if (tipoAllerta != null) {
			setTipoAllerta(tipoAllerta);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public AllertaValanghe cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allerta valanghe ID of this allerta valanghe.
	 *
	 * @return the allerta valanghe ID of this allerta valanghe
	 */
	@Override
	public long getAllertaValangheId() {
		return model.getAllertaValangheId();
	}

	@Override
	public java.util.List<AllertaValangheStato> getAllertaValangheStato() {
		return model.getAllertaValangheStato();
	}

	/**
	 * Returns the anno of this allerta valanghe.
	 *
	 * @return the anno of this allerta valanghe
	 */
	@Override
	public int getAnno() {
		return model.getAnno();
	}

	/**
	 * Returns the company ID of this allerta valanghe.
	 *
	 * @return the company ID of this allerta valanghe
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta valanghe.
	 *
	 * @return the create date of this allerta valanghe
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator name of this allerta valanghe.
	 *
	 * @return the creator name of this allerta valanghe
	 */
	@Override
	public String getCreatorName() {
		return model.getCreatorName();
	}

	/**
	 * Returns the data emissione of this allerta valanghe.
	 *
	 * @return the data emissione of this allerta valanghe
	 */
	@Override
	public Date getDataEmissione() {
		return model.getDataEmissione();
	}

	/**
	 * Returns the data fine of this allerta valanghe.
	 *
	 * @return the data fine of this allerta valanghe
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data firma arpa of this allerta valanghe.
	 *
	 * @return the data firma arpa of this allerta valanghe
	 */
	@Override
	public Date getDataFirmaArpa() {
		return model.getDataFirmaArpa();
	}

	/**
	 * Returns the data firma prot of this allerta valanghe.
	 *
	 * @return the data firma prot of this allerta valanghe
	 */
	@Override
	public Date getDataFirmaProt() {
		return model.getDataFirmaProt();
	}

	/**
	 * Returns the data inizio of this allerta valanghe.
	 *
	 * @return the data inizio of this allerta valanghe
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the descrizione fenomeni of this allerta valanghe.
	 *
	 * @return the descrizione fenomeni of this allerta valanghe
	 */
	@Override
	public String getDescrizioneFenomeni() {
		return model.getDescrizioneFenomeni();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName) {

		return model.getFile(folderName, fileName);
	}

	@Override
	public String getFileLinkRelative(String folderName, String fileName) {
		return model.getFileLinkRelative(folderName, fileName);
	}

	/**
	 * Returns the group ID of this allerta valanghe.
	 *
	 * @return the group ID of this allerta valanghe
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hash of this allerta valanghe.
	 *
	 * @return the hash of this allerta valanghe
	 */
	@Override
	public String getHash() {
		return model.getHash();
	}

	/**
	 * Returns the link of this allerta valanghe.
	 *
	 * @return the link of this allerta valanghe
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this allerta valanghe.
	 *
	 * @return the modified date of this allerta valanghe
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note of this allerta valanghe.
	 *
	 * @return the note of this allerta valanghe
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the numero of this allerta valanghe.
	 *
	 * @return the numero of this allerta valanghe
	 */
	@Override
	public String getNumero() {
		return model.getNumero();
	}

	/**
	 * Returns the parent ID of this allerta valanghe.
	 *
	 * @return the parent ID of this allerta valanghe
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this allerta valanghe.
	 *
	 * @return the primary key of this allerta valanghe
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this allerta valanghe.
	 *
	 * @return the progressivo of this allerta valanghe
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	@Override
	public java.io.File getReportAsFile() {
		return model.getReportAsFile();
	}

	/**
	 * Returns the riferimenti of this allerta valanghe.
	 *
	 * @return the riferimenti of this allerta valanghe
	 */
	@Override
	public String getRiferimenti() {
		return model.getRiferimenti();
	}

	/**
	 * Returns the sintesi of this allerta valanghe.
	 *
	 * @return the sintesi of this allerta valanghe
	 */
	@Override
	public String getSintesi() {
		return model.getSintesi();
	}

	/**
	 * Returns the stato of this allerta valanghe.
	 *
	 * @return the stato of this allerta valanghe
	 */
	@Override
	public int getStato() {
		return model.getStato();
	}

	/**
	 * Returns the tipo allerta of this allerta valanghe.
	 *
	 * @return the tipo allerta of this allerta valanghe
	 */
	@Override
	public boolean getTipoAllerta() {
		return model.getTipoAllerta();
	}

	/**
	 * Returns the titolo of this allerta valanghe.
	 *
	 * @return the titolo of this allerta valanghe
	 */
	@Override
	public String getTitolo() {
		return model.getTitolo();
	}

	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this allerta valanghe.
	 *
	 * @return the user ID of this allerta valanghe
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this allerta valanghe.
	 *
	 * @return the user name of this allerta valanghe
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta valanghe.
	 *
	 * @return the user uuid of this allerta valanghe
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utente firma arpa ID of this allerta valanghe.
	 *
	 * @return the utente firma arpa ID of this allerta valanghe
	 */
	@Override
	public long getUtenteFirmaArpaId() {
		return model.getUtenteFirmaArpaId();
	}

	/**
	 * Returns the utente firma prot ID of this allerta valanghe.
	 *
	 * @return the utente firma prot ID of this allerta valanghe
	 */
	@Override
	public long getUtenteFirmaProtId() {
		return model.getUtenteFirmaProtId();
	}

	/**
	 * Returns the uuid of this allerta valanghe.
	 *
	 * @return the uuid of this allerta valanghe
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this allerta valanghe is tipo allerta.
	 *
	 * @return <code>true</code> if this allerta valanghe is tipo allerta; <code>false</code> otherwise
	 */
	@Override
	public boolean isTipoAllerta() {
		return model.isTipoAllerta();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the allerta valanghe ID of this allerta valanghe.
	 *
	 * @param allertaValangheId the allerta valanghe ID of this allerta valanghe
	 */
	@Override
	public void setAllertaValangheId(long allertaValangheId) {
		model.setAllertaValangheId(allertaValangheId);
	}

	/**
	 * Sets the anno of this allerta valanghe.
	 *
	 * @param anno the anno of this allerta valanghe
	 */
	@Override
	public void setAnno(int anno) {
		model.setAnno(anno);
	}

	/**
	 * Sets the company ID of this allerta valanghe.
	 *
	 * @param companyId the company ID of this allerta valanghe
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta valanghe.
	 *
	 * @param createDate the create date of this allerta valanghe
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator name of this allerta valanghe.
	 *
	 * @param creatorName the creator name of this allerta valanghe
	 */
	@Override
	public void setCreatorName(String creatorName) {
		model.setCreatorName(creatorName);
	}

	/**
	 * Sets the data emissione of this allerta valanghe.
	 *
	 * @param dataEmissione the data emissione of this allerta valanghe
	 */
	@Override
	public void setDataEmissione(Date dataEmissione) {
		model.setDataEmissione(dataEmissione);
	}

	/**
	 * Sets the data fine of this allerta valanghe.
	 *
	 * @param dataFine the data fine of this allerta valanghe
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data firma arpa of this allerta valanghe.
	 *
	 * @param dataFirmaArpa the data firma arpa of this allerta valanghe
	 */
	@Override
	public void setDataFirmaArpa(Date dataFirmaArpa) {
		model.setDataFirmaArpa(dataFirmaArpa);
	}

	/**
	 * Sets the data firma prot of this allerta valanghe.
	 *
	 * @param dataFirmaProt the data firma prot of this allerta valanghe
	 */
	@Override
	public void setDataFirmaProt(Date dataFirmaProt) {
		model.setDataFirmaProt(dataFirmaProt);
	}

	/**
	 * Sets the data inizio of this allerta valanghe.
	 *
	 * @param dataInizio the data inizio of this allerta valanghe
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the descrizione fenomeni of this allerta valanghe.
	 *
	 * @param descrizioneFenomeni the descrizione fenomeni of this allerta valanghe
	 */
	@Override
	public void setDescrizioneFenomeni(String descrizioneFenomeni) {
		model.setDescrizioneFenomeni(descrizioneFenomeni);
	}

	/**
	 * Sets the group ID of this allerta valanghe.
	 *
	 * @param groupId the group ID of this allerta valanghe
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this allerta valanghe.
	 *
	 * @param hash the hash of this allerta valanghe
	 */
	@Override
	public void setHash(String hash) {
		model.setHash(hash);
	}

	/**
	 * Sets the link of this allerta valanghe.
	 *
	 * @param link the link of this allerta valanghe
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this allerta valanghe.
	 *
	 * @param modifiedDate the modified date of this allerta valanghe
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note of this allerta valanghe.
	 *
	 * @param note the note of this allerta valanghe
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the numero of this allerta valanghe.
	 *
	 * @param numero the numero of this allerta valanghe
	 */
	@Override
	public void setNumero(String numero) {
		model.setNumero(numero);
	}

	/**
	 * Sets the parent ID of this allerta valanghe.
	 *
	 * @param parentId the parent ID of this allerta valanghe
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta valanghe.
	 *
	 * @param primaryKey the primary key of this allerta valanghe
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this allerta valanghe.
	 *
	 * @param progressivo the progressivo of this allerta valanghe
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the riferimenti of this allerta valanghe.
	 *
	 * @param riferimenti the riferimenti of this allerta valanghe
	 */
	@Override
	public void setRiferimenti(String riferimenti) {
		model.setRiferimenti(riferimenti);
	}

	/**
	 * Sets the sintesi of this allerta valanghe.
	 *
	 * @param sintesi the sintesi of this allerta valanghe
	 */
	@Override
	public void setSintesi(String sintesi) {
		model.setSintesi(sintesi);
	}

	/**
	 * Sets the stato of this allerta valanghe.
	 *
	 * @param stato the stato of this allerta valanghe
	 */
	@Override
	public void setStato(int stato) {
		model.setStato(stato);
	}

	/**
	 * Sets whether this allerta valanghe is tipo allerta.
	 *
	 * @param tipoAllerta the tipo allerta of this allerta valanghe
	 */
	@Override
	public void setTipoAllerta(boolean tipoAllerta) {
		model.setTipoAllerta(tipoAllerta);
	}

	/**
	 * Sets the titolo of this allerta valanghe.
	 *
	 * @param titolo the titolo of this allerta valanghe
	 */
	@Override
	public void setTitolo(String titolo) {
		model.setTitolo(titolo);
	}

	/**
	 * Sets the user ID of this allerta valanghe.
	 *
	 * @param userId the user ID of this allerta valanghe
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta valanghe.
	 *
	 * @param userName the user name of this allerta valanghe
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta valanghe.
	 *
	 * @param userUuid the user uuid of this allerta valanghe
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utente firma arpa ID of this allerta valanghe.
	 *
	 * @param utenteFirmaArpaId the utente firma arpa ID of this allerta valanghe
	 */
	@Override
	public void setUtenteFirmaArpaId(long utenteFirmaArpaId) {
		model.setUtenteFirmaArpaId(utenteFirmaArpaId);
	}

	/**
	 * Sets the utente firma prot ID of this allerta valanghe.
	 *
	 * @param utenteFirmaProtId the utente firma prot ID of this allerta valanghe
	 */
	@Override
	public void setUtenteFirmaProtId(long utenteFirmaProtId) {
		model.setUtenteFirmaProtId(utenteFirmaProtId);
	}

	/**
	 * Sets the uuid of this allerta valanghe.
	 *
	 * @param uuid the uuid of this allerta valanghe
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
	protected AllertaValangheWrapper wrap(AllertaValanghe allertaValanghe) {
		return new AllertaValangheWrapper(allertaValanghe);
	}

}