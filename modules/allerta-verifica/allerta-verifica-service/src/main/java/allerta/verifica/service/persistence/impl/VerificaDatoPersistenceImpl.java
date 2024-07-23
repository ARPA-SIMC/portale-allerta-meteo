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

package allerta.verifica.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.exception.NoSuchVerificaDatoException;
import allerta.verifica.model.VerificaDato;
import allerta.verifica.model.impl.VerificaDatoImpl;
import allerta.verifica.model.impl.VerificaDatoModelImpl;
import allerta.verifica.service.persistence.VerificaDatoPersistence;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the verifica dato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VerificaDatoPersistenceImpl
	extends BasePersistenceImpl<VerificaDato>
	implements VerificaDatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VerificaDatoUtil</code> to access the verifica dato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VerificaDatoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocumento;
	private FinderPath _finderPathWithoutPaginationFindByDocumento;
	private FinderPath _finderPathCountByDocumento;

	/**
	 * Returns all the verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(long documento) {
		return findByDocumento(
			documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(
		long documento, int start, int end) {

		return findByDocumento(documento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumento(documento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDocumento;
			finderArgs = new Object[] {documento};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDocumento;
			finderArgs = new Object[] {
				documento, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento())) {
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

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumento_First(
			long documento, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumento_First(
			documento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumento_First(
		long documento, OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumento(
			documento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumento_Last(
			long documento, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumento_Last(
			documento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumento_Last(
		long documento, OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumento(documento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumento(
			documento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumento_PrevAndNext(
				session, verificaDato, documento, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumento_PrevAndNext(
				session, verificaDato, documento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VerificaDato getByDocumento_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	@Override
	public void removeByDocumento(long documento) {
		for (VerificaDato verificaDato :
				findByDocumento(
					documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumento(long documento) {
		FinderPath finderPath = _finderPathCountByDocumento;

		Object[] finderArgs = new Object[] {documento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

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

	private static final String _FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2 =
		"verificaDato.documento = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiorno;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoGiorno;
	private FinderPath _finderPathCountByDocumentoGiorno;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno) {

		return findByDocumentoGiorno(
			documento, giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end) {

		return findByDocumentoGiorno(documento, giorno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiorno(
			documento, giorno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDocumentoGiorno;
			finderArgs = new Object[] {documento, _getTime(giorno)};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDocumentoGiorno;
			finderArgs = new Object[] {
				documento, _getTime(giorno), start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiorno_First(
			long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiorno_First(
			documento, giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiorno_First(
		long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiorno(
			documento, giorno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiorno_Last(
			long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiorno_Last(
			documento, giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiorno_Last(
		long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiorno(documento, giorno);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiorno(
			documento, giorno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiorno_PrevAndNext(
			long id, long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiorno_PrevAndNext(
				session, verificaDato, documento, giorno, orderByComparator,
				true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiorno_PrevAndNext(
				session, verificaDato, documento, giorno, orderByComparator,
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

	protected VerificaDato getByDocumentoGiorno_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2);
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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 */
	@Override
	public void removeByDocumentoGiorno(long documento, Date giorno) {
		for (VerificaDato verificaDato :
				findByDocumentoGiorno(
					documento, giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiorno(long documento, Date giorno) {
		FinderPath finderPath = _finderPathCountByDocumentoGiorno;

		Object[] finderArgs = new Object[] {documento, _getTime(giorno)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
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

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2 =
		"verificaDato.documento = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1 =
		"verificaDato.giorno IS NULL";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2 =
		"verificaDato.giorno = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiornoEvento;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoGiornoEvento;
	private FinderPath _finderPathCountByDocumentoGiornoEvento;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		return findByDocumentoGiornoEvento(
			documento, giorno, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end) {

		return findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByDocumentoGiornoEvento;
			finderArgs = new Object[] {documento, _getTime(giorno), evento};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDocumentoGiornoEvento;
			finderArgs = new Object[] {
				documento, _getTime(giorno), evento, start, end,
				orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno()) ||
						(evento != verificaDato.getEvento())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2);
			}

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				qPos.add(evento);

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoEvento_First(
			long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoEvento_First(
			documento, giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoEvento_First(
		long documento, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiornoEvento(
			documento, giorno, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoEvento_Last(
			long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoEvento_Last(
			documento, giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoEvento_Last(
		long documento, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiornoEvento(documento, giorno, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiornoEvento(
			documento, giorno, evento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiornoEvento_PrevAndNext(
			long id, long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiornoEvento_PrevAndNext(
				session, verificaDato, documento, giorno, evento,
				orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiornoEvento_PrevAndNext(
				session, verificaDato, documento, giorno, evento,
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

	protected VerificaDato getByDocumentoGiornoEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		long evento, OrderByComparator<VerificaDato> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2);
		}

		query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2);

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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		qPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	@Override
	public void removeByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		for (VerificaDato verificaDato :
				findByDocumentoGiornoEvento(
					documento, giorno, evento, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		FinderPath finderPath = _finderPathCountByDocumentoGiornoEvento;

		Object[] finderArgs = new Object[] {
			documento, _getTime(giorno), evento
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2);
			}

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				qPos.add(evento);

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
		_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2 =
			"verificaDato.documento = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2 =
		"verificaDato.evento = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiornoZona;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoGiornoZona;
	private FinderPath _finderPathCountByDocumentoGiornoZona;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		return findByDocumentoGiornoZona(
			documento, giorno, zona, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end) {

		return findByDocumentoGiornoZona(
			documento, giorno, zona, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiornoZona(
			documento, giorno, zona, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		zona = Objects.toString(zona, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDocumentoGiornoZona;
			finderArgs = new Object[] {documento, _getTime(giorno), zona};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDocumentoGiornoZona;
			finderArgs = new Object[] {
				documento, _getTime(giorno), zona, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
				}

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZona_First(
			long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZona_First(
			documento, giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZona_First(
		long documento, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiornoZona(
			documento, giorno, zona, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZona_Last(
			long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZona_Last(
			documento, giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZona_Last(
		long documento, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiornoZona(documento, giorno, zona);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiornoZona(
			documento, giorno, zona, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiornoZona_PrevAndNext(
			long id, long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiornoZona_PrevAndNext(
				session, verificaDato, documento, giorno, zona,
				orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiornoZona_PrevAndNext(
				session, verificaDato, documento, giorno, zona,
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

	protected VerificaDato getByDocumentoGiornoZona_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		String zona, OrderByComparator<VerificaDato> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3);
		}
		else {
			bindZona = true;

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2);
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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			qPos.add(zona);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	@Override
	public void removeByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		for (VerificaDato verificaDato :
				findByDocumentoGiornoZona(
					documento, giorno, zona, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByDocumentoGiornoZona;

		Object[] finderArgs = new Object[] {documento, _getTime(giorno), zona};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
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

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2 =
		"verificaDato.documento = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2 =
		"verificaDato.zona = ?";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3 =
		"(verificaDato.zona IS NULL OR verificaDato.zona = '')";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiornoZonaEvento;
	private FinderPath
		_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento;
	private FinderPath _finderPathCountByDocumentoGiornoZonaEvento;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		return findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end) {

		return findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end, OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end, OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		zona = Objects.toString(zona, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento;
			finderArgs = new Object[] {
				documento, _getTime(giorno), zona, evento
			};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByDocumentoGiornoZonaEvento;
			finderArgs = new Object[] {
				documento, _getTime(giorno), zona, evento, start, end,
				orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona()) ||
						(evento != verificaDato.getEvento())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2);
			}

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
				}

				qPos.add(evento);

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZonaEvento_First(
			long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZonaEvento_First(
			documento, giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZonaEvento_First(
		long documento, Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZonaEvento_Last(
			long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZonaEvento_Last(
			documento, giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documento=");
		msg.append(documento);

		msg.append(", giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZonaEvento_Last(
		long documento, Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiornoZonaEvento_PrevAndNext(
			long id, long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiornoZonaEvento_PrevAndNext(
				session, verificaDato, documento, giorno, zona, evento,
				orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiornoZonaEvento_PrevAndNext(
				session, verificaDato, documento, giorno, zona, evento,
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

	protected VerificaDato getByDocumentoGiornoZonaEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3);
		}
		else {
			bindZona = true;

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2);
		}

		query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2);

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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documento);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			qPos.add(zona);
		}

		qPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	@Override
	public void removeByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		for (VerificaDato verificaDato :
				findByDocumentoGiornoZonaEvento(
					documento, giorno, zona, evento, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByDocumentoGiornoZonaEvento;

		Object[] finderArgs = new Object[] {
			documento, _getTime(giorno), zona, evento
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2);
			}

			query.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documento);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
				}

				qPos.add(evento);

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
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2 =
			"verificaDato.documento = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1 =
			"verificaDato.giorno IS NULL AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2 =
			"verificaDato.giorno = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2 =
			"verificaDato.zona = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3 =
			"(verificaDato.zona IS NULL OR verificaDato.zona = '') AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2 =
			"verificaDato.evento = ?";

	private FinderPath _finderPathWithPaginationFindByGiorno;
	private FinderPath _finderPathWithoutPaginationFindByGiorno;
	private FinderPath _finderPathCountByGiorno;

	/**
	 * Returns all the verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(Date giorno) {
		return findByGiorno(giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(Date giorno, int start, int end) {
		return findByGiorno(giorno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiorno(giorno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGiorno;
			finderArgs = new Object[] {_getTime(giorno)};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGiorno;
			finderArgs = new Object[] {
				_getTime(giorno), start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno())) {
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

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNO_GIORNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiorno_First(
			Date giorno, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiorno_First(
			giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiorno_First(
		Date giorno, OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiorno(giorno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiorno_Last(
			Date giorno, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiorno_Last(
			giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiorno_Last(
		Date giorno, OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiorno(giorno);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiorno(
			giorno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiorno_PrevAndNext(
			long id, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiorno_PrevAndNext(
				session, verificaDato, giorno, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByGiorno_PrevAndNext(
				session, verificaDato, giorno, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VerificaDato getByGiorno_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_GIORNO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_GIORNO_GIORNO_2);
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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; from the database.
	 *
	 * @param giorno the giorno
	 */
	@Override
	public void removeByGiorno(Date giorno) {
		for (VerificaDato verificaDato :
				findByGiorno(
					giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiorno(Date giorno) {
		FinderPath finderPath = _finderPathCountByGiorno;

		Object[] finderArgs = new Object[] {_getTime(giorno)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNO_GIORNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
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

	private static final String _FINDER_COLUMN_GIORNO_GIORNO_1 =
		"verificaDato.giorno IS NULL";

	private static final String _FINDER_COLUMN_GIORNO_GIORNO_2 =
		"verificaDato.giorno = ?";

	private FinderPath _finderPathWithPaginationFindByGiornoZona;
	private FinderPath _finderPathWithoutPaginationFindByGiornoZona;
	private FinderPath _finderPathCountByGiornoZona;

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(Date giorno, String zona) {
		return findByGiornoZona(
			giorno, zona, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end) {

		return findByGiornoZona(giorno, zona, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiornoZona(
			giorno, zona, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		zona = Objects.toString(zona, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGiornoZona;
			finderArgs = new Object[] {_getTime(giorno), zona};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGiornoZona;
			finderArgs = new Object[] {
				_getTime(giorno), zona, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_GIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_GIORNOZONA_ZONA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
				}

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZona_First(
			Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZona_First(
			giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZona_First(
		Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiornoZona(
			giorno, zona, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZona_Last(
			Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZona_Last(
			giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZona_Last(
		Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiornoZona(giorno, zona);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiornoZona(
			giorno, zona, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiornoZona_PrevAndNext(
			long id, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiornoZona_PrevAndNext(
				session, verificaDato, giorno, zona, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByGiornoZona_PrevAndNext(
				session, verificaDato, giorno, zona, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VerificaDato getByGiornoZona_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			query.append(_FINDER_COLUMN_GIORNOZONA_ZONA_3);
		}
		else {
			bindZona = true;

			query.append(_FINDER_COLUMN_GIORNOZONA_ZONA_2);
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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			qPos.add(zona);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	@Override
	public void removeByGiornoZona(Date giorno, String zona) {
		for (VerificaDato verificaDato :
				findByGiornoZona(
					giorno, zona, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiornoZona(Date giorno, String zona) {
		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByGiornoZona;

		Object[] finderArgs = new Object[] {_getTime(giorno), zona};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_GIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_GIORNOZONA_ZONA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
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

	private static final String _FINDER_COLUMN_GIORNOZONA_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_GIORNOZONA_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOZONA_ZONA_2 =
		"verificaDato.zona = ?";

	private static final String _FINDER_COLUMN_GIORNOZONA_ZONA_3 =
		"(verificaDato.zona IS NULL OR verificaDato.zona = '')";

	private FinderPath _finderPathWithPaginationFindByGiornoEvento;
	private FinderPath _finderPathWithoutPaginationFindByGiornoEvento;
	private FinderPath _finderPathCountByGiornoEvento;

	/**
	 * Returns all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(Date giorno, long evento) {
		return findByGiornoEvento(
			giorno, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end) {

		return findByGiornoEvento(giorno, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiornoEvento(
			giorno, evento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGiornoEvento;
			finderArgs = new Object[] {_getTime(giorno), evento};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGiornoEvento;
			finderArgs = new Object[] {
				_getTime(giorno), evento, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno()) ||
						(evento != verificaDato.getEvento())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_2);
			}

			query.append(_FINDER_COLUMN_GIORNOEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				qPos.add(evento);

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoEvento_First(
			Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoEvento_First(
			giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoEvento_First(
		Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiornoEvento(
			giorno, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoEvento_Last(
			Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoEvento_Last(
			giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoEvento_Last(
		Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiornoEvento(giorno, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiornoEvento(
			giorno, evento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiornoEvento_PrevAndNext(
			long id, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiornoEvento_PrevAndNext(
				session, verificaDato, giorno, evento, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByGiornoEvento_PrevAndNext(
				session, verificaDato, giorno, evento, orderByComparator,
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

	protected VerificaDato getByGiornoEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_2);
		}

		query.append(_FINDER_COLUMN_GIORNOEVENTO_EVENTO_2);

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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		qPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	@Override
	public void removeByGiornoEvento(Date giorno, long evento) {
		for (VerificaDato verificaDato :
				findByGiornoEvento(
					giorno, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiornoEvento(Date giorno, long evento) {
		FinderPath finderPath = _finderPathCountByGiornoEvento;

		Object[] finderArgs = new Object[] {_getTime(giorno), evento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_2);
			}

			query.append(_FINDER_COLUMN_GIORNOEVENTO_EVENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				qPos.add(evento);

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

	private static final String _FINDER_COLUMN_GIORNOEVENTO_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_GIORNOEVENTO_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOEVENTO_EVENTO_2 =
		"verificaDato.evento = ?";

	private FinderPath _finderPathWithPaginationFindByGiornoZonaEvento;
	private FinderPath _finderPathWithoutPaginationFindByGiornoZonaEvento;
	private FinderPath _finderPathCountByGiornoZonaEvento;

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		return findByGiornoZonaEvento(
			giorno, zona, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end) {

		return findByGiornoZonaEvento(giorno, zona, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiornoZonaEvento(
			giorno, zona, evento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		zona = Objects.toString(zona, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGiornoZonaEvento;
			finderArgs = new Object[] {_getTime(giorno), zona, evento};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGiornoZonaEvento;
			finderArgs = new Object[] {
				_getTime(giorno), zona, evento, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona()) ||
						(evento != verificaDato.getEvento())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2);
			}

			query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
				}

				qPos.add(evento);

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZonaEvento_First(
			Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZonaEvento_First(
			giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZonaEvento_First(
		Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiornoZonaEvento(
			giorno, zona, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZonaEvento_Last(
			Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZonaEvento_Last(
			giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giorno=");
		msg.append(giorno);

		msg.append(", zona=");
		msg.append(zona);

		msg.append(", evento=");
		msg.append(evento);

		msg.append("}");

		throw new NoSuchVerificaDatoException(msg.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZonaEvento_Last(
		Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiornoZonaEvento(giorno, zona, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiornoZonaEvento(
			giorno, zona, evento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiornoZonaEvento_PrevAndNext(
			long id, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiornoZonaEvento_PrevAndNext(
				session, verificaDato, giorno, zona, evento, orderByComparator,
				true);

			array[1] = verificaDato;

			array[2] = getByGiornoZonaEvento_PrevAndNext(
				session, verificaDato, giorno, zona, evento, orderByComparator,
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

	protected VerificaDato getByGiornoZonaEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno, String zona,
		long evento, OrderByComparator<VerificaDato> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3);
		}
		else {
			bindZona = true;

			query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2);
		}

		query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2);

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
			query.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGiorno) {
			qPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			qPos.add(zona);
		}

		qPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	@Override
	public void removeByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		for (VerificaDato verificaDato :
				findByGiornoZonaEvento(
					giorno, zona, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiornoZonaEvento(Date giorno, String zona, long evento) {
		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByGiornoZonaEvento;

		Object[] finderArgs = new Object[] {_getTime(giorno), zona, evento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2);
			}

			query.append(_FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiorno) {
					qPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					qPos.add(zona);
				}

				qPos.add(evento);

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

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2 =
		"verificaDato.zona = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3 =
		"(verificaDato.zona IS NULL OR verificaDato.zona = '') AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2 =
		"verificaDato.evento = ?";

	public VerificaDatoPersistenceImpl() {
		setModelClass(VerificaDato.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the verifica dato in the entity cache if it is enabled.
	 *
	 * @param verificaDato the verifica dato
	 */
	@Override
	public void cacheResult(VerificaDato verificaDato) {
		entityCache.putResult(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED, VerificaDatoImpl.class,
			verificaDato.getPrimaryKey(), verificaDato);

		verificaDato.resetOriginalValues();
	}

	/**
	 * Caches the verifica datos in the entity cache if it is enabled.
	 *
	 * @param verificaDatos the verifica datos
	 */
	@Override
	public void cacheResult(List<VerificaDato> verificaDatos) {
		for (VerificaDato verificaDato : verificaDatos) {
			if (entityCache.getResult(
					VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
					VerificaDatoImpl.class, verificaDato.getPrimaryKey()) ==
						null) {

				cacheResult(verificaDato);
			}
			else {
				verificaDato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all verifica datos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VerificaDatoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the verifica dato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VerificaDato verificaDato) {
		entityCache.removeResult(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED, VerificaDatoImpl.class,
			verificaDato.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VerificaDato> verificaDatos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VerificaDato verificaDato : verificaDatos) {
			entityCache.removeResult(
				VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
				VerificaDatoImpl.class, verificaDato.getPrimaryKey());
		}
	}

	/**
	 * Creates a new verifica dato with the primary key. Does not add the verifica dato to the database.
	 *
	 * @param id the primary key for the new verifica dato
	 * @return the new verifica dato
	 */
	@Override
	public VerificaDato create(long id) {
		VerificaDato verificaDato = new VerificaDatoImpl();

		verificaDato.setNew(true);
		verificaDato.setPrimaryKey(id);

		return verificaDato;
	}

	/**
	 * Removes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato remove(long id) throws NoSuchVerificaDatoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato remove(Serializable primaryKey)
		throws NoSuchVerificaDatoException {

		Session session = null;

		try {
			session = openSession();

			VerificaDato verificaDato = (VerificaDato)session.get(
				VerificaDatoImpl.class, primaryKey);

			if (verificaDato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVerificaDatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(verificaDato);
		}
		catch (NoSuchVerificaDatoException nsee) {
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
	protected VerificaDato removeImpl(VerificaDato verificaDato) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(verificaDato)) {
				verificaDato = (VerificaDato)session.get(
					VerificaDatoImpl.class, verificaDato.getPrimaryKeyObj());
			}

			if (verificaDato != null) {
				session.delete(verificaDato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (verificaDato != null) {
			clearCache(verificaDato);
		}

		return verificaDato;
	}

	@Override
	public VerificaDato updateImpl(VerificaDato verificaDato) {
		boolean isNew = verificaDato.isNew();

		if (!(verificaDato instanceof VerificaDatoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(verificaDato.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					verificaDato);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in verificaDato proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VerificaDato implementation " +
					verificaDato.getClass());
		}

		VerificaDatoModelImpl verificaDatoModelImpl =
			(VerificaDatoModelImpl)verificaDato;

		Session session = null;

		try {
			session = openSession();

			if (verificaDato.isNew()) {
				session.save(verificaDato);

				verificaDato.setNew(false);
			}
			else {
				verificaDato = (VerificaDato)session.merge(verificaDato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VerificaDatoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {verificaDatoModelImpl.getDocumento()};

			finderCache.removeResult(_finderPathCountByDocumento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumento, args);

			args = new Object[] {
				verificaDatoModelImpl.getDocumento(),
				verificaDatoModelImpl.getGiorno()
			};

			finderCache.removeResult(_finderPathCountByDocumentoGiorno, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentoGiorno, args);

			args = new Object[] {
				verificaDatoModelImpl.getDocumento(),
				verificaDatoModelImpl.getGiorno(),
				verificaDatoModelImpl.getEvento()
			};

			finderCache.removeResult(
				_finderPathCountByDocumentoGiornoEvento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentoGiornoEvento, args);

			args = new Object[] {
				verificaDatoModelImpl.getDocumento(),
				verificaDatoModelImpl.getGiorno(),
				verificaDatoModelImpl.getZona()
			};

			finderCache.removeResult(
				_finderPathCountByDocumentoGiornoZona, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentoGiornoZona, args);

			args = new Object[] {
				verificaDatoModelImpl.getDocumento(),
				verificaDatoModelImpl.getGiorno(),
				verificaDatoModelImpl.getZona(),
				verificaDatoModelImpl.getEvento()
			};

			finderCache.removeResult(
				_finderPathCountByDocumentoGiornoZonaEvento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento,
				args);

			args = new Object[] {verificaDatoModelImpl.getGiorno()};

			finderCache.removeResult(_finderPathCountByGiorno, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGiorno, args);

			args = new Object[] {
				verificaDatoModelImpl.getGiorno(),
				verificaDatoModelImpl.getZona()
			};

			finderCache.removeResult(_finderPathCountByGiornoZona, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGiornoZona, args);

			args = new Object[] {
				verificaDatoModelImpl.getGiorno(),
				verificaDatoModelImpl.getEvento()
			};

			finderCache.removeResult(_finderPathCountByGiornoEvento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGiornoEvento, args);

			args = new Object[] {
				verificaDatoModelImpl.getGiorno(),
				verificaDatoModelImpl.getZona(),
				verificaDatoModelImpl.getEvento()
			};

			finderCache.removeResult(_finderPathCountByGiornoZonaEvento, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGiornoZonaEvento, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalDocumento()
				};

				finderCache.removeResult(_finderPathCountByDocumento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumento, args);

				args = new Object[] {verificaDatoModelImpl.getDocumento()};

				finderCache.removeResult(_finderPathCountByDocumento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumento, args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentoGiorno.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalDocumento(),
					verificaDatoModelImpl.getOriginalGiorno()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiorno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiorno, args);

				args = new Object[] {
					verificaDatoModelImpl.getDocumento(),
					verificaDatoModelImpl.getGiorno()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiorno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiorno, args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentoGiornoEvento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalDocumento(),
					verificaDatoModelImpl.getOriginalGiorno(),
					verificaDatoModelImpl.getOriginalEvento()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiornoEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiornoEvento,
					args);

				args = new Object[] {
					verificaDatoModelImpl.getDocumento(),
					verificaDatoModelImpl.getGiorno(),
					verificaDatoModelImpl.getEvento()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiornoEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiornoEvento,
					args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentoGiornoZona.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalDocumento(),
					verificaDatoModelImpl.getOriginalGiorno(),
					verificaDatoModelImpl.getOriginalZona()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiornoZona, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiornoZona,
					args);

				args = new Object[] {
					verificaDatoModelImpl.getDocumento(),
					verificaDatoModelImpl.getGiorno(),
					verificaDatoModelImpl.getZona()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiornoZona, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiornoZona,
					args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalDocumento(),
					verificaDatoModelImpl.getOriginalGiorno(),
					verificaDatoModelImpl.getOriginalZona(),
					verificaDatoModelImpl.getOriginalEvento()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiornoZonaEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento,
					args);

				args = new Object[] {
					verificaDatoModelImpl.getDocumento(),
					verificaDatoModelImpl.getGiorno(),
					verificaDatoModelImpl.getZona(),
					verificaDatoModelImpl.getEvento()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoGiornoZonaEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento,
					args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGiorno.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalGiorno()
				};

				finderCache.removeResult(_finderPathCountByGiorno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiorno, args);

				args = new Object[] {verificaDatoModelImpl.getGiorno()};

				finderCache.removeResult(_finderPathCountByGiorno, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiorno, args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGiornoZona.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalGiorno(),
					verificaDatoModelImpl.getOriginalZona()
				};

				finderCache.removeResult(_finderPathCountByGiornoZona, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiornoZona, args);

				args = new Object[] {
					verificaDatoModelImpl.getGiorno(),
					verificaDatoModelImpl.getZona()
				};

				finderCache.removeResult(_finderPathCountByGiornoZona, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiornoZona, args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGiornoEvento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalGiorno(),
					verificaDatoModelImpl.getOriginalEvento()
				};

				finderCache.removeResult(_finderPathCountByGiornoEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiornoEvento, args);

				args = new Object[] {
					verificaDatoModelImpl.getGiorno(),
					verificaDatoModelImpl.getEvento()
				};

				finderCache.removeResult(_finderPathCountByGiornoEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiornoEvento, args);
			}

			if ((verificaDatoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGiornoZonaEvento.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					verificaDatoModelImpl.getOriginalGiorno(),
					verificaDatoModelImpl.getOriginalZona(),
					verificaDatoModelImpl.getOriginalEvento()
				};

				finderCache.removeResult(
					_finderPathCountByGiornoZonaEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiornoZonaEvento, args);

				args = new Object[] {
					verificaDatoModelImpl.getGiorno(),
					verificaDatoModelImpl.getZona(),
					verificaDatoModelImpl.getEvento()
				};

				finderCache.removeResult(
					_finderPathCountByGiornoZonaEvento, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGiornoZonaEvento, args);
			}
		}

		entityCache.putResult(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED, VerificaDatoImpl.class,
			verificaDato.getPrimaryKey(), verificaDato, false);

		verificaDato.resetOriginalValues();

		return verificaDato;
	}

	/**
	 * Returns the verifica dato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByPrimaryKey(primaryKey);

		if (verificaDato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVerificaDatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return verificaDato;
	}

	/**
	 * Returns the verifica dato with the primary key or throws a <code>NoSuchVerificaDatoException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato findByPrimaryKey(long id)
		throws NoSuchVerificaDatoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the verifica dato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verifica dato
	 * @return the verifica dato, or <code>null</code> if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED, VerificaDatoImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VerificaDato verificaDato = (VerificaDato)serializable;

		if (verificaDato == null) {
			Session session = null;

			try {
				session = openSession();

				verificaDato = (VerificaDato)session.get(
					VerificaDatoImpl.class, primaryKey);

				if (verificaDato != null) {
					cacheResult(verificaDato);
				}
				else {
					entityCache.putResult(
						VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
						VerificaDatoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
					VerificaDatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return verificaDato;
	}

	/**
	 * Returns the verifica dato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato, or <code>null</code> if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VerificaDato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VerificaDato> map =
			new HashMap<Serializable, VerificaDato>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VerificaDato verificaDato = fetchByPrimaryKey(primaryKey);

			if (verificaDato != null) {
				map.put(primaryKey, verificaDato);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
				VerificaDatoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VerificaDato)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_VERIFICADATO_WHERE_PKS_IN);

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

			for (VerificaDato verificaDato : (List<VerificaDato>)q.list()) {
				map.put(verificaDato.getPrimaryKeyObj(), verificaDato);

				cacheResult(verificaDato);

				uncachedPrimaryKeys.remove(verificaDato.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
					VerificaDatoImpl.class, primaryKey, nullModel);
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
	 * Returns all the verifica datos.
	 *
	 * @return the verifica datos
	 */
	@Override
	public List<VerificaDato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of verifica datos
	 */
	@Override
	public List<VerificaDato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verifica datos
	 */
	@Override
	public List<VerificaDato> findAll(
		int start, int end, OrderByComparator<VerificaDato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of verifica datos
	 */
	@Override
	public List<VerificaDato> findAll(
		int start, int end, OrderByComparator<VerificaDato> orderByComparator,
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

		List<VerificaDato> list = null;

		if (retrieveFromCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VERIFICADATO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VERIFICADATO;

				if (pagination) {
					sql = sql.concat(VerificaDatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VerificaDato>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VerificaDato>)QueryUtil.list(
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
	 * Removes all the verifica datos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VerificaDato verificaDato : findAll()) {
			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos.
	 *
	 * @return the number of verifica datos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VERIFICADATO);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VerificaDatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the verifica dato persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDocumento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumento",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumento",
			new String[] {Long.class.getName()},
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByDocumento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumento",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDocumentoGiorno = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentoGiorno",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumentoGiorno = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentoGiorno",
			new String[] {Long.class.getName(), Date.class.getName()},
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByDocumentoGiorno = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentoGiorno",
			new String[] {Long.class.getName(), Date.class.getName()});

		_finderPathWithPaginationFindByDocumentoGiornoEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDocumentoGiornoEvento",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumentoGiornoEvento =
			new FinderPath(
				VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
				VerificaDatoModelImpl.FINDER_CACHE_ENABLED,
				VerificaDatoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDocumentoGiornoEvento",
				new String[] {
					Long.class.getName(), Date.class.getName(),
					Long.class.getName()
				},
				VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
				VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
				VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
				VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
				VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
				VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByDocumentoGiornoEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoGiornoEvento",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByDocumentoGiornoZona = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentoGiornoZona",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumentoGiornoZona = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDocumentoGiornoZona",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName()
			},
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByDocumentoGiornoZona = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoGiornoZona",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByDocumentoGiornoZonaEvento =
			new FinderPath(
				VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
				VerificaDatoModelImpl.FINDER_CACHE_ENABLED,
				VerificaDatoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDocumentoGiornoZonaEvento",
				new String[] {
					Long.class.getName(), Date.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento =
			new FinderPath(
				VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
				VerificaDatoModelImpl.FINDER_CACHE_ENABLED,
				VerificaDatoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDocumentoGiornoZonaEvento",
				new String[] {
					Long.class.getName(), Date.class.getName(),
					String.class.getName(), Long.class.getName()
				},
				VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
				VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
				VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
				VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
				VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
				VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByDocumentoGiornoZonaEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoGiornoZonaEvento",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByGiorno = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiorno",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGiorno = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiorno",
			new String[] {Date.class.getName()},
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByGiorno = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiorno",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByGiornoZona = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiornoZona",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGiornoZona = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiornoZona",
			new String[] {Date.class.getName(), String.class.getName()},
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByGiornoZona = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiornoZona",
			new String[] {Date.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByGiornoEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiornoEvento",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGiornoEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiornoEvento",
			new String[] {Date.class.getName(), Long.class.getName()},
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByGiornoEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiornoEvento",
			new String[] {Date.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGiornoZonaEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiornoZonaEvento",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGiornoZonaEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, VerificaDatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiornoZonaEvento",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			VerificaDatoModelImpl.GIORNO_COLUMN_BITMASK |
			VerificaDatoModelImpl.ZONA_COLUMN_BITMASK |
			VerificaDatoModelImpl.EVENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.DOCUMENTO_COLUMN_BITMASK |
			VerificaDatoModelImpl.NOMEDATO_COLUMN_BITMASK |
			VerificaDatoModelImpl.PROGRESSIVO_COLUMN_BITMASK);

		_finderPathCountByGiornoZonaEvento = new FinderPath(
			VerificaDatoModelImpl.ENTITY_CACHE_ENABLED,
			VerificaDatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGiornoZonaEvento",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	}

	public void destroy() {
		entityCache.removeCache(VerificaDatoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_VERIFICADATO =
		"SELECT verificaDato FROM VerificaDato verificaDato";

	private static final String _SQL_SELECT_VERIFICADATO_WHERE_PKS_IN =
		"SELECT verificaDato FROM VerificaDato verificaDato WHERE id_ IN (";

	private static final String _SQL_SELECT_VERIFICADATO_WHERE =
		"SELECT verificaDato FROM VerificaDato verificaDato WHERE ";

	private static final String _SQL_COUNT_VERIFICADATO =
		"SELECT COUNT(verificaDato) FROM VerificaDato verificaDato";

	private static final String _SQL_COUNT_VERIFICADATO_WHERE =
		"SELECT COUNT(verificaDato) FROM VerificaDato verificaDato WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "verificaDato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VerificaDato exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VerificaDato exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VerificaDatoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}