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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException;
import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.model.impl.RegolaAllarmeComuneImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl;
import it.eng.bollettino.service.persistence.RegolaAllarmeComunePersistence;

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
 * The persistence implementation for the regola allarme comune service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeComunePersistenceImpl
	extends BasePersistenceImpl<RegolaAllarmeComune>
	implements RegolaAllarmeComunePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegolaAllarmeComuneUtil</code> to access the regola allarme comune persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegolaAllarmeComuneImpl.class.getName();

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
	 * Returns all the regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		List<RegolaAllarmeComune> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeComune regolaAllarmeComune : list) {
					if (!uuid.equals(regolaAllarmeComune.getUuid())) {
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

			query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

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
				query.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
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
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByUuid_First(
			String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByUuid_First(
			uuid, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchRegolaAllarmeComuneException(msg.toString());
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByUuid_First(
		String uuid, OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		List<RegolaAllarmeComune> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByUuid_Last(
			String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByUuid_Last(
			uuid, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchRegolaAllarmeComuneException(msg.toString());
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByUuid_Last(
		String uuid, OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeComune> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		uuid = Objects.toString(uuid, "");

		RegolaAllarmeComune regolaAllarmeComune = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune[] array = new RegolaAllarmeComuneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, regolaAllarmeComune, uuid, orderByComparator, true);

			array[1] = regolaAllarmeComune;

			array[2] = getByUuid_PrevAndNext(
				session, regolaAllarmeComune, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegolaAllarmeComune getByUuid_PrevAndNext(
		Session session, RegolaAllarmeComune regolaAllarmeComune, String uuid,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

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
			query.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
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
						regolaAllarmeComune)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeComune> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme comunes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegolaAllarmeComune regolaAllarmeComune :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme comunes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARMECOMUNE_WHERE);

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
		"regolaAllarmeComune.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(regolaAllarmeComune.uuid IS NULL OR regolaAllarmeComune.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByRegola;
	private FinderPath _finderPathWithoutPaginationFindByRegola;
	private FinderPath _finderPathCountByRegola;

	/**
	 * Returns all the regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(long idRegola) {
		return findByRegola(
			idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end) {

		return findByRegola(idRegola, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findByRegola(idRegola, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRegola;
			finderArgs = new Object[] {idRegola};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRegola;
			finderArgs = new Object[] {idRegola, start, end, orderByComparator};
		}

		List<RegolaAllarmeComune> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeComune regolaAllarmeComune : list) {
					if ((idRegola != regolaAllarmeComune.getIdRegola())) {
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

			query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

			query.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idRegola);

				if (!pagination) {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByRegola_First(
			long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByRegola_First(
			idRegola, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idRegola=");
		msg.append(idRegola);

		msg.append("}");

		throw new NoSuchRegolaAllarmeComuneException(msg.toString());
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByRegola_First(
		long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		List<RegolaAllarmeComune> list = findByRegola(
			idRegola, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByRegola_Last(
			long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByRegola_Last(
			idRegola, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idRegola=");
		msg.append(idRegola);

		msg.append("}");

		throw new NoSuchRegolaAllarmeComuneException(msg.toString());
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByRegola_Last(
		long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		int count = countByRegola(idRegola);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeComune> list = findByRegola(
			idRegola, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune[] findByRegola_PrevAndNext(
			long id, long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune[] array = new RegolaAllarmeComuneImpl[3];

			array[0] = getByRegola_PrevAndNext(
				session, regolaAllarmeComune, idRegola, orderByComparator,
				true);

			array[1] = regolaAllarmeComune;

			array[2] = getByRegola_PrevAndNext(
				session, regolaAllarmeComune, idRegola, orderByComparator,
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

	protected RegolaAllarmeComune getByRegola_PrevAndNext(
		Session session, RegolaAllarmeComune regolaAllarmeComune, long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

		query.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

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
			query.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idRegola);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						regolaAllarmeComune)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeComune> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme comunes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	@Override
	public void removeByRegola(long idRegola) {
		for (RegolaAllarmeComune regolaAllarmeComune :
				findByRegola(
					idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme comunes
	 */
	@Override
	public int countByRegola(long idRegola) {
		FinderPath finderPath = _finderPathCountByRegola;

		Object[] finderArgs = new Object[] {idRegola};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARMECOMUNE_WHERE);

			query.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idRegola);

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

	private static final String _FINDER_COLUMN_REGOLA_IDREGOLA_2 =
		"regolaAllarmeComune.idRegola = ?";

	private FinderPath _finderPathWithPaginationFindByComune;
	private FinderPath _finderPathWithoutPaginationFindByComune;
	private FinderPath _finderPathCountByComune;

	/**
	 * Returns all the regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(long idComune) {
		return findByComune(
			idComune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end) {

		return findByComune(idComune, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findByComune(idComune, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByComune;
			finderArgs = new Object[] {idComune};
		}
		else {
			finderPath = _finderPathWithPaginationFindByComune;
			finderArgs = new Object[] {idComune, start, end, orderByComparator};
		}

		List<RegolaAllarmeComune> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeComune regolaAllarmeComune : list) {
					if ((idComune != regolaAllarmeComune.getIdComune())) {
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

			query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

			query.append(_FINDER_COLUMN_COMUNE_IDCOMUNE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idComune);

				if (!pagination) {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByComune_First(
			long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByComune_First(
			idComune, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idComune=");
		msg.append(idComune);

		msg.append("}");

		throw new NoSuchRegolaAllarmeComuneException(msg.toString());
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByComune_First(
		long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		List<RegolaAllarmeComune> list = findByComune(
			idComune, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByComune_Last(
			long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByComune_Last(
			idComune, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idComune=");
		msg.append(idComune);

		msg.append("}");

		throw new NoSuchRegolaAllarmeComuneException(msg.toString());
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByComune_Last(
		long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		int count = countByComune(idComune);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeComune> list = findByComune(
			idComune, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune[] findByComune_PrevAndNext(
			long id, long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune[] array = new RegolaAllarmeComuneImpl[3];

			array[0] = getByComune_PrevAndNext(
				session, regolaAllarmeComune, idComune, orderByComparator,
				true);

			array[1] = regolaAllarmeComune;

			array[2] = getByComune_PrevAndNext(
				session, regolaAllarmeComune, idComune, orderByComparator,
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

	protected RegolaAllarmeComune getByComune_PrevAndNext(
		Session session, RegolaAllarmeComune regolaAllarmeComune, long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

		query.append(_FINDER_COLUMN_COMUNE_IDCOMUNE_2);

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
			query.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idComune);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						regolaAllarmeComune)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeComune> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme comunes where idComune = &#63; from the database.
	 *
	 * @param idComune the id comune
	 */
	@Override
	public void removeByComune(long idComune) {
		for (RegolaAllarmeComune regolaAllarmeComune :
				findByComune(
					idComune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the number of matching regola allarme comunes
	 */
	@Override
	public int countByComune(long idComune) {
		FinderPath finderPath = _finderPathCountByComune;

		Object[] finderArgs = new Object[] {idComune};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARMECOMUNE_WHERE);

			query.append(_FINDER_COLUMN_COMUNE_IDCOMUNE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idComune);

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

	private static final String _FINDER_COLUMN_COMUNE_IDCOMUNE_2 =
		"regolaAllarmeComune.idComune = ?";

	public RegolaAllarmeComunePersistenceImpl() {
		setModelClass(RegolaAllarmeComune.class);

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
	 * Caches the regola allarme comune in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 */
	@Override
	public void cacheResult(RegolaAllarmeComune regolaAllarmeComune) {
		entityCache.putResult(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class, regolaAllarmeComune.getPrimaryKey(),
			regolaAllarmeComune);

		regolaAllarmeComune.resetOriginalValues();
	}

	/**
	 * Caches the regola allarme comunes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComunes the regola allarme comunes
	 */
	@Override
	public void cacheResult(List<RegolaAllarmeComune> regolaAllarmeComunes) {
		for (RegolaAllarmeComune regolaAllarmeComune : regolaAllarmeComunes) {
			if (entityCache.getResult(
					RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeComuneImpl.class,
					regolaAllarmeComune.getPrimaryKey()) == null) {

				cacheResult(regolaAllarmeComune);
			}
			else {
				regolaAllarmeComune.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all regola allarme comunes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegolaAllarmeComuneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the regola allarme comune.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegolaAllarmeComune regolaAllarmeComune) {
		entityCache.removeResult(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class, regolaAllarmeComune.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RegolaAllarmeComune> regolaAllarmeComunes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RegolaAllarmeComune regolaAllarmeComune : regolaAllarmeComunes) {
			entityCache.removeResult(
				RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
				RegolaAllarmeComuneImpl.class,
				regolaAllarmeComune.getPrimaryKey());
		}
	}

	/**
	 * Creates a new regola allarme comune with the primary key. Does not add the regola allarme comune to the database.
	 *
	 * @param id the primary key for the new regola allarme comune
	 * @return the new regola allarme comune
	 */
	@Override
	public RegolaAllarmeComune create(long id) {
		RegolaAllarmeComune regolaAllarmeComune = new RegolaAllarmeComuneImpl();

		regolaAllarmeComune.setNew(true);
		regolaAllarmeComune.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		regolaAllarmeComune.setUuid(uuid);

		return regolaAllarmeComune;
	}

	/**
	 * Removes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune remove(long id)
		throws NoSuchRegolaAllarmeComuneException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune remove(Serializable primaryKey)
		throws NoSuchRegolaAllarmeComuneException {

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune regolaAllarmeComune =
				(RegolaAllarmeComune)session.get(
					RegolaAllarmeComuneImpl.class, primaryKey);

			if (regolaAllarmeComune == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegolaAllarmeComuneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(regolaAllarmeComune);
		}
		catch (NoSuchRegolaAllarmeComuneException nsee) {
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
	protected RegolaAllarmeComune removeImpl(
		RegolaAllarmeComune regolaAllarmeComune) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regolaAllarmeComune)) {
				regolaAllarmeComune = (RegolaAllarmeComune)session.get(
					RegolaAllarmeComuneImpl.class,
					regolaAllarmeComune.getPrimaryKeyObj());
			}

			if (regolaAllarmeComune != null) {
				session.delete(regolaAllarmeComune);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (regolaAllarmeComune != null) {
			clearCache(regolaAllarmeComune);
		}

		return regolaAllarmeComune;
	}

	@Override
	public RegolaAllarmeComune updateImpl(
		RegolaAllarmeComune regolaAllarmeComune) {

		boolean isNew = regolaAllarmeComune.isNew();

		if (!(regolaAllarmeComune instanceof RegolaAllarmeComuneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(regolaAllarmeComune.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					regolaAllarmeComune);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in regolaAllarmeComune proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegolaAllarmeComune implementation " +
					regolaAllarmeComune.getClass());
		}

		RegolaAllarmeComuneModelImpl regolaAllarmeComuneModelImpl =
			(RegolaAllarmeComuneModelImpl)regolaAllarmeComune;

		if (Validator.isNull(regolaAllarmeComune.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			regolaAllarmeComune.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (regolaAllarmeComune.isNew()) {
				session.save(regolaAllarmeComune);

				regolaAllarmeComune.setNew(false);
			}
			else {
				regolaAllarmeComune = (RegolaAllarmeComune)session.merge(
					regolaAllarmeComune);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RegolaAllarmeComuneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				regolaAllarmeComuneModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {regolaAllarmeComuneModelImpl.getIdRegola()};

			finderCache.removeResult(_finderPathCountByRegola, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRegola, args);

			args = new Object[] {regolaAllarmeComuneModelImpl.getIdComune()};

			finderCache.removeResult(_finderPathCountByComune, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByComune, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((regolaAllarmeComuneModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeComuneModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {regolaAllarmeComuneModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((regolaAllarmeComuneModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRegola.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeComuneModelImpl.getOriginalIdRegola()
				};

				finderCache.removeResult(_finderPathCountByRegola, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRegola, args);

				args = new Object[] {
					regolaAllarmeComuneModelImpl.getIdRegola()
				};

				finderCache.removeResult(_finderPathCountByRegola, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRegola, args);
			}

			if ((regolaAllarmeComuneModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByComune.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeComuneModelImpl.getOriginalIdComune()
				};

				finderCache.removeResult(_finderPathCountByComune, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByComune, args);

				args = new Object[] {
					regolaAllarmeComuneModelImpl.getIdComune()
				};

				finderCache.removeResult(_finderPathCountByComune, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByComune, args);
			}
		}

		entityCache.putResult(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class, regolaAllarmeComune.getPrimaryKey(),
			regolaAllarmeComune, false);

		regolaAllarmeComune.resetOriginalValues();

		return regolaAllarmeComune;
	}

	/**
	 * Returns the regola allarme comune with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByPrimaryKey(primaryKey);

		if (regolaAllarmeComune == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegolaAllarmeComuneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return regolaAllarmeComune;
	}

	/**
	 * Returns the regola allarme comune with the primary key or throws a <code>NoSuchRegolaAllarmeComuneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeComuneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the regola allarme comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme comune
	 * @return the regola allarme comune, or <code>null</code> if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RegolaAllarmeComune regolaAllarmeComune =
			(RegolaAllarmeComune)serializable;

		if (regolaAllarmeComune == null) {
			Session session = null;

			try {
				session = openSession();

				regolaAllarmeComune = (RegolaAllarmeComune)session.get(
					RegolaAllarmeComuneImpl.class, primaryKey);

				if (regolaAllarmeComune != null) {
					cacheResult(regolaAllarmeComune);
				}
				else {
					entityCache.putResult(
						RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
						RegolaAllarmeComuneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeComuneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return regolaAllarmeComune;
	}

	/**
	 * Returns the regola allarme comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune, or <code>null</code> if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RegolaAllarmeComune> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RegolaAllarmeComune> map =
			new HashMap<Serializable, RegolaAllarmeComune>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RegolaAllarmeComune regolaAllarmeComune = fetchByPrimaryKey(
				primaryKey);

			if (regolaAllarmeComune != null) {
				map.put(primaryKey, regolaAllarmeComune);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
				RegolaAllarmeComuneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RegolaAllarmeComune)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE_PKS_IN);

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

			for (RegolaAllarmeComune regolaAllarmeComune :
					(List<RegolaAllarmeComune>)q.list()) {

				map.put(
					regolaAllarmeComune.getPrimaryKeyObj(),
					regolaAllarmeComune);

				cacheResult(regolaAllarmeComune);

				uncachedPrimaryKeys.remove(
					regolaAllarmeComune.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeComuneImpl.class, primaryKey, nullModel);
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
	 * Returns all the regola allarme comunes.
	 *
	 * @return the regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		List<RegolaAllarmeComune> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REGOLAALLARMECOMUNE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGOLAALLARMECOMUNE;

				if (pagination) {
					sql = sql.concat(
						RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Removes all the regola allarme comunes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegolaAllarmeComune regolaAllarmeComune : findAll()) {
			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes.
	 *
	 * @return the number of regola allarme comunes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REGOLAALLARMECOMUNE);

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
		return RegolaAllarmeComuneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the regola allarme comune persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			RegolaAllarmeComuneModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRegola = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRegola",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRegola = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegola",
			new String[] {Long.class.getName()},
			RegolaAllarmeComuneModelImpl.IDREGOLA_COLUMN_BITMASK);

		_finderPathCountByRegola = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegola",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByComune = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComune",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByComune = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeComuneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByComune",
			new String[] {Long.class.getName()},
			RegolaAllarmeComuneModelImpl.IDCOMUNE_COLUMN_BITMASK);

		_finderPathCountByComune = new FinderPath(
			RegolaAllarmeComuneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeComuneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByComune",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RegolaAllarmeComuneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REGOLAALLARMECOMUNE =
		"SELECT regolaAllarmeComune FROM RegolaAllarmeComune regolaAllarmeComune";

	private static final String _SQL_SELECT_REGOLAALLARMECOMUNE_WHERE_PKS_IN =
		"SELECT regolaAllarmeComune FROM RegolaAllarmeComune regolaAllarmeComune WHERE id_ IN (";

	private static final String _SQL_SELECT_REGOLAALLARMECOMUNE_WHERE =
		"SELECT regolaAllarmeComune FROM RegolaAllarmeComune regolaAllarmeComune WHERE ";

	private static final String _SQL_COUNT_REGOLAALLARMECOMUNE =
		"SELECT COUNT(regolaAllarmeComune) FROM RegolaAllarmeComune regolaAllarmeComune";

	private static final String _SQL_COUNT_REGOLAALLARMECOMUNE_WHERE =
		"SELECT COUNT(regolaAllarmeComune) FROM RegolaAllarmeComune regolaAllarmeComune WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "regolaAllarmeComune.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegolaAllarmeComune exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegolaAllarmeComune exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegolaAllarmeComunePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}