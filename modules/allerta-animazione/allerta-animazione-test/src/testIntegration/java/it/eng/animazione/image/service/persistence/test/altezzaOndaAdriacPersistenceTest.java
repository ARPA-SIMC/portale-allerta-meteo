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

import it.eng.animazione.image.exception.NoSuchaltezzaOndaAdriacException;
import it.eng.animazione.image.model.altezzaOndaAdriac;
import it.eng.animazione.image.service.altezzaOndaAdriacLocalServiceUtil;
import it.eng.animazione.image.service.persistence.altezzaOndaAdriacPersistence;
import it.eng.animazione.image.service.persistence.altezzaOndaAdriacUtil;

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
public class altezzaOndaAdriacPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animazione.image.service"));

	@Before
	public void setUp() {
		_persistence = altezzaOndaAdriacUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<altezzaOndaAdriac> iterator = _altezzaOndaAdriacs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaAdriac altezzaOndaAdriac = _persistence.create(pk);

		Assert.assertNotNull(altezzaOndaAdriac);

		Assert.assertEquals(altezzaOndaAdriac.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		_persistence.remove(newaltezzaOndaAdriac);

		altezzaOndaAdriac existingaltezzaOndaAdriac =
			_persistence.fetchByPrimaryKey(
				newaltezzaOndaAdriac.getPrimaryKey());

		Assert.assertNull(existingaltezzaOndaAdriac);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addaltezzaOndaAdriac();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaAdriac newaltezzaOndaAdriac = _persistence.create(pk);

		newaltezzaOndaAdriac.setIm(RandomTestUtil.randomString());

		newaltezzaOndaAdriac.setText_LOC(RandomTestUtil.randomString());

		newaltezzaOndaAdriac.setTs_UTC(RandomTestUtil.nextLong());

		newaltezzaOndaAdriac.setImgData(RandomTestUtil.randomString());

		_altezzaOndaAdriacs.add(_persistence.update(newaltezzaOndaAdriac));

		altezzaOndaAdriac existingaltezzaOndaAdriac =
			_persistence.findByPrimaryKey(newaltezzaOndaAdriac.getPrimaryKey());

		Assert.assertEquals(
			existingaltezzaOndaAdriac.getId(), newaltezzaOndaAdriac.getId());
		Assert.assertEquals(
			existingaltezzaOndaAdriac.getIm(), newaltezzaOndaAdriac.getIm());
		Assert.assertEquals(
			existingaltezzaOndaAdriac.getText_LOC(),
			newaltezzaOndaAdriac.getText_LOC());
		Assert.assertEquals(
			existingaltezzaOndaAdriac.getTs_UTC(),
			newaltezzaOndaAdriac.getTs_UTC());
		Assert.assertEquals(
			existingaltezzaOndaAdriac.getImgData(),
			newaltezzaOndaAdriac.getImgData());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		altezzaOndaAdriac existingaltezzaOndaAdriac =
			_persistence.findByPrimaryKey(newaltezzaOndaAdriac.getPrimaryKey());

		Assert.assertEquals(existingaltezzaOndaAdriac, newaltezzaOndaAdriac);
	}

	@Test(expected = NoSuchaltezzaOndaAdriacException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<altezzaOndaAdriac> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"img_animazioni_altezzaOndaAdriac", "id", true, "im", true,
			"text_LOC", true, "ts_UTC", true, "imgData", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		altezzaOndaAdriac existingaltezzaOndaAdriac =
			_persistence.fetchByPrimaryKey(
				newaltezzaOndaAdriac.getPrimaryKey());

		Assert.assertEquals(existingaltezzaOndaAdriac, newaltezzaOndaAdriac);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaAdriac missingaltezzaOndaAdriac =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingaltezzaOndaAdriac);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		altezzaOndaAdriac newaltezzaOndaAdriac1 = addaltezzaOndaAdriac();
		altezzaOndaAdriac newaltezzaOndaAdriac2 = addaltezzaOndaAdriac();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOndaAdriac1.getPrimaryKey());
		primaryKeys.add(newaltezzaOndaAdriac2.getPrimaryKey());

		Map<Serializable, altezzaOndaAdriac> altezzaOndaAdriacs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, altezzaOndaAdriacs.size());
		Assert.assertEquals(
			newaltezzaOndaAdriac1,
			altezzaOndaAdriacs.get(newaltezzaOndaAdriac1.getPrimaryKey()));
		Assert.assertEquals(
			newaltezzaOndaAdriac2,
			altezzaOndaAdriacs.get(newaltezzaOndaAdriac2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, altezzaOndaAdriac> altezzaOndaAdriacs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(altezzaOndaAdriacs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOndaAdriac.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, altezzaOndaAdriac> altezzaOndaAdriacs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, altezzaOndaAdriacs.size());
		Assert.assertEquals(
			newaltezzaOndaAdriac,
			altezzaOndaAdriacs.get(newaltezzaOndaAdriac.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, altezzaOndaAdriac> altezzaOndaAdriacs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(altezzaOndaAdriacs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newaltezzaOndaAdriac.getPrimaryKey());

		Map<Serializable, altezzaOndaAdriac> altezzaOndaAdriacs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, altezzaOndaAdriacs.size());
		Assert.assertEquals(
			newaltezzaOndaAdriac,
			altezzaOndaAdriacs.get(newaltezzaOndaAdriac.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			altezzaOndaAdriacLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<altezzaOndaAdriac>() {

				@Override
				public void performAction(altezzaOndaAdriac altezzaOndaAdriac) {
					Assert.assertNotNull(altezzaOndaAdriac);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOndaAdriac.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newaltezzaOndaAdriac.getId()));

		List<altezzaOndaAdriac> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		altezzaOndaAdriac existingaltezzaOndaAdriac = result.get(0);

		Assert.assertEquals(existingaltezzaOndaAdriac, newaltezzaOndaAdriac);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOndaAdriac.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<altezzaOndaAdriac> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		altezzaOndaAdriac newaltezzaOndaAdriac = addaltezzaOndaAdriac();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			altezzaOndaAdriac.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newaltezzaOndaAdriac.getId();

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
			altezzaOndaAdriac.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected altezzaOndaAdriac addaltezzaOndaAdriac() throws Exception {
		long pk = RandomTestUtil.nextLong();

		altezzaOndaAdriac altezzaOndaAdriac = _persistence.create(pk);

		altezzaOndaAdriac.setIm(RandomTestUtil.randomString());

		altezzaOndaAdriac.setText_LOC(RandomTestUtil.randomString());

		altezzaOndaAdriac.setTs_UTC(RandomTestUtil.nextLong());

		altezzaOndaAdriac.setImgData(RandomTestUtil.randomString());

		_altezzaOndaAdriacs.add(_persistence.update(altezzaOndaAdriac));

		return altezzaOndaAdriac;
	}

	private List<altezzaOndaAdriac> _altezzaOndaAdriacs =
		new ArrayList<altezzaOndaAdriac>();
	private altezzaOndaAdriacPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}