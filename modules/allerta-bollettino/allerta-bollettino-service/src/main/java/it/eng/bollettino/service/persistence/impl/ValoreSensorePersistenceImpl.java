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

import it.eng.bollettino.exception.NoSuchValoreSensoreException;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.model.impl.ValoreSensoreImpl;
import it.eng.bollettino.model.impl.ValoreSensoreModelImpl;
import it.eng.bollettino.service.persistence.ValoreSensorePersistence;

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
 * The persistence implementation for the valore sensore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class ValoreSensorePersistenceImpl
	extends BasePersistenceImpl<ValoreSensore>
	implements ValoreSensorePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ValoreSensoreUtil</code> to access the valore sensore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ValoreSensoreImpl.class.getName();

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
	 * Returns all the valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator,
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

		List<ValoreSensore> list = null;

		if (retrieveFromCache) {
			list = (List<ValoreSensore>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValoreSensore valoreSensore : list) {
					if (!uuid.equals(valoreSensore.getUuid())) {
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

			query.append(_SQL_SELECT_VALORESENSORE_WHERE);

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
				query.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
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
					list = (List<ValoreSensore>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ValoreSensore>)QueryUtil.list(
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
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByUuid_First(
			String uuid, OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByUuid_First(
			uuid, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchValoreSensoreException(msg.toString());
	}

	/**
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByUuid_First(
		String uuid, OrderByComparator<ValoreSensore> orderByComparator) {

		List<ValoreSensore> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByUuid_Last(
			String uuid, OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByUuid_Last(uuid, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchValoreSensoreException(msg.toString());
	}

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByUuid_Last(
		String uuid, OrderByComparator<ValoreSensore> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ValoreSensore> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		uuid = Objects.toString(uuid, "");

		ValoreSensore valoreSensore = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValoreSensore[] array = new ValoreSensoreImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, valoreSensore, uuid, orderByComparator, true);

			array[1] = valoreSensore;

			array[2] = getByUuid_PrevAndNext(
				session, valoreSensore, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ValoreSensore getByUuid_PrevAndNext(
		Session session, ValoreSensore valoreSensore, String uuid,
		OrderByComparator<ValoreSensore> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VALORESENSORE_WHERE);

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
			query.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
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
						valoreSensore)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ValoreSensore> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the valore sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ValoreSensore valoreSensore :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(valoreSensore);
		}
	}

	/**
	 * Returns the number of valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching valore sensores
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VALORESENSORE_WHERE);

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
		"valoreSensore.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(valoreSensore.uuid IS NULL OR valoreSensore.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByvariabileStazione;
	private FinderPath _finderPathWithoutPaginationFindByvariabileStazione;
	private FinderPath _finderPathCountByvariabileStazione;

	/**
	 * Returns all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione) {

		return findByvariabileStazione(
			idVariabile, idStazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end) {

		return findByvariabileStazione(
			idVariabile, idStazione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return findByvariabileStazione(
			idVariabile, idStazione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator,
		boolean retrieveFromCache) {

		idVariabile = Objects.toString(idVariabile, "");
		idStazione = Objects.toString(idStazione, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByvariabileStazione;
			finderArgs = new Object[] {idVariabile, idStazione};
		}
		else {
			finderPath = _finderPathWithPaginationFindByvariabileStazione;
			finderArgs = new Object[] {
				idVariabile, idStazione, start, end, orderByComparator
			};
		}

		List<ValoreSensore> list = null;

		if (retrieveFromCache) {
			list = (List<ValoreSensore>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValoreSensore valoreSensore : list) {
					if (!idVariabile.equals(valoreSensore.getIdVariabile()) ||
						!idStazione.equals(valoreSensore.getIdStazione())) {

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

			query.append(_SQL_SELECT_VALORESENSORE_WHERE);

			boolean bindIdVariabile = false;

			if (idVariabile.isEmpty()) {
				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3);
			}
			else {
				bindIdVariabile = true;

				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2);
			}

			boolean bindIdStazione = false;

			if (idStazione.isEmpty()) {
				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3);
			}
			else {
				bindIdStazione = true;

				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
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

				if (bindIdStazione) {
					qPos.add(idStazione);
				}

				if (!pagination) {
					list = (List<ValoreSensore>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ValoreSensore>)QueryUtil.list(
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
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByvariabileStazione_First(
			String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByvariabileStazione_First(
			idVariabile, idStazione, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idVariabile=");
		msg.append(idVariabile);

		msg.append(", idStazione=");
		msg.append(idStazione);

		msg.append("}");

		throw new NoSuchValoreSensoreException(msg.toString());
	}

	/**
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByvariabileStazione_First(
		String idVariabile, String idStazione,
		OrderByComparator<ValoreSensore> orderByComparator) {

		List<ValoreSensore> list = findByvariabileStazione(
			idVariabile, idStazione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByvariabileStazione_Last(
			String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByvariabileStazione_Last(
			idVariabile, idStazione, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idVariabile=");
		msg.append(idVariabile);

		msg.append(", idStazione=");
		msg.append(idStazione);

		msg.append("}");

		throw new NoSuchValoreSensoreException(msg.toString());
	}

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByvariabileStazione_Last(
		String idVariabile, String idStazione,
		OrderByComparator<ValoreSensore> orderByComparator) {

		int count = countByvariabileStazione(idVariabile, idStazione);

		if (count == 0) {
			return null;
		}

		List<ValoreSensore> list = findByvariabileStazione(
			idVariabile, idStazione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore[] findByvariabileStazione_PrevAndNext(
			long id, String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		idVariabile = Objects.toString(idVariabile, "");
		idStazione = Objects.toString(idStazione, "");

		ValoreSensore valoreSensore = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValoreSensore[] array = new ValoreSensoreImpl[3];

			array[0] = getByvariabileStazione_PrevAndNext(
				session, valoreSensore, idVariabile, idStazione,
				orderByComparator, true);

			array[1] = valoreSensore;

			array[2] = getByvariabileStazione_PrevAndNext(
				session, valoreSensore, idVariabile, idStazione,
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

	protected ValoreSensore getByvariabileStazione_PrevAndNext(
		Session session, ValoreSensore valoreSensore, String idVariabile,
		String idStazione, OrderByComparator<ValoreSensore> orderByComparator,
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

		query.append(_SQL_SELECT_VALORESENSORE_WHERE);

		boolean bindIdVariabile = false;

		if (idVariabile.isEmpty()) {
			query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3);
		}
		else {
			bindIdVariabile = true;

			query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2);
		}

		boolean bindIdStazione = false;

		if (idStazione.isEmpty()) {
			query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3);
		}
		else {
			bindIdStazione = true;

			query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2);
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
			query.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIdVariabile) {
			qPos.add(idVariabile);
		}

		if (bindIdStazione) {
			qPos.add(idStazione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						valoreSensore)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ValoreSensore> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the valore sensores where idVariabile = &#63; and idStazione = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 */
	@Override
	public void removeByvariabileStazione(
		String idVariabile, String idStazione) {

		for (ValoreSensore valoreSensore :
				findByvariabileStazione(
					idVariabile, idStazione, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(valoreSensore);
		}
	}

	/**
	 * Returns the number of valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the number of matching valore sensores
	 */
	@Override
	public int countByvariabileStazione(String idVariabile, String idStazione) {
		idVariabile = Objects.toString(idVariabile, "");
		idStazione = Objects.toString(idStazione, "");

		FinderPath finderPath = _finderPathCountByvariabileStazione;

		Object[] finderArgs = new Object[] {idVariabile, idStazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VALORESENSORE_WHERE);

			boolean bindIdVariabile = false;

			if (idVariabile.isEmpty()) {
				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3);
			}
			else {
				bindIdVariabile = true;

				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2);
			}

			boolean bindIdStazione = false;

			if (idStazione.isEmpty()) {
				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3);
			}
			else {
				bindIdStazione = true;

				query.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2);
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

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2 =
		"valoreSensore.idVariabile = ? AND ";

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3 =
		"(valoreSensore.idVariabile IS NULL OR valoreSensore.idVariabile = '') AND ";

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2 =
		"valoreSensore.idStazione = ?";

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3 =
		"(valoreSensore.idStazione IS NULL OR valoreSensore.idStazione = '')";

	public ValoreSensorePersistenceImpl() {
		setModelClass(ValoreSensore.class);

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
	 * Caches the valore sensore in the entity cache if it is enabled.
	 *
	 * @param valoreSensore the valore sensore
	 */
	@Override
	public void cacheResult(ValoreSensore valoreSensore) {
		entityCache.putResult(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreImpl.class, valoreSensore.getPrimaryKey(),
			valoreSensore);

		valoreSensore.resetOriginalValues();
	}

	/**
	 * Caches the valore sensores in the entity cache if it is enabled.
	 *
	 * @param valoreSensores the valore sensores
	 */
	@Override
	public void cacheResult(List<ValoreSensore> valoreSensores) {
		for (ValoreSensore valoreSensore : valoreSensores) {
			if (entityCache.getResult(
					ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
					ValoreSensoreImpl.class, valoreSensore.getPrimaryKey()) ==
						null) {

				cacheResult(valoreSensore);
			}
			else {
				valoreSensore.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all valore sensores.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ValoreSensoreImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the valore sensore.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ValoreSensore valoreSensore) {
		entityCache.removeResult(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreImpl.class, valoreSensore.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ValoreSensore> valoreSensores) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ValoreSensore valoreSensore : valoreSensores) {
			entityCache.removeResult(
				ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
				ValoreSensoreImpl.class, valoreSensore.getPrimaryKey());
		}
	}

	/**
	 * Creates a new valore sensore with the primary key. Does not add the valore sensore to the database.
	 *
	 * @param id the primary key for the new valore sensore
	 * @return the new valore sensore
	 */
	@Override
	public ValoreSensore create(long id) {
		ValoreSensore valoreSensore = new ValoreSensoreImpl();

		valoreSensore.setNew(true);
		valoreSensore.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		valoreSensore.setUuid(uuid);

		return valoreSensore;
	}

	/**
	 * Removes the valore sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore that was removed
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore remove(long id) throws NoSuchValoreSensoreException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the valore sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the valore sensore
	 * @return the valore sensore that was removed
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore remove(Serializable primaryKey)
		throws NoSuchValoreSensoreException {

		Session session = null;

		try {
			session = openSession();

			ValoreSensore valoreSensore = (ValoreSensore)session.get(
				ValoreSensoreImpl.class, primaryKey);

			if (valoreSensore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchValoreSensoreException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(valoreSensore);
		}
		catch (NoSuchValoreSensoreException nsee) {
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
	protected ValoreSensore removeImpl(ValoreSensore valoreSensore) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(valoreSensore)) {
				valoreSensore = (ValoreSensore)session.get(
					ValoreSensoreImpl.class, valoreSensore.getPrimaryKeyObj());
			}

			if (valoreSensore != null) {
				session.delete(valoreSensore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (valoreSensore != null) {
			clearCache(valoreSensore);
		}

		return valoreSensore;
	}

	@Override
	public ValoreSensore updateImpl(ValoreSensore valoreSensore) {
		boolean isNew = valoreSensore.isNew();

		if (!(valoreSensore instanceof ValoreSensoreModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(valoreSensore.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					valoreSensore);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in valoreSensore proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ValoreSensore implementation " +
					valoreSensore.getClass());
		}

		ValoreSensoreModelImpl valoreSensoreModelImpl =
			(ValoreSensoreModelImpl)valoreSensore;

		if (Validator.isNull(valoreSensore.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			valoreSensore.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (valoreSensore.isNew()) {
				session.save(valoreSensore);

				valoreSensore.setNew(false);
			}
			else {
				valoreSensore = (ValoreSensore)session.merge(valoreSensore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ValoreSensoreModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {valoreSensoreModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				valoreSensoreModelImpl.getIdVariabile(),
				valoreSensoreModelImpl.getIdStazione()
			};

			finderCache.removeResult(_finderPathCountByvariabileStazione, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByvariabileStazione, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((valoreSensoreModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					valoreSensoreModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {valoreSensoreModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((valoreSensoreModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByvariabileStazione.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					valoreSensoreModelImpl.getOriginalIdVariabile(),
					valoreSensoreModelImpl.getOriginalIdStazione()
				};

				finderCache.removeResult(
					_finderPathCountByvariabileStazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByvariabileStazione, args);

				args = new Object[] {
					valoreSensoreModelImpl.getIdVariabile(),
					valoreSensoreModelImpl.getIdStazione()
				};

				finderCache.removeResult(
					_finderPathCountByvariabileStazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByvariabileStazione, args);
			}
		}

		entityCache.putResult(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreImpl.class, valoreSensore.getPrimaryKey(),
			valoreSensore, false);

		valoreSensore.resetOriginalValues();

		return valoreSensore;
	}

	/**
	 * Returns the valore sensore with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the valore sensore
	 * @return the valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByPrimaryKey(primaryKey);

		if (valoreSensore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchValoreSensoreException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return valoreSensore;
	}

	/**
	 * Returns the valore sensore with the primary key or throws a <code>NoSuchValoreSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore findByPrimaryKey(long id)
		throws NoSuchValoreSensoreException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the valore sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the valore sensore
	 * @return the valore sensore, or <code>null</code> if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ValoreSensore valoreSensore = (ValoreSensore)serializable;

		if (valoreSensore == null) {
			Session session = null;

			try {
				session = openSession();

				valoreSensore = (ValoreSensore)session.get(
					ValoreSensoreImpl.class, primaryKey);

				if (valoreSensore != null) {
					cacheResult(valoreSensore);
				}
				else {
					entityCache.putResult(
						ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
						ValoreSensoreImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
					ValoreSensoreImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return valoreSensore;
	}

	/**
	 * Returns the valore sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore, or <code>null</code> if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ValoreSensore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ValoreSensore> map =
			new HashMap<Serializable, ValoreSensore>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ValoreSensore valoreSensore = fetchByPrimaryKey(primaryKey);

			if (valoreSensore != null) {
				map.put(primaryKey, valoreSensore);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
				ValoreSensoreImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ValoreSensore)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_VALORESENSORE_WHERE_PKS_IN);

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

			for (ValoreSensore valoreSensore : (List<ValoreSensore>)q.list()) {
				map.put(valoreSensore.getPrimaryKeyObj(), valoreSensore);

				cacheResult(valoreSensore);

				uncachedPrimaryKeys.remove(valoreSensore.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
					ValoreSensoreImpl.class, primaryKey, nullModel);
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
	 * Returns all the valore sensores.
	 *
	 * @return the valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll(
		int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll(
		int start, int end, OrderByComparator<ValoreSensore> orderByComparator,
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

		List<ValoreSensore> list = null;

		if (retrieveFromCache) {
			list = (List<ValoreSensore>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VALORESENSORE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VALORESENSORE;

				if (pagination) {
					sql = sql.concat(ValoreSensoreModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ValoreSensore>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ValoreSensore>)QueryUtil.list(
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
	 * Removes all the valore sensores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ValoreSensore valoreSensore : findAll()) {
			remove(valoreSensore);
		}
	}

	/**
	 * Returns the number of valore sensores.
	 *
	 * @return the number of valore sensores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VALORESENSORE);

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
		return ValoreSensoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the valore sensore persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED,
			ValoreSensoreImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED,
			ValoreSensoreImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED,
			ValoreSensoreImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED,
			ValoreSensoreImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			ValoreSensoreModelImpl.UUID_COLUMN_BITMASK |
			ValoreSensoreModelImpl.DATETIME_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByvariabileStazione = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED,
			ValoreSensoreImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByvariabileStazione",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByvariabileStazione = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED,
			ValoreSensoreImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByvariabileStazione",
			new String[] {String.class.getName(), String.class.getName()},
			ValoreSensoreModelImpl.IDVARIABILE_COLUMN_BITMASK |
			ValoreSensoreModelImpl.IDSTAZIONE_COLUMN_BITMASK |
			ValoreSensoreModelImpl.DATETIME_COLUMN_BITMASK);

		_finderPathCountByvariabileStazione = new FinderPath(
			ValoreSensoreModelImpl.ENTITY_CACHE_ENABLED,
			ValoreSensoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByvariabileStazione",
			new String[] {String.class.getName(), String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ValoreSensoreImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VALORESENSORE =
		"SELECT valoreSensore FROM ValoreSensore valoreSensore";

	private static final String _SQL_SELECT_VALORESENSORE_WHERE_PKS_IN =
		"SELECT valoreSensore FROM ValoreSensore valoreSensore WHERE id_ IN (";

	private static final String _SQL_SELECT_VALORESENSORE_WHERE =
		"SELECT valoreSensore FROM ValoreSensore valoreSensore WHERE ";

	private static final String _SQL_COUNT_VALORESENSORE =
		"SELECT COUNT(valoreSensore) FROM ValoreSensore valoreSensore";

	private static final String _SQL_COUNT_VALORESENSORE_WHERE =
		"SELECT COUNT(valoreSensore) FROM ValoreSensore valoreSensore WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "valoreSensore.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ValoreSensore exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ValoreSensore exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ValoreSensorePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}