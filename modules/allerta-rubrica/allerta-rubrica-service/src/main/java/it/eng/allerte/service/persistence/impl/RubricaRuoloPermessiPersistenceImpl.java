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
import com.liferay.portal.kernel.util.SetUtil;

import it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException;
import it.eng.allerte.model.RubricaRuoloPermessi;
import it.eng.allerte.model.RubricaRuoloPermessiTable;
import it.eng.allerte.model.impl.RubricaRuoloPermessiImpl;
import it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPK;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPersistence;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiUtil;
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
 * The persistence implementation for the rubrica ruolo permessi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaRuoloPermessiPersistence.class)
public class RubricaRuoloPermessiPersistenceImpl
	extends BasePersistenceImpl<RubricaRuoloPermessi>
	implements RubricaRuoloPermessiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaRuoloPermessiUtil</code> to access the rubrica ruolo permessi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaRuoloPermessiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRubricaPermessiByRuolo;
	private FinderPath _finderPathWithoutPaginationFindByRubricaPermessiByRuolo;
	private FinderPath _finderPathCountByRubricaPermessiByRuolo;

	/**
	 * Returns all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO) {

		return findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end) {

		return findByRubricaPermessiByRuolo(FK_ID_RUOLO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaPermessiByRuolo;
				finderArgs = new Object[] {FK_ID_RUOLO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRubricaPermessiByRuolo;
			finderArgs = new Object[] {
				FK_ID_RUOLO, start, end, orderByComparator
			};
		}

		List<RubricaRuoloPermessi> list = null;

		if (useFinderCache) {
			list = (List<RubricaRuoloPermessi>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaRuoloPermessi rubricaRuoloPermessi : list) {
					if (FK_ID_RUOLO != rubricaRuoloPermessi.getFK_ID_RUOLO()) {
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

			sb.append(_SQL_SELECT_RUBRICARUOLOPERMESSI_WHERE);

			sb.append(_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaRuoloPermessiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_ID_RUOLO);

				list = (List<RubricaRuoloPermessi>)QueryUtil.list(
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
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByRubricaPermessiByRuolo_First(
			long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi =
			fetchByRubricaPermessiByRuolo_First(FK_ID_RUOLO, orderByComparator);

		if (rubricaRuoloPermessi != null) {
			return rubricaRuoloPermessi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_ID_RUOLO=");
		sb.append(FK_ID_RUOLO);

		sb.append("}");

		throw new NoSuchRubricaRuoloPermessiException(sb.toString());
	}

	/**
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_First(
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		List<RubricaRuoloPermessi> list = findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByRubricaPermessiByRuolo_Last(
			long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi =
			fetchByRubricaPermessiByRuolo_Last(FK_ID_RUOLO, orderByComparator);

		if (rubricaRuoloPermessi != null) {
			return rubricaRuoloPermessi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_ID_RUOLO=");
		sb.append(FK_ID_RUOLO);

		sb.append("}");

		throw new NoSuchRubricaRuoloPermessiException(sb.toString());
	}

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_Last(
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		int count = countByRubricaPermessiByRuolo(FK_ID_RUOLO);

		if (count == 0) {
			return null;
		}

		List<RubricaRuoloPermessi> list = findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica ruolo permessis before and after the current rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the current rubrica ruolo permessi
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi[] findByRubricaPermessiByRuolo_PrevAndNext(
			RubricaRuoloPermessiPK rubricaRuoloPermessiPK, long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi = findByPrimaryKey(
			rubricaRuoloPermessiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaRuoloPermessi[] array = new RubricaRuoloPermessiImpl[3];

			array[0] = getByRubricaPermessiByRuolo_PrevAndNext(
				session, rubricaRuoloPermessi, FK_ID_RUOLO, orderByComparator,
				true);

			array[1] = rubricaRuoloPermessi;

			array[2] = getByRubricaPermessiByRuolo_PrevAndNext(
				session, rubricaRuoloPermessi, FK_ID_RUOLO, orderByComparator,
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

	protected RubricaRuoloPermessi getByRubricaPermessiByRuolo_PrevAndNext(
		Session session, RubricaRuoloPermessi rubricaRuoloPermessi,
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RUBRICARUOLOPERMESSI_WHERE);

		sb.append(_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2);

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
			sb.append(RubricaRuoloPermessiModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_ID_RUOLO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaRuoloPermessi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaRuoloPermessi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica ruolo permessis where FK_ID_RUOLO = &#63; from the database.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 */
	@Override
	public void removeByRubricaPermessiByRuolo(long FK_ID_RUOLO) {
		for (RubricaRuoloPermessi rubricaRuoloPermessi :
				findByRubricaPermessiByRuolo(
					FK_ID_RUOLO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rubricaRuoloPermessi);
		}
	}

	/**
	 * Returns the number of rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the number of matching rubrica ruolo permessis
	 */
	@Override
	public int countByRubricaPermessiByRuolo(long FK_ID_RUOLO) {
		FinderPath finderPath = _finderPathCountByRubricaPermessiByRuolo;

		Object[] finderArgs = new Object[] {FK_ID_RUOLO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICARUOLOPERMESSI_WHERE);

			sb.append(_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_ID_RUOLO);

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

	private static final String
		_FINDER_COLUMN_RUBRICAPERMESSIBYRUOLO_FK_ID_RUOLO_2 =
			"rubricaRuoloPermessi.id.FK_ID_RUOLO = ?";

	public RubricaRuoloPermessiPersistenceImpl() {
		setModelClass(RubricaRuoloPermessi.class);

		setModelImplClass(RubricaRuoloPermessiImpl.class);
		setModelPKClass(RubricaRuoloPermessiPK.class);

		setTable(RubricaRuoloPermessiTable.INSTANCE);
	}

	/**
	 * Caches the rubrica ruolo permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 */
	@Override
	public void cacheResult(RubricaRuoloPermessi rubricaRuoloPermessi) {
		dummyEntityCache.putResult(
			RubricaRuoloPermessiImpl.class,
			rubricaRuoloPermessi.getPrimaryKey(), rubricaRuoloPermessi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica ruolo permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessis the rubrica ruolo permessis
	 */
	@Override
	public void cacheResult(List<RubricaRuoloPermessi> rubricaRuoloPermessis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaRuoloPermessis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaRuoloPermessi rubricaRuoloPermessi :
				rubricaRuoloPermessis) {

			if (dummyEntityCache.getResult(
					RubricaRuoloPermessiImpl.class,
					rubricaRuoloPermessi.getPrimaryKey()) == null) {

				cacheResult(rubricaRuoloPermessi);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica ruolo permessis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaRuoloPermessiImpl.class);

		dummyFinderCache.clearCache(RubricaRuoloPermessiImpl.class);
	}

	/**
	 * Clears the cache for the rubrica ruolo permessi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaRuoloPermessi rubricaRuoloPermessi) {
		dummyEntityCache.removeResult(
			RubricaRuoloPermessiImpl.class, rubricaRuoloPermessi);
	}

	@Override
	public void clearCache(List<RubricaRuoloPermessi> rubricaRuoloPermessis) {
		for (RubricaRuoloPermessi rubricaRuoloPermessi :
				rubricaRuoloPermessis) {

			dummyEntityCache.removeResult(
				RubricaRuoloPermessiImpl.class, rubricaRuoloPermessi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaRuoloPermessiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaRuoloPermessiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica ruolo permessi with the primary key. Does not add the rubrica ruolo permessi to the database.
	 *
	 * @param rubricaRuoloPermessiPK the primary key for the new rubrica ruolo permessi
	 * @return the new rubrica ruolo permessi
	 */
	@Override
	public RubricaRuoloPermessi create(
		RubricaRuoloPermessiPK rubricaRuoloPermessiPK) {

		RubricaRuoloPermessi rubricaRuoloPermessi =
			new RubricaRuoloPermessiImpl();

		rubricaRuoloPermessi.setNew(true);
		rubricaRuoloPermessi.setPrimaryKey(rubricaRuoloPermessiPK);

		return rubricaRuoloPermessi;
	}

	/**
	 * Removes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi remove(
			RubricaRuoloPermessiPK rubricaRuoloPermessiPK)
		throws NoSuchRubricaRuoloPermessiException {

		return remove((Serializable)rubricaRuoloPermessiPK);
	}

	/**
	 * Removes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi remove(Serializable primaryKey)
		throws NoSuchRubricaRuoloPermessiException {

		Session session = null;

		try {
			session = openSession();

			RubricaRuoloPermessi rubricaRuoloPermessi =
				(RubricaRuoloPermessi)session.get(
					RubricaRuoloPermessiImpl.class, primaryKey);

			if (rubricaRuoloPermessi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaRuoloPermessiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaRuoloPermessi);
		}
		catch (NoSuchRubricaRuoloPermessiException noSuchEntityException) {
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
	protected RubricaRuoloPermessi removeImpl(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaRuoloPermessi)) {
				rubricaRuoloPermessi = (RubricaRuoloPermessi)session.get(
					RubricaRuoloPermessiImpl.class,
					rubricaRuoloPermessi.getPrimaryKeyObj());
			}

			if (rubricaRuoloPermessi != null) {
				session.delete(rubricaRuoloPermessi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaRuoloPermessi != null) {
			clearCache(rubricaRuoloPermessi);
		}

		return rubricaRuoloPermessi;
	}

	@Override
	public RubricaRuoloPermessi updateImpl(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		boolean isNew = rubricaRuoloPermessi.isNew();

		if (!(rubricaRuoloPermessi instanceof RubricaRuoloPermessiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaRuoloPermessi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaRuoloPermessi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaRuoloPermessi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaRuoloPermessi implementation " +
					rubricaRuoloPermessi.getClass());
		}

		RubricaRuoloPermessiModelImpl rubricaRuoloPermessiModelImpl =
			(RubricaRuoloPermessiModelImpl)rubricaRuoloPermessi;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaRuoloPermessi);
			}
			else {
				rubricaRuoloPermessi = (RubricaRuoloPermessi)session.merge(
					rubricaRuoloPermessi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaRuoloPermessiImpl.class, rubricaRuoloPermessiModelImpl,
			false, true);

		if (isNew) {
			rubricaRuoloPermessi.setNew(false);
		}

		rubricaRuoloPermessi.resetOriginalValues();

		return rubricaRuoloPermessi;
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaRuoloPermessiException {

		RubricaRuoloPermessi rubricaRuoloPermessi = fetchByPrimaryKey(
			primaryKey);

		if (rubricaRuoloPermessi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaRuoloPermessiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaRuoloPermessi;
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or throws a <code>NoSuchRubricaRuoloPermessiException</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi findByPrimaryKey(
			RubricaRuoloPermessiPK rubricaRuoloPermessiPK)
		throws NoSuchRubricaRuoloPermessiException {

		return findByPrimaryKey((Serializable)rubricaRuoloPermessiPK);
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi, or <code>null</code> if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public RubricaRuoloPermessi fetchByPrimaryKey(
		RubricaRuoloPermessiPK rubricaRuoloPermessiPK) {

		return fetchByPrimaryKey((Serializable)rubricaRuoloPermessiPK);
	}

	/**
	 * Returns all the rubrica ruolo permessis.
	 *
	 * @return the rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica ruolo permessis
	 */
	@Override
	public List<RubricaRuoloPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
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

		List<RubricaRuoloPermessi> list = null;

		if (useFinderCache) {
			list = (List<RubricaRuoloPermessi>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICARUOLOPERMESSI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICARUOLOPERMESSI;

				sql = sql.concat(RubricaRuoloPermessiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaRuoloPermessi>)QueryUtil.list(
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
	 * Removes all the rubrica ruolo permessis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaRuoloPermessi rubricaRuoloPermessi : findAll()) {
			remove(rubricaRuoloPermessi);
		}
	}

	/**
	 * Returns the number of rubrica ruolo permessis.
	 *
	 * @return the number of rubrica ruolo permessis
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_RUBRICARUOLOPERMESSI);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "rubricaRuoloPermessiPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICARUOLOPERMESSI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaRuoloPermessiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica ruolo permessi persistence.
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

		_finderPathWithPaginationFindByRubricaPermessiByRuolo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRubricaPermessiByRuolo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"FK_ID_RUOLO"}, true);

		_finderPathWithoutPaginationFindByRubricaPermessiByRuolo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaPermessiByRuolo",
				new String[] {Long.class.getName()},
				new String[] {"FK_ID_RUOLO"}, true);

		_finderPathCountByRubricaPermessiByRuolo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaPermessiByRuolo",
			new String[] {Long.class.getName()}, new String[] {"FK_ID_RUOLO"},
			false);

		RubricaRuoloPermessiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaRuoloPermessiUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaRuoloPermessiImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICARUOLOPERMESSI =
		"SELECT rubricaRuoloPermessi FROM RubricaRuoloPermessi rubricaRuoloPermessi";

	private static final String _SQL_SELECT_RUBRICARUOLOPERMESSI_WHERE =
		"SELECT rubricaRuoloPermessi FROM RubricaRuoloPermessi rubricaRuoloPermessi WHERE ";

	private static final String _SQL_COUNT_RUBRICARUOLOPERMESSI =
		"SELECT COUNT(rubricaRuoloPermessi) FROM RubricaRuoloPermessi rubricaRuoloPermessi";

	private static final String _SQL_COUNT_RUBRICARUOLOPERMESSI_WHERE =
		"SELECT COUNT(rubricaRuoloPermessi) FROM RubricaRuoloPermessi rubricaRuoloPermessi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"rubricaRuoloPermessi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaRuoloPermessi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaRuoloPermessi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaRuoloPermessiPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"FK_ID_RUOLO", "FK_ID_PERMESSO"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}