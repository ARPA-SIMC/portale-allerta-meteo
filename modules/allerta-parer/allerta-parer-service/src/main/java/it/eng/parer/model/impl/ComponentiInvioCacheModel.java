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

package it.eng.parer.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.service.persistence.ComponentiInvioPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ComponentiInvio in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class ComponentiInvioCacheModel
	implements CacheModel<ComponentiInvio>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ComponentiInvioCacheModel)) {
			return false;
		}

		ComponentiInvioCacheModel componentiInvioCacheModel =
			(ComponentiInvioCacheModel)obj;

		if (componentiInvioPK.equals(
				componentiInvioCacheModel.componentiInvioPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, componentiInvioPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID_INVIO=");
		sb.append(ID_INVIO);
		sb.append(", ID_COMPONENTE=");
		sb.append(ID_COMPONENTE);
		sb.append(", ORDINE_PRESENTAZIONE=");
		sb.append(ORDINE_PRESENTAZIONE);
		sb.append(", TIPO_COMPONENTE=");
		sb.append(TIPO_COMPONENTE);
		sb.append(", TIPO_SUPPORTO_COMPONENTE=");
		sb.append(TIPO_SUPPORTO_COMPONENTE);
		sb.append(", NOME_COMPONENTE=");
		sb.append(NOME_COMPONENTE);
		sb.append(", FORMATO_FILE_VERSATO=");
		sb.append(FORMATO_FILE_VERSATO);
		sb.append(", HASH_VERSATO=");
		sb.append(HASH_VERSATO);
		sb.append(", URN_VERSATO=");
		sb.append(URN_VERSATO);
		sb.append(", ID_COMPONENTE_VERSATO=");
		sb.append(ID_COMPONENTE_VERSATO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ComponentiInvio toEntityModel() {
		ComponentiInvioImpl componentiInvioImpl = new ComponentiInvioImpl();

		componentiInvioImpl.setID_INVIO(ID_INVIO);
		componentiInvioImpl.setID_COMPONENTE(ID_COMPONENTE);
		componentiInvioImpl.setORDINE_PRESENTAZIONE(ORDINE_PRESENTAZIONE);

		if (TIPO_COMPONENTE == null) {
			componentiInvioImpl.setTIPO_COMPONENTE("");
		}
		else {
			componentiInvioImpl.setTIPO_COMPONENTE(TIPO_COMPONENTE);
		}

		if (TIPO_SUPPORTO_COMPONENTE == null) {
			componentiInvioImpl.setTIPO_SUPPORTO_COMPONENTE("");
		}
		else {
			componentiInvioImpl.setTIPO_SUPPORTO_COMPONENTE(
				TIPO_SUPPORTO_COMPONENTE);
		}

		if (NOME_COMPONENTE == null) {
			componentiInvioImpl.setNOME_COMPONENTE("");
		}
		else {
			componentiInvioImpl.setNOME_COMPONENTE(NOME_COMPONENTE);
		}

		if (FORMATO_FILE_VERSATO == null) {
			componentiInvioImpl.setFORMATO_FILE_VERSATO("");
		}
		else {
			componentiInvioImpl.setFORMATO_FILE_VERSATO(FORMATO_FILE_VERSATO);
		}

		if (HASH_VERSATO == null) {
			componentiInvioImpl.setHASH_VERSATO("");
		}
		else {
			componentiInvioImpl.setHASH_VERSATO(HASH_VERSATO);
		}

		if (URN_VERSATO == null) {
			componentiInvioImpl.setURN_VERSATO("");
		}
		else {
			componentiInvioImpl.setURN_VERSATO(URN_VERSATO);
		}

		componentiInvioImpl.setID_COMPONENTE_VERSATO(ID_COMPONENTE_VERSATO);

		componentiInvioImpl.resetOriginalValues();

		return componentiInvioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_INVIO = objectInput.readLong();

		ID_COMPONENTE = objectInput.readLong();

		ORDINE_PRESENTAZIONE = objectInput.readLong();
		TIPO_COMPONENTE = objectInput.readUTF();
		TIPO_SUPPORTO_COMPONENTE = objectInput.readUTF();
		NOME_COMPONENTE = objectInput.readUTF();
		FORMATO_FILE_VERSATO = objectInput.readUTF();
		HASH_VERSATO = objectInput.readUTF();
		URN_VERSATO = objectInput.readUTF();

		ID_COMPONENTE_VERSATO = objectInput.readLong();

		componentiInvioPK = new ComponentiInvioPK(ID_INVIO, ID_COMPONENTE);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_INVIO);

		objectOutput.writeLong(ID_COMPONENTE);

		objectOutput.writeLong(ORDINE_PRESENTAZIONE);

		if (TIPO_COMPONENTE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPO_COMPONENTE);
		}

		if (TIPO_SUPPORTO_COMPONENTE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPO_SUPPORTO_COMPONENTE);
		}

		if (NOME_COMPONENTE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NOME_COMPONENTE);
		}

		if (FORMATO_FILE_VERSATO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FORMATO_FILE_VERSATO);
		}

		if (HASH_VERSATO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(HASH_VERSATO);
		}

		if (URN_VERSATO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(URN_VERSATO);
		}

		objectOutput.writeLong(ID_COMPONENTE_VERSATO);
	}

	public long ID_INVIO;

	public long ID_COMPONENTE;

	public long ORDINE_PRESENTAZIONE;

	public String TIPO_COMPONENTE;

	public String TIPO_SUPPORTO_COMPONENTE;

	public String NOME_COMPONENTE;

	public String FORMATO_FILE_VERSATO;

	public String HASH_VERSATO;

	public String URN_VERSATO;

	public long ID_COMPONENTE_VERSATO;

	public transient ComponentiInvioPK componentiInvioPK;

}