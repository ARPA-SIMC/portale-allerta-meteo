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

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaNominativo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica nominativo service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaNominativoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaNominativoPersistence
 * @generated
 */
@ProviderType
public class RubricaNominativoUtil {

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
	public static void clearCache(RubricaNominativo rubricaNominativo) {
		getPersistence().clearCache(rubricaNominativo);
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
	public static Map<Serializable, RubricaNominativo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaNominativo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaNominativo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaNominativo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaNominativo update(
		RubricaNominativo rubricaNominativo) {

		return getPersistence().update(rubricaNominativo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaNominativo update(
		RubricaNominativo rubricaNominativo, ServiceContext serviceContext) {

		return getPersistence().update(rubricaNominativo, serviceContext);
	}

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaNominativoException</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByNominativoPerSitoProprietario(
			long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByNominativoPerSitoProprietario(
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO) {

		return getPersistence().fetchByNominativoPerSitoProprietario(
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO,
		boolean retrieveFromCache) {

		return getPersistence().fetchByNominativoPerSitoProprietario(
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO, retrieveFromCache);
	}

	/**
	 * Removes the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica nominativo that was removed
	 */
	public static RubricaNominativo removeByNominativoPerSitoProprietario(
			long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().removeByNominativoPerSitoProprietario(
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica nominativos where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica nominativos
	 */
	public static int countByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByNominativoPerSitoProprietario(
			ID_NOMINATIVO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @return the matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE) {

		return getPersistence().findByUtentePortale(FK_UTENTE_PORTALE);
	}

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end) {

		return getPersistence().findByUtentePortale(
			FK_UTENTE_PORTALE, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().findByUtentePortale(
			FK_UTENTE_PORTALE, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUtentePortale(
			FK_UTENTE_PORTALE, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByUtentePortale_First(
			long FK_UTENTE_PORTALE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtentePortale_First(
			FK_UTENTE_PORTALE, orderByComparator);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByUtentePortale_First(
		long FK_UTENTE_PORTALE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByUtentePortale_First(
			FK_UTENTE_PORTALE, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByUtentePortale_Last(
			long FK_UTENTE_PORTALE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtentePortale_Last(
			FK_UTENTE_PORTALE, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByUtentePortale_Last(
		long FK_UTENTE_PORTALE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByUtentePortale_Last(
			FK_UTENTE_PORTALE, orderByComparator);
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo[] findByUtentePortale_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_PORTALE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtentePortale_PrevAndNext(
			ID_NOMINATIVO, FK_UTENTE_PORTALE, orderByComparator);
	}

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_PORTALE = &#63; from the database.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 */
	public static void removeByUtentePortale(long FK_UTENTE_PORTALE) {
		getPersistence().removeByUtentePortale(FK_UTENTE_PORTALE);
	}

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @return the number of matching rubrica nominativos
	 */
	public static int countByUtentePortale(long FK_UTENTE_PORTALE) {
		return getPersistence().countByUtentePortale(FK_UTENTE_PORTALE);
	}

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE) {

		return getPersistence().findByUtenteCreazione(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end) {

		return getPersistence().findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUtenteCreazione(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByUtenteCreazione_First(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtenteCreazione_First(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByUtenteCreazione_First(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByUtenteCreazione_First(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByUtenteCreazione_Last(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtenteCreazione_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByUtenteCreazione_Last(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByUtenteCreazione_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo[] findByUtenteCreazione_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtenteCreazione_PrevAndNext(
			ID_NOMINATIVO, FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	public static void removeByUtenteCreazione(long FK_UTENTE_CREAZIONE) {
		getPersistence().removeByUtenteCreazione(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica nominativos
	 */
	public static int countByUtenteCreazione(long FK_UTENTE_CREAZIONE) {
		return getPersistence().countByUtenteCreazione(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA) {

		return getPersistence().findByUtenteModifica(FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return getPersistence().findByUtenteModifica(
			FK_UTENTE_MODIFICA, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().findByUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByUtenteModifica_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtenteModifica_First(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByUtenteModifica_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByUtenteModifica_First(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByUtenteModifica_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtenteModifica_Last(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo fetchByUtenteModifica_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByUtenteModifica_Last(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo[] findByUtenteModifica_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByUtenteModifica_PrevAndNext(
			ID_NOMINATIVO, FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	public static void removeByUtenteModifica(long FK_UTENTE_MODIFICA) {
		getPersistence().removeByUtenteModifica(FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica nominativos
	 */
	public static int countByUtenteModifica(long FK_UTENTE_MODIFICA) {
		return getPersistence().countByUtenteModifica(FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativos
	 */
	public static List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO) {

		return getPersistence().findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns a range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
			int end) {

		return getPersistence().findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
			int end, OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public static List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
			int end, OrderByComparator<RubricaNominativo> orderByComparator,
			boolean retrieveFromCache) {

		return getPersistence().findByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo
			findByNominativoPerGruppoByNomeCognome_First(
				String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
				OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByNominativoPerGruppoByNomeCognome_First(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the first rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo
		fetchByNominativoPerGruppoByNomeCognome_First(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByNominativoPerGruppoByNomeCognome_First(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo findByNominativoPerGruppoByNomeCognome_Last(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByNominativoPerGruppoByNomeCognome_Last(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public static RubricaNominativo
		fetchByNominativoPerGruppoByNomeCognome_Last(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().fetchByNominativoPerGruppoByNomeCognome_Last(
			COGNOME, NOME, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo[]
			findByNominativoPerGruppoByNomeCognome_PrevAndNext(
				long ID_NOMINATIVO, String COGNOME, String NOME,
				long FK_SITO_PROPRIETARIO,
				OrderByComparator<RubricaNominativo> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().
			findByNominativoPerGruppoByNomeCognome_PrevAndNext(
				ID_NOMINATIVO, COGNOME, NOME, FK_SITO_PROPRIETARIO,
				orderByComparator);
	}

	/**
	 * Removes all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public static void removeByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO) {

		getPersistence().removeByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica nominativos
	 */
	public static int countByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByNominativoPerGruppoByNomeCognome(
			COGNOME, NOME, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Caches the rubrica nominativo in the entity cache if it is enabled.
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 */
	public static void cacheResult(RubricaNominativo rubricaNominativo) {
		getPersistence().cacheResult(rubricaNominativo);
	}

	/**
	 * Caches the rubrica nominativos in the entity cache if it is enabled.
	 *
	 * @param rubricaNominativos the rubrica nominativos
	 */
	public static void cacheResult(List<RubricaNominativo> rubricaNominativos) {
		getPersistence().cacheResult(rubricaNominativos);
	}

	/**
	 * Creates a new rubrica nominativo with the primary key. Does not add the rubrica nominativo to the database.
	 *
	 * @param ID_NOMINATIVO the primary key for the new rubrica nominativo
	 * @return the new rubrica nominativo
	 */
	public static RubricaNominativo create(long ID_NOMINATIVO) {
		return getPersistence().create(ID_NOMINATIVO);
	}

	/**
	 * Removes the rubrica nominativo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo remove(long ID_NOMINATIVO)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().remove(ID_NOMINATIVO);
	}

	public static RubricaNominativo updateImpl(
		RubricaNominativo rubricaNominativo) {

		return getPersistence().updateImpl(rubricaNominativo);
	}

	/**
	 * Returns the rubrica nominativo with the primary key or throws a <code>NoSuchRubricaNominativoException</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo findByPrimaryKey(long ID_NOMINATIVO)
		throws it.eng.allerte.exception.NoSuchRubricaNominativoException {

		return getPersistence().findByPrimaryKey(ID_NOMINATIVO);
	}

	/**
	 * Returns the rubrica nominativo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo, or <code>null</code> if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo fetchByPrimaryKey(long ID_NOMINATIVO) {
		return getPersistence().fetchByPrimaryKey(ID_NOMINATIVO);
	}

	/**
	 * Returns all the rubrica nominativos.
	 *
	 * @return the rubrica nominativos
	 */
	public static List<RubricaNominativo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of rubrica nominativos
	 */
	public static List<RubricaNominativo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica nominativos
	 */
	public static List<RubricaNominativo> findAll(
		int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica nominativos
	 */
	public static List<RubricaNominativo> findAll(
		int start, int end,
		OrderByComparator<RubricaNominativo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica nominativos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica nominativos.
	 *
	 * @return the number of rubrica nominativos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaNominativoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaNominativoPersistence, RubricaNominativoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaNominativoPersistence.class);

		ServiceTracker
			<RubricaNominativoPersistence, RubricaNominativoPersistence>
				serviceTracker =
					new ServiceTracker
						<RubricaNominativoPersistence,
						 RubricaNominativoPersistence>(
							 bundle.getBundleContext(),
							 RubricaNominativoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}