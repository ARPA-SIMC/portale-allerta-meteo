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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchSMSException;
import it.eng.allerter.model.SMS;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the sms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see SMSUtil
 * @generated
 */
@ProviderType
public interface SMSPersistence extends BasePersistence<SMS> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SMSUtil} to access the sms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, SMS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByDestinatario(long destinatario);

	/**
	 * Returns a range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByDestinatario(
		long destinatario, int start, int end);

	/**
	 * Returns an ordered range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByDestinatario_First(
			long destinatario,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByDestinatario_First(
		long destinatario,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByDestinatario_Last(
			long destinatario,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByDestinatario_Last(
		long destinatario,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	public void removeByDestinatario(long destinatario);

	/**
	 * Returns the number of smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching smses
	 */
	public int countByDestinatario(long destinatario);

	/**
	 * Returns all the smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByNumero(String numero);

	/**
	 * Returns a range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByNumero(String numero, int start, int end);

	/**
	 * Returns an ordered range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByNumero_First(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByNumero_First(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByNumero_Last(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByNumero_Last(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByNumero_PrevAndNext(
			long id, String numero,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	public void removeByNumero(String numero);

	/**
	 * Returns the number of smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching smses
	 */
	public int countByNumero(String numero);

	/**
	 * Returns all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByNumeroDataAck(String numero, Date dataAck);

	/**
	 * Returns a range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end);

	/**
	 * Returns an ordered range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByNumeroDataAck_First(
			String numero, Date dataAck,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByNumeroDataAck_First(
		String numero, Date dataAck,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByNumeroDataAck_Last(
			String numero, Date dataAck,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByNumeroDataAck_Last(
		String numero, Date dataAck,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByNumeroDataAck_PrevAndNext(
			long id, String numero, Date dataAck,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where numero = &#63; and dataAck = &#63; from the database.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 */
	public void removeByNumeroDataAck(String numero, Date dataAck);

	/**
	 * Returns the number of smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the number of matching smses
	 */
	public int countByNumeroDataAck(String numero, Date dataAck);

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByInvio(
		String tipo, String sottotipo, long param);

	/**
	 * Returns a range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end);

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByInvio_First(
			String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByInvio_First(
		String tipo, String sottotipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByInvio_Last(
			String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	public void removeByInvio(String tipo, String sottotipo, long param);

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	public int countByInvio(String tipo, String sottotipo, long param);

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo);

	/**
	 * Returns a range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end);

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByTipoSottotipo_First(
			String tipo, String sottotipo,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	public void removeByTipoSottotipo(String tipo, String sottotipo);

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching smses
	 */
	public int countByTipoSottotipo(String tipo, String sottotipo);

	/**
	 * Returns all the smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByTipoParam(String tipo, long param);

	/**
	 * Returns a range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByTipoParam(
		String tipo, long param, int start, int end);

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByTipoParam_First(
			String tipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByTipoParam_First(
		String tipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByTipoParam_Last(
			String tipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByTipoParam_Last(
		String tipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	public void removeByTipoParam(String tipo, long param);

	/**
	 * Returns the number of smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	public int countByTipoParam(String tipo, long param);

	/**
	 * Returns all the smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching smses
	 */
	public java.util.List<SMS> findByTimestamp(String timestamp);

	/**
	 * Returns a range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	public java.util.List<SMS> findByTimestamp(
		String timestamp, int start, int end);

	/**
	 * Returns an ordered range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching smses
	 */
	public java.util.List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByTimestamp_First(
			String timestamp,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByTimestamp_First(
		String timestamp,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public SMS findByTimestamp_Last(
			String timestamp,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public SMS fetchByTimestamp_Last(
		String timestamp,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns the smses before and after the current sms in the ordered set where timestamp = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS[] findByTimestamp_PrevAndNext(
			long id, String timestamp,
			com.liferay.portal.kernel.util.OrderByComparator<SMS>
				orderByComparator)
		throws NoSuchSMSException;

	/**
	 * Removes all the smses where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 */
	public void removeByTimestamp(String timestamp);

	/**
	 * Returns the number of smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching smses
	 */
	public int countByTimestamp(String timestamp);

	/**
	 * Caches the sms in the entity cache if it is enabled.
	 *
	 * @param sms the sms
	 */
	public void cacheResult(SMS sms);

	/**
	 * Caches the smses in the entity cache if it is enabled.
	 *
	 * @param smses the smses
	 */
	public void cacheResult(java.util.List<SMS> smses);

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	public SMS create(long id);

	/**
	 * Removes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS remove(long id) throws NoSuchSMSException;

	public SMS updateImpl(SMS sms);

	/**
	 * Returns the sms with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public SMS findByPrimaryKey(long id) throws NoSuchSMSException;

	/**
	 * Returns the sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms, or <code>null</code> if a sms with the primary key could not be found
	 */
	public SMS fetchByPrimaryKey(long id);

	/**
	 * Returns all the smses.
	 *
	 * @return the smses
	 */
	public java.util.List<SMS> findAll();

	/**
	 * Returns a range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of smses
	 */
	public java.util.List<SMS> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smses
	 */
	public java.util.List<SMS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of smses
	 */
	public java.util.List<SMS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the smses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}