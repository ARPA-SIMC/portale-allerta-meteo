/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author GFAVINI
 * @generated
 */
public class GeografiaPK implements Comparable<GeografiaPK>, Serializable {

	public String geografiaId;
	public String tipo;
	public String area;
	public String complessita;

	public GeografiaPK() {
	}

	public GeografiaPK(
		String geografiaId, String tipo, String area, String complessita) {

		this.geografiaId = geografiaId;
		this.tipo = tipo;
		this.area = area;
		this.complessita = complessita;
	}

	public String getGeografiaId() {
		return geografiaId;
	}

	public void setGeografiaId(String geografiaId) {
		this.geografiaId = geografiaId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getComplessita() {
		return complessita;
	}

	public void setComplessita(String complessita) {
		this.complessita = complessita;
	}

	@Override
	public int compareTo(GeografiaPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = geografiaId.compareTo(pk.geografiaId);

		if (value != 0) {
			return value;
		}

		value = tipo.compareTo(pk.tipo);

		if (value != 0) {
			return value;
		}

		value = area.compareTo(pk.area);

		if (value != 0) {
			return value;
		}

		value = complessita.compareTo(pk.complessita);

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

		if (!(object instanceof GeografiaPK)) {
			return false;
		}

		GeografiaPK pk = (GeografiaPK)object;

		if (geografiaId.equals(pk.geografiaId) && tipo.equals(pk.tipo) &&
			area.equals(pk.area) && complessita.equals(pk.complessita)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, geografiaId);
		hashCode = HashUtil.hash(hashCode, tipo);
		hashCode = HashUtil.hash(hashCode, area);
		hashCode = HashUtil.hash(hashCode, complessita);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append("{");

		sb.append("geografiaId=");

		sb.append(geografiaId);
		sb.append(", tipo=");

		sb.append(tipo);
		sb.append(", area=");

		sb.append(area);
		sb.append(", complessita=");

		sb.append(complessita);

		sb.append("}");

		return sb.toString();
	}

}