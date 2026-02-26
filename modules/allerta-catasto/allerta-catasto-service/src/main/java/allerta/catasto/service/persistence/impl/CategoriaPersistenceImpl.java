/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.impl;

import allerta.catasto.exception.NoSuchCategoriaException;
import allerta.catasto.model.Categoria;
import allerta.catasto.model.CategoriaTable;
import allerta.catasto.model.impl.CategoriaImpl;
import allerta.catasto.model.impl.CategoriaModelImpl;
import allerta.catasto.service.persistence.CategoriaPersistence;
import allerta.catasto.service.persistence.CategoriaUtil;
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
 * The persistence implementation for the categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CategoriaPersistence.class)
public class CategoriaPersistenceImpl
	extends BasePersistenceImpl<Categoria> implements CategoriaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CategoriaUtil</code> to access the categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CategoriaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CategoriaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Categoria.class);

		setModelImplClass(CategoriaImpl.class);
		setModelPKClass(long.class);

		setTable(CategoriaTable.INSTANCE);
	}

	/**
	 * Caches the categoria in the entity cache if it is enabled.
	 *
	 * @param categoria the categoria
	 */
	@Override
	public void cacheResult(Categoria categoria) {
		entityCache.putResult(
			CategoriaImpl.class, categoria.getPrimaryKey(), categoria);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the categorias in the entity cache if it is enabled.
	 *
	 * @param categorias the categorias
	 */
	@Override
	public void cacheResult(List<Categoria> categorias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (categorias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Categoria categoria : categorias) {
			if (entityCache.getResult(
					CategoriaImpl.class, categoria.getPrimaryKey()) == null) {

				cacheResult(categoria);
			}
		}
	}

	/**
	 * Clears the cache for all categorias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoriaImpl.class);

		finderCache.clearCache(CategoriaImpl.class);
	}

	/**
	 * Clears the cache for the categoria.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Categoria categoria) {
		entityCache.removeResult(CategoriaImpl.class, categoria);
	}

	@Override
	public void clearCache(List<Categoria> categorias) {
		for (Categoria categoria : categorias) {
			entityCache.removeResult(CategoriaImpl.class, categoria);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CategoriaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CategoriaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new categoria with the primary key. Does not add the categoria to the database.
	 *
	 * @param id the primary key for the new categoria
	 * @return the new categoria
	 */
	@Override
	public Categoria create(long id) {
		Categoria categoria = new CategoriaImpl();

		categoria.setNew(true);
		categoria.setPrimaryKey(id);

		return categoria;
	}

	/**
	 * Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the categoria
	 * @return the categoria that was removed
	 * @throws NoSuchCategoriaException if a categoria with the primary key could not be found
	 */
	@Override
	public Categoria remove(long id) throws NoSuchCategoriaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the categoria
	 * @return the categoria that was removed
	 * @throws NoSuchCategoriaException if a categoria with the primary key could not be found
	 */
	@Override
	public Categoria remove(Serializable primaryKey)
		throws NoSuchCategoriaException {

		Session session = null;

		try {
			session = openSession();

			Categoria categoria = (Categoria)session.get(
				CategoriaImpl.class, primaryKey);

			if (categoria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoriaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(categoria);
		}
		catch (NoSuchCategoriaException noSuchEntityException) {
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
	protected Categoria removeImpl(Categoria categoria) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(categoria)) {
				categoria = (Categoria)session.get(
					CategoriaImpl.class, categoria.getPrimaryKeyObj());
			}

			if (categoria != null) {
				session.delete(categoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (categoria != null) {
			clearCache(categoria);
		}

		return categoria;
	}

	@Override
	public Categoria updateImpl(Categoria categoria) {
		boolean isNew = categoria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(categoria);
			}
			else {
				categoria = (Categoria)session.merge(categoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CategoriaImpl.class, categoria, false, true);

		if (isNew) {
			categoria.setNew(false);
		}

		categoria.resetOriginalValues();

		return categoria;
	}

	/**
	 * Returns the categoria with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the categoria
	 * @return the categoria
	 * @throws NoSuchCategoriaException if a categoria with the primary key could not be found
	 */
	@Override
	public Categoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoriaException {

		Categoria categoria = fetchByPrimaryKey(primaryKey);

		if (categoria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoriaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return categoria;
	}

	/**
	 * Returns the categoria with the primary key or throws a <code>NoSuchCategoriaException</code> if it could not be found.
	 *
	 * @param id the primary key of the categoria
	 * @return the categoria
	 * @throws NoSuchCategoriaException if a categoria with the primary key could not be found
	 */
	@Override
	public Categoria findByPrimaryKey(long id) throws NoSuchCategoriaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the categoria
	 * @return the categoria, or <code>null</code> if a categoria with the primary key could not be found
	 */
	@Override
	public Categoria fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the categorias.
	 *
	 * @return the categorias
	 */
	@Override
	public List<Categoria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @return the range of categorias
	 */
	@Override
	public List<Categoria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categorias
	 */
	@Override
	public List<Categoria> findAll(
		int start, int end, OrderByComparator<Categoria> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categorias
	 */
	@Override
	public List<Categoria> findAll(
		int start, int end, OrderByComparator<Categoria> orderByComparator,
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

		List<Categoria> list = null;

		if (useFinderCache) {
			list = (List<Categoria>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATEGORIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORIA;

				sql = sql.concat(CategoriaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Categoria>)QueryUtil.list(
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
	 * Removes all the categorias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Categoria categoria : findAll()) {
			remove(categoria);
		}
	}

	/**
	 * Returns the number of categorias.
	 *
	 * @return the number of categorias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATEGORIA);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CATEGORIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CategoriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the categoria persistence.
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

		CategoriaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CategoriaUtil.setPersistence(null);

		entityCache.removeCache(CategoriaImpl.class.getName());
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

	private static final String _SQL_SELECT_CATEGORIA =
		"SELECT categoria FROM Categoria categoria";

	private static final String _SQL_COUNT_CATEGORIA =
		"SELECT COUNT(categoria) FROM Categoria categoria";

	private static final String _ORDER_BY_ENTITY_ALIAS = "categoria.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Categoria exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CategoriaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}