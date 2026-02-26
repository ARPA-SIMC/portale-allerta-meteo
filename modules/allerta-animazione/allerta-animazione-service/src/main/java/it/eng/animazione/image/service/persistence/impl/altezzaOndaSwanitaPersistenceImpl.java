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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaSwanitaException;
import it.eng.animazione.image.model.altezzaOndaSwanita;
import it.eng.animazione.image.model.altezzaOndaSwanitaTable;
import it.eng.animazione.image.model.impl.altezzaOndaSwanitaImpl;
import it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl;
import it.eng.animazione.image.service.persistence.altezzaOndaSwanitaPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaSwanitaUtil;
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
 * The persistence implementation for the altezza onda swanita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = altezzaOndaSwanitaPersistence.class)
public class altezzaOndaSwanitaPersistenceImpl
	extends BasePersistenceImpl<altezzaOndaSwanita>
	implements altezzaOndaSwanitaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>altezzaOndaSwanitaUtil</code> to access the altezza onda swanita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		altezzaOndaSwanitaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public altezzaOndaSwanitaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("ts_UTC", "timestamp");

		setDBColumnNames(dbColumnNames);

		setModelClass(altezzaOndaSwanita.class);

		setModelImplClass(altezzaOndaSwanitaImpl.class);
		setModelPKClass(long.class);

		setTable(altezzaOndaSwanitaTable.INSTANCE);
	}

	/**
	 * Caches the altezza onda swanita in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 */
	@Override
	public void cacheResult(altezzaOndaSwanita altezzaOndaSwanita) {
		entityCache.putResult(
			altezzaOndaSwanitaImpl.class, altezzaOndaSwanita.getPrimaryKey(),
			altezzaOndaSwanita);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the altezza onda swanitas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanitas the altezza onda swanitas
	 */
	@Override
	public void cacheResult(List<altezzaOndaSwanita> altezzaOndaSwanitas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (altezzaOndaSwanitas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (altezzaOndaSwanita altezzaOndaSwanita : altezzaOndaSwanitas) {
			if (entityCache.getResult(
					altezzaOndaSwanitaImpl.class,
					altezzaOndaSwanita.getPrimaryKey()) == null) {

				cacheResult(altezzaOndaSwanita);
			}
		}
	}

	/**
	 * Clears the cache for all altezza onda swanitas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(altezzaOndaSwanitaImpl.class);

		finderCache.clearCache(altezzaOndaSwanitaImpl.class);
	}

	/**
	 * Clears the cache for the altezza onda swanita.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(altezzaOndaSwanita altezzaOndaSwanita) {
		entityCache.removeResult(
			altezzaOndaSwanitaImpl.class, altezzaOndaSwanita);
	}

	@Override
	public void clearCache(List<altezzaOndaSwanita> altezzaOndaSwanitas) {
		for (altezzaOndaSwanita altezzaOndaSwanita : altezzaOndaSwanitas) {
			entityCache.removeResult(
				altezzaOndaSwanitaImpl.class, altezzaOndaSwanita);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(altezzaOndaSwanitaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(altezzaOndaSwanitaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new altezza onda swanita with the primary key. Does not add the altezza onda swanita to the database.
	 *
	 * @param id the primary key for the new altezza onda swanita
	 * @return the new altezza onda swanita
	 */
	@Override
	public altezzaOndaSwanita create(long id) {
		altezzaOndaSwanita altezzaOndaSwanita = new altezzaOndaSwanitaImpl();

		altezzaOndaSwanita.setNew(true);
		altezzaOndaSwanita.setPrimaryKey(id);

		return altezzaOndaSwanita;
	}

	/**
	 * Removes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita remove(long id)
		throws NoSuchaltezzaOndaSwanitaException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita remove(Serializable primaryKey)
		throws NoSuchaltezzaOndaSwanitaException {

		Session session = null;

		try {
			session = openSession();

			altezzaOndaSwanita altezzaOndaSwanita =
				(altezzaOndaSwanita)session.get(
					altezzaOndaSwanitaImpl.class, primaryKey);

			if (altezzaOndaSwanita == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaltezzaOndaSwanitaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(altezzaOndaSwanita);
		}
		catch (NoSuchaltezzaOndaSwanitaException noSuchEntityException) {
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
	protected altezzaOndaSwanita removeImpl(
		altezzaOndaSwanita altezzaOndaSwanita) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(altezzaOndaSwanita)) {
				altezzaOndaSwanita = (altezzaOndaSwanita)session.get(
					altezzaOndaSwanitaImpl.class,
					altezzaOndaSwanita.getPrimaryKeyObj());
			}

			if (altezzaOndaSwanita != null) {
				session.delete(altezzaOndaSwanita);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (altezzaOndaSwanita != null) {
			clearCache(altezzaOndaSwanita);
		}

		return altezzaOndaSwanita;
	}

	@Override
	public altezzaOndaSwanita updateImpl(
		altezzaOndaSwanita altezzaOndaSwanita) {

		boolean isNew = altezzaOndaSwanita.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(altezzaOndaSwanita);
			}
			else {
				altezzaOndaSwanita = (altezzaOndaSwanita)session.merge(
					altezzaOndaSwanita);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			altezzaOndaSwanitaImpl.class, altezzaOndaSwanita, false, true);

		if (isNew) {
			altezzaOndaSwanita.setNew(false);
		}

		altezzaOndaSwanita.resetOriginalValues();

		return altezzaOndaSwanita;
	}

	/**
	 * Returns the altezza onda swanita with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaltezzaOndaSwanitaException {

		altezzaOndaSwanita altezzaOndaSwanita = fetchByPrimaryKey(primaryKey);

		if (altezzaOndaSwanita == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaltezzaOndaSwanitaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return altezzaOndaSwanita;
	}

	/**
	 * Returns the altezza onda swanita with the primary key or throws a <code>NoSuchaltezzaOndaSwanitaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaSwanitaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the altezza onda swanita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita, or <code>null</code> if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public altezzaOndaSwanita fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the altezza onda swanitas.
	 *
	 * @return the altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @return the range of altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza onda swanitas
	 */
	@Override
	public List<altezzaOndaSwanita> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator,
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

		List<altezzaOndaSwanita> list = null;

		if (useFinderCache) {
			list = (List<altezzaOndaSwanita>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALTEZZAONDASWANITA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALTEZZAONDASWANITA;

				sql = sql.concat(altezzaOndaSwanitaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<altezzaOndaSwanita>)QueryUtil.list(
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
	 * Removes all the altezza onda swanitas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (altezzaOndaSwanita altezzaOndaSwanita : findAll()) {
			remove(altezzaOndaSwanita);
		}
	}

	/**
	 * Returns the number of altezza onda swanitas.
	 *
	 * @return the number of altezza onda swanitas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ALTEZZAONDASWANITA);

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
		return _SQL_SELECT_ALTEZZAONDASWANITA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return altezzaOndaSwanitaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the altezza onda swanita persistence.
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

		altezzaOndaSwanitaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		altezzaOndaSwanitaUtil.setPersistence(null);

		entityCache.removeCache(altezzaOndaSwanitaImpl.class.getName());
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

	private static final String _SQL_SELECT_ALTEZZAONDASWANITA =
		"SELECT altezzaOndaSwanita FROM altezzaOndaSwanita altezzaOndaSwanita";

	private static final String _SQL_COUNT_ALTEZZAONDASWANITA =
		"SELECT COUNT(altezzaOndaSwanita) FROM altezzaOndaSwanita altezzaOndaSwanita";

	private static final String _ORDER_BY_ENTITY_ALIAS = "altezzaOndaSwanita.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No altezzaOndaSwanita exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		altezzaOndaSwanitaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}