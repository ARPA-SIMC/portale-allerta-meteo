/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
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

import it.eng.parer.exception.NoSuchDatiSpecificiInvioException;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.service.DatiSpecificiInvioLocalServiceUtil;
import it.eng.parer.service.persistence.DatiSpecificiInvioPersistence;
import it.eng.parer.service.persistence.DatiSpecificiInvioUtil;

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
public class DatiSpecificiInvioPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.parer.service"));

	@Before
	public void setUp() {
		_persistence = DatiSpecificiInvioUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DatiSpecificiInvio> iterator = _datiSpecificiInvios.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DatiSpecificiInvio datiSpecificiInvio = _persistence.create(pk);

		Assert.assertNotNull(datiSpecificiInvio);

		Assert.assertEquals(datiSpecificiInvio.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		_persistence.remove(newDatiSpecificiInvio);

		DatiSpecificiInvio existingDatiSpecificiInvio =
			_persistence.fetchByPrimaryKey(
				newDatiSpecificiInvio.getPrimaryKey());

		Assert.assertNull(existingDatiSpecificiInvio);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDatiSpecificiInvio();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DatiSpecificiInvio newDatiSpecificiInvio = _persistence.create(pk);

		newDatiSpecificiInvio.setAMBIENTE(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setVERSIONE(RandomTestUtil.nextDouble());

		newDatiSpecificiInvio.setVERSATORE_ENTE(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setVERSATORE_USER_ID(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setVERSATORE_STRUTTURA(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setCHIAVE_NUMERO(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setCHIAVE_ANNO(RandomTestUtil.nextLong());

		newDatiSpecificiInvio.setCHIAVE_TIPO_REGISTRO(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setTIPOLOGIA_UNITA_DOCUMENTARIA(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setTIPO_CONSERVAZIONE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setFORZA_ACCETTAZIONE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setFORZA_CONSERVAZIONE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setFORZA_COLLEGAMENTO(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setOGGETTO_UNITA_DOCUMENTARIA(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setDATA_UNITA_DOCUMENTARIA(
			RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setVERSIONE_DATI_SPECIFICI(
			RandomTestUtil.nextDouble());

		newDatiSpecificiInvio.setIDENTIFICATIVO_DATO_SPECIFICO(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setDATA_GENERAZIONE(RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setNUM_SMS_GENERATI(RandomTestUtil.nextInt());

		newDatiSpecificiInvio.setNUM_SMS_INVIATI(RandomTestUtil.nextInt());

		newDatiSpecificiInvio.setNUM_NOTIFICHE_RICEZIONE(
			RandomTestUtil.nextInt());

		newDatiSpecificiInvio.setDENOMINAZIONE_APPLICATIVO(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setOGGETTO_MAIL(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setTESTO_MAIL(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setCOMPILATORE_ARPAE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setCOMPILATORE_PROTEZIONE_CIVILE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setDATA_INIZIO_VALIDITA(
			RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setDATA_FINE_VALIDITA(RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setAPPROVATORE_ARPAE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setDATA_FIRMA_ARPAE(RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setAPPROVATORE_PROTEZIONE_CIVILE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setDATA_FIRMA_PROTEZIONE_CIVILE(
			RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setINVIO_RESPONSABILE_TERRITORIO(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setID_DOCUMENTO_PRINCIPALE(
			RandomTestUtil.nextLong());

		newDatiSpecificiInvio.setTIPO_DOCUMENTO(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setTIPO_STRUTTURA(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setDENOMINAZIONE_SENSORE_RILEVAMENTO(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setREGOLA_ALLARME_ID(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setREGOLA_ALLARME_NOME(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setREGOLA_ALLARME_DESCRIZIONE(
			RandomTestUtil.randomString());

		newDatiSpecificiInvio.setESITO_INVIO(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setUserId(RandomTestUtil.nextLong());

		newDatiSpecificiInvio.setCompanyId(RandomTestUtil.nextLong());

		newDatiSpecificiInvio.setGroupId(RandomTestUtil.nextLong());

		newDatiSpecificiInvio.setData_invio(RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setData_risposta(RandomTestUtil.nextDate());

		newDatiSpecificiInvio.setCODICE_ESITO(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setCODICE_ERRORE(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setMESG_ERRORE(RandomTestUtil.randomString());

		newDatiSpecificiInvio.setCODICE_TIPO_INVIO(
			RandomTestUtil.randomString());

		_datiSpecificiInvios.add(_persistence.update(newDatiSpecificiInvio));

		DatiSpecificiInvio existingDatiSpecificiInvio =
			_persistence.findByPrimaryKey(
				newDatiSpecificiInvio.getPrimaryKey());

		Assert.assertEquals(
			existingDatiSpecificiInvio.getID_INVIO(),
			newDatiSpecificiInvio.getID_INVIO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getAMBIENTE(),
			newDatiSpecificiInvio.getAMBIENTE());
		AssertUtils.assertEquals(
			existingDatiSpecificiInvio.getVERSIONE(),
			newDatiSpecificiInvio.getVERSIONE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getVERSATORE_ENTE(),
			newDatiSpecificiInvio.getVERSATORE_ENTE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getVERSATORE_USER_ID(),
			newDatiSpecificiInvio.getVERSATORE_USER_ID());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getVERSATORE_STRUTTURA(),
			newDatiSpecificiInvio.getVERSATORE_STRUTTURA());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCHIAVE_NUMERO(),
			newDatiSpecificiInvio.getCHIAVE_NUMERO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCHIAVE_ANNO(),
			newDatiSpecificiInvio.getCHIAVE_ANNO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCHIAVE_TIPO_REGISTRO(),
			newDatiSpecificiInvio.getCHIAVE_TIPO_REGISTRO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getTIPOLOGIA_UNITA_DOCUMENTARIA(),
			newDatiSpecificiInvio.getTIPOLOGIA_UNITA_DOCUMENTARIA());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getTIPO_CONSERVAZIONE(),
			newDatiSpecificiInvio.getTIPO_CONSERVAZIONE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getFORZA_ACCETTAZIONE(),
			newDatiSpecificiInvio.getFORZA_ACCETTAZIONE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getFORZA_CONSERVAZIONE(),
			newDatiSpecificiInvio.getFORZA_CONSERVAZIONE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getFORZA_COLLEGAMENTO(),
			newDatiSpecificiInvio.getFORZA_COLLEGAMENTO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getOGGETTO_UNITA_DOCUMENTARIA(),
			newDatiSpecificiInvio.getOGGETTO_UNITA_DOCUMENTARIA());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getDATA_UNITA_DOCUMENTARIA()),
			Time.getShortTimestamp(
				newDatiSpecificiInvio.getDATA_UNITA_DOCUMENTARIA()));
		AssertUtils.assertEquals(
			existingDatiSpecificiInvio.getVERSIONE_DATI_SPECIFICI(),
			newDatiSpecificiInvio.getVERSIONE_DATI_SPECIFICI());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getIDENTIFICATIVO_DATO_SPECIFICO(),
			newDatiSpecificiInvio.getIDENTIFICATIVO_DATO_SPECIFICO());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getDATA_GENERAZIONE()),
			Time.getShortTimestamp(
				newDatiSpecificiInvio.getDATA_GENERAZIONE()));
		Assert.assertEquals(
			existingDatiSpecificiInvio.getNUM_SMS_GENERATI(),
			newDatiSpecificiInvio.getNUM_SMS_GENERATI());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getNUM_SMS_INVIATI(),
			newDatiSpecificiInvio.getNUM_SMS_INVIATI());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getNUM_NOTIFICHE_RICEZIONE(),
			newDatiSpecificiInvio.getNUM_NOTIFICHE_RICEZIONE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getDENOMINAZIONE_APPLICATIVO(),
			newDatiSpecificiInvio.getDENOMINAZIONE_APPLICATIVO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getOGGETTO_MAIL(),
			newDatiSpecificiInvio.getOGGETTO_MAIL());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getTESTO_MAIL(),
			newDatiSpecificiInvio.getTESTO_MAIL());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCOMPILATORE_ARPAE(),
			newDatiSpecificiInvio.getCOMPILATORE_ARPAE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCOMPILATORE_PROTEZIONE_CIVILE(),
			newDatiSpecificiInvio.getCOMPILATORE_PROTEZIONE_CIVILE());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getDATA_INIZIO_VALIDITA()),
			Time.getShortTimestamp(
				newDatiSpecificiInvio.getDATA_INIZIO_VALIDITA()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getDATA_FINE_VALIDITA()),
			Time.getShortTimestamp(
				newDatiSpecificiInvio.getDATA_FINE_VALIDITA()));
		Assert.assertEquals(
			existingDatiSpecificiInvio.getAPPROVATORE_ARPAE(),
			newDatiSpecificiInvio.getAPPROVATORE_ARPAE());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getDATA_FIRMA_ARPAE()),
			Time.getShortTimestamp(
				newDatiSpecificiInvio.getDATA_FIRMA_ARPAE()));
		Assert.assertEquals(
			existingDatiSpecificiInvio.getAPPROVATORE_PROTEZIONE_CIVILE(),
			newDatiSpecificiInvio.getAPPROVATORE_PROTEZIONE_CIVILE());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getDATA_FIRMA_PROTEZIONE_CIVILE()),
			Time.getShortTimestamp(
				newDatiSpecificiInvio.getDATA_FIRMA_PROTEZIONE_CIVILE()));
		Assert.assertEquals(
			existingDatiSpecificiInvio.getINVIO_RESPONSABILE_TERRITORIO(),
			newDatiSpecificiInvio.getINVIO_RESPONSABILE_TERRITORIO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getID_DOCUMENTO_PRINCIPALE(),
			newDatiSpecificiInvio.getID_DOCUMENTO_PRINCIPALE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getTIPO_DOCUMENTO(),
			newDatiSpecificiInvio.getTIPO_DOCUMENTO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getTIPO_STRUTTURA(),
			newDatiSpecificiInvio.getTIPO_STRUTTURA());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getDENOMINAZIONE_SENSORE_RILEVAMENTO(),
			newDatiSpecificiInvio.getDENOMINAZIONE_SENSORE_RILEVAMENTO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getREGOLA_ALLARME_ID(),
			newDatiSpecificiInvio.getREGOLA_ALLARME_ID());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getREGOLA_ALLARME_NOME(),
			newDatiSpecificiInvio.getREGOLA_ALLARME_NOME());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getREGOLA_ALLARME_DESCRIZIONE(),
			newDatiSpecificiInvio.getREGOLA_ALLARME_DESCRIZIONE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getESITO_INVIO(),
			newDatiSpecificiInvio.getESITO_INVIO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getUserId(),
			newDatiSpecificiInvio.getUserId());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCompanyId(),
			newDatiSpecificiInvio.getCompanyId());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getGroupId(),
			newDatiSpecificiInvio.getGroupId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDatiSpecificiInvio.getData_invio()),
			Time.getShortTimestamp(newDatiSpecificiInvio.getData_invio()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingDatiSpecificiInvio.getData_risposta()),
			Time.getShortTimestamp(newDatiSpecificiInvio.getData_risposta()));
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCODICE_ESITO(),
			newDatiSpecificiInvio.getCODICE_ESITO());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCODICE_ERRORE(),
			newDatiSpecificiInvio.getCODICE_ERRORE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getMESG_ERRORE(),
			newDatiSpecificiInvio.getMESG_ERRORE());
		Assert.assertEquals(
			existingDatiSpecificiInvio.getCODICE_TIPO_INVIO(),
			newDatiSpecificiInvio.getCODICE_TIPO_INVIO());
	}

	@Test
	public void testCountByesitoInvio() throws Exception {
		_persistence.countByesitoInvio("");

		_persistence.countByesitoInvio("null");

		_persistence.countByesitoInvio((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		DatiSpecificiInvio existingDatiSpecificiInvio =
			_persistence.findByPrimaryKey(
				newDatiSpecificiInvio.getPrimaryKey());

		Assert.assertEquals(existingDatiSpecificiInvio, newDatiSpecificiInvio);
	}

	@Test(expected = NoSuchDatiSpecificiInvioException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DatiSpecificiInvio> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"parer_DatiSpecificiInvio", "ID_INVIO", true, "AMBIENTE", true,
			"VERSIONE", true, "VERSATORE_ENTE", true, "VERSATORE_USER_ID", true,
			"VERSATORE_STRUTTURA", true, "CHIAVE_NUMERO", true, "CHIAVE_ANNO",
			true, "CHIAVE_TIPO_REGISTRO", true, "TIPOLOGIA_UNITA_DOCUMENTARIA",
			true, "TIPO_CONSERVAZIONE", true, "FORZA_ACCETTAZIONE", true,
			"FORZA_CONSERVAZIONE", true, "FORZA_COLLEGAMENTO", true,
			"OGGETTO_UNITA_DOCUMENTARIA", true, "DATA_UNITA_DOCUMENTARIA", true,
			"VERSIONE_DATI_SPECIFICI", true, "IDENTIFICATIVO_DATO_SPECIFICO",
			true, "DATA_GENERAZIONE", true, "NUM_SMS_GENERATI", true,
			"NUM_SMS_INVIATI", true, "NUM_NOTIFICHE_RICEZIONE", true,
			"DENOMINAZIONE_APPLICATIVO", true, "OGGETTO_MAIL", true,
			"TESTO_MAIL", true, "COMPILATORE_ARPAE", true,
			"COMPILATORE_PROTEZIONE_CIVILE", true, "DATA_INIZIO_VALIDITA", true,
			"DATA_FINE_VALIDITA", true, "APPROVATORE_ARPAE", true,
			"DATA_FIRMA_ARPAE", true, "APPROVATORE_PROTEZIONE_CIVILE", true,
			"DATA_FIRMA_PROTEZIONE_CIVILE", true,
			"INVIO_RESPONSABILE_TERRITORIO", true, "ID_DOCUMENTO_PRINCIPALE",
			true, "TIPO_DOCUMENTO", true, "TIPO_STRUTTURA", true,
			"DENOMINAZIONE_SENSORE_RILEVAMENTO", true, "REGOLA_ALLARME_ID",
			true, "REGOLA_ALLARME_NOME", true, "REGOLA_ALLARME_DESCRIZIONE",
			true, "ESITO_INVIO", true, "userId", true, "companyId", true,
			"groupId", true, "data_invio", true, "data_risposta", true,
			"CODICE_ESITO", true, "CODICE_ERRORE", true, "MESG_ERRORE", true,
			"CODICE_TIPO_INVIO", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		DatiSpecificiInvio existingDatiSpecificiInvio =
			_persistence.fetchByPrimaryKey(
				newDatiSpecificiInvio.getPrimaryKey());

		Assert.assertEquals(existingDatiSpecificiInvio, newDatiSpecificiInvio);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DatiSpecificiInvio missingDatiSpecificiInvio =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDatiSpecificiInvio);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DatiSpecificiInvio newDatiSpecificiInvio1 = addDatiSpecificiInvio();
		DatiSpecificiInvio newDatiSpecificiInvio2 = addDatiSpecificiInvio();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDatiSpecificiInvio1.getPrimaryKey());
		primaryKeys.add(newDatiSpecificiInvio2.getPrimaryKey());

		Map<Serializable, DatiSpecificiInvio> datiSpecificiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, datiSpecificiInvios.size());
		Assert.assertEquals(
			newDatiSpecificiInvio1,
			datiSpecificiInvios.get(newDatiSpecificiInvio1.getPrimaryKey()));
		Assert.assertEquals(
			newDatiSpecificiInvio2,
			datiSpecificiInvios.get(newDatiSpecificiInvio2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DatiSpecificiInvio> datiSpecificiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(datiSpecificiInvios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDatiSpecificiInvio.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DatiSpecificiInvio> datiSpecificiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, datiSpecificiInvios.size());
		Assert.assertEquals(
			newDatiSpecificiInvio,
			datiSpecificiInvios.get(newDatiSpecificiInvio.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DatiSpecificiInvio> datiSpecificiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(datiSpecificiInvios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDatiSpecificiInvio.getPrimaryKey());

		Map<Serializable, DatiSpecificiInvio> datiSpecificiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, datiSpecificiInvios.size());
		Assert.assertEquals(
			newDatiSpecificiInvio,
			datiSpecificiInvios.get(newDatiSpecificiInvio.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DatiSpecificiInvioLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<DatiSpecificiInvio>() {

				@Override
				public void performAction(
					DatiSpecificiInvio datiSpecificiInvio) {

					Assert.assertNotNull(datiSpecificiInvio);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DatiSpecificiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ID_INVIO", newDatiSpecificiInvio.getID_INVIO()));

		List<DatiSpecificiInvio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DatiSpecificiInvio existingDatiSpecificiInvio = result.get(0);

		Assert.assertEquals(existingDatiSpecificiInvio, newDatiSpecificiInvio);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DatiSpecificiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ID_INVIO", RandomTestUtil.nextLong()));

		List<DatiSpecificiInvio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DatiSpecificiInvio newDatiSpecificiInvio = addDatiSpecificiInvio();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DatiSpecificiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_INVIO"));

		Object newID_INVIO = newDatiSpecificiInvio.getID_INVIO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ID_INVIO", new Object[] {newID_INVIO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_INVIO = result.get(0);

		Assert.assertEquals(existingID_INVIO, newID_INVIO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DatiSpecificiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ID_INVIO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ID_INVIO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DatiSpecificiInvio addDatiSpecificiInvio() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DatiSpecificiInvio datiSpecificiInvio = _persistence.create(pk);

		datiSpecificiInvio.setAMBIENTE(RandomTestUtil.randomString());

		datiSpecificiInvio.setVERSIONE(RandomTestUtil.nextDouble());

		datiSpecificiInvio.setVERSATORE_ENTE(RandomTestUtil.randomString());

		datiSpecificiInvio.setVERSATORE_USER_ID(RandomTestUtil.randomString());

		datiSpecificiInvio.setVERSATORE_STRUTTURA(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setCHIAVE_NUMERO(RandomTestUtil.randomString());

		datiSpecificiInvio.setCHIAVE_ANNO(RandomTestUtil.nextLong());

		datiSpecificiInvio.setCHIAVE_TIPO_REGISTRO(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setTIPOLOGIA_UNITA_DOCUMENTARIA(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setTIPO_CONSERVAZIONE(RandomTestUtil.randomString());

		datiSpecificiInvio.setFORZA_ACCETTAZIONE(RandomTestUtil.randomString());

		datiSpecificiInvio.setFORZA_CONSERVAZIONE(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setFORZA_COLLEGAMENTO(RandomTestUtil.randomString());

		datiSpecificiInvio.setOGGETTO_UNITA_DOCUMENTARIA(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setDATA_UNITA_DOCUMENTARIA(
			RandomTestUtil.nextDate());

		datiSpecificiInvio.setVERSIONE_DATI_SPECIFICI(
			RandomTestUtil.nextDouble());

		datiSpecificiInvio.setIDENTIFICATIVO_DATO_SPECIFICO(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setDATA_GENERAZIONE(RandomTestUtil.nextDate());

		datiSpecificiInvio.setNUM_SMS_GENERATI(RandomTestUtil.nextInt());

		datiSpecificiInvio.setNUM_SMS_INVIATI(RandomTestUtil.nextInt());

		datiSpecificiInvio.setNUM_NOTIFICHE_RICEZIONE(RandomTestUtil.nextInt());

		datiSpecificiInvio.setDENOMINAZIONE_APPLICATIVO(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setOGGETTO_MAIL(RandomTestUtil.randomString());

		datiSpecificiInvio.setTESTO_MAIL(RandomTestUtil.randomString());

		datiSpecificiInvio.setCOMPILATORE_ARPAE(RandomTestUtil.randomString());

		datiSpecificiInvio.setCOMPILATORE_PROTEZIONE_CIVILE(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setDATA_INIZIO_VALIDITA(RandomTestUtil.nextDate());

		datiSpecificiInvio.setDATA_FINE_VALIDITA(RandomTestUtil.nextDate());

		datiSpecificiInvio.setAPPROVATORE_ARPAE(RandomTestUtil.randomString());

		datiSpecificiInvio.setDATA_FIRMA_ARPAE(RandomTestUtil.nextDate());

		datiSpecificiInvio.setAPPROVATORE_PROTEZIONE_CIVILE(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setDATA_FIRMA_PROTEZIONE_CIVILE(
			RandomTestUtil.nextDate());

		datiSpecificiInvio.setINVIO_RESPONSABILE_TERRITORIO(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setID_DOCUMENTO_PRINCIPALE(
			RandomTestUtil.nextLong());

		datiSpecificiInvio.setTIPO_DOCUMENTO(RandomTestUtil.randomString());

		datiSpecificiInvio.setTIPO_STRUTTURA(RandomTestUtil.randomString());

		datiSpecificiInvio.setDENOMINAZIONE_SENSORE_RILEVAMENTO(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setREGOLA_ALLARME_ID(RandomTestUtil.randomString());

		datiSpecificiInvio.setREGOLA_ALLARME_NOME(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setREGOLA_ALLARME_DESCRIZIONE(
			RandomTestUtil.randomString());

		datiSpecificiInvio.setESITO_INVIO(RandomTestUtil.randomString());

		datiSpecificiInvio.setUserId(RandomTestUtil.nextLong());

		datiSpecificiInvio.setCompanyId(RandomTestUtil.nextLong());

		datiSpecificiInvio.setGroupId(RandomTestUtil.nextLong());

		datiSpecificiInvio.setData_invio(RandomTestUtil.nextDate());

		datiSpecificiInvio.setData_risposta(RandomTestUtil.nextDate());

		datiSpecificiInvio.setCODICE_ESITO(RandomTestUtil.randomString());

		datiSpecificiInvio.setCODICE_ERRORE(RandomTestUtil.randomString());

		datiSpecificiInvio.setMESG_ERRORE(RandomTestUtil.randomString());

		datiSpecificiInvio.setCODICE_TIPO_INVIO(RandomTestUtil.randomString());

		_datiSpecificiInvios.add(_persistence.update(datiSpecificiInvio));

		return datiSpecificiInvio;
	}

	private List<DatiSpecificiInvio> _datiSpecificiInvios =
		new ArrayList<DatiSpecificiInvio>();
	private DatiSpecificiInvioPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}