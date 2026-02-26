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

import it.eng.bollettino.exception.NoSuchValoreSensoreException;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.service.ValoreSensoreLocalServiceUtil;
import it.eng.bollettino.service.persistence.ValoreSensorePersistence;
import it.eng.bollettino.service.persistence.ValoreSensoreUtil;

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
public class ValoreSensorePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = ValoreSensoreUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ValoreSensore> iterator = _valoreSensores.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ValoreSensore valoreSensore = _persistence.create(pk);

		Assert.assertNotNull(valoreSensore);

		Assert.assertEquals(valoreSensore.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ValoreSensore newValoreSensore = addValoreSensore();

		_persistence.remove(newValoreSensore);

		ValoreSensore existingValoreSensore = _persistence.fetchByPrimaryKey(
			newValoreSensore.getPrimaryKey());

		Assert.assertNull(existingValoreSensore);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addValoreSensore();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ValoreSensore newValoreSensore = _persistence.create(pk);

		newValoreSensore.setUuid(RandomTestUtil.randomString());

		newValoreSensore.setValue(RandomTestUtil.nextDouble());

		newValoreSensore.setDatetime(RandomTestUtil.nextDate());

		newValoreSensore.setIdVariabile(RandomTestUtil.randomString());

		newValoreSensore.setIdStazione(RandomTestUtil.randomString());

		_valoreSensores.add(_persistence.update(newValoreSensore));

		ValoreSensore existingValoreSensore = _persistence.findByPrimaryKey(
			newValoreSensore.getPrimaryKey());

		Assert.assertEquals(
			existingValoreSensore.getUuid(), newValoreSensore.getUuid());
		Assert.assertEquals(
			existingValoreSensore.getId(), newValoreSensore.getId());
		AssertUtils.assertEquals(
			existingValoreSensore.getValue(), newValoreSensore.getValue());
		Assert.assertEquals(
			Time.getShortTimestamp(existingValoreSensore.getDatetime()),
			Time.getShortTimestamp(newValoreSensore.getDatetime()));
		Assert.assertEquals(
			existingValoreSensore.getIdVariabile(),
			newValoreSensore.getIdVariabile());
		Assert.assertEquals(
			existingValoreSensore.getIdStazione(),
			newValoreSensore.getIdStazione());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByvariabileStazione() throws Exception {
		_persistence.countByvariabileStazione("", "");

		_persistence.countByvariabileStazione("null", "null");

		_persistence.countByvariabileStazione((String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ValoreSensore newValoreSensore = addValoreSensore();

		ValoreSensore existingValoreSensore = _persistence.findByPrimaryKey(
			newValoreSensore.getPrimaryKey());

		Assert.assertEquals(existingValoreSensore, newValoreSensore);
	}

	@Test(expected = NoSuchValoreSensoreException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ValoreSensore> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_ValoreSensore", "uuid", true, "id", true, "value", true,
			"datetime", true, "idVariabile", true, "idStazione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ValoreSensore newValoreSensore = addValoreSensore();

		ValoreSensore existingValoreSensore = _persistence.fetchByPrimaryKey(
			newValoreSensore.getPrimaryKey());

		Assert.assertEquals(existingValoreSensore, newValoreSensore);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ValoreSensore missingValoreSensore = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingValoreSensore);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ValoreSensore newValoreSensore1 = addValoreSensore();
		ValoreSensore newValoreSensore2 = addValoreSensore();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newValoreSensore1.getPrimaryKey());
		primaryKeys.add(newValoreSensore2.getPrimaryKey());

		Map<Serializable, ValoreSensore> valoreSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, valoreSensores.size());
		Assert.assertEquals(
			newValoreSensore1,
			valoreSensores.get(newValoreSensore1.getPrimaryKey()));
		Assert.assertEquals(
			newValoreSensore2,
			valoreSensores.get(newValoreSensore2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ValoreSensore> valoreSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(valoreSensores.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ValoreSensore newValoreSensore = addValoreSensore();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newValoreSensore.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ValoreSensore> valoreSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, valoreSensores.size());
		Assert.assertEquals(
			newValoreSensore,
			valoreSensores.get(newValoreSensore.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ValoreSensore> valoreSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(valoreSensores.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ValoreSensore newValoreSensore = addValoreSensore();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newValoreSensore.getPrimaryKey());

		Map<Serializable, ValoreSensore> valoreSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, valoreSensores.size());
		Assert.assertEquals(
			newValoreSensore,
			valoreSensores.get(newValoreSensore.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ValoreSensoreLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ValoreSensore>() {

				@Override
				public void performAction(ValoreSensore valoreSensore) {
					Assert.assertNotNull(valoreSensore);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ValoreSensore newValoreSensore = addValoreSensore();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ValoreSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newValoreSensore.getId()));

		List<ValoreSensore> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ValoreSensore existingValoreSensore = result.get(0);

		Assert.assertEquals(existingValoreSensore, newValoreSensore);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ValoreSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ValoreSensore> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ValoreSensore newValoreSensore = addValoreSensore();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ValoreSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newValoreSensore.getId();

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
			ValoreSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ValoreSensore addValoreSensore() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ValoreSensore valoreSensore = _persistence.create(pk);

		valoreSensore.setUuid(RandomTestUtil.randomString());

		valoreSensore.setValue(RandomTestUtil.nextDouble());

		valoreSensore.setDatetime(RandomTestUtil.nextDate());

		valoreSensore.setIdVariabile(RandomTestUtil.randomString());

		valoreSensore.setIdStazione(RandomTestUtil.randomString());

		_valoreSensores.add(_persistence.update(valoreSensore));

		return valoreSensore;
	}

	private List<ValoreSensore> _valoreSensores =
		new ArrayList<ValoreSensore>();
	private ValoreSensorePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}