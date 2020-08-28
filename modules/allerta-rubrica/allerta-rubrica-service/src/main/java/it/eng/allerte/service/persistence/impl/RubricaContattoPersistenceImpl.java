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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaContattoException;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.impl.RubricaContattoImpl;
import it.eng.allerte.model.impl.RubricaContattoModelImpl;
import it.eng.allerte.service.persistence.RubricaContattoPersistence;

import java.io.Serializable;

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
 * The persistence implementation for the rubrica contatto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaContattoPersistenceImpl
	extends BasePersistenceImpl<RubricaContatto>
	implements RubricaContattoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaContattoUtil</code> to access the rubrica contatto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaContattoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUtenteCreazioneContatto;
	private FinderPath
		_finderPathWithoutPaginationFindByUtenteCreazioneContatto;
	private FinderPath _finderPathCountByUtenteCreazioneContatto;

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE) {

		return findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end) {

		return findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByUtenteCreazioneContatto;
			finderArgs = new Object[] {FK_UTENTE_CREAZIONE};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUtenteCreazioneContatto;
			finderArgs = new Object[] {
				FK_UTENTE_CREAZIONE, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if ((FK_UTENTE_CREAZIONE !=
							rubricaContatto.getFK_UTENTE_CREAZIONE())) {

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

			query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			query.append(
				_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_CREAZIONE);

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteCreazioneContatto_First(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteCreazioneContatto_First(
			FK_UTENTE_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_CREAZIONE=");
		msg.append(FK_UTENTE_CREAZIONE);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteCreazioneContatto_First(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteCreazioneContatto_Last(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteCreazioneContatto_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_CREAZIONE=");
		msg.append(FK_UTENTE_CREAZIONE);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteCreazioneContatto_Last(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByUtenteCreazioneContatto(FK_UTENTE_CREAZIONE);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByUtenteCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByUtenteCreazioneContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_CREAZIONE,
				orderByComparator, true);

			array[1] = rubricaContatto;

			array[2] = getByUtenteCreazioneContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_CREAZIONE,
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

	protected RubricaContatto getByUtenteCreazioneContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto,
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		query.append(
			_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2);

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
			query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_UTENTE_CREAZIONE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	@Override
	public void removeByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE) {
		for (RubricaContatto rubricaContatto :
				findByUtenteCreazioneContatto(
					FK_UTENTE_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE) {
		FinderPath finderPath = _finderPathCountByUtenteCreazioneContatto;

		Object[] finderArgs = new Object[] {FK_UTENTE_CREAZIONE};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			query.append(
				_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_CREAZIONE);

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
		_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2 =
			"rubricaContatto.FK_UTENTE_CREAZIONE = ?";

	private FinderPath _finderPathWithPaginationFindByUtenteModificaContatto;
	private FinderPath _finderPathWithoutPaginationFindByUtenteModificaContatto;
	private FinderPath _finderPathCountByUtenteModificaContatto;

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA) {

		return findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByUtenteModificaContatto;
			finderArgs = new Object[] {FK_UTENTE_MODIFICA};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUtenteModificaContatto;
			finderArgs = new Object[] {
				FK_UTENTE_MODIFICA, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if ((FK_UTENTE_MODIFICA !=
							rubricaContatto.getFK_UTENTE_MODIFICA())) {

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

			query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			query.append(
				_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_MODIFICA);

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteModificaContatto_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteModificaContatto_First(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_MODIFICA=");
		msg.append(FK_UTENTE_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteModificaContatto_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteModificaContatto_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteModificaContatto_Last(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_MODIFICA=");
		msg.append(FK_UTENTE_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteModificaContatto_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByUtenteModificaContatto(FK_UTENTE_MODIFICA);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByUtenteModificaContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByUtenteModificaContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_MODIFICA, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByUtenteModificaContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_MODIFICA, orderByComparator,
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

	protected RubricaContatto getByUtenteModificaContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto,
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		query.append(
			_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2);

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
			query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_UTENTE_MODIFICA);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	@Override
	public void removeByUtenteModificaContatto(long FK_UTENTE_MODIFICA) {
		for (RubricaContatto rubricaContatto :
				findByUtenteModificaContatto(
					FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByUtenteModificaContatto(long FK_UTENTE_MODIFICA) {
		FinderPath finderPath = _finderPathCountByUtenteModificaContatto;

		Object[] finderArgs = new Object[] {FK_UTENTE_MODIFICA};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			query.append(
				_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_MODIFICA);

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
		_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2 =
			"rubricaContatto.FK_UTENTE_MODIFICA = ?";

	private FinderPath _finderPathWithPaginationFindByContattoCanale;
	private FinderPath _finderPathWithoutPaginationFindByContattoCanale;
	private FinderPath _finderPathCountByContattoCanale;

	/**
	 * Returns all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(long FK_CANALE) {
		return findByContattoCanale(
			FK_CANALE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end) {

		return findByContattoCanale(FK_CANALE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByContattoCanale(
			FK_CANALE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByContattoCanale;
			finderArgs = new Object[] {FK_CANALE};
		}
		else {
			finderPath = _finderPathWithPaginationFindByContattoCanale;
			finderArgs = new Object[] {
				FK_CANALE, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if ((FK_CANALE != rubricaContatto.getFK_CANALE())) {
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

			query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			query.append(_FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_CANALE);

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoCanale_First(
			long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoCanale_First(
			FK_CANALE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_CANALE=");
		msg.append(FK_CANALE);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoCanale_First(
		long FK_CANALE, OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByContattoCanale(
			FK_CANALE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoCanale_Last(
			long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoCanale_Last(
			FK_CANALE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_CANALE=");
		msg.append(FK_CANALE);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoCanale_Last(
		long FK_CANALE, OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByContattoCanale(FK_CANALE);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByContattoCanale(
			FK_CANALE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByContattoCanale_PrevAndNext(
			long ID_CONTATTO, long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByContattoCanale_PrevAndNext(
				session, rubricaContatto, FK_CANALE, orderByComparator, true);

			array[1] = rubricaContatto;

			array[2] = getByContattoCanale_PrevAndNext(
				session, rubricaContatto, FK_CANALE, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaContatto getByContattoCanale_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, long FK_CANALE,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		query.append(_FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2);

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
			query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_CANALE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_CANALE = &#63; from the database.
	 *
	 * @param FK_CANALE the fk_canale
	 */
	@Override
	public void removeByContattoCanale(long FK_CANALE) {
		for (RubricaContatto rubricaContatto :
				findByContattoCanale(
					FK_CANALE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByContattoCanale(long FK_CANALE) {
		FinderPath finderPath = _finderPathCountByContattoCanale;

		Object[] finderArgs = new Object[] {FK_CANALE};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			query.append(_FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_CANALE);

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

	private static final String _FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2 =
		"rubricaContatto.FK_CANALE = ?";

	private FinderPath _finderPathWithPaginationFindByContattoNominativo;
	private FinderPath _finderPathWithoutPaginationFindByContattoNominativo;
	private FinderPath _finderPathCountByContattoNominativo;

	/**
	 * Returns all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(long FK_NOMINATIVO) {
		return findByContattoNominativo(
			FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end) {

		return findByContattoNominativo(FK_NOMINATIVO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByContattoNominativo(
			FK_NOMINATIVO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByContattoNominativo;
			finderArgs = new Object[] {FK_NOMINATIVO};
		}
		else {
			finderPath = _finderPathWithPaginationFindByContattoNominativo;
			finderArgs = new Object[] {
				FK_NOMINATIVO, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if ((FK_NOMINATIVO != rubricaContatto.getFK_NOMINATIVO())) {
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

			query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			query.append(_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_NOMINATIVO);

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoNominativo_First(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoNominativo_First(
			FK_NOMINATIVO, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_NOMINATIVO=");
		msg.append(FK_NOMINATIVO);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoNominativo_First(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByContattoNominativo(
			FK_NOMINATIVO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoNominativo_Last(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoNominativo_Last(
			FK_NOMINATIVO, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_NOMINATIVO=");
		msg.append(FK_NOMINATIVO);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoNominativo_Last(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByContattoNominativo(FK_NOMINATIVO);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByContattoNominativo(
			FK_NOMINATIVO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByContattoNominativo_PrevAndNext(
			long ID_CONTATTO, long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByContattoNominativo_PrevAndNext(
				session, rubricaContatto, FK_NOMINATIVO, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByContattoNominativo_PrevAndNext(
				session, rubricaContatto, FK_NOMINATIVO, orderByComparator,
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

	protected RubricaContatto getByContattoNominativo_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		query.append(_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2);

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
			query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
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
						rubricaContatto)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	@Override
	public void removeByContattoNominativo(long FK_NOMINATIVO) {
		for (RubricaContatto rubricaContatto :
				findByContattoNominativo(
					FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByContattoNominativo(long FK_NOMINATIVO) {
		FinderPath finderPath = _finderPathCountByContattoNominativo;

		Object[] finderArgs = new Object[] {FK_NOMINATIVO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			query.append(_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2);

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
		_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2 =
			"rubricaContatto.FK_NOMINATIVO = ?";

	private FinderPath _finderPathWithPaginationFindByDataCreazioneContatto;
	private FinderPath _finderPathWithoutPaginationFindByDataCreazioneContatto;
	private FinderPath _finderPathCountByDataCreazioneContatto;

	/**
	 * Returns all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE) {

		return findByDataCreazioneContatto(
			DATA_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end) {

		return findByDataCreazioneContatto(DATA_CREAZIONE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByDataCreazioneContatto(
			DATA_CREAZIONE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByDataCreazioneContatto;
			finderArgs = new Object[] {_getTime(DATA_CREAZIONE)};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataCreazioneContatto;
			finderArgs = new Object[] {
				_getTime(DATA_CREAZIONE), start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (!Objects.equals(
							DATA_CREAZIONE,
							rubricaContatto.getDATA_CREAZIONE())) {

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

			query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_CREAZIONE = false;

			if (DATA_CREAZIONE == null) {
				query.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1);
			}
			else {
				bindDATA_CREAZIONE = true;

				query.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATA_CREAZIONE) {
					qPos.add(new Timestamp(DATA_CREAZIONE.getTime()));
				}

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataCreazioneContatto_First(
			Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataCreazioneContatto_First(
			DATA_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATA_CREAZIONE=");
		msg.append(DATA_CREAZIONE);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataCreazioneContatto_First(
		Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByDataCreazioneContatto(
			DATA_CREAZIONE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataCreazioneContatto_Last(
			Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataCreazioneContatto_Last(
			DATA_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATA_CREAZIONE=");
		msg.append(DATA_CREAZIONE);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataCreazioneContatto_Last(
		Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByDataCreazioneContatto(DATA_CREAZIONE);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByDataCreazioneContatto(
			DATA_CREAZIONE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByDataCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByDataCreazioneContatto_PrevAndNext(
				session, rubricaContatto, DATA_CREAZIONE, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByDataCreazioneContatto_PrevAndNext(
				session, rubricaContatto, DATA_CREAZIONE, orderByComparator,
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

	protected RubricaContatto getByDataCreazioneContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		boolean bindDATA_CREAZIONE = false;

		if (DATA_CREAZIONE == null) {
			query.append(_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1);
		}
		else {
			bindDATA_CREAZIONE = true;

			query.append(_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2);
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
			query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDATA_CREAZIONE) {
			qPos.add(new Timestamp(DATA_CREAZIONE.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where DATA_CREAZIONE = &#63; from the database.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 */
	@Override
	public void removeByDataCreazioneContatto(Date DATA_CREAZIONE) {
		for (RubricaContatto rubricaContatto :
				findByDataCreazioneContatto(
					DATA_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByDataCreazioneContatto(Date DATA_CREAZIONE) {
		FinderPath finderPath = _finderPathCountByDataCreazioneContatto;

		Object[] finderArgs = new Object[] {_getTime(DATA_CREAZIONE)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_CREAZIONE = false;

			if (DATA_CREAZIONE == null) {
				query.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1);
			}
			else {
				bindDATA_CREAZIONE = true;

				query.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATA_CREAZIONE) {
					qPos.add(new Timestamp(DATA_CREAZIONE.getTime()));
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
		_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1 =
			"rubricaContatto.DATA_CREAZIONE IS NULL";

	private static final String
		_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2 =
			"rubricaContatto.DATA_CREAZIONE = ?";

	private FinderPath _finderPathWithPaginationFindByDataModificaContatto;
	private FinderPath _finderPathWithoutPaginationFindByDataModificaContatto;
	private FinderPath _finderPathCountByDataModificaContatto;

	/**
	 * Returns all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA) {

		return findByDataModificaContatto(
			DATA_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end) {

		return findByDataModificaContatto(DATA_MODIFICA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByDataModificaContatto(
			DATA_MODIFICA, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataModificaContatto;
			finderArgs = new Object[] {_getTime(DATA_MODIFICA)};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataModificaContatto;
			finderArgs = new Object[] {
				_getTime(DATA_MODIFICA), start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (!Objects.equals(
							DATA_MODIFICA,
							rubricaContatto.getDATA_MODIFICA())) {

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

			query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				query.append(
					_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				query.append(
					_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATA_MODIFICA) {
					qPos.add(new Timestamp(DATA_MODIFICA.getTime()));
				}

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataModificaContatto_First(
			Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataModificaContatto_First(
			DATA_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATA_MODIFICA=");
		msg.append(DATA_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataModificaContatto_First(
		Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByDataModificaContatto(
			DATA_MODIFICA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataModificaContatto_Last(
			Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataModificaContatto_Last(
			DATA_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATA_MODIFICA=");
		msg.append(DATA_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaContattoException(msg.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataModificaContatto_Last(
		Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByDataModificaContatto(DATA_MODIFICA);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByDataModificaContatto(
			DATA_MODIFICA, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByDataModificaContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByDataModificaContatto_PrevAndNext(
				session, rubricaContatto, DATA_MODIFICA, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByDataModificaContatto_PrevAndNext(
				session, rubricaContatto, DATA_MODIFICA, orderByComparator,
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

	protected RubricaContatto getByDataModificaContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		boolean bindDATA_MODIFICA = false;

		if (DATA_MODIFICA == null) {
			query.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1);
		}
		else {
			bindDATA_MODIFICA = true;

			query.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2);
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
			query.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDATA_MODIFICA) {
			qPos.add(new Timestamp(DATA_MODIFICA.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where DATA_MODIFICA = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 */
	@Override
	public void removeByDataModificaContatto(Date DATA_MODIFICA) {
		for (RubricaContatto rubricaContatto :
				findByDataModificaContatto(
					DATA_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByDataModificaContatto(Date DATA_MODIFICA) {
		FinderPath finderPath = _finderPathCountByDataModificaContatto;

		Object[] finderArgs = new Object[] {_getTime(DATA_MODIFICA)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				query.append(
					_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				query.append(
					_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATA_MODIFICA) {
					qPos.add(new Timestamp(DATA_MODIFICA.getTime()));
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
		_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1 =
			"rubricaContatto.DATA_MODIFICA IS NULL";

	private static final String
		_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2 =
			"rubricaContatto.DATA_MODIFICA = ?";

	public RubricaContattoPersistenceImpl() {
		setModelClass(RubricaContatto.class);
	}

	/**
	 * Caches the rubrica contatto in the entity cache if it is enabled.
	 *
	 * @param rubricaContatto the rubrica contatto
	 */
	@Override
	public void cacheResult(RubricaContatto rubricaContatto) {
		entityCache.putResult(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoImpl.class, rubricaContatto.getPrimaryKey(),
			rubricaContatto);

		rubricaContatto.resetOriginalValues();
	}

	/**
	 * Caches the rubrica contattos in the entity cache if it is enabled.
	 *
	 * @param rubricaContattos the rubrica contattos
	 */
	@Override
	public void cacheResult(List<RubricaContatto> rubricaContattos) {
		for (RubricaContatto rubricaContatto : rubricaContattos) {
			if (entityCache.getResult(
					RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaContattoImpl.class,
					rubricaContatto.getPrimaryKey()) == null) {

				cacheResult(rubricaContatto);
			}
			else {
				rubricaContatto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica contattos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaContattoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica contatto.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaContatto rubricaContatto) {
		entityCache.removeResult(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoImpl.class, rubricaContatto.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaContatto> rubricaContattos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaContatto rubricaContatto : rubricaContattos) {
			entityCache.removeResult(
				RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaContattoImpl.class, rubricaContatto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica contatto with the primary key. Does not add the rubrica contatto to the database.
	 *
	 * @param ID_CONTATTO the primary key for the new rubrica contatto
	 * @return the new rubrica contatto
	 */
	@Override
	public RubricaContatto create(long ID_CONTATTO) {
		RubricaContatto rubricaContatto = new RubricaContattoImpl();

		rubricaContatto.setNew(true);
		rubricaContatto.setPrimaryKey(ID_CONTATTO);

		return rubricaContatto;
	}

	/**
	 * Removes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto remove(long ID_CONTATTO)
		throws NoSuchRubricaContattoException {

		return remove((Serializable)ID_CONTATTO);
	}

	/**
	 * Removes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto remove(Serializable primaryKey)
		throws NoSuchRubricaContattoException {

		Session session = null;

		try {
			session = openSession();

			RubricaContatto rubricaContatto = (RubricaContatto)session.get(
				RubricaContattoImpl.class, primaryKey);

			if (rubricaContatto == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaContattoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaContatto);
		}
		catch (NoSuchRubricaContattoException nsee) {
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
	protected RubricaContatto removeImpl(RubricaContatto rubricaContatto) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaContatto)) {
				rubricaContatto = (RubricaContatto)session.get(
					RubricaContattoImpl.class,
					rubricaContatto.getPrimaryKeyObj());
			}

			if (rubricaContatto != null) {
				session.delete(rubricaContatto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaContatto != null) {
			clearCache(rubricaContatto);
		}

		return rubricaContatto;
	}

	@Override
	public RubricaContatto updateImpl(RubricaContatto rubricaContatto) {
		boolean isNew = rubricaContatto.isNew();

		if (!(rubricaContatto instanceof RubricaContattoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaContatto.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaContatto);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaContatto proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaContatto implementation " +
					rubricaContatto.getClass());
		}

		RubricaContattoModelImpl rubricaContattoModelImpl =
			(RubricaContattoModelImpl)rubricaContatto;

		Session session = null;

		try {
			session = openSession();

			if (rubricaContatto.isNew()) {
				session.save(rubricaContatto);

				rubricaContatto.setNew(false);
			}
			else {
				rubricaContatto = (RubricaContatto)session.merge(
					rubricaContatto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaContattoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaContattoModelImpl.getFK_UTENTE_CREAZIONE()
			};

			finderCache.removeResult(
				_finderPathCountByUtenteCreazioneContatto, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUtenteCreazioneContatto,
				args);

			args = new Object[] {
				rubricaContattoModelImpl.getFK_UTENTE_MODIFICA()
			};

			finderCache.removeResult(
				_finderPathCountByUtenteModificaContatto, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUtenteModificaContatto, args);

			args = new Object[] {rubricaContattoModelImpl.getFK_CANALE()};

			finderCache.removeResult(_finderPathCountByContattoCanale, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByContattoCanale, args);

			args = new Object[] {rubricaContattoModelImpl.getFK_NOMINATIVO()};

			finderCache.removeResult(
				_finderPathCountByContattoNominativo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByContattoNominativo, args);

			args = new Object[] {rubricaContattoModelImpl.getDATA_CREAZIONE()};

			finderCache.removeResult(
				_finderPathCountByDataCreazioneContatto, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataCreazioneContatto, args);

			args = new Object[] {rubricaContattoModelImpl.getDATA_MODIFICA()};

			finderCache.removeResult(
				_finderPathCountByDataModificaContatto, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataModificaContatto, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaContattoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUtenteCreazioneContatto.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaContattoModelImpl.getOriginalFK_UTENTE_CREAZIONE()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteCreazioneContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteCreazioneContatto,
					args);

				args = new Object[] {
					rubricaContattoModelImpl.getFK_UTENTE_CREAZIONE()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteCreazioneContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteCreazioneContatto,
					args);
			}

			if ((rubricaContattoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUtenteModificaContatto.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaContattoModelImpl.getOriginalFK_UTENTE_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteModificaContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteModificaContatto,
					args);

				args = new Object[] {
					rubricaContattoModelImpl.getFK_UTENTE_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteModificaContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteModificaContatto,
					args);
			}

			if ((rubricaContattoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByContattoCanale.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaContattoModelImpl.getOriginalFK_CANALE()
				};

				finderCache.removeResult(
					_finderPathCountByContattoCanale, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContattoCanale, args);

				args = new Object[] {rubricaContattoModelImpl.getFK_CANALE()};

				finderCache.removeResult(
					_finderPathCountByContattoCanale, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContattoCanale, args);
			}

			if ((rubricaContattoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByContattoNominativo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaContattoModelImpl.getOriginalFK_NOMINATIVO()
				};

				finderCache.removeResult(
					_finderPathCountByContattoNominativo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContattoNominativo, args);

				args = new Object[] {
					rubricaContattoModelImpl.getFK_NOMINATIVO()
				};

				finderCache.removeResult(
					_finderPathCountByContattoNominativo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByContattoNominativo, args);
			}

			if ((rubricaContattoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataCreazioneContatto.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaContattoModelImpl.getOriginalDATA_CREAZIONE()
				};

				finderCache.removeResult(
					_finderPathCountByDataCreazioneContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataCreazioneContatto,
					args);

				args = new Object[] {
					rubricaContattoModelImpl.getDATA_CREAZIONE()
				};

				finderCache.removeResult(
					_finderPathCountByDataCreazioneContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataCreazioneContatto,
					args);
			}

			if ((rubricaContattoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataModificaContatto.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaContattoModelImpl.getOriginalDATA_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByDataModificaContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataModificaContatto,
					args);

				args = new Object[] {
					rubricaContattoModelImpl.getDATA_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByDataModificaContatto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataModificaContatto,
					args);
			}
		}

		entityCache.putResult(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoImpl.class, rubricaContatto.getPrimaryKey(),
			rubricaContatto, false);

		rubricaContatto.resetOriginalValues();

		return rubricaContatto;
	}

	/**
	 * Returns the rubrica contatto with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByPrimaryKey(primaryKey);

		if (rubricaContatto == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaContattoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaContatto;
	}

	/**
	 * Returns the rubrica contatto with the primary key or throws a <code>NoSuchRubricaContattoException</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto findByPrimaryKey(long ID_CONTATTO)
		throws NoSuchRubricaContattoException {

		return findByPrimaryKey((Serializable)ID_CONTATTO);
	}

	/**
	 * Returns the rubrica contatto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica contatto
	 * @return the rubrica contatto, or <code>null</code> if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaContatto rubricaContatto = (RubricaContatto)serializable;

		if (rubricaContatto == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaContatto = (RubricaContatto)session.get(
					RubricaContattoImpl.class, primaryKey);

				if (rubricaContatto != null) {
					cacheResult(rubricaContatto);
				}
				else {
					entityCache.putResult(
						RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
						RubricaContattoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaContattoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaContatto;
	}

	/**
	 * Returns the rubrica contatto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto, or <code>null</code> if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto fetchByPrimaryKey(long ID_CONTATTO) {
		return fetchByPrimaryKey((Serializable)ID_CONTATTO);
	}

	@Override
	public Map<Serializable, RubricaContatto> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaContatto> map =
			new HashMap<Serializable, RubricaContatto>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaContatto rubricaContatto = fetchByPrimaryKey(primaryKey);

			if (rubricaContatto != null) {
				map.put(primaryKey, rubricaContatto);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaContattoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaContatto)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICACONTATTO_WHERE_PKS_IN);

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

			for (RubricaContatto rubricaContatto :
					(List<RubricaContatto>)q.list()) {

				map.put(rubricaContatto.getPrimaryKeyObj(), rubricaContatto);

				cacheResult(rubricaContatto);

				uncachedPrimaryKeys.remove(rubricaContatto.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaContattoImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica contattos.
	 *
	 * @return the rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll(
		int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll(
		int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		List<RubricaContatto> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaContatto>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICACONTATTO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICACONTATTO;

				if (pagination) {
					sql = sql.concat(RubricaContattoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaContatto>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Removes all the rubrica contattos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaContatto rubricaContatto : findAll()) {
			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos.
	 *
	 * @return the number of rubrica contattos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICACONTATTO);

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
		return RubricaContattoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica contatto persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUtenteCreazioneContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtenteCreazioneContatto",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUtenteCreazioneContatto =
			new FinderPath(
				RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
				RubricaContattoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUtenteCreazioneContatto",
				new String[] {Long.class.getName()},
				RubricaContattoModelImpl.FK_UTENTE_CREAZIONE_COLUMN_BITMASK);

		_finderPathCountByUtenteCreazioneContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUtenteCreazioneContatto",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUtenteModificaContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtenteModificaContatto",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUtenteModificaContatto =
			new FinderPath(
				RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
				RubricaContattoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUtenteModificaContatto",
				new String[] {Long.class.getName()},
				RubricaContattoModelImpl.FK_UTENTE_MODIFICA_COLUMN_BITMASK);

		_finderPathCountByUtenteModificaContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUtenteModificaContatto",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByContattoCanale = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContattoCanale",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByContattoCanale = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContattoCanale",
			new String[] {Long.class.getName()},
			RubricaContattoModelImpl.FK_CANALE_COLUMN_BITMASK);

		_finderPathCountByContattoCanale = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContattoCanale",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByContattoNominativo = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContattoNominativo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByContattoNominativo = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContattoNominativo", new String[] {Long.class.getName()},
			RubricaContattoModelImpl.FK_NOMINATIVO_COLUMN_BITMASK);

		_finderPathCountByContattoNominativo = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContattoNominativo", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataCreazioneContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDataCreazioneContatto",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataCreazioneContatto =
			new FinderPath(
				RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
				RubricaContattoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDataCreazioneContatto",
				new String[] {Date.class.getName()},
				RubricaContattoModelImpl.DATA_CREAZIONE_COLUMN_BITMASK);

		_finderPathCountByDataCreazioneContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataCreazioneContatto",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByDataModificaContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDataModificaContatto",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataModificaContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED,
			RubricaContattoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDataModificaContatto", new String[] {Date.class.getName()},
			RubricaContattoModelImpl.DATA_MODIFICA_COLUMN_BITMASK);

		_finderPathCountByDataModificaContatto = new FinderPath(
			RubricaContattoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaContattoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataModificaContatto", new String[] {Date.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaContattoImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICACONTATTO =
		"SELECT rubricaContatto FROM RubricaContatto rubricaContatto";

	private static final String _SQL_SELECT_RUBRICACONTATTO_WHERE_PKS_IN =
		"SELECT rubricaContatto FROM RubricaContatto rubricaContatto WHERE ID_CONTATTO IN (";

	private static final String _SQL_SELECT_RUBRICACONTATTO_WHERE =
		"SELECT rubricaContatto FROM RubricaContatto rubricaContatto WHERE ";

	private static final String _SQL_COUNT_RUBRICACONTATTO =
		"SELECT COUNT(rubricaContatto) FROM RubricaContatto rubricaContatto";

	private static final String _SQL_COUNT_RUBRICACONTATTO_WHERE =
		"SELECT COUNT(rubricaContatto) FROM RubricaContatto rubricaContatto WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaContatto.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaContatto exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaContatto exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaContattoPersistenceImpl.class);

}