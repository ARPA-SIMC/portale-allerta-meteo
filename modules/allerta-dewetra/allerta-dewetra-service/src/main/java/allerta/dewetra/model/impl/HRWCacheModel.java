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

package allerta.dewetra.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.dewetra.model.HRW;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HRW in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class HRWCacheModel implements CacheModel<HRW>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HRWCacheModel)) {
			return false;
		}

		HRWCacheModel hrwCacheModel = (HRWCacheModel)obj;

		if (id == hrwCacheModel.id) {
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
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(id);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", HRI=");
		sb.append(HRI);
		sb.append(", SSI=");
		sb.append(SSI);
		sb.append(", SRI=");
		sb.append(SRI);
		sb.append(", VMI=");
		sb.append(VMI);
		sb.append(", VIL=");
		sb.append(VIL);
		sb.append(", POH=");
		sb.append(POH);
		sb.append(", ETM=");
		sb.append(ETM);
		sb.append(", TOP=");
		sb.append(TOP);
		sb.append(", LGT=");
		sb.append(LGT);
		sb.append(", Pers=");
		sb.append(Pers);
		sb.append(", SRT=");
		sb.append(SRT);
		sb.append(", SRT_3=");
		sb.append(SRT_3);
		sb.append(", SRT_6=");
		sb.append(SRT_6);
		sb.append(", Vel=");
		sb.append(Vel);
		sb.append(", Dir=");
		sb.append(Dir);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HRW toEntityModel() {
		HRWImpl hrwImpl = new HRWImpl();

		hrwImpl.setId(id);

		if (comune == null) {
			hrwImpl.setComune("");
		}
		else {
			hrwImpl.setComune(comune);
		}

		if (timestamp == Long.MIN_VALUE) {
			hrwImpl.setTimestamp(null);
		}
		else {
			hrwImpl.setTimestamp(new Date(timestamp));
		}

		hrwImpl.setHRI(HRI);
		hrwImpl.setSSI(SSI);
		hrwImpl.setSRI(SRI);
		hrwImpl.setVMI(VMI);
		hrwImpl.setVIL(VIL);
		hrwImpl.setPOH(POH);
		hrwImpl.setETM(ETM);
		hrwImpl.setTOP(TOP);
		hrwImpl.setLGT(LGT);
		hrwImpl.setPers(Pers);
		hrwImpl.setSRT(SRT);
		hrwImpl.setSRT_3(SRT_3);
		hrwImpl.setSRT_6(SRT_6);
		hrwImpl.setVel(Vel);
		hrwImpl.setDir(Dir);

		hrwImpl.resetOriginalValues();

		return hrwImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		comune = objectInput.readUTF();
		timestamp = objectInput.readLong();

		HRI = objectInput.readDouble();

		SSI = objectInput.readDouble();

		SRI = objectInput.readDouble();

		VMI = objectInput.readDouble();

		VIL = objectInput.readDouble();

		POH = objectInput.readDouble();

		ETM = objectInput.readDouble();

		TOP = objectInput.readDouble();

		LGT = objectInput.readDouble();

		Pers = objectInput.readDouble();

		SRT = objectInput.readDouble();

		SRT_3 = objectInput.readDouble();

		SRT_6 = objectInput.readDouble();

		Vel = objectInput.readDouble();

		Dir = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (comune == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comune);
		}

		objectOutput.writeLong(timestamp);

		objectOutput.writeDouble(HRI);

		objectOutput.writeDouble(SSI);

		objectOutput.writeDouble(SRI);

		objectOutput.writeDouble(VMI);

		objectOutput.writeDouble(VIL);

		objectOutput.writeDouble(POH);

		objectOutput.writeDouble(ETM);

		objectOutput.writeDouble(TOP);

		objectOutput.writeDouble(LGT);

		objectOutput.writeDouble(Pers);

		objectOutput.writeDouble(SRT);

		objectOutput.writeDouble(SRT_3);

		objectOutput.writeDouble(SRT_6);

		objectOutput.writeDouble(Vel);

		objectOutput.writeDouble(Dir);
	}

	public long id;
	public String comune;
	public long timestamp;

	public double HRI;

	public double SSI;

	public double SRI;

	public double VMI;

	public double VIL;

	public double POH;

	public double ETM;

	public double TOP;

	public double LGT;

	public double Pers;

	public double SRT;

	public double SRT_3;

	public double SRT_6;

	public double Vel;
	public double Dir;

}