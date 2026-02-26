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

import it.eng.allerte.model.RubricaNominativo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

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
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaGruppoNominativiService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoNominativiServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the rubrica gruppo nominativi remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RubricaGruppoNominativiServiceUtil} if injection and service tracking are not available.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> addGroupNominatives(int id, String data);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> addGroupNominativesMulti(int id, String data);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> deleteGroupNominatives(int id, String data);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
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