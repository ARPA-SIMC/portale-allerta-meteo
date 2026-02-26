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

import it.eng.allerter.exception.NoSuchStatoAllertamentoException;
import it.eng.allerter.model.StatoAllertamento;
import it.eng.allerter.service.StatoAllertamentoLocalServiceUtil;
import it.eng.allerter.service.persistence.StatoAllertamentoPersistence;
import it.eng.allerter.service.persistence.StatoAllertamentoUtil;

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
public class StatoAllertamentoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = StatoAllertamentoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StatoAllertamento> iterator = _statoAllertamentos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatoAllertamento statoAllertamento = _persistence.create(pk);

		Assert.assertNotNull(statoAllertamento);

		Assert.assertEquals(statoAllertamento.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		_persistence.remove(newStatoAllertamento);

		StatoAllertamento existingStatoAllertamento =
			_persistence.fetchByPrimaryKey(
				newStatoAllertamento.getPrimaryKey());

		Assert.assertNull(existingStatoAllertamento);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStatoAllertamento();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatoAllertamento newStatoAllertamento = _persistence.create(pk);

		newStatoAllertamento.setUuid(RandomTestUtil.randomString());

		newStatoAllertamento.setGroupId(RandomTestUtil.nextLong());

		newStatoAllertamento.setCompanyId(RandomTestUtil.nextLong());

		newStatoAllertamento.setUserId(RandomTestUtil.nextLong());

		newStatoAllertamento.setUserName(RandomTestUtil.randomString());

		newStatoAllertamento.setCreateDate(RandomTestUtil.nextDate());

		newStatoAllertamento.setModifiedDate(RandomTestUtil.nextDate());

		newStatoAllertamento.setNome(RandomTestUtil.randomString());

		newStatoAllertamento.setDataInizio(RandomTestUtil.nextDate());

		newStatoAllertamento.setDataFine(RandomTestUtil.nextDate());

		newStatoAllertamento.setParentId(RandomTestUtil.nextLong());

		_statoAllertamentos.add(_persistence.update(newStatoAllertamento));

		StatoAllertamento existingStatoAllertamento =
			_persistence.findByPrimaryKey(newStatoAllertamento.getPrimaryKey());

		Assert.assertEquals(
			existingStatoAllertamento.getUuid(),
			newStatoAllertamento.getUuid());
		Assert.assertEquals(
			existingStatoAllertamento.getStatoId(),
			newStatoAllertamento.getStatoId());
		Assert.assertEquals(
			existingStatoAllertamento.getGroupId(),
			newStatoAllertamento.getGroupId());
		Assert.assertEquals(
			existingStatoAllertamento.getCompanyId(),
			newStatoAllertamento.getCompanyId());
		Assert.assertEquals(
			existingStatoAllertamento.getUserId(),
			newStatoAllertamento.getUserId());
		Assert.assertEquals(
			existingStatoAllertamento.getUserName(),
			newStatoAllertamento.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingStatoAllertamento.getCreateDate()),
			Time.getShortTimestamp(newStatoAllertamento.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingStatoAllertamento.getModifiedDate()),
			Time.getShortTimestamp(newStatoAllertamento.getModifiedDate()));
		Assert.assertEquals(
			existingStatoAllertamento.getNome(),
			newStatoAllertamento.getNome());
		Assert.assertEquals(
			Time.getShortTimestamp(existingStatoAllertamento.getDataInizio()),
			Time.getShortTimestamp(newStatoAllertamento.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingStatoAllertamento.getDataFine()),
			Time.getShortTimestamp(newStatoAllertamento.getDataFine()));
		Assert.assertEquals(
			existingStatoAllertamento.getParentId(),
			newStatoAllertamento.getParentId());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		StatoAllertamento existingStatoAllertamento =
			_persistence.findByPrimaryKey(newStatoAllertamento.getPrimaryKey());

		Assert.assertEquals(existingStatoAllertamento, newStatoAllertamento);
	}

	@Test(expected = NoSuchStatoAllertamentoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<StatoAllertamento> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_StatoAllertamento", "uuid", true, "statoId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "nome", true,
			"dataInizio", true, "dataFine", true, "parentId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		StatoAllertamento existingStatoAllertamento =
			_persistence.fetchByPrimaryKey(
				newStatoAllertamento.getPrimaryKey());

		Assert.assertEquals(existingStatoAllertamento, newStatoAllertamento);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatoAllertamento missingStatoAllertamento =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStatoAllertamento);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StatoAllertamento newStatoAllertamento1 = addStatoAllertamento();
		StatoAllertamento newStatoAllertamento2 = addStatoAllertamento();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatoAllertamento1.getPrimaryKey());
		primaryKeys.add(newStatoAllertamento2.getPrimaryKey());

		Map<Serializable, StatoAllertamento> statoAllertamentos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, statoAllertamentos.size());
		Assert.assertEquals(
			newStatoAllertamento1,
			statoAllertamentos.get(newStatoAllertamento1.getPrimaryKey()));
		Assert.assertEquals(
			newStatoAllertamento2,
			statoAllertamentos.get(newStatoAllertamento2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StatoAllertamento> statoAllertamentos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(statoAllertamentos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatoAllertamento.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StatoAllertamento> statoAllertamentos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, statoAllertamentos.size());
		Assert.assertEquals(
			newStatoAllertamento,
			statoAllertamentos.get(newStatoAllertamento.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StatoAllertamento> statoAllertamentos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(statoAllertamentos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatoAllertamento.getPrimaryKey());

		Map<Serializable, StatoAllertamento> statoAllertamentos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, statoAllertamentos.size());
		Assert.assertEquals(
			newStatoAllertamento,
			statoAllertamentos.get(newStatoAllertamento.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StatoAllertamentoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<StatoAllertamento>() {

				@Override
				public void performAction(StatoAllertamento statoAllertamento) {
					Assert.assertNotNull(statoAllertamento);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatoAllertamento.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"statoId", newStatoAllertamento.getStatoId()));

		List<StatoAllertamento> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StatoAllertamento existingStatoAllertamento = result.get(0);

		Assert.assertEquals(existingStatoAllertamento, newStatoAllertamento);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatoAllertamento.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("statoId", RandomTestUtil.nextLong()));

		List<StatoAllertamento> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatoAllertamento.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("statoId"));

		Object newStatoId = newStatoAllertamento.getStatoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("statoId", new Object[] {newStatoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStatoId = result.get(0);

		Assert.assertEquals(existingStatoId, newStatoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatoAllertamento.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("statoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"statoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newStatoAllertamento.getPrimaryKey()));
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

		StatoAllertamento newStatoAllertamento = addStatoAllertamento();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatoAllertamento.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"statoId", newStatoAllertamento.getStatoId()));

		List<StatoAllertamento> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(StatoAllertamento statoAllertamento) {
		Assert.assertEquals(
			statoAllertamento.getUuid(),
			ReflectionTestUtil.invoke(
				statoAllertamento, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(statoAllertamento.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				statoAllertamento, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected StatoAllertamento addStatoAllertamento() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatoAllertamento statoAllertamento = _persistence.create(pk);

		statoAllertamento.setUuid(RandomTestUtil.randomString());

		statoAllertamento.setGroupId(RandomTestUtil.nextLong());

		statoAllertamento.setCompanyId(RandomTestUtil.nextLong());

		statoAllertamento.setUserId(RandomTestUtil.nextLong());

		statoAllertamento.setUserName(RandomTestUtil.randomString());

		statoAllertamento.setCreateDate(RandomTestUtil.nextDate());

		statoAllertamento.setModifiedDate(RandomTestUtil.nextDate());

		statoAllertamento.setNome(RandomTestUtil.randomString());

		statoAllertamento.setDataInizio(RandomTestUtil.nextDate());

		statoAllertamento.setDataFine(RandomTestUtil.nextDate());

		statoAllertamento.setParentId(RandomTestUtil.nextLong());

		_statoAllertamentos.add(_persistence.update(statoAllertamento));

		return statoAllertamento;
	}

	private List<StatoAllertamento> _statoAllertamentos =
		new ArrayList<StatoAllertamento>();
	private StatoAllertamentoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}