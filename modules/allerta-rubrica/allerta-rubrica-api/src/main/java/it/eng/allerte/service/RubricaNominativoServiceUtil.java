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
 * Provides the remote service utility for RubricaNominativo. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaNominativoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaNominativoService
 * @generated
 */
@ProviderType
public class RubricaNominativoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaNominativoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<String, Object> addNominativesGroupsMulti(
		Long id, String data) {

		return getService().addNominativesGroupsMulti(id, data);
	}

	public static java.util.Map<String, Object> deleteNominatives(Long id) {
		return getService().deleteNominatives(id);
	}

	public static java.util.Map<String, Object> deleteNominativesGroupsMulti(
		Long id, String data) {

		return getService().deleteNominativesGroupsMulti(id, data);
	}

	public static java.util.Map<String, Object> getNominatives(Long id) {
		return getService().getNominatives(id);
	}

	public static java.util.Map<String, Object> getNominatives(
		String name, int limit, int offset) {

		return getService().getNominatives(name, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.Map<String, Object> importNominatives() {
		return getService().importNominatives();
	}

	public static java.util.Map<String, Object> insertNominatives(String data) {
		return getService().insertNominatives(data);
	}

	public static java.util.Map<String, Object> nominativesMulti(Long id) {
		return getService().nominativesMulti(id);
	}

	public static java.util.Map<String, Object> nominativesMulti(String data) {
		return getService().nominativesMulti(data);
	}

	public static java.util.Map<String, Object> updateNominatives(
		Long id, String data) {

		return getService().updateNominatives(id, data);
	}

	public static RubricaNominativoService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaNominativoService, RubricaNominativoService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaNominativoService.class);

		ServiceTracker<RubricaNominativoService, RubricaNominativoService>
			serviceTracker =
				new ServiceTracker
					<RubricaNominativoService, RubricaNominativoService>(
						bundle.getBundleContext(),
						RubricaNominativoService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}