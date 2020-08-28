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

import it.eng.allerte.exception.NoSuchRubricaRuoloRubricaException;
import it.eng.allerte.model.RubricaRuoloRubrica;
import it.eng.allerte.model.impl.RubricaRuoloRubricaImpl;
import it.eng.allerte.model.impl.RubricaRuoloRubricaModelImpl;
import it.eng.allerte.service.persistence.RubricaRuoloRubricaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica ruolo rubrica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloRubricaPersistenceImpl
	extends BasePersistenceImpl<RubricaRuoloRubrica>
	implements RubricaRuoloRubricaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaRuoloRubricaUtil</code> to access the rubrica ruolo rubrica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaRuoloRubricaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaRuoloRubricaPersistenceImpl() {
		setModelClass(RubricaRuoloRubrica.class);
	}

	/**
	 * Caches the rubrica ruolo rubrica in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 */
	@Override
	public void cacheResult(RubricaRuoloRubrica rubricaRuoloRubrica) {
		entityCache.putResult(
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica.getPrimaryKey(),
			rubricaRuoloRubrica);

		rubricaRuoloRubrica.resetOriginalValues();
	}

	/**
	 * Caches the rubrica ruolo rubricas in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubricas the rubrica ruolo rubricas
	 */
	@Override
	public void cacheResult(List<RubricaRuoloRubrica> rubricaRuoloRubricas) {
		for (RubricaRuoloRubrica rubricaRuoloRubrica : rubricaRuoloRubricas) {
			if (entityCache.getResult(
					RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloRubricaImpl.class,
					rubricaRuoloRubrica.getPrimaryKey()) == null) {

				cacheResult(rubricaRuoloRubrica);
			}
			else {
				rubricaRuoloRubrica.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica ruolo rubricas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaRuoloRubricaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica ruolo rubrica.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaRuoloRubrica rubricaRuoloRubrica) {
		entityCache.removeResult(
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaRuoloRubrica> rubricaRuoloRubricas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaRuoloRubrica rubricaRuoloRubrica : rubricaRuoloRubricas) {
			entityCache.removeResult(
				RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
				RubricaRuoloRubricaImpl.class,
				rubricaRuoloRubrica.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica ruolo rubrica with the primary key. Does not add the rubrica ruolo rubrica to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo rubrica
	 * @return the new rubrica ruolo rubrica
	 */
	@Override
	public RubricaRuoloRubrica create(long ID_RUOLO) {
		RubricaRuoloRubrica rubricaRuoloRubrica = new RubricaRuoloRubricaImpl();

		rubricaRuoloRubrica.setNew(true);
		rubricaRuoloRubrica.setPrimaryKey(ID_RUOLO);

		return rubricaRuoloRubrica;
	}

	/**
	 * Removes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica remove(long ID_RUOLO)
		throws NoSuchRubricaRuoloRubricaException {

		return remove((Serializable)ID_RUOLO);
	}

	/**
	 * Removes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica remove(Serializable primaryKey)
		throws NoSuchRubricaRuoloRubricaException {

		Session session = null;

		try {
			session = openSession();

			RubricaRuoloRubrica rubricaRuoloRubrica =
				(RubricaRuoloRubrica)session.get(
					RubricaRuoloRubricaImpl.class, primaryKey);

			if (rubricaRuoloRubrica == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaRuoloRubricaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaRuoloRubrica);
		}
		catch (NoSuchRubricaRuoloRubricaException nsee) {
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
	protected RubricaRuoloRubrica removeImpl(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaRuoloRubrica)) {
				rubricaRuoloRubrica = (RubricaRuoloRubrica)session.get(
					RubricaRuoloRubricaImpl.class,
					rubricaRuoloRubrica.getPrimaryKeyObj());
			}

			if (rubricaRuoloRubrica != null) {
				session.delete(rubricaRuoloRubrica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaRuoloRubrica != null) {
			clearCache(rubricaRuoloRubrica);
		}

		return rubricaRuoloRubrica;
	}

	@Override
	public RubricaRuoloRubrica updateImpl(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		boolean isNew = rubricaRuoloRubrica.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rubricaRuoloRubrica.isNew()) {
				session.save(rubricaRuoloRubrica);

				rubricaRuoloRubrica.setNew(false);
			}
			else {
				rubricaRuoloRubrica = (RubricaRuoloRubrica)session.merge(
					rubricaRuoloRubrica);
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
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica.getPrimaryKey(),
			rubricaRuoloRubrica, false);

		rubricaRuoloRubrica.resetOriginalValues();

		return rubricaRuoloRubrica;
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaRuoloRubricaException {

		RubricaRuoloRubrica rubricaRuoloRubrica = fetchByPrimaryKey(primaryKey);

		if (rubricaRuoloRubrica == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaRuoloRubricaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaRuoloRubrica;
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or throws a <code>NoSuchRubricaRuoloRubricaException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica findByPrimaryKey(long ID_RUOLO)
		throws NoSuchRubricaRuoloRubricaException {

		return findByPrimaryKey((Serializable)ID_RUOLO);
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica, or <code>null</code> if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaRuoloRubrica rubricaRuoloRubrica =
			(RubricaRuoloRubrica)serializable;

		if (rubricaRuoloRubrica == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaRuoloRubrica = (RubricaRuoloRubrica)session.get(
					RubricaRuoloRubricaImpl.class, primaryKey);

				if (rubricaRuoloRubrica != null) {
					cacheResult(rubricaRuoloRubrica);
				}
				else {
					entityCache.putResult(
						RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
						RubricaRuoloRubricaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloRubricaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaRuoloRubrica;
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica, or <code>null</code> if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica fetchByPrimaryKey(long ID_RUOLO) {
		return fetchByPrimaryKey((Serializable)ID_RUOLO);
	}

	@Override
	public Map<Serializable, RubricaRuoloRubrica> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaRuoloRubrica> map =
			new HashMap<Serializable, RubricaRuoloRubrica>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaRuoloRubrica rubricaRuoloRubrica = fetchByPrimaryKey(
				primaryKey);

			if (rubricaRuoloRubrica != null) {
				map.put(primaryKey, rubricaRuoloRubrica);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
				RubricaRuoloRubricaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaRuoloRubrica)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICARUOLORUBRICA_WHERE_PKS_IN);

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

			for (RubricaRuoloRubrica rubricaRuoloRubrica :
					(List<RubricaRuoloRubrica>)q.list()) {

				map.put(
					rubricaRuoloRubrica.getPrimaryKeyObj(),
					rubricaRuoloRubrica);

				cacheResult(rubricaRuoloRubrica);

				uncachedPrimaryKeys.remove(
					rubricaRuoloRubrica.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloRubricaImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica ruolo rubricas.
	 *
	 * @return the rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @return the range of rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator,
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

		List<RubricaRuoloRubrica> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaRuoloRubrica>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICARUOLORUBRICA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICARUOLORUBRICA;

				if (pagination) {
					sql = sql.concat(
						RubricaRuoloRubricaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaRuoloRubrica>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaRuoloRubrica>)QueryUtil.list(
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
	 * Removes all the rubrica ruolo rubricas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaRuoloRubrica rubricaRuoloRubrica : findAll()) {
			remove(rubricaRuoloRubrica);
		}
	}

	/**
	 * Returns the number of rubrica ruolo rubricas.
	 *
	 * @return the number of rubrica ruolo rubricas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICARUOLORUBRICA);

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
		return RubricaRuoloRubricaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica ruolo rubrica persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaModelImpl.FINDER_CACHE_ENABLED,
			RubricaRuoloRubricaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaModelImpl.FINDER_CACHE_ENABLED,
			RubricaRuoloRubricaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaRuoloRubricaModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloRubricaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(RubricaRuoloRubricaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICARUOLORUBRICA =
		"SELECT rubricaRuoloRubrica FROM RubricaRuoloRubrica rubricaRuoloRubrica";

	private static final String _SQL_SELECT_RUBRICARUOLORUBRICA_WHERE_PKS_IN =
		"SELECT rubricaRuoloRubrica FROM RubricaRuoloRubrica rubricaRuoloRubrica WHERE ID_RUOLO IN (";

	private static final String _SQL_COUNT_RUBRICARUOLORUBRICA =
		"SELECT COUNT(rubricaRuoloRubrica) FROM RubricaRuoloRubrica rubricaRuoloRubrica";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaRuoloRubrica.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaRuoloRubrica exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaRuoloRubricaPersistenceImpl.class);

}