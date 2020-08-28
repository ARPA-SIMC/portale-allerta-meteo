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

import it.eng.allerter.exception.NoSuchEmailException;
import it.eng.allerter.model.Email;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see EmailUtil
 * @generated
 */
@ProviderType
public interface EmailPersistence extends BasePersistence<Email> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailUtil} to access the email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Email> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching emails
	 */
	public java.util.List<Email> findByDestinatario(long destinatario);

	/**
	 * Returns a range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	public java.util.List<Email> findByDestinatario(
		long destinatario, int start, int end);

	/**
	 * Returns an ordered range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByDestinatario(
		long destinatario, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByDestinatario(
		long destinatario, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByDestinatario_First(
			long destinatario,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByDestinatario_First(
		long destinatario,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByDestinatario_Last(
			long destinatario,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByDestinatario_Last(
		long destinatario,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the emails before and after the current email in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Removes all the emails where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	public void removeByDestinatario(long destinatario);

	/**
	 * Returns the number of emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching emails
	 */
	public int countByDestinatario(long destinatario);

	/**
	 * Returns all the emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the matching emails
	 */
	public java.util.List<Email> findByIndirizzo(String indirizzo);

	/**
	 * Returns a range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	public java.util.List<Email> findByIndirizzo(
		String indirizzo, int start, int end);

	/**
	 * Returns an ordered range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByIndirizzo_First(
			String indirizzo,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByIndirizzo_First(
		String indirizzo,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByIndirizzo_Last(
			String indirizzo,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByIndirizzo_Last(
		String indirizzo,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the emails before and after the current email in the ordered set where indirizzo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email[] findByIndirizzo_PrevAndNext(
			long id, String indirizzo,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Removes all the emails where indirizzo = &#63; from the database.
	 *
	 * @param indirizzo the indirizzo
	 */
	public void removeByIndirizzo(String indirizzo);

	/**
	 * Returns the number of emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the number of matching emails
	 */
	public int countByIndirizzo(String indirizzo);

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching emails
	 */
	public java.util.List<Email> findByInvio(
		String tipo, String sottotipo, long param);

	/**
	 * Returns a range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	public java.util.List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end);

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByInvio_First(
			String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByInvio_First(
		String tipo, String sottotipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByInvio_Last(
			String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	public void removeByInvio(String tipo, String sottotipo, long param);

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	public int countByInvio(String tipo, String sottotipo, long param);

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching emails
	 */
	public java.util.List<Email> findByTipoSottotipo(
		String tipo, String sottotipo);

	/**
	 * Returns a range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	public java.util.List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end);

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByTipoSottotipo_First(
			String tipo, String sottotipo,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	public void removeByTipoSottotipo(String tipo, String sottotipo);

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching emails
	 */
	public int countByTipoSottotipo(String tipo, String sottotipo);

	/**
	 * Returns all the emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching emails
	 */
	public java.util.List<Email> findByTipoParam(String tipo, long param);

	/**
	 * Returns a range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	public java.util.List<Email> findByTipoParam(
		String tipo, long param, int start, int end);

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emails
	 */
	public java.util.List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByTipoParam_First(
			String tipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByTipoParam_First(
		String tipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public Email findByTipoParam_Last(
			String tipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public Email fetchByTipoParam_Last(
		String tipo, long param,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			com.liferay.portal.kernel.util.OrderByComparator<Email>
				orderByComparator)
		throws NoSuchEmailException;

	/**
	 * Removes all the emails where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	public void removeByTipoParam(String tipo, long param);

	/**
	 * Returns the number of emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	public int countByTipoParam(String tipo, long param);

	/**
	 * Caches the email in the entity cache if it is enabled.
	 *
	 * @param email the email
	 */
	public void cacheResult(Email email);

	/**
	 * Caches the emails in the entity cache if it is enabled.
	 *
	 * @param emails the emails
	 */
	public void cacheResult(java.util.List<Email> emails);

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	public Email create(long id);

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email remove(long id) throws NoSuchEmailException;

	public Email updateImpl(Email email);

	/**
	 * Returns the email with the primary key or throws a <code>NoSuchEmailException</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public Email findByPrimaryKey(long id) throws NoSuchEmailException;

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	public Email fetchByPrimaryKey(long id);

	/**
	 * Returns all the emails.
	 *
	 * @return the emails
	 */
	public java.util.List<Email> findAll();

	/**
	 * Returns a range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of emails
	 */
	public java.util.List<Email> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emails
	 */
	public java.util.List<Email> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of emails
	 */
	public java.util.List<Email> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the emails from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}