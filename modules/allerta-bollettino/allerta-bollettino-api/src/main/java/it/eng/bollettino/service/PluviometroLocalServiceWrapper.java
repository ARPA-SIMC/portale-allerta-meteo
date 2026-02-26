/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PluviometroLocalService}.
 *
 * @author GFAVINI
 * @see PluviometroLocalService
 * @generated
 */
public class PluviometroLocalServiceWrapper
	implements PluviometroLocalService,
			   ServiceWrapper<PluviometroLocalService> {

	public PluviometroLocalServiceWrapper() {
		this(null);
	}

	public PluviometroLocalServiceWrapper(
		PluviometroLocalService pluviometroLocalService) {

		_pluviometroLocalService = pluviometroLocalService;
	}

	/**
	 * Adds the pluviometro to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PluviometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pluviometro the pluviometro
	 * @return the pluviometro that was added
	 */
	@Override
	public it.eng.bollettino.model.Pluviometro addPluviometro(
		it.eng.bollettino.model.Pluviometro pluviometro) {

		return _pluviometroLocalService.addPluviometro(pluviometro);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pluviometroLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pluviometro with the primary key. Does not add the pluviometro to the database.
	 *
	 * @param stazioneId the primary key for the new pluviometro
	 * @return the new pluviometro
	 */
	@Override
	public it.eng.bollettino.model.Pluviometro createPluviometro(
		String stazioneId) {

		return _pluviometroLocalService.createPluviometro(stazioneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pluviometroLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pluviometro from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PluviometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pluviometro the pluviometro
	 * @return the pluviometro that was removed
	 */
	@Override
	public it.eng.bollettino.model.Pluviometro deletePluviometro(
		it.eng.bollettino.model.Pluviometro pluviometro) {

		return _pluviometroLocalService.deletePluviometro(pluviometro);
	}

	/**
	 * Deletes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PluviometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws PortalException if a pluviometro with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Pluviometro deletePluviometro(
			String stazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pluviometroLocalService.deletePluviometro(stazioneId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pluviometroLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pluviometroLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pluviometroLocalService.dynamicQuery();
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

		return _pluviometroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.PluviometroModelImpl</code>.
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

		return _pluviometroLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.PluviometroModelImpl</code>.
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

		return _pluviometroLocalService.dynamicQuery(
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

		return _pluviometroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pluviometroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Pluviometro fetchPluviometro(
		String stazioneId) {

		return _pluviometroLocalService.fetchPluviometro(stazioneId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pluviometroLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pluviometroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pluviometro with the primary key.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws PortalException if a pluviometro with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Pluviometro getPluviometro(String stazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pluviometroLocalService.getPluviometro(stazioneId);
	}

	/**
	 * Returns a range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of pluviometros
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Pluviometro> getPluviometros(
		int start, int end) {

		return _pluviometroLocalService.getPluviometros(start, end);
	}

	/**
	 * Returns the number of pluviometros.
	 *
	 * @return the number of pluviometros
	 */
	@Override
	public int getPluviometrosCount() {
		return _pluviometroLocalService.getPluviometrosCount();
	}

	/**
	 * Updates the pluviometro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PluviometroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pluviometro the pluviometro
	 * @return the pluviometro that was updated
	 */
	@Override
	public it.eng.bollettino.model.Pluviometro updatePluviometro(
		it.eng.bollettino.model.Pluviometro pluviometro) {

		return _pluviometroLocalService.updatePluviometro(pluviometro);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _pluviometroLocalService.getBasePersistence();
	}

	@Override
	public PluviometroLocalService getWrappedService() {
		return _pluviometroLocalService;
	}

	@Override
	public void setWrappedService(
		PluviometroLocalService pluviometroLocalService) {

		_pluviometroLocalService = pluviometroLocalService;
	}

	private PluviometroLocalService _pluviometroLocalService;

}