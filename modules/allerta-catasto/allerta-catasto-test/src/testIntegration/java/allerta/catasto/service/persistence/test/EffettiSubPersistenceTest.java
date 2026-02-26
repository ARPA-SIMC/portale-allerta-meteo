/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.test;

import allerta.catasto.exception.NoSuchEffettiSubException;
import allerta.catasto.model.EffettiSub;
import allerta.catasto.service.EffettiSubLocalServiceUtil;
import allerta.catasto.service.persistence.EffettiSubPK;
import allerta.catasto.service.persistence.EffettiSubPersistence;
import allerta.catasto.service.persistence.EffettiSubUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

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
public class EffettiSubPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.catasto.service"));

	@Before
	public void setUp() {
		_persistence = EffettiSubUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EffettiSub> iterator = _effettiSubs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		EffettiSubPK pk = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EffettiSub effettiSub = _persistence.create(pk);

		Assert.assertNotNull(effettiSub);

		Assert.assertEquals(effettiSub.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EffettiSub newEffettiSub = addEffettiSub();

		_persistence.remove(newEffettiSub);

		EffettiSub existingEffettiSub = _persistence.fetchByPrimaryKey(
			newEffettiSub.getPrimaryKey());

		Assert.assertNull(existingEffettiSub);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEffettiSub();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		EffettiSubPK pk = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EffettiSub newEffettiSub = _persistence.create(pk);

		newEffettiSub.setDescrizione(RandomTestUtil.randomString());

		_effettiSubs.add(_persistence.update(newEffettiSub));

		EffettiSub existingEffettiSub = _persistence.findByPrimaryKey(
			newEffettiSub.getPrimaryKey());

		Assert.assertEquals(existingEffettiSub.getId(), newEffettiSub.getId());
		Assert.assertEquals(
			existingEffettiSub.getIdEffetti(), newEffettiSub.getIdEffetti());
		Assert.assertEquals(
			existingEffettiSub.getDescrizione(),
			newEffettiSub.getDescrizione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EffettiSub newEffettiSub = addEffettiSub();

		EffettiSub existingEffettiSub = _persistence.findByPrimaryKey(
			newEffettiSub.getPrimaryKey());

		Assert.assertEquals(existingEffettiSub, newEffettiSub);
	}

	@Test(expected = NoSuchEffettiSubException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		EffettiSubPK pk = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EffettiSub newEffettiSub = addEffettiSub();

		EffettiSub existingEffettiSub = _persistence.fetchByPrimaryKey(
			newEffettiSub.getPrimaryKey());

		Assert.assertEquals(existingEffettiSub, newEffettiSub);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		EffettiSubPK pk = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EffettiSub missingEffettiSub = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEffettiSub);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EffettiSub newEffettiSub1 = addEffettiSub();
		EffettiSub newEffettiSub2 = addEffettiSub();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEffettiSub1.getPrimaryKey());
		primaryKeys.add(newEffettiSub2.getPrimaryKey());

		Map<Serializable, EffettiSub> effettiSubs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, effettiSubs.size());
		Assert.assertEquals(
			newEffettiSub1, effettiSubs.get(newEffettiSub1.getPrimaryKey()));
		Assert.assertEquals(
			newEffettiSub2, effettiSubs.get(newEffettiSub2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		EffettiSubPK pk1 = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EffettiSubPK pk2 = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EffettiSub> effettiSubs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(effettiSubs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EffettiSub newEffettiSub = addEffettiSub();

		EffettiSubPK pk = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEffettiSub.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EffettiSub> effettiSubs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, effettiSubs.size());
		Assert.assertEquals(
			newEffettiSub, effettiSubs.get(newEffettiSub.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EffettiSub> effettiSubs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(effettiSubs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EffettiSub newEffettiSub = addEffettiSub();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEffettiSub.getPrimaryKey());

		Map<Serializable, EffettiSub> effettiSubs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, effettiSubs.size());
		Assert.assertEquals(
			newEffettiSub, effettiSubs.get(newEffettiSub.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EffettiSubLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EffettiSub>() {

				@Override
				public void performAction(EffettiSub effettiSub) {
					Assert.assertNotNull(effettiSub);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EffettiSub newEffettiSub = addEffettiSub();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EffettiSub.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.id", newEffettiSub.getId()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.idEffetti", newEffettiSub.getIdEffetti()));

		List<EffettiSub> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EffettiSub existingEffettiSub = result.get(0);

		Assert.assertEquals(existingEffettiSub, newEffettiSub);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EffettiSub.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.id", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.idEffetti", RandomTestUtil.nextLong()));

		List<EffettiSub> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EffettiSub newEffettiSub = addEffettiSub();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EffettiSub.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.id"));

		Object newId = newEffettiSub.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id.id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EffettiSub.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EffettiSub addEffettiSub() throws Exception {
		EffettiSubPK pk = new EffettiSubPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EffettiSub effettiSub = _persistence.create(pk);

		effettiSub.setDescrizione(RandomTestUtil.randomString());

		_effettiSubs.add(_persistence.update(effettiSub));

		return effettiSub;
	}

	private List<EffettiSub> _effettiSubs = new ArrayList<EffettiSub>();
	private EffettiSubPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}