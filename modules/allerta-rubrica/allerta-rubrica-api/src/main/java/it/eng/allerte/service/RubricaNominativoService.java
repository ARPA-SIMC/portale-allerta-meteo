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

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

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
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaNominativoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaNominativoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the rubrica nominativo remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RubricaNominativoServiceUtil} if injection and service tracking are not available.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> addNominativesGroupsMulti(Long id, String data);

	public Map<String, Object> deleteNominatives(Long id);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
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