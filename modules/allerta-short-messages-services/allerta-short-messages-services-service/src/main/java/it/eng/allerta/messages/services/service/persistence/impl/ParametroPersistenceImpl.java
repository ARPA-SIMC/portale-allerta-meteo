/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.impl;

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

import it.eng.allerta.messages.services.exception.NoSuchParametroException;
import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.model.ParametroTable;
import it.eng.allerta.messages.services.model.impl.ParametroImpl;
import it.eng.allerta.messages.services.model.impl.ParametroModelImpl;
import it.eng.allerta.messages.services.service.persistence.ParametroPersistence;
import it.eng.allerta.messages.services.service.persistence.ParametroUtil;
import it.eng.allerta.messages.services.service.persistence.impl.constants.smsServicePersistenceConstants;

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
 * The persistence implementation for the parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @generated
 */
@Component(service = ParametroPersistence.class)
public class ParametroPersistenceImpl
	extends BasePersistenceImpl<Parametro> implements ParametroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParametroUtil</code> to access the parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParametroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBynodo;
	private FinderPath _finderPathWithoutPaginationFindBynodo;
	private FinderPath _finderPathCountBynodo;

	/**
	 * Returns all the parametros where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @return the matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(String nodo) {
		return findBynodo(nodo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(String nodo, int start, int end) {
		return findBynodo(nodo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(
		String nodo, int start, int end,
		OrderByComparator<Parametro> orderByComparator) {

		return findBynodo(nodo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametros where nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param nodo the nodo
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parametros
	 */
	@Override
	public List<Parametro> findBynodo(
		String nodo, int start, int end,
		OrderByComparator<Parametro> orderByComparator,
		boolean useFinderCache) {

		nodo = Objects.toString(nodo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBynodo;
				finderArgs = new Object[] {nodo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBynodo;
			finderArgs = new Object[] {nodo, start, end, orderByComparator};
		}

		List<Parametro> list = null;

		if (useFinderCache) {
			list = (List<Parametro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Parametro parametro : list) {
					if (!nodo.equals(parametro.getNodo())) {
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

			sb.append(_SQL_SELECT_PARAMETRO_WHERE);

			boolean bindNodo = false;

			if (nodo.isEmpty()) {
				sb.append(_FINDER_COLUMN_NODO_NODO_3);
			}
			else {
				bindNodo = true;

				sb.append(_FINDER_COLUMN_NODO_NODO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ParametroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNodo) {
					queryPos.add(nodo);
				}

				list = (List<Parametro>)QueryUtil.list(
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
	 * Returns the first parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parametro
	 * @throws NoSuchParametroException if a matching parametro could not be found
	 */
	@Override
	public Parametro findBynodo_First(
			String nodo, OrderByComparator<Parametro> orderByComparator)
		throws NoSuchParametroException {

		Parametro parametro = fetchBynodo_First(nodo, orderByComparator);

		if (parametro != null) {
			return parametro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nodo=");
		sb.append(nodo);

		sb.append("}");

		throw new NoSuchParametroException(sb.toString());
	}

	/**
	 * Returns the first parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parametro, or <code>null</code> if a matching parametro could not be found
	 */
	@Override
	public Parametro fetchBynodo_First(
		String nodo, OrderByComparator<Parametro> orderByComparator) {

		List<Parametro> list = findBynodo(nodo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parametro
	 * @throws NoSuchParametroException if a matching parametro could not be found
	 */
	@Override
	public Parametro findBynodo_Last(
			String nodo, OrderByComparator<Parametro> orderByComparator)
		throws NoSuchParametroException {

		Parametro parametro = fetchBynodo_Last(nodo, orderByComparator);

		if (parametro != null) {
			return parametro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nodo=");
		sb.append(nodo);

		sb.append("}");

		throw new NoSuchParametroException(sb.toString());
	}

	/**
	 * Returns the last parametro in the ordered set where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parametro, or <code>null</code> if a matching parametro could not be found
	 */
	@Override
	public Parametro fetchBynodo_Last(
		String nodo, OrderByComparator<Parametro> orderByComparator) {

		int count = countBynodo(nodo);

		if (count == 0) {
			return null;
		}

		List<Parametro> list = findBynodo(
			nodo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the parametros before and after the current parametro in the ordered set where nodo = &#63;.
	 *
	 * @param Id the primary key of the current parametro
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro[] findBynodo_PrevAndNext(
			long Id, String nodo,
			OrderByComparator<Parametro> orderByComparator)
		throws NoSuchParametroException {

		nodo = Objects.toString(nodo, "");

		Parametro parametro = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			Parametro[] array = new ParametroImpl[3];

			array[0] = getBynodo_PrevAndNext(
				session, parametro, nodo, orderByComparator, true);

			array[1] = parametro;

			array[2] = getBynodo_PrevAndNext(
				session, parametro, nodo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Parametro getBynodo_PrevAndNext(
		Session session, Parametro parametro, String nodo,
		OrderByComparator<Parametro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PARAMETRO_WHERE);

		boolean bindNodo = false;

		if (nodo.isEmpty()) {
			sb.append(_FINDER_COLUMN_NODO_NODO_3);
		}
		else {
			bindNodo = true;

			sb.append(_FINDER_COLUMN_NODO_NODO_2);
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
			sb.append(ParametroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNodo) {
			queryPos.add(nodo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(parametro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Parametro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the parametros where nodo = &#63; from the database.
	 *
	 * @param nodo the nodo
	 */
	@Override
	public void removeBynodo(String nodo) {
		for (Parametro parametro :
				findBynodo(nodo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(parametro);
		}
	}

	/**
	 * Returns the number of parametros where nodo = &#63;.
	 *
	 * @param nodo the nodo
	 * @return the number of matching parametros
	 */
	@Override
	public int countBynodo(String nodo) {
		nodo = Objects.toString(nodo, "");

		FinderPath finderPath = _finderPathCountBynodo;

		Object[] finderArgs = new Object[] {nodo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PARAMETRO_WHERE);

			boolean bindNodo = false;

			if (nodo.isEmpty()) {
				sb.append(_FINDER_COLUMN_NODO_NODO_3);
			}
			else {
				bindNodo = true;

				sb.append(_FINDER_COLUMN_NODO_NODO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNodo) {
					queryPos.add(nodo);
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

	private static final String _FINDER_COLUMN_NODO_NODO_2 =
		"parametro.nodo = ?";

	private static final String _FINDER_COLUMN_NODO_NODO_3 =
		"(parametro.nodo IS NULL OR parametro.nodo = '')";

	public ParametroPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Parametro.class);

		setModelImplClass(ParametroImpl.class);
		setModelPKClass(long.class);

		setTable(ParametroTable.INSTANCE);
	}

	/**
	 * Caches the parametro in the entity cache if it is enabled.
	 *
	 * @param parametro the parametro
	 */
	@Override
	public void cacheResult(Parametro parametro) {
		entityCache.putResult(
			ParametroImpl.class, parametro.getPrimaryKey(), parametro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	@Override
	public void cacheResult(List<Parametro> parametros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (parametros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Parametro parametro : parametros) {
			if (entityCache.getResult(
					ParametroImpl.class, parametro.getPrimaryKey()) == null) {

				cacheResult(parametro);
			}
		}
	}

	/**
	 * Clears the cache for all parametros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParametroImpl.class);

		finderCache.clearCache(ParametroImpl.class);
	}

	/**
	 * Clears the cache for the parametro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametro parametro) {
		entityCache.removeResult(ParametroImpl.class, parametro);
	}

	@Override
	public void clearCache(List<Parametro> parametros) {
		for (Parametro parametro : parametros) {
			entityCache.removeResult(ParametroImpl.class, parametro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ParametroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ParametroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param Id the primary key for the new parametro
	 * @return the new parametro
	 */
	@Override
	public Parametro create(long Id) {
		Parametro parametro = new ParametroImpl();

		parametro.setNew(true);
		parametro.setPrimaryKey(Id);

		return parametro;
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro remove(long Id) throws NoSuchParametroException {
		return remove((Serializable)Id);
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro remove(Serializable primaryKey)
		throws NoSuchParametroException {

		Session session = null;

		try {
			session = openSession();

			Parametro parametro = (Parametro)session.get(
				ParametroImpl.class, primaryKey);

			if (parametro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(parametro);
		}
		catch (NoSuchParametroException noSuchEntityException) {
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
	protected Parametro removeImpl(Parametro parametro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parametro)) {
				parametro = (Parametro)session.get(
					ParametroImpl.class, parametro.getPrimaryKeyObj());
			}

			if (parametro != null) {
				session.delete(parametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (parametro != null) {
			clearCache(parametro);
		}

		return parametro;
	}

	@Override
	public Parametro updateImpl(Parametro parametro) {
		boolean isNew = parametro.isNew();

		if (!(parametro instanceof ParametroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(parametro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(parametro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in parametro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Parametro implementation " +
					parametro.getClass());
		}

		ParametroModelImpl parametroModelImpl = (ParametroModelImpl)parametro;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(parametro);
			}
			else {
				parametro = (Parametro)session.merge(parametro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ParametroImpl.class, parametroModelImpl, false, true);

		if (isNew) {
			parametro.setNew(false);
		}

		parametro.resetOriginalValues();

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParametroException {

		Parametro parametro = fetchByPrimaryKey(primaryKey);

		if (parametro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParametroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or throws a <code>NoSuchParametroException</code> if it could not be found.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro findByPrimaryKey(long Id) throws NoSuchParametroException {
		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 */
	@Override
	public Parametro fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns all the parametros.
	 *
	 * @return the parametros
	 */
	@Override
	public List<Parametro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 */
	@Override
	public List<Parametro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametros
	 */
	@Override
	public List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parametros
	 */
	@Override
	public List<Parametro> findAll(
		int start, int end, OrderByComparator<Parametro> orderByComparator,
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

		List<Parametro> list = null;

		if (useFinderCache) {
			list = (List<Parametro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PARAMETRO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETRO;

				sql = sql.concat(ParametroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Parametro>)QueryUtil.list(
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
	 * Removes all the parametros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Parametro parametro : findAll()) {
			remove(parametro);
		}
	}

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PARAMETRO);

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
		return "Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PARAMETRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ParametroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the parametro persistence.
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

		_finderPathWithPaginationFindBynodo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynodo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nodo"}, true);

		_finderPathWithoutPaginationFindBynodo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynodo",
			new String[] {String.class.getName()}, new String[] {"nodo"}, true);

		_finderPathCountBynodo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynodo",
			new String[] {String.class.getName()}, new String[] {"nodo"},
			false);

		ParametroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ParametroUtil.setPersistence(null);

		entityCache.removeCache(ParametroImpl.class.getName());
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = smsServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PARAMETRO =
		"SELECT parametro FROM Parametro parametro";

	private static final String _SQL_SELECT_PARAMETRO_WHERE =
		"SELECT parametro FROM Parametro parametro WHERE ";

	private static final String _SQL_COUNT_PARAMETRO =
		"SELECT COUNT(parametro) FROM Parametro parametro";

	private static final String _SQL_COUNT_PARAMETRO_WHERE =
		"SELECT COUNT(parametro) FROM Parametro parametro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "parametro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Parametro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Parametro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ParametroPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}