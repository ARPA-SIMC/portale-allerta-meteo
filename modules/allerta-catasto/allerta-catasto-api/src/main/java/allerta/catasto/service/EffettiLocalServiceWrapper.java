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

package allerta.catasto.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EffettiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EffettiLocalService
 * @generated
 */
@ProviderType
public class EffettiLocalServiceWrapper
	implements EffettiLocalService, ServiceWrapper<EffettiLocalService> {

	public EffettiLocalServiceWrapper(EffettiLocalService effettiLocalService) {
		_effettiLocalService = effettiLocalService;
	}

	/**
	 * Adds the effetti to the database. Also notifies the appropriate model listeners.
	 *
	 * @param effetti the effetti
	 * @return the effetti that was added
	 */
	@Override
	public allerta.catasto.model.Effetti addEffetti(
		allerta.catasto.model.Effetti effetti) {

		return _effettiLocalService.addEffetti(effetti);
	}

	/**
	 * Creates a new effetti with the primary key. Does not add the effetti to the database.
	 *
	 * @param id the primary key for the new effetti
	 * @return the new effetti
	 */
	@Override
	public allerta.catasto.model.Effetti createEffetti(long id) {
		return _effettiLocalService.createEffetti(id);
	}

	/**
	 * Deletes the effetti from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effetti the effetti
	 * @return the effetti that was removed
	 */
	@Override
	public allerta.catasto.model.Effetti deleteEffetti(
		allerta.catasto.model.Effetti effetti) {

		return _effettiLocalService.deleteEffetti(effetti);
	}

	/**
	 * Deletes the effetti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti that was removed
	 * @throws PortalException if a effetti with the primary key could not be found
	 */
	@Override
	public allerta.catasto.model.Effetti deleteEffetti(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiLocalService.deleteEffetti(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _effettiLocalService.dynamicQuery();
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

		return _effettiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _effettiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _effettiLocalService.dynamicQuery(
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

		return _effettiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _effettiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public allerta.catasto.model.Effetti fetchEffetti(long id) {
		return _effettiLocalService.fetchEffetti(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _effettiLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the effetti with the primary key.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti
	 * @throws PortalException if a effetti with the primary key could not be found
	 */
	@Override
	public allerta.catasto.model.Effetti getEffetti(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiLocalService.getEffetti(id);
	}

	/**
	 * Returns a range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @return the range of effettis
	 */
	@Override
	public java.util.List<allerta.catasto.model.Effetti> getEffettis(
		int start, int end) {

		return _effettiLocalService.getEffettis(start, end);
	}

	/**
	 * Returns the number of effettis.
	 *
	 * @return the number of effettis
	 */
	@Override
	public int getEffettisCount() {
		return _effettiLocalService.getEffettisCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _effettiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _effettiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the effetti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param effetti the effetti
	 * @return the effetti that was updated
	 */
	@Override
	public allerta.catasto.model.Effetti updateEffetti(
		allerta.catasto.model.Effetti effetti) {

		return _effettiLocalService.updateEffetti(effetti);
	}

	@Override
	public EffettiLocalService getWrappedService() {
		return _effettiLocalService;
	}

	@Override
	public void setWrappedService(EffettiLocalService effettiLocalService) {
		_effettiLocalService = effettiLocalService;
	}

	private EffettiLocalService _effettiLocalService;

}