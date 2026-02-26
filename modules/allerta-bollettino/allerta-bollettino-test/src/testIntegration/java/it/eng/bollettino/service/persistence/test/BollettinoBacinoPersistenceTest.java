/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.test;

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

import it.eng.bollettino.exception.NoSuchBollettinoBacinoException;
import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.service.BollettinoBacinoLocalServiceUtil;
import it.eng.bollettino.service.persistence.BollettinoBacinoPersistence;
import it.eng.bollettino.service.persistence.BollettinoBacinoUtil;

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
public class BollettinoBacinoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = BollettinoBacinoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BollettinoBacino> iterator = _bollettinoBacinos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoBacino bollettinoBacino = _persistence.create(pk);

		Assert.assertNotNull(bollettinoBacino);

		Assert.assertEquals(bollettinoBacino.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		_persistence.remove(newBollettinoBacino);

		BollettinoBacino existingBollettinoBacino =
			_persistence.fetchByPrimaryKey(newBollettinoBacino.getPrimaryKey());

		Assert.assertNull(existingBollettinoBacino);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBollettinoBacino();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoBacino newBollettinoBacino = _persistence.create(pk);

		newBollettinoBacino.setUuid(RandomTestUtil.randomString());

		newBollettinoBacino.setIdBollettino(RandomTestUtil.nextLong());

		newBollettinoBacino.setProgressivo(RandomTestUtil.nextInt());

		newBollettinoBacino.setIdBacino(RandomTestUtil.randomString());

		newBollettinoBacino.setNomeBacino(RandomTestUtil.randomString());

		newBollettinoBacino.setOreOsservazione(RandomTestUtil.randomString());

		newBollettinoBacino.setNote(RandomTestUtil.randomString());

		_bollettinoBacinos.add(_persistence.update(newBollettinoBacino));

		BollettinoBacino existingBollettinoBacino =
			_persistence.findByPrimaryKey(newBollettinoBacino.getPrimaryKey());

		Assert.assertEquals(
			existingBollettinoBacino.getUuid(), newBollettinoBacino.getUuid());
		Assert.assertEquals(
			existingBollettinoBacino.getId(), newBollettinoBacino.getId());
		Assert.assertEquals(
			existingBollettinoBacino.getIdBollettino(),
			newBollettinoBacino.getIdBollettino());
		Assert.assertEquals(
			existingBollettinoBacino.getProgressivo(),
			newBollettinoBacino.getProgressivo());
		Assert.assertEquals(
			existingBollettinoBacino.getIdBacino(),
			newBollettinoBacino.getIdBacino());
		Assert.assertEquals(
			existingBollettinoBacino.getNomeBacino(),
			newBollettinoBacino.getNomeBacino());
		Assert.assertEquals(
			existingBollettinoBacino.getOreOsservazione(),
			newBollettinoBacino.getOreOsservazione());
		Assert.assertEquals(
			existingBollettinoBacino.getNote(), newBollettinoBacino.getNote());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByBollettino() throws Exception {
		_persistence.countByBollettino(RandomTestUtil.nextLong());

		_persistence.countByBollettino(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		BollettinoBacino existingBollettinoBacino =
			_persistence.findByPrimaryKey(newBollettinoBacino.getPrimaryKey());

		Assert.assertEquals(existingBollettinoBacino, newBollettinoBacino);
	}

	@Test(expected = NoSuchBollettinoBacinoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BollettinoBacino> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_BollettinoBacino", "uuid", true, "id", true,
			"idBollettino", true, "progressivo", true, "idBacino", true,
			"nomeBacino", true, "oreOsservazione", true, "note", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		BollettinoBacino existingBollettinoBacino =
			_persistence.fetchByPrimaryKey(newBollettinoBacino.getPrimaryKey());

		Assert.assertEquals(existingBollettinoBacino, newBollettinoBacino);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoBacino missingBollettinoBacino =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBollettinoBacino);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BollettinoBacino newBollettinoBacino1 = addBollettinoBacino();
		BollettinoBacino newBollettinoBacino2 = addBollettinoBacino();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoBacino1.getPrimaryKey());
		primaryKeys.add(newBollettinoBacino2.getPrimaryKey());

		Map<Serializable, BollettinoBacino> bollettinoBacinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bollettinoBacinos.size());
		Assert.assertEquals(
			newBollettinoBacino1,
			bollettinoBacinos.get(newBollettinoBacino1.getPrimaryKey()));
		Assert.assertEquals(
			newBollettinoBacino2,
			bollettinoBacinos.get(newBollettinoBacino2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BollettinoBacino> bollettinoBacinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoBacinos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoBacino.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BollettinoBacino> bollettinoBacinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoBacinos.size());
		Assert.assertEquals(
			newBollettinoBacino,
			bollettinoBacinos.get(newBollettinoBacino.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BollettinoBacino> bollettinoBacinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoBacinos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoBacino.getPrimaryKey());

		Map<Serializable, BollettinoBacino> bollettinoBacinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoBacinos.size());
		Assert.assertEquals(
			newBollettinoBacino,
			bollettinoBacinos.get(newBollettinoBacino.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BollettinoBacinoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<BollettinoBacino>() {

				@Override
				public void performAction(BollettinoBacino bollettinoBacino) {
					Assert.assertNotNull(bollettinoBacino);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoBacino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newBollettinoBacino.getId()));

		List<BollettinoBacino> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BollettinoBacino existingBollettinoBacino = result.get(0);

		Assert.assertEquals(existingBollettinoBacino, newBollettinoBacino);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoBacino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<BollettinoBacino> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BollettinoBacino newBollettinoBacino = addBollettinoBacino();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoBacino.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newBollettinoBacino.getId();

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
			BollettinoBacino.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected BollettinoBacino addBollettinoBacino() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoBacino bollettinoBacino = _persistence.create(pk);

		bollettinoBacino.setUuid(RandomTestUtil.randomString());

		bollettinoBacino.setIdBollettino(RandomTestUtil.nextLong());

		bollettinoBacino.setProgressivo(RandomTestUtil.nextInt());

		bollettinoBacino.setIdBacino(RandomTestUtil.randomString());

		bollettinoBacino.setNomeBacino(RandomTestUtil.randomString());

		bollettinoBacino.setOreOsservazione(RandomTestUtil.randomString());

		bollettinoBacino.setNote(RandomTestUtil.randomString());

		_bollettinoBacinos.add(_persistence.update(bollettinoBacino));

		return bollettinoBacino;
	}

	private List<BollettinoBacino> _bollettinoBacinos =
		new ArrayList<BollettinoBacino>();
	private BollettinoBacinoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}