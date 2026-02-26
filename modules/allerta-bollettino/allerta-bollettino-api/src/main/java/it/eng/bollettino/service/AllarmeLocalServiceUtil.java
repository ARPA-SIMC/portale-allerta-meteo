/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.Allarme;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Allarme. This utility wraps
 * <code>it.eng.bollettino.service.impl.AllarmeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see AllarmeLocalService
 * @generated
 */
public class AllarmeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.AllarmeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the allarme to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allarme the allarme
	 * @return the allarme that was added
	 */
	public static Allarme addAllarme(Allarme allarme) {
		return getService().addAllarme(allarme);
	}

	/**
	 * Creates a new allarme with the primary key. Does not add the allarme to the database.
	 *
	 * @param allarmeId the primary key for the new allarme
	 * @return the new allarme
	 */
	public static Allarme createAllarme(long allarmeId) {
		return getService().createAllarme(allarmeId);
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
	 * Deletes the allarme from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allarme the allarme
	 * @return the allarme that was removed
	 */
	public static Allarme deleteAllarme(Allarme allarme) {
		return getService().deleteAllarme(allarme);
	}

	/**
	 * Deletes the allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme that was removed
	 * @throws PortalException if a allarme with the primary key could not be found
	 */
	public static Allarme deleteAllarme(long allarmeId) throws PortalException {
		return getService().deleteAllarme(allarmeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AllarmeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AllarmeModelImpl</code>.
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

	public static Allarme fetchAllarme(long allarmeId) {
		return getService().fetchAllarme(allarmeId);
	}

	/**
	 * Returns the allarme matching the UUID and group.
	 *
	 * @param uuid the allarme's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchAllarmeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAllarmeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the allarme with the primary key.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme
	 * @throws PortalException if a allarme with the primary key could not be found
	 */
	public static Allarme getAllarme(long allarmeId) throws PortalException {
		return getService().getAllarme(allarmeId);
	}

	/**
	 * Returns the allarme matching the UUID and group.
	 *
	 * @param uuid the allarme's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allarme
	 * @throws PortalException if a matching allarme could not be found
	 */
	public static Allarme getAllarmeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getAllarmeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of allarmes
	 */
	public static List<Allarme> getAllarmes(int start, int end) {
		return getService().getAllarmes(start, end);
	}

	/**
	 * Returns all the allarmes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allarmes
	 * @param companyId the primary key of the company
	 * @return the matching allarmes, or an empty list if no matches were found
	 */
	public static List<Allarme> getAllarmesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAllarmesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of allarmes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allarmes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allarmes, or an empty list if no matches were found
	 */
	public static List<Allarme> getAllarmesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return getService().getAllarmesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allarmes.
	 *
	 * @return the number of allarmes
	 */
	public static int getAllarmesCount() {
		return getService().getAllarmesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the allarme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allarme the allarme
	 * @return the allarme that was updated
	 */
	public static Allarme updateAllarme(Allarme allarme) {
		return getService().updateAllarme(allarme);
	}

	public static AllarmeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AllarmeLocalService> _serviceSnapshot =
		new Snapshot<>(
			AllarmeLocalServiceUtil.class, AllarmeLocalService.class);

}