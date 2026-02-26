/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.impl;

import allerta.catasto.exception.NoSuchEffettiException;
import allerta.catasto.model.Effetti;
import allerta.catasto.model.EffettiTable;
import allerta.catasto.model.impl.EffettiImpl;
import allerta.catasto.model.impl.EffettiModelImpl;
import allerta.catasto.service.persistence.EffettiPersistence;
import allerta.catasto.service.persistence.EffettiUtil;
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
 * The persistence implementation for the effetti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EffettiPersistence.class)
public class EffettiPersistenceImpl
	extends BasePersistenceImpl<Effetti> implements EffettiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EffettiUtil</code> to access the effetti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EffettiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EffettiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Effetti.class);

		setModelImplClass(EffettiImpl.class);
		setModelPKClass(long.class);

		setTable(EffettiTable.INSTANCE);
	}

	/**
	 * Caches the effetti in the entity cache if it is enabled.
	 *
	 * @param effetti the effetti
	 */
	@Override
	public void cacheResult(Effetti effetti) {
		entityCache.putResult(
			EffettiImpl.class, effetti.getPrimaryKey(), effetti);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the effettis in the entity cache if it is enabled.
	 *
	 * @param effettis the effettis
	 */
	@Override
	public void cacheResult(List<Effetti> effettis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (effettis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Effetti effetti : effettis) {
			if (entityCache.getResult(
					EffettiImpl.class, effetti.getPrimaryKey()) == null) {

				cacheResult(effetti);
			}
		}
	}

	/**
	 * Clears the cache for all effettis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EffettiImpl.class);

		finderCache.clearCache(EffettiImpl.class);
	}

	/**
	 * Clears the cache for the effetti.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Effetti effetti) {
		entityCache.removeResult(EffettiImpl.class, effetti);
	}

	@Override
	public void clearCache(List<Effetti> effettis) {
		for (Effetti effetti : effettis) {
			entityCache.removeResult(EffettiImpl.class, effetti);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EffettiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EffettiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new effetti with the primary key. Does not add the effetti to the database.
	 *
	 * @param id the primary key for the new effetti
	 * @return the new effetti
	 */
	@Override
	public Effetti create(long id) {
		Effetti effetti = new EffettiImpl();

		effetti.setNew(true);
		effetti.setPrimaryKey(id);

		return effetti;
	}

	/**
	 * Removes the effetti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti that was removed
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	@Override
	public Effetti remove(long id) throws NoSuchEffettiException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the effetti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the effetti
	 * @return the effetti that was removed
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	@Override
	public Effetti remove(Serializable primaryKey)
		throws NoSuchEffettiException {

		Session session = null;

		try {
			session = openSession();

			Effetti effetti = (Effetti)session.get(
				EffettiImpl.class, primaryKey);

			if (effetti == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEffettiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(effetti);
		}
		catch (NoSuchEffettiException noSuchEntityException) {
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
	protected Effetti removeImpl(Effetti effetti) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(effetti)) {
				effetti = (Effetti)session.get(
					EffettiImpl.class, effetti.getPrimaryKeyObj());
			}

			if (effetti != null) {
				session.delete(effetti);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (effetti != null) {
			clearCache(effetti);
		}

		return effetti;
	}

	@Override
	public Effetti updateImpl(Effetti effetti) {
		boolean isNew = effetti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(effetti);
			}
			else {
				effetti = (Effetti)session.merge(effetti);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EffettiImpl.class, effetti, false, true);

		if (isNew) {
			effetti.setNew(false);
		}

		effetti.resetOriginalValues();

		return effetti;
	}

	/**
	 * Returns the effetti with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the effetti
	 * @return the effetti
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	@Override
	public Effetti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEffettiException {

		Effetti effetti = fetchByPrimaryKey(primaryKey);

		if (effetti == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEffettiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return effetti;
	}

	/**
	 * Returns the effetti with the primary key or throws a <code>NoSuchEffettiException</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	@Override
	public Effetti findByPrimaryKey(long id) throws NoSuchEffettiException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the effetti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti, or <code>null</code> if a effetti with the primary key could not be found
	 */
	@Override
	public Effetti fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the effettis.
	 *
	 * @return the effettis
	 */
	@Override
	public List<Effetti> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @return the range of effettis
	 */
	@Override
	public List<Effetti> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effettis
	 */
	@Override
	public List<Effetti> findAll(
		int start, int end, OrderByComparator<Effetti> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of effettis
	 */
	@Override
	public List<Effetti> findAll(
		int start, int end, OrderByComparator<Effetti> orderByComparator,
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

		List<Effetti> list = null;

		if (useFinderCache) {
			list = (List<Effetti>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EFFETTI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EFFETTI;

				sql = sql.concat(EffettiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Effetti>)QueryUtil.list(
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
	 * Removes all the effettis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Effetti effetti : findAll()) {
			remove(effetti);
		}
	}

	/**
	 * Returns the number of effettis.
	 *
	 * @return the number of effettis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EFFETTI);

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
		return _SQL_SELECT_EFFETTI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EffettiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the effetti persistence.
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

		EffettiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EffettiUtil.setPersistence(null);

		entityCache.removeCache(EffettiImpl.class.getName());
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

	private static final String _SQL_SELECT_EFFETTI =
		"SELECT effetti FROM Effetti effetti";

	private static final String _SQL_COUNT_EFFETTI =
		"SELECT COUNT(effetti) FROM Effetti effetti";

	private static final String _ORDER_BY_ENTITY_ALIAS = "effetti.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Effetti exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EffettiPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}