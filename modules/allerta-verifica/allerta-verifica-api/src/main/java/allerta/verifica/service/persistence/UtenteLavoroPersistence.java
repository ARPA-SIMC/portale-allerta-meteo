/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence;

import allerta.verifica.exception.NoSuchUtenteLavoroException;
import allerta.verifica.model.UtenteLavoro;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the utente lavoro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoroUtil
 * @generated
 */
@ProviderType
public interface UtenteLavoroPersistence extends BasePersistence<UtenteLavoro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UtenteLavoroUtil} to access the utente lavoro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching utente lavoros
	 */
	public java.util.List<UtenteLavoro> findByDocumento(long documento);

	/**
	 * Returns a range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of matching utente lavoros
	 */
	public java.util.List<UtenteLavoro> findByDocumento(
		long documento, int start, int end);

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente lavoros
	 */
	public java.util.List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente lavoros
	 */
	public java.util.List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	public UtenteLavoro findByDocumento_First(
			long documento,
			com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
				orderByComparator)
		throws NoSuchUtenteLavoroException;

	/**
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	public UtenteLavoro fetchByDocumento_First(
		long documento,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
			orderByComparator);

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	public UtenteLavoro findByDocumento_Last(
			long documento,
			com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
				orderByComparator)
		throws NoSuchUtenteLavoroException;

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	public UtenteLavoro fetchByDocumento_Last(
		long documento,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
			orderByComparator);

	/**
	 * Returns the utente lavoros before and after the current utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current utente lavoro
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	public UtenteLavoro[] findByDocumento_PrevAndNext(
			long id, long documento,
			com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
				orderByComparator)
		throws NoSuchUtenteLavoroException;

	/**
	 * Removes all the utente lavoros where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	public void removeByDocumento(long documento);

	/**
	 * Returns the number of utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching utente lavoros
	 */
	public int countByDocumento(long documento);

	/**
	 * Caches the utente lavoro in the entity cache if it is enabled.
	 *
	 * @param utenteLavoro the utente lavoro
	 */
	public void cacheResult(UtenteLavoro utenteLavoro);

	/**
	 * Caches the utente lavoros in the entity cache if it is enabled.
	 *
	 * @param utenteLavoros the utente lavoros
	 */
	public void cacheResult(java.util.List<UtenteLavoro> utenteLavoros);

	/**
	 * Creates a new utente lavoro with the primary key. Does not add the utente lavoro to the database.
	 *
	 * @param id the primary key for the new utente lavoro
	 * @return the new utente lavoro
	 */
	public UtenteLavoro create(long id);

	/**
	 * Removes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	public UtenteLavoro remove(long id) throws NoSuchUtenteLavoroException;

	public UtenteLavoro updateImpl(UtenteLavoro utenteLavoro);

	/**
	 * Returns the utente lavoro with the primary key or throws a <code>NoSuchUtenteLavoroException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	public UtenteLavoro findByPrimaryKey(long id)
		throws NoSuchUtenteLavoroException;

	/**
	 * Returns the utente lavoro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro, or <code>null</code> if a utente lavoro with the primary key could not be found
	 */
	public UtenteLavoro fetchByPrimaryKey(long id);

	/**
	 * Returns all the utente lavoros.
	 *
	 * @return the utente lavoros
	 */
	public java.util.List<UtenteLavoro> findAll();

	/**
	 * Returns a range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of utente lavoros
	 */
	public java.util.List<UtenteLavoro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente lavoros
	 */
	public java.util.List<UtenteLavoro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente lavoros
	 */
	public java.util.List<UtenteLavoro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtenteLavoro>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the utente lavoros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of utente lavoros.
	 *
	 * @return the number of utente lavoros
	 */
	public int countAll();

}