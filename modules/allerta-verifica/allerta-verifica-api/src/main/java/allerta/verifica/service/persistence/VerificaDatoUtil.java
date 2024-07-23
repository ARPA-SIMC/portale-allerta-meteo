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

import allerta.verifica.model.VerificaDato;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the verifica dato service. This utility wraps <code>allerta.verifica.service.persistence.impl.VerificaDatoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDatoPersistence
 * @generated
 */
@ProviderType
public class VerificaDatoUtil {

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
	public static void clearCache(VerificaDato verificaDato) {
		getPersistence().clearCache(verificaDato);
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
	public static Map<Serializable, VerificaDato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VerificaDato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VerificaDato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VerificaDato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VerificaDato update(VerificaDato verificaDato) {
		return getPersistence().update(verificaDato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VerificaDato update(
		VerificaDato verificaDato, ServiceContext serviceContext) {

		return getPersistence().update(verificaDato, serviceContext);
	}

	/**
	 * Returns all the verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByDocumento(long documento) {
		return getPersistence().findByDocumento(documento);
	}

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
	public static List<VerificaDato> findByDocumento(
		long documento, int start, int end) {

		return getPersistence().findByDocumento(documento, start, end);
	}

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
	public static List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByDocumento(
			documento, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumento(
			documento, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByDocumento_First(
			long documento, OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumento_First(
			documento, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumento_First(
		long documento, OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumento_First(
			documento, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByDocumento_Last(
			long documento, OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumento_Last(
			documento, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumento_Last(
		long documento, OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumento_Last(
			documento, orderByComparator);
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public static VerificaDato[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumento_PrevAndNext(
			id, documento, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	public static void removeByDocumento(long documento) {
		getPersistence().removeByDocumento(documento);
	}

	/**
	 * Returns the number of verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verifica datos
	 */
	public static int countByDocumento(long documento) {
		return getPersistence().countByDocumento(documento);
	}

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno) {

		return getPersistence().findByDocumentoGiorno(documento, giorno);
	}

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
	public static List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end) {

		return getPersistence().findByDocumentoGiorno(
			documento, giorno, start, end);
	}

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
	public static List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByDocumentoGiorno(
			documento, giorno, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumentoGiorno(
			documento, giorno, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByDocumentoGiorno_First(
			long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiorno_First(
			documento, giorno, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumentoGiorno_First(
		long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiorno_First(
			documento, giorno, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByDocumentoGiorno_Last(
			long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiorno_Last(
			documento, giorno, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumentoGiorno_Last(
		long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiorno_Last(
			documento, giorno, orderByComparator);
	}

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
	public static VerificaDato[] findByDocumentoGiorno_PrevAndNext(
			long id, long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiorno_PrevAndNext(
			id, documento, giorno, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 */
	public static void removeByDocumentoGiorno(long documento, Date giorno) {
		getPersistence().removeByDocumentoGiorno(documento, giorno);
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	public static int countByDocumentoGiorno(long documento, Date giorno) {
		return getPersistence().countByDocumentoGiorno(documento, giorno);
	}

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		return getPersistence().findByDocumentoGiornoEvento(
			documento, giorno, evento);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end) {

		return getPersistence().findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static VerificaDato findByDocumentoGiornoEvento_First(
			long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoEvento_First(
			documento, giorno, evento, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumentoGiornoEvento_First(
		long documento, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiornoEvento_First(
			documento, giorno, evento, orderByComparator);
	}

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
	public static VerificaDato findByDocumentoGiornoEvento_Last(
			long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoEvento_Last(
			documento, giorno, evento, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumentoGiornoEvento_Last(
		long documento, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiornoEvento_Last(
			documento, giorno, evento, orderByComparator);
	}

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
	public static VerificaDato[] findByDocumentoGiornoEvento_PrevAndNext(
			long id, long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoEvento_PrevAndNext(
			id, documento, giorno, evento, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	public static void removeByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		getPersistence().removeByDocumentoGiornoEvento(
			documento, giorno, evento);
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public static int countByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		return getPersistence().countByDocumentoGiornoEvento(
			documento, giorno, evento);
	}

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		return getPersistence().findByDocumentoGiornoZona(
			documento, giorno, zona);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end) {

		return getPersistence().findByDocumentoGiornoZona(
			documento, giorno, zona, start, end);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByDocumentoGiornoZona(
			documento, giorno, zona, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumentoGiornoZona(
			documento, giorno, zona, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static VerificaDato findByDocumentoGiornoZona_First(
			long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoZona_First(
			documento, giorno, zona, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumentoGiornoZona_First(
		long documento, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiornoZona_First(
			documento, giorno, zona, orderByComparator);
	}

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
	public static VerificaDato findByDocumentoGiornoZona_Last(
			long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoZona_Last(
			documento, giorno, zona, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByDocumentoGiornoZona_Last(
		long documento, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiornoZona_Last(
			documento, giorno, zona, orderByComparator);
	}

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
	public static VerificaDato[] findByDocumentoGiornoZona_PrevAndNext(
			long id, long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoZona_PrevAndNext(
			id, documento, giorno, zona, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	public static void removeByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		getPersistence().removeByDocumentoGiornoZona(documento, giorno, zona);
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	public static int countByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		return getPersistence().countByDocumentoGiornoZona(
			documento, giorno, zona);
	}

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		return getPersistence().findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end) {

		return getPersistence().findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end, OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end, OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static VerificaDato findByDocumentoGiornoZonaEvento_First(
			long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoZonaEvento_First(
			documento, giorno, zona, evento, orderByComparator);
	}

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
	public static VerificaDato fetchByDocumentoGiornoZonaEvento_First(
		long documento, Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiornoZonaEvento_First(
			documento, giorno, zona, evento, orderByComparator);
	}

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
	public static VerificaDato findByDocumentoGiornoZonaEvento_Last(
			long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoZonaEvento_Last(
			documento, giorno, zona, evento, orderByComparator);
	}

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
	public static VerificaDato fetchByDocumentoGiornoZonaEvento_Last(
		long documento, Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByDocumentoGiornoZonaEvento_Last(
			documento, giorno, zona, evento, orderByComparator);
	}

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
	public static VerificaDato[] findByDocumentoGiornoZonaEvento_PrevAndNext(
			long id, long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByDocumentoGiornoZonaEvento_PrevAndNext(
			id, documento, giorno, zona, evento, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	public static void removeByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		getPersistence().removeByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento);
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public static int countByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		return getPersistence().countByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento);
	}

	/**
	 * Returns all the verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByGiorno(Date giorno) {
		return getPersistence().findByGiorno(giorno);
	}

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
	public static List<VerificaDato> findByGiorno(
		Date giorno, int start, int end) {

		return getPersistence().findByGiorno(giorno, start, end);
	}

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
	public static List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByGiorno(
			giorno, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGiorno(
			giorno, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByGiorno_First(
			Date giorno, OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiorno_First(giorno, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiorno_First(
		Date giorno, OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiorno_First(giorno, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByGiorno_Last(
			Date giorno, OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiorno_Last(giorno, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiorno_Last(
		Date giorno, OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiorno_Last(giorno, orderByComparator);
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public static VerificaDato[] findByGiorno_PrevAndNext(
			long id, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiorno_PrevAndNext(
			id, giorno, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; from the database.
	 *
	 * @param giorno the giorno
	 */
	public static void removeByGiorno(Date giorno) {
		getPersistence().removeByGiorno(giorno);
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	public static int countByGiorno(Date giorno) {
		return getPersistence().countByGiorno(giorno);
	}

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByGiornoZona(
		Date giorno, String zona) {

		return getPersistence().findByGiornoZona(giorno, zona);
	}

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
	public static List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end) {

		return getPersistence().findByGiornoZona(giorno, zona, start, end);
	}

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
	public static List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByGiornoZona(
			giorno, zona, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGiornoZona(
			giorno, zona, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByGiornoZona_First(
			Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoZona_First(
			giorno, zona, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiornoZona_First(
		Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiornoZona_First(
			giorno, zona, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByGiornoZona_Last(
			Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoZona_Last(
			giorno, zona, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiornoZona_Last(
		Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiornoZona_Last(
			giorno, zona, orderByComparator);
	}

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
	public static VerificaDato[] findByGiornoZona_PrevAndNext(
			long id, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoZona_PrevAndNext(
			id, giorno, zona, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	public static void removeByGiornoZona(Date giorno, String zona) {
		getPersistence().removeByGiornoZona(giorno, zona);
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	public static int countByGiornoZona(Date giorno, String zona) {
		return getPersistence().countByGiornoZona(giorno, zona);
	}

	/**
	 * Returns all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento) {

		return getPersistence().findByGiornoEvento(giorno, evento);
	}

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
	public static List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end) {

		return getPersistence().findByGiornoEvento(giorno, evento, start, end);
	}

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
	public static List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByGiornoEvento(
			giorno, evento, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGiornoEvento(
			giorno, evento, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByGiornoEvento_First(
			Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoEvento_First(
			giorno, evento, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiornoEvento_First(
		Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiornoEvento_First(
			giorno, evento, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	public static VerificaDato findByGiornoEvento_Last(
			Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoEvento_Last(
			giorno, evento, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiornoEvento_Last(
		Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiornoEvento_Last(
			giorno, evento, orderByComparator);
	}

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
	public static VerificaDato[] findByGiornoEvento_PrevAndNext(
			long id, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoEvento_PrevAndNext(
			id, giorno, evento, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	public static void removeByGiornoEvento(Date giorno, long evento) {
		getPersistence().removeByGiornoEvento(giorno, evento);
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public static int countByGiornoEvento(Date giorno, long evento) {
		return getPersistence().countByGiornoEvento(giorno, evento);
	}

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	public static List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		return getPersistence().findByGiornoZonaEvento(giorno, zona, evento);
	}

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
	public static List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end) {

		return getPersistence().findByGiornoZonaEvento(
			giorno, zona, evento, start, end);
	}

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
	public static List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findByGiornoZonaEvento(
			giorno, zona, evento, start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGiornoZonaEvento(
			giorno, zona, evento, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static VerificaDato findByGiornoZonaEvento_First(
			Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoZonaEvento_First(
			giorno, zona, evento, orderByComparator);
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiornoZonaEvento_First(
		Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiornoZonaEvento_First(
			giorno, zona, evento, orderByComparator);
	}

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
	public static VerificaDato findByGiornoZonaEvento_Last(
			Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoZonaEvento_Last(
			giorno, zona, evento, orderByComparator);
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	public static VerificaDato fetchByGiornoZonaEvento_Last(
		Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().fetchByGiornoZonaEvento_Last(
			giorno, zona, evento, orderByComparator);
	}

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
	public static VerificaDato[] findByGiornoZonaEvento_PrevAndNext(
			long id, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByGiornoZonaEvento_PrevAndNext(
			id, giorno, zona, evento, orderByComparator);
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	public static void removeByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		getPersistence().removeByGiornoZonaEvento(giorno, zona, evento);
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	public static int countByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		return getPersistence().countByGiornoZonaEvento(giorno, zona, evento);
	}

	/**
	 * Caches the verifica dato in the entity cache if it is enabled.
	 *
	 * @param verificaDato the verifica dato
	 */
	public static void cacheResult(VerificaDato verificaDato) {
		getPersistence().cacheResult(verificaDato);
	}

	/**
	 * Caches the verifica datos in the entity cache if it is enabled.
	 *
	 * @param verificaDatos the verifica datos
	 */
	public static void cacheResult(List<VerificaDato> verificaDatos) {
		getPersistence().cacheResult(verificaDatos);
	}

	/**
	 * Creates a new verifica dato with the primary key. Does not add the verifica dato to the database.
	 *
	 * @param id the primary key for the new verifica dato
	 * @return the new verifica dato
	 */
	public static VerificaDato create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public static VerificaDato remove(long id)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().remove(id);
	}

	public static VerificaDato updateImpl(VerificaDato verificaDato) {
		return getPersistence().updateImpl(verificaDato);
	}

	/**
	 * Returns the verifica dato with the primary key or throws a <code>NoSuchVerificaDatoException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	public static VerificaDato findByPrimaryKey(long id)
		throws allerta.verifica.exception.NoSuchVerificaDatoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the verifica dato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato, or <code>null</code> if a verifica dato with the primary key could not be found
	 */
	public static VerificaDato fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the verifica datos.
	 *
	 * @return the verifica datos
	 */
	public static List<VerificaDato> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<VerificaDato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<VerificaDato> findAll(
		int start, int end, OrderByComparator<VerificaDato> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<VerificaDato> findAll(
		int start, int end, OrderByComparator<VerificaDato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the verifica datos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of verifica datos.
	 *
	 * @return the number of verifica datos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static VerificaDatoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<VerificaDatoPersistence, VerificaDatoPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VerificaDatoPersistence.class);

		ServiceTracker<VerificaDatoPersistence, VerificaDatoPersistence>
			serviceTracker =
				new ServiceTracker
					<VerificaDatoPersistence, VerificaDatoPersistence>(
						bundle.getBundleContext(),
						VerificaDatoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}