/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence.test;

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

import it.eng.animazione.image.exception.NoSuchParametroException;
import it.eng.animazione.image.model.Parametro;
import it.eng.animazione.image.service.persistence.ParametroPersistence;
import it.eng.animazione.image.service.persistence.ParametroUtil;

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
public class ParametroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animazione.image.service"));

	@Before
	public void setUp() {
		_persistence = ParametroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Parametro> iterator = _parametros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametro parametro = _persistence.create(pk);

		Assert.assertNotNull(parametro);

		Assert.assertEquals(parametro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Parametro newParametro = addParametro();

		_persistence.remove(newParametro);

		Parametro existingParametro = _persistence.fetchByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertNull(existingParametro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addParametro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametro newParametro = _persistence.create(pk);

		newParametro.setValue(RandomTestUtil.randomString());

		_parametros.add(_persistence.update(newParametro));

		Parametro existingParametro = _persistence.findByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertEquals(existingParametro.getKey(), newParametro.getKey());
		Assert.assertEquals(
			existingParametro.getValue(), newParametro.getValue());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Parametro newParametro = addParametro();

		Parametro existingParametro = _persistence.findByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertEquals(existingParametro, newParametro);
	}

	@Test(expected = NoSuchParametroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Parametro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"img_animazioni_Parametro", "key", true, "value", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Parametro newParametro = addParametro();

		Parametro existingParametro = _persistence.fetchByPrimaryKey(
			newParametro.getPrimaryKey());

		Assert.assertEquals(existingParametro, newParametro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametro missingParametro = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingParametro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Parametro newParametro1 = addParametro();
		Parametro newParametro2 = addParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametro1.getPrimaryKey());
		primaryKeys.add(newParametro2.getPrimaryKey());

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, parametros.size());
		Assert.assertEquals(
			newParametro1, parametros.get(newParametro1.getPrimaryKey()));
		Assert.assertEquals(
			newParametro2, parametros.get(newParametro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Parametro newParametro = addParametro();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parametros.size());
		Assert.assertEquals(
			newParametro, parametros.get(newParametro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Parametro newParametro = addParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParametro.getPrimaryKey());

		Map<Serializable, Parametro> parametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parametros.size());
		Assert.assertEquals(
			newParametro, parametros.get(newParametro.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Parametro newParametro = addParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("key", newParametro.getKey()));

		List<Parametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Parametro existingParametro = result.get(0);

		Assert.assertEquals(existingParametro, newParametro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("key", RandomTestUtil.randomString()));

		List<Parametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Parametro newParametro = addParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("key"));

		Object newKey = newParametro.getKey();

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
			Parametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("key"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"key", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Parametro addParametro() throws Exception {
		String pk = RandomTestUtil.randomString();

		Parametro parametro = _persistence.create(pk);

		parametro.setValue(RandomTestUtil.randomString());

		_parametros.add(_persistence.update(parametro));

		return parametro;
	}

	private List<Parametro> _parametros = new ArrayList<Parametro>();
	private ParametroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}