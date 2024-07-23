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

package allerta.dewetra.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.dewetra.exception.NoSuchHRWException;
import allerta.dewetra.model.HRW;
import allerta.dewetra.model.impl.HRWImpl;
import allerta.dewetra.model.impl.HRWModelImpl;
import allerta.dewetra.service.persistence.HRWPersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the hrw service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class HRWPersistenceImpl
	extends BasePersistenceImpl<HRW> implements HRWPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HRWUtil</code> to access the hrw persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HRWImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByComune;
	private FinderPath _finderPathWithoutPaginationFindByComune;
	private FinderPath _finderPathCountByComune;

	/**
	 * Returns all the hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the matching hrws
	 */
	@Override
	public List<HRW> findByComune(String comune) {
		return findByComune(comune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of matching hrws
	 */
	@Override
	public List<HRW> findByComune(String comune, int start, int end) {
		return findByComune(comune, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hrws
	 */
	@Override
	public List<HRW> findByComune(
		String comune, int start, int end,
		OrderByComparator<HRW> orderByComparator) {

		return findByComune(comune, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching hrws
	 */
	@Override
	public List<HRW> findByComune(
		String comune, int start, int end,
		OrderByComparator<HRW> orderByComparator, boolean retrieveFromCache) {

		comune = Objects.toString(comune, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByComune;
			finderArgs = new Object[] {comune};
		}
		else {
			finderPath = _finderPathWithPaginationFindByComune;
			finderArgs = new Object[] {comune, start, end, orderByComparator};
		}

		List<HRW> list = null;

		if (retrieveFromCache) {
			list = (List<HRW>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HRW hrw : list) {
					if (!comune.equals(hrw.getComune())) {
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

			query.append(_SQL_SELECT_HRW_WHERE);

			boolean bindComune = false;

			if (comune.isEmpty()) {
				query.append(_FINDER_COLUMN_COMUNE_COMUNE_3);
			}
			else {
				bindComune = true;

				query.append(_FINDER_COLUMN_COMUNE_COMUNE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(HRWModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComune) {
					qPos.add(comune);
				}

				if (!pagination) {
					list = (List<HRW>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HRW>)QueryUtil.list(
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
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	@Override
	public HRW findByComune_First(
			String comune, OrderByComparator<HRW> orderByComparator)
		throws NoSuchHRWException {

		HRW hrw = fetchByComune_First(comune, orderByComparator);

		if (hrw != null) {
			return hrw;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("comune=");
		msg.append(comune);

		msg.append("}");

		throw new NoSuchHRWException(msg.toString());
	}

	/**
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	@Override
	public HRW fetchByComune_First(
		String comune, OrderByComparator<HRW> orderByComparator) {

		List<HRW> list = findByComune(comune, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	@Override
	public HRW findByComune_Last(
			String comune, OrderByComparator<HRW> orderByComparator)
		throws NoSuchHRWException {

		HRW hrw = fetchByComune_Last(comune, orderByComparator);

		if (hrw != null) {
			return hrw;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("comune=");
		msg.append(comune);

		msg.append("}");

		throw new NoSuchHRWException(msg.toString());
	}

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	@Override
	public HRW fetchByComune_Last(
		String comune, OrderByComparator<HRW> orderByComparator) {

		int count = countByComune(comune);

		if (count == 0) {
			return null;
		}

		List<HRW> list = findByComune(
			comune, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hrws before and after the current hrw in the ordered set where comune = &#63;.
	 *
	 * @param id the primary key of the current hrw
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW[] findByComune_PrevAndNext(
			long id, String comune, OrderByComparator<HRW> orderByComparator)
		throws NoSuchHRWException {

		comune = Objects.toString(comune, "");

		HRW hrw = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HRW[] array = new HRWImpl[3];

			array[0] = getByComune_PrevAndNext(
				session, hrw, comune, orderByComparator, true);

			array[1] = hrw;

			array[2] = getByComune_PrevAndNext(
				session, hrw, comune, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HRW getByComune_PrevAndNext(
		Session session, HRW hrw, String comune,
		OrderByComparator<HRW> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HRW_WHERE);

		boolean bindComune = false;

		if (comune.isEmpty()) {
			query.append(_FINDER_COLUMN_COMUNE_COMUNE_3);
		}
		else {
			bindComune = true;

			query.append(_FINDER_COLUMN_COMUNE_COMUNE_2);
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
			query.append(HRWModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindComune) {
			qPos.add(comune);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(hrw)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<HRW> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hrws where comune = &#63; from the database.
	 *
	 * @param comune the comune
	 */
	@Override
	public void removeByComune(String comune) {
		for (HRW hrw :
				findByComune(
					comune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(hrw);
		}
	}

	/**
	 * Returns the number of hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the number of matching hrws
	 */
	@Override
	public int countByComune(String comune) {
		comune = Objects.toString(comune, "");

		FinderPath finderPath = _finderPathCountByComune;

		Object[] finderArgs = new Object[] {comune};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HRW_WHERE);

			boolean bindComune = false;

			if (comune.isEmpty()) {
				query.append(_FINDER_COLUMN_COMUNE_COMUNE_3);
			}
			else {
				bindComune = true;

				query.append(_FINDER_COLUMN_COMUNE_COMUNE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComune) {
					qPos.add(comune);
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

	private static final String _FINDER_COLUMN_COMUNE_COMUNE_2 =
		"hrw.comune = ?";

	private static final String _FINDER_COLUMN_COMUNE_COMUNE_3 =
		"(hrw.comune IS NULL OR hrw.comune = '')";

	public HRWPersistenceImpl() {
		setModelClass(HRW.class);

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
	 * Caches the hrw in the entity cache if it is enabled.
	 *
	 * @param hrw the hrw
	 */
	@Override
	public void cacheResult(HRW hrw) {
		entityCache.putResult(
			HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
			hrw.getPrimaryKey(), hrw);

		hrw.resetOriginalValues();
	}

	/**
	 * Caches the hrws in the entity cache if it is enabled.
	 *
	 * @param hrws the hrws
	 */
	@Override
	public void cacheResult(List<HRW> hrws) {
		for (HRW hrw : hrws) {
			if (entityCache.getResult(
					HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
					hrw.getPrimaryKey()) == null) {

				cacheResult(hrw);
			}
			else {
				hrw.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hrws.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HRWImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hrw.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HRW hrw) {
		entityCache.removeResult(
			HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
			hrw.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HRW> hrws) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HRW hrw : hrws) {
			entityCache.removeResult(
				HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
				hrw.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hrw with the primary key. Does not add the hrw to the database.
	 *
	 * @param id the primary key for the new hrw
	 * @return the new hrw
	 */
	@Override
	public HRW create(long id) {
		HRW hrw = new HRWImpl();

		hrw.setNew(true);
		hrw.setPrimaryKey(id);

		return hrw;
	}

	/**
	 * Removes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW remove(long id) throws NoSuchHRWException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW remove(Serializable primaryKey) throws NoSuchHRWException {
		Session session = null;

		try {
			session = openSession();

			HRW hrw = (HRW)session.get(HRWImpl.class, primaryKey);

			if (hrw == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHRWException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(hrw);
		}
		catch (NoSuchHRWException nsee) {
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
	protected HRW removeImpl(HRW hrw) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hrw)) {
				hrw = (HRW)session.get(HRWImpl.class, hrw.getPrimaryKeyObj());
			}

			if (hrw != null) {
				session.delete(hrw);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (hrw != null) {
			clearCache(hrw);
		}

		return hrw;
	}

	@Override
	public HRW updateImpl(HRW hrw) {
		boolean isNew = hrw.isNew();

		if (!(hrw instanceof HRWModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(hrw.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(hrw);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in hrw proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HRW implementation " +
					hrw.getClass());
		}

		HRWModelImpl hrwModelImpl = (HRWModelImpl)hrw;

		Session session = null;

		try {
			session = openSession();

			if (hrw.isNew()) {
				session.save(hrw);

				hrw.setNew(false);
			}
			else {
				hrw = (HRW)session.merge(hrw);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HRWModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {hrwModelImpl.getComune()};

			finderCache.removeResult(_finderPathCountByComune, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByComune, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((hrwModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByComune.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {hrwModelImpl.getOriginalComune()};

				finderCache.removeResult(_finderPathCountByComune, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByComune, args);

				args = new Object[] {hrwModelImpl.getComune()};

				finderCache.removeResult(_finderPathCountByComune, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByComune, args);
			}
		}

		entityCache.putResult(
			HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
			hrw.getPrimaryKey(), hrw, false);

		hrw.resetOriginalValues();

		return hrw;
	}

	/**
	 * Returns the hrw with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hrw
	 * @return the hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHRWException {

		HRW hrw = fetchByPrimaryKey(primaryKey);

		if (hrw == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHRWException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return hrw;
	}

	/**
	 * Returns the hrw with the primary key or throws a <code>NoSuchHRWException</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW findByPrimaryKey(long id) throws NoSuchHRWException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the hrw with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hrw
	 * @return the hrw, or <code>null</code> if a hrw with the primary key could not be found
	 */
	@Override
	public HRW fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		HRW hrw = (HRW)serializable;

		if (hrw == null) {
			Session session = null;

			try {
				session = openSession();

				hrw = (HRW)session.get(HRWImpl.class, primaryKey);

				if (hrw != null) {
					cacheResult(hrw);
				}
				else {
					entityCache.putResult(
						HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return hrw;
	}

	/**
	 * Returns the hrw with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw, or <code>null</code> if a hrw with the primary key could not be found
	 */
	@Override
	public HRW fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, HRW> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, HRW> map = new HashMap<Serializable, HRW>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			HRW hrw = fetchByPrimaryKey(primaryKey);

			if (hrw != null) {
				map.put(primaryKey, hrw);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (HRW)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_HRW_WHERE_PKS_IN);

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

			for (HRW hrw : (List<HRW>)q.list()) {
				map.put(hrw.getPrimaryKeyObj(), hrw);

				cacheResult(hrw);

				uncachedPrimaryKeys.remove(hrw.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					HRWModelImpl.ENTITY_CACHE_ENABLED, HRWImpl.class,
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
	 * Returns all the hrws.
	 *
	 * @return the hrws
	 */
	@Override
	public List<HRW> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of hrws
	 */
	@Override
	public List<HRW> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hrws
	 */
	@Override
	public List<HRW> findAll(
		int start, int end, OrderByComparator<HRW> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of hrws
	 */
	@Override
	public List<HRW> findAll(
		int start, int end, OrderByComparator<HRW> orderByComparator,
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

		List<HRW> list = null;

		if (retrieveFromCache) {
			list = (List<HRW>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HRW);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HRW;

				if (pagination) {
					sql = sql.concat(HRWModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HRW>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HRW>)QueryUtil.list(
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
	 * Removes all the hrws from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HRW hrw : findAll()) {
			remove(hrw);
		}
	}

	/**
	 * Returns the number of hrws.
	 *
	 * @return the number of hrws
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HRW);

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
		return HRWModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hrw persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			HRWModelImpl.ENTITY_CACHE_ENABLED,
			HRWModelImpl.FINDER_CACHE_ENABLED, HRWImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			HRWModelImpl.ENTITY_CACHE_ENABLED,
			HRWModelImpl.FINDER_CACHE_ENABLED, HRWImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			HRWModelImpl.ENTITY_CACHE_ENABLED,
			HRWModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByComune = new FinderPath(
			HRWModelImpl.ENTITY_CACHE_ENABLED,
			HRWModelImpl.FINDER_CACHE_ENABLED, HRWImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComune",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByComune = new FinderPath(
			HRWModelImpl.ENTITY_CACHE_ENABLED,
			HRWModelImpl.FINDER_CACHE_ENABLED, HRWImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByComune",
			new String[] {String.class.getName()},
			HRWModelImpl.COMUNE_COLUMN_BITMASK);

		_finderPathCountByComune = new FinderPath(
			HRWModelImpl.ENTITY_CACHE_ENABLED,
			HRWModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByComune",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(HRWImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_HRW = "SELECT hrw FROM HRW hrw";

	private static final String _SQL_SELECT_HRW_WHERE_PKS_IN =
		"SELECT hrw FROM HRW hrw WHERE id_ IN (";

	private static final String _SQL_SELECT_HRW_WHERE =
		"SELECT hrw FROM HRW hrw WHERE ";

	private static final String _SQL_COUNT_HRW =
		"SELECT COUNT(hrw) FROM HRW hrw";

	private static final String _SQL_COUNT_HRW_WHERE =
		"SELECT COUNT(hrw) FROM HRW hrw WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "hrw.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HRW exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No HRW exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HRWPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}