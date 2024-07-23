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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaAdriacException;
import it.eng.animazione.image.model.altezzaOndaAdriac;
import it.eng.animazione.image.model.impl.altezzaOndaAdriacImpl;
import it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl;
import it.eng.animazione.image.service.persistence.altezzaOndaAdriacPersistence;

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
 * The persistence implementation for the altezza onda adriac service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class altezzaOndaAdriacPersistenceImpl
	extends BasePersistenceImpl<altezzaOndaAdriac>
	implements altezzaOndaAdriacPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>altezzaOndaAdriacUtil</code> to access the altezza onda adriac persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		altezzaOndaAdriacImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public altezzaOndaAdriacPersistenceImpl() {
		setModelClass(altezzaOndaAdriac.class);

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
	 * Caches the altezza onda adriac in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 */
	@Override
	public void cacheResult(altezzaOndaAdriac altezzaOndaAdriac) {
		entityCache.putResult(
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacImpl.class, altezzaOndaAdriac.getPrimaryKey(),
			altezzaOndaAdriac);

		altezzaOndaAdriac.resetOriginalValues();
	}

	/**
	 * Caches the altezza onda adriacs in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriacs the altezza onda adriacs
	 */
	@Override
	public void cacheResult(List<altezzaOndaAdriac> altezzaOndaAdriacs) {
		for (altezzaOndaAdriac altezzaOndaAdriac : altezzaOndaAdriacs) {
			if (entityCache.getResult(
					altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaAdriacImpl.class,
					altezzaOndaAdriac.getPrimaryKey()) == null) {

				cacheResult(altezzaOndaAdriac);
			}
			else {
				altezzaOndaAdriac.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all altezza onda adriacs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(altezzaOndaAdriacImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the altezza onda adriac.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(altezzaOndaAdriac altezzaOndaAdriac) {
		entityCache.removeResult(
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacImpl.class, altezzaOndaAdriac.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<altezzaOndaAdriac> altezzaOndaAdriacs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (altezzaOndaAdriac altezzaOndaAdriac : altezzaOndaAdriacs) {
			entityCache.removeResult(
				altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
				altezzaOndaAdriacImpl.class, altezzaOndaAdriac.getPrimaryKey());
		}
	}

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	@Override
	public altezzaOndaAdriac create(long id) {
		altezzaOndaAdriac altezzaOndaAdriac = new altezzaOndaAdriacImpl();

		altezzaOndaAdriac.setNew(true);
		altezzaOndaAdriac.setPrimaryKey(id);

		return altezzaOndaAdriac;
	}

	/**
	 * Removes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac remove(long id)
		throws NoSuchaltezzaOndaAdriacException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac remove(Serializable primaryKey)
		throws NoSuchaltezzaOndaAdriacException {

		Session session = null;

		try {
			session = openSession();

			altezzaOndaAdriac altezzaOndaAdriac =
				(altezzaOndaAdriac)session.get(
					altezzaOndaAdriacImpl.class, primaryKey);

			if (altezzaOndaAdriac == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaltezzaOndaAdriacException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(altezzaOndaAdriac);
		}
		catch (NoSuchaltezzaOndaAdriacException nsee) {
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
	protected altezzaOndaAdriac removeImpl(
		altezzaOndaAdriac altezzaOndaAdriac) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(altezzaOndaAdriac)) {
				altezzaOndaAdriac = (altezzaOndaAdriac)session.get(
					altezzaOndaAdriacImpl.class,
					altezzaOndaAdriac.getPrimaryKeyObj());
			}

			if (altezzaOndaAdriac != null) {
				session.delete(altezzaOndaAdriac);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (altezzaOndaAdriac != null) {
			clearCache(altezzaOndaAdriac);
		}

		return altezzaOndaAdriac;
	}

	@Override
	public altezzaOndaAdriac updateImpl(altezzaOndaAdriac altezzaOndaAdriac) {
		boolean isNew = altezzaOndaAdriac.isNew();

		Session session = null;

		try {
			session = openSession();

			if (altezzaOndaAdriac.isNew()) {
				session.save(altezzaOndaAdriac);

				altezzaOndaAdriac.setNew(false);
			}
			else {
				altezzaOndaAdriac = (altezzaOndaAdriac)session.merge(
					altezzaOndaAdriac);
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
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacImpl.class, altezzaOndaAdriac.getPrimaryKey(),
			altezzaOndaAdriac, false);

		altezzaOndaAdriac.resetOriginalValues();

		return altezzaOndaAdriac;
	}

	/**
	 * Returns the altezza onda adriac with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaltezzaOndaAdriacException {

		altezzaOndaAdriac altezzaOndaAdriac = fetchByPrimaryKey(primaryKey);

		if (altezzaOndaAdriac == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaltezzaOndaAdriacException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return altezzaOndaAdriac;
	}

	/**
	 * Returns the altezza onda adriac with the primary key or throws a <code>NoSuchaltezzaOndaAdriacException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaAdriacException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the altezza onda adriac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda adriac
	 * @return the altezza onda adriac, or <code>null</code> if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		altezzaOndaAdriac altezzaOndaAdriac = (altezzaOndaAdriac)serializable;

		if (altezzaOndaAdriac == null) {
			Session session = null;

			try {
				session = openSession();

				altezzaOndaAdriac = (altezzaOndaAdriac)session.get(
					altezzaOndaAdriacImpl.class, primaryKey);

				if (altezzaOndaAdriac != null) {
					cacheResult(altezzaOndaAdriac);
				}
				else {
					entityCache.putResult(
						altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
						altezzaOndaAdriacImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaAdriacImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return altezzaOndaAdriac;
	}

	/**
	 * Returns the altezza onda adriac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac, or <code>null</code> if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, altezzaOndaAdriac> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, altezzaOndaAdriac> map =
			new HashMap<Serializable, altezzaOndaAdriac>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			altezzaOndaAdriac altezzaOndaAdriac = fetchByPrimaryKey(primaryKey);

			if (altezzaOndaAdriac != null) {
				map.put(primaryKey, altezzaOndaAdriac);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
				altezzaOndaAdriacImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (altezzaOndaAdriac)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ALTEZZAONDAADRIAC_WHERE_PKS_IN);

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

			for (altezzaOndaAdriac altezzaOndaAdriac :
					(List<altezzaOndaAdriac>)q.list()) {

				map.put(
					altezzaOndaAdriac.getPrimaryKeyObj(), altezzaOndaAdriac);

				cacheResult(altezzaOndaAdriac);

				uncachedPrimaryKeys.remove(
					altezzaOndaAdriac.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaAdriacImpl.class, primaryKey, nullModel);
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
	 * Returns all the altezza onda adriacs.
	 *
	 * @return the altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator,
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

		List<altezzaOndaAdriac> list = null;

		if (retrieveFromCache) {
			list = (List<altezzaOndaAdriac>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALTEZZAONDAADRIAC);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALTEZZAONDAADRIAC;

				if (pagination) {
					sql = sql.concat(altezzaOndaAdriacModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<altezzaOndaAdriac>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<altezzaOndaAdriac>)QueryUtil.list(
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
	 * Removes all the altezza onda adriacs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (altezzaOndaAdriac altezzaOndaAdriac : findAll()) {
			remove(altezzaOndaAdriac);
		}
	}

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALTEZZAONDAADRIAC);

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
		return altezzaOndaAdriacModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the altezza onda adriac persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacModelImpl.FINDER_CACHE_ENABLED,
			altezzaOndaAdriacImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacModelImpl.FINDER_CACHE_ENABLED,
			altezzaOndaAdriacImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			altezzaOndaAdriacModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaAdriacModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(altezzaOndaAdriacImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALTEZZAONDAADRIAC =
		"SELECT altezzaOndaAdriac FROM altezzaOndaAdriac altezzaOndaAdriac";

	private static final String _SQL_SELECT_ALTEZZAONDAADRIAC_WHERE_PKS_IN =
		"SELECT altezzaOndaAdriac FROM altezzaOndaAdriac altezzaOndaAdriac WHERE id_ IN (";

	private static final String _SQL_COUNT_ALTEZZAONDAADRIAC =
		"SELECT COUNT(altezzaOndaAdriac) FROM altezzaOndaAdriac altezzaOndaAdriac";

	private static final String _ORDER_BY_ENTITY_ALIAS = "altezzaOndaAdriac.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No altezzaOndaAdriac exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		altezzaOndaAdriacPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

}