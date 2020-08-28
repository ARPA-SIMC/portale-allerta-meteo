/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author GFAVINI
 * @generated
 */
@ProviderType
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeografiaPK)) {
			return false;
		}

		GeografiaPK pk = (GeografiaPK)obj;

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