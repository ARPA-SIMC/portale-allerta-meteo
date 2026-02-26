/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.parer.model.ComponentiInvio;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the componenti invio service. This utility wraps <code>it.eng.parer.service.persistence.impl.ComponentiInvioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see ComponentiInvioPersistence
 * @generated
 */
public class ComponentiInvioUtil {

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
	public static void clearCache(ComponentiInvio componentiInvio) {
		getPersistence().clearCache(componentiInvio);
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
	public static Map<Serializable, ComponentiInvio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ComponentiInvio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ComponentiInvio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ComponentiInvio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ComponentiInvio update(ComponentiInvio componentiInvio) {
		return getPersistence().update(componentiInvio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ComponentiInvio update(
		ComponentiInvio componentiInvio, ServiceContext serviceContext) {

		return getPersistence().update(componentiInvio, serviceContext);
	}

	/**
	 * Returns all the componenti invios where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the matching componenti invios
	 */
	public static List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO) {

		return getPersistence().findByComponentiByIdInvio(ID_INVIO);
	}

	/**
	 * Returns a range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of matching componenti invios
	 */
	public static List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end) {

		return getPersistence().findByComponentiByIdInvio(ID_INVIO, start, end);
	}

	/**
	 * Returns an ordered range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching componenti invios
	 */
	public static List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator) {

		return getPersistence().findByComponentiByIdInvio(
			ID_INVIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching componenti invios
	 */
	public static List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByComponentiByIdInvio(
			ID_INVIO, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching componenti invio
	 * @throws NoSuchComponentiInvioException if a matching componenti invio could not be found
	 */
	public static ComponentiInvio findByComponentiByIdInvio_First(
			long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator)
		throws it.eng.parer.exception.NoSuchComponentiInvioException {

		return getPersistence().findByComponentiByIdInvio_First(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the first componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching componenti invio, or <code>null</code> if a matching componenti invio could not be found
	 */
	public static ComponentiInvio fetchByComponentiByIdInvio_First(
		long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator) {

		return getPersistence().fetchByComponentiByIdInvio_First(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the last componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching componenti invio
	 * @throws NoSuchComponentiInvioException if a matching componenti invio could not be found
	 */
	public static ComponentiInvio findByComponentiByIdInvio_Last(
			long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator)
		throws it.eng.parer.exception.NoSuchComponentiInvioException {

		return getPersistence().findByComponentiByIdInvio_Last(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the last componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching componenti invio, or <code>null</code> if a matching componenti invio could not be found
	 */
	public static ComponentiInvio fetchByComponentiByIdInvio_Last(
		long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator) {

		return getPersistence().fetchByComponentiByIdInvio_Last(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the componenti invios before and after the current componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param componentiInvioPK the primary key of the current componenti invio
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	public static ComponentiInvio[] findByComponentiByIdInvio_PrevAndNext(
			ComponentiInvioPK componentiInvioPK, long ID_INVIO,
			OrderByComparator<ComponentiInvio> orderByComparator)
		throws it.eng.parer.exception.NoSuchComponentiInvioException {

		return getPersistence().findByComponentiByIdInvio_PrevAndNext(
			componentiInvioPK, ID_INVIO, orderByComparator);
	}

	/**
	 * Removes all the componenti invios where ID_INVIO = &#63; from the database.
	 *
	 * @param ID_INVIO the id_invio
	 */
	public static void removeByComponentiByIdInvio(long ID_INVIO) {
		getPersistence().removeByComponentiByIdInvio(ID_INVIO);
	}

	/**
	 * Returns the number of componenti invios where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the number of matching componenti invios
	 */
	public static int countByComponentiByIdInvio(long ID_INVIO) {
		return getPersistence().countByComponentiByIdInvio(ID_INVIO);
	}

	/**
	 * Caches the componenti invio in the entity cache if it is enabled.
	 *
	 * @param componentiInvio the componenti invio
	 */
	public static void cacheResult(ComponentiInvio componentiInvio) {
		getPersistence().cacheResult(componentiInvio);
	}

	/**
	 * Caches the componenti invios in the entity cache if it is enabled.
	 *
	 * @param componentiInvios the componenti invios
	 */
	public static void cacheResult(List<ComponentiInvio> componentiInvios) {
		getPersistence().cacheResult(componentiInvios);
	}

	/**
	 * Creates a new componenti invio with the primary key. Does not add the componenti invio to the database.
	 *
	 * @param componentiInvioPK the primary key for the new componenti invio
	 * @return the new componenti invio
	 */
	public static ComponentiInvio create(ComponentiInvioPK componentiInvioPK) {
		return getPersistence().create(componentiInvioPK);
	}

	/**
	 * Removes the componenti invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio that was removed
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	public static ComponentiInvio remove(ComponentiInvioPK componentiInvioPK)
		throws it.eng.parer.exception.NoSuchComponentiInvioException {

		return getPersistence().remove(componentiInvioPK);
	}

	public static ComponentiInvio updateImpl(ComponentiInvio componentiInvio) {
		return getPersistence().updateImpl(componentiInvio);
	}

	/**
	 * Returns the componenti invio with the primary key or throws a <code>NoSuchComponentiInvioException</code> if it could not be found.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	public static ComponentiInvio findByPrimaryKey(
			ComponentiInvioPK componentiInvioPK)
		throws it.eng.parer.exception.NoSuchComponentiInvioException {

		return getPersistence().findByPrimaryKey(componentiInvioPK);
	}

	/**
	 * Returns the componenti invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio, or <code>null</code> if a componenti invio with the primary key could not be found
	 */
	public static ComponentiInvio fetchByPrimaryKey(
		ComponentiInvioPK componentiInvioPK) {

		return getPersistence().fetchByPrimaryKey(componentiInvioPK);
	}

	/**
	 * Returns all the componenti invios.
	 *
	 * @return the componenti invios
	 */
	public static List<ComponentiInvio> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of componenti invios
	 */
	public static List<ComponentiInvio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of componenti invios
	 */
	public static List<ComponentiInvio> findAll(
		int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of componenti invios
	 */
	public static List<ComponentiInvio> findAll(
		int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the componenti invios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of componenti invios.
	 *
	 * @return the number of componenti invios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ComponentiInvioPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ComponentiInvioPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ComponentiInvioPersistence _persistence;

}