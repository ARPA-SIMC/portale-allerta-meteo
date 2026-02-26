/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animazione.image.model.altezzaOndaAdriac;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for altezzaOndaAdriac. This utility wraps
 * <code>it.eng.animazione.image.service.impl.altezzaOndaAdriacLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author UTENTE
 * @see altezzaOndaAdriacLocalService
 * @generated
 */
public class altezzaOndaAdriacLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.animazione.image.service.impl.altezzaOndaAdriacLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the altezza onda adriac to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaAdriacLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was added
	 */
	public static altezzaOndaAdriac addaltezzaOndaAdriac(
		altezzaOndaAdriac altezzaOndaAdriac) {

		return getService().addaltezzaOndaAdriac(altezzaOndaAdriac);
	}

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	public static altezzaOndaAdriac createaltezzaOndaAdriac(long id) {
		return getService().createaltezzaOndaAdriac(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the altezza onda adriac from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaAdriacLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 */
	public static altezzaOndaAdriac deletealtezzaOndaAdriac(
		altezzaOndaAdriac altezzaOndaAdriac) {

		return getService().deletealtezzaOndaAdriac(altezzaOndaAdriac);
	}

	/**
	 * Deletes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaAdriacLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws PortalException if a altezza onda adriac with the primary key could not be found
	 */
	public static altezzaOndaAdriac deletealtezzaOndaAdriac(long id)
		throws PortalException {

		return getService().deletealtezzaOndaAdriac(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static altezzaOndaAdriac fetchaltezzaOndaAdriac(long id) {
		return getService().fetchaltezzaOndaAdriac(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the altezza onda adriac with the primary key.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws PortalException if a altezza onda adriac with the primary key could not be found
	 */
	public static altezzaOndaAdriac getaltezzaOndaAdriac(long id)
		throws PortalException {

		return getService().getaltezzaOndaAdriac(id);
	}

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	public static List<altezzaOndaAdriac> getaltezzaOndaAdriacs(
		int start, int end) {

		return getService().getaltezzaOndaAdriacs(start, end);
	}

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	public static int getaltezzaOndaAdriacsCount() {
		return getService().getaltezzaOndaAdriacsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the altezza onda adriac in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaAdriacLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was updated
	 */
	public static altezzaOndaAdriac updatealtezzaOndaAdriac(
		altezzaOndaAdriac altezzaOndaAdriac) {

		return getService().updatealtezzaOndaAdriac(altezzaOndaAdriac);
	}

	public static altezzaOndaAdriacLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<altezzaOndaAdriacLocalService>
		_serviceSnapshot = new Snapshot<>(
			altezzaOndaAdriacLocalServiceUtil.class,
			altezzaOndaAdriacLocalService.class);

}