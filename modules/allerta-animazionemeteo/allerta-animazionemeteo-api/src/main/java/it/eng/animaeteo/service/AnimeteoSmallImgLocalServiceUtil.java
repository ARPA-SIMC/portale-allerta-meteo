/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animaeteo.model.AnimeteoSmallImg;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AnimeteoSmallImg. This utility wraps
 * <code>it.eng.animaeteo.service.impl.AnimeteoSmallImgLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgLocalService
 * @generated
 */
public class AnimeteoSmallImgLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.animaeteo.service.impl.AnimeteoSmallImgLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the animeteo small img to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimeteoSmallImgLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was added
	 */
	public static AnimeteoSmallImg addAnimeteoSmallImg(
		AnimeteoSmallImg animeteoSmallImg) {

		return getService().addAnimeteoSmallImg(animeteoSmallImg);
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	public static AnimeteoSmallImg createAnimeteoSmallImg(long id) {
		return getService().createAnimeteoSmallImg(id);
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
	 * Deletes the animeteo small img from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimeteoSmallImgLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was removed
	 */
	public static AnimeteoSmallImg deleteAnimeteoSmallImg(
		AnimeteoSmallImg animeteoSmallImg) {

		return getService().deleteAnimeteoSmallImg(animeteoSmallImg);
	}

	/**
	 * Deletes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimeteoSmallImgLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	public static AnimeteoSmallImg deleteAnimeteoSmallImg(long id)
		throws PortalException {

		return getService().deleteAnimeteoSmallImg(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>.
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

	public static AnimeteoSmallImg fetchAnimeteoSmallImg(long id) {
		return getService().fetchAnimeteoSmallImg(id);
	}

	public static List<AnimeteoSmallImg> findByType(String type)
		throws SystemException {

		return getService().findByType(type);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the animeteo small img with the primary key.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	public static AnimeteoSmallImg getAnimeteoSmallImg(long id)
		throws PortalException {

		return getService().getAnimeteoSmallImg(id);
	}

	/**
	 * Returns a range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of animeteo small imgs
	 */
	public static List<AnimeteoSmallImg> getAnimeteoSmallImgs(
		int start, int end) {

		return getService().getAnimeteoSmallImgs(start, end);
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	public static int getAnimeteoSmallImgsCount() {
		return getService().getAnimeteoSmallImgsCount();
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
	 * Updates the animeteo small img in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimeteoSmallImgLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was updated
	 */
	public static AnimeteoSmallImg updateAnimeteoSmallImg(
		AnimeteoSmallImg animeteoSmallImg) {

		return getService().updateAnimeteoSmallImg(animeteoSmallImg);
	}

	public static AnimeteoSmallImgLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AnimeteoSmallImgLocalService>
		_serviceSnapshot = new Snapshot<>(
			AnimeteoSmallImgLocalServiceUtil.class,
			AnimeteoSmallImgLocalService.class);

}