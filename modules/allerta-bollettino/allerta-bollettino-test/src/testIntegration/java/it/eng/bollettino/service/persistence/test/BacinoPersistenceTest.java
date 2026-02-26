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

import it.eng.bollettino.exception.NoSuchBacinoException;
import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.service.persistence.BacinoPersistence;
import it.eng.bollettino.service.persistence.BacinoUtil;

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
public class BacinoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = BacinoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Bacino> iterator = _bacinos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Bacino bacino = _persistence.create(pk);

		Assert.assertNotNull(bacino);

		Assert.assertEquals(bacino.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Bacino newBacino = addBacino();

		_persistence.remove(newBacino);

		Bacino existingBacino = _persistence.fetchByPrimaryKey(
			newBacino.getPrimaryKey());

		Assert.assertNull(existingBacino);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBacino();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Bacino newBacino = _persistence.create(pk);

		newBacino.setUuid(RandomTestUtil.randomString());

		newBacino.setNome(RandomTestUtil.randomString());

		newBacino.setProgressivo(RandomTestUtil.nextInt());

		_bacinos.add(_persistence.update(newBacino));

		Bacino existingBacino = _persistence.findByPrimaryKey(
			newBacino.getPrimaryKey());

		Assert.assertEquals(existingBacino.getUuid(), newBacino.getUuid());
		Assert.assertEquals(existingBacino.getId(), newBacino.getId());
		Assert.assertEquals(existingBacino.getNome(), newBacino.getNome());
		Assert.assertEquals(
			existingBacino.getProgressivo(), newBacino.getProgressivo());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Bacino newBacino = addBacino();

		Bacino existingBacino = _persistence.findByPrimaryKey(
			newBacino.getPrimaryKey());

		Assert.assertEquals(existingBacino, newBacino);
	}

	@Test(expected = NoSuchBacinoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Bacino> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Bacino", "uuid", true, "id", true, "nome", true,
			"progressivo", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Bacino newBacino = addBacino();

		Bacino existingBacino = _persistence.fetchByPrimaryKey(
			newBacino.getPrimaryKey());

		Assert.assertEquals(existingBacino, newBacino);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Bacino missingBacino = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBacino);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Bacino newBacino1 = addBacino();
		Bacino newBacino2 = addBacino();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBacino1.getPrimaryKey());
		primaryKeys.add(newBacino2.getPrimaryKey());

		Map<Serializable, Bacino> bacinos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, bacinos.size());
		Assert.assertEquals(
			newBacino1, bacinos.get(newBacino1.getPrimaryKey()));
		Assert.assertEquals(
			newBacino2, bacinos.get(newBacino2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Bacino> bacinos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(bacinos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Bacino newBacino = addBacino();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBacino.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Bacino> bacinos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, bacinos.size());
		Assert.assertEquals(newBacino, bacinos.get(newBacino.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Bacino> bacinos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(bacinos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Bacino newBacino = addBacino();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBacino.getPrimaryKey());

		Map<Serializable, Bacino> bacinos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, bacinos.size());
		Assert.assertEquals(newBacino, bacinos.get(newBacino.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Bacino newBacino = addBacino();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bacino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newBacino.getId()));

		List<Bacino> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Bacino existingBacino = result.get(0);

		Assert.assertEquals(existingBacino, newBacino);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bacino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.randomString()));

		List<Bacino> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Bacino newBacino = addBacino();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bacino.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newBacino.getId();

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
			Bacino.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Bacino addBacino() throws Exception {
		String pk = RandomTestUtil.randomString();

		Bacino bacino = _persistence.create(pk);

		bacino.setUuid(RandomTestUtil.randomString());

		bacino.setNome(RandomTestUtil.randomString());

		bacino.setProgressivo(RandomTestUtil.nextInt());

		_bacinos.add(_persistence.update(bacino));

		return bacino;
	}

	private List<Bacino> _bacinos = new ArrayList<Bacino>();
	private BacinoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}