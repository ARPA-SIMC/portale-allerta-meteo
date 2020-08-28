/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RubricaGruppoGruppi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoGruppiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiLocalService
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoGruppiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rubrica gruppo gruppi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was added
	 */
	public static it.eng.allerte.model.RubricaGruppoGruppi
		addRubricaGruppoGruppi(
			it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return getService().addRubricaGruppoGruppi(rubricaGruppoGruppi);
	}

	/**
	 * Creates a new rubrica gruppo gruppi with the primary key. Does not add the rubrica gruppo gruppi to the database.
	 *
	 * @param rubricaGruppoGruppiPK the primary key for the new rubrica gruppo gruppi
	 * @return the new rubrica gruppo gruppi
	 */
	public static it.eng.allerte.model.RubricaGruppoGruppi
		createRubricaGruppoGruppi(
			it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
				rubricaGruppoGruppiPK) {

		return getService().createRubricaGruppoGruppi(rubricaGruppoGruppiPK);
	}

	public static void deleteGruppoSottoGruppo(
		Long fkGruppo, Long fkSottoGruppo) {

		getService().deleteGruppoSottoGruppo(fkGruppo, fkSottoGruppo);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rubrica gruppo gruppi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 */
	public static it.eng.allerte.model.RubricaGruppoGruppi
		deleteRubricaGruppoGruppi(
			it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return getService().deleteRubricaGruppoGruppi(rubricaGruppoGruppi);
	}

	/**
	 * Deletes the rubrica gruppo gruppi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 * @throws PortalException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static it.eng.allerte.model.RubricaGruppoGruppi
			deleteRubricaGruppoGruppi(
				it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
					rubricaGruppoGruppiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRubricaGruppoGruppi(rubricaGruppoGruppiPK);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.eng.allerte.model.RubricaGruppoGruppi
		fetchRubricaGruppoGruppi(
			it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
				rubricaGruppoGruppiPK) {

		return getService().fetchRubricaGruppoGruppi(rubricaGruppoGruppiPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.ArrayList<Object[]> getGruppiFigli(
		Long fkGruppoPadre) {

		return getService().getGruppiFigli(fkGruppoPadre);
	}

	public static java.util.ArrayList<Object[]> getGruppiPadriPerFiglio(
		Long fkGruppoPadre) {

		return getService().getGruppiPadriPerFiglio(fkGruppoPadre);
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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica gruppo gruppi with the primary key.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi
	 * @throws PortalException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public static it.eng.allerte.model.RubricaGruppoGruppi
			getRubricaGruppoGruppi(
				it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
					rubricaGruppoGruppiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRubricaGruppoGruppi(rubricaGruppoGruppiPK);
	}

	/**
	 * Returns a range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of rubrica gruppo gruppis
	 */
	public static java.util.List<it.eng.allerte.model.RubricaGruppoGruppi>
		getRubricaGruppoGruppis(int start, int end) {

		return getService().getRubricaGruppoGruppis(start, end);
	}

	/**
	 * Returns the number of rubrica gruppo gruppis.
	 *
	 * @return the number of rubrica gruppo gruppis
	 */
	public static int getRubricaGruppoGruppisCount() {
		return getService().getRubricaGruppoGruppisCount();
	}

	/**
	 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
	 *
	 * @param idGroup
	 * @return
	 */
	public static java.util.List<it.eng.allerte.model.RubricaGruppo>
		getSubGroups(long idGroup) {

		return getService().getSubGroups(idGroup);
	}

	/**
	 * Updates the rubrica gruppo gruppi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was updated
	 */
	public static it.eng.allerte.model.RubricaGruppoGruppi
		updateRubricaGruppoGruppi(
			it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return getService().updateRubricaGruppoGruppi(rubricaGruppoGruppi);
	}

	public static RubricaGruppoGruppiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaGruppoGruppiLocalService, RubricaGruppoGruppiLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaGruppoGruppiLocalService.class);

		ServiceTracker
			<RubricaGruppoGruppiLocalService, RubricaGruppoGruppiLocalService>
				serviceTracker =
					new ServiceTracker
						<RubricaGruppoGruppiLocalService,
						 RubricaGruppoGruppiLocalService>(
							 bundle.getBundleContext(),
							 RubricaGruppoGruppiLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}