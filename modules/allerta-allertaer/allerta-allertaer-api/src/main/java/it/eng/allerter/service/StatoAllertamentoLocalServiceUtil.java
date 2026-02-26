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

import it.eng.allerter.model.StatoAllertamento;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StatoAllertamento. This utility wraps
 * <code>it.eng.allerter.service.impl.StatoAllertamentoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see StatoAllertamentoLocalService
 * @generated
 */
public class StatoAllertamentoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.StatoAllertamentoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the stato allertamento to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoAllertamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoAllertamento the stato allertamento
	 * @return the stato allertamento that was added
	 */
	public static StatoAllertamento addStatoAllertamento(
		StatoAllertamento statoAllertamento) {

		return getService().addStatoAllertamento(statoAllertamento);
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
	 * Creates a new stato allertamento with the primary key. Does not add the stato allertamento to the database.
	 *
	 * @param statoId the primary key for the new stato allertamento
	 * @return the new stato allertamento
	 */
	public static StatoAllertamento createStatoAllertamento(long statoId) {
		return getService().createStatoAllertamento(statoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the stato allertamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoAllertamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento that was removed
	 * @throws PortalException if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento deleteStatoAllertamento(long statoId)
		throws PortalException {

		return getService().deleteStatoAllertamento(statoId);
	}

	/**
	 * Deletes the stato allertamento from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoAllertamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoAllertamento the stato allertamento
	 * @return the stato allertamento that was removed
	 */
	public static StatoAllertamento deleteStatoAllertamento(
		StatoAllertamento statoAllertamento) {

		return getService().deleteStatoAllertamento(statoAllertamento);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.StatoAllertamentoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.StatoAllertamentoModelImpl</code>.
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

	public static StatoAllertamento fetchStatoAllertamento(long statoId) {
		return getService().fetchStatoAllertamento(statoId);
	}

	/**
	 * Returns the stato allertamento matching the UUID and group.
	 *
	 * @param uuid the stato allertamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchStatoAllertamentoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchStatoAllertamentoByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the stato allertamento with the primary key.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento
	 * @throws PortalException if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento getStatoAllertamento(long statoId)
		throws PortalException {

		return getService().getStatoAllertamento(statoId);
	}

	/**
	 * Returns the stato allertamento matching the UUID and group.
	 *
	 * @param uuid the stato allertamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stato allertamento
	 * @throws PortalException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento getStatoAllertamentoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getStatoAllertamentoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.StatoAllertamentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of stato allertamentos
	 */
	public static List<StatoAllertamento> getStatoAllertamentos(
		int start, int end) {

		return getService().getStatoAllertamentos(start, end);
	}

	/**
	 * Returns all the stato allertamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the stato allertamentos
	 * @param companyId the primary key of the company
	 * @return the matching stato allertamentos, or an empty list if no matches were found
	 */
	public static List<StatoAllertamento>
		getStatoAllertamentosByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getStatoAllertamentosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of stato allertamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the stato allertamentos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching stato allertamentos, or an empty list if no matches were found
	 */
	public static List<StatoAllertamento>
		getStatoAllertamentosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<StatoAllertamento> orderByComparator) {

		return getService().getStatoAllertamentosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of stato allertamentos.
	 *
	 * @return the number of stato allertamentos
	 */
	public static int getStatoAllertamentosCount() {
		return getService().getStatoAllertamentosCount();
	}

	/**
	 * Updates the stato allertamento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatoAllertamentoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statoAllertamento the stato allertamento
	 * @return the stato allertamento that was updated
	 */
	public static StatoAllertamento updateStatoAllertamento(
		StatoAllertamento statoAllertamento) {

		return getService().updateStatoAllertamento(statoAllertamento);
	}

	public static StatoAllertamentoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<StatoAllertamentoLocalService>
		_serviceSnapshot = new Snapshot<>(
			StatoAllertamentoLocalServiceUtil.class,
			StatoAllertamentoLocalService.class);

}