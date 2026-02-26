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

import it.eng.bollettino.exception.NoSuchBollettinoIconaException;
import it.eng.bollettino.model.BollettinoIcona;
import it.eng.bollettino.model.BollettinoIconaTable;
import it.eng.bollettino.model.impl.BollettinoIconaImpl;
import it.eng.bollettino.model.impl.BollettinoIconaModelImpl;
import it.eng.bollettino.service.persistence.BollettinoIconaPersistence;
import it.eng.bollettino.service.persistence.BollettinoIconaUtil;
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
 * The persistence implementation for the bollettino icona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = BollettinoIconaPersistence.class)
public class BollettinoIconaPersistenceImpl
	extends BasePersistenceImpl<BollettinoIcona>
	implements BollettinoIconaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BollettinoIconaUtil</code> to access the bollettino icona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BollettinoIconaImpl.class.getName();

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
	 * Returns all the bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		List<BollettinoIcona> list = null;

		if (useFinderCache) {
			list = (List<BollettinoIcona>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoIcona bollettinoIcona : list) {
					if (!uuid.equals(bollettinoIcona.getUuid())) {
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

			sb.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

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
				sb.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
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

				list = (List<BollettinoIcona>)QueryUtil.list(
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
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByUuid_First(
			String uuid, OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByUuid_First(
			uuid, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoIconaException(sb.toString());
	}

	/**
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoIcona> orderByComparator) {

		List<BollettinoIcona> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByUuid_Last(
			String uuid, OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBollettinoIconaException(sb.toString());
	}

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoIcona> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BollettinoIcona> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		uuid = Objects.toString(uuid, "");

		BollettinoIcona bollettinoIcona = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoIcona[] array = new BollettinoIconaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bollettinoIcona, uuid, orderByComparator, true);

			array[1] = bollettinoIcona;

			array[2] = getByUuid_PrevAndNext(
				session, bollettinoIcona, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BollettinoIcona getByUuid_PrevAndNext(
		Session session, BollettinoIcona bollettinoIcona, String uuid,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		sb.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

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
			sb.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
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
						bollettinoIcona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BollettinoIcona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BollettinoIcona bollettinoIcona :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoIcona);
		}
	}

	/**
	 * Returns the number of bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino iconas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINOICONA_WHERE);

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
		"bollettinoIcona.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bollettinoIcona.uuid IS NULL OR bollettinoIcona.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByBollettino;
	private FinderPath _finderPathWithoutPaginationFindByBollettino;
	private FinderPath _finderPathCountByBollettino;

	/**
	 * Returns all the bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(long idBollettino) {
		return findByBollettino(
			idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end) {

		return findByBollettino(idBollettino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return findByBollettino(
			idBollettino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		List<BollettinoIcona> list = null;

		if (useFinderCache) {
			list = (List<BollettinoIcona>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BollettinoIcona bollettinoIcona : list) {
					if (idBollettino != bollettinoIcona.getIdBollettino()) {
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

			sb.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

			sb.append(_FINDER_COLUMN_BOLLETTINO_IDBOLLETTINO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idBollettino);

				list = (List<BollettinoIcona>)QueryUtil.list(
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
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByBollettino_First(
			idBollettino, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBollettino=");
		sb.append(idBollettino);

		sb.append("}");

		throw new NoSuchBollettinoIconaException(sb.toString());
	}

	/**
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		List<BollettinoIcona> list = findByBollettino(
			idBollettino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByBollettino_Last(
			idBollettino, orderByComparator);

		if (bollettinoIcona != null) {
			return bollettinoIcona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idBollettino=");
		sb.append(idBollettino);

		sb.append("}");

		throw new NoSuchBollettinoIconaException(sb.toString());
	}

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	@Override
	public BollettinoIcona fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		int count = countByBollettino(idBollettino);

		if (count == 0) {
			return null;
		}

		List<BollettinoIcona> list = findByBollettino(
			idBollettino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BollettinoIcona[] array = new BollettinoIconaImpl[3];

			array[0] = getByBollettino_PrevAndNext(
				session, bollettinoIcona, idBollettino, orderByComparator,
				true);

			array[1] = bollettinoIcona;

			array[2] = getByBollettino_PrevAndNext(
				session, bollettinoIcona, idBollettino, orderByComparator,
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

	protected BollettinoIcona getByBollettino_PrevAndNext(
		Session session, BollettinoIcona bollettinoIcona, long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		sb.append(_SQL_SELECT_BOLLETTINOICONA_WHERE);

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
			sb.append(BollettinoIconaModelImpl.ORDER_BY_JPQL);
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
						bollettinoIcona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BollettinoIcona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bollettino iconas where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	@Override
	public void removeByBollettino(long idBollettino) {
		for (BollettinoIcona bollettinoIcona :
				findByBollettino(
					idBollettino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bollettinoIcona);
		}
	}

	/**
	 * Returns the number of bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino iconas
	 */
	@Override
	public int countByBollettino(long idBollettino) {
		FinderPath finderPath = _finderPathCountByBollettino;

		Object[] finderArgs = new Object[] {idBollettino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOLLETTINOICONA_WHERE);

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
		"bollettinoIcona.idBollettino = ?";

	public BollettinoIconaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BollettinoIcona.class);

		setModelImplClass(BollettinoIconaImpl.class);
		setModelPKClass(long.class);

		setTable(BollettinoIconaTable.INSTANCE);
	}

	/**
	 * Caches the bollettino icona in the entity cache if it is enabled.
	 *
	 * @param bollettinoIcona the bollettino icona
	 */
	@Override
	public void cacheResult(BollettinoIcona bollettinoIcona) {
		entityCache.putResult(
			BollettinoIconaImpl.class, bollettinoIcona.getPrimaryKey(),
			bollettinoIcona);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bollettino iconas in the entity cache if it is enabled.
	 *
	 * @param bollettinoIconas the bollettino iconas
	 */
	@Override
	public void cacheResult(List<BollettinoIcona> bollettinoIconas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bollettinoIconas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BollettinoIcona bollettinoIcona : bollettinoIconas) {
			if (entityCache.getResult(
					BollettinoIconaImpl.class,
					bollettinoIcona.getPrimaryKey()) == null) {

				cacheResult(bollettinoIcona);
			}
		}
	}

	/**
	 * Clears the cache for all bollettino iconas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BollettinoIconaImpl.class);

		finderCache.clearCache(BollettinoIconaImpl.class);
	}

	/**
	 * Clears the cache for the bollettino icona.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BollettinoIcona bollettinoIcona) {
		entityCache.removeResult(BollettinoIconaImpl.class, bollettinoIcona);
	}

	@Override
	public void clearCache(List<BollettinoIcona> bollettinoIconas) {
		for (BollettinoIcona bollettinoIcona : bollettinoIconas) {
			entityCache.removeResult(
				BollettinoIconaImpl.class, bollettinoIcona);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BollettinoIconaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BollettinoIconaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bollettino icona with the primary key. Does not add the bollettino icona to the database.
	 *
	 * @param id the primary key for the new bollettino icona
	 * @return the new bollettino icona
	 */
	@Override
	public BollettinoIcona create(long id) {
		BollettinoIcona bollettinoIcona = new BollettinoIconaImpl();

		bollettinoIcona.setNew(true);
		bollettinoIcona.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		bollettinoIcona.setUuid(uuid);

		return bollettinoIcona;
	}

	/**
	 * Removes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona remove(long id)
		throws NoSuchBollettinoIconaException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona remove(Serializable primaryKey)
		throws NoSuchBollettinoIconaException {

		Session session = null;

		try {
			session = openSession();

			BollettinoIcona bollettinoIcona = (BollettinoIcona)session.get(
				BollettinoIconaImpl.class, primaryKey);

			if (bollettinoIcona == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBollettinoIconaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bollettinoIcona);
		}
		catch (NoSuchBollettinoIconaException noSuchEntityException) {
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
	protected BollettinoIcona removeImpl(BollettinoIcona bollettinoIcona) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bollettinoIcona)) {
				bollettinoIcona = (BollettinoIcona)session.get(
					BollettinoIconaImpl.class,
					bollettinoIcona.getPrimaryKeyObj());
			}

			if (bollettinoIcona != null) {
				session.delete(bollettinoIcona);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bollettinoIcona != null) {
			clearCache(bollettinoIcona);
		}

		return bollettinoIcona;
	}

	@Override
	public BollettinoIcona updateImpl(BollettinoIcona bollettinoIcona) {
		boolean isNew = bollettinoIcona.isNew();

		if (!(bollettinoIcona instanceof BollettinoIconaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bollettinoIcona.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bollettinoIcona);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bollettinoIcona proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BollettinoIcona implementation " +
					bollettinoIcona.getClass());
		}

		BollettinoIconaModelImpl bollettinoIconaModelImpl =
			(BollettinoIconaModelImpl)bollettinoIcona;

		if (Validator.isNull(bollettinoIcona.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bollettinoIcona.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bollettinoIcona);
			}
			else {
				bollettinoIcona = (BollettinoIcona)session.merge(
					bollettinoIcona);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BollettinoIconaImpl.class, bollettinoIconaModelImpl, false, true);

		if (isNew) {
			bollettinoIcona.setNew(false);
		}

		bollettinoIcona.resetOriginalValues();

		return bollettinoIcona;
	}

	/**
	 * Returns the bollettino icona with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBollettinoIconaException {

		BollettinoIcona bollettinoIcona = fetchByPrimaryKey(primaryKey);

		if (bollettinoIcona == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBollettinoIconaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bollettinoIcona;
	}

	/**
	 * Returns the bollettino icona with the primary key or throws a <code>NoSuchBollettinoIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona findByPrimaryKey(long id)
		throws NoSuchBollettinoIconaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bollettino icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona, or <code>null</code> if a bollettino icona with the primary key could not be found
	 */
	@Override
	public BollettinoIcona fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the bollettino iconas.
	 *
	 * @return the bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll(
		int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettino iconas
	 */
	@Override
	public List<BollettinoIcona> findAll(
		int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
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

		List<BollettinoIcona> list = null;

		if (useFinderCache) {
			list = (List<BollettinoIcona>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOLLETTINOICONA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOLLETTINOICONA;

				sql = sql.concat(BollettinoIconaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BollettinoIcona>)QueryUtil.list(
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
	 * Removes all the bollettino iconas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BollettinoIcona bollettinoIcona : findAll()) {
			remove(bollettinoIcona);
		}
	}

	/**
	 * Returns the number of bollettino iconas.
	 *
	 * @return the number of bollettino iconas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOLLETTINOICONA);

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
		return _SQL_SELECT_BOLLETTINOICONA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BollettinoIconaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bollettino icona persistence.
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

		BollettinoIconaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BollettinoIconaUtil.setPersistence(null);

		entityCache.removeCache(BollettinoIconaImpl.class.getName());
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

	private static final String _SQL_SELECT_BOLLETTINOICONA =
		"SELECT bollettinoIcona FROM BollettinoIcona bollettinoIcona";

	private static final String _SQL_SELECT_BOLLETTINOICONA_WHERE =
		"SELECT bollettinoIcona FROM BollettinoIcona bollettinoIcona WHERE ";

	private static final String _SQL_COUNT_BOLLETTINOICONA =
		"SELECT COUNT(bollettinoIcona) FROM BollettinoIcona bollettinoIcona";

	private static final String _SQL_COUNT_BOLLETTINOICONA_WHERE =
		"SELECT COUNT(bollettinoIcona) FROM BollettinoIcona bollettinoIcona WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bollettinoIcona.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BollettinoIcona exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BollettinoIcona exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BollettinoIconaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}