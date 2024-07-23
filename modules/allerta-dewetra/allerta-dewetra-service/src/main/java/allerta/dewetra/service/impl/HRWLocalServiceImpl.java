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

package allerta.dewetra.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allerta.dewetra.model.HRW;
import allerta.dewetra.service.HRWLocalServiceUtil;
import allerta.dewetra.service.base.HRWLocalServiceBaseImpl;

/**
 * The implementation of the hrw local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>allerta.dewetra.service.HRWLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HRWLocalServiceBaseImpl
 */
public class HRWLocalServiceImpl extends HRWLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>allerta.dewetra.service.HRWLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>allerta.dewetra.service.HRWLocalServiceUtil</code>.
	 */
	
	public Map<String, Object> aggiornaDewetra(String dati) {
		
		HashMap<String,Object> m = new HashMap<String, Object>();
		
		JSONDeserializer<Map> deserializer = 
				JSONFactoryUtil.createJSONDeserializer();
		
		Map<String,Object> all = deserializer.deserialize(dati);
		String dt = (String) all.get("reftime");
		 if (dt.endsWith("Z")) dt = dt.substring(0, dt.length()-1);
		 SimpleDateFormat atom = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 Date ddd = null;
		 try {
			 ddd = atom.parse(dt);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		List al = (List)all.get("features");
		 
		 if (al==null || al.size()==0) {
			 m.put("valori", 0);
			 return m;
		 }
		 
		 int howmany = 0;
		 
		 for (int k=0; k<al.size(); k++) {
			 
			 try {
				 Map<String, Object> o = (Map<String, Object>) al.get(k);
				 if (o==null) continue;
				 
				 HRW h = HRWLocalServiceUtil.createHRW(CounterLocalServiceUtil.increment(HRW.class.getName()));
				 h.setTimestamp(ddd);
				 if(o.containsKey("Name")) h.setComune(o.get("Name").toString());
				 if(o.containsKey("HRI")) h.setHRI(Double.parseDouble(o.get("HRI").toString()));
				 if(o.containsKey("SSI")) h.setSSI(Double.parseDouble(o.get("SSI").toString()));
				 if(o.containsKey("SRI")) h.setSRI(Double.parseDouble(o.get("SRI").toString()));
				 if(o.containsKey("VMI")) h.setVMI(Double.parseDouble(o.get("VMI").toString()));
				 if(o.containsKey("VIL")) h.setVIL(Double.parseDouble(o.get("VIL").toString()));
				 if(o.containsKey("POH")) h.setPOH(Double.parseDouble(o.get("POH").toString()));
				 if(o.containsKey("ETM")) h.setETM(Double.parseDouble(o.get("ETM").toString()));
				 if(o.containsKey("TOP")) h.setTOP(Double.parseDouble(o.get("TOP").toString()));
				 if(o.containsKey("LGT")) h.setLGT(Double.parseDouble(o.get("LGT").toString()));
				 if(o.containsKey("Pers")) h.setPers(Double.parseDouble(o.get("Pers").toString()));
				 if(o.containsKey("SRT")) h.setSRT(Double.parseDouble(o.get("SRT").toString()));
				 if(o.containsKey("SRT_3")) h.setSRT_3(Double.parseDouble(o.get("SRT_3").toString()));
				 if(o.containsKey("SRT_6")) h.setSRT_6(Double.parseDouble(o.get("SRT_6").toString()));
				 if(o.containsKey("Vel")) h.setVel(Double.parseDouble(o.get("Vel").toString()));
				 if(o.containsKey("Dir")) h.setDir(Double.parseDouble(o.get("Dir").toString()));
				 HRWLocalServiceUtil.addHRW(h);
				 howmany++;
				 
			 } catch (Exception e) {
				 
			 }
		 }
		 
		m.put("valori", howmany);
		return m;
	}
}