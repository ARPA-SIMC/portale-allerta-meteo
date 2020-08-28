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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for RubricaContatto. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaContattoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaContattoService
 * @generated
 */
@ProviderType
public class RubricaContattoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaContattoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<String, Object> addContacts(String data) {
		return getService().addContacts(data);
	}

	public static java.util.Map<String, Object> deleteContacts(
		Long id, String data) {

		return getService().deleteContacts(id, data);
	}

	public static java.util.Map<String, Object> deleteContactsMulti(
		String data) {

		return getService().deleteContactsMulti(data);
	}

	/**
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 *
	 * @param idNominative
	 * @return
	 */
	public static java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominative(long idNominative) {

		return getService().getContactByNominative(idNominative);
	}

	/**
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 *
	 * @param idUserPortal
	 * @return
	 */
	public static java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominativePortal(long idUserPortal) {

		return getService().getContactByNominativePortal(idUserPortal);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.Map<String, Object> updateContacts(
		Long id, String data) {

		return getService().updateContacts(id, data);
	}

	public static RubricaContattoService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaContattoService, RubricaContattoService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaContattoService.class);

		ServiceTracker<RubricaContattoService, RubricaContattoService>
			serviceTracker =
				new ServiceTracker
					<RubricaContattoService, RubricaContattoService>(
						bundle.getBundleContext(), RubricaContattoService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}