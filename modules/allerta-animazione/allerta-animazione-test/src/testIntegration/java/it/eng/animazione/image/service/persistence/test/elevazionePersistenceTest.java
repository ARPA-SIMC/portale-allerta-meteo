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

import it.eng.animazione.image.exception.NoSuchelevazioneException;
import it.eng.animazione.image.model.elevazione;
import it.eng.animazione.image.service.elevazioneLocalServiceUtil;
import it.eng.animazione.image.service.persistence.elevazionePersistence;
import it.eng.animazione.image.service.persistence.elevazioneUtil;

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
public class elevazionePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.animazione.image.service"));

	@Before
	public void setUp() {
		_persistence = elevazioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<elevazione> iterator = _elevaziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		elevazione elevazione = _persistence.create(pk);

		Assert.assertNotNull(elevazione);

		Assert.assertEquals(elevazione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		elevazione newelevazione = addelevazione();

		_persistence.remove(newelevazione);

		elevazione existingelevazione = _persistence.fetchByPrimaryKey(
			newelevazione.getPrimaryKey());

		Assert.assertNull(existingelevazione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addelevazione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		elevazione newelevazione = _persistence.create(pk);

		newelevazione.setIm(RandomTestUtil.randomString());

		newelevazione.setText_LOC(RandomTestUtil.randomString());

		newelevazione.setTs_UTC(RandomTestUtil.nextLong());

		newelevazione.setImgData(RandomTestUtil.randomString());

		_elevaziones.add(_persistence.update(newelevazione));

		elevazione existingelevazione = _persistence.findByPrimaryKey(
			newelevazione.getPrimaryKey());

		Assert.assertEquals(existingelevazione.getId(), newelevazione.getId());
		Assert.assertEquals(existingelevazione.getIm(), newelevazione.getIm());
		Assert.assertEquals(
			existingelevazione.getText_LOC(), newelevazione.getText_LOC());
		Assert.assertEquals(
			existingelevazione.getTs_UTC(), newelevazione.getTs_UTC());
		Assert.assertEquals(
			existingelevazione.getImgData(), newelevazione.getImgData());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		elevazione newelevazione = addelevazione();

		elevazione existingelevazione = _persistence.findByPrimaryKey(
			newelevazione.getPrimaryKey());

		Assert.assertEquals(existingelevazione, newelevazione);
	}

	@Test(expected = NoSuchelevazioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<elevazione> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"img_animazioni_elevazione", "id", true, "im", true, "text_LOC",
			true, "ts_UTC", true, "imgData", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		elevazione newelevazione = addelevazione();

		elevazione existingelevazione = _persistence.fetchByPrimaryKey(
			newelevazione.getPrimaryKey());

		Assert.assertEquals(existingelevazione, newelevazione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		elevazione missingelevazione = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingelevazione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		elevazione newelevazione1 = addelevazione();
		elevazione newelevazione2 = addelevazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newelevazione1.getPrimaryKey());
		primaryKeys.add(newelevazione2.getPrimaryKey());

		Map<Serializable, elevazione> elevaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, elevaziones.size());
		Assert.assertEquals(
			newelevazione1, elevaziones.get(newelevazione1.getPrimaryKey()));
		Assert.assertEquals(
			newelevazione2, elevaziones.get(newelevazione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, elevazione> elevaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(elevaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		elevazione newelevazione = addelevazione();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newelevazione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, elevazione> elevaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, elevaziones.size());
		Assert.assertEquals(
			newelevazione, elevaziones.get(newelevazione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, elevazione> elevaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(elevaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		elevazione newelevazione = addelevazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newelevazione.getPrimaryKey());

		Map<Serializable, elevazione> elevaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, elevaziones.size());
		Assert.assertEquals(
			newelevazione, elevaziones.get(newelevazione.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			elevazioneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<elevazione>() {

				@Override
				public void performAction(elevazione elevazione) {
					Assert.assertNotNull(elevazione);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		elevazione newelevazione = addelevazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			elevazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newelevazione.getId()));

		List<elevazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		elevazione existingelevazione = result.get(0);

		Assert.assertEquals(existingelevazione, newelevazione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			elevazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<elevazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		elevazione newelevazione = addelevazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			elevazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newelevazione.getId();

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
			elevazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected elevazione addelevazione() throws Exception {
		long pk = RandomTestUtil.nextLong();

		elevazione elevazione = _persistence.create(pk);

		elevazione.setIm(RandomTestUtil.randomString());

		elevazione.setText_LOC(RandomTestUtil.randomString());

		elevazione.setTs_UTC(RandomTestUtil.nextLong());

		elevazione.setImgData(RandomTestUtil.randomString());

		_elevaziones.add(_persistence.update(elevazione));

		return elevazione;
	}

	private List<elevazione> _elevaziones = new ArrayList<elevazione>();
	private elevazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}