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
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException;
import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.service.RegolaAllarmeComuneLocalServiceUtil;
import it.eng.bollettino.service.persistence.RegolaAllarmeComunePersistence;
import it.eng.bollettino.service.persistence.RegolaAllarmeComuneUtil;

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
public class RegolaAllarmeComunePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = RegolaAllarmeComuneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RegolaAllarmeComune> iterator =
			_regolaAllarmeComunes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeComune regolaAllarmeComune = _persistence.create(pk);

		Assert.assertNotNull(regolaAllarmeComune);

		Assert.assertEquals(regolaAllarmeComune.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		_persistence.remove(newRegolaAllarmeComune);

		RegolaAllarmeComune existingRegolaAllarmeComune =
			_persistence.fetchByPrimaryKey(
				newRegolaAllarmeComune.getPrimaryKey());

		Assert.assertNull(existingRegolaAllarmeComune);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRegolaAllarmeComune();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeComune newRegolaAllarmeComune = _persistence.create(pk);

		newRegolaAllarmeComune.setUuid(RandomTestUtil.randomString());

		newRegolaAllarmeComune.setIdRegola(RandomTestUtil.nextLong());

		newRegolaAllarmeComune.setIdComune(RandomTestUtil.nextLong());

		_regolaAllarmeComunes.add(_persistence.update(newRegolaAllarmeComune));

		RegolaAllarmeComune existingRegolaAllarmeComune =
			_persistence.findByPrimaryKey(
				newRegolaAllarmeComune.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarmeComune.getUuid(),
			newRegolaAllarmeComune.getUuid());
		Assert.assertEquals(
			existingRegolaAllarmeComune.getId(),
			newRegolaAllarmeComune.getId());
		Assert.assertEquals(
			existingRegolaAllarmeComune.getIdRegola(),
			newRegolaAllarmeComune.getIdRegola());
		Assert.assertEquals(
			existingRegolaAllarmeComune.getIdComune(),
			newRegolaAllarmeComune.getIdComune());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByRegola() throws Exception {
		_persistence.countByRegola(RandomTestUtil.nextLong());

		_persistence.countByRegola(0L);
	}

	@Test
	public void testCountByComune() throws Exception {
		_persistence.countByComune(RandomTestUtil.nextLong());

		_persistence.countByComune(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		RegolaAllarmeComune existingRegolaAllarmeComune =
			_persistence.findByPrimaryKey(
				newRegolaAllarmeComune.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarmeComune, newRegolaAllarmeComune);
	}

	@Test(expected = NoSuchRegolaAllarmeComuneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RegolaAllarmeComune> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_RegolaAllarmeComune", "uuid", true, "id", true,
			"idRegola", true, "idComune", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		RegolaAllarmeComune existingRegolaAllarmeComune =
			_persistence.fetchByPrimaryKey(
				newRegolaAllarmeComune.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarmeComune, newRegolaAllarmeComune);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeComune missingRegolaAllarmeComune =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRegolaAllarmeComune);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RegolaAllarmeComune newRegolaAllarmeComune1 = addRegolaAllarmeComune();
		RegolaAllarmeComune newRegolaAllarmeComune2 = addRegolaAllarmeComune();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarmeComune1.getPrimaryKey());
		primaryKeys.add(newRegolaAllarmeComune2.getPrimaryKey());

		Map<Serializable, RegolaAllarmeComune> regolaAllarmeComunes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, regolaAllarmeComunes.size());
		Assert.assertEquals(
			newRegolaAllarmeComune1,
			regolaAllarmeComunes.get(newRegolaAllarmeComune1.getPrimaryKey()));
		Assert.assertEquals(
			newRegolaAllarmeComune2,
			regolaAllarmeComunes.get(newRegolaAllarmeComune2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RegolaAllarmeComune> regolaAllarmeComunes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(regolaAllarmeComunes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarmeComune.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RegolaAllarmeComune> regolaAllarmeComunes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, regolaAllarmeComunes.size());
		Assert.assertEquals(
			newRegolaAllarmeComune,
			regolaAllarmeComunes.get(newRegolaAllarmeComune.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RegolaAllarmeComune> regolaAllarmeComunes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(regolaAllarmeComunes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarmeComune.getPrimaryKey());

		Map<Serializable, RegolaAllarmeComune> regolaAllarmeComunes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, regolaAllarmeComunes.size());
		Assert.assertEquals(
			newRegolaAllarmeComune,
			regolaAllarmeComunes.get(newRegolaAllarmeComune.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RegolaAllarmeComuneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RegolaAllarmeComune>() {

				@Override
				public void performAction(
					RegolaAllarmeComune regolaAllarmeComune) {

					Assert.assertNotNull(regolaAllarmeComune);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarmeComune.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newRegolaAllarmeComune.getId()));

		List<RegolaAllarmeComune> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RegolaAllarmeComune existingRegolaAllarmeComune = result.get(0);

		Assert.assertEquals(
			existingRegolaAllarmeComune, newRegolaAllarmeComune);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarmeComune.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<RegolaAllarmeComune> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RegolaAllarmeComune newRegolaAllarmeComune = addRegolaAllarmeComune();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarmeComune.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newRegolaAllarmeComune.getId();

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
			RegolaAllarmeComune.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RegolaAllarmeComune addRegolaAllarmeComune() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeComune regolaAllarmeComune = _persistence.create(pk);

		regolaAllarmeComune.setUuid(RandomTestUtil.randomString());

		regolaAllarmeComune.setIdRegola(RandomTestUtil.nextLong());

		regolaAllarmeComune.setIdComune(RandomTestUtil.nextLong());

		_regolaAllarmeComunes.add(_persistence.update(regolaAllarmeComune));

		return regolaAllarmeComune;
	}

	private List<RegolaAllarmeComune> _regolaAllarmeComunes =
		new ArrayList<RegolaAllarmeComune>();
	private RegolaAllarmeComunePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}