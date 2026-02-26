/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.test;

import allerta.catasto.exception.NoSuchSottocategoriaException;
import allerta.catasto.model.Sottocategoria;
import allerta.catasto.service.SottocategoriaLocalServiceUtil;
import allerta.catasto.service.persistence.SottocategoriaPK;
import allerta.catasto.service.persistence.SottocategoriaPersistence;
import allerta.catasto.service.persistence.SottocategoriaUtil;

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
public class SottocategoriaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.catasto.service"));

	@Before
	public void setUp() {
		_persistence = SottocategoriaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Sottocategoria> iterator = _sottocategorias.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		SottocategoriaPK pk = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Sottocategoria sottocategoria = _persistence.create(pk);

		Assert.assertNotNull(sottocategoria);

		Assert.assertEquals(sottocategoria.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Sottocategoria newSottocategoria = addSottocategoria();

		_persistence.remove(newSottocategoria);

		Sottocategoria existingSottocategoria = _persistence.fetchByPrimaryKey(
			newSottocategoria.getPrimaryKey());

		Assert.assertNull(existingSottocategoria);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSottocategoria();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		SottocategoriaPK pk = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Sottocategoria newSottocategoria = _persistence.create(pk);

		newSottocategoria.setDescrizione(RandomTestUtil.randomString());

		_sottocategorias.add(_persistence.update(newSottocategoria));

		Sottocategoria existingSottocategoria = _persistence.findByPrimaryKey(
			newSottocategoria.getPrimaryKey());

		Assert.assertEquals(
			existingSottocategoria.getId(), newSottocategoria.getId());
		Assert.assertEquals(
			existingSottocategoria.getIdCategoria(),
			newSottocategoria.getIdCategoria());
		Assert.assertEquals(
			existingSottocategoria.getDescrizione(),
			newSottocategoria.getDescrizione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Sottocategoria newSottocategoria = addSottocategoria();

		Sottocategoria existingSottocategoria = _persistence.findByPrimaryKey(
			newSottocategoria.getPrimaryKey());

		Assert.assertEquals(existingSottocategoria, newSottocategoria);
	}

	@Test(expected = NoSuchSottocategoriaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		SottocategoriaPK pk = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Sottocategoria newSottocategoria = addSottocategoria();

		Sottocategoria existingSottocategoria = _persistence.fetchByPrimaryKey(
			newSottocategoria.getPrimaryKey());

		Assert.assertEquals(existingSottocategoria, newSottocategoria);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		SottocategoriaPK pk = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Sottocategoria missingSottocategoria = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingSottocategoria);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Sottocategoria newSottocategoria1 = addSottocategoria();
		Sottocategoria newSottocategoria2 = addSottocategoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSottocategoria1.getPrimaryKey());
		primaryKeys.add(newSottocategoria2.getPrimaryKey());

		Map<Serializable, Sottocategoria> sottocategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, sottocategorias.size());
		Assert.assertEquals(
			newSottocategoria1,
			sottocategorias.get(newSottocategoria1.getPrimaryKey()));
		Assert.assertEquals(
			newSottocategoria2,
			sottocategorias.get(newSottocategoria2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		SottocategoriaPK pk1 = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		SottocategoriaPK pk2 = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Sottocategoria> sottocategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(sottocategorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Sottocategoria newSottocategoria = addSottocategoria();

		SottocategoriaPK pk = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSottocategoria.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Sottocategoria> sottocategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, sottocategorias.size());
		Assert.assertEquals(
			newSottocategoria,
			sottocategorias.get(newSottocategoria.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Sottocategoria> sottocategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(sottocategorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Sottocategoria newSottocategoria = addSottocategoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSottocategoria.getPrimaryKey());

		Map<Serializable, Sottocategoria> sottocategorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, sottocategorias.size());
		Assert.assertEquals(
			newSottocategoria,
			sottocategorias.get(newSottocategoria.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SottocategoriaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Sottocategoria>() {

				@Override
				public void performAction(Sottocategoria sottocategoria) {
					Assert.assertNotNull(sottocategoria);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Sottocategoria newSottocategoria = addSottocategoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Sottocategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.id", newSottocategoria.getId()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.idCategoria", newSottocategoria.getIdCategoria()));

		List<Sottocategoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Sottocategoria existingSottocategoria = result.get(0);

		Assert.assertEquals(existingSottocategoria, newSottocategoria);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Sottocategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.id", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.idCategoria", RandomTestUtil.nextLong()));

		List<Sottocategoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Sottocategoria newSottocategoria = addSottocategoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Sottocategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.id"));

		Object newId = newSottocategoria.getId();

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
			Sottocategoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Sottocategoria addSottocategoria() throws Exception {
		SottocategoriaPK pk = new SottocategoriaPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Sottocategoria sottocategoria = _persistence.create(pk);

		sottocategoria.setDescrizione(RandomTestUtil.randomString());

		_sottocategorias.add(_persistence.update(sottocategoria));

		return sottocategoria;
	}

	private List<Sottocategoria> _sottocategorias =
		new ArrayList<Sottocategoria>();
	private SottocategoriaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}