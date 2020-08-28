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

package it.eng.bollettino.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.Idrometro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the idrometro service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.IdrometroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see IdrometroPersistence
 * @generated
 */
@ProviderType
public class IdrometroUtil {

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
	public static void clearCache(Idrometro idrometro) {
		getPersistence().clearCache(idrometro);
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
	public static Map<Serializable, Idrometro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Idrometro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Idrometro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Idrometro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Idrometro update(Idrometro idrometro) {
		return getPersistence().update(idrometro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Idrometro update(
		Idrometro idrometro, ServiceContext serviceContext) {

		return getPersistence().update(idrometro, serviceContext);
	}

	/**
	 * Returns all the idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the matching idrometros
	 */
	public static List<Idrometro> findByNomeBacino(String nomeBacino) {
		return getPersistence().findByNomeBacino(nomeBacino);
	}

	/**
	 * Returns a range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	public static List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end) {

		return getPersistence().findByNomeBacino(nomeBacino, start, end);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	public static List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().findByNomeBacino(
			nomeBacino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	public static List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNomeBacino(
			nomeBacino, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public static Idrometro findByNomeBacino_First(
			String nomeBacino, OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeBacino_First(
			nomeBacino, orderByComparator);
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public static Idrometro fetchByNomeBacino_First(
		String nomeBacino, OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().fetchByNomeBacino_First(
			nomeBacino, orderByComparator);
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public static Idrometro findByNomeBacino_Last(
			String nomeBacino, OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeBacino_Last(
			nomeBacino, orderByComparator);
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public static Idrometro fetchByNomeBacino_Last(
		String nomeBacino, OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().fetchByNomeBacino_Last(
			nomeBacino, orderByComparator);
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public static Idrometro[] findByNomeBacino_PrevAndNext(
			String stazioneId, String nomeBacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeBacino_PrevAndNext(
			stazioneId, nomeBacino, orderByComparator);
	}

	/**
	 * Removes all the idrometros where nomeBacino = &#63; from the database.
	 *
	 * @param nomeBacino the nome bacino
	 */
	public static void removeByNomeBacino(String nomeBacino) {
		getPersistence().removeByNomeBacino(nomeBacino);
	}

	/**
	 * Returns the number of idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the number of matching idrometros
	 */
	public static int countByNomeBacino(String nomeBacino) {
		return getPersistence().countByNomeBacino(nomeBacino);
	}

	/**
	 * Returns all the idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the matching idrometros
	 */
	public static List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino) {

		return getPersistence().findByNomeSottobacino(nomeSottobacino);
	}

	/**
	 * Returns a range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	public static List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end) {

		return getPersistence().findByNomeSottobacino(
			nomeSottobacino, start, end);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	public static List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().findByNomeSottobacino(
			nomeSottobacino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	public static List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNomeSottobacino(
			nomeSottobacino, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public static Idrometro findByNomeSottobacino_First(
			String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeSottobacino_First(
			nomeSottobacino, orderByComparator);
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public static Idrometro fetchByNomeSottobacino_First(
		String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().fetchByNomeSottobacino_First(
			nomeSottobacino, orderByComparator);
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public static Idrometro findByNomeSottobacino_Last(
			String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeSottobacino_Last(
			nomeSottobacino, orderByComparator);
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public static Idrometro fetchByNomeSottobacino_Last(
		String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().fetchByNomeSottobacino_Last(
			nomeSottobacino, orderByComparator);
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public static Idrometro[] findByNomeSottobacino_PrevAndNext(
			String stazioneId, String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeSottobacino_PrevAndNext(
			stazioneId, nomeSottobacino, orderByComparator);
	}

	/**
	 * Removes all the idrometros where nomeSottobacino = &#63; from the database.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 */
	public static void removeByNomeSottobacino(String nomeSottobacino) {
		getPersistence().removeByNomeSottobacino(nomeSottobacino);
	}

	/**
	 * Returns the number of idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the number of matching idrometros
	 */
	public static int countByNomeSottobacino(String nomeSottobacino) {
		return getPersistence().countByNomeSottobacino(nomeSottobacino);
	}

	/**
	 * Returns all the idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching idrometros
	 */
	public static List<Idrometro> findByNomeRubrica(String nomeRubrica) {
		return getPersistence().findByNomeRubrica(nomeRubrica);
	}

	/**
	 * Returns a range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	public static List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end) {

		return getPersistence().findByNomeRubrica(nomeRubrica, start, end);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	public static List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	public static List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public static Idrometro findByNomeRubrica_First(
			String nomeRubrica, OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeRubrica_First(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public static Idrometro fetchByNomeRubrica_First(
		String nomeRubrica, OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().fetchByNomeRubrica_First(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public static Idrometro findByNomeRubrica_Last(
			String nomeRubrica, OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeRubrica_Last(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public static Idrometro fetchByNomeRubrica_Last(
		String nomeRubrica, OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().fetchByNomeRubrica_Last(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public static Idrometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			OrderByComparator<Idrometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByNomeRubrica_PrevAndNext(
			stazioneId, nomeRubrica, orderByComparator);
	}

	/**
	 * Removes all the idrometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	public static void removeByNomeRubrica(String nomeRubrica) {
		getPersistence().removeByNomeRubrica(nomeRubrica);
	}

	/**
	 * Returns the number of idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching idrometros
	 */
	public static int countByNomeRubrica(String nomeRubrica) {
		return getPersistence().countByNomeRubrica(nomeRubrica);
	}

	/**
	 * Caches the idrometro in the entity cache if it is enabled.
	 *
	 * @param idrometro the idrometro
	 */
	public static void cacheResult(Idrometro idrometro) {
		getPersistence().cacheResult(idrometro);
	}

	/**
	 * Caches the idrometros in the entity cache if it is enabled.
	 *
	 * @param idrometros the idrometros
	 */
	public static void cacheResult(List<Idrometro> idrometros) {
		getPersistence().cacheResult(idrometros);
	}

	/**
	 * Creates a new idrometro with the primary key. Does not add the idrometro to the database.
	 *
	 * @param stazioneId the primary key for the new idrometro
	 * @return the new idrometro
	 */
	public static Idrometro create(String stazioneId) {
		return getPersistence().create(stazioneId);
	}

	/**
	 * Removes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public static Idrometro remove(String stazioneId)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().remove(stazioneId);
	}

	public static Idrometro updateImpl(Idrometro idrometro) {
		return getPersistence().updateImpl(idrometro);
	}

	/**
	 * Returns the idrometro with the primary key or throws a <code>NoSuchIdrometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public static Idrometro findByPrimaryKey(String stazioneId)
		throws it.eng.bollettino.exception.NoSuchIdrometroException {

		return getPersistence().findByPrimaryKey(stazioneId);
	}

	/**
	 * Returns the idrometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro, or <code>null</code> if a idrometro with the primary key could not be found
	 */
	public static Idrometro fetchByPrimaryKey(String stazioneId) {
		return getPersistence().fetchByPrimaryKey(stazioneId);
	}

	/**
	 * Returns all the idrometros.
	 *
	 * @return the idrometros
	 */
	public static List<Idrometro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of idrometros
	 */
	public static List<Idrometro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idrometros
	 */
	public static List<Idrometro> findAll(
		int start, int end, OrderByComparator<Idrometro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of idrometros
	 */
	public static List<Idrometro> findAll(
		int start, int end, OrderByComparator<Idrometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the idrometros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of idrometros.
	 *
	 * @return the number of idrometros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IdrometroPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IdrometroPersistence, IdrometroPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IdrometroPersistence.class);

		ServiceTracker<IdrometroPersistence, IdrometroPersistence>
			serviceTracker =
				new ServiceTracker<IdrometroPersistence, IdrometroPersistence>(
					bundle.getBundleContext(), IdrometroPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}