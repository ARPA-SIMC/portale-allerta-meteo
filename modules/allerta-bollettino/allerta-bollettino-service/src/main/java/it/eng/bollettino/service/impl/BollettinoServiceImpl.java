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

package it.eng.bollettino.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import it.eng.bollettino.service.base.BollettinoServiceBaseImpl;

/**
 * The implementation of the bollettino remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>it.eng.bollettino.service.BollettinoService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoServiceBaseImpl
 */
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