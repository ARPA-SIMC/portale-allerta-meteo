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

package allerta.verifica.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.exception.NoSuchUtenteLavoroException;
import allerta.verifica.model.UtenteLavoro;
import allerta.verifica.model.impl.UtenteLavoroImpl;
import allerta.verifica.model.impl.UtenteLavoroModelImpl;
import allerta.verifica.service.persistence.UtenteLavoroPersistence;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the utente lavoro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UtenteLavoroPersistenceImpl
	extends BasePersistenceImpl<UtenteLavoro>
	implements UtenteLavoroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UtenteLavoroUtil</code> to access the utente lavoro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UtenteLavoroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocumento;
	private FinderPath _finderPathWithoutPaginationFindByDocumento;
	private FinderPath _finderPathCountByDocumento;

	/**
	 * Returns all the utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(long documento) {
		return findByDocumento(
			documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(
		long documento, int start, int end) {

		return findByDocumento(documento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator) {

		return findByDocumento(documento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDocumento;
			finderArgs = new Object[] {documento};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDocumento;
			finderArgs = new Object[] {
				documento, start, end, orderByComparator
			};
		}

		List<UtenteLavoro> list = null;

		if (retrieveFromCache) {
			list = (List<UtenteLavoro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteLavoro utenteLavoro : list) {
					if ((documento != utenteLavoro.getDocumento())) {
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

			query.append(_SQL_SELECT_UTENTELAVORO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UtenteLavoroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (!pagination) {
					list = (List<UtenteLavoro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UtenteLavoro>)QueryUtil.list(
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
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro findByDocumento_First(
			long documento, OrderByComparator<UtenteLavoro> orderByComparator)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = fetchByDocumento_First(
			documento, orderByComparator);

		if (utenteLavoro != null) {
			return utenteLavoro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append("}");

		throw new NoSuchUtenteLavoroException(msg.toString());
	}

	/**
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro fetchByDocumento_First(
		long documento, OrderByComparator<UtenteLavoro> orderByComparator) {

		List<UtenteLavoro> list = findByDocumento(
			documento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro findByDocumento_Last(
			long documento, OrderByComparator<UtenteLavoro> orderByComparator)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = fetchByDocumento_Last(
			documento, orderByComparator);

		if (utenteLavoro != null) {
			return utenteLavoro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append("}");

		throw new NoSuchUtenteLavoroException(msg.toString());
	}

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro fetchByDocumento_Last(
		long documento, OrderByComparator<UtenteLavoro> orderByComparator) {

		int count = countByDocumento(documento);

		if (count == 0) {
			return null;
		}

		List<UtenteLavoro> list = findByDocumento(
			documento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente lavoros before and after the current utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current utente lavoro
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<UtenteLavoro> orderByComparator)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UtenteLavoro[] array = new UtenteLavoroImpl[3];

			array[0] = getByDocumento_PrevAndNext(
				session, utenteLavoro, documento, orderByComparator, true);

			array[1] = utenteLavoro;

			array[2] = getByDocumento_PrevAndNext(
				session, utenteLavoro, documento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UtenteLavoro getByDocumento_PrevAndNext(
		Session session, UtenteLavoro utenteLavoro, long documento,
		OrderByComparator<UtenteLavoro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UTENTELAVORO_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

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
			query.append(UtenteLavoroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(utenteLavoro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UtenteLavoro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente lavoros where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	@Override
	public void removeByDocumento(long documento) {
		for (UtenteLavoro utenteLavoro :
				findByDocumento(
					documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(utenteLavoro);
		}
	}

	/**
	 * Returns the number of utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching utente lavoros
	 */
	@Override
	public int countByDocumento(long documento) {
		FinderPath finderPath = _finderPathCountByDocumento;

		Object[] finderArgs = new Object[] {documento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UTENTELAVORO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

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

	private static final String _FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2 =
		"utenteLavoro.documento = ?";

	public UtenteLavoroPersistenceImpl() {
		setModelClass(UtenteLavoro.class);

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
	 * Caches the utente lavoro in the entity cache if it is enabled.
	 *
	 * @param utenteLavoro the utente lavoro
	 */
	@Override
	public void cacheResult(UtenteLavoro utenteLavoro) {
		entityCache.putResult(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED, UtenteLavoroImpl.class,
			utenteLavoro.getPrimaryKey(), utenteLavoro);

		utenteLavoro.resetOriginalValues();
	}

	/**
	 * Caches the utente lavoros in the entity cache if it is enabled.
	 *
	 * @param utenteLavoros the utente lavoros
	 */
	@Override
	public void cacheResult(List<UtenteLavoro> utenteLavoros) {
		for (UtenteLavoro utenteLavoro : utenteLavoros) {
			if (entityCache.getResult(
					UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
					UtenteLavoroImpl.class, utenteLavoro.getPrimaryKey()) ==
						null) {

				cacheResult(utenteLavoro);
			}
			else {
				utenteLavoro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all utente lavoros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UtenteLavoroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the utente lavoro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UtenteLavoro utenteLavoro) {
		entityCache.removeResult(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED, UtenteLavoroImpl.class,
			utenteLavoro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UtenteLavoro> utenteLavoros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UtenteLavoro utenteLavoro : utenteLavoros) {
			entityCache.removeResult(
				UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
				UtenteLavoroImpl.class, utenteLavoro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new utente lavoro with the primary key. Does not add the utente lavoro to the database.
	 *
	 * @param id the primary key for the new utente lavoro
	 * @return the new utente lavoro
	 */
	@Override
	public UtenteLavoro create(long id) {
		UtenteLavoro utenteLavoro = new UtenteLavoroImpl();

		utenteLavoro.setNew(true);
		utenteLavoro.setPrimaryKey(id);

		return utenteLavoro;
	}

	/**
	 * Removes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro remove(long id) throws NoSuchUtenteLavoroException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro remove(Serializable primaryKey)
		throws NoSuchUtenteLavoroException {

		Session session = null;

		try {
			session = openSession();

			UtenteLavoro utenteLavoro = (UtenteLavoro)session.get(
				UtenteLavoroImpl.class, primaryKey);

			if (utenteLavoro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUtenteLavoroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(utenteLavoro);
		}
		catch (NoSuchUtenteLavoroException nsee) {
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
	protected UtenteLavoro removeImpl(UtenteLavoro utenteLavoro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(utenteLavoro)) {
				utenteLavoro = (UtenteLavoro)session.get(
					UtenteLavoroImpl.class, utenteLavoro.getPrimaryKeyObj());
			}

			if (utenteLavoro != null) {
				session.delete(utenteLavoro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (utenteLavoro != null) {
			clearCache(utenteLavoro);
		}

		return utenteLavoro;
	}

	@Override
	public UtenteLavoro updateImpl(UtenteLavoro utenteLavoro) {
		boolean isNew = utenteLavoro.isNew();

		if (!(utenteLavoro instanceof UtenteLavoroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(utenteLavoro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					utenteLavoro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in utenteLavoro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UtenteLavoro implementation " +
					utenteLavoro.getClass());
		}

		UtenteLavoroModelImpl utenteLavoroModelImpl =
			(UtenteLavoroModelImpl)utenteLavoro;

		Session session = null;

		try {
			session = openSession();

			if (utenteLavoro.isNew()) {
				session.save(utenteLavoro);

				utenteLavoro.setNew(false);
			}
			else {
				utenteLavoro = (UtenteLavoro)session.merge(utenteLavoro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UtenteLavoroModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {utenteLavoroModelImpl.getDocumento()};

			finderCache.removeResult(_finderPathCountByDocumento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumento, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((utenteLavoroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					utenteLavoroModelImpl.getOriginalDocumento()
				};

				finderCache.removeResult(_finderPathCountByDocumento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumento, args);

				args = new Object[] {utenteLavoroModelImpl.getDocumento()};

				finderCache.removeResult(_finderPathCountByDocumento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumento, args);
			}
		}

		entityCache.putResult(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED, UtenteLavoroImpl.class,
			utenteLavoro.getPrimaryKey(), utenteLavoro, false);

		utenteLavoro.resetOriginalValues();

		return utenteLavoro;
	}

	/**
	 * Returns the utente lavoro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = fetchByPrimaryKey(primaryKey);

		if (utenteLavoro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUtenteLavoroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return utenteLavoro;
	}

	/**
	 * Returns the utente lavoro with the primary key or throws a <code>NoSuchUtenteLavoroException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro findByPrimaryKey(long id)
		throws NoSuchUtenteLavoroException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the utente lavoro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utente lavoro
	 * @return the utente lavoro, or <code>null</code> if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED, UtenteLavoroImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UtenteLavoro utenteLavoro = (UtenteLavoro)serializable;

		if (utenteLavoro == null) {
			Session session = null;

			try {
				session = openSession();

				utenteLavoro = (UtenteLavoro)session.get(
					UtenteLavoroImpl.class, primaryKey);

				if (utenteLavoro != null) {
					cacheResult(utenteLavoro);
				}
				else {
					entityCache.putResult(
						UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
						UtenteLavoroImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
					UtenteLavoroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return utenteLavoro;
	}

	/**
	 * Returns the utente lavoro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro, or <code>null</code> if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, UtenteLavoro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UtenteLavoro> map =
			new HashMap<Serializable, UtenteLavoro>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UtenteLavoro utenteLavoro = fetchByPrimaryKey(primaryKey);

			if (utenteLavoro != null) {
				map.put(primaryKey, utenteLavoro);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
				UtenteLavoroImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UtenteLavoro)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_UTENTELAVORO_WHERE_PKS_IN);

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

			for (UtenteLavoro utenteLavoro : (List<UtenteLavoro>)q.list()) {
				map.put(utenteLavoro.getPrimaryKeyObj(), utenteLavoro);

				cacheResult(utenteLavoro);

				uncachedPrimaryKeys.remove(utenteLavoro.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
					UtenteLavoroImpl.class, primaryKey, nullModel);
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
	 * Returns all the utente lavoros.
	 *
	 * @return the utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll(
		int start, int end, OrderByComparator<UtenteLavoro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll(
		int start, int end, OrderByComparator<UtenteLavoro> orderByComparator,
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

		List<UtenteLavoro> list = null;

		if (retrieveFromCache) {
			list = (List<UtenteLavoro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_UTENTELAVORO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UTENTELAVORO;

				if (pagination) {
					sql = sql.concat(UtenteLavoroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UtenteLavoro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UtenteLavoro>)QueryUtil.list(
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
	 * Removes all the utente lavoros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UtenteLavoro utenteLavoro : findAll()) {
			remove(utenteLavoro);
		}
	}

	/**
	 * Returns the number of utente lavoros.
	 *
	 * @return the number of utente lavoros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UTENTELAVORO);

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
		return UtenteLavoroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the utente lavoro persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
			UtenteLavoroModelImpl.FINDER_CACHE_ENABLED, UtenteLavoroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
			UtenteLavoroModelImpl.FINDER_CACHE_ENABLED, UtenteLavoroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
			UtenteLavoroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDocumento = new FinderPath(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
			UtenteLavoroModelImpl.FINDER_CACHE_ENABLED, UtenteLavoroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumento",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumento = new FinderPath(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
			UtenteLavoroModelImpl.FINDER_CACHE_ENABLED, UtenteLavoroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumento",
			new String[] {Long.class.getName()},
			UtenteLavoroModelImpl.DOCUMENTO_COLUMN_BITMASK |
			UtenteLavoroModelImpl.TS_COLUMN_BITMASK);

		_finderPathCountByDocumento = new FinderPath(
			UtenteLavoroModelImpl.ENTITY_CACHE_ENABLED,
			UtenteLavoroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumento",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(UtenteLavoroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_UTENTELAVORO =
		"SELECT utenteLavoro FROM UtenteLavoro utenteLavoro";

	private static final String _SQL_SELECT_UTENTELAVORO_WHERE_PKS_IN =
		"SELECT utenteLavoro FROM UtenteLavoro utenteLavoro WHERE id_ IN (";

	private static final String _SQL_SELECT_UTENTELAVORO_WHERE =
		"SELECT utenteLavoro FROM UtenteLavoro utenteLavoro WHERE ";

	private static final String _SQL_COUNT_UTENTELAVORO =
		"SELECT COUNT(utenteLavoro) FROM UtenteLavoro utenteLavoro";

	private static final String _SQL_COUNT_UTENTELAVORO_WHERE =
		"SELECT COUNT(utenteLavoro) FROM UtenteLavoro utenteLavoro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "utenteLavoro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UtenteLavoro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UtenteLavoro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UtenteLavoroPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}