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

import it.eng.bollettino.exception.NoSuchAllarmeException;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.AllarmeTable;
import it.eng.bollettino.model.impl.AllarmeImpl;
import it.eng.bollettino.model.impl.AllarmeModelImpl;
import it.eng.bollettino.service.persistence.AllarmePersistence;
import it.eng.bollettino.service.persistence.AllarmeUtil;
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
 * The persistence implementation for the allarme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = AllarmePersistence.class)
public class AllarmePersistenceImpl
	extends BasePersistenceImpl<Allarme> implements AllarmePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllarmeUtil</code> to access the allarme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllarmeImpl.class.getName();

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
	 * Returns all the allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Allarme> orderByComparator, boolean useFinderCache) {

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

		List<Allarme> list = null;

		if (useFinderCache) {
			list = (List<Allarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Allarme allarme : list) {
					if (!uuid.equals(allarme.getUuid())) {
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

			sb.append(_SQL_SELECT_ALLARME_WHERE);

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
				sb.append(AllarmeModelImpl.ORDER_BY_JPQL);
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

				list = (List<Allarme>)QueryUtil.list(
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
	 * Returns the first allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByUuid_First(
			String uuid, OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByUuid_First(uuid, orderByComparator);

		if (allarme != null) {
			return allarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllarmeException(sb.toString());
	}

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByUuid_First(
		String uuid, OrderByComparator<Allarme> orderByComparator) {

		List<Allarme> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByUuid_Last(
			String uuid, OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByUuid_Last(uuid, orderByComparator);

		if (allarme != null) {
			return allarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllarmeException(sb.toString());
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByUuid_Last(
		String uuid, OrderByComparator<Allarme> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Allarme> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where uuid = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme[] findByUuid_PrevAndNext(
			long allarmeId, String uuid,
			OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		uuid = Objects.toString(uuid, "");

		Allarme allarme = findByPrimaryKey(allarmeId);

		Session session = null;

		try {
			session = openSession();

			Allarme[] array = new AllarmeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, allarme, uuid, orderByComparator, true);

			array[1] = allarme;

			array[2] = getByUuid_PrevAndNext(
				session, allarme, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Allarme getByUuid_PrevAndNext(
		Session session, Allarme allarme, String uuid,
		OrderByComparator<Allarme> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLARME_WHERE);

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
			sb.append(AllarmeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allarme)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Allarme> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Allarme allarme :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allarme);
		}
	}

	/**
	 * Returns the number of allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allarmes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLARME_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "allarme.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(allarme.uuid IS NULL OR allarme.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllarmeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByUUID_G(String uuid, long groupId)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByUUID_G(uuid, groupId);

		if (allarme == null) {
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

			throw new NoSuchAllarmeException(sb.toString());
		}

		return allarme;
	}

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByUUID_G(
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

		if (result instanceof Allarme) {
			Allarme allarme = (Allarme)result;

			if (!Objects.equals(uuid, allarme.getUuid()) ||
				(groupId != allarme.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ALLARME_WHERE);

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

				List<Allarme> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Allarme allarme = list.get(0);

					result = allarme;

					cacheResult(allarme);
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
			return (Allarme)result;
		}
	}

	/**
	 * Removes the allarme where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allarme that was removed
	 */
	@Override
	public Allarme removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllarmeException {

		Allarme allarme = findByUUID_G(uuid, groupId);

		return remove(allarme);
	}

	/**
	 * Returns the number of allarmes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allarmes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Allarme allarme = fetchByUUID_G(uuid, groupId);

		if (allarme == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"allarme.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(allarme.uuid IS NULL OR allarme.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"allarme.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	@Override
	public List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allarme> orderByComparator, boolean useFinderCache) {

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

		List<Allarme> list = null;

		if (useFinderCache) {
			list = (List<Allarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Allarme allarme : list) {
					if (!uuid.equals(allarme.getUuid()) ||
						(companyId != allarme.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ALLARME_WHERE);

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
				sb.append(AllarmeModelImpl.ORDER_BY_JPQL);
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

				list = (List<Allarme>)QueryUtil.list(
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
	 * Returns the first allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (allarme != null) {
			return allarme;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllarmeException(sb.toString());
	}

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Allarme> orderByComparator) {

		List<Allarme> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (allarme != null) {
			return allarme;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllarmeException(sb.toString());
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Allarme> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Allarme> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme[] findByUuid_C_PrevAndNext(
			long allarmeId, String uuid, long companyId,
			OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		uuid = Objects.toString(uuid, "");

		Allarme allarme = findByPrimaryKey(allarmeId);

		Session session = null;

		try {
			session = openSession();

			Allarme[] array = new AllarmeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, allarme, uuid, companyId, orderByComparator, true);

			array[1] = allarme;

			array[2] = getByUuid_C_PrevAndNext(
				session, allarme, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Allarme getByUuid_C_PrevAndNext(
		Session session, Allarme allarme, String uuid, long companyId,
		OrderByComparator<Allarme> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ALLARME_WHERE);

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
			sb.append(AllarmeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allarme)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Allarme> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allarmes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Allarme allarme :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allarme);
		}
	}

	/**
	 * Returns the number of allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allarmes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLARME_WHERE);

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
		"allarme.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(allarme.uuid IS NULL OR allarme.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"allarme.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRegola;
	private FinderPath _finderPathWithoutPaginationFindByRegola;
	private FinderPath _finderPathCountByRegola;

	/**
	 * Returns all the allarmes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching allarmes
	 */
	@Override
	public List<Allarme> findByRegola(long idRegola) {
		return findByRegola(
			idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	@Override
	public List<Allarme> findByRegola(long idRegola, int start, int end) {
		return findByRegola(idRegola, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	@Override
	public List<Allarme> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return findByRegola(idRegola, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	@Override
	public List<Allarme> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<Allarme> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRegola;
				finderArgs = new Object[] {idRegola};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRegola;
			finderArgs = new Object[] {idRegola, start, end, orderByComparator};
		}

		List<Allarme> list = null;

		if (useFinderCache) {
			list = (List<Allarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Allarme allarme : list) {
					if (idRegola != allarme.getIdRegola()) {
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

			sb.append(_SQL_SELECT_ALLARME_WHERE);

			sb.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllarmeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idRegola);

				list = (List<Allarme>)QueryUtil.list(
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
	 * Returns the first allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByRegola_First(
			long idRegola, OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByRegola_First(idRegola, orderByComparator);

		if (allarme != null) {
			return allarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegola=");
		sb.append(idRegola);

		sb.append("}");

		throw new NoSuchAllarmeException(sb.toString());
	}

	/**
	 * Returns the first allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByRegola_First(
		long idRegola, OrderByComparator<Allarme> orderByComparator) {

		List<Allarme> list = findByRegola(idRegola, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	@Override
	public Allarme findByRegola_Last(
			long idRegola, OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByRegola_Last(idRegola, orderByComparator);

		if (allarme != null) {
			return allarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegola=");
		sb.append(idRegola);

		sb.append("}");

		throw new NoSuchAllarmeException(sb.toString());
	}

	/**
	 * Returns the last allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public Allarme fetchByRegola_Last(
		long idRegola, OrderByComparator<Allarme> orderByComparator) {

		int count = countByRegola(idRegola);

		if (count == 0) {
			return null;
		}

		List<Allarme> list = findByRegola(
			idRegola, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme[] findByRegola_PrevAndNext(
			long allarmeId, long idRegola,
			OrderByComparator<Allarme> orderByComparator)
		throws NoSuchAllarmeException {

		Allarme allarme = findByPrimaryKey(allarmeId);

		Session session = null;

		try {
			session = openSession();

			Allarme[] array = new AllarmeImpl[3];

			array[0] = getByRegola_PrevAndNext(
				session, allarme, idRegola, orderByComparator, true);

			array[1] = allarme;

			array[2] = getByRegola_PrevAndNext(
				session, allarme, idRegola, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Allarme getByRegola_PrevAndNext(
		Session session, Allarme allarme, long idRegola,
		OrderByComparator<Allarme> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLARME_WHERE);

		sb.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

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
			sb.append(AllarmeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(idRegola);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(allarme)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Allarme> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allarmes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	@Override
	public void removeByRegola(long idRegola) {
		for (Allarme allarme :
				findByRegola(
					idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allarme);
		}
	}

	/**
	 * Returns the number of allarmes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching allarmes
	 */
	@Override
	public int countByRegola(long idRegola) {
		FinderPath finderPath = _finderPathCountByRegola;

		Object[] finderArgs = new Object[] {idRegola};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLARME_WHERE);

			sb.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idRegola);

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

	private static final String _FINDER_COLUMN_REGOLA_IDREGOLA_2 =
		"allarme.idRegola = ?";

	public AllarmePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Allarme.class);

		setModelImplClass(AllarmeImpl.class);
		setModelPKClass(long.class);

		setTable(AllarmeTable.INSTANCE);
	}

	/**
	 * Caches the allarme in the entity cache if it is enabled.
	 *
	 * @param allarme the allarme
	 */
	@Override
	public void cacheResult(Allarme allarme) {
		entityCache.putResult(
			AllarmeImpl.class, allarme.getPrimaryKey(), allarme);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {allarme.getUuid(), allarme.getGroupId()}, allarme);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the allarmes in the entity cache if it is enabled.
	 *
	 * @param allarmes the allarmes
	 */
	@Override
	public void cacheResult(List<Allarme> allarmes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (allarmes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Allarme allarme : allarmes) {
			if (entityCache.getResult(
					AllarmeImpl.class, allarme.getPrimaryKey()) == null) {

				cacheResult(allarme);
			}
		}
	}

	/**
	 * Clears the cache for all allarmes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllarmeImpl.class);

		finderCache.clearCache(AllarmeImpl.class);
	}

	/**
	 * Clears the cache for the allarme.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Allarme allarme) {
		entityCache.removeResult(AllarmeImpl.class, allarme);
	}

	@Override
	public void clearCache(List<Allarme> allarmes) {
		for (Allarme allarme : allarmes) {
			entityCache.removeResult(AllarmeImpl.class, allarme);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AllarmeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AllarmeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AllarmeModelImpl allarmeModelImpl) {
		Object[] args = new Object[] {
			allarmeModelImpl.getUuid(), allarmeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathFetchByUUID_G, args, allarmeModelImpl);
	}

	/**
	 * Creates a new allarme with the primary key. Does not add the allarme to the database.
	 *
	 * @param allarmeId the primary key for the new allarme
	 * @return the new allarme
	 */
	@Override
	public Allarme create(long allarmeId) {
		Allarme allarme = new AllarmeImpl();

		allarme.setNew(true);
		allarme.setPrimaryKey(allarmeId);

		String uuid = PortalUUIDUtil.generate();

		allarme.setUuid(uuid);

		allarme.setCompanyId(CompanyThreadLocal.getCompanyId());

		return allarme;
	}

	/**
	 * Removes the allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme that was removed
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme remove(long allarmeId) throws NoSuchAllarmeException {
		return remove((Serializable)allarmeId);
	}

	/**
	 * Removes the allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allarme
	 * @return the allarme that was removed
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme remove(Serializable primaryKey)
		throws NoSuchAllarmeException {

		Session session = null;

		try {
			session = openSession();

			Allarme allarme = (Allarme)session.get(
				AllarmeImpl.class, primaryKey);

			if (allarme == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllarmeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allarme);
		}
		catch (NoSuchAllarmeException noSuchEntityException) {
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
	protected Allarme removeImpl(Allarme allarme) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allarme)) {
				allarme = (Allarme)session.get(
					AllarmeImpl.class, allarme.getPrimaryKeyObj());
			}

			if (allarme != null) {
				session.delete(allarme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (allarme != null) {
			clearCache(allarme);
		}

		return allarme;
	}

	@Override
	public Allarme updateImpl(Allarme allarme) {
		boolean isNew = allarme.isNew();

		if (!(allarme instanceof AllarmeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(allarme.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(allarme);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in allarme proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Allarme implementation " +
					allarme.getClass());
		}

		AllarmeModelImpl allarmeModelImpl = (AllarmeModelImpl)allarme;

		if (Validator.isNull(allarme.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			allarme.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (allarme.getCreateDate() == null)) {
			if (serviceContext == null) {
				allarme.setCreateDate(date);
			}
			else {
				allarme.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!allarmeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				allarme.setModifiedDate(date);
			}
			else {
				allarme.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(allarme);
			}
			else {
				allarme = (Allarme)session.merge(allarme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AllarmeImpl.class, allarmeModelImpl, false, true);

		cacheUniqueFindersCache(allarmeModelImpl);

		if (isNew) {
			allarme.setNew(false);
		}

		allarme.resetOriginalValues();

		return allarme;
	}

	/**
	 * Returns the allarme with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allarme
	 * @return the allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllarmeException {

		Allarme allarme = fetchByPrimaryKey(primaryKey);

		if (allarme == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllarmeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allarme;
	}

	/**
	 * Returns the allarme with the primary key or throws a <code>NoSuchAllarmeException</code> if it could not be found.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme findByPrimaryKey(long allarmeId)
		throws NoSuchAllarmeException {

		return findByPrimaryKey((Serializable)allarmeId);
	}

	/**
	 * Returns the allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme, or <code>null</code> if a allarme with the primary key could not be found
	 */
	@Override
	public Allarme fetchByPrimaryKey(long allarmeId) {
		return fetchByPrimaryKey((Serializable)allarmeId);
	}

	/**
	 * Returns all the allarmes.
	 *
	 * @return the allarmes
	 */
	@Override
	public List<Allarme> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of allarmes
	 */
	@Override
	public List<Allarme> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allarmes
	 */
	@Override
	public List<Allarme> findAll(
		int start, int end, OrderByComparator<Allarme> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allarmes
	 */
	@Override
	public List<Allarme> findAll(
		int start, int end, OrderByComparator<Allarme> orderByComparator,
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

		List<Allarme> list = null;

		if (useFinderCache) {
			list = (List<Allarme>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALLARME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALLARME;

				sql = sql.concat(AllarmeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Allarme>)QueryUtil.list(
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
	 * Removes all the allarmes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Allarme allarme : findAll()) {
			remove(allarme);
		}
	}

	/**
	 * Returns the number of allarmes.
	 *
	 * @return the number of allarmes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALLARME);

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
		return "allarmeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALLARME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AllarmeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allarme persistence.
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

		_finderPathWithPaginationFindByRegola = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRegola",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idRegola"}, true);

		_finderPathWithoutPaginationFindByRegola = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegola",
			new String[] {Long.class.getName()}, new String[] {"idRegola"},
			true);

		_finderPathCountByRegola = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegola",
			new String[] {Long.class.getName()}, new String[] {"idRegola"},
			false);

		AllarmeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AllarmeUtil.setPersistence(null);

		entityCache.removeCache(AllarmeImpl.class.getName());
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

	private static final String _SQL_SELECT_ALLARME =
		"SELECT allarme FROM Allarme allarme";

	private static final String _SQL_SELECT_ALLARME_WHERE =
		"SELECT allarme FROM Allarme allarme WHERE ";

	private static final String _SQL_COUNT_ALLARME =
		"SELECT COUNT(allarme) FROM Allarme allarme";

	private static final String _SQL_COUNT_ALLARME_WHERE =
		"SELECT COUNT(allarme) FROM Allarme allarme WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allarme.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Allarme exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Allarme exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AllarmePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}