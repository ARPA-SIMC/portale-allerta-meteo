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

package it.eng.animazione.image.service.persistence.impl;

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

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.model.impl.PioggiaCumulativaImpl;
import it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl;
import it.eng.animazione.image.service.persistence.PioggiaCumulativaPersistence;

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
 * The persistence implementation for the pioggia cumulativa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class PioggiaCumulativaPersistenceImpl
	extends BasePersistenceImpl<PioggiaCumulativa>
	implements PioggiaCumulativaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PioggiaCumulativaUtil</code> to access the pioggia cumulativa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PioggiaCumulativaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCumulazione;
	private FinderPath _finderPathWithoutPaginationFindByCumulazione;
	private FinderPath _finderPathCountByCumulazione;

	/**
	 * Returns all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(String cumulazione) {
		return findByCumulazione(
			cumulazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end) {

		return findByCumulazione(cumulazione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return findByCumulazione(
			cumulazione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
		boolean retrieveFromCache) {

		cumulazione = Objects.toString(cumulazione, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCumulazione;
			finderArgs = new Object[] {cumulazione};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCumulazione;
			finderArgs = new Object[] {
				cumulazione, start, end, orderByComparator
			};
		}

		List<PioggiaCumulativa> list = null;

		if (retrieveFromCache) {
			list = (List<PioggiaCumulativa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PioggiaCumulativa pioggiaCumulativa : list) {
					if (!cumulazione.equals(
							pioggiaCumulativa.getCumulazione())) {

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

			query.append(_SQL_SELECT_PIOGGIACUMULATIVA_WHERE);

			boolean bindCumulazione = false;

			if (cumulazione.isEmpty()) {
				query.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3);
			}
			else {
				bindCumulazione = true;

				query.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PioggiaCumulativaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCumulazione) {
					qPos.add(cumulazione);
				}

				if (!pagination) {
					list = (List<PioggiaCumulativa>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PioggiaCumulativa>)QueryUtil.list(
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
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa findByCumulazione_First(
			String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws NoSuchPioggiaCumulativaException {

		PioggiaCumulativa pioggiaCumulativa = fetchByCumulazione_First(
			cumulazione, orderByComparator);

		if (pioggiaCumulativa != null) {
			return pioggiaCumulativa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cumulazione=");
		msg.append(cumulazione);

		msg.append("}");

		throw new NoSuchPioggiaCumulativaException(msg.toString());
	}

	/**
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByCumulazione_First(
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		List<PioggiaCumulativa> list = findByCumulazione(
			cumulazione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa findByCumulazione_Last(
			String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws NoSuchPioggiaCumulativaException {

		PioggiaCumulativa pioggiaCumulativa = fetchByCumulazione_Last(
			cumulazione, orderByComparator);

		if (pioggiaCumulativa != null) {
			return pioggiaCumulativa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cumulazione=");
		msg.append(cumulazione);

		msg.append("}");

		throw new NoSuchPioggiaCumulativaException(msg.toString());
	}

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByCumulazione_Last(
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		int count = countByCumulazione(cumulazione);

		if (count == 0) {
			return null;
		}

		List<PioggiaCumulativa> list = findByCumulazione(
			cumulazione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pioggia cumulativas before and after the current pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param id the primary key of the current pioggia cumulativa
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa[] findByCumulazione_PrevAndNext(
			long id, String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws NoSuchPioggiaCumulativaException {

		cumulazione = Objects.toString(cumulazione, "");

		PioggiaCumulativa pioggiaCumulativa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PioggiaCumulativa[] array = new PioggiaCumulativaImpl[3];

			array[0] = getByCumulazione_PrevAndNext(
				session, pioggiaCumulativa, cumulazione, orderByComparator,
				true);

			array[1] = pioggiaCumulativa;

			array[2] = getByCumulazione_PrevAndNext(
				session, pioggiaCumulativa, cumulazione, orderByComparator,
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

	protected PioggiaCumulativa getByCumulazione_PrevAndNext(
		Session session, PioggiaCumulativa pioggiaCumulativa,
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
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

		query.append(_SQL_SELECT_PIOGGIACUMULATIVA_WHERE);

		boolean bindCumulazione = false;

		if (cumulazione.isEmpty()) {
			query.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3);
		}
		else {
			bindCumulazione = true;

			query.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2);
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
			query.append(PioggiaCumulativaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCumulazione) {
			qPos.add(cumulazione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						pioggiaCumulativa)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PioggiaCumulativa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pioggia cumulativas where cumulazione = &#63; from the database.
	 *
	 * @param cumulazione the cumulazione
	 */
	@Override
	public void removeByCumulazione(String cumulazione) {
		for (PioggiaCumulativa pioggiaCumulativa :
				findByCumulazione(
					cumulazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pioggiaCumulativa);
		}
	}

	/**
	 * Returns the number of pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the number of matching pioggia cumulativas
	 */
	@Override
	public int countByCumulazione(String cumulazione) {
		cumulazione = Objects.toString(cumulazione, "");

		FinderPath finderPath = _finderPathCountByCumulazione;

		Object[] finderArgs = new Object[] {cumulazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PIOGGIACUMULATIVA_WHERE);

			boolean bindCumulazione = false;

			if (cumulazione.isEmpty()) {
				query.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3);
			}
			else {
				bindCumulazione = true;

				query.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCumulazione) {
					qPos.add(cumulazione);
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

	private static final String _FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2 =
		"pioggiaCumulativa.cumulazione = ?";

	private static final String _FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3 =
		"(pioggiaCumulativa.cumulazione IS NULL OR pioggiaCumulativa.cumulazione = '')";

	public PioggiaCumulativaPersistenceImpl() {
		setModelClass(PioggiaCumulativa.class);

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
	 * Caches the pioggia cumulativa in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 */
	@Override
	public void cacheResult(PioggiaCumulativa pioggiaCumulativa) {
		entityCache.putResult(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaImpl.class, pioggiaCumulativa.getPrimaryKey(),
			pioggiaCumulativa);

		pioggiaCumulativa.resetOriginalValues();
	}

	/**
	 * Caches the pioggia cumulativas in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativas the pioggia cumulativas
	 */
	@Override
	public void cacheResult(List<PioggiaCumulativa> pioggiaCumulativas) {
		for (PioggiaCumulativa pioggiaCumulativa : pioggiaCumulativas) {
			if (entityCache.getResult(
					PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
					PioggiaCumulativaImpl.class,
					pioggiaCumulativa.getPrimaryKey()) == null) {

				cacheResult(pioggiaCumulativa);
			}
			else {
				pioggiaCumulativa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pioggia cumulativas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PioggiaCumulativaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pioggia cumulativa.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PioggiaCumulativa pioggiaCumulativa) {
		entityCache.removeResult(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaImpl.class, pioggiaCumulativa.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PioggiaCumulativa> pioggiaCumulativas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PioggiaCumulativa pioggiaCumulativa : pioggiaCumulativas) {
			entityCache.removeResult(
				PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
				PioggiaCumulativaImpl.class, pioggiaCumulativa.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pioggia cumulativa with the primary key. Does not add the pioggia cumulativa to the database.
	 *
	 * @param id the primary key for the new pioggia cumulativa
	 * @return the new pioggia cumulativa
	 */
	@Override
	public PioggiaCumulativa create(long id) {
		PioggiaCumulativa pioggiaCumulativa = new PioggiaCumulativaImpl();

		pioggiaCumulativa.setNew(true);
		pioggiaCumulativa.setPrimaryKey(id);

		return pioggiaCumulativa;
	}

	/**
	 * Removes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa remove(long id)
		throws NoSuchPioggiaCumulativaException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa remove(Serializable primaryKey)
		throws NoSuchPioggiaCumulativaException {

		Session session = null;

		try {
			session = openSession();

			PioggiaCumulativa pioggiaCumulativa =
				(PioggiaCumulativa)session.get(
					PioggiaCumulativaImpl.class, primaryKey);

			if (pioggiaCumulativa == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPioggiaCumulativaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pioggiaCumulativa);
		}
		catch (NoSuchPioggiaCumulativaException nsee) {
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
	protected PioggiaCumulativa removeImpl(
		PioggiaCumulativa pioggiaCumulativa) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pioggiaCumulativa)) {
				pioggiaCumulativa = (PioggiaCumulativa)session.get(
					PioggiaCumulativaImpl.class,
					pioggiaCumulativa.getPrimaryKeyObj());
			}

			if (pioggiaCumulativa != null) {
				session.delete(pioggiaCumulativa);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pioggiaCumulativa != null) {
			clearCache(pioggiaCumulativa);
		}

		return pioggiaCumulativa;
	}

	@Override
	public PioggiaCumulativa updateImpl(PioggiaCumulativa pioggiaCumulativa) {
		boolean isNew = pioggiaCumulativa.isNew();

		if (!(pioggiaCumulativa instanceof PioggiaCumulativaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pioggiaCumulativa.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					pioggiaCumulativa);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pioggiaCumulativa proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PioggiaCumulativa implementation " +
					pioggiaCumulativa.getClass());
		}

		PioggiaCumulativaModelImpl pioggiaCumulativaModelImpl =
			(PioggiaCumulativaModelImpl)pioggiaCumulativa;

		Session session = null;

		try {
			session = openSession();

			if (pioggiaCumulativa.isNew()) {
				session.save(pioggiaCumulativa);

				pioggiaCumulativa.setNew(false);
			}
			else {
				pioggiaCumulativa = (PioggiaCumulativa)session.merge(
					pioggiaCumulativa);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PioggiaCumulativaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				pioggiaCumulativaModelImpl.getCumulazione()
			};

			finderCache.removeResult(_finderPathCountByCumulazione, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCumulazione, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((pioggiaCumulativaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCumulazione.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					pioggiaCumulativaModelImpl.getOriginalCumulazione()
				};

				finderCache.removeResult(_finderPathCountByCumulazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCumulazione, args);

				args = new Object[] {
					pioggiaCumulativaModelImpl.getCumulazione()
				};

				finderCache.removeResult(_finderPathCountByCumulazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCumulazione, args);
			}
		}

		entityCache.putResult(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaImpl.class, pioggiaCumulativa.getPrimaryKey(),
			pioggiaCumulativa, false);

		pioggiaCumulativa.resetOriginalValues();

		return pioggiaCumulativa;
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPioggiaCumulativaException {

		PioggiaCumulativa pioggiaCumulativa = fetchByPrimaryKey(primaryKey);

		if (pioggiaCumulativa == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPioggiaCumulativaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pioggiaCumulativa;
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or throws a <code>NoSuchPioggiaCumulativaException</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa findByPrimaryKey(long id)
		throws NoSuchPioggiaCumulativaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa, or <code>null</code> if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PioggiaCumulativa pioggiaCumulativa = (PioggiaCumulativa)serializable;

		if (pioggiaCumulativa == null) {
			Session session = null;

			try {
				session = openSession();

				pioggiaCumulativa = (PioggiaCumulativa)session.get(
					PioggiaCumulativaImpl.class, primaryKey);

				if (pioggiaCumulativa != null) {
					cacheResult(pioggiaCumulativa);
				}
				else {
					entityCache.putResult(
						PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
						PioggiaCumulativaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
					PioggiaCumulativaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pioggiaCumulativa;
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa, or <code>null</code> if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, PioggiaCumulativa> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PioggiaCumulativa> map =
			new HashMap<Serializable, PioggiaCumulativa>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PioggiaCumulativa pioggiaCumulativa = fetchByPrimaryKey(primaryKey);

			if (pioggiaCumulativa != null) {
				map.put(primaryKey, pioggiaCumulativa);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
				PioggiaCumulativaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PioggiaCumulativa)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PIOGGIACUMULATIVA_WHERE_PKS_IN);

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

			for (PioggiaCumulativa pioggiaCumulativa :
					(List<PioggiaCumulativa>)q.list()) {

				map.put(
					pioggiaCumulativa.getPrimaryKeyObj(), pioggiaCumulativa);

				cacheResult(pioggiaCumulativa);

				uncachedPrimaryKeys.remove(
					pioggiaCumulativa.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
					PioggiaCumulativaImpl.class, primaryKey, nullModel);
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
	 * Returns all the pioggia cumulativas.
	 *
	 * @return the pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll(
		int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll(
		int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
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

		List<PioggiaCumulativa> list = null;

		if (retrieveFromCache) {
			list = (List<PioggiaCumulativa>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PIOGGIACUMULATIVA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PIOGGIACUMULATIVA;

				if (pagination) {
					sql = sql.concat(PioggiaCumulativaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PioggiaCumulativa>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PioggiaCumulativa>)QueryUtil.list(
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
	 * Removes all the pioggia cumulativas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PioggiaCumulativa pioggiaCumulativa : findAll()) {
			remove(pioggiaCumulativa);
		}
	}

	/**
	 * Returns the number of pioggia cumulativas.
	 *
	 * @return the number of pioggia cumulativas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PIOGGIACUMULATIVA);

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
		return PioggiaCumulativaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pioggia cumulativa persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaModelImpl.FINDER_CACHE_ENABLED,
			PioggiaCumulativaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaModelImpl.FINDER_CACHE_ENABLED,
			PioggiaCumulativaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCumulazione = new FinderPath(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaModelImpl.FINDER_CACHE_ENABLED,
			PioggiaCumulativaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCumulazione",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCumulazione = new FinderPath(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaModelImpl.FINDER_CACHE_ENABLED,
			PioggiaCumulativaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCumulazione",
			new String[] {String.class.getName()},
			PioggiaCumulativaModelImpl.CUMULAZIONE_COLUMN_BITMASK);

		_finderPathCountByCumulazione = new FinderPath(
			PioggiaCumulativaModelImpl.ENTITY_CACHE_ENABLED,
			PioggiaCumulativaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCumulazione",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(PioggiaCumulativaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PIOGGIACUMULATIVA =
		"SELECT pioggiaCumulativa FROM PioggiaCumulativa pioggiaCumulativa";

	private static final String _SQL_SELECT_PIOGGIACUMULATIVA_WHERE_PKS_IN =
		"SELECT pioggiaCumulativa FROM PioggiaCumulativa pioggiaCumulativa WHERE id_ IN (";

	private static final String _SQL_SELECT_PIOGGIACUMULATIVA_WHERE =
		"SELECT pioggiaCumulativa FROM PioggiaCumulativa pioggiaCumulativa WHERE ";

	private static final String _SQL_COUNT_PIOGGIACUMULATIVA =
		"SELECT COUNT(pioggiaCumulativa) FROM PioggiaCumulativa pioggiaCumulativa";

	private static final String _SQL_COUNT_PIOGGIACUMULATIVA_WHERE =
		"SELECT COUNT(pioggiaCumulativa) FROM PioggiaCumulativa pioggiaCumulativa WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pioggiaCumulativa.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PioggiaCumulativa exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PioggiaCumulativa exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PioggiaCumulativaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}