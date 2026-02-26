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

import it.eng.animazione.image.model.altezzaOndaSwanita;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for altezzaOndaSwanita. This utility wraps
 * <code>it.eng.animazione.image.service.impl.altezzaOndaSwanitaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author UTENTE
 * @see altezzaOndaSwanitaLocalService
 * @generated
 */
public class altezzaOndaSwanitaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.animazione.image.service.impl.altezzaOndaSwanitaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the altezza onda swanita to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaSwanitaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 * @return the altezza onda swanita that was added
	 */
	public static altezzaOndaSwanita addaltezzaOndaSwanita(
		altezzaOndaSwanita altezzaOndaSwanita) {

		return getService().addaltezzaOndaSwanita(altezzaOndaSwanita);
	}

	/**
	 * Creates a new altezza onda swanita with the primary key. Does not add the altezza onda swanita to the database.
	 *
	 * @param id the primary key for the new altezza onda swanita
	 * @return the new altezza onda swanita
	 */
	public static altezzaOndaSwanita createaltezzaOndaSwanita(long id) {
		return getService().createaltezzaOndaSwanita(id);
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
	 * Deletes the altezza onda swanita from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaSwanitaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 */
	public static altezzaOndaSwanita deletealtezzaOndaSwanita(
		altezzaOndaSwanita altezzaOndaSwanita) {

		return getService().deletealtezzaOndaSwanita(altezzaOndaSwanita);
	}

	/**
	 * Deletes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaSwanitaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws PortalException if a altezza onda swanita with the primary key could not be found
	 */
	public static altezzaOndaSwanita deletealtezzaOndaSwanita(long id)
		throws PortalException {

		return getService().deletealtezzaOndaSwanita(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl</code>.
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

	public static altezzaOndaSwanita fetchaltezzaOndaSwanita(long id) {
		return getService().fetchaltezzaOndaSwanita(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the altezza onda swanita with the primary key.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws PortalException if a altezza onda swanita with the primary key could not be found
	 */
	public static altezzaOndaSwanita getaltezzaOndaSwanita(long id)
		throws PortalException {

		return getService().getaltezzaOndaSwanita(id);
	}

	/**
	 * Returns a range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @return the range of altezza onda swanitas
	 */
	public static List<altezzaOndaSwanita> getaltezzaOndaSwanitas(
		int start, int end) {

		return getService().getaltezzaOndaSwanitas(start, end);
	}

	/**
	 * Returns the number of altezza onda swanitas.
	 *
	 * @return the number of altezza onda swanitas
	 */
	public static int getaltezzaOndaSwanitasCount() {
		return getService().getaltezzaOndaSwanitasCount();
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
	 * Updates the altezza onda swanita in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaSwanitaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 * @return the altezza onda swanita that was updated
	 */
	public static altezzaOndaSwanita updatealtezzaOndaSwanita(
		altezzaOndaSwanita altezzaOndaSwanita) {

		return getService().updatealtezzaOndaSwanita(altezzaOndaSwanita);
	}

	public static altezzaOndaSwanitaLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<altezzaOndaSwanitaLocalService>
		_serviceSnapshot = new Snapshot<>(
			altezzaOndaSwanitaLocalServiceUtil.class,
			altezzaOndaSwanitaLocalService.class);

}