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

import it.eng.bollettino.model.Bollettino;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Bollettino. This utility wraps
 * <code>it.eng.bollettino.service.impl.BollettinoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see BollettinoLocalService
 * @generated
 */
public class BollettinoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.BollettinoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the bollettino to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettino the bollettino
	 * @return the bollettino that was added
	 */
	public static Bollettino addBollettino(Bollettino bollettino) {
		return getService().addBollettino(bollettino);
	}

	public static void cessatiTuttiAllarmiFiumi() {
		getService().cessatiTuttiAllarmiFiumi();
	}

	public static void cessatoAllarmeFiume(
		it.eng.bollettino.model.AttivazioneFiume fiume) {

		getService().cessatoAllarmeFiume(fiume);
	}

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param bollettinoId the primary key for the new bollettino
	 * @return the new bollettino
	 */
	public static Bollettino createBollettino(long bollettinoId) {
		return getService().createBollettino(bollettinoId);
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
	 * Deletes the bollettino from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettino the bollettino
	 * @return the bollettino that was removed
	 */
	public static Bollettino deleteBollettino(Bollettino bollettino) {
		return getService().deleteBollettino(bollettino);
	}

	/**
	 * Deletes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws PortalException if a bollettino with the primary key could not be found
	 */
	public static Bollettino deleteBollettino(long bollettinoId)
		throws PortalException {

		return getService().deleteBollettino(bollettinoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoModelImpl</code>.
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

	public static Object eseguiQueryGenerica(String q) {
		return getService().eseguiQueryGenerica(q);
	}

	public static List eseguiQueryGenericaLista(String q) {
		return getService().eseguiQueryGenericaLista(q);
	}

	public static Bollettino fetchBollettino(long bollettinoId) {
		return getService().fetchBollettino(bollettinoId);
	}

	/**
	 * Returns the bollettino matching the UUID and group.
	 *
	 * @param uuid the bollettino's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public static Bollettino fetchBollettinoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBollettinoByUuidAndGroupId(uuid, groupId);
	}

	public static void fileDeleteByApp(
		long scopeGroup, String file, String folderName) {

		getService().fileDeleteByApp(scopeGroup, file, folderName);
	}

	public static void fileDeleteByApp(
		String file, String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		getService().fileDeleteByApp(file, folderName, serviceContext);
	}

	public static void fileUploadByApp(
		java.io.File file, String folderName, String title, String description,
		String mimeType,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		getService().fileUploadByApp(
			file, folderName, title, description, mimeType, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static long getApprovatore(long idBollettino) {
		return getService().getApprovatore(idBollettino);
	}

	/**
	 * Returns the bollettino with the primary key.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino
	 * @throws PortalException if a bollettino with the primary key could not be found
	 */
	public static Bollettino getBollettino(long bollettinoId)
		throws PortalException {

		return getService().getBollettino(bollettinoId);
	}

	/**
	 * Returns the bollettino matching the UUID and group.
	 *
	 * @param uuid the bollettino's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bollettino
	 * @throws PortalException if a matching bollettino could not be found
	 */
	public static Bollettino getBollettinoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBollettinoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	public static List<Bollettino> getBollettinos(int start, int end) {
		return getService().getBollettinos(start, end);
	}

	/**
	 * Returns all the bollettinos matching the UUID and company.
	 *
	 * @param uuid the UUID of the bollettinos
	 * @param companyId the primary key of the company
	 * @return the matching bollettinos, or an empty list if no matches were found
	 */
	public static List<Bollettino> getBollettinosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBollettinosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of bollettinos matching the UUID and company.
	 *
	 * @param uuid the UUID of the bollettinos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bollettinos, or an empty list if no matches were found
	 */
	public static List<Bollettino> getBollettinosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Bollettino> orderByComparator) {

		return getService().getBollettinosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	public static int getBollettinosCount() {
		return getService().getBollettinosCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static List<Object> getFiumiBollettino(long id) {
		return getService().getFiumiBollettino(id);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Bollettino> getListaBollettiniMonitoraggio() {
		return getService().getListaBollettiniMonitoraggio();
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

	public static double getSommaValori(
		String idStazione, String idVariabile, int quanti) {

		return getService().getSommaValori(idStazione, idVariabile, quanti);
	}

	public static String nextIdMonitoraggio(int anno) {
		return getService().nextIdMonitoraggio(anno);
	}

	public static void terminaMonitoraggio() {
		getService().terminaMonitoraggio();
	}

	/**
	 * Updates the bollettino in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettino the bollettino
	 * @return the bollettino that was updated
	 */
	public static Bollettino updateBollettino(Bollettino bollettino) {
		return getService().updateBollettino(bollettino);
	}

	public static BollettinoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BollettinoLocalService> _serviceSnapshot =
		new Snapshot<>(
			BollettinoLocalServiceUtil.class, BollettinoLocalService.class);

}