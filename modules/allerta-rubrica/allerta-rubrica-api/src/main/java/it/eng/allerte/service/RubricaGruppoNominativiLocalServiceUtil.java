/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaGruppoNominativi;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for RubricaGruppoNominativi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoNominativiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiLocalService
 * @generated
 */
public class RubricaGruppoNominativiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoNominativiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static RubricaGruppoNominativi addRubricaGruppoNominativi(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		return getService().addRubricaGruppoNominativi(rubricaGruppoNominativi);
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
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	public static RubricaGruppoNominativi createRubricaGruppoNominativi(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			rubricaGruppoNominativiPK) {

		return getService().createRubricaGruppoNominativi(
			rubricaGruppoNominativiPK);
	}

	public static void deleteNominativoDaGruppo(
		Long fkGruppo, Long fkNominativo) {

		getService().deleteNominativoDaGruppo(fkGruppo, fkNominativo);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

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
	public static RubricaGruppoNominativi deleteRubricaGruppoNominativi(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		return getService().deleteRubricaGruppoNominativi(
			rubricaGruppoNominativi);
	}

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
	public static RubricaGruppoNominativi deleteRubricaGruppoNominativi(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK)
		throws PortalException {

		return getService().deleteRubricaGruppoNominativi(
			rubricaGruppoNominativiPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl</code>.
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

	public static RubricaGruppoNominativi fetchRubricaGruppoNominativi(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			rubricaGruppoNominativiPK) {

		return getService().fetchRubricaGruppoNominativi(
			rubricaGruppoNominativiPK);
	}

	public static List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(Long idNominativo) {

		return getService().findByRubricaGruppoRuoloByNominativo(idNominativo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	public static Set<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroup(Long ownerId, Long groupId) {

		return getService().getNominativeForGroup(ownerId, groupId);
	}

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	public static List<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroupPortal(Long ownerId) {

		return getService().getNominativeForGroupPortal(ownerId);
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
	 * Returns the rubrica gruppo nominativi with the primary key.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws PortalException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public static RubricaGruppoNominativi getRubricaGruppoNominativi(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK)
		throws PortalException {

		return getService().getRubricaGruppoNominativi(
			rubricaGruppoNominativiPK);
	}

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
	public static List<RubricaGruppoNominativi> getRubricaGruppoNominativis(
		int start, int end) {

		return getService().getRubricaGruppoNominativis(start, end);
	}

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	public static int getRubricaGruppoNominativisCount() {
		return getService().getRubricaGruppoNominativisCount();
	}

	public static List<Object[]> loadByidRuolo(Long idRuolo) {
		return getService().loadByidRuolo(idRuolo);
	}

	public static List<Object[]> loadNominativiGruppo(
		Long idGruppo, Long idSite) {

		return getService().loadNominativiGruppo(idGruppo, idSite);
	}

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
	public static RubricaGruppoNominativi updateRubricaGruppoNominativi(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		return getService().updateRubricaGruppoNominativi(
			rubricaGruppoNominativi);
	}

	public static RubricaGruppoNominativiLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaGruppoNominativiLocalService>
		_serviceSnapshot = new Snapshot<>(
			RubricaGruppoNominativiLocalServiceUtil.class,
			RubricaGruppoNominativiLocalService.class);

}