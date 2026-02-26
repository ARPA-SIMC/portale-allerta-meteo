/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.service.persistence.test;

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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.cache.exception.NoSuchDatiException;
import it.eng.cache.model.Dati;
import it.eng.cache.service.persistence.DatiPersistence;
import it.eng.cache.service.persistence.DatiUtil;

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
public class DatiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.cache.service"));

	@Before
	public void setUp() {
		_persistence = DatiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Dati> iterator = _datis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Dati dati = _persistence.create(pk);

		Assert.assertNotNull(dati);

		Assert.assertEquals(dati.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Dati newDati = addDati();

		_persistence.remove(newDati);

		Dati existingDati = _persistence.fetchByPrimaryKey(
			newDati.getPrimaryKey());

		Assert.assertNull(existingDati);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDati();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Dati newDati = _persistence.create(pk);

		newDati.setDato(RandomTestUtil.randomString());

		newDati.setCreateDate(RandomTestUtil.nextDate());

		_datis.add(_persistence.update(newDati));

		Dati existingDati = _persistence.findByPrimaryKey(
			newDati.getPrimaryKey());

		Assert.assertEquals(existingDati.getIdDati(), newDati.getIdDati());
		Assert.assertEquals(existingDati.getDato(), newDati.getDato());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDati.getCreateDate()),
			Time.getShortTimestamp(newDati.getCreateDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Dati newDati = addDati();

		Dati existingDati = _persistence.findByPrimaryKey(
			newDati.getPrimaryKey());

		Assert.assertEquals(existingDati, newDati);
	}

	@Test(expected = NoSuchDatiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Dati> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CACHE_Dati", "idDati", true, "dato", true, "createDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Dati newDati = addDati();

		Dati existingDati = _persistence.fetchByPrimaryKey(
			newDati.getPrimaryKey());

		Assert.assertEquals(existingDati, newDati);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Dati missingDati = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDati);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Dati newDati1 = addDati();
		Dati newDati2 = addDati();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDati1.getPrimaryKey());
		primaryKeys.add(newDati2.getPrimaryKey());

		Map<Serializable, Dati> datis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, datis.size());
		Assert.assertEquals(newDati1, datis.get(newDati1.getPrimaryKey()));
		Assert.assertEquals(newDati2, datis.get(newDati2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Dati> datis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(datis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Dati newDati = addDati();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDati.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Dati> datis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, datis.size());
		Assert.assertEquals(newDati, datis.get(newDati.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Dati> datis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(datis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Dati newDati = addDati();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDati.getPrimaryKey());

		Map<Serializable, Dati> datis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, datis.size());
		Assert.assertEquals(newDati, datis.get(newDati.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Dati newDati = addDati();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dati.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("idDati", newDati.getIdDati()));

		List<Dati> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Dati existingDati = result.get(0);

		Assert.assertEquals(existingDati, newDati);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dati.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"idDati", RandomTestUtil.randomString()));

		List<Dati> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Dati newDati = addDati();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dati.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("idDati"));

		Object newIdDati = newDati.getIdDati();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("idDati", new Object[] {newIdDati}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingIdDati = result.get(0);

		Assert.assertEquals(existingIdDati, newIdDati);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dati.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("idDati"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"idDati", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Dati addDati() throws Exception {
		String pk = RandomTestUtil.randomString();

		Dati dati = _persistence.create(pk);

		dati.setDato(RandomTestUtil.randomString());

		dati.setCreateDate(RandomTestUtil.nextDate());

		_datis.add(_persistence.update(dati));

		return dati;
	}

	private List<Dati> _datis = new ArrayList<Dati>();
	private DatiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}