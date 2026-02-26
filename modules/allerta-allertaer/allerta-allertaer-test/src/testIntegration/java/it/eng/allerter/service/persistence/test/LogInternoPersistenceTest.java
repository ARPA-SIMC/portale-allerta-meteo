/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.test;

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

import it.eng.allerter.exception.NoSuchLogInternoException;
import it.eng.allerter.model.LogInterno;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.persistence.LogInternoPersistence;
import it.eng.allerter.service.persistence.LogInternoUtil;

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
public class LogInternoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = LogInternoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<LogInterno> iterator = _logInternos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LogInterno logInterno = _persistence.create(pk);

		Assert.assertNotNull(logInterno);

		Assert.assertEquals(logInterno.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		LogInterno newLogInterno = addLogInterno();

		_persistence.remove(newLogInterno);

		LogInterno existingLogInterno = _persistence.fetchByPrimaryKey(
			newLogInterno.getPrimaryKey());

		Assert.assertNull(existingLogInterno);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLogInterno();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LogInterno newLogInterno = _persistence.create(pk);

		newLogInterno.setTimestamp(RandomTestUtil.nextDate());

		newLogInterno.setThread(RandomTestUtil.randomString());

		newLogInterno.setCosa(RandomTestUtil.randomString());

		newLogInterno.setDettaglio(RandomTestUtil.randomString());

		newLogInterno.setUtente(RandomTestUtil.randomString());

		newLogInterno.setRisultato(RandomTestUtil.randomString());

		newLogInterno.setEccezione(RandomTestUtil.randomString());

		_logInternos.add(_persistence.update(newLogInterno));

		LogInterno existingLogInterno = _persistence.findByPrimaryKey(
			newLogInterno.getPrimaryKey());

		Assert.assertEquals(
			existingLogInterno.getLogId(), newLogInterno.getLogId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLogInterno.getTimestamp()),
			Time.getShortTimestamp(newLogInterno.getTimestamp()));
		Assert.assertEquals(
			existingLogInterno.getThread(), newLogInterno.getThread());
		Assert.assertEquals(
			existingLogInterno.getCosa(), newLogInterno.getCosa());
		Assert.assertEquals(
			existingLogInterno.getDettaglio(), newLogInterno.getDettaglio());
		Assert.assertEquals(
			existingLogInterno.getUtente(), newLogInterno.getUtente());
		Assert.assertEquals(
			existingLogInterno.getRisultato(), newLogInterno.getRisultato());
		Assert.assertEquals(
			existingLogInterno.getEccezione(), newLogInterno.getEccezione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		LogInterno newLogInterno = addLogInterno();

		LogInterno existingLogInterno = _persistence.findByPrimaryKey(
			newLogInterno.getPrimaryKey());

		Assert.assertEquals(existingLogInterno, newLogInterno);
	}

	@Test(expected = NoSuchLogInternoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<LogInterno> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_LogInterno", "logId", true, "timestamp", true, "thread",
			true, "cosa", true, "dettaglio", true, "utente", true, "risultato",
			true, "eccezione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		LogInterno newLogInterno = addLogInterno();

		LogInterno existingLogInterno = _persistence.fetchByPrimaryKey(
			newLogInterno.getPrimaryKey());

		Assert.assertEquals(existingLogInterno, newLogInterno);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LogInterno missingLogInterno = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLogInterno);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		LogInterno newLogInterno1 = addLogInterno();
		LogInterno newLogInterno2 = addLogInterno();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLogInterno1.getPrimaryKey());
		primaryKeys.add(newLogInterno2.getPrimaryKey());

		Map<Serializable, LogInterno> logInternos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, logInternos.size());
		Assert.assertEquals(
			newLogInterno1, logInternos.get(newLogInterno1.getPrimaryKey()));
		Assert.assertEquals(
			newLogInterno2, logInternos.get(newLogInterno2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, LogInterno> logInternos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(logInternos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		LogInterno newLogInterno = addLogInterno();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLogInterno.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, LogInterno> logInternos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, logInternos.size());
		Assert.assertEquals(
			newLogInterno, logInternos.get(newLogInterno.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, LogInterno> logInternos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(logInternos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		LogInterno newLogInterno = addLogInterno();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLogInterno.getPrimaryKey());

		Map<Serializable, LogInterno> logInternos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, logInternos.size());
		Assert.assertEquals(
			newLogInterno, logInternos.get(newLogInterno.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LogInternoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<LogInterno>() {

				@Override
				public void performAction(LogInterno logInterno) {
					Assert.assertNotNull(logInterno);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		LogInterno newLogInterno = addLogInterno();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LogInterno.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("logId", newLogInterno.getLogId()));

		List<LogInterno> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		LogInterno existingLogInterno = result.get(0);

		Assert.assertEquals(existingLogInterno, newLogInterno);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LogInterno.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("logId", RandomTestUtil.nextLong()));

		List<LogInterno> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		LogInterno newLogInterno = addLogInterno();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LogInterno.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("logId"));

		Object newLogId = newLogInterno.getLogId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("logId", new Object[] {newLogId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLogId = result.get(0);

		Assert.assertEquals(existingLogId, newLogId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LogInterno.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("logId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"logId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected LogInterno addLogInterno() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LogInterno logInterno = _persistence.create(pk);

		logInterno.setTimestamp(RandomTestUtil.nextDate());

		logInterno.setThread(RandomTestUtil.randomString());

		logInterno.setCosa(RandomTestUtil.randomString());

		logInterno.setDettaglio(RandomTestUtil.randomString());

		logInterno.setUtente(RandomTestUtil.randomString());

		logInterno.setRisultato(RandomTestUtil.randomString());

		logInterno.setEccezione(RandomTestUtil.randomString());

		_logInternos.add(_persistence.update(logInterno));

		return logInterno;
	}

	private List<LogInterno> _logInternos = new ArrayList<LogInterno>();
	private LogInternoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}