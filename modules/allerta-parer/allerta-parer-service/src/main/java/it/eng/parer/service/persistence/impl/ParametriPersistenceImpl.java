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

package it.eng.parer.service.persistence.impl;

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

import it.eng.parer.exception.NoSuchParametriException;
import it.eng.parer.model.Parametri;
import it.eng.parer.model.impl.ParametriImpl;
import it.eng.parer.model.impl.ParametriModelImpl;
import it.eng.parer.service.persistence.ParametriPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the parametri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class ParametriPersistenceImpl
	extends BasePersistenceImpl<Parametri> implements ParametriPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParametriUtil</code> to access the parametri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParametriImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ParametriPersistenceImpl() {
		setModelClass(Parametri.class);
	}

	/**
	 * Caches the parametri in the entity cache if it is enabled.
	 *
	 * @param parametri the parametri
	 */
	@Override
	public void cacheResult(Parametri parametri) {
		entityCache.putResult(
			ParametriModelImpl.ENTITY_CACHE_ENABLED, ParametriImpl.class,
			parametri.getPrimaryKey(), parametri);

		parametri.resetOriginalValues();
	}

	/**
	 * Caches the parametris in the entity cache if it is enabled.
	 *
	 * @param parametris the parametris
	 */
	@Override
	public void cacheResult(List<Parametri> parametris) {
		for (Parametri parametri : parametris) {
			if (entityCache.getResult(
					ParametriModelImpl.ENTITY_CACHE_ENABLED,
					ParametriImpl.class, parametri.getPrimaryKey()) == null) {

				cacheResult(parametri);
			}
			else {
				parametri.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all parametris.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParametriImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the parametri.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametri parametri) {
		entityCache.removeResult(
			ParametriModelImpl.ENTITY_CACHE_ENABLED, ParametriImpl.class,
			parametri.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Parametri> parametris) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Parametri parametri : parametris) {
			entityCache.removeResult(
				ParametriModelImpl.ENTITY_CACHE_ENABLED, ParametriImpl.class,
				parametri.getPrimaryKey());
		}
	}

	/**
	 * Creates a new parametri with the primary key. Does not add the parametri to the database.
	 *
	 * @param chiave the primary key for the new parametri
	 * @return the new parametri
	 */
	@Override
	public Parametri create(String chiave) {
		Parametri parametri = new ParametriImpl();

		parametri.setNew(true);
		parametri.setPrimaryKey(chiave);

		return parametri;
	}

	/**
	 * Removes the parametri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri that was removed
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri remove(String chiave) throws NoSuchParametriException {
		return remove((Serializable)chiave);
	}

	/**
	 * Removes the parametri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametri
	 * @return the parametri that was removed
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri remove(Serializable primaryKey)
		throws NoSuchParametriException {

		Session session = null;

		try {
			session = openSession();

			Parametri parametri = (Parametri)session.get(
				ParametriImpl.class, primaryKey);

			if (parametri == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametriException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(parametri);
		}
		catch (NoSuchParametriException nsee) {
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
	protected Parametri removeImpl(Parametri parametri) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parametri)) {
				parametri = (Parametri)session.get(
					ParametriImpl.class, parametri.getPrimaryKeyObj());
			}

			if (parametri != null) {
				session.delete(parametri);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (parametri != null) {
			clearCache(parametri);
		}

		return parametri;
	}

	@Override
	public Parametri updateImpl(Parametri parametri) {
		boolean isNew = parametri.isNew();

		Session session = null;

		try {
			session = openSession();

			if (parametri.isNew()) {
				session.save(parametri);

				parametri.setNew(false);
			}
			else {
				parametri = (Parametri)session.merge(parametri);
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
			ParametriModelImpl.ENTITY_CACHE_ENABLED, ParametriImpl.class,
			parametri.getPrimaryKey(), parametri, false);

		parametri.resetOriginalValues();

		return parametri;
	}

	/**
	 * Returns the parametri with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametri
	 * @return the parametri
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParametriException {

		Parametri parametri = fetchByPrimaryKey(primaryKey);

		if (parametri == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParametriException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return parametri;
	}

	/**
	 * Returns the parametri with the primary key or throws a <code>NoSuchParametriException</code> if it could not be found.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri findByPrimaryKey(String chiave)
		throws NoSuchParametriException {

		return findByPrimaryKey((Serializable)chiave);
	}

	/**
	 * Returns the parametri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametri
	 * @return the parametri, or <code>null</code> if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ParametriModelImpl.ENTITY_CACHE_ENABLED, ParametriImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Parametri parametri = (Parametri)serializable;

		if (parametri == null) {
			Session session = null;

			try {
				session = openSession();

				parametri = (Parametri)session.get(
					ParametriImpl.class, primaryKey);

				if (parametri != null) {
					cacheResult(parametri);
				}
				else {
					entityCache.putResult(
						ParametriModelImpl.ENTITY_CACHE_ENABLED,
						ParametriImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ParametriModelImpl.ENTITY_CACHE_ENABLED,
					ParametriImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return parametri;
	}

	/**
	 * Returns the parametri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri, or <code>null</code> if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri fetchByPrimaryKey(String chiave) {
		return fetchByPrimaryKey((Serializable)chiave);
	}

	@Override
	public Map<Serializable, Parametri> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Parametri> map =
			new HashMap<Serializable, Parametri>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Parametri parametri = fetchByPrimaryKey(primaryKey);

			if (parametri != null) {
				map.put(primaryKey, parametri);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ParametriModelImpl.ENTITY_CACHE_ENABLED, ParametriImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Parametri)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PARAMETRI_WHERE_PKS_IN);

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

			for (Parametri parametri : (List<Parametri>)q.list()) {
				map.put(parametri.getPrimaryKeyObj(), parametri);

				cacheResult(parametri);

				uncachedPrimaryKeys.remove(parametri.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ParametriModelImpl.ENTITY_CACHE_ENABLED,
					ParametriImpl.class, primaryKey, nullModel);
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
	 * Returns all the parametris.
	 *
	 * @return the parametris
	 */
	@Override
	public List<Parametri> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @return the range of parametris
	 */
	@Override
	public List<Parametri> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametris
	 */
	@Override
	public List<Parametri> findAll(
		int start, int end, OrderByComparator<Parametri> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of parametris
	 */
	@Override
	public List<Parametri> findAll(
		int start, int end, OrderByComparator<Parametri> orderByComparator,
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

		List<Parametri> list = null;

		if (retrieveFromCache) {
			list = (List<Parametri>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PARAMETRI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETRI;

				if (pagination) {
					sql = sql.concat(ParametriModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Parametri>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Parametri>)QueryUtil.list(
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
	 * Removes all the parametris from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Parametri parametri : findAll()) {
			remove(parametri);
		}
	}

	/**
	 * Returns the number of parametris.
	 *
	 * @return the number of parametris
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PARAMETRI);

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
		return ParametriModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the parametri persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ParametriModelImpl.ENTITY_CACHE_ENABLED,
			ParametriModelImpl.FINDER_CACHE_ENABLED, ParametriImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ParametriModelImpl.ENTITY_CACHE_ENABLED,
			ParametriModelImpl.FINDER_CACHE_ENABLED, ParametriImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ParametriModelImpl.ENTITY_CACHE_ENABLED,
			ParametriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(ParametriImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PARAMETRI =
		"SELECT parametri FROM Parametri parametri";

	private static final String _SQL_SELECT_PARAMETRI_WHERE_PKS_IN =
		"SELECT parametri FROM Parametri parametri WHERE chiave IN (";

	private static final String _SQL_COUNT_PARAMETRI =
		"SELECT COUNT(parametri) FROM Parametri parametri";

	private static final String _ORDER_BY_ENTITY_ALIAS = "parametri.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Parametri exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ParametriPersistenceImpl.class);

}