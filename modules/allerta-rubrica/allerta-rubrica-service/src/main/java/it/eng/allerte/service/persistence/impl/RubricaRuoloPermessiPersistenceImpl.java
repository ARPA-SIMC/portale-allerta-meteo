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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException;
import it.eng.allerte.model.RubricaRuoloPermessi;
import it.eng.allerte.model.impl.RubricaRuoloPermessiImpl;
import it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPK;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica ruolo permessi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiPersistenceImpl
	extends BasePersistenceImpl<RubricaRuoloPermessi>
	implements RubricaRuoloPermessiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaRuoloPermessiUtil</code> to access the rubrica ruolo permessi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaRuoloPermessiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRubricaPermessiByRuolo;
	private FinderPath _finderPathWithoutPaginationFindByRubricaPermessiByRuolo;
	private FinderPath _finderPathCountByRubricaPermessiByRuolo;

	/**
	 * Returns all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO) {

		return findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end) {

		return findByRubricaPermessiByRuolo(FK_ID_RUOLO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaPermessiByRuolo;
			finderArgs = new Object[] {FK_ID_RUOLO};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRubricaPermessiByRuolo;
			finderArgs = new Object[] {
				FK_ID_RUOLO, start, end, orderByComparator
			};
		}

		List<RubricaRuoloPermessi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaRuoloPermessi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaRuoloPermessi rubricaRuoloPermessi : list) {
					if ((FK_ID_RUOLO !=
							rubricaRuoloPermessi.getFK_ID_RUOLO())) {

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

			query.append(_SQL_SELECT_RUBRICARUOLOPERMESSI_WHERE);

			query.append(_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaRuoloPermessiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_ID_RUOLO);

				if (!pagination) {
					list = (List<RubricaRuoloPermessi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaRuoloPermessi>)QueryUtil.list(
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
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByRubricaPermessiByRuolo_First(
			long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi =
			fetchByRubricaPermessiByRuolo_First(FK_ID_RUOLO, orderByComparator);

		if (rubricaRuoloPermessi != null) {
			return rubricaRuoloPermessi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_ID_RUOLO=");
		msg.append(FK_ID_RUOLO);

		msg.append("}");

		throw new NoSuchRubricaRuoloPermessiException(msg.toString());
	}

	/**
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_First(
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		List<RubricaRuoloPermessi> list = findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByRubricaPermessiByRuolo_Last(
			long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi =
			fetchByRubricaPermessiByRuolo_Last(FK_ID_RUOLO, orderByComparator);

		if (rubricaRuoloPermessi != null) {
			return rubricaRuoloPermessi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_ID_RUOLO=");
		msg.append(FK_ID_RUOLO);

		msg.append("}");

		throw new NoSuchRubricaRuoloPermessiException(msg.toString());
	}

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_Last(
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		int count = countByRubricaPermessiByRuolo(FK_ID_RUOLO);

		if (count == 0) {
			return null;
		}

		List<RubricaRuoloPermessi> list = findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica ruolo permessis before and after the current rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the current rubrica ruolo permessi
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi[] findByRubricaPermessiByRuolo_PrevAndNext(
			RubricaRuoloPermessiPK rubricaRuoloPermessiPK, long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi = findByPrimaryKey(
			rubricaRuoloPermessiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaRuoloPermessi[] array = new RubricaRuoloPermessiImpl[3];

			array[0] = getByRubricaPermessiByRuolo_PrevAndNext(
				session, rubricaRuoloPermessi, FK_ID_RUOLO, orderByComparator,
				true);

			array[1] = rubricaRuoloPermessi;

			array[2] = getByRubricaPermessiByRuolo_PrevAndNext(
				session, rubricaRuoloPermessi, FK_ID_RUOLO, orderByComparator,
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

	protected RubricaRuoloPermessi getByRubricaPermessiByRuolo_PrevAndNext(
		Session session, RubricaRuoloPermessi rubricaRuoloPermessi,
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICARUOLOPERMESSI_WHERE);

		query.append(_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2);

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
			query.append(RubricaRuoloPermessiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_ID_RUOLO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaRuoloPermessi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaRuoloPermessi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica ruolo permessis where FK_ID_RUOLO = &#63; from the database.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 */
	@Override
	public void removeByRubricaPermessiByRuolo(long FK_ID_RUOLO) {
		for (RubricaRuoloPermessi rubricaRuoloPermessi :
				findByRubricaPermessiByRuolo(
					FK_ID_RUOLO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rubricaRuoloPermessi);
		}
	}

	/**
	 * Returns the number of rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the number of matching rubrica ruolo permessis
	 */
	@Override
	public int countByRubricaPermessiByRuolo(long FK_ID_RUOLO) {
		FinderPath finderPath = _finderPathCountByRubricaPermessiByRuolo;

		Object[] finderArgs = new Object[] {FK_ID_RUOLO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICARUOLOPERMESSI_WHERE);

			query.append(_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_ID_RUOLO);

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

	private static final String
		_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2 =
			"rubricaRuoloPermessi.id.FK_ID_RUOLO = ?";

	public RubricaRuoloPermessiPersistenceImpl() {
		setModelClass(RubricaRuoloPermessi.class);
	}

	/**
	 * Caches the rubrica ruolo permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 */
	@Override
	public void cacheResult(RubricaRuoloPermessi rubricaRuoloPermessi) {
		entityCache.putResult(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class,
			rubricaRuoloPermessi.getPrimaryKey(), rubricaRuoloPermessi);

		rubricaRuoloPermessi.resetOriginalValues();
	}

	/**
	 * Caches the rubrica ruolo permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessis the rubrica ruolo permessis
	 */
	@Override
	public void cacheResult(List<RubricaRuoloPermessi> rubricaRuoloPermessis) {
		for (RubricaRuoloPermessi rubricaRuoloPermessi :
				rubricaRuoloPermessis) {

			if (entityCache.getResult(
					RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloPermessiImpl.class,
					rubricaRuoloPermessi.getPrimaryKey()) == null) {

				cacheResult(rubricaRuoloPermessi);
			}
			else {
				rubricaRuoloPermessi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica ruolo permessis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaRuoloPermessiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica ruolo permessi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaRuoloPermessi rubricaRuoloPermessi) {
		entityCache.removeResult(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class,
			rubricaRuoloPermessi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaRuoloPermessi> rubricaRuoloPermessis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaRuoloPermessi rubricaRuoloPermessi :
				rubricaRuoloPermessis) {

			entityCache.removeResult(
				RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaRuoloPermessiImpl.class,
				rubricaRuoloPermessi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica ruolo permessi with the primary key. Does not add the rubrica ruolo permessi to the database.
	 *
	 * @param rubricaRuoloPermessiPK the primary key for the new rubrica ruolo permessi
	 * @return the new rubrica ruolo permessi
	 */
	@Override
	public RubricaRuoloPermessi create(
		RubricaRuoloPermessiPK rubricaRuoloPermessiPK) {

		RubricaRuoloPermessi rubricaRuoloPermessi =
			new RubricaRuoloPermessiImpl();

		rubricaRuoloPermessi.setNew(true);
		rubricaRuoloPermessi.setPrimaryKey(rubricaRuoloPermessiPK);

		return rubricaRuoloPermessi;
	}

	/**
	 * Removes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi remove(
			RubricaRuoloPermessiPK rubricaRuoloPermessiPK)
		throws NoSuchRubricaRuoloPermessiException {

		return remove((Serializable)rubricaRuoloPermessiPK);
	}

	/**
	 * Removes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi remove(Serializable primaryKey)
		throws NoSuchRubricaRuoloPermessiException {

		Session session = null;

		try {
			session = openSession();

			RubricaRuoloPermessi rubricaRuoloPermessi =
				(RubricaRuoloPermessi)session.get(
					RubricaRuoloPermessiImpl.class, primaryKey);

			if (rubricaRuoloPermessi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaRuoloPermessiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaRuoloPermessi);
		}
		catch (NoSuchRubricaRuoloPermessiException nsee) {
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
	protected RubricaRuoloPermessi removeImpl(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaRuoloPermessi)) {
				rubricaRuoloPermessi = (RubricaRuoloPermessi)session.get(
					RubricaRuoloPermessiImpl.class,
					rubricaRuoloPermessi.getPrimaryKeyObj());
			}

			if (rubricaRuoloPermessi != null) {
				session.delete(rubricaRuoloPermessi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaRuoloPermessi != null) {
			clearCache(rubricaRuoloPermessi);
		}

		return rubricaRuoloPermessi;
	}

	@Override
	public RubricaRuoloPermessi updateImpl(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		boolean isNew = rubricaRuoloPermessi.isNew();

		if (!(rubricaRuoloPermessi instanceof RubricaRuoloPermessiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaRuoloPermessi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaRuoloPermessi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaRuoloPermessi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaRuoloPermessi implementation " +
					rubricaRuoloPermessi.getClass());
		}

		RubricaRuoloPermessiModelImpl rubricaRuoloPermessiModelImpl =
			(RubricaRuoloPermessiModelImpl)rubricaRuoloPermessi;

		Session session = null;

		try {
			session = openSession();

			if (rubricaRuoloPermessi.isNew()) {
				session.save(rubricaRuoloPermessi);

				rubricaRuoloPermessi.setNew(false);
			}
			else {
				rubricaRuoloPermessi = (RubricaRuoloPermessi)session.merge(
					rubricaRuoloPermessi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaRuoloPermessiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaRuoloPermessiModelImpl.getFK_ID_RUOLO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaPermessiByRuolo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaPermessiByRuolo, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaRuoloPermessiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaPermessiByRuolo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaRuoloPermessiModelImpl.getOriginalFK_ID_RUOLO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaPermessiByRuolo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaPermessiByRuolo,
					args);

				args = new Object[] {
					rubricaRuoloPermessiModelImpl.getFK_ID_RUOLO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaPermessiByRuolo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaPermessiByRuolo,
					args);
			}
		}

		entityCache.putResult(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class,
			rubricaRuoloPermessi.getPrimaryKey(), rubricaRuoloPermessi, false);

		rubricaRuoloPermessi.resetOriginalValues();

		return rubricaRuoloPermessi;
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi = fetchByPrimaryKey(
			primaryKey);

		if (rubricaRuoloPermessi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaRuoloPermessiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaRuoloPermessi;
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or throws a <code>NoSuchRubricaRuoloPermessiException</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByPrimaryKey(
			RubricaRuoloPermessiPK rubricaRuoloPermessiPK)
		throws NoSuchRubricaRuoloPermessiException {

		return findByPrimaryKey((Serializable)rubricaRuoloPermessiPK);
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi, or <code>null</code> if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaRuoloPermessi rubricaRuoloPermessi =
			(RubricaRuoloPermessi)serializable;

		if (rubricaRuoloPermessi == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaRuoloPermessi = (RubricaRuoloPermessi)session.get(
					RubricaRuoloPermessiImpl.class, primaryKey);

				if (rubricaRuoloPermessi != null) {
					cacheResult(rubricaRuoloPermessi);
				}
				else {
					entityCache.putResult(
						RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
						RubricaRuoloPermessiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloPermessiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaRuoloPermessi;
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi, or <code>null</code> if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByPrimaryKey(
		RubricaRuoloPermessiPK rubricaRuoloPermessiPK) {

		return fetchByPrimaryKey((Serializable)rubricaRuoloPermessiPK);
	}

	@Override
	public Map<Serializable, RubricaRuoloPermessi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaRuoloPermessi> map =
			new HashMap<Serializable, RubricaRuoloPermessi>();

		for (Serializable primaryKey : primaryKeys) {
			RubricaRuoloPermessi rubricaRuoloPermessi = fetchByPrimaryKey(
				primaryKey);

			if (rubricaRuoloPermessi != null) {
				map.put(primaryKey, rubricaRuoloPermessi);
			}
		}

		return map;
	}

	/**
	 * Returns all the rubrica ruolo permessis.
	 *
	 * @return the rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
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

		List<RubricaRuoloPermessi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaRuoloPermessi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICARUOLOPERMESSI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICARUOLOPERMESSI;

				if (pagination) {
					sql = sql.concat(
						RubricaRuoloPermessiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaRuoloPermessi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaRuoloPermessi>)QueryUtil.list(
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
	 * Removes all the rubrica ruolo permessis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaRuoloPermessi rubricaRuoloPermessi : findAll()) {
			remove(rubricaRuoloPermessi);
		}
	}

	/**
	 * Returns the number of rubrica ruolo permessis.
	 *
	 * @return the number of rubrica ruolo permessis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICARUOLOPERMESSI);

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
		return RubricaRuoloPermessiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica ruolo permessi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiModelImpl.FINDER_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiModelImpl.FINDER_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRubricaPermessiByRuolo = new FinderPath(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiModelImpl.FINDER_CACHE_ENABLED,
			RubricaRuoloPermessiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRubricaPermessiByRuolo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRubricaPermessiByRuolo =
			new FinderPath(
				RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaRuoloPermessiModelImpl.FINDER_CACHE_ENABLED,
				RubricaRuoloPermessiImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaPermessiByRuolo",
				new String[] {Long.class.getName()},
				RubricaRuoloPermessiModelImpl.FK_ID_RUOLO_COLUMN_BITMASK);

		_finderPathCountByRubricaPermessiByRuolo = new FinderPath(
			RubricaRuoloPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloPermessiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaPermessiByRuolo",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaRuoloPermessiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICARUOLOPERMESSI =
		"SELECT rubricaRuoloPermessi FROM RubricaRuoloPermessi rubricaRuoloPermessi";

	private static final String _SQL_SELECT_RUBRICARUOLOPERMESSI_WHERE =
		"SELECT rubricaRuoloPermessi FROM RubricaRuoloPermessi rubricaRuoloPermessi WHERE ";

	private static final String _SQL_COUNT_RUBRICARUOLOPERMESSI =
		"SELECT COUNT(rubricaRuoloPermessi) FROM RubricaRuoloPermessi rubricaRuoloPermessi";

	private static final String _SQL_COUNT_RUBRICARUOLOPERMESSI_WHERE =
		"SELECT COUNT(rubricaRuoloPermessi) FROM RubricaRuoloPermessi rubricaRuoloPermessi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"rubricaRuoloPermessi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaRuoloPermessi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaRuoloPermessi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaRuoloPermessiPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"FK_ID_RUOLO", "FK_ID_PERMESSO"});

}