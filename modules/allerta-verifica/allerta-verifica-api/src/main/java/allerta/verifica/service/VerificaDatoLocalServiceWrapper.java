/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package allerta.verifica.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VerificaDatoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDatoLocalService
 * @generated
 */
@ProviderType
public class VerificaDatoLocalServiceWrapper
	implements VerificaDatoLocalService,
			   ServiceWrapper<VerificaDatoLocalService> {

	public VerificaDatoLocalServiceWrapper(
		VerificaDatoLocalService verificaDatoLocalService) {

		_verificaDatoLocalService = verificaDatoLocalService;
	}

	/**
	 * Adds the verifica dato to the database. Also notifies the appropriate model listeners.
	 *
	 * @param verificaDato the verifica dato
	 * @return the verifica dato that was added
	 */
	@Override
	public allerta.verifica.model.VerificaDato addVerificaDato(
		allerta.verifica.model.VerificaDato verificaDato) {

		return _verificaDatoLocalService.addVerificaDato(verificaDato);
	}

	/**
	 * Creates a new verifica dato with the primary key. Does not add the verifica dato to the database.
	 *
	 * @param id the primary key for the new verifica dato
	 * @return the new verifica dato
	 */
	@Override
	public allerta.verifica.model.VerificaDato createVerificaDato(long id) {
		return _verificaDatoLocalService.createVerificaDato(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaDatoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws PortalException if a verifica dato with the primary key could not be found
	 */
	@Override
	public allerta.verifica.model.VerificaDato deleteVerificaDato(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaDatoLocalService.deleteVerificaDato(id);
	}

	/**
	 * Deletes the verifica dato from the database. Also notifies the appropriate model listeners.
	 *
	 * @param verificaDato the verifica dato
	 * @return the verifica dato that was removed
	 */
	@Override
	public allerta.verifica.model.VerificaDato deleteVerificaDato(
		allerta.verifica.model.VerificaDato verificaDato) {

		return _verificaDatoLocalService.deleteVerificaDato(verificaDato);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _verificaDatoLocalService.dynamicQuery();
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

		return _verificaDatoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _verificaDatoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _verificaDatoLocalService.dynamicQuery(
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

		return _verificaDatoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _verificaDatoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public allerta.verifica.model.VerificaDato fetchVerificaDato(long id) {
		return _verificaDatoLocalService.fetchVerificaDato(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _verificaDatoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _verificaDatoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verificaDatoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaDatoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the verifica dato with the primary key.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws PortalException if a verifica dato with the primary key could not be found
	 */
	@Override
	public allerta.verifica.model.VerificaDato getVerificaDato(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaDatoLocalService.getVerificaDato(id);
	}

	/**
	 * Returns a range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaDatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of verifica datos
	 */
	@Override
	public java.util.List<allerta.verifica.model.VerificaDato> getVerificaDatos(
		int start, int end) {

		return _verificaDatoLocalService.getVerificaDatos(start, end);
	}

	/**
	 * Returns the number of verifica datos.
	 *
	 * @return the number of verifica datos
	 */
	@Override
	public int getVerificaDatosCount() {
		return _verificaDatoLocalService.getVerificaDatosCount();
	}

	/**
	 * Updates the verifica dato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param verificaDato the verifica dato
	 * @return the verifica dato that was updated
	 */
	@Override
	public allerta.verifica.model.VerificaDato updateVerificaDato(
		allerta.verifica.model.VerificaDato verificaDato) {

		return _verificaDatoLocalService.updateVerificaDato(verificaDato);
	}

	@Override
	public VerificaDatoLocalService getWrappedService() {
		return _verificaDatoLocalService;
	}

	@Override
	public void setWrappedService(
		VerificaDatoLocalService verificaDatoLocalService) {

		_verificaDatoLocalService = verificaDatoLocalService;
	}

	private VerificaDatoLocalService _verificaDatoLocalService;

}