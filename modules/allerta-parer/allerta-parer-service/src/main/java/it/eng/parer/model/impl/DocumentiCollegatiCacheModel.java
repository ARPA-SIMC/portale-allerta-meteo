/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.persistence.DocumentiCollegatiPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DocumentiCollegati in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class DocumentiCollegatiCacheModel
	implements CacheModel<DocumentiCollegati>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentiCollegatiCacheModel)) {
			return false;
		}

		DocumentiCollegatiCacheModel documentiCollegatiCacheModel =
			(DocumentiCollegatiCacheModel)object;

		if (documentiCollegatiPK.equals(
				documentiCollegatiCacheModel.documentiCollegatiPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentiCollegatiPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{DOC_COLLEGATO_NUMERO=");
		sb.append(DOC_COLLEGATO_NUMERO);
		sb.append(", DOC_COLLEGATO_ANNO=");
		sb.append(DOC_COLLEGATO_ANNO);
		sb.append(", DOC_COLLEGATO_TIPO_REGISTRO=");
		sb.append(DOC_COLLEGATO_TIPO_REGISTRO);
		sb.append(", DESCRIZIONE_COLLEGAMENTO=");
		sb.append(DESCRIZIONE_COLLEGAMENTO);
		sb.append(", ID_INVIO=");
		sb.append(ID_INVIO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentiCollegati toEntityModel() {
		DocumentiCollegatiImpl documentiCollegatiImpl =
			new DocumentiCollegatiImpl();

		if (DOC_COLLEGATO_NUMERO == null) {
			documentiCollegatiImpl.setDOC_COLLEGATO_NUMERO("");
		}
		else {
			documentiCollegatiImpl.setDOC_COLLEGATO_NUMERO(
				DOC_COLLEGATO_NUMERO);
		}

		documentiCollegatiImpl.setDOC_COLLEGATO_ANNO(DOC_COLLEGATO_ANNO);

		if (DOC_COLLEGATO_TIPO_REGISTRO == null) {
			documentiCollegatiImpl.setDOC_COLLEGATO_TIPO_REGISTRO("");
		}
		else {
			documentiCollegatiImpl.setDOC_COLLEGATO_TIPO_REGISTRO(
				DOC_COLLEGATO_TIPO_REGISTRO);
		}

		if (DESCRIZIONE_COLLEGAMENTO == null) {
			documentiCollegatiImpl.setDESCRIZIONE_COLLEGAMENTO("");
		}
		else {
			documentiCollegatiImpl.setDESCRIZIONE_COLLEGAMENTO(
				DESCRIZIONE_COLLEGAMENTO);
		}

		documentiCollegatiImpl.setID_INVIO(ID_INVIO);

		documentiCollegatiImpl.resetOriginalValues();

		return documentiCollegatiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		DOC_COLLEGATO_NUMERO = objectInput.readUTF();

		DOC_COLLEGATO_ANNO = objectInput.readInt();
		DOC_COLLEGATO_TIPO_REGISTRO = objectInput.readUTF();
		DESCRIZIONE_COLLEGAMENTO = objectInput.readUTF();

		ID_INVIO = objectInput.readLong();

		documentiCollegatiPK = new DocumentiCollegatiPK(
			DOC_COLLEGATO_NUMERO, DOC_COLLEGATO_ANNO,
			DOC_COLLEGATO_TIPO_REGISTRO, ID_INVIO);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (DOC_COLLEGATO_NUMERO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DOC_COLLEGATO_NUMERO);
		}

		objectOutput.writeInt(DOC_COLLEGATO_ANNO);

		if (DOC_COLLEGATO_TIPO_REGISTRO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DOC_COLLEGATO_TIPO_REGISTRO);
		}

		if (DESCRIZIONE_COLLEGAMENTO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DESCRIZIONE_COLLEGAMENTO);
		}

		objectOutput.writeLong(ID_INVIO);
	}

	public String DOC_COLLEGATO_NUMERO;

	public int DOC_COLLEGATO_ANNO;

	public String DOC_COLLEGATO_TIPO_REGISTRO;

	public String DESCRIZIONE_COLLEGAMENTO;

	public long ID_INVIO;

	public transient DocumentiCollegatiPK documentiCollegatiPK;

}