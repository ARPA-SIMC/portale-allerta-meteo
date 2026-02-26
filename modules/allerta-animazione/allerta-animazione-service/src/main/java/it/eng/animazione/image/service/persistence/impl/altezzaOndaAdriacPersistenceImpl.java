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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaAdriacException;
import it.eng.animazione.image.model.altezzaOndaAdriac;
import it.eng.animazione.image.model.altezzaOndaAdriacTable;
import it.eng.animazione.image.model.impl.altezzaOndaAdriacImpl;
import it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl;
import it.eng.animazione.image.service.persistence.altezzaOndaAdriacPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaAdriacUtil;
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
 * The persistence implementation for the altezza onda adriac service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = altezzaOndaAdriacPersistence.class)
public class altezzaOndaAdriacPersistenceImpl
	extends BasePersistenceImpl<altezzaOndaAdriac>
	implements altezzaOndaAdriacPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>altezzaOndaAdriacUtil</code> to access the altezza onda adriac persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		altezzaOndaAdriacImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public altezzaOndaAdriacPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("ts_UTC", "timestamp");

		setDBColumnNames(dbColumnNames);

		setModelClass(altezzaOndaAdriac.class);

		setModelImplClass(altezzaOndaAdriacImpl.class);
		setModelPKClass(long.class);

		setTable(altezzaOndaAdriacTable.INSTANCE);
	}

	/**
	 * Caches the altezza onda adriac in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 */
	@Override
	public void cacheResult(altezzaOndaAdriac altezzaOndaAdriac) {
		entityCache.putResult(
			altezzaOndaAdriacImpl.class, altezzaOndaAdriac.getPrimaryKey(),
			altezzaOndaAdriac);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the altezza onda adriacs in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriacs the altezza onda adriacs
	 */
	@Override
	public void cacheResult(List<altezzaOndaAdriac> altezzaOndaAdriacs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (altezzaOndaAdriacs.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (altezzaOndaAdriac altezzaOndaAdriac : altezzaOndaAdriacs) {
			if (entityCache.getResult(
					altezzaOndaAdriacImpl.class,
					altezzaOndaAdriac.getPrimaryKey()) == null) {

				cacheResult(altezzaOndaAdriac);
			}
		}
	}

	/**
	 * Clears the cache for all altezza onda adriacs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(altezzaOndaAdriacImpl.class);

		finderCache.clearCache(altezzaOndaAdriacImpl.class);
	}

	/**
	 * Clears the cache for the altezza onda adriac.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(altezzaOndaAdriac altezzaOndaAdriac) {
		entityCache.removeResult(
			altezzaOndaAdriacImpl.class, altezzaOndaAdriac);
	}

	@Override
	public void clearCache(List<altezzaOndaAdriac> altezzaOndaAdriacs) {
		for (altezzaOndaAdriac altezzaOndaAdriac : altezzaOndaAdriacs) {
			entityCache.removeResult(
				altezzaOndaAdriacImpl.class, altezzaOndaAdriac);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(altezzaOndaAdriacImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(altezzaOndaAdriacImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	@Override
	public altezzaOndaAdriac create(long id) {
		altezzaOndaAdriac altezzaOndaAdriac = new altezzaOndaAdriacImpl();

		altezzaOndaAdriac.setNew(true);
		altezzaOndaAdriac.setPrimaryKey(id);

		return altezzaOndaAdriac;
	}

	/**
	 * Removes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac remove(long id)
		throws NoSuchaltezzaOndaAdriacException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac remove(Serializable primaryKey)
		throws NoSuchaltezzaOndaAdriacException {

		Session session = null;

		try {
			session = openSession();

			altezzaOndaAdriac altezzaOndaAdriac =
				(altezzaOndaAdriac)session.get(
					altezzaOndaAdriacImpl.class, primaryKey);

			if (altezzaOndaAdriac == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaltezzaOndaAdriacException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(altezzaOndaAdriac);
		}
		catch (NoSuchaltezzaOndaAdriacException noSuchEntityException) {
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
	protected altezzaOndaAdriac removeImpl(
		altezzaOndaAdriac altezzaOndaAdriac) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(altezzaOndaAdriac)) {
				altezzaOndaAdriac = (altezzaOndaAdriac)session.get(
					altezzaOndaAdriacImpl.class,
					altezzaOndaAdriac.getPrimaryKeyObj());
			}

			if (altezzaOndaAdriac != null) {
				session.delete(altezzaOndaAdriac);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (altezzaOndaAdriac != null) {
			clearCache(altezzaOndaAdriac);
		}

		return altezzaOndaAdriac;
	}

	@Override
	public altezzaOndaAdriac updateImpl(altezzaOndaAdriac altezzaOndaAdriac) {
		boolean isNew = altezzaOndaAdriac.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(altezzaOndaAdriac);
			}
			else {
				altezzaOndaAdriac = (altezzaOndaAdriac)session.merge(
					altezzaOndaAdriac);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			altezzaOndaAdriacImpl.class, altezzaOndaAdriac, false, true);

		if (isNew) {
			altezzaOndaAdriac.setNew(false);
		}

		altezzaOndaAdriac.resetOriginalValues();

		return altezzaOndaAdriac;
	}

	/**
	 * Returns the altezza onda adriac with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaltezzaOndaAdriacException {

		altezzaOndaAdriac altezzaOndaAdriac = fetchByPrimaryKey(primaryKey);

		if (altezzaOndaAdriac == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaltezzaOndaAdriacException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return altezzaOndaAdriac;
	}

	/**
	 * Returns the altezza onda adriac with the primary key or throws a <code>NoSuchaltezzaOndaAdriacException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaAdriacException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the altezza onda adriac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac, or <code>null</code> if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public altezzaOndaAdriac fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the altezza onda adriacs.
	 *
	 * @return the altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza onda adriacs
	 */
	@Override
	public List<altezzaOndaAdriac> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator,
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

		List<altezzaOndaAdriac> list = null;

		if (useFinderCache) {
			list = (List<altezzaOndaAdriac>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALTEZZAONDAADRIAC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALTEZZAONDAADRIAC;

				sql = sql.concat(altezzaOndaAdriacModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<altezzaOndaAdriac>)QueryUtil.list(
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
	 * Removes all the altezza onda adriacs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (altezzaOndaAdriac altezzaOndaAdriac : findAll()) {
			remove(altezzaOndaAdriac);
		}
	}

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALTEZZAONDAADRIAC);

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
		return _SQL_SELECT_ALTEZZAONDAADRIAC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return altezzaOndaAdriacModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the altezza onda adriac persistence.
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

		altezzaOndaAdriacUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		altezzaOndaAdriacUtil.setPersistence(null);

		entityCache.removeCache(altezzaOndaAdriacImpl.class.getName());
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

	private static final String _SQL_SELECT_ALTEZZAONDAADRIAC =
		"SELECT altezzaOndaAdriac FROM altezzaOndaAdriac altezzaOndaAdriac";

	private static final String _SQL_COUNT_ALTEZZAONDAADRIAC =
		"SELECT COUNT(altezzaOndaAdriac) FROM altezzaOndaAdriac altezzaOndaAdriac";

	private static final String _ORDER_BY_ENTITY_ALIAS = "altezzaOndaAdriac.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No altezzaOndaAdriac exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		altezzaOndaAdriacPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}