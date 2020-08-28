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

import it.eng.allerte.exception.NoSuchRubricaUtenteSitoException;
import it.eng.allerte.model.RubricaUtenteSito;
import it.eng.allerte.model.impl.RubricaUtenteSitoImpl;
import it.eng.allerte.model.impl.RubricaUtenteSitoModelImpl;
import it.eng.allerte.service.persistence.RubricaUtenteSitoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica utente sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaUtenteSitoPersistenceImpl
	extends BasePersistenceImpl<RubricaUtenteSito>
	implements RubricaUtenteSitoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaUtenteSitoUtil</code> to access the rubrica utente sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaUtenteSitoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaUtenteSitoPersistenceImpl() {
		setModelClass(RubricaUtenteSito.class);
	}

	/**
	 * Caches the rubrica utente sito in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 */
	@Override
	public void cacheResult(RubricaUtenteSito rubricaUtenteSito) {
		entityCache.putResult(
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoImpl.class, rubricaUtenteSito.getPrimaryKey(),
			rubricaUtenteSito);

		rubricaUtenteSito.resetOriginalValues();
	}

	/**
	 * Caches the rubrica utente sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSitos the rubrica utente sitos
	 */
	@Override
	public void cacheResult(List<RubricaUtenteSito> rubricaUtenteSitos) {
		for (RubricaUtenteSito rubricaUtenteSito : rubricaUtenteSitos) {
			if (entityCache.getResult(
					RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaUtenteSitoImpl.class,
					rubricaUtenteSito.getPrimaryKey()) == null) {

				cacheResult(rubricaUtenteSito);
			}
			else {
				rubricaUtenteSito.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica utente sitos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaUtenteSitoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica utente sito.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaUtenteSito rubricaUtenteSito) {
		entityCache.removeResult(
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoImpl.class, rubricaUtenteSito.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaUtenteSito> rubricaUtenteSitos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaUtenteSito rubricaUtenteSito : rubricaUtenteSitos) {
			entityCache.removeResult(
				RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaUtenteSitoImpl.class, rubricaUtenteSito.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica utente sito with the primary key. Does not add the rubrica utente sito to the database.
	 *
	 * @param ID_UTENTE the primary key for the new rubrica utente sito
	 * @return the new rubrica utente sito
	 */
	@Override
	public RubricaUtenteSito create(long ID_UTENTE) {
		RubricaUtenteSito rubricaUtenteSito = new RubricaUtenteSitoImpl();

		rubricaUtenteSito.setNew(true);
		rubricaUtenteSito.setPrimaryKey(ID_UTENTE);

		return rubricaUtenteSito;
	}

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito remove(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException {

		return remove((Serializable)ID_UTENTE);
	}

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito remove(Serializable primaryKey)
		throws NoSuchRubricaUtenteSitoException {

		Session session = null;

		try {
			session = openSession();

			RubricaUtenteSito rubricaUtenteSito =
				(RubricaUtenteSito)session.get(
					RubricaUtenteSitoImpl.class, primaryKey);

			if (rubricaUtenteSito == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaUtenteSitoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaUtenteSito);
		}
		catch (NoSuchRubricaUtenteSitoException nsee) {
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
	protected RubricaUtenteSito removeImpl(
		RubricaUtenteSito rubricaUtenteSito) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaUtenteSito)) {
				rubricaUtenteSito = (RubricaUtenteSito)session.get(
					RubricaUtenteSitoImpl.class,
					rubricaUtenteSito.getPrimaryKeyObj());
			}

			if (rubricaUtenteSito != null) {
				session.delete(rubricaUtenteSito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaUtenteSito != null) {
			clearCache(rubricaUtenteSito);
		}

		return rubricaUtenteSito;
	}

	@Override
	public RubricaUtenteSito updateImpl(RubricaUtenteSito rubricaUtenteSito) {
		boolean isNew = rubricaUtenteSito.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rubricaUtenteSito.isNew()) {
				session.save(rubricaUtenteSito);

				rubricaUtenteSito.setNew(false);
			}
			else {
				rubricaUtenteSito = (RubricaUtenteSito)session.merge(
					rubricaUtenteSito);
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
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoImpl.class, rubricaUtenteSito.getPrimaryKey(),
			rubricaUtenteSito, false);

		rubricaUtenteSito.resetOriginalValues();

		return rubricaUtenteSito;
	}

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaUtenteSitoException {

		RubricaUtenteSito rubricaUtenteSito = fetchByPrimaryKey(primaryKey);

		if (rubricaUtenteSito == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaUtenteSitoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaUtenteSito;
	}

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>NoSuchRubricaUtenteSitoException</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito findByPrimaryKey(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException {

		return findByPrimaryKey((Serializable)ID_UTENTE);
	}

	/**
	 * Returns the rubrica utente sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica utente sito
	 * @return the rubrica utente sito, or <code>null</code> if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaUtenteSito rubricaUtenteSito = (RubricaUtenteSito)serializable;

		if (rubricaUtenteSito == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaUtenteSito = (RubricaUtenteSito)session.get(
					RubricaUtenteSitoImpl.class, primaryKey);

				if (rubricaUtenteSito != null) {
					cacheResult(rubricaUtenteSito);
				}
				else {
					entityCache.putResult(
						RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
						RubricaUtenteSitoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaUtenteSitoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaUtenteSito;
	}

	/**
	 * Returns the rubrica utente sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito, or <code>null</code> if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito fetchByPrimaryKey(long ID_UTENTE) {
		return fetchByPrimaryKey((Serializable)ID_UTENTE);
	}

	@Override
	public Map<Serializable, RubricaUtenteSito> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaUtenteSito> map =
			new HashMap<Serializable, RubricaUtenteSito>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaUtenteSito rubricaUtenteSito = fetchByPrimaryKey(primaryKey);

			if (rubricaUtenteSito != null) {
				map.put(primaryKey, rubricaUtenteSito);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaUtenteSitoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaUtenteSito)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICAUTENTESITO_WHERE_PKS_IN);

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

			for (RubricaUtenteSito rubricaUtenteSito :
					(List<RubricaUtenteSito>)q.list()) {

				map.put(
					rubricaUtenteSito.getPrimaryKeyObj(), rubricaUtenteSito);

				cacheResult(rubricaUtenteSito);

				uncachedPrimaryKeys.remove(
					rubricaUtenteSito.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaUtenteSitoImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica utente sitos.
	 *
	 * @return the rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @return the range of rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll(
		int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll(
		int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator,
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

		List<RubricaUtenteSito> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaUtenteSito>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICAUTENTESITO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAUTENTESITO;

				if (pagination) {
					sql = sql.concat(RubricaUtenteSitoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaUtenteSito>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaUtenteSito>)QueryUtil.list(
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
	 * Removes all the rubrica utente sitos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaUtenteSito rubricaUtenteSito : findAll()) {
			remove(rubricaUtenteSito);
		}
	}

	/**
	 * Returns the number of rubrica utente sitos.
	 *
	 * @return the number of rubrica utente sitos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICAUTENTESITO);

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
		return RubricaUtenteSitoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica utente sito persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoModelImpl.FINDER_CACHE_ENABLED,
			RubricaUtenteSitoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoModelImpl.FINDER_CACHE_ENABLED,
			RubricaUtenteSitoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaUtenteSitoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaUtenteSitoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(RubricaUtenteSitoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICAUTENTESITO =
		"SELECT rubricaUtenteSito FROM RubricaUtenteSito rubricaUtenteSito";

	private static final String _SQL_SELECT_RUBRICAUTENTESITO_WHERE_PKS_IN =
		"SELECT rubricaUtenteSito FROM RubricaUtenteSito rubricaUtenteSito WHERE ID_UTENTE IN (";

	private static final String _SQL_COUNT_RUBRICAUTENTESITO =
		"SELECT COUNT(rubricaUtenteSito) FROM RubricaUtenteSito rubricaUtenteSito";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaUtenteSito.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaUtenteSito exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaUtenteSitoPersistenceImpl.class);

}