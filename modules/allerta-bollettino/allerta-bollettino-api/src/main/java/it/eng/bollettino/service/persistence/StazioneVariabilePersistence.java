/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchStazioneVariabileException;
import it.eng.bollettino.model.StazioneVariabile;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the stazione variabile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see StazioneVariabileUtil
 * @generated
 */
@ProviderType
public interface StazioneVariabilePersistence
	extends BasePersistence<StazioneVariabile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StazioneVariabileUtil} to access the stazione variabile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the stazione variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByUuid(String uuid);

	/**
	 * Returns a range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public StazioneVariabile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the first stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public StazioneVariabile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns the last stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public StazioneVariabile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the last stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public StazioneVariabile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public StazioneVariabile[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Removes all the stazione variabiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of stazione variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stazione variabiles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the stazione variabiles where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @return the matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByStazione(String idStazione);

	/**
	 * Returns a range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end);

	/**
	 * Returns an ordered range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public StazioneVariabile findByStazione_First(
			String idStazione,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the first stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public StazioneVariabile fetchByStazione_First(
		String idStazione,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns the last stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public StazioneVariabile findByStazione_Last(
			String idStazione,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the last stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public StazioneVariabile fetchByStazione_Last(
		String idStazione,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public StazioneVariabile[] findByStazione_PrevAndNext(
			long id, String idStazione,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Removes all the stazione variabiles where idStazione = &#63; from the database.
	 *
	 * @param idStazione the id stazione
	 */
	public void removeByStazione(String idStazione);

	/**
	 * Returns the number of stazione variabiles where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @return the number of matching stazione variabiles
	 */
	public int countByStazione(String idStazione);

	/**
	 * Returns all the stazione variabiles where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @return the matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByVariabile(
		String idVariabile);

	/**
	 * Returns a range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end);

	/**
	 * Returns an ordered range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public StazioneVariabile findByVariabile_First(
			String idVariabile,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the first stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public StazioneVariabile fetchByVariabile_First(
		String idVariabile,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns the last stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public StazioneVariabile findByVariabile_Last(
			String idVariabile,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the last stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public StazioneVariabile fetchByVariabile_Last(
		String idVariabile,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public StazioneVariabile[] findByVariabile_PrevAndNext(
			long id, String idVariabile,
			com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
				orderByComparator)
		throws NoSuchStazioneVariabileException;

	/**
	 * Removes all the stazione variabiles where idVariabile = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 */
	public void removeByVariabile(String idVariabile);

	/**
	 * Returns the number of stazione variabiles where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @return the number of matching stazione variabiles
	 */
	public int countByVariabile(String idVariabile);

	/**
	 * Caches the stazione variabile in the entity cache if it is enabled.
	 *
	 * @param stazioneVariabile the stazione variabile
	 */
	public void cacheResult(StazioneVariabile stazioneVariabile);

	/**
	 * Caches the stazione variabiles in the entity cache if it is enabled.
	 *
	 * @param stazioneVariabiles the stazione variabiles
	 */
	public void cacheResult(
		java.util.List<StazioneVariabile> stazioneVariabiles);

	/**
	 * Creates a new stazione variabile with the primary key. Does not add the stazione variabile to the database.
	 *
	 * @param id the primary key for the new stazione variabile
	 * @return the new stazione variabile
	 */
	public StazioneVariabile create(long id);

	/**
	 * Removes the stazione variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile that was removed
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public StazioneVariabile remove(long id)
		throws NoSuchStazioneVariabileException;

	public StazioneVariabile updateImpl(StazioneVariabile stazioneVariabile);

	/**
	 * Returns the stazione variabile with the primary key or throws a <code>NoSuchStazioneVariabileException</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public StazioneVariabile findByPrimaryKey(long id)
		throws NoSuchStazioneVariabileException;

	/**
	 * Returns the stazione variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile, or <code>null</code> if a stazione variabile with the primary key could not be found
	 */
	public StazioneVariabile fetchByPrimaryKey(long id);

	/**
	 * Returns all the stazione variabiles.
	 *
	 * @return the stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findAll();

	/**
	 * Returns a range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stazione variabiles
	 */
	public java.util.List<StazioneVariabile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StazioneVariabile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the stazione variabiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of stazione variabiles.
	 *
	 * @return the number of stazione variabiles
	 */
	public int countAll();

}