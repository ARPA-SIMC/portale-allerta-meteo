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

package allerta.catasto.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.exception.NoSuchSottocategoriaException;
import allerta.catasto.model.Sottocategoria;
import allerta.catasto.model.impl.SottocategoriaImpl;
import allerta.catasto.model.impl.SottocategoriaModelImpl;
import allerta.catasto.service.persistence.SottocategoriaPK;
import allerta.catasto.service.persistence.SottocategoriaPersistence;

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

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sottocategoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SottocategoriaPersistenceImpl
	extends BasePersistenceImpl<Sottocategoria>
	implements SottocategoriaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SottocategoriaUtil</code> to access the sottocategoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SottocategoriaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SottocategoriaPersistenceImpl() {
		setModelClass(Sottocategoria.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

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
	 * Caches the sottocategoria in the entity cache if it is enabled.
	 *
	 * @param sottocategoria the sottocategoria
	 */
	@Override
	public void cacheResult(Sottocategoria sottocategoria) {
		entityCache.putResult(
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaImpl.class, sottocategoria.getPrimaryKey(),
			sottocategoria);

		sottocategoria.resetOriginalValues();
	}

	/**
	 * Caches the sottocategorias in the entity cache if it is enabled.
	 *
	 * @param sottocategorias the sottocategorias
	 */
	@Override
	public void cacheResult(List<Sottocategoria> sottocategorias) {
		for (Sottocategoria sottocategoria : sottocategorias) {
			if (entityCache.getResult(
					SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
					SottocategoriaImpl.class, sottocategoria.getPrimaryKey()) ==
						null) {

				cacheResult(sottocategoria);
			}
			else {
				sottocategoria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sottocategorias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SottocategoriaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sottocategoria.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sottocategoria sottocategoria) {
		entityCache.removeResult(
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaImpl.class, sottocategoria.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sottocategoria> sottocategorias) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sottocategoria sottocategoria : sottocategorias) {
			entityCache.removeResult(
				SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
				SottocategoriaImpl.class, sottocategoria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sottocategoria with the primary key. Does not add the sottocategoria to the database.
	 *
	 * @param sottocategoriaPK the primary key for the new sottocategoria
	 * @return the new sottocategoria
	 */
	@Override
	public Sottocategoria create(SottocategoriaPK sottocategoriaPK) {
		Sottocategoria sottocategoria = new SottocategoriaImpl();

		sottocategoria.setNew(true);
		sottocategoria.setPrimaryKey(sottocategoriaPK);

		return sottocategoria;
	}

	/**
	 * Removes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria remove(SottocategoriaPK sottocategoriaPK)
		throws NoSuchSottocategoriaException {

		return remove((Serializable)sottocategoriaPK);
	}

	/**
	 * Removes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria remove(Serializable primaryKey)
		throws NoSuchSottocategoriaException {

		Session session = null;

		try {
			session = openSession();

			Sottocategoria sottocategoria = (Sottocategoria)session.get(
				SottocategoriaImpl.class, primaryKey);

			if (sottocategoria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSottocategoriaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sottocategoria);
		}
		catch (NoSuchSottocategoriaException nsee) {
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
	protected Sottocategoria removeImpl(Sottocategoria sottocategoria) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sottocategoria)) {
				sottocategoria = (Sottocategoria)session.get(
					SottocategoriaImpl.class,
					sottocategoria.getPrimaryKeyObj());
			}

			if (sottocategoria != null) {
				session.delete(sottocategoria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sottocategoria != null) {
			clearCache(sottocategoria);
		}

		return sottocategoria;
	}

	@Override
	public Sottocategoria updateImpl(Sottocategoria sottocategoria) {
		boolean isNew = sottocategoria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sottocategoria.isNew()) {
				session.save(sottocategoria);

				sottocategoria.setNew(false);
			}
			else {
				sottocategoria = (Sottocategoria)session.merge(sottocategoria);
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
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaImpl.class, sottocategoria.getPrimaryKey(),
			sottocategoria, false);

		sottocategoria.resetOriginalValues();

		return sottocategoria;
	}

	/**
	 * Returns the sottocategoria with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSottocategoriaException {

		Sottocategoria sottocategoria = fetchByPrimaryKey(primaryKey);

		if (sottocategoria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSottocategoriaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sottocategoria;
	}

	/**
	 * Returns the sottocategoria with the primary key or throws a <code>NoSuchSottocategoriaException</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria findByPrimaryKey(SottocategoriaPK sottocategoriaPK)
		throws NoSuchSottocategoriaException {

		return findByPrimaryKey((Serializable)sottocategoriaPK);
	}

	/**
	 * Returns the sottocategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sottocategoria
	 * @return the sottocategoria, or <code>null</code> if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Sottocategoria sottocategoria = (Sottocategoria)serializable;

		if (sottocategoria == null) {
			Session session = null;

			try {
				session = openSession();

				sottocategoria = (Sottocategoria)session.get(
					SottocategoriaImpl.class, primaryKey);

				if (sottocategoria != null) {
					cacheResult(sottocategoria);
				}
				else {
					entityCache.putResult(
						SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
						SottocategoriaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
					SottocategoriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sottocategoria;
	}

	/**
	 * Returns the sottocategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria, or <code>null</code> if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria fetchByPrimaryKey(SottocategoriaPK sottocategoriaPK) {
		return fetchByPrimaryKey((Serializable)sottocategoriaPK);
	}

	@Override
	public Map<Serializable, Sottocategoria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Sottocategoria> map =
			new HashMap<Serializable, Sottocategoria>();

		for (Serializable primaryKey : primaryKeys) {
			Sottocategoria sottocategoria = fetchByPrimaryKey(primaryKey);

			if (sottocategoria != null) {
				map.put(primaryKey, sottocategoria);
			}
		}

		return map;
	}

	/**
	 * Returns all the sottocategorias.
	 *
	 * @return the sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @return the range of sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll(
		int start, int end,
		OrderByComparator<Sottocategoria> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll(
		int start, int end, OrderByComparator<Sottocategoria> orderByComparator,
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

		List<Sottocategoria> list = null;

		if (retrieveFromCache) {
			list = (List<Sottocategoria>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SOTTOCATEGORIA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOTTOCATEGORIA;

				if (pagination) {
					sql = sql.concat(SottocategoriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sottocategoria>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Sottocategoria>)QueryUtil.list(
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
	 * Removes all the sottocategorias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Sottocategoria sottocategoria : findAll()) {
			remove(sottocategoria);
		}
	}

	/**
	 * Returns the number of sottocategorias.
	 *
	 * @return the number of sottocategorias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOTTOCATEGORIA);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SottocategoriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sottocategoria persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaModelImpl.FINDER_CACHE_ENABLED,
			SottocategoriaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaModelImpl.FINDER_CACHE_ENABLED,
			SottocategoriaImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			SottocategoriaModelImpl.ENTITY_CACHE_ENABLED,
			SottocategoriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(SottocategoriaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SOTTOCATEGORIA =
		"SELECT sottocategoria FROM Sottocategoria sottocategoria";

	private static final String _SQL_COUNT_SOTTOCATEGORIA =
		"SELECT COUNT(sottocategoria) FROM Sottocategoria sottocategoria";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sottocategoria.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Sottocategoria exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SottocategoriaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"id", "idCategoria"});

}