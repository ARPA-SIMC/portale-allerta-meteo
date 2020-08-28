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

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaSitoException;
import it.eng.allerte.model.RubricaSito;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaSitoUtil
 * @generated
 */
@ProviderType
public interface RubricaSitoPersistence extends BasePersistence<RubricaSito> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaSitoUtil} to access the rubrica sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaSito> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the matching rubrica sitos
	 */
	public java.util.List<RubricaSito> findByLiferaySite(long FK_LIFERAY_SITE);

	/**
	 * Returns a range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of matching rubrica sitos
	 */
	public java.util.List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica sitos
	 */
	public java.util.List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica sitos
	 */
	public java.util.List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	public RubricaSito findByLiferaySite_First(
			long FK_LIFERAY_SITE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
				orderByComparator)
		throws NoSuchRubricaSitoException;

	/**
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	public RubricaSito fetchByLiferaySite_First(
		long FK_LIFERAY_SITE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
			orderByComparator);

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	public RubricaSito findByLiferaySite_Last(
			long FK_LIFERAY_SITE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
				orderByComparator)
		throws NoSuchRubricaSitoException;

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	public RubricaSito fetchByLiferaySite_Last(
		long FK_LIFERAY_SITE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
			orderByComparator);

	/**
	 * Returns the rubrica sitos before and after the current rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param ID_SITO the primary key of the current rubrica sito
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	public RubricaSito[] findByLiferaySite_PrevAndNext(
			long ID_SITO, long FK_LIFERAY_SITE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
				orderByComparator)
		throws NoSuchRubricaSitoException;

	/**
	 * Removes all the rubrica sitos where FK_LIFERAY_SITE = &#63; from the database.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 */
	public void removeByLiferaySite(long FK_LIFERAY_SITE);

	/**
	 * Returns the number of rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the number of matching rubrica sitos
	 */
	public int countByLiferaySite(long FK_LIFERAY_SITE);

	/**
	 * Caches the rubrica sito in the entity cache if it is enabled.
	 *
	 * @param rubricaSito the rubrica sito
	 */
	public void cacheResult(RubricaSito rubricaSito);

	/**
	 * Caches the rubrica sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaSitos the rubrica sitos
	 */
	public void cacheResult(java.util.List<RubricaSito> rubricaSitos);

	/**
	 * Creates a new rubrica sito with the primary key. Does not add the rubrica sito to the database.
	 *
	 * @param ID_SITO the primary key for the new rubrica sito
	 * @return the new rubrica sito
	 */
	public RubricaSito create(long ID_SITO);

	/**
	 * Removes the rubrica sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito that was removed
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	public RubricaSito remove(long ID_SITO) throws NoSuchRubricaSitoException;

	public RubricaSito updateImpl(RubricaSito rubricaSito);

	/**
	 * Returns the rubrica sito with the primary key or throws a <code>NoSuchRubricaSitoException</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	public RubricaSito findByPrimaryKey(long ID_SITO)
		throws NoSuchRubricaSitoException;

	/**
	 * Returns the rubrica sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito, or <code>null</code> if a rubrica sito with the primary key could not be found
	 */
	public RubricaSito fetchByPrimaryKey(long ID_SITO);

	/**
	 * Returns all the rubrica sitos.
	 *
	 * @return the rubrica sitos
	 */
	public java.util.List<RubricaSito> findAll();

	/**
	 * Returns a range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of rubrica sitos
	 */
	public java.util.List<RubricaSito> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica sitos
	 */
	public java.util.List<RubricaSito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica sitos
	 */
	public java.util.List<RubricaSito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaSito>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica sitos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica sitos.
	 *
	 * @return the number of rubrica sitos
	 */
	public int countAll();

}