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

import it.eng.allerte.exception.NoSuchRubricaCategoriaException;
import it.eng.allerte.model.RubricaCategoria;
import it.eng.allerte.model.RubricaCategoriaTable;
import it.eng.allerte.model.impl.RubricaCategoriaImpl;
import it.eng.allerte.model.impl.RubricaCategoriaModelImpl;
import it.eng.allerte.service.persistence.RubricaCategoriaPersistence;
import it.eng.allerte.service.persistence.RubricaCategoriaUtil;
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
 * The persistence implementation for the rubrica categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaCategoriaPersistence.class)
public class RubricaCategoriaPersistenceImpl
	extends BasePersistenceImpl<RubricaCategoria>
	implements RubricaCategoriaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaCategoriaUtil</code> to access the rubrica categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaCategoriaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RubricaCategoriaPersistenceImpl() {
		setModelClass(RubricaCategoria.class);

		setModelImplClass(RubricaCategoriaImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaCategoriaTable.INSTANCE);
	}

	/**
	 * Caches the rubrica categoria in the entity cache if it is enabled.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 */
	@Override
	public void cacheResult(RubricaCategoria rubricaCategoria) {
		dummyEntityCache.putResult(
			RubricaCategoriaImpl.class, rubricaCategoria.getPrimaryKey(),
			rubricaCategoria);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica categorias in the entity cache if it is enabled.
	 *
	 * @param rubricaCategorias the rubrica categorias
	 */
	@Override
	public void cacheResult(List<RubricaCategoria> rubricaCategorias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaCategorias.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaCategoria rubricaCategoria : rubricaCategorias) {
			if (dummyEntityCache.getResult(
					RubricaCategoriaImpl.class,
					rubricaCategoria.getPrimaryKey()) == null) {

				cacheResult(rubricaCategoria);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica categorias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaCategoriaImpl.class);

		dummyFinderCache.clearCache(RubricaCategoriaImpl.class);
	}

	/**
	 * Clears the cache for the rubrica categoria.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaCategoria rubricaCategoria) {
		dummyEntityCache.removeResult(
			RubricaCategoriaImpl.class, rubricaCategoria);
	}

	@Override
	public void clearCache(List<RubricaCategoria> rubricaCategorias) {
		for (RubricaCategoria rubricaCategoria : rubricaCategorias) {
			dummyEntityCache.removeResult(
				RubricaCategoriaImpl.class, rubricaCategoria);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaCategoriaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaCategoriaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica categoria with the primary key. Does not add the rubrica categoria to the database.
	 *
	 * @param ID_CATEGORIA the primary key for the new rubrica categoria
	 * @return the new rubrica categoria
	 */
	@Override
	public RubricaCategoria create(long ID_CATEGORIA) {
		RubricaCategoria rubricaCategoria = new RubricaCategoriaImpl();

		rubricaCategoria.setNew(true);
		rubricaCategoria.setPrimaryKey(ID_CATEGORIA);

		return rubricaCategoria;
	}

	/**
	 * Removes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria remove(long ID_CATEGORIA)
		throws NoSuchRubricaCategoriaException {

		return remove((Serializable)ID_CATEGORIA);
	}

	/**
	 * Removes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria remove(Serializable primaryKey)
		throws NoSuchRubricaCategoriaException {

		Session session = null;

		try {
			session = openSession();

			RubricaCategoria rubricaCategoria = (RubricaCategoria)session.get(
				RubricaCategoriaImpl.class, primaryKey);

			if (rubricaCategoria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaCategoriaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaCategoria);
		}
		catch (NoSuchRubricaCategoriaException noSuchEntityException) {
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
	protected RubricaCategoria removeImpl(RubricaCategoria rubricaCategoria) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaCategoria)) {
				rubricaCategoria = (RubricaCategoria)session.get(
					RubricaCategoriaImpl.class,
					rubricaCategoria.getPrimaryKeyObj());
			}

			if (rubricaCategoria != null) {
				session.delete(rubricaCategoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaCategoria != null) {
			clearCache(rubricaCategoria);
		}

		return rubricaCategoria;
	}

	@Override
	public RubricaCategoria updateImpl(RubricaCategoria rubricaCategoria) {
		boolean isNew = rubricaCategoria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaCategoria);
			}
			else {
				rubricaCategoria = (RubricaCategoria)session.merge(
					rubricaCategoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaCategoriaImpl.class, rubricaCategoria, false, true);

		if (isNew) {
			rubricaCategoria.setNew(false);
		}

		rubricaCategoria.resetOriginalValues();

		return rubricaCategoria;
	}

	/**
	 * Returns the rubrica categoria with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaCategoriaException {

		RubricaCategoria rubricaCategoria = fetchByPrimaryKey(primaryKey);

		if (rubricaCategoria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaCategoriaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaCategoria;
	}

	/**
	 * Returns the rubrica categoria with the primary key or throws a <code>NoSuchRubricaCategoriaException</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria findByPrimaryKey(long ID_CATEGORIA)
		throws NoSuchRubricaCategoriaException {

		return findByPrimaryKey((Serializable)ID_CATEGORIA);
	}

	/**
	 * Returns the rubrica categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria, or <code>null</code> if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public RubricaCategoria fetchByPrimaryKey(long ID_CATEGORIA) {
		return fetchByPrimaryKey((Serializable)ID_CATEGORIA);
	}

	/**
	 * Returns all the rubrica categorias.
	 *
	 * @return the rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @return the range of rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll(
		int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica categorias
	 */
	@Override
	public List<RubricaCategoria> findAll(
		int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator,
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

		List<RubricaCategoria> list = null;

		if (useFinderCache) {
			list = (List<RubricaCategoria>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICACATEGORIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICACATEGORIA;

				sql = sql.concat(RubricaCategoriaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaCategoria>)QueryUtil.list(
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
	 * Removes all the rubrica categorias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaCategoria rubricaCategoria : findAll()) {
			remove(rubricaCategoria);
		}
	}

	/**
	 * Returns the number of rubrica categorias.
	 *
	 * @return the number of rubrica categorias
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICACATEGORIA);

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
		return "ID_CATEGORIA";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICACATEGORIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaCategoriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica categoria persistence.
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

		RubricaCategoriaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaCategoriaUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaCategoriaImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICACATEGORIA =
		"SELECT rubricaCategoria FROM RubricaCategoria rubricaCategoria";

	private static final String _SQL_COUNT_RUBRICACATEGORIA =
		"SELECT COUNT(rubricaCategoria) FROM RubricaCategoria rubricaCategoria";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaCategoria.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaCategoria exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaCategoriaPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}