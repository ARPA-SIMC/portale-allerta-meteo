/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerta.messages.services.model.Parametro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the parametro service. This utility wraps <code>it.eng.allerta.messages.services.service.persistence.impl.ParametroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see ParametroPersistence
 * @generated
 */
public class ParametroUtil {

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
	public static void clearCache(Parametro parametro) {
		getPersistence().clearCache(parametro);
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
	public static Map<Serializable, Parametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Parametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Parametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Parametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Parametro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Parametro update(Parametro parametro) {
		return getPersistence().update(parametro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Parametro update(
		Parametro parametro, ServiceContext serviceContext) {

		return getPersistence().update(parametro, serviceContext);
	}

	/**
	 * Returns all the parametros where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @return the matching parametros
	 */
	public static List<Parametro> findBynodo(String nodo) {
		return getPersistence().findBynodo(nodo);
	}

	/**
	 * Returns a range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of matching parametros
	 */
	public static List<Parametro> findBynodo(String nodo, int start, int end) {
		return getPersistence().findBynodo(nodo, start, end);
	}

	/**
	 * Returns an ordered range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parametros
	 */
	public static List<Parametro> findBynodo(
		String nodo, int start, int end,
		OrderByComparator<Parametro> orderByComparator) {

		return getPersistence().findBynodo(nodo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parametros
	 */
	public static List<Parametro> findBynodo(
		String nodo, int start, int end,
		OrderByComparator<Parametro> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBynodo(
			nodo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parametro
	 * @throws NoSuchParametroException if a matching parametro could not be found
	 */
	public static Parametro findBynodo_First(
			String nodo, OrderByComparator<Parametro> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchParametroException {

		return getPersistence().findBynodo_First(nodo, orderByComparator);
	}

	/**
	 * Returns the first parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parametro, or <code>null</code> if a matching parametro could not be found
	 */
	public static Parametro fetchBynodo_First(
		String nodo, OrderByComparator<Parametro> orderByComparator) {

		return getPersistence().fetchBynodo_First(nodo, orderByComparator);
	}

	/**
	 * Returns the last parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parametro
	 * @throws NoSuchParametroException if a matching parametro could not be found
	 */
	public static Parametro findBynodo_Last(
			String nodo, OrderByComparator<Parametro> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchParametroException {

		return getPersistence().findBynodo_Last(nodo, orderByComparator);
	}

	/**
	 * Returns the last parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parametro, or <code>null</code> if a matching parametro could not be found
	 */
	public static Parametro fetchBynodo_Last(
		String nodo, OrderByComparator<Parametro> orderByComparator) {

		return getPersistence().fetchBynodo_Last(nodo, orderByComparator);
	}

	/**
	 * Returns the parametros before and after the current parametro in the ordered set where nodo = &#63;.
	 *
	 * @param Id the primary key of the current parametro
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	public static Parametro[] findBynodo_PrevAndNext(
			long Id, String nodo,
			OrderByComparator<Parametro> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchParametroException {

		return getPersistence().findBynodo_PrevAndNext(
			Id, nodo, orderByComparator);
	}

	/**
	 * Removes all the parametros where nodo = &#63; from the database.
	 *
	 * @param nodo the nodo
	 */
	public static void removeBynodo(String nodo) {
		getPersistence().removeBynodo(nodo);
	}

	/**
	 * Returns the number of parametros where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @return the number of matching parametros
	 */
	public static int countBynodo(String nodo) {
		return getPersistence().countBynodo(nodo);
	}

	/**
	 * Caches the parametro in the entity cache if it is enabled.
	 *
	 * @param parametro the parametro
	 */
	public static void cacheResult(Parametro parametro) {
		getPersistence().cacheResult(parametro);
	}

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	public static void cacheResult(List<Parametro> parametros) {
		getPersistence().cacheResult(parametros);
	}

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param Id the primary key for the new parametro
	 * @return the new parametro
	 */
	public static Parametro create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	public static Parametro remove(long Id)
		throws it.eng.allerta.messages.services.exception.
			NoSuchParametroException {

		return getPersistence().remove(Id);
	}

	public static Parametro updateImpl(Parametro parametro) {
		return getPersistence().updateImpl(parametro);
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>NoSuchParametroException</code> if it could not be found.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	public static Parametro findByPrimaryKey(long Id)
		throws it.eng.allerta.messages.services.exception.
			NoSuchParametroException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 */
	public static Parametro fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the parametros.
	 *
	 * @return the parametros
	 */
	public static List<Parametro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 */
	public static List<Parametro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametros
	 */
	public static List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parametros
	 */
	public static List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the parametros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ParametroPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ParametroPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ParametroPersistence _persistence;

}