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

import it.eng.bollettino.exception.NoSuchBollettinoBacinoException;
import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.model.impl.BollettinoBacinoImpl;
import it.eng.bollettino.model.impl.BollettinoBacinoModelImpl;
import it.eng.bollettino.service.persistence.BollettinoBacinoPersistence;

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
 * The persistence implementation for the bollettino bacino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoBacinoPersistenceImpl
	extends BasePersistenceImpl<BollettinoBacino>
	implements BollettinoBacinoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoBacinoUtil</code> to access the bollettino bacino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoBacinoImpl.class.getName();

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
	 * Returns all the bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		List<BollettinoBacino> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoBacino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoBacino bollettinoBacino : list) {
					if (!uuid.equals(bollettinoBacino.getUuid())) {
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

			query.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

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
				query.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BollettinoBacino>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoBacino>)QueryUtil.list(
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
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByUuid_First(
			String uuid, OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByUuid_First(
			uuid, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBollettinoBacinoException(msg.toString());
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoBacino> orderByComparator) {

		List<BollettinoBacino> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByUuid_Last(
			String uuid, OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBollettinoBacinoException(msg.toString());
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoBacino> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BollettinoBacino> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		uuid = Objects.toString(uuid, "");

		BollettinoBacino bollettinoBacino = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoBacino[] array = new BollettinoBacinoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bollettinoBacino, uuid, orderByComparator, true);

			array[1] = bollettinoBacino;

			array[2] = getByUuid_PrevAndNext(
				session, bollettinoBacino, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BollettinoBacino getByUuid_PrevAndNext(
		Session session, BollettinoBacino bollettinoBacino, String uuid,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		query.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

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
			query.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
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
						bollettinoBacino)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<BollettinoBacino> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino bacinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BollettinoBacino bollettinoBacino :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoBacino);
		}
	}

	/**
	 * Returns the number of bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino bacinos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOLLETTINOBACINO_WHERE);

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
		"bollettinoBacino.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bollettinoBacino.uuid IS NULL OR bollettinoBacino.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByBollettino;
	private FinderPath _finderPathWithoutPaginationFindByBollettino;
	private FinderPath _finderPathCountByBollettino;

	/**
	 * Returns all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(long idBollettino) {
		return findByBollettino(
			idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end) {

		return findByBollettino(idBollettino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return findByBollettino(
			idBollettino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByBollettino;
			finderArgs = new Object[] {idBollettino};
		}
		else {
			finderPath = _finderPathWithPaginationFindByBollettino;
			finderArgs = new Object[] {
				idBollettino, start, end, orderByComparator
			};
		}

		List<BollettinoBacino> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoBacino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoBacino bollettinoBacino : list) {
					if ((idBollettino != bollettinoBacino.getIdBollettino())) {
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

			query.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

			query.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idBollettino);

				if (!pagination) {
					list = (List<BollettinoBacino>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoBacino>)QueryUtil.list(
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
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByBollettino_First(
			idBollettino, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idBollettino=");
		msg.append(idBollettino);

		msg.append("}");

		throw new NoSuchBollettinoBacinoException(msg.toString());
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		List<BollettinoBacino> list = findByBollettino(
			idBollettino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByBollettino_Last(
			idBollettino, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idBollettino=");
		msg.append(idBollettino);

		msg.append("}");

		throw new NoSuchBollettinoBacinoException(msg.toString());
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		int count = countByBollettino(idBollettino);

		if (count == 0) {
			return null;
		}

		List<BollettinoBacino> list = findByBollettino(
			idBollettino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoBacino[] array = new BollettinoBacinoImpl[3];

			array[0] = getByBollettino_PrevAndNext(
				session, bollettinoBacino, idBollettino, orderByComparator,
				true);

			array[1] = bollettinoBacino;

			array[2] = getByBollettino_PrevAndNext(
				session, bollettinoBacino, idBollettino, orderByComparator,
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

	protected BollettinoBacino getByBollettino_PrevAndNext(
		Session session, BollettinoBacino bollettinoBacino, long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		query.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

		query.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

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
			query.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idBollettino);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bollettinoBacino)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<BollettinoBacino> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino bacinos where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	@Override
	public void removeByBollettino(long idBollettino) {
		for (BollettinoBacino bollettinoBacino :
				findByBollettino(
					idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoBacino);
		}
	}

	/**
	 * Returns the number of bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino bacinos
	 */
	@Override
	public int countByBollettino(long idBollettino) {
		FinderPath finderPath = _finderPathCountByBollettino;

		Object[] finderArgs = new Object[] {idBollettino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOLLETTINOBACINO_WHERE);

			query.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idBollettino);

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

	private static final String _FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2 =
		"bollettinoBacino.idBollettino = ?";

	public BollettinoBacinoPersistenceImpl() {
		setModelClass(BollettinoBacino.class);

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
	 * Caches the bollettino bacino in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 */
	@Override
	public void cacheResult(BollettinoBacino bollettinoBacino) {
		entityCache.putResult(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoImpl.class, bollettinoBacino.getPrimaryKey(),
			bollettinoBacino);

		bollettinoBacino.resetOriginalValues();
	}

	/**
	 * Caches the bollettino bacinos in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacinos the bollettino bacinos
	 */
	@Override
	public void cacheResult(List<BollettinoBacino> bollettinoBacinos) {
		for (BollettinoBacino bollettinoBacino : bollettinoBacinos) {
			if (entityCache.getResult(
					BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoBacinoImpl.class,
					bollettinoBacino.getPrimaryKey()) == null) {

				cacheResult(bollettinoBacino);
			}
			else {
				bollettinoBacino.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bollettino bacinos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoBacinoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bollettino bacino.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoBacino bollettinoBacino) {
		entityCache.removeResult(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoImpl.class, bollettinoBacino.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BollettinoBacino> bollettinoBacinos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BollettinoBacino bollettinoBacino : bollettinoBacinos) {
			entityCache.removeResult(
				BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
				BollettinoBacinoImpl.class, bollettinoBacino.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bollettino bacino with the primary key. Does not add the bollettino bacino to the database.
	 *
	 * @param id the primary key for the new bollettino bacino
	 * @return the new bollettino bacino
	 */
	@Override
	public BollettinoBacino create(long id) {
		BollettinoBacino bollettinoBacino = new BollettinoBacinoImpl();

		bollettinoBacino.setNew(true);
		bollettinoBacino.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		bollettinoBacino.setUuid(uuid);

		return bollettinoBacino;
	}

	/**
	 * Removes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino remove(long id)
		throws NoSuchBollettinoBacinoException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino remove(Serializable primaryKey)
		throws NoSuchBollettinoBacinoException {

		Session session = null;

		try {
			session = openSession();

			BollettinoBacino bollettinoBacino = (BollettinoBacino)session.get(
				BollettinoBacinoImpl.class, primaryKey);

			if (bollettinoBacino == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoBacinoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoBacino);
		}
		catch (NoSuchBollettinoBacinoException nsee) {
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
	protected BollettinoBacino removeImpl(BollettinoBacino bollettinoBacino) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoBacino)) {
				bollettinoBacino = (BollettinoBacino)session.get(
					BollettinoBacinoImpl.class,
					bollettinoBacino.getPrimaryKeyObj());
			}

			if (bollettinoBacino != null) {
				session.delete(bollettinoBacino);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoBacino != null) {
			clearCache(bollettinoBacino);
		}

		return bollettinoBacino;
	}

	@Override
	public BollettinoBacino updateImpl(BollettinoBacino bollettinoBacino) {
		boolean isNew = bollettinoBacino.isNew();

		if (!(bollettinoBacino instanceof BollettinoBacinoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettinoBacino.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bollettinoBacino);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettinoBacino proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BollettinoBacino implementation " +
					bollettinoBacino.getClass());
		}

		BollettinoBacinoModelImpl bollettinoBacinoModelImpl =
			(BollettinoBacinoModelImpl)bollettinoBacino;

		if (Validator.isNull(bollettinoBacino.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bollettinoBacino.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (bollettinoBacino.isNew()) {
				session.save(bollettinoBacino);

				bollettinoBacino.setNew(false);
			}
			else {
				bollettinoBacino = (BollettinoBacino)session.merge(
					bollettinoBacino);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BollettinoBacinoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {bollettinoBacinoModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {bollettinoBacinoModelImpl.getIdBollettino()};

			finderCache.removeResult(_finderPathCountByBollettino, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByBollettino, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((bollettinoBacinoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					bollettinoBacinoModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {bollettinoBacinoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((bollettinoBacinoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByBollettino.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					bollettinoBacinoModelImpl.getOriginalIdBollettino()
				};

				finderCache.removeResult(_finderPathCountByBollettino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByBollettino, args);

				args = new Object[] {
					bollettinoBacinoModelImpl.getIdBollettino()
				};

				finderCache.removeResult(_finderPathCountByBollettino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByBollettino, args);
			}
		}

		entityCache.putResult(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoImpl.class, bollettinoBacino.getPrimaryKey(),
			bollettinoBacino, false);

		bollettinoBacino.resetOriginalValues();

		return bollettinoBacino;
	}

	/**
	 * Returns the bollettino bacino with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByPrimaryKey(primaryKey);

		if (bollettinoBacino == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoBacinoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoBacino;
	}

	/**
	 * Returns the bollettino bacino with the primary key or throws a <code>NoSuchBollettinoBacinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino findByPrimaryKey(long id)
		throws NoSuchBollettinoBacinoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bollettino bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino bacino
	 * @return the bollettino bacino, or <code>null</code> if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BollettinoBacino bollettinoBacino = (BollettinoBacino)serializable;

		if (bollettinoBacino == null) {
			Session session = null;

			try {
				session = openSession();

				bollettinoBacino = (BollettinoBacino)session.get(
					BollettinoBacinoImpl.class, primaryKey);

				if (bollettinoBacino != null) {
					cacheResult(bollettinoBacino);
				}
				else {
					entityCache.putResult(
						BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
						BollettinoBacinoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoBacinoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bollettinoBacino;
	}

	/**
	 * Returns the bollettino bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino, or <code>null</code> if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, BollettinoBacino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BollettinoBacino> map =
			new HashMap<Serializable, BollettinoBacino>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BollettinoBacino bollettinoBacino = fetchByPrimaryKey(primaryKey);

			if (bollettinoBacino != null) {
				map.put(primaryKey, bollettinoBacino);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
				BollettinoBacinoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BollettinoBacino)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE_PKS_IN);

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

			for (BollettinoBacino bollettinoBacino :
					(List<BollettinoBacino>)q.list()) {

				map.put(bollettinoBacino.getPrimaryKeyObj(), bollettinoBacino);

				cacheResult(bollettinoBacino);

				uncachedPrimaryKeys.remove(bollettinoBacino.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoBacinoImpl.class, primaryKey, nullModel);
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
	 * Returns all the bollettino bacinos.
	 *
	 * @return the bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll(
		int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll(
		int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		List<BollettinoBacino> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoBacino>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOLLETTINOBACINO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOBACINO;

				if (pagination) {
					sql = sql.concat(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BollettinoBacino>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoBacino>)QueryUtil.list(
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
	 * Removes all the bollettino bacinos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoBacino bollettinoBacino : findAll()) {
			remove(bollettinoBacino);
		}
	}

	/**
	 * Returns the number of bollettino bacinos.
	 *
	 * @return the number of bollettino bacinos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOLLETTINOBACINO);

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
		return BollettinoBacinoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino bacino persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED,
			BollettinoBacinoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED,
			BollettinoBacinoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED,
			BollettinoBacinoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED,
			BollettinoBacinoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			BollettinoBacinoModelImpl.UUID_COLUMN_BITMASK |
			BollettinoBacinoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByBollettino = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED,
			BollettinoBacinoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBollettino",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByBollettino = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED,
			BollettinoBacinoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBollettino",
			new String[] {Long.class.getName()},
			BollettinoBacinoModelImpl.IDBOLLETTINO_COLUMN_BITMASK |
			BollettinoBacinoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByBollettino = new FinderPath(
			BollettinoBacinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoBacinoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBollettino",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(BollettinoBacinoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOLLETTINOBACINO =
		"SELECT bollettinoBacino FROM BollettinoBacino bollettinoBacino";

	private static final String _SQL_SELECT_BOLLETTINOBACINO_WHERE_PKS_IN =
		"SELECT bollettinoBacino FROM BollettinoBacino bollettinoBacino WHERE id_ IN (";

	private static final String _SQL_SELECT_BOLLETTINOBACINO_WHERE =
		"SELECT bollettinoBacino FROM BollettinoBacino bollettinoBacino WHERE ";

	private static final String _SQL_COUNT_BOLLETTINOBACINO =
		"SELECT COUNT(bollettinoBacino) FROM BollettinoBacino bollettinoBacino";

	private static final String _SQL_COUNT_BOLLETTINOBACINO_WHERE =
		"SELECT COUNT(bollettinoBacino) FROM BollettinoBacino bollettinoBacino WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoBacino.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoBacino exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BollettinoBacino exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoBacinoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}