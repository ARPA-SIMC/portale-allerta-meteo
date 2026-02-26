/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.test;

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

import it.eng.bollettino.exception.NoSuchAttivazioneFiumeException;
import it.eng.bollettino.model.AttivazioneFiume;
import it.eng.bollettino.service.persistence.AttivazioneFiumePersistence;
import it.eng.bollettino.service.persistence.AttivazioneFiumeUtil;

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
public class AttivazioneFiumePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = AttivazioneFiumeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AttivazioneFiume> iterator = _attivazioneFiumes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		AttivazioneFiume attivazioneFiume = _persistence.create(pk);

		Assert.assertNotNull(attivazioneFiume);

		Assert.assertEquals(attivazioneFiume.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		_persistence.remove(newAttivazioneFiume);

		AttivazioneFiume existingAttivazioneFiume =
			_persistence.fetchByPrimaryKey(newAttivazioneFiume.getPrimaryKey());

		Assert.assertNull(existingAttivazioneFiume);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAttivazioneFiume();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		AttivazioneFiume newAttivazioneFiume = _persistence.create(pk);

		newAttivazioneFiume.setAttivo(RandomTestUtil.randomBoolean());

		_attivazioneFiumes.add(_persistence.update(newAttivazioneFiume));

		AttivazioneFiume existingAttivazioneFiume =
			_persistence.findByPrimaryKey(newAttivazioneFiume.getPrimaryKey());

		Assert.assertEquals(
			existingAttivazioneFiume.getFiumeId(),
			newAttivazioneFiume.getFiumeId());
		Assert.assertEquals(
			existingAttivazioneFiume.isAttivo(),
			newAttivazioneFiume.isAttivo());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		AttivazioneFiume existingAttivazioneFiume =
			_persistence.findByPrimaryKey(newAttivazioneFiume.getPrimaryKey());

		Assert.assertEquals(existingAttivazioneFiume, newAttivazioneFiume);
	}

	@Test(expected = NoSuchAttivazioneFiumeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AttivazioneFiume> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_AttivazioneFiume", "fiumeId", true, "attivo", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		AttivazioneFiume existingAttivazioneFiume =
			_persistence.fetchByPrimaryKey(newAttivazioneFiume.getPrimaryKey());

		Assert.assertEquals(existingAttivazioneFiume, newAttivazioneFiume);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		AttivazioneFiume missingAttivazioneFiume =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAttivazioneFiume);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AttivazioneFiume newAttivazioneFiume1 = addAttivazioneFiume();
		AttivazioneFiume newAttivazioneFiume2 = addAttivazioneFiume();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAttivazioneFiume1.getPrimaryKey());
		primaryKeys.add(newAttivazioneFiume2.getPrimaryKey());

		Map<Serializable, AttivazioneFiume> attivazioneFiumes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, attivazioneFiumes.size());
		Assert.assertEquals(
			newAttivazioneFiume1,
			attivazioneFiumes.get(newAttivazioneFiume1.getPrimaryKey()));
		Assert.assertEquals(
			newAttivazioneFiume2,
			attivazioneFiumes.get(newAttivazioneFiume2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AttivazioneFiume> attivazioneFiumes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(attivazioneFiumes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAttivazioneFiume.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AttivazioneFiume> attivazioneFiumes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, attivazioneFiumes.size());
		Assert.assertEquals(
			newAttivazioneFiume,
			attivazioneFiumes.get(newAttivazioneFiume.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AttivazioneFiume> attivazioneFiumes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(attivazioneFiumes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAttivazioneFiume.getPrimaryKey());

		Map<Serializable, AttivazioneFiume> attivazioneFiumes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, attivazioneFiumes.size());
		Assert.assertEquals(
			newAttivazioneFiume,
			attivazioneFiumes.get(newAttivazioneFiume.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AttivazioneFiume.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"fiumeId", newAttivazioneFiume.getFiumeId()));

		List<AttivazioneFiume> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AttivazioneFiume existingAttivazioneFiume = result.get(0);

		Assert.assertEquals(existingAttivazioneFiume, newAttivazioneFiume);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AttivazioneFiume.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"fiumeId", RandomTestUtil.randomString()));

		List<AttivazioneFiume> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AttivazioneFiume newAttivazioneFiume = addAttivazioneFiume();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AttivazioneFiume.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fiumeId"));

		Object newFiumeId = newAttivazioneFiume.getFiumeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("fiumeId", new Object[] {newFiumeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFiumeId = result.get(0);

		Assert.assertEquals(existingFiumeId, newFiumeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AttivazioneFiume.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fiumeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"fiumeId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AttivazioneFiume addAttivazioneFiume() throws Exception {
		String pk = RandomTestUtil.randomString();

		AttivazioneFiume attivazioneFiume = _persistence.create(pk);

		attivazioneFiume.setAttivo(RandomTestUtil.randomBoolean());

		_attivazioneFiumes.add(_persistence.update(attivazioneFiume));

		return attivazioneFiume;
	}

	private List<AttivazioneFiume> _attivazioneFiumes =
		new ArrayList<AttivazioneFiume>();
	private AttivazioneFiumePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}