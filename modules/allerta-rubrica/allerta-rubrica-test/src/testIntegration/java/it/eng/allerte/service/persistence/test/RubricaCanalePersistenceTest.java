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

import it.eng.allerte.exception.NoSuchRubricaCanaleException;
import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.service.RubricaCanaleLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaCanalePersistence;
import it.eng.allerte.service.persistence.RubricaCanaleUtil;

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
public class RubricaCanalePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaCanaleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaCanale> iterator = _rubricaCanales.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCanale rubricaCanale = _persistence.create(pk);

		Assert.assertNotNull(rubricaCanale);

		Assert.assertEquals(rubricaCanale.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaCanale newRubricaCanale = addRubricaCanale();

		_persistence.remove(newRubricaCanale);

		RubricaCanale existingRubricaCanale = _persistence.fetchByPrimaryKey(
			newRubricaCanale.getPrimaryKey());

		Assert.assertNull(existingRubricaCanale);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaCanale();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCanale newRubricaCanale = _persistence.create(pk);

		newRubricaCanale.setNOME(RandomTestUtil.randomString());

		newRubricaCanale.setICONA(RandomTestUtil.randomString());

		newRubricaCanale.setREGEX(RandomTestUtil.randomString());

		_rubricaCanales.add(_persistence.update(newRubricaCanale));

		RubricaCanale existingRubricaCanale = _persistence.findByPrimaryKey(
			newRubricaCanale.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaCanale.getID_CANALE(),
			newRubricaCanale.getID_CANALE());
		Assert.assertEquals(
			existingRubricaCanale.getNOME(), newRubricaCanale.getNOME());
		Assert.assertEquals(
			existingRubricaCanale.getICONA(), newRubricaCanale.getICONA());
		Assert.assertEquals(
			existingRubricaCanale.getREGEX(), newRubricaCanale.getREGEX());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaCanale newRubricaCanale = addRubricaCanale();

		RubricaCanale existingRubricaCanale = _persistence.findByPrimaryKey(
			newRubricaCanale.getPrimaryKey());

		Assert.assertEquals(existingRubricaCanale, newRubricaCanale);
	}

	@Test(expected = NoSuchRubricaCanaleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaCanale> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaCanale", "ID_CANALE", true, "NOME", true, "ICONA",
			true, "REGEX", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaCanale newRubricaCanale = addRubricaCanale();

		RubricaCanale existingRubricaCanale = _persistence.fetchByPrimaryKey(
			newRubricaCanale.getPrimaryKey());

		Assert.assertEquals(existingRubricaCanale, newRubricaCanale);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCanale missingRubricaCanale = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaCanale);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaCanale newRubricaCanale1 = addRubricaCanale();
		RubricaCanale newRubricaCanale2 = addRubricaCanale();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaCanale1.getPrimaryKey());
		primaryKeys.add(newRubricaCanale2.getPrimaryKey());

		Map<Serializable, RubricaCanale> rubricaCanales =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaCanales.size());
		Assert.assertEquals(
			newRubricaCanale1,
			rubricaCanales.get(newRubricaCanale1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaCanale2,
			rubricaCanales.get(newRubricaCanale2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaCanale> rubricaCanales =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaCanales.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaCanale newRubricaCanale = addRubricaCanale();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaCanale.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaCanale> rubricaCanales =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaCanales.size());
		Assert.assertEquals(
			newRubricaCanale,
			rubricaCanales.get(newRubricaCanale.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaCanale> rubricaCanales =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaCanales.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaCanale newRubricaCanale = addRubricaCanale();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaCanale.getPrimaryKey());

		Map<Serializable, RubricaCanale> rubricaCanales =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaCanales.size());
		Assert.assertEquals(
			newRubricaCanale,
			rubricaCanales.get(newRubricaCanale.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaCanaleLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaCanale>() {

				@Override
				public void performAction(RubricaCanale rubricaCanale) {
					Assert.assertNotNull(rubricaCanale);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaCanale newRubricaCanale = addRubricaCanale();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCanale.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_CANALE", newRubricaCanale.getID_CANALE()));

		List<RubricaCanale> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaCanale existingRubricaCanale = result.get(0);

		Assert.assertEquals(existingRubricaCanale, newRubricaCanale);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCanale.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_CANALE", RandomTestUtil.nextLong()));

		List<RubricaCanale> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaCanale newRubricaCanale = addRubricaCanale();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCanale.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_CANALE"));

		Object newID_CANALE = newRubricaCanale.getID_CANALE();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_CANALE", new Object[] {newID_CANALE}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_CANALE = result.get(0);

		Assert.assertEquals(existingID_CANALE, newID_CANALE);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaCanale.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_CANALE"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_CANALE", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaCanale addRubricaCanale() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaCanale rubricaCanale = _persistence.create(pk);

		rubricaCanale.setNOME(RandomTestUtil.randomString());

		rubricaCanale.setICONA(RandomTestUtil.randomString());

		rubricaCanale.setREGEX(RandomTestUtil.randomString());

		_rubricaCanales.add(_persistence.update(rubricaCanale));

		return rubricaCanale;
	}

	private List<RubricaCanale> _rubricaCanales =
		new ArrayList<RubricaCanale>();
	private RubricaCanalePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}