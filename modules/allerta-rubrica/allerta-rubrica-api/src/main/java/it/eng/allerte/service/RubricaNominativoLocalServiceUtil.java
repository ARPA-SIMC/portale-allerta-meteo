/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaNominativo;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RubricaNominativo. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaNominativoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see RubricaNominativoLocalService
 * @generated
 */
public class RubricaNominativoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaNominativoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rubrica nominativo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 * @return the rubrica nominativo that was added
	 */
	public static RubricaNominativo addRubricaNominativo(
		RubricaNominativo rubricaNominativo) {

		return getService().addRubricaNominativo(rubricaNominativo);
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
	 * Creates a new rubrica nominativo with the primary key. Does not add the rubrica nominativo to the database.
	 *
	 * @param ID_NOMINATIVO the primary key for the new rubrica nominativo
	 * @return the new rubrica nominativo
	 */
	public static RubricaNominativo createRubricaNominativo(
		long ID_NOMINATIVO) {

		return getService().createRubricaNominativo(ID_NOMINATIVO);
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
	 * Deletes the rubrica nominativo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 * @throws PortalException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo deleteRubricaNominativo(long ID_NOMINATIVO)
		throws PortalException {

		return getService().deleteRubricaNominativo(ID_NOMINATIVO);
	}

	/**
	 * Deletes the rubrica nominativo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 */
	public static RubricaNominativo deleteRubricaNominativo(
		RubricaNominativo rubricaNominativo) {

		return getService().deleteRubricaNominativo(rubricaNominativo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaNominativoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaNominativoModelImpl</code>.
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

	public static RubricaNominativo fetchRubricaNominativo(long ID_NOMINATIVO) {
		return getService().fetchRubricaNominativo(ID_NOMINATIVO);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Object[]> getNominativiByName(
		String name, Long limit, Long offset) {

		return getService().getNominativiByName(name, limit, offset);
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
	 * Returns the rubrica nominativo with the primary key.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo
	 * @throws PortalException if a rubrica nominativo with the primary key could not be found
	 */
	public static RubricaNominativo getRubricaNominativo(long ID_NOMINATIVO)
		throws PortalException {

		return getService().getRubricaNominativo(ID_NOMINATIVO);
	}

	/**
	 * Returns a range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaNominativoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of rubrica nominativos
	 */
	public static List<RubricaNominativo> getRubricaNominativos(
		int start, int end) {

		return getService().getRubricaNominativos(start, end);
	}

	/**
	 * Returns the number of rubrica nominativos.
	 *
	 * @return the number of rubrica nominativos
	 */
	public static int getRubricaNominativosCount() {
		return getService().getRubricaNominativosCount();
	}

	/**
	 * Updates the rubrica nominativo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 * @return the rubrica nominativo that was updated
	 */
	public static RubricaNominativo updateRubricaNominativo(
		RubricaNominativo rubricaNominativo) {

		return getService().updateRubricaNominativo(rubricaNominativo);
	}

	public static RubricaNominativoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaNominativoLocalService>
		_serviceSnapshot = new Snapshot<>(
			RubricaNominativoLocalServiceUtil.class,
			RubricaNominativoLocalService.class);

}