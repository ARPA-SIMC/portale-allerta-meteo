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

package it.eng.radarMeteo.service.persistence.impl;

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

import it.eng.radarMeteo.exception.NoSuchJsonException;
import it.eng.radarMeteo.model.Json;
import it.eng.radarMeteo.model.impl.JsonImpl;
import it.eng.radarMeteo.model.impl.JsonModelImpl;
import it.eng.radarMeteo.service.persistence.JsonPersistence;

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
 * The persistence implementation for the json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class JsonPersistenceImpl
	extends BasePersistenceImpl<Json> implements JsonPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JsonUtil</code> to access the json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JsonImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBytype;
	private FinderPath _finderPathWithoutPaginationFindBytype;
	private FinderPath _finderPathCountBytype;

	/**
	 * Returns all the jsons where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching jsons
	 */
	@Override
	public List<Json> findBytype(String type) {
		return findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @return the range of matching jsons
	 */
	@Override
	public List<Json> findBytype(String type, int start, int end) {
		return findBytype(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jsons
	 */
	@Override
	public List<Json> findBytype(
		String type, int start, int end,
		OrderByComparator<Json> orderByComparator) {

		return findBytype(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jsons
	 */
	@Override
	public List<Json> findBytype(
		String type, int start, int end,
		OrderByComparator<Json> orderByComparator, boolean retrieveFromCache) {

		type = Objects.toString(type, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBytype;
			finderArgs = new Object[] {type};
		}
		else {
			finderPath = _finderPathWithPaginationFindBytype;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<Json> list = null;

		if (retrieveFromCache) {
			list = (List<Json>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Json json : list) {
					if (!type.equals(json.getType())) {
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

			query.append(_SQL_SELECT_JSON_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JsonModelImpl.ORDER_BY_JPQL);
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
					list = (List<Json>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Json>)QueryUtil.list(
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
	 * Returns the first json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching json
	 * @throws NoSuchJsonException if a matching json could not be found
	 */
	@Override
	public Json findBytype_First(
			String type, OrderByComparator<Json> orderByComparator)
		throws NoSuchJsonException {

		Json json = fetchBytype_First(type, orderByComparator);

		if (json != null) {
			return json;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchJsonException(msg.toString());
	}

	/**
	 * Returns the first json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching json, or <code>null</code> if a matching json could not be found
	 */
	@Override
	public Json fetchBytype_First(
		String type, OrderByComparator<Json> orderByComparator) {

		List<Json> list = findBytype(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching json
	 * @throws NoSuchJsonException if a matching json could not be found
	 */
	@Override
	public Json findBytype_Last(
			String type, OrderByComparator<Json> orderByComparator)
		throws NoSuchJsonException {

		Json json = fetchBytype_Last(type, orderByComparator);

		if (json != null) {
			return json;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchJsonException(msg.toString());
	}

	/**
	 * Returns the last json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching json, or <code>null</code> if a matching json could not be found
	 */
	@Override
	public Json fetchBytype_Last(
		String type, OrderByComparator<Json> orderByComparator) {

		int count = countBytype(type);

		if (count == 0) {
			return null;
		}

		List<Json> list = findBytype(type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the jsons before and after the current json in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current json
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next json
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	@Override
	public Json[] findBytype_PrevAndNext(
			long id, String type, OrderByComparator<Json> orderByComparator)
		throws NoSuchJsonException {

		type = Objects.toString(type, "");

		Json json = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Json[] array = new JsonImpl[3];

			array[0] = getBytype_PrevAndNext(
				session, json, type, orderByComparator, true);

			array[1] = json;

			array[2] = getBytype_PrevAndNext(
				session, json, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Json getBytype_PrevAndNext(
		Session session, Json json, String type,
		OrderByComparator<Json> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JSON_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);
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
			query.append(JsonModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(json)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Json> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jsons where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeBytype(String type) {
		for (Json json :
				findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(json);
		}
	}

	/**
	 * Returns the number of jsons where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching jsons
	 */
	@Override
	public int countBytype(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountBytype;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JSON_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "json.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(json.type IS NULL OR json.type = '')";

	public JsonPersistenceImpl() {
		setModelClass(Json.class);

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
	 * Caches the json in the entity cache if it is enabled.
	 *
	 * @param json the json
	 */
	@Override
	public void cacheResult(Json json) {
		entityCache.putResult(
			JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
			json.getPrimaryKey(), json);

		json.resetOriginalValues();
	}

	/**
	 * Caches the jsons in the entity cache if it is enabled.
	 *
	 * @param jsons the jsons
	 */
	@Override
	public void cacheResult(List<Json> jsons) {
		for (Json json : jsons) {
			if (entityCache.getResult(
					JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
					json.getPrimaryKey()) == null) {

				cacheResult(json);
			}
			else {
				json.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jsons.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JsonImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the json.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Json json) {
		entityCache.removeResult(
			JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
			json.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Json> jsons) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Json json : jsons) {
			entityCache.removeResult(
				JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
				json.getPrimaryKey());
		}
	}

	/**
	 * Creates a new json with the primary key. Does not add the json to the database.
	 *
	 * @param id the primary key for the new json
	 * @return the new json
	 */
	@Override
	public Json create(long id) {
		Json json = new JsonImpl();

		json.setNew(true);
		json.setPrimaryKey(id);

		return json;
	}

	/**
	 * Removes the json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the json
	 * @return the json that was removed
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	@Override
	public Json remove(long id) throws NoSuchJsonException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the json
	 * @return the json that was removed
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	@Override
	public Json remove(Serializable primaryKey) throws NoSuchJsonException {
		Session session = null;

		try {
			session = openSession();

			Json json = (Json)session.get(JsonImpl.class, primaryKey);

			if (json == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJsonException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(json);
		}
		catch (NoSuchJsonException nsee) {
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
	protected Json removeImpl(Json json) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(json)) {
				json = (Json)session.get(
					JsonImpl.class, json.getPrimaryKeyObj());
			}

			if (json != null) {
				session.delete(json);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (json != null) {
			clearCache(json);
		}

		return json;
	}

	@Override
	public Json updateImpl(Json json) {
		boolean isNew = json.isNew();

		if (!(json instanceof JsonModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(json.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(json);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in json proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Json implementation " +
					json.getClass());
		}

		JsonModelImpl jsonModelImpl = (JsonModelImpl)json;

		Session session = null;

		try {
			session = openSession();

			if (json.isNew()) {
				session.save(json);

				json.setNew(false);
			}
			else {
				json = (Json)session.merge(json);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!JsonModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {jsonModelImpl.getType()};

			finderCache.removeResult(_finderPathCountBytype, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBytype, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((jsonModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBytype.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {jsonModelImpl.getOriginalType()};

				finderCache.removeResult(_finderPathCountBytype, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBytype, args);

				args = new Object[] {jsonModelImpl.getType()};

				finderCache.removeResult(_finderPathCountBytype, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBytype, args);
			}
		}

		entityCache.putResult(
			JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
			json.getPrimaryKey(), json, false);

		json.resetOriginalValues();

		return json;
	}

	/**
	 * Returns the json with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the json
	 * @return the json
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	@Override
	public Json findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJsonException {

		Json json = fetchByPrimaryKey(primaryKey);

		if (json == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJsonException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return json;
	}

	/**
	 * Returns the json with the primary key or throws a <code>NoSuchJsonException</code> if it could not be found.
	 *
	 * @param id the primary key of the json
	 * @return the json
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	@Override
	public Json findByPrimaryKey(long id) throws NoSuchJsonException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the json
	 * @return the json, or <code>null</code> if a json with the primary key could not be found
	 */
	@Override
	public Json fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Json json = (Json)serializable;

		if (json == null) {
			Session session = null;

			try {
				session = openSession();

				json = (Json)session.get(JsonImpl.class, primaryKey);

				if (json != null) {
					cacheResult(json);
				}
				else {
					entityCache.putResult(
						JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return json;
	}

	/**
	 * Returns the json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the json
	 * @return the json, or <code>null</code> if a json with the primary key could not be found
	 */
	@Override
	public Json fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Json> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Json> map = new HashMap<Serializable, Json>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Json json = fetchByPrimaryKey(primaryKey);

			if (json != null) {
				map.put(primaryKey, json);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Json)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_JSON_WHERE_PKS_IN);

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

			for (Json json : (List<Json>)q.list()) {
				map.put(json.getPrimaryKeyObj(), json);

				cacheResult(json);

				uncachedPrimaryKeys.remove(json.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					JsonModelImpl.ENTITY_CACHE_ENABLED, JsonImpl.class,
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
	 * Returns all the jsons.
	 *
	 * @return the jsons
	 */
	@Override
	public List<Json> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @return the range of jsons
	 */
	@Override
	public List<Json> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jsons
	 */
	@Override
	public List<Json> findAll(
		int start, int end, OrderByComparator<Json> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of jsons
	 */
	@Override
	public List<Json> findAll(
		int start, int end, OrderByComparator<Json> orderByComparator,
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

		List<Json> list = null;

		if (retrieveFromCache) {
			list = (List<Json>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JSON);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JSON;

				if (pagination) {
					sql = sql.concat(JsonModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Json>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Json>)QueryUtil.list(
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
	 * Removes all the jsons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Json json : findAll()) {
			remove(json);
		}
	}

	/**
	 * Returns the number of jsons.
	 *
	 * @return the number of jsons
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JSON);

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
		return JsonModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the json persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			JsonModelImpl.ENTITY_CACHE_ENABLED,
			JsonModelImpl.FINDER_CACHE_ENABLED, JsonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			JsonModelImpl.ENTITY_CACHE_ENABLED,
			JsonModelImpl.FINDER_CACHE_ENABLED, JsonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			JsonModelImpl.ENTITY_CACHE_ENABLED,
			JsonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBytype = new FinderPath(
			JsonModelImpl.ENTITY_CACHE_ENABLED,
			JsonModelImpl.FINDER_CACHE_ENABLED, JsonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytype",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBytype = new FinderPath(
			JsonModelImpl.ENTITY_CACHE_ENABLED,
			JsonModelImpl.FINDER_CACHE_ENABLED, JsonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytype",
			new String[] {String.class.getName()},
			JsonModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountBytype = new FinderPath(
			JsonModelImpl.ENTITY_CACHE_ENABLED,
			JsonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytype",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(JsonImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_JSON = "SELECT json FROM Json json";

	private static final String _SQL_SELECT_JSON_WHERE_PKS_IN =
		"SELECT json FROM Json json WHERE id_ IN (";

	private static final String _SQL_SELECT_JSON_WHERE =
		"SELECT json FROM Json json WHERE ";

	private static final String _SQL_COUNT_JSON =
		"SELECT COUNT(json) FROM Json json";

	private static final String _SQL_COUNT_JSON_WHERE =
		"SELECT COUNT(json) FROM Json json WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "json.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Json exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Json exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JsonPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type", "data"});

}