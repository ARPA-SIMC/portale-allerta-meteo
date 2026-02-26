/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.impl;

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

import it.eng.parer.exception.NoSuchParametriException;
import it.eng.parer.model.Parametri;
import it.eng.parer.model.ParametriTable;
import it.eng.parer.model.impl.ParametriImpl;
import it.eng.parer.model.impl.ParametriModelImpl;
import it.eng.parer.service.persistence.ParametriPersistence;
import it.eng.parer.service.persistence.ParametriUtil;
import it.eng.parer.service.persistence.impl.constants.parerPersistenceConstants;

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
 * The persistence implementation for the parametri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = ParametriPersistence.class)
public class ParametriPersistenceImpl
	extends BasePersistenceImpl<Parametri> implements ParametriPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParametriUtil</code> to access the parametri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParametriImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ParametriPersistenceImpl() {
		setModelClass(Parametri.class);

		setModelImplClass(ParametriImpl.class);
		setModelPKClass(String.class);

		setTable(ParametriTable.INSTANCE);
	}

	/**
	 * Caches the parametri in the entity cache if it is enabled.
	 *
	 * @param parametri the parametri
	 */
	@Override
	public void cacheResult(Parametri parametri) {
		entityCache.putResult(
			ParametriImpl.class, parametri.getPrimaryKey(), parametri);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the parametris in the entity cache if it is enabled.
	 *
	 * @param parametris the parametris
	 */
	@Override
	public void cacheResult(List<Parametri> parametris) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (parametris.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Parametri parametri : parametris) {
			if (entityCache.getResult(
					ParametriImpl.class, parametri.getPrimaryKey()) == null) {

				cacheResult(parametri);
			}
		}
	}

	/**
	 * Clears the cache for all parametris.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParametriImpl.class);

		finderCache.clearCache(ParametriImpl.class);
	}

	/**
	 * Clears the cache for the parametri.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametri parametri) {
		entityCache.removeResult(ParametriImpl.class, parametri);
	}

	@Override
	public void clearCache(List<Parametri> parametris) {
		for (Parametri parametri : parametris) {
			entityCache.removeResult(ParametriImpl.class, parametri);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ParametriImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ParametriImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new parametri with the primary key. Does not add the parametri to the database.
	 *
	 * @param chiave the primary key for the new parametri
	 * @return the new parametri
	 */
	@Override
	public Parametri create(String chiave) {
		Parametri parametri = new ParametriImpl();

		parametri.setNew(true);
		parametri.setPrimaryKey(chiave);

		return parametri;
	}

	/**
	 * Removes the parametri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri that was removed
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri remove(String chiave) throws NoSuchParametriException {
		return remove((Serializable)chiave);
	}

	/**
	 * Removes the parametri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametri
	 * @return the parametri that was removed
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri remove(Serializable primaryKey)
		throws NoSuchParametriException {

		Session session = null;

		try {
			session = openSession();

			Parametri parametri = (Parametri)session.get(
				ParametriImpl.class, primaryKey);

			if (parametri == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametriException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(parametri);
		}
		catch (NoSuchParametriException noSuchEntityException) {
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
	protected Parametri removeImpl(Parametri parametri) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parametri)) {
				parametri = (Parametri)session.get(
					ParametriImpl.class, parametri.getPrimaryKeyObj());
			}

			if (parametri != null) {
				session.delete(parametri);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (parametri != null) {
			clearCache(parametri);
		}

		return parametri;
	}

	@Override
	public Parametri updateImpl(Parametri parametri) {
		boolean isNew = parametri.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(parametri);
			}
			else {
				parametri = (Parametri)session.merge(parametri);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ParametriImpl.class, parametri, false, true);

		if (isNew) {
			parametri.setNew(false);
		}

		parametri.resetOriginalValues();

		return parametri;
	}

	/**
	 * Returns the parametri with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametri
	 * @return the parametri
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParametriException {

		Parametri parametri = fetchByPrimaryKey(primaryKey);

		if (parametri == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParametriException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return parametri;
	}

	/**
	 * Returns the parametri with the primary key or throws a <code>NoSuchParametriException</code> if it could not be found.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri
	 * @throws NoSuchParametriException if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri findByPrimaryKey(String chiave)
		throws NoSuchParametriException {

		return findByPrimaryKey((Serializable)chiave);
	}

	/**
	 * Returns the parametri with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri, or <code>null</code> if a parametri with the primary key could not be found
	 */
	@Override
	public Parametri fetchByPrimaryKey(String chiave) {
		return fetchByPrimaryKey((Serializable)chiave);
	}

	/**
	 * Returns all the parametris.
	 *
	 * @return the parametris
	 */
	@Override
	public List<Parametri> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @return the range of parametris
	 */
	@Override
	public List<Parametri> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametris
	 */
	@Override
	public List<Parametri> findAll(
		int start, int end, OrderByComparator<Parametri> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametriModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parametris
	 */
	@Override
	public List<Parametri> findAll(
		int start, int end, OrderByComparator<Parametri> orderByComparator,
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

		List<Parametri> list = null;

		if (useFinderCache) {
			list = (List<Parametri>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PARAMETRI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETRI;

				sql = sql.concat(ParametriModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Parametri>)QueryUtil.list(
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
	 * Removes all the parametris from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Parametri parametri : findAll()) {
			remove(parametri);
		}
	}

	/**
	 * Returns the number of parametris.
	 *
	 * @return the number of parametris
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PARAMETRI);

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
		return "chiave";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PARAMETRI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ParametriModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the parametri persistence.
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

		ParametriUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ParametriUtil.setPersistence(null);

		entityCache.removeCache(ParametriImpl.class.getName());
	}

	@Override
	@Reference(
		target = parerPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = parerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = parerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PARAMETRI =
		"SELECT parametri FROM Parametri parametri";

	private static final String _SQL_COUNT_PARAMETRI =
		"SELECT COUNT(parametri) FROM Parametri parametri";

	private static final String _ORDER_BY_ENTITY_ALIAS = "parametri.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Parametri exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ParametriPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}