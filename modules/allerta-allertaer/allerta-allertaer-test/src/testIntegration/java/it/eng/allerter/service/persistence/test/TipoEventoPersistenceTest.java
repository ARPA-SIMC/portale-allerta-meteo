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

import it.eng.allerter.exception.NoSuchTipoEventoException;
import it.eng.allerter.model.TipoEvento;
import it.eng.allerter.service.TipoEventoLocalServiceUtil;
import it.eng.allerter.service.persistence.TipoEventoPersistence;
import it.eng.allerter.service.persistence.TipoEventoUtil;

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
public class TipoEventoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = TipoEventoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TipoEvento> iterator = _tipoEventos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TipoEvento tipoEvento = _persistence.create(pk);

		Assert.assertNotNull(tipoEvento);

		Assert.assertEquals(tipoEvento.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		_persistence.remove(newTipoEvento);

		TipoEvento existingTipoEvento = _persistence.fetchByPrimaryKey(
			newTipoEvento.getPrimaryKey());

		Assert.assertNull(existingTipoEvento);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTipoEvento();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TipoEvento newTipoEvento = _persistence.create(pk);

		newTipoEvento.setUuid(RandomTestUtil.randomString());

		newTipoEvento.setGroupId(RandomTestUtil.nextLong());

		newTipoEvento.setCompanyId(RandomTestUtil.nextLong());

		newTipoEvento.setUserId(RandomTestUtil.nextLong());

		newTipoEvento.setUserName(RandomTestUtil.randomString());

		newTipoEvento.setCreateDate(RandomTestUtil.nextDate());

		newTipoEvento.setModifiedDate(RandomTestUtil.nextDate());

		newTipoEvento.setNome(RandomTestUtil.randomString());

		newTipoEvento.setIndice(RandomTestUtil.nextInt());

		newTipoEvento.setTabella(RandomTestUtil.nextInt());

		newTipoEvento.setSplit(RandomTestUtil.randomBoolean());

		newTipoEvento.setCostiero(RandomTestUtil.randomBoolean());

		newTipoEvento.setDataInizio(RandomTestUtil.nextDate());

		newTipoEvento.setDataFine(RandomTestUtil.nextDate());

		newTipoEvento.setParentId(RandomTestUtil.nextLong());

		_tipoEventos.add(_persistence.update(newTipoEvento));

		TipoEvento existingTipoEvento = _persistence.findByPrimaryKey(
			newTipoEvento.getPrimaryKey());

		Assert.assertEquals(
			existingTipoEvento.getUuid(), newTipoEvento.getUuid());
		Assert.assertEquals(
			existingTipoEvento.getEventoId(), newTipoEvento.getEventoId());
		Assert.assertEquals(
			existingTipoEvento.getGroupId(), newTipoEvento.getGroupId());
		Assert.assertEquals(
			existingTipoEvento.getCompanyId(), newTipoEvento.getCompanyId());
		Assert.assertEquals(
			existingTipoEvento.getUserId(), newTipoEvento.getUserId());
		Assert.assertEquals(
			existingTipoEvento.getUserName(), newTipoEvento.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTipoEvento.getCreateDate()),
			Time.getShortTimestamp(newTipoEvento.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTipoEvento.getModifiedDate()),
			Time.getShortTimestamp(newTipoEvento.getModifiedDate()));
		Assert.assertEquals(
			existingTipoEvento.getNome(), newTipoEvento.getNome());
		Assert.assertEquals(
			existingTipoEvento.getIndice(), newTipoEvento.getIndice());
		Assert.assertEquals(
			existingTipoEvento.getTabella(), newTipoEvento.getTabella());
		Assert.assertEquals(
			existingTipoEvento.isSplit(), newTipoEvento.isSplit());
		Assert.assertEquals(
			existingTipoEvento.isCostiero(), newTipoEvento.isCostiero());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTipoEvento.getDataInizio()),
			Time.getShortTimestamp(newTipoEvento.getDataInizio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTipoEvento.getDataFine()),
			Time.getShortTimestamp(newTipoEvento.getDataFine()));
		Assert.assertEquals(
			existingTipoEvento.getParentId(), newTipoEvento.getParentId());
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
	public void testCountByNome() throws Exception {
		_persistence.countByNome("");

		_persistence.countByNome("null");

		_persistence.countByNome((String)null);
	}

	@Test
	public void testCountByTabella() throws Exception {
		_persistence.countByTabella(RandomTestUtil.nextInt());

		_persistence.countByTabella(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		TipoEvento existingTipoEvento = _persistence.findByPrimaryKey(
			newTipoEvento.getPrimaryKey());

		Assert.assertEquals(existingTipoEvento, newTipoEvento);
	}

	@Test(expected = NoSuchTipoEventoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<TipoEvento> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_TipoEvento", "uuid", true, "eventoId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "nome", true, "indice",
			true, "tabella", true, "split", true, "costiero", true,
			"dataInizio", true, "dataFine", true, "parentId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		TipoEvento existingTipoEvento = _persistence.fetchByPrimaryKey(
			newTipoEvento.getPrimaryKey());

		Assert.assertEquals(existingTipoEvento, newTipoEvento);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TipoEvento missingTipoEvento = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTipoEvento);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		TipoEvento newTipoEvento1 = addTipoEvento();
		TipoEvento newTipoEvento2 = addTipoEvento();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTipoEvento1.getPrimaryKey());
		primaryKeys.add(newTipoEvento2.getPrimaryKey());

		Map<Serializable, TipoEvento> tipoEventos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, tipoEventos.size());
		Assert.assertEquals(
			newTipoEvento1, tipoEventos.get(newTipoEvento1.getPrimaryKey()));
		Assert.assertEquals(
			newTipoEvento2, tipoEventos.get(newTipoEvento2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TipoEvento> tipoEventos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(tipoEventos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		TipoEvento newTipoEvento = addTipoEvento();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTipoEvento.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TipoEvento> tipoEventos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, tipoEventos.size());
		Assert.assertEquals(
			newTipoEvento, tipoEventos.get(newTipoEvento.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TipoEvento> tipoEventos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(tipoEventos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTipoEvento.getPrimaryKey());

		Map<Serializable, TipoEvento> tipoEventos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, tipoEventos.size());
		Assert.assertEquals(
			newTipoEvento, tipoEventos.get(newTipoEvento.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TipoEventoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<TipoEvento>() {

				@Override
				public void performAction(TipoEvento tipoEvento) {
					Assert.assertNotNull(tipoEvento);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TipoEvento.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"eventoId", newTipoEvento.getEventoId()));

		List<TipoEvento> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		TipoEvento existingTipoEvento = result.get(0);

		Assert.assertEquals(existingTipoEvento, newTipoEvento);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TipoEvento.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("eventoId", RandomTestUtil.nextLong()));

		List<TipoEvento> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TipoEvento.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("eventoId"));

		Object newEventoId = newTipoEvento.getEventoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("eventoId", new Object[] {newEventoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEventoId = result.get(0);

		Assert.assertEquals(existingEventoId, newEventoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TipoEvento.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("eventoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"eventoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TipoEvento newTipoEvento = addTipoEvento();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newTipoEvento.getPrimaryKey()));
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

		TipoEvento newTipoEvento = addTipoEvento();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TipoEvento.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"eventoId", newTipoEvento.getEventoId()));

		List<TipoEvento> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(TipoEvento tipoEvento) {
		Assert.assertEquals(
			tipoEvento.getUuid(),
			ReflectionTestUtil.invoke(
				tipoEvento, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(tipoEvento.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				tipoEvento, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected TipoEvento addTipoEvento() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TipoEvento tipoEvento = _persistence.create(pk);

		tipoEvento.setUuid(RandomTestUtil.randomString());

		tipoEvento.setGroupId(RandomTestUtil.nextLong());

		tipoEvento.setCompanyId(RandomTestUtil.nextLong());

		tipoEvento.setUserId(RandomTestUtil.nextLong());

		tipoEvento.setUserName(RandomTestUtil.randomString());

		tipoEvento.setCreateDate(RandomTestUtil.nextDate());

		tipoEvento.setModifiedDate(RandomTestUtil.nextDate());

		tipoEvento.setNome(RandomTestUtil.randomString());

		tipoEvento.setIndice(RandomTestUtil.nextInt());

		tipoEvento.setTabella(RandomTestUtil.nextInt());

		tipoEvento.setSplit(RandomTestUtil.randomBoolean());

		tipoEvento.setCostiero(RandomTestUtil.randomBoolean());

		tipoEvento.setDataInizio(RandomTestUtil.nextDate());

		tipoEvento.setDataFine(RandomTestUtil.nextDate());

		tipoEvento.setParentId(RandomTestUtil.nextLong());

		_tipoEventos.add(_persistence.update(tipoEvento));

		return tipoEvento;
	}

	private List<TipoEvento> _tipoEventos = new ArrayList<TipoEvento>();
	private TipoEventoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}