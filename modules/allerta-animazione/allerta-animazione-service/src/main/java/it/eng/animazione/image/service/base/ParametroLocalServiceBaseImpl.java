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

package it.eng.animazione.image.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.animazione.image.model.Parametro;
import it.eng.animazione.image.service.ParametroLocalService;
import it.eng.animazione.image.service.persistence.ParametroPersistence;
import it.eng.animazione.image.service.persistence.PioggiaCumulativaPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaAdriacPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaSwanitaPersistence;
import it.eng.animazione.image.service.persistence.elevazionePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the parametro local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.eng.animazione.image.service.impl.ParametroLocalServiceImpl}.
 * </p>
 *
 * @author UTENTE
 * @see it.eng.animazione.image.service.impl.ParametroLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class ParametroLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ParametroLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ParametroLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.animazione.image.service.ParametroLocalServiceUtil</code>.
	 */

	/**
	 * Adds the parametro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametro the parametro
	 * @return the parametro that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Parametro addParametro(Parametro parametro) {
		parametro.setNew(true);

		return parametroPersistence.update(parametro);
	}

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param key the primary key for the new parametro
	 * @return the new parametro
	 */
	@Override
	@Transactional(enabled = false)
	public Parametro createParametro(String key) {
		return parametroPersistence.create(key);
	}

	/**
	 * Deletes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws PortalException if a parametro with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Parametro deleteParametro(String key) throws PortalException {
		return parametroPersistence.remove(key);
	}

	/**
	 * Deletes the parametro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametro the parametro
	 * @return the parametro that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Parametro deleteParametro(Parametro parametro) {
		return parametroPersistence.remove(parametro);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Parametro.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return parametroPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return parametroPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return parametroPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return parametroPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return parametroPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Parametro fetchParametro(String key) {
		return parametroPersistence.fetchByPrimaryKey(key);
	}

	/**
	 * Returns the parametro with the primary key.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro
	 * @throws PortalException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro getParametro(String key) throws PortalException {
		return parametroPersistence.findByPrimaryKey(key);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return parametroLocalService.deleteParametro((Parametro)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return parametroPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.ParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 */
	@Override
	public List<Parametro> getParametros(int start, int end) {
		return parametroPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 */
	@Override
	public int getParametrosCount() {
		return parametroPersistence.countAll();
	}

	/**
	 * Updates the parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param parametro the parametro
	 * @return the parametro that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Parametro updateParametro(Parametro parametro) {
		return parametroPersistence.update(parametro);
	}

	/**
	 * Returns the altezza onda local service.
	 *
	 * @return the altezza onda local service
	 */
	public it.eng.animazione.image.service.altezzaOndaLocalService
		getaltezzaOndaLocalService() {

		return altezzaOndaLocalService;
	}

	/**
	 * Sets the altezza onda local service.
	 *
	 * @param altezzaOndaLocalService the altezza onda local service
	 */
	public void setaltezzaOndaLocalService(
		it.eng.animazione.image.service.altezzaOndaLocalService
			altezzaOndaLocalService) {

		this.altezzaOndaLocalService = altezzaOndaLocalService;
	}

	/**
	 * Returns the altezza onda persistence.
	 *
	 * @return the altezza onda persistence
	 */
	public altezzaOndaPersistence getaltezzaOndaPersistence() {
		return altezzaOndaPersistence;
	}

	/**
	 * Sets the altezza onda persistence.
	 *
	 * @param altezzaOndaPersistence the altezza onda persistence
	 */
	public void setaltezzaOndaPersistence(
		altezzaOndaPersistence altezzaOndaPersistence) {

		this.altezzaOndaPersistence = altezzaOndaPersistence;
	}

	/**
	 * Returns the altezza onda adriac local service.
	 *
	 * @return the altezza onda adriac local service
	 */
	public it.eng.animazione.image.service.altezzaOndaAdriacLocalService
		getaltezzaOndaAdriacLocalService() {

		return altezzaOndaAdriacLocalService;
	}

	/**
	 * Sets the altezza onda adriac local service.
	 *
	 * @param altezzaOndaAdriacLocalService the altezza onda adriac local service
	 */
	public void setaltezzaOndaAdriacLocalService(
		it.eng.animazione.image.service.altezzaOndaAdriacLocalService
			altezzaOndaAdriacLocalService) {

		this.altezzaOndaAdriacLocalService = altezzaOndaAdriacLocalService;
	}

	/**
	 * Returns the altezza onda adriac persistence.
	 *
	 * @return the altezza onda adriac persistence
	 */
	public altezzaOndaAdriacPersistence getaltezzaOndaAdriacPersistence() {
		return altezzaOndaAdriacPersistence;
	}

	/**
	 * Sets the altezza onda adriac persistence.
	 *
	 * @param altezzaOndaAdriacPersistence the altezza onda adriac persistence
	 */
	public void setaltezzaOndaAdriacPersistence(
		altezzaOndaAdriacPersistence altezzaOndaAdriacPersistence) {

		this.altezzaOndaAdriacPersistence = altezzaOndaAdriacPersistence;
	}

	/**
	 * Returns the altezza onda swanita local service.
	 *
	 * @return the altezza onda swanita local service
	 */
	public it.eng.animazione.image.service.altezzaOndaSwanitaLocalService
		getaltezzaOndaSwanitaLocalService() {

		return altezzaOndaSwanitaLocalService;
	}

	/**
	 * Sets the altezza onda swanita local service.
	 *
	 * @param altezzaOndaSwanitaLocalService the altezza onda swanita local service
	 */
	public void setaltezzaOndaSwanitaLocalService(
		it.eng.animazione.image.service.altezzaOndaSwanitaLocalService
			altezzaOndaSwanitaLocalService) {

		this.altezzaOndaSwanitaLocalService = altezzaOndaSwanitaLocalService;
	}

	/**
	 * Returns the altezza onda swanita persistence.
	 *
	 * @return the altezza onda swanita persistence
	 */
	public altezzaOndaSwanitaPersistence getaltezzaOndaSwanitaPersistence() {
		return altezzaOndaSwanitaPersistence;
	}

	/**
	 * Sets the altezza onda swanita persistence.
	 *
	 * @param altezzaOndaSwanitaPersistence the altezza onda swanita persistence
	 */
	public void setaltezzaOndaSwanitaPersistence(
		altezzaOndaSwanitaPersistence altezzaOndaSwanitaPersistence) {

		this.altezzaOndaSwanitaPersistence = altezzaOndaSwanitaPersistence;
	}

	/**
	 * Returns the elevazione local service.
	 *
	 * @return the elevazione local service
	 */
	public it.eng.animazione.image.service.elevazioneLocalService
		getelevazioneLocalService() {

		return elevazioneLocalService;
	}

	/**
	 * Sets the elevazione local service.
	 *
	 * @param elevazioneLocalService the elevazione local service
	 */
	public void setelevazioneLocalService(
		it.eng.animazione.image.service.elevazioneLocalService
			elevazioneLocalService) {

		this.elevazioneLocalService = elevazioneLocalService;
	}

	/**
	 * Returns the elevazione persistence.
	 *
	 * @return the elevazione persistence
	 */
	public elevazionePersistence getelevazionePersistence() {
		return elevazionePersistence;
	}

	/**
	 * Sets the elevazione persistence.
	 *
	 * @param elevazionePersistence the elevazione persistence
	 */
	public void setelevazionePersistence(
		elevazionePersistence elevazionePersistence) {

		this.elevazionePersistence = elevazionePersistence;
	}

	/**
	 * Returns the parametro local service.
	 *
	 * @return the parametro local service
	 */
	public ParametroLocalService getParametroLocalService() {
		return parametroLocalService;
	}

	/**
	 * Sets the parametro local service.
	 *
	 * @param parametroLocalService the parametro local service
	 */
	public void setParametroLocalService(
		ParametroLocalService parametroLocalService) {

		this.parametroLocalService = parametroLocalService;
	}

	/**
	 * Returns the parametro persistence.
	 *
	 * @return the parametro persistence
	 */
	public ParametroPersistence getParametroPersistence() {
		return parametroPersistence;
	}

	/**
	 * Sets the parametro persistence.
	 *
	 * @param parametroPersistence the parametro persistence
	 */
	public void setParametroPersistence(
		ParametroPersistence parametroPersistence) {

		this.parametroPersistence = parametroPersistence;
	}

	/**
	 * Returns the pioggia cumulativa local service.
	 *
	 * @return the pioggia cumulativa local service
	 */
	public it.eng.animazione.image.service.PioggiaCumulativaLocalService
		getPioggiaCumulativaLocalService() {

		return pioggiaCumulativaLocalService;
	}

	/**
	 * Sets the pioggia cumulativa local service.
	 *
	 * @param pioggiaCumulativaLocalService the pioggia cumulativa local service
	 */
	public void setPioggiaCumulativaLocalService(
		it.eng.animazione.image.service.PioggiaCumulativaLocalService
			pioggiaCumulativaLocalService) {

		this.pioggiaCumulativaLocalService = pioggiaCumulativaLocalService;
	}

	/**
	 * Returns the pioggia cumulativa persistence.
	 *
	 * @return the pioggia cumulativa persistence
	 */
	public PioggiaCumulativaPersistence getPioggiaCumulativaPersistence() {
		return pioggiaCumulativaPersistence;
	}

	/**
	 * Sets the pioggia cumulativa persistence.
	 *
	 * @param pioggiaCumulativaPersistence the pioggia cumulativa persistence
	 */
	public void setPioggiaCumulativaPersistence(
		PioggiaCumulativaPersistence pioggiaCumulativaPersistence) {

		this.pioggiaCumulativaPersistence = pioggiaCumulativaPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"it.eng.animazione.image.model.Parametro", parametroLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"it.eng.animazione.image.model.Parametro");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ParametroLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Parametro.class;
	}

	protected String getModelClassName() {
		return Parametro.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = parametroPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = it.eng.animazione.image.service.altezzaOndaLocalService.class
	)
	protected it.eng.animazione.image.service.altezzaOndaLocalService
		altezzaOndaLocalService;

	@BeanReference(type = altezzaOndaPersistence.class)
	protected altezzaOndaPersistence altezzaOndaPersistence;

	@BeanReference(
		type = it.eng.animazione.image.service.altezzaOndaAdriacLocalService.class
	)
	protected it.eng.animazione.image.service.altezzaOndaAdriacLocalService
		altezzaOndaAdriacLocalService;

	@BeanReference(type = altezzaOndaAdriacPersistence.class)
	protected altezzaOndaAdriacPersistence altezzaOndaAdriacPersistence;

	@BeanReference(
		type = it.eng.animazione.image.service.altezzaOndaSwanitaLocalService.class
	)
	protected it.eng.animazione.image.service.altezzaOndaSwanitaLocalService
		altezzaOndaSwanitaLocalService;

	@BeanReference(type = altezzaOndaSwanitaPersistence.class)
	protected altezzaOndaSwanitaPersistence altezzaOndaSwanitaPersistence;

	@BeanReference(
		type = it.eng.animazione.image.service.elevazioneLocalService.class
	)
	protected it.eng.animazione.image.service.elevazioneLocalService
		elevazioneLocalService;

	@BeanReference(type = elevazionePersistence.class)
	protected elevazionePersistence elevazionePersistence;

	@BeanReference(type = ParametroLocalService.class)
	protected ParametroLocalService parametroLocalService;

	@BeanReference(type = ParametroPersistence.class)
	protected ParametroPersistence parametroPersistence;

	@BeanReference(
		type = it.eng.animazione.image.service.PioggiaCumulativaLocalService.class
	)
	protected it.eng.animazione.image.service.PioggiaCumulativaLocalService
		pioggiaCumulativaLocalService;

	@BeanReference(type = PioggiaCumulativaPersistence.class)
	protected PioggiaCumulativaPersistence pioggiaCumulativaPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}