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

import it.eng.allerte.exception.NoSuchRubricaLogException;
import it.eng.allerte.model.RubricaLog;
import it.eng.allerte.model.impl.RubricaLogImpl;
import it.eng.allerte.model.impl.RubricaLogModelImpl;
import it.eng.allerte.service.persistence.RubricaLogPersistence;

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
 * The persistence implementation for the rubrica log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaLogPersistenceImpl
	extends BasePersistenceImpl<RubricaLog> implements RubricaLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaLogUtil</code> to access the rubrica log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaLogImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRubricaLogUtenteModifica;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaLogUtenteModifica;
	private FinderPath _finderPathCountByRubricaLogUtenteModifica;

	/**
	 * Returns all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA) {

		return findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaLogUtenteModifica;
			finderArgs = new Object[] {FK_UTENTE_MODIFICA};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByRubricaLogUtenteModifica;
			finderArgs = new Object[] {
				FK_UTENTE_MODIFICA, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if ((FK_UTENTE_MODIFICA !=
							rubricaLog.getFK_UTENTE_MODIFICA())) {

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

			query.append(_SQL_SELECT_RUBRICALOG_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_MODIFICA);

				if (!pagination) {
					list = (List<RubricaLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaLog>)QueryUtil.list(
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
	 * Returns the first rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogUtenteModifica_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogUtenteModifica_First(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_MODIFICA=");
		msg.append(FK_UTENTE_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the first rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogUtenteModifica_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaLog> orderByComparator) {

		List<RubricaLog> list = findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogUtenteModifica_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogUtenteModifica_Last(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_MODIFICA=");
		msg.append(FK_UTENTE_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogUtenteModifica_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaLog> orderByComparator) {

		int count = countByRubricaLogUtenteModifica(FK_UTENTE_MODIFICA);

		if (count == 0) {
			return null;
		}

		List<RubricaLog> list = findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog[] findByRubricaLogUtenteModifica_PrevAndNext(
			long ID_LOG, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = findByPrimaryKey(ID_LOG);

		Session session = null;

		try {
			session = openSession();

			RubricaLog[] array = new RubricaLogImpl[3];

			array[0] = getByRubricaLogUtenteModifica_PrevAndNext(
				session, rubricaLog, FK_UTENTE_MODIFICA, orderByComparator,
				true);

			array[1] = rubricaLog;

			array[2] = getByRubricaLogUtenteModifica_PrevAndNext(
				session, rubricaLog, FK_UTENTE_MODIFICA, orderByComparator,
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

	protected RubricaLog getByRubricaLogUtenteModifica_PrevAndNext(
		Session session, RubricaLog rubricaLog, long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RUBRICALOG_WHERE);

		query.append(
			_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

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
			query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_UTENTE_MODIFICA);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica logs where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	@Override
	public void removeByRubricaLogUtenteModifica(long FK_UTENTE_MODIFICA) {
		for (RubricaLog rubricaLog :
				findByRubricaLogUtenteModifica(
					FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaLog);
		}
	}

	/**
	 * Returns the number of rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica logs
	 */
	@Override
	public int countByRubricaLogUtenteModifica(long FK_UTENTE_MODIFICA) {
		FinderPath finderPath = _finderPathCountByRubricaLogUtenteModifica;

		Object[] finderArgs = new Object[] {FK_UTENTE_MODIFICA};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICALOG_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

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
		_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2 =
			"rubricaLog.FK_UTENTE_MODIFICA = ?";

	private FinderPath _finderPathWithPaginationFindByRubricaLogDataModifica;
	private FinderPath _finderPathWithoutPaginationFindByRubricaLogDataModifica;
	private FinderPath _finderPathCountByRubricaLogDataModifica;

	/**
	 * Returns all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO) {

		return findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end) {

		return findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaLogDataModifica;
			finderArgs = new Object[] {
				_getTime(DATA_MODIFICA), FK_SITO_PROPRIETARIO
			};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRubricaLogDataModifica;
			finderArgs = new Object[] {
				_getTime(DATA_MODIFICA), FK_SITO_PROPRIETARIO, start, end,
				orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if (!Objects.equals(
							DATA_MODIFICA, rubricaLog.getDATA_MODIFICA()) ||
						(FK_SITO_PROPRIETARIO !=
							rubricaLog.getFK_SITO_PROPRIETARIO())) {

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

			query.append(_SQL_SELECT_RUBRICALOG_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				query.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				query.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
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

				qPos.add(FK_SITO_PROPRIETARIO);

				if (!pagination) {
					list = (List<RubricaLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaLog>)QueryUtil.list(
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
	 * Returns the first rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogDataModifica_First(
			Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogDataModifica_First(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATA_MODIFICA=");
		msg.append(DATA_MODIFICA);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the first rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogDataModifica_First(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		List<RubricaLog> list = findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogDataModifica_Last(
			Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogDataModifica_Last(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATA_MODIFICA=");
		msg.append(DATA_MODIFICA);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the last rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogDataModifica_Last(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		int count = countByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO);

		if (count == 0) {
			return null;
		}

		List<RubricaLog> list = findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog[] findByRubricaLogDataModifica_PrevAndNext(
			long ID_LOG, Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = findByPrimaryKey(ID_LOG);

		Session session = null;

		try {
			session = openSession();

			RubricaLog[] array = new RubricaLogImpl[3];

			array[0] = getByRubricaLogDataModifica_PrevAndNext(
				session, rubricaLog, DATA_MODIFICA, FK_SITO_PROPRIETARIO,
				orderByComparator, true);

			array[1] = rubricaLog;

			array[2] = getByRubricaLogDataModifica_PrevAndNext(
				session, rubricaLog, DATA_MODIFICA, FK_SITO_PROPRIETARIO,
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

	protected RubricaLog getByRubricaLogDataModifica_PrevAndNext(
		Session session, RubricaLog rubricaLog, Date DATA_MODIFICA,
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RUBRICALOG_WHERE);

		boolean bindDATA_MODIFICA = false;

		if (DATA_MODIFICA == null) {
			query.append(_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1);
		}
		else {
			bindDATA_MODIFICA = true;

			query.append(_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2);
		}

		query.append(
			_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2);

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
			query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDATA_MODIFICA) {
			qPos.add(new Timestamp(DATA_MODIFICA.getTime()));
		}

		qPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	@Override
	public void removeByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO) {

		for (RubricaLog rubricaLog :
				findByRubricaLogDataModifica(
					DATA_MODIFICA, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(rubricaLog);
		}
	}

	/**
	 * Returns the number of rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	@Override
	public int countByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO) {

		FinderPath finderPath = _finderPathCountByRubricaLogDataModifica;

		Object[] finderArgs = new Object[] {
			_getTime(DATA_MODIFICA), FK_SITO_PROPRIETARIO
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RUBRICALOG_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				query.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				query.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATA_MODIFICA) {
					qPos.add(new Timestamp(DATA_MODIFICA.getTime()));
				}

				qPos.add(FK_SITO_PROPRIETARIO);

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
		_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1 =
			"rubricaLog.DATA_MODIFICA IS NULL AND ";

	private static final String
		_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2 =
			"rubricaLog.DATA_MODIFICA = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2 =
			"rubricaLog.FK_SITO_PROPRIETARIO = ?";

	private FinderPath _finderPathWithPaginationFindByRubricaLogTabella;
	private FinderPath _finderPathWithoutPaginationFindByRubricaLogTabella;
	private FinderPath _finderPathCountByRubricaLogTabella;

	/**
	 * Returns all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO) {

		return findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end) {

		return findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		TABELLA = Objects.toString(TABELLA, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRubricaLogTabella;
			finderArgs = new Object[] {TABELLA, FK_SITO_PROPRIETARIO};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRubricaLogTabella;
			finderArgs = new Object[] {
				TABELLA, FK_SITO_PROPRIETARIO, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if (!TABELLA.equals(rubricaLog.getTABELLA()) ||
						(FK_SITO_PROPRIETARIO !=
							rubricaLog.getFK_SITO_PROPRIETARIO())) {

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

			query.append(_SQL_SELECT_RUBRICALOG_WHERE);

			boolean bindTABELLA = false;

			if (TABELLA.isEmpty()) {
				query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3);
			}
			else {
				bindTABELLA = true;

				query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTABELLA) {
					qPos.add(TABELLA);
				}

				qPos.add(FK_SITO_PROPRIETARIO);

				if (!pagination) {
					list = (List<RubricaLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaLog>)QueryUtil.list(
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
	 * Returns the first rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogTabella_First(
			String TABELLA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogTabella_First(
			TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("TABELLA=");
		msg.append(TABELLA);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the first rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogTabella_First(
		String TABELLA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		List<RubricaLog> list = findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogTabella_Last(
			String TABELLA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogTabella_Last(
			TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("TABELLA=");
		msg.append(TABELLA);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the last rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogTabella_Last(
		String TABELLA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		int count = countByRubricaLogTabella(TABELLA, FK_SITO_PROPRIETARIO);

		if (count == 0) {
			return null;
		}

		List<RubricaLog> list = findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog[] findByRubricaLogTabella_PrevAndNext(
			long ID_LOG, String TABELLA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		TABELLA = Objects.toString(TABELLA, "");

		RubricaLog rubricaLog = findByPrimaryKey(ID_LOG);

		Session session = null;

		try {
			session = openSession();

			RubricaLog[] array = new RubricaLogImpl[3];

			array[0] = getByRubricaLogTabella_PrevAndNext(
				session, rubricaLog, TABELLA, FK_SITO_PROPRIETARIO,
				orderByComparator, true);

			array[1] = rubricaLog;

			array[2] = getByRubricaLogTabella_PrevAndNext(
				session, rubricaLog, TABELLA, FK_SITO_PROPRIETARIO,
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

	protected RubricaLog getByRubricaLogTabella_PrevAndNext(
		Session session, RubricaLog rubricaLog, String TABELLA,
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RUBRICALOG_WHERE);

		boolean bindTABELLA = false;

		if (TABELLA.isEmpty()) {
			query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3);
		}
		else {
			bindTABELLA = true;

			query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2);
		}

		query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2);

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
			query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTABELLA) {
			qPos.add(TABELLA);
		}

		qPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	@Override
	public void removeByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO) {

		for (RubricaLog rubricaLog :
				findByRubricaLogTabella(
					TABELLA, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(rubricaLog);
		}
	}

	/**
	 * Returns the number of rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	@Override
	public int countByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO) {

		TABELLA = Objects.toString(TABELLA, "");

		FinderPath finderPath = _finderPathCountByRubricaLogTabella;

		Object[] finderArgs = new Object[] {TABELLA, FK_SITO_PROPRIETARIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RUBRICALOG_WHERE);

			boolean bindTABELLA = false;

			if (TABELLA.isEmpty()) {
				query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3);
			}
			else {
				bindTABELLA = true;

				query.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTABELLA) {
					qPos.add(TABELLA);
				}

				qPos.add(FK_SITO_PROPRIETARIO);

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

	private static final String _FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2 =
		"rubricaLog.TABELLA = ? AND ";

	private static final String _FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3 =
		"(rubricaLog.TABELLA IS NULL OR rubricaLog.TABELLA = '') AND ";

	private static final String
		_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2 =
			"rubricaLog.FK_SITO_PROPRIETARIO = ?";

	private FinderPath _finderPathWithPaginationFindByRubricaLogIdOggetto;
	private FinderPath _finderPathWithoutPaginationFindByRubricaLogIdOggetto;
	private FinderPath _finderPathCountByRubricaLogIdOggetto;

	/**
	 * Returns all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO) {

		return findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end) {

		return findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		ID_OGGETTO = Objects.toString(ID_OGGETTO, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRubricaLogIdOggetto;
			finderArgs = new Object[] {ID_OGGETTO, FK_SITO_PROPRIETARIO};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRubricaLogIdOggetto;
			finderArgs = new Object[] {
				ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if (!ID_OGGETTO.equals(rubricaLog.getID_OGGETTO()) ||
						(FK_SITO_PROPRIETARIO !=
							rubricaLog.getFK_SITO_PROPRIETARIO())) {

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

			query.append(_SQL_SELECT_RUBRICALOG_WHERE);

			boolean bindID_OGGETTO = false;

			if (ID_OGGETTO.isEmpty()) {
				query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3);
			}
			else {
				bindID_OGGETTO = true;

				query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindID_OGGETTO) {
					qPos.add(ID_OGGETTO);
				}

				qPos.add(FK_SITO_PROPRIETARIO);

				if (!pagination) {
					list = (List<RubricaLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaLog>)QueryUtil.list(
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
	 * Returns the first rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogIdOggetto_First(
			String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogIdOggetto_First(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ID_OGGETTO=");
		msg.append(ID_OGGETTO);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the first rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogIdOggetto_First(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		List<RubricaLog> list = findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogIdOggetto_Last(
			String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogIdOggetto_Last(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ID_OGGETTO=");
		msg.append(ID_OGGETTO);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the last rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogIdOggetto_Last(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		int count = countByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO);

		if (count == 0) {
			return null;
		}

		List<RubricaLog> list = findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog[] findByRubricaLogIdOggetto_PrevAndNext(
			long ID_LOG, String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		ID_OGGETTO = Objects.toString(ID_OGGETTO, "");

		RubricaLog rubricaLog = findByPrimaryKey(ID_LOG);

		Session session = null;

		try {
			session = openSession();

			RubricaLog[] array = new RubricaLogImpl[3];

			array[0] = getByRubricaLogIdOggetto_PrevAndNext(
				session, rubricaLog, ID_OGGETTO, FK_SITO_PROPRIETARIO,
				orderByComparator, true);

			array[1] = rubricaLog;

			array[2] = getByRubricaLogIdOggetto_PrevAndNext(
				session, rubricaLog, ID_OGGETTO, FK_SITO_PROPRIETARIO,
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

	protected RubricaLog getByRubricaLogIdOggetto_PrevAndNext(
		Session session, RubricaLog rubricaLog, String ID_OGGETTO,
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RUBRICALOG_WHERE);

		boolean bindID_OGGETTO = false;

		if (ID_OGGETTO.isEmpty()) {
			query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3);
		}
		else {
			bindID_OGGETTO = true;

			query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2);
		}

		query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2);

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
			query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindID_OGGETTO) {
			qPos.add(ID_OGGETTO);
		}

		qPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	@Override
	public void removeByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO) {

		for (RubricaLog rubricaLog :
				findByRubricaLogIdOggetto(
					ID_OGGETTO, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(rubricaLog);
		}
	}

	/**
	 * Returns the number of rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	@Override
	public int countByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO) {

		ID_OGGETTO = Objects.toString(ID_OGGETTO, "");

		FinderPath finderPath = _finderPathCountByRubricaLogIdOggetto;

		Object[] finderArgs = new Object[] {ID_OGGETTO, FK_SITO_PROPRIETARIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RUBRICALOG_WHERE);

			boolean bindID_OGGETTO = false;

			if (ID_OGGETTO.isEmpty()) {
				query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3);
			}
			else {
				bindID_OGGETTO = true;

				query.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindID_OGGETTO) {
					qPos.add(ID_OGGETTO);
				}

				qPos.add(FK_SITO_PROPRIETARIO);

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
		_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2 =
			"rubricaLog.ID_OGGETTO = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3 =
			"(rubricaLog.ID_OGGETTO IS NULL OR rubricaLog.ID_OGGETTO = '') AND ";

	private static final String
		_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2 =
			"rubricaLog.FK_SITO_PROPRIETARIO = ?";

	private FinderPath
		_finderPathWithPaginationFindByRubricaLogBySitoProprietario;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario;
	private FinderPath _finderPathCountByRubricaLogBySitoProprietario;

	/**
	 * Returns all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO) {

		return findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end) {

		return findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario;
			finderArgs = new Object[] {FK_SITO_PROPRIETARIO};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByRubricaLogBySitoProprietario;
			finderArgs = new Object[] {
				FK_SITO_PROPRIETARIO, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if ((FK_SITO_PROPRIETARIO !=
							rubricaLog.getFK_SITO_PROPRIETARIO())) {

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

			query.append(_SQL_SELECT_RUBRICALOG_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_SITO_PROPRIETARIO);

				if (!pagination) {
					list = (List<RubricaLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaLog>)QueryUtil.list(
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
	 * Returns the first rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogBySitoProprietario_First(
			long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogBySitoProprietario_First(
			FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the first rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogBySitoProprietario_First(
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		List<RubricaLog> list = findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog findByRubricaLogBySitoProprietario_Last(
			long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByRubricaLogBySitoProprietario_Last(
			FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaLog != null) {
			return rubricaLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaLogException(msg.toString());
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	@Override
	public RubricaLog fetchByRubricaLogBySitoProprietario_Last(
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		int count = countByRubricaLogBySitoProprietario(FK_SITO_PROPRIETARIO);

		if (count == 0) {
			return null;
		}

		List<RubricaLog> list = findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog[] findByRubricaLogBySitoProprietario_PrevAndNext(
			long ID_LOG, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = findByPrimaryKey(ID_LOG);

		Session session = null;

		try {
			session = openSession();

			RubricaLog[] array = new RubricaLogImpl[3];

			array[0] = getByRubricaLogBySitoProprietario_PrevAndNext(
				session, rubricaLog, FK_SITO_PROPRIETARIO, orderByComparator,
				true);

			array[1] = rubricaLog;

			array[2] = getByRubricaLogBySitoProprietario_PrevAndNext(
				session, rubricaLog, FK_SITO_PROPRIETARIO, orderByComparator,
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

	protected RubricaLog getByRubricaLogBySitoProprietario_PrevAndNext(
		Session session, RubricaLog rubricaLog, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RUBRICALOG_WHERE);

		query.append(
			_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

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
			query.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica logs where FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	@Override
	public void removeByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO) {

		for (RubricaLog rubricaLog :
				findByRubricaLogBySitoProprietario(
					FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaLog);
		}
	}

	/**
	 * Returns the number of rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	@Override
	public int countByRubricaLogBySitoProprietario(long FK_SITO_PROPRIETARIO) {
		FinderPath finderPath = _finderPathCountByRubricaLogBySitoProprietario;

		Object[] finderArgs = new Object[] {FK_SITO_PROPRIETARIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICALOG_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_SITO_PROPRIETARIO);

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
		_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2 =
			"rubricaLog.FK_SITO_PROPRIETARIO = ?";

	public RubricaLogPersistenceImpl() {
		setModelClass(RubricaLog.class);
	}

	/**
	 * Caches the rubrica log in the entity cache if it is enabled.
	 *
	 * @param rubricaLog the rubrica log
	 */
	@Override
	public void cacheResult(RubricaLog rubricaLog) {
		entityCache.putResult(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED, RubricaLogImpl.class,
			rubricaLog.getPrimaryKey(), rubricaLog);

		rubricaLog.resetOriginalValues();
	}

	/**
	 * Caches the rubrica logs in the entity cache if it is enabled.
	 *
	 * @param rubricaLogs the rubrica logs
	 */
	@Override
	public void cacheResult(List<RubricaLog> rubricaLogs) {
		for (RubricaLog rubricaLog : rubricaLogs) {
			if (entityCache.getResult(
					RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
					RubricaLogImpl.class, rubricaLog.getPrimaryKey()) == null) {

				cacheResult(rubricaLog);
			}
			else {
				rubricaLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaLog rubricaLog) {
		entityCache.removeResult(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED, RubricaLogImpl.class,
			rubricaLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RubricaLog> rubricaLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaLog rubricaLog : rubricaLogs) {
			entityCache.removeResult(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED, RubricaLogImpl.class,
				rubricaLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rubrica log with the primary key. Does not add the rubrica log to the database.
	 *
	 * @param ID_LOG the primary key for the new rubrica log
	 * @return the new rubrica log
	 */
	@Override
	public RubricaLog create(long ID_LOG) {
		RubricaLog rubricaLog = new RubricaLogImpl();

		rubricaLog.setNew(true);
		rubricaLog.setPrimaryKey(ID_LOG);

		return rubricaLog;
	}

	/**
	 * Removes the rubrica log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log that was removed
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog remove(long ID_LOG) throws NoSuchRubricaLogException {
		return remove((Serializable)ID_LOG);
	}

	/**
	 * Removes the rubrica log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica log
	 * @return the rubrica log that was removed
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog remove(Serializable primaryKey)
		throws NoSuchRubricaLogException {

		Session session = null;

		try {
			session = openSession();

			RubricaLog rubricaLog = (RubricaLog)session.get(
				RubricaLogImpl.class, primaryKey);

			if (rubricaLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaLog);
		}
		catch (NoSuchRubricaLogException nsee) {
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
	protected RubricaLog removeImpl(RubricaLog rubricaLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaLog)) {
				rubricaLog = (RubricaLog)session.get(
					RubricaLogImpl.class, rubricaLog.getPrimaryKeyObj());
			}

			if (rubricaLog != null) {
				session.delete(rubricaLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaLog != null) {
			clearCache(rubricaLog);
		}

		return rubricaLog;
	}

	@Override
	public RubricaLog updateImpl(RubricaLog rubricaLog) {
		boolean isNew = rubricaLog.isNew();

		if (!(rubricaLog instanceof RubricaLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(rubricaLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaLog implementation " +
					rubricaLog.getClass());
		}

		RubricaLogModelImpl rubricaLogModelImpl =
			(RubricaLogModelImpl)rubricaLog;

		Session session = null;

		try {
			session = openSession();

			if (rubricaLog.isNew()) {
				session.save(rubricaLog);

				rubricaLog.setNew(false);
			}
			else {
				rubricaLog = (RubricaLog)session.merge(rubricaLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaLogModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaLogModelImpl.getFK_UTENTE_MODIFICA()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaLogUtenteModifica, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaLogUtenteModifica,
				args);

			args = new Object[] {
				rubricaLogModelImpl.getDATA_MODIFICA(),
				rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaLogDataModifica, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaLogDataModifica, args);

			args = new Object[] {
				rubricaLogModelImpl.getTABELLA(),
				rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(_finderPathCountByRubricaLogTabella, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaLogTabella, args);

			args = new Object[] {
				rubricaLogModelImpl.getID_OGGETTO(),
				rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaLogIdOggetto, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaLogIdOggetto, args);

			args = new Object[] {rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()};

			finderCache.removeResult(
				_finderPathCountByRubricaLogBySitoProprietario, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaLogUtenteModifica.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaLogModelImpl.getOriginalFK_UTENTE_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogUtenteModifica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogUtenteModifica,
					args);

				args = new Object[] {
					rubricaLogModelImpl.getFK_UTENTE_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogUtenteModifica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogUtenteModifica,
					args);
			}

			if ((rubricaLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaLogDataModifica.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaLogModelImpl.getOriginalDATA_MODIFICA(),
					rubricaLogModelImpl.getOriginalFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogDataModifica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogDataModifica,
					args);

				args = new Object[] {
					rubricaLogModelImpl.getDATA_MODIFICA(),
					rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogDataModifica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogDataModifica,
					args);
			}

			if ((rubricaLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaLogTabella.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaLogModelImpl.getOriginalTABELLA(),
					rubricaLogModelImpl.getOriginalFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogTabella, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogTabella, args);

				args = new Object[] {
					rubricaLogModelImpl.getTABELLA(),
					rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogTabella, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogTabella, args);
			}

			if ((rubricaLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaLogIdOggetto.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaLogModelImpl.getOriginalID_OGGETTO(),
					rubricaLogModelImpl.getOriginalFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogIdOggetto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogIdOggetto,
					args);

				args = new Object[] {
					rubricaLogModelImpl.getID_OGGETTO(),
					rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogIdOggetto, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogIdOggetto,
					args);
			}

			if ((rubricaLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRubricaLogBySitoProprietario.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaLogModelImpl.getOriginalFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogBySitoProprietario, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario,
					args);

				args = new Object[] {
					rubricaLogModelImpl.getFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByRubricaLogBySitoProprietario, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario,
					args);
			}
		}

		entityCache.putResult(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED, RubricaLogImpl.class,
			rubricaLog.getPrimaryKey(), rubricaLog, false);

		rubricaLog.resetOriginalValues();

		return rubricaLog;
	}

	/**
	 * Returns the rubrica log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica log
	 * @return the rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaLogException {

		RubricaLog rubricaLog = fetchByPrimaryKey(primaryKey);

		if (rubricaLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaLog;
	}

	/**
	 * Returns the rubrica log with the primary key or throws a <code>NoSuchRubricaLogException</code> if it could not be found.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog findByPrimaryKey(long ID_LOG)
		throws NoSuchRubricaLogException {

		return findByPrimaryKey((Serializable)ID_LOG);
	}

	/**
	 * Returns the rubrica log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica log
	 * @return the rubrica log, or <code>null</code> if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED, RubricaLogImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaLog rubricaLog = (RubricaLog)serializable;

		if (rubricaLog == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaLog = (RubricaLog)session.get(
					RubricaLogImpl.class, primaryKey);

				if (rubricaLog != null) {
					cacheResult(rubricaLog);
				}
				else {
					entityCache.putResult(
						RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
						RubricaLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
					RubricaLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaLog;
	}

	/**
	 * Returns the rubrica log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log, or <code>null</code> if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog fetchByPrimaryKey(long ID_LOG) {
		return fetchByPrimaryKey((Serializable)ID_LOG);
	}

	@Override
	public Map<Serializable, RubricaLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaLog> map =
			new HashMap<Serializable, RubricaLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaLog rubricaLog = fetchByPrimaryKey(primaryKey);

			if (rubricaLog != null) {
				map.put(primaryKey, rubricaLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED, RubricaLogImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICALOG_WHERE_PKS_IN);

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

			for (RubricaLog rubricaLog : (List<RubricaLog>)q.list()) {
				map.put(rubricaLog.getPrimaryKeyObj(), rubricaLog);

				cacheResult(rubricaLog);

				uncachedPrimaryKeys.remove(rubricaLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
					RubricaLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica logs.
	 *
	 * @return the rubrica logs
	 */
	@Override
	public List<RubricaLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of rubrica logs
	 */
	@Override
	public List<RubricaLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica logs
	 */
	@Override
	public List<RubricaLog> findAll(
		int start, int end, OrderByComparator<RubricaLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica logs
	 */
	@Override
	public List<RubricaLog> findAll(
		int start, int end, OrderByComparator<RubricaLog> orderByComparator,
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

		List<RubricaLog> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICALOG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICALOG;

				if (pagination) {
					sql = sql.concat(RubricaLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaLog>)QueryUtil.list(
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
	 * Removes all the rubrica logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaLog rubricaLog : findAll()) {
			remove(rubricaLog);
		}
	}

	/**
	 * Returns the number of rubrica logs.
	 *
	 * @return the number of rubrica logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICALOG);

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
		return RubricaLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica log persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRubricaLogUtenteModifica =
			new FinderPath(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
				RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaLogUtenteModifica",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByRubricaLogUtenteModifica =
			new FinderPath(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
				RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaLogUtenteModifica",
				new String[] {Long.class.getName()},
				RubricaLogModelImpl.FK_UTENTE_MODIFICA_COLUMN_BITMASK);

		_finderPathCountByRubricaLogUtenteModifica = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogUtenteModifica",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRubricaLogDataModifica = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRubricaLogDataModifica",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRubricaLogDataModifica =
			new FinderPath(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
				RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaLogDataModifica",
				new String[] {Date.class.getName(), Long.class.getName()},
				RubricaLogModelImpl.DATA_MODIFICA_COLUMN_BITMASK |
				RubricaLogModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByRubricaLogDataModifica = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogDataModifica",
			new String[] {Date.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByRubricaLogTabella = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRubricaLogTabella",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRubricaLogTabella = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRubricaLogTabella",
			new String[] {String.class.getName(), Long.class.getName()},
			RubricaLogModelImpl.TABELLA_COLUMN_BITMASK |
			RubricaLogModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByRubricaLogTabella = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogTabella",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByRubricaLogIdOggetto = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRubricaLogIdOggetto",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRubricaLogIdOggetto = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRubricaLogIdOggetto",
			new String[] {String.class.getName(), Long.class.getName()},
			RubricaLogModelImpl.ID_OGGETTO_COLUMN_BITMASK |
			RubricaLogModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByRubricaLogIdOggetto = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogIdOggetto",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByRubricaLogBySitoProprietario =
			new FinderPath(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
				RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaLogBySitoProprietario",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario =
			new FinderPath(
				RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
				RubricaLogModelImpl.FINDER_CACHE_ENABLED, RubricaLogImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaLogBySitoProprietario",
				new String[] {Long.class.getName()},
				RubricaLogModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByRubricaLogBySitoProprietario = new FinderPath(
			RubricaLogModelImpl.ENTITY_CACHE_ENABLED,
			RubricaLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogBySitoProprietario",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaLogImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICALOG =
		"SELECT rubricaLog FROM RubricaLog rubricaLog";

	private static final String _SQL_SELECT_RUBRICALOG_WHERE_PKS_IN =
		"SELECT rubricaLog FROM RubricaLog rubricaLog WHERE ID_LOG IN (";

	private static final String _SQL_SELECT_RUBRICALOG_WHERE =
		"SELECT rubricaLog FROM RubricaLog rubricaLog WHERE ";

	private static final String _SQL_COUNT_RUBRICALOG =
		"SELECT COUNT(rubricaLog) FROM RubricaLog rubricaLog";

	private static final String _SQL_COUNT_RUBRICALOG_WHERE =
		"SELECT COUNT(rubricaLog) FROM RubricaLog rubricaLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaLogPersistenceImpl.class);

}