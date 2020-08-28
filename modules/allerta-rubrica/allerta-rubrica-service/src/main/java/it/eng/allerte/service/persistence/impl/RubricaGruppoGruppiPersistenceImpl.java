/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerte.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.model.impl.RubricaGruppoGruppiImpl;
import it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica gruppo gruppi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiPersistenceImpl
	extends BasePersistenceImpl<RubricaGruppoGruppi>
	implements RubricaGruppoGruppiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaGruppoGruppiUtil</code> to access the rubrica gruppo gruppi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaGruppoGruppiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByRubricaGruppoGruppoByPadre;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre;
	private FinderPath _finderPathCountByRubricaGruppoGruppoByPadre;

	/**
	 * Returns all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @return the matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE) {

		return findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end) {

		return findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre;
			finderArgs = new Object[] {FK_GRUPPO_PADRE};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByRubricaGruppoGruppoByPadre;
			finderArgs = new Object[] {
				FK_GRUPPO_PADRE, start, end, orderByComparator
			};
		}

		List<RubricaGruppoGruppi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppoGruppi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaGruppoGruppi rubricaGruppoGruppi : list) {
					if ((FK_GRUPPO_PADRE !=
							rubricaGruppoGruppi.getFK_GRUPPO_PADRE())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RUBRICAGRUPPOGRUPPI_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYPADRE_FK_GRUPPO_PADRE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaGruppoGruppiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_GRUPPO_PADRE);

				if (!pagination) {
					list = (List<RubricaGruppoGruppi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppoGruppi>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByPadre_First(
			long FK_GRUPPO_PADRE,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi =
			fetchByRubricaGruppoGruppoByPadre_First(
				FK_GRUPPO_PADRE, orderByComparator);

		if (rubricaGruppoGruppi != null) {
			return rubricaGruppoGruppi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_GRUPPO_PADRE=");
		msg.append(FK_GRUPPO_PADRE);

		msg.append("}");

		throw new NoSuchRubricaGruppoGruppiException(msg.toString());
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByPadre_First(
		long FK_GRUPPO_PADRE,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		List<RubricaGruppoGruppi> list = findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByPadre_Last(
			long FK_GRUPPO_PADRE,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi =
			fetchByRubricaGruppoGruppoByPadre_Last(
				FK_GRUPPO_PADRE, orderByComparator);

		if (rubricaGruppoGruppi != null) {
			return rubricaGruppoGruppi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_GRUPPO_PADRE=");
		msg.append(FK_GRUPPO_PADRE);

		msg.append("}");

		throw new NoSuchRubricaGruppoGruppiException(msg.toString());
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByPadre_Last(
		long FK_GRUPPO_PADRE,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		int count = countByRubricaGruppoGruppoByPadre(FK_GRUPPO_PADRE);

		if (count == 0) {
			return null;
		}

		List<RubricaGruppoGruppi> list = findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica gruppo gruppis before and after the current rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the current rubrica gruppo gruppi
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi[] findByRubricaGruppoGruppoByPadre_PrevAndNext(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK, long FK_GRUPPO_PADRE,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi = findByPrimaryKey(
			rubricaGruppoGruppiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoGruppi[] array = new RubricaGruppoGruppiImpl[3];

			array[0] = getByRubricaGruppoGruppoByPadre_PrevAndNext(
				session, rubricaGruppoGruppi, FK_GRUPPO_PADRE,
				orderByComparator, true);

			array[1] = rubricaGruppoGruppi;

			array[2] = getByRubricaGruppoGruppoByPadre_PrevAndNext(
				session, rubricaGruppoGruppi, FK_GRUPPO_PADRE,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaGruppoGruppi getByRubricaGruppoGruppoByPadre_PrevAndNext(
		Session session, RubricaGruppoGruppi rubricaGruppoGruppi,
		long FK_GRUPPO_PADRE,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RUBRICAGRUPPOGRUPPI_WHERE);

		query.append(
			_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYPADRE_FK_GRUPPO_PADRE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(RubricaGruppoGruppiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_GRUPPO_PADRE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaGruppoGruppi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaGruppoGruppi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63; from the database.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 */
	@Override
	public void removeByRubricaGruppoGruppoByPadre(long FK_GRUPPO_PADRE) {
		for (RubricaGruppoGruppi rubricaGruppoGruppi :
				findByRubricaGruppoGruppoByPadre(
					FK_GRUPPO_PADRE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaGruppoGruppi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @return the number of matching rubrica gruppo gruppis
	 */
	@Override
	public int countByRubricaGruppoGruppoByPadre(long FK_GRUPPO_PADRE) {
		FinderPath finderPath = _finderPathCountByRubricaGruppoGruppoByPadre;

		Object[] finderArgs = new Object[] {FK_GRUPPO_PADRE};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICAGRUPPOGRUPPI_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYPADRE_FK_GRUPPO_PADRE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_GRUPPO_PADRE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYPADRE_FK_GRUPPO_PADRE_2 =
			"rubricaGruppoGruppi.id.FK_GRUPPO_PADRE = ?";

	private FinderPath
		_finderPathWithPaginationFindByRubricaGruppoGruppoByFiglio;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio;
	private FinderPath _finderPathCountByRubricaGruppoGruppoByFiglio;

	/**
	 * Returns all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @return the matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO) {

		return findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO, int start, int end) {

		return findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio;
			finderArgs = new Object[] {FK_GRUPPO_FIGLIO};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByRubricaGruppoGruppoByFiglio;
			finderArgs = new Object[] {
				FK_GRUPPO_FIGLIO, start, end, orderByComparator
			};
		}

		List<RubricaGruppoGruppi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppoGruppi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaGruppoGruppi rubricaGruppoGruppi : list) {
					if ((FK_GRUPPO_FIGLIO !=
							rubricaGruppoGruppi.getFK_GRUPPO_FIGLIO())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RUBRICAGRUPPOGRUPPI_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYFIGLIO_FK_GRUPPO_FIGLIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaGruppoGruppiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_GRUPPO_FIGLIO);

				if (!pagination) {
					list = (List<RubricaGruppoGruppi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppoGruppi>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByFiglio_First(
			long FK_GRUPPO_FIGLIO,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi =
			fetchByRubricaGruppoGruppoByFiglio_First(
				FK_GRUPPO_FIGLIO, orderByComparator);

		if (rubricaGruppoGruppi != null) {
			return rubricaGruppoGruppi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_GRUPPO_FIGLIO=");
		msg.append(FK_GRUPPO_FIGLIO);

		msg.append("}");

		throw new NoSuchRubricaGruppoGruppiException(msg.toString());
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByFiglio_First(
		long FK_GRUPPO_FIGLIO,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		List<RubricaGruppoGruppi> list = findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByFiglio_Last(
			long FK_GRUPPO_FIGLIO,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi =
			fetchByRubricaGruppoGruppoByFiglio_Last(
				FK_GRUPPO_FIGLIO, orderByComparator);

		if (rubricaGruppoGruppi != null) {
			return rubricaGruppoGruppi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_GRUPPO_FIGLIO=");
		msg.append(FK_GRUPPO_FIGLIO);

		msg.append("}");

		throw new NoSuchRubricaGruppoGruppiException(msg.toString());
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	@Override
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByFiglio_Last(
		long FK_GRUPPO_FIGLIO,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		int count = countByRubricaGruppoGruppoByFiglio(FK_GRUPPO_FIGLIO);

		if (count == 0) {
			return null;
		}

		List<RubricaGruppoGruppi> list = findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica gruppo gruppis before and after the current rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the current rubrica gruppo gruppi
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi[] findByRubricaGruppoGruppoByFiglio_PrevAndNext(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK, long FK_GRUPPO_FIGLIO,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi = findByPrimaryKey(
			rubricaGruppoGruppiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoGruppi[] array = new RubricaGruppoGruppiImpl[3];

			array[0] = getByRubricaGruppoGruppoByFiglio_PrevAndNext(
				session, rubricaGruppoGruppi, FK_GRUPPO_FIGLIO,
				orderByComparator, true);

			array[1] = rubricaGruppoGruppi;

			array[2] = getByRubricaGruppoGruppoByFiglio_PrevAndNext(
				session, rubricaGruppoGruppi, FK_GRUPPO_FIGLIO,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaGruppoGruppi getByRubricaGruppoGruppoByFiglio_PrevAndNext(
		Session session, RubricaGruppoGruppi rubricaGruppoGruppi,
		long FK_GRUPPO_FIGLIO,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RUBRICAGRUPPOGRUPPI_WHERE);

		query.append(
			_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYFIGLIO_FK_GRUPPO_FIGLIO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(RubricaGruppoGruppiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_GRUPPO_FIGLIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaGruppoGruppi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaGruppoGruppi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63; from the database.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 */
	@Override
	public void removeByRubricaGruppoGruppoByFiglio(long FK_GRUPPO_FIGLIO) {
		for (RubricaGruppoGruppi rubricaGruppoGruppi :
				findByRubricaGruppoGruppoByFiglio(
					FK_GRUPPO_FIGLIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaGruppoGruppi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @return the number of matching rubrica gruppo gruppis
	 */
	@Override
	public int countByRubricaGruppoGruppoByFiglio(long FK_GRUPPO_FIGLIO) {
		FinderPath finderPath = _finderPathCountByRubricaGruppoGruppoByFiglio;

		Object[] finderArgs = new Object[] {FK_GRUPPO_FIGLIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICAGRUPPOGRUPPI_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYFIGLIO_FK_GRUPPO_FIGLIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_GRUPPO_FIGLIO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOGRUPPOBYFIGLIO_FK_GRUPPO_FIGLIO_2 =
			"rubricaGruppoGruppi.id.FK_GRUPPO_FIGLIO = ?";

	public RubricaGruppoGruppiPersistenceImpl() {
		setModelClass(RubricaGruppoGruppi.class);
	}

	/**
	 * Caches the rubrica gruppo gruppi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 */
	@Override
	public void cacheResult(RubricaGruppoGruppi rubricaGruppoGruppi) {
		entityCache.putResult(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiImpl.class, rubricaGruppoGruppi.getPrimaryKey(),
			rubricaGruppoGruppi);

		rubricaGruppoGruppi.resetOriginalValues();
	}

	/**
	 * Caches the rubrica gruppo gruppis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoGruppis the rubrica gruppo gruppis
	 */
	@Override
	public void cacheResult(List<RubricaGruppoGruppi> rubricaGruppoGruppis) {
		for (RubricaGruppoGruppi rubricaGruppoGruppi : rubricaGruppoGruppis) {
			if (entityCache.getResult(
					RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoGruppiImpl.class,
					rubricaGruppoGruppi.getPrimaryKey()) == null) {

				cacheResult(rubricaGruppoGruppi);
			}
			else {
				rubricaGruppoGruppi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica gruppo gruppis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaGruppoGruppiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica gruppo gruppi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaGruppoGruppi rubricaGruppoGruppi) {
		entityCache.removeResult(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiImpl.class, rubricaGruppoGruppi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaGruppoGruppi> rubricaGruppoGruppis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaGruppoGruppi rubricaGruppoGruppi : rubricaGruppoGruppis) {
			entityCache.removeResult(
				RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoGruppiImpl.class,
				rubricaGruppoGruppi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica gruppo gruppi with the primary key. Does not add the rubrica gruppo gruppi to the database.
	 *
	 * @param rubricaGruppoGruppiPK the primary key for the new rubrica gruppo gruppi
	 * @return the new rubrica gruppo gruppi
	 */
	@Override
	public RubricaGruppoGruppi create(
		RubricaGruppoGruppiPK rubricaGruppoGruppiPK) {

		RubricaGruppoGruppi rubricaGruppoGruppi = new RubricaGruppoGruppiImpl();

		rubricaGruppoGruppi.setNew(true);
		rubricaGruppoGruppi.setPrimaryKey(rubricaGruppoGruppiPK);

		return rubricaGruppoGruppi;
	}

	/**
	 * Removes the rubrica gruppo gruppi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi remove(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK)
		throws NoSuchRubricaGruppoGruppiException {

		return remove((Serializable)rubricaGruppoGruppiPK);
	}

	/**
	 * Removes the rubrica gruppo gruppi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi remove(Serializable primaryKey)
		throws NoSuchRubricaGruppoGruppiException {

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoGruppi rubricaGruppoGruppi =
				(RubricaGruppoGruppi)session.get(
					RubricaGruppoGruppiImpl.class, primaryKey);

			if (rubricaGruppoGruppi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaGruppoGruppiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaGruppoGruppi);
		}
		catch (NoSuchRubricaGruppoGruppiException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RubricaGruppoGruppi removeImpl(
		RubricaGruppoGruppi rubricaGruppoGruppi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaGruppoGruppi)) {
				rubricaGruppoGruppi = (RubricaGruppoGruppi)session.get(
					RubricaGruppoGruppiImpl.class,
					rubricaGruppoGruppi.getPrimaryKeyObj());
			}

			if (rubricaGruppoGruppi != null) {
				session.delete(rubricaGruppoGruppi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaGruppoGruppi != null) {
			clearCache(rubricaGruppoGruppi);
		}

		return rubricaGruppoGruppi;
	}

	@Override
	public RubricaGruppoGruppi updateImpl(
		RubricaGruppoGruppi rubricaGruppoGruppi) {

		boolean isNew = rubricaGruppoGruppi.isNew();

		if (!(rubricaGruppoGruppi instanceof RubricaGruppoGruppiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaGruppoGruppi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaGruppoGruppi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaGruppoGruppi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaGruppoGruppi implementation " +
					rubricaGruppoGruppi.getClass());
		}

		RubricaGruppoGruppiModelImpl rubricaGruppoGruppiModelImpl =
			(RubricaGruppoGruppiModelImpl)rubricaGruppoGruppi;

		Session session = null;

		try {
			session = openSession();

			if (rubricaGruppoGruppi.isNew()) {
				session.save(rubricaGruppoGruppi);

				rubricaGruppoGruppi.setNew(false);
			}
			else {
				rubricaGruppoGruppi = (RubricaGruppoGruppi)session.merge(
					rubricaGruppoGruppi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaGruppoGruppiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaGruppoGruppiModelImpl.getFK_GRUPPO_PADRE()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoGruppoByPadre, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre,
				args);

			args = new Object[] {
				rubricaGruppoGruppiModelImpl.getFK_GRUPPO_FIGLIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoGruppoByFiglio, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaGruppoGruppiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaGruppoGruppiModelImpl.getOriginalFK_GRUPPO_PADRE()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoGruppoByPadre, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre,
					args);

				args = new Object[] {
					rubricaGruppoGruppiModelImpl.getFK_GRUPPO_PADRE()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoGruppoByPadre, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre,
					args);
			}

			if ((rubricaGruppoGruppiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaGruppoGruppiModelImpl.getOriginalFK_GRUPPO_FIGLIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoGruppoByFiglio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio,
					args);

				args = new Object[] {
					rubricaGruppoGruppiModelImpl.getFK_GRUPPO_FIGLIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoGruppoByFiglio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio,
					args);
			}
		}

		entityCache.putResult(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiImpl.class, rubricaGruppoGruppi.getPrimaryKey(),
			rubricaGruppoGruppi, false);

		rubricaGruppoGruppi.resetOriginalValues();

		return rubricaGruppoGruppi;
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaGruppoGruppiException {

		RubricaGruppoGruppi rubricaGruppoGruppi = fetchByPrimaryKey(primaryKey);

		if (rubricaGruppoGruppi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaGruppoGruppiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaGruppoGruppi;
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or throws a <code>NoSuchRubricaGruppoGruppiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi findByPrimaryKey(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK)
		throws NoSuchRubricaGruppoGruppiException {

		return findByPrimaryKey((Serializable)rubricaGruppoGruppiPK);
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi, or <code>null</code> if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaGruppoGruppi rubricaGruppoGruppi =
			(RubricaGruppoGruppi)serializable;

		if (rubricaGruppoGruppi == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaGruppoGruppi = (RubricaGruppoGruppi)session.get(
					RubricaGruppoGruppiImpl.class, primaryKey);

				if (rubricaGruppoGruppi != null) {
					cacheResult(rubricaGruppoGruppi);
				}
				else {
					entityCache.putResult(
						RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
						RubricaGruppoGruppiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoGruppiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaGruppoGruppi;
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi, or <code>null</code> if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoGruppi fetchByPrimaryKey(
		RubricaGruppoGruppiPK rubricaGruppoGruppiPK) {

		return fetchByPrimaryKey((Serializable)rubricaGruppoGruppiPK);
	}

	@Override
	public Map<Serializable, RubricaGruppoGruppi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaGruppoGruppi> map =
			new HashMap<Serializable, RubricaGruppoGruppi>();

		for (Serializable primaryKey : primaryKeys) {
			RubricaGruppoGruppi rubricaGruppoGruppi = fetchByPrimaryKey(
				primaryKey);

			if (rubricaGruppoGruppi != null) {
				map.put(primaryKey, rubricaGruppoGruppi);
			}
		}

		return map;
	}

	/**
	 * Returns all the rubrica gruppo gruppis.
	 *
	 * @return the rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppo gruppis
	 */
	@Override
	public List<RubricaGruppoGruppi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RubricaGruppoGruppi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppoGruppi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICAGRUPPOGRUPPI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAGRUPPOGRUPPI;

				if (pagination) {
					sql = sql.concat(
						RubricaGruppoGruppiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaGruppoGruppi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppoGruppi>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the rubrica gruppo gruppis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaGruppoGruppi rubricaGruppoGruppi : findAll()) {
			remove(rubricaGruppoGruppi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo gruppis.
	 *
	 * @return the number of rubrica gruppo gruppis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICAGRUPPOGRUPPI);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaGruppoGruppiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica gruppo gruppi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoGruppiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoGruppiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRubricaGruppoGruppoByPadre =
			new FinderPath(
				RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoGruppiImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaGruppoGruppoByPadre",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByRubricaGruppoGruppoByPadre =
			new FinderPath(
				RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoGruppiImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaGruppoGruppoByPadre",
				new String[] {Long.class.getName()},
				RubricaGruppoGruppiModelImpl.FK_GRUPPO_PADRE_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoGruppoByPadre = new FinderPath(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoGruppoByPadre",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRubricaGruppoGruppoByFiglio =
			new FinderPath(
				RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoGruppiImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaGruppoGruppoByFiglio",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByRubricaGruppoGruppoByFiglio =
			new FinderPath(
				RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoGruppiImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaGruppoGruppoByFiglio",
				new String[] {Long.class.getName()},
				RubricaGruppoGruppiModelImpl.FK_GRUPPO_FIGLIO_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoGruppoByFiglio = new FinderPath(
			RubricaGruppoGruppiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoGruppiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoGruppoByFiglio",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaGruppoGruppiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICAGRUPPOGRUPPI =
		"SELECT rubricaGruppoGruppi FROM RubricaGruppoGruppi rubricaGruppoGruppi";

	private static final String _SQL_SELECT_RUBRICAGRUPPOGRUPPI_WHERE =
		"SELECT rubricaGruppoGruppi FROM RubricaGruppoGruppi rubricaGruppoGruppi WHERE ";

	private static final String _SQL_COUNT_RUBRICAGRUPPOGRUPPI =
		"SELECT COUNT(rubricaGruppoGruppi) FROM RubricaGruppoGruppi rubricaGruppoGruppi";

	private static final String _SQL_COUNT_RUBRICAGRUPPOGRUPPI_WHERE =
		"SELECT COUNT(rubricaGruppoGruppi) FROM RubricaGruppoGruppi rubricaGruppoGruppi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaGruppoGruppi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaGruppoGruppi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaGruppoGruppi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaGruppoGruppiPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"FK_GRUPPO_PADRE", "FK_GRUPPO_FIGLIO"});

}