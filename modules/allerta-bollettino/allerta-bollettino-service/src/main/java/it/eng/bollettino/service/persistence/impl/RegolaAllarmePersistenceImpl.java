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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeException;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.model.impl.RegolaAllarmeImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeModelImpl;
import it.eng.bollettino.service.persistence.RegolaAllarmePersistence;

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
 * The persistence implementation for the regola allarme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmePersistenceImpl
	extends BasePersistenceImpl<RegolaAllarme>
	implements RegolaAllarmePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegolaAllarmeUtil</code> to access the regola allarme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegolaAllarmeImpl.class.getName();

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
	 * Returns all the regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator,
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

		List<RegolaAllarme> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarme regolaAllarme : list) {
					if (!uuid.equals(regolaAllarme.getUuid())) {
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

			query.append(_SQL_SELECT_REGOLAALLARME_WHERE);

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
				query.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
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
					list = (List<RegolaAllarme>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarme>)QueryUtil.list(
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
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByUuid_First(
			String uuid, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByUuid_First(
			uuid, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchRegolaAllarmeException(msg.toString());
	}

	/**
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByUuid_First(
		String uuid, OrderByComparator<RegolaAllarme> orderByComparator) {

		List<RegolaAllarme> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByUuid_Last(
			String uuid, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByUuid_Last(uuid, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchRegolaAllarmeException(msg.toString());
	}

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByUuid_Last(
		String uuid, OrderByComparator<RegolaAllarme> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarme> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		uuid = Objects.toString(uuid, "");

		RegolaAllarme regolaAllarme = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarme[] array = new RegolaAllarmeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, regolaAllarme, uuid, orderByComparator, true);

			array[1] = regolaAllarme;

			array[2] = getByUuid_PrevAndNext(
				session, regolaAllarme, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegolaAllarme getByUuid_PrevAndNext(
		Session session, RegolaAllarme regolaAllarme, String uuid,
		OrderByComparator<RegolaAllarme> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REGOLAALLARME_WHERE);

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
			query.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
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
						regolaAllarme)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarme> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegolaAllarme regolaAllarme :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarme);
		}
	}

	/**
	 * Returns the number of regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarmes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARME_WHERE);

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
		"regolaAllarme.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(regolaAllarme.uuid IS NULL OR regolaAllarme.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByAttivo;
	private FinderPath _finderPathWithoutPaginationFindByAttivo;
	private FinderPath _finderPathCountByAttivo;

	/**
	 * Returns all the regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(boolean attivo) {
		return findByAttivo(attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end) {

		return findByAttivo(attivo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return findByAttivo(attivo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByAttivo;
			finderArgs = new Object[] {attivo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByAttivo;
			finderArgs = new Object[] {attivo, start, end, orderByComparator};
		}

		List<RegolaAllarme> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarme regolaAllarme : list) {
					if ((attivo != regolaAllarme.isAttivo())) {
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

			query.append(_SQL_SELECT_REGOLAALLARME_WHERE);

			query.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attivo);

				if (!pagination) {
					list = (List<RegolaAllarme>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarme>)QueryUtil.list(
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
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByAttivo_First(
			boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByAttivo_First(
			attivo, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attivo=");
		msg.append(attivo);

		msg.append("}");

		throw new NoSuchRegolaAllarmeException(msg.toString());
	}

	/**
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByAttivo_First(
		boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator) {

		List<RegolaAllarme> list = findByAttivo(
			attivo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByAttivo_Last(
			boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByAttivo_Last(
			attivo, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attivo=");
		msg.append(attivo);

		msg.append("}");

		throw new NoSuchRegolaAllarmeException(msg.toString());
	}

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByAttivo_Last(
		boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator) {

		int count = countByAttivo(attivo);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarme> list = findByAttivo(
			attivo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme[] findByAttivo_PrevAndNext(
			long id, boolean attivo,
			OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarme[] array = new RegolaAllarmeImpl[3];

			array[0] = getByAttivo_PrevAndNext(
				session, regolaAllarme, attivo, orderByComparator, true);

			array[1] = regolaAllarme;

			array[2] = getByAttivo_PrevAndNext(
				session, regolaAllarme, attivo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegolaAllarme getByAttivo_PrevAndNext(
		Session session, RegolaAllarme regolaAllarme, boolean attivo,
		OrderByComparator<RegolaAllarme> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REGOLAALLARME_WHERE);

		query.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

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
			query.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(attivo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						regolaAllarme)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarme> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarmes where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	@Override
	public void removeByAttivo(boolean attivo) {
		for (RegolaAllarme regolaAllarme :
				findByAttivo(
					attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarme);
		}
	}

	/**
	 * Returns the number of regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching regola allarmes
	 */
	@Override
	public int countByAttivo(boolean attivo) {
		FinderPath finderPath = _finderPathCountByAttivo;

		Object[] finderArgs = new Object[] {attivo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARME_WHERE);

			query.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attivo);

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

	private static final String _FINDER_COLUMN_ATTIVO_ATTIVO_2 =
		"regolaAllarme.attivo = ?";

	public RegolaAllarmePersistenceImpl() {
		setModelClass(RegolaAllarme.class);

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
	 * Caches the regola allarme in the entity cache if it is enabled.
	 *
	 * @param regolaAllarme the regola allarme
	 */
	@Override
	public void cacheResult(RegolaAllarme regolaAllarme) {
		entityCache.putResult(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey(),
			regolaAllarme);

		regolaAllarme.resetOriginalValues();
	}

	/**
	 * Caches the regola allarmes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmes the regola allarmes
	 */
	@Override
	public void cacheResult(List<RegolaAllarme> regolaAllarmes) {
		for (RegolaAllarme regolaAllarme : regolaAllarmes) {
			if (entityCache.getResult(
					RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey()) ==
						null) {

				cacheResult(regolaAllarme);
			}
			else {
				regolaAllarme.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all regola allarmes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegolaAllarmeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the regola allarme.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegolaAllarme regolaAllarme) {
		entityCache.removeResult(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RegolaAllarme> regolaAllarmes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RegolaAllarme regolaAllarme : regolaAllarmes) {
			entityCache.removeResult(
				RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
				RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey());
		}
	}

	/**
	 * Creates a new regola allarme with the primary key. Does not add the regola allarme to the database.
	 *
	 * @param id the primary key for the new regola allarme
	 * @return the new regola allarme
	 */
	@Override
	public RegolaAllarme create(long id) {
		RegolaAllarme regolaAllarme = new RegolaAllarmeImpl();

		regolaAllarme.setNew(true);
		regolaAllarme.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		regolaAllarme.setUuid(uuid);

		return regolaAllarme;
	}

	/**
	 * Removes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme remove(long id) throws NoSuchRegolaAllarmeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme remove(Serializable primaryKey)
		throws NoSuchRegolaAllarmeException {

		Session session = null;

		try {
			session = openSession();

			RegolaAllarme regolaAllarme = (RegolaAllarme)session.get(
				RegolaAllarmeImpl.class, primaryKey);

			if (regolaAllarme == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegolaAllarmeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(regolaAllarme);
		}
		catch (NoSuchRegolaAllarmeException nsee) {
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
	protected RegolaAllarme removeImpl(RegolaAllarme regolaAllarme) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regolaAllarme)) {
				regolaAllarme = (RegolaAllarme)session.get(
					RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKeyObj());
			}

			if (regolaAllarme != null) {
				session.delete(regolaAllarme);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (regolaAllarme != null) {
			clearCache(regolaAllarme);
		}

		return regolaAllarme;
	}

	@Override
	public RegolaAllarme updateImpl(RegolaAllarme regolaAllarme) {
		boolean isNew = regolaAllarme.isNew();

		if (!(regolaAllarme instanceof RegolaAllarmeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(regolaAllarme.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					regolaAllarme);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in regolaAllarme proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegolaAllarme implementation " +
					regolaAllarme.getClass());
		}

		RegolaAllarmeModelImpl regolaAllarmeModelImpl =
			(RegolaAllarmeModelImpl)regolaAllarme;

		if (Validator.isNull(regolaAllarme.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			regolaAllarme.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (regolaAllarme.isNew()) {
				session.save(regolaAllarme);

				regolaAllarme.setNew(false);
			}
			else {
				regolaAllarme = (RegolaAllarme)session.merge(regolaAllarme);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RegolaAllarmeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {regolaAllarmeModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {regolaAllarmeModelImpl.isAttivo()};

			finderCache.removeResult(_finderPathCountByAttivo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAttivo, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((regolaAllarmeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {regolaAllarmeModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((regolaAllarmeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAttivo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeModelImpl.getOriginalAttivo()
				};

				finderCache.removeResult(_finderPathCountByAttivo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAttivo, args);

				args = new Object[] {regolaAllarmeModelImpl.isAttivo()};

				finderCache.removeResult(_finderPathCountByAttivo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAttivo, args);
			}
		}

		entityCache.putResult(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey(),
			regolaAllarme, false);

		regolaAllarme.resetOriginalValues();

		return regolaAllarme;
	}

	/**
	 * Returns the regola allarme with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByPrimaryKey(primaryKey);

		if (regolaAllarme == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegolaAllarmeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return regolaAllarme;
	}

	/**
	 * Returns the regola allarme with the primary key or throws a <code>NoSuchRegolaAllarmeException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the regola allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme
	 * @return the regola allarme, or <code>null</code> if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RegolaAllarme regolaAllarme = (RegolaAllarme)serializable;

		if (regolaAllarme == null) {
			Session session = null;

			try {
				session = openSession();

				regolaAllarme = (RegolaAllarme)session.get(
					RegolaAllarmeImpl.class, primaryKey);

				if (regolaAllarme != null) {
					cacheResult(regolaAllarme);
				}
				else {
					entityCache.putResult(
						RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
						RegolaAllarmeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return regolaAllarme;
	}

	/**
	 * Returns the regola allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme, or <code>null</code> if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RegolaAllarme> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RegolaAllarme> map =
			new HashMap<Serializable, RegolaAllarme>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RegolaAllarme regolaAllarme = fetchByPrimaryKey(primaryKey);

			if (regolaAllarme != null) {
				map.put(primaryKey, regolaAllarme);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
				RegolaAllarmeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RegolaAllarme)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_REGOLAALLARME_WHERE_PKS_IN);

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

			for (RegolaAllarme regolaAllarme : (List<RegolaAllarme>)q.list()) {
				map.put(regolaAllarme.getPrimaryKeyObj(), regolaAllarme);

				cacheResult(regolaAllarme);

				uncachedPrimaryKeys.remove(regolaAllarme.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeImpl.class, primaryKey, nullModel);
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
	 * Returns all the regola allarmes.
	 *
	 * @return the regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll(
		int start, int end, OrderByComparator<RegolaAllarme> orderByComparator,
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

		List<RegolaAllarme> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarme>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REGOLAALLARME);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGOLAALLARME;

				if (pagination) {
					sql = sql.concat(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RegolaAllarme>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarme>)QueryUtil.list(
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
	 * Removes all the regola allarmes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegolaAllarme regolaAllarme : findAll()) {
			remove(regolaAllarme);
		}
	}

	/**
	 * Returns the number of regola allarmes.
	 *
	 * @return the number of regola allarmes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REGOLAALLARME);

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
		return RegolaAllarmeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the regola allarme persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			RegolaAllarmeModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByAttivo = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAttivo",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAttivo = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAttivo", new String[] {Boolean.class.getName()},
			RegolaAllarmeModelImpl.ATTIVO_COLUMN_BITMASK);

		_finderPathCountByAttivo = new FinderPath(
			RegolaAllarmeModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttivo",
			new String[] {Boolean.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RegolaAllarmeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REGOLAALLARME =
		"SELECT regolaAllarme FROM RegolaAllarme regolaAllarme";

	private static final String _SQL_SELECT_REGOLAALLARME_WHERE_PKS_IN =
		"SELECT regolaAllarme FROM RegolaAllarme regolaAllarme WHERE id_ IN (";

	private static final String _SQL_SELECT_REGOLAALLARME_WHERE =
		"SELECT regolaAllarme FROM RegolaAllarme regolaAllarme WHERE ";

	private static final String _SQL_COUNT_REGOLAALLARME =
		"SELECT COUNT(regolaAllarme) FROM RegolaAllarme regolaAllarme";

	private static final String _SQL_COUNT_REGOLAALLARME_WHERE =
		"SELECT COUNT(regolaAllarme) FROM RegolaAllarme regolaAllarme WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "regolaAllarme.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegolaAllarme exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegolaAllarme exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegolaAllarmePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}