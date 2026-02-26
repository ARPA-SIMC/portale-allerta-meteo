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

import it.eng.bollettino.exception.NoSuchIconaException;
import it.eng.bollettino.model.Icona;
import it.eng.bollettino.service.IconaLocalServiceUtil;
import it.eng.bollettino.service.persistence.IconaPersistence;
import it.eng.bollettino.service.persistence.IconaUtil;

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
public class IconaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = IconaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Icona> iterator = _iconas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Icona icona = _persistence.create(pk);

		Assert.assertNotNull(icona);

		Assert.assertEquals(icona.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Icona newIcona = addIcona();

		_persistence.remove(newIcona);

		Icona existingIcona = _persistence.fetchByPrimaryKey(
			newIcona.getPrimaryKey());

		Assert.assertNull(existingIcona);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addIcona();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Icona newIcona = _persistence.create(pk);

		newIcona.setUuid(RandomTestUtil.randomString());

		newIcona.setPath(RandomTestUtil.randomString());

		newIcona.setDescrizione(RandomTestUtil.randomString());

		_iconas.add(_persistence.update(newIcona));

		Icona existingIcona = _persistence.findByPrimaryKey(
			newIcona.getPrimaryKey());

		Assert.assertEquals(existingIcona.getUuid(), newIcona.getUuid());
		Assert.assertEquals(existingIcona.getId(), newIcona.getId());
		Assert.assertEquals(existingIcona.getPath(), newIcona.getPath());
		Assert.assertEquals(
			existingIcona.getDescrizione(), newIcona.getDescrizione());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Icona newIcona = addIcona();

		Icona existingIcona = _persistence.findByPrimaryKey(
			newIcona.getPrimaryKey());

		Assert.assertEquals(existingIcona, newIcona);
	}

	@Test(expected = NoSuchIconaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Icona> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Icona", "uuid", true, "id", true, "path", true,
			"descrizione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Icona newIcona = addIcona();

		Icona existingIcona = _persistence.fetchByPrimaryKey(
			newIcona.getPrimaryKey());

		Assert.assertEquals(existingIcona, newIcona);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Icona missingIcona = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingIcona);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Icona newIcona1 = addIcona();
		Icona newIcona2 = addIcona();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIcona1.getPrimaryKey());
		primaryKeys.add(newIcona2.getPrimaryKey());

		Map<Serializable, Icona> iconas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, iconas.size());
		Assert.assertEquals(newIcona1, iconas.get(newIcona1.getPrimaryKey()));
		Assert.assertEquals(newIcona2, iconas.get(newIcona2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Icona> iconas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(iconas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Icona newIcona = addIcona();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIcona.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Icona> iconas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, iconas.size());
		Assert.assertEquals(newIcona, iconas.get(newIcona.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Icona> iconas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(iconas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Icona newIcona = addIcona();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIcona.getPrimaryKey());

		Map<Serializable, Icona> iconas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, iconas.size());
		Assert.assertEquals(newIcona, iconas.get(newIcona.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			IconaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Icona>() {

				@Override
				public void performAction(Icona icona) {
					Assert.assertNotNull(icona);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Icona newIcona = addIcona();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Icona.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newIcona.getId()));

		List<Icona> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Icona existingIcona = result.get(0);

		Assert.assertEquals(existingIcona, newIcona);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Icona.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Icona> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Icona newIcona = addIcona();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Icona.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newIcona.getId();

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
			Icona.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Icona addIcona() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Icona icona = _persistence.create(pk);

		icona.setUuid(RandomTestUtil.randomString());

		icona.setPath(RandomTestUtil.randomString());

		icona.setDescrizione(RandomTestUtil.randomString());

		_iconas.add(_persistence.update(icona));

		return icona;
	}

	private List<Icona> _iconas = new ArrayList<Icona>();
	private IconaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}