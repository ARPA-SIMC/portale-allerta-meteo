/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerta.messages.services.exception.NoSuchNodoException;
import it.eng.allerta.messages.services.model.Nodo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the nodo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see NodoUtil
 * @generated
 */
@ProviderType
public interface NodoPersistence extends BasePersistence<Nodo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NodoUtil} to access the nodo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the nodo where nodoConnesso = &#63; or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the matching nodo
	 * @throws NoSuchNodoException if a matching nodo could not be found
	 */
	public Nodo findBynodoConnesso(String nodoConnesso)
		throws NoSuchNodoException;

	/**
	 * Returns the nodo where nodoConnesso = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public Nodo fetchBynodoConnesso(String nodoConnesso);

	/**
	 * Returns the nodo where nodoConnesso = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public Nodo fetchBynodoConnesso(
		String nodoConnesso, boolean useFinderCache);

	/**
	 * Removes the nodo where nodoConnesso = &#63; from the database.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the nodo that was removed
	 */
	public Nodo removeBynodoConnesso(String nodoConnesso)
		throws NoSuchNodoException;

	/**
	 * Returns the number of nodos where nodoConnesso = &#63;.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the number of matching nodos
	 */
	public int countBynodoConnesso(String nodoConnesso);

	/**
	 * Returns the nodo where ip = &#63; or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param ip the ip
	 * @return the matching nodo
	 * @throws NoSuchNodoException if a matching nodo could not be found
	 */
	public Nodo findByip(String ip) throws NoSuchNodoException;

	/**
	 * Returns the nodo where ip = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ip the ip
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public Nodo fetchByip(String ip);

	/**
	 * Returns the nodo where ip = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ip the ip
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public Nodo fetchByip(String ip, boolean useFinderCache);

	/**
	 * Removes the nodo where ip = &#63; from the database.
	 *
	 * @param ip the ip
	 * @return the nodo that was removed
	 */
	public Nodo removeByip(String ip) throws NoSuchNodoException;

	/**
	 * Returns the number of nodos where ip = &#63;.
	 *
	 * @param ip the ip
	 * @return the number of matching nodos
	 */
	public int countByip(String ip);

	/**
	 * Caches the nodo in the entity cache if it is enabled.
	 *
	 * @param nodo the nodo
	 */
	public void cacheResult(Nodo nodo);

	/**
	 * Caches the nodos in the entity cache if it is enabled.
	 *
	 * @param nodos the nodos
	 */
	public void cacheResult(java.util.List<Nodo> nodos);

	/**
	 * Creates a new nodo with the primary key. Does not add the nodo to the database.
	 *
	 * @param Id the primary key for the new nodo
	 * @return the new nodo
	 */
	public Nodo create(long Id);

	/**
	 * Removes the nodo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo that was removed
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	public Nodo remove(long Id) throws NoSuchNodoException;

	public Nodo updateImpl(Nodo nodo);

	/**
	 * Returns the nodo with the primary key or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	public Nodo findByPrimaryKey(long Id) throws NoSuchNodoException;

	/**
	 * Returns the nodo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo, or <code>null</code> if a nodo with the primary key could not be found
	 */
	public Nodo fetchByPrimaryKey(long Id);

	/**
	 * Returns all the nodos.
	 *
	 * @return the nodos
	 */
	public java.util.List<Nodo> findAll();

	/**
	 * Returns a range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @return the range of nodos
	 */
	public java.util.List<Nodo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nodos
	 */
	public java.util.List<Nodo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nodo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nodos
	 */
	public java.util.List<Nodo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nodo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the nodos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of nodos.
	 *
	 * @return the number of nodos
	 */
	public int countAll();

}