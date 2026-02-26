/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DatiSpecificiInvioLocalService}.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioLocalService
 * @generated
 */
public class DatiSpecificiInvioLocalServiceWrapper
	implements DatiSpecificiInvioLocalService,
			   ServiceWrapper<DatiSpecificiInvioLocalService> {

	public DatiSpecificiInvioLocalServiceWrapper() {
		this(null);
	}

	public DatiSpecificiInvioLocalServiceWrapper(
		DatiSpecificiInvioLocalService datiSpecificiInvioLocalService) {

		_datiSpecificiInvioLocalService = datiSpecificiInvioLocalService;
	}

	/**
	 * Adds the dati specifici invio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DatiSpecificiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param datiSpecificiInvio the dati specifici invio
	 * @return the dati specifici invio that was added
	 */
	@Override
	public it.eng.parer.model.DatiSpecificiInvio addDatiSpecificiInvio(
		it.eng.parer.model.DatiSpecificiInvio datiSpecificiInvio) {

		return _datiSpecificiInvioLocalService.addDatiSpecificiInvio(
			datiSpecificiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioAllerta(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioAllerta(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioAllertaBollettino(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioAllertaBollettino(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioAllertaMail(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioAllertaMail(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioAllertaSms(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioAllertaSms(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioMonitoraggio(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioMonitoraggio(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioMonitoraggioMail(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioMonitoraggioMail(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioMonitoraggioSms(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioMonitoraggioSms(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioSuperamentoMail(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioSuperamentoMail(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	@Override
	public String comunicaDatiSpecificiInvioSuperamentoSms(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioSuperamentoSms(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	@Override
	public String comunicaDatiSpecificiInvioValanghe(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioValanghe(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	@Override
	public String comunicaDatiSpecificiInvioValangheMail(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioValangheMail(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	@Override
	public String comunicaDatiSpecificiInvioValangheSms(
		it.eng.parer.model.DatiSpecificiInvio datiSpecifici,
		java.util.List<it.eng.parer.model.DocumentiCollegati>
			documentiCollegati,
		java.util.List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return _datiSpecificiInvioLocalService.
			comunicaDatiSpecificiInvioValangheSms(
				datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * Creates a new dati specifici invio with the primary key. Does not add the dati specifici invio to the database.
	 *
	 * @param ID_INVIO the primary key for the new dati specifici invio
	 * @return the new dati specifici invio
	 */
	@Override
	public it.eng.parer.model.DatiSpecificiInvio createDatiSpecificiInvio(
		long ID_INVIO) {

		return _datiSpecificiInvioLocalService.createDatiSpecificiInvio(
			ID_INVIO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiSpecificiInvioLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dati specifici invio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DatiSpecificiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param datiSpecificiInvio the dati specifici invio
	 * @return the dati specifici invio that was removed
	 */
	@Override
	public it.eng.parer.model.DatiSpecificiInvio deleteDatiSpecificiInvio(
		it.eng.parer.model.DatiSpecificiInvio datiSpecificiInvio) {

		return _datiSpecificiInvioLocalService.deleteDatiSpecificiInvio(
			datiSpecificiInvio);
	}

	/**
	 * Deletes the dati specifici invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DatiSpecificiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio that was removed
	 * @throws PortalException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.DatiSpecificiInvio deleteDatiSpecificiInvio(
			long ID_INVIO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiSpecificiInvioLocalService.deleteDatiSpecificiInvio(
			ID_INVIO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiSpecificiInvioLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _datiSpecificiInvioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _datiSpecificiInvioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _datiSpecificiInvioLocalService.dynamicQuery();
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

		return _datiSpecificiInvioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DatiSpecificiInvioModelImpl</code>.
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

		return _datiSpecificiInvioLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DatiSpecificiInvioModelImpl</code>.
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

		return _datiSpecificiInvioLocalService.dynamicQuery(
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

		return _datiSpecificiInvioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _datiSpecificiInvioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.parer.model.DatiSpecificiInvio fetchDatiSpecificiInvio(
		long ID_INVIO) {

		return _datiSpecificiInvioLocalService.fetchDatiSpecificiInvio(
			ID_INVIO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _datiSpecificiInvioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dati specifici invio with the primary key.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws PortalException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.DatiSpecificiInvio getDatiSpecificiInvio(
			long ID_INVIO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiSpecificiInvioLocalService.getDatiSpecificiInvio(ID_INVIO);
	}

	/**
	 * Returns a range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of dati specifici invios
	 */
	@Override
	public java.util.List<it.eng.parer.model.DatiSpecificiInvio>
		getDatiSpecificiInvios(int start, int end) {

		return _datiSpecificiInvioLocalService.getDatiSpecificiInvios(
			start, end);
	}

	/**
	 * Returns the number of dati specifici invios.
	 *
	 * @return the number of dati specifici invios
	 */
	@Override
	public int getDatiSpecificiInviosCount() {
		return _datiSpecificiInvioLocalService.getDatiSpecificiInviosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _datiSpecificiInvioLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _datiSpecificiInvioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiSpecificiInvioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Ritorna una lista di dati specifici filtrata in base all'esito passato come paramentro
	 *
	 * @param esitoInvio
	 * @return
	 */
	@Override
	public java.util.List<it.eng.parer.model.DatiSpecificiInvio>
			listaDatiSpecificiByEsitoInvio(String esitoInvio)
		throws Exception {

		return _datiSpecificiInvioLocalService.listaDatiSpecificiByEsitoInvio(
			esitoInvio);
	}

	/**
	 * Updates the dati specifici invio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DatiSpecificiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param datiSpecificiInvio the dati specifici invio
	 * @return the dati specifici invio that was updated
	 */
	@Override
	public it.eng.parer.model.DatiSpecificiInvio updateDatiSpecificiInvio(
		it.eng.parer.model.DatiSpecificiInvio datiSpecificiInvio) {

		return _datiSpecificiInvioLocalService.updateDatiSpecificiInvio(
			datiSpecificiInvio);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _datiSpecificiInvioLocalService.getBasePersistence();
	}

	@Override
	public DatiSpecificiInvioLocalService getWrappedService() {
		return _datiSpecificiInvioLocalService;
	}

	@Override
	public void setWrappedService(
		DatiSpecificiInvioLocalService datiSpecificiInvioLocalService) {

		_datiSpecificiInvioLocalService = datiSpecificiInvioLocalService;
	}

	private DatiSpecificiInvioLocalService _datiSpecificiInvioLocalService;

}