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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaContattoLocalService}.
 *
 * @author Pratola_L
 * @see RubricaContattoLocalService
 * @generated
 */
@ProviderType
public class RubricaContattoLocalServiceWrapper
	implements RubricaContattoLocalService,
			   ServiceWrapper<RubricaContattoLocalService> {

	public RubricaContattoLocalServiceWrapper(
		RubricaContattoLocalService rubricaContattoLocalService) {

		_rubricaContattoLocalService = rubricaContattoLocalService;
	}

	/**
	 * Adds the rubrica contatto to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaContatto the rubrica contatto
	 * @return the rubrica contatto that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaContatto addRubricaContatto(
		it.eng.allerte.model.RubricaContatto rubricaContatto) {

		return _rubricaContattoLocalService.addRubricaContatto(rubricaContatto);
	}

	/**
	 * Creates a new rubrica contatto with the primary key. Does not add the rubrica contatto to the database.
	 *
	 * @param ID_CONTATTO the primary key for the new rubrica contatto
	 * @return the new rubrica contatto
	 */
	@Override
	public it.eng.allerte.model.RubricaContatto createRubricaContatto(
		long ID_CONTATTO) {

		return _rubricaContattoLocalService.createRubricaContatto(ID_CONTATTO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaContattoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws PortalException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaContatto deleteRubricaContatto(
			long ID_CONTATTO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaContattoLocalService.deleteRubricaContatto(ID_CONTATTO);
	}

	/**
	 * Deletes the rubrica contatto from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaContatto the rubrica contatto
	 * @return the rubrica contatto that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaContatto deleteRubricaContatto(
		it.eng.allerte.model.RubricaContatto rubricaContatto) {

		return _rubricaContattoLocalService.deleteRubricaContatto(
			rubricaContatto);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaContattoLocalService.dynamicQuery();
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

		return _rubricaContattoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaContattoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaContattoLocalService.dynamicQuery(
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

		return _rubricaContattoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaContattoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaContatto fetchRubricaContatto(
		long ID_CONTATTO) {

		return _rubricaContattoLocalService.fetchRubricaContatto(ID_CONTATTO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaContattoLocalService.getActionableDynamicQuery();
	}

	/**
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 *
	 * @param idNominative
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominative(long idNominative) {

		return _rubricaContattoLocalService.getContactByNominative(
			idNominative);
	}

	/**
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 *
	 * @param idUserPortal
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominativePortal(long idUserPortal) {

		return _rubricaContattoLocalService.getContactByNominativePortal(
			idUserPortal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaContattoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaContattoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaContattoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica contatto with the primary key.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws PortalException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaContatto getRubricaContatto(
			long ID_CONTATTO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaContattoLocalService.getRubricaContatto(ID_CONTATTO);
	}

	/**
	 * Returns a range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of rubrica contattos
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaContatto>
		getRubricaContattos(int start, int end) {

		return _rubricaContattoLocalService.getRubricaContattos(start, end);
	}

	/**
	 * Returns the number of rubrica contattos.
	 *
	 * @return the number of rubrica contattos
	 */
	@Override
	public int getRubricaContattosCount() {
		return _rubricaContattoLocalService.getRubricaContattosCount();
	}

	@Override
	public java.util.ArrayList<Object[]> loadByNominativo(Long idNominativo) {
		return _rubricaContattoLocalService.loadByNominativo(idNominativo);
	}

	/**
	 * Updates the rubrica contatto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaContatto the rubrica contatto
	 * @return the rubrica contatto that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaContatto updateRubricaContatto(
		it.eng.allerte.model.RubricaContatto rubricaContatto) {

		return _rubricaContattoLocalService.updateRubricaContatto(
			rubricaContatto);
	}

	@Override
	public RubricaContattoLocalService getWrappedService() {
		return _rubricaContattoLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaContattoLocalService rubricaContattoLocalService) {

		_rubricaContattoLocalService = rubricaContattoLocalService;
	}

	private RubricaContattoLocalService _rubricaContattoLocalService;

}