/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.allerter.exception.NoSuchGeografiaException;
import it.eng.allerter.model.Geografia;
import it.eng.allerter.service.persistence.GeografiaPK;
import it.eng.allerter.service.persistence.GeografiaPersistence;
import it.eng.allerter.service.persistence.GeografiaUtil;

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
public class GeografiaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = GeografiaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Geografia> iterator = _geografias.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		GeografiaPK pk = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Geografia geografia = _persistence.create(pk);

		Assert.assertNotNull(geografia);

		Assert.assertEquals(geografia.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Geografia newGeografia = addGeografia();

		_persistence.remove(newGeografia);

		Geografia existingGeografia = _persistence.fetchByPrimaryKey(
			newGeografia.getPrimaryKey());

		Assert.assertNull(existingGeografia);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addGeografia();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		GeografiaPK pk = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Geografia newGeografia = _persistence.create(pk);

		newGeografia.setGeometria(RandomTestUtil.randomString());

		_geografias.add(_persistence.update(newGeografia));

		Geografia existingGeografia = _persistence.findByPrimaryKey(
			newGeografia.getPrimaryKey());

		Assert.assertEquals(
			existingGeografia.getGeografiaId(), newGeografia.getGeografiaId());
		Assert.assertEquals(
			existingGeografia.getTipo(), newGeografia.getTipo());
		Assert.assertEquals(
			existingGeografia.getArea(), newGeografia.getArea());
		Assert.assertEquals(
			existingGeografia.getComplessita(), newGeografia.getComplessita());
		Assert.assertEquals(
			existingGeografia.getGeometria(), newGeografia.getGeometria());
	}

	@Test
	public void testCountByTipo() throws Exception {
		_persistence.countByTipo("");

		_persistence.countByTipo("null");

		_persistence.countByTipo((String)null);
	}

	@Test
	public void testCountByTipoArea() throws Exception {
		_persistence.countByTipoArea("", "");

		_persistence.countByTipoArea("null", "null");

		_persistence.countByTipoArea((String)null, (String)null);
	}

	@Test
	public void testCountByTipoAreaComplessita() throws Exception {
		_persistence.countByTipoAreaComplessita("", "", "");

		_persistence.countByTipoAreaComplessita("null", "null", "null");

		_persistence.countByTipoAreaComplessita(
			(String)null, (String)null, (String)null);
	}

	@Test
	public void testCountByTipoComplessita() throws Exception {
		_persistence.countByTipoComplessita("", "");

		_persistence.countByTipoComplessita("null", "null");

		_persistence.countByTipoComplessita((String)null, (String)null);
	}

	@Test
	public void testCountByIdComplessita() throws Exception {
		_persistence.countByIdComplessita("", "");

		_persistence.countByIdComplessita("null", "null");

		_persistence.countByIdComplessita((String)null, (String)null);
	}

	@Test
	public void testCountByAreaComplessita() throws Exception {
		_persistence.countByAreaComplessita("", "");

		_persistence.countByAreaComplessita("null", "null");

		_persistence.countByAreaComplessita((String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Geografia newGeografia = addGeografia();

		Geografia existingGeografia = _persistence.findByPrimaryKey(
			newGeografia.getPrimaryKey());

		Assert.assertEquals(existingGeografia, newGeografia);
	}

	@Test(expected = NoSuchGeografiaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		GeografiaPK pk = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Geografia newGeografia = addGeografia();

		Geografia existingGeografia = _persistence.fetchByPrimaryKey(
			newGeografia.getPrimaryKey());

		Assert.assertEquals(existingGeografia, newGeografia);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		GeografiaPK pk = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Geografia missingGeografia = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingGeografia);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Geografia newGeografia1 = addGeografia();
		Geografia newGeografia2 = addGeografia();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGeografia1.getPrimaryKey());
		primaryKeys.add(newGeografia2.getPrimaryKey());

		Map<Serializable, Geografia> geografias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, geografias.size());
		Assert.assertEquals(
			newGeografia1, geografias.get(newGeografia1.getPrimaryKey()));
		Assert.assertEquals(
			newGeografia2, geografias.get(newGeografia2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		GeografiaPK pk1 = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		GeografiaPK pk2 = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Geografia> geografias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(geografias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Geografia newGeografia = addGeografia();

		GeografiaPK pk = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGeografia.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Geografia> geografias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, geografias.size());
		Assert.assertEquals(
			newGeografia, geografias.get(newGeografia.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Geografia> geografias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(geografias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Geografia newGeografia = addGeografia();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGeografia.getPrimaryKey());

		Map<Serializable, Geografia> geografias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, geografias.size());
		Assert.assertEquals(
			newGeografia, geografias.get(newGeografia.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Geografia newGeografia = addGeografia();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Geografia.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.geografiaId", newGeografia.getGeografiaId()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.tipo", newGeografia.getTipo()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.area", newGeografia.getArea()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.complessita", newGeografia.getComplessita()));

		List<Geografia> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Geografia existingGeografia = result.get(0);

		Assert.assertEquals(existingGeografia, newGeografia);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Geografia.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.geografiaId", RandomTestUtil.randomString()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.tipo", RandomTestUtil.randomString()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.area", RandomTestUtil.randomString()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.complessita", RandomTestUtil.randomString()));

		List<Geografia> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Geografia newGeografia = addGeografia();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Geografia.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.geografiaId"));

		Object newGeografiaId = newGeografia.getGeografiaId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.geografiaId", new Object[] {newGeografiaId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingGeografiaId = result.get(0);

		Assert.assertEquals(existingGeografiaId, newGeografiaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Geografia.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.geografiaId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.geografiaId",
				new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Geografia addGeografia() throws Exception {
		GeografiaPK pk = new GeografiaPK(
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString());

		Geografia geografia = _persistence.create(pk);

		geografia.setGeometria(RandomTestUtil.randomString());

		_geografias.add(_persistence.update(geografia));

		return geografia;
	}

	private List<Geografia> _geografias = new ArrayList<Geografia>();
	private GeografiaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}