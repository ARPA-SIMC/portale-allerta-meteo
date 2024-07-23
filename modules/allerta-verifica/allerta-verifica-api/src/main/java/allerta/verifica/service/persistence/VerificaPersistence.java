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

package allerta.verifica.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.exception.NoSuchVerificaException;
import allerta.verifica.model.Verifica;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the verifica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificaUtil
 * @generated
 */
@ProviderType
public interface VerificaPersistence extends BasePersistence<Verifica> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VerificaUtil} to access the verifica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Verifica> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the verificas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching verificas
	 */
	public java.util.List<Verifica> findByUuid(String uuid);

	/**
	 * Returns a range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	public java.util.List<Verifica> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	public java.util.List<Verifica> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verificas
	 */
	public java.util.List<Verifica> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	public Verifica[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Removes all the verificas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of verificas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching verificas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVerificaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByUUID_G(String uuid, long groupId)
		throws NoSuchVerificaException;

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the verifica where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the verifica that was removed
	 */
	public Verifica removeByUUID_G(String uuid, long groupId)
		throws NoSuchVerificaException;

	/**
	 * Returns the number of verificas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching verificas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching verificas
	 */
	public java.util.List<Verifica> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	public java.util.List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	public java.util.List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verificas
	 */
	public java.util.List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	public Verifica[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Removes all the verificas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching verificas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the verificas where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verificas
	 */
	public java.util.List<Verifica> findByDocumento(long documento);

	/**
	 * Returns a range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	public java.util.List<Verifica> findByDocumento(
		long documento, int start, int end);

	/**
	 * Returns an ordered range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	public java.util.List<Verifica> findByDocumento(
		long documento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verificas
	 */
	public java.util.List<Verifica> findByDocumento(
		long documento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByDocumento_First(
			long documento,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Returns the first verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByDocumento_First(
		long documento,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns the last verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	public Verifica findByDocumento_Last(
			long documento,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Returns the last verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public Verifica fetchByDocumento_Last(
		long documento,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	public Verifica[] findByDocumento_PrevAndNext(
			long id, long documento,
			com.liferay.portal.kernel.util.OrderByComparator<Verifica>
				orderByComparator)
		throws NoSuchVerificaException;

	/**
	 * Removes all the verificas where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	public void removeByDocumento(long documento);

	/**
	 * Returns the number of verificas where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verificas
	 */
	public int countByDocumento(long documento);

	/**
	 * Caches the verifica in the entity cache if it is enabled.
	 *
	 * @param verifica the verifica
	 */
	public void cacheResult(Verifica verifica);

	/**
	 * Caches the verificas in the entity cache if it is enabled.
	 *
	 * @param verificas the verificas
	 */
	public void cacheResult(java.util.List<Verifica> verificas);

	/**
	 * Creates a new verifica with the primary key. Does not add the verifica to the database.
	 *
	 * @param id the primary key for the new verifica
	 * @return the new verifica
	 */
	public Verifica create(long id);

	/**
	 * Removes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	public Verifica remove(long id) throws NoSuchVerificaException;

	public Verifica updateImpl(Verifica verifica);

	/**
	 * Returns the verifica with the primary key or throws a <code>NoSuchVerificaException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	public Verifica findByPrimaryKey(long id) throws NoSuchVerificaException;

	/**
	 * Returns the verifica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica, or <code>null</code> if a verifica with the primary key could not be found
	 */
	public Verifica fetchByPrimaryKey(long id);

	/**
	 * Returns all the verificas.
	 *
	 * @return the verificas
	 */
	public java.util.List<Verifica> findAll();

	/**
	 * Returns a range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of verificas
	 */
	public java.util.List<Verifica> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verificas
	 */
	public java.util.List<Verifica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of verificas
	 */
	public java.util.List<Verifica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Verifica>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the verificas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of verificas.
	 *
	 * @return the number of verificas
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}