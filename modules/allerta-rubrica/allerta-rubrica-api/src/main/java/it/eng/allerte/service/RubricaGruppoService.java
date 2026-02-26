/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import it.eng.allerte.model.RubricaGruppo;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

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
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaGruppoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the rubrica gruppo remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RubricaGruppoServiceUtil} if injection and service tracking are not available.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> addGroup(String data);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> deleteGroups(Long id);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> deleteGroupsMulti(String data);

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RubricaGruppo getGroupForOwnerByName(Long ownerId, String groupName);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getGroups();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getGroups(Long id);

	@AccessControlled(guestAccessEnabled = false)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getGroups(
		String name, Long categoria, int limit, int offset);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> updateGroups(Long id, String data);

}