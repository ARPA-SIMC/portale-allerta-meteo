/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.test;

import allerta.catasto.exception.NoSuchEffettiException;
import allerta.catasto.model.Effetti;
import allerta.catasto.service.EffettiLocalServiceUtil;
import allerta.catasto.service.persistence.EffettiPersistence;
import allerta.catasto.service.persistence.EffettiUtil;

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
public class EffettiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.catasto.service"));

	@Before
	public void setUp() {
		_persistence = EffettiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Effetti> iterator = _effettis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Effetti effetti = _persistence.create(pk);

		Assert.assertNotNull(effetti);

		Assert.assertEquals(effetti.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Effetti newEffetti = addEffetti();

		_persistence.remove(newEffetti);

		Effetti existingEffetti = _persistence.fetchByPrimaryKey(
			newEffetti.getPrimaryKey());

		Assert.assertNull(existingEffetti);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEffetti();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Effetti newEffetti = _persistence.create(pk);

		newEffetti.setDescrizione(RandomTestUtil.randomString());

		_effettis.add(_persistence.update(newEffetti));

		Effetti existingEffetti = _persistence.findByPrimaryKey(
			newEffetti.getPrimaryKey());

		Assert.assertEquals(existingEffetti.getId(), newEffetti.getId());
		Assert.assertEquals(
			existingEffetti.getDescrizione(), newEffetti.getDescrizione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Effetti newEffetti = addEffetti();

		Effetti existingEffetti = _persistence.findByPrimaryKey(
			newEffetti.getPrimaryKey());

		Assert.assertEquals(existingEffetti, newEffetti);
	}

	@Test(expected = NoSuchEffettiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Effetti> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CATASTO_Effetti", "id", true, "descrizione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Effetti newEffetti = addEffetti();

		Effetti existingEffetti = _persistence.fetchByPrimaryKey(
			newEffetti.getPrimaryKey());

		Assert.assertEquals(existingEffetti, newEffetti);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Effetti missingEffetti = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEffetti);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Effetti newEffetti1 = addEffetti();
		Effetti newEffetti2 = addEffetti();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEffetti1.getPrimaryKey());
		primaryKeys.add(newEffetti2.getPrimaryKey());

		Map<Serializable, Effetti> effettis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, effettis.size());
		Assert.assertEquals(
			newEffetti1, effettis.get(newEffetti1.getPrimaryKey()));
		Assert.assertEquals(
			newEffetti2, effettis.get(newEffetti2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Effetti> effettis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(effettis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Effetti newEffetti = addEffetti();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEffetti.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Effetti> effettis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, effettis.size());
		Assert.assertEquals(
			newEffetti, effettis.get(newEffetti.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Effetti> effettis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(effettis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Effetti newEffetti = addEffetti();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEffetti.getPrimaryKey());

		Map<Serializable, Effetti> effettis = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, effettis.size());
		Assert.assertEquals(
			newEffetti, effettis.get(newEffetti.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EffettiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Effetti>() {

				@Override
				public void performAction(Effetti effetti) {
					Assert.assertNotNull(effetti);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Effetti newEffetti = addEffetti();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Effetti.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newEffetti.getId()));

		List<Effetti> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Effetti existingEffetti = result.get(0);

		Assert.assertEquals(existingEffetti, newEffetti);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Effetti.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Effetti> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Effetti newEffetti = addEffetti();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Effetti.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newEffetti.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Effetti.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Effetti addEffetti() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Effetti effetti = _persistence.create(pk);

		effetti.setDescrizione(RandomTestUtil.randomString());

		_effettis.add(_persistence.update(effetti));

		return effetti;
	}

	private List<Effetti> _effettis = new ArrayList<Effetti>();
	private EffettiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}