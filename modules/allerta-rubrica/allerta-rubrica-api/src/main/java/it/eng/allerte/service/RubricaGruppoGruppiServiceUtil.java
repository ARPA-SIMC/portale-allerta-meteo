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
 * Provides the remote service utility for RubricaGruppoGruppi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoGruppiServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiService
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoGruppiServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<String, Object> addGroupMultiSubgroups(
		int id, String data) {

		return getService().addGroupMultiSubgroups(id, data);
	}

	public static java.util.Map<String, Object> addGroupMultiSupergroups(
		int id, String data) {

		return getService().addGroupMultiSupergroups(id, data);
	}

	public static java.util.Map<String, Object> addGroupSubgroups(
		int id, String data) {

		return getService().addGroupSubgroups(id, data);
	}

	public static java.util.Map<String, Object> deleteGroupMultiSubgroups(
		int id, String data) {

		return getService().deleteGroupMultiSubgroups(id, data);
	}

	public static java.util.Map<String, Object> deleteGroupMultiSupergroups(
		int id, String data) {

		return getService().deleteGroupMultiSupergroups(id, data);
	}

	public static java.util.Map<String, Object> deleteGroupSubgroups(
		int id, String data) {

		return getService().deleteGroupSubgroups(id, data);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
	 *
	 * @param idGroup
	 * @return
	 */
	public static java.util.List<it.eng.allerte.model.RubricaGruppo>
		getSubGroups(long idGroup) {

		return getService().getSubGroups(idGroup);
	}

	public static java.util.Map<String, Object> updateGroupSubgroups(
		int id, String data) {

		return getService().updateGroupSubgroups(id, data);
	}

	public static RubricaGruppoGruppiService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaGruppoGruppiService, RubricaGruppoGruppiService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaGruppoGruppiService.class);

		ServiceTracker<RubricaGruppoGruppiService, RubricaGruppoGruppiService>
			serviceTracker =
				new ServiceTracker
					<RubricaGruppoGruppiService, RubricaGruppoGruppiService>(
						bundle.getBundleContext(),
						RubricaGruppoGruppiService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}