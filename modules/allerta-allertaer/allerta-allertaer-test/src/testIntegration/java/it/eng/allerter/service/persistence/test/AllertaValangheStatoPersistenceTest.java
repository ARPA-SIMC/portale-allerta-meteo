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

import it.eng.allerter.exception.NoSuchAllertaValangheStatoException;
import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.service.AllertaValangheStatoLocalServiceUtil;
import it.eng.allerter.service.persistence.AllertaValangheStatoPersistence;
import it.eng.allerter.service.persistence.AllertaValangheStatoUtil;

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
public class AllertaValangheStatoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = AllertaValangheStatoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AllertaValangheStato> iterator =
			_allertaValangheStatos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValangheStato allertaValangheStato = _persistence.create(pk);

		Assert.assertNotNull(allertaValangheStato);

		Assert.assertEquals(allertaValangheStato.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		_persistence.remove(newAllertaValangheStato);

		AllertaValangheStato existingAllertaValangheStato =
			_persistence.fetchByPrimaryKey(
				newAllertaValangheStato.getPrimaryKey());

		Assert.assertNull(existingAllertaValangheStato);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAllertaValangheStato();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValangheStato newAllertaValangheStato = _persistence.create(pk);

		newAllertaValangheStato.setUuid(RandomTestUtil.randomString());

		newAllertaValangheStato.setGroupId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setCompanyId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setUserId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setUserName(RandomTestUtil.randomString());

		newAllertaValangheStato.setCreateDate(RandomTestUtil.nextDate());

		newAllertaValangheStato.setModifiedDate(RandomTestUtil.nextDate());

		newAllertaValangheStato.setNome(RandomTestUtil.randomString());

		newAllertaValangheStato.setDataInizio(RandomTestUtil.nextDate());

		newAllertaValangheStato.setDataFine(RandomTestUtil.nextDate());

		newAllertaValangheStato.setParentId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setAllertaValangheId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setStatoId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setEventoId(RandomTestUtil.nextLong());

		newAllertaValangheStato.setAreaId(RandomTestUtil.nextLong());

		_allertaValangheStatos.add(
			_persistence.update(newAllertaValangheStato));

		AllertaValangheStato existingAllertaValangheStato =
			_persistence.findByPrimaryKey(
				newAllertaValangheStato.getPrimaryKey());

		Assert.assertEquals(
			existingAllertaValangheStato.getUuid(),
			newAllertaValangheStato.getUuid());
		Assert.assertEquals(
			existingAllertaValangheStato.getAllertaValangheStatoId(),
			newAllertaValangheStato.getAllertaValangheStatoId());
		Assert.assertEquals(
			existingAllertaValangheStato.getGroupId(),
			newAllertaValangheStato.getGroupId());
		Assert.assertEquals(
			existingAllertaValangheStato.getCompanyId(),
			newAllertaValangheStato.getCompanyId());
		Assert.assertEquals(
			existingAllertaValangheStato.getUserId(),
			newAllertaValangheStato.getUserId());
		Assert.assertEquals(
			existingAllertaValangheStato.getUserName(),
			newAllertaValangheStato.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAllertaValangheStato.getCreateDate()),
			Time.getShortTimestamp(newAllertaValangheStato.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAllertaValangheStato.getModifiedDate()),
			Time.getShortTimestamp(newAllertaValangheStato.getModifiedDate()));
		Assert.assertEquals(
			existingAllertaValangheStato.getNome(),
			newAllertaValangheStato.getNome());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAllertaValangheStato.getDataInizio()),
			Time.getShortTimestamp(newAllertaValangheStato.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValangheStato.getDataFine()),
			Time.getShortTimestamp(newAllertaValangheStato.getDataFine()));
		Assert.assertEquals(
			existingAllertaValangheStato.getParentId(),
			newAllertaValangheStato.getParentId());
		Assert.assertEquals(
			existingAllertaValangheStato.getAllertaValangheId(),
			newAllertaValangheStato.getAllertaValangheId());
		Assert.assertEquals(
			existingAllertaValangheStato.getStatoId(),
			newAllertaValangheStato.getStatoId());
		Assert.assertEquals(
			existingAllertaValangheStato.getEventoId(),
			newAllertaValangheStato.getEventoId());
		Assert.assertEquals(
			existingAllertaValangheStato.getAreaId(),
			newAllertaValangheStato.getAreaId());
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
	public void testCountByNome() throws Exception {
		_persistence.countByNome("");

		_persistence.countByNome("null");

		_persistence.countByNome((String)null);
	}

	@Test
	public void testCountByAllertaValangheId() throws Exception {
		_persistence.countByAllertaValangheId(RandomTestUtil.nextLong());

		_persistence.countByAllertaValangheId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		AllertaValangheStato existingAllertaValangheStato =
			_persistence.findByPrimaryKey(
				newAllertaValangheStato.getPrimaryKey());

		Assert.assertEquals(
			existingAllertaValangheStato, newAllertaValangheStato);
	}

	@Test(expected = NoSuchAllertaValangheStatoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AllertaValangheStato> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_AllertaValangheStato", "uuid", true,
			"allertaValangheStatoId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "nome", true, "dataInizio", true, "dataFine",
			true, "parentId", true, "allertaValangheId", true, "statoId", true,
			"eventoId", true, "areaId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		AllertaValangheStato existingAllertaValangheStato =
			_persistence.fetchByPrimaryKey(
				newAllertaValangheStato.getPrimaryKey());

		Assert.assertEquals(
			existingAllertaValangheStato, newAllertaValangheStato);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValangheStato missingAllertaValangheStato =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAllertaValangheStato);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AllertaValangheStato newAllertaValangheStato1 =
			addAllertaValangheStato();
		AllertaValangheStato newAllertaValangheStato2 =
			addAllertaValangheStato();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaValangheStato1.getPrimaryKey());
		primaryKeys.add(newAllertaValangheStato2.getPrimaryKey());

		Map<Serializable, AllertaValangheStato> allertaValangheStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, allertaValangheStatos.size());
		Assert.assertEquals(
			newAllertaValangheStato1,
			allertaValangheStatos.get(
				newAllertaValangheStato1.getPrimaryKey()));
		Assert.assertEquals(
			newAllertaValangheStato2,
			allertaValangheStatos.get(
				newAllertaValangheStato2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AllertaValangheStato> allertaValangheStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaValangheStatos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaValangheStato.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AllertaValangheStato> allertaValangheStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaValangheStatos.size());
		Assert.assertEquals(
			newAllertaValangheStato,
			allertaValangheStatos.get(newAllertaValangheStato.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AllertaValangheStato> allertaValangheStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaValangheStatos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaValangheStato.getPrimaryKey());

		Map<Serializable, AllertaValangheStato> allertaValangheStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaValangheStatos.size());
		Assert.assertEquals(
			newAllertaValangheStato,
			allertaValangheStatos.get(newAllertaValangheStato.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AllertaValangheStatoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AllertaValangheStato>() {

				@Override
				public void performAction(
					AllertaValangheStato allertaValangheStato) {

					Assert.assertNotNull(allertaValangheStato);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValangheStato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaValangheStatoId",
				newAllertaValangheStato.getAllertaValangheStatoId()));

		List<AllertaValangheStato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AllertaValangheStato existingAllertaValangheStato = result.get(0);

		Assert.assertEquals(
			existingAllertaValangheStato, newAllertaValangheStato);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValangheStato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaValangheStatoId", RandomTestUtil.nextLong()));

		List<AllertaValangheStato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValangheStato.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("allertaValangheStatoId"));

		Object newAllertaValangheStatoId =
			newAllertaValangheStato.getAllertaValangheStatoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaValangheStatoId",
				new Object[] {newAllertaValangheStatoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAllertaValangheStatoId = result.get(0);

		Assert.assertEquals(
			existingAllertaValangheStatoId, newAllertaValangheStatoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValangheStato.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("allertaValangheStatoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaValangheStatoId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newAllertaValangheStato.getPrimaryKey()));
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

		AllertaValangheStato newAllertaValangheStato =
			addAllertaValangheStato();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValangheStato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaValangheStatoId",
				newAllertaValangheStato.getAllertaValangheStatoId()));

		List<AllertaValangheStato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		AllertaValangheStato allertaValangheStato) {

		Assert.assertEquals(
			allertaValangheStato.getUuid(),
			ReflectionTestUtil.invoke(
				allertaValangheStato, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(allertaValangheStato.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				allertaValangheStato, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AllertaValangheStato addAllertaValangheStato() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValangheStato allertaValangheStato = _persistence.create(pk);

		allertaValangheStato.setUuid(RandomTestUtil.randomString());

		allertaValangheStato.setGroupId(RandomTestUtil.nextLong());

		allertaValangheStato.setCompanyId(RandomTestUtil.nextLong());

		allertaValangheStato.setUserId(RandomTestUtil.nextLong());

		allertaValangheStato.setUserName(RandomTestUtil.randomString());

		allertaValangheStato.setCreateDate(RandomTestUtil.nextDate());

		allertaValangheStato.setModifiedDate(RandomTestUtil.nextDate());

		allertaValangheStato.setNome(RandomTestUtil.randomString());

		allertaValangheStato.setDataInizio(RandomTestUtil.nextDate());

		allertaValangheStato.setDataFine(RandomTestUtil.nextDate());

		allertaValangheStato.setParentId(RandomTestUtil.nextLong());

		allertaValangheStato.setAllertaValangheId(RandomTestUtil.nextLong());

		allertaValangheStato.setStatoId(RandomTestUtil.nextLong());

		allertaValangheStato.setEventoId(RandomTestUtil.nextLong());

		allertaValangheStato.setAreaId(RandomTestUtil.nextLong());

		_allertaValangheStatos.add(_persistence.update(allertaValangheStato));

		return allertaValangheStato;
	}

	private List<AllertaValangheStato> _allertaValangheStatos =
		new ArrayList<AllertaValangheStato>();
	private AllertaValangheStatoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}