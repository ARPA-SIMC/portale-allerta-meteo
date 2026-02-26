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

import it.eng.bollettino.exception.NoSuchStazioneException;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneTable;
import it.eng.bollettino.model.impl.StazioneImpl;
import it.eng.bollettino.model.impl.StazioneModelImpl;
import it.eng.bollettino.service.persistence.StazionePersistence;
import it.eng.bollettino.service.persistence.StazioneUtil;
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
 * The persistence implementation for the stazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = StazionePersistence.class)
public class StazionePersistenceImpl
	extends BasePersistenceImpl<Stazione> implements StazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StazioneUtil</code> to access the stazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StazioneImpl.class.getName();

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
	 * Returns all the staziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching staziones
	 */
	@Override
	public List<Stazione> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	@Override
	public List<Stazione> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

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

		List<Stazione> list = null;

		if (useFinderCache) {
			list = (List<Stazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stazione stazione : list) {
					if (!uuid.equals(stazione.getUuid())) {
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

			sb.append(_SQL_SELECT_STAZIONE_WHERE);

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
				sb.append(StazioneModelImpl.ORDER_BY_JPQL);
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

				list = (List<Stazione>)QueryUtil.list(
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
	 * Returns the first stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByUuid_First(
			String uuid, OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByUuid_First(uuid, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the first stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByUuid_First(
		String uuid, OrderByComparator<Stazione> orderByComparator) {

		List<Stazione> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByUuid_Last(
			String uuid, OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByUuid_Last(uuid, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the last stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByUuid_Last(
		String uuid, OrderByComparator<Stazione> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Stazione> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione[] findByUuid_PrevAndNext(
			String id, String uuid,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		uuid = Objects.toString(uuid, "");

		Stazione stazione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Stazione[] array = new StazioneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, stazione, uuid, orderByComparator, true);

			array[1] = stazione;

			array[2] = getByUuid_PrevAndNext(
				session, stazione, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stazione getByUuid_PrevAndNext(
		Session session, Stazione stazione, String uuid,
		OrderByComparator<Stazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAZIONE_WHERE);

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
			sb.append(StazioneModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(stazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Stazione stazione :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stazione);
		}
	}

	/**
	 * Returns the number of staziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching staziones
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAZIONE_WHERE);

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
		"stazione.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(stazione.uuid IS NULL OR stazione.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the staziones where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching staziones
	 */
	@Override
	public List<Stazione> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	@Override
	public List<Stazione> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByName(
		String name, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByName(
		String name, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<Stazione> list = null;

		if (useFinderCache) {
			list = (List<Stazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stazione stazione : list) {
					if (!name.equals(stazione.getName())) {
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

			sb.append(_SQL_SELECT_STAZIONE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Stazione>)QueryUtil.list(
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
	 * Returns the first stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByName_First(
			String name, OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByName_First(name, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the first stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByName_First(
		String name, OrderByComparator<Stazione> orderByComparator) {

		List<Stazione> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByName_Last(
			String name, OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByName_Last(name, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the last stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByName_Last(
		String name, OrderByComparator<Stazione> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Stazione> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where name = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione[] findByName_PrevAndNext(
			String id, String name,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		name = Objects.toString(name, "");

		Stazione stazione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Stazione[] array = new StazioneImpl[3];

			array[0] = getByName_PrevAndNext(
				session, stazione, name, orderByComparator, true);

			array[1] = stazione;

			array[2] = getByName_PrevAndNext(
				session, stazione, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stazione getByName_PrevAndNext(
		Session session, Stazione stazione, String name,
		OrderByComparator<Stazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAZIONE_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
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
			sb.append(StazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staziones where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (Stazione stazione :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stazione);
		}
	}

	/**
	 * Returns the number of staziones where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching staziones
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAZIONE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"stazione.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(stazione.name IS NULL OR stazione.name = '')";

	private FinderPath _finderPathWithPaginationFindByBacino;
	private FinderPath _finderPathWithoutPaginationFindByBacino;
	private FinderPath _finderPathCountByBacino;

	/**
	 * Returns all the staziones where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @return the matching staziones
	 */
	@Override
	public List<Stazione> findByBacino(String idBasin) {
		return findByBacino(
			idBasin, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacino(String idBasin, int start, int end) {
		return findByBacino(idBasin, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacino(
		String idBasin, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return findByBacino(idBasin, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacino(
		String idBasin, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		idBasin = Objects.toString(idBasin, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBacino;
				finderArgs = new Object[] {idBasin};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBacino;
			finderArgs = new Object[] {idBasin, start, end, orderByComparator};
		}

		List<Stazione> list = null;

		if (useFinderCache) {
			list = (List<Stazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stazione stazione : list) {
					if (!idBasin.equals(stazione.getIdBasin())) {
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

			sb.append(_SQL_SELECT_STAZIONE_WHERE);

			boolean bindIdBasin = false;

			if (idBasin.isEmpty()) {
				sb.append(_FINDER_COLUMN_BACINO_IDBASIN_3);
			}
			else {
				bindIdBasin = true;

				sb.append(_FINDER_COLUMN_BACINO_IDBASIN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdBasin) {
					queryPos.add(idBasin);
				}

				list = (List<Stazione>)QueryUtil.list(
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
	 * Returns the first stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByBacino_First(
			String idBasin, OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByBacino_First(idBasin, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBasin=");
		sb.append(idBasin);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByBacino_First(
		String idBasin, OrderByComparator<Stazione> orderByComparator) {

		List<Stazione> list = findByBacino(idBasin, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByBacino_Last(
			String idBasin, OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByBacino_Last(idBasin, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBasin=");
		sb.append(idBasin);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByBacino_Last(
		String idBasin, OrderByComparator<Stazione> orderByComparator) {

		int count = countByBacino(idBasin);

		if (count == 0) {
			return null;
		}

		List<Stazione> list = findByBacino(
			idBasin, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione[] findByBacino_PrevAndNext(
			String id, String idBasin,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		idBasin = Objects.toString(idBasin, "");

		Stazione stazione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Stazione[] array = new StazioneImpl[3];

			array[0] = getByBacino_PrevAndNext(
				session, stazione, idBasin, orderByComparator, true);

			array[1] = stazione;

			array[2] = getByBacino_PrevAndNext(
				session, stazione, idBasin, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stazione getByBacino_PrevAndNext(
		Session session, Stazione stazione, String idBasin,
		OrderByComparator<Stazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAZIONE_WHERE);

		boolean bindIdBasin = false;

		if (idBasin.isEmpty()) {
			sb.append(_FINDER_COLUMN_BACINO_IDBASIN_3);
		}
		else {
			bindIdBasin = true;

			sb.append(_FINDER_COLUMN_BACINO_IDBASIN_2);
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
			sb.append(StazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdBasin) {
			queryPos.add(idBasin);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staziones where idBasin = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 */
	@Override
	public void removeByBacino(String idBasin) {
		for (Stazione stazione :
				findByBacino(
					idBasin, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stazione);
		}
	}

	/**
	 * Returns the number of staziones where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @return the number of matching staziones
	 */
	@Override
	public int countByBacino(String idBasin) {
		idBasin = Objects.toString(idBasin, "");

		FinderPath finderPath = _finderPathCountByBacino;

		Object[] finderArgs = new Object[] {idBasin};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAZIONE_WHERE);

			boolean bindIdBasin = false;

			if (idBasin.isEmpty()) {
				sb.append(_FINDER_COLUMN_BACINO_IDBASIN_3);
			}
			else {
				bindIdBasin = true;

				sb.append(_FINDER_COLUMN_BACINO_IDBASIN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdBasin) {
					queryPos.add(idBasin);
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

	private static final String _FINDER_COLUMN_BACINO_IDBASIN_2 =
		"stazione.idBasin = ?";

	private static final String _FINDER_COLUMN_BACINO_IDBASIN_3 =
		"(stazione.idBasin IS NULL OR stazione.idBasin = '')";

	private FinderPath _finderPathWithPaginationFindByBacinoAttivo;
	private FinderPath _finderPathWithoutPaginationFindByBacinoAttivo;
	private FinderPath _finderPathCountByBacinoAttivo;

	/**
	 * Returns all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @return the matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivo(String idBasin, boolean attivo) {
		return findByBacinoAttivo(
			idBasin, attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end) {

		return findByBacinoAttivo(idBasin, attivo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return findByBacinoAttivo(
			idBasin, attivo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		idBasin = Objects.toString(idBasin, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBacinoAttivo;
				finderArgs = new Object[] {idBasin, attivo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBacinoAttivo;
			finderArgs = new Object[] {
				idBasin, attivo, start, end, orderByComparator
			};
		}

		List<Stazione> list = null;

		if (useFinderCache) {
			list = (List<Stazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stazione stazione : list) {
					if (!idBasin.equals(stazione.getIdBasin()) ||
						(attivo != stazione.isAttivo())) {

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

			sb.append(_SQL_SELECT_STAZIONE_WHERE);

			boolean bindIdBasin = false;

			if (idBasin.isEmpty()) {
				sb.append(_FINDER_COLUMN_BACINOATTIVO_IDBASIN_3);
			}
			else {
				bindIdBasin = true;

				sb.append(_FINDER_COLUMN_BACINOATTIVO_IDBASIN_2);
			}

			sb.append(_FINDER_COLUMN_BACINOATTIVO_ATTIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdBasin) {
					queryPos.add(idBasin);
				}

				queryPos.add(attivo);

				list = (List<Stazione>)QueryUtil.list(
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
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByBacinoAttivo_First(
			String idBasin, boolean attivo,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByBacinoAttivo_First(
			idBasin, attivo, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBasin=");
		sb.append(idBasin);

		sb.append(", attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByBacinoAttivo_First(
		String idBasin, boolean attivo,
		OrderByComparator<Stazione> orderByComparator) {

		List<Stazione> list = findByBacinoAttivo(
			idBasin, attivo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByBacinoAttivo_Last(
			String idBasin, boolean attivo,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByBacinoAttivo_Last(
			idBasin, attivo, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBasin=");
		sb.append(idBasin);

		sb.append(", attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByBacinoAttivo_Last(
		String idBasin, boolean attivo,
		OrderByComparator<Stazione> orderByComparator) {

		int count = countByBacinoAttivo(idBasin, attivo);

		if (count == 0) {
			return null;
		}

		List<Stazione> list = findByBacinoAttivo(
			idBasin, attivo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione[] findByBacinoAttivo_PrevAndNext(
			String id, String idBasin, boolean attivo,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		idBasin = Objects.toString(idBasin, "");

		Stazione stazione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Stazione[] array = new StazioneImpl[3];

			array[0] = getByBacinoAttivo_PrevAndNext(
				session, stazione, idBasin, attivo, orderByComparator, true);

			array[1] = stazione;

			array[2] = getByBacinoAttivo_PrevAndNext(
				session, stazione, idBasin, attivo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stazione getByBacinoAttivo_PrevAndNext(
		Session session, Stazione stazione, String idBasin, boolean attivo,
		OrderByComparator<Stazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STAZIONE_WHERE);

		boolean bindIdBasin = false;

		if (idBasin.isEmpty()) {
			sb.append(_FINDER_COLUMN_BACINOATTIVO_IDBASIN_3);
		}
		else {
			bindIdBasin = true;

			sb.append(_FINDER_COLUMN_BACINOATTIVO_IDBASIN_2);
		}

		sb.append(_FINDER_COLUMN_BACINOATTIVO_ATTIVO_2);

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
			sb.append(StazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdBasin) {
			queryPos.add(idBasin);
		}

		queryPos.add(attivo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staziones where idBasin = &#63; and attivo = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 */
	@Override
	public void removeByBacinoAttivo(String idBasin, boolean attivo) {
		for (Stazione stazione :
				findByBacinoAttivo(
					idBasin, attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(stazione);
		}
	}

	/**
	 * Returns the number of staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @return the number of matching staziones
	 */
	@Override
	public int countByBacinoAttivo(String idBasin, boolean attivo) {
		idBasin = Objects.toString(idBasin, "");

		FinderPath finderPath = _finderPathCountByBacinoAttivo;

		Object[] finderArgs = new Object[] {idBasin, attivo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STAZIONE_WHERE);

			boolean bindIdBasin = false;

			if (idBasin.isEmpty()) {
				sb.append(_FINDER_COLUMN_BACINOATTIVO_IDBASIN_3);
			}
			else {
				bindIdBasin = true;

				sb.append(_FINDER_COLUMN_BACINOATTIVO_IDBASIN_2);
			}

			sb.append(_FINDER_COLUMN_BACINOATTIVO_ATTIVO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdBasin) {
					queryPos.add(idBasin);
				}

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

	private static final String _FINDER_COLUMN_BACINOATTIVO_IDBASIN_2 =
		"stazione.idBasin = ? AND ";

	private static final String _FINDER_COLUMN_BACINOATTIVO_IDBASIN_3 =
		"(stazione.idBasin IS NULL OR stazione.idBasin = '') AND ";

	private static final String _FINDER_COLUMN_BACINOATTIVO_ATTIVO_2 =
		"stazione.attivo = ?";

	private FinderPath _finderPathWithPaginationFindByBacinoAttivoIncluso;
	private FinderPath _finderPathWithoutPaginationFindByBacinoAttivoIncluso;
	private FinderPath _finderPathCountByBacinoAttivoIncluso;

	/**
	 * Returns all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @return the matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso) {

		return findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end) {

		return findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	@Override
	public List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		idBasin = Objects.toString(idBasin, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBacinoAttivoIncluso;
				finderArgs = new Object[] {idBasin, attivo, incluso};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBacinoAttivoIncluso;
			finderArgs = new Object[] {
				idBasin, attivo, incluso, start, end, orderByComparator
			};
		}

		List<Stazione> list = null;

		if (useFinderCache) {
			list = (List<Stazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stazione stazione : list) {
					if (!idBasin.equals(stazione.getIdBasin()) ||
						(attivo != stazione.isAttivo()) ||
						(incluso != stazione.isIncluso())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_STAZIONE_WHERE);

			boolean bindIdBasin = false;

			if (idBasin.isEmpty()) {
				sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_3);
			}
			else {
				bindIdBasin = true;

				sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_2);
			}

			sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_ATTIVO_2);

			sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_INCLUSO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdBasin) {
					queryPos.add(idBasin);
				}

				queryPos.add(attivo);

				queryPos.add(incluso);

				list = (List<Stazione>)QueryUtil.list(
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
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByBacinoAttivoIncluso_First(
			String idBasin, boolean attivo, boolean incluso,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByBacinoAttivoIncluso_First(
			idBasin, attivo, incluso, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBasin=");
		sb.append(idBasin);

		sb.append(", attivo=");
		sb.append(attivo);

		sb.append(", incluso=");
		sb.append(incluso);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByBacinoAttivoIncluso_First(
		String idBasin, boolean attivo, boolean incluso,
		OrderByComparator<Stazione> orderByComparator) {

		List<Stazione> list = findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	@Override
	public Stazione findByBacinoAttivoIncluso_Last(
			String idBasin, boolean attivo, boolean incluso,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByBacinoAttivoIncluso_Last(
			idBasin, attivo, incluso, orderByComparator);

		if (stazione != null) {
			return stazione;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBasin=");
		sb.append(idBasin);

		sb.append(", attivo=");
		sb.append(attivo);

		sb.append(", incluso=");
		sb.append(incluso);

		sb.append("}");

		throw new NoSuchStazioneException(sb.toString());
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	@Override
	public Stazione fetchByBacinoAttivoIncluso_Last(
		String idBasin, boolean attivo, boolean incluso,
		OrderByComparator<Stazione> orderByComparator) {

		int count = countByBacinoAttivoIncluso(idBasin, attivo, incluso);

		if (count == 0) {
			return null;
		}

		List<Stazione> list = findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione[] findByBacinoAttivoIncluso_PrevAndNext(
			String id, String idBasin, boolean attivo, boolean incluso,
			OrderByComparator<Stazione> orderByComparator)
		throws NoSuchStazioneException {

		idBasin = Objects.toString(idBasin, "");

		Stazione stazione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Stazione[] array = new StazioneImpl[3];

			array[0] = getByBacinoAttivoIncluso_PrevAndNext(
				session, stazione, idBasin, attivo, incluso, orderByComparator,
				true);

			array[1] = stazione;

			array[2] = getByBacinoAttivoIncluso_PrevAndNext(
				session, stazione, idBasin, attivo, incluso, orderByComparator,
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

	protected Stazione getByBacinoAttivoIncluso_PrevAndNext(
		Session session, Stazione stazione, String idBasin, boolean attivo,
		boolean incluso, OrderByComparator<Stazione> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_STAZIONE_WHERE);

		boolean bindIdBasin = false;

		if (idBasin.isEmpty()) {
			sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_3);
		}
		else {
			bindIdBasin = true;

			sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_2);
		}

		sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_ATTIVO_2);

		sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_INCLUSO_2);

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
			sb.append(StazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdBasin) {
			queryPos.add(idBasin);
		}

		queryPos.add(attivo);

		queryPos.add(incluso);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 */
	@Override
	public void removeByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso) {

		for (Stazione stazione :
				findByBacinoAttivoIncluso(
					idBasin, attivo, incluso, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(stazione);
		}
	}

	/**
	 * Returns the number of staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @return the number of matching staziones
	 */
	@Override
	public int countByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso) {

		idBasin = Objects.toString(idBasin, "");

		FinderPath finderPath = _finderPathCountByBacinoAttivoIncluso;

		Object[] finderArgs = new Object[] {idBasin, attivo, incluso};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_STAZIONE_WHERE);

			boolean bindIdBasin = false;

			if (idBasin.isEmpty()) {
				sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_3);
			}
			else {
				bindIdBasin = true;

				sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_2);
			}

			sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_ATTIVO_2);

			sb.append(_FINDER_COLUMN_BACINOATTIVOINCLUSO_INCLUSO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdBasin) {
					queryPos.add(idBasin);
				}

				queryPos.add(attivo);

				queryPos.add(incluso);

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

	private static final String _FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_2 =
		"stazione.idBasin = ? AND ";

	private static final String _FINDER_COLUMN_BACINOATTIVOINCLUSO_IDBASIN_3 =
		"(stazione.idBasin IS NULL OR stazione.idBasin = '') AND ";

	private static final String _FINDER_COLUMN_BACINOATTIVOINCLUSO_ATTIVO_2 =
		"stazione.attivo = ? AND ";

	private static final String _FINDER_COLUMN_BACINOATTIVOINCLUSO_INCLUSO_2 =
		"stazione.incluso = ?";

	public StazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Stazione.class);

		setModelImplClass(StazioneImpl.class);
		setModelPKClass(String.class);

		setTable(StazioneTable.INSTANCE);
	}

	/**
	 * Caches the stazione in the entity cache if it is enabled.
	 *
	 * @param stazione the stazione
	 */
	@Override
	public void cacheResult(Stazione stazione) {
		entityCache.putResult(
			StazioneImpl.class, stazione.getPrimaryKey(), stazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the staziones in the entity cache if it is enabled.
	 *
	 * @param staziones the staziones
	 */
	@Override
	public void cacheResult(List<Stazione> staziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (staziones.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Stazione stazione : staziones) {
			if (entityCache.getResult(
					StazioneImpl.class, stazione.getPrimaryKey()) == null) {

				cacheResult(stazione);
			}
		}
	}

	/**
	 * Clears the cache for all staziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StazioneImpl.class);

		finderCache.clearCache(StazioneImpl.class);
	}

	/**
	 * Clears the cache for the stazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Stazione stazione) {
		entityCache.removeResult(StazioneImpl.class, stazione);
	}

	@Override
	public void clearCache(List<Stazione> staziones) {
		for (Stazione stazione : staziones) {
			entityCache.removeResult(StazioneImpl.class, stazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new stazione with the primary key. Does not add the stazione to the database.
	 *
	 * @param id the primary key for the new stazione
	 * @return the new stazione
	 */
	@Override
	public Stazione create(String id) {
		Stazione stazione = new StazioneImpl();

		stazione.setNew(true);
		stazione.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		stazione.setUuid(uuid);

		return stazione;
	}

	/**
	 * Removes the stazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione that was removed
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione remove(String id) throws NoSuchStazioneException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stazione
	 * @return the stazione that was removed
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione remove(Serializable primaryKey)
		throws NoSuchStazioneException {

		Session session = null;

		try {
			session = openSession();

			Stazione stazione = (Stazione)session.get(
				StazioneImpl.class, primaryKey);

			if (stazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stazione);
		}
		catch (NoSuchStazioneException noSuchEntityException) {
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
	protected Stazione removeImpl(Stazione stazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stazione)) {
				stazione = (Stazione)session.get(
					StazioneImpl.class, stazione.getPrimaryKeyObj());
			}

			if (stazione != null) {
				session.delete(stazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stazione != null) {
			clearCache(stazione);
		}

		return stazione;
	}

	@Override
	public Stazione updateImpl(Stazione stazione) {
		boolean isNew = stazione.isNew();

		if (!(stazione instanceof StazioneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stazione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stazione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Stazione implementation " +
					stazione.getClass());
		}

		StazioneModelImpl stazioneModelImpl = (StazioneModelImpl)stazione;

		if (Validator.isNull(stazione.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			stazione.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stazione);
			}
			else {
				stazione = (Stazione)session.merge(stazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StazioneImpl.class, stazioneModelImpl, false, true);

		if (isNew) {
			stazione.setNew(false);
		}

		stazione.resetOriginalValues();

		return stazione;
	}

	/**
	 * Returns the stazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stazione
	 * @return the stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStazioneException {

		Stazione stazione = fetchByPrimaryKey(primaryKey);

		if (stazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stazione;
	}

	/**
	 * Returns the stazione with the primary key or throws a <code>NoSuchStazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione findByPrimaryKey(String id) throws NoSuchStazioneException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione, or <code>null</code> if a stazione with the primary key could not be found
	 */
	@Override
	public Stazione fetchByPrimaryKey(String id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the staziones.
	 *
	 * @return the staziones
	 */
	@Override
	public List<Stazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of staziones
	 */
	@Override
	public List<Stazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staziones
	 */
	@Override
	public List<Stazione> findAll(
		int start, int end, OrderByComparator<Stazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staziones
	 */
	@Override
	public List<Stazione> findAll(
		int start, int end, OrderByComparator<Stazione> orderByComparator,
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

		List<Stazione> list = null;

		if (useFinderCache) {
			list = (List<Stazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAZIONE;

				sql = sql.concat(StazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Stazione>)QueryUtil.list(
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
	 * Removes all the staziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Stazione stazione : findAll()) {
			remove(stazione);
		}
	}

	/**
	 * Returns the number of staziones.
	 *
	 * @return the number of staziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAZIONE);

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
		return _SQL_SELECT_STAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stazione persistence.
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

		_finderPathWithPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathWithPaginationFindByBacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBacino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idBasin"}, true);

		_finderPathWithoutPaginationFindByBacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBacino",
			new String[] {String.class.getName()}, new String[] {"idBasin"},
			true);

		_finderPathCountByBacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBacino",
			new String[] {String.class.getName()}, new String[] {"idBasin"},
			false);

		_finderPathWithPaginationFindByBacinoAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBacinoAttivo",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"idBasin", "attivo"}, true);

		_finderPathWithoutPaginationFindByBacinoAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBacinoAttivo",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"idBasin", "attivo"}, true);

		_finderPathCountByBacinoAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBacinoAttivo",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"idBasin", "attivo"}, false);

		_finderPathWithPaginationFindByBacinoAttivoIncluso = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBacinoAttivoIncluso",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idBasin", "attivo", "incluso"}, true);

		_finderPathWithoutPaginationFindByBacinoAttivoIncluso = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBacinoAttivoIncluso",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"idBasin", "attivo", "incluso"}, true);

		_finderPathCountByBacinoAttivoIncluso = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBacinoAttivoIncluso",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"idBasin", "attivo", "incluso"}, false);

		StazioneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		StazioneUtil.setPersistence(null);

		entityCache.removeCache(StazioneImpl.class.getName());
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

	private static final String _SQL_SELECT_STAZIONE =
		"SELECT stazione FROM Stazione stazione";

	private static final String _SQL_SELECT_STAZIONE_WHERE =
		"SELECT stazione FROM Stazione stazione WHERE ";

	private static final String _SQL_COUNT_STAZIONE =
		"SELECT COUNT(stazione) FROM Stazione stazione";

	private static final String _SQL_COUNT_STAZIONE_WHERE =
		"SELECT COUNT(stazione) FROM Stazione stazione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Stazione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Stazione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}