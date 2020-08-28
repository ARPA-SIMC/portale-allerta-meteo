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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerta.messages.services.exception.NoSuchNodoException;
import it.eng.allerta.messages.services.model.Nodo;
import it.eng.allerta.messages.services.model.impl.NodoImpl;
import it.eng.allerta.messages.services.model.impl.NodoModelImpl;
import it.eng.allerta.messages.services.service.persistence.NodoPersistence;

import java.io.Serializable;

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
 * The persistence implementation for the nodo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class NodoPersistenceImpl
	extends BasePersistenceImpl<Nodo> implements NodoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NodoUtil</code> to access the nodo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NodoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBynodoConnesso;
	private FinderPath _finderPathCountBynodoConnesso;

	/**
	 * Returns the nodo where nodoConnesso = &#63; or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the matching nodo
	 * @throws NoSuchNodoException if a matching nodo could not be found
	 */
	@Override
	public Nodo findBynodoConnesso(String nodoConnesso)
		throws NoSuchNodoException {

		Nodo nodo = fetchBynodoConnesso(nodoConnesso);

		if (nodo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nodoConnesso=");
			msg.append(nodoConnesso);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchNodoException(msg.toString());
		}

		return nodo;
	}

	/**
	 * Returns the nodo where nodoConnesso = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	@Override
	public Nodo fetchBynodoConnesso(String nodoConnesso) {
		return fetchBynodoConnesso(nodoConnesso, true);
	}

	/**
	 * Returns the nodo where nodoConnesso = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	@Override
	public Nodo fetchBynodoConnesso(
		String nodoConnesso, boolean retrieveFromCache) {

		nodoConnesso = Objects.toString(nodoConnesso, "");

		Object[] finderArgs = new Object[] {nodoConnesso};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBynodoConnesso, finderArgs, this);
		}

		if (result instanceof Nodo) {
			Nodo nodo = (Nodo)result;

			if (!Objects.equals(nodoConnesso, nodo.getNodoConnesso())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NODO_WHERE);

			boolean bindNodoConnesso = false;

			if (nodoConnesso.isEmpty()) {
				query.append(_FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_3);
			}
			else {
				bindNodoConnesso = true;

				query.append(_FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNodoConnesso) {
					qPos.add(nodoConnesso);
				}

				List<Nodo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBynodoConnesso, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"NodoPersistenceImpl.fetchBynodoConnesso(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Nodo nodo = list.get(0);

					result = nodo;

					cacheResult(nodo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBynodoConnesso, finderArgs);

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
			return (Nodo)result;
		}
	}

	/**
	 * Removes the nodo where nodoConnesso = &#63; from the database.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the nodo that was removed
	 */
	@Override
	public Nodo removeBynodoConnesso(String nodoConnesso)
		throws NoSuchNodoException {

		Nodo nodo = findBynodoConnesso(nodoConnesso);

		return remove(nodo);
	}

	/**
	 * Returns the number of nodos where nodoConnesso = &#63;.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the number of matching nodos
	 */
	@Override
	public int countBynodoConnesso(String nodoConnesso) {
		nodoConnesso = Objects.toString(nodoConnesso, "");

		FinderPath finderPath = _finderPathCountBynodoConnesso;

		Object[] finderArgs = new Object[] {nodoConnesso};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NODO_WHERE);

			boolean bindNodoConnesso = false;

			if (nodoConnesso.isEmpty()) {
				query.append(_FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_3);
			}
			else {
				bindNodoConnesso = true;

				query.append(_FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNodoConnesso) {
					qPos.add(nodoConnesso);
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

	private static final String _FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_2 =
		"nodo.nodoConnesso = ?";

	private static final String _FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_3 =
		"(nodo.nodoConnesso IS NULL OR nodo.nodoConnesso = '')";

	private FinderPath _finderPathFetchByip;
	private FinderPath _finderPathCountByip;

	/**
	 * Returns the nodo where ip = &#63; or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param ip the ip
	 * @return the matching nodo
	 * @throws NoSuchNodoException if a matching nodo could not be found
	 */
	@Override
	public Nodo findByip(String ip) throws NoSuchNodoException {
		Nodo nodo = fetchByip(ip);

		if (nodo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ip=");
			msg.append(ip);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchNodoException(msg.toString());
		}

		return nodo;
	}

	/**
	 * Returns the nodo where ip = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ip the ip
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	@Override
	public Nodo fetchByip(String ip) {
		return fetchByip(ip, true);
	}

	/**
	 * Returns the nodo where ip = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ip the ip
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	@Override
	public Nodo fetchByip(String ip, boolean retrieveFromCache) {
		ip = Objects.toString(ip, "");

		Object[] finderArgs = new Object[] {ip};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByip, finderArgs, this);
		}

		if (result instanceof Nodo) {
			Nodo nodo = (Nodo)result;

			if (!Objects.equals(ip, nodo.getIp())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NODO_WHERE);

			boolean bindIp = false;

			if (ip.isEmpty()) {
				query.append(_FINDER_COLUMN_IP_IP_3);
			}
			else {
				bindIp = true;

				query.append(_FINDER_COLUMN_IP_IP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIp) {
					qPos.add(ip);
				}

				List<Nodo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByip, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"NodoPersistenceImpl.fetchByip(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Nodo nodo = list.get(0);

					result = nodo;

					cacheResult(nodo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByip, finderArgs);

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
			return (Nodo)result;
		}
	}

	/**
	 * Removes the nodo where ip = &#63; from the database.
	 *
	 * @param ip the ip
	 * @return the nodo that was removed
	 */
	@Override
	public Nodo removeByip(String ip) throws NoSuchNodoException {
		Nodo nodo = findByip(ip);

		return remove(nodo);
	}

	/**
	 * Returns the number of nodos where ip = &#63;.
	 *
	 * @param ip the ip
	 * @return the number of matching nodos
	 */
	@Override
	public int countByip(String ip) {
		ip = Objects.toString(ip, "");

		FinderPath finderPath = _finderPathCountByip;

		Object[] finderArgs = new Object[] {ip};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NODO_WHERE);

			boolean bindIp = false;

			if (ip.isEmpty()) {
				query.append(_FINDER_COLUMN_IP_IP_3);
			}
			else {
				bindIp = true;

				query.append(_FINDER_COLUMN_IP_IP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIp) {
					qPos.add(ip);
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

	private static final String _FINDER_COLUMN_IP_IP_2 = "nodo.ip = ?";

	private static final String _FINDER_COLUMN_IP_IP_3 =
		"(nodo.ip IS NULL OR nodo.ip = '')";

	public NodoPersistenceImpl() {
		setModelClass(Nodo.class);
	}

	/**
	 * Caches the nodo in the entity cache if it is enabled.
	 *
	 * @param nodo the nodo
	 */
	@Override
	public void cacheResult(Nodo nodo) {
		entityCache.putResult(
			NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
			nodo.getPrimaryKey(), nodo);

		finderCache.putResult(
			_finderPathFetchBynodoConnesso,
			new Object[] {nodo.getNodoConnesso()}, nodo);

		finderCache.putResult(
			_finderPathFetchByip, new Object[] {nodo.getIp()}, nodo);

		nodo.resetOriginalValues();
	}

	/**
	 * Caches the nodos in the entity cache if it is enabled.
	 *
	 * @param nodos the nodos
	 */
	@Override
	public void cacheResult(List<Nodo> nodos) {
		for (Nodo nodo : nodos) {
			if (entityCache.getResult(
					NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
					nodo.getPrimaryKey()) == null) {

				cacheResult(nodo);
			}
			else {
				nodo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nodos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NodoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nodo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Nodo nodo) {
		entityCache.removeResult(
			NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
			nodo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((NodoModelImpl)nodo, true);
	}

	@Override
	public void clearCache(List<Nodo> nodos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Nodo nodo : nodos) {
			entityCache.removeResult(
				NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
				nodo.getPrimaryKey());

			clearUniqueFindersCache((NodoModelImpl)nodo, true);
		}
	}

	protected void cacheUniqueFindersCache(NodoModelImpl nodoModelImpl) {
		Object[] args = new Object[] {nodoModelImpl.getNodoConnesso()};

		finderCache.putResult(
			_finderPathCountBynodoConnesso, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBynodoConnesso, args, nodoModelImpl, false);

		args = new Object[] {nodoModelImpl.getIp()};

		finderCache.putResult(
			_finderPathCountByip, args, Long.valueOf(1), false);
		finderCache.putResult(_finderPathFetchByip, args, nodoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		NodoModelImpl nodoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {nodoModelImpl.getNodoConnesso()};

			finderCache.removeResult(_finderPathCountBynodoConnesso, args);
			finderCache.removeResult(_finderPathFetchBynodoConnesso, args);
		}

		if ((nodoModelImpl.getColumnBitmask() &
			 _finderPathFetchBynodoConnesso.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				nodoModelImpl.getOriginalNodoConnesso()
			};

			finderCache.removeResult(_finderPathCountBynodoConnesso, args);
			finderCache.removeResult(_finderPathFetchBynodoConnesso, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {nodoModelImpl.getIp()};

			finderCache.removeResult(_finderPathCountByip, args);
			finderCache.removeResult(_finderPathFetchByip, args);
		}

		if ((nodoModelImpl.getColumnBitmask() &
			 _finderPathFetchByip.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {nodoModelImpl.getOriginalIp()};

			finderCache.removeResult(_finderPathCountByip, args);
			finderCache.removeResult(_finderPathFetchByip, args);
		}
	}

	/**
	 * Creates a new nodo with the primary key. Does not add the nodo to the database.
	 *
	 * @param Id the primary key for the new nodo
	 * @return the new nodo
	 */
	@Override
	public Nodo create(long Id) {
		Nodo nodo = new NodoImpl();

		nodo.setNew(true);
		nodo.setPrimaryKey(Id);

		return nodo;
	}

	/**
	 * Removes the nodo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo that was removed
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo remove(long Id) throws NoSuchNodoException {
		return remove((Serializable)Id);
	}

	/**
	 * Removes the nodo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nodo
	 * @return the nodo that was removed
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo remove(Serializable primaryKey) throws NoSuchNodoException {
		Session session = null;

		try {
			session = openSession();

			Nodo nodo = (Nodo)session.get(NodoImpl.class, primaryKey);

			if (nodo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNodoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(nodo);
		}
		catch (NoSuchNodoException nsee) {
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
	protected Nodo removeImpl(Nodo nodo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nodo)) {
				nodo = (Nodo)session.get(
					NodoImpl.class, nodo.getPrimaryKeyObj());
			}

			if (nodo != null) {
				session.delete(nodo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nodo != null) {
			clearCache(nodo);
		}

		return nodo;
	}

	@Override
	public Nodo updateImpl(Nodo nodo) {
		boolean isNew = nodo.isNew();

		if (!(nodo instanceof NodoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(nodo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(nodo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in nodo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Nodo implementation " +
					nodo.getClass());
		}

		NodoModelImpl nodoModelImpl = (NodoModelImpl)nodo;

		Session session = null;

		try {
			session = openSession();

			if (nodo.isNew()) {
				session.save(nodo);

				nodo.setNew(false);
			}
			else {
				nodo = (Nodo)session.merge(nodo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!NodoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
			nodo.getPrimaryKey(), nodo, false);

		clearUniqueFindersCache(nodoModelImpl, false);
		cacheUniqueFindersCache(nodoModelImpl);

		nodo.resetOriginalValues();

		return nodo;
	}

	/**
	 * Returns the nodo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nodo
	 * @return the nodo
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNodoException {

		Nodo nodo = fetchByPrimaryKey(primaryKey);

		if (nodo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNodoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return nodo;
	}

	/**
	 * Returns the nodo with the primary key or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo findByPrimaryKey(long Id) throws NoSuchNodoException {
		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the nodo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nodo
	 * @return the nodo, or <code>null</code> if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Nodo nodo = (Nodo)serializable;

		if (nodo == null) {
			Session session = null;

			try {
				session = openSession();

				nodo = (Nodo)session.get(NodoImpl.class, primaryKey);

				if (nodo != null) {
					cacheResult(nodo);
				}
				else {
					entityCache.putResult(
						NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nodo;
	}

	/**
	 * Returns the nodo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo, or <code>null</code> if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	@Override
	public Map<Serializable, Nodo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Nodo> map = new HashMap<Serializable, Nodo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Nodo nodo = fetchByPrimaryKey(primaryKey);

			if (nodo != null) {
				map.put(primaryKey, nodo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Nodo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_NODO_WHERE_PKS_IN);

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

			for (Nodo nodo : (List<Nodo>)q.list()) {
				map.put(nodo.getPrimaryKeyObj(), nodo);

				cacheResult(nodo);

				uncachedPrimaryKeys.remove(nodo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					NodoModelImpl.ENTITY_CACHE_ENABLED, NodoImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the nodos.
	 *
	 * @return the nodos
	 */
	@Override
	public List<Nodo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @return the range of nodos
	 */
	@Override
	public List<Nodo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nodos
	 */
	@Override
	public List<Nodo> findAll(
		int start, int end, OrderByComparator<Nodo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of nodos
	 */
	@Override
	public List<Nodo> findAll(
		int start, int end, OrderByComparator<Nodo> orderByComparator,
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

		List<Nodo> list = null;

		if (retrieveFromCache) {
			list = (List<Nodo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NODO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NODO;

				if (pagination) {
					sql = sql.concat(NodoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Nodo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Nodo>)QueryUtil.list(
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
	 * Removes all the nodos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Nodo nodo : findAll()) {
			remove(nodo);
		}
	}

	/**
	 * Returns the number of nodos.
	 *
	 * @return the number of nodos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NODO);

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
		return NodoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the nodo persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, NodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, NodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBynodoConnesso = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, NodoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBynodoConnesso",
			new String[] {String.class.getName()},
			NodoModelImpl.NODOCONNESSO_COLUMN_BITMASK);

		_finderPathCountBynodoConnesso = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynodoConnesso",
			new String[] {String.class.getName()});

		_finderPathFetchByip = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, NodoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByip",
			new String[] {String.class.getName()},
			NodoModelImpl.IP_COLUMN_BITMASK);

		_finderPathCountByip = new FinderPath(
			NodoModelImpl.ENTITY_CACHE_ENABLED,
			NodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByip",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(NodoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NODO = "SELECT nodo FROM Nodo nodo";

	private static final String _SQL_SELECT_NODO_WHERE_PKS_IN =
		"SELECT nodo FROM Nodo nodo WHERE Id IN (";

	private static final String _SQL_SELECT_NODO_WHERE =
		"SELECT nodo FROM Nodo nodo WHERE ";

	private static final String _SQL_COUNT_NODO =
		"SELECT COUNT(nodo) FROM Nodo nodo";

	private static final String _SQL_COUNT_NODO_WHERE =
		"SELECT COUNT(nodo) FROM Nodo nodo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "nodo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Nodo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Nodo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NodoPersistenceImpl.class);

}