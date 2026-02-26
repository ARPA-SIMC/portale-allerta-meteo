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
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.bollettino.exception.NoSuchIdrometroException;
import it.eng.bollettino.model.Idrometro;
import it.eng.bollettino.service.persistence.IdrometroPersistence;
import it.eng.bollettino.service.persistence.IdrometroUtil;

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
public class IdrometroPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = IdrometroUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Idrometro> iterator = _idrometros.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Idrometro idrometro = _persistence.create(pk);

		Assert.assertNotNull(idrometro);

		Assert.assertEquals(idrometro.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Idrometro newIdrometro = addIdrometro();

		_persistence.remove(newIdrometro);

		Idrometro existingIdrometro = _persistence.fetchByPrimaryKey(
			newIdrometro.getPrimaryKey());

		Assert.assertNull(existingIdrometro);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addIdrometro();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Idrometro newIdrometro = _persistence.create(pk);

		newIdrometro.setNomeBacino(RandomTestUtil.randomString());

		newIdrometro.setNomeSottobacino(RandomTestUtil.randomString());

		newIdrometro.setNomeRubrica(RandomTestUtil.randomString());

		newIdrometro.setSogliaSpike(RandomTestUtil.nextDouble());

		_idrometros.add(_persistence.update(newIdrometro));

		Idrometro existingIdrometro = _persistence.findByPrimaryKey(
			newIdrometro.getPrimaryKey());

		Assert.assertEquals(
			existingIdrometro.getStazioneId(), newIdrometro.getStazioneId());
		Assert.assertEquals(
			existingIdrometro.getNomeBacino(), newIdrometro.getNomeBacino());
		Assert.assertEquals(
			existingIdrometro.getNomeSottobacino(),
			newIdrometro.getNomeSottobacino());
		Assert.assertEquals(
			existingIdrometro.getNomeRubrica(), newIdrometro.getNomeRubrica());
		AssertUtils.assertEquals(
			existingIdrometro.getSogliaSpike(), newIdrometro.getSogliaSpike());
	}

	@Test
	public void testCountByNomeBacino() throws Exception {
		_persistence.countByNomeBacino("");

		_persistence.countByNomeBacino("null");

		_persistence.countByNomeBacino((String)null);
	}

	@Test
	public void testCountByNomeSottobacino() throws Exception {
		_persistence.countByNomeSottobacino("");

		_persistence.countByNomeSottobacino("null");

		_persistence.countByNomeSottobacino((String)null);
	}

	@Test
	public void testCountByNomeRubrica() throws Exception {
		_persistence.countByNomeRubrica("");

		_persistence.countByNomeRubrica("null");

		_persistence.countByNomeRubrica((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Idrometro newIdrometro = addIdrometro();

		Idrometro existingIdrometro = _persistence.findByPrimaryKey(
			newIdrometro.getPrimaryKey());

		Assert.assertEquals(existingIdrometro, newIdrometro);
	}

	@Test(expected = NoSuchIdrometroException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Idrometro> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Idrometro", "stazioneId", true, "nomeBacino", true,
			"nomeSottobacino", true, "nomeRubrica", true, "sogliaSpike", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Idrometro newIdrometro = addIdrometro();

		Idrometro existingIdrometro = _persistence.fetchByPrimaryKey(
			newIdrometro.getPrimaryKey());

		Assert.assertEquals(existingIdrometro, newIdrometro);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Idrometro missingIdrometro = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingIdrometro);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Idrometro newIdrometro1 = addIdrometro();
		Idrometro newIdrometro2 = addIdrometro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIdrometro1.getPrimaryKey());
		primaryKeys.add(newIdrometro2.getPrimaryKey());

		Map<Serializable, Idrometro> idrometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, idrometros.size());
		Assert.assertEquals(
			newIdrometro1, idrometros.get(newIdrometro1.getPrimaryKey()));
		Assert.assertEquals(
			newIdrometro2, idrometros.get(newIdrometro2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Idrometro> idrometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(idrometros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Idrometro newIdrometro = addIdrometro();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIdrometro.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Idrometro> idrometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, idrometros.size());
		Assert.assertEquals(
			newIdrometro, idrometros.get(newIdrometro.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Idrometro> idrometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(idrometros.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Idrometro newIdrometro = addIdrometro();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIdrometro.getPrimaryKey());

		Map<Serializable, Idrometro> idrometros =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, idrometros.size());
		Assert.assertEquals(
			newIdrometro, idrometros.get(newIdrometro.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Idrometro newIdrometro = addIdrometro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Idrometro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stazioneId", newIdrometro.getStazioneId()));

		List<Idrometro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Idrometro existingIdrometro = result.get(0);

		Assert.assertEquals(existingIdrometro, newIdrometro);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Idrometro.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"stazioneId", RandomTestUtil.randomString()));

		List<Idrometro> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Idrometro newIdrometro = addIdrometro();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Idrometro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("stazioneId"));

		Object newStazioneId = newIdrometro.getStazioneId();

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
			Idrometro.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("stazioneId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"stazioneId", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Idrometro addIdrometro() throws Exception {
		String pk = RandomTestUtil.randomString();

		Idrometro idrometro = _persistence.create(pk);

		idrometro.setNomeBacino(RandomTestUtil.randomString());

		idrometro.setNomeSottobacino(RandomTestUtil.randomString());

		idrometro.setNomeRubrica(RandomTestUtil.randomString());

		idrometro.setSogliaSpike(RandomTestUtil.nextDouble());

		_idrometros.add(_persistence.update(idrometro));

		return idrometro;
	}

	private List<Idrometro> _idrometros = new ArrayList<Idrometro>();
	private IdrometroPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}