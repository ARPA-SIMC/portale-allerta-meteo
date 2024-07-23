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

package allerta.verifica.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.model.VerificaDato;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VerificaDato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VerificaDatoCacheModel
	implements CacheModel<VerificaDato>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VerificaDatoCacheModel)) {
			return false;
		}

		VerificaDatoCacheModel verificaDatoCacheModel =
			(VerificaDatoCacheModel)obj;

		if (id == verificaDatoCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", documento=");
		sb.append(documento);
		sb.append(", giorno=");
		sb.append(giorno);
		sb.append(", zona=");
		sb.append(zona);
		sb.append(", evento=");
		sb.append(evento);
		sb.append(", nomeDato=");
		sb.append(nomeDato);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append(", datoInserito=");
		sb.append(datoInserito);
		sb.append(", datoCalcolato=");
		sb.append(datoCalcolato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VerificaDato toEntityModel() {
		VerificaDatoImpl verificaDatoImpl = new VerificaDatoImpl();

		verificaDatoImpl.setId(id);
		verificaDatoImpl.setDocumento(documento);

		if (giorno == Long.MIN_VALUE) {
			verificaDatoImpl.setGiorno(null);
		}
		else {
			verificaDatoImpl.setGiorno(new Date(giorno));
		}

		if (zona == null) {
			verificaDatoImpl.setZona("");
		}
		else {
			verificaDatoImpl.setZona(zona);
		}

		verificaDatoImpl.setEvento(evento);

		if (nomeDato == null) {
			verificaDatoImpl.setNomeDato("");
		}
		else {
			verificaDatoImpl.setNomeDato(nomeDato);
		}

		verificaDatoImpl.setProgressivo(progressivo);

		if (datoInserito == null) {
			verificaDatoImpl.setDatoInserito("");
		}
		else {
			verificaDatoImpl.setDatoInserito(datoInserito);
		}

		if (datoCalcolato == null) {
			verificaDatoImpl.setDatoCalcolato("");
		}
		else {
			verificaDatoImpl.setDatoCalcolato(datoCalcolato);
		}

		verificaDatoImpl.resetOriginalValues();

		return verificaDatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		documento = objectInput.readLong();
		giorno = objectInput.readLong();
		zona = objectInput.readUTF();

		evento = objectInput.readLong();
		nomeDato = objectInput.readUTF();

		progressivo = objectInput.readInt();
		datoInserito = objectInput.readUTF();
		datoCalcolato = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(documento);
		objectOutput.writeLong(giorno);

		if (zona == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zona);
		}

		objectOutput.writeLong(evento);

		if (nomeDato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeDato);
		}

		objectOutput.writeInt(progressivo);

		if (datoInserito == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(datoInserito);
		}

		if (datoCalcolato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(datoCalcolato);
		}
	}

	public long id;
	public long documento;
	public long giorno;
	public String zona;
	public long evento;
	public String nomeDato;
	public int progressivo;
	public String datoInserito;
	public String datoCalcolato;

}