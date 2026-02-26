/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

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

import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for RubricaGruppoNominativi. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaGruppoNominativiLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoNominativiLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the rubrica gruppo nominativi local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RubricaGruppoNominativiLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the rubrica gruppo nominativi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoNominativiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RubricaGruppoNominativi addRubricaGruppoNominativi(
		RubricaGruppoNominativi rubricaGruppoNominativi);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	@Transactional(enabled = false)
	public RubricaGruppoNominativi createRubricaGruppoNominativi(
		RubricaGruppoNominativiPK rubricaGruppoNominativiPK);

	public void deleteNominativoDaGruppo(Long fkGruppo, Long fkNominativo);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the rubrica gruppo nominativi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoNominativiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public RubricaGruppoNominativi deleteRubricaGruppoNominativi(
		RubricaGruppoNominativi rubricaGruppoNominativi);

	/**
	 * Deletes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoNominativiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws PortalException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public RubricaGruppoNominativi deleteRubricaGruppoNominativi(
			RubricaGruppoNominativiPK rubricaGruppoNominativiPK)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>.
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
	public RubricaGruppoNominativi fetchRubricaGruppoNominativi(
		RubricaGruppoNominativiPK rubricaGruppoNominativiPK);

	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		Long idNominativo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Set<RubricaNominativo> getNominativeForGroup(
		Long ownerId, Long groupId);

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RubricaNominativo> getNominativeForGroupPortal(Long ownerId);

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
	 * Returns the rubrica gruppo nominativi with the primary key.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws PortalException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RubricaGruppoNominativi getRubricaGruppoNominativi(
			RubricaGruppoNominativiPK rubricaGruppoNominativiPK)
		throws PortalException;

	/**
	 * Returns a range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of rubrica gruppo nominativis
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RubricaGruppoNominativi> getRubricaGruppoNominativis(
		int start, int end);

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRubricaGruppoNominativisCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object[]> loadByidRuolo(Long idRuolo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object[]> loadNominativiGruppo(Long idGruppo, Long idSite);

	/**
	 * Updates the rubrica gruppo nominativi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoNominativiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RubricaGruppoNominativi updateRubricaGruppoNominativi(
		RubricaGruppoNominativi rubricaGruppoNominativi);

}