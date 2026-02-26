/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence;

import allerta.catasto.exception.NoSuchEffettiSubException;
import allerta.catasto.model.EffettiSub;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the effetti sub service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSubUtil
 * @generated
 */
@ProviderType
public interface EffettiSubPersistence extends BasePersistence<EffettiSub> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EffettiSubUtil} to access the effetti sub persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the effetti sub in the entity cache if it is enabled.
	 *
	 * @param effettiSub the effetti sub
	 */
	public void cacheResult(EffettiSub effettiSub);

	/**
	 * Caches the effetti subs in the entity cache if it is enabled.
	 *
	 * @param effettiSubs the effetti subs
	 */
	public void cacheResult(java.util.List<EffettiSub> effettiSubs);

	/**
	 * Creates a new effetti sub with the primary key. Does not add the effetti sub to the database.
	 *
	 * @param effettiSubPK the primary key for the new effetti sub
	 * @return the new effetti sub
	 */
	public EffettiSub create(EffettiSubPK effettiSubPK);

	/**
	 * Removes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	public EffettiSub remove(EffettiSubPK effettiSubPK)
		throws NoSuchEffettiSubException;

	public EffettiSub updateImpl(EffettiSub effettiSub);

	/**
	 * Returns the effetti sub with the primary key or throws a <code>NoSuchEffettiSubException</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	public EffettiSub findByPrimaryKey(EffettiSubPK effettiSubPK)
		throws NoSuchEffettiSubException;

	/**
	 * Returns the effetti sub with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub, or <code>null</code> if a effetti sub with the primary key could not be found
	 */
	public EffettiSub fetchByPrimaryKey(EffettiSubPK effettiSubPK);

	/**
	 * Returns all the effetti subs.
	 *
	 * @return the effetti subs
	 */
	public java.util.List<EffettiSub> findAll();

	/**
	 * Returns a range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @return the range of effetti subs
	 */
	public java.util.List<EffettiSub> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effetti subs
	 */
	public java.util.List<EffettiSub> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EffettiSub>
			orderByComparator);

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of effetti subs
	 */
	public java.util.List<EffettiSub> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EffettiSub>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the effetti subs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of effetti subs.
	 *
	 * @return the number of effetti subs
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}