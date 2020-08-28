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

package it.eng.animazione.image.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.animazione.image.exception.NoSuchaltezzaOndaException;
import it.eng.animazione.image.model.altezzaOnda;
import it.eng.animazione.image.model.impl.altezzaOndaImpl;
import it.eng.animazione.image.model.impl.altezzaOndaModelImpl;
import it.eng.animazione.image.service.persistence.altezzaOndaPersistence;

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
 * The persistence implementation for the altezza onda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class altezzaOndaPersistenceImpl
	extends BasePersistenceImpl<altezzaOnda> implements altezzaOndaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>altezzaOndaUtil</code> to access the altezza onda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		altezzaOndaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public altezzaOndaPersistenceImpl() {
		setModelClass(altezzaOnda.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("ts_UTC", "timestamp");

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
	 * Caches the altezza onda in the entity cache if it is enabled.
	 *
	 * @param altezzaOnda the altezza onda
	 */
	@Override
	public void cacheResult(altezzaOnda altezzaOnda) {
		entityCache.putResult(
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED, altezzaOndaImpl.class,
			altezzaOnda.getPrimaryKey(), altezzaOnda);

		altezzaOnda.resetOriginalValues();
	}

	/**
	 * Caches the altezza ondas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndas the altezza ondas
	 */
	@Override
	public void cacheResult(List<altezzaOnda> altezzaOndas) {
		for (altezzaOnda altezzaOnda : altezzaOndas) {
			if (entityCache.getResult(
					altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaImpl.class, altezzaOnda.getPrimaryKey()) ==
						null) {

				cacheResult(altezzaOnda);
			}
			else {
				altezzaOnda.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all altezza ondas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(altezzaOndaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the altezza onda.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(altezzaOnda altezzaOnda) {
		entityCache.removeResult(
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED, altezzaOndaImpl.class,
			altezzaOnda.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<altezzaOnda> altezzaOndas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (altezzaOnda altezzaOnda : altezzaOndas) {
			entityCache.removeResult(
				altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
				altezzaOndaImpl.class, altezzaOnda.getPrimaryKey());
		}
	}

	/**
	 * Creates a new altezza onda with the primary key. Does not add the altezza onda to the database.
	 *
	 * @param id the primary key for the new altezza onda
	 * @return the new altezza onda
	 */
	@Override
	public altezzaOnda create(long id) {
		altezzaOnda altezzaOnda = new altezzaOndaImpl();

		altezzaOnda.setNew(true);
		altezzaOnda.setPrimaryKey(id);

		return altezzaOnda;
	}

	/**
	 * Removes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda remove(long id) throws NoSuchaltezzaOndaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda remove(Serializable primaryKey)
		throws NoSuchaltezzaOndaException {

		Session session = null;

		try {
			session = openSession();

			altezzaOnda altezzaOnda = (altezzaOnda)session.get(
				altezzaOndaImpl.class, primaryKey);

			if (altezzaOnda == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaltezzaOndaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(altezzaOnda);
		}
		catch (NoSuchaltezzaOndaException nsee) {
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
	protected altezzaOnda removeImpl(altezzaOnda altezzaOnda) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(altezzaOnda)) {
				altezzaOnda = (altezzaOnda)session.get(
					altezzaOndaImpl.class, altezzaOnda.getPrimaryKeyObj());
			}

			if (altezzaOnda != null) {
				session.delete(altezzaOnda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (altezzaOnda != null) {
			clearCache(altezzaOnda);
		}

		return altezzaOnda;
	}

	@Override
	public altezzaOnda updateImpl(altezzaOnda altezzaOnda) {
		boolean isNew = altezzaOnda.isNew();

		Session session = null;

		try {
			session = openSession();

			if (altezzaOnda.isNew()) {
				session.save(altezzaOnda);

				altezzaOnda.setNew(false);
			}
			else {
				altezzaOnda = (altezzaOnda)session.merge(altezzaOnda);
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
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED, altezzaOndaImpl.class,
			altezzaOnda.getPrimaryKey(), altezzaOnda, false);

		altezzaOnda.resetOriginalValues();

		return altezzaOnda;
	}

	/**
	 * Returns the altezza onda with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaltezzaOndaException {

		altezzaOnda altezzaOnda = fetchByPrimaryKey(primaryKey);

		if (altezzaOnda == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaltezzaOndaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return altezzaOnda;
	}

	/**
	 * Returns the altezza onda with the primary key or throws a <code>NoSuchaltezzaOndaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the altezza onda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda
	 * @return the altezza onda, or <code>null</code> if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED, altezzaOndaImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		altezzaOnda altezzaOnda = (altezzaOnda)serializable;

		if (altezzaOnda == null) {
			Session session = null;

			try {
				session = openSession();

				altezzaOnda = (altezzaOnda)session.get(
					altezzaOndaImpl.class, primaryKey);

				if (altezzaOnda != null) {
					cacheResult(altezzaOnda);
				}
				else {
					entityCache.putResult(
						altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
						altezzaOndaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return altezzaOnda;
	}

	/**
	 * Returns the altezza onda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda, or <code>null</code> if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, altezzaOnda> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, altezzaOnda> map =
			new HashMap<Serializable, altezzaOnda>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			altezzaOnda altezzaOnda = fetchByPrimaryKey(primaryKey);

			if (altezzaOnda != null) {
				map.put(primaryKey, altezzaOnda);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
				altezzaOndaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (altezzaOnda)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ALTEZZAONDA_WHERE_PKS_IN);

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

			for (altezzaOnda altezzaOnda : (List<altezzaOnda>)q.list()) {
				map.put(altezzaOnda.getPrimaryKeyObj(), altezzaOnda);

				cacheResult(altezzaOnda);

				uncachedPrimaryKeys.remove(altezzaOnda.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaImpl.class, primaryKey, nullModel);
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
	 * Returns all the altezza ondas.
	 *
	 * @return the altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @return the range of altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll(
		int start, int end, OrderByComparator<altezzaOnda> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll(
		int start, int end, OrderByComparator<altezzaOnda> orderByComparator,
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

		List<altezzaOnda> list = null;

		if (retrieveFromCache) {
			list = (List<altezzaOnda>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALTEZZAONDA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALTEZZAONDA;

				if (pagination) {
					sql = sql.concat(altezzaOndaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<altezzaOnda>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<altezzaOnda>)QueryUtil.list(
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
	 * Removes all the altezza ondas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (altezzaOnda altezzaOnda : findAll()) {
			remove(altezzaOnda);
		}
	}

	/**
	 * Returns the number of altezza ondas.
	 *
	 * @return the number of altezza ondas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALTEZZAONDA);

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
		return altezzaOndaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the altezza onda persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaModelImpl.FINDER_CACHE_ENABLED, altezzaOndaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaModelImpl.FINDER_CACHE_ENABLED, altezzaOndaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			altezzaOndaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(altezzaOndaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALTEZZAONDA =
		"SELECT altezzaOnda FROM altezzaOnda altezzaOnda";

	private static final String _SQL_SELECT_ALTEZZAONDA_WHERE_PKS_IN =
		"SELECT altezzaOnda FROM altezzaOnda altezzaOnda WHERE id_ IN (";

	private static final String _SQL_COUNT_ALTEZZAONDA =
		"SELECT COUNT(altezzaOnda) FROM altezzaOnda altezzaOnda";

	private static final String _ORDER_BY_ENTITY_ALIAS = "altezzaOnda.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No altezzaOnda exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		altezzaOndaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

}