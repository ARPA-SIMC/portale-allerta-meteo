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

import it.eng.allerte.model.RubricaContatto;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service interface for RubricaContatto. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaContattoServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaContatto"
	},
	service = RubricaContattoService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaContattoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaContattoServiceUtil} to access the rubrica contatto remote service. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaContattoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> addContacts(String data);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteContacts(Long id, String data);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteContactsMulti(String data);

	/**
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 *
	 * @param idNominative
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RubricaContatto> getContactByNominative(long idNominative);

	/**
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 *
	 * @param idUserPortal
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RubricaContatto> getContactByNominativePortal(
		long idUserPortal);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> updateContacts(Long id, String data);

}