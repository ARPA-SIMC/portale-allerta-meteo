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

import it.eng.allerter.exception.NoSuchSMSException;
import it.eng.allerter.model.SMS;
import it.eng.allerter.model.SMSTable;
import it.eng.allerter.model.impl.SMSImpl;
import it.eng.allerter.model.impl.SMSModelImpl;
import it.eng.allerter.service.persistence.SMSPersistence;
import it.eng.allerter.service.persistence.SMSUtil;
import it.eng.allerter.service.persistence.impl.constants.ALLERTERPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
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
 * The persistence implementation for the sms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = SMSPersistence.class)
public class SMSPersistenceImpl
	extends BasePersistenceImpl<SMS> implements SMSPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SMSUtil</code> to access the sms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SMSImpl.class.getName();

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
	 * Returns all the smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(long destinatario) {
		return findByDestinatario(
			destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(long destinatario, int start, int end) {
		return findByDestinatario(destinatario, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByDestinatario(
			destinatario, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where destinatario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param destinatario the destinatario
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByDestinatario(
		long destinatario, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

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

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (destinatario != sms.getDestinatario()) {
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

			sb.append(_SQL_SELECT_SMS_WHERE);

			sb.append(_FINDER_COLUMN_DESTINATARIO_DESTINATARIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatario);

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByDestinatario_First(
			long destinatario, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByDestinatario_First(destinatario, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatario=");
		sb.append(destinatario);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByDestinatario_First(
		long destinatario, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByDestinatario(
			destinatario, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByDestinatario_Last(
			long destinatario, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByDestinatario_Last(destinatario, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatario=");
		sb.append(destinatario);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByDestinatario_Last(
		long destinatario, OrderByComparator<SMS> orderByComparator) {

		int count = countByDestinatario(destinatario);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByDestinatario(
			destinatario, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where destinatario = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param destinatario the destinatario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByDestinatario_PrevAndNext(
			long id, long destinatario,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByDestinatario_PrevAndNext(
				session, sms, destinatario, orderByComparator, true);

			array[1] = sms;

			array[2] = getByDestinatario_PrevAndNext(
				session, sms, destinatario, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByDestinatario_PrevAndNext(
		Session session, SMS sms, long destinatario,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(destinatario);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where destinatario = &#63; from the database.
	 *
	 * @param destinatario the destinatario
	 */
	@Override
	public void removeByDestinatario(long destinatario) {
		for (SMS sms :
				findByDestinatario(
					destinatario, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where destinatario = &#63;.
	 *
	 * @param destinatario the destinatario
	 * @return the number of matching smses
	 */
	@Override
	public int countByDestinatario(long destinatario) {
		FinderPath finderPath = _finderPathCountByDestinatario;

		Object[] finderArgs = new Object[] {destinatario};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMS_WHERE);

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
		"sms.destinatario = ?";

	private FinderPath _finderPathWithPaginationFindByNumero;
	private FinderPath _finderPathWithoutPaginationFindByNumero;
	private FinderPath _finderPathCountByNumero;

	/**
	 * Returns all the smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByNumero(String numero) {
		return findByNumero(numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByNumero(String numero, int start, int end) {
		return findByNumero(numero, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumero(
		String numero, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByNumero(numero, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumero(
		String numero, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

		numero = Objects.toString(numero, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNumero;
				finderArgs = new Object[] {numero};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNumero;
			finderArgs = new Object[] {numero, start, end, orderByComparator};
		}

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!numero.equals(sms.getNumero())) {
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

			sb.append(_SQL_SELECT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				sb.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
			}
			else {
				bindNumero = true;

				sb.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNumero) {
					queryPos.add(numero);
				}

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumero_First(
			String numero, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumero_First(numero, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumero_First(
		String numero, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByNumero(numero, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumero_Last(
			String numero, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumero_Last(numero, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumero_Last(
		String numero, OrderByComparator<SMS> orderByComparator) {

		int count = countByNumero(numero);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByNumero(
			numero, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByNumero_PrevAndNext(
			long id, String numero, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		numero = Objects.toString(numero, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByNumero_PrevAndNext(
				session, sms, numero, orderByComparator, true);

			array[1] = sms;

			array[2] = getByNumero_PrevAndNext(
				session, sms, numero, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByNumero_PrevAndNext(
		Session session, SMS sms, String numero,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

		boolean bindNumero = false;

		if (numero.isEmpty()) {
			sb.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
		}
		else {
			bindNumero = true;

			sb.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNumero) {
			queryPos.add(numero);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	@Override
	public void removeByNumero(String numero) {
		for (SMS sms :
				findByNumero(
					numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching smses
	 */
	@Override
	public int countByNumero(String numero) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumero;

		Object[] finderArgs = new Object[] {numero};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				sb.append(_FINDER_COLUMN_NUMERO_NUMERO_3);
			}
			else {
				bindNumero = true;

				sb.append(_FINDER_COLUMN_NUMERO_NUMERO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNumero) {
					queryPos.add(numero);
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

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_2 =
		"sms.numero = ?";

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_3 =
		"(sms.numero IS NULL OR sms.numero = '')";

	private FinderPath _finderPathWithPaginationFindByNumeroDataAck;
	private FinderPath _finderPathWithoutPaginationFindByNumeroDataAck;
	private FinderPath _finderPathCountByNumeroDataAck;

	/**
	 * Returns all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(String numero, Date dataAck) {
		return findByNumeroDataAck(
			numero, dataAck, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end) {

		return findByNumeroDataAck(numero, dataAck, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByNumeroDataAck(
			numero, dataAck, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where numero = &#63; and dataAck = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByNumeroDataAck(
		String numero, Date dataAck, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

		numero = Objects.toString(numero, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNumeroDataAck;
				finderArgs = new Object[] {numero, _getTime(dataAck)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNumeroDataAck;
			finderArgs = new Object[] {
				numero, _getTime(dataAck), start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!numero.equals(sms.getNumero()) ||
						!Objects.equals(dataAck, sms.getDataAck())) {

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

			sb.append(_SQL_SELECT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				sb.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_3);
			}
			else {
				bindNumero = true;

				sb.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_2);
			}

			boolean bindDataAck = false;

			if (dataAck == null) {
				sb.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_1);
			}
			else {
				bindDataAck = true;

				sb.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNumero) {
					queryPos.add(numero);
				}

				if (bindDataAck) {
					queryPos.add(new Timestamp(dataAck.getTime()));
				}

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumeroDataAck_First(
			String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumeroDataAck_First(
			numero, dataAck, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append(", dataAck=");
		sb.append(dataAck);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumeroDataAck_First(
		String numero, Date dataAck, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByNumeroDataAck(
			numero, dataAck, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByNumeroDataAck_Last(
			String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByNumeroDataAck_Last(numero, dataAck, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append(", dataAck=");
		sb.append(dataAck);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByNumeroDataAck_Last(
		String numero, Date dataAck, OrderByComparator<SMS> orderByComparator) {

		int count = countByNumeroDataAck(numero, dataAck);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByNumeroDataAck(
			numero, dataAck, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where numero = &#63; and dataAck = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByNumeroDataAck_PrevAndNext(
			long id, String numero, Date dataAck,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		numero = Objects.toString(numero, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByNumeroDataAck_PrevAndNext(
				session, sms, numero, dataAck, orderByComparator, true);

			array[1] = sms;

			array[2] = getByNumeroDataAck_PrevAndNext(
				session, sms, numero, dataAck, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByNumeroDataAck_PrevAndNext(
		Session session, SMS sms, String numero, Date dataAck,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

		boolean bindNumero = false;

		if (numero.isEmpty()) {
			sb.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_3);
		}
		else {
			bindNumero = true;

			sb.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_2);
		}

		boolean bindDataAck = false;

		if (dataAck == null) {
			sb.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_1);
		}
		else {
			bindDataAck = true;

			sb.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_2);
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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNumero) {
			queryPos.add(numero);
		}

		if (bindDataAck) {
			queryPos.add(new Timestamp(dataAck.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where numero = &#63; and dataAck = &#63; from the database.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 */
	@Override
	public void removeByNumeroDataAck(String numero, Date dataAck) {
		for (SMS sms :
				findByNumeroDataAck(
					numero, dataAck, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where numero = &#63; and dataAck = &#63;.
	 *
	 * @param numero the numero
	 * @param dataAck the data ack
	 * @return the number of matching smses
	 */
	@Override
	public int countByNumeroDataAck(String numero, Date dataAck) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumeroDataAck;

		Object[] finderArgs = new Object[] {numero, _getTime(dataAck)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SMS_WHERE);

			boolean bindNumero = false;

			if (numero.isEmpty()) {
				sb.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_3);
			}
			else {
				bindNumero = true;

				sb.append(_FINDER_COLUMN_NUMERODATAACK_NUMERO_2);
			}

			boolean bindDataAck = false;

			if (dataAck == null) {
				sb.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_1);
			}
			else {
				bindDataAck = true;

				sb.append(_FINDER_COLUMN_NUMERODATAACK_DATAACK_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNumero) {
					queryPos.add(numero);
				}

				if (bindDataAck) {
					queryPos.add(new Timestamp(dataAck.getTime()));
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

	private static final String _FINDER_COLUMN_NUMERODATAACK_NUMERO_2 =
		"sms.numero = ? AND ";

	private static final String _FINDER_COLUMN_NUMERODATAACK_NUMERO_3 =
		"(sms.numero IS NULL OR sms.numero = '') AND ";

	private static final String _FINDER_COLUMN_NUMERODATAACK_DATAACK_1 =
		"sms.dataAck IS NULL";

	private static final String _FINDER_COLUMN_NUMERODATAACK_DATAACK_2 =
		"sms.dataAck = ?";

	private FinderPath _finderPathWithPaginationFindByInvio;
	private FinderPath _finderPathWithoutPaginationFindByInvio;
	private FinderPath _finderPathCountByInvio;

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByInvio(String tipo, String sottotipo, long param) {
		return findByInvio(
			tipo, sottotipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end) {

		return findByInvio(tipo, sottotipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByInvio(
			tipo, sottotipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByInvio(
		String tipo, String sottotipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

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

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!tipo.equals(sms.getTipo()) ||
						!sottotipo.equals(sms.getSottotipo()) ||
						(param != sms.getParam())) {

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

			sb.append(_SQL_SELECT_SMS_WHERE);

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
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
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

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByInvio_First(
			String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByInvio_First(tipo, sottotipo, param, orderByComparator);

		if (sms != null) {
			return sms;
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

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByInvio_First(
		String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByInvio(
			tipo, sottotipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByInvio_Last(
			String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByInvio_Last(tipo, sottotipo, param, orderByComparator);

		if (sms != null) {
			return sms;
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

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByInvio_Last(
		String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator) {

		int count = countByInvio(tipo, sottotipo, param);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByInvio(
			tipo, sottotipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByInvio_PrevAndNext(
			long id, String tipo, String sottotipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByInvio_PrevAndNext(
				session, sms, tipo, sottotipo, param, orderByComparator, true);

			array[1] = sms;

			array[2] = getByInvio_PrevAndNext(
				session, sms, tipo, sottotipo, param, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByInvio_PrevAndNext(
		Session session, SMS sms, String tipo, String sottotipo, long param,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 */
	@Override
	public void removeByInvio(String tipo, String sottotipo, long param) {
		for (SMS sms :
				findByInvio(
					tipo, sottotipo, param, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param param the param
	 * @return the number of matching smses
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

			sb.append(_SQL_COUNT_SMS_WHERE);

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
		"sms.tipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_TIPO_3 =
		"(sms.tipo IS NULL OR sms.tipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_2 =
		"sms.sottotipo = ? AND ";

	private static final String _FINDER_COLUMN_INVIO_SOTTOTIPO_3 =
		"(sms.sottotipo IS NULL OR sms.sottotipo = '') AND ";

	private static final String _FINDER_COLUMN_INVIO_PARAM_2 = "sms.param = ?";

	private FinderPath _finderPathWithPaginationFindByTipoSottotipo;
	private FinderPath _finderPathWithoutPaginationFindByTipoSottotipo;
	private FinderPath _finderPathCountByTipoSottotipo;

	/**
	 * Returns all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(String tipo, String sottotipo) {
		return findByTipoSottotipo(
			tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end) {

		return findByTipoSottotipo(tipo, sottotipo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByTipoSottotipo(
			tipo, sottotipo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoSottotipo(
		String tipo, String sottotipo, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

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

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!tipo.equals(sms.getTipo()) ||
						!sottotipo.equals(sms.getSottotipo())) {

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

			sb.append(_SQL_SELECT_SMS_WHERE);

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
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
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

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoSottotipo_First(
			String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoSottotipo_First(
			tipo, sottotipo, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", sottotipo=");
		sb.append(sottotipo);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoSottotipo_First(
		String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByTipoSottotipo(
			tipo, sottotipo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoSottotipo_Last(
			String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoSottotipo_Last(tipo, sottotipo, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", sottotipo=");
		sb.append(sottotipo);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoSottotipo_Last(
		String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator) {

		int count = countByTipoSottotipo(tipo, sottotipo);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByTipoSottotipo(
			tipo, sottotipo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByTipoSottotipo_PrevAndNext(
			long id, String tipo, String sottotipo,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		tipo = Objects.toString(tipo, "");
		sottotipo = Objects.toString(sottotipo, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByTipoSottotipo_PrevAndNext(
				session, sms, tipo, sottotipo, orderByComparator, true);

			array[1] = sms;

			array[2] = getByTipoSottotipo_PrevAndNext(
				session, sms, tipo, sottotipo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByTipoSottotipo_PrevAndNext(
		Session session, SMS sms, String tipo, String sottotipo,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where tipo = &#63; and sottotipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 */
	@Override
	public void removeByTipoSottotipo(String tipo, String sottotipo) {
		for (SMS sms :
				findByTipoSottotipo(
					tipo, sottotipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where tipo = &#63; and sottotipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param sottotipo the sottotipo
	 * @return the number of matching smses
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

			sb.append(_SQL_COUNT_SMS_WHERE);

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
		"sms.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_TIPO_3 =
		"(sms.tipo IS NULL OR sms.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_2 =
		"sms.sottotipo = ?";

	private static final String _FINDER_COLUMN_TIPOSOTTOTIPO_SOTTOTIPO_3 =
		"(sms.sottotipo IS NULL OR sms.sottotipo = '')";

	private FinderPath _finderPathWithPaginationFindByTipoParam;
	private FinderPath _finderPathWithoutPaginationFindByTipoParam;
	private FinderPath _finderPathCountByTipoParam;

	/**
	 * Returns all the smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(String tipo, long param) {
		return findByTipoParam(
			tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(
		String tipo, long param, int start, int end) {

		return findByTipoParam(tipo, param, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByTipoParam(
			tipo, param, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where tipo = &#63; and param = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTipoParam(
		String tipo, long param, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

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

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!tipo.equals(sms.getTipo()) ||
						(param != sms.getParam())) {

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

			sb.append(_SQL_SELECT_SMS_WHERE);

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
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
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

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoParam_First(
			String tipo, long param, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoParam_First(tipo, param, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", param=");
		sb.append(param);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoParam_First(
		String tipo, long param, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByTipoParam(tipo, param, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTipoParam_Last(
			String tipo, long param, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTipoParam_Last(tipo, param, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipo=");
		sb.append(tipo);

		sb.append(", param=");
		sb.append(param);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTipoParam_Last(
		String tipo, long param, OrderByComparator<SMS> orderByComparator) {

		int count = countByTipoParam(tipo, param);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByTipoParam(
			tipo, param, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where tipo = &#63; and param = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param tipo the tipo
	 * @param param the param
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByTipoParam_PrevAndNext(
			long id, String tipo, long param,
			OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		tipo = Objects.toString(tipo, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByTipoParam_PrevAndNext(
				session, sms, tipo, param, orderByComparator, true);

			array[1] = sms;

			array[2] = getByTipoParam_PrevAndNext(
				session, sms, tipo, param, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByTipoParam_PrevAndNext(
		Session session, SMS sms, String tipo, long param,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where tipo = &#63; and param = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 */
	@Override
	public void removeByTipoParam(String tipo, long param) {
		for (SMS sms :
				findByTipoParam(
					tipo, param, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where tipo = &#63; and param = &#63;.
	 *
	 * @param tipo the tipo
	 * @param param the param
	 * @return the number of matching smses
	 */
	@Override
	public int countByTipoParam(String tipo, long param) {
		tipo = Objects.toString(tipo, "");

		FinderPath finderPath = _finderPathCountByTipoParam;

		Object[] finderArgs = new Object[] {tipo, param};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SMS_WHERE);

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
		"sms.tipo = ? AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_TIPO_3 =
		"(sms.tipo IS NULL OR sms.tipo = '') AND ";

	private static final String _FINDER_COLUMN_TIPOPARAM_PARAM_2 =
		"sms.param = ?";

	private FinderPath _finderPathWithPaginationFindByTimestamp;
	private FinderPath _finderPathWithoutPaginationFindByTimestamp;
	private FinderPath _finderPathCountByTimestamp;

	/**
	 * Returns all the smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(String timestamp) {
		return findByTimestamp(
			timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(String timestamp, int start, int end) {
		return findByTimestamp(timestamp, start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return findByTimestamp(timestamp, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smses
	 */
	@Override
	public List<SMS> findByTimestamp(
		String timestamp, int start, int end,
		OrderByComparator<SMS> orderByComparator, boolean useFinderCache) {

		timestamp = Objects.toString(timestamp, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTimestamp;
				finderArgs = new Object[] {timestamp};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTimestamp;
			finderArgs = new Object[] {
				timestamp, start, end, orderByComparator
			};
		}

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SMS sms : list) {
					if (!timestamp.equals(sms.getTimestamp())) {
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

			sb.append(_SQL_SELECT_SMS_WHERE);

			boolean bindTimestamp = false;

			if (timestamp.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3);
			}
			else {
				bindTimestamp = true;

				sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SMSModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTimestamp) {
					queryPos.add(timestamp);
				}

				list = (List<SMS>)QueryUtil.list(
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
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTimestamp_First(
			String timestamp, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTimestamp_First(timestamp, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("timestamp=");
		sb.append(timestamp);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the first sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTimestamp_First(
		String timestamp, OrderByComparator<SMS> orderByComparator) {

		List<SMS> list = findByTimestamp(timestamp, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms
	 * @throws NoSuchSMSException if a matching sms could not be found
	 */
	@Override
	public SMS findByTimestamp_Last(
			String timestamp, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		SMS sms = fetchByTimestamp_Last(timestamp, orderByComparator);

		if (sms != null) {
			return sms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("timestamp=");
		sb.append(timestamp);

		sb.append("}");

		throw new NoSuchSMSException(sb.toString());
	}

	/**
	 * Returns the last sms in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sms, or <code>null</code> if a matching sms could not be found
	 */
	@Override
	public SMS fetchByTimestamp_Last(
		String timestamp, OrderByComparator<SMS> orderByComparator) {

		int count = countByTimestamp(timestamp);

		if (count == 0) {
			return null;
		}

		List<SMS> list = findByTimestamp(
			timestamp, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the smses before and after the current sms in the ordered set where timestamp = &#63;.
	 *
	 * @param id the primary key of the current sms
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS[] findByTimestamp_PrevAndNext(
			long id, String timestamp, OrderByComparator<SMS> orderByComparator)
		throws NoSuchSMSException {

		timestamp = Objects.toString(timestamp, "");

		SMS sms = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SMS[] array = new SMSImpl[3];

			array[0] = getByTimestamp_PrevAndNext(
				session, sms, timestamp, orderByComparator, true);

			array[1] = sms;

			array[2] = getByTimestamp_PrevAndNext(
				session, sms, timestamp, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SMS getByTimestamp_PrevAndNext(
		Session session, SMS sms, String timestamp,
		OrderByComparator<SMS> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SMS_WHERE);

		boolean bindTimestamp = false;

		if (timestamp.isEmpty()) {
			sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3);
		}
		else {
			bindTimestamp = true;

			sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
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
			sb.append(SMSModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTimestamp) {
			queryPos.add(timestamp);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SMS> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the smses where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 */
	@Override
	public void removeByTimestamp(String timestamp) {
		for (SMS sms :
				findByTimestamp(
					timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sms);
		}
	}

	/**
	 * Returns the number of smses where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching smses
	 */
	@Override
	public int countByTimestamp(String timestamp) {
		timestamp = Objects.toString(timestamp, "");

		FinderPath finderPath = _finderPathCountByTimestamp;

		Object[] finderArgs = new Object[] {timestamp};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMS_WHERE);

			boolean bindTimestamp = false;

			if (timestamp.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3);
			}
			else {
				bindTimestamp = true;

				sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTimestamp) {
					queryPos.add(timestamp);
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

	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2 =
		"sms.timestamp = ?";

	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_3 =
		"(sms.timestamp IS NULL OR sms.timestamp = '')";

	public SMSPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SMS.class);

		setModelImplClass(SMSImpl.class);
		setModelPKClass(long.class);

		setTable(SMSTable.INSTANCE);
	}

	/**
	 * Caches the sms in the entity cache if it is enabled.
	 *
	 * @param sms the sms
	 */
	@Override
	public void cacheResult(SMS sms) {
		entityCache.putResult(SMSImpl.class, sms.getPrimaryKey(), sms);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smses in the entity cache if it is enabled.
	 *
	 * @param smses the smses
	 */
	@Override
	public void cacheResult(List<SMS> smses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SMS sms : smses) {
			if (entityCache.getResult(SMSImpl.class, sms.getPrimaryKey()) ==
					null) {

				cacheResult(sms);
			}
		}
	}

	/**
	 * Clears the cache for all smses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SMSImpl.class);

		finderCache.clearCache(SMSImpl.class);
	}

	/**
	 * Clears the cache for the sms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SMS sms) {
		entityCache.removeResult(SMSImpl.class, sms);
	}

	@Override
	public void clearCache(List<SMS> smses) {
		for (SMS sms : smses) {
			entityCache.removeResult(SMSImpl.class, sms);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SMSImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SMSImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	@Override
	public SMS create(long id) {
		SMS sms = new SMSImpl();

		sms.setNew(true);
		sms.setPrimaryKey(id);

		return sms;
	}

	/**
	 * Removes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS remove(long id) throws NoSuchSMSException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sms
	 * @return the sms that was removed
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS remove(Serializable primaryKey) throws NoSuchSMSException {
		Session session = null;

		try {
			session = openSession();

			SMS sms = (SMS)session.get(SMSImpl.class, primaryKey);

			if (sms == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSMSException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sms);
		}
		catch (NoSuchSMSException noSuchEntityException) {
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
	protected SMS removeImpl(SMS sms) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sms)) {
				sms = (SMS)session.get(SMSImpl.class, sms.getPrimaryKeyObj());
			}

			if (sms != null) {
				session.delete(sms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sms != null) {
			clearCache(sms);
		}

		return sms;
	}

	@Override
	public SMS updateImpl(SMS sms) {
		boolean isNew = sms.isNew();

		if (!(sms instanceof SMSModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sms.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(sms);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sms proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SMS implementation " +
					sms.getClass());
		}

		SMSModelImpl smsModelImpl = (SMSModelImpl)sms;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sms);
			}
			else {
				sms = (SMS)session.merge(sms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SMSImpl.class, smsModelImpl, false, true);

		if (isNew) {
			sms.setNew(false);
		}

		sms.resetOriginalValues();

		return sms;
	}

	/**
	 * Returns the sms with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sms
	 * @return the sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSMSException {

		SMS sms = fetchByPrimaryKey(primaryKey);

		if (sms == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSMSException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sms;
	}

	/**
	 * Returns the sms with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws NoSuchSMSException if a sms with the primary key could not be found
	 */
	@Override
	public SMS findByPrimaryKey(long id) throws NoSuchSMSException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the sms
	 * @return the sms, or <code>null</code> if a sms with the primary key could not be found
	 */
	@Override
	public SMS fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the smses.
	 *
	 * @return the smses
	 */
	@Override
	public List<SMS> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of smses
	 */
	@Override
	public List<SMS> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smses
	 */
	@Override
	public List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smses
	 */
	@Override
	public List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator,
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

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMS;

				sql = sql.concat(SMSModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SMS>)QueryUtil.list(
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
	 * Removes all the smses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SMS sms : findAll()) {
			remove(sms);
		}
	}

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SMS);

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
		return _SQL_SELECT_SMS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SMSModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sms persistence.
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

		_finderPathWithPaginationFindByNumero = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumero",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"numero"}, true);

		_finderPathWithoutPaginationFindByNumero = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumero",
			new String[] {String.class.getName()}, new String[] {"numero"},
			true);

		_finderPathCountByNumero = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumero",
			new String[] {String.class.getName()}, new String[] {"numero"},
			false);

		_finderPathWithPaginationFindByNumeroDataAck = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumeroDataAck",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"numero", "dataAck"}, true);

		_finderPathWithoutPaginationFindByNumeroDataAck = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumeroDataAck",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"numero", "dataAck"}, true);

		_finderPathCountByNumeroDataAck = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumeroDataAck",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"numero", "dataAck"}, false);

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

		_finderPathWithPaginationFindByTimestamp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimestamp",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"timestamp"}, true);

		_finderPathWithoutPaginationFindByTimestamp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimestamp",
			new String[] {String.class.getName()}, new String[] {"timestamp"},
			true);

		_finderPathCountByTimestamp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimestamp",
			new String[] {String.class.getName()}, new String[] {"timestamp"},
			false);

		SMSUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SMSUtil.setPersistence(null);

		entityCache.removeCache(SMSImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_SMS = "SELECT sms FROM SMS sms";

	private static final String _SQL_SELECT_SMS_WHERE =
		"SELECT sms FROM SMS sms WHERE ";

	private static final String _SQL_COUNT_SMS =
		"SELECT COUNT(sms) FROM SMS sms";

	private static final String _SQL_COUNT_SMS_WHERE =
		"SELECT COUNT(sms) FROM SMS sms WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sms.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SMS exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SMS exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SMSPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}