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
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.parer.exception.NoSuchComponentiInvioException;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.service.ComponentiInvioLocalServiceUtil;
import it.eng.parer.service.persistence.ComponentiInvioPK;
import it.eng.parer.service.persistence.ComponentiInvioPersistence;
import it.eng.parer.service.persistence.ComponentiInvioUtil;

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
public class ComponentiInvioPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.parer.service"));

	@Before
	public void setUp() {
		_persistence = ComponentiInvioUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ComponentiInvio> iterator = _componentiInvios.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		ComponentiInvioPK pk = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		ComponentiInvio componentiInvio = _persistence.create(pk);

		Assert.assertNotNull(componentiInvio);

		Assert.assertEquals(componentiInvio.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ComponentiInvio newComponentiInvio = addComponentiInvio();

		_persistence.remove(newComponentiInvio);

		ComponentiInvio existingComponentiInvio =
			_persistence.fetchByPrimaryKey(newComponentiInvio.getPrimaryKey());

		Assert.assertNull(existingComponentiInvio);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addComponentiInvio();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		ComponentiInvioPK pk = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		ComponentiInvio newComponentiInvio = _persistence.create(pk);

		newComponentiInvio.setORDINE_PRESENTAZIONE(RandomTestUtil.nextLong());

		newComponentiInvio.setTIPO_COMPONENTE(RandomTestUtil.randomString());

		newComponentiInvio.setTIPO_SUPPORTO_COMPONENTE(
			RandomTestUtil.randomString());

		newComponentiInvio.setNOME_COMPONENTE(RandomTestUtil.randomString());

		newComponentiInvio.setFORMATO_FILE_VERSATO(
			RandomTestUtil.randomString());

		newComponentiInvio.setHASH_VERSATO(RandomTestUtil.randomString());

		newComponentiInvio.setURN_VERSATO(RandomTestUtil.randomString());

		newComponentiInvio.setID_COMPONENTE_VERSATO(RandomTestUtil.nextLong());

		_componentiInvios.add(_persistence.update(newComponentiInvio));

		ComponentiInvio existingComponentiInvio = _persistence.findByPrimaryKey(
			newComponentiInvio.getPrimaryKey());

		Assert.assertEquals(
			existingComponentiInvio.getID_INVIO(),
			newComponentiInvio.getID_INVIO());
		Assert.assertEquals(
			existingComponentiInvio.getID_COMPONENTE(),
			newComponentiInvio.getID_COMPONENTE());
		Assert.assertEquals(
			existingComponentiInvio.getORDINE_PRESENTAZIONE(),
			newComponentiInvio.getORDINE_PRESENTAZIONE());
		Assert.assertEquals(
			existingComponentiInvio.getTIPO_COMPONENTE(),
			newComponentiInvio.getTIPO_COMPONENTE());
		Assert.assertEquals(
			existingComponentiInvio.getTIPO_SUPPORTO_COMPONENTE(),
			newComponentiInvio.getTIPO_SUPPORTO_COMPONENTE());
		Assert.assertEquals(
			existingComponentiInvio.getNOME_COMPONENTE(),
			newComponentiInvio.getNOME_COMPONENTE());
		Assert.assertEquals(
			existingComponentiInvio.getFORMATO_FILE_VERSATO(),
			newComponentiInvio.getFORMATO_FILE_VERSATO());
		Assert.assertEquals(
			existingComponentiInvio.getHASH_VERSATO(),
			newComponentiInvio.getHASH_VERSATO());
		Assert.assertEquals(
			existingComponentiInvio.getURN_VERSATO(),
			newComponentiInvio.getURN_VERSATO());
		Assert.assertEquals(
			existingComponentiInvio.getID_COMPONENTE_VERSATO(),
			newComponentiInvio.getID_COMPONENTE_VERSATO());
	}

	@Test
	public void testCountByComponentiByIdInvio() throws Exception {
		_persistence.countByComponentiByIdInvio(RandomTestUtil.nextLong());

		_persistence.countByComponentiByIdInvio(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ComponentiInvio newComponentiInvio = addComponentiInvio();

		ComponentiInvio existingComponentiInvio = _persistence.findByPrimaryKey(
			newComponentiInvio.getPrimaryKey());

		Assert.assertEquals(existingComponentiInvio, newComponentiInvio);
	}

	@Test(expected = NoSuchComponentiInvioException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		ComponentiInvioPK pk = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ComponentiInvio newComponentiInvio = addComponentiInvio();

		ComponentiInvio existingComponentiInvio =
			_persistence.fetchByPrimaryKey(newComponentiInvio.getPrimaryKey());

		Assert.assertEquals(existingComponentiInvio, newComponentiInvio);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		ComponentiInvioPK pk = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		ComponentiInvio missingComponentiInvio = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingComponentiInvio);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ComponentiInvio newComponentiInvio1 = addComponentiInvio();
		ComponentiInvio newComponentiInvio2 = addComponentiInvio();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComponentiInvio1.getPrimaryKey());
		primaryKeys.add(newComponentiInvio2.getPrimaryKey());

		Map<Serializable, ComponentiInvio> componentiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, componentiInvios.size());
		Assert.assertEquals(
			newComponentiInvio1,
			componentiInvios.get(newComponentiInvio1.getPrimaryKey()));
		Assert.assertEquals(
			newComponentiInvio2,
			componentiInvios.get(newComponentiInvio2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		ComponentiInvioPK pk1 = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		ComponentiInvioPK pk2 = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ComponentiInvio> componentiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(componentiInvios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ComponentiInvio newComponentiInvio = addComponentiInvio();

		ComponentiInvioPK pk = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComponentiInvio.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ComponentiInvio> componentiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, componentiInvios.size());
		Assert.assertEquals(
			newComponentiInvio,
			componentiInvios.get(newComponentiInvio.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ComponentiInvio> componentiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(componentiInvios.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ComponentiInvio newComponentiInvio = addComponentiInvio();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newComponentiInvio.getPrimaryKey());

		Map<Serializable, ComponentiInvio> componentiInvios =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, componentiInvios.size());
		Assert.assertEquals(
			newComponentiInvio,
			componentiInvios.get(newComponentiInvio.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ComponentiInvioLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ComponentiInvio>() {

				@Override
				public void performAction(ComponentiInvio componentiInvio) {
					Assert.assertNotNull(componentiInvio);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ComponentiInvio newComponentiInvio = addComponentiInvio();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ComponentiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.ID_INVIO", newComponentiInvio.getID_INVIO()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.ID_COMPONENTE", newComponentiInvio.getID_COMPONENTE()));

		List<ComponentiInvio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ComponentiInvio existingComponentiInvio = result.get(0);

		Assert.assertEquals(existingComponentiInvio, newComponentiInvio);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ComponentiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.ID_INVIO", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.ID_COMPONENTE", RandomTestUtil.nextLong()));

		List<ComponentiInvio> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ComponentiInvio newComponentiInvio = addComponentiInvio();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ComponentiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.ID_INVIO"));

		Object newID_INVIO = newComponentiInvio.getID_INVIO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.ID_INVIO", new Object[] {newID_INVIO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingID_INVIO = result.get(0);

		Assert.assertEquals(existingID_INVIO, newID_INVIO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ComponentiInvio.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.ID_INVIO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.ID_INVIO", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ComponentiInvio addComponentiInvio() throws Exception {
		ComponentiInvioPK pk = new ComponentiInvioPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		ComponentiInvio componentiInvio = _persistence.create(pk);

		componentiInvio.setORDINE_PRESENTAZIONE(RandomTestUtil.nextLong());

		componentiInvio.setTIPO_COMPONENTE(RandomTestUtil.randomString());

		componentiInvio.setTIPO_SUPPORTO_COMPONENTE(
			RandomTestUtil.randomString());

		componentiInvio.setNOME_COMPONENTE(RandomTestUtil.randomString());

		componentiInvio.setFORMATO_FILE_VERSATO(RandomTestUtil.randomString());

		componentiInvio.setHASH_VERSATO(RandomTestUtil.randomString());

		componentiInvio.setURN_VERSATO(RandomTestUtil.randomString());

		componentiInvio.setID_COMPONENTE_VERSATO(RandomTestUtil.nextLong());

		_componentiInvios.add(_persistence.update(componentiInvio));

		return componentiInvio;
	}

	private List<ComponentiInvio> _componentiInvios =
		new ArrayList<ComponentiInvio>();
	private ComponentiInvioPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}