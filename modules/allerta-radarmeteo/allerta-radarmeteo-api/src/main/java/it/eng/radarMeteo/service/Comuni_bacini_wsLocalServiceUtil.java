/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.radarMeteo.model.Comuni_bacini_ws;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Comuni_bacini_ws. This utility wraps
 * <code>it.eng.radarMeteo.service.impl.Comuni_bacini_wsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Francesco
 * @see Comuni_bacini_wsLocalService
 * @generated
 */
public class Comuni_bacini_wsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.radarMeteo.service.impl.Comuni_bacini_wsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the comuni_bacini_ws to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Comuni_bacini_wsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was added
	 */
	public static Comuni_bacini_ws addComuni_bacini_ws(
		Comuni_bacini_ws comuni_bacini_ws) {

		return getService().addComuni_bacini_ws(comuni_bacini_ws);
	}

	/**
	 * Creates a new comuni_bacini_ws with the primary key. Does not add the comuni_bacini_ws to the database.
	 *
	 * @param idBacini the primary key for the new comuni_bacini_ws
	 * @return the new comuni_bacini_ws
	 */
	public static Comuni_bacini_ws createComuni_bacini_ws(int idBacini) {
		return getService().createComuni_bacini_ws(idBacini);
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
	 * Deletes the comuni_bacini_ws from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Comuni_bacini_wsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 */
	public static Comuni_bacini_ws deleteComuni_bacini_ws(
		Comuni_bacini_ws comuni_bacini_ws) {

		return getService().deleteComuni_bacini_ws(comuni_bacini_ws);
	}

	/**
	 * Deletes the comuni_bacini_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Comuni_bacini_wsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 * @throws PortalException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static Comuni_bacini_ws deleteComuni_bacini_ws(int idBacini)
		throws PortalException {

		return getService().deleteComuni_bacini_ws(idBacini);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>.
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

	public static Comuni_bacini_ws fetchComuni_bacini_ws(int idBacini) {
		return getService().fetchComuni_bacini_ws(idBacini);
	}

	public static List<Comuni_bacini_ws> findByBacino(String bacino) {
		return getService().findByBacino(bacino);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws
	 * @throws PortalException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static Comuni_bacini_ws getComuni_bacini_ws(int idBacini)
		throws PortalException {

		return getService().getComuni_bacini_ws(idBacini);
	}

	/**
	 * Returns a range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> getComuni_bacini_wses(
		int start, int end) {

		return getService().getComuni_bacini_wses(start, end);
	}

	/**
	 * Returns the number of comuni_bacini_wses.
	 *
	 * @return the number of comuni_bacini_wses
	 */
	public static int getComuni_bacini_wsesCount() {
		return getService().getComuni_bacini_wsesCount();
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
	 * Updates the comuni_bacini_ws in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Comuni_bacini_wsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was updated
	 */
	public static Comuni_bacini_ws updateComuni_bacini_ws(
		Comuni_bacini_ws comuni_bacini_ws) {

		return getService().updateComuni_bacini_ws(comuni_bacini_ws);
	}

	public static Comuni_bacini_wsLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<Comuni_bacini_wsLocalService>
		_serviceSnapshot = new Snapshot<>(
			Comuni_bacini_wsLocalServiceUtil.class,
			Comuni_bacini_wsLocalService.class);

}