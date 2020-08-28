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

package it.eng.radarMeteo.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException;
import it.eng.radarMeteo.model.Comuni_bacini_ws;
import it.eng.radarMeteo.model.impl.Comuni_bacini_wsImpl;
import it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl;
import it.eng.radarMeteo.service.persistence.Comuni_bacini_wsPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the comuni_bacini_ws service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsPersistenceImpl
	extends BasePersistenceImpl<Comuni_bacini_ws>
	implements Comuni_bacini_wsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Comuni_bacini_wsUtil</code> to access the comuni_bacini_ws persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Comuni_bacini_wsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByBacino;
	private FinderPath _finderPathWithoutPaginationFindByBacino;
	private FinderPath _finderPathCountByBacino;

	/**
	 * Returns all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @return the matching comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findByBacino(String bacino) {
		return findByBacino(bacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of matching comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findByBacino(
		String bacino, int start, int end) {

		return findByBacino(bacino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findByBacino(
		String bacino, int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return findByBacino(bacino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findByBacino(
		String bacino, int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator,
		boolean retrieveFromCache) {

		bacino = Objects.toString(bacino, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByBacino;
			finderArgs = new Object[] {bacino};
		}
		else {
			finderPath = _finderPathWithPaginationFindByBacino;
			finderArgs = new Object[] {bacino, start, end, orderByComparator};
		}

		List<Comuni_bacini_ws> list = null;

		if (retrieveFromCache) {
			list = (List<Comuni_bacini_ws>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comuni_bacini_ws comuni_bacini_ws : list) {
					if (!bacino.equals(comuni_bacini_ws.getBacino())) {
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

			query.append(_SQL_SELECT_COMUNI_BACINI_WS_WHERE);

			boolean bindBacino = false;

			if (bacino.isEmpty()) {
				query.append(_FINDER_COLUMN_BACINO_BACINO_3);
			}
			else {
				bindBacino = true;

				query.append(_FINDER_COLUMN_BACINO_BACINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Comuni_bacini_wsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBacino) {
					qPos.add(bacino);
				}

				if (!pagination) {
					list = (List<Comuni_bacini_ws>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Comuni_bacini_ws>)QueryUtil.list(
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
	 * Returns the first comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a matching comuni_bacini_ws could not be found
	 */
	@Override
	public Comuni_bacini_ws findByBacino_First(
			String bacino,
			OrderByComparator<Comuni_bacini_ws> orderByComparator)
		throws NoSuchComuni_bacini_wsException {

		Comuni_bacini_ws comuni_bacini_ws = fetchByBacino_First(
			bacino, orderByComparator);

		if (comuni_bacini_ws != null) {
			return comuni_bacini_ws;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bacino=");
		msg.append(bacino);

		msg.append("}");

		throw new NoSuchComuni_bacini_wsException(msg.toString());
	}

	/**
	 * Returns the first comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_bacini_ws, or <code>null</code> if a matching comuni_bacini_ws could not be found
	 */
	@Override
	public Comuni_bacini_ws fetchByBacino_First(
		String bacino, OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		List<Comuni_bacini_ws> list = findByBacino(
			bacino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a matching comuni_bacini_ws could not be found
	 */
	@Override
	public Comuni_bacini_ws findByBacino_Last(
			String bacino,
			OrderByComparator<Comuni_bacini_ws> orderByComparator)
		throws NoSuchComuni_bacini_wsException {

		Comuni_bacini_ws comuni_bacini_ws = fetchByBacino_Last(
			bacino, orderByComparator);

		if (comuni_bacini_ws != null) {
			return comuni_bacini_ws;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bacino=");
		msg.append(bacino);

		msg.append("}");

		throw new NoSuchComuni_bacini_wsException(msg.toString());
	}

	/**
	 * Returns the last comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_bacini_ws, or <code>null</code> if a matching comuni_bacini_ws could not be found
	 */
	@Override
	public Comuni_bacini_ws fetchByBacino_Last(
		String bacino, OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		int count = countByBacino(bacino);

		if (count == 0) {
			return null;
		}

		List<Comuni_bacini_ws> list = findByBacino(
			bacino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comuni_bacini_wses before and after the current comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param idBacini the primary key of the current comuni_bacini_ws
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws[] findByBacino_PrevAndNext(
			int idBacini, String bacino,
			OrderByComparator<Comuni_bacini_ws> orderByComparator)
		throws NoSuchComuni_bacini_wsException {

		bacino = Objects.toString(bacino, "");

		Comuni_bacini_ws comuni_bacini_ws = findByPrimaryKey(idBacini);

		Session session = null;

		try {
			session = openSession();

			Comuni_bacini_ws[] array = new Comuni_bacini_wsImpl[3];

			array[0] = getByBacino_PrevAndNext(
				session, comuni_bacini_ws, bacino, orderByComparator, true);

			array[1] = comuni_bacini_ws;

			array[2] = getByBacino_PrevAndNext(
				session, comuni_bacini_ws, bacino, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comuni_bacini_ws getByBacino_PrevAndNext(
		Session session, Comuni_bacini_ws comuni_bacini_ws, String bacino,
		OrderByComparator<Comuni_bacini_ws> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMUNI_BACINI_WS_WHERE);

		boolean bindBacino = false;

		if (bacino.isEmpty()) {
			query.append(_FINDER_COLUMN_BACINO_BACINO_3);
		}
		else {
			bindBacino = true;

			query.append(_FINDER_COLUMN_BACINO_BACINO_2);
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
			query.append(Comuni_bacini_wsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBacino) {
			qPos.add(bacino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						comuni_bacini_ws)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Comuni_bacini_ws> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comuni_bacini_wses where bacino = &#63; from the database.
	 *
	 * @param bacino the bacino
	 */
	@Override
	public void removeByBacino(String bacino) {
		for (Comuni_bacini_ws comuni_bacini_ws :
				findByBacino(
					bacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comuni_bacini_ws);
		}
	}

	/**
	 * Returns the number of comuni_bacini_wses where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @return the number of matching comuni_bacini_wses
	 */
	@Override
	public int countByBacino(String bacino) {
		bacino = Objects.toString(bacino, "");

		FinderPath finderPath = _finderPathCountByBacino;

		Object[] finderArgs = new Object[] {bacino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMUNI_BACINI_WS_WHERE);

			boolean bindBacino = false;

			if (bacino.isEmpty()) {
				query.append(_FINDER_COLUMN_BACINO_BACINO_3);
			}
			else {
				bindBacino = true;

				query.append(_FINDER_COLUMN_BACINO_BACINO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBacino) {
					qPos.add(bacino);
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

	private static final String _FINDER_COLUMN_BACINO_BACINO_2 =
		"comuni_bacini_ws.bacino = ?";

	private static final String _FINDER_COLUMN_BACINO_BACINO_3 =
		"(comuni_bacini_ws.bacino IS NULL OR comuni_bacini_ws.bacino = '')";

	public Comuni_bacini_wsPersistenceImpl() {
		setModelClass(Comuni_bacini_ws.class);
	}

	/**
	 * Caches the comuni_bacini_ws in the entity cache if it is enabled.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 */
	@Override
	public void cacheResult(Comuni_bacini_ws comuni_bacini_ws) {
		entityCache.putResult(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class, comuni_bacini_ws.getPrimaryKey(),
			comuni_bacini_ws);

		comuni_bacini_ws.resetOriginalValues();
	}

	/**
	 * Caches the comuni_bacini_wses in the entity cache if it is enabled.
	 *
	 * @param comuni_bacini_wses the comuni_bacini_wses
	 */
	@Override
	public void cacheResult(List<Comuni_bacini_ws> comuni_bacini_wses) {
		for (Comuni_bacini_ws comuni_bacini_ws : comuni_bacini_wses) {
			if (entityCache.getResult(
					Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
					Comuni_bacini_wsImpl.class,
					comuni_bacini_ws.getPrimaryKey()) == null) {

				cacheResult(comuni_bacini_ws);
			}
			else {
				comuni_bacini_ws.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all comuni_bacini_wses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Comuni_bacini_wsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the comuni_bacini_ws.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comuni_bacini_ws comuni_bacini_ws) {
		entityCache.removeResult(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class, comuni_bacini_ws.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Comuni_bacini_ws> comuni_bacini_wses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Comuni_bacini_ws comuni_bacini_ws : comuni_bacini_wses) {
			entityCache.removeResult(
				Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
				Comuni_bacini_wsImpl.class, comuni_bacini_ws.getPrimaryKey());
		}
	}

	/**
	 * Creates a new comuni_bacini_ws with the primary key. Does not add the comuni_bacini_ws to the database.
	 *
	 * @param idBacini the primary key for the new comuni_bacini_ws
	 * @return the new comuni_bacini_ws
	 */
	@Override
	public Comuni_bacini_ws create(int idBacini) {
		Comuni_bacini_ws comuni_bacini_ws = new Comuni_bacini_wsImpl();

		comuni_bacini_ws.setNew(true);
		comuni_bacini_ws.setPrimaryKey(idBacini);

		return comuni_bacini_ws;
	}

	/**
	 * Removes the comuni_bacini_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws remove(int idBacini)
		throws NoSuchComuni_bacini_wsException {

		return remove((Serializable)idBacini);
	}

	/**
	 * Removes the comuni_bacini_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws remove(Serializable primaryKey)
		throws NoSuchComuni_bacini_wsException {

		Session session = null;

		try {
			session = openSession();

			Comuni_bacini_ws comuni_bacini_ws = (Comuni_bacini_ws)session.get(
				Comuni_bacini_wsImpl.class, primaryKey);

			if (comuni_bacini_ws == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComuni_bacini_wsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(comuni_bacini_ws);
		}
		catch (NoSuchComuni_bacini_wsException nsee) {
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
	protected Comuni_bacini_ws removeImpl(Comuni_bacini_ws comuni_bacini_ws) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comuni_bacini_ws)) {
				comuni_bacini_ws = (Comuni_bacini_ws)session.get(
					Comuni_bacini_wsImpl.class,
					comuni_bacini_ws.getPrimaryKeyObj());
			}

			if (comuni_bacini_ws != null) {
				session.delete(comuni_bacini_ws);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (comuni_bacini_ws != null) {
			clearCache(comuni_bacini_ws);
		}

		return comuni_bacini_ws;
	}

	@Override
	public Comuni_bacini_ws updateImpl(Comuni_bacini_ws comuni_bacini_ws) {
		boolean isNew = comuni_bacini_ws.isNew();

		if (!(comuni_bacini_ws instanceof Comuni_bacini_wsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(comuni_bacini_ws.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					comuni_bacini_ws);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in comuni_bacini_ws proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Comuni_bacini_ws implementation " +
					comuni_bacini_ws.getClass());
		}

		Comuni_bacini_wsModelImpl comuni_bacini_wsModelImpl =
			(Comuni_bacini_wsModelImpl)comuni_bacini_ws;

		Session session = null;

		try {
			session = openSession();

			if (comuni_bacini_ws.isNew()) {
				session.save(comuni_bacini_ws);

				comuni_bacini_ws.setNew(false);
			}
			else {
				comuni_bacini_ws = (Comuni_bacini_ws)session.merge(
					comuni_bacini_ws);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Comuni_bacini_wsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				comuni_bacini_wsModelImpl.getBacino()
			};

			finderCache.removeResult(_finderPathCountByBacino, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByBacino, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((comuni_bacini_wsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByBacino.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					comuni_bacini_wsModelImpl.getOriginalBacino()
				};

				finderCache.removeResult(_finderPathCountByBacino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByBacino, args);

				args = new Object[] {comuni_bacini_wsModelImpl.getBacino()};

				finderCache.removeResult(_finderPathCountByBacino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByBacino, args);
			}
		}

		entityCache.putResult(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class, comuni_bacini_ws.getPrimaryKey(),
			comuni_bacini_ws, false);

		comuni_bacini_ws.resetOriginalValues();

		return comuni_bacini_ws;
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComuni_bacini_wsException {

		Comuni_bacini_ws comuni_bacini_ws = fetchByPrimaryKey(primaryKey);

		if (comuni_bacini_ws == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComuni_bacini_wsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return comuni_bacini_ws;
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key or throws a <code>NoSuchComuni_bacini_wsException</code> if it could not be found.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws findByPrimaryKey(int idBacini)
		throws NoSuchComuni_bacini_wsException {

		return findByPrimaryKey((Serializable)idBacini);
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws, or <code>null</code> if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Comuni_bacini_ws comuni_bacini_ws = (Comuni_bacini_ws)serializable;

		if (comuni_bacini_ws == null) {
			Session session = null;

			try {
				session = openSession();

				comuni_bacini_ws = (Comuni_bacini_ws)session.get(
					Comuni_bacini_wsImpl.class, primaryKey);

				if (comuni_bacini_ws != null) {
					cacheResult(comuni_bacini_ws);
				}
				else {
					entityCache.putResult(
						Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
						Comuni_bacini_wsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
					Comuni_bacini_wsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return comuni_bacini_ws;
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws, or <code>null</code> if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public Comuni_bacini_ws fetchByPrimaryKey(int idBacini) {
		return fetchByPrimaryKey((Serializable)idBacini);
	}

	@Override
	public Map<Serializable, Comuni_bacini_ws> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Comuni_bacini_ws> map =
			new HashMap<Serializable, Comuni_bacini_ws>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Comuni_bacini_ws comuni_bacini_ws = fetchByPrimaryKey(primaryKey);

			if (comuni_bacini_ws != null) {
				map.put(primaryKey, comuni_bacini_ws);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
				Comuni_bacini_wsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Comuni_bacini_ws)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMUNI_BACINI_WS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Comuni_bacini_ws comuni_bacini_ws :
					(List<Comuni_bacini_ws>)q.list()) {

				map.put(comuni_bacini_ws.getPrimaryKeyObj(), comuni_bacini_ws);

				cacheResult(comuni_bacini_ws);

				uncachedPrimaryKeys.remove(comuni_bacini_ws.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
					Comuni_bacini_wsImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the comuni_bacini_wses.
	 *
	 * @return the comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findAll(
		int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of comuni_bacini_wses
	 */
	@Override
	public List<Comuni_bacini_ws> findAll(
		int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator,
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

		List<Comuni_bacini_ws> list = null;

		if (retrieveFromCache) {
			list = (List<Comuni_bacini_ws>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMUNI_BACINI_WS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMUNI_BACINI_WS;

				if (pagination) {
					sql = sql.concat(Comuni_bacini_wsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Comuni_bacini_ws>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Comuni_bacini_ws>)QueryUtil.list(
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
	 * Removes all the comuni_bacini_wses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Comuni_bacini_ws comuni_bacini_ws : findAll()) {
			remove(comuni_bacini_ws);
		}
	}

	/**
	 * Returns the number of comuni_bacini_wses.
	 *
	 * @return the number of comuni_bacini_wses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMUNI_BACINI_WS);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return Comuni_bacini_wsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comuni_bacini_ws persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsModelImpl.FINDER_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsModelImpl.FINDER_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByBacino = new FinderPath(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsModelImpl.FINDER_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBacino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByBacino = new FinderPath(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsModelImpl.FINDER_CACHE_ENABLED,
			Comuni_bacini_wsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBacino",
			new String[] {String.class.getName()},
			Comuni_bacini_wsModelImpl.BACINO_COLUMN_BITMASK);

		_finderPathCountByBacino = new FinderPath(
			Comuni_bacini_wsModelImpl.ENTITY_CACHE_ENABLED,
			Comuni_bacini_wsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBacino",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Comuni_bacini_wsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMUNI_BACINI_WS =
		"SELECT comuni_bacini_ws FROM Comuni_bacini_ws comuni_bacini_ws";

	private static final String _SQL_SELECT_COMUNI_BACINI_WS_WHERE_PKS_IN =
		"SELECT comuni_bacini_ws FROM Comuni_bacini_ws comuni_bacini_ws WHERE idBacini IN (";

	private static final String _SQL_SELECT_COMUNI_BACINI_WS_WHERE =
		"SELECT comuni_bacini_ws FROM Comuni_bacini_ws comuni_bacini_ws WHERE ";

	private static final String _SQL_COUNT_COMUNI_BACINI_WS =
		"SELECT COUNT(comuni_bacini_ws) FROM Comuni_bacini_ws comuni_bacini_ws";

	private static final String _SQL_COUNT_COMUNI_BACINI_WS_WHERE =
		"SELECT COUNT(comuni_bacini_ws) FROM Comuni_bacini_ws comuni_bacini_ws WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "comuni_bacini_ws.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Comuni_bacini_ws exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Comuni_bacini_ws exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Comuni_bacini_wsPersistenceImpl.class);

}