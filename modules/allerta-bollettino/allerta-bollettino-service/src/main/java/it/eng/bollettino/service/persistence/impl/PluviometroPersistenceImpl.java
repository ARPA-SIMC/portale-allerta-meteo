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

import it.eng.bollettino.exception.NoSuchPluviometroException;
import it.eng.bollettino.model.Pluviometro;
import it.eng.bollettino.model.PluviometroTable;
import it.eng.bollettino.model.impl.PluviometroImpl;
import it.eng.bollettino.model.impl.PluviometroModelImpl;
import it.eng.bollettino.service.persistence.PluviometroPersistence;
import it.eng.bollettino.service.persistence.PluviometroUtil;
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
 * The persistence implementation for the pluviometro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @generated
 */
@Component(service = PluviometroPersistence.class)
public class PluviometroPersistenceImpl
	extends BasePersistenceImpl<Pluviometro> implements PluviometroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PluviometroUtil</code> to access the pluviometro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PluviometroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByNomeGruppo;
	private FinderPath _finderPathWithoutPaginationFindByNomeGruppo;
	private FinderPath _finderPathCountByNomeGruppo;

	/**
	 * Returns all the pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(String nomeGruppo) {
		return findByNomeGruppo(
			nomeGruppo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end) {

		return findByNomeGruppo(nomeGruppo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return findByNomeGruppo(
			nomeGruppo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator,
		boolean useFinderCache) {

		nomeGruppo = Objects.toString(nomeGruppo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNomeGruppo;
				finderArgs = new Object[] {nomeGruppo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNomeGruppo;
			finderArgs = new Object[] {
				nomeGruppo, start, end, orderByComparator
			};
		}

		List<Pluviometro> list = null;

		if (useFinderCache) {
			list = (List<Pluviometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Pluviometro pluviometro : list) {
					if (!nomeGruppo.equals(pluviometro.getNomeGruppo())) {
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

			sb.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

			boolean bindNomeGruppo = false;

			if (nomeGruppo.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3);
			}
			else {
				bindNomeGruppo = true;

				sb.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PluviometroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeGruppo) {
					queryPos.add(nomeGruppo);
				}

				list = (List<Pluviometro>)QueryUtil.list(
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
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeGruppo_First(
			String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeGruppo_First(
			nomeGruppo, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeGruppo=");
		sb.append(nomeGruppo);

		sb.append("}");

		throw new NoSuchPluviometroException(sb.toString());
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeGruppo_First(
		String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator) {

		List<Pluviometro> list = findByNomeGruppo(
			nomeGruppo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeGruppo_Last(
			String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeGruppo_Last(
			nomeGruppo, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeGruppo=");
		sb.append(nomeGruppo);

		sb.append("}");

		throw new NoSuchPluviometroException(sb.toString());
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeGruppo_Last(
		String nomeGruppo, OrderByComparator<Pluviometro> orderByComparator) {

		int count = countByNomeGruppo(nomeGruppo);

		if (count == 0) {
			return null;
		}

		List<Pluviometro> list = findByNomeGruppo(
			nomeGruppo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro[] findByNomeGruppo_PrevAndNext(
			String stazioneId, String nomeGruppo,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		nomeGruppo = Objects.toString(nomeGruppo, "");

		Pluviometro pluviometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Pluviometro[] array = new PluviometroImpl[3];

			array[0] = getByNomeGruppo_PrevAndNext(
				session, pluviometro, nomeGruppo, orderByComparator, true);

			array[1] = pluviometro;

			array[2] = getByNomeGruppo_PrevAndNext(
				session, pluviometro, nomeGruppo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pluviometro getByNomeGruppo_PrevAndNext(
		Session session, Pluviometro pluviometro, String nomeGruppo,
		OrderByComparator<Pluviometro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

		boolean bindNomeGruppo = false;

		if (nomeGruppo.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3);
		}
		else {
			bindNomeGruppo = true;

			sb.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2);
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
			sb.append(PluviometroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNomeGruppo) {
			queryPos.add(nomeGruppo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pluviometro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pluviometro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pluviometros where nomeGruppo = &#63; from the database.
	 *
	 * @param nomeGruppo the nome gruppo
	 */
	@Override
	public void removeByNomeGruppo(String nomeGruppo) {
		for (Pluviometro pluviometro :
				findByNomeGruppo(
					nomeGruppo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pluviometro);
		}
	}

	/**
	 * Returns the number of pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the number of matching pluviometros
	 */
	@Override
	public int countByNomeGruppo(String nomeGruppo) {
		nomeGruppo = Objects.toString(nomeGruppo, "");

		FinderPath finderPath = _finderPathCountByNomeGruppo;

		Object[] finderArgs = new Object[] {nomeGruppo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLUVIOMETRO_WHERE);

			boolean bindNomeGruppo = false;

			if (nomeGruppo.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3);
			}
			else {
				bindNomeGruppo = true;

				sb.append(_FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNomeGruppo) {
					queryPos.add(nomeGruppo);
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

	private static final String _FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_2 =
		"pluviometro.nomeGruppo = ?";

	private static final String _FINDER_COLUMN_NOMEGRUPPO_NOMEGRUPPO_3 =
		"(pluviometro.nomeGruppo IS NULL OR pluviometro.nomeGruppo = '')";

	private FinderPath _finderPathWithPaginationFindByNomeRubrica;
	private FinderPath _finderPathWithoutPaginationFindByNomeRubrica;
	private FinderPath _finderPathCountByNomeRubrica;

	/**
	 * Returns all the pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(String nomeRubrica) {
		return findByNomeRubrica(
			nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end) {

		return findByNomeRubrica(nomeRubrica, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator) {

		return findByNomeRubrica(
			nomeRubrica, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	@Override
	public List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		OrderByComparator<Pluviometro> orderByComparator,
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

		List<Pluviometro> list = null;

		if (useFinderCache) {
			list = (List<Pluviometro>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Pluviometro pluviometro : list) {
					if (!nomeRubrica.equals(pluviometro.getNomeRubrica())) {
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

			sb.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

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
				sb.append(PluviometroModelImpl.ORDER_BY_JPQL);
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

				list = (List<Pluviometro>)QueryUtil.list(
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
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeRubrica_First(
			String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeRubrica_First(
			nomeRubrica, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeRubrica=");
		sb.append(nomeRubrica);

		sb.append("}");

		throw new NoSuchPluviometroException(sb.toString());
	}

	/**
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeRubrica_First(
		String nomeRubrica, OrderByComparator<Pluviometro> orderByComparator) {

		List<Pluviometro> list = findByNomeRubrica(
			nomeRubrica, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro findByNomeRubrica_Last(
			String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByNomeRubrica_Last(
			nomeRubrica, orderByComparator);

		if (pluviometro != null) {
			return pluviometro;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nomeRubrica=");
		sb.append(nomeRubrica);

		sb.append("}");

		throw new NoSuchPluviometroException(sb.toString());
	}

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	@Override
	public Pluviometro fetchByNomeRubrica_Last(
		String nomeRubrica, OrderByComparator<Pluviometro> orderByComparator) {

		int count = countByNomeRubrica(nomeRubrica);

		if (count == 0) {
			return null;
		}

		List<Pluviometro> list = findByNomeRubrica(
			nomeRubrica, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			OrderByComparator<Pluviometro> orderByComparator)
		throws NoSuchPluviometroException {

		nomeRubrica = Objects.toString(nomeRubrica, "");

		Pluviometro pluviometro = findByPrimaryKey(stazioneId);

		Session session = null;

		try {
			session = openSession();

			Pluviometro[] array = new PluviometroImpl[3];

			array[0] = getByNomeRubrica_PrevAndNext(
				session, pluviometro, nomeRubrica, orderByComparator, true);

			array[1] = pluviometro;

			array[2] = getByNomeRubrica_PrevAndNext(
				session, pluviometro, nomeRubrica, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pluviometro getByNomeRubrica_PrevAndNext(
		Session session, Pluviometro pluviometro, String nomeRubrica,
		OrderByComparator<Pluviometro> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLUVIOMETRO_WHERE);

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
			sb.append(PluviometroModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pluviometro)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pluviometro> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pluviometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	@Override
	public void removeByNomeRubrica(String nomeRubrica) {
		for (Pluviometro pluviometro :
				findByNomeRubrica(
					nomeRubrica, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pluviometro);
		}
	}

	/**
	 * Returns the number of pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching pluviometros
	 */
	@Override
	public int countByNomeRubrica(String nomeRubrica) {
		nomeRubrica = Objects.toString(nomeRubrica, "");

		FinderPath finderPath = _finderPathCountByNomeRubrica;

		Object[] finderArgs = new Object[] {nomeRubrica};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLUVIOMETRO_WHERE);

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
		"pluviometro.nomeRubrica = ?";

	private static final String _FINDER_COLUMN_NOMERUBRICA_NOMERUBRICA_3 =
		"(pluviometro.nomeRubrica IS NULL OR pluviometro.nomeRubrica = '')";

	public PluviometroPersistenceImpl() {
		setModelClass(Pluviometro.class);

		setModelImplClass(PluviometroImpl.class);
		setModelPKClass(String.class);

		setTable(PluviometroTable.INSTANCE);
	}

	/**
	 * Caches the pluviometro in the entity cache if it is enabled.
	 *
	 * @param pluviometro the pluviometro
	 */
	@Override
	public void cacheResult(Pluviometro pluviometro) {
		entityCache.putResult(
			PluviometroImpl.class, pluviometro.getPrimaryKey(), pluviometro);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pluviometros in the entity cache if it is enabled.
	 *
	 * @param pluviometros the pluviometros
	 */
	@Override
	public void cacheResult(List<Pluviometro> pluviometros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pluviometros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Pluviometro pluviometro : pluviometros) {
			if (entityCache.getResult(
					PluviometroImpl.class, pluviometro.getPrimaryKey()) ==
						null) {

				cacheResult(pluviometro);
			}
		}
	}

	/**
	 * Clears the cache for all pluviometros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PluviometroImpl.class);

		finderCache.clearCache(PluviometroImpl.class);
	}

	/**
	 * Clears the cache for the pluviometro.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pluviometro pluviometro) {
		entityCache.removeResult(PluviometroImpl.class, pluviometro);
	}

	@Override
	public void clearCache(List<Pluviometro> pluviometros) {
		for (Pluviometro pluviometro : pluviometros) {
			entityCache.removeResult(PluviometroImpl.class, pluviometro);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PluviometroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PluviometroImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pluviometro with the primary key. Does not add the pluviometro to the database.
	 *
	 * @param stazioneId the primary key for the new pluviometro
	 * @return the new pluviometro
	 */
	@Override
	public Pluviometro create(String stazioneId) {
		Pluviometro pluviometro = new PluviometroImpl();

		pluviometro.setNew(true);
		pluviometro.setPrimaryKey(stazioneId);

		return pluviometro;
	}

	/**
	 * Removes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro remove(String stazioneId)
		throws NoSuchPluviometroException {

		return remove((Serializable)stazioneId);
	}

	/**
	 * Removes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro remove(Serializable primaryKey)
		throws NoSuchPluviometroException {

		Session session = null;

		try {
			session = openSession();

			Pluviometro pluviometro = (Pluviometro)session.get(
				PluviometroImpl.class, primaryKey);

			if (pluviometro == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPluviometroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pluviometro);
		}
		catch (NoSuchPluviometroException noSuchEntityException) {
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
	protected Pluviometro removeImpl(Pluviometro pluviometro) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pluviometro)) {
				pluviometro = (Pluviometro)session.get(
					PluviometroImpl.class, pluviometro.getPrimaryKeyObj());
			}

			if (pluviometro != null) {
				session.delete(pluviometro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pluviometro != null) {
			clearCache(pluviometro);
		}

		return pluviometro;
	}

	@Override
	public Pluviometro updateImpl(Pluviometro pluviometro) {
		boolean isNew = pluviometro.isNew();

		if (!(pluviometro instanceof PluviometroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pluviometro.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pluviometro);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pluviometro proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Pluviometro implementation " +
					pluviometro.getClass());
		}

		PluviometroModelImpl pluviometroModelImpl =
			(PluviometroModelImpl)pluviometro;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pluviometro);
			}
			else {
				pluviometro = (Pluviometro)session.merge(pluviometro);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PluviometroImpl.class, pluviometroModelImpl, false, true);

		if (isNew) {
			pluviometro.setNew(false);
		}

		pluviometro.resetOriginalValues();

		return pluviometro;
	}

	/**
	 * Returns the pluviometro with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPluviometroException {

		Pluviometro pluviometro = fetchByPrimaryKey(primaryKey);

		if (pluviometro == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPluviometroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pluviometro;
	}

	/**
	 * Returns the pluviometro with the primary key or throws a <code>NoSuchPluviometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro findByPrimaryKey(String stazioneId)
		throws NoSuchPluviometroException {

		return findByPrimaryKey((Serializable)stazioneId);
	}

	/**
	 * Returns the pluviometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro, or <code>null</code> if a pluviometro with the primary key could not be found
	 */
	@Override
	public Pluviometro fetchByPrimaryKey(String stazioneId) {
		return fetchByPrimaryKey((Serializable)stazioneId);
	}

	/**
	 * Returns all the pluviometros.
	 *
	 * @return the pluviometros
	 */
	@Override
	public List<Pluviometro> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of pluviometros
	 */
	@Override
	public List<Pluviometro> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pluviometros
	 */
	@Override
	public List<Pluviometro> findAll(
		int start, int end, OrderByComparator<Pluviometro> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pluviometros
	 */
	@Override
	public List<Pluviometro> findAll(
		int start, int end, OrderByComparator<Pluviometro> orderByComparator,
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

		List<Pluviometro> list = null;

		if (useFinderCache) {
			list = (List<Pluviometro>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PLUVIOMETRO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PLUVIOMETRO;

				sql = sql.concat(PluviometroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Pluviometro>)QueryUtil.list(
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
	 * Removes all the pluviometros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Pluviometro pluviometro : findAll()) {
			remove(pluviometro);
		}
	}

	/**
	 * Returns the number of pluviometros.
	 *
	 * @return the number of pluviometros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PLUVIOMETRO);

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
		return _SQL_SELECT_PLUVIOMETRO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PluviometroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pluviometro persistence.
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

		_finderPathWithPaginationFindByNomeGruppo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNomeGruppo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nomeGruppo"}, true);

		_finderPathWithoutPaginationFindByNomeGruppo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNomeGruppo",
			new String[] {String.class.getName()}, new String[] {"nomeGruppo"},
			true);

		_finderPathCountByNomeGruppo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNomeGruppo",
			new String[] {String.class.getName()}, new String[] {"nomeGruppo"},
			false);

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

		PluviometroUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PluviometroUtil.setPersistence(null);

		entityCache.removeCache(PluviometroImpl.class.getName());
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

	private static final String _SQL_SELECT_PLUVIOMETRO =
		"SELECT pluviometro FROM Pluviometro pluviometro";

	private static final String _SQL_SELECT_PLUVIOMETRO_WHERE =
		"SELECT pluviometro FROM Pluviometro pluviometro WHERE ";

	private static final String _SQL_COUNT_PLUVIOMETRO =
		"SELECT COUNT(pluviometro) FROM Pluviometro pluviometro";

	private static final String _SQL_COUNT_PLUVIOMETRO_WHERE =
		"SELECT COUNT(pluviometro) FROM Pluviometro pluviometro WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pluviometro.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Pluviometro exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Pluviometro exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PluviometroPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}