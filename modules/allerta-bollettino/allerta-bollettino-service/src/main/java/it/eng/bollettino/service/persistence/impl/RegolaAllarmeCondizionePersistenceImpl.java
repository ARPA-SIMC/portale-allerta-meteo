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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeCondizioneException;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.impl.RegolaAllarmeCondizioneImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl;
import it.eng.bollettino.service.persistence.RegolaAllarmeCondizionePersistence;

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
 * The persistence implementation for the regola allarme condizione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizionePersistenceImpl
	extends BasePersistenceImpl<RegolaAllarmeCondizione>
	implements RegolaAllarmeCondizionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegolaAllarmeCondizioneUtil</code> to access the regola allarme condizione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegolaAllarmeCondizioneImpl.class.getName();

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
	 * Returns all the regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		List<RegolaAllarmeCondizione> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeCondizione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeCondizione regolaAllarmeCondizione : list) {
					if (!uuid.equals(regolaAllarmeCondizione.getUuid())) {
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

			query.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

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
				query.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
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
					list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
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
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByUuid_First(
			String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByUuid_First(
			uuid, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(msg.toString());
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByUuid_First(
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		List<RegolaAllarmeCondizione> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByUuid_Last(
			String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByUuid_Last(
			uuid, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(msg.toString());
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByUuid_Last(
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeCondizione> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		uuid = Objects.toString(uuid, "");

		RegolaAllarmeCondizione regolaAllarmeCondizione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeCondizione[] array =
				new RegolaAllarmeCondizioneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, regolaAllarmeCondizione, uuid, orderByComparator,
				true);

			array[1] = regolaAllarmeCondizione;

			array[2] = getByUuid_PrevAndNext(
				session, regolaAllarmeCondizione, uuid, orderByComparator,
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

	protected RegolaAllarmeCondizione getByUuid_PrevAndNext(
		Session session, RegolaAllarmeCondizione regolaAllarmeCondizione,
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		query.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

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
			query.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
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
						regolaAllarmeCondizione)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeCondizione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme condiziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeCondizione);
		}
	}

	/**
	 * Returns the number of regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme condiziones
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARMECONDIZIONE_WHERE);

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
		"regolaAllarmeCondizione.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(regolaAllarmeCondizione.uuid IS NULL OR regolaAllarmeCondizione.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByRegola;
	private FinderPath _finderPathWithoutPaginationFindByRegola;
	private FinderPath _finderPathCountByRegola;

	/**
	 * Returns all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(long idRegola) {
		return findByRegola(
			idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end) {

		return findByRegola(idRegola, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return findByRegola(idRegola, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		List<RegolaAllarmeCondizione> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeCondizione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeCondizione regolaAllarmeCondizione : list) {
					if ((idRegola != regolaAllarmeCondizione.getIdRegola())) {
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

			query.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

			query.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idRegola);

				if (!pagination) {
					list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
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
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByRegola_First(
			long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByRegola_First(
			idRegola, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idRegola=");
		msg.append(idRegola);

		msg.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(msg.toString());
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByRegola_First(
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		List<RegolaAllarmeCondizione> list = findByRegola(
			idRegola, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByRegola_Last(
			long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByRegola_Last(
			idRegola, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idRegola=");
		msg.append(idRegola);

		msg.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(msg.toString());
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByRegola_Last(
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		int count = countByRegola(idRegola);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeCondizione> list = findByRegola(
			idRegola, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione[] findByRegola_PrevAndNext(
			long id, long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeCondizione[] array =
				new RegolaAllarmeCondizioneImpl[3];

			array[0] = getByRegola_PrevAndNext(
				session, regolaAllarmeCondizione, idRegola, orderByComparator,
				true);

			array[1] = regolaAllarmeCondizione;

			array[2] = getByRegola_PrevAndNext(
				session, regolaAllarmeCondizione, idRegola, orderByComparator,
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

	protected RegolaAllarmeCondizione getByRegola_PrevAndNext(
		Session session, RegolaAllarmeCondizione regolaAllarmeCondizione,
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		query.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

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
			query.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
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
						regolaAllarmeCondizione)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeCondizione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme condiziones where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	@Override
	public void removeByRegola(long idRegola) {
		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				findByRegola(
					idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeCondizione);
		}
	}

	/**
	 * Returns the number of regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme condiziones
	 */
	@Override
	public int countByRegola(long idRegola) {
		FinderPath finderPath = _finderPathCountByRegola;

		Object[] finderArgs = new Object[] {idRegola};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGOLAALLARMECONDIZIONE_WHERE);

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
		"regolaAllarmeCondizione.idRegola = ?";

	public RegolaAllarmeCondizionePersistenceImpl() {
		setModelClass(RegolaAllarmeCondizione.class);

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
	 * Caches the regola allarme condizione in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 */
	@Override
	public void cacheResult(RegolaAllarmeCondizione regolaAllarmeCondizione) {
		entityCache.putResult(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			regolaAllarmeCondizione.getPrimaryKey(), regolaAllarmeCondizione);

		regolaAllarmeCondizione.resetOriginalValues();
	}

	/**
	 * Caches the regola allarme condiziones in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondiziones the regola allarme condiziones
	 */
	@Override
	public void cacheResult(
		List<RegolaAllarmeCondizione> regolaAllarmeCondiziones) {

		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				regolaAllarmeCondiziones) {

			if (entityCache.getResult(
					RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeCondizioneImpl.class,
					regolaAllarmeCondizione.getPrimaryKey()) == null) {

				cacheResult(regolaAllarmeCondizione);
			}
			else {
				regolaAllarmeCondizione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all regola allarme condiziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegolaAllarmeCondizioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the regola allarme condizione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegolaAllarmeCondizione regolaAllarmeCondizione) {
		entityCache.removeResult(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			regolaAllarmeCondizione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RegolaAllarmeCondizione> regolaAllarmeCondiziones) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				regolaAllarmeCondiziones) {

			entityCache.removeResult(
				RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
				RegolaAllarmeCondizioneImpl.class,
				regolaAllarmeCondizione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	@Override
	public RegolaAllarmeCondizione create(long id) {
		RegolaAllarmeCondizione regolaAllarmeCondizione =
			new RegolaAllarmeCondizioneImpl();

		regolaAllarmeCondizione.setNew(true);
		regolaAllarmeCondizione.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		regolaAllarmeCondizione.setUuid(uuid);

		return regolaAllarmeCondizione;
	}

	/**
	 * Removes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione remove(long id)
		throws NoSuchRegolaAllarmeCondizioneException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione remove(Serializable primaryKey)
		throws NoSuchRegolaAllarmeCondizioneException {

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeCondizione regolaAllarmeCondizione =
				(RegolaAllarmeCondizione)session.get(
					RegolaAllarmeCondizioneImpl.class, primaryKey);

			if (regolaAllarmeCondizione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegolaAllarmeCondizioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(regolaAllarmeCondizione);
		}
		catch (NoSuchRegolaAllarmeCondizioneException nsee) {
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
	protected RegolaAllarmeCondizione removeImpl(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regolaAllarmeCondizione)) {
				regolaAllarmeCondizione = (RegolaAllarmeCondizione)session.get(
					RegolaAllarmeCondizioneImpl.class,
					regolaAllarmeCondizione.getPrimaryKeyObj());
			}

			if (regolaAllarmeCondizione != null) {
				session.delete(regolaAllarmeCondizione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (regolaAllarmeCondizione != null) {
			clearCache(regolaAllarmeCondizione);
		}

		return regolaAllarmeCondizione;
	}

	@Override
	public RegolaAllarmeCondizione updateImpl(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		boolean isNew = regolaAllarmeCondizione.isNew();

		if (!(regolaAllarmeCondizione instanceof
				RegolaAllarmeCondizioneModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(regolaAllarmeCondizione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					regolaAllarmeCondizione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in regolaAllarmeCondizione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegolaAllarmeCondizione implementation " +
					regolaAllarmeCondizione.getClass());
		}

		RegolaAllarmeCondizioneModelImpl regolaAllarmeCondizioneModelImpl =
			(RegolaAllarmeCondizioneModelImpl)regolaAllarmeCondizione;

		if (Validator.isNull(regolaAllarmeCondizione.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			regolaAllarmeCondizione.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (regolaAllarmeCondizione.isNew()) {
				session.save(regolaAllarmeCondizione);

				regolaAllarmeCondizione.setNew(false);
			}
			else {
				regolaAllarmeCondizione =
					(RegolaAllarmeCondizione)session.merge(
						regolaAllarmeCondizione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RegolaAllarmeCondizioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				regolaAllarmeCondizioneModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				regolaAllarmeCondizioneModelImpl.getIdRegola()
			};

			finderCache.removeResult(_finderPathCountByRegola, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRegola, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((regolaAllarmeCondizioneModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeCondizioneModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {
					regolaAllarmeCondizioneModelImpl.getUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((regolaAllarmeCondizioneModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRegola.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					regolaAllarmeCondizioneModelImpl.getOriginalIdRegola()
				};

				finderCache.removeResult(_finderPathCountByRegola, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRegola, args);

				args = new Object[] {
					regolaAllarmeCondizioneModelImpl.getIdRegola()
				};

				finderCache.removeResult(_finderPathCountByRegola, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRegola, args);
			}
		}

		entityCache.putResult(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			regolaAllarmeCondizione.getPrimaryKey(), regolaAllarmeCondizione,
			false);

		regolaAllarmeCondizione.resetOriginalValues();

		return regolaAllarmeCondizione;
	}

	/**
	 * Returns the regola allarme condizione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByPrimaryKey(
			primaryKey);

		if (regolaAllarmeCondizione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegolaAllarmeCondizioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return regolaAllarmeCondizione;
	}

	/**
	 * Returns the regola allarme condizione with the primary key or throws a <code>NoSuchRegolaAllarmeCondizioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeCondizioneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the regola allarme condizione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme condizione
	 * @return the regola allarme condizione, or <code>null</code> if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RegolaAllarmeCondizione regolaAllarmeCondizione =
			(RegolaAllarmeCondizione)serializable;

		if (regolaAllarmeCondizione == null) {
			Session session = null;

			try {
				session = openSession();

				regolaAllarmeCondizione = (RegolaAllarmeCondizione)session.get(
					RegolaAllarmeCondizioneImpl.class, primaryKey);

				if (regolaAllarmeCondizione != null) {
					cacheResult(regolaAllarmeCondizione);
				}
				else {
					entityCache.putResult(
						RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
						RegolaAllarmeCondizioneImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeCondizioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return regolaAllarmeCondizione;
	}

	/**
	 * Returns the regola allarme condizione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione, or <code>null</code> if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RegolaAllarmeCondizione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RegolaAllarmeCondizione> map =
			new HashMap<Serializable, RegolaAllarmeCondizione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByPrimaryKey(
				primaryKey);

			if (regolaAllarmeCondizione != null) {
				map.put(primaryKey, regolaAllarmeCondizione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
				RegolaAllarmeCondizioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RegolaAllarmeCondizione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE_PKS_IN);

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

			for (RegolaAllarmeCondizione regolaAllarmeCondizione :
					(List<RegolaAllarmeCondizione>)q.list()) {

				map.put(
					regolaAllarmeCondizione.getPrimaryKeyObj(),
					regolaAllarmeCondizione);

				cacheResult(regolaAllarmeCondizione);

				uncachedPrimaryKeys.remove(
					regolaAllarmeCondizione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
					RegolaAllarmeCondizioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the regola allarme condiziones.
	 *
	 * @return the regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		List<RegolaAllarmeCondizione> list = null;

		if (retrieveFromCache) {
			list = (List<RegolaAllarmeCondizione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGOLAALLARMECONDIZIONE;

				if (pagination) {
					sql = sql.concat(
						RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
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
	 * Removes all the regola allarme condiziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegolaAllarmeCondizione regolaAllarmeCondizione : findAll()) {
			remove(regolaAllarmeCondizione);
		}
	}

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_REGOLAALLARMECONDIZIONE);

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
		return RegolaAllarmeCondizioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the regola allarme condizione persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			RegolaAllarmeCondizioneModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRegola = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRegola",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRegola = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED,
			RegolaAllarmeCondizioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegola",
			new String[] {Long.class.getName()},
			RegolaAllarmeCondizioneModelImpl.IDREGOLA_COLUMN_BITMASK);

		_finderPathCountByRegola = new FinderPath(
			RegolaAllarmeCondizioneModelImpl.ENTITY_CACHE_ENABLED,
			RegolaAllarmeCondizioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegola",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RegolaAllarmeCondizioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REGOLAALLARMECONDIZIONE =
		"SELECT regolaAllarmeCondizione FROM RegolaAllarmeCondizione regolaAllarmeCondizione";

	private static final String
		_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE_PKS_IN =
			"SELECT regolaAllarmeCondizione FROM RegolaAllarmeCondizione regolaAllarmeCondizione WHERE id_ IN (";

	private static final String _SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE =
		"SELECT regolaAllarmeCondizione FROM RegolaAllarmeCondizione regolaAllarmeCondizione WHERE ";

	private static final String _SQL_COUNT_REGOLAALLARMECONDIZIONE =
		"SELECT COUNT(regolaAllarmeCondizione) FROM RegolaAllarmeCondizione regolaAllarmeCondizione";

	private static final String _SQL_COUNT_REGOLAALLARMECONDIZIONE_WHERE =
		"SELECT COUNT(regolaAllarmeCondizione) FROM RegolaAllarmeCondizione regolaAllarmeCondizione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"regolaAllarmeCondizione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegolaAllarmeCondizione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegolaAllarmeCondizione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegolaAllarmeCondizionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}