/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import it.eng.allerter.exception.NoSuchEmailException;
import it.eng.allerter.model.Email;
import it.eng.allerter.model.EmailTable;
import it.eng.allerter.model.impl.EmailImpl;
import it.eng.allerter.model.impl.EmailModelImpl;
import it.eng.allerter.service.persistence.EmailPersistence;
import it.eng.allerter.service.persistence.EmailUtil;
import it.eng.allerter.service.persistence.impl.constants.ALLERTERPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = EmailPersistence.class)
public class EmailPersistenceImpl
	extends BasePersistenceImpl<Email> implements EmailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmailUtil</code> to access the email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDestinatario;
	private FinderPath _finderPathWithoutPaginationFindByDestinatario;
	private FinderPath _finderPathCountByDestinatario;

	/**
	 * Returns all the emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByDestinatario(long destinatario) {
		return findByDestinatario(
			destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByDestinatario(
		long destinatario, int start, int end) {

		return findByDestinatario(destinatario, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByDestinatario(
			destinatario, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDestinatario;
				finderArgs = new Object[] {destinatario};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDestinatario;
			finderArgs = new Object[] {
				destinatario, start, end, orderByComparator
			};
		}

		List<Email> list = null;

		if (useFinderCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (destinatario != email.getDestinatario()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMAIL_WHERE);

			sb.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatario);

				list = (List<Email>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByDestinatario_First(
			long destinatario, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByDestinatario_First(
			destinatario, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatario=");
		sb.append(destinatario);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the first email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByDestinatario_First(
		long destinatario, OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByDestinatario(
			destinatario, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByDestinatario_Last(
			long destinatario, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByDestinatario_Last(destinatario, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatario=");
		sb.append(destinatario);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the last email in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByDestinatario_Last(
		long destinatario, OrderByComparator<Email> orderByComparator) {

		int count = countByDestinatario(destinatario);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByDestinatario(
			destinatario, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByDestinatario_PrevAndNext(
				session, email, destinatario, orderByComparator, true);

			array[1] = email;

			array[2] = getByDestinatario_PrevAndNext(
				session, email, destinatario, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByDestinatario_PrevAndNext(
		Session session, Email email, long destinatario,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMAIL_WHERE);

		sb.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(destinatario);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Email> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	@Override
	public void removeByDestinatario(long destinatario) {
		for (Email email :
				findByDestinatario(
					destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching emails
	 */
	@Override
	public int countByDestinatario(long destinatario) {
		FinderPath finderPath = _finderPathCountByDestinatario;

		Object[] finderArgs = new Object[] {destinatario};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMAIL_WHERE);

			sb.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatario);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2 =
		"email.destinatario = ?";

	private FinderPath _finderPathWithPaginationFindByIndirizzo;
	private FinderPath _finderPathWithoutPaginationFindByIndirizzo;
	private FinderPath _finderPathCountByIndirizzo;

	/**
	 * Returns all the emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(String indirizzo) {
		return findByIndirizzo(
			indirizzo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(String indirizzo, int start, int end) {
		return findByIndirizzo(indirizzo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByIndirizzo(indirizzo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where indirizzo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param indirizzo the indirizzo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByIndirizzo(
		String indirizzo, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean useFinderCache) {

		indirizzo = Objects.toString(indirizzo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIndirizzo;
				finderArgs = new Object[] {indirizzo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIndirizzo;
			finderArgs = new Object[] {
				indirizzo, start, end, orderByComparator
			};
		}

		List<Email> list = null;

		if (useFinderCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!indirizzo.equals(email.getIndirizzo())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMAIL_WHERE);

			boolean bindIndirizzo = false;

			if (indirizzo.isEmpty()) {
				sb.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3);
			}
			else {
				bindIndirizzo = true;

				sb.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIndirizzo) {
					queryPos.add(indirizzo);
				}

				list = (List<Email>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByIndirizzo_First(
			String indirizzo, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByIndirizzo_First(indirizzo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("indirizzo=");
		sb.append(indirizzo);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the first email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByIndirizzo_First(
		String indirizzo, OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByIndirizzo(indirizzo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByIndirizzo_Last(
			String indirizzo, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByIndirizzo_Last(indirizzo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("indirizzo=");
		sb.append(indirizzo);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the last email in the ordered set where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByIndirizzo_Last(
		String indirizzo, OrderByComparator<Email> orderByComparator) {

		int count = countByIndirizzo(indirizzo);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByIndirizzo(
			indirizzo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where indirizzo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param indirizzo the indirizzo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByIndirizzo_PrevAndNext(
			long id, String indirizzo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		indirizzo = Objects.toString(indirizzo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByIndirizzo_PrevAndNext(
				session, email, indirizzo, orderByComparator, true);

			array[1] = email;

			array[2] = getByIndirizzo_PrevAndNext(
				session, email, indirizzo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByIndirizzo_PrevAndNext(
		Session session, Email email, String indirizzo,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMAIL_WHERE);

		boolean bindIndirizzo = false;

		if (indirizzo.isEmpty()) {
			sb.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3);
		}
		else {
			bindIndirizzo = true;

			sb.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIndirizzo) {
			queryPos.add(indirizzo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Email> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where indirizzo = &#63; from the database.
	 *
	 * @param indirizzo the indirizzo
	 */
	@Override
	public void removeByIndirizzo(String indirizzo) {
		for (Email email :
				findByIndirizzo(
					indirizzo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where indirizzo = &#63;.
	 *
	 * @param indirizzo the indirizzo
	 * @return the number of matching emails
	 */
	@Override
	public int countByIndirizzo(String indirizzo) {
		indirizzo = Objects.toString(indirizzo, "");

		FinderPath finderPath = _finderPathCountByIndirizzo;

		Object[] finderArgs = new Object[] {indirizzo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMAIL_WHERE);

			boolean bindIndirizzo = false;

			if (indirizzo.isEmpty()) {
				sb.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3);
			}
			else {
				bindIndirizzo = true;

				sb.append(_FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIndirizzo) {
					queryPos.add(indirizzo);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INDIRIZZO_INDIRIZZO_2 =
		"email.indirizzo = ?";

	private static final String _FINDER_COLUMN_INDIRIZZO_INDIRIZZO_3 =
		"(email.indirizzo IS NULL OR email.indirizzo = '')";

	private FinderPath _finderPathWithPaginationFindByInvio;
	private FinderPath _finderPathWithoutPaginationFindByInvio;
	private FinderPath _finderPathCountByInvio;

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByInvio(String tipo, String sottotipo, long param) {
		return findByInvio(
			tipo, sottotipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end) {

		return findByInvio(tipo, sottotipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean useFinderCache) {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInvio;
				finderArgs = new Object[] {tipo, sottotipo, param};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInvio;
			finderArgs = new Object[] {
				tipo, sottotipo, param, start, end, orderByComparator
			};
		}

		List<Email> list = null;

		if (useFinderCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!tipo.equals(email.getTipo()) ||
						!sottotipo.equals(email.getSottotipo()) ||
						(param != email.getParam())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_EMAIL_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVIO_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_INVIO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				sb.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_2);
			}

			sb.append(_FINDER_COLUMN_INVIO_PARAM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				if (bindSottotipo) {
					queryPos.add(sottotipo);
				}

				queryPos.add(param);

				list = (List<Email>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByInvio_First(
			String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByInvio_First(
			tipo, sottotipo, param, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", sottotipo=");
		sb.append(sottotipo);

		sb.append(", param=");
		sb.append(param);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByInvio_First(
		String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByInvio(
			tipo, sottotipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByInvio_Last(
			String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByInvio_Last(
			tipo, sottotipo, param, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", sottotipo=");
		sb.append(sottotipo);

		sb.append(", param=");
		sb.append(param);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator) {

		int count = countByInvio(tipo, sottotipo, param);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByInvio(
			tipo, sottotipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByInvio_PrevAndNext(
				session, email, tipo, sottotipo, param, orderByComparator,
				true);

			array[1] = email;

			array[2] = getByInvio_PrevAndNext(
				session, email, tipo, sottotipo, param, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByInvio_PrevAndNext(
		Session session, Email email, String tipo, String sottotipo, long param,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_EMAIL_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			sb.append(_FINDER_COLUMN_INVIO_TIPO_3);
		}
		else {
			bindTipo = true;

			sb.append(_FINDER_COLUMN_INVIO_TIPO_2);
		}

		boolean bindSottotipo = false;

		if (sottotipo.isEmpty()) {
			sb.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_3);
		}
		else {
			bindSottotipo = true;

			sb.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_2);
		}

		sb.append(_FINDER_COLUMN_INVIO_PARAM_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTipo) {
			queryPos.add(tipo);
		}

		if (bindSottotipo) {
			queryPos.add(sottotipo);
		}

		queryPos.add(param);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Email> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	@Override
	public void removeByInvio(String tipo, String sottotipo, long param) {
		for (Email email :
				findByInvio(
					tipo, sottotipo, param, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	@Override
	public int countByInvio(String tipo, String sottotipo, long param) {
		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		FinderPath finderPath = _finderPathCountByInvio;

		Object[] finderArgs = new Object[] {tipo, sottotipo, param};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_EMAIL_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVIO_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_INVIO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				sb.append(_FINDER_COLUMN_INVIO_SOTTOTIPO_2);
			}

			sb.append(_FINDER_COLUMN_INVIO_PARAM_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				if (bindSottotipo) {
					queryPos.add(sottotipo);
				}

				queryPos.add(param);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INVIO_TIPO_2 =
		"email.tipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_TIPO_3 =
		"(email.tipo IS NULL OR email.tipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_2 =
		"email.sottotipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_3 =
		"(email.sottotipo IS NULL OR email.sottotipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_PARAM_2 =
		"email.param = ?";

	private FinderPath _finderPathWithPaginationFindByTipoSottotipo;
	private FinderPath _finderPathWithoutPaginationFindByTipoSottotipo;
	private FinderPath _finderPathCountByTipoSottotipo;

	/**
	 * Returns all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(String tipo, String sottotipo) {
		return findByTipoSottotipo(
			tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end) {

		return findByTipoSottotipo(tipo, sottotipo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean useFinderCache) {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTipoSottotipo;
				finderArgs = new Object[] {tipo, sottotipo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTipoSottotipo;
			finderArgs = new Object[] {
				tipo, sottotipo, start, end, orderByComparator
			};
		}

		List<Email> list = null;

		if (useFinderCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!tipo.equals(email.getTipo()) ||
						!sottotipo.equals(email.getSottotipo())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EMAIL_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				if (bindSottotipo) {
					queryPos.add(sottotipo);
				}

				list = (List<Email>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoSottotipo_First(
			String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", sottotipo=");
		sb.append(sottotipo);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByTipoSottotipo(
			tipo, sottotipo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoSottotipo_Last(
			tipo, sottotipo, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", sottotipo=");
		sb.append(sottotipo);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator) {

		int count = countByTipoSottotipo(tipo, sottotipo);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByTipoSottotipo(
			tipo, sottotipo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByTipoSottotipo_PrevAndNext(
				session, email, tipo, sottotipo, orderByComparator, true);

			array[1] = email;

			array[2] = getByTipoSottotipo_PrevAndNext(
				session, email, tipo, sottotipo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByTipoSottotipo_PrevAndNext(
		Session session, Email email, String tipo, String sottotipo,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMAIL_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3);
		}
		else {
			bindTipo = true;

			sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2);
		}

		boolean bindSottotipo = false;

		if (sottotipo.isEmpty()) {
			sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3);
		}
		else {
			bindSottotipo = true;

			sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTipo) {
			queryPos.add(tipo);
		}

		if (bindSottotipo) {
			queryPos.add(sottotipo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Email> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	@Override
	public void removeByTipoSottotipo(String tipo, String sottotipo) {
		for (Email email :
				findByTipoSottotipo(
					tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching emails
	 */
	@Override
	public int countByTipoSottotipo(String tipo, String sottotipo) {
		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		FinderPath finderPath = _finderPathCountByTipoSottotipo;

		Object[] finderArgs = new Object[] {tipo, sottotipo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAIL_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2);
			}

			boolean bindSottotipo = false;

			if (sottotipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3);
			}
			else {
				bindSottotipo = true;

				sb.append(_FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				if (bindSottotipo) {
					queryPos.add(sottotipo);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_2 =
		"email.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3 =
		"(email.tipo IS NULL OR email.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2 =
		"email.sottotipo = ?";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3 =
		"(email.sottotipo IS NULL OR email.sottotipo = '')";

	private FinderPath _finderPathWithPaginationFindByTipoParam;
	private FinderPath _finderPathWithoutPaginationFindByTipoParam;
	private FinderPath _finderPathCountByTipoParam;

	/**
	 * Returns all the emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching emails
	 */
	@Override
	public List<Email> findByTipoParam(String tipo, long param) {
		return findByTipoParam(
			tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of matching emails
	 */
	@Override
	public List<Email> findByTipoParam(
		String tipo, long param, int start, int end) {

		return findByTipoParam(tipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator) {

		return findByTipoParam(
			tipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emails
	 */
	@Override
	public List<Email> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<Email> orderByComparator, boolean useFinderCache) {

		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTipoParam;
				finderArgs = new Object[] {tipo, param};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTipoParam;
			finderArgs = new Object[] {
				tipo, param, start, end, orderByComparator
			};
		}

		List<Email> list = null;

		if (useFinderCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Email email : list) {
					if (!tipo.equals(email.getTipo()) ||
						(param != email.getParam())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EMAIL_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPOPARAM_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_TIPOPARAM_TIPO_2);
			}

			sb.append(_FINDER_COLUMN_TIPOPARAM_PARAM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				queryPos.add(param);

				list = (List<Email>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoParam_First(
			String tipo, long param, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoParam_First(tipo, param, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", param=");
		sb.append(param);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the first email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoParam_First(
		String tipo, long param, OrderByComparator<Email> orderByComparator) {

		List<Email> list = findByTipoParam(
			tipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email
	 * @throws NoSuchEmailException if a matching email could not be found
	 */
	@Override
	public Email findByTipoParam_Last(
			String tipo, long param, OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		Email email = fetchByTipoParam_Last(tipo, param, orderByComparator);

		if (email != null) {
			return email;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", param=");
		sb.append(param);

		sb.append("}");

		throw new NoSuchEmailException(sb.toString());
	}

	/**
	 * Returns the last email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email, or <code>null</code> if a matching email could not be found
	 */
	@Override
	public Email fetchByTipoParam_Last(
		String tipo, long param, OrderByComparator<Email> orderByComparator) {

		int count = countByTipoParam(tipo, param);

		if (count == 0) {
			return null;
		}

		List<Email> list = findByTipoParam(
			tipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emails before and after the current email in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current email
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException {

		tipo = Objects.toString(tipo, "");

		Email email = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Email[] array = new EmailImpl[3];

			array[0] = getByTipoParam_PrevAndNext(
				session, email, tipo, param, orderByComparator, true);

			array[1] = email;

			array[2] = getByTipoParam_PrevAndNext(
				session, email, tipo, param, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Email getByTipoParam_PrevAndNext(
		Session session, Email email, String tipo, long param,
		OrderByComparator<Email> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMAIL_WHERE);

		boolean bindTipo = false;

		if (tipo.isEmpty()) {
			sb.append(_FINDER_COLUMN_TIPOPARAM_TIPO_3);
		}
		else {
			bindTipo = true;

			sb.append(_FINDER_COLUMN_TIPOPARAM_TIPO_2);
		}

		sb.append(_FINDER_COLUMN_TIPOPARAM_PARAM_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTipo) {
			queryPos.add(tipo);
		}

		queryPos.add(param);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(email)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Email> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emails where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	@Override
	public void removeByTipoParam(String tipo, long param) {
		for (Email email :
				findByTipoParam(
					tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(email);
		}
	}

	/**
	 * Returns the number of emails where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching emails
	 */
	@Override
	public int countByTipoParam(String tipo, long param) {
		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = _finderPathCountByTipoParam;

		Object[] finderArgs = new Object[] {tipo, param};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAIL_WHERE);

			boolean bindTipo = false;

			if (tipo.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIPOPARAM_TIPO_3);
			}
			else {
				bindTipo = true;

				sb.append(_FINDER_COLUMN_TIPOPARAM_TIPO_2);
			}

			sb.append(_FINDER_COLUMN_TIPOPARAM_PARAM_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTipo) {
					queryPos.add(tipo);
				}

				queryPos.add(param);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIPOPARAM_TIPO_2 =
		"email.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_TIPO_3 =
		"(email.tipo IS NULL OR email.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_PARAM_2 =
		"email.param = ?";

	public EmailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Email.class);

		setModelImplClass(EmailImpl.class);
		setModelPKClass(long.class);

		setTable(EmailTable.INSTANCE);
	}

	/**
	 * Caches the email in the entity cache if it is enabled.
	 *
	 * @param email the email
	 */
	@Override
	public void cacheResult(Email email) {
		entityCache.putResult(EmailImpl.class, email.getPrimaryKey(), email);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the emails in the entity cache if it is enabled.
	 *
	 * @param emails the emails
	 */
	@Override
	public void cacheResult(List<Email> emails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Email email : emails) {
			if (entityCache.getResult(EmailImpl.class, email.getPrimaryKey()) ==
					null) {

				cacheResult(email);
			}
		}
	}

	/**
	 * Clears the cache for all emails.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailImpl.class);

		finderCache.clearCache(EmailImpl.class);
	}

	/**
	 * Clears the cache for the email.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Email email) {
		entityCache.removeResult(EmailImpl.class, email);
	}

	@Override
	public void clearCache(List<Email> emails) {
		for (Email email : emails) {
			entityCache.removeResult(EmailImpl.class, email);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new email with the primary key. Does not add the email to the database.
	 *
	 * @param id the primary key for the new email
	 * @return the new email
	 */
	@Override
	public Email create(long id) {
		Email email = new EmailImpl();

		email.setNew(true);
		email.setPrimaryKey(id);

		return email;
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email remove(long id) throws NoSuchEmailException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email that was removed
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email remove(Serializable primaryKey) throws NoSuchEmailException {
		Session session = null;

		try {
			session = openSession();

			Email email = (Email)session.get(EmailImpl.class, primaryKey);

			if (email == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(email);
		}
		catch (NoSuchEmailException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Email removeImpl(Email email) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(email)) {
				email = (Email)session.get(
					EmailImpl.class, email.getPrimaryKeyObj());
			}

			if (email != null) {
				session.delete(email);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (email != null) {
			clearCache(email);
		}

		return email;
	}

	@Override
	public Email updateImpl(Email email) {
		boolean isNew = email.isNew();

		if (!(email instanceof EmailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(email.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(email);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in email proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Email implementation " +
					email.getClass());
		}

		EmailModelImpl emailModelImpl = (EmailModelImpl)email;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(email);
			}
			else {
				email = (Email)session.merge(email);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EmailImpl.class, emailModelImpl, false, true);

		if (isNew) {
			email.setNew(false);
		}

		email.resetOriginalValues();

		return email;
	}

	/**
	 * Returns the email with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailException {

		Email email = fetchByPrimaryKey(primaryKey);

		if (email == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return email;
	}

	/**
	 * Returns the email with the primary key or throws a <code>NoSuchEmailException</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email
	 * @throws NoSuchEmailException if a email with the primary key could not be found
	 */
	@Override
	public Email findByPrimaryKey(long id) throws NoSuchEmailException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email
	 * @return the email, or <code>null</code> if a email with the primary key could not be found
	 */
	@Override
	public Email fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the emails.
	 *
	 * @return the emails
	 */
	@Override
	public List<Email> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @return the range of emails
	 */
	@Override
	public List<Email> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emails
	 */
	@Override
	public List<Email> findAll(
		int start, int end, OrderByComparator<Email> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emails
	 * @param end the upper bound of the range of emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of emails
	 */
	@Override
	public List<Email> findAll(
		int start, int end, OrderByComparator<Email> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Email> list = null;

		if (useFinderCache) {
			list = (List<Email>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMAIL;

				sql = sql.concat(EmailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Email>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the emails from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Email email : findAll()) {
			remove(email);
		}
	}

	/**
	 * Returns the number of emails.
	 *
	 * @return the number of emails
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMAIL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByDestinatario = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDestinatario",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"destinatario"}, true);

		_finderPathWithoutPaginationFindByDestinatario = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDestinatario",
			new String[] {Long.class.getName()}, new String[] {"destinatario"},
			true);

		_finderPathCountByDestinatario = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDestinatario",
			new String[] {Long.class.getName()}, new String[] {"destinatario"},
			false);

		_finderPathWithPaginationFindByIndirizzo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIndirizzo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"indirizzo"}, true);

		_finderPathWithoutPaginationFindByIndirizzo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIndirizzo",
			new String[] {String.class.getName()}, new String[] {"indirizzo"},
			true);

		_finderPathCountByIndirizzo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIndirizzo",
			new String[] {String.class.getName()}, new String[] {"indirizzo"},
			false);

		_finderPathWithPaginationFindByInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tipo", "sottotipo", "param"}, true);

		_finderPathWithoutPaginationFindByInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"tipo", "sottotipo", "param"}, true);

		_finderPathCountByInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvio",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"tipo", "sottotipo", "param"}, false);

		_finderPathWithPaginationFindByTipoSottotipo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoSottotipo",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"tipo", "sottotipo"}, true);

		_finderPathWithoutPaginationFindByTipoSottotipo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoSottotipo",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"tipo", "sottotipo"}, true);

		_finderPathCountByTipoSottotipo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoSottotipo",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"tipo", "sottotipo"}, false);

		_finderPathWithPaginationFindByTipoParam = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoParam",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"tipo", "param"}, true);

		_finderPathWithoutPaginationFindByTipoParam = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoParam",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"tipo", "param"}, true);

		_finderPathCountByTipoParam = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoParam",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"tipo", "param"}, false);

		EmailUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmailUtil.setPersistence(null);

		entityCache.removeCache(EmailImpl.class.getName());
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ALLERTERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMAIL =
		"SELECT email FROM Email email";

	private static final String _SQL_SELECT_EMAIL_WHERE =
		"SELECT email FROM Email email WHERE ";

	private static final String _SQL_COUNT_EMAIL =
		"SELECT COUNT(email) FROM Email email";

	private static final String _SQL_COUNT_EMAIL_WHERE =
		"SELECT COUNT(email) FROM Email email WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "email.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Email exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Email exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}