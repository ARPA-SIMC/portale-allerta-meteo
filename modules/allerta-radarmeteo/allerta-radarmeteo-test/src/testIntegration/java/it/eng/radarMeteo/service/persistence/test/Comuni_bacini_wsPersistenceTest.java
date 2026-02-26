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

import it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException;
import it.eng.radarMeteo.model.Comuni_bacini_ws;
import it.eng.radarMeteo.service.Comuni_bacini_wsLocalServiceUtil;
import it.eng.radarMeteo.service.persistence.Comuni_bacini_wsPersistence;
import it.eng.radarMeteo.service.persistence.Comuni_bacini_wsUtil;

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
public class Comuni_bacini_wsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.radarMeteo.service"));

	@Before
	public void setUp() {
		_persistence = Comuni_bacini_wsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Comuni_bacini_ws> iterator = _comuni_bacini_wses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Comuni_bacini_ws comuni_bacini_ws = _persistence.create(pk);

		Assert.assertNotNull(comuni_bacini_ws);

		Assert.assertEquals(comuni_bacini_ws.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		_persistence.remove(newComuni_bacini_ws);

		Comuni_bacini_ws existingComuni_bacini_ws =
			_persistence.fetchByPrimaryKey(newComuni_bacini_ws.getPrimaryKey());

		Assert.assertNull(existingComuni_bacini_ws);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addComuni_bacini_ws();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Comuni_bacini_ws newComuni_bacini_ws = _persistence.create(pk);

		newComuni_bacini_ws.setComune(RandomTestUtil.randomString());

		newComuni_bacini_ws.setProvincia(RandomTestUtil.randomString());

		newComuni_bacini_ws.setBacino(RandomTestUtil.randomString());

		_comuni_bacini_wses.add(_persistence.update(newComuni_bacini_ws));

		Comuni_bacini_ws existingComuni_bacini_ws =
			_persistence.findByPrimaryKey(newComuni_bacini_ws.getPrimaryKey());

		Assert.assertEquals(
			existingComuni_bacini_ws.getIdBacini(),
			newComuni_bacini_ws.getIdBacini());
		Assert.assertEquals(
			existingComuni_bacini_ws.getComune(),
			newComuni_bacini_ws.getComune());
		Assert.assertEquals(
			existingComuni_bacini_ws.getProvincia(),
			newComuni_bacini_ws.getProvincia());
		Assert.assertEquals(
			existingComuni_bacini_ws.getBacino(),
			newComuni_bacini_ws.getBacino());
	}

	@Test
	public void testCountByBacino() throws Exception {
		_persistence.countByBacino("");

		_persistence.countByBacino("null");

		_persistence.countByBacino((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		Comuni_bacini_ws existingComuni_bacini_ws =
			_persistence.findByPrimaryKey(newComuni_bacini_ws.getPrimaryKey());

		Assert.assertEquals(existingComuni_bacini_ws, newComuni_bacini_ws);
	}

	@Test(expected = NoSuchComuni_bacini_wsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Comuni_bacini_ws> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rt_portlet_comuni_bacini_ws", "idBacini", true, "comune", true,
			"provincia", true, "bacino", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		Comuni_bacini_ws existingComuni_bacini_ws =
			_persistence.fetchByPrimaryKey(newComuni_bacini_ws.getPrimaryKey());

		Assert.assertEquals(existingComuni_bacini_ws, newComuni_bacini_ws);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Comuni_bacini_ws missingComuni_bacini_ws =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingComuni_bacini_ws);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Comuni_bacini_ws newComuni_bacini_ws1 = addComuni_bacini_ws();
		Comuni_bacini_ws newComuni_bacini_ws2 = addComuni_bacini_ws();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComuni_bacini_ws1.getPrimaryKey());
		primaryKeys.add(newComuni_bacini_ws2.getPrimaryKey());

		Map<Serializable, Comuni_bacini_ws> comuni_bacini_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, comuni_bacini_wses.size());
		Assert.assertEquals(
			newComuni_bacini_ws1,
			comuni_bacini_wses.get(newComuni_bacini_ws1.getPrimaryKey()));
		Assert.assertEquals(
			newComuni_bacini_ws2,
			comuni_bacini_wses.get(newComuni_bacini_ws2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		int pk1 = RandomTestUtil.nextInt();

		int pk2 = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Comuni_bacini_ws> comuni_bacini_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(comuni_bacini_wses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		int pk = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComuni_bacini_ws.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Comuni_bacini_ws> comuni_bacini_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, comuni_bacini_wses.size());
		Assert.assertEquals(
			newComuni_bacini_ws,
			comuni_bacini_wses.get(newComuni_bacini_ws.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Comuni_bacini_ws> comuni_bacini_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(comuni_bacini_wses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComuni_bacini_ws.getPrimaryKey());

		Map<Serializable, Comuni_bacini_ws> comuni_bacini_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, comuni_bacini_wses.size());
		Assert.assertEquals(
			newComuni_bacini_ws,
			comuni_bacini_wses.get(newComuni_bacini_ws.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			Comuni_bacini_wsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Comuni_bacini_ws>() {

				@Override
				public void performAction(Comuni_bacini_ws comuni_bacini_ws) {
					Assert.assertNotNull(comuni_bacini_ws);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_bacini_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"idBacini", newComuni_bacini_ws.getIdBacini()));

		List<Comuni_bacini_ws> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Comuni_bacini_ws existingComuni_bacini_ws = result.get(0);

		Assert.assertEquals(existingComuni_bacini_ws, newComuni_bacini_ws);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_bacini_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("idBacini", RandomTestUtil.nextInt()));

		List<Comuni_bacini_ws> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Comuni_bacini_ws newComuni_bacini_ws = addComuni_bacini_ws();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_bacini_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("idBacini"));

		Object newIdBacini = newComuni_bacini_ws.getIdBacini();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("idBacini", new Object[] {newIdBacini}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingIdBacini = result.get(0);

		Assert.assertEquals(existingIdBacini, newIdBacini);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_bacini_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("idBacini"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"idBacini", new Object[] {RandomTestUtil.nextInt()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Comuni_bacini_ws addComuni_bacini_ws() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Comuni_bacini_ws comuni_bacini_ws = _persistence.create(pk);

		comuni_bacini_ws.setComune(RandomTestUtil.randomString());

		comuni_bacini_ws.setProvincia(RandomTestUtil.randomString());

		comuni_bacini_ws.setBacino(RandomTestUtil.randomString());

		_comuni_bacini_wses.add(_persistence.update(comuni_bacini_ws));

		return comuni_bacini_ws;
	}

	private List<Comuni_bacini_ws> _comuni_bacini_wses =
		new ArrayList<Comuni_bacini_ws>();
	private Comuni_bacini_wsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}