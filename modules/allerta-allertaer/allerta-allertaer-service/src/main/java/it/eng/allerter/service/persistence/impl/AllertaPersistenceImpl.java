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

import it.eng.allerter.exception.NoSuchAllertaException;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaTable;
import it.eng.allerter.model.impl.AllertaImpl;
import it.eng.allerter.model.impl.AllertaModelImpl;
import it.eng.allerter.service.persistence.AllertaPersistence;
import it.eng.allerter.service.persistence.AllertaUtil;
import it.eng.allerter.service.persistence.impl.constants.ALLERTERPersistenceConstants;

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
 * The persistence implementation for the allerta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = AllertaPersistence.class)
public class AllertaPersistenceImpl
	extends BasePersistenceImpl<Allerta> implements AllertaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllertaUtil</code> to access the allerta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllertaImpl.class.getName();

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
	 * Returns all the allertas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allertas
	 */
	@Override
	public List<Allerta> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allertas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of matching allertas
	 */
	@Override
	public List<Allerta> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allertas
	 */
	@Override
	public List<Allerta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Allerta> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allertas
	 */
	@Override
	public List<Allerta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Allerta> orderByComparator, boolean useFinderCache) {

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

		List<Allerta> list = null;

		if (useFinderCache) {
			list = (List<Allerta>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Allerta allerta : list) {
					if (!uuid.equals(allerta.getUuid())) {
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

			sb.append(_SQL_SELECT_ALLERTA_WHERE);

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
				sb.append(AllertaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Allerta>)QueryUtil.list(
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
	 * Returns the first allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByUuid_First(
			String uuid, OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByUuid_First(uuid, orderByComparator);

		if (allerta != null) {
			return allerta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllertaException(sb.toString());
	}

	/**
	 * Returns the first allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByUuid_First(
		String uuid, OrderByComparator<Allerta> orderByComparator) {

		List<Allerta> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByUuid_Last(
			String uuid, OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByUuid_Last(uuid, orderByComparator);

		if (allerta != null) {
			return allerta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllertaException(sb.toString());
	}

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByUuid_Last(
		String uuid, OrderByComparator<Allerta> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Allerta> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allertas before and after the current allerta in the ordered set where uuid = &#63;.
	 *
	 * @param allertaId the primary key of the current allerta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta[] findByUuid_PrevAndNext(
			long allertaId, String uuid,
			OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		uuid = Objects.toString(uuid, "");

		Allerta allerta = findByPrimaryKey(allertaId);

		Session session = null;

		try {
			session = openSession();

			Allerta[] array = new AllertaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, allerta, uuid, orderByComparator, true);

			array[1] = allerta;

			array[2] = getByUuid_PrevAndNext(
				session, allerta, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Allerta getByUuid_PrevAndNext(
		Session session, Allerta allerta, String uuid,
		OrderByComparator<Allerta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLERTA_WHERE);

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
			sb.append(AllertaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allerta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Allerta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allertas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Allerta allerta :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allerta);
		}
	}

	/**
	 * Returns the number of allertas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allertas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLERTA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "allerta.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(allerta.uuid IS NULL OR allerta.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the allerta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByUUID_G(uuid, groupId);

		if (allerta == null) {
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

			throw new NoSuchAllertaException(sb.toString());
		}

		return allerta;
	}

	/**
	 * Returns the allerta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the allerta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByUUID_G(
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

		if (result instanceof Allerta) {
			Allerta allerta = (Allerta)result;

			if (!Objects.equals(uuid, allerta.getUuid()) ||
				(groupId != allerta.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ALLERTA_WHERE);

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

				List<Allerta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Allerta allerta = list.get(0);

					result = allerta;

					cacheResult(allerta);
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
			return (Allerta)result;
		}
	}

	/**
	 * Removes the allerta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta that was removed
	 */
	@Override
	public Allerta removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaException {

		Allerta allerta = findByUUID_G(uuid, groupId);

		return remove(allerta);
	}

	/**
	 * Returns the number of allertas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allertas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Allerta allerta = fetchByUUID_G(uuid, groupId);

		if (allerta == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"allerta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(allerta.uuid IS NULL OR allerta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"allerta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allertas
	 */
	@Override
	public List<Allerta> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of matching allertas
	 */
	@Override
	public List<Allerta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allertas
	 */
	@Override
	public List<Allerta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allerta> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allertas
	 */
	@Override
	public List<Allerta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allerta> orderByComparator, boolean useFinderCache) {

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

		List<Allerta> list = null;

		if (useFinderCache) {
			list = (List<Allerta>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Allerta allerta : list) {
					if (!uuid.equals(allerta.getUuid()) ||
						(companyId != allerta.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ALLERTA_WHERE);

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
				sb.append(AllertaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Allerta>)QueryUtil.list(
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
	 * Returns the first allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (allerta != null) {
			return allerta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllertaException(sb.toString());
	}

	/**
	 * Returns the first allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Allerta> orderByComparator) {

		List<Allerta> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (allerta != null) {
			return allerta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllertaException(sb.toString());
	}

	/**
	 * Returns the last allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Allerta> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Allerta> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allertas before and after the current allerta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaId the primary key of the current allerta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta[] findByUuid_C_PrevAndNext(
			long allertaId, String uuid, long companyId,
			OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		uuid = Objects.toString(uuid, "");

		Allerta allerta = findByPrimaryKey(allertaId);

		Session session = null;

		try {
			session = openSession();

			Allerta[] array = new AllertaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, allerta, uuid, companyId, orderByComparator, true);

			array[1] = allerta;

			array[2] = getByUuid_C_PrevAndNext(
				session, allerta, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Allerta getByUuid_C_PrevAndNext(
		Session session, Allerta allerta, String uuid, long companyId,
		OrderByComparator<Allerta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ALLERTA_WHERE);

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
			sb.append(AllertaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allerta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Allerta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allertas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Allerta allerta :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allerta);
		}
	}

	/**
	 * Returns the number of allertas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allertas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLERTA_WHERE);

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
		"allerta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(allerta.uuid IS NULL OR allerta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"allerta.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNumero;
	private FinderPath _finderPathWithoutPaginationFindByNumero;
	private FinderPath _finderPathCountByNumero;

	/**
	 * Returns all the allertas where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching allertas
	 */
	@Override
	public List<Allerta> findByNumero(String numero) {
		return findByNumero(numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allertas where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of matching allertas
	 */
	@Override
	public List<Allerta> findByNumero(String numero, int start, int end) {
		return findByNumero(numero, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allertas where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allertas
	 */
	@Override
	public List<Allerta> findByNumero(
		String numero, int start, int end,
		OrderByComparator<Allerta> orderByComparator) {

		return findByNumero(numero, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allertas where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allertas
	 */
	@Override
	public List<Allerta> findByNumero(
		String numero, int start, int end,
		OrderByComparator<Allerta> orderByComparator, boolean useFinderCache) {

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

		List<Allerta> list = null;

		if (useFinderCache) {
			list = (List<Allerta>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Allerta allerta : list) {
					if (!numero.equals(allerta.getNumero())) {
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

			sb.append(_SQL_SELECT_ALLERTA_WHERE);

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
				sb.append(AllertaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Allerta>)QueryUtil.list(
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
	 * Returns the first allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByNumero_First(
			String numero, OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByNumero_First(numero, orderByComparator);

		if (allerta != null) {
			return allerta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append("}");

		throw new NoSuchAllertaException(sb.toString());
	}

	/**
	 * Returns the first allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByNumero_First(
		String numero, OrderByComparator<Allerta> orderByComparator) {

		List<Allerta> list = findByNumero(numero, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta
	 * @throws NoSuchAllertaException if a matching allerta could not be found
	 */
	@Override
	public Allerta findByNumero_Last(
			String numero, OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByNumero_Last(numero, orderByComparator);

		if (allerta != null) {
			return allerta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("numero=");
		sb.append(numero);

		sb.append("}");

		throw new NoSuchAllertaException(sb.toString());
	}

	/**
	 * Returns the last allerta in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public Allerta fetchByNumero_Last(
		String numero, OrderByComparator<Allerta> orderByComparator) {

		int count = countByNumero(numero);

		if (count == 0) {
			return null;
		}

		List<Allerta> list = findByNumero(
			numero, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allertas before and after the current allerta in the ordered set where numero = &#63;.
	 *
	 * @param allertaId the primary key of the current allerta
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta[] findByNumero_PrevAndNext(
			long allertaId, String numero,
			OrderByComparator<Allerta> orderByComparator)
		throws NoSuchAllertaException {

		numero = Objects.toString(numero, "");

		Allerta allerta = findByPrimaryKey(allertaId);

		Session session = null;

		try {
			session = openSession();

			Allerta[] array = new AllertaImpl[3];

			array[0] = getByNumero_PrevAndNext(
				session, allerta, numero, orderByComparator, true);

			array[1] = allerta;

			array[2] = getByNumero_PrevAndNext(
				session, allerta, numero, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Allerta getByNumero_PrevAndNext(
		Session session, Allerta allerta, String numero,
		OrderByComparator<Allerta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLERTA_WHERE);

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
			sb.append(AllertaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allerta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Allerta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allertas where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	@Override
	public void removeByNumero(String numero) {
		for (Allerta allerta :
				findByNumero(
					numero, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allerta);
		}
	}

	/**
	 * Returns the number of allertas where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching allertas
	 */
	@Override
	public int countByNumero(String numero) {
		numero = Objects.toString(numero, "");

		FinderPath finderPath = _finderPathCountByNumero;

		Object[] finderArgs = new Object[] {numero};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLERTA_WHERE);

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
		"allerta.numero = ?";

	private static final String _FINDER_COLUMN_NUMERO_NUMERO_3 =
		"(allerta.numero IS NULL OR allerta.numero = '')";

	public AllertaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Allerta.class);

		setModelImplClass(AllertaImpl.class);
		setModelPKClass(long.class);

		setTable(AllertaTable.INSTANCE);
	}

	/**
	 * Caches the allerta in the entity cache if it is enabled.
	 *
	 * @param allerta the allerta
	 */
	@Override
	public void cacheResult(Allerta allerta) {
		entityCache.putResult(
			AllertaImpl.class, allerta.getPrimaryKey(), allerta);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {allerta.getUuid(), allerta.getGroupId()}, allerta);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the allertas in the entity cache if it is enabled.
	 *
	 * @param allertas the allertas
	 */
	@Override
	public void cacheResult(List<Allerta> allertas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (allertas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Allerta allerta : allertas) {
			if (entityCache.getResult(
					AllertaImpl.class, allerta.getPrimaryKey()) == null) {

				cacheResult(allerta);
			}
		}
	}

	/**
	 * Clears the cache for all allertas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllertaImpl.class);

		finderCache.clearCache(AllertaImpl.class);
	}

	/**
	 * Clears the cache for the allerta.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Allerta allerta) {
		entityCache.removeResult(AllertaImpl.class, allerta);
	}

	@Override
	public void clearCache(List<Allerta> allertas) {
		for (Allerta allerta : allertas) {
			entityCache.removeResult(AllertaImpl.class, allerta);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AllertaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AllertaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AllertaModelImpl allertaModelImpl) {
		Object[] args = new Object[] {
			allertaModelImpl.getUuid(), allertaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathFetchByUUID_G, args, allertaModelImpl);
	}

	/**
	 * Creates a new allerta with the primary key. Does not add the allerta to the database.
	 *
	 * @param allertaId the primary key for the new allerta
	 * @return the new allerta
	 */
	@Override
	public Allerta create(long allertaId) {
		Allerta allerta = new AllertaImpl();

		allerta.setNew(true);
		allerta.setPrimaryKey(allertaId);

		String uuid = PortalUUIDUtil.generate();

		allerta.setUuid(uuid);

		allerta.setCompanyId(CompanyThreadLocal.getCompanyId());

		return allerta;
	}

	/**
	 * Removes the allerta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta that was removed
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta remove(long allertaId) throws NoSuchAllertaException {
		return remove((Serializable)allertaId);
	}

	/**
	 * Removes the allerta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allerta
	 * @return the allerta that was removed
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta remove(Serializable primaryKey)
		throws NoSuchAllertaException {

		Session session = null;

		try {
			session = openSession();

			Allerta allerta = (Allerta)session.get(
				AllertaImpl.class, primaryKey);

			if (allerta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllertaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allerta);
		}
		catch (NoSuchAllertaException noSuchEntityException) {
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
	protected Allerta removeImpl(Allerta allerta) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allerta)) {
				allerta = (Allerta)session.get(
					AllertaImpl.class, allerta.getPrimaryKeyObj());
			}

			if (allerta != null) {
				session.delete(allerta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (allerta != null) {
			clearCache(allerta);
		}

		return allerta;
	}

	@Override
	public Allerta updateImpl(Allerta allerta) {
		boolean isNew = allerta.isNew();

		if (!(allerta instanceof AllertaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(allerta.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(allerta);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in allerta proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Allerta implementation " +
					allerta.getClass());
		}

		AllertaModelImpl allertaModelImpl = (AllertaModelImpl)allerta;

		if (Validator.isNull(allerta.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			allerta.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (allerta.getCreateDate() == null)) {
			if (serviceContext == null) {
				allerta.setCreateDate(date);
			}
			else {
				allerta.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!allertaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				allerta.setModifiedDate(date);
			}
			else {
				allerta.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(allerta);
			}
			else {
				allerta = (Allerta)session.merge(allerta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AllertaImpl.class, allertaModelImpl, false, true);

		cacheUniqueFindersCache(allertaModelImpl);

		if (isNew) {
			allerta.setNew(false);
		}

		allerta.resetOriginalValues();

		return allerta;
	}

	/**
	 * Returns the allerta with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta
	 * @return the allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllertaException {

		Allerta allerta = fetchByPrimaryKey(primaryKey);

		if (allerta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllertaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allerta;
	}

	/**
	 * Returns the allerta with the primary key or throws a <code>NoSuchAllertaException</code> if it could not be found.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta
	 * @throws NoSuchAllertaException if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta findByPrimaryKey(long allertaId)
		throws NoSuchAllertaException {

		return findByPrimaryKey((Serializable)allertaId);
	}

	/**
	 * Returns the allerta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta, or <code>null</code> if a allerta with the primary key could not be found
	 */
	@Override
	public Allerta fetchByPrimaryKey(long allertaId) {
		return fetchByPrimaryKey((Serializable)allertaId);
	}

	/**
	 * Returns all the allertas.
	 *
	 * @return the allertas
	 */
	@Override
	public List<Allerta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of allertas
	 */
	@Override
	public List<Allerta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allertas
	 */
	@Override
	public List<Allerta> findAll(
		int start, int end, OrderByComparator<Allerta> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allertas
	 */
	@Override
	public List<Allerta> findAll(
		int start, int end, OrderByComparator<Allerta> orderByComparator,
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

		List<Allerta> list = null;

		if (useFinderCache) {
			list = (List<Allerta>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALLERTA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALLERTA;

				sql = sql.concat(AllertaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Allerta>)QueryUtil.list(
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
	 * Removes all the allertas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Allerta allerta : findAll()) {
			remove(allerta);
		}
	}

	/**
	 * Returns the number of allertas.
	 *
	 * @return the number of allertas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALLERTA);

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
		return "allertaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALLERTA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AllertaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allerta persistence.
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

		AllertaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AllertaUtil.setPersistence(null);

		entityCache.removeCache(AllertaImpl.class.getName());
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

	private static final String _SQL_SELECT_ALLERTA =
		"SELECT allerta FROM Allerta allerta";

	private static final String _SQL_SELECT_ALLERTA_WHERE =
		"SELECT allerta FROM Allerta allerta WHERE ";

	private static final String _SQL_COUNT_ALLERTA =
		"SELECT COUNT(allerta) FROM Allerta allerta";

	private static final String _SQL_COUNT_ALLERTA_WHERE =
		"SELECT COUNT(allerta) FROM Allerta allerta WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allerta.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Allerta exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Allerta exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}