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

import it.eng.bollettino.exception.NoSuchBollettinoSensoreException;
import it.eng.bollettino.model.BollettinoSensore;
import it.eng.bollettino.service.BollettinoSensoreLocalServiceUtil;
import it.eng.bollettino.service.persistence.BollettinoSensorePersistence;
import it.eng.bollettino.service.persistence.BollettinoSensoreUtil;

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
public class BollettinoSensorePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = BollettinoSensoreUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BollettinoSensore> iterator = _bollettinoSensores.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoSensore bollettinoSensore = _persistence.create(pk);

		Assert.assertNotNull(bollettinoSensore);

		Assert.assertEquals(bollettinoSensore.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		_persistence.remove(newBollettinoSensore);

		BollettinoSensore existingBollettinoSensore =
			_persistence.fetchByPrimaryKey(
				newBollettinoSensore.getPrimaryKey());

		Assert.assertNull(existingBollettinoSensore);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBollettinoSensore();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoSensore newBollettinoSensore = _persistence.create(pk);

		newBollettinoSensore.setUuid(RandomTestUtil.randomString());

		newBollettinoSensore.setIdBollettino(RandomTestUtil.nextLong());

		newBollettinoSensore.setIdStazione(RandomTestUtil.nextLong());

		newBollettinoSensore.setIdBollettinoBacino(RandomTestUtil.nextLong());

		newBollettinoSensore.setProgressivo(RandomTestUtil.nextInt());

		newBollettinoSensore.setNomeStazione(RandomTestUtil.randomString());

		newBollettinoSensore.setOreOsservazione(RandomTestUtil.randomString());

		newBollettinoSensore.setOsservazione(RandomTestUtil.nextDouble());

		newBollettinoSensore.setTendenza(RandomTestUtil.nextInt());

		newBollettinoSensore.setColmoPrevisto(RandomTestUtil.randomString());

		newBollettinoSensore.setOraPrevista(RandomTestUtil.randomString());

		newBollettinoSensore.setSoglia1(RandomTestUtil.nextDouble());

		newBollettinoSensore.setSoglia2(RandomTestUtil.nextDouble());

		newBollettinoSensore.setSoglia3(RandomTestUtil.nextDouble());

		newBollettinoSensore.setGiornoPrevisto(RandomTestUtil.randomString());

		newBollettinoSensore.setOsservato(RandomTestUtil.randomBoolean());

		_bollettinoSensores.add(_persistence.update(newBollettinoSensore));

		BollettinoSensore existingBollettinoSensore =
			_persistence.findByPrimaryKey(newBollettinoSensore.getPrimaryKey());

		Assert.assertEquals(
			existingBollettinoSensore.getUuid(),
			newBollettinoSensore.getUuid());
		Assert.assertEquals(
			existingBollettinoSensore.getId(), newBollettinoSensore.getId());
		Assert.assertEquals(
			existingBollettinoSensore.getIdBollettino(),
			newBollettinoSensore.getIdBollettino());
		Assert.assertEquals(
			existingBollettinoSensore.getIdStazione(),
			newBollettinoSensore.getIdStazione());
		Assert.assertEquals(
			existingBollettinoSensore.getIdBollettinoBacino(),
			newBollettinoSensore.getIdBollettinoBacino());
		Assert.assertEquals(
			existingBollettinoSensore.getProgressivo(),
			newBollettinoSensore.getProgressivo());
		Assert.assertEquals(
			existingBollettinoSensore.getNomeStazione(),
			newBollettinoSensore.getNomeStazione());
		Assert.assertEquals(
			existingBollettinoSensore.getOreOsservazione(),
			newBollettinoSensore.getOreOsservazione());
		AssertUtils.assertEquals(
			existingBollettinoSensore.getOsservazione(),
			newBollettinoSensore.getOsservazione());
		Assert.assertEquals(
			existingBollettinoSensore.getTendenza(),
			newBollettinoSensore.getTendenza());
		Assert.assertEquals(
			existingBollettinoSensore.getColmoPrevisto(),
			newBollettinoSensore.getColmoPrevisto());
		Assert.assertEquals(
			existingBollettinoSensore.getOraPrevista(),
			newBollettinoSensore.getOraPrevista());
		AssertUtils.assertEquals(
			existingBollettinoSensore.getSoglia1(),
			newBollettinoSensore.getSoglia1());
		AssertUtils.assertEquals(
			existingBollettinoSensore.getSoglia2(),
			newBollettinoSensore.getSoglia2());
		AssertUtils.assertEquals(
			existingBollettinoSensore.getSoglia3(),
			newBollettinoSensore.getSoglia3());
		Assert.assertEquals(
			existingBollettinoSensore.getGiornoPrevisto(),
			newBollettinoSensore.getGiornoPrevisto());
		Assert.assertEquals(
			existingBollettinoSensore.isOsservato(),
			newBollettinoSensore.isOsservato());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByBollettino() throws Exception {
		_persistence.countByBollettino(RandomTestUtil.nextLong());

		_persistence.countByBollettino(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		BollettinoSensore existingBollettinoSensore =
			_persistence.findByPrimaryKey(newBollettinoSensore.getPrimaryKey());

		Assert.assertEquals(existingBollettinoSensore, newBollettinoSensore);
	}

	@Test(expected = NoSuchBollettinoSensoreException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BollettinoSensore> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_BollettinoSensore", "uuid", true, "id", true,
			"idBollettino", true, "idStazione", true, "idBollettinoBacino",
			true, "progressivo", true, "nomeStazione", true, "oreOsservazione",
			true, "osservazione", true, "tendenza", true, "colmoPrevisto", true,
			"oraPrevista", true, "soglia1", true, "soglia2", true, "soglia3",
			true, "giornoPrevisto", true, "osservato", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		BollettinoSensore existingBollettinoSensore =
			_persistence.fetchByPrimaryKey(
				newBollettinoSensore.getPrimaryKey());

		Assert.assertEquals(existingBollettinoSensore, newBollettinoSensore);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoSensore missingBollettinoSensore =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBollettinoSensore);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BollettinoSensore newBollettinoSensore1 = addBollettinoSensore();
		BollettinoSensore newBollettinoSensore2 = addBollettinoSensore();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoSensore1.getPrimaryKey());
		primaryKeys.add(newBollettinoSensore2.getPrimaryKey());

		Map<Serializable, BollettinoSensore> bollettinoSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bollettinoSensores.size());
		Assert.assertEquals(
			newBollettinoSensore1,
			bollettinoSensores.get(newBollettinoSensore1.getPrimaryKey()));
		Assert.assertEquals(
			newBollettinoSensore2,
			bollettinoSensores.get(newBollettinoSensore2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BollettinoSensore> bollettinoSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoSensores.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoSensore.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BollettinoSensore> bollettinoSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoSensores.size());
		Assert.assertEquals(
			newBollettinoSensore,
			bollettinoSensores.get(newBollettinoSensore.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BollettinoSensore> bollettinoSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoSensores.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoSensore.getPrimaryKey());

		Map<Serializable, BollettinoSensore> bollettinoSensores =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoSensores.size());
		Assert.assertEquals(
			newBollettinoSensore,
			bollettinoSensores.get(newBollettinoSensore.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BollettinoSensoreLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<BollettinoSensore>() {

				@Override
				public void performAction(BollettinoSensore bollettinoSensore) {
					Assert.assertNotNull(bollettinoSensore);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newBollettinoSensore.getId()));

		List<BollettinoSensore> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BollettinoSensore existingBollettinoSensore = result.get(0);

		Assert.assertEquals(existingBollettinoSensore, newBollettinoSensore);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<BollettinoSensore> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BollettinoSensore newBollettinoSensore = addBollettinoSensore();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newBollettinoSensore.getId();

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
			BollettinoSensore.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected BollettinoSensore addBollettinoSensore() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BollettinoSensore bollettinoSensore = _persistence.create(pk);

		bollettinoSensore.setUuid(RandomTestUtil.randomString());

		bollettinoSensore.setIdBollettino(RandomTestUtil.nextLong());

		bollettinoSensore.setIdStazione(RandomTestUtil.nextLong());

		bollettinoSensore.setIdBollettinoBacino(RandomTestUtil.nextLong());

		bollettinoSensore.setProgressivo(RandomTestUtil.nextInt());

		bollettinoSensore.setNomeStazione(RandomTestUtil.randomString());

		bollettinoSensore.setOreOsservazione(RandomTestUtil.randomString());

		bollettinoSensore.setOsservazione(RandomTestUtil.nextDouble());

		bollettinoSensore.setTendenza(RandomTestUtil.nextInt());

		bollettinoSensore.setColmoPrevisto(RandomTestUtil.randomString());

		bollettinoSensore.setOraPrevista(RandomTestUtil.randomString());

		bollettinoSensore.setSoglia1(RandomTestUtil.nextDouble());

		bollettinoSensore.setSoglia2(RandomTestUtil.nextDouble());

		bollettinoSensore.setSoglia3(RandomTestUtil.nextDouble());

		bollettinoSensore.setGiornoPrevisto(RandomTestUtil.randomString());

		bollettinoSensore.setOsservato(RandomTestUtil.randomBoolean());

		_bollettinoSensores.add(_persistence.update(bollettinoSensore));

		return bollettinoSensore;
	}

	private List<BollettinoSensore> _bollettinoSensores =
		new ArrayList<BollettinoSensore>();
	private BollettinoSensorePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}