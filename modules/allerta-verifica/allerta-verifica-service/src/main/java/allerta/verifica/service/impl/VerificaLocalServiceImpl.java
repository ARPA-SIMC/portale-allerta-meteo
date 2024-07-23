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

package allerta.verifica.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import java.util.Date;

import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.VerificaDatoLocalServiceUtil;
import allerta.verifica.service.base.VerificaLocalServiceBaseImpl;

/**
 * The implementation of the verifica local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>allerta.verifica.service.VerificaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificaLocalServiceBaseImpl
 */
public class VerificaLocalServiceImpl extends VerificaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>allerta.verifica.service.VerificaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>allerta.verifica.service.VerificaLocalServiceUtil</code>.
	 */
	
	public VerificaDato insertVerificaDato(long doc,Date giorno,String zona, Long evento, String nomeDato, Integer prog, String datoCalcolato) {
		VerificaDato v = VerificaDatoLocalServiceUtil.createVerificaDato(CounterLocalServiceUtil.increment(VerificaDato.class.getName()));
		v.setDocumento(doc);
		v.setGiorno(giorno);
		v.setZona(zona);
		v.setEvento(evento!=null?evento:0);
		v.setNomeDato(nomeDato);
		v.setProgressivo(prog);
		v.setDatoCalcolato(datoCalcolato);
		v.setDatoInserito(datoCalcolato);
		VerificaDatoLocalServiceUtil.addVerificaDato(v);
		
		return v;
	}
}