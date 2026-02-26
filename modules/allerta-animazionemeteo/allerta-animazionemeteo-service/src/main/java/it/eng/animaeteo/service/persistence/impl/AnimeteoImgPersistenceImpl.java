/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service.persistence.impl;

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

import it.eng.animaeteo.exception.NoSuchAnimeteoImgException;
import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.model.AnimeteoImgTable;
import it.eng.animaeteo.model.impl.AnimeteoImgImpl;
import it.eng.animaeteo.model.impl.AnimeteoImgModelImpl;
import it.eng.animaeteo.service.persistence.AnimeteoImgPersistence;
import it.eng.animaeteo.service.persistence.AnimeteoImgUtil;
import it.eng.animaeteo.service.persistence.impl.constants.animeteoPersistenceConstants;

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
 * The persistence implementation for the animeteo img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = AnimeteoImgPersistence.class)
public class AnimeteoImgPersistenceImpl
	extends BasePersistenceImpl<AnimeteoImg> implements AnimeteoImgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimeteoImgUtil</code> to access the animeteo img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimeteoImgImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByImageData;
	private FinderPath _finderPathWithoutPaginationFindByImageData;
	private FinderPath _finderPathCountByImageData;

	/**
	 * Returns all the animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(String type) {
		return findByImageData(
			type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(String type, int start, int end) {
		return findByImageData(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator) {

		return findByImageData(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByImageData;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByImageData;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<AnimeteoImg> list = null;

		if (useFinderCache) {
			list = (List<AnimeteoImg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnimeteoImg animeteoImg : list) {
					if (!type.equals(animeteoImg.getType())) {
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

			sb.append(_SQL_SELECT_ANIMETEOIMG_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_IMAGEDATA_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_IMAGEDATA_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnimeteoImgModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<AnimeteoImg>)QueryUtil.list(
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
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg findByImageData_First(
			String type, OrderByComparator<AnimeteoImg> orderByComparator)
		throws NoSuchAnimeteoImgException {

		AnimeteoImg animeteoImg = fetchByImageData_First(
			type, orderByComparator);

		if (animeteoImg != null) {
			return animeteoImg;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchAnimeteoImgException(sb.toString());
	}

	/**
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg fetchByImageData_First(
		String type, OrderByComparator<AnimeteoImg> orderByComparator) {

		List<AnimeteoImg> list = findByImageData(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg findByImageData_Last(
			String type, OrderByComparator<AnimeteoImg> orderByComparator)
		throws NoSuchAnimeteoImgException {

		AnimeteoImg animeteoImg = fetchByImageData_Last(
			type, orderByComparator);

		if (animeteoImg != null) {
			return animeteoImg;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchAnimeteoImgException(sb.toString());
	}

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	@Override
	public AnimeteoImg fetchByImageData_Last(
		String type, OrderByComparator<AnimeteoImg> orderByComparator) {

		int count = countByImageData(type);

		if (count == 0) {
			return null;
		}

		List<AnimeteoImg> list = findByImageData(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animeteo imgs before and after the current animeteo img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg[] findByImageData_PrevAndNext(
			long id, String type,
			OrderByComparator<AnimeteoImg> orderByComparator)
		throws NoSuchAnimeteoImgException {

		type = Objects.toString(type, "");

		AnimeteoImg animeteoImg = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AnimeteoImg[] array = new AnimeteoImgImpl[3];

			array[0] = getByImageData_PrevAndNext(
				session, animeteoImg, type, orderByComparator, true);

			array[1] = animeteoImg;

			array[2] = getByImageData_PrevAndNext(
				session, animeteoImg, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimeteoImg getByImageData_PrevAndNext(
		Session session, AnimeteoImg animeteoImg, String type,
		OrderByComparator<AnimeteoImg> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANIMETEOIMG_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_IMAGEDATA_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_IMAGEDATA_TYPE_2);
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
			sb.append(AnimeteoImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(animeteoImg)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimeteoImg> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animeteo imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByImageData(String type) {
		for (AnimeteoImg animeteoImg :
				findByImageData(
					type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animeteoImg);
		}
	}

	/**
	 * Returns the number of animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo imgs
	 */
	@Override
	public int countByImageData(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByImageData;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANIMETEOIMG_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_IMAGEDATA_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_IMAGEDATA_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_IMAGEDATA_TYPE_2 =
		"animeteoImg.type = ?";

	private static final String _FINDER_COLUMN_IMAGEDATA_TYPE_3 =
		"(animeteoImg.type IS NULL OR animeteoImg.type = '')";

	public AnimeteoImgPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("data", "data_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnimeteoImg.class);

		setModelImplClass(AnimeteoImgImpl.class);
		setModelPKClass(long.class);

		setTable(AnimeteoImgTable.INSTANCE);
	}

	/**
	 * Caches the animeteo img in the entity cache if it is enabled.
	 *
	 * @param animeteoImg the animeteo img
	 */
	@Override
	public void cacheResult(AnimeteoImg animeteoImg) {
		entityCache.putResult(
			AnimeteoImgImpl.class, animeteoImg.getPrimaryKey(), animeteoImg);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the animeteo imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoImgs the animeteo imgs
	 */
	@Override
	public void cacheResult(List<AnimeteoImg> animeteoImgs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (animeteoImgs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnimeteoImg animeteoImg : animeteoImgs) {
			if (entityCache.getResult(
					AnimeteoImgImpl.class, animeteoImg.getPrimaryKey()) ==
						null) {

				cacheResult(animeteoImg);
			}
		}
	}

	/**
	 * Clears the cache for all animeteo imgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimeteoImgImpl.class);

		finderCache.clearCache(AnimeteoImgImpl.class);
	}

	/**
	 * Clears the cache for the animeteo img.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimeteoImg animeteoImg) {
		entityCache.removeResult(AnimeteoImgImpl.class, animeteoImg);
	}

	@Override
	public void clearCache(List<AnimeteoImg> animeteoImgs) {
		for (AnimeteoImg animeteoImg : animeteoImgs) {
			entityCache.removeResult(AnimeteoImgImpl.class, animeteoImg);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnimeteoImgImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnimeteoImgImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new animeteo img with the primary key. Does not add the animeteo img to the database.
	 *
	 * @param id the primary key for the new animeteo img
	 * @return the new animeteo img
	 */
	@Override
	public AnimeteoImg create(long id) {
		AnimeteoImg animeteoImg = new AnimeteoImgImpl();

		animeteoImg.setNew(true);
		animeteoImg.setPrimaryKey(id);

		return animeteoImg;
	}

	/**
	 * Removes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg remove(long id) throws NoSuchAnimeteoImgException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg remove(Serializable primaryKey)
		throws NoSuchAnimeteoImgException {

		Session session = null;

		try {
			session = openSession();

			AnimeteoImg animeteoImg = (AnimeteoImg)session.get(
				AnimeteoImgImpl.class, primaryKey);

			if (animeteoImg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimeteoImgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animeteoImg);
		}
		catch (NoSuchAnimeteoImgException noSuchEntityException) {
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
	protected AnimeteoImg removeImpl(AnimeteoImg animeteoImg) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animeteoImg)) {
				animeteoImg = (AnimeteoImg)session.get(
					AnimeteoImgImpl.class, animeteoImg.getPrimaryKeyObj());
			}

			if (animeteoImg != null) {
				session.delete(animeteoImg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (animeteoImg != null) {
			clearCache(animeteoImg);
		}

		return animeteoImg;
	}

	@Override
	public AnimeteoImg updateImpl(AnimeteoImg animeteoImg) {
		boolean isNew = animeteoImg.isNew();

		if (!(animeteoImg instanceof AnimeteoImgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(animeteoImg.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(animeteoImg);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in animeteoImg proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnimeteoImg implementation " +
					animeteoImg.getClass());
		}

		AnimeteoImgModelImpl animeteoImgModelImpl =
			(AnimeteoImgModelImpl)animeteoImg;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(animeteoImg);
			}
			else {
				animeteoImg = (AnimeteoImg)session.merge(animeteoImg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnimeteoImgImpl.class, animeteoImgModelImpl, false, true);

		if (isNew) {
			animeteoImg.setNew(false);
		}

		animeteoImg.resetOriginalValues();

		return animeteoImg;
	}

	/**
	 * Returns the animeteo img with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimeteoImgException {

		AnimeteoImg animeteoImg = fetchByPrimaryKey(primaryKey);

		if (animeteoImg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimeteoImgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animeteoImg;
	}

	/**
	 * Returns the animeteo img with the primary key or throws a <code>NoSuchAnimeteoImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg findByPrimaryKey(long id)
		throws NoSuchAnimeteoImgException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the animeteo img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img, or <code>null</code> if a animeteo img with the primary key could not be found
	 */
	@Override
	public AnimeteoImg fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the animeteo imgs.
	 *
	 * @return the animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll(
		int start, int end, OrderByComparator<AnimeteoImg> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animeteo imgs
	 */
	@Override
	public List<AnimeteoImg> findAll(
		int start, int end, OrderByComparator<AnimeteoImg> orderByComparator,
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

		List<AnimeteoImg> list = null;

		if (useFinderCache) {
			list = (List<AnimeteoImg>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANIMETEOIMG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMETEOIMG;

				sql = sql.concat(AnimeteoImgModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnimeteoImg>)QueryUtil.list(
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
	 * Removes all the animeteo imgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimeteoImg animeteoImg : findAll()) {
			remove(animeteoImg);
		}
	}

	/**
	 * Returns the number of animeteo imgs.
	 *
	 * @return the number of animeteo imgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANIMETEOIMG);

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
		return _SQL_SELECT_ANIMETEOIMG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnimeteoImgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animeteo img persistence.
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

		_finderPathWithPaginationFindByImageData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByImageData",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindByImageData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByImageData",
			new String[] {String.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountByImageData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByImageData",
			new String[] {String.class.getName()}, new String[] {"type_"},
			false);

		AnimeteoImgUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AnimeteoImgUtil.setPersistence(null);

		entityCache.removeCache(AnimeteoImgImpl.class.getName());
	}

	@Override
	@Reference(
		target = animeteoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = animeteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = animeteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ANIMETEOIMG =
		"SELECT animeteoImg FROM AnimeteoImg animeteoImg";

	private static final String _SQL_SELECT_ANIMETEOIMG_WHERE =
		"SELECT animeteoImg FROM AnimeteoImg animeteoImg WHERE ";

	private static final String _SQL_COUNT_ANIMETEOIMG =
		"SELECT COUNT(animeteoImg) FROM AnimeteoImg animeteoImg";

	private static final String _SQL_COUNT_ANIMETEOIMG_WHERE =
		"SELECT COUNT(animeteoImg) FROM AnimeteoImg animeteoImg WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animeteoImg.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimeteoImg exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnimeteoImg exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimeteoImgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type", "data"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}