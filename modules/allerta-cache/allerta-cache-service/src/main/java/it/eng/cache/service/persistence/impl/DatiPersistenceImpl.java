/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.service.persistence.impl;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.cache.exception.NoSuchDatiException;
import it.eng.cache.model.Dati;
import it.eng.cache.model.DatiTable;
import it.eng.cache.model.impl.DatiImpl;
import it.eng.cache.model.impl.DatiModelImpl;
import it.eng.cache.service.persistence.DatiPersistence;
import it.eng.cache.service.persistence.DatiUtil;
import it.eng.cache.service.persistence.impl.constants.CACHEPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dati service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = DatiPersistence.class)
public class DatiPersistenceImpl
	extends BasePersistenceImpl<Dati> implements DatiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DatiUtil</code> to access the dati persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DatiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DatiPersistenceImpl() {
		setModelClass(Dati.class);

		setModelImplClass(DatiImpl.class);
		setModelPKClass(String.class);

		setTable(DatiTable.INSTANCE);
	}

	/**
	 * Caches the dati in the entity cache if it is enabled.
	 *
	 * @param dati the dati
	 */
	@Override
	public void cacheResult(Dati dati) {
		dummyEntityCache.putResult(DatiImpl.class, dati.getPrimaryKey(), dati);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the datis in the entity cache if it is enabled.
	 *
	 * @param datis the datis
	 */
	@Override
	public void cacheResult(List<Dati> datis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (datis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Dati dati : datis) {
			if (dummyEntityCache.getResult(
					DatiImpl.class, dati.getPrimaryKey()) == null) {

				cacheResult(dati);
			}
		}
	}

	/**
	 * Clears the cache for all datis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(DatiImpl.class);

		dummyFinderCache.clearCache(DatiImpl.class);
	}

	/**
	 * Clears the cache for the dati.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dati dati) {
		dummyEntityCache.removeResult(DatiImpl.class, dati);
	}

	@Override
	public void clearCache(List<Dati> datis) {
		for (Dati dati : datis) {
			dummyEntityCache.removeResult(DatiImpl.class, dati);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(DatiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(DatiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dati with the primary key. Does not add the dati to the database.
	 *
	 * @param idDati the primary key for the new dati
	 * @return the new dati
	 */
	@Override
	public Dati create(String idDati) {
		Dati dati = new DatiImpl();

		dati.setNew(true);
		dati.setPrimaryKey(idDati);

		return dati;
	}

	/**
	 * Removes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati that was removed
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati remove(String idDati) throws NoSuchDatiException {
		return remove((Serializable)idDati);
	}

	/**
	 * Removes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dati
	 * @return the dati that was removed
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati remove(Serializable primaryKey) throws NoSuchDatiException {
		Session session = null;

		try {
			session = openSession();

			Dati dati = (Dati)session.get(DatiImpl.class, primaryKey);

			if (dati == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDatiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dati);
		}
		catch (NoSuchDatiException noSuchEntityException) {
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
	protected Dati removeImpl(Dati dati) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dati)) {
				dati = (Dati)session.get(
					DatiImpl.class, dati.getPrimaryKeyObj());
			}

			if (dati != null) {
				session.delete(dati);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dati != null) {
			clearCache(dati);
		}

		return dati;
	}

	@Override
	public Dati updateImpl(Dati dati) {
		boolean isNew = dati.isNew();

		if (!(dati instanceof DatiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dati.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dati);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dati proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Dati implementation " +
					dati.getClass());
		}

		DatiModelImpl datiModelImpl = (DatiModelImpl)dati;

		if (isNew && (dati.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dati.setCreateDate(date);
			}
			else {
				dati.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dati);
			}
			else {
				dati = (Dati)session.merge(dati);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(DatiImpl.class, dati, false, true);

		if (isNew) {
			dati.setNew(false);
		}

		dati.resetOriginalValues();

		return dati;
	}

	/**
	 * Returns the dati with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dati
	 * @return the dati
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDatiException {

		Dati dati = fetchByPrimaryKey(primaryKey);

		if (dati == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDatiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dati;
	}

	/**
	 * Returns the dati with the primary key or throws a <code>NoSuchDatiException</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	@Override
	public Dati findByPrimaryKey(String idDati) throws NoSuchDatiException {
		return findByPrimaryKey((Serializable)idDati);
	}

	/**
	 * Returns the dati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati, or <code>null</code> if a dati with the primary key could not be found
	 */
	@Override
	public Dati fetchByPrimaryKey(String idDati) {
		return fetchByPrimaryKey((Serializable)idDati);
	}

	/**
	 * Returns all the datis.
	 *
	 * @return the datis
	 */
	@Override
	public List<Dati> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @return the range of datis
	 */
	@Override
	public List<Dati> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datis
	 */
	@Override
	public List<Dati> findAll(
		int start, int end, OrderByComparator<Dati> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of datis
	 */
	@Override
	public List<Dati> findAll(
		int start, int end, OrderByComparator<Dati> orderByComparator,
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

		List<Dati> list = null;

		if (useFinderCache) {
			list = (List<Dati>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATI;

				sql = sql.concat(DatiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Dati>)QueryUtil.list(
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
	 * Removes all the datis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dati dati : findAll()) {
			remove(dati);
		}
	}

	/**
	 * Returns the number of datis.
	 *
	 * @return the number of datis
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATI);

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
		return "idDati";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DatiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dati persistence.
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

		DatiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DatiUtil.setPersistence(null);

		dummyEntityCache.removeCache(DatiImpl.class.getName());
	}

	@Override
	@Reference(
		target = CACHEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CACHEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CACHEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_DATI = "SELECT dati FROM Dati dati";

	private static final String _SQL_COUNT_DATI =
		"SELECT COUNT(dati) FROM Dati dati";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dati.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Dati exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DatiPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}