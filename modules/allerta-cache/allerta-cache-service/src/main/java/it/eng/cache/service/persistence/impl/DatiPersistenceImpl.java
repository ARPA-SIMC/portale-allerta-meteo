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

package it.eng.cache.service.persistence.impl;

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

import it.eng.cache.exception.NoSuchDatiException;
import it.eng.cache.model.Dati;
import it.eng.cache.model.impl.DatiImpl;
import it.eng.cache.model.impl.DatiModelImpl;
import it.eng.cache.service.persistence.DatiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the dati service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class DatiPersistenceImpl
	extends BasePersistenceImpl<Dati> implements DatiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DatiUtil</code> to access the dati persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DatiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DatiPersistenceImpl() {
		setModelClass(Dati.class);
	}

	/**
	 * Caches the dati in the entity cache if it is enabled.
	 *
	 * @param dati the dati
	 */
	@Override
	public void cacheResult(Dati dati) {
		entityCache.putResult(
			DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
			dati.getPrimaryKey(), dati);

		dati.resetOriginalValues();
	}

	/**
	 * Caches the datis in the entity cache if it is enabled.
	 *
	 * @param datis the datis
	 */
	@Override
	public void cacheResult(List<Dati> datis) {
		for (Dati dati : datis) {
			if (entityCache.getResult(
					DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
					dati.getPrimaryKey()) == null) {

				cacheResult(dati);
			}
			else {
				dati.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all datis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DatiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dati.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dati dati) {
		entityCache.removeResult(
			DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
			dati.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dati> datis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dati dati : datis) {
			entityCache.removeResult(
				DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
				dati.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dati with the primary key. Does not add the dati to the database.
	 *
	 * @param idDati the primary key for the new dati
	 * @return the new dati
	 */
	@Override
	public Dati create(String idDati) {
		Dati dati = new DatiImpl();

		dati.setNew(true);
		dati.setPrimaryKey(idDati);

		return dati;
	}

	/**
	 * Removes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati that was removed
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati remove(String idDati) throws NoSuchDatiException {
		return remove((Serializable)idDati);
	}

	/**
	 * Removes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dati
	 * @return the dati that was removed
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati remove(Serializable primaryKey) throws NoSuchDatiException {
		Session session = null;

		try {
			session = openSession();

			Dati dati = (Dati)session.get(DatiImpl.class, primaryKey);

			if (dati == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDatiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dati);
		}
		catch (NoSuchDatiException nsee) {
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
	protected Dati removeImpl(Dati dati) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dati)) {
				dati = (Dati)session.get(
					DatiImpl.class, dati.getPrimaryKeyObj());
			}

			if (dati != null) {
				session.delete(dati);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dati != null) {
			clearCache(dati);
		}

		return dati;
	}

	@Override
	public Dati updateImpl(Dati dati) {
		boolean isNew = dati.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dati.isNew()) {
				session.save(dati);

				dati.setNew(false);
			}
			else {
				dati = (Dati)session.merge(dati);
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
			DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
			dati.getPrimaryKey(), dati, false);

		dati.resetOriginalValues();

		return dati;
	}

	/**
	 * Returns the dati with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dati
	 * @return the dati
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDatiException {

		Dati dati = fetchByPrimaryKey(primaryKey);

		if (dati == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDatiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dati;
	}

	/**
	 * Returns the dati with the primary key or throws a <code>NoSuchDatiException</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati findByPrimaryKey(String idDati) throws NoSuchDatiException {
		return findByPrimaryKey((Serializable)idDati);
	}

	/**
	 * Returns the dati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dati
	 * @return the dati, or <code>null</code> if a dati with the primary key could not be found
	 */
	@Override
	public Dati fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Dati dati = (Dati)serializable;

		if (dati == null) {
			Session session = null;

			try {
				session = openSession();

				dati = (Dati)session.get(DatiImpl.class, primaryKey);

				if (dati != null) {
					cacheResult(dati);
				}
				else {
					entityCache.putResult(
						DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dati;
	}

	/**
	 * Returns the dati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati, or <code>null</code> if a dati with the primary key could not be found
	 */
	@Override
	public Dati fetchByPrimaryKey(String idDati) {
		return fetchByPrimaryKey((Serializable)idDati);
	}

	@Override
	public Map<Serializable, Dati> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Dati> map = new HashMap<Serializable, Dati>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Dati dati = fetchByPrimaryKey(primaryKey);

			if (dati != null) {
				map.put(primaryKey, dati);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Dati)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DATI_WHERE_PKS_IN);

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

			for (Dati dati : (List<Dati>)q.list()) {
				map.put(dati.getPrimaryKeyObj(), dati);

				cacheResult(dati);

				uncachedPrimaryKeys.remove(dati.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DatiModelImpl.ENTITY_CACHE_ENABLED, DatiImpl.class,
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
	 * Returns all the datis.
	 *
	 * @return the datis
	 */
	@Override
	public List<Dati> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @return the range of datis
	 */
	@Override
	public List<Dati> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datis
	 */
	@Override
	public List<Dati> findAll(
		int start, int end, OrderByComparator<Dati> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of datis
	 */
	@Override
	public List<Dati> findAll(
		int start, int end, OrderByComparator<Dati> orderByComparator,
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

		List<Dati> list = null;

		if (retrieveFromCache) {
			list = (List<Dati>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATI;

				if (pagination) {
					sql = sql.concat(DatiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dati>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dati>)QueryUtil.list(
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
	 * Removes all the datis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dati dati : findAll()) {
			remove(dati);
		}
	}

	/**
	 * Returns the number of datis.
	 *
	 * @return the number of datis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATI);

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
		return DatiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dati persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DatiModelImpl.ENTITY_CACHE_ENABLED,
			DatiModelImpl.FINDER_CACHE_ENABLED, DatiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DatiModelImpl.ENTITY_CACHE_ENABLED,
			DatiModelImpl.FINDER_CACHE_ENABLED, DatiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DatiModelImpl.ENTITY_CACHE_ENABLED,
			DatiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(DatiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATI = "SELECT dati FROM Dati dati";

	private static final String _SQL_SELECT_DATI_WHERE_PKS_IN =
		"SELECT dati FROM Dati dati WHERE idDati IN (";

	private static final String _SQL_COUNT_DATI =
		"SELECT COUNT(dati) FROM Dati dati";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dati.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Dati exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DatiPersistenceImpl.class);

}