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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchGeografiaException;
import it.eng.allerter.model.Geografia;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the geografia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see GeografiaUtil
 * @generated
 */
@ProviderType
public interface GeografiaPersistence extends BasePersistence<Geografia> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeografiaUtil} to access the geografia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Geografia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the geografias where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the matching geografias
	 */
	public java.util.List<Geografia> findByTipo(String tipo);

	/**
	 * Returns a range of all the geografias where tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public java.util.List<Geografia> findByTipo(
		String tipo, int start, int end);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipo(
		String tipo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipo(
		String tipo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipo_First(
			String tipo,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipo_First(
		String tipo,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipo_Last(
			String tipo,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipo_Last(
		String tipo,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia[] findByTipo_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Removes all the geografias where tipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 */
	public void removeByTipo(String tipo);

	/**
	 * Returns the number of geografias where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the number of matching geografias
	 */
	public int countByTipo(String tipo);

	/**
	 * Returns all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @return the matching geografias
	 */
	public java.util.List<Geografia> findByTipoArea(String tipo, String area);

	/**
	 * Returns a range of all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipoArea_First(
			String tipo, String area,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipoArea_First(
		String tipo, String area,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipoArea_Last(
			String tipo, String area,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipoArea_Last(
		String tipo, String area,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia[] findByTipoArea_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, String area,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Removes all the geografias where tipo = &#63; and area = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 */
	public void removeByTipoArea(String tipo, String area);

	/**
	 * Returns the number of geografias where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @return the number of matching geografias
	 */
	public int countByTipoArea(String tipo, String area);

	/**
	 * Returns all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public java.util.List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita);

	/**
	 * Returns a range of all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipoAreaComplessita_First(
			String tipo, String area, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipoAreaComplessita_First(
		String tipo, String area, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipoAreaComplessita_Last(
			String tipo, String area, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipoAreaComplessita_Last(
		String tipo, String area, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia[] findByTipoAreaComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, String area, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Removes all the geografias where tipo = &#63; and area = &#63; and complessita = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 */
	public void removeByTipoAreaComplessita(
		String tipo, String area, String complessita);

	/**
	 * Returns the number of geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public int countByTipoAreaComplessita(
		String tipo, String area, String complessita);

	/**
	 * Returns all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public java.util.List<Geografia> findByTipoComplessita(
		String tipo, String complessita);

	/**
	 * Returns a range of all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipoComplessita_First(
			String tipo, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipoComplessita_First(
		String tipo, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByTipoComplessita_Last(
			String tipo, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByTipoComplessita_Last(
		String tipo, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia[] findByTipoComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Removes all the geografias where tipo = &#63; and complessita = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 */
	public void removeByTipoComplessita(String tipo, String complessita);

	/**
	 * Returns the number of geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public int countByTipoComplessita(String tipo, String complessita);

	/**
	 * Returns all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public java.util.List<Geografia> findByIdComplessita(
		String geografiaId, String complessita);

	/**
	 * Returns a range of all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public java.util.List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end);

	/**
	 * Returns an ordered range of all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByIdComplessita_First(
			String geografiaId, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the first geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByIdComplessita_First(
		String geografiaId, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the last geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByIdComplessita_Last(
			String geografiaId, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the last geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByIdComplessita_Last(
		String geografiaId, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia[] findByIdComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String geografiaId, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Removes all the geografias where geografiaId = &#63; and complessita = &#63; from the database.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 */
	public void removeByIdComplessita(String geografiaId, String complessita);

	/**
	 * Returns the number of geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public int countByIdComplessita(String geografiaId, String complessita);

	/**
	 * Returns all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public java.util.List<Geografia> findByAreaComplessita(
		String area, String complessita);

	/**
	 * Returns a range of all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public java.util.List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end);

	/**
	 * Returns an ordered range of all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public java.util.List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByAreaComplessita_First(
			String area, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the first geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByAreaComplessita_First(
		String area, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the last geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public Geografia findByAreaComplessita_Last(
			String area, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Returns the last geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public Geografia fetchByAreaComplessita_Last(
		String area, String complessita,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia[] findByAreaComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String area, String complessita,
			com.liferay.portal.kernel.util.OrderByComparator<Geografia>
				orderByComparator)
		throws NoSuchGeografiaException;

	/**
	 * Removes all the geografias where area = &#63; and complessita = &#63; from the database.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 */
	public void removeByAreaComplessita(String area, String complessita);

	/**
	 * Returns the number of geografias where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public int countByAreaComplessita(String area, String complessita);

	/**
	 * Caches the geografia in the entity cache if it is enabled.
	 *
	 * @param geografia the geografia
	 */
	public void cacheResult(Geografia geografia);

	/**
	 * Caches the geografias in the entity cache if it is enabled.
	 *
	 * @param geografias the geografias
	 */
	public void cacheResult(java.util.List<Geografia> geografias);

	/**
	 * Creates a new geografia with the primary key. Does not add the geografia to the database.
	 *
	 * @param geografiaPK the primary key for the new geografia
	 * @return the new geografia
	 */
	public Geografia create(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK);

	/**
	 * Removes the geografia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia that was removed
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia remove(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws NoSuchGeografiaException;

	public Geografia updateImpl(Geografia geografia);

	/**
	 * Returns the geografia with the primary key or throws a <code>NoSuchGeografiaException</code> if it could not be found.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public Geografia findByPrimaryKey(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws NoSuchGeografiaException;

	/**
	 * Returns the geografia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia, or <code>null</code> if a geografia with the primary key could not be found
	 */
	public Geografia fetchByPrimaryKey(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK);

	/**
	 * Returns all the geografias.
	 *
	 * @return the geografias
	 */
	public java.util.List<Geografia> findAll();

	/**
	 * Returns a range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of geografias
	 */
	public java.util.List<Geografia> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of geografias
	 */
	public java.util.List<Geografia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of geografias
	 */
	public java.util.List<Geografia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geografia>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the geografias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of geografias.
	 *
	 * @return the number of geografias
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}