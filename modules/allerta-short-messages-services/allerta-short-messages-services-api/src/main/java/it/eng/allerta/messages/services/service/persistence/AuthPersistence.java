/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerta.messages.services.exception.NoSuchAuthException;
import it.eng.allerta.messages.services.model.Auth;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the auth service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see AuthUtil
 * @generated
 */
@ProviderType
public interface AuthPersistence extends BasePersistence<Auth> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthUtil} to access the auth persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the auth in the entity cache if it is enabled.
	 *
	 * @param auth the auth
	 */
	public void cacheResult(Auth auth);

	/**
	 * Caches the auths in the entity cache if it is enabled.
	 *
	 * @param auths the auths
	 */
	public void cacheResult(java.util.List<Auth> auths);

	/**
	 * Creates a new auth with the primary key. Does not add the auth to the database.
	 *
	 * @param key the primary key for the new auth
	 * @return the new auth
	 */
	public Auth create(String key);

	/**
	 * Removes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the auth
	 * @return the auth that was removed
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	public Auth remove(String key) throws NoSuchAuthException;

	public Auth updateImpl(Auth auth);

	/**
	 * Returns the auth with the primary key or throws a <code>NoSuchAuthException</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	public Auth findByPrimaryKey(String key) throws NoSuchAuthException;

	/**
	 * Returns the auth with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth, or <code>null</code> if a auth with the primary key could not be found
	 */
	public Auth fetchByPrimaryKey(String key);

	/**
	 * Returns all the auths.
	 *
	 * @return the auths
	 */
	public java.util.List<Auth> findAll();

	/**
	 * Returns a range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @return the range of auths
	 */
	public java.util.List<Auth> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auths
	 */
	public java.util.List<Auth> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auth>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auths
	 */
	public java.util.List<Auth> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auth>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the auths from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of auths.
	 *
	 * @return the number of auths
	 */
	public int countAll();

}