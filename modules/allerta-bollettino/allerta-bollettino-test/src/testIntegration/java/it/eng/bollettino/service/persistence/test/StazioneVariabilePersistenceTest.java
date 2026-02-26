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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.bollettino.exception.NoSuchStazioneVariabileException;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.persistence.StazioneVariabilePersistence;
import it.eng.bollettino.service.persistence.StazioneVariabileUtil;

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
public class StazioneVariabilePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = StazioneVariabileUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StazioneVariabile> iterator = _stazioneVariabiles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StazioneVariabile stazioneVariabile = _persistence.create(pk);

		Assert.assertNotNull(stazioneVariabile);

		Assert.assertEquals(stazioneVariabile.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		_persistence.remove(newStazioneVariabile);

		StazioneVariabile existingStazioneVariabile =
			_persistence.fetchByPrimaryKey(
				newStazioneVariabile.getPrimaryKey());

		Assert.assertNull(existingStazioneVariabile);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStazioneVariabile();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StazioneVariabile newStazioneVariabile = _persistence.create(pk);

		newStazioneVariabile.setUuid(RandomTestUtil.randomString());

		newStazioneVariabile.setIdStazione(RandomTestUtil.randomString());

		newStazioneVariabile.setIdVariabile(RandomTestUtil.randomString());

		newStazioneVariabile.setDataUltimoValore(RandomTestUtil.nextDate());

		newStazioneVariabile.setSoglia1(RandomTestUtil.nextDouble());

		newStazioneVariabile.setSoglia2(RandomTestUtil.nextDouble());

		newStazioneVariabile.setSoglia3(RandomTestUtil.nextDouble());

		_stazioneVariabiles.add(_persistence.update(newStazioneVariabile));

		StazioneVariabile existingStazioneVariabile =
			_persistence.findByPrimaryKey(newStazioneVariabile.getPrimaryKey());

		Assert.assertEquals(
			existingStazioneVariabile.getUuid(),
			newStazioneVariabile.getUuid());
		Assert.assertEquals(
			existingStazioneVariabile.getId(), newStazioneVariabile.getId());
		Assert.assertEquals(
			existingStazioneVariabile.getIdStazione(),
			newStazioneVariabile.getIdStazione());
		Assert.assertEquals(
			existingStazioneVariabile.getIdVariabile(),
			newStazioneVariabile.getIdVariabile());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingStazioneVariabile.getDataUltimoValore()),
			Time.getShortTimestamp(newStazioneVariabile.getDataUltimoValore()));
		AssertUtils.assertEquals(
			existingStazioneVariabile.getSoglia1(),
			newStazioneVariabile.getSoglia1());
		AssertUtils.assertEquals(
			existingStazioneVariabile.getSoglia2(),
			newStazioneVariabile.getSoglia2());
		AssertUtils.assertEquals(
			existingStazioneVariabile.getSoglia3(),
			newStazioneVariabile.getSoglia3());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByStazione() throws Exception {
		_persistence.countByStazione("");

		_persistence.countByStazione("null");

		_persistence.countByStazione((String)null);
	}

	@Test
	public void testCountByVariabile() throws Exception {
		_persistence.countByVariabile("");

		_persistence.countByVariabile("null");

		_persistence.countByVariabile((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		StazioneVariabile existingStazioneVariabile =
			_persistence.findByPrimaryKey(newStazioneVariabile.getPrimaryKey());

		Assert.assertEquals(existingStazioneVariabile, newStazioneVariabile);
	}

	@Test(expected = NoSuchStazioneVariabileException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<StazioneVariabile> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_StazioneVariabile", "uuid", true, "id", true,
			"idStazione", true, "idVariabile", true, "dataUltimoValore", true,
			"soglia1", true, "soglia2", true, "soglia3", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		StazioneVariabile existingStazioneVariabile =
			_persistence.fetchByPrimaryKey(
				newStazioneVariabile.getPrimaryKey());

		Assert.assertEquals(existingStazioneVariabile, newStazioneVariabile);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StazioneVariabile missingStazioneVariabile =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStazioneVariabile);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StazioneVariabile newStazioneVariabile1 = addStazioneVariabile();
		StazioneVariabile newStazioneVariabile2 = addStazioneVariabile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStazioneVariabile1.getPrimaryKey());
		primaryKeys.add(newStazioneVariabile2.getPrimaryKey());

		Map<Serializable, StazioneVariabile> stazioneVariabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, stazioneVariabiles.size());
		Assert.assertEquals(
			newStazioneVariabile1,
			stazioneVariabiles.get(newStazioneVariabile1.getPrimaryKey()));
		Assert.assertEquals(
			newStazioneVariabile2,
			stazioneVariabiles.get(newStazioneVariabile2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StazioneVariabile> stazioneVariabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(stazioneVariabiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStazioneVariabile.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StazioneVariabile> stazioneVariabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, stazioneVariabiles.size());
		Assert.assertEquals(
			newStazioneVariabile,
			stazioneVariabiles.get(newStazioneVariabile.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StazioneVariabile> stazioneVariabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(stazioneVariabiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStazioneVariabile.getPrimaryKey());

		Map<Serializable, StazioneVariabile> stazioneVariabiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, stazioneVariabiles.size());
		Assert.assertEquals(
			newStazioneVariabile,
			stazioneVariabiles.get(newStazioneVariabile.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StazioneVariabileLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<StazioneVariabile>() {

				@Override
				public void performAction(StazioneVariabile stazioneVariabile) {
					Assert.assertNotNull(stazioneVariabile);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StazioneVariabile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newStazioneVariabile.getId()));

		List<StazioneVariabile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StazioneVariabile existingStazioneVariabile = result.get(0);

		Assert.assertEquals(existingStazioneVariabile, newStazioneVariabile);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StazioneVariabile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<StazioneVariabile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StazioneVariabile newStazioneVariabile = addStazioneVariabile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StazioneVariabile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newStazioneVariabile.getId();

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
			StazioneVariabile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected StazioneVariabile addStazioneVariabile() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StazioneVariabile stazioneVariabile = _persistence.create(pk);

		stazioneVariabile.setUuid(RandomTestUtil.randomString());

		stazioneVariabile.setIdStazione(RandomTestUtil.randomString());

		stazioneVariabile.setIdVariabile(RandomTestUtil.randomString());

		stazioneVariabile.setDataUltimoValore(RandomTestUtil.nextDate());

		stazioneVariabile.setSoglia1(RandomTestUtil.nextDouble());

		stazioneVariabile.setSoglia2(RandomTestUtil.nextDouble());

		stazioneVariabile.setSoglia3(RandomTestUtil.nextDouble());

		_stazioneVariabiles.add(_persistence.update(stazioneVariabile));

		return stazioneVariabile;
	}

	private List<StazioneVariabile> _stazioneVariabiles =
		new ArrayList<StazioneVariabile>();
	private StazioneVariabilePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}