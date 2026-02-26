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
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.bollettino.exception.NoSuchBollettinoIconaException;
import it.eng.bollettino.model.BollettinoIcona;
import it.eng.bollettino.service.BollettinoIconaLocalServiceUtil;
import it.eng.bollettino.service.persistence.BollettinoIconaPersistence;
import it.eng.bollettino.service.persistence.BollettinoIconaUtil;

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
public class BollettinoIconaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = BollettinoIconaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BollettinoIcona> iterator = _bollettinoIconas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoIcona bollettinoIcona = _persistence.create(pk);

		Assert.assertNotNull(bollettinoIcona);

		Assert.assertEquals(bollettinoIcona.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		_persistence.remove(newBollettinoIcona);

		BollettinoIcona existingBollettinoIcona =
			_persistence.fetchByPrimaryKey(newBollettinoIcona.getPrimaryKey());

		Assert.assertNull(existingBollettinoIcona);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBollettinoIcona();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoIcona newBollettinoIcona = _persistence.create(pk);

		newBollettinoIcona.setUuid(RandomTestUtil.randomString());

		newBollettinoIcona.setIdBollettino(RandomTestUtil.nextLong());

		newBollettinoIcona.setIdIcona(RandomTestUtil.nextLong());

		newBollettinoIcona.setX(RandomTestUtil.nextDouble());

		newBollettinoIcona.setY(RandomTestUtil.nextDouble());

		_bollettinoIconas.add(_persistence.update(newBollettinoIcona));

		BollettinoIcona existingBollettinoIcona = _persistence.findByPrimaryKey(
			newBollettinoIcona.getPrimaryKey());

		Assert.assertEquals(
			existingBollettinoIcona.getUuid(), newBollettinoIcona.getUuid());
		Assert.assertEquals(
			existingBollettinoIcona.getId(), newBollettinoIcona.getId());
		Assert.assertEquals(
			existingBollettinoIcona.getIdBollettino(),
			newBollettinoIcona.getIdBollettino());
		Assert.assertEquals(
			existingBollettinoIcona.getIdIcona(),
			newBollettinoIcona.getIdIcona());
		AssertUtils.assertEquals(
			existingBollettinoIcona.getX(), newBollettinoIcona.getX());
		AssertUtils.assertEquals(
			existingBollettinoIcona.getY(), newBollettinoIcona.getY());
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
		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		BollettinoIcona existingBollettinoIcona = _persistence.findByPrimaryKey(
			newBollettinoIcona.getPrimaryKey());

		Assert.assertEquals(existingBollettinoIcona, newBollettinoIcona);
	}

	@Test(expected = NoSuchBollettinoIconaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BollettinoIcona> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_BollettinoIcona", "uuid", true, "id", true,
			"idBollettino", true, "idIcona", true, "x", true, "y", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		BollettinoIcona existingBollettinoIcona =
			_persistence.fetchByPrimaryKey(newBollettinoIcona.getPrimaryKey());

		Assert.assertEquals(existingBollettinoIcona, newBollettinoIcona);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoIcona missingBollettinoIcona = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingBollettinoIcona);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BollettinoIcona newBollettinoIcona1 = addBollettinoIcona();
		BollettinoIcona newBollettinoIcona2 = addBollettinoIcona();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoIcona1.getPrimaryKey());
		primaryKeys.add(newBollettinoIcona2.getPrimaryKey());

		Map<Serializable, BollettinoIcona> bollettinoIconas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bollettinoIconas.size());
		Assert.assertEquals(
			newBollettinoIcona1,
			bollettinoIconas.get(newBollettinoIcona1.getPrimaryKey()));
		Assert.assertEquals(
			newBollettinoIcona2,
			bollettinoIconas.get(newBollettinoIcona2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BollettinoIcona> bollettinoIconas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoIconas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoIcona.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BollettinoIcona> bollettinoIconas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoIconas.size());
		Assert.assertEquals(
			newBollettinoIcona,
			bollettinoIconas.get(newBollettinoIcona.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BollettinoIcona> bollettinoIconas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoIconas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoIcona.getPrimaryKey());

		Map<Serializable, BollettinoIcona> bollettinoIconas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoIconas.size());
		Assert.assertEquals(
			newBollettinoIcona,
			bollettinoIconas.get(newBollettinoIcona.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BollettinoIconaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<BollettinoIcona>() {

				@Override
				public void performAction(BollettinoIcona bollettinoIcona) {
					Assert.assertNotNull(bollettinoIcona);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoIcona.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newBollettinoIcona.getId()));

		List<BollettinoIcona> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BollettinoIcona existingBollettinoIcona = result.get(0);

		Assert.assertEquals(existingBollettinoIcona, newBollettinoIcona);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoIcona.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<BollettinoIcona> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BollettinoIcona newBollettinoIcona = addBollettinoIcona();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoIcona.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newBollettinoIcona.getId();

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
			BollettinoIcona.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected BollettinoIcona addBollettinoIcona() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoIcona bollettinoIcona = _persistence.create(pk);

		bollettinoIcona.setUuid(RandomTestUtil.randomString());

		bollettinoIcona.setIdBollettino(RandomTestUtil.nextLong());

		bollettinoIcona.setIdIcona(RandomTestUtil.nextLong());

		bollettinoIcona.setX(RandomTestUtil.nextDouble());

		bollettinoIcona.setY(RandomTestUtil.nextDouble());

		_bollettinoIconas.add(_persistence.update(bollettinoIcona));

		return bollettinoIcona;
	}

	private List<BollettinoIcona> _bollettinoIconas =
		new ArrayList<BollettinoIcona>();
	private BollettinoIconaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}