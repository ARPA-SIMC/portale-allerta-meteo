/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.BollettinoParametro;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BollettinoParametro. This utility wraps
 * <code>it.eng.bollettino.service.impl.BollettinoParametroLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see BollettinoParametroLocalService
 * @generated
 */
public class BollettinoParametroLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.BollettinoParametroLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the bollettino parametro to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoParametro the bollettino parametro
	 * @return the bollettino parametro that was added
	 */
	public static BollettinoParametro addBollettinoParametro(
		BollettinoParametro bollettinoParametro) {

		return getService().addBollettinoParametro(bollettinoParametro);
	}

	/**
	 * Creates a new bollettino parametro with the primary key. Does not add the bollettino parametro to the database.
	 *
	 * @param parametroId the primary key for the new bollettino parametro
	 * @return the new bollettino parametro
	 */
	public static BollettinoParametro createBollettinoParametro(
		String parametroId) {

		return getService().createBollettinoParametro(parametroId);
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
	 * Deletes the bollettino parametro from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoParametro the bollettino parametro
	 * @return the bollettino parametro that was removed
	 */
	public static BollettinoParametro deleteBollettinoParametro(
		BollettinoParametro bollettinoParametro) {

		return getService().deleteBollettinoParametro(bollettinoParametro);
	}

	/**
	 * Deletes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws PortalException if a bollettino parametro with the primary key could not be found
	 */
	public static BollettinoParametro deleteBollettinoParametro(
			String parametroId)
		throws PortalException {

		return getService().deleteBollettinoParametro(parametroId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoParametroModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoParametroModelImpl</code>.
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

	public static BollettinoParametro fetchBollettinoParametro(
		String parametroId) {

		return getService().fetchBollettinoParametro(parametroId);
	}

	/**
	 * Returns the bollettino parametro with the primary key.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws PortalException if a bollettino parametro with the primary key could not be found
	 */
	public static BollettinoParametro getBollettinoParametro(String parametroId)
		throws PortalException {

		return getService().getBollettinoParametro(parametroId);
	}

	/**
	 * Returns a range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @return the range of bollettino parametros
	 */
	public static List<BollettinoParametro> getBollettinoParametros(
		int start, int end) {

		return getService().getBollettinoParametros(start, end);
	}

	/**
	 * Returns the number of bollettino parametros.
	 *
	 * @return the number of bollettino parametros
	 */
	public static int getBollettinoParametrosCount() {
		return getService().getBollettinoParametrosCount();
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
	 * Updates the bollettino parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoParametro the bollettino parametro
	 * @return the bollettino parametro that was updated
	 */
	public static BollettinoParametro updateBollettinoParametro(
		BollettinoParametro bollettinoParametro) {

		return getService().updateBollettinoParametro(bollettinoParametro);
	}

	public static BollettinoParametroLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BollettinoParametroLocalService>
		_serviceSnapshot = new Snapshot<>(
			BollettinoParametroLocalServiceUtil.class,
			BollettinoParametroLocalService.class);

}