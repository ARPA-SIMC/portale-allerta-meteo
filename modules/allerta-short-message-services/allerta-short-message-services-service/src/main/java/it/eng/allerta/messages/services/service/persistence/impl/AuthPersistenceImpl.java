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

package it.eng.allerta.messages.services.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerta.messages.services.exception.NoSuchAuthException;
import it.eng.allerta.messages.services.model.Auth;
import it.eng.allerta.messages.services.model.impl.AuthImpl;
import it.eng.allerta.messages.services.model.impl.AuthModelImpl;
import it.eng.allerta.messages.services.service.persistence.AuthPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the auth service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class AuthPersistenceImpl
	extends BasePersistenceImpl<Auth> implements AuthPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuthUtil</code> to access the auth persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuthImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AuthPersistenceImpl() {
		setModelClass(Auth.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

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
	 * Caches the auth in the entity cache if it is enabled.
	 *
	 * @param auth the auth
	 */
	@Override
	public void cacheResult(Auth auth) {
		entityCache.putResult(
			AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
			auth.getPrimaryKey(), auth);

		auth.resetOriginalValues();
	}

	/**
	 * Caches the auths in the entity cache if it is enabled.
	 *
	 * @param auths the auths
	 */
	@Override
	public void cacheResult(List<Auth> auths) {
		for (Auth auth : auths) {
			if (entityCache.getResult(
					AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
					auth.getPrimaryKey()) == null) {

				cacheResult(auth);
			}
			else {
				auth.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auths.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuthImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auth.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Auth auth) {
		entityCache.removeResult(
			AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
			auth.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Auth> auths) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Auth auth : auths) {
			entityCache.removeResult(
				AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
				auth.getPrimaryKey());
		}
	}

	/**
	 * Creates a new auth with the primary key. Does not add the auth to the database.
	 *
	 * @param key the primary key for the new auth
	 * @return the new auth
	 */
	@Override
	public Auth create(String key) {
		Auth auth = new AuthImpl();

		auth.setNew(true);
		auth.setPrimaryKey(key);

		return auth;
	}

	/**
	 * Removes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the auth
	 * @return the auth that was removed
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth remove(String key) throws NoSuchAuthException {
		return remove((Serializable)key);
	}

	/**
	 * Removes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auth
	 * @return the auth that was removed
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth remove(Serializable primaryKey) throws NoSuchAuthException {
		Session session = null;

		try {
			session = openSession();

			Auth auth = (Auth)session.get(AuthImpl.class, primaryKey);

			if (auth == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auth);
		}
		catch (NoSuchAuthException nsee) {
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
	protected Auth removeImpl(Auth auth) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auth)) {
				auth = (Auth)session.get(
					AuthImpl.class, auth.getPrimaryKeyObj());
			}

			if (auth != null) {
				session.delete(auth);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (auth != null) {
			clearCache(auth);
		}

		return auth;
	}

	@Override
	public Auth updateImpl(Auth auth) {
		boolean isNew = auth.isNew();

		Session session = null;

		try {
			session = openSession();

			if (auth.isNew()) {
				session.save(auth);

				auth.setNew(false);
			}
			else {
				auth = (Auth)session.merge(auth);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
			auth.getPrimaryKey(), auth, false);

		auth.resetOriginalValues();

		return auth;
	}

	/**
	 * Returns the auth with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auth
	 * @return the auth
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthException {

		Auth auth = fetchByPrimaryKey(primaryKey);

		if (auth == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auth;
	}

	/**
	 * Returns the auth with the primary key or throws a <code>NoSuchAuthException</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth findByPrimaryKey(String key) throws NoSuchAuthException {
		return findByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns the auth with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auth
	 * @return the auth, or <code>null</code> if a auth with the primary key could not be found
	 */
	@Override
	public Auth fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Auth auth = (Auth)serializable;

		if (auth == null) {
			Session session = null;

			try {
				session = openSession();

				auth = (Auth)session.get(AuthImpl.class, primaryKey);

				if (auth != null) {
					cacheResult(auth);
				}
				else {
					entityCache.putResult(
						AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return auth;
	}

	/**
	 * Returns the auth with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth, or <code>null</code> if a auth with the primary key could not be found
	 */
	@Override
	public Auth fetchByPrimaryKey(String key) {
		return fetchByPrimaryKey((Serializable)key);
	}

	@Override
	public Map<Serializable, Auth> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Auth> map = new HashMap<Serializable, Auth>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Auth auth = fetchByPrimaryKey(primaryKey);

			if (auth != null) {
				map.put(primaryKey, auth);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Auth)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_AUTH_WHERE_PKS_IN);

		for (int i = 0; i < uncachedPrimaryKeys.size(); i++) {
			query.append("?");

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				qPos.add((String)primaryKey);
			}

			for (Auth auth : (List<Auth>)q.list()) {
				map.put(auth.getPrimaryKeyObj(), auth);

				cacheResult(auth);

				uncachedPrimaryKeys.remove(auth.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AuthModelImpl.ENTITY_CACHE_ENABLED, AuthImpl.class,
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
	 * Returns all the auths.
	 *
	 * @return the auths
	 */
	@Override
	public List<Auth> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @return the range of auths
	 */
	@Override
	public List<Auth> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auths
	 */
	@Override
	public List<Auth> findAll(
		int start, int end, OrderByComparator<Auth> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of auths
	 */
	@Override
	public List<Auth> findAll(
		int start, int end, OrderByComparator<Auth> orderByComparator,
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

		List<Auth> list = null;

		if (retrieveFromCache) {
			list = (List<Auth>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AUTH);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTH;

				if (pagination) {
					sql = sql.concat(AuthModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Auth>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Auth>)QueryUtil.list(
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
	 * Removes all the auths from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Auth auth : findAll()) {
			remove(auth);
		}
	}

	/**
	 * Returns the number of auths.
	 *
	 * @return the number of auths
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUTH);

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
		return AuthModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the auth persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AuthModelImpl.ENTITY_CACHE_ENABLED,
			AuthModelImpl.FINDER_CACHE_ENABLED, AuthImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AuthModelImpl.ENTITY_CACHE_ENABLED,
			AuthModelImpl.FINDER_CACHE_ENABLED, AuthImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AuthModelImpl.ENTITY_CACHE_ENABLED,
			AuthModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(AuthImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AUTH = "SELECT auth FROM Auth auth";

	private static final String _SQL_SELECT_AUTH_WHERE_PKS_IN =
		"SELECT auth FROM Auth auth WHERE key_ IN (";

	private static final String _SQL_COUNT_AUTH =
		"SELECT COUNT(auth) FROM Auth auth";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auth.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Auth exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AuthPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

}