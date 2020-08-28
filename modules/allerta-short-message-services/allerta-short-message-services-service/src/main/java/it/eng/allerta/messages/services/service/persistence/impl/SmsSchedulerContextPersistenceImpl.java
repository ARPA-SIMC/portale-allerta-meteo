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

package it.eng.allerta.messages.services.service.persistence.impl;

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

import it.eng.allerta.messages.services.exception.NoSuchSmsSchedulerContextException;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl;
import it.eng.allerta.messages.services.service.persistence.SmsSchedulerContextPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sms scheduler context service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class SmsSchedulerContextPersistenceImpl
	extends BasePersistenceImpl<SmsSchedulerContext>
	implements SmsSchedulerContextPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmsSchedulerContextUtil</code> to access the sms scheduler context persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmsSchedulerContextImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SmsSchedulerContextPersistenceImpl() {
		setModelClass(SmsSchedulerContext.class);
	}

	/**
	 * Caches the sms scheduler context in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 */
	@Override
	public void cacheResult(SmsSchedulerContext smsSchedulerContext) {
		entityCache.putResult(
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextImpl.class, smsSchedulerContext.getPrimaryKey(),
			smsSchedulerContext);

		smsSchedulerContext.resetOriginalValues();
	}

	/**
	 * Caches the sms scheduler contexts in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContexts the sms scheduler contexts
	 */
	@Override
	public void cacheResult(List<SmsSchedulerContext> smsSchedulerContexts) {
		for (SmsSchedulerContext smsSchedulerContext : smsSchedulerContexts) {
			if (entityCache.getResult(
					SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
					SmsSchedulerContextImpl.class,
					smsSchedulerContext.getPrimaryKey()) == null) {

				cacheResult(smsSchedulerContext);
			}
			else {
				smsSchedulerContext.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sms scheduler contexts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmsSchedulerContextImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sms scheduler context.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmsSchedulerContext smsSchedulerContext) {
		entityCache.removeResult(
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextImpl.class, smsSchedulerContext.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SmsSchedulerContext> smsSchedulerContexts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SmsSchedulerContext smsSchedulerContext : smsSchedulerContexts) {
			entityCache.removeResult(
				SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
				SmsSchedulerContextImpl.class,
				smsSchedulerContext.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	@Override
	public SmsSchedulerContext create(String varId) {
		SmsSchedulerContext smsSchedulerContext = new SmsSchedulerContextImpl();

		smsSchedulerContext.setNew(true);
		smsSchedulerContext.setPrimaryKey(varId);

		return smsSchedulerContext;
	}

	/**
	 * Removes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext remove(String varId)
		throws NoSuchSmsSchedulerContextException {

		return remove((Serializable)varId);
	}

	/**
	 * Removes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext remove(Serializable primaryKey)
		throws NoSuchSmsSchedulerContextException {

		Session session = null;

		try {
			session = openSession();

			SmsSchedulerContext smsSchedulerContext =
				(SmsSchedulerContext)session.get(
					SmsSchedulerContextImpl.class, primaryKey);

			if (smsSchedulerContext == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmsSchedulerContextException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smsSchedulerContext);
		}
		catch (NoSuchSmsSchedulerContextException nsee) {
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
	protected SmsSchedulerContext removeImpl(
		SmsSchedulerContext smsSchedulerContext) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smsSchedulerContext)) {
				smsSchedulerContext = (SmsSchedulerContext)session.get(
					SmsSchedulerContextImpl.class,
					smsSchedulerContext.getPrimaryKeyObj());
			}

			if (smsSchedulerContext != null) {
				session.delete(smsSchedulerContext);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (smsSchedulerContext != null) {
			clearCache(smsSchedulerContext);
		}

		return smsSchedulerContext;
	}

	@Override
	public SmsSchedulerContext updateImpl(
		SmsSchedulerContext smsSchedulerContext) {

		boolean isNew = smsSchedulerContext.isNew();

		Session session = null;

		try {
			session = openSession();

			if (smsSchedulerContext.isNew()) {
				session.save(smsSchedulerContext);

				smsSchedulerContext.setNew(false);
			}
			else {
				smsSchedulerContext = (SmsSchedulerContext)session.merge(
					smsSchedulerContext);
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
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextImpl.class, smsSchedulerContext.getPrimaryKey(),
			smsSchedulerContext, false);

		smsSchedulerContext.resetOriginalValues();

		return smsSchedulerContext;
	}

	/**
	 * Returns the sms scheduler context with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmsSchedulerContextException {

		SmsSchedulerContext smsSchedulerContext = fetchByPrimaryKey(primaryKey);

		if (smsSchedulerContext == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmsSchedulerContextException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smsSchedulerContext;
	}

	/**
	 * Returns the sms scheduler context with the primary key or throws a <code>NoSuchSmsSchedulerContextException</code> if it could not be found.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext findByPrimaryKey(String varId)
		throws NoSuchSmsSchedulerContextException {

		return findByPrimaryKey((Serializable)varId);
	}

	/**
	 * Returns the sms scheduler context with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sms scheduler context
	 * @return the sms scheduler context, or <code>null</code> if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SmsSchedulerContext smsSchedulerContext =
			(SmsSchedulerContext)serializable;

		if (smsSchedulerContext == null) {
			Session session = null;

			try {
				session = openSession();

				smsSchedulerContext = (SmsSchedulerContext)session.get(
					SmsSchedulerContextImpl.class, primaryKey);

				if (smsSchedulerContext != null) {
					cacheResult(smsSchedulerContext);
				}
				else {
					entityCache.putResult(
						SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
						SmsSchedulerContextImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
					SmsSchedulerContextImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return smsSchedulerContext;
	}

	/**
	 * Returns the sms scheduler context with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context, or <code>null</code> if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext fetchByPrimaryKey(String varId) {
		return fetchByPrimaryKey((Serializable)varId);
	}

	@Override
	public Map<Serializable, SmsSchedulerContext> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SmsSchedulerContext> map =
			new HashMap<Serializable, SmsSchedulerContext>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SmsSchedulerContext smsSchedulerContext = fetchByPrimaryKey(
				primaryKey);

			if (smsSchedulerContext != null) {
				map.put(primaryKey, smsSchedulerContext);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
				SmsSchedulerContextImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SmsSchedulerContext)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_SMSSCHEDULERCONTEXT_WHERE_PKS_IN);

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

			for (SmsSchedulerContext smsSchedulerContext :
					(List<SmsSchedulerContext>)q.list()) {

				map.put(
					smsSchedulerContext.getPrimaryKeyObj(),
					smsSchedulerContext);

				cacheResult(smsSchedulerContext);

				uncachedPrimaryKeys.remove(
					smsSchedulerContext.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
					SmsSchedulerContextImpl.class, primaryKey, nullModel);
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
	 * Returns all the sms scheduler contexts.
	 *
	 * @return the sms scheduler contexts
	 */
	@Override
	public List<SmsSchedulerContext> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @return the range of sms scheduler contexts
	 */
	@Override
	public List<SmsSchedulerContext> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sms scheduler contexts
	 */
	@Override
	public List<SmsSchedulerContext> findAll(
		int start, int end,
		OrderByComparator<SmsSchedulerContext> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sms scheduler contexts
	 */
	@Override
	public List<SmsSchedulerContext> findAll(
		int start, int end,
		OrderByComparator<SmsSchedulerContext> orderByComparator,
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

		List<SmsSchedulerContext> list = null;

		if (retrieveFromCache) {
			list = (List<SmsSchedulerContext>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SMSSCHEDULERCONTEXT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SMSSCHEDULERCONTEXT;

				if (pagination) {
					sql = sql.concat(
						SmsSchedulerContextModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SmsSchedulerContext>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SmsSchedulerContext>)QueryUtil.list(
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
	 * Removes all the sms scheduler contexts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmsSchedulerContext smsSchedulerContext : findAll()) {
			remove(smsSchedulerContext);
		}
	}

	/**
	 * Returns the number of sms scheduler contexts.
	 *
	 * @return the number of sms scheduler contexts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SMSSCHEDULERCONTEXT);

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
		return SmsSchedulerContextModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sms scheduler context persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextModelImpl.FINDER_CACHE_ENABLED,
			SmsSchedulerContextImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextModelImpl.FINDER_CACHE_ENABLED,
			SmsSchedulerContextImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			SmsSchedulerContextModelImpl.ENTITY_CACHE_ENABLED,
			SmsSchedulerContextModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(SmsSchedulerContextImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SMSSCHEDULERCONTEXT =
		"SELECT smsSchedulerContext FROM SmsSchedulerContext smsSchedulerContext";

	private static final String _SQL_SELECT_SMSSCHEDULERCONTEXT_WHERE_PKS_IN =
		"SELECT smsSchedulerContext FROM SmsSchedulerContext smsSchedulerContext WHERE varId IN (";

	private static final String _SQL_COUNT_SMSSCHEDULERCONTEXT =
		"SELECT COUNT(smsSchedulerContext) FROM SmsSchedulerContext smsSchedulerContext";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smsSchedulerContext.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmsSchedulerContext exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SmsSchedulerContextPersistenceImpl.class);

}