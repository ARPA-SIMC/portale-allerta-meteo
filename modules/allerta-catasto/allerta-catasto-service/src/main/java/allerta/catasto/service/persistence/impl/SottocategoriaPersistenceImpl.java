/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.impl;

import allerta.catasto.exception.NoSuchSottocategoriaException;
import allerta.catasto.model.Sottocategoria;
import allerta.catasto.model.SottocategoriaTable;
import allerta.catasto.model.impl.SottocategoriaImpl;
import allerta.catasto.model.impl.SottocategoriaModelImpl;
import allerta.catasto.service.persistence.SottocategoriaPK;
import allerta.catasto.service.persistence.SottocategoriaPersistence;
import allerta.catasto.service.persistence.SottocategoriaUtil;
import allerta.catasto.service.persistence.impl.constants.CATASTOPersistenceConstants;

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
 * The persistence implementation for the sottocategoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SottocategoriaPersistence.class)
public class SottocategoriaPersistenceImpl
	extends BasePersistenceImpl<Sottocategoria>
	implements SottocategoriaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SottocategoriaUtil</code> to access the sottocategoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SottocategoriaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SottocategoriaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Sottocategoria.class);

		setModelImplClass(SottocategoriaImpl.class);
		setModelPKClass(SottocategoriaPK.class);

		setTable(SottocategoriaTable.INSTANCE);
	}

	/**
	 * Caches the sottocategoria in the entity cache if it is enabled.
	 *
	 * @param sottocategoria the sottocategoria
	 */
	@Override
	public void cacheResult(Sottocategoria sottocategoria) {
		entityCache.putResult(
			SottocategoriaImpl.class, sottocategoria.getPrimaryKey(),
			sottocategoria);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sottocategorias in the entity cache if it is enabled.
	 *
	 * @param sottocategorias the sottocategorias
	 */
	@Override
	public void cacheResult(List<Sottocategoria> sottocategorias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sottocategorias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Sottocategoria sottocategoria : sottocategorias) {
			if (entityCache.getResult(
					SottocategoriaImpl.class, sottocategoria.getPrimaryKey()) ==
						null) {

				cacheResult(sottocategoria);
			}
		}
	}

	/**
	 * Clears the cache for all sottocategorias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SottocategoriaImpl.class);

		finderCache.clearCache(SottocategoriaImpl.class);
	}

	/**
	 * Clears the cache for the sottocategoria.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sottocategoria sottocategoria) {
		entityCache.removeResult(SottocategoriaImpl.class, sottocategoria);
	}

	@Override
	public void clearCache(List<Sottocategoria> sottocategorias) {
		for (Sottocategoria sottocategoria : sottocategorias) {
			entityCache.removeResult(SottocategoriaImpl.class, sottocategoria);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SottocategoriaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SottocategoriaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sottocategoria with the primary key. Does not add the sottocategoria to the database.
	 *
	 * @param sottocategoriaPK the primary key for the new sottocategoria
	 * @return the new sottocategoria
	 */
	@Override
	public Sottocategoria create(SottocategoriaPK sottocategoriaPK) {
		Sottocategoria sottocategoria = new SottocategoriaImpl();

		sottocategoria.setNew(true);
		sottocategoria.setPrimaryKey(sottocategoriaPK);

		return sottocategoria;
	}

	/**
	 * Removes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria remove(SottocategoriaPK sottocategoriaPK)
		throws NoSuchSottocategoriaException {

		return remove((Serializable)sottocategoriaPK);
	}

	/**
	 * Removes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria remove(Serializable primaryKey)
		throws NoSuchSottocategoriaException {

		Session session = null;

		try {
			session = openSession();

			Sottocategoria sottocategoria = (Sottocategoria)session.get(
				SottocategoriaImpl.class, primaryKey);

			if (sottocategoria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSottocategoriaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sottocategoria);
		}
		catch (NoSuchSottocategoriaException noSuchEntityException) {
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
	protected Sottocategoria removeImpl(Sottocategoria sottocategoria) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sottocategoria)) {
				sottocategoria = (Sottocategoria)session.get(
					SottocategoriaImpl.class,
					sottocategoria.getPrimaryKeyObj());
			}

			if (sottocategoria != null) {
				session.delete(sottocategoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sottocategoria != null) {
			clearCache(sottocategoria);
		}

		return sottocategoria;
	}

	@Override
	public Sottocategoria updateImpl(Sottocategoria sottocategoria) {
		boolean isNew = sottocategoria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sottocategoria);
			}
			else {
				sottocategoria = (Sottocategoria)session.merge(sottocategoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SottocategoriaImpl.class, sottocategoria, false, true);

		if (isNew) {
			sottocategoria.setNew(false);
		}

		sottocategoria.resetOriginalValues();

		return sottocategoria;
	}

	/**
	 * Returns the sottocategoria with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSottocategoriaException {

		Sottocategoria sottocategoria = fetchByPrimaryKey(primaryKey);

		if (sottocategoria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSottocategoriaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sottocategoria;
	}

	/**
	 * Returns the sottocategoria with the primary key or throws a <code>NoSuchSottocategoriaException</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria findByPrimaryKey(SottocategoriaPK sottocategoriaPK)
		throws NoSuchSottocategoriaException {

		return findByPrimaryKey((Serializable)sottocategoriaPK);
	}

	/**
	 * Returns the sottocategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria, or <code>null</code> if a sottocategoria with the primary key could not be found
	 */
	@Override
	public Sottocategoria fetchByPrimaryKey(SottocategoriaPK sottocategoriaPK) {
		return fetchByPrimaryKey((Serializable)sottocategoriaPK);
	}

	/**
	 * Returns all the sottocategorias.
	 *
	 * @return the sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @return the range of sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll(
		int start, int end,
		OrderByComparator<Sottocategoria> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sottocategorias
	 */
	@Override
	public List<Sottocategoria> findAll(
		int start, int end, OrderByComparator<Sottocategoria> orderByComparator,
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

		List<Sottocategoria> list = null;

		if (useFinderCache) {
			list = (List<Sottocategoria>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SOTTOCATEGORIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SOTTOCATEGORIA;

				sql = sql.concat(SottocategoriaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Sottocategoria>)QueryUtil.list(
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
	 * Removes all the sottocategorias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Sottocategoria sottocategoria : findAll()) {
			remove(sottocategoria);
		}
	}

	/**
	 * Returns the number of sottocategorias.
	 *
	 * @return the number of sottocategorias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SOTTOCATEGORIA);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "sottocategoriaPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SOTTOCATEGORIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SottocategoriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sottocategoria persistence.
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

		SottocategoriaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SottocategoriaUtil.setPersistence(null);

		entityCache.removeCache(SottocategoriaImpl.class.getName());
	}

	@Override
	@Reference(
		target = CATASTOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CATASTOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CATASTOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SOTTOCATEGORIA =
		"SELECT sottocategoria FROM Sottocategoria sottocategoria";

	private static final String _SQL_COUNT_SOTTOCATEGORIA =
		"SELECT COUNT(sottocategoria) FROM Sottocategoria sottocategoria";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sottocategoria.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Sottocategoria exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SottocategoriaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"id", "idCategoria"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}