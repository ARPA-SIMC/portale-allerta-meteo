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

package it.eng.allerter.service.persistence.impl;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerter.exception.NoSuchAllertaValangheException;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.model.impl.AllertaValangheImpl;
import it.eng.allerter.model.impl.AllertaValangheModelImpl;
import it.eng.allerter.service.persistence.AllertaValanghePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the allerta valanghe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaValanghePersistenceImpl
	extends BasePersistenceImpl<AllertaValanghe>
	implements AllertaValanghePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllertaValangheUtil</code> to access the allerta valanghe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllertaValangheImpl.class.getName();

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
	 * Returns all the allerta valanghes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
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

		List<AllertaValanghe> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValanghe>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValanghe allertaValanghe : list) {
					if (!uuid.equals(allertaValanghe.getUuid())) {
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

			query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

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
				query.append(AllertaValangheModelImpl.ORDER_BY_JPQL);
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
					list = (List<AllertaValanghe>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValanghe>)QueryUtil.list(
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
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByUuid_First(
			String uuid, OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByUuid_First(
			uuid, orderByComparator);

		if (allertaValanghe != null) {
			return allertaValanghe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAllertaValangheException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByUuid_First(
		String uuid, OrderByComparator<AllertaValanghe> orderByComparator) {

		List<AllertaValanghe> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByUuid_Last(
			String uuid, OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByUuid_Last(
			uuid, orderByComparator);

		if (allertaValanghe != null) {
			return allertaValanghe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAllertaValangheException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByUuid_Last(
		String uuid, OrderByComparator<AllertaValanghe> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AllertaValanghe> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe[] findByUuid_PrevAndNext(
			long allertaValangheId, String uuid,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		uuid = Objects.toString(uuid, "");

		AllertaValanghe allertaValanghe = findByPrimaryKey(allertaValangheId);

		Session session = null;

		try {
			session = openSession();

			AllertaValanghe[] array = new AllertaValangheImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, allertaValanghe, uuid, orderByComparator, true);

			array[1] = allertaValanghe;

			array[2] = getByUuid_PrevAndNext(
				session, allertaValanghe, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaValanghe getByUuid_PrevAndNext(
		Session session, AllertaValanghe allertaValanghe, String uuid,
		OrderByComparator<AllertaValanghe> orderByComparator,
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

		query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

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
			query.append(AllertaValangheModelImpl.ORDER_BY_JPQL);
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
						allertaValanghe)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValanghe> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AllertaValanghe allertaValanghe :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaValanghe);
		}
	}

	/**
	 * Returns the number of allerta valanghes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta valanghes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALLERTAVALANGHE_WHERE);

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
		"allertaValanghe.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(allertaValanghe.uuid IS NULL OR allertaValanghe.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaValangheException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByUUID_G(uuid, groupId);

		if (allertaValanghe == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAllertaValangheException(msg.toString());
		}

		return allertaValanghe;
	}

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof AllertaValanghe) {
			AllertaValanghe allertaValanghe = (AllertaValanghe)result;

			if (!Objects.equals(uuid, allertaValanghe.getUuid()) ||
				(groupId != allertaValanghe.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<AllertaValanghe> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					AllertaValanghe allertaValanghe = list.get(0);

					result = allertaValanghe;

					cacheResult(allertaValanghe);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AllertaValanghe)result;
		}
	}

	/**
	 * Removes the allerta valanghe where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta valanghe that was removed
	 */
	@Override
	public AllertaValanghe removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = findByUUID_G(uuid, groupId);

		return remove(allertaValanghe);
	}

	/**
	 * Returns the number of allerta valanghes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta valanghes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ALLERTAVALANGHE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"allertaValanghe.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(allertaValanghe.uuid IS NULL OR allertaValanghe.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"allertaValanghe.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<AllertaValanghe> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValanghe>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValanghe allertaValanghe : list) {
					if (!uuid.equals(allertaValanghe.getUuid()) ||
						(companyId != allertaValanghe.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AllertaValangheModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<AllertaValanghe>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValanghe>)QueryUtil.list(
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
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (allertaValanghe != null) {
			return allertaValanghe;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchAllertaValangheException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		List<AllertaValanghe> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (allertaValanghe != null) {
			return allertaValanghe;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchAllertaValangheException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AllertaValanghe> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe[] findByUuid_C_PrevAndNext(
			long allertaValangheId, String uuid, long companyId,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		uuid = Objects.toString(uuid, "");

		AllertaValanghe allertaValanghe = findByPrimaryKey(allertaValangheId);

		Session session = null;

		try {
			session = openSession();

			AllertaValanghe[] array = new AllertaValangheImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, allertaValanghe, uuid, companyId, orderByComparator,
				true);

			array[1] = allertaValanghe;

			array[2] = getByUuid_C_PrevAndNext(
				session, allertaValanghe, uuid, companyId, orderByComparator,
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

	protected AllertaValanghe getByUuid_C_PrevAndNext(
		Session session, AllertaValanghe allertaValanghe, String uuid,
		long companyId, OrderByComparator<AllertaValanghe> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(AllertaValangheModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						allertaValanghe)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValanghe> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AllertaValanghe allertaValanghe :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allertaValanghe);
		}
	}

	/**
	 * Returns the number of allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta valanghes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ALLERTAVALANGHE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"allertaValanghe.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(allertaValanghe.uuid IS NULL OR allertaValanghe.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"allertaValanghe.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNumero;
	private FinderPath _finderPathWithoutPaginationFindByNumero;
	private FinderPath _finderPathCountByNumero;

	/**
	 * Returns all the allerta valanghes where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByNumero(String numero) {
		return findByNumero(numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByNumero(
		String numero, int start, int end) {

		return findByNumero(numero, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByNumero(
		String numero, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return findByNumero(numero, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findByNumero(
		String numero, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
		boolean retrieveFromCache) {

		numero = Objects.toString(numero, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNumero;
			finderArgs = new Object[] {numero};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNumero;
			finderArgs = new Object[] {numero, start, end, orderByComparator};
		}

		List<AllertaValanghe> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValanghe>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValanghe allertaValanghe : list) {
					if (!numero.equals(allertaValanghe.getNumero())) {
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

			query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				query.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
			}
			else {
				bindNumero = true;

				query.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AllertaValangheModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumero) {
					qPos.add(numero);
				}

				if (!pagination) {
					list = (List<AllertaValanghe>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValanghe>)QueryUtil.list(
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
	 * Returns the first allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByNumero_First(
			String numero, OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByNumero_First(
			numero, orderByComparator);

		if (allertaValanghe != null) {
			return allertaValanghe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numero=");
		msg.append(numero);

		msg.append("}");

		throw new NoSuchAllertaValangheException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByNumero_First(
		String numero, OrderByComparator<AllertaValanghe> orderByComparator) {

		List<AllertaValanghe> list = findByNumero(
			numero, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe findByNumero_Last(
			String numero, OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByNumero_Last(
			numero, orderByComparator);

		if (allertaValanghe != null) {
			return allertaValanghe;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numero=");
		msg.append(numero);

		msg.append("}");

		throw new NoSuchAllertaValangheException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public AllertaValanghe fetchByNumero_Last(
		String numero, OrderByComparator<AllertaValanghe> orderByComparator) {

		int count = countByNumero(numero);

		if (count == 0) {
			return null;
		}

		List<AllertaValanghe> list = findByNumero(
			numero, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe[] findByNumero_PrevAndNext(
			long allertaValangheId, String numero,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws NoSuchAllertaValangheException {

		numero = Objects.toString(numero, "");

		AllertaValanghe allertaValanghe = findByPrimaryKey(allertaValangheId);

		Session session = null;

		try {
			session = openSession();

			AllertaValanghe[] array = new AllertaValangheImpl[3];

			array[0] = getByNumero_PrevAndNext(
				session, allertaValanghe, numero, orderByComparator, true);

			array[1] = allertaValanghe;

			array[2] = getByNumero_PrevAndNext(
				session, allertaValanghe, numero, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaValanghe getByNumero_PrevAndNext(
		Session session, AllertaValanghe allertaValanghe, String numero,
		OrderByComparator<AllertaValanghe> orderByComparator,
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

		query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE);

		boolean bindNumero = false;

		if (numero.isEmpty()) {
			query.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
		}
		else {
			bindNumero = true;

			query.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
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
			query.append(AllertaValangheModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNumero) {
			qPos.add(numero);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						allertaValanghe)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValanghe> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghes where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	@Override
	public void removeByNumero(String numero) {
		for (AllertaValanghe allertaValanghe :
				findByNumero(
					numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaValanghe);
		}
	}

	/**
	 * Returns the number of allerta valanghes where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching allerta valanghes
	 */
	@Override
	public int countByNumero(String numero) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumero;

		Object[] finderArgs = new Object[] {numero};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALLERTAVALANGHE_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				query.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
			}
			else {
				bindNumero = true;

				query.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumero) {
					qPos.add(numero);
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

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_2 =
		"allertaValanghe.numero = ?";

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_3 =
		"(allertaValanghe.numero IS NULL OR allertaValanghe.numero = '')";

	public AllertaValanghePersistenceImpl() {
		setModelClass(AllertaValanghe.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

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
	 * Caches the allerta valanghe in the entity cache if it is enabled.
	 *
	 * @param allertaValanghe the allerta valanghe
	 */
	@Override
	public void cacheResult(AllertaValanghe allertaValanghe) {
		entityCache.putResult(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheImpl.class, allertaValanghe.getPrimaryKey(),
			allertaValanghe);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				allertaValanghe.getUuid(), allertaValanghe.getGroupId()
			},
			allertaValanghe);

		allertaValanghe.resetOriginalValues();
	}

	/**
	 * Caches the allerta valanghes in the entity cache if it is enabled.
	 *
	 * @param allertaValanghes the allerta valanghes
	 */
	@Override
	public void cacheResult(List<AllertaValanghe> allertaValanghes) {
		for (AllertaValanghe allertaValanghe : allertaValanghes) {
			if (entityCache.getResult(
					AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
					AllertaValangheImpl.class,
					allertaValanghe.getPrimaryKey()) == null) {

				cacheResult(allertaValanghe);
			}
			else {
				allertaValanghe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all allerta valanghes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllertaValangheImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the allerta valanghe.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllertaValanghe allertaValanghe) {
		entityCache.removeResult(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheImpl.class, allertaValanghe.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(AllertaValangheModelImpl)allertaValanghe, true);
	}

	@Override
	public void clearCache(List<AllertaValanghe> allertaValanghes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AllertaValanghe allertaValanghe : allertaValanghes) {
			entityCache.removeResult(
				AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
				AllertaValangheImpl.class, allertaValanghe.getPrimaryKey());

			clearUniqueFindersCache(
				(AllertaValangheModelImpl)allertaValanghe, true);
		}
	}

	protected void cacheUniqueFindersCache(
		AllertaValangheModelImpl allertaValangheModelImpl) {

		Object[] args = new Object[] {
			allertaValangheModelImpl.getUuid(),
			allertaValangheModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, allertaValangheModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AllertaValangheModelImpl allertaValangheModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				allertaValangheModelImpl.getUuid(),
				allertaValangheModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((allertaValangheModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				allertaValangheModelImpl.getOriginalUuid(),
				allertaValangheModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new allerta valanghe with the primary key. Does not add the allerta valanghe to the database.
	 *
	 * @param allertaValangheId the primary key for the new allerta valanghe
	 * @return the new allerta valanghe
	 */
	@Override
	public AllertaValanghe create(long allertaValangheId) {
		AllertaValanghe allertaValanghe = new AllertaValangheImpl();

		allertaValanghe.setNew(true);
		allertaValanghe.setPrimaryKey(allertaValangheId);

		String uuid = PortalUUIDUtil.generate();

		allertaValanghe.setUuid(uuid);

		allertaValanghe.setCompanyId(companyProvider.getCompanyId());

		return allertaValanghe;
	}

	/**
	 * Removes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe remove(long allertaValangheId)
		throws NoSuchAllertaValangheException {

		return remove((Serializable)allertaValangheId);
	}

	/**
	 * Removes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe remove(Serializable primaryKey)
		throws NoSuchAllertaValangheException {

		Session session = null;

		try {
			session = openSession();

			AllertaValanghe allertaValanghe = (AllertaValanghe)session.get(
				AllertaValangheImpl.class, primaryKey);

			if (allertaValanghe == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllertaValangheException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allertaValanghe);
		}
		catch (NoSuchAllertaValangheException nsee) {
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
	protected AllertaValanghe removeImpl(AllertaValanghe allertaValanghe) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allertaValanghe)) {
				allertaValanghe = (AllertaValanghe)session.get(
					AllertaValangheImpl.class,
					allertaValanghe.getPrimaryKeyObj());
			}

			if (allertaValanghe != null) {
				session.delete(allertaValanghe);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (allertaValanghe != null) {
			clearCache(allertaValanghe);
		}

		return allertaValanghe;
	}

	@Override
	public AllertaValanghe updateImpl(AllertaValanghe allertaValanghe) {
		boolean isNew = allertaValanghe.isNew();

		if (!(allertaValanghe instanceof AllertaValangheModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(allertaValanghe.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					allertaValanghe);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in allertaValanghe proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AllertaValanghe implementation " +
					allertaValanghe.getClass());
		}

		AllertaValangheModelImpl allertaValangheModelImpl =
			(AllertaValangheModelImpl)allertaValanghe;

		if (Validator.isNull(allertaValanghe.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			allertaValanghe.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (allertaValanghe.getCreateDate() == null)) {
			if (serviceContext == null) {
				allertaValanghe.setCreateDate(now);
			}
			else {
				allertaValanghe.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!allertaValangheModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				allertaValanghe.setModifiedDate(now);
			}
			else {
				allertaValanghe.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (allertaValanghe.isNew()) {
				session.save(allertaValanghe);

				allertaValanghe.setNew(false);
			}
			else {
				allertaValanghe = (AllertaValanghe)session.merge(
					allertaValanghe);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AllertaValangheModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {allertaValangheModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				allertaValangheModelImpl.getUuid(),
				allertaValangheModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {allertaValangheModelImpl.getNumero()};

			finderCache.removeResult(_finderPathCountByNumero, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNumero, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((allertaValangheModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					allertaValangheModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {allertaValangheModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((allertaValangheModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					allertaValangheModelImpl.getOriginalUuid(),
					allertaValangheModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					allertaValangheModelImpl.getUuid(),
					allertaValangheModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((allertaValangheModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNumero.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					allertaValangheModelImpl.getOriginalNumero()
				};

				finderCache.removeResult(_finderPathCountByNumero, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNumero, args);

				args = new Object[] {allertaValangheModelImpl.getNumero()};

				finderCache.removeResult(_finderPathCountByNumero, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNumero, args);
			}
		}

		entityCache.putResult(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheImpl.class, allertaValanghe.getPrimaryKey(),
			allertaValanghe, false);

		clearUniqueFindersCache(allertaValangheModelImpl, false);
		cacheUniqueFindersCache(allertaValangheModelImpl);

		allertaValanghe.resetOriginalValues();

		return allertaValanghe;
	}

	/**
	 * Returns the allerta valanghe with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllertaValangheException {

		AllertaValanghe allertaValanghe = fetchByPrimaryKey(primaryKey);

		if (allertaValanghe == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllertaValangheException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allertaValanghe;
	}

	/**
	 * Returns the allerta valanghe with the primary key or throws a <code>NoSuchAllertaValangheException</code> if it could not be found.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe findByPrimaryKey(long allertaValangheId)
		throws NoSuchAllertaValangheException {

		return findByPrimaryKey((Serializable)allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta valanghe
	 * @return the allerta valanghe, or <code>null</code> if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AllertaValanghe allertaValanghe = (AllertaValanghe)serializable;

		if (allertaValanghe == null) {
			Session session = null;

			try {
				session = openSession();

				allertaValanghe = (AllertaValanghe)session.get(
					AllertaValangheImpl.class, primaryKey);

				if (allertaValanghe != null) {
					cacheResult(allertaValanghe);
				}
				else {
					entityCache.putResult(
						AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
						AllertaValangheImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
					AllertaValangheImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return allertaValanghe;
	}

	/**
	 * Returns the allerta valanghe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe, or <code>null</code> if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public AllertaValanghe fetchByPrimaryKey(long allertaValangheId) {
		return fetchByPrimaryKey((Serializable)allertaValangheId);
	}

	@Override
	public Map<Serializable, AllertaValanghe> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AllertaValanghe> map =
			new HashMap<Serializable, AllertaValanghe>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AllertaValanghe allertaValanghe = fetchByPrimaryKey(primaryKey);

			if (allertaValanghe != null) {
				map.put(primaryKey, allertaValanghe);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
				AllertaValangheImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AllertaValanghe)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ALLERTAVALANGHE_WHERE_PKS_IN);

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

			for (AllertaValanghe allertaValanghe :
					(List<AllertaValanghe>)q.list()) {

				map.put(allertaValanghe.getPrimaryKeyObj(), allertaValanghe);

				cacheResult(allertaValanghe);

				uncachedPrimaryKeys.remove(allertaValanghe.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
					AllertaValangheImpl.class, primaryKey, nullModel);
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
	 * Returns all the allerta valanghes.
	 *
	 * @return the allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findAll(
		int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta valanghes
	 */
	@Override
	public List<AllertaValanghe> findAll(
		int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
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

		List<AllertaValanghe> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValanghe>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALLERTAVALANGHE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALLERTAVALANGHE;

				if (pagination) {
					sql = sql.concat(AllertaValangheModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AllertaValanghe>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValanghe>)QueryUtil.list(
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
	 * Removes all the allerta valanghes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AllertaValanghe allertaValanghe : findAll()) {
			remove(allertaValanghe);
		}
	}

	/**
	 * Returns the number of allerta valanghes.
	 *
	 * @return the number of allerta valanghes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALLERTAVALANGHE);

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
		return AllertaValangheModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allerta valanghe persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			AllertaValangheModelImpl.UUID_COLUMN_BITMASK |
			AllertaValangheModelImpl.NUMERO_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			AllertaValangheModelImpl.UUID_COLUMN_BITMASK |
			AllertaValangheModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			AllertaValangheModelImpl.UUID_COLUMN_BITMASK |
			AllertaValangheModelImpl.COMPANYID_COLUMN_BITMASK |
			AllertaValangheModelImpl.NUMERO_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByNumero = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNumero",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNumero = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumero",
			new String[] {String.class.getName()},
			AllertaValangheModelImpl.NUMERO_COLUMN_BITMASK);

		_finderPathCountByNumero = new FinderPath(
			AllertaValangheModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumero",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AllertaValangheImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALLERTAVALANGHE =
		"SELECT allertaValanghe FROM AllertaValanghe allertaValanghe";

	private static final String _SQL_SELECT_ALLERTAVALANGHE_WHERE_PKS_IN =
		"SELECT allertaValanghe FROM AllertaValanghe allertaValanghe WHERE allertaValangheId IN (";

	private static final String _SQL_SELECT_ALLERTAVALANGHE_WHERE =
		"SELECT allertaValanghe FROM AllertaValanghe allertaValanghe WHERE ";

	private static final String _SQL_COUNT_ALLERTAVALANGHE =
		"SELECT COUNT(allertaValanghe) FROM AllertaValanghe allertaValanghe";

	private static final String _SQL_COUNT_ALLERTAVALANGHE_WHERE =
		"SELECT COUNT(allertaValanghe) FROM AllertaValanghe allertaValanghe WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allertaValanghe.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AllertaValanghe exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AllertaValanghe exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaValanghePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}