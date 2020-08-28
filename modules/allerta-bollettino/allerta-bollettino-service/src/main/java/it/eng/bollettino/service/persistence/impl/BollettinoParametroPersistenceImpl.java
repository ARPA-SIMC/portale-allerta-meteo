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

package it.eng.bollettino.service.persistence.impl;

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

import it.eng.bollettino.exception.NoSuchBollettinoParametroException;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.impl.BollettinoParametroImpl;
import it.eng.bollettino.model.impl.BollettinoParametroModelImpl;
import it.eng.bollettino.service.persistence.BollettinoParametroPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the bollettino parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoParametroPersistenceImpl
	extends BasePersistenceImpl<BollettinoParametro>
	implements BollettinoParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoParametroUtil</code> to access the bollettino parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BollettinoParametroPersistenceImpl() {
		setModelClass(BollettinoParametro.class);
	}

	/**
	 * Caches the bollettino parametro in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametro the bollettino parametro
	 */
	@Override
	public void cacheResult(BollettinoParametro bollettinoParametro) {
		entityCache.putResult(
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroImpl.class, bollettinoParametro.getPrimaryKey(),
			bollettinoParametro);

		bollettinoParametro.resetOriginalValues();
	}

	/**
	 * Caches the bollettino parametros in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametros the bollettino parametros
	 */
	@Override
	public void cacheResult(List<BollettinoParametro> bollettinoParametros) {
		for (BollettinoParametro bollettinoParametro : bollettinoParametros) {
			if (entityCache.getResult(
					BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoParametroImpl.class,
					bollettinoParametro.getPrimaryKey()) == null) {

				cacheResult(bollettinoParametro);
			}
			else {
				bollettinoParametro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bollettino parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoParametroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bollettino parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoParametro bollettinoParametro) {
		entityCache.removeResult(
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroImpl.class, bollettinoParametro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BollettinoParametro> bollettinoParametros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BollettinoParametro bollettinoParametro : bollettinoParametros) {
			entityCache.removeResult(
				BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
				BollettinoParametroImpl.class,
				bollettinoParametro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bollettino parametro with the primary key. Does not add the bollettino parametro to the database.
	 *
	 * @param parametroId the primary key for the new bollettino parametro
	 * @return the new bollettino parametro
	 */
	@Override
	public BollettinoParametro create(String parametroId) {
		BollettinoParametro bollettinoParametro = new BollettinoParametroImpl();

		bollettinoParametro.setNew(true);
		bollettinoParametro.setPrimaryKey(parametroId);

		return bollettinoParametro;
	}

	/**
	 * Removes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro remove(String parametroId)
		throws NoSuchBollettinoParametroException {

		return remove((Serializable)parametroId);
	}

	/**
	 * Removes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro remove(Serializable primaryKey)
		throws NoSuchBollettinoParametroException {

		Session session = null;

		try {
			session = openSession();

			BollettinoParametro bollettinoParametro =
				(BollettinoParametro)session.get(
					BollettinoParametroImpl.class, primaryKey);

			if (bollettinoParametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoParametro);
		}
		catch (NoSuchBollettinoParametroException nsee) {
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
	protected BollettinoParametro removeImpl(
		BollettinoParametro bollettinoParametro) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoParametro)) {
				bollettinoParametro = (BollettinoParametro)session.get(
					BollettinoParametroImpl.class,
					bollettinoParametro.getPrimaryKeyObj());
			}

			if (bollettinoParametro != null) {
				session.delete(bollettinoParametro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoParametro != null) {
			clearCache(bollettinoParametro);
		}

		return bollettinoParametro;
	}

	@Override
	public BollettinoParametro updateImpl(
		BollettinoParametro bollettinoParametro) {

		boolean isNew = bollettinoParametro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bollettinoParametro.isNew()) {
				session.save(bollettinoParametro);

				bollettinoParametro.setNew(false);
			}
			else {
				bollettinoParametro = (BollettinoParametro)session.merge(
					bollettinoParametro);
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
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroImpl.class, bollettinoParametro.getPrimaryKey(),
			bollettinoParametro, false);

		bollettinoParametro.resetOriginalValues();

		return bollettinoParametro;
	}

	/**
	 * Returns the bollettino parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoParametroException {

		BollettinoParametro bollettinoParametro = fetchByPrimaryKey(primaryKey);

		if (bollettinoParametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoParametro;
	}

	/**
	 * Returns the bollettino parametro with the primary key or throws a <code>NoSuchBollettinoParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro findByPrimaryKey(String parametroId)
		throws NoSuchBollettinoParametroException {

		return findByPrimaryKey((Serializable)parametroId);
	}

	/**
	 * Returns the bollettino parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino parametro
	 * @return the bollettino parametro, or <code>null</code> if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BollettinoParametro bollettinoParametro =
			(BollettinoParametro)serializable;

		if (bollettinoParametro == null) {
			Session session = null;

			try {
				session = openSession();

				bollettinoParametro = (BollettinoParametro)session.get(
					BollettinoParametroImpl.class, primaryKey);

				if (bollettinoParametro != null) {
					cacheResult(bollettinoParametro);
				}
				else {
					entityCache.putResult(
						BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
						BollettinoParametroImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoParametroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bollettinoParametro;
	}

	/**
	 * Returns the bollettino parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro, or <code>null</code> if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro fetchByPrimaryKey(String parametroId) {
		return fetchByPrimaryKey((Serializable)parametroId);
	}

	@Override
	public Map<Serializable, BollettinoParametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BollettinoParametro> map =
			new HashMap<Serializable, BollettinoParametro>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BollettinoParametro bollettinoParametro = fetchByPrimaryKey(
				primaryKey);

			if (bollettinoParametro != null) {
				map.put(primaryKey, bollettinoParametro);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
				BollettinoParametroImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BollettinoParametro)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_BOLLETTINOPARAMETRO_WHERE_PKS_IN);

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

			for (BollettinoParametro bollettinoParametro :
					(List<BollettinoParametro>)q.list()) {

				map.put(
					bollettinoParametro.getPrimaryKeyObj(),
					bollettinoParametro);

				cacheResult(bollettinoParametro);

				uncachedPrimaryKeys.remove(
					bollettinoParametro.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
					BollettinoParametroImpl.class, primaryKey, nullModel);
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
	 * Returns all the bollettino parametros.
	 *
	 * @return the bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @return the range of bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll(
		int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll(
		int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator,
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

		List<BollettinoParametro> list = null;

		if (retrieveFromCache) {
			list = (List<BollettinoParametro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOLLETTINOPARAMETRO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOPARAMETRO;

				if (pagination) {
					sql = sql.concat(
						BollettinoParametroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BollettinoParametro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BollettinoParametro>)QueryUtil.list(
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
	 * Removes all the bollettino parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoParametro bollettinoParametro : findAll()) {
			remove(bollettinoParametro);
		}
	}

	/**
	 * Returns the number of bollettino parametros.
	 *
	 * @return the number of bollettino parametros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOLLETTINOPARAMETRO);

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
		return BollettinoParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino parametro persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroModelImpl.FINDER_CACHE_ENABLED,
			BollettinoParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroModelImpl.FINDER_CACHE_ENABLED,
			BollettinoParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			BollettinoParametroModelImpl.ENTITY_CACHE_ENABLED,
			BollettinoParametroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(BollettinoParametroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOLLETTINOPARAMETRO =
		"SELECT bollettinoParametro FROM BollettinoParametro bollettinoParametro";

	private static final String _SQL_SELECT_BOLLETTINOPARAMETRO_WHERE_PKS_IN =
		"SELECT bollettinoParametro FROM BollettinoParametro bollettinoParametro WHERE parametroId IN (";

	private static final String _SQL_COUNT_BOLLETTINOPARAMETRO =
		"SELECT COUNT(bollettinoParametro) FROM BollettinoParametro bollettinoParametro";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoParametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoParametro exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoParametroPersistenceImpl.class);

}