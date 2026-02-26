/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.allerta.messages.services.exception.NoSuchSmsSchedulerContextException;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.service.persistence.SmsSchedulerContextPersistence;
import it.eng.allerta.messages.services.service.persistence.SmsSchedulerContextUtil;

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
public class SmsSchedulerContextPersistenceTest {

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
		_persistence = SmsSchedulerContextUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SmsSchedulerContext> iterator =
			_smsSchedulerContexts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		SmsSchedulerContext smsSchedulerContext = _persistence.create(pk);

		Assert.assertNotNull(smsSchedulerContext);

		Assert.assertEquals(smsSchedulerContext.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		_persistence.remove(newSmsSchedulerContext);

		SmsSchedulerContext existingSmsSchedulerContext =
			_persistence.fetchByPrimaryKey(
				newSmsSchedulerContext.getPrimaryKey());

		Assert.assertNull(existingSmsSchedulerContext);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSmsSchedulerContext();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		SmsSchedulerContext newSmsSchedulerContext = _persistence.create(pk);

		newSmsSchedulerContext.setValue(RandomTestUtil.randomString());

		_smsSchedulerContexts.add(_persistence.update(newSmsSchedulerContext));

		SmsSchedulerContext existingSmsSchedulerContext =
			_persistence.findByPrimaryKey(
				newSmsSchedulerContext.getPrimaryKey());

		Assert.assertEquals(
			existingSmsSchedulerContext.getVarId(),
			newSmsSchedulerContext.getVarId());
		Assert.assertEquals(
			existingSmsSchedulerContext.getValue(),
			newSmsSchedulerContext.getValue());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		SmsSchedulerContext existingSmsSchedulerContext =
			_persistence.findByPrimaryKey(
				newSmsSchedulerContext.getPrimaryKey());

		Assert.assertEquals(
			existingSmsSchedulerContext, newSmsSchedulerContext);
	}

	@Test(expected = NoSuchSmsSchedulerContextException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SmsSchedulerContext> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"smsService_SmsSchedulerContext", "varId", true, "value", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		SmsSchedulerContext existingSmsSchedulerContext =
			_persistence.fetchByPrimaryKey(
				newSmsSchedulerContext.getPrimaryKey());

		Assert.assertEquals(
			existingSmsSchedulerContext, newSmsSchedulerContext);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		SmsSchedulerContext missingSmsSchedulerContext =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSmsSchedulerContext);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SmsSchedulerContext newSmsSchedulerContext1 = addSmsSchedulerContext();
		SmsSchedulerContext newSmsSchedulerContext2 = addSmsSchedulerContext();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSmsSchedulerContext1.getPrimaryKey());
		primaryKeys.add(newSmsSchedulerContext2.getPrimaryKey());

		Map<Serializable, SmsSchedulerContext> smsSchedulerContexts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, smsSchedulerContexts.size());
		Assert.assertEquals(
			newSmsSchedulerContext1,
			smsSchedulerContexts.get(newSmsSchedulerContext1.getPrimaryKey()));
		Assert.assertEquals(
			newSmsSchedulerContext2,
			smsSchedulerContexts.get(newSmsSchedulerContext2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SmsSchedulerContext> smsSchedulerContexts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(smsSchedulerContexts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSmsSchedulerContext.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SmsSchedulerContext> smsSchedulerContexts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, smsSchedulerContexts.size());
		Assert.assertEquals(
			newSmsSchedulerContext,
			smsSchedulerContexts.get(newSmsSchedulerContext.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SmsSchedulerContext> smsSchedulerContexts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(smsSchedulerContexts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSmsSchedulerContext.getPrimaryKey());

		Map<Serializable, SmsSchedulerContext> smsSchedulerContexts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, smsSchedulerContexts.size());
		Assert.assertEquals(
			newSmsSchedulerContext,
			smsSchedulerContexts.get(newSmsSchedulerContext.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SmsSchedulerContext.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"varId", newSmsSchedulerContext.getVarId()));

		List<SmsSchedulerContext> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SmsSchedulerContext existingSmsSchedulerContext = result.get(0);

		Assert.assertEquals(
			existingSmsSchedulerContext, newSmsSchedulerContext);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SmsSchedulerContext.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("varId", RandomTestUtil.randomString()));

		List<SmsSchedulerContext> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SmsSchedulerContext newSmsSchedulerContext = addSmsSchedulerContext();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SmsSchedulerContext.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("varId"));

		Object newVarId = newSmsSchedulerContext.getVarId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("varId", new Object[] {newVarId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingVarId = result.get(0);

		Assert.assertEquals(existingVarId, newVarId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SmsSchedulerContext.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("varId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"varId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SmsSchedulerContext addSmsSchedulerContext() throws Exception {
		String pk = RandomTestUtil.randomString();

		SmsSchedulerContext smsSchedulerContext = _persistence.create(pk);

		smsSchedulerContext.setValue(RandomTestUtil.randomString());

		_smsSchedulerContexts.add(_persistence.update(smsSchedulerContext));

		return smsSchedulerContext;
	}

	private List<SmsSchedulerContext> _smsSchedulerContexts =
		new ArrayList<SmsSchedulerContext>();
	private SmsSchedulerContextPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}