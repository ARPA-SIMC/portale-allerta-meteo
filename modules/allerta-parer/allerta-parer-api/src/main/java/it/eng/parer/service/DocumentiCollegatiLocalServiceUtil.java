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

package it.eng.parer.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

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
@ProviderType
public class DocumentiCollegatiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.parer.service.impl.DocumentiCollegatiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the documenti collegati to the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was added
	 */
	public static it.eng.parer.model.DocumentiCollegati addDocumentiCollegati(
		it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return getService().addDocumentiCollegati(documentiCollegati);
	}

	/**
	 * Creates a new documenti collegati with the primary key. Does not add the documenti collegati to the database.
	 *
	 * @param documentiCollegatiPK the primary key for the new documenti collegati
	 * @return the new documenti collegati
	 */
	public static it.eng.parer.model.DocumentiCollegati
		createDocumentiCollegati(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK) {

		return getService().createDocumentiCollegati(documentiCollegatiPK);
	}

	/**
	 * Deletes the documenti collegati from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was removed
	 */
	public static it.eng.parer.model.DocumentiCollegati
		deleteDocumentiCollegati(
			it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return getService().deleteDocumentiCollegati(documentiCollegati);
	}

	/**
	 * Deletes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws PortalException if a documenti collegati with the primary key could not be found
	 */
	public static it.eng.parer.model.DocumentiCollegati
			deleteDocumentiCollegati(
				it.eng.parer.service.persistence.DocumentiCollegatiPK
					documentiCollegatiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDocumentiCollegati(documentiCollegatiPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.eng.parer.model.DocumentiCollegati fetchDocumentiCollegati(
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
	public static it.eng.parer.model.DocumentiCollegati getDocumentiCollegati(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDocumentiCollegati(documentiCollegatiPK);
	}

	/**
	 * Returns a range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of documenti collegatis
	 */
	public static java.util.List<it.eng.parer.model.DocumentiCollegati>
		getDocumentiCollegatis(int start, int end) {

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

	public static it.eng.parer.model.DocumentiCollegati
		getNuovoDocumentoCollegato() {

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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the documenti collegati in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was updated
	 */
	public static it.eng.parer.model.DocumentiCollegati
		updateDocumentiCollegati(
			it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return getService().updateDocumentiCollegati(documentiCollegati);
	}

	public static DocumentiCollegatiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DocumentiCollegatiLocalService, DocumentiCollegatiLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DocumentiCollegatiLocalService.class);

		ServiceTracker
			<DocumentiCollegatiLocalService, DocumentiCollegatiLocalService>
				serviceTracker =
					new ServiceTracker
						<DocumentiCollegatiLocalService,
						 DocumentiCollegatiLocalService>(
							 bundle.getBundleContext(),
							 DocumentiCollegatiLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}