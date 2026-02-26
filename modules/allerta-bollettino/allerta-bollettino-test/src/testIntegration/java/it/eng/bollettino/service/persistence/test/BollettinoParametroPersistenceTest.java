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

import it.eng.bollettino.exception.NoSuchBollettinoParametroException;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.persistence.BollettinoParametroPersistence;
import it.eng.bollettino.service.persistence.BollettinoParametroUtil;

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
public class BollettinoParametroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = BollettinoParametroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BollettinoParametro> iterator =
			_bollettinoParametros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		BollettinoParametro bollettinoParametro = _persistence.create(pk);

		Assert.assertNotNull(bollettinoParametro);

		Assert.assertEquals(bollettinoParametro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		_persistence.remove(newBollettinoParametro);

		BollettinoParametro existingBollettinoParametro =
			_persistence.fetchByPrimaryKey(
				newBollettinoParametro.getPrimaryKey());

		Assert.assertNull(existingBollettinoParametro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBollettinoParametro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		BollettinoParametro newBollettinoParametro = _persistence.create(pk);

		newBollettinoParametro.setValore(RandomTestUtil.randomString());

		_bollettinoParametros.add(_persistence.update(newBollettinoParametro));

		BollettinoParametro existingBollettinoParametro =
			_persistence.findByPrimaryKey(
				newBollettinoParametro.getPrimaryKey());

		Assert.assertEquals(
			existingBollettinoParametro.getParametroId(),
			newBollettinoParametro.getParametroId());
		Assert.assertEquals(
			existingBollettinoParametro.getValore(),
			newBollettinoParametro.getValore());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		BollettinoParametro existingBollettinoParametro =
			_persistence.findByPrimaryKey(
				newBollettinoParametro.getPrimaryKey());

		Assert.assertEquals(
			existingBollettinoParametro, newBollettinoParametro);
	}

	@Test(expected = NoSuchBollettinoParametroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BollettinoParametro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_BollettinoParametro", "parametroId", true, "valore",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		BollettinoParametro existingBollettinoParametro =
			_persistence.fetchByPrimaryKey(
				newBollettinoParametro.getPrimaryKey());

		Assert.assertEquals(
			existingBollettinoParametro, newBollettinoParametro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		BollettinoParametro missingBollettinoParametro =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBollettinoParametro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BollettinoParametro newBollettinoParametro1 = addBollettinoParametro();
		BollettinoParametro newBollettinoParametro2 = addBollettinoParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoParametro1.getPrimaryKey());
		primaryKeys.add(newBollettinoParametro2.getPrimaryKey());

		Map<Serializable, BollettinoParametro> bollettinoParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bollettinoParametros.size());
		Assert.assertEquals(
			newBollettinoParametro1,
			bollettinoParametros.get(newBollettinoParametro1.getPrimaryKey()));
		Assert.assertEquals(
			newBollettinoParametro2,
			bollettinoParametros.get(newBollettinoParametro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BollettinoParametro> bollettinoParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoParametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoParametro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BollettinoParametro> bollettinoParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoParametros.size());
		Assert.assertEquals(
			newBollettinoParametro,
			bollettinoParametros.get(newBollettinoParametro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BollettinoParametro> bollettinoParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinoParametros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettinoParametro.getPrimaryKey());

		Map<Serializable, BollettinoParametro> bollettinoParametros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinoParametros.size());
		Assert.assertEquals(
			newBollettinoParametro,
			bollettinoParametros.get(newBollettinoParametro.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parametroId", newBollettinoParametro.getParametroId()));

		List<BollettinoParametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BollettinoParametro existingBollettinoParametro = result.get(0);

		Assert.assertEquals(
			existingBollettinoParametro, newBollettinoParametro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parametroId", RandomTestUtil.randomString()));

		List<BollettinoParametro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BollettinoParametro newBollettinoParametro = addBollettinoParametro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BollettinoParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("parametroId"));

		Object newParametroId = newBollettinoParametro.getParametroId();

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
			BollettinoParametro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("parametroId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"parametroId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected BollettinoParametro addBollettinoParametro() throws Exception {
		String pk = RandomTestUtil.randomString();

		BollettinoParametro bollettinoParametro = _persistence.create(pk);

		bollettinoParametro.setValore(RandomTestUtil.randomString());

		_bollettinoParametros.add(_persistence.update(bollettinoParametro));

		return bollettinoParametro;
	}

	private List<BollettinoParametro> _bollettinoParametros =
		new ArrayList<BollettinoParametro>();
	private BollettinoParametroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}