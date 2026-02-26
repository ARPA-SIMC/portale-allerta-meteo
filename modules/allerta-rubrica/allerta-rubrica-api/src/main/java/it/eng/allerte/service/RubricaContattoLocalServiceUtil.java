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

import it.eng.allerte.model.RubricaContatto;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RubricaContatto. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaContattoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see RubricaContattoLocalService
 * @generated
 */
public class RubricaContattoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaContattoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rubrica contatto to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaContattoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaContatto the rubrica contatto
	 * @return the rubrica contatto that was added
	 */
	public static RubricaContatto addRubricaContatto(
		RubricaContatto rubricaContatto) {

		return getService().addRubricaContatto(rubricaContatto);
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
	 * Creates a new rubrica contatto with the primary key. Does not add the rubrica contatto to the database.
	 *
	 * @param ID_CONTATTO the primary key for the new rubrica contatto
	 * @return the new rubrica contatto
	 */
	public static RubricaContatto createRubricaContatto(long ID_CONTATTO) {
		return getService().createRubricaContatto(ID_CONTATTO);
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
	 * Deletes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaContattoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws PortalException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto deleteRubricaContatto(long ID_CONTATTO)
		throws PortalException {

		return getService().deleteRubricaContatto(ID_CONTATTO);
	}

	/**
	 * Deletes the rubrica contatto from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaContattoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaContatto the rubrica contatto
	 * @return the rubrica contatto that was removed
	 */
	public static RubricaContatto deleteRubricaContatto(
		RubricaContatto rubricaContatto) {

		return getService().deleteRubricaContatto(rubricaContatto);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaContattoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaContattoModelImpl</code>.
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

	public static RubricaContatto fetchRubricaContatto(long ID_CONTATTO) {
		return getService().fetchRubricaContatto(ID_CONTATTO);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 *
	 * @param idNominative
	 * @return
	 */
	public static List<RubricaContatto> getContactByNominative(
		long idNominative) {

		return getService().getContactByNominative(idNominative);
	}

	/**
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 *
	 * @param idUserPortal
	 * @return
	 */
	public static List<RubricaContatto> getContactByNominativePortal(
		long idUserPortal) {

		return getService().getContactByNominativePortal(idUserPortal);
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
	 * Returns the rubrica contatto with the primary key.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws PortalException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto getRubricaContatto(long ID_CONTATTO)
		throws PortalException {

		return getService().getRubricaContatto(ID_CONTATTO);
	}

	/**
	 * Returns a range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of rubrica contattos
	 */
	public static List<RubricaContatto> getRubricaContattos(
		int start, int end) {

		return getService().getRubricaContattos(start, end);
	}

	/**
	 * Returns the number of rubrica contattos.
	 *
	 * @return the number of rubrica contattos
	 */
	public static int getRubricaContattosCount() {
		return getService().getRubricaContattosCount();
	}

	public static java.util.ArrayList<Object[]> loadByNominativo(
		Long idNominativo) {

		return getService().loadByNominativo(idNominativo);
	}

	/**
	 * Updates the rubrica contatto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaContattoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaContatto the rubrica contatto
	 * @return the rubrica contatto that was updated
	 */
	public static RubricaContatto updateRubricaContatto(
		RubricaContatto rubricaContatto) {

		return getService().updateRubricaContatto(rubricaContatto);
	}

	public static RubricaContattoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaContattoLocalService>
		_serviceSnapshot = new Snapshot<>(
			RubricaContattoLocalServiceUtil.class,
			RubricaContattoLocalService.class);

}