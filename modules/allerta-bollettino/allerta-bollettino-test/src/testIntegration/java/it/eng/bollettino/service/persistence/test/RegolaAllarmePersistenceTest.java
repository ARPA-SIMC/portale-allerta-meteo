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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeException;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;
import it.eng.bollettino.service.persistence.RegolaAllarmePersistence;
import it.eng.bollettino.service.persistence.RegolaAllarmeUtil;

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
public class RegolaAllarmePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = RegolaAllarmeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RegolaAllarme> iterator = _regolaAllarmes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarme regolaAllarme = _persistence.create(pk);

		Assert.assertNotNull(regolaAllarme);

		Assert.assertEquals(regolaAllarme.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		_persistence.remove(newRegolaAllarme);

		RegolaAllarme existingRegolaAllarme = _persistence.fetchByPrimaryKey(
			newRegolaAllarme.getPrimaryKey());

		Assert.assertNull(existingRegolaAllarme);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRegolaAllarme();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarme newRegolaAllarme = _persistence.create(pk);

		newRegolaAllarme.setUuid(RandomTestUtil.randomString());

		newRegolaAllarme.setNome(RandomTestUtil.randomString());

		newRegolaAllarme.setEspressione(RandomTestUtil.randomString());

		newRegolaAllarme.setDescrizione(RandomTestUtil.randomString());

		newRegolaAllarme.setColore(RandomTestUtil.nextInt());

		newRegolaAllarme.setAttivo(RandomTestUtil.randomBoolean());

		_regolaAllarmes.add(_persistence.update(newRegolaAllarme));

		RegolaAllarme existingRegolaAllarme = _persistence.findByPrimaryKey(
			newRegolaAllarme.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarme.getUuid(), newRegolaAllarme.getUuid());
		Assert.assertEquals(
			existingRegolaAllarme.getId(), newRegolaAllarme.getId());
		Assert.assertEquals(
			existingRegolaAllarme.getNome(), newRegolaAllarme.getNome());
		Assert.assertEquals(
			existingRegolaAllarme.getEspressione(),
			newRegolaAllarme.getEspressione());
		Assert.assertEquals(
			existingRegolaAllarme.getDescrizione(),
			newRegolaAllarme.getDescrizione());
		Assert.assertEquals(
			existingRegolaAllarme.getColore(), newRegolaAllarme.getColore());
		Assert.assertEquals(
			existingRegolaAllarme.isAttivo(), newRegolaAllarme.isAttivo());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByAttivo() throws Exception {
		_persistence.countByAttivo(RandomTestUtil.randomBoolean());

		_persistence.countByAttivo(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		RegolaAllarme existingRegolaAllarme = _persistence.findByPrimaryKey(
			newRegolaAllarme.getPrimaryKey());

		Assert.assertEquals(existingRegolaAllarme, newRegolaAllarme);
	}

	@Test(expected = NoSuchRegolaAllarmeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RegolaAllarme> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_RegolaAllarme", "uuid", true, "id", true, "nome", true,
			"espressione", true, "descrizione", true, "colore", true, "attivo",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		RegolaAllarme existingRegolaAllarme = _persistence.fetchByPrimaryKey(
			newRegolaAllarme.getPrimaryKey());

		Assert.assertEquals(existingRegolaAllarme, newRegolaAllarme);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarme missingRegolaAllarme = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRegolaAllarme);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RegolaAllarme newRegolaAllarme1 = addRegolaAllarme();
		RegolaAllarme newRegolaAllarme2 = addRegolaAllarme();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarme1.getPrimaryKey());
		primaryKeys.add(newRegolaAllarme2.getPrimaryKey());

		Map<Serializable, RegolaAllarme> regolaAllarmes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, regolaAllarmes.size());
		Assert.assertEquals(
			newRegolaAllarme1,
			regolaAllarmes.get(newRegolaAllarme1.getPrimaryKey()));
		Assert.assertEquals(
			newRegolaAllarme2,
			regolaAllarmes.get(newRegolaAllarme2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RegolaAllarme> regolaAllarmes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(regolaAllarmes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarme.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RegolaAllarme> regolaAllarmes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, regolaAllarmes.size());
		Assert.assertEquals(
			newRegolaAllarme,
			regolaAllarmes.get(newRegolaAllarme.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RegolaAllarme> regolaAllarmes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(regolaAllarmes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarme.getPrimaryKey());

		Map<Serializable, RegolaAllarme> regolaAllarmes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, regolaAllarmes.size());
		Assert.assertEquals(
			newRegolaAllarme,
			regolaAllarmes.get(newRegolaAllarme.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RegolaAllarmeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RegolaAllarme>() {

				@Override
				public void performAction(RegolaAllarme regolaAllarme) {
					Assert.assertNotNull(regolaAllarme);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarme.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newRegolaAllarme.getId()));

		List<RegolaAllarme> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RegolaAllarme existingRegolaAllarme = result.get(0);

		Assert.assertEquals(existingRegolaAllarme, newRegolaAllarme);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarme.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<RegolaAllarme> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RegolaAllarme newRegolaAllarme = addRegolaAllarme();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarme.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newRegolaAllarme.getId();

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
			RegolaAllarme.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RegolaAllarme addRegolaAllarme() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarme regolaAllarme = _persistence.create(pk);

		regolaAllarme.setUuid(RandomTestUtil.randomString());

		regolaAllarme.setNome(RandomTestUtil.randomString());

		regolaAllarme.setEspressione(RandomTestUtil.randomString());

		regolaAllarme.setDescrizione(RandomTestUtil.randomString());

		regolaAllarme.setColore(RandomTestUtil.nextInt());

		regolaAllarme.setAttivo(RandomTestUtil.randomBoolean());

		_regolaAllarmes.add(_persistence.update(regolaAllarme));

		return regolaAllarme;
	}

	private List<RegolaAllarme> _regolaAllarmes =
		new ArrayList<RegolaAllarme>();
	private RegolaAllarmePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}