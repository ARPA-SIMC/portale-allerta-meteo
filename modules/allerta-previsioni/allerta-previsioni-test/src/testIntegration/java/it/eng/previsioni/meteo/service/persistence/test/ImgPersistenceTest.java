/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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

import it.eng.previsioni.meteo.exception.NoSuchImgException;
import it.eng.previsioni.meteo.model.Img;
import it.eng.previsioni.meteo.service.ImgLocalServiceUtil;
import it.eng.previsioni.meteo.service.persistence.ImgPersistence;
import it.eng.previsioni.meteo.service.persistence.ImgUtil;

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
public class ImgPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.previsioni.meteo.service"));

	@Before
	public void setUp() {
		_persistence = ImgUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Img> iterator = _imgs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Img img = _persistence.create(pk);

		Assert.assertNotNull(img);

		Assert.assertEquals(img.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Img newImg = addImg();

		_persistence.remove(newImg);

		Img existingImg = _persistence.fetchByPrimaryKey(
			newImg.getPrimaryKey());

		Assert.assertNull(existingImg);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addImg();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Img newImg = _persistence.create(pk);

		newImg.setDaypart(RandomTestUtil.randomString());

		newImg.setDay(RandomTestUtil.randomString());

		newImg.setProvincia(RandomTestUtil.randomString());

		newImg.setInserted(RandomTestUtil.nextDate());

		newImg.setData(RandomTestUtil.randomString());

		_imgs.add(_persistence.update(newImg));

		Img existingImg = _persistence.findByPrimaryKey(newImg.getPrimaryKey());

		Assert.assertEquals(existingImg.getId(), newImg.getId());
		Assert.assertEquals(existingImg.getDaypart(), newImg.getDaypart());
		Assert.assertEquals(existingImg.getDay(), newImg.getDay());
		Assert.assertEquals(existingImg.getProvincia(), newImg.getProvincia());
		Assert.assertEquals(
			Time.getShortTimestamp(existingImg.getInserted()),
			Time.getShortTimestamp(newImg.getInserted()));
		Assert.assertEquals(existingImg.getData(), newImg.getData());
	}

	@Test
	public void testCountByday() throws Exception {
		_persistence.countByday("");

		_persistence.countByday("null");

		_persistence.countByday((String)null);
	}

	@Test
	public void testCountByDay_Province() throws Exception {
		_persistence.countByDay_Province("", "");

		_persistence.countByDay_Province("null", "null");

		_persistence.countByDay_Province((String)null, (String)null);
	}

	@Test
	public void testCountByPart_Day_Province() throws Exception {
		_persistence.countByPart_Day_Province("", "", "");

		_persistence.countByPart_Day_Province("null", "null", "null");

		_persistence.countByPart_Day_Province(
			(String)null, (String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Img newImg = addImg();

		Img existingImg = _persistence.findByPrimaryKey(newImg.getPrimaryKey());

		Assert.assertEquals(existingImg, newImg);
	}

	@Test(expected = NoSuchImgException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Img> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"prev_meteo_Img", "id", true, "daypart", true, "day", true,
			"provincia", true, "inserted", true, "data", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Img newImg = addImg();

		Img existingImg = _persistence.fetchByPrimaryKey(
			newImg.getPrimaryKey());

		Assert.assertEquals(existingImg, newImg);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Img missingImg = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingImg);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Img newImg1 = addImg();
		Img newImg2 = addImg();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newImg1.getPrimaryKey());
		primaryKeys.add(newImg2.getPrimaryKey());

		Map<Serializable, Img> imgs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, imgs.size());
		Assert.assertEquals(newImg1, imgs.get(newImg1.getPrimaryKey()));
		Assert.assertEquals(newImg2, imgs.get(newImg2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Img> imgs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(imgs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Img newImg = addImg();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newImg.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Img> imgs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, imgs.size());
		Assert.assertEquals(newImg, imgs.get(newImg.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Img> imgs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(imgs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Img newImg = addImg();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newImg.getPrimaryKey());

		Map<Serializable, Img> imgs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, imgs.size());
		Assert.assertEquals(newImg, imgs.get(newImg.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ImgLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Img>() {

				@Override
				public void performAction(Img img) {
					Assert.assertNotNull(img);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Img newImg = addImg();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Img.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newImg.getId()));

		List<Img> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Img existingImg = result.get(0);

		Assert.assertEquals(existingImg, newImg);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Img.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Img> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Img newImg = addImg();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Img.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newImg.getId();

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
			Img.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Img newImg = addImg();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newImg.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Img newImg = addImg();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Img.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newImg.getId()));

		List<Img> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Img img) {
		Assert.assertEquals(
			img.getDaypart(),
			ReflectionTestUtil.invoke(
				img, "getColumnOriginalValue", new Class<?>[] {String.class},
				"daypart"));
		Assert.assertEquals(
			img.getDay(),
			ReflectionTestUtil.invoke(
				img, "getColumnOriginalValue", new Class<?>[] {String.class},
				"day"));
		Assert.assertEquals(
			img.getProvincia(),
			ReflectionTestUtil.invoke(
				img, "getColumnOriginalValue", new Class<?>[] {String.class},
				"provincia"));
	}

	protected Img addImg() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Img img = _persistence.create(pk);

		img.setDaypart(RandomTestUtil.randomString());

		img.setDay(RandomTestUtil.randomString());

		img.setProvincia(RandomTestUtil.randomString());

		img.setInserted(RandomTestUtil.nextDate());

		img.setData(RandomTestUtil.randomString());

		_imgs.add(_persistence.update(img));

		return img;
	}

	private List<Img> _imgs = new ArrayList<Img>();
	private ImgPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}