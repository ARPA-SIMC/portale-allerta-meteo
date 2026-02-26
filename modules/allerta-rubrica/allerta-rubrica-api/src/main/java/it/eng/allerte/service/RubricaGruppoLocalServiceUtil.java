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

import it.eng.allerte.model.RubricaGruppo;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RubricaGruppo. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see RubricaGruppoLocalService
 * @generated
 */
public class RubricaGruppoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rubrica gruppo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was added
	 */
	public static RubricaGruppo addRubricaGruppo(RubricaGruppo rubricaGruppo) {
		return getService().addRubricaGruppo(rubricaGruppo);
	}

	public static void aggiornaTuttoGruppo(Long gruppo) {
		getService().aggiornaTuttoGruppo(gruppo);
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
	 * Creates a new rubrica gruppo with the primary key. Does not add the rubrica gruppo to the database.
	 *
	 * @param ID_GRUPPO the primary key for the new rubrica gruppo
	 * @return the new rubrica gruppo
	 */
	public static RubricaGruppo createRubricaGruppo(long ID_GRUPPO) {
		return getService().createRubricaGruppo(ID_GRUPPO);
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
	 * Deletes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws PortalException if a rubrica gruppo with the primary key could not be found
	 */
	public static RubricaGruppo deleteRubricaGruppo(long ID_GRUPPO)
		throws PortalException {

		return getService().deleteRubricaGruppo(ID_GRUPPO);
	}

	/**
	 * Deletes the rubrica gruppo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 */
	public static RubricaGruppo deleteRubricaGruppo(
		RubricaGruppo rubricaGruppo) {

		return getService().deleteRubricaGruppo(rubricaGruppo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>.
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

	public static RubricaGruppo fetchRubricaGruppo(long ID_GRUPPO) {
		return getService().fetchRubricaGruppo(ID_GRUPPO);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.ArrayList<Object[]> getGerarchia(Long site) {
		return getService().getGerarchia(site);
	}

	public static List<Object[]> getGroup(Long id) {
		return getService().getGroup(id);
	}

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	public static RubricaGruppo getGroupForOwnerByName(
		Long ownerId, String groupName) {

		return getService().getGroupForOwnerByName(ownerId, groupName);
	}

	public static java.util.ArrayList<Object[]> getGruppiByName(
		Long site, String groupName, Long limit, Long offset) {

		return getService().getGruppiByName(site, groupName, limit, offset);
	}

	public static java.util.ArrayList<Object[]> getGruppiByNameCategoria(
		Long site, String groupName, Long categoria, Long limit, Long offset) {

		return getService().getGruppiByNameCategoria(
			site, groupName, categoria, limit, offset);
	}

	public static Object[] getGruppiByOwnerAndName(
		Long idOwner, String groupName) {

		return getService().getGruppiByOwnerAndName(idOwner, groupName);
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
	 * Returns the rubrica gruppo with the primary key.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws PortalException if a rubrica gruppo with the primary key could not be found
	 */
	public static RubricaGruppo getRubricaGruppo(long ID_GRUPPO)
		throws PortalException {

		return getService().getRubricaGruppo(ID_GRUPPO);
	}

	/**
	 * Returns a range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @return the range of rubrica gruppos
	 */
	public static List<RubricaGruppo> getRubricaGruppos(int start, int end) {
		return getService().getRubricaGruppos(start, end);
	}

	/**
	 * Returns the number of rubrica gruppos.
	 *
	 * @return the number of rubrica gruppos
	 */
	public static int getRubricaGrupposCount() {
		return getService().getRubricaGrupposCount();
	}

	/**
	 * Updates the rubrica gruppo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaGruppoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was updated
	 */
	public static RubricaGruppo updateRubricaGruppo(
		RubricaGruppo rubricaGruppo) {

		return getService().updateRubricaGruppo(rubricaGruppo);
	}

	public static RubricaGruppoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaGruppoLocalService> _serviceSnapshot =
		new Snapshot<>(
			RubricaGruppoLocalServiceUtil.class,
			RubricaGruppoLocalService.class);

}