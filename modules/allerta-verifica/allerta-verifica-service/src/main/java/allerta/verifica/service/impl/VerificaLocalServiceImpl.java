/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import java.util.Date;

import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.VerificaDatoLocalServiceUtil;
import allerta.verifica.service.base.VerificaLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=allerta.verifica.model.Verifica",
	service = AopService.class
)
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