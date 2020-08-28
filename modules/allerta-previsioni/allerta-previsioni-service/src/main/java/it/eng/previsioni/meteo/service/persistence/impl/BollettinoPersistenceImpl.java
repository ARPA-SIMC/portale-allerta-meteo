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

package it.eng.previsioni.meteo.service.persistence.impl;

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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.previsioni.meteo.exception.NoSuchBollettinoException;
import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.model.impl.BollettinoImpl;
import it.eng.previsioni.meteo.model.impl.BollettinoModelImpl;
import it.eng.previsioni.meteo.service.persistence.BollettinoPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the bollettino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class BollettinoPersistenceImpl
	extends BasePersistenceImpl<Bollettino> implements BollettinoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoUtil</code> to access the bollettino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBytipo;
	private FinderPath _finderPathCountBytipo;

	/**
	 * Returns the bollettino where tipo = &#63; or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param tipo the tipo
	 * @return the matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findBytipo(String tipo) throws NoSuchBollettinoException {
		Bollettino bollettino = fetchBytipo(tipo);

		if (bollettino == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tipo=");
			msg.append(tipo);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBollettinoException(msg.toString());
		}

		return bollettino;
	}

	/**
	 * Returns the bollettino where tipo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tipo the tipo
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchBytipo(String tipo) {
		return fetchBytipo(tipo, true);
	}

	/**
	 * Returns the bollettino where tipo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tipo the tipo
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchBytipo(String tipo, boolean retrieveFromCache) {
		tipo = Objects.toString(tipo, "");

		Object[] finderArgs = new Object[] {tipo};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBytipo, finderArgs, this);
		}

		if (result instanceof Bollettino) {
			Bollettino bollettino = (Bollettino)result;

			if (!Objects.equals(tipo, bollettino.getTipo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BOLLETTINO_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPO_TIPO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				List<Bollettino> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBytipo, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"BollettinoPersistenceImpl.fetchBytipo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Bollettino bollettino = list.get(0);

					result = bollettino;

					cacheResult(bollettino);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBytipo, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Bollettino)result;
		}
	}

	/**
	 * Removes the bollettino where tipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @return the bollettino that was removed
	 */
	@Override
	public Bollettino removeBytipo(String tipo)
		throws NoSuchBollettinoException {

		Bollettino bollettino = findBytipo(tipo);

		return remove(bollettino);
	}

	/**
	 * Returns the number of bollettinos where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the number of matching bollettinos
	 */
	@Override
	public int countBytipo(String tipo) {
		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = _finderPathCountBytipo;

		Object[] finderArgs = new Object[] {tipo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOLLETTINO_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPO_TIPO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPO_TIPO_2 =
		"bollettino.tipo = ?";

	private static final String _FINDER_COLUMN_TIPO_TIPO_3 =
		"(bollettino.tipo IS NULL OR bollettino.tipo = '')";

	public BollettinoPersistenceImpl() {
		setModelClass(Bollettino.class);

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
	 * Caches the bollettino in the entity cache if it is enabled.
	 *
	 * @param bollettino the bollettino
	 */
	@Override
	public void cacheResult(Bollettino bollettino) {
		entityCache.putResult(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED, BollettinoImpl.class,
			bollettino.getPrimaryKey(), bollettino);

		finderCache.putResult(
			_finderPathFetchBytipo, new Object[] {bollettino.getTipo()},
			bollettino);

		bollettino.resetOriginalValues();
	}

	/**
	 * Caches the bollettinos in the entity cache if it is enabled.
	 *
	 * @param bollettinos the bollettinos
	 */
	@Override
	public void cacheResult(List<Bollettino> bollettinos) {
		for (Bollettino bollettino : bollettinos) {
			if (entityCache.getResult(
					BollettinoModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoImpl.class, bollettino.getPrimaryKey()) == null) {

				cacheResult(bollettino);
			}
			else {
				bollettino.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bollettinos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bollettino.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bollettino bollettino) {
		entityCache.removeResult(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED, BollettinoImpl.class,
			bollettino.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BollettinoModelImpl)bollettino, true);
	}

	@Override
	public void clearCache(List<Bollettino> bollettinos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Bollettino bollettino : bollettinos) {
			entityCache.removeResult(
				BollettinoModelImpl.ENTITY_CACHE_ENABLED, BollettinoImpl.class,
				bollettino.getPrimaryKey());

			clearUniqueFindersCache((BollettinoModelImpl)bollettino, true);
		}
	}

	protected void cacheUniqueFindersCache(
		BollettinoModelImpl bollettinoModelImpl) {

		Object[] args = new Object[] {bollettinoModelImpl.getTipo()};

		finderCache.putResult(
			_finderPathCountBytipo, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBytipo, args, bollettinoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		BollettinoModelImpl bollettinoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {bollettinoModelImpl.getTipo()};

			finderCache.removeResult(_finderPathCountBytipo, args);
			finderCache.removeResult(_finderPathFetchBytipo, args);
		}

		if ((bollettinoModelImpl.getColumnBitmask() &
			 _finderPathFetchBytipo.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				bollettinoModelImpl.getOriginalTipo()
			};

			finderCache.removeResult(_finderPathCountBytipo, args);
			finderCache.removeResult(_finderPathFetchBytipo, args);
		}
	}

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param id the primary key for the new bollettino
	 * @return the new bollettino
	 */
	@Override
	public Bollettino create(long id) {
		Bollettino bollettino = new BollettinoImpl();

		bollettino.setNew(true);
		bollettino.setPrimaryKey(id);

		return bollettino;
	}

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino remove(long id) throws NoSuchBollettinoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino remove(Serializable primaryKey)
		throws NoSuchBollettinoException {

		Session session = null;

		try {
			session = openSession();

			Bollettino bollettino = (Bollettino)session.get(
				BollettinoImpl.class, primaryKey);

			if (bollettino == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettino);
		}
		catch (NoSuchBollettinoException nsee) {
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
	protected Bollettino removeImpl(Bollettino bollettino) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettino)) {
				bollettino = (Bollettino)session.get(
					BollettinoImpl.class, bollettino.getPrimaryKeyObj());
			}

			if (bollettino != null) {
				session.delete(bollettino);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bollettino != null) {
			clearCache(bollettino);
		}

		return bollettino;
	}

	@Override
	public Bollettino updateImpl(Bollettino bollettino) {
		boolean isNew = bollettino.isNew();

		if (!(bollettino instanceof BollettinoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettino.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bollettino);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettino proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Bollettino implementation " +
					bollettino.getClass());
		}

		BollettinoModelImpl bollettinoModelImpl =
			(BollettinoModelImpl)bollettino;

		Session session = null;

		try {
			session = openSession();

			if (bollettino.isNew()) {
				session.save(bollettino);

				bollettino.setNew(false);
			}
			else {
				bollettino = (Bollettino)session.merge(bollettino);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BollettinoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED, BollettinoImpl.class,
			bollettino.getPrimaryKey(), bollettino, false);

		clearUniqueFindersCache(bollettinoModelImpl, false);
		cacheUniqueFindersCache(bollettinoModelImpl);

		bollettino.resetOriginalValues();

		return bollettino;
	}

	/**
	 * Returns the bollettino with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByPrimaryKey(primaryKey);

		if (bollettino == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettino;
	}

	/**
	 * Returns the bollettino with the primary key or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino findByPrimaryKey(long id)
		throws NoSuchBollettinoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bollettino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED, BollettinoImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Bollettino bollettino = (Bollettino)serializable;

		if (bollettino == null) {
			Session session = null;

			try {
				session = openSession();

				bollettino = (Bollettino)session.get(
					BollettinoImpl.class, primaryKey);

				if (bollettino != null) {
					cacheResult(bollettino);
				}
				else {
					entityCache.putResult(
						BollettinoModelImpl.ENTITY_CACHE_ENABLED,
						BollettinoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					BollettinoModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bollettino;
	}

	/**
	 * Returns the bollettino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Bollettino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Bollettino> map =
			new HashMap<Serializable, Bollettino>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Bollettino bollettino = fetchByPrimaryKey(primaryKey);

			if (bollettino != null) {
				map.put(primaryKey, bollettino);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				BollettinoModelImpl.ENTITY_CACHE_ENABLED, BollettinoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Bollettino)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_BOLLETTINO_WHERE_PKS_IN);

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

			for (Bollettino bollettino : (List<Bollettino>)q.list()) {
				map.put(bollettino.getPrimaryKeyObj(), bollettino);

				cacheResult(bollettino);

				uncachedPrimaryKeys.remove(bollettino.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					BollettinoModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoImpl.class, primaryKey, nullModel);
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
	 * Returns all the bollettinos.
	 *
	 * @return the bollettinos
	 */
	@Override
	public List<Bollettino> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator,
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

		List<Bollettino> list = null;

		if (retrieveFromCache) {
			list = (List<Bollettino>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOLLETTINO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINO;

				if (pagination) {
					sql = sql.concat(BollettinoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Bollettino>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bollettino>)QueryUtil.list(
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
	 * Removes all the bollettinos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Bollettino bollettino : findAll()) {
			remove(bollettino);
		}
	}

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOLLETTINO);

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
		return BollettinoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoModelImpl.FINDER_CACHE_ENABLED, BollettinoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoModelImpl.FINDER_CACHE_ENABLED, BollettinoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBytipo = new FinderPath(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoModelImpl.FINDER_CACHE_ENABLED, BollettinoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBytipo",
			new String[] {String.class.getName()},
			BollettinoModelImpl.TIPO_COLUMN_BITMASK);

		_finderPathCountBytipo = new FinderPath(
			BollettinoModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytipo",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(BollettinoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOLLETTINO =
		"SELECT bollettino FROM Bollettino bollettino";

	private static final String _SQL_SELECT_BOLLETTINO_WHERE_PKS_IN =
		"SELECT bollettino FROM Bollettino bollettino WHERE id_ IN (";

	private static final String _SQL_SELECT_BOLLETTINO_WHERE =
		"SELECT bollettino FROM Bollettino bollettino WHERE ";

	private static final String _SQL_COUNT_BOLLETTINO =
		"SELECT COUNT(bollettino) FROM Bollettino bollettino";

	private static final String _SQL_COUNT_BOLLETTINO_WHERE =
		"SELECT COUNT(bollettino) FROM Bollettino bollettino WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettino.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Bollettino exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Bollettino exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}