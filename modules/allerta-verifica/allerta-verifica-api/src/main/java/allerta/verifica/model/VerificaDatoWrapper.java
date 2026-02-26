/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VerificaDato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDato
 * @generated
 */
public class VerificaDatoWrapper
	extends BaseModelWrapper<VerificaDato>
	implements ModelWrapper<VerificaDato>, VerificaDato {

	public VerificaDatoWrapper(VerificaDato verificaDato) {
		super(verificaDato);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("documento", getDocumento());
		attributes.put("giorno", getGiorno());
		attributes.put("zona", getZona());
		attributes.put("evento", getEvento());
		attributes.put("nomeDato", getNomeDato());
		attributes.put("progressivo", getProgressivo());
		attributes.put("datoInserito", getDatoInserito());
		attributes.put("datoCalcolato", getDatoCalcolato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long documento = (Long)attributes.get("documento");

		if (documento != null) {
			setDocumento(documento);
		}

		Date giorno = (Date)attributes.get("giorno");

		if (giorno != null) {
			setGiorno(giorno);
		}

		String zona = (String)attributes.get("zona");

		if (zona != null) {
			setZona(zona);
		}

		Long evento = (Long)attributes.get("evento");

		if (evento != null) {
			setEvento(evento);
		}

		String nomeDato = (String)attributes.get("nomeDato");

		if (nomeDato != null) {
			setNomeDato(nomeDato);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		String datoInserito = (String)attributes.get("datoInserito");

		if (datoInserito != null) {
			setDatoInserito(datoInserito);
		}

		String datoCalcolato = (String)attributes.get("datoCalcolato");

		if (datoCalcolato != null) {
			setDatoCalcolato(datoCalcolato);
		}
	}

	@Override
	public VerificaDato cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the dato calcolato of this verifica dato.
	 *
	 * @return the dato calcolato of this verifica dato
	 */
	@Override
	public String getDatoCalcolato() {
		return model.getDatoCalcolato();
	}

	/**
	 * Returns the dato inserito of this verifica dato.
	 *
	 * @return the dato inserito of this verifica dato
	 */
	@Override
	public String getDatoInserito() {
		return model.getDatoInserito();
	}

	/**
	 * Returns the documento of this verifica dato.
	 *
	 * @return the documento of this verifica dato
	 */
	@Override
	public long getDocumento() {
		return model.getDocumento();
	}

	/**
	 * Returns the evento of this verifica dato.
	 *
	 * @return the evento of this verifica dato
	 */
	@Override
	public long getEvento() {
		return model.getEvento();
	}

	/**
	 * Returns the giorno of this verifica dato.
	 *
	 * @return the giorno of this verifica dato
	 */
	@Override
	public Date getGiorno() {
		return model.getGiorno();
	}

	/**
	 * Returns the ID of this verifica dato.
	 *
	 * @return the ID of this verifica dato
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the nome dato of this verifica dato.
	 *
	 * @return the nome dato of this verifica dato
	 */
	@Override
	public String getNomeDato() {
		return model.getNomeDato();
	}

	/**
	 * Returns the primary key of this verifica dato.
	 *
	 * @return the primary key of this verifica dato
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this verifica dato.
	 *
	 * @return the progressivo of this verifica dato
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	/**
	 * Returns the zona of this verifica dato.
	 *
	 * @return the zona of this verifica dato
	 */
	@Override
	public String getZona() {
		return model.getZona();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the dato calcolato of this verifica dato.
	 *
	 * @param datoCalcolato the dato calcolato of this verifica dato
	 */
	@Override
	public void setDatoCalcolato(String datoCalcolato) {
		model.setDatoCalcolato(datoCalcolato);
	}

	/**
	 * Sets the dato inserito of this verifica dato.
	 *
	 * @param datoInserito the dato inserito of this verifica dato
	 */
	@Override
	public void setDatoInserito(String datoInserito) {
		model.setDatoInserito(datoInserito);
	}

	/**
	 * Sets the documento of this verifica dato.
	 *
	 * @param documento the documento of this verifica dato
	 */
	@Override
	public void setDocumento(long documento) {
		model.setDocumento(documento);
	}

	/**
	 * Sets the evento of this verifica dato.
	 *
	 * @param evento the evento of this verifica dato
	 */
	@Override
	public void setEvento(long evento) {
		model.setEvento(evento);
	}

	/**
	 * Sets the giorno of this verifica dato.
	 *
	 * @param giorno the giorno of this verifica dato
	 */
	@Override
	public void setGiorno(Date giorno) {
		model.setGiorno(giorno);
	}

	/**
	 * Sets the ID of this verifica dato.
	 *
	 * @param id the ID of this verifica dato
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the nome dato of this verifica dato.
	 *
	 * @param nomeDato the nome dato of this verifica dato
	 */
	@Override
	public void setNomeDato(String nomeDato) {
		model.setNomeDato(nomeDato);
	}

	/**
	 * Sets the primary key of this verifica dato.
	 *
	 * @param primaryKey the primary key of this verifica dato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this verifica dato.
	 *
	 * @param progressivo the progressivo of this verifica dato
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the zona of this verifica dato.
	 *
	 * @param zona the zona of this verifica dato
	 */
	@Override
	public void setZona(String zona) {
		model.setZona(zona);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected VerificaDatoWrapper wrap(VerificaDato verificaDato) {
		return new VerificaDatoWrapper(verificaDato);
	}

}