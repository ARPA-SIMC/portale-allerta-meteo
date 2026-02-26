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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaSwanitaException;
import it.eng.animazione.image.model.altezzaOndaSwanita;
import it.eng.animazione.image.service.altezzaOndaSwanitaLocalServiceUtil;
import it.eng.animazione.image.service.persistence.altezzaOndaSwanitaPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaSwanitaUtil;

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
public class altezzaOndaSwanitaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animazione.image.service"));

	@Before
	public void setUp() {
		_persistence = altezzaOndaSwanitaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<altezzaOndaSwanita> iterator = _altezzaOndaSwanitas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaSwanita altezzaOndaSwanita = _persistence.create(pk);

		Assert.assertNotNull(altezzaOndaSwanita);

		Assert.assertEquals(altezzaOndaSwanita.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		_persistence.remove(newaltezzaOndaSwanita);

		altezzaOndaSwanita existingaltezzaOndaSwanita =
			_persistence.fetchByPrimaryKey(
				newaltezzaOndaSwanita.getPrimaryKey());

		Assert.assertNull(existingaltezzaOndaSwanita);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addaltezzaOndaSwanita();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaSwanita newaltezzaOndaSwanita = _persistence.create(pk);

		newaltezzaOndaSwanita.setIm(RandomTestUtil.randomString());

		newaltezzaOndaSwanita.setText_LOC(RandomTestUtil.randomString());

		newaltezzaOndaSwanita.setTs_UTC(RandomTestUtil.nextLong());

		newaltezzaOndaSwanita.setImgData(RandomTestUtil.randomString());

		_altezzaOndaSwanitas.add(_persistence.update(newaltezzaOndaSwanita));

		altezzaOndaSwanita existingaltezzaOndaSwanita =
			_persistence.findByPrimaryKey(
				newaltezzaOndaSwanita.getPrimaryKey());

		Assert.assertEquals(
			existingaltezzaOndaSwanita.getId(), newaltezzaOndaSwanita.getId());
		Assert.assertEquals(
			existingaltezzaOndaSwanita.getIm(), newaltezzaOndaSwanita.getIm());
		Assert.assertEquals(
			existingaltezzaOndaSwanita.getText_LOC(),
			newaltezzaOndaSwanita.getText_LOC());
		Assert.assertEquals(
			existingaltezzaOndaSwanita.getTs_UTC(),
			newaltezzaOndaSwanita.getTs_UTC());
		Assert.assertEquals(
			existingaltezzaOndaSwanita.getImgData(),
			newaltezzaOndaSwanita.getImgData());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		altezzaOndaSwanita existingaltezzaOndaSwanita =
			_persistence.findByPrimaryKey(
				newaltezzaOndaSwanita.getPrimaryKey());

		Assert.assertEquals(existingaltezzaOndaSwanita, newaltezzaOndaSwanita);
	}

	@Test(expected = NoSuchaltezzaOndaSwanitaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<altezzaOndaSwanita> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"img_animazioni_altezzaOndaSwanita", "id", true, "im", true,
			"text_LOC", true, "ts_UTC", true, "imgData", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		altezzaOndaSwanita existingaltezzaOndaSwanita =
			_persistence.fetchByPrimaryKey(
				newaltezzaOndaSwanita.getPrimaryKey());

		Assert.assertEquals(existingaltezzaOndaSwanita, newaltezzaOndaSwanita);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaSwanita missingaltezzaOndaSwanita =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingaltezzaOndaSwanita);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		altezzaOndaSwanita newaltezzaOndaSwanita1 = addaltezzaOndaSwanita();
		altezzaOndaSwanita newaltezzaOndaSwanita2 = addaltezzaOndaSwanita();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOndaSwanita1.getPrimaryKey());
		primaryKeys.add(newaltezzaOndaSwanita2.getPrimaryKey());

		Map<Serializable, altezzaOndaSwanita> altezzaOndaSwanitas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, altezzaOndaSwanitas.size());
		Assert.assertEquals(
			newaltezzaOndaSwanita1,
			altezzaOndaSwanitas.get(newaltezzaOndaSwanita1.getPrimaryKey()));
		Assert.assertEquals(
			newaltezzaOndaSwanita2,
			altezzaOndaSwanitas.get(newaltezzaOndaSwanita2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, altezzaOndaSwanita> altezzaOndaSwanitas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(altezzaOndaSwanitas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOndaSwanita.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, altezzaOndaSwanita> altezzaOndaSwanitas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, altezzaOndaSwanitas.size());
		Assert.assertEquals(
			newaltezzaOndaSwanita,
			altezzaOndaSwanitas.get(newaltezzaOndaSwanita.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, altezzaOndaSwanita> altezzaOndaSwanitas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(altezzaOndaSwanitas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOndaSwanita.getPrimaryKey());

		Map<Serializable, altezzaOndaSwanita> altezzaOndaSwanitas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, altezzaOndaSwanitas.size());
		Assert.assertEquals(
			newaltezzaOndaSwanita,
			altezzaOndaSwanitas.get(newaltezzaOndaSwanita.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			altezzaOndaSwanitaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<altezzaOndaSwanita>() {

				@Override
				public void performAction(
					altezzaOndaSwanita altezzaOndaSwanita) {

					Assert.assertNotNull(altezzaOndaSwanita);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOndaSwanita.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newaltezzaOndaSwanita.getId()));

		List<altezzaOndaSwanita> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		altezzaOndaSwanita existingaltezzaOndaSwanita = result.get(0);

		Assert.assertEquals(existingaltezzaOndaSwanita, newaltezzaOndaSwanita);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOndaSwanita.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<altezzaOndaSwanita> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		altezzaOndaSwanita newaltezzaOndaSwanita = addaltezzaOndaSwanita();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOndaSwanita.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newaltezzaOndaSwanita.getId();

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
			altezzaOndaSwanita.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected altezzaOndaSwanita addaltezzaOndaSwanita() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaSwanita altezzaOndaSwanita = _persistence.create(pk);

		altezzaOndaSwanita.setIm(RandomTestUtil.randomString());

		altezzaOndaSwanita.setText_LOC(RandomTestUtil.randomString());

		altezzaOndaSwanita.setTs_UTC(RandomTestUtil.nextLong());

		altezzaOndaSwanita.setImgData(RandomTestUtil.randomString());

		_altezzaOndaSwanitas.add(_persistence.update(altezzaOndaSwanita));

		return altezzaOndaSwanita;
	}

	private List<altezzaOndaSwanita> _altezzaOndaSwanitas =
		new ArrayList<altezzaOndaSwanita>();
	private altezzaOndaSwanitaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}