/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaGruppoGruppi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rubrica gruppo gruppi service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaGruppoGruppiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiPersistence
 * @generated
 */
public class RubricaGruppoGruppiUtil {

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
	public static void clearCache(RubricaGruppoGruppi rubricaGruppoGruppi) {
		getPersistence().clearCache(rubricaGruppoGruppi);
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
	public static Map<Serializable, RubricaGruppoGruppi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaGruppoGruppi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaGruppoGruppi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaGruppoGruppi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaGruppoGruppi update(
		RubricaGruppoGruppi rubricaGruppoGruppi) {

		return getPersistence().update(rubricaGruppoGruppi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaGruppoGruppi update(
		RubricaGruppoGruppi rubricaGruppoGruppi,
		ServiceContext serviceContext) {

		return getPersistence().update(rubricaGruppoGruppi, serviceContext);
	}

	/**
	 * Returns all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @return the matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE) {

		return getPersistence().findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end) {

		return getPersistence().findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi findByRubricaGruppoGruppoByPadre_First(
			long FK_GRUPPO_PADRE,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByRubricaGruppoGruppoByPadre_First(
			FK_GRUPPO_PADRE, orderByComparator);
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi fetchByRubricaGruppoGruppoByPadre_First(
		long FK_GRUPPO_PADRE,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoGruppoByPadre_First(
			FK_GRUPPO_PADRE, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi findByRubricaGruppoGruppoByPadre_Last(
			long FK_GRUPPO_PADRE,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByRubricaGruppoGruppoByPadre_Last(
			FK_GRUPPO_PADRE, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi fetchByRubricaGruppoGruppoByPadre_Last(
		long FK_GRUPPO_PADRE,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoGruppoByPadre_Last(
			FK_GRUPPO_PADRE, orderByComparator);
	}

	/**
	 * Returns the rubrica gruppo gruppis before and after the current rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the current rubrica gruppo gruppi
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static RubricaGruppoGruppi[]
			findByRubricaGruppoGruppoByPadre_PrevAndNext(
				RubricaGruppoGruppiPK rubricaGruppoGruppiPK,
				long FK_GRUPPO_PADRE,
				OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByRubricaGruppoGruppoByPadre_PrevAndNext(
			rubricaGruppoGruppiPK, FK_GRUPPO_PADRE, orderByComparator);
	}

	/**
	 * Removes all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63; from the database.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 */
	public static void removeByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE) {

		getPersistence().removeByRubricaGruppoGruppoByPadre(FK_GRUPPO_PADRE);
	}

	/**
	 * Returns the number of rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @return the number of matching rubrica gruppo gruppis
	 */
	public static int countByRubricaGruppoGruppoByPadre(long FK_GRUPPO_PADRE) {
		return getPersistence().countByRubricaGruppoGruppoByPadre(
			FK_GRUPPO_PADRE);
	}

	/**
	 * Returns all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @return the matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO) {

		return getPersistence().findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO, int start, int end) {

		return getPersistence().findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO, int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi findByRubricaGruppoGruppoByFiglio_First(
			long FK_GRUPPO_FIGLIO,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByRubricaGruppoGruppoByFiglio_First(
			FK_GRUPPO_FIGLIO, orderByComparator);
	}

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi fetchByRubricaGruppoGruppoByFiglio_First(
		long FK_GRUPPO_FIGLIO,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoGruppoByFiglio_First(
			FK_GRUPPO_FIGLIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi findByRubricaGruppoGruppoByFiglio_Last(
			long FK_GRUPPO_FIGLIO,
			OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByRubricaGruppoGruppoByFiglio_Last(
			FK_GRUPPO_FIGLIO, orderByComparator);
	}

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public static RubricaGruppoGruppi fetchByRubricaGruppoGruppoByFiglio_Last(
		long FK_GRUPPO_FIGLIO,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().fetchByRubricaGruppoGruppoByFiglio_Last(
			FK_GRUPPO_FIGLIO, orderByComparator);
	}

	/**
	 * Returns the rubrica gruppo gruppis before and after the current rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the current rubrica gruppo gruppi
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static RubricaGruppoGruppi[]
			findByRubricaGruppoGruppoByFiglio_PrevAndNext(
				RubricaGruppoGruppiPK rubricaGruppoGruppiPK,
				long FK_GRUPPO_FIGLIO,
				OrderByComparator<RubricaGruppoGruppi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByRubricaGruppoGruppoByFiglio_PrevAndNext(
			rubricaGruppoGruppiPK, FK_GRUPPO_FIGLIO, orderByComparator);
	}

	/**
	 * Removes all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63; from the database.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 */
	public static void removeByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO) {

		getPersistence().removeByRubricaGruppoGruppoByFiglio(FK_GRUPPO_FIGLIO);
	}

	/**
	 * Returns the number of rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @return the number of matching rubrica gruppo gruppis
	 */
	public static int countByRubricaGruppoGruppoByFiglio(
		long FK_GRUPPO_FIGLIO) {

		return getPersistence().countByRubricaGruppoGruppoByFiglio(
			FK_GRUPPO_FIGLIO);
	}

	/**
	 * Caches the rubrica gruppo gruppi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 */
	public static void cacheResult(RubricaGruppoGruppi rubricaGruppoGruppi) {
		getPersistence().cacheResult(rubricaGruppoGruppi);
	}

	/**
	 * Caches the rubrica gruppo gruppis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoGruppis the rubrica gruppo gruppis
	 */
	public static void cacheResult(
		List<RubricaGruppoGruppi> rubricaGruppoGruppis) {

		getPersistence().cacheResult(rubricaGruppoGruppis);
	}

	/**
	 * Creates a new rubrica gruppo gruppi with the primary key. Does not add the rubrica gruppo gruppi to the database.
	 *
	 * @param rubricaGruppoGruppiPK the primary key for the new rubrica gruppo gruppi
	 * @return the new rubrica gruppo gruppi
	 */
	public static RubricaGruppoGruppi create(
		RubricaGruppoGruppiPK rubricaGruppoGruppiPK) {

		return getPersistence().create(rubricaGruppoGruppiPK);
	}

	/**
	 * Removes the rubrica gruppo gruppi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static RubricaGruppoGruppi remove(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().remove(rubricaGruppoGruppiPK);
	}

	public static RubricaGruppoGruppi updateImpl(
		RubricaGruppoGruppi rubricaGruppoGruppi) {

		return getPersistence().updateImpl(rubricaGruppoGruppi);
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or throws a <code>NoSuchRubricaGruppoGruppiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static RubricaGruppoGruppi findByPrimaryKey(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException {

		return getPersistence().findByPrimaryKey(rubricaGruppoGruppiPK);
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi, or <code>null</code> if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static RubricaGruppoGruppi fetchByPrimaryKey(
		RubricaGruppoGruppiPK rubricaGruppoGruppiPK) {

		return getPersistence().fetchByPrimaryKey(rubricaGruppoGruppiPK);
	}

	/**
	 * Returns all the rubrica gruppo gruppis.
	 *
	 * @return the rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica gruppo gruppis
	 */
	public static List<RubricaGruppoGruppi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoGruppi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rubrica gruppo gruppis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica gruppo gruppis.
	 *
	 * @return the number of rubrica gruppo gruppis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static RubricaGruppoGruppiPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		RubricaGruppoGruppiPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile RubricaGruppoGruppiPersistence _persistence;

}