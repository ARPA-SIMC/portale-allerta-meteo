/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import it.eng.radarMeteo.exception.NoSuchJsonException;
import it.eng.radarMeteo.model.Json;
import it.eng.radarMeteo.model.JsonTable;
import it.eng.radarMeteo.model.impl.JsonImpl;
import it.eng.radarMeteo.model.impl.JsonModelImpl;
import it.eng.radarMeteo.service.persistence.JsonPersistence;
import it.eng.radarMeteo.service.persistence.JsonUtil;
import it.eng.radarMeteo.service.persistence.impl.constants.rt_portletPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

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
@Component(service = JsonPersistence.class)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching jsons
	 */
	@Override
	public List<Json> findBytype(
		String type, int start, int end,
		OrderByComparator<Json> orderByComparator, boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytype;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytype;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<Json> list = null;

		if (useFinderCache) {
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
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_JSON_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(JsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<Json>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchJsonException(sb.toString());
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

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchJsonException(sb.toString());
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Json getBytype_PrevAndNext(
		Session session, Json json, String type,
		OrderByComparator<Json> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JSON_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(JsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(json)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Json> list = query.list();

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
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JSON_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("data", "data_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Json.class);

		setModelImplClass(JsonImpl.class);
		setModelPKClass(long.class);

		setTable(JsonTable.INSTANCE);
	}

	/**
	 * Caches the json in the entity cache if it is enabled.
	 *
	 * @param json the json
	 */
	@Override
	public void cacheResult(Json json) {
		entityCache.putResult(JsonImpl.class, json.getPrimaryKey(), json);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the jsons in the entity cache if it is enabled.
	 *
	 * @param jsons the jsons
	 */
	@Override
	public void cacheResult(List<Json> jsons) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (jsons.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Json json : jsons) {
			if (entityCache.getResult(JsonImpl.class, json.getPrimaryKey()) ==
					null) {

				cacheResult(json);
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

		finderCache.clearCache(JsonImpl.class);
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
		entityCache.removeResult(JsonImpl.class, json);
	}

	@Override
	public void clearCache(List<Json> jsons) {
		for (Json json : jsons) {
			entityCache.removeResult(JsonImpl.class, json);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(JsonImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JsonImpl.class, primaryKey);
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
		catch (NoSuchJsonException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(json);
			}
			else {
				json = (Json)session.merge(json);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(JsonImpl.class, jsonModelImpl, false, true);

		if (isNew) {
			json.setNew(false);
		}

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
	 * @param id the primary key of the json
	 * @return the json, or <code>null</code> if a json with the primary key could not be found
	 */
	@Override
	public Json fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of jsons
	 */
	@Override
	public List<Json> findAll(
		int start, int end, OrderByComparator<Json> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Json> list = null;

		if (useFinderCache) {
			list = (List<Json>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JSON);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JSON;

				sql = sql.concat(JsonModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Json>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

				Query query = session.createQuery(_SQL_COUNT_JSON);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JSON;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JsonModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the json persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytype",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytype",
			new String[] {String.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytype",
			new String[] {String.class.getName()}, new String[] {"type_"},
			false);

		JsonUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		JsonUtil.setPersistence(null);

		entityCache.removeCache(JsonImpl.class.getName());
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_JSON = "SELECT json FROM Json json";

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

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}