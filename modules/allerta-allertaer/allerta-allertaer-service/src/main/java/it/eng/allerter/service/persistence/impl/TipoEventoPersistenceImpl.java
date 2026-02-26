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

import it.eng.allerter.exception.NoSuchTipoEventoException;
import it.eng.allerter.model.TipoEvento;
import it.eng.allerter.model.TipoEventoTable;
import it.eng.allerter.model.impl.TipoEventoImpl;
import it.eng.allerter.model.impl.TipoEventoModelImpl;
import it.eng.allerter.service.persistence.TipoEventoPersistence;
import it.eng.allerter.service.persistence.TipoEventoUtil;
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
 * The persistence implementation for the tipo evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = TipoEventoPersistence.class)
public class TipoEventoPersistenceImpl
	extends BasePersistenceImpl<TipoEvento> implements TipoEventoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TipoEventoUtil</code> to access the tipo evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TipoEventoImpl.class.getName();

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
	 * Returns all the tipo eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
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

		List<TipoEvento> list = null;

		if (useFinderCache) {
			list = (List<TipoEvento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipoEvento tipoEvento : list) {
					if (!uuid.equals(tipoEvento.getUuid())) {
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

			sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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
				sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipoEvento>)QueryUtil.list(
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
	 * Returns the first tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByUuid_First(
			String uuid, OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByUuid_First(uuid, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByUuid_First(
		String uuid, OrderByComparator<TipoEvento> orderByComparator) {

		List<TipoEvento> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByUuid_Last(
			String uuid, OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByUuid_Last(uuid, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByUuid_Last(
		String uuid, OrderByComparator<TipoEvento> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TipoEvento> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento[] findByUuid_PrevAndNext(
			long eventoId, String uuid,
			OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		uuid = Objects.toString(uuid, "");

		TipoEvento tipoEvento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			TipoEvento[] array = new TipoEventoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tipoEvento, uuid, orderByComparator, true);

			array[1] = tipoEvento;

			array[2] = getByUuid_PrevAndNext(
				session, tipoEvento, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipoEvento getByUuid_PrevAndNext(
		Session session, TipoEvento tipoEvento, String uuid,
		OrderByComparator<TipoEvento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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
			sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tipoEvento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoEvento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo eventos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TipoEvento tipoEvento :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipoEvento);
		}
	}

	/**
	 * Returns the number of tipo eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipo eventos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPOEVENTO_WHERE);

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
		"tipoEvento.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tipoEvento.uuid IS NULL OR tipoEvento.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipoEventoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByUUID_G(String uuid, long groupId)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByUUID_G(uuid, groupId);

		if (tipoEvento == null) {
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

			throw new NoSuchTipoEventoException(sb.toString());
		}

		return tipoEvento;
	}

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByUUID_G(
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

		if (result instanceof TipoEvento) {
			TipoEvento tipoEvento = (TipoEvento)result;

			if (!Objects.equals(uuid, tipoEvento.getUuid()) ||
				(groupId != tipoEvento.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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

				List<TipoEvento> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TipoEvento tipoEvento = list.get(0);

					result = tipoEvento;

					cacheResult(tipoEvento);
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
			return (TipoEvento)result;
		}
	}

	/**
	 * Removes the tipo evento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipo evento that was removed
	 */
	@Override
	public TipoEvento removeByUUID_G(String uuid, long groupId)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = findByUUID_G(uuid, groupId);

		return remove(tipoEvento);
	}

	/**
	 * Returns the number of tipo eventos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipo eventos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		TipoEvento tipoEvento = fetchByUUID_G(uuid, groupId);

		if (tipoEvento == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"tipoEvento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(tipoEvento.uuid IS NULL OR tipoEvento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"tipoEvento.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
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

		List<TipoEvento> list = null;

		if (useFinderCache) {
			list = (List<TipoEvento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipoEvento tipoEvento : list) {
					if (!uuid.equals(tipoEvento.getUuid()) ||
						(companyId != tipoEvento.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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
				sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipoEvento>)QueryUtil.list(
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
	 * Returns the first tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TipoEvento> orderByComparator) {

		List<TipoEvento> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TipoEvento> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TipoEvento> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento[] findByUuid_C_PrevAndNext(
			long eventoId, String uuid, long companyId,
			OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		uuid = Objects.toString(uuid, "");

		TipoEvento tipoEvento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			TipoEvento[] array = new TipoEventoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, tipoEvento, uuid, companyId, orderByComparator, true);

			array[1] = tipoEvento;

			array[2] = getByUuid_C_PrevAndNext(
				session, tipoEvento, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipoEvento getByUuid_C_PrevAndNext(
		Session session, TipoEvento tipoEvento, String uuid, long companyId,
		OrderByComparator<TipoEvento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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
			sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tipoEvento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoEvento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo eventos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TipoEvento tipoEvento :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tipoEvento);
		}
	}

	/**
	 * Returns the number of tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipo eventos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIPOEVENTO_WHERE);

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
		"tipoEvento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(tipoEvento.uuid IS NULL OR tipoEvento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"tipoEvento.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNome;
	private FinderPath _finderPathWithoutPaginationFindByNome;
	private FinderPath _finderPathCountByNome;

	/**
	 * Returns all the tipo eventos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByNome(String nome) {
		return findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByNome(String nome, int start, int end) {
		return findByNome(nome, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByNome(
		String nome, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return findByNome(nome, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByNome(
		String nome, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
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

		List<TipoEvento> list = null;

		if (useFinderCache) {
			list = (List<TipoEvento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipoEvento tipoEvento : list) {
					if (!nome.equals(tipoEvento.getNome())) {
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

			sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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
				sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipoEvento>)QueryUtil.list(
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
	 * Returns the first tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByNome_First(
			String nome, OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByNome_First(nome, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nome=");
		sb.append(nome);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the first tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByNome_First(
		String nome, OrderByComparator<TipoEvento> orderByComparator) {

		List<TipoEvento> list = findByNome(nome, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByNome_Last(
			String nome, OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByNome_Last(nome, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nome=");
		sb.append(nome);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the last tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByNome_Last(
		String nome, OrderByComparator<TipoEvento> orderByComparator) {

		int count = countByNome(nome);

		if (count == 0) {
			return null;
		}

		List<TipoEvento> list = findByNome(
			nome, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento[] findByNome_PrevAndNext(
			long eventoId, String nome,
			OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		nome = Objects.toString(nome, "");

		TipoEvento tipoEvento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			TipoEvento[] array = new TipoEventoImpl[3];

			array[0] = getByNome_PrevAndNext(
				session, tipoEvento, nome, orderByComparator, true);

			array[1] = tipoEvento;

			array[2] = getByNome_PrevAndNext(
				session, tipoEvento, nome, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipoEvento getByNome_PrevAndNext(
		Session session, TipoEvento tipoEvento, String nome,
		OrderByComparator<TipoEvento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

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
			sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tipoEvento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoEvento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo eventos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	@Override
	public void removeByNome(String nome) {
		for (TipoEvento tipoEvento :
				findByNome(nome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipoEvento);
		}
	}

	/**
	 * Returns the number of tipo eventos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching tipo eventos
	 */
	@Override
	public int countByNome(String nome) {
		nome = Objects.toString(nome, "");

		FinderPath finderPath = _finderPathCountByNome;

		Object[] finderArgs = new Object[] {nome};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPOEVENTO_WHERE);

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
		"tipoEvento.nome = ?";

	private static final String _FINDER_COLUMN_NOME_NOME_3 =
		"(tipoEvento.nome IS NULL OR tipoEvento.nome = '')";

	private FinderPath _finderPathWithPaginationFindByTabella;
	private FinderPath _finderPathWithoutPaginationFindByTabella;
	private FinderPath _finderPathCountByTabella;

	/**
	 * Returns all the tipo eventos where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @return the matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByTabella(int tabella) {
		return findByTabella(
			tabella, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByTabella(int tabella, int start, int end) {
		return findByTabella(tabella, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByTabella(
		int tabella, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return findByTabella(tabella, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	@Override
	public List<TipoEvento> findByTabella(
		int tabella, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTabella;
				finderArgs = new Object[] {tabella};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTabella;
			finderArgs = new Object[] {tabella, start, end, orderByComparator};
		}

		List<TipoEvento> list = null;

		if (useFinderCache) {
			list = (List<TipoEvento>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipoEvento tipoEvento : list) {
					if (tabella != tipoEvento.getTabella()) {
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

			sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

			sb.append(_FINDER_COLUMN_TABELLA_TABELLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tabella);

				list = (List<TipoEvento>)QueryUtil.list(
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
	 * Returns the first tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByTabella_First(
			int tabella, OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByTabella_First(
			tabella, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tabella=");
		sb.append(tabella);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the first tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByTabella_First(
		int tabella, OrderByComparator<TipoEvento> orderByComparator) {

		List<TipoEvento> list = findByTabella(tabella, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento findByTabella_Last(
			int tabella, OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByTabella_Last(tabella, orderByComparator);

		if (tipoEvento != null) {
			return tipoEvento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tabella=");
		sb.append(tabella);

		sb.append("}");

		throw new NoSuchTipoEventoException(sb.toString());
	}

	/**
	 * Returns the last tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchByTabella_Last(
		int tabella, OrderByComparator<TipoEvento> orderByComparator) {

		int count = countByTabella(tabella);

		if (count == 0) {
			return null;
		}

		List<TipoEvento> list = findByTabella(
			tabella, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento[] findByTabella_PrevAndNext(
			long eventoId, int tabella,
			OrderByComparator<TipoEvento> orderByComparator)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = findByPrimaryKey(eventoId);

		Session session = null;

		try {
			session = openSession();

			TipoEvento[] array = new TipoEventoImpl[3];

			array[0] = getByTabella_PrevAndNext(
				session, tipoEvento, tabella, orderByComparator, true);

			array[1] = tipoEvento;

			array[2] = getByTabella_PrevAndNext(
				session, tipoEvento, tabella, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipoEvento getByTabella_PrevAndNext(
		Session session, TipoEvento tipoEvento, int tabella,
		OrderByComparator<TipoEvento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPOEVENTO_WHERE);

		sb.append(_FINDER_COLUMN_TABELLA_TABELLA_2);

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
			sb.append(TipoEventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tabella);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tipoEvento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoEvento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo eventos where tabella = &#63; from the database.
	 *
	 * @param tabella the tabella
	 */
	@Override
	public void removeByTabella(int tabella) {
		for (TipoEvento tipoEvento :
				findByTabella(
					tabella, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipoEvento);
		}
	}

	/**
	 * Returns the number of tipo eventos where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @return the number of matching tipo eventos
	 */
	@Override
	public int countByTabella(int tabella) {
		FinderPath finderPath = _finderPathCountByTabella;

		Object[] finderArgs = new Object[] {tabella};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPOEVENTO_WHERE);

			sb.append(_FINDER_COLUMN_TABELLA_TABELLA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tabella);

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

	private static final String _FINDER_COLUMN_TABELLA_TABELLA_2 =
		"tipoEvento.tabella = ?";

	public TipoEventoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TipoEvento.class);

		setModelImplClass(TipoEventoImpl.class);
		setModelPKClass(long.class);

		setTable(TipoEventoTable.INSTANCE);
	}

	/**
	 * Caches the tipo evento in the entity cache if it is enabled.
	 *
	 * @param tipoEvento the tipo evento
	 */
	@Override
	public void cacheResult(TipoEvento tipoEvento) {
		entityCache.putResult(
			TipoEventoImpl.class, tipoEvento.getPrimaryKey(), tipoEvento);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {tipoEvento.getUuid(), tipoEvento.getGroupId()},
			tipoEvento);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tipo eventos in the entity cache if it is enabled.
	 *
	 * @param tipoEventos the tipo eventos
	 */
	@Override
	public void cacheResult(List<TipoEvento> tipoEventos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tipoEventos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TipoEvento tipoEvento : tipoEventos) {
			if (entityCache.getResult(
					TipoEventoImpl.class, tipoEvento.getPrimaryKey()) == null) {

				cacheResult(tipoEvento);
			}
		}
	}

	/**
	 * Clears the cache for all tipo eventos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipoEventoImpl.class);

		finderCache.clearCache(TipoEventoImpl.class);
	}

	/**
	 * Clears the cache for the tipo evento.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoEvento tipoEvento) {
		entityCache.removeResult(TipoEventoImpl.class, tipoEvento);
	}

	@Override
	public void clearCache(List<TipoEvento> tipoEventos) {
		for (TipoEvento tipoEvento : tipoEventos) {
			entityCache.removeResult(TipoEventoImpl.class, tipoEvento);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TipoEventoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TipoEventoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TipoEventoModelImpl tipoEventoModelImpl) {

		Object[] args = new Object[] {
			tipoEventoModelImpl.getUuid(), tipoEventoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, tipoEventoModelImpl);
	}

	/**
	 * Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	 *
	 * @param eventoId the primary key for the new tipo evento
	 * @return the new tipo evento
	 */
	@Override
	public TipoEvento create(long eventoId) {
		TipoEvento tipoEvento = new TipoEventoImpl();

		tipoEvento.setNew(true);
		tipoEvento.setPrimaryKey(eventoId);

		String uuid = PortalUUIDUtil.generate();

		tipoEvento.setUuid(uuid);

		tipoEvento.setCompanyId(CompanyThreadLocal.getCompanyId());

		return tipoEvento;
	}

	/**
	 * Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento remove(long eventoId) throws NoSuchTipoEventoException {
		return remove((Serializable)eventoId);
	}

	/**
	 * Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento remove(Serializable primaryKey)
		throws NoSuchTipoEventoException {

		Session session = null;

		try {
			session = openSession();

			TipoEvento tipoEvento = (TipoEvento)session.get(
				TipoEventoImpl.class, primaryKey);

			if (tipoEvento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoEventoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tipoEvento);
		}
		catch (NoSuchTipoEventoException noSuchEntityException) {
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
	protected TipoEvento removeImpl(TipoEvento tipoEvento) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipoEvento)) {
				tipoEvento = (TipoEvento)session.get(
					TipoEventoImpl.class, tipoEvento.getPrimaryKeyObj());
			}

			if (tipoEvento != null) {
				session.delete(tipoEvento);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tipoEvento != null) {
			clearCache(tipoEvento);
		}

		return tipoEvento;
	}

	@Override
	public TipoEvento updateImpl(TipoEvento tipoEvento) {
		boolean isNew = tipoEvento.isNew();

		if (!(tipoEvento instanceof TipoEventoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tipoEvento.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tipoEvento);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tipoEvento proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TipoEvento implementation " +
					tipoEvento.getClass());
		}

		TipoEventoModelImpl tipoEventoModelImpl =
			(TipoEventoModelImpl)tipoEvento;

		if (Validator.isNull(tipoEvento.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tipoEvento.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (tipoEvento.getCreateDate() == null)) {
			if (serviceContext == null) {
				tipoEvento.setCreateDate(date);
			}
			else {
				tipoEvento.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!tipoEventoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tipoEvento.setModifiedDate(date);
			}
			else {
				tipoEvento.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tipoEvento);
			}
			else {
				tipoEvento = (TipoEvento)session.merge(tipoEvento);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TipoEventoImpl.class, tipoEventoModelImpl, false, true);

		cacheUniqueFindersCache(tipoEventoModelImpl);

		if (isNew) {
			tipoEvento.setNew(false);
		}

		tipoEvento.resetOriginalValues();

		return tipoEvento;
	}

	/**
	 * Returns the tipo evento with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipoEventoException {

		TipoEvento tipoEvento = fetchByPrimaryKey(primaryKey);

		if (tipoEvento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipoEventoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tipoEvento;
	}

	/**
	 * Returns the tipo evento with the primary key or throws a <code>NoSuchTipoEventoException</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento findByPrimaryKey(long eventoId)
		throws NoSuchTipoEventoException {

		return findByPrimaryKey((Serializable)eventoId);
	}

	/**
	 * Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento fetchByPrimaryKey(long eventoId) {
		return fetchByPrimaryKey((Serializable)eventoId);
	}

	/**
	 * Returns all the tipo eventos.
	 *
	 * @return the tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll(
		int start, int end, OrderByComparator<TipoEvento> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll(
		int start, int end, OrderByComparator<TipoEvento> orderByComparator,
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

		List<TipoEvento> list = null;

		if (useFinderCache) {
			list = (List<TipoEvento>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIPOEVENTO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOEVENTO;

				sql = sql.concat(TipoEventoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TipoEvento>)QueryUtil.list(
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
	 * Removes all the tipo eventos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipoEvento tipoEvento : findAll()) {
			remove(tipoEvento);
		}
	}

	/**
	 * Returns the number of tipo eventos.
	 *
	 * @return the number of tipo eventos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TIPOEVENTO);

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
		return "eventoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIPOEVENTO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TipoEventoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipo evento persistence.
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

		_finderPathWithPaginationFindByTabella = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTabella",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tabella"}, true);

		_finderPathWithoutPaginationFindByTabella = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTabella",
			new String[] {Integer.class.getName()}, new String[] {"tabella"},
			true);

		_finderPathCountByTabella = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTabella",
			new String[] {Integer.class.getName()}, new String[] {"tabella"},
			false);

		TipoEventoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TipoEventoUtil.setPersistence(null);

		entityCache.removeCache(TipoEventoImpl.class.getName());
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

	private static final String _SQL_SELECT_TIPOEVENTO =
		"SELECT tipoEvento FROM TipoEvento tipoEvento";

	private static final String _SQL_SELECT_TIPOEVENTO_WHERE =
		"SELECT tipoEvento FROM TipoEvento tipoEvento WHERE ";

	private static final String _SQL_COUNT_TIPOEVENTO =
		"SELECT COUNT(tipoEvento) FROM TipoEvento tipoEvento";

	private static final String _SQL_COUNT_TIPOEVENTO_WHERE =
		"SELECT COUNT(tipoEvento) FROM TipoEvento tipoEvento WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoEvento.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TipoEvento exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TipoEvento exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TipoEventoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}