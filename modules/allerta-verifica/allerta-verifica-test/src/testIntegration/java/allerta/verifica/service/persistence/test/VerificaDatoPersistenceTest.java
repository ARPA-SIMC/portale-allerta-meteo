/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.test;

import allerta.verifica.exception.NoSuchVerificaDatoException;
import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.VerificaDatoLocalServiceUtil;
import allerta.verifica.service.persistence.VerificaDatoPersistence;
import allerta.verifica.service.persistence.VerificaDatoUtil;

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
public class VerificaDatoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.verifica.service"));

	@Before
	public void setUp() {
		_persistence = VerificaDatoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<VerificaDato> iterator = _verificaDatos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		VerificaDato verificaDato = _persistence.create(pk);

		Assert.assertNotNull(verificaDato);

		Assert.assertEquals(verificaDato.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		VerificaDato newVerificaDato = addVerificaDato();

		_persistence.remove(newVerificaDato);

		VerificaDato existingVerificaDato = _persistence.fetchByPrimaryKey(
			newVerificaDato.getPrimaryKey());

		Assert.assertNull(existingVerificaDato);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVerificaDato();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		VerificaDato newVerificaDato = _persistence.create(pk);

		newVerificaDato.setDocumento(RandomTestUtil.nextLong());

		newVerificaDato.setGiorno(RandomTestUtil.nextDate());

		newVerificaDato.setZona(RandomTestUtil.randomString());

		newVerificaDato.setEvento(RandomTestUtil.nextLong());

		newVerificaDato.setNomeDato(RandomTestUtil.randomString());

		newVerificaDato.setProgressivo(RandomTestUtil.nextInt());

		newVerificaDato.setDatoInserito(RandomTestUtil.randomString());

		newVerificaDato.setDatoCalcolato(RandomTestUtil.randomString());

		_verificaDatos.add(_persistence.update(newVerificaDato));

		VerificaDato existingVerificaDato = _persistence.findByPrimaryKey(
			newVerificaDato.getPrimaryKey());

		Assert.assertEquals(
			existingVerificaDato.getId(), newVerificaDato.getId());
		Assert.assertEquals(
			existingVerificaDato.getDocumento(),
			newVerificaDato.getDocumento());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVerificaDato.getGiorno()),
			Time.getShortTimestamp(newVerificaDato.getGiorno()));
		Assert.assertEquals(
			existingVerificaDato.getZona(), newVerificaDato.getZona());
		Assert.assertEquals(
			existingVerificaDato.getEvento(), newVerificaDato.getEvento());
		Assert.assertEquals(
			existingVerificaDato.getNomeDato(), newVerificaDato.getNomeDato());
		Assert.assertEquals(
			existingVerificaDato.getProgressivo(),
			newVerificaDato.getProgressivo());
		Assert.assertEquals(
			existingVerificaDato.getDatoInserito(),
			newVerificaDato.getDatoInserito());
		Assert.assertEquals(
			existingVerificaDato.getDatoCalcolato(),
			newVerificaDato.getDatoCalcolato());
	}

	@Test
	public void testCountByDocumento() throws Exception {
		_persistence.countByDocumento(RandomTestUtil.nextLong());

		_persistence.countByDocumento(0L);
	}

	@Test
	public void testCountByDocumentoGiorno() throws Exception {
		_persistence.countByDocumentoGiorno(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate());

		_persistence.countByDocumentoGiorno(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByDocumentoGiornoEvento() throws Exception {
		_persistence.countByDocumentoGiornoEvento(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate(),
			RandomTestUtil.nextLong());

		_persistence.countByDocumentoGiornoEvento(
			0L, RandomTestUtil.nextDate(), 0L);
	}

	@Test
	public void testCountByDocumentoGiornoZona() throws Exception {
		_persistence.countByDocumentoGiornoZona(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate(), "");

		_persistence.countByDocumentoGiornoZona(
			0L, RandomTestUtil.nextDate(), "null");

		_persistence.countByDocumentoGiornoZona(
			0L, RandomTestUtil.nextDate(), (String)null);
	}

	@Test
	public void testCountByDocumentoGiornoZonaEvento() throws Exception {
		_persistence.countByDocumentoGiornoZonaEvento(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate(), "",
			RandomTestUtil.nextLong());

		_persistence.countByDocumentoGiornoZonaEvento(
			0L, RandomTestUtil.nextDate(), "null", 0L);

		_persistence.countByDocumentoGiornoZonaEvento(
			0L, RandomTestUtil.nextDate(), (String)null, 0L);
	}

	@Test
	public void testCountByGiorno() throws Exception {
		_persistence.countByGiorno(RandomTestUtil.nextDate());

		_persistence.countByGiorno(RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByGiornoZona() throws Exception {
		_persistence.countByGiornoZona(RandomTestUtil.nextDate(), "");

		_persistence.countByGiornoZona(RandomTestUtil.nextDate(), "null");

		_persistence.countByGiornoZona(RandomTestUtil.nextDate(), (String)null);
	}

	@Test
	public void testCountByGiornoEvento() throws Exception {
		_persistence.countByGiornoEvento(
			RandomTestUtil.nextDate(), RandomTestUtil.nextLong());

		_persistence.countByGiornoEvento(RandomTestUtil.nextDate(), 0L);
	}

	@Test
	public void testCountByGiornoZonaEvento() throws Exception {
		_persistence.countByGiornoZonaEvento(
			RandomTestUtil.nextDate(), "", RandomTestUtil.nextLong());

		_persistence.countByGiornoZonaEvento(
			RandomTestUtil.nextDate(), "null", 0L);

		_persistence.countByGiornoZonaEvento(
			RandomTestUtil.nextDate(), (String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		VerificaDato newVerificaDato = addVerificaDato();

		VerificaDato existingVerificaDato = _persistence.findByPrimaryKey(
			newVerificaDato.getPrimaryKey());

		Assert.assertEquals(existingVerificaDato, newVerificaDato);
	}

	@Test(expected = NoSuchVerificaDatoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<VerificaDato> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"VERIFICA_VerificaDato", "id", true, "documento", true, "giorno",
			true, "zona", true, "evento", true, "nomeDato", true, "progressivo",
			true, "datoInserito", true, "datoCalcolato", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		VerificaDato newVerificaDato = addVerificaDato();

		VerificaDato existingVerificaDato = _persistence.fetchByPrimaryKey(
			newVerificaDato.getPrimaryKey());

		Assert.assertEquals(existingVerificaDato, newVerificaDato);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		VerificaDato missingVerificaDato = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVerificaDato);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		VerificaDato newVerificaDato1 = addVerificaDato();
		VerificaDato newVerificaDato2 = addVerificaDato();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVerificaDato1.getPrimaryKey());
		primaryKeys.add(newVerificaDato2.getPrimaryKey());

		Map<Serializable, VerificaDato> verificaDatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, verificaDatos.size());
		Assert.assertEquals(
			newVerificaDato1,
			verificaDatos.get(newVerificaDato1.getPrimaryKey()));
		Assert.assertEquals(
			newVerificaDato2,
			verificaDatos.get(newVerificaDato2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, VerificaDato> verificaDatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(verificaDatos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		VerificaDato newVerificaDato = addVerificaDato();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVerificaDato.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, VerificaDato> verificaDatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, verificaDatos.size());
		Assert.assertEquals(
			newVerificaDato,
			verificaDatos.get(newVerificaDato.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, VerificaDato> verificaDatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(verificaDatos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		VerificaDato newVerificaDato = addVerificaDato();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVerificaDato.getPrimaryKey());

		Map<Serializable, VerificaDato> verificaDatos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, verificaDatos.size());
		Assert.assertEquals(
			newVerificaDato,
			verificaDatos.get(newVerificaDato.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VerificaDatoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<VerificaDato>() {

				@Override
				public void performAction(VerificaDato verificaDato) {
					Assert.assertNotNull(verificaDato);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		VerificaDato newVerificaDato = addVerificaDato();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			VerificaDato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newVerificaDato.getId()));

		List<VerificaDato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		VerificaDato existingVerificaDato = result.get(0);

		Assert.assertEquals(existingVerificaDato, newVerificaDato);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			VerificaDato.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<VerificaDato> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		VerificaDato newVerificaDato = addVerificaDato();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			VerificaDato.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVerificaDato.getId();

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
			VerificaDato.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected VerificaDato addVerificaDato() throws Exception {
		long pk = RandomTestUtil.nextLong();

		VerificaDato verificaDato = _persistence.create(pk);

		verificaDato.setDocumento(RandomTestUtil.nextLong());

		verificaDato.setGiorno(RandomTestUtil.nextDate());

		verificaDato.setZona(RandomTestUtil.randomString());

		verificaDato.setEvento(RandomTestUtil.nextLong());

		verificaDato.setNomeDato(RandomTestUtil.randomString());

		verificaDato.setProgressivo(RandomTestUtil.nextInt());

		verificaDato.setDatoInserito(RandomTestUtil.randomString());

		verificaDato.setDatoCalcolato(RandomTestUtil.randomString());

		_verificaDatos.add(_persistence.update(verificaDato));

		return verificaDato;
	}

	private List<VerificaDato> _verificaDatos = new ArrayList<VerificaDato>();
	private VerificaDatoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}