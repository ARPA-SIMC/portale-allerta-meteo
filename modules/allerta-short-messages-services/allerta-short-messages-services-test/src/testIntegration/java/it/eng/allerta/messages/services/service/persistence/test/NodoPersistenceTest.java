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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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

import it.eng.allerta.messages.services.exception.NoSuchNodoException;
import it.eng.allerta.messages.services.model.Nodo;
import it.eng.allerta.messages.services.service.NodoLocalServiceUtil;
import it.eng.allerta.messages.services.service.persistence.NodoPersistence;
import it.eng.allerta.messages.services.service.persistence.NodoUtil;

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
public class NodoPersistenceTest {

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
		_persistence = NodoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Nodo> iterator = _nodos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Nodo nodo = _persistence.create(pk);

		Assert.assertNotNull(nodo);

		Assert.assertEquals(nodo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Nodo newNodo = addNodo();

		_persistence.remove(newNodo);

		Nodo existingNodo = _persistence.fetchByPrimaryKey(
			newNodo.getPrimaryKey());

		Assert.assertNull(existingNodo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNodo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Nodo newNodo = _persistence.create(pk);

		newNodo.setIp(RandomTestUtil.randomString());

		newNodo.setPorta(RandomTestUtil.nextInt());

		newNodo.setNodoConnesso(RandomTestUtil.randomString());

		newNodo.setDataConnessione(RandomTestUtil.nextDate());

		_nodos.add(_persistence.update(newNodo));

		Nodo existingNodo = _persistence.findByPrimaryKey(
			newNodo.getPrimaryKey());

		Assert.assertEquals(existingNodo.getId(), newNodo.getId());
		Assert.assertEquals(existingNodo.getIp(), newNodo.getIp());
		Assert.assertEquals(existingNodo.getPorta(), newNodo.getPorta());
		Assert.assertEquals(
			existingNodo.getNodoConnesso(), newNodo.getNodoConnesso());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNodo.getDataConnessione()),
			Time.getShortTimestamp(newNodo.getDataConnessione()));
	}

	@Test
	public void testCountBynodoConnesso() throws Exception {
		_persistence.countBynodoConnesso("");

		_persistence.countBynodoConnesso("null");

		_persistence.countBynodoConnesso((String)null);
	}

	@Test
	public void testCountByip() throws Exception {
		_persistence.countByip("");

		_persistence.countByip("null");

		_persistence.countByip((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Nodo newNodo = addNodo();

		Nodo existingNodo = _persistence.findByPrimaryKey(
			newNodo.getPrimaryKey());

		Assert.assertEquals(existingNodo, newNodo);
	}

	@Test(expected = NoSuchNodoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Nodo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"smsService_Nodo", "Id", true, "ip", true, "porta", true,
			"nodoConnesso", true, "dataConnessione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Nodo newNodo = addNodo();

		Nodo existingNodo = _persistence.fetchByPrimaryKey(
			newNodo.getPrimaryKey());

		Assert.assertEquals(existingNodo, newNodo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Nodo missingNodo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNodo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Nodo newNodo1 = addNodo();
		Nodo newNodo2 = addNodo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNodo1.getPrimaryKey());
		primaryKeys.add(newNodo2.getPrimaryKey());

		Map<Serializable, Nodo> nodos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, nodos.size());
		Assert.assertEquals(newNodo1, nodos.get(newNodo1.getPrimaryKey()));
		Assert.assertEquals(newNodo2, nodos.get(newNodo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Nodo> nodos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(nodos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Nodo newNodo = addNodo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNodo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Nodo> nodos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, nodos.size());
		Assert.assertEquals(newNodo, nodos.get(newNodo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Nodo> nodos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(nodos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Nodo newNodo = addNodo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNodo.getPrimaryKey());

		Map<Serializable, Nodo> nodos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, nodos.size());
		Assert.assertEquals(newNodo, nodos.get(newNodo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			NodoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Nodo>() {

				@Override
				public void performAction(Nodo nodo) {
					Assert.assertNotNull(nodo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Nodo newNodo = addNodo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Nodo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("Id", newNodo.getId()));

		List<Nodo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Nodo existingNodo = result.get(0);

		Assert.assertEquals(existingNodo, newNodo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Nodo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<Nodo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Nodo newNodo = addNodo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Nodo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newNodo.getId();

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
			Nodo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Nodo newNodo = addNodo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newNodo.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Nodo newNodo = addNodo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Nodo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("Id", newNodo.getId()));

		List<Nodo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Nodo nodo) {
		Assert.assertEquals(
			nodo.getNodoConnesso(),
			ReflectionTestUtil.invoke(
				nodo, "getColumnOriginalValue", new Class<?>[] {String.class},
				"nodoConnesso"));

		Assert.assertEquals(
			nodo.getIp(),
			ReflectionTestUtil.invoke(
				nodo, "getColumnOriginalValue", new Class<?>[] {String.class},
				"ip"));
	}

	protected Nodo addNodo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Nodo nodo = _persistence.create(pk);

		nodo.setIp(RandomTestUtil.randomString());

		nodo.setPorta(RandomTestUtil.nextInt());

		nodo.setNodoConnesso(RandomTestUtil.randomString());

		nodo.setDataConnessione(RandomTestUtil.nextDate());

		_nodos.add(_persistence.update(nodo));

		return nodo;
	}

	private List<Nodo> _nodos = new ArrayList<Nodo>();
	private NodoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}