/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.service.persistence.impl;

import allerta.dewetra.exception.NoSuchHRWException;
import allerta.dewetra.model.HRW;
import allerta.dewetra.model.HRWTable;
import allerta.dewetra.model.impl.HRWImpl;
import allerta.dewetra.model.impl.HRWModelImpl;
import allerta.dewetra.service.persistence.HRWPersistence;
import allerta.dewetra.service.persistence.HRWUtil;
import allerta.dewetra.service.persistence.impl.constants.DEWETRAPersistenceConstants;

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
 * The persistence implementation for the hrw service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = HRWPersistence.class)
public class HRWPersistenceImpl
	extends BasePersistenceImpl<HRW> implements HRWPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HRWUtil</code> to access the hrw persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HRWImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByComune;
	private FinderPath _finderPathWithoutPaginationFindByComune;
	private FinderPath _finderPathCountByComune;

	/**
	 * Returns all the hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the matching hrws
	 */
	@Override
	public List<HRW> findByComune(String comune) {
		return findByComune(comune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of matching hrws
	 */
	@Override
	public List<HRW> findByComune(String comune, int start, int end) {
		return findByComune(comune, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hrws
	 */
	@Override
	public List<HRW> findByComune(
		String comune, int start, int end,
		OrderByComparator<HRW> orderByComparator) {

		return findByComune(comune, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hrws
	 */
	@Override
	public List<HRW> findByComune(
		String comune, int start, int end,
		OrderByComparator<HRW> orderByComparator, boolean useFinderCache) {

		comune = Objects.toString(comune, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByComune;
				finderArgs = new Object[] {comune};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByComune;
			finderArgs = new Object[] {comune, start, end, orderByComparator};
		}

		List<HRW> list = null;

		if (useFinderCache) {
			list = (List<HRW>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HRW hrw : list) {
					if (!comune.equals(hrw.getComune())) {
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

			sb.append(_SQL_SELECT_HRW_WHERE);

			boolean bindComune = false;

			if (comune.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMUNE_COMUNE_3);
			}
			else {
				bindComune = true;

				sb.append(_FINDER_COLUMN_COMUNE_COMUNE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HRWModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindComune) {
					queryPos.add(comune);
				}

				list = (List<HRW>)QueryUtil.list(
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
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	@Override
	public HRW findByComune_First(
			String comune, OrderByComparator<HRW> orderByComparator)
		throws NoSuchHRWException {

		HRW hrw = fetchByComune_First(comune, orderByComparator);

		if (hrw != null) {
			return hrw;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("comune=");
		sb.append(comune);

		sb.append("}");

		throw new NoSuchHRWException(sb.toString());
	}

	/**
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	@Override
	public HRW fetchByComune_First(
		String comune, OrderByComparator<HRW> orderByComparator) {

		List<HRW> list = findByComune(comune, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	@Override
	public HRW findByComune_Last(
			String comune, OrderByComparator<HRW> orderByComparator)
		throws NoSuchHRWException {

		HRW hrw = fetchByComune_Last(comune, orderByComparator);

		if (hrw != null) {
			return hrw;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("comune=");
		sb.append(comune);

		sb.append("}");

		throw new NoSuchHRWException(sb.toString());
	}

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	@Override
	public HRW fetchByComune_Last(
		String comune, OrderByComparator<HRW> orderByComparator) {

		int count = countByComune(comune);

		if (count == 0) {
			return null;
		}

		List<HRW> list = findByComune(
			comune, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hrws before and after the current hrw in the ordered set where comune = &#63;.
	 *
	 * @param id the primary key of the current hrw
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW[] findByComune_PrevAndNext(
			long id, String comune, OrderByComparator<HRW> orderByComparator)
		throws NoSuchHRWException {

		comune = Objects.toString(comune, "");

		HRW hrw = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HRW[] array = new HRWImpl[3];

			array[0] = getByComune_PrevAndNext(
				session, hrw, comune, orderByComparator, true);

			array[1] = hrw;

			array[2] = getByComune_PrevAndNext(
				session, hrw, comune, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected HRW getByComune_PrevAndNext(
		Session session, HRW hrw, String comune,
		OrderByComparator<HRW> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HRW_WHERE);

		boolean bindComune = false;

		if (comune.isEmpty()) {
			sb.append(_FINDER_COLUMN_COMUNE_COMUNE_3);
		}
		else {
			bindComune = true;

			sb.append(_FINDER_COLUMN_COMUNE_COMUNE_2);
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
			sb.append(HRWModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindComune) {
			queryPos.add(comune);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(hrw)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<HRW> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hrws where comune = &#63; from the database.
	 *
	 * @param comune the comune
	 */
	@Override
	public void removeByComune(String comune) {
		for (HRW hrw :
				findByComune(
					comune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(hrw);
		}
	}

	/**
	 * Returns the number of hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the number of matching hrws
	 */
	@Override
	public int countByComune(String comune) {
		comune = Objects.toString(comune, "");

		FinderPath finderPath = _finderPathCountByComune;

		Object[] finderArgs = new Object[] {comune};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HRW_WHERE);

			boolean bindComune = false;

			if (comune.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMUNE_COMUNE_3);
			}
			else {
				bindComune = true;

				sb.append(_FINDER_COLUMN_COMUNE_COMUNE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindComune) {
					queryPos.add(comune);
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

	private static final String _FINDER_COLUMN_COMUNE_COMUNE_2 =
		"hrw.comune = ?";

	private static final String _FINDER_COLUMN_COMUNE_COMUNE_3 =
		"(hrw.comune IS NULL OR hrw.comune = '')";

	public HRWPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HRW.class);

		setModelImplClass(HRWImpl.class);
		setModelPKClass(long.class);

		setTable(HRWTable.INSTANCE);
	}

	/**
	 * Caches the hrw in the entity cache if it is enabled.
	 *
	 * @param hrw the hrw
	 */
	@Override
	public void cacheResult(HRW hrw) {
		entityCache.putResult(HRWImpl.class, hrw.getPrimaryKey(), hrw);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the hrws in the entity cache if it is enabled.
	 *
	 * @param hrws the hrws
	 */
	@Override
	public void cacheResult(List<HRW> hrws) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (hrws.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HRW hrw : hrws) {
			if (entityCache.getResult(HRWImpl.class, hrw.getPrimaryKey()) ==
					null) {

				cacheResult(hrw);
			}
		}
	}

	/**
	 * Clears the cache for all hrws.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HRWImpl.class);

		finderCache.clearCache(HRWImpl.class);
	}

	/**
	 * Clears the cache for the hrw.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HRW hrw) {
		entityCache.removeResult(HRWImpl.class, hrw);
	}

	@Override
	public void clearCache(List<HRW> hrws) {
		for (HRW hrw : hrws) {
			entityCache.removeResult(HRWImpl.class, hrw);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(HRWImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HRWImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new hrw with the primary key. Does not add the hrw to the database.
	 *
	 * @param id the primary key for the new hrw
	 * @return the new hrw
	 */
	@Override
	public HRW create(long id) {
		HRW hrw = new HRWImpl();

		hrw.setNew(true);
		hrw.setPrimaryKey(id);

		return hrw;
	}

	/**
	 * Removes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW remove(long id) throws NoSuchHRWException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW remove(Serializable primaryKey) throws NoSuchHRWException {
		Session session = null;

		try {
			session = openSession();

			HRW hrw = (HRW)session.get(HRWImpl.class, primaryKey);

			if (hrw == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHRWException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(hrw);
		}
		catch (NoSuchHRWException noSuchEntityException) {
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
	protected HRW removeImpl(HRW hrw) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hrw)) {
				hrw = (HRW)session.get(HRWImpl.class, hrw.getPrimaryKeyObj());
			}

			if (hrw != null) {
				session.delete(hrw);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (hrw != null) {
			clearCache(hrw);
		}

		return hrw;
	}

	@Override
	public HRW updateImpl(HRW hrw) {
		boolean isNew = hrw.isNew();

		if (!(hrw instanceof HRWModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(hrw.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(hrw);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in hrw proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HRW implementation " +
					hrw.getClass());
		}

		HRWModelImpl hrwModelImpl = (HRWModelImpl)hrw;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(hrw);
			}
			else {
				hrw = (HRW)session.merge(hrw);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HRWImpl.class, hrwModelImpl, false, true);

		if (isNew) {
			hrw.setNew(false);
		}

		hrw.resetOriginalValues();

		return hrw;
	}

	/**
	 * Returns the hrw with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hrw
	 * @return the hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHRWException {

		HRW hrw = fetchByPrimaryKey(primaryKey);

		if (hrw == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHRWException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return hrw;
	}

	/**
	 * Returns the hrw with the primary key or throws a <code>NoSuchHRWException</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	@Override
	public HRW findByPrimaryKey(long id) throws NoSuchHRWException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the hrw with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw, or <code>null</code> if a hrw with the primary key could not be found
	 */
	@Override
	public HRW fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the hrws.
	 *
	 * @return the hrws
	 */
	@Override
	public List<HRW> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of hrws
	 */
	@Override
	public List<HRW> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hrws
	 */
	@Override
	public List<HRW> findAll(
		int start, int end, OrderByComparator<HRW> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hrws
	 */
	@Override
	public List<HRW> findAll(
		int start, int end, OrderByComparator<HRW> orderByComparator,
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

		List<HRW> list = null;

		if (useFinderCache) {
			list = (List<HRW>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HRW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HRW;

				sql = sql.concat(HRWModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HRW>)QueryUtil.list(
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
	 * Removes all the hrws from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HRW hrw : findAll()) {
			remove(hrw);
		}
	}

	/**
	 * Returns the number of hrws.
	 *
	 * @return the number of hrws
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HRW);

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
		return _SQL_SELECT_HRW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HRWModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hrw persistence.
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

		_finderPathWithPaginationFindByComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComune",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"comune"}, true);

		_finderPathWithoutPaginationFindByComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByComune",
			new String[] {String.class.getName()}, new String[] {"comune"},
			true);

		_finderPathCountByComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByComune",
			new String[] {String.class.getName()}, new String[] {"comune"},
			false);

		HRWUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		HRWUtil.setPersistence(null);

		entityCache.removeCache(HRWImpl.class.getName());
	}

	@Override
	@Reference(
		target = DEWETRAPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DEWETRAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DEWETRAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_HRW = "SELECT hrw FROM HRW hrw";

	private static final String _SQL_SELECT_HRW_WHERE =
		"SELECT hrw FROM HRW hrw WHERE ";

	private static final String _SQL_COUNT_HRW =
		"SELECT COUNT(hrw) FROM HRW hrw";

	private static final String _SQL_COUNT_HRW_WHERE =
		"SELECT COUNT(hrw) FROM HRW hrw WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "hrw.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HRW exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No HRW exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HRWPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}