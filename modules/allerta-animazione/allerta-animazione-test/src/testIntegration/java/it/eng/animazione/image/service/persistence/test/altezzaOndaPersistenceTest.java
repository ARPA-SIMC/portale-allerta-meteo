/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence.test;

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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaException;
import it.eng.animazione.image.model.altezzaOnda;
import it.eng.animazione.image.service.altezzaOndaLocalServiceUtil;
import it.eng.animazione.image.service.persistence.altezzaOndaPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaUtil;

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
public class altezzaOndaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animazione.image.service"));

	@Before
	public void setUp() {
		_persistence = altezzaOndaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<altezzaOnda> iterator = _altezzaOndas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOnda altezzaOnda = _persistence.create(pk);

		Assert.assertNotNull(altezzaOnda);

		Assert.assertEquals(altezzaOnda.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		_persistence.remove(newaltezzaOnda);

		altezzaOnda existingaltezzaOnda = _persistence.fetchByPrimaryKey(
			newaltezzaOnda.getPrimaryKey());

		Assert.assertNull(existingaltezzaOnda);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addaltezzaOnda();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOnda newaltezzaOnda = _persistence.create(pk);

		newaltezzaOnda.setIm(RandomTestUtil.randomString());

		newaltezzaOnda.setText_LOC(RandomTestUtil.randomString());

		newaltezzaOnda.setTs_UTC(RandomTestUtil.nextLong());

		newaltezzaOnda.setImgData(RandomTestUtil.randomString());

		_altezzaOndas.add(_persistence.update(newaltezzaOnda));

		altezzaOnda existingaltezzaOnda = _persistence.findByPrimaryKey(
			newaltezzaOnda.getPrimaryKey());

		Assert.assertEquals(
			existingaltezzaOnda.getId(), newaltezzaOnda.getId());
		Assert.assertEquals(
			existingaltezzaOnda.getIm(), newaltezzaOnda.getIm());
		Assert.assertEquals(
			existingaltezzaOnda.getText_LOC(), newaltezzaOnda.getText_LOC());
		Assert.assertEquals(
			existingaltezzaOnda.getTs_UTC(), newaltezzaOnda.getTs_UTC());
		Assert.assertEquals(
			existingaltezzaOnda.getImgData(), newaltezzaOnda.getImgData());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		altezzaOnda existingaltezzaOnda = _persistence.findByPrimaryKey(
			newaltezzaOnda.getPrimaryKey());

		Assert.assertEquals(existingaltezzaOnda, newaltezzaOnda);
	}

	@Test(expected = NoSuchaltezzaOndaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<altezzaOnda> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"img_animazioni_altezzaOnda", "id", true, "im", true, "text_LOC",
			true, "ts_UTC", true, "imgData", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		altezzaOnda existingaltezzaOnda = _persistence.fetchByPrimaryKey(
			newaltezzaOnda.getPrimaryKey());

		Assert.assertEquals(existingaltezzaOnda, newaltezzaOnda);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOnda missingaltezzaOnda = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingaltezzaOnda);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		altezzaOnda newaltezzaOnda1 = addaltezzaOnda();
		altezzaOnda newaltezzaOnda2 = addaltezzaOnda();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOnda1.getPrimaryKey());
		primaryKeys.add(newaltezzaOnda2.getPrimaryKey());

		Map<Serializable, altezzaOnda> altezzaOndas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, altezzaOndas.size());
		Assert.assertEquals(
			newaltezzaOnda1, altezzaOndas.get(newaltezzaOnda1.getPrimaryKey()));
		Assert.assertEquals(
			newaltezzaOnda2, altezzaOndas.get(newaltezzaOnda2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, altezzaOnda> altezzaOndas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(altezzaOndas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOnda.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, altezzaOnda> altezzaOndas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, altezzaOndas.size());
		Assert.assertEquals(
			newaltezzaOnda, altezzaOndas.get(newaltezzaOnda.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, altezzaOnda> altezzaOndas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(altezzaOndas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOnda.getPrimaryKey());

		Map<Serializable, altezzaOnda> altezzaOndas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, altezzaOndas.size());
		Assert.assertEquals(
			newaltezzaOnda, altezzaOndas.get(newaltezzaOnda.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			altezzaOndaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<altezzaOnda>() {

				@Override
				public void performAction(altezzaOnda altezzaOnda) {
					Assert.assertNotNull(altezzaOnda);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOnda.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newaltezzaOnda.getId()));

		List<altezzaOnda> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		altezzaOnda existingaltezzaOnda = result.get(0);

		Assert.assertEquals(existingaltezzaOnda, newaltezzaOnda);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOnda.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<altezzaOnda> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		altezzaOnda newaltezzaOnda = addaltezzaOnda();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOnda.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newaltezzaOnda.getId();

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
			altezzaOnda.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected altezzaOnda addaltezzaOnda() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOnda altezzaOnda = _persistence.create(pk);

		altezzaOnda.setIm(RandomTestUtil.randomString());

		altezzaOnda.setText_LOC(RandomTestUtil.randomString());

		altezzaOnda.setTs_UTC(RandomTestUtil.nextLong());

		altezzaOnda.setImgData(RandomTestUtil.randomString());

		_altezzaOndas.add(_persistence.update(altezzaOnda));

		return altezzaOnda;
	}

	private List<altezzaOnda> _altezzaOndas = new ArrayList<altezzaOnda>();
	private altezzaOndaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}