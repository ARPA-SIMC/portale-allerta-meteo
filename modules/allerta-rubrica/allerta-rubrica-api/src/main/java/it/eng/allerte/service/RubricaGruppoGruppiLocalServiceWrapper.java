/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RubricaGruppoGruppiLocalService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiLocalService
 * @generated
 */
public class RubricaGruppoGruppiLocalServiceWrapper
	implements RubricaGruppoGruppiLocalService,
			   ServiceWrapper<RubricaGruppoGruppiLocalService> {

	public RubricaGruppoGruppiLocalServiceWrapper() {
		this(null);
	}

	public RubricaGruppoGruppiLocalServiceWrapper(
		RubricaGruppoGruppiLocalService rubricaGruppoGruppiLocalService) {

		_rubricaGruppoGruppiLocalService = rubricaGruppoGruppiLocalService;
	}

	/**
	 * Adds the rubrica gruppo gruppi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoGruppiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi addRubricaGruppoGruppi(
		it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return _rubricaGruppoGruppiLocalService.addRubricaGruppoGruppi(
			rubricaGruppoGruppi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoGruppiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new rubrica gruppo gruppi with the primary key. Does not add the rubrica gruppo gruppi to the database.
	 *
	 * @param rubricaGruppoGruppiPK the primary key for the new rubrica gruppo gruppi
	 * @return the new rubrica gruppo gruppi
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi createRubricaGruppoGruppi(
		it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
			rubricaGruppoGruppiPK) {

		return _rubricaGruppoGruppiLocalService.createRubricaGruppoGruppi(
			rubricaGruppoGruppiPK);
	}

	@Override
	public void deleteGruppoSottoGruppo(Long fkGruppo, Long fkSottoGruppo) {
		_rubricaGruppoGruppiLocalService.deleteGruppoSottoGruppo(
			fkGruppo, fkSottoGruppo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoGruppiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica gruppo gruppi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoGruppiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi deleteRubricaGruppoGruppi(
		it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return _rubricaGruppoGruppiLocalService.deleteRubricaGruppoGruppi(
			rubricaGruppoGruppi);
	}

	/**
	 * Deletes the rubrica gruppo gruppi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoGruppiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 * @throws PortalException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi deleteRubricaGruppoGruppi(
			it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
				rubricaGruppoGruppiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoGruppiLocalService.deleteRubricaGruppoGruppi(
			rubricaGruppoGruppiPK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rubricaGruppoGruppiLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rubricaGruppoGruppiLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaGruppoGruppiLocalService.dynamicQuery();
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

		return _rubricaGruppoGruppiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl</code>.
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

		return _rubricaGruppoGruppiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl</code>.
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

		return _rubricaGruppoGruppiLocalService.dynamicQuery(
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

		return _rubricaGruppoGruppiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaGruppoGruppiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi fetchRubricaGruppoGruppi(
		it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
			rubricaGruppoGruppiPK) {

		return _rubricaGruppoGruppiLocalService.fetchRubricaGruppoGruppi(
			rubricaGruppoGruppiPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaGruppoGruppiLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.ArrayList<Object[]> getGruppiFigli(Long fkGruppoPadre) {
		return _rubricaGruppoGruppiLocalService.getGruppiFigli(fkGruppoPadre);
	}

	@Override
	public java.util.ArrayList<Object[]> getGruppiPadriPerFiglio(
		Long fkGruppoPadre) {

		return _rubricaGruppoGruppiLocalService.getGruppiPadriPerFiglio(
			fkGruppoPadre);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaGruppoGruppiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaGruppoGruppiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoGruppiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi
	 * @throws PortalException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi getRubricaGruppoGruppi(
			it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
				rubricaGruppoGruppiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoGruppiLocalService.getRubricaGruppoGruppi(
			rubricaGruppoGruppiPK);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of rubrica gruppo gruppis
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaGruppoGruppi>
		getRubricaGruppoGruppis(int start, int end) {

		return _rubricaGruppoGruppiLocalService.getRubricaGruppoGruppis(
			start, end);
	}

	/**
	 * Returns the number of rubrica gruppo gruppis.
	 *
	 * @return the number of rubrica gruppo gruppis
	 */
	@Override
	public int getRubricaGruppoGruppisCount() {
		return _rubricaGruppoGruppiLocalService.getRubricaGruppoGruppisCount();
	}

	/**
	 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
	 *
	 * @param idGroup
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaGruppo> getSubGroups(
		long idGroup) {

		return _rubricaGruppoGruppiLocalService.getSubGroups(idGroup);
	}

	/**
	 * Updates the rubrica gruppo gruppi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoGruppiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi updateRubricaGruppoGruppi(
		it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return _rubricaGruppoGruppiLocalService.updateRubricaGruppoGruppi(
			rubricaGruppoGruppi);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _rubricaGruppoGruppiLocalService.getBasePersistence();
	}

	@Override
	public RubricaGruppoGruppiLocalService getWrappedService() {
		return _rubricaGruppoGruppiLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaGruppoGruppiLocalService rubricaGruppoGruppiLocalService) {

		_rubricaGruppoGruppiLocalService = rubricaGruppoGruppiLocalService;
	}

	private RubricaGruppoGruppiLocalService _rubricaGruppoGruppiLocalService;

}