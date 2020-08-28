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

import it.eng.bollettino.model.Pluviometro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the pluviometro service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.PluviometroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see PluviometroPersistence
 * @generated
 */
@ProviderType
public class PluviometroUtil {

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
	public static void clearCache(Pluviometro pluviometro) {
		getPersistence().clearCache(pluviometro);
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
	public static Map<Serializable, Pluviometro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Pluviometro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Pluviometro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Pluviometro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Pluviometro update(Pluviometro pluviometro) {
		return getPersistence().update(pluviometro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Pluviometro update(
		Pluviometro pluviometro, ServiceContext serviceContext) {

		return getPersistence().update(pluviometro, serviceContext);
	}

	/**
	 * Returns all the pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the matching pluviometros
	 */
	public static List<Pluviometro> findByNomeGruppo(String nomeGruppo) {
		return getPersistence().findByNomeGruppo(nomeGruppo);
	}

	/**
	 * Returns a range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	public static List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end) {

		return getPersistence().findByNomeGruppo(nomeGruppo, start, end);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	public static List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().findByNomeGruppo(
			nomeGruppo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	public static List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNomeGruppo(
			nomeGruppo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public static Pluviometro findByNomeGruppo_First(
			String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByNomeGruppo_First(
			nomeGruppo, orderByComparator);
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public static Pluviometro fetchByNomeGruppo_First(
		String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().fetchByNomeGruppo_First(
			nomeGruppo, orderByComparator);
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public static Pluviometro findByNomeGruppo_Last(
			String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByNomeGruppo_Last(
			nomeGruppo, orderByComparator);
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public static Pluviometro fetchByNomeGruppo_Last(
		String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().fetchByNomeGruppo_Last(
			nomeGruppo, orderByComparator);
	}

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public static Pluviometro[] findByNomeGruppo_PrevAndNext(
			String stazioneId, String nomeGruppo,
			OrderByComparator<Pluviometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByNomeGruppo_PrevAndNext(
			stazioneId, nomeGruppo, orderByComparator);
	}

	/**
	 * Removes all the pluviometros where nomeGruppo = &#63; from the database.
	 *
	 * @param nomeGruppo the nome gruppo
	 */
	public static void removeByNomeGruppo(String nomeGruppo) {
		getPersistence().removeByNomeGruppo(nomeGruppo);
	}

	/**
	 * Returns the number of pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the number of matching pluviometros
	 */
	public static int countByNomeGruppo(String nomeGruppo) {
		return getPersistence().countByNomeGruppo(nomeGruppo);
	}

	/**
	 * Returns all the pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching pluviometros
	 */
	public static List<Pluviometro> findByNomeRubrica(String nomeRubrica) {
		return getPersistence().findByNomeRubrica(nomeRubrica);
	}

	/**
	 * Returns a range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	public static List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end) {

		return getPersistence().findByNomeRubrica(nomeRubrica, start, end);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	public static List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	public static List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public static Pluviometro findByNomeRubrica_First(
			String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByNomeRubrica_First(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public static Pluviometro fetchByNomeRubrica_First(
		String nomeRubrica, OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().fetchByNomeRubrica_First(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public static Pluviometro findByNomeRubrica_Last(
			String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByNomeRubrica_Last(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public static Pluviometro fetchByNomeRubrica_Last(
		String nomeRubrica, OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().fetchByNomeRubrica_Last(
			nomeRubrica, orderByComparator);
	}

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public static Pluviometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByNomeRubrica_PrevAndNext(
			stazioneId, nomeRubrica, orderByComparator);
	}

	/**
	 * Removes all the pluviometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	public static void removeByNomeRubrica(String nomeRubrica) {
		getPersistence().removeByNomeRubrica(nomeRubrica);
	}

	/**
	 * Returns the number of pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching pluviometros
	 */
	public static int countByNomeRubrica(String nomeRubrica) {
		return getPersistence().countByNomeRubrica(nomeRubrica);
	}

	/**
	 * Caches the pluviometro in the entity cache if it is enabled.
	 *
	 * @param pluviometro the pluviometro
	 */
	public static void cacheResult(Pluviometro pluviometro) {
		getPersistence().cacheResult(pluviometro);
	}

	/**
	 * Caches the pluviometros in the entity cache if it is enabled.
	 *
	 * @param pluviometros the pluviometros
	 */
	public static void cacheResult(List<Pluviometro> pluviometros) {
		getPersistence().cacheResult(pluviometros);
	}

	/**
	 * Creates a new pluviometro with the primary key. Does not add the pluviometro to the database.
	 *
	 * @param stazioneId the primary key for the new pluviometro
	 * @return the new pluviometro
	 */
	public static Pluviometro create(String stazioneId) {
		return getPersistence().create(stazioneId);
	}

	/**
	 * Removes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public static Pluviometro remove(String stazioneId)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().remove(stazioneId);
	}

	public static Pluviometro updateImpl(Pluviometro pluviometro) {
		return getPersistence().updateImpl(pluviometro);
	}

	/**
	 * Returns the pluviometro with the primary key or throws a <code>NoSuchPluviometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public static Pluviometro findByPrimaryKey(String stazioneId)
		throws it.eng.bollettino.exception.NoSuchPluviometroException {

		return getPersistence().findByPrimaryKey(stazioneId);
	}

	/**
	 * Returns the pluviometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro, or <code>null</code> if a pluviometro with the primary key could not be found
	 */
	public static Pluviometro fetchByPrimaryKey(String stazioneId) {
		return getPersistence().fetchByPrimaryKey(stazioneId);
	}

	/**
	 * Returns all the pluviometros.
	 *
	 * @return the pluviometros
	 */
	public static List<Pluviometro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of pluviometros
	 */
	public static List<Pluviometro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pluviometros
	 */
	public static List<Pluviometro> findAll(
		int start, int end, OrderByComparator<Pluviometro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pluviometros
	 */
	public static List<Pluviometro> findAll(
		int start, int end, OrderByComparator<Pluviometro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the pluviometros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pluviometros.
	 *
	 * @return the number of pluviometros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PluviometroPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PluviometroPersistence, PluviometroPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PluviometroPersistence.class);

		ServiceTracker<PluviometroPersistence, PluviometroPersistence>
			serviceTracker =
				new ServiceTracker
					<PluviometroPersistence, PluviometroPersistence>(
						bundle.getBundleContext(), PluviometroPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}