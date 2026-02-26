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

import it.eng.bollettino.exception.NoSuchBacinoException;
import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.BacinoTable;
import it.eng.bollettino.model.impl.BacinoImpl;
import it.eng.bollettino.model.impl.BacinoModelImpl;
import it.eng.bollettino.service.persistence.BacinoPersistence;
import it.eng.bollettino.service.persistence.BacinoUtil;
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
 * The persistence implementation for the bacino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = BacinoPersistence.class)
public class BacinoPersistenceImpl
	extends BasePersistenceImpl<Bacino> implements BacinoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BacinoUtil</code> to access the bacino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BacinoImpl.class.getName();

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
	 * Returns all the bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bacinos
	 */
	@Override
	public List<Bacino> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @return the range of matching bacinos
	 */
	@Override
	public List<Bacino> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bacinos
	 */
	@Override
	public List<Bacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Bacino> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bacinos
	 */
	@Override
	public List<Bacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Bacino> orderByComparator, boolean useFinderCache) {

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

		List<Bacino> list = null;

		if (useFinderCache) {
			list = (List<Bacino>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Bacino bacino : list) {
					if (!uuid.equals(bacino.getUuid())) {
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

			sb.append(_SQL_SELECT_BACINO_WHERE);

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
				sb.append(BacinoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Bacino>)QueryUtil.list(
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
	 * Returns the first bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bacino
	 * @throws NoSuchBacinoException if a matching bacino could not be found
	 */
	@Override
	public Bacino findByUuid_First(
			String uuid, OrderByComparator<Bacino> orderByComparator)
		throws NoSuchBacinoException {

		Bacino bacino = fetchByUuid_First(uuid, orderByComparator);

		if (bacino != null) {
			return bacino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBacinoException(sb.toString());
	}

	/**
	 * Returns the first bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bacino, or <code>null</code> if a matching bacino could not be found
	 */
	@Override
	public Bacino fetchByUuid_First(
		String uuid, OrderByComparator<Bacino> orderByComparator) {

		List<Bacino> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bacino
	 * @throws NoSuchBacinoException if a matching bacino could not be found
	 */
	@Override
	public Bacino findByUuid_Last(
			String uuid, OrderByComparator<Bacino> orderByComparator)
		throws NoSuchBacinoException {

		Bacino bacino = fetchByUuid_Last(uuid, orderByComparator);

		if (bacino != null) {
			return bacino;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBacinoException(sb.toString());
	}

	/**
	 * Returns the last bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bacino, or <code>null</code> if a matching bacino could not be found
	 */
	@Override
	public Bacino fetchByUuid_Last(
		String uuid, OrderByComparator<Bacino> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Bacino> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bacinos before and after the current bacino in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bacino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bacino
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	@Override
	public Bacino[] findByUuid_PrevAndNext(
			String id, String uuid, OrderByComparator<Bacino> orderByComparator)
		throws NoSuchBacinoException {

		uuid = Objects.toString(uuid, "");

		Bacino bacino = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Bacino[] array = new BacinoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bacino, uuid, orderByComparator, true);

			array[1] = bacino;

			array[2] = getByUuid_PrevAndNext(
				session, bacino, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bacino getByUuid_PrevAndNext(
		Session session, Bacino bacino, String uuid,
		OrderByComparator<Bacino> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BACINO_WHERE);

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
			sb.append(BacinoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bacino)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Bacino> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bacinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Bacino bacino :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bacino);
		}
	}

	/**
	 * Returns the number of bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bacinos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BACINO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "bacino.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bacino.uuid IS NULL OR bacino.uuid = '')";

	public BacinoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Bacino.class);

		setModelImplClass(BacinoImpl.class);
		setModelPKClass(String.class);

		setTable(BacinoTable.INSTANCE);
	}

	/**
	 * Caches the bacino in the entity cache if it is enabled.
	 *
	 * @param bacino the bacino
	 */
	@Override
	public void cacheResult(Bacino bacino) {
		entityCache.putResult(BacinoImpl.class, bacino.getPrimaryKey(), bacino);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bacinos in the entity cache if it is enabled.
	 *
	 * @param bacinos the bacinos
	 */
	@Override
	public void cacheResult(List<Bacino> bacinos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bacinos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Bacino bacino : bacinos) {
			if (entityCache.getResult(
					BacinoImpl.class, bacino.getPrimaryKey()) == null) {

				cacheResult(bacino);
			}
		}
	}

	/**
	 * Clears the cache for all bacinos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BacinoImpl.class);

		finderCache.clearCache(BacinoImpl.class);
	}

	/**
	 * Clears the cache for the bacino.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bacino bacino) {
		entityCache.removeResult(BacinoImpl.class, bacino);
	}

	@Override
	public void clearCache(List<Bacino> bacinos) {
		for (Bacino bacino : bacinos) {
			entityCache.removeResult(BacinoImpl.class, bacino);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BacinoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BacinoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bacino with the primary key. Does not add the bacino to the database.
	 *
	 * @param id the primary key for the new bacino
	 * @return the new bacino
	 */
	@Override
	public Bacino create(String id) {
		Bacino bacino = new BacinoImpl();

		bacino.setNew(true);
		bacino.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		bacino.setUuid(uuid);

		return bacino;
	}

	/**
	 * Removes the bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino that was removed
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	@Override
	public Bacino remove(String id) throws NoSuchBacinoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bacino
	 * @return the bacino that was removed
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	@Override
	public Bacino remove(Serializable primaryKey) throws NoSuchBacinoException {
		Session session = null;

		try {
			session = openSession();

			Bacino bacino = (Bacino)session.get(BacinoImpl.class, primaryKey);

			if (bacino == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBacinoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bacino);
		}
		catch (NoSuchBacinoException noSuchEntityException) {
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
	protected Bacino removeImpl(Bacino bacino) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bacino)) {
				bacino = (Bacino)session.get(
					BacinoImpl.class, bacino.getPrimaryKeyObj());
			}

			if (bacino != null) {
				session.delete(bacino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bacino != null) {
			clearCache(bacino);
		}

		return bacino;
	}

	@Override
	public Bacino updateImpl(Bacino bacino) {
		boolean isNew = bacino.isNew();

		if (!(bacino instanceof BacinoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bacino.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bacino);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bacino proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Bacino implementation " +
					bacino.getClass());
		}

		BacinoModelImpl bacinoModelImpl = (BacinoModelImpl)bacino;

		if (Validator.isNull(bacino.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bacino.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bacino);
			}
			else {
				bacino = (Bacino)session.merge(bacino);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BacinoImpl.class, bacinoModelImpl, false, true);

		if (isNew) {
			bacino.setNew(false);
		}

		bacino.resetOriginalValues();

		return bacino;
	}

	/**
	 * Returns the bacino with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bacino
	 * @return the bacino
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	@Override
	public Bacino findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBacinoException {

		Bacino bacino = fetchByPrimaryKey(primaryKey);

		if (bacino == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBacinoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bacino;
	}

	/**
	 * Returns the bacino with the primary key or throws a <code>NoSuchBacinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	@Override
	public Bacino findByPrimaryKey(String id) throws NoSuchBacinoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino, or <code>null</code> if a bacino with the primary key could not be found
	 */
	@Override
	public Bacino fetchByPrimaryKey(String id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the bacinos.
	 *
	 * @return the bacinos
	 */
	@Override
	public List<Bacino> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @return the range of bacinos
	 */
	@Override
	public List<Bacino> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bacinos
	 */
	@Override
	public List<Bacino> findAll(
		int start, int end, OrderByComparator<Bacino> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bacinos
	 */
	@Override
	public List<Bacino> findAll(
		int start, int end, OrderByComparator<Bacino> orderByComparator,
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

		List<Bacino> list = null;

		if (useFinderCache) {
			list = (List<Bacino>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BACINO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BACINO;

				sql = sql.concat(BacinoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Bacino>)QueryUtil.list(
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
	 * Removes all the bacinos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Bacino bacino : findAll()) {
			remove(bacino);
		}
	}

	/**
	 * Returns the number of bacinos.
	 *
	 * @return the number of bacinos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BACINO);

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
		return _SQL_SELECT_BACINO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BacinoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bacino persistence.
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

		BacinoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BacinoUtil.setPersistence(null);

		entityCache.removeCache(BacinoImpl.class.getName());
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

	private static final String _SQL_SELECT_BACINO =
		"SELECT bacino FROM Bacino bacino";

	private static final String _SQL_SELECT_BACINO_WHERE =
		"SELECT bacino FROM Bacino bacino WHERE ";

	private static final String _SQL_COUNT_BACINO =
		"SELECT COUNT(bacino) FROM Bacino bacino";

	private static final String _SQL_COUNT_BACINO_WHERE =
		"SELECT COUNT(bacino) FROM Bacino bacino WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bacino.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Bacino exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Bacino exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BacinoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}