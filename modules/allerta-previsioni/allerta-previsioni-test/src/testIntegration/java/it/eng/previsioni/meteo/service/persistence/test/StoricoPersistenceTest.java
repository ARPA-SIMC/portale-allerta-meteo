/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.persistence.test;

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

import it.eng.previsioni.meteo.exception.NoSuchStoricoException;
import it.eng.previsioni.meteo.model.Storico;
import it.eng.previsioni.meteo.service.StoricoLocalServiceUtil;
import it.eng.previsioni.meteo.service.persistence.StoricoPersistence;
import it.eng.previsioni.meteo.service.persistence.StoricoUtil;

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
public class StoricoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.previsioni.meteo.service"));

	@Before
	public void setUp() {
		_persistence = StoricoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Storico> iterator = _storicos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Storico storico = _persistence.create(pk);

		Assert.assertNotNull(storico);

		Assert.assertEquals(storico.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Storico newStorico = addStorico();

		_persistence.remove(newStorico);

		Storico existingStorico = _persistence.fetchByPrimaryKey(
			newStorico.getPrimaryKey());

		Assert.assertNull(existingStorico);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStorico();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Storico newStorico = _persistence.create(pk);

		newStorico.setIdZona(RandomTestUtil.nextInt());

		newStorico.setNome(RandomTestUtil.randomString());

		newStorico.setSigla(RandomTestUtil.randomString());

		newStorico.setTipo(RandomTestUtil.randomString());

		newStorico.setXml(RandomTestUtil.randomString());

		_storicos.add(_persistence.update(newStorico));

		Storico existingStorico = _persistence.findByPrimaryKey(
			newStorico.getPrimaryKey());

		Assert.assertEquals(existingStorico.getId(), newStorico.getId());
		Assert.assertEquals(
			existingStorico.getIdZona(), newStorico.getIdZona());
		Assert.assertEquals(existingStorico.getNome(), newStorico.getNome());
		Assert.assertEquals(existingStorico.getSigla(), newStorico.getSigla());
		Assert.assertEquals(existingStorico.getTipo(), newStorico.getTipo());
		Assert.assertEquals(existingStorico.getXml(), newStorico.getXml());
	}

	@Test
	public void testCountBySigla() throws Exception {
		_persistence.countBySigla("");

		_persistence.countBySigla("null");

		_persistence.countBySigla((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Storico newStorico = addStorico();

		Storico existingStorico = _persistence.findByPrimaryKey(
			newStorico.getPrimaryKey());

		Assert.assertEquals(existingStorico, newStorico);
	}

	@Test(expected = NoSuchStoricoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Storico> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"prev_meteo_Storico", "id", true, "idZona", true, "nome", true,
			"sigla", true, "tipo", true, "xml", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Storico newStorico = addStorico();

		Storico existingStorico = _persistence.fetchByPrimaryKey(
			newStorico.getPrimaryKey());

		Assert.assertEquals(existingStorico, newStorico);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Storico missingStorico = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStorico);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Storico newStorico1 = addStorico();
		Storico newStorico2 = addStorico();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStorico1.getPrimaryKey());
		primaryKeys.add(newStorico2.getPrimaryKey());

		Map<Serializable, Storico> storicos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, storicos.size());
		Assert.assertEquals(
			newStorico1, storicos.get(newStorico1.getPrimaryKey()));
		Assert.assertEquals(
			newStorico2, storicos.get(newStorico2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Storico> storicos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(storicos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Storico newStorico = addStorico();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStorico.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Storico> storicos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, storicos.size());
		Assert.assertEquals(
			newStorico, storicos.get(newStorico.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Storico> storicos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(storicos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Storico newStorico = addStorico();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStorico.getPrimaryKey());

		Map<Serializable, Storico> storicos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, storicos.size());
		Assert.assertEquals(
			newStorico, storicos.get(newStorico.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StoricoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Storico>() {

				@Override
				public void performAction(Storico storico) {
					Assert.assertNotNull(storico);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Storico newStorico = addStorico();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Storico.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newStorico.getId()));

		List<Storico> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Storico existingStorico = result.get(0);

		Assert.assertEquals(existingStorico, newStorico);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Storico.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Storico> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Storico newStorico = addStorico();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Storico.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newStorico.getId();

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
			Storico.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Storico addStorico() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Storico storico = _persistence.create(pk);

		storico.setIdZona(RandomTestUtil.nextInt());

		storico.setNome(RandomTestUtil.randomString());

		storico.setSigla(RandomTestUtil.randomString());

		storico.setTipo(RandomTestUtil.randomString());

		storico.setXml(RandomTestUtil.randomString());

		_storicos.add(_persistence.update(storico));

		return storico;
	}

	private List<Storico> _storicos = new ArrayList<Storico>();
	private StoricoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}