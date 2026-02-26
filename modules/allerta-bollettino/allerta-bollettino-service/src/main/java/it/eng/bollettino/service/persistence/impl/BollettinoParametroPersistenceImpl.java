/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.impl;

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

import it.eng.bollettino.exception.NoSuchBollettinoParametroException;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.BollettinoParametroTable;
import it.eng.bollettino.model.impl.BollettinoParametroImpl;
import it.eng.bollettino.model.impl.BollettinoParametroModelImpl;
import it.eng.bollettino.service.persistence.BollettinoParametroPersistence;
import it.eng.bollettino.service.persistence.BollettinoParametroUtil;
import it.eng.bollettino.service.persistence.impl.constants.BOLLETTINOPersistenceConstants;

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
 * The persistence implementation for the bollettino parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = BollettinoParametroPersistence.class)
public class BollettinoParametroPersistenceImpl
	extends BasePersistenceImpl<BollettinoParametro>
	implements BollettinoParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoParametroUtil</code> to access the bollettino parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BollettinoParametroPersistenceImpl() {
		setModelClass(BollettinoParametro.class);

		setModelImplClass(BollettinoParametroImpl.class);
		setModelPKClass(String.class);

		setTable(BollettinoParametroTable.INSTANCE);
	}

	/**
	 * Caches the bollettino parametro in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametro the bollettino parametro
	 */
	@Override
	public void cacheResult(BollettinoParametro bollettinoParametro) {
		dummyEntityCache.putResult(
			BollettinoParametroImpl.class, bollettinoParametro.getPrimaryKey(),
			bollettinoParametro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bollettino parametros in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametros the bollettino parametros
	 */
	@Override
	public void cacheResult(List<BollettinoParametro> bollettinoParametros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bollettinoParametros.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BollettinoParametro bollettinoParametro : bollettinoParametros) {
			if (dummyEntityCache.getResult(
					BollettinoParametroImpl.class,
					bollettinoParametro.getPrimaryKey()) == null) {

				cacheResult(bollettinoParametro);
			}
		}
	}

	/**
	 * Clears the cache for all bollettino parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(BollettinoParametroImpl.class);

		dummyFinderCache.clearCache(BollettinoParametroImpl.class);
	}

	/**
	 * Clears the cache for the bollettino parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoParametro bollettinoParametro) {
		dummyEntityCache.removeResult(
			BollettinoParametroImpl.class, bollettinoParametro);
	}

	@Override
	public void clearCache(List<BollettinoParametro> bollettinoParametros) {
		for (BollettinoParametro bollettinoParametro : bollettinoParametros) {
			dummyEntityCache.removeResult(
				BollettinoParametroImpl.class, bollettinoParametro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(BollettinoParametroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				BollettinoParametroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bollettino parametro with the primary key. Does not add the bollettino parametro to the database.
	 *
	 * @param parametroId the primary key for the new bollettino parametro
	 * @return the new bollettino parametro
	 */
	@Override
	public BollettinoParametro create(String parametroId) {
		BollettinoParametro bollettinoParametro = new BollettinoParametroImpl();

		bollettinoParametro.setNew(true);
		bollettinoParametro.setPrimaryKey(parametroId);

		return bollettinoParametro;
	}

	/**
	 * Removes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro remove(String parametroId)
		throws NoSuchBollettinoParametroException {

		return remove((Serializable)parametroId);
	}

	/**
	 * Removes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro remove(Serializable primaryKey)
		throws NoSuchBollettinoParametroException {

		Session session = null;

		try {
			session = openSession();

			BollettinoParametro bollettinoParametro =
				(BollettinoParametro)session.get(
					BollettinoParametroImpl.class, primaryKey);

			if (bollettinoParametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoParametro);
		}
		catch (NoSuchBollettinoParametroException noSuchEntityException) {
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
	protected BollettinoParametro removeImpl(
		BollettinoParametro bollettinoParametro) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoParametro)) {
				bollettinoParametro = (BollettinoParametro)session.get(
					BollettinoParametroImpl.class,
					bollettinoParametro.getPrimaryKeyObj());
			}

			if (bollettinoParametro != null) {
				session.delete(bollettinoParametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoParametro != null) {
			clearCache(bollettinoParametro);
		}

		return bollettinoParametro;
	}

	@Override
	public BollettinoParametro updateImpl(
		BollettinoParametro bollettinoParametro) {

		boolean isNew = bollettinoParametro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bollettinoParametro);
			}
			else {
				bollettinoParametro = (BollettinoParametro)session.merge(
					bollettinoParametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			BollettinoParametroImpl.class, bollettinoParametro, false, true);

		if (isNew) {
			bollettinoParametro.setNew(false);
		}

		bollettinoParametro.resetOriginalValues();

		return bollettinoParametro;
	}

	/**
	 * Returns the bollettino parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoParametroException {

		BollettinoParametro bollettinoParametro = fetchByPrimaryKey(primaryKey);

		if (bollettinoParametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoParametro;
	}

	/**
	 * Returns the bollettino parametro with the primary key or throws a <code>NoSuchBollettinoParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro findByPrimaryKey(String parametroId)
		throws NoSuchBollettinoParametroException {

		return findByPrimaryKey((Serializable)parametroId);
	}

	/**
	 * Returns the bollettino parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro, or <code>null</code> if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public BollettinoParametro fetchByPrimaryKey(String parametroId) {
		return fetchByPrimaryKey((Serializable)parametroId);
	}

	/**
	 * Returns all the bollettino parametros.
	 *
	 * @return the bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @return the range of bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll(
		int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettino parametros
	 */
	@Override
	public List<BollettinoParametro> findAll(
		int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator,
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

		List<BollettinoParametro> list = null;

		if (useFinderCache) {
			list = (List<BollettinoParametro>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOLLETTINOPARAMETRO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOPARAMETRO;

				sql = sql.concat(BollettinoParametroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BollettinoParametro>)QueryUtil.list(
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
	 * Removes all the bollettino parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoParametro bollettinoParametro : findAll()) {
			remove(bollettinoParametro);
		}
	}

	/**
	 * Returns the number of bollettino parametros.
	 *
	 * @return the number of bollettino parametros
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
					_SQL_COUNT_BOLLETTINOPARAMETRO);

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
		return "parametroId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOLLETTINOPARAMETRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BollettinoParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino parametro persistence.
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

		BollettinoParametroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BollettinoParametroUtil.setPersistence(null);

		dummyEntityCache.removeCache(BollettinoParametroImpl.class.getName());
	}

	@Override
	@Reference(
		target = BOLLETTINOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BOLLETTINOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BOLLETTINOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_BOLLETTINOPARAMETRO =
		"SELECT bollettinoParametro FROM BollettinoParametro bollettinoParametro";

	private static final String _SQL_COUNT_BOLLETTINOPARAMETRO =
		"SELECT COUNT(bollettinoParametro) FROM BollettinoParametro bollettinoParametro";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoParametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoParametro exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoParametroPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}