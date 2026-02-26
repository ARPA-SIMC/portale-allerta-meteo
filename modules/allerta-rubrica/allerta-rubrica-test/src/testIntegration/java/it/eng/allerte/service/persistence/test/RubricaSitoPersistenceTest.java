/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.test;

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

import it.eng.allerte.exception.NoSuchRubricaSitoException;
import it.eng.allerte.model.RubricaSito;
import it.eng.allerte.service.RubricaSitoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaSitoPersistence;
import it.eng.allerte.service.persistence.RubricaSitoUtil;

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
public class RubricaSitoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaSitoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaSito> iterator = _rubricaSitos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaSito rubricaSito = _persistence.create(pk);

		Assert.assertNotNull(rubricaSito);

		Assert.assertEquals(rubricaSito.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaSito newRubricaSito = addRubricaSito();

		_persistence.remove(newRubricaSito);

		RubricaSito existingRubricaSito = _persistence.fetchByPrimaryKey(
			newRubricaSito.getPrimaryKey());

		Assert.assertNull(existingRubricaSito);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaSito();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaSito newRubricaSito = _persistence.create(pk);

		newRubricaSito.setNOME(RandomTestUtil.randomString());

		newRubricaSito.setFK_LIFERAY_SITE(RandomTestUtil.nextLong());

		_rubricaSitos.add(_persistence.update(newRubricaSito));

		RubricaSito existingRubricaSito = _persistence.findByPrimaryKey(
			newRubricaSito.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaSito.getID_SITO(), newRubricaSito.getID_SITO());
		Assert.assertEquals(
			existingRubricaSito.getNOME(), newRubricaSito.getNOME());
		Assert.assertEquals(
			existingRubricaSito.getFK_LIFERAY_SITE(),
			newRubricaSito.getFK_LIFERAY_SITE());
	}

	@Test
	public void testCountByLiferaySite() throws Exception {
		_persistence.countByLiferaySite(RandomTestUtil.nextLong());

		_persistence.countByLiferaySite(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaSito newRubricaSito = addRubricaSito();

		RubricaSito existingRubricaSito = _persistence.findByPrimaryKey(
			newRubricaSito.getPrimaryKey());

		Assert.assertEquals(existingRubricaSito, newRubricaSito);
	}

	@Test(expected = NoSuchRubricaSitoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaSito> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaSito", "ID_SITO", true, "NOME", true,
			"FK_LIFERAY_SITE", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaSito newRubricaSito = addRubricaSito();

		RubricaSito existingRubricaSito = _persistence.fetchByPrimaryKey(
			newRubricaSito.getPrimaryKey());

		Assert.assertEquals(existingRubricaSito, newRubricaSito);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaSito missingRubricaSito = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaSito);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaSito newRubricaSito1 = addRubricaSito();
		RubricaSito newRubricaSito2 = addRubricaSito();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaSito1.getPrimaryKey());
		primaryKeys.add(newRubricaSito2.getPrimaryKey());

		Map<Serializable, RubricaSito> rubricaSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaSitos.size());
		Assert.assertEquals(
			newRubricaSito1, rubricaSitos.get(newRubricaSito1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaSito2, rubricaSitos.get(newRubricaSito2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaSito> rubricaSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaSitos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaSito newRubricaSito = addRubricaSito();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaSito.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaSito> rubricaSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaSitos.size());
		Assert.assertEquals(
			newRubricaSito, rubricaSitos.get(newRubricaSito.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaSito> rubricaSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaSitos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaSito newRubricaSito = addRubricaSito();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaSito.getPrimaryKey());

		Map<Serializable, RubricaSito> rubricaSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaSitos.size());
		Assert.assertEquals(
			newRubricaSito, rubricaSitos.get(newRubricaSito.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaSitoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaSito>() {

				@Override
				public void performAction(RubricaSito rubricaSito) {
					Assert.assertNotNull(rubricaSito);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaSito newRubricaSito = addRubricaSito();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaSito.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_SITO", newRubricaSito.getID_SITO()));

		List<RubricaSito> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaSito existingRubricaSito = result.get(0);

		Assert.assertEquals(existingRubricaSito, newRubricaSito);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaSito.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_SITO", RandomTestUtil.nextLong()));

		List<RubricaSito> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaSito newRubricaSito = addRubricaSito();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaSito.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_SITO"));

		Object newID_SITO = newRubricaSito.getID_SITO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ID_SITO", new Object[] {newID_SITO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_SITO = result.get(0);

		Assert.assertEquals(existingID_SITO, newID_SITO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaSito.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_SITO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_SITO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaSito addRubricaSito() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaSito rubricaSito = _persistence.create(pk);

		rubricaSito.setNOME(RandomTestUtil.randomString());

		rubricaSito.setFK_LIFERAY_SITE(RandomTestUtil.nextLong());

		_rubricaSitos.add(_persistence.update(rubricaSito));

		return rubricaSito;
	}

	private List<RubricaSito> _rubricaSitos = new ArrayList<RubricaSito>();
	private RubricaSitoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}