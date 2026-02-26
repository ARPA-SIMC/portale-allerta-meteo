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

import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaGruppoPersistence;
import it.eng.allerte.service.persistence.RubricaGruppoUtil;

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
public class RubricaGruppoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaGruppoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaGruppo> iterator = _rubricaGruppos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaGruppo rubricaGruppo = _persistence.create(pk);

		Assert.assertNotNull(rubricaGruppo);

		Assert.assertEquals(rubricaGruppo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		_persistence.remove(newRubricaGruppo);

		RubricaGruppo existingRubricaGruppo = _persistence.fetchByPrimaryKey(
			newRubricaGruppo.getPrimaryKey());

		Assert.assertNull(existingRubricaGruppo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaGruppo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaGruppo newRubricaGruppo = _persistence.create(pk);

		newRubricaGruppo.setNOME(RandomTestUtil.randomString());

		newRubricaGruppo.setFK_SITO_PROPRIETARIO(RandomTestUtil.nextLong());

		newRubricaGruppo.setNOTE(RandomTestUtil.randomString());

		newRubricaGruppo.setFK_UTENTE_CREAZIONE(RandomTestUtil.nextLong());

		newRubricaGruppo.setDATA_CREAZIONE(RandomTestUtil.nextDate());

		newRubricaGruppo.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		newRubricaGruppo.setDATA_MODIFICA(RandomTestUtil.nextDate());

		newRubricaGruppo.setDISABLED(RandomTestUtil.randomBoolean());

		newRubricaGruppo.setFK_CATEGORIA(RandomTestUtil.nextLong());

		_rubricaGruppos.add(_persistence.update(newRubricaGruppo));

		RubricaGruppo existingRubricaGruppo = _persistence.findByPrimaryKey(
			newRubricaGruppo.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaGruppo.getID_GRUPPO(),
			newRubricaGruppo.getID_GRUPPO());
		Assert.assertEquals(
			existingRubricaGruppo.getNOME(), newRubricaGruppo.getNOME());
		Assert.assertEquals(
			existingRubricaGruppo.getFK_SITO_PROPRIETARIO(),
			newRubricaGruppo.getFK_SITO_PROPRIETARIO());
		Assert.assertEquals(
			existingRubricaGruppo.getNOTE(), newRubricaGruppo.getNOTE());
		Assert.assertEquals(
			existingRubricaGruppo.getFK_UTENTE_CREAZIONE(),
			newRubricaGruppo.getFK_UTENTE_CREAZIONE());
		Assert.assertEquals(
			Time.getShortTimestamp(existingRubricaGruppo.getDATA_CREAZIONE()),
			Time.getShortTimestamp(newRubricaGruppo.getDATA_CREAZIONE()));
		Assert.assertEquals(
			existingRubricaGruppo.getFK_UTENTE_MODIFICA(),
			newRubricaGruppo.getFK_UTENTE_MODIFICA());
		Assert.assertEquals(
			Time.getShortTimestamp(existingRubricaGruppo.getDATA_MODIFICA()),
			Time.getShortTimestamp(newRubricaGruppo.getDATA_MODIFICA()));
		Assert.assertEquals(
			existingRubricaGruppo.isDISABLED(), newRubricaGruppo.isDISABLED());
		Assert.assertEquals(
			existingRubricaGruppo.getFK_CATEGORIA(),
			newRubricaGruppo.getFK_CATEGORIA());
	}

	@Test
	public void testCountByRubricaGruppoSitoProprietario() throws Exception {
		_persistence.countByRubricaGruppoSitoProprietario(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByRubricaGruppoSitoProprietario(0L, 0L);
	}

	@Test
	public void testCountByRubricaGruppoForOwnerAndName() throws Exception {
		_persistence.countByRubricaGruppoForOwnerAndName(
			RandomTestUtil.nextLong(), "", RandomTestUtil.randomBoolean());

		_persistence.countByRubricaGruppoForOwnerAndName(
			0L, "null", RandomTestUtil.randomBoolean());

		_persistence.countByRubricaGruppoForOwnerAndName(
			0L, (String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByRubricaGruppoCategoria() throws Exception {
		_persistence.countByRubricaGruppoCategoria(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByRubricaGruppoCategoria(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		RubricaGruppo existingRubricaGruppo = _persistence.findByPrimaryKey(
			newRubricaGruppo.getPrimaryKey());

		Assert.assertEquals(existingRubricaGruppo, newRubricaGruppo);
	}

	@Test(expected = NoSuchRubricaGruppoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaGruppo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaGruppo", "ID_GRUPPO", true, "NOME", true,
			"FK_SITO_PROPRIETARIO", true, "NOTE", true, "FK_UTENTE_CREAZIONE",
			true, "DATA_CREAZIONE", true, "FK_UTENTE_MODIFICA", true,
			"DATA_MODIFICA", true, "DISABLED", true, "FK_CATEGORIA", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		RubricaGruppo existingRubricaGruppo = _persistence.fetchByPrimaryKey(
			newRubricaGruppo.getPrimaryKey());

		Assert.assertEquals(existingRubricaGruppo, newRubricaGruppo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaGruppo missingRubricaGruppo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaGruppo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaGruppo newRubricaGruppo1 = addRubricaGruppo();
		RubricaGruppo newRubricaGruppo2 = addRubricaGruppo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppo1.getPrimaryKey());
		primaryKeys.add(newRubricaGruppo2.getPrimaryKey());

		Map<Serializable, RubricaGruppo> rubricaGruppos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaGruppos.size());
		Assert.assertEquals(
			newRubricaGruppo1,
			rubricaGruppos.get(newRubricaGruppo1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaGruppo2,
			rubricaGruppos.get(newRubricaGruppo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaGruppo> rubricaGruppos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaGruppos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaGruppo> rubricaGruppos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaGruppos.size());
		Assert.assertEquals(
			newRubricaGruppo,
			rubricaGruppos.get(newRubricaGruppo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaGruppo> rubricaGruppos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaGruppos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaGruppo.getPrimaryKey());

		Map<Serializable, RubricaGruppo> rubricaGruppos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaGruppos.size());
		Assert.assertEquals(
			newRubricaGruppo,
			rubricaGruppos.get(newRubricaGruppo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaGruppoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaGruppo>() {

				@Override
				public void performAction(RubricaGruppo rubricaGruppo) {
					Assert.assertNotNull(rubricaGruppo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_GRUPPO", newRubricaGruppo.getID_GRUPPO()));

		List<RubricaGruppo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaGruppo existingRubricaGruppo = result.get(0);

		Assert.assertEquals(existingRubricaGruppo, newRubricaGruppo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_GRUPPO", RandomTestUtil.nextLong()));

		List<RubricaGruppo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_GRUPPO"));

		Object newID_GRUPPO = newRubricaGruppo.getID_GRUPPO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_GRUPPO", new Object[] {newID_GRUPPO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_GRUPPO = result.get(0);

		Assert.assertEquals(existingID_GRUPPO, newID_GRUPPO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_GRUPPO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_GRUPPO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newRubricaGruppo.getPrimaryKey()));
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

		RubricaGruppo newRubricaGruppo = addRubricaGruppo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaGruppo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_GRUPPO", newRubricaGruppo.getID_GRUPPO()));

		List<RubricaGruppo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(RubricaGruppo rubricaGruppo) {
		Assert.assertEquals(
			Long.valueOf(rubricaGruppo.getID_GRUPPO()),
			ReflectionTestUtil.<Long>invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "ID_GRUPPO"));
		Assert.assertEquals(
			Long.valueOf(rubricaGruppo.getFK_SITO_PROPRIETARIO()),
			ReflectionTestUtil.<Long>invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "FK_SITO_PROPRIETARIO"));

		Assert.assertEquals(
			Long.valueOf(rubricaGruppo.getFK_SITO_PROPRIETARIO()),
			ReflectionTestUtil.<Long>invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "FK_SITO_PROPRIETARIO"));
		Assert.assertEquals(
			rubricaGruppo.getNOME(),
			ReflectionTestUtil.invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "NOME"));
		Assert.assertEquals(
			Boolean.valueOf(rubricaGruppo.getDISABLED()),
			ReflectionTestUtil.<Boolean>invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "DISABLED"));

		Assert.assertEquals(
			Long.valueOf(rubricaGruppo.getFK_CATEGORIA()),
			ReflectionTestUtil.<Long>invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "FK_CATEGORIA"));
		Assert.assertEquals(
			Long.valueOf(rubricaGruppo.getFK_SITO_PROPRIETARIO()),
			ReflectionTestUtil.<Long>invoke(
				rubricaGruppo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "FK_SITO_PROPRIETARIO"));
	}

	protected RubricaGruppo addRubricaGruppo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaGruppo rubricaGruppo = _persistence.create(pk);

		rubricaGruppo.setNOME(RandomTestUtil.randomString());

		rubricaGruppo.setFK_SITO_PROPRIETARIO(RandomTestUtil.nextLong());

		rubricaGruppo.setNOTE(RandomTestUtil.randomString());

		rubricaGruppo.setFK_UTENTE_CREAZIONE(RandomTestUtil.nextLong());

		rubricaGruppo.setDATA_CREAZIONE(RandomTestUtil.nextDate());

		rubricaGruppo.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		rubricaGruppo.setDATA_MODIFICA(RandomTestUtil.nextDate());

		rubricaGruppo.setDISABLED(RandomTestUtil.randomBoolean());

		rubricaGruppo.setFK_CATEGORIA(RandomTestUtil.nextLong());

		_rubricaGruppos.add(_persistence.update(rubricaGruppo));

		return rubricaGruppo;
	}

	private List<RubricaGruppo> _rubricaGruppos =
		new ArrayList<RubricaGruppo>();
	private RubricaGruppoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}