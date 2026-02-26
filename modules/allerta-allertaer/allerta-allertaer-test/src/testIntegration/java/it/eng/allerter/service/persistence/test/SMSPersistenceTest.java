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

import it.eng.allerter.exception.NoSuchSMSException;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.allerter.service.persistence.SMSPersistence;
import it.eng.allerter.service.persistence.SMSUtil;

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
public class SMSPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = SMSUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SMS> iterator = _smses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SMS sms = _persistence.create(pk);

		Assert.assertNotNull(sms);

		Assert.assertEquals(sms.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SMS newSMS = addSMS();

		_persistence.remove(newSMS);

		SMS existingSMS = _persistence.fetchByPrimaryKey(
			newSMS.getPrimaryKey());

		Assert.assertNull(existingSMS);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSMS();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SMS newSMS = _persistence.create(pk);

		newSMS.setTipo(RandomTestUtil.randomString());

		newSMS.setSottotipo(RandomTestUtil.randomString());

		newSMS.setParam(RandomTestUtil.nextLong());

		newSMS.setTesto(RandomTestUtil.randomString());

		newSMS.setDestinatario(RandomTestUtil.nextLong());

		newSMS.setNumeroDa(RandomTestUtil.randomString());

		newSMS.setNumero(RandomTestUtil.randomString());

		newSMS.setNomeDestinatario(RandomTestUtil.randomString());

		newSMS.setStato(RandomTestUtil.nextLong());

		newSMS.setDataInvio(RandomTestUtil.nextDate());

		newSMS.setDataAck(RandomTestUtil.nextDate());

		newSMS.setDataRicevuta(RandomTestUtil.nextDate());

		newSMS.setTentativi(RandomTestUtil.nextLong());

		newSMS.setProssimoInvio(RandomTestUtil.nextDate());

		newSMS.setCodiceErrore(RandomTestUtil.randomString());

		newSMS.setDescrizioneErrore(RandomTestUtil.randomString());

		newSMS.setTimestamp(RandomTestUtil.randomString());

		_smses.add(_persistence.update(newSMS));

		SMS existingSMS = _persistence.findByPrimaryKey(newSMS.getPrimaryKey());

		Assert.assertEquals(existingSMS.getId(), newSMS.getId());
		Assert.assertEquals(existingSMS.getTipo(), newSMS.getTipo());
		Assert.assertEquals(existingSMS.getSottotipo(), newSMS.getSottotipo());
		Assert.assertEquals(existingSMS.getParam(), newSMS.getParam());
		Assert.assertEquals(existingSMS.getTesto(), newSMS.getTesto());
		Assert.assertEquals(
			existingSMS.getDestinatario(), newSMS.getDestinatario());
		Assert.assertEquals(existingSMS.getNumeroDa(), newSMS.getNumeroDa());
		Assert.assertEquals(existingSMS.getNumero(), newSMS.getNumero());
		Assert.assertEquals(
			existingSMS.getNomeDestinatario(), newSMS.getNomeDestinatario());
		Assert.assertEquals(existingSMS.getStato(), newSMS.getStato());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSMS.getDataInvio()),
			Time.getShortTimestamp(newSMS.getDataInvio()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSMS.getDataAck()),
			Time.getShortTimestamp(newSMS.getDataAck()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSMS.getDataRicevuta()),
			Time.getShortTimestamp(newSMS.getDataRicevuta()));
		Assert.assertEquals(existingSMS.getTentativi(), newSMS.getTentativi());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSMS.getProssimoInvio()),
			Time.getShortTimestamp(newSMS.getProssimoInvio()));
		Assert.assertEquals(
			existingSMS.getCodiceErrore(), newSMS.getCodiceErrore());
		Assert.assertEquals(
			existingSMS.getDescrizioneErrore(), newSMS.getDescrizioneErrore());
		Assert.assertEquals(existingSMS.getTimestamp(), newSMS.getTimestamp());
	}

	@Test
	public void testCountByDestinatario() throws Exception {
		_persistence.countByDestinatario(RandomTestUtil.nextLong());

		_persistence.countByDestinatario(0L);
	}

	@Test
	public void testCountByNumero() throws Exception {
		_persistence.countByNumero("");

		_persistence.countByNumero("null");

		_persistence.countByNumero((String)null);
	}

	@Test
	public void testCountByNumeroDataAck() throws Exception {
		_persistence.countByNumeroDataAck("", RandomTestUtil.nextDate());

		_persistence.countByNumeroDataAck("null", RandomTestUtil.nextDate());

		_persistence.countByNumeroDataAck(
			(String)null, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByInvio() throws Exception {
		_persistence.countByInvio("", "", RandomTestUtil.nextLong());

		_persistence.countByInvio("null", "null", 0L);

		_persistence.countByInvio((String)null, (String)null, 0L);
	}

	@Test
	public void testCountByTipoSottotipo() throws Exception {
		_persistence.countByTipoSottotipo("", "");

		_persistence.countByTipoSottotipo("null", "null");

		_persistence.countByTipoSottotipo((String)null, (String)null);
	}

	@Test
	public void testCountByTipoParam() throws Exception {
		_persistence.countByTipoParam("", RandomTestUtil.nextLong());

		_persistence.countByTipoParam("null", 0L);

		_persistence.countByTipoParam((String)null, 0L);
	}

	@Test
	public void testCountByTimestamp() throws Exception {
		_persistence.countByTimestamp("");

		_persistence.countByTimestamp("null");

		_persistence.countByTimestamp((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SMS newSMS = addSMS();

		SMS existingSMS = _persistence.findByPrimaryKey(newSMS.getPrimaryKey());

		Assert.assertEquals(existingSMS, newSMS);
	}

	@Test(expected = NoSuchSMSException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SMS> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_SMS", "id", true, "tipo", true, "sottotipo", true,
			"param", true, "testo", true, "destinatario", true, "numeroDa",
			true, "numero", true, "nomeDestinatario", true, "stato", true,
			"dataInvio", true, "dataAck", true, "dataRicevuta", true,
			"tentativi", true, "prossimoInvio", true, "codiceErrore", true,
			"descrizioneErrore", true, "timestamp", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SMS newSMS = addSMS();

		SMS existingSMS = _persistence.fetchByPrimaryKey(
			newSMS.getPrimaryKey());

		Assert.assertEquals(existingSMS, newSMS);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SMS missingSMS = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSMS);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SMS newSMS1 = addSMS();
		SMS newSMS2 = addSMS();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSMS1.getPrimaryKey());
		primaryKeys.add(newSMS2.getPrimaryKey());

		Map<Serializable, SMS> smses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, smses.size());
		Assert.assertEquals(newSMS1, smses.get(newSMS1.getPrimaryKey()));
		Assert.assertEquals(newSMS2, smses.get(newSMS2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SMS> smses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(smses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SMS newSMS = addSMS();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSMS.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SMS> smses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, smses.size());
		Assert.assertEquals(newSMS, smses.get(newSMS.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SMS> smses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(smses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SMS newSMS = addSMS();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSMS.getPrimaryKey());

		Map<Serializable, SMS> smses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, smses.size());
		Assert.assertEquals(newSMS, smses.get(newSMS.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SMSLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SMS>() {

				@Override
				public void performAction(SMS sms) {
					Assert.assertNotNull(sms);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SMS newSMS = addSMS();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SMS.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newSMS.getId()));

		List<SMS> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		SMS existingSMS = result.get(0);

		Assert.assertEquals(existingSMS, newSMS);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SMS.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<SMS> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SMS newSMS = addSMS();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SMS.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newSMS.getId();

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
			SMS.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SMS addSMS() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SMS sms = _persistence.create(pk);

		sms.setTipo(RandomTestUtil.randomString());

		sms.setSottotipo(RandomTestUtil.randomString());

		sms.setParam(RandomTestUtil.nextLong());

		sms.setTesto(RandomTestUtil.randomString());

		sms.setDestinatario(RandomTestUtil.nextLong());

		sms.setNumeroDa(RandomTestUtil.randomString());

		sms.setNumero(RandomTestUtil.randomString());

		sms.setNomeDestinatario(RandomTestUtil.randomString());

		sms.setStato(RandomTestUtil.nextLong());

		sms.setDataInvio(RandomTestUtil.nextDate());

		sms.setDataAck(RandomTestUtil.nextDate());

		sms.setDataRicevuta(RandomTestUtil.nextDate());

		sms.setTentativi(RandomTestUtil.nextLong());

		sms.setProssimoInvio(RandomTestUtil.nextDate());

		sms.setCodiceErrore(RandomTestUtil.randomString());

		sms.setDescrizioneErrore(RandomTestUtil.randomString());

		sms.setTimestamp(RandomTestUtil.randomString());

		_smses.add(_persistence.update(sms));

		return sms;
	}

	private List<SMS> _smses = new ArrayList<SMS>();
	private SMSPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}