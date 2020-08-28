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

package it.eng.bollettino.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.bollettino.exception.NoSuchPluviometroException;
import it.eng.bollettino.model.Pluviometro;
import it.eng.bollettino.model.impl.PluviometroImpl;
import it.eng.bollettino.model.impl.PluviometroModelImpl;
import it.eng.bollettino.service.persistence.PluviometroPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the pluviometro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class PluviometroPersistenceImpl
	extends BasePersistenceImpl<Pluviometro> implements PluviometroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PluviometroUtil</code> to access the pluviometro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PluviometroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByNomeGruppo;
	private FinderPath _finderPathWithoutPaginationFindByNomeGruppo;
	private FinderPath _finderPathCountByNomeGruppo;

	/**
	 * Returns all the pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(String nomeGruppo) {
		return findByNomeGruppo(
			nomeGruppo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end) {

		return findByNomeGruppo(nomeGruppo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return findByNomeGruppo(
			nomeGruppo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator,
		boolean retrieveFromCache) {

		nomeGruppo = Objects.toString(nomeGruppo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNomeGruppo;
			finderArgs = new Object[] {nomeGruppo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNomeGruppo;
			finderArgs = new Object[] {
				nomeGruppo, start, end, orderByComparator
			};
		}

		List<Pluviometro> list = null;

		if (retrieveFromCache) {
			list = (List<Pluviometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Pluviometro pluviometro : list) {
					if (!nomeGruppo.equals(pluviometro.getNomeGruppo())) {
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

			query.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

			boolean bindNomeGruppo = false;

			if (nomeGruppo.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3);
			}
			else {
				bindNomeGruppo = true;

				query.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PluviometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeGruppo) {
					qPos.add(nomeGruppo);
				}

				if (!pagination) {
					list = (List<Pluviometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Pluviometro>)QueryUtil.list(
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
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeGruppo_First(
			String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeGruppo_First(
			nomeGruppo, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeGruppo=");
		msg.append(nomeGruppo);

		msg.append("}");

		throw new NoSuchPluviometroException(msg.toString());
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeGruppo_First(
		String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator) {

		List<Pluviometro> list = findByNomeGruppo(
			nomeGruppo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeGruppo_Last(
			String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeGruppo_Last(
			nomeGruppo, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeGruppo=");
		msg.append(nomeGruppo);

		msg.append("}");

		throw new NoSuchPluviometroException(msg.toString());
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeGruppo_Last(
		String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator) {

		int count = countByNomeGruppo(nomeGruppo);

		if (count == 0) {
			return null;
		}

		List<Pluviometro> list = findByNomeGruppo(
			nomeGruppo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro[] findByNomeGruppo_PrevAndNext(
			String stazioneId, String nomeGruppo,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		nomeGruppo = Objects.toString(nomeGruppo, "");

		Pluviometro pluviometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Pluviometro[] array = new PluviometroImpl[3];

			array[0] = getByNomeGruppo_PrevAndNext(
				session, pluviometro, nomeGruppo, orderByComparator, true);

			array[1] = pluviometro;

			array[2] = getByNomeGruppo_PrevAndNext(
				session, pluviometro, nomeGruppo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pluviometro getByNomeGruppo_PrevAndNext(
		Session session, Pluviometro pluviometro, String nomeGruppo,
		OrderByComparator<Pluviometro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

		boolean bindNomeGruppo = false;

		if (nomeGruppo.isEmpty()) {
			query.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3);
		}
		else {
			bindNomeGruppo = true;

			query.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2);
		}

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
			query.append(PluviometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNomeGruppo) {
			qPos.add(nomeGruppo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pluviometro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Pluviometro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pluviometros where nomeGruppo = &#63; from the database.
	 *
	 * @param nomeGruppo the nome gruppo
	 */
	@Override
	public void removeByNomeGruppo(String nomeGruppo) {
		for (Pluviometro pluviometro :
				findByNomeGruppo(
					nomeGruppo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pluviometro);
		}
	}

	/**
	 * Returns the number of pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the number of matching pluviometros
	 */
	@Override
	public int countByNomeGruppo(String nomeGruppo) {
		nomeGruppo = Objects.toString(nomeGruppo, "");

		FinderPath finderPath = _finderPathCountByNomeGruppo;

		Object[] finderArgs = new Object[] {nomeGruppo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PLUVIOMETRO_WHERE);

			boolean bindNomeGruppo = false;

			if (nomeGruppo.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3);
			}
			else {
				bindNomeGruppo = true;

				query.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeGruppo) {
					qPos.add(nomeGruppo);
				}

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

	private static final String _FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2 =
		"pluviometro.nomeGruppo = ?";

	private static final String _FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3 =
		"(pluviometro.nomeGruppo IS NULL OR pluviometro.nomeGruppo = '')";

	private FinderPath _finderPathWithPaginationFindByNomeRubrica;
	private FinderPath _finderPathWithoutPaginationFindByNomeRubrica;
	private FinderPath _finderPathCountByNomeRubrica;

	/**
	 * Returns all the pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(String nomeRubrica) {
		return findByNomeRubrica(
			nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end) {

		return findByNomeRubrica(nomeRubrica, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator,
		boolean retrieveFromCache) {

		nomeRubrica = Objects.toString(nomeRubrica, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNomeRubrica;
			finderArgs = new Object[] {nomeRubrica};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNomeRubrica;
			finderArgs = new Object[] {
				nomeRubrica, start, end, orderByComparator
			};
		}

		List<Pluviometro> list = null;

		if (retrieveFromCache) {
			list = (List<Pluviometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Pluviometro pluviometro : list) {
					if (!nomeRubrica.equals(pluviometro.getNomeRubrica())) {
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

			query.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

			boolean bindNomeRubrica = false;

			if (nomeRubrica.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3);
			}
			else {
				bindNomeRubrica = true;

				query.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PluviometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeRubrica) {
					qPos.add(nomeRubrica);
				}

				if (!pagination) {
					list = (List<Pluviometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Pluviometro>)QueryUtil.list(
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
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeRubrica_First(
			String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeRubrica_First(
			nomeRubrica, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeRubrica=");
		msg.append(nomeRubrica);

		msg.append("}");

		throw new NoSuchPluviometroException(msg.toString());
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeRubrica_First(
		String nomeRubrica, OrderByComparator<Pluviometro> orderByComparator) {

		List<Pluviometro> list = findByNomeRubrica(
			nomeRubrica, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeRubrica_Last(
			String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeRubrica_Last(
			nomeRubrica, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeRubrica=");
		msg.append(nomeRubrica);

		msg.append("}");

		throw new NoSuchPluviometroException(msg.toString());
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeRubrica_Last(
		String nomeRubrica, OrderByComparator<Pluviometro> orderByComparator) {

		int count = countByNomeRubrica(nomeRubrica);

		if (count == 0) {
			return null;
		}

		List<Pluviometro> list = findByNomeRubrica(
			nomeRubrica, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		nomeRubrica = Objects.toString(nomeRubrica, "");

		Pluviometro pluviometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Pluviometro[] array = new PluviometroImpl[3];

			array[0] = getByNomeRubrica_PrevAndNext(
				session, pluviometro, nomeRubrica, orderByComparator, true);

			array[1] = pluviometro;

			array[2] = getByNomeRubrica_PrevAndNext(
				session, pluviometro, nomeRubrica, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pluviometro getByNomeRubrica_PrevAndNext(
		Session session, Pluviometro pluviometro, String nomeRubrica,
		OrderByComparator<Pluviometro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

		boolean bindNomeRubrica = false;

		if (nomeRubrica.isEmpty()) {
			query.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3);
		}
		else {
			bindNomeRubrica = true;

			query.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2);
		}

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
			query.append(PluviometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNomeRubrica) {
			qPos.add(nomeRubrica);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pluviometro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Pluviometro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pluviometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	@Override
	public void removeByNomeRubrica(String nomeRubrica) {
		for (Pluviometro pluviometro :
				findByNomeRubrica(
					nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pluviometro);
		}
	}

	/**
	 * Returns the number of pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching pluviometros
	 */
	@Override
	public int countByNomeRubrica(String nomeRubrica) {
		nomeRubrica = Objects.toString(nomeRubrica, "");

		FinderPath finderPath = _finderPathCountByNomeRubrica;

		Object[] finderArgs = new Object[] {nomeRubrica};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PLUVIOMETRO_WHERE);

			boolean bindNomeRubrica = false;

			if (nomeRubrica.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3);
			}
			else {
				bindNomeRubrica = true;

				query.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeRubrica) {
					qPos.add(nomeRubrica);
				}

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

	private static final String _FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2 =
		"pluviometro.nomeRubrica = ?";

	private static final String _FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3 =
		"(pluviometro.nomeRubrica IS NULL OR pluviometro.nomeRubrica = '')";

	public PluviometroPersistenceImpl() {
		setModelClass(Pluviometro.class);
	}

	/**
	 * Caches the pluviometro in the entity cache if it is enabled.
	 *
	 * @param pluviometro the pluviometro
	 */
	@Override
	public void cacheResult(Pluviometro pluviometro) {
		entityCache.putResult(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED, PluviometroImpl.class,
			pluviometro.getPrimaryKey(), pluviometro);

		pluviometro.resetOriginalValues();
	}

	/**
	 * Caches the pluviometros in the entity cache if it is enabled.
	 *
	 * @param pluviometros the pluviometros
	 */
	@Override
	public void cacheResult(List<Pluviometro> pluviometros) {
		for (Pluviometro pluviometro : pluviometros) {
			if (entityCache.getResult(
					PluviometroModelImpl.ENTITY_CACHE_ENABLED,
					PluviometroImpl.class, pluviometro.getPrimaryKey()) ==
						null) {

				cacheResult(pluviometro);
			}
			else {
				pluviometro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pluviometros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PluviometroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pluviometro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pluviometro pluviometro) {
		entityCache.removeResult(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED, PluviometroImpl.class,
			pluviometro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Pluviometro> pluviometros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Pluviometro pluviometro : pluviometros) {
			entityCache.removeResult(
				PluviometroModelImpl.ENTITY_CACHE_ENABLED,
				PluviometroImpl.class, pluviometro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pluviometro with the primary key. Does not add the pluviometro to the database.
	 *
	 * @param stazioneId the primary key for the new pluviometro
	 * @return the new pluviometro
	 */
	@Override
	public Pluviometro create(String stazioneId) {
		Pluviometro pluviometro = new PluviometroImpl();

		pluviometro.setNew(true);
		pluviometro.setPrimaryKey(stazioneId);

		return pluviometro;
	}

	/**
	 * Removes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro remove(String stazioneId)
		throws NoSuchPluviometroException {

		return remove((Serializable)stazioneId);
	}

	/**
	 * Removes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro remove(Serializable primaryKey)
		throws NoSuchPluviometroException {

		Session session = null;

		try {
			session = openSession();

			Pluviometro pluviometro = (Pluviometro)session.get(
				PluviometroImpl.class, primaryKey);

			if (pluviometro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPluviometroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pluviometro);
		}
		catch (NoSuchPluviometroException nsee) {
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
	protected Pluviometro removeImpl(Pluviometro pluviometro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pluviometro)) {
				pluviometro = (Pluviometro)session.get(
					PluviometroImpl.class, pluviometro.getPrimaryKeyObj());
			}

			if (pluviometro != null) {
				session.delete(pluviometro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pluviometro != null) {
			clearCache(pluviometro);
		}

		return pluviometro;
	}

	@Override
	public Pluviometro updateImpl(Pluviometro pluviometro) {
		boolean isNew = pluviometro.isNew();

		if (!(pluviometro instanceof PluviometroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pluviometro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pluviometro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pluviometro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Pluviometro implementation " +
					pluviometro.getClass());
		}

		PluviometroModelImpl pluviometroModelImpl =
			(PluviometroModelImpl)pluviometro;

		Session session = null;

		try {
			session = openSession();

			if (pluviometro.isNew()) {
				session.save(pluviometro);

				pluviometro.setNew(false);
			}
			else {
				pluviometro = (Pluviometro)session.merge(pluviometro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PluviometroModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {pluviometroModelImpl.getNomeGruppo()};

			finderCache.removeResult(_finderPathCountByNomeGruppo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNomeGruppo, args);

			args = new Object[] {pluviometroModelImpl.getNomeRubrica()};

			finderCache.removeResult(_finderPathCountByNomeRubrica, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNomeRubrica, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((pluviometroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNomeGruppo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					pluviometroModelImpl.getOriginalNomeGruppo()
				};

				finderCache.removeResult(_finderPathCountByNomeGruppo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeGruppo, args);

				args = new Object[] {pluviometroModelImpl.getNomeGruppo()};

				finderCache.removeResult(_finderPathCountByNomeGruppo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeGruppo, args);
			}

			if ((pluviometroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNomeRubrica.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					pluviometroModelImpl.getOriginalNomeRubrica()
				};

				finderCache.removeResult(_finderPathCountByNomeRubrica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeRubrica, args);

				args = new Object[] {pluviometroModelImpl.getNomeRubrica()};

				finderCache.removeResult(_finderPathCountByNomeRubrica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeRubrica, args);
			}
		}

		entityCache.putResult(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED, PluviometroImpl.class,
			pluviometro.getPrimaryKey(), pluviometro, false);

		pluviometro.resetOriginalValues();

		return pluviometro;
	}

	/**
	 * Returns the pluviometro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByPrimaryKey(primaryKey);

		if (pluviometro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPluviometroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pluviometro;
	}

	/**
	 * Returns the pluviometro with the primary key or throws a <code>NoSuchPluviometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro findByPrimaryKey(String stazioneId)
		throws NoSuchPluviometroException {

		return findByPrimaryKey((Serializable)stazioneId);
	}

	/**
	 * Returns the pluviometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pluviometro
	 * @return the pluviometro, or <code>null</code> if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED, PluviometroImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Pluviometro pluviometro = (Pluviometro)serializable;

		if (pluviometro == null) {
			Session session = null;

			try {
				session = openSession();

				pluviometro = (Pluviometro)session.get(
					PluviometroImpl.class, primaryKey);

				if (pluviometro != null) {
					cacheResult(pluviometro);
				}
				else {
					entityCache.putResult(
						PluviometroModelImpl.ENTITY_CACHE_ENABLED,
						PluviometroImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PluviometroModelImpl.ENTITY_CACHE_ENABLED,
					PluviometroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pluviometro;
	}

	/**
	 * Returns the pluviometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro, or <code>null</code> if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro fetchByPrimaryKey(String stazioneId) {
		return fetchByPrimaryKey((Serializable)stazioneId);
	}

	@Override
	public Map<Serializable, Pluviometro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Pluviometro> map =
			new HashMap<Serializable, Pluviometro>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Pluviometro pluviometro = fetchByPrimaryKey(primaryKey);

			if (pluviometro != null) {
				map.put(primaryKey, pluviometro);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PluviometroModelImpl.ENTITY_CACHE_ENABLED,
				PluviometroImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Pluviometro)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PLUVIOMETRO_WHERE_PKS_IN);

		for (int i = 0; i < uncachedPrimaryKeys.size(); i++) {
			query.append("?");

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				qPos.add((String)primaryKey);
			}

			for (Pluviometro pluviometro : (List<Pluviometro>)q.list()) {
				map.put(pluviometro.getPrimaryKeyObj(), pluviometro);

				cacheResult(pluviometro);

				uncachedPrimaryKeys.remove(pluviometro.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PluviometroModelImpl.ENTITY_CACHE_ENABLED,
					PluviometroImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the pluviometros.
	 *
	 * @return the pluviometros
	 */
	@Override
	public List<Pluviometro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of pluviometros
	 */
	@Override
	public List<Pluviometro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pluviometros
	 */
	@Override
	public List<Pluviometro> findAll(
		int start, int end, OrderByComparator<Pluviometro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pluviometros
	 */
	@Override
	public List<Pluviometro> findAll(
		int start, int end, OrderByComparator<Pluviometro> orderByComparator,
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

		List<Pluviometro> list = null;

		if (retrieveFromCache) {
			list = (List<Pluviometro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PLUVIOMETRO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PLUVIOMETRO;

				if (pagination) {
					sql = sql.concat(PluviometroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Pluviometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Pluviometro>)QueryUtil.list(
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
	 * Removes all the pluviometros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Pluviometro pluviometro : findAll()) {
			remove(pluviometro);
		}
	}

	/**
	 * Returns the number of pluviometros.
	 *
	 * @return the number of pluviometros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PLUVIOMETRO);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return PluviometroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pluviometro persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, PluviometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, PluviometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByNomeGruppo = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, PluviometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeGruppo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNomeGruppo = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, PluviometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeGruppo",
			new String[] {String.class.getName()},
			PluviometroModelImpl.NOMEGRUPPO_COLUMN_BITMASK);

		_finderPathCountByNomeGruppo = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeGruppo",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByNomeRubrica = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, PluviometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeRubrica",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNomeRubrica = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, PluviometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeRubrica",
			new String[] {String.class.getName()},
			PluviometroModelImpl.NOMERUBRICA_COLUMN_BITMASK);

		_finderPathCountByNomeRubrica = new FinderPath(
			PluviometroModelImpl.ENTITY_CACHE_ENABLED,
			PluviometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeRubrica",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(PluviometroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PLUVIOMETRO =
		"SELECT pluviometro FROM Pluviometro pluviometro";

	private static final String _SQL_SELECT_PLUVIOMETRO_WHERE_PKS_IN =
		"SELECT pluviometro FROM Pluviometro pluviometro WHERE stazioneId IN (";

	private static final String _SQL_SELECT_PLUVIOMETRO_WHERE =
		"SELECT pluviometro FROM Pluviometro pluviometro WHERE ";

	private static final String _SQL_COUNT_PLUVIOMETRO =
		"SELECT COUNT(pluviometro) FROM Pluviometro pluviometro";

	private static final String _SQL_COUNT_PLUVIOMETRO_WHERE =
		"SELECT COUNT(pluviometro) FROM Pluviometro pluviometro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pluviometro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Pluviometro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Pluviometro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PluviometroPersistenceImpl.class);

}