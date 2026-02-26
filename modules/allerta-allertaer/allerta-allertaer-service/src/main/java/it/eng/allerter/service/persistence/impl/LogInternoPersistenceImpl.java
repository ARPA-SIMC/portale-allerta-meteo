/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import it.eng.allerter.exception.NoSuchLogInternoException;
import it.eng.allerter.model.LogInterno;
import it.eng.allerter.model.LogInternoTable;
import it.eng.allerter.model.impl.LogInternoImpl;
import it.eng.allerter.model.impl.LogInternoModelImpl;
import it.eng.allerter.service.persistence.LogInternoPersistence;
import it.eng.allerter.service.persistence.LogInternoUtil;
import it.eng.allerter.service.persistence.impl.constants.ALLERTERPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the log interno service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = LogInternoPersistence.class)
public class LogInternoPersistenceImpl
	extends BasePersistenceImpl<LogInterno> implements LogInternoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LogInternoUtil</code> to access the log interno persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LogInternoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public LogInternoPersistenceImpl() {
		setModelClass(LogInterno.class);

		setModelImplClass(LogInternoImpl.class);
		setModelPKClass(long.class);

		setTable(LogInternoTable.INSTANCE);
	}

	/**
	 * Caches the log interno in the entity cache if it is enabled.
	 *
	 * @param logInterno the log interno
	 */
	@Override
	public void cacheResult(LogInterno logInterno) {
		entityCache.putResult(
			LogInternoImpl.class, logInterno.getPrimaryKey(), logInterno);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the log internos in the entity cache if it is enabled.
	 *
	 * @param logInternos the log internos
	 */
	@Override
	public void cacheResult(List<LogInterno> logInternos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (logInternos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LogInterno logInterno : logInternos) {
			if (entityCache.getResult(
					LogInternoImpl.class, logInterno.getPrimaryKey()) == null) {

				cacheResult(logInterno);
			}
		}
	}

	/**
	 * Clears the cache for all log internos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogInternoImpl.class);

		finderCache.clearCache(LogInternoImpl.class);
	}

	/**
	 * Clears the cache for the log interno.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogInterno logInterno) {
		entityCache.removeResult(LogInternoImpl.class, logInterno);
	}

	@Override
	public void clearCache(List<LogInterno> logInternos) {
		for (LogInterno logInterno : logInternos) {
			entityCache.removeResult(LogInternoImpl.class, logInterno);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LogInternoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LogInternoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new log interno with the primary key. Does not add the log interno to the database.
	 *
	 * @param logId the primary key for the new log interno
	 * @return the new log interno
	 */
	@Override
	public LogInterno create(long logId) {
		LogInterno logInterno = new LogInternoImpl();

		logInterno.setNew(true);
		logInterno.setPrimaryKey(logId);

		return logInterno;
	}

	/**
	 * Removes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno remove(long logId) throws NoSuchLogInternoException {
		return remove((Serializable)logId);
	}

	/**
	 * Removes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno remove(Serializable primaryKey)
		throws NoSuchLogInternoException {

		Session session = null;

		try {
			session = openSession();

			LogInterno logInterno = (LogInterno)session.get(
				LogInternoImpl.class, primaryKey);

			if (logInterno == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogInternoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(logInterno);
		}
		catch (NoSuchLogInternoException noSuchEntityException) {
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
	protected LogInterno removeImpl(LogInterno logInterno) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logInterno)) {
				logInterno = (LogInterno)session.get(
					LogInternoImpl.class, logInterno.getPrimaryKeyObj());
			}

			if (logInterno != null) {
				session.delete(logInterno);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (logInterno != null) {
			clearCache(logInterno);
		}

		return logInterno;
	}

	@Override
	public LogInterno updateImpl(LogInterno logInterno) {
		boolean isNew = logInterno.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(logInterno);
			}
			else {
				logInterno = (LogInterno)session.merge(logInterno);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LogInternoImpl.class, logInterno, false, true);

		if (isNew) {
			logInterno.setNew(false);
		}

		logInterno.resetOriginalValues();

		return logInterno;
	}

	/**
	 * Returns the log interno with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log interno
	 * @return the log interno
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogInternoException {

		LogInterno logInterno = fetchByPrimaryKey(primaryKey);

		if (logInterno == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogInternoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return logInterno;
	}

	/**
	 * Returns the log interno with the primary key or throws a <code>NoSuchLogInternoException</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno findByPrimaryKey(long logId)
		throws NoSuchLogInternoException {

		return findByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns the log interno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno, or <code>null</code> if a log interno with the primary key could not be found
	 */
	@Override
	public LogInterno fetchByPrimaryKey(long logId) {
		return fetchByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns all the log internos.
	 *
	 * @return the log internos
	 */
	@Override
	public List<LogInterno> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @return the range of log internos
	 */
	@Override
	public List<LogInterno> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log internos
	 */
	@Override
	public List<LogInterno> findAll(
		int start, int end, OrderByComparator<LogInterno> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of log internos
	 */
	@Override
	public List<LogInterno> findAll(
		int start, int end, OrderByComparator<LogInterno> orderByComparator,
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

		List<LogInterno> list = null;

		if (useFinderCache) {
			list = (List<LogInterno>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOGINTERNO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOGINTERNO;

				sql = sql.concat(LogInternoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LogInterno>)QueryUtil.list(
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
	 * Removes all the log internos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogInterno logInterno : findAll()) {
			remove(logInterno);
		}
	}

	/**
	 * Returns the number of log internos.
	 *
	 * @return the number of log internos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOGINTERNO);

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
		return "logId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOGINTERNO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LogInternoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the log interno persistence.
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

		LogInternoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LogInternoUtil.setPersistence(null);

		entityCache.removeCache(LogInternoImpl.class.getName());
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LOGINTERNO =
		"SELECT logInterno FROM LogInterno logInterno";

	private static final String _SQL_COUNT_LOGINTERNO =
		"SELECT COUNT(logInterno) FROM LogInterno logInterno";

	private static final String _ORDER_BY_ENTITY_ALIAS = "logInterno.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LogInterno exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		LogInternoPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}