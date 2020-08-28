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

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaGruppo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica gruppo service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaGruppoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoPersistence
 * @generated
 */
@ProviderType
public class RubricaGruppoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(RubricaGruppo rubricaGruppo) {
		getPersistence().clearCache(rubricaGruppo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, RubricaGruppo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaGruppo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaGruppo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaGruppo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaGruppo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaGruppo update(RubricaGruppo rubricaGruppo) {
		return getPersistence().update(rubricaGruppo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaGruppo update(
		RubricaGruppo rubricaGruppo, ServiceContext serviceContext) {

		return getPersistence().update(rubricaGruppo, serviceContext);
	}

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	public static RubricaGruppo findByRubricaGruppoSitoProprietario(
			long ID_GRUPPO, long FK_SITO_PROPRIETARIO)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoException {

		return getPersistence().findByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public static RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO) {

		return getPersistence().fetchByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public static RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO, boolean retrieveFromCache) {

		return getPersistence().fetchByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO, retrieveFromCache);
	}

	/**
	 * Removes the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica gruppo that was removed
	 */
	public static RubricaGruppo removeByRubricaGruppoSitoProprietario(
			long ID_GRUPPO, long FK_SITO_PROPRIETARIO)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoException {

		return getPersistence().removeByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the number of rubrica gruppos where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica gruppos
	 */
	public static int countByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO) {

		return getPersistence().countByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);
	}

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	public static RubricaGruppo findByRubricaGruppoForOwnerAndName(
			long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoException {

		return getPersistence().findByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);
	}

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public static RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED) {

		return getPersistence().fetchByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);
	}

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public static RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED,
		boolean retrieveFromCache) {

		return getPersistence().fetchByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED, retrieveFromCache);
	}

	/**
	 * Removes the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; from the database.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the rubrica gruppo that was removed
	 */
	public static RubricaGruppo removeByRubricaGruppoForOwnerAndName(
			long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoException {

		return getPersistence().removeByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);
	}

	/**
	 * Returns the number of rubrica gruppos where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the number of matching rubrica gruppos
	 */
	public static int countByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED) {

		return getPersistence().countByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);
	}

	/**
	 * Caches the rubrica gruppo in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 */
	public static void cacheResult(RubricaGruppo rubricaGruppo) {
		getPersistence().cacheResult(rubricaGruppo);
	}

	/**
	 * Caches the rubrica gruppos in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppos the rubrica gruppos
	 */
	public static void cacheResult(List<RubricaGruppo> rubricaGruppos) {
		getPersistence().cacheResult(rubricaGruppos);
	}

	/**
	 * Creates a new rubrica gruppo with the primary key. Does not add the rubrica gruppo to the database.
	 *
	 * @param ID_GRUPPO the primary key for the new rubrica gruppo
	 * @return the new rubrica gruppo
	 */
	public static RubricaGruppo create(long ID_GRUPPO) {
		return getPersistence().create(ID_GRUPPO);
	}

	/**
	 * Removes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	public static RubricaGruppo remove(long ID_GRUPPO)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoException {

		return getPersistence().remove(ID_GRUPPO);
	}

	public static RubricaGruppo updateImpl(RubricaGruppo rubricaGruppo) {
		return getPersistence().updateImpl(rubricaGruppo);
	}

	/**
	 * Returns the rubrica gruppo with the primary key or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	public static RubricaGruppo findByPrimaryKey(long ID_GRUPPO)
		throws it.eng.allerte.exception.NoSuchRubricaGruppoException {

		return getPersistence().findByPrimaryKey(ID_GRUPPO);
	}

	/**
	 * Returns the rubrica gruppo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo, or <code>null</code> if a rubrica gruppo with the primary key could not be found
	 */
	public static RubricaGruppo fetchByPrimaryKey(long ID_GRUPPO) {
		return getPersistence().fetchByPrimaryKey(ID_GRUPPO);
	}

	/**
	 * Returns all the rubrica gruppos.
	 *
	 * @return the rubrica gruppos
	 */
	public static List<RubricaGruppo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @return the range of rubrica gruppos
	 */
	public static List<RubricaGruppo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppos
	 */
	public static List<RubricaGruppo> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppos
	 */
	public static List<RubricaGruppo> findAll(
		int start, int end, OrderByComparator<RubricaGruppo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica gruppos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica gruppos.
	 *
	 * @return the number of rubrica gruppos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaGruppoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaGruppoPersistence, RubricaGruppoPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaGruppoPersistence.class);

		ServiceTracker<RubricaGruppoPersistence, RubricaGruppoPersistence>
			serviceTracker =
				new ServiceTracker
					<RubricaGruppoPersistence, RubricaGruppoPersistence>(
						bundle.getBundleContext(),
						RubricaGruppoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}