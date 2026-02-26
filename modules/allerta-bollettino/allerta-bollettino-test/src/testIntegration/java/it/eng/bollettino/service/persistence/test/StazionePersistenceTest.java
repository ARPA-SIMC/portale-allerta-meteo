/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.bollettino.exception.NoSuchStazioneException;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.service.persistence.StazionePersistence;
import it.eng.bollettino.service.persistence.StazioneUtil;

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
public class StazionePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.bollettino.service"));

	@Before
	public void setUp() {
		_persistence = StazioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Stazione> iterator = _staziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Stazione stazione = _persistence.create(pk);

		Assert.assertNotNull(stazione);

		Assert.assertEquals(stazione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Stazione newStazione = addStazione();

		_persistence.remove(newStazione);

		Stazione existingStazione = _persistence.fetchByPrimaryKey(
			newStazione.getPrimaryKey());

		Assert.assertNull(existingStazione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStazione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Stazione newStazione = _persistence.create(pk);

		newStazione.setUuid(RandomTestUtil.randomString());

		newStazione.setIdent(RandomTestUtil.randomString());

		newStazione.setName(RandomTestUtil.randomString());

		newStazione.setLon(RandomTestUtil.nextLong());

		newStazione.setLat(RandomTestUtil.nextLong());

		newStazione.setHeight(RandomTestUtil.nextDouble());

		newStazione.setIdBasin(RandomTestUtil.randomString());

		newStazione.setIdSubbasin(RandomTestUtil.randomString());

		newStazione.setIdCountry(RandomTestUtil.randomString());

		newStazione.setIdProvince(RandomTestUtil.randomString());

		newStazione.setIdRegion(RandomTestUtil.randomString());

		newStazione.setIdMunicipality(RandomTestUtil.randomString());

		newStazione.setIdMacroarea(RandomTestUtil.randomString());

		newStazione.setNameBasin(RandomTestUtil.randomString());

		newStazione.setNameSubbasin(RandomTestUtil.randomString());

		newStazione.setNameCountry(RandomTestUtil.randomString());

		newStazione.setNameProvince(RandomTestUtil.randomString());

		newStazione.setNameRegion(RandomTestUtil.randomString());

		newStazione.setNameMunicipality(RandomTestUtil.randomString());

		newStazione.setNameMacroarea(RandomTestUtil.randomString());

		newStazione.setNetwork(RandomTestUtil.randomString());

		newStazione.setAttivo(RandomTestUtil.randomBoolean());

		newStazione.setIncluso(RandomTestUtil.randomBoolean());

		newStazione.setProgressivo(RandomTestUtil.nextInt());

		_staziones.add(_persistence.update(newStazione));

		Stazione existingStazione = _persistence.findByPrimaryKey(
			newStazione.getPrimaryKey());

		Assert.assertEquals(existingStazione.getUuid(), newStazione.getUuid());
		Assert.assertEquals(existingStazione.getId(), newStazione.getId());
		Assert.assertEquals(
			existingStazione.getIdent(), newStazione.getIdent());
		Assert.assertEquals(existingStazione.getName(), newStazione.getName());
		Assert.assertEquals(existingStazione.getLon(), newStazione.getLon());
		Assert.assertEquals(existingStazione.getLat(), newStazione.getLat());
		AssertUtils.assertEquals(
			existingStazione.getHeight(), newStazione.getHeight());
		Assert.assertEquals(
			existingStazione.getIdBasin(), newStazione.getIdBasin());
		Assert.assertEquals(
			existingStazione.getIdSubbasin(), newStazione.getIdSubbasin());
		Assert.assertEquals(
			existingStazione.getIdCountry(), newStazione.getIdCountry());
		Assert.assertEquals(
			existingStazione.getIdProvince(), newStazione.getIdProvince());
		Assert.assertEquals(
			existingStazione.getIdRegion(), newStazione.getIdRegion());
		Assert.assertEquals(
			existingStazione.getIdMunicipality(),
			newStazione.getIdMunicipality());
		Assert.assertEquals(
			existingStazione.getIdMacroarea(), newStazione.getIdMacroarea());
		Assert.assertEquals(
			existingStazione.getNameBasin(), newStazione.getNameBasin());
		Assert.assertEquals(
			existingStazione.getNameSubbasin(), newStazione.getNameSubbasin());
		Assert.assertEquals(
			existingStazione.getNameCountry(), newStazione.getNameCountry());
		Assert.assertEquals(
			existingStazione.getNameProvince(), newStazione.getNameProvince());
		Assert.assertEquals(
			existingStazione.getNameRegion(), newStazione.getNameRegion());
		Assert.assertEquals(
			existingStazione.getNameMunicipality(),
			newStazione.getNameMunicipality());
		Assert.assertEquals(
			existingStazione.getNameMacroarea(),
			newStazione.getNameMacroarea());
		Assert.assertEquals(
			existingStazione.getNetwork(), newStazione.getNetwork());
		Assert.assertEquals(
			existingStazione.isAttivo(), newStazione.isAttivo());
		Assert.assertEquals(
			existingStazione.isIncluso(), newStazione.isIncluso());
		Assert.assertEquals(
			existingStazione.getProgressivo(), newStazione.getProgressivo());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testCountByBacino() throws Exception {
		_persistence.countByBacino("");

		_persistence.countByBacino("null");

		_persistence.countByBacino((String)null);
	}

	@Test
	public void testCountByBacinoAttivo() throws Exception {
		_persistence.countByBacinoAttivo("", RandomTestUtil.randomBoolean());

		_persistence.countByBacinoAttivo(
			"null", RandomTestUtil.randomBoolean());

		_persistence.countByBacinoAttivo(
			(String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByBacinoAttivoIncluso() throws Exception {
		_persistence.countByBacinoAttivoIncluso(
			"", RandomTestUtil.randomBoolean(), RandomTestUtil.randomBoolean());

		_persistence.countByBacinoAttivoIncluso(
			"null", RandomTestUtil.randomBoolean(),
			RandomTestUtil.randomBoolean());

		_persistence.countByBacinoAttivoIncluso(
			(String)null, RandomTestUtil.randomBoolean(),
			RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Stazione newStazione = addStazione();

		Stazione existingStazione = _persistence.findByPrimaryKey(
			newStazione.getPrimaryKey());

		Assert.assertEquals(existingStazione, newStazione);
	}

	@Test(expected = NoSuchStazioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Stazione> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"BOLLETTINO_Stazione", "uuid", true, "id", true, "ident", true,
			"name", true, "lon", true, "lat", true, "height", true, "idBasin",
			true, "idSubbasin", true, "idCountry", true, "idProvince", true,
			"idRegion", true, "idMunicipality", true, "idMacroarea", true,
			"nameBasin", true, "nameSubbasin", true, "nameCountry", true,
			"nameProvince", true, "nameRegion", true, "nameMunicipality", true,
			"nameMacroarea", true, "network", true, "attivo", true, "incluso",
			true, "progressivo", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Stazione newStazione = addStazione();

		Stazione existingStazione = _persistence.fetchByPrimaryKey(
			newStazione.getPrimaryKey());

		Assert.assertEquals(existingStazione, newStazione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Stazione missingStazione = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStazione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Stazione newStazione1 = addStazione();
		Stazione newStazione2 = addStazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStazione1.getPrimaryKey());
		primaryKeys.add(newStazione2.getPrimaryKey());

		Map<Serializable, Stazione> staziones = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, staziones.size());
		Assert.assertEquals(
			newStazione1, staziones.get(newStazione1.getPrimaryKey()));
		Assert.assertEquals(
			newStazione2, staziones.get(newStazione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Stazione> staziones = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(staziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Stazione newStazione = addStazione();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStazione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Stazione> staziones = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, staziones.size());
		Assert.assertEquals(
			newStazione, staziones.get(newStazione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Stazione> staziones = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(staziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Stazione newStazione = addStazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStazione.getPrimaryKey());

		Map<Serializable, Stazione> staziones = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, staziones.size());
		Assert.assertEquals(
			newStazione, staziones.get(newStazione.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Stazione newStazione = addStazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Stazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newStazione.getId()));

		List<Stazione> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Stazione existingStazione = result.get(0);

		Assert.assertEquals(existingStazione, newStazione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Stazione.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.randomString()));

		List<Stazione> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Stazione newStazione = addStazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Stazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newStazione.getId();

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
			Stazione.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Stazione addStazione() throws Exception {
		String pk = RandomTestUtil.randomString();

		Stazione stazione = _persistence.create(pk);

		stazione.setUuid(RandomTestUtil.randomString());

		stazione.setIdent(RandomTestUtil.randomString());

		stazione.setName(RandomTestUtil.randomString());

		stazione.setLon(RandomTestUtil.nextLong());

		stazione.setLat(RandomTestUtil.nextLong());

		stazione.setHeight(RandomTestUtil.nextDouble());

		stazione.setIdBasin(RandomTestUtil.randomString());

		stazione.setIdSubbasin(RandomTestUtil.randomString());

		stazione.setIdCountry(RandomTestUtil.randomString());

		stazione.setIdProvince(RandomTestUtil.randomString());

		stazione.setIdRegion(RandomTestUtil.randomString());

		stazione.setIdMunicipality(RandomTestUtil.randomString());

		stazione.setIdMacroarea(RandomTestUtil.randomString());

		stazione.setNameBasin(RandomTestUtil.randomString());

		stazione.setNameSubbasin(RandomTestUtil.randomString());

		stazione.setNameCountry(RandomTestUtil.randomString());

		stazione.setNameProvince(RandomTestUtil.randomString());

		stazione.setNameRegion(RandomTestUtil.randomString());

		stazione.setNameMunicipality(RandomTestUtil.randomString());

		stazione.setNameMacroarea(RandomTestUtil.randomString());

		stazione.setNetwork(RandomTestUtil.randomString());

		stazione.setAttivo(RandomTestUtil.randomBoolean());

		stazione.setIncluso(RandomTestUtil.randomBoolean());

		stazione.setProgressivo(RandomTestUtil.nextInt());

		_staziones.add(_persistence.update(stazione));

		return stazione;
	}

	private List<Stazione> _staziones = new ArrayList<Stazione>();
	private StazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}