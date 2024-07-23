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

package allerta.catasto.service.base;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.Segnalazione;
import allerta.catasto.service.SegnalazioneLocalService;
import allerta.catasto.service.persistence.CategoriaPersistence;
import allerta.catasto.service.persistence.EffettiPersistence;
import allerta.catasto.service.persistence.EffettiSubPersistence;
import allerta.catasto.service.persistence.FontePersistence;
import allerta.catasto.service.persistence.SegnalazionePersistence;
import allerta.catasto.service.persistence.SottocategoriaPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
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

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the segnalazione local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link allerta.catasto.service.impl.SegnalazioneLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see allerta.catasto.service.impl.SegnalazioneLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class SegnalazioneLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements SegnalazioneLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SegnalazioneLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>allerta.catasto.service.SegnalazioneLocalServiceUtil</code>.
	 */

	/**
	 * Adds the segnalazione to the database. Also notifies the appropriate model listeners.
	 *
	 * @param segnalazione the segnalazione
	 * @return the segnalazione that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Segnalazione addSegnalazione(Segnalazione segnalazione) {
		segnalazione.setNew(true);

		return segnalazionePersistence.update(segnalazione);
	}

	/**
	 * Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	 *
	 * @param id the primary key for the new segnalazione
	 * @return the new segnalazione
	 */
	@Override
	@Transactional(enabled = false)
	public Segnalazione createSegnalazione(long id) {
		return segnalazionePersistence.create(id);
	}

	/**
	 * Deletes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws PortalException if a segnalazione with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Segnalazione deleteSegnalazione(long id) throws PortalException {
		return segnalazionePersistence.remove(id);
	}

	/**
	 * Deletes the segnalazione from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segnalazione the segnalazione
	 * @return the segnalazione that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Segnalazione deleteSegnalazione(Segnalazione segnalazione) {
		return segnalazionePersistence.remove(segnalazione);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Segnalazione.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return segnalazionePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return segnalazionePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return segnalazionePersistence.findWithDynamicQuery(
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
		return segnalazionePersistence.countWithDynamicQuery(dynamicQuery);
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

		return segnalazionePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Segnalazione fetchSegnalazione(long id) {
		return segnalazionePersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the segnalazione with the primary key.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws PortalException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione getSegnalazione(long id) throws PortalException {
		return segnalazionePersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(segnalazioneLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Segnalazione.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			segnalazioneLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Segnalazione.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(segnalazioneLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Segnalazione.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return segnalazioneLocalService.deleteSegnalazione(
			(Segnalazione)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return segnalazionePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of segnalaziones
	 */
	@Override
	public List<Segnalazione> getSegnalaziones(int start, int end) {
		return segnalazionePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of segnalaziones.
	 *
	 * @return the number of segnalaziones
	 */
	@Override
	public int getSegnalazionesCount() {
		return segnalazionePersistence.countAll();
	}

	/**
	 * Updates the segnalazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param segnalazione the segnalazione
	 * @return the segnalazione that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Segnalazione updateSegnalazione(Segnalazione segnalazione) {
		return segnalazionePersistence.update(segnalazione);
	}

	/**
	 * Returns the categoria local service.
	 *
	 * @return the categoria local service
	 */
	public allerta.catasto.service.CategoriaLocalService
		getCategoriaLocalService() {

		return categoriaLocalService;
	}

	/**
	 * Sets the categoria local service.
	 *
	 * @param categoriaLocalService the categoria local service
	 */
	public void setCategoriaLocalService(
		allerta.catasto.service.CategoriaLocalService categoriaLocalService) {

		this.categoriaLocalService = categoriaLocalService;
	}

	/**
	 * Returns the categoria persistence.
	 *
	 * @return the categoria persistence
	 */
	public CategoriaPersistence getCategoriaPersistence() {
		return categoriaPersistence;
	}

	/**
	 * Sets the categoria persistence.
	 *
	 * @param categoriaPersistence the categoria persistence
	 */
	public void setCategoriaPersistence(
		CategoriaPersistence categoriaPersistence) {

		this.categoriaPersistence = categoriaPersistence;
	}

	/**
	 * Returns the effetti local service.
	 *
	 * @return the effetti local service
	 */
	public allerta.catasto.service.EffettiLocalService
		getEffettiLocalService() {

		return effettiLocalService;
	}

	/**
	 * Sets the effetti local service.
	 *
	 * @param effettiLocalService the effetti local service
	 */
	public void setEffettiLocalService(
		allerta.catasto.service.EffettiLocalService effettiLocalService) {

		this.effettiLocalService = effettiLocalService;
	}

	/**
	 * Returns the effetti persistence.
	 *
	 * @return the effetti persistence
	 */
	public EffettiPersistence getEffettiPersistence() {
		return effettiPersistence;
	}

	/**
	 * Sets the effetti persistence.
	 *
	 * @param effettiPersistence the effetti persistence
	 */
	public void setEffettiPersistence(EffettiPersistence effettiPersistence) {
		this.effettiPersistence = effettiPersistence;
	}

	/**
	 * Returns the effetti sub local service.
	 *
	 * @return the effetti sub local service
	 */
	public allerta.catasto.service.EffettiSubLocalService
		getEffettiSubLocalService() {

		return effettiSubLocalService;
	}

	/**
	 * Sets the effetti sub local service.
	 *
	 * @param effettiSubLocalService the effetti sub local service
	 */
	public void setEffettiSubLocalService(
		allerta.catasto.service.EffettiSubLocalService effettiSubLocalService) {

		this.effettiSubLocalService = effettiSubLocalService;
	}

	/**
	 * Returns the effetti sub persistence.
	 *
	 * @return the effetti sub persistence
	 */
	public EffettiSubPersistence getEffettiSubPersistence() {
		return effettiSubPersistence;
	}

	/**
	 * Sets the effetti sub persistence.
	 *
	 * @param effettiSubPersistence the effetti sub persistence
	 */
	public void setEffettiSubPersistence(
		EffettiSubPersistence effettiSubPersistence) {

		this.effettiSubPersistence = effettiSubPersistence;
	}

	/**
	 * Returns the fonte local service.
	 *
	 * @return the fonte local service
	 */
	public allerta.catasto.service.FonteLocalService getFonteLocalService() {
		return fonteLocalService;
	}

	/**
	 * Sets the fonte local service.
	 *
	 * @param fonteLocalService the fonte local service
	 */
	public void setFonteLocalService(
		allerta.catasto.service.FonteLocalService fonteLocalService) {

		this.fonteLocalService = fonteLocalService;
	}

	/**
	 * Returns the fonte persistence.
	 *
	 * @return the fonte persistence
	 */
	public FontePersistence getFontePersistence() {
		return fontePersistence;
	}

	/**
	 * Sets the fonte persistence.
	 *
	 * @param fontePersistence the fonte persistence
	 */
	public void setFontePersistence(FontePersistence fontePersistence) {
		this.fontePersistence = fontePersistence;
	}

	/**
	 * Returns the segnalazione local service.
	 *
	 * @return the segnalazione local service
	 */
	public SegnalazioneLocalService getSegnalazioneLocalService() {
		return segnalazioneLocalService;
	}

	/**
	 * Sets the segnalazione local service.
	 *
	 * @param segnalazioneLocalService the segnalazione local service
	 */
	public void setSegnalazioneLocalService(
		SegnalazioneLocalService segnalazioneLocalService) {

		this.segnalazioneLocalService = segnalazioneLocalService;
	}

	/**
	 * Returns the segnalazione persistence.
	 *
	 * @return the segnalazione persistence
	 */
	public SegnalazionePersistence getSegnalazionePersistence() {
		return segnalazionePersistence;
	}

	/**
	 * Sets the segnalazione persistence.
	 *
	 * @param segnalazionePersistence the segnalazione persistence
	 */
	public void setSegnalazionePersistence(
		SegnalazionePersistence segnalazionePersistence) {

		this.segnalazionePersistence = segnalazionePersistence;
	}

	/**
	 * Returns the sottocategoria local service.
	 *
	 * @return the sottocategoria local service
	 */
	public allerta.catasto.service.SottocategoriaLocalService
		getSottocategoriaLocalService() {

		return sottocategoriaLocalService;
	}

	/**
	 * Sets the sottocategoria local service.
	 *
	 * @param sottocategoriaLocalService the sottocategoria local service
	 */
	public void setSottocategoriaLocalService(
		allerta.catasto.service.SottocategoriaLocalService
			sottocategoriaLocalService) {

		this.sottocategoriaLocalService = sottocategoriaLocalService;
	}

	/**
	 * Returns the sottocategoria persistence.
	 *
	 * @return the sottocategoria persistence
	 */
	public SottocategoriaPersistence getSottocategoriaPersistence() {
		return sottocategoriaPersistence;
	}

	/**
	 * Sets the sottocategoria persistence.
	 *
	 * @param sottocategoriaPersistence the sottocategoria persistence
	 */
	public void setSottocategoriaPersistence(
		SottocategoriaPersistence sottocategoriaPersistence) {

		this.sottocategoriaPersistence = sottocategoriaPersistence;
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
			"allerta.catasto.model.Segnalazione", segnalazioneLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"allerta.catasto.model.Segnalazione");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SegnalazioneLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Segnalazione.class;
	}

	protected String getModelClassName() {
		return Segnalazione.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = segnalazionePersistence.getDataSource();

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

	@BeanReference(type = allerta.catasto.service.CategoriaLocalService.class)
	protected allerta.catasto.service.CategoriaLocalService
		categoriaLocalService;

	@BeanReference(type = CategoriaPersistence.class)
	protected CategoriaPersistence categoriaPersistence;

	@BeanReference(type = allerta.catasto.service.EffettiLocalService.class)
	protected allerta.catasto.service.EffettiLocalService effettiLocalService;

	@BeanReference(type = EffettiPersistence.class)
	protected EffettiPersistence effettiPersistence;

	@BeanReference(type = allerta.catasto.service.EffettiSubLocalService.class)
	protected allerta.catasto.service.EffettiSubLocalService
		effettiSubLocalService;

	@BeanReference(type = EffettiSubPersistence.class)
	protected EffettiSubPersistence effettiSubPersistence;

	@BeanReference(type = allerta.catasto.service.FonteLocalService.class)
	protected allerta.catasto.service.FonteLocalService fonteLocalService;

	@BeanReference(type = FontePersistence.class)
	protected FontePersistence fontePersistence;

	@BeanReference(type = SegnalazioneLocalService.class)
	protected SegnalazioneLocalService segnalazioneLocalService;

	@BeanReference(type = SegnalazionePersistence.class)
	protected SegnalazionePersistence segnalazionePersistence;

	@BeanReference(
		type = allerta.catasto.service.SottocategoriaLocalService.class
	)
	protected allerta.catasto.service.SottocategoriaLocalService
		sottocategoriaLocalService;

	@BeanReference(type = SottocategoriaPersistence.class)
	protected SottocategoriaPersistence sottocategoriaPersistence;

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