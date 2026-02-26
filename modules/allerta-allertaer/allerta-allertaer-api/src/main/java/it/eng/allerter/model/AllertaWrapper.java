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
 * This class is a wrapper for {@link Allerta}.
 * </p>
 *
 * @author GFAVINI
 * @see Allerta
 * @generated
 */
public class AllertaWrapper
	extends BaseModelWrapper<Allerta>
	implements Allerta, ModelWrapper<Allerta> {

	public AllertaWrapper(Allerta allerta) {
		super(allerta);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaId", getAllertaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("creatorName", getCreatorName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stato", getStato());
		attributes.put("numero", getNumero());
		attributes.put("progressivo", getProgressivo());
		attributes.put("anno", getAnno());
		attributes.put("dataEmissione", getDataEmissione());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("descrizioneMeteo", getDescrizioneMeteo());
		attributes.put("tendenza", getTendenza());
		attributes.put("note", getNote());
		attributes.put("riferimenti", getRiferimenti());
		attributes.put("utenteFirmaArpaId", getUtenteFirmaArpaId());
		attributes.put("dataFirmaArpa", getDataFirmaArpa());
		attributes.put("utenteFirmaProtId", getUtenteFirmaProtId());
		attributes.put("dataFirmaProt", getDataFirmaProt());
		attributes.put("parentId", getParentId());
		attributes.put("sintesi", getSintesi());
		attributes.put("sintesiEng", getSintesiEng());
		attributes.put("link", getLink());
		attributes.put("titolo", getTitolo());
		attributes.put("titoloEng", getTitoloEng());
		attributes.put("tipoAllerta", isTipoAllerta());
		attributes.put("hash", getHash());
		attributes.put("sintesiBriefing", getSintesiBriefing());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allertaId = (Long)attributes.get("allertaId");

		if (allertaId != null) {
			setAllertaId(allertaId);
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

		Integer stato = (Integer)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
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

		String descrizioneMeteo = (String)attributes.get("descrizioneMeteo");

		if (descrizioneMeteo != null) {
			setDescrizioneMeteo(descrizioneMeteo);
		}

		Integer tendenza = (Integer)attributes.get("tendenza");

		if (tendenza != null) {
			setTendenza(tendenza);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String riferimenti = (String)attributes.get("riferimenti");

		if (riferimenti != null) {
			setRiferimenti(riferimenti);
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

		String sintesi = (String)attributes.get("sintesi");

		if (sintesi != null) {
			setSintesi(sintesi);
		}

		String sintesiEng = (String)attributes.get("sintesiEng");

		if (sintesiEng != null) {
			setSintesiEng(sintesiEng);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String titoloEng = (String)attributes.get("titoloEng");

		if (titoloEng != null) {
			setTitoloEng(titoloEng);
		}

		Boolean tipoAllerta = (Boolean)attributes.get("tipoAllerta");

		if (tipoAllerta != null) {
			setTipoAllerta(tipoAllerta);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}

		String sintesiBriefing = (String)attributes.get("sintesiBriefing");

		if (sintesiBriefing != null) {
			setSintesiBriefing(sintesiBriefing);
		}
	}

	@Override
	public Allerta cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allerta ID of this allerta.
	 *
	 * @return the allerta ID of this allerta
	 */
	@Override
	public long getAllertaId() {
		return model.getAllertaId();
	}

	@Override
	public java.util.List<AllertaStato> getAllertaStato() {
		return model.getAllertaStato();
	}

	/**
	 * Returns the anno of this allerta.
	 *
	 * @return the anno of this allerta
	 */
	@Override
	public int getAnno() {
		return model.getAnno();
	}

	/**
	 * Returns the company ID of this allerta.
	 *
	 * @return the company ID of this allerta
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta.
	 *
	 * @return the create date of this allerta
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator name of this allerta.
	 *
	 * @return the creator name of this allerta
	 */
	@Override
	public String getCreatorName() {
		return model.getCreatorName();
	}

	/**
	 * Returns the data emissione of this allerta.
	 *
	 * @return the data emissione of this allerta
	 */
	@Override
	public Date getDataEmissione() {
		return model.getDataEmissione();
	}

	/**
	 * Returns the data fine of this allerta.
	 *
	 * @return the data fine of this allerta
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data firma arpa of this allerta.
	 *
	 * @return the data firma arpa of this allerta
	 */
	@Override
	public Date getDataFirmaArpa() {
		return model.getDataFirmaArpa();
	}

	/**
	 * Returns the data firma prot of this allerta.
	 *
	 * @return the data firma prot of this allerta
	 */
	@Override
	public Date getDataFirmaProt() {
		return model.getDataFirmaProt();
	}

	/**
	 * Returns the data inizio of this allerta.
	 *
	 * @return the data inizio of this allerta
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	/**
	 * Returns the descrizione meteo of this allerta.
	 *
	 * @return the descrizione meteo of this allerta
	 */
	@Override
	public String getDescrizioneMeteo() {
		return model.getDescrizioneMeteo();
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
	 * Returns the group ID of this allerta.
	 *
	 * @return the group ID of this allerta
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hash of this allerta.
	 *
	 * @return the hash of this allerta
	 */
	@Override
	public String getHash() {
		return model.getHash();
	}

	/**
	 * Returns the link of this allerta.
	 *
	 * @return the link of this allerta
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this allerta.
	 *
	 * @return the modified date of this allerta
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note of this allerta.
	 *
	 * @return the note of this allerta
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the numero of this allerta.
	 *
	 * @return the numero of this allerta
	 */
	@Override
	public String getNumero() {
		return model.getNumero();
	}

	/**
	 * Returns the parent ID of this allerta.
	 *
	 * @return the parent ID of this allerta
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this allerta.
	 *
	 * @return the primary key of this allerta
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this allerta.
	 *
	 * @return the progressivo of this allerta
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
	 * Returns the riferimenti of this allerta.
	 *
	 * @return the riferimenti of this allerta
	 */
	@Override
	public String getRiferimenti() {
		return model.getRiferimenti();
	}

	/**
	 * Returns the sintesi of this allerta.
	 *
	 * @return the sintesi of this allerta
	 */
	@Override
	public String getSintesi() {
		return model.getSintesi();
	}

	/**
	 * Returns the sintesi briefing of this allerta.
	 *
	 * @return the sintesi briefing of this allerta
	 */
	@Override
	public String getSintesiBriefing() {
		return model.getSintesiBriefing();
	}

	/**
	 * Returns the sintesi eng of this allerta.
	 *
	 * @return the sintesi eng of this allerta
	 */
	@Override
	public String getSintesiEng() {
		return model.getSintesiEng();
	}

	/**
	 * Returns the stato of this allerta.
	 *
	 * @return the stato of this allerta
	 */
	@Override
	public int getStato() {
		return model.getStato();
	}

	/**
	 * Returns the tendenza of this allerta.
	 *
	 * @return the tendenza of this allerta
	 */
	@Override
	public int getTendenza() {
		return model.getTendenza();
	}

	/**
	 * Returns the tipo allerta of this allerta.
	 *
	 * @return the tipo allerta of this allerta
	 */
	@Override
	public boolean getTipoAllerta() {
		return model.getTipoAllerta();
	}

	/**
	 * Returns the titolo of this allerta.
	 *
	 * @return the titolo of this allerta
	 */
	@Override
	public String getTitolo() {
		return model.getTitolo();
	}

	/**
	 * Returns the titolo eng of this allerta.
	 *
	 * @return the titolo eng of this allerta
	 */
	@Override
	public String getTitoloEng() {
		return model.getTitoloEng();
	}

	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this allerta.
	 *
	 * @return the user ID of this allerta
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this allerta.
	 *
	 * @return the user name of this allerta
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta.
	 *
	 * @return the user uuid of this allerta
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utente firma arpa ID of this allerta.
	 *
	 * @return the utente firma arpa ID of this allerta
	 */
	@Override
	public long getUtenteFirmaArpaId() {
		return model.getUtenteFirmaArpaId();
	}

	/**
	 * Returns the utente firma prot ID of this allerta.
	 *
	 * @return the utente firma prot ID of this allerta
	 */
	@Override
	public long getUtenteFirmaProtId() {
		return model.getUtenteFirmaProtId();
	}

	/**
	 * Returns the uuid of this allerta.
	 *
	 * @return the uuid of this allerta
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this allerta is tipo allerta.
	 *
	 * @return <code>true</code> if this allerta is tipo allerta; <code>false</code> otherwise
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
	 * Sets the allerta ID of this allerta.
	 *
	 * @param allertaId the allerta ID of this allerta
	 */
	@Override
	public void setAllertaId(long allertaId) {
		model.setAllertaId(allertaId);
	}

	/**
	 * Sets the anno of this allerta.
	 *
	 * @param anno the anno of this allerta
	 */
	@Override
	public void setAnno(int anno) {
		model.setAnno(anno);
	}

	/**
	 * Sets the company ID of this allerta.
	 *
	 * @param companyId the company ID of this allerta
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta.
	 *
	 * @param createDate the create date of this allerta
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator name of this allerta.
	 *
	 * @param creatorName the creator name of this allerta
	 */
	@Override
	public void setCreatorName(String creatorName) {
		model.setCreatorName(creatorName);
	}

	/**
	 * Sets the data emissione of this allerta.
	 *
	 * @param dataEmissione the data emissione of this allerta
	 */
	@Override
	public void setDataEmissione(Date dataEmissione) {
		model.setDataEmissione(dataEmissione);
	}

	/**
	 * Sets the data fine of this allerta.
	 *
	 * @param dataFine the data fine of this allerta
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data firma arpa of this allerta.
	 *
	 * @param dataFirmaArpa the data firma arpa of this allerta
	 */
	@Override
	public void setDataFirmaArpa(Date dataFirmaArpa) {
		model.setDataFirmaArpa(dataFirmaArpa);
	}

	/**
	 * Sets the data firma prot of this allerta.
	 *
	 * @param dataFirmaProt the data firma prot of this allerta
	 */
	@Override
	public void setDataFirmaProt(Date dataFirmaProt) {
		model.setDataFirmaProt(dataFirmaProt);
	}

	/**
	 * Sets the data inizio of this allerta.
	 *
	 * @param dataInizio the data inizio of this allerta
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the descrizione meteo of this allerta.
	 *
	 * @param descrizioneMeteo the descrizione meteo of this allerta
	 */
	@Override
	public void setDescrizioneMeteo(String descrizioneMeteo) {
		model.setDescrizioneMeteo(descrizioneMeteo);
	}

	/**
	 * Sets the group ID of this allerta.
	 *
	 * @param groupId the group ID of this allerta
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this allerta.
	 *
	 * @param hash the hash of this allerta
	 */
	@Override
	public void setHash(String hash) {
		model.setHash(hash);
	}

	/**
	 * Sets the link of this allerta.
	 *
	 * @param link the link of this allerta
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this allerta.
	 *
	 * @param modifiedDate the modified date of this allerta
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note of this allerta.
	 *
	 * @param note the note of this allerta
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the numero of this allerta.
	 *
	 * @param numero the numero of this allerta
	 */
	@Override
	public void setNumero(String numero) {
		model.setNumero(numero);
	}

	/**
	 * Sets the parent ID of this allerta.
	 *
	 * @param parentId the parent ID of this allerta
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta.
	 *
	 * @param primaryKey the primary key of this allerta
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this allerta.
	 *
	 * @param progressivo the progressivo of this allerta
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the riferimenti of this allerta.
	 *
	 * @param riferimenti the riferimenti of this allerta
	 */
	@Override
	public void setRiferimenti(String riferimenti) {
		model.setRiferimenti(riferimenti);
	}

	/**
	 * Sets the sintesi of this allerta.
	 *
	 * @param sintesi the sintesi of this allerta
	 */
	@Override
	public void setSintesi(String sintesi) {
		model.setSintesi(sintesi);
	}

	/**
	 * Sets the sintesi briefing of this allerta.
	 *
	 * @param sintesiBriefing the sintesi briefing of this allerta
	 */
	@Override
	public void setSintesiBriefing(String sintesiBriefing) {
		model.setSintesiBriefing(sintesiBriefing);
	}

	/**
	 * Sets the sintesi eng of this allerta.
	 *
	 * @param sintesiEng the sintesi eng of this allerta
	 */
	@Override
	public void setSintesiEng(String sintesiEng) {
		model.setSintesiEng(sintesiEng);
	}

	/**
	 * Sets the stato of this allerta.
	 *
	 * @param stato the stato of this allerta
	 */
	@Override
	public void setStato(int stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the tendenza of this allerta.
	 *
	 * @param tendenza the tendenza of this allerta
	 */
	@Override
	public void setTendenza(int tendenza) {
		model.setTendenza(tendenza);
	}

	/**
	 * Sets whether this allerta is tipo allerta.
	 *
	 * @param tipoAllerta the tipo allerta of this allerta
	 */
	@Override
	public void setTipoAllerta(boolean tipoAllerta) {
		model.setTipoAllerta(tipoAllerta);
	}

	/**
	 * Sets the titolo of this allerta.
	 *
	 * @param titolo the titolo of this allerta
	 */
	@Override
	public void setTitolo(String titolo) {
		model.setTitolo(titolo);
	}

	/**
	 * Sets the titolo eng of this allerta.
	 *
	 * @param titoloEng the titolo eng of this allerta
	 */
	@Override
	public void setTitoloEng(String titoloEng) {
		model.setTitoloEng(titoloEng);
	}

	/**
	 * Sets the user ID of this allerta.
	 *
	 * @param userId the user ID of this allerta
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta.
	 *
	 * @param userName the user name of this allerta
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta.
	 *
	 * @param userUuid the user uuid of this allerta
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utente firma arpa ID of this allerta.
	 *
	 * @param utenteFirmaArpaId the utente firma arpa ID of this allerta
	 */
	@Override
	public void setUtenteFirmaArpaId(long utenteFirmaArpaId) {
		model.setUtenteFirmaArpaId(utenteFirmaArpaId);
	}

	/**
	 * Sets the utente firma prot ID of this allerta.
	 *
	 * @param utenteFirmaProtId the utente firma prot ID of this allerta
	 */
	@Override
	public void setUtenteFirmaProtId(long utenteFirmaProtId) {
		model.setUtenteFirmaProtId(utenteFirmaProtId);
	}

	/**
	 * Sets the uuid of this allerta.
	 *
	 * @param uuid the uuid of this allerta
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
	protected AllertaWrapper wrap(Allerta allerta) {
		return new AllertaWrapper(allerta);
	}

}