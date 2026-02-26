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

import it.eng.bollettino.model.AttivazioneFiume;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AttivazioneFiume. This utility wraps
 * <code>it.eng.bollettino.service.impl.AttivazioneFiumeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see AttivazioneFiumeLocalService
 * @generated
 */
public class AttivazioneFiumeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.AttivazioneFiumeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the attivazione fiume to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivazioneFiumeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivazioneFiume the attivazione fiume
	 * @return the attivazione fiume that was added
	 */
	public static AttivazioneFiume addAttivazioneFiume(
		AttivazioneFiume attivazioneFiume) {

		return getService().addAttivazioneFiume(attivazioneFiume);
	}

	/**
	 * Creates a new attivazione fiume with the primary key. Does not add the attivazione fiume to the database.
	 *
	 * @param fiumeId the primary key for the new attivazione fiume
	 * @return the new attivazione fiume
	 */
	public static AttivazioneFiume createAttivazioneFiume(String fiumeId) {
		return getService().createAttivazioneFiume(fiumeId);
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
	 * Deletes the attivazione fiume from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivazioneFiumeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivazioneFiume the attivazione fiume
	 * @return the attivazione fiume that was removed
	 */
	public static AttivazioneFiume deleteAttivazioneFiume(
		AttivazioneFiume attivazioneFiume) {

		return getService().deleteAttivazioneFiume(attivazioneFiume);
	}

	/**
	 * Deletes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivazioneFiumeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws PortalException if a attivazione fiume with the primary key could not be found
	 */
	public static AttivazioneFiume deleteAttivazioneFiume(String fiumeId)
		throws PortalException {

		return getService().deleteAttivazioneFiume(fiumeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AttivazioneFiumeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AttivazioneFiumeModelImpl</code>.
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

	public static AttivazioneFiume fetchAttivazioneFiume(String fiumeId) {
		return getService().fetchAttivazioneFiume(fiumeId);
	}

	/**
	 * Returns the attivazione fiume with the primary key.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws PortalException if a attivazione fiume with the primary key could not be found
	 */
	public static AttivazioneFiume getAttivazioneFiume(String fiumeId)
		throws PortalException {

		return getService().getAttivazioneFiume(fiumeId);
	}

	/**
	 * Returns a range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @return the range of attivazione fiumes
	 */
	public static List<AttivazioneFiume> getAttivazioneFiumes(
		int start, int end) {

		return getService().getAttivazioneFiumes(start, end);
	}

	/**
	 * Returns the number of attivazione fiumes.
	 *
	 * @return the number of attivazione fiumes
	 */
	public static int getAttivazioneFiumesCount() {
		return getService().getAttivazioneFiumesCount();
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
	 * Updates the attivazione fiume in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttivazioneFiumeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attivazioneFiume the attivazione fiume
	 * @return the attivazione fiume that was updated
	 */
	public static AttivazioneFiume updateAttivazioneFiume(
		AttivazioneFiume attivazioneFiume) {

		return getService().updateAttivazioneFiume(attivazioneFiume);
	}

	public static AttivazioneFiumeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AttivazioneFiumeLocalService>
		_serviceSnapshot = new Snapshot<>(
			AttivazioneFiumeLocalServiceUtil.class,
			AttivazioneFiumeLocalService.class);

}