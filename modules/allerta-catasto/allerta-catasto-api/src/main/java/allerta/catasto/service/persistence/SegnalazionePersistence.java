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

package allerta.catasto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.exception.NoSuchSegnalazioneException;
import allerta.catasto.model.Segnalazione;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the segnalazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneUtil
 * @generated
 */
@ProviderType
public interface SegnalazionePersistence extends BasePersistence<Segnalazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SegnalazioneUtil} to access the segnalazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Segnalazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @return the matching segnalaziones
	 */
	public java.util.List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato);

	/**
	 * Returns a range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of matching segnalaziones
	 */
	public java.util.List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end);

	/**
	 * Returns an ordered range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segnalaziones
	 */
	public java.util.List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching segnalaziones
	 */
	public java.util.List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segnalazione
	 * @throws NoSuchSegnalazioneException if a matching segnalazione could not be found
	 */
	public Segnalazione findByDocumentoAssociato_First(
			long documentoAssociato,
			com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
				orderByComparator)
		throws NoSuchSegnalazioneException;

	/**
	 * Returns the first segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segnalazione, or <code>null</code> if a matching segnalazione could not be found
	 */
	public Segnalazione fetchByDocumentoAssociato_First(
		long documentoAssociato,
		com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
			orderByComparator);

	/**
	 * Returns the last segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segnalazione
	 * @throws NoSuchSegnalazioneException if a matching segnalazione could not be found
	 */
	public Segnalazione findByDocumentoAssociato_Last(
			long documentoAssociato,
			com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
				orderByComparator)
		throws NoSuchSegnalazioneException;

	/**
	 * Returns the last segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segnalazione, or <code>null</code> if a matching segnalazione could not be found
	 */
	public Segnalazione fetchByDocumentoAssociato_Last(
		long documentoAssociato,
		com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
			orderByComparator);

	/**
	 * Returns the segnalaziones before and after the current segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param id the primary key of the current segnalazione
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	public Segnalazione[] findByDocumentoAssociato_PrevAndNext(
			long id, long documentoAssociato,
			com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
				orderByComparator)
		throws NoSuchSegnalazioneException;

	/**
	 * Removes all the segnalaziones where documentoAssociato = &#63; from the database.
	 *
	 * @param documentoAssociato the documento associato
	 */
	public void removeByDocumentoAssociato(long documentoAssociato);

	/**
	 * Returns the number of segnalaziones where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @return the number of matching segnalaziones
	 */
	public int countByDocumentoAssociato(long documentoAssociato);

	/**
	 * Caches the segnalazione in the entity cache if it is enabled.
	 *
	 * @param segnalazione the segnalazione
	 */
	public void cacheResult(Segnalazione segnalazione);

	/**
	 * Caches the segnalaziones in the entity cache if it is enabled.
	 *
	 * @param segnalaziones the segnalaziones
	 */
	public void cacheResult(java.util.List<Segnalazione> segnalaziones);

	/**
	 * Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	 *
	 * @param id the primary key for the new segnalazione
	 * @return the new segnalazione
	 */
	public Segnalazione create(long id);

	/**
	 * Removes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	public Segnalazione remove(long id) throws NoSuchSegnalazioneException;

	public Segnalazione updateImpl(Segnalazione segnalazione);

	/**
	 * Returns the segnalazione with the primary key or throws a <code>NoSuchSegnalazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	public Segnalazione findByPrimaryKey(long id)
		throws NoSuchSegnalazioneException;

	/**
	 * Returns the segnalazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione, or <code>null</code> if a segnalazione with the primary key could not be found
	 */
	public Segnalazione fetchByPrimaryKey(long id);

	/**
	 * Returns all the segnalaziones.
	 *
	 * @return the segnalaziones
	 */
	public java.util.List<Segnalazione> findAll();

	/**
	 * Returns a range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of segnalaziones
	 */
	public java.util.List<Segnalazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segnalaziones
	 */
	public java.util.List<Segnalazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of segnalaziones
	 */
	public java.util.List<Segnalazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segnalazione>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the segnalaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of segnalaziones.
	 *
	 * @return the number of segnalaziones
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}