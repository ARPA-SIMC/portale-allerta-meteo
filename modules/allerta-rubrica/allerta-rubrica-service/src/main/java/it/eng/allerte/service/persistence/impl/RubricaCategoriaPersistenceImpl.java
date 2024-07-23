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

import it.eng.allerte.exception.NoSuchRubricaCategoriaException;
import it.eng.allerte.model.RubricaCategoria;
import it.eng.allerte.model.impl.RubricaCategoriaImpl;
import it.eng.allerte.model.impl.RubricaCategoriaModelImpl;
import it.eng.allerte.service.persistence.RubricaCategoriaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaCategoriaPersistenceImpl
	extends BasePersistenceImpl<RubricaCategoria>
	implements RubricaCategoriaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaCategoriaUtil</code> to access the rubrica categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaCategoriaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaCategoriaPersistenceImpl() {
		setModelClass(RubricaCategoria.class);
	}

	/**
	 * Caches the rubrica categoria in the entity cache if it is enabled.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 */
	@Override
	public void cacheResult(RubricaCategoria rubricaCategoria) {
		entityCache.putResult(
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaImpl.class, rubricaCategoria.getPrimaryKey(),
			rubricaCategoria);

		rubricaCategoria.resetOriginalValues();
	}

	/**
	 * Caches the rubrica categorias in the entity cache if it is enabled.
	 *
	 * @param rubricaCategorias the rubrica categorias
	 */
	@Override
	public void cacheResult(List<RubricaCategoria> rubricaCategorias) {
		for (RubricaCategoria rubricaCategoria : rubricaCategorias) {
			if (entityCache.getResult(
					RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
					RubricaCategoriaImpl.class,
					rubricaCategoria.getPrimaryKey()) == null) {

				cacheResult(rubricaCategoria);
			}
			else {
				rubricaCategoria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica categorias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaCategoriaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica categoria.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaCategoria rubricaCategoria) {
		entityCache.removeResult(
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaImpl.class, rubricaCategoria.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaCategoria> rubricaCategorias) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaCategoria rubricaCategoria : rubricaCategorias) {
			entityCache.removeResult(
				RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
				RubricaCategoriaImpl.class, rubricaCategoria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica categoria with the primary key. Does not add the rubrica categoria to the database.
	 *
	 * @param ID_CATEGORIA the primary key for the new rubrica categoria
	 * @return the new rubrica categoria
	 */
	@Override
	public RubricaCategoria create(long ID_CATEGORIA) {
		RubricaCategoria rubricaCategoria = new RubricaCategoriaImpl();

		rubricaCategoria.setNew(true);
		rubricaCategoria.setPrimaryKey(ID_CATEGORIA);

		return rubricaCategoria;
	}

	/**
	 * Removes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria remove(long ID_CATEGORIA)
		throws NoSuchRubricaCategoriaException {

		return remove((Serializable)ID_CATEGORIA);
	}

	/**
	 * Removes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria remove(Serializable primaryKey)
		throws NoSuchRubricaCategoriaException {

		Session session = null;

		try {
			session = openSession();

			RubricaCategoria rubricaCategoria = (RubricaCategoria)session.get(
				RubricaCategoriaImpl.class, primaryKey);

			if (rubricaCategoria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaCategoriaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaCategoria);
		}
		catch (NoSuchRubricaCategoriaException nsee) {
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
	protected RubricaCategoria removeImpl(RubricaCategoria rubricaCategoria) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaCategoria)) {
				rubricaCategoria = (RubricaCategoria)session.get(
					RubricaCategoriaImpl.class,
					rubricaCategoria.getPrimaryKeyObj());
			}

			if (rubricaCategoria != null) {
				session.delete(rubricaCategoria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaCategoria != null) {
			clearCache(rubricaCategoria);
		}

		return rubricaCategoria;
	}

	@Override
	public RubricaCategoria updateImpl(RubricaCategoria rubricaCategoria) {
		boolean isNew = rubricaCategoria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rubricaCategoria.isNew()) {
				session.save(rubricaCategoria);

				rubricaCategoria.setNew(false);
			}
			else {
				rubricaCategoria = (RubricaCategoria)session.merge(
					rubricaCategoria);
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
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaImpl.class, rubricaCategoria.getPrimaryKey(),
			rubricaCategoria, false);

		rubricaCategoria.resetOriginalValues();

		return rubricaCategoria;
	}

	/**
	 * Returns the rubrica categoria with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaCategoriaException {

		RubricaCategoria rubricaCategoria = fetchByPrimaryKey(primaryKey);

		if (rubricaCategoria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaCategoriaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaCategoria;
	}

	/**
	 * Returns the rubrica categoria with the primary key or throws a <code>NoSuchRubricaCategoriaException</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria findByPrimaryKey(long ID_CATEGORIA)
		throws NoSuchRubricaCategoriaException {

		return findByPrimaryKey((Serializable)ID_CATEGORIA);
	}

	/**
	 * Returns the rubrica categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica categoria
	 * @return the rubrica categoria, or <code>null</code> if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaCategoria rubricaCategoria = (RubricaCategoria)serializable;

		if (rubricaCategoria == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaCategoria = (RubricaCategoria)session.get(
					RubricaCategoriaImpl.class, primaryKey);

				if (rubricaCategoria != null) {
					cacheResult(rubricaCategoria);
				}
				else {
					entityCache.putResult(
						RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
						RubricaCategoriaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
					RubricaCategoriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaCategoria;
	}

	/**
	 * Returns the rubrica categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria, or <code>null</code> if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria fetchByPrimaryKey(long ID_CATEGORIA) {
		return fetchByPrimaryKey((Serializable)ID_CATEGORIA);
	}

	@Override
	public Map<Serializable, RubricaCategoria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaCategoria> map =
			new HashMap<Serializable, RubricaCategoria>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaCategoria rubricaCategoria = fetchByPrimaryKey(primaryKey);

			if (rubricaCategoria != null) {
				map.put(primaryKey, rubricaCategoria);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
				RubricaCategoriaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaCategoria)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICACATEGORIA_WHERE_PKS_IN);

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

			for (RubricaCategoria rubricaCategoria :
					(List<RubricaCategoria>)q.list()) {

				map.put(rubricaCategoria.getPrimaryKeyObj(), rubricaCategoria);

				cacheResult(rubricaCategoria);

				uncachedPrimaryKeys.remove(rubricaCategoria.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
					RubricaCategoriaImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica categorias.
	 *
	 * @return the rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @return the range of rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll(
		int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll(
		int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator,
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

		List<RubricaCategoria> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaCategoria>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICACATEGORIA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICACATEGORIA;

				if (pagination) {
					sql = sql.concat(RubricaCategoriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaCategoria>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaCategoria>)QueryUtil.list(
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
	 * Removes all the rubrica categorias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaCategoria rubricaCategoria : findAll()) {
			remove(rubricaCategoria);
		}
	}

	/**
	 * Returns the number of rubrica categorias.
	 *
	 * @return the number of rubrica categorias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICACATEGORIA);

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
		return RubricaCategoriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica categoria persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaModelImpl.FINDER_CACHE_ENABLED,
			RubricaCategoriaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaModelImpl.FINDER_CACHE_ENABLED,
			RubricaCategoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaCategoriaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaCategoriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(RubricaCategoriaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICACATEGORIA =
		"SELECT rubricaCategoria FROM RubricaCategoria rubricaCategoria";

	private static final String _SQL_SELECT_RUBRICACATEGORIA_WHERE_PKS_IN =
		"SELECT rubricaCategoria FROM RubricaCategoria rubricaCategoria WHERE ID_CATEGORIA IN (";

	private static final String _SQL_COUNT_RUBRICACATEGORIA =
		"SELECT COUNT(rubricaCategoria) FROM RubricaCategoria rubricaCategoria";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaCategoria.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaCategoria exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaCategoriaPersistenceImpl.class);

}