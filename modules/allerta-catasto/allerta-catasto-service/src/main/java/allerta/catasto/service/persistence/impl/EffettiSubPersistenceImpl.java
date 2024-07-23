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

package allerta.catasto.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.exception.NoSuchEffettiSubException;
import allerta.catasto.model.EffettiSub;
import allerta.catasto.model.impl.EffettiSubImpl;
import allerta.catasto.model.impl.EffettiSubModelImpl;
import allerta.catasto.service.persistence.EffettiSubPK;
import allerta.catasto.service.persistence.EffettiSubPersistence;

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

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the effetti sub service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EffettiSubPersistenceImpl
	extends BasePersistenceImpl<EffettiSub> implements EffettiSubPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EffettiSubUtil</code> to access the effetti sub persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EffettiSubImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EffettiSubPersistenceImpl() {
		setModelClass(EffettiSub.class);

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
	 * Caches the effetti sub in the entity cache if it is enabled.
	 *
	 * @param effettiSub the effetti sub
	 */
	@Override
	public void cacheResult(EffettiSub effettiSub) {
		entityCache.putResult(
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED, EffettiSubImpl.class,
			effettiSub.getPrimaryKey(), effettiSub);

		effettiSub.resetOriginalValues();
	}

	/**
	 * Caches the effetti subs in the entity cache if it is enabled.
	 *
	 * @param effettiSubs the effetti subs
	 */
	@Override
	public void cacheResult(List<EffettiSub> effettiSubs) {
		for (EffettiSub effettiSub : effettiSubs) {
			if (entityCache.getResult(
					EffettiSubModelImpl.ENTITY_CACHE_ENABLED,
					EffettiSubImpl.class, effettiSub.getPrimaryKey()) == null) {

				cacheResult(effettiSub);
			}
			else {
				effettiSub.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all effetti subs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EffettiSubImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the effetti sub.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EffettiSub effettiSub) {
		entityCache.removeResult(
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED, EffettiSubImpl.class,
			effettiSub.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EffettiSub> effettiSubs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EffettiSub effettiSub : effettiSubs) {
			entityCache.removeResult(
				EffettiSubModelImpl.ENTITY_CACHE_ENABLED, EffettiSubImpl.class,
				effettiSub.getPrimaryKey());
		}
	}

	/**
	 * Creates a new effetti sub with the primary key. Does not add the effetti sub to the database.
	 *
	 * @param effettiSubPK the primary key for the new effetti sub
	 * @return the new effetti sub
	 */
	@Override
	public EffettiSub create(EffettiSubPK effettiSubPK) {
		EffettiSub effettiSub = new EffettiSubImpl();

		effettiSub.setNew(true);
		effettiSub.setPrimaryKey(effettiSubPK);

		return effettiSub;
	}

	/**
	 * Removes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub remove(EffettiSubPK effettiSubPK)
		throws NoSuchEffettiSubException {

		return remove((Serializable)effettiSubPK);
	}

	/**
	 * Removes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub remove(Serializable primaryKey)
		throws NoSuchEffettiSubException {

		Session session = null;

		try {
			session = openSession();

			EffettiSub effettiSub = (EffettiSub)session.get(
				EffettiSubImpl.class, primaryKey);

			if (effettiSub == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEffettiSubException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(effettiSub);
		}
		catch (NoSuchEffettiSubException nsee) {
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
	protected EffettiSub removeImpl(EffettiSub effettiSub) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(effettiSub)) {
				effettiSub = (EffettiSub)session.get(
					EffettiSubImpl.class, effettiSub.getPrimaryKeyObj());
			}

			if (effettiSub != null) {
				session.delete(effettiSub);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (effettiSub != null) {
			clearCache(effettiSub);
		}

		return effettiSub;
	}

	@Override
	public EffettiSub updateImpl(EffettiSub effettiSub) {
		boolean isNew = effettiSub.isNew();

		Session session = null;

		try {
			session = openSession();

			if (effettiSub.isNew()) {
				session.save(effettiSub);

				effettiSub.setNew(false);
			}
			else {
				effettiSub = (EffettiSub)session.merge(effettiSub);
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
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED, EffettiSubImpl.class,
			effettiSub.getPrimaryKey(), effettiSub, false);

		effettiSub.resetOriginalValues();

		return effettiSub;
	}

	/**
	 * Returns the effetti sub with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEffettiSubException {

		EffettiSub effettiSub = fetchByPrimaryKey(primaryKey);

		if (effettiSub == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEffettiSubException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return effettiSub;
	}

	/**
	 * Returns the effetti sub with the primary key or throws a <code>NoSuchEffettiSubException</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub findByPrimaryKey(EffettiSubPK effettiSubPK)
		throws NoSuchEffettiSubException {

		return findByPrimaryKey((Serializable)effettiSubPK);
	}

	/**
	 * Returns the effetti sub with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the effetti sub
	 * @return the effetti sub, or <code>null</code> if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED, EffettiSubImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EffettiSub effettiSub = (EffettiSub)serializable;

		if (effettiSub == null) {
			Session session = null;

			try {
				session = openSession();

				effettiSub = (EffettiSub)session.get(
					EffettiSubImpl.class, primaryKey);

				if (effettiSub != null) {
					cacheResult(effettiSub);
				}
				else {
					entityCache.putResult(
						EffettiSubModelImpl.ENTITY_CACHE_ENABLED,
						EffettiSubImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					EffettiSubModelImpl.ENTITY_CACHE_ENABLED,
					EffettiSubImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return effettiSub;
	}

	/**
	 * Returns the effetti sub with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub, or <code>null</code> if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub fetchByPrimaryKey(EffettiSubPK effettiSubPK) {
		return fetchByPrimaryKey((Serializable)effettiSubPK);
	}

	@Override
	public Map<Serializable, EffettiSub> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EffettiSub> map =
			new HashMap<Serializable, EffettiSub>();

		for (Serializable primaryKey : primaryKeys) {
			EffettiSub effettiSub = fetchByPrimaryKey(primaryKey);

			if (effettiSub != null) {
				map.put(primaryKey, effettiSub);
			}
		}

		return map;
	}

	/**
	 * Returns all the effetti subs.
	 *
	 * @return the effetti subs
	 */
	@Override
	public List<EffettiSub> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @return the range of effetti subs
	 */
	@Override
	public List<EffettiSub> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effetti subs
	 */
	@Override
	public List<EffettiSub> findAll(
		int start, int end, OrderByComparator<EffettiSub> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of effetti subs
	 */
	@Override
	public List<EffettiSub> findAll(
		int start, int end, OrderByComparator<EffettiSub> orderByComparator,
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

		List<EffettiSub> list = null;

		if (retrieveFromCache) {
			list = (List<EffettiSub>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EFFETTISUB);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EFFETTISUB;

				if (pagination) {
					sql = sql.concat(EffettiSubModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EffettiSub>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EffettiSub>)QueryUtil.list(
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
	 * Removes all the effetti subs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EffettiSub effettiSub : findAll()) {
			remove(effettiSub);
		}
	}

	/**
	 * Returns the number of effetti subs.
	 *
	 * @return the number of effetti subs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EFFETTISUB);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EffettiSubModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the effetti sub persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED,
			EffettiSubModelImpl.FINDER_CACHE_ENABLED, EffettiSubImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED,
			EffettiSubModelImpl.FINDER_CACHE_ENABLED, EffettiSubImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			EffettiSubModelImpl.ENTITY_CACHE_ENABLED,
			EffettiSubModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(EffettiSubImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EFFETTISUB =
		"SELECT effettiSub FROM EffettiSub effettiSub";

	private static final String _SQL_COUNT_EFFETTISUB =
		"SELECT COUNT(effettiSub) FROM EffettiSub effettiSub";

	private static final String _ORDER_BY_ENTITY_ALIAS = "effettiSub.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EffettiSub exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EffettiSubPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"id", "idEffetti"});

}