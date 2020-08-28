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

import it.eng.bollettino.exception.NoSuchAttivazioneFiumeException;
import it.eng.bollettino.model.AttivazioneFiume;
import it.eng.bollettino.model.impl.AttivazioneFiumeImpl;
import it.eng.bollettino.model.impl.AttivazioneFiumeModelImpl;
import it.eng.bollettino.service.persistence.AttivazioneFiumePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the attivazione fiume service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AttivazioneFiumePersistenceImpl
	extends BasePersistenceImpl<AttivazioneFiume>
	implements AttivazioneFiumePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AttivazioneFiumeUtil</code> to access the attivazione fiume persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AttivazioneFiumeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AttivazioneFiumePersistenceImpl() {
		setModelClass(AttivazioneFiume.class);
	}

	/**
	 * Caches the attivazione fiume in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiume the attivazione fiume
	 */
	@Override
	public void cacheResult(AttivazioneFiume attivazioneFiume) {
		entityCache.putResult(
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeImpl.class, attivazioneFiume.getPrimaryKey(),
			attivazioneFiume);

		attivazioneFiume.resetOriginalValues();
	}

	/**
	 * Caches the attivazione fiumes in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiumes the attivazione fiumes
	 */
	@Override
	public void cacheResult(List<AttivazioneFiume> attivazioneFiumes) {
		for (AttivazioneFiume attivazioneFiume : attivazioneFiumes) {
			if (entityCache.getResult(
					AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
					AttivazioneFiumeImpl.class,
					attivazioneFiume.getPrimaryKey()) == null) {

				cacheResult(attivazioneFiume);
			}
			else {
				attivazioneFiume.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attivazione fiumes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttivazioneFiumeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attivazione fiume.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttivazioneFiume attivazioneFiume) {
		entityCache.removeResult(
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeImpl.class, attivazioneFiume.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AttivazioneFiume> attivazioneFiumes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttivazioneFiume attivazioneFiume : attivazioneFiumes) {
			entityCache.removeResult(
				AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
				AttivazioneFiumeImpl.class, attivazioneFiume.getPrimaryKey());
		}
	}

	/**
	 * Creates a new attivazione fiume with the primary key. Does not add the attivazione fiume to the database.
	 *
	 * @param fiumeId the primary key for the new attivazione fiume
	 * @return the new attivazione fiume
	 */
	@Override
	public AttivazioneFiume create(String fiumeId) {
		AttivazioneFiume attivazioneFiume = new AttivazioneFiumeImpl();

		attivazioneFiume.setNew(true);
		attivazioneFiume.setPrimaryKey(fiumeId);

		return attivazioneFiume;
	}

	/**
	 * Removes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume remove(String fiumeId)
		throws NoSuchAttivazioneFiumeException {

		return remove((Serializable)fiumeId);
	}

	/**
	 * Removes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume remove(Serializable primaryKey)
		throws NoSuchAttivazioneFiumeException {

		Session session = null;

		try {
			session = openSession();

			AttivazioneFiume attivazioneFiume = (AttivazioneFiume)session.get(
				AttivazioneFiumeImpl.class, primaryKey);

			if (attivazioneFiume == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttivazioneFiumeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(attivazioneFiume);
		}
		catch (NoSuchAttivazioneFiumeException nsee) {
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
	protected AttivazioneFiume removeImpl(AttivazioneFiume attivazioneFiume) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attivazioneFiume)) {
				attivazioneFiume = (AttivazioneFiume)session.get(
					AttivazioneFiumeImpl.class,
					attivazioneFiume.getPrimaryKeyObj());
			}

			if (attivazioneFiume != null) {
				session.delete(attivazioneFiume);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attivazioneFiume != null) {
			clearCache(attivazioneFiume);
		}

		return attivazioneFiume;
	}

	@Override
	public AttivazioneFiume updateImpl(AttivazioneFiume attivazioneFiume) {
		boolean isNew = attivazioneFiume.isNew();

		Session session = null;

		try {
			session = openSession();

			if (attivazioneFiume.isNew()) {
				session.save(attivazioneFiume);

				attivazioneFiume.setNew(false);
			}
			else {
				attivazioneFiume = (AttivazioneFiume)session.merge(
					attivazioneFiume);
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
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeImpl.class, attivazioneFiume.getPrimaryKey(),
			attivazioneFiume, false);

		attivazioneFiume.resetOriginalValues();

		return attivazioneFiume;
	}

	/**
	 * Returns the attivazione fiume with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttivazioneFiumeException {

		AttivazioneFiume attivazioneFiume = fetchByPrimaryKey(primaryKey);

		if (attivazioneFiume == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttivazioneFiumeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return attivazioneFiume;
	}

	/**
	 * Returns the attivazione fiume with the primary key or throws a <code>NoSuchAttivazioneFiumeException</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume findByPrimaryKey(String fiumeId)
		throws NoSuchAttivazioneFiumeException {

		return findByPrimaryKey((Serializable)fiumeId);
	}

	/**
	 * Returns the attivazione fiume with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attivazione fiume
	 * @return the attivazione fiume, or <code>null</code> if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AttivazioneFiume attivazioneFiume = (AttivazioneFiume)serializable;

		if (attivazioneFiume == null) {
			Session session = null;

			try {
				session = openSession();

				attivazioneFiume = (AttivazioneFiume)session.get(
					AttivazioneFiumeImpl.class, primaryKey);

				if (attivazioneFiume != null) {
					cacheResult(attivazioneFiume);
				}
				else {
					entityCache.putResult(
						AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
						AttivazioneFiumeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
					AttivazioneFiumeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attivazioneFiume;
	}

	/**
	 * Returns the attivazione fiume with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume, or <code>null</code> if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume fetchByPrimaryKey(String fiumeId) {
		return fetchByPrimaryKey((Serializable)fiumeId);
	}

	@Override
	public Map<Serializable, AttivazioneFiume> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AttivazioneFiume> map =
			new HashMap<Serializable, AttivazioneFiume>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AttivazioneFiume attivazioneFiume = fetchByPrimaryKey(primaryKey);

			if (attivazioneFiume != null) {
				map.put(primaryKey, attivazioneFiume);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
				AttivazioneFiumeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AttivazioneFiume)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ATTIVAZIONEFIUME_WHERE_PKS_IN);

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

			for (AttivazioneFiume attivazioneFiume :
					(List<AttivazioneFiume>)q.list()) {

				map.put(attivazioneFiume.getPrimaryKeyObj(), attivazioneFiume);

				cacheResult(attivazioneFiume);

				uncachedPrimaryKeys.remove(attivazioneFiume.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
					AttivazioneFiumeImpl.class, primaryKey, nullModel);
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
	 * Returns all the attivazione fiumes.
	 *
	 * @return the attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @return the range of attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll(
		int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll(
		int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator,
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

		List<AttivazioneFiume> list = null;

		if (retrieveFromCache) {
			list = (List<AttivazioneFiume>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ATTIVAZIONEFIUME);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTIVAZIONEFIUME;

				if (pagination) {
					sql = sql.concat(AttivazioneFiumeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttivazioneFiume>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AttivazioneFiume>)QueryUtil.list(
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
	 * Removes all the attivazione fiumes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttivazioneFiume attivazioneFiume : findAll()) {
			remove(attivazioneFiume);
		}
	}

	/**
	 * Returns the number of attivazione fiumes.
	 *
	 * @return the number of attivazione fiumes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ATTIVAZIONEFIUME);

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
		return AttivazioneFiumeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attivazione fiume persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeModelImpl.FINDER_CACHE_ENABLED,
			AttivazioneFiumeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeModelImpl.FINDER_CACHE_ENABLED,
			AttivazioneFiumeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AttivazioneFiumeModelImpl.ENTITY_CACHE_ENABLED,
			AttivazioneFiumeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(AttivazioneFiumeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ATTIVAZIONEFIUME =
		"SELECT attivazioneFiume FROM AttivazioneFiume attivazioneFiume";

	private static final String _SQL_SELECT_ATTIVAZIONEFIUME_WHERE_PKS_IN =
		"SELECT attivazioneFiume FROM AttivazioneFiume attivazioneFiume WHERE fiumeId IN (";

	private static final String _SQL_COUNT_ATTIVAZIONEFIUME =
		"SELECT COUNT(attivazioneFiume) FROM AttivazioneFiume attivazioneFiume";

	private static final String _ORDER_BY_ENTITY_ALIAS = "attivazioneFiume.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AttivazioneFiume exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AttivazioneFiumePersistenceImpl.class);

}