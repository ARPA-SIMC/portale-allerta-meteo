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
 * This class is a wrapper for {@link Bollettino}.
 * </p>
 *
 * @author GFAVINI
 * @see Bollettino
 * @generated
 */
public class BollettinoWrapper
	extends BaseModelWrapper<Bollettino>
	implements Bollettino, ModelWrapper<Bollettino> {

	public BollettinoWrapper(Bollettino bollettino) {
		super(bollettino);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bollettinoId", getBollettinoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stato", getStato());
		attributes.put("idApprovatore", getIdApprovatore());
		attributes.put("dataApprovazione", getDataApprovazione());
		attributes.put("numero", getNumero());
		attributes.put("progressivo", getProgressivo());
		attributes.put("anno", getAnno());
		attributes.put("dataEmissione", getDataEmissione());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("noteMeteo", getNoteMeteo());
		attributes.put("stringaMeteo", getStringaMeteo());
		attributes.put("link", getLink());
		attributes.put("ultimo", isUltimo());
		attributes.put("hash", getHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bollettinoId = (Long)attributes.get("bollettinoId");

		if (bollettinoId != null) {
			setBollettinoId(bollettinoId);
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

		String noteMeteo = (String)attributes.get("noteMeteo");

		if (noteMeteo != null) {
			setNoteMeteo(noteMeteo);
		}

		String stringaMeteo = (String)attributes.get("stringaMeteo");

		if (stringaMeteo != null) {
			setStringaMeteo(stringaMeteo);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Boolean ultimo = (Boolean)attributes.get("ultimo");

		if (ultimo != null) {
			setUltimo(ultimo);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public Bollettino cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the anno of this bollettino.
	 *
	 * @return the anno of this bollettino
	 */
	@Override
	public int getAnno() {
		return model.getAnno();
	}

	@Override
	public java.util.List<BollettinoBacino> getBacini() {
		return model.getBacini();
	}

	/**
	 * Returns the bollettino ID of this bollettino.
	 *
	 * @return the bollettino ID of this bollettino
	 */
	@Override
	public long getBollettinoId() {
		return model.getBollettinoId();
	}

	/**
	 * Returns the company ID of this bollettino.
	 *
	 * @return the company ID of this bollettino
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this bollettino.
	 *
	 * @return the create date of this bollettino
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data approvazione of this bollettino.
	 *
	 * @return the data approvazione of this bollettino
	 */
	@Override
	public Date getDataApprovazione() {
		return model.getDataApprovazione();
	}

	/**
	 * Returns the data emissione of this bollettino.
	 *
	 * @return the data emissione of this bollettino
	 */
	@Override
	public Date getDataEmissione() {
		return model.getDataEmissione();
	}

	/**
	 * Returns the data fine of this bollettino.
	 *
	 * @return the data fine of this bollettino
	 */
	@Override
	public Date getDataFine() {
		return model.getDataFine();
	}

	/**
	 * Returns the data inizio of this bollettino.
	 *
	 * @return the data inizio of this bollettino
	 */
	@Override
	public Date getDataInizio() {
		return model.getDataInizio();
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFolder getDLFolder(
		String folderName) {

		return model.getDLFolder(folderName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName) {

		return model.getFile(folderName, fileName);
	}

	@Override
	public String getFileLink(String folderName, String fileName) {
		return model.getFileLink(folderName, fileName);
	}

	@Override
	public String getFileLinkRelative(String folderName, String fileName) {
		return model.getFileLinkRelative(folderName, fileName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		String folderName) {

		return model.getFolder(folderName);
	}

	/**
	 * Returns the group ID of this bollettino.
	 *
	 * @return the group ID of this bollettino
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hash of this bollettino.
	 *
	 * @return the hash of this bollettino
	 */
	@Override
	public String getHash() {
		return model.getHash();
	}

	/**
	 * Returns the id approvatore of this bollettino.
	 *
	 * @return the id approvatore of this bollettino
	 */
	@Override
	public long getIdApprovatore() {
		return model.getIdApprovatore();
	}

	/**
	 * Returns the link of this bollettino.
	 *
	 * @return the link of this bollettino
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this bollettino.
	 *
	 * @return the modified date of this bollettino
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note meteo of this bollettino.
	 *
	 * @return the note meteo of this bollettino
	 */
	@Override
	public String getNoteMeteo() {
		return model.getNoteMeteo();
	}

	/**
	 * Returns the numero of this bollettino.
	 *
	 * @return the numero of this bollettino
	 */
	@Override
	public String getNumero() {
		return model.getNumero();
	}

	/**
	 * Returns the primary key of this bollettino.
	 *
	 * @return the primary key of this bollettino
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this bollettino.
	 *
	 * @return the progressivo of this bollettino
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	/**
	 * Returns the stato of this bollettino.
	 *
	 * @return the stato of this bollettino
	 */
	@Override
	public int getStato() {
		return model.getStato();
	}

	/**
	 * Returns the stringa meteo of this bollettino.
	 *
	 * @return the stringa meteo of this bollettino
	 */
	@Override
	public String getStringaMeteo() {
		return model.getStringaMeteo();
	}

	/**
	 * Returns the ultimo of this bollettino.
	 *
	 * @return the ultimo of this bollettino
	 */
	@Override
	public boolean getUltimo() {
		return model.getUltimo();
	}

	/**
	 * Returns the user ID of this bollettino.
	 *
	 * @return the user ID of this bollettino
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this bollettino.
	 *
	 * @return the user name of this bollettino
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this bollettino.
	 *
	 * @return the user uuid of this bollettino
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this bollettino.
	 *
	 * @return the uuid of this bollettino
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this bollettino is ultimo.
	 *
	 * @return <code>true</code> if this bollettino is ultimo; <code>false</code> otherwise
	 */
	@Override
	public boolean isUltimo() {
		return model.isUltimo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the anno of this bollettino.
	 *
	 * @param anno the anno of this bollettino
	 */
	@Override
	public void setAnno(int anno) {
		model.setAnno(anno);
	}

	/**
	 * Sets the bollettino ID of this bollettino.
	 *
	 * @param bollettinoId the bollettino ID of this bollettino
	 */
	@Override
	public void setBollettinoId(long bollettinoId) {
		model.setBollettinoId(bollettinoId);
	}

	/**
	 * Sets the company ID of this bollettino.
	 *
	 * @param companyId the company ID of this bollettino
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this bollettino.
	 *
	 * @param createDate the create date of this bollettino
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data approvazione of this bollettino.
	 *
	 * @param dataApprovazione the data approvazione of this bollettino
	 */
	@Override
	public void setDataApprovazione(Date dataApprovazione) {
		model.setDataApprovazione(dataApprovazione);
	}

	/**
	 * Sets the data emissione of this bollettino.
	 *
	 * @param dataEmissione the data emissione of this bollettino
	 */
	@Override
	public void setDataEmissione(Date dataEmissione) {
		model.setDataEmissione(dataEmissione);
	}

	/**
	 * Sets the data fine of this bollettino.
	 *
	 * @param dataFine the data fine of this bollettino
	 */
	@Override
	public void setDataFine(Date dataFine) {
		model.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this bollettino.
	 *
	 * @param dataInizio the data inizio of this bollettino
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		model.setDataInizio(dataInizio);
	}

	/**
	 * Sets the group ID of this bollettino.
	 *
	 * @param groupId the group ID of this bollettino
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hash of this bollettino.
	 *
	 * @param hash the hash of this bollettino
	 */
	@Override
	public void setHash(String hash) {
		model.setHash(hash);
	}

	/**
	 * Sets the id approvatore of this bollettino.
	 *
	 * @param idApprovatore the id approvatore of this bollettino
	 */
	@Override
	public void setIdApprovatore(long idApprovatore) {
		model.setIdApprovatore(idApprovatore);
	}

	/**
	 * Sets the link of this bollettino.
	 *
	 * @param link the link of this bollettino
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this bollettino.
	 *
	 * @param modifiedDate the modified date of this bollettino
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note meteo of this bollettino.
	 *
	 * @param noteMeteo the note meteo of this bollettino
	 */
	@Override
	public void setNoteMeteo(String noteMeteo) {
		model.setNoteMeteo(noteMeteo);
	}

	/**
	 * Sets the numero of this bollettino.
	 *
	 * @param numero the numero of this bollettino
	 */
	@Override
	public void setNumero(String numero) {
		model.setNumero(numero);
	}

	/**
	 * Sets the primary key of this bollettino.
	 *
	 * @param primaryKey the primary key of this bollettino
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this bollettino.
	 *
	 * @param progressivo the progressivo of this bollettino
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the stato of this bollettino.
	 *
	 * @param stato the stato of this bollettino
	 */
	@Override
	public void setStato(int stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the stringa meteo of this bollettino.
	 *
	 * @param stringaMeteo the stringa meteo of this bollettino
	 */
	@Override
	public void setStringaMeteo(String stringaMeteo) {
		model.setStringaMeteo(stringaMeteo);
	}

	/**
	 * Sets whether this bollettino is ultimo.
	 *
	 * @param ultimo the ultimo of this bollettino
	 */
	@Override
	public void setUltimo(boolean ultimo) {
		model.setUltimo(ultimo);
	}

	/**
	 * Sets the user ID of this bollettino.
	 *
	 * @param userId the user ID of this bollettino
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this bollettino.
	 *
	 * @param userName the user name of this bollettino
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this bollettino.
	 *
	 * @param userUuid the user uuid of this bollettino
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this bollettino.
	 *
	 * @param uuid the uuid of this bollettino
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
	protected BollettinoWrapper wrap(Bollettino bollettino) {
		return new BollettinoWrapper(bollettino);
	}

}