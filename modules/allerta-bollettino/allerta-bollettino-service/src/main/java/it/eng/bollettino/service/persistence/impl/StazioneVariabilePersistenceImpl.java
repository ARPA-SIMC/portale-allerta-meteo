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

package it.eng.bollettino.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.bollettino.exception.NoSuchStazioneVariabileException;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.impl.StazioneVariabileImpl;
import it.eng.bollettino.model.impl.StazioneVariabileModelImpl;
import it.eng.bollettino.service.persistence.StazioneVariabilePersistence;

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
 * The persistence implementation for the stazione variabile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StazioneVariabilePersistenceImpl
	extends BasePersistenceImpl<StazioneVariabile>
	implements StazioneVariabilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StazioneVariabileUtil</code> to access the stazione variabile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StazioneVariabileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the stazione variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<StazioneVariabile> list = null;

		if (retrieveFromCache) {
			list = (List<StazioneVariabile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StazioneVariabile stazioneVariabile : list) {
					if (!uuid.equals(stazioneVariabile.getUuid())) {
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

			query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StazioneVariabileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<StazioneVariabile>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StazioneVariabile>)QueryUtil.list(
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
	 * Returns the first stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile findByUuid_First(
			String uuid, OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByUuid_First(
			uuid, orderByComparator);

		if (stazioneVariabile != null) {
			return stazioneVariabile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStazioneVariabileException(msg.toString());
	}

	/**
	 * Returns the first stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile fetchByUuid_First(
		String uuid, OrderByComparator<StazioneVariabile> orderByComparator) {

		List<StazioneVariabile> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile findByUuid_Last(
			String uuid, OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByUuid_Last(
			uuid, orderByComparator);

		if (stazioneVariabile != null) {
			return stazioneVariabile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStazioneVariabileException(msg.toString());
	}

	/**
	 * Returns the last stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile fetchByUuid_Last(
		String uuid, OrderByComparator<StazioneVariabile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StazioneVariabile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		uuid = Objects.toString(uuid, "");

		StazioneVariabile stazioneVariabile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StazioneVariabile[] array = new StazioneVariabileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, stazioneVariabile, uuid, orderByComparator, true);

			array[1] = stazioneVariabile;

			array[2] = getByUuid_PrevAndNext(
				session, stazioneVariabile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StazioneVariabile getByUuid_PrevAndNext(
		Session session, StazioneVariabile stazioneVariabile, String uuid,
		OrderByComparator<StazioneVariabile> orderByComparator,
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

		query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(StazioneVariabileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stazioneVariabile)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StazioneVariabile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stazione variabiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StazioneVariabile stazioneVariabile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stazioneVariabile);
		}
	}

	/**
	 * Returns the number of stazione variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stazione variabiles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STAZIONEVARIABILE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"stazioneVariabile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(stazioneVariabile.uuid IS NULL OR stazioneVariabile.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByStazione;
	private FinderPath _finderPathWithoutPaginationFindByStazione;
	private FinderPath _finderPathCountByStazione;

	/**
	 * Returns all the stazione variabiles where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @return the matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByStazione(String idStazione) {
		return findByStazione(
			idStazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end) {

		return findByStazione(idStazione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return findByStazione(idStazione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean retrieveFromCache) {

		idStazione = Objects.toString(idStazione, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStazione;
			finderArgs = new Object[] {idStazione};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStazione;
			finderArgs = new Object[] {
				idStazione, start, end, orderByComparator
			};
		}

		List<StazioneVariabile> list = null;

		if (retrieveFromCache) {
			list = (List<StazioneVariabile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StazioneVariabile stazioneVariabile : list) {
					if (!idStazione.equals(stazioneVariabile.getIdStazione())) {
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

			query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE);

			boolean bindIdStazione = false;

			if (idStazione.isEmpty()) {
				query.append(_FINDER_COLUMN_STAZIONE_IDSTAZIONE_3);
			}
			else {
				bindIdStazione = true;

				query.append(_FINDER_COLUMN_STAZIONE_IDSTAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StazioneVariabileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdStazione) {
					qPos.add(idStazione);
				}

				if (!pagination) {
					list = (List<StazioneVariabile>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StazioneVariabile>)QueryUtil.list(
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
	 * Returns the first stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile findByStazione_First(
			String idStazione,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByStazione_First(
			idStazione, orderByComparator);

		if (stazioneVariabile != null) {
			return stazioneVariabile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idStazione=");
		msg.append(idStazione);

		msg.append("}");

		throw new NoSuchStazioneVariabileException(msg.toString());
	}

	/**
	 * Returns the first stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile fetchByStazione_First(
		String idStazione,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		List<StazioneVariabile> list = findByStazione(
			idStazione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile findByStazione_Last(
			String idStazione,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByStazione_Last(
			idStazione, orderByComparator);

		if (stazioneVariabile != null) {
			return stazioneVariabile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idStazione=");
		msg.append(idStazione);

		msg.append("}");

		throw new NoSuchStazioneVariabileException(msg.toString());
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile fetchByStazione_Last(
		String idStazione,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		int count = countByStazione(idStazione);

		if (count == 0) {
			return null;
		}

		List<StazioneVariabile> list = findByStazione(
			idStazione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile[] findByStazione_PrevAndNext(
			long id, String idStazione,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		idStazione = Objects.toString(idStazione, "");

		StazioneVariabile stazioneVariabile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StazioneVariabile[] array = new StazioneVariabileImpl[3];

			array[0] = getByStazione_PrevAndNext(
				session, stazioneVariabile, idStazione, orderByComparator,
				true);

			array[1] = stazioneVariabile;

			array[2] = getByStazione_PrevAndNext(
				session, stazioneVariabile, idStazione, orderByComparator,
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

	protected StazioneVariabile getByStazione_PrevAndNext(
		Session session, StazioneVariabile stazioneVariabile, String idStazione,
		OrderByComparator<StazioneVariabile> orderByComparator,
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

		query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE);

		boolean bindIdStazione = false;

		if (idStazione.isEmpty()) {
			query.append(_FINDER_COLUMN_STAZIONE_IDSTAZIONE_3);
		}
		else {
			bindIdStazione = true;

			query.append(_FINDER_COLUMN_STAZIONE_IDSTAZIONE_2);
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
			query.append(StazioneVariabileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdStazione) {
			qPos.add(idStazione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stazioneVariabile)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StazioneVariabile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stazione variabiles where idStazione = &#63; from the database.
	 *
	 * @param idStazione the id stazione
	 */
	@Override
	public void removeByStazione(String idStazione) {
		for (StazioneVariabile stazioneVariabile :
				findByStazione(
					idStazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stazioneVariabile);
		}
	}

	/**
	 * Returns the number of stazione variabiles where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @return the number of matching stazione variabiles
	 */
	@Override
	public int countByStazione(String idStazione) {
		idStazione = Objects.toString(idStazione, "");

		FinderPath finderPath = _finderPathCountByStazione;

		Object[] finderArgs = new Object[] {idStazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STAZIONEVARIABILE_WHERE);

			boolean bindIdStazione = false;

			if (idStazione.isEmpty()) {
				query.append(_FINDER_COLUMN_STAZIONE_IDSTAZIONE_3);
			}
			else {
				bindIdStazione = true;

				query.append(_FINDER_COLUMN_STAZIONE_IDSTAZIONE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdStazione) {
					qPos.add(idStazione);
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

	private static final String _FINDER_COLUMN_STAZIONE_IDSTAZIONE_2 =
		"stazioneVariabile.idStazione = ?";

	private static final String _FINDER_COLUMN_STAZIONE_IDSTAZIONE_3 =
		"(stazioneVariabile.idStazione IS NULL OR stazioneVariabile.idStazione = '')";

	private FinderPath _finderPathWithPaginationFindByVariabile;
	private FinderPath _finderPathWithoutPaginationFindByVariabile;
	private FinderPath _finderPathCountByVariabile;

	/**
	 * Returns all the stazione variabiles where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @return the matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByVariabile(String idVariabile) {
		return findByVariabile(
			idVariabile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end) {

		return findByVariabile(idVariabile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return findByVariabile(
			idVariabile, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean retrieveFromCache) {

		idVariabile = Objects.toString(idVariabile, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByVariabile;
			finderArgs = new Object[] {idVariabile};
		}
		else {
			finderPath = _finderPathWithPaginationFindByVariabile;
			finderArgs = new Object[] {
				idVariabile, start, end, orderByComparator
			};
		}

		List<StazioneVariabile> list = null;

		if (retrieveFromCache) {
			list = (List<StazioneVariabile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StazioneVariabile stazioneVariabile : list) {
					if (!idVariabile.equals(
							stazioneVariabile.getIdVariabile())) {

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

			query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE);

			boolean bindIdVariabile = false;

			if (idVariabile.isEmpty()) {
				query.append(_FINDER_COLUMN_VARIABILE_IDVARIABILE_3);
			}
			else {
				bindIdVariabile = true;

				query.append(_FINDER_COLUMN_VARIABILE_IDVARIABILE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StazioneVariabileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdVariabile) {
					qPos.add(idVariabile);
				}

				if (!pagination) {
					list = (List<StazioneVariabile>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StazioneVariabile>)QueryUtil.list(
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
	 * Returns the first stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile findByVariabile_First(
			String idVariabile,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByVariabile_First(
			idVariabile, orderByComparator);

		if (stazioneVariabile != null) {
			return stazioneVariabile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idVariabile=");
		msg.append(idVariabile);

		msg.append("}");

		throw new NoSuchStazioneVariabileException(msg.toString());
	}

	/**
	 * Returns the first stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile fetchByVariabile_First(
		String idVariabile,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		List<StazioneVariabile> list = findByVariabile(
			idVariabile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile findByVariabile_Last(
			String idVariabile,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByVariabile_Last(
			idVariabile, orderByComparator);

		if (stazioneVariabile != null) {
			return stazioneVariabile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idVariabile=");
		msg.append(idVariabile);

		msg.append("}");

		throw new NoSuchStazioneVariabileException(msg.toString());
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	@Override
	public StazioneVariabile fetchByVariabile_Last(
		String idVariabile,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		int count = countByVariabile(idVariabile);

		if (count == 0) {
			return null;
		}

		List<StazioneVariabile> list = findByVariabile(
			idVariabile, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile[] findByVariabile_PrevAndNext(
			long id, String idVariabile,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws NoSuchStazioneVariabileException {

		idVariabile = Objects.toString(idVariabile, "");

		StazioneVariabile stazioneVariabile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StazioneVariabile[] array = new StazioneVariabileImpl[3];

			array[0] = getByVariabile_PrevAndNext(
				session, stazioneVariabile, idVariabile, orderByComparator,
				true);

			array[1] = stazioneVariabile;

			array[2] = getByVariabile_PrevAndNext(
				session, stazioneVariabile, idVariabile, orderByComparator,
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

	protected StazioneVariabile getByVariabile_PrevAndNext(
		Session session, StazioneVariabile stazioneVariabile,
		String idVariabile,
		OrderByComparator<StazioneVariabile> orderByComparator,
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

		query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE);

		boolean bindIdVariabile = false;

		if (idVariabile.isEmpty()) {
			query.append(_FINDER_COLUMN_VARIABILE_IDVARIABILE_3);
		}
		else {
			bindIdVariabile = true;

			query.append(_FINDER_COLUMN_VARIABILE_IDVARIABILE_2);
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
			query.append(StazioneVariabileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdVariabile) {
			qPos.add(idVariabile);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stazioneVariabile)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StazioneVariabile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stazione variabiles where idVariabile = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 */
	@Override
	public void removeByVariabile(String idVariabile) {
		for (StazioneVariabile stazioneVariabile :
				findByVariabile(
					idVariabile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stazioneVariabile);
		}
	}

	/**
	 * Returns the number of stazione variabiles where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @return the number of matching stazione variabiles
	 */
	@Override
	public int countByVariabile(String idVariabile) {
		idVariabile = Objects.toString(idVariabile, "");

		FinderPath finderPath = _finderPathCountByVariabile;

		Object[] finderArgs = new Object[] {idVariabile};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STAZIONEVARIABILE_WHERE);

			boolean bindIdVariabile = false;

			if (idVariabile.isEmpty()) {
				query.append(_FINDER_COLUMN_VARIABILE_IDVARIABILE_3);
			}
			else {
				bindIdVariabile = true;

				query.append(_FINDER_COLUMN_VARIABILE_IDVARIABILE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdVariabile) {
					qPos.add(idVariabile);
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

	private static final String _FINDER_COLUMN_VARIABILE_IDVARIABILE_2 =
		"stazioneVariabile.idVariabile = ?";

	private static final String _FINDER_COLUMN_VARIABILE_IDVARIABILE_3 =
		"(stazioneVariabile.idVariabile IS NULL OR stazioneVariabile.idVariabile = '')";

	public StazioneVariabilePersistenceImpl() {
		setModelClass(StazioneVariabile.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
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
	 * Caches the stazione variabile in the entity cache if it is enabled.
	 *
	 * @param stazioneVariabile the stazione variabile
	 */
	@Override
	public void cacheResult(StazioneVariabile stazioneVariabile) {
		entityCache.putResult(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileImpl.class, stazioneVariabile.getPrimaryKey(),
			stazioneVariabile);

		stazioneVariabile.resetOriginalValues();
	}

	/**
	 * Caches the stazione variabiles in the entity cache if it is enabled.
	 *
	 * @param stazioneVariabiles the stazione variabiles
	 */
	@Override
	public void cacheResult(List<StazioneVariabile> stazioneVariabiles) {
		for (StazioneVariabile stazioneVariabile : stazioneVariabiles) {
			if (entityCache.getResult(
					StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
					StazioneVariabileImpl.class,
					stazioneVariabile.getPrimaryKey()) == null) {

				cacheResult(stazioneVariabile);
			}
			else {
				stazioneVariabile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stazione variabiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StazioneVariabileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stazione variabile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StazioneVariabile stazioneVariabile) {
		entityCache.removeResult(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileImpl.class, stazioneVariabile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StazioneVariabile> stazioneVariabiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StazioneVariabile stazioneVariabile : stazioneVariabiles) {
			entityCache.removeResult(
				StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
				StazioneVariabileImpl.class, stazioneVariabile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stazione variabile with the primary key. Does not add the stazione variabile to the database.
	 *
	 * @param id the primary key for the new stazione variabile
	 * @return the new stazione variabile
	 */
	@Override
	public StazioneVariabile create(long id) {
		StazioneVariabile stazioneVariabile = new StazioneVariabileImpl();

		stazioneVariabile.setNew(true);
		stazioneVariabile.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		stazioneVariabile.setUuid(uuid);

		return stazioneVariabile;
	}

	/**
	 * Removes the stazione variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile that was removed
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile remove(long id)
		throws NoSuchStazioneVariabileException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the stazione variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stazione variabile
	 * @return the stazione variabile that was removed
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile remove(Serializable primaryKey)
		throws NoSuchStazioneVariabileException {

		Session session = null;

		try {
			session = openSession();

			StazioneVariabile stazioneVariabile =
				(StazioneVariabile)session.get(
					StazioneVariabileImpl.class, primaryKey);

			if (stazioneVariabile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStazioneVariabileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stazioneVariabile);
		}
		catch (NoSuchStazioneVariabileException nsee) {
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
	protected StazioneVariabile removeImpl(
		StazioneVariabile stazioneVariabile) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stazioneVariabile)) {
				stazioneVariabile = (StazioneVariabile)session.get(
					StazioneVariabileImpl.class,
					stazioneVariabile.getPrimaryKeyObj());
			}

			if (stazioneVariabile != null) {
				session.delete(stazioneVariabile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stazioneVariabile != null) {
			clearCache(stazioneVariabile);
		}

		return stazioneVariabile;
	}

	@Override
	public StazioneVariabile updateImpl(StazioneVariabile stazioneVariabile) {
		boolean isNew = stazioneVariabile.isNew();

		if (!(stazioneVariabile instanceof StazioneVariabileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stazioneVariabile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stazioneVariabile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stazioneVariabile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StazioneVariabile implementation " +
					stazioneVariabile.getClass());
		}

		StazioneVariabileModelImpl stazioneVariabileModelImpl =
			(StazioneVariabileModelImpl)stazioneVariabile;

		if (Validator.isNull(stazioneVariabile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			stazioneVariabile.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (stazioneVariabile.isNew()) {
				session.save(stazioneVariabile);

				stazioneVariabile.setNew(false);
			}
			else {
				stazioneVariabile = (StazioneVariabile)session.merge(
					stazioneVariabile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StazioneVariabileModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {stazioneVariabileModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {stazioneVariabileModelImpl.getIdStazione()};

			finderCache.removeResult(_finderPathCountByStazione, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStazione, args);

			args = new Object[] {stazioneVariabileModelImpl.getIdVariabile()};

			finderCache.removeResult(_finderPathCountByVariabile, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVariabile, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stazioneVariabileModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					stazioneVariabileModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {stazioneVariabileModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((stazioneVariabileModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStazione.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stazioneVariabileModelImpl.getOriginalIdStazione()
				};

				finderCache.removeResult(_finderPathCountByStazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStazione, args);

				args = new Object[] {
					stazioneVariabileModelImpl.getIdStazione()
				};

				finderCache.removeResult(_finderPathCountByStazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStazione, args);
			}

			if ((stazioneVariabileModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVariabile.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stazioneVariabileModelImpl.getOriginalIdVariabile()
				};

				finderCache.removeResult(_finderPathCountByVariabile, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVariabile, args);

				args = new Object[] {
					stazioneVariabileModelImpl.getIdVariabile()
				};

				finderCache.removeResult(_finderPathCountByVariabile, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVariabile, args);
			}
		}

		entityCache.putResult(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileImpl.class, stazioneVariabile.getPrimaryKey(),
			stazioneVariabile, false);

		stazioneVariabile.resetOriginalValues();

		return stazioneVariabile;
	}

	/**
	 * Returns the stazione variabile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stazione variabile
	 * @return the stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStazioneVariabileException {

		StazioneVariabile stazioneVariabile = fetchByPrimaryKey(primaryKey);

		if (stazioneVariabile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStazioneVariabileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stazioneVariabile;
	}

	/**
	 * Returns the stazione variabile with the primary key or throws a <code>NoSuchStazioneVariabileException</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile findByPrimaryKey(long id)
		throws NoSuchStazioneVariabileException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stazione variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stazione variabile
	 * @return the stazione variabile, or <code>null</code> if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StazioneVariabile stazioneVariabile = (StazioneVariabile)serializable;

		if (stazioneVariabile == null) {
			Session session = null;

			try {
				session = openSession();

				stazioneVariabile = (StazioneVariabile)session.get(
					StazioneVariabileImpl.class, primaryKey);

				if (stazioneVariabile != null) {
					cacheResult(stazioneVariabile);
				}
				else {
					entityCache.putResult(
						StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
						StazioneVariabileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
					StazioneVariabileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stazioneVariabile;
	}

	/**
	 * Returns the stazione variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile, or <code>null</code> if a stazione variabile with the primary key could not be found
	 */
	@Override
	public StazioneVariabile fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, StazioneVariabile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StazioneVariabile> map =
			new HashMap<Serializable, StazioneVariabile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StazioneVariabile stazioneVariabile = fetchByPrimaryKey(primaryKey);

			if (stazioneVariabile != null) {
				map.put(primaryKey, stazioneVariabile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
				StazioneVariabileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StazioneVariabile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_STAZIONEVARIABILE_WHERE_PKS_IN);

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

			for (StazioneVariabile stazioneVariabile :
					(List<StazioneVariabile>)q.list()) {

				map.put(
					stazioneVariabile.getPrimaryKeyObj(), stazioneVariabile);

				cacheResult(stazioneVariabile);

				uncachedPrimaryKeys.remove(
					stazioneVariabile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
					StazioneVariabileImpl.class, primaryKey, nullModel);
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
	 * Returns all the stazione variabiles.
	 *
	 * @return the stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findAll(
		int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stazione variabiles
	 */
	@Override
	public List<StazioneVariabile> findAll(
		int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
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

		List<StazioneVariabile> list = null;

		if (retrieveFromCache) {
			list = (List<StazioneVariabile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STAZIONEVARIABILE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STAZIONEVARIABILE;

				if (pagination) {
					sql = sql.concat(StazioneVariabileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StazioneVariabile>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StazioneVariabile>)QueryUtil.list(
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
	 * Removes all the stazione variabiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StazioneVariabile stazioneVariabile : findAll()) {
			remove(stazioneVariabile);
		}
	}

	/**
	 * Returns the number of stazione variabiles.
	 *
	 * @return the number of stazione variabiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STAZIONEVARIABILE);

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
		return StazioneVariabileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stazione variabile persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			StazioneVariabileModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByStazione = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStazione",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStazione = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStazione",
			new String[] {String.class.getName()},
			StazioneVariabileModelImpl.IDSTAZIONE_COLUMN_BITMASK);

		_finderPathCountByStazione = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStazione",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByVariabile = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVariabile",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVariabile = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED,
			StazioneVariabileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVariabile",
			new String[] {String.class.getName()},
			StazioneVariabileModelImpl.IDVARIABILE_COLUMN_BITMASK);

		_finderPathCountByVariabile = new FinderPath(
			StazioneVariabileModelImpl.ENTITY_CACHE_ENABLED,
			StazioneVariabileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVariabile",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(StazioneVariabileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STAZIONEVARIABILE =
		"SELECT stazioneVariabile FROM StazioneVariabile stazioneVariabile";

	private static final String _SQL_SELECT_STAZIONEVARIABILE_WHERE_PKS_IN =
		"SELECT stazioneVariabile FROM StazioneVariabile stazioneVariabile WHERE id_ IN (";

	private static final String _SQL_SELECT_STAZIONEVARIABILE_WHERE =
		"SELECT stazioneVariabile FROM StazioneVariabile stazioneVariabile WHERE ";

	private static final String _SQL_COUNT_STAZIONEVARIABILE =
		"SELECT COUNT(stazioneVariabile) FROM StazioneVariabile stazioneVariabile";

	private static final String _SQL_COUNT_STAZIONEVARIABILE_WHERE =
		"SELECT COUNT(stazioneVariabile) FROM StazioneVariabile stazioneVariabile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stazioneVariabile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StazioneVariabile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StazioneVariabile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StazioneVariabilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}