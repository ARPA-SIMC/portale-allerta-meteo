/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.service.persistence.test;

import allerta.dewetra.exception.NoSuchHRWException;
import allerta.dewetra.model.HRW;
import allerta.dewetra.service.HRWLocalServiceUtil;
import allerta.dewetra.service.persistence.HRWPersistence;
import allerta.dewetra.service.persistence.HRWUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class HRWPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.dewetra.service"));

	@Before
	public void setUp() {
		_persistence = HRWUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<HRW> iterator = _hrws.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HRW hrw = _persistence.create(pk);

		Assert.assertNotNull(hrw);

		Assert.assertEquals(hrw.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		HRW newHRW = addHRW();

		_persistence.remove(newHRW);

		HRW existingHRW = _persistence.fetchByPrimaryKey(
			newHRW.getPrimaryKey());

		Assert.assertNull(existingHRW);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addHRW();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HRW newHRW = _persistence.create(pk);

		newHRW.setComune(RandomTestUtil.randomString());

		newHRW.setTimestamp(RandomTestUtil.nextDate());

		newHRW.setHRI(RandomTestUtil.nextDouble());

		newHRW.setSSI(RandomTestUtil.nextDouble());

		newHRW.setSRI(RandomTestUtil.nextDouble());

		newHRW.setVMI(RandomTestUtil.nextDouble());

		newHRW.setVIL(RandomTestUtil.nextDouble());

		newHRW.setPOH(RandomTestUtil.nextDouble());

		newHRW.setETM(RandomTestUtil.nextDouble());

		newHRW.setTOP(RandomTestUtil.nextDouble());

		newHRW.setLGT(RandomTestUtil.nextDouble());

		newHRW.setPers(RandomTestUtil.nextDouble());

		newHRW.setSRT(RandomTestUtil.nextDouble());

		newHRW.setSRT_3(RandomTestUtil.nextDouble());

		newHRW.setSRT_6(RandomTestUtil.nextDouble());

		newHRW.setVel(RandomTestUtil.nextDouble());

		newHRW.setDir(RandomTestUtil.nextDouble());

		_hrws.add(_persistence.update(newHRW));

		HRW existingHRW = _persistence.findByPrimaryKey(newHRW.getPrimaryKey());

		Assert.assertEquals(existingHRW.getId(), newHRW.getId());
		Assert.assertEquals(existingHRW.getComune(), newHRW.getComune());
		Assert.assertEquals(
			Time.getShortTimestamp(existingHRW.getTimestamp()),
			Time.getShortTimestamp(newHRW.getTimestamp()));
		AssertUtils.assertEquals(existingHRW.getHRI(), newHRW.getHRI());
		AssertUtils.assertEquals(existingHRW.getSSI(), newHRW.getSSI());
		AssertUtils.assertEquals(existingHRW.getSRI(), newHRW.getSRI());
		AssertUtils.assertEquals(existingHRW.getVMI(), newHRW.getVMI());
		AssertUtils.assertEquals(existingHRW.getVIL(), newHRW.getVIL());
		AssertUtils.assertEquals(existingHRW.getPOH(), newHRW.getPOH());
		AssertUtils.assertEquals(existingHRW.getETM(), newHRW.getETM());
		AssertUtils.assertEquals(existingHRW.getTOP(), newHRW.getTOP());
		AssertUtils.assertEquals(existingHRW.getLGT(), newHRW.getLGT());
		AssertUtils.assertEquals(existingHRW.getPers(), newHRW.getPers());
		AssertUtils.assertEquals(existingHRW.getSRT(), newHRW.getSRT());
		AssertUtils.assertEquals(existingHRW.getSRT_3(), newHRW.getSRT_3());
		AssertUtils.assertEquals(existingHRW.getSRT_6(), newHRW.getSRT_6());
		AssertUtils.assertEquals(existingHRW.getVel(), newHRW.getVel());
		AssertUtils.assertEquals(existingHRW.getDir(), newHRW.getDir());
	}

	@Test
	public void testCountByComune() throws Exception {
		_persistence.countByComune("");

		_persistence.countByComune("null");

		_persistence.countByComune((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		HRW newHRW = addHRW();

		HRW existingHRW = _persistence.findByPrimaryKey(newHRW.getPrimaryKey());

		Assert.assertEquals(existingHRW, newHRW);
	}

	@Test(expected = NoSuchHRWException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<HRW> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DEWETRA_HRW", "id", true, "comune", true, "timestamp", true, "HRI",
			true, "SSI", true, "SRI", true, "VMI", true, "VIL", true, "POH",
			true, "ETM", true, "TOP", true, "LGT", true, "Pers", true, "SRT",
			true, "SRT_3", true, "SRT_6", true, "Vel", true, "Dir", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		HRW newHRW = addHRW();

		HRW existingHRW = _persistence.fetchByPrimaryKey(
			newHRW.getPrimaryKey());

		Assert.assertEquals(existingHRW, newHRW);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HRW missingHRW = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingHRW);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		HRW newHRW1 = addHRW();
		HRW newHRW2 = addHRW();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHRW1.getPrimaryKey());
		primaryKeys.add(newHRW2.getPrimaryKey());

		Map<Serializable, HRW> hrws = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, hrws.size());
		Assert.assertEquals(newHRW1, hrws.get(newHRW1.getPrimaryKey()));
		Assert.assertEquals(newHRW2, hrws.get(newHRW2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, HRW> hrws = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(hrws.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		HRW newHRW = addHRW();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHRW.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, HRW> hrws = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, hrws.size());
		Assert.assertEquals(newHRW, hrws.get(newHRW.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, HRW> hrws = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(hrws.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		HRW newHRW = addHRW();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHRW.getPrimaryKey());

		Map<Serializable, HRW> hrws = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, hrws.size());
		Assert.assertEquals(newHRW, hrws.get(newHRW.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			HRWLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<HRW>() {

				@Override
				public void performAction(HRW hrw) {
					Assert.assertNotNull(hrw);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		HRW newHRW = addHRW();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HRW.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newHRW.getId()));

		List<HRW> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		HRW existingHRW = result.get(0);

		Assert.assertEquals(existingHRW, newHRW);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HRW.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<HRW> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		HRW newHRW = addHRW();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HRW.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newHRW.getId();

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
			HRW.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected HRW addHRW() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HRW hrw = _persistence.create(pk);

		hrw.setComune(RandomTestUtil.randomString());

		hrw.setTimestamp(RandomTestUtil.nextDate());

		hrw.setHRI(RandomTestUtil.nextDouble());

		hrw.setSSI(RandomTestUtil.nextDouble());

		hrw.setSRI(RandomTestUtil.nextDouble());

		hrw.setVMI(RandomTestUtil.nextDouble());

		hrw.setVIL(RandomTestUtil.nextDouble());

		hrw.setPOH(RandomTestUtil.nextDouble());

		hrw.setETM(RandomTestUtil.nextDouble());

		hrw.setTOP(RandomTestUtil.nextDouble());

		hrw.setLGT(RandomTestUtil.nextDouble());

		hrw.setPers(RandomTestUtil.nextDouble());

		hrw.setSRT(RandomTestUtil.nextDouble());

		hrw.setSRT_3(RandomTestUtil.nextDouble());

		hrw.setSRT_6(RandomTestUtil.nextDouble());

		hrw.setVel(RandomTestUtil.nextDouble());

		hrw.setDir(RandomTestUtil.nextDouble());

		_hrws.add(_persistence.update(hrw));

		return hrw;
	}

	private List<HRW> _hrws = new ArrayList<HRW>();
	private HRWPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}