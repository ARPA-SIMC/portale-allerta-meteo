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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeCondizioneException;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.RegolaAllarmeCondizioneTable;
import it.eng.bollettino.model.impl.RegolaAllarmeCondizioneImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl;
import it.eng.bollettino.service.persistence.RegolaAllarmeCondizionePersistence;
import it.eng.bollettino.service.persistence.RegolaAllarmeCondizioneUtil;
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
 * The persistence implementation for the regola allarme condizione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = RegolaAllarmeCondizionePersistence.class)
public class RegolaAllarmeCondizionePersistenceImpl
	extends BasePersistenceImpl<RegolaAllarmeCondizione>
	implements RegolaAllarmeCondizionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegolaAllarmeCondizioneUtil</code> to access the regola allarme condizione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegolaAllarmeCondizioneImpl.class.getName();

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
	 * Returns all the regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		List<RegolaAllarmeCondizione> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeCondizione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeCondizione regolaAllarmeCondizione : list) {
					if (!uuid.equals(regolaAllarmeCondizione.getUuid())) {
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

			sb.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

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
				sb.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
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
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByUuid_First(
			String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByUuid_First(
			uuid, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(sb.toString());
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByUuid_First(
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		List<RegolaAllarmeCondizione> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByUuid_Last(
			String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByUuid_Last(
			uuid, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(sb.toString());
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByUuid_Last(
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeCondizione> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		uuid = Objects.toString(uuid, "");

		RegolaAllarmeCondizione regolaAllarmeCondizione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeCondizione[] array =
				new RegolaAllarmeCondizioneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, regolaAllarmeCondizione, uuid, orderByComparator,
				true);

			array[1] = regolaAllarmeCondizione;

			array[2] = getByUuid_PrevAndNext(
				session, regolaAllarmeCondizione, uuid, orderByComparator,
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

	protected RegolaAllarmeCondizione getByUuid_PrevAndNext(
		Session session, RegolaAllarmeCondizione regolaAllarmeCondizione,
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		sb.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

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
			sb.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
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
						regolaAllarmeCondizione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeCondizione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme condiziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeCondizione);
		}
	}

	/**
	 * Returns the number of regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme condiziones
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARMECONDIZIONE_WHERE);

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
		"regolaAllarmeCondizione.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(regolaAllarmeCondizione.uuid IS NULL OR regolaAllarmeCondizione.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByRegola;
	private FinderPath _finderPathWithoutPaginationFindByRegola;
	private FinderPath _finderPathCountByRegola;

	/**
	 * Returns all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(long idRegola) {
		return findByRegola(
			idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end) {

		return findByRegola(idRegola, start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return findByRegola(idRegola, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		List<RegolaAllarmeCondizione> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeCondizione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegolaAllarmeCondizione regolaAllarmeCondizione : list) {
					if (idRegola != regolaAllarmeCondizione.getIdRegola()) {
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

			sb.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

			sb.append(_FINDER_COLUMN_REGOLA_IDREGOLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idRegola);

				list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
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
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByRegola_First(
			long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByRegola_First(
			idRegola, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegola=");
		sb.append(idRegola);

		sb.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(sb.toString());
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByRegola_First(
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		List<RegolaAllarmeCondizione> list = findByRegola(
			idRegola, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByRegola_Last(
			long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByRegola_Last(
			idRegola, orderByComparator);

		if (regolaAllarmeCondizione != null) {
			return regolaAllarmeCondizione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegola=");
		sb.append(idRegola);

		sb.append("}");

		throw new NoSuchRegolaAllarmeCondizioneException(sb.toString());
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByRegola_Last(
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		int count = countByRegola(idRegola);

		if (count == 0) {
			return null;
		}

		List<RegolaAllarmeCondizione> list = findByRegola(
			idRegola, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione[] findByRegola_PrevAndNext(
			long id, long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeCondizione[] array =
				new RegolaAllarmeCondizioneImpl[3];

			array[0] = getByRegola_PrevAndNext(
				session, regolaAllarmeCondizione, idRegola, orderByComparator,
				true);

			array[1] = regolaAllarmeCondizione;

			array[2] = getByRegola_PrevAndNext(
				session, regolaAllarmeCondizione, idRegola, orderByComparator,
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

	protected RegolaAllarmeCondizione getByRegola_PrevAndNext(
		Session session, RegolaAllarmeCondizione regolaAllarmeCondizione,
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		sb.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE);

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
			sb.append(RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
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
						regolaAllarmeCondizione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegolaAllarmeCondizione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the regola allarme condiziones where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	@Override
	public void removeByRegola(long idRegola) {
		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				findByRegola(
					idRegola, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(regolaAllarmeCondizione);
		}
	}

	/**
	 * Returns the number of regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme condiziones
	 */
	@Override
	public int countByRegola(long idRegola) {
		FinderPath finderPath = _finderPathCountByRegola;

		Object[] finderArgs = new Object[] {idRegola};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGOLAALLARMECONDIZIONE_WHERE);

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
		"regolaAllarmeCondizione.idRegola = ?";

	public RegolaAllarmeCondizionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RegolaAllarmeCondizione.class);

		setModelImplClass(RegolaAllarmeCondizioneImpl.class);
		setModelPKClass(long.class);

		setTable(RegolaAllarmeCondizioneTable.INSTANCE);
	}

	/**
	 * Caches the regola allarme condizione in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 */
	@Override
	public void cacheResult(RegolaAllarmeCondizione regolaAllarmeCondizione) {
		entityCache.putResult(
			RegolaAllarmeCondizioneImpl.class,
			regolaAllarmeCondizione.getPrimaryKey(), regolaAllarmeCondizione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the regola allarme condiziones in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondiziones the regola allarme condiziones
	 */
	@Override
	public void cacheResult(
		List<RegolaAllarmeCondizione> regolaAllarmeCondiziones) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (regolaAllarmeCondiziones.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				regolaAllarmeCondiziones) {

			if (entityCache.getResult(
					RegolaAllarmeCondizioneImpl.class,
					regolaAllarmeCondizione.getPrimaryKey()) == null) {

				cacheResult(regolaAllarmeCondizione);
			}
		}
	}

	/**
	 * Clears the cache for all regola allarme condiziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegolaAllarmeCondizioneImpl.class);

		finderCache.clearCache(RegolaAllarmeCondizioneImpl.class);
	}

	/**
	 * Clears the cache for the regola allarme condizione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegolaAllarmeCondizione regolaAllarmeCondizione) {
		entityCache.removeResult(
			RegolaAllarmeCondizioneImpl.class, regolaAllarmeCondizione);
	}

	@Override
	public void clearCache(
		List<RegolaAllarmeCondizione> regolaAllarmeCondiziones) {

		for (RegolaAllarmeCondizione regolaAllarmeCondizione :
				regolaAllarmeCondiziones) {

			entityCache.removeResult(
				RegolaAllarmeCondizioneImpl.class, regolaAllarmeCondizione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RegolaAllarmeCondizioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				RegolaAllarmeCondizioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	@Override
	public RegolaAllarmeCondizione create(long id) {
		RegolaAllarmeCondizione regolaAllarmeCondizione =
			new RegolaAllarmeCondizioneImpl();

		regolaAllarmeCondizione.setNew(true);
		regolaAllarmeCondizione.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		regolaAllarmeCondizione.setUuid(uuid);

		return regolaAllarmeCondizione;
	}

	/**
	 * Removes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione remove(long id)
		throws NoSuchRegolaAllarmeCondizioneException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione remove(Serializable primaryKey)
		throws NoSuchRegolaAllarmeCondizioneException {

		Session session = null;

		try {
			session = openSession();

			RegolaAllarmeCondizione regolaAllarmeCondizione =
				(RegolaAllarmeCondizione)session.get(
					RegolaAllarmeCondizioneImpl.class, primaryKey);

			if (regolaAllarmeCondizione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegolaAllarmeCondizioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(regolaAllarmeCondizione);
		}
		catch (NoSuchRegolaAllarmeCondizioneException noSuchEntityException) {
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
	protected RegolaAllarmeCondizione removeImpl(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regolaAllarmeCondizione)) {
				regolaAllarmeCondizione = (RegolaAllarmeCondizione)session.get(
					RegolaAllarmeCondizioneImpl.class,
					regolaAllarmeCondizione.getPrimaryKeyObj());
			}

			if (regolaAllarmeCondizione != null) {
				session.delete(regolaAllarmeCondizione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (regolaAllarmeCondizione != null) {
			clearCache(regolaAllarmeCondizione);
		}

		return regolaAllarmeCondizione;
	}

	@Override
	public RegolaAllarmeCondizione updateImpl(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		boolean isNew = regolaAllarmeCondizione.isNew();

		if (!(regolaAllarmeCondizione instanceof
				RegolaAllarmeCondizioneModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(regolaAllarmeCondizione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					regolaAllarmeCondizione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in regolaAllarmeCondizione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegolaAllarmeCondizione implementation " +
					regolaAllarmeCondizione.getClass());
		}

		RegolaAllarmeCondizioneModelImpl regolaAllarmeCondizioneModelImpl =
			(RegolaAllarmeCondizioneModelImpl)regolaAllarmeCondizione;

		if (Validator.isNull(regolaAllarmeCondizione.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			regolaAllarmeCondizione.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(regolaAllarmeCondizione);
			}
			else {
				regolaAllarmeCondizione =
					(RegolaAllarmeCondizione)session.merge(
						regolaAllarmeCondizione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RegolaAllarmeCondizioneImpl.class, regolaAllarmeCondizioneModelImpl,
			false, true);

		if (isNew) {
			regolaAllarmeCondizione.setNew(false);
		}

		regolaAllarmeCondizione.resetOriginalValues();

		return regolaAllarmeCondizione;
	}

	/**
	 * Returns the regola allarme condizione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegolaAllarmeCondizioneException {

		RegolaAllarmeCondizione regolaAllarmeCondizione = fetchByPrimaryKey(
			primaryKey);

		if (regolaAllarmeCondizione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegolaAllarmeCondizioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return regolaAllarmeCondizione;
	}

	/**
	 * Returns the regola allarme condizione with the primary key or throws a <code>NoSuchRegolaAllarmeCondizioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeCondizioneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the regola allarme condizione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione, or <code>null</code> if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public RegolaAllarmeCondizione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the regola allarme condiziones.
	 *
	 * @return the regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of regola allarme condiziones
	 */
	@Override
	public List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
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

		List<RegolaAllarmeCondizione> list = null;

		if (useFinderCache) {
			list = (List<RegolaAllarmeCondizione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REGOLAALLARMECONDIZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REGOLAALLARMECONDIZIONE;

				sql = sql.concat(
					RegolaAllarmeCondizioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegolaAllarmeCondizione>)QueryUtil.list(
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
	 * Removes all the regola allarme condiziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegolaAllarmeCondizione regolaAllarmeCondizione : findAll()) {
			remove(regolaAllarmeCondizione);
		}
	}

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
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
					_SQL_COUNT_REGOLAALLARMECONDIZIONE);

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
		return _SQL_SELECT_REGOLAALLARMECONDIZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegolaAllarmeCondizioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the regola allarme condizione persistence.
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

		RegolaAllarmeCondizioneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RegolaAllarmeCondizioneUtil.setPersistence(null);

		entityCache.removeCache(RegolaAllarmeCondizioneImpl.class.getName());
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

	private static final String _SQL_SELECT_REGOLAALLARMECONDIZIONE =
		"SELECT regolaAllarmeCondizione FROM RegolaAllarmeCondizione regolaAllarmeCondizione";

	private static final String _SQL_SELECT_REGOLAALLARMECONDIZIONE_WHERE =
		"SELECT regolaAllarmeCondizione FROM RegolaAllarmeCondizione regolaAllarmeCondizione WHERE ";

	private static final String _SQL_COUNT_REGOLAALLARMECONDIZIONE =
		"SELECT COUNT(regolaAllarmeCondizione) FROM RegolaAllarmeCondizione regolaAllarmeCondizione";

	private static final String _SQL_COUNT_REGOLAALLARMECONDIZIONE_WHERE =
		"SELECT COUNT(regolaAllarmeCondizione) FROM RegolaAllarmeCondizione regolaAllarmeCondizione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"regolaAllarmeCondizione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegolaAllarmeCondizione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegolaAllarmeCondizione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegolaAllarmeCondizionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}