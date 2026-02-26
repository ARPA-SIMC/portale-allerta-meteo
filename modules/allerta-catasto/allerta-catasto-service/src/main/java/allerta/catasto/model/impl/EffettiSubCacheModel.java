/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model.impl;

import allerta.catasto.model.EffettiSub;
import allerta.catasto.service.persistence.EffettiSubPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EffettiSub in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EffettiSubCacheModel
	implements CacheModel<EffettiSub>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EffettiSubCacheModel)) {
			return false;
		}

		EffettiSubCacheModel effettiSubCacheModel =
			(EffettiSubCacheModel)object;

		if (effettiSubPK.equals(effettiSubCacheModel.effettiSubPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, effettiSubPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idEffetti=");
		sb.append(idEffetti);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EffettiSub toEntityModel() {
		EffettiSubImpl effettiSubImpl = new EffettiSubImpl();

		effettiSubImpl.setId(id);
		effettiSubImpl.setIdEffetti(idEffetti);

		if (descrizione == null) {
			effettiSubImpl.setDescrizione("");
		}
		else {
			effettiSubImpl.setDescrizione(descrizione);
		}

		effettiSubImpl.resetOriginalValues();

		return effettiSubImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		idEffetti = objectInput.readLong();
		descrizione = objectInput.readUTF();

		effettiSubPK = new EffettiSubPK(id, idEffetti);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(idEffetti);

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id;
	public long idEffetti;
	public String descrizione;
	public transient EffettiSubPK effettiSubPK;

}