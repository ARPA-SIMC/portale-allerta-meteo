/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence;

import allerta.catasto.model.Effetti;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the effetti service. This utility wraps <code>allerta.catasto.service.persistence.impl.EffettiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiPersistence
 * @generated
 */
public class EffettiUtil {

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
	public static void clearCache(Effetti effetti) {
		getPersistence().clearCache(effetti);
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
	public static Map<Serializable, Effetti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Effetti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Effetti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Effetti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Effetti> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Effetti update(Effetti effetti) {
		return getPersistence().update(effetti);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Effetti update(
		Effetti effetti, ServiceContext serviceContext) {

		return getPersistence().update(effetti, serviceContext);
	}

	/**
	 * Caches the effetti in the entity cache if it is enabled.
	 *
	 * @param effetti the effetti
	 */
	public static void cacheResult(Effetti effetti) {
		getPersistence().cacheResult(effetti);
	}

	/**
	 * Caches the effettis in the entity cache if it is enabled.
	 *
	 * @param effettis the effettis
	 */
	public static void cacheResult(List<Effetti> effettis) {
		getPersistence().cacheResult(effettis);
	}

	/**
	 * Creates a new effetti with the primary key. Does not add the effetti to the database.
	 *
	 * @param id the primary key for the new effetti
	 * @return the new effetti
	 */
	public static Effetti create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the effetti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti that was removed
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	public static Effetti remove(long id)
		throws allerta.catasto.exception.NoSuchEffettiException {

		return getPersistence().remove(id);
	}

	public static Effetti updateImpl(Effetti effetti) {
		return getPersistence().updateImpl(effetti);
	}

	/**
	 * Returns the effetti with the primary key or throws a <code>NoSuchEffettiException</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	public static Effetti findByPrimaryKey(long id)
		throws allerta.catasto.exception.NoSuchEffettiException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the effetti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti, or <code>null</code> if a effetti with the primary key could not be found
	 */
	public static Effetti fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the effettis.
	 *
	 * @return the effettis
	 */
	public static List<Effetti> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @return the range of effettis
	 */
	public static List<Effetti> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effettis
	 */
	public static List<Effetti> findAll(
		int start, int end, OrderByComparator<Effetti> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of effettis
	 */
	public static List<Effetti> findAll(
		int start, int end, OrderByComparator<Effetti> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the effettis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of effettis.
	 *
	 * @return the number of effettis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EffettiPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EffettiPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EffettiPersistence _persistence;

}