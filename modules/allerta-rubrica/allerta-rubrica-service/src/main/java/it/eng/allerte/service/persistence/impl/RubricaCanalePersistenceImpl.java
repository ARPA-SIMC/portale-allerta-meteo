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

package it.eng.allerte.service.persistence.impl;

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

import it.eng.allerte.exception.NoSuchRubricaCanaleException;
import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.model.impl.RubricaCanaleImpl;
import it.eng.allerte.model.impl.RubricaCanaleModelImpl;
import it.eng.allerte.service.persistence.RubricaCanalePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica canale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaCanalePersistenceImpl
	extends BasePersistenceImpl<RubricaCanale>
	implements RubricaCanalePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaCanaleUtil</code> to access the rubrica canale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaCanaleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaCanalePersistenceImpl() {
		setModelClass(RubricaCanale.class);
	}

	/**
	 * Caches the rubrica canale in the entity cache if it is enabled.
	 *
	 * @param rubricaCanale the rubrica canale
	 */
	@Override
	public void cacheResult(RubricaCanale rubricaCanale) {
		entityCache.putResult(
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey(),
			rubricaCanale);

		rubricaCanale.resetOriginalValues();
	}

	/**
	 * Caches the rubrica canales in the entity cache if it is enabled.
	 *
	 * @param rubricaCanales the rubrica canales
	 */
	@Override
	public void cacheResult(List<RubricaCanale> rubricaCanales) {
		for (RubricaCanale rubricaCanale : rubricaCanales) {
			if (entityCache.getResult(
					RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
					RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaCanale);
			}
			else {
				rubricaCanale.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica canales.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaCanaleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica canale.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaCanale rubricaCanale) {
		entityCache.removeResult(
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaCanale> rubricaCanales) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaCanale rubricaCanale : rubricaCanales) {
			entityCache.removeResult(
				RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
				RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica canale with the primary key. Does not add the rubrica canale to the database.
	 *
	 * @param ID_CANALE the primary key for the new rubrica canale
	 * @return the new rubrica canale
	 */
	@Override
	public RubricaCanale create(long ID_CANALE) {
		RubricaCanale rubricaCanale = new RubricaCanaleImpl();

		rubricaCanale.setNew(true);
		rubricaCanale.setPrimaryKey(ID_CANALE);

		return rubricaCanale;
	}

	/**
	 * Removes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale remove(long ID_CANALE)
		throws NoSuchRubricaCanaleException {

		return remove((Serializable)ID_CANALE);
	}

	/**
	 * Removes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale remove(Serializable primaryKey)
		throws NoSuchRubricaCanaleException {

		Session session = null;

		try {
			session = openSession();

			RubricaCanale rubricaCanale = (RubricaCanale)session.get(
				RubricaCanaleImpl.class, primaryKey);

			if (rubricaCanale == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaCanaleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaCanale);
		}
		catch (NoSuchRubricaCanaleException nsee) {
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
	protected RubricaCanale removeImpl(RubricaCanale rubricaCanale) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaCanale)) {
				rubricaCanale = (RubricaCanale)session.get(
					RubricaCanaleImpl.class, rubricaCanale.getPrimaryKeyObj());
			}

			if (rubricaCanale != null) {
				session.delete(rubricaCanale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaCanale != null) {
			clearCache(rubricaCanale);
		}

		return rubricaCanale;
	}

	@Override
	public RubricaCanale updateImpl(RubricaCanale rubricaCanale) {
		boolean isNew = rubricaCanale.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rubricaCanale.isNew()) {
				session.save(rubricaCanale);

				rubricaCanale.setNew(false);
			}
			else {
				rubricaCanale = (RubricaCanale)session.merge(rubricaCanale);
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
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey(),
			rubricaCanale, false);

		rubricaCanale.resetOriginalValues();

		return rubricaCanale;
	}

	/**
	 * Returns the rubrica canale with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaCanaleException {

		RubricaCanale rubricaCanale = fetchByPrimaryKey(primaryKey);

		if (rubricaCanale == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaCanaleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaCanale;
	}

	/**
	 * Returns the rubrica canale with the primary key or throws a <code>NoSuchRubricaCanaleException</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale findByPrimaryKey(long ID_CANALE)
		throws NoSuchRubricaCanaleException {

		return findByPrimaryKey((Serializable)ID_CANALE);
	}

	/**
	 * Returns the rubrica canale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica canale
	 * @return the rubrica canale, or <code>null</code> if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaCanale rubricaCanale = (RubricaCanale)serializable;

		if (rubricaCanale == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaCanale = (RubricaCanale)session.get(
					RubricaCanaleImpl.class, primaryKey);

				if (rubricaCanale != null) {
					cacheResult(rubricaCanale);
				}
				else {
					entityCache.putResult(
						RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
						RubricaCanaleImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
					RubricaCanaleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaCanale;
	}

	/**
	 * Returns the rubrica canale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale, or <code>null</code> if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale fetchByPrimaryKey(long ID_CANALE) {
		return fetchByPrimaryKey((Serializable)ID_CANALE);
	}

	@Override
	public Map<Serializable, RubricaCanale> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaCanale> map =
			new HashMap<Serializable, RubricaCanale>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaCanale rubricaCanale = fetchByPrimaryKey(primaryKey);

			if (rubricaCanale != null) {
				map.put(primaryKey, rubricaCanale);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
				RubricaCanaleImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaCanale)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICACANALE_WHERE_PKS_IN);

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

			for (RubricaCanale rubricaCanale : (List<RubricaCanale>)q.list()) {
				map.put(rubricaCanale.getPrimaryKeyObj(), rubricaCanale);

				cacheResult(rubricaCanale);

				uncachedPrimaryKeys.remove(rubricaCanale.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
					RubricaCanaleImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica canales.
	 *
	 * @return the rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @return the range of rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll(
		int start, int end,
		OrderByComparator<RubricaCanale> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll(
		int start, int end, OrderByComparator<RubricaCanale> orderByComparator,
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

		List<RubricaCanale> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaCanale>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICACANALE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICACANALE;

				if (pagination) {
					sql = sql.concat(RubricaCanaleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaCanale>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaCanale>)QueryUtil.list(
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
	 * Removes all the rubrica canales from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaCanale rubricaCanale : findAll()) {
			remove(rubricaCanale);
		}
	}

	/**
	 * Returns the number of rubrica canales.
	 *
	 * @return the number of rubrica canales
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICACANALE);

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
		return RubricaCanaleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica canale persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleModelImpl.FINDER_CACHE_ENABLED,
			RubricaCanaleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleModelImpl.FINDER_CACHE_ENABLED,
			RubricaCanaleImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaCanaleModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCanaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(RubricaCanaleImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICACANALE =
		"SELECT rubricaCanale FROM RubricaCanale rubricaCanale";

	private static final String _SQL_SELECT_RUBRICACANALE_WHERE_PKS_IN =
		"SELECT rubricaCanale FROM RubricaCanale rubricaCanale WHERE ID_CANALE IN (";

	private static final String _SQL_COUNT_RUBRICACANALE =
		"SELECT COUNT(rubricaCanale) FROM RubricaCanale rubricaCanale";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaCanale.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaCanale exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaCanalePersistenceImpl.class);

}