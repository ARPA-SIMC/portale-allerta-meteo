/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.eng.parer.exception.NoSuchDocumentiCollegatiException;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.persistence.DocumentiCollegatiPK;
import it.eng.parer.service.persistence.DocumentiCollegatiPersistence;
import it.eng.parer.service.persistence.DocumentiCollegatiUtil;

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
public class DocumentiCollegatiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.parer.service"));

	@Before
	public void setUp() {
		_persistence = DocumentiCollegatiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DocumentiCollegati> iterator = _documentiCollegatis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		DocumentiCollegatiPK pk = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		DocumentiCollegati documentiCollegati = _persistence.create(pk);

		Assert.assertNotNull(documentiCollegati);

		Assert.assertEquals(documentiCollegati.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		_persistence.remove(newDocumentiCollegati);

		DocumentiCollegati existingDocumentiCollegati =
			_persistence.fetchByPrimaryKey(
				newDocumentiCollegati.getPrimaryKey());

		Assert.assertNull(existingDocumentiCollegati);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDocumentiCollegati();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		DocumentiCollegatiPK pk = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		DocumentiCollegati newDocumentiCollegati = _persistence.create(pk);

		newDocumentiCollegati.setDESCRIZIONE_COLLEGAMENTO(
			RandomTestUtil.randomString());

		_documentiCollegatis.add(_persistence.update(newDocumentiCollegati));

		DocumentiCollegati existingDocumentiCollegati =
			_persistence.findByPrimaryKey(
				newDocumentiCollegati.getPrimaryKey());

		Assert.assertEquals(
			existingDocumentiCollegati.getDOC_COLLEGATO_NUMERO(),
			newDocumentiCollegati.getDOC_COLLEGATO_NUMERO());
		Assert.assertEquals(
			existingDocumentiCollegati.getDOC_COLLEGATO_ANNO(),
			newDocumentiCollegati.getDOC_COLLEGATO_ANNO());
		Assert.assertEquals(
			existingDocumentiCollegati.getDOC_COLLEGATO_TIPO_REGISTRO(),
			newDocumentiCollegati.getDOC_COLLEGATO_TIPO_REGISTRO());
		Assert.assertEquals(
			existingDocumentiCollegati.getDESCRIZIONE_COLLEGAMENTO(),
			newDocumentiCollegati.getDESCRIZIONE_COLLEGAMENTO());
		Assert.assertEquals(
			existingDocumentiCollegati.getID_INVIO(),
			newDocumentiCollegati.getID_INVIO());
	}

	@Test
	public void testCountByDocumentiCollegatiByIdInvio() throws Exception {
		_persistence.countByDocumentiCollegatiByIdInvio(
			RandomTestUtil.nextLong());

		_persistence.countByDocumentiCollegatiByIdInvio(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		DocumentiCollegati existingDocumentiCollegati =
			_persistence.findByPrimaryKey(
				newDocumentiCollegati.getPrimaryKey());

		Assert.assertEquals(existingDocumentiCollegati, newDocumentiCollegati);
	}

	@Test(expected = NoSuchDocumentiCollegatiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		DocumentiCollegatiPK pk = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		DocumentiCollegati existingDocumentiCollegati =
			_persistence.fetchByPrimaryKey(
				newDocumentiCollegati.getPrimaryKey());

		Assert.assertEquals(existingDocumentiCollegati, newDocumentiCollegati);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		DocumentiCollegatiPK pk = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		DocumentiCollegati missingDocumentiCollegati =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDocumentiCollegati);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DocumentiCollegati newDocumentiCollegati1 = addDocumentiCollegati();
		DocumentiCollegati newDocumentiCollegati2 = addDocumentiCollegati();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocumentiCollegati1.getPrimaryKey());
		primaryKeys.add(newDocumentiCollegati2.getPrimaryKey());

		Map<Serializable, DocumentiCollegati> documentiCollegatis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, documentiCollegatis.size());
		Assert.assertEquals(
			newDocumentiCollegati1,
			documentiCollegatis.get(newDocumentiCollegati1.getPrimaryKey()));
		Assert.assertEquals(
			newDocumentiCollegati2,
			documentiCollegatis.get(newDocumentiCollegati2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		DocumentiCollegatiPK pk1 = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		DocumentiCollegatiPK pk2 = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DocumentiCollegati> documentiCollegatis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(documentiCollegatis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		DocumentiCollegatiPK pk = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocumentiCollegati.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DocumentiCollegati> documentiCollegatis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, documentiCollegatis.size());
		Assert.assertEquals(
			newDocumentiCollegati,
			documentiCollegatis.get(newDocumentiCollegati.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DocumentiCollegati> documentiCollegatis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(documentiCollegatis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocumentiCollegati.getPrimaryKey());

		Map<Serializable, DocumentiCollegati> documentiCollegatis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, documentiCollegatis.size());
		Assert.assertEquals(
			newDocumentiCollegati,
			documentiCollegatis.get(newDocumentiCollegati.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DocumentiCollegati.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.DOC_COLLEGATO_NUMERO",
				newDocumentiCollegati.getDOC_COLLEGATO_NUMERO()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.DOC_COLLEGATO_ANNO",
				newDocumentiCollegati.getDOC_COLLEGATO_ANNO()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.DOC_COLLEGATO_TIPO_REGISTRO",
				newDocumentiCollegati.getDOC_COLLEGATO_TIPO_REGISTRO()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.ID_INVIO", newDocumentiCollegati.getID_INVIO()));

		List<DocumentiCollegati> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DocumentiCollegati existingDocumentiCollegati = result.get(0);

		Assert.assertEquals(existingDocumentiCollegati, newDocumentiCollegati);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DocumentiCollegati.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.DOC_COLLEGATO_NUMERO", RandomTestUtil.randomString()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.DOC_COLLEGATO_ANNO", RandomTestUtil.nextInt()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.DOC_COLLEGATO_TIPO_REGISTRO",
				RandomTestUtil.randomString()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.ID_INVIO", RandomTestUtil.nextLong()));

		List<DocumentiCollegati> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DocumentiCollegati newDocumentiCollegati = addDocumentiCollegati();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DocumentiCollegati.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.DOC_COLLEGATO_NUMERO"));

		Object newDOC_COLLEGATO_NUMERO =
			newDocumentiCollegati.getDOC_COLLEGATO_NUMERO();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.DOC_COLLEGATO_NUMERO",
				new Object[] {newDOC_COLLEGATO_NUMERO}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDOC_COLLEGATO_NUMERO = result.get(0);

		Assert.assertEquals(
			existingDOC_COLLEGATO_NUMERO, newDOC_COLLEGATO_NUMERO);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DocumentiCollegati.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.DOC_COLLEGATO_NUMERO"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.DOC_COLLEGATO_NUMERO",
				new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DocumentiCollegati addDocumentiCollegati() throws Exception {
		DocumentiCollegatiPK pk = new DocumentiCollegatiPK(
			RandomTestUtil.randomString(), RandomTestUtil.nextInt(),
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());

		DocumentiCollegati documentiCollegati = _persistence.create(pk);

		documentiCollegati.setDESCRIZIONE_COLLEGAMENTO(
			RandomTestUtil.randomString());

		_documentiCollegatis.add(_persistence.update(documentiCollegati));

		return documentiCollegati;
	}

	private List<DocumentiCollegati> _documentiCollegatis =
		new ArrayList<DocumentiCollegati>();
	private DocumentiCollegatiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}