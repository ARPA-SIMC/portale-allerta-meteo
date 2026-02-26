/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.AttivazioneFiume;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the attivazione fiume service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.AttivazioneFiumePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AttivazioneFiumePersistence
 * @generated
 */
public class AttivazioneFiumeUtil {

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
	public static void clearCache(AttivazioneFiume attivazioneFiume) {
		getPersistence().clearCache(attivazioneFiume);
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
	public static Map<Serializable, AttivazioneFiume> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AttivazioneFiume> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttivazioneFiume> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttivazioneFiume> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttivazioneFiume update(AttivazioneFiume attivazioneFiume) {
		return getPersistence().update(attivazioneFiume);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttivazioneFiume update(
		AttivazioneFiume attivazioneFiume, ServiceContext serviceContext) {

		return getPersistence().update(attivazioneFiume, serviceContext);
	}

	/**
	 * Caches the attivazione fiume in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiume the attivazione fiume
	 */
	public static void cacheResult(AttivazioneFiume attivazioneFiume) {
		getPersistence().cacheResult(attivazioneFiume);
	}

	/**
	 * Caches the attivazione fiumes in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiumes the attivazione fiumes
	 */
	public static void cacheResult(List<AttivazioneFiume> attivazioneFiumes) {
		getPersistence().cacheResult(attivazioneFiumes);
	}

	/**
	 * Creates a new attivazione fiume with the primary key. Does not add the attivazione fiume to the database.
	 *
	 * @param fiumeId the primary key for the new attivazione fiume
	 * @return the new attivazione fiume
	 */
	public static AttivazioneFiume create(String fiumeId) {
		return getPersistence().create(fiumeId);
	}

	/**
	 * Removes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	public static AttivazioneFiume remove(String fiumeId)
		throws it.eng.bollettino.exception.NoSuchAttivazioneFiumeException {

		return getPersistence().remove(fiumeId);
	}

	public static AttivazioneFiume updateImpl(
		AttivazioneFiume attivazioneFiume) {

		return getPersistence().updateImpl(attivazioneFiume);
	}

	/**
	 * Returns the attivazione fiume with the primary key or throws a <code>NoSuchAttivazioneFiumeException</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	public static AttivazioneFiume findByPrimaryKey(String fiumeId)
		throws it.eng.bollettino.exception.NoSuchAttivazioneFiumeException {

		return getPersistence().findByPrimaryKey(fiumeId);
	}

	/**
	 * Returns the attivazione fiume with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume, or <code>null</code> if a attivazione fiume with the primary key could not be found
	 */
	public static AttivazioneFiume fetchByPrimaryKey(String fiumeId) {
		return getPersistence().fetchByPrimaryKey(fiumeId);
	}

	/**
	 * Returns all the attivazione fiumes.
	 *
	 * @return the attivazione fiumes
	 */
	public static List<AttivazioneFiume> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @return the range of attivazione fiumes
	 */
	public static List<AttivazioneFiume> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivazione fiumes
	 */
	public static List<AttivazioneFiume> findAll(
		int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attivazione fiumes
	 */
	public static List<AttivazioneFiume> findAll(
		int start, int end,
		OrderByComparator<AttivazioneFiume> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the attivazione fiumes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of attivazione fiumes.
	 *
	 * @return the number of attivazione fiumes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttivazioneFiumePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AttivazioneFiumePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AttivazioneFiumePersistence _persistence;

}