/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AttivazioneFiumeLocalService}.
 *
 * @author GFAVINI
 * @see AttivazioneFiumeLocalService
 * @generated
 */
public class AttivazioneFiumeLocalServiceWrapper
	implements AttivazioneFiumeLocalService,
			   ServiceWrapper<AttivazioneFiumeLocalService> {

	public AttivazioneFiumeLocalServiceWrapper() {
		this(null);
	}

	public AttivazioneFiumeLocalServiceWrapper(
		AttivazioneFiumeLocalService attivazioneFiumeLocalService) {

		_attivazioneFiumeLocalService = attivazioneFiumeLocalService;
	}

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
	@Override
	public it.eng.bollettino.model.AttivazioneFiume addAttivazioneFiume(
		it.eng.bollettino.model.AttivazioneFiume attivazioneFiume) {

		return _attivazioneFiumeLocalService.addAttivazioneFiume(
			attivazioneFiume);
	}

	/**
	 * Creates a new attivazione fiume with the primary key. Does not add the attivazione fiume to the database.
	 *
	 * @param fiumeId the primary key for the new attivazione fiume
	 * @return the new attivazione fiume
	 */
	@Override
	public it.eng.bollettino.model.AttivazioneFiume createAttivazioneFiume(
		String fiumeId) {

		return _attivazioneFiumeLocalService.createAttivazioneFiume(fiumeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivazioneFiumeLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public it.eng.bollettino.model.AttivazioneFiume deleteAttivazioneFiume(
		it.eng.bollettino.model.AttivazioneFiume attivazioneFiume) {

		return _attivazioneFiumeLocalService.deleteAttivazioneFiume(
			attivazioneFiume);
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
	@Override
	public it.eng.bollettino.model.AttivazioneFiume deleteAttivazioneFiume(
			String fiumeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivazioneFiumeLocalService.deleteAttivazioneFiume(fiumeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivazioneFiumeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _attivazioneFiumeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _attivazioneFiumeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attivazioneFiumeLocalService.dynamicQuery();
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

		return _attivazioneFiumeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _attivazioneFiumeLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _attivazioneFiumeLocalService.dynamicQuery(
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

		return _attivazioneFiumeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _attivazioneFiumeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.AttivazioneFiume fetchAttivazioneFiume(
		String fiumeId) {

		return _attivazioneFiumeLocalService.fetchAttivazioneFiume(fiumeId);
	}

	/**
	 * Returns the attivazione fiume with the primary key.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws PortalException if a attivazione fiume with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.AttivazioneFiume getAttivazioneFiume(
			String fiumeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivazioneFiumeLocalService.getAttivazioneFiume(fiumeId);
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
	@Override
	public java.util.List<it.eng.bollettino.model.AttivazioneFiume>
		getAttivazioneFiumes(int start, int end) {

		return _attivazioneFiumeLocalService.getAttivazioneFiumes(start, end);
	}

	/**
	 * Returns the number of attivazione fiumes.
	 *
	 * @return the number of attivazione fiumes
	 */
	@Override
	public int getAttivazioneFiumesCount() {
		return _attivazioneFiumeLocalService.getAttivazioneFiumesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attivazioneFiumeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attivazioneFiumeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.bollettino.model.AttivazioneFiume updateAttivazioneFiume(
		it.eng.bollettino.model.AttivazioneFiume attivazioneFiume) {

		return _attivazioneFiumeLocalService.updateAttivazioneFiume(
			attivazioneFiume);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _attivazioneFiumeLocalService.getBasePersistence();
	}

	@Override
	public AttivazioneFiumeLocalService getWrappedService() {
		return _attivazioneFiumeLocalService;
	}

	@Override
	public void setWrappedService(
		AttivazioneFiumeLocalService attivazioneFiumeLocalService) {

		_attivazioneFiumeLocalService = attivazioneFiumeLocalService;
	}

	private AttivazioneFiumeLocalService _attivazioneFiumeLocalService;

}