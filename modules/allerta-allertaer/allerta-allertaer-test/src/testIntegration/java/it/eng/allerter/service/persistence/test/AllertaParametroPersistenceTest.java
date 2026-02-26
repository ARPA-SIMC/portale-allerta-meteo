/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.test;

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

import it.eng.allerter.exception.NoSuchAllertaParametroException;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.service.persistence.AllertaParametroPersistence;
import it.eng.allerter.service.persistence.AllertaParametroUtil;

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
public class AllertaParametroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = AllertaParametroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AllertaParametro> iterator = _allertaParametros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		AllertaParametro allertaParametro = _persistence.create(pk);

		Assert.assertNotNull(allertaParametro);

		Assert.assertEquals(allertaParametro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AllertaParametro newAllertaParametro = addAllertaParametro();

		_persistence.remove(newAllertaParametro);

		AllertaParametro existingAllertaParametro =
			_persistence.fetchByPrimaryKey(newAllertaParametro.getPrimaryKey());

		Assert.assertNull(existingAllertaParametro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAllertaParametro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		AllertaParametro newAllertaParametro = _persistence.create(pk);

		newAllertaParametro.setValore(RandomTestUtil.randomString());

		_allertaParametros.add(_persistence.update(newAllertaParametro));

		AllertaParametro existingAllertaParametro =
			_persistence.findByPrimaryKey(newAllertaParametro.getPrimaryKey());

		Assert.assertEquals(
			existingAllertaParametro.getParametroId(),
			newAllertaParametro.getParametroId());
		Assert.assertEquals(
			existingAllertaParametro.getValore(),
			newAllertaParametro.getValore());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AllertaParametro newAllertaParametro = addAllertaParametro();

		AllertaParametro existingAllertaParametro =
			_persistence.findByPrimaryKey(newAllertaParametro.getPrimaryKey());

		Assert.assertEquals(existingAllertaParametro, newAllertaParametro);
	}

	@Test(expected = NoSuchAllertaParametroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AllertaParametro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_AllertaParametro", "parametroId", true, "valore", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AllertaParametro newAllertaParametro = addAllertaParametro();

		AllertaParametro existingAllertaParametro =
			_persistence.fetchByPrimaryKey(newAllertaParametro.getPrimaryKey());

		Assert.assertEquals(existingAllertaParametro, newAllertaParametro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		AllertaParametro missingAllertaParametro =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAllertaParametro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AllertaParametro newAllertaParametro1 = addAllertaParametro();
		AllertaParametro newAllertaParametro2 = addAllertaParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaParametro1.getPrimaryKey());
		primaryKeys.add(newAllertaParametro2.getPrimaryKey());

		Map<Serializable, AllertaParametro> allertaParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, allertaParametros.size());
		Assert.assertEquals(
			newAllertaParametro1,
			allertaParametros.get(newAllertaParametro1.getPrimaryKey()));
		Assert.assertEquals(
			newAllertaParametro2,
			allertaParametros.get(newAllertaParametro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AllertaParametro> allertaParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaParametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AllertaParametro newAllertaParametro = addAllertaParametro();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaParametro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AllertaParametro> allertaParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaParametros.size());
		Assert.assertEquals(
			newAllertaParametro,
			allertaParametros.get(newAllertaParametro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AllertaParametro> allertaParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaParametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AllertaParametro newAllertaParametro = addAllertaParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaParametro.getPrimaryKey());

		Map<Serializable, AllertaParametro> allertaParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaParametros.size());
		Assert.assertEquals(
			newAllertaParametro,
			allertaParametros.get(newAllertaParametro.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AllertaParametro newAllertaParametro = addAllertaParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parametroId", newAllertaParametro.getParametroId()));

		List<AllertaParametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AllertaParametro existingAllertaParametro = result.get(0);

		Assert.assertEquals(existingAllertaParametro, newAllertaParametro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parametroId", RandomTestUtil.randomString()));

		List<AllertaParametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AllertaParametro newAllertaParametro = addAllertaParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("parametroId"));

		Object newParametroId = newAllertaParametro.getParametroId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"parametroId", new Object[] {newParametroId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingParametroId = result.get(0);

		Assert.assertEquals(existingParametroId, newParametroId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("parametroId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"parametroId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AllertaParametro addAllertaParametro() throws Exception {
		String pk = RandomTestUtil.randomString();

		AllertaParametro allertaParametro = _persistence.create(pk);

		allertaParametro.setValore(RandomTestUtil.randomString());

		_allertaParametros.add(_persistence.update(allertaParametro));

		return allertaParametro;
	}

	private List<AllertaParametro> _allertaParametros =
		new ArrayList<AllertaParametro>();
	private AllertaParametroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}