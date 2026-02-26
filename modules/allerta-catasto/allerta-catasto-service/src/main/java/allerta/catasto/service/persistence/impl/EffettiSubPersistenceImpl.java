/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.impl;

import allerta.catasto.exception.NoSuchEffettiSubException;
import allerta.catasto.model.EffettiSub;
import allerta.catasto.model.EffettiSubTable;
import allerta.catasto.model.impl.EffettiSubImpl;
import allerta.catasto.model.impl.EffettiSubModelImpl;
import allerta.catasto.service.persistence.EffettiSubPK;
import allerta.catasto.service.persistence.EffettiSubPersistence;
import allerta.catasto.service.persistence.EffettiSubUtil;
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
 * The persistence implementation for the effetti sub service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EffettiSubPersistence.class)
public class EffettiSubPersistenceImpl
	extends BasePersistenceImpl<EffettiSub> implements EffettiSubPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EffettiSubUtil</code> to access the effetti sub persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EffettiSubImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EffettiSubPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EffettiSub.class);

		setModelImplClass(EffettiSubImpl.class);
		setModelPKClass(EffettiSubPK.class);

		setTable(EffettiSubTable.INSTANCE);
	}

	/**
	 * Caches the effetti sub in the entity cache if it is enabled.
	 *
	 * @param effettiSub the effetti sub
	 */
	@Override
	public void cacheResult(EffettiSub effettiSub) {
		entityCache.putResult(
			EffettiSubImpl.class, effettiSub.getPrimaryKey(), effettiSub);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the effetti subs in the entity cache if it is enabled.
	 *
	 * @param effettiSubs the effetti subs
	 */
	@Override
	public void cacheResult(List<EffettiSub> effettiSubs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (effettiSubs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EffettiSub effettiSub : effettiSubs) {
			if (entityCache.getResult(
					EffettiSubImpl.class, effettiSub.getPrimaryKey()) == null) {

				cacheResult(effettiSub);
			}
		}
	}

	/**
	 * Clears the cache for all effetti subs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EffettiSubImpl.class);

		finderCache.clearCache(EffettiSubImpl.class);
	}

	/**
	 * Clears the cache for the effetti sub.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EffettiSub effettiSub) {
		entityCache.removeResult(EffettiSubImpl.class, effettiSub);
	}

	@Override
	public void clearCache(List<EffettiSub> effettiSubs) {
		for (EffettiSub effettiSub : effettiSubs) {
			entityCache.removeResult(EffettiSubImpl.class, effettiSub);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EffettiSubImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EffettiSubImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new effetti sub with the primary key. Does not add the effetti sub to the database.
	 *
	 * @param effettiSubPK the primary key for the new effetti sub
	 * @return the new effetti sub
	 */
	@Override
	public EffettiSub create(EffettiSubPK effettiSubPK) {
		EffettiSub effettiSub = new EffettiSubImpl();

		effettiSub.setNew(true);
		effettiSub.setPrimaryKey(effettiSubPK);

		return effettiSub;
	}

	/**
	 * Removes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub remove(EffettiSubPK effettiSubPK)
		throws NoSuchEffettiSubException {

		return remove((Serializable)effettiSubPK);
	}

	/**
	 * Removes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub remove(Serializable primaryKey)
		throws NoSuchEffettiSubException {

		Session session = null;

		try {
			session = openSession();

			EffettiSub effettiSub = (EffettiSub)session.get(
				EffettiSubImpl.class, primaryKey);

			if (effettiSub == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEffettiSubException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(effettiSub);
		}
		catch (NoSuchEffettiSubException noSuchEntityException) {
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
	protected EffettiSub removeImpl(EffettiSub effettiSub) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(effettiSub)) {
				effettiSub = (EffettiSub)session.get(
					EffettiSubImpl.class, effettiSub.getPrimaryKeyObj());
			}

			if (effettiSub != null) {
				session.delete(effettiSub);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (effettiSub != null) {
			clearCache(effettiSub);
		}

		return effettiSub;
	}

	@Override
	public EffettiSub updateImpl(EffettiSub effettiSub) {
		boolean isNew = effettiSub.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(effettiSub);
			}
			else {
				effettiSub = (EffettiSub)session.merge(effettiSub);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EffettiSubImpl.class, effettiSub, false, true);

		if (isNew) {
			effettiSub.setNew(false);
		}

		effettiSub.resetOriginalValues();

		return effettiSub;
	}

	/**
	 * Returns the effetti sub with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEffettiSubException {

		EffettiSub effettiSub = fetchByPrimaryKey(primaryKey);

		if (effettiSub == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEffettiSubException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return effettiSub;
	}

	/**
	 * Returns the effetti sub with the primary key or throws a <code>NoSuchEffettiSubException</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub findByPrimaryKey(EffettiSubPK effettiSubPK)
		throws NoSuchEffettiSubException {

		return findByPrimaryKey((Serializable)effettiSubPK);
	}

	/**
	 * Returns the effetti sub with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub, or <code>null</code> if a effetti sub with the primary key could not be found
	 */
	@Override
	public EffettiSub fetchByPrimaryKey(EffettiSubPK effettiSubPK) {
		return fetchByPrimaryKey((Serializable)effettiSubPK);
	}

	/**
	 * Returns all the effetti subs.
	 *
	 * @return the effetti subs
	 */
	@Override
	public List<EffettiSub> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @return the range of effetti subs
	 */
	@Override
	public List<EffettiSub> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effetti subs
	 */
	@Override
	public List<EffettiSub> findAll(
		int start, int end, OrderByComparator<EffettiSub> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of effetti subs
	 */
	@Override
	public List<EffettiSub> findAll(
		int start, int end, OrderByComparator<EffettiSub> orderByComparator,
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

		List<EffettiSub> list = null;

		if (useFinderCache) {
			list = (List<EffettiSub>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EFFETTISUB);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EFFETTISUB;

				sql = sql.concat(EffettiSubModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EffettiSub>)QueryUtil.list(
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
	 * Removes all the effetti subs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EffettiSub effettiSub : findAll()) {
			remove(effettiSub);
		}
	}

	/**
	 * Returns the number of effetti subs.
	 *
	 * @return the number of effetti subs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EFFETTISUB);

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
		return "effettiSubPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EFFETTISUB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EffettiSubModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the effetti sub persistence.
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

		EffettiSubUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EffettiSubUtil.setPersistence(null);

		entityCache.removeCache(EffettiSubImpl.class.getName());
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

	private static final String _SQL_SELECT_EFFETTISUB =
		"SELECT effettiSub FROM EffettiSub effettiSub";

	private static final String _SQL_COUNT_EFFETTISUB =
		"SELECT COUNT(effettiSub) FROM EffettiSub effettiSub";

	private static final String _ORDER_BY_ENTITY_ALIAS = "effettiSub.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EffettiSub exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EffettiSubPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"id", "idEffetti"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}