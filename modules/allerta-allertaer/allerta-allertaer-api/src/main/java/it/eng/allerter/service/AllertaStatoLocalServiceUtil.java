/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaStato;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AllertaStato. This utility wraps
 * <code>it.eng.allerter.service.impl.AllertaStatoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see AllertaStatoLocalService
 * @generated
 */
public class AllertaStatoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaStatoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the allerta stato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaStatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was added
	 */
	public static AllertaStato addAllertaStato(AllertaStato allertaStato) {
		return getService().addAllertaStato(allertaStato);
	}

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	public static AllertaStato createAllertaStato(long allertaStatoId) {
		return getService().createAllertaStato(allertaStatoId);
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
	 * Deletes the allerta stato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaStatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was removed
	 */
	public static AllertaStato deleteAllertaStato(AllertaStato allertaStato) {
		return getService().deleteAllertaStato(allertaStato);
	}

	/**
	 * Deletes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaStatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato deleteAllertaStato(long allertaStatoId)
		throws PortalException {

		return getService().deleteAllertaStato(allertaStatoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>.
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

	public static AllertaStato fetchAllertaStato(long allertaStatoId) {
		return getService().fetchAllertaStato(allertaStatoId);
	}

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchAllertaStatoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAllertaStatoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta stato with the primary key.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato getAllertaStato(long allertaStatoId)
		throws PortalException {

		return getService().getAllertaStato(allertaStatoId);
	}

	public static List<AllertaStato> getAllertaStatoByAllerta(long allertaId) {
		return getService().getAllertaStatoByAllerta(allertaId);
	}

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato
	 * @throws PortalException if a matching allerta stato could not be found
	 */
	public static AllertaStato getAllertaStatoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAllertaStatoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of allerta statos
	 */
	public static List<AllertaStato> getAllertaStatos(int start, int end) {
		return getService().getAllertaStatos(start, end);
	}

	/**
	 * Returns all the allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @return the matching allerta statos, or an empty list if no matches were found
	 */
	public static List<AllertaStato> getAllertaStatosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAllertaStatosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allerta statos, or an empty list if no matches were found
	 */
	public static List<AllertaStato> getAllertaStatosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getService().getAllertaStatosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	public static int getAllertaStatosCount() {
		return getService().getAllertaStatosCount();
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
	 * Updates the allerta stato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaStatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was updated
	 */
	public static AllertaStato updateAllertaStato(AllertaStato allertaStato) {
		return getService().updateAllertaStato(allertaStato);
	}

	public static AllertaStatoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AllertaStatoLocalService> _serviceSnapshot =
		new Snapshot<>(
			AllertaStatoLocalServiceUtil.class, AllertaStatoLocalService.class);

}