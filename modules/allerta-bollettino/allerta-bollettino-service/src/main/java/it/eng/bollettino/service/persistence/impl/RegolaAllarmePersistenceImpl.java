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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeException;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.model.RegolaAllarmeTable;
import it.eng.bollettino.model.impl.RegolaAllarmeImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeModelImpl;
import it.eng.bollettino.service.persistence.RegolaAllarmePersistence;
import it.eng.bollettino.service.persistence.RegolaAllarmeUtil;
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
 * The persistence implementation for the regola allarme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = RegolaAllarmePersistence.class)
public class RegolaAllarmePersistenceImpl
	extends BasePersistenceImpl<RegolaAllarme>
	implements RegolaAllarmePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegolaAllarmeUtil</code> to access the regola allarme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegolaAllarmeImpl.class.getName();

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
	 * Returns all the regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator,
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

		List<RegolaAllarme> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarme regolaAllarme : list) {
					if (!uuid.equals(regolaAllarme.getUuid())) {
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

			sb.append(_SQL_SELECT_REGOLAALLARME_WHERE);

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
				sb.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegolaAllarme>)QueryUtil.list(
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
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByUuid_First(
			String uuid, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByUuid_First(
			uuid, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegolaAllarmeException(sb.toString());
	}

	/**
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByUuid_First(
		String uuid, OrderByComparator<RegolaAllarme> orderByComparator) {

		List<RegolaAllarme> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByUuid_Last(
			String uuid, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByUuid_Last(uuid, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegolaAllarmeException(sb.toString());
	}

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByUuid_Last(
		String uuid, OrderByComparator<RegolaAllarme> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarme> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		uuid = Objects.toString(uuid, "");

		RegolaAllarme regolaAllarme = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarme[] array = new RegolaAllarmeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, regolaAllarme, uuid, orderByComparator, true);

			array[1] = regolaAllarme;

			array[2] = getByUuid_PrevAndNext(
				session, regolaAllarme, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegolaAllarme getByUuid_PrevAndNext(
		Session session, RegolaAllarme regolaAllarme, String uuid,
		OrderByComparator<RegolaAllarme> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REGOLAALLARME_WHERE);

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
			sb.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
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
						regolaAllarme)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarme> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegolaAllarme regolaAllarme :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarme);
		}
	}

	/**
	 * Returns the number of regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarmes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARME_WHERE);

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
		"regolaAllarme.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(regolaAllarme.uuid IS NULL OR regolaAllarme.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByAttivo;
	private FinderPath _finderPathWithoutPaginationFindByAttivo;
	private FinderPath _finderPathCountByAttivo;

	/**
	 * Returns all the regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(boolean attivo) {
		return findByAttivo(attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end) {

		return findByAttivo(attivo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return findByAttivo(attivo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAttivo;
				finderArgs = new Object[] {attivo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAttivo;
			finderArgs = new Object[] {attivo, start, end, orderByComparator};
		}

		List<RegolaAllarme> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarme>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarme regolaAllarme : list) {
					if (attivo != regolaAllarme.isAttivo()) {
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

			sb.append(_SQL_SELECT_REGOLAALLARME_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

				list = (List<RegolaAllarme>)QueryUtil.list(
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
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByAttivo_First(
			boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByAttivo_First(
			attivo, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchRegolaAllarmeException(sb.toString());
	}

	/**
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByAttivo_First(
		boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator) {

		List<RegolaAllarme> list = findByAttivo(
			attivo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme findByAttivo_Last(
			boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByAttivo_Last(
			attivo, orderByComparator);

		if (regolaAllarme != null) {
			return regolaAllarme;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchRegolaAllarmeException(sb.toString());
	}

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	@Override
	public RegolaAllarme fetchByAttivo_Last(
		boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator) {

		int count = countByAttivo(attivo);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarme> list = findByAttivo(
			attivo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme[] findByAttivo_PrevAndNext(
			long id, boolean attivo,
			OrderByComparator<RegolaAllarme> orderByComparator)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarme[] array = new RegolaAllarmeImpl[3];

			array[0] = getByAttivo_PrevAndNext(
				session, regolaAllarme, attivo, orderByComparator, true);

			array[1] = regolaAllarme;

			array[2] = getByAttivo_PrevAndNext(
				session, regolaAllarme, attivo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegolaAllarme getByAttivo_PrevAndNext(
		Session session, RegolaAllarme regolaAllarme, boolean attivo,
		OrderByComparator<RegolaAllarme> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REGOLAALLARME_WHERE);

		sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

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
			sb.append(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(attivo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						regolaAllarme)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarme> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarmes where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	@Override
	public void removeByAttivo(boolean attivo) {
		for (RegolaAllarme regolaAllarme :
				findByAttivo(
					attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarme);
		}
	}

	/**
	 * Returns the number of regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching regola allarmes
	 */
	@Override
	public int countByAttivo(boolean attivo) {
		FinderPath finderPath = _finderPathCountByAttivo;

		Object[] finderArgs = new Object[] {attivo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARME_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

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

	private static final String _FINDER_COLUMN_ATTIVO_ATTIVO_2 =
		"regolaAllarme.attivo = ?";

	public RegolaAllarmePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RegolaAllarme.class);

		setModelImplClass(RegolaAllarmeImpl.class);
		setModelPKClass(long.class);

		setTable(RegolaAllarmeTable.INSTANCE);
	}

	/**
	 * Caches the regola allarme in the entity cache if it is enabled.
	 *
	 * @param regolaAllarme the regola allarme
	 */
	@Override
	public void cacheResult(RegolaAllarme regolaAllarme) {
		entityCache.putResult(
			RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey(),
			regolaAllarme);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the regola allarmes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmes the regola allarmes
	 */
	@Override
	public void cacheResult(List<RegolaAllarme> regolaAllarmes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (regolaAllarmes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RegolaAllarme regolaAllarme : regolaAllarmes) {
			if (entityCache.getResult(
					RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKey()) ==
						null) {

				cacheResult(regolaAllarme);
			}
		}
	}

	/**
	 * Clears the cache for all regola allarmes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegolaAllarmeImpl.class);

		finderCache.clearCache(RegolaAllarmeImpl.class);
	}

	/**
	 * Clears the cache for the regola allarme.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegolaAllarme regolaAllarme) {
		entityCache.removeResult(RegolaAllarmeImpl.class, regolaAllarme);
	}

	@Override
	public void clearCache(List<RegolaAllarme> regolaAllarmes) {
		for (RegolaAllarme regolaAllarme : regolaAllarmes) {
			entityCache.removeResult(RegolaAllarmeImpl.class, regolaAllarme);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RegolaAllarmeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RegolaAllarmeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new regola allarme with the primary key. Does not add the regola allarme to the database.
	 *
	 * @param id the primary key for the new regola allarme
	 * @return the new regola allarme
	 */
	@Override
	public RegolaAllarme create(long id) {
		RegolaAllarme regolaAllarme = new RegolaAllarmeImpl();

		regolaAllarme.setNew(true);
		regolaAllarme.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		regolaAllarme.setUuid(uuid);

		return regolaAllarme;
	}

	/**
	 * Removes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme remove(long id) throws NoSuchRegolaAllarmeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme remove(Serializable primaryKey)
		throws NoSuchRegolaAllarmeException {

		Session session = null;

		try {
			session = openSession();

			RegolaAllarme regolaAllarme = (RegolaAllarme)session.get(
				RegolaAllarmeImpl.class, primaryKey);

			if (regolaAllarme == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegolaAllarmeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(regolaAllarme);
		}
		catch (NoSuchRegolaAllarmeException noSuchEntityException) {
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
	protected RegolaAllarme removeImpl(RegolaAllarme regolaAllarme) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regolaAllarme)) {
				regolaAllarme = (RegolaAllarme)session.get(
					RegolaAllarmeImpl.class, regolaAllarme.getPrimaryKeyObj());
			}

			if (regolaAllarme != null) {
				session.delete(regolaAllarme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (regolaAllarme != null) {
			clearCache(regolaAllarme);
		}

		return regolaAllarme;
	}

	@Override
	public RegolaAllarme updateImpl(RegolaAllarme regolaAllarme) {
		boolean isNew = regolaAllarme.isNew();

		if (!(regolaAllarme instanceof RegolaAllarmeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(regolaAllarme.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					regolaAllarme);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in regolaAllarme proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegolaAllarme implementation " +
					regolaAllarme.getClass());
		}

		RegolaAllarmeModelImpl regolaAllarmeModelImpl =
			(RegolaAllarmeModelImpl)regolaAllarme;

		if (Validator.isNull(regolaAllarme.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			regolaAllarme.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(regolaAllarme);
			}
			else {
				regolaAllarme = (RegolaAllarme)session.merge(regolaAllarme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RegolaAllarmeImpl.class, regolaAllarmeModelImpl, false, true);

		if (isNew) {
			regolaAllarme.setNew(false);
		}

		regolaAllarme.resetOriginalValues();

		return regolaAllarme;
	}

	/**
	 * Returns the regola allarme with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegolaAllarmeException {

		RegolaAllarme regolaAllarme = fetchByPrimaryKey(primaryKey);

		if (regolaAllarme == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegolaAllarmeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return regolaAllarme;
	}

	/**
	 * Returns the regola allarme with the primary key or throws a <code>NoSuchRegolaAllarmeException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the regola allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme, or <code>null</code> if a regola allarme with the primary key could not be found
	 */
	@Override
	public RegolaAllarme fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the regola allarmes.
	 *
	 * @return the regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of regola allarmes
	 */
	@Override
	public List<RegolaAllarme> findAll(
		int start, int end, OrderByComparator<RegolaAllarme> orderByComparator,
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

		List<RegolaAllarme> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarme>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REGOLAALLARME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REGOLAALLARME;

				sql = sql.concat(RegolaAllarmeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegolaAllarme>)QueryUtil.list(
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
	 * Removes all the regola allarmes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegolaAllarme regolaAllarme : findAll()) {
			remove(regolaAllarme);
		}
	}

	/**
	 * Returns the number of regola allarmes.
	 *
	 * @return the number of regola allarmes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REGOLAALLARME);

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
		return _SQL_SELECT_REGOLAALLARME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegolaAllarmeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the regola allarme persistence.
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

		_finderPathWithPaginationFindByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttivo",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"attivo"}, true);

		_finderPathWithoutPaginationFindByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttivo",
			new String[] {Boolean.class.getName()}, new String[] {"attivo"},
			true);

		_finderPathCountByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttivo",
			new String[] {Boolean.class.getName()}, new String[] {"attivo"},
			false);

		RegolaAllarmeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RegolaAllarmeUtil.setPersistence(null);

		entityCache.removeCache(RegolaAllarmeImpl.class.getName());
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

	private static final String _SQL_SELECT_REGOLAALLARME =
		"SELECT regolaAllarme FROM RegolaAllarme regolaAllarme";

	private static final String _SQL_SELECT_REGOLAALLARME_WHERE =
		"SELECT regolaAllarme FROM RegolaAllarme regolaAllarme WHERE ";

	private static final String _SQL_COUNT_REGOLAALLARME =
		"SELECT COUNT(regolaAllarme) FROM RegolaAllarme regolaAllarme";

	private static final String _SQL_COUNT_REGOLAALLARME_WHERE =
		"SELECT COUNT(regolaAllarme) FROM RegolaAllarme regolaAllarme WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "regolaAllarme.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegolaAllarme exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegolaAllarme exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegolaAllarmePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}