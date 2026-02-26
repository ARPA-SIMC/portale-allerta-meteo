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

import it.eng.animaeteo.exception.NoSuchAnimeteoSmallImgException;
import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.service.AnimeteoSmallImgLocalServiceUtil;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgPersistence;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgUtil;

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
public class AnimeteoSmallImgPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animaeteo.service"));

	@Before
	public void setUp() {
		_persistence = AnimeteoSmallImgUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnimeteoSmallImg> iterator = _animeteoSmallImgs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoSmallImg animeteoSmallImg = _persistence.create(pk);

		Assert.assertNotNull(animeteoSmallImg);

		Assert.assertEquals(animeteoSmallImg.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		_persistence.remove(newAnimeteoSmallImg);

		AnimeteoSmallImg existingAnimeteoSmallImg =
			_persistence.fetchByPrimaryKey(newAnimeteoSmallImg.getPrimaryKey());

		Assert.assertNull(existingAnimeteoSmallImg);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnimeteoSmallImg();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoSmallImg newAnimeteoSmallImg = _persistence.create(pk);

		newAnimeteoSmallImg.setName(RandomTestUtil.randomString());

		newAnimeteoSmallImg.setType(RandomTestUtil.randomString());

		newAnimeteoSmallImg.setInserted(RandomTestUtil.nextDate());

		newAnimeteoSmallImg.setData(RandomTestUtil.randomString());

		_animeteoSmallImgs.add(_persistence.update(newAnimeteoSmallImg));

		AnimeteoSmallImg existingAnimeteoSmallImg =
			_persistence.findByPrimaryKey(newAnimeteoSmallImg.getPrimaryKey());

		Assert.assertEquals(
			existingAnimeteoSmallImg.getId(), newAnimeteoSmallImg.getId());
		Assert.assertEquals(
			existingAnimeteoSmallImg.getName(), newAnimeteoSmallImg.getName());
		Assert.assertEquals(
			existingAnimeteoSmallImg.getType(), newAnimeteoSmallImg.getType());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnimeteoSmallImg.getInserted()),
			Time.getShortTimestamp(newAnimeteoSmallImg.getInserted()));
		Assert.assertEquals(
			existingAnimeteoSmallImg.getData(), newAnimeteoSmallImg.getData());
	}

	@Test
	public void testCountByImageData() throws Exception {
		_persistence.countByImageData("");

		_persistence.countByImageData("null");

		_persistence.countByImageData((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		AnimeteoSmallImg existingAnimeteoSmallImg =
			_persistence.findByPrimaryKey(newAnimeteoSmallImg.getPrimaryKey());

		Assert.assertEquals(existingAnimeteoSmallImg, newAnimeteoSmallImg);
	}

	@Test(expected = NoSuchAnimeteoSmallImgException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnimeteoSmallImg> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"animeteo_AnimeteoSmallImg", "id", true, "name", true, "type", true,
			"inserted", true, "data", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		AnimeteoSmallImg existingAnimeteoSmallImg =
			_persistence.fetchByPrimaryKey(newAnimeteoSmallImg.getPrimaryKey());

		Assert.assertEquals(existingAnimeteoSmallImg, newAnimeteoSmallImg);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoSmallImg missingAnimeteoSmallImg =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnimeteoSmallImg);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnimeteoSmallImg newAnimeteoSmallImg1 = addAnimeteoSmallImg();
		AnimeteoSmallImg newAnimeteoSmallImg2 = addAnimeteoSmallImg();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnimeteoSmallImg1.getPrimaryKey());
		primaryKeys.add(newAnimeteoSmallImg2.getPrimaryKey());

		Map<Serializable, AnimeteoSmallImg> animeteoSmallImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, animeteoSmallImgs.size());
		Assert.assertEquals(
			newAnimeteoSmallImg1,
			animeteoSmallImgs.get(newAnimeteoSmallImg1.getPrimaryKey()));
		Assert.assertEquals(
			newAnimeteoSmallImg2,
			animeteoSmallImgs.get(newAnimeteoSmallImg2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnimeteoSmallImg> animeteoSmallImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(animeteoSmallImgs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnimeteoSmallImg.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnimeteoSmallImg> animeteoSmallImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, animeteoSmallImgs.size());
		Assert.assertEquals(
			newAnimeteoSmallImg,
			animeteoSmallImgs.get(newAnimeteoSmallImg.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnimeteoSmallImg> animeteoSmallImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(animeteoSmallImgs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnimeteoSmallImg.getPrimaryKey());

		Map<Serializable, AnimeteoSmallImg> animeteoSmallImgs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, animeteoSmallImgs.size());
		Assert.assertEquals(
			newAnimeteoSmallImg,
			animeteoSmallImgs.get(newAnimeteoSmallImg.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnimeteoSmallImgLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnimeteoSmallImg>() {

				@Override
				public void performAction(AnimeteoSmallImg animeteoSmallImg) {
					Assert.assertNotNull(animeteoSmallImg);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnimeteoSmallImg.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnimeteoSmallImg.getId()));

		List<AnimeteoSmallImg> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnimeteoSmallImg existingAnimeteoSmallImg = result.get(0);

		Assert.assertEquals(existingAnimeteoSmallImg, newAnimeteoSmallImg);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnimeteoSmallImg.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnimeteoSmallImg> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnimeteoSmallImg newAnimeteoSmallImg = addAnimeteoSmallImg();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnimeteoSmallImg.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnimeteoSmallImg.getId();

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
			AnimeteoSmallImg.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnimeteoSmallImg addAnimeteoSmallImg() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnimeteoSmallImg animeteoSmallImg = _persistence.create(pk);

		animeteoSmallImg.setName(RandomTestUtil.randomString());

		animeteoSmallImg.setType(RandomTestUtil.randomString());

		animeteoSmallImg.setInserted(RandomTestUtil.nextDate());

		animeteoSmallImg.setData(RandomTestUtil.randomString());

		_animeteoSmallImgs.add(_persistence.update(animeteoSmallImg));

		return animeteoSmallImg;
	}

	private List<AnimeteoSmallImg> _animeteoSmallImgs =
		new ArrayList<AnimeteoSmallImg>();
	private AnimeteoSmallImgPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}