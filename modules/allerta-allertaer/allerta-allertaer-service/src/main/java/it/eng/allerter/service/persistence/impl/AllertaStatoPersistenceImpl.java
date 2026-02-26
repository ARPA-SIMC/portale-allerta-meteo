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

import it.eng.allerter.exception.NoSuchAllertaStatoException;
import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.model.AllertaStatoTable;
import it.eng.allerter.model.impl.AllertaStatoImpl;
import it.eng.allerter.model.impl.AllertaStatoModelImpl;
import it.eng.allerter.service.persistence.AllertaStatoPersistence;
import it.eng.allerter.service.persistence.AllertaStatoUtil;
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
 * The persistence implementation for the allerta stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = AllertaStatoPersistence.class)
public class AllertaStatoPersistenceImpl
	extends BasePersistenceImpl<AllertaStato>
	implements AllertaStatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllertaStatoUtil</code> to access the allerta stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllertaStatoImpl.class.getName();

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
	 * Returns all the allerta statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
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

		List<AllertaStato> list = null;

		if (useFinderCache) {
			list = (List<AllertaStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaStato allertaStato : list) {
					if (!uuid.equals(allertaStato.getUuid())) {
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

			sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

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
				sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<AllertaStato>)QueryUtil.list(
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
	 * Returns the first allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByUuid_First(
			String uuid, OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByUuid_First(uuid, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByUuid_First(
		String uuid, OrderByComparator<AllertaStato> orderByComparator) {

		List<AllertaStato> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByUuid_Last(
			String uuid, OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByUuid_Last(uuid, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByUuid_Last(
		String uuid, OrderByComparator<AllertaStato> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AllertaStato> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato[] findByUuid_PrevAndNext(
			long allertaStatoId, String uuid,
			OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		uuid = Objects.toString(uuid, "");

		AllertaStato allertaStato = findByPrimaryKey(allertaStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaStato[] array = new AllertaStatoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, allertaStato, uuid, orderByComparator, true);

			array[1] = allertaStato;

			array[2] = getByUuid_PrevAndNext(
				session, allertaStato, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaStato getByUuid_PrevAndNext(
		Session session, AllertaStato allertaStato, String uuid,
		OrderByComparator<AllertaStato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

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
			sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allertaStato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllertaStato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta statos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AllertaStato allertaStato :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaStato);
		}
	}

	/**
	 * Returns the number of allerta statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta statos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLERTASTATO_WHERE);

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
		"allertaStato.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(allertaStato.uuid IS NULL OR allertaStato.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaStatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByUUID_G(uuid, groupId);

		if (allertaStato == null) {
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

			throw new NoSuchAllertaStatoException(sb.toString());
		}

		return allertaStato;
	}

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByUUID_G(
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

		if (result instanceof AllertaStato) {
			AllertaStato allertaStato = (AllertaStato)result;

			if (!Objects.equals(uuid, allertaStato.getUuid()) ||
				(groupId != allertaStato.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

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

				List<AllertaStato> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AllertaStato allertaStato = list.get(0);

					result = allertaStato;

					cacheResult(allertaStato);
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
			return (AllertaStato)result;
		}
	}

	/**
	 * Removes the allerta stato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta stato that was removed
	 */
	@Override
	public AllertaStato removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = findByUUID_G(uuid, groupId);

		return remove(allertaStato);
	}

	/**
	 * Returns the number of allerta statos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta statos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AllertaStato allertaStato = fetchByUUID_G(uuid, groupId);

		if (allertaStato == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"allertaStato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(allertaStato.uuid IS NULL OR allertaStato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"allertaStato.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
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

		List<AllertaStato> list = null;

		if (useFinderCache) {
			list = (List<AllertaStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaStato allertaStato : list) {
					if (!uuid.equals(allertaStato.getUuid()) ||
						(companyId != allertaStato.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

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
				sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<AllertaStato>)QueryUtil.list(
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
	 * Returns the first allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllertaStato> orderByComparator) {

		List<AllertaStato> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllertaStato> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AllertaStato> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato[] findByUuid_C_PrevAndNext(
			long allertaStatoId, String uuid, long companyId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		uuid = Objects.toString(uuid, "");

		AllertaStato allertaStato = findByPrimaryKey(allertaStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaStato[] array = new AllertaStatoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, allertaStato, uuid, companyId, orderByComparator,
				true);

			array[1] = allertaStato;

			array[2] = getByUuid_C_PrevAndNext(
				session, allertaStato, uuid, companyId, orderByComparator,
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

	protected AllertaStato getByUuid_C_PrevAndNext(
		Session session, AllertaStato allertaStato, String uuid, long companyId,
		OrderByComparator<AllertaStato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

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
			sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(allertaStato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllertaStato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta statos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AllertaStato allertaStato :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allertaStato);
		}
	}

	/**
	 * Returns the number of allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta statos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLERTASTATO_WHERE);

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
		"allertaStato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(allertaStato.uuid IS NULL OR allertaStato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"allertaStato.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNome;
	private FinderPath _finderPathWithoutPaginationFindByNome;
	private FinderPath _finderPathCountByNome;

	/**
	 * Returns all the allerta statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByNome(String nome) {
		return findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByNome(String nome, int start, int end) {
		return findByNome(nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return findByNome(nome, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
		boolean useFinderCache) {

		nome = Objects.toString(nome, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNome;
				finderArgs = new Object[] {nome};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNome;
			finderArgs = new Object[] {nome, start, end, orderByComparator};
		}

		List<AllertaStato> list = null;

		if (useFinderCache) {
			list = (List<AllertaStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaStato allertaStato : list) {
					if (!nome.equals(allertaStato.getNome())) {
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

			sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

			boolean bindNome = false;

			if (nome.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOME_NOME_3);
			}
			else {
				bindNome = true;

				sb.append(_FINDER_COLUMN_NOME_NOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNome) {
					queryPos.add(nome);
				}

				list = (List<AllertaStato>)QueryUtil.list(
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
	 * Returns the first allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByNome_First(
			String nome, OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByNome_First(nome, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nome=");
		sb.append(nome);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the first allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByNome_First(
		String nome, OrderByComparator<AllertaStato> orderByComparator) {

		List<AllertaStato> list = findByNome(nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByNome_Last(
			String nome, OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByNome_Last(nome, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nome=");
		sb.append(nome);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the last allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByNome_Last(
		String nome, OrderByComparator<AllertaStato> orderByComparator) {

		int count = countByNome(nome);

		if (count == 0) {
			return null;
		}

		List<AllertaStato> list = findByNome(
			nome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato[] findByNome_PrevAndNext(
			long allertaStatoId, String nome,
			OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		nome = Objects.toString(nome, "");

		AllertaStato allertaStato = findByPrimaryKey(allertaStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaStato[] array = new AllertaStatoImpl[3];

			array[0] = getByNome_PrevAndNext(
				session, allertaStato, nome, orderByComparator, true);

			array[1] = allertaStato;

			array[2] = getByNome_PrevAndNext(
				session, allertaStato, nome, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaStato getByNome_PrevAndNext(
		Session session, AllertaStato allertaStato, String nome,
		OrderByComparator<AllertaStato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

		boolean bindNome = false;

		if (nome.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOME_NOME_3);
		}
		else {
			bindNome = true;

			sb.append(_FINDER_COLUMN_NOME_NOME_2);
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
			sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNome) {
			queryPos.add(nome);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(allertaStato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllertaStato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta statos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByNome(String nome) {
		for (AllertaStato allertaStato :
				findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaStato);
		}
	}

	/**
	 * Returns the number of allerta statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching allerta statos
	 */
	@Override
	public int countByNome(String nome) {
		nome = Objects.toString(nome, "");

		FinderPath finderPath = _finderPathCountByNome;

		Object[] finderArgs = new Object[] {nome};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLERTASTATO_WHERE);

			boolean bindNome = false;

			if (nome.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOME_NOME_3);
			}
			else {
				bindNome = true;

				sb.append(_FINDER_COLUMN_NOME_NOME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNome) {
					queryPos.add(nome);
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

	private static final String _FINDER_COLUMN_NOME_NOME_2 =
		"allertaStato.nome = ?";

	private static final String _FINDER_COLUMN_NOME_NOME_3 =
		"(allertaStato.nome IS NULL OR allertaStato.nome = '')";

	private FinderPath _finderPathWithPaginationFindByAllertaId;
	private FinderPath _finderPathWithoutPaginationFindByAllertaId;
	private FinderPath _finderPathCountByAllertaId;

	/**
	 * Returns all the allerta statos where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @return the matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByAllertaId(long allertaId) {
		return findByAllertaId(
			allertaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end) {

		return findByAllertaId(allertaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return findByAllertaId(allertaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	@Override
	public List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAllertaId;
				finderArgs = new Object[] {allertaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAllertaId;
			finderArgs = new Object[] {
				allertaId, start, end, orderByComparator
			};
		}

		List<AllertaStato> list = null;

		if (useFinderCache) {
			list = (List<AllertaStato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AllertaStato allertaStato : list) {
					if (allertaId != allertaStato.getAllertaId()) {
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

			sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

			sb.append(_FINDER_COLUMN_ALLERTAID_ALLERTAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(allertaId);

				list = (List<AllertaStato>)QueryUtil.list(
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
	 * Returns the first allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByAllertaId_First(
			long allertaId, OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByAllertaId_First(
			allertaId, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("allertaId=");
		sb.append(allertaId);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the first allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByAllertaId_First(
		long allertaId, OrderByComparator<AllertaStato> orderByComparator) {

		List<AllertaStato> list = findByAllertaId(
			allertaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato findByAllertaId_Last(
			long allertaId, OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByAllertaId_Last(
			allertaId, orderByComparator);

		if (allertaStato != null) {
			return allertaStato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("allertaId=");
		sb.append(allertaId);

		sb.append("}");

		throw new NoSuchAllertaStatoException(sb.toString());
	}

	/**
	 * Returns the last allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public AllertaStato fetchByAllertaId_Last(
		long allertaId, OrderByComparator<AllertaStato> orderByComparator) {

		int count = countByAllertaId(allertaId);

		if (count == 0) {
			return null;
		}

		List<AllertaStato> list = findByAllertaId(
			allertaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato[] findByAllertaId_PrevAndNext(
			long allertaStatoId, long allertaId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = findByPrimaryKey(allertaStatoId);

		Session session = null;

		try {
			session = openSession();

			AllertaStato[] array = new AllertaStatoImpl[3];

			array[0] = getByAllertaId_PrevAndNext(
				session, allertaStato, allertaId, orderByComparator, true);

			array[1] = allertaStato;

			array[2] = getByAllertaId_PrevAndNext(
				session, allertaStato, allertaId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllertaStato getByAllertaId_PrevAndNext(
		Session session, AllertaStato allertaStato, long allertaId,
		OrderByComparator<AllertaStato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALLERTASTATO_WHERE);

		sb.append(_FINDER_COLUMN_ALLERTAID_ALLERTAID_2);

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
			sb.append(AllertaStatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(allertaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(allertaStato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllertaStato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allerta statos where allertaId = &#63; from the database.
	 *
	 * @param allertaId the allerta ID
	 */
	@Override
	public void removeByAllertaId(long allertaId) {
		for (AllertaStato allertaStato :
				findByAllertaId(
					allertaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allertaStato);
		}
	}

	/**
	 * Returns the number of allerta statos where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @return the number of matching allerta statos
	 */
	@Override
	public int countByAllertaId(long allertaId) {
		FinderPath finderPath = _finderPathCountByAllertaId;

		Object[] finderArgs = new Object[] {allertaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLERTASTATO_WHERE);

			sb.append(_FINDER_COLUMN_ALLERTAID_ALLERTAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(allertaId);

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

	private static final String _FINDER_COLUMN_ALLERTAID_ALLERTAID_2 =
		"allertaStato.allertaId = ?";

	public AllertaStatoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AllertaStato.class);

		setModelImplClass(AllertaStatoImpl.class);
		setModelPKClass(long.class);

		setTable(AllertaStatoTable.INSTANCE);
	}

	/**
	 * Caches the allerta stato in the entity cache if it is enabled.
	 *
	 * @param allertaStato the allerta stato
	 */
	@Override
	public void cacheResult(AllertaStato allertaStato) {
		entityCache.putResult(
			AllertaStatoImpl.class, allertaStato.getPrimaryKey(), allertaStato);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {allertaStato.getUuid(), allertaStato.getGroupId()},
			allertaStato);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the allerta statos in the entity cache if it is enabled.
	 *
	 * @param allertaStatos the allerta statos
	 */
	@Override
	public void cacheResult(List<AllertaStato> allertaStatos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (allertaStatos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AllertaStato allertaStato : allertaStatos) {
			if (entityCache.getResult(
					AllertaStatoImpl.class, allertaStato.getPrimaryKey()) ==
						null) {

				cacheResult(allertaStato);
			}
		}
	}

	/**
	 * Clears the cache for all allerta statos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllertaStatoImpl.class);

		finderCache.clearCache(AllertaStatoImpl.class);
	}

	/**
	 * Clears the cache for the allerta stato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllertaStato allertaStato) {
		entityCache.removeResult(AllertaStatoImpl.class, allertaStato);
	}

	@Override
	public void clearCache(List<AllertaStato> allertaStatos) {
		for (AllertaStato allertaStato : allertaStatos) {
			entityCache.removeResult(AllertaStatoImpl.class, allertaStato);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AllertaStatoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AllertaStatoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AllertaStatoModelImpl allertaStatoModelImpl) {

		Object[] args = new Object[] {
			allertaStatoModelImpl.getUuid(), allertaStatoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, allertaStatoModelImpl);
	}

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	@Override
	public AllertaStato create(long allertaStatoId) {
		AllertaStato allertaStato = new AllertaStatoImpl();

		allertaStato.setNew(true);
		allertaStato.setPrimaryKey(allertaStatoId);

		String uuid = PortalUUIDUtil.generate();

		allertaStato.setUuid(uuid);

		allertaStato.setCompanyId(CompanyThreadLocal.getCompanyId());

		return allertaStato;
	}

	/**
	 * Removes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato remove(long allertaStatoId)
		throws NoSuchAllertaStatoException {

		return remove((Serializable)allertaStatoId);
	}

	/**
	 * Removes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato remove(Serializable primaryKey)
		throws NoSuchAllertaStatoException {

		Session session = null;

		try {
			session = openSession();

			AllertaStato allertaStato = (AllertaStato)session.get(
				AllertaStatoImpl.class, primaryKey);

			if (allertaStato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllertaStatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allertaStato);
		}
		catch (NoSuchAllertaStatoException noSuchEntityException) {
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
	protected AllertaStato removeImpl(AllertaStato allertaStato) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allertaStato)) {
				allertaStato = (AllertaStato)session.get(
					AllertaStatoImpl.class, allertaStato.getPrimaryKeyObj());
			}

			if (allertaStato != null) {
				session.delete(allertaStato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (allertaStato != null) {
			clearCache(allertaStato);
		}

		return allertaStato;
	}

	@Override
	public AllertaStato updateImpl(AllertaStato allertaStato) {
		boolean isNew = allertaStato.isNew();

		if (!(allertaStato instanceof AllertaStatoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(allertaStato.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					allertaStato);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in allertaStato proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AllertaStato implementation " +
					allertaStato.getClass());
		}

		AllertaStatoModelImpl allertaStatoModelImpl =
			(AllertaStatoModelImpl)allertaStato;

		if (Validator.isNull(allertaStato.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			allertaStato.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (allertaStato.getCreateDate() == null)) {
			if (serviceContext == null) {
				allertaStato.setCreateDate(date);
			}
			else {
				allertaStato.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!allertaStatoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				allertaStato.setModifiedDate(date);
			}
			else {
				allertaStato.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(allertaStato);
			}
			else {
				allertaStato = (AllertaStato)session.merge(allertaStato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AllertaStatoImpl.class, allertaStatoModelImpl, false, true);

		cacheUniqueFindersCache(allertaStatoModelImpl);

		if (isNew) {
			allertaStato.setNew(false);
		}

		allertaStato.resetOriginalValues();

		return allertaStato;
	}

	/**
	 * Returns the allerta stato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllertaStatoException {

		AllertaStato allertaStato = fetchByPrimaryKey(primaryKey);

		if (allertaStato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllertaStatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allertaStato;
	}

	/**
	 * Returns the allerta stato with the primary key or throws a <code>NoSuchAllertaStatoException</code> if it could not be found.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato findByPrimaryKey(long allertaStatoId)
		throws NoSuchAllertaStatoException {

		return findByPrimaryKey((Serializable)allertaStatoId);
	}

	/**
	 * Returns the allerta stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato, or <code>null</code> if a allerta stato with the primary key could not be found
	 */
	@Override
	public AllertaStato fetchByPrimaryKey(long allertaStatoId) {
		return fetchByPrimaryKey((Serializable)allertaStatoId);
	}

	/**
	 * Returns all the allerta statos.
	 *
	 * @return the allerta statos
	 */
	@Override
	public List<AllertaStato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of allerta statos
	 */
	@Override
	public List<AllertaStato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta statos
	 */
	@Override
	public List<AllertaStato> findAll(
		int start, int end, OrderByComparator<AllertaStato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allerta statos
	 */
	@Override
	public List<AllertaStato> findAll(
		int start, int end, OrderByComparator<AllertaStato> orderByComparator,
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

		List<AllertaStato> list = null;

		if (useFinderCache) {
			list = (List<AllertaStato>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALLERTASTATO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALLERTASTATO;

				sql = sql.concat(AllertaStatoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AllertaStato>)QueryUtil.list(
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
	 * Removes all the allerta statos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AllertaStato allertaStato : findAll()) {
			remove(allertaStato);
		}
	}

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALLERTASTATO);

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
		return "allertaStatoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALLERTASTATO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AllertaStatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allerta stato persistence.
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

		_finderPathWithPaginationFindByNome = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNome",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nome"}, true);

		_finderPathWithoutPaginationFindByNome = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNome",
			new String[] {String.class.getName()}, new String[] {"nome"}, true);

		_finderPathCountByNome = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNome",
			new String[] {String.class.getName()}, new String[] {"nome"},
			false);

		_finderPathWithPaginationFindByAllertaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllertaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"allertaId"}, true);

		_finderPathWithoutPaginationFindByAllertaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAllertaId",
			new String[] {Long.class.getName()}, new String[] {"allertaId"},
			true);

		_finderPathCountByAllertaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAllertaId",
			new String[] {Long.class.getName()}, new String[] {"allertaId"},
			false);

		AllertaStatoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AllertaStatoUtil.setPersistence(null);

		entityCache.removeCache(AllertaStatoImpl.class.getName());
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

	private static final String _SQL_SELECT_ALLERTASTATO =
		"SELECT allertaStato FROM AllertaStato allertaStato";

	private static final String _SQL_SELECT_ALLERTASTATO_WHERE =
		"SELECT allertaStato FROM AllertaStato allertaStato WHERE ";

	private static final String _SQL_COUNT_ALLERTASTATO =
		"SELECT COUNT(allertaStato) FROM AllertaStato allertaStato";

	private static final String _SQL_COUNT_ALLERTASTATO_WHERE =
		"SELECT COUNT(allertaStato) FROM AllertaStato allertaStato WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allertaStato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AllertaStato exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AllertaStato exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaStatoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}