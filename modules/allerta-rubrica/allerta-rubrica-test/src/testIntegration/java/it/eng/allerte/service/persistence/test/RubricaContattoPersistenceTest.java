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

import it.eng.allerte.exception.NoSuchRubricaContattoException;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.service.RubricaContattoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaContattoPersistence;
import it.eng.allerte.service.persistence.RubricaContattoUtil;

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
public class RubricaContattoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerte.service"));

	@Before
	public void setUp() {
		_persistence = RubricaContattoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RubricaContatto> iterator = _rubricaContattos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaContatto rubricaContatto = _persistence.create(pk);

		Assert.assertNotNull(rubricaContatto);

		Assert.assertEquals(rubricaContatto.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RubricaContatto newRubricaContatto = addRubricaContatto();

		_persistence.remove(newRubricaContatto);

		RubricaContatto existingRubricaContatto =
			_persistence.fetchByPrimaryKey(newRubricaContatto.getPrimaryKey());

		Assert.assertNull(existingRubricaContatto);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRubricaContatto();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaContatto newRubricaContatto = _persistence.create(pk);

		newRubricaContatto.setFK_NOMINATIVO(RandomTestUtil.nextLong());

		newRubricaContatto.setFK_CANALE(RandomTestUtil.nextLong());

		newRubricaContatto.setCONTATTO(RandomTestUtil.randomString());

		newRubricaContatto.setALLERTAMENTO(RandomTestUtil.randomBoolean());

		newRubricaContatto.setFK_UTENTE_CREAZIONE(RandomTestUtil.nextLong());

		newRubricaContatto.setDATA_CREAZIONE(RandomTestUtil.nextDate());

		newRubricaContatto.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		newRubricaContatto.setDATA_MODIFICA(RandomTestUtil.nextDate());

		newRubricaContatto.setDATA_FINE_VALIDITA(RandomTestUtil.nextDate());

		newRubricaContatto.setMODIFICA_MINORE(RandomTestUtil.randomBoolean());

		_rubricaContattos.add(_persistence.update(newRubricaContatto));

		RubricaContatto existingRubricaContatto = _persistence.findByPrimaryKey(
			newRubricaContatto.getPrimaryKey());

		Assert.assertEquals(
			existingRubricaContatto.getID_CONTATTO(),
			newRubricaContatto.getID_CONTATTO());
		Assert.assertEquals(
			existingRubricaContatto.getFK_NOMINATIVO(),
			newRubricaContatto.getFK_NOMINATIVO());
		Assert.assertEquals(
			existingRubricaContatto.getFK_CANALE(),
			newRubricaContatto.getFK_CANALE());
		Assert.assertEquals(
			existingRubricaContatto.getCONTATTO(),
			newRubricaContatto.getCONTATTO());
		Assert.assertEquals(
			existingRubricaContatto.isALLERTAMENTO(),
			newRubricaContatto.isALLERTAMENTO());
		Assert.assertEquals(
			existingRubricaContatto.getFK_UTENTE_CREAZIONE(),
			newRubricaContatto.getFK_UTENTE_CREAZIONE());
		Assert.assertEquals(
			Time.getShortTimestamp(existingRubricaContatto.getDATA_CREAZIONE()),
			Time.getShortTimestamp(newRubricaContatto.getDATA_CREAZIONE()));
		Assert.assertEquals(
			existingRubricaContatto.getFK_UTENTE_MODIFICA(),
			newRubricaContatto.getFK_UTENTE_MODIFICA());
		Assert.assertEquals(
			Time.getShortTimestamp(existingRubricaContatto.getDATA_MODIFICA()),
			Time.getShortTimestamp(newRubricaContatto.getDATA_MODIFICA()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingRubricaContatto.getDATA_FINE_VALIDITA()),
			Time.getShortTimestamp(newRubricaContatto.getDATA_FINE_VALIDITA()));
		Assert.assertEquals(
			existingRubricaContatto.isMODIFICA_MINORE(),
			newRubricaContatto.isMODIFICA_MINORE());
	}

	@Test
	public void testCountByUtenteCreazioneContatto() throws Exception {
		_persistence.countByUtenteCreazioneContatto(RandomTestUtil.nextLong());

		_persistence.countByUtenteCreazioneContatto(0L);
	}

	@Test
	public void testCountByUtenteModificaContatto() throws Exception {
		_persistence.countByUtenteModificaContatto(RandomTestUtil.nextLong());

		_persistence.countByUtenteModificaContatto(0L);
	}

	@Test
	public void testCountByContattoCanale() throws Exception {
		_persistence.countByContattoCanale(RandomTestUtil.nextLong());

		_persistence.countByContattoCanale(0L);
	}

	@Test
	public void testCountByContattoNominativo() throws Exception {
		_persistence.countByContattoNominativo(RandomTestUtil.nextLong());

		_persistence.countByContattoNominativo(0L);
	}

	@Test
	public void testCountByDataCreazioneContatto() throws Exception {
		_persistence.countByDataCreazioneContatto(RandomTestUtil.nextDate());

		_persistence.countByDataCreazioneContatto(RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByDataModificaContatto() throws Exception {
		_persistence.countByDataModificaContatto(RandomTestUtil.nextDate());

		_persistence.countByDataModificaContatto(RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RubricaContatto newRubricaContatto = addRubricaContatto();

		RubricaContatto existingRubricaContatto = _persistence.findByPrimaryKey(
			newRubricaContatto.getPrimaryKey());

		Assert.assertEquals(existingRubricaContatto, newRubricaContatto);
	}

	@Test(expected = NoSuchRubricaContattoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RubricaContatto> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"rubrica_RubricaContatto", "ID_CONTATTO", true, "FK_NOMINATIVO",
			true, "FK_CANALE", true, "CONTATTO", true, "ALLERTAMENTO", true,
			"FK_UTENTE_CREAZIONE", true, "DATA_CREAZIONE", true,
			"FK_UTENTE_MODIFICA", true, "DATA_MODIFICA", true,
			"DATA_FINE_VALIDITA", true, "MODIFICA_MINORE", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RubricaContatto newRubricaContatto = addRubricaContatto();

		RubricaContatto existingRubricaContatto =
			_persistence.fetchByPrimaryKey(newRubricaContatto.getPrimaryKey());

		Assert.assertEquals(existingRubricaContatto, newRubricaContatto);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaContatto missingRubricaContatto = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingRubricaContatto);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RubricaContatto newRubricaContatto1 = addRubricaContatto();
		RubricaContatto newRubricaContatto2 = addRubricaContatto();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaContatto1.getPrimaryKey());
		primaryKeys.add(newRubricaContatto2.getPrimaryKey());

		Map<Serializable, RubricaContatto> rubricaContattos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, rubricaContattos.size());
		Assert.assertEquals(
			newRubricaContatto1,
			rubricaContattos.get(newRubricaContatto1.getPrimaryKey()));
		Assert.assertEquals(
			newRubricaContatto2,
			rubricaContattos.get(newRubricaContatto2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RubricaContatto> rubricaContattos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaContattos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RubricaContatto newRubricaContatto = addRubricaContatto();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaContatto.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RubricaContatto> rubricaContattos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaContattos.size());
		Assert.assertEquals(
			newRubricaContatto,
			rubricaContattos.get(newRubricaContatto.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RubricaContatto> rubricaContattos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(rubricaContattos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RubricaContatto newRubricaContatto = addRubricaContatto();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRubricaContatto.getPrimaryKey());

		Map<Serializable, RubricaContatto> rubricaContattos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, rubricaContattos.size());
		Assert.assertEquals(
			newRubricaContatto,
			rubricaContattos.get(newRubricaContatto.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RubricaContattoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RubricaContatto>() {

				@Override
				public void performAction(RubricaContatto rubricaContatto) {
					Assert.assertNotNull(rubricaContatto);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RubricaContatto newRubricaContatto = addRubricaContatto();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaContatto.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_CONTATTO", newRubricaContatto.getID_CONTATTO()));

		List<RubricaContatto> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RubricaContatto existingRubricaContatto = result.get(0);

		Assert.assertEquals(existingRubricaContatto, newRubricaContatto);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaContatto.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_CONTATTO", RandomTestUtil.nextLong()));

		List<RubricaContatto> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RubricaContatto newRubricaContatto = addRubricaContatto();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaContatto.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_CONTATTO"));

		Object newID_CONTATTO = newRubricaContatto.getID_CONTATTO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_CONTATTO", new Object[] {newID_CONTATTO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_CONTATTO = result.get(0);

		Assert.assertEquals(existingID_CONTATTO, newID_CONTATTO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RubricaContatto.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ID_CONTATTO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_CONTATTO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RubricaContatto addRubricaContatto() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RubricaContatto rubricaContatto = _persistence.create(pk);

		rubricaContatto.setFK_NOMINATIVO(RandomTestUtil.nextLong());

		rubricaContatto.setFK_CANALE(RandomTestUtil.nextLong());

		rubricaContatto.setCONTATTO(RandomTestUtil.randomString());

		rubricaContatto.setALLERTAMENTO(RandomTestUtil.randomBoolean());

		rubricaContatto.setFK_UTENTE_CREAZIONE(RandomTestUtil.nextLong());

		rubricaContatto.setDATA_CREAZIONE(RandomTestUtil.nextDate());

		rubricaContatto.setFK_UTENTE_MODIFICA(RandomTestUtil.nextLong());

		rubricaContatto.setDATA_MODIFICA(RandomTestUtil.nextDate());

		rubricaContatto.setDATA_FINE_VALIDITA(RandomTestUtil.nextDate());

		rubricaContatto.setMODIFICA_MINORE(RandomTestUtil.randomBoolean());

		_rubricaContattos.add(_persistence.update(rubricaContatto));

		return rubricaContatto;
	}

	private List<RubricaContatto> _rubricaContattos =
		new ArrayList<RubricaContatto>();
	private RubricaContattoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}