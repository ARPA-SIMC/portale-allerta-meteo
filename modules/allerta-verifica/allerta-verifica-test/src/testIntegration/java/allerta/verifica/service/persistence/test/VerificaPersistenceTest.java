/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.test;

import allerta.verifica.exception.NoSuchVerificaException;
import allerta.verifica.model.Verifica;
import allerta.verifica.service.VerificaLocalServiceUtil;
import allerta.verifica.service.persistence.VerificaPersistence;
import allerta.verifica.service.persistence.VerificaUtil;

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
public class VerificaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.verifica.service"));

	@Before
	public void setUp() {
		_persistence = VerificaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Verifica> iterator = _verificas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Verifica verifica = _persistence.create(pk);

		Assert.assertNotNull(verifica);

		Assert.assertEquals(verifica.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Verifica newVerifica = addVerifica();

		_persistence.remove(newVerifica);

		Verifica existingVerifica = _persistence.fetchByPrimaryKey(
			newVerifica.getPrimaryKey());

		Assert.assertNull(existingVerifica);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVerifica();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Verifica newVerifica = _persistence.create(pk);

		newVerifica.setUuid(RandomTestUtil.randomString());

		newVerifica.setGroupId(RandomTestUtil.nextLong());

		newVerifica.setCompanyId(RandomTestUtil.nextLong());

		newVerifica.setUserId(RandomTestUtil.nextLong());

		newVerifica.setUserName(RandomTestUtil.randomString());

		newVerifica.setCreateDate(RandomTestUtil.nextDate());

		newVerifica.setModifiedDate(RandomTestUtil.nextDate());

		newVerifica.setDocumento(RandomTestUtil.nextLong());

		newVerifica.setStato(RandomTestUtil.nextInt());

		newVerifica.setTitolo(RandomTestUtil.randomString());

		newVerifica.setFenomeni(RandomTestUtil.randomString());

		newVerifica.setFenomeniDescritti(RandomTestUtil.randomString());

		newVerifica.setNote(RandomTestUtil.randomString());

		newVerifica.setDataInizio(RandomTestUtil.nextDate());

		newVerifica.setDataFine(RandomTestUtil.nextDate());

		newVerifica.setLink(RandomTestUtil.randomString());

		newVerifica.setHash(RandomTestUtil.randomString());

		_verificas.add(_persistence.update(newVerifica));

		Verifica existingVerifica = _persistence.findByPrimaryKey(
			newVerifica.getPrimaryKey());

		Assert.assertEquals(existingVerifica.getUuid(), newVerifica.getUuid());
		Assert.assertEquals(existingVerifica.getId(), newVerifica.getId());
		Assert.assertEquals(
			existingVerifica.getGroupId(), newVerifica.getGroupId());
		Assert.assertEquals(
			existingVerifica.getCompanyId(), newVerifica.getCompanyId());
		Assert.assertEquals(
			existingVerifica.getUserId(), newVerifica.getUserId());
		Assert.assertEquals(
			existingVerifica.getUserName(), newVerifica.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVerifica.getCreateDate()),
			Time.getShortTimestamp(newVerifica.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVerifica.getModifiedDate()),
			Time.getShortTimestamp(newVerifica.getModifiedDate()));
		Assert.assertEquals(
			existingVerifica.getDocumento(), newVerifica.getDocumento());
		Assert.assertEquals(
			existingVerifica.getStato(), newVerifica.getStato());
		Assert.assertEquals(
			existingVerifica.getTitolo(), newVerifica.getTitolo());
		Assert.assertEquals(
			existingVerifica.getFenomeni(), newVerifica.getFenomeni());
		Assert.assertEquals(
			existingVerifica.getFenomeniDescritti(),
			newVerifica.getFenomeniDescritti());
		Assert.assertEquals(existingVerifica.getNote(), newVerifica.getNote());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVerifica.getDataInizio()),
			Time.getShortTimestamp(newVerifica.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVerifica.getDataFine()),
			Time.getShortTimestamp(newVerifica.getDataFine()));
		Assert.assertEquals(existingVerifica.getLink(), newVerifica.getLink());
		Assert.assertEquals(existingVerifica.getHash(), newVerifica.getHash());
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
	public void testCountByDocumento() throws Exception {
		_persistence.countByDocumento(RandomTestUtil.nextLong());

		_persistence.countByDocumento(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Verifica newVerifica = addVerifica();

		Verifica existingVerifica = _persistence.findByPrimaryKey(
			newVerifica.getPrimaryKey());

		Assert.assertEquals(existingVerifica, newVerifica);
	}

	@Test(expected = NoSuchVerificaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Verifica> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"VERIFICA_Verifica", "uuid", true, "id", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "documento", true, "stato", true,
			"titolo", true, "fenomeni", true, "fenomeniDescritti", true, "note",
			true, "dataInizio", true, "dataFine", true, "link", true, "hash",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Verifica newVerifica = addVerifica();

		Verifica existingVerifica = _persistence.fetchByPrimaryKey(
			newVerifica.getPrimaryKey());

		Assert.assertEquals(existingVerifica, newVerifica);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Verifica missingVerifica = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVerifica);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Verifica newVerifica1 = addVerifica();
		Verifica newVerifica2 = addVerifica();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVerifica1.getPrimaryKey());
		primaryKeys.add(newVerifica2.getPrimaryKey());

		Map<Serializable, Verifica> verificas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, verificas.size());
		Assert.assertEquals(
			newVerifica1, verificas.get(newVerifica1.getPrimaryKey()));
		Assert.assertEquals(
			newVerifica2, verificas.get(newVerifica2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Verifica> verificas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(verificas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Verifica newVerifica = addVerifica();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVerifica.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Verifica> verificas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, verificas.size());
		Assert.assertEquals(
			newVerifica, verificas.get(newVerifica.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Verifica> verificas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(verificas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Verifica newVerifica = addVerifica();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVerifica.getPrimaryKey());

		Map<Serializable, Verifica> verificas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, verificas.size());
		Assert.assertEquals(
			newVerifica, verificas.get(newVerifica.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VerificaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Verifica>() {

				@Override
				public void performAction(Verifica verifica) {
					Assert.assertNotNull(verifica);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Verifica newVerifica = addVerifica();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Verifica.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newVerifica.getId()));

		List<Verifica> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Verifica existingVerifica = result.get(0);

		Assert.assertEquals(existingVerifica, newVerifica);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Verifica.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Verifica> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Verifica newVerifica = addVerifica();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Verifica.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVerifica.getId();

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
			Verifica.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Verifica newVerifica = addVerifica();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newVerifica.getPrimaryKey()));
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

		Verifica newVerifica = addVerifica();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Verifica.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newVerifica.getId()));

		List<Verifica> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Verifica verifica) {
		Assert.assertEquals(
			verifica.getUuid(),
			ReflectionTestUtil.invoke(
				verifica, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(verifica.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				verifica, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Verifica addVerifica() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Verifica verifica = _persistence.create(pk);

		verifica.setUuid(RandomTestUtil.randomString());

		verifica.setGroupId(RandomTestUtil.nextLong());

		verifica.setCompanyId(RandomTestUtil.nextLong());

		verifica.setUserId(RandomTestUtil.nextLong());

		verifica.setUserName(RandomTestUtil.randomString());

		verifica.setCreateDate(RandomTestUtil.nextDate());

		verifica.setModifiedDate(RandomTestUtil.nextDate());

		verifica.setDocumento(RandomTestUtil.nextLong());

		verifica.setStato(RandomTestUtil.nextInt());

		verifica.setTitolo(RandomTestUtil.randomString());

		verifica.setFenomeni(RandomTestUtil.randomString());

		verifica.setFenomeniDescritti(RandomTestUtil.randomString());

		verifica.setNote(RandomTestUtil.randomString());

		verifica.setDataInizio(RandomTestUtil.nextDate());

		verifica.setDataFine(RandomTestUtil.nextDate());

		verifica.setLink(RandomTestUtil.randomString());

		verifica.setHash(RandomTestUtil.randomString());

		_verificas.add(_persistence.update(verifica));

		return verifica;
	}

	private List<Verifica> _verificas = new ArrayList<Verifica>();
	private VerificaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}