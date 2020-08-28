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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaNominativoException;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.model.impl.RubricaNominativoImpl;
import it.eng.allerte.model.impl.RubricaNominativoModelImpl;
import it.eng.allerte.service.persistence.RubricaNominativoPersistence;

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
 * The persistence implementation for the rubrica nominativo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaNominativoPersistenceImpl
	extends BasePersistenceImpl<RubricaNominativo>
	implements RubricaNominativoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaNominativoUtil</code> to access the rubrica nominativo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaNominativoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByNominativoPerSitoProprietario;
	private FinderPath _finderPathCountByNominativoPerSitoProprietario;

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaNominativoException</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByNominativoPerSitoProprietario(
			long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo =
			fetchByNominativoPerSitoProprietario(
				ID_NOMINATIVO, FK_SITO_PROPRIETARIO);

		if (rubricaNominativo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ID_NOMINATIVO=");
			msg.append(ID_NOMINATIVO);

			msg.append(", FK_SITO_PROPRIETARIO=");
			msg.append(FK_SITO_PROPRIETARIO);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRubricaNominativoException(msg.toString());
		}

		return rubricaNominativo;
	}

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO) {

		return fetchByNominativoPerSitoProprietario(
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO, true);
	}

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO,
		boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO
		};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByNominativoPerSitoProprietario, finderArgs,
				this);
		}

		if (result instanceof RubricaNominativo) {
			RubricaNominativo rubricaNominativo = (RubricaNominativo)result;

			if ((ID_NOMINATIVO != rubricaNominativo.getID_NOMINATIVO()) ||
				(FK_SITO_PROPRIETARIO !=
					rubricaNominativo.getFK_SITO_PROPRIETARIO())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERSITOPROPRIETARIO_ID_NOMINATIVO_2);

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ID_NOMINATIVO);

				qPos.add(FK_SITO_PROPRIETARIO);

				List<RubricaNominativo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByNominativoPerSitoProprietario,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RubricaNominativoPersistenceImpl.fetchByNominativoPerSitoProprietario(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RubricaNominativo rubricaNominativo = list.get(0);

					result = rubricaNominativo;

					cacheResult(rubricaNominativo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByNominativoPerSitoProprietario,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RubricaNominativo)result;
		}
	}

	/**
	 * Removes the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica nominativo that was removed
	 */
	@Override
	public RubricaNominativo removeByNominativoPerSitoProprietario(
			long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo =
			findByNominativoPerSitoProprietario(
				ID_NOMINATIVO, FK_SITO_PROPRIETARIO);

		return remove(rubricaNominativo);
	}

	/**
	 * Returns the number of rubrica nominativos where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica nominativos
	 */
	@Override
	public int countByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO) {

		FinderPath finderPath = _finderPathCountByNominativoPerSitoProprietario;

		Object[] finderArgs = new Object[] {
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RUBRICANOMINATIVO_WHERE);

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERSITOPROPRIETARIO_ID_NOMINATIVO_2);

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ID_NOMINATIVO);

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
		_FINDER_COLUMN_NOMINATIVOPERSITOPROPRIETARIO_ID_NOMINATIVO_2 =
			"rubricaNominativo.ID_NOMINATIVO = ? AND ";

	private static final String
		_FINDER_COLUMN_NOMINATIVOPERSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2 =
			"rubricaNominativo.FK_SITO_PROPRIETARIO = ?";

	private FinderPath _finderPathWithPaginationFindByUtentePortale;
	private FinderPath _finderPathWithoutPaginationFindByUtentePortale;
	private FinderPath _finderPathCountByUtentePortale;

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @return the matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtentePortale(long FK_UTENTE_PORTALE) {
		return findByUtentePortale(
			FK_UTENTE_PORTALE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end) {

		return findByUtentePortale(FK_UTENTE_PORTALE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return findByUtentePortale(
			FK_UTENTE_PORTALE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUtentePortale;
			finderArgs = new Object[] {FK_UTENTE_PORTALE};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUtentePortale;
			finderArgs = new Object[] {
				FK_UTENTE_PORTALE, start, end, orderByComparator
			};
		}

		List<RubricaNominativo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaNominativo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaNominativo rubricaNominativo : list) {
					if ((FK_UTENTE_PORTALE !=
							rubricaNominativo.getFK_UTENTE_PORTALE())) {

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

			query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

			query.append(_FINDER_COLUMN_UTENTEPORTALE_FK_UTENTE_PORTALE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_PORTALE);

				if (!pagination) {
					list = (List<RubricaNominativo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaNominativo>)QueryUtil.list(
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
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByUtentePortale_First(
			long FK_UTENTE_PORTALE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByUtentePortale_First(
			FK_UTENTE_PORTALE, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_PORTALE=");
		msg.append(FK_UTENTE_PORTALE);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByUtentePortale_First(
		long FK_UTENTE_PORTALE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		List<RubricaNominativo> list = findByUtentePortale(
			FK_UTENTE_PORTALE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByUtentePortale_Last(
			long FK_UTENTE_PORTALE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByUtentePortale_Last(
			FK_UTENTE_PORTALE, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_PORTALE=");
		msg.append(FK_UTENTE_PORTALE);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByUtentePortale_Last(
		long FK_UTENTE_PORTALE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		int count = countByUtentePortale(FK_UTENTE_PORTALE);

		if (count == 0) {
			return null;
		}

		List<RubricaNominativo> list = findByUtentePortale(
			FK_UTENTE_PORTALE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo[] findByUtentePortale_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_PORTALE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = findByPrimaryKey(ID_NOMINATIVO);

		Session session = null;

		try {
			session = openSession();

			RubricaNominativo[] array = new RubricaNominativoImpl[3];

			array[0] = getByUtentePortale_PrevAndNext(
				session, rubricaNominativo, FK_UTENTE_PORTALE,
				orderByComparator, true);

			array[1] = rubricaNominativo;

			array[2] = getByUtentePortale_PrevAndNext(
				session, rubricaNominativo, FK_UTENTE_PORTALE,
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

	protected RubricaNominativo getByUtentePortale_PrevAndNext(
		Session session, RubricaNominativo rubricaNominativo,
		long FK_UTENTE_PORTALE,
		OrderByComparator<RubricaNominativo> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

		query.append(_FINDER_COLUMN_UTENTEPORTALE_FK_UTENTE_PORTALE_2);

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
			query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FK_UTENTE_PORTALE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaNominativo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaNominativo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_PORTALE = &#63; from the database.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 */
	@Override
	public void removeByUtentePortale(long FK_UTENTE_PORTALE) {
		for (RubricaNominativo rubricaNominativo :
				findByUtentePortale(
					FK_UTENTE_PORTALE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaNominativo);
		}
	}

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @return the number of matching rubrica nominativos
	 */
	@Override
	public int countByUtentePortale(long FK_UTENTE_PORTALE) {
		FinderPath finderPath = _finderPathCountByUtentePortale;

		Object[] finderArgs = new Object[] {FK_UTENTE_PORTALE};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICANOMINATIVO_WHERE);

			query.append(_FINDER_COLUMN_UTENTEPORTALE_FK_UTENTE_PORTALE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_PORTALE);

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
		_FINDER_COLUMN_UTENTEPORTALE_FK_UTENTE_PORTALE_2 =
			"rubricaNominativo.FK_UTENTE_PORTALE = ?";

	private FinderPath _finderPathWithPaginationFindByUtenteCreazione;
	private FinderPath _finderPathWithoutPaginationFindByUtenteCreazione;
	private FinderPath _finderPathCountByUtenteCreazione;

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE) {

		return findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end) {

		return findByUtenteCreazione(FK_UTENTE_CREAZIONE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUtenteCreazione;
			finderArgs = new Object[] {FK_UTENTE_CREAZIONE};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUtenteCreazione;
			finderArgs = new Object[] {
				FK_UTENTE_CREAZIONE, start, end, orderByComparator
			};
		}

		List<RubricaNominativo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaNominativo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaNominativo rubricaNominativo : list) {
					if ((FK_UTENTE_CREAZIONE !=
							rubricaNominativo.getFK_UTENTE_CREAZIONE())) {

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

			query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

			query.append(_FINDER_COLUMN_UTENTECREAZIONE_FK_UTENTE_CREAZIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_CREAZIONE);

				if (!pagination) {
					list = (List<RubricaNominativo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaNominativo>)QueryUtil.list(
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
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByUtenteCreazione_First(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByUtenteCreazione_First(
			FK_UTENTE_CREAZIONE, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_CREAZIONE=");
		msg.append(FK_UTENTE_CREAZIONE);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByUtenteCreazione_First(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		List<RubricaNominativo> list = findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByUtenteCreazione_Last(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByUtenteCreazione_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_CREAZIONE=");
		msg.append(FK_UTENTE_CREAZIONE);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByUtenteCreazione_Last(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		int count = countByUtenteCreazione(FK_UTENTE_CREAZIONE);

		if (count == 0) {
			return null;
		}

		List<RubricaNominativo> list = findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo[] findByUtenteCreazione_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = findByPrimaryKey(ID_NOMINATIVO);

		Session session = null;

		try {
			session = openSession();

			RubricaNominativo[] array = new RubricaNominativoImpl[3];

			array[0] = getByUtenteCreazione_PrevAndNext(
				session, rubricaNominativo, FK_UTENTE_CREAZIONE,
				orderByComparator, true);

			array[1] = rubricaNominativo;

			array[2] = getByUtenteCreazione_PrevAndNext(
				session, rubricaNominativo, FK_UTENTE_CREAZIONE,
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

	protected RubricaNominativo getByUtenteCreazione_PrevAndNext(
		Session session, RubricaNominativo rubricaNominativo,
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaNominativo> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

		query.append(_FINDER_COLUMN_UTENTECREAZIONE_FK_UTENTE_CREAZIONE_2);

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
			query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
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
						rubricaNominativo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaNominativo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	@Override
	public void removeByUtenteCreazione(long FK_UTENTE_CREAZIONE) {
		for (RubricaNominativo rubricaNominativo :
				findByUtenteCreazione(
					FK_UTENTE_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaNominativo);
		}
	}

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica nominativos
	 */
	@Override
	public int countByUtenteCreazione(long FK_UTENTE_CREAZIONE) {
		FinderPath finderPath = _finderPathCountByUtenteCreazione;

		Object[] finderArgs = new Object[] {FK_UTENTE_CREAZIONE};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICANOMINATIVO_WHERE);

			query.append(_FINDER_COLUMN_UTENTECREAZIONE_FK_UTENTE_CREAZIONE_2);

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
		_FINDER_COLUMN_UTENTECREAZIONE_FK_UTENTE_CREAZIONE_2 =
			"rubricaNominativo.FK_UTENTE_CREAZIONE = ?";

	private FinderPath _finderPathWithPaginationFindByUtenteModifica;
	private FinderPath _finderPathWithoutPaginationFindByUtenteModifica;
	private FinderPath _finderPathCountByUtenteModifica;

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA) {

		return findByUtenteModifica(
			FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return findByUtenteModifica(FK_UTENTE_MODIFICA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return findByUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUtenteModifica;
			finderArgs = new Object[] {FK_UTENTE_MODIFICA};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUtenteModifica;
			finderArgs = new Object[] {
				FK_UTENTE_MODIFICA, start, end, orderByComparator
			};
		}

		List<RubricaNominativo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaNominativo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaNominativo rubricaNominativo : list) {
					if ((FK_UTENTE_MODIFICA !=
							rubricaNominativo.getFK_UTENTE_MODIFICA())) {

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

			query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

			query.append(_FINDER_COLUMN_UTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_UTENTE_MODIFICA);

				if (!pagination) {
					list = (List<RubricaNominativo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaNominativo>)QueryUtil.list(
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
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByUtenteModifica_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByUtenteModifica_First(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_MODIFICA=");
		msg.append(FK_UTENTE_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByUtenteModifica_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		List<RubricaNominativo> list = findByUtenteModifica(
			FK_UTENTE_MODIFICA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByUtenteModifica_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByUtenteModifica_Last(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FK_UTENTE_MODIFICA=");
		msg.append(FK_UTENTE_MODIFICA);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByUtenteModifica_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		int count = countByUtenteModifica(FK_UTENTE_MODIFICA);

		if (count == 0) {
			return null;
		}

		List<RubricaNominativo> list = findByUtenteModifica(
			FK_UTENTE_MODIFICA, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo[] findByUtenteModifica_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = findByPrimaryKey(ID_NOMINATIVO);

		Session session = null;

		try {
			session = openSession();

			RubricaNominativo[] array = new RubricaNominativoImpl[3];

			array[0] = getByUtenteModifica_PrevAndNext(
				session, rubricaNominativo, FK_UTENTE_MODIFICA,
				orderByComparator, true);

			array[1] = rubricaNominativo;

			array[2] = getByUtenteModifica_PrevAndNext(
				session, rubricaNominativo, FK_UTENTE_MODIFICA,
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

	protected RubricaNominativo getByUtenteModifica_PrevAndNext(
		Session session, RubricaNominativo rubricaNominativo,
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaNominativo> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

		query.append(_FINDER_COLUMN_UTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

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
			query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
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
						rubricaNominativo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaNominativo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	@Override
	public void removeByUtenteModifica(long FK_UTENTE_MODIFICA) {
		for (RubricaNominativo rubricaNominativo :
				findByUtenteModifica(
					FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaNominativo);
		}
	}

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica nominativos
	 */
	@Override
	public int countByUtenteModifica(long FK_UTENTE_MODIFICA) {
		FinderPath finderPath = _finderPathCountByUtenteModifica;

		Object[] finderArgs = new Object[] {FK_UTENTE_MODIFICA};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RUBRICANOMINATIVO_WHERE);

			query.append(_FINDER_COLUMN_UTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

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
		_FINDER_COLUMN_UTENTEMODIFICA_FK_UTENTE_MODIFICA_2 =
			"rubricaNominativo.FK_UTENTE_MODIFICA = ?";

	private FinderPath
		_finderPathWithPaginationFindByNominativoPerGruppoByNomeCognome;
	private FinderPath
		_finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome;
	private FinderPath _finderPathCountByNominativoPerGruppoByNomeCognome;

	/**
	 * Returns all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO) {

		return findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
		int end) {

		return findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
		int end, OrderByComparator<RubricaNominativo> orderByComparator) {

		return findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
		int end, OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		COGNOME = Objects.toString(COGNOME, "");
		NOME = Objects.toString(NOME, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome;
			finderArgs = new Object[] {COGNOME, NOME, FK_SITO_PROPRIETARIO};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByNominativoPerGruppoByNomeCognome;
			finderArgs = new Object[] {
				COGNOME, NOME, FK_SITO_PROPRIETARIO, start, end,
				orderByComparator
			};
		}

		List<RubricaNominativo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaNominativo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaNominativo rubricaNominativo : list) {
					if (!COGNOME.equals(rubricaNominativo.getCOGNOME()) ||
						!NOME.equals(rubricaNominativo.getNOME()) ||
						(FK_SITO_PROPRIETARIO !=
							rubricaNominativo.getFK_SITO_PROPRIETARIO())) {

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

			query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

			boolean bindCOGNOME = false;

			if (COGNOME.isEmpty()) {
				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_3);
			}
			else {
				bindCOGNOME = true;

				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_2);
			}

			boolean bindNOME = false;

			if (NOME.isEmpty()) {
				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_3);
			}
			else {
				bindNOME = true;

				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_2);
			}

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCOGNOME) {
					qPos.add(COGNOME);
				}

				if (bindNOME) {
					qPos.add(NOME);
				}

				qPos.add(FK_SITO_PROPRIETARIO);

				if (!pagination) {
					list = (List<RubricaNominativo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaNominativo>)QueryUtil.list(
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
	 * Returns the first rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByNominativoPerGruppoByNomeCognome_First(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo =
			fetchByNominativoPerGruppoByNomeCognome_First(
				COGNOME, NOME, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("COGNOME=");
		msg.append(COGNOME);

		msg.append(", NOME=");
		msg.append(NOME);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByNominativoPerGruppoByNomeCognome_First(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		List<RubricaNominativo> list = findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo findByNominativoPerGruppoByNomeCognome_Last(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo =
			fetchByNominativoPerGruppoByNomeCognome_Last(
				COGNOME, NOME, FK_SITO_PROPRIETARIO, orderByComparator);

		if (rubricaNominativo != null) {
			return rubricaNominativo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("COGNOME=");
		msg.append(COGNOME);

		msg.append(", NOME=");
		msg.append(NOME);

		msg.append(", FK_SITO_PROPRIETARIO=");
		msg.append(FK_SITO_PROPRIETARIO);

		msg.append("}");

		throw new NoSuchRubricaNominativoException(msg.toString());
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	@Override
	public RubricaNominativo fetchByNominativoPerGruppoByNomeCognome_Last(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		int count = countByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO);

		if (count == 0) {
			return null;
		}

		List<RubricaNominativo> list = findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo[]
			findByNominativoPerGruppoByNomeCognome_PrevAndNext(
				long ID_NOMINATIVO, String COGNOME, String NOME,
				long FK_SITO_PROPRIETARIO,
				OrderByComparator<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException {

		COGNOME = Objects.toString(COGNOME, "");
		NOME = Objects.toString(NOME, "");

		RubricaNominativo rubricaNominativo = findByPrimaryKey(ID_NOMINATIVO);

		Session session = null;

		try {
			session = openSession();

			RubricaNominativo[] array = new RubricaNominativoImpl[3];

			array[0] = getByNominativoPerGruppoByNomeCognome_PrevAndNext(
				session, rubricaNominativo, COGNOME, NOME, FK_SITO_PROPRIETARIO,
				orderByComparator, true);

			array[1] = rubricaNominativo;

			array[2] = getByNominativoPerGruppoByNomeCognome_PrevAndNext(
				session, rubricaNominativo, COGNOME, NOME, FK_SITO_PROPRIETARIO,
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

	protected RubricaNominativo
		getByNominativoPerGruppoByNomeCognome_PrevAndNext(
			Session session, RubricaNominativo rubricaNominativo,
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaNominativo> orderByComparator,
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

		query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE);

		boolean bindCOGNOME = false;

		if (COGNOME.isEmpty()) {
			query.append(
				_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_3);
		}
		else {
			bindCOGNOME = true;

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_2);
		}

		boolean bindNOME = false;

		if (NOME.isEmpty()) {
			query.append(
				_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_3);
		}
		else {
			bindNOME = true;

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_2);
		}

		query.append(
			_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_FK_SITO_PROPRIETARIO_2);

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
			query.append(RubricaNominativoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCOGNOME) {
			qPos.add(COGNOME);
		}

		if (bindNOME) {
			qPos.add(NOME);
		}

		qPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaNominativo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RubricaNominativo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	@Override
	public void removeByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO) {

		for (RubricaNominativo rubricaNominativo :
				findByNominativoPerGruppoByNomeCognome(
					COGNOME, NOME, FK_SITO_PROPRIETARIO, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(rubricaNominativo);
		}
	}

	/**
	 * Returns the number of rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica nominativos
	 */
	@Override
	public int countByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO) {

		COGNOME = Objects.toString(COGNOME, "");
		NOME = Objects.toString(NOME, "");

		FinderPath finderPath =
			_finderPathCountByNominativoPerGruppoByNomeCognome;

		Object[] finderArgs = new Object[] {
			COGNOME, NOME, FK_SITO_PROPRIETARIO
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RUBRICANOMINATIVO_WHERE);

			boolean bindCOGNOME = false;

			if (COGNOME.isEmpty()) {
				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_3);
			}
			else {
				bindCOGNOME = true;

				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_2);
			}

			boolean bindNOME = false;

			if (NOME.isEmpty()) {
				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_3);
			}
			else {
				bindNOME = true;

				query.append(
					_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_2);
			}

			query.append(
				_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCOGNOME) {
					qPos.add(COGNOME);
				}

				if (bindNOME) {
					qPos.add(NOME);
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
		_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_2 =
			"rubricaNominativo.COGNOME = ? AND ";

	private static final String
		_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_COGNOME_3 =
			"(rubricaNominativo.COGNOME IS NULL OR rubricaNominativo.COGNOME = '') AND ";

	private static final String
		_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_2 =
			"rubricaNominativo.NOME = ? AND ";

	private static final String
		_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_NOME_3 =
			"(rubricaNominativo.NOME IS NULL OR rubricaNominativo.NOME = '') AND ";

	private static final String
		_FINDER_COLUMN_NOMINATIVOPERGRUPPOBYNOMECOGNOME_FK_SITO_PROPRIETARIO_2 =
			"rubricaNominativo.FK_SITO_PROPRIETARIO = ?";

	public RubricaNominativoPersistenceImpl() {
		setModelClass(RubricaNominativo.class);
	}

	/**
	 * Caches the rubrica nominativo in the entity cache if it is enabled.
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 */
	@Override
	public void cacheResult(RubricaNominativo rubricaNominativo) {
		entityCache.putResult(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoImpl.class, rubricaNominativo.getPrimaryKey(),
			rubricaNominativo);

		finderCache.putResult(
			_finderPathFetchByNominativoPerSitoProprietario,
			new Object[] {
				rubricaNominativo.getID_NOMINATIVO(),
				rubricaNominativo.getFK_SITO_PROPRIETARIO()
			},
			rubricaNominativo);

		rubricaNominativo.resetOriginalValues();
	}

	/**
	 * Caches the rubrica nominativos in the entity cache if it is enabled.
	 *
	 * @param rubricaNominativos the rubrica nominativos
	 */
	@Override
	public void cacheResult(List<RubricaNominativo> rubricaNominativos) {
		for (RubricaNominativo rubricaNominativo : rubricaNominativos) {
			if (entityCache.getResult(
					RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaNominativoImpl.class,
					rubricaNominativo.getPrimaryKey()) == null) {

				cacheResult(rubricaNominativo);
			}
			else {
				rubricaNominativo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica nominativos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaNominativoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica nominativo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaNominativo rubricaNominativo) {
		entityCache.removeResult(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoImpl.class, rubricaNominativo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(RubricaNominativoModelImpl)rubricaNominativo, true);
	}

	@Override
	public void clearCache(List<RubricaNominativo> rubricaNominativos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaNominativo rubricaNominativo : rubricaNominativos) {
			entityCache.removeResult(
				RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaNominativoImpl.class, rubricaNominativo.getPrimaryKey());

			clearUniqueFindersCache(
				(RubricaNominativoModelImpl)rubricaNominativo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		RubricaNominativoModelImpl rubricaNominativoModelImpl) {

		Object[] args = new Object[] {
			rubricaNominativoModelImpl.getID_NOMINATIVO(),
			rubricaNominativoModelImpl.getFK_SITO_PROPRIETARIO()
		};

		finderCache.putResult(
			_finderPathCountByNominativoPerSitoProprietario, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByNominativoPerSitoProprietario, args,
			rubricaNominativoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		RubricaNominativoModelImpl rubricaNominativoModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				rubricaNominativoModelImpl.getID_NOMINATIVO(),
				rubricaNominativoModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByNominativoPerSitoProprietario, args);
			finderCache.removeResult(
				_finderPathFetchByNominativoPerSitoProprietario, args);
		}

		if ((rubricaNominativoModelImpl.getColumnBitmask() &
			 _finderPathFetchByNominativoPerSitoProprietario.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				rubricaNominativoModelImpl.getOriginalID_NOMINATIVO(),
				rubricaNominativoModelImpl.getOriginalFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByNominativoPerSitoProprietario, args);
			finderCache.removeResult(
				_finderPathFetchByNominativoPerSitoProprietario, args);
		}
	}

	/**
	 * Creates a new rubrica nominativo with the primary key. Does not add the rubrica nominativo to the database.
	 *
	 * @param ID_NOMINATIVO the primary key for the new rubrica nominativo
	 * @return the new rubrica nominativo
	 */
	@Override
	public RubricaNominativo create(long ID_NOMINATIVO) {
		RubricaNominativo rubricaNominativo = new RubricaNominativoImpl();

		rubricaNominativo.setNew(true);
		rubricaNominativo.setPrimaryKey(ID_NOMINATIVO);

		return rubricaNominativo;
	}

	/**
	 * Removes the rubrica nominativo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo remove(long ID_NOMINATIVO)
		throws NoSuchRubricaNominativoException {

		return remove((Serializable)ID_NOMINATIVO);
	}

	/**
	 * Removes the rubrica nominativo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo remove(Serializable primaryKey)
		throws NoSuchRubricaNominativoException {

		Session session = null;

		try {
			session = openSession();

			RubricaNominativo rubricaNominativo =
				(RubricaNominativo)session.get(
					RubricaNominativoImpl.class, primaryKey);

			if (rubricaNominativo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaNominativoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaNominativo);
		}
		catch (NoSuchRubricaNominativoException nsee) {
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
	protected RubricaNominativo removeImpl(
		RubricaNominativo rubricaNominativo) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaNominativo)) {
				rubricaNominativo = (RubricaNominativo)session.get(
					RubricaNominativoImpl.class,
					rubricaNominativo.getPrimaryKeyObj());
			}

			if (rubricaNominativo != null) {
				session.delete(rubricaNominativo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaNominativo != null) {
			clearCache(rubricaNominativo);
		}

		return rubricaNominativo;
	}

	@Override
	public RubricaNominativo updateImpl(RubricaNominativo rubricaNominativo) {
		boolean isNew = rubricaNominativo.isNew();

		if (!(rubricaNominativo instanceof RubricaNominativoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaNominativo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaNominativo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaNominativo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaNominativo implementation " +
					rubricaNominativo.getClass());
		}

		RubricaNominativoModelImpl rubricaNominativoModelImpl =
			(RubricaNominativoModelImpl)rubricaNominativo;

		Session session = null;

		try {
			session = openSession();

			if (rubricaNominativo.isNew()) {
				session.save(rubricaNominativo);

				rubricaNominativo.setNew(false);
			}
			else {
				rubricaNominativo = (RubricaNominativo)session.merge(
					rubricaNominativo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaNominativoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				rubricaNominativoModelImpl.getFK_UTENTE_PORTALE()
			};

			finderCache.removeResult(_finderPathCountByUtentePortale, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUtentePortale, args);

			args = new Object[] {
				rubricaNominativoModelImpl.getFK_UTENTE_CREAZIONE()
			};

			finderCache.removeResult(_finderPathCountByUtenteCreazione, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUtenteCreazione, args);

			args = new Object[] {
				rubricaNominativoModelImpl.getFK_UTENTE_MODIFICA()
			};

			finderCache.removeResult(_finderPathCountByUtenteModifica, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUtenteModifica, args);

			args = new Object[] {
				rubricaNominativoModelImpl.getCOGNOME(),
				rubricaNominativoModelImpl.getNOME(),
				rubricaNominativoModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByNominativoPerGruppoByNomeCognome, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((rubricaNominativoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUtentePortale.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaNominativoModelImpl.getOriginalFK_UTENTE_PORTALE()
				};

				finderCache.removeResult(_finderPathCountByUtentePortale, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtentePortale, args);

				args = new Object[] {
					rubricaNominativoModelImpl.getFK_UTENTE_PORTALE()
				};

				finderCache.removeResult(_finderPathCountByUtentePortale, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtentePortale, args);
			}

			if ((rubricaNominativoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUtenteCreazione.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaNominativoModelImpl.getOriginalFK_UTENTE_CREAZIONE()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteCreazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteCreazione, args);

				args = new Object[] {
					rubricaNominativoModelImpl.getFK_UTENTE_CREAZIONE()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteCreazione, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteCreazione, args);
			}

			if ((rubricaNominativoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUtenteModifica.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaNominativoModelImpl.getOriginalFK_UTENTE_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteModifica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteModifica, args);

				args = new Object[] {
					rubricaNominativoModelImpl.getFK_UTENTE_MODIFICA()
				};

				finderCache.removeResult(
					_finderPathCountByUtenteModifica, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUtenteModifica, args);
			}

			if ((rubricaNominativoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					rubricaNominativoModelImpl.getOriginalCOGNOME(),
					rubricaNominativoModelImpl.getOriginalNOME(),
					rubricaNominativoModelImpl.getOriginalFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByNominativoPerGruppoByNomeCognome, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome,
					args);

				args = new Object[] {
					rubricaNominativoModelImpl.getCOGNOME(),
					rubricaNominativoModelImpl.getNOME(),
					rubricaNominativoModelImpl.getFK_SITO_PROPRIETARIO()
				};

				finderCache.removeResult(
					_finderPathCountByNominativoPerGruppoByNomeCognome, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome,
					args);
			}
		}

		entityCache.putResult(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoImpl.class, rubricaNominativo.getPrimaryKey(),
			rubricaNominativo, false);

		clearUniqueFindersCache(rubricaNominativoModelImpl, false);
		cacheUniqueFindersCache(rubricaNominativoModelImpl);

		rubricaNominativo.resetOriginalValues();

		return rubricaNominativo;
	}

	/**
	 * Returns the rubrica nominativo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica nominativo
	 * @return the rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaNominativoException {

		RubricaNominativo rubricaNominativo = fetchByPrimaryKey(primaryKey);

		if (rubricaNominativo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaNominativoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaNominativo;
	}

	/**
	 * Returns the rubrica nominativo with the primary key or throws a <code>NoSuchRubricaNominativoException</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo findByPrimaryKey(long ID_NOMINATIVO)
		throws NoSuchRubricaNominativoException {

		return findByPrimaryKey((Serializable)ID_NOMINATIVO);
	}

	/**
	 * Returns the rubrica nominativo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica nominativo
	 * @return the rubrica nominativo, or <code>null</code> if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaNominativo rubricaNominativo = (RubricaNominativo)serializable;

		if (rubricaNominativo == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaNominativo = (RubricaNominativo)session.get(
					RubricaNominativoImpl.class, primaryKey);

				if (rubricaNominativo != null) {
					cacheResult(rubricaNominativo);
				}
				else {
					entityCache.putResult(
						RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
						RubricaNominativoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaNominativoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaNominativo;
	}

	/**
	 * Returns the rubrica nominativo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo, or <code>null</code> if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public RubricaNominativo fetchByPrimaryKey(long ID_NOMINATIVO) {
		return fetchByPrimaryKey((Serializable)ID_NOMINATIVO);
	}

	@Override
	public Map<Serializable, RubricaNominativo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaNominativo> map =
			new HashMap<Serializable, RubricaNominativo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaNominativo rubricaNominativo = fetchByPrimaryKey(primaryKey);

			if (rubricaNominativo != null) {
				map.put(primaryKey, rubricaNominativo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaNominativoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaNominativo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICANOMINATIVO_WHERE_PKS_IN);

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

			for (RubricaNominativo rubricaNominativo :
					(List<RubricaNominativo>)q.list()) {

				map.put(
					rubricaNominativo.getPrimaryKeyObj(), rubricaNominativo);

				cacheResult(rubricaNominativo);

				uncachedPrimaryKeys.remove(
					rubricaNominativo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaNominativoImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica nominativos.
	 *
	 * @return the rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findAll(
		int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica nominativos
	 */
	@Override
	public List<RubricaNominativo> findAll(
		int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
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

		List<RubricaNominativo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaNominativo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICANOMINATIVO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICANOMINATIVO;

				if (pagination) {
					sql = sql.concat(RubricaNominativoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaNominativo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaNominativo>)QueryUtil.list(
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
	 * Removes all the rubrica nominativos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaNominativo rubricaNominativo : findAll()) {
			remove(rubricaNominativo);
		}
	}

	/**
	 * Returns the number of rubrica nominativos.
	 *
	 * @return the number of rubrica nominativos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICANOMINATIVO);

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
		return RubricaNominativoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica nominativo persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByNominativoPerSitoProprietario = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNominativoPerSitoProprietario",
			new String[] {Long.class.getName(), Long.class.getName()},
			RubricaNominativoModelImpl.ID_NOMINATIVO_COLUMN_BITMASK |
			RubricaNominativoModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByNominativoPerSitoProprietario = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNominativoPerSitoProprietario",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUtentePortale = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtentePortale",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUtentePortale = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtentePortale",
			new String[] {Long.class.getName()},
			RubricaNominativoModelImpl.FK_UTENTE_PORTALE_COLUMN_BITMASK);

		_finderPathCountByUtentePortale = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtentePortale",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUtenteCreazione = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtenteCreazione",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUtenteCreazione = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtenteCreazione",
			new String[] {Long.class.getName()},
			RubricaNominativoModelImpl.FK_UTENTE_CREAZIONE_COLUMN_BITMASK);

		_finderPathCountByUtenteCreazione = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtenteCreazione",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUtenteModifica = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtenteModifica",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUtenteModifica = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
			RubricaNominativoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtenteModifica",
			new String[] {Long.class.getName()},
			RubricaNominativoModelImpl.FK_UTENTE_MODIFICA_COLUMN_BITMASK);

		_finderPathCountByUtenteModifica = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtenteModifica",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByNominativoPerGruppoByNomeCognome =
			new FinderPath(
				RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
				RubricaNominativoImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByNominativoPerGruppoByNomeCognome",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByNominativoPerGruppoByNomeCognome =
			new FinderPath(
				RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaNominativoModelImpl.FINDER_CACHE_ENABLED,
				RubricaNominativoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByNominativoPerGruppoByNomeCognome",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				RubricaNominativoModelImpl.COGNOME_COLUMN_BITMASK |
				RubricaNominativoModelImpl.NOME_COLUMN_BITMASK |
				RubricaNominativoModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByNominativoPerGruppoByNomeCognome = new FinderPath(
			RubricaNominativoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaNominativoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNominativoPerGruppoByNomeCognome",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	}

	public void destroy() {
		entityCache.removeCache(RubricaNominativoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICANOMINATIVO =
		"SELECT rubricaNominativo FROM RubricaNominativo rubricaNominativo";

	private static final String _SQL_SELECT_RUBRICANOMINATIVO_WHERE_PKS_IN =
		"SELECT rubricaNominativo FROM RubricaNominativo rubricaNominativo WHERE ID_NOMINATIVO IN (";

	private static final String _SQL_SELECT_RUBRICANOMINATIVO_WHERE =
		"SELECT rubricaNominativo FROM RubricaNominativo rubricaNominativo WHERE ";

	private static final String _SQL_COUNT_RUBRICANOMINATIVO =
		"SELECT COUNT(rubricaNominativo) FROM RubricaNominativo rubricaNominativo";

	private static final String _SQL_COUNT_RUBRICANOMINATIVO_WHERE =
		"SELECT COUNT(rubricaNominativo) FROM RubricaNominativo rubricaNominativo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaNominativo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaNominativo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaNominativo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaNominativoPersistenceImpl.class);

}