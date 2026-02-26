/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.allerta.messages.services.exception.NoSuchNodoException;
import it.eng.allerta.messages.services.model.Nodo;
import it.eng.allerta.messages.services.model.NodoTable;
import it.eng.allerta.messages.services.model.impl.NodoImpl;
import it.eng.allerta.messages.services.model.impl.NodoModelImpl;
import it.eng.allerta.messages.services.service.persistence.NodoPersistence;
import it.eng.allerta.messages.services.service.persistence.NodoUtil;
import it.eng.allerta.messages.services.service.persistence.impl.constants.smsServicePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

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
@Component(service = NodoPersistence.class)
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
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nodoConnesso=");
			sb.append(nodoConnesso);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchNodoException(sb.toString());
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
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	@Override
	public Nodo fetchBynodoConnesso(
		String nodoConnesso, boolean useFinderCache) {

		nodoConnesso = Objects.toString(nodoConnesso, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nodoConnesso};
		}

		Object result = null;

		if (useFinderCache) {
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
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_NODO_WHERE);

			boolean bindNodoConnesso = false;

			if (nodoConnesso.isEmpty()) {
				sb.append(_FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_3);
			}
			else {
				bindNodoConnesso = true;

				sb.append(_FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNodoConnesso) {
					queryPos.add(nodoConnesso);
				}

				List<Nodo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBynodoConnesso, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {nodoConnesso};
							}

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
			catch (Exception exception) {
				throw processException(exception);
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
		Nodo nodo = fetchBynodoConnesso(nodoConnesso);

		if (nodo == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_2 =
		"nodo.nodoConnesso = ?";

	private static final String _FINDER_COLUMN_NODOCONNESSO_NODOCONNESSO_3 =
		"(nodo.nodoConnesso IS NULL OR nodo.nodoConnesso = '')";

	private FinderPath _finderPathFetchByip;

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
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ip=");
			sb.append(ip);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchNodoException(sb.toString());
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
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	@Override
	public Nodo fetchByip(String ip, boolean useFinderCache) {
		ip = Objects.toString(ip, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ip};
		}

		Object result = null;

		if (useFinderCache) {
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
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_NODO_WHERE);

			boolean bindIp = false;

			if (ip.isEmpty()) {
				sb.append(_FINDER_COLUMN_IP_IP_3);
			}
			else {
				bindIp = true;

				sb.append(_FINDER_COLUMN_IP_IP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIp) {
					queryPos.add(ip);
				}

				List<Nodo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByip, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {ip};
							}

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
			catch (Exception exception) {
				throw processException(exception);
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
		Nodo nodo = fetchByip(ip);

		if (nodo == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_IP_IP_2 = "nodo.ip = ?";

	private static final String _FINDER_COLUMN_IP_IP_3 =
		"(nodo.ip IS NULL OR nodo.ip = '')";

	public NodoPersistenceImpl() {
		setModelClass(Nodo.class);

		setModelImplClass(NodoImpl.class);
		setModelPKClass(long.class);

		setTable(NodoTable.INSTANCE);
	}

	/**
	 * Caches the nodo in the entity cache if it is enabled.
	 *
	 * @param nodo the nodo
	 */
	@Override
	public void cacheResult(Nodo nodo) {
		entityCache.putResult(NodoImpl.class, nodo.getPrimaryKey(), nodo);

		finderCache.putResult(
			_finderPathFetchBynodoConnesso,
			new Object[] {nodo.getNodoConnesso()}, nodo);

		finderCache.putResult(
			_finderPathFetchByip, new Object[] {nodo.getIp()}, nodo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the nodos in the entity cache if it is enabled.
	 *
	 * @param nodos the nodos
	 */
	@Override
	public void cacheResult(List<Nodo> nodos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (nodos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Nodo nodo : nodos) {
			if (entityCache.getResult(NodoImpl.class, nodo.getPrimaryKey()) ==
					null) {

				cacheResult(nodo);
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

		finderCache.clearCache(NodoImpl.class);
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
		entityCache.removeResult(NodoImpl.class, nodo);
	}

	@Override
	public void clearCache(List<Nodo> nodos) {
		for (Nodo nodo : nodos) {
			entityCache.removeResult(NodoImpl.class, nodo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NodoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NodoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(NodoModelImpl nodoModelImpl) {
		Object[] args = new Object[] {nodoModelImpl.getNodoConnesso()};

		finderCache.putResult(
			_finderPathFetchBynodoConnesso, args, nodoModelImpl);

		args = new Object[] {nodoModelImpl.getIp()};

		finderCache.putResult(_finderPathFetchByip, args, nodoModelImpl);
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
		catch (NoSuchNodoException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(nodo);
			}
			else {
				nodo = (Nodo)session.merge(nodo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(NodoImpl.class, nodoModelImpl, false, true);

		cacheUniqueFindersCache(nodoModelImpl);

		if (isNew) {
			nodo.setNew(false);
		}

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
	 * @param Id the primary key of the nodo
	 * @return the nodo, or <code>null</code> if a nodo with the primary key could not be found
	 */
	@Override
	public Nodo fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nodos
	 */
	@Override
	public List<Nodo> findAll(
		int start, int end, OrderByComparator<Nodo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Nodo> list = null;

		if (useFinderCache) {
			list = (List<Nodo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NODO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NODO;

				sql = sql.concat(NodoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Nodo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

				Query query = session.createQuery(_SQL_COUNT_NODO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NODO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NodoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the nodo persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchBynodoConnesso = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBynodoConnesso",
			new String[] {String.class.getName()},
			new String[] {"nodoConnesso"}, true);

		_finderPathFetchByip = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByip",
			new String[] {String.class.getName()}, new String[] {"ip"}, true);

		NodoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		NodoUtil.setPersistence(null);

		entityCache.removeCache(NodoImpl.class.getName());
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NODO = "SELECT nodo FROM Nodo nodo";

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

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}