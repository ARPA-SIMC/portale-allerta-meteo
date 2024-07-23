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
 * Provides a wrapper for {@link VerificaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaLocalService
 * @generated
 */
@ProviderType
public class VerificaLocalServiceWrapper
	implements VerificaLocalService, ServiceWrapper<VerificaLocalService> {

	public VerificaLocalServiceWrapper(
		VerificaLocalService verificaLocalService) {

		_verificaLocalService = verificaLocalService;
	}

	/**
	 * Adds the verifica to the database. Also notifies the appropriate model listeners.
	 *
	 * @param verifica the verifica
	 * @return the verifica that was added
	 */
	@Override
	public allerta.verifica.model.Verifica addVerifica(
		allerta.verifica.model.Verifica verifica) {

		return _verificaLocalService.addVerifica(verifica);
	}

	/**
	 * Creates a new verifica with the primary key. Does not add the verifica to the database.
	 *
	 * @param id the primary key for the new verifica
	 * @return the new verifica
	 */
	@Override
	public allerta.verifica.model.Verifica createVerifica(long id) {
		return _verificaLocalService.createVerifica(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws PortalException if a verifica with the primary key could not be found
	 */
	@Override
	public allerta.verifica.model.Verifica deleteVerifica(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaLocalService.deleteVerifica(id);
	}

	/**
	 * Deletes the verifica from the database. Also notifies the appropriate model listeners.
	 *
	 * @param verifica the verifica
	 * @return the verifica that was removed
	 */
	@Override
	public allerta.verifica.model.Verifica deleteVerifica(
		allerta.verifica.model.Verifica verifica) {

		return _verificaLocalService.deleteVerifica(verifica);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _verificaLocalService.dynamicQuery();
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

		return _verificaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _verificaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _verificaLocalService.dynamicQuery(
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

		return _verificaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _verificaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public allerta.verifica.model.Verifica fetchVerifica(long id) {
		return _verificaLocalService.fetchVerifica(id);
	}

	/**
	 * Returns the verifica matching the UUID and group.
	 *
	 * @param uuid the verifica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public allerta.verifica.model.Verifica fetchVerificaByUuidAndGroupId(
		String uuid, long groupId) {

		return _verificaLocalService.fetchVerificaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _verificaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _verificaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _verificaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verificaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the verifica with the primary key.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica
	 * @throws PortalException if a verifica with the primary key could not be found
	 */
	@Override
	public allerta.verifica.model.Verifica getVerifica(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaLocalService.getVerifica(id);
	}

	/**
	 * Returns the verifica matching the UUID and group.
	 *
	 * @param uuid the verifica's UUID
	 * @param groupId the primary key of the group
	 * @return the matching verifica
	 * @throws PortalException if a matching verifica could not be found
	 */
	@Override
	public allerta.verifica.model.Verifica getVerificaByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verificaLocalService.getVerificaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.VerificaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of verificas
	 */
	@Override
	public java.util.List<allerta.verifica.model.Verifica> getVerificas(
		int start, int end) {

		return _verificaLocalService.getVerificas(start, end);
	}

	/**
	 * Returns all the verificas matching the UUID and company.
	 *
	 * @param uuid the UUID of the verificas
	 * @param companyId the primary key of the company
	 * @return the matching verificas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<allerta.verifica.model.Verifica>
		getVerificasByUuidAndCompanyId(String uuid, long companyId) {

		return _verificaLocalService.getVerificasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of verificas matching the UUID and company.
	 *
	 * @param uuid the UUID of the verificas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching verificas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<allerta.verifica.model.Verifica>
		getVerificasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<allerta.verifica.model.Verifica> orderByComparator) {

		return _verificaLocalService.getVerificasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of verificas.
	 *
	 * @return the number of verificas
	 */
	@Override
	public int getVerificasCount() {
		return _verificaLocalService.getVerificasCount();
	}

	@Override
	public allerta.verifica.model.VerificaDato insertVerificaDato(
		long doc, java.util.Date giorno, String zona, Long evento,
		String nomeDato, Integer prog, String datoCalcolato) {

		return _verificaLocalService.insertVerificaDato(
			doc, giorno, zona, evento, nomeDato, prog, datoCalcolato);
	}

	/**
	 * Updates the verifica in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param verifica the verifica
	 * @return the verifica that was updated
	 */
	@Override
	public allerta.verifica.model.Verifica updateVerifica(
		allerta.verifica.model.Verifica verifica) {

		return _verificaLocalService.updateVerifica(verifica);
	}

	@Override
	public VerificaLocalService getWrappedService() {
		return _verificaLocalService;
	}

	@Override
	public void setWrappedService(VerificaLocalService verificaLocalService) {
		_verificaLocalService = verificaLocalService;
	}

	private VerificaLocalService _verificaLocalService;

}