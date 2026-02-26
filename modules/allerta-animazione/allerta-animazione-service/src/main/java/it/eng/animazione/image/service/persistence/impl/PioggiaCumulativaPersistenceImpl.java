/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence.impl;

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

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.model.PioggiaCumulativaTable;
import it.eng.animazione.image.model.impl.PioggiaCumulativaImpl;
import it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl;
import it.eng.animazione.image.service.persistence.PioggiaCumulativaPersistence;
import it.eng.animazione.image.service.persistence.PioggiaCumulativaUtil;
import it.eng.animazione.image.service.persistence.impl.constants.img_animazioniPersistenceConstants;

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
 * The persistence implementation for the pioggia cumulativa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = PioggiaCumulativaPersistence.class)
public class PioggiaCumulativaPersistenceImpl
	extends BasePersistenceImpl<PioggiaCumulativa>
	implements PioggiaCumulativaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PioggiaCumulativaUtil</code> to access the pioggia cumulativa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PioggiaCumulativaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCumulazione;
	private FinderPath _finderPathWithoutPaginationFindByCumulazione;
	private FinderPath _finderPathCountByCumulazione;

	/**
	 * Returns all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(String cumulazione) {
		return findByCumulazione(
			cumulazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end) {

		return findByCumulazione(cumulazione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return findByCumulazione(
			cumulazione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
		boolean useFinderCache) {

		cumulazione = Objects.toString(cumulazione, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCumulazione;
				finderArgs = new Object[] {cumulazione};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCumulazione;
			finderArgs = new Object[] {
				cumulazione, start, end, orderByComparator
			};
		}

		List<PioggiaCumulativa> list = null;

		if (useFinderCache) {
			list = (List<PioggiaCumulativa>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PioggiaCumulativa pioggiaCumulativa : list) {
					if (!cumulazione.equals(
							pioggiaCumulativa.getCumulazione())) {

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

			sb.append(_SQL_SELECT_PIOGGIACUMULATIVA_WHERE);

			boolean bindCumulazione = false;

			if (cumulazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3);
			}
			else {
				bindCumulazione = true;

				sb.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PioggiaCumulativaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCumulazione) {
					queryPos.add(cumulazione);
				}

				list = (List<PioggiaCumulativa>)QueryUtil.list(
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
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa findByCumulazione_First(
			String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws NoSuchPioggiaCumulativaException {

		PioggiaCumulativa pioggiaCumulativa = fetchByCumulazione_First(
			cumulazione, orderByComparator);

		if (pioggiaCumulativa != null) {
			return pioggiaCumulativa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cumulazione=");
		sb.append(cumulazione);

		sb.append("}");

		throw new NoSuchPioggiaCumulativaException(sb.toString());
	}

	/**
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByCumulazione_First(
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		List<PioggiaCumulativa> list = findByCumulazione(
			cumulazione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa findByCumulazione_Last(
			String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws NoSuchPioggiaCumulativaException {

		PioggiaCumulativa pioggiaCumulativa = fetchByCumulazione_Last(
			cumulazione, orderByComparator);

		if (pioggiaCumulativa != null) {
			return pioggiaCumulativa;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cumulazione=");
		sb.append(cumulazione);

		sb.append("}");

		throw new NoSuchPioggiaCumulativaException(sb.toString());
	}

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByCumulazione_Last(
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		int count = countByCumulazione(cumulazione);

		if (count == 0) {
			return null;
		}

		List<PioggiaCumulativa> list = findByCumulazione(
			cumulazione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pioggia cumulativas before and after the current pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param id the primary key of the current pioggia cumulativa
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa[] findByCumulazione_PrevAndNext(
			long id, String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws NoSuchPioggiaCumulativaException {

		cumulazione = Objects.toString(cumulazione, "");

		PioggiaCumulativa pioggiaCumulativa = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PioggiaCumulativa[] array = new PioggiaCumulativaImpl[3];

			array[0] = getByCumulazione_PrevAndNext(
				session, pioggiaCumulativa, cumulazione, orderByComparator,
				true);

			array[1] = pioggiaCumulativa;

			array[2] = getByCumulazione_PrevAndNext(
				session, pioggiaCumulativa, cumulazione, orderByComparator,
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

	protected PioggiaCumulativa getByCumulazione_PrevAndNext(
		Session session, PioggiaCumulativa pioggiaCumulativa,
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
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

		sb.append(_SQL_SELECT_PIOGGIACUMULATIVA_WHERE);

		boolean bindCumulazione = false;

		if (cumulazione.isEmpty()) {
			sb.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3);
		}
		else {
			bindCumulazione = true;

			sb.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2);
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
			sb.append(PioggiaCumulativaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCumulazione) {
			queryPos.add(cumulazione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						pioggiaCumulativa)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PioggiaCumulativa> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pioggia cumulativas where cumulazione = &#63; from the database.
	 *
	 * @param cumulazione the cumulazione
	 */
	@Override
	public void removeByCumulazione(String cumulazione) {
		for (PioggiaCumulativa pioggiaCumulativa :
				findByCumulazione(
					cumulazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pioggiaCumulativa);
		}
	}

	/**
	 * Returns the number of pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the number of matching pioggia cumulativas
	 */
	@Override
	public int countByCumulazione(String cumulazione) {
		cumulazione = Objects.toString(cumulazione, "");

		FinderPath finderPath = _finderPathCountByCumulazione;

		Object[] finderArgs = new Object[] {cumulazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PIOGGIACUMULATIVA_WHERE);

			boolean bindCumulazione = false;

			if (cumulazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3);
			}
			else {
				bindCumulazione = true;

				sb.append(_FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCumulazione) {
					queryPos.add(cumulazione);
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

	private static final String _FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_2 =
		"pioggiaCumulativa.cumulazione = ?";

	private static final String _FINDER_COLUMN_CUMULAZIONE_CUMULAZIONE_3 =
		"(pioggiaCumulativa.cumulazione IS NULL OR pioggiaCumulativa.cumulazione = '')";

	public PioggiaCumulativaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PioggiaCumulativa.class);

		setModelImplClass(PioggiaCumulativaImpl.class);
		setModelPKClass(long.class);

		setTable(PioggiaCumulativaTable.INSTANCE);
	}

	/**
	 * Caches the pioggia cumulativa in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 */
	@Override
	public void cacheResult(PioggiaCumulativa pioggiaCumulativa) {
		entityCache.putResult(
			PioggiaCumulativaImpl.class, pioggiaCumulativa.getPrimaryKey(),
			pioggiaCumulativa);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pioggia cumulativas in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativas the pioggia cumulativas
	 */
	@Override
	public void cacheResult(List<PioggiaCumulativa> pioggiaCumulativas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pioggiaCumulativas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PioggiaCumulativa pioggiaCumulativa : pioggiaCumulativas) {
			if (entityCache.getResult(
					PioggiaCumulativaImpl.class,
					pioggiaCumulativa.getPrimaryKey()) == null) {

				cacheResult(pioggiaCumulativa);
			}
		}
	}

	/**
	 * Clears the cache for all pioggia cumulativas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PioggiaCumulativaImpl.class);

		finderCache.clearCache(PioggiaCumulativaImpl.class);
	}

	/**
	 * Clears the cache for the pioggia cumulativa.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PioggiaCumulativa pioggiaCumulativa) {
		entityCache.removeResult(
			PioggiaCumulativaImpl.class, pioggiaCumulativa);
	}

	@Override
	public void clearCache(List<PioggiaCumulativa> pioggiaCumulativas) {
		for (PioggiaCumulativa pioggiaCumulativa : pioggiaCumulativas) {
			entityCache.removeResult(
				PioggiaCumulativaImpl.class, pioggiaCumulativa);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PioggiaCumulativaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PioggiaCumulativaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pioggia cumulativa with the primary key. Does not add the pioggia cumulativa to the database.
	 *
	 * @param id the primary key for the new pioggia cumulativa
	 * @return the new pioggia cumulativa
	 */
	@Override
	public PioggiaCumulativa create(long id) {
		PioggiaCumulativa pioggiaCumulativa = new PioggiaCumulativaImpl();

		pioggiaCumulativa.setNew(true);
		pioggiaCumulativa.setPrimaryKey(id);

		return pioggiaCumulativa;
	}

	/**
	 * Removes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa remove(long id)
		throws NoSuchPioggiaCumulativaException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa remove(Serializable primaryKey)
		throws NoSuchPioggiaCumulativaException {

		Session session = null;

		try {
			session = openSession();

			PioggiaCumulativa pioggiaCumulativa =
				(PioggiaCumulativa)session.get(
					PioggiaCumulativaImpl.class, primaryKey);

			if (pioggiaCumulativa == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPioggiaCumulativaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pioggiaCumulativa);
		}
		catch (NoSuchPioggiaCumulativaException noSuchEntityException) {
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
	protected PioggiaCumulativa removeImpl(
		PioggiaCumulativa pioggiaCumulativa) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pioggiaCumulativa)) {
				pioggiaCumulativa = (PioggiaCumulativa)session.get(
					PioggiaCumulativaImpl.class,
					pioggiaCumulativa.getPrimaryKeyObj());
			}

			if (pioggiaCumulativa != null) {
				session.delete(pioggiaCumulativa);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pioggiaCumulativa != null) {
			clearCache(pioggiaCumulativa);
		}

		return pioggiaCumulativa;
	}

	@Override
	public PioggiaCumulativa updateImpl(PioggiaCumulativa pioggiaCumulativa) {
		boolean isNew = pioggiaCumulativa.isNew();

		if (!(pioggiaCumulativa instanceof PioggiaCumulativaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pioggiaCumulativa.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					pioggiaCumulativa);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pioggiaCumulativa proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PioggiaCumulativa implementation " +
					pioggiaCumulativa.getClass());
		}

		PioggiaCumulativaModelImpl pioggiaCumulativaModelImpl =
			(PioggiaCumulativaModelImpl)pioggiaCumulativa;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pioggiaCumulativa);
			}
			else {
				pioggiaCumulativa = (PioggiaCumulativa)session.merge(
					pioggiaCumulativa);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PioggiaCumulativaImpl.class, pioggiaCumulativaModelImpl, false,
			true);

		if (isNew) {
			pioggiaCumulativa.setNew(false);
		}

		pioggiaCumulativa.resetOriginalValues();

		return pioggiaCumulativa;
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPioggiaCumulativaException {

		PioggiaCumulativa pioggiaCumulativa = fetchByPrimaryKey(primaryKey);

		if (pioggiaCumulativa == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPioggiaCumulativaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pioggiaCumulativa;
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or throws a <code>NoSuchPioggiaCumulativaException</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa findByPrimaryKey(long id)
		throws NoSuchPioggiaCumulativaException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa, or <code>null</code> if a pioggia cumulativa with the primary key could not be found
	 */
	@Override
	public PioggiaCumulativa fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the pioggia cumulativas.
	 *
	 * @return the pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll(
		int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pioggia cumulativas
	 */
	@Override
	public List<PioggiaCumulativa> findAll(
		int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
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

		List<PioggiaCumulativa> list = null;

		if (useFinderCache) {
			list = (List<PioggiaCumulativa>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PIOGGIACUMULATIVA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PIOGGIACUMULATIVA;

				sql = sql.concat(PioggiaCumulativaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PioggiaCumulativa>)QueryUtil.list(
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
	 * Removes all the pioggia cumulativas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PioggiaCumulativa pioggiaCumulativa : findAll()) {
			remove(pioggiaCumulativa);
		}
	}

	/**
	 * Returns the number of pioggia cumulativas.
	 *
	 * @return the number of pioggia cumulativas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PIOGGIACUMULATIVA);

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
		return _SQL_SELECT_PIOGGIACUMULATIVA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PioggiaCumulativaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pioggia cumulativa persistence.
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

		_finderPathWithPaginationFindByCumulazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCumulazione",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cumulazione"}, true);

		_finderPathWithoutPaginationFindByCumulazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCumulazione",
			new String[] {String.class.getName()}, new String[] {"cumulazione"},
			true);

		_finderPathCountByCumulazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCumulazione",
			new String[] {String.class.getName()}, new String[] {"cumulazione"},
			false);

		PioggiaCumulativaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PioggiaCumulativaUtil.setPersistence(null);

		entityCache.removeCache(PioggiaCumulativaImpl.class.getName());
	}

	@Override
	@Reference(
		target = img_animazioniPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = img_animazioniPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = img_animazioniPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PIOGGIACUMULATIVA =
		"SELECT pioggiaCumulativa FROM PioggiaCumulativa pioggiaCumulativa";

	private static final String _SQL_SELECT_PIOGGIACUMULATIVA_WHERE =
		"SELECT pioggiaCumulativa FROM PioggiaCumulativa pioggiaCumulativa WHERE ";

	private static final String _SQL_COUNT_PIOGGIACUMULATIVA =
		"SELECT COUNT(pioggiaCumulativa) FROM PioggiaCumulativa pioggiaCumulativa";

	private static final String _SQL_COUNT_PIOGGIACUMULATIVA_WHERE =
		"SELECT COUNT(pioggiaCumulativa) FROM PioggiaCumulativa pioggiaCumulativa WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pioggiaCumulativa.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PioggiaCumulativa exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PioggiaCumulativa exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PioggiaCumulativaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}