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

package it.eng.allerta.messages.services.service.persistence.impl;

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

import it.eng.allerta.messages.services.exception.NoSuchParametroException;
import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.model.impl.ParametroImpl;
import it.eng.allerta.messages.services.model.impl.ParametroModelImpl;
import it.eng.allerta.messages.services.service.persistence.ParametroPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
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
 * The persistence implementation for the parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class ParametroPersistenceImpl
	extends BasePersistenceImpl<Parametro> implements ParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParametroUtil</code> to access the parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBynodo;
	private FinderPath _finderPathWithoutPaginationFindBynodo;
	private FinderPath _finderPathCountBynodo;

	/**
	 * Returns all the parametros where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @return the matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(String nodo) {
		return findBynodo(nodo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(String nodo, int start, int end) {
		return findBynodo(nodo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(
		String nodo, int start, int end,
		OrderByComparator<Parametro> orderByComparator) {

		return findBynodo(nodo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(
		String nodo, int start, int end,
		OrderByComparator<Parametro> orderByComparator,
		boolean retrieveFromCache) {

		nodo = Objects.toString(nodo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBynodo;
			finderArgs = new Object[] {nodo};
		}
		else {
			finderPath = _finderPathWithPaginationFindBynodo;
			finderArgs = new Object[] {nodo, start, end, orderByComparator};
		}

		List<Parametro> list = null;

		if (retrieveFromCache) {
			list = (List<Parametro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Parametro parametro : list) {
					if (!nodo.equals(parametro.getNodo())) {
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

			query.append(_SQL_SELECT_PARAMETRO_WHERE);

			boolean bindNodo = false;

			if (nodo.isEmpty()) {
				query.append(_FINDER_COLUMN_NODO_NODO_3);
			}
			else {
				bindNodo = true;

				query.append(_FINDER_COLUMN_NODO_NODO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ParametroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNodo) {
					qPos.add(nodo);
				}

				if (!pagination) {
					list = (List<Parametro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Parametro>)QueryUtil.list(
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
	 * Returns the first parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parametro
	 * @throws NoSuchParametroException if a matching parametro could not be found
	 */
	@Override
	public Parametro findBynodo_First(
			String nodo, OrderByComparator<Parametro> orderByComparator)
		throws NoSuchParametroException {

		Parametro parametro = fetchBynodo_First(nodo, orderByComparator);

		if (parametro != null) {
			return parametro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nodo=");
		msg.append(nodo);

		msg.append("}");

		throw new NoSuchParametroException(msg.toString());
	}

	/**
	 * Returns the first parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parametro, or <code>null</code> if a matching parametro could not be found
	 */
	@Override
	public Parametro fetchBynodo_First(
		String nodo, OrderByComparator<Parametro> orderByComparator) {

		List<Parametro> list = findBynodo(nodo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parametro
	 * @throws NoSuchParametroException if a matching parametro could not be found
	 */
	@Override
	public Parametro findBynodo_Last(
			String nodo, OrderByComparator<Parametro> orderByComparator)
		throws NoSuchParametroException {

		Parametro parametro = fetchBynodo_Last(nodo, orderByComparator);

		if (parametro != null) {
			return parametro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nodo=");
		msg.append(nodo);

		msg.append("}");

		throw new NoSuchParametroException(msg.toString());
	}

	/**
	 * Returns the last parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parametro, or <code>null</code> if a matching parametro could not be found
	 */
	@Override
	public Parametro fetchBynodo_Last(
		String nodo, OrderByComparator<Parametro> orderByComparator) {

		int count = countBynodo(nodo);

		if (count == 0) {
			return null;
		}

		List<Parametro> list = findBynodo(
			nodo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the parametros before and after the current parametro in the ordered set where nodo = &#63;.
	 *
	 * @param Id the primary key of the current parametro
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro[] findBynodo_PrevAndNext(
			long Id, String nodo,
			OrderByComparator<Parametro> orderByComparator)
		throws NoSuchParametroException {

		nodo = Objects.toString(nodo, "");

		Parametro parametro = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			Parametro[] array = new ParametroImpl[3];

			array[0] = getBynodo_PrevAndNext(
				session, parametro, nodo, orderByComparator, true);

			array[1] = parametro;

			array[2] = getBynodo_PrevAndNext(
				session, parametro, nodo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Parametro getBynodo_PrevAndNext(
		Session session, Parametro parametro, String nodo,
		OrderByComparator<Parametro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARAMETRO_WHERE);

		boolean bindNodo = false;

		if (nodo.isEmpty()) {
			query.append(_FINDER_COLUMN_NODO_NODO_3);
		}
		else {
			bindNodo = true;

			query.append(_FINDER_COLUMN_NODO_NODO_2);
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
			query.append(ParametroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNodo) {
			qPos.add(nodo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(parametro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Parametro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the parametros where nodo = &#63; from the database.
	 *
	 * @param nodo the nodo
	 */
	@Override
	public void removeBynodo(String nodo) {
		for (Parametro parametro :
				findBynodo(nodo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(parametro);
		}
	}

	/**
	 * Returns the number of parametros where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @return the number of matching parametros
	 */
	@Override
	public int countBynodo(String nodo) {
		nodo = Objects.toString(nodo, "");

		FinderPath finderPath = _finderPathCountBynodo;

		Object[] finderArgs = new Object[] {nodo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PARAMETRO_WHERE);

			boolean bindNodo = false;

			if (nodo.isEmpty()) {
				query.append(_FINDER_COLUMN_NODO_NODO_3);
			}
			else {
				bindNodo = true;

				query.append(_FINDER_COLUMN_NODO_NODO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNodo) {
					qPos.add(nodo);
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

	private static final String _FINDER_COLUMN_NODO_NODO_2 =
		"parametro.nodo = ?";

	private static final String _FINDER_COLUMN_NODO_NODO_3 =
		"(parametro.nodo IS NULL OR parametro.nodo = '')";

	public ParametroPersistenceImpl() {
		setModelClass(Parametro.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the parametro in the entity cache if it is enabled.
	 *
	 * @param parametro the parametro
	 */
	@Override
	public void cacheResult(Parametro parametro) {
		entityCache.putResult(
			ParametroModelImpl.ENTITY_CACHE_ENABLED, ParametroImpl.class,
			parametro.getPrimaryKey(), parametro);

		parametro.resetOriginalValues();
	}

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	@Override
	public void cacheResult(List<Parametro> parametros) {
		for (Parametro parametro : parametros) {
			if (entityCache.getResult(
					ParametroModelImpl.ENTITY_CACHE_ENABLED,
					ParametroImpl.class, parametro.getPrimaryKey()) == null) {

				cacheResult(parametro);
			}
			else {
				parametro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParametroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametro parametro) {
		entityCache.removeResult(
			ParametroModelImpl.ENTITY_CACHE_ENABLED, ParametroImpl.class,
			parametro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Parametro> parametros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Parametro parametro : parametros) {
			entityCache.removeResult(
				ParametroModelImpl.ENTITY_CACHE_ENABLED, ParametroImpl.class,
				parametro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param Id the primary key for the new parametro
	 * @return the new parametro
	 */
	@Override
	public Parametro create(long Id) {
		Parametro parametro = new ParametroImpl();

		parametro.setNew(true);
		parametro.setPrimaryKey(Id);

		return parametro;
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro remove(long Id) throws NoSuchParametroException {
		return remove((Serializable)Id);
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro remove(Serializable primaryKey)
		throws NoSuchParametroException {

		Session session = null;

		try {
			session = openSession();

			Parametro parametro = (Parametro)session.get(
				ParametroImpl.class, primaryKey);

			if (parametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(parametro);
		}
		catch (NoSuchParametroException nsee) {
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
	protected Parametro removeImpl(Parametro parametro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parametro)) {
				parametro = (Parametro)session.get(
					ParametroImpl.class, parametro.getPrimaryKeyObj());
			}

			if (parametro != null) {
				session.delete(parametro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (parametro != null) {
			clearCache(parametro);
		}

		return parametro;
	}

	@Override
	public Parametro updateImpl(Parametro parametro) {
		boolean isNew = parametro.isNew();

		if (!(parametro instanceof ParametroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(parametro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(parametro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in parametro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Parametro implementation " +
					parametro.getClass());
		}

		ParametroModelImpl parametroModelImpl = (ParametroModelImpl)parametro;

		Session session = null;

		try {
			session = openSession();

			if (parametro.isNew()) {
				session.save(parametro);

				parametro.setNew(false);
			}
			else {
				parametro = (Parametro)session.merge(parametro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ParametroModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {parametroModelImpl.getNodo()};

			finderCache.removeResult(_finderPathCountBynodo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBynodo, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((parametroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBynodo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					parametroModelImpl.getOriginalNodo()
				};

				finderCache.removeResult(_finderPathCountBynodo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBynodo, args);

				args = new Object[] {parametroModelImpl.getNodo()};

				finderCache.removeResult(_finderPathCountBynodo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBynodo, args);
			}
		}

		entityCache.putResult(
			ParametroModelImpl.ENTITY_CACHE_ENABLED, ParametroImpl.class,
			parametro.getPrimaryKey(), parametro, false);

		parametro.resetOriginalValues();

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParametroException {

		Parametro parametro = fetchByPrimaryKey(primaryKey);

		if (parametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>NoSuchParametroException</code> if it could not be found.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro findByPrimaryKey(long Id) throws NoSuchParametroException {
		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ParametroModelImpl.ENTITY_CACHE_ENABLED, ParametroImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Parametro parametro = (Parametro)serializable;

		if (parametro == null) {
			Session session = null;

			try {
				session = openSession();

				parametro = (Parametro)session.get(
					ParametroImpl.class, primaryKey);

				if (parametro != null) {
					cacheResult(parametro);
				}
				else {
					entityCache.putResult(
						ParametroModelImpl.ENTITY_CACHE_ENABLED,
						ParametroImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ParametroModelImpl.ENTITY_CACHE_ENABLED,
					ParametroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	@Override
	public Map<Serializable, Parametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Parametro> map =
			new HashMap<Serializable, Parametro>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Parametro parametro = fetchByPrimaryKey(primaryKey);

			if (parametro != null) {
				map.put(primaryKey, parametro);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ParametroModelImpl.ENTITY_CACHE_ENABLED, ParametroImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Parametro)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PARAMETRO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Parametro parametro : (List<Parametro>)q.list()) {
				map.put(parametro.getPrimaryKeyObj(), parametro);

				cacheResult(parametro);

				uncachedPrimaryKeys.remove(parametro.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ParametroModelImpl.ENTITY_CACHE_ENABLED,
					ParametroImpl.class, primaryKey, nullModel);
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
	 * Returns all the parametros.
	 *
	 * @return the parametros
	 */
	@Override
	public List<Parametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 */
	@Override
	public List<Parametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametros
	 */
	@Override
	public List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of parametros
	 */
	@Override
	public List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator,
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

		List<Parametro> list = null;

		if (retrieveFromCache) {
			list = (List<Parametro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PARAMETRO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETRO;

				if (pagination) {
					sql = sql.concat(ParametroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Parametro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Parametro>)QueryUtil.list(
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
	 * Removes all the parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Parametro parametro : findAll()) {
			remove(parametro);
		}
	}

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PARAMETRO);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the parametro persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, ParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, ParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBynodo = new FinderPath(
			ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, ParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynodo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBynodo = new FinderPath(
			ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, ParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynodo",
			new String[] {String.class.getName()},
			ParametroModelImpl.NODO_COLUMN_BITMASK);

		_finderPathCountBynodo = new FinderPath(
			ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynodo",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ParametroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PARAMETRO =
		"SELECT parametro FROM Parametro parametro";

	private static final String _SQL_SELECT_PARAMETRO_WHERE_PKS_IN =
		"SELECT parametro FROM Parametro parametro WHERE Id IN (";

	private static final String _SQL_SELECT_PARAMETRO_WHERE =
		"SELECT parametro FROM Parametro parametro WHERE ";

	private static final String _SQL_COUNT_PARAMETRO =
		"SELECT COUNT(parametro) FROM Parametro parametro";

	private static final String _SQL_COUNT_PARAMETRO_WHERE =
		"SELECT COUNT(parametro) FROM Parametro parametro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "parametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Parametro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Parametro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ParametroPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

}