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

import it.eng.allerte.exception.NoSuchRubricaSitoException;
import it.eng.allerte.model.RubricaSito;
import it.eng.allerte.model.RubricaSitoTable;
import it.eng.allerte.model.impl.RubricaSitoImpl;
import it.eng.allerte.model.impl.RubricaSitoModelImpl;
import it.eng.allerte.service.persistence.RubricaSitoPersistence;
import it.eng.allerte.service.persistence.RubricaSitoUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the rubrica sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaSitoPersistence.class)
public class RubricaSitoPersistenceImpl
	extends BasePersistenceImpl<RubricaSito> implements RubricaSitoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaSitoUtil</code> to access the rubrica sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaSitoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLiferaySite;
	private FinderPath _finderPathWithoutPaginationFindByLiferaySite;
	private FinderPath _finderPathCountByLiferaySite;

	/**
	 * Returns all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(long FK_LIFERAY_SITE) {
		return findByLiferaySite(
			FK_LIFERAY_SITE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end) {

		return findByLiferaySite(FK_LIFERAY_SITE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator) {

		return findByLiferaySite(
			FK_LIFERAY_SITE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica sitos
	 */
	@Override
	public List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLiferaySite;
				finderArgs = new Object[] {FK_LIFERAY_SITE};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLiferaySite;
			finderArgs = new Object[] {
				FK_LIFERAY_SITE, start, end, orderByComparator
			};
		}

		List<RubricaSito> list = null;

		if (useFinderCache) {
			list = (List<RubricaSito>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaSito rubricaSito : list) {
					if (FK_LIFERAY_SITE != rubricaSito.getFK_LIFERAY_SITE()) {
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

			sb.append(_SQL_SELECT_RUBRICASITO_WHERE);

			sb.append(_FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaSitoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_LIFERAY_SITE);

				list = (List<RubricaSito>)QueryUtil.list(
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
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito findByLiferaySite_First(
			long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = fetchByLiferaySite_First(
			FK_LIFERAY_SITE, orderByComparator);

		if (rubricaSito != null) {
			return rubricaSito;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_LIFERAY_SITE=");
		sb.append(FK_LIFERAY_SITE);

		sb.append("}");

		throw new NoSuchRubricaSitoException(sb.toString());
	}

	/**
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito fetchByLiferaySite_First(
		long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator) {

		List<RubricaSito> list = findByLiferaySite(
			FK_LIFERAY_SITE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito findByLiferaySite_Last(
			long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = fetchByLiferaySite_Last(
			FK_LIFERAY_SITE, orderByComparator);

		if (rubricaSito != null) {
			return rubricaSito;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_LIFERAY_SITE=");
		sb.append(FK_LIFERAY_SITE);

		sb.append("}");

		throw new NoSuchRubricaSitoException(sb.toString());
	}

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	@Override
	public RubricaSito fetchByLiferaySite_Last(
		long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator) {

		int count = countByLiferaySite(FK_LIFERAY_SITE);

		if (count == 0) {
			return null;
		}

		List<RubricaSito> list = findByLiferaySite(
			FK_LIFERAY_SITE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica sitos before and after the current rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param ID_SITO the primary key of the current rubrica sito
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito[] findByLiferaySite_PrevAndNext(
			long ID_SITO, long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = findByPrimaryKey(ID_SITO);

		Session session = null;

		try {
			session = openSession();

			RubricaSito[] array = new RubricaSitoImpl[3];

			array[0] = getByLiferaySite_PrevAndNext(
				session, rubricaSito, FK_LIFERAY_SITE, orderByComparator, true);

			array[1] = rubricaSito;

			array[2] = getByLiferaySite_PrevAndNext(
				session, rubricaSito, FK_LIFERAY_SITE, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaSito getByLiferaySite_PrevAndNext(
		Session session, RubricaSito rubricaSito, long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RUBRICASITO_WHERE);

		sb.append(_FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2);

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
			sb.append(RubricaSitoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_LIFERAY_SITE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaSito)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaSito> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica sitos where FK_LIFERAY_SITE = &#63; from the database.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 */
	@Override
	public void removeByLiferaySite(long FK_LIFERAY_SITE) {
		for (RubricaSito rubricaSito :
				findByLiferaySite(
					FK_LIFERAY_SITE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaSito);
		}
	}

	/**
	 * Returns the number of rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the number of matching rubrica sitos
	 */
	@Override
	public int countByLiferaySite(long FK_LIFERAY_SITE) {
		FinderPath finderPath = _finderPathCountByLiferaySite;

		Object[] finderArgs = new Object[] {FK_LIFERAY_SITE};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICASITO_WHERE);

			sb.append(_FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_LIFERAY_SITE);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_LIFERAYSITE_FK_LIFERAY_SITE_2 =
		"rubricaSito.FK_LIFERAY_SITE = ?";

	public RubricaSitoPersistenceImpl() {
		setModelClass(RubricaSito.class);

		setModelImplClass(RubricaSitoImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaSitoTable.INSTANCE);
	}

	/**
	 * Caches the rubrica sito in the entity cache if it is enabled.
	 *
	 * @param rubricaSito the rubrica sito
	 */
	@Override
	public void cacheResult(RubricaSito rubricaSito) {
		dummyEntityCache.putResult(
			RubricaSitoImpl.class, rubricaSito.getPrimaryKey(), rubricaSito);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaSitos the rubrica sitos
	 */
	@Override
	public void cacheResult(List<RubricaSito> rubricaSitos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaSitos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaSito rubricaSito : rubricaSitos) {
			if (dummyEntityCache.getResult(
					RubricaSitoImpl.class, rubricaSito.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaSito);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica sitos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaSitoImpl.class);

		dummyFinderCache.clearCache(RubricaSitoImpl.class);
	}

	/**
	 * Clears the cache for the rubrica sito.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaSito rubricaSito) {
		dummyEntityCache.removeResult(RubricaSitoImpl.class, rubricaSito);
	}

	@Override
	public void clearCache(List<RubricaSito> rubricaSitos) {
		for (RubricaSito rubricaSito : rubricaSitos) {
			dummyEntityCache.removeResult(RubricaSitoImpl.class, rubricaSito);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaSitoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(RubricaSitoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica sito with the primary key. Does not add the rubrica sito to the database.
	 *
	 * @param ID_SITO the primary key for the new rubrica sito
	 * @return the new rubrica sito
	 */
	@Override
	public RubricaSito create(long ID_SITO) {
		RubricaSito rubricaSito = new RubricaSitoImpl();

		rubricaSito.setNew(true);
		rubricaSito.setPrimaryKey(ID_SITO);

		return rubricaSito;
	}

	/**
	 * Removes the rubrica sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito that was removed
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito remove(long ID_SITO) throws NoSuchRubricaSitoException {
		return remove((Serializable)ID_SITO);
	}

	/**
	 * Removes the rubrica sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica sito
	 * @return the rubrica sito that was removed
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito remove(Serializable primaryKey)
		throws NoSuchRubricaSitoException {

		Session session = null;

		try {
			session = openSession();

			RubricaSito rubricaSito = (RubricaSito)session.get(
				RubricaSitoImpl.class, primaryKey);

			if (rubricaSito == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaSitoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaSito);
		}
		catch (NoSuchRubricaSitoException noSuchEntityException) {
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
	protected RubricaSito removeImpl(RubricaSito rubricaSito) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaSito)) {
				rubricaSito = (RubricaSito)session.get(
					RubricaSitoImpl.class, rubricaSito.getPrimaryKeyObj());
			}

			if (rubricaSito != null) {
				session.delete(rubricaSito);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaSito != null) {
			clearCache(rubricaSito);
		}

		return rubricaSito;
	}

	@Override
	public RubricaSito updateImpl(RubricaSito rubricaSito) {
		boolean isNew = rubricaSito.isNew();

		if (!(rubricaSito instanceof RubricaSitoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaSito.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(rubricaSito);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaSito proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaSito implementation " +
					rubricaSito.getClass());
		}

		RubricaSitoModelImpl rubricaSitoModelImpl =
			(RubricaSitoModelImpl)rubricaSito;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaSito);
			}
			else {
				rubricaSito = (RubricaSito)session.merge(rubricaSito);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaSitoImpl.class, rubricaSitoModelImpl, false, true);

		if (isNew) {
			rubricaSito.setNew(false);
		}

		rubricaSito.resetOriginalValues();

		return rubricaSito;
	}

	/**
	 * Returns the rubrica sito with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica sito
	 * @return the rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaSitoException {

		RubricaSito rubricaSito = fetchByPrimaryKey(primaryKey);

		if (rubricaSito == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaSitoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaSito;
	}

	/**
	 * Returns the rubrica sito with the primary key or throws a <code>NoSuchRubricaSitoException</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito findByPrimaryKey(long ID_SITO)
		throws NoSuchRubricaSitoException {

		return findByPrimaryKey((Serializable)ID_SITO);
	}

	/**
	 * Returns the rubrica sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito, or <code>null</code> if a rubrica sito with the primary key could not be found
	 */
	@Override
	public RubricaSito fetchByPrimaryKey(long ID_SITO) {
		return fetchByPrimaryKey((Serializable)ID_SITO);
	}

	/**
	 * Returns all the rubrica sitos.
	 *
	 * @return the rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll(
		int start, int end, OrderByComparator<RubricaSito> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica sitos
	 */
	@Override
	public List<RubricaSito> findAll(
		int start, int end, OrderByComparator<RubricaSito> orderByComparator,
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

		List<RubricaSito> list = null;

		if (useFinderCache) {
			list = (List<RubricaSito>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICASITO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICASITO;

				sql = sql.concat(RubricaSitoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaSito>)QueryUtil.list(
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
	 * Removes all the rubrica sitos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaSito rubricaSito : findAll()) {
			remove(rubricaSito);
		}
	}

	/**
	 * Returns the number of rubrica sitos.
	 *
	 * @return the number of rubrica sitos
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICASITO);

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
		return "ID_SITO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICASITO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaSitoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica sito persistence.
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

		_finderPathWithPaginationFindByLiferaySite = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLiferaySite",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"FK_LIFERAY_SITE"}, true);

		_finderPathWithoutPaginationFindByLiferaySite = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLiferaySite",
			new String[] {Long.class.getName()},
			new String[] {"FK_LIFERAY_SITE"}, true);

		_finderPathCountByLiferaySite = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLiferaySite",
			new String[] {Long.class.getName()},
			new String[] {"FK_LIFERAY_SITE"}, false);

		RubricaSitoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaSitoUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaSitoImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICASITO =
		"SELECT rubricaSito FROM RubricaSito rubricaSito";

	private static final String _SQL_SELECT_RUBRICASITO_WHERE =
		"SELECT rubricaSito FROM RubricaSito rubricaSito WHERE ";

	private static final String _SQL_COUNT_RUBRICASITO =
		"SELECT COUNT(rubricaSito) FROM RubricaSito rubricaSito";

	private static final String _SQL_COUNT_RUBRICASITO_WHERE =
		"SELECT COUNT(rubricaSito) FROM RubricaSito rubricaSito WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaSito.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaSito exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaSito exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaSitoPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}