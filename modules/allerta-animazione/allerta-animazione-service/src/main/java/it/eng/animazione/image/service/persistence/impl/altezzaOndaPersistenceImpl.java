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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaException;
import it.eng.animazione.image.model.altezzaOnda;
import it.eng.animazione.image.model.altezzaOndaTable;
import it.eng.animazione.image.model.impl.altezzaOndaImpl;
import it.eng.animazione.image.model.impl.altezzaOndaModelImpl;
import it.eng.animazione.image.service.persistence.altezzaOndaPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaUtil;
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
 * The persistence implementation for the altezza onda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = altezzaOndaPersistence.class)
public class altezzaOndaPersistenceImpl
	extends BasePersistenceImpl<altezzaOnda> implements altezzaOndaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>altezzaOndaUtil</code> to access the altezza onda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		altezzaOndaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public altezzaOndaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("ts_UTC", "timestamp");

		setDBColumnNames(dbColumnNames);

		setModelClass(altezzaOnda.class);

		setModelImplClass(altezzaOndaImpl.class);
		setModelPKClass(long.class);

		setTable(altezzaOndaTable.INSTANCE);
	}

	/**
	 * Caches the altezza onda in the entity cache if it is enabled.
	 *
	 * @param altezzaOnda the altezza onda
	 */
	@Override
	public void cacheResult(altezzaOnda altezzaOnda) {
		entityCache.putResult(
			altezzaOndaImpl.class, altezzaOnda.getPrimaryKey(), altezzaOnda);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the altezza ondas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndas the altezza ondas
	 */
	@Override
	public void cacheResult(List<altezzaOnda> altezzaOndas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (altezzaOndas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (altezzaOnda altezzaOnda : altezzaOndas) {
			if (entityCache.getResult(
					altezzaOndaImpl.class, altezzaOnda.getPrimaryKey()) ==
						null) {

				cacheResult(altezzaOnda);
			}
		}
	}

	/**
	 * Clears the cache for all altezza ondas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(altezzaOndaImpl.class);

		finderCache.clearCache(altezzaOndaImpl.class);
	}

	/**
	 * Clears the cache for the altezza onda.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(altezzaOnda altezzaOnda) {
		entityCache.removeResult(altezzaOndaImpl.class, altezzaOnda);
	}

	@Override
	public void clearCache(List<altezzaOnda> altezzaOndas) {
		for (altezzaOnda altezzaOnda : altezzaOndas) {
			entityCache.removeResult(altezzaOndaImpl.class, altezzaOnda);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(altezzaOndaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(altezzaOndaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new altezza onda with the primary key. Does not add the altezza onda to the database.
	 *
	 * @param id the primary key for the new altezza onda
	 * @return the new altezza onda
	 */
	@Override
	public altezzaOnda create(long id) {
		altezzaOnda altezzaOnda = new altezzaOndaImpl();

		altezzaOnda.setNew(true);
		altezzaOnda.setPrimaryKey(id);

		return altezzaOnda;
	}

	/**
	 * Removes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda remove(long id) throws NoSuchaltezzaOndaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda remove(Serializable primaryKey)
		throws NoSuchaltezzaOndaException {

		Session session = null;

		try {
			session = openSession();

			altezzaOnda altezzaOnda = (altezzaOnda)session.get(
				altezzaOndaImpl.class, primaryKey);

			if (altezzaOnda == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaltezzaOndaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(altezzaOnda);
		}
		catch (NoSuchaltezzaOndaException noSuchEntityException) {
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
	protected altezzaOnda removeImpl(altezzaOnda altezzaOnda) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(altezzaOnda)) {
				altezzaOnda = (altezzaOnda)session.get(
					altezzaOndaImpl.class, altezzaOnda.getPrimaryKeyObj());
			}

			if (altezzaOnda != null) {
				session.delete(altezzaOnda);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (altezzaOnda != null) {
			clearCache(altezzaOnda);
		}

		return altezzaOnda;
	}

	@Override
	public altezzaOnda updateImpl(altezzaOnda altezzaOnda) {
		boolean isNew = altezzaOnda.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(altezzaOnda);
			}
			else {
				altezzaOnda = (altezzaOnda)session.merge(altezzaOnda);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(altezzaOndaImpl.class, altezzaOnda, false, true);

		if (isNew) {
			altezzaOnda.setNew(false);
		}

		altezzaOnda.resetOriginalValues();

		return altezzaOnda;
	}

	/**
	 * Returns the altezza onda with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaltezzaOndaException {

		altezzaOnda altezzaOnda = fetchByPrimaryKey(primaryKey);

		if (altezzaOnda == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaltezzaOndaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return altezzaOnda;
	}

	/**
	 * Returns the altezza onda with the primary key or throws a <code>NoSuchaltezzaOndaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the altezza onda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda, or <code>null</code> if a altezza onda with the primary key could not be found
	 */
	@Override
	public altezzaOnda fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the altezza ondas.
	 *
	 * @return the altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @return the range of altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll(
		int start, int end, OrderByComparator<altezzaOnda> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza ondas
	 */
	@Override
	public List<altezzaOnda> findAll(
		int start, int end, OrderByComparator<altezzaOnda> orderByComparator,
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

		List<altezzaOnda> list = null;

		if (useFinderCache) {
			list = (List<altezzaOnda>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALTEZZAONDA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALTEZZAONDA;

				sql = sql.concat(altezzaOndaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<altezzaOnda>)QueryUtil.list(
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
	 * Removes all the altezza ondas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (altezzaOnda altezzaOnda : findAll()) {
			remove(altezzaOnda);
		}
	}

	/**
	 * Returns the number of altezza ondas.
	 *
	 * @return the number of altezza ondas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALTEZZAONDA);

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
		return _SQL_SELECT_ALTEZZAONDA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return altezzaOndaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the altezza onda persistence.
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

		altezzaOndaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		altezzaOndaUtil.setPersistence(null);

		entityCache.removeCache(altezzaOndaImpl.class.getName());
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

	private static final String _SQL_SELECT_ALTEZZAONDA =
		"SELECT altezzaOnda FROM altezzaOnda altezzaOnda";

	private static final String _SQL_COUNT_ALTEZZAONDA =
		"SELECT COUNT(altezzaOnda) FROM altezzaOnda altezzaOnda";

	private static final String _ORDER_BY_ENTITY_ALIAS = "altezzaOnda.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No altezzaOnda exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		altezzaOndaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}