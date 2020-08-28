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

import it.eng.allerter.exception.NoSuchEmailException;
import it.eng.allerter.model.Email;
import it.eng.allerter.model.impl.EmailImpl;
import it.eng.allerter.model.impl.EmailModelImpl;
import it.eng.allerter.service.persistence.EmailPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
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
 * The persistence implementation for the email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class EmailPersistenceImpl
	extends BasePersistenceImpl<Email> implements EmailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmailUtil</code> to access the email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmailImpl.class.getName();

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
	 * Returns all the emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByDestinatario(long destinatario) {
		return findByDestinatario(
			destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByDestinatario(
		long destinatario, int start, int end) {

		return findByDestinatario(destinatario, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByDestinatario(
			destinatario, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

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

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if ((destinatario != email.getDestinatario())) {
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

			query.append(_SQL_SELECT_EMAIL_WHERE);

			query.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(destinatario);

				if (!pagination) {
					list = (List<Email>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(
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
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByDestinatario_First(
			long destinatario, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByDestinatario_First(
			destinatario, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("destinatario=");
		msg.append(destinatario);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByDestinatario_First(
		long destinatario, OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByDestinatario(
			destinatario, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByDestinatario_Last(
			long destinatario, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByDestinatario_Last(destinatario, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("destinatario=");
		msg.append(destinatario);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByDestinatario_Last(
		long destinatario, OrderByComparator<Email> orderByComparator) {

		int count = countByDestinatario(destinatario);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByDestinatario(
			destinatario, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByDestinatario_PrevAndNext(
				session, email, destinatario, orderByComparator, true);

			array[1] = email;

			array[2] = getByDestinatario_PrevAndNext(
				session, email, destinatario, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByDestinatario_PrevAndNext(
		Session session, Email email, long destinatario,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAIL_WHERE);

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
			query.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(destinatario);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Email> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	@Override
	public void removeByDestinatario(long destinatario) {
		for (Email email :
				findByDestinatario(
					destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching emails
	 */
	@Override
	public int countByDestinatario(long destinatario) {
		FinderPath finderPath = _finderPathCountByDestinatario;

		Object[] finderArgs = new Object[] {destinatario};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAIL_WHERE);

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
		"email.destinatario = ?";

	private FinderPath _finderPathWithPaginationFindByIndirizzo;
	private FinderPath _finderPathWithoutPaginationFindByIndirizzo;
	private FinderPath _finderPathCountByIndirizzo;

	/**
	 * Returns all the emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(String indirizzo) {
		return findByIndirizzo(
			indirizzo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(String indirizzo, int start, int end) {
		return findByIndirizzo(indirizzo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByIndirizzo(indirizzo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

		indirizzo = Objects.toString(indirizzo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByIndirizzo;
			finderArgs = new Object[] {indirizzo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByIndirizzo;
			finderArgs = new Object[] {
				indirizzo, start, end, orderByComparator
			};
		}

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!indirizzo.equals(email.getIndirizzo())) {
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

			query.append(_SQL_SELECT_EMAIL_WHERE);

			boolean bindIndirizzo = false;

			if (indirizzo.isEmpty()) {
				query.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3);
			}
			else {
				bindIndirizzo = true;

				query.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIndirizzo) {
					qPos.add(indirizzo);
				}

				if (!pagination) {
					list = (List<Email>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(
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
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByIndirizzo_First(
			String indirizzo, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByIndirizzo_First(indirizzo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("indirizzo=");
		msg.append(indirizzo);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByIndirizzo_First(
		String indirizzo, OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByIndirizzo(indirizzo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByIndirizzo_Last(
			String indirizzo, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByIndirizzo_Last(indirizzo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("indirizzo=");
		msg.append(indirizzo);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByIndirizzo_Last(
		String indirizzo, OrderByComparator<Email> orderByComparator) {

		int count = countByIndirizzo(indirizzo);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByIndirizzo(
			indirizzo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where indirizzo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByIndirizzo_PrevAndNext(
			long id, String indirizzo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		indirizzo = Objects.toString(indirizzo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByIndirizzo_PrevAndNext(
				session, email, indirizzo, orderByComparator, true);

			array[1] = email;

			array[2] = getByIndirizzo_PrevAndNext(
				session, email, indirizzo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByIndirizzo_PrevAndNext(
		Session session, Email email, String indirizzo,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAIL_WHERE);

		boolean bindIndirizzo = false;

		if (indirizzo.isEmpty()) {
			query.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3);
		}
		else {
			bindIndirizzo = true;

			query.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2);
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
			query.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIndirizzo) {
			qPos.add(indirizzo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Email> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where indirizzo = &#63; from the database.
	 *
	 * @param indirizzo the indirizzo
	 */
	@Override
	public void removeByIndirizzo(String indirizzo) {
		for (Email email :
				findByIndirizzo(
					indirizzo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the number of matching emails
	 */
	@Override
	public int countByIndirizzo(String indirizzo) {
		indirizzo = Objects.toString(indirizzo, "");

		FinderPath finderPath = _finderPathCountByIndirizzo;

		Object[] finderArgs = new Object[] {indirizzo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAIL_WHERE);

			boolean bindIndirizzo = false;

			if (indirizzo.isEmpty()) {
				query.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3);
			}
			else {
				bindIndirizzo = true;

				query.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIndirizzo) {
					qPos.add(indirizzo);
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

	private static final String _FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2 =
		"email.indirizzo = ?";

	private static final String _FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3 =
		"(email.indirizzo IS NULL OR email.indirizzo = '')";

	private FinderPath _finderPathWithPaginationFindByInvio;
	private FinderPath _finderPathWithoutPaginationFindByInvio;
	private FinderPath _finderPathCountByInvio;

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByInvio(String tipo, String sottotipo, long param) {
		return findByInvio(
			tipo, sottotipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end) {

		return findByInvio(tipo, sottotipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

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

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!tipo.equals(email.getTipo()) ||
						!sottotipo.equals(email.getSottotipo()) ||
						(param != email.getParam())) {

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

			query.append(_SQL_SELECT_EMAIL_WHERE);

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
				query.append(EmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<Email>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(
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
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByInvio_First(
			String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByInvio_First(
			tipo, sottotipo, param, orderByComparator);

		if (email != null) {
			return email;
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

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByInvio_First(
		String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByInvio(
			tipo, sottotipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByInvio_Last(
			String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByInvio_Last(
			tipo, sottotipo, param, orderByComparator);

		if (email != null) {
			return email;
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

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator) {

		int count = countByInvio(tipo, sottotipo, param);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByInvio(
			tipo, sottotipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByInvio_PrevAndNext(
				session, email, tipo, sottotipo, param, orderByComparator,
				true);

			array[1] = email;

			array[2] = getByInvio_PrevAndNext(
				session, email, tipo, sottotipo, param, orderByComparator,
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

	protected Email getByInvio_PrevAndNext(
		Session session, Email email, String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_EMAIL_WHERE);

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
			query.append(EmailModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(email)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Email> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	@Override
	public void removeByInvio(String tipo, String sottotipo, long param) {
		for (Email email :
				findByInvio(
					tipo, sottotipo, param, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching emails
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

			query.append(_SQL_COUNT_EMAIL_WHERE);

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
		"email.tipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_TIPO_3 =
		"(email.tipo IS NULL OR email.tipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_2 =
		"email.sottotipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_3 =
		"(email.sottotipo IS NULL OR email.sottotipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_PARAM_2 =
		"email.param = ?";

	private FinderPath _finderPathWithPaginationFindByTipoSottotipo;
	private FinderPath _finderPathWithoutPaginationFindByTipoSottotipo;
	private FinderPath _finderPathCountByTipoSottotipo;

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(String tipo, String sottotipo) {
		return findByTipoSottotipo(
			tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end) {

		return findByTipoSottotipo(tipo, sottotipo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

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

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!tipo.equals(email.getTipo()) ||
						!sottotipo.equals(email.getSottotipo())) {

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

			query.append(_SQL_SELECT_EMAIL_WHERE);

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
				query.append(EmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<Email>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(
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
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoSottotipo_First(
			String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", sottotipo=");
		msg.append(sottotipo);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByTipoSottotipo(
			tipo, sottotipo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoSottotipo_Last(
			tipo, sottotipo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", sottotipo=");
		msg.append(sottotipo);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator) {

		int count = countByTipoSottotipo(tipo, sottotipo);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByTipoSottotipo(
			tipo, sottotipo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByTipoSottotipo_PrevAndNext(
				session, email, tipo, sottotipo, orderByComparator, true);

			array[1] = email;

			array[2] = getByTipoSottotipo_PrevAndNext(
				session, email, tipo, sottotipo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByTipoSottotipo_PrevAndNext(
		Session session, Email email, String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EMAIL_WHERE);

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
			query.append(EmailModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(email)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Email> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	@Override
	public void removeByTipoSottotipo(String tipo, String sottotipo) {
		for (Email email :
				findByTipoSottotipo(
					tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching emails
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

			query.append(_SQL_COUNT_EMAIL_WHERE);

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
		"email.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3 =
		"(email.tipo IS NULL OR email.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2 =
		"email.sottotipo = ?";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3 =
		"(email.sottotipo IS NULL OR email.sottotipo = '')";

	private FinderPath _finderPathWithPaginationFindByTipoParam;
	private FinderPath _finderPathWithoutPaginationFindByTipoParam;
	private FinderPath _finderPathCountByTipoParam;

	/**
	 * Returns all the emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByTipoParam(String tipo, long param) {
		return findByTipoParam(
			tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByTipoParam(
		String tipo, long param, int start, int end) {

		return findByTipoParam(tipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByTipoParam(
			tipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

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

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!tipo.equals(email.getTipo()) ||
						(param != email.getParam())) {

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

			query.append(_SQL_SELECT_EMAIL_WHERE);

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
				query.append(EmailModelImpl.ORDER_BY_JPQL);
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
					list = (List<Email>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(
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
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoParam_First(
			String tipo, long param, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoParam_First(tipo, param, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", param=");
		msg.append(param);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoParam_First(
		String tipo, long param, OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByTipoParam(
			tipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoParam_Last(
			String tipo, long param, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoParam_Last(tipo, param, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipo=");
		msg.append(tipo);

		msg.append(", param=");
		msg.append(param);

		msg.append("}");

		throw new NoSuchEmailException(msg.toString());
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoParam_Last(
		String tipo, long param, OrderByComparator<Email> orderByComparator) {

		int count = countByTipoParam(tipo, param);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByTipoParam(
			tipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		tipo = Objects.toString(tipo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByTipoParam_PrevAndNext(
				session, email, tipo, param, orderByComparator, true);

			array[1] = email;

			array[2] = getByTipoParam_PrevAndNext(
				session, email, tipo, param, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByTipoParam_PrevAndNext(
		Session session, Email email, String tipo, long param,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EMAIL_WHERE);

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
			query.append(EmailModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(email)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Email> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	@Override
	public void removeByTipoParam(String tipo, long param) {
		for (Email email :
				findByTipoParam(
					tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	@Override
	public int countByTipoParam(String tipo, long param) {
		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = _finderPathCountByTipoParam;

		Object[] finderArgs = new Object[] {tipo, param};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMAIL_WHERE);

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
		"email.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_TIPO_3 =
		"(email.tipo IS NULL OR email.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_PARAM_2 =
		"email.param = ?";

	public EmailPersistenceImpl() {
		setModelClass(Email.class);

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
	 * Caches the email in the entity cache if it is enabled.
	 *
	 * @param email the email
	 */
	@Override
	public void cacheResult(Email email) {
		entityCache.putResult(
			EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
			email.getPrimaryKey(), email);

		email.resetOriginalValues();
	}

	/**
	 * Caches the emails in the entity cache if it is enabled.
	 *
	 * @param emails the emails
	 */
	@Override
	public void cacheResult(List<Email> emails) {
		for (Email email : emails) {
			if (entityCache.getResult(
					EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
					email.getPrimaryKey()) == null) {

				cacheResult(email);
			}
			else {
				email.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emails.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Email email) {
		entityCache.removeResult(
			EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
			email.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Email> emails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Email email : emails) {
			entityCache.removeResult(
				EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
				email.getPrimaryKey());
		}
	}

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	@Override
	public Email create(long id) {
		Email email = new EmailImpl();

		email.setNew(true);
		email.setPrimaryKey(id);

		return email;
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email remove(long id) throws NoSuchEmailException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email remove(Serializable primaryKey) throws NoSuchEmailException {
		Session session = null;

		try {
			session = openSession();

			Email email = (Email)session.get(EmailImpl.class, primaryKey);

			if (email == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(email);
		}
		catch (NoSuchEmailException nsee) {
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
	protected Email removeImpl(Email email) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(email)) {
				email = (Email)session.get(
					EmailImpl.class, email.getPrimaryKeyObj());
			}

			if (email != null) {
				session.delete(email);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (email != null) {
			clearCache(email);
		}

		return email;
	}

	@Override
	public Email updateImpl(Email email) {
		boolean isNew = email.isNew();

		if (!(email instanceof EmailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(email.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(email);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in email proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Email implementation " +
					email.getClass());
		}

		EmailModelImpl emailModelImpl = (EmailModelImpl)email;

		Session session = null;

		try {
			session = openSession();

			if (email.isNew()) {
				session.save(email);

				email.setNew(false);
			}
			else {
				email = (Email)session.merge(email);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EmailModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {emailModelImpl.getDestinatario()};

			finderCache.removeResult(_finderPathCountByDestinatario, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDestinatario, args);

			args = new Object[] {emailModelImpl.getIndirizzo()};

			finderCache.removeResult(_finderPathCountByIndirizzo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByIndirizzo, args);

			args = new Object[] {
				emailModelImpl.getTipo(), emailModelImpl.getSottotipo(),
				emailModelImpl.getParam()
			};

			finderCache.removeResult(_finderPathCountByInvio, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByInvio, args);

			args = new Object[] {
				emailModelImpl.getTipo(), emailModelImpl.getSottotipo()
			};

			finderCache.removeResult(_finderPathCountByTipoSottotipo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoSottotipo, args);

			args = new Object[] {
				emailModelImpl.getTipo(), emailModelImpl.getParam()
			};

			finderCache.removeResult(_finderPathCountByTipoParam, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTipoParam, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((emailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDestinatario.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					emailModelImpl.getOriginalDestinatario()
				};

				finderCache.removeResult(_finderPathCountByDestinatario, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDestinatario, args);

				args = new Object[] {emailModelImpl.getDestinatario()};

				finderCache.removeResult(_finderPathCountByDestinatario, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDestinatario, args);
			}

			if ((emailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByIndirizzo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					emailModelImpl.getOriginalIndirizzo()
				};

				finderCache.removeResult(_finderPathCountByIndirizzo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIndirizzo, args);

				args = new Object[] {emailModelImpl.getIndirizzo()};

				finderCache.removeResult(_finderPathCountByIndirizzo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIndirizzo, args);
			}

			if ((emailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByInvio.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					emailModelImpl.getOriginalTipo(),
					emailModelImpl.getOriginalSottotipo(),
					emailModelImpl.getOriginalParam()
				};

				finderCache.removeResult(_finderPathCountByInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvio, args);

				args = new Object[] {
					emailModelImpl.getTipo(), emailModelImpl.getSottotipo(),
					emailModelImpl.getParam()
				};

				finderCache.removeResult(_finderPathCountByInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvio, args);
			}

			if ((emailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoSottotipo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					emailModelImpl.getOriginalTipo(),
					emailModelImpl.getOriginalSottotipo()
				};

				finderCache.removeResult(_finderPathCountByTipoSottotipo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoSottotipo, args);

				args = new Object[] {
					emailModelImpl.getTipo(), emailModelImpl.getSottotipo()
				};

				finderCache.removeResult(_finderPathCountByTipoSottotipo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoSottotipo, args);
			}

			if ((emailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTipoParam.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					emailModelImpl.getOriginalTipo(),
					emailModelImpl.getOriginalParam()
				};

				finderCache.removeResult(_finderPathCountByTipoParam, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoParam, args);

				args = new Object[] {
					emailModelImpl.getTipo(), emailModelImpl.getParam()
				};

				finderCache.removeResult(_finderPathCountByTipoParam, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTipoParam, args);
			}
		}

		entityCache.putResult(
			EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
			email.getPrimaryKey(), email, false);

		email.resetOriginalValues();

		return email;
	}

	/**
	 * Returns the email with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailException {

		Email email = fetchByPrimaryKey(primaryKey);

		if (email == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return email;
	}

	/**
	 * Returns the email with the primary key or throws a <code>NoSuchEmailException</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email findByPrimaryKey(long id) throws NoSuchEmailException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	@Override
	public Email fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Email email = (Email)serializable;

		if (email == null) {
			Session session = null;

			try {
				session = openSession();

				email = (Email)session.get(EmailImpl.class, primaryKey);

				if (email != null) {
					cacheResult(email);
				}
				else {
					entityCache.putResult(
						EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return email;
	}

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	@Override
	public Email fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Email> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Email> map = new HashMap<Serializable, Email>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Email email = fetchByPrimaryKey(primaryKey);

			if (email != null) {
				map.put(primaryKey, email);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Email)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_EMAIL_WHERE_PKS_IN);

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

			for (Email email : (List<Email>)q.list()) {
				map.put(email.getPrimaryKeyObj(), email);

				cacheResult(email);

				uncachedPrimaryKeys.remove(email.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					EmailModelImpl.ENTITY_CACHE_ENABLED, EmailImpl.class,
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
	 * Returns all the emails.
	 *
	 * @return the emails
	 */
	@Override
	public List<Email> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of emails
	 */
	@Override
	public List<Email> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emails
	 */
	@Override
	public List<Email> findAll(
		int start, int end, OrderByComparator<Email> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of emails
	 */
	@Override
	public List<Email> findAll(
		int start, int end, OrderByComparator<Email> orderByComparator,
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

		List<Email> list = null;

		if (retrieveFromCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMAIL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAIL;

				if (pagination) {
					sql = sql.concat(EmailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Email>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Email>)QueryUtil.list(
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
	 * Removes all the emails from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Email email : findAll()) {
			remove(email);
		}
	}

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAIL);

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
		return EmailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDestinatario = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDestinatario",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDestinatario = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDestinatario",
			new String[] {Long.class.getName()},
			EmailModelImpl.DESTINATARIO_COLUMN_BITMASK);

		_finderPathCountByDestinatario = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDestinatario",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByIndirizzo = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIndirizzo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByIndirizzo = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIndirizzo",
			new String[] {String.class.getName()},
			EmailModelImpl.INDIRIZZO_COLUMN_BITMASK);

		_finderPathCountByIndirizzo = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIndirizzo",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByInvio = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByInvio = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			EmailModelImpl.TIPO_COLUMN_BITMASK |
			EmailModelImpl.SOTTOTIPO_COLUMN_BITMASK |
			EmailModelImpl.PARAM_COLUMN_BITMASK);

		_finderPathCountByInvio = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByTipoSottotipo = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoSottotipo",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoSottotipo = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoSottotipo",
			new String[] {String.class.getName(), String.class.getName()},
			EmailModelImpl.TIPO_COLUMN_BITMASK |
			EmailModelImpl.SOTTOTIPO_COLUMN_BITMASK);

		_finderPathCountByTipoSottotipo = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoSottotipo",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByTipoParam = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoParam",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTipoParam = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, EmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoParam",
			new String[] {String.class.getName(), Long.class.getName()},
			EmailModelImpl.TIPO_COLUMN_BITMASK |
			EmailModelImpl.PARAM_COLUMN_BITMASK);

		_finderPathCountByTipoParam = new FinderPath(
			EmailModelImpl.ENTITY_CACHE_ENABLED,
			EmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoParam",
			new String[] {String.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(EmailImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMAIL =
		"SELECT email FROM Email email";

	private static final String _SQL_SELECT_EMAIL_WHERE_PKS_IN =
		"SELECT email FROM Email email WHERE id_ IN (";

	private static final String _SQL_SELECT_EMAIL_WHERE =
		"SELECT email FROM Email email WHERE ";

	private static final String _SQL_COUNT_EMAIL =
		"SELECT COUNT(email) FROM Email email";

	private static final String _SQL_COUNT_EMAIL_WHERE =
		"SELECT COUNT(email) FROM Email email WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "email.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Email exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Email exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}