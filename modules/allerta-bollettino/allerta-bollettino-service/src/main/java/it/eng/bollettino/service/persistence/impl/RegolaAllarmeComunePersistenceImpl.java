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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException;
import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.model.RegolaAllarmeComuneTable;
import it.eng.bollettino.model.impl.RegolaAllarmeComuneImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl;
import it.eng.bollettino.service.persistence.RegolaAllarmeComunePersistence;
import it.eng.bollettino.service.persistence.RegolaAllarmeComuneUtil;
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
 * The persistence implementation for the regola allarme comune service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = RegolaAllarmeComunePersistence.class)
public class RegolaAllarmeComunePersistenceImpl
	extends BasePersistenceImpl<RegolaAllarmeComune>
	implements RegolaAllarmeComunePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegolaAllarmeComuneUtil</code> to access the regola allarme comune persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegolaAllarmeComuneImpl.class.getName();

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
	 * Returns all the regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		List<RegolaAllarmeComune> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeComune regolaAllarmeComune : list) {
					if (!uuid.equals(regolaAllarmeComune.getUuid())) {
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

			sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

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
				sb.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByUuid_First(
			String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByUuid_First(
			uuid, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegolaAllarmeComuneException(sb.toString());
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByUuid_First(
		String uuid, OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		List<RegolaAllarmeComune> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByUuid_Last(
			String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByUuid_Last(
			uuid, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegolaAllarmeComuneException(sb.toString());
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByUuid_Last(
		String uuid, OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeComune> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		uuid = Objects.toString(uuid, "");

		RegolaAllarmeComune regolaAllarmeComune = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune[] array = new RegolaAllarmeComuneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, regolaAllarmeComune, uuid, orderByComparator, true);

			array[1] = regolaAllarmeComune;

			array[2] = getByUuid_PrevAndNext(
				session, regolaAllarmeComune, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegolaAllarmeComune getByUuid_PrevAndNext(
		Session session, RegolaAllarmeComune regolaAllarmeComune, String uuid,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

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
			sb.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
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
						regolaAllarmeComune)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeComune> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme comunes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegolaAllarmeComune regolaAllarmeComune :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme comunes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARMECOMUNE_WHERE);

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
		"regolaAllarmeComune.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(regolaAllarmeComune.uuid IS NULL OR regolaAllarmeComune.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByRegola;
	private FinderPath _finderPathWithoutPaginationFindByRegola;
	private FinderPath _finderPathCountByRegola;

	/**
	 * Returns all the regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(long idRegola) {
		return findByRegola(
			idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end) {

		return findByRegola(idRegola, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findByRegola(idRegola, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean useFinderCache) {

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

		List<RegolaAllarmeComune> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeComune regolaAllarmeComune : list) {
					if (idRegola != regolaAllarmeComune.getIdRegola()) {
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

			sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

			sb.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idRegola);

				list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByRegola_First(
			long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByRegola_First(
			idRegola, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegola=");
		sb.append(idRegola);

		sb.append("}");

		throw new NoSuchRegolaAllarmeComuneException(sb.toString());
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByRegola_First(
		long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		List<RegolaAllarmeComune> list = findByRegola(
			idRegola, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByRegola_Last(
			long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByRegola_Last(
			idRegola, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegola=");
		sb.append(idRegola);

		sb.append("}");

		throw new NoSuchRegolaAllarmeComuneException(sb.toString());
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByRegola_Last(
		long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		int count = countByRegola(idRegola);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeComune> list = findByRegola(
			idRegola, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune[] findByRegola_PrevAndNext(
			long id, long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune[] array = new RegolaAllarmeComuneImpl[3];

			array[0] = getByRegola_PrevAndNext(
				session, regolaAllarmeComune, idRegola, orderByComparator,
				true);

			array[1] = regolaAllarmeComune;

			array[2] = getByRegola_PrevAndNext(
				session, regolaAllarmeComune, idRegola, orderByComparator,
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

	protected RegolaAllarmeComune getByRegola_PrevAndNext(
		Session session, RegolaAllarmeComune regolaAllarmeComune, long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

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
			sb.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(idRegola);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						regolaAllarmeComune)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeComune> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme comunes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	@Override
	public void removeByRegola(long idRegola) {
		for (RegolaAllarmeComune regolaAllarmeComune :
				findByRegola(
					idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme comunes
	 */
	@Override
	public int countByRegola(long idRegola) {
		FinderPath finderPath = _finderPathCountByRegola;

		Object[] finderArgs = new Object[] {idRegola};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARMECOMUNE_WHERE);

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
		"regolaAllarmeComune.idRegola = ?";

	private FinderPath _finderPathWithPaginationFindByComune;
	private FinderPath _finderPathWithoutPaginationFindByComune;
	private FinderPath _finderPathCountByComune;

	/**
	 * Returns all the regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(long idComune) {
		return findByComune(
			idComune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end) {

		return findByComune(idComune, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findByComune(idComune, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByComune;
				finderArgs = new Object[] {idComune};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByComune;
			finderArgs = new Object[] {idComune, start, end, orderByComparator};
		}

		List<RegolaAllarmeComune> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeComune regolaAllarmeComune : list) {
					if (idComune != regolaAllarmeComune.getIdComune()) {
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

			sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

			sb.append(_FINDER_COLUMN_COMUNE_IDCOMUNE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idComune);

				list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByComune_First(
			long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByComune_First(
			idComune, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idComune=");
		sb.append(idComune);

		sb.append("}");

		throw new NoSuchRegolaAllarmeComuneException(sb.toString());
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByComune_First(
		long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		List<RegolaAllarmeComune> list = findByComune(
			idComune, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune findByComune_Last(
			long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByComune_Last(
			idComune, orderByComparator);

		if (regolaAllarmeComune != null) {
			return regolaAllarmeComune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idComune=");
		sb.append(idComune);

		sb.append("}");

		throw new NoSuchRegolaAllarmeComuneException(sb.toString());
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByComune_Last(
		long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		int count = countByComune(idComune);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeComune> list = findByComune(
			idComune, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune[] findByComune_PrevAndNext(
			long id, long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune[] array = new RegolaAllarmeComuneImpl[3];

			array[0] = getByComune_PrevAndNext(
				session, regolaAllarmeComune, idComune, orderByComparator,
				true);

			array[1] = regolaAllarmeComune;

			array[2] = getByComune_PrevAndNext(
				session, regolaAllarmeComune, idComune, orderByComparator,
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

	protected RegolaAllarmeComune getByComune_PrevAndNext(
		Session session, RegolaAllarmeComune regolaAllarmeComune, long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE_WHERE);

		sb.append(_FINDER_COLUMN_COMUNE_IDCOMUNE_2);

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
			sb.append(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(idComune);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						regolaAllarmeComune)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeComune> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme comunes where idComune = &#63; from the database.
	 *
	 * @param idComune the id comune
	 */
	@Override
	public void removeByComune(long idComune) {
		for (RegolaAllarmeComune regolaAllarmeComune :
				findByComune(
					idComune, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the number of matching regola allarme comunes
	 */
	@Override
	public int countByComune(long idComune) {
		FinderPath finderPath = _finderPathCountByComune;

		Object[] finderArgs = new Object[] {idComune};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARMECOMUNE_WHERE);

			sb.append(_FINDER_COLUMN_COMUNE_IDCOMUNE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idComune);

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

	private static final String _FINDER_COLUMN_COMUNE_IDCOMUNE_2 =
		"regolaAllarmeComune.idComune = ?";

	public RegolaAllarmeComunePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RegolaAllarmeComune.class);

		setModelImplClass(RegolaAllarmeComuneImpl.class);
		setModelPKClass(long.class);

		setTable(RegolaAllarmeComuneTable.INSTANCE);
	}

	/**
	 * Caches the regola allarme comune in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 */
	@Override
	public void cacheResult(RegolaAllarmeComune regolaAllarmeComune) {
		entityCache.putResult(
			RegolaAllarmeComuneImpl.class, regolaAllarmeComune.getPrimaryKey(),
			regolaAllarmeComune);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the regola allarme comunes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComunes the regola allarme comunes
	 */
	@Override
	public void cacheResult(List<RegolaAllarmeComune> regolaAllarmeComunes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (regolaAllarmeComunes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RegolaAllarmeComune regolaAllarmeComune : regolaAllarmeComunes) {
			if (entityCache.getResult(
					RegolaAllarmeComuneImpl.class,
					regolaAllarmeComune.getPrimaryKey()) == null) {

				cacheResult(regolaAllarmeComune);
			}
		}
	}

	/**
	 * Clears the cache for all regola allarme comunes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegolaAllarmeComuneImpl.class);

		finderCache.clearCache(RegolaAllarmeComuneImpl.class);
	}

	/**
	 * Clears the cache for the regola allarme comune.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegolaAllarmeComune regolaAllarmeComune) {
		entityCache.removeResult(
			RegolaAllarmeComuneImpl.class, regolaAllarmeComune);
	}

	@Override
	public void clearCache(List<RegolaAllarmeComune> regolaAllarmeComunes) {
		for (RegolaAllarmeComune regolaAllarmeComune : regolaAllarmeComunes) {
			entityCache.removeResult(
				RegolaAllarmeComuneImpl.class, regolaAllarmeComune);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RegolaAllarmeComuneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RegolaAllarmeComuneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new regola allarme comune with the primary key. Does not add the regola allarme comune to the database.
	 *
	 * @param id the primary key for the new regola allarme comune
	 * @return the new regola allarme comune
	 */
	@Override
	public RegolaAllarmeComune create(long id) {
		RegolaAllarmeComune regolaAllarmeComune = new RegolaAllarmeComuneImpl();

		regolaAllarmeComune.setNew(true);
		regolaAllarmeComune.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		regolaAllarmeComune.setUuid(uuid);

		return regolaAllarmeComune;
	}

	/**
	 * Removes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune remove(long id)
		throws NoSuchRegolaAllarmeComuneException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune remove(Serializable primaryKey)
		throws NoSuchRegolaAllarmeComuneException {

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeComune regolaAllarmeComune =
				(RegolaAllarmeComune)session.get(
					RegolaAllarmeComuneImpl.class, primaryKey);

			if (regolaAllarmeComune == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegolaAllarmeComuneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(regolaAllarmeComune);
		}
		catch (NoSuchRegolaAllarmeComuneException noSuchEntityException) {
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
	protected RegolaAllarmeComune removeImpl(
		RegolaAllarmeComune regolaAllarmeComune) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regolaAllarmeComune)) {
				regolaAllarmeComune = (RegolaAllarmeComune)session.get(
					RegolaAllarmeComuneImpl.class,
					regolaAllarmeComune.getPrimaryKeyObj());
			}

			if (regolaAllarmeComune != null) {
				session.delete(regolaAllarmeComune);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (regolaAllarmeComune != null) {
			clearCache(regolaAllarmeComune);
		}

		return regolaAllarmeComune;
	}

	@Override
	public RegolaAllarmeComune updateImpl(
		RegolaAllarmeComune regolaAllarmeComune) {

		boolean isNew = regolaAllarmeComune.isNew();

		if (!(regolaAllarmeComune instanceof RegolaAllarmeComuneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(regolaAllarmeComune.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					regolaAllarmeComune);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in regolaAllarmeComune proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegolaAllarmeComune implementation " +
					regolaAllarmeComune.getClass());
		}

		RegolaAllarmeComuneModelImpl regolaAllarmeComuneModelImpl =
			(RegolaAllarmeComuneModelImpl)regolaAllarmeComune;

		if (Validator.isNull(regolaAllarmeComune.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			regolaAllarmeComune.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(regolaAllarmeComune);
			}
			else {
				regolaAllarmeComune = (RegolaAllarmeComune)session.merge(
					regolaAllarmeComune);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RegolaAllarmeComuneImpl.class, regolaAllarmeComuneModelImpl, false,
			true);

		if (isNew) {
			regolaAllarmeComune.setNew(false);
		}

		regolaAllarmeComune.resetOriginalValues();

		return regolaAllarmeComune;
	}

	/**
	 * Returns the regola allarme comune with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegolaAllarmeComuneException {

		RegolaAllarmeComune regolaAllarmeComune = fetchByPrimaryKey(primaryKey);

		if (regolaAllarmeComune == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegolaAllarmeComuneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return regolaAllarmeComune;
	}

	/**
	 * Returns the regola allarme comune with the primary key or throws a <code>NoSuchRegolaAllarmeComuneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeComuneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the regola allarme comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune, or <code>null</code> if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeComune fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the regola allarme comunes.
	 *
	 * @return the regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of regola allarme comunes
	 */
	@Override
	public List<RegolaAllarmeComune> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
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

		List<RegolaAllarmeComune> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeComune>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REGOLAALLARMECOMUNE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REGOLAALLARMECOMUNE;

				sql = sql.concat(RegolaAllarmeComuneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegolaAllarmeComune>)QueryUtil.list(
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
	 * Removes all the regola allarme comunes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegolaAllarmeComune regolaAllarmeComune : findAll()) {
			remove(regolaAllarmeComune);
		}
	}

	/**
	 * Returns the number of regola allarme comunes.
	 *
	 * @return the number of regola allarme comunes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_REGOLAALLARMECOMUNE);

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
		return _SQL_SELECT_REGOLAALLARMECOMUNE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegolaAllarmeComuneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the regola allarme comune persistence.
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

		_finderPathWithPaginationFindByComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComune",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idComune"}, true);

		_finderPathWithoutPaginationFindByComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByComune",
			new String[] {Long.class.getName()}, new String[] {"idComune"},
			true);

		_finderPathCountByComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByComune",
			new String[] {Long.class.getName()}, new String[] {"idComune"},
			false);

		RegolaAllarmeComuneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RegolaAllarmeComuneUtil.setPersistence(null);

		entityCache.removeCache(RegolaAllarmeComuneImpl.class.getName());
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

	private static final String _SQL_SELECT_REGOLAALLARMECOMUNE =
		"SELECT regolaAllarmeComune FROM RegolaAllarmeComune regolaAllarmeComune";

	private static final String _SQL_SELECT_REGOLAALLARMECOMUNE_WHERE =
		"SELECT regolaAllarmeComune FROM RegolaAllarmeComune regolaAllarmeComune WHERE ";

	private static final String _SQL_COUNT_REGOLAALLARMECOMUNE =
		"SELECT COUNT(regolaAllarmeComune) FROM RegolaAllarmeComune regolaAllarmeComune";

	private static final String _SQL_COUNT_REGOLAALLARMECOMUNE_WHERE =
		"SELECT COUNT(regolaAllarmeComune) FROM RegolaAllarmeComune regolaAllarmeComune WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "regolaAllarmeComune.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegolaAllarmeComune exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegolaAllarmeComune exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegolaAllarmeComunePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}