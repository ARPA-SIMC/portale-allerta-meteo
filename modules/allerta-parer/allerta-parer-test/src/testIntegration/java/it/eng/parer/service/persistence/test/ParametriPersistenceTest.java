/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.test;

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

import it.eng.parer.exception.NoSuchParametriException;
import it.eng.parer.model.Parametri;
import it.eng.parer.service.persistence.ParametriPersistence;
import it.eng.parer.service.persistence.ParametriUtil;

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
public class ParametriPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.parer.service"));

	@Before
	public void setUp() {
		_persistence = ParametriUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Parametri> iterator = _parametris.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametri parametri = _persistence.create(pk);

		Assert.assertNotNull(parametri);

		Assert.assertEquals(parametri.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Parametri newParametri = addParametri();

		_persistence.remove(newParametri);

		Parametri existingParametri = _persistence.fetchByPrimaryKey(
			newParametri.getPrimaryKey());

		Assert.assertNull(existingParametri);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addParametri();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametri newParametri = _persistence.create(pk);

		newParametri.setValore(RandomTestUtil.randomString());

		_parametris.add(_persistence.update(newParametri));

		Parametri existingParametri = _persistence.findByPrimaryKey(
			newParametri.getPrimaryKey());

		Assert.assertEquals(
			existingParametri.getChiave(), newParametri.getChiave());
		Assert.assertEquals(
			existingParametri.getValore(), newParametri.getValore());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Parametri newParametri = addParametri();

		Parametri existingParametri = _persistence.findByPrimaryKey(
			newParametri.getPrimaryKey());

		Assert.assertEquals(existingParametri, newParametri);
	}

	@Test(expected = NoSuchParametriException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Parametri> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"parer_Parametri", "chiave", true, "valore", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Parametri newParametri = addParametri();

		Parametri existingParametri = _persistence.fetchByPrimaryKey(
			newParametri.getPrimaryKey());

		Assert.assertEquals(existingParametri, newParametri);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametri missingParametri = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingParametri);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Parametri newParametri1 = addParametri();
		Parametri newParametri2 = addParametri();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametri1.getPrimaryKey());
		primaryKeys.add(newParametri2.getPrimaryKey());

		Map<Serializable, Parametri> parametris =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, parametris.size());
		Assert.assertEquals(
			newParametri1, parametris.get(newParametri1.getPrimaryKey()));
		Assert.assertEquals(
			newParametri2, parametris.get(newParametri2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Parametri> parametris =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parametris.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Parametri newParametri = addParametri();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametri.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Parametri> parametris =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parametris.size());
		Assert.assertEquals(
			newParametri, parametris.get(newParametri.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Parametri> parametris =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parametris.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Parametri newParametri = addParametri();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametri.getPrimaryKey());

		Map<Serializable, Parametri> parametris =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parametris.size());
		Assert.assertEquals(
			newParametri, parametris.get(newParametri.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Parametri newParametri = addParametri();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametri.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("chiave", newParametri.getChiave()));

		List<Parametri> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Parametri existingParametri = result.get(0);

		Assert.assertEquals(existingParametri, newParametri);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametri.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"chiave", RandomTestUtil.randomString()));

		List<Parametri> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Parametri newParametri = addParametri();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametri.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("chiave"));

		Object newChiave = newParametri.getChiave();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("chiave", new Object[] {newChiave}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingChiave = result.get(0);

		Assert.assertEquals(existingChiave, newChiave);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametri.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("chiave"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"chiave", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Parametri addParametri() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametri parametri = _persistence.create(pk);

		parametri.setValore(RandomTestUtil.randomString());

		_parametris.add(_persistence.update(parametri));

		return parametri;
	}

	private List<Parametri> _parametris = new ArrayList<Parametri>();
	private ParametriPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}