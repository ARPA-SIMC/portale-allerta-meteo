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

import it.eng.allerte.exception.NoSuchRubricaCategoriaException;
import it.eng.allerte.model.RubricaCategoria;
import it.eng.allerte.service.RubricaCategoriaLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaCategoriaPersistence;
import it.eng.allerte.service.persistence.RubricaCategoriaUtil;

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
public class RubricaCategoriaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaCategoriaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaCategoria> iterator = _rubricaCategorias.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCategoria rubricaCategoria = _persistence.create(pk);

		Assert.assertNotNull(rubricaCategoria);

		Assert.assertEquals(rubricaCategoria.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		_persistence.remove(newRubricaCategoria);

		RubricaCategoria existingRubricaCategoria =
			_persistence.fetchByPrimaryKey(newRubricaCategoria.getPrimaryKey());

		Assert.assertNull(existingRubricaCategoria);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaCategoria();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCategoria newRubricaCategoria = _persistence.create(pk);

		newRubricaCategoria.setDESCRIZIONE(RandomTestUtil.randomString());

		_rubricaCategorias.add(_persistence.update(newRubricaCategoria));

		RubricaCategoria existingRubricaCategoria =
			_persistence.findByPrimaryKey(newRubricaCategoria.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaCategoria.getID_CATEGORIA(),
			newRubricaCategoria.getID_CATEGORIA());
		Assert.assertEquals(
			existingRubricaCategoria.getDESCRIZIONE(),
			newRubricaCategoria.getDESCRIZIONE());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		RubricaCategoria existingRubricaCategoria =
			_persistence.findByPrimaryKey(newRubricaCategoria.getPrimaryKey());

		Assert.assertEquals(existingRubricaCategoria, newRubricaCategoria);
	}

	@Test(expected = NoSuchRubricaCategoriaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaCategoria> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaCategoria", "ID_CATEGORIA", true, "DESCRIZIONE",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		RubricaCategoria existingRubricaCategoria =
			_persistence.fetchByPrimaryKey(newRubricaCategoria.getPrimaryKey());

		Assert.assertEquals(existingRubricaCategoria, newRubricaCategoria);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCategoria missingRubricaCategoria =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaCategoria);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaCategoria newRubricaCategoria1 = addRubricaCategoria();
		RubricaCategoria newRubricaCategoria2 = addRubricaCategoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaCategoria1.getPrimaryKey());
		primaryKeys.add(newRubricaCategoria2.getPrimaryKey());

		Map<Serializable, RubricaCategoria> rubricaCategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaCategorias.size());
		Assert.assertEquals(
			newRubricaCategoria1,
			rubricaCategorias.get(newRubricaCategoria1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaCategoria2,
			rubricaCategorias.get(newRubricaCategoria2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaCategoria> rubricaCategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaCategorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaCategoria.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaCategoria> rubricaCategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaCategorias.size());
		Assert.assertEquals(
			newRubricaCategoria,
			rubricaCategorias.get(newRubricaCategoria.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaCategoria> rubricaCategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaCategorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaCategoria.getPrimaryKey());

		Map<Serializable, RubricaCategoria> rubricaCategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaCategorias.size());
		Assert.assertEquals(
			newRubricaCategoria,
			rubricaCategorias.get(newRubricaCategoria.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaCategoriaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaCategoria>() {

				@Override
				public void performAction(RubricaCategoria rubricaCategoria) {
					Assert.assertNotNull(rubricaCategoria);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_CATEGORIA", newRubricaCategoria.getID_CATEGORIA()));

		List<RubricaCategoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaCategoria existingRubricaCategoria = result.get(0);

		Assert.assertEquals(existingRubricaCategoria, newRubricaCategoria);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_CATEGORIA", RandomTestUtil.nextLong()));

		List<RubricaCategoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaCategoria newRubricaCategoria = addRubricaCategoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_CATEGORIA"));

		Object newID_CATEGORIA = newRubricaCategoria.getID_CATEGORIA();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_CATEGORIA", new Object[] {newID_CATEGORIA}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_CATEGORIA = result.get(0);

		Assert.assertEquals(existingID_CATEGORIA, newID_CATEGORIA);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_CATEGORIA"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_CATEGORIA", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaCategoria addRubricaCategoria() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCategoria rubricaCategoria = _persistence.create(pk);

		rubricaCategoria.setDESCRIZIONE(RandomTestUtil.randomString());

		_rubricaCategorias.add(_persistence.update(rubricaCategoria));

		return rubricaCategoria;
	}

	private List<RubricaCategoria> _rubricaCategorias =
		new ArrayList<RubricaCategoria>();
	private RubricaCategoriaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}