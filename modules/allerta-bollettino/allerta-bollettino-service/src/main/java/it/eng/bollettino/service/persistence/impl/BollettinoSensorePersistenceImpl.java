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

import it.eng.bollettino.exception.NoSuchBollettinoSensoreException;
import it.eng.bollettino.model.BollettinoSensore;
import it.eng.bollettino.model.BollettinoSensoreTable;
import it.eng.bollettino.model.impl.BollettinoSensoreImpl;
import it.eng.bollettino.model.impl.BollettinoSensoreModelImpl;
import it.eng.bollettino.service.persistence.BollettinoSensorePersistence;
import it.eng.bollettino.service.persistence.BollettinoSensoreUtil;
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
 * The persistence implementation for the bollettino sensore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = BollettinoSensorePersistence.class)
public class BollettinoSensorePersistenceImpl
	extends BasePersistenceImpl<BollettinoSensore>
	implements BollettinoSensorePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoSensoreUtil</code> to access the bollettino sensore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoSensoreImpl.class.getName();

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
	 * Returns all the bollettino sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator,
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

		List<BollettinoSensore> list = null;

		if (useFinderCache) {
			list = (List<BollettinoSensore>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoSensore bollettinoSensore : list) {
					if (!uuid.equals(bollettinoSensore.getUuid())) {
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

			sb.append(_SQL_SELECT_BOLLETTINOSENSORE_WHERE);

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
				sb.append(BollettinoSensoreModelImpl.ORDER_BY_JPQL);
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

				list = (List<BollettinoSensore>)QueryUtil.list(
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
	 * Returns the first bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore findByUuid_First(
			String uuid, OrderByComparator<BollettinoSensore> orderByComparator)
		throws NoSuchBollettinoSensoreException {

		BollettinoSensore bollettinoSensore = fetchByUuid_First(
			uuid, orderByComparator);

		if (bollettinoSensore != null) {
			return bollettinoSensore;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoSensoreException(sb.toString());
	}

	/**
	 * Returns the first bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoSensore> orderByComparator) {

		List<BollettinoSensore> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore findByUuid_Last(
			String uuid, OrderByComparator<BollettinoSensore> orderByComparator)
		throws NoSuchBollettinoSensoreException {

		BollettinoSensore bollettinoSensore = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bollettinoSensore != null) {
			return bollettinoSensore;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoSensoreException(sb.toString());
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoSensore> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BollettinoSensore> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino sensores before and after the current bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws NoSuchBollettinoSensoreException {

		uuid = Objects.toString(uuid, "");

		BollettinoSensore bollettinoSensore = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoSensore[] array = new BollettinoSensoreImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bollettinoSensore, uuid, orderByComparator, true);

			array[1] = bollettinoSensore;

			array[2] = getByUuid_PrevAndNext(
				session, bollettinoSensore, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BollettinoSensore getByUuid_PrevAndNext(
		Session session, BollettinoSensore bollettinoSensore, String uuid,
		OrderByComparator<BollettinoSensore> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOLLETTINOSENSORE_WHERE);

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
			sb.append(BollettinoSensoreModelImpl.ORDER_BY_JPQL);
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
						bollettinoSensore)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BollettinoSensore> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BollettinoSensore bollettinoSensore :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoSensore);
		}
	}

	/**
	 * Returns the number of bollettino sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino sensores
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINOSENSORE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"bollettinoSensore.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bollettinoSensore.uuid IS NULL OR bollettinoSensore.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByBollettino;
	private FinderPath _finderPathWithoutPaginationFindByBollettino;
	private FinderPath _finderPathCountByBollettino;

	/**
	 * Returns all the bollettino sensores where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByBollettino(long idBollettino) {
		return findByBollettino(
			idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end) {

		return findByBollettino(idBollettino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return findByBollettino(
			idBollettino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBollettino;
				finderArgs = new Object[] {idBollettino};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBollettino;
			finderArgs = new Object[] {
				idBollettino, start, end, orderByComparator
			};
		}

		List<BollettinoSensore> list = null;

		if (useFinderCache) {
			list = (List<BollettinoSensore>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoSensore bollettinoSensore : list) {
					if (idBollettino != bollettinoSensore.getIdBollettino()) {
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

			sb.append(_SQL_SELECT_BOLLETTINOSENSORE_WHERE);

			sb.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BollettinoSensoreModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idBollettino);

				list = (List<BollettinoSensore>)QueryUtil.list(
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
	 * Returns the first bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws NoSuchBollettinoSensoreException {

		BollettinoSensore bollettinoSensore = fetchByBollettino_First(
			idBollettino, orderByComparator);

		if (bollettinoSensore != null) {
			return bollettinoSensore;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBollettino=");
		sb.append(idBollettino);

		sb.append("}");

		throw new NoSuchBollettinoSensoreException(sb.toString());
	}

	/**
	 * Returns the first bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		List<BollettinoSensore> list = findByBollettino(
			idBollettino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws NoSuchBollettinoSensoreException {

		BollettinoSensore bollettinoSensore = fetchByBollettino_Last(
			idBollettino, orderByComparator);

		if (bollettinoSensore != null) {
			return bollettinoSensore;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBollettino=");
		sb.append(idBollettino);

		sb.append("}");

		throw new NoSuchBollettinoSensoreException(sb.toString());
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	@Override
	public BollettinoSensore fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		int count = countByBollettino(idBollettino);

		if (count == 0) {
			return null;
		}

		List<BollettinoSensore> list = findByBollettino(
			idBollettino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino sensores before and after the current bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino sensore
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws NoSuchBollettinoSensoreException {

		BollettinoSensore bollettinoSensore = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoSensore[] array = new BollettinoSensoreImpl[3];

			array[0] = getByBollettino_PrevAndNext(
				session, bollettinoSensore, idBollettino, orderByComparator,
				true);

			array[1] = bollettinoSensore;

			array[2] = getByBollettino_PrevAndNext(
				session, bollettinoSensore, idBollettino, orderByComparator,
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

	protected BollettinoSensore getByBollettino_PrevAndNext(
		Session session, BollettinoSensore bollettinoSensore, long idBollettino,
		OrderByComparator<BollettinoSensore> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOLLETTINOSENSORE_WHERE);

		sb.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

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
			sb.append(BollettinoSensoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(idBollettino);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bollettinoSensore)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BollettinoSensore> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino sensores where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	@Override
	public void removeByBollettino(long idBollettino) {
		for (BollettinoSensore bollettinoSensore :
				findByBollettino(
					idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoSensore);
		}
	}

	/**
	 * Returns the number of bollettino sensores where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino sensores
	 */
	@Override
	public int countByBollettino(long idBollettino) {
		FinderPath finderPath = _finderPathCountByBollettino;

		Object[] finderArgs = new Object[] {idBollettino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINOSENSORE_WHERE);

			sb.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idBollettino);

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

	private static final String _FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2 =
		"bollettinoSensore.idBollettino = ?";

	public BollettinoSensorePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BollettinoSensore.class);

		setModelImplClass(BollettinoSensoreImpl.class);
		setModelPKClass(long.class);

		setTable(BollettinoSensoreTable.INSTANCE);
	}

	/**
	 * Caches the bollettino sensore in the entity cache if it is enabled.
	 *
	 * @param bollettinoSensore the bollettino sensore
	 */
	@Override
	public void cacheResult(BollettinoSensore bollettinoSensore) {
		entityCache.putResult(
			BollettinoSensoreImpl.class, bollettinoSensore.getPrimaryKey(),
			bollettinoSensore);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bollettino sensores in the entity cache if it is enabled.
	 *
	 * @param bollettinoSensores the bollettino sensores
	 */
	@Override
	public void cacheResult(List<BollettinoSensore> bollettinoSensores) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bollettinoSensores.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BollettinoSensore bollettinoSensore : bollettinoSensores) {
			if (entityCache.getResult(
					BollettinoSensoreImpl.class,
					bollettinoSensore.getPrimaryKey()) == null) {

				cacheResult(bollettinoSensore);
			}
		}
	}

	/**
	 * Clears the cache for all bollettino sensores.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoSensoreImpl.class);

		finderCache.clearCache(BollettinoSensoreImpl.class);
	}

	/**
	 * Clears the cache for the bollettino sensore.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoSensore bollettinoSensore) {
		entityCache.removeResult(
			BollettinoSensoreImpl.class, bollettinoSensore);
	}

	@Override
	public void clearCache(List<BollettinoSensore> bollettinoSensores) {
		for (BollettinoSensore bollettinoSensore : bollettinoSensores) {
			entityCache.removeResult(
				BollettinoSensoreImpl.class, bollettinoSensore);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BollettinoSensoreImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BollettinoSensoreImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bollettino sensore with the primary key. Does not add the bollettino sensore to the database.
	 *
	 * @param id the primary key for the new bollettino sensore
	 * @return the new bollettino sensore
	 */
	@Override
	public BollettinoSensore create(long id) {
		BollettinoSensore bollettinoSensore = new BollettinoSensoreImpl();

		bollettinoSensore.setNew(true);
		bollettinoSensore.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		bollettinoSensore.setUuid(uuid);

		return bollettinoSensore;
	}

	/**
	 * Removes the bollettino sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore that was removed
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore remove(long id)
		throws NoSuchBollettinoSensoreException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the bollettino sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino sensore
	 * @return the bollettino sensore that was removed
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore remove(Serializable primaryKey)
		throws NoSuchBollettinoSensoreException {

		Session session = null;

		try {
			session = openSession();

			BollettinoSensore bollettinoSensore =
				(BollettinoSensore)session.get(
					BollettinoSensoreImpl.class, primaryKey);

			if (bollettinoSensore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoSensoreException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoSensore);
		}
		catch (NoSuchBollettinoSensoreException noSuchEntityException) {
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
	protected BollettinoSensore removeImpl(
		BollettinoSensore bollettinoSensore) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoSensore)) {
				bollettinoSensore = (BollettinoSensore)session.get(
					BollettinoSensoreImpl.class,
					bollettinoSensore.getPrimaryKeyObj());
			}

			if (bollettinoSensore != null) {
				session.delete(bollettinoSensore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoSensore != null) {
			clearCache(bollettinoSensore);
		}

		return bollettinoSensore;
	}

	@Override
	public BollettinoSensore updateImpl(BollettinoSensore bollettinoSensore) {
		boolean isNew = bollettinoSensore.isNew();

		if (!(bollettinoSensore instanceof BollettinoSensoreModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettinoSensore.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bollettinoSensore);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettinoSensore proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BollettinoSensore implementation " +
					bollettinoSensore.getClass());
		}

		BollettinoSensoreModelImpl bollettinoSensoreModelImpl =
			(BollettinoSensoreModelImpl)bollettinoSensore;

		if (Validator.isNull(bollettinoSensore.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bollettinoSensore.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bollettinoSensore);
			}
			else {
				bollettinoSensore = (BollettinoSensore)session.merge(
					bollettinoSensore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BollettinoSensoreImpl.class, bollettinoSensoreModelImpl, false,
			true);

		if (isNew) {
			bollettinoSensore.setNew(false);
		}

		bollettinoSensore.resetOriginalValues();

		return bollettinoSensore;
	}

	/**
	 * Returns the bollettino sensore with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino sensore
	 * @return the bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoSensoreException {

		BollettinoSensore bollettinoSensore = fetchByPrimaryKey(primaryKey);

		if (bollettinoSensore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoSensoreException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoSensore;
	}

	/**
	 * Returns the bollettino sensore with the primary key or throws a <code>NoSuchBollettinoSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore findByPrimaryKey(long id)
		throws NoSuchBollettinoSensoreException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bollettino sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore, or <code>null</code> if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public BollettinoSensore fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the bollettino sensores.
	 *
	 * @return the bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findAll(
		int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettino sensores
	 */
	@Override
	public List<BollettinoSensore> findAll(
		int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator,
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

		List<BollettinoSensore> list = null;

		if (useFinderCache) {
			list = (List<BollettinoSensore>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOLLETTINOSENSORE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOSENSORE;

				sql = sql.concat(BollettinoSensoreModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BollettinoSensore>)QueryUtil.list(
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
	 * Removes all the bollettino sensores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoSensore bollettinoSensore : findAll()) {
			remove(bollettinoSensore);
		}
	}

	/**
	 * Returns the number of bollettino sensores.
	 *
	 * @return the number of bollettino sensores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOLLETTINOSENSORE);

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
		return _SQL_SELECT_BOLLETTINOSENSORE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BollettinoSensoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino sensore persistence.
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

		_finderPathWithPaginationFindByBollettino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBollettino",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idBollettino"}, true);

		_finderPathWithoutPaginationFindByBollettino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBollettino",
			new String[] {Long.class.getName()}, new String[] {"idBollettino"},
			true);

		_finderPathCountByBollettino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBollettino",
			new String[] {Long.class.getName()}, new String[] {"idBollettino"},
			false);

		BollettinoSensoreUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BollettinoSensoreUtil.setPersistence(null);

		entityCache.removeCache(BollettinoSensoreImpl.class.getName());
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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOLLETTINOSENSORE =
		"SELECT bollettinoSensore FROM BollettinoSensore bollettinoSensore";

	private static final String _SQL_SELECT_BOLLETTINOSENSORE_WHERE =
		"SELECT bollettinoSensore FROM BollettinoSensore bollettinoSensore WHERE ";

	private static final String _SQL_COUNT_BOLLETTINOSENSORE =
		"SELECT COUNT(bollettinoSensore) FROM BollettinoSensore bollettinoSensore";

	private static final String _SQL_COUNT_BOLLETTINOSENSORE_WHERE =
		"SELECT COUNT(bollettinoSensore) FROM BollettinoSensore bollettinoSensore WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoSensore.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoSensore exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BollettinoSensore exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoSensorePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}