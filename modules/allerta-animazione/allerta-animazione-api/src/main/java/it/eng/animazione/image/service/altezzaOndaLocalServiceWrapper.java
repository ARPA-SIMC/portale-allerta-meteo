/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link altezzaOndaLocalService}.
 *
 * @author UTENTE
 * @see altezzaOndaLocalService
 * @generated
 */
public class altezzaOndaLocalServiceWrapper
	implements altezzaOndaLocalService,
			   ServiceWrapper<altezzaOndaLocalService> {

	public altezzaOndaLocalServiceWrapper() {
		this(null);
	}

	public altezzaOndaLocalServiceWrapper(
		altezzaOndaLocalService altezzaOndaLocalService) {

		_altezzaOndaLocalService = altezzaOndaLocalService;
	}

	/**
	 * Adds the altezza onda to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOnda the altezza onda
	 * @return the altezza onda that was added
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOnda addaltezzaOnda(
		it.eng.animazione.image.model.altezzaOnda altezzaOnda) {

		return _altezzaOndaLocalService.addaltezzaOnda(altezzaOnda);
	}

	/**
	 * Creates a new altezza onda with the primary key. Does not add the altezza onda to the database.
	 *
	 * @param id the primary key for the new altezza onda
	 * @return the new altezza onda
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOnda createaltezzaOnda(
		long id) {

		return _altezzaOndaLocalService.createaltezzaOnda(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the altezza onda from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOnda the altezza onda
	 * @return the altezza onda that was removed
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOnda deletealtezzaOnda(
		it.eng.animazione.image.model.altezzaOnda altezzaOnda) {

		return _altezzaOndaLocalService.deletealtezzaOnda(altezzaOnda);
	}

	/**
	 * Deletes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws PortalException if a altezza onda with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOnda deletealtezzaOnda(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaLocalService.deletealtezzaOnda(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _altezzaOndaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _altezzaOndaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _altezzaOndaLocalService.dynamicQuery();
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

		return _altezzaOndaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaModelImpl</code>.
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

		return _altezzaOndaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaModelImpl</code>.
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

		return _altezzaOndaLocalService.dynamicQuery(
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

		return _altezzaOndaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _altezzaOndaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animazione.image.model.altezzaOnda fetchaltezzaOnda(long id) {
		return _altezzaOndaLocalService.fetchaltezzaOnda(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _altezzaOndaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the altezza onda with the primary key.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws PortalException if a altezza onda with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOnda getaltezzaOnda(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaLocalService.getaltezzaOnda(id);
	}

	/**
	 * Returns a range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @return the range of altezza ondas
	 */
	@Override
	public java.util.List<it.eng.animazione.image.model.altezzaOnda>
		getaltezzaOndas(int start, int end) {

		return _altezzaOndaLocalService.getaltezzaOndas(start, end);
	}

	/**
	 * Returns the number of altezza ondas.
	 *
	 * @return the number of altezza ondas
	 */
	@Override
	public int getaltezzaOndasCount() {
		return _altezzaOndaLocalService.getaltezzaOndasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _altezzaOndaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _altezzaOndaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the altezza onda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect altezzaOndaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param altezzaOnda the altezza onda
	 * @return the altezza onda that was updated
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOnda updatealtezzaOnda(
		it.eng.animazione.image.model.altezzaOnda altezzaOnda) {

		return _altezzaOndaLocalService.updatealtezzaOnda(altezzaOnda);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _altezzaOndaLocalService.getBasePersistence();
	}

	@Override
	public altezzaOndaLocalService getWrappedService() {
		return _altezzaOndaLocalService;
	}

	@Override
	public void setWrappedService(
		altezzaOndaLocalService altezzaOndaLocalService) {

		_altezzaOndaLocalService = altezzaOndaLocalService;
	}

	private altezzaOndaLocalService _altezzaOndaLocalService;

}