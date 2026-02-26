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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import it.eng.parer.exception.NoSuchComponentiInvioException;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.ComponentiInvioTable;
import it.eng.parer.model.impl.ComponentiInvioImpl;
import it.eng.parer.model.impl.ComponentiInvioModelImpl;
import it.eng.parer.service.persistence.ComponentiInvioPK;
import it.eng.parer.service.persistence.ComponentiInvioPersistence;
import it.eng.parer.service.persistence.ComponentiInvioUtil;
import it.eng.parer.service.persistence.impl.constants.parerPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the componenti invio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = ComponentiInvioPersistence.class)
public class ComponentiInvioPersistenceImpl
	extends BasePersistenceImpl<ComponentiInvio>
	implements ComponentiInvioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ComponentiInvioUtil</code> to access the componenti invio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ComponentiInvioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByComponentiByIdInvio;
	private FinderPath _finderPathWithoutPaginationFindByComponentiByIdInvio;
	private FinderPath _finderPathCountByComponentiByIdInvio;

	/**
	 * Returns all the componenti invios where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the matching componenti invios
	 */
	@Override
	public List<ComponentiInvio> findByComponentiByIdInvio(long ID_INVIO) {
		return findByComponentiByIdInvio(
			ID_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of matching componenti invios
	 */
	@Override
	public List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end) {

		return findByComponentiByIdInvio(ID_INVIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching componenti invios
	 */
	@Override
	public List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator) {

		return findByComponentiByIdInvio(
			ID_INVIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching componenti invios
	 */
	@Override
	public List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByComponentiByIdInvio;
				finderArgs = new Object[] {ID_INVIO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByComponentiByIdInvio;
			finderArgs = new Object[] {ID_INVIO, start, end, orderByComparator};
		}

		List<ComponentiInvio> list = null;

		if (useFinderCache) {
			list = (List<ComponentiInvio>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ComponentiInvio componentiInvio : list) {
					if (ID_INVIO != componentiInvio.getID_INVIO()) {
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

			sb.append(_SQL_SELECT_COMPONENTIINVIO_WHERE);

			sb.append(_FINDER_COLUMN_COMPONENTIBYIDINVIO_ID_INVIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComponentiInvioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ID_INVIO);

				list = (List<ComponentiInvio>)QueryUtil.list(
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
	 * Returns the first componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching componenti invio
	 * @throws NoSuchComponentiInvioException if a matching componenti invio could not be found
	 */
	@Override
	public ComponentiInvio findByComponentiByIdInvio_First(
			long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator)
		throws NoSuchComponentiInvioException {

		ComponentiInvio componentiInvio = fetchByComponentiByIdInvio_First(
			ID_INVIO, orderByComparator);

		if (componentiInvio != null) {
			return componentiInvio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ID_INVIO=");
		sb.append(ID_INVIO);

		sb.append("}");

		throw new NoSuchComponentiInvioException(sb.toString());
	}

	/**
	 * Returns the first componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching componenti invio, or <code>null</code> if a matching componenti invio could not be found
	 */
	@Override
	public ComponentiInvio fetchByComponentiByIdInvio_First(
		long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator) {

		List<ComponentiInvio> list = findByComponentiByIdInvio(
			ID_INVIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching componenti invio
	 * @throws NoSuchComponentiInvioException if a matching componenti invio could not be found
	 */
	@Override
	public ComponentiInvio findByComponentiByIdInvio_Last(
			long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator)
		throws NoSuchComponentiInvioException {

		ComponentiInvio componentiInvio = fetchByComponentiByIdInvio_Last(
			ID_INVIO, orderByComparator);

		if (componentiInvio != null) {
			return componentiInvio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ID_INVIO=");
		sb.append(ID_INVIO);

		sb.append("}");

		throw new NoSuchComponentiInvioException(sb.toString());
	}

	/**
	 * Returns the last componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching componenti invio, or <code>null</code> if a matching componenti invio could not be found
	 */
	@Override
	public ComponentiInvio fetchByComponentiByIdInvio_Last(
		long ID_INVIO, OrderByComparator<ComponentiInvio> orderByComparator) {

		int count = countByComponentiByIdInvio(ID_INVIO);

		if (count == 0) {
			return null;
		}

		List<ComponentiInvio> list = findByComponentiByIdInvio(
			ID_INVIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the componenti invios before and after the current componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param componentiInvioPK the primary key of the current componenti invio
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	@Override
	public ComponentiInvio[] findByComponentiByIdInvio_PrevAndNext(
			ComponentiInvioPK componentiInvioPK, long ID_INVIO,
			OrderByComparator<ComponentiInvio> orderByComparator)
		throws NoSuchComponentiInvioException {

		ComponentiInvio componentiInvio = findByPrimaryKey(componentiInvioPK);

		Session session = null;

		try {
			session = openSession();

			ComponentiInvio[] array = new ComponentiInvioImpl[3];

			array[0] = getByComponentiByIdInvio_PrevAndNext(
				session, componentiInvio, ID_INVIO, orderByComparator, true);

			array[1] = componentiInvio;

			array[2] = getByComponentiByIdInvio_PrevAndNext(
				session, componentiInvio, ID_INVIO, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ComponentiInvio getByComponentiByIdInvio_PrevAndNext(
		Session session, ComponentiInvio componentiInvio, long ID_INVIO,
		OrderByComparator<ComponentiInvio> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPONENTIINVIO_WHERE);

		sb.append(_FINDER_COLUMN_COMPONENTIBYIDINVIO_ID_INVIO_2);

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
			sb.append(ComponentiInvioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ID_INVIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						componentiInvio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComponentiInvio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the componenti invios where ID_INVIO = &#63; from the database.
	 *
	 * @param ID_INVIO the id_invio
	 */
	@Override
	public void removeByComponentiByIdInvio(long ID_INVIO) {
		for (ComponentiInvio componentiInvio :
				findByComponentiByIdInvio(
					ID_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(componentiInvio);
		}
	}

	/**
	 * Returns the number of componenti invios where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the number of matching componenti invios
	 */
	@Override
	public int countByComponentiByIdInvio(long ID_INVIO) {
		FinderPath finderPath = _finderPathCountByComponentiByIdInvio;

		Object[] finderArgs = new Object[] {ID_INVIO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPONENTIINVIO_WHERE);

			sb.append(_FINDER_COLUMN_COMPONENTIBYIDINVIO_ID_INVIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ID_INVIO);

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

	private static final String _FINDER_COLUMN_COMPONENTIBYIDINVIO_ID_INVIO_2 =
		"componentiInvio.id.ID_INVIO = ?";

	public ComponentiInvioPersistenceImpl() {
		setModelClass(ComponentiInvio.class);

		setModelImplClass(ComponentiInvioImpl.class);
		setModelPKClass(ComponentiInvioPK.class);

		setTable(ComponentiInvioTable.INSTANCE);
	}

	/**
	 * Caches the componenti invio in the entity cache if it is enabled.
	 *
	 * @param componentiInvio the componenti invio
	 */
	@Override
	public void cacheResult(ComponentiInvio componentiInvio) {
		dummyEntityCache.putResult(
			ComponentiInvioImpl.class, componentiInvio.getPrimaryKey(),
			componentiInvio);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the componenti invios in the entity cache if it is enabled.
	 *
	 * @param componentiInvios the componenti invios
	 */
	@Override
	public void cacheResult(List<ComponentiInvio> componentiInvios) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (componentiInvios.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ComponentiInvio componentiInvio : componentiInvios) {
			if (dummyEntityCache.getResult(
					ComponentiInvioImpl.class,
					componentiInvio.getPrimaryKey()) == null) {

				cacheResult(componentiInvio);
			}
		}
	}

	/**
	 * Clears the cache for all componenti invios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ComponentiInvioImpl.class);

		dummyFinderCache.clearCache(ComponentiInvioImpl.class);
	}

	/**
	 * Clears the cache for the componenti invio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ComponentiInvio componentiInvio) {
		dummyEntityCache.removeResult(
			ComponentiInvioImpl.class, componentiInvio);
	}

	@Override
	public void clearCache(List<ComponentiInvio> componentiInvios) {
		for (ComponentiInvio componentiInvio : componentiInvios) {
			dummyEntityCache.removeResult(
				ComponentiInvioImpl.class, componentiInvio);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ComponentiInvioImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ComponentiInvioImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new componenti invio with the primary key. Does not add the componenti invio to the database.
	 *
	 * @param componentiInvioPK the primary key for the new componenti invio
	 * @return the new componenti invio
	 */
	@Override
	public ComponentiInvio create(ComponentiInvioPK componentiInvioPK) {
		ComponentiInvio componentiInvio = new ComponentiInvioImpl();

		componentiInvio.setNew(true);
		componentiInvio.setPrimaryKey(componentiInvioPK);

		return componentiInvio;
	}

	/**
	 * Removes the componenti invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio that was removed
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	@Override
	public ComponentiInvio remove(ComponentiInvioPK componentiInvioPK)
		throws NoSuchComponentiInvioException {

		return remove((Serializable)componentiInvioPK);
	}

	/**
	 * Removes the componenti invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the componenti invio
	 * @return the componenti invio that was removed
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	@Override
	public ComponentiInvio remove(Serializable primaryKey)
		throws NoSuchComponentiInvioException {

		Session session = null;

		try {
			session = openSession();

			ComponentiInvio componentiInvio = (ComponentiInvio)session.get(
				ComponentiInvioImpl.class, primaryKey);

			if (componentiInvio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComponentiInvioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(componentiInvio);
		}
		catch (NoSuchComponentiInvioException noSuchEntityException) {
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
	protected ComponentiInvio removeImpl(ComponentiInvio componentiInvio) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(componentiInvio)) {
				componentiInvio = (ComponentiInvio)session.get(
					ComponentiInvioImpl.class,
					componentiInvio.getPrimaryKeyObj());
			}

			if (componentiInvio != null) {
				session.delete(componentiInvio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (componentiInvio != null) {
			clearCache(componentiInvio);
		}

		return componentiInvio;
	}

	@Override
	public ComponentiInvio updateImpl(ComponentiInvio componentiInvio) {
		boolean isNew = componentiInvio.isNew();

		if (!(componentiInvio instanceof ComponentiInvioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(componentiInvio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					componentiInvio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in componentiInvio proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ComponentiInvio implementation " +
					componentiInvio.getClass());
		}

		ComponentiInvioModelImpl componentiInvioModelImpl =
			(ComponentiInvioModelImpl)componentiInvio;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(componentiInvio);
			}
			else {
				componentiInvio = (ComponentiInvio)session.merge(
					componentiInvio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ComponentiInvioImpl.class, componentiInvioModelImpl, false, true);

		if (isNew) {
			componentiInvio.setNew(false);
		}

		componentiInvio.resetOriginalValues();

		return componentiInvio;
	}

	/**
	 * Returns the componenti invio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the componenti invio
	 * @return the componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	@Override
	public ComponentiInvio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComponentiInvioException {

		ComponentiInvio componentiInvio = fetchByPrimaryKey(primaryKey);

		if (componentiInvio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComponentiInvioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return componentiInvio;
	}

	/**
	 * Returns the componenti invio with the primary key or throws a <code>NoSuchComponentiInvioException</code> if it could not be found.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	@Override
	public ComponentiInvio findByPrimaryKey(ComponentiInvioPK componentiInvioPK)
		throws NoSuchComponentiInvioException {

		return findByPrimaryKey((Serializable)componentiInvioPK);
	}

	/**
	 * Returns the componenti invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio, or <code>null</code> if a componenti invio with the primary key could not be found
	 */
	@Override
	public ComponentiInvio fetchByPrimaryKey(
		ComponentiInvioPK componentiInvioPK) {

		return fetchByPrimaryKey((Serializable)componentiInvioPK);
	}

	/**
	 * Returns all the componenti invios.
	 *
	 * @return the componenti invios
	 */
	@Override
	public List<ComponentiInvio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of componenti invios
	 */
	@Override
	public List<ComponentiInvio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of componenti invios
	 */
	@Override
	public List<ComponentiInvio> findAll(
		int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of componenti invios
	 */
	@Override
	public List<ComponentiInvio> findAll(
		int start, int end,
		OrderByComparator<ComponentiInvio> orderByComparator,
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

		List<ComponentiInvio> list = null;

		if (useFinderCache) {
			list = (List<ComponentiInvio>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPONENTIINVIO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPONENTIINVIO;

				sql = sql.concat(ComponentiInvioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ComponentiInvio>)QueryUtil.list(
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
	 * Removes all the componenti invios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ComponentiInvio componentiInvio : findAll()) {
			remove(componentiInvio);
		}
	}

	/**
	 * Returns the number of componenti invios.
	 *
	 * @return the number of componenti invios
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMPONENTIINVIO);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "componentiInvioPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPONENTIINVIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ComponentiInvioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the componenti invio persistence.
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

		_finderPathWithPaginationFindByComponentiByIdInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComponentiByIdInvio",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ID_INVIO"}, true);

		_finderPathWithoutPaginationFindByComponentiByIdInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByComponentiByIdInvio", new String[] {Long.class.getName()},
			new String[] {"ID_INVIO"}, true);

		_finderPathCountByComponentiByIdInvio = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByComponentiByIdInvio", new String[] {Long.class.getName()},
			new String[] {"ID_INVIO"}, false);

		ComponentiInvioUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ComponentiInvioUtil.setPersistence(null);

		dummyEntityCache.removeCache(ComponentiInvioImpl.class.getName());
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

	private static final String _SQL_SELECT_COMPONENTIINVIO =
		"SELECT componentiInvio FROM ComponentiInvio componentiInvio";

	private static final String _SQL_SELECT_COMPONENTIINVIO_WHERE =
		"SELECT componentiInvio FROM ComponentiInvio componentiInvio WHERE ";

	private static final String _SQL_COUNT_COMPONENTIINVIO =
		"SELECT COUNT(componentiInvio) FROM ComponentiInvio componentiInvio";

	private static final String _SQL_COUNT_COMPONENTIINVIO_WHERE =
		"SELECT COUNT(componentiInvio) FROM ComponentiInvio componentiInvio WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "componentiInvio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ComponentiInvio exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ComponentiInvio exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ComponentiInvioPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"ID_INVIO", "ID_COMPONENTE"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}