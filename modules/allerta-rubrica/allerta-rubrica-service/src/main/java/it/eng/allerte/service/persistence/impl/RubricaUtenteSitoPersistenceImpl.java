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

import it.eng.allerte.exception.NoSuchRubricaUtenteSitoException;
import it.eng.allerte.model.RubricaUtenteSito;
import it.eng.allerte.model.RubricaUtenteSitoTable;
import it.eng.allerte.model.impl.RubricaUtenteSitoImpl;
import it.eng.allerte.model.impl.RubricaUtenteSitoModelImpl;
import it.eng.allerte.service.persistence.RubricaUtenteSitoPersistence;
import it.eng.allerte.service.persistence.RubricaUtenteSitoUtil;
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
 * The persistence implementation for the rubrica utente sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaUtenteSitoPersistence.class)
public class RubricaUtenteSitoPersistenceImpl
	extends BasePersistenceImpl<RubricaUtenteSito>
	implements RubricaUtenteSitoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaUtenteSitoUtil</code> to access the rubrica utente sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaUtenteSitoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaUtenteSitoPersistenceImpl() {
		setModelClass(RubricaUtenteSito.class);

		setModelImplClass(RubricaUtenteSitoImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaUtenteSitoTable.INSTANCE);
	}

	/**
	 * Caches the rubrica utente sito in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 */
	@Override
	public void cacheResult(RubricaUtenteSito rubricaUtenteSito) {
		dummyEntityCache.putResult(
			RubricaUtenteSitoImpl.class, rubricaUtenteSito.getPrimaryKey(),
			rubricaUtenteSito);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica utente sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSitos the rubrica utente sitos
	 */
	@Override
	public void cacheResult(List<RubricaUtenteSito> rubricaUtenteSitos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaUtenteSitos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaUtenteSito rubricaUtenteSito : rubricaUtenteSitos) {
			if (dummyEntityCache.getResult(
					RubricaUtenteSitoImpl.class,
					rubricaUtenteSito.getPrimaryKey()) == null) {

				cacheResult(rubricaUtenteSito);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica utente sitos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaUtenteSitoImpl.class);

		dummyFinderCache.clearCache(RubricaUtenteSitoImpl.class);
	}

	/**
	 * Clears the cache for the rubrica utente sito.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaUtenteSito rubricaUtenteSito) {
		dummyEntityCache.removeResult(
			RubricaUtenteSitoImpl.class, rubricaUtenteSito);
	}

	@Override
	public void clearCache(List<RubricaUtenteSito> rubricaUtenteSitos) {
		for (RubricaUtenteSito rubricaUtenteSito : rubricaUtenteSitos) {
			dummyEntityCache.removeResult(
				RubricaUtenteSitoImpl.class, rubricaUtenteSito);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaUtenteSitoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaUtenteSitoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica utente sito with the primary key. Does not add the rubrica utente sito to the database.
	 *
	 * @param ID_UTENTE the primary key for the new rubrica utente sito
	 * @return the new rubrica utente sito
	 */
	@Override
	public RubricaUtenteSito create(long ID_UTENTE) {
		RubricaUtenteSito rubricaUtenteSito = new RubricaUtenteSitoImpl();

		rubricaUtenteSito.setNew(true);
		rubricaUtenteSito.setPrimaryKey(ID_UTENTE);

		return rubricaUtenteSito;
	}

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito remove(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException {

		return remove((Serializable)ID_UTENTE);
	}

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito remove(Serializable primaryKey)
		throws NoSuchRubricaUtenteSitoException {

		Session session = null;

		try {
			session = openSession();

			RubricaUtenteSito rubricaUtenteSito =
				(RubricaUtenteSito)session.get(
					RubricaUtenteSitoImpl.class, primaryKey);

			if (rubricaUtenteSito == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaUtenteSitoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaUtenteSito);
		}
		catch (NoSuchRubricaUtenteSitoException noSuchEntityException) {
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
	protected RubricaUtenteSito removeImpl(
		RubricaUtenteSito rubricaUtenteSito) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaUtenteSito)) {
				rubricaUtenteSito = (RubricaUtenteSito)session.get(
					RubricaUtenteSitoImpl.class,
					rubricaUtenteSito.getPrimaryKeyObj());
			}

			if (rubricaUtenteSito != null) {
				session.delete(rubricaUtenteSito);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaUtenteSito != null) {
			clearCache(rubricaUtenteSito);
		}

		return rubricaUtenteSito;
	}

	@Override
	public RubricaUtenteSito updateImpl(RubricaUtenteSito rubricaUtenteSito) {
		boolean isNew = rubricaUtenteSito.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaUtenteSito);
			}
			else {
				rubricaUtenteSito = (RubricaUtenteSito)session.merge(
					rubricaUtenteSito);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaUtenteSitoImpl.class, rubricaUtenteSito, false, true);

		if (isNew) {
			rubricaUtenteSito.setNew(false);
		}

		rubricaUtenteSito.resetOriginalValues();

		return rubricaUtenteSito;
	}

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaUtenteSitoException {

		RubricaUtenteSito rubricaUtenteSito = fetchByPrimaryKey(primaryKey);

		if (rubricaUtenteSito == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaUtenteSitoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaUtenteSito;
	}

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>NoSuchRubricaUtenteSitoException</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito findByPrimaryKey(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException {

		return findByPrimaryKey((Serializable)ID_UTENTE);
	}

	/**
	 * Returns the rubrica utente sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito, or <code>null</code> if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public RubricaUtenteSito fetchByPrimaryKey(long ID_UTENTE) {
		return fetchByPrimaryKey((Serializable)ID_UTENTE);
	}

	/**
	 * Returns all the rubrica utente sitos.
	 *
	 * @return the rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @return the range of rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll(
		int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica utente sitos
	 */
	@Override
	public List<RubricaUtenteSito> findAll(
		int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator,
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

		List<RubricaUtenteSito> list = null;

		if (useFinderCache) {
			list = (List<RubricaUtenteSito>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICAUTENTESITO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAUTENTESITO;

				sql = sql.concat(RubricaUtenteSitoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaUtenteSito>)QueryUtil.list(
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
	 * Removes all the rubrica utente sitos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaUtenteSito rubricaUtenteSito : findAll()) {
			remove(rubricaUtenteSito);
		}
	}

	/**
	 * Returns the number of rubrica utente sitos.
	 *
	 * @return the number of rubrica utente sitos
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICAUTENTESITO);

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
		return "ID_UTENTE";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICAUTENTESITO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaUtenteSitoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica utente sito persistence.
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

		RubricaUtenteSitoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaUtenteSitoUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaUtenteSitoImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICAUTENTESITO =
		"SELECT rubricaUtenteSito FROM RubricaUtenteSito rubricaUtenteSito";

	private static final String _SQL_COUNT_RUBRICAUTENTESITO =
		"SELECT COUNT(rubricaUtenteSito) FROM RubricaUtenteSito rubricaUtenteSito";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaUtenteSito.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaUtenteSito exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaUtenteSitoPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}