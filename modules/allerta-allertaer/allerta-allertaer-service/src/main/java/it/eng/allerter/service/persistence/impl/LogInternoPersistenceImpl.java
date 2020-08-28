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

package it.eng.allerter.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerter.exception.NoSuchLogInternoException;
import it.eng.allerter.model.LogInterno;
import it.eng.allerter.model.impl.LogInternoImpl;
import it.eng.allerter.model.impl.LogInternoModelImpl;
import it.eng.allerter.service.persistence.LogInternoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the log interno service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class LogInternoPersistenceImpl
	extends BasePersistenceImpl<LogInterno> implements LogInternoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LogInternoUtil</code> to access the log interno persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LogInternoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public LogInternoPersistenceImpl() {
		setModelClass(LogInterno.class);
	}

	/**
	 * Caches the log interno in the entity cache if it is enabled.
	 *
	 * @param logInterno the log interno
	 */
	@Override
	public void cacheResult(LogInterno logInterno) {
		entityCache.putResult(
			LogInternoModelImpl.ENTITY_CACHE_ENABLED, LogInternoImpl.class,
			logInterno.getPrimaryKey(), logInterno);

		logInterno.resetOriginalValues();
	}

	/**
	 * Caches the log internos in the entity cache if it is enabled.
	 *
	 * @param logInternos the log internos
	 */
	@Override
	public void cacheResult(List<LogInterno> logInternos) {
		for (LogInterno logInterno : logInternos) {
			if (entityCache.getResult(
					LogInternoModelImpl.ENTITY_CACHE_ENABLED,
					LogInternoImpl.class, logInterno.getPrimaryKey()) == null) {

				cacheResult(logInterno);
			}
			else {
				logInterno.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log internos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogInternoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log interno.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogInterno logInterno) {
		entityCache.removeResult(
			LogInternoModelImpl.ENTITY_CACHE_ENABLED, LogInternoImpl.class,
			logInterno.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogInterno> logInternos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogInterno logInterno : logInternos) {
			entityCache.removeResult(
				LogInternoModelImpl.ENTITY_CACHE_ENABLED, LogInternoImpl.class,
				logInterno.getPrimaryKey());
		}
	}

	/**
	 * Creates a new log interno with the primary key. Does not add the log interno to the database.
	 *
	 * @param logId the primary key for the new log interno
	 * @return the new log interno
	 */
	@Override
	public LogInterno create(long logId) {
		LogInterno logInterno = new LogInternoImpl();

		logInterno.setNew(true);
		logInterno.setPrimaryKey(logId);

		return logInterno;
	}

	/**
	 * Removes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno remove(long logId) throws NoSuchLogInternoException {
		return remove((Serializable)logId);
	}

	/**
	 * Removes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno remove(Serializable primaryKey)
		throws NoSuchLogInternoException {

		Session session = null;

		try {
			session = openSession();

			LogInterno logInterno = (LogInterno)session.get(
				LogInternoImpl.class, primaryKey);

			if (logInterno == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogInternoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(logInterno);
		}
		catch (NoSuchLogInternoException nsee) {
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
	protected LogInterno removeImpl(LogInterno logInterno) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logInterno)) {
				logInterno = (LogInterno)session.get(
					LogInternoImpl.class, logInterno.getPrimaryKeyObj());
			}

			if (logInterno != null) {
				session.delete(logInterno);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logInterno != null) {
			clearCache(logInterno);
		}

		return logInterno;
	}

	@Override
	public LogInterno updateImpl(LogInterno logInterno) {
		boolean isNew = logInterno.isNew();

		Session session = null;

		try {
			session = openSession();

			if (logInterno.isNew()) {
				session.save(logInterno);

				logInterno.setNew(false);
			}
			else {
				logInterno = (LogInterno)session.merge(logInterno);
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
			LogInternoModelImpl.ENTITY_CACHE_ENABLED, LogInternoImpl.class,
			logInterno.getPrimaryKey(), logInterno, false);

		logInterno.resetOriginalValues();

		return logInterno;
	}

	/**
	 * Returns the log interno with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log interno
	 * @return the log interno
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogInternoException {

		LogInterno logInterno = fetchByPrimaryKey(primaryKey);

		if (logInterno == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogInternoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return logInterno;
	}

	/**
	 * Returns the log interno with the primary key or throws a <code>NoSuchLogInternoException</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno findByPrimaryKey(long logId)
		throws NoSuchLogInternoException {

		return findByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns the log interno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log interno
	 * @return the log interno, or <code>null</code> if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			LogInternoModelImpl.ENTITY_CACHE_ENABLED, LogInternoImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LogInterno logInterno = (LogInterno)serializable;

		if (logInterno == null) {
			Session session = null;

			try {
				session = openSession();

				logInterno = (LogInterno)session.get(
					LogInternoImpl.class, primaryKey);

				if (logInterno != null) {
					cacheResult(logInterno);
				}
				else {
					entityCache.putResult(
						LogInternoModelImpl.ENTITY_CACHE_ENABLED,
						LogInternoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					LogInternoModelImpl.ENTITY_CACHE_ENABLED,
					LogInternoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logInterno;
	}

	/**
	 * Returns the log interno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno, or <code>null</code> if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno fetchByPrimaryKey(long logId) {
		return fetchByPrimaryKey((Serializable)logId);
	}

	@Override
	public Map<Serializable, LogInterno> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LogInterno> map =
			new HashMap<Serializable, LogInterno>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LogInterno logInterno = fetchByPrimaryKey(primaryKey);

			if (logInterno != null) {
				map.put(primaryKey, logInterno);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				LogInternoModelImpl.ENTITY_CACHE_ENABLED, LogInternoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LogInterno)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_LOGINTERNO_WHERE_PKS_IN);

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

			for (LogInterno logInterno : (List<LogInterno>)q.list()) {
				map.put(logInterno.getPrimaryKeyObj(), logInterno);

				cacheResult(logInterno);

				uncachedPrimaryKeys.remove(logInterno.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					LogInternoModelImpl.ENTITY_CACHE_ENABLED,
					LogInternoImpl.class, primaryKey, nullModel);
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
	 * Returns all the log internos.
	 *
	 * @return the log internos
	 */
	@Override
	public List<LogInterno> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @return the range of log internos
	 */
	@Override
	public List<LogInterno> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log internos
	 */
	@Override
	public List<LogInterno> findAll(
		int start, int end, OrderByComparator<LogInterno> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of log internos
	 */
	@Override
	public List<LogInterno> findAll(
		int start, int end, OrderByComparator<LogInterno> orderByComparator,
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

		List<LogInterno> list = null;

		if (retrieveFromCache) {
			list = (List<LogInterno>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGINTERNO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGINTERNO;

				if (pagination) {
					sql = sql.concat(LogInternoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogInterno>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogInterno>)QueryUtil.list(
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
	 * Removes all the log internos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogInterno logInterno : findAll()) {
			remove(logInterno);
		}
	}

	/**
	 * Returns the number of log internos.
	 *
	 * @return the number of log internos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGINTERNO);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return LogInternoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the log interno persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LogInternoModelImpl.ENTITY_CACHE_ENABLED,
			LogInternoModelImpl.FINDER_CACHE_ENABLED, LogInternoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LogInternoModelImpl.ENTITY_CACHE_ENABLED,
			LogInternoModelImpl.FINDER_CACHE_ENABLED, LogInternoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LogInternoModelImpl.ENTITY_CACHE_ENABLED,
			LogInternoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(LogInternoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LOGINTERNO =
		"SELECT logInterno FROM LogInterno logInterno";

	private static final String _SQL_SELECT_LOGINTERNO_WHERE_PKS_IN =
		"SELECT logInterno FROM LogInterno logInterno WHERE logId IN (";

	private static final String _SQL_COUNT_LOGINTERNO =
		"SELECT COUNT(logInterno) FROM LogInterno logInterno";

	private static final String _ORDER_BY_ENTITY_ALIAS = "logInterno.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LogInterno exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		LogInternoPersistenceImpl.class);

}