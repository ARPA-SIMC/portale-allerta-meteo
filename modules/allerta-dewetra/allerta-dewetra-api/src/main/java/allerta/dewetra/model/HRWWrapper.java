/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HRW}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HRW
 * @generated
 */
public class HRWWrapper
	extends BaseModelWrapper<HRW> implements HRW, ModelWrapper<HRW> {

	public HRWWrapper(HRW hrw) {
		super(hrw);
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
	public HRW cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comune of this hrw.
	 *
	 * @return the comune of this hrw
	 */
	@Override
	public String getComune() {
		return model.getComune();
	}

	/**
	 * Returns the dir of this hrw.
	 *
	 * @return the dir of this hrw
	 */
	@Override
	public double getDir() {
		return model.getDir();
	}

	/**
	 * Returns the etm of this hrw.
	 *
	 * @return the etm of this hrw
	 */
	@Override
	public double getETM() {
		return model.getETM();
	}

	/**
	 * Returns the hri of this hrw.
	 *
	 * @return the hri of this hrw
	 */
	@Override
	public double getHRI() {
		return model.getHRI();
	}

	/**
	 * Returns the ID of this hrw.
	 *
	 * @return the ID of this hrw
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the lgt of this hrw.
	 *
	 * @return the lgt of this hrw
	 */
	@Override
	public double getLGT() {
		return model.getLGT();
	}

	/**
	 * Returns the pers of this hrw.
	 *
	 * @return the pers of this hrw
	 */
	@Override
	public double getPers() {
		return model.getPers();
	}

	/**
	 * Returns the poh of this hrw.
	 *
	 * @return the poh of this hrw
	 */
	@Override
	public double getPOH() {
		return model.getPOH();
	}

	/**
	 * Returns the primary key of this hrw.
	 *
	 * @return the primary key of this hrw
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sri of this hrw.
	 *
	 * @return the sri of this hrw
	 */
	@Override
	public double getSRI() {
		return model.getSRI();
	}

	/**
	 * Returns the srt of this hrw.
	 *
	 * @return the srt of this hrw
	 */
	@Override
	public double getSRT() {
		return model.getSRT();
	}

	/**
	 * Returns the srt_3 of this hrw.
	 *
	 * @return the srt_3 of this hrw
	 */
	@Override
	public double getSRT_3() {
		return model.getSRT_3();
	}

	/**
	 * Returns the srt_6 of this hrw.
	 *
	 * @return the srt_6 of this hrw
	 */
	@Override
	public double getSRT_6() {
		return model.getSRT_6();
	}

	/**
	 * Returns the ssi of this hrw.
	 *
	 * @return the ssi of this hrw
	 */
	@Override
	public double getSSI() {
		return model.getSSI();
	}

	/**
	 * Returns the timestamp of this hrw.
	 *
	 * @return the timestamp of this hrw
	 */
	@Override
	public Date getTimestamp() {
		return model.getTimestamp();
	}

	/**
	 * Returns the top of this hrw.
	 *
	 * @return the top of this hrw
	 */
	@Override
	public double getTOP() {
		return model.getTOP();
	}

	/**
	 * Returns the vel of this hrw.
	 *
	 * @return the vel of this hrw
	 */
	@Override
	public double getVel() {
		return model.getVel();
	}

	/**
	 * Returns the vil of this hrw.
	 *
	 * @return the vil of this hrw
	 */
	@Override
	public double getVIL() {
		return model.getVIL();
	}

	/**
	 * Returns the vmi of this hrw.
	 *
	 * @return the vmi of this hrw
	 */
	@Override
	public double getVMI() {
		return model.getVMI();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comune of this hrw.
	 *
	 * @param comune the comune of this hrw
	 */
	@Override
	public void setComune(String comune) {
		model.setComune(comune);
	}

	/**
	 * Sets the dir of this hrw.
	 *
	 * @param Dir the dir of this hrw
	 */
	@Override
	public void setDir(double Dir) {
		model.setDir(Dir);
	}

	/**
	 * Sets the etm of this hrw.
	 *
	 * @param ETM the etm of this hrw
	 */
	@Override
	public void setETM(double ETM) {
		model.setETM(ETM);
	}

	/**
	 * Sets the hri of this hrw.
	 *
	 * @param HRI the hri of this hrw
	 */
	@Override
	public void setHRI(double HRI) {
		model.setHRI(HRI);
	}

	/**
	 * Sets the ID of this hrw.
	 *
	 * @param id the ID of this hrw
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the lgt of this hrw.
	 *
	 * @param LGT the lgt of this hrw
	 */
	@Override
	public void setLGT(double LGT) {
		model.setLGT(LGT);
	}

	/**
	 * Sets the pers of this hrw.
	 *
	 * @param Pers the pers of this hrw
	 */
	@Override
	public void setPers(double Pers) {
		model.setPers(Pers);
	}

	/**
	 * Sets the poh of this hrw.
	 *
	 * @param POH the poh of this hrw
	 */
	@Override
	public void setPOH(double POH) {
		model.setPOH(POH);
	}

	/**
	 * Sets the primary key of this hrw.
	 *
	 * @param primaryKey the primary key of this hrw
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sri of this hrw.
	 *
	 * @param SRI the sri of this hrw
	 */
	@Override
	public void setSRI(double SRI) {
		model.setSRI(SRI);
	}

	/**
	 * Sets the srt of this hrw.
	 *
	 * @param SRT the srt of this hrw
	 */
	@Override
	public void setSRT(double SRT) {
		model.setSRT(SRT);
	}

	/**
	 * Sets the srt_3 of this hrw.
	 *
	 * @param SRT_3 the srt_3 of this hrw
	 */
	@Override
	public void setSRT_3(double SRT_3) {
		model.setSRT_3(SRT_3);
	}

	/**
	 * Sets the srt_6 of this hrw.
	 *
	 * @param SRT_6 the srt_6 of this hrw
	 */
	@Override
	public void setSRT_6(double SRT_6) {
		model.setSRT_6(SRT_6);
	}

	/**
	 * Sets the ssi of this hrw.
	 *
	 * @param SSI the ssi of this hrw
	 */
	@Override
	public void setSSI(double SSI) {
		model.setSSI(SSI);
	}

	/**
	 * Sets the timestamp of this hrw.
	 *
	 * @param timestamp the timestamp of this hrw
	 */
	@Override
	public void setTimestamp(Date timestamp) {
		model.setTimestamp(timestamp);
	}

	/**
	 * Sets the top of this hrw.
	 *
	 * @param TOP the top of this hrw
	 */
	@Override
	public void setTOP(double TOP) {
		model.setTOP(TOP);
	}

	/**
	 * Sets the vel of this hrw.
	 *
	 * @param Vel the vel of this hrw
	 */
	@Override
	public void setVel(double Vel) {
		model.setVel(Vel);
	}

	/**
	 * Sets the vil of this hrw.
	 *
	 * @param VIL the vil of this hrw
	 */
	@Override
	public void setVIL(double VIL) {
		model.setVIL(VIL);
	}

	/**
	 * Sets the vmi of this hrw.
	 *
	 * @param VMI the vmi of this hrw
	 */
	@Override
	public void setVMI(double VMI) {
		model.setVMI(VMI);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected HRWWrapper wrap(HRW hrw) {
		return new HRWWrapper(hrw);
	}

}