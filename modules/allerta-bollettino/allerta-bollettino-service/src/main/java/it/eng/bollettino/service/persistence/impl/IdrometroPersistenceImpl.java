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

import it.eng.bollettino.exception.NoSuchIdrometroException;
import it.eng.bollettino.model.Idrometro;
import it.eng.bollettino.model.impl.IdrometroImpl;
import it.eng.bollettino.model.impl.IdrometroModelImpl;
import it.eng.bollettino.service.persistence.IdrometroPersistence;

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
 * The persistence implementation for the idrometro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class IdrometroPersistenceImpl
	extends BasePersistenceImpl<Idrometro> implements IdrometroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IdrometroUtil</code> to access the idrometro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IdrometroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByNomeBacino;
	private FinderPath _finderPathWithoutPaginationFindByNomeBacino;
	private FinderPath _finderPathCountByNomeBacino;

	/**
	 * Returns all the idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(String nomeBacino) {
		return findByNomeBacino(
			nomeBacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end) {

		return findByNomeBacino(nomeBacino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return findByNomeBacino(
			nomeBacino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean retrieveFromCache) {

		nomeBacino = Objects.toString(nomeBacino, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNomeBacino;
			finderArgs = new Object[] {nomeBacino};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNomeBacino;
			finderArgs = new Object[] {
				nomeBacino, start, end, orderByComparator
			};
		}

		List<Idrometro> list = null;

		if (retrieveFromCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Idrometro idrometro : list) {
					if (!nomeBacino.equals(idrometro.getNomeBacino())) {
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

			query.append(_SQL_SELECT_IDROMETRO_WHERE);

			boolean bindNomeBacino = false;

			if (nomeBacino.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3);
			}
			else {
				bindNomeBacino = true;

				query.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IdrometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeBacino) {
					qPos.add(nomeBacino);
				}

				if (!pagination) {
					list = (List<Idrometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Idrometro>)QueryUtil.list(
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
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeBacino_First(
			String nomeBacino, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeBacino_First(
			nomeBacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeBacino=");
		msg.append(nomeBacino);

		msg.append("}");

		throw new NoSuchIdrometroException(msg.toString());
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeBacino_First(
		String nomeBacino, OrderByComparator<Idrometro> orderByComparator) {

		List<Idrometro> list = findByNomeBacino(
			nomeBacino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeBacino_Last(
			String nomeBacino, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeBacino_Last(
			nomeBacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeBacino=");
		msg.append(nomeBacino);

		msg.append("}");

		throw new NoSuchIdrometroException(msg.toString());
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeBacino_Last(
		String nomeBacino, OrderByComparator<Idrometro> orderByComparator) {

		int count = countByNomeBacino(nomeBacino);

		if (count == 0) {
			return null;
		}

		List<Idrometro> list = findByNomeBacino(
			nomeBacino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro[] findByNomeBacino_PrevAndNext(
			String stazioneId, String nomeBacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		nomeBacino = Objects.toString(nomeBacino, "");

		Idrometro idrometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Idrometro[] array = new IdrometroImpl[3];

			array[0] = getByNomeBacino_PrevAndNext(
				session, idrometro, nomeBacino, orderByComparator, true);

			array[1] = idrometro;

			array[2] = getByNomeBacino_PrevAndNext(
				session, idrometro, nomeBacino, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Idrometro getByNomeBacino_PrevAndNext(
		Session session, Idrometro idrometro, String nomeBacino,
		OrderByComparator<Idrometro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IDROMETRO_WHERE);

		boolean bindNomeBacino = false;

		if (nomeBacino.isEmpty()) {
			query.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3);
		}
		else {
			bindNomeBacino = true;

			query.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2);
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
			query.append(IdrometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNomeBacino) {
			qPos.add(nomeBacino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(idrometro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Idrometro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the idrometros where nomeBacino = &#63; from the database.
	 *
	 * @param nomeBacino the nome bacino
	 */
	@Override
	public void removeByNomeBacino(String nomeBacino) {
		for (Idrometro idrometro :
				findByNomeBacino(
					nomeBacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the number of matching idrometros
	 */
	@Override
	public int countByNomeBacino(String nomeBacino) {
		nomeBacino = Objects.toString(nomeBacino, "");

		FinderPath finderPath = _finderPathCountByNomeBacino;

		Object[] finderArgs = new Object[] {nomeBacino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IDROMETRO_WHERE);

			boolean bindNomeBacino = false;

			if (nomeBacino.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3);
			}
			else {
				bindNomeBacino = true;

				query.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeBacino) {
					qPos.add(nomeBacino);
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

	private static final String _FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2 =
		"idrometro.nomeBacino = ?";

	private static final String _FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3 =
		"(idrometro.nomeBacino IS NULL OR idrometro.nomeBacino = '')";

	private FinderPath _finderPathWithPaginationFindByNomeSottobacino;
	private FinderPath _finderPathWithoutPaginationFindByNomeSottobacino;
	private FinderPath _finderPathCountByNomeSottobacino;

	/**
	 * Returns all the idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(String nomeSottobacino) {
		return findByNomeSottobacino(
			nomeSottobacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end) {

		return findByNomeSottobacino(nomeSottobacino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return findByNomeSottobacino(
			nomeSottobacino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean retrieveFromCache) {

		nomeSottobacino = Objects.toString(nomeSottobacino, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNomeSottobacino;
			finderArgs = new Object[] {nomeSottobacino};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNomeSottobacino;
			finderArgs = new Object[] {
				nomeSottobacino, start, end, orderByComparator
			};
		}

		List<Idrometro> list = null;

		if (retrieveFromCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Idrometro idrometro : list) {
					if (!nomeSottobacino.equals(
							idrometro.getNomeSottobacino())) {

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

			query.append(_SQL_SELECT_IDROMETRO_WHERE);

			boolean bindNomeSottobacino = false;

			if (nomeSottobacino.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3);
			}
			else {
				bindNomeSottobacino = true;

				query.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IdrometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeSottobacino) {
					qPos.add(nomeSottobacino);
				}

				if (!pagination) {
					list = (List<Idrometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Idrometro>)QueryUtil.list(
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
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeSottobacino_First(
			String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeSottobacino_First(
			nomeSottobacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeSottobacino=");
		msg.append(nomeSottobacino);

		msg.append("}");

		throw new NoSuchIdrometroException(msg.toString());
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeSottobacino_First(
		String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator) {

		List<Idrometro> list = findByNomeSottobacino(
			nomeSottobacino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeSottobacino_Last(
			String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeSottobacino_Last(
			nomeSottobacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeSottobacino=");
		msg.append(nomeSottobacino);

		msg.append("}");

		throw new NoSuchIdrometroException(msg.toString());
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeSottobacino_Last(
		String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator) {

		int count = countByNomeSottobacino(nomeSottobacino);

		if (count == 0) {
			return null;
		}

		List<Idrometro> list = findByNomeSottobacino(
			nomeSottobacino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro[] findByNomeSottobacino_PrevAndNext(
			String stazioneId, String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		nomeSottobacino = Objects.toString(nomeSottobacino, "");

		Idrometro idrometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Idrometro[] array = new IdrometroImpl[3];

			array[0] = getByNomeSottobacino_PrevAndNext(
				session, idrometro, nomeSottobacino, orderByComparator, true);

			array[1] = idrometro;

			array[2] = getByNomeSottobacino_PrevAndNext(
				session, idrometro, nomeSottobacino, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Idrometro getByNomeSottobacino_PrevAndNext(
		Session session, Idrometro idrometro, String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IDROMETRO_WHERE);

		boolean bindNomeSottobacino = false;

		if (nomeSottobacino.isEmpty()) {
			query.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3);
		}
		else {
			bindNomeSottobacino = true;

			query.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2);
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
			query.append(IdrometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNomeSottobacino) {
			qPos.add(nomeSottobacino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(idrometro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Idrometro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the idrometros where nomeSottobacino = &#63; from the database.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 */
	@Override
	public void removeByNomeSottobacino(String nomeSottobacino) {
		for (Idrometro idrometro :
				findByNomeSottobacino(
					nomeSottobacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the number of matching idrometros
	 */
	@Override
	public int countByNomeSottobacino(String nomeSottobacino) {
		nomeSottobacino = Objects.toString(nomeSottobacino, "");

		FinderPath finderPath = _finderPathCountByNomeSottobacino;

		Object[] finderArgs = new Object[] {nomeSottobacino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IDROMETRO_WHERE);

			boolean bindNomeSottobacino = false;

			if (nomeSottobacino.isEmpty()) {
				query.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3);
			}
			else {
				bindNomeSottobacino = true;

				query.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNomeSottobacino) {
					qPos.add(nomeSottobacino);
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

	private static final String
		_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2 =
			"idrometro.nomeSottobacino = ?";

	private static final String
		_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3 =
			"(idrometro.nomeSottobacino IS NULL OR idrometro.nomeSottobacino = '')";

	private FinderPath _finderPathWithPaginationFindByNomeRubrica;
	private FinderPath _finderPathWithoutPaginationFindByNomeRubrica;
	private FinderPath _finderPathCountByNomeRubrica;

	/**
	 * Returns all the idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(String nomeRubrica) {
		return findByNomeRubrica(
			nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end) {

		return findByNomeRubrica(nomeRubrica, start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
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

		List<Idrometro> list = null;

		if (retrieveFromCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Idrometro idrometro : list) {
					if (!nomeRubrica.equals(idrometro.getNomeRubrica())) {
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

			query.append(_SQL_SELECT_IDROMETRO_WHERE);

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
				query.append(IdrometroModelImpl.ORDER_BY_JPQL);
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
					list = (List<Idrometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Idrometro>)QueryUtil.list(
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
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeRubrica_First(
			String nomeRubrica, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeRubrica_First(
			nomeRubrica, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeRubrica=");
		msg.append(nomeRubrica);

		msg.append("}");

		throw new NoSuchIdrometroException(msg.toString());
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeRubrica_First(
		String nomeRubrica, OrderByComparator<Idrometro> orderByComparator) {

		List<Idrometro> list = findByNomeRubrica(
			nomeRubrica, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeRubrica_Last(
			String nomeRubrica, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeRubrica_Last(
			nomeRubrica, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nomeRubrica=");
		msg.append(nomeRubrica);

		msg.append("}");

		throw new NoSuchIdrometroException(msg.toString());
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeRubrica_Last(
		String nomeRubrica, OrderByComparator<Idrometro> orderByComparator) {

		int count = countByNomeRubrica(nomeRubrica);

		if (count == 0) {
			return null;
		}

		List<Idrometro> list = findByNomeRubrica(
			nomeRubrica, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		nomeRubrica = Objects.toString(nomeRubrica, "");

		Idrometro idrometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Idrometro[] array = new IdrometroImpl[3];

			array[0] = getByNomeRubrica_PrevAndNext(
				session, idrometro, nomeRubrica, orderByComparator, true);

			array[1] = idrometro;

			array[2] = getByNomeRubrica_PrevAndNext(
				session, idrometro, nomeRubrica, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Idrometro getByNomeRubrica_PrevAndNext(
		Session session, Idrometro idrometro, String nomeRubrica,
		OrderByComparator<Idrometro> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IDROMETRO_WHERE);

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
			query.append(IdrometroModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(idrometro)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Idrometro> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the idrometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	@Override
	public void removeByNomeRubrica(String nomeRubrica) {
		for (Idrometro idrometro :
				findByNomeRubrica(
					nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching idrometros
	 */
	@Override
	public int countByNomeRubrica(String nomeRubrica) {
		nomeRubrica = Objects.toString(nomeRubrica, "");

		FinderPath finderPath = _finderPathCountByNomeRubrica;

		Object[] finderArgs = new Object[] {nomeRubrica};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IDROMETRO_WHERE);

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
		"idrometro.nomeRubrica = ?";

	private static final String _FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3 =
		"(idrometro.nomeRubrica IS NULL OR idrometro.nomeRubrica = '')";

	public IdrometroPersistenceImpl() {
		setModelClass(Idrometro.class);
	}

	/**
	 * Caches the idrometro in the entity cache if it is enabled.
	 *
	 * @param idrometro the idrometro
	 */
	@Override
	public void cacheResult(Idrometro idrometro) {
		entityCache.putResult(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED, IdrometroImpl.class,
			idrometro.getPrimaryKey(), idrometro);

		idrometro.resetOriginalValues();
	}

	/**
	 * Caches the idrometros in the entity cache if it is enabled.
	 *
	 * @param idrometros the idrometros
	 */
	@Override
	public void cacheResult(List<Idrometro> idrometros) {
		for (Idrometro idrometro : idrometros) {
			if (entityCache.getResult(
					IdrometroModelImpl.ENTITY_CACHE_ENABLED,
					IdrometroImpl.class, idrometro.getPrimaryKey()) == null) {

				cacheResult(idrometro);
			}
			else {
				idrometro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all idrometros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IdrometroImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the idrometro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Idrometro idrometro) {
		entityCache.removeResult(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED, IdrometroImpl.class,
			idrometro.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Idrometro> idrometros) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Idrometro idrometro : idrometros) {
			entityCache.removeResult(
				IdrometroModelImpl.ENTITY_CACHE_ENABLED, IdrometroImpl.class,
				idrometro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new idrometro with the primary key. Does not add the idrometro to the database.
	 *
	 * @param stazioneId the primary key for the new idrometro
	 * @return the new idrometro
	 */
	@Override
	public Idrometro create(String stazioneId) {
		Idrometro idrometro = new IdrometroImpl();

		idrometro.setNew(true);
		idrometro.setPrimaryKey(stazioneId);

		return idrometro;
	}

	/**
	 * Removes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro remove(String stazioneId) throws NoSuchIdrometroException {
		return remove((Serializable)stazioneId);
	}

	/**
	 * Removes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro remove(Serializable primaryKey)
		throws NoSuchIdrometroException {

		Session session = null;

		try {
			session = openSession();

			Idrometro idrometro = (Idrometro)session.get(
				IdrometroImpl.class, primaryKey);

			if (idrometro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIdrometroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(idrometro);
		}
		catch (NoSuchIdrometroException nsee) {
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
	protected Idrometro removeImpl(Idrometro idrometro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(idrometro)) {
				idrometro = (Idrometro)session.get(
					IdrometroImpl.class, idrometro.getPrimaryKeyObj());
			}

			if (idrometro != null) {
				session.delete(idrometro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (idrometro != null) {
			clearCache(idrometro);
		}

		return idrometro;
	}

	@Override
	public Idrometro updateImpl(Idrometro idrometro) {
		boolean isNew = idrometro.isNew();

		if (!(idrometro instanceof IdrometroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(idrometro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(idrometro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in idrometro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Idrometro implementation " +
					idrometro.getClass());
		}

		IdrometroModelImpl idrometroModelImpl = (IdrometroModelImpl)idrometro;

		Session session = null;

		try {
			session = openSession();

			if (idrometro.isNew()) {
				session.save(idrometro);

				idrometro.setNew(false);
			}
			else {
				idrometro = (Idrometro)session.merge(idrometro);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!IdrometroModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {idrometroModelImpl.getNomeBacino()};

			finderCache.removeResult(_finderPathCountByNomeBacino, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNomeBacino, args);

			args = new Object[] {idrometroModelImpl.getNomeSottobacino()};

			finderCache.removeResult(_finderPathCountByNomeSottobacino, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNomeSottobacino, args);

			args = new Object[] {idrometroModelImpl.getNomeRubrica()};

			finderCache.removeResult(_finderPathCountByNomeRubrica, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNomeRubrica, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((idrometroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNomeBacino.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					idrometroModelImpl.getOriginalNomeBacino()
				};

				finderCache.removeResult(_finderPathCountByNomeBacino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeBacino, args);

				args = new Object[] {idrometroModelImpl.getNomeBacino()};

				finderCache.removeResult(_finderPathCountByNomeBacino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeBacino, args);
			}

			if ((idrometroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNomeSottobacino.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					idrometroModelImpl.getOriginalNomeSottobacino()
				};

				finderCache.removeResult(
					_finderPathCountByNomeSottobacino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeSottobacino, args);

				args = new Object[] {idrometroModelImpl.getNomeSottobacino()};

				finderCache.removeResult(
					_finderPathCountByNomeSottobacino, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeSottobacino, args);
			}

			if ((idrometroModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNomeRubrica.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					idrometroModelImpl.getOriginalNomeRubrica()
				};

				finderCache.removeResult(_finderPathCountByNomeRubrica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeRubrica, args);

				args = new Object[] {idrometroModelImpl.getNomeRubrica()};

				finderCache.removeResult(_finderPathCountByNomeRubrica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNomeRubrica, args);
			}
		}

		entityCache.putResult(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED, IdrometroImpl.class,
			idrometro.getPrimaryKey(), idrometro, false);

		idrometro.resetOriginalValues();

		return idrometro;
	}

	/**
	 * Returns the idrometro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the idrometro
	 * @return the idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByPrimaryKey(primaryKey);

		if (idrometro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIdrometroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return idrometro;
	}

	/**
	 * Returns the idrometro with the primary key or throws a <code>NoSuchIdrometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro findByPrimaryKey(String stazioneId)
		throws NoSuchIdrometroException {

		return findByPrimaryKey((Serializable)stazioneId);
	}

	/**
	 * Returns the idrometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the idrometro
	 * @return the idrometro, or <code>null</code> if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED, IdrometroImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Idrometro idrometro = (Idrometro)serializable;

		if (idrometro == null) {
			Session session = null;

			try {
				session = openSession();

				idrometro = (Idrometro)session.get(
					IdrometroImpl.class, primaryKey);

				if (idrometro != null) {
					cacheResult(idrometro);
				}
				else {
					entityCache.putResult(
						IdrometroModelImpl.ENTITY_CACHE_ENABLED,
						IdrometroImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					IdrometroModelImpl.ENTITY_CACHE_ENABLED,
					IdrometroImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return idrometro;
	}

	/**
	 * Returns the idrometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro, or <code>null</code> if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro fetchByPrimaryKey(String stazioneId) {
		return fetchByPrimaryKey((Serializable)stazioneId);
	}

	@Override
	public Map<Serializable, Idrometro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Idrometro> map =
			new HashMap<Serializable, Idrometro>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Idrometro idrometro = fetchByPrimaryKey(primaryKey);

			if (idrometro != null) {
				map.put(primaryKey, idrometro);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				IdrometroModelImpl.ENTITY_CACHE_ENABLED, IdrometroImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Idrometro)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_IDROMETRO_WHERE_PKS_IN);

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

			for (Idrometro idrometro : (List<Idrometro>)q.list()) {
				map.put(idrometro.getPrimaryKeyObj(), idrometro);

				cacheResult(idrometro);

				uncachedPrimaryKeys.remove(idrometro.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					IdrometroModelImpl.ENTITY_CACHE_ENABLED,
					IdrometroImpl.class, primaryKey, nullModel);
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
	 * Returns all the idrometros.
	 *
	 * @return the idrometros
	 */
	@Override
	public List<Idrometro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of idrometros
	 */
	@Override
	public List<Idrometro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idrometros
	 */
	@Override
	public List<Idrometro> findAll(
		int start, int end, OrderByComparator<Idrometro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of idrometros
	 */
	@Override
	public List<Idrometro> findAll(
		int start, int end, OrderByComparator<Idrometro> orderByComparator,
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

		List<Idrometro> list = null;

		if (retrieveFromCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IDROMETRO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IDROMETRO;

				if (pagination) {
					sql = sql.concat(IdrometroModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Idrometro>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Idrometro>)QueryUtil.list(
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
	 * Removes all the idrometros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Idrometro idrometro : findAll()) {
			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros.
	 *
	 * @return the number of idrometros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IDROMETRO);

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
		return IdrometroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the idrometro persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByNomeBacino = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeBacino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNomeBacino = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeBacino",
			new String[] {String.class.getName()},
			IdrometroModelImpl.NOMEBACINO_COLUMN_BITMASK);

		_finderPathCountByNomeBacino = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeBacino",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByNomeSottobacino = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeSottobacino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNomeSottobacino = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeSottobacino",
			new String[] {String.class.getName()},
			IdrometroModelImpl.NOMESOTTOBACINO_COLUMN_BITMASK);

		_finderPathCountByNomeSottobacino = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeSottobacino",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByNomeRubrica = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeRubrica",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNomeRubrica = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, IdrometroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeRubrica",
			new String[] {String.class.getName()},
			IdrometroModelImpl.NOMERUBRICA_COLUMN_BITMASK);

		_finderPathCountByNomeRubrica = new FinderPath(
			IdrometroModelImpl.ENTITY_CACHE_ENABLED,
			IdrometroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeRubrica",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(IdrometroImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IDROMETRO =
		"SELECT idrometro FROM Idrometro idrometro";

	private static final String _SQL_SELECT_IDROMETRO_WHERE_PKS_IN =
		"SELECT idrometro FROM Idrometro idrometro WHERE stazioneId IN (";

	private static final String _SQL_SELECT_IDROMETRO_WHERE =
		"SELECT idrometro FROM Idrometro idrometro WHERE ";

	private static final String _SQL_COUNT_IDROMETRO =
		"SELECT COUNT(idrometro) FROM Idrometro idrometro";

	private static final String _SQL_COUNT_IDROMETRO_WHERE =
		"SELECT COUNT(idrometro) FROM Idrometro idrometro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "idrometro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Idrometro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Idrometro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IdrometroPersistenceImpl.class);

}