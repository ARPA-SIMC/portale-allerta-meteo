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

import it.eng.animazione.image.exception.NoSuchelevazioneException;
import it.eng.animazione.image.model.elevazione;
import it.eng.animazione.image.model.impl.elevazioneImpl;
import it.eng.animazione.image.model.impl.elevazioneModelImpl;
import it.eng.animazione.image.service.persistence.elevazionePersistence;

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
 * The persistence implementation for the elevazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class elevazionePersistenceImpl
	extends BasePersistenceImpl<elevazione> implements elevazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>elevazioneUtil</code> to access the elevazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		elevazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public elevazionePersistenceImpl() {
		setModelClass(elevazione.class);

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
	 * Caches the elevazione in the entity cache if it is enabled.
	 *
	 * @param elevazione the elevazione
	 */
	@Override
	public void cacheResult(elevazione elevazione) {
		entityCache.putResult(
			elevazioneModelImpl.ENTITY_CACHE_ENABLED, elevazioneImpl.class,
			elevazione.getPrimaryKey(), elevazione);

		elevazione.resetOriginalValues();
	}

	/**
	 * Caches the elevaziones in the entity cache if it is enabled.
	 *
	 * @param elevaziones the elevaziones
	 */
	@Override
	public void cacheResult(List<elevazione> elevaziones) {
		for (elevazione elevazione : elevaziones) {
			if (entityCache.getResult(
					elevazioneModelImpl.ENTITY_CACHE_ENABLED,
					elevazioneImpl.class, elevazione.getPrimaryKey()) == null) {

				cacheResult(elevazione);
			}
			else {
				elevazione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all elevaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(elevazioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the elevazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(elevazione elevazione) {
		entityCache.removeResult(
			elevazioneModelImpl.ENTITY_CACHE_ENABLED, elevazioneImpl.class,
			elevazione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<elevazione> elevaziones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (elevazione elevazione : elevaziones) {
			entityCache.removeResult(
				elevazioneModelImpl.ENTITY_CACHE_ENABLED, elevazioneImpl.class,
				elevazione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new elevazione with the primary key. Does not add the elevazione to the database.
	 *
	 * @param id the primary key for the new elevazione
	 * @return the new elevazione
	 */
	@Override
	public elevazione create(long id) {
		elevazione elevazione = new elevazioneImpl();

		elevazione.setNew(true);
		elevazione.setPrimaryKey(id);

		return elevazione;
	}

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione remove(long id) throws NoSuchelevazioneException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione remove(Serializable primaryKey)
		throws NoSuchelevazioneException {

		Session session = null;

		try {
			session = openSession();

			elevazione elevazione = (elevazione)session.get(
				elevazioneImpl.class, primaryKey);

			if (elevazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchelevazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(elevazione);
		}
		catch (NoSuchelevazioneException nsee) {
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
	protected elevazione removeImpl(elevazione elevazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(elevazione)) {
				elevazione = (elevazione)session.get(
					elevazioneImpl.class, elevazione.getPrimaryKeyObj());
			}

			if (elevazione != null) {
				session.delete(elevazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (elevazione != null) {
			clearCache(elevazione);
		}

		return elevazione;
	}

	@Override
	public elevazione updateImpl(elevazione elevazione) {
		boolean isNew = elevazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (elevazione.isNew()) {
				session.save(elevazione);

				elevazione.setNew(false);
			}
			else {
				elevazione = (elevazione)session.merge(elevazione);
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
			elevazioneModelImpl.ENTITY_CACHE_ENABLED, elevazioneImpl.class,
			elevazione.getPrimaryKey(), elevazione, false);

		elevazione.resetOriginalValues();

		return elevazione;
	}

	/**
	 * Returns the elevazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchelevazioneException {

		elevazione elevazione = fetchByPrimaryKey(primaryKey);

		if (elevazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchelevazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return elevazione;
	}

	/**
	 * Returns the elevazione with the primary key or throws a <code>NoSuchelevazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione findByPrimaryKey(long id)
		throws NoSuchelevazioneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the elevazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the elevazione
	 * @return the elevazione, or <code>null</code> if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			elevazioneModelImpl.ENTITY_CACHE_ENABLED, elevazioneImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		elevazione elevazione = (elevazione)serializable;

		if (elevazione == null) {
			Session session = null;

			try {
				session = openSession();

				elevazione = (elevazione)session.get(
					elevazioneImpl.class, primaryKey);

				if (elevazione != null) {
					cacheResult(elevazione);
				}
				else {
					entityCache.putResult(
						elevazioneModelImpl.ENTITY_CACHE_ENABLED,
						elevazioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					elevazioneModelImpl.ENTITY_CACHE_ENABLED,
					elevazioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return elevazione;
	}

	/**
	 * Returns the elevazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione, or <code>null</code> if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, elevazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, elevazione> map =
			new HashMap<Serializable, elevazione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			elevazione elevazione = fetchByPrimaryKey(primaryKey);

			if (elevazione != null) {
				map.put(primaryKey, elevazione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				elevazioneModelImpl.ENTITY_CACHE_ENABLED, elevazioneImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (elevazione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ELEVAZIONE_WHERE_PKS_IN);

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

			for (elevazione elevazione : (List<elevazione>)q.list()) {
				map.put(elevazione.getPrimaryKeyObj(), elevazione);

				cacheResult(elevazione);

				uncachedPrimaryKeys.remove(elevazione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					elevazioneModelImpl.ENTITY_CACHE_ENABLED,
					elevazioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the elevaziones.
	 *
	 * @return the elevaziones
	 */
	@Override
	public List<elevazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @return the range of elevaziones
	 */
	@Override
	public List<elevazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of elevaziones
	 */
	@Override
	public List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of elevaziones
	 */
	@Override
	public List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator,
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

		List<elevazione> list = null;

		if (retrieveFromCache) {
			list = (List<elevazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ELEVAZIONE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ELEVAZIONE;

				if (pagination) {
					sql = sql.concat(elevazioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<elevazione>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<elevazione>)QueryUtil.list(
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
	 * Removes all the elevaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (elevazione elevazione : findAll()) {
			remove(elevazione);
		}
	}

	/**
	 * Returns the number of elevaziones.
	 *
	 * @return the number of elevaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ELEVAZIONE);

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
		return elevazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the elevazione persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			elevazioneModelImpl.ENTITY_CACHE_ENABLED,
			elevazioneModelImpl.FINDER_CACHE_ENABLED, elevazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			elevazioneModelImpl.ENTITY_CACHE_ENABLED,
			elevazioneModelImpl.FINDER_CACHE_ENABLED, elevazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			elevazioneModelImpl.ENTITY_CACHE_ENABLED,
			elevazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(elevazioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ELEVAZIONE =
		"SELECT elevazione FROM elevazione elevazione";

	private static final String _SQL_SELECT_ELEVAZIONE_WHERE_PKS_IN =
		"SELECT elevazione FROM elevazione elevazione WHERE id_ IN (";

	private static final String _SQL_COUNT_ELEVAZIONE =
		"SELECT COUNT(elevazione) FROM elevazione elevazione";

	private static final String _ORDER_BY_ENTITY_ALIAS = "elevazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No elevazione exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		elevazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

}