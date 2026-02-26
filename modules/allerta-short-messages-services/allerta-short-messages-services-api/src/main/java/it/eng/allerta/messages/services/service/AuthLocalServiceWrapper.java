/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AuthLocalService}.
 *
 * @author Giorgianni_F
 * @see AuthLocalService
 * @generated
 */
public class AuthLocalServiceWrapper
	implements AuthLocalService, ServiceWrapper<AuthLocalService> {

	public AuthLocalServiceWrapper() {
		this(null);
	}

	public AuthLocalServiceWrapper(AuthLocalService authLocalService) {
		_authLocalService = authLocalService;
	}

	/**
	 * Adds the auth to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auth the auth
	 * @return the auth that was added
	 */
	@Override
	public it.eng.allerta.messages.services.model.Auth addAuth(
		it.eng.allerta.messages.services.model.Auth auth) {

		return _authLocalService.addAuth(auth);
	}

	/**
	 * Creates a new auth with the primary key. Does not add the auth to the database.
	 *
	 * @param key the primary key for the new auth
	 * @return the new auth
	 */
	@Override
	public it.eng.allerta.messages.services.model.Auth createAuth(String key) {
		return _authLocalService.createAuth(key);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the auth from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auth the auth
	 * @return the auth that was removed
	 */
	@Override
	public it.eng.allerta.messages.services.model.Auth deleteAuth(
		it.eng.allerta.messages.services.model.Auth auth) {

		return _authLocalService.deleteAuth(auth);
	}

	/**
	 * Deletes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param key the primary key of the auth
	 * @return the auth that was removed
	 * @throws PortalException if a auth with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.Auth deleteAuth(String key)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authLocalService.deleteAuth(key);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _authLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _authLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authLocalService.dynamicQuery();
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

		return _authLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.AuthModelImpl</code>.
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

		return _authLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.AuthModelImpl</code>.
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

		return _authLocalService.dynamicQuery(
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

		return _authLocalService.dynamicQueryCount(dynamicQuery);
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

		return _authLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.allerta.messages.services.model.Auth fetchAuth(String key) {
		return _authLocalService.fetchAuth(key);
	}

	/**
	 * Returns the auth with the primary key.
	 *
	 * @param key the primary key of the auth
	 * @return the auth
	 * @throws PortalException if a auth with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.Auth getAuth(String key)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authLocalService.getAuth(key);
	}

	/**
	 * Returns a range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @return the range of auths
	 */
	@Override
	public java.util.List<it.eng.allerta.messages.services.model.Auth> getAuths(
		int start, int end) {

		return _authLocalService.getAuths(start, end);
	}

	/**
	 * Returns the number of auths.
	 *
	 * @return the number of auths
	 */
	@Override
	public int getAuthsCount() {
		return _authLocalService.getAuthsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _authLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the auth in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auth the auth
	 * @return the auth that was updated
	 */
	@Override
	public it.eng.allerta.messages.services.model.Auth updateAuth(
		it.eng.allerta.messages.services.model.Auth auth) {

		return _authLocalService.updateAuth(auth);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _authLocalService.getBasePersistence();
	}

	@Override
	public AuthLocalService getWrappedService() {
		return _authLocalService;
	}

	@Override
	public void setWrappedService(AuthLocalService authLocalService) {
		_authLocalService = authLocalService;
	}

	private AuthLocalService _authLocalService;

}