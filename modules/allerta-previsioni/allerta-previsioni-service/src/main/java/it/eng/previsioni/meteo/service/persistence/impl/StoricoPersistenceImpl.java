/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;

import it.eng.previsioni.meteo.exception.NoSuchStoricoException;
import it.eng.previsioni.meteo.model.Storico;
import it.eng.previsioni.meteo.model.StoricoTable;
import it.eng.previsioni.meteo.model.impl.StoricoImpl;
import it.eng.previsioni.meteo.model.impl.StoricoModelImpl;
import it.eng.previsioni.meteo.service.persistence.StoricoPersistence;
import it.eng.previsioni.meteo.service.persistence.StoricoUtil;
import it.eng.previsioni.meteo.service.persistence.impl.constants.prev_meteoPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the storico service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StoricoPersistence.class)
public class StoricoPersistenceImpl
	extends BasePersistenceImpl<Storico> implements StoricoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StoricoUtil</code> to access the storico persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StoricoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySigla;
	private FinderPath _finderPathWithoutPaginationFindBySigla;
	private FinderPath _finderPathCountBySigla;

	/**
	 * Returns all the storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the matching storicos
	 */
	@Override
	public List<Storico> findBySigla(String sigla) {
		return findBySigla(sigla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of matching storicos
	 */
	@Override
	public List<Storico> findBySigla(String sigla, int start, int end) {
		return findBySigla(sigla, start, end, null);
	}

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching storicos
	 */
	@Override
	public List<Storico> findBySigla(
		String sigla, int start, int end,
		OrderByComparator<Storico> orderByComparator) {

		return findBySigla(sigla, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching storicos
	 */
	@Override
	public List<Storico> findBySigla(
		String sigla, int start, int end,
		OrderByComparator<Storico> orderByComparator, boolean useFinderCache) {

		sigla = Objects.toString(sigla, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySigla;
				finderArgs = new Object[] {sigla};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySigla;
			finderArgs = new Object[] {sigla, start, end, orderByComparator};
		}

		List<Storico> list = null;

		if (useFinderCache) {
			list = (List<Storico>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Storico storico : list) {
					if (!sigla.equals(storico.getSigla())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STORICO_WHERE);

			boolean bindSigla = false;

			if (sigla.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
			}
			else {
				bindSigla = true;

				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StoricoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSigla) {
					queryPos.add(sigla);
				}

				list = (List<Storico>)QueryUtil.list(
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
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	@Override
	public Storico findBySigla_First(
			String sigla, OrderByComparator<Storico> orderByComparator)
		throws NoSuchStoricoException {

		Storico storico = fetchBySigla_First(sigla, orderByComparator);

		if (storico != null) {
			return storico;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sigla=");
		sb.append(sigla);

		sb.append("}");

		throw new NoSuchStoricoException(sb.toString());
	}

	/**
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico, or <code>null</code> if a matching storico could not be found
	 */
	@Override
	public Storico fetchBySigla_First(
		String sigla, OrderByComparator<Storico> orderByComparator) {

		List<Storico> list = findBySigla(sigla, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	@Override
	public Storico findBySigla_Last(
			String sigla, OrderByComparator<Storico> orderByComparator)
		throws NoSuchStoricoException {

		Storico storico = fetchBySigla_Last(sigla, orderByComparator);

		if (storico != null) {
			return storico;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sigla=");
		sb.append(sigla);

		sb.append("}");

		throw new NoSuchStoricoException(sb.toString());
	}

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico, or <code>null</code> if a matching storico could not be found
	 */
	@Override
	public Storico fetchBySigla_Last(
		String sigla, OrderByComparator<Storico> orderByComparator) {

		int count = countBySigla(sigla);

		if (count == 0) {
			return null;
		}

		List<Storico> list = findBySigla(
			sigla, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the storicos before and after the current storico in the ordered set where sigla = &#63;.
	 *
	 * @param id the primary key of the current storico
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico[] findBySigla_PrevAndNext(
			long id, String sigla, OrderByComparator<Storico> orderByComparator)
		throws NoSuchStoricoException {

		sigla = Objects.toString(sigla, "");

		Storico storico = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Storico[] array = new StoricoImpl[3];

			array[0] = getBySigla_PrevAndNext(
				session, storico, sigla, orderByComparator, true);

			array[1] = storico;

			array[2] = getBySigla_PrevAndNext(
				session, storico, sigla, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Storico getBySigla_PrevAndNext(
		Session session, Storico storico, String sigla,
		OrderByComparator<Storico> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STORICO_WHERE);

		boolean bindSigla = false;

		if (sigla.isEmpty()) {
			sb.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
		}
		else {
			bindSigla = true;

			sb.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StoricoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSigla) {
			queryPos.add(sigla);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(storico)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Storico> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the storicos where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 */
	@Override
	public void removeBySigla(String sigla) {
		for (Storico storico :
				findBySigla(
					sigla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(storico);
		}
	}

	/**
	 * Returns the number of storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching storicos
	 */
	@Override
	public int countBySigla(String sigla) {
		sigla = Objects.toString(sigla, "");

		FinderPath finderPath = _finderPathCountBySigla;

		Object[] finderArgs = new Object[] {sigla};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STORICO_WHERE);

			boolean bindSigla = false;

			if (sigla.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
			}
			else {
				bindSigla = true;

				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSigla) {
					queryPos.add(sigla);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_SIGLA_SIGLA_2 =
		"storico.sigla = ?";

	private static final String _FINDER_COLUMN_SIGLA_SIGLA_3 =
		"(storico.sigla IS NULL OR storico.sigla = '')";

	public StoricoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Storico.class);

		setModelImplClass(StoricoImpl.class);
		setModelPKClass(long.class);

		setTable(StoricoTable.INSTANCE);
	}

	/**
	 * Caches the storico in the entity cache if it is enabled.
	 *
	 * @param storico the storico
	 */
	@Override
	public void cacheResult(Storico storico) {
		entityCache.putResult(
			StoricoImpl.class, storico.getPrimaryKey(), storico);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the storicos in the entity cache if it is enabled.
	 *
	 * @param storicos the storicos
	 */
	@Override
	public void cacheResult(List<Storico> storicos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (storicos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Storico storico : storicos) {
			if (entityCache.getResult(
					StoricoImpl.class, storico.getPrimaryKey()) == null) {

				cacheResult(storico);
			}
		}
	}

	/**
	 * Clears the cache for all storicos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StoricoImpl.class);

		finderCache.clearCache(StoricoImpl.class);
	}

	/**
	 * Clears the cache for the storico.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Storico storico) {
		entityCache.removeResult(StoricoImpl.class, storico);
	}

	@Override
	public void clearCache(List<Storico> storicos) {
		for (Storico storico : storicos) {
			entityCache.removeResult(StoricoImpl.class, storico);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StoricoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StoricoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new storico with the primary key. Does not add the storico to the database.
	 *
	 * @param id the primary key for the new storico
	 * @return the new storico
	 */
	@Override
	public Storico create(long id) {
		Storico storico = new StoricoImpl();

		storico.setNew(true);
		storico.setPrimaryKey(id);

		return storico;
	}

	/**
	 * Removes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the storico
	 * @return the storico that was removed
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico remove(long id) throws NoSuchStoricoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the storico
	 * @return the storico that was removed
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico remove(Serializable primaryKey)
		throws NoSuchStoricoException {

		Session session = null;

		try {
			session = openSession();

			Storico storico = (Storico)session.get(
				StoricoImpl.class, primaryKey);

			if (storico == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStoricoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(storico);
		}
		catch (NoSuchStoricoException noSuchEntityException) {
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
	protected Storico removeImpl(Storico storico) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(storico)) {
				storico = (Storico)session.get(
					StoricoImpl.class, storico.getPrimaryKeyObj());
			}

			if (storico != null) {
				session.delete(storico);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (storico != null) {
			clearCache(storico);
		}

		return storico;
	}

	@Override
	public Storico updateImpl(Storico storico) {
		boolean isNew = storico.isNew();

		if (!(storico instanceof StoricoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(storico.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(storico);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in storico proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Storico implementation " +
					storico.getClass());
		}

		StoricoModelImpl storicoModelImpl = (StoricoModelImpl)storico;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(storico);
			}
			else {
				storico = (Storico)session.merge(storico);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StoricoImpl.class, storicoModelImpl, false, true);

		if (isNew) {
			storico.setNew(false);
		}

		storico.resetOriginalValues();

		return storico;
	}

	/**
	 * Returns the storico with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the storico
	 * @return the storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStoricoException {

		Storico storico = fetchByPrimaryKey(primaryKey);

		if (storico == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStoricoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return storico;
	}

	/**
	 * Returns the storico with the primary key or throws a <code>NoSuchStoricoException</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	@Override
	public Storico findByPrimaryKey(long id) throws NoSuchStoricoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the storico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico, or <code>null</code> if a storico with the primary key could not be found
	 */
	@Override
	public Storico fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the storicos.
	 *
	 * @return the storicos
	 */
	@Override
	public List<Storico> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of storicos
	 */
	@Override
	public List<Storico> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of storicos
	 */
	@Override
	public List<Storico> findAll(
		int start, int end, OrderByComparator<Storico> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of storicos
	 */
	@Override
	public List<Storico> findAll(
		int start, int end, OrderByComparator<Storico> orderByComparator,
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

		List<Storico> list = null;

		if (useFinderCache) {
			list = (List<Storico>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STORICO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STORICO;

				sql = sql.concat(StoricoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Storico>)QueryUtil.list(
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
	 * Removes all the storicos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Storico storico : findAll()) {
			remove(storico);
		}
	}

	/**
	 * Returns the number of storicos.
	 *
	 * @return the number of storicos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STORICO);

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
		return _SQL_SELECT_STORICO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StoricoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the storico persistence.
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

		_finderPathWithPaginationFindBySigla = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySigla",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"sigla"}, true);

		_finderPathWithoutPaginationFindBySigla = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySigla",
			new String[] {String.class.getName()}, new String[] {"sigla"},
			true);

		_finderPathCountBySigla = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigla",
			new String[] {String.class.getName()}, new String[] {"sigla"},
			false);

		StoricoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		StoricoUtil.setPersistence(null);

		entityCache.removeCache(StoricoImpl.class.getName());
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STORICO =
		"SELECT storico FROM Storico storico";

	private static final String _SQL_SELECT_STORICO_WHERE =
		"SELECT storico FROM Storico storico WHERE ";

	private static final String _SQL_COUNT_STORICO =
		"SELECT COUNT(storico) FROM Storico storico";

	private static final String _SQL_COUNT_STORICO_WHERE =
		"SELECT COUNT(storico) FROM Storico storico WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "storico.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Storico exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Storico exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StoricoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}