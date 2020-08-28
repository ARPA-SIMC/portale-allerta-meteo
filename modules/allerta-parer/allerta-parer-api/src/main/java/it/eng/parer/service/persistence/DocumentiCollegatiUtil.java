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

package it.eng.parer.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.parer.model.DocumentiCollegati;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the documenti collegati service. This utility wraps <code>it.eng.parer.service.persistence.impl.DocumentiCollegatiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see DocumentiCollegatiPersistence
 * @generated
 */
@ProviderType
public class DocumentiCollegatiUtil {

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
	public static void clearCache(DocumentiCollegati documentiCollegati) {
		getPersistence().clearCache(documentiCollegati);
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
	public static Map<Serializable, DocumentiCollegati> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentiCollegati> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentiCollegati> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentiCollegati> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentiCollegati update(
		DocumentiCollegati documentiCollegati) {

		return getPersistence().update(documentiCollegati);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentiCollegati update(
		DocumentiCollegati documentiCollegati, ServiceContext serviceContext) {

		return getPersistence().update(documentiCollegati, serviceContext);
	}

	/**
	 * Returns all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the matching documenti collegatis
	 */
	public static List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO) {

		return getPersistence().findByDocumentiCollegatiByIdInvio(ID_INVIO);
	}

	/**
	 * Returns a range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of matching documenti collegatis
	 */
	public static List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end) {

		return getPersistence().findByDocumentiCollegatiByIdInvio(
			ID_INVIO, start, end);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documenti collegatis
	 */
	public static List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return getPersistence().findByDocumentiCollegatiByIdInvio(
			ID_INVIO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching documenti collegatis
	 */
	public static List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumentiCollegatiByIdInvio(
			ID_INVIO, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a matching documenti collegati could not be found
	 */
	public static DocumentiCollegati findByDocumentiCollegatiByIdInvio_First(
			long ID_INVIO,
			OrderByComparator<DocumentiCollegati> orderByComparator)
		throws it.eng.parer.exception.NoSuchDocumentiCollegatiException {

		return getPersistence().findByDocumentiCollegatiByIdInvio_First(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the first documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documenti collegati, or <code>null</code> if a matching documenti collegati could not be found
	 */
	public static DocumentiCollegati fetchByDocumentiCollegatiByIdInvio_First(
		long ID_INVIO,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return getPersistence().fetchByDocumentiCollegatiByIdInvio_First(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the last documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a matching documenti collegati could not be found
	 */
	public static DocumentiCollegati findByDocumentiCollegatiByIdInvio_Last(
			long ID_INVIO,
			OrderByComparator<DocumentiCollegati> orderByComparator)
		throws it.eng.parer.exception.NoSuchDocumentiCollegatiException {

		return getPersistence().findByDocumentiCollegatiByIdInvio_Last(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the last documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documenti collegati, or <code>null</code> if a matching documenti collegati could not be found
	 */
	public static DocumentiCollegati fetchByDocumentiCollegatiByIdInvio_Last(
		long ID_INVIO,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return getPersistence().fetchByDocumentiCollegatiByIdInvio_Last(
			ID_INVIO, orderByComparator);
	}

	/**
	 * Returns the documenti collegatis before and after the current documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param documentiCollegatiPK the primary key of the current documenti collegati
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	public static DocumentiCollegati[]
			findByDocumentiCollegatiByIdInvio_PrevAndNext(
				it.eng.parer.service.persistence.DocumentiCollegatiPK
					documentiCollegatiPK,
				long ID_INVIO,
				OrderByComparator<DocumentiCollegati> orderByComparator)
		throws it.eng.parer.exception.NoSuchDocumentiCollegatiException {

		return getPersistence().findByDocumentiCollegatiByIdInvio_PrevAndNext(
			documentiCollegatiPK, ID_INVIO, orderByComparator);
	}

	/**
	 * Removes all the documenti collegatis where ID_INVIO = &#63; from the database.
	 *
	 * @param ID_INVIO the id_invio
	 */
	public static void removeByDocumentiCollegatiByIdInvio(long ID_INVIO) {
		getPersistence().removeByDocumentiCollegatiByIdInvio(ID_INVIO);
	}

	/**
	 * Returns the number of documenti collegatis where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the number of matching documenti collegatis
	 */
	public static int countByDocumentiCollegatiByIdInvio(long ID_INVIO) {
		return getPersistence().countByDocumentiCollegatiByIdInvio(ID_INVIO);
	}

	/**
	 * Caches the documenti collegati in the entity cache if it is enabled.
	 *
	 * @param documentiCollegati the documenti collegati
	 */
	public static void cacheResult(DocumentiCollegati documentiCollegati) {
		getPersistence().cacheResult(documentiCollegati);
	}

	/**
	 * Caches the documenti collegatis in the entity cache if it is enabled.
	 *
	 * @param documentiCollegatis the documenti collegatis
	 */
	public static void cacheResult(
		List<DocumentiCollegati> documentiCollegatis) {

		getPersistence().cacheResult(documentiCollegatis);
	}

	/**
	 * Creates a new documenti collegati with the primary key. Does not add the documenti collegati to the database.
	 *
	 * @param documentiCollegatiPK the primary key for the new documenti collegati
	 * @return the new documenti collegati
	 */
	public static DocumentiCollegati create(
		it.eng.parer.service.persistence.DocumentiCollegatiPK
			documentiCollegatiPK) {

		return getPersistence().create(documentiCollegatiPK);
	}

	/**
	 * Removes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	public static DocumentiCollegati remove(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws it.eng.parer.exception.NoSuchDocumentiCollegatiException {

		return getPersistence().remove(documentiCollegatiPK);
	}

	public static DocumentiCollegati updateImpl(
		DocumentiCollegati documentiCollegati) {

		return getPersistence().updateImpl(documentiCollegati);
	}

	/**
	 * Returns the documenti collegati with the primary key or throws a <code>NoSuchDocumentiCollegatiException</code> if it could not be found.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	public static DocumentiCollegati findByPrimaryKey(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws it.eng.parer.exception.NoSuchDocumentiCollegatiException {

		return getPersistence().findByPrimaryKey(documentiCollegatiPK);
	}

	/**
	 * Returns the documenti collegati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati, or <code>null</code> if a documenti collegati with the primary key could not be found
	 */
	public static DocumentiCollegati fetchByPrimaryKey(
		it.eng.parer.service.persistence.DocumentiCollegatiPK
			documentiCollegatiPK) {

		return getPersistence().fetchByPrimaryKey(documentiCollegatiPK);
	}

	/**
	 * Returns all the documenti collegatis.
	 *
	 * @return the documenti collegatis
	 */
	public static List<DocumentiCollegati> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of documenti collegatis
	 */
	public static List<DocumentiCollegati> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documenti collegatis
	 */
	public static List<DocumentiCollegati> findAll(
		int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of documenti collegatis
	 */
	public static List<DocumentiCollegati> findAll(
		int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the documenti collegatis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of documenti collegatis.
	 *
	 * @return the number of documenti collegatis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static DocumentiCollegatiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DocumentiCollegatiPersistence, DocumentiCollegatiPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DocumentiCollegatiPersistence.class);

		ServiceTracker
			<DocumentiCollegatiPersistence, DocumentiCollegatiPersistence>
				serviceTracker =
					new ServiceTracker
						<DocumentiCollegatiPersistence,
						 DocumentiCollegatiPersistence>(
							 bundle.getBundleContext(),
							 DocumentiCollegatiPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}