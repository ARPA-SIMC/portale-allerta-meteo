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

import it.eng.allerta.messages.services.exception.NoSuchSmsSchedulerContextException;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.SmsSchedulerContextTable;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl;
import it.eng.allerta.messages.services.service.persistence.SmsSchedulerContextPersistence;
import it.eng.allerta.messages.services.service.persistence.SmsSchedulerContextUtil;
import it.eng.allerta.messages.services.service.persistence.impl.constants.smsServicePersistenceConstants;

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
 * The persistence implementation for the sms scheduler context service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@Component(service = SmsSchedulerContextPersistence.class)
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

		setModelImplClass(SmsSchedulerContextImpl.class);
		setModelPKClass(String.class);

		setTable(SmsSchedulerContextTable.INSTANCE);
	}

	/**
	 * Caches the sms scheduler context in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 */
	@Override
	public void cacheResult(SmsSchedulerContext smsSchedulerContext) {
		dummyEntityCache.putResult(
			SmsSchedulerContextImpl.class, smsSchedulerContext.getPrimaryKey(),
			smsSchedulerContext);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sms scheduler contexts in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContexts the sms scheduler contexts
	 */
	@Override
	public void cacheResult(List<SmsSchedulerContext> smsSchedulerContexts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smsSchedulerContexts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmsSchedulerContext smsSchedulerContext : smsSchedulerContexts) {
			if (dummyEntityCache.getResult(
					SmsSchedulerContextImpl.class,
					smsSchedulerContext.getPrimaryKey()) == null) {

				cacheResult(smsSchedulerContext);
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
		dummyEntityCache.clearCache(SmsSchedulerContextImpl.class);

		dummyFinderCache.clearCache(SmsSchedulerContextImpl.class);
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
		dummyEntityCache.removeResult(
			SmsSchedulerContextImpl.class, smsSchedulerContext);
	}

	@Override
	public void clearCache(List<SmsSchedulerContext> smsSchedulerContexts) {
		for (SmsSchedulerContext smsSchedulerContext : smsSchedulerContexts) {
			dummyEntityCache.removeResult(
				SmsSchedulerContextImpl.class, smsSchedulerContext);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(SmsSchedulerContextImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				SmsSchedulerContextImpl.class, primaryKey);
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
		catch (NoSuchSmsSchedulerContextException noSuchEntityException) {
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(smsSchedulerContext);
			}
			else {
				smsSchedulerContext = (SmsSchedulerContext)session.merge(
					smsSchedulerContext);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			SmsSchedulerContextImpl.class, smsSchedulerContext, false, true);

		if (isNew) {
			smsSchedulerContext.setNew(false);
		}

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
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context, or <code>null</code> if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public SmsSchedulerContext fetchByPrimaryKey(String varId) {
		return fetchByPrimaryKey((Serializable)varId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sms scheduler contexts
	 */
	@Override
	public List<SmsSchedulerContext> findAll(
		int start, int end,
		OrderByComparator<SmsSchedulerContext> orderByComparator,
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

		List<SmsSchedulerContext> list = null;

		if (useFinderCache) {
			list = (List<SmsSchedulerContext>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMSSCHEDULERCONTEXT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMSSCHEDULERCONTEXT;

				sql = sql.concat(SmsSchedulerContextModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmsSchedulerContext>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_SMSSCHEDULERCONTEXT);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
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
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "varId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMSSCHEDULERCONTEXT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmsSchedulerContextModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sms scheduler context persistence.
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

		SmsSchedulerContextUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SmsSchedulerContextUtil.setPersistence(null);

		dummyEntityCache.removeCache(SmsSchedulerContextImpl.class.getName());
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

	private static final String _SQL_SELECT_SMSSCHEDULERCONTEXT =
		"SELECT smsSchedulerContext FROM SmsSchedulerContext smsSchedulerContext";

	private static final String _SQL_COUNT_SMSSCHEDULERCONTEXT =
		"SELECT COUNT(smsSchedulerContext) FROM SmsSchedulerContext smsSchedulerContext";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smsSchedulerContext.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmsSchedulerContext exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SmsSchedulerContextPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}