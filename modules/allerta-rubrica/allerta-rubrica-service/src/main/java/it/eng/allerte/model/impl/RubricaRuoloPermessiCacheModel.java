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

package it.eng.allerte.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerte.model.RubricaRuoloPermessi;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaRuoloPermessi in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiCacheModel
	implements CacheModel<RubricaRuoloPermessi>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloPermessiCacheModel)) {
			return false;
		}

		RubricaRuoloPermessiCacheModel rubricaRuoloPermessiCacheModel =
			(RubricaRuoloPermessiCacheModel)obj;

		if (rubricaRuoloPermessiPK.equals(
				rubricaRuoloPermessiCacheModel.rubricaRuoloPermessiPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rubricaRuoloPermessiPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{FK_ID_RUOLO=");
		sb.append(FK_ID_RUOLO);
		sb.append(", FK_ID_PERMESSO=");
		sb.append(FK_ID_PERMESSO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaRuoloPermessi toEntityModel() {
		RubricaRuoloPermessiImpl rubricaRuoloPermessiImpl =
			new RubricaRuoloPermessiImpl();

		rubricaRuoloPermessiImpl.setFK_ID_RUOLO(FK_ID_RUOLO);

		if (FK_ID_PERMESSO == null) {
			rubricaRuoloPermessiImpl.setFK_ID_PERMESSO("");
		}
		else {
			rubricaRuoloPermessiImpl.setFK_ID_PERMESSO(FK_ID_PERMESSO);
		}

		rubricaRuoloPermessiImpl.resetOriginalValues();

		return rubricaRuoloPermessiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		FK_ID_RUOLO = objectInput.readLong();
		FK_ID_PERMESSO = objectInput.readUTF();

		rubricaRuoloPermessiPK = new RubricaRuoloPermessiPK(
			FK_ID_RUOLO, FK_ID_PERMESSO);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(FK_ID_RUOLO);

		if (FK_ID_PERMESSO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FK_ID_PERMESSO);
		}
	}

	public long FK_ID_RUOLO;

	public String FK_ID_PERMESSO;

	public transient RubricaRuoloPermessiPK rubricaRuoloPermessiPK;

}