/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.test;

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

import it.eng.allerte.exception.NoSuchRubricaLogException;
import it.eng.allerte.model.RubricaLog;
import it.eng.allerte.service.RubricaLogLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaLogPersistence;
import it.eng.allerte.service.persistence.RubricaLogUtil;

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
public class RubricaLogPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaLogUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaLog> iterator = _rubricaLogs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaLog rubricaLog = _persistence.create(pk);

		Assert.assertNotNull(rubricaLog);

		Assert.assertEquals(rubricaLog.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaLog newRubricaLog = addRubricaLog();

		_persistence.remove(newRubricaLog);

		RubricaLog existingRubricaLog = _persistence.fetchByPrimaryKey(
			newRubricaLog.getPrimaryKey());

		Assert.assertNull(existingRubricaLog);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaLog();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaLog newRubricaLog = _persistence.create(pk);

		newRubricaLog.setFK_SITO_PROPRIETARIO(RandomTestUtil.nextLong());

		newRubricaLog.setTABELLA(RandomTestUtil.randomString());

		newRubricaLog.setTIPO_OPERAZIONE(RandomTestUtil.randomString());

		newRubricaLog.setID_OGGETTO(RandomTestUtil.randomString());

		newRubricaLog.setNUOVA_DESCRIZIONE(RandomTestUtil.randomString());

		newRubricaLog.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		newRubricaLog.setDATA_MODIFICA(RandomTestUtil.nextDate());

		_rubricaLogs.add(_persistence.update(newRubricaLog));

		RubricaLog existingRubricaLog = _persistence.findByPrimaryKey(
			newRubricaLog.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaLog.getID_LOG(), newRubricaLog.getID_LOG());
		Assert.assertEquals(
			existingRubricaLog.getFK_SITO_PROPRIETARIO(),
			newRubricaLog.getFK_SITO_PROPRIETARIO());
		Assert.assertEquals(
			existingRubricaLog.getTABELLA(), newRubricaLog.getTABELLA());
		Assert.assertEquals(
			existingRubricaLog.getTIPO_OPERAZIONE(),
			newRubricaLog.getTIPO_OPERAZIONE());
		Assert.assertEquals(
			existingRubricaLog.getID_OGGETTO(), newRubricaLog.getID_OGGETTO());
		Assert.assertEquals(
			existingRubricaLog.getNUOVA_DESCRIZIONE(),
			newRubricaLog.getNUOVA_DESCRIZIONE());
		Assert.assertEquals(
			existingRubricaLog.getFK_UTENTE_MODIFICA(),
			newRubricaLog.getFK_UTENTE_MODIFICA());
		Assert.assertEquals(
			Time.getShortTimestamp(existingRubricaLog.getDATA_MODIFICA()),
			Time.getShortTimestamp(newRubricaLog.getDATA_MODIFICA()));
	}

	@Test
	public void testCountByRubricaLogUtenteModifica() throws Exception {
		_persistence.countByRubricaLogUtenteModifica(RandomTestUtil.nextLong());

		_persistence.countByRubricaLogUtenteModifica(0L);
	}

	@Test
	public void testCountByRubricaLogDataModifica() throws Exception {
		_persistence.countByRubricaLogDataModifica(
			RandomTestUtil.nextDate(), RandomTestUtil.nextLong());

		_persistence.countByRubricaLogDataModifica(
			RandomTestUtil.nextDate(), 0L);
	}

	@Test
	public void testCountByRubricaLogTabella() throws Exception {
		_persistence.countByRubricaLogTabella("", RandomTestUtil.nextLong());

		_persistence.countByRubricaLogTabella("null", 0L);

		_persistence.countByRubricaLogTabella((String)null, 0L);
	}

	@Test
	public void testCountByRubricaLogIdOggetto() throws Exception {
		_persistence.countByRubricaLogIdOggetto("", RandomTestUtil.nextLong());

		_persistence.countByRubricaLogIdOggetto("null", 0L);

		_persistence.countByRubricaLogIdOggetto((String)null, 0L);
	}

	@Test
	public void testCountByRubricaLogBySitoProprietario() throws Exception {
		_persistence.countByRubricaLogBySitoProprietario(
			RandomTestUtil.nextLong());

		_persistence.countByRubricaLogBySitoProprietario(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaLog newRubricaLog = addRubricaLog();

		RubricaLog existingRubricaLog = _persistence.findByPrimaryKey(
			newRubricaLog.getPrimaryKey());

		Assert.assertEquals(existingRubricaLog, newRubricaLog);
	}

	@Test(expected = NoSuchRubricaLogException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaLog> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaLog", "ID_LOG", true, "FK_SITO_PROPRIETARIO", true,
			"TABELLA", true, "TIPO_OPERAZIONE", true, "ID_OGGETTO", true,
			"NUOVA_DESCRIZIONE", true, "FK_UTENTE_MODIFICA", true,
			"DATA_MODIFICA", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaLog newRubricaLog = addRubricaLog();

		RubricaLog existingRubricaLog = _persistence.fetchByPrimaryKey(
			newRubricaLog.getPrimaryKey());

		Assert.assertEquals(existingRubricaLog, newRubricaLog);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaLog missingRubricaLog = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaLog);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaLog newRubricaLog1 = addRubricaLog();
		RubricaLog newRubricaLog2 = addRubricaLog();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaLog1.getPrimaryKey());
		primaryKeys.add(newRubricaLog2.getPrimaryKey());

		Map<Serializable, RubricaLog> rubricaLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaLogs.size());
		Assert.assertEquals(
			newRubricaLog1, rubricaLogs.get(newRubricaLog1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaLog2, rubricaLogs.get(newRubricaLog2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaLog> rubricaLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaLogs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaLog newRubricaLog = addRubricaLog();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaLog.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaLog> rubricaLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaLogs.size());
		Assert.assertEquals(
			newRubricaLog, rubricaLogs.get(newRubricaLog.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaLog> rubricaLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaLogs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaLog newRubricaLog = addRubricaLog();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaLog.getPrimaryKey());

		Map<Serializable, RubricaLog> rubricaLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaLogs.size());
		Assert.assertEquals(
			newRubricaLog, rubricaLogs.get(newRubricaLog.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaLogLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaLog>() {

				@Override
				public void performAction(RubricaLog rubricaLog) {
					Assert.assertNotNull(rubricaLog);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaLog newRubricaLog = addRubricaLog();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaLog.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_LOG", newRubricaLog.getID_LOG()));

		List<RubricaLog> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaLog existingRubricaLog = result.get(0);

		Assert.assertEquals(existingRubricaLog, newRubricaLog);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaLog.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_LOG", RandomTestUtil.nextLong()));

		List<RubricaLog> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaLog newRubricaLog = addRubricaLog();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaLog.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_LOG"));

		Object newID_LOG = newRubricaLog.getID_LOG();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ID_LOG", new Object[] {newID_LOG}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_LOG = result.get(0);

		Assert.assertEquals(existingID_LOG, newID_LOG);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaLog.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_LOG"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_LOG", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaLog addRubricaLog() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaLog rubricaLog = _persistence.create(pk);

		rubricaLog.setFK_SITO_PROPRIETARIO(RandomTestUtil.nextLong());

		rubricaLog.setTABELLA(RandomTestUtil.randomString());

		rubricaLog.setTIPO_OPERAZIONE(RandomTestUtil.randomString());

		rubricaLog.setID_OGGETTO(RandomTestUtil.randomString());

		rubricaLog.setNUOVA_DESCRIZIONE(RandomTestUtil.randomString());

		rubricaLog.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		rubricaLog.setDATA_MODIFICA(RandomTestUtil.nextDate());

		_rubricaLogs.add(_persistence.update(rubricaLog));

		return rubricaLog;
	}

	private List<RubricaLog> _rubricaLogs = new ArrayList<RubricaLog>();
	private RubricaLogPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}