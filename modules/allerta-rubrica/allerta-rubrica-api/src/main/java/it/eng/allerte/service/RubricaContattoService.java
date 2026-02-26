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

import it.eng.allerte.model.RubricaContatto;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

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
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaContattoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaContattoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the rubrica contatto remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RubricaContattoServiceUtil} if injection and service tracking are not available.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> addContacts(String data);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> deleteContacts(Long id, String data);

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
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

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService
	public Map<String, Object> updateContacts(Long id, String data);

}