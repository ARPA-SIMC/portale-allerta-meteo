/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DatiSpecificiInvio. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DatiSpecificiInvioLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.parer.service.impl.DatiSpecificiInvioLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dati specifici invio local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DatiSpecificiInvioLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public DatiSpecificiInvio addDatiSpecificiInvio(
		DatiSpecificiInvio datiSpecificiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllerta(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllertaBollettino(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllertaMail(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllertaSms(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioMonitoraggio(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioMonitoraggioMail(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioMonitoraggioSms(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioSuperamentoMail(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioSuperamentoSms(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	public String comunicaDatiSpecificiInvioValanghe(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	public String comunicaDatiSpecificiInvioValangheMail(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	public String comunicaDatiSpecificiInvioValangheSms(
		DatiSpecificiInvio datiSpecifici,
		List<DocumentiCollegati> documentiCollegati,
		List<ComponentiInvio> componentiInvio);

	/**
	 * Creates a new dati specifici invio with the primary key. Does not add the dati specifici invio to the database.
	 *
	 * @param ID_INVIO the primary key for the new dati specifici invio
	 * @return the new dati specifici invio
	 */
	@Transactional(enabled = false)
	public DatiSpecificiInvio createDatiSpecificiInvio(long ID_INVIO);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public DatiSpecificiInvio deleteDatiSpecificiInvio(
		DatiSpecificiInvio datiSpecificiInvio);

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
	@Indexable(type = IndexableType.DELETE)
	public DatiSpecificiInvio deleteDatiSpecificiInvio(long ID_INVIO)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DatiSpecificiInvio fetchDatiSpecificiInvio(long ID_INVIO);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the dati specifici invio with the primary key.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws PortalException if a dati specifici invio with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DatiSpecificiInvio getDatiSpecificiInvio(long ID_INVIO)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DatiSpecificiInvio> getDatiSpecificiInvios(int start, int end);

	/**
	 * Returns the number of dati specifici invios.
	 *
	 * @return the number of dati specifici invios
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDatiSpecificiInviosCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Ritorna una lista di dati specifici filtrata in base all'esito passato come paramentro
	 *
	 * @param esitoInvio
	 * @return
	 */
	public List<DatiSpecificiInvio> listaDatiSpecificiByEsitoInvio(
			String esitoInvio)
		throws Exception;

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
	@Indexable(type = IndexableType.REINDEX)
	public DatiSpecificiInvio updateDatiSpecificiInvio(
		DatiSpecificiInvio datiSpecificiInvio);

}