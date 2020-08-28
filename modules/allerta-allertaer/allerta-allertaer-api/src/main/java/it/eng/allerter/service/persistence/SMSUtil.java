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

import it.eng.allerter.model.SMS;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sms service. This utility wraps <code>it.eng.allerter.service.persistence.impl.SMSPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see SMSPersistence
 * @generated
 */
@ProviderType
public class SMSUtil {

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
	public static void clearCache(SMS sms) {
		getPersistence().clearCache(sms);
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
	public static Map<Serializable, SMS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SMS> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SMS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SMS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SMS update(SMS sms) {
		return getPersistence().update(sms);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SMS update(SMS sms, ServiceContext serviceContext) {
		return getPersistence().update(sms, serviceContext);
	}

	/**
	 * Returns all the smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching smses
	 */
	public static List<SMS> findByDestinatario(long destinatario) {
		return getPersistence().findByDestinatario(destinatario);
	}

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
	public static List<SMS> findByDestinatario(
		long destinatario, int start, int end) {

		return getPersistence().findByDestinatario(destinatario, start, end);
	}

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
	public static List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByDestinatario(
			destinatario, start, end, orderByComparator);
	}

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
	public static List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByDestinatario(
			destinatario, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByDestinatario_First(
			long destinatario, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByDestinatario_First(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByDestinatario_First(
		long destinatario, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByDestinatario_First(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByDestinatario_Last(
			long destinatario, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByDestinatario_Last(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByDestinatario_Last(
		long destinatario, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByDestinatario_Last(
			destinatario, orderByComparator);
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public static SMS[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByDestinatario_PrevAndNext(
			id, destinatario, orderByComparator);
	}

	/**
	 * Removes all the smses where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	public static void removeByDestinatario(long destinatario) {
		getPersistence().removeByDestinatario(destinatario);
	}

	/**
	 * Returns the number of smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching smses
	 */
	public static int countByDestinatario(long destinatario) {
		return getPersistence().countByDestinatario(destinatario);
	}

	/**
	 * Returns all the smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching smses
	 */
	public static List<SMS> findByNumero(String numero) {
		return getPersistence().findByNumero(numero);
	}

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
	public static List<SMS> findByNumero(String numero, int start, int end) {
		return getPersistence().findByNumero(numero, start, end);
	}

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
	public static List<SMS> findByNumero(
		String numero, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByNumero(
			numero, start, end, orderByComparator);
	}

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
	public static List<SMS> findByNumero(
		String numero, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByNumero(
			numero, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByNumero_First(
			String numero, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByNumero_First(numero, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByNumero_First(
		String numero, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByNumero_First(numero, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByNumero_Last(
			String numero, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByNumero_Last(numero, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByNumero_Last(
		String numero, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByNumero_Last(numero, orderByComparator);
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public static SMS[] findByNumero_PrevAndNext(
			long id, String numero, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByNumero_PrevAndNext(
			id, numero, orderByComparator);
	}

	/**
	 * Removes all the smses where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	public static void removeByNumero(String numero) {
		getPersistence().removeByNumero(numero);
	}

	/**
	 * Returns the number of smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching smses
	 */
	public static int countByNumero(String numero) {
		return getPersistence().countByNumero(numero);
	}

	/**
	 * Returns all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the matching smses
	 */
	public static List<SMS> findByNumeroDataAck(String numero, Date dataAck) {
		return getPersistence().findByNumeroDataAck(numero, dataAck);
	}

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
	public static List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end) {

		return getPersistence().findByNumeroDataAck(
			numero, dataAck, start, end);
	}

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
	public static List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByNumeroDataAck(
			numero, dataAck, start, end, orderByComparator);
	}

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
	public static List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByNumeroDataAck(
			numero, dataAck, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByNumeroDataAck_First(
			String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByNumeroDataAck_First(
			numero, dataAck, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByNumeroDataAck_First(
		String numero, Date dataAck, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByNumeroDataAck_First(
			numero, dataAck, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByNumeroDataAck_Last(
			String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByNumeroDataAck_Last(
			numero, dataAck, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByNumeroDataAck_Last(
		String numero, Date dataAck, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByNumeroDataAck_Last(
			numero, dataAck, orderByComparator);
	}

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
	public static SMS[] findByNumeroDataAck_PrevAndNext(
			long id, String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByNumeroDataAck_PrevAndNext(
			id, numero, dataAck, orderByComparator);
	}

	/**
	 * Removes all the smses where numero = &#63; and dataAck = &#63; from the database.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 */
	public static void removeByNumeroDataAck(String numero, Date dataAck) {
		getPersistence().removeByNumeroDataAck(numero, dataAck);
	}

	/**
	 * Returns the number of smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the number of matching smses
	 */
	public static int countByNumeroDataAck(String numero, Date dataAck) {
		return getPersistence().countByNumeroDataAck(numero, dataAck);
	}

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching smses
	 */
	public static List<SMS> findByInvio(
		String tipo, String sottotipo, long param) {

		return getPersistence().findByInvio(tipo, sottotipo, param);
	}

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
	public static List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end) {

		return getPersistence().findByInvio(tipo, sottotipo, param, start, end);
	}

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
	public static List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator);
	}

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
	public static List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static SMS findByInvio_First(
			String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByInvio_First(
			tipo, sottotipo, param, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByInvio_First(
		String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByInvio_First(
			tipo, sottotipo, param, orderByComparator);
	}

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
	public static SMS findByInvio_Last(
			String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByInvio_Last(
			tipo, sottotipo, param, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByInvio_Last(
			tipo, sottotipo, param, orderByComparator);
	}

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
	public static SMS[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByInvio_PrevAndNext(
			id, tipo, sottotipo, param, orderByComparator);
	}

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
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
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	public static int countByInvio(String tipo, String sottotipo, long param) {
		return getPersistence().countByInvio(tipo, sottotipo, param);
	}

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching smses
	 */
	public static List<SMS> findByTipoSottotipo(String tipo, String sottotipo) {
		return getPersistence().findByTipoSottotipo(tipo, sottotipo);
	}

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
	public static List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end) {

		return getPersistence().findByTipoSottotipo(
			tipo, sottotipo, start, end);
	}

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
	public static List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator);
	}

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
	public static List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByTipoSottotipo_First(
			String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTipoSottotipo_Last(
			tipo, sottotipo, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByTipoSottotipo_Last(
			tipo, sottotipo, orderByComparator);
	}

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
	public static SMS[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTipoSottotipo_PrevAndNext(
			id, tipo, sottotipo, orderByComparator);
	}

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	public static void removeByTipoSottotipo(String tipo, String sottotipo) {
		getPersistence().removeByTipoSottotipo(tipo, sottotipo);
	}

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching smses
	 */
	public static int countByTipoSottotipo(String tipo, String sottotipo) {
		return getPersistence().countByTipoSottotipo(tipo, sottotipo);
	}

	/**
	 * Returns all the smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching smses
	 */
	public static List<SMS> findByTipoParam(String tipo, long param) {
		return getPersistence().findByTipoParam(tipo, param);
	}

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
	public static List<SMS> findByTipoParam(
		String tipo, long param, int start, int end) {

		return getPersistence().findByTipoParam(tipo, param, start, end);
	}

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
	public static List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByTipoParam(
			tipo, param, start, end, orderByComparator);
	}

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
	public static List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTipoParam(
			tipo, param, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByTipoParam_First(
			String tipo, long param, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTipoParam_First(
			tipo, param, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByTipoParam_First(
		String tipo, long param, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByTipoParam_First(
			tipo, param, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByTipoParam_Last(
			String tipo, long param, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTipoParam_Last(
			tipo, param, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByTipoParam_Last(
		String tipo, long param, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByTipoParam_Last(
			tipo, param, orderByComparator);
	}

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
	public static SMS[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTipoParam_PrevAndNext(
			id, tipo, param, orderByComparator);
	}

	/**
	 * Removes all the smses where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	public static void removeByTipoParam(String tipo, long param) {
		getPersistence().removeByTipoParam(tipo, param);
	}

	/**
	 * Returns the number of smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	public static int countByTipoParam(String tipo, long param) {
		return getPersistence().countByTipoParam(tipo, param);
	}

	/**
	 * Returns all the smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching smses
	 */
	public static List<SMS> findByTimestamp(String timestamp) {
		return getPersistence().findByTimestamp(timestamp);
	}

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
	public static List<SMS> findByTimestamp(
		String timestamp, int start, int end) {

		return getPersistence().findByTimestamp(timestamp, start, end);
	}

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
	public static List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findByTimestamp(
			timestamp, start, end, orderByComparator);
	}

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
	public static List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTimestamp(
			timestamp, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByTimestamp_First(
			String timestamp, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTimestamp_First(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByTimestamp_First(
		String timestamp, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByTimestamp_First(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	public static SMS findByTimestamp_Last(
			String timestamp, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTimestamp_Last(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	public static SMS fetchByTimestamp_Last(
		String timestamp, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().fetchByTimestamp_Last(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where timestamp = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public static SMS[] findByTimestamp_PrevAndNext(
			long id, String timestamp, OrderByComparator<SMS> orderByComparator)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByTimestamp_PrevAndNext(
			id, timestamp, orderByComparator);
	}

	/**
	 * Removes all the smses where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 */
	public static void removeByTimestamp(String timestamp) {
		getPersistence().removeByTimestamp(timestamp);
	}

	/**
	 * Returns the number of smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching smses
	 */
	public static int countByTimestamp(String timestamp) {
		return getPersistence().countByTimestamp(timestamp);
	}

	/**
	 * Caches the sms in the entity cache if it is enabled.
	 *
	 * @param sms the sms
	 */
	public static void cacheResult(SMS sms) {
		getPersistence().cacheResult(sms);
	}

	/**
	 * Caches the smses in the entity cache if it is enabled.
	 *
	 * @param smses the smses
	 */
	public static void cacheResult(List<SMS> smses) {
		getPersistence().cacheResult(smses);
	}

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	public static SMS create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public static SMS remove(long id)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().remove(id);
	}

	public static SMS updateImpl(SMS sms) {
		return getPersistence().updateImpl(sms);
	}

	/**
	 * Returns the sms with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	public static SMS findByPrimaryKey(long id)
		throws it.eng.allerter.exception.NoSuchSMSException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms, or <code>null</code> if a sms with the primary key could not be found
	 */
	public static SMS fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the smses.
	 *
	 * @return the smses
	 */
	public static List<SMS> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SMS> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the smses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SMSPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SMSPersistence, SMSPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SMSPersistence.class);

		ServiceTracker<SMSPersistence, SMSPersistence> serviceTracker =
			new ServiceTracker<SMSPersistence, SMSPersistence>(
				bundle.getBundleContext(), SMSPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}