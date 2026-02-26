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

import it.eng.animaeteo.exception.NoSuchAnimeteoSmallImgException;
import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.model.AnimeteoSmallImgTable;
import it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl;
import it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgPersistence;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgUtil;
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
 * The persistence implementation for the animeteo small img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @generated
 */
@Component(service = AnimeteoSmallImgPersistence.class)
public class AnimeteoSmallImgPersistenceImpl
	extends BasePersistenceImpl<AnimeteoSmallImg>
	implements AnimeteoSmallImgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimeteoSmallImgUtil</code> to access the animeteo small img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimeteoSmallImgImpl.class.getName();

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
	 * Returns all the animeteo small imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(String type) {
		return findByImageData(
			type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end) {

		return findByImageData(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		return findByImageData(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator,
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

		List<AnimeteoSmallImg> list = null;

		if (useFinderCache) {
			list = (List<AnimeteoSmallImg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnimeteoSmallImg animeteoSmallImg : list) {
					if (!type.equals(animeteoSmallImg.getType())) {
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

			sb.append(_SQL_SELECT_ANIMETEOSMALLIMG_WHERE);

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
				sb.append(AnimeteoSmallImgModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimeteoSmallImg>)QueryUtil.list(
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
	 * Returns the first animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg findByImageData_First(
			String type, OrderByComparator<AnimeteoSmallImg> orderByComparator)
		throws NoSuchAnimeteoSmallImgException {

		AnimeteoSmallImg animeteoSmallImg = fetchByImageData_First(
			type, orderByComparator);

		if (animeteoSmallImg != null) {
			return animeteoSmallImg;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchAnimeteoSmallImgException(sb.toString());
	}

	/**
	 * Returns the first animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo small img, or <code>null</code> if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByImageData_First(
		String type, OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		List<AnimeteoSmallImg> list = findByImageData(
			type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg findByImageData_Last(
			String type, OrderByComparator<AnimeteoSmallImg> orderByComparator)
		throws NoSuchAnimeteoSmallImgException {

		AnimeteoSmallImg animeteoSmallImg = fetchByImageData_Last(
			type, orderByComparator);

		if (animeteoSmallImg != null) {
			return animeteoSmallImg;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchAnimeteoSmallImgException(sb.toString());
	}

	/**
	 * Returns the last animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo small img, or <code>null</code> if a matching animeteo small img could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByImageData_Last(
		String type, OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		int count = countByImageData(type);

		if (count == 0) {
			return null;
		}

		List<AnimeteoSmallImg> list = findByImageData(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animeteo small imgs before and after the current animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo small img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg[] findByImageData_PrevAndNext(
			long id, String type,
			OrderByComparator<AnimeteoSmallImg> orderByComparator)
		throws NoSuchAnimeteoSmallImgException {

		type = Objects.toString(type, "");

		AnimeteoSmallImg animeteoSmallImg = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AnimeteoSmallImg[] array = new AnimeteoSmallImgImpl[3];

			array[0] = getByImageData_PrevAndNext(
				session, animeteoSmallImg, type, orderByComparator, true);

			array[1] = animeteoSmallImg;

			array[2] = getByImageData_PrevAndNext(
				session, animeteoSmallImg, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimeteoSmallImg getByImageData_PrevAndNext(
		Session session, AnimeteoSmallImg animeteoSmallImg, String type,
		OrderByComparator<AnimeteoSmallImg> orderByComparator,
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

		sb.append(_SQL_SELECT_ANIMETEOSMALLIMG_WHERE);

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
			sb.append(AnimeteoSmallImgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						animeteoSmallImg)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimeteoSmallImg> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animeteo small imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByImageData(String type) {
		for (AnimeteoSmallImg animeteoSmallImg :
				findByImageData(
					type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animeteoSmallImg);
		}
	}

	/**
	 * Returns the number of animeteo small imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo small imgs
	 */
	@Override
	public int countByImageData(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByImageData;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANIMETEOSMALLIMG_WHERE);

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
		"animeteoSmallImg.type = ?";

	private static final String _FINDER_COLUMN_IMAGEDATA_TYPE_3 =
		"(animeteoSmallImg.type IS NULL OR animeteoSmallImg.type = '')";

	public AnimeteoSmallImgPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("data", "data_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnimeteoSmallImg.class);

		setModelImplClass(AnimeteoSmallImgImpl.class);
		setModelPKClass(long.class);

		setTable(AnimeteoSmallImgTable.INSTANCE);
	}

	/**
	 * Caches the animeteo small img in the entity cache if it is enabled.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 */
	@Override
	public void cacheResult(AnimeteoSmallImg animeteoSmallImg) {
		entityCache.putResult(
			AnimeteoSmallImgImpl.class, animeteoSmallImg.getPrimaryKey(),
			animeteoSmallImg);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the animeteo small imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoSmallImgs the animeteo small imgs
	 */
	@Override
	public void cacheResult(List<AnimeteoSmallImg> animeteoSmallImgs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (animeteoSmallImgs.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnimeteoSmallImg animeteoSmallImg : animeteoSmallImgs) {
			if (entityCache.getResult(
					AnimeteoSmallImgImpl.class,
					animeteoSmallImg.getPrimaryKey()) == null) {

				cacheResult(animeteoSmallImg);
			}
		}
	}

	/**
	 * Clears the cache for all animeteo small imgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimeteoSmallImgImpl.class);

		finderCache.clearCache(AnimeteoSmallImgImpl.class);
	}

	/**
	 * Clears the cache for the animeteo small img.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimeteoSmallImg animeteoSmallImg) {
		entityCache.removeResult(AnimeteoSmallImgImpl.class, animeteoSmallImg);
	}

	@Override
	public void clearCache(List<AnimeteoSmallImg> animeteoSmallImgs) {
		for (AnimeteoSmallImg animeteoSmallImg : animeteoSmallImgs) {
			entityCache.removeResult(
				AnimeteoSmallImgImpl.class, animeteoSmallImg);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnimeteoSmallImgImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnimeteoSmallImgImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	@Override
	public AnimeteoSmallImg create(long id) {
		AnimeteoSmallImg animeteoSmallImg = new AnimeteoSmallImgImpl();

		animeteoSmallImg.setNew(true);
		animeteoSmallImg.setPrimaryKey(id);

		return animeteoSmallImg;
	}

	/**
	 * Removes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg remove(long id)
		throws NoSuchAnimeteoSmallImgException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg remove(Serializable primaryKey)
		throws NoSuchAnimeteoSmallImgException {

		Session session = null;

		try {
			session = openSession();

			AnimeteoSmallImg animeteoSmallImg = (AnimeteoSmallImg)session.get(
				AnimeteoSmallImgImpl.class, primaryKey);

			if (animeteoSmallImg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimeteoSmallImgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animeteoSmallImg);
		}
		catch (NoSuchAnimeteoSmallImgException noSuchEntityException) {
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
	protected AnimeteoSmallImg removeImpl(AnimeteoSmallImg animeteoSmallImg) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animeteoSmallImg)) {
				animeteoSmallImg = (AnimeteoSmallImg)session.get(
					AnimeteoSmallImgImpl.class,
					animeteoSmallImg.getPrimaryKeyObj());
			}

			if (animeteoSmallImg != null) {
				session.delete(animeteoSmallImg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (animeteoSmallImg != null) {
			clearCache(animeteoSmallImg);
		}

		return animeteoSmallImg;
	}

	@Override
	public AnimeteoSmallImg updateImpl(AnimeteoSmallImg animeteoSmallImg) {
		boolean isNew = animeteoSmallImg.isNew();

		if (!(animeteoSmallImg instanceof AnimeteoSmallImgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(animeteoSmallImg.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					animeteoSmallImg);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in animeteoSmallImg proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnimeteoSmallImg implementation " +
					animeteoSmallImg.getClass());
		}

		AnimeteoSmallImgModelImpl animeteoSmallImgModelImpl =
			(AnimeteoSmallImgModelImpl)animeteoSmallImg;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(animeteoSmallImg);
			}
			else {
				animeteoSmallImg = (AnimeteoSmallImg)session.merge(
					animeteoSmallImg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnimeteoSmallImgImpl.class, animeteoSmallImgModelImpl, false, true);

		if (isNew) {
			animeteoSmallImg.setNew(false);
		}

		animeteoSmallImg.resetOriginalValues();

		return animeteoSmallImg;
	}

	/**
	 * Returns the animeteo small img with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimeteoSmallImgException {

		AnimeteoSmallImg animeteoSmallImg = fetchByPrimaryKey(primaryKey);

		if (animeteoSmallImg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimeteoSmallImgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animeteoSmallImg;
	}

	/**
	 * Returns the animeteo small img with the primary key or throws a <code>NoSuchAnimeteoSmallImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg findByPrimaryKey(long id)
		throws NoSuchAnimeteoSmallImgException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the animeteo small img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img, or <code>null</code> if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the animeteo small imgs.
	 *
	 * @return the animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll(
		int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> findAll(
		int start, int end,
		OrderByComparator<AnimeteoSmallImg> orderByComparator,
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

		List<AnimeteoSmallImg> list = null;

		if (useFinderCache) {
			list = (List<AnimeteoSmallImg>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANIMETEOSMALLIMG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMETEOSMALLIMG;

				sql = sql.concat(AnimeteoSmallImgModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnimeteoSmallImg>)QueryUtil.list(
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
	 * Removes all the animeteo small imgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimeteoSmallImg animeteoSmallImg : findAll()) {
			remove(animeteoSmallImg);
		}
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANIMETEOSMALLIMG);

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
		return _SQL_SELECT_ANIMETEOSMALLIMG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnimeteoSmallImgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animeteo small img persistence.
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

		AnimeteoSmallImgUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AnimeteoSmallImgUtil.setPersistence(null);

		entityCache.removeCache(AnimeteoSmallImgImpl.class.getName());
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

	private static final String _SQL_SELECT_ANIMETEOSMALLIMG =
		"SELECT animeteoSmallImg FROM AnimeteoSmallImg animeteoSmallImg";

	private static final String _SQL_SELECT_ANIMETEOSMALLIMG_WHERE =
		"SELECT animeteoSmallImg FROM AnimeteoSmallImg animeteoSmallImg WHERE ";

	private static final String _SQL_COUNT_ANIMETEOSMALLIMG =
		"SELECT COUNT(animeteoSmallImg) FROM AnimeteoSmallImg animeteoSmallImg";

	private static final String _SQL_COUNT_ANIMETEOSMALLIMG_WHERE =
		"SELECT COUNT(animeteoSmallImg) FROM AnimeteoSmallImg animeteoSmallImg WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animeteoSmallImg.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimeteoSmallImg exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnimeteoSmallImg exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimeteoSmallImgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type", "data"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}