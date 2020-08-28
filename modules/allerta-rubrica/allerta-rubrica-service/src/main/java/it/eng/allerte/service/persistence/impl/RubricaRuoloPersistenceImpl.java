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

package it.eng.allerte.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaRuoloException;
import it.eng.allerte.model.RubricaRuolo;
import it.eng.allerte.model.impl.RubricaRuoloImpl;
import it.eng.allerte.model.impl.RubricaRuoloModelImpl;
import it.eng.allerte.service.persistence.RubricaRuoloPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica ruolo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloPersistenceImpl
	extends BasePersistenceImpl<RubricaRuolo>
	implements RubricaRuoloPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaRuoloUtil</code> to access the rubrica ruolo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaRuoloImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByRubricaRuoloByRuoloLiferay;
	private FinderPath _finderPathCountByRubricaRuoloByRuoloLiferay;

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a matching rubrica ruolo could not be found
	 */
	@Override
	public RubricaRuolo findByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY)
		throws NoSuchRubricaRuoloException {

		RubricaRuolo rubricaRuolo = fetchByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);

		if (rubricaRuolo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("FK_RUOLO_LIFERAY=");
			msg.append(FK_RUOLO_LIFERAY);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRubricaRuoloException(msg.toString());
		}

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	@Override
	public RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY) {

		return fetchByRubricaRuoloByRuoloLiferay(FK_RUOLO_LIFERAY, true);
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	@Override
	public RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {FK_RUOLO_LIFERAY};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByRubricaRuoloByRuoloLiferay, finderArgs, this);
		}

		if (result instanceof RubricaRuolo) {
			RubricaRuolo rubricaRuolo = (RubricaRuolo)result;

			if ((FK_RUOLO_LIFERAY != rubricaRuolo.getFK_RUOLO_LIFERAY())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RUBRICARUOLO_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICARUOLOBYRUOLOLIFERAY_FK_RUOLO_LIFERAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_RUOLO_LIFERAY);

				List<RubricaRuolo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByRubricaRuoloByRuoloLiferay,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RubricaRuoloPersistenceImpl.fetchByRubricaRuoloByRuoloLiferay(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RubricaRuolo rubricaRuolo = list.get(0);

					result = rubricaRuolo;

					cacheResult(rubricaRuolo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByRubricaRuoloByRuoloLiferay, finderArgs);

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
			return (RubricaRuolo)result;
		}
	}

	/**
	 * Removes the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; from the database.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the rubrica ruolo that was removed
	 */
	@Override
	public RubricaRuolo removeByRubricaRuoloByRuoloLiferay(
			long FK_RUOLO_LIFERAY)
		throws NoSuchRubricaRuoloException {

		RubricaRuolo rubricaRuolo = findByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);

		return remove(rubricaRuolo);
	}

	/**
	 * Returns the number of rubrica ruolos where FK_RUOLO_LIFERAY = &#63;.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the number of matching rubrica ruolos
	 */
	@Override
	public int countByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY) {
		FinderPath finderPath = _finderPathCountByRubricaRuoloByRuoloLiferay;

		Object[] finderArgs = new Object[] {FK_RUOLO_LIFERAY};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICARUOLO_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICARUOLOBYRUOLOLIFERAY_FK_RUOLO_LIFERAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_RUOLO_LIFERAY);

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

	private static final String
		_FINDER_COLUMN_RUBRICARUOLOBYRUOLOLIFERAY_FK_RUOLO_LIFERAY_2 =
			"rubricaRuolo.FK_RUOLO_LIFERAY = ?";

	public RubricaRuoloPersistenceImpl() {
		setModelClass(RubricaRuolo.class);
	}

	/**
	 * Caches the rubrica ruolo in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 */
	@Override
	public void cacheResult(RubricaRuolo rubricaRuolo) {
		entityCache.putResult(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED, RubricaRuoloImpl.class,
			rubricaRuolo.getPrimaryKey(), rubricaRuolo);

		finderCache.putResult(
			_finderPathFetchByRubricaRuoloByRuoloLiferay,
			new Object[] {rubricaRuolo.getFK_RUOLO_LIFERAY()}, rubricaRuolo);

		rubricaRuolo.resetOriginalValues();
	}

	/**
	 * Caches the rubrica ruolos in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolos the rubrica ruolos
	 */
	@Override
	public void cacheResult(List<RubricaRuolo> rubricaRuolos) {
		for (RubricaRuolo rubricaRuolo : rubricaRuolos) {
			if (entityCache.getResult(
					RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloImpl.class, rubricaRuolo.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaRuolo);
			}
			else {
				rubricaRuolo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica ruolos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaRuoloImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica ruolo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaRuolo rubricaRuolo) {
		entityCache.removeResult(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED, RubricaRuoloImpl.class,
			rubricaRuolo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((RubricaRuoloModelImpl)rubricaRuolo, true);
	}

	@Override
	public void clearCache(List<RubricaRuolo> rubricaRuolos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaRuolo rubricaRuolo : rubricaRuolos) {
			entityCache.removeResult(
				RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
				RubricaRuoloImpl.class, rubricaRuolo.getPrimaryKey());

			clearUniqueFindersCache((RubricaRuoloModelImpl)rubricaRuolo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		RubricaRuoloModelImpl rubricaRuoloModelImpl) {

		Object[] args = new Object[] {
			rubricaRuoloModelImpl.getFK_RUOLO_LIFERAY()
		};

		finderCache.putResult(
			_finderPathCountByRubricaRuoloByRuoloLiferay, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByRubricaRuoloByRuoloLiferay, args,
			rubricaRuoloModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		RubricaRuoloModelImpl rubricaRuoloModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				rubricaRuoloModelImpl.getFK_RUOLO_LIFERAY()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaRuoloByRuoloLiferay, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaRuoloByRuoloLiferay, args);
		}

		if ((rubricaRuoloModelImpl.getColumnBitmask() &
			 _finderPathFetchByRubricaRuoloByRuoloLiferay.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				rubricaRuoloModelImpl.getOriginalFK_RUOLO_LIFERAY()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaRuoloByRuoloLiferay, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaRuoloByRuoloLiferay, args);
		}
	}

	/**
	 * Creates a new rubrica ruolo with the primary key. Does not add the rubrica ruolo to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo
	 * @return the new rubrica ruolo
	 */
	@Override
	public RubricaRuolo create(long ID_RUOLO) {
		RubricaRuolo rubricaRuolo = new RubricaRuoloImpl();

		rubricaRuolo.setNew(true);
		rubricaRuolo.setPrimaryKey(ID_RUOLO);

		return rubricaRuolo;
	}

	/**
	 * Removes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo remove(long ID_RUOLO)
		throws NoSuchRubricaRuoloException {

		return remove((Serializable)ID_RUOLO);
	}

	/**
	 * Removes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo remove(Serializable primaryKey)
		throws NoSuchRubricaRuoloException {

		Session session = null;

		try {
			session = openSession();

			RubricaRuolo rubricaRuolo = (RubricaRuolo)session.get(
				RubricaRuoloImpl.class, primaryKey);

			if (rubricaRuolo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaRuoloException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaRuolo);
		}
		catch (NoSuchRubricaRuoloException nsee) {
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
	protected RubricaRuolo removeImpl(RubricaRuolo rubricaRuolo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaRuolo)) {
				rubricaRuolo = (RubricaRuolo)session.get(
					RubricaRuoloImpl.class, rubricaRuolo.getPrimaryKeyObj());
			}

			if (rubricaRuolo != null) {
				session.delete(rubricaRuolo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaRuolo != null) {
			clearCache(rubricaRuolo);
		}

		return rubricaRuolo;
	}

	@Override
	public RubricaRuolo updateImpl(RubricaRuolo rubricaRuolo) {
		boolean isNew = rubricaRuolo.isNew();

		if (!(rubricaRuolo instanceof RubricaRuoloModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaRuolo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaRuolo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaRuolo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaRuolo implementation " +
					rubricaRuolo.getClass());
		}

		RubricaRuoloModelImpl rubricaRuoloModelImpl =
			(RubricaRuoloModelImpl)rubricaRuolo;

		Session session = null;

		try {
			session = openSession();

			if (rubricaRuolo.isNew()) {
				session.save(rubricaRuolo);

				rubricaRuolo.setNew(false);
			}
			else {
				rubricaRuolo = (RubricaRuolo)session.merge(rubricaRuolo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaRuoloModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED, RubricaRuoloImpl.class,
			rubricaRuolo.getPrimaryKey(), rubricaRuolo, false);

		clearUniqueFindersCache(rubricaRuoloModelImpl, false);
		cacheUniqueFindersCache(rubricaRuoloModelImpl);

		rubricaRuolo.resetOriginalValues();

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaRuoloException {

		RubricaRuolo rubricaRuolo = fetchByPrimaryKey(primaryKey);

		if (rubricaRuolo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaRuoloException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo with the primary key or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo findByPrimaryKey(long ID_RUOLO)
		throws NoSuchRubricaRuoloException {

		return findByPrimaryKey((Serializable)ID_RUOLO);
	}

	/**
	 * Returns the rubrica ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo
	 * @return the rubrica ruolo, or <code>null</code> if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED, RubricaRuoloImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaRuolo rubricaRuolo = (RubricaRuolo)serializable;

		if (rubricaRuolo == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaRuolo = (RubricaRuolo)session.get(
					RubricaRuoloImpl.class, primaryKey);

				if (rubricaRuolo != null) {
					cacheResult(rubricaRuolo);
				}
				else {
					entityCache.putResult(
						RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
						RubricaRuoloImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo, or <code>null</code> if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo fetchByPrimaryKey(long ID_RUOLO) {
		return fetchByPrimaryKey((Serializable)ID_RUOLO);
	}

	@Override
	public Map<Serializable, RubricaRuolo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaRuolo> map =
			new HashMap<Serializable, RubricaRuolo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaRuolo rubricaRuolo = fetchByPrimaryKey(primaryKey);

			if (rubricaRuolo != null) {
				map.put(primaryKey, rubricaRuolo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
				RubricaRuoloImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaRuolo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICARUOLO_WHERE_PKS_IN);

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

			for (RubricaRuolo rubricaRuolo : (List<RubricaRuolo>)q.list()) {
				map.put(rubricaRuolo.getPrimaryKeyObj(), rubricaRuolo);

				cacheResult(rubricaRuolo);

				uncachedPrimaryKeys.remove(rubricaRuolo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
					RubricaRuoloImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica ruolos.
	 *
	 * @return the rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @return the range of rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll(
		int start, int end, OrderByComparator<RubricaRuolo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll(
		int start, int end, OrderByComparator<RubricaRuolo> orderByComparator,
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

		List<RubricaRuolo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaRuolo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICARUOLO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICARUOLO;

				if (pagination) {
					sql = sql.concat(RubricaRuoloModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaRuolo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaRuolo>)QueryUtil.list(
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
	 * Removes all the rubrica ruolos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaRuolo rubricaRuolo : findAll()) {
			remove(rubricaRuolo);
		}
	}

	/**
	 * Returns the number of rubrica ruolos.
	 *
	 * @return the number of rubrica ruolos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICARUOLO);

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
		return RubricaRuoloModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica ruolo persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloModelImpl.FINDER_CACHE_ENABLED, RubricaRuoloImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloModelImpl.FINDER_CACHE_ENABLED, RubricaRuoloImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByRubricaRuoloByRuoloLiferay = new FinderPath(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloModelImpl.FINDER_CACHE_ENABLED, RubricaRuoloImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRubricaRuoloByRuoloLiferay",
			new String[] {Long.class.getName()},
			RubricaRuoloModelImpl.FK_RUOLO_LIFERAY_COLUMN_BITMASK);

		_finderPathCountByRubricaRuoloByRuoloLiferay = new FinderPath(
			RubricaRuoloModelImpl.ENTITY_CACHE_ENABLED,
			RubricaRuoloModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaRuoloByRuoloLiferay",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaRuoloImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICARUOLO =
		"SELECT rubricaRuolo FROM RubricaRuolo rubricaRuolo";

	private static final String _SQL_SELECT_RUBRICARUOLO_WHERE_PKS_IN =
		"SELECT rubricaRuolo FROM RubricaRuolo rubricaRuolo WHERE ID_RUOLO IN (";

	private static final String _SQL_SELECT_RUBRICARUOLO_WHERE =
		"SELECT rubricaRuolo FROM RubricaRuolo rubricaRuolo WHERE ";

	private static final String _SQL_COUNT_RUBRICARUOLO =
		"SELECT COUNT(rubricaRuolo) FROM RubricaRuolo rubricaRuolo";

	private static final String _SQL_COUNT_RUBRICARUOLO_WHERE =
		"SELECT COUNT(rubricaRuolo) FROM RubricaRuolo rubricaRuolo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaRuolo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaRuolo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaRuolo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaRuoloPersistenceImpl.class);

}