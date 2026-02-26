/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaSito;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rubrica sito service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaSitoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaSitoPersistence
 * @generated
 */
public class RubricaSitoUtil {

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
	public static void clearCache(RubricaSito rubricaSito) {
		getPersistence().clearCache(rubricaSito);
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
	public static Map<Serializable, RubricaSito> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaSito> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaSito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaSito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaSito update(RubricaSito rubricaSito) {
		return getPersistence().update(rubricaSito);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaSito update(
		RubricaSito rubricaSito, ServiceContext serviceContext) {

		return getPersistence().update(rubricaSito, serviceContext);
	}

	/**
	 * Returns all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the matching rubrica sitos
	 */
	public static List<RubricaSito> findByLiferaySite(long FK_LIFERAY_SITE) {
		return getPersistence().findByLiferaySite(FK_LIFERAY_SITE);
	}

	/**
	 * Returns a range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of matching rubrica sitos
	 */
	public static List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end) {

		return getPersistence().findByLiferaySite(FK_LIFERAY_SITE, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica sitos
	 */
	public static List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator) {

		return getPersistence().findByLiferaySite(
			FK_LIFERAY_SITE, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica sitos
	 */
	public static List<RubricaSito> findByLiferaySite(
		long FK_LIFERAY_SITE, int start, int end,
		OrderByComparator<RubricaSito> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLiferaySite(
			FK_LIFERAY_SITE, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	public static RubricaSito findByLiferaySite_First(
			long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaSitoException {

		return getPersistence().findByLiferaySite_First(
			FK_LIFERAY_SITE, orderByComparator);
	}

	/**
	 * Returns the first rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	public static RubricaSito fetchByLiferaySite_First(
		long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator) {

		return getPersistence().fetchByLiferaySite_First(
			FK_LIFERAY_SITE, orderByComparator);
	}

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito
	 * @throws NoSuchRubricaSitoException if a matching rubrica sito could not be found
	 */
	public static RubricaSito findByLiferaySite_Last(
			long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaSitoException {

		return getPersistence().findByLiferaySite_Last(
			FK_LIFERAY_SITE, orderByComparator);
	}

	/**
	 * Returns the last rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica sito, or <code>null</code> if a matching rubrica sito could not be found
	 */
	public static RubricaSito fetchByLiferaySite_Last(
		long FK_LIFERAY_SITE,
		OrderByComparator<RubricaSito> orderByComparator) {

		return getPersistence().fetchByLiferaySite_Last(
			FK_LIFERAY_SITE, orderByComparator);
	}

	/**
	 * Returns the rubrica sitos before and after the current rubrica sito in the ordered set where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param ID_SITO the primary key of the current rubrica sito
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	public static RubricaSito[] findByLiferaySite_PrevAndNext(
			long ID_SITO, long FK_LIFERAY_SITE,
			OrderByComparator<RubricaSito> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaSitoException {

		return getPersistence().findByLiferaySite_PrevAndNext(
			ID_SITO, FK_LIFERAY_SITE, orderByComparator);
	}

	/**
	 * Removes all the rubrica sitos where FK_LIFERAY_SITE = &#63; from the database.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 */
	public static void removeByLiferaySite(long FK_LIFERAY_SITE) {
		getPersistence().removeByLiferaySite(FK_LIFERAY_SITE);
	}

	/**
	 * Returns the number of rubrica sitos where FK_LIFERAY_SITE = &#63;.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site
	 * @return the number of matching rubrica sitos
	 */
	public static int countByLiferaySite(long FK_LIFERAY_SITE) {
		return getPersistence().countByLiferaySite(FK_LIFERAY_SITE);
	}

	/**
	 * Caches the rubrica sito in the entity cache if it is enabled.
	 *
	 * @param rubricaSito the rubrica sito
	 */
	public static void cacheResult(RubricaSito rubricaSito) {
		getPersistence().cacheResult(rubricaSito);
	}

	/**
	 * Caches the rubrica sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaSitos the rubrica sitos
	 */
	public static void cacheResult(List<RubricaSito> rubricaSitos) {
		getPersistence().cacheResult(rubricaSitos);
	}

	/**
	 * Creates a new rubrica sito with the primary key. Does not add the rubrica sito to the database.
	 *
	 * @param ID_SITO the primary key for the new rubrica sito
	 * @return the new rubrica sito
	 */
	public static RubricaSito create(long ID_SITO) {
		return getPersistence().create(ID_SITO);
	}

	/**
	 * Removes the rubrica sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito that was removed
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	public static RubricaSito remove(long ID_SITO)
		throws it.eng.allerte.exception.NoSuchRubricaSitoException {

		return getPersistence().remove(ID_SITO);
	}

	public static RubricaSito updateImpl(RubricaSito rubricaSito) {
		return getPersistence().updateImpl(rubricaSito);
	}

	/**
	 * Returns the rubrica sito with the primary key or throws a <code>NoSuchRubricaSitoException</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito
	 * @throws NoSuchRubricaSitoException if a rubrica sito with the primary key could not be found
	 */
	public static RubricaSito findByPrimaryKey(long ID_SITO)
		throws it.eng.allerte.exception.NoSuchRubricaSitoException {

		return getPersistence().findByPrimaryKey(ID_SITO);
	}

	/**
	 * Returns the rubrica sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_SITO the primary key of the rubrica sito
	 * @return the rubrica sito, or <code>null</code> if a rubrica sito with the primary key could not be found
	 */
	public static RubricaSito fetchByPrimaryKey(long ID_SITO) {
		return getPersistence().fetchByPrimaryKey(ID_SITO);
	}

	/**
	 * Returns all the rubrica sitos.
	 *
	 * @return the rubrica sitos
	 */
	public static List<RubricaSito> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @return the range of rubrica sitos
	 */
	public static List<RubricaSito> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica sitos
	 */
	public static List<RubricaSito> findAll(
		int start, int end, OrderByComparator<RubricaSito> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica sitos
	 * @param end the upper bound of the range of rubrica sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica sitos
	 */
	public static List<RubricaSito> findAll(
		int start, int end, OrderByComparator<RubricaSito> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rubrica sitos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica sitos.
	 *
	 * @return the number of rubrica sitos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaSitoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(RubricaSitoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile RubricaSitoPersistence _persistence;

}