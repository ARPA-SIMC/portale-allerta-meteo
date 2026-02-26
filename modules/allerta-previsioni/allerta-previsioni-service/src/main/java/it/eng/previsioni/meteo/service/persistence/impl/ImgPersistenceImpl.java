/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.previsioni.meteo.exception.NoSuchImgException;
import it.eng.previsioni.meteo.model.Img;
import it.eng.previsioni.meteo.model.ImgTable;
import it.eng.previsioni.meteo.model.impl.ImgImpl;
import it.eng.previsioni.meteo.model.impl.ImgModelImpl;
import it.eng.previsioni.meteo.service.persistence.ImgPersistence;
import it.eng.previsioni.meteo.service.persistence.ImgUtil;
import it.eng.previsioni.meteo.service.persistence.impl.constants.prev_meteoPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
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
	private FinderPath _finderPathWithPaginationFindByday;
	private FinderPath _finderPathWithoutPaginationFindByday;
	private FinderPath _finderPathCountByday;

	/**
	 * Returns all the imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the matching imgs
	 */
	@Override
	public List<Img> findByday(String day) {
		return findByday(day, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	@Override
	public List<Img> findByday(String day, int start, int end) {
		return findByday(day, start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByday(
		String day, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return findByday(day, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByday(
		String day, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean useFinderCache) {

		day = Objects.toString(day, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByday;
				finderArgs = new Object[] {day};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByday;
			finderArgs = new Object[] {day, start, end, orderByComparator};
		}

		List<Img> list = null;

		if (useFinderCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Img img : list) {
					if (!day.equals(img.getDay())) {
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

			boolean bindDay = false;

			if (day.isEmpty()) {
				sb.append(_FINDER_COLUMN_DAY_DAY_3);
			}
			else {
				bindDay = true;

				sb.append(_FINDER_COLUMN_DAY_DAY_2);
			}

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

				if (bindDay) {
					queryPos.add(day);
				}

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
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByday_First(
			String day, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByday_First(day, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("day=");
		sb.append(day);

		sb.append("}");

		throw new NoSuchImgException(sb.toString());
	}

	/**
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByday_First(
		String day, OrderByComparator<Img> orderByComparator) {

		List<Img> list = findByday(day, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByday_Last(
			String day, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByday_Last(day, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("day=");
		sb.append(day);

		sb.append("}");

		throw new NoSuchImgException(sb.toString());
	}

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByday_Last(
		String day, OrderByComparator<Img> orderByComparator) {

		int count = countByday(day);

		if (count == 0) {
			return null;
		}

		List<Img> list = findByday(day, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img[] findByday_PrevAndNext(
			long id, String day, OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		day = Objects.toString(day, "");

		Img img = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Img[] array = new ImgImpl[3];

			array[0] = getByday_PrevAndNext(
				session, img, day, orderByComparator, true);

			array[1] = img;

			array[2] = getByday_PrevAndNext(
				session, img, day, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Img getByday_PrevAndNext(
		Session session, Img img, String day,
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

		boolean bindDay = false;

		if (day.isEmpty()) {
			sb.append(_FINDER_COLUMN_DAY_DAY_3);
		}
		else {
			bindDay = true;

			sb.append(_FINDER_COLUMN_DAY_DAY_2);
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
			sb.append(ImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDay) {
			queryPos.add(day);
		}

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
	 * Removes all the imgs where day = &#63; from the database.
	 *
	 * @param day the day
	 */
	@Override
	public void removeByday(String day) {
		for (Img img :
				findByday(day, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(img);
		}
	}

	/**
	 * Returns the number of imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the number of matching imgs
	 */
	@Override
	public int countByday(String day) {
		day = Objects.toString(day, "");

		FinderPath finderPath = _finderPathCountByday;

		Object[] finderArgs = new Object[] {day};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				sb.append(_FINDER_COLUMN_DAY_DAY_3);
			}
			else {
				bindDay = true;

				sb.append(_FINDER_COLUMN_DAY_DAY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDay) {
					queryPos.add(day);
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

	private static final String _FINDER_COLUMN_DAY_DAY_2 = "img.day = ?";

	private static final String _FINDER_COLUMN_DAY_DAY_3 =
		"(img.day IS NULL OR img.day = '')";

	private FinderPath _finderPathWithPaginationFindByDay_Province;
	private FinderPath _finderPathWithoutPaginationFindByDay_Province;
	private FinderPath _finderPathCountByDay_Province;

	/**
	 * Returns all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(String day, String provincia) {
		return findByDay_Province(
			day, provincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(
		String day, String provincia, int start, int end) {

		return findByDay_Province(day, provincia, start, end, null);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return findByDay_Province(
			day, provincia, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching imgs
	 */
	@Override
	public List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean useFinderCache) {

		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDay_Province;
				finderArgs = new Object[] {day, provincia};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDay_Province;
			finderArgs = new Object[] {
				day, provincia, start, end, orderByComparator
			};
		}

		List<Img> list = null;

		if (useFinderCache) {
			list = (List<Img>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Img img : list) {
					if (!day.equals(img.getDay()) ||
						!provincia.equals(img.getProvincia())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				sb.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				sb.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				sb.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				sb.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2);
			}

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

				if (bindDay) {
					queryPos.add(day);
				}

				if (bindProvincia) {
					queryPos.add(provincia);
				}

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
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByDay_Province_First(
			String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByDay_Province_First(day, provincia, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("day=");
		sb.append(day);

		sb.append(", provincia=");
		sb.append(provincia);

		sb.append("}");

		throw new NoSuchImgException(sb.toString());
	}

	/**
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByDay_Province_First(
		String day, String provincia,
		OrderByComparator<Img> orderByComparator) {

		List<Img> list = findByDay_Province(
			day, provincia, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByDay_Province_Last(
			String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		Img img = fetchByDay_Province_Last(day, provincia, orderByComparator);

		if (img != null) {
			return img;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("day=");
		sb.append(day);

		sb.append(", provincia=");
		sb.append(provincia);

		sb.append("}");

		throw new NoSuchImgException(sb.toString());
	}

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByDay_Province_Last(
		String day, String provincia,
		OrderByComparator<Img> orderByComparator) {

		int count = countByDay_Province(day, provincia);

		if (count == 0) {
			return null;
		}

		List<Img> list = findByDay_Province(
			day, provincia, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	@Override
	public Img[] findByDay_Province_PrevAndNext(
			long id, String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws NoSuchImgException {

		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		Img img = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Img[] array = new ImgImpl[3];

			array[0] = getByDay_Province_PrevAndNext(
				session, img, day, provincia, orderByComparator, true);

			array[1] = img;

			array[2] = getByDay_Province_PrevAndNext(
				session, img, day, provincia, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Img getByDay_Province_PrevAndNext(
		Session session, Img img, String day, String provincia,
		OrderByComparator<Img> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IMG_WHERE);

		boolean bindDay = false;

		if (day.isEmpty()) {
			sb.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_3);
		}
		else {
			bindDay = true;

			sb.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_2);
		}

		boolean bindProvincia = false;

		if (provincia.isEmpty()) {
			sb.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3);
		}
		else {
			bindProvincia = true;

			sb.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2);
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
			sb.append(ImgModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDay) {
			queryPos.add(day);
		}

		if (bindProvincia) {
			queryPos.add(provincia);
		}

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
	 * Removes all the imgs where day = &#63; and provincia = &#63; from the database.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 */
	@Override
	public void removeByDay_Province(String day, String provincia) {
		for (Img img :
				findByDay_Province(
					day, provincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(img);
		}
	}

	/**
	 * Returns the number of imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	@Override
	public int countByDay_Province(String day, String provincia) {
		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		FinderPath finderPath = _finderPathCountByDay_Province;

		Object[] finderArgs = new Object[] {day, provincia};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IMG_WHERE);

			boolean bindDay = false;

			if (day.isEmpty()) {
				sb.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				sb.append(_FINDER_COLUMN_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				sb.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				sb.append(_FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDay) {
					queryPos.add(day);
				}

				if (bindProvincia) {
					queryPos.add(provincia);
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

	private static final String _FINDER_COLUMN_DAY_PROVINCE_DAY_2 =
		"img.day = ? AND ";

	private static final String _FINDER_COLUMN_DAY_PROVINCE_DAY_3 =
		"(img.day IS NULL OR img.day = '') AND ";

	private static final String _FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_2 =
		"img.provincia = ?";

	private static final String _FINDER_COLUMN_DAY_PROVINCE_PROVINCIA_3 =
		"(img.provincia IS NULL OR img.provincia = '')";

	private FinderPath _finderPathFetchByPart_Day_Province;

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	@Override
	public Img findByPart_Day_Province(
			String daypart, String day, String provincia)
		throws NoSuchImgException {

		Img img = fetchByPart_Day_Province(daypart, day, provincia);

		if (img == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("daypart=");
			sb.append(daypart);

			sb.append(", day=");
			sb.append(day);

			sb.append(", provincia=");
			sb.append(provincia);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchImgException(sb.toString());
		}

		return img;
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByPart_Day_Province(
		String daypart, String day, String provincia) {

		return fetchByPart_Day_Province(daypart, day, provincia, true);
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	@Override
	public Img fetchByPart_Day_Province(
		String daypart, String day, String provincia, boolean useFinderCache) {

		daypart = Objects.toString(daypart, "");
		day = Objects.toString(day, "");
		provincia = Objects.toString(provincia, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {daypart, day, provincia};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPart_Day_Province, finderArgs, this);
		}

		if (result instanceof Img) {
			Img img = (Img)result;

			if (!Objects.equals(daypart, img.getDaypart()) ||
				!Objects.equals(day, img.getDay()) ||
				!Objects.equals(provincia, img.getProvincia())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_IMG_WHERE);

			boolean bindDaypart = false;

			if (daypart.isEmpty()) {
				sb.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_3);
			}
			else {
				bindDaypart = true;

				sb.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_2);
			}

			boolean bindDay = false;

			if (day.isEmpty()) {
				sb.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAY_3);
			}
			else {
				bindDay = true;

				sb.append(_FINDER_COLUMN_PART_DAY_PROVINCE_DAY_2);
			}

			boolean bindProvincia = false;

			if (provincia.isEmpty()) {
				sb.append(_FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_3);
			}
			else {
				bindProvincia = true;

				sb.append(_FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDaypart) {
					queryPos.add(daypart);
				}

				if (bindDay) {
					queryPos.add(day);
				}

				if (bindProvincia) {
					queryPos.add(provincia);
				}

				List<Img> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPart_Day_Province, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									daypart, day, provincia
								};
							}

							_log.warn(
								"ImgPersistenceImpl.fetchByPart_Day_Province(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Img img = list.get(0);

					result = img;

					cacheResult(img);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Img)result;
		}
	}

	/**
	 * Removes the img where daypart = &#63; and day = &#63; and provincia = &#63; from the database.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the img that was removed
	 */
	@Override
	public Img removeByPart_Day_Province(
			String daypart, String day, String provincia)
		throws NoSuchImgException {

		Img img = findByPart_Day_Province(daypart, day, provincia);

		return remove(img);
	}

	/**
	 * Returns the number of imgs where daypart = &#63; and day = &#63; and provincia = &#63;.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	@Override
	public int countByPart_Day_Province(
		String daypart, String day, String provincia) {

		Img img = fetchByPart_Day_Province(daypart, day, provincia);

		if (img == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_2 =
		"img.daypart = ? AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAYPART_3 =
		"(img.daypart IS NULL OR img.daypart = '') AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAY_2 =
		"img.day = ? AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_DAY_3 =
		"(img.day IS NULL OR img.day = '') AND ";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_2 =
		"img.provincia = ?";

	private static final String _FINDER_COLUMN_PART_DAY_PROVINCE_PROVINCIA_3 =
		"(img.provincia IS NULL OR img.provincia = '')";

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

		finderCache.putResult(
			_finderPathFetchByPart_Day_Province,
			new Object[] {img.getDaypart(), img.getDay(), img.getProvincia()},
			img);
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

	protected void cacheUniqueFindersCache(ImgModelImpl imgModelImpl) {
		Object[] args = new Object[] {
			imgModelImpl.getDaypart(), imgModelImpl.getDay(),
			imgModelImpl.getProvincia()
		};

		finderCache.putResult(
			_finderPathFetchByPart_Day_Province, args, imgModelImpl);
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

		cacheUniqueFindersCache(imgModelImpl);

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

		_finderPathWithPaginationFindByday = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByday",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"day"}, true);

		_finderPathWithoutPaginationFindByday = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByday",
			new String[] {String.class.getName()}, new String[] {"day"}, true);

		_finderPathCountByday = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByday",
			new String[] {String.class.getName()}, new String[] {"day"}, false);

		_finderPathWithPaginationFindByDay_Province = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDay_Province",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"day", "provincia"}, true);

		_finderPathWithoutPaginationFindByDay_Province = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDay_Province",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"day", "provincia"}, true);

		_finderPathCountByDay_Province = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDay_Province",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"day", "provincia"}, false);

		_finderPathFetchByPart_Day_Province = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPart_Day_Province",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"daypart", "day", "provincia"}, true);

		ImgUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ImgUtil.setPersistence(null);

		entityCache.removeCache(ImgImpl.class.getName());
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = prev_meteoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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