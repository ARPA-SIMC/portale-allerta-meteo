/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.allerte.exception.NoSuchRubricaRuoloException;
import it.eng.allerte.model.RubricaRuolo;
import it.eng.allerte.model.RubricaRuoloTable;
import it.eng.allerte.model.impl.RubricaRuoloImpl;
import it.eng.allerte.model.impl.RubricaRuoloModelImpl;
import it.eng.allerte.service.persistence.RubricaRuoloPersistence;
import it.eng.allerte.service.persistence.RubricaRuoloUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the rubrica ruolo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaRuoloPersistence.class)
public class RubricaRuoloPersistenceImpl
	extends BasePersistenceImpl<RubricaRuolo>
	implements RubricaRuoloPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaRuoloUtil</code> to access the rubrica ruolo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaRuoloImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByRubricaRuoloByRuoloLiferay;

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a matching rubrica ruolo could not be found
	 */
	@Override
	public RubricaRuolo findByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY)
		throws NoSuchRubricaRuoloException {

		RubricaRuolo rubricaRuolo = fetchByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);

		if (rubricaRuolo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("FK_RUOLO_LIFERAY=");
			sb.append(FK_RUOLO_LIFERAY);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRubricaRuoloException(sb.toString());
		}

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	@Override
	public RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY) {

		return fetchByRubricaRuoloByRuoloLiferay(FK_RUOLO_LIFERAY, true);
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	@Override
	public RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {FK_RUOLO_LIFERAY};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByRubricaRuoloByRuoloLiferay, finderArgs, this);
		}

		if (result instanceof RubricaRuolo) {
			RubricaRuolo rubricaRuolo = (RubricaRuolo)result;

			if (FK_RUOLO_LIFERAY != rubricaRuolo.getFK_RUOLO_LIFERAY()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_RUBRICARUOLO_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICARUOLOBYRUOLOLIFERAY_FK_RUOLO_LIFERAY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_RUOLO_LIFERAY);

				List<RubricaRuolo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByRubricaRuoloByRuoloLiferay,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {FK_RUOLO_LIFERAY};
							}

							_log.warn(
								"RubricaRuoloPersistenceImpl.fetchByRubricaRuoloByRuoloLiferay(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RubricaRuolo rubricaRuolo = list.get(0);

					result = rubricaRuolo;

					cacheResult(rubricaRuolo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RubricaRuolo)result;
		}
	}

	/**
	 * Removes the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; from the database.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the rubrica ruolo that was removed
	 */
	@Override
	public RubricaRuolo removeByRubricaRuoloByRuoloLiferay(
			long FK_RUOLO_LIFERAY)
		throws NoSuchRubricaRuoloException {

		RubricaRuolo rubricaRuolo = findByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);

		return remove(rubricaRuolo);
	}

	/**
	 * Returns the number of rubrica ruolos where FK_RUOLO_LIFERAY = &#63;.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the number of matching rubrica ruolos
	 */
	@Override
	public int countByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY) {
		RubricaRuolo rubricaRuolo = fetchByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);

		if (rubricaRuolo == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_RUBRICARUOLOBYRUOLOLIFERAY_FK_RUOLO_LIFERAY_2 =
			"rubricaRuolo.FK_RUOLO_LIFERAY = ?";

	public RubricaRuoloPersistenceImpl() {
		setModelClass(RubricaRuolo.class);

		setModelImplClass(RubricaRuoloImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaRuoloTable.INSTANCE);
	}

	/**
	 * Caches the rubrica ruolo in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 */
	@Override
	public void cacheResult(RubricaRuolo rubricaRuolo) {
		dummyEntityCache.putResult(
			RubricaRuoloImpl.class, rubricaRuolo.getPrimaryKey(), rubricaRuolo);

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaRuoloByRuoloLiferay,
			new Object[] {rubricaRuolo.getFK_RUOLO_LIFERAY()}, rubricaRuolo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica ruolos in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolos the rubrica ruolos
	 */
	@Override
	public void cacheResult(List<RubricaRuolo> rubricaRuolos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaRuolos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaRuolo rubricaRuolo : rubricaRuolos) {
			if (dummyEntityCache.getResult(
					RubricaRuoloImpl.class, rubricaRuolo.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaRuolo);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica ruolos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaRuoloImpl.class);

		dummyFinderCache.clearCache(RubricaRuoloImpl.class);
	}

	/**
	 * Clears the cache for the rubrica ruolo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaRuolo rubricaRuolo) {
		dummyEntityCache.removeResult(RubricaRuoloImpl.class, rubricaRuolo);
	}

	@Override
	public void clearCache(List<RubricaRuolo> rubricaRuolos) {
		for (RubricaRuolo rubricaRuolo : rubricaRuolos) {
			dummyEntityCache.removeResult(RubricaRuoloImpl.class, rubricaRuolo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaRuoloImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(RubricaRuoloImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RubricaRuoloModelImpl rubricaRuoloModelImpl) {

		Object[] args = new Object[] {
			rubricaRuoloModelImpl.getFK_RUOLO_LIFERAY()
		};

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaRuoloByRuoloLiferay, args,
			rubricaRuoloModelImpl);
	}

	/**
	 * Creates a new rubrica ruolo with the primary key. Does not add the rubrica ruolo to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo
	 * @return the new rubrica ruolo
	 */
	@Override
	public RubricaRuolo create(long ID_RUOLO) {
		RubricaRuolo rubricaRuolo = new RubricaRuoloImpl();

		rubricaRuolo.setNew(true);
		rubricaRuolo.setPrimaryKey(ID_RUOLO);

		return rubricaRuolo;
	}

	/**
	 * Removes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo remove(long ID_RUOLO)
		throws NoSuchRubricaRuoloException {

		return remove((Serializable)ID_RUOLO);
	}

	/**
	 * Removes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo remove(Serializable primaryKey)
		throws NoSuchRubricaRuoloException {

		Session session = null;

		try {
			session = openSession();

			RubricaRuolo rubricaRuolo = (RubricaRuolo)session.get(
				RubricaRuoloImpl.class, primaryKey);

			if (rubricaRuolo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaRuoloException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaRuolo);
		}
		catch (NoSuchRubricaRuoloException noSuchEntityException) {
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
	protected RubricaRuolo removeImpl(RubricaRuolo rubricaRuolo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaRuolo)) {
				rubricaRuolo = (RubricaRuolo)session.get(
					RubricaRuoloImpl.class, rubricaRuolo.getPrimaryKeyObj());
			}

			if (rubricaRuolo != null) {
				session.delete(rubricaRuolo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaRuolo != null) {
			clearCache(rubricaRuolo);
		}

		return rubricaRuolo;
	}

	@Override
	public RubricaRuolo updateImpl(RubricaRuolo rubricaRuolo) {
		boolean isNew = rubricaRuolo.isNew();

		if (!(rubricaRuolo instanceof RubricaRuoloModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaRuolo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaRuolo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaRuolo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaRuolo implementation " +
					rubricaRuolo.getClass());
		}

		RubricaRuoloModelImpl rubricaRuoloModelImpl =
			(RubricaRuoloModelImpl)rubricaRuolo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaRuolo);
			}
			else {
				rubricaRuolo = (RubricaRuolo)session.merge(rubricaRuolo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaRuoloImpl.class, rubricaRuoloModelImpl, false, true);

		cacheUniqueFindersCache(rubricaRuoloModelImpl);

		if (isNew) {
			rubricaRuolo.setNew(false);
		}

		rubricaRuolo.resetOriginalValues();

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaRuoloException {

		RubricaRuolo rubricaRuolo = fetchByPrimaryKey(primaryKey);

		if (rubricaRuolo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaRuoloException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaRuolo;
	}

	/**
	 * Returns the rubrica ruolo with the primary key or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo findByPrimaryKey(long ID_RUOLO)
		throws NoSuchRubricaRuoloException {

		return findByPrimaryKey((Serializable)ID_RUOLO);
	}

	/**
	 * Returns the rubrica ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo, or <code>null</code> if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public RubricaRuolo fetchByPrimaryKey(long ID_RUOLO) {
		return fetchByPrimaryKey((Serializable)ID_RUOLO);
	}

	/**
	 * Returns all the rubrica ruolos.
	 *
	 * @return the rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @return the range of rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll(
		int start, int end, OrderByComparator<RubricaRuolo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica ruolos
	 */
	@Override
	public List<RubricaRuolo> findAll(
		int start, int end, OrderByComparator<RubricaRuolo> orderByComparator,
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

		List<RubricaRuolo> list = null;

		if (useFinderCache) {
			list = (List<RubricaRuolo>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICARUOLO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICARUOLO;

				sql = sql.concat(RubricaRuoloModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaRuolo>)QueryUtil.list(
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
	 * Removes all the rubrica ruolos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaRuolo rubricaRuolo : findAll()) {
			remove(rubricaRuolo);
		}
	}

	/**
	 * Returns the number of rubrica ruolos.
	 *
	 * @return the number of rubrica ruolos
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICARUOLO);

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
		return "ID_RUOLO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICARUOLO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaRuoloModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica ruolo persistence.
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

		_finderPathFetchByRubricaRuoloByRuoloLiferay = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRubricaRuoloByRuoloLiferay",
			new String[] {Long.class.getName()},
			new String[] {"FK_RUOLO_LIFERAY"}, true);

		RubricaRuoloUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaRuoloUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaRuoloImpl.class.getName());
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_RUBRICARUOLO =
		"SELECT rubricaRuolo FROM RubricaRuolo rubricaRuolo";

	private static final String _SQL_SELECT_RUBRICARUOLO_WHERE =
		"SELECT rubricaRuolo FROM RubricaRuolo rubricaRuolo WHERE ";

	private static final String _SQL_COUNT_RUBRICARUOLO =
		"SELECT COUNT(rubricaRuolo) FROM RubricaRuolo rubricaRuolo";

	private static final String _SQL_COUNT_RUBRICARUOLO_WHERE =
		"SELECT COUNT(rubricaRuolo) FROM RubricaRuolo rubricaRuolo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaRuolo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaRuolo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaRuolo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaRuoloPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}