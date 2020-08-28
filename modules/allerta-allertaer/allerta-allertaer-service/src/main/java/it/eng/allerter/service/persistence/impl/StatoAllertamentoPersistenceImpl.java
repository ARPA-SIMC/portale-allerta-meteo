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

import it.eng.allerter.exception.NoSuchStatoAllertamentoException;
import it.eng.allerter.model.StatoAllertamento;
import it.eng.allerter.model.impl.StatoAllertamentoImpl;
import it.eng.allerter.model.impl.StatoAllertamentoModelImpl;
import it.eng.allerter.service.persistence.StatoAllertamentoPersistence;

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
 * The persistence implementation for the stato allertamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StatoAllertamentoPersistenceImpl
	extends BasePersistenceImpl<StatoAllertamento>
	implements StatoAllertamentoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StatoAllertamentoUtil</code> to access the stato allertamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StatoAllertamentoImpl.class.getName();

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
	 * Returns all the stato allertamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato allertamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
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

		List<StatoAllertamento> list = null;

		if (retrieveFromCache) {
			list = (List<StatoAllertamento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatoAllertamento statoAllertamento : list) {
					if (!uuid.equals(statoAllertamento.getUuid())) {
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

			query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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
				query.append(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
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
					list = (List<StatoAllertamento>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoAllertamento>)QueryUtil.list(
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
	 * Returns the first stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByUuid_First(
			String uuid, OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByUuid_First(
			uuid, orderByComparator);

		if (statoAllertamento != null) {
			return statoAllertamento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStatoAllertamentoException(msg.toString());
	}

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByUuid_First(
		String uuid, OrderByComparator<StatoAllertamento> orderByComparator) {

		List<StatoAllertamento> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByUuid_Last(
			String uuid, OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByUuid_Last(
			uuid, orderByComparator);

		if (statoAllertamento != null) {
			return statoAllertamento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStatoAllertamentoException(msg.toString());
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByUuid_Last(
		String uuid, OrderByComparator<StatoAllertamento> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StatoAllertamento> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento[] findByUuid_PrevAndNext(
			long statoId, String uuid,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		uuid = Objects.toString(uuid, "");

		StatoAllertamento statoAllertamento = findByPrimaryKey(statoId);

		Session session = null;

		try {
			session = openSession();

			StatoAllertamento[] array = new StatoAllertamentoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, statoAllertamento, uuid, orderByComparator, true);

			array[1] = statoAllertamento;

			array[2] = getByUuid_PrevAndNext(
				session, statoAllertamento, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoAllertamento getByUuid_PrevAndNext(
		Session session, StatoAllertamento statoAllertamento, String uuid,
		OrderByComparator<StatoAllertamento> orderByComparator,
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

		query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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
			query.append(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
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
						statoAllertamento)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StatoAllertamento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato allertamentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StatoAllertamento statoAllertamento :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statoAllertamento);
		}
	}

	/**
	 * Returns the number of stato allertamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stato allertamentos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATOALLERTAMENTO_WHERE);

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
		"statoAllertamento.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(statoAllertamento.uuid IS NULL OR statoAllertamento.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStatoAllertamentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByUUID_G(String uuid, long groupId)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByUUID_G(uuid, groupId);

		if (statoAllertamento == null) {
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

			throw new NoSuchStatoAllertamentoException(msg.toString());
		}

		return statoAllertamento;
	}

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof StatoAllertamento) {
			StatoAllertamento statoAllertamento = (StatoAllertamento)result;

			if (!Objects.equals(uuid, statoAllertamento.getUuid()) ||
				(groupId != statoAllertamento.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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

				List<StatoAllertamento> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					StatoAllertamento statoAllertamento = list.get(0);

					result = statoAllertamento;

					cacheResult(statoAllertamento);
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
			return (StatoAllertamento)result;
		}
	}

	/**
	 * Removes the stato allertamento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stato allertamento that was removed
	 */
	@Override
	public StatoAllertamento removeByUUID_G(String uuid, long groupId)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = findByUUID_G(uuid, groupId);

		return remove(statoAllertamento);
	}

	/**
	 * Returns the number of stato allertamentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stato allertamentos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STATOALLERTAMENTO_WHERE);

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
		"statoAllertamento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(statoAllertamento.uuid IS NULL OR statoAllertamento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"statoAllertamento.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
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

		List<StatoAllertamento> list = null;

		if (retrieveFromCache) {
			list = (List<StatoAllertamento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatoAllertamento statoAllertamento : list) {
					if (!uuid.equals(statoAllertamento.getUuid()) ||
						(companyId != statoAllertamento.getCompanyId())) {

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

			query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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
				query.append(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
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
					list = (List<StatoAllertamento>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoAllertamento>)QueryUtil.list(
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
	 * Returns the first stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (statoAllertamento != null) {
			return statoAllertamento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchStatoAllertamentoException(msg.toString());
	}

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		List<StatoAllertamento> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (statoAllertamento != null) {
			return statoAllertamento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchStatoAllertamentoException(msg.toString());
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<StatoAllertamento> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento[] findByUuid_C_PrevAndNext(
			long statoId, String uuid, long companyId,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		uuid = Objects.toString(uuid, "");

		StatoAllertamento statoAllertamento = findByPrimaryKey(statoId);

		Session session = null;

		try {
			session = openSession();

			StatoAllertamento[] array = new StatoAllertamentoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, statoAllertamento, uuid, companyId, orderByComparator,
				true);

			array[1] = statoAllertamento;

			array[2] = getByUuid_C_PrevAndNext(
				session, statoAllertamento, uuid, companyId, orderByComparator,
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

	protected StatoAllertamento getByUuid_C_PrevAndNext(
		Session session, StatoAllertamento statoAllertamento, String uuid,
		long companyId, OrderByComparator<StatoAllertamento> orderByComparator,
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

		query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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
			query.append(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
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
						statoAllertamento)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StatoAllertamento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato allertamentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (StatoAllertamento statoAllertamento :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(statoAllertamento);
		}
	}

	/**
	 * Returns the number of stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stato allertamentos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STATOALLERTAMENTO_WHERE);

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
		"statoAllertamento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(statoAllertamento.uuid IS NULL OR statoAllertamento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"statoAllertamento.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNome;
	private FinderPath _finderPathWithoutPaginationFindByNome;
	private FinderPath _finderPathCountByNome;

	/**
	 * Returns all the stato allertamentos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByNome(String nome) {
		return findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato allertamentos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByNome(String nome, int start, int end) {
		return findByNome(nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByNome(
		String nome, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return findByNome(nome, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findByNome(
		String nome, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
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

		List<StatoAllertamento> list = null;

		if (retrieveFromCache) {
			list = (List<StatoAllertamento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatoAllertamento statoAllertamento : list) {
					if (!nome.equals(statoAllertamento.getNome())) {
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

			query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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
				query.append(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
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
					list = (List<StatoAllertamento>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoAllertamento>)QueryUtil.list(
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
	 * Returns the first stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByNome_First(
			String nome, OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByNome_First(
			nome, orderByComparator);

		if (statoAllertamento != null) {
			return statoAllertamento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append("}");

		throw new NoSuchStatoAllertamentoException(msg.toString());
	}

	/**
	 * Returns the first stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByNome_First(
		String nome, OrderByComparator<StatoAllertamento> orderByComparator) {

		List<StatoAllertamento> list = findByNome(
			nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento findByNome_Last(
			String nome, OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByNome_Last(
			nome, orderByComparator);

		if (statoAllertamento != null) {
			return statoAllertamento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nome=");
		msg.append(nome);

		msg.append("}");

		throw new NoSuchStatoAllertamentoException(msg.toString());
	}

	/**
	 * Returns the last stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public StatoAllertamento fetchByNome_Last(
		String nome, OrderByComparator<StatoAllertamento> orderByComparator) {

		int count = countByNome(nome);

		if (count == 0) {
			return null;
		}

		List<StatoAllertamento> list = findByNome(
			nome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento[] findByNome_PrevAndNext(
			long statoId, String nome,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws NoSuchStatoAllertamentoException {

		nome = Objects.toString(nome, "");

		StatoAllertamento statoAllertamento = findByPrimaryKey(statoId);

		Session session = null;

		try {
			session = openSession();

			StatoAllertamento[] array = new StatoAllertamentoImpl[3];

			array[0] = getByNome_PrevAndNext(
				session, statoAllertamento, nome, orderByComparator, true);

			array[1] = statoAllertamento;

			array[2] = getByNome_PrevAndNext(
				session, statoAllertamento, nome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoAllertamento getByNome_PrevAndNext(
		Session session, StatoAllertamento statoAllertamento, String nome,
		OrderByComparator<StatoAllertamento> orderByComparator,
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

		query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE);

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
			query.append(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
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
						statoAllertamento)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StatoAllertamento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato allertamentos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByNome(String nome) {
		for (StatoAllertamento statoAllertamento :
				findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statoAllertamento);
		}
	}

	/**
	 * Returns the number of stato allertamentos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching stato allertamentos
	 */
	@Override
	public int countByNome(String nome) {
		nome = Objects.toString(nome, "");

		FinderPath finderPath = _finderPathCountByNome;

		Object[] finderArgs = new Object[] {nome};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATOALLERTAMENTO_WHERE);

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
		"statoAllertamento.nome = ?";

	private static final String _FINDER_COLUMN_NOME_NOME_3 =
		"(statoAllertamento.nome IS NULL OR statoAllertamento.nome = '')";

	public StatoAllertamentoPersistenceImpl() {
		setModelClass(StatoAllertamento.class);

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
	 * Caches the stato allertamento in the entity cache if it is enabled.
	 *
	 * @param statoAllertamento the stato allertamento
	 */
	@Override
	public void cacheResult(StatoAllertamento statoAllertamento) {
		entityCache.putResult(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoImpl.class, statoAllertamento.getPrimaryKey(),
			statoAllertamento);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				statoAllertamento.getUuid(), statoAllertamento.getGroupId()
			},
			statoAllertamento);

		statoAllertamento.resetOriginalValues();
	}

	/**
	 * Caches the stato allertamentos in the entity cache if it is enabled.
	 *
	 * @param statoAllertamentos the stato allertamentos
	 */
	@Override
	public void cacheResult(List<StatoAllertamento> statoAllertamentos) {
		for (StatoAllertamento statoAllertamento : statoAllertamentos) {
			if (entityCache.getResult(
					StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
					StatoAllertamentoImpl.class,
					statoAllertamento.getPrimaryKey()) == null) {

				cacheResult(statoAllertamento);
			}
			else {
				statoAllertamento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stato allertamentos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoAllertamentoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato allertamento.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoAllertamento statoAllertamento) {
		entityCache.removeResult(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoImpl.class, statoAllertamento.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(StatoAllertamentoModelImpl)statoAllertamento, true);
	}

	@Override
	public void clearCache(List<StatoAllertamento> statoAllertamentos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatoAllertamento statoAllertamento : statoAllertamentos) {
			entityCache.removeResult(
				StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
				StatoAllertamentoImpl.class, statoAllertamento.getPrimaryKey());

			clearUniqueFindersCache(
				(StatoAllertamentoModelImpl)statoAllertamento, true);
		}
	}

	protected void cacheUniqueFindersCache(
		StatoAllertamentoModelImpl statoAllertamentoModelImpl) {

		Object[] args = new Object[] {
			statoAllertamentoModelImpl.getUuid(),
			statoAllertamentoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, statoAllertamentoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StatoAllertamentoModelImpl statoAllertamentoModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				statoAllertamentoModelImpl.getUuid(),
				statoAllertamentoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((statoAllertamentoModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				statoAllertamentoModelImpl.getOriginalUuid(),
				statoAllertamentoModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new stato allertamento with the primary key. Does not add the stato allertamento to the database.
	 *
	 * @param statoId the primary key for the new stato allertamento
	 * @return the new stato allertamento
	 */
	@Override
	public StatoAllertamento create(long statoId) {
		StatoAllertamento statoAllertamento = new StatoAllertamentoImpl();

		statoAllertamento.setNew(true);
		statoAllertamento.setPrimaryKey(statoId);

		String uuid = PortalUUIDUtil.generate();

		statoAllertamento.setUuid(uuid);

		statoAllertamento.setCompanyId(companyProvider.getCompanyId());

		return statoAllertamento;
	}

	/**
	 * Removes the stato allertamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento that was removed
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento remove(long statoId)
		throws NoSuchStatoAllertamentoException {

		return remove((Serializable)statoId);
	}

	/**
	 * Removes the stato allertamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato allertamento
	 * @return the stato allertamento that was removed
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento remove(Serializable primaryKey)
		throws NoSuchStatoAllertamentoException {

		Session session = null;

		try {
			session = openSession();

			StatoAllertamento statoAllertamento =
				(StatoAllertamento)session.get(
					StatoAllertamentoImpl.class, primaryKey);

			if (statoAllertamento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoAllertamentoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(statoAllertamento);
		}
		catch (NoSuchStatoAllertamentoException nsee) {
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
	protected StatoAllertamento removeImpl(
		StatoAllertamento statoAllertamento) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoAllertamento)) {
				statoAllertamento = (StatoAllertamento)session.get(
					StatoAllertamentoImpl.class,
					statoAllertamento.getPrimaryKeyObj());
			}

			if (statoAllertamento != null) {
				session.delete(statoAllertamento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statoAllertamento != null) {
			clearCache(statoAllertamento);
		}

		return statoAllertamento;
	}

	@Override
	public StatoAllertamento updateImpl(StatoAllertamento statoAllertamento) {
		boolean isNew = statoAllertamento.isNew();

		if (!(statoAllertamento instanceof StatoAllertamentoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(statoAllertamento.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					statoAllertamento);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in statoAllertamento proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StatoAllertamento implementation " +
					statoAllertamento.getClass());
		}

		StatoAllertamentoModelImpl statoAllertamentoModelImpl =
			(StatoAllertamentoModelImpl)statoAllertamento;

		if (Validator.isNull(statoAllertamento.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			statoAllertamento.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (statoAllertamento.getCreateDate() == null)) {
			if (serviceContext == null) {
				statoAllertamento.setCreateDate(now);
			}
			else {
				statoAllertamento.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!statoAllertamentoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				statoAllertamento.setModifiedDate(now);
			}
			else {
				statoAllertamento.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (statoAllertamento.isNew()) {
				session.save(statoAllertamento);

				statoAllertamento.setNew(false);
			}
			else {
				statoAllertamento = (StatoAllertamento)session.merge(
					statoAllertamento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StatoAllertamentoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {statoAllertamentoModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				statoAllertamentoModelImpl.getUuid(),
				statoAllertamentoModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {statoAllertamentoModelImpl.getNome()};

			finderCache.removeResult(_finderPathCountByNome, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNome, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((statoAllertamentoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					statoAllertamentoModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {statoAllertamentoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((statoAllertamentoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					statoAllertamentoModelImpl.getOriginalUuid(),
					statoAllertamentoModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					statoAllertamentoModelImpl.getUuid(),
					statoAllertamentoModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((statoAllertamentoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNome.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					statoAllertamentoModelImpl.getOriginalNome()
				};

				finderCache.removeResult(_finderPathCountByNome, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNome, args);

				args = new Object[] {statoAllertamentoModelImpl.getNome()};

				finderCache.removeResult(_finderPathCountByNome, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNome, args);
			}
		}

		entityCache.putResult(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoImpl.class, statoAllertamento.getPrimaryKey(),
			statoAllertamento, false);

		clearUniqueFindersCache(statoAllertamentoModelImpl, false);
		cacheUniqueFindersCache(statoAllertamentoModelImpl);

		statoAllertamento.resetOriginalValues();

		return statoAllertamento;
	}

	/**
	 * Returns the stato allertamento with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato allertamento
	 * @return the stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoAllertamentoException {

		StatoAllertamento statoAllertamento = fetchByPrimaryKey(primaryKey);

		if (statoAllertamento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoAllertamentoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return statoAllertamento;
	}

	/**
	 * Returns the stato allertamento with the primary key or throws a <code>NoSuchStatoAllertamentoException</code> if it could not be found.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento findByPrimaryKey(long statoId)
		throws NoSuchStatoAllertamentoException {

		return findByPrimaryKey((Serializable)statoId);
	}

	/**
	 * Returns the stato allertamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato allertamento
	 * @return the stato allertamento, or <code>null</code> if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StatoAllertamento statoAllertamento = (StatoAllertamento)serializable;

		if (statoAllertamento == null) {
			Session session = null;

			try {
				session = openSession();

				statoAllertamento = (StatoAllertamento)session.get(
					StatoAllertamentoImpl.class, primaryKey);

				if (statoAllertamento != null) {
					cacheResult(statoAllertamento);
				}
				else {
					entityCache.putResult(
						StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
						StatoAllertamentoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
					StatoAllertamentoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statoAllertamento;
	}

	/**
	 * Returns the stato allertamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento, or <code>null</code> if a stato allertamento with the primary key could not be found
	 */
	@Override
	public StatoAllertamento fetchByPrimaryKey(long statoId) {
		return fetchByPrimaryKey((Serializable)statoId);
	}

	@Override
	public Map<Serializable, StatoAllertamento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StatoAllertamento> map =
			new HashMap<Serializable, StatoAllertamento>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StatoAllertamento statoAllertamento = fetchByPrimaryKey(primaryKey);

			if (statoAllertamento != null) {
				map.put(primaryKey, statoAllertamento);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
				StatoAllertamentoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StatoAllertamento)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_STATOALLERTAMENTO_WHERE_PKS_IN);

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

			for (StatoAllertamento statoAllertamento :
					(List<StatoAllertamento>)q.list()) {

				map.put(
					statoAllertamento.getPrimaryKeyObj(), statoAllertamento);

				cacheResult(statoAllertamento);

				uncachedPrimaryKeys.remove(
					statoAllertamento.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
					StatoAllertamentoImpl.class, primaryKey, nullModel);
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
	 * Returns all the stato allertamentos.
	 *
	 * @return the stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findAll(
		int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato allertamentos
	 */
	@Override
	public List<StatoAllertamento> findAll(
		int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
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

		List<StatoAllertamento> list = null;

		if (retrieveFromCache) {
			list = (List<StatoAllertamento>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATOALLERTAMENTO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATOALLERTAMENTO;

				if (pagination) {
					sql = sql.concat(StatoAllertamentoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatoAllertamento>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoAllertamento>)QueryUtil.list(
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
	 * Removes all the stato allertamentos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoAllertamento statoAllertamento : findAll()) {
			remove(statoAllertamento);
		}
	}

	/**
	 * Returns the number of stato allertamentos.
	 *
	 * @return the number of stato allertamentos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATOALLERTAMENTO);

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
		return StatoAllertamentoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato allertamento persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			StatoAllertamentoModelImpl.UUID_COLUMN_BITMASK |
			StatoAllertamentoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			StatoAllertamentoModelImpl.UUID_COLUMN_BITMASK |
			StatoAllertamentoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			StatoAllertamentoModelImpl.UUID_COLUMN_BITMASK |
			StatoAllertamentoModelImpl.COMPANYID_COLUMN_BITMASK |
			StatoAllertamentoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByNome = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNome",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNome = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED,
			StatoAllertamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNome",
			new String[] {String.class.getName()},
			StatoAllertamentoModelImpl.NOME_COLUMN_BITMASK);

		_finderPathCountByNome = new FinderPath(
			StatoAllertamentoModelImpl.ENTITY_CACHE_ENABLED,
			StatoAllertamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNome",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(StatoAllertamentoImpl.class.getName());
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

	private static final String _SQL_SELECT_STATOALLERTAMENTO =
		"SELECT statoAllertamento FROM StatoAllertamento statoAllertamento";

	private static final String _SQL_SELECT_STATOALLERTAMENTO_WHERE_PKS_IN =
		"SELECT statoAllertamento FROM StatoAllertamento statoAllertamento WHERE statoId IN (";

	private static final String _SQL_SELECT_STATOALLERTAMENTO_WHERE =
		"SELECT statoAllertamento FROM StatoAllertamento statoAllertamento WHERE ";

	private static final String _SQL_COUNT_STATOALLERTAMENTO =
		"SELECT COUNT(statoAllertamento) FROM StatoAllertamento statoAllertamento";

	private static final String _SQL_COUNT_STATOALLERTAMENTO_WHERE =
		"SELECT COUNT(statoAllertamento) FROM StatoAllertamento statoAllertamento WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "statoAllertamento.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StatoAllertamento exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StatoAllertamento exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StatoAllertamentoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}