/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.allerter.exception.NoSuchFeedException;
import it.eng.allerter.model.Feed;
import it.eng.allerter.service.persistence.FeedPersistence;
import it.eng.allerter.service.persistence.FeedUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class FeedPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = FeedUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Feed> iterator = _feeds.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Feed feed = _persistence.create(pk);

		Assert.assertNotNull(feed);

		Assert.assertEquals(feed.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Feed newFeed = addFeed();

		_persistence.remove(newFeed);

		Feed existingFeed = _persistence.fetchByPrimaryKey(
			newFeed.getPrimaryKey());

		Assert.assertNull(existingFeed);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFeed();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Feed newFeed = _persistence.create(pk);

		newFeed.setTitolo(RandomTestUtil.randomString());

		newFeed.setLink(RandomTestUtil.randomString());

		newFeed.setAutore(RandomTestUtil.randomString());

		newFeed.setQuery(RandomTestUtil.randomString());

		_feeds.add(_persistence.update(newFeed));

		Feed existingFeed = _persistence.findByPrimaryKey(
			newFeed.getPrimaryKey());

		Assert.assertEquals(existingFeed.getFeedId(), newFeed.getFeedId());
		Assert.assertEquals(existingFeed.getTitolo(), newFeed.getTitolo());
		Assert.assertEquals(existingFeed.getLink(), newFeed.getLink());
		Assert.assertEquals(existingFeed.getAutore(), newFeed.getAutore());
		Assert.assertEquals(existingFeed.getQuery(), newFeed.getQuery());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Feed newFeed = addFeed();

		Feed existingFeed = _persistence.findByPrimaryKey(
			newFeed.getPrimaryKey());

		Assert.assertEquals(existingFeed, newFeed);
	}

	@Test(expected = NoSuchFeedException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Feed> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_Feed", "feedId", true, "titolo", true, "link", true,
			"autore", true, "query", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Feed newFeed = addFeed();

		Feed existingFeed = _persistence.fetchByPrimaryKey(
			newFeed.getPrimaryKey());

		Assert.assertEquals(existingFeed, newFeed);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Feed missingFeed = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFeed);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Feed newFeed1 = addFeed();
		Feed newFeed2 = addFeed();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFeed1.getPrimaryKey());
		primaryKeys.add(newFeed2.getPrimaryKey());

		Map<Serializable, Feed> feeds = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, feeds.size());
		Assert.assertEquals(newFeed1, feeds.get(newFeed1.getPrimaryKey()));
		Assert.assertEquals(newFeed2, feeds.get(newFeed2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Feed> feeds = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(feeds.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Feed newFeed = addFeed();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFeed.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Feed> feeds = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, feeds.size());
		Assert.assertEquals(newFeed, feeds.get(newFeed.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Feed> feeds = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(feeds.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Feed newFeed = addFeed();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFeed.getPrimaryKey());

		Map<Serializable, Feed> feeds = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, feeds.size());
		Assert.assertEquals(newFeed, feeds.get(newFeed.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Feed newFeed = addFeed();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Feed.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("feedId", newFeed.getFeedId()));

		List<Feed> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Feed existingFeed = result.get(0);

		Assert.assertEquals(existingFeed, newFeed);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Feed.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"feedId", RandomTestUtil.randomString()));

		List<Feed> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Feed newFeed = addFeed();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Feed.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("feedId"));

		Object newFeedId = newFeed.getFeedId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("feedId", new Object[] {newFeedId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFeedId = result.get(0);

		Assert.assertEquals(existingFeedId, newFeedId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Feed.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("feedId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"feedId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Feed addFeed() throws Exception {
		String pk = RandomTestUtil.randomString();

		Feed feed = _persistence.create(pk);

		feed.setTitolo(RandomTestUtil.randomString());

		feed.setLink(RandomTestUtil.randomString());

		feed.setAutore(RandomTestUtil.randomString());

		feed.setQuery(RandomTestUtil.randomString());

		_feeds.add(_persistence.update(feed));

		return feed;
	}

	private List<Feed> _feeds = new ArrayList<Feed>();
	private FeedPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}