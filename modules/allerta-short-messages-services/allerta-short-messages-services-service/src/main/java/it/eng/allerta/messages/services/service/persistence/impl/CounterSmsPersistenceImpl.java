/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.allerta.messages.services.exception.NoSuchCounterSmsException;
import it.eng.allerta.messages.services.model.CounterSms;
import it.eng.allerta.messages.services.model.CounterSmsTable;
import it.eng.allerta.messages.services.model.impl.CounterSmsImpl;
import it.eng.allerta.messages.services.model.impl.CounterSmsModelImpl;
import it.eng.allerta.messages.services.service.persistence.CounterSmsPersistence;
import it.eng.allerta.messages.services.service.persistence.CounterSmsUtil;
import it.eng.allerta.messages.services.service.persistence.impl.constants.smsServicePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the counter sms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@Component(service = CounterSmsPersistence.class)
public class CounterSmsPersistenceImpl
	extends BasePersistenceImpl<CounterSms> implements CounterSmsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CounterSmsUtil</code> to access the counter sms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CounterSmsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydata;

	/**
	 * Returns the counter sms where date = &#63; or throws a <code>NoSuchCounterSmsException</code> if it could not be found.
	 *
	 * @param date the date
	 * @return the matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	@Override
	public CounterSms findBydata(Date date) throws NoSuchCounterSmsException {
		CounterSms counterSms = fetchBydata(date);

		if (counterSms == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("date=");
			sb.append(date);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCounterSmsException(sb.toString());
		}

		return counterSms;
	}

	/**
	 * Returns the counter sms where date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param date the date
	 * @return the matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	@Override
	public CounterSms fetchBydata(Date date) {
		return fetchBydata(date, true);
	}

	/**
	 * Returns the counter sms where date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param date the date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	@Override
	public CounterSms fetchBydata(Date date, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {_getTime(date)};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydata, finderArgs, this);
		}

		if (result instanceof CounterSms) {
			CounterSms counterSms = (CounterSms)result;

			if (!Objects.equals(date, counterSms.getDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COUNTERSMS_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATA_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATA_DATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				List<CounterSms> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydata, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {_getTime(date)};
							}

							_log.warn(
								"CounterSmsPersistenceImpl.fetchBydata(Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CounterSms counterSms = list.get(0);

					result = counterSms;

					cacheResult(counterSms);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CounterSms)result;
		}
	}

	/**
	 * Removes the counter sms where date = &#63; from the database.
	 *
	 * @param date the date
	 * @return the counter sms that was removed
	 */
	@Override
	public CounterSms removeBydata(Date date) throws NoSuchCounterSmsException {
		CounterSms counterSms = findBydata(date);

		return remove(counterSms);
	}

	/**
	 * Returns the number of counter smses where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching counter smses
	 */
	@Override
	public int countBydata(Date date) {
		CounterSms counterSms = fetchBydata(date);

		if (counterSms == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_DATA_DATE_1 =
		"counterSms.date IS NULL";

	private static final String _FINDER_COLUMN_DATA_DATE_2 =
		"counterSms.date = ?";

	private FinderPath _finderPathWithPaginationFindBydataGreather;
	private FinderPath _finderPathWithPaginationCountBydataGreather;

	/**
	 * Returns all the counter smses where date &gt; &#63;.
	 *
	 * @param date the date
	 * @return the matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataGreather(Date date) {
		return findBydataGreather(
			date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the counter smses where date &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataGreather(Date date, int start, int end) {
		return findBydataGreather(date, start, end, null);
	}

	/**
	 * Returns an ordered range of all the counter smses where date &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataGreather(
		Date date, int start, int end,
		OrderByComparator<CounterSms> orderByComparator) {

		return findBydataGreather(date, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the counter smses where date &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataGreather(
		Date date, int start, int end,
		OrderByComparator<CounterSms> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBydataGreather;
		finderArgs = new Object[] {
			_getTime(date), start, end, orderByComparator
		};

		List<CounterSms> list = null;

		if (useFinderCache) {
			list = (List<CounterSms>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CounterSms counterSms : list) {
					if (date.getTime() >= counterSms.getDate(
						).getTime()) {

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

			sb.append(_SQL_SELECT_COUNTERSMS_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATAGREATHER_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATAGREATHER_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CounterSmsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				list = (List<CounterSms>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	@Override
	public CounterSms findBydataGreather_First(
			Date date, OrderByComparator<CounterSms> orderByComparator)
		throws NoSuchCounterSmsException {

		CounterSms counterSms = fetchBydataGreather_First(
			date, orderByComparator);

		if (counterSms != null) {
			return counterSms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date>");
		sb.append(date);

		sb.append("}");

		throw new NoSuchCounterSmsException(sb.toString());
	}

	/**
	 * Returns the first counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	@Override
	public CounterSms fetchBydataGreather_First(
		Date date, OrderByComparator<CounterSms> orderByComparator) {

		List<CounterSms> list = findBydataGreather(
			date, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	@Override
	public CounterSms findBydataGreather_Last(
			Date date, OrderByComparator<CounterSms> orderByComparator)
		throws NoSuchCounterSmsException {

		CounterSms counterSms = fetchBydataGreather_Last(
			date, orderByComparator);

		if (counterSms != null) {
			return counterSms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date>");
		sb.append(date);

		sb.append("}");

		throw new NoSuchCounterSmsException(sb.toString());
	}

	/**
	 * Returns the last counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	@Override
	public CounterSms fetchBydataGreather_Last(
		Date date, OrderByComparator<CounterSms> orderByComparator) {

		int count = countBydataGreather(date);

		if (count == 0) {
			return null;
		}

		List<CounterSms> list = findBydataGreather(
			date, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the counter smses before and after the current counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param counterId the primary key of the current counter sms
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms[] findBydataGreather_PrevAndNext(
			long counterId, Date date,
			OrderByComparator<CounterSms> orderByComparator)
		throws NoSuchCounterSmsException {

		CounterSms counterSms = findByPrimaryKey(counterId);

		Session session = null;

		try {
			session = openSession();

			CounterSms[] array = new CounterSmsImpl[3];

			array[0] = getBydataGreather_PrevAndNext(
				session, counterSms, date, orderByComparator, true);

			array[1] = counterSms;

			array[2] = getBydataGreather_PrevAndNext(
				session, counterSms, date, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CounterSms getBydataGreather_PrevAndNext(
		Session session, CounterSms counterSms, Date date,
		OrderByComparator<CounterSms> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COUNTERSMS_WHERE);

		boolean bindDate = false;

		if (date == null) {
			sb.append(_FINDER_COLUMN_DATAGREATHER_DATE_1);
		}
		else {
			bindDate = true;

			sb.append(_FINDER_COLUMN_DATAGREATHER_DATE_2);
		}

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
			sb.append(CounterSmsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDate) {
			queryPos.add(new Timestamp(date.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(counterSms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CounterSms> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the counter smses where date &gt; &#63; from the database.
	 *
	 * @param date the date
	 */
	@Override
	public void removeBydataGreather(Date date) {
		for (CounterSms counterSms :
				findBydataGreather(
					date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(counterSms);
		}
	}

	/**
	 * Returns the number of counter smses where date &gt; &#63;.
	 *
	 * @param date the date
	 * @return the number of matching counter smses
	 */
	@Override
	public int countBydataGreather(Date date) {
		FinderPath finderPath = _finderPathWithPaginationCountBydataGreather;

		Object[] finderArgs = new Object[] {_getTime(date)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COUNTERSMS_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATAGREATHER_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATAGREATHER_DATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_DATAGREATHER_DATE_1 =
		"counterSms.date IS NULL";

	private static final String _FINDER_COLUMN_DATAGREATHER_DATE_2 =
		"counterSms.date > ?";

	private FinderPath _finderPathWithPaginationFindBydataAndNodo;
	private FinderPath _finderPathWithoutPaginationFindBydataAndNodo;
	private FinderPath _finderPathCountBydataAndNodo;

	/**
	 * Returns all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @return the matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataAndNodo(Date date, String nodo) {
		return findBydataAndNodo(
			date, nodo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end) {

		return findBydataAndNodo(date, nodo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end,
		OrderByComparator<CounterSms> orderByComparator) {

		return findBydataAndNodo(
			date, nodo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching counter smses
	 */
	@Override
	public List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end,
		OrderByComparator<CounterSms> orderByComparator,
		boolean useFinderCache) {

		nodo = Objects.toString(nodo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydataAndNodo;
				finderArgs = new Object[] {_getTime(date), nodo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydataAndNodo;
			finderArgs = new Object[] {
				_getTime(date), nodo, start, end, orderByComparator
			};
		}

		List<CounterSms> list = null;

		if (useFinderCache) {
			list = (List<CounterSms>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CounterSms counterSms : list) {
					if (!Objects.equals(date, counterSms.getDate()) ||
						!nodo.equals(counterSms.getNodo())) {

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

			sb.append(_SQL_SELECT_COUNTERSMS_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATAANDNODO_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATAANDNODO_DATE_2);
			}

			boolean bindNodo = false;

			if (nodo.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATAANDNODO_NODO_3);
			}
			else {
				bindNodo = true;

				sb.append(_FINDER_COLUMN_DATAANDNODO_NODO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CounterSmsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				if (bindNodo) {
					queryPos.add(nodo);
				}

				list = (List<CounterSms>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	@Override
	public CounterSms findBydataAndNodo_First(
			Date date, String nodo,
			OrderByComparator<CounterSms> orderByComparator)
		throws NoSuchCounterSmsException {

		CounterSms counterSms = fetchBydataAndNodo_First(
			date, nodo, orderByComparator);

		if (counterSms != null) {
			return counterSms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date=");
		sb.append(date);

		sb.append(", nodo=");
		sb.append(nodo);

		sb.append("}");

		throw new NoSuchCounterSmsException(sb.toString());
	}

	/**
	 * Returns the first counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	@Override
	public CounterSms fetchBydataAndNodo_First(
		Date date, String nodo,
		OrderByComparator<CounterSms> orderByComparator) {

		List<CounterSms> list = findBydataAndNodo(
			date, nodo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	@Override
	public CounterSms findBydataAndNodo_Last(
			Date date, String nodo,
			OrderByComparator<CounterSms> orderByComparator)
		throws NoSuchCounterSmsException {

		CounterSms counterSms = fetchBydataAndNodo_Last(
			date, nodo, orderByComparator);

		if (counterSms != null) {
			return counterSms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date=");
		sb.append(date);

		sb.append(", nodo=");
		sb.append(nodo);

		sb.append("}");

		throw new NoSuchCounterSmsException(sb.toString());
	}

	/**
	 * Returns the last counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	@Override
	public CounterSms fetchBydataAndNodo_Last(
		Date date, String nodo,
		OrderByComparator<CounterSms> orderByComparator) {

		int count = countBydataAndNodo(date, nodo);

		if (count == 0) {
			return null;
		}

		List<CounterSms> list = findBydataAndNodo(
			date, nodo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the counter smses before and after the current counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param counterId the primary key of the current counter sms
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms[] findBydataAndNodo_PrevAndNext(
			long counterId, Date date, String nodo,
			OrderByComparator<CounterSms> orderByComparator)
		throws NoSuchCounterSmsException {

		nodo = Objects.toString(nodo, "");

		CounterSms counterSms = findByPrimaryKey(counterId);

		Session session = null;

		try {
			session = openSession();

			CounterSms[] array = new CounterSmsImpl[3];

			array[0] = getBydataAndNodo_PrevAndNext(
				session, counterSms, date, nodo, orderByComparator, true);

			array[1] = counterSms;

			array[2] = getBydataAndNodo_PrevAndNext(
				session, counterSms, date, nodo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CounterSms getBydataAndNodo_PrevAndNext(
		Session session, CounterSms counterSms, Date date, String nodo,
		OrderByComparator<CounterSms> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COUNTERSMS_WHERE);

		boolean bindDate = false;

		if (date == null) {
			sb.append(_FINDER_COLUMN_DATAANDNODO_DATE_1);
		}
		else {
			bindDate = true;

			sb.append(_FINDER_COLUMN_DATAANDNODO_DATE_2);
		}

		boolean bindNodo = false;

		if (nodo.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATAANDNODO_NODO_3);
		}
		else {
			bindNodo = true;

			sb.append(_FINDER_COLUMN_DATAANDNODO_NODO_2);
		}

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
			sb.append(CounterSmsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDate) {
			queryPos.add(new Timestamp(date.getTime()));
		}

		if (bindNodo) {
			queryPos.add(nodo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(counterSms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CounterSms> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the counter smses where date = &#63; and nodo = &#63; from the database.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 */
	@Override
	public void removeBydataAndNodo(Date date, String nodo) {
		for (CounterSms counterSms :
				findBydataAndNodo(
					date, nodo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(counterSms);
		}
	}

	/**
	 * Returns the number of counter smses where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @return the number of matching counter smses
	 */
	@Override
	public int countBydataAndNodo(Date date, String nodo) {
		nodo = Objects.toString(nodo, "");

		FinderPath finderPath = _finderPathCountBydataAndNodo;

		Object[] finderArgs = new Object[] {_getTime(date), nodo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COUNTERSMS_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATAANDNODO_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATAANDNODO_DATE_2);
			}

			boolean bindNodo = false;

			if (nodo.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATAANDNODO_NODO_3);
			}
			else {
				bindNodo = true;

				sb.append(_FINDER_COLUMN_DATAANDNODO_NODO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				if (bindNodo) {
					queryPos.add(nodo);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_DATAANDNODO_DATE_1 =
		"counterSms.date IS NULL AND ";

	private static final String _FINDER_COLUMN_DATAANDNODO_DATE_2 =
		"counterSms.date = ? AND ";

	private static final String _FINDER_COLUMN_DATAANDNODO_NODO_2 =
		"counterSms.nodo = ?";

	private static final String _FINDER_COLUMN_DATAANDNODO_NODO_3 =
		"(counterSms.nodo IS NULL OR counterSms.nodo = '')";

	public CounterSmsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("date", "date_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CounterSms.class);

		setModelImplClass(CounterSmsImpl.class);
		setModelPKClass(long.class);

		setTable(CounterSmsTable.INSTANCE);
	}

	/**
	 * Caches the counter sms in the entity cache if it is enabled.
	 *
	 * @param counterSms the counter sms
	 */
	@Override
	public void cacheResult(CounterSms counterSms) {
		entityCache.putResult(
			CounterSmsImpl.class, counterSms.getPrimaryKey(), counterSms);

		finderCache.putResult(
			_finderPathFetchBydata, new Object[] {counterSms.getDate()},
			counterSms);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the counter smses in the entity cache if it is enabled.
	 *
	 * @param counterSmses the counter smses
	 */
	@Override
	public void cacheResult(List<CounterSms> counterSmses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (counterSmses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CounterSms counterSms : counterSmses) {
			if (entityCache.getResult(
					CounterSmsImpl.class, counterSms.getPrimaryKey()) == null) {

				cacheResult(counterSms);
			}
		}
	}

	/**
	 * Clears the cache for all counter smses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CounterSmsImpl.class);

		finderCache.clearCache(CounterSmsImpl.class);
	}

	/**
	 * Clears the cache for the counter sms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CounterSms counterSms) {
		entityCache.removeResult(CounterSmsImpl.class, counterSms);
	}

	@Override
	public void clearCache(List<CounterSms> counterSmses) {
		for (CounterSms counterSms : counterSmses) {
			entityCache.removeResult(CounterSmsImpl.class, counterSms);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CounterSmsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CounterSmsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CounterSmsModelImpl counterSmsModelImpl) {

		Object[] args = new Object[] {_getTime(counterSmsModelImpl.getDate())};

		finderCache.putResult(
			_finderPathFetchBydata, args, counterSmsModelImpl);
	}

	/**
	 * Creates a new counter sms with the primary key. Does not add the counter sms to the database.
	 *
	 * @param counterId the primary key for the new counter sms
	 * @return the new counter sms
	 */
	@Override
	public CounterSms create(long counterId) {
		CounterSms counterSms = new CounterSmsImpl();

		counterSms.setNew(true);
		counterSms.setPrimaryKey(counterId);

		return counterSms;
	}

	/**
	 * Removes the counter sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms that was removed
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms remove(long counterId) throws NoSuchCounterSmsException {
		return remove((Serializable)counterId);
	}

	/**
	 * Removes the counter sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the counter sms
	 * @return the counter sms that was removed
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms remove(Serializable primaryKey)
		throws NoSuchCounterSmsException {

		Session session = null;

		try {
			session = openSession();

			CounterSms counterSms = (CounterSms)session.get(
				CounterSmsImpl.class, primaryKey);

			if (counterSms == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCounterSmsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(counterSms);
		}
		catch (NoSuchCounterSmsException noSuchEntityException) {
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
	protected CounterSms removeImpl(CounterSms counterSms) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(counterSms)) {
				counterSms = (CounterSms)session.get(
					CounterSmsImpl.class, counterSms.getPrimaryKeyObj());
			}

			if (counterSms != null) {
				session.delete(counterSms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (counterSms != null) {
			clearCache(counterSms);
		}

		return counterSms;
	}

	@Override
	public CounterSms updateImpl(CounterSms counterSms) {
		boolean isNew = counterSms.isNew();

		if (!(counterSms instanceof CounterSmsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(counterSms.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(counterSms);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in counterSms proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CounterSms implementation " +
					counterSms.getClass());
		}

		CounterSmsModelImpl counterSmsModelImpl =
			(CounterSmsModelImpl)counterSms;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(counterSms);
			}
			else {
				counterSms = (CounterSms)session.merge(counterSms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CounterSmsImpl.class, counterSmsModelImpl, false, true);

		cacheUniqueFindersCache(counterSmsModelImpl);

		if (isNew) {
			counterSms.setNew(false);
		}

		counterSms.resetOriginalValues();

		return counterSms;
	}

	/**
	 * Returns the counter sms with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the counter sms
	 * @return the counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCounterSmsException {

		CounterSms counterSms = fetchByPrimaryKey(primaryKey);

		if (counterSms == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCounterSmsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return counterSms;
	}

	/**
	 * Returns the counter sms with the primary key or throws a <code>NoSuchCounterSmsException</code> if it could not be found.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms findByPrimaryKey(long counterId)
		throws NoSuchCounterSmsException {

		return findByPrimaryKey((Serializable)counterId);
	}

	/**
	 * Returns the counter sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms, or <code>null</code> if a counter sms with the primary key could not be found
	 */
	@Override
	public CounterSms fetchByPrimaryKey(long counterId) {
		return fetchByPrimaryKey((Serializable)counterId);
	}

	/**
	 * Returns all the counter smses.
	 *
	 * @return the counter smses
	 */
	@Override
	public List<CounterSms> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of counter smses
	 */
	@Override
	public List<CounterSms> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of counter smses
	 */
	@Override
	public List<CounterSms> findAll(
		int start, int end, OrderByComparator<CounterSms> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of counter smses
	 */
	@Override
	public List<CounterSms> findAll(
		int start, int end, OrderByComparator<CounterSms> orderByComparator,
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

		List<CounterSms> list = null;

		if (useFinderCache) {
			list = (List<CounterSms>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COUNTERSMS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COUNTERSMS;

				sql = sql.concat(CounterSmsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CounterSms>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the counter smses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CounterSms counterSms : findAll()) {
			remove(counterSms);
		}
	}

	/**
	 * Returns the number of counter smses.
	 *
	 * @return the number of counter smses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COUNTERSMS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "counterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COUNTERSMS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CounterSmsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the counter sms persistence.
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

		_finderPathFetchBydata = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydata",
			new String[] {Date.class.getName()}, new String[] {"date_"}, true);

		_finderPathWithPaginationFindBydataGreather = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydataGreather",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"date_"}, true);

		_finderPathWithPaginationCountBydataGreather = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBydataGreather",
			new String[] {Date.class.getName()}, new String[] {"date_"}, false);

		_finderPathWithPaginationFindBydataAndNodo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydataAndNodo",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"date_", "nodo"}, true);

		_finderPathWithoutPaginationFindBydataAndNodo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydataAndNodo",
			new String[] {Date.class.getName(), String.class.getName()},
			new String[] {"date_", "nodo"}, true);

		_finderPathCountBydataAndNodo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydataAndNodo",
			new String[] {Date.class.getName(), String.class.getName()},
			new String[] {"date_", "nodo"}, false);

		CounterSmsUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CounterSmsUtil.setPersistence(null);

		entityCache.removeCache(CounterSmsImpl.class.getName());
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_COUNTERSMS =
		"SELECT counterSms FROM CounterSms counterSms";

	private static final String _SQL_SELECT_COUNTERSMS_WHERE =
		"SELECT counterSms FROM CounterSms counterSms WHERE ";

	private static final String _SQL_COUNT_COUNTERSMS =
		"SELECT COUNT(counterSms) FROM CounterSms counterSms";

	private static final String _SQL_COUNT_COUNTERSMS_WHERE =
		"SELECT COUNT(counterSms) FROM CounterSms counterSms WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "counterSms.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CounterSms exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CounterSms exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CounterSmsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"date"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}