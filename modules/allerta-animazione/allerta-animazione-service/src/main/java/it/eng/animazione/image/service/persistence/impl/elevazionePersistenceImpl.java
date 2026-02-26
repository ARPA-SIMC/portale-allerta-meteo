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

import it.eng.animazione.image.exception.NoSuchelevazioneException;
import it.eng.animazione.image.model.elevazione;
import it.eng.animazione.image.model.elevazioneTable;
import it.eng.animazione.image.model.impl.elevazioneImpl;
import it.eng.animazione.image.model.impl.elevazioneModelImpl;
import it.eng.animazione.image.service.persistence.elevazionePersistence;
import it.eng.animazione.image.service.persistence.elevazioneUtil;
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
 * The persistence implementation for the elevazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = elevazionePersistence.class)
public class elevazionePersistenceImpl
	extends BasePersistenceImpl<elevazione> implements elevazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>elevazioneUtil</code> to access the elevazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		elevazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public elevazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("ts_UTC", "timestamp");

		setDBColumnNames(dbColumnNames);

		setModelClass(elevazione.class);

		setModelImplClass(elevazioneImpl.class);
		setModelPKClass(long.class);

		setTable(elevazioneTable.INSTANCE);
	}

	/**
	 * Caches the elevazione in the entity cache if it is enabled.
	 *
	 * @param elevazione the elevazione
	 */
	@Override
	public void cacheResult(elevazione elevazione) {
		entityCache.putResult(
			elevazioneImpl.class, elevazione.getPrimaryKey(), elevazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the elevaziones in the entity cache if it is enabled.
	 *
	 * @param elevaziones the elevaziones
	 */
	@Override
	public void cacheResult(List<elevazione> elevaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (elevaziones.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (elevazione elevazione : elevaziones) {
			if (entityCache.getResult(
					elevazioneImpl.class, elevazione.getPrimaryKey()) == null) {

				cacheResult(elevazione);
			}
		}
	}

	/**
	 * Clears the cache for all elevaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(elevazioneImpl.class);

		finderCache.clearCache(elevazioneImpl.class);
	}

	/**
	 * Clears the cache for the elevazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(elevazione elevazione) {
		entityCache.removeResult(elevazioneImpl.class, elevazione);
	}

	@Override
	public void clearCache(List<elevazione> elevaziones) {
		for (elevazione elevazione : elevaziones) {
			entityCache.removeResult(elevazioneImpl.class, elevazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(elevazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(elevazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new elevazione with the primary key. Does not add the elevazione to the database.
	 *
	 * @param id the primary key for the new elevazione
	 * @return the new elevazione
	 */
	@Override
	public elevazione create(long id) {
		elevazione elevazione = new elevazioneImpl();

		elevazione.setNew(true);
		elevazione.setPrimaryKey(id);

		return elevazione;
	}

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione remove(long id) throws NoSuchelevazioneException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione remove(Serializable primaryKey)
		throws NoSuchelevazioneException {

		Session session = null;

		try {
			session = openSession();

			elevazione elevazione = (elevazione)session.get(
				elevazioneImpl.class, primaryKey);

			if (elevazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchelevazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(elevazione);
		}
		catch (NoSuchelevazioneException noSuchEntityException) {
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
	protected elevazione removeImpl(elevazione elevazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(elevazione)) {
				elevazione = (elevazione)session.get(
					elevazioneImpl.class, elevazione.getPrimaryKeyObj());
			}

			if (elevazione != null) {
				session.delete(elevazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (elevazione != null) {
			clearCache(elevazione);
		}

		return elevazione;
	}

	@Override
	public elevazione updateImpl(elevazione elevazione) {
		boolean isNew = elevazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(elevazione);
			}
			else {
				elevazione = (elevazione)session.merge(elevazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(elevazioneImpl.class, elevazione, false, true);

		if (isNew) {
			elevazione.setNew(false);
		}

		elevazione.resetOriginalValues();

		return elevazione;
	}

	/**
	 * Returns the elevazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchelevazioneException {

		elevazione elevazione = fetchByPrimaryKey(primaryKey);

		if (elevazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchelevazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return elevazione;
	}

	/**
	 * Returns the elevazione with the primary key or throws a <code>NoSuchelevazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione findByPrimaryKey(long id)
		throws NoSuchelevazioneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the elevazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione, or <code>null</code> if a elevazione with the primary key could not be found
	 */
	@Override
	public elevazione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the elevaziones.
	 *
	 * @return the elevaziones
	 */
	@Override
	public List<elevazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @return the range of elevaziones
	 */
	@Override
	public List<elevazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of elevaziones
	 */
	@Override
	public List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of elevaziones
	 */
	@Override
	public List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator,
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

		List<elevazione> list = null;

		if (useFinderCache) {
			list = (List<elevazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELEVAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELEVAZIONE;

				sql = sql.concat(elevazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<elevazione>)QueryUtil.list(
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
	 * Removes all the elevaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (elevazione elevazione : findAll()) {
			remove(elevazione);
		}
	}

	/**
	 * Returns the number of elevaziones.
	 *
	 * @return the number of elevaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELEVAZIONE);

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
		return _SQL_SELECT_ELEVAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return elevazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the elevazione persistence.
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

		elevazioneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		elevazioneUtil.setPersistence(null);

		entityCache.removeCache(elevazioneImpl.class.getName());
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

	private static final String _SQL_SELECT_ELEVAZIONE =
		"SELECT elevazione FROM elevazione elevazione";

	private static final String _SQL_COUNT_ELEVAZIONE =
		"SELECT COUNT(elevazione) FROM elevazione elevazione";

	private static final String _ORDER_BY_ENTITY_ALIAS = "elevazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No elevazione exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		elevazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "ts_UTC"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}