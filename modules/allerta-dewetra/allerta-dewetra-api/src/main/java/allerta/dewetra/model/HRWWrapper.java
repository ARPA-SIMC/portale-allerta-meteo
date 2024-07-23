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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link HRW}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HRW
 * @generated
 */
@ProviderType
public class HRWWrapper implements HRW, ModelWrapper<HRW> {

	public HRWWrapper(HRW hrw) {
		_hrw = hrw;
	}

	@Override
	public Class<?> getModelClass() {
		return HRW.class;
	}

	@Override
	public String getModelClassName() {
		return HRW.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("comune", getComune());
		attributes.put("timestamp", getTimestamp());
		attributes.put("HRI", getHRI());
		attributes.put("SSI", getSSI());
		attributes.put("SRI", getSRI());
		attributes.put("VMI", getVMI());
		attributes.put("VIL", getVIL());
		attributes.put("POH", getPOH());
		attributes.put("ETM", getETM());
		attributes.put("TOP", getTOP());
		attributes.put("LGT", getLGT());
		attributes.put("Pers", getPers());
		attributes.put("SRT", getSRT());
		attributes.put("SRT_3", getSRT_3());
		attributes.put("SRT_6", getSRT_6());
		attributes.put("Vel", getVel());
		attributes.put("Dir", getDir());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Double HRI = (Double)attributes.get("HRI");

		if (HRI != null) {
			setHRI(HRI);
		}

		Double SSI = (Double)attributes.get("SSI");

		if (SSI != null) {
			setSSI(SSI);
		}

		Double SRI = (Double)attributes.get("SRI");

		if (SRI != null) {
			setSRI(SRI);
		}

		Double VMI = (Double)attributes.get("VMI");

		if (VMI != null) {
			setVMI(VMI);
		}

		Double VIL = (Double)attributes.get("VIL");

		if (VIL != null) {
			setVIL(VIL);
		}

		Double POH = (Double)attributes.get("POH");

		if (POH != null) {
			setPOH(POH);
		}

		Double ETM = (Double)attributes.get("ETM");

		if (ETM != null) {
			setETM(ETM);
		}

		Double TOP = (Double)attributes.get("TOP");

		if (TOP != null) {
			setTOP(TOP);
		}

		Double LGT = (Double)attributes.get("LGT");

		if (LGT != null) {
			setLGT(LGT);
		}

		Double Pers = (Double)attributes.get("Pers");

		if (Pers != null) {
			setPers(Pers);
		}

		Double SRT = (Double)attributes.get("SRT");

		if (SRT != null) {
			setSRT(SRT);
		}

		Double SRT_3 = (Double)attributes.get("SRT_3");

		if (SRT_3 != null) {
			setSRT_3(SRT_3);
		}

		Double SRT_6 = (Double)attributes.get("SRT_6");

		if (SRT_6 != null) {
			setSRT_6(SRT_6);
		}

		Double Vel = (Double)attributes.get("Vel");

		if (Vel != null) {
			setVel(Vel);
		}

		Double Dir = (Double)attributes.get("Dir");

		if (Dir != null) {
			setDir(Dir);
		}
	}

	@Override
	public Object clone() {
		return new HRWWrapper((HRW)_hrw.clone());
	}

	@Override
	public int compareTo(allerta.dewetra.model.HRW hrw) {
		return _hrw.compareTo(hrw);
	}

	/**
	 * Returns the comune of this hrw.
	 *
	 * @return the comune of this hrw
	 */
	@Override
	public String getComune() {
		return _hrw.getComune();
	}

	/**
	 * Returns the dir of this hrw.
	 *
	 * @return the dir of this hrw
	 */
	@Override
	public double getDir() {
		return _hrw.getDir();
	}

	/**
	 * Returns the etm of this hrw.
	 *
	 * @return the etm of this hrw
	 */
	@Override
	public double getETM() {
		return _hrw.getETM();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _hrw.getExpandoBridge();
	}

	/**
	 * Returns the hri of this hrw.
	 *
	 * @return the hri of this hrw
	 */
	@Override
	public double getHRI() {
		return _hrw.getHRI();
	}

	/**
	 * Returns the ID of this hrw.
	 *
	 * @return the ID of this hrw
	 */
	@Override
	public long getId() {
		return _hrw.getId();
	}

	/**
	 * Returns the lgt of this hrw.
	 *
	 * @return the lgt of this hrw
	 */
	@Override
	public double getLGT() {
		return _hrw.getLGT();
	}

	/**
	 * Returns the pers of this hrw.
	 *
	 * @return the pers of this hrw
	 */
	@Override
	public double getPers() {
		return _hrw.getPers();
	}

	/**
	 * Returns the poh of this hrw.
	 *
	 * @return the poh of this hrw
	 */
	@Override
	public double getPOH() {
		return _hrw.getPOH();
	}

	/**
	 * Returns the primary key of this hrw.
	 *
	 * @return the primary key of this hrw
	 */
	@Override
	public long getPrimaryKey() {
		return _hrw.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hrw.getPrimaryKeyObj();
	}

	/**
	 * Returns the sri of this hrw.
	 *
	 * @return the sri of this hrw
	 */
	@Override
	public double getSRI() {
		return _hrw.getSRI();
	}

	/**
	 * Returns the srt of this hrw.
	 *
	 * @return the srt of this hrw
	 */
	@Override
	public double getSRT() {
		return _hrw.getSRT();
	}

	/**
	 * Returns the srt_3 of this hrw.
	 *
	 * @return the srt_3 of this hrw
	 */
	@Override
	public double getSRT_3() {
		return _hrw.getSRT_3();
	}

	/**
	 * Returns the srt_6 of this hrw.
	 *
	 * @return the srt_6 of this hrw
	 */
	@Override
	public double getSRT_6() {
		return _hrw.getSRT_6();
	}

	/**
	 * Returns the ssi of this hrw.
	 *
	 * @return the ssi of this hrw
	 */
	@Override
	public double getSSI() {
		return _hrw.getSSI();
	}

	/**
	 * Returns the timestamp of this hrw.
	 *
	 * @return the timestamp of this hrw
	 */
	@Override
	public Date getTimestamp() {
		return _hrw.getTimestamp();
	}

	/**
	 * Returns the top of this hrw.
	 *
	 * @return the top of this hrw
	 */
	@Override
	public double getTOP() {
		return _hrw.getTOP();
	}

	/**
	 * Returns the vel of this hrw.
	 *
	 * @return the vel of this hrw
	 */
	@Override
	public double getVel() {
		return _hrw.getVel();
	}

	/**
	 * Returns the vil of this hrw.
	 *
	 * @return the vil of this hrw
	 */
	@Override
	public double getVIL() {
		return _hrw.getVIL();
	}

	/**
	 * Returns the vmi of this hrw.
	 *
	 * @return the vmi of this hrw
	 */
	@Override
	public double getVMI() {
		return _hrw.getVMI();
	}

	@Override
	public int hashCode() {
		return _hrw.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _hrw.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _hrw.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _hrw.isNew();
	}

	@Override
	public void persist() {
		_hrw.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hrw.setCachedModel(cachedModel);
	}

	/**
	 * Sets the comune of this hrw.
	 *
	 * @param comune the comune of this hrw
	 */
	@Override
	public void setComune(String comune) {
		_hrw.setComune(comune);
	}

	/**
	 * Sets the dir of this hrw.
	 *
	 * @param Dir the dir of this hrw
	 */
	@Override
	public void setDir(double Dir) {
		_hrw.setDir(Dir);
	}

	/**
	 * Sets the etm of this hrw.
	 *
	 * @param ETM the etm of this hrw
	 */
	@Override
	public void setETM(double ETM) {
		_hrw.setETM(ETM);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_hrw.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_hrw.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_hrw.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the hri of this hrw.
	 *
	 * @param HRI the hri of this hrw
	 */
	@Override
	public void setHRI(double HRI) {
		_hrw.setHRI(HRI);
	}

	/**
	 * Sets the ID of this hrw.
	 *
	 * @param id the ID of this hrw
	 */
	@Override
	public void setId(long id) {
		_hrw.setId(id);
	}

	/**
	 * Sets the lgt of this hrw.
	 *
	 * @param LGT the lgt of this hrw
	 */
	@Override
	public void setLGT(double LGT) {
		_hrw.setLGT(LGT);
	}

	@Override
	public void setNew(boolean n) {
		_hrw.setNew(n);
	}

	/**
	 * Sets the pers of this hrw.
	 *
	 * @param Pers the pers of this hrw
	 */
	@Override
	public void setPers(double Pers) {
		_hrw.setPers(Pers);
	}

	/**
	 * Sets the poh of this hrw.
	 *
	 * @param POH the poh of this hrw
	 */
	@Override
	public void setPOH(double POH) {
		_hrw.setPOH(POH);
	}

	/**
	 * Sets the primary key of this hrw.
	 *
	 * @param primaryKey the primary key of this hrw
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hrw.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_hrw.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the sri of this hrw.
	 *
	 * @param SRI the sri of this hrw
	 */
	@Override
	public void setSRI(double SRI) {
		_hrw.setSRI(SRI);
	}

	/**
	 * Sets the srt of this hrw.
	 *
	 * @param SRT the srt of this hrw
	 */
	@Override
	public void setSRT(double SRT) {
		_hrw.setSRT(SRT);
	}

	/**
	 * Sets the srt_3 of this hrw.
	 *
	 * @param SRT_3 the srt_3 of this hrw
	 */
	@Override
	public void setSRT_3(double SRT_3) {
		_hrw.setSRT_3(SRT_3);
	}

	/**
	 * Sets the srt_6 of this hrw.
	 *
	 * @param SRT_6 the srt_6 of this hrw
	 */
	@Override
	public void setSRT_6(double SRT_6) {
		_hrw.setSRT_6(SRT_6);
	}

	/**
	 * Sets the ssi of this hrw.
	 *
	 * @param SSI the ssi of this hrw
	 */
	@Override
	public void setSSI(double SSI) {
		_hrw.setSSI(SSI);
	}

	/**
	 * Sets the timestamp of this hrw.
	 *
	 * @param timestamp the timestamp of this hrw
	 */
	@Override
	public void setTimestamp(Date timestamp) {
		_hrw.setTimestamp(timestamp);
	}

	/**
	 * Sets the top of this hrw.
	 *
	 * @param TOP the top of this hrw
	 */
	@Override
	public void setTOP(double TOP) {
		_hrw.setTOP(TOP);
	}

	/**
	 * Sets the vel of this hrw.
	 *
	 * @param Vel the vel of this hrw
	 */
	@Override
	public void setVel(double Vel) {
		_hrw.setVel(Vel);
	}

	/**
	 * Sets the vil of this hrw.
	 *
	 * @param VIL the vil of this hrw
	 */
	@Override
	public void setVIL(double VIL) {
		_hrw.setVIL(VIL);
	}

	/**
	 * Sets the vmi of this hrw.
	 *
	 * @param VMI the vmi of this hrw
	 */
	@Override
	public void setVMI(double VMI) {
		_hrw.setVMI(VMI);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<allerta.dewetra.model.HRW>
		toCacheModel() {

		return _hrw.toCacheModel();
	}

	@Override
	public allerta.dewetra.model.HRW toEscapedModel() {
		return new HRWWrapper(_hrw.toEscapedModel());
	}

	@Override
	public String toString() {
		return _hrw.toString();
	}

	@Override
	public allerta.dewetra.model.HRW toUnescapedModel() {
		return new HRWWrapper(_hrw.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _hrw.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HRWWrapper)) {
			return false;
		}

		HRWWrapper hrwWrapper = (HRWWrapper)obj;

		if (Objects.equals(_hrw, hrwWrapper._hrw)) {
			return true;
		}

		return false;
	}

	@Override
	public HRW getWrappedModel() {
		return _hrw;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _hrw.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _hrw.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_hrw.resetOriginalValues();
	}

	private final HRW _hrw;

}