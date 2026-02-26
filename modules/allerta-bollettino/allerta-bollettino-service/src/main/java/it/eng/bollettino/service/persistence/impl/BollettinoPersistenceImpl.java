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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.eng.bollettino.exception.NoSuchBollettinoException;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.model.BollettinoTable;
import it.eng.bollettino.model.impl.BollettinoImpl;
import it.eng.bollettino.model.impl.BollettinoModelImpl;
import it.eng.bollettino.service.persistence.BollettinoPersistence;
import it.eng.bollettino.service.persistence.BollettinoUtil;
import it.eng.bollettino.service.persistence.impl.constants.BOLLETTINOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the bollettino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = BollettinoPersistence.class)
public class BollettinoPersistenceImpl
	extends BasePersistenceImpl<Bollettino> implements BollettinoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoUtil</code> to access the bollettino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoImpl.class.getName();

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
	 * Returns all the bollettinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Bollettino> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Bollettino> orderByComparator,
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

		List<Bollettino> list = null;

		if (useFinderCache) {
			list = (List<Bollettino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Bollettino bollettino : list) {
					if (!uuid.equals(bollettino.getUuid())) {
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

			sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

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
				sb.append(BollettinoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Bollettino>)QueryUtil.list(
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
	 * Returns the first bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByUuid_First(
			String uuid, OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByUuid_First(uuid, orderByComparator);

		if (bollettino != null) {
			return bollettino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoException(sb.toString());
	}

	/**
	 * Returns the first bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByUuid_First(
		String uuid, OrderByComparator<Bollettino> orderByComparator) {

		List<Bollettino> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByUuid_Last(
			String uuid, OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByUuid_Last(uuid, orderByComparator);

		if (bollettino != null) {
			return bollettino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoException(sb.toString());
	}

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByUuid_Last(
		String uuid, OrderByComparator<Bollettino> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Bollettino> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettinos before and after the current bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param bollettinoId the primary key of the current bollettino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino[] findByUuid_PrevAndNext(
			long bollettinoId, String uuid,
			OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		uuid = Objects.toString(uuid, "");

		Bollettino bollettino = findByPrimaryKey(bollettinoId);

		Session session = null;

		try {
			session = openSession();

			Bollettino[] array = new BollettinoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bollettino, uuid, orderByComparator, true);

			array[1] = bollettino;

			array[2] = getByUuid_PrevAndNext(
				session, bollettino, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bollettino getByUuid_PrevAndNext(
		Session session, Bollettino bollettino, String uuid,
		OrderByComparator<Bollettino> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

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
			sb.append(BollettinoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bollettino)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Bollettino> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Bollettino bollettino :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettino);
		}
	}

	/**
	 * Returns the number of bollettinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettinos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINO_WHERE);

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
		"bollettino.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bollettino.uuid IS NULL OR bollettino.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the bollettino where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByUUID_G(String uuid, long groupId)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByUUID_G(uuid, groupId);

		if (bollettino == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBollettinoException(sb.toString());
		}

		return bollettino;
	}

	/**
	 * Returns the bollettino where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the bollettino where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Bollettino) {
			Bollettino bollettino = (Bollettino)result;

			if (!Objects.equals(uuid, bollettino.getUuid()) ||
				(groupId != bollettino.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Bollettino> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Bollettino bollettino = list.get(0);

					result = bollettino;

					cacheResult(bollettino);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Bollettino)result;
		}
	}

	/**
	 * Removes the bollettino where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bollettino that was removed
	 */
	@Override
	public Bollettino removeByUUID_G(String uuid, long groupId)
		throws NoSuchBollettinoException {

		Bollettino bollettino = findByUUID_G(uuid, groupId);

		return remove(bollettino);
	}

	/**
	 * Returns the number of bollettinos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bollettinos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Bollettino bollettino = fetchByUUID_G(uuid, groupId);

		if (bollettino == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"bollettino.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(bollettino.uuid IS NULL OR bollettino.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"bollettino.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Bollettino> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Bollettino> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Bollettino> list = null;

		if (useFinderCache) {
			list = (List<Bollettino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Bollettino bollettino : list) {
					if (!uuid.equals(bollettino.getUuid()) ||
						(companyId != bollettino.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BollettinoModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<Bollettino>)QueryUtil.list(
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
	 * Returns the first bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (bollettino != null) {
			return bollettino;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBollettinoException(sb.toString());
	}

	/**
	 * Returns the first bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Bollettino> orderByComparator) {

		List<Bollettino> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (bollettino != null) {
			return bollettino;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBollettinoException(sb.toString());
	}

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Bollettino> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Bollettino> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettinos before and after the current bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bollettinoId the primary key of the current bollettino
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino[] findByUuid_C_PrevAndNext(
			long bollettinoId, String uuid, long companyId,
			OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		uuid = Objects.toString(uuid, "");

		Bollettino bollettino = findByPrimaryKey(bollettinoId);

		Session session = null;

		try {
			session = openSession();

			Bollettino[] array = new BollettinoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, bollettino, uuid, companyId, orderByComparator, true);

			array[1] = bollettino;

			array[2] = getByUuid_C_PrevAndNext(
				session, bollettino, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bollettino getByUuid_C_PrevAndNext(
		Session session, Bollettino bollettino, String uuid, long companyId,
		OrderByComparator<Bollettino> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(BollettinoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bollettino)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Bollettino> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettinos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Bollettino bollettino :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bollettino);
		}
	}

	/**
	 * Returns the number of bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bollettinos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOLLETTINO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"bollettino.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(bollettino.uuid IS NULL OR bollettino.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"bollettino.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNumero;
	private FinderPath _finderPathWithoutPaginationFindByNumero;
	private FinderPath _finderPathCountByNumero;

	/**
	 * Returns all the bollettinos where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching bollettinos
	 */
	@Override
	public List<Bollettino> findByNumero(String numero) {
		return findByNumero(numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettinos where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByNumero(String numero, int start, int end) {
		return findByNumero(numero, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettinos where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByNumero(
		String numero, int start, int end,
		OrderByComparator<Bollettino> orderByComparator) {

		return findByNumero(numero, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettinos where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettinos
	 */
	@Override
	public List<Bollettino> findByNumero(
		String numero, int start, int end,
		OrderByComparator<Bollettino> orderByComparator,
		boolean useFinderCache) {

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

		List<Bollettino> list = null;

		if (useFinderCache) {
			list = (List<Bollettino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Bollettino bollettino : list) {
					if (!numero.equals(bollettino.getNumero())) {
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

			sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

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
				sb.append(BollettinoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Bollettino>)QueryUtil.list(
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
	 * Returns the first bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByNumero_First(
			String numero, OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByNumero_First(numero, orderByComparator);

		if (bollettino != null) {
			return bollettino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append("}");

		throw new NoSuchBollettinoException(sb.toString());
	}

	/**
	 * Returns the first bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByNumero_First(
		String numero, OrderByComparator<Bollettino> orderByComparator) {

		List<Bollettino> list = findByNumero(numero, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	@Override
	public Bollettino findByNumero_Last(
			String numero, OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByNumero_Last(numero, orderByComparator);

		if (bollettino != null) {
			return bollettino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append("}");

		throw new NoSuchBollettinoException(sb.toString());
	}

	/**
	 * Returns the last bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public Bollettino fetchByNumero_Last(
		String numero, OrderByComparator<Bollettino> orderByComparator) {

		int count = countByNumero(numero);

		if (count == 0) {
			return null;
		}

		List<Bollettino> list = findByNumero(
			numero, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettinos before and after the current bollettino in the ordered set where numero = &#63;.
	 *
	 * @param bollettinoId the primary key of the current bollettino
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino[] findByNumero_PrevAndNext(
			long bollettinoId, String numero,
			OrderByComparator<Bollettino> orderByComparator)
		throws NoSuchBollettinoException {

		numero = Objects.toString(numero, "");

		Bollettino bollettino = findByPrimaryKey(bollettinoId);

		Session session = null;

		try {
			session = openSession();

			Bollettino[] array = new BollettinoImpl[3];

			array[0] = getByNumero_PrevAndNext(
				session, bollettino, numero, orderByComparator, true);

			array[1] = bollettino;

			array[2] = getByNumero_PrevAndNext(
				session, bollettino, numero, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bollettino getByNumero_PrevAndNext(
		Session session, Bollettino bollettino, String numero,
		OrderByComparator<Bollettino> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOLLETTINO_WHERE);

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
			sb.append(BollettinoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bollettino)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Bollettino> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettinos where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	@Override
	public void removeByNumero(String numero) {
		for (Bollettino bollettino :
				findByNumero(
					numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettino);
		}
	}

	/**
	 * Returns the number of bollettinos where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching bollettinos
	 */
	@Override
	public int countByNumero(String numero) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumero;

		Object[] finderArgs = new Object[] {numero};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINO_WHERE);

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
		"bollettino.numero = ?";

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_3 =
		"(bollettino.numero IS NULL OR bollettino.numero = '')";

	public BollettinoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Bollettino.class);

		setModelImplClass(BollettinoImpl.class);
		setModelPKClass(long.class);

		setTable(BollettinoTable.INSTANCE);
	}

	/**
	 * Caches the bollettino in the entity cache if it is enabled.
	 *
	 * @param bollettino the bollettino
	 */
	@Override
	public void cacheResult(Bollettino bollettino) {
		entityCache.putResult(
			BollettinoImpl.class, bollettino.getPrimaryKey(), bollettino);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {bollettino.getUuid(), bollettino.getGroupId()},
			bollettino);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bollettinos in the entity cache if it is enabled.
	 *
	 * @param bollettinos the bollettinos
	 */
	@Override
	public void cacheResult(List<Bollettino> bollettinos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bollettinos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Bollettino bollettino : bollettinos) {
			if (entityCache.getResult(
					BollettinoImpl.class, bollettino.getPrimaryKey()) == null) {

				cacheResult(bollettino);
			}
		}
	}

	/**
	 * Clears the cache for all bollettinos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoImpl.class);

		finderCache.clearCache(BollettinoImpl.class);
	}

	/**
	 * Clears the cache for the bollettino.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bollettino bollettino) {
		entityCache.removeResult(BollettinoImpl.class, bollettino);
	}

	@Override
	public void clearCache(List<Bollettino> bollettinos) {
		for (Bollettino bollettino : bollettinos) {
			entityCache.removeResult(BollettinoImpl.class, bollettino);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BollettinoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BollettinoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BollettinoModelImpl bollettinoModelImpl) {

		Object[] args = new Object[] {
			bollettinoModelImpl.getUuid(), bollettinoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, bollettinoModelImpl);
	}

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param bollettinoId the primary key for the new bollettino
	 * @return the new bollettino
	 */
	@Override
	public Bollettino create(long bollettinoId) {
		Bollettino bollettino = new BollettinoImpl();

		bollettino.setNew(true);
		bollettino.setPrimaryKey(bollettinoId);

		String uuid = PortalUUIDUtil.generate();

		bollettino.setUuid(uuid);

		bollettino.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bollettino;
	}

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino remove(long bollettinoId)
		throws NoSuchBollettinoException {

		return remove((Serializable)bollettinoId);
	}

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino remove(Serializable primaryKey)
		throws NoSuchBollettinoException {

		Session session = null;

		try {
			session = openSession();

			Bollettino bollettino = (Bollettino)session.get(
				BollettinoImpl.class, primaryKey);

			if (bollettino == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettino);
		}
		catch (NoSuchBollettinoException noSuchEntityException) {
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
	protected Bollettino removeImpl(Bollettino bollettino) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettino)) {
				bollettino = (Bollettino)session.get(
					BollettinoImpl.class, bollettino.getPrimaryKeyObj());
			}

			if (bollettino != null) {
				session.delete(bollettino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bollettino != null) {
			clearCache(bollettino);
		}

		return bollettino;
	}

	@Override
	public Bollettino updateImpl(Bollettino bollettino) {
		boolean isNew = bollettino.isNew();

		if (!(bollettino instanceof BollettinoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettino.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bollettino);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettino proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Bollettino implementation " +
					bollettino.getClass());
		}

		BollettinoModelImpl bollettinoModelImpl =
			(BollettinoModelImpl)bollettino;

		if (Validator.isNull(bollettino.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bollettino.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (bollettino.getCreateDate() == null)) {
			if (serviceContext == null) {
				bollettino.setCreateDate(date);
			}
			else {
				bollettino.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bollettinoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bollettino.setModifiedDate(date);
			}
			else {
				bollettino.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bollettino);
			}
			else {
				bollettino = (Bollettino)session.merge(bollettino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BollettinoImpl.class, bollettinoModelImpl, false, true);

		cacheUniqueFindersCache(bollettinoModelImpl);

		if (isNew) {
			bollettino.setNew(false);
		}

		bollettino.resetOriginalValues();

		return bollettino;
	}

	/**
	 * Returns the bollettino with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoException {

		Bollettino bollettino = fetchByPrimaryKey(primaryKey);

		if (bollettino == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettino;
	}

	/**
	 * Returns the bollettino with the primary key or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino findByPrimaryKey(long bollettinoId)
		throws NoSuchBollettinoException {

		return findByPrimaryKey((Serializable)bollettinoId);
	}

	/**
	 * Returns the bollettino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	@Override
	public Bollettino fetchByPrimaryKey(long bollettinoId) {
		return fetchByPrimaryKey((Serializable)bollettinoId);
	}

	/**
	 * Returns all the bollettinos.
	 *
	 * @return the bollettinos
	 */
	@Override
	public List<Bollettino> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettinos
	 */
	@Override
	public List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator,
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

		List<Bollettino> list = null;

		if (useFinderCache) {
			list = (List<Bollettino>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOLLETTINO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINO;

				sql = sql.concat(BollettinoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Bollettino>)QueryUtil.list(
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
	 * Removes all the bollettinos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Bollettino bollettino : findAll()) {
			remove(bollettino);
		}
	}

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOLLETTINO);

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
		return "bollettinoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOLLETTINO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BollettinoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

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

		BollettinoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BollettinoUtil.setPersistence(null);

		entityCache.removeCache(BollettinoImpl.class.getName());
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

	private static final String _SQL_SELECT_BOLLETTINO =
		"SELECT bollettino FROM Bollettino bollettino";

	private static final String _SQL_SELECT_BOLLETTINO_WHERE =
		"SELECT bollettino FROM Bollettino bollettino WHERE ";

	private static final String _SQL_COUNT_BOLLETTINO =
		"SELECT COUNT(bollettino) FROM Bollettino bollettino";

	private static final String _SQL_COUNT_BOLLETTINO_WHERE =
		"SELECT COUNT(bollettino) FROM Bollettino bollettino WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettino.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Bollettino exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Bollettino exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}