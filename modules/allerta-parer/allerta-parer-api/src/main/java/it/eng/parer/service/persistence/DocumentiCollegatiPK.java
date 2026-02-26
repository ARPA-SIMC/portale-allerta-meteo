/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Pratola_L
 * @generated
 */
public class DocumentiCollegatiPK
	implements Comparable<DocumentiCollegatiPK>, Serializable {

	public String DOC_COLLEGATO_NUMERO;

	public int DOC_COLLEGATO_ANNO;

	public String DOC_COLLEGATO_TIPO_REGISTRO;

	public long ID_INVIO;

	public DocumentiCollegatiPK() {
	}

	public DocumentiCollegatiPK(
		String DOC_COLLEGATO_NUMERO, int DOC_COLLEGATO_ANNO,
		String DOC_COLLEGATO_TIPO_REGISTRO, long ID_INVIO) {

		this.DOC_COLLEGATO_NUMERO = DOC_COLLEGATO_NUMERO;
		this.DOC_COLLEGATO_ANNO = DOC_COLLEGATO_ANNO;
		this.DOC_COLLEGATO_TIPO_REGISTRO = DOC_COLLEGATO_TIPO_REGISTRO;
		this.ID_INVIO = ID_INVIO;
	}

	public String getDOC_COLLEGATO_NUMERO() {
		return DOC_COLLEGATO_NUMERO;
	}

	public void setDOC_COLLEGATO_NUMERO(String DOC_COLLEGATO_NUMERO) {
		this.DOC_COLLEGATO_NUMERO = DOC_COLLEGATO_NUMERO;
	}

	public int getDOC_COLLEGATO_ANNO() {
		return DOC_COLLEGATO_ANNO;
	}

	public void setDOC_COLLEGATO_ANNO(int DOC_COLLEGATO_ANNO) {
		this.DOC_COLLEGATO_ANNO = DOC_COLLEGATO_ANNO;
	}

	public String getDOC_COLLEGATO_TIPO_REGISTRO() {
		return DOC_COLLEGATO_TIPO_REGISTRO;
	}

	public void setDOC_COLLEGATO_TIPO_REGISTRO(
		String DOC_COLLEGATO_TIPO_REGISTRO) {

		this.DOC_COLLEGATO_TIPO_REGISTRO = DOC_COLLEGATO_TIPO_REGISTRO;
	}

	public long getID_INVIO() {
		return ID_INVIO;
	}

	public void setID_INVIO(long ID_INVIO) {
		this.ID_INVIO = ID_INVIO;
	}

	@Override
	public int compareTo(DocumentiCollegatiPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = DOC_COLLEGATO_NUMERO.compareTo(pk.DOC_COLLEGATO_NUMERO);

		if (value != 0) {
			return value;
		}

		if (DOC_COLLEGATO_ANNO < pk.DOC_COLLEGATO_ANNO) {
			value = -1;
		}
		else if (DOC_COLLEGATO_ANNO > pk.DOC_COLLEGATO_ANNO) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DOC_COLLEGATO_TIPO_REGISTRO.compareTo(
			pk.DOC_COLLEGATO_TIPO_REGISTRO);

		if (value != 0) {
			return value;
		}

		if (ID_INVIO < pk.ID_INVIO) {
			value = -1;
		}
		else if (ID_INVIO > pk.ID_INVIO) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentiCollegatiPK)) {
			return false;
		}

		DocumentiCollegatiPK pk = (DocumentiCollegatiPK)object;

		if (DOC_COLLEGATO_NUMERO.equals(pk.DOC_COLLEGATO_NUMERO) &&
			(DOC_COLLEGATO_ANNO == pk.DOC_COLLEGATO_ANNO) &&
			DOC_COLLEGATO_TIPO_REGISTRO.equals(
				pk.DOC_COLLEGATO_TIPO_REGISTRO) &&
			(ID_INVIO == pk.ID_INVIO)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, DOC_COLLEGATO_NUMERO);
		hashCode = HashUtil.hash(hashCode, DOC_COLLEGATO_ANNO);
		hashCode = HashUtil.hash(hashCode, DOC_COLLEGATO_TIPO_REGISTRO);
		hashCode = HashUtil.hash(hashCode, ID_INVIO);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append("{");

		sb.append("DOC_COLLEGATO_NUMERO=");

		sb.append(DOC_COLLEGATO_NUMERO);
		sb.append(", DOC_COLLEGATO_ANNO=");

		sb.append(DOC_COLLEGATO_ANNO);
		sb.append(", DOC_COLLEGATO_TIPO_REGISTRO=");

		sb.append(DOC_COLLEGATO_TIPO_REGISTRO);
		sb.append(", ID_INVIO=");

		sb.append(ID_INVIO);

		sb.append("}");

		return sb.toString();
	}

}