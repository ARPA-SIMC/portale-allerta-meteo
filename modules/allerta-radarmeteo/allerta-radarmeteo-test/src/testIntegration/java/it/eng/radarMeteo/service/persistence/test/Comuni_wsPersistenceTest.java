/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence.test;

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

import it.eng.radarMeteo.exception.NoSuchComuni_wsException;
import it.eng.radarMeteo.model.Comuni_ws;
import it.eng.radarMeteo.service.persistence.Comuni_wsPersistence;
import it.eng.radarMeteo.service.persistence.Comuni_wsUtil;

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
public class Comuni_wsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.radarMeteo.service"));

	@Before
	public void setUp() {
		_persistence = Comuni_wsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Comuni_ws> iterator = _comuni_wses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Comuni_ws comuni_ws = _persistence.create(pk);

		Assert.assertNotNull(comuni_ws);

		Assert.assertEquals(comuni_ws.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Comuni_ws newComuni_ws = addComuni_ws();

		_persistence.remove(newComuni_ws);

		Comuni_ws existingComuni_ws = _persistence.fetchByPrimaryKey(
			newComuni_ws.getPrimaryKey());

		Assert.assertNull(existingComuni_ws);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addComuni_ws();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Comuni_ws newComuni_ws = _persistence.create(pk);

		newComuni_ws.setComune(RandomTestUtil.randomString());

		newComuni_ws.setProvincia(RandomTestUtil.randomString());

		newComuni_ws.setSottozona(RandomTestUtil.randomString());

		newComuni_ws.setZonaallerta(RandomTestUtil.randomString());

		_comuni_wses.add(_persistence.update(newComuni_ws));

		Comuni_ws existingComuni_ws = _persistence.findByPrimaryKey(
			newComuni_ws.getPrimaryKey());

		Assert.assertEquals(
			existingComuni_ws.getIdIstat(), newComuni_ws.getIdIstat());
		Assert.assertEquals(
			existingComuni_ws.getComune(), newComuni_ws.getComune());
		Assert.assertEquals(
			existingComuni_ws.getProvincia(), newComuni_ws.getProvincia());
		Assert.assertEquals(
			existingComuni_ws.getSottozona(), newComuni_ws.getSottozona());
		Assert.assertEquals(
			existingComuni_ws.getZonaallerta(), newComuni_ws.getZonaallerta());
	}

	@Test
	public void testCountBySottozona() throws Exception {
		_persistence.countBySottozona("");

		_persistence.countBySottozona("null");

		_persistence.countBySottozona((String)null);
	}

	@Test
	public void testCountByZonaallerta() throws Exception {
		_persistence.countByZonaallerta("");

		_persistence.countByZonaallerta("null");

		_persistence.countByZonaallerta((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Comuni_ws newComuni_ws = addComuni_ws();

		Comuni_ws existingComuni_ws = _persistence.findByPrimaryKey(
			newComuni_ws.getPrimaryKey());

		Assert.assertEquals(existingComuni_ws, newComuni_ws);
	}

	@Test(expected = NoSuchComuni_wsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Comuni_ws> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rt_portlet_comuni_ws", "idIstat", true, "comune", true,
			"provincia", true, "sottozona", true, "zonaallerta", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Comuni_ws newComuni_ws = addComuni_ws();

		Comuni_ws existingComuni_ws = _persistence.fetchByPrimaryKey(
			newComuni_ws.getPrimaryKey());

		Assert.assertEquals(existingComuni_ws, newComuni_ws);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Comuni_ws missingComuni_ws = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingComuni_ws);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Comuni_ws newComuni_ws1 = addComuni_ws();
		Comuni_ws newComuni_ws2 = addComuni_ws();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComuni_ws1.getPrimaryKey());
		primaryKeys.add(newComuni_ws2.getPrimaryKey());

		Map<Serializable, Comuni_ws> comuni_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, comuni_wses.size());
		Assert.assertEquals(
			newComuni_ws1, comuni_wses.get(newComuni_ws1.getPrimaryKey()));
		Assert.assertEquals(
			newComuni_ws2, comuni_wses.get(newComuni_ws2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Comuni_ws> comuni_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(comuni_wses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Comuni_ws newComuni_ws = addComuni_ws();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComuni_ws.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Comuni_ws> comuni_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, comuni_wses.size());
		Assert.assertEquals(
			newComuni_ws, comuni_wses.get(newComuni_ws.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Comuni_ws> comuni_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(comuni_wses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Comuni_ws newComuni_ws = addComuni_ws();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComuni_ws.getPrimaryKey());

		Map<Serializable, Comuni_ws> comuni_wses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, comuni_wses.size());
		Assert.assertEquals(
			newComuni_ws, comuni_wses.get(newComuni_ws.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Comuni_ws newComuni_ws = addComuni_ws();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("idIstat", newComuni_ws.getIdIstat()));

		List<Comuni_ws> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Comuni_ws existingComuni_ws = result.get(0);

		Assert.assertEquals(existingComuni_ws, newComuni_ws);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"idIstat", RandomTestUtil.randomString()));

		List<Comuni_ws> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Comuni_ws newComuni_ws = addComuni_ws();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("idIstat"));

		Object newIdIstat = newComuni_ws.getIdIstat();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("idIstat", new Object[] {newIdIstat}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingIdIstat = result.get(0);

		Assert.assertEquals(existingIdIstat, newIdIstat);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Comuni_ws.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("idIstat"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"idIstat", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Comuni_ws addComuni_ws() throws Exception {
		String pk = RandomTestUtil.randomString();

		Comuni_ws comuni_ws = _persistence.create(pk);

		comuni_ws.setComune(RandomTestUtil.randomString());

		comuni_ws.setProvincia(RandomTestUtil.randomString());

		comuni_ws.setSottozona(RandomTestUtil.randomString());

		comuni_ws.setZonaallerta(RandomTestUtil.randomString());

		_comuni_wses.add(_persistence.update(comuni_ws));

		return comuni_ws;
	}

	private List<Comuni_ws> _comuni_wses = new ArrayList<Comuni_ws>();
	private Comuni_wsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}