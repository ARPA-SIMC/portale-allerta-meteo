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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.service.PioggiaCumulativaLocalServiceUtil;
import it.eng.animazione.image.service.persistence.PioggiaCumulativaPersistence;
import it.eng.animazione.image.service.persistence.PioggiaCumulativaUtil;

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
public class PioggiaCumulativaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animazione.image.service"));

	@Before
	public void setUp() {
		_persistence = PioggiaCumulativaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PioggiaCumulativa> iterator = _pioggiaCumulativas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PioggiaCumulativa pioggiaCumulativa = _persistence.create(pk);

		Assert.assertNotNull(pioggiaCumulativa);

		Assert.assertEquals(pioggiaCumulativa.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		_persistence.remove(newPioggiaCumulativa);

		PioggiaCumulativa existingPioggiaCumulativa =
			_persistence.fetchByPrimaryKey(
				newPioggiaCumulativa.getPrimaryKey());

		Assert.assertNull(existingPioggiaCumulativa);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPioggiaCumulativa();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PioggiaCumulativa newPioggiaCumulativa = _persistence.create(pk);

		newPioggiaCumulativa.setNome(RandomTestUtil.randomString());

		newPioggiaCumulativa.setCumulazione(RandomTestUtil.randomString());

		newPioggiaCumulativa.setInzioCumulazione(RandomTestUtil.nextDate());

		newPioggiaCumulativa.setFineCumulazione(RandomTestUtil.nextDate());

		newPioggiaCumulativa.setImgData(RandomTestUtil.randomString());

		_pioggiaCumulativas.add(_persistence.update(newPioggiaCumulativa));

		PioggiaCumulativa existingPioggiaCumulativa =
			_persistence.findByPrimaryKey(newPioggiaCumulativa.getPrimaryKey());

		Assert.assertEquals(
			existingPioggiaCumulativa.getId(), newPioggiaCumulativa.getId());
		Assert.assertEquals(
			existingPioggiaCumulativa.getNome(),
			newPioggiaCumulativa.getNome());
		Assert.assertEquals(
			existingPioggiaCumulativa.getCumulazione(),
			newPioggiaCumulativa.getCumulazione());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingPioggiaCumulativa.getInzioCumulazione()),
			Time.getShortTimestamp(newPioggiaCumulativa.getInzioCumulazione()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingPioggiaCumulativa.getFineCumulazione()),
			Time.getShortTimestamp(newPioggiaCumulativa.getFineCumulazione()));
		Assert.assertEquals(
			existingPioggiaCumulativa.getImgData(),
			newPioggiaCumulativa.getImgData());
	}

	@Test
	public void testCountByCumulazione() throws Exception {
		_persistence.countByCumulazione("");

		_persistence.countByCumulazione("null");

		_persistence.countByCumulazione((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		PioggiaCumulativa existingPioggiaCumulativa =
			_persistence.findByPrimaryKey(newPioggiaCumulativa.getPrimaryKey());

		Assert.assertEquals(existingPioggiaCumulativa, newPioggiaCumulativa);
	}

	@Test(expected = NoSuchPioggiaCumulativaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PioggiaCumulativa> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"img_animazioni_PioggiaCumulativa", "id", true, "nome", true,
			"cumulazione", true, "inzioCumulazione", true, "fineCumulazione",
			true, "imgData", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		PioggiaCumulativa existingPioggiaCumulativa =
			_persistence.fetchByPrimaryKey(
				newPioggiaCumulativa.getPrimaryKey());

		Assert.assertEquals(existingPioggiaCumulativa, newPioggiaCumulativa);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PioggiaCumulativa missingPioggiaCumulativa =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPioggiaCumulativa);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PioggiaCumulativa newPioggiaCumulativa1 = addPioggiaCumulativa();
		PioggiaCumulativa newPioggiaCumulativa2 = addPioggiaCumulativa();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPioggiaCumulativa1.getPrimaryKey());
		primaryKeys.add(newPioggiaCumulativa2.getPrimaryKey());

		Map<Serializable, PioggiaCumulativa> pioggiaCumulativas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, pioggiaCumulativas.size());
		Assert.assertEquals(
			newPioggiaCumulativa1,
			pioggiaCumulativas.get(newPioggiaCumulativa1.getPrimaryKey()));
		Assert.assertEquals(
			newPioggiaCumulativa2,
			pioggiaCumulativas.get(newPioggiaCumulativa2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PioggiaCumulativa> pioggiaCumulativas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pioggiaCumulativas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPioggiaCumulativa.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PioggiaCumulativa> pioggiaCumulativas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pioggiaCumulativas.size());
		Assert.assertEquals(
			newPioggiaCumulativa,
			pioggiaCumulativas.get(newPioggiaCumulativa.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PioggiaCumulativa> pioggiaCumulativas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pioggiaCumulativas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPioggiaCumulativa.getPrimaryKey());

		Map<Serializable, PioggiaCumulativa> pioggiaCumulativas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pioggiaCumulativas.size());
		Assert.assertEquals(
			newPioggiaCumulativa,
			pioggiaCumulativas.get(newPioggiaCumulativa.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PioggiaCumulativaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<PioggiaCumulativa>() {

				@Override
				public void performAction(PioggiaCumulativa pioggiaCumulativa) {
					Assert.assertNotNull(pioggiaCumulativa);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PioggiaCumulativa.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newPioggiaCumulativa.getId()));

		List<PioggiaCumulativa> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PioggiaCumulativa existingPioggiaCumulativa = result.get(0);

		Assert.assertEquals(existingPioggiaCumulativa, newPioggiaCumulativa);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PioggiaCumulativa.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<PioggiaCumulativa> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PioggiaCumulativa newPioggiaCumulativa = addPioggiaCumulativa();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PioggiaCumulativa.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newPioggiaCumulativa.getId();

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
			PioggiaCumulativa.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PioggiaCumulativa addPioggiaCumulativa() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PioggiaCumulativa pioggiaCumulativa = _persistence.create(pk);

		pioggiaCumulativa.setNome(RandomTestUtil.randomString());

		pioggiaCumulativa.setCumulazione(RandomTestUtil.randomString());

		pioggiaCumulativa.setInzioCumulazione(RandomTestUtil.nextDate());

		pioggiaCumulativa.setFineCumulazione(RandomTestUtil.nextDate());

		pioggiaCumulativa.setImgData(RandomTestUtil.randomString());

		_pioggiaCumulativas.add(_persistence.update(pioggiaCumulativa));

		return pioggiaCumulativa;
	}

	private List<PioggiaCumulativa> _pioggiaCumulativas =
		new ArrayList<PioggiaCumulativa>();
	private PioggiaCumulativaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}