/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchFeedException;
import it.eng.allerter.model.Feed;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the feed service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see FeedUtil
 * @generated
 */
@ProviderType
public interface FeedPersistence extends BasePersistence<Feed> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeedUtil} to access the feed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the feed in the entity cache if it is enabled.
	 *
	 * @param feed the feed
	 */
	public void cacheResult(Feed feed);

	/**
	 * Caches the feeds in the entity cache if it is enabled.
	 *
	 * @param feeds the feeds
	 */
	public void cacheResult(java.util.List<Feed> feeds);

	/**
	 * Creates a new feed with the primary key. Does not add the feed to the database.
	 *
	 * @param feedId the primary key for the new feed
	 * @return the new feed
	 */
	public Feed create(String feedId);

	/**
	 * Removes the feed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedId the primary key of the feed
	 * @return the feed that was removed
	 * @throws NoSuchFeedException if a feed with the primary key could not be found
	 */
	public Feed remove(String feedId) throws NoSuchFeedException;

	public Feed updateImpl(Feed feed);

	/**
	 * Returns the feed with the primary key or throws a <code>NoSuchFeedException</code> if it could not be found.
	 *
	 * @param feedId the primary key of the feed
	 * @return the feed
	 * @throws NoSuchFeedException if a feed with the primary key could not be found
	 */
	public Feed findByPrimaryKey(String feedId) throws NoSuchFeedException;

	/**
	 * Returns the feed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedId the primary key of the feed
	 * @return the feed, or <code>null</code> if a feed with the primary key could not be found
	 */
	public Feed fetchByPrimaryKey(String feedId);

	/**
	 * Returns all the feeds.
	 *
	 * @return the feeds
	 */
	public java.util.List<Feed> findAll();

	/**
	 * Returns a range of all the feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feeds
	 * @param end the upper bound of the range of feeds (not inclusive)
	 * @return the range of feeds
	 */
	public java.util.List<Feed> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feeds
	 * @param end the upper bound of the range of feeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feeds
	 */
	public java.util.List<Feed> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feed>
			orderByComparator);

	/**
	 * Returns an ordered range of all the feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feeds
	 * @param end the upper bound of the range of feeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of feeds
	 */
	public java.util.List<Feed> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feed>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the feeds from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of feeds.
	 *
	 * @return the number of feeds
	 */
	public int countAll();

}