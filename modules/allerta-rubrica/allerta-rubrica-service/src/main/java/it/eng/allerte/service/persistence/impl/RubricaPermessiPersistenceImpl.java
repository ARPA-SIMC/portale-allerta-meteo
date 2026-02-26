/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

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

import it.eng.allerte.exception.NoSuchRubricaPermessiException;
import it.eng.allerte.model.RubricaPermessi;
import it.eng.allerte.model.RubricaPermessiTable;
import it.eng.allerte.model.impl.RubricaPermessiImpl;
import it.eng.allerte.model.impl.RubricaPermessiModelImpl;
import it.eng.allerte.service.persistence.RubricaPermessiPersistence;
import it.eng.allerte.service.persistence.RubricaPermessiUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

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
 * The persistence implementation for the rubrica permessi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaPermessiPersistence.class)
public class RubricaPermessiPersistenceImpl
	extends BasePersistenceImpl<RubricaPermessi>
	implements RubricaPermessiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaPermessiUtil</code> to access the rubrica permessi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaPermessiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaPermessiPersistenceImpl() {
		setModelClass(RubricaPermessi.class);

		setModelImplClass(RubricaPermessiImpl.class);
		setModelPKClass(String.class);

		setTable(RubricaPermessiTable.INSTANCE);
	}

	/**
	 * Caches the rubrica permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessi the rubrica permessi
	 */
	@Override
	public void cacheResult(RubricaPermessi rubricaPermessi) {
		dummyEntityCache.putResult(
			RubricaPermessiImpl.class, rubricaPermessi.getPrimaryKey(),
			rubricaPermessi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessis the rubrica permessis
	 */
	@Override
	public void cacheResult(List<RubricaPermessi> rubricaPermessis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaPermessis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaPermessi rubricaPermessi : rubricaPermessis) {
			if (dummyEntityCache.getResult(
					RubricaPermessiImpl.class,
					rubricaPermessi.getPrimaryKey()) == null) {

				cacheResult(rubricaPermessi);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica permessis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaPermessiImpl.class);

		dummyFinderCache.clearCache(RubricaPermessiImpl.class);
	}

	/**
	 * Clears the cache for the rubrica permessi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaPermessi rubricaPermessi) {
		dummyEntityCache.removeResult(
			RubricaPermessiImpl.class, rubricaPermessi);
	}

	@Override
	public void clearCache(List<RubricaPermessi> rubricaPermessis) {
		for (RubricaPermessi rubricaPermessi : rubricaPermessis) {
			dummyEntityCache.removeResult(
				RubricaPermessiImpl.class, rubricaPermessi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaPermessiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaPermessiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica permessi with the primary key. Does not add the rubrica permessi to the database.
	 *
	 * @param ID_PERMESSO the primary key for the new rubrica permessi
	 * @return the new rubrica permessi
	 */
	@Override
	public RubricaPermessi create(String ID_PERMESSO) {
		RubricaPermessi rubricaPermessi = new RubricaPermessiImpl();

		rubricaPermessi.setNew(true);
		rubricaPermessi.setPrimaryKey(ID_PERMESSO);

		return rubricaPermessi;
	}

	/**
	 * Removes the rubrica permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi that was removed
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi remove(String ID_PERMESSO)
		throws NoSuchRubricaPermessiException {

		return remove((Serializable)ID_PERMESSO);
	}

	/**
	 * Removes the rubrica permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica permessi
	 * @return the rubrica permessi that was removed
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi remove(Serializable primaryKey)
		throws NoSuchRubricaPermessiException {

		Session session = null;

		try {
			session = openSession();

			RubricaPermessi rubricaPermessi = (RubricaPermessi)session.get(
				RubricaPermessiImpl.class, primaryKey);

			if (rubricaPermessi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaPermessiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaPermessi);
		}
		catch (NoSuchRubricaPermessiException noSuchEntityException) {
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
	protected RubricaPermessi removeImpl(RubricaPermessi rubricaPermessi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaPermessi)) {
				rubricaPermessi = (RubricaPermessi)session.get(
					RubricaPermessiImpl.class,
					rubricaPermessi.getPrimaryKeyObj());
			}

			if (rubricaPermessi != null) {
				session.delete(rubricaPermessi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaPermessi != null) {
			clearCache(rubricaPermessi);
		}

		return rubricaPermessi;
	}

	@Override
	public RubricaPermessi updateImpl(RubricaPermessi rubricaPermessi) {
		boolean isNew = rubricaPermessi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaPermessi);
			}
			else {
				rubricaPermessi = (RubricaPermessi)session.merge(
					rubricaPermessi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaPermessiImpl.class, rubricaPermessi, false, true);

		if (isNew) {
			rubricaPermessi.setNew(false);
		}

		rubricaPermessi.resetOriginalValues();

		return rubricaPermessi;
	}

	/**
	 * Returns the rubrica permessi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica permessi
	 * @return the rubrica permessi
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaPermessiException {

		RubricaPermessi rubricaPermessi = fetchByPrimaryKey(primaryKey);

		if (rubricaPermessi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaPermessiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaPermessi;
	}

	/**
	 * Returns the rubrica permessi with the primary key or throws a <code>NoSuchRubricaPermessiException</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi findByPrimaryKey(String ID_PERMESSO)
		throws NoSuchRubricaPermessiException {

		return findByPrimaryKey((Serializable)ID_PERMESSO);
	}

	/**
	 * Returns the rubrica permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi, or <code>null</code> if a rubrica permessi with the primary key could not be found
	 */
	@Override
	public RubricaPermessi fetchByPrimaryKey(String ID_PERMESSO) {
		return fetchByPrimaryKey((Serializable)ID_PERMESSO);
	}

	/**
	 * Returns all the rubrica permessis.
	 *
	 * @return the rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @return the range of rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica permessis
	 */
	@Override
	public List<RubricaPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator,
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

		List<RubricaPermessi> list = null;

		if (useFinderCache) {
			list = (List<RubricaPermessi>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICAPERMESSI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAPERMESSI;

				sql = sql.concat(RubricaPermessiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaPermessi>)QueryUtil.list(
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
	 * Removes all the rubrica permessis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaPermessi rubricaPermessi : findAll()) {
			remove(rubricaPermessi);
		}
	}

	/**
	 * Returns the number of rubrica permessis.
	 *
	 * @return the number of rubrica permessis
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICAPERMESSI);

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
		return "ID_PERMESSO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICAPERMESSI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaPermessiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica permessi persistence.
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

		RubricaPermessiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaPermessiUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaPermessiImpl.class.getName());
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_RUBRICAPERMESSI =
		"SELECT rubricaPermessi FROM RubricaPermessi rubricaPermessi";

	private static final String _SQL_COUNT_RUBRICAPERMESSI =
		"SELECT COUNT(rubricaPermessi) FROM RubricaPermessi rubricaPermessi";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaPermessi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaPermessi exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaPermessiPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}