/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence.impl;

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

import it.eng.animazione.image.exception.NoSuchParametroException;
import it.eng.animazione.image.model.Parametro;
import it.eng.animazione.image.model.ParametroTable;
import it.eng.animazione.image.model.impl.ParametroImpl;
import it.eng.animazione.image.model.impl.ParametroModelImpl;
import it.eng.animazione.image.service.persistence.ParametroPersistence;
import it.eng.animazione.image.service.persistence.ParametroUtil;
import it.eng.animazione.image.service.persistence.impl.constants.img_animazioniPersistenceConstants;

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
 * The persistence implementation for the parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = ParametroPersistence.class)
public class ParametroPersistenceImpl
	extends BasePersistenceImpl<Parametro> implements ParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParametroUtil</code> to access the parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ParametroPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Parametro.class);

		setModelImplClass(ParametroImpl.class);
		setModelPKClass(String.class);

		setTable(ParametroTable.INSTANCE);
	}

	/**
	 * Caches the parametro in the entity cache if it is enabled.
	 *
	 * @param parametro the parametro
	 */
	@Override
	public void cacheResult(Parametro parametro) {
		entityCache.putResult(
			ParametroImpl.class, parametro.getPrimaryKey(), parametro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	@Override
	public void cacheResult(List<Parametro> parametros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (parametros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Parametro parametro : parametros) {
			if (entityCache.getResult(
					ParametroImpl.class, parametro.getPrimaryKey()) == null) {

				cacheResult(parametro);
			}
		}
	}

	/**
	 * Clears the cache for all parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParametroImpl.class);

		finderCache.clearCache(ParametroImpl.class);
	}

	/**
	 * Clears the cache for the parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametro parametro) {
		entityCache.removeResult(ParametroImpl.class, parametro);
	}

	@Override
	public void clearCache(List<Parametro> parametros) {
		for (Parametro parametro : parametros) {
			entityCache.removeResult(ParametroImpl.class, parametro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ParametroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ParametroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param key the primary key for the new parametro
	 * @return the new parametro
	 */
	@Override
	public Parametro create(String key) {
		Parametro parametro = new ParametroImpl();

		parametro.setNew(true);
		parametro.setPrimaryKey(key);

		return parametro;
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro remove(String key) throws NoSuchParametroException {
		return remove((Serializable)key);
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro remove(Serializable primaryKey)
		throws NoSuchParametroException {

		Session session = null;

		try {
			session = openSession();

			Parametro parametro = (Parametro)session.get(
				ParametroImpl.class, primaryKey);

			if (parametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(parametro);
		}
		catch (NoSuchParametroException noSuchEntityException) {
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
	protected Parametro removeImpl(Parametro parametro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parametro)) {
				parametro = (Parametro)session.get(
					ParametroImpl.class, parametro.getPrimaryKeyObj());
			}

			if (parametro != null) {
				session.delete(parametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (parametro != null) {
			clearCache(parametro);
		}

		return parametro;
	}

	@Override
	public Parametro updateImpl(Parametro parametro) {
		boolean isNew = parametro.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(parametro);
			}
			else {
				parametro = (Parametro)session.merge(parametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ParametroImpl.class, parametro, false, true);

		if (isNew) {
			parametro.setNew(false);
		}

		parametro.resetOriginalValues();

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParametroException {

		Parametro parametro = fetchByPrimaryKey(primaryKey);

		if (parametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>NoSuchParametroException</code> if it could not be found.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro findByPrimaryKey(String key)
		throws NoSuchParametroException {

		return findByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro fetchByPrimaryKey(String key) {
		return fetchByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns all the parametros.
	 *
	 * @return the parametros
	 */
	@Override
	public List<Parametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 */
	@Override
	public List<Parametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametros
	 */
	@Override
	public List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parametros
	 */
	@Override
	public List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator,
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

		List<Parametro> list = null;

		if (useFinderCache) {
			list = (List<Parametro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PARAMETRO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETRO;

				sql = sql.concat(ParametroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Parametro>)QueryUtil.list(
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
	 * Removes all the parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Parametro parametro : findAll()) {
			remove(parametro);
		}
	}

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PARAMETRO);

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
		return "key_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PARAMETRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the parametro persistence.
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

		ParametroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ParametroUtil.setPersistence(null);

		entityCache.removeCache(ParametroImpl.class.getName());
	}

	@Override
	@Reference(
		target = img_animazioniPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = img_animazioniPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = img_animazioniPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PARAMETRO =
		"SELECT parametro FROM Parametro parametro";

	private static final String _SQL_COUNT_PARAMETRO =
		"SELECT COUNT(parametro) FROM Parametro parametro";

	private static final String _ORDER_BY_ENTITY_ALIAS = "parametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Parametro exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ParametroPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}