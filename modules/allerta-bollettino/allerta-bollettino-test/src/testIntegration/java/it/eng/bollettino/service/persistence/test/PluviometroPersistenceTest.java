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

import it.eng.bollettino.exception.NoSuchPluviometroException;
import it.eng.bollettino.model.Pluviometro;
import it.eng.bollettino.service.persistence.PluviometroPersistence;
import it.eng.bollettino.service.persistence.PluviometroUtil;

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
public class PluviometroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = PluviometroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Pluviometro> iterator = _pluviometros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Pluviometro pluviometro = _persistence.create(pk);

		Assert.assertNotNull(pluviometro);

		Assert.assertEquals(pluviometro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Pluviometro newPluviometro = addPluviometro();

		_persistence.remove(newPluviometro);

		Pluviometro existingPluviometro = _persistence.fetchByPrimaryKey(
			newPluviometro.getPrimaryKey());

		Assert.assertNull(existingPluviometro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPluviometro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Pluviometro newPluviometro = _persistence.create(pk);

		newPluviometro.setNomeGruppo(RandomTestUtil.randomString());

		newPluviometro.setNomeRubrica(RandomTestUtil.randomString());

		_pluviometros.add(_persistence.update(newPluviometro));

		Pluviometro existingPluviometro = _persistence.findByPrimaryKey(
			newPluviometro.getPrimaryKey());

		Assert.assertEquals(
			existingPluviometro.getStazioneId(),
			newPluviometro.getStazioneId());
		Assert.assertEquals(
			existingPluviometro.getNomeGruppo(),
			newPluviometro.getNomeGruppo());
		Assert.assertEquals(
			existingPluviometro.getNomeRubrica(),
			newPluviometro.getNomeRubrica());
	}

	@Test
	public void testCountByNomeGruppo() throws Exception {
		_persistence.countByNomeGruppo("");

		_persistence.countByNomeGruppo("null");

		_persistence.countByNomeGruppo((String)null);
	}

	@Test
	public void testCountByNomeRubrica() throws Exception {
		_persistence.countByNomeRubrica("");

		_persistence.countByNomeRubrica("null");

		_persistence.countByNomeRubrica((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Pluviometro newPluviometro = addPluviometro();

		Pluviometro existingPluviometro = _persistence.findByPrimaryKey(
			newPluviometro.getPrimaryKey());

		Assert.assertEquals(existingPluviometro, newPluviometro);
	}

	@Test(expected = NoSuchPluviometroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Pluviometro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Pluviometro", "stazioneId", true, "nomeGruppo", true,
			"nomeRubrica", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Pluviometro newPluviometro = addPluviometro();

		Pluviometro existingPluviometro = _persistence.fetchByPrimaryKey(
			newPluviometro.getPrimaryKey());

		Assert.assertEquals(existingPluviometro, newPluviometro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Pluviometro missingPluviometro = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPluviometro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Pluviometro newPluviometro1 = addPluviometro();
		Pluviometro newPluviometro2 = addPluviometro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPluviometro1.getPrimaryKey());
		primaryKeys.add(newPluviometro2.getPrimaryKey());

		Map<Serializable, Pluviometro> pluviometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, pluviometros.size());
		Assert.assertEquals(
			newPluviometro1, pluviometros.get(newPluviometro1.getPrimaryKey()));
		Assert.assertEquals(
			newPluviometro2, pluviometros.get(newPluviometro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Pluviometro> pluviometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pluviometros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Pluviometro newPluviometro = addPluviometro();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPluviometro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Pluviometro> pluviometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pluviometros.size());
		Assert.assertEquals(
			newPluviometro, pluviometros.get(newPluviometro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Pluviometro> pluviometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pluviometros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Pluviometro newPluviometro = addPluviometro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPluviometro.getPrimaryKey());

		Map<Serializable, Pluviometro> pluviometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pluviometros.size());
		Assert.assertEquals(
			newPluviometro, pluviometros.get(newPluviometro.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Pluviometro newPluviometro = addPluviometro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pluviometro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stazioneId", newPluviometro.getStazioneId()));

		List<Pluviometro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Pluviometro existingPluviometro = result.get(0);

		Assert.assertEquals(existingPluviometro, newPluviometro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pluviometro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stazioneId", RandomTestUtil.randomString()));

		List<Pluviometro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Pluviometro newPluviometro = addPluviometro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pluviometro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("stazioneId"));

		Object newStazioneId = newPluviometro.getStazioneId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stazioneId", new Object[] {newStazioneId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStazioneId = result.get(0);

		Assert.assertEquals(existingStazioneId, newStazioneId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pluviometro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("stazioneId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stazioneId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Pluviometro addPluviometro() throws Exception {
		String pk = RandomTestUtil.randomString();

		Pluviometro pluviometro = _persistence.create(pk);

		pluviometro.setNomeGruppo(RandomTestUtil.randomString());

		pluviometro.setNomeRubrica(RandomTestUtil.randomString());

		_pluviometros.add(_persistence.update(pluviometro));

		return pluviometro;
	}

	private List<Pluviometro> _pluviometros = new ArrayList<Pluviometro>();
	private PluviometroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}