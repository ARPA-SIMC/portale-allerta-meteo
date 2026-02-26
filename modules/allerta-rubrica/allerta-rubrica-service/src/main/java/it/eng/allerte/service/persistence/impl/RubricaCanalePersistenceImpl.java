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

import it.eng.allerte.exception.NoSuchRubricaCanaleException;
import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.model.RubricaCanaleTable;
import it.eng.allerte.model.impl.RubricaCanaleImpl;
import it.eng.allerte.model.impl.RubricaCanaleModelImpl;
import it.eng.allerte.service.persistence.RubricaCanalePersistence;
import it.eng.allerte.service.persistence.RubricaCanaleUtil;
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
 * The persistence implementation for the rubrica canale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaCanalePersistence.class)
public class RubricaCanalePersistenceImpl
	extends BasePersistenceImpl<RubricaCanale>
	implements RubricaCanalePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaCanaleUtil</code> to access the rubrica canale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaCanaleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaCanalePersistenceImpl() {
		setModelClass(RubricaCanale.class);

		setModelImplClass(RubricaCanaleImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaCanaleTable.INSTANCE);
	}

	/**
	 * Caches the rubrica canale in the entity cache if it is enabled.
	 *
	 * @param rubricaCanale the rubrica canale
	 */
	@Override
	public void cacheResult(RubricaCanale rubricaCanale) {
		dummyEntityCache.putResult(
			RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey(),
			rubricaCanale);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica canales in the entity cache if it is enabled.
	 *
	 * @param rubricaCanales the rubrica canales
	 */
	@Override
	public void cacheResult(List<RubricaCanale> rubricaCanales) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaCanales.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaCanale rubricaCanale : rubricaCanales) {
			if (dummyEntityCache.getResult(
					RubricaCanaleImpl.class, rubricaCanale.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaCanale);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica canales.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaCanaleImpl.class);

		dummyFinderCache.clearCache(RubricaCanaleImpl.class);
	}

	/**
	 * Clears the cache for the rubrica canale.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaCanale rubricaCanale) {
		dummyEntityCache.removeResult(RubricaCanaleImpl.class, rubricaCanale);
	}

	@Override
	public void clearCache(List<RubricaCanale> rubricaCanales) {
		for (RubricaCanale rubricaCanale : rubricaCanales) {
			dummyEntityCache.removeResult(
				RubricaCanaleImpl.class, rubricaCanale);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaCanaleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(RubricaCanaleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica canale with the primary key. Does not add the rubrica canale to the database.
	 *
	 * @param ID_CANALE the primary key for the new rubrica canale
	 * @return the new rubrica canale
	 */
	@Override
	public RubricaCanale create(long ID_CANALE) {
		RubricaCanale rubricaCanale = new RubricaCanaleImpl();

		rubricaCanale.setNew(true);
		rubricaCanale.setPrimaryKey(ID_CANALE);

		return rubricaCanale;
	}

	/**
	 * Removes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale remove(long ID_CANALE)
		throws NoSuchRubricaCanaleException {

		return remove((Serializable)ID_CANALE);
	}

	/**
	 * Removes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale remove(Serializable primaryKey)
		throws NoSuchRubricaCanaleException {

		Session session = null;

		try {
			session = openSession();

			RubricaCanale rubricaCanale = (RubricaCanale)session.get(
				RubricaCanaleImpl.class, primaryKey);

			if (rubricaCanale == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaCanaleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaCanale);
		}
		catch (NoSuchRubricaCanaleException noSuchEntityException) {
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
	protected RubricaCanale removeImpl(RubricaCanale rubricaCanale) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaCanale)) {
				rubricaCanale = (RubricaCanale)session.get(
					RubricaCanaleImpl.class, rubricaCanale.getPrimaryKeyObj());
			}

			if (rubricaCanale != null) {
				session.delete(rubricaCanale);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaCanale != null) {
			clearCache(rubricaCanale);
		}

		return rubricaCanale;
	}

	@Override
	public RubricaCanale updateImpl(RubricaCanale rubricaCanale) {
		boolean isNew = rubricaCanale.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaCanale);
			}
			else {
				rubricaCanale = (RubricaCanale)session.merge(rubricaCanale);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaCanaleImpl.class, rubricaCanale, false, true);

		if (isNew) {
			rubricaCanale.setNew(false);
		}

		rubricaCanale.resetOriginalValues();

		return rubricaCanale;
	}

	/**
	 * Returns the rubrica canale with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaCanaleException {

		RubricaCanale rubricaCanale = fetchByPrimaryKey(primaryKey);

		if (rubricaCanale == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaCanaleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaCanale;
	}

	/**
	 * Returns the rubrica canale with the primary key or throws a <code>NoSuchRubricaCanaleException</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale findByPrimaryKey(long ID_CANALE)
		throws NoSuchRubricaCanaleException {

		return findByPrimaryKey((Serializable)ID_CANALE);
	}

	/**
	 * Returns the rubrica canale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale, or <code>null</code> if a rubrica canale with the primary key could not be found
	 */
	@Override
	public RubricaCanale fetchByPrimaryKey(long ID_CANALE) {
		return fetchByPrimaryKey((Serializable)ID_CANALE);
	}

	/**
	 * Returns all the rubrica canales.
	 *
	 * @return the rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @return the range of rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll(
		int start, int end,
		OrderByComparator<RubricaCanale> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica canales
	 */
	@Override
	public List<RubricaCanale> findAll(
		int start, int end, OrderByComparator<RubricaCanale> orderByComparator,
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

		List<RubricaCanale> list = null;

		if (useFinderCache) {
			list = (List<RubricaCanale>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICACANALE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICACANALE;

				sql = sql.concat(RubricaCanaleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaCanale>)QueryUtil.list(
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
	 * Removes all the rubrica canales from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaCanale rubricaCanale : findAll()) {
			remove(rubricaCanale);
		}
	}

	/**
	 * Returns the number of rubrica canales.
	 *
	 * @return the number of rubrica canales
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICACANALE);

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
		return "ID_CANALE";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICACANALE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaCanaleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica canale persistence.
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

		RubricaCanaleUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaCanaleUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaCanaleImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICACANALE =
		"SELECT rubricaCanale FROM RubricaCanale rubricaCanale";

	private static final String _SQL_COUNT_RUBRICACANALE =
		"SELECT COUNT(rubricaCanale) FROM RubricaCanale rubricaCanale";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaCanale.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaCanale exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaCanalePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}