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

package it.eng.parer.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.parer.exception.NoSuchDatiSpecificiInvioException;
import it.eng.parer.model.DatiSpecificiInvio;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the dati specifici invio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioUtil
 * @generated
 */
@ProviderType
public interface DatiSpecificiInvioPersistence
	extends BasePersistence<DatiSpecificiInvio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DatiSpecificiInvioUtil} to access the dati specifici invio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, DatiSpecificiInvio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @return the matching dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO);

	/**
	 * Returns a range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of matching dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end);

	/**
	 * Returns an ordered range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a matching dati specifici invio could not be found
	 */
	public DatiSpecificiInvio findByesitoInvio_First(
			String ESITO_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
				orderByComparator)
		throws NoSuchDatiSpecificiInvioException;

	/**
	 * Returns the first dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dati specifici invio, or <code>null</code> if a matching dati specifici invio could not be found
	 */
	public DatiSpecificiInvio fetchByesitoInvio_First(
		String ESITO_INVIO,
		com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
			orderByComparator);

	/**
	 * Returns the last dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a matching dati specifici invio could not be found
	 */
	public DatiSpecificiInvio findByesitoInvio_Last(
			String ESITO_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
				orderByComparator)
		throws NoSuchDatiSpecificiInvioException;

	/**
	 * Returns the last dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dati specifici invio, or <code>null</code> if a matching dati specifici invio could not be found
	 */
	public DatiSpecificiInvio fetchByesitoInvio_Last(
		String ESITO_INVIO,
		com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
			orderByComparator);

	/**
	 * Returns the dati specifici invios before and after the current dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ID_INVIO the primary key of the current dati specifici invio
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	public DatiSpecificiInvio[] findByesitoInvio_PrevAndNext(
			long ID_INVIO, String ESITO_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
				orderByComparator)
		throws NoSuchDatiSpecificiInvioException;

	/**
	 * Removes all the dati specifici invios where ESITO_INVIO = &#63; from the database.
	 *
	 * @param ESITO_INVIO the esito_invio
	 */
	public void removeByesitoInvio(String ESITO_INVIO);

	/**
	 * Returns the number of dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @return the number of matching dati specifici invios
	 */
	public int countByesitoInvio(String ESITO_INVIO);

	/**
	 * Caches the dati specifici invio in the entity cache if it is enabled.
	 *
	 * @param datiSpecificiInvio the dati specifici invio
	 */
	public void cacheResult(DatiSpecificiInvio datiSpecificiInvio);

	/**
	 * Caches the dati specifici invios in the entity cache if it is enabled.
	 *
	 * @param datiSpecificiInvios the dati specifici invios
	 */
	public void cacheResult(
		java.util.List<DatiSpecificiInvio> datiSpecificiInvios);

	/**
	 * Creates a new dati specifici invio with the primary key. Does not add the dati specifici invio to the database.
	 *
	 * @param ID_INVIO the primary key for the new dati specifici invio
	 * @return the new dati specifici invio
	 */
	public DatiSpecificiInvio create(long ID_INVIO);

	/**
	 * Removes the dati specifici invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio that was removed
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	public DatiSpecificiInvio remove(long ID_INVIO)
		throws NoSuchDatiSpecificiInvioException;

	public DatiSpecificiInvio updateImpl(DatiSpecificiInvio datiSpecificiInvio);

	/**
	 * Returns the dati specifici invio with the primary key or throws a <code>NoSuchDatiSpecificiInvioException</code> if it could not be found.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	public DatiSpecificiInvio findByPrimaryKey(long ID_INVIO)
		throws NoSuchDatiSpecificiInvioException;

	/**
	 * Returns the dati specifici invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio, or <code>null</code> if a dati specifici invio with the primary key could not be found
	 */
	public DatiSpecificiInvio fetchByPrimaryKey(long ID_INVIO);

	/**
	 * Returns all the dati specifici invios.
	 *
	 * @return the dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findAll();

	/**
	 * Returns a range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dati specifici invios
	 */
	public java.util.List<DatiSpecificiInvio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DatiSpecificiInvio>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the dati specifici invios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dati specifici invios.
	 *
	 * @return the number of dati specifici invios
	 */
	public int countAll();

}