/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.allerte.exception.NoSuchRubricaLogException;
import it.eng.allerte.model.RubricaLog;
import it.eng.allerte.model.RubricaLogTable;
import it.eng.allerte.model.impl.RubricaLogImpl;
import it.eng.allerte.model.impl.RubricaLogModelImpl;
import it.eng.allerte.service.persistence.RubricaLogPersistence;
import it.eng.allerte.service.persistence.RubricaLogUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

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
@Component(service = RubricaLogPersistence.class)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaLogUtenteModifica;
				finderArgs = new Object[] {FK_UTENTE_MODIFICA};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRubricaLogUtenteModifica;
			finderArgs = new Object[] {
				FK_UTENTE_MODIFICA, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (useFinderCache) {
			list = (List<RubricaLog>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if (FK_UTENTE_MODIFICA !=
							rubricaLog.getFK_UTENTE_MODIFICA()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_UTENTE_MODIFICA);

				list = (List<RubricaLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaLog getByRubricaLogUtenteModifica_PrevAndNext(
		Session session, RubricaLog rubricaLog, long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

		sb.append(_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_UTENTE_MODIFICA);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = query.list();

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

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICALOG_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICALOGUTENTEMODIFICA_FK_UTENTE_MODIFICA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_UTENTE_MODIFICA);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaLogDataModifica;
				finderArgs = new Object[] {
					_getTime(DATA_MODIFICA), FK_SITO_PROPRIETARIO
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRubricaLogDataModifica;
			finderArgs = new Object[] {
				_getTime(DATA_MODIFICA), FK_SITO_PROPRIETARIO, start, end,
				orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (useFinderCache) {
			list = (List<RubricaLog>)dummyFinderCache.getResult(
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
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				sb.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				sb.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2);
			}

			sb.append(
				_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDATA_MODIFICA) {
					queryPos.add(new Timestamp(DATA_MODIFICA.getTime()));
				}

				queryPos.add(FK_SITO_PROPRIETARIO);

				list = (List<RubricaLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);

		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);

		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaLog getByRubricaLogDataModifica_PrevAndNext(
		Session session, RubricaLog rubricaLog, Date DATA_MODIFICA,
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

		boolean bindDATA_MODIFICA = false;

		if (DATA_MODIFICA == null) {
			sb.append(_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1);
		}
		else {
			bindDATA_MODIFICA = true;

			sb.append(_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2);
		}

		sb.append(_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDATA_MODIFICA) {
			queryPos.add(new Timestamp(DATA_MODIFICA.getTime()));
		}

		queryPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = query.list();

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

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RUBRICALOG_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				sb.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				sb.append(
					_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_DATA_MODIFICA_2);
			}

			sb.append(
				_FINDER_COLUMN_RUBRICALOGDATAMODIFICA_FK_SITO_PROPRIETARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDATA_MODIFICA) {
					queryPos.add(new Timestamp(DATA_MODIFICA.getTime()));
				}

				queryPos.add(FK_SITO_PROPRIETARIO);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean useFinderCache) {

		TABELLA = Objects.toString(TABELLA, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaLogTabella;
				finderArgs = new Object[] {TABELLA, FK_SITO_PROPRIETARIO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRubricaLogTabella;
			finderArgs = new Object[] {
				TABELLA, FK_SITO_PROPRIETARIO, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (useFinderCache) {
			list = (List<RubricaLog>)dummyFinderCache.getResult(
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
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

			boolean bindTABELLA = false;

			if (TABELLA.isEmpty()) {
				sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3);
			}
			else {
				bindTABELLA = true;

				sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2);
			}

			sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTABELLA) {
					queryPos.add(TABELLA);
				}

				queryPos.add(FK_SITO_PROPRIETARIO);

				list = (List<RubricaLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("TABELLA=");
		sb.append(TABELLA);

		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("TABELLA=");
		sb.append(TABELLA);

		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaLog getByRubricaLogTabella_PrevAndNext(
		Session session, RubricaLog rubricaLog, String TABELLA,
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

		boolean bindTABELLA = false;

		if (TABELLA.isEmpty()) {
			sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3);
		}
		else {
			bindTABELLA = true;

			sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2);
		}

		sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTABELLA) {
			queryPos.add(TABELLA);
		}

		queryPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = query.list();

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

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RUBRICALOG_WHERE);

			boolean bindTABELLA = false;

			if (TABELLA.isEmpty()) {
				sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_3);
			}
			else {
				bindTABELLA = true;

				sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_TABELLA_2);
			}

			sb.append(_FINDER_COLUMN_RUBRICALOGTABELLA_FK_SITO_PROPRIETARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTABELLA) {
					queryPos.add(TABELLA);
				}

				queryPos.add(FK_SITO_PROPRIETARIO);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean useFinderCache) {

		ID_OGGETTO = Objects.toString(ID_OGGETTO, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaLogIdOggetto;
				finderArgs = new Object[] {ID_OGGETTO, FK_SITO_PROPRIETARIO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRubricaLogIdOggetto;
			finderArgs = new Object[] {
				ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (useFinderCache) {
			list = (List<RubricaLog>)dummyFinderCache.getResult(
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
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

			boolean bindID_OGGETTO = false;

			if (ID_OGGETTO.isEmpty()) {
				sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3);
			}
			else {
				bindID_OGGETTO = true;

				sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2);
			}

			sb.append(
				_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindID_OGGETTO) {
					queryPos.add(ID_OGGETTO);
				}

				queryPos.add(FK_SITO_PROPRIETARIO);

				list = (List<RubricaLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ID_OGGETTO=");
		sb.append(ID_OGGETTO);

		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ID_OGGETTO=");
		sb.append(ID_OGGETTO);

		sb.append(", FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaLog getByRubricaLogIdOggetto_PrevAndNext(
		Session session, RubricaLog rubricaLog, String ID_OGGETTO,
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

		boolean bindID_OGGETTO = false;

		if (ID_OGGETTO.isEmpty()) {
			sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3);
		}
		else {
			bindID_OGGETTO = true;

			sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2);
		}

		sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindID_OGGETTO) {
			queryPos.add(ID_OGGETTO);
		}

		queryPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = query.list();

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

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RUBRICALOG_WHERE);

			boolean bindID_OGGETTO = false;

			if (ID_OGGETTO.isEmpty()) {
				sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_3);
			}
			else {
				bindID_OGGETTO = true;

				sb.append(_FINDER_COLUMN_RUBRICALOGIDOGGETTO_ID_OGGETTO_2);
			}

			sb.append(
				_FINDER_COLUMN_RUBRICALOGIDOGGETTO_FK_SITO_PROPRIETARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindID_OGGETTO) {
					queryPos.add(ID_OGGETTO);
				}

				queryPos.add(FK_SITO_PROPRIETARIO);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	@Override
	public List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario;
				finderArgs = new Object[] {FK_SITO_PROPRIETARIO};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRubricaLogBySitoProprietario;
			finderArgs = new Object[] {
				FK_SITO_PROPRIETARIO, start, end, orderByComparator
			};
		}

		List<RubricaLog> list = null;

		if (useFinderCache) {
			list = (List<RubricaLog>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaLog rubricaLog : list) {
					if (FK_SITO_PROPRIETARIO !=
							rubricaLog.getFK_SITO_PROPRIETARIO()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_SITO_PROPRIETARIO);

				list = (List<RubricaLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_SITO_PROPRIETARIO=");
		sb.append(FK_SITO_PROPRIETARIO);

		sb.append("}");

		throw new NoSuchRubricaLogException(sb.toString());
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaLog getByRubricaLogBySitoProprietario_PrevAndNext(
		Session session, RubricaLog rubricaLog, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RUBRICALOG_WHERE);

		sb.append(
			_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RubricaLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_SITO_PROPRIETARIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rubricaLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaLog> list = query.list();

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

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICALOG_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICALOGBYSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_SITO_PROPRIETARIO);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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

		setModelImplClass(RubricaLogImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaLogTable.INSTANCE);
	}

	/**
	 * Caches the rubrica log in the entity cache if it is enabled.
	 *
	 * @param rubricaLog the rubrica log
	 */
	@Override
	public void cacheResult(RubricaLog rubricaLog) {
		dummyEntityCache.putResult(
			RubricaLogImpl.class, rubricaLog.getPrimaryKey(), rubricaLog);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica logs in the entity cache if it is enabled.
	 *
	 * @param rubricaLogs the rubrica logs
	 */
	@Override
	public void cacheResult(List<RubricaLog> rubricaLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaLog rubricaLog : rubricaLogs) {
			if (dummyEntityCache.getResult(
					RubricaLogImpl.class, rubricaLog.getPrimaryKey()) == null) {

				cacheResult(rubricaLog);
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
		dummyEntityCache.clearCache(RubricaLogImpl.class);

		dummyFinderCache.clearCache(RubricaLogImpl.class);
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
		dummyEntityCache.removeResult(RubricaLogImpl.class, rubricaLog);
	}

	@Override
	public void clearCache(List<RubricaLog> rubricaLogs) {
		for (RubricaLog rubricaLog : rubricaLogs) {
			dummyEntityCache.removeResult(RubricaLogImpl.class, rubricaLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaLogImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(RubricaLogImpl.class, primaryKey);
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
		catch (NoSuchRubricaLogException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(rubricaLog);
			}
			else {
				rubricaLog = (RubricaLog)session.merge(rubricaLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaLogImpl.class, rubricaLogModelImpl, false, true);

		if (isNew) {
			rubricaLog.setNew(false);
		}

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
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log, or <code>null</code> if a rubrica log with the primary key could not be found
	 */
	@Override
	public RubricaLog fetchByPrimaryKey(long ID_LOG) {
		return fetchByPrimaryKey((Serializable)ID_LOG);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica logs
	 */
	@Override
	public List<RubricaLog> findAll(
		int start, int end, OrderByComparator<RubricaLog> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RubricaLog> list = null;

		if (useFinderCache) {
			list = (List<RubricaLog>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICALOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICALOG;

				sql = sql.concat(RubricaLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
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
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICALOG);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID_LOG";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICALOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica log persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByRubricaLogUtenteModifica =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaLogUtenteModifica",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"FK_UTENTE_MODIFICA"}, true);

		_finderPathWithoutPaginationFindByRubricaLogUtenteModifica =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaLogUtenteModifica",
				new String[] {Long.class.getName()},
				new String[] {"FK_UTENTE_MODIFICA"}, true);

		_finderPathCountByRubricaLogUtenteModifica = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogUtenteModifica",
			new String[] {Long.class.getName()},
			new String[] {"FK_UTENTE_MODIFICA"}, false);

		_finderPathWithPaginationFindByRubricaLogDataModifica = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRubricaLogDataModifica",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"DATA_MODIFICA", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathWithoutPaginationFindByRubricaLogDataModifica =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaLogDataModifica",
				new String[] {Date.class.getName(), Long.class.getName()},
				new String[] {"DATA_MODIFICA", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathCountByRubricaLogDataModifica = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogDataModifica",
			new String[] {Date.class.getName(), Long.class.getName()},
			new String[] {"DATA_MODIFICA", "FK_SITO_PROPRIETARIO"}, false);

		_finderPathWithPaginationFindByRubricaLogTabella = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRubricaLogTabella",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"TABELLA", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathWithoutPaginationFindByRubricaLogTabella = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRubricaLogTabella",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"TABELLA", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathCountByRubricaLogTabella = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogTabella",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"TABELLA", "FK_SITO_PROPRIETARIO"}, false);

		_finderPathWithPaginationFindByRubricaLogIdOggetto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRubricaLogIdOggetto",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"ID_OGGETTO", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathWithoutPaginationFindByRubricaLogIdOggetto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRubricaLogIdOggetto",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"ID_OGGETTO", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathCountByRubricaLogIdOggetto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogIdOggetto",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"ID_OGGETTO", "FK_SITO_PROPRIETARIO"}, false);

		_finderPathWithPaginationFindByRubricaLogBySitoProprietario =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaLogBySitoProprietario",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"FK_SITO_PROPRIETARIO"}, true);

		_finderPathWithoutPaginationFindByRubricaLogBySitoProprietario =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaLogBySitoProprietario",
				new String[] {Long.class.getName()},
				new String[] {"FK_SITO_PROPRIETARIO"}, true);

		_finderPathCountByRubricaLogBySitoProprietario = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaLogBySitoProprietario",
			new String[] {Long.class.getName()},
			new String[] {"FK_SITO_PROPRIETARIO"}, false);

		RubricaLogUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaLogUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaLogImpl.class.getName());
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_RUBRICALOG =
		"SELECT rubricaLog FROM RubricaLog rubricaLog";

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

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}