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

import allerta.catasto.model.EffettiSub;
import allerta.catasto.service.EffettiSubService;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the effetti sub remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link allerta.catasto.service.impl.EffettiSubServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see allerta.catasto.service.impl.EffettiSubServiceImpl
 * @generated
 */
public abstract class EffettiSubServiceBaseImpl
	extends BaseServiceImpl
	implements EffettiSubService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EffettiSubService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>allerta.catasto.service.EffettiSubServiceUtil</code>.
	 */

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
	 * Returns the categoria remote service.
	 *
	 * @return the categoria remote service
	 */
	public allerta.catasto.service.CategoriaService getCategoriaService() {
		return categoriaService;
	}

	/**
	 * Sets the categoria remote service.
	 *
	 * @param categoriaService the categoria remote service
	 */
	public void setCategoriaService(
		allerta.catasto.service.CategoriaService categoriaService) {

		this.categoriaService = categoriaService;
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
	 * Returns the effetti remote service.
	 *
	 * @return the effetti remote service
	 */
	public allerta.catasto.service.EffettiService getEffettiService() {
		return effettiService;
	}

	/**
	 * Sets the effetti remote service.
	 *
	 * @param effettiService the effetti remote service
	 */
	public void setEffettiService(
		allerta.catasto.service.EffettiService effettiService) {

		this.effettiService = effettiService;
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
	 * Returns the effetti sub remote service.
	 *
	 * @return the effetti sub remote service
	 */
	public EffettiSubService getEffettiSubService() {
		return effettiSubService;
	}

	/**
	 * Sets the effetti sub remote service.
	 *
	 * @param effettiSubService the effetti sub remote service
	 */
	public void setEffettiSubService(EffettiSubService effettiSubService) {
		this.effettiSubService = effettiSubService;
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
	 * Returns the fonte remote service.
	 *
	 * @return the fonte remote service
	 */
	public allerta.catasto.service.FonteService getFonteService() {
		return fonteService;
	}

	/**
	 * Sets the fonte remote service.
	 *
	 * @param fonteService the fonte remote service
	 */
	public void setFonteService(
		allerta.catasto.service.FonteService fonteService) {

		this.fonteService = fonteService;
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
	public allerta.catasto.service.SegnalazioneLocalService
		getSegnalazioneLocalService() {

		return segnalazioneLocalService;
	}

	/**
	 * Sets the segnalazione local service.
	 *
	 * @param segnalazioneLocalService the segnalazione local service
	 */
	public void setSegnalazioneLocalService(
		allerta.catasto.service.SegnalazioneLocalService
			segnalazioneLocalService) {

		this.segnalazioneLocalService = segnalazioneLocalService;
	}

	/**
	 * Returns the segnalazione remote service.
	 *
	 * @return the segnalazione remote service
	 */
	public allerta.catasto.service.SegnalazioneService
		getSegnalazioneService() {

		return segnalazioneService;
	}

	/**
	 * Sets the segnalazione remote service.
	 *
	 * @param segnalazioneService the segnalazione remote service
	 */
	public void setSegnalazioneService(
		allerta.catasto.service.SegnalazioneService segnalazioneService) {

		this.segnalazioneService = segnalazioneService;
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
	 * Returns the sottocategoria remote service.
	 *
	 * @return the sottocategoria remote service
	 */
	public allerta.catasto.service.SottocategoriaService
		getSottocategoriaService() {

		return sottocategoriaService;
	}

	/**
	 * Sets the sottocategoria remote service.
	 *
	 * @param sottocategoriaService the sottocategoria remote service
	 */
	public void setSottocategoriaService(
		allerta.catasto.service.SottocategoriaService sottocategoriaService) {

		this.sottocategoriaService = sottocategoriaService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EffettiSubService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EffettiSub.class;
	}

	protected String getModelClassName() {
		return EffettiSub.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = effettiSubPersistence.getDataSource();

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

	@BeanReference(type = allerta.catasto.service.CategoriaService.class)
	protected allerta.catasto.service.CategoriaService categoriaService;

	@BeanReference(type = CategoriaPersistence.class)
	protected CategoriaPersistence categoriaPersistence;

	@BeanReference(type = allerta.catasto.service.EffettiLocalService.class)
	protected allerta.catasto.service.EffettiLocalService effettiLocalService;

	@BeanReference(type = allerta.catasto.service.EffettiService.class)
	protected allerta.catasto.service.EffettiService effettiService;

	@BeanReference(type = EffettiPersistence.class)
	protected EffettiPersistence effettiPersistence;

	@BeanReference(type = allerta.catasto.service.EffettiSubLocalService.class)
	protected allerta.catasto.service.EffettiSubLocalService
		effettiSubLocalService;

	@BeanReference(type = EffettiSubService.class)
	protected EffettiSubService effettiSubService;

	@BeanReference(type = EffettiSubPersistence.class)
	protected EffettiSubPersistence effettiSubPersistence;

	@BeanReference(type = allerta.catasto.service.FonteLocalService.class)
	protected allerta.catasto.service.FonteLocalService fonteLocalService;

	@BeanReference(type = allerta.catasto.service.FonteService.class)
	protected allerta.catasto.service.FonteService fonteService;

	@BeanReference(type = FontePersistence.class)
	protected FontePersistence fontePersistence;

	@BeanReference(
		type = allerta.catasto.service.SegnalazioneLocalService.class
	)
	protected allerta.catasto.service.SegnalazioneLocalService
		segnalazioneLocalService;

	@BeanReference(type = allerta.catasto.service.SegnalazioneService.class)
	protected allerta.catasto.service.SegnalazioneService segnalazioneService;

	@BeanReference(type = SegnalazionePersistence.class)
	protected SegnalazionePersistence segnalazionePersistence;

	@BeanReference(
		type = allerta.catasto.service.SottocategoriaLocalService.class
	)
	protected allerta.catasto.service.SottocategoriaLocalService
		sottocategoriaLocalService;

	@BeanReference(type = allerta.catasto.service.SottocategoriaService.class)
	protected allerta.catasto.service.SottocategoriaService
		sottocategoriaService;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}