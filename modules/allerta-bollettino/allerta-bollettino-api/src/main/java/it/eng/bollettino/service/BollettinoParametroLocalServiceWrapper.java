/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BollettinoParametroLocalService}.
 *
 * @author GFAVINI
 * @see BollettinoParametroLocalService
 * @generated
 */
public class BollettinoParametroLocalServiceWrapper
	implements BollettinoParametroLocalService,
			   ServiceWrapper<BollettinoParametroLocalService> {

	public BollettinoParametroLocalServiceWrapper() {
		this(null);
	}

	public BollettinoParametroLocalServiceWrapper(
		BollettinoParametroLocalService bollettinoParametroLocalService) {

		_bollettinoParametroLocalService = bollettinoParametroLocalService;
	}

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
	@Override
	public it.eng.bollettino.model.BollettinoParametro addBollettinoParametro(
		it.eng.bollettino.model.BollettinoParametro bollettinoParametro) {

		return _bollettinoParametroLocalService.addBollettinoParametro(
			bollettinoParametro);
	}

	/**
	 * Creates a new bollettino parametro with the primary key. Does not add the bollettino parametro to the database.
	 *
	 * @param parametroId the primary key for the new bollettino parametro
	 * @return the new bollettino parametro
	 */
	@Override
	public it.eng.bollettino.model.BollettinoParametro
		createBollettinoParametro(String parametroId) {

		return _bollettinoParametroLocalService.createBollettinoParametro(
			parametroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoParametroLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public it.eng.bollettino.model.BollettinoParametro
		deleteBollettinoParametro(
			it.eng.bollettino.model.BollettinoParametro bollettinoParametro) {

		return _bollettinoParametroLocalService.deleteBollettinoParametro(
			bollettinoParametro);
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
	@Override
	public it.eng.bollettino.model.BollettinoParametro
			deleteBollettinoParametro(String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoParametroLocalService.deleteBollettinoParametro(
			parametroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoParametroLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bollettinoParametroLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bollettinoParametroLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bollettinoParametroLocalService.dynamicQuery();
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

		return _bollettinoParametroLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bollettinoParametroLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bollettinoParametroLocalService.dynamicQuery(
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

		return _bollettinoParametroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bollettinoParametroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.BollettinoParametro fetchBollettinoParametro(
		String parametroId) {

		return _bollettinoParametroLocalService.fetchBollettinoParametro(
			parametroId);
	}

	/**
	 * Returns the bollettino parametro with the primary key.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws PortalException if a bollettino parametro with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoParametro getBollettinoParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoParametroLocalService.getBollettinoParametro(
			parametroId);
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
	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoParametro>
		getBollettinoParametros(int start, int end) {

		return _bollettinoParametroLocalService.getBollettinoParametros(
			start, end);
	}

	/**
	 * Returns the number of bollettino parametros.
	 *
	 * @return the number of bollettino parametros
	 */
	@Override
	public int getBollettinoParametrosCount() {
		return _bollettinoParametroLocalService.getBollettinoParametrosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoParametroLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoParametroLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public it.eng.bollettino.model.BollettinoParametro
		updateBollettinoParametro(
			it.eng.bollettino.model.BollettinoParametro bollettinoParametro) {

		return _bollettinoParametroLocalService.updateBollettinoParametro(
			bollettinoParametro);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bollettinoParametroLocalService.getBasePersistence();
	}

	@Override
	public BollettinoParametroLocalService getWrappedService() {
		return _bollettinoParametroLocalService;
	}

	@Override
	public void setWrappedService(
		BollettinoParametroLocalService bollettinoParametroLocalService) {

		_bollettinoParametroLocalService = bollettinoParametroLocalService;
	}

	private BollettinoParametroLocalService _bollettinoParametroLocalService;

}