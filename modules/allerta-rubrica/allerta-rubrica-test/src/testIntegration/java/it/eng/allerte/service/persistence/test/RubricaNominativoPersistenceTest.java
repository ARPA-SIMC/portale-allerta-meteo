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

import it.eng.allerte.exception.NoSuchRubricaNominativoException;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaNominativoPersistence;
import it.eng.allerte.service.persistence.RubricaNominativoUtil;

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
public class RubricaNominativoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaNominativoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaNominativo> iterator = _rubricaNominativos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaNominativo rubricaNominativo = _persistence.create(pk);

		Assert.assertNotNull(rubricaNominativo);

		Assert.assertEquals(rubricaNominativo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		_persistence.remove(newRubricaNominativo);

		RubricaNominativo existingRubricaNominativo =
			_persistence.fetchByPrimaryKey(
				newRubricaNominativo.getPrimaryKey());

		Assert.assertNull(existingRubricaNominativo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaNominativo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaNominativo newRubricaNominativo = _persistence.create(pk);

		newRubricaNominativo.setCOGNOME(RandomTestUtil.randomString());

		newRubricaNominativo.setNOME(RandomTestUtil.randomString());

		newRubricaNominativo.setINDIRIZZO(RandomTestUtil.randomString());

		newRubricaNominativo.setFK_SITO_PROPRIETARIO(RandomTestUtil.nextLong());

		newRubricaNominativo.setFK_UTENTE_PORTALE(RandomTestUtil.nextLong());

		newRubricaNominativo.setFK_UTENTE_CREAZIONE(RandomTestUtil.nextLong());

		newRubricaNominativo.setDATA_CREAZIONE(RandomTestUtil.nextDate());

		newRubricaNominativo.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		newRubricaNominativo.setDATA_MODIFICA(RandomTestUtil.nextDate());

		newRubricaNominativo.setDISABLED(RandomTestUtil.randomBoolean());

		newRubricaNominativo.setMODIFICA_MINORE(RandomTestUtil.randomBoolean());

		_rubricaNominativos.add(_persistence.update(newRubricaNominativo));

		RubricaNominativo existingRubricaNominativo =
			_persistence.findByPrimaryKey(newRubricaNominativo.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaNominativo.getID_NOMINATIVO(),
			newRubricaNominativo.getID_NOMINATIVO());
		Assert.assertEquals(
			existingRubricaNominativo.getCOGNOME(),
			newRubricaNominativo.getCOGNOME());
		Assert.assertEquals(
			existingRubricaNominativo.getNOME(),
			newRubricaNominativo.getNOME());
		Assert.assertEquals(
			existingRubricaNominativo.getINDIRIZZO(),
			newRubricaNominativo.getINDIRIZZO());
		Assert.assertEquals(
			existingRubricaNominativo.getFK_SITO_PROPRIETARIO(),
			newRubricaNominativo.getFK_SITO_PROPRIETARIO());
		Assert.assertEquals(
			existingRubricaNominativo.getFK_UTENTE_PORTALE(),
			newRubricaNominativo.getFK_UTENTE_PORTALE());
		Assert.assertEquals(
			existingRubricaNominativo.getFK_UTENTE_CREAZIONE(),
			newRubricaNominativo.getFK_UTENTE_CREAZIONE());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingRubricaNominativo.getDATA_CREAZIONE()),
			Time.getShortTimestamp(newRubricaNominativo.getDATA_CREAZIONE()));
		Assert.assertEquals(
			existingRubricaNominativo.getFK_UTENTE_MODIFICA(),
			newRubricaNominativo.getFK_UTENTE_MODIFICA());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingRubricaNominativo.getDATA_MODIFICA()),
			Time.getShortTimestamp(newRubricaNominativo.getDATA_MODIFICA()));
		Assert.assertEquals(
			existingRubricaNominativo.isDISABLED(),
			newRubricaNominativo.isDISABLED());
		Assert.assertEquals(
			existingRubricaNominativo.isMODIFICA_MINORE(),
			newRubricaNominativo.isMODIFICA_MINORE());
	}

	@Test
	public void testCountByNominativoPerSitoProprietario() throws Exception {
		_persistence.countByNominativoPerSitoProprietario(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByNominativoPerSitoProprietario(0L, 0L);
	}

	@Test
	public void testCountByUtentePortale() throws Exception {
		_persistence.countByUtentePortale(RandomTestUtil.nextLong());

		_persistence.countByUtentePortale(0L);
	}

	@Test
	public void testCountByUtenteCreazione() throws Exception {
		_persistence.countByUtenteCreazione(RandomTestUtil.nextLong());

		_persistence.countByUtenteCreazione(0L);
	}

	@Test
	public void testCountByUtenteModifica() throws Exception {
		_persistence.countByUtenteModifica(RandomTestUtil.nextLong());

		_persistence.countByUtenteModifica(0L);
	}

	@Test
	public void testCountByNominativoPerGruppoByNomeCognome() throws Exception {
		_persistence.countByNominativoPerGruppoByNomeCognome(
			"", "", RandomTestUtil.nextLong());

		_persistence.countByNominativoPerGruppoByNomeCognome(
			"null", "null", 0L);

		_persistence.countByNominativoPerGruppoByNomeCognome(
			(String)null, (String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		RubricaNominativo existingRubricaNominativo =
			_persistence.findByPrimaryKey(newRubricaNominativo.getPrimaryKey());

		Assert.assertEquals(existingRubricaNominativo, newRubricaNominativo);
	}

	@Test(expected = NoSuchRubricaNominativoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaNominativo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaNominativo", "ID_NOMINATIVO", true, "COGNOME", true,
			"NOME", true, "INDIRIZZO", true, "FK_SITO_PROPRIETARIO", true,
			"FK_UTENTE_PORTALE", true, "FK_UTENTE_CREAZIONE", true,
			"DATA_CREAZIONE", true, "FK_UTENTE_MODIFICA", true, "DATA_MODIFICA",
			true, "DISABLED", true, "MODIFICA_MINORE", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		RubricaNominativo existingRubricaNominativo =
			_persistence.fetchByPrimaryKey(
				newRubricaNominativo.getPrimaryKey());

		Assert.assertEquals(existingRubricaNominativo, newRubricaNominativo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaNominativo missingRubricaNominativo =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRubricaNominativo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaNominativo newRubricaNominativo1 = addRubricaNominativo();
		RubricaNominativo newRubricaNominativo2 = addRubricaNominativo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaNominativo1.getPrimaryKey());
		primaryKeys.add(newRubricaNominativo2.getPrimaryKey());

		Map<Serializable, RubricaNominativo> rubricaNominativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaNominativos.size());
		Assert.assertEquals(
			newRubricaNominativo1,
			rubricaNominativos.get(newRubricaNominativo1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaNominativo2,
			rubricaNominativos.get(newRubricaNominativo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaNominativo> rubricaNominativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaNominativos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaNominativo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaNominativo> rubricaNominativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaNominativos.size());
		Assert.assertEquals(
			newRubricaNominativo,
			rubricaNominativos.get(newRubricaNominativo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaNominativo> rubricaNominativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaNominativos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaNominativo.getPrimaryKey());

		Map<Serializable, RubricaNominativo> rubricaNominativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaNominativos.size());
		Assert.assertEquals(
			newRubricaNominativo,
			rubricaNominativos.get(newRubricaNominativo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaNominativoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RubricaNominativo>() {

				@Override
				public void performAction(RubricaNominativo rubricaNominativo) {
					Assert.assertNotNull(rubricaNominativo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaNominativo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_NOMINATIVO", newRubricaNominativo.getID_NOMINATIVO()));

		List<RubricaNominativo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaNominativo existingRubricaNominativo = result.get(0);

		Assert.assertEquals(existingRubricaNominativo, newRubricaNominativo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaNominativo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_NOMINATIVO", RandomTestUtil.nextLong()));

		List<RubricaNominativo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaNominativo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_NOMINATIVO"));

		Object newID_NOMINATIVO = newRubricaNominativo.getID_NOMINATIVO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_NOMINATIVO", new Object[] {newID_NOMINATIVO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_NOMINATIVO = result.get(0);

		Assert.assertEquals(existingID_NOMINATIVO, newID_NOMINATIVO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaNominativo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_NOMINATIVO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_NOMINATIVO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newRubricaNominativo.getPrimaryKey()));
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

		RubricaNominativo newRubricaNominativo = addRubricaNominativo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaNominativo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_NOMINATIVO", newRubricaNominativo.getID_NOMINATIVO()));

		List<RubricaNominativo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(RubricaNominativo rubricaNominativo) {
		Assert.assertEquals(
			Long.valueOf(rubricaNominativo.getID_NOMINATIVO()),
			ReflectionTestUtil.<Long>invoke(
				rubricaNominativo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "ID_NOMINATIVO"));
		Assert.assertEquals(
			Long.valueOf(rubricaNominativo.getFK_SITO_PROPRIETARIO()),
			ReflectionTestUtil.<Long>invoke(
				rubricaNominativo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "FK_SITO_PROPRIETARIO"));
	}

	protected RubricaNominativo addRubricaNominativo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaNominativo rubricaNominativo = _persistence.create(pk);

		rubricaNominativo.setCOGNOME(RandomTestUtil.randomString());

		rubricaNominativo.setNOME(RandomTestUtil.randomString());

		rubricaNominativo.setINDIRIZZO(RandomTestUtil.randomString());

		rubricaNominativo.setFK_SITO_PROPRIETARIO(RandomTestUtil.nextLong());

		rubricaNominativo.setFK_UTENTE_PORTALE(RandomTestUtil.nextLong());

		rubricaNominativo.setFK_UTENTE_CREAZIONE(RandomTestUtil.nextLong());

		rubricaNominativo.setDATA_CREAZIONE(RandomTestUtil.nextDate());

		rubricaNominativo.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		rubricaNominativo.setDATA_MODIFICA(RandomTestUtil.nextDate());

		rubricaNominativo.setDISABLED(RandomTestUtil.randomBoolean());

		rubricaNominativo.setMODIFICA_MINORE(RandomTestUtil.randomBoolean());

		_rubricaNominativos.add(_persistence.update(rubricaNominativo));

		return rubricaNominativo;
	}

	private List<RubricaNominativo> _rubricaNominativos =
		new ArrayList<RubricaNominativo>();
	private RubricaNominativoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}