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

import it.eng.allerter.exception.NoSuchAllertaValangheStatoException;
import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.model.impl.AllertaValangheStatoImpl;
import it.eng.allerter.model.impl.AllertaValangheStatoModelImpl;
import it.eng.allerter.service.persistence.AllertaValangheStatoPersistence;

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
 * The persistence implementation for the allerta valanghe stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaValangheStatoPersistenceImpl
	extends BasePersistenceImpl<AllertaValangheStato>
	implements AllertaValangheStatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllertaValangheStatoUtil</code> to access the allerta valanghe stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllertaValangheStatoImpl.class.getName();

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
	 * Returns all the allerta valanghe statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		List<AllertaValangheStato> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValangheStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValangheStato allertaValangheStato : list) {
					if (!uuid.equals(allertaValangheStato.getUuid())) {
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

			query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

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
				query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<AllertaValangheStato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValangheStato>)QueryUtil.list(
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
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByUuid_First(
			String uuid,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByUuid_First(
			uuid, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByUuid_First(
		String uuid,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		List<AllertaValangheStato> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByUuid_Last(
			String uuid,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByUuid_Last(
			uuid, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByUuid_Last(
		String uuid,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AllertaValangheStato> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato[] findByUuid_PrevAndNext(
			long allertaValangheStatoId, String uuid,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		uuid = Objects.toString(uuid, "");

		AllertaValangheStato allertaValangheStato = findByPrimaryKey(
			allertaValangheStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaValangheStato[] array = new AllertaValangheStatoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, allertaValangheStato, uuid, orderByComparator, true);

			array[1] = allertaValangheStato;

			array[2] = getByUuid_PrevAndNext(
				session, allertaValangheStato, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaValangheStato getByUuid_PrevAndNext(
		Session session, AllertaValangheStato allertaValangheStato, String uuid,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

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
			query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
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
						allertaValangheStato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValangheStato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghe statos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AllertaValangheStato allertaValangheStato :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaValangheStato);
		}
	}

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta valanghe statos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALLERTAVALANGHESTATO_WHERE);

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
		"allertaValangheStato.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(allertaValangheStato.uuid IS NULL OR allertaValangheStato.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaValangheStatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByUUID_G(
			uuid, groupId);

		if (allertaValangheStato == null) {
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

			throw new NoSuchAllertaValangheStatoException(msg.toString());
		}

		return allertaValangheStato;
	}

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof AllertaValangheStato) {
			AllertaValangheStato allertaValangheStato =
				(AllertaValangheStato)result;

			if (!Objects.equals(uuid, allertaValangheStato.getUuid()) ||
				(groupId != allertaValangheStato.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

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

				List<AllertaValangheStato> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					AllertaValangheStato allertaValangheStato = list.get(0);

					result = allertaValangheStato;

					cacheResult(allertaValangheStato);
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
			return (AllertaValangheStato)result;
		}
	}

	/**
	 * Removes the allerta valanghe stato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta valanghe stato that was removed
	 */
	@Override
	public AllertaValangheStato removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = findByUUID_G(uuid, groupId);

		return remove(allertaValangheStato);
	}

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta valanghe statos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ALLERTAVALANGHESTATO_WHERE);

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
		"allertaValangheStato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(allertaValangheStato.uuid IS NULL OR allertaValangheStato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"allertaValangheStato.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		List<AllertaValangheStato> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValangheStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValangheStato allertaValangheStato : list) {
					if (!uuid.equals(allertaValangheStato.getUuid()) ||
						(companyId != allertaValangheStato.getCompanyId())) {

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

			query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

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
				query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
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
					list = (List<AllertaValangheStato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValangheStato>)QueryUtil.list(
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
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		List<AllertaValangheStato> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AllertaValangheStato> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato[] findByUuid_C_PrevAndNext(
			long allertaValangheStatoId, String uuid, long companyId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		uuid = Objects.toString(uuid, "");

		AllertaValangheStato allertaValangheStato = findByPrimaryKey(
			allertaValangheStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaValangheStato[] array = new AllertaValangheStatoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, allertaValangheStato, uuid, companyId,
				orderByComparator, true);

			array[1] = allertaValangheStato;

			array[2] = getByUuid_C_PrevAndNext(
				session, allertaValangheStato, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaValangheStato getByUuid_C_PrevAndNext(
		Session session, AllertaValangheStato allertaValangheStato, String uuid,
		long companyId,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

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
			query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
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
						allertaValangheStato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValangheStato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghe statos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AllertaValangheStato allertaValangheStato :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allertaValangheStato);
		}
	}

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta valanghe statos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ALLERTAVALANGHESTATO_WHERE);

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
		"allertaValangheStato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(allertaValangheStato.uuid IS NULL OR allertaValangheStato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"allertaValangheStato.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNome;
	private FinderPath _finderPathWithoutPaginationFindByNome;
	private FinderPath _finderPathCountByNome;

	/**
	 * Returns all the allerta valanghe statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByNome(String nome) {
		return findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByNome(
		String nome, int start, int end) {

		return findByNome(nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return findByNome(nome, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean retrieveFromCache) {

		nome = Objects.toString(nome, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNome;
			finderArgs = new Object[] {nome};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNome;
			finderArgs = new Object[] {nome, start, end, orderByComparator};
		}

		List<AllertaValangheStato> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValangheStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValangheStato allertaValangheStato : list) {
					if (!nome.equals(allertaValangheStato.getNome())) {
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

			query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

			boolean bindNome = false;

			if (nome.isEmpty()) {
				query.append(_FINDER_COLUMN_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNome) {
					qPos.add(nome);
				}

				if (!pagination) {
					list = (List<AllertaValangheStato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValangheStato>)QueryUtil.list(
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
	 * Returns the first allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByNome_First(
			String nome,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByNome_First(
			nome, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByNome_First(
		String nome,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		List<AllertaValangheStato> list = findByNome(
			nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByNome_Last(
			String nome,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByNome_Last(
			nome, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByNome_Last(
		String nome,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		int count = countByNome(nome);

		if (count == 0) {
			return null;
		}

		List<AllertaValangheStato> list = findByNome(
			nome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato[] findByNome_PrevAndNext(
			long allertaValangheStatoId, String nome,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		nome = Objects.toString(nome, "");

		AllertaValangheStato allertaValangheStato = findByPrimaryKey(
			allertaValangheStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaValangheStato[] array = new AllertaValangheStatoImpl[3];

			array[0] = getByNome_PrevAndNext(
				session, allertaValangheStato, nome, orderByComparator, true);

			array[1] = allertaValangheStato;

			array[2] = getByNome_PrevAndNext(
				session, allertaValangheStato, nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaValangheStato getByNome_PrevAndNext(
		Session session, AllertaValangheStato allertaValangheStato, String nome,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

		boolean bindNome = false;

		if (nome.isEmpty()) {
			query.append(_FINDER_COLUMN_NOME_NOME_3);
		}
		else {
			bindNome = true;

			query.append(_FINDER_COLUMN_NOME_NOME_2);
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
			query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNome) {
			qPos.add(nome);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						allertaValangheStato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValangheStato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghe statos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByNome(String nome) {
		for (AllertaValangheStato allertaValangheStato :
				findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaValangheStato);
		}
	}

	/**
	 * Returns the number of allerta valanghe statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching allerta valanghe statos
	 */
	@Override
	public int countByNome(String nome) {
		nome = Objects.toString(nome, "");

		FinderPath finderPath = _finderPathCountByNome;

		Object[] finderArgs = new Object[] {nome};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALLERTAVALANGHESTATO_WHERE);

			boolean bindNome = false;

			if (nome.isEmpty()) {
				query.append(_FINDER_COLUMN_NOME_NOME_3);
			}
			else {
				bindNome = true;

				query.append(_FINDER_COLUMN_NOME_NOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNome) {
					qPos.add(nome);
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

	private static final String _FINDER_COLUMN_NOME_NOME_2 =
		"allertaValangheStato.nome = ?";

	private static final String _FINDER_COLUMN_NOME_NOME_3 =
		"(allertaValangheStato.nome IS NULL OR allertaValangheStato.nome = '')";

	private FinderPath _finderPathWithPaginationFindByAllertaValangheId;
	private FinderPath _finderPathWithoutPaginationFindByAllertaValangheId;
	private FinderPath _finderPathCountByAllertaValangheId;

	/**
	 * Returns all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @return the matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId) {

		return findByAllertaValangheId(
			allertaValangheId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end) {

		return findByAllertaValangheId(allertaValangheId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return findByAllertaValangheId(
			allertaValangheId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByAllertaValangheId;
			finderArgs = new Object[] {allertaValangheId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByAllertaValangheId;
			finderArgs = new Object[] {
				allertaValangheId, start, end, orderByComparator
			};
		}

		List<AllertaValangheStato> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValangheStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaValangheStato allertaValangheStato : list) {
					if ((allertaValangheId !=
							allertaValangheStato.getAllertaValangheId())) {

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

			query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

			query.append(_FINDER_COLUMN_ALLERTAVALANGHEID_ALLERTAVALANGHEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(allertaValangheId);

				if (!pagination) {
					list = (List<AllertaValangheStato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValangheStato>)QueryUtil.list(
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
	 * Returns the first allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByAllertaValangheId_First(
			long allertaValangheId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato =
			fetchByAllertaValangheId_First(
				allertaValangheId, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("allertaValangheId=");
		msg.append(allertaValangheId);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByAllertaValangheId_First(
		long allertaValangheId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		List<AllertaValangheStato> list = findByAllertaValangheId(
			allertaValangheId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato findByAllertaValangheId_Last(
			long allertaValangheId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato =
			fetchByAllertaValangheId_Last(allertaValangheId, orderByComparator);

		if (allertaValangheStato != null) {
			return allertaValangheStato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("allertaValangheId=");
		msg.append(allertaValangheId);

		msg.append("}");

		throw new NoSuchAllertaValangheStatoException(msg.toString());
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public AllertaValangheStato fetchByAllertaValangheId_Last(
		long allertaValangheId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		int count = countByAllertaValangheId(allertaValangheId);

		if (count == 0) {
			return null;
		}

		List<AllertaValangheStato> list = findByAllertaValangheId(
			allertaValangheId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato[] findByAllertaValangheId_PrevAndNext(
			long allertaValangheStatoId, long allertaValangheId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = findByPrimaryKey(
			allertaValangheStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaValangheStato[] array = new AllertaValangheStatoImpl[3];

			array[0] = getByAllertaValangheId_PrevAndNext(
				session, allertaValangheStato, allertaValangheId,
				orderByComparator, true);

			array[1] = allertaValangheStato;

			array[2] = getByAllertaValangheId_PrevAndNext(
				session, allertaValangheStato, allertaValangheId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaValangheStato getByAllertaValangheId_PrevAndNext(
		Session session, AllertaValangheStato allertaValangheStato,
		long allertaValangheId,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE);

		query.append(_FINDER_COLUMN_ALLERTAVALANGHEID_ALLERTAVALANGHEID_2);

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
			query.append(AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(allertaValangheId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						allertaValangheStato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AllertaValangheStato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta valanghe statos where allertaValangheId = &#63; from the database.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 */
	@Override
	public void removeByAllertaValangheId(long allertaValangheId) {
		for (AllertaValangheStato allertaValangheStato :
				findByAllertaValangheId(
					allertaValangheId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allertaValangheStato);
		}
	}

	/**
	 * Returns the number of allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @return the number of matching allerta valanghe statos
	 */
	@Override
	public int countByAllertaValangheId(long allertaValangheId) {
		FinderPath finderPath = _finderPathCountByAllertaValangheId;

		Object[] finderArgs = new Object[] {allertaValangheId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALLERTAVALANGHESTATO_WHERE);

			query.append(_FINDER_COLUMN_ALLERTAVALANGHEID_ALLERTAVALANGHEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(allertaValangheId);

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
		_FINDER_COLUMN_ALLERTAVALANGHEID_ALLERTAVALANGHEID_2 =
			"allertaValangheStato.allertaValangheId = ?";

	public AllertaValangheStatoPersistenceImpl() {
		setModelClass(AllertaValangheStato.class);

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
	 * Caches the allerta valanghe stato in the entity cache if it is enabled.
	 *
	 * @param allertaValangheStato the allerta valanghe stato
	 */
	@Override
	public void cacheResult(AllertaValangheStato allertaValangheStato) {
		entityCache.putResult(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			allertaValangheStato.getPrimaryKey(), allertaValangheStato);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				allertaValangheStato.getUuid(),
				allertaValangheStato.getGroupId()
			},
			allertaValangheStato);

		allertaValangheStato.resetOriginalValues();
	}

	/**
	 * Caches the allerta valanghe statos in the entity cache if it is enabled.
	 *
	 * @param allertaValangheStatos the allerta valanghe statos
	 */
	@Override
	public void cacheResult(List<AllertaValangheStato> allertaValangheStatos) {
		for (AllertaValangheStato allertaValangheStato :
				allertaValangheStatos) {

			if (entityCache.getResult(
					AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
					AllertaValangheStatoImpl.class,
					allertaValangheStato.getPrimaryKey()) == null) {

				cacheResult(allertaValangheStato);
			}
			else {
				allertaValangheStato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all allerta valanghe statos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllertaValangheStatoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the allerta valanghe stato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllertaValangheStato allertaValangheStato) {
		entityCache.removeResult(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			allertaValangheStato.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(AllertaValangheStatoModelImpl)allertaValangheStato, true);
	}

	@Override
	public void clearCache(List<AllertaValangheStato> allertaValangheStatos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AllertaValangheStato allertaValangheStato :
				allertaValangheStatos) {

			entityCache.removeResult(
				AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
				AllertaValangheStatoImpl.class,
				allertaValangheStato.getPrimaryKey());

			clearUniqueFindersCache(
				(AllertaValangheStatoModelImpl)allertaValangheStato, true);
		}
	}

	protected void cacheUniqueFindersCache(
		AllertaValangheStatoModelImpl allertaValangheStatoModelImpl) {

		Object[] args = new Object[] {
			allertaValangheStatoModelImpl.getUuid(),
			allertaValangheStatoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, allertaValangheStatoModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		AllertaValangheStatoModelImpl allertaValangheStatoModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				allertaValangheStatoModelImpl.getUuid(),
				allertaValangheStatoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((allertaValangheStatoModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				allertaValangheStatoModelImpl.getOriginalUuid(),
				allertaValangheStatoModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new allerta valanghe stato with the primary key. Does not add the allerta valanghe stato to the database.
	 *
	 * @param allertaValangheStatoId the primary key for the new allerta valanghe stato
	 * @return the new allerta valanghe stato
	 */
	@Override
	public AllertaValangheStato create(long allertaValangheStatoId) {
		AllertaValangheStato allertaValangheStato =
			new AllertaValangheStatoImpl();

		allertaValangheStato.setNew(true);
		allertaValangheStato.setPrimaryKey(allertaValangheStatoId);

		String uuid = PortalUUIDUtil.generate();

		allertaValangheStato.setUuid(uuid);

		allertaValangheStato.setCompanyId(companyProvider.getCompanyId());

		return allertaValangheStato;
	}

	/**
	 * Removes the allerta valanghe stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato that was removed
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato remove(long allertaValangheStatoId)
		throws NoSuchAllertaValangheStatoException {

		return remove((Serializable)allertaValangheStatoId);
	}

	/**
	 * Removes the allerta valanghe stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato that was removed
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato remove(Serializable primaryKey)
		throws NoSuchAllertaValangheStatoException {

		Session session = null;

		try {
			session = openSession();

			AllertaValangheStato allertaValangheStato =
				(AllertaValangheStato)session.get(
					AllertaValangheStatoImpl.class, primaryKey);

			if (allertaValangheStato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllertaValangheStatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allertaValangheStato);
		}
		catch (NoSuchAllertaValangheStatoException nsee) {
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
	protected AllertaValangheStato removeImpl(
		AllertaValangheStato allertaValangheStato) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allertaValangheStato)) {
				allertaValangheStato = (AllertaValangheStato)session.get(
					AllertaValangheStatoImpl.class,
					allertaValangheStato.getPrimaryKeyObj());
			}

			if (allertaValangheStato != null) {
				session.delete(allertaValangheStato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (allertaValangheStato != null) {
			clearCache(allertaValangheStato);
		}

		return allertaValangheStato;
	}

	@Override
	public AllertaValangheStato updateImpl(
		AllertaValangheStato allertaValangheStato) {

		boolean isNew = allertaValangheStato.isNew();

		if (!(allertaValangheStato instanceof AllertaValangheStatoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(allertaValangheStato.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					allertaValangheStato);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in allertaValangheStato proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AllertaValangheStato implementation " +
					allertaValangheStato.getClass());
		}

		AllertaValangheStatoModelImpl allertaValangheStatoModelImpl =
			(AllertaValangheStatoModelImpl)allertaValangheStato;

		if (Validator.isNull(allertaValangheStato.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			allertaValangheStato.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (allertaValangheStato.getCreateDate() == null)) {
			if (serviceContext == null) {
				allertaValangheStato.setCreateDate(now);
			}
			else {
				allertaValangheStato.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!allertaValangheStatoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				allertaValangheStato.setModifiedDate(now);
			}
			else {
				allertaValangheStato.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (allertaValangheStato.isNew()) {
				session.save(allertaValangheStato);

				allertaValangheStato.setNew(false);
			}
			else {
				allertaValangheStato = (AllertaValangheStato)session.merge(
					allertaValangheStato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AllertaValangheStatoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				allertaValangheStatoModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				allertaValangheStatoModelImpl.getUuid(),
				allertaValangheStatoModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {allertaValangheStatoModelImpl.getNome()};

			finderCache.removeResult(_finderPathCountByNome, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNome, args);

			args = new Object[] {
				allertaValangheStatoModelImpl.getAllertaValangheId()
			};

			finderCache.removeResult(_finderPathCountByAllertaValangheId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAllertaValangheId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((allertaValangheStatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					allertaValangheStatoModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {allertaValangheStatoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((allertaValangheStatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					allertaValangheStatoModelImpl.getOriginalUuid(),
					allertaValangheStatoModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					allertaValangheStatoModelImpl.getUuid(),
					allertaValangheStatoModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((allertaValangheStatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNome.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					allertaValangheStatoModelImpl.getOriginalNome()
				};

				finderCache.removeResult(_finderPathCountByNome, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNome, args);

				args = new Object[] {allertaValangheStatoModelImpl.getNome()};

				finderCache.removeResult(_finderPathCountByNome, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNome, args);
			}

			if ((allertaValangheStatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAllertaValangheId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					allertaValangheStatoModelImpl.getOriginalAllertaValangheId()
				};

				finderCache.removeResult(
					_finderPathCountByAllertaValangheId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAllertaValangheId, args);

				args = new Object[] {
					allertaValangheStatoModelImpl.getAllertaValangheId()
				};

				finderCache.removeResult(
					_finderPathCountByAllertaValangheId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAllertaValangheId, args);
			}
		}

		entityCache.putResult(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			allertaValangheStato.getPrimaryKey(), allertaValangheStato, false);

		clearUniqueFindersCache(allertaValangheStatoModelImpl, false);
		cacheUniqueFindersCache(allertaValangheStatoModelImpl);

		allertaValangheStato.resetOriginalValues();

		return allertaValangheStato;
	}

	/**
	 * Returns the allerta valanghe stato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllertaValangheStatoException {

		AllertaValangheStato allertaValangheStato = fetchByPrimaryKey(
			primaryKey);

		if (allertaValangheStato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllertaValangheStatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allertaValangheStato;
	}

	/**
	 * Returns the allerta valanghe stato with the primary key or throws a <code>NoSuchAllertaValangheStatoException</code> if it could not be found.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato findByPrimaryKey(long allertaValangheStatoId)
		throws NoSuchAllertaValangheStatoException {

		return findByPrimaryKey((Serializable)allertaValangheStatoId);
	}

	/**
	 * Returns the allerta valanghe stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato, or <code>null</code> if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AllertaValangheStato allertaValangheStato =
			(AllertaValangheStato)serializable;

		if (allertaValangheStato == null) {
			Session session = null;

			try {
				session = openSession();

				allertaValangheStato = (AllertaValangheStato)session.get(
					AllertaValangheStatoImpl.class, primaryKey);

				if (allertaValangheStato != null) {
					cacheResult(allertaValangheStato);
				}
				else {
					entityCache.putResult(
						AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
						AllertaValangheStatoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
					AllertaValangheStatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return allertaValangheStato;
	}

	/**
	 * Returns the allerta valanghe stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato, or <code>null</code> if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public AllertaValangheStato fetchByPrimaryKey(long allertaValangheStatoId) {
		return fetchByPrimaryKey((Serializable)allertaValangheStatoId);
	}

	@Override
	public Map<Serializable, AllertaValangheStato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AllertaValangheStato> map =
			new HashMap<Serializable, AllertaValangheStato>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AllertaValangheStato allertaValangheStato = fetchByPrimaryKey(
				primaryKey);

			if (allertaValangheStato != null) {
				map.put(primaryKey, allertaValangheStato);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
				AllertaValangheStatoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AllertaValangheStato)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ALLERTAVALANGHESTATO_WHERE_PKS_IN);

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

			for (AllertaValangheStato allertaValangheStato :
					(List<AllertaValangheStato>)q.list()) {

				map.put(
					allertaValangheStato.getPrimaryKeyObj(),
					allertaValangheStato);

				cacheResult(allertaValangheStato);

				uncachedPrimaryKeys.remove(
					allertaValangheStato.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
					AllertaValangheStatoImpl.class, primaryKey, nullModel);
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
	 * Returns all the allerta valanghe statos.
	 *
	 * @return the allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findAll(
		int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta valanghe statos
	 */
	@Override
	public List<AllertaValangheStato> findAll(
		int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
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

		List<AllertaValangheStato> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaValangheStato>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALLERTAVALANGHESTATO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALLERTAVALANGHESTATO;

				if (pagination) {
					sql = sql.concat(
						AllertaValangheStatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AllertaValangheStato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaValangheStato>)QueryUtil.list(
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
	 * Removes all the allerta valanghe statos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AllertaValangheStato allertaValangheStato : findAll()) {
			remove(allertaValangheStato);
		}
	}

	/**
	 * Returns the number of allerta valanghe statos.
	 *
	 * @return the number of allerta valanghe statos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALLERTAVALANGHESTATO);

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
		return AllertaValangheStatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allerta valanghe stato persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			AllertaValangheStatoModelImpl.UUID_COLUMN_BITMASK |
			AllertaValangheStatoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			AllertaValangheStatoModelImpl.UUID_COLUMN_BITMASK |
			AllertaValangheStatoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			AllertaValangheStatoModelImpl.UUID_COLUMN_BITMASK |
			AllertaValangheStatoModelImpl.COMPANYID_COLUMN_BITMASK |
			AllertaValangheStatoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByNome = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNome",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNome = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNome",
			new String[] {String.class.getName()},
			AllertaValangheStatoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByNome = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNome",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByAllertaValangheId = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllertaValangheId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAllertaValangheId = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED,
			AllertaValangheStatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllertaValangheId", new String[] {Long.class.getName()},
			AllertaValangheStatoModelImpl.ALLERTAVALANGHEID_COLUMN_BITMASK |
			AllertaValangheStatoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByAllertaValangheId = new FinderPath(
			AllertaValangheStatoModelImpl.ENTITY_CACHE_ENABLED,
			AllertaValangheStatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllertaValangheId", new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AllertaValangheStatoImpl.class.getName());
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

	private static final String _SQL_SELECT_ALLERTAVALANGHESTATO =
		"SELECT allertaValangheStato FROM AllertaValangheStato allertaValangheStato";

	private static final String _SQL_SELECT_ALLERTAVALANGHESTATO_WHERE_PKS_IN =
		"SELECT allertaValangheStato FROM AllertaValangheStato allertaValangheStato WHERE allertaValangheStatoId IN (";

	private static final String _SQL_SELECT_ALLERTAVALANGHESTATO_WHERE =
		"SELECT allertaValangheStato FROM AllertaValangheStato allertaValangheStato WHERE ";

	private static final String _SQL_COUNT_ALLERTAVALANGHESTATO =
		"SELECT COUNT(allertaValangheStato) FROM AllertaValangheStato allertaValangheStato";

	private static final String _SQL_COUNT_ALLERTAVALANGHESTATO_WHERE =
		"SELECT COUNT(allertaValangheStato) FROM AllertaValangheStato allertaValangheStato WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"allertaValangheStato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AllertaValangheStato exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AllertaValangheStato exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaValangheStatoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}