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

import it.eng.bollettino.exception.NoSuchIconaException;
import it.eng.bollettino.model.Icona;
import it.eng.bollettino.model.IconaTable;
import it.eng.bollettino.model.impl.IconaImpl;
import it.eng.bollettino.model.impl.IconaModelImpl;
import it.eng.bollettino.service.persistence.IconaPersistence;
import it.eng.bollettino.service.persistence.IconaUtil;
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
 * The persistence implementation for the icona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = IconaPersistence.class)
public class IconaPersistenceImpl
	extends BasePersistenceImpl<Icona> implements IconaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IconaUtil</code> to access the icona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IconaImpl.class.getName();

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
	 * Returns all the iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching iconas
	 */
	@Override
	public List<Icona> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of matching iconas
	 */
	@Override
	public List<Icona> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching iconas
	 */
	@Override
	public List<Icona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Icona> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching iconas
	 */
	@Override
	public List<Icona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Icona> orderByComparator, boolean useFinderCache) {

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

		List<Icona> list = null;

		if (useFinderCache) {
			list = (List<Icona>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Icona icona : list) {
					if (!uuid.equals(icona.getUuid())) {
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

			sb.append(_SQL_SELECT_ICONA_WHERE);

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
				sb.append(IconaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Icona>)QueryUtil.list(
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
	 * Returns the first icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icona
	 * @throws NoSuchIconaException if a matching icona could not be found
	 */
	@Override
	public Icona findByUuid_First(
			String uuid, OrderByComparator<Icona> orderByComparator)
		throws NoSuchIconaException {

		Icona icona = fetchByUuid_First(uuid, orderByComparator);

		if (icona != null) {
			return icona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIconaException(sb.toString());
	}

	/**
	 * Returns the first icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icona, or <code>null</code> if a matching icona could not be found
	 */
	@Override
	public Icona fetchByUuid_First(
		String uuid, OrderByComparator<Icona> orderByComparator) {

		List<Icona> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icona
	 * @throws NoSuchIconaException if a matching icona could not be found
	 */
	@Override
	public Icona findByUuid_Last(
			String uuid, OrderByComparator<Icona> orderByComparator)
		throws NoSuchIconaException {

		Icona icona = fetchByUuid_Last(uuid, orderByComparator);

		if (icona != null) {
			return icona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIconaException(sb.toString());
	}

	/**
	 * Returns the last icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icona, or <code>null</code> if a matching icona could not be found
	 */
	@Override
	public Icona fetchByUuid_Last(
		String uuid, OrderByComparator<Icona> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Icona> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the iconas before and after the current icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	@Override
	public Icona[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Icona> orderByComparator)
		throws NoSuchIconaException {

		uuid = Objects.toString(uuid, "");

		Icona icona = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Icona[] array = new IconaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, icona, uuid, orderByComparator, true);

			array[1] = icona;

			array[2] = getByUuid_PrevAndNext(
				session, icona, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Icona getByUuid_PrevAndNext(
		Session session, Icona icona, String uuid,
		OrderByComparator<Icona> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ICONA_WHERE);

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
			sb.append(IconaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(icona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Icona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Icona icona :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(icona);
		}
	}

	/**
	 * Returns the number of iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching iconas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ICONA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "icona.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(icona.uuid IS NULL OR icona.uuid = '')";

	public IconaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");
		dbColumnNames.put("path", "path_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Icona.class);

		setModelImplClass(IconaImpl.class);
		setModelPKClass(long.class);

		setTable(IconaTable.INSTANCE);
	}

	/**
	 * Caches the icona in the entity cache if it is enabled.
	 *
	 * @param icona the icona
	 */
	@Override
	public void cacheResult(Icona icona) {
		entityCache.putResult(IconaImpl.class, icona.getPrimaryKey(), icona);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the iconas in the entity cache if it is enabled.
	 *
	 * @param iconas the iconas
	 */
	@Override
	public void cacheResult(List<Icona> iconas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (iconas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Icona icona : iconas) {
			if (entityCache.getResult(IconaImpl.class, icona.getPrimaryKey()) ==
					null) {

				cacheResult(icona);
			}
		}
	}

	/**
	 * Clears the cache for all iconas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IconaImpl.class);

		finderCache.clearCache(IconaImpl.class);
	}

	/**
	 * Clears the cache for the icona.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Icona icona) {
		entityCache.removeResult(IconaImpl.class, icona);
	}

	@Override
	public void clearCache(List<Icona> iconas) {
		for (Icona icona : iconas) {
			entityCache.removeResult(IconaImpl.class, icona);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(IconaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IconaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new icona with the primary key. Does not add the icona to the database.
	 *
	 * @param id the primary key for the new icona
	 * @return the new icona
	 */
	@Override
	public Icona create(long id) {
		Icona icona = new IconaImpl();

		icona.setNew(true);
		icona.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		icona.setUuid(uuid);

		return icona;
	}

	/**
	 * Removes the icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the icona
	 * @return the icona that was removed
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	@Override
	public Icona remove(long id) throws NoSuchIconaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the icona
	 * @return the icona that was removed
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	@Override
	public Icona remove(Serializable primaryKey) throws NoSuchIconaException {
		Session session = null;

		try {
			session = openSession();

			Icona icona = (Icona)session.get(IconaImpl.class, primaryKey);

			if (icona == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIconaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(icona);
		}
		catch (NoSuchIconaException noSuchEntityException) {
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
	protected Icona removeImpl(Icona icona) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(icona)) {
				icona = (Icona)session.get(
					IconaImpl.class, icona.getPrimaryKeyObj());
			}

			if (icona != null) {
				session.delete(icona);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (icona != null) {
			clearCache(icona);
		}

		return icona;
	}

	@Override
	public Icona updateImpl(Icona icona) {
		boolean isNew = icona.isNew();

		if (!(icona instanceof IconaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(icona.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(icona);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in icona proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Icona implementation " +
					icona.getClass());
		}

		IconaModelImpl iconaModelImpl = (IconaModelImpl)icona;

		if (Validator.isNull(icona.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			icona.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(icona);
			}
			else {
				icona = (Icona)session.merge(icona);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(IconaImpl.class, iconaModelImpl, false, true);

		if (isNew) {
			icona.setNew(false);
		}

		icona.resetOriginalValues();

		return icona;
	}

	/**
	 * Returns the icona with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the icona
	 * @return the icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	@Override
	public Icona findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIconaException {

		Icona icona = fetchByPrimaryKey(primaryKey);

		if (icona == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIconaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return icona;
	}

	/**
	 * Returns the icona with the primary key or throws a <code>NoSuchIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the icona
	 * @return the icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	@Override
	public Icona findByPrimaryKey(long id) throws NoSuchIconaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the icona
	 * @return the icona, or <code>null</code> if a icona with the primary key could not be found
	 */
	@Override
	public Icona fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the iconas.
	 *
	 * @return the iconas
	 */
	@Override
	public List<Icona> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of iconas
	 */
	@Override
	public List<Icona> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of iconas
	 */
	@Override
	public List<Icona> findAll(
		int start, int end, OrderByComparator<Icona> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of iconas
	 */
	@Override
	public List<Icona> findAll(
		int start, int end, OrderByComparator<Icona> orderByComparator,
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

		List<Icona> list = null;

		if (useFinderCache) {
			list = (List<Icona>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ICONA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ICONA;

				sql = sql.concat(IconaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Icona>)QueryUtil.list(
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
	 * Removes all the iconas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Icona icona : findAll()) {
			remove(icona);
		}
	}

	/**
	 * Returns the number of iconas.
	 *
	 * @return the number of iconas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ICONA);

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
		return _SQL_SELECT_ICONA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IconaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the icona persistence.
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

		IconaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		IconaUtil.setPersistence(null);

		entityCache.removeCache(IconaImpl.class.getName());
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

	private static final String _SQL_SELECT_ICONA =
		"SELECT icona FROM Icona icona";

	private static final String _SQL_SELECT_ICONA_WHERE =
		"SELECT icona FROM Icona icona WHERE ";

	private static final String _SQL_COUNT_ICONA =
		"SELECT COUNT(icona) FROM Icona icona";

	private static final String _SQL_COUNT_ICONA_WHERE =
		"SELECT COUNT(icona) FROM Icona icona WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "icona.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Icona exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Icona exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IconaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id", "path"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}