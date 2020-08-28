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

package it.eng.animaeteo.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.animaeteo.exception.NoSuchAnimeteoSmallImgException;
import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl;
import it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgPersistence;

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
 * The persistence implementation for the animeteo small img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class AnimeteoSmallImgPersistenceImpl
	extends BasePersistenceImpl<AnimeteoSmallImg>
	implements AnimeteoSmallImgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimeteoSmallImgUtil</code> to access the animeteo small img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimeteoSmallImgImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByImageData;
	private FinderPath _finderPathWithoutPaginationFindByImageData;
	private FinderPath _finderPathCountByImageData;

	/**
	 * Returns all the animeteo small imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(String type) {
		return findByImageData(
			type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end) {

		return findByImageData(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		return findByImageData(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator,
		boolean retrieveFromCache) {

		type = Objects.toString(type, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByImageData;
			finderArgs = new Object[] {type};
		}
		else {
			finderPath = _finderPathWithPaginationFindByImageData;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<AnimeteoSmallImg> list = null;

		if (retrieveFromCache) {
			list = (List<AnimeteoSmallImg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnimeteoSmallImg animeteoSmallImg : list) {
					if (!type.equals(animeteoSmallImg.getType())) {
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

			query.append(_SQL_SELECT_ANIMETEOSMALLIMG_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_IMAGEDATA_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_IMAGEDATA_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AnimeteoSmallImgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<AnimeteoSmallImg>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnimeteoSmallImg>)QueryUtil.list(
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
	 * Returns the first animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg findByImageData_First(
			String type, OrderByComparator<AnimeteoSmallImg> orderByComparator)
		throws NoSuchAnimeteoSmallImgException {

		AnimeteoSmallImg animeteoSmallImg = fetchByImageData_First(
			type, orderByComparator);

		if (animeteoSmallImg != null) {
			return animeteoSmallImg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchAnimeteoSmallImgException(msg.toString());
	}

	/**
	 * Returns the first animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo small img, or <code>null</code> if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByImageData_First(
		String type, OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		List<AnimeteoSmallImg> list = findByImageData(
			type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg findByImageData_Last(
			String type, OrderByComparator<AnimeteoSmallImg> orderByComparator)
		throws NoSuchAnimeteoSmallImgException {

		AnimeteoSmallImg animeteoSmallImg = fetchByImageData_Last(
			type, orderByComparator);

		if (animeteoSmallImg != null) {
			return animeteoSmallImg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchAnimeteoSmallImgException(msg.toString());
	}

	/**
	 * Returns the last animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo small img, or <code>null</code> if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByImageData_Last(
		String type, OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		int count = countByImageData(type);

		if (count == 0) {
			return null;
		}

		List<AnimeteoSmallImg> list = findByImageData(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animeteo small imgs before and after the current animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo small img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg[] findByImageData_PrevAndNext(
			long id, String type,
			OrderByComparator<AnimeteoSmallImg> orderByComparator)
		throws NoSuchAnimeteoSmallImgException {

		type = Objects.toString(type, "");

		AnimeteoSmallImg animeteoSmallImg = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AnimeteoSmallImg[] array = new AnimeteoSmallImgImpl[3];

			array[0] = getByImageData_PrevAndNext(
				session, animeteoSmallImg, type, orderByComparator, true);

			array[1] = animeteoSmallImg;

			array[2] = getByImageData_PrevAndNext(
				session, animeteoSmallImg, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimeteoSmallImg getByImageData_PrevAndNext(
		Session session, AnimeteoSmallImg animeteoSmallImg, String type,
		OrderByComparator<AnimeteoSmallImg> orderByComparator,
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

		query.append(_SQL_SELECT_ANIMETEOSMALLIMG_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			query.append(_FINDER_COLUMN_IMAGEDATA_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_IMAGEDATA_TYPE_2);
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
			query.append(AnimeteoSmallImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						animeteoSmallImg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AnimeteoSmallImg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animeteo small imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByImageData(String type) {
		for (AnimeteoSmallImg animeteoSmallImg :
				findByImageData(
					type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animeteoSmallImg);
		}
	}

	/**
	 * Returns the number of animeteo small imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo small imgs
	 */
	@Override
	public int countByImageData(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByImageData;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANIMETEOSMALLIMG_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_IMAGEDATA_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_IMAGEDATA_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_IMAGEDATA_TYPE_2 =
		"animeteoSmallImg.type = ?";

	private static final String _FINDER_COLUMN_IMAGEDATA_TYPE_3 =
		"(animeteoSmallImg.type IS NULL OR animeteoSmallImg.type = '')";

	public AnimeteoSmallImgPersistenceImpl() {
		setModelClass(AnimeteoSmallImg.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");
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
	 * Caches the animeteo small img in the entity cache if it is enabled.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 */
	@Override
	public void cacheResult(AnimeteoSmallImg animeteoSmallImg) {
		entityCache.putResult(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class, animeteoSmallImg.getPrimaryKey(),
			animeteoSmallImg);

		animeteoSmallImg.resetOriginalValues();
	}

	/**
	 * Caches the animeteo small imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoSmallImgs the animeteo small imgs
	 */
	@Override
	public void cacheResult(List<AnimeteoSmallImg> animeteoSmallImgs) {
		for (AnimeteoSmallImg animeteoSmallImg : animeteoSmallImgs) {
			if (entityCache.getResult(
					AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
					AnimeteoSmallImgImpl.class,
					animeteoSmallImg.getPrimaryKey()) == null) {

				cacheResult(animeteoSmallImg);
			}
			else {
				animeteoSmallImg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all animeteo small imgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimeteoSmallImgImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the animeteo small img.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimeteoSmallImg animeteoSmallImg) {
		entityCache.removeResult(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class, animeteoSmallImg.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnimeteoSmallImg> animeteoSmallImgs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnimeteoSmallImg animeteoSmallImg : animeteoSmallImgs) {
			entityCache.removeResult(
				AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
				AnimeteoSmallImgImpl.class, animeteoSmallImg.getPrimaryKey());
		}
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	@Override
	public AnimeteoSmallImg create(long id) {
		AnimeteoSmallImg animeteoSmallImg = new AnimeteoSmallImgImpl();

		animeteoSmallImg.setNew(true);
		animeteoSmallImg.setPrimaryKey(id);

		return animeteoSmallImg;
	}

	/**
	 * Removes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg remove(long id)
		throws NoSuchAnimeteoSmallImgException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg remove(Serializable primaryKey)
		throws NoSuchAnimeteoSmallImgException {

		Session session = null;

		try {
			session = openSession();

			AnimeteoSmallImg animeteoSmallImg = (AnimeteoSmallImg)session.get(
				AnimeteoSmallImgImpl.class, primaryKey);

			if (animeteoSmallImg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimeteoSmallImgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animeteoSmallImg);
		}
		catch (NoSuchAnimeteoSmallImgException nsee) {
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
	protected AnimeteoSmallImg removeImpl(AnimeteoSmallImg animeteoSmallImg) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animeteoSmallImg)) {
				animeteoSmallImg = (AnimeteoSmallImg)session.get(
					AnimeteoSmallImgImpl.class,
					animeteoSmallImg.getPrimaryKeyObj());
			}

			if (animeteoSmallImg != null) {
				session.delete(animeteoSmallImg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (animeteoSmallImg != null) {
			clearCache(animeteoSmallImg);
		}

		return animeteoSmallImg;
	}

	@Override
	public AnimeteoSmallImg updateImpl(AnimeteoSmallImg animeteoSmallImg) {
		boolean isNew = animeteoSmallImg.isNew();

		if (!(animeteoSmallImg instanceof AnimeteoSmallImgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(animeteoSmallImg.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					animeteoSmallImg);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in animeteoSmallImg proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnimeteoSmallImg implementation " +
					animeteoSmallImg.getClass());
		}

		AnimeteoSmallImgModelImpl animeteoSmallImgModelImpl =
			(AnimeteoSmallImgModelImpl)animeteoSmallImg;

		Session session = null;

		try {
			session = openSession();

			if (animeteoSmallImg.isNew()) {
				session.save(animeteoSmallImg);

				animeteoSmallImg.setNew(false);
			}
			else {
				animeteoSmallImg = (AnimeteoSmallImg)session.merge(
					animeteoSmallImg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AnimeteoSmallImgModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {animeteoSmallImgModelImpl.getType()};

			finderCache.removeResult(_finderPathCountByImageData, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByImageData, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((animeteoSmallImgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByImageData.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					animeteoSmallImgModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByImageData, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByImageData, args);

				args = new Object[] {animeteoSmallImgModelImpl.getType()};

				finderCache.removeResult(_finderPathCountByImageData, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByImageData, args);
			}
		}

		entityCache.putResult(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class, animeteoSmallImg.getPrimaryKey(),
			animeteoSmallImg, false);

		animeteoSmallImg.resetOriginalValues();

		return animeteoSmallImg;
	}

	/**
	 * Returns the animeteo small img with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimeteoSmallImgException {

		AnimeteoSmallImg animeteoSmallImg = fetchByPrimaryKey(primaryKey);

		if (animeteoSmallImg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimeteoSmallImgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animeteoSmallImg;
	}

	/**
	 * Returns the animeteo small img with the primary key or throws a <code>NoSuchAnimeteoSmallImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg findByPrimaryKey(long id)
		throws NoSuchAnimeteoSmallImgException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the animeteo small img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animeteo small img
	 * @return the animeteo small img, or <code>null</code> if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AnimeteoSmallImg animeteoSmallImg = (AnimeteoSmallImg)serializable;

		if (animeteoSmallImg == null) {
			Session session = null;

			try {
				session = openSession();

				animeteoSmallImg = (AnimeteoSmallImg)session.get(
					AnimeteoSmallImgImpl.class, primaryKey);

				if (animeteoSmallImg != null) {
					cacheResult(animeteoSmallImg);
				}
				else {
					entityCache.putResult(
						AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
						AnimeteoSmallImgImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
					AnimeteoSmallImgImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return animeteoSmallImg;
	}

	/**
	 * Returns the animeteo small img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img, or <code>null</code> if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, AnimeteoSmallImg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnimeteoSmallImg> map =
			new HashMap<Serializable, AnimeteoSmallImg>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnimeteoSmallImg animeteoSmallImg = fetchByPrimaryKey(primaryKey);

			if (animeteoSmallImg != null) {
				map.put(primaryKey, animeteoSmallImg);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
				AnimeteoSmallImgImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AnimeteoSmallImg)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ANIMETEOSMALLIMG_WHERE_PKS_IN);

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

			for (AnimeteoSmallImg animeteoSmallImg :
					(List<AnimeteoSmallImg>)q.list()) {

				map.put(animeteoSmallImg.getPrimaryKeyObj(), animeteoSmallImg);

				cacheResult(animeteoSmallImg);

				uncachedPrimaryKeys.remove(animeteoSmallImg.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
					AnimeteoSmallImgImpl.class, primaryKey, nullModel);
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
	 * Returns all the animeteo small imgs.
	 *
	 * @return the animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll(
		int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll(
		int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator,
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

		List<AnimeteoSmallImg> list = null;

		if (retrieveFromCache) {
			list = (List<AnimeteoSmallImg>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANIMETEOSMALLIMG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMETEOSMALLIMG;

				if (pagination) {
					sql = sql.concat(AnimeteoSmallImgModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnimeteoSmallImg>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnimeteoSmallImg>)QueryUtil.list(
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
	 * Removes all the animeteo small imgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimeteoSmallImg animeteoSmallImg : findAll()) {
			remove(animeteoSmallImg);
		}
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANIMETEOSMALLIMG);

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
		return AnimeteoSmallImgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animeteo small img persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgModelImpl.FINDER_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgModelImpl.FINDER_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByImageData = new FinderPath(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgModelImpl.FINDER_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByImageData",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByImageData = new FinderPath(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgModelImpl.FINDER_CACHE_ENABLED,
			AnimeteoSmallImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByImageData",
			new String[] {String.class.getName()},
			AnimeteoSmallImgModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByImageData = new FinderPath(
			AnimeteoSmallImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoSmallImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByImageData",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AnimeteoSmallImgImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ANIMETEOSMALLIMG =
		"SELECT animeteoSmallImg FROM AnimeteoSmallImg animeteoSmallImg";

	private static final String _SQL_SELECT_ANIMETEOSMALLIMG_WHERE_PKS_IN =
		"SELECT animeteoSmallImg FROM AnimeteoSmallImg animeteoSmallImg WHERE id_ IN (";

	private static final String _SQL_SELECT_ANIMETEOSMALLIMG_WHERE =
		"SELECT animeteoSmallImg FROM AnimeteoSmallImg animeteoSmallImg WHERE ";

	private static final String _SQL_COUNT_ANIMETEOSMALLIMG =
		"SELECT COUNT(animeteoSmallImg) FROM AnimeteoSmallImg animeteoSmallImg";

	private static final String _SQL_COUNT_ANIMETEOSMALLIMG_WHERE =
		"SELECT COUNT(animeteoSmallImg) FROM AnimeteoSmallImg animeteoSmallImg WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animeteoSmallImg.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimeteoSmallImg exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnimeteoSmallImg exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimeteoSmallImgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type", "data"});

}