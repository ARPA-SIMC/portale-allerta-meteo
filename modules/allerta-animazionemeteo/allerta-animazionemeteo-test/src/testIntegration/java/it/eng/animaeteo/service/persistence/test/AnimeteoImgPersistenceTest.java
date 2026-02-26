/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service.persistence.test;

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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.animaeteo.exception.NoSuchAnimeteoImgException;
import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.service.AnimeteoImgLocalServiceUtil;
import it.eng.animaeteo.service.persistence.AnimeteoImgPersistence;
import it.eng.animaeteo.service.persistence.AnimeteoImgUtil;

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
public class AnimeteoImgPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animaeteo.service"));

	@Before
	public void setUp() {
		_persistence = AnimeteoImgUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnimeteoImg> iterator = _animeteoImgs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoImg animeteoImg = _persistence.create(pk);

		Assert.assertNotNull(animeteoImg);

		Assert.assertEquals(animeteoImg.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		_persistence.remove(newAnimeteoImg);

		AnimeteoImg existingAnimeteoImg = _persistence.fetchByPrimaryKey(
			newAnimeteoImg.getPrimaryKey());

		Assert.assertNull(existingAnimeteoImg);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnimeteoImg();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoImg newAnimeteoImg = _persistence.create(pk);

		newAnimeteoImg.setName(RandomTestUtil.randomString());

		newAnimeteoImg.setType(RandomTestUtil.randomString());

		newAnimeteoImg.setInserted(RandomTestUtil.nextDate());

		newAnimeteoImg.setData(RandomTestUtil.randomString());

		_animeteoImgs.add(_persistence.update(newAnimeteoImg));

		AnimeteoImg existingAnimeteoImg = _persistence.findByPrimaryKey(
			newAnimeteoImg.getPrimaryKey());

		Assert.assertEquals(
			existingAnimeteoImg.getId(), newAnimeteoImg.getId());
		Assert.assertEquals(
			existingAnimeteoImg.getName(), newAnimeteoImg.getName());
		Assert.assertEquals(
			existingAnimeteoImg.getType(), newAnimeteoImg.getType());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnimeteoImg.getInserted()),
			Time.getShortTimestamp(newAnimeteoImg.getInserted()));
		Assert.assertEquals(
			existingAnimeteoImg.getData(), newAnimeteoImg.getData());
	}

	@Test
	public void testCountByImageData() throws Exception {
		_persistence.countByImageData("");

		_persistence.countByImageData("null");

		_persistence.countByImageData((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		AnimeteoImg existingAnimeteoImg = _persistence.findByPrimaryKey(
			newAnimeteoImg.getPrimaryKey());

		Assert.assertEquals(existingAnimeteoImg, newAnimeteoImg);
	}

	@Test(expected = NoSuchAnimeteoImgException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnimeteoImg> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"animeteo_AnimeteoImg", "id", true, "name", true, "type", true,
			"inserted", true, "data", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		AnimeteoImg existingAnimeteoImg = _persistence.fetchByPrimaryKey(
			newAnimeteoImg.getPrimaryKey());

		Assert.assertEquals(existingAnimeteoImg, newAnimeteoImg);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoImg missingAnimeteoImg = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnimeteoImg);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnimeteoImg newAnimeteoImg1 = addAnimeteoImg();
		AnimeteoImg newAnimeteoImg2 = addAnimeteoImg();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnimeteoImg1.getPrimaryKey());
		primaryKeys.add(newAnimeteoImg2.getPrimaryKey());

		Map<Serializable, AnimeteoImg> animeteoImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, animeteoImgs.size());
		Assert.assertEquals(
			newAnimeteoImg1, animeteoImgs.get(newAnimeteoImg1.getPrimaryKey()));
		Assert.assertEquals(
			newAnimeteoImg2, animeteoImgs.get(newAnimeteoImg2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnimeteoImg> animeteoImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(animeteoImgs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnimeteoImg.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnimeteoImg> animeteoImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, animeteoImgs.size());
		Assert.assertEquals(
			newAnimeteoImg, animeteoImgs.get(newAnimeteoImg.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnimeteoImg> animeteoImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(animeteoImgs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnimeteoImg.getPrimaryKey());

		Map<Serializable, AnimeteoImg> animeteoImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, animeteoImgs.size());
		Assert.assertEquals(
			newAnimeteoImg, animeteoImgs.get(newAnimeteoImg.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnimeteoImgLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnimeteoImg>() {

				@Override
				public void performAction(AnimeteoImg animeteoImg) {
					Assert.assertNotNull(animeteoImg);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnimeteoImg.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnimeteoImg.getId()));

		List<AnimeteoImg> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnimeteoImg existingAnimeteoImg = result.get(0);

		Assert.assertEquals(existingAnimeteoImg, newAnimeteoImg);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnimeteoImg.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnimeteoImg> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnimeteoImg newAnimeteoImg = addAnimeteoImg();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnimeteoImg.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnimeteoImg.getId();

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
			AnimeteoImg.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnimeteoImg addAnimeteoImg() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoImg animeteoImg = _persistence.create(pk);

		animeteoImg.setName(RandomTestUtil.randomString());

		animeteoImg.setType(RandomTestUtil.randomString());

		animeteoImg.setInserted(RandomTestUtil.nextDate());

		animeteoImg.setData(RandomTestUtil.randomString());

		_animeteoImgs.add(_persistence.update(animeteoImg));

		return animeteoImg;
	}

	private List<AnimeteoImg> _animeteoImgs = new ArrayList<AnimeteoImg>();
	private AnimeteoImgPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}