/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Segnalazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Segnalazione
 * @generated
 */
public class SegnalazioneWrapper
	extends BaseModelWrapper<Segnalazione>
	implements ModelWrapper<Segnalazione>, Segnalazione {

	public SegnalazioneWrapper(Segnalazione segnalazione) {
		super(segnalazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documentoAssociato", getDocumentoAssociato());
		attributes.put("dataEvento", getDataEvento());
		attributes.put("enteSegnalante", getEnteSegnalante());
		attributes.put("fonte", getFonte());
		attributes.put("categoria", getCategoria());
		attributes.put("sottocategoria", getSottocategoria());
		attributes.put("riferimento", getRiferimento());
		attributes.put("descrizione", getDescrizione());
		attributes.put("note", getNote());
		attributes.put("area", getArea());
		attributes.put("provincia", getProvincia());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("civico", getCivico());
		attributes.put("lat", getLat());
		attributes.put("lon", getLon());
		attributes.put("effetti", getEffetti());
		attributes.put("effettiSub", getEffettiSub());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		Long documentoAssociato = (Long)attributes.get("documentoAssociato");

		if (documentoAssociato != null) {
			setDocumentoAssociato(documentoAssociato);
		}

		Date dataEvento = (Date)attributes.get("dataEvento");

		if (dataEvento != null) {
			setDataEvento(dataEvento);
		}

		String enteSegnalante = (String)attributes.get("enteSegnalante");

		if (enteSegnalante != null) {
			setEnteSegnalante(enteSegnalante);
		}

		Long fonte = (Long)attributes.get("fonte");

		if (fonte != null) {
			setFonte(fonte);
		}

		Long categoria = (Long)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}

		Long sottocategoria = (Long)attributes.get("sottocategoria");

		if (sottocategoria != null) {
			setSottocategoria(sottocategoria);
		}

		String riferimento = (String)attributes.get("riferimento");

		if (riferimento != null) {
			setRiferimento(riferimento);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String civico = (String)attributes.get("civico");

		if (civico != null) {
			setCivico(civico);
		}

		Double lat = (Double)attributes.get("lat");

		if (lat != null) {
			setLat(lat);
		}

		Double lon = (Double)attributes.get("lon");

		if (lon != null) {
			setLon(lon);
		}

		Long effetti = (Long)attributes.get("effetti");

		if (effetti != null) {
			setEffetti(effetti);
		}

		Long effettiSub = (Long)attributes.get("effettiSub");

		if (effettiSub != null) {
			setEffettiSub(effettiSub);
		}
	}

	@Override
	public Segnalazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area of this segnalazione.
	 *
	 * @return the area of this segnalazione
	 */
	@Override
	public String getArea() {
		return model.getArea();
	}

	/**
	 * Returns the categoria of this segnalazione.
	 *
	 * @return the categoria of this segnalazione
	 */
	@Override
	public long getCategoria() {
		return model.getCategoria();
	}

	/**
	 * Returns the civico of this segnalazione.
	 *
	 * @return the civico of this segnalazione
	 */
	@Override
	public String getCivico() {
		return model.getCivico();
	}

	/**
	 * Returns the company ID of this segnalazione.
	 *
	 * @return the company ID of this segnalazione
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the comune of this segnalazione.
	 *
	 * @return the comune of this segnalazione
	 */
	@Override
	public String getComune() {
		return model.getComune();
	}

	/**
	 * Returns the create date of this segnalazione.
	 *
	 * @return the create date of this segnalazione
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data evento of this segnalazione.
	 *
	 * @return the data evento of this segnalazione
	 */
	@Override
	public Date getDataEvento() {
		return model.getDataEvento();
	}

	/**
	 * Returns the descrizione of this segnalazione.
	 *
	 * @return the descrizione of this segnalazione
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the documento associato of this segnalazione.
	 *
	 * @return the documento associato of this segnalazione
	 */
	@Override
	public long getDocumentoAssociato() {
		return model.getDocumentoAssociato();
	}

	/**
	 * Returns the effetti of this segnalazione.
	 *
	 * @return the effetti of this segnalazione
	 */
	@Override
	public long getEffetti() {
		return model.getEffetti();
	}

	/**
	 * Returns the effetti sub of this segnalazione.
	 *
	 * @return the effetti sub of this segnalazione
	 */
	@Override
	public long getEffettiSub() {
		return model.getEffettiSub();
	}

	/**
	 * Returns the ente segnalante of this segnalazione.
	 *
	 * @return the ente segnalante of this segnalazione
	 */
	@Override
	public String getEnteSegnalante() {
		return model.getEnteSegnalante();
	}

	/**
	 * Returns the fonte of this segnalazione.
	 *
	 * @return the fonte of this segnalazione
	 */
	@Override
	public long getFonte() {
		return model.getFonte();
	}

	/**
	 * Returns the group ID of this segnalazione.
	 *
	 * @return the group ID of this segnalazione
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this segnalazione.
	 *
	 * @return the ID of this segnalazione
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the indirizzo of this segnalazione.
	 *
	 * @return the indirizzo of this segnalazione
	 */
	@Override
	public String getIndirizzo() {
		return model.getIndirizzo();
	}

	/**
	 * Returns the lat of this segnalazione.
	 *
	 * @return the lat of this segnalazione
	 */
	@Override
	public double getLat() {
		return model.getLat();
	}

	/**
	 * Returns the lon of this segnalazione.
	 *
	 * @return the lon of this segnalazione
	 */
	@Override
	public double getLon() {
		return model.getLon();
	}

	/**
	 * Returns the modified date of this segnalazione.
	 *
	 * @return the modified date of this segnalazione
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note of this segnalazione.
	 *
	 * @return the note of this segnalazione
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the primary key of this segnalazione.
	 *
	 * @return the primary key of this segnalazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia of this segnalazione.
	 *
	 * @return the provincia of this segnalazione
	 */
	@Override
	public String getProvincia() {
		return model.getProvincia();
	}

	/**
	 * Returns the riferimento of this segnalazione.
	 *
	 * @return the riferimento of this segnalazione
	 */
	@Override
	public String getRiferimento() {
		return model.getRiferimento();
	}

	/**
	 * Returns the sottocategoria of this segnalazione.
	 *
	 * @return the sottocategoria of this segnalazione
	 */
	@Override
	public long getSottocategoria() {
		return model.getSottocategoria();
	}

	/**
	 * Returns the user ID of this segnalazione.
	 *
	 * @return the user ID of this segnalazione
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this segnalazione.
	 *
	 * @return the user name of this segnalazione
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this segnalazione.
	 *
	 * @return the user uuid of this segnalazione
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the area of this segnalazione.
	 *
	 * @param area the area of this segnalazione
	 */
	@Override
	public void setArea(String area) {
		model.setArea(area);
	}

	/**
	 * Sets the categoria of this segnalazione.
	 *
	 * @param categoria the categoria of this segnalazione
	 */
	@Override
	public void setCategoria(long categoria) {
		model.setCategoria(categoria);
	}

	/**
	 * Sets the civico of this segnalazione.
	 *
	 * @param civico the civico of this segnalazione
	 */
	@Override
	public void setCivico(String civico) {
		model.setCivico(civico);
	}

	/**
	 * Sets the company ID of this segnalazione.
	 *
	 * @param companyId the company ID of this segnalazione
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the comune of this segnalazione.
	 *
	 * @param comune the comune of this segnalazione
	 */
	@Override
	public void setComune(String comune) {
		model.setComune(comune);
	}

	/**
	 * Sets the create date of this segnalazione.
	 *
	 * @param createDate the create date of this segnalazione
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data evento of this segnalazione.
	 *
	 * @param dataEvento the data evento of this segnalazione
	 */
	@Override
	public void setDataEvento(Date dataEvento) {
		model.setDataEvento(dataEvento);
	}

	/**
	 * Sets the descrizione of this segnalazione.
	 *
	 * @param descrizione the descrizione of this segnalazione
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the documento associato of this segnalazione.
	 *
	 * @param documentoAssociato the documento associato of this segnalazione
	 */
	@Override
	public void setDocumentoAssociato(long documentoAssociato) {
		model.setDocumentoAssociato(documentoAssociato);
	}

	/**
	 * Sets the effetti of this segnalazione.
	 *
	 * @param effetti the effetti of this segnalazione
	 */
	@Override
	public void setEffetti(long effetti) {
		model.setEffetti(effetti);
	}

	/**
	 * Sets the effetti sub of this segnalazione.
	 *
	 * @param effettiSub the effetti sub of this segnalazione
	 */
	@Override
	public void setEffettiSub(long effettiSub) {
		model.setEffettiSub(effettiSub);
	}

	/**
	 * Sets the ente segnalante of this segnalazione.
	 *
	 * @param enteSegnalante the ente segnalante of this segnalazione
	 */
	@Override
	public void setEnteSegnalante(String enteSegnalante) {
		model.setEnteSegnalante(enteSegnalante);
	}

	/**
	 * Sets the fonte of this segnalazione.
	 *
	 * @param fonte the fonte of this segnalazione
	 */
	@Override
	public void setFonte(long fonte) {
		model.setFonte(fonte);
	}

	/**
	 * Sets the group ID of this segnalazione.
	 *
	 * @param groupId the group ID of this segnalazione
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this segnalazione.
	 *
	 * @param id the ID of this segnalazione
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the indirizzo of this segnalazione.
	 *
	 * @param indirizzo the indirizzo of this segnalazione
	 */
	@Override
	public void setIndirizzo(String indirizzo) {
		model.setIndirizzo(indirizzo);
	}

	/**
	 * Sets the lat of this segnalazione.
	 *
	 * @param lat the lat of this segnalazione
	 */
	@Override
	public void setLat(double lat) {
		model.setLat(lat);
	}

	/**
	 * Sets the lon of this segnalazione.
	 *
	 * @param lon the lon of this segnalazione
	 */
	@Override
	public void setLon(double lon) {
		model.setLon(lon);
	}

	/**
	 * Sets the modified date of this segnalazione.
	 *
	 * @param modifiedDate the modified date of this segnalazione
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note of this segnalazione.
	 *
	 * @param note the note of this segnalazione
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the primary key of this segnalazione.
	 *
	 * @param primaryKey the primary key of this segnalazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia of this segnalazione.
	 *
	 * @param provincia the provincia of this segnalazione
	 */
	@Override
	public void setProvincia(String provincia) {
		model.setProvincia(provincia);
	}

	/**
	 * Sets the riferimento of this segnalazione.
	 *
	 * @param riferimento the riferimento of this segnalazione
	 */
	@Override
	public void setRiferimento(String riferimento) {
		model.setRiferimento(riferimento);
	}

	/**
	 * Sets the sottocategoria of this segnalazione.
	 *
	 * @param sottocategoria the sottocategoria of this segnalazione
	 */
	@Override
	public void setSottocategoria(long sottocategoria) {
		model.setSottocategoria(sottocategoria);
	}

	/**
	 * Sets the user ID of this segnalazione.
	 *
	 * @param userId the user ID of this segnalazione
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this segnalazione.
	 *
	 * @param userName the user name of this segnalazione
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this segnalazione.
	 *
	 * @param userUuid the user uuid of this segnalazione
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SegnalazioneWrapper wrap(Segnalazione segnalazione) {
		return new SegnalazioneWrapper(segnalazione);
	}

}