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
 * Provides the remote service utility for RubricaGruppo. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoService
 * @generated
 */
@ProviderType
public class RubricaGruppoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<String, Object> addGroup(String data) {
		return getService().addGroup(data);
	}

	public static java.util.Map<String, Object> deleteGroups(Long id) {
		return getService().deleteGroups(id);
	}

	public static java.util.Map<String, Object> deleteGroupsMulti(String data) {
		return getService().deleteGroupsMulti(data);
	}

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	public static it.eng.allerte.model.RubricaGruppo getGroupForOwnerByName(
		Long ownerId, String groupName) {

		return getService().getGroupForOwnerByName(ownerId, groupName);
	}

	public static java.util.Map<String, Object> getGroups() {
		return getService().getGroups();
	}

	public static java.util.Map<String, Object> getGroups(Long id) {
		return getService().getGroups(id);
	}

	public static java.util.Map<String, Object> getGroups(
		String name, Long categoria, int limit, int offset) {

		return getService().getGroups(name, categoria, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.Map<String, Object> updateGroups(
		Long id, String data) {

		return getService().updateGroups(id, data);
	}

	public static RubricaGruppoService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RubricaGruppoService, RubricaGruppoService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaGruppoService.class);

		ServiceTracker<RubricaGruppoService, RubricaGruppoService>
			serviceTracker =
				new ServiceTracker<RubricaGruppoService, RubricaGruppoService>(
					bundle.getBundleContext(), RubricaGruppoService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}