/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchRegolaAllarmeException;
import it.eng.bollettino.model.RegolaAllarme;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the regola allarme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeUtil
 * @generated
 */
@ProviderType
public interface RegolaAllarmePersistence
	extends BasePersistence<RegolaAllarme> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegolaAllarmeUtil} to access the regola allarme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByUuid(String uuid);

	/**
	 * Returns a range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public RegolaAllarme findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
				orderByComparator)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public RegolaAllarme fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public RegolaAllarme findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
				orderByComparator)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public RegolaAllarme fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public RegolaAllarme[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
				orderByComparator)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Removes all the regola allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarmes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByAttivo(boolean attivo);

	/**
	 * Returns a range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	public java.util.List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public RegolaAllarme findByAttivo_First(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
				orderByComparator)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public RegolaAllarme fetchByAttivo_First(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public RegolaAllarme findByAttivo_Last(
			boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
				orderByComparator)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public RegolaAllarme fetchByAttivo_Last(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public RegolaAllarme[] findByAttivo_PrevAndNext(
			long id, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
				orderByComparator)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Removes all the regola allarmes where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public void removeByAttivo(boolean attivo);

	/**
	 * Returns the number of regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching regola allarmes
	 */
	public int countByAttivo(boolean attivo);

	/**
	 * Caches the regola allarme in the entity cache if it is enabled.
	 *
	 * @param regolaAllarme the regola allarme
	 */
	public void cacheResult(RegolaAllarme regolaAllarme);

	/**
	 * Caches the regola allarmes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmes the regola allarmes
	 */
	public void cacheResult(java.util.List<RegolaAllarme> regolaAllarmes);

	/**
	 * Creates a new regola allarme with the primary key. Does not add the regola allarme to the database.
	 *
	 * @param id the primary key for the new regola allarme
	 * @return the new regola allarme
	 */
	public RegolaAllarme create(long id);

	/**
	 * Removes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public RegolaAllarme remove(long id) throws NoSuchRegolaAllarmeException;

	public RegolaAllarme updateImpl(RegolaAllarme regolaAllarme);

	/**
	 * Returns the regola allarme with the primary key or throws a <code>NoSuchRegolaAllarmeException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public RegolaAllarme findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeException;

	/**
	 * Returns the regola allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme, or <code>null</code> if a regola allarme with the primary key could not be found
	 */
	public RegolaAllarme fetchByPrimaryKey(long id);

	/**
	 * Returns all the regola allarmes.
	 *
	 * @return the regola allarmes
	 */
	public java.util.List<RegolaAllarme> findAll();

	/**
	 * Returns a range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of regola allarmes
	 */
	public java.util.List<RegolaAllarme> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarmes
	 */
	public java.util.List<RegolaAllarme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of regola allarmes
	 */
	public java.util.List<RegolaAllarme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the regola allarmes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of regola allarmes.
	 *
	 * @return the number of regola allarmes
	 */
	public int countAll();

}