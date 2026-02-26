/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.test;

import allerta.catasto.exception.NoSuchCategoriaException;
import allerta.catasto.model.Categoria;
import allerta.catasto.service.CategoriaLocalServiceUtil;
import allerta.catasto.service.persistence.CategoriaPersistence;
import allerta.catasto.service.persistence.CategoriaUtil;

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
public class CategoriaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.catasto.service"));

	@Before
	public void setUp() {
		_persistence = CategoriaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Categoria> iterator = _categorias.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Categoria categoria = _persistence.create(pk);

		Assert.assertNotNull(categoria);

		Assert.assertEquals(categoria.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Categoria newCategoria = addCategoria();

		_persistence.remove(newCategoria);

		Categoria existingCategoria = _persistence.fetchByPrimaryKey(
			newCategoria.getPrimaryKey());

		Assert.assertNull(existingCategoria);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCategoria();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Categoria newCategoria = _persistence.create(pk);

		newCategoria.setDescrizione(RandomTestUtil.randomString());

		_categorias.add(_persistence.update(newCategoria));

		Categoria existingCategoria = _persistence.findByPrimaryKey(
			newCategoria.getPrimaryKey());

		Assert.assertEquals(existingCategoria.getId(), newCategoria.getId());
		Assert.assertEquals(
			existingCategoria.getDescrizione(), newCategoria.getDescrizione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Categoria newCategoria = addCategoria();

		Categoria existingCategoria = _persistence.findByPrimaryKey(
			newCategoria.getPrimaryKey());

		Assert.assertEquals(existingCategoria, newCategoria);
	}

	@Test(expected = NoSuchCategoriaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Categoria> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CATASTO_Categoria", "id", true, "descrizione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Categoria newCategoria = addCategoria();

		Categoria existingCategoria = _persistence.fetchByPrimaryKey(
			newCategoria.getPrimaryKey());

		Assert.assertEquals(existingCategoria, newCategoria);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Categoria missingCategoria = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCategoria);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Categoria newCategoria1 = addCategoria();
		Categoria newCategoria2 = addCategoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategoria1.getPrimaryKey());
		primaryKeys.add(newCategoria2.getPrimaryKey());

		Map<Serializable, Categoria> categorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, categorias.size());
		Assert.assertEquals(
			newCategoria1, categorias.get(newCategoria1.getPrimaryKey()));
		Assert.assertEquals(
			newCategoria2, categorias.get(newCategoria2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Categoria> categorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(categorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Categoria newCategoria = addCategoria();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategoria.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Categoria> categorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, categorias.size());
		Assert.assertEquals(
			newCategoria, categorias.get(newCategoria.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Categoria> categorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(categorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Categoria newCategoria = addCategoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategoria.getPrimaryKey());

		Map<Serializable, Categoria> categorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, categorias.size());
		Assert.assertEquals(
			newCategoria, categorias.get(newCategoria.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CategoriaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Categoria>() {

				@Override
				public void performAction(Categoria categoria) {
					Assert.assertNotNull(categoria);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Categoria newCategoria = addCategoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Categoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCategoria.getId()));

		List<Categoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Categoria existingCategoria = result.get(0);

		Assert.assertEquals(existingCategoria, newCategoria);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Categoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Categoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Categoria newCategoria = addCategoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Categoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newCategoria.getId();

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
			Categoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Categoria addCategoria() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Categoria categoria = _persistence.create(pk);

		categoria.setDescrizione(RandomTestUtil.randomString());

		_categorias.add(_persistence.update(categoria));

		return categoria;
	}

	private List<Categoria> _categorias = new ArrayList<Categoria>();
	private CategoriaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}