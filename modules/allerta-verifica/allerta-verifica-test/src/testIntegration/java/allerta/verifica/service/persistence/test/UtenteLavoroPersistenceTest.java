/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.test;

import allerta.verifica.exception.NoSuchUtenteLavoroException;
import allerta.verifica.model.UtenteLavoro;
import allerta.verifica.service.UtenteLavoroLocalServiceUtil;
import allerta.verifica.service.persistence.UtenteLavoroPersistence;
import allerta.verifica.service.persistence.UtenteLavoroUtil;

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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

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
public class UtenteLavoroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.verifica.service"));

	@Before
	public void setUp() {
		_persistence = UtenteLavoroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UtenteLavoro> iterator = _utenteLavoros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UtenteLavoro utenteLavoro = _persistence.create(pk);

		Assert.assertNotNull(utenteLavoro);

		Assert.assertEquals(utenteLavoro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		_persistence.remove(newUtenteLavoro);

		UtenteLavoro existingUtenteLavoro = _persistence.fetchByPrimaryKey(
			newUtenteLavoro.getPrimaryKey());

		Assert.assertNull(existingUtenteLavoro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUtenteLavoro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UtenteLavoro newUtenteLavoro = _persistence.create(pk);

		newUtenteLavoro.setDocumento(RandomTestUtil.nextLong());

		newUtenteLavoro.setUtente(RandomTestUtil.randomString());

		newUtenteLavoro.setTs(RandomTestUtil.nextDate());

		newUtenteLavoro.setAttivita(RandomTestUtil.randomString());

		_utenteLavoros.add(_persistence.update(newUtenteLavoro));

		UtenteLavoro existingUtenteLavoro = _persistence.findByPrimaryKey(
			newUtenteLavoro.getPrimaryKey());

		Assert.assertEquals(
			existingUtenteLavoro.getId(), newUtenteLavoro.getId());
		Assert.assertEquals(
			existingUtenteLavoro.getDocumento(),
			newUtenteLavoro.getDocumento());
		Assert.assertEquals(
			existingUtenteLavoro.getUtente(), newUtenteLavoro.getUtente());
		Assert.assertEquals(
			Time.getShortTimestamp(existingUtenteLavoro.getTs()),
			Time.getShortTimestamp(newUtenteLavoro.getTs()));
		Assert.assertEquals(
			existingUtenteLavoro.getAttivita(), newUtenteLavoro.getAttivita());
	}

	@Test
	public void testCountByDocumento() throws Exception {
		_persistence.countByDocumento(RandomTestUtil.nextLong());

		_persistence.countByDocumento(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		UtenteLavoro existingUtenteLavoro = _persistence.findByPrimaryKey(
			newUtenteLavoro.getPrimaryKey());

		Assert.assertEquals(existingUtenteLavoro, newUtenteLavoro);
	}

	@Test(expected = NoSuchUtenteLavoroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<UtenteLavoro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"VERIFICA_UtenteLavoro", "id", true, "documento", true, "utente",
			true, "ts", true, "attivita", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		UtenteLavoro existingUtenteLavoro = _persistence.fetchByPrimaryKey(
			newUtenteLavoro.getPrimaryKey());

		Assert.assertEquals(existingUtenteLavoro, newUtenteLavoro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UtenteLavoro missingUtenteLavoro = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUtenteLavoro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		UtenteLavoro newUtenteLavoro1 = addUtenteLavoro();
		UtenteLavoro newUtenteLavoro2 = addUtenteLavoro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUtenteLavoro1.getPrimaryKey());
		primaryKeys.add(newUtenteLavoro2.getPrimaryKey());

		Map<Serializable, UtenteLavoro> utenteLavoros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, utenteLavoros.size());
		Assert.assertEquals(
			newUtenteLavoro1,
			utenteLavoros.get(newUtenteLavoro1.getPrimaryKey()));
		Assert.assertEquals(
			newUtenteLavoro2,
			utenteLavoros.get(newUtenteLavoro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UtenteLavoro> utenteLavoros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(utenteLavoros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUtenteLavoro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UtenteLavoro> utenteLavoros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, utenteLavoros.size());
		Assert.assertEquals(
			newUtenteLavoro,
			utenteLavoros.get(newUtenteLavoro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UtenteLavoro> utenteLavoros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(utenteLavoros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUtenteLavoro.getPrimaryKey());

		Map<Serializable, UtenteLavoro> utenteLavoros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, utenteLavoros.size());
		Assert.assertEquals(
			newUtenteLavoro,
			utenteLavoros.get(newUtenteLavoro.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			UtenteLavoroLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<UtenteLavoro>() {

				@Override
				public void performAction(UtenteLavoro utenteLavoro) {
					Assert.assertNotNull(utenteLavoro);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UtenteLavoro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newUtenteLavoro.getId()));

		List<UtenteLavoro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		UtenteLavoro existingUtenteLavoro = result.get(0);

		Assert.assertEquals(existingUtenteLavoro, newUtenteLavoro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UtenteLavoro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<UtenteLavoro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		UtenteLavoro newUtenteLavoro = addUtenteLavoro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UtenteLavoro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newUtenteLavoro.getId();

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
			UtenteLavoro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected UtenteLavoro addUtenteLavoro() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UtenteLavoro utenteLavoro = _persistence.create(pk);

		utenteLavoro.setDocumento(RandomTestUtil.nextLong());

		utenteLavoro.setUtente(RandomTestUtil.randomString());

		utenteLavoro.setTs(RandomTestUtil.nextDate());

		utenteLavoro.setAttivita(RandomTestUtil.randomString());

		_utenteLavoros.add(_persistence.update(utenteLavoro));

		return utenteLavoro;
	}

	private List<UtenteLavoro> _utenteLavoros = new ArrayList<UtenteLavoro>();
	private UtenteLavoroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}