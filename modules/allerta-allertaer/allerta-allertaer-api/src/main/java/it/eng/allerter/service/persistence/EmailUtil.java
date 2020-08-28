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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.Email;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the email service. This utility wraps <code>it.eng.allerter.service.persistence.impl.EmailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see EmailPersistence
 * @generated
 */
@ProviderType
public class EmailUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Email email) {
		getPersistence().clearCache(email);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Email> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Email> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Email> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Email> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Email update(Email email) {
		return getPersistence().update(email);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Email update(Email email, ServiceContext serviceContext) {
		return getPersistence().update(email, serviceContext);
	}

	/**
	 * Returns all the emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching emails
	 */
	public static List<Email> findByDestinatario(long destinatario) {
		return getPersistence().findByDestinatario(destinatario);
	}

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
	public static List<Email> findByDestinatario(
		long destinatario, int start, int end) {

		return getPersistence().findByDestinatario(destinatario, start, end);
	}

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
	public static List<Email> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().findByDestinatario(
			destinatario, start, end, orderByComparator);
	}

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
	public static List<Email> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByDestinatario(
			destinatario, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByDestinatario_First(
			long destinatario, OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByDestinatario_First(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByDestinatario_First(
		long destinatario, OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByDestinatario_First(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByDestinatario_Last(
			long destinatario, OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByDestinatario_Last(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByDestinatario_Last(
		long destinatario, OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByDestinatario_Last(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public static Email[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByDestinatario_PrevAndNext(
			id, destinatario, orderByComparator);
	}

	/**
	 * Removes all the emails where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	public static void removeByDestinatario(long destinatario) {
		getPersistence().removeByDestinatario(destinatario);
	}

	/**
	 * Returns the number of emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching emails
	 */
	public static int countByDestinatario(long destinatario) {
		return getPersistence().countByDestinatario(destinatario);
	}

	/**
	 * Returns all the emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the matching emails
	 */
	public static List<Email> findByIndirizzo(String indirizzo) {
		return getPersistence().findByIndirizzo(indirizzo);
	}

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
	public static List<Email> findByIndirizzo(
		String indirizzo, int start, int end) {

		return getPersistence().findByIndirizzo(indirizzo, start, end);
	}

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
	public static List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().findByIndirizzo(
			indirizzo, start, end, orderByComparator);
	}

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
	public static List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByIndirizzo(
			indirizzo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByIndirizzo_First(
			String indirizzo, OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByIndirizzo_First(
			indirizzo, orderByComparator);
	}

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByIndirizzo_First(
		String indirizzo, OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByIndirizzo_First(
			indirizzo, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByIndirizzo_Last(
			String indirizzo, OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByIndirizzo_Last(
			indirizzo, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByIndirizzo_Last(
		String indirizzo, OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByIndirizzo_Last(
			indirizzo, orderByComparator);
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where indirizzo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public static Email[] findByIndirizzo_PrevAndNext(
			long id, String indirizzo,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByIndirizzo_PrevAndNext(
			id, indirizzo, orderByComparator);
	}

	/**
	 * Removes all the emails where indirizzo = &#63; from the database.
	 *
	 * @param indirizzo the indirizzo
	 */
	public static void removeByIndirizzo(String indirizzo) {
		getPersistence().removeByIndirizzo(indirizzo);
	}

	/**
	 * Returns the number of emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the number of matching emails
	 */
	public static int countByIndirizzo(String indirizzo) {
		return getPersistence().countByIndirizzo(indirizzo);
	}

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching emails
	 */
	public static List<Email> findByInvio(
		String tipo, String sottotipo, long param) {

		return getPersistence().findByInvio(tipo, sottotipo, param);
	}

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
	public static List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end) {

		return getPersistence().findByInvio(tipo, sottotipo, param, start, end);
	}

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
	public static List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator);
	}

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
	public static List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static Email findByInvio_First(
			String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByInvio_First(
			tipo, sottotipo, param, orderByComparator);
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByInvio_First(
		String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByInvio_First(
			tipo, sottotipo, param, orderByComparator);
	}

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
	public static Email findByInvio_Last(
			String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByInvio_Last(
			tipo, sottotipo, param, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByInvio_Last(
			tipo, sottotipo, param, orderByComparator);
	}

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
	public static Email[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByInvio_PrevAndNext(
			id, tipo, sottotipo, param, orderByComparator);
	}

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	public static void removeByInvio(
		String tipo, String sottotipo, long param) {

		getPersistence().removeByInvio(tipo, sottotipo, param);
	}

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	public static int countByInvio(String tipo, String sottotipo, long param) {
		return getPersistence().countByInvio(tipo, sottotipo, param);
	}

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching emails
	 */
	public static List<Email> findByTipoSottotipo(
		String tipo, String sottotipo) {

		return getPersistence().findByTipoSottotipo(tipo, sottotipo);
	}

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
	public static List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end) {

		return getPersistence().findByTipoSottotipo(
			tipo, sottotipo, start, end);
	}

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
	public static List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator);
	}

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
	public static List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByTipoSottotipo_First(
			String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByTipoSottotipo_Last(
			tipo, sottotipo, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByTipoSottotipo_Last(
			tipo, sottotipo, orderByComparator);
	}

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
	public static Email[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByTipoSottotipo_PrevAndNext(
			id, tipo, sottotipo, orderByComparator);
	}

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	public static void removeByTipoSottotipo(String tipo, String sottotipo) {
		getPersistence().removeByTipoSottotipo(tipo, sottotipo);
	}

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching emails
	 */
	public static int countByTipoSottotipo(String tipo, String sottotipo) {
		return getPersistence().countByTipoSottotipo(tipo, sottotipo);
	}

	/**
	 * Returns all the emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching emails
	 */
	public static List<Email> findByTipoParam(String tipo, long param) {
		return getPersistence().findByTipoParam(tipo, param);
	}

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
	public static List<Email> findByTipoParam(
		String tipo, long param, int start, int end) {

		return getPersistence().findByTipoParam(tipo, param, start, end);
	}

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
	public static List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return getPersistence().findByTipoParam(
			tipo, param, start, end, orderByComparator);
	}

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
	public static List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTipoParam(
			tipo, param, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByTipoParam_First(
			String tipo, long param, OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByTipoParam_First(
			tipo, param, orderByComparator);
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByTipoParam_First(
		String tipo, long param, OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByTipoParam_First(
			tipo, param, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	public static Email findByTipoParam_Last(
			String tipo, long param, OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByTipoParam_Last(
			tipo, param, orderByComparator);
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	public static Email fetchByTipoParam_Last(
		String tipo, long param, OrderByComparator<Email> orderByComparator) {

		return getPersistence().fetchByTipoParam_Last(
			tipo, param, orderByComparator);
	}

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
	public static Email[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByTipoParam_PrevAndNext(
			id, tipo, param, orderByComparator);
	}

	/**
	 * Removes all the emails where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	public static void removeByTipoParam(String tipo, long param) {
		getPersistence().removeByTipoParam(tipo, param);
	}

	/**
	 * Returns the number of emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	public static int countByTipoParam(String tipo, long param) {
		return getPersistence().countByTipoParam(tipo, param);
	}

	/**
	 * Caches the email in the entity cache if it is enabled.
	 *
	 * @param email the email
	 */
	public static void cacheResult(Email email) {
		getPersistence().cacheResult(email);
	}

	/**
	 * Caches the emails in the entity cache if it is enabled.
	 *
	 * @param emails the emails
	 */
	public static void cacheResult(List<Email> emails) {
		getPersistence().cacheResult(emails);
	}

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	public static Email create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public static Email remove(long id)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().remove(id);
	}

	public static Email updateImpl(Email email) {
		return getPersistence().updateImpl(email);
	}

	/**
	 * Returns the email with the primary key or throws a <code>NoSuchEmailException</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	public static Email findByPrimaryKey(long id)
		throws it.eng.allerter.exception.NoSuchEmailException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	public static Email fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the emails.
	 *
	 * @return the emails
	 */
	public static List<Email> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Email> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Email> findAll(
		int start, int end, OrderByComparator<Email> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Email> findAll(
		int start, int end, OrderByComparator<Email> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the emails from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmailPersistence, EmailPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmailPersistence.class);

		ServiceTracker<EmailPersistence, EmailPersistence> serviceTracker =
			new ServiceTracker<EmailPersistence, EmailPersistence>(
				bundle.getBundleContext(), EmailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}