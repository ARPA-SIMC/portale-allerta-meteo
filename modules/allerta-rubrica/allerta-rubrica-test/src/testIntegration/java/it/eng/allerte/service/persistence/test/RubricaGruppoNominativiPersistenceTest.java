/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPersistence;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiUtil;

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
public class RubricaGruppoNominativiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaGruppoNominativiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaGruppoNominativi> iterator =
			_rubricaGruppoNominativis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		RubricaGruppoNominativiPK pk = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoNominativi rubricaGruppoNominativi = _persistence.create(
			pk);

		Assert.assertNotNull(rubricaGruppoNominativi);

		Assert.assertEquals(rubricaGruppoNominativi.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		_persistence.remove(newRubricaGruppoNominativi);

		RubricaGruppoNominativi existingRubricaGruppoNominativi =
			_persistence.fetchByPrimaryKey(
				newRubricaGruppoNominativi.getPrimaryKey());

		Assert.assertNull(existingRubricaGruppoNominativi);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaGruppoNominativi();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		RubricaGruppoNominativiPK pk = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoNominativi newRubricaGruppoNominativi =
			_persistence.create(pk);

		newRubricaGruppoNominativi.setFK_RUOLO(RandomTestUtil.nextLong());

		newRubricaGruppoNominativi.setSPECIFICA_RUOLO(
			RandomTestUtil.randomString());

		_rubricaGruppoNominativis.add(
			_persistence.update(newRubricaGruppoNominativi));

		RubricaGruppoNominativi existingRubricaGruppoNominativi =
			_persistence.findByPrimaryKey(
				newRubricaGruppoNominativi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppoNominativi.getFK_GRUPPO(),
			newRubricaGruppoNominativi.getFK_GRUPPO());
		Assert.assertEquals(
			existingRubricaGruppoNominativi.getFK_NOMINATIVO(),
			newRubricaGruppoNominativi.getFK_NOMINATIVO());
		Assert.assertEquals(
			existingRubricaGruppoNominativi.getFK_RUOLO(),
			newRubricaGruppoNominativi.getFK_RUOLO());
		Assert.assertEquals(
			existingRubricaGruppoNominativi.getSPECIFICA_RUOLO(),
			newRubricaGruppoNominativi.getSPECIFICA_RUOLO());
	}

	@Test
	public void testCountByRubricaGruppoRuoloByNominativo() throws Exception {
		_persistence.countByRubricaGruppoRuoloByNominativo(
			RandomTestUtil.nextLong());

		_persistence.countByRubricaGruppoRuoloByNominativo(0L);
	}

	@Test
	public void testCountByRubricaGruppoRuoloByGruppo() throws Exception {
		_persistence.countByRubricaGruppoRuoloByGruppo(
			RandomTestUtil.nextLong());

		_persistence.countByRubricaGruppoRuoloByGruppo(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		RubricaGruppoNominativi existingRubricaGruppoNominativi =
			_persistence.findByPrimaryKey(
				newRubricaGruppoNominativi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppoNominativi, newRubricaGruppoNominativi);
	}

	@Test(expected = NoSuchRubricaGruppoNominativiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		RubricaGruppoNominativiPK pk = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		RubricaGruppoNominativi existingRubricaGruppoNominativi =
			_persistence.fetchByPrimaryKey(
				newRubricaGruppoNominativi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppoNominativi, newRubricaGruppoNominativi);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		RubricaGruppoNominativiPK pk = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoNominativi missingRubricaGruppoNominativi =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaGruppoNominativi);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaGruppoNominativi newRubricaGruppoNominativi1 =
			addRubricaGruppoNominativi();
		RubricaGruppoNominativi newRubricaGruppoNominativi2 =
			addRubricaGruppoNominativi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppoNominativi1.getPrimaryKey());
		primaryKeys.add(newRubricaGruppoNominativi2.getPrimaryKey());

		Map<Serializable, RubricaGruppoNominativi> rubricaGruppoNominativis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaGruppoNominativis.size());
		Assert.assertEquals(
			newRubricaGruppoNominativi1,
			rubricaGruppoNominativis.get(
				newRubricaGruppoNominativi1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaGruppoNominativi2,
			rubricaGruppoNominativis.get(
				newRubricaGruppoNominativi2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		RubricaGruppoNominativiPK pk1 = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoNominativiPK pk2 = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaGruppoNominativi> rubricaGruppoNominativis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaGruppoNominativis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		RubricaGruppoNominativiPK pk = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppoNominativi.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaGruppoNominativi> rubricaGruppoNominativis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaGruppoNominativis.size());
		Assert.assertEquals(
			newRubricaGruppoNominativi,
			rubricaGruppoNominativis.get(
				newRubricaGruppoNominativi.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaGruppoNominativi> rubricaGruppoNominativis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaGruppoNominativis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppoNominativi.getPrimaryKey());

		Map<Serializable, RubricaGruppoNominativi> rubricaGruppoNominativis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaGruppoNominativis.size());
		Assert.assertEquals(
			newRubricaGruppoNominativi,
			rubricaGruppoNominativis.get(
				newRubricaGruppoNominativi.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaGruppoNominativiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RubricaGruppoNominativi>() {

				@Override
				public void performAction(
					RubricaGruppoNominativi rubricaGruppoNominativi) {

					Assert.assertNotNull(rubricaGruppoNominativi);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoNominativi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_GRUPPO", newRubricaGruppoNominativi.getFK_GRUPPO()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_NOMINATIVO",
				newRubricaGruppoNominativi.getFK_NOMINATIVO()));

		List<RubricaGruppoNominativi> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaGruppoNominativi existingRubricaGruppoNominativi = result.get(0);

		Assert.assertEquals(
			existingRubricaGruppoNominativi, newRubricaGruppoNominativi);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoNominativi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_GRUPPO", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_NOMINATIVO", RandomTestUtil.nextLong()));

		List<RubricaGruppoNominativi> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaGruppoNominativi newRubricaGruppoNominativi =
			addRubricaGruppoNominativi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoNominativi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.FK_GRUPPO"));

		Object newFK_GRUPPO = newRubricaGruppoNominativi.getFK_GRUPPO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.FK_GRUPPO", new Object[] {newFK_GRUPPO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFK_GRUPPO = result.get(0);

		Assert.assertEquals(existingFK_GRUPPO, newFK_GRUPPO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoNominativi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.FK_GRUPPO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.FK_GRUPPO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaGruppoNominativi addRubricaGruppoNominativi()
		throws Exception {

		RubricaGruppoNominativiPK pk = new RubricaGruppoNominativiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoNominativi rubricaGruppoNominativi = _persistence.create(
			pk);

		rubricaGruppoNominativi.setFK_RUOLO(RandomTestUtil.nextLong());

		rubricaGruppoNominativi.setSPECIFICA_RUOLO(
			RandomTestUtil.randomString());

		_rubricaGruppoNominativis.add(
			_persistence.update(rubricaGruppoNominativi));

		return rubricaGruppoNominativi;
	}

	private List<RubricaGruppoNominativi> _rubricaGruppoNominativis =
		new ArrayList<RubricaGruppoNominativi>();
	private RubricaGruppoNominativiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}