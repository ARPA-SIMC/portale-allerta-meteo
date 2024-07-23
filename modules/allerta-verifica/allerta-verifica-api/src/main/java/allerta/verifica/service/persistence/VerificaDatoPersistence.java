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

package allerta.verifica.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.exception.NoSuchVerificaDatoException;
import allerta.verifica.model.VerificaDato;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the verifica dato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDatoUtil
 * @generated
 */
@ProviderType
public interface VerificaDatoPersistence extends BasePersistence<VerificaDato> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VerificaDatoUtil} to access the verifica dato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, VerificaDato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumento(long documento);

	/**
	 * Returns a range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumento(
		long documento, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumento_First(
			long documento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumento_First(
		long documento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumento_Last(
			long documento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumento_Last(
		long documento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByDocumento_PrevAndNext(
			long id, long documento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	public void removeByDocumento(long documento);

	/**
	 * Returns the number of verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verifica datos
	 */
	public int countByDocumento(long documento);

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno);

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiorno_First(
			long documento, Date giorno,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiorno_First(
		long documento, Date giorno,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiorno_Last(
			long documento, Date giorno,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiorno_Last(
		long documento, Date giorno,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByDocumentoGiorno_PrevAndNext(
			long id, long documento, Date giorno,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 */
	public void removeByDocumentoGiorno(long documento, Date giorno);

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	public int countByDocumentoGiorno(long documento, Date giorno);

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento);

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiornoEvento_First(
			long documento, Date giorno, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiornoEvento_First(
		long documento, Date giorno, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiornoEvento_Last(
			long documento, Date giorno, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiornoEvento_Last(
		long documento, Date giorno, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByDocumentoGiornoEvento_PrevAndNext(
			long id, long documento, Date giorno, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	public void removeByDocumentoGiornoEvento(
		long documento, Date giorno, long evento);

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public int countByDocumentoGiornoEvento(
		long documento, Date giorno, long evento);

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona);

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiornoZona_First(
			long documento, Date giorno, String zona,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiornoZona_First(
		long documento, Date giorno, String zona,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiornoZona_Last(
			long documento, Date giorno, String zona,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiornoZona_Last(
		long documento, Date giorno, String zona,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByDocumentoGiornoZona_PrevAndNext(
			long id, long documento, Date giorno, String zona,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	public void removeByDocumentoGiornoZona(
		long documento, Date giorno, String zona);

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	public int countByDocumentoGiornoZona(
		long documento, Date giorno, String zona);

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento);

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiornoZonaEvento_First(
			long documento, Date giorno, String zona, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiornoZonaEvento_First(
		long documento, Date giorno, String zona, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByDocumentoGiornoZonaEvento_Last(
			long documento, Date giorno, String zona, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByDocumentoGiornoZonaEvento_Last(
		long documento, Date giorno, String zona, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByDocumentoGiornoZonaEvento_PrevAndNext(
			long id, long documento, Date giorno, String zona, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	public void removeByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento);

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public int countByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento);

	/**
	 * Returns all the verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiorno(Date giorno);

	/**
	 * Returns a range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiorno(
		Date giorno, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiorno_First(
			Date giorno,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiorno_First(
		Date giorno,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiorno_Last(
			Date giorno,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiorno_Last(
		Date giorno,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByGiorno_PrevAndNext(
			long id, Date giorno,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where giorno = &#63; from the database.
	 *
	 * @param giorno the giorno
	 */
	public void removeByGiorno(Date giorno);

	/**
	 * Returns the number of verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	public int countByGiorno(Date giorno);

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZona(
		Date giorno, String zona);

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiornoZona_First(
			Date giorno, String zona,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiornoZona_First(
		Date giorno, String zona,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiornoZona_Last(
			Date giorno, String zona,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiornoZona_Last(
		Date giorno, String zona,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByGiornoZona_PrevAndNext(
			long id, Date giorno, String zona,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	public void removeByGiornoZona(Date giorno, String zona);

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	public int countByGiornoZona(Date giorno, String zona);

	/**
	 * Returns all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento);

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiornoEvento_First(
			Date giorno, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiornoEvento_First(
		Date giorno, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiornoEvento_Last(
			Date giorno, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiornoEvento_Last(
		Date giorno, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByGiornoEvento_PrevAndNext(
			long id, Date giorno, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	public void removeByGiornoEvento(Date giorno, long evento);

	/**
	 * Returns the number of verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public int countByGiornoEvento(Date giorno, long evento);

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento);

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	public java.util.List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiornoZonaEvento_First(
			Date giorno, String zona, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiornoZonaEvento_First(
		Date giorno, String zona, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public VerificaDato findByGiornoZonaEvento_Last(
			Date giorno, String zona, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public VerificaDato fetchByGiornoZonaEvento_Last(
		Date giorno, String zona, long evento,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato[] findByGiornoZonaEvento_PrevAndNext(
			long id, Date giorno, String zona, long evento,
			com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
				orderByComparator)
		throws NoSuchVerificaDatoException;

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	public void removeByGiornoZonaEvento(Date giorno, String zona, long evento);

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public int countByGiornoZonaEvento(Date giorno, String zona, long evento);

	/**
	 * Caches the verifica dato in the entity cache if it is enabled.
	 *
	 * @param verificaDato the verifica dato
	 */
	public void cacheResult(VerificaDato verificaDato);

	/**
	 * Caches the verifica datos in the entity cache if it is enabled.
	 *
	 * @param verificaDatos the verifica datos
	 */
	public void cacheResult(java.util.List<VerificaDato> verificaDatos);

	/**
	 * Creates a new verifica dato with the primary key. Does not add the verifica dato to the database.
	 *
	 * @param id the primary key for the new verifica dato
	 * @return the new verifica dato
	 */
	public VerificaDato create(long id);

	/**
	 * Removes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato remove(long id) throws NoSuchVerificaDatoException;

	public VerificaDato updateImpl(VerificaDato verificaDato);

	/**
	 * Returns the verifica dato with the primary key or throws a <code>NoSuchVerificaDatoException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public VerificaDato findByPrimaryKey(long id)
		throws NoSuchVerificaDatoException;

	/**
	 * Returns the verifica dato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato, or <code>null</code> if a verifica dato with the primary key could not be found
	 */
	public VerificaDato fetchByPrimaryKey(long id);

	/**
	 * Returns all the verifica datos.
	 *
	 * @return the verifica datos
	 */
	public java.util.List<VerificaDato> findAll();

	/**
	 * Returns a range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of verifica datos
	 */
	public java.util.List<VerificaDato> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verifica datos
	 */
	public java.util.List<VerificaDato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of verifica datos
	 */
	public java.util.List<VerificaDato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerificaDato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the verifica datos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of verifica datos.
	 *
	 * @return the number of verifica datos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}