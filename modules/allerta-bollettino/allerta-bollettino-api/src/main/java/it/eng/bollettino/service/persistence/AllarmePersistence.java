/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchAllarmeException;
import it.eng.bollettino.model.Allarme;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the allarme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllarmeUtil
 * @generated
 */
@ProviderType
public interface AllarmePersistence extends BasePersistence<Allarme> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllarmeUtil} to access the allarme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allarmes
	 */
	public java.util.List<Allarme> findByUuid(String uuid);

	/**
	 * Returns a range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	public java.util.List<Allarme> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	public java.util.List<Allarme> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	public java.util.List<Allarme> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where uuid = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public Allarme[] findByUuid_PrevAndNext(
			long allarmeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Removes all the allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allarmes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllarmeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByUUID_G(String uuid, long groupId)
		throws NoSuchAllarmeException;

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the allarme where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allarme that was removed
	 */
	public Allarme removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllarmeException;

	/**
	 * Returns the number of allarmes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allarmes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allarmes
	 */
	public java.util.List<Allarme> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	public java.util.List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	public java.util.List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	public java.util.List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public Allarme[] findByUuid_C_PrevAndNext(
			long allarmeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Removes all the allarmes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allarmes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the allarmes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching allarmes
	 */
	public java.util.List<Allarme> findByRegola(long idRegola);

	/**
	 * Returns a range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	public java.util.List<Allarme> findByRegola(
		long idRegola, int start, int end);

	/**
	 * Returns an ordered range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	public java.util.List<Allarme> findByRegola(
		long idRegola, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	public java.util.List<Allarme> findByRegola(
		long idRegola, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByRegola_First(
			long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Returns the first allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByRegola_First(
		long idRegola,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns the last allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public Allarme findByRegola_Last(
			long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Returns the last allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public Allarme fetchByRegola_Last(
		long idRegola,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public Allarme[] findByRegola_PrevAndNext(
			long allarmeId, long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator<Allarme>
				orderByComparator)
		throws NoSuchAllarmeException;

	/**
	 * Removes all the allarmes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	public void removeByRegola(long idRegola);

	/**
	 * Returns the number of allarmes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching allarmes
	 */
	public int countByRegola(long idRegola);

	/**
	 * Caches the allarme in the entity cache if it is enabled.
	 *
	 * @param allarme the allarme
	 */
	public void cacheResult(Allarme allarme);

	/**
	 * Caches the allarmes in the entity cache if it is enabled.
	 *
	 * @param allarmes the allarmes
	 */
	public void cacheResult(java.util.List<Allarme> allarmes);

	/**
	 * Creates a new allarme with the primary key. Does not add the allarme to the database.
	 *
	 * @param allarmeId the primary key for the new allarme
	 * @return the new allarme
	 */
	public Allarme create(long allarmeId);

	/**
	 * Removes the allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme that was removed
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public Allarme remove(long allarmeId) throws NoSuchAllarmeException;

	public Allarme updateImpl(Allarme allarme);

	/**
	 * Returns the allarme with the primary key or throws a <code>NoSuchAllarmeException</code> if it could not be found.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public Allarme findByPrimaryKey(long allarmeId)
		throws NoSuchAllarmeException;

	/**
	 * Returns the allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme, or <code>null</code> if a allarme with the primary key could not be found
	 */
	public Allarme fetchByPrimaryKey(long allarmeId);

	/**
	 * Returns all the allarmes.
	 *
	 * @return the allarmes
	 */
	public java.util.List<Allarme> findAll();

	/**
	 * Returns a range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of allarmes
	 */
	public java.util.List<Allarme> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allarmes
	 */
	public java.util.List<Allarme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allarmes
	 */
	public java.util.List<Allarme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Allarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the allarmes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allarmes.
	 *
	 * @return the number of allarmes
	 */
	public int countAll();

}