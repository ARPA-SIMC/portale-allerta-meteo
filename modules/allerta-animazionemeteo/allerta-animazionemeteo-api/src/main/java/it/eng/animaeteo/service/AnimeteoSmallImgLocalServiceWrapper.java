/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AnimeteoSmallImgLocalService}.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgLocalService
 * @generated
 */
public class AnimeteoSmallImgLocalServiceWrapper
	implements AnimeteoSmallImgLocalService,
			   ServiceWrapper<AnimeteoSmallImgLocalService> {

	public AnimeteoSmallImgLocalServiceWrapper() {
		this(null);
	}

	public AnimeteoSmallImgLocalServiceWrapper(
		AnimeteoSmallImgLocalService animeteoSmallImgLocalService) {

		_animeteoSmallImgLocalService = animeteoSmallImgLocalService;
	}

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
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg addAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImgLocalService.addAnimeteoSmallImg(
			animeteoSmallImg);
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg createAnimeteoSmallImg(
		long id) {

		return _animeteoSmallImgLocalService.createAnimeteoSmallImg(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg deleteAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImgLocalService.deleteAnimeteoSmallImg(
			animeteoSmallImg);
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
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg deleteAnimeteoSmallImg(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.deleteAnimeteoSmallImg(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _animeteoSmallImgLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _animeteoSmallImgLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _animeteoSmallImgLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _animeteoSmallImgLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _animeteoSmallImgLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _animeteoSmallImgLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _animeteoSmallImgLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _animeteoSmallImgLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg fetchAnimeteoSmallImg(
		long id) {

		return _animeteoSmallImgLocalService.fetchAnimeteoSmallImg(id);
	}

	@Override
	public java.util.List<it.eng.animaeteo.model.AnimeteoSmallImg> findByType(
			String type)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _animeteoSmallImgLocalService.findByType(type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _animeteoSmallImgLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the animeteo small img with the primary key.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg getAnimeteoSmallImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.getAnimeteoSmallImg(id);
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
	@Override
	public java.util.List<it.eng.animaeteo.model.AnimeteoSmallImg>
		getAnimeteoSmallImgs(int start, int end) {

		return _animeteoSmallImgLocalService.getAnimeteoSmallImgs(start, end);
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	@Override
	public int getAnimeteoSmallImgsCount() {
		return _animeteoSmallImgLocalService.getAnimeteoSmallImgsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _animeteoSmallImgLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animeteoSmallImgLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg updateAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImgLocalService.updateAnimeteoSmallImg(
			animeteoSmallImg);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _animeteoSmallImgLocalService.getBasePersistence();
	}

	@Override
	public AnimeteoSmallImgLocalService getWrappedService() {
		return _animeteoSmallImgLocalService;
	}

	@Override
	public void setWrappedService(
		AnimeteoSmallImgLocalService animeteoSmallImgLocalService) {

		_animeteoSmallImgLocalService = animeteoSmallImgLocalService;
	}

	private AnimeteoSmallImgLocalService _animeteoSmallImgLocalService;

}