/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.impl;

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

import it.eng.allerter.exception.NoSuchAllertaParametroException;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaParametroTable;
import it.eng.allerter.model.impl.AllertaParametroImpl;
import it.eng.allerter.model.impl.AllertaParametroModelImpl;
import it.eng.allerter.service.persistence.AllertaParametroPersistence;
import it.eng.allerter.service.persistence.AllertaParametroUtil;
import it.eng.allerter.service.persistence.impl.constants.ALLERTERPersistenceConstants;

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
 * The persistence implementation for the allerta parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = AllertaParametroPersistence.class)
public class AllertaParametroPersistenceImpl
	extends BasePersistenceImpl<AllertaParametro>
	implements AllertaParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllertaParametroUtil</code> to access the allerta parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllertaParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AllertaParametroPersistenceImpl() {
		setModelClass(AllertaParametro.class);

		setModelImplClass(AllertaParametroImpl.class);
		setModelPKClass(String.class);

		setTable(AllertaParametroTable.INSTANCE);
	}

	/**
	 * Caches the allerta parametro in the entity cache if it is enabled.
	 *
	 * @param allertaParametro the allerta parametro
	 */
	@Override
	public void cacheResult(AllertaParametro allertaParametro) {
		entityCache.putResult(
			AllertaParametroImpl.class, allertaParametro.getPrimaryKey(),
			allertaParametro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the allerta parametros in the entity cache if it is enabled.
	 *
	 * @param allertaParametros the allerta parametros
	 */
	@Override
	public void cacheResult(List<AllertaParametro> allertaParametros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (allertaParametros.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AllertaParametro allertaParametro : allertaParametros) {
			if (entityCache.getResult(
					AllertaParametroImpl.class,
					allertaParametro.getPrimaryKey()) == null) {

				cacheResult(allertaParametro);
			}
		}
	}

	/**
	 * Clears the cache for all allerta parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllertaParametroImpl.class);

		finderCache.clearCache(AllertaParametroImpl.class);
	}

	/**
	 * Clears the cache for the allerta parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllertaParametro allertaParametro) {
		entityCache.removeResult(AllertaParametroImpl.class, allertaParametro);
	}

	@Override
	public void clearCache(List<AllertaParametro> allertaParametros) {
		for (AllertaParametro allertaParametro : allertaParametros) {
			entityCache.removeResult(
				AllertaParametroImpl.class, allertaParametro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AllertaParametroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AllertaParametroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	@Override
	public AllertaParametro create(String parametroId) {
		AllertaParametro allertaParametro = new AllertaParametroImpl();

		allertaParametro.setNew(true);
		allertaParametro.setPrimaryKey(parametroId);

		return allertaParametro;
	}

	/**
	 * Removes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro remove(String parametroId)
		throws NoSuchAllertaParametroException {

		return remove((Serializable)parametroId);
	}

	/**
	 * Removes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro remove(Serializable primaryKey)
		throws NoSuchAllertaParametroException {

		Session session = null;

		try {
			session = openSession();

			AllertaParametro allertaParametro = (AllertaParametro)session.get(
				AllertaParametroImpl.class, primaryKey);

			if (allertaParametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllertaParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allertaParametro);
		}
		catch (NoSuchAllertaParametroException noSuchEntityException) {
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
	protected AllertaParametro removeImpl(AllertaParametro allertaParametro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allertaParametro)) {
				allertaParametro = (AllertaParametro)session.get(
					AllertaParametroImpl.class,
					allertaParametro.getPrimaryKeyObj());
			}

			if (allertaParametro != null) {
				session.delete(allertaParametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (allertaParametro != null) {
			clearCache(allertaParametro);
		}

		return allertaParametro;
	}

	@Override
	public AllertaParametro updateImpl(AllertaParametro allertaParametro) {
		boolean isNew = allertaParametro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(allertaParametro);
			}
			else {
				allertaParametro = (AllertaParametro)session.merge(
					allertaParametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AllertaParametroImpl.class, allertaParametro, false, true);

		if (isNew) {
			allertaParametro.setNew(false);
		}

		allertaParametro.resetOriginalValues();

		return allertaParametro;
	}

	/**
	 * Returns the allerta parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllertaParametroException {

		AllertaParametro allertaParametro = fetchByPrimaryKey(primaryKey);

		if (allertaParametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllertaParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allertaParametro;
	}

	/**
	 * Returns the allerta parametro with the primary key or throws a <code>NoSuchAllertaParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro findByPrimaryKey(String parametroId)
		throws NoSuchAllertaParametroException {

		return findByPrimaryKey((Serializable)parametroId);
	}

	/**
	 * Returns the allerta parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro, or <code>null</code> if a allerta parametro with the primary key could not be found
	 */
	@Override
	public AllertaParametro fetchByPrimaryKey(String parametroId) {
		return fetchByPrimaryKey((Serializable)parametroId);
	}

	/**
	 * Returns all the allerta parametros.
	 *
	 * @return the allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll(
		int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allerta parametros
	 */
	@Override
	public List<AllertaParametro> findAll(
		int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator,
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

		List<AllertaParametro> list = null;

		if (useFinderCache) {
			list = (List<AllertaParametro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALLERTAPARAMETRO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALLERTAPARAMETRO;

				sql = sql.concat(AllertaParametroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AllertaParametro>)QueryUtil.list(
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
	 * Removes all the allerta parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AllertaParametro allertaParametro : findAll()) {
			remove(allertaParametro);
		}
	}

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALLERTAPARAMETRO);

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
		return "parametroId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALLERTAPARAMETRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AllertaParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allerta parametro persistence.
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

		AllertaParametroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AllertaParametroUtil.setPersistence(null);

		entityCache.removeCache(AllertaParametroImpl.class.getName());
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALLERTAPARAMETRO =
		"SELECT allertaParametro FROM AllertaParametro allertaParametro";

	private static final String _SQL_COUNT_ALLERTAPARAMETRO =
		"SELECT COUNT(allertaParametro) FROM AllertaParametro allertaParametro";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allertaParametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AllertaParametro exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaParametroPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}