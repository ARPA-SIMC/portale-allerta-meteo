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

import it.eng.allerte.model.RubricaLog;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica log service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaLogPersistence
 * @generated
 */
@ProviderType
public class RubricaLogUtil {

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
	public static void clearCache(RubricaLog rubricaLog) {
		getPersistence().clearCache(rubricaLog);
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
	public static Map<Serializable, RubricaLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaLog update(RubricaLog rubricaLog) {
		return getPersistence().update(rubricaLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaLog update(
		RubricaLog rubricaLog, ServiceContext serviceContext) {

		return getPersistence().update(rubricaLog, serviceContext);
	}

	/**
	 * Returns all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA) {

		return getPersistence().findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns a range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return getPersistence().findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogUtenteModifica_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogUtenteModifica_First(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the first rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogUtenteModifica_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogUtenteModifica_First(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogUtenteModifica_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogUtenteModifica_Last(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogUtenteModifica_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogUtenteModifica_Last(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog[] findByRubricaLogUtenteModifica_PrevAndNext(
			long ID_LOG, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogUtenteModifica_PrevAndNext(
			ID_LOG, FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Removes all the rubrica logs where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	public static void removeByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA) {

		getPersistence().removeByRubricaLogUtenteModifica(FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns the number of rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica logs
	 */
	public static int countByRubricaLogUtenteModifica(long FK_UTENTE_MODIFICA) {
		return getPersistence().countByRubricaLogUtenteModifica(
			FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO) {

		return getPersistence().findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns a range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end) {

		return getPersistence().findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogDataModifica_First(
			Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogDataModifica_First(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the first rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogDataModifica_First(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogDataModifica_First(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogDataModifica_Last(
			Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogDataModifica_Last(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogDataModifica_Last(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogDataModifica_Last(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog[] findByRubricaLogDataModifica_PrevAndNext(
			long ID_LOG, Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogDataModifica_PrevAndNext(
			ID_LOG, DATA_MODIFICA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Removes all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public static void removeByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO) {

		getPersistence().removeByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public static int countByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByRubricaLogDataModifica(
			DATA_MODIFICA, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO) {

		return getPersistence().findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns a range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end) {

		return getPersistence().findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogTabella_First(
			String TABELLA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogTabella_First(
			TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the first rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogTabella_First(
		String TABELLA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogTabella_First(
			TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogTabella_Last(
			String TABELLA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogTabella_Last(
			TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogTabella_Last(
		String TABELLA, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogTabella_Last(
			TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog[] findByRubricaLogTabella_PrevAndNext(
			long ID_LOG, String TABELLA, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogTabella_PrevAndNext(
			ID_LOG, TABELLA, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Removes all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public static void removeByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO) {

		getPersistence().removeByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public static int countByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByRubricaLogTabella(
			TABELLA, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO) {

		return getPersistence().findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns a range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end) {

		return getPersistence().findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogIdOggetto_First(
			String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogIdOggetto_First(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the first rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogIdOggetto_First(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogIdOggetto_First(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogIdOggetto_Last(
			String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogIdOggetto_Last(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogIdOggetto_Last(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogIdOggetto_Last(
			ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog[] findByRubricaLogIdOggetto_PrevAndNext(
			long ID_LOG, String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogIdOggetto_PrevAndNext(
			ID_LOG, ID_OGGETTO, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Removes all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public static void removeByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO) {

		getPersistence().removeByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public static int countByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByRubricaLogIdOggetto(
			ID_OGGETTO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO) {

		return getPersistence().findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns a range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end) {

		return getPersistence().findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public static List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogBySitoProprietario_First(
			long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogBySitoProprietario_First(
			FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the first rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogBySitoProprietario_First(
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogBySitoProprietario_First(
			FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public static RubricaLog findByRubricaLogBySitoProprietario_Last(
			long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogBySitoProprietario_Last(
			FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public static RubricaLog fetchByRubricaLogBySitoProprietario_Last(
		long FK_SITO_PROPRIETARIO,
		OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().fetchByRubricaLogBySitoProprietario_Last(
			FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog[] findByRubricaLogBySitoProprietario_PrevAndNext(
			long ID_LOG, long FK_SITO_PROPRIETARIO,
			OrderByComparator<RubricaLog> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByRubricaLogBySitoProprietario_PrevAndNext(
			ID_LOG, FK_SITO_PROPRIETARIO, orderByComparator);
	}

	/**
	 * Removes all the rubrica logs where FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public static void removeByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO) {

		getPersistence().removeByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public static int countByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByRubricaLogBySitoProprietario(
			FK_SITO_PROPRIETARIO);
	}

	/**
	 * Caches the rubrica log in the entity cache if it is enabled.
	 *
	 * @param rubricaLog the rubrica log
	 */
	public static void cacheResult(RubricaLog rubricaLog) {
		getPersistence().cacheResult(rubricaLog);
	}

	/**
	 * Caches the rubrica logs in the entity cache if it is enabled.
	 *
	 * @param rubricaLogs the rubrica logs
	 */
	public static void cacheResult(List<RubricaLog> rubricaLogs) {
		getPersistence().cacheResult(rubricaLogs);
	}

	/**
	 * Creates a new rubrica log with the primary key. Does not add the rubrica log to the database.
	 *
	 * @param ID_LOG the primary key for the new rubrica log
	 * @return the new rubrica log
	 */
	public static RubricaLog create(long ID_LOG) {
		return getPersistence().create(ID_LOG);
	}

	/**
	 * Removes the rubrica log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log that was removed
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog remove(long ID_LOG)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().remove(ID_LOG);
	}

	public static RubricaLog updateImpl(RubricaLog rubricaLog) {
		return getPersistence().updateImpl(rubricaLog);
	}

	/**
	 * Returns the rubrica log with the primary key or throws a <code>NoSuchRubricaLogException</code> if it could not be found.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog findByPrimaryKey(long ID_LOG)
		throws it.eng.allerte.exception.NoSuchRubricaLogException {

		return getPersistence().findByPrimaryKey(ID_LOG);
	}

	/**
	 * Returns the rubrica log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log, or <code>null</code> if a rubrica log with the primary key could not be found
	 */
	public static RubricaLog fetchByPrimaryKey(long ID_LOG) {
		return getPersistence().fetchByPrimaryKey(ID_LOG);
	}

	/**
	 * Returns all the rubrica logs.
	 *
	 * @return the rubrica logs
	 */
	public static List<RubricaLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of rubrica logs
	 */
	public static List<RubricaLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica logs
	 */
	public static List<RubricaLog> findAll(
		int start, int end, OrderByComparator<RubricaLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica logs
	 */
	public static List<RubricaLog> findAll(
		int start, int end, OrderByComparator<RubricaLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica logs.
	 *
	 * @return the number of rubrica logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RubricaLogPersistence, RubricaLogPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaLogPersistence.class);

		ServiceTracker<RubricaLogPersistence, RubricaLogPersistence>
			serviceTracker =
				new ServiceTracker
					<RubricaLogPersistence, RubricaLogPersistence>(
						bundle.getBundleContext(), RubricaLogPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}