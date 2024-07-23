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

package allerta.catasto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.Segnalazione;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the segnalazione service. This utility wraps <code>allerta.catasto.service.persistence.impl.SegnalazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazionePersistence
 * @generated
 */
@ProviderType
public class SegnalazioneUtil {

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
	public static void clearCache(Segnalazione segnalazione) {
		getPersistence().clearCache(segnalazione);
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
	public static Map<Serializable, Segnalazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Segnalazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Segnalazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Segnalazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Segnalazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Segnalazione update(Segnalazione segnalazione) {
		return getPersistence().update(segnalazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Segnalazione update(
		Segnalazione segnalazione, ServiceContext serviceContext) {

		return getPersistence().update(segnalazione, serviceContext);
	}

	/**
	 * Returns all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @return the matching segnalaziones
	 */
	public static List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato) {

		return getPersistence().findByDocumentoAssociato(documentoAssociato);
	}

	/**
	 * Returns a range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of matching segnalaziones
	 */
	public static List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end) {

		return getPersistence().findByDocumentoAssociato(
			documentoAssociato, start, end);
	}

	/**
	 * Returns an ordered range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segnalaziones
	 */
	public static List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		OrderByComparator<Segnalazione> orderByComparator) {

		return getPersistence().findByDocumentoAssociato(
			documentoAssociato, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching segnalaziones
	 */
	public static List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		OrderByComparator<Segnalazione> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumentoAssociato(
			documentoAssociato, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segnalazione
	 * @throws NoSuchSegnalazioneException if a matching segnalazione could not be found
	 */
	public static Segnalazione findByDocumentoAssociato_First(
			long documentoAssociato,
			OrderByComparator<Segnalazione> orderByComparator)
		throws allerta.catasto.exception.NoSuchSegnalazioneException {

		return getPersistence().findByDocumentoAssociato_First(
			documentoAssociato, orderByComparator);
	}

	/**
	 * Returns the first segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segnalazione, or <code>null</code> if a matching segnalazione could not be found
	 */
	public static Segnalazione fetchByDocumentoAssociato_First(
		long documentoAssociato,
		OrderByComparator<Segnalazione> orderByComparator) {

		return getPersistence().fetchByDocumentoAssociato_First(
			documentoAssociato, orderByComparator);
	}

	/**
	 * Returns the last segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segnalazione
	 * @throws NoSuchSegnalazioneException if a matching segnalazione could not be found
	 */
	public static Segnalazione findByDocumentoAssociato_Last(
			long documentoAssociato,
			OrderByComparator<Segnalazione> orderByComparator)
		throws allerta.catasto.exception.NoSuchSegnalazioneException {

		return getPersistence().findByDocumentoAssociato_Last(
			documentoAssociato, orderByComparator);
	}

	/**
	 * Returns the last segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segnalazione, or <code>null</code> if a matching segnalazione could not be found
	 */
	public static Segnalazione fetchByDocumentoAssociato_Last(
		long documentoAssociato,
		OrderByComparator<Segnalazione> orderByComparator) {

		return getPersistence().fetchByDocumentoAssociato_Last(
			documentoAssociato, orderByComparator);
	}

	/**
	 * Returns the segnalaziones before and after the current segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param id the primary key of the current segnalazione
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	public static Segnalazione[] findByDocumentoAssociato_PrevAndNext(
			long id, long documentoAssociato,
			OrderByComparator<Segnalazione> orderByComparator)
		throws allerta.catasto.exception.NoSuchSegnalazioneException {

		return getPersistence().findByDocumentoAssociato_PrevAndNext(
			id, documentoAssociato, orderByComparator);
	}

	/**
	 * Removes all the segnalaziones where documentoAssociato = &#63; from the database.
	 *
	 * @param documentoAssociato the documento associato
	 */
	public static void removeByDocumentoAssociato(long documentoAssociato) {
		getPersistence().removeByDocumentoAssociato(documentoAssociato);
	}

	/**
	 * Returns the number of segnalaziones where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @return the number of matching segnalaziones
	 */
	public static int countByDocumentoAssociato(long documentoAssociato) {
		return getPersistence().countByDocumentoAssociato(documentoAssociato);
	}

	/**
	 * Caches the segnalazione in the entity cache if it is enabled.
	 *
	 * @param segnalazione the segnalazione
	 */
	public static void cacheResult(Segnalazione segnalazione) {
		getPersistence().cacheResult(segnalazione);
	}

	/**
	 * Caches the segnalaziones in the entity cache if it is enabled.
	 *
	 * @param segnalaziones the segnalaziones
	 */
	public static void cacheResult(List<Segnalazione> segnalaziones) {
		getPersistence().cacheResult(segnalaziones);
	}

	/**
	 * Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	 *
	 * @param id the primary key for the new segnalazione
	 * @return the new segnalazione
	 */
	public static Segnalazione create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	public static Segnalazione remove(long id)
		throws allerta.catasto.exception.NoSuchSegnalazioneException {

		return getPersistence().remove(id);
	}

	public static Segnalazione updateImpl(Segnalazione segnalazione) {
		return getPersistence().updateImpl(segnalazione);
	}

	/**
	 * Returns the segnalazione with the primary key or throws a <code>NoSuchSegnalazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	public static Segnalazione findByPrimaryKey(long id)
		throws allerta.catasto.exception.NoSuchSegnalazioneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the segnalazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione, or <code>null</code> if a segnalazione with the primary key could not be found
	 */
	public static Segnalazione fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the segnalaziones.
	 *
	 * @return the segnalaziones
	 */
	public static List<Segnalazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of segnalaziones
	 */
	public static List<Segnalazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segnalaziones
	 */
	public static List<Segnalazione> findAll(
		int start, int end, OrderByComparator<Segnalazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of segnalaziones
	 */
	public static List<Segnalazione> findAll(
		int start, int end, OrderByComparator<Segnalazione> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the segnalaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of segnalaziones.
	 *
	 * @return the number of segnalaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SegnalazionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SegnalazionePersistence, SegnalazionePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SegnalazionePersistence.class);

		ServiceTracker<SegnalazionePersistence, SegnalazionePersistence>
			serviceTracker =
				new ServiceTracker
					<SegnalazionePersistence, SegnalazionePersistence>(
						bundle.getBundleContext(),
						SegnalazionePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}