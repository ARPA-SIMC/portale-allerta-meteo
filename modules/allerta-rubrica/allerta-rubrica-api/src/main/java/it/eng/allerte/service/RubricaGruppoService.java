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

import it.eng.allerte.model.RubricaGruppo;

import java.util.Map;

/**
 * Provides the remote service interface for RubricaGruppo. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaGruppo"
	},
	service = RubricaGruppoService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaGruppoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaGruppoServiceUtil} to access the rubrica gruppo remote service. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> addGroup(String data);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteGroups(Long id);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteGroupsMulti(String data);

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RubricaGruppo getGroupForOwnerByName(Long ownerId, String groupName);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getGroups();

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getGroups(Long id);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = false)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getGroups(
		String name, Long categoria, int limit, int offset);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> updateGroups(Long id, String data);

}