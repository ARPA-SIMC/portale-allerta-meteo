/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.impl;

import allerta.verifica.exception.NoSuchUtenteLavoroException;
import allerta.verifica.model.UtenteLavoro;
import allerta.verifica.model.UtenteLavoroTable;
import allerta.verifica.model.impl.UtenteLavoroImpl;
import allerta.verifica.model.impl.UtenteLavoroModelImpl;
import allerta.verifica.service.persistence.UtenteLavoroPersistence;
import allerta.verifica.service.persistence.UtenteLavoroUtil;
import allerta.verifica.service.persistence.impl.constants.VERIFICAPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the utente lavoro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UtenteLavoroPersistence.class)
public class UtenteLavoroPersistenceImpl
	extends BasePersistenceImpl<UtenteLavoro>
	implements UtenteLavoroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UtenteLavoroUtil</code> to access the utente lavoro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UtenteLavoroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocumento;
	private FinderPath _finderPathWithoutPaginationFindByDocumento;
	private FinderPath _finderPathCountByDocumento;

	/**
	 * Returns all the utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(long documento) {
		return findByDocumento(
			documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(
		long documento, int start, int end) {

		return findByDocumento(documento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator) {

		return findByDocumento(documento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumento;
				finderArgs = new Object[] {documento};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumento;
			finderArgs = new Object[] {
				documento, start, end, orderByComparator
			};
		}

		List<UtenteLavoro> list = null;

		if (useFinderCache) {
			list = (List<UtenteLavoro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteLavoro utenteLavoro : list) {
					if (documento != utenteLavoro.getDocumento()) {
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

			sb.append(_SQL_SELECT_UTENTELAVORO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UtenteLavoroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				list = (List<UtenteLavoro>)QueryUtil.list(
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
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro findByDocumento_First(
			long documento, OrderByComparator<UtenteLavoro> orderByComparator)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = fetchByDocumento_First(
			documento, orderByComparator);

		if (utenteLavoro != null) {
			return utenteLavoro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append("}");

		throw new NoSuchUtenteLavoroException(sb.toString());
	}

	/**
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro fetchByDocumento_First(
		long documento, OrderByComparator<UtenteLavoro> orderByComparator) {

		List<UtenteLavoro> list = findByDocumento(
			documento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro findByDocumento_Last(
			long documento, OrderByComparator<UtenteLavoro> orderByComparator)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = fetchByDocumento_Last(
			documento, orderByComparator);

		if (utenteLavoro != null) {
			return utenteLavoro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append("}");

		throw new NoSuchUtenteLavoroException(sb.toString());
	}

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	@Override
	public UtenteLavoro fetchByDocumento_Last(
		long documento, OrderByComparator<UtenteLavoro> orderByComparator) {

		int count = countByDocumento(documento);

		if (count == 0) {
			return null;
		}

		List<UtenteLavoro> list = findByDocumento(
			documento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente lavoros before and after the current utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current utente lavoro
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<UtenteLavoro> orderByComparator)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UtenteLavoro[] array = new UtenteLavoroImpl[3];

			array[0] = getByDocumento_PrevAndNext(
				session, utenteLavoro, documento, orderByComparator, true);

			array[1] = utenteLavoro;

			array[2] = getByDocumento_PrevAndNext(
				session, utenteLavoro, documento, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UtenteLavoro getByDocumento_PrevAndNext(
		Session session, UtenteLavoro utenteLavoro, long documento,
		OrderByComparator<UtenteLavoro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_UTENTELAVORO_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

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
			sb.append(UtenteLavoroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(utenteLavoro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteLavoro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente lavoros where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	@Override
	public void removeByDocumento(long documento) {
		for (UtenteLavoro utenteLavoro :
				findByDocumento(
					documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(utenteLavoro);
		}
	}

	/**
	 * Returns the number of utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching utente lavoros
	 */
	@Override
	public int countByDocumento(long documento) {
		FinderPath finderPath = _finderPathCountByDocumento;

		Object[] finderArgs = new Object[] {documento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTELAVORO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

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

	private static final String _FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2 =
		"utenteLavoro.documento = ?";

	public UtenteLavoroPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UtenteLavoro.class);

		setModelImplClass(UtenteLavoroImpl.class);
		setModelPKClass(long.class);

		setTable(UtenteLavoroTable.INSTANCE);
	}

	/**
	 * Caches the utente lavoro in the entity cache if it is enabled.
	 *
	 * @param utenteLavoro the utente lavoro
	 */
	@Override
	public void cacheResult(UtenteLavoro utenteLavoro) {
		entityCache.putResult(
			UtenteLavoroImpl.class, utenteLavoro.getPrimaryKey(), utenteLavoro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the utente lavoros in the entity cache if it is enabled.
	 *
	 * @param utenteLavoros the utente lavoros
	 */
	@Override
	public void cacheResult(List<UtenteLavoro> utenteLavoros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (utenteLavoros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UtenteLavoro utenteLavoro : utenteLavoros) {
			if (entityCache.getResult(
					UtenteLavoroImpl.class, utenteLavoro.getPrimaryKey()) ==
						null) {

				cacheResult(utenteLavoro);
			}
		}
	}

	/**
	 * Clears the cache for all utente lavoros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UtenteLavoroImpl.class);

		finderCache.clearCache(UtenteLavoroImpl.class);
	}

	/**
	 * Clears the cache for the utente lavoro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UtenteLavoro utenteLavoro) {
		entityCache.removeResult(UtenteLavoroImpl.class, utenteLavoro);
	}

	@Override
	public void clearCache(List<UtenteLavoro> utenteLavoros) {
		for (UtenteLavoro utenteLavoro : utenteLavoros) {
			entityCache.removeResult(UtenteLavoroImpl.class, utenteLavoro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UtenteLavoroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UtenteLavoroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new utente lavoro with the primary key. Does not add the utente lavoro to the database.
	 *
	 * @param id the primary key for the new utente lavoro
	 * @return the new utente lavoro
	 */
	@Override
	public UtenteLavoro create(long id) {
		UtenteLavoro utenteLavoro = new UtenteLavoroImpl();

		utenteLavoro.setNew(true);
		utenteLavoro.setPrimaryKey(id);

		return utenteLavoro;
	}

	/**
	 * Removes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro remove(long id) throws NoSuchUtenteLavoroException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro remove(Serializable primaryKey)
		throws NoSuchUtenteLavoroException {

		Session session = null;

		try {
			session = openSession();

			UtenteLavoro utenteLavoro = (UtenteLavoro)session.get(
				UtenteLavoroImpl.class, primaryKey);

			if (utenteLavoro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUtenteLavoroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(utenteLavoro);
		}
		catch (NoSuchUtenteLavoroException noSuchEntityException) {
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
	protected UtenteLavoro removeImpl(UtenteLavoro utenteLavoro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(utenteLavoro)) {
				utenteLavoro = (UtenteLavoro)session.get(
					UtenteLavoroImpl.class, utenteLavoro.getPrimaryKeyObj());
			}

			if (utenteLavoro != null) {
				session.delete(utenteLavoro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (utenteLavoro != null) {
			clearCache(utenteLavoro);
		}

		return utenteLavoro;
	}

	@Override
	public UtenteLavoro updateImpl(UtenteLavoro utenteLavoro) {
		boolean isNew = utenteLavoro.isNew();

		if (!(utenteLavoro instanceof UtenteLavoroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(utenteLavoro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					utenteLavoro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in utenteLavoro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UtenteLavoro implementation " +
					utenteLavoro.getClass());
		}

		UtenteLavoroModelImpl utenteLavoroModelImpl =
			(UtenteLavoroModelImpl)utenteLavoro;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(utenteLavoro);
			}
			else {
				utenteLavoro = (UtenteLavoro)session.merge(utenteLavoro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UtenteLavoroImpl.class, utenteLavoroModelImpl, false, true);

		if (isNew) {
			utenteLavoro.setNew(false);
		}

		utenteLavoro.resetOriginalValues();

		return utenteLavoro;
	}

	/**
	 * Returns the utente lavoro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUtenteLavoroException {

		UtenteLavoro utenteLavoro = fetchByPrimaryKey(primaryKey);

		if (utenteLavoro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUtenteLavoroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return utenteLavoro;
	}

	/**
	 * Returns the utente lavoro with the primary key or throws a <code>NoSuchUtenteLavoroException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro findByPrimaryKey(long id)
		throws NoSuchUtenteLavoroException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the utente lavoro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro, or <code>null</code> if a utente lavoro with the primary key could not be found
	 */
	@Override
	public UtenteLavoro fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the utente lavoros.
	 *
	 * @return the utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll(
		int start, int end, OrderByComparator<UtenteLavoro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente lavoros
	 */
	@Override
	public List<UtenteLavoro> findAll(
		int start, int end, OrderByComparator<UtenteLavoro> orderByComparator,
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

		List<UtenteLavoro> list = null;

		if (useFinderCache) {
			list = (List<UtenteLavoro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_UTENTELAVORO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_UTENTELAVORO;

				sql = sql.concat(UtenteLavoroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UtenteLavoro>)QueryUtil.list(
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
	 * Removes all the utente lavoros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UtenteLavoro utenteLavoro : findAll()) {
			remove(utenteLavoro);
		}
	}

	/**
	 * Returns the number of utente lavoros.
	 *
	 * @return the number of utente lavoros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_UTENTELAVORO);

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
		return _SQL_SELECT_UTENTELAVORO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UtenteLavoroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the utente lavoro persistence.
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

		_finderPathWithPaginationFindByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumento",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documento"}, true);

		_finderPathWithoutPaginationFindByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumento",
			new String[] {Long.class.getName()}, new String[] {"documento"},
			true);

		_finderPathCountByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumento",
			new String[] {Long.class.getName()}, new String[] {"documento"},
			false);

		UtenteLavoroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		UtenteLavoroUtil.setPersistence(null);

		entityCache.removeCache(UtenteLavoroImpl.class.getName());
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_UTENTELAVORO =
		"SELECT utenteLavoro FROM UtenteLavoro utenteLavoro";

	private static final String _SQL_SELECT_UTENTELAVORO_WHERE =
		"SELECT utenteLavoro FROM UtenteLavoro utenteLavoro WHERE ";

	private static final String _SQL_COUNT_UTENTELAVORO =
		"SELECT COUNT(utenteLavoro) FROM UtenteLavoro utenteLavoro";

	private static final String _SQL_COUNT_UTENTELAVORO_WHERE =
		"SELECT COUNT(utenteLavoro) FROM UtenteLavoro utenteLavoro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "utenteLavoro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UtenteLavoro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UtenteLavoro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UtenteLavoroPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}