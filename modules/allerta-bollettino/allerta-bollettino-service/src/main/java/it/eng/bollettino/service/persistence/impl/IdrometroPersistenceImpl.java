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

import it.eng.bollettino.exception.NoSuchIdrometroException;
import it.eng.bollettino.model.Idrometro;
import it.eng.bollettino.model.IdrometroTable;
import it.eng.bollettino.model.impl.IdrometroImpl;
import it.eng.bollettino.model.impl.IdrometroModelImpl;
import it.eng.bollettino.service.persistence.IdrometroPersistence;
import it.eng.bollettino.service.persistence.IdrometroUtil;
import it.eng.bollettino.service.persistence.impl.constants.BOLLETTINOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the idrometro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = IdrometroPersistence.class)
public class IdrometroPersistenceImpl
	extends BasePersistenceImpl<Idrometro> implements IdrometroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IdrometroUtil</code> to access the idrometro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IdrometroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByNomeBacino;
	private FinderPath _finderPathWithoutPaginationFindByNomeBacino;
	private FinderPath _finderPathCountByNomeBacino;

	/**
	 * Returns all the idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(String nomeBacino) {
		return findByNomeBacino(
			nomeBacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end) {

		return findByNomeBacino(nomeBacino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return findByNomeBacino(
			nomeBacino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean useFinderCache) {

		nomeBacino = Objects.toString(nomeBacino, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNomeBacino;
				finderArgs = new Object[] {nomeBacino};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNomeBacino;
			finderArgs = new Object[] {
				nomeBacino, start, end, orderByComparator
			};
		}

		List<Idrometro> list = null;

		if (useFinderCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Idrometro idrometro : list) {
					if (!nomeBacino.equals(idrometro.getNomeBacino())) {
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

			sb.append(_SQL_SELECT_IDROMETRO_WHERE);

			boolean bindNomeBacino = false;

			if (nomeBacino.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3);
			}
			else {
				bindNomeBacino = true;

				sb.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IdrometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeBacino) {
					queryPos.add(nomeBacino);
				}

				list = (List<Idrometro>)QueryUtil.list(
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
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeBacino_First(
			String nomeBacino, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeBacino_First(
			nomeBacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeBacino=");
		sb.append(nomeBacino);

		sb.append("}");

		throw new NoSuchIdrometroException(sb.toString());
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeBacino_First(
		String nomeBacino, OrderByComparator<Idrometro> orderByComparator) {

		List<Idrometro> list = findByNomeBacino(
			nomeBacino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeBacino_Last(
			String nomeBacino, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeBacino_Last(
			nomeBacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeBacino=");
		sb.append(nomeBacino);

		sb.append("}");

		throw new NoSuchIdrometroException(sb.toString());
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeBacino_Last(
		String nomeBacino, OrderByComparator<Idrometro> orderByComparator) {

		int count = countByNomeBacino(nomeBacino);

		if (count == 0) {
			return null;
		}

		List<Idrometro> list = findByNomeBacino(
			nomeBacino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro[] findByNomeBacino_PrevAndNext(
			String stazioneId, String nomeBacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		nomeBacino = Objects.toString(nomeBacino, "");

		Idrometro idrometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Idrometro[] array = new IdrometroImpl[3];

			array[0] = getByNomeBacino_PrevAndNext(
				session, idrometro, nomeBacino, orderByComparator, true);

			array[1] = idrometro;

			array[2] = getByNomeBacino_PrevAndNext(
				session, idrometro, nomeBacino, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Idrometro getByNomeBacino_PrevAndNext(
		Session session, Idrometro idrometro, String nomeBacino,
		OrderByComparator<Idrometro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IDROMETRO_WHERE);

		boolean bindNomeBacino = false;

		if (nomeBacino.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3);
		}
		else {
			bindNomeBacino = true;

			sb.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2);
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
			sb.append(IdrometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNomeBacino) {
			queryPos.add(nomeBacino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(idrometro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Idrometro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the idrometros where nomeBacino = &#63; from the database.
	 *
	 * @param nomeBacino the nome bacino
	 */
	@Override
	public void removeByNomeBacino(String nomeBacino) {
		for (Idrometro idrometro :
				findByNomeBacino(
					nomeBacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the number of matching idrometros
	 */
	@Override
	public int countByNomeBacino(String nomeBacino) {
		nomeBacino = Objects.toString(nomeBacino, "");

		FinderPath finderPath = _finderPathCountByNomeBacino;

		Object[] finderArgs = new Object[] {nomeBacino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IDROMETRO_WHERE);

			boolean bindNomeBacino = false;

			if (nomeBacino.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3);
			}
			else {
				bindNomeBacino = true;

				sb.append(_FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeBacino) {
					queryPos.add(nomeBacino);
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

	private static final String _FINDER_COLUMN_NOMEBACINO_NOMEBACINO_2 =
		"idrometro.nomeBacino = ?";

	private static final String _FINDER_COLUMN_NOMEBACINO_NOMEBACINO_3 =
		"(idrometro.nomeBacino IS NULL OR idrometro.nomeBacino = '')";

	private FinderPath _finderPathWithPaginationFindByNomeSottobacino;
	private FinderPath _finderPathWithoutPaginationFindByNomeSottobacino;
	private FinderPath _finderPathCountByNomeSottobacino;

	/**
	 * Returns all the idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(String nomeSottobacino) {
		return findByNomeSottobacino(
			nomeSottobacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end) {

		return findByNomeSottobacino(nomeSottobacino, start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return findByNomeSottobacino(
			nomeSottobacino, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean useFinderCache) {

		nomeSottobacino = Objects.toString(nomeSottobacino, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNomeSottobacino;
				finderArgs = new Object[] {nomeSottobacino};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNomeSottobacino;
			finderArgs = new Object[] {
				nomeSottobacino, start, end, orderByComparator
			};
		}

		List<Idrometro> list = null;

		if (useFinderCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Idrometro idrometro : list) {
					if (!nomeSottobacino.equals(
							idrometro.getNomeSottobacino())) {

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

			sb.append(_SQL_SELECT_IDROMETRO_WHERE);

			boolean bindNomeSottobacino = false;

			if (nomeSottobacino.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3);
			}
			else {
				bindNomeSottobacino = true;

				sb.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IdrometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeSottobacino) {
					queryPos.add(nomeSottobacino);
				}

				list = (List<Idrometro>)QueryUtil.list(
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
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeSottobacino_First(
			String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeSottobacino_First(
			nomeSottobacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeSottobacino=");
		sb.append(nomeSottobacino);

		sb.append("}");

		throw new NoSuchIdrometroException(sb.toString());
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeSottobacino_First(
		String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator) {

		List<Idrometro> list = findByNomeSottobacino(
			nomeSottobacino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeSottobacino_Last(
			String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeSottobacino_Last(
			nomeSottobacino, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeSottobacino=");
		sb.append(nomeSottobacino);

		sb.append("}");

		throw new NoSuchIdrometroException(sb.toString());
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeSottobacino_Last(
		String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator) {

		int count = countByNomeSottobacino(nomeSottobacino);

		if (count == 0) {
			return null;
		}

		List<Idrometro> list = findByNomeSottobacino(
			nomeSottobacino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro[] findByNomeSottobacino_PrevAndNext(
			String stazioneId, String nomeSottobacino,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		nomeSottobacino = Objects.toString(nomeSottobacino, "");

		Idrometro idrometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Idrometro[] array = new IdrometroImpl[3];

			array[0] = getByNomeSottobacino_PrevAndNext(
				session, idrometro, nomeSottobacino, orderByComparator, true);

			array[1] = idrometro;

			array[2] = getByNomeSottobacino_PrevAndNext(
				session, idrometro, nomeSottobacino, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Idrometro getByNomeSottobacino_PrevAndNext(
		Session session, Idrometro idrometro, String nomeSottobacino,
		OrderByComparator<Idrometro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IDROMETRO_WHERE);

		boolean bindNomeSottobacino = false;

		if (nomeSottobacino.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3);
		}
		else {
			bindNomeSottobacino = true;

			sb.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2);
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
			sb.append(IdrometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNomeSottobacino) {
			queryPos.add(nomeSottobacino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(idrometro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Idrometro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the idrometros where nomeSottobacino = &#63; from the database.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 */
	@Override
	public void removeByNomeSottobacino(String nomeSottobacino) {
		for (Idrometro idrometro :
				findByNomeSottobacino(
					nomeSottobacino, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the number of matching idrometros
	 */
	@Override
	public int countByNomeSottobacino(String nomeSottobacino) {
		nomeSottobacino = Objects.toString(nomeSottobacino, "");

		FinderPath finderPath = _finderPathCountByNomeSottobacino;

		Object[] finderArgs = new Object[] {nomeSottobacino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IDROMETRO_WHERE);

			boolean bindNomeSottobacino = false;

			if (nomeSottobacino.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3);
			}
			else {
				bindNomeSottobacino = true;

				sb.append(_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeSottobacino) {
					queryPos.add(nomeSottobacino);
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

	private static final String
		_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_2 =
			"idrometro.nomeSottobacino = ?";

	private static final String
		_FINDER_COLUMN_NOMESOTTOBACINO_NOMESOTTOBACINO_3 =
			"(idrometro.nomeSottobacino IS NULL OR idrometro.nomeSottobacino = '')";

	private FinderPath _finderPathWithPaginationFindByNomeRubrica;
	private FinderPath _finderPathWithoutPaginationFindByNomeRubrica;
	private FinderPath _finderPathCountByNomeRubrica;

	/**
	 * Returns all the idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(String nomeRubrica) {
		return findByNomeRubrica(
			nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end) {

		return findByNomeRubrica(nomeRubrica, start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Idrometro> orderByComparator) {

		return findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching idrometros
	 */
	@Override
	public List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Idrometro> orderByComparator,
		boolean useFinderCache) {

		nomeRubrica = Objects.toString(nomeRubrica, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNomeRubrica;
				finderArgs = new Object[] {nomeRubrica};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNomeRubrica;
			finderArgs = new Object[] {
				nomeRubrica, start, end, orderByComparator
			};
		}

		List<Idrometro> list = null;

		if (useFinderCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Idrometro idrometro : list) {
					if (!nomeRubrica.equals(idrometro.getNomeRubrica())) {
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

			sb.append(_SQL_SELECT_IDROMETRO_WHERE);

			boolean bindNomeRubrica = false;

			if (nomeRubrica.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3);
			}
			else {
				bindNomeRubrica = true;

				sb.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IdrometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeRubrica) {
					queryPos.add(nomeRubrica);
				}

				list = (List<Idrometro>)QueryUtil.list(
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
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeRubrica_First(
			String nomeRubrica, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeRubrica_First(
			nomeRubrica, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeRubrica=");
		sb.append(nomeRubrica);

		sb.append("}");

		throw new NoSuchIdrometroException(sb.toString());
	}

	/**
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeRubrica_First(
		String nomeRubrica, OrderByComparator<Idrometro> orderByComparator) {

		List<Idrometro> list = findByNomeRubrica(
			nomeRubrica, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	@Override
	public Idrometro findByNomeRubrica_Last(
			String nomeRubrica, OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByNomeRubrica_Last(
			nomeRubrica, orderByComparator);

		if (idrometro != null) {
			return idrometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeRubrica=");
		sb.append(nomeRubrica);

		sb.append("}");

		throw new NoSuchIdrometroException(sb.toString());
	}

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	@Override
	public Idrometro fetchByNomeRubrica_Last(
		String nomeRubrica, OrderByComparator<Idrometro> orderByComparator) {

		int count = countByNomeRubrica(nomeRubrica);

		if (count == 0) {
			return null;
		}

		List<Idrometro> list = findByNomeRubrica(
			nomeRubrica, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			OrderByComparator<Idrometro> orderByComparator)
		throws NoSuchIdrometroException {

		nomeRubrica = Objects.toString(nomeRubrica, "");

		Idrometro idrometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Idrometro[] array = new IdrometroImpl[3];

			array[0] = getByNomeRubrica_PrevAndNext(
				session, idrometro, nomeRubrica, orderByComparator, true);

			array[1] = idrometro;

			array[2] = getByNomeRubrica_PrevAndNext(
				session, idrometro, nomeRubrica, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Idrometro getByNomeRubrica_PrevAndNext(
		Session session, Idrometro idrometro, String nomeRubrica,
		OrderByComparator<Idrometro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IDROMETRO_WHERE);

		boolean bindNomeRubrica = false;

		if (nomeRubrica.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3);
		}
		else {
			bindNomeRubrica = true;

			sb.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2);
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
			sb.append(IdrometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNomeRubrica) {
			queryPos.add(nomeRubrica);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(idrometro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Idrometro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the idrometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	@Override
	public void removeByNomeRubrica(String nomeRubrica) {
		for (Idrometro idrometro :
				findByNomeRubrica(
					nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching idrometros
	 */
	@Override
	public int countByNomeRubrica(String nomeRubrica) {
		nomeRubrica = Objects.toString(nomeRubrica, "");

		FinderPath finderPath = _finderPathCountByNomeRubrica;

		Object[] finderArgs = new Object[] {nomeRubrica};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IDROMETRO_WHERE);

			boolean bindNomeRubrica = false;

			if (nomeRubrica.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3);
			}
			else {
				bindNomeRubrica = true;

				sb.append(_FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeRubrica) {
					queryPos.add(nomeRubrica);
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

	private static final String _FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_2 =
		"idrometro.nomeRubrica = ?";

	private static final String _FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3 =
		"(idrometro.nomeRubrica IS NULL OR idrometro.nomeRubrica = '')";

	public IdrometroPersistenceImpl() {
		setModelClass(Idrometro.class);

		setModelImplClass(IdrometroImpl.class);
		setModelPKClass(String.class);

		setTable(IdrometroTable.INSTANCE);
	}

	/**
	 * Caches the idrometro in the entity cache if it is enabled.
	 *
	 * @param idrometro the idrometro
	 */
	@Override
	public void cacheResult(Idrometro idrometro) {
		entityCache.putResult(
			IdrometroImpl.class, idrometro.getPrimaryKey(), idrometro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the idrometros in the entity cache if it is enabled.
	 *
	 * @param idrometros the idrometros
	 */
	@Override
	public void cacheResult(List<Idrometro> idrometros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (idrometros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Idrometro idrometro : idrometros) {
			if (entityCache.getResult(
					IdrometroImpl.class, idrometro.getPrimaryKey()) == null) {

				cacheResult(idrometro);
			}
		}
	}

	/**
	 * Clears the cache for all idrometros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IdrometroImpl.class);

		finderCache.clearCache(IdrometroImpl.class);
	}

	/**
	 * Clears the cache for the idrometro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Idrometro idrometro) {
		entityCache.removeResult(IdrometroImpl.class, idrometro);
	}

	@Override
	public void clearCache(List<Idrometro> idrometros) {
		for (Idrometro idrometro : idrometros) {
			entityCache.removeResult(IdrometroImpl.class, idrometro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(IdrometroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IdrometroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new idrometro with the primary key. Does not add the idrometro to the database.
	 *
	 * @param stazioneId the primary key for the new idrometro
	 * @return the new idrometro
	 */
	@Override
	public Idrometro create(String stazioneId) {
		Idrometro idrometro = new IdrometroImpl();

		idrometro.setNew(true);
		idrometro.setPrimaryKey(stazioneId);

		return idrometro;
	}

	/**
	 * Removes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro remove(String stazioneId) throws NoSuchIdrometroException {
		return remove((Serializable)stazioneId);
	}

	/**
	 * Removes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro remove(Serializable primaryKey)
		throws NoSuchIdrometroException {

		Session session = null;

		try {
			session = openSession();

			Idrometro idrometro = (Idrometro)session.get(
				IdrometroImpl.class, primaryKey);

			if (idrometro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIdrometroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(idrometro);
		}
		catch (NoSuchIdrometroException noSuchEntityException) {
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
	protected Idrometro removeImpl(Idrometro idrometro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(idrometro)) {
				idrometro = (Idrometro)session.get(
					IdrometroImpl.class, idrometro.getPrimaryKeyObj());
			}

			if (idrometro != null) {
				session.delete(idrometro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (idrometro != null) {
			clearCache(idrometro);
		}

		return idrometro;
	}

	@Override
	public Idrometro updateImpl(Idrometro idrometro) {
		boolean isNew = idrometro.isNew();

		if (!(idrometro instanceof IdrometroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(idrometro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(idrometro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in idrometro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Idrometro implementation " +
					idrometro.getClass());
		}

		IdrometroModelImpl idrometroModelImpl = (IdrometroModelImpl)idrometro;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(idrometro);
			}
			else {
				idrometro = (Idrometro)session.merge(idrometro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IdrometroImpl.class, idrometroModelImpl, false, true);

		if (isNew) {
			idrometro.setNew(false);
		}

		idrometro.resetOriginalValues();

		return idrometro;
	}

	/**
	 * Returns the idrometro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the idrometro
	 * @return the idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIdrometroException {

		Idrometro idrometro = fetchByPrimaryKey(primaryKey);

		if (idrometro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIdrometroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return idrometro;
	}

	/**
	 * Returns the idrometro with the primary key or throws a <code>NoSuchIdrometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro findByPrimaryKey(String stazioneId)
		throws NoSuchIdrometroException {

		return findByPrimaryKey((Serializable)stazioneId);
	}

	/**
	 * Returns the idrometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro, or <code>null</code> if a idrometro with the primary key could not be found
	 */
	@Override
	public Idrometro fetchByPrimaryKey(String stazioneId) {
		return fetchByPrimaryKey((Serializable)stazioneId);
	}

	/**
	 * Returns all the idrometros.
	 *
	 * @return the idrometros
	 */
	@Override
	public List<Idrometro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of idrometros
	 */
	@Override
	public List<Idrometro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idrometros
	 */
	@Override
	public List<Idrometro> findAll(
		int start, int end, OrderByComparator<Idrometro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of idrometros
	 */
	@Override
	public List<Idrometro> findAll(
		int start, int end, OrderByComparator<Idrometro> orderByComparator,
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

		List<Idrometro> list = null;

		if (useFinderCache) {
			list = (List<Idrometro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IDROMETRO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IDROMETRO;

				sql = sql.concat(IdrometroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Idrometro>)QueryUtil.list(
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
	 * Removes all the idrometros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Idrometro idrometro : findAll()) {
			remove(idrometro);
		}
	}

	/**
	 * Returns the number of idrometros.
	 *
	 * @return the number of idrometros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IDROMETRO);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "stazioneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IDROMETRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IdrometroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the idrometro persistence.
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

		_finderPathWithPaginationFindByNomeBacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeBacino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nomeBacino"}, true);

		_finderPathWithoutPaginationFindByNomeBacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeBacino",
			new String[] {String.class.getName()}, new String[] {"nomeBacino"},
			true);

		_finderPathCountByNomeBacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeBacino",
			new String[] {String.class.getName()}, new String[] {"nomeBacino"},
			false);

		_finderPathWithPaginationFindByNomeSottobacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeSottobacino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nomeSottobacino"}, true);

		_finderPathWithoutPaginationFindByNomeSottobacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeSottobacino",
			new String[] {String.class.getName()},
			new String[] {"nomeSottobacino"}, true);

		_finderPathCountByNomeSottobacino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeSottobacino",
			new String[] {String.class.getName()},
			new String[] {"nomeSottobacino"}, false);

		_finderPathWithPaginationFindByNomeRubrica = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeRubrica",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nomeRubrica"}, true);

		_finderPathWithoutPaginationFindByNomeRubrica = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeRubrica",
			new String[] {String.class.getName()}, new String[] {"nomeRubrica"},
			true);

		_finderPathCountByNomeRubrica = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeRubrica",
			new String[] {String.class.getName()}, new String[] {"nomeRubrica"},
			false);

		IdrometroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		IdrometroUtil.setPersistence(null);

		entityCache.removeCache(IdrometroImpl.class.getName());
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

	private static final String _SQL_SELECT_IDROMETRO =
		"SELECT idrometro FROM Idrometro idrometro";

	private static final String _SQL_SELECT_IDROMETRO_WHERE =
		"SELECT idrometro FROM Idrometro idrometro WHERE ";

	private static final String _SQL_COUNT_IDROMETRO =
		"SELECT COUNT(idrometro) FROM Idrometro idrometro";

	private static final String _SQL_COUNT_IDROMETRO_WHERE =
		"SELECT COUNT(idrometro) FROM Idrometro idrometro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "idrometro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Idrometro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Idrometro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IdrometroPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}