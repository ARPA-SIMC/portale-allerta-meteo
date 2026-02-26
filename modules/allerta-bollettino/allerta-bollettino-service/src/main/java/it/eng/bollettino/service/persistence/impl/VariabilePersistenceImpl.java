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

import it.eng.bollettino.exception.NoSuchVariabileException;
import it.eng.bollettino.model.Variabile;
import it.eng.bollettino.model.VariabileTable;
import it.eng.bollettino.model.impl.VariabileImpl;
import it.eng.bollettino.model.impl.VariabileModelImpl;
import it.eng.bollettino.service.persistence.VariabilePersistence;
import it.eng.bollettino.service.persistence.VariabileUtil;
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
 * The persistence implementation for the variabile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = VariabilePersistence.class)
public class VariabilePersistenceImpl
	extends BasePersistenceImpl<Variabile> implements VariabilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VariabileUtil</code> to access the variabile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VariabileImpl.class.getName();

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
	 * Returns all the variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching variabiles
	 */
	@Override
	public List<Variabile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of matching variabiles
	 */
	@Override
	public List<Variabile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variabiles
	 */
	@Override
	public List<Variabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Variabile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variabiles
	 */
	@Override
	public List<Variabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Variabile> orderByComparator,
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

		List<Variabile> list = null;

		if (useFinderCache) {
			list = (List<Variabile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Variabile variabile : list) {
					if (!uuid.equals(variabile.getUuid())) {
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

			sb.append(_SQL_SELECT_VARIABILE_WHERE);

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
				sb.append(VariabileModelImpl.ORDER_BY_JPQL);
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

				list = (List<Variabile>)QueryUtil.list(
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
	 * Returns the first variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variabile
	 * @throws NoSuchVariabileException if a matching variabile could not be found
	 */
	@Override
	public Variabile findByUuid_First(
			String uuid, OrderByComparator<Variabile> orderByComparator)
		throws NoSuchVariabileException {

		Variabile variabile = fetchByUuid_First(uuid, orderByComparator);

		if (variabile != null) {
			return variabile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVariabileException(sb.toString());
	}

	/**
	 * Returns the first variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variabile, or <code>null</code> if a matching variabile could not be found
	 */
	@Override
	public Variabile fetchByUuid_First(
		String uuid, OrderByComparator<Variabile> orderByComparator) {

		List<Variabile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variabile
	 * @throws NoSuchVariabileException if a matching variabile could not be found
	 */
	@Override
	public Variabile findByUuid_Last(
			String uuid, OrderByComparator<Variabile> orderByComparator)
		throws NoSuchVariabileException {

		Variabile variabile = fetchByUuid_Last(uuid, orderByComparator);

		if (variabile != null) {
			return variabile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVariabileException(sb.toString());
	}

	/**
	 * Returns the last variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variabile, or <code>null</code> if a matching variabile could not be found
	 */
	@Override
	public Variabile fetchByUuid_Last(
		String uuid, OrderByComparator<Variabile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Variabile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the variabiles before and after the current variabile in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current variabile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	@Override
	public Variabile[] findByUuid_PrevAndNext(
			String id, String uuid,
			OrderByComparator<Variabile> orderByComparator)
		throws NoSuchVariabileException {

		uuid = Objects.toString(uuid, "");

		Variabile variabile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Variabile[] array = new VariabileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, variabile, uuid, orderByComparator, true);

			array[1] = variabile;

			array[2] = getByUuid_PrevAndNext(
				session, variabile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Variabile getByUuid_PrevAndNext(
		Session session, Variabile variabile, String uuid,
		OrderByComparator<Variabile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VARIABILE_WHERE);

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
			sb.append(VariabileModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(variabile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Variabile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the variabiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Variabile variabile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(variabile);
		}
	}

	/**
	 * Returns the number of variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching variabiles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VARIABILE_WHERE);

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
		"variabile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(variabile.uuid IS NULL OR variabile.uuid = '')";

	public VariabilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Variabile.class);

		setModelImplClass(VariabileImpl.class);
		setModelPKClass(String.class);

		setTable(VariabileTable.INSTANCE);
	}

	/**
	 * Caches the variabile in the entity cache if it is enabled.
	 *
	 * @param variabile the variabile
	 */
	@Override
	public void cacheResult(Variabile variabile) {
		entityCache.putResult(
			VariabileImpl.class, variabile.getPrimaryKey(), variabile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the variabiles in the entity cache if it is enabled.
	 *
	 * @param variabiles the variabiles
	 */
	@Override
	public void cacheResult(List<Variabile> variabiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (variabiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Variabile variabile : variabiles) {
			if (entityCache.getResult(
					VariabileImpl.class, variabile.getPrimaryKey()) == null) {

				cacheResult(variabile);
			}
		}
	}

	/**
	 * Clears the cache for all variabiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VariabileImpl.class);

		finderCache.clearCache(VariabileImpl.class);
	}

	/**
	 * Clears the cache for the variabile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Variabile variabile) {
		entityCache.removeResult(VariabileImpl.class, variabile);
	}

	@Override
	public void clearCache(List<Variabile> variabiles) {
		for (Variabile variabile : variabiles) {
			entityCache.removeResult(VariabileImpl.class, variabile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VariabileImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VariabileImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new variabile with the primary key. Does not add the variabile to the database.
	 *
	 * @param id the primary key for the new variabile
	 * @return the new variabile
	 */
	@Override
	public Variabile create(String id) {
		Variabile variabile = new VariabileImpl();

		variabile.setNew(true);
		variabile.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		variabile.setUuid(uuid);

		return variabile;
	}

	/**
	 * Removes the variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile that was removed
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	@Override
	public Variabile remove(String id) throws NoSuchVariabileException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the variabile
	 * @return the variabile that was removed
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	@Override
	public Variabile remove(Serializable primaryKey)
		throws NoSuchVariabileException {

		Session session = null;

		try {
			session = openSession();

			Variabile variabile = (Variabile)session.get(
				VariabileImpl.class, primaryKey);

			if (variabile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVariabileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(variabile);
		}
		catch (NoSuchVariabileException noSuchEntityException) {
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
	protected Variabile removeImpl(Variabile variabile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(variabile)) {
				variabile = (Variabile)session.get(
					VariabileImpl.class, variabile.getPrimaryKeyObj());
			}

			if (variabile != null) {
				session.delete(variabile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (variabile != null) {
			clearCache(variabile);
		}

		return variabile;
	}

	@Override
	public Variabile updateImpl(Variabile variabile) {
		boolean isNew = variabile.isNew();

		if (!(variabile instanceof VariabileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(variabile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(variabile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in variabile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Variabile implementation " +
					variabile.getClass());
		}

		VariabileModelImpl variabileModelImpl = (VariabileModelImpl)variabile;

		if (Validator.isNull(variabile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			variabile.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(variabile);
			}
			else {
				variabile = (Variabile)session.merge(variabile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VariabileImpl.class, variabileModelImpl, false, true);

		if (isNew) {
			variabile.setNew(false);
		}

		variabile.resetOriginalValues();

		return variabile;
	}

	/**
	 * Returns the variabile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the variabile
	 * @return the variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	@Override
	public Variabile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVariabileException {

		Variabile variabile = fetchByPrimaryKey(primaryKey);

		if (variabile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVariabileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return variabile;
	}

	/**
	 * Returns the variabile with the primary key or throws a <code>NoSuchVariabileException</code> if it could not be found.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	@Override
	public Variabile findByPrimaryKey(String id)
		throws NoSuchVariabileException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile, or <code>null</code> if a variabile with the primary key could not be found
	 */
	@Override
	public Variabile fetchByPrimaryKey(String id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the variabiles.
	 *
	 * @return the variabiles
	 */
	@Override
	public List<Variabile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of variabiles
	 */
	@Override
	public List<Variabile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of variabiles
	 */
	@Override
	public List<Variabile> findAll(
		int start, int end, OrderByComparator<Variabile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of variabiles
	 */
	@Override
	public List<Variabile> findAll(
		int start, int end, OrderByComparator<Variabile> orderByComparator,
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

		List<Variabile> list = null;

		if (useFinderCache) {
			list = (List<Variabile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VARIABILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VARIABILE;

				sql = sql.concat(VariabileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Variabile>)QueryUtil.list(
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
	 * Removes all the variabiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Variabile variabile : findAll()) {
			remove(variabile);
		}
	}

	/**
	 * Returns the number of variabiles.
	 *
	 * @return the number of variabiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VARIABILE);

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
		return _SQL_SELECT_VARIABILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VariabileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the variabile persistence.
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

		VariabileUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		VariabileUtil.setPersistence(null);

		entityCache.removeCache(VariabileImpl.class.getName());
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

	private static final String _SQL_SELECT_VARIABILE =
		"SELECT variabile FROM Variabile variabile";

	private static final String _SQL_SELECT_VARIABILE_WHERE =
		"SELECT variabile FROM Variabile variabile WHERE ";

	private static final String _SQL_COUNT_VARIABILE =
		"SELECT COUNT(variabile) FROM Variabile variabile";

	private static final String _SQL_COUNT_VARIABILE_WHERE =
		"SELECT COUNT(variabile) FROM Variabile variabile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "variabile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Variabile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Variabile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VariabilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}