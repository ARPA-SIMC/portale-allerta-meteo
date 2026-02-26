/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.test;

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

import it.eng.allerte.exception.NoSuchRubricaPermessiException;
import it.eng.allerte.model.RubricaPermessi;
import it.eng.allerte.service.persistence.RubricaPermessiPersistence;
import it.eng.allerte.service.persistence.RubricaPermessiUtil;

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
public class RubricaPermessiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaPermessiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaPermessi> iterator = _rubricaPermessis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		RubricaPermessi rubricaPermessi = _persistence.create(pk);

		Assert.assertNotNull(rubricaPermessi);

		Assert.assertEquals(rubricaPermessi.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		_persistence.remove(newRubricaPermessi);

		RubricaPermessi existingRubricaPermessi =
			_persistence.fetchByPrimaryKey(newRubricaPermessi.getPrimaryKey());

		Assert.assertNull(existingRubricaPermessi);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaPermessi();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		RubricaPermessi newRubricaPermessi = _persistence.create(pk);

		newRubricaPermessi.setNOME_PERMESSO(RandomTestUtil.randomString());

		_rubricaPermessis.add(_persistence.update(newRubricaPermessi));

		RubricaPermessi existingRubricaPermessi = _persistence.findByPrimaryKey(
			newRubricaPermessi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaPermessi.getID_PERMESSO(),
			newRubricaPermessi.getID_PERMESSO());
		Assert.assertEquals(
			existingRubricaPermessi.getNOME_PERMESSO(),
			newRubricaPermessi.getNOME_PERMESSO());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		RubricaPermessi existingRubricaPermessi = _persistence.findByPrimaryKey(
			newRubricaPermessi.getPrimaryKey());

		Assert.assertEquals(existingRubricaPermessi, newRubricaPermessi);
	}

	@Test(expected = NoSuchRubricaPermessiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaPermessi> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaPermessi", "ID_PERMESSO", true, "NOME_PERMESSO",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		RubricaPermessi existingRubricaPermessi =
			_persistence.fetchByPrimaryKey(newRubricaPermessi.getPrimaryKey());

		Assert.assertEquals(existingRubricaPermessi, newRubricaPermessi);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		RubricaPermessi missingRubricaPermessi = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingRubricaPermessi);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaPermessi newRubricaPermessi1 = addRubricaPermessi();
		RubricaPermessi newRubricaPermessi2 = addRubricaPermessi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaPermessi1.getPrimaryKey());
		primaryKeys.add(newRubricaPermessi2.getPrimaryKey());

		Map<Serializable, RubricaPermessi> rubricaPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaPermessis.size());
		Assert.assertEquals(
			newRubricaPermessi1,
			rubricaPermessis.get(newRubricaPermessi1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaPermessi2,
			rubricaPermessis.get(newRubricaPermessi2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaPermessi> rubricaPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaPermessis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaPermessi.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaPermessi> rubricaPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaPermessis.size());
		Assert.assertEquals(
			newRubricaPermessi,
			rubricaPermessis.get(newRubricaPermessi.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaPermessi> rubricaPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaPermessis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaPermessi.getPrimaryKey());

		Map<Serializable, RubricaPermessi> rubricaPermessis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaPermessis.size());
		Assert.assertEquals(
			newRubricaPermessi,
			rubricaPermessis.get(newRubricaPermessi.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_PERMESSO", newRubricaPermessi.getID_PERMESSO()));

		List<RubricaPermessi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaPermessi existingRubricaPermessi = result.get(0);

		Assert.assertEquals(existingRubricaPermessi, newRubricaPermessi);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_PERMESSO", RandomTestUtil.randomString()));

		List<RubricaPermessi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaPermessi newRubricaPermessi = addRubricaPermessi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_PERMESSO"));

		Object newID_PERMESSO = newRubricaPermessi.getID_PERMESSO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_PERMESSO", new Object[] {newID_PERMESSO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_PERMESSO = result.get(0);

		Assert.assertEquals(existingID_PERMESSO, newID_PERMESSO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaPermessi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_PERMESSO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_PERMESSO", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaPermessi addRubricaPermessi() throws Exception {
		String pk = RandomTestUtil.randomString();

		RubricaPermessi rubricaPermessi = _persistence.create(pk);

		rubricaPermessi.setNOME_PERMESSO(RandomTestUtil.randomString());

		_rubricaPermessis.add(_persistence.update(rubricaPermessi));

		return rubricaPermessi;
	}

	private List<RubricaPermessi> _rubricaPermessis =
		new ArrayList<RubricaPermessi>();
	private RubricaPermessiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}