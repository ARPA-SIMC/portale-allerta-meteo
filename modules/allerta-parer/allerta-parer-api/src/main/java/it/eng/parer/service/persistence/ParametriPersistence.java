/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.parer.exception.NoSuchParametriException;
import it.eng.parer.model.Parametri;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the parametri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see ParametriUtil
 * @generated
 */
@ProviderType
public interface ParametriPersistence extends BasePersistence<Parametri> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParametriUtil} to access the parametri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the parametri in the entity cache if it is enabled.
	 *
	 * @param parametri the parametri
	 */
	public void cacheResult(Parametri parametri);

	/**
	 * Caches the parametris in the entity cache if it is enabled.
	 *
	 * @param parametris the parametris
	 */
	public void cacheResult(java.util.List<Parametri> parametris);

	/**
	 * Creates a new parametri with the primary key. Does not add the parametri to the database.
	 *
	 * @param chiave the primary key for the new parametri
	 * @return the new parametri
	 */
	public Parametri create(String chiave);

	/**
	 * Removes the parametri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri that was removed
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	public Parametri remove(String chiave) throws NoSuchParametriException;

	public Parametri updateImpl(Parametri parametri);

	/**
	 * Returns the parametri with the primary key or throws a <code>NoSuchParametriException</code> if it could not be found.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	public Parametri findByPrimaryKey(String chiave)
		throws NoSuchParametriException;

	/**
	 * Returns the parametri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri, or <code>null</code> if a parametri with the primary key could not be found
	 */
	public Parametri fetchByPrimaryKey(String chiave);

	/**
	 * Returns all the parametris.
	 *
	 * @return the parametris
	 */
	public java.util.List<Parametri> findAll();

	/**
	 * Returns a range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @return the range of parametris
	 */
	public java.util.List<Parametri> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametris
	 */
	public java.util.List<Parametri> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parametri>
			orderByComparator);

	/**
	 * Returns an ordered range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parametris
	 */
	public java.util.List<Parametri> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parametri>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the parametris from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of parametris.
	 *
	 * @return the number of parametris
	 */
	public int countAll();

}