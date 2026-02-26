/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.test;

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

import it.eng.bollettino.exception.NoSuchBollettinoException;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.persistence.BollettinoPersistence;
import it.eng.bollettino.service.persistence.BollettinoUtil;

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
public class BollettinoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = BollettinoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Bollettino> iterator = _bollettinos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bollettino bollettino = _persistence.create(pk);

		Assert.assertNotNull(bollettino);

		Assert.assertEquals(bollettino.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Bollettino newBollettino = addBollettino();

		_persistence.remove(newBollettino);

		Bollettino existingBollettino = _persistence.fetchByPrimaryKey(
			newBollettino.getPrimaryKey());

		Assert.assertNull(existingBollettino);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBollettino();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bollettino newBollettino = _persistence.create(pk);

		newBollettino.setUuid(RandomTestUtil.randomString());

		newBollettino.setGroupId(RandomTestUtil.nextLong());

		newBollettino.setCompanyId(RandomTestUtil.nextLong());

		newBollettino.setUserId(RandomTestUtil.nextLong());

		newBollettino.setUserName(RandomTestUtil.randomString());

		newBollettino.setCreateDate(RandomTestUtil.nextDate());

		newBollettino.setModifiedDate(RandomTestUtil.nextDate());

		newBollettino.setStato(RandomTestUtil.nextInt());

		newBollettino.setIdApprovatore(RandomTestUtil.nextLong());

		newBollettino.setDataApprovazione(RandomTestUtil.nextDate());

		newBollettino.setNumero(RandomTestUtil.randomString());

		newBollettino.setProgressivo(RandomTestUtil.nextInt());

		newBollettino.setAnno(RandomTestUtil.nextInt());

		newBollettino.setDataEmissione(RandomTestUtil.nextDate());

		newBollettino.setDataInizio(RandomTestUtil.nextDate());

		newBollettino.setDataFine(RandomTestUtil.nextDate());

		newBollettino.setNoteMeteo(RandomTestUtil.randomString());

		newBollettino.setStringaMeteo(RandomTestUtil.randomString());

		newBollettino.setLink(RandomTestUtil.randomString());

		newBollettino.setUltimo(RandomTestUtil.randomBoolean());

		newBollettino.setHash(RandomTestUtil.randomString());

		_bollettinos.add(_persistence.update(newBollettino));

		Bollettino existingBollettino = _persistence.findByPrimaryKey(
			newBollettino.getPrimaryKey());

		Assert.assertEquals(
			existingBollettino.getUuid(), newBollettino.getUuid());
		Assert.assertEquals(
			existingBollettino.getBollettinoId(),
			newBollettino.getBollettinoId());
		Assert.assertEquals(
			existingBollettino.getGroupId(), newBollettino.getGroupId());
		Assert.assertEquals(
			existingBollettino.getCompanyId(), newBollettino.getCompanyId());
		Assert.assertEquals(
			existingBollettino.getUserId(), newBollettino.getUserId());
		Assert.assertEquals(
			existingBollettino.getUserName(), newBollettino.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBollettino.getCreateDate()),
			Time.getShortTimestamp(newBollettino.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBollettino.getModifiedDate()),
			Time.getShortTimestamp(newBollettino.getModifiedDate()));
		Assert.assertEquals(
			existingBollettino.getStato(), newBollettino.getStato());
		Assert.assertEquals(
			existingBollettino.getIdApprovatore(),
			newBollettino.getIdApprovatore());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBollettino.getDataApprovazione()),
			Time.getShortTimestamp(newBollettino.getDataApprovazione()));
		Assert.assertEquals(
			existingBollettino.getNumero(), newBollettino.getNumero());
		Assert.assertEquals(
			existingBollettino.getProgressivo(),
			newBollettino.getProgressivo());
		Assert.assertEquals(
			existingBollettino.getAnno(), newBollettino.getAnno());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBollettino.getDataEmissione()),
			Time.getShortTimestamp(newBollettino.getDataEmissione()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBollettino.getDataInizio()),
			Time.getShortTimestamp(newBollettino.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBollettino.getDataFine()),
			Time.getShortTimestamp(newBollettino.getDataFine()));
		Assert.assertEquals(
			existingBollettino.getNoteMeteo(), newBollettino.getNoteMeteo());
		Assert.assertEquals(
			existingBollettino.getStringaMeteo(),
			newBollettino.getStringaMeteo());
		Assert.assertEquals(
			existingBollettino.getLink(), newBollettino.getLink());
		Assert.assertEquals(
			existingBollettino.isUltimo(), newBollettino.isUltimo());
		Assert.assertEquals(
			existingBollettino.getHash(), newBollettino.getHash());
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
		Bollettino newBollettino = addBollettino();

		Bollettino existingBollettino = _persistence.findByPrimaryKey(
			newBollettino.getPrimaryKey());

		Assert.assertEquals(existingBollettino, newBollettino);
	}

	@Test(expected = NoSuchBollettinoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Bollettino> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Bollettino", "uuid", true, "bollettinoId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "stato", true,
			"idApprovatore", true, "dataApprovazione", true, "numero", true,
			"progressivo", true, "anno", true, "dataEmissione", true,
			"dataInizio", true, "dataFine", true, "noteMeteo", true,
			"stringaMeteo", true, "link", true, "ultimo", true, "hash", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Bollettino newBollettino = addBollettino();

		Bollettino existingBollettino = _persistence.fetchByPrimaryKey(
			newBollettino.getPrimaryKey());

		Assert.assertEquals(existingBollettino, newBollettino);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bollettino missingBollettino = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBollettino);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Bollettino newBollettino1 = addBollettino();
		Bollettino newBollettino2 = addBollettino();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettino1.getPrimaryKey());
		primaryKeys.add(newBollettino2.getPrimaryKey());

		Map<Serializable, Bollettino> bollettinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bollettinos.size());
		Assert.assertEquals(
			newBollettino1, bollettinos.get(newBollettino1.getPrimaryKey()));
		Assert.assertEquals(
			newBollettino2, bollettinos.get(newBollettino2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Bollettino> bollettinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Bollettino newBollettino = addBollettino();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettino.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Bollettino> bollettinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinos.size());
		Assert.assertEquals(
			newBollettino, bollettinos.get(newBollettino.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Bollettino> bollettinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bollettinos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Bollettino newBollettino = addBollettino();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBollettino.getPrimaryKey());

		Map<Serializable, Bollettino> bollettinos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bollettinos.size());
		Assert.assertEquals(
			newBollettino, bollettinos.get(newBollettino.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BollettinoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Bollettino>() {

				@Override
				public void performAction(Bollettino bollettino) {
					Assert.assertNotNull(bollettino);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Bollettino newBollettino = addBollettino();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bollettino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"bollettinoId", newBollettino.getBollettinoId()));

		List<Bollettino> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Bollettino existingBollettino = result.get(0);

		Assert.assertEquals(existingBollettino, newBollettino);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bollettino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"bollettinoId", RandomTestUtil.nextLong()));

		List<Bollettino> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Bollettino newBollettino = addBollettino();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bollettino.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("bollettinoId"));

		Object newBollettinoId = newBollettino.getBollettinoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"bollettinoId", new Object[] {newBollettinoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBollettinoId = result.get(0);

		Assert.assertEquals(existingBollettinoId, newBollettinoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bollettino.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("bollettinoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"bollettinoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Bollettino newBollettino = addBollettino();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newBollettino.getPrimaryKey()));
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

		Bollettino newBollettino = addBollettino();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bollettino.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"bollettinoId", newBollettino.getBollettinoId()));

		List<Bollettino> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Bollettino bollettino) {
		Assert.assertEquals(
			bollettino.getUuid(),
			ReflectionTestUtil.invoke(
				bollettino, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(bollettino.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				bollettino, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Bollettino addBollettino() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bollettino bollettino = _persistence.create(pk);

		bollettino.setUuid(RandomTestUtil.randomString());

		bollettino.setGroupId(RandomTestUtil.nextLong());

		bollettino.setCompanyId(RandomTestUtil.nextLong());

		bollettino.setUserId(RandomTestUtil.nextLong());

		bollettino.setUserName(RandomTestUtil.randomString());

		bollettino.setCreateDate(RandomTestUtil.nextDate());

		bollettino.setModifiedDate(RandomTestUtil.nextDate());

		bollettino.setStato(RandomTestUtil.nextInt());

		bollettino.setIdApprovatore(RandomTestUtil.nextLong());

		bollettino.setDataApprovazione(RandomTestUtil.nextDate());

		bollettino.setNumero(RandomTestUtil.randomString());

		bollettino.setProgressivo(RandomTestUtil.nextInt());

		bollettino.setAnno(RandomTestUtil.nextInt());

		bollettino.setDataEmissione(RandomTestUtil.nextDate());

		bollettino.setDataInizio(RandomTestUtil.nextDate());

		bollettino.setDataFine(RandomTestUtil.nextDate());

		bollettino.setNoteMeteo(RandomTestUtil.randomString());

		bollettino.setStringaMeteo(RandomTestUtil.randomString());

		bollettino.setLink(RandomTestUtil.randomString());

		bollettino.setUltimo(RandomTestUtil.randomBoolean());

		bollettino.setHash(RandomTestUtil.randomString());

		_bollettinos.add(_persistence.update(bollettino));

		return bollettino;
	}

	private List<Bollettino> _bollettinos = new ArrayList<Bollettino>();
	private BollettinoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}