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

import it.eng.allerte.model.RubricaNominativo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides the remote service interface for RubricaGruppoNominativi. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaGruppoNominativi"
	},
	service = RubricaGruppoNominativiService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaGruppoNominativiService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaGruppoNominativiServiceUtil} to access the rubrica gruppo nominativi remote service. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoNominativiServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> addGroupNominatives(int id, String data);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> addGroupNominativesMulti(int id, String data);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteGroupNominatives(int id, String data);

	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> deleteGroupNominativesMulti(int id, String data);

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Set<RubricaNominativo> getNominativeForGroup(
		Long ownerId, Long groupId);

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RubricaNominativo> getNominativeForGroupPortal(Long ownerId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Map<String, Object> nominativeGroupRole(String data);

}