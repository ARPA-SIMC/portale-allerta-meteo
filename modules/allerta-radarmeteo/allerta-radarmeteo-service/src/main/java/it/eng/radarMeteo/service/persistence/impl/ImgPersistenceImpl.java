/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence.impl;

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

import it.eng.radarMeteo.exception.NoSuchImgException;
import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.model.ImgTable;
import it.eng.radarMeteo.model.impl.ImgImpl;
import it.eng.radarMeteo.model.impl.ImgModelImpl;
import it.eng.radarMeteo.service.persistence.ImgPersistence;
import it.eng.radarMeteo.service.persistence.ImgUtil;
import it.eng.radarMeteo.service.persistence.impl.constants.rt_portletPersistenceConstants;

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
 * The persistence implementation for the img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @generated
 */
@Component(service = ImgPersistence.class)
public class ImgPersistenceImpl
	extends BasePersistenceImpl<Img> implements ImgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImgUtil</code> to access the img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImgImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBytimeStamp;
	private FinderPath _finderPathWithoutPaginationFindBytimeStamp;
	private FinderPath _finderPathCountBytimeStamp;

	/**
	 * Returns all the imgs where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching imgs
	 */
	@Override
	public List<Img> findBytimeStamp(long timestamp) {
		return findBytimeStamp(
			timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	@Override
	public List<Img> findBytimeStamp(long timestamp, int start, int end) {
		return findBytimeStamp(timestamp, start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findBytimeStamp(
		long timestamp, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return findBytimeStamp(timestamp, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findBytimeStamp(
		long timestamp, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytimeStamp;
				finderArgs = new Object[] {timestamp};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytimeStamp;
			finderArgs = new Object[] {
				timestamp, start, end, orderByComparator
			};
		}

		List<Img> list = null;

		if (useFinderCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Img img : list) {
					if (timestamp != img.getTimestamp()) {
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

			sb.append(_SQL_SELECT_IMG_WHERE);

			sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImgModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(timestamp);

				list = (List<Img>)QueryUtil.list(
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
	 * Returns the first img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findBytimeStamp_First(
			long timestamp, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchBytimeStamp_First(timestamp, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("timestamp=");
		sb.append(timestamp);

		sb.append("}");

		throw new NoSuchImgException(sb.toString());
	}

	/**
	 * Returns the first img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchBytimeStamp_First(
		long timestamp, OrderByComparator<Img> orderByComparator) {

		List<Img> list = findBytimeStamp(timestamp, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findBytimeStamp_Last(
			long timestamp, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchBytimeStamp_Last(timestamp, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("timestamp=");
		sb.append(timestamp);

		sb.append("}");

		throw new NoSuchImgException(sb.toString());
	}

	/**
	 * Returns the last img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchBytimeStamp_Last(
		long timestamp, OrderByComparator<Img> orderByComparator) {

		int count = countBytimeStamp(timestamp);

		if (count == 0) {
			return null;
		}

		List<Img> list = findBytimeStamp(
			timestamp, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where timestamp = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img[] findBytimeStamp_PrevAndNext(
			long id, long timestamp, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Img[] array = new ImgImpl[3];

			array[0] = getBytimeStamp_PrevAndNext(
				session, img, timestamp, orderByComparator, true);

			array[1] = img;

			array[2] = getBytimeStamp_PrevAndNext(
				session, img, timestamp, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Img getBytimeStamp_PrevAndNext(
		Session session, Img img, long timestamp,
		OrderByComparator<Img> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IMG_WHERE);

		sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);

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
			sb.append(ImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(timestamp);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(img)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Img> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the imgs where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 */
	@Override
	public void removeBytimeStamp(long timestamp) {
		for (Img img :
				findBytimeStamp(
					timestamp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(img);
		}
	}

	/**
	 * Returns the number of imgs where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching imgs
	 */
	@Override
	public int countBytimeStamp(long timestamp) {
		FinderPath finderPath = _finderPathCountBytimeStamp;

		Object[] finderArgs = new Object[] {timestamp};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMG_WHERE);

			sb.append(_FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(timestamp);

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

	private static final String _FINDER_COLUMN_TIMESTAMP_TIMESTAMP_2 =
		"img.timestamp = ?";

	public ImgPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("data", "data_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Img.class);

		setModelImplClass(ImgImpl.class);
		setModelPKClass(long.class);

		setTable(ImgTable.INSTANCE);
	}

	/**
	 * Caches the img in the entity cache if it is enabled.
	 *
	 * @param img the img
	 */
	@Override
	public void cacheResult(Img img) {
		entityCache.putResult(ImgImpl.class, img.getPrimaryKey(), img);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the imgs in the entity cache if it is enabled.
	 *
	 * @param imgs the imgs
	 */
	@Override
	public void cacheResult(List<Img> imgs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (imgs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Img img : imgs) {
			if (entityCache.getResult(ImgImpl.class, img.getPrimaryKey()) ==
					null) {

				cacheResult(img);
			}
		}
	}

	/**
	 * Clears the cache for all imgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImgImpl.class);

		finderCache.clearCache(ImgImpl.class);
	}

	/**
	 * Clears the cache for the img.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Img img) {
		entityCache.removeResult(ImgImpl.class, img);
	}

	@Override
	public void clearCache(List<Img> imgs) {
		for (Img img : imgs) {
			entityCache.removeResult(ImgImpl.class, img);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ImgImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ImgImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new img with the primary key. Does not add the img to the database.
	 *
	 * @param id the primary key for the new img
	 * @return the new img
	 */
	@Override
	public Img create(long id) {
		Img img = new ImgImpl();

		img.setNew(true);
		img.setPrimaryKey(id);

		return img;
	}

	/**
	 * Removes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the img
	 * @return the img that was removed
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img remove(long id) throws NoSuchImgException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the img
	 * @return the img that was removed
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img remove(Serializable primaryKey) throws NoSuchImgException {
		Session session = null;

		try {
			session = openSession();

			Img img = (Img)session.get(ImgImpl.class, primaryKey);

			if (img == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(img);
		}
		catch (NoSuchImgException noSuchEntityException) {
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
	protected Img removeImpl(Img img) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(img)) {
				img = (Img)session.get(ImgImpl.class, img.getPrimaryKeyObj());
			}

			if (img != null) {
				session.delete(img);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (img != null) {
			clearCache(img);
		}

		return img;
	}

	@Override
	public Img updateImpl(Img img) {
		boolean isNew = img.isNew();

		if (!(img instanceof ImgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(img.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(img);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in img proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Img implementation " +
					img.getClass());
		}

		ImgModelImpl imgModelImpl = (ImgModelImpl)img;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(img);
			}
			else {
				img = (Img)session.merge(img);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ImgImpl.class, imgModelImpl, false, true);

		if (isNew) {
			img.setNew(false);
		}

		img.resetOriginalValues();

		return img;
	}

	/**
	 * Returns the img with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the img
	 * @return the img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImgException {

		Img img = fetchByPrimaryKey(primaryKey);

		if (img == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return img;
	}

	/**
	 * Returns the img with the primary key or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img findByPrimaryKey(long id) throws NoSuchImgException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img, or <code>null</code> if a img with the primary key could not be found
	 */
	@Override
	public Img fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the imgs.
	 *
	 * @return the imgs
	 */
	@Override
	public List<Img> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of imgs
	 */
	@Override
	public List<Img> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of imgs
	 */
	@Override
	public List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of imgs
	 */
	@Override
	public List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator,
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

		List<Img> list = null;

		if (useFinderCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IMG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IMG;

				sql = sql.concat(ImgModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Img>)QueryUtil.list(
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
	 * Removes all the imgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Img img : findAll()) {
			remove(img);
		}
	}

	/**
	 * Returns the number of imgs.
	 *
	 * @return the number of imgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IMG);

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
		return _SQL_SELECT_IMG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ImgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the img persistence.
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

		_finderPathWithPaginationFindBytimeStamp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytimeStamp",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"timestamp"}, true);

		_finderPathWithoutPaginationFindBytimeStamp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytimeStamp",
			new String[] {Long.class.getName()}, new String[] {"timestamp"},
			true);

		_finderPathCountBytimeStamp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytimeStamp",
			new String[] {Long.class.getName()}, new String[] {"timestamp"},
			false);

		ImgUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ImgUtil.setPersistence(null);

		entityCache.removeCache(ImgImpl.class.getName());
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rt_portletPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IMG = "SELECT img FROM Img img";

	private static final String _SQL_SELECT_IMG_WHERE =
		"SELECT img FROM Img img WHERE ";

	private static final String _SQL_COUNT_IMG =
		"SELECT COUNT(img) FROM Img img";

	private static final String _SQL_COUNT_IMG_WHERE =
		"SELECT COUNT(img) FROM Img img WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "img.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Img exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Img exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "data"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}