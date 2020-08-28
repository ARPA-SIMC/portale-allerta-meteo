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

import it.eng.bollettino.exception.NoSuchBollettinoIconaException;
import it.eng.bollettino.model.BollettinoIcona;
import it.eng.bollettino.model.impl.BollettinoIconaImpl;
import it.eng.bollettino.model.impl.BollettinoIconaModelImpl;
import it.eng.bollettino.service.persistence.BollettinoIconaPersistence;

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
 * The persistence implementation for the bollettino icona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoIconaPersistenceImpl
	extends BasePersistenceImpl<BollettinoIcona>
	implements BollettinoIconaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoIconaUtil</code> to access the bollettino icona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoIconaImpl.class.getName();

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
	 * Returns all the bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		List<BollettinoIcona> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoIcona>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoIcona bollettinoIcona : list) {
					if (!uuid.equals(bollettinoIcona.getUuid())) {
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

			query.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

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
				query.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
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
					list = (List<BollettinoIcona>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoIcona>)QueryUtil.list(
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
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByUuid_First(
			String uuid, OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByUuid_First(
			uuid, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBollettinoIconaException(msg.toString());
	}

	/**
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoIcona> orderByComparator) {

		List<BollettinoIcona> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByUuid_Last(
			String uuid, OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBollettinoIconaException(msg.toString());
	}

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoIcona> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BollettinoIcona> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		uuid = Objects.toString(uuid, "");

		BollettinoIcona bollettinoIcona = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoIcona[] array = new BollettinoIconaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bollettinoIcona, uuid, orderByComparator, true);

			array[1] = bollettinoIcona;

			array[2] = getByUuid_PrevAndNext(
				session, bollettinoIcona, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BollettinoIcona getByUuid_PrevAndNext(
		Session session, BollettinoIcona bollettinoIcona, String uuid,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		query.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

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
			query.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
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
						bollettinoIcona)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<BollettinoIcona> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BollettinoIcona bollettinoIcona :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoIcona);
		}
	}

	/**
	 * Returns the number of bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino iconas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOLLETTINOICONA_WHERE);

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
		"bollettinoIcona.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bollettinoIcona.uuid IS NULL OR bollettinoIcona.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByBollettino;
	private FinderPath _finderPathWithoutPaginationFindByBollettino;
	private FinderPath _finderPathCountByBollettino;

	/**
	 * Returns all the bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(long idBollettino) {
		return findByBollettino(
			idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end) {

		return findByBollettino(idBollettino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return findByBollettino(
			idBollettino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		List<BollettinoIcona> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoIcona>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoIcona bollettinoIcona : list) {
					if ((idBollettino != bollettinoIcona.getIdBollettino())) {
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

			query.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

			query.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idBollettino);

				if (!pagination) {
					list = (List<BollettinoIcona>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoIcona>)QueryUtil.list(
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
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByBollettino_First(
			idBollettino, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idBollettino=");
		msg.append(idBollettino);

		msg.append("}");

		throw new NoSuchBollettinoIconaException(msg.toString());
	}

	/**
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		List<BollettinoIcona> list = findByBollettino(
			idBollettino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByBollettino_Last(
			idBollettino, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idBollettino=");
		msg.append(idBollettino);

		msg.append("}");

		throw new NoSuchBollettinoIconaException(msg.toString());
	}

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		int count = countByBollettino(idBollettino);

		if (count == 0) {
			return null;
		}

		List<BollettinoIcona> list = findByBollettino(
			idBollettino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoIcona[] array = new BollettinoIconaImpl[3];

			array[0] = getByBollettino_PrevAndNext(
				session, bollettinoIcona, idBollettino, orderByComparator,
				true);

			array[1] = bollettinoIcona;

			array[2] = getByBollettino_PrevAndNext(
				session, bollettinoIcona, idBollettino, orderByComparator,
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

	protected BollettinoIcona getByBollettino_PrevAndNext(
		Session session, BollettinoIcona bollettinoIcona, long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		query.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

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
			query.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
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
						bollettinoIcona)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<BollettinoIcona> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino iconas where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	@Override
	public void removeByBollettino(long idBollettino) {
		for (BollettinoIcona bollettinoIcona :
				findByBollettino(
					idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoIcona);
		}
	}

	/**
	 * Returns the number of bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino iconas
	 */
	@Override
	public int countByBollettino(long idBollettino) {
		FinderPath finderPath = _finderPathCountByBollettino;

		Object[] finderArgs = new Object[] {idBollettino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOLLETTINOICONA_WHERE);

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
		"bollettinoIcona.idBollettino = ?";

	public BollettinoIconaPersistenceImpl() {
		setModelClass(BollettinoIcona.class);

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
	 * Caches the bollettino icona in the entity cache if it is enabled.
	 *
	 * @param bollettinoIcona the bollettino icona
	 */
	@Override
	public void cacheResult(BollettinoIcona bollettinoIcona) {
		entityCache.putResult(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaImpl.class, bollettinoIcona.getPrimaryKey(),
			bollettinoIcona);

		bollettinoIcona.resetOriginalValues();
	}

	/**
	 * Caches the bollettino iconas in the entity cache if it is enabled.
	 *
	 * @param bollettinoIconas the bollettino iconas
	 */
	@Override
	public void cacheResult(List<BollettinoIcona> bollettinoIconas) {
		for (BollettinoIcona bollettinoIcona : bollettinoIconas) {
			if (entityCache.getResult(
					BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoIconaImpl.class,
					bollettinoIcona.getPrimaryKey()) == null) {

				cacheResult(bollettinoIcona);
			}
			else {
				bollettinoIcona.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bollettino iconas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoIconaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bollettino icona.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoIcona bollettinoIcona) {
		entityCache.removeResult(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaImpl.class, bollettinoIcona.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BollettinoIcona> bollettinoIconas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BollettinoIcona bollettinoIcona : bollettinoIconas) {
			entityCache.removeResult(
				BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
				BollettinoIconaImpl.class, bollettinoIcona.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bollettino icona with the primary key. Does not add the bollettino icona to the database.
	 *
	 * @param id the primary key for the new bollettino icona
	 * @return the new bollettino icona
	 */
	@Override
	public BollettinoIcona create(long id) {
		BollettinoIcona bollettinoIcona = new BollettinoIconaImpl();

		bollettinoIcona.setNew(true);
		bollettinoIcona.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		bollettinoIcona.setUuid(uuid);

		return bollettinoIcona;
	}

	/**
	 * Removes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona remove(long id)
		throws NoSuchBollettinoIconaException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona remove(Serializable primaryKey)
		throws NoSuchBollettinoIconaException {

		Session session = null;

		try {
			session = openSession();

			BollettinoIcona bollettinoIcona = (BollettinoIcona)session.get(
				BollettinoIconaImpl.class, primaryKey);

			if (bollettinoIcona == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoIconaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoIcona);
		}
		catch (NoSuchBollettinoIconaException nsee) {
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
	protected BollettinoIcona removeImpl(BollettinoIcona bollettinoIcona) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoIcona)) {
				bollettinoIcona = (BollettinoIcona)session.get(
					BollettinoIconaImpl.class,
					bollettinoIcona.getPrimaryKeyObj());
			}

			if (bollettinoIcona != null) {
				session.delete(bollettinoIcona);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoIcona != null) {
			clearCache(bollettinoIcona);
		}

		return bollettinoIcona;
	}

	@Override
	public BollettinoIcona updateImpl(BollettinoIcona bollettinoIcona) {
		boolean isNew = bollettinoIcona.isNew();

		if (!(bollettinoIcona instanceof BollettinoIconaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettinoIcona.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bollettinoIcona);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettinoIcona proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BollettinoIcona implementation " +
					bollettinoIcona.getClass());
		}

		BollettinoIconaModelImpl bollettinoIconaModelImpl =
			(BollettinoIconaModelImpl)bollettinoIcona;

		if (Validator.isNull(bollettinoIcona.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bollettinoIcona.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (bollettinoIcona.isNew()) {
				session.save(bollettinoIcona);

				bollettinoIcona.setNew(false);
			}
			else {
				bollettinoIcona = (BollettinoIcona)session.merge(
					bollettinoIcona);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BollettinoIconaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {bollettinoIconaModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {bollettinoIconaModelImpl.getIdBollettino()};

			finderCache.removeResult(_finderPathCountByBollettino, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByBollettino, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((bollettinoIconaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					bollettinoIconaModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {bollettinoIconaModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((bollettinoIconaModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByBollettino.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					bollettinoIconaModelImpl.getOriginalIdBollettino()
				};

				finderCache.removeResult(_finderPathCountByBollettino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByBollettino, args);

				args = new Object[] {
					bollettinoIconaModelImpl.getIdBollettino()
				};

				finderCache.removeResult(_finderPathCountByBollettino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByBollettino, args);
			}
		}

		entityCache.putResult(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaImpl.class, bollettinoIcona.getPrimaryKey(),
			bollettinoIcona, false);

		bollettinoIcona.resetOriginalValues();

		return bollettinoIcona;
	}

	/**
	 * Returns the bollettino icona with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByPrimaryKey(primaryKey);

		if (bollettinoIcona == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoIconaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoIcona;
	}

	/**
	 * Returns the bollettino icona with the primary key or throws a <code>NoSuchBollettinoIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona findByPrimaryKey(long id)
		throws NoSuchBollettinoIconaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bollettino icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino icona
	 * @return the bollettino icona, or <code>null</code> if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BollettinoIcona bollettinoIcona = (BollettinoIcona)serializable;

		if (bollettinoIcona == null) {
			Session session = null;

			try {
				session = openSession();

				bollettinoIcona = (BollettinoIcona)session.get(
					BollettinoIconaImpl.class, primaryKey);

				if (bollettinoIcona != null) {
					cacheResult(bollettinoIcona);
				}
				else {
					entityCache.putResult(
						BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
						BollettinoIconaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoIconaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bollettinoIcona;
	}

	/**
	 * Returns the bollettino icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona, or <code>null</code> if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, BollettinoIcona> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BollettinoIcona> map =
			new HashMap<Serializable, BollettinoIcona>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BollettinoIcona bollettinoIcona = fetchByPrimaryKey(primaryKey);

			if (bollettinoIcona != null) {
				map.put(primaryKey, bollettinoIcona);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
				BollettinoIconaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BollettinoIcona)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_BOLLETTINOICONA_WHERE_PKS_IN);

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

			for (BollettinoIcona bollettinoIcona :
					(List<BollettinoIcona>)q.list()) {

				map.put(bollettinoIcona.getPrimaryKeyObj(), bollettinoIcona);

				cacheResult(bollettinoIcona);

				uncachedPrimaryKeys.remove(bollettinoIcona.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoIconaImpl.class, primaryKey, nullModel);
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
	 * Returns all the bollettino iconas.
	 *
	 * @return the bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll(
		int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll(
		int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		List<BollettinoIcona> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoIcona>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOLLETTINOICONA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOICONA;

				if (pagination) {
					sql = sql.concat(BollettinoIconaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BollettinoIcona>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoIcona>)QueryUtil.list(
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
	 * Removes all the bollettino iconas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoIcona bollettinoIcona : findAll()) {
			remove(bollettinoIcona);
		}
	}

	/**
	 * Returns the number of bollettino iconas.
	 *
	 * @return the number of bollettino iconas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOLLETTINOICONA);

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
		return BollettinoIconaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino icona persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED,
			BollettinoIconaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED,
			BollettinoIconaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED,
			BollettinoIconaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED,
			BollettinoIconaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			BollettinoIconaModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByBollettino = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED,
			BollettinoIconaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBollettino",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByBollettino = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED,
			BollettinoIconaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBollettino",
			new String[] {Long.class.getName()},
			BollettinoIconaModelImpl.IDBOLLETTINO_COLUMN_BITMASK);

		_finderPathCountByBollettino = new FinderPath(
			BollettinoIconaModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoIconaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBollettino",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(BollettinoIconaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOLLETTINOICONA =
		"SELECT bollettinoIcona FROM BollettinoIcona bollettinoIcona";

	private static final String _SQL_SELECT_BOLLETTINOICONA_WHERE_PKS_IN =
		"SELECT bollettinoIcona FROM BollettinoIcona bollettinoIcona WHERE id_ IN (";

	private static final String _SQL_SELECT_BOLLETTINOICONA_WHERE =
		"SELECT bollettinoIcona FROM BollettinoIcona bollettinoIcona WHERE ";

	private static final String _SQL_COUNT_BOLLETTINOICONA =
		"SELECT COUNT(bollettinoIcona) FROM BollettinoIcona bollettinoIcona";

	private static final String _SQL_COUNT_BOLLETTINOICONA_WHERE =
		"SELECT COUNT(bollettinoIcona) FROM BollettinoIcona bollettinoIcona WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoIcona.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoIcona exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BollettinoIcona exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoIconaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}