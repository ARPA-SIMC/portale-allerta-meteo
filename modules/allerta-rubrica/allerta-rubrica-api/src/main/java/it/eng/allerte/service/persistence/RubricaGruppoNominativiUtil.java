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

import it.eng.allerte.model.RubricaGruppoNominativi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica gruppo nominativi service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaGruppoNominativiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiPersistence
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiUtil {

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
	public static void clearCache(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		getPersistence().clearCache(rubricaGruppoNominativi);
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
	public static Map<Serializable, RubricaGruppoNominativi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaGruppoNominativi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaGruppoNominativi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaGruppoNominativi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaGruppoNominativi update(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		return getPersistence().update(rubricaGruppoNominativi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaGruppoNominativi update(
		RubricaGruppoNominativi rubricaGruppoNominativi,
		ServiceContext serviceContext) {

		return getPersistence().update(rubricaGruppoNominativi, serviceContext);
	}

	/**
	 * Returns all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO) {

		return getPersistence().findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(
			long FK_NOMINATIVO, int start, int end) {

		return getPersistence().findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(
			long FK_NOMINATIVO, int start, int end,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(
			long FK_NOMINATIVO, int start, int end,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator,
			boolean retrieveFromCache) {

		return getPersistence().findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
			findByRubricaGruppoRuoloByNominativo_First(
				long FK_NOMINATIVO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().findByRubricaGruppoRuoloByNominativo_First(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
		fetchByRubricaGruppoRuoloByNominativo_First(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoRuoloByNominativo_First(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
			findByRubricaGruppoRuoloByNominativo_Last(
				long FK_NOMINATIVO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().findByRubricaGruppoRuoloByNominativo_Last(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
		fetchByRubricaGruppoRuoloByNominativo_Last(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoRuoloByNominativo_Last(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public static RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByNominativo_PrevAndNext(
				it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
					rubricaGruppoNominativiPK,
				long FK_NOMINATIVO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().
			findByRubricaGruppoRuoloByNominativo_PrevAndNext(
				rubricaGruppoNominativiPK, FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Removes all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	public static void removeByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO) {

		getPersistence().removeByRubricaGruppoRuoloByNominativo(FK_NOMINATIVO);
	}

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	public static int countByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO) {

		return getPersistence().countByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO);
	}

	/**
	 * Returns all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {

		return getPersistence().findByRubricaGruppoRuoloByGruppo(FK_GRUPPO);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(long FK_GRUPPO, int start, int end) {

		return getPersistence().findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(
			long FK_GRUPPO, int start, int end,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(
			long FK_GRUPPO, int start, int end,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator,
			boolean retrieveFromCache) {

		return getPersistence().findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
			findByRubricaGruppoRuoloByGruppo_First(
				long FK_GRUPPO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().findByRubricaGruppoRuoloByGruppo_First(
			FK_GRUPPO, orderByComparator);
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
		fetchByRubricaGruppoRuoloByGruppo_First(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoRuoloByGruppo_First(
			FK_GRUPPO, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_Last(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().findByRubricaGruppoRuoloByGruppo_Last(
			FK_GRUPPO, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public static RubricaGruppoNominativi
		fetchByRubricaGruppoRuoloByGruppo_Last(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoRuoloByGruppo_Last(
			FK_GRUPPO, orderByComparator);
	}

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public static RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByGruppo_PrevAndNext(
				it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
					rubricaGruppoNominativiPK,
				long FK_GRUPPO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().findByRubricaGruppoRuoloByGruppo_PrevAndNext(
			rubricaGruppoNominativiPK, FK_GRUPPO, orderByComparator);
	}

	/**
	 * Removes all the rubrica gruppo nominativis where FK_GRUPPO = &#63; from the database.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 */
	public static void removeByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {
		getPersistence().removeByRubricaGruppoRuoloByGruppo(FK_GRUPPO);
	}

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	public static int countByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {
		return getPersistence().countByRubricaGruppoRuoloByGruppo(FK_GRUPPO);
	}

	/**
	 * Caches the rubrica gruppo nominativi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 */
	public static void cacheResult(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		getPersistence().cacheResult(rubricaGruppoNominativi);
	}

	/**
	 * Caches the rubrica gruppo nominativis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativis the rubrica gruppo nominativis
	 */
	public static void cacheResult(
		List<RubricaGruppoNominativi> rubricaGruppoNominativis) {

		getPersistence().cacheResult(rubricaGruppoNominativis);
	}

	/**
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	public static RubricaGruppoNominativi create(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			rubricaGruppoNominativiPK) {

		return getPersistence().create(rubricaGruppoNominativiPK);
	}

	/**
	 * Removes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public static RubricaGruppoNominativi remove(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().remove(rubricaGruppoNominativiPK);
	}

	public static RubricaGruppoNominativi updateImpl(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		return getPersistence().updateImpl(rubricaGruppoNominativi);
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or throws a <code>NoSuchRubricaGruppoNominativiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public static RubricaGruppoNominativi findByPrimaryKey(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException {

		return getPersistence().findByPrimaryKey(rubricaGruppoNominativiPK);
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi, or <code>null</code> if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public static RubricaGruppoNominativi fetchByPrimaryKey(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			rubricaGruppoNominativiPK) {

		return getPersistence().fetchByPrimaryKey(rubricaGruppoNominativiPK);
	}

	/**
	 * Returns all the rubrica gruppo nominativis.
	 *
	 * @return the rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	public static List<RubricaGruppoNominativi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica gruppo nominativis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static RubricaGruppoNominativiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaGruppoNominativiPersistence, RubricaGruppoNominativiPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaGruppoNominativiPersistence.class);

		ServiceTracker
			<RubricaGruppoNominativiPersistence,
			 RubricaGruppoNominativiPersistence> serviceTracker =
				new ServiceTracker
					<RubricaGruppoNominativiPersistence,
					 RubricaGruppoNominativiPersistence>(
						 bundle.getBundleContext(),
						 RubricaGruppoNominativiPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}