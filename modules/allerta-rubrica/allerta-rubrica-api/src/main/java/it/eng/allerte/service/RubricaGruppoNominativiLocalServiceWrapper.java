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
 * Provides a wrapper for {@link RubricaGruppoNominativiLocalService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiLocalService
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiLocalServiceWrapper
	implements RubricaGruppoNominativiLocalService,
			   ServiceWrapper<RubricaGruppoNominativiLocalService> {

	public RubricaGruppoNominativiLocalServiceWrapper(
		RubricaGruppoNominativiLocalService
			rubricaGruppoNominativiLocalService) {

		_rubricaGruppoNominativiLocalService =
			rubricaGruppoNominativiLocalService;
	}

	/**
	 * Adds the rubrica gruppo nominativi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
		addRubricaGruppoNominativi(
			it.eng.allerte.model.RubricaGruppoNominativi
				rubricaGruppoNominativi) {

		return _rubricaGruppoNominativiLocalService.addRubricaGruppoNominativi(
			rubricaGruppoNominativi);
	}

	/**
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
		createRubricaGruppoNominativi(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK) {

		return _rubricaGruppoNominativiLocalService.
			createRubricaGruppoNominativi(rubricaGruppoNominativiPK);
	}

	@Override
	public void deleteNominativoDaGruppo(Long fkGruppo, Long fkNominativo) {
		_rubricaGruppoNominativiLocalService.deleteNominativoDaGruppo(
			fkGruppo, fkNominativo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoNominativiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica gruppo nominativi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
		deleteRubricaGruppoNominativi(
			it.eng.allerte.model.RubricaGruppoNominativi
				rubricaGruppoNominativi) {

		return _rubricaGruppoNominativiLocalService.
			deleteRubricaGruppoNominativi(rubricaGruppoNominativi);
	}

	/**
	 * Deletes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws PortalException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
			deleteRubricaGruppoNominativi(
				it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
					rubricaGruppoNominativiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoNominativiLocalService.
			deleteRubricaGruppoNominativi(rubricaGruppoNominativiPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaGruppoNominativiLocalService.dynamicQuery();
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

		return _rubricaGruppoNominativiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaGruppoNominativiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaGruppoNominativiLocalService.dynamicQuery(
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

		return _rubricaGruppoNominativiLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _rubricaGruppoNominativiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
		fetchRubricaGruppoNominativi(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK) {

		return _rubricaGruppoNominativiLocalService.
			fetchRubricaGruppoNominativi(rubricaGruppoNominativiPK);
	}

	@Override
	public java.util.List<it.eng.allerte.model.RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(Long idNominativo) {

		return _rubricaGruppoNominativiLocalService.
			findByRubricaGruppoRuoloByNominativo(idNominativo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaGruppoNominativiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaGruppoNominativiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	@Override
	public java.util.Set<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroup(Long ownerId, Long groupId) {

		return _rubricaGruppoNominativiLocalService.getNominativeForGroup(
			ownerId, groupId);
	}

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroupPortal(Long ownerId) {

		return _rubricaGruppoNominativiLocalService.getNominativeForGroupPortal(
			ownerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaGruppoNominativiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoNominativiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws PortalException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
			getRubricaGruppoNominativi(
				it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
					rubricaGruppoNominativiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoNominativiLocalService.getRubricaGruppoNominativi(
			rubricaGruppoNominativiPK);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of rubrica gruppo nominativis
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaGruppoNominativi>
		getRubricaGruppoNominativis(int start, int end) {

		return _rubricaGruppoNominativiLocalService.getRubricaGruppoNominativis(
			start, end);
	}

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	@Override
	public int getRubricaGruppoNominativisCount() {
		return _rubricaGruppoNominativiLocalService.
			getRubricaGruppoNominativisCount();
	}

	@Override
	public java.util.List<Object[]> loadByidRuolo(Long idRuolo) {
		return _rubricaGruppoNominativiLocalService.loadByidRuolo(idRuolo);
	}

	@Override
	public java.util.List<Object[]> loadNominativiGruppo(
		Long idGruppo, Long idSite) {

		return _rubricaGruppoNominativiLocalService.loadNominativiGruppo(
			idGruppo, idSite);
	}

	/**
	 * Updates the rubrica gruppo nominativi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi
		updateRubricaGruppoNominativi(
			it.eng.allerte.model.RubricaGruppoNominativi
				rubricaGruppoNominativi) {

		return _rubricaGruppoNominativiLocalService.
			updateRubricaGruppoNominativi(rubricaGruppoNominativi);
	}

	@Override
	public RubricaGruppoNominativiLocalService getWrappedService() {
		return _rubricaGruppoNominativiLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaGruppoNominativiLocalService
			rubricaGruppoNominativiLocalService) {

		_rubricaGruppoNominativiLocalService =
			rubricaGruppoNominativiLocalService;
	}

	private RubricaGruppoNominativiLocalService
		_rubricaGruppoNominativiLocalService;

}