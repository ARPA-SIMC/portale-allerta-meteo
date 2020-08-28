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

package it.eng.allerter.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerter.exception.NoSuchGeografiaException;
import it.eng.allerter.model.Geografia;
import it.eng.allerter.model.impl.GeografiaImpl;
import it.eng.allerter.model.impl.GeografiaModelImpl;
import it.eng.allerter.service.persistence.GeografiaPK;
import it.eng.allerter.service.persistence.GeografiaPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the geografia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class GeografiaPersistenceImpl
	extends BasePersistenceImpl<Geografia> implements GeografiaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GeografiaUtil</code> to access the geografia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GeografiaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTipo;
	private FinderPath _finderPathWithoutPaginationFindByTipo;
	private FinderPath _finderPathCountByTipo;

	/**
	 * Returns all the geografias where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the matching geografias
	 */
	@Override
	public List<Geografia> findByTipo(String tipo) {
		return findByTipo(tipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Geografia> findByTipo(String tipo, int start, int end) {
		return findByTipo(tipo, start, end, null);
	}

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
	@Override
	public List<Geografia> findByTipo(
		String tipo, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return findByTipo(tipo, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findByTipo(
		String tipo, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTipo;
			finderArgs = new Object[] {tipo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTipo;
			finderArgs = new Object[] {tipo, start, end, orderByComparator};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Geografia geografia : list) {
					if (!tipo.equals(geografia.getTipo())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPO_TIPO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GeografiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByTipo_First(
			String tipo, OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipo_First(tipo, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipo_First(
		String tipo, OrderByComparator<Geografia> orderByComparator) {

		List<Geografia> list = findByTipo(tipo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByTipo_Last(
			String tipo, OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipo_Last(tipo, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipo_Last(
		String tipo, OrderByComparator<Geografia> orderByComparator) {

		int count = countByTipo(tipo);

		if (count == 0) {
			return null;
		}

		List<Geografia> list = findByTipo(
			tipo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia[] findByTipo_PrevAndNext(
			GeografiaPK geografiaPK, String tipo,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		tipo = Objects.toString(tipo, "");

		Geografia geografia = findByPrimaryKey(geografiaPK);

		Session session = null;

		try {
			session = openSession();

			Geografia[] array = new GeografiaImpl[3];

			array[0] = getByTipo_PrevAndNext(
				session, geografia, tipo, orderByComparator, true);

			array[1] = geografia;

			array[2] = getByTipo_PrevAndNext(
				session, geografia, tipo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geografia getByTipo_PrevAndNext(
		Session session, Geografia geografia, String tipo,
		OrderByComparator<Geografia> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPO_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_TIPO_TIPO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeografiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(geografia)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Geografia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geografias where tipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 */
	@Override
	public void removeByTipo(String tipo) {
		for (Geografia geografia :
				findByTipo(tipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the number of matching geografias
	 */
	@Override
	public int countByTipo(String tipo) {
		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = _finderPathCountByTipo;

		Object[] finderArgs = new Object[] {tipo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPO_TIPO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPO_TIPO_2 =
		"geografia.id.tipo = ?";

	private static final String _FINDER_COLUMN_TIPO_TIPO_3 =
		"(geografia.id.tipo IS NULL OR geografia.id.tipo = '')";

	private FinderPath _finderPathWithPaginationFindByTipoArea;
	private FinderPath _finderPathWithoutPaginationFindByTipoArea;
	private FinderPath _finderPathCountByTipoArea;

	/**
	 * Returns all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @return the matching geografias
	 */
	@Override
	public List<Geografia> findByTipoArea(String tipo, String area) {
		return findByTipoArea(
			tipo, area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end) {

		return findByTipoArea(tipo, area, start, end, null);
	}

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
	@Override
	public List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return findByTipoArea(tipo, area, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");
		area = Objects.toString(area, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTipoArea;
			finderArgs = new Object[] {tipo, area};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTipoArea;
			finderArgs = new Object[] {
				tipo, area, start, end, orderByComparator
			};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Geografia geografia : list) {
					if (!tipo.equals(geografia.getTipo()) ||
						!area.equals(geografia.getArea())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREA_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOAREA_TIPO_2);
			}

			boolean bindArea = false;

			if (area.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREA_AREA_3);
			}
			else {
				bindArea = true;

				query.append(_FINDER_COLUMN_TIPOAREA_AREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GeografiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindArea) {
					qPos.add(area);
				}

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByTipoArea_First(
			String tipo, String area,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipoArea_First(
			tipo, area, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", area=");
		msg.append(area);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipoArea_First(
		String tipo, String area,
		OrderByComparator<Geografia> orderByComparator) {

		List<Geografia> list = findByTipoArea(
			tipo, area, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByTipoArea_Last(
			String tipo, String area,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipoArea_Last(
			tipo, area, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", area=");
		msg.append(area);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipoArea_Last(
		String tipo, String area,
		OrderByComparator<Geografia> orderByComparator) {

		int count = countByTipoArea(tipo, area);

		if (count == 0) {
			return null;
		}

		List<Geografia> list = findByTipoArea(
			tipo, area, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Geografia[] findByTipoArea_PrevAndNext(
			GeografiaPK geografiaPK, String tipo, String area,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		tipo = Objects.toString(tipo, "");
		area = Objects.toString(area, "");

		Geografia geografia = findByPrimaryKey(geografiaPK);

		Session session = null;

		try {
			session = openSession();

			Geografia[] array = new GeografiaImpl[3];

			array[0] = getByTipoArea_PrevAndNext(
				session, geografia, tipo, area, orderByComparator, true);

			array[1] = geografia;

			array[2] = getByTipoArea_PrevAndNext(
				session, geografia, tipo, area, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geografia getByTipoArea_PrevAndNext(
		Session session, Geografia geografia, String tipo, String area,
		OrderByComparator<Geografia> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOAREA_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_TIPOAREA_TIPO_2);
		}

		boolean bindArea = false;

		if (area.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOAREA_AREA_3);
		}
		else {
			bindArea = true;

			query.append(_FINDER_COLUMN_TIPOAREA_AREA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeografiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		if (bindArea) {
			qPos.add(area);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(geografia)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Geografia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geografias where tipo = &#63; and area = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 */
	@Override
	public void removeByTipoArea(String tipo, String area) {
		for (Geografia geografia :
				findByTipoArea(
					tipo, area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @return the number of matching geografias
	 */
	@Override
	public int countByTipoArea(String tipo, String area) {
		tipo = Objects.toString(tipo, "");
		area = Objects.toString(area, "");

		FinderPath finderPath = _finderPathCountByTipoArea;

		Object[] finderArgs = new Object[] {tipo, area};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREA_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOAREA_TIPO_2);
			}

			boolean bindArea = false;

			if (area.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREA_AREA_3);
			}
			else {
				bindArea = true;

				query.append(_FINDER_COLUMN_TIPOAREA_AREA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindArea) {
					qPos.add(area);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPOAREA_TIPO_2 =
		"geografia.id.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOAREA_TIPO_3 =
		"(geografia.id.tipo IS NULL OR geografia.id.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOAREA_AREA_2 =
		"geografia.id.area = ?";

	private static final String _FINDER_COLUMN_TIPOAREA_AREA_3 =
		"(geografia.id.area IS NULL OR geografia.id.area = '')";

	private FinderPath _finderPathWithPaginationFindByTipoAreaComplessita;
	private FinderPath _finderPathWithoutPaginationFindByTipoAreaComplessita;
	private FinderPath _finderPathCountByTipoAreaComplessita;

	/**
	 * Returns all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	@Override
	public List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita) {

		return findByTipoAreaComplessita(
			tipo, area, complessita, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end) {

		return findByTipoAreaComplessita(
			tipo, area, complessita, start, end, null);
	}

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
	@Override
	public List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return findByTipoAreaComplessita(
			tipo, area, complessita, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");
		area = Objects.toString(area, "");
		complessita = Objects.toString(complessita, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTipoAreaComplessita;
			finderArgs = new Object[] {tipo, area, complessita};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTipoAreaComplessita;
			finderArgs = new Object[] {
				tipo, area, complessita, start, end, orderByComparator
			};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Geografia geografia : list) {
					if (!tipo.equals(geografia.getTipo()) ||
						!area.equals(geografia.getArea()) ||
						!complessita.equals(geografia.getComplessita())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_2);
			}

			boolean bindArea = false;

			if (area.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_3);
			}
			else {
				bindArea = true;

				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GeografiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindArea) {
					qPos.add(area);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public Geografia findByTipoAreaComplessita_First(
			String tipo, String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipoAreaComplessita_First(
			tipo, area, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", area=");
		msg.append(area);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipoAreaComplessita_First(
		String tipo, String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		List<Geografia> list = findByTipoAreaComplessita(
			tipo, area, complessita, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Geografia findByTipoAreaComplessita_Last(
			String tipo, String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipoAreaComplessita_Last(
			tipo, area, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", area=");
		msg.append(area);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipoAreaComplessita_Last(
		String tipo, String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		int count = countByTipoAreaComplessita(tipo, area, complessita);

		if (count == 0) {
			return null;
		}

		List<Geografia> list = findByTipoAreaComplessita(
			tipo, area, complessita, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Geografia[] findByTipoAreaComplessita_PrevAndNext(
			GeografiaPK geografiaPK, String tipo, String area,
			String complessita, OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		tipo = Objects.toString(tipo, "");
		area = Objects.toString(area, "");
		complessita = Objects.toString(complessita, "");

		Geografia geografia = findByPrimaryKey(geografiaPK);

		Session session = null;

		try {
			session = openSession();

			Geografia[] array = new GeografiaImpl[3];

			array[0] = getByTipoAreaComplessita_PrevAndNext(
				session, geografia, tipo, area, complessita, orderByComparator,
				true);

			array[1] = geografia;

			array[2] = getByTipoAreaComplessita_PrevAndNext(
				session, geografia, tipo, area, complessita, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geografia getByTipoAreaComplessita_PrevAndNext(
		Session session, Geografia geografia, String tipo, String area,
		String complessita, OrderByComparator<Geografia> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_2);
		}

		boolean bindArea = false;

		if (area.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_3);
		}
		else {
			bindArea = true;

			query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_2);
		}

		boolean bindComplessita = false;

		if (complessita.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_3);
		}
		else {
			bindComplessita = true;

			query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeografiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		if (bindArea) {
			qPos.add(area);
		}

		if (bindComplessita) {
			qPos.add(complessita);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(geografia)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Geografia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geografias where tipo = &#63; and area = &#63; and complessita = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 */
	@Override
	public void removeByTipoAreaComplessita(
		String tipo, String area, String complessita) {

		for (Geografia geografia :
				findByTipoAreaComplessita(
					tipo, area, complessita, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	@Override
	public int countByTipoAreaComplessita(
		String tipo, String area, String complessita) {

		tipo = Objects.toString(tipo, "");
		area = Objects.toString(area, "");
		complessita = Objects.toString(complessita, "");

		FinderPath finderPath = _finderPathCountByTipoAreaComplessita;

		Object[] finderArgs = new Object[] {tipo, area, complessita};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_2);
			}

			boolean bindArea = false;

			if (area.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_3);
			}
			else {
				bindArea = true;

				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindArea) {
					qPos.add(area);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_2 =
		"geografia.id.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOAREACOMPLESSITA_TIPO_3 =
		"(geografia.id.tipo IS NULL OR geografia.id.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_2 =
		"geografia.id.area = ? AND ";

	private static final String _FINDER_COLUMN_TIPOAREACOMPLESSITA_AREA_3 =
		"(geografia.id.area IS NULL OR geografia.id.area = '') AND ";

	private static final String
		_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_2 =
			"geografia.id.complessita = ?";

	private static final String
		_FINDER_COLUMN_TIPOAREACOMPLESSITA_COMPLESSITA_3 =
			"(geografia.id.complessita IS NULL OR geografia.id.complessita = '')";

	private FinderPath _finderPathWithPaginationFindByTipoComplessita;
	private FinderPath _finderPathWithoutPaginationFindByTipoComplessita;
	private FinderPath _finderPathCountByTipoComplessita;

	/**
	 * Returns all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	@Override
	public List<Geografia> findByTipoComplessita(
		String tipo, String complessita) {

		return findByTipoComplessita(
			tipo, complessita, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end) {

		return findByTipoComplessita(tipo, complessita, start, end, null);
	}

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
	@Override
	public List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return findByTipoComplessita(
			tipo, complessita, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");
		complessita = Objects.toString(complessita, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTipoComplessita;
			finderArgs = new Object[] {tipo, complessita};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTipoComplessita;
			finderArgs = new Object[] {
				tipo, complessita, start, end, orderByComparator
			};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Geografia geografia : list) {
					if (!tipo.equals(geografia.getTipo()) ||
						!complessita.equals(geografia.getComplessita())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GeografiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByTipoComplessita_First(
			String tipo, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipoComplessita_First(
			tipo, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipoComplessita_First(
		String tipo, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		List<Geografia> list = findByTipoComplessita(
			tipo, complessita, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByTipoComplessita_Last(
			String tipo, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByTipoComplessita_Last(
			tipo, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByTipoComplessita_Last(
		String tipo, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		int count = countByTipoComplessita(tipo, complessita);

		if (count == 0) {
			return null;
		}

		List<Geografia> list = findByTipoComplessita(
			tipo, complessita, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Geografia[] findByTipoComplessita_PrevAndNext(
			GeografiaPK geografiaPK, String tipo, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		tipo = Objects.toString(tipo, "");
		complessita = Objects.toString(complessita, "");

		Geografia geografia = findByPrimaryKey(geografiaPK);

		Session session = null;

		try {
			session = openSession();

			Geografia[] array = new GeografiaImpl[3];

			array[0] = getByTipoComplessita_PrevAndNext(
				session, geografia, tipo, complessita, orderByComparator, true);

			array[1] = geografia;

			array[2] = getByTipoComplessita_PrevAndNext(
				session, geografia, tipo, complessita, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geografia getByTipoComplessita_PrevAndNext(
		Session session, Geografia geografia, String tipo, String complessita,
		OrderByComparator<Geografia> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_2);
		}

		boolean bindComplessita = false;

		if (complessita.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_3);
		}
		else {
			bindComplessita = true;

			query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeografiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		if (bindComplessita) {
			qPos.add(complessita);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(geografia)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Geografia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geografias where tipo = &#63; and complessita = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 */
	@Override
	public void removeByTipoComplessita(String tipo, String complessita) {
		for (Geografia geografia :
				findByTipoComplessita(
					tipo, complessita, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	@Override
	public int countByTipoComplessita(String tipo, String complessita) {
		tipo = Objects.toString(tipo, "");
		complessita = Objects.toString(complessita, "");

		FinderPath finderPath = _finderPathCountByTipoComplessita;

		Object[] finderArgs = new Object[] {tipo, complessita};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOGRAFIA_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_2 =
		"geografia.id.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOCOMPLESSITA_TIPO_3 =
		"(geografia.id.tipo IS NULL OR geografia.id.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_2 =
		"geografia.id.complessita = ?";

	private static final String _FINDER_COLUMN_TIPOCOMPLESSITA_COMPLESSITA_3 =
		"(geografia.id.complessita IS NULL OR geografia.id.complessita = '')";

	private FinderPath _finderPathWithPaginationFindByIdComplessita;
	private FinderPath _finderPathWithoutPaginationFindByIdComplessita;
	private FinderPath _finderPathCountByIdComplessita;

	/**
	 * Returns all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	@Override
	public List<Geografia> findByIdComplessita(
		String geografiaId, String complessita) {

		return findByIdComplessita(
			geografiaId, complessita, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end) {

		return findByIdComplessita(geografiaId, complessita, start, end, null);
	}

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
	@Override
	public List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return findByIdComplessita(
			geografiaId, complessita, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		geografiaId = Objects.toString(geografiaId, "");
		complessita = Objects.toString(complessita, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByIdComplessita;
			finderArgs = new Object[] {geografiaId, complessita};
		}
		else {
			finderPath = _finderPathWithPaginationFindByIdComplessita;
			finderArgs = new Object[] {
				geografiaId, complessita, start, end, orderByComparator
			};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Geografia geografia : list) {
					if (!geografiaId.equals(geografia.getGeografiaId()) ||
						!complessita.equals(geografia.getComplessita())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

			boolean bindGeografiaId = false;

			if (geografiaId.isEmpty()) {
				query.append(_FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_3);
			}
			else {
				bindGeografiaId = true;

				query.append(_FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GeografiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGeografiaId) {
					qPos.add(geografiaId);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByIdComplessita_First(
			String geografiaId, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByIdComplessita_First(
			geografiaId, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("geografiaId=");
		msg.append(geografiaId);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the first geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByIdComplessita_First(
		String geografiaId, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		List<Geografia> list = findByIdComplessita(
			geografiaId, complessita, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByIdComplessita_Last(
			String geografiaId, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByIdComplessita_Last(
			geografiaId, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("geografiaId=");
		msg.append(geografiaId);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the last geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByIdComplessita_Last(
		String geografiaId, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		int count = countByIdComplessita(geografiaId, complessita);

		if (count == 0) {
			return null;
		}

		List<Geografia> list = findByIdComplessita(
			geografiaId, complessita, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Geografia[] findByIdComplessita_PrevAndNext(
			GeografiaPK geografiaPK, String geografiaId, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		geografiaId = Objects.toString(geografiaId, "");
		complessita = Objects.toString(complessita, "");

		Geografia geografia = findByPrimaryKey(geografiaPK);

		Session session = null;

		try {
			session = openSession();

			Geografia[] array = new GeografiaImpl[3];

			array[0] = getByIdComplessita_PrevAndNext(
				session, geografia, geografiaId, complessita, orderByComparator,
				true);

			array[1] = geografia;

			array[2] = getByIdComplessita_PrevAndNext(
				session, geografia, geografiaId, complessita, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geografia getByIdComplessita_PrevAndNext(
		Session session, Geografia geografia, String geografiaId,
		String complessita, OrderByComparator<Geografia> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

		boolean bindGeografiaId = false;

		if (geografiaId.isEmpty()) {
			query.append(_FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_3);
		}
		else {
			bindGeografiaId = true;

			query.append(_FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_2);
		}

		boolean bindComplessita = false;

		if (complessita.isEmpty()) {
			query.append(_FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_3);
		}
		else {
			bindComplessita = true;

			query.append(_FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeografiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGeografiaId) {
			qPos.add(geografiaId);
		}

		if (bindComplessita) {
			qPos.add(complessita);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(geografia)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Geografia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geografias where geografiaId = &#63; and complessita = &#63; from the database.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 */
	@Override
	public void removeByIdComplessita(String geografiaId, String complessita) {
		for (Geografia geografia :
				findByIdComplessita(
					geografiaId, complessita, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	@Override
	public int countByIdComplessita(String geografiaId, String complessita) {
		geografiaId = Objects.toString(geografiaId, "");
		complessita = Objects.toString(complessita, "");

		FinderPath finderPath = _finderPathCountByIdComplessita;

		Object[] finderArgs = new Object[] {geografiaId, complessita};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOGRAFIA_WHERE);

			boolean bindGeografiaId = false;

			if (geografiaId.isEmpty()) {
				query.append(_FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_3);
			}
			else {
				bindGeografiaId = true;

				query.append(_FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGeografiaId) {
					qPos.add(geografiaId);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_2 =
		"geografia.id.geografiaId = ? AND ";

	private static final String _FINDER_COLUMN_IDCOMPLESSITA_GEOGRAFIAID_3 =
		"(geografia.id.geografiaId IS NULL OR geografia.id.geografiaId = '') AND ";

	private static final String _FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_2 =
		"geografia.id.complessita = ?";

	private static final String _FINDER_COLUMN_IDCOMPLESSITA_COMPLESSITA_3 =
		"(geografia.id.complessita IS NULL OR geografia.id.complessita = '')";

	private FinderPath _finderPathWithPaginationFindByAreaComplessita;
	private FinderPath _finderPathWithoutPaginationFindByAreaComplessita;
	private FinderPath _finderPathCountByAreaComplessita;

	/**
	 * Returns all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	@Override
	public List<Geografia> findByAreaComplessita(
		String area, String complessita) {

		return findByAreaComplessita(
			area, complessita, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end) {

		return findByAreaComplessita(area, complessita, start, end, null);
	}

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
	@Override
	public List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return findByAreaComplessita(
			area, complessita, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		area = Objects.toString(area, "");
		complessita = Objects.toString(complessita, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByAreaComplessita;
			finderArgs = new Object[] {area, complessita};
		}
		else {
			finderPath = _finderPathWithPaginationFindByAreaComplessita;
			finderArgs = new Object[] {
				area, complessita, start, end, orderByComparator
			};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Geografia geografia : list) {
					if (!area.equals(geografia.getArea()) ||
						!complessita.equals(geografia.getComplessita())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

			boolean bindArea = false;

			if (area.isEmpty()) {
				query.append(_FINDER_COLUMN_AREACOMPLESSITA_AREA_3);
			}
			else {
				bindArea = true;

				query.append(_FINDER_COLUMN_AREACOMPLESSITA_AREA_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(GeografiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArea) {
					qPos.add(area);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByAreaComplessita_First(
			String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByAreaComplessita_First(
			area, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("area=");
		msg.append(area);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the first geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByAreaComplessita_First(
		String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		List<Geografia> list = findByAreaComplessita(
			area, complessita, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	@Override
	public Geografia findByAreaComplessita_Last(
			String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByAreaComplessita_Last(
			area, complessita, orderByComparator);

		if (geografia != null) {
			return geografia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("area=");
		msg.append(area);

		msg.append(", complessita=");
		msg.append(complessita);

		msg.append("}");

		throw new NoSuchGeografiaException(msg.toString());
	}

	/**
	 * Returns the last geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	@Override
	public Geografia fetchByAreaComplessita_Last(
		String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		int count = countByAreaComplessita(area, complessita);

		if (count == 0) {
			return null;
		}

		List<Geografia> list = findByAreaComplessita(
			area, complessita, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Geografia[] findByAreaComplessita_PrevAndNext(
			GeografiaPK geografiaPK, String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws NoSuchGeografiaException {

		area = Objects.toString(area, "");
		complessita = Objects.toString(complessita, "");

		Geografia geografia = findByPrimaryKey(geografiaPK);

		Session session = null;

		try {
			session = openSession();

			Geografia[] array = new GeografiaImpl[3];

			array[0] = getByAreaComplessita_PrevAndNext(
				session, geografia, area, complessita, orderByComparator, true);

			array[1] = geografia;

			array[2] = getByAreaComplessita_PrevAndNext(
				session, geografia, area, complessita, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geografia getByAreaComplessita_PrevAndNext(
		Session session, Geografia geografia, String area, String complessita,
		OrderByComparator<Geografia> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GEOGRAFIA_WHERE);

		boolean bindArea = false;

		if (area.isEmpty()) {
			query.append(_FINDER_COLUMN_AREACOMPLESSITA_AREA_3);
		}
		else {
			bindArea = true;

			query.append(_FINDER_COLUMN_AREACOMPLESSITA_AREA_2);
		}

		boolean bindComplessita = false;

		if (complessita.isEmpty()) {
			query.append(_FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_3);
		}
		else {
			bindComplessita = true;

			query.append(_FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeografiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindArea) {
			qPos.add(area);
		}

		if (bindComplessita) {
			qPos.add(complessita);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(geografia)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Geografia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geografias where area = &#63; and complessita = &#63; from the database.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 */
	@Override
	public void removeByAreaComplessita(String area, String complessita) {
		for (Geografia geografia :
				findByAreaComplessita(
					area, complessita, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	@Override
	public int countByAreaComplessita(String area, String complessita) {
		area = Objects.toString(area, "");
		complessita = Objects.toString(complessita, "");

		FinderPath finderPath = _finderPathCountByAreaComplessita;

		Object[] finderArgs = new Object[] {area, complessita};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOGRAFIA_WHERE);

			boolean bindArea = false;

			if (area.isEmpty()) {
				query.append(_FINDER_COLUMN_AREACOMPLESSITA_AREA_3);
			}
			else {
				bindArea = true;

				query.append(_FINDER_COLUMN_AREACOMPLESSITA_AREA_2);
			}

			boolean bindComplessita = false;

			if (complessita.isEmpty()) {
				query.append(_FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_3);
			}
			else {
				bindComplessita = true;

				query.append(_FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArea) {
					qPos.add(area);
				}

				if (bindComplessita) {
					qPos.add(complessita);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AREACOMPLESSITA_AREA_2 =
		"geografia.id.area = ? AND ";

	private static final String _FINDER_COLUMN_AREACOMPLESSITA_AREA_3 =
		"(geografia.id.area IS NULL OR geografia.id.area = '') AND ";

	private static final String _FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_2 =
		"geografia.id.complessita = ?";

	private static final String _FINDER_COLUMN_AREACOMPLESSITA_COMPLESSITA_3 =
		"(geografia.id.complessita IS NULL OR geografia.id.complessita = '')";

	public GeografiaPersistenceImpl() {
		setModelClass(Geografia.class);
	}

	/**
	 * Caches the geografia in the entity cache if it is enabled.
	 *
	 * @param geografia the geografia
	 */
	@Override
	public void cacheResult(Geografia geografia) {
		entityCache.putResult(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED, GeografiaImpl.class,
			geografia.getPrimaryKey(), geografia);

		geografia.resetOriginalValues();
	}

	/**
	 * Caches the geografias in the entity cache if it is enabled.
	 *
	 * @param geografias the geografias
	 */
	@Override
	public void cacheResult(List<Geografia> geografias) {
		for (Geografia geografia : geografias) {
			if (entityCache.getResult(
					GeografiaModelImpl.ENTITY_CACHE_ENABLED,
					GeografiaImpl.class, geografia.getPrimaryKey()) == null) {

				cacheResult(geografia);
			}
			else {
				geografia.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geografias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GeografiaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geografia.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Geografia geografia) {
		entityCache.removeResult(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED, GeografiaImpl.class,
			geografia.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Geografia> geografias) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Geografia geografia : geografias) {
			entityCache.removeResult(
				GeografiaModelImpl.ENTITY_CACHE_ENABLED, GeografiaImpl.class,
				geografia.getPrimaryKey());
		}
	}

	/**
	 * Creates a new geografia with the primary key. Does not add the geografia to the database.
	 *
	 * @param geografiaPK the primary key for the new geografia
	 * @return the new geografia
	 */
	@Override
	public Geografia create(GeografiaPK geografiaPK) {
		Geografia geografia = new GeografiaImpl();

		geografia.setNew(true);
		geografia.setPrimaryKey(geografiaPK);

		return geografia;
	}

	/**
	 * Removes the geografia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia that was removed
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia remove(GeografiaPK geografiaPK)
		throws NoSuchGeografiaException {

		return remove((Serializable)geografiaPK);
	}

	/**
	 * Removes the geografia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geografia
	 * @return the geografia that was removed
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia remove(Serializable primaryKey)
		throws NoSuchGeografiaException {

		Session session = null;

		try {
			session = openSession();

			Geografia geografia = (Geografia)session.get(
				GeografiaImpl.class, primaryKey);

			if (geografia == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeografiaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(geografia);
		}
		catch (NoSuchGeografiaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Geografia removeImpl(Geografia geografia) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geografia)) {
				geografia = (Geografia)session.get(
					GeografiaImpl.class, geografia.getPrimaryKeyObj());
			}

			if (geografia != null) {
				session.delete(geografia);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geografia != null) {
			clearCache(geografia);
		}

		return geografia;
	}

	@Override
	public Geografia updateImpl(Geografia geografia) {
		boolean isNew = geografia.isNew();

		if (!(geografia instanceof GeografiaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(geografia.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(geografia);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in geografia proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Geografia implementation " +
					geografia.getClass());
		}

		GeografiaModelImpl geografiaModelImpl = (GeografiaModelImpl)geografia;

		Session session = null;

		try {
			session = openSession();

			if (geografia.isNew()) {
				session.save(geografia);

				geografia.setNew(false);
			}
			else {
				geografia = (Geografia)session.merge(geografia);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!GeografiaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {geografiaModelImpl.getTipo()};

			finderCache.removeResult(_finderPathCountByTipo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipo, args);

			args = new Object[] {
				geografiaModelImpl.getTipo(), geografiaModelImpl.getArea()
			};

			finderCache.removeResult(_finderPathCountByTipoArea, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoArea, args);

			args = new Object[] {
				geografiaModelImpl.getTipo(), geografiaModelImpl.getArea(),
				geografiaModelImpl.getComplessita()
			};

			finderCache.removeResult(
				_finderPathCountByTipoAreaComplessita, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoAreaComplessita, args);

			args = new Object[] {
				geografiaModelImpl.getTipo(),
				geografiaModelImpl.getComplessita()
			};

			finderCache.removeResult(_finderPathCountByTipoComplessita, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoComplessita, args);

			args = new Object[] {
				geografiaModelImpl.getGeografiaId(),
				geografiaModelImpl.getComplessita()
			};

			finderCache.removeResult(_finderPathCountByIdComplessita, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByIdComplessita, args);

			args = new Object[] {
				geografiaModelImpl.getArea(),
				geografiaModelImpl.getComplessita()
			};

			finderCache.removeResult(_finderPathCountByAreaComplessita, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAreaComplessita, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((geografiaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					geografiaModelImpl.getOriginalTipo()
				};

				finderCache.removeResult(_finderPathCountByTipo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipo, args);

				args = new Object[] {geografiaModelImpl.getTipo()};

				finderCache.removeResult(_finderPathCountByTipo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipo, args);
			}

			if ((geografiaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoArea.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					geografiaModelImpl.getOriginalTipo(),
					geografiaModelImpl.getOriginalArea()
				};

				finderCache.removeResult(_finderPathCountByTipoArea, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoArea, args);

				args = new Object[] {
					geografiaModelImpl.getTipo(), geografiaModelImpl.getArea()
				};

				finderCache.removeResult(_finderPathCountByTipoArea, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoArea, args);
			}

			if ((geografiaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoAreaComplessita.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					geografiaModelImpl.getOriginalTipo(),
					geografiaModelImpl.getOriginalArea(),
					geografiaModelImpl.getOriginalComplessita()
				};

				finderCache.removeResult(
					_finderPathCountByTipoAreaComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoAreaComplessita,
					args);

				args = new Object[] {
					geografiaModelImpl.getTipo(), geografiaModelImpl.getArea(),
					geografiaModelImpl.getComplessita()
				};

				finderCache.removeResult(
					_finderPathCountByTipoAreaComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoAreaComplessita,
					args);
			}

			if ((geografiaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoComplessita.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					geografiaModelImpl.getOriginalTipo(),
					geografiaModelImpl.getOriginalComplessita()
				};

				finderCache.removeResult(
					_finderPathCountByTipoComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoComplessita, args);

				args = new Object[] {
					geografiaModelImpl.getTipo(),
					geografiaModelImpl.getComplessita()
				};

				finderCache.removeResult(
					_finderPathCountByTipoComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoComplessita, args);
			}

			if ((geografiaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByIdComplessita.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					geografiaModelImpl.getOriginalGeografiaId(),
					geografiaModelImpl.getOriginalComplessita()
				};

				finderCache.removeResult(_finderPathCountByIdComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIdComplessita, args);

				args = new Object[] {
					geografiaModelImpl.getGeografiaId(),
					geografiaModelImpl.getComplessita()
				};

				finderCache.removeResult(_finderPathCountByIdComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIdComplessita, args);
			}

			if ((geografiaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAreaComplessita.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					geografiaModelImpl.getOriginalArea(),
					geografiaModelImpl.getOriginalComplessita()
				};

				finderCache.removeResult(
					_finderPathCountByAreaComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAreaComplessita, args);

				args = new Object[] {
					geografiaModelImpl.getArea(),
					geografiaModelImpl.getComplessita()
				};

				finderCache.removeResult(
					_finderPathCountByAreaComplessita, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAreaComplessita, args);
			}
		}

		entityCache.putResult(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED, GeografiaImpl.class,
			geografia.getPrimaryKey(), geografia, false);

		geografia.resetOriginalValues();

		return geografia;
	}

	/**
	 * Returns the geografia with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geografia
	 * @return the geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeografiaException {

		Geografia geografia = fetchByPrimaryKey(primaryKey);

		if (geografia == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeografiaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return geografia;
	}

	/**
	 * Returns the geografia with the primary key or throws a <code>NoSuchGeografiaException</code> if it could not be found.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia findByPrimaryKey(GeografiaPK geografiaPK)
		throws NoSuchGeografiaException {

		return findByPrimaryKey((Serializable)geografiaPK);
	}

	/**
	 * Returns the geografia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geografia
	 * @return the geografia, or <code>null</code> if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED, GeografiaImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Geografia geografia = (Geografia)serializable;

		if (geografia == null) {
			Session session = null;

			try {
				session = openSession();

				geografia = (Geografia)session.get(
					GeografiaImpl.class, primaryKey);

				if (geografia != null) {
					cacheResult(geografia);
				}
				else {
					entityCache.putResult(
						GeografiaModelImpl.ENTITY_CACHE_ENABLED,
						GeografiaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					GeografiaModelImpl.ENTITY_CACHE_ENABLED,
					GeografiaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geografia;
	}

	/**
	 * Returns the geografia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia, or <code>null</code> if a geografia with the primary key could not be found
	 */
	@Override
	public Geografia fetchByPrimaryKey(GeografiaPK geografiaPK) {
		return fetchByPrimaryKey((Serializable)geografiaPK);
	}

	@Override
	public Map<Serializable, Geografia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Geografia> map =
			new HashMap<Serializable, Geografia>();

		for (Serializable primaryKey : primaryKeys) {
			Geografia geografia = fetchByPrimaryKey(primaryKey);

			if (geografia != null) {
				map.put(primaryKey, geografia);
			}
		}

		return map;
	}

	/**
	 * Returns all the geografias.
	 *
	 * @return the geografias
	 */
	@Override
	public List<Geografia> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Geografia> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Geografia> findAll(
		int start, int end, OrderByComparator<Geografia> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Geografia> findAll(
		int start, int end, OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Geografia> list = null;

		if (retrieveFromCache) {
			list = (List<Geografia>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GEOGRAFIA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOGRAFIA;

				if (pagination) {
					sql = sql.concat(GeografiaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geografia>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the geografias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Geografia geografia : findAll()) {
			remove(geografia);
		}
	}

	/**
	 * Returns the number of geografias.
	 *
	 * @return the number of geografias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GEOGRAFIA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GeografiaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the geografia persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTipo = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipo = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipo",
			new String[] {String.class.getName()},
			GeografiaModelImpl.TIPO_COLUMN_BITMASK);

		_finderPathCountByTipo = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipo",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTipoArea = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoArea",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoArea = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoArea",
			new String[] {String.class.getName(), String.class.getName()},
			GeografiaModelImpl.TIPO_COLUMN_BITMASK |
			GeografiaModelImpl.AREA_COLUMN_BITMASK);

		_finderPathCountByTipoArea = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoArea",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByTipoAreaComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoAreaComplessita",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoAreaComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTipoAreaComplessita",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			GeografiaModelImpl.TIPO_COLUMN_BITMASK |
			GeografiaModelImpl.AREA_COLUMN_BITMASK |
			GeografiaModelImpl.COMPLESSITA_COLUMN_BITMASK);

		_finderPathCountByTipoAreaComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTipoAreaComplessita",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByTipoComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoComplessita",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoComplessita",
			new String[] {String.class.getName(), String.class.getName()},
			GeografiaModelImpl.TIPO_COLUMN_BITMASK |
			GeografiaModelImpl.COMPLESSITA_COLUMN_BITMASK);

		_finderPathCountByTipoComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoComplessita",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByIdComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdComplessita",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByIdComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdComplessita",
			new String[] {String.class.getName(), String.class.getName()},
			GeografiaModelImpl.GEOGRAFIAID_COLUMN_BITMASK |
			GeografiaModelImpl.COMPLESSITA_COLUMN_BITMASK);

		_finderPathCountByIdComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdComplessita",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByAreaComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAreaComplessita",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAreaComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, GeografiaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAreaComplessita",
			new String[] {String.class.getName(), String.class.getName()},
			GeografiaModelImpl.AREA_COLUMN_BITMASK |
			GeografiaModelImpl.COMPLESSITA_COLUMN_BITMASK);

		_finderPathCountByAreaComplessita = new FinderPath(
			GeografiaModelImpl.ENTITY_CACHE_ENABLED,
			GeografiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAreaComplessita",
			new String[] {String.class.getName(), String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(GeografiaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GEOGRAFIA =
		"SELECT geografia FROM Geografia geografia";

	private static final String _SQL_SELECT_GEOGRAFIA_WHERE =
		"SELECT geografia FROM Geografia geografia WHERE ";

	private static final String _SQL_COUNT_GEOGRAFIA =
		"SELECT COUNT(geografia) FROM Geografia geografia";

	private static final String _SQL_COUNT_GEOGRAFIA_WHERE =
		"SELECT COUNT(geografia) FROM Geografia geografia WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "geografia.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Geografia exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Geografia exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GeografiaPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"geografiaId", "tipo", "area", "complessita"});

}