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

import it.eng.allerte.exception.NoSuchRubricaRuoloRubricaException;
import it.eng.allerte.model.RubricaRuoloRubrica;
import it.eng.allerte.model.RubricaRuoloRubricaTable;
import it.eng.allerte.model.impl.RubricaRuoloRubricaImpl;
import it.eng.allerte.model.impl.RubricaRuoloRubricaModelImpl;
import it.eng.allerte.service.persistence.RubricaRuoloRubricaPersistence;
import it.eng.allerte.service.persistence.RubricaRuoloRubricaUtil;
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
 * The persistence implementation for the rubrica ruolo rubrica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaRuoloRubricaPersistence.class)
public class RubricaRuoloRubricaPersistenceImpl
	extends BasePersistenceImpl<RubricaRuoloRubrica>
	implements RubricaRuoloRubricaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaRuoloRubricaUtil</code> to access the rubrica ruolo rubrica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaRuoloRubricaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaRuoloRubricaPersistenceImpl() {
		setModelClass(RubricaRuoloRubrica.class);

		setModelImplClass(RubricaRuoloRubricaImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaRuoloRubricaTable.INSTANCE);
	}

	/**
	 * Caches the rubrica ruolo rubrica in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 */
	@Override
	public void cacheResult(RubricaRuoloRubrica rubricaRuoloRubrica) {
		dummyEntityCache.putResult(
			RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica.getPrimaryKey(),
			rubricaRuoloRubrica);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica ruolo rubricas in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubricas the rubrica ruolo rubricas
	 */
	@Override
	public void cacheResult(List<RubricaRuoloRubrica> rubricaRuoloRubricas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaRuoloRubricas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaRuoloRubrica rubricaRuoloRubrica : rubricaRuoloRubricas) {
			if (dummyEntityCache.getResult(
					RubricaRuoloRubricaImpl.class,
					rubricaRuoloRubrica.getPrimaryKey()) == null) {

				cacheResult(rubricaRuoloRubrica);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica ruolo rubricas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaRuoloRubricaImpl.class);

		dummyFinderCache.clearCache(RubricaRuoloRubricaImpl.class);
	}

	/**
	 * Clears the cache for the rubrica ruolo rubrica.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaRuoloRubrica rubricaRuoloRubrica) {
		dummyEntityCache.removeResult(
			RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica);
	}

	@Override
	public void clearCache(List<RubricaRuoloRubrica> rubricaRuoloRubricas) {
		for (RubricaRuoloRubrica rubricaRuoloRubrica : rubricaRuoloRubricas) {
			dummyEntityCache.removeResult(
				RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaRuoloRubricaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaRuoloRubricaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica ruolo rubrica with the primary key. Does not add the rubrica ruolo rubrica to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo rubrica
	 * @return the new rubrica ruolo rubrica
	 */
	@Override
	public RubricaRuoloRubrica create(long ID_RUOLO) {
		RubricaRuoloRubrica rubricaRuoloRubrica = new RubricaRuoloRubricaImpl();

		rubricaRuoloRubrica.setNew(true);
		rubricaRuoloRubrica.setPrimaryKey(ID_RUOLO);

		return rubricaRuoloRubrica;
	}

	/**
	 * Removes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica remove(long ID_RUOLO)
		throws NoSuchRubricaRuoloRubricaException {

		return remove((Serializable)ID_RUOLO);
	}

	/**
	 * Removes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica remove(Serializable primaryKey)
		throws NoSuchRubricaRuoloRubricaException {

		Session session = null;

		try {
			session = openSession();

			RubricaRuoloRubrica rubricaRuoloRubrica =
				(RubricaRuoloRubrica)session.get(
					RubricaRuoloRubricaImpl.class, primaryKey);

			if (rubricaRuoloRubrica == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaRuoloRubricaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaRuoloRubrica);
		}
		catch (NoSuchRubricaRuoloRubricaException noSuchEntityException) {
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
	protected RubricaRuoloRubrica removeImpl(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaRuoloRubrica)) {
				rubricaRuoloRubrica = (RubricaRuoloRubrica)session.get(
					RubricaRuoloRubricaImpl.class,
					rubricaRuoloRubrica.getPrimaryKeyObj());
			}

			if (rubricaRuoloRubrica != null) {
				session.delete(rubricaRuoloRubrica);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaRuoloRubrica != null) {
			clearCache(rubricaRuoloRubrica);
		}

		return rubricaRuoloRubrica;
	}

	@Override
	public RubricaRuoloRubrica updateImpl(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		boolean isNew = rubricaRuoloRubrica.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaRuoloRubrica);
			}
			else {
				rubricaRuoloRubrica = (RubricaRuoloRubrica)session.merge(
					rubricaRuoloRubrica);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaRuoloRubricaImpl.class, rubricaRuoloRubrica, false, true);

		if (isNew) {
			rubricaRuoloRubrica.setNew(false);
		}

		rubricaRuoloRubrica.resetOriginalValues();

		return rubricaRuoloRubrica;
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaRuoloRubricaException {

		RubricaRuoloRubrica rubricaRuoloRubrica = fetchByPrimaryKey(primaryKey);

		if (rubricaRuoloRubrica == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaRuoloRubricaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaRuoloRubrica;
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or throws a <code>NoSuchRubricaRuoloRubricaException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica findByPrimaryKey(long ID_RUOLO)
		throws NoSuchRubricaRuoloRubricaException {

		return findByPrimaryKey((Serializable)ID_RUOLO);
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica, or <code>null</code> if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public RubricaRuoloRubrica fetchByPrimaryKey(long ID_RUOLO) {
		return fetchByPrimaryKey((Serializable)ID_RUOLO);
	}

	/**
	 * Returns all the rubrica ruolo rubricas.
	 *
	 * @return the rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @return the range of rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	@Override
	public List<RubricaRuoloRubrica> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator,
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

		List<RubricaRuoloRubrica> list = null;

		if (useFinderCache) {
			list = (List<RubricaRuoloRubrica>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICARUOLORUBRICA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICARUOLORUBRICA;

				sql = sql.concat(RubricaRuoloRubricaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaRuoloRubrica>)QueryUtil.list(
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
	 * Removes all the rubrica ruolo rubricas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaRuoloRubrica rubricaRuoloRubrica : findAll()) {
			remove(rubricaRuoloRubrica);
		}
	}

	/**
	 * Returns the number of rubrica ruolo rubricas.
	 *
	 * @return the number of rubrica ruolo rubricas
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
					_SQL_COUNT_RUBRICARUOLORUBRICA);

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
		return "ID_RUOLO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICARUOLORUBRICA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaRuoloRubricaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica ruolo rubrica persistence.
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

		RubricaRuoloRubricaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaRuoloRubricaUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaRuoloRubricaImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICARUOLORUBRICA =
		"SELECT rubricaRuoloRubrica FROM RubricaRuoloRubrica rubricaRuoloRubrica";

	private static final String _SQL_COUNT_RUBRICARUOLORUBRICA =
		"SELECT COUNT(rubricaRuoloRubrica) FROM RubricaRuoloRubrica rubricaRuoloRubrica";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaRuoloRubrica.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaRuoloRubrica exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaRuoloRubricaPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}