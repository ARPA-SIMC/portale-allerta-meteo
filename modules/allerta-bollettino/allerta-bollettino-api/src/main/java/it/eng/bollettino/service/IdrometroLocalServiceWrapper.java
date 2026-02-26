/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link IdrometroLocalService}.
 *
 * @author GFAVINI
 * @see IdrometroLocalService
 * @generated
 */
public class IdrometroLocalServiceWrapper
	implements IdrometroLocalService, ServiceWrapper<IdrometroLocalService> {

	public IdrometroLocalServiceWrapper() {
		this(null);
	}

	public IdrometroLocalServiceWrapper(
		IdrometroLocalService idrometroLocalService) {

		_idrometroLocalService = idrometroLocalService;
	}

	/**
	 * Adds the idrometro to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdrometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idrometro the idrometro
	 * @return the idrometro that was added
	 */
	@Override
	public it.eng.bollettino.model.Idrometro addIdrometro(
		it.eng.bollettino.model.Idrometro idrometro) {

		return _idrometroLocalService.addIdrometro(idrometro);
	}

	/**
	 * Creates a new idrometro with the primary key. Does not add the idrometro to the database.
	 *
	 * @param stazioneId the primary key for the new idrometro
	 * @return the new idrometro
	 */
	@Override
	public it.eng.bollettino.model.Idrometro createIdrometro(
		String stazioneId) {

		return _idrometroLocalService.createIdrometro(stazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idrometroLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the idrometro from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdrometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idrometro the idrometro
	 * @return the idrometro that was removed
	 */
	@Override
	public it.eng.bollettino.model.Idrometro deleteIdrometro(
		it.eng.bollettino.model.Idrometro idrometro) {

		return _idrometroLocalService.deleteIdrometro(idrometro);
	}

	/**
	 * Deletes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdrometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws PortalException if a idrometro with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Idrometro deleteIdrometro(String stazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idrometroLocalService.deleteIdrometro(stazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idrometroLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _idrometroLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _idrometroLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _idrometroLocalService.dynamicQuery();
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

		return _idrometroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IdrometroModelImpl</code>.
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

		return _idrometroLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IdrometroModelImpl</code>.
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

		return _idrometroLocalService.dynamicQuery(
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

		return _idrometroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _idrometroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Idrometro fetchIdrometro(String stazioneId) {
		return _idrometroLocalService.fetchIdrometro(stazioneId);
	}

	/**
	 * Returns the idrometro with the primary key.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro
	 * @throws PortalException if a idrometro with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Idrometro getIdrometro(String stazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idrometroLocalService.getIdrometro(stazioneId);
	}

	/**
	 * Returns a range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of idrometros
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Idrometro> getIdrometros(
		int start, int end) {

		return _idrometroLocalService.getIdrometros(start, end);
	}

	/**
	 * Returns the number of idrometros.
	 *
	 * @return the number of idrometros
	 */
	@Override
	public int getIdrometrosCount() {
		return _idrometroLocalService.getIdrometrosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _idrometroLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _idrometroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the idrometro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IdrometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idrometro the idrometro
	 * @return the idrometro that was updated
	 */
	@Override
	public it.eng.bollettino.model.Idrometro updateIdrometro(
		it.eng.bollettino.model.Idrometro idrometro) {

		return _idrometroLocalService.updateIdrometro(idrometro);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _idrometroLocalService.getBasePersistence();
	}

	@Override
	public IdrometroLocalService getWrappedService() {
		return _idrometroLocalService;
	}

	@Override
	public void setWrappedService(IdrometroLocalService idrometroLocalService) {
		_idrometroLocalService = idrometroLocalService;
	}

	private IdrometroLocalService _idrometroLocalService;

}