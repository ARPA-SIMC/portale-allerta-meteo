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

package it.eng.parer.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.parer.exception.NoSuchDatiSpecificiInvioException;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.impl.DatiSpecificiInvioImpl;
import it.eng.parer.model.impl.DatiSpecificiInvioModelImpl;
import it.eng.parer.service.persistence.DatiSpecificiInvioPersistence;

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
 * The persistence implementation for the dati specifici invio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class DatiSpecificiInvioPersistenceImpl
	extends BasePersistenceImpl<DatiSpecificiInvio>
	implements DatiSpecificiInvioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DatiSpecificiInvioUtil</code> to access the dati specifici invio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DatiSpecificiInvioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByesitoInvio;
	private FinderPath _finderPathWithoutPaginationFindByesitoInvio;
	private FinderPath _finderPathCountByesitoInvio;

	/**
	 * Returns all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @return the matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(String ESITO_INVIO) {
		return findByesitoInvio(
			ESITO_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end) {

		return findByesitoInvio(ESITO_INVIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		return findByesitoInvio(
			ESITO_INVIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator,
		boolean retrieveFromCache) {

		ESITO_INVIO = Objects.toString(ESITO_INVIO, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByesitoInvio;
			finderArgs = new Object[] {ESITO_INVIO};
		}
		else {
			finderPath = _finderPathWithPaginationFindByesitoInvio;
			finderArgs = new Object[] {
				ESITO_INVIO, start, end, orderByComparator
			};
		}

		List<DatiSpecificiInvio> list = null;

		if (retrieveFromCache) {
			list = (List<DatiSpecificiInvio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DatiSpecificiInvio datiSpecificiInvio : list) {
					if (!ESITO_INVIO.equals(
							datiSpecificiInvio.getESITO_INVIO())) {

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

			query.append(_SQL_SELECT_DATISPECIFICIINVIO_WHERE);

			boolean bindESITO_INVIO = false;

			if (ESITO_INVIO.isEmpty()) {
				query.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3);
			}
			else {
				bindESITO_INVIO = true;

				query.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DatiSpecificiInvioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindESITO_INVIO) {
					qPos.add(ESITO_INVIO);
				}

				if (!pagination) {
					list = (List<DatiSpecificiInvio>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DatiSpecificiInvio>)QueryUtil.list(
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
	 * Returns the first dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio findByesitoInvio_First(
			String ESITO_INVIO,
			OrderByComparator<DatiSpecificiInvio> orderByComparator)
		throws NoSuchDatiSpecificiInvioException {

		DatiSpecificiInvio datiSpecificiInvio = fetchByesitoInvio_First(
			ESITO_INVIO, orderByComparator);

		if (datiSpecificiInvio != null) {
			return datiSpecificiInvio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ESITO_INVIO=");
		msg.append(ESITO_INVIO);

		msg.append("}");

		throw new NoSuchDatiSpecificiInvioException(msg.toString());
	}

	/**
	 * Returns the first dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dati specifici invio, or <code>null</code> if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByesitoInvio_First(
		String ESITO_INVIO,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		List<DatiSpecificiInvio> list = findByesitoInvio(
			ESITO_INVIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio findByesitoInvio_Last(
			String ESITO_INVIO,
			OrderByComparator<DatiSpecificiInvio> orderByComparator)
		throws NoSuchDatiSpecificiInvioException {

		DatiSpecificiInvio datiSpecificiInvio = fetchByesitoInvio_Last(
			ESITO_INVIO, orderByComparator);

		if (datiSpecificiInvio != null) {
			return datiSpecificiInvio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ESITO_INVIO=");
		msg.append(ESITO_INVIO);

		msg.append("}");

		throw new NoSuchDatiSpecificiInvioException(msg.toString());
	}

	/**
	 * Returns the last dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dati specifici invio, or <code>null</code> if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByesitoInvio_Last(
		String ESITO_INVIO,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		int count = countByesitoInvio(ESITO_INVIO);

		if (count == 0) {
			return null;
		}

		List<DatiSpecificiInvio> list = findByesitoInvio(
			ESITO_INVIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dati specifici invios before and after the current dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ID_INVIO the primary key of the current dati specifici invio
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio[] findByesitoInvio_PrevAndNext(
			long ID_INVIO, String ESITO_INVIO,
			OrderByComparator<DatiSpecificiInvio> orderByComparator)
		throws NoSuchDatiSpecificiInvioException {

		ESITO_INVIO = Objects.toString(ESITO_INVIO, "");

		DatiSpecificiInvio datiSpecificiInvio = findByPrimaryKey(ID_INVIO);

		Session session = null;

		try {
			session = openSession();

			DatiSpecificiInvio[] array = new DatiSpecificiInvioImpl[3];

			array[0] = getByesitoInvio_PrevAndNext(
				session, datiSpecificiInvio, ESITO_INVIO, orderByComparator,
				true);

			array[1] = datiSpecificiInvio;

			array[2] = getByesitoInvio_PrevAndNext(
				session, datiSpecificiInvio, ESITO_INVIO, orderByComparator,
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

	protected DatiSpecificiInvio getByesitoInvio_PrevAndNext(
		Session session, DatiSpecificiInvio datiSpecificiInvio,
		String ESITO_INVIO,
		OrderByComparator<DatiSpecificiInvio> orderByComparator,
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

		query.append(_SQL_SELECT_DATISPECIFICIINVIO_WHERE);

		boolean bindESITO_INVIO = false;

		if (ESITO_INVIO.isEmpty()) {
			query.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3);
		}
		else {
			bindESITO_INVIO = true;

			query.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2);
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
			query.append(DatiSpecificiInvioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindESITO_INVIO) {
			qPos.add(ESITO_INVIO);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						datiSpecificiInvio)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DatiSpecificiInvio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dati specifici invios where ESITO_INVIO = &#63; from the database.
	 *
	 * @param ESITO_INVIO the esito_invio
	 */
	@Override
	public void removeByesitoInvio(String ESITO_INVIO) {
		for (DatiSpecificiInvio datiSpecificiInvio :
				findByesitoInvio(
					ESITO_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(datiSpecificiInvio);
		}
	}

	/**
	 * Returns the number of dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @return the number of matching dati specifici invios
	 */
	@Override
	public int countByesitoInvio(String ESITO_INVIO) {
		ESITO_INVIO = Objects.toString(ESITO_INVIO, "");

		FinderPath finderPath = _finderPathCountByesitoInvio;

		Object[] finderArgs = new Object[] {ESITO_INVIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATISPECIFICIINVIO_WHERE);

			boolean bindESITO_INVIO = false;

			if (ESITO_INVIO.isEmpty()) {
				query.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3);
			}
			else {
				bindESITO_INVIO = true;

				query.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindESITO_INVIO) {
					qPos.add(ESITO_INVIO);
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

	private static final String _FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2 =
		"datiSpecificiInvio.ESITO_INVIO = ?";

	private static final String _FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3 =
		"(datiSpecificiInvio.ESITO_INVIO IS NULL OR datiSpecificiInvio.ESITO_INVIO = '')";

	public DatiSpecificiInvioPersistenceImpl() {
		setModelClass(DatiSpecificiInvio.class);
	}

	/**
	 * Caches the dati specifici invio in the entity cache if it is enabled.
	 *
	 * @param datiSpecificiInvio the dati specifici invio
	 */
	@Override
	public void cacheResult(DatiSpecificiInvio datiSpecificiInvio) {
		entityCache.putResult(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class, datiSpecificiInvio.getPrimaryKey(),
			datiSpecificiInvio);

		datiSpecificiInvio.resetOriginalValues();
	}

	/**
	 * Caches the dati specifici invios in the entity cache if it is enabled.
	 *
	 * @param datiSpecificiInvios the dati specifici invios
	 */
	@Override
	public void cacheResult(List<DatiSpecificiInvio> datiSpecificiInvios) {
		for (DatiSpecificiInvio datiSpecificiInvio : datiSpecificiInvios) {
			if (entityCache.getResult(
					DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
					DatiSpecificiInvioImpl.class,
					datiSpecificiInvio.getPrimaryKey()) == null) {

				cacheResult(datiSpecificiInvio);
			}
			else {
				datiSpecificiInvio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dati specifici invios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DatiSpecificiInvioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dati specifici invio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DatiSpecificiInvio datiSpecificiInvio) {
		entityCache.removeResult(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class, datiSpecificiInvio.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DatiSpecificiInvio> datiSpecificiInvios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DatiSpecificiInvio datiSpecificiInvio : datiSpecificiInvios) {
			entityCache.removeResult(
				DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
				DatiSpecificiInvioImpl.class,
				datiSpecificiInvio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dati specifici invio with the primary key. Does not add the dati specifici invio to the database.
	 *
	 * @param ID_INVIO the primary key for the new dati specifici invio
	 * @return the new dati specifici invio
	 */
	@Override
	public DatiSpecificiInvio create(long ID_INVIO) {
		DatiSpecificiInvio datiSpecificiInvio = new DatiSpecificiInvioImpl();

		datiSpecificiInvio.setNew(true);
		datiSpecificiInvio.setPrimaryKey(ID_INVIO);

		datiSpecificiInvio.setCompanyId(companyProvider.getCompanyId());

		return datiSpecificiInvio;
	}

	/**
	 * Removes the dati specifici invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio that was removed
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio remove(long ID_INVIO)
		throws NoSuchDatiSpecificiInvioException {

		return remove((Serializable)ID_INVIO);
	}

	/**
	 * Removes the dati specifici invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dati specifici invio
	 * @return the dati specifici invio that was removed
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio remove(Serializable primaryKey)
		throws NoSuchDatiSpecificiInvioException {

		Session session = null;

		try {
			session = openSession();

			DatiSpecificiInvio datiSpecificiInvio =
				(DatiSpecificiInvio)session.get(
					DatiSpecificiInvioImpl.class, primaryKey);

			if (datiSpecificiInvio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDatiSpecificiInvioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(datiSpecificiInvio);
		}
		catch (NoSuchDatiSpecificiInvioException nsee) {
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
	protected DatiSpecificiInvio removeImpl(
		DatiSpecificiInvio datiSpecificiInvio) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(datiSpecificiInvio)) {
				datiSpecificiInvio = (DatiSpecificiInvio)session.get(
					DatiSpecificiInvioImpl.class,
					datiSpecificiInvio.getPrimaryKeyObj());
			}

			if (datiSpecificiInvio != null) {
				session.delete(datiSpecificiInvio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (datiSpecificiInvio != null) {
			clearCache(datiSpecificiInvio);
		}

		return datiSpecificiInvio;
	}

	@Override
	public DatiSpecificiInvio updateImpl(
		DatiSpecificiInvio datiSpecificiInvio) {

		boolean isNew = datiSpecificiInvio.isNew();

		if (!(datiSpecificiInvio instanceof DatiSpecificiInvioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(datiSpecificiInvio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					datiSpecificiInvio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in datiSpecificiInvio proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DatiSpecificiInvio implementation " +
					datiSpecificiInvio.getClass());
		}

		DatiSpecificiInvioModelImpl datiSpecificiInvioModelImpl =
			(DatiSpecificiInvioModelImpl)datiSpecificiInvio;

		Session session = null;

		try {
			session = openSession();

			if (datiSpecificiInvio.isNew()) {
				session.save(datiSpecificiInvio);

				datiSpecificiInvio.setNew(false);
			}
			else {
				datiSpecificiInvio = (DatiSpecificiInvio)session.merge(
					datiSpecificiInvio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DatiSpecificiInvioModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				datiSpecificiInvioModelImpl.getESITO_INVIO()
			};

			finderCache.removeResult(_finderPathCountByesitoInvio, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByesitoInvio, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((datiSpecificiInvioModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByesitoInvio.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					datiSpecificiInvioModelImpl.getOriginalESITO_INVIO()
				};

				finderCache.removeResult(_finderPathCountByesitoInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByesitoInvio, args);

				args = new Object[] {
					datiSpecificiInvioModelImpl.getESITO_INVIO()
				};

				finderCache.removeResult(_finderPathCountByesitoInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByesitoInvio, args);
			}
		}

		entityCache.putResult(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class, datiSpecificiInvio.getPrimaryKey(),
			datiSpecificiInvio, false);

		datiSpecificiInvio.resetOriginalValues();

		return datiSpecificiInvio;
	}

	/**
	 * Returns the dati specifici invio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDatiSpecificiInvioException {

		DatiSpecificiInvio datiSpecificiInvio = fetchByPrimaryKey(primaryKey);

		if (datiSpecificiInvio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDatiSpecificiInvioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return datiSpecificiInvio;
	}

	/**
	 * Returns the dati specifici invio with the primary key or throws a <code>NoSuchDatiSpecificiInvioException</code> if it could not be found.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio findByPrimaryKey(long ID_INVIO)
		throws NoSuchDatiSpecificiInvioException {

		return findByPrimaryKey((Serializable)ID_INVIO);
	}

	/**
	 * Returns the dati specifici invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dati specifici invio
	 * @return the dati specifici invio, or <code>null</code> if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DatiSpecificiInvio datiSpecificiInvio =
			(DatiSpecificiInvio)serializable;

		if (datiSpecificiInvio == null) {
			Session session = null;

			try {
				session = openSession();

				datiSpecificiInvio = (DatiSpecificiInvio)session.get(
					DatiSpecificiInvioImpl.class, primaryKey);

				if (datiSpecificiInvio != null) {
					cacheResult(datiSpecificiInvio);
				}
				else {
					entityCache.putResult(
						DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
						DatiSpecificiInvioImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
					DatiSpecificiInvioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return datiSpecificiInvio;
	}

	/**
	 * Returns the dati specifici invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio, or <code>null</code> if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByPrimaryKey(long ID_INVIO) {
		return fetchByPrimaryKey((Serializable)ID_INVIO);
	}

	@Override
	public Map<Serializable, DatiSpecificiInvio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DatiSpecificiInvio> map =
			new HashMap<Serializable, DatiSpecificiInvio>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DatiSpecificiInvio datiSpecificiInvio = fetchByPrimaryKey(
				primaryKey);

			if (datiSpecificiInvio != null) {
				map.put(primaryKey, datiSpecificiInvio);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
				DatiSpecificiInvioImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DatiSpecificiInvio)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DATISPECIFICIINVIO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DatiSpecificiInvio datiSpecificiInvio :
					(List<DatiSpecificiInvio>)q.list()) {

				map.put(
					datiSpecificiInvio.getPrimaryKeyObj(), datiSpecificiInvio);

				cacheResult(datiSpecificiInvio);

				uncachedPrimaryKeys.remove(
					datiSpecificiInvio.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
					DatiSpecificiInvioImpl.class, primaryKey, nullModel);
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
	 * Returns all the dati specifici invios.
	 *
	 * @return the dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll(
		int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll(
		int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator,
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

		List<DatiSpecificiInvio> list = null;

		if (retrieveFromCache) {
			list = (List<DatiSpecificiInvio>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATISPECIFICIINVIO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATISPECIFICIINVIO;

				if (pagination) {
					sql = sql.concat(DatiSpecificiInvioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DatiSpecificiInvio>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DatiSpecificiInvio>)QueryUtil.list(
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
	 * Removes all the dati specifici invios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DatiSpecificiInvio datiSpecificiInvio : findAll()) {
			remove(datiSpecificiInvio);
		}
	}

	/**
	 * Returns the number of dati specifici invios.
	 *
	 * @return the number of dati specifici invios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATISPECIFICIINVIO);

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
		return DatiSpecificiInvioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dati specifici invio persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioModelImpl.FINDER_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioModelImpl.FINDER_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByesitoInvio = new FinderPath(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioModelImpl.FINDER_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesitoInvio",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByesitoInvio = new FinderPath(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioModelImpl.FINDER_CACHE_ENABLED,
			DatiSpecificiInvioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesitoInvio",
			new String[] {String.class.getName()},
			DatiSpecificiInvioModelImpl.ESITO_INVIO_COLUMN_BITMASK);

		_finderPathCountByesitoInvio = new FinderPath(
			DatiSpecificiInvioModelImpl.ENTITY_CACHE_ENABLED,
			DatiSpecificiInvioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesitoInvio",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(DatiSpecificiInvioImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATISPECIFICIINVIO =
		"SELECT datiSpecificiInvio FROM DatiSpecificiInvio datiSpecificiInvio";

	private static final String _SQL_SELECT_DATISPECIFICIINVIO_WHERE_PKS_IN =
		"SELECT datiSpecificiInvio FROM DatiSpecificiInvio datiSpecificiInvio WHERE ID_INVIO IN (";

	private static final String _SQL_SELECT_DATISPECIFICIINVIO_WHERE =
		"SELECT datiSpecificiInvio FROM DatiSpecificiInvio datiSpecificiInvio WHERE ";

	private static final String _SQL_COUNT_DATISPECIFICIINVIO =
		"SELECT COUNT(datiSpecificiInvio) FROM DatiSpecificiInvio datiSpecificiInvio";

	private static final String _SQL_COUNT_DATISPECIFICIINVIO_WHERE =
		"SELECT COUNT(datiSpecificiInvio) FROM DatiSpecificiInvio datiSpecificiInvio WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "datiSpecificiInvio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DatiSpecificiInvio exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DatiSpecificiInvio exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DatiSpecificiInvioPersistenceImpl.class);

}