/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence.impl;

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

import it.eng.radarMeteo.exception.NoSuchComuni_wsException;
import it.eng.radarMeteo.model.Comuni_ws;
import it.eng.radarMeteo.model.Comuni_wsTable;
import it.eng.radarMeteo.model.impl.Comuni_wsImpl;
import it.eng.radarMeteo.model.impl.Comuni_wsModelImpl;
import it.eng.radarMeteo.service.persistence.Comuni_wsPersistence;
import it.eng.radarMeteo.service.persistence.Comuni_wsUtil;
import it.eng.radarMeteo.service.persistence.impl.constants.rt_portletPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the comuni_ws service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @generated
 */
@Component(service = Comuni_wsPersistence.class)
public class Comuni_wsPersistenceImpl
	extends BasePersistenceImpl<Comuni_ws> implements Comuni_wsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Comuni_wsUtil</code> to access the comuni_ws persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Comuni_wsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySottozona;
	private FinderPath _finderPathWithoutPaginationFindBySottozona;
	private FinderPath _finderPathCountBySottozona;

	/**
	 * Returns all the comuni_wses where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @return the matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findBySottozona(String sottozona) {
		return findBySottozona(
			sottozona, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end) {

		return findBySottozona(sottozona, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator) {

		return findBySottozona(sottozona, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator,
		boolean useFinderCache) {

		sottozona = Objects.toString(sottozona, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySottozona;
				finderArgs = new Object[] {sottozona};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySottozona;
			finderArgs = new Object[] {
				sottozona, start, end, orderByComparator
			};
		}

		List<Comuni_ws> list = null;

		if (useFinderCache) {
			list = (List<Comuni_ws>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comuni_ws comuni_ws : list) {
					if (!sottozona.equals(comuni_ws.getSottozona())) {
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

			sb.append(_SQL_SELECT_COMUNI_WS_WHERE);

			boolean bindSottozona = false;

			if (sottozona.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOTTOZONA_SOTTOZONA_3);
			}
			else {
				bindSottozona = true;

				sb.append(_FINDER_COLUMN_SOTTOZONA_SOTTOZONA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Comuni_wsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSottozona) {
					queryPos.add(sottozona);
				}

				list = (List<Comuni_ws>)QueryUtil.list(
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
	 * Returns the first comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws findBySottozona_First(
			String sottozona, OrderByComparator<Comuni_ws> orderByComparator)
		throws NoSuchComuni_wsException {

		Comuni_ws comuni_ws = fetchBySottozona_First(
			sottozona, orderByComparator);

		if (comuni_ws != null) {
			return comuni_ws;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sottozona=");
		sb.append(sottozona);

		sb.append("}");

		throw new NoSuchComuni_wsException(sb.toString());
	}

	/**
	 * Returns the first comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws fetchBySottozona_First(
		String sottozona, OrderByComparator<Comuni_ws> orderByComparator) {

		List<Comuni_ws> list = findBySottozona(
			sottozona, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws findBySottozona_Last(
			String sottozona, OrderByComparator<Comuni_ws> orderByComparator)
		throws NoSuchComuni_wsException {

		Comuni_ws comuni_ws = fetchBySottozona_Last(
			sottozona, orderByComparator);

		if (comuni_ws != null) {
			return comuni_ws;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sottozona=");
		sb.append(sottozona);

		sb.append("}");

		throw new NoSuchComuni_wsException(sb.toString());
	}

	/**
	 * Returns the last comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws fetchBySottozona_Last(
		String sottozona, OrderByComparator<Comuni_ws> orderByComparator) {

		int count = countBySottozona(sottozona);

		if (count == 0) {
			return null;
		}

		List<Comuni_ws> list = findBySottozona(
			sottozona, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comuni_wses before and after the current comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param idIstat the primary key of the current comuni_ws
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws[] findBySottozona_PrevAndNext(
			String idIstat, String sottozona,
			OrderByComparator<Comuni_ws> orderByComparator)
		throws NoSuchComuni_wsException {

		sottozona = Objects.toString(sottozona, "");

		Comuni_ws comuni_ws = findByPrimaryKey(idIstat);

		Session session = null;

		try {
			session = openSession();

			Comuni_ws[] array = new Comuni_wsImpl[3];

			array[0] = getBySottozona_PrevAndNext(
				session, comuni_ws, sottozona, orderByComparator, true);

			array[1] = comuni_ws;

			array[2] = getBySottozona_PrevAndNext(
				session, comuni_ws, sottozona, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comuni_ws getBySottozona_PrevAndNext(
		Session session, Comuni_ws comuni_ws, String sottozona,
		OrderByComparator<Comuni_ws> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNI_WS_WHERE);

		boolean bindSottozona = false;

		if (sottozona.isEmpty()) {
			sb.append(_FINDER_COLUMN_SOTTOZONA_SOTTOZONA_3);
		}
		else {
			bindSottozona = true;

			sb.append(_FINDER_COLUMN_SOTTOZONA_SOTTOZONA_2);
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
			sb.append(Comuni_wsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSottozona) {
			queryPos.add(sottozona);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comuni_ws)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comuni_ws> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comuni_wses where sottozona = &#63; from the database.
	 *
	 * @param sottozona the sottozona
	 */
	@Override
	public void removeBySottozona(String sottozona) {
		for (Comuni_ws comuni_ws :
				findBySottozona(
					sottozona, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comuni_ws);
		}
	}

	/**
	 * Returns the number of comuni_wses where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @return the number of matching comuni_wses
	 */
	@Override
	public int countBySottozona(String sottozona) {
		sottozona = Objects.toString(sottozona, "");

		FinderPath finderPath = _finderPathCountBySottozona;

		Object[] finderArgs = new Object[] {sottozona};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNI_WS_WHERE);

			boolean bindSottozona = false;

			if (sottozona.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOTTOZONA_SOTTOZONA_3);
			}
			else {
				bindSottozona = true;

				sb.append(_FINDER_COLUMN_SOTTOZONA_SOTTOZONA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSottozona) {
					queryPos.add(sottozona);
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

	private static final String _FINDER_COLUMN_SOTTOZONA_SOTTOZONA_2 =
		"comuni_ws.sottozona = ?";

	private static final String _FINDER_COLUMN_SOTTOZONA_SOTTOZONA_3 =
		"(comuni_ws.sottozona IS NULL OR comuni_ws.sottozona = '')";

	private FinderPath _finderPathWithPaginationFindByZonaallerta;
	private FinderPath _finderPathWithoutPaginationFindByZonaallerta;
	private FinderPath _finderPathCountByZonaallerta;

	/**
	 * Returns all the comuni_wses where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @return the matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findByZonaallerta(String zonaallerta) {
		return findByZonaallerta(
			zonaallerta, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end) {

		return findByZonaallerta(zonaallerta, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator) {

		return findByZonaallerta(
			zonaallerta, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comuni_wses
	 */
	@Override
	public List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator,
		boolean useFinderCache) {

		zonaallerta = Objects.toString(zonaallerta, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByZonaallerta;
				finderArgs = new Object[] {zonaallerta};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByZonaallerta;
			finderArgs = new Object[] {
				zonaallerta, start, end, orderByComparator
			};
		}

		List<Comuni_ws> list = null;

		if (useFinderCache) {
			list = (List<Comuni_ws>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comuni_ws comuni_ws : list) {
					if (!zonaallerta.equals(comuni_ws.getZonaallerta())) {
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

			sb.append(_SQL_SELECT_COMUNI_WS_WHERE);

			boolean bindZonaallerta = false;

			if (zonaallerta.isEmpty()) {
				sb.append(_FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_3);
			}
			else {
				bindZonaallerta = true;

				sb.append(_FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Comuni_wsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindZonaallerta) {
					queryPos.add(zonaallerta);
				}

				list = (List<Comuni_ws>)QueryUtil.list(
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
	 * Returns the first comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws findByZonaallerta_First(
			String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator)
		throws NoSuchComuni_wsException {

		Comuni_ws comuni_ws = fetchByZonaallerta_First(
			zonaallerta, orderByComparator);

		if (comuni_ws != null) {
			return comuni_ws;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("zonaallerta=");
		sb.append(zonaallerta);

		sb.append("}");

		throw new NoSuchComuni_wsException(sb.toString());
	}

	/**
	 * Returns the first comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws fetchByZonaallerta_First(
		String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator) {

		List<Comuni_ws> list = findByZonaallerta(
			zonaallerta, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws findByZonaallerta_Last(
			String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator)
		throws NoSuchComuni_wsException {

		Comuni_ws comuni_ws = fetchByZonaallerta_Last(
			zonaallerta, orderByComparator);

		if (comuni_ws != null) {
			return comuni_ws;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("zonaallerta=");
		sb.append(zonaallerta);

		sb.append("}");

		throw new NoSuchComuni_wsException(sb.toString());
	}

	/**
	 * Returns the last comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	@Override
	public Comuni_ws fetchByZonaallerta_Last(
		String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator) {

		int count = countByZonaallerta(zonaallerta);

		if (count == 0) {
			return null;
		}

		List<Comuni_ws> list = findByZonaallerta(
			zonaallerta, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comuni_wses before and after the current comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param idIstat the primary key of the current comuni_ws
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws[] findByZonaallerta_PrevAndNext(
			String idIstat, String zonaallerta,
			OrderByComparator<Comuni_ws> orderByComparator)
		throws NoSuchComuni_wsException {

		zonaallerta = Objects.toString(zonaallerta, "");

		Comuni_ws comuni_ws = findByPrimaryKey(idIstat);

		Session session = null;

		try {
			session = openSession();

			Comuni_ws[] array = new Comuni_wsImpl[3];

			array[0] = getByZonaallerta_PrevAndNext(
				session, comuni_ws, zonaallerta, orderByComparator, true);

			array[1] = comuni_ws;

			array[2] = getByZonaallerta_PrevAndNext(
				session, comuni_ws, zonaallerta, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comuni_ws getByZonaallerta_PrevAndNext(
		Session session, Comuni_ws comuni_ws, String zonaallerta,
		OrderByComparator<Comuni_ws> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNI_WS_WHERE);

		boolean bindZonaallerta = false;

		if (zonaallerta.isEmpty()) {
			sb.append(_FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_3);
		}
		else {
			bindZonaallerta = true;

			sb.append(_FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_2);
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
			sb.append(Comuni_wsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindZonaallerta) {
			queryPos.add(zonaallerta);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comuni_ws)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comuni_ws> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comuni_wses where zonaallerta = &#63; from the database.
	 *
	 * @param zonaallerta the zonaallerta
	 */
	@Override
	public void removeByZonaallerta(String zonaallerta) {
		for (Comuni_ws comuni_ws :
				findByZonaallerta(
					zonaallerta, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comuni_ws);
		}
	}

	/**
	 * Returns the number of comuni_wses where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @return the number of matching comuni_wses
	 */
	@Override
	public int countByZonaallerta(String zonaallerta) {
		zonaallerta = Objects.toString(zonaallerta, "");

		FinderPath finderPath = _finderPathCountByZonaallerta;

		Object[] finderArgs = new Object[] {zonaallerta};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNI_WS_WHERE);

			boolean bindZonaallerta = false;

			if (zonaallerta.isEmpty()) {
				sb.append(_FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_3);
			}
			else {
				bindZonaallerta = true;

				sb.append(_FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindZonaallerta) {
					queryPos.add(zonaallerta);
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

	private static final String _FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_2 =
		"comuni_ws.zonaallerta = ?";

	private static final String _FINDER_COLUMN_ZONAALLERTA_ZONAALLERTA_3 =
		"(comuni_ws.zonaallerta IS NULL OR comuni_ws.zonaallerta = '')";

	public Comuni_wsPersistenceImpl() {
		setModelClass(Comuni_ws.class);

		setModelImplClass(Comuni_wsImpl.class);
		setModelPKClass(String.class);

		setTable(Comuni_wsTable.INSTANCE);
	}

	/**
	 * Caches the comuni_ws in the entity cache if it is enabled.
	 *
	 * @param comuni_ws the comuni_ws
	 */
	@Override
	public void cacheResult(Comuni_ws comuni_ws) {
		entityCache.putResult(
			Comuni_wsImpl.class, comuni_ws.getPrimaryKey(), comuni_ws);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the comuni_wses in the entity cache if it is enabled.
	 *
	 * @param comuni_wses the comuni_wses
	 */
	@Override
	public void cacheResult(List<Comuni_ws> comuni_wses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (comuni_wses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Comuni_ws comuni_ws : comuni_wses) {
			if (entityCache.getResult(
					Comuni_wsImpl.class, comuni_ws.getPrimaryKey()) == null) {

				cacheResult(comuni_ws);
			}
		}
	}

	/**
	 * Clears the cache for all comuni_wses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Comuni_wsImpl.class);

		finderCache.clearCache(Comuni_wsImpl.class);
	}

	/**
	 * Clears the cache for the comuni_ws.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comuni_ws comuni_ws) {
		entityCache.removeResult(Comuni_wsImpl.class, comuni_ws);
	}

	@Override
	public void clearCache(List<Comuni_ws> comuni_wses) {
		for (Comuni_ws comuni_ws : comuni_wses) {
			entityCache.removeResult(Comuni_wsImpl.class, comuni_ws);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(Comuni_wsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(Comuni_wsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new comuni_ws with the primary key. Does not add the comuni_ws to the database.
	 *
	 * @param idIstat the primary key for the new comuni_ws
	 * @return the new comuni_ws
	 */
	@Override
	public Comuni_ws create(String idIstat) {
		Comuni_ws comuni_ws = new Comuni_wsImpl();

		comuni_ws.setNew(true);
		comuni_ws.setPrimaryKey(idIstat);

		return comuni_ws;
	}

	/**
	 * Removes the comuni_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws that was removed
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws remove(String idIstat) throws NoSuchComuni_wsException {
		return remove((Serializable)idIstat);
	}

	/**
	 * Removes the comuni_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comuni_ws
	 * @return the comuni_ws that was removed
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws remove(Serializable primaryKey)
		throws NoSuchComuni_wsException {

		Session session = null;

		try {
			session = openSession();

			Comuni_ws comuni_ws = (Comuni_ws)session.get(
				Comuni_wsImpl.class, primaryKey);

			if (comuni_ws == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComuni_wsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(comuni_ws);
		}
		catch (NoSuchComuni_wsException noSuchEntityException) {
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
	protected Comuni_ws removeImpl(Comuni_ws comuni_ws) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comuni_ws)) {
				comuni_ws = (Comuni_ws)session.get(
					Comuni_wsImpl.class, comuni_ws.getPrimaryKeyObj());
			}

			if (comuni_ws != null) {
				session.delete(comuni_ws);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (comuni_ws != null) {
			clearCache(comuni_ws);
		}

		return comuni_ws;
	}

	@Override
	public Comuni_ws updateImpl(Comuni_ws comuni_ws) {
		boolean isNew = comuni_ws.isNew();

		if (!(comuni_ws instanceof Comuni_wsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(comuni_ws.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(comuni_ws);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in comuni_ws proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Comuni_ws implementation " +
					comuni_ws.getClass());
		}

		Comuni_wsModelImpl comuni_wsModelImpl = (Comuni_wsModelImpl)comuni_ws;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(comuni_ws);
			}
			else {
				comuni_ws = (Comuni_ws)session.merge(comuni_ws);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			Comuni_wsImpl.class, comuni_wsModelImpl, false, true);

		if (isNew) {
			comuni_ws.setNew(false);
		}

		comuni_ws.resetOriginalValues();

		return comuni_ws;
	}

	/**
	 * Returns the comuni_ws with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comuni_ws
	 * @return the comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComuni_wsException {

		Comuni_ws comuni_ws = fetchByPrimaryKey(primaryKey);

		if (comuni_ws == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComuni_wsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return comuni_ws;
	}

	/**
	 * Returns the comuni_ws with the primary key or throws a <code>NoSuchComuni_wsException</code> if it could not be found.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws findByPrimaryKey(String idIstat)
		throws NoSuchComuni_wsException {

		return findByPrimaryKey((Serializable)idIstat);
	}

	/**
	 * Returns the comuni_ws with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws, or <code>null</code> if a comuni_ws with the primary key could not be found
	 */
	@Override
	public Comuni_ws fetchByPrimaryKey(String idIstat) {
		return fetchByPrimaryKey((Serializable)idIstat);
	}

	/**
	 * Returns all the comuni_wses.
	 *
	 * @return the comuni_wses
	 */
	@Override
	public List<Comuni_ws> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of comuni_wses
	 */
	@Override
	public List<Comuni_ws> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comuni_wses
	 */
	@Override
	public List<Comuni_ws> findAll(
		int start, int end, OrderByComparator<Comuni_ws> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comuni_wses
	 */
	@Override
	public List<Comuni_ws> findAll(
		int start, int end, OrderByComparator<Comuni_ws> orderByComparator,
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

		List<Comuni_ws> list = null;

		if (useFinderCache) {
			list = (List<Comuni_ws>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMUNI_WS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMUNI_WS;

				sql = sql.concat(Comuni_wsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Comuni_ws>)QueryUtil.list(
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
	 * Removes all the comuni_wses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Comuni_ws comuni_ws : findAll()) {
			remove(comuni_ws);
		}
	}

	/**
	 * Returns the number of comuni_wses.
	 *
	 * @return the number of comuni_wses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMUNI_WS);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "idIstat";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMUNI_WS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Comuni_wsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comuni_ws persistence.
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

		_finderPathWithPaginationFindBySottozona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySottozona",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"sottozona"}, true);

		_finderPathWithoutPaginationFindBySottozona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySottozona",
			new String[] {String.class.getName()}, new String[] {"sottozona"},
			true);

		_finderPathCountBySottozona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySottozona",
			new String[] {String.class.getName()}, new String[] {"sottozona"},
			false);

		_finderPathWithPaginationFindByZonaallerta = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByZonaallerta",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"zonaallerta"}, true);

		_finderPathWithoutPaginationFindByZonaallerta = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByZonaallerta",
			new String[] {String.class.getName()}, new String[] {"zonaallerta"},
			true);

		_finderPathCountByZonaallerta = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByZonaallerta",
			new String[] {String.class.getName()}, new String[] {"zonaallerta"},
			false);

		Comuni_wsUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		Comuni_wsUtil.setPersistence(null);

		entityCache.removeCache(Comuni_wsImpl.class.getName());
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMUNI_WS =
		"SELECT comuni_ws FROM Comuni_ws comuni_ws";

	private static final String _SQL_SELECT_COMUNI_WS_WHERE =
		"SELECT comuni_ws FROM Comuni_ws comuni_ws WHERE ";

	private static final String _SQL_COUNT_COMUNI_WS =
		"SELECT COUNT(comuni_ws) FROM Comuni_ws comuni_ws";

	private static final String _SQL_COUNT_COMUNI_WS_WHERE =
		"SELECT COUNT(comuni_ws) FROM Comuni_ws comuni_ws WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "comuni_ws.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Comuni_ws exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Comuni_ws exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Comuni_wsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}