/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.parer.exception.NoSuchDatiSpecificiInvioException;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DatiSpecificiInvioTable;
import it.eng.parer.model.impl.DatiSpecificiInvioImpl;
import it.eng.parer.model.impl.DatiSpecificiInvioModelImpl;
import it.eng.parer.service.persistence.DatiSpecificiInvioPersistence;
import it.eng.parer.service.persistence.DatiSpecificiInvioUtil;
import it.eng.parer.service.persistence.impl.constants.parerPersistenceConstants;

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
 * The persistence implementation for the dati specifici invio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = DatiSpecificiInvioPersistence.class)
public class DatiSpecificiInvioPersistenceImpl
	extends BasePersistenceImpl<DatiSpecificiInvio>
	implements DatiSpecificiInvioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DatiSpecificiInvioUtil</code> to access the dati specifici invio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DatiSpecificiInvioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByesitoInvio;
	private FinderPath _finderPathWithoutPaginationFindByesitoInvio;
	private FinderPath _finderPathCountByesitoInvio;

	/**
	 * Returns all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @return the matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(String ESITO_INVIO) {
		return findByesitoInvio(
			ESITO_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end) {

		return findByesitoInvio(ESITO_INVIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		return findByesitoInvio(
			ESITO_INVIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findByesitoInvio(
		String ESITO_INVIO, int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator,
		boolean useFinderCache) {

		ESITO_INVIO = Objects.toString(ESITO_INVIO, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByesitoInvio;
				finderArgs = new Object[] {ESITO_INVIO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByesitoInvio;
			finderArgs = new Object[] {
				ESITO_INVIO, start, end, orderByComparator
			};
		}

		List<DatiSpecificiInvio> list = null;

		if (useFinderCache) {
			list = (List<DatiSpecificiInvio>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DatiSpecificiInvio datiSpecificiInvio : list) {
					if (!ESITO_INVIO.equals(
							datiSpecificiInvio.getESITO_INVIO())) {

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

			sb.append(_SQL_SELECT_DATISPECIFICIINVIO_WHERE);

			boolean bindESITO_INVIO = false;

			if (ESITO_INVIO.isEmpty()) {
				sb.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3);
			}
			else {
				bindESITO_INVIO = true;

				sb.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DatiSpecificiInvioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindESITO_INVIO) {
					queryPos.add(ESITO_INVIO);
				}

				list = (List<DatiSpecificiInvio>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio findByesitoInvio_First(
			String ESITO_INVIO,
			OrderByComparator<DatiSpecificiInvio> orderByComparator)
		throws NoSuchDatiSpecificiInvioException {

		DatiSpecificiInvio datiSpecificiInvio = fetchByesitoInvio_First(
			ESITO_INVIO, orderByComparator);

		if (datiSpecificiInvio != null) {
			return datiSpecificiInvio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ESITO_INVIO=");
		sb.append(ESITO_INVIO);

		sb.append("}");

		throw new NoSuchDatiSpecificiInvioException(sb.toString());
	}

	/**
	 * Returns the first dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dati specifici invio, or <code>null</code> if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByesitoInvio_First(
		String ESITO_INVIO,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		List<DatiSpecificiInvio> list = findByesitoInvio(
			ESITO_INVIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio findByesitoInvio_Last(
			String ESITO_INVIO,
			OrderByComparator<DatiSpecificiInvio> orderByComparator)
		throws NoSuchDatiSpecificiInvioException {

		DatiSpecificiInvio datiSpecificiInvio = fetchByesitoInvio_Last(
			ESITO_INVIO, orderByComparator);

		if (datiSpecificiInvio != null) {
			return datiSpecificiInvio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ESITO_INVIO=");
		sb.append(ESITO_INVIO);

		sb.append("}");

		throw new NoSuchDatiSpecificiInvioException(sb.toString());
	}

	/**
	 * Returns the last dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dati specifici invio, or <code>null</code> if a matching dati specifici invio could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByesitoInvio_Last(
		String ESITO_INVIO,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		int count = countByesitoInvio(ESITO_INVIO);

		if (count == 0) {
			return null;
		}

		List<DatiSpecificiInvio> list = findByesitoInvio(
			ESITO_INVIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dati specifici invios before and after the current dati specifici invio in the ordered set where ESITO_INVIO = &#63;.
	 *
	 * @param ID_INVIO the primary key of the current dati specifici invio
	 * @param ESITO_INVIO the esito_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio[] findByesitoInvio_PrevAndNext(
			long ID_INVIO, String ESITO_INVIO,
			OrderByComparator<DatiSpecificiInvio> orderByComparator)
		throws NoSuchDatiSpecificiInvioException {

		ESITO_INVIO = Objects.toString(ESITO_INVIO, "");

		DatiSpecificiInvio datiSpecificiInvio = findByPrimaryKey(ID_INVIO);

		Session session = null;

		try {
			session = openSession();

			DatiSpecificiInvio[] array = new DatiSpecificiInvioImpl[3];

			array[0] = getByesitoInvio_PrevAndNext(
				session, datiSpecificiInvio, ESITO_INVIO, orderByComparator,
				true);

			array[1] = datiSpecificiInvio;

			array[2] = getByesitoInvio_PrevAndNext(
				session, datiSpecificiInvio, ESITO_INVIO, orderByComparator,
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

	protected DatiSpecificiInvio getByesitoInvio_PrevAndNext(
		Session session, DatiSpecificiInvio datiSpecificiInvio,
		String ESITO_INVIO,
		OrderByComparator<DatiSpecificiInvio> orderByComparator,
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

		sb.append(_SQL_SELECT_DATISPECIFICIINVIO_WHERE);

		boolean bindESITO_INVIO = false;

		if (ESITO_INVIO.isEmpty()) {
			sb.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3);
		}
		else {
			bindESITO_INVIO = true;

			sb.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2);
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
			sb.append(DatiSpecificiInvioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindESITO_INVIO) {
			queryPos.add(ESITO_INVIO);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						datiSpecificiInvio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DatiSpecificiInvio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dati specifici invios where ESITO_INVIO = &#63; from the database.
	 *
	 * @param ESITO_INVIO the esito_invio
	 */
	@Override
	public void removeByesitoInvio(String ESITO_INVIO) {
		for (DatiSpecificiInvio datiSpecificiInvio :
				findByesitoInvio(
					ESITO_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(datiSpecificiInvio);
		}
	}

	/**
	 * Returns the number of dati specifici invios where ESITO_INVIO = &#63;.
	 *
	 * @param ESITO_INVIO the esito_invio
	 * @return the number of matching dati specifici invios
	 */
	@Override
	public int countByesitoInvio(String ESITO_INVIO) {
		ESITO_INVIO = Objects.toString(ESITO_INVIO, "");

		FinderPath finderPath = _finderPathCountByesitoInvio;

		Object[] finderArgs = new Object[] {ESITO_INVIO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATISPECIFICIINVIO_WHERE);

			boolean bindESITO_INVIO = false;

			if (ESITO_INVIO.isEmpty()) {
				sb.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3);
			}
			else {
				bindESITO_INVIO = true;

				sb.append(_FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindESITO_INVIO) {
					queryPos.add(ESITO_INVIO);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_2 =
		"datiSpecificiInvio.ESITO_INVIO = ?";

	private static final String _FINDER_COLUMN_ESITOINVIO_ESITO_INVIO_3 =
		"(datiSpecificiInvio.ESITO_INVIO IS NULL OR datiSpecificiInvio.ESITO_INVIO = '')";

	public DatiSpecificiInvioPersistenceImpl() {
		setModelClass(DatiSpecificiInvio.class);

		setModelImplClass(DatiSpecificiInvioImpl.class);
		setModelPKClass(long.class);

		setTable(DatiSpecificiInvioTable.INSTANCE);
	}

	/**
	 * Caches the dati specifici invio in the entity cache if it is enabled.
	 *
	 * @param datiSpecificiInvio the dati specifici invio
	 */
	@Override
	public void cacheResult(DatiSpecificiInvio datiSpecificiInvio) {
		dummyEntityCache.putResult(
			DatiSpecificiInvioImpl.class, datiSpecificiInvio.getPrimaryKey(),
			datiSpecificiInvio);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dati specifici invios in the entity cache if it is enabled.
	 *
	 * @param datiSpecificiInvios the dati specifici invios
	 */
	@Override
	public void cacheResult(List<DatiSpecificiInvio> datiSpecificiInvios) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (datiSpecificiInvios.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DatiSpecificiInvio datiSpecificiInvio : datiSpecificiInvios) {
			if (dummyEntityCache.getResult(
					DatiSpecificiInvioImpl.class,
					datiSpecificiInvio.getPrimaryKey()) == null) {

				cacheResult(datiSpecificiInvio);
			}
		}
	}

	/**
	 * Clears the cache for all dati specifici invios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(DatiSpecificiInvioImpl.class);

		dummyFinderCache.clearCache(DatiSpecificiInvioImpl.class);
	}

	/**
	 * Clears the cache for the dati specifici invio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DatiSpecificiInvio datiSpecificiInvio) {
		dummyEntityCache.removeResult(
			DatiSpecificiInvioImpl.class, datiSpecificiInvio);
	}

	@Override
	public void clearCache(List<DatiSpecificiInvio> datiSpecificiInvios) {
		for (DatiSpecificiInvio datiSpecificiInvio : datiSpecificiInvios) {
			dummyEntityCache.removeResult(
				DatiSpecificiInvioImpl.class, datiSpecificiInvio);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(DatiSpecificiInvioImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				DatiSpecificiInvioImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dati specifici invio with the primary key. Does not add the dati specifici invio to the database.
	 *
	 * @param ID_INVIO the primary key for the new dati specifici invio
	 * @return the new dati specifici invio
	 */
	@Override
	public DatiSpecificiInvio create(long ID_INVIO) {
		DatiSpecificiInvio datiSpecificiInvio = new DatiSpecificiInvioImpl();

		datiSpecificiInvio.setNew(true);
		datiSpecificiInvio.setPrimaryKey(ID_INVIO);

		datiSpecificiInvio.setCompanyId(CompanyThreadLocal.getCompanyId());

		return datiSpecificiInvio;
	}

	/**
	 * Removes the dati specifici invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio that was removed
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio remove(long ID_INVIO)
		throws NoSuchDatiSpecificiInvioException {

		return remove((Serializable)ID_INVIO);
	}

	/**
	 * Removes the dati specifici invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dati specifici invio
	 * @return the dati specifici invio that was removed
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio remove(Serializable primaryKey)
		throws NoSuchDatiSpecificiInvioException {

		Session session = null;

		try {
			session = openSession();

			DatiSpecificiInvio datiSpecificiInvio =
				(DatiSpecificiInvio)session.get(
					DatiSpecificiInvioImpl.class, primaryKey);

			if (datiSpecificiInvio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDatiSpecificiInvioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(datiSpecificiInvio);
		}
		catch (NoSuchDatiSpecificiInvioException noSuchEntityException) {
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
	protected DatiSpecificiInvio removeImpl(
		DatiSpecificiInvio datiSpecificiInvio) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(datiSpecificiInvio)) {
				datiSpecificiInvio = (DatiSpecificiInvio)session.get(
					DatiSpecificiInvioImpl.class,
					datiSpecificiInvio.getPrimaryKeyObj());
			}

			if (datiSpecificiInvio != null) {
				session.delete(datiSpecificiInvio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (datiSpecificiInvio != null) {
			clearCache(datiSpecificiInvio);
		}

		return datiSpecificiInvio;
	}

	@Override
	public DatiSpecificiInvio updateImpl(
		DatiSpecificiInvio datiSpecificiInvio) {

		boolean isNew = datiSpecificiInvio.isNew();

		if (!(datiSpecificiInvio instanceof DatiSpecificiInvioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(datiSpecificiInvio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					datiSpecificiInvio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in datiSpecificiInvio proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DatiSpecificiInvio implementation " +
					datiSpecificiInvio.getClass());
		}

		DatiSpecificiInvioModelImpl datiSpecificiInvioModelImpl =
			(DatiSpecificiInvioModelImpl)datiSpecificiInvio;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(datiSpecificiInvio);
			}
			else {
				datiSpecificiInvio = (DatiSpecificiInvio)session.merge(
					datiSpecificiInvio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			DatiSpecificiInvioImpl.class, datiSpecificiInvioModelImpl, false,
			true);

		if (isNew) {
			datiSpecificiInvio.setNew(false);
		}

		datiSpecificiInvio.resetOriginalValues();

		return datiSpecificiInvio;
	}

	/**
	 * Returns the dati specifici invio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDatiSpecificiInvioException {

		DatiSpecificiInvio datiSpecificiInvio = fetchByPrimaryKey(primaryKey);

		if (datiSpecificiInvio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDatiSpecificiInvioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return datiSpecificiInvio;
	}

	/**
	 * Returns the dati specifici invio with the primary key or throws a <code>NoSuchDatiSpecificiInvioException</code> if it could not be found.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio
	 * @throws NoSuchDatiSpecificiInvioException if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio findByPrimaryKey(long ID_INVIO)
		throws NoSuchDatiSpecificiInvioException {

		return findByPrimaryKey((Serializable)ID_INVIO);
	}

	/**
	 * Returns the dati specifici invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_INVIO the primary key of the dati specifici invio
	 * @return the dati specifici invio, or <code>null</code> if a dati specifici invio with the primary key could not be found
	 */
	@Override
	public DatiSpecificiInvio fetchByPrimaryKey(long ID_INVIO) {
		return fetchByPrimaryKey((Serializable)ID_INVIO);
	}

	/**
	 * Returns all the dati specifici invios.
	 *
	 * @return the dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @return the range of dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll(
		int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dati specifici invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiSpecificiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dati specifici invios
	 * @param end the upper bound of the range of dati specifici invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dati specifici invios
	 */
	@Override
	public List<DatiSpecificiInvio> findAll(
		int start, int end,
		OrderByComparator<DatiSpecificiInvio> orderByComparator,
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

		List<DatiSpecificiInvio> list = null;

		if (useFinderCache) {
			list = (List<DatiSpecificiInvio>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATISPECIFICIINVIO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATISPECIFICIINVIO;

				sql = sql.concat(DatiSpecificiInvioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DatiSpecificiInvio>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the dati specifici invios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DatiSpecificiInvio datiSpecificiInvio : findAll()) {
			remove(datiSpecificiInvio);
		}
	}

	/**
	 * Returns the number of dati specifici invios.
	 *
	 * @return the number of dati specifici invios
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DATISPECIFICIINVIO);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
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
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID_INVIO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATISPECIFICIINVIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DatiSpecificiInvioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dati specifici invio persistence.
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

		_finderPathWithPaginationFindByesitoInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByesitoInvio",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ESITO_INVIO"}, true);

		_finderPathWithoutPaginationFindByesitoInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByesitoInvio",
			new String[] {String.class.getName()}, new String[] {"ESITO_INVIO"},
			true);

		_finderPathCountByesitoInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByesitoInvio",
			new String[] {String.class.getName()}, new String[] {"ESITO_INVIO"},
			false);

		DatiSpecificiInvioUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DatiSpecificiInvioUtil.setPersistence(null);

		dummyEntityCache.removeCache(DatiSpecificiInvioImpl.class.getName());
	}

	@Override
	@Reference(
		target = parerPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = parerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = parerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_DATISPECIFICIINVIO =
		"SELECT datiSpecificiInvio FROM DatiSpecificiInvio datiSpecificiInvio";

	private static final String _SQL_SELECT_DATISPECIFICIINVIO_WHERE =
		"SELECT datiSpecificiInvio FROM DatiSpecificiInvio datiSpecificiInvio WHERE ";

	private static final String _SQL_COUNT_DATISPECIFICIINVIO =
		"SELECT COUNT(datiSpecificiInvio) FROM DatiSpecificiInvio datiSpecificiInvio";

	private static final String _SQL_COUNT_DATISPECIFICIINVIO_WHERE =
		"SELECT COUNT(datiSpecificiInvio) FROM DatiSpecificiInvio datiSpecificiInvio WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "datiSpecificiInvio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DatiSpecificiInvio exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DatiSpecificiInvio exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DatiSpecificiInvioPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}