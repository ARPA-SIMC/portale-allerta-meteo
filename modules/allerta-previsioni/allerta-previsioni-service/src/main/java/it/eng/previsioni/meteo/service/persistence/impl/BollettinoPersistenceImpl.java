/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.previsioni.meteo.exception.NoSuchBollettinoException;
import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.model.BollettinoTable;
import it.eng.previsioni.meteo.model.impl.BollettinoImpl;
import it.eng.previsioni.meteo.model.impl.BollettinoModelImpl;
import it.eng.previsioni.meteo.service.persistence.BollettinoPersistence;
import it.eng.previsioni.meteo.service.persistence.BollettinoUtil;
import it.eng.previsioni.meteo.service.persistence.impl.constants.prev_meteoPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
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
 * The persistence implementation for the bollettino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BollettinoPersistence.class)
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
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tipo=");
			sb.append(tipo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBollettinoException(sb.toString());
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
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchBytipo(String tipo, boolean useFinderCache) {
		tipo = Objects.toString(tipo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tipo};
		}

		Object result = null;

		if (useFinderCache) {
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
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_TIPO_TIPO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				List<Bollettino> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBytipo, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {tipo};
							}

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
		Bollettino bollettino = fetchBytipo(tipo);

		if (bollettino == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_TIPO_TIPO_2 =
		"bollettino.tipo = ?";

	private static final String _FINDER_COLUMN_TIPO_TIPO_3 =
		"(bollettino.tipo IS NULL OR bollettino.tipo = '')";

	public BollettinoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Bollettino.class);

		setModelImplClass(BollettinoImpl.class);
		setModelPKClass(long.class);

		setTable(BollettinoTable.INSTANCE);
	}

	/**
	 * Caches the bollettino in the entity cache if it is enabled.
	 *
	 * @param bollettino the bollettino
	 */
	@Override
	public void cacheResult(Bollettino bollettino) {
		entityCache.putResult(
			BollettinoImpl.class, bollettino.getPrimaryKey(), bollettino);

		finderCache.putResult(
			_finderPathFetchBytipo, new Object[] {bollettino.getTipo()},
			bollettino);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bollettinos in the entity cache if it is enabled.
	 *
	 * @param bollettinos the bollettinos
	 */
	@Override
	public void cacheResult(List<Bollettino> bollettinos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bollettinos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Bollettino bollettino : bollettinos) {
			if (entityCache.getResult(
					BollettinoImpl.class, bollettino.getPrimaryKey()) == null) {

				cacheResult(bollettino);
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

		finderCache.clearCache(BollettinoImpl.class);
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
		entityCache.removeResult(BollettinoImpl.class, bollettino);
	}

	@Override
	public void clearCache(List<Bollettino> bollettinos) {
		for (Bollettino bollettino : bollettinos) {
			entityCache.removeResult(BollettinoImpl.class, bollettino);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BollettinoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BollettinoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BollettinoModelImpl bollettinoModelImpl) {

		Object[] args = new Object[] {bollettinoModelImpl.getTipo()};

		finderCache.putResult(
			_finderPathFetchBytipo, args, bollettinoModelImpl);
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
		catch (NoSuchBollettinoException noSuchEntityException) {
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(bollettino);
			}
			else {
				bollettino = (Bollettino)session.merge(bollettino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BollettinoImpl.class, bollettinoModelImpl, false, true);

		cacheUniqueFindersCache(bollettinoModelImpl);

		if (isNew) {
			bollettino.setNew(false);
		}

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
	 * @param id the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator,
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

		List<Bollettino> list = null;

		if (useFinderCache) {
			list = (List<Bollettino>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOLLETTINO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINO;

				sql = sql.concat(BollettinoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Bollettino>)QueryUtil.list(
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

				Query query = session.createQuery(_SQL_COUNT_BOLLETTINO);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOLLETTINO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BollettinoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino persistence.
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

		_finderPathFetchBytipo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBytipo",
			new String[] {String.class.getName()}, new String[] {"tipo"}, true);

		BollettinoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BollettinoUtil.setPersistence(null);

		entityCache.removeCache(BollettinoImpl.class.getName());
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOLLETTINO =
		"SELECT bollettino FROM Bollettino bollettino";

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

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}