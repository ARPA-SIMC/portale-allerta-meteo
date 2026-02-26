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

import it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.RubricaGruppoGruppiLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPersistence;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiUtil;

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
public class RubricaGruppoGruppiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaGruppoGruppiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaGruppoGruppi> iterator =
			_rubricaGruppoGruppis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoGruppi rubricaGruppoGruppi = _persistence.create(pk);

		Assert.assertNotNull(rubricaGruppoGruppi);

		Assert.assertEquals(rubricaGruppoGruppi.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		_persistence.remove(newRubricaGruppoGruppi);

		RubricaGruppoGruppi existingRubricaGruppoGruppi =
			_persistence.fetchByPrimaryKey(
				newRubricaGruppoGruppi.getPrimaryKey());

		Assert.assertNull(existingRubricaGruppoGruppi);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaGruppoGruppi();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoGruppi newRubricaGruppoGruppi = _persistence.create(pk);

		_rubricaGruppoGruppis.add(_persistence.update(newRubricaGruppoGruppi));

		RubricaGruppoGruppi existingRubricaGruppoGruppi =
			_persistence.findByPrimaryKey(
				newRubricaGruppoGruppi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppoGruppi.getFK_GRUPPO_PADRE(),
			newRubricaGruppoGruppi.getFK_GRUPPO_PADRE());
		Assert.assertEquals(
			existingRubricaGruppoGruppi.getFK_GRUPPO_FIGLIO(),
			newRubricaGruppoGruppi.getFK_GRUPPO_FIGLIO());
	}

	@Test
	public void testCountByRubricaGruppoGruppoByPadre() throws Exception {
		_persistence.countByRubricaGruppoGruppoByPadre(
			RandomTestUtil.nextLong());

		_persistence.countByRubricaGruppoGruppoByPadre(0L);
	}

	@Test
	public void testCountByRubricaGruppoGruppoByFiglio() throws Exception {
		_persistence.countByRubricaGruppoGruppoByFiglio(
			RandomTestUtil.nextLong());

		_persistence.countByRubricaGruppoGruppoByFiglio(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		RubricaGruppoGruppi existingRubricaGruppoGruppi =
			_persistence.findByPrimaryKey(
				newRubricaGruppoGruppi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppoGruppi, newRubricaGruppoGruppi);
	}

	@Test(expected = NoSuchRubricaGruppoGruppiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		RubricaGruppoGruppi existingRubricaGruppoGruppi =
			_persistence.fetchByPrimaryKey(
				newRubricaGruppoGruppi.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppoGruppi, newRubricaGruppoGruppi);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoGruppi missingRubricaGruppoGruppi =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaGruppoGruppi);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaGruppoGruppi newRubricaGruppoGruppi1 = addRubricaGruppoGruppi();
		RubricaGruppoGruppi newRubricaGruppoGruppi2 = addRubricaGruppoGruppi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppoGruppi1.getPrimaryKey());
		primaryKeys.add(newRubricaGruppoGruppi2.getPrimaryKey());

		Map<Serializable, RubricaGruppoGruppi> rubricaGruppoGruppis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaGruppoGruppis.size());
		Assert.assertEquals(
			newRubricaGruppoGruppi1,
			rubricaGruppoGruppis.get(newRubricaGruppoGruppi1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaGruppoGruppi2,
			rubricaGruppoGruppis.get(newRubricaGruppoGruppi2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		RubricaGruppoGruppiPK pk1 = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoGruppiPK pk2 = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaGruppoGruppi> rubricaGruppoGruppis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaGruppoGruppis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppoGruppi.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaGruppoGruppi> rubricaGruppoGruppis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaGruppoGruppis.size());
		Assert.assertEquals(
			newRubricaGruppoGruppi,
			rubricaGruppoGruppis.get(newRubricaGruppoGruppi.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaGruppoGruppi> rubricaGruppoGruppis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaGruppoGruppis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppoGruppi.getPrimaryKey());

		Map<Serializable, RubricaGruppoGruppi> rubricaGruppoGruppis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaGruppoGruppis.size());
		Assert.assertEquals(
			newRubricaGruppoGruppi,
			rubricaGruppoGruppis.get(newRubricaGruppoGruppi.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaGruppoGruppiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RubricaGruppoGruppi>() {

				@Override
				public void performAction(
					RubricaGruppoGruppi rubricaGruppoGruppi) {

					Assert.assertNotNull(rubricaGruppoGruppi);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoGruppi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_GRUPPO_PADRE",
				newRubricaGruppoGruppi.getFK_GRUPPO_PADRE()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_GRUPPO_FIGLIO",
				newRubricaGruppoGruppi.getFK_GRUPPO_FIGLIO()));

		List<RubricaGruppoGruppi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaGruppoGruppi existingRubricaGruppoGruppi = result.get(0);

		Assert.assertEquals(
			existingRubricaGruppoGruppi, newRubricaGruppoGruppi);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoGruppi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_GRUPPO_PADRE", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.FK_GRUPPO_FIGLIO", RandomTestUtil.nextLong()));

		List<RubricaGruppoGruppi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaGruppoGruppi newRubricaGruppoGruppi = addRubricaGruppoGruppi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoGruppi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.FK_GRUPPO_PADRE"));

		Object newFK_GRUPPO_PADRE = newRubricaGruppoGruppi.getFK_GRUPPO_PADRE();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.FK_GRUPPO_PADRE", new Object[] {newFK_GRUPPO_PADRE}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFK_GRUPPO_PADRE = result.get(0);

		Assert.assertEquals(existingFK_GRUPPO_PADRE, newFK_GRUPPO_PADRE);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppoGruppi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.FK_GRUPPO_PADRE"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.FK_GRUPPO_PADRE",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaGruppoGruppi addRubricaGruppoGruppi() throws Exception {
		RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		RubricaGruppoGruppi rubricaGruppoGruppi = _persistence.create(pk);

		_rubricaGruppoGruppis.add(_persistence.update(rubricaGruppoGruppi));

		return rubricaGruppoGruppi;
	}

	private List<RubricaGruppoGruppi> _rubricaGruppoGruppis =
		new ArrayList<RubricaGruppoGruppi>();
	private RubricaGruppoGruppiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}