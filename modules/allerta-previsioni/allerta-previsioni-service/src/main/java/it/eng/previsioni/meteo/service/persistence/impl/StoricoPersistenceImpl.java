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

package it.eng.previsioni.meteo.service.persistence.impl;

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

import it.eng.previsioni.meteo.exception.NoSuchStoricoException;
import it.eng.previsioni.meteo.model.Storico;
import it.eng.previsioni.meteo.model.impl.StoricoImpl;
import it.eng.previsioni.meteo.model.impl.StoricoModelImpl;
import it.eng.previsioni.meteo.service.persistence.StoricoPersistence;

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
 * The persistence implementation for the storico service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class StoricoPersistenceImpl
	extends BasePersistenceImpl<Storico> implements StoricoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StoricoUtil</code> to access the storico persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StoricoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySigla;
	private FinderPath _finderPathWithoutPaginationFindBySigla;
	private FinderPath _finderPathCountBySigla;

	/**
	 * Returns all the storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the matching storicos
	 */
	@Override
	public List<Storico> findBySigla(String sigla) {
		return findBySigla(sigla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of matching storicos
	 */
	@Override
	public List<Storico> findBySigla(String sigla, int start, int end) {
		return findBySigla(sigla, start, end, null);
	}

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching storicos
	 */
	@Override
	public List<Storico> findBySigla(
		String sigla, int start, int end,
		OrderByComparator<Storico> orderByComparator) {

		return findBySigla(sigla, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching storicos
	 */
	@Override
	public List<Storico> findBySigla(
		String sigla, int start, int end,
		OrderByComparator<Storico> orderByComparator,
		boolean retrieveFromCache) {

		sigla = Objects.toString(sigla, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBySigla;
			finderArgs = new Object[] {sigla};
		}
		else {
			finderPath = _finderPathWithPaginationFindBySigla;
			finderArgs = new Object[] {sigla, start, end, orderByComparator};
		}

		List<Storico> list = null;

		if (retrieveFromCache) {
			list = (List<Storico>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Storico storico : list) {
					if (!sigla.equals(storico.getSigla())) {
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

			query.append(_SQL_SELECT_STORICO_WHERE);

			boolean bindSigla = false;

			if (sigla.isEmpty()) {
				query.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
			}
			else {
				bindSigla = true;

				query.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StoricoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSigla) {
					qPos.add(sigla);
				}

				if (!pagination) {
					list = (List<Storico>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Storico>)QueryUtil.list(
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
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	@Override
	public Storico findBySigla_First(
			String sigla, OrderByComparator<Storico> orderByComparator)
		throws NoSuchStoricoException {

		Storico storico = fetchBySigla_First(sigla, orderByComparator);

		if (storico != null) {
			return storico;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sigla=");
		msg.append(sigla);

		msg.append("}");

		throw new NoSuchStoricoException(msg.toString());
	}

	/**
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico, or <code>null</code> if a matching storico could not be found
	 */
	@Override
	public Storico fetchBySigla_First(
		String sigla, OrderByComparator<Storico> orderByComparator) {

		List<Storico> list = findBySigla(sigla, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	@Override
	public Storico findBySigla_Last(
			String sigla, OrderByComparator<Storico> orderByComparator)
		throws NoSuchStoricoException {

		Storico storico = fetchBySigla_Last(sigla, orderByComparator);

		if (storico != null) {
			return storico;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sigla=");
		msg.append(sigla);

		msg.append("}");

		throw new NoSuchStoricoException(msg.toString());
	}

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico, or <code>null</code> if a matching storico could not be found
	 */
	@Override
	public Storico fetchBySigla_Last(
		String sigla, OrderByComparator<Storico> orderByComparator) {

		int count = countBySigla(sigla);

		if (count == 0) {
			return null;
		}

		List<Storico> list = findBySigla(
			sigla, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the storicos before and after the current storico in the ordered set where sigla = &#63;.
	 *
	 * @param id the primary key of the current storico
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico[] findBySigla_PrevAndNext(
			long id, String sigla, OrderByComparator<Storico> orderByComparator)
		throws NoSuchStoricoException {

		sigla = Objects.toString(sigla, "");

		Storico storico = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Storico[] array = new StoricoImpl[3];

			array[0] = getBySigla_PrevAndNext(
				session, storico, sigla, orderByComparator, true);

			array[1] = storico;

			array[2] = getBySigla_PrevAndNext(
				session, storico, sigla, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Storico getBySigla_PrevAndNext(
		Session session, Storico storico, String sigla,
		OrderByComparator<Storico> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STORICO_WHERE);

		boolean bindSigla = false;

		if (sigla.isEmpty()) {
			query.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
		}
		else {
			bindSigla = true;

			query.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
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
			query.append(StoricoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSigla) {
			qPos.add(sigla);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(storico)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Storico> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the storicos where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 */
	@Override
	public void removeBySigla(String sigla) {
		for (Storico storico :
				findBySigla(
					sigla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(storico);
		}
	}

	/**
	 * Returns the number of storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching storicos
	 */
	@Override
	public int countBySigla(String sigla) {
		sigla = Objects.toString(sigla, "");

		FinderPath finderPath = _finderPathCountBySigla;

		Object[] finderArgs = new Object[] {sigla};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STORICO_WHERE);

			boolean bindSigla = false;

			if (sigla.isEmpty()) {
				query.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
			}
			else {
				bindSigla = true;

				query.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSigla) {
					qPos.add(sigla);
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

	private static final String _FINDER_COLUMN_SIGLA_SIGLA_2 =
		"storico.sigla = ?";

	private static final String _FINDER_COLUMN_SIGLA_SIGLA_3 =
		"(storico.sigla IS NULL OR storico.sigla = '')";

	public StoricoPersistenceImpl() {
		setModelClass(Storico.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

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
	 * Caches the storico in the entity cache if it is enabled.
	 *
	 * @param storico the storico
	 */
	@Override
	public void cacheResult(Storico storico) {
		entityCache.putResult(
			StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
			storico.getPrimaryKey(), storico);

		storico.resetOriginalValues();
	}

	/**
	 * Caches the storicos in the entity cache if it is enabled.
	 *
	 * @param storicos the storicos
	 */
	@Override
	public void cacheResult(List<Storico> storicos) {
		for (Storico storico : storicos) {
			if (entityCache.getResult(
					StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
					storico.getPrimaryKey()) == null) {

				cacheResult(storico);
			}
			else {
				storico.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all storicos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StoricoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the storico.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Storico storico) {
		entityCache.removeResult(
			StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
			storico.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Storico> storicos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Storico storico : storicos) {
			entityCache.removeResult(
				StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
				storico.getPrimaryKey());
		}
	}

	/**
	 * Creates a new storico with the primary key. Does not add the storico to the database.
	 *
	 * @param id the primary key for the new storico
	 * @return the new storico
	 */
	@Override
	public Storico create(long id) {
		Storico storico = new StoricoImpl();

		storico.setNew(true);
		storico.setPrimaryKey(id);

		return storico;
	}

	/**
	 * Removes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the storico
	 * @return the storico that was removed
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico remove(long id) throws NoSuchStoricoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the storico
	 * @return the storico that was removed
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico remove(Serializable primaryKey)
		throws NoSuchStoricoException {

		Session session = null;

		try {
			session = openSession();

			Storico storico = (Storico)session.get(
				StoricoImpl.class, primaryKey);

			if (storico == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStoricoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(storico);
		}
		catch (NoSuchStoricoException nsee) {
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
	protected Storico removeImpl(Storico storico) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(storico)) {
				storico = (Storico)session.get(
					StoricoImpl.class, storico.getPrimaryKeyObj());
			}

			if (storico != null) {
				session.delete(storico);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (storico != null) {
			clearCache(storico);
		}

		return storico;
	}

	@Override
	public Storico updateImpl(Storico storico) {
		boolean isNew = storico.isNew();

		if (!(storico instanceof StoricoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(storico.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(storico);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in storico proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Storico implementation " +
					storico.getClass());
		}

		StoricoModelImpl storicoModelImpl = (StoricoModelImpl)storico;

		Session session = null;

		try {
			session = openSession();

			if (storico.isNew()) {
				session.save(storico);

				storico.setNew(false);
			}
			else {
				storico = (Storico)session.merge(storico);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StoricoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {storicoModelImpl.getSigla()};

			finderCache.removeResult(_finderPathCountBySigla, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySigla, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((storicoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySigla.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					storicoModelImpl.getOriginalSigla()
				};

				finderCache.removeResult(_finderPathCountBySigla, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySigla, args);

				args = new Object[] {storicoModelImpl.getSigla()};

				finderCache.removeResult(_finderPathCountBySigla, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySigla, args);
			}
		}

		entityCache.putResult(
			StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
			storico.getPrimaryKey(), storico, false);

		storico.resetOriginalValues();

		return storico;
	}

	/**
	 * Returns the storico with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the storico
	 * @return the storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStoricoException {

		Storico storico = fetchByPrimaryKey(primaryKey);

		if (storico == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStoricoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return storico;
	}

	/**
	 * Returns the storico with the primary key or throws a <code>NoSuchStoricoException</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico findByPrimaryKey(long id) throws NoSuchStoricoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the storico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the storico
	 * @return the storico, or <code>null</code> if a storico with the primary key could not be found
	 */
	@Override
	public Storico fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Storico storico = (Storico)serializable;

		if (storico == null) {
			Session session = null;

			try {
				session = openSession();

				storico = (Storico)session.get(StoricoImpl.class, primaryKey);

				if (storico != null) {
					cacheResult(storico);
				}
				else {
					entityCache.putResult(
						StoricoModelImpl.ENTITY_CACHE_ENABLED,
						StoricoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return storico;
	}

	/**
	 * Returns the storico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico, or <code>null</code> if a storico with the primary key could not be found
	 */
	@Override
	public Storico fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Storico> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Storico> map = new HashMap<Serializable, Storico>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Storico storico = fetchByPrimaryKey(primaryKey);

			if (storico != null) {
				map.put(primaryKey, storico);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Storico)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_STORICO_WHERE_PKS_IN);

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

			for (Storico storico : (List<Storico>)q.list()) {
				map.put(storico.getPrimaryKeyObj(), storico);

				cacheResult(storico);

				uncachedPrimaryKeys.remove(storico.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					StoricoModelImpl.ENTITY_CACHE_ENABLED, StoricoImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the storicos.
	 *
	 * @return the storicos
	 */
	@Override
	public List<Storico> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of storicos
	 */
	@Override
	public List<Storico> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of storicos
	 */
	@Override
	public List<Storico> findAll(
		int start, int end, OrderByComparator<Storico> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of storicos
	 */
	@Override
	public List<Storico> findAll(
		int start, int end, OrderByComparator<Storico> orderByComparator,
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

		List<Storico> list = null;

		if (retrieveFromCache) {
			list = (List<Storico>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STORICO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STORICO;

				if (pagination) {
					sql = sql.concat(StoricoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Storico>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Storico>)QueryUtil.list(
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
	 * Removes all the storicos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Storico storico : findAll()) {
			remove(storico);
		}
	}

	/**
	 * Returns the number of storicos.
	 *
	 * @return the number of storicos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STORICO);

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
		return StoricoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the storico persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StoricoModelImpl.ENTITY_CACHE_ENABLED,
			StoricoModelImpl.FINDER_CACHE_ENABLED, StoricoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StoricoModelImpl.ENTITY_CACHE_ENABLED,
			StoricoModelImpl.FINDER_CACHE_ENABLED, StoricoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			StoricoModelImpl.ENTITY_CACHE_ENABLED,
			StoricoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBySigla = new FinderPath(
			StoricoModelImpl.ENTITY_CACHE_ENABLED,
			StoricoModelImpl.FINDER_CACHE_ENABLED, StoricoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySigla",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySigla = new FinderPath(
			StoricoModelImpl.ENTITY_CACHE_ENABLED,
			StoricoModelImpl.FINDER_CACHE_ENABLED, StoricoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySigla",
			new String[] {String.class.getName()},
			StoricoModelImpl.SIGLA_COLUMN_BITMASK);

		_finderPathCountBySigla = new FinderPath(
			StoricoModelImpl.ENTITY_CACHE_ENABLED,
			StoricoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigla",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(StoricoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STORICO =
		"SELECT storico FROM Storico storico";

	private static final String _SQL_SELECT_STORICO_WHERE_PKS_IN =
		"SELECT storico FROM Storico storico WHERE id_ IN (";

	private static final String _SQL_SELECT_STORICO_WHERE =
		"SELECT storico FROM Storico storico WHERE ";

	private static final String _SQL_COUNT_STORICO =
		"SELECT COUNT(storico) FROM Storico storico";

	private static final String _SQL_COUNT_STORICO_WHERE =
		"SELECT COUNT(storico) FROM Storico storico WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "storico.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Storico exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Storico exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StoricoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}