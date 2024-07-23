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

package allerta.dewetra.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.dewetra.exception.NoSuchHRWException;
import allerta.dewetra.model.HRW;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the hrw service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HRWUtil
 * @generated
 */
@ProviderType
public interface HRWPersistence extends BasePersistence<HRW> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HRWUtil} to access the hrw persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, HRW> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the matching hrws
	 */
	public java.util.List<HRW> findByComune(String comune);

	/**
	 * Returns a range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of matching hrws
	 */
	public java.util.List<HRW> findByComune(String comune, int start, int end);

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hrws
	 */
	public java.util.List<HRW> findByComune(
		String comune, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HRW>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching hrws
	 */
	public java.util.List<HRW> findByComune(
		String comune, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HRW> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	public HRW findByComune_First(
			String comune,
			com.liferay.portal.kernel.util.OrderByComparator<HRW>
				orderByComparator)
		throws NoSuchHRWException;

	/**
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	public HRW fetchByComune_First(
		String comune,
		com.liferay.portal.kernel.util.OrderByComparator<HRW>
			orderByComparator);

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	public HRW findByComune_Last(
			String comune,
			com.liferay.portal.kernel.util.OrderByComparator<HRW>
				orderByComparator)
		throws NoSuchHRWException;

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	public HRW fetchByComune_Last(
		String comune,
		com.liferay.portal.kernel.util.OrderByComparator<HRW>
			orderByComparator);

	/**
	 * Returns the hrws before and after the current hrw in the ordered set where comune = &#63;.
	 *
	 * @param id the primary key of the current hrw
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	public HRW[] findByComune_PrevAndNext(
			long id, String comune,
			com.liferay.portal.kernel.util.OrderByComparator<HRW>
				orderByComparator)
		throws NoSuchHRWException;

	/**
	 * Removes all the hrws where comune = &#63; from the database.
	 *
	 * @param comune the comune
	 */
	public void removeByComune(String comune);

	/**
	 * Returns the number of hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the number of matching hrws
	 */
	public int countByComune(String comune);

	/**
	 * Caches the hrw in the entity cache if it is enabled.
	 *
	 * @param hrw the hrw
	 */
	public void cacheResult(HRW hrw);

	/**
	 * Caches the hrws in the entity cache if it is enabled.
	 *
	 * @param hrws the hrws
	 */
	public void cacheResult(java.util.List<HRW> hrws);

	/**
	 * Creates a new hrw with the primary key. Does not add the hrw to the database.
	 *
	 * @param id the primary key for the new hrw
	 * @return the new hrw
	 */
	public HRW create(long id);

	/**
	 * Removes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	public HRW remove(long id) throws NoSuchHRWException;

	public HRW updateImpl(HRW hrw);

	/**
	 * Returns the hrw with the primary key or throws a <code>NoSuchHRWException</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	public HRW findByPrimaryKey(long id) throws NoSuchHRWException;

	/**
	 * Returns the hrw with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw, or <code>null</code> if a hrw with the primary key could not be found
	 */
	public HRW fetchByPrimaryKey(long id);

	/**
	 * Returns all the hrws.
	 *
	 * @return the hrws
	 */
	public java.util.List<HRW> findAll();

	/**
	 * Returns a range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of hrws
	 */
	public java.util.List<HRW> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hrws
	 */
	public java.util.List<HRW> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HRW>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of hrws
	 */
	public java.util.List<HRW> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HRW> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the hrws from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of hrws.
	 *
	 * @return the number of hrws
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}