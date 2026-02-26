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
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException;
import it.eng.allerte.model.RubricaRuoloPermessi;
import it.eng.allerte.service.RubricaRuoloPermessiLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPK;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiPersistence;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiUtil;

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
public class RubricaRuoloPermessiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaRuoloPermessiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaRuoloPermessi> iterator =
			_rubricaRuoloPermessis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		RubricaRuoloPermessiPK pk = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		RubricaRuoloPermessi rubricaRuoloPermessi = _persistence.create(pk);

		Assert.assertNotNull(rubricaRuoloPermessi);

		Assert.assertEquals(rubricaRuoloPermessi.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		_persistence.remove(newRubricaRuoloPermessi);

		RubricaRuoloPermessi existingRubricaRuoloPermessi =
			_persistence.fetchByPrimaryKey(
				newRubricaRuoloPermessi.getPrimaryKey());

		Assert.assertNull(existingRubricaRuoloPermessi);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaRuoloPermessi();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		RubricaRuoloPermessiPK pk = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		RubricaRuoloPermessi newRubricaRuoloPermessi = _persistence.create(pk);

		_rubricaRuoloPermessis.add(
			_persistence.update(newRubricaRuoloPermessi));

		RubricaRuoloPermessi existingRubricaRuoloPermessi =
			_persistence.findByPrimaryKey(
				newRubricaRuoloPermessi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuoloPermessi.getFK_ID_RUOLO(),
			newRubricaRuoloPermessi.getFK_ID_RUOLO());
		Assert.assertEquals(
			existingRubricaRuoloPermessi.getFK_ID_PERMESSO(),
			newRubricaRuoloPermessi.getFK_ID_PERMESSO());
	}

	@Test
	public void testCountByRubricaPermessiByRuolo() throws Exception {
		_persistence.countByRubricaPermessiByRuolo(RandomTestUtil.nextLong());

		_persistence.countByRubricaPermessiByRuolo(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		RubricaRuoloPermessi existingRubricaRuoloPermessi =
			_persistence.findByPrimaryKey(
				newRubricaRuoloPermessi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuoloPermessi, newRubricaRuoloPermessi);
	}

	@Test(expected = NoSuchRubricaRuoloPermessiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		RubricaRuoloPermessiPK pk = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		RubricaRuoloPermessi existingRubricaRuoloPermessi =
			_persistence.fetchByPrimaryKey(
				newRubricaRuoloPermessi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaRuoloPermessi, newRubricaRuoloPermessi);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		RubricaRuoloPermessiPK pk = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		RubricaRuoloPermessi missingRubricaRuoloPermessi =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaRuoloPermessi);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaRuoloPermessi newRubricaRuoloPermessi1 =
			addRubricaRuoloPermessi();
		RubricaRuoloPermessi newRubricaRuoloPermessi2 =
			addRubricaRuoloPermessi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuoloPermessi1.getPrimaryKey());
		primaryKeys.add(newRubricaRuoloPermessi2.getPrimaryKey());

		Map<Serializable, RubricaRuoloPermessi> rubricaRuoloPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaRuoloPermessis.size());
		Assert.assertEquals(
			newRubricaRuoloPermessi1,
			rubricaRuoloPermessis.get(
				newRubricaRuoloPermessi1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaRuoloPermessi2,
			rubricaRuoloPermessis.get(
				newRubricaRuoloPermessi2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		RubricaRuoloPermessiPK pk1 = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		RubricaRuoloPermessiPK pk2 = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaRuoloPermessi> rubricaRuoloPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaRuoloPermessis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		RubricaRuoloPermessiPK pk = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuoloPermessi.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaRuoloPermessi> rubricaRuoloPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaRuoloPermessis.size());
		Assert.assertEquals(
			newRubricaRuoloPermessi,
			rubricaRuoloPermessis.get(newRubricaRuoloPermessi.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaRuoloPermessi> rubricaRuoloPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaRuoloPermessis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaRuoloPermessi.getPrimaryKey());

		Map<Serializable, RubricaRuoloPermessi> rubricaRuoloPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaRuoloPermessis.size());
		Assert.assertEquals(
			newRubricaRuoloPermessi,
			rubricaRuoloPermessis.get(newRubricaRuoloPermessi.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaRuoloPermessiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RubricaRuoloPermessi>() {

				@Override
				public void performAction(
					RubricaRuoloPermessi rubricaRuoloPermessi) {

					Assert.assertNotNull(rubricaRuoloPermessi);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_ID_RUOLO", newRubricaRuoloPermessi.getFK_ID_RUOLO()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_ID_PERMESSO",
				newRubricaRuoloPermessi.getFK_ID_PERMESSO()));

		List<RubricaRuoloPermessi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaRuoloPermessi existingRubricaRuoloPermessi = result.get(0);

		Assert.assertEquals(
			existingRubricaRuoloPermessi, newRubricaRuoloPermessi);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_ID_RUOLO", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_ID_PERMESSO", RandomTestUtil.randomString()));

		List<RubricaRuoloPermessi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaRuoloPermessi newRubricaRuoloPermessi =
			addRubricaRuoloPermessi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.FK_ID_RUOLO"));

		Object newFK_ID_RUOLO = newRubricaRuoloPermessi.getFK_ID_RUOLO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.FK_ID_RUOLO", new Object[] {newFK_ID_RUOLO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFK_ID_RUOLO = result.get(0);

		Assert.assertEquals(existingFK_ID_RUOLO, newFK_ID_RUOLO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaRuoloPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.FK_ID_RUOLO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.FK_ID_RUOLO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaRuoloPermessi addRubricaRuoloPermessi() throws Exception {
		RubricaRuoloPermessiPK pk = new RubricaRuoloPermessiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.randomString());

		RubricaRuoloPermessi rubricaRuoloPermessi = _persistence.create(pk);

		_rubricaRuoloPermessis.add(_persistence.update(rubricaRuoloPermessi));

		return rubricaRuoloPermessi;
	}

	private List<RubricaRuoloPermessi> _rubricaRuoloPermessis =
		new ArrayList<RubricaRuoloPermessi>();
	private RubricaRuoloPermessiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}