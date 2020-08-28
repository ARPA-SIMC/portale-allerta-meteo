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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.bollettino.exception.NoSuchImgException;
import it.eng.bollettino.model.Img;
import it.eng.bollettino.model.impl.ImgImpl;
import it.eng.bollettino.model.impl.ImgModelImpl;
import it.eng.bollettino.service.persistence.ImgPersistence;

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
 * The persistence implementation for the img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class ImgPersistenceImpl
	extends BasePersistenceImpl<Img> implements ImgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImgUtil</code> to access the img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImgImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByday;
	private FinderPath _finderPathWithoutPaginationFindByday;
	private FinderPath _finderPathCountByday;

	/**
	 * Returns all the imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the matching imgs
	 */
	@Override
	public List<Img> findByday(String day) {
		return findByday(day, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	@Override
	public List<Img> findByday(String day, int start, int end) {
		return findByday(day, start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByday(
		String day, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return findByday(day, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByday(
		String day, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean retrieveFromCache) {

		day = Objects.toString(day, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByday;
			finderArgs = new Object[] {day};
		}
		else {
			finderPath = _finderPathWithPaginationFindByday;
			finderArgs = new Object[] {day, start, end, orderByComparator};
		}

		List<Img> list = null;

		if (retrieveFromCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Img img : list) {
					if (!day.equals(img.getDay())) {
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

			query.append(_SQL_SELECT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				query.append(_FINDER_COLUMN_DAY_DAY_3);
			}
			else {
				bindDay = true;

				query.append(_FINDER_COLUMN_DAY_DAY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ImgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDay) {
					qPos.add(day);
				}

				if (!pagination) {
					list = (List<Img>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Img>)QueryUtil.list(
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
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByday_First(
			String day, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByday_First(day, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("day=");
		msg.append(day);

		msg.append("}");

		throw new NoSuchImgException(msg.toString());
	}

	/**
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByday_First(
		String day, OrderByComparator<Img> orderByComparator) {

		List<Img> list = findByday(day, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByday_Last(
			String day, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByday_Last(day, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("day=");
		msg.append(day);

		msg.append("}");

		throw new NoSuchImgException(msg.toString());
	}

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByday_Last(
		String day, OrderByComparator<Img> orderByComparator) {

		int count = countByday(day);

		if (count == 0) {
			return null;
		}

		List<Img> list = findByday(day, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img[] findByday_PrevAndNext(
			long id, String day, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		day = Objects.toString(day, "");

		Img img = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Img[] array = new ImgImpl[3];

			array[0] = getByday_PrevAndNext(
				session, img, day, orderByComparator, true);

			array[1] = img;

			array[2] = getByday_PrevAndNext(
				session, img, day, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Img getByday_PrevAndNext(
		Session session, Img img, String day,
		OrderByComparator<Img> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMG_WHERE);

		boolean bindDay = false;

		if (day.isEmpty()) {
			query.append(_FINDER_COLUMN_DAY_DAY_3);
		}
		else {
			bindDay = true;

			query.append(_FINDER_COLUMN_DAY_DAY_2);
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
			query.append(ImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDay) {
			qPos.add(day);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(img)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Img> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the imgs where day = &#63; from the database.
	 *
	 * @param day the day
	 */
	@Override
	public void removeByday(String day) {
		for (Img img :
				findByday(day, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(img);
		}
	}

	/**
	 * Returns the number of imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the number of matching imgs
	 */
	@Override
	public int countByday(String day) {
		day = Objects.toString(day, "");

		FinderPath finderPath = _finderPathCountByday;

		Object[] finderArgs = new Object[] {day};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				query.append(_FINDER_COLUMN_DAY_DAY_3);
			}
			else {
				bindDay = true;

				query.append(_FINDER_COLUMN_DAY_DAY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDay) {
					qPos.add(day);
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

	private static final String _FINDER_COLUMN_DAY_DAY_2 = "img.day = ?";

	private static final String _FINDER_COLUMN_DAY_DAY_3 =
		"(img.day IS NULL OR img.day = '')";

	private FinderPath _finderPathWithPaginationFindByDay_Province;
	private FinderPath _finderPathWithoutPaginationFindByDay_Province;
	private FinderPath _finderPathCountByDay_Province;

	/**
	 * Returns all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(String day, String provincia) {
		return findByDay_Province(
			day, provincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(
		String day, String provincia, int start, int end) {

		return findByDay_Province(day, provincia, start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return findByDay_Province(
			day, provincia, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean retrieveFromCache) {

		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDay_Province;
			finderArgs = new Object[] {day, provincia};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDay_Province;
			finderArgs = new Object[] {
				day, provincia, start, end, orderByComparator
			};
		}

		List<Img> list = null;

		if (retrieveFromCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Img img : list) {
					if (!day.equals(img.getDay()) ||
						!provincia.equals(img.getProvincia())) {

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

			query.append(_SQL_SELECT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				query.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				query.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ImgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDay) {
					qPos.add(day);
				}

				if (bindProvincia) {
					qPos.add(provincia);
				}

				if (!pagination) {
					list = (List<Img>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Img>)QueryUtil.list(
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
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByDay_Province_First(
			String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByDay_Province_First(day, provincia, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("day=");
		msg.append(day);

		msg.append(", provincia=");
		msg.append(provincia);

		msg.append("}");

		throw new NoSuchImgException(msg.toString());
	}

	/**
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByDay_Province_First(
		String day, String provincia,
		OrderByComparator<Img> orderByComparator) {

		List<Img> list = findByDay_Province(
			day, provincia, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByDay_Province_Last(
			String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByDay_Province_Last(day, provincia, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("day=");
		msg.append(day);

		msg.append(", provincia=");
		msg.append(provincia);

		msg.append("}");

		throw new NoSuchImgException(msg.toString());
	}

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByDay_Province_Last(
		String day, String provincia,
		OrderByComparator<Img> orderByComparator) {

		int count = countByDay_Province(day, provincia);

		if (count == 0) {
			return null;
		}

		List<Img> list = findByDay_Province(
			day, provincia, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img[] findByDay_Province_PrevAndNext(
			long id, String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		Img img = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Img[] array = new ImgImpl[3];

			array[0] = getByDay_Province_PrevAndNext(
				session, img, day, provincia, orderByComparator, true);

			array[1] = img;

			array[2] = getByDay_Province_PrevAndNext(
				session, img, day, provincia, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Img getByDay_Province_PrevAndNext(
		Session session, Img img, String day, String provincia,
		OrderByComparator<Img> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_IMG_WHERE);

		boolean bindDay = false;

		if (day.isEmpty()) {
			query.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_3);
		}
		else {
			bindDay = true;

			query.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_2);
		}

		boolean bindProvincia = false;

		if (provincia.isEmpty()) {
			query.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3);
		}
		else {
			bindProvincia = true;

			query.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2);
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
			query.append(ImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDay) {
			qPos.add(day);
		}

		if (bindProvincia) {
			qPos.add(provincia);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(img)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Img> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the imgs where day = &#63; and provincia = &#63; from the database.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 */
	@Override
	public void removeByDay_Province(String day, String provincia) {
		for (Img img :
				findByDay_Province(
					day, provincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(img);
		}
	}

	/**
	 * Returns the number of imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	@Override
	public int countByDay_Province(String day, String provincia) {
		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		FinderPath finderPath = _finderPathCountByDay_Province;

		Object[] finderArgs = new Object[] {day, provincia};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				query.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				query.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDay) {
					qPos.add(day);
				}

				if (bindProvincia) {
					qPos.add(provincia);
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

	private static final String _FINDER_COLUMN_DAY_PROVINCE_DAY_2 =
		"img.day = ? AND ";

	private static final String _FINDER_COLUMN_DAY_PROVINCE_DAY_3 =
		"(img.day IS NULL OR img.day = '') AND ";

	private static final String _FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2 =
		"img.provincia = ?";

	private static final String _FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3 =
		"(img.provincia IS NULL OR img.provincia = '')";

	private FinderPath _finderPathFetchByPart_Day_Province;
	private FinderPath _finderPathCountByPart_Day_Province;

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByPart_Day_Province(
			String daypart, String day, String provincia)
		throws NoSuchImgException {

		Img img = fetchByPart_Day_Province(daypart, day, provincia);

		if (img == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daypart=");
			msg.append(daypart);

			msg.append(", day=");
			msg.append(day);

			msg.append(", provincia=");
			msg.append(provincia);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchImgException(msg.toString());
		}

		return img;
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByPart_Day_Province(
		String daypart, String day, String provincia) {

		return fetchByPart_Day_Province(daypart, day, provincia, true);
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByPart_Day_Province(
		String daypart, String day, String provincia,
		boolean retrieveFromCache) {

		daypart = Objects.toString(daypart, "");
		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		Object[] finderArgs = new Object[] {daypart, day, provincia};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByPart_Day_Province, finderArgs, this);
		}

		if (result instanceof Img) {
			Img img = (Img)result;

			if (!Objects.equals(daypart, img.getDaypart()) ||
				!Objects.equals(day, img.getDay()) ||
				!Objects.equals(provincia, img.getProvincia())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_IMG_WHERE);

			boolean bindDaypart = false;

			if (daypart.isEmpty()) {
				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_3);
			}
			else {
				bindDaypart = true;

				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_2);
			}

			boolean bindDay = false;

			if (day.isEmpty()) {
				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDaypart) {
					qPos.add(daypart);
				}

				if (bindDay) {
					qPos.add(day);
				}

				if (bindProvincia) {
					qPos.add(provincia);
				}

				List<Img> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByPart_Day_Province, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ImgPersistenceImpl.fetchByPart_Day_Province(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Img img = list.get(0);

					result = img;

					cacheResult(img);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByPart_Day_Province, finderArgs);

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
			return (Img)result;
		}
	}

	/**
	 * Removes the img where daypart = &#63; and day = &#63; and provincia = &#63; from the database.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the img that was removed
	 */
	@Override
	public Img removeByPart_Day_Province(
			String daypart, String day, String provincia)
		throws NoSuchImgException {

		Img img = findByPart_Day_Province(daypart, day, provincia);

		return remove(img);
	}

	/**
	 * Returns the number of imgs where daypart = &#63; and day = &#63; and provincia = &#63;.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	@Override
	public int countByPart_Day_Province(
		String daypart, String day, String provincia) {

		daypart = Objects.toString(daypart, "");
		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		FinderPath finderPath = _finderPathCountByPart_Day_Province;

		Object[] finderArgs = new Object[] {daypart, day, provincia};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IMG_WHERE);

			boolean bindDaypart = false;

			if (daypart.isEmpty()) {
				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_3);
			}
			else {
				bindDaypart = true;

				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_2);
			}

			boolean bindDay = false;

			if (day.isEmpty()) {
				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				query.append(_FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDaypart) {
					qPos.add(daypart);
				}

				if (bindDay) {
					qPos.add(day);
				}

				if (bindProvincia) {
					qPos.add(provincia);
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

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_2 =
		"img.daypart = ? AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_3 =
		"(img.daypart IS NULL OR img.daypart = '') AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAY_2 =
		"img.day = ? AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAY_3 =
		"(img.day IS NULL OR img.day = '') AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_2 =
		"img.provincia = ?";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_3 =
		"(img.provincia IS NULL OR img.provincia = '')";

	public ImgPersistenceImpl() {
		setModelClass(Img.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("data", "data_");

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
	 * Caches the img in the entity cache if it is enabled.
	 *
	 * @param img the img
	 */
	@Override
	public void cacheResult(Img img) {
		entityCache.putResult(
			ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
			img.getPrimaryKey(), img);

		finderCache.putResult(
			_finderPathFetchByPart_Day_Province,
			new Object[] {img.getDaypart(), img.getDay(), img.getProvincia()},
			img);

		img.resetOriginalValues();
	}

	/**
	 * Caches the imgs in the entity cache if it is enabled.
	 *
	 * @param imgs the imgs
	 */
	@Override
	public void cacheResult(List<Img> imgs) {
		for (Img img : imgs) {
			if (entityCache.getResult(
					ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
					img.getPrimaryKey()) == null) {

				cacheResult(img);
			}
			else {
				img.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all imgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImgImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the img.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Img img) {
		entityCache.removeResult(
			ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
			img.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImgModelImpl)img, true);
	}

	@Override
	public void clearCache(List<Img> imgs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Img img : imgs) {
			entityCache.removeResult(
				ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
				img.getPrimaryKey());

			clearUniqueFindersCache((ImgModelImpl)img, true);
		}
	}

	protected void cacheUniqueFindersCache(ImgModelImpl imgModelImpl) {
		Object[] args = new Object[] {
			imgModelImpl.getDaypart(), imgModelImpl.getDay(),
			imgModelImpl.getProvincia()
		};

		finderCache.putResult(
			_finderPathCountByPart_Day_Province, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByPart_Day_Province, args, imgModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImgModelImpl imgModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				imgModelImpl.getDaypart(), imgModelImpl.getDay(),
				imgModelImpl.getProvincia()
			};

			finderCache.removeResult(_finderPathCountByPart_Day_Province, args);
			finderCache.removeResult(_finderPathFetchByPart_Day_Province, args);
		}

		if ((imgModelImpl.getColumnBitmask() &
			 _finderPathFetchByPart_Day_Province.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				imgModelImpl.getOriginalDaypart(),
				imgModelImpl.getOriginalDay(),
				imgModelImpl.getOriginalProvincia()
			};

			finderCache.removeResult(_finderPathCountByPart_Day_Province, args);
			finderCache.removeResult(_finderPathFetchByPart_Day_Province, args);
		}
	}

	/**
	 * Creates a new img with the primary key. Does not add the img to the database.
	 *
	 * @param id the primary key for the new img
	 * @return the new img
	 */
	@Override
	public Img create(long id) {
		Img img = new ImgImpl();

		img.setNew(true);
		img.setPrimaryKey(id);

		return img;
	}

	/**
	 * Removes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the img
	 * @return the img that was removed
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img remove(long id) throws NoSuchImgException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the img
	 * @return the img that was removed
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img remove(Serializable primaryKey) throws NoSuchImgException {
		Session session = null;

		try {
			session = openSession();

			Img img = (Img)session.get(ImgImpl.class, primaryKey);

			if (img == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(img);
		}
		catch (NoSuchImgException nsee) {
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
	protected Img removeImpl(Img img) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(img)) {
				img = (Img)session.get(ImgImpl.class, img.getPrimaryKeyObj());
			}

			if (img != null) {
				session.delete(img);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (img != null) {
			clearCache(img);
		}

		return img;
	}

	@Override
	public Img updateImpl(Img img) {
		boolean isNew = img.isNew();

		if (!(img instanceof ImgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(img.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(img);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in img proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Img implementation " +
					img.getClass());
		}

		ImgModelImpl imgModelImpl = (ImgModelImpl)img;

		Session session = null;

		try {
			session = openSession();

			if (img.isNew()) {
				session.save(img);

				img.setNew(false);
			}
			else {
				img = (Img)session.merge(img);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImgModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {imgModelImpl.getDay()};

			finderCache.removeResult(_finderPathCountByday, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByday, args);

			args = new Object[] {
				imgModelImpl.getDay(), imgModelImpl.getProvincia()
			};

			finderCache.removeResult(_finderPathCountByDay_Province, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDay_Province, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((imgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByday.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {imgModelImpl.getOriginalDay()};

				finderCache.removeResult(_finderPathCountByday, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByday, args);

				args = new Object[] {imgModelImpl.getDay()};

				finderCache.removeResult(_finderPathCountByday, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByday, args);
			}

			if ((imgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDay_Province.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					imgModelImpl.getOriginalDay(),
					imgModelImpl.getOriginalProvincia()
				};

				finderCache.removeResult(_finderPathCountByDay_Province, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDay_Province, args);

				args = new Object[] {
					imgModelImpl.getDay(), imgModelImpl.getProvincia()
				};

				finderCache.removeResult(_finderPathCountByDay_Province, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDay_Province, args);
			}
		}

		entityCache.putResult(
			ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
			img.getPrimaryKey(), img, false);

		clearUniqueFindersCache(imgModelImpl, false);
		cacheUniqueFindersCache(imgModelImpl);

		img.resetOriginalValues();

		return img;
	}

	/**
	 * Returns the img with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the img
	 * @return the img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImgException {

		Img img = fetchByPrimaryKey(primaryKey);

		if (img == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return img;
	}

	/**
	 * Returns the img with the primary key or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img findByPrimaryKey(long id) throws NoSuchImgException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the img
	 * @return the img, or <code>null</code> if a img with the primary key could not be found
	 */
	@Override
	public Img fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Img img = (Img)serializable;

		if (img == null) {
			Session session = null;

			try {
				session = openSession();

				img = (Img)session.get(ImgImpl.class, primaryKey);

				if (img != null) {
					cacheResult(img);
				}
				else {
					entityCache.putResult(
						ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return img;
	}

	/**
	 * Returns the img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img, or <code>null</code> if a img with the primary key could not be found
	 */
	@Override
	public Img fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Img> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Img> map = new HashMap<Serializable, Img>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Img img = fetchByPrimaryKey(primaryKey);

			if (img != null) {
				map.put(primaryKey, img);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Img)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_IMG_WHERE_PKS_IN);

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

			for (Img img : (List<Img>)q.list()) {
				map.put(img.getPrimaryKeyObj(), img);

				cacheResult(img);

				uncachedPrimaryKeys.remove(img.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ImgModelImpl.ENTITY_CACHE_ENABLED, ImgImpl.class,
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
	 * Returns all the imgs.
	 *
	 * @return the imgs
	 */
	@Override
	public List<Img> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of imgs
	 */
	@Override
	public List<Img> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of imgs
	 */
	@Override
	public List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of imgs
	 */
	@Override
	public List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator,
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

		List<Img> list = null;

		if (retrieveFromCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMG;

				if (pagination) {
					sql = sql.concat(ImgModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Img>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Img>)QueryUtil.list(
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
	 * Removes all the imgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Img img : findAll()) {
			remove(img);
		}
	}

	/**
	 * Returns the number of imgs.
	 *
	 * @return the number of imgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMG);

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
		return ImgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the img persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByday = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByday",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByday = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByday",
			new String[] {String.class.getName()},
			ImgModelImpl.DAY_COLUMN_BITMASK);

		_finderPathCountByday = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByday",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByDay_Province = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDay_Province",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDay_Province = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDay_Province",
			new String[] {String.class.getName(), String.class.getName()},
			ImgModelImpl.DAY_COLUMN_BITMASK |
			ImgModelImpl.PROVINCIA_COLUMN_BITMASK);

		_finderPathCountByDay_Province = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDay_Province",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathFetchByPart_Day_Province = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, ImgImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPart_Day_Province",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ImgModelImpl.DAYPART_COLUMN_BITMASK |
			ImgModelImpl.DAY_COLUMN_BITMASK |
			ImgModelImpl.PROVINCIA_COLUMN_BITMASK);

		_finderPathCountByPart_Day_Province = new FinderPath(
			ImgModelImpl.ENTITY_CACHE_ENABLED,
			ImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPart_Day_Province",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	}

	public void destroy() {
		entityCache.removeCache(ImgImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IMG = "SELECT img FROM Img img";

	private static final String _SQL_SELECT_IMG_WHERE_PKS_IN =
		"SELECT img FROM Img img WHERE id_ IN (";

	private static final String _SQL_SELECT_IMG_WHERE =
		"SELECT img FROM Img img WHERE ";

	private static final String _SQL_COUNT_IMG =
		"SELECT COUNT(img) FROM Img img";

	private static final String _SQL_COUNT_IMG_WHERE =
		"SELECT COUNT(img) FROM Img img WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "img.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Img exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Img exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "data"});

}