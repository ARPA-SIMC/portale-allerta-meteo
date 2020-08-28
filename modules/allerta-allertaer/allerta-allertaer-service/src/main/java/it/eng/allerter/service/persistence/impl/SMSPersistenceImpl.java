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

package it.eng.allerter.service.persistence.impl;

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

import it.eng.allerter.exception.NoSuchSMSException;
import it.eng.allerter.model.SMS;
import it.eng.allerter.model.impl.SMSImpl;
import it.eng.allerter.model.impl.SMSModelImpl;
import it.eng.allerter.service.persistence.SMSPersistence;

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
 * The persistence implementation for the sms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class SMSPersistenceImpl
	extends BasePersistenceImpl<SMS> implements SMSPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SMSUtil</code> to access the sms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SMSImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDestinatario;
	private FinderPath _finderPathWithoutPaginationFindByDestinatario;
	private FinderPath _finderPathCountByDestinatario;

	/**
	 * Returns all the smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(long destinatario) {
		return findByDestinatario(
			destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(long destinatario, int start, int end) {
		return findByDestinatario(destinatario, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByDestinatario(
			destinatario, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDestinatario;
			finderArgs = new Object[] {destinatario};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDestinatario;
			finderArgs = new Object[] {
				destinatario, start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if ((destinatario != sms.getDestinatario())) {
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

			query.append(_SQL_SELECT_SMS_WHERE);

			query.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(destinatario);

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByDestinatario_First(
			long destinatario, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByDestinatario_First(destinatario, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("destinatario=");
		msg.append(destinatario);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByDestinatario_First(
		long destinatario, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByDestinatario(
			destinatario, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByDestinatario_Last(
			long destinatario, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByDestinatario_Last(destinatario, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("destinatario=");
		msg.append(destinatario);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByDestinatario_Last(
		long destinatario, OrderByComparator<SMS> orderByComparator) {

		int count = countByDestinatario(destinatario);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByDestinatario(
			destinatario, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByDestinatario_PrevAndNext(
				session, sms, destinatario, orderByComparator, true);

			array[1] = sms;

			array[2] = getByDestinatario_PrevAndNext(
				session, sms, destinatario, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByDestinatario_PrevAndNext(
		Session session, SMS sms, long destinatario,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		query.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(destinatario);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	@Override
	public void removeByDestinatario(long destinatario) {
		for (SMS sms :
				findByDestinatario(
					destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching smses
	 */
	@Override
	public int countByDestinatario(long destinatario) {
		FinderPath finderPath = _finderPathCountByDestinatario;

		Object[] finderArgs = new Object[] {destinatario};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SMS_WHERE);

			query.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(destinatario);

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

	private static final String _FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2 =
		"sms.destinatario = ?";

	private FinderPath _finderPathWithPaginationFindByNumero;
	private FinderPath _finderPathWithoutPaginationFindByNumero;
	private FinderPath _finderPathCountByNumero;

	/**
	 * Returns all the smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByNumero(String numero) {
		return findByNumero(numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByNumero(String numero, int start, int end) {
		return findByNumero(numero, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumero(
		String numero, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByNumero(numero, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumero(
		String numero, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		numero = Objects.toString(numero, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNumero;
			finderArgs = new Object[] {numero};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNumero;
			finderArgs = new Object[] {numero, start, end, orderByComparator};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!numero.equals(sms.getNumero())) {
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

			query.append(_SQL_SELECT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				query.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
			}
			else {
				bindNumero = true;

				query.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumero) {
					qPos.add(numero);
				}

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumero_First(
			String numero, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumero_First(numero, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numero=");
		msg.append(numero);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumero_First(
		String numero, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByNumero(numero, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumero_Last(
			String numero, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumero_Last(numero, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numero=");
		msg.append(numero);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumero_Last(
		String numero, OrderByComparator<SMS> orderByComparator) {

		int count = countByNumero(numero);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByNumero(
			numero, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByNumero_PrevAndNext(
			long id, String numero, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		numero = Objects.toString(numero, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByNumero_PrevAndNext(
				session, sms, numero, orderByComparator, true);

			array[1] = sms;

			array[2] = getByNumero_PrevAndNext(
				session, sms, numero, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByNumero_PrevAndNext(
		Session session, SMS sms, String numero,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		boolean bindNumero = false;

		if (numero.isEmpty()) {
			query.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
		}
		else {
			bindNumero = true;

			query.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNumero) {
			qPos.add(numero);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	@Override
	public void removeByNumero(String numero) {
		for (SMS sms :
				findByNumero(
					numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching smses
	 */
	@Override
	public int countByNumero(String numero) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumero;

		Object[] finderArgs = new Object[] {numero};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				query.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
			}
			else {
				bindNumero = true;

				query.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumero) {
					qPos.add(numero);
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

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_2 =
		"sms.numero = ?";

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_3 =
		"(sms.numero IS NULL OR sms.numero = '')";

	private FinderPath _finderPathWithPaginationFindByNumeroDataAck;
	private FinderPath _finderPathWithoutPaginationFindByNumeroDataAck;
	private FinderPath _finderPathCountByNumeroDataAck;

	/**
	 * Returns all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(String numero, Date dataAck) {
		return findByNumeroDataAck(
			numero, dataAck, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end) {

		return findByNumeroDataAck(numero, dataAck, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByNumeroDataAck(
			numero, dataAck, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		numero = Objects.toString(numero, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNumeroDataAck;
			finderArgs = new Object[] {numero, _getTime(dataAck)};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNumeroDataAck;
			finderArgs = new Object[] {
				numero, _getTime(dataAck), start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!numero.equals(sms.getNumero()) ||
						!Objects.equals(dataAck, sms.getDataAck())) {

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

			query.append(_SQL_SELECT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				query.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_3);
			}
			else {
				bindNumero = true;

				query.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_2);
			}

			boolean bindDataAck = false;

			if (dataAck == null) {
				query.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_1);
			}
			else {
				bindDataAck = true;

				query.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumero) {
					qPos.add(numero);
				}

				if (bindDataAck) {
					qPos.add(new Timestamp(dataAck.getTime()));
				}

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumeroDataAck_First(
			String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumeroDataAck_First(
			numero, dataAck, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numero=");
		msg.append(numero);

		msg.append(", dataAck=");
		msg.append(dataAck);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumeroDataAck_First(
		String numero, Date dataAck, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByNumeroDataAck(
			numero, dataAck, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumeroDataAck_Last(
			String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumeroDataAck_Last(numero, dataAck, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numero=");
		msg.append(numero);

		msg.append(", dataAck=");
		msg.append(dataAck);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumeroDataAck_Last(
		String numero, Date dataAck, OrderByComparator<SMS> orderByComparator) {

		int count = countByNumeroDataAck(numero, dataAck);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByNumeroDataAck(
			numero, dataAck, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByNumeroDataAck_PrevAndNext(
			long id, String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		numero = Objects.toString(numero, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByNumeroDataAck_PrevAndNext(
				session, sms, numero, dataAck, orderByComparator, true);

			array[1] = sms;

			array[2] = getByNumeroDataAck_PrevAndNext(
				session, sms, numero, dataAck, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByNumeroDataAck_PrevAndNext(
		Session session, SMS sms, String numero, Date dataAck,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		boolean bindNumero = false;

		if (numero.isEmpty()) {
			query.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_3);
		}
		else {
			bindNumero = true;

			query.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_2);
		}

		boolean bindDataAck = false;

		if (dataAck == null) {
			query.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_1);
		}
		else {
			bindDataAck = true;

			query.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_2);
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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNumero) {
			qPos.add(numero);
		}

		if (bindDataAck) {
			qPos.add(new Timestamp(dataAck.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where numero = &#63; and dataAck = &#63; from the database.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 */
	@Override
	public void removeByNumeroDataAck(String numero, Date dataAck) {
		for (SMS sms :
				findByNumeroDataAck(
					numero, dataAck, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the number of matching smses
	 */
	@Override
	public int countByNumeroDataAck(String numero, Date dataAck) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumeroDataAck;

		Object[] finderArgs = new Object[] {numero, _getTime(dataAck)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				query.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_3);
			}
			else {
				bindNumero = true;

				query.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_2);
			}

			boolean bindDataAck = false;

			if (dataAck == null) {
				query.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_1);
			}
			else {
				bindDataAck = true;

				query.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumero) {
					qPos.add(numero);
				}

				if (bindDataAck) {
					qPos.add(new Timestamp(dataAck.getTime()));
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

	private static final String _FINDER_COLUMN_NUMERODATAACK_NUMERO_2 =
		"sms.numero = ? AND ";

	private static final String _FINDER_COLUMN_NUMERODATAACK_NUMERO_3 =
		"(sms.numero IS NULL OR sms.numero = '') AND ";

	private static final String _FINDER_COLUMN_NUMERODATAACK_DATAACK_1 =
		"sms.dataAck IS NULL";

	private static final String _FINDER_COLUMN_NUMERODATAACK_DATAACK_2 =
		"sms.dataAck = ?";

	private FinderPath _finderPathWithPaginationFindByInvio;
	private FinderPath _finderPathWithoutPaginationFindByInvio;
	private FinderPath _finderPathCountByInvio;

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByInvio(String tipo, String sottotipo, long param) {
		return findByInvio(
			tipo, sottotipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end) {

		return findByInvio(tipo, sottotipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByInvio;
			finderArgs = new Object[] {tipo, sottotipo, param};
		}
		else {
			finderPath = _finderPathWithPaginationFindByInvio;
			finderArgs = new Object[] {
				tipo, sottotipo, param, start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!tipo.equals(sms.getTipo()) ||
						!sottotipo.equals(sms.getSottotipo()) ||
						(param != sms.getParam())) {

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

			query.append(_SQL_SELECT_SMS_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_INVIO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_INVIO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				query.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				query.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_2);
			}

			query.append(_FINDER_COLUMN_INVIO_PARAM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindSottotipo) {
					qPos.add(sottotipo);
				}

				qPos.add(param);

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByInvio_First(
			String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByInvio_First(tipo, sottotipo, param, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", sottotipo=");
		msg.append(sottotipo);

		msg.append(", param=");
		msg.append(param);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByInvio_First(
		String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByInvio(
			tipo, sottotipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByInvio_Last(
			String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByInvio_Last(tipo, sottotipo, param, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", sottotipo=");
		msg.append(sottotipo);

		msg.append(", param=");
		msg.append(param);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator) {

		int count = countByInvio(tipo, sottotipo, param);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByInvio(
			tipo, sottotipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByInvio_PrevAndNext(
				session, sms, tipo, sottotipo, param, orderByComparator, true);

			array[1] = sms;

			array[2] = getByInvio_PrevAndNext(
				session, sms, tipo, sottotipo, param, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByInvio_PrevAndNext(
		Session session, SMS sms, String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_INVIO_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_INVIO_TIPO_2);
		}

		boolean bindSottotipo = false;

		if (sottotipo.isEmpty()) {
			query.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_3);
		}
		else {
			bindSottotipo = true;

			query.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_2);
		}

		query.append(_FINDER_COLUMN_INVIO_PARAM_2);

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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		if (bindSottotipo) {
			qPos.add(sottotipo);
		}

		qPos.add(param);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	@Override
	public void removeByInvio(String tipo, String sottotipo, long param) {
		for (SMS sms :
				findByInvio(
					tipo, sottotipo, param, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	@Override
	public int countByInvio(String tipo, String sottotipo, long param) {
		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		FinderPath finderPath = _finderPathCountByInvio;

		Object[] finderArgs = new Object[] {tipo, sottotipo, param};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SMS_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_INVIO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_INVIO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				query.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				query.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_2);
			}

			query.append(_FINDER_COLUMN_INVIO_PARAM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindSottotipo) {
					qPos.add(sottotipo);
				}

				qPos.add(param);

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

	private static final String _FINDER_COLUMN_INVIO_TIPO_2 =
		"sms.tipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_TIPO_3 =
		"(sms.tipo IS NULL OR sms.tipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_2 =
		"sms.sottotipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_3 =
		"(sms.sottotipo IS NULL OR sms.sottotipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_PARAM_2 = "sms.param = ?";

	private FinderPath _finderPathWithPaginationFindByTipoSottotipo;
	private FinderPath _finderPathWithoutPaginationFindByTipoSottotipo;
	private FinderPath _finderPathCountByTipoSottotipo;

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(String tipo, String sottotipo) {
		return findByTipoSottotipo(
			tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end) {

		return findByTipoSottotipo(tipo, sottotipo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTipoSottotipo;
			finderArgs = new Object[] {tipo, sottotipo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTipoSottotipo;
			finderArgs = new Object[] {
				tipo, sottotipo, start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!tipo.equals(sms.getTipo()) ||
						!sottotipo.equals(sms.getSottotipo())) {

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

			query.append(_SQL_SELECT_SMS_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindSottotipo) {
					qPos.add(sottotipo);
				}

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoSottotipo_First(
			String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", sottotipo=");
		msg.append(sottotipo);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByTipoSottotipo(
			tipo, sottotipo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoSottotipo_Last(tipo, sottotipo, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", sottotipo=");
		msg.append(sottotipo);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator) {

		int count = countByTipoSottotipo(tipo, sottotipo);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByTipoSottotipo(
			tipo, sottotipo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByTipoSottotipo_PrevAndNext(
				session, sms, tipo, sottotipo, orderByComparator, true);

			array[1] = sms;

			array[2] = getByTipoSottotipo_PrevAndNext(
				session, sms, tipo, sottotipo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByTipoSottotipo_PrevAndNext(
		Session session, SMS sms, String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2);
		}

		boolean bindSottotipo = false;

		if (sottotipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3);
		}
		else {
			bindSottotipo = true;

			query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2);
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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		if (bindSottotipo) {
			qPos.add(sottotipo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	@Override
	public void removeByTipoSottotipo(String tipo, String sottotipo) {
		for (SMS sms :
				findByTipoSottotipo(
					tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching smses
	 */
	@Override
	public int countByTipoSottotipo(String tipo, String sottotipo) {
		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		FinderPath finderPath = _finderPathCountByTipoSottotipo;

		Object[] finderArgs = new Object[] {tipo, sottotipo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SMS_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				query.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				if (bindSottotipo) {
					qPos.add(sottotipo);
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

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2 =
		"sms.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3 =
		"(sms.tipo IS NULL OR sms.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2 =
		"sms.sottotipo = ?";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3 =
		"(sms.sottotipo IS NULL OR sms.sottotipo = '')";

	private FinderPath _finderPathWithPaginationFindByTipoParam;
	private FinderPath _finderPathWithoutPaginationFindByTipoParam;
	private FinderPath _finderPathCountByTipoParam;

	/**
	 * Returns all the smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(String tipo, long param) {
		return findByTipoParam(
			tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(
		String tipo, long param, int start, int end) {

		return findByTipoParam(tipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByTipoParam(
			tipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		tipo = Objects.toString(tipo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTipoParam;
			finderArgs = new Object[] {tipo, param};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTipoParam;
			finderArgs = new Object[] {
				tipo, param, start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!tipo.equals(sms.getTipo()) ||
						(param != sms.getParam())) {

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

			query.append(_SQL_SELECT_SMS_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOPARAM_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOPARAM_TIPO_2);
			}

			query.append(_FINDER_COLUMN_TIPOPARAM_PARAM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				qPos.add(param);

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoParam_First(
			String tipo, long param, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoParam_First(tipo, param, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", param=");
		msg.append(param);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoParam_First(
		String tipo, long param, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByTipoParam(tipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoParam_Last(
			String tipo, long param, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoParam_Last(tipo, param, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", param=");
		msg.append(param);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoParam_Last(
		String tipo, long param, OrderByComparator<SMS> orderByComparator) {

		int count = countByTipoParam(tipo, param);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByTipoParam(
			tipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		tipo = Objects.toString(tipo, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByTipoParam_PrevAndNext(
				session, sms, tipo, param, orderByComparator, true);

			array[1] = sms;

			array[2] = getByTipoParam_PrevAndNext(
				session, sms, tipo, param, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByTipoParam_PrevAndNext(
		Session session, SMS sms, String tipo, long param,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			query.append(_FINDER_COLUMN_TIPOPARAM_TIPO_3);
		}
		else {
			bindTipo = true;

			query.append(_FINDER_COLUMN_TIPOPARAM_TIPO_2);
		}

		query.append(_FINDER_COLUMN_TIPOPARAM_PARAM_2);

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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipo) {
			qPos.add(tipo);
		}

		qPos.add(param);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	@Override
	public void removeByTipoParam(String tipo, long param) {
		for (SMS sms :
				findByTipoParam(
					tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	@Override
	public int countByTipoParam(String tipo, long param) {
		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = _finderPathCountByTipoParam;

		Object[] finderArgs = new Object[] {tipo, param};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SMS_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				query.append(_FINDER_COLUMN_TIPOPARAM_TIPO_3);
			}
			else {
				bindTipo = true;

				query.append(_FINDER_COLUMN_TIPOPARAM_TIPO_2);
			}

			query.append(_FINDER_COLUMN_TIPOPARAM_PARAM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipo) {
					qPos.add(tipo);
				}

				qPos.add(param);

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

	private static final String _FINDER_COLUMN_TIPOPARAM_TIPO_2 =
		"sms.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_TIPO_3 =
		"(sms.tipo IS NULL OR sms.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_PARAM_2 =
		"sms.param = ?";

	private FinderPath _finderPathWithPaginationFindByTimestamp;
	private FinderPath _finderPathWithoutPaginationFindByTimestamp;
	private FinderPath _finderPathCountByTimestamp;

	/**
	 * Returns all the smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(String timestamp) {
		return findByTimestamp(
			timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(String timestamp, int start, int end) {
		return findByTimestamp(timestamp, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByTimestamp(timestamp, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		timestamp = Objects.toString(timestamp, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTimestamp;
			finderArgs = new Object[] {timestamp};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTimestamp;
			finderArgs = new Object[] {
				timestamp, start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!timestamp.equals(sms.getTimestamp())) {
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

			query.append(_SQL_SELECT_SMS_WHERE);

			boolean bindTimestamp = false;

			if (timestamp.isEmpty()) {
				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3);
			}
			else {
				bindTimestamp = true;

				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTimestamp) {
					qPos.add(timestamp);
				}

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTimestamp_First(
			String timestamp, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTimestamp_First(timestamp, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTimestamp_First(
		String timestamp, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByTimestamp(timestamp, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTimestamp_Last(
			String timestamp, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTimestamp_Last(timestamp, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timestamp=");
		msg.append(timestamp);

		msg.append("}");

		throw new NoSuchSMSException(msg.toString());
	}

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTimestamp_Last(
		String timestamp, OrderByComparator<SMS> orderByComparator) {

		int count = countByTimestamp(timestamp);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByTimestamp(
			timestamp, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where timestamp = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByTimestamp_PrevAndNext(
			long id, String timestamp, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		timestamp = Objects.toString(timestamp, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByTimestamp_PrevAndNext(
				session, sms, timestamp, orderByComparator, true);

			array[1] = sms;

			array[2] = getByTimestamp_PrevAndNext(
				session, sms, timestamp, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByTimestamp_PrevAndNext(
		Session session, SMS sms, String timestamp,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SMS_WHERE);

		boolean bindTimestamp = false;

		if (timestamp.isEmpty()) {
			query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3);
		}
		else {
			bindTimestamp = true;

			query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
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
			query.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTimestamp) {
			qPos.add(timestamp);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 */
	@Override
	public void removeByTimestamp(String timestamp) {
		for (SMS sms :
				findByTimestamp(
					timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching smses
	 */
	@Override
	public int countByTimestamp(String timestamp) {
		timestamp = Objects.toString(timestamp, "");

		FinderPath finderPath = _finderPathCountByTimestamp;

		Object[] finderArgs = new Object[] {timestamp};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SMS_WHERE);

			boolean bindTimestamp = false;

			if (timestamp.isEmpty()) {
				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3);
			}
			else {
				bindTimestamp = true;

				query.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTimestamp) {
					qPos.add(timestamp);
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

	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2 =
		"sms.timestamp = ?";

	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3 =
		"(sms.timestamp IS NULL OR sms.timestamp = '')";

	public SMSPersistenceImpl() {
		setModelClass(SMS.class);

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
	 * Caches the sms in the entity cache if it is enabled.
	 *
	 * @param sms the sms
	 */
	@Override
	public void cacheResult(SMS sms) {
		entityCache.putResult(
			SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
			sms.getPrimaryKey(), sms);

		sms.resetOriginalValues();
	}

	/**
	 * Caches the smses in the entity cache if it is enabled.
	 *
	 * @param smses the smses
	 */
	@Override
	public void cacheResult(List<SMS> smses) {
		for (SMS sms : smses) {
			if (entityCache.getResult(
					SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
					sms.getPrimaryKey()) == null) {

				cacheResult(sms);
			}
			else {
				sms.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all smses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SMSImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SMS sms) {
		entityCache.removeResult(
			SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
			sms.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SMS> smses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SMS sms : smses) {
			entityCache.removeResult(
				SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
				sms.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	@Override
	public SMS create(long id) {
		SMS sms = new SMSImpl();

		sms.setNew(true);
		sms.setPrimaryKey(id);

		return sms;
	}

	/**
	 * Removes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS remove(long id) throws NoSuchSMSException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sms
	 * @return the sms that was removed
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS remove(Serializable primaryKey) throws NoSuchSMSException {
		Session session = null;

		try {
			session = openSession();

			SMS sms = (SMS)session.get(SMSImpl.class, primaryKey);

			if (sms == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSMSException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sms);
		}
		catch (NoSuchSMSException nsee) {
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
	protected SMS removeImpl(SMS sms) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sms)) {
				sms = (SMS)session.get(SMSImpl.class, sms.getPrimaryKeyObj());
			}

			if (sms != null) {
				session.delete(sms);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sms != null) {
			clearCache(sms);
		}

		return sms;
	}

	@Override
	public SMS updateImpl(SMS sms) {
		boolean isNew = sms.isNew();

		if (!(sms instanceof SMSModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sms.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(sms);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sms proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SMS implementation " +
					sms.getClass());
		}

		SMSModelImpl smsModelImpl = (SMSModelImpl)sms;

		Session session = null;

		try {
			session = openSession();

			if (sms.isNew()) {
				session.save(sms);

				sms.setNew(false);
			}
			else {
				sms = (SMS)session.merge(sms);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SMSModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {smsModelImpl.getDestinatario()};

			finderCache.removeResult(_finderPathCountByDestinatario, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDestinatario, args);

			args = new Object[] {smsModelImpl.getNumero()};

			finderCache.removeResult(_finderPathCountByNumero, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNumero, args);

			args = new Object[] {
				smsModelImpl.getNumero(), smsModelImpl.getDataAck()
			};

			finderCache.removeResult(_finderPathCountByNumeroDataAck, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNumeroDataAck, args);

			args = new Object[] {
				smsModelImpl.getTipo(), smsModelImpl.getSottotipo(),
				smsModelImpl.getParam()
			};

			finderCache.removeResult(_finderPathCountByInvio, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByInvio, args);

			args = new Object[] {
				smsModelImpl.getTipo(), smsModelImpl.getSottotipo()
			};

			finderCache.removeResult(_finderPathCountByTipoSottotipo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoSottotipo, args);

			args = new Object[] {
				smsModelImpl.getTipo(), smsModelImpl.getParam()
			};

			finderCache.removeResult(_finderPathCountByTipoParam, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoParam, args);

			args = new Object[] {smsModelImpl.getTimestamp()};

			finderCache.removeResult(_finderPathCountByTimestamp, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTimestamp, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDestinatario.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					smsModelImpl.getOriginalDestinatario()
				};

				finderCache.removeResult(_finderPathCountByDestinatario, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDestinatario, args);

				args = new Object[] {smsModelImpl.getDestinatario()};

				finderCache.removeResult(_finderPathCountByDestinatario, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDestinatario, args);
			}

			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNumero.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {smsModelImpl.getOriginalNumero()};

				finderCache.removeResult(_finderPathCountByNumero, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNumero, args);

				args = new Object[] {smsModelImpl.getNumero()};

				finderCache.removeResult(_finderPathCountByNumero, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNumero, args);
			}

			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNumeroDataAck.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					smsModelImpl.getOriginalNumero(),
					smsModelImpl.getOriginalDataAck()
				};

				finderCache.removeResult(_finderPathCountByNumeroDataAck, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNumeroDataAck, args);

				args = new Object[] {
					smsModelImpl.getNumero(), smsModelImpl.getDataAck()
				};

				finderCache.removeResult(_finderPathCountByNumeroDataAck, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNumeroDataAck, args);
			}

			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByInvio.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					smsModelImpl.getOriginalTipo(),
					smsModelImpl.getOriginalSottotipo(),
					smsModelImpl.getOriginalParam()
				};

				finderCache.removeResult(_finderPathCountByInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvio, args);

				args = new Object[] {
					smsModelImpl.getTipo(), smsModelImpl.getSottotipo(),
					smsModelImpl.getParam()
				};

				finderCache.removeResult(_finderPathCountByInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvio, args);
			}

			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoSottotipo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					smsModelImpl.getOriginalTipo(),
					smsModelImpl.getOriginalSottotipo()
				};

				finderCache.removeResult(_finderPathCountByTipoSottotipo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoSottotipo, args);

				args = new Object[] {
					smsModelImpl.getTipo(), smsModelImpl.getSottotipo()
				};

				finderCache.removeResult(_finderPathCountByTipoSottotipo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoSottotipo, args);
			}

			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoParam.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					smsModelImpl.getOriginalTipo(),
					smsModelImpl.getOriginalParam()
				};

				finderCache.removeResult(_finderPathCountByTipoParam, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoParam, args);

				args = new Object[] {
					smsModelImpl.getTipo(), smsModelImpl.getParam()
				};

				finderCache.removeResult(_finderPathCountByTipoParam, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoParam, args);
			}

			if ((smsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTimestamp.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					smsModelImpl.getOriginalTimestamp()
				};

				finderCache.removeResult(_finderPathCountByTimestamp, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTimestamp, args);

				args = new Object[] {smsModelImpl.getTimestamp()};

				finderCache.removeResult(_finderPathCountByTimestamp, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTimestamp, args);
			}
		}

		entityCache.putResult(
			SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
			sms.getPrimaryKey(), sms, false);

		sms.resetOriginalValues();

		return sms;
	}

	/**
	 * Returns the sms with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sms
	 * @return the sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSMSException {

		SMS sms = fetchByPrimaryKey(primaryKey);

		if (sms == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSMSException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sms;
	}

	/**
	 * Returns the sms with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS findByPrimaryKey(long id) throws NoSuchSMSException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sms
	 * @return the sms, or <code>null</code> if a sms with the primary key could not be found
	 */
	@Override
	public SMS fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SMS sms = (SMS)serializable;

		if (sms == null) {
			Session session = null;

			try {
				session = openSession();

				sms = (SMS)session.get(SMSImpl.class, primaryKey);

				if (sms != null) {
					cacheResult(sms);
				}
				else {
					entityCache.putResult(
						SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sms;
	}

	/**
	 * Returns the sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms, or <code>null</code> if a sms with the primary key could not be found
	 */
	@Override
	public SMS fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, SMS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SMS> map = new HashMap<Serializable, SMS>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SMS sms = fetchByPrimaryKey(primaryKey);

			if (sms != null) {
				map.put(primaryKey, sms);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SMS)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_SMS_WHERE_PKS_IN);

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

			for (SMS sms : (List<SMS>)q.list()) {
				map.put(sms.getPrimaryKeyObj(), sms);

				cacheResult(sms);

				uncachedPrimaryKeys.remove(sms.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					SMSModelImpl.ENTITY_CACHE_ENABLED, SMSImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the smses.
	 *
	 * @return the smses
	 */
	@Override
	public List<SMS> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of smses
	 */
	@Override
	public List<SMS> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smses
	 */
	@Override
	public List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of smses
	 */
	@Override
	public List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator,
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

		List<SMS> list = null;

		if (retrieveFromCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SMS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SMS;

				if (pagination) {
					sql = sql.concat(SMSModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(
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
	 * Removes all the smses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SMS sms : findAll()) {
			remove(sms);
		}
	}

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SMS);

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
		return SMSModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sms persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDestinatario = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDestinatario",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDestinatario = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDestinatario",
			new String[] {Long.class.getName()},
			SMSModelImpl.DESTINATARIO_COLUMN_BITMASK);

		_finderPathCountByDestinatario = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDestinatario",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByNumero = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumero",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNumero = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumero",
			new String[] {String.class.getName()},
			SMSModelImpl.NUMERO_COLUMN_BITMASK);

		_finderPathCountByNumero = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumero",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByNumeroDataAck = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumeroDataAck",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNumeroDataAck = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumeroDataAck",
			new String[] {String.class.getName(), Date.class.getName()},
			SMSModelImpl.NUMERO_COLUMN_BITMASK |
			SMSModelImpl.DATAACK_COLUMN_BITMASK);

		_finderPathCountByNumeroDataAck = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumeroDataAck",
			new String[] {String.class.getName(), Date.class.getName()});

		_finderPathWithPaginationFindByInvio = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByInvio = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			SMSModelImpl.TIPO_COLUMN_BITMASK |
			SMSModelImpl.SOTTOTIPO_COLUMN_BITMASK |
			SMSModelImpl.PARAM_COLUMN_BITMASK);

		_finderPathCountByInvio = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByTipoSottotipo = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoSottotipo",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoSottotipo = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoSottotipo",
			new String[] {String.class.getName(), String.class.getName()},
			SMSModelImpl.TIPO_COLUMN_BITMASK |
			SMSModelImpl.SOTTOTIPO_COLUMN_BITMASK);

		_finderPathCountByTipoSottotipo = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoSottotipo",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByTipoParam = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoParam",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoParam = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoParam",
			new String[] {String.class.getName(), Long.class.getName()},
			SMSModelImpl.TIPO_COLUMN_BITMASK |
			SMSModelImpl.PARAM_COLUMN_BITMASK);

		_finderPathCountByTipoParam = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoParam",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByTimestamp = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimestamp",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTimestamp = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimestamp",
			new String[] {String.class.getName()},
			SMSModelImpl.TIMESTAMP_COLUMN_BITMASK);

		_finderPathCountByTimestamp = new FinderPath(
			SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimestamp",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(SMSImpl.class.getName());
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

	private static final String _SQL_SELECT_SMS = "SELECT sms FROM SMS sms";

	private static final String _SQL_SELECT_SMS_WHERE_PKS_IN =
		"SELECT sms FROM SMS sms WHERE id_ IN (";

	private static final String _SQL_SELECT_SMS_WHERE =
		"SELECT sms FROM SMS sms WHERE ";

	private static final String _SQL_COUNT_SMS =
		"SELECT COUNT(sms) FROM SMS sms";

	private static final String _SQL_COUNT_SMS_WHERE =
		"SELECT COUNT(sms) FROM SMS sms WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sms.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SMS exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SMS exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SMSPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}