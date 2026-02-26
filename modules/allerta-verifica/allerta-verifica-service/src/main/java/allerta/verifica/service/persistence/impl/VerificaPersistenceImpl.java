/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.impl;

import allerta.verifica.exception.NoSuchVerificaException;
import allerta.verifica.model.Verifica;
import allerta.verifica.model.VerificaTable;
import allerta.verifica.model.impl.VerificaImpl;
import allerta.verifica.model.impl.VerificaModelImpl;
import allerta.verifica.service.persistence.VerificaPersistence;
import allerta.verifica.service.persistence.VerificaUtil;
import allerta.verifica.service.persistence.impl.constants.VERIFICAPersistenceConstants;

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
 * The persistence implementation for the verifica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VerificaPersistence.class)
public class VerificaPersistenceImpl
	extends BasePersistenceImpl<Verifica> implements VerificaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VerificaUtil</code> to access the verifica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VerificaImpl.class.getName();

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
	 * Returns all the verificas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Verifica> orderByComparator, boolean useFinderCache) {

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

		List<Verifica> list = null;

		if (useFinderCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Verifica verifica : list) {
					if (!uuid.equals(verifica.getUuid())) {
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

			sb.append(_SQL_SELECT_VERIFICA_WHERE);

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
				sb.append(VerificaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Verifica>)QueryUtil.list(
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
	 * Returns the first verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_First(
			String uuid, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_First(uuid, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVerificaException(sb.toString());
	}

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_First(
		String uuid, OrderByComparator<Verifica> orderByComparator) {

		List<Verifica> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_Last(
			String uuid, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_Last(uuid, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVerificaException(sb.toString());
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_Last(
		String uuid, OrderByComparator<Verifica> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Verifica> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		uuid = Objects.toString(uuid, "");

		Verifica verifica = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Verifica[] array = new VerificaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, verifica, uuid, orderByComparator, true);

			array[1] = verifica;

			array[2] = getByUuid_PrevAndNext(
				session, verifica, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Verifica getByUuid_PrevAndNext(
		Session session, Verifica verifica, String uuid,
		OrderByComparator<Verifica> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VERIFICA_WHERE);

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
			sb.append(VerificaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(verifica)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Verifica> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verificas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Verifica verifica :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching verificas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFICA_WHERE);

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
		"verifica.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(verifica.uuid IS NULL OR verifica.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVerificaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUUID_G(String uuid, long groupId)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUUID_G(uuid, groupId);

		if (verifica == null) {
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

			throw new NoSuchVerificaException(sb.toString());
		}

		return verifica;
	}

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the verifica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUUID_G(
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

		if (result instanceof Verifica) {
			Verifica verifica = (Verifica)result;

			if (!Objects.equals(uuid, verifica.getUuid()) ||
				(groupId != verifica.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VERIFICA_WHERE);

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

				List<Verifica> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Verifica verifica = list.get(0);

					result = verifica;

					cacheResult(verifica);
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
			return (Verifica)result;
		}
	}

	/**
	 * Removes the verifica where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the verifica that was removed
	 */
	@Override
	public Verifica removeByUUID_G(String uuid, long groupId)
		throws NoSuchVerificaException {

		Verifica verifica = findByUUID_G(uuid, groupId);

		return remove(verifica);
	}

	/**
	 * Returns the number of verificas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching verificas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Verifica verifica = fetchByUUID_G(uuid, groupId);

		if (verifica == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"verifica.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(verifica.uuid IS NULL OR verifica.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"verifica.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Verifica> orderByComparator, boolean useFinderCache) {

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

		List<Verifica> list = null;

		if (useFinderCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Verifica verifica : list) {
					if (!uuid.equals(verifica.getUuid()) ||
						(companyId != verifica.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VERIFICA_WHERE);

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
				sb.append(VerificaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Verifica>)QueryUtil.list(
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
	 * Returns the first verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVerificaException(sb.toString());
	}

	/**
	 * Returns the first verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Verifica> orderByComparator) {

		List<Verifica> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVerificaException(sb.toString());
	}

	/**
	 * Returns the last verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Verifica> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Verifica> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		uuid = Objects.toString(uuid, "");

		Verifica verifica = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Verifica[] array = new VerificaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, verifica, uuid, companyId, orderByComparator, true);

			array[1] = verifica;

			array[2] = getByUuid_C_PrevAndNext(
				session, verifica, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Verifica getByUuid_C_PrevAndNext(
		Session session, Verifica verifica, String uuid, long companyId,
		OrderByComparator<Verifica> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VERIFICA_WHERE);

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
			sb.append(VerificaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(verifica)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Verifica> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verificas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Verifica verifica :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching verificas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VERIFICA_WHERE);

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
		"verifica.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(verifica.uuid IS NULL OR verifica.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"verifica.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDocumento;
	private FinderPath _finderPathWithoutPaginationFindByDocumento;
	private FinderPath _finderPathCountByDocumento;

	/**
	 * Returns all the verificas where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(long documento) {
		return findByDocumento(
			documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(long documento, int start, int end) {
		return findByDocumento(documento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<Verifica> orderByComparator) {

		return findByDocumento(documento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verificas
	 */
	@Override
	public List<Verifica> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<Verifica> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumento;
				finderArgs = new Object[] {documento};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumento;
			finderArgs = new Object[] {
				documento, start, end, orderByComparator
			};
		}

		List<Verifica> list = null;

		if (useFinderCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Verifica verifica : list) {
					if (documento != verifica.getDocumento()) {
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

			sb.append(_SQL_SELECT_VERIFICA_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				list = (List<Verifica>)QueryUtil.list(
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
	 * Returns the first verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByDocumento_First(
			long documento, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByDocumento_First(
			documento, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append("}");

		throw new NoSuchVerificaException(sb.toString());
	}

	/**
	 * Returns the first verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByDocumento_First(
		long documento, OrderByComparator<Verifica> orderByComparator) {

		List<Verifica> list = findByDocumento(
			documento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica
	 * @throws NoSuchVerificaException if a matching verifica could not be found
	 */
	@Override
	public Verifica findByDocumento_Last(
			long documento, OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByDocumento_Last(documento, orderByComparator);

		if (verifica != null) {
			return verifica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append("}");

		throw new NoSuchVerificaException(sb.toString());
	}

	/**
	 * Returns the last verifica in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica, or <code>null</code> if a matching verifica could not be found
	 */
	@Override
	public Verifica fetchByDocumento_Last(
		long documento, OrderByComparator<Verifica> orderByComparator) {

		int count = countByDocumento(documento);

		if (count == 0) {
			return null;
		}

		List<Verifica> list = findByDocumento(
			documento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verificas before and after the current verifica in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<Verifica> orderByComparator)
		throws NoSuchVerificaException {

		Verifica verifica = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Verifica[] array = new VerificaImpl[3];

			array[0] = getByDocumento_PrevAndNext(
				session, verifica, documento, orderByComparator, true);

			array[1] = verifica;

			array[2] = getByDocumento_PrevAndNext(
				session, verifica, documento, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Verifica getByDocumento_PrevAndNext(
		Session session, Verifica verifica, long documento,
		OrderByComparator<Verifica> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VERIFICA_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

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
			sb.append(VerificaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verifica)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Verifica> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verificas where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	@Override
	public void removeByDocumento(long documento) {
		for (Verifica verifica :
				findByDocumento(
					documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verificas
	 */
	@Override
	public int countByDocumento(long documento) {
		FinderPath finderPath = _finderPathCountByDocumento;

		Object[] finderArgs = new Object[] {documento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFICA_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

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

	private static final String _FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2 =
		"verifica.documento = ?";

	public VerificaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Verifica.class);

		setModelImplClass(VerificaImpl.class);
		setModelPKClass(long.class);

		setTable(VerificaTable.INSTANCE);
	}

	/**
	 * Caches the verifica in the entity cache if it is enabled.
	 *
	 * @param verifica the verifica
	 */
	@Override
	public void cacheResult(Verifica verifica) {
		entityCache.putResult(
			VerificaImpl.class, verifica.getPrimaryKey(), verifica);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {verifica.getUuid(), verifica.getGroupId()}, verifica);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the verificas in the entity cache if it is enabled.
	 *
	 * @param verificas the verificas
	 */
	@Override
	public void cacheResult(List<Verifica> verificas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (verificas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Verifica verifica : verificas) {
			if (entityCache.getResult(
					VerificaImpl.class, verifica.getPrimaryKey()) == null) {

				cacheResult(verifica);
			}
		}
	}

	/**
	 * Clears the cache for all verificas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VerificaImpl.class);

		finderCache.clearCache(VerificaImpl.class);
	}

	/**
	 * Clears the cache for the verifica.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Verifica verifica) {
		entityCache.removeResult(VerificaImpl.class, verifica);
	}

	@Override
	public void clearCache(List<Verifica> verificas) {
		for (Verifica verifica : verificas) {
			entityCache.removeResult(VerificaImpl.class, verifica);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VerificaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VerificaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		VerificaModelImpl verificaModelImpl) {

		Object[] args = new Object[] {
			verificaModelImpl.getUuid(), verificaModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, verificaModelImpl);
	}

	/**
	 * Creates a new verifica with the primary key. Does not add the verifica to the database.
	 *
	 * @param id the primary key for the new verifica
	 * @return the new verifica
	 */
	@Override
	public Verifica create(long id) {
		Verifica verifica = new VerificaImpl();

		verifica.setNew(true);
		verifica.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		verifica.setUuid(uuid);

		verifica.setCompanyId(CompanyThreadLocal.getCompanyId());

		return verifica;
	}

	/**
	 * Removes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica remove(long id) throws NoSuchVerificaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the verifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the verifica
	 * @return the verifica that was removed
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica remove(Serializable primaryKey)
		throws NoSuchVerificaException {

		Session session = null;

		try {
			session = openSession();

			Verifica verifica = (Verifica)session.get(
				VerificaImpl.class, primaryKey);

			if (verifica == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVerificaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(verifica);
		}
		catch (NoSuchVerificaException noSuchEntityException) {
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
	protected Verifica removeImpl(Verifica verifica) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(verifica)) {
				verifica = (Verifica)session.get(
					VerificaImpl.class, verifica.getPrimaryKeyObj());
			}

			if (verifica != null) {
				session.delete(verifica);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (verifica != null) {
			clearCache(verifica);
		}

		return verifica;
	}

	@Override
	public Verifica updateImpl(Verifica verifica) {
		boolean isNew = verifica.isNew();

		if (!(verifica instanceof VerificaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(verifica.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(verifica);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in verifica proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Verifica implementation " +
					verifica.getClass());
		}

		VerificaModelImpl verificaModelImpl = (VerificaModelImpl)verifica;

		if (Validator.isNull(verifica.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			verifica.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (verifica.getCreateDate() == null)) {
			if (serviceContext == null) {
				verifica.setCreateDate(date);
			}
			else {
				verifica.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!verificaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				verifica.setModifiedDate(date);
			}
			else {
				verifica.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(verifica);
			}
			else {
				verifica = (Verifica)session.merge(verifica);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VerificaImpl.class, verificaModelImpl, false, true);

		cacheUniqueFindersCache(verificaModelImpl);

		if (isNew) {
			verifica.setNew(false);
		}

		verifica.resetOriginalValues();

		return verifica;
	}

	/**
	 * Returns the verifica with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verifica
	 * @return the verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVerificaException {

		Verifica verifica = fetchByPrimaryKey(primaryKey);

		if (verifica == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVerificaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return verifica;
	}

	/**
	 * Returns the verifica with the primary key or throws a <code>NoSuchVerificaException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica
	 * @throws NoSuchVerificaException if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica findByPrimaryKey(long id) throws NoSuchVerificaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the verifica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica
	 * @return the verifica, or <code>null</code> if a verifica with the primary key could not be found
	 */
	@Override
	public Verifica fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the verificas.
	 *
	 * @return the verificas
	 */
	@Override
	public List<Verifica> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @return the range of verificas
	 */
	@Override
	public List<Verifica> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verificas
	 */
	@Override
	public List<Verifica> findAll(
		int start, int end, OrderByComparator<Verifica> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verificas
	 * @param end the upper bound of the range of verificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verificas
	 */
	@Override
	public List<Verifica> findAll(
		int start, int end, OrderByComparator<Verifica> orderByComparator,
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

		List<Verifica> list = null;

		if (useFinderCache) {
			list = (List<Verifica>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VERIFICA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VERIFICA;

				sql = sql.concat(VerificaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Verifica>)QueryUtil.list(
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
	 * Removes all the verificas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Verifica verifica : findAll()) {
			remove(verifica);
		}
	}

	/**
	 * Returns the number of verificas.
	 *
	 * @return the number of verificas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VERIFICA);

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
		return _SQL_SELECT_VERIFICA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VerificaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the verifica persistence.
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

		_finderPathWithPaginationFindByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumento",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documento"}, true);

		_finderPathWithoutPaginationFindByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumento",
			new String[] {Long.class.getName()}, new String[] {"documento"},
			true);

		_finderPathCountByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumento",
			new String[] {Long.class.getName()}, new String[] {"documento"},
			false);

		VerificaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		VerificaUtil.setPersistence(null);

		entityCache.removeCache(VerificaImpl.class.getName());
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VERIFICA =
		"SELECT verifica FROM Verifica verifica";

	private static final String _SQL_SELECT_VERIFICA_WHERE =
		"SELECT verifica FROM Verifica verifica WHERE ";

	private static final String _SQL_COUNT_VERIFICA =
		"SELECT COUNT(verifica) FROM Verifica verifica";

	private static final String _SQL_COUNT_VERIFICA_WHERE =
		"SELECT COUNT(verifica) FROM Verifica verifica WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "verifica.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Verifica exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Verifica exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VerificaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}