/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.parer.model.DocumentiCollegati;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DocumentiCollegati. This utility wraps
 * <code>it.eng.parer.service.impl.DocumentiCollegatiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see DocumentiCollegatiLocalService
 * @generated
 */
public class DocumentiCollegatiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.parer.service.impl.DocumentiCollegatiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the documenti collegati to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentiCollegatiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was added
	 */
	public static DocumentiCollegati addDocumentiCollegati(
		DocumentiCollegati documentiCollegati) {

		return getService().addDocumentiCollegati(documentiCollegati);
	}

	/**
	 * Creates a new documenti collegati with the primary key. Does not add the documenti collegati to the database.
	 *
	 * @param documentiCollegatiPK the primary key for the new documenti collegati
	 * @return the new documenti collegati
	 */
	public static DocumentiCollegati createDocumentiCollegati(
		it.eng.parer.service.persistence.DocumentiCollegatiPK
			documentiCollegatiPK) {

		return getService().createDocumentiCollegati(documentiCollegatiPK);
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
	 * Deletes the documenti collegati from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentiCollegatiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was removed
	 */
	public static DocumentiCollegati deleteDocumentiCollegati(
		DocumentiCollegati documentiCollegati) {

		return getService().deleteDocumentiCollegati(documentiCollegati);
	}

	/**
	 * Deletes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentiCollegatiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws PortalException if a documenti collegati with the primary key could not be found
	 */
	public static DocumentiCollegati deleteDocumentiCollegati(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws PortalException {

		return getService().deleteDocumentiCollegati(documentiCollegatiPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>.
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

	public static DocumentiCollegati fetchDocumentiCollegati(
		it.eng.parer.service.persistence.DocumentiCollegatiPK
			documentiCollegatiPK) {

		return getService().fetchDocumentiCollegati(documentiCollegatiPK);
	}

	/**
	 * Returns the documenti collegati with the primary key.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati
	 * @throws PortalException if a documenti collegati with the primary key could not be found
	 */
	public static DocumentiCollegati getDocumentiCollegati(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws PortalException {

		return getService().getDocumentiCollegati(documentiCollegatiPK);
	}

	/**
	 * Returns a range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of documenti collegatis
	 */
	public static List<DocumentiCollegati> getDocumentiCollegatis(
		int start, int end) {

		return getService().getDocumentiCollegatis(start, end);
	}

	/**
	 * Returns the number of documenti collegatis.
	 *
	 * @return the number of documenti collegatis
	 */
	public static int getDocumentiCollegatisCount() {
		return getService().getDocumentiCollegatisCount();
	}

	public static DocumentiCollegati getNuovoDocumentoCollegato() {
		return getService().getNuovoDocumentoCollegato();
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
	 * Updates the documenti collegati in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentiCollegatiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was updated
	 */
	public static DocumentiCollegati updateDocumentiCollegati(
		DocumentiCollegati documentiCollegati) {

		return getService().updateDocumentiCollegati(documentiCollegati);
	}

	public static DocumentiCollegatiLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DocumentiCollegatiLocalService>
		_serviceSnapshot = new Snapshot<>(
			DocumentiCollegatiLocalServiceUtil.class,
			DocumentiCollegatiLocalService.class);

}