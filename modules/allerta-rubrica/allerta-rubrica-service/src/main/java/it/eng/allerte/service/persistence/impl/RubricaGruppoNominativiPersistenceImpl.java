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

import it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.impl.RubricaGruppoNominativiImpl;
import it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the rubrica gruppo nominativi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiPersistenceImpl
	extends BasePersistenceImpl<RubricaGruppoNominativi>
	implements RubricaGruppoNominativiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaGruppoNominativiUtil</code> to access the rubrica gruppo nominativi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaGruppoNominativiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByRubricaGruppoRuoloByNominativo;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo;
	private FinderPath _finderPathCountByRubricaGruppoRuoloByNominativo;

	/**
	 * Returns all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO) {

		return findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO, int start, int end) {

		return findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo;
			finderArgs = new Object[] {FK_NOMINATIVO};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByRubricaGruppoRuoloByNominativo;
			finderArgs = new Object[] {
				FK_NOMINATIVO, start, end, orderByComparator
			};
		}

		List<RubricaGruppoNominativi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppoNominativi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaGruppoNominativi rubricaGruppoNominativi : list) {
					if ((FK_NOMINATIVO !=
							rubricaGruppoNominativi.getFK_NOMINATIVO())) {

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

			query.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_NOMINATIVO);

				if (!pagination) {
					list = (List<RubricaGruppoNominativi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppoNominativi>)QueryUtil.list(
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
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByNominativo_First(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByNominativo_First(
				FK_NOMINATIVO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_NOMINATIVO=");
		msg.append(FK_NOMINATIVO);

		msg.append("}");

		throw new NoSuchRubricaGruppoNominativiException(msg.toString());
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByNominativo_First(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		List<RubricaGruppoNominativi> list =
			findByRubricaGruppoRuoloByNominativo(
				FK_NOMINATIVO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByNominativo_Last(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByNominativo_Last(
				FK_NOMINATIVO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_NOMINATIVO=");
		msg.append(FK_NOMINATIVO);

		msg.append("}");

		throw new NoSuchRubricaGruppoNominativiException(msg.toString());
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByNominativo_Last(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		int count = countByRubricaGruppoRuoloByNominativo(FK_NOMINATIVO);

		if (count == 0) {
			return null;
		}

		List<RubricaGruppoNominativi> list =
			findByRubricaGruppoRuoloByNominativo(
				FK_NOMINATIVO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByNominativo_PrevAndNext(
				RubricaGruppoNominativiPK rubricaGruppoNominativiPK,
				long FK_NOMINATIVO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi = findByPrimaryKey(
			rubricaGruppoNominativiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoNominativi[] array =
				new RubricaGruppoNominativiImpl[3];

			array[0] = getByRubricaGruppoRuoloByNominativo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_NOMINATIVO,
				orderByComparator, true);

			array[1] = rubricaGruppoNominativi;

			array[2] = getByRubricaGruppoRuoloByNominativo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_NOMINATIVO,
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

	protected RubricaGruppoNominativi
		getByRubricaGruppoRuoloByNominativo_PrevAndNext(
			Session session, RubricaGruppoNominativi rubricaGruppoNominativi,
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

		query.append(
			_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2);

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
			query.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_NOMINATIVO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaGruppoNominativi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaGruppoNominativi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	@Override
	public void removeByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO) {
		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				findByRubricaGruppoRuoloByNominativo(
					FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaGruppoNominativi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	@Override
	public int countByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO) {
		FinderPath finderPath =
			_finderPathCountByRubricaGruppoRuoloByNominativo;

		Object[] finderArgs = new Object[] {FK_NOMINATIVO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICAGRUPPONOMINATIVI_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_NOMINATIVO);

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
		_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2 =
			"rubricaGruppoNominativi.id.FK_NOMINATIVO = ?";

	private FinderPath
		_finderPathWithPaginationFindByRubricaGruppoRuoloByGruppo;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo;
	private FinderPath _finderPathCountByRubricaGruppoRuoloByGruppo;

	/**
	 * Returns all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO) {

		return findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO, int start, int end) {

		return findByRubricaGruppoRuoloByGruppo(FK_GRUPPO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo;
			finderArgs = new Object[] {FK_GRUPPO};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByRubricaGruppoRuoloByGruppo;
			finderArgs = new Object[] {
				FK_GRUPPO, start, end, orderByComparator
			};
		}

		List<RubricaGruppoNominativi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppoNominativi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaGruppoNominativi rubricaGruppoNominativi : list) {
					if ((FK_GRUPPO != rubricaGruppoNominativi.getFK_GRUPPO())) {
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

			query.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

			query.append(_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_GRUPPO);

				if (!pagination) {
					list = (List<RubricaGruppoNominativi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppoNominativi>)QueryUtil.list(
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
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_First(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByGruppo_First(
				FK_GRUPPO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_GRUPPO=");
		msg.append(FK_GRUPPO);

		msg.append("}");

		throw new NoSuchRubricaGruppoNominativiException(msg.toString());
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByGruppo_First(
		long FK_GRUPPO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		List<RubricaGruppoNominativi> list = findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_Last(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByGruppo_Last(
				FK_GRUPPO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_GRUPPO=");
		msg.append(FK_GRUPPO);

		msg.append("}");

		throw new NoSuchRubricaGruppoNominativiException(msg.toString());
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByGruppo_Last(
		long FK_GRUPPO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		int count = countByRubricaGruppoRuoloByGruppo(FK_GRUPPO);

		if (count == 0) {
			return null;
		}

		List<RubricaGruppoNominativi> list = findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByGruppo_PrevAndNext(
				RubricaGruppoNominativiPK rubricaGruppoNominativiPK,
				long FK_GRUPPO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi = findByPrimaryKey(
			rubricaGruppoNominativiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoNominativi[] array =
				new RubricaGruppoNominativiImpl[3];

			array[0] = getByRubricaGruppoRuoloByGruppo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_GRUPPO, orderByComparator,
				true);

			array[1] = rubricaGruppoNominativi;

			array[2] = getByRubricaGruppoRuoloByGruppo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_GRUPPO, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaGruppoNominativi
		getByRubricaGruppoRuoloByGruppo_PrevAndNext(
			Session session, RubricaGruppoNominativi rubricaGruppoNominativi,
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

		query.append(_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2);

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
			query.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_GRUPPO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaGruppoNominativi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaGruppoNominativi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica gruppo nominativis where FK_GRUPPO = &#63; from the database.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 */
	@Override
	public void removeByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {
		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				findByRubricaGruppoRuoloByGruppo(
					FK_GRUPPO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rubricaGruppoNominativi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	@Override
	public int countByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {
		FinderPath finderPath = _finderPathCountByRubricaGruppoRuoloByGruppo;

		Object[] finderArgs = new Object[] {FK_GRUPPO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICAGRUPPONOMINATIVI_WHERE);

			query.append(_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_GRUPPO);

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
		_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2 =
			"rubricaGruppoNominativi.id.FK_GRUPPO = ?";

	public RubricaGruppoNominativiPersistenceImpl() {
		setModelClass(RubricaGruppoNominativi.class);
	}

	/**
	 * Caches the rubrica gruppo nominativi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 */
	@Override
	public void cacheResult(RubricaGruppoNominativi rubricaGruppoNominativi) {
		entityCache.putResult(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiImpl.class,
			rubricaGruppoNominativi.getPrimaryKey(), rubricaGruppoNominativi);

		rubricaGruppoNominativi.resetOriginalValues();
	}

	/**
	 * Caches the rubrica gruppo nominativis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativis the rubrica gruppo nominativis
	 */
	@Override
	public void cacheResult(
		List<RubricaGruppoNominativi> rubricaGruppoNominativis) {

		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				rubricaGruppoNominativis) {

			if (entityCache.getResult(
					RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoNominativiImpl.class,
					rubricaGruppoNominativi.getPrimaryKey()) == null) {

				cacheResult(rubricaGruppoNominativi);
			}
			else {
				rubricaGruppoNominativi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica gruppo nominativis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaGruppoNominativiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica gruppo nominativi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaGruppoNominativi rubricaGruppoNominativi) {
		entityCache.removeResult(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiImpl.class,
			rubricaGruppoNominativi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RubricaGruppoNominativi> rubricaGruppoNominativis) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				rubricaGruppoNominativis) {

			entityCache.removeResult(
				RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoNominativiImpl.class,
				rubricaGruppoNominativi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	@Override
	public RubricaGruppoNominativi create(
		RubricaGruppoNominativiPK rubricaGruppoNominativiPK) {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			new RubricaGruppoNominativiImpl();

		rubricaGruppoNominativi.setNew(true);
		rubricaGruppoNominativi.setPrimaryKey(rubricaGruppoNominativiPK);

		return rubricaGruppoNominativi;
	}

	/**
	 * Removes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi remove(
			RubricaGruppoNominativiPK rubricaGruppoNominativiPK)
		throws NoSuchRubricaGruppoNominativiException {

		return remove((Serializable)rubricaGruppoNominativiPK);
	}

	/**
	 * Removes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi remove(Serializable primaryKey)
		throws NoSuchRubricaGruppoNominativiException {

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoNominativi rubricaGruppoNominativi =
				(RubricaGruppoNominativi)session.get(
					RubricaGruppoNominativiImpl.class, primaryKey);

			if (rubricaGruppoNominativi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaGruppoNominativiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaGruppoNominativi);
		}
		catch (NoSuchRubricaGruppoNominativiException nsee) {
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
	protected RubricaGruppoNominativi removeImpl(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaGruppoNominativi)) {
				rubricaGruppoNominativi = (RubricaGruppoNominativi)session.get(
					RubricaGruppoNominativiImpl.class,
					rubricaGruppoNominativi.getPrimaryKeyObj());
			}

			if (rubricaGruppoNominativi != null) {
				session.delete(rubricaGruppoNominativi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaGruppoNominativi != null) {
			clearCache(rubricaGruppoNominativi);
		}

		return rubricaGruppoNominativi;
	}

	@Override
	public RubricaGruppoNominativi updateImpl(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		boolean isNew = rubricaGruppoNominativi.isNew();

		if (!(rubricaGruppoNominativi instanceof
				RubricaGruppoNominativiModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaGruppoNominativi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaGruppoNominativi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaGruppoNominativi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaGruppoNominativi implementation " +
					rubricaGruppoNominativi.getClass());
		}

		RubricaGruppoNominativiModelImpl rubricaGruppoNominativiModelImpl =
			(RubricaGruppoNominativiModelImpl)rubricaGruppoNominativi;

		Session session = null;

		try {
			session = openSession();

			if (rubricaGruppoNominativi.isNew()) {
				session.save(rubricaGruppoNominativi);

				rubricaGruppoNominativi.setNew(false);
			}
			else {
				rubricaGruppoNominativi =
					(RubricaGruppoNominativi)session.merge(
						rubricaGruppoNominativi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaGruppoNominativiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaGruppoNominativiModelImpl.getFK_NOMINATIVO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoRuoloByNominativo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo,
				args);

			args = new Object[] {
				rubricaGruppoNominativiModelImpl.getFK_GRUPPO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoRuoloByGruppo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaGruppoNominativiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaGruppoNominativiModelImpl.getOriginalFK_NOMINATIVO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoRuoloByNominativo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo,
					args);

				args = new Object[] {
					rubricaGruppoNominativiModelImpl.getFK_NOMINATIVO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoRuoloByNominativo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo,
					args);
			}

			if ((rubricaGruppoNominativiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaGruppoNominativiModelImpl.getOriginalFK_GRUPPO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoRuoloByGruppo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo,
					args);

				args = new Object[] {
					rubricaGruppoNominativiModelImpl.getFK_GRUPPO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaGruppoRuoloByGruppo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo,
					args);
			}
		}

		entityCache.putResult(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiImpl.class,
			rubricaGruppoNominativi.getPrimaryKey(), rubricaGruppoNominativi,
			false);

		rubricaGruppoNominativi.resetOriginalValues();

		return rubricaGruppoNominativi;
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi = fetchByPrimaryKey(
			primaryKey);

		if (rubricaGruppoNominativi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaGruppoNominativiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaGruppoNominativi;
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or throws a <code>NoSuchRubricaGruppoNominativiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByPrimaryKey(
			RubricaGruppoNominativiPK rubricaGruppoNominativiPK)
		throws NoSuchRubricaGruppoNominativiException {

		return findByPrimaryKey((Serializable)rubricaGruppoNominativiPK);
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi, or <code>null</code> if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaGruppoNominativi rubricaGruppoNominativi =
			(RubricaGruppoNominativi)serializable;

		if (rubricaGruppoNominativi == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaGruppoNominativi = (RubricaGruppoNominativi)session.get(
					RubricaGruppoNominativiImpl.class, primaryKey);

				if (rubricaGruppoNominativi != null) {
					cacheResult(rubricaGruppoNominativi);
				}
				else {
					entityCache.putResult(
						RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
						RubricaGruppoNominativiImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoNominativiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaGruppoNominativi;
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi, or <code>null</code> if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByPrimaryKey(
		RubricaGruppoNominativiPK rubricaGruppoNominativiPK) {

		return fetchByPrimaryKey((Serializable)rubricaGruppoNominativiPK);
	}

	@Override
	public Map<Serializable, RubricaGruppoNominativi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaGruppoNominativi> map =
			new HashMap<Serializable, RubricaGruppoNominativi>();

		for (Serializable primaryKey : primaryKeys) {
			RubricaGruppoNominativi rubricaGruppoNominativi = fetchByPrimaryKey(
				primaryKey);

			if (rubricaGruppoNominativi != null) {
				map.put(primaryKey, rubricaGruppoNominativi);
			}
		}

		return map;
	}

	/**
	 * Returns all the rubrica gruppo nominativis.
	 *
	 * @return the rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
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

		List<RubricaGruppoNominativi> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppoNominativi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAGRUPPONOMINATIVI;

				if (pagination) {
					sql = sql.concat(
						RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaGruppoNominativi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppoNominativi>)QueryUtil.list(
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
	 * Removes all the rubrica gruppo nominativis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaGruppoNominativi rubricaGruppoNominativi : findAll()) {
			remove(rubricaGruppoNominativi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_RUBRICAGRUPPONOMINATIVI);

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
		return RubricaGruppoNominativiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica gruppo nominativi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoNominativiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoNominativiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRubricaGruppoRuoloByNominativo =
			new FinderPath(
				RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoNominativiImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaGruppoRuoloByNominativo",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo =
			new FinderPath(
				RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoNominativiImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaGruppoRuoloByNominativo",
				new String[] {Long.class.getName()},
				RubricaGruppoNominativiModelImpl.FK_NOMINATIVO_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoRuoloByNominativo = new FinderPath(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoRuoloByNominativo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRubricaGruppoRuoloByGruppo =
			new FinderPath(
				RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoNominativiImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaGruppoRuoloByGruppo",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo =
			new FinderPath(
				RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED,
				RubricaGruppoNominativiImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaGruppoRuoloByGruppo",
				new String[] {Long.class.getName()},
				RubricaGruppoNominativiModelImpl.FK_GRUPPO_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoRuoloByGruppo = new FinderPath(
			RubricaGruppoNominativiModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoNominativiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoRuoloByGruppo",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaGruppoNominativiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICAGRUPPONOMINATIVI =
		"SELECT rubricaGruppoNominativi FROM RubricaGruppoNominativi rubricaGruppoNominativi";

	private static final String _SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE =
		"SELECT rubricaGruppoNominativi FROM RubricaGruppoNominativi rubricaGruppoNominativi WHERE ";

	private static final String _SQL_COUNT_RUBRICAGRUPPONOMINATIVI =
		"SELECT COUNT(rubricaGruppoNominativi) FROM RubricaGruppoNominativi rubricaGruppoNominativi";

	private static final String _SQL_COUNT_RUBRICAGRUPPONOMINATIVI_WHERE =
		"SELECT COUNT(rubricaGruppoNominativi) FROM RubricaGruppoNominativi rubricaGruppoNominativi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"rubricaGruppoNominativi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaGruppoNominativi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaGruppoNominativi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaGruppoNominativiPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"FK_GRUPPO", "FK_NOMINATIVO"});

}