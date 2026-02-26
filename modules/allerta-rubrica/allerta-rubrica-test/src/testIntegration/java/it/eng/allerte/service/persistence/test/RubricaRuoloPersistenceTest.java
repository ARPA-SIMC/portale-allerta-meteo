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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.allerte.exception.NoSuchRubricaRuoloException;
import it.eng.allerte.model.RubricaRuolo;
import it.eng.allerte.service.RubricaRuoloLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaRuoloPersistence;
import it.eng.allerte.service.persistence.RubricaRuoloUtil;

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
public class RubricaRuoloPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaRuoloUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaRuolo> iterator = _rubricaRuolos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuolo rubricaRuolo = _persistence.create(pk);

		Assert.assertNotNull(rubricaRuolo);

		Assert.assertEquals(rubricaRuolo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		_persistence.remove(newRubricaRuolo);

		RubricaRuolo existingRubricaRuolo = _persistence.fetchByPrimaryKey(
			newRubricaRuolo.getPrimaryKey());

		Assert.assertNull(existingRubricaRuolo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaRuolo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuolo newRubricaRuolo = _persistence.create(pk);

		newRubricaRuolo.setDESCRIZIONE(RandomTestUtil.randomString());

		newRubricaRuolo.setFK_RUOLO_LIFERAY(RandomTestUtil.nextLong());

		_rubricaRuolos.add(_persistence.update(newRubricaRuolo));

		RubricaRuolo existingRubricaRuolo = _persistence.findByPrimaryKey(
			newRubricaRuolo.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuolo.getID_RUOLO(), newRubricaRuolo.getID_RUOLO());
		Assert.assertEquals(
			existingRubricaRuolo.getDESCRIZIONE(),
			newRubricaRuolo.getDESCRIZIONE());
		Assert.assertEquals(
			existingRubricaRuolo.getFK_RUOLO_LIFERAY(),
			newRubricaRuolo.getFK_RUOLO_LIFERAY());
	}

	@Test
	public void testCountByRubricaRuoloByRuoloLiferay() throws Exception {
		_persistence.countByRubricaRuoloByRuoloLiferay(
			RandomTestUtil.nextLong());

		_persistence.countByRubricaRuoloByRuoloLiferay(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		RubricaRuolo existingRubricaRuolo = _persistence.findByPrimaryKey(
			newRubricaRuolo.getPrimaryKey());

		Assert.assertEquals(existingRubricaRuolo, newRubricaRuolo);
	}

	@Test(expected = NoSuchRubricaRuoloException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaRuolo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaRuolo", "ID_RUOLO", true, "DESCRIZIONE", true,
			"FK_RUOLO_LIFERAY", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		RubricaRuolo existingRubricaRuolo = _persistence.fetchByPrimaryKey(
			newRubricaRuolo.getPrimaryKey());

		Assert.assertEquals(existingRubricaRuolo, newRubricaRuolo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuolo missingRubricaRuolo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaRuolo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaRuolo newRubricaRuolo1 = addRubricaRuolo();
		RubricaRuolo newRubricaRuolo2 = addRubricaRuolo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuolo1.getPrimaryKey());
		primaryKeys.add(newRubricaRuolo2.getPrimaryKey());

		Map<Serializable, RubricaRuolo> rubricaRuolos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaRuolos.size());
		Assert.assertEquals(
			newRubricaRuolo1,
			rubricaRuolos.get(newRubricaRuolo1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaRuolo2,
			rubricaRuolos.get(newRubricaRuolo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaRuolo> rubricaRuolos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaRuolos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuolo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaRuolo> rubricaRuolos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaRuolos.size());
		Assert.assertEquals(
			newRubricaRuolo,
			rubricaRuolos.get(newRubricaRuolo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaRuolo> rubricaRuolos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaRuolos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuolo.getPrimaryKey());

		Map<Serializable, RubricaRuolo> rubricaRuolos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaRuolos.size());
		Assert.assertEquals(
			newRubricaRuolo,
			rubricaRuolos.get(newRubricaRuolo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaRuoloLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaRuolo>() {

				@Override
				public void performAction(RubricaRuolo rubricaRuolo) {
					Assert.assertNotNull(rubricaRuolo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuolo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_RUOLO", newRubricaRuolo.getID_RUOLO()));

		List<RubricaRuolo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaRuolo existingRubricaRuolo = result.get(0);

		Assert.assertEquals(existingRubricaRuolo, newRubricaRuolo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuolo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_RUOLO", RandomTestUtil.nextLong()));

		List<RubricaRuolo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuolo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_RUOLO"));

		Object newID_RUOLO = newRubricaRuolo.getID_RUOLO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ID_RUOLO", new Object[] {newID_RUOLO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_RUOLO = result.get(0);

		Assert.assertEquals(existingID_RUOLO, newID_RUOLO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuolo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_RUOLO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_RUOLO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newRubricaRuolo.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		RubricaRuolo newRubricaRuolo = addRubricaRuolo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuolo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_RUOLO", newRubricaRuolo.getID_RUOLO()));

		List<RubricaRuolo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(RubricaRuolo rubricaRuolo) {
		Assert.assertEquals(
			Long.valueOf(rubricaRuolo.getFK_RUOLO_LIFERAY()),
			ReflectionTestUtil.<Long>invoke(
				rubricaRuolo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "FK_RUOLO_LIFERAY"));
	}

	protected RubricaRuolo addRubricaRuolo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuolo rubricaRuolo = _persistence.create(pk);

		rubricaRuolo.setDESCRIZIONE(RandomTestUtil.randomString());

		rubricaRuolo.setFK_RUOLO_LIFERAY(RandomTestUtil.nextLong());

		_rubricaRuolos.add(_persistence.update(rubricaRuolo));

		return rubricaRuolo;
	}

	private List<RubricaRuolo> _rubricaRuolos = new ArrayList<RubricaRuolo>();
	private RubricaRuoloPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}