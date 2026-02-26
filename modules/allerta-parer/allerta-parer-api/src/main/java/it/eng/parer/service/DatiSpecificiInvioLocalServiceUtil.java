/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.parer.model.DatiSpecificiInvio;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DatiSpecificiInvio. This utility wraps
 * <code>it.eng.parer.service.impl.DatiSpecificiInvioLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioLocalService
 * @generated
 */
public class DatiSpecificiInvioLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.parer.service.impl.DatiSpecificiInvioLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DatiSpecificiInvio addDatiSpecificiInvio(
		DatiSpecificiInvio datiSpecificiInvio) {

		return getService().addDatiSpecificiInvio(datiSpecificiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioAllerta(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioAllerta(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioAllertaBollettino(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioAllertaBollettino(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioAllertaMail(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioAllertaMail(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioAllertaSms(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioAllertaSms(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioMonitoraggio(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioMonitoraggio(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioMonitoraggioMail(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioMonitoraggioMail(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioMonitoraggioSms(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioMonitoraggioSms(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioSuperamentoMail(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioSuperamentoMail(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public static String comunicaDatiSpecificiInvioSuperamentoSms(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioSuperamentoSms(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	public static String comunicaDatiSpecificiInvioValanghe(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioValanghe(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	public static String comunicaDatiSpecificiInvioValangheMail(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioValangheMail(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	public static String comunicaDatiSpecificiInvioValangheSms(
		DatiSpecificiInvio datiSpecifici,
		List<it.eng.parer.model.DocumentiCollegati> documentiCollegati,
		List<it.eng.parer.model.ComponentiInvio> componentiInvio) {

		return getService().comunicaDatiSpecificiInvioValangheSms(
			datiSpecifici, documentiCollegati, componentiInvio);
	}

	/**
	 * Creates a new dati specifici invio with the primary key. Does not add the dati specifici invio to the database.
	 *
	 * @param ID_INVIO the primary key for the new dati specifici invio
	 * @return the new dati specifici invio
	 */
	public static DatiSpecificiInvio createDatiSpecificiInvio(long ID_INVIO) {
		return getService().createDatiSpecificiInvio(ID_INVIO);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static DatiSpecificiInvio deleteDatiSpecificiInvio(
		DatiSpecificiInvio datiSpecificiInvio) {

		return getService().deleteDatiSpecificiInvio(datiSpecificiInvio);
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
	public static DatiSpecificiInvio deleteDatiSpecificiInvio(long ID_INVIO)
		throws PortalException {

		return getService().deleteDatiSpecificiInvio(ID_INVIO);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DatiSpecificiInvio fetchDatiSpecificiInvio(long ID_INVIO) {
		return getService().fetchDatiSpecificiInvio(ID_INVIO);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dati specifici invio with the primary key.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws PortalException if a dati specifici invio with the primary key could not be found
	 */
	public static DatiSpecificiInvio getDatiSpecificiInvio(long ID_INVIO)
		throws PortalException {

		return getService().getDatiSpecificiInvio(ID_INVIO);
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
	public static List<DatiSpecificiInvio> getDatiSpecificiInvios(
		int start, int end) {

		return getService().getDatiSpecificiInvios(start, end);
	}

	/**
	 * Returns the number of dati specifici invios.
	 *
	 * @return the number of dati specifici invios
	 */
	public static int getDatiSpecificiInviosCount() {
		return getService().getDatiSpecificiInviosCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Ritorna una lista di dati specifici filtrata in base all'esito passato come paramentro
	 *
	 * @param esitoInvio
	 * @return
	 */
	public static List<DatiSpecificiInvio> listaDatiSpecificiByEsitoInvio(
			String esitoInvio)
		throws Exception {

		return getService().listaDatiSpecificiByEsitoInvio(esitoInvio);
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
	public static DatiSpecificiInvio updateDatiSpecificiInvio(
		DatiSpecificiInvio datiSpecificiInvio) {

		return getService().updateDatiSpecificiInvio(datiSpecificiInvio);
	}

	public static DatiSpecificiInvioLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DatiSpecificiInvioLocalService>
		_serviceSnapshot = new Snapshot<>(
			DatiSpecificiInvioLocalServiceUtil.class,
			DatiSpecificiInvioLocalService.class);

}