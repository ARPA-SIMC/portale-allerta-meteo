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

package it.eng.allerter.service.persistence.impl;

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

import it.eng.allerter.exception.NoSuchAllertaParametroException;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.impl.AllertaParametroImpl;
import it.eng.allerter.model.impl.AllertaParametroModelImpl;
import it.eng.allerter.service.persistence.AllertaParametroPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the allerta parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaParametroPersistenceImpl
	extends BasePersistenceImpl<AllertaParametro>
	implements AllertaParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllertaParametroUtil</code> to access the allerta parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllertaParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AllertaParametroPersistenceImpl() {
		setModelClass(AllertaParametro.class);
	}

	/**
	 * Caches the allerta parametro in the entity cache if it is enabled.
	 *
	 * @param allertaParametro the allerta parametro
	 */
	@Override
	public void cacheResult(AllertaParametro allertaParametro) {
		entityCache.putResult(
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroImpl.class, allertaParametro.getPrimaryKey(),
			allertaParametro);

		allertaParametro.resetOriginalValues();
	}

	/**
	 * Caches the allerta parametros in the entity cache if it is enabled.
	 *
	 * @param allertaParametros the allerta parametros
	 */
	@Override
	public void cacheResult(List<AllertaParametro> allertaParametros) {
		for (AllertaParametro allertaParametro : allertaParametros) {
			if (entityCache.getResult(
					AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
					AllertaParametroImpl.class,
					allertaParametro.getPrimaryKey()) == null) {

				cacheResult(allertaParametro);
			}
			else {
				allertaParametro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all allerta parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllertaParametroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the allerta parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllertaParametro allertaParametro) {
		entityCache.removeResult(
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroImpl.class, allertaParametro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AllertaParametro> allertaParametros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AllertaParametro allertaParametro : allertaParametros) {
			entityCache.removeResult(
				AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
				AllertaParametroImpl.class, allertaParametro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	@Override
	public AllertaParametro create(String parametroId) {
		AllertaParametro allertaParametro = new AllertaParametroImpl();

		allertaParametro.setNew(true);
		allertaParametro.setPrimaryKey(parametroId);

		return allertaParametro;
	}

	/**
	 * Removes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro remove(String parametroId)
		throws NoSuchAllertaParametroException {

		return remove((Serializable)parametroId);
	}

	/**
	 * Removes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro remove(Serializable primaryKey)
		throws NoSuchAllertaParametroException {

		Session session = null;

		try {
			session = openSession();

			AllertaParametro allertaParametro = (AllertaParametro)session.get(
				AllertaParametroImpl.class, primaryKey);

			if (allertaParametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllertaParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allertaParametro);
		}
		catch (NoSuchAllertaParametroException nsee) {
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
	protected AllertaParametro removeImpl(AllertaParametro allertaParametro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allertaParametro)) {
				allertaParametro = (AllertaParametro)session.get(
					AllertaParametroImpl.class,
					allertaParametro.getPrimaryKeyObj());
			}

			if (allertaParametro != null) {
				session.delete(allertaParametro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (allertaParametro != null) {
			clearCache(allertaParametro);
		}

		return allertaParametro;
	}

	@Override
	public AllertaParametro updateImpl(AllertaParametro allertaParametro) {
		boolean isNew = allertaParametro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (allertaParametro.isNew()) {
				session.save(allertaParametro);

				allertaParametro.setNew(false);
			}
			else {
				allertaParametro = (AllertaParametro)session.merge(
					allertaParametro);
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
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroImpl.class, allertaParametro.getPrimaryKey(),
			allertaParametro, false);

		allertaParametro.resetOriginalValues();

		return allertaParametro;
	}

	/**
	 * Returns the allerta parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllertaParametroException {

		AllertaParametro allertaParametro = fetchByPrimaryKey(primaryKey);

		if (allertaParametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllertaParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allertaParametro;
	}

	/**
	 * Returns the allerta parametro with the primary key or throws a <code>NoSuchAllertaParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro findByPrimaryKey(String parametroId)
		throws NoSuchAllertaParametroException {

		return findByPrimaryKey((Serializable)parametroId);
	}

	/**
	 * Returns the allerta parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta parametro
	 * @return the allerta parametro, or <code>null</code> if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AllertaParametro allertaParametro = (AllertaParametro)serializable;

		if (allertaParametro == null) {
			Session session = null;

			try {
				session = openSession();

				allertaParametro = (AllertaParametro)session.get(
					AllertaParametroImpl.class, primaryKey);

				if (allertaParametro != null) {
					cacheResult(allertaParametro);
				}
				else {
					entityCache.putResult(
						AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
						AllertaParametroImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
					AllertaParametroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return allertaParametro;
	}

	/**
	 * Returns the allerta parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro, or <code>null</code> if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro fetchByPrimaryKey(String parametroId) {
		return fetchByPrimaryKey((Serializable)parametroId);
	}

	@Override
	public Map<Serializable, AllertaParametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AllertaParametro> map =
			new HashMap<Serializable, AllertaParametro>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AllertaParametro allertaParametro = fetchByPrimaryKey(primaryKey);

			if (allertaParametro != null) {
				map.put(primaryKey, allertaParametro);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
				AllertaParametroImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AllertaParametro)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ALLERTAPARAMETRO_WHERE_PKS_IN);

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

			for (AllertaParametro allertaParametro :
					(List<AllertaParametro>)q.list()) {

				map.put(allertaParametro.getPrimaryKeyObj(), allertaParametro);

				cacheResult(allertaParametro);

				uncachedPrimaryKeys.remove(allertaParametro.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
					AllertaParametroImpl.class, primaryKey, nullModel);
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
	 * Returns all the allerta parametros.
	 *
	 * @return the allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll(
		int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll(
		int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator,
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

		List<AllertaParametro> list = null;

		if (retrieveFromCache) {
			list = (List<AllertaParametro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALLERTAPARAMETRO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALLERTAPARAMETRO;

				if (pagination) {
					sql = sql.concat(AllertaParametroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AllertaParametro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AllertaParametro>)QueryUtil.list(
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
	 * Removes all the allerta parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AllertaParametro allertaParametro : findAll()) {
			remove(allertaParametro);
		}
	}

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALLERTAPARAMETRO);

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
		return AllertaParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allerta parametro persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroModelImpl.FINDER_CACHE_ENABLED,
			AllertaParametroImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroModelImpl.FINDER_CACHE_ENABLED,
			AllertaParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AllertaParametroModelImpl.ENTITY_CACHE_ENABLED,
			AllertaParametroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(AllertaParametroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALLERTAPARAMETRO =
		"SELECT allertaParametro FROM AllertaParametro allertaParametro";

	private static final String _SQL_SELECT_ALLERTAPARAMETRO_WHERE_PKS_IN =
		"SELECT allertaParametro FROM AllertaParametro allertaParametro WHERE parametroId IN (";

	private static final String _SQL_COUNT_ALLERTAPARAMETRO =
		"SELECT COUNT(allertaParametro) FROM AllertaParametro allertaParametro";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allertaParametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AllertaParametro exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaParametroPersistenceImpl.class);

}