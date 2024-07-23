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
 * Provides a wrapper for {@link EffettiSubLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSubLocalService
 * @generated
 */
@ProviderType
public class EffettiSubLocalServiceWrapper
	implements EffettiSubLocalService, ServiceWrapper<EffettiSubLocalService> {

	public EffettiSubLocalServiceWrapper(
		EffettiSubLocalService effettiSubLocalService) {

		_effettiSubLocalService = effettiSubLocalService;
	}

	/**
	 * Adds the effetti sub to the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSub the effetti sub
	 * @return the effetti sub that was added
	 */
	@Override
	public allerta.catasto.model.EffettiSub addEffettiSub(
		allerta.catasto.model.EffettiSub effettiSub) {

		return _effettiSubLocalService.addEffettiSub(effettiSub);
	}

	/**
	 * Creates a new effetti sub with the primary key. Does not add the effetti sub to the database.
	 *
	 * @param effettiSubPK the primary key for the new effetti sub
	 * @return the new effetti sub
	 */
	@Override
	public allerta.catasto.model.EffettiSub createEffettiSub(
		allerta.catasto.service.persistence.EffettiSubPK effettiSubPK) {

		return _effettiSubLocalService.createEffettiSub(effettiSubPK);
	}

	/**
	 * Deletes the effetti sub from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSub the effetti sub
	 * @return the effetti sub that was removed
	 */
	@Override
	public allerta.catasto.model.EffettiSub deleteEffettiSub(
		allerta.catasto.model.EffettiSub effettiSub) {

		return _effettiSubLocalService.deleteEffettiSub(effettiSub);
	}

	/**
	 * Deletes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws PortalException if a effetti sub with the primary key could not be found
	 */
	@Override
	public allerta.catasto.model.EffettiSub deleteEffettiSub(
			allerta.catasto.service.persistence.EffettiSubPK effettiSubPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiSubLocalService.deleteEffettiSub(effettiSubPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiSubLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _effettiSubLocalService.dynamicQuery();
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

		return _effettiSubLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _effettiSubLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _effettiSubLocalService.dynamicQuery(
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

		return _effettiSubLocalService.dynamicQueryCount(dynamicQuery);
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

		return _effettiSubLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public allerta.catasto.model.EffettiSub fetchEffettiSub(
		allerta.catasto.service.persistence.EffettiSubPK effettiSubPK) {

		return _effettiSubLocalService.fetchEffettiSub(effettiSubPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _effettiSubLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the effetti sub with the primary key.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws PortalException if a effetti sub with the primary key could not be found
	 */
	@Override
	public allerta.catasto.model.EffettiSub getEffettiSub(
			allerta.catasto.service.persistence.EffettiSubPK effettiSubPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiSubLocalService.getEffettiSub(effettiSubPK);
	}

	/**
	 * Returns a range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @return the range of effetti subs
	 */
	@Override
	public java.util.List<allerta.catasto.model.EffettiSub> getEffettiSubs(
		int start, int end) {

		return _effettiSubLocalService.getEffettiSubs(start, end);
	}

	/**
	 * Returns the number of effetti subs.
	 *
	 * @return the number of effetti subs
	 */
	@Override
	public int getEffettiSubsCount() {
		return _effettiSubLocalService.getEffettiSubsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _effettiSubLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _effettiSubLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _effettiSubLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the effetti sub in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSub the effetti sub
	 * @return the effetti sub that was updated
	 */
	@Override
	public allerta.catasto.model.EffettiSub updateEffettiSub(
		allerta.catasto.model.EffettiSub effettiSub) {

		return _effettiSubLocalService.updateEffettiSub(effettiSub);
	}

	@Override
	public EffettiSubLocalService getWrappedService() {
		return _effettiSubLocalService;
	}

	@Override
	public void setWrappedService(
		EffettiSubLocalService effettiSubLocalService) {

		_effettiSubLocalService = effettiSubLocalService;
	}

	private EffettiSubLocalService _effettiSubLocalService;

}