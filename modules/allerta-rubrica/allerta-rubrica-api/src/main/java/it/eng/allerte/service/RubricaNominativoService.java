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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Map;

/**
 * Provides the remote service interface for RubricaNominativo. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaNominativoServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaNominativo"
	},
	service = RubricaNominativoService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaNominativoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaNominativoServiceUtil} to access the rubrica nominativo remote service. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaNominativoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> addNominativesGroupsMulti(Long id, String data);

	public Map<String, Object> deleteNominatives(Long id);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteNominativesGroupsMulti(
		Long id, String data);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getNominatives(Long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getNominatives(
		String name, int limit, int offset);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Map<String, Object> importNominatives();

	public Map<String, Object> insertNominatives(String data);

	public Map<String, Object> nominativesMulti(Long id);

	public Map<String, Object> nominativesMulti(String data);

	public Map<String, Object> updateNominatives(Long id, String data);

}