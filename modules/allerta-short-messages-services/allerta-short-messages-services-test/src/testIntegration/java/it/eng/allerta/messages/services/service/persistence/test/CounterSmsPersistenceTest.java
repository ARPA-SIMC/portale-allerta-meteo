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

import it.eng.allerta.messages.services.exception.NoSuchCounterSmsException;
import it.eng.allerta.messages.services.model.CounterSms;
import it.eng.allerta.messages.services.service.CounterSmsLocalServiceUtil;
import it.eng.allerta.messages.services.service.persistence.CounterSmsPersistence;
import it.eng.allerta.messages.services.service.persistence.CounterSmsUtil;

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
public class CounterSmsPersistenceTest {

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
		_persistence = CounterSmsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CounterSms> iterator = _counterSmses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CounterSms counterSms = _persistence.create(pk);

		Assert.assertNotNull(counterSms);

		Assert.assertEquals(counterSms.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		_persistence.remove(newCounterSms);

		CounterSms existingCounterSms = _persistence.fetchByPrimaryKey(
			newCounterSms.getPrimaryKey());

		Assert.assertNull(existingCounterSms);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCounterSms();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CounterSms newCounterSms = _persistence.create(pk);

		newCounterSms.setDate(RandomTestUtil.nextDate());

		newCounterSms.setNumerosms(RandomTestUtil.nextInt());

		newCounterSms.setNodo(RandomTestUtil.randomString());

		_counterSmses.add(_persistence.update(newCounterSms));

		CounterSms existingCounterSms = _persistence.findByPrimaryKey(
			newCounterSms.getPrimaryKey());

		Assert.assertEquals(
			existingCounterSms.getCounterId(), newCounterSms.getCounterId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCounterSms.getDate()),
			Time.getShortTimestamp(newCounterSms.getDate()));
		Assert.assertEquals(
			existingCounterSms.getNumerosms(), newCounterSms.getNumerosms());
		Assert.assertEquals(
			existingCounterSms.getNodo(), newCounterSms.getNodo());
	}

	@Test
	public void testCountBydata() throws Exception {
		_persistence.countBydata(RandomTestUtil.nextDate());

		_persistence.countBydata(RandomTestUtil.nextDate());
	}

	@Test
	public void testCountBydataGreather() throws Exception {
		_persistence.countBydataGreather(RandomTestUtil.nextDate());

		_persistence.countBydataGreather(RandomTestUtil.nextDate());
	}

	@Test
	public void testCountBydataAndNodo() throws Exception {
		_persistence.countBydataAndNodo(RandomTestUtil.nextDate(), "");

		_persistence.countBydataAndNodo(RandomTestUtil.nextDate(), "null");

		_persistence.countBydataAndNodo(
			RandomTestUtil.nextDate(), (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		CounterSms existingCounterSms = _persistence.findByPrimaryKey(
			newCounterSms.getPrimaryKey());

		Assert.assertEquals(existingCounterSms, newCounterSms);
	}

	@Test(expected = NoSuchCounterSmsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CounterSms> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"smsService_CounterSms", "counterId", true, "date", true,
			"numerosms", true, "nodo", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		CounterSms existingCounterSms = _persistence.fetchByPrimaryKey(
			newCounterSms.getPrimaryKey());

		Assert.assertEquals(existingCounterSms, newCounterSms);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CounterSms missingCounterSms = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCounterSms);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CounterSms newCounterSms1 = addCounterSms();
		CounterSms newCounterSms2 = addCounterSms();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCounterSms1.getPrimaryKey());
		primaryKeys.add(newCounterSms2.getPrimaryKey());

		Map<Serializable, CounterSms> counterSmses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, counterSmses.size());
		Assert.assertEquals(
			newCounterSms1, counterSmses.get(newCounterSms1.getPrimaryKey()));
		Assert.assertEquals(
			newCounterSms2, counterSmses.get(newCounterSms2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CounterSms> counterSmses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(counterSmses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CounterSms newCounterSms = addCounterSms();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCounterSms.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CounterSms> counterSmses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, counterSmses.size());
		Assert.assertEquals(
			newCounterSms, counterSmses.get(newCounterSms.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CounterSms> counterSmses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(counterSmses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCounterSms.getPrimaryKey());

		Map<Serializable, CounterSms> counterSmses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, counterSmses.size());
		Assert.assertEquals(
			newCounterSms, counterSmses.get(newCounterSms.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CounterSmsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CounterSms>() {

				@Override
				public void performAction(CounterSms counterSms) {
					Assert.assertNotNull(counterSms);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CounterSms.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"counterId", newCounterSms.getCounterId()));

		List<CounterSms> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CounterSms existingCounterSms = result.get(0);

		Assert.assertEquals(existingCounterSms, newCounterSms);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CounterSms.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("counterId", RandomTestUtil.nextLong()));

		List<CounterSms> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CounterSms.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("counterId"));

		Object newCounterId = newCounterSms.getCounterId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"counterId", new Object[] {newCounterId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCounterId = result.get(0);

		Assert.assertEquals(existingCounterId, newCounterId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CounterSms.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("counterId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"counterId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CounterSms newCounterSms = addCounterSms();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCounterSms.getPrimaryKey()));
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

		CounterSms newCounterSms = addCounterSms();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CounterSms.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"counterId", newCounterSms.getCounterId()));

		List<CounterSms> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CounterSms counterSms) {
		Assert.assertEquals(
			counterSms.getDate(),
			ReflectionTestUtil.invoke(
				counterSms, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "date_"));
	}

	protected CounterSms addCounterSms() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CounterSms counterSms = _persistence.create(pk);

		counterSms.setDate(RandomTestUtil.nextDate());

		counterSms.setNumerosms(RandomTestUtil.nextInt());

		counterSms.setNodo(RandomTestUtil.randomString());

		_counterSmses.add(_persistence.update(counterSms));

		return counterSms;
	}

	private List<CounterSms> _counterSmses = new ArrayList<CounterSms>();
	private CounterSmsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}