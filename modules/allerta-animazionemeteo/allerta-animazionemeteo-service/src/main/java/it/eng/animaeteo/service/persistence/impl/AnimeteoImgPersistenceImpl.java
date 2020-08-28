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

import it.eng.animaeteo.exception.NoSuchAnimeteoImgException;
import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.model.impl.AnimeteoImgImpl;
import it.eng.animaeteo.model.impl.AnimeteoImgModelImpl;
import it.eng.animaeteo.service.persistence.AnimeteoImgPersistence;

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
 * The persistence implementation for the animeteo img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class AnimeteoImgPersistenceImpl
	extends BasePersistenceImpl<AnimeteoImg> implements AnimeteoImgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimeteoImgUtil</code> to access the animeteo img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimeteoImgImpl.class.getName();

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
	 * Returns all the animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(String type) {
		return findByImageData(
			type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(String type, int start, int end) {
		return findByImageData(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator) {

		return findByImageData(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator,
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

		List<AnimeteoImg> list = null;

		if (retrieveFromCache) {
			list = (List<AnimeteoImg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnimeteoImg animeteoImg : list) {
					if (!type.equals(animeteoImg.getType())) {
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

			query.append(_SQL_SELECT_ANIMETEOIMG_WHERE);

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
				query.append(AnimeteoImgModelImpl.ORDER_BY_JPQL);
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
					list = (List<AnimeteoImg>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnimeteoImg>)QueryUtil.list(
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
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg findByImageData_First(
			String type, OrderByComparator<AnimeteoImg> orderByComparator)
		throws NoSuchAnimeteoImgException {

		AnimeteoImg animeteoImg = fetchByImageData_First(
			type, orderByComparator);

		if (animeteoImg != null) {
			return animeteoImg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchAnimeteoImgException(msg.toString());
	}

	/**
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg fetchByImageData_First(
		String type, OrderByComparator<AnimeteoImg> orderByComparator) {

		List<AnimeteoImg> list = findByImageData(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg findByImageData_Last(
			String type, OrderByComparator<AnimeteoImg> orderByComparator)
		throws NoSuchAnimeteoImgException {

		AnimeteoImg animeteoImg = fetchByImageData_Last(
			type, orderByComparator);

		if (animeteoImg != null) {
			return animeteoImg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchAnimeteoImgException(msg.toString());
	}

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg fetchByImageData_Last(
		String type, OrderByComparator<AnimeteoImg> orderByComparator) {

		int count = countByImageData(type);

		if (count == 0) {
			return null;
		}

		List<AnimeteoImg> list = findByImageData(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animeteo imgs before and after the current animeteo img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg[] findByImageData_PrevAndNext(
			long id, String type,
			OrderByComparator<AnimeteoImg> orderByComparator)
		throws NoSuchAnimeteoImgException {

		type = Objects.toString(type, "");

		AnimeteoImg animeteoImg = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AnimeteoImg[] array = new AnimeteoImgImpl[3];

			array[0] = getByImageData_PrevAndNext(
				session, animeteoImg, type, orderByComparator, true);

			array[1] = animeteoImg;

			array[2] = getByImageData_PrevAndNext(
				session, animeteoImg, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimeteoImg getByImageData_PrevAndNext(
		Session session, AnimeteoImg animeteoImg, String type,
		OrderByComparator<AnimeteoImg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANIMETEOIMG_WHERE);

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
			query.append(AnimeteoImgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(animeteoImg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AnimeteoImg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animeteo imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByImageData(String type) {
		for (AnimeteoImg animeteoImg :
				findByImageData(
					type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animeteoImg);
		}
	}

	/**
	 * Returns the number of animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo imgs
	 */
	@Override
	public int countByImageData(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByImageData;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANIMETEOIMG_WHERE);

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
		"animeteoImg.type = ?";

	private static final String _FINDER_COLUMN_IMAGEDATA_TYPE_3 =
		"(animeteoImg.type IS NULL OR animeteoImg.type = '')";

	public AnimeteoImgPersistenceImpl() {
		setModelClass(AnimeteoImg.class);

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
	 * Caches the animeteo img in the entity cache if it is enabled.
	 *
	 * @param animeteoImg the animeteo img
	 */
	@Override
	public void cacheResult(AnimeteoImg animeteoImg) {
		entityCache.putResult(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED, AnimeteoImgImpl.class,
			animeteoImg.getPrimaryKey(), animeteoImg);

		animeteoImg.resetOriginalValues();
	}

	/**
	 * Caches the animeteo imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoImgs the animeteo imgs
	 */
	@Override
	public void cacheResult(List<AnimeteoImg> animeteoImgs) {
		for (AnimeteoImg animeteoImg : animeteoImgs) {
			if (entityCache.getResult(
					AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
					AnimeteoImgImpl.class, animeteoImg.getPrimaryKey()) ==
						null) {

				cacheResult(animeteoImg);
			}
			else {
				animeteoImg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all animeteo imgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimeteoImgImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the animeteo img.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimeteoImg animeteoImg) {
		entityCache.removeResult(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED, AnimeteoImgImpl.class,
			animeteoImg.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnimeteoImg> animeteoImgs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnimeteoImg animeteoImg : animeteoImgs) {
			entityCache.removeResult(
				AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
				AnimeteoImgImpl.class, animeteoImg.getPrimaryKey());
		}
	}

	/**
	 * Creates a new animeteo img with the primary key. Does not add the animeteo img to the database.
	 *
	 * @param id the primary key for the new animeteo img
	 * @return the new animeteo img
	 */
	@Override
	public AnimeteoImg create(long id) {
		AnimeteoImg animeteoImg = new AnimeteoImgImpl();

		animeteoImg.setNew(true);
		animeteoImg.setPrimaryKey(id);

		return animeteoImg;
	}

	/**
	 * Removes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg remove(long id) throws NoSuchAnimeteoImgException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg remove(Serializable primaryKey)
		throws NoSuchAnimeteoImgException {

		Session session = null;

		try {
			session = openSession();

			AnimeteoImg animeteoImg = (AnimeteoImg)session.get(
				AnimeteoImgImpl.class, primaryKey);

			if (animeteoImg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimeteoImgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animeteoImg);
		}
		catch (NoSuchAnimeteoImgException nsee) {
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
	protected AnimeteoImg removeImpl(AnimeteoImg animeteoImg) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animeteoImg)) {
				animeteoImg = (AnimeteoImg)session.get(
					AnimeteoImgImpl.class, animeteoImg.getPrimaryKeyObj());
			}

			if (animeteoImg != null) {
				session.delete(animeteoImg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (animeteoImg != null) {
			clearCache(animeteoImg);
		}

		return animeteoImg;
	}

	@Override
	public AnimeteoImg updateImpl(AnimeteoImg animeteoImg) {
		boolean isNew = animeteoImg.isNew();

		if (!(animeteoImg instanceof AnimeteoImgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(animeteoImg.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(animeteoImg);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in animeteoImg proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnimeteoImg implementation " +
					animeteoImg.getClass());
		}

		AnimeteoImgModelImpl animeteoImgModelImpl =
			(AnimeteoImgModelImpl)animeteoImg;

		Session session = null;

		try {
			session = openSession();

			if (animeteoImg.isNew()) {
				session.save(animeteoImg);

				animeteoImg.setNew(false);
			}
			else {
				animeteoImg = (AnimeteoImg)session.merge(animeteoImg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AnimeteoImgModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {animeteoImgModelImpl.getType()};

			finderCache.removeResult(_finderPathCountByImageData, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByImageData, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((animeteoImgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByImageData.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					animeteoImgModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByImageData, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByImageData, args);

				args = new Object[] {animeteoImgModelImpl.getType()};

				finderCache.removeResult(_finderPathCountByImageData, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByImageData, args);
			}
		}

		entityCache.putResult(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED, AnimeteoImgImpl.class,
			animeteoImg.getPrimaryKey(), animeteoImg, false);

		animeteoImg.resetOriginalValues();

		return animeteoImg;
	}

	/**
	 * Returns the animeteo img with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimeteoImgException {

		AnimeteoImg animeteoImg = fetchByPrimaryKey(primaryKey);

		if (animeteoImg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimeteoImgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animeteoImg;
	}

	/**
	 * Returns the animeteo img with the primary key or throws a <code>NoSuchAnimeteoImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg findByPrimaryKey(long id)
		throws NoSuchAnimeteoImgException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the animeteo img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animeteo img
	 * @return the animeteo img, or <code>null</code> if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED, AnimeteoImgImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AnimeteoImg animeteoImg = (AnimeteoImg)serializable;

		if (animeteoImg == null) {
			Session session = null;

			try {
				session = openSession();

				animeteoImg = (AnimeteoImg)session.get(
					AnimeteoImgImpl.class, primaryKey);

				if (animeteoImg != null) {
					cacheResult(animeteoImg);
				}
				else {
					entityCache.putResult(
						AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
						AnimeteoImgImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
					AnimeteoImgImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return animeteoImg;
	}

	/**
	 * Returns the animeteo img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img, or <code>null</code> if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, AnimeteoImg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnimeteoImg> map =
			new HashMap<Serializable, AnimeteoImg>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnimeteoImg animeteoImg = fetchByPrimaryKey(primaryKey);

			if (animeteoImg != null) {
				map.put(primaryKey, animeteoImg);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
				AnimeteoImgImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AnimeteoImg)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ANIMETEOIMG_WHERE_PKS_IN);

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

			for (AnimeteoImg animeteoImg : (List<AnimeteoImg>)q.list()) {
				map.put(animeteoImg.getPrimaryKeyObj(), animeteoImg);

				cacheResult(animeteoImg);

				uncachedPrimaryKeys.remove(animeteoImg.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
					AnimeteoImgImpl.class, primaryKey, nullModel);
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
	 * Returns all the animeteo imgs.
	 *
	 * @return the animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll(
		int start, int end, OrderByComparator<AnimeteoImg> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll(
		int start, int end, OrderByComparator<AnimeteoImg> orderByComparator,
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

		List<AnimeteoImg> list = null;

		if (retrieveFromCache) {
			list = (List<AnimeteoImg>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANIMETEOIMG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMETEOIMG;

				if (pagination) {
					sql = sql.concat(AnimeteoImgModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnimeteoImg>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnimeteoImg>)QueryUtil.list(
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
	 * Removes all the animeteo imgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimeteoImg animeteoImg : findAll()) {
			remove(animeteoImg);
		}
	}

	/**
	 * Returns the number of animeteo imgs.
	 *
	 * @return the number of animeteo imgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANIMETEOIMG);

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
		return AnimeteoImgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animeteo img persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoImgModelImpl.FINDER_CACHE_ENABLED, AnimeteoImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoImgModelImpl.FINDER_CACHE_ENABLED, AnimeteoImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByImageData = new FinderPath(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoImgModelImpl.FINDER_CACHE_ENABLED, AnimeteoImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByImageData",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByImageData = new FinderPath(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoImgModelImpl.FINDER_CACHE_ENABLED, AnimeteoImgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByImageData",
			new String[] {String.class.getName()},
			AnimeteoImgModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByImageData = new FinderPath(
			AnimeteoImgModelImpl.ENTITY_CACHE_ENABLED,
			AnimeteoImgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByImageData",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AnimeteoImgImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ANIMETEOIMG =
		"SELECT animeteoImg FROM AnimeteoImg animeteoImg";

	private static final String _SQL_SELECT_ANIMETEOIMG_WHERE_PKS_IN =
		"SELECT animeteoImg FROM AnimeteoImg animeteoImg WHERE id_ IN (";

	private static final String _SQL_SELECT_ANIMETEOIMG_WHERE =
		"SELECT animeteoImg FROM AnimeteoImg animeteoImg WHERE ";

	private static final String _SQL_COUNT_ANIMETEOIMG =
		"SELECT COUNT(animeteoImg) FROM AnimeteoImg animeteoImg";

	private static final String _SQL_COUNT_ANIMETEOIMG_WHERE =
		"SELECT COUNT(animeteoImg) FROM AnimeteoImg animeteoImg WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animeteoImg.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimeteoImg exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnimeteoImg exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimeteoImgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type", "data"});

}