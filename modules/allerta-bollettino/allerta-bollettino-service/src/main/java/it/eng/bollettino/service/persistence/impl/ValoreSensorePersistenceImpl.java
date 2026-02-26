/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.eng.bollettino.exception.NoSuchValoreSensoreException;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.model.ValoreSensoreTable;
import it.eng.bollettino.model.impl.ValoreSensoreImpl;
import it.eng.bollettino.model.impl.ValoreSensoreModelImpl;
import it.eng.bollettino.service.persistence.ValoreSensorePersistence;
import it.eng.bollettino.service.persistence.ValoreSensoreUtil;
import it.eng.bollettino.service.persistence.impl.constants.BOLLETTINOPersistenceConstants;

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
 * The persistence implementation for the valore sensore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = ValoreSensorePersistence.class)
public class ValoreSensorePersistenceImpl
	extends BasePersistenceImpl<ValoreSensore>
	implements ValoreSensorePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ValoreSensoreUtil</code> to access the valore sensore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ValoreSensoreImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ValoreSensore> list = null;

		if (useFinderCache) {
			list = (List<ValoreSensore>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValoreSensore valoreSensore : list) {
					if (!uuid.equals(valoreSensore.getUuid())) {
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

			sb.append(_SQL_SELECT_VALORESENSORE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ValoreSensore>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByUuid_First(
			String uuid, OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByUuid_First(
			uuid, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchValoreSensoreException(sb.toString());
	}

	/**
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByUuid_First(
		String uuid, OrderByComparator<ValoreSensore> orderByComparator) {

		List<ValoreSensore> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByUuid_Last(
			String uuid, OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByUuid_Last(uuid, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchValoreSensoreException(sb.toString());
	}

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByUuid_Last(
		String uuid, OrderByComparator<ValoreSensore> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ValoreSensore> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		uuid = Objects.toString(uuid, "");

		ValoreSensore valoreSensore = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValoreSensore[] array = new ValoreSensoreImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, valoreSensore, uuid, orderByComparator, true);

			array[1] = valoreSensore;

			array[2] = getByUuid_PrevAndNext(
				session, valoreSensore, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ValoreSensore getByUuid_PrevAndNext(
		Session session, ValoreSensore valoreSensore, String uuid,
		OrderByComparator<ValoreSensore> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VALORESENSORE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						valoreSensore)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValoreSensore> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the valore sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ValoreSensore valoreSensore :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(valoreSensore);
		}
	}

	/**
	 * Returns the number of valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching valore sensores
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VALORESENSORE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"valoreSensore.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(valoreSensore.uuid IS NULL OR valoreSensore.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByvariabileStazione;
	private FinderPath _finderPathWithoutPaginationFindByvariabileStazione;
	private FinderPath _finderPathCountByvariabileStazione;

	/**
	 * Returns all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione) {

		return findByvariabileStazione(
			idVariabile, idStazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end) {

		return findByvariabileStazione(
			idVariabile, idStazione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return findByvariabileStazione(
			idVariabile, idStazione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	@Override
	public List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator,
		boolean useFinderCache) {

		idVariabile = Objects.toString(idVariabile, "");
		idStazione = Objects.toString(idStazione, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByvariabileStazione;
				finderArgs = new Object[] {idVariabile, idStazione};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByvariabileStazione;
			finderArgs = new Object[] {
				idVariabile, idStazione, start, end, orderByComparator
			};
		}

		List<ValoreSensore> list = null;

		if (useFinderCache) {
			list = (List<ValoreSensore>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValoreSensore valoreSensore : list) {
					if (!idVariabile.equals(valoreSensore.getIdVariabile()) ||
						!idStazione.equals(valoreSensore.getIdStazione())) {

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

			sb.append(_SQL_SELECT_VALORESENSORE_WHERE);

			boolean bindIdVariabile = false;

			if (idVariabile.isEmpty()) {
				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3);
			}
			else {
				bindIdVariabile = true;

				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2);
			}

			boolean bindIdStazione = false;

			if (idStazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3);
			}
			else {
				bindIdStazione = true;

				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdVariabile) {
					queryPos.add(idVariabile);
				}

				if (bindIdStazione) {
					queryPos.add(idStazione);
				}

				list = (List<ValoreSensore>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByvariabileStazione_First(
			String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByvariabileStazione_First(
			idVariabile, idStazione, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idVariabile=");
		sb.append(idVariabile);

		sb.append(", idStazione=");
		sb.append(idStazione);

		sb.append("}");

		throw new NoSuchValoreSensoreException(sb.toString());
	}

	/**
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByvariabileStazione_First(
		String idVariabile, String idStazione,
		OrderByComparator<ValoreSensore> orderByComparator) {

		List<ValoreSensore> list = findByvariabileStazione(
			idVariabile, idStazione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore findByvariabileStazione_Last(
			String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByvariabileStazione_Last(
			idVariabile, idStazione, orderByComparator);

		if (valoreSensore != null) {
			return valoreSensore;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idVariabile=");
		sb.append(idVariabile);

		sb.append(", idStazione=");
		sb.append(idStazione);

		sb.append("}");

		throw new NoSuchValoreSensoreException(sb.toString());
	}

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	@Override
	public ValoreSensore fetchByvariabileStazione_Last(
		String idVariabile, String idStazione,
		OrderByComparator<ValoreSensore> orderByComparator) {

		int count = countByvariabileStazione(idVariabile, idStazione);

		if (count == 0) {
			return null;
		}

		List<ValoreSensore> list = findByvariabileStazione(
			idVariabile, idStazione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore[] findByvariabileStazione_PrevAndNext(
			long id, String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws NoSuchValoreSensoreException {

		idVariabile = Objects.toString(idVariabile, "");
		idStazione = Objects.toString(idStazione, "");

		ValoreSensore valoreSensore = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValoreSensore[] array = new ValoreSensoreImpl[3];

			array[0] = getByvariabileStazione_PrevAndNext(
				session, valoreSensore, idVariabile, idStazione,
				orderByComparator, true);

			array[1] = valoreSensore;

			array[2] = getByvariabileStazione_PrevAndNext(
				session, valoreSensore, idVariabile, idStazione,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ValoreSensore getByvariabileStazione_PrevAndNext(
		Session session, ValoreSensore valoreSensore, String idVariabile,
		String idStazione, OrderByComparator<ValoreSensore> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VALORESENSORE_WHERE);

		boolean bindIdVariabile = false;

		if (idVariabile.isEmpty()) {
			sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3);
		}
		else {
			bindIdVariabile = true;

			sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2);
		}

		boolean bindIdStazione = false;

		if (idStazione.isEmpty()) {
			sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3);
		}
		else {
			bindIdStazione = true;

			sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2);
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
			sb.append(ValoreSensoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdVariabile) {
			queryPos.add(idVariabile);
		}

		if (bindIdStazione) {
			queryPos.add(idStazione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						valoreSensore)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValoreSensore> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the valore sensores where idVariabile = &#63; and idStazione = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 */
	@Override
	public void removeByvariabileStazione(
		String idVariabile, String idStazione) {

		for (ValoreSensore valoreSensore :
				findByvariabileStazione(
					idVariabile, idStazione, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(valoreSensore);
		}
	}

	/**
	 * Returns the number of valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the number of matching valore sensores
	 */
	@Override
	public int countByvariabileStazione(String idVariabile, String idStazione) {
		idVariabile = Objects.toString(idVariabile, "");
		idStazione = Objects.toString(idStazione, "");

		FinderPath finderPath = _finderPathCountByvariabileStazione;

		Object[] finderArgs = new Object[] {idVariabile, idStazione};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VALORESENSORE_WHERE);

			boolean bindIdVariabile = false;

			if (idVariabile.isEmpty()) {
				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3);
			}
			else {
				bindIdVariabile = true;

				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2);
			}

			boolean bindIdStazione = false;

			if (idStazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3);
			}
			else {
				bindIdStazione = true;

				sb.append(_FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdVariabile) {
					queryPos.add(idVariabile);
				}

				if (bindIdStazione) {
					queryPos.add(idStazione);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_2 =
		"valoreSensore.idVariabile = ? AND ";

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDVARIABILE_3 =
		"(valoreSensore.idVariabile IS NULL OR valoreSensore.idVariabile = '') AND ";

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_2 =
		"valoreSensore.idStazione = ?";

	private static final String _FINDER_COLUMN_VARIABILESTAZIONE_IDSTAZIONE_3 =
		"(valoreSensore.idStazione IS NULL OR valoreSensore.idStazione = '')";

	public ValoreSensorePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ValoreSensore.class);

		setModelImplClass(ValoreSensoreImpl.class);
		setModelPKClass(long.class);

		setTable(ValoreSensoreTable.INSTANCE);
	}

	/**
	 * Caches the valore sensore in the entity cache if it is enabled.
	 *
	 * @param valoreSensore the valore sensore
	 */
	@Override
	public void cacheResult(ValoreSensore valoreSensore) {
		dummyEntityCache.putResult(
			ValoreSensoreImpl.class, valoreSensore.getPrimaryKey(),
			valoreSensore);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the valore sensores in the entity cache if it is enabled.
	 *
	 * @param valoreSensores the valore sensores
	 */
	@Override
	public void cacheResult(List<ValoreSensore> valoreSensores) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (valoreSensores.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ValoreSensore valoreSensore : valoreSensores) {
			if (dummyEntityCache.getResult(
					ValoreSensoreImpl.class, valoreSensore.getPrimaryKey()) ==
						null) {

				cacheResult(valoreSensore);
			}
		}
	}

	/**
	 * Clears the cache for all valore sensores.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ValoreSensoreImpl.class);

		dummyFinderCache.clearCache(ValoreSensoreImpl.class);
	}

	/**
	 * Clears the cache for the valore sensore.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ValoreSensore valoreSensore) {
		dummyEntityCache.removeResult(ValoreSensoreImpl.class, valoreSensore);
	}

	@Override
	public void clearCache(List<ValoreSensore> valoreSensores) {
		for (ValoreSensore valoreSensore : valoreSensores) {
			dummyEntityCache.removeResult(
				ValoreSensoreImpl.class, valoreSensore);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ValoreSensoreImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ValoreSensoreImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new valore sensore with the primary key. Does not add the valore sensore to the database.
	 *
	 * @param id the primary key for the new valore sensore
	 * @return the new valore sensore
	 */
	@Override
	public ValoreSensore create(long id) {
		ValoreSensore valoreSensore = new ValoreSensoreImpl();

		valoreSensore.setNew(true);
		valoreSensore.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		valoreSensore.setUuid(uuid);

		return valoreSensore;
	}

	/**
	 * Removes the valore sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore that was removed
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore remove(long id) throws NoSuchValoreSensoreException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the valore sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the valore sensore
	 * @return the valore sensore that was removed
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore remove(Serializable primaryKey)
		throws NoSuchValoreSensoreException {

		Session session = null;

		try {
			session = openSession();

			ValoreSensore valoreSensore = (ValoreSensore)session.get(
				ValoreSensoreImpl.class, primaryKey);

			if (valoreSensore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchValoreSensoreException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(valoreSensore);
		}
		catch (NoSuchValoreSensoreException noSuchEntityException) {
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
	protected ValoreSensore removeImpl(ValoreSensore valoreSensore) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(valoreSensore)) {
				valoreSensore = (ValoreSensore)session.get(
					ValoreSensoreImpl.class, valoreSensore.getPrimaryKeyObj());
			}

			if (valoreSensore != null) {
				session.delete(valoreSensore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (valoreSensore != null) {
			clearCache(valoreSensore);
		}

		return valoreSensore;
	}

	@Override
	public ValoreSensore updateImpl(ValoreSensore valoreSensore) {
		boolean isNew = valoreSensore.isNew();

		if (!(valoreSensore instanceof ValoreSensoreModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(valoreSensore.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					valoreSensore);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in valoreSensore proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ValoreSensore implementation " +
					valoreSensore.getClass());
		}

		ValoreSensoreModelImpl valoreSensoreModelImpl =
			(ValoreSensoreModelImpl)valoreSensore;

		if (Validator.isNull(valoreSensore.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			valoreSensore.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(valoreSensore);
			}
			else {
				valoreSensore = (ValoreSensore)session.merge(valoreSensore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ValoreSensoreImpl.class, valoreSensoreModelImpl, false, true);

		if (isNew) {
			valoreSensore.setNew(false);
		}

		valoreSensore.resetOriginalValues();

		return valoreSensore;
	}

	/**
	 * Returns the valore sensore with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the valore sensore
	 * @return the valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchValoreSensoreException {

		ValoreSensore valoreSensore = fetchByPrimaryKey(primaryKey);

		if (valoreSensore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchValoreSensoreException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return valoreSensore;
	}

	/**
	 * Returns the valore sensore with the primary key or throws a <code>NoSuchValoreSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore findByPrimaryKey(long id)
		throws NoSuchValoreSensoreException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the valore sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore, or <code>null</code> if a valore sensore with the primary key could not be found
	 */
	@Override
	public ValoreSensore fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the valore sensores.
	 *
	 * @return the valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll(
		int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of valore sensores
	 */
	@Override
	public List<ValoreSensore> findAll(
		int start, int end, OrderByComparator<ValoreSensore> orderByComparator,
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

		List<ValoreSensore> list = null;

		if (useFinderCache) {
			list = (List<ValoreSensore>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VALORESENSORE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VALORESENSORE;

				sql = sql.concat(ValoreSensoreModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ValoreSensore>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the valore sensores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ValoreSensore valoreSensore : findAll()) {
			remove(valoreSensore);
		}
	}

	/**
	 * Returns the number of valore sensores.
	 *
	 * @return the number of valore sensores
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VALORESENSORE);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
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
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VALORESENSORE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ValoreSensoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the valore sensore persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByvariabileStazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByvariabileStazione",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"idVariabile", "idStazione"}, true);

		_finderPathWithoutPaginationFindByvariabileStazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByvariabileStazione",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"idVariabile", "idStazione"}, true);

		_finderPathCountByvariabileStazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByvariabileStazione",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"idVariabile", "idStazione"}, false);

		ValoreSensoreUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ValoreSensoreUtil.setPersistence(null);

		dummyEntityCache.removeCache(ValoreSensoreImpl.class.getName());
	}

	@Override
	@Reference(
		target = BOLLETTINOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BOLLETTINOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BOLLETTINOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_VALORESENSORE =
		"SELECT valoreSensore FROM ValoreSensore valoreSensore";

	private static final String _SQL_SELECT_VALORESENSORE_WHERE =
		"SELECT valoreSensore FROM ValoreSensore valoreSensore WHERE ";

	private static final String _SQL_COUNT_VALORESENSORE =
		"SELECT COUNT(valoreSensore) FROM ValoreSensore valoreSensore";

	private static final String _SQL_COUNT_VALORESENSORE_WHERE =
		"SELECT COUNT(valoreSensore) FROM ValoreSensore valoreSensore WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "valoreSensore.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ValoreSensore exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ValoreSensore exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ValoreSensorePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}