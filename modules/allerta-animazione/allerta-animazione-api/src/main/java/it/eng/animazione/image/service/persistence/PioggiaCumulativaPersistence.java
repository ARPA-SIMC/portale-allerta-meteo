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

package it.eng.animazione.image.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the pioggia cumulativa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see PioggiaCumulativaUtil
 * @generated
 */
@ProviderType
public interface PioggiaCumulativaPersistence
	extends BasePersistence<PioggiaCumulativa> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PioggiaCumulativaUtil} to access the pioggia cumulativa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, PioggiaCumulativa> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the matching pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findByCumulazione(
		String cumulazione);

	/**
	 * Returns a range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of matching pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end);

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	public PioggiaCumulativa findByCumulazione_First(
			String cumulazione,
			com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
				orderByComparator)
		throws NoSuchPioggiaCumulativaException;

	/**
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	public PioggiaCumulativa fetchByCumulazione_First(
		String cumulazione,
		com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
			orderByComparator);

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	public PioggiaCumulativa findByCumulazione_Last(
			String cumulazione,
			com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
				orderByComparator)
		throws NoSuchPioggiaCumulativaException;

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	public PioggiaCumulativa fetchByCumulazione_Last(
		String cumulazione,
		com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
			orderByComparator);

	/**
	 * Returns the pioggia cumulativas before and after the current pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param id the primary key of the current pioggia cumulativa
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	public PioggiaCumulativa[] findByCumulazione_PrevAndNext(
			long id, String cumulazione,
			com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
				orderByComparator)
		throws NoSuchPioggiaCumulativaException;

	/**
	 * Removes all the pioggia cumulativas where cumulazione = &#63; from the database.
	 *
	 * @param cumulazione the cumulazione
	 */
	public void removeByCumulazione(String cumulazione);

	/**
	 * Returns the number of pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the number of matching pioggia cumulativas
	 */
	public int countByCumulazione(String cumulazione);

	/**
	 * Caches the pioggia cumulativa in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 */
	public void cacheResult(PioggiaCumulativa pioggiaCumulativa);

	/**
	 * Caches the pioggia cumulativas in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativas the pioggia cumulativas
	 */
	public void cacheResult(
		java.util.List<PioggiaCumulativa> pioggiaCumulativas);

	/**
	 * Creates a new pioggia cumulativa with the primary key. Does not add the pioggia cumulativa to the database.
	 *
	 * @param id the primary key for the new pioggia cumulativa
	 * @return the new pioggia cumulativa
	 */
	public PioggiaCumulativa create(long id);

	/**
	 * Removes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	public PioggiaCumulativa remove(long id)
		throws NoSuchPioggiaCumulativaException;

	public PioggiaCumulativa updateImpl(PioggiaCumulativa pioggiaCumulativa);

	/**
	 * Returns the pioggia cumulativa with the primary key or throws a <code>NoSuchPioggiaCumulativaException</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	public PioggiaCumulativa findByPrimaryKey(long id)
		throws NoSuchPioggiaCumulativaException;

	/**
	 * Returns the pioggia cumulativa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa, or <code>null</code> if a pioggia cumulativa with the primary key could not be found
	 */
	public PioggiaCumulativa fetchByPrimaryKey(long id);

	/**
	 * Returns all the pioggia cumulativas.
	 *
	 * @return the pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findAll();

	/**
	 * Returns a range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pioggia cumulativas
	 */
	public java.util.List<PioggiaCumulativa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PioggiaCumulativa>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the pioggia cumulativas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pioggia cumulativas.
	 *
	 * @return the number of pioggia cumulativas
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}