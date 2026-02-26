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

import it.eng.bollettino.exception.NoSuchAttivazioneFiumeException;
import it.eng.bollettino.model.AttivazioneFiume;
import it.eng.bollettino.model.AttivazioneFiumeTable;
import it.eng.bollettino.model.impl.AttivazioneFiumeImpl;
import it.eng.bollettino.model.impl.AttivazioneFiumeModelImpl;
import it.eng.bollettino.service.persistence.AttivazioneFiumePersistence;
import it.eng.bollettino.service.persistence.AttivazioneFiumeUtil;
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
 * The persistence implementation for the attivazione fiume service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = AttivazioneFiumePersistence.class)
public class AttivazioneFiumePersistenceImpl
	extends BasePersistenceImpl<AttivazioneFiume>
	implements AttivazioneFiumePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AttivazioneFiumeUtil</code> to access the attivazione fiume persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AttivazioneFiumeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AttivazioneFiumePersistenceImpl() {
		setModelClass(AttivazioneFiume.class);

		setModelImplClass(AttivazioneFiumeImpl.class);
		setModelPKClass(String.class);

		setTable(AttivazioneFiumeTable.INSTANCE);
	}

	/**
	 * Caches the attivazione fiume in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiume the attivazione fiume
	 */
	@Override
	public void cacheResult(AttivazioneFiume attivazioneFiume) {
		entityCache.putResult(
			AttivazioneFiumeImpl.class, attivazioneFiume.getPrimaryKey(),
			attivazioneFiume);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the attivazione fiumes in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiumes the attivazione fiumes
	 */
	@Override
	public void cacheResult(List<AttivazioneFiume> attivazioneFiumes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (attivazioneFiumes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AttivazioneFiume attivazioneFiume : attivazioneFiumes) {
			if (entityCache.getResult(
					AttivazioneFiumeImpl.class,
					attivazioneFiume.getPrimaryKey()) == null) {

				cacheResult(attivazioneFiume);
			}
		}
	}

	/**
	 * Clears the cache for all attivazione fiumes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttivazioneFiumeImpl.class);

		finderCache.clearCache(AttivazioneFiumeImpl.class);
	}

	/**
	 * Clears the cache for the attivazione fiume.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttivazioneFiume attivazioneFiume) {
		entityCache.removeResult(AttivazioneFiumeImpl.class, attivazioneFiume);
	}

	@Override
	public void clearCache(List<AttivazioneFiume> attivazioneFiumes) {
		for (AttivazioneFiume attivazioneFiume : attivazioneFiumes) {
			entityCache.removeResult(
				AttivazioneFiumeImpl.class, attivazioneFiume);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AttivazioneFiumeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AttivazioneFiumeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new attivazione fiume with the primary key. Does not add the attivazione fiume to the database.
	 *
	 * @param fiumeId the primary key for the new attivazione fiume
	 * @return the new attivazione fiume
	 */
	@Override
	public AttivazioneFiume create(String fiumeId) {
		AttivazioneFiume attivazioneFiume = new AttivazioneFiumeImpl();

		attivazioneFiume.setNew(true);
		attivazioneFiume.setPrimaryKey(fiumeId);

		return attivazioneFiume;
	}

	/**
	 * Removes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume remove(String fiumeId)
		throws NoSuchAttivazioneFiumeException {

		return remove((Serializable)fiumeId);
	}

	/**
	 * Removes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume remove(Serializable primaryKey)
		throws NoSuchAttivazioneFiumeException {

		Session session = null;

		try {
			session = openSession();

			AttivazioneFiume attivazioneFiume = (AttivazioneFiume)session.get(
				AttivazioneFiumeImpl.class, primaryKey);

			if (attivazioneFiume == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttivazioneFiumeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(attivazioneFiume);
		}
		catch (NoSuchAttivazioneFiumeException noSuchEntityException) {
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
	protected AttivazioneFiume removeImpl(AttivazioneFiume attivazioneFiume) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attivazioneFiume)) {
				attivazioneFiume = (AttivazioneFiume)session.get(
					AttivazioneFiumeImpl.class,
					attivazioneFiume.getPrimaryKeyObj());
			}

			if (attivazioneFiume != null) {
				session.delete(attivazioneFiume);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (attivazioneFiume != null) {
			clearCache(attivazioneFiume);
		}

		return attivazioneFiume;
	}

	@Override
	public AttivazioneFiume updateImpl(AttivazioneFiume attivazioneFiume) {
		boolean isNew = attivazioneFiume.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(attivazioneFiume);
			}
			else {
				attivazioneFiume = (AttivazioneFiume)session.merge(
					attivazioneFiume);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AttivazioneFiumeImpl.class, attivazioneFiume, false, true);

		if (isNew) {
			attivazioneFiume.setNew(false);
		}

		attivazioneFiume.resetOriginalValues();

		return attivazioneFiume;
	}

	/**
	 * Returns the attivazione fiume with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttivazioneFiumeException {

		AttivazioneFiume attivazioneFiume = fetchByPrimaryKey(primaryKey);

		if (attivazioneFiume == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttivazioneFiumeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return attivazioneFiume;
	}

	/**
	 * Returns the attivazione fiume with the primary key or throws a <code>NoSuchAttivazioneFiumeException</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume findByPrimaryKey(String fiumeId)
		throws NoSuchAttivazioneFiumeException {

		return findByPrimaryKey((Serializable)fiumeId);
	}

	/**
	 * Returns the attivazione fiume with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume, or <code>null</code> if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public AttivazioneFiume fetchByPrimaryKey(String fiumeId) {
		return fetchByPrimaryKey((Serializable)fiumeId);
	}

	/**
	 * Returns all the attivazione fiumes.
	 *
	 * @return the attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @return the range of attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll(
		int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attivazione fiumes
	 */
	@Override
	public List<AttivazioneFiume> findAll(
		int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator,
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

		List<AttivazioneFiume> list = null;

		if (useFinderCache) {
			list = (List<AttivazioneFiume>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ATTIVAZIONEFIUME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ATTIVAZIONEFIUME;

				sql = sql.concat(AttivazioneFiumeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AttivazioneFiume>)QueryUtil.list(
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
	 * Removes all the attivazione fiumes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttivazioneFiume attivazioneFiume : findAll()) {
			remove(attivazioneFiume);
		}
	}

	/**
	 * Returns the number of attivazione fiumes.
	 *
	 * @return the number of attivazione fiumes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ATTIVAZIONEFIUME);

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
		return "fiumeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ATTIVAZIONEFIUME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AttivazioneFiumeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attivazione fiume persistence.
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

		AttivazioneFiumeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AttivazioneFiumeUtil.setPersistence(null);

		entityCache.removeCache(AttivazioneFiumeImpl.class.getName());
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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ATTIVAZIONEFIUME =
		"SELECT attivazioneFiume FROM AttivazioneFiume attivazioneFiume";

	private static final String _SQL_COUNT_ATTIVAZIONEFIUME =
		"SELECT COUNT(attivazioneFiume) FROM AttivazioneFiume attivazioneFiume";

	private static final String _ORDER_BY_ENTITY_ALIAS = "attivazioneFiume.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AttivazioneFiume exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AttivazioneFiumePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}