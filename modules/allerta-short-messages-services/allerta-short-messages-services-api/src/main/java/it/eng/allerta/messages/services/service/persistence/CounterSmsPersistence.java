/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerta.messages.services.exception.NoSuchCounterSmsException;
import it.eng.allerta.messages.services.model.CounterSms;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the counter sms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see CounterSmsUtil
 * @generated
 */
@ProviderType
public interface CounterSmsPersistence extends BasePersistence<CounterSms> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CounterSmsUtil} to access the counter sms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the counter sms where date = &#63; or throws a <code>NoSuchCounterSmsException</code> if it could not be found.
	 *
	 * @param date the date
	 * @return the matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public CounterSms findBydata(Date date) throws NoSuchCounterSmsException;

	/**
	 * Returns the counter sms where date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param date the date
	 * @return the matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public CounterSms fetchBydata(Date date);

	/**
	 * Returns the counter sms where date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param date the date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public CounterSms fetchBydata(Date date, boolean useFinderCache);

	/**
	 * Removes the counter sms where date = &#63; from the database.
	 *
	 * @param date the date
	 * @return the counter sms that was removed
	 */
	public CounterSms removeBydata(Date date) throws NoSuchCounterSmsException;

	/**
	 * Returns the number of counter smses where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching counter smses
	 */
	public int countBydata(Date date);

	/**
	 * Returns all the counter smses where date &gt; &#63;.
	 *
	 * @param date the date
	 * @return the matching counter smses
	 */
	public java.util.List<CounterSms> findBydataGreather(Date date);

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
	public java.util.List<CounterSms> findBydataGreather(
		Date date, int start, int end);

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
	public java.util.List<CounterSms> findBydataGreather(
		Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

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
	public java.util.List<CounterSms> findBydataGreather(
		Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public CounterSms findBydataGreather_First(
			Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
				orderByComparator)
		throws NoSuchCounterSmsException;

	/**
	 * Returns the first counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public CounterSms fetchBydataGreather_First(
		Date date,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

	/**
	 * Returns the last counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public CounterSms findBydataGreather_Last(
			Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
				orderByComparator)
		throws NoSuchCounterSmsException;

	/**
	 * Returns the last counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public CounterSms fetchBydataGreather_Last(
		Date date,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

	/**
	 * Returns the counter smses before and after the current counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param counterId the primary key of the current counter sms
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public CounterSms[] findBydataGreather_PrevAndNext(
			long counterId, Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
				orderByComparator)
		throws NoSuchCounterSmsException;

	/**
	 * Removes all the counter smses where date &gt; &#63; from the database.
	 *
	 * @param date the date
	 */
	public void removeBydataGreather(Date date);

	/**
	 * Returns the number of counter smses where date &gt; &#63;.
	 *
	 * @param date the date
	 * @return the number of matching counter smses
	 */
	public int countBydataGreather(Date date);

	/**
	 * Returns all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @return the matching counter smses
	 */
	public java.util.List<CounterSms> findBydataAndNodo(Date date, String nodo);

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
	public java.util.List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end);

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
	public java.util.List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

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
	public java.util.List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public CounterSms findBydataAndNodo_First(
			Date date, String nodo,
			com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
				orderByComparator)
		throws NoSuchCounterSmsException;

	/**
	 * Returns the first counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public CounterSms fetchBydataAndNodo_First(
		Date date, String nodo,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

	/**
	 * Returns the last counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public CounterSms findBydataAndNodo_Last(
			Date date, String nodo,
			com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
				orderByComparator)
		throws NoSuchCounterSmsException;

	/**
	 * Returns the last counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public CounterSms fetchBydataAndNodo_Last(
		Date date, String nodo,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

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
	public CounterSms[] findBydataAndNodo_PrevAndNext(
			long counterId, Date date, String nodo,
			com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
				orderByComparator)
		throws NoSuchCounterSmsException;

	/**
	 * Removes all the counter smses where date = &#63; and nodo = &#63; from the database.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 */
	public void removeBydataAndNodo(Date date, String nodo);

	/**
	 * Returns the number of counter smses where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @return the number of matching counter smses
	 */
	public int countBydataAndNodo(Date date, String nodo);

	/**
	 * Caches the counter sms in the entity cache if it is enabled.
	 *
	 * @param counterSms the counter sms
	 */
	public void cacheResult(CounterSms counterSms);

	/**
	 * Caches the counter smses in the entity cache if it is enabled.
	 *
	 * @param counterSmses the counter smses
	 */
	public void cacheResult(java.util.List<CounterSms> counterSmses);

	/**
	 * Creates a new counter sms with the primary key. Does not add the counter sms to the database.
	 *
	 * @param counterId the primary key for the new counter sms
	 * @return the new counter sms
	 */
	public CounterSms create(long counterId);

	/**
	 * Removes the counter sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms that was removed
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public CounterSms remove(long counterId) throws NoSuchCounterSmsException;

	public CounterSms updateImpl(CounterSms counterSms);

	/**
	 * Returns the counter sms with the primary key or throws a <code>NoSuchCounterSmsException</code> if it could not be found.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public CounterSms findByPrimaryKey(long counterId)
		throws NoSuchCounterSmsException;

	/**
	 * Returns the counter sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms, or <code>null</code> if a counter sms with the primary key could not be found
	 */
	public CounterSms fetchByPrimaryKey(long counterId);

	/**
	 * Returns all the counter smses.
	 *
	 * @return the counter smses
	 */
	public java.util.List<CounterSms> findAll();

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
	public java.util.List<CounterSms> findAll(int start, int end);

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
	public java.util.List<CounterSms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator);

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
	public java.util.List<CounterSms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CounterSms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the counter smses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of counter smses.
	 *
	 * @return the number of counter smses
	 */
	public int countAll();

}