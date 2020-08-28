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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaPermessiException;
import it.eng.allerte.model.RubricaPermessi;
import it.eng.allerte.model.impl.RubricaPermessiImpl;
import it.eng.allerte.model.impl.RubricaPermessiModelImpl;
import it.eng.allerte.service.persistence.RubricaPermessiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica permessi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaPermessiPersistenceImpl
	extends BasePersistenceImpl<RubricaPermessi>
	implements RubricaPermessiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaPermessiUtil</code> to access the rubrica permessi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaPermessiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaPermessiPersistenceImpl() {
		setModelClass(RubricaPermessi.class);
	}

	/**
	 * Caches the rubrica permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessi the rubrica permessi
	 */
	@Override
	public void cacheResult(RubricaPermessi rubricaPermessi) {
		entityCache.putResult(
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiImpl.class, rubricaPermessi.getPrimaryKey(),
			rubricaPermessi);

		rubricaPermessi.resetOriginalValues();
	}

	/**
	 * Caches the rubrica permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessis the rubrica permessis
	 */
	@Override
	public void cacheResult(List<RubricaPermessi> rubricaPermessis) {
		for (RubricaPermessi rubricaPermessi : rubricaPermessis) {
			if (entityCache.getResult(
					RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaPermessiImpl.class,
					rubricaPermessi.getPrimaryKey()) == null) {

				cacheResult(rubricaPermessi);
			}
			else {
				rubricaPermessi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica permessis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaPermessiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica permessi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaPermessi rubricaPermessi) {
		entityCache.removeResult(
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiImpl.class, rubricaPermessi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaPermessi> rubricaPermessis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaPermessi rubricaPermessi : rubricaPermessis) {
			entityCache.removeResult(
				RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaPermessiImpl.class, rubricaPermessi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica permessi with the primary key. Does not add the rubrica permessi to the database.
	 *
	 * @param ID_PERMESSO the primary key for the new rubrica permessi
	 * @return the new rubrica permessi
	 */
	@Override
	public RubricaPermessi create(String ID_PERMESSO) {
		RubricaPermessi rubricaPermessi = new RubricaPermessiImpl();

		rubricaPermessi.setNew(true);
		rubricaPermessi.setPrimaryKey(ID_PERMESSO);

		return rubricaPermessi;
	}

	/**
	 * Removes the rubrica permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi that was removed
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi remove(String ID_PERMESSO)
		throws NoSuchRubricaPermessiException {

		return remove((Serializable)ID_PERMESSO);
	}

	/**
	 * Removes the rubrica permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica permessi
	 * @return the rubrica permessi that was removed
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi remove(Serializable primaryKey)
		throws NoSuchRubricaPermessiException {

		Session session = null;

		try {
			session = openSession();

			RubricaPermessi rubricaPermessi = (RubricaPermessi)session.get(
				RubricaPermessiImpl.class, primaryKey);

			if (rubricaPermessi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaPermessiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaPermessi);
		}
		catch (NoSuchRubricaPermessiException nsee) {
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
	protected RubricaPermessi removeImpl(RubricaPermessi rubricaPermessi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaPermessi)) {
				rubricaPermessi = (RubricaPermessi)session.get(
					RubricaPermessiImpl.class,
					rubricaPermessi.getPrimaryKeyObj());
			}

			if (rubricaPermessi != null) {
				session.delete(rubricaPermessi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaPermessi != null) {
			clearCache(rubricaPermessi);
		}

		return rubricaPermessi;
	}

	@Override
	public RubricaPermessi updateImpl(RubricaPermessi rubricaPermessi) {
		boolean isNew = rubricaPermessi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rubricaPermessi.isNew()) {
				session.save(rubricaPermessi);

				rubricaPermessi.setNew(false);
			}
			else {
				rubricaPermessi = (RubricaPermessi)session.merge(
					rubricaPermessi);
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
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiImpl.class, rubricaPermessi.getPrimaryKey(),
			rubricaPermessi, false);

		rubricaPermessi.resetOriginalValues();

		return rubricaPermessi;
	}

	/**
	 * Returns the rubrica permessi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica permessi
	 * @return the rubrica permessi
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaPermessiException {

		RubricaPermessi rubricaPermessi = fetchByPrimaryKey(primaryKey);

		if (rubricaPermessi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaPermessiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaPermessi;
	}

	/**
	 * Returns the rubrica permessi with the primary key or throws a <code>NoSuchRubricaPermessiException</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi findByPrimaryKey(String ID_PERMESSO)
		throws NoSuchRubricaPermessiException {

		return findByPrimaryKey((Serializable)ID_PERMESSO);
	}

	/**
	 * Returns the rubrica permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica permessi
	 * @return the rubrica permessi, or <code>null</code> if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaPermessi rubricaPermessi = (RubricaPermessi)serializable;

		if (rubricaPermessi == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaPermessi = (RubricaPermessi)session.get(
					RubricaPermessiImpl.class, primaryKey);

				if (rubricaPermessi != null) {
					cacheResult(rubricaPermessi);
				}
				else {
					entityCache.putResult(
						RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
						RubricaPermessiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaPermessiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaPermessi;
	}

	/**
	 * Returns the rubrica permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi, or <code>null</code> if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi fetchByPrimaryKey(String ID_PERMESSO) {
		return fetchByPrimaryKey((Serializable)ID_PERMESSO);
	}

	@Override
	public Map<Serializable, RubricaPermessi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaPermessi> map =
			new HashMap<Serializable, RubricaPermessi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaPermessi rubricaPermessi = fetchByPrimaryKey(primaryKey);

			if (rubricaPermessi != null) {
				map.put(primaryKey, rubricaPermessi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaPermessiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaPermessi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICAPERMESSI_WHERE_PKS_IN);

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

			for (RubricaPermessi rubricaPermessi :
					(List<RubricaPermessi>)q.list()) {

				map.put(rubricaPermessi.getPrimaryKeyObj(), rubricaPermessi);

				cacheResult(rubricaPermessi);

				uncachedPrimaryKeys.remove(rubricaPermessi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaPermessiImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica permessis.
	 *
	 * @return the rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @return the range of rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator,
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

		List<RubricaPermessi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaPermessi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICAPERMESSI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAPERMESSI;

				if (pagination) {
					sql = sql.concat(RubricaPermessiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaPermessi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaPermessi>)QueryUtil.list(
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
	 * Removes all the rubrica permessis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaPermessi rubricaPermessi : findAll()) {
			remove(rubricaPermessi);
		}
	}

	/**
	 * Returns the number of rubrica permessis.
	 *
	 * @return the number of rubrica permessis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICAPERMESSI);

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
		return RubricaPermessiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica permessi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiModelImpl.FINDER_CACHE_ENABLED,
			RubricaPermessiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiModelImpl.FINDER_CACHE_ENABLED,
			RubricaPermessiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaPermessiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaPermessiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(RubricaPermessiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICAPERMESSI =
		"SELECT rubricaPermessi FROM RubricaPermessi rubricaPermessi";

	private static final String _SQL_SELECT_RUBRICAPERMESSI_WHERE_PKS_IN =
		"SELECT rubricaPermessi FROM RubricaPermessi rubricaPermessi WHERE ID_PERMESSO IN (";

	private static final String _SQL_COUNT_RUBRICAPERMESSI =
		"SELECT COUNT(rubricaPermessi) FROM RubricaPermessi rubricaPermessi";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaPermessi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaPermessi exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaPermessiPersistenceImpl.class);

}