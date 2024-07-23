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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaSwanitaException;
import it.eng.animazione.image.model.altezzaOndaSwanita;
import it.eng.animazione.image.model.impl.altezzaOndaSwanitaImpl;
import it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl;
import it.eng.animazione.image.service.persistence.altezzaOndaSwanitaPersistence;

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
 * The persistence implementation for the altezza onda swanita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class altezzaOndaSwanitaPersistenceImpl
	extends BasePersistenceImpl<altezzaOndaSwanita>
	implements altezzaOndaSwanitaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>altezzaOndaSwanitaUtil</code> to access the altezza onda swanita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		altezzaOndaSwanitaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public altezzaOndaSwanitaPersistenceImpl() {
		setModelClass(altezzaOndaSwanita.class);

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
	 * Caches the altezza onda swanita in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 */
	@Override
	public void cacheResult(altezzaOndaSwanita altezzaOndaSwanita) {
		entityCache.putResult(
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaImpl.class, altezzaOndaSwanita.getPrimaryKey(),
			altezzaOndaSwanita);

		altezzaOndaSwanita.resetOriginalValues();
	}

	/**
	 * Caches the altezza onda swanitas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanitas the altezza onda swanitas
	 */
	@Override
	public void cacheResult(List<altezzaOndaSwanita> altezzaOndaSwanitas) {
		for (altezzaOndaSwanita altezzaOndaSwanita : altezzaOndaSwanitas) {
			if (entityCache.getResult(
					altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaSwanitaImpl.class,
					altezzaOndaSwanita.getPrimaryKey()) == null) {

				cacheResult(altezzaOndaSwanita);
			}
			else {
				altezzaOndaSwanita.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all altezza onda swanitas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(altezzaOndaSwanitaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the altezza onda swanita.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(altezzaOndaSwanita altezzaOndaSwanita) {
		entityCache.removeResult(
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaImpl.class, altezzaOndaSwanita.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<altezzaOndaSwanita> altezzaOndaSwanitas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (altezzaOndaSwanita altezzaOndaSwanita : altezzaOndaSwanitas) {
			entityCache.removeResult(
				altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
				altezzaOndaSwanitaImpl.class,
				altezzaOndaSwanita.getPrimaryKey());
		}
	}

	/**
	 * Creates a new altezza onda swanita with the primary key. Does not add the altezza onda swanita to the database.
	 *
	 * @param id the primary key for the new altezza onda swanita
	 * @return the new altezza onda swanita
	 */
	@Override
	public altezzaOndaSwanita create(long id) {
		altezzaOndaSwanita altezzaOndaSwanita = new altezzaOndaSwanitaImpl();

		altezzaOndaSwanita.setNew(true);
		altezzaOndaSwanita.setPrimaryKey(id);

		return altezzaOndaSwanita;
	}

	/**
	 * Removes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita remove(long id)
		throws NoSuchaltezzaOndaSwanitaException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita remove(Serializable primaryKey)
		throws NoSuchaltezzaOndaSwanitaException {

		Session session = null;

		try {
			session = openSession();

			altezzaOndaSwanita altezzaOndaSwanita =
				(altezzaOndaSwanita)session.get(
					altezzaOndaSwanitaImpl.class, primaryKey);

			if (altezzaOndaSwanita == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaltezzaOndaSwanitaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(altezzaOndaSwanita);
		}
		catch (NoSuchaltezzaOndaSwanitaException nsee) {
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
	protected altezzaOndaSwanita removeImpl(
		altezzaOndaSwanita altezzaOndaSwanita) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(altezzaOndaSwanita)) {
				altezzaOndaSwanita = (altezzaOndaSwanita)session.get(
					altezzaOndaSwanitaImpl.class,
					altezzaOndaSwanita.getPrimaryKeyObj());
			}

			if (altezzaOndaSwanita != null) {
				session.delete(altezzaOndaSwanita);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (altezzaOndaSwanita != null) {
			clearCache(altezzaOndaSwanita);
		}

		return altezzaOndaSwanita;
	}

	@Override
	public altezzaOndaSwanita updateImpl(
		altezzaOndaSwanita altezzaOndaSwanita) {

		boolean isNew = altezzaOndaSwanita.isNew();

		Session session = null;

		try {
			session = openSession();

			if (altezzaOndaSwanita.isNew()) {
				session.save(altezzaOndaSwanita);

				altezzaOndaSwanita.setNew(false);
			}
			else {
				altezzaOndaSwanita = (altezzaOndaSwanita)session.merge(
					altezzaOndaSwanita);
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
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaImpl.class, altezzaOndaSwanita.getPrimaryKey(),
			altezzaOndaSwanita, false);

		altezzaOndaSwanita.resetOriginalValues();

		return altezzaOndaSwanita;
	}

	/**
	 * Returns the altezza onda swanita with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaltezzaOndaSwanitaException {

		altezzaOndaSwanita altezzaOndaSwanita = fetchByPrimaryKey(primaryKey);

		if (altezzaOndaSwanita == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaltezzaOndaSwanitaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return altezzaOndaSwanita;
	}

	/**
	 * Returns the altezza onda swanita with the primary key or throws a <code>NoSuchaltezzaOndaSwanitaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaSwanitaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the altezza onda swanita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda swanita
	 * @return the altezza onda swanita, or <code>null</code> if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		altezzaOndaSwanita altezzaOndaSwanita =
			(altezzaOndaSwanita)serializable;

		if (altezzaOndaSwanita == null) {
			Session session = null;

			try {
				session = openSession();

				altezzaOndaSwanita = (altezzaOndaSwanita)session.get(
					altezzaOndaSwanitaImpl.class, primaryKey);

				if (altezzaOndaSwanita != null) {
					cacheResult(altezzaOndaSwanita);
				}
				else {
					entityCache.putResult(
						altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
						altezzaOndaSwanitaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaSwanitaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return altezzaOndaSwanita;
	}

	/**
	 * Returns the altezza onda swanita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita, or <code>null</code> if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, altezzaOndaSwanita> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, altezzaOndaSwanita> map =
			new HashMap<Serializable, altezzaOndaSwanita>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			altezzaOndaSwanita altezzaOndaSwanita = fetchByPrimaryKey(
				primaryKey);

			if (altezzaOndaSwanita != null) {
				map.put(primaryKey, altezzaOndaSwanita);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
				altezzaOndaSwanitaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (altezzaOndaSwanita)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ALTEZZAONDASWANITA_WHERE_PKS_IN);

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

			for (altezzaOndaSwanita altezzaOndaSwanita :
					(List<altezzaOndaSwanita>)q.list()) {

				map.put(
					altezzaOndaSwanita.getPrimaryKeyObj(), altezzaOndaSwanita);

				cacheResult(altezzaOndaSwanita);

				uncachedPrimaryKeys.remove(
					altezzaOndaSwanita.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
					altezzaOndaSwanitaImpl.class, primaryKey, nullModel);
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
	 * Returns all the altezza onda swanitas.
	 *
	 * @return the altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @return the range of altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator,
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

		List<altezzaOndaSwanita> list = null;

		if (retrieveFromCache) {
			list = (List<altezzaOndaSwanita>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALTEZZAONDASWANITA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALTEZZAONDASWANITA;

				if (pagination) {
					sql = sql.concat(altezzaOndaSwanitaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<altezzaOndaSwanita>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<altezzaOndaSwanita>)QueryUtil.list(
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
	 * Removes all the altezza onda swanitas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (altezzaOndaSwanita altezzaOndaSwanita : findAll()) {
			remove(altezzaOndaSwanita);
		}
	}

	/**
	 * Returns the number of altezza onda swanitas.
	 *
	 * @return the number of altezza onda swanitas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALTEZZAONDASWANITA);

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
		return altezzaOndaSwanitaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the altezza onda swanita persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaModelImpl.FINDER_CACHE_ENABLED,
			altezzaOndaSwanitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaModelImpl.FINDER_CACHE_ENABLED,
			altezzaOndaSwanitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			altezzaOndaSwanitaModelImpl.ENTITY_CACHE_ENABLED,
			altezzaOndaSwanitaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(altezzaOndaSwanitaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALTEZZAONDASWANITA =
		"SELECT altezzaOndaSwanita FROM altezzaOndaSwanita altezzaOndaSwanita";

	private static final String _SQL_SELECT_ALTEZZAONDASWANITA_WHERE_PKS_IN =
		"SELECT altezzaOndaSwanita FROM altezzaOndaSwanita altezzaOndaSwanita WHERE id_ IN (";

	private static final String _SQL_COUNT_ALTEZZAONDASWANITA =
		"SELECT COUNT(altezzaOndaSwanita) FROM altezzaOndaSwanita altezzaOndaSwanita";

	private static final String _ORDER_BY_ENTITY_ALIAS = "altezzaOndaSwanita.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No altezzaOndaSwanita exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		altezzaOndaSwanitaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

}