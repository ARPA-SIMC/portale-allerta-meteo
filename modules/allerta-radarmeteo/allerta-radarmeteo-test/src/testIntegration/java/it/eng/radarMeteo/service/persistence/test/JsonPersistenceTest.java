/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.radarMeteo.exception.NoSuchJsonException;
import it.eng.radarMeteo.model.Json;
import it.eng.radarMeteo.service.JsonLocalServiceUtil;
import it.eng.radarMeteo.service.persistence.JsonPersistence;
import it.eng.radarMeteo.service.persistence.JsonUtil;

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
public class JsonPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.radarMeteo.service"));

	@Before
	public void setUp() {
		_persistence = JsonUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Json> iterator = _jsons.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Json json = _persistence.create(pk);

		Assert.assertNotNull(json);

		Assert.assertEquals(json.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Json newJson = addJson();

		_persistence.remove(newJson);

		Json existingJson = _persistence.fetchByPrimaryKey(
			newJson.getPrimaryKey());

		Assert.assertNull(existingJson);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addJson();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Json newJson = _persistence.create(pk);

		newJson.setType(RandomTestUtil.randomString());

		newJson.setInserted(RandomTestUtil.nextLong());

		newJson.setData(RandomTestUtil.randomString());

		_jsons.add(_persistence.update(newJson));

		Json existingJson = _persistence.findByPrimaryKey(
			newJson.getPrimaryKey());

		Assert.assertEquals(existingJson.getId(), newJson.getId());
		Assert.assertEquals(existingJson.getType(), newJson.getType());
		Assert.assertEquals(existingJson.getInserted(), newJson.getInserted());
		Assert.assertEquals(existingJson.getData(), newJson.getData());
	}

	@Test
	public void testCountBytype() throws Exception {
		_persistence.countBytype("");

		_persistence.countBytype("null");

		_persistence.countBytype((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Json newJson = addJson();

		Json existingJson = _persistence.findByPrimaryKey(
			newJson.getPrimaryKey());

		Assert.assertEquals(existingJson, newJson);
	}

	@Test(expected = NoSuchJsonException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Json> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rt_portlet_json", "id", true, "type", true, "inserted", true,
			"data", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Json newJson = addJson();

		Json existingJson = _persistence.fetchByPrimaryKey(
			newJson.getPrimaryKey());

		Assert.assertEquals(existingJson, newJson);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Json missingJson = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingJson);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Json newJson1 = addJson();
		Json newJson2 = addJson();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newJson1.getPrimaryKey());
		primaryKeys.add(newJson2.getPrimaryKey());

		Map<Serializable, Json> jsons = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, jsons.size());
		Assert.assertEquals(newJson1, jsons.get(newJson1.getPrimaryKey()));
		Assert.assertEquals(newJson2, jsons.get(newJson2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Json> jsons = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(jsons.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Json newJson = addJson();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newJson.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Json> jsons = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, jsons.size());
		Assert.assertEquals(newJson, jsons.get(newJson.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Json> jsons = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(jsons.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Json newJson = addJson();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newJson.getPrimaryKey());

		Map<Serializable, Json> jsons = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, jsons.size());
		Assert.assertEquals(newJson, jsons.get(newJson.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			JsonLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Json>() {

				@Override
				public void performAction(Json json) {
					Assert.assertNotNull(json);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Json newJson = addJson();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Json.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newJson.getId()));

		List<Json> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Json existingJson = result.get(0);

		Assert.assertEquals(existingJson, newJson);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Json.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Json> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Json newJson = addJson();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Json.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newJson.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Json.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Json addJson() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Json json = _persistence.create(pk);

		json.setType(RandomTestUtil.randomString());

		json.setInserted(RandomTestUtil.nextLong());

		json.setData(RandomTestUtil.randomString());

		_jsons.add(_persistence.update(json));

		return json;
	}

	private List<Json> _jsons = new ArrayList<Json>();
	private JsonPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}