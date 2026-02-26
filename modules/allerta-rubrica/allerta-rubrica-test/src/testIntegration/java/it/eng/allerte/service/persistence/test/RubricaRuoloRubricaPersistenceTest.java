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

import it.eng.allerte.exception.NoSuchRubricaRuoloRubricaException;
import it.eng.allerte.model.RubricaRuoloRubrica;
import it.eng.allerte.service.RubricaRuoloRubricaLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaRuoloRubricaPersistence;
import it.eng.allerte.service.persistence.RubricaRuoloRubricaUtil;

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
public class RubricaRuoloRubricaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaRuoloRubricaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaRuoloRubrica> iterator =
			_rubricaRuoloRubricas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuoloRubrica rubricaRuoloRubrica = _persistence.create(pk);

		Assert.assertNotNull(rubricaRuoloRubrica);

		Assert.assertEquals(rubricaRuoloRubrica.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		_persistence.remove(newRubricaRuoloRubrica);

		RubricaRuoloRubrica existingRubricaRuoloRubrica =
			_persistence.fetchByPrimaryKey(
				newRubricaRuoloRubrica.getPrimaryKey());

		Assert.assertNull(existingRubricaRuoloRubrica);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaRuoloRubrica();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuoloRubrica newRubricaRuoloRubrica = _persistence.create(pk);

		newRubricaRuoloRubrica.setDESCRIZIONE(RandomTestUtil.randomString());

		_rubricaRuoloRubricas.add(_persistence.update(newRubricaRuoloRubrica));

		RubricaRuoloRubrica existingRubricaRuoloRubrica =
			_persistence.findByPrimaryKey(
				newRubricaRuoloRubrica.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuoloRubrica.getID_RUOLO(),
			newRubricaRuoloRubrica.getID_RUOLO());
		Assert.assertEquals(
			existingRubricaRuoloRubrica.getDESCRIZIONE(),
			newRubricaRuoloRubrica.getDESCRIZIONE());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		RubricaRuoloRubrica existingRubricaRuoloRubrica =
			_persistence.findByPrimaryKey(
				newRubricaRuoloRubrica.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuoloRubrica, newRubricaRuoloRubrica);
	}

	@Test(expected = NoSuchRubricaRuoloRubricaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaRuoloRubrica> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaRuoloRubrica", "ID_RUOLO", true, "DESCRIZIONE",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		RubricaRuoloRubrica existingRubricaRuoloRubrica =
			_persistence.fetchByPrimaryKey(
				newRubricaRuoloRubrica.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuoloRubrica, newRubricaRuoloRubrica);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuoloRubrica missingRubricaRuoloRubrica =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaRuoloRubrica);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaRuoloRubrica newRubricaRuoloRubrica1 = addRubricaRuoloRubrica();
		RubricaRuoloRubrica newRubricaRuoloRubrica2 = addRubricaRuoloRubrica();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuoloRubrica1.getPrimaryKey());
		primaryKeys.add(newRubricaRuoloRubrica2.getPrimaryKey());

		Map<Serializable, RubricaRuoloRubrica> rubricaRuoloRubricas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaRuoloRubricas.size());
		Assert.assertEquals(
			newRubricaRuoloRubrica1,
			rubricaRuoloRubricas.get(newRubricaRuoloRubrica1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaRuoloRubrica2,
			rubricaRuoloRubricas.get(newRubricaRuoloRubrica2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaRuoloRubrica> rubricaRuoloRubricas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaRuoloRubricas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuoloRubrica.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaRuoloRubrica> rubricaRuoloRubricas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaRuoloRubricas.size());
		Assert.assertEquals(
			newRubricaRuoloRubrica,
			rubricaRuoloRubricas.get(newRubricaRuoloRubrica.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaRuoloRubrica> rubricaRuoloRubricas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaRuoloRubricas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuoloRubrica.getPrimaryKey());

		Map<Serializable, RubricaRuoloRubrica> rubricaRuoloRubricas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaRuoloRubricas.size());
		Assert.assertEquals(
			newRubricaRuoloRubrica,
			rubricaRuoloRubricas.get(newRubricaRuoloRubrica.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaRuoloRubricaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RubricaRuoloRubrica>() {

				@Override
				public void performAction(
					RubricaRuoloRubrica rubricaRuoloRubrica) {

					Assert.assertNotNull(rubricaRuoloRubrica);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloRubrica.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_RUOLO", newRubricaRuoloRubrica.getID_RUOLO()));

		List<RubricaRuoloRubrica> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaRuoloRubrica existingRubricaRuoloRubrica = result.get(0);

		Assert.assertEquals(
			existingRubricaRuoloRubrica, newRubricaRuoloRubrica);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloRubrica.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_RUOLO", RandomTestUtil.nextLong()));

		List<RubricaRuoloRubrica> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaRuoloRubrica newRubricaRuoloRubrica = addRubricaRuoloRubrica();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloRubrica.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_RUOLO"));

		Object newID_RUOLO = newRubricaRuoloRubrica.getID_RUOLO();

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
			RubricaRuoloRubrica.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_RUOLO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_RUOLO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaRuoloRubrica addRubricaRuoloRubrica() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaRuoloRubrica rubricaRuoloRubrica = _persistence.create(pk);

		rubricaRuoloRubrica.setDESCRIZIONE(RandomTestUtil.randomString());

		_rubricaRuoloRubricas.add(_persistence.update(rubricaRuoloRubrica));

		return rubricaRuoloRubrica;
	}

	private List<RubricaRuoloRubrica> _rubricaRuoloRubricas =
		new ArrayList<RubricaRuoloRubrica>();
	private RubricaRuoloRubricaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}