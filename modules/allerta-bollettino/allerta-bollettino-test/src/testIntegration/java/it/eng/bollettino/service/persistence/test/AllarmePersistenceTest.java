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

import it.eng.bollettino.exception.NoSuchAllarmeException;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.service.AllarmeLocalServiceUtil;
import it.eng.bollettino.service.persistence.AllarmePersistence;
import it.eng.bollettino.service.persistence.AllarmeUtil;

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
public class AllarmePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = AllarmeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Allarme> iterator = _allarmes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allarme allarme = _persistence.create(pk);

		Assert.assertNotNull(allarme);

		Assert.assertEquals(allarme.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Allarme newAllarme = addAllarme();

		_persistence.remove(newAllarme);

		Allarme existingAllarme = _persistence.fetchByPrimaryKey(
			newAllarme.getPrimaryKey());

		Assert.assertNull(existingAllarme);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAllarme();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allarme newAllarme = _persistence.create(pk);

		newAllarme.setUuid(RandomTestUtil.randomString());

		newAllarme.setGroupId(RandomTestUtil.nextLong());

		newAllarme.setCompanyId(RandomTestUtil.nextLong());

		newAllarme.setUserId(RandomTestUtil.nextLong());

		newAllarme.setUserName(RandomTestUtil.randomString());

		newAllarme.setCreateDate(RandomTestUtil.nextDate());

		newAllarme.setModifiedDate(RandomTestUtil.nextDate());

		newAllarme.setStato(RandomTestUtil.nextInt());

		newAllarme.setIdApprovatore(RandomTestUtil.nextLong());

		newAllarme.setDataApprovazione(RandomTestUtil.nextDate());

		newAllarme.setIdRegola(RandomTestUtil.nextLong());

		newAllarme.setColore(RandomTestUtil.nextInt());

		newAllarme.setDataInizio(RandomTestUtil.nextDate());

		newAllarme.setDataFine(RandomTestUtil.nextDate());

		_allarmes.add(_persistence.update(newAllarme));

		Allarme existingAllarme = _persistence.findByPrimaryKey(
			newAllarme.getPrimaryKey());

		Assert.assertEquals(existingAllarme.getUuid(), newAllarme.getUuid());
		Assert.assertEquals(
			existingAllarme.getAllarmeId(), newAllarme.getAllarmeId());
		Assert.assertEquals(
			existingAllarme.getGroupId(), newAllarme.getGroupId());
		Assert.assertEquals(
			existingAllarme.getCompanyId(), newAllarme.getCompanyId());
		Assert.assertEquals(
			existingAllarme.getUserId(), newAllarme.getUserId());
		Assert.assertEquals(
			existingAllarme.getUserName(), newAllarme.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllarme.getCreateDate()),
			Time.getShortTimestamp(newAllarme.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllarme.getModifiedDate()),
			Time.getShortTimestamp(newAllarme.getModifiedDate()));
		Assert.assertEquals(existingAllarme.getStato(), newAllarme.getStato());
		Assert.assertEquals(
			existingAllarme.getIdApprovatore(), newAllarme.getIdApprovatore());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllarme.getDataApprovazione()),
			Time.getShortTimestamp(newAllarme.getDataApprovazione()));
		Assert.assertEquals(
			existingAllarme.getIdRegola(), newAllarme.getIdRegola());
		Assert.assertEquals(
			existingAllarme.getColore(), newAllarme.getColore());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllarme.getDataInizio()),
			Time.getShortTimestamp(newAllarme.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllarme.getDataFine()),
			Time.getShortTimestamp(newAllarme.getDataFine()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByRegola() throws Exception {
		_persistence.countByRegola(RandomTestUtil.nextLong());

		_persistence.countByRegola(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Allarme newAllarme = addAllarme();

		Allarme existingAllarme = _persistence.findByPrimaryKey(
			newAllarme.getPrimaryKey());

		Assert.assertEquals(existingAllarme, newAllarme);
	}

	@Test(expected = NoSuchAllarmeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Allarme> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Allarme", "uuid", true, "allarmeId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "stato", true,
			"idApprovatore", true, "dataApprovazione", true, "idRegola", true,
			"colore", true, "dataInizio", true, "dataFine", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Allarme newAllarme = addAllarme();

		Allarme existingAllarme = _persistence.fetchByPrimaryKey(
			newAllarme.getPrimaryKey());

		Assert.assertEquals(existingAllarme, newAllarme);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allarme missingAllarme = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAllarme);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Allarme newAllarme1 = addAllarme();
		Allarme newAllarme2 = addAllarme();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllarme1.getPrimaryKey());
		primaryKeys.add(newAllarme2.getPrimaryKey());

		Map<Serializable, Allarme> allarmes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, allarmes.size());
		Assert.assertEquals(
			newAllarme1, allarmes.get(newAllarme1.getPrimaryKey()));
		Assert.assertEquals(
			newAllarme2, allarmes.get(newAllarme2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Allarme> allarmes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(allarmes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Allarme newAllarme = addAllarme();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllarme.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Allarme> allarmes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, allarmes.size());
		Assert.assertEquals(
			newAllarme, allarmes.get(newAllarme.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Allarme> allarmes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(allarmes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Allarme newAllarme = addAllarme();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllarme.getPrimaryKey());

		Map<Serializable, Allarme> allarmes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, allarmes.size());
		Assert.assertEquals(
			newAllarme, allarmes.get(newAllarme.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AllarmeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Allarme>() {

				@Override
				public void performAction(Allarme allarme) {
					Assert.assertNotNull(allarme);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Allarme newAllarme = addAllarme();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allarme.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("allarmeId", newAllarme.getAllarmeId()));

		List<Allarme> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Allarme existingAllarme = result.get(0);

		Assert.assertEquals(existingAllarme, newAllarme);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allarme.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("allarmeId", RandomTestUtil.nextLong()));

		List<Allarme> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Allarme newAllarme = addAllarme();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allarme.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("allarmeId"));

		Object newAllarmeId = newAllarme.getAllarmeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allarmeId", new Object[] {newAllarmeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAllarmeId = result.get(0);

		Assert.assertEquals(existingAllarmeId, newAllarmeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allarme.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("allarmeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allarmeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Allarme newAllarme = addAllarme();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAllarme.getPrimaryKey()));
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

		Allarme newAllarme = addAllarme();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allarme.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("allarmeId", newAllarme.getAllarmeId()));

		List<Allarme> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Allarme allarme) {
		Assert.assertEquals(
			allarme.getUuid(),
			ReflectionTestUtil.invoke(
				allarme, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(allarme.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				allarme, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Allarme addAllarme() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allarme allarme = _persistence.create(pk);

		allarme.setUuid(RandomTestUtil.randomString());

		allarme.setGroupId(RandomTestUtil.nextLong());

		allarme.setCompanyId(RandomTestUtil.nextLong());

		allarme.setUserId(RandomTestUtil.nextLong());

		allarme.setUserName(RandomTestUtil.randomString());

		allarme.setCreateDate(RandomTestUtil.nextDate());

		allarme.setModifiedDate(RandomTestUtil.nextDate());

		allarme.setStato(RandomTestUtil.nextInt());

		allarme.setIdApprovatore(RandomTestUtil.nextLong());

		allarme.setDataApprovazione(RandomTestUtil.nextDate());

		allarme.setIdRegola(RandomTestUtil.nextLong());

		allarme.setColore(RandomTestUtil.nextInt());

		allarme.setDataInizio(RandomTestUtil.nextDate());

		allarme.setDataFine(RandomTestUtil.nextDate());

		_allarmes.add(_persistence.update(allarme));

		return allarme;
	}

	private List<Allarme> _allarmes = new ArrayList<Allarme>();
	private AllarmePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}