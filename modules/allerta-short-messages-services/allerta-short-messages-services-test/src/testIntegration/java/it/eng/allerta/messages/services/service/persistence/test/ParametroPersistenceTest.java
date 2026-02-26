/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.test;

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

import it.eng.allerta.messages.services.exception.NoSuchParametroException;
import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.service.ParametroLocalServiceUtil;
import it.eng.allerta.messages.services.service.persistence.ParametroPersistence;
import it.eng.allerta.messages.services.service.persistence.ParametroUtil;

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
public class ParametroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"it.eng.allerta.messages.services.service"));

	@Before
	public void setUp() {
		_persistence = ParametroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Parametro> iterator = _parametros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parametro parametro = _persistence.create(pk);

		Assert.assertNotNull(parametro);

		Assert.assertEquals(parametro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Parametro newParametro = addParametro();

		_persistence.remove(newParametro);

		Parametro existingParametro = _persistence.fetchByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertNull(existingParametro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addParametro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parametro newParametro = _persistence.create(pk);

		newParametro.setIp(RandomTestUtil.randomString());

		newParametro.setPorta(RandomTestUtil.nextInt());

		newParametro.setUsername(RandomTestUtil.randomString());

		newParametro.setPassword(RandomTestUtil.randomString());

		newParametro.setMittente(RandomTestUtil.randomString());

		newParametro.setNodo(RandomTestUtil.randomString());

		newParametro.setDataConnessione(RandomTestUtil.nextDate());

		_parametros.add(_persistence.update(newParametro));

		Parametro existingParametro = _persistence.findByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertEquals(existingParametro.getId(), newParametro.getId());
		Assert.assertEquals(existingParametro.getIp(), newParametro.getIp());
		Assert.assertEquals(
			existingParametro.getPorta(), newParametro.getPorta());
		Assert.assertEquals(
			existingParametro.getUsername(), newParametro.getUsername());
		Assert.assertEquals(
			existingParametro.getPassword(), newParametro.getPassword());
		Assert.assertEquals(
			existingParametro.getMittente(), newParametro.getMittente());
		Assert.assertEquals(
			existingParametro.getNodo(), newParametro.getNodo());
		Assert.assertEquals(
			Time.getShortTimestamp(existingParametro.getDataConnessione()),
			Time.getShortTimestamp(newParametro.getDataConnessione()));
	}

	@Test
	public void testCountBynodo() throws Exception {
		_persistence.countBynodo("");

		_persistence.countBynodo("null");

		_persistence.countBynodo((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Parametro newParametro = addParametro();

		Parametro existingParametro = _persistence.findByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertEquals(existingParametro, newParametro);
	}

	@Test(expected = NoSuchParametroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Parametro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"smsService_Parametro", "Id", true, "ip", true, "porta", true,
			"username", true, "password", true, "mittente", true, "nodo", true,
			"dataConnessione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Parametro newParametro = addParametro();

		Parametro existingParametro = _persistence.fetchByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertEquals(existingParametro, newParametro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parametro missingParametro = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingParametro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Parametro newParametro1 = addParametro();
		Parametro newParametro2 = addParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametro1.getPrimaryKey());
		primaryKeys.add(newParametro2.getPrimaryKey());

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, parametros.size());
		Assert.assertEquals(
			newParametro1, parametros.get(newParametro1.getPrimaryKey()));
		Assert.assertEquals(
			newParametro2, parametros.get(newParametro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Parametro newParametro = addParametro();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parametros.size());
		Assert.assertEquals(
			newParametro, parametros.get(newParametro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Parametro newParametro = addParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametro.getPrimaryKey());

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parametros.size());
		Assert.assertEquals(
			newParametro, parametros.get(newParametro.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ParametroLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Parametro>() {

				@Override
				public void performAction(Parametro parametro) {
					Assert.assertNotNull(parametro);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Parametro newParametro = addParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", newParametro.getId()));

		List<Parametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Parametro existingParametro = result.get(0);

		Assert.assertEquals(existingParametro, newParametro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<Parametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Parametro newParametro = addParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newParametro.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("Id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Parametro addParametro() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parametro parametro = _persistence.create(pk);

		parametro.setIp(RandomTestUtil.randomString());

		parametro.setPorta(RandomTestUtil.nextInt());

		parametro.setUsername(RandomTestUtil.randomString());

		parametro.setPassword(RandomTestUtil.randomString());

		parametro.setMittente(RandomTestUtil.randomString());

		parametro.setNodo(RandomTestUtil.randomString());

		parametro.setDataConnessione(RandomTestUtil.nextDate());

		_parametros.add(_persistence.update(parametro));

		return parametro;
	}

	private List<Parametro> _parametros = new ArrayList<Parametro>();
	private ParametroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}