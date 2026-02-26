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

import it.eng.allerter.exception.NoSuchAllertaStatoException;
import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.service.AllertaStatoLocalServiceUtil;
import it.eng.allerter.service.persistence.AllertaStatoPersistence;
import it.eng.allerter.service.persistence.AllertaStatoUtil;

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
public class AllertaStatoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = AllertaStatoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AllertaStato> iterator = _allertaStatos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaStato allertaStato = _persistence.create(pk);

		Assert.assertNotNull(allertaStato);

		Assert.assertEquals(allertaStato.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		_persistence.remove(newAllertaStato);

		AllertaStato existingAllertaStato = _persistence.fetchByPrimaryKey(
			newAllertaStato.getPrimaryKey());

		Assert.assertNull(existingAllertaStato);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAllertaStato();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaStato newAllertaStato = _persistence.create(pk);

		newAllertaStato.setUuid(RandomTestUtil.randomString());

		newAllertaStato.setGroupId(RandomTestUtil.nextLong());

		newAllertaStato.setCompanyId(RandomTestUtil.nextLong());

		newAllertaStato.setUserId(RandomTestUtil.nextLong());

		newAllertaStato.setUserName(RandomTestUtil.randomString());

		newAllertaStato.setCreateDate(RandomTestUtil.nextDate());

		newAllertaStato.setModifiedDate(RandomTestUtil.nextDate());

		newAllertaStato.setNome(RandomTestUtil.randomString());

		newAllertaStato.setDataInizio(RandomTestUtil.nextDate());

		newAllertaStato.setDataFine(RandomTestUtil.nextDate());

		newAllertaStato.setParentId(RandomTestUtil.nextLong());

		newAllertaStato.setAllertaId(RandomTestUtil.nextLong());

		newAllertaStato.setStatoId(RandomTestUtil.nextLong());

		newAllertaStato.setEventoId(RandomTestUtil.nextLong());

		newAllertaStato.setAreaId(RandomTestUtil.nextLong());

		_allertaStatos.add(_persistence.update(newAllertaStato));

		AllertaStato existingAllertaStato = _persistence.findByPrimaryKey(
			newAllertaStato.getPrimaryKey());

		Assert.assertEquals(
			existingAllertaStato.getUuid(), newAllertaStato.getUuid());
		Assert.assertEquals(
			existingAllertaStato.getAllertaStatoId(),
			newAllertaStato.getAllertaStatoId());
		Assert.assertEquals(
			existingAllertaStato.getGroupId(), newAllertaStato.getGroupId());
		Assert.assertEquals(
			existingAllertaStato.getCompanyId(),
			newAllertaStato.getCompanyId());
		Assert.assertEquals(
			existingAllertaStato.getUserId(), newAllertaStato.getUserId());
		Assert.assertEquals(
			existingAllertaStato.getUserName(), newAllertaStato.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaStato.getCreateDate()),
			Time.getShortTimestamp(newAllertaStato.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaStato.getModifiedDate()),
			Time.getShortTimestamp(newAllertaStato.getModifiedDate()));
		Assert.assertEquals(
			existingAllertaStato.getNome(), newAllertaStato.getNome());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaStato.getDataInizio()),
			Time.getShortTimestamp(newAllertaStato.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaStato.getDataFine()),
			Time.getShortTimestamp(newAllertaStato.getDataFine()));
		Assert.assertEquals(
			existingAllertaStato.getParentId(), newAllertaStato.getParentId());
		Assert.assertEquals(
			existingAllertaStato.getAllertaId(),
			newAllertaStato.getAllertaId());
		Assert.assertEquals(
			existingAllertaStato.getStatoId(), newAllertaStato.getStatoId());
		Assert.assertEquals(
			existingAllertaStato.getEventoId(), newAllertaStato.getEventoId());
		Assert.assertEquals(
			existingAllertaStato.getAreaId(), newAllertaStato.getAreaId());
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
	public void testCountByAllertaId() throws Exception {
		_persistence.countByAllertaId(RandomTestUtil.nextLong());

		_persistence.countByAllertaId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		AllertaStato existingAllertaStato = _persistence.findByPrimaryKey(
			newAllertaStato.getPrimaryKey());

		Assert.assertEquals(existingAllertaStato, newAllertaStato);
	}

	@Test(expected = NoSuchAllertaStatoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AllertaStato> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_AllertaStato", "uuid", true, "allertaStatoId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "nome", true,
			"dataInizio", true, "dataFine", true, "parentId", true, "allertaId",
			true, "statoId", true, "eventoId", true, "areaId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		AllertaStato existingAllertaStato = _persistence.fetchByPrimaryKey(
			newAllertaStato.getPrimaryKey());

		Assert.assertEquals(existingAllertaStato, newAllertaStato);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaStato missingAllertaStato = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAllertaStato);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AllertaStato newAllertaStato1 = addAllertaStato();
		AllertaStato newAllertaStato2 = addAllertaStato();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaStato1.getPrimaryKey());
		primaryKeys.add(newAllertaStato2.getPrimaryKey());

		Map<Serializable, AllertaStato> allertaStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, allertaStatos.size());
		Assert.assertEquals(
			newAllertaStato1,
			allertaStatos.get(newAllertaStato1.getPrimaryKey()));
		Assert.assertEquals(
			newAllertaStato2,
			allertaStatos.get(newAllertaStato2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AllertaStato> allertaStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaStatos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AllertaStato newAllertaStato = addAllertaStato();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaStato.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AllertaStato> allertaStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaStatos.size());
		Assert.assertEquals(
			newAllertaStato,
			allertaStatos.get(newAllertaStato.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AllertaStato> allertaStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaStatos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaStato.getPrimaryKey());

		Map<Serializable, AllertaStato> allertaStatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaStatos.size());
		Assert.assertEquals(
			newAllertaStato,
			allertaStatos.get(newAllertaStato.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AllertaStatoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AllertaStato>() {

				@Override
				public void performAction(AllertaStato allertaStato) {
					Assert.assertNotNull(allertaStato);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaStato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaStatoId", newAllertaStato.getAllertaStatoId()));

		List<AllertaStato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AllertaStato existingAllertaStato = result.get(0);

		Assert.assertEquals(existingAllertaStato, newAllertaStato);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaStato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaStatoId", RandomTestUtil.nextLong()));

		List<AllertaStato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaStato.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("allertaStatoId"));

		Object newAllertaStatoId = newAllertaStato.getAllertaStatoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaStatoId", new Object[] {newAllertaStatoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAllertaStatoId = result.get(0);

		Assert.assertEquals(existingAllertaStatoId, newAllertaStatoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaStato.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("allertaStatoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaStatoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AllertaStato newAllertaStato = addAllertaStato();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAllertaStato.getPrimaryKey()));
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

		AllertaStato newAllertaStato = addAllertaStato();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaStato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaStatoId", newAllertaStato.getAllertaStatoId()));

		List<AllertaStato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(AllertaStato allertaStato) {
		Assert.assertEquals(
			allertaStato.getUuid(),
			ReflectionTestUtil.invoke(
				allertaStato, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(allertaStato.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				allertaStato, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AllertaStato addAllertaStato() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaStato allertaStato = _persistence.create(pk);

		allertaStato.setUuid(RandomTestUtil.randomString());

		allertaStato.setGroupId(RandomTestUtil.nextLong());

		allertaStato.setCompanyId(RandomTestUtil.nextLong());

		allertaStato.setUserId(RandomTestUtil.nextLong());

		allertaStato.setUserName(RandomTestUtil.randomString());

		allertaStato.setCreateDate(RandomTestUtil.nextDate());

		allertaStato.setModifiedDate(RandomTestUtil.nextDate());

		allertaStato.setNome(RandomTestUtil.randomString());

		allertaStato.setDataInizio(RandomTestUtil.nextDate());

		allertaStato.setDataFine(RandomTestUtil.nextDate());

		allertaStato.setParentId(RandomTestUtil.nextLong());

		allertaStato.setAllertaId(RandomTestUtil.nextLong());

		allertaStato.setStatoId(RandomTestUtil.nextLong());

		allertaStato.setEventoId(RandomTestUtil.nextLong());

		allertaStato.setAreaId(RandomTestUtil.nextLong());

		_allertaStatos.add(_persistence.update(allertaStato));

		return allertaStato;
	}

	private List<AllertaStato> _allertaStatos = new ArrayList<AllertaStato>();
	private AllertaStatoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}