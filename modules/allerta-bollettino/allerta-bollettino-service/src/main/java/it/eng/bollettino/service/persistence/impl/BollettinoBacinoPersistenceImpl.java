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

import it.eng.bollettino.exception.NoSuchBollettinoBacinoException;
import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.model.BollettinoBacinoTable;
import it.eng.bollettino.model.impl.BollettinoBacinoImpl;
import it.eng.bollettino.model.impl.BollettinoBacinoModelImpl;
import it.eng.bollettino.service.persistence.BollettinoBacinoPersistence;
import it.eng.bollettino.service.persistence.BollettinoBacinoUtil;
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
 * The persistence implementation for the bollettino bacino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = BollettinoBacinoPersistence.class)
public class BollettinoBacinoPersistenceImpl
	extends BasePersistenceImpl<BollettinoBacino>
	implements BollettinoBacinoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoBacinoUtil</code> to access the bollettino bacino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoBacinoImpl.class.getName();

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
	 * Returns all the bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		List<BollettinoBacino> list = null;

		if (useFinderCache) {
			list = (List<BollettinoBacino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoBacino bollettinoBacino : list) {
					if (!uuid.equals(bollettinoBacino.getUuid())) {
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

			sb.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

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
				sb.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
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

				list = (List<BollettinoBacino>)QueryUtil.list(
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
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByUuid_First(
			String uuid, OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByUuid_First(
			uuid, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoBacinoException(sb.toString());
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoBacino> orderByComparator) {

		List<BollettinoBacino> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByUuid_Last(
			String uuid, OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoBacinoException(sb.toString());
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoBacino> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BollettinoBacino> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		uuid = Objects.toString(uuid, "");

		BollettinoBacino bollettinoBacino = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoBacino[] array = new BollettinoBacinoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bollettinoBacino, uuid, orderByComparator, true);

			array[1] = bollettinoBacino;

			array[2] = getByUuid_PrevAndNext(
				session, bollettinoBacino, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BollettinoBacino getByUuid_PrevAndNext(
		Session session, BollettinoBacino bollettinoBacino, String uuid,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		sb.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

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
			sb.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
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
						bollettinoBacino)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BollettinoBacino> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino bacinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BollettinoBacino bollettinoBacino :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoBacino);
		}
	}

	/**
	 * Returns the number of bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino bacinos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINOBACINO_WHERE);

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
		"bollettinoBacino.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bollettinoBacino.uuid IS NULL OR bollettinoBacino.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByBollettino;
	private FinderPath _finderPathWithoutPaginationFindByBollettino;
	private FinderPath _finderPathCountByBollettino;

	/**
	 * Returns all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(long idBollettino) {
		return findByBollettino(
			idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end) {

		return findByBollettino(idBollettino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return findByBollettino(
			idBollettino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		List<BollettinoBacino> list = null;

		if (useFinderCache) {
			list = (List<BollettinoBacino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoBacino bollettinoBacino : list) {
					if (idBollettino != bollettinoBacino.getIdBollettino()) {
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

			sb.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

			sb.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idBollettino);

				list = (List<BollettinoBacino>)QueryUtil.list(
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
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByBollettino_First(
			idBollettino, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBollettino=");
		sb.append(idBollettino);

		sb.append("}");

		throw new NoSuchBollettinoBacinoException(sb.toString());
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		List<BollettinoBacino> list = findByBollettino(
			idBollettino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByBollettino_Last(
			idBollettino, orderByComparator);

		if (bollettinoBacino != null) {
			return bollettinoBacino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBollettino=");
		sb.append(idBollettino);

		sb.append("}");

		throw new NoSuchBollettinoBacinoException(sb.toString());
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	@Override
	public BollettinoBacino fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		int count = countByBollettino(idBollettino);

		if (count == 0) {
			return null;
		}

		List<BollettinoBacino> list = findByBollettino(
			idBollettino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoBacino[] array = new BollettinoBacinoImpl[3];

			array[0] = getByBollettino_PrevAndNext(
				session, bollettinoBacino, idBollettino, orderByComparator,
				true);

			array[1] = bollettinoBacino;

			array[2] = getByBollettino_PrevAndNext(
				session, bollettinoBacino, idBollettino, orderByComparator,
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

	protected BollettinoBacino getByBollettino_PrevAndNext(
		Session session, BollettinoBacino bollettinoBacino, long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		sb.append(_SQL_SELECT_BOLLETTINOBACINO_WHERE);

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
			sb.append(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
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
						bollettinoBacino)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BollettinoBacino> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino bacinos where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	@Override
	public void removeByBollettino(long idBollettino) {
		for (BollettinoBacino bollettinoBacino :
				findByBollettino(
					idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoBacino);
		}
	}

	/**
	 * Returns the number of bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino bacinos
	 */
	@Override
	public int countByBollettino(long idBollettino) {
		FinderPath finderPath = _finderPathCountByBollettino;

		Object[] finderArgs = new Object[] {idBollettino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINOBACINO_WHERE);

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
		"bollettinoBacino.idBollettino = ?";

	public BollettinoBacinoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BollettinoBacino.class);

		setModelImplClass(BollettinoBacinoImpl.class);
		setModelPKClass(long.class);

		setTable(BollettinoBacinoTable.INSTANCE);
	}

	/**
	 * Caches the bollettino bacino in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 */
	@Override
	public void cacheResult(BollettinoBacino bollettinoBacino) {
		entityCache.putResult(
			BollettinoBacinoImpl.class, bollettinoBacino.getPrimaryKey(),
			bollettinoBacino);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bollettino bacinos in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacinos the bollettino bacinos
	 */
	@Override
	public void cacheResult(List<BollettinoBacino> bollettinoBacinos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bollettinoBacinos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BollettinoBacino bollettinoBacino : bollettinoBacinos) {
			if (entityCache.getResult(
					BollettinoBacinoImpl.class,
					bollettinoBacino.getPrimaryKey()) == null) {

				cacheResult(bollettinoBacino);
			}
		}
	}

	/**
	 * Clears the cache for all bollettino bacinos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoBacinoImpl.class);

		finderCache.clearCache(BollettinoBacinoImpl.class);
	}

	/**
	 * Clears the cache for the bollettino bacino.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoBacino bollettinoBacino) {
		entityCache.removeResult(BollettinoBacinoImpl.class, bollettinoBacino);
	}

	@Override
	public void clearCache(List<BollettinoBacino> bollettinoBacinos) {
		for (BollettinoBacino bollettinoBacino : bollettinoBacinos) {
			entityCache.removeResult(
				BollettinoBacinoImpl.class, bollettinoBacino);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BollettinoBacinoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BollettinoBacinoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bollettino bacino with the primary key. Does not add the bollettino bacino to the database.
	 *
	 * @param id the primary key for the new bollettino bacino
	 * @return the new bollettino bacino
	 */
	@Override
	public BollettinoBacino create(long id) {
		BollettinoBacino bollettinoBacino = new BollettinoBacinoImpl();

		bollettinoBacino.setNew(true);
		bollettinoBacino.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		bollettinoBacino.setUuid(uuid);

		return bollettinoBacino;
	}

	/**
	 * Removes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino remove(long id)
		throws NoSuchBollettinoBacinoException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino remove(Serializable primaryKey)
		throws NoSuchBollettinoBacinoException {

		Session session = null;

		try {
			session = openSession();

			BollettinoBacino bollettinoBacino = (BollettinoBacino)session.get(
				BollettinoBacinoImpl.class, primaryKey);

			if (bollettinoBacino == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoBacinoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoBacino);
		}
		catch (NoSuchBollettinoBacinoException noSuchEntityException) {
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
	protected BollettinoBacino removeImpl(BollettinoBacino bollettinoBacino) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoBacino)) {
				bollettinoBacino = (BollettinoBacino)session.get(
					BollettinoBacinoImpl.class,
					bollettinoBacino.getPrimaryKeyObj());
			}

			if (bollettinoBacino != null) {
				session.delete(bollettinoBacino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoBacino != null) {
			clearCache(bollettinoBacino);
		}

		return bollettinoBacino;
	}

	@Override
	public BollettinoBacino updateImpl(BollettinoBacino bollettinoBacino) {
		boolean isNew = bollettinoBacino.isNew();

		if (!(bollettinoBacino instanceof BollettinoBacinoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettinoBacino.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bollettinoBacino);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettinoBacino proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BollettinoBacino implementation " +
					bollettinoBacino.getClass());
		}

		BollettinoBacinoModelImpl bollettinoBacinoModelImpl =
			(BollettinoBacinoModelImpl)bollettinoBacino;

		if (Validator.isNull(bollettinoBacino.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bollettinoBacino.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bollettinoBacino);
			}
			else {
				bollettinoBacino = (BollettinoBacino)session.merge(
					bollettinoBacino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BollettinoBacinoImpl.class, bollettinoBacinoModelImpl, false, true);

		if (isNew) {
			bollettinoBacino.setNew(false);
		}

		bollettinoBacino.resetOriginalValues();

		return bollettinoBacino;
	}

	/**
	 * Returns the bollettino bacino with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoBacinoException {

		BollettinoBacino bollettinoBacino = fetchByPrimaryKey(primaryKey);

		if (bollettinoBacino == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoBacinoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoBacino;
	}

	/**
	 * Returns the bollettino bacino with the primary key or throws a <code>NoSuchBollettinoBacinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino findByPrimaryKey(long id)
		throws NoSuchBollettinoBacinoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bollettino bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino, or <code>null</code> if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public BollettinoBacino fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the bollettino bacinos.
	 *
	 * @return the bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll(
		int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettino bacinos
	 */
	@Override
	public List<BollettinoBacino> findAll(
		int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
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

		List<BollettinoBacino> list = null;

		if (useFinderCache) {
			list = (List<BollettinoBacino>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOLLETTINOBACINO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOBACINO;

				sql = sql.concat(BollettinoBacinoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BollettinoBacino>)QueryUtil.list(
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
	 * Removes all the bollettino bacinos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoBacino bollettinoBacino : findAll()) {
			remove(bollettinoBacino);
		}
	}

	/**
	 * Returns the number of bollettino bacinos.
	 *
	 * @return the number of bollettino bacinos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOLLETTINOBACINO);

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
		return _SQL_SELECT_BOLLETTINOBACINO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BollettinoBacinoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino bacino persistence.
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

		BollettinoBacinoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BollettinoBacinoUtil.setPersistence(null);

		entityCache.removeCache(BollettinoBacinoImpl.class.getName());
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

	private static final String _SQL_SELECT_BOLLETTINOBACINO =
		"SELECT bollettinoBacino FROM BollettinoBacino bollettinoBacino";

	private static final String _SQL_SELECT_BOLLETTINOBACINO_WHERE =
		"SELECT bollettinoBacino FROM BollettinoBacino bollettinoBacino WHERE ";

	private static final String _SQL_COUNT_BOLLETTINOBACINO =
		"SELECT COUNT(bollettinoBacino) FROM BollettinoBacino bollettinoBacino";

	private static final String _SQL_COUNT_BOLLETTINOBACINO_WHERE =
		"SELECT COUNT(bollettinoBacino) FROM BollettinoBacino bollettinoBacino WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoBacino.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoBacino exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BollettinoBacino exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoBacinoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}