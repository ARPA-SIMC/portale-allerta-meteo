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

package it.eng.allerter.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.service.AllertaValangheLocalServiceUtil;
import it.eng.allerter.service.base.AllertaServiceBaseImpl;

/**
 * The implementation of the allerta remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>it.eng.allerter.service.AllertaService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaServiceBaseImpl
 */
public class AllertaServiceImpl extends AllertaServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>it.eng.allerter.service.AllertaServiceUtil</code> to access the allerta
	 * remote service.
	 */
	

	private static String[] eventi = { "idraulica", "idrogeologica", "temporali", "vento", "temperature-estreme",
			"neve", "ghiaccio-pioggia-gela", "stato-mare", "mareggiate" };

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * it.eng.allerter.service.AllertaServiceUtil} to access the allerta remote
	 * service.
	 */

	public class AreaEventi implements Serializable {
		long colore = 0;
		List<Long> eventi = new ArrayList<Long>();
	}

	private ArrayList<Map<String, String>> getJsonAllerta(int giorni) {

		try {

			Map<Long, String> zone = new HashMap<Long, String>();
			Map<Long, String> zoneV = new HashMap<Long, String>();

			zone.put(10L, "A");
			zone.put(11L, "A1");
			zone.put(12L, "A2");
			zone.put(20L, "B");
			zone.put(21L, "B1");
			zone.put(22L, "B2");
			zone.put(30L, "C");
			zone.put(31L, "C1");
			zone.put(32L, "C2");
			zone.put(40L, "D");
			zone.put(41L, "D1");
			zone.put(42L, "D2");
			zone.put(43L, "D3");
			zone.put(50L, "E");
			zone.put(51L, "E1");
			zone.put(52L, "E2");
			zone.put(60L, "F");
			zone.put(61L, "F1");
			zone.put(62L, "F2");
			zone.put(63L, "F3");
			zone.put(70L, "G");
			zone.put(71L, "G1");
			zone.put(72L, "G2");
			zone.put(80L, "H");
			zone.put(81L, "H1");
			zone.put(82L, "H2");
			
			zoneV.put(10L, "V1");
			zoneV.put(20L, "V2");
			zoneV.put(30L, "V3");

			List<Object> aree = allertaFinder.getMacroareeAllerta(giorni);
			
			List<Object> areeValanghe = allertaValangheFinder.getMacroareeAllertaValanghe(giorni);

			ArrayList<Map<String, String>> out = new ArrayList<Map<String, String>>();

			if (aree!=null) {
				for (Object ae : aree) {
	
					Object ae2[] = (Object[]) ae;
	
					Long l = Long.parseLong(ae2[0].toString().replace(".0", ""));
					String s = ae2[1].toString();
	
					for (int k = 1; k <= eventi.length; k++)
						s = s.replace("" + k + ":", eventi[k - 1] + ":");
	
					s = s.replace(":1000", ":white");
					s = s.replace(":0", ":green");
					s = s.replace(":1", ":yellow");
					s = s.replace(":2", ":orange");
					s = s.replace(":3", ":red");
	
					Map<String, String> m = new HashMap<String, String>();
					m.put("area", zone.get(l));
					m.put("eventi", s);
	
					out.add(m);
	
					// if (index!=aree.size()-1) out+=", ";
	
					// index++;
				}
			}
			
			if (areeValanghe!=null) {
				for (Object ae : areeValanghe) {
	
					Object ae2[] = (Object[]) ae;
	
					Long l = Long.parseLong(ae2[0].toString().replace(".0", ""));
					String s = ae2[1].toString();
	
					
					s = s.replace("1:", "valanghe:");
	
					s = s.replace(":1000", ":white");
					s = s.replace(":0", ":green");
					s = s.replace(":1", ":yellow");
					s = s.replace(":2", ":orange");
					s = s.replace(":3", ":red");
	
					Map<String, String> m = new HashMap<String, String>();
					m.put("area", zoneV.get(l));
					m.put("eventi", s);
	
					out.add(m);
	
					// if (index!=aree.size()-1) out+=", ";
	
					// index++;
				}
			}
			// out +="]";

			return out;

		} catch (Exception e) {
			e.printStackTrace();

			try {
				
				e.printStackTrace();

			} catch (Exception ex2) {
				ex2.printStackTrace();
			}
		}

		return new ArrayList<Map<String, String>>();

	}

	private ArrayList<Map<String, String>> getJsonAllertaPrimes(int giorni) {

		try {

			Map<Long, String> zone = new HashMap<Long, String>();

			zone.put(10L, "A");
			zone.put(20L, "B");
			zone.put(30L, "C");
			zone.put(40L, "D");
			zone.put(50L, "E");
			zone.put(60L, "F");
			zone.put(70L, "G");
			zone.put(80L, "H");

			List<Object> aree = allertaFinder.getMacroareeAllertaPrimes(giorni);

			ArrayList<Map<String, String>> out = new ArrayList<Map<String, String>>();

			if (aree == null)
				return out;

			// String out = "[";
			// int index = 0;

			for (Object ae : aree) {

				Object ae2[] = (Object[]) ae;

				Long l = Long.parseLong(ae2[0].toString().replace(".0", ""));
				String s = ae2[1].toString();

				for (int k = 1; k <= eventi.length; k++)
					s = s.replace("" + k + ":", eventi[k - 1] + ":");

				s = s.replace(":1000", ":white");
				s = s.replace(":0", ":green");
				s = s.replace(":1", ":yellow");
				s = s.replace(":2", ":orange");
				s = s.replace(":3", ":red");

				Map<String, String> m = new HashMap<String, String>();
				m.put("area", zone.get(l));
				m.put("eventi", s);

				out.add(m);

				// if (index!=aree.size()-1) out+=", ";

				// index++;
			}

			// out +="]";

			return out;

		} catch (Exception e) {
			e.printStackTrace();

			try {
				
				e.printStackTrace();

			} catch (Exception ex2) {
				ex2.printStackTrace();
			}
		}

		return new ArrayList<Map<String, String>>();

	}
	
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public ArrayList<Map<String, String>> getStatoAllertaDays(int giorni) {
		return getJsonAllerta(giorni);
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public ArrayList<Map<String, String>> getStatoAllerta() {
		return getJsonAllerta(0);
	}

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public ArrayList<Map<String, String>> getStatoAllertaDomani() {

		return getJsonAllerta(1);
	}

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> getStatoAllertaPrimes() {
		ArrayList<Map<String, String>> x = getJsonAllertaPrimes(0);
		Map<String, Object> m = new HashMap<String, Object>();

		try {
			AllertaParametro ap = allertaParametroLocalService.getAllertaParametro("URL_PRIMES");
			if (ap != null)
				m.put("url", ap.getValore());
		} catch (Exception e) {
		}

		m.put("data", x);
		m.put("status", 1);

		return m;
	}

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> getStatoAllertaPrimesDomani() {
		ArrayList<Map<String, String>> x = getJsonAllertaPrimes(1);
		Map<String, Object> m = new HashMap<String, Object>();

		try {
			AllertaParametro ap = allertaParametroLocalService.getAllertaParametro("URL_PRIMES");
			if (ap != null)
				m.put("url", ap.getValore());
		} catch (Exception e) {
		}

		m.put("data", x);
		m.put("status", 1);

		return m;
	}

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> getInfoAllerta() {
		return allertaFinder.getInfoAllerta(0);
	}

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> getInfoAllertaDomani() {
		return allertaFinder.getInfoAllerta(1);
	}

	public long getIdApprovatore(long id) {
		return allertaFinder.getUtenteApprovatore(id);
	}


	
}