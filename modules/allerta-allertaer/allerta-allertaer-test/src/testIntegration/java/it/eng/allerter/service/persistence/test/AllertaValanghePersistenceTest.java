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

import it.eng.allerter.exception.NoSuchAllertaValangheException;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaValangheLocalServiceUtil;
import it.eng.allerter.service.persistence.AllertaValanghePersistence;
import it.eng.allerter.service.persistence.AllertaValangheUtil;

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
public class AllertaValanghePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = AllertaValangheUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AllertaValanghe> iterator = _allertaValanghes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValanghe allertaValanghe = _persistence.create(pk);

		Assert.assertNotNull(allertaValanghe);

		Assert.assertEquals(allertaValanghe.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		_persistence.remove(newAllertaValanghe);

		AllertaValanghe existingAllertaValanghe =
			_persistence.fetchByPrimaryKey(newAllertaValanghe.getPrimaryKey());

		Assert.assertNull(existingAllertaValanghe);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAllertaValanghe();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValanghe newAllertaValanghe = _persistence.create(pk);

		newAllertaValanghe.setUuid(RandomTestUtil.randomString());

		newAllertaValanghe.setGroupId(RandomTestUtil.nextLong());

		newAllertaValanghe.setCompanyId(RandomTestUtil.nextLong());

		newAllertaValanghe.setUserId(RandomTestUtil.nextLong());

		newAllertaValanghe.setUserName(RandomTestUtil.randomString());

		newAllertaValanghe.setCreatorName(RandomTestUtil.randomString());

		newAllertaValanghe.setCreateDate(RandomTestUtil.nextDate());

		newAllertaValanghe.setModifiedDate(RandomTestUtil.nextDate());

		newAllertaValanghe.setDataEmissione(RandomTestUtil.nextDate());

		newAllertaValanghe.setDataInizio(RandomTestUtil.nextDate());

		newAllertaValanghe.setDataFine(RandomTestUtil.nextDate());

		newAllertaValanghe.setNumero(RandomTestUtil.randomString());

		newAllertaValanghe.setProgressivo(RandomTestUtil.nextInt());

		newAllertaValanghe.setAnno(RandomTestUtil.nextInt());

		newAllertaValanghe.setTitolo(RandomTestUtil.randomString());

		newAllertaValanghe.setDescrizioneFenomeni(
			RandomTestUtil.randomString());

		newAllertaValanghe.setNote(RandomTestUtil.randomString());

		newAllertaValanghe.setRiferimenti(RandomTestUtil.randomString());

		newAllertaValanghe.setSintesi(RandomTestUtil.randomString());

		newAllertaValanghe.setUtenteFirmaArpaId(RandomTestUtil.nextLong());

		newAllertaValanghe.setDataFirmaArpa(RandomTestUtil.nextDate());

		newAllertaValanghe.setUtenteFirmaProtId(RandomTestUtil.nextLong());

		newAllertaValanghe.setDataFirmaProt(RandomTestUtil.nextDate());

		newAllertaValanghe.setParentId(RandomTestUtil.nextLong());

		newAllertaValanghe.setLink(RandomTestUtil.randomString());

		newAllertaValanghe.setStato(RandomTestUtil.nextInt());

		newAllertaValanghe.setTipoAllerta(RandomTestUtil.randomBoolean());

		newAllertaValanghe.setHash(RandomTestUtil.randomString());

		_allertaValanghes.add(_persistence.update(newAllertaValanghe));

		AllertaValanghe existingAllertaValanghe = _persistence.findByPrimaryKey(
			newAllertaValanghe.getPrimaryKey());

		Assert.assertEquals(
			existingAllertaValanghe.getUuid(), newAllertaValanghe.getUuid());
		Assert.assertEquals(
			existingAllertaValanghe.getAllertaValangheId(),
			newAllertaValanghe.getAllertaValangheId());
		Assert.assertEquals(
			existingAllertaValanghe.getGroupId(),
			newAllertaValanghe.getGroupId());
		Assert.assertEquals(
			existingAllertaValanghe.getCompanyId(),
			newAllertaValanghe.getCompanyId());
		Assert.assertEquals(
			existingAllertaValanghe.getUserId(),
			newAllertaValanghe.getUserId());
		Assert.assertEquals(
			existingAllertaValanghe.getUserName(),
			newAllertaValanghe.getUserName());
		Assert.assertEquals(
			existingAllertaValanghe.getCreatorName(),
			newAllertaValanghe.getCreatorName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getCreateDate()),
			Time.getShortTimestamp(newAllertaValanghe.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getModifiedDate()),
			Time.getShortTimestamp(newAllertaValanghe.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getDataEmissione()),
			Time.getShortTimestamp(newAllertaValanghe.getDataEmissione()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getDataInizio()),
			Time.getShortTimestamp(newAllertaValanghe.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getDataFine()),
			Time.getShortTimestamp(newAllertaValanghe.getDataFine()));
		Assert.assertEquals(
			existingAllertaValanghe.getNumero(),
			newAllertaValanghe.getNumero());
		Assert.assertEquals(
			existingAllertaValanghe.getProgressivo(),
			newAllertaValanghe.getProgressivo());
		Assert.assertEquals(
			existingAllertaValanghe.getAnno(), newAllertaValanghe.getAnno());
		Assert.assertEquals(
			existingAllertaValanghe.getTitolo(),
			newAllertaValanghe.getTitolo());
		Assert.assertEquals(
			existingAllertaValanghe.getDescrizioneFenomeni(),
			newAllertaValanghe.getDescrizioneFenomeni());
		Assert.assertEquals(
			existingAllertaValanghe.getNote(), newAllertaValanghe.getNote());
		Assert.assertEquals(
			existingAllertaValanghe.getRiferimenti(),
			newAllertaValanghe.getRiferimenti());
		Assert.assertEquals(
			existingAllertaValanghe.getSintesi(),
			newAllertaValanghe.getSintesi());
		Assert.assertEquals(
			existingAllertaValanghe.getUtenteFirmaArpaId(),
			newAllertaValanghe.getUtenteFirmaArpaId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getDataFirmaArpa()),
			Time.getShortTimestamp(newAllertaValanghe.getDataFirmaArpa()));
		Assert.assertEquals(
			existingAllertaValanghe.getUtenteFirmaProtId(),
			newAllertaValanghe.getUtenteFirmaProtId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAllertaValanghe.getDataFirmaProt()),
			Time.getShortTimestamp(newAllertaValanghe.getDataFirmaProt()));
		Assert.assertEquals(
			existingAllertaValanghe.getParentId(),
			newAllertaValanghe.getParentId());
		Assert.assertEquals(
			existingAllertaValanghe.getLink(), newAllertaValanghe.getLink());
		Assert.assertEquals(
			existingAllertaValanghe.getStato(), newAllertaValanghe.getStato());
		Assert.assertEquals(
			existingAllertaValanghe.isTipoAllerta(),
			newAllertaValanghe.isTipoAllerta());
		Assert.assertEquals(
			existingAllertaValanghe.getHash(), newAllertaValanghe.getHash());
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
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		AllertaValanghe existingAllertaValanghe = _persistence.findByPrimaryKey(
			newAllertaValanghe.getPrimaryKey());

		Assert.assertEquals(existingAllertaValanghe, newAllertaValanghe);
	}

	@Test(expected = NoSuchAllertaValangheException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AllertaValanghe> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_AllertaValanghe", "uuid", true, "allertaValangheId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "creatorName", true, "createDate", true, "modifiedDate", true,
			"dataEmissione", true, "dataInizio", true, "dataFine", true,
			"numero", true, "progressivo", true, "anno", true, "titolo", true,
			"descrizioneFenomeni", true, "note", true, "riferimenti", true,
			"sintesi", true, "utenteFirmaArpaId", true, "dataFirmaArpa", true,
			"utenteFirmaProtId", true, "dataFirmaProt", true, "parentId", true,
			"link", true, "stato", true, "tipoAllerta", true, "hash", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		AllertaValanghe existingAllertaValanghe =
			_persistence.fetchByPrimaryKey(newAllertaValanghe.getPrimaryKey());

		Assert.assertEquals(existingAllertaValanghe, newAllertaValanghe);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValanghe missingAllertaValanghe = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingAllertaValanghe);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AllertaValanghe newAllertaValanghe1 = addAllertaValanghe();
		AllertaValanghe newAllertaValanghe2 = addAllertaValanghe();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaValanghe1.getPrimaryKey());
		primaryKeys.add(newAllertaValanghe2.getPrimaryKey());

		Map<Serializable, AllertaValanghe> allertaValanghes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, allertaValanghes.size());
		Assert.assertEquals(
			newAllertaValanghe1,
			allertaValanghes.get(newAllertaValanghe1.getPrimaryKey()));
		Assert.assertEquals(
			newAllertaValanghe2,
			allertaValanghes.get(newAllertaValanghe2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AllertaValanghe> allertaValanghes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaValanghes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaValanghe.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AllertaValanghe> allertaValanghes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaValanghes.size());
		Assert.assertEquals(
			newAllertaValanghe,
			allertaValanghes.get(newAllertaValanghe.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AllertaValanghe> allertaValanghes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(allertaValanghes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAllertaValanghe.getPrimaryKey());

		Map<Serializable, AllertaValanghe> allertaValanghes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, allertaValanghes.size());
		Assert.assertEquals(
			newAllertaValanghe,
			allertaValanghes.get(newAllertaValanghe.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AllertaValangheLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AllertaValanghe>() {

				@Override
				public void performAction(AllertaValanghe allertaValanghe) {
					Assert.assertNotNull(allertaValanghe);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValanghe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaValangheId",
				newAllertaValanghe.getAllertaValangheId()));

		List<AllertaValanghe> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AllertaValanghe existingAllertaValanghe = result.get(0);

		Assert.assertEquals(existingAllertaValanghe, newAllertaValanghe);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValanghe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaValangheId", RandomTestUtil.nextLong()));

		List<AllertaValanghe> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValanghe.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("allertaValangheId"));

		Object newAllertaValangheId = newAllertaValanghe.getAllertaValangheId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaValangheId", new Object[] {newAllertaValangheId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAllertaValangheId = result.get(0);

		Assert.assertEquals(existingAllertaValangheId, newAllertaValangheId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValanghe.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("allertaValangheId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"allertaValangheId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAllertaValanghe.getPrimaryKey()));
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

		AllertaValanghe newAllertaValanghe = addAllertaValanghe();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AllertaValanghe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"allertaValangheId",
				newAllertaValanghe.getAllertaValangheId()));

		List<AllertaValanghe> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(AllertaValanghe allertaValanghe) {
		Assert.assertEquals(
			allertaValanghe.getUuid(),
			ReflectionTestUtil.invoke(
				allertaValanghe, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(allertaValanghe.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				allertaValanghe, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AllertaValanghe addAllertaValanghe() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AllertaValanghe allertaValanghe = _persistence.create(pk);

		allertaValanghe.setUuid(RandomTestUtil.randomString());

		allertaValanghe.setGroupId(RandomTestUtil.nextLong());

		allertaValanghe.setCompanyId(RandomTestUtil.nextLong());

		allertaValanghe.setUserId(RandomTestUtil.nextLong());

		allertaValanghe.setUserName(RandomTestUtil.randomString());

		allertaValanghe.setCreatorName(RandomTestUtil.randomString());

		allertaValanghe.setCreateDate(RandomTestUtil.nextDate());

		allertaValanghe.setModifiedDate(RandomTestUtil.nextDate());

		allertaValanghe.setDataEmissione(RandomTestUtil.nextDate());

		allertaValanghe.setDataInizio(RandomTestUtil.nextDate());

		allertaValanghe.setDataFine(RandomTestUtil.nextDate());

		allertaValanghe.setNumero(RandomTestUtil.randomString());

		allertaValanghe.setProgressivo(RandomTestUtil.nextInt());

		allertaValanghe.setAnno(RandomTestUtil.nextInt());

		allertaValanghe.setTitolo(RandomTestUtil.randomString());

		allertaValanghe.setDescrizioneFenomeni(RandomTestUtil.randomString());

		allertaValanghe.setNote(RandomTestUtil.randomString());

		allertaValanghe.setRiferimenti(RandomTestUtil.randomString());

		allertaValanghe.setSintesi(RandomTestUtil.randomString());

		allertaValanghe.setUtenteFirmaArpaId(RandomTestUtil.nextLong());

		allertaValanghe.setDataFirmaArpa(RandomTestUtil.nextDate());

		allertaValanghe.setUtenteFirmaProtId(RandomTestUtil.nextLong());

		allertaValanghe.setDataFirmaProt(RandomTestUtil.nextDate());

		allertaValanghe.setParentId(RandomTestUtil.nextLong());

		allertaValanghe.setLink(RandomTestUtil.randomString());

		allertaValanghe.setStato(RandomTestUtil.nextInt());

		allertaValanghe.setTipoAllerta(RandomTestUtil.randomBoolean());

		allertaValanghe.setHash(RandomTestUtil.randomString());

		_allertaValanghes.add(_persistence.update(allertaValanghe));

		return allertaValanghe;
	}

	private List<AllertaValanghe> _allertaValanghes =
		new ArrayList<AllertaValanghe>();
	private AllertaValanghePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}