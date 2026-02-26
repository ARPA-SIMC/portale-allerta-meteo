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

import it.eng.allerta.messages.services.exception.NoSuchAuthException;
import it.eng.allerta.messages.services.model.Auth;
import it.eng.allerta.messages.services.service.persistence.AuthPersistence;
import it.eng.allerta.messages.services.service.persistence.AuthUtil;

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
public class AuthPersistenceTest {

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
		_persistence = AuthUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Auth> iterator = _auths.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Auth auth = _persistence.create(pk);

		Assert.assertNotNull(auth);

		Assert.assertEquals(auth.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Auth newAuth = addAuth();

		_persistence.remove(newAuth);

		Auth existingAuth = _persistence.fetchByPrimaryKey(
			newAuth.getPrimaryKey());

		Assert.assertNull(existingAuth);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAuth();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Auth newAuth = _persistence.create(pk);

		newAuth.setValue(RandomTestUtil.randomString());

		_auths.add(_persistence.update(newAuth));

		Auth existingAuth = _persistence.findByPrimaryKey(
			newAuth.getPrimaryKey());

		Assert.assertEquals(existingAuth.getKey(), newAuth.getKey());
		Assert.assertEquals(existingAuth.getValue(), newAuth.getValue());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Auth newAuth = addAuth();

		Auth existingAuth = _persistence.findByPrimaryKey(
			newAuth.getPrimaryKey());

		Assert.assertEquals(existingAuth, newAuth);
	}

	@Test(expected = NoSuchAuthException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Auth> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"smsService_Auth", "key", true, "value", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Auth newAuth = addAuth();

		Auth existingAuth = _persistence.fetchByPrimaryKey(
			newAuth.getPrimaryKey());

		Assert.assertEquals(existingAuth, newAuth);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Auth missingAuth = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAuth);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Auth newAuth1 = addAuth();
		Auth newAuth2 = addAuth();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuth1.getPrimaryKey());
		primaryKeys.add(newAuth2.getPrimaryKey());

		Map<Serializable, Auth> auths = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, auths.size());
		Assert.assertEquals(newAuth1, auths.get(newAuth1.getPrimaryKey()));
		Assert.assertEquals(newAuth2, auths.get(newAuth2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Auth> auths = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(auths.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Auth newAuth = addAuth();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuth.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Auth> auths = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, auths.size());
		Assert.assertEquals(newAuth, auths.get(newAuth.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Auth> auths = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(auths.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Auth newAuth = addAuth();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuth.getPrimaryKey());

		Map<Serializable, Auth> auths = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, auths.size());
		Assert.assertEquals(newAuth, auths.get(newAuth.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Auth newAuth = addAuth();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auth.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("key", newAuth.getKey()));

		List<Auth> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Auth existingAuth = result.get(0);

		Assert.assertEquals(existingAuth, newAuth);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auth.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("key", RandomTestUtil.randomString()));

		List<Auth> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Auth newAuth = addAuth();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auth.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("key"));

		Object newKey = newAuth.getKey();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("key", new Object[] {newKey}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingKey = result.get(0);

		Assert.assertEquals(existingKey, newKey);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auth.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("key"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"key", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Auth addAuth() throws Exception {
		String pk = RandomTestUtil.randomString();

		Auth auth = _persistence.create(pk);

		auth.setValue(RandomTestUtil.randomString());

		_auths.add(_persistence.update(auth));

		return auth;
	}

	private List<Auth> _auths = new ArrayList<Auth>();
	private AuthPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}