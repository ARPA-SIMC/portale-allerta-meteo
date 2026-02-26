/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchLogInternoException;
import it.eng.allerter.model.LogInterno;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the log interno service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see LogInternoUtil
 * @generated
 */
@ProviderType
public interface LogInternoPersistence extends BasePersistence<LogInterno> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogInternoUtil} to access the log interno persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the log interno in the entity cache if it is enabled.
	 *
	 * @param logInterno the log interno
	 */
	public void cacheResult(LogInterno logInterno);

	/**
	 * Caches the log internos in the entity cache if it is enabled.
	 *
	 * @param logInternos the log internos
	 */
	public void cacheResult(java.util.List<LogInterno> logInternos);

	/**
	 * Creates a new log interno with the primary key. Does not add the log interno to the database.
	 *
	 * @param logId the primary key for the new log interno
	 * @return the new log interno
	 */
	public LogInterno create(long logId);

	/**
	 * Removes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	public LogInterno remove(long logId) throws NoSuchLogInternoException;

	public LogInterno updateImpl(LogInterno logInterno);

	/**
	 * Returns the log interno with the primary key or throws a <code>NoSuchLogInternoException</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	public LogInterno findByPrimaryKey(long logId)
		throws NoSuchLogInternoException;

	/**
	 * Returns the log interno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno, or <code>null</code> if a log interno with the primary key could not be found
	 */
	public LogInterno fetchByPrimaryKey(long logId);

	/**
	 * Returns all the log internos.
	 *
	 * @return the log internos
	 */
	public java.util.List<LogInterno> findAll();

	/**
	 * Returns a range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @return the range of log internos
	 */
	public java.util.List<LogInterno> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log internos
	 */
	public java.util.List<LogInterno> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogInterno>
			orderByComparator);

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of log internos
	 */
	public java.util.List<LogInterno> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogInterno>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the log internos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of log internos.
	 *
	 * @return the number of log internos
	 */
	public int countAll();

}