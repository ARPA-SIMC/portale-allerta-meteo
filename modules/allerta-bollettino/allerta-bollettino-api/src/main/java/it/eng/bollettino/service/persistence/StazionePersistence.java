/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchStazioneException;
import it.eng.bollettino.model.Stazione;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the stazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see StazioneUtil
 * @generated
 */
@ProviderType
public interface StazionePersistence extends BasePersistence<Stazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StazioneUtil} to access the stazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the staziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching staziones
	 */
	public java.util.List<Stazione> findByUuid(String uuid);

	/**
	 * Returns a range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public java.util.List<Stazione> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the first stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the last stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the last stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione[] findByUuid_PrevAndNext(
			String id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Removes all the staziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of staziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching staziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the staziones where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching staziones
	 */
	public java.util.List<Stazione> findByName(String name);

	/**
	 * Returns a range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public java.util.List<Stazione> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the first stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the last stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the last stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where name = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione[] findByName_PrevAndNext(
			String id, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Removes all the staziones where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of staziones where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching staziones
	 */
	public int countByName(String name);

	/**
	 * Returns all the staziones where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @return the matching staziones
	 */
	public java.util.List<Stazione> findByBacino(String idBasin);

	/**
	 * Returns a range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public java.util.List<Stazione> findByBacino(
		String idBasin, int start, int end);

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByBacino(
		String idBasin, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByBacino(
		String idBasin, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByBacino_First(
			String idBasin,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByBacino_First(
		String idBasin,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByBacino_Last(
			String idBasin,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByBacino_Last(
		String idBasin,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione[] findByBacino_PrevAndNext(
			String id, String idBasin,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Removes all the staziones where idBasin = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 */
	public void removeByBacino(String idBasin);

	/**
	 * Returns the number of staziones where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @return the number of matching staziones
	 */
	public int countByBacino(String idBasin);

	/**
	 * Returns all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @return the matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo);

	/**
	 * Returns a range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end);

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByBacinoAttivo_First(
			String idBasin, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByBacinoAttivo_First(
		String idBasin, boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByBacinoAttivo_Last(
			String idBasin, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByBacinoAttivo_Last(
		String idBasin, boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione[] findByBacinoAttivo_PrevAndNext(
			String id, String idBasin, boolean attivo,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Removes all the staziones where idBasin = &#63; and attivo = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 */
	public void removeByBacinoAttivo(String idBasin, boolean attivo);

	/**
	 * Returns the number of staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @return the number of matching staziones
	 */
	public int countByBacinoAttivo(String idBasin, boolean attivo);

	/**
	 * Returns all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @return the matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso);

	/**
	 * Returns a range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end);

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public java.util.List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByBacinoAttivoIncluso_First(
			String idBasin, boolean attivo, boolean incluso,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByBacinoAttivoIncluso_First(
		String idBasin, boolean attivo, boolean incluso,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public Stazione findByBacinoAttivoIncluso_Last(
			String idBasin, boolean attivo, boolean incluso,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public Stazione fetchByBacinoAttivoIncluso_Last(
		String idBasin, boolean attivo, boolean incluso,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione[] findByBacinoAttivoIncluso_PrevAndNext(
			String id, String idBasin, boolean attivo, boolean incluso,
			com.liferay.portal.kernel.util.OrderByComparator<Stazione>
				orderByComparator)
		throws NoSuchStazioneException;

	/**
	 * Removes all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 */
	public void removeByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso);

	/**
	 * Returns the number of staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @return the number of matching staziones
	 */
	public int countByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso);

	/**
	 * Caches the stazione in the entity cache if it is enabled.
	 *
	 * @param stazione the stazione
	 */
	public void cacheResult(Stazione stazione);

	/**
	 * Caches the staziones in the entity cache if it is enabled.
	 *
	 * @param staziones the staziones
	 */
	public void cacheResult(java.util.List<Stazione> staziones);

	/**
	 * Creates a new stazione with the primary key. Does not add the stazione to the database.
	 *
	 * @param id the primary key for the new stazione
	 * @return the new stazione
	 */
	public Stazione create(String id);

	/**
	 * Removes the stazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione that was removed
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione remove(String id) throws NoSuchStazioneException;

	public Stazione updateImpl(Stazione stazione);

	/**
	 * Returns the stazione with the primary key or throws a <code>NoSuchStazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public Stazione findByPrimaryKey(String id) throws NoSuchStazioneException;

	/**
	 * Returns the stazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione, or <code>null</code> if a stazione with the primary key could not be found
	 */
	public Stazione fetchByPrimaryKey(String id);

	/**
	 * Returns all the staziones.
	 *
	 * @return the staziones
	 */
	public java.util.List<Stazione> findAll();

	/**
	 * Returns a range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of staziones
	 */
	public java.util.List<Stazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staziones
	 */
	public java.util.List<Stazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staziones
	 */
	public java.util.List<Stazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staziones.
	 *
	 * @return the number of staziones
	 */
	public int countAll();

}