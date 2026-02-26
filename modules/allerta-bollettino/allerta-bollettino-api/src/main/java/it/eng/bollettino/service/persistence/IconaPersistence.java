/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchIconaException;
import it.eng.bollettino.model.Icona;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the icona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see IconaUtil
 * @generated
 */
@ProviderType
public interface IconaPersistence extends BasePersistence<Icona> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IconaUtil} to access the icona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching iconas
	 */
	public java.util.List<Icona> findByUuid(String uuid);

	/**
	 * Returns a range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of matching iconas
	 */
	public java.util.List<Icona> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching iconas
	 */
	public java.util.List<Icona> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Icona>
			orderByComparator);

	/**
	 * Returns an ordered range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching iconas
	 */
	public java.util.List<Icona> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Icona>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icona
	 * @throws NoSuchIconaException if a matching icona could not be found
	 */
	public Icona findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Icona>
				orderByComparator)
		throws NoSuchIconaException;

	/**
	 * Returns the first icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icona, or <code>null</code> if a matching icona could not be found
	 */
	public Icona fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Icona>
			orderByComparator);

	/**
	 * Returns the last icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icona
	 * @throws NoSuchIconaException if a matching icona could not be found
	 */
	public Icona findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Icona>
				orderByComparator)
		throws NoSuchIconaException;

	/**
	 * Returns the last icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icona, or <code>null</code> if a matching icona could not be found
	 */
	public Icona fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Icona>
			orderByComparator);

	/**
	 * Returns the iconas before and after the current icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	public Icona[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Icona>
				orderByComparator)
		throws NoSuchIconaException;

	/**
	 * Removes all the iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching iconas
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the icona in the entity cache if it is enabled.
	 *
	 * @param icona the icona
	 */
	public void cacheResult(Icona icona);

	/**
	 * Caches the iconas in the entity cache if it is enabled.
	 *
	 * @param iconas the iconas
	 */
	public void cacheResult(java.util.List<Icona> iconas);

	/**
	 * Creates a new icona with the primary key. Does not add the icona to the database.
	 *
	 * @param id the primary key for the new icona
	 * @return the new icona
	 */
	public Icona create(long id);

	/**
	 * Removes the icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the icona
	 * @return the icona that was removed
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	public Icona remove(long id) throws NoSuchIconaException;

	public Icona updateImpl(Icona icona);

	/**
	 * Returns the icona with the primary key or throws a <code>NoSuchIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the icona
	 * @return the icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	public Icona findByPrimaryKey(long id) throws NoSuchIconaException;

	/**
	 * Returns the icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the icona
	 * @return the icona, or <code>null</code> if a icona with the primary key could not be found
	 */
	public Icona fetchByPrimaryKey(long id);

	/**
	 * Returns all the iconas.
	 *
	 * @return the iconas
	 */
	public java.util.List<Icona> findAll();

	/**
	 * Returns a range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of iconas
	 */
	public java.util.List<Icona> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of iconas
	 */
	public java.util.List<Icona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Icona>
			orderByComparator);

	/**
	 * Returns an ordered range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of iconas
	 */
	public java.util.List<Icona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Icona>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the iconas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of iconas.
	 *
	 * @return the number of iconas
	 */
	public int countAll();

}