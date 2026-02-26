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
import com.liferay.portal.kernel.util.SetUtil;

import it.eng.allerta.messages.services.exception.NoSuchAuthException;
import it.eng.allerta.messages.services.model.Auth;
import it.eng.allerta.messages.services.model.AuthTable;
import it.eng.allerta.messages.services.model.impl.AuthImpl;
import it.eng.allerta.messages.services.model.impl.AuthModelImpl;
import it.eng.allerta.messages.services.service.persistence.AuthPersistence;
import it.eng.allerta.messages.services.service.persistence.AuthUtil;
import it.eng.allerta.messages.services.service.persistence.impl.constants.smsServicePersistenceConstants;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the auth service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@Component(service = AuthPersistence.class)
public class AuthPersistenceImpl
	extends BasePersistenceImpl<Auth> implements AuthPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuthUtil</code> to access the auth persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuthImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AuthPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Auth.class);

		setModelImplClass(AuthImpl.class);
		setModelPKClass(String.class);

		setTable(AuthTable.INSTANCE);
	}

	/**
	 * Caches the auth in the entity cache if it is enabled.
	 *
	 * @param auth the auth
	 */
	@Override
	public void cacheResult(Auth auth) {
		entityCache.putResult(AuthImpl.class, auth.getPrimaryKey(), auth);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the auths in the entity cache if it is enabled.
	 *
	 * @param auths the auths
	 */
	@Override
	public void cacheResult(List<Auth> auths) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (auths.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Auth auth : auths) {
			if (entityCache.getResult(AuthImpl.class, auth.getPrimaryKey()) ==
					null) {

				cacheResult(auth);
			}
		}
	}

	/**
	 * Clears the cache for all auths.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuthImpl.class);

		finderCache.clearCache(AuthImpl.class);
	}

	/**
	 * Clears the cache for the auth.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Auth auth) {
		entityCache.removeResult(AuthImpl.class, auth);
	}

	@Override
	public void clearCache(List<Auth> auths) {
		for (Auth auth : auths) {
			entityCache.removeResult(AuthImpl.class, auth);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AuthImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuthImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new auth with the primary key. Does not add the auth to the database.
	 *
	 * @param key the primary key for the new auth
	 * @return the new auth
	 */
	@Override
	public Auth create(String key) {
		Auth auth = new AuthImpl();

		auth.setNew(true);
		auth.setPrimaryKey(key);

		return auth;
	}

	/**
	 * Removes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the auth
	 * @return the auth that was removed
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth remove(String key) throws NoSuchAuthException {
		return remove((Serializable)key);
	}

	/**
	 * Removes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auth
	 * @return the auth that was removed
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth remove(Serializable primaryKey) throws NoSuchAuthException {
		Session session = null;

		try {
			session = openSession();

			Auth auth = (Auth)session.get(AuthImpl.class, primaryKey);

			if (auth == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auth);
		}
		catch (NoSuchAuthException noSuchEntityException) {
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
	protected Auth removeImpl(Auth auth) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auth)) {
				auth = (Auth)session.get(
					AuthImpl.class, auth.getPrimaryKeyObj());
			}

			if (auth != null) {
				session.delete(auth);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (auth != null) {
			clearCache(auth);
		}

		return auth;
	}

	@Override
	public Auth updateImpl(Auth auth) {
		boolean isNew = auth.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(auth);
			}
			else {
				auth = (Auth)session.merge(auth);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AuthImpl.class, auth, false, true);

		if (isNew) {
			auth.setNew(false);
		}

		auth.resetOriginalValues();

		return auth;
	}

	/**
	 * Returns the auth with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auth
	 * @return the auth
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthException {

		Auth auth = fetchByPrimaryKey(primaryKey);

		if (auth == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auth;
	}

	/**
	 * Returns the auth with the primary key or throws a <code>NoSuchAuthException</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	@Override
	public Auth findByPrimaryKey(String key) throws NoSuchAuthException {
		return findByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns the auth with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth, or <code>null</code> if a auth with the primary key could not be found
	 */
	@Override
	public Auth fetchByPrimaryKey(String key) {
		return fetchByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns all the auths.
	 *
	 * @return the auths
	 */
	@Override
	public List<Auth> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @return the range of auths
	 */
	@Override
	public List<Auth> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auths
	 */
	@Override
	public List<Auth> findAll(
		int start, int end, OrderByComparator<Auth> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auths
	 */
	@Override
	public List<Auth> findAll(
		int start, int end, OrderByComparator<Auth> orderByComparator,
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

		List<Auth> list = null;

		if (useFinderCache) {
			list = (List<Auth>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUTH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUTH;

				sql = sql.concat(AuthModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Auth>)QueryUtil.list(
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
	 * Removes all the auths from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Auth auth : findAll()) {
			remove(auth);
		}
	}

	/**
	 * Returns the number of auths.
	 *
	 * @return the number of auths
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUTH);

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
		return "key_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUTH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuthModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the auth persistence.
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

		AuthUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AuthUtil.setPersistence(null);

		entityCache.removeCache(AuthImpl.class.getName());
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

	private static final String _SQL_SELECT_AUTH = "SELECT auth FROM Auth auth";

	private static final String _SQL_COUNT_AUTH =
		"SELECT COUNT(auth) FROM Auth auth";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auth.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Auth exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AuthPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}