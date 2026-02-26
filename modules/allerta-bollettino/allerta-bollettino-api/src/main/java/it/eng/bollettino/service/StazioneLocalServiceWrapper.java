/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link StazioneLocalService}.
 *
 * @author GFAVINI
 * @see StazioneLocalService
 * @generated
 */
public class StazioneLocalServiceWrapper
	implements ServiceWrapper<StazioneLocalService>, StazioneLocalService {

	public StazioneLocalServiceWrapper() {
		this(null);
	}

	public StazioneLocalServiceWrapper(
		StazioneLocalService stazioneLocalService) {

		_stazioneLocalService = stazioneLocalService;
	}

	/**
	 * Adds the stazione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stazione the stazione
	 * @return the stazione that was added
	 */
	@Override
	public it.eng.bollettino.model.Stazione addStazione(
		it.eng.bollettino.model.Stazione stazione) {

		return _stazioneLocalService.addStazione(stazione);
	}

	@Override
	public it.eng.bollettino.cron.RisultatiAggiornamento aggiornaStazioni() {
		return _stazioneLocalService.aggiornaStazioni();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stazione with the primary key. Does not add the stazione to the database.
	 *
	 * @param id the primary key for the new stazione
	 * @return the new stazione
	 */
	@Override
	public it.eng.bollettino.model.Stazione createStazione(String id) {
		return _stazioneLocalService.createStazione(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the stazione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stazione the stazione
	 * @return the stazione that was removed
	 */
	@Override
	public it.eng.bollettino.model.Stazione deleteStazione(
		it.eng.bollettino.model.Stazione stazione) {

		return _stazioneLocalService.deleteStazione(stazione);
	}

	/**
	 * Deletes the stazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione that was removed
	 * @throws PortalException if a stazione with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Stazione deleteStazione(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneLocalService.deleteStazione(id);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _stazioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _stazioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stazioneLocalService.dynamicQuery();
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

		return _stazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.StazioneModelImpl</code>.
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

		return _stazioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.StazioneModelImpl</code>.
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

		return _stazioneLocalService.dynamicQuery(
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

		return _stazioneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Stazione fetchStazione(String id) {
		return _stazioneLocalService.fetchStazione(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stazioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stazione with the primary key.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione
	 * @throws PortalException if a stazione with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Stazione getStazione(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneLocalService.getStazione(id);
	}

	/**
	 * Returns a range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of staziones
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Stazione> getStaziones(
		int start, int end) {

		return _stazioneLocalService.getStaziones(start, end);
	}

	/**
	 * Returns the number of staziones.
	 *
	 * @return the number of staziones
	 */
	@Override
	public int getStazionesCount() {
		return _stazioneLocalService.getStazionesCount();
	}

	@Override
	public java.util.List<it.eng.bollettino.model.Stazione> getStazioni(
		String variabile) {

		return _stazioneLocalService.getStazioni(variabile);
	}

	/**
	 * Updates the stazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StazioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stazione the stazione
	 * @return the stazione that was updated
	 */
	@Override
	public it.eng.bollettino.model.Stazione updateStazione(
		it.eng.bollettino.model.Stazione stazione) {

		return _stazioneLocalService.updateStazione(stazione);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _stazioneLocalService.getBasePersistence();
	}

	@Override
	public StazioneLocalService getWrappedService() {
		return _stazioneLocalService;
	}

	@Override
	public void setWrappedService(StazioneLocalService stazioneLocalService) {
		_stazioneLocalService = stazioneLocalService;
	}

	private StazioneLocalService _stazioneLocalService;

}