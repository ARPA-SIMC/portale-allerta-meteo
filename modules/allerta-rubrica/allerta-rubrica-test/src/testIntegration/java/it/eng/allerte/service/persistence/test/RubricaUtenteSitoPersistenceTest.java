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

import it.eng.allerte.exception.NoSuchRubricaUtenteSitoException;
import it.eng.allerte.model.RubricaUtenteSito;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaUtenteSitoPersistence;
import it.eng.allerte.service.persistence.RubricaUtenteSitoUtil;

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
public class RubricaUtenteSitoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaUtenteSitoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaUtenteSito> iterator = _rubricaUtenteSitos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaUtenteSito rubricaUtenteSito = _persistence.create(pk);

		Assert.assertNotNull(rubricaUtenteSito);

		Assert.assertEquals(rubricaUtenteSito.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		_persistence.remove(newRubricaUtenteSito);

		RubricaUtenteSito existingRubricaUtenteSito =
			_persistence.fetchByPrimaryKey(
				newRubricaUtenteSito.getPrimaryKey());

		Assert.assertNull(existingRubricaUtenteSito);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaUtenteSito();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaUtenteSito newRubricaUtenteSito = _persistence.create(pk);

		newRubricaUtenteSito.setID_SITO(RandomTestUtil.nextLong());

		_rubricaUtenteSitos.add(_persistence.update(newRubricaUtenteSito));

		RubricaUtenteSito existingRubricaUtenteSito =
			_persistence.findByPrimaryKey(newRubricaUtenteSito.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaUtenteSito.getID_UTENTE(),
			newRubricaUtenteSito.getID_UTENTE());
		Assert.assertEquals(
			existingRubricaUtenteSito.getID_SITO(),
			newRubricaUtenteSito.getID_SITO());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		RubricaUtenteSito existingRubricaUtenteSito =
			_persistence.findByPrimaryKey(newRubricaUtenteSito.getPrimaryKey());

		Assert.assertEquals(existingRubricaUtenteSito, newRubricaUtenteSito);
	}

	@Test(expected = NoSuchRubricaUtenteSitoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaUtenteSito> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaUtenteSito", "ID_UTENTE", true, "ID_SITO", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		RubricaUtenteSito existingRubricaUtenteSito =
			_persistence.fetchByPrimaryKey(
				newRubricaUtenteSito.getPrimaryKey());

		Assert.assertEquals(existingRubricaUtenteSito, newRubricaUtenteSito);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaUtenteSito missingRubricaUtenteSito =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaUtenteSito);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaUtenteSito newRubricaUtenteSito1 = addRubricaUtenteSito();
		RubricaUtenteSito newRubricaUtenteSito2 = addRubricaUtenteSito();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaUtenteSito1.getPrimaryKey());
		primaryKeys.add(newRubricaUtenteSito2.getPrimaryKey());

		Map<Serializable, RubricaUtenteSito> rubricaUtenteSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaUtenteSitos.size());
		Assert.assertEquals(
			newRubricaUtenteSito1,
			rubricaUtenteSitos.get(newRubricaUtenteSito1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaUtenteSito2,
			rubricaUtenteSitos.get(newRubricaUtenteSito2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaUtenteSito> rubricaUtenteSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaUtenteSitos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaUtenteSito.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaUtenteSito> rubricaUtenteSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaUtenteSitos.size());
		Assert.assertEquals(
			newRubricaUtenteSito,
			rubricaUtenteSitos.get(newRubricaUtenteSito.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaUtenteSito> rubricaUtenteSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaUtenteSitos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaUtenteSito.getPrimaryKey());

		Map<Serializable, RubricaUtenteSito> rubricaUtenteSitos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaUtenteSitos.size());
		Assert.assertEquals(
			newRubricaUtenteSito,
			rubricaUtenteSitos.get(newRubricaUtenteSito.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaUtenteSitoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RubricaUtenteSito>() {

				@Override
				public void performAction(RubricaUtenteSito rubricaUtenteSito) {
					Assert.assertNotNull(rubricaUtenteSito);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaUtenteSito.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_UTENTE", newRubricaUtenteSito.getID_UTENTE()));

		List<RubricaUtenteSito> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaUtenteSito existingRubricaUtenteSito = result.get(0);

		Assert.assertEquals(existingRubricaUtenteSito, newRubricaUtenteSito);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaUtenteSito.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_UTENTE", RandomTestUtil.nextLong()));

		List<RubricaUtenteSito> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaUtenteSito newRubricaUtenteSito = addRubricaUtenteSito();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaUtenteSito.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_UTENTE"));

		Object newID_UTENTE = newRubricaUtenteSito.getID_UTENTE();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_UTENTE", new Object[] {newID_UTENTE}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_UTENTE = result.get(0);

		Assert.assertEquals(existingID_UTENTE, newID_UTENTE);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaUtenteSito.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_UTENTE"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_UTENTE", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaUtenteSito addRubricaUtenteSito() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaUtenteSito rubricaUtenteSito = _persistence.create(pk);

		rubricaUtenteSito.setID_SITO(RandomTestUtil.nextLong());

		_rubricaUtenteSitos.add(_persistence.update(rubricaUtenteSito));

		return rubricaUtenteSito;
	}

	private List<RubricaUtenteSito> _rubricaUtenteSitos =
		new ArrayList<RubricaUtenteSito>();
	private RubricaUtenteSitoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}