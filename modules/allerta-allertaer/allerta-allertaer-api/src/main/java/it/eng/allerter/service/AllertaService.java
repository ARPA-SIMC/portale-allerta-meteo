/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.ArrayList;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Allerta. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author GFAVINI
 * @see AllertaServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AllertaService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the allerta remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AllertaServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getIdApprovatore(long id);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getInfoAllerta();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getInfoAllertaDomani();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Map<String, String>> getStatoAllerta();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Map<String, String>> getStatoAllertaDays(int giorni);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Map<String, String>> getStatoAllertaDomani();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getStatoAllertaPrimes();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getStatoAllertaPrimesDomani();

}