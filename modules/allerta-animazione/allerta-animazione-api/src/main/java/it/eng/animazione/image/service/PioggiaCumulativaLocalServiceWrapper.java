/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PioggiaCumulativaLocalService}.
 *
 * @author UTENTE
 * @see PioggiaCumulativaLocalService
 * @generated
 */
public class PioggiaCumulativaLocalServiceWrapper
	implements PioggiaCumulativaLocalService,
			   ServiceWrapper<PioggiaCumulativaLocalService> {

	public PioggiaCumulativaLocalServiceWrapper() {
		this(null);
	}

	public PioggiaCumulativaLocalServiceWrapper(
		PioggiaCumulativaLocalService pioggiaCumulativaLocalService) {

		_pioggiaCumulativaLocalService = pioggiaCumulativaLocalService;
	}

	/**
	 * Adds the pioggia cumulativa to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PioggiaCumulativaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 * @return the pioggia cumulativa that was added
	 */
	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa addPioggiaCumulativa(
		it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return _pioggiaCumulativaLocalService.addPioggiaCumulativa(
			pioggiaCumulativa);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pioggiaCumulativaLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new pioggia cumulativa with the primary key. Does not add the pioggia cumulativa to the database.
	 *
	 * @param id the primary key for the new pioggia cumulativa
	 * @return the new pioggia cumulativa
	 */
	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa
		createPioggiaCumulativa(long id) {

		return _pioggiaCumulativaLocalService.createPioggiaCumulativa(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pioggiaCumulativaLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PioggiaCumulativaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws PortalException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa
			deletePioggiaCumulativa(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pioggiaCumulativaLocalService.deletePioggiaCumulativa(id);
	}

	/**
	 * Deletes the pioggia cumulativa from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PioggiaCumulativaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 */
	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa
		deletePioggiaCumulativa(
			it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return _pioggiaCumulativaLocalService.deletePioggiaCumulativa(
			pioggiaCumulativa);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pioggiaCumulativaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pioggiaCumulativaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pioggiaCumulativaLocalService.dynamicQuery();
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

		return _pioggiaCumulativaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl</code>.
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

		return _pioggiaCumulativaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl</code>.
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

		return _pioggiaCumulativaLocalService.dynamicQuery(
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

		return _pioggiaCumulativaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pioggiaCumulativaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa
		fetchPioggiaCumulativa(long id) {

		return _pioggiaCumulativaLocalService.fetchPioggiaCumulativa(id);
	}

	@Override
	public java.util.List<it.eng.animazione.image.model.PioggiaCumulativa>
			findByCumulazione(String cumulazione)
		throws com.liferay.portal.kernel.exception.SystemException,
			   it.eng.animazione.image.exception.
				   NoSuchPioggiaCumulativaException {

		return _pioggiaCumulativaLocalService.findByCumulazione(cumulazione);
	}

	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa findByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			   it.eng.animazione.image.exception.
				   NoSuchPioggiaCumulativaException {

		return _pioggiaCumulativaLocalService.findByID(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pioggiaCumulativaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pioggiaCumulativaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pioggiaCumulativaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pioggiaCumulativaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pioggia cumulativa with the primary key.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws PortalException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa getPioggiaCumulativa(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pioggiaCumulativaLocalService.getPioggiaCumulativa(id);
	}

	/**
	 * Returns a range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of pioggia cumulativas
	 */
	@Override
	public java.util.List<it.eng.animazione.image.model.PioggiaCumulativa>
		getPioggiaCumulativas(int start, int end) {

		return _pioggiaCumulativaLocalService.getPioggiaCumulativas(start, end);
	}

	/**
	 * Returns the number of pioggia cumulativas.
	 *
	 * @return the number of pioggia cumulativas
	 */
	@Override
	public int getPioggiaCumulativasCount() {
		return _pioggiaCumulativaLocalService.getPioggiaCumulativasCount();
	}

	/**
	 * Updates the pioggia cumulativa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PioggiaCumulativaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 * @return the pioggia cumulativa that was updated
	 */
	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa
		updatePioggiaCumulativa(
			it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return _pioggiaCumulativaLocalService.updatePioggiaCumulativa(
			pioggiaCumulativa);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _pioggiaCumulativaLocalService.getBasePersistence();
	}

	@Override
	public PioggiaCumulativaLocalService getWrappedService() {
		return _pioggiaCumulativaLocalService;
	}

	@Override
	public void setWrappedService(
		PioggiaCumulativaLocalService pioggiaCumulativaLocalService) {

		_pioggiaCumulativaLocalService = pioggiaCumulativaLocalService;
	}

	private PioggiaCumulativaLocalService _pioggiaCumulativaLocalService;

}