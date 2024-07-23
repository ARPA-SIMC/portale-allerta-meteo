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

package allerta.dewetra.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link allerta.dewetra.service.http.HRWServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class HRWSoap implements Serializable {

	public static HRWSoap toSoapModel(HRW model) {
		HRWSoap soapModel = new HRWSoap();

		soapModel.setId(model.getId());
		soapModel.setComune(model.getComune());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setHRI(model.getHRI());
		soapModel.setSSI(model.getSSI());
		soapModel.setSRI(model.getSRI());
		soapModel.setVMI(model.getVMI());
		soapModel.setVIL(model.getVIL());
		soapModel.setPOH(model.getPOH());
		soapModel.setETM(model.getETM());
		soapModel.setTOP(model.getTOP());
		soapModel.setLGT(model.getLGT());
		soapModel.setPers(model.getPers());
		soapModel.setSRT(model.getSRT());
		soapModel.setSRT_3(model.getSRT_3());
		soapModel.setSRT_6(model.getSRT_6());
		soapModel.setVel(model.getVel());
		soapModel.setDir(model.getDir());

		return soapModel;
	}

	public static HRWSoap[] toSoapModels(HRW[] models) {
		HRWSoap[] soapModels = new HRWSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HRWSoap[][] toSoapModels(HRW[][] models) {
		HRWSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HRWSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HRWSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HRWSoap[] toSoapModels(List<HRW> models) {
		List<HRWSoap> soapModels = new ArrayList<HRWSoap>(models.size());

		for (HRW model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HRWSoap[soapModels.size()]);
	}

	public HRWSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;
	}

	public double getHRI() {
		return _HRI;
	}

	public void setHRI(double HRI) {
		_HRI = HRI;
	}

	public double getSSI() {
		return _SSI;
	}

	public void setSSI(double SSI) {
		_SSI = SSI;
	}

	public double getSRI() {
		return _SRI;
	}

	public void setSRI(double SRI) {
		_SRI = SRI;
	}

	public double getVMI() {
		return _VMI;
	}

	public void setVMI(double VMI) {
		_VMI = VMI;
	}

	public double getVIL() {
		return _VIL;
	}

	public void setVIL(double VIL) {
		_VIL = VIL;
	}

	public double getPOH() {
		return _POH;
	}

	public void setPOH(double POH) {
		_POH = POH;
	}

	public double getETM() {
		return _ETM;
	}

	public void setETM(double ETM) {
		_ETM = ETM;
	}

	public double getTOP() {
		return _TOP;
	}

	public void setTOP(double TOP) {
		_TOP = TOP;
	}

	public double getLGT() {
		return _LGT;
	}

	public void setLGT(double LGT) {
		_LGT = LGT;
	}

	public double getPers() {
		return _Pers;
	}

	public void setPers(double Pers) {
		_Pers = Pers;
	}

	public double getSRT() {
		return _SRT;
	}

	public void setSRT(double SRT) {
		_SRT = SRT;
	}

	public double getSRT_3() {
		return _SRT_3;
	}

	public void setSRT_3(double SRT_3) {
		_SRT_3 = SRT_3;
	}

	public double getSRT_6() {
		return _SRT_6;
	}

	public void setSRT_6(double SRT_6) {
		_SRT_6 = SRT_6;
	}

	public double getVel() {
		return _Vel;
	}

	public void setVel(double Vel) {
		_Vel = Vel;
	}

	public double getDir() {
		return _Dir;
	}

	public void setDir(double Dir) {
		_Dir = Dir;
	}

	private long _id;
	private String _comune;
	private Date _timestamp;

	private double _HRI;

	private double _SSI;

	private double _SRI;

	private double _VMI;

	private double _VIL;

	private double _POH;

	private double _ETM;

	private double _TOP;

	private double _LGT;

	private double _Pers;

	private double _SRT;

	private double _SRT_3;

	private double _SRT_6;

	private double _Vel;
	private double _Dir;

}