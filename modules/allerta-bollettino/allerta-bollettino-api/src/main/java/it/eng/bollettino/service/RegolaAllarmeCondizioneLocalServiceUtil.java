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

import it.eng.bollettino.model.RegolaAllarmeCondizione;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RegolaAllarmeCondizione. This utility wraps
 * <code>it.eng.bollettino.service.impl.RegolaAllarmeCondizioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneLocalService
 * @generated
 */
public class RegolaAllarmeCondizioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.RegolaAllarmeCondizioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the regola allarme condizione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was added
	 */
	public static RegolaAllarmeCondizione addRegolaAllarmeCondizione(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		return getService().addRegolaAllarmeCondizione(regolaAllarmeCondizione);
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
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	public static RegolaAllarmeCondizione createRegolaAllarmeCondizione(
		long id) {

		return getService().createRegolaAllarmeCondizione(id);
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
	 * Deletes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws PortalException if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione deleteRegolaAllarmeCondizione(long id)
		throws PortalException {

		return getService().deleteRegolaAllarmeCondizione(id);
	}

	/**
	 * Deletes the regola allarme condizione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 */
	public static RegolaAllarmeCondizione deleteRegolaAllarmeCondizione(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		return getService().deleteRegolaAllarmeCondizione(
			regolaAllarmeCondizione);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>.
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

	public static RegolaAllarmeCondizione fetchRegolaAllarmeCondizione(
		long id) {

		return getService().fetchRegolaAllarmeCondizione(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<RegolaAllarmeCondizione> getAllarmeCondizione(
		long idRegola) {

		return getService().getAllarmeCondizione(idRegola);
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
	 * Returns the regola allarme condizione with the primary key.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws PortalException if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione getRegolaAllarmeCondizione(long id)
		throws PortalException {

		return getService().getRegolaAllarmeCondizione(id);
	}

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> getRegolaAllarmeCondiziones(
		int start, int end) {

		return getService().getRegolaAllarmeCondiziones(start, end);
	}

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
	 */
	public static int getRegolaAllarmeCondizionesCount() {
		return getService().getRegolaAllarmeCondizionesCount();
	}

	/**
	 * Updates the regola allarme condizione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was updated
	 */
	public static RegolaAllarmeCondizione updateRegolaAllarmeCondizione(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		return getService().updateRegolaAllarmeCondizione(
			regolaAllarmeCondizione);
	}

	public static RegolaAllarmeCondizioneLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RegolaAllarmeCondizioneLocalService>
		_serviceSnapshot = new Snapshot<>(
			RegolaAllarmeCondizioneLocalServiceUtil.class,
			RegolaAllarmeCondizioneLocalService.class);

}