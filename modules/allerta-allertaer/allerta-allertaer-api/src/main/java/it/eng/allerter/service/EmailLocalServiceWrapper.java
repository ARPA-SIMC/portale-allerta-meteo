/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmailLocalService}.
 *
 * @author GFAVINI
 * @see EmailLocalService
 * @generated
 */
public class EmailLocalServiceWrapper
	implements EmailLocalService, ServiceWrapper<EmailLocalService> {

	public EmailLocalServiceWrapper() {
		this(null);
	}

	public EmailLocalServiceWrapper(EmailLocalService emailLocalService) {
		_emailLocalService = emailLocalService;
	}

	/**
	 * Adds the email to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param email the email
	 * @return the email that was added
	 */
	@Override
	public it.eng.allerter.model.Email addEmail(
		it.eng.allerter.model.Email email) {

		return _emailLocalService.addEmail(email);
	}

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	@Override
	public it.eng.allerter.model.Email createEmail(long id) {
		return _emailLocalService.createEmail(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the email from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param email the email
	 * @return the email that was removed
	 */
	@Override
	public it.eng.allerter.model.Email deleteEmail(
		it.eng.allerter.model.Email email) {

		return _emailLocalService.deleteEmail(email);
	}

	/**
	 * Deletes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws PortalException if a email with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.Email deleteEmail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailLocalService.deleteEmail(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _emailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _emailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailLocalService.dynamicQuery();
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

		return _emailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.EmailModelImpl</code>.
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

		return _emailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.EmailModelImpl</code>.
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

		return _emailLocalService.dynamicQuery(
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

		return _emailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _emailLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.Email fetchEmail(long id) {
		return _emailLocalService.fetchEmail(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the email with the primary key.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws PortalException if a email with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.Email getEmail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailLocalService.getEmail(id);
	}

	/**
	 * Returns a range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.EmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of emails
	 */
	@Override
	public java.util.List<it.eng.allerter.model.Email> getEmails(
		int start, int end) {

		return _emailLocalService.getEmails(start, end);
	}

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	@Override
	public int getEmailsCount() {
		return _emailLocalService.getEmailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param email the email
	 * @return the email that was updated
	 */
	@Override
	public it.eng.allerter.model.Email updateEmail(
		it.eng.allerter.model.Email email) {

		return _emailLocalService.updateEmail(email);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _emailLocalService.getBasePersistence();
	}

	@Override
	public EmailLocalService getWrappedService() {
		return _emailLocalService;
	}

	@Override
	public void setWrappedService(EmailLocalService emailLocalService) {
		_emailLocalService = emailLocalService;
	}

	private EmailLocalService _emailLocalService;

}