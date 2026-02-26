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
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.bollettino.exception.NoSuchRegolaAllarmeCondizioneException;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.persistence.RegolaAllarmeCondizionePersistence;
import it.eng.bollettino.service.persistence.RegolaAllarmeCondizioneUtil;

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
public class RegolaAllarmeCondizionePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = RegolaAllarmeCondizioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RegolaAllarmeCondizione> iterator =
			_regolaAllarmeCondiziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeCondizione regolaAllarmeCondizione = _persistence.create(
			pk);

		Assert.assertNotNull(regolaAllarmeCondizione);

		Assert.assertEquals(regolaAllarmeCondizione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		_persistence.remove(newRegolaAllarmeCondizione);

		RegolaAllarmeCondizione existingRegolaAllarmeCondizione =
			_persistence.fetchByPrimaryKey(
				newRegolaAllarmeCondizione.getPrimaryKey());

		Assert.assertNull(existingRegolaAllarmeCondizione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRegolaAllarmeCondizione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			_persistence.create(pk);

		newRegolaAllarmeCondizione.setUuid(RandomTestUtil.randomString());

		newRegolaAllarmeCondizione.setIdRegola(RandomTestUtil.nextLong());

		newRegolaAllarmeCondizione.setLettera(RandomTestUtil.randomString());

		newRegolaAllarmeCondizione.setIdVariabile(
			RandomTestUtil.randomString());

		newRegolaAllarmeCondizione.setIdStazione(RandomTestUtil.randomString());

		newRegolaAllarmeCondizione.setIdStazioneVariabile(
			RandomTestUtil.nextLong());

		newRegolaAllarmeCondizione.setSoglia(RandomTestUtil.nextInt());

		newRegolaAllarmeCondizione.setValoreSoglia(RandomTestUtil.nextDouble());

		_regolaAllarmeCondiziones.add(
			_persistence.update(newRegolaAllarmeCondizione));

		RegolaAllarmeCondizione existingRegolaAllarmeCondizione =
			_persistence.findByPrimaryKey(
				newRegolaAllarmeCondizione.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getUuid(),
			newRegolaAllarmeCondizione.getUuid());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getId(),
			newRegolaAllarmeCondizione.getId());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getIdRegola(),
			newRegolaAllarmeCondizione.getIdRegola());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getLettera(),
			newRegolaAllarmeCondizione.getLettera());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getIdVariabile(),
			newRegolaAllarmeCondizione.getIdVariabile());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getIdStazione(),
			newRegolaAllarmeCondizione.getIdStazione());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getIdStazioneVariabile(),
			newRegolaAllarmeCondizione.getIdStazioneVariabile());
		Assert.assertEquals(
			existingRegolaAllarmeCondizione.getSoglia(),
			newRegolaAllarmeCondizione.getSoglia());
		AssertUtils.assertEquals(
			existingRegolaAllarmeCondizione.getValoreSoglia(),
			newRegolaAllarmeCondizione.getValoreSoglia());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		RegolaAllarmeCondizione existingRegolaAllarmeCondizione =
			_persistence.findByPrimaryKey(
				newRegolaAllarmeCondizione.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarmeCondizione, newRegolaAllarmeCondizione);
	}

	@Test(expected = NoSuchRegolaAllarmeCondizioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RegolaAllarmeCondizione>
		getOrderByComparator() {

		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_RegolaAllarmeCondizione", "uuid", true, "id", true,
			"idRegola", true, "lettera", true, "idVariabile", true,
			"idStazione", true, "idStazioneVariabile", true, "soglia", true,
			"valoreSoglia", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		RegolaAllarmeCondizione existingRegolaAllarmeCondizione =
			_persistence.fetchByPrimaryKey(
				newRegolaAllarmeCondizione.getPrimaryKey());

		Assert.assertEquals(
			existingRegolaAllarmeCondizione, newRegolaAllarmeCondizione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeCondizione missingRegolaAllarmeCondizione =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRegolaAllarmeCondizione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RegolaAllarmeCondizione newRegolaAllarmeCondizione1 =
			addRegolaAllarmeCondizione();
		RegolaAllarmeCondizione newRegolaAllarmeCondizione2 =
			addRegolaAllarmeCondizione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarmeCondizione1.getPrimaryKey());
		primaryKeys.add(newRegolaAllarmeCondizione2.getPrimaryKey());

		Map<Serializable, RegolaAllarmeCondizione> regolaAllarmeCondiziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, regolaAllarmeCondiziones.size());
		Assert.assertEquals(
			newRegolaAllarmeCondizione1,
			regolaAllarmeCondiziones.get(
				newRegolaAllarmeCondizione1.getPrimaryKey()));
		Assert.assertEquals(
			newRegolaAllarmeCondizione2,
			regolaAllarmeCondiziones.get(
				newRegolaAllarmeCondizione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RegolaAllarmeCondizione> regolaAllarmeCondiziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(regolaAllarmeCondiziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarmeCondizione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RegolaAllarmeCondizione> regolaAllarmeCondiziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, regolaAllarmeCondiziones.size());
		Assert.assertEquals(
			newRegolaAllarmeCondizione,
			regolaAllarmeCondiziones.get(
				newRegolaAllarmeCondizione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RegolaAllarmeCondizione> regolaAllarmeCondiziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(regolaAllarmeCondiziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRegolaAllarmeCondizione.getPrimaryKey());

		Map<Serializable, RegolaAllarmeCondizione> regolaAllarmeCondiziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, regolaAllarmeCondiziones.size());
		Assert.assertEquals(
			newRegolaAllarmeCondizione,
			regolaAllarmeCondiziones.get(
				newRegolaAllarmeCondizione.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RegolaAllarmeCondizioneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RegolaAllarmeCondizione>() {

				@Override
				public void performAction(
					RegolaAllarmeCondizione regolaAllarmeCondizione) {

					Assert.assertNotNull(regolaAllarmeCondizione);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarmeCondizione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id", newRegolaAllarmeCondizione.getId()));

		List<RegolaAllarmeCondizione> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		RegolaAllarmeCondizione existingRegolaAllarmeCondizione = result.get(0);

		Assert.assertEquals(
			existingRegolaAllarmeCondizione, newRegolaAllarmeCondizione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarmeCondizione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<RegolaAllarmeCondizione> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RegolaAllarmeCondizione newRegolaAllarmeCondizione =
			addRegolaAllarmeCondizione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RegolaAllarmeCondizione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newRegolaAllarmeCondizione.getId();

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
			RegolaAllarmeCondizione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RegolaAllarmeCondizione addRegolaAllarmeCondizione()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		RegolaAllarmeCondizione regolaAllarmeCondizione = _persistence.create(
			pk);

		regolaAllarmeCondizione.setUuid(RandomTestUtil.randomString());

		regolaAllarmeCondizione.setIdRegola(RandomTestUtil.nextLong());

		regolaAllarmeCondizione.setLettera(RandomTestUtil.randomString());

		regolaAllarmeCondizione.setIdVariabile(RandomTestUtil.randomString());

		regolaAllarmeCondizione.setIdStazione(RandomTestUtil.randomString());

		regolaAllarmeCondizione.setIdStazioneVariabile(
			RandomTestUtil.nextLong());

		regolaAllarmeCondizione.setSoglia(RandomTestUtil.nextInt());

		regolaAllarmeCondizione.setValoreSoglia(RandomTestUtil.nextDouble());

		_regolaAllarmeCondiziones.add(
			_persistence.update(regolaAllarmeCondizione));

		return regolaAllarmeCondizione;
	}

	private List<RegolaAllarmeCondizione> _regolaAllarmeCondiziones =
		new ArrayList<RegolaAllarmeCondizione>();
	private RegolaAllarmeCondizionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}