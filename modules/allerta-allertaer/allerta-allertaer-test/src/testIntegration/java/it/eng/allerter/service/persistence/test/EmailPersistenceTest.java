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

import it.eng.allerter.exception.NoSuchEmailException;
import it.eng.allerter.model.Email;
import it.eng.allerter.service.EmailLocalServiceUtil;
import it.eng.allerter.service.persistence.EmailPersistence;
import it.eng.allerter.service.persistence.EmailUtil;

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
public class EmailPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "it.eng.allerter.service"));

	@Before
	public void setUp() {
		_persistence = EmailUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Email> iterator = _emails.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Email email = _persistence.create(pk);

		Assert.assertNotNull(email);

		Assert.assertEquals(email.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Email newEmail = addEmail();

		_persistence.remove(newEmail);

		Email existingEmail = _persistence.fetchByPrimaryKey(
			newEmail.getPrimaryKey());

		Assert.assertNull(existingEmail);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmail();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Email newEmail = _persistence.create(pk);

		newEmail.setTipo(RandomTestUtil.randomString());

		newEmail.setSottotipo(RandomTestUtil.randomString());

		newEmail.setParam(RandomTestUtil.nextLong());

		newEmail.setDestinatario(RandomTestUtil.nextLong());

		newEmail.setIndirizzo(RandomTestUtil.randomString());

		newEmail.setNomeDestinatario(RandomTestUtil.randomString());

		newEmail.setStato(RandomTestUtil.nextLong());

		newEmail.setDataInvio(RandomTestUtil.nextDate());

		newEmail.setTesto(RandomTestUtil.randomString());

		newEmail.setOggetto(RandomTestUtil.randomString());

		_emails.add(_persistence.update(newEmail));

		Email existingEmail = _persistence.findByPrimaryKey(
			newEmail.getPrimaryKey());

		Assert.assertEquals(existingEmail.getId(), newEmail.getId());
		Assert.assertEquals(existingEmail.getTipo(), newEmail.getTipo());
		Assert.assertEquals(
			existingEmail.getSottotipo(), newEmail.getSottotipo());
		Assert.assertEquals(existingEmail.getParam(), newEmail.getParam());
		Assert.assertEquals(
			existingEmail.getDestinatario(), newEmail.getDestinatario());
		Assert.assertEquals(
			existingEmail.getIndirizzo(), newEmail.getIndirizzo());
		Assert.assertEquals(
			existingEmail.getNomeDestinatario(),
			newEmail.getNomeDestinatario());
		Assert.assertEquals(existingEmail.getStato(), newEmail.getStato());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmail.getDataInvio()),
			Time.getShortTimestamp(newEmail.getDataInvio()));
		Assert.assertEquals(existingEmail.getTesto(), newEmail.getTesto());
		Assert.assertEquals(existingEmail.getOggetto(), newEmail.getOggetto());
	}

	@Test
	public void testCountByDestinatario() throws Exception {
		_persistence.countByDestinatario(RandomTestUtil.nextLong());

		_persistence.countByDestinatario(0L);
	}

	@Test
	public void testCountByIndirizzo() throws Exception {
		_persistence.countByIndirizzo("");

		_persistence.countByIndirizzo("null");

		_persistence.countByIndirizzo((String)null);
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		Email newEmail = addEmail();

		Email existingEmail = _persistence.findByPrimaryKey(
			newEmail.getPrimaryKey());

		Assert.assertEquals(existingEmail, newEmail);
	}

	@Test(expected = NoSuchEmailException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Email> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ALLERTER_Email", "id", true, "tipo", true, "sottotipo", true,
			"param", true, "destinatario", true, "indirizzo", true,
			"nomeDestinatario", true, "stato", true, "dataInvio", true, "testo",
			true, "oggetto", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Email newEmail = addEmail();

		Email existingEmail = _persistence.fetchByPrimaryKey(
			newEmail.getPrimaryKey());

		Assert.assertEquals(existingEmail, newEmail);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Email missingEmail = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmail);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Email newEmail1 = addEmail();
		Email newEmail2 = addEmail();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmail1.getPrimaryKey());
		primaryKeys.add(newEmail2.getPrimaryKey());

		Map<Serializable, Email> emails = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, emails.size());
		Assert.assertEquals(newEmail1, emails.get(newEmail1.getPrimaryKey()));
		Assert.assertEquals(newEmail2, emails.get(newEmail2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Email> emails = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(emails.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Email newEmail = addEmail();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmail.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Email> emails = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, emails.size());
		Assert.assertEquals(newEmail, emails.get(newEmail.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Email> emails = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(emails.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Email newEmail = addEmail();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmail.getPrimaryKey());

		Map<Serializable, Email> emails = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, emails.size());
		Assert.assertEquals(newEmail, emails.get(newEmail.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmailLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Email>() {

				@Override
				public void performAction(Email email) {
					Assert.assertNotNull(email);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Email newEmail = addEmail();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Email.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newEmail.getId()));

		List<Email> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Email existingEmail = result.get(0);

		Assert.assertEquals(existingEmail, newEmail);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Email.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Email> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Email newEmail = addEmail();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Email.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newEmail.getId();

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
			Email.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Email addEmail() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Email email = _persistence.create(pk);

		email.setTipo(RandomTestUtil.randomString());

		email.setSottotipo(RandomTestUtil.randomString());

		email.setParam(RandomTestUtil.nextLong());

		email.setDestinatario(RandomTestUtil.nextLong());

		email.setIndirizzo(RandomTestUtil.randomString());

		email.setNomeDestinatario(RandomTestUtil.randomString());

		email.setStato(RandomTestUtil.nextLong());

		email.setDataInvio(RandomTestUtil.nextDate());

		email.setTesto(RandomTestUtil.randomString());

		email.setOggetto(RandomTestUtil.randomString());

		_emails.add(_persistence.update(email));

		return email;
	}

	private List<Email> _emails = new ArrayList<Email>();
	private EmailPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}