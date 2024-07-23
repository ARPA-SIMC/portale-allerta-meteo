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

import allerta.verifica.exception.NoSuchVerificaException;
import allerta.verifica.model.Verifica;
import allerta.verifica.model.impl.VerificaImpl;
import allerta.verifica.model.impl.VerificaModelImpl;
import allerta.verifica.service.persistence.VerificaPersistence;

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
 * The persistence implementation for the verifica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VerificaPersistenceImpl
	extends BasePersistenceImpl<Verifica> implements VerificaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VerificaUtil</code> to access the verifica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VerificaImpl.class.getName();

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
	 * Returns all the verificas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Verifica> orderByComparator,
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

		List<Verifica> list = null;

		if (retrieveFromCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Verifica verifica : list) {
					if (!uuid.equals(verifica.getUuid())) {
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

			query.append(_SQL_SELECT_VERIFICA_WHERE);

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
				query.append(VerificaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Verifica>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Verifica>)QueryUtil.list(
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
	 * Returns the first verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_First(
			String uuid, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_First(uuid, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchVerificaException(msg.toString());
	}

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_First(
		String uuid, OrderByComparator<Verifica> orderByComparator) {

		List<Verifica> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_Last(
			String uuid, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_Last(uuid, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchVerificaException(msg.toString());
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_Last(
		String uuid, OrderByComparator<Verifica> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Verifica> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		uuid = Objects.toString(uuid, "");

		Verifica verifica = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Verifica[] array = new VerificaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, verifica, uuid, orderByComparator, true);

			array[1] = verifica;

			array[2] = getByUuid_PrevAndNext(
				session, verifica, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Verifica getByUuid_PrevAndNext(
		Session session, Verifica verifica, String uuid,
		OrderByComparator<Verifica> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VERIFICA_WHERE);

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
			query.append(VerificaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(verifica)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Verifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verificas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Verifica verifica :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching verificas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VERIFICA_WHERE);

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
		"verifica.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(verifica.uuid IS NULL OR verifica.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVerificaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUUID_G(String uuid, long groupId)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUUID_G(uuid, groupId);

		if (verifica == null) {
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

			throw new NoSuchVerificaException(msg.toString());
		}

		return verifica;
	}

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Verifica) {
			Verifica verifica = (Verifica)result;

			if (!Objects.equals(uuid, verifica.getUuid()) ||
				(groupId != verifica.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VERIFICA_WHERE);

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

				List<Verifica> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					Verifica verifica = list.get(0);

					result = verifica;

					cacheResult(verifica);
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
			return (Verifica)result;
		}
	}

	/**
	 * Removes the verifica where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the verifica that was removed
	 */
	@Override
	public Verifica removeByUUID_G(String uuid, long groupId)
		throws NoSuchVerificaException {

		Verifica verifica = findByUUID_G(uuid, groupId);

		return remove(verifica);
	}

	/**
	 * Returns the number of verificas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching verificas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VERIFICA_WHERE);

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
		"verifica.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(verifica.uuid IS NULL OR verifica.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"verifica.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Verifica> orderByComparator,
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

		List<Verifica> list = null;

		if (retrieveFromCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Verifica verifica : list) {
					if (!uuid.equals(verifica.getUuid()) ||
						(companyId != verifica.getCompanyId())) {

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

			query.append(_SQL_SELECT_VERIFICA_WHERE);

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
				query.append(VerificaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Verifica>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Verifica>)QueryUtil.list(
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
	 * Returns the first verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchVerificaException(msg.toString());
	}

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Verifica> orderByComparator) {

		List<Verifica> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchVerificaException(msg.toString());
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Verifica> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Verifica> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		uuid = Objects.toString(uuid, "");

		Verifica verifica = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Verifica[] array = new VerificaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, verifica, uuid, companyId, orderByComparator, true);

			array[1] = verifica;

			array[2] = getByUuid_C_PrevAndNext(
				session, verifica, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Verifica getByUuid_C_PrevAndNext(
		Session session, Verifica verifica, String uuid, long companyId,
		OrderByComparator<Verifica> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VERIFICA_WHERE);

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
			query.append(VerificaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(verifica)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Verifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verificas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Verifica verifica :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching verificas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VERIFICA_WHERE);

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
		"verifica.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(verifica.uuid IS NULL OR verifica.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"verifica.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDocumento;
	private FinderPath _finderPathWithoutPaginationFindByDocumento;
	private FinderPath _finderPathCountByDocumento;

	/**
	 * Returns all the verificas where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(long documento) {
		return findByDocumento(
			documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(long documento, int start, int end) {
		return findByDocumento(documento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return findByDocumento(documento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<Verifica> orderByComparator,
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

		List<Verifica> list = null;

		if (retrieveFromCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Verifica verifica : list) {
					if ((documento != verifica.getDocumento())) {
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

			query.append(_SQL_SELECT_VERIFICA_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (!pagination) {
					list = (List<Verifica>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Verifica>)QueryUtil.list(
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
	 * Returns the first verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByDocumento_First(
			long documento, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByDocumento_First(
			documento, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append("}");

		throw new NoSuchVerificaException(msg.toString());
	}

	/**
	 * Returns the first verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByDocumento_First(
		long documento, OrderByComparator<Verifica> orderByComparator) {

		List<Verifica> list = findByDocumento(
			documento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByDocumento_Last(
			long documento, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByDocumento_Last(documento, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append("}");

		throw new NoSuchVerificaException(msg.toString());
	}

	/**
	 * Returns the last verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByDocumento_Last(
		long documento, OrderByComparator<Verifica> orderByComparator) {

		int count = countByDocumento(documento);

		if (count == 0) {
			return null;
		}

		List<Verifica> list = findByDocumento(
			documento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Verifica[] array = new VerificaImpl[3];

			array[0] = getByDocumento_PrevAndNext(
				session, verifica, documento, orderByComparator, true);

			array[1] = verifica;

			array[2] = getByDocumento_PrevAndNext(
				session, verifica, documento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Verifica getByDocumento_PrevAndNext(
		Session session, Verifica verifica, long documento,
		OrderByComparator<Verifica> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VERIFICA_WHERE);

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
			query.append(VerificaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verifica)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Verifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verificas where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	@Override
	public void removeByDocumento(long documento) {
		for (Verifica verifica :
				findByDocumento(
					documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verificas
	 */
	@Override
	public int countByDocumento(long documento) {
		FinderPath finderPath = _finderPathCountByDocumento;

		Object[] finderArgs = new Object[] {documento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VERIFICA_WHERE);

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
		"verifica.documento = ?";

	public VerificaPersistenceImpl() {
		setModelClass(Verifica.class);

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
	 * Caches the verifica in the entity cache if it is enabled.
	 *
	 * @param verifica the verifica
	 */
	@Override
	public void cacheResult(Verifica verifica) {
		entityCache.putResult(
			VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
			verifica.getPrimaryKey(), verifica);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {verifica.getUuid(), verifica.getGroupId()}, verifica);

		verifica.resetOriginalValues();
	}

	/**
	 * Caches the verificas in the entity cache if it is enabled.
	 *
	 * @param verificas the verificas
	 */
	@Override
	public void cacheResult(List<Verifica> verificas) {
		for (Verifica verifica : verificas) {
			if (entityCache.getResult(
					VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
					verifica.getPrimaryKey()) == null) {

				cacheResult(verifica);
			}
			else {
				verifica.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all verificas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VerificaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the verifica.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Verifica verifica) {
		entityCache.removeResult(
			VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
			verifica.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((VerificaModelImpl)verifica, true);
	}

	@Override
	public void clearCache(List<Verifica> verificas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Verifica verifica : verificas) {
			entityCache.removeResult(
				VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
				verifica.getPrimaryKey());

			clearUniqueFindersCache((VerificaModelImpl)verifica, true);
		}
	}

	protected void cacheUniqueFindersCache(
		VerificaModelImpl verificaModelImpl) {

		Object[] args = new Object[] {
			verificaModelImpl.getUuid(), verificaModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, verificaModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		VerificaModelImpl verificaModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				verificaModelImpl.getUuid(), verificaModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((verificaModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				verificaModelImpl.getOriginalUuid(),
				verificaModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new verifica with the primary key. Does not add the verifica to the database.
	 *
	 * @param id the primary key for the new verifica
	 * @return the new verifica
	 */
	@Override
	public Verifica create(long id) {
		Verifica verifica = new VerificaImpl();

		verifica.setNew(true);
		verifica.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		verifica.setUuid(uuid);

		verifica.setCompanyId(companyProvider.getCompanyId());

		return verifica;
	}

	/**
	 * Removes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica remove(long id) throws NoSuchVerificaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica remove(Serializable primaryKey)
		throws NoSuchVerificaException {

		Session session = null;

		try {
			session = openSession();

			Verifica verifica = (Verifica)session.get(
				VerificaImpl.class, primaryKey);

			if (verifica == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVerificaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(verifica);
		}
		catch (NoSuchVerificaException nsee) {
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
	protected Verifica removeImpl(Verifica verifica) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(verifica)) {
				verifica = (Verifica)session.get(
					VerificaImpl.class, verifica.getPrimaryKeyObj());
			}

			if (verifica != null) {
				session.delete(verifica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (verifica != null) {
			clearCache(verifica);
		}

		return verifica;
	}

	@Override
	public Verifica updateImpl(Verifica verifica) {
		boolean isNew = verifica.isNew();

		if (!(verifica instanceof VerificaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(verifica.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(verifica);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in verifica proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Verifica implementation " +
					verifica.getClass());
		}

		VerificaModelImpl verificaModelImpl = (VerificaModelImpl)verifica;

		if (Validator.isNull(verifica.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			verifica.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (verifica.getCreateDate() == null)) {
			if (serviceContext == null) {
				verifica.setCreateDate(now);
			}
			else {
				verifica.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!verificaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				verifica.setModifiedDate(now);
			}
			else {
				verifica.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (verifica.isNew()) {
				session.save(verifica);

				verifica.setNew(false);
			}
			else {
				verifica = (Verifica)session.merge(verifica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VerificaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {verificaModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				verificaModelImpl.getUuid(), verificaModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {verificaModelImpl.getDocumento()};

			finderCache.removeResult(_finderPathCountByDocumento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumento, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((verificaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					verificaModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {verificaModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((verificaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					verificaModelImpl.getOriginalUuid(),
					verificaModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					verificaModelImpl.getUuid(),
					verificaModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((verificaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaModelImpl.getOriginalDocumento()
				};

				finderCache.removeResult(_finderPathCountByDocumento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumento, args);

				args = new Object[] {verificaModelImpl.getDocumento()};

				finderCache.removeResult(_finderPathCountByDocumento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumento, args);
			}
		}

		entityCache.putResult(
			VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
			verifica.getPrimaryKey(), verifica, false);

		clearUniqueFindersCache(verificaModelImpl, false);
		cacheUniqueFindersCache(verificaModelImpl);

		verifica.resetOriginalValues();

		return verifica;
	}

	/**
	 * Returns the verifica with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verifica
	 * @return the verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByPrimaryKey(primaryKey);

		if (verifica == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVerificaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return verifica;
	}

	/**
	 * Returns the verifica with the primary key or throws a <code>NoSuchVerificaException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica findByPrimaryKey(long id) throws NoSuchVerificaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the verifica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verifica
	 * @return the verifica, or <code>null</code> if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Verifica verifica = (Verifica)serializable;

		if (verifica == null) {
			Session session = null;

			try {
				session = openSession();

				verifica = (Verifica)session.get(
					VerificaImpl.class, primaryKey);

				if (verifica != null) {
					cacheResult(verifica);
				}
				else {
					entityCache.putResult(
						VerificaModelImpl.ENTITY_CACHE_ENABLED,
						VerificaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return verifica;
	}

	/**
	 * Returns the verifica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica, or <code>null</code> if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Verifica> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Verifica> map = new HashMap<Serializable, Verifica>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Verifica verifica = fetchByPrimaryKey(primaryKey);

			if (verifica != null) {
				map.put(primaryKey, verifica);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Verifica)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_VERIFICA_WHERE_PKS_IN);

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

			for (Verifica verifica : (List<Verifica>)q.list()) {
				map.put(verifica.getPrimaryKeyObj(), verifica);

				cacheResult(verifica);

				uncachedPrimaryKeys.remove(verifica.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					VerificaModelImpl.ENTITY_CACHE_ENABLED, VerificaImpl.class,
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
	 * Returns all the verificas.
	 *
	 * @return the verificas
	 */
	@Override
	public List<Verifica> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of verificas
	 */
	@Override
	public List<Verifica> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verificas
	 */
	@Override
	public List<Verifica> findAll(
		int start, int end, OrderByComparator<Verifica> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of verificas
	 */
	@Override
	public List<Verifica> findAll(
		int start, int end, OrderByComparator<Verifica> orderByComparator,
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

		List<Verifica> list = null;

		if (retrieveFromCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VERIFICA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VERIFICA;

				if (pagination) {
					sql = sql.concat(VerificaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Verifica>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Verifica>)QueryUtil.list(
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
	 * Removes all the verificas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Verifica verifica : findAll()) {
			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas.
	 *
	 * @return the number of verificas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VERIFICA);

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
		return VerificaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the verifica persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			VerificaModelImpl.UUID_COLUMN_BITMASK |
			VerificaModelImpl.DATAINIZIO_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			VerificaModelImpl.UUID_COLUMN_BITMASK |
			VerificaModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			VerificaModelImpl.UUID_COLUMN_BITMASK |
			VerificaModelImpl.COMPANYID_COLUMN_BITMASK |
			VerificaModelImpl.DATAINIZIO_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByDocumento = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumento",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumento = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, VerificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumento",
			new String[] {Long.class.getName()},
			VerificaModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaModelImpl.DATAINIZIO_COLUMN_BITMASK);

		_finderPathCountByDocumento = new FinderPath(
			VerificaModelImpl.ENTITY_CACHE_ENABLED,
			VerificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumento",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(VerificaImpl.class.getName());
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

	private static final String _SQL_SELECT_VERIFICA =
		"SELECT verifica FROM Verifica verifica";

	private static final String _SQL_SELECT_VERIFICA_WHERE_PKS_IN =
		"SELECT verifica FROM Verifica verifica WHERE id_ IN (";

	private static final String _SQL_SELECT_VERIFICA_WHERE =
		"SELECT verifica FROM Verifica verifica WHERE ";

	private static final String _SQL_COUNT_VERIFICA =
		"SELECT COUNT(verifica) FROM Verifica verifica";

	private static final String _SQL_COUNT_VERIFICA_WHERE =
		"SELECT COUNT(verifica) FROM Verifica verifica WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "verifica.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Verifica exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Verifica exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VerificaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}