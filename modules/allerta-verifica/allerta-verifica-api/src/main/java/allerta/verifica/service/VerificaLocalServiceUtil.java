/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service;

import allerta.verifica.model.Verifica;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Verifica. This utility wraps
 * <code>allerta.verifica.service.impl.VerificaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaLocalService
 * @generated
 */
public class VerificaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>allerta.verifica.service.impl.VerificaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the verifica to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verifica the verifica
	 * @return the verifica that was added
	 */
	public static Verifica addVerifica(Verifica verifica) {
		return getService().addVerifica(verifica);
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
	 * Creates a new verifica with the primary key. Does not add the verifica to the database.
	 *
	 * @param id the primary key for the new verifica
	 * @return the new verifica
	 */
	public static Verifica createVerifica(long id) {
		return getService().createVerifica(id);
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
	 * Deletes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws PortalException if a verifica with the primary key could not be found
	 */
	public static Verifica deleteVerifica(long id) throws PortalException {
		return getService().deleteVerifica(id);
	}

	/**
	 * Deletes the verifica from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verifica the verifica
	 * @return the verifica that was removed
	 */
	public static Verifica deleteVerifica(Verifica verifica) {
		return getService().deleteVerifica(verifica);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaModelImpl</code>.
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

	public static Verifica fetchVerifica(long id) {
		return getService().fetchVerifica(id);
	}

	/**
	 * Returns the verifica matching the UUID and group.
	 *
	 * @param uuid the verifica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	public static Verifica fetchVerificaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchVerificaByUuidAndGroupId(uuid, groupId);
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
	 * Returns the verifica with the primary key.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica
	 * @throws PortalException if a verifica with the primary key could not be found
	 */
	public static Verifica getVerifica(long id) throws PortalException {
		return getService().getVerifica(id);
	}

	/**
	 * Returns the verifica matching the UUID and group.
	 *
	 * @param uuid the verifica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching verifica
	 * @throws PortalException if a matching verifica could not be found
	 */
	public static Verifica getVerificaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getVerificaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of verificas
	 */
	public static List<Verifica> getVerificas(int start, int end) {
		return getService().getVerificas(start, end);
	}

	/**
	 * Returns all the verificas matching the UUID and company.
	 *
	 * @param uuid the UUID of the verificas
	 * @param companyId the primary key of the company
	 * @return the matching verificas, or an empty list if no matches were found
	 */
	public static List<Verifica> getVerificasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getVerificasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of verificas matching the UUID and company.
	 *
	 * @param uuid the UUID of the verificas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching verificas, or an empty list if no matches were found
	 */
	public static List<Verifica> getVerificasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return getService().getVerificasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of verificas.
	 *
	 * @return the number of verificas
	 */
	public static int getVerificasCount() {
		return getService().getVerificasCount();
	}

	public static allerta.verifica.model.VerificaDato insertVerificaDato(
		long doc, java.util.Date giorno, String zona, Long evento,
		String nomeDato, Integer prog, String datoCalcolato) {

		return getService().insertVerificaDato(
			doc, giorno, zona, evento, nomeDato, prog, datoCalcolato);
	}

	/**
	 * Updates the verifica in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerificaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verifica the verifica
	 * @return the verifica that was updated
	 */
	public static Verifica updateVerifica(Verifica verifica) {
		return getService().updateVerifica(verifica);
	}

	public static VerificaLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<VerificaLocalService> _serviceSnapshot =
		new Snapshot<>(
			VerificaLocalServiceUtil.class, VerificaLocalService.class);

}