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

package it.eng.allerte.service.persistence.impl;

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

import it.eng.allerte.exception.NoSuchRubricaSitoException;
import it.eng.allerte.model.RubricaSito;
import it.eng.allerte.model.impl.RubricaSitoImpl;
import it.eng.allerte.model.impl.RubricaSitoModelImpl;
import it.eng.allerte.service.persistence.RubricaSitoPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaSitoPersistenceImpl
	extends BasePersistenceImpl<RubricaSito> implements RubricaSitoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaSitoUtil</code> to access the rubrica sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaSitoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLiferaySite;
	private FinderPath _finderPathWithoutPaginationFindByLiferaySite;
	private FinderPath _finderPathCountByLiferaySite;

	/**
	 * Returns all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(long FK_LIFERAY_SITE) {
		return findByLiferaySite(
			FK_LIFERAY_SITE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end) {

		return findByLiferaySite(FK_LIFERAY_SITE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator) {

		return findByLiferaySite(
			FK_LIFERAY_SITE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByLiferaySite;
			finderArgs = new Object[] {FK_LIFERAY_SITE};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLiferaySite;
			finderArgs = new Object[] {
				FK_LIFERAY_SITE, start, end, orderByComparator
			};
		}

		List<RubricaSito> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaSito>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaSito rubricaSito : list) {
					if ((FK_LIFERAY_SITE != rubricaSito.getFK_LIFERAY_SITE())) {
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

			query.append(_SQL_SELECT_RUBRICASITO_WHERE);

			query.append(_FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaSitoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_LIFERAY_SITE);

				if (!pagination) {
					list = (List<RubricaSito>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaSito>)QueryUtil.list(
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
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito findByLiferaySite_First(
			long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = fetchByLiferaySite_First(
			FK_LIFERAY_SITE, orderByComparator);

		if (rubricaSito != null) {
			return rubricaSito;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_LIFERAY_SITE=");
		msg.append(FK_LIFERAY_SITE);

		msg.append("}");

		throw new NoSuchRubricaSitoException(msg.toString());
	}

	/**
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito fetchByLiferaySite_First(
		long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator) {

		List<RubricaSito> list = findByLiferaySite(
			FK_LIFERAY_SITE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito findByLiferaySite_Last(
			long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = fetchByLiferaySite_Last(
			FK_LIFERAY_SITE, orderByComparator);

		if (rubricaSito != null) {
			return rubricaSito;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_LIFERAY_SITE=");
		msg.append(FK_LIFERAY_SITE);

		msg.append("}");

		throw new NoSuchRubricaSitoException(msg.toString());
	}

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito fetchByLiferaySite_Last(
		long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator) {

		int count = countByLiferaySite(FK_LIFERAY_SITE);

		if (count == 0) {
			return null;
		}

		List<RubricaSito> list = findByLiferaySite(
			FK_LIFERAY_SITE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica sitos before and after the current rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param ID_SITO the primary key of the current rubrica sito
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito[] findByLiferaySite_PrevAndNext(
			long ID_SITO, long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = findByPrimaryKey(ID_SITO);

		Session session = null;

		try {
			session = openSession();

			RubricaSito[] array = new RubricaSitoImpl[3];

			array[0] = getByLiferaySite_PrevAndNext(
				session, rubricaSito, FK_LIFERAY_SITE, orderByComparator, true);

			array[1] = rubricaSito;

			array[2] = getByLiferaySite_PrevAndNext(
				session, rubricaSito, FK_LIFERAY_SITE, orderByComparator,
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

	protected RubricaSito getByLiferaySite_PrevAndNext(
		Session session, RubricaSito rubricaSito, long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RUBRICASITO_WHERE);

		query.append(_FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2);

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
			query.append(RubricaSitoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_LIFERAY_SITE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaSito)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaSito> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica sitos where FK_LIFERAY_SITE = &#63; from the database.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 */
	@Override
	public void removeByLiferaySite(long FK_LIFERAY_SITE) {
		for (RubricaSito rubricaSito :
				findByLiferaySite(
					FK_LIFERAY_SITE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaSito);
		}
	}

	/**
	 * Returns the number of rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the number of matching rubrica sitos
	 */
	@Override
	public int countByLiferaySite(long FK_LIFERAY_SITE) {
		FinderPath finderPath = _finderPathCountByLiferaySite;

		Object[] finderArgs = new Object[] {FK_LIFERAY_SITE};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICASITO_WHERE);

			query.append(_FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_LIFERAY_SITE);

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

	private static final String _FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2 =
		"rubricaSito.FK_LIFERAY_SITE = ?";

	public RubricaSitoPersistenceImpl() {
		setModelClass(RubricaSito.class);
	}

	/**
	 * Caches the rubrica sito in the entity cache if it is enabled.
	 *
	 * @param rubricaSito the rubrica sito
	 */
	@Override
	public void cacheResult(RubricaSito rubricaSito) {
		entityCache.putResult(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED, RubricaSitoImpl.class,
			rubricaSito.getPrimaryKey(), rubricaSito);

		rubricaSito.resetOriginalValues();
	}

	/**
	 * Caches the rubrica sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaSitos the rubrica sitos
	 */
	@Override
	public void cacheResult(List<RubricaSito> rubricaSitos) {
		for (RubricaSito rubricaSito : rubricaSitos) {
			if (entityCache.getResult(
					RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaSitoImpl.class, rubricaSito.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaSito);
			}
			else {
				rubricaSito.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica sitos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaSitoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica sito.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaSito rubricaSito) {
		entityCache.removeResult(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED, RubricaSitoImpl.class,
			rubricaSito.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaSito> rubricaSitos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaSito rubricaSito : rubricaSitos) {
			entityCache.removeResult(
				RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaSitoImpl.class, rubricaSito.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica sito with the primary key. Does not add the rubrica sito to the database.
	 *
	 * @param ID_SITO the primary key for the new rubrica sito
	 * @return the new rubrica sito
	 */
	@Override
	public RubricaSito create(long ID_SITO) {
		RubricaSito rubricaSito = new RubricaSitoImpl();

		rubricaSito.setNew(true);
		rubricaSito.setPrimaryKey(ID_SITO);

		return rubricaSito;
	}

	/**
	 * Removes the rubrica sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito that was removed
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito remove(long ID_SITO) throws NoSuchRubricaSitoException {
		return remove((Serializable)ID_SITO);
	}

	/**
	 * Removes the rubrica sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica sito
	 * @return the rubrica sito that was removed
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito remove(Serializable primaryKey)
		throws NoSuchRubricaSitoException {

		Session session = null;

		try {
			session = openSession();

			RubricaSito rubricaSito = (RubricaSito)session.get(
				RubricaSitoImpl.class, primaryKey);

			if (rubricaSito == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaSitoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaSito);
		}
		catch (NoSuchRubricaSitoException nsee) {
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
	protected RubricaSito removeImpl(RubricaSito rubricaSito) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaSito)) {
				rubricaSito = (RubricaSito)session.get(
					RubricaSitoImpl.class, rubricaSito.getPrimaryKeyObj());
			}

			if (rubricaSito != null) {
				session.delete(rubricaSito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaSito != null) {
			clearCache(rubricaSito);
		}

		return rubricaSito;
	}

	@Override
	public RubricaSito updateImpl(RubricaSito rubricaSito) {
		boolean isNew = rubricaSito.isNew();

		if (!(rubricaSito instanceof RubricaSitoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaSito.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(rubricaSito);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaSito proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaSito implementation " +
					rubricaSito.getClass());
		}

		RubricaSitoModelImpl rubricaSitoModelImpl =
			(RubricaSitoModelImpl)rubricaSito;

		Session session = null;

		try {
			session = openSession();

			if (rubricaSito.isNew()) {
				session.save(rubricaSito);

				rubricaSito.setNew(false);
			}
			else {
				rubricaSito = (RubricaSito)session.merge(rubricaSito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaSitoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaSitoModelImpl.getFK_LIFERAY_SITE()
			};

			finderCache.removeResult(_finderPathCountByLiferaySite, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLiferaySite, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaSitoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLiferaySite.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaSitoModelImpl.getOriginalFK_LIFERAY_SITE()
				};

				finderCache.removeResult(_finderPathCountByLiferaySite, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLiferaySite, args);

				args = new Object[] {rubricaSitoModelImpl.getFK_LIFERAY_SITE()};

				finderCache.removeResult(_finderPathCountByLiferaySite, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLiferaySite, args);
			}
		}

		entityCache.putResult(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED, RubricaSitoImpl.class,
			rubricaSito.getPrimaryKey(), rubricaSito, false);

		rubricaSito.resetOriginalValues();

		return rubricaSito;
	}

	/**
	 * Returns the rubrica sito with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica sito
	 * @return the rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = fetchByPrimaryKey(primaryKey);

		if (rubricaSito == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaSitoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaSito;
	}

	/**
	 * Returns the rubrica sito with the primary key or throws a <code>NoSuchRubricaSitoException</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito findByPrimaryKey(long ID_SITO)
		throws NoSuchRubricaSitoException {

		return findByPrimaryKey((Serializable)ID_SITO);
	}

	/**
	 * Returns the rubrica sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica sito
	 * @return the rubrica sito, or <code>null</code> if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED, RubricaSitoImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaSito rubricaSito = (RubricaSito)serializable;

		if (rubricaSito == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaSito = (RubricaSito)session.get(
					RubricaSitoImpl.class, primaryKey);

				if (rubricaSito != null) {
					cacheResult(rubricaSito);
				}
				else {
					entityCache.putResult(
						RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
						RubricaSitoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaSitoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaSito;
	}

	/**
	 * Returns the rubrica sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito, or <code>null</code> if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito fetchByPrimaryKey(long ID_SITO) {
		return fetchByPrimaryKey((Serializable)ID_SITO);
	}

	@Override
	public Map<Serializable, RubricaSito> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaSito> map =
			new HashMap<Serializable, RubricaSito>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaSito rubricaSito = fetchByPrimaryKey(primaryKey);

			if (rubricaSito != null) {
				map.put(primaryKey, rubricaSito);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaSitoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaSito)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICASITO_WHERE_PKS_IN);

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

			for (RubricaSito rubricaSito : (List<RubricaSito>)q.list()) {
				map.put(rubricaSito.getPrimaryKeyObj(), rubricaSito);

				cacheResult(rubricaSito);

				uncachedPrimaryKeys.remove(rubricaSito.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaSitoImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica sitos.
	 *
	 * @return the rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll(
		int start, int end, OrderByComparator<RubricaSito> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll(
		int start, int end, OrderByComparator<RubricaSito> orderByComparator,
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

		List<RubricaSito> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaSito>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICASITO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICASITO;

				if (pagination) {
					sql = sql.concat(RubricaSitoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaSito>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaSito>)QueryUtil.list(
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
	 * Removes all the rubrica sitos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaSito rubricaSito : findAll()) {
			remove(rubricaSito);
		}
	}

	/**
	 * Returns the number of rubrica sitos.
	 *
	 * @return the number of rubrica sitos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICASITO);

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
		return RubricaSitoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica sito persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaSitoModelImpl.FINDER_CACHE_ENABLED, RubricaSitoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaSitoModelImpl.FINDER_CACHE_ENABLED, RubricaSitoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaSitoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByLiferaySite = new FinderPath(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaSitoModelImpl.FINDER_CACHE_ENABLED, RubricaSitoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLiferaySite",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLiferaySite = new FinderPath(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaSitoModelImpl.FINDER_CACHE_ENABLED, RubricaSitoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLiferaySite",
			new String[] {Long.class.getName()},
			RubricaSitoModelImpl.FK_LIFERAY_SITE_COLUMN_BITMASK);

		_finderPathCountByLiferaySite = new FinderPath(
			RubricaSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaSitoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLiferaySite",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaSitoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICASITO =
		"SELECT rubricaSito FROM RubricaSito rubricaSito";

	private static final String _SQL_SELECT_RUBRICASITO_WHERE_PKS_IN =
		"SELECT rubricaSito FROM RubricaSito rubricaSito WHERE ID_SITO IN (";

	private static final String _SQL_SELECT_RUBRICASITO_WHERE =
		"SELECT rubricaSito FROM RubricaSito rubricaSito WHERE ";

	private static final String _SQL_COUNT_RUBRICASITO =
		"SELECT COUNT(rubricaSito) FROM RubricaSito rubricaSito";

	private static final String _SQL_COUNT_RUBRICASITO_WHERE =
		"SELECT COUNT(rubricaSito) FROM RubricaSito rubricaSito WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaSito.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaSito exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaSito exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaSitoPersistenceImpl.class);

}