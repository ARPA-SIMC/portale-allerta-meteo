/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.test;

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

import it.eng.allerter.exception.NoSuchAreaException;
import it.eng.allerter.model.Area;
import it.eng.allerter.service.AreaLocalServiceUtil;
import it.eng.allerter.service.persistence.AreaPersistence;
import it.eng.allerter.service.persistence.AreaUtil;

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
public class AreaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = AreaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Area> iterator = _areas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Area area = _persistence.create(pk);

		Assert.assertNotNull(area);

		Assert.assertEquals(area.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Area newArea = addArea();

		_persistence.remove(newArea);

		Area existingArea = _persistence.fetchByPrimaryKey(
			newArea.getPrimaryKey());

		Assert.assertNull(existingArea);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addArea();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Area newArea = _persistence.create(pk);

		newArea.setUuid(RandomTestUtil.randomString());

		newArea.setGroupId(RandomTestUtil.nextLong());

		newArea.setCompanyId(RandomTestUtil.nextLong());

		newArea.setUserId(RandomTestUtil.nextLong());

		newArea.setUserName(RandomTestUtil.randomString());

		newArea.setCreateDate(RandomTestUtil.nextDate());

		newArea.setModifiedDate(RandomTestUtil.nextDate());

		newArea.setNome(RandomTestUtil.randomString());

		newArea.setTipoArea(RandomTestUtil.randomString());

		newArea.setCostiero(RandomTestUtil.randomBoolean());

		newArea.setDataInizio(RandomTestUtil.nextDate());

		newArea.setDataFine(RandomTestUtil.nextDate());

		newArea.setParentId(RandomTestUtil.nextLong());

		_areas.add(_persistence.update(newArea));

		Area existingArea = _persistence.findByPrimaryKey(
			newArea.getPrimaryKey());

		Assert.assertEquals(existingArea.getUuid(), newArea.getUuid());
		Assert.assertEquals(existingArea.getAreaId(), newArea.getAreaId());
		Assert.assertEquals(existingArea.getGroupId(), newArea.getGroupId());
		Assert.assertEquals(
			existingArea.getCompanyId(), newArea.getCompanyId());
		Assert.assertEquals(existingArea.getUserId(), newArea.getUserId());
		Assert.assertEquals(existingArea.getUserName(), newArea.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingArea.getCreateDate()),
			Time.getShortTimestamp(newArea.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingArea.getModifiedDate()),
			Time.getShortTimestamp(newArea.getModifiedDate()));
		Assert.assertEquals(existingArea.getNome(), newArea.getNome());
		Assert.assertEquals(existingArea.getTipoArea(), newArea.getTipoArea());
		Assert.assertEquals(existingArea.isCostiero(), newArea.isCostiero());
		Assert.assertEquals(
			Time.getShortTimestamp(existingArea.getDataInizio()),
			Time.getShortTimestamp(newArea.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingArea.getDataFine()),
			Time.getShortTimestamp(newArea.getDataFine()));
		Assert.assertEquals(existingArea.getParentId(), newArea.getParentId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByNome() throws Exception {
		_persistence.countByNome("");

		_persistence.countByNome("null");

		_persistence.countByNome((String)null);
	}

	@Test
	public void testCountByTipoArea() throws Exception {
		_persistence.countByTipoArea("");

		_persistence.countByTipoArea("null");

		_persistence.countByTipoArea((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Area newArea = addArea();

		Area existingArea = _persistence.findByPrimaryKey(
			newArea.getPrimaryKey());

		Assert.assertEquals(existingArea, newArea);
	}

	@Test(expected = NoSuchAreaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Area> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_Area", "uuid", true, "areaId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "nome", true, "tipoArea", true,
			"costiero", true, "dataInizio", true, "dataFine", true, "parentId",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Area newArea = addArea();

		Area existingArea = _persistence.fetchByPrimaryKey(
			newArea.getPrimaryKey());

		Assert.assertEquals(existingArea, newArea);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Area missingArea = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingArea);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Area newArea1 = addArea();
		Area newArea2 = addArea();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newArea1.getPrimaryKey());
		primaryKeys.add(newArea2.getPrimaryKey());

		Map<Serializable, Area> areas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, areas.size());
		Assert.assertEquals(newArea1, areas.get(newArea1.getPrimaryKey()));
		Assert.assertEquals(newArea2, areas.get(newArea2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Area> areas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(areas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Area newArea = addArea();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newArea.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Area> areas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, areas.size());
		Assert.assertEquals(newArea, areas.get(newArea.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Area> areas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(areas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Area newArea = addArea();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newArea.getPrimaryKey());

		Map<Serializable, Area> areas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, areas.size());
		Assert.assertEquals(newArea, areas.get(newArea.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AreaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Area>() {

				@Override
				public void performAction(Area area) {
					Assert.assertNotNull(area);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Area newArea = addArea();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Area.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("areaId", newArea.getAreaId()));

		List<Area> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Area existingArea = result.get(0);

		Assert.assertEquals(existingArea, newArea);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Area.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("areaId", RandomTestUtil.nextLong()));

		List<Area> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Area newArea = addArea();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Area.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("areaId"));

		Object newAreaId = newArea.getAreaId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("areaId", new Object[] {newAreaId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAreaId = result.get(0);

		Assert.assertEquals(existingAreaId, newAreaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Area.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("areaId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"areaId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Area newArea = addArea();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newArea.getPrimaryKey()));
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

		Area newArea = addArea();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Area.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("areaId", newArea.getAreaId()));

		List<Area> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Area area) {
		Assert.assertEquals(
			area.getUuid(),
			ReflectionTestUtil.invoke(
				area, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(area.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				area, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected Area addArea() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Area area = _persistence.create(pk);

		area.setUuid(RandomTestUtil.randomString());

		area.setGroupId(RandomTestUtil.nextLong());

		area.setCompanyId(RandomTestUtil.nextLong());

		area.setUserId(RandomTestUtil.nextLong());

		area.setUserName(RandomTestUtil.randomString());

		area.setCreateDate(RandomTestUtil.nextDate());

		area.setModifiedDate(RandomTestUtil.nextDate());

		area.setNome(RandomTestUtil.randomString());

		area.setTipoArea(RandomTestUtil.randomString());

		area.setCostiero(RandomTestUtil.randomBoolean());

		area.setDataInizio(RandomTestUtil.nextDate());

		area.setDataFine(RandomTestUtil.nextDate());

		area.setParentId(RandomTestUtil.nextLong());

		_areas.add(_persistence.update(area));

		return area;
	}

	private List<Area> _areas = new ArrayList<Area>();
	private AreaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}