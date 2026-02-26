/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.test;

import allerta.catasto.exception.NoSuchFonteException;
import allerta.catasto.model.Fonte;
import allerta.catasto.service.FonteLocalServiceUtil;
import allerta.catasto.service.persistence.FontePersistence;
import allerta.catasto.service.persistence.FonteUtil;

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
public class FontePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.catasto.service"));

	@Before
	public void setUp() {
		_persistence = FonteUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Fonte> iterator = _fontes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Fonte fonte = _persistence.create(pk);

		Assert.assertNotNull(fonte);

		Assert.assertEquals(fonte.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Fonte newFonte = addFonte();

		_persistence.remove(newFonte);

		Fonte existingFonte = _persistence.fetchByPrimaryKey(
			newFonte.getPrimaryKey());

		Assert.assertNull(existingFonte);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFonte();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Fonte newFonte = _persistence.create(pk);

		newFonte.setDescrizione(RandomTestUtil.randomString());

		_fontes.add(_persistence.update(newFonte));

		Fonte existingFonte = _persistence.findByPrimaryKey(
			newFonte.getPrimaryKey());

		Assert.assertEquals(existingFonte.getId(), newFonte.getId());
		Assert.assertEquals(
			existingFonte.getDescrizione(), newFonte.getDescrizione());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Fonte newFonte = addFonte();

		Fonte existingFonte = _persistence.findByPrimaryKey(
			newFonte.getPrimaryKey());

		Assert.assertEquals(existingFonte, newFonte);
	}

	@Test(expected = NoSuchFonteException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Fonte> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CATASTO_Fonte", "id", true, "descrizione", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Fonte newFonte = addFonte();

		Fonte existingFonte = _persistence.fetchByPrimaryKey(
			newFonte.getPrimaryKey());

		Assert.assertEquals(existingFonte, newFonte);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Fonte missingFonte = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFonte);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Fonte newFonte1 = addFonte();
		Fonte newFonte2 = addFonte();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFonte1.getPrimaryKey());
		primaryKeys.add(newFonte2.getPrimaryKey());

		Map<Serializable, Fonte> fontes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, fontes.size());
		Assert.assertEquals(newFonte1, fontes.get(newFonte1.getPrimaryKey()));
		Assert.assertEquals(newFonte2, fontes.get(newFonte2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Fonte> fontes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(fontes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Fonte newFonte = addFonte();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFonte.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Fonte> fontes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, fontes.size());
		Assert.assertEquals(newFonte, fontes.get(newFonte.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Fonte> fontes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(fontes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Fonte newFonte = addFonte();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFonte.getPrimaryKey());

		Map<Serializable, Fonte> fontes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, fontes.size());
		Assert.assertEquals(newFonte, fontes.get(newFonte.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			FonteLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Fonte>() {

				@Override
				public void performAction(Fonte fonte) {
					Assert.assertNotNull(fonte);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Fonte newFonte = addFonte();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Fonte.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newFonte.getId()));

		List<Fonte> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Fonte existingFonte = result.get(0);

		Assert.assertEquals(existingFonte, newFonte);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Fonte.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Fonte> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Fonte newFonte = addFonte();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Fonte.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newFonte.getId();

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
			Fonte.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Fonte addFonte() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Fonte fonte = _persistence.create(pk);

		fonte.setDescrizione(RandomTestUtil.randomString());

		_fontes.add(_persistence.update(fonte));

		return fonte;
	}

	private List<Fonte> _fontes = new ArrayList<Fonte>();
	private FontePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}