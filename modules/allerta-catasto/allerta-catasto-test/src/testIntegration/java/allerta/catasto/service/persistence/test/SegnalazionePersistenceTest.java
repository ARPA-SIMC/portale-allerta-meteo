/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.test;

import allerta.catasto.exception.NoSuchSegnalazioneException;
import allerta.catasto.model.Segnalazione;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import allerta.catasto.service.persistence.SegnalazionePersistence;
import allerta.catasto.service.persistence.SegnalazioneUtil;

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
public class SegnalazionePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "allerta.catasto.service"));

	@Before
	public void setUp() {
		_persistence = SegnalazioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Segnalazione> iterator = _segnalaziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Segnalazione segnalazione = _persistence.create(pk);

		Assert.assertNotNull(segnalazione);

		Assert.assertEquals(segnalazione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Segnalazione newSegnalazione = addSegnalazione();

		_persistence.remove(newSegnalazione);

		Segnalazione existingSegnalazione = _persistence.fetchByPrimaryKey(
			newSegnalazione.getPrimaryKey());

		Assert.assertNull(existingSegnalazione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSegnalazione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Segnalazione newSegnalazione = _persistence.create(pk);

		newSegnalazione.setGroupId(RandomTestUtil.nextLong());

		newSegnalazione.setCompanyId(RandomTestUtil.nextLong());

		newSegnalazione.setUserId(RandomTestUtil.nextLong());

		newSegnalazione.setUserName(RandomTestUtil.randomString());

		newSegnalazione.setCreateDate(RandomTestUtil.nextDate());

		newSegnalazione.setModifiedDate(RandomTestUtil.nextDate());

		newSegnalazione.setDocumentoAssociato(RandomTestUtil.nextLong());

		newSegnalazione.setDataEvento(RandomTestUtil.nextDate());

		newSegnalazione.setEnteSegnalante(RandomTestUtil.randomString());

		newSegnalazione.setFonte(RandomTestUtil.nextLong());

		newSegnalazione.setCategoria(RandomTestUtil.nextLong());

		newSegnalazione.setSottocategoria(RandomTestUtil.nextLong());

		newSegnalazione.setRiferimento(RandomTestUtil.randomString());

		newSegnalazione.setDescrizione(RandomTestUtil.randomString());

		newSegnalazione.setNote(RandomTestUtil.randomString());

		newSegnalazione.setArea(RandomTestUtil.randomString());

		newSegnalazione.setProvincia(RandomTestUtil.randomString());

		newSegnalazione.setComune(RandomTestUtil.randomString());

		newSegnalazione.setIndirizzo(RandomTestUtil.randomString());

		newSegnalazione.setCivico(RandomTestUtil.randomString());

		newSegnalazione.setLat(RandomTestUtil.nextDouble());

		newSegnalazione.setLon(RandomTestUtil.nextDouble());

		newSegnalazione.setEffetti(RandomTestUtil.nextLong());

		newSegnalazione.setEffettiSub(RandomTestUtil.nextLong());

		_segnalaziones.add(_persistence.update(newSegnalazione));

		Segnalazione existingSegnalazione = _persistence.findByPrimaryKey(
			newSegnalazione.getPrimaryKey());

		Assert.assertEquals(
			existingSegnalazione.getId(), newSegnalazione.getId());
		Assert.assertEquals(
			existingSegnalazione.getGroupId(), newSegnalazione.getGroupId());
		Assert.assertEquals(
			existingSegnalazione.getCompanyId(),
			newSegnalazione.getCompanyId());
		Assert.assertEquals(
			existingSegnalazione.getUserId(), newSegnalazione.getUserId());
		Assert.assertEquals(
			existingSegnalazione.getUserName(), newSegnalazione.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSegnalazione.getCreateDate()),
			Time.getShortTimestamp(newSegnalazione.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSegnalazione.getModifiedDate()),
			Time.getShortTimestamp(newSegnalazione.getModifiedDate()));
		Assert.assertEquals(
			existingSegnalazione.getDocumentoAssociato(),
			newSegnalazione.getDocumentoAssociato());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSegnalazione.getDataEvento()),
			Time.getShortTimestamp(newSegnalazione.getDataEvento()));
		Assert.assertEquals(
			existingSegnalazione.getEnteSegnalante(),
			newSegnalazione.getEnteSegnalante());
		Assert.assertEquals(
			existingSegnalazione.getFonte(), newSegnalazione.getFonte());
		Assert.assertEquals(
			existingSegnalazione.getCategoria(),
			newSegnalazione.getCategoria());
		Assert.assertEquals(
			existingSegnalazione.getSottocategoria(),
			newSegnalazione.getSottocategoria());
		Assert.assertEquals(
			existingSegnalazione.getRiferimento(),
			newSegnalazione.getRiferimento());
		Assert.assertEquals(
			existingSegnalazione.getDescrizione(),
			newSegnalazione.getDescrizione());
		Assert.assertEquals(
			existingSegnalazione.getNote(), newSegnalazione.getNote());
		Assert.assertEquals(
			existingSegnalazione.getArea(), newSegnalazione.getArea());
		Assert.assertEquals(
			existingSegnalazione.getProvincia(),
			newSegnalazione.getProvincia());
		Assert.assertEquals(
			existingSegnalazione.getComune(), newSegnalazione.getComune());
		Assert.assertEquals(
			existingSegnalazione.getIndirizzo(),
			newSegnalazione.getIndirizzo());
		Assert.assertEquals(
			existingSegnalazione.getCivico(), newSegnalazione.getCivico());
		AssertUtils.assertEquals(
			existingSegnalazione.getLat(), newSegnalazione.getLat());
		AssertUtils.assertEquals(
			existingSegnalazione.getLon(), newSegnalazione.getLon());
		Assert.assertEquals(
			existingSegnalazione.getEffetti(), newSegnalazione.getEffetti());
		Assert.assertEquals(
			existingSegnalazione.getEffettiSub(),
			newSegnalazione.getEffettiSub());
	}

	@Test
	public void testCountByDocumentoAssociato() throws Exception {
		_persistence.countByDocumentoAssociato(RandomTestUtil.nextLong());

		_persistence.countByDocumentoAssociato(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Segnalazione newSegnalazione = addSegnalazione();

		Segnalazione existingSegnalazione = _persistence.findByPrimaryKey(
			newSegnalazione.getPrimaryKey());

		Assert.assertEquals(existingSegnalazione, newSegnalazione);
	}

	@Test(expected = NoSuchSegnalazioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Segnalazione> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CATASTO_Segnalazione", "id", true, "groupId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "documentoAssociato", true, "dataEvento",
			true, "enteSegnalante", true, "fonte", true, "categoria", true,
			"sottocategoria", true, "riferimento", true, "descrizione", true,
			"note", true, "area", true, "provincia", true, "comune", true,
			"indirizzo", true, "civico", true, "lat", true, "lon", true,
			"effetti", true, "effettiSub", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Segnalazione newSegnalazione = addSegnalazione();

		Segnalazione existingSegnalazione = _persistence.fetchByPrimaryKey(
			newSegnalazione.getPrimaryKey());

		Assert.assertEquals(existingSegnalazione, newSegnalazione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Segnalazione missingSegnalazione = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSegnalazione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Segnalazione newSegnalazione1 = addSegnalazione();
		Segnalazione newSegnalazione2 = addSegnalazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSegnalazione1.getPrimaryKey());
		primaryKeys.add(newSegnalazione2.getPrimaryKey());

		Map<Serializable, Segnalazione> segnalaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, segnalaziones.size());
		Assert.assertEquals(
			newSegnalazione1,
			segnalaziones.get(newSegnalazione1.getPrimaryKey()));
		Assert.assertEquals(
			newSegnalazione2,
			segnalaziones.get(newSegnalazione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Segnalazione> segnalaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(segnalaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Segnalazione newSegnalazione = addSegnalazione();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSegnalazione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Segnalazione> segnalaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, segnalaziones.size());
		Assert.assertEquals(
			newSegnalazione,
			segnalaziones.get(newSegnalazione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Segnalazione> segnalaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(segnalaziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Segnalazione newSegnalazione = addSegnalazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSegnalazione.getPrimaryKey());

		Map<Serializable, Segnalazione> segnalaziones =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, segnalaziones.size());
		Assert.assertEquals(
			newSegnalazione,
			segnalaziones.get(newSegnalazione.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SegnalazioneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Segnalazione>() {

				@Override
				public void performAction(Segnalazione segnalazione) {
					Assert.assertNotNull(segnalazione);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Segnalazione newSegnalazione = addSegnalazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Segnalazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newSegnalazione.getId()));

		List<Segnalazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Segnalazione existingSegnalazione = result.get(0);

		Assert.assertEquals(existingSegnalazione, newSegnalazione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Segnalazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Segnalazione> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Segnalazione newSegnalazione = addSegnalazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Segnalazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newSegnalazione.getId();

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
			Segnalazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Segnalazione addSegnalazione() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Segnalazione segnalazione = _persistence.create(pk);

		segnalazione.setGroupId(RandomTestUtil.nextLong());

		segnalazione.setCompanyId(RandomTestUtil.nextLong());

		segnalazione.setUserId(RandomTestUtil.nextLong());

		segnalazione.setUserName(RandomTestUtil.randomString());

		segnalazione.setCreateDate(RandomTestUtil.nextDate());

		segnalazione.setModifiedDate(RandomTestUtil.nextDate());

		segnalazione.setDocumentoAssociato(RandomTestUtil.nextLong());

		segnalazione.setDataEvento(RandomTestUtil.nextDate());

		segnalazione.setEnteSegnalante(RandomTestUtil.randomString());

		segnalazione.setFonte(RandomTestUtil.nextLong());

		segnalazione.setCategoria(RandomTestUtil.nextLong());

		segnalazione.setSottocategoria(RandomTestUtil.nextLong());

		segnalazione.setRiferimento(RandomTestUtil.randomString());

		segnalazione.setDescrizione(RandomTestUtil.randomString());

		segnalazione.setNote(RandomTestUtil.randomString());

		segnalazione.setArea(RandomTestUtil.randomString());

		segnalazione.setProvincia(RandomTestUtil.randomString());

		segnalazione.setComune(RandomTestUtil.randomString());

		segnalazione.setIndirizzo(RandomTestUtil.randomString());

		segnalazione.setCivico(RandomTestUtil.randomString());

		segnalazione.setLat(RandomTestUtil.nextDouble());

		segnalazione.setLon(RandomTestUtil.nextDouble());

		segnalazione.setEffetti(RandomTestUtil.nextLong());

		segnalazione.setEffettiSub(RandomTestUtil.nextLong());

		_segnalaziones.add(_persistence.update(segnalazione));

		return segnalazione;
	}

	private List<Segnalazione> _segnalaziones = new ArrayList<Segnalazione>();
	private SegnalazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}