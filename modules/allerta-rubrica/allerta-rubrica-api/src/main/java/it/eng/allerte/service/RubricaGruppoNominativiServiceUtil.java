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
 * Provides the remote service utility for RubricaGruppoNominativi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoNominativiServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiService
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoNominativiServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<String, Object> addGroupNominatives(
		int id, String data) {

		return getService().addGroupNominatives(id, data);
	}

	public static java.util.Map<String, Object> addGroupNominativesMulti(
		int id, String data) {

		return getService().addGroupNominativesMulti(id, data);
	}

	public static java.util.Map<String, Object> deleteGroupNominatives(
		int id, String data) {

		return getService().deleteGroupNominatives(id, data);
	}

	public static java.util.Map<String, Object> deleteGroupNominativesMulti(
		int id, String data) {

		return getService().deleteGroupNominativesMulti(id, data);
	}

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	public static java.util.Set<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroup(Long ownerId, Long groupId) {

		return getService().getNominativeForGroup(ownerId, groupId);
	}

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	public static java.util.List<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroupPortal(Long ownerId) {

		return getService().getNominativeForGroupPortal(ownerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.Map<String, Object> nominativeGroupRole(
		String data) {

		return getService().nominativeGroupRole(data);
	}

	public static RubricaGruppoNominativiService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaGruppoNominativiService, RubricaGruppoNominativiService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaGruppoNominativiService.class);

		ServiceTracker
			<RubricaGruppoNominativiService, RubricaGruppoNominativiService>
				serviceTracker =
					new ServiceTracker
						<RubricaGruppoNominativiService,
						 RubricaGruppoNominativiService>(
							 bundle.getBundleContext(),
							 RubricaGruppoNominativiService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}