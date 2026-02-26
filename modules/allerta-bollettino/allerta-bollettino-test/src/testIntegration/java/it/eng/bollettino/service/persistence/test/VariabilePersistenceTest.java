/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.test;

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

import it.eng.bollettino.exception.NoSuchVariabileException;
import it.eng.bollettino.model.Variabile;
import it.eng.bollettino.service.persistence.VariabilePersistence;
import it.eng.bollettino.service.persistence.VariabileUtil;

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
public class VariabilePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = VariabileUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Variabile> iterator = _variabiles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Variabile variabile = _persistence.create(pk);

		Assert.assertNotNull(variabile);

		Assert.assertEquals(variabile.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Variabile newVariabile = addVariabile();

		_persistence.remove(newVariabile);

		Variabile existingVariabile = _persistence.fetchByPrimaryKey(
			newVariabile.getPrimaryKey());

		Assert.assertNull(existingVariabile);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVariabile();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Variabile newVariabile = _persistence.create(pk);

		newVariabile.setUuid(RandomTestUtil.randomString());

		newVariabile.setDescription_it(RandomTestUtil.randomString());

		newVariabile.setLevel_t1(RandomTestUtil.nextInt());

		newVariabile.setLevel_t2(RandomTestUtil.nextInt());

		newVariabile.setLevel_v1(RandomTestUtil.nextInt());

		newVariabile.setLevel_v2(RandomTestUtil.nextInt());

		newVariabile.setTrange_p1(RandomTestUtil.nextInt());

		newVariabile.setTrange_p2(RandomTestUtil.nextInt());

		newVariabile.setTrange_pind(RandomTestUtil.nextInt());

		newVariabile.setUnit(RandomTestUtil.randomString());

		newVariabile.setBcode(RandomTestUtil.randomString());

		_variabiles.add(_persistence.update(newVariabile));

		Variabile existingVariabile = _persistence.findByPrimaryKey(
			newVariabile.getPrimaryKey());

		Assert.assertEquals(
			existingVariabile.getUuid(), newVariabile.getUuid());
		Assert.assertEquals(existingVariabile.getId(), newVariabile.getId());
		Assert.assertEquals(
			existingVariabile.getDescription_it(),
			newVariabile.getDescription_it());
		Assert.assertEquals(
			existingVariabile.getLevel_t1(), newVariabile.getLevel_t1());
		Assert.assertEquals(
			existingVariabile.getLevel_t2(), newVariabile.getLevel_t2());
		Assert.assertEquals(
			existingVariabile.getLevel_v1(), newVariabile.getLevel_v1());
		Assert.assertEquals(
			existingVariabile.getLevel_v2(), newVariabile.getLevel_v2());
		Assert.assertEquals(
			existingVariabile.getTrange_p1(), newVariabile.getTrange_p1());
		Assert.assertEquals(
			existingVariabile.getTrange_p2(), newVariabile.getTrange_p2());
		Assert.assertEquals(
			existingVariabile.getTrange_pind(), newVariabile.getTrange_pind());
		Assert.assertEquals(
			existingVariabile.getUnit(), newVariabile.getUnit());
		Assert.assertEquals(
			existingVariabile.getBcode(), newVariabile.getBcode());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Variabile newVariabile = addVariabile();

		Variabile existingVariabile = _persistence.findByPrimaryKey(
			newVariabile.getPrimaryKey());

		Assert.assertEquals(existingVariabile, newVariabile);
	}

	@Test(expected = NoSuchVariabileException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Variabile> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Variabile", "uuid", true, "id", true, "description_it",
			true, "level_t1", true, "level_t2", true, "level_v1", true,
			"level_v2", true, "trange_p1", true, "trange_p2", true,
			"trange_pind", true, "unit", true, "bcode", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Variabile newVariabile = addVariabile();

		Variabile existingVariabile = _persistence.fetchByPrimaryKey(
			newVariabile.getPrimaryKey());

		Assert.assertEquals(existingVariabile, newVariabile);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Variabile missingVariabile = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVariabile);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Variabile newVariabile1 = addVariabile();
		Variabile newVariabile2 = addVariabile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVariabile1.getPrimaryKey());
		primaryKeys.add(newVariabile2.getPrimaryKey());

		Map<Serializable, Variabile> variabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, variabiles.size());
		Assert.assertEquals(
			newVariabile1, variabiles.get(newVariabile1.getPrimaryKey()));
		Assert.assertEquals(
			newVariabile2, variabiles.get(newVariabile2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Variabile> variabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(variabiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Variabile newVariabile = addVariabile();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVariabile.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Variabile> variabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, variabiles.size());
		Assert.assertEquals(
			newVariabile, variabiles.get(newVariabile.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Variabile> variabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(variabiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Variabile newVariabile = addVariabile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVariabile.getPrimaryKey());

		Map<Serializable, Variabile> variabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, variabiles.size());
		Assert.assertEquals(
			newVariabile, variabiles.get(newVariabile.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Variabile newVariabile = addVariabile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Variabile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newVariabile.getId()));

		List<Variabile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Variabile existingVariabile = result.get(0);

		Assert.assertEquals(existingVariabile, newVariabile);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Variabile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.randomString()));

		List<Variabile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Variabile newVariabile = addVariabile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Variabile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVariabile.getId();

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
			Variabile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Variabile addVariabile() throws Exception {
		String pk = RandomTestUtil.randomString();

		Variabile variabile = _persistence.create(pk);

		variabile.setUuid(RandomTestUtil.randomString());

		variabile.setDescription_it(RandomTestUtil.randomString());

		variabile.setLevel_t1(RandomTestUtil.nextInt());

		variabile.setLevel_t2(RandomTestUtil.nextInt());

		variabile.setLevel_v1(RandomTestUtil.nextInt());

		variabile.setLevel_v2(RandomTestUtil.nextInt());

		variabile.setTrange_p1(RandomTestUtil.nextInt());

		variabile.setTrange_p2(RandomTestUtil.nextInt());

		variabile.setTrange_pind(RandomTestUtil.nextInt());

		variabile.setUnit(RandomTestUtil.randomString());

		variabile.setBcode(RandomTestUtil.randomString());

		_variabiles.add(_persistence.update(variabile));

		return variabile;
	}

	private List<Variabile> _variabiles = new ArrayList<Variabile>();
	private VariabilePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}