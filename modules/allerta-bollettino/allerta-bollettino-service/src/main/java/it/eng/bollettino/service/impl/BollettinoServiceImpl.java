/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import it.eng.bollettino.service.base.BollettinoServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = {
		"json.web.service.context.name=bollettino",
		"json.web.service.context.path=Bollettino"
	},
	service = AopService.class
)
public class BollettinoServiceImpl extends BollettinoServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>it.eng.bollettino.service.BollettinoServiceUtil</code> to access the
	 * bollettino remote service.
	 */

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public ArrayList<Map<String, String>> getAllarmi() {

		List<Object> o = bollettinoFinder.getComuniAllarme();

		ArrayList<Map<String, String>> out = new ArrayList<Map<String, String>>();

		if (o == null)
			return out;

		for (Object o2 : o) {

			Object[] o3 = (Object[]) o2;
			if (o3 == null || o3.length < 2)
				continue;

			Map<String, String> m = new HashMap<String, String>();

			String colore = o3[0].toString();

			if (colore.equals("1"))
				m.put("color", "yellow");
			if (colore.equals("2"))
				m.put("color", "orange");
			if (colore.equals("3"))
				m.put("color", "red");

			m.put("comune", o3[1].toString());

			out.add(m);

		}

		return out;

	}

}