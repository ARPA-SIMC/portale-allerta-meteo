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

import it.eng.bollettino.model.RegolaAllarmeComune;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RegolaAllarmeComune. This utility wraps
 * <code>it.eng.bollettino.service.impl.RegolaAllarmeComuneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see RegolaAllarmeComuneLocalService
 * @generated
 */
public class RegolaAllarmeComuneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.RegolaAllarmeComuneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the regola allarme comune to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 * @return the regola allarme comune that was added
	 */
	public static RegolaAllarmeComune addRegolaAllarmeComune(
		RegolaAllarmeComune regolaAllarmeComune) {

		return getService().addRegolaAllarmeComune(regolaAllarmeComune);
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
	 * Creates a new regola allarme comune with the primary key. Does not add the regola allarme comune to the database.
	 *
	 * @param id the primary key for the new regola allarme comune
	 * @return the new regola allarme comune
	 */
	public static RegolaAllarmeComune createRegolaAllarmeComune(long id) {
		return getService().createRegolaAllarmeComune(id);
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
	 * Deletes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws PortalException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune deleteRegolaAllarmeComune(long id)
		throws PortalException {

		return getService().deleteRegolaAllarmeComune(id);
	}

	/**
	 * Deletes the regola allarme comune from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 * @return the regola allarme comune that was removed
	 */
	public static RegolaAllarmeComune deleteRegolaAllarmeComune(
		RegolaAllarmeComune regolaAllarmeComune) {

		return getService().deleteRegolaAllarmeComune(regolaAllarmeComune);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl</code>.
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

	public static RegolaAllarmeComune fetchRegolaAllarmeComune(long id) {
		return getService().fetchRegolaAllarmeComune(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<RegolaAllarmeComune> getAllarmeCondizione(
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
	 * Returns the regola allarme comune with the primary key.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws PortalException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune getRegolaAllarmeComune(long id)
		throws PortalException {

		return getService().getRegolaAllarmeComune(id);
	}

	/**
	 * Returns a range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> getRegolaAllarmeComunes(
		int start, int end) {

		return getService().getRegolaAllarmeComunes(start, end);
	}

	/**
	 * Returns the number of regola allarme comunes.
	 *
	 * @return the number of regola allarme comunes
	 */
	public static int getRegolaAllarmeComunesCount() {
		return getService().getRegolaAllarmeComunesCount();
	}

	/**
	 * Updates the regola allarme comune in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeComuneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 * @return the regola allarme comune that was updated
	 */
	public static RegolaAllarmeComune updateRegolaAllarmeComune(
		RegolaAllarmeComune regolaAllarmeComune) {

		return getService().updateRegolaAllarmeComune(regolaAllarmeComune);
	}

	public static RegolaAllarmeComuneLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RegolaAllarmeComuneLocalService>
		_serviceSnapshot = new Snapshot<>(
			RegolaAllarmeComuneLocalServiceUtil.class,
			RegolaAllarmeComuneLocalService.class);

}