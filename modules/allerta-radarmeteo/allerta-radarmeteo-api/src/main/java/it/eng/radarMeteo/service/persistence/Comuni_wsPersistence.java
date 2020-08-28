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

package it.eng.radarMeteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.radarMeteo.exception.NoSuchComuni_wsException;
import it.eng.radarMeteo.model.Comuni_ws;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the comuni_ws service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @see Comuni_wsUtil
 * @generated
 */
@ProviderType
public interface Comuni_wsPersistence extends BasePersistence<Comuni_ws> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Comuni_wsUtil} to access the comuni_ws persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Comuni_ws> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the comuni_wses where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @return the matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findBySottozona(String sottozona);

	/**
	 * Returns a range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end);

	/**
	 * Returns an ordered range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public Comuni_ws findBySottozona_First(
			String sottozona,
			com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
				orderByComparator)
		throws NoSuchComuni_wsException;

	/**
	 * Returns the first comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public Comuni_ws fetchBySottozona_First(
		String sottozona,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns the last comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public Comuni_ws findBySottozona_Last(
			String sottozona,
			com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
				orderByComparator)
		throws NoSuchComuni_wsException;

	/**
	 * Returns the last comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public Comuni_ws fetchBySottozona_Last(
		String sottozona,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns the comuni_wses before and after the current comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param idIstat the primary key of the current comuni_ws
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public Comuni_ws[] findBySottozona_PrevAndNext(
			String idIstat, String sottozona,
			com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
				orderByComparator)
		throws NoSuchComuni_wsException;

	/**
	 * Removes all the comuni_wses where sottozona = &#63; from the database.
	 *
	 * @param sottozona the sottozona
	 */
	public void removeBySottozona(String sottozona);

	/**
	 * Returns the number of comuni_wses where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @return the number of matching comuni_wses
	 */
	public int countBySottozona(String sottozona);

	/**
	 * Returns all the comuni_wses where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @return the matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findByZonaallerta(String zonaallerta);

	/**
	 * Returns a range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end);

	/**
	 * Returns an ordered range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comuni_wses
	 */
	public java.util.List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public Comuni_ws findByZonaallerta_First(
			String zonaallerta,
			com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
				orderByComparator)
		throws NoSuchComuni_wsException;

	/**
	 * Returns the first comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public Comuni_ws fetchByZonaallerta_First(
		String zonaallerta,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns the last comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public Comuni_ws findByZonaallerta_Last(
			String zonaallerta,
			com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
				orderByComparator)
		throws NoSuchComuni_wsException;

	/**
	 * Returns the last comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public Comuni_ws fetchByZonaallerta_Last(
		String zonaallerta,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns the comuni_wses before and after the current comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param idIstat the primary key of the current comuni_ws
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public Comuni_ws[] findByZonaallerta_PrevAndNext(
			String idIstat, String zonaallerta,
			com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
				orderByComparator)
		throws NoSuchComuni_wsException;

	/**
	 * Removes all the comuni_wses where zonaallerta = &#63; from the database.
	 *
	 * @param zonaallerta the zonaallerta
	 */
	public void removeByZonaallerta(String zonaallerta);

	/**
	 * Returns the number of comuni_wses where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @return the number of matching comuni_wses
	 */
	public int countByZonaallerta(String zonaallerta);

	/**
	 * Caches the comuni_ws in the entity cache if it is enabled.
	 *
	 * @param comuni_ws the comuni_ws
	 */
	public void cacheResult(Comuni_ws comuni_ws);

	/**
	 * Caches the comuni_wses in the entity cache if it is enabled.
	 *
	 * @param comuni_wses the comuni_wses
	 */
	public void cacheResult(java.util.List<Comuni_ws> comuni_wses);

	/**
	 * Creates a new comuni_ws with the primary key. Does not add the comuni_ws to the database.
	 *
	 * @param idIstat the primary key for the new comuni_ws
	 * @return the new comuni_ws
	 */
	public Comuni_ws create(String idIstat);

	/**
	 * Removes the comuni_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws that was removed
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public Comuni_ws remove(String idIstat) throws NoSuchComuni_wsException;

	public Comuni_ws updateImpl(Comuni_ws comuni_ws);

	/**
	 * Returns the comuni_ws with the primary key or throws a <code>NoSuchComuni_wsException</code> if it could not be found.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public Comuni_ws findByPrimaryKey(String idIstat)
		throws NoSuchComuni_wsException;

	/**
	 * Returns the comuni_ws with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws, or <code>null</code> if a comuni_ws with the primary key could not be found
	 */
	public Comuni_ws fetchByPrimaryKey(String idIstat);

	/**
	 * Returns all the comuni_wses.
	 *
	 * @return the comuni_wses
	 */
	public java.util.List<Comuni_ws> findAll();

	/**
	 * Returns a range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of comuni_wses
	 */
	public java.util.List<Comuni_ws> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comuni_wses
	 */
	public java.util.List<Comuni_ws> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of comuni_wses
	 */
	public java.util.List<Comuni_ws> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comuni_ws>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the comuni_wses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comuni_wses.
	 *
	 * @return the number of comuni_wses
	 */
	public int countAll();

}