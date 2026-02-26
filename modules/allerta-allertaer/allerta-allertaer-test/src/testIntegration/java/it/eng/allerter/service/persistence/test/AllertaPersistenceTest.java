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

import it.eng.allerter.exception.NoSuchAllertaException;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.persistence.AllertaPersistence;
import it.eng.allerter.service.persistence.AllertaUtil;

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
public class AllertaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = AllertaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Allerta> iterator = _allertas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allerta allerta = _persistence.create(pk);

		Assert.assertNotNull(allerta);

		Assert.assertEquals(allerta.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Allerta newAllerta = addAllerta();

		_persistence.remove(newAllerta);

		Allerta existingAllerta = _persistence.fetchByPrimaryKey(
			newAllerta.getPrimaryKey());

		Assert.assertNull(existingAllerta);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAllerta();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allerta newAllerta = _persistence.create(pk);

		newAllerta.setUuid(RandomTestUtil.randomString());

		newAllerta.setGroupId(RandomTestUtil.nextLong());

		newAllerta.setCompanyId(RandomTestUtil.nextLong());

		newAllerta.setUserId(RandomTestUtil.nextLong());

		newAllerta.setUserName(RandomTestUtil.randomString());

		newAllerta.setCreatorName(RandomTestUtil.randomString());

		newAllerta.setCreateDate(RandomTestUtil.nextDate());

		newAllerta.setModifiedDate(RandomTestUtil.nextDate());

		newAllerta.setStato(RandomTestUtil.nextInt());

		newAllerta.setNumero(RandomTestUtil.randomString());

		newAllerta.setProgressivo(RandomTestUtil.nextInt());

		newAllerta.setAnno(RandomTestUtil.nextInt());

		newAllerta.setDataEmissione(RandomTestUtil.nextDate());

		newAllerta.setDataInizio(RandomTestUtil.nextDate());

		newAllerta.setDataFine(RandomTestUtil.nextDate());

		newAllerta.setDescrizioneMeteo(RandomTestUtil.randomString());

		newAllerta.setTendenza(RandomTestUtil.nextInt());

		newAllerta.setNote(RandomTestUtil.randomString());

		newAllerta.setRiferimenti(RandomTestUtil.randomString());

		newAllerta.setUtenteFirmaArpaId(RandomTestUtil.nextLong());

		newAllerta.setDataFirmaArpa(RandomTestUtil.nextDate());

		newAllerta.setUtenteFirmaProtId(RandomTestUtil.nextLong());

		newAllerta.setDataFirmaProt(RandomTestUtil.nextDate());

		newAllerta.setParentId(RandomTestUtil.nextLong());

		newAllerta.setSintesi(RandomTestUtil.randomString());

		newAllerta.setSintesiEng(RandomTestUtil.randomString());

		newAllerta.setLink(RandomTestUtil.randomString());

		newAllerta.setTitolo(RandomTestUtil.randomString());

		newAllerta.setTitoloEng(RandomTestUtil.randomString());

		newAllerta.setTipoAllerta(RandomTestUtil.randomBoolean());

		newAllerta.setHash(RandomTestUtil.randomString());

		newAllerta.setSintesiBriefing(RandomTestUtil.randomString());

		_allertas.add(_persistence.update(newAllerta));

		Allerta existingAllerta = _persistence.findByPrimaryKey(
			newAllerta.getPrimaryKey());

		Assert.assertEquals(existingAllerta.getUuid(), newAllerta.getUuid());
		Assert.assertEquals(
			existingAllerta.getAllertaId(), newAllerta.getAllertaId());
		Assert.assertEquals(
			existingAllerta.getGroupId(), newAllerta.getGroupId());
		Assert.assertEquals(
			existingAllerta.getCompanyId(), newAllerta.getCompanyId());
		Assert.assertEquals(
			existingAllerta.getUserId(), newAllerta.getUserId());
		Assert.assertEquals(
			existingAllerta.getUserName(), newAllerta.getUserName());
		Assert.assertEquals(
			existingAllerta.getCreatorName(), newAllerta.getCreatorName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getCreateDate()),
			Time.getShortTimestamp(newAllerta.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getModifiedDate()),
			Time.getShortTimestamp(newAllerta.getModifiedDate()));
		Assert.assertEquals(existingAllerta.getStato(), newAllerta.getStato());
		Assert.assertEquals(
			existingAllerta.getNumero(), newAllerta.getNumero());
		Assert.assertEquals(
			existingAllerta.getProgressivo(), newAllerta.getProgressivo());
		Assert.assertEquals(existingAllerta.getAnno(), newAllerta.getAnno());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getDataEmissione()),
			Time.getShortTimestamp(newAllerta.getDataEmissione()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getDataInizio()),
			Time.getShortTimestamp(newAllerta.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getDataFine()),
			Time.getShortTimestamp(newAllerta.getDataFine()));
		Assert.assertEquals(
			existingAllerta.getDescrizioneMeteo(),
			newAllerta.getDescrizioneMeteo());
		Assert.assertEquals(
			existingAllerta.getTendenza(), newAllerta.getTendenza());
		Assert.assertEquals(existingAllerta.getNote(), newAllerta.getNote());
		Assert.assertEquals(
			existingAllerta.getRiferimenti(), newAllerta.getRiferimenti());
		Assert.assertEquals(
			existingAllerta.getUtenteFirmaArpaId(),
			newAllerta.getUtenteFirmaArpaId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getDataFirmaArpa()),
			Time.getShortTimestamp(newAllerta.getDataFirmaArpa()));
		Assert.assertEquals(
			existingAllerta.getUtenteFirmaProtId(),
			newAllerta.getUtenteFirmaProtId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllerta.getDataFirmaProt()),
			Time.getShortTimestamp(newAllerta.getDataFirmaProt()));
		Assert.assertEquals(
			existingAllerta.getParentId(), newAllerta.getParentId());
		Assert.assertEquals(
			existingAllerta.getSintesi(), newAllerta.getSintesi());
		Assert.assertEquals(
			existingAllerta.getSintesiEng(), newAllerta.getSintesiEng());
		Assert.assertEquals(existingAllerta.getLink(), newAllerta.getLink());
		Assert.assertEquals(
			existingAllerta.getTitolo(), newAllerta.getTitolo());
		Assert.assertEquals(
			existingAllerta.getTitoloEng(), newAllerta.getTitoloEng());
		Assert.assertEquals(
			existingAllerta.isTipoAllerta(), newAllerta.isTipoAllerta());
		Assert.assertEquals(existingAllerta.getHash(), newAllerta.getHash());
		Assert.assertEquals(
			existingAllerta.getSintesiBriefing(),
			newAllerta.getSintesiBriefing());
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
	public void testCountByNumero() throws Exception {
		_persistence.countByNumero("");

		_persistence.countByNumero("null");

		_persistence.countByNumero((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Allerta newAllerta = addAllerta();

		Allerta existingAllerta = _persistence.findByPrimaryKey(
			newAllerta.getPrimaryKey());

		Assert.assertEquals(existingAllerta, newAllerta);
	}

	@Test(expected = NoSuchAllertaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Allerta> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_Allerta", "uuid", true, "allertaId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"creatorName", true, "createDate", true, "modifiedDate", true,
			"stato", true, "numero", true, "progressivo", true, "anno", true,
			"dataEmissione", true, "dataInizio", true, "dataFine", true,
			"descrizioneMeteo", true, "tendenza", true, "note", true,
			"riferimenti", true, "utenteFirmaArpaId", true, "dataFirmaArpa",
			true, "utenteFirmaProtId", true, "dataFirmaProt", true, "parentId",
			true, "sintesi", true, "sintesiEng", true, "link", true, "titolo",
			true, "titoloEng", true, "tipoAllerta", true, "hash", true,
			"sintesiBriefing", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Allerta newAllerta = addAllerta();

		Allerta existingAllerta = _persistence.fetchByPrimaryKey(
			newAllerta.getPrimaryKey());

		Assert.assertEquals(existingAllerta, newAllerta);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allerta missingAllerta = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAllerta);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Allerta newAllerta1 = addAllerta();
		Allerta newAllerta2 = addAllerta();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllerta1.getPrimaryKey());
		primaryKeys.add(newAllerta2.getPrimaryKey());

		Map<Serializable, Allerta> allertas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, allertas.size());
		Assert.assertEquals(
			newAllerta1, allertas.get(newAllerta1.getPrimaryKey()));
		Assert.assertEquals(
			newAllerta2, allertas.get(newAllerta2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Allerta> allertas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(allertas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Allerta newAllerta = addAllerta();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllerta.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Allerta> allertas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, allertas.size());
		Assert.assertEquals(
			newAllerta, allertas.get(newAllerta.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Allerta> allertas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(allertas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Allerta newAllerta = addAllerta();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllerta.getPrimaryKey());

		Map<Serializable, Allerta> allertas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, allertas.size());
		Assert.assertEquals(
			newAllerta, allertas.get(newAllerta.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AllertaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Allerta>() {

				@Override
				public void performAction(Allerta allerta) {
					Assert.assertNotNull(allerta);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Allerta newAllerta = addAllerta();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allerta.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("allertaId", newAllerta.getAllertaId()));

		List<Allerta> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Allerta existingAllerta = result.get(0);

		Assert.assertEquals(existingAllerta, newAllerta);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allerta.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("allertaId", RandomTestUtil.nextLong()));

		List<Allerta> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Allerta newAllerta = addAllerta();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allerta.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("allertaId"));

		Object newAllertaId = newAllerta.getAllertaId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaId", new Object[] {newAllertaId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAllertaId = result.get(0);

		Assert.assertEquals(existingAllertaId, newAllertaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allerta.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("allertaId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Allerta newAllerta = addAllerta();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAllerta.getPrimaryKey()));
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

		Allerta newAllerta = addAllerta();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Allerta.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("allertaId", newAllerta.getAllertaId()));

		List<Allerta> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Allerta allerta) {
		Assert.assertEquals(
			allerta.getUuid(),
			ReflectionTestUtil.invoke(
				allerta, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(allerta.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				allerta, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Allerta addAllerta() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Allerta allerta = _persistence.create(pk);

		allerta.setUuid(RandomTestUtil.randomString());

		allerta.setGroupId(RandomTestUtil.nextLong());

		allerta.setCompanyId(RandomTestUtil.nextLong());

		allerta.setUserId(RandomTestUtil.nextLong());

		allerta.setUserName(RandomTestUtil.randomString());

		allerta.setCreatorName(RandomTestUtil.randomString());

		allerta.setCreateDate(RandomTestUtil.nextDate());

		allerta.setModifiedDate(RandomTestUtil.nextDate());

		allerta.setStato(RandomTestUtil.nextInt());

		allerta.setNumero(RandomTestUtil.randomString());

		allerta.setProgressivo(RandomTestUtil.nextInt());

		allerta.setAnno(RandomTestUtil.nextInt());

		allerta.setDataEmissione(RandomTestUtil.nextDate());

		allerta.setDataInizio(RandomTestUtil.nextDate());

		allerta.setDataFine(RandomTestUtil.nextDate());

		allerta.setDescrizioneMeteo(RandomTestUtil.randomString());

		allerta.setTendenza(RandomTestUtil.nextInt());

		allerta.setNote(RandomTestUtil.randomString());

		allerta.setRiferimenti(RandomTestUtil.randomString());

		allerta.setUtenteFirmaArpaId(RandomTestUtil.nextLong());

		allerta.setDataFirmaArpa(RandomTestUtil.nextDate());

		allerta.setUtenteFirmaProtId(RandomTestUtil.nextLong());

		allerta.setDataFirmaProt(RandomTestUtil.nextDate());

		allerta.setParentId(RandomTestUtil.nextLong());

		allerta.setSintesi(RandomTestUtil.randomString());

		allerta.setSintesiEng(RandomTestUtil.randomString());

		allerta.setLink(RandomTestUtil.randomString());

		allerta.setTitolo(RandomTestUtil.randomString());

		allerta.setTitoloEng(RandomTestUtil.randomString());

		allerta.setTipoAllerta(RandomTestUtil.randomBoolean());

		allerta.setHash(RandomTestUtil.randomString());

		allerta.setSintesiBriefing(RandomTestUtil.randomString());

		_allertas.add(_persistence.update(allerta));

		return allerta;
	}

	private List<Allerta> _allertas = new ArrayList<Allerta>();
	private AllertaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}