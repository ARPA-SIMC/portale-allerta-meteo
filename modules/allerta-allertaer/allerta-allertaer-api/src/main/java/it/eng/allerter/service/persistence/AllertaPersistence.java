/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchAllertaException;
import it.eng.allerter.model.Allerta;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the allerta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaUtil
 * @generated
 */
@ProviderType
public interface AllertaPersistence extends BasePersistence<Allerta> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllertaUtil} to access the allerta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the allertas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allertas
	 */
	public java.util.List<Allerta> findByUuid(String uuid);

	/**
	 * Returns a range of all the allertas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of matching allertas
	 */
	public java.util.List<Allerta> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allertas
	 */
	public java.util.List<Allerta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allertas
	 */
	public java.util.List<Allerta> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Returns the first allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns the allertas before and after the current allerta in the ordered set where uuid = &#63;.
	 *
	 * @param allertaId the primary key of the current allerta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	public Allerta[] findByUuid_PrevAndNext(
			long allertaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Removes all the allertas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of allertas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allertas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the allerta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaException;

	/**
	 * Returns the allerta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the allerta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the allerta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta that was removed
	 */
	public Allerta removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaException;

	/**
	 * Returns the number of allertas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allertas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allertas
	 */
	public java.util.List<Allerta> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of matching allertas
	 */
	public java.util.List<Allerta> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allertas
	 */
	public java.util.List<Allerta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allertas
	 */
	public java.util.List<Allerta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Returns the first allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns the allertas before and after the current allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaId the primary key of the current allerta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	public Allerta[] findByUuid_C_PrevAndNext(
			long allertaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Removes all the allertas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allertas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the allertas where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching allertas
	 */
	public java.util.List<Allerta> findByNumero(String numero);

	/**
	 * Returns a range of all the allertas where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of matching allertas
	 */
	public java.util.List<Allerta> findByNumero(
		String numero, int start, int end);

	/**
	 * Returns an ordered range of all the allertas where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allertas
	 */
	public java.util.List<Allerta> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allertas where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allertas
	 */
	public java.util.List<Allerta> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByNumero_First(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Returns the first allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByNumero_First(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns the last allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	public Allerta findByNumero_Last(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Returns the last allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	public Allerta fetchByNumero_Last(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns the allertas before and after the current allerta in the ordered set where numero = &#63;.
	 *
	 * @param allertaId the primary key of the current allerta
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	public Allerta[] findByNumero_PrevAndNext(
			long allertaId, String numero,
			com.liferay.portal.kernel.util.OrderByComparator<Allerta>
				orderByComparator)
		throws NoSuchAllertaException;

	/**
	 * Removes all the allertas where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	public void removeByNumero(String numero);

	/**
	 * Returns the number of allertas where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching allertas
	 */
	public int countByNumero(String numero);

	/**
	 * Caches the allerta in the entity cache if it is enabled.
	 *
	 * @param allerta the allerta
	 */
	public void cacheResult(Allerta allerta);

	/**
	 * Caches the allertas in the entity cache if it is enabled.
	 *
	 * @param allertas the allertas
	 */
	public void cacheResult(java.util.List<Allerta> allertas);

	/**
	 * Creates a new allerta with the primary key. Does not add the allerta to the database.
	 *
	 * @param allertaId the primary key for the new allerta
	 * @return the new allerta
	 */
	public Allerta create(long allertaId);

	/**
	 * Removes the allerta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta that was removed
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	public Allerta remove(long allertaId) throws NoSuchAllertaException;

	public Allerta updateImpl(Allerta allerta);

	/**
	 * Returns the allerta with the primary key or throws a <code>NoSuchAllertaException</code> if it could not be found.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	public Allerta findByPrimaryKey(long allertaId)
		throws NoSuchAllertaException;

	/**
	 * Returns the allerta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta, or <code>null</code> if a allerta with the primary key could not be found
	 */
	public Allerta fetchByPrimaryKey(long allertaId);

	/**
	 * Returns all the allertas.
	 *
	 * @return the allertas
	 */
	public java.util.List<Allerta> findAll();

	/**
	 * Returns a range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of allertas
	 */
	public java.util.List<Allerta> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allertas
	 */
	public java.util.List<Allerta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allertas
	 */
	public java.util.List<Allerta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allerta>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the allertas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allertas.
	 *
	 * @return the number of allertas
	 */
	public int countAll();

}