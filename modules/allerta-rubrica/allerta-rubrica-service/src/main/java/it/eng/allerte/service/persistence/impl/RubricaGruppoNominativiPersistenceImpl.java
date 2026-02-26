/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

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

import it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.RubricaGruppoNominativiTable;
import it.eng.allerte.model.impl.RubricaGruppoNominativiImpl;
import it.eng.allerte.model.impl.RubricaGruppoNominativiModelImpl;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPersistence;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

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
 * The persistence implementation for the rubrica gruppo nominativi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaGruppoNominativiPersistence.class)
public class RubricaGruppoNominativiPersistenceImpl
	extends BasePersistenceImpl<RubricaGruppoNominativi>
	implements RubricaGruppoNominativiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaGruppoNominativiUtil</code> to access the rubrica gruppo nominativi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaGruppoNominativiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByRubricaGruppoRuoloByNominativo;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo;
	private FinderPath _finderPathCountByRubricaGruppoRuoloByNominativo;

	/**
	 * Returns all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO) {

		return findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO, int start, int end) {

		return findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return findByRubricaGruppoRuoloByNominativo(
			FK_NOMINATIVO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo;
				finderArgs = new Object[] {FK_NOMINATIVO};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRubricaGruppoRuoloByNominativo;
			finderArgs = new Object[] {
				FK_NOMINATIVO, start, end, orderByComparator
			};
		}

		List<RubricaGruppoNominativi> list = null;

		if (useFinderCache) {
			list = (List<RubricaGruppoNominativi>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaGruppoNominativi rubricaGruppoNominativi : list) {
					if (FK_NOMINATIVO !=
							rubricaGruppoNominativi.getFK_NOMINATIVO()) {

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

			sb.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_NOMINATIVO);

				list = (List<RubricaGruppoNominativi>)QueryUtil.list(
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
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByNominativo_First(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByNominativo_First(
				FK_NOMINATIVO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_NOMINATIVO=");
		sb.append(FK_NOMINATIVO);

		sb.append("}");

		throw new NoSuchRubricaGruppoNominativiException(sb.toString());
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByNominativo_First(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		List<RubricaGruppoNominativi> list =
			findByRubricaGruppoRuoloByNominativo(
				FK_NOMINATIVO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByNominativo_Last(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByNominativo_Last(
				FK_NOMINATIVO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_NOMINATIVO=");
		sb.append(FK_NOMINATIVO);

		sb.append("}");

		throw new NoSuchRubricaGruppoNominativiException(sb.toString());
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByNominativo_Last(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		int count = countByRubricaGruppoRuoloByNominativo(FK_NOMINATIVO);

		if (count == 0) {
			return null;
		}

		List<RubricaGruppoNominativi> list =
			findByRubricaGruppoRuoloByNominativo(
				FK_NOMINATIVO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByNominativo_PrevAndNext(
				RubricaGruppoNominativiPK rubricaGruppoNominativiPK,
				long FK_NOMINATIVO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi = findByPrimaryKey(
			rubricaGruppoNominativiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoNominativi[] array =
				new RubricaGruppoNominativiImpl[3];

			array[0] = getByRubricaGruppoRuoloByNominativo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_NOMINATIVO,
				orderByComparator, true);

			array[1] = rubricaGruppoNominativi;

			array[2] = getByRubricaGruppoRuoloByNominativo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_NOMINATIVO,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaGruppoNominativi
		getByRubricaGruppoRuoloByNominativo_PrevAndNext(
			Session session, RubricaGruppoNominativi rubricaGruppoNominativi,
			long FK_NOMINATIVO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

		sb.append(
			_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2);

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
			sb.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_NOMINATIVO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaGruppoNominativi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaGruppoNominativi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	@Override
	public void removeByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO) {
		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				findByRubricaGruppoRuoloByNominativo(
					FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaGruppoNominativi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	@Override
	public int countByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO) {
		FinderPath finderPath =
			_finderPathCountByRubricaGruppoRuoloByNominativo;

		Object[] finderArgs = new Object[] {FK_NOMINATIVO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICAGRUPPONOMINATIVI_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_NOMINATIVO);

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

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYNOMINATIVO_FK_NOMINATIVO_2 =
			"rubricaGruppoNominativi.id.FK_NOMINATIVO = ?";

	private FinderPath
		_finderPathWithPaginationFindByRubricaGruppoRuoloByGruppo;
	private FinderPath
		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo;
	private FinderPath _finderPathCountByRubricaGruppoRuoloByGruppo;

	/**
	 * Returns all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO) {

		return findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO, int start, int end) {

		return findByRubricaGruppoRuoloByGruppo(FK_GRUPPO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByGruppo(
		long FK_GRUPPO, int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo;
				finderArgs = new Object[] {FK_GRUPPO};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRubricaGruppoRuoloByGruppo;
			finderArgs = new Object[] {
				FK_GRUPPO, start, end, orderByComparator
			};
		}

		List<RubricaGruppoNominativi> list = null;

		if (useFinderCache) {
			list = (List<RubricaGruppoNominativi>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaGruppoNominativi rubricaGruppoNominativi : list) {
					if (FK_GRUPPO != rubricaGruppoNominativi.getFK_GRUPPO()) {
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

			sb.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

			sb.append(_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_GRUPPO);

				list = (List<RubricaGruppoNominativi>)QueryUtil.list(
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
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_First(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByGruppo_First(
				FK_GRUPPO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_GRUPPO=");
		sb.append(FK_GRUPPO);

		sb.append("}");

		throw new NoSuchRubricaGruppoNominativiException(sb.toString());
	}

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByGruppo_First(
		long FK_GRUPPO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		List<RubricaGruppoNominativi> list = findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_Last(
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			fetchByRubricaGruppoRuoloByGruppo_Last(
				FK_GRUPPO, orderByComparator);

		if (rubricaGruppoNominativi != null) {
			return rubricaGruppoNominativi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_GRUPPO=");
		sb.append(FK_GRUPPO);

		sb.append("}");

		throw new NoSuchRubricaGruppoNominativiException(sb.toString());
	}

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByGruppo_Last(
		long FK_GRUPPO,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		int count = countByRubricaGruppoRuoloByGruppo(FK_GRUPPO);

		if (count == 0) {
			return null;
		}

		List<RubricaGruppoNominativi> list = findByRubricaGruppoRuoloByGruppo(
			FK_GRUPPO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByGruppo_PrevAndNext(
				RubricaGruppoNominativiPK rubricaGruppoNominativiPK,
				long FK_GRUPPO,
				OrderByComparator<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi = findByPrimaryKey(
			rubricaGruppoNominativiPK);

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoNominativi[] array =
				new RubricaGruppoNominativiImpl[3];

			array[0] = getByRubricaGruppoRuoloByGruppo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_GRUPPO, orderByComparator,
				true);

			array[1] = rubricaGruppoNominativi;

			array[2] = getByRubricaGruppoRuoloByGruppo_PrevAndNext(
				session, rubricaGruppoNominativi, FK_GRUPPO, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaGruppoNominativi
		getByRubricaGruppoRuoloByGruppo_PrevAndNext(
			Session session, RubricaGruppoNominativi rubricaGruppoNominativi,
			long FK_GRUPPO,
			OrderByComparator<RubricaGruppoNominativi> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE);

		sb.append(_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2);

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
			sb.append(RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_GRUPPO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaGruppoNominativi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaGruppoNominativi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica gruppo nominativis where FK_GRUPPO = &#63; from the database.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 */
	@Override
	public void removeByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {
		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				findByRubricaGruppoRuoloByGruppo(
					FK_GRUPPO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rubricaGruppoNominativi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	@Override
	public int countByRubricaGruppoRuoloByGruppo(long FK_GRUPPO) {
		FinderPath finderPath = _finderPathCountByRubricaGruppoRuoloByGruppo;

		Object[] finderArgs = new Object[] {FK_GRUPPO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICAGRUPPONOMINATIVI_WHERE);

			sb.append(_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_GRUPPO);

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

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPORUOLOBYGRUPPO_FK_GRUPPO_2 =
			"rubricaGruppoNominativi.id.FK_GRUPPO = ?";

	public RubricaGruppoNominativiPersistenceImpl() {
		setModelClass(RubricaGruppoNominativi.class);

		setModelImplClass(RubricaGruppoNominativiImpl.class);
		setModelPKClass(RubricaGruppoNominativiPK.class);

		setTable(RubricaGruppoNominativiTable.INSTANCE);
	}

	/**
	 * Caches the rubrica gruppo nominativi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 */
	@Override
	public void cacheResult(RubricaGruppoNominativi rubricaGruppoNominativi) {
		dummyEntityCache.putResult(
			RubricaGruppoNominativiImpl.class,
			rubricaGruppoNominativi.getPrimaryKey(), rubricaGruppoNominativi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica gruppo nominativis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativis the rubrica gruppo nominativis
	 */
	@Override
	public void cacheResult(
		List<RubricaGruppoNominativi> rubricaGruppoNominativis) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaGruppoNominativis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				rubricaGruppoNominativis) {

			if (dummyEntityCache.getResult(
					RubricaGruppoNominativiImpl.class,
					rubricaGruppoNominativi.getPrimaryKey()) == null) {

				cacheResult(rubricaGruppoNominativi);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica gruppo nominativis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaGruppoNominativiImpl.class);

		dummyFinderCache.clearCache(RubricaGruppoNominativiImpl.class);
	}

	/**
	 * Clears the cache for the rubrica gruppo nominativi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaGruppoNominativi rubricaGruppoNominativi) {
		dummyEntityCache.removeResult(
			RubricaGruppoNominativiImpl.class, rubricaGruppoNominativi);
	}

	@Override
	public void clearCache(
		List<RubricaGruppoNominativi> rubricaGruppoNominativis) {

		for (RubricaGruppoNominativi rubricaGruppoNominativi :
				rubricaGruppoNominativis) {

			dummyEntityCache.removeResult(
				RubricaGruppoNominativiImpl.class, rubricaGruppoNominativi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaGruppoNominativiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaGruppoNominativiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	@Override
	public RubricaGruppoNominativi create(
		RubricaGruppoNominativiPK rubricaGruppoNominativiPK) {

		RubricaGruppoNominativi rubricaGruppoNominativi =
			new RubricaGruppoNominativiImpl();

		rubricaGruppoNominativi.setNew(true);
		rubricaGruppoNominativi.setPrimaryKey(rubricaGruppoNominativiPK);

		return rubricaGruppoNominativi;
	}

	/**
	 * Removes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi remove(
			RubricaGruppoNominativiPK rubricaGruppoNominativiPK)
		throws NoSuchRubricaGruppoNominativiException {

		return remove((Serializable)rubricaGruppoNominativiPK);
	}

	/**
	 * Removes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi remove(Serializable primaryKey)
		throws NoSuchRubricaGruppoNominativiException {

		Session session = null;

		try {
			session = openSession();

			RubricaGruppoNominativi rubricaGruppoNominativi =
				(RubricaGruppoNominativi)session.get(
					RubricaGruppoNominativiImpl.class, primaryKey);

			if (rubricaGruppoNominativi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaGruppoNominativiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaGruppoNominativi);
		}
		catch (NoSuchRubricaGruppoNominativiException noSuchEntityException) {
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
	protected RubricaGruppoNominativi removeImpl(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaGruppoNominativi)) {
				rubricaGruppoNominativi = (RubricaGruppoNominativi)session.get(
					RubricaGruppoNominativiImpl.class,
					rubricaGruppoNominativi.getPrimaryKeyObj());
			}

			if (rubricaGruppoNominativi != null) {
				session.delete(rubricaGruppoNominativi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaGruppoNominativi != null) {
			clearCache(rubricaGruppoNominativi);
		}

		return rubricaGruppoNominativi;
	}

	@Override
	public RubricaGruppoNominativi updateImpl(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		boolean isNew = rubricaGruppoNominativi.isNew();

		if (!(rubricaGruppoNominativi instanceof
				RubricaGruppoNominativiModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaGruppoNominativi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaGruppoNominativi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaGruppoNominativi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaGruppoNominativi implementation " +
					rubricaGruppoNominativi.getClass());
		}

		RubricaGruppoNominativiModelImpl rubricaGruppoNominativiModelImpl =
			(RubricaGruppoNominativiModelImpl)rubricaGruppoNominativi;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaGruppoNominativi);
			}
			else {
				rubricaGruppoNominativi =
					(RubricaGruppoNominativi)session.merge(
						rubricaGruppoNominativi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaGruppoNominativiImpl.class, rubricaGruppoNominativiModelImpl,
			false, true);

		if (isNew) {
			rubricaGruppoNominativi.setNew(false);
		}

		rubricaGruppoNominativi.resetOriginalValues();

		return rubricaGruppoNominativi;
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaGruppoNominativiException {

		RubricaGruppoNominativi rubricaGruppoNominativi = fetchByPrimaryKey(
			primaryKey);

		if (rubricaGruppoNominativi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaGruppoNominativiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaGruppoNominativi;
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or throws a <code>NoSuchRubricaGruppoNominativiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi findByPrimaryKey(
			RubricaGruppoNominativiPK rubricaGruppoNominativiPK)
		throws NoSuchRubricaGruppoNominativiException {

		return findByPrimaryKey((Serializable)rubricaGruppoNominativiPK);
	}

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi, or <code>null</code> if a rubrica gruppo nominativi with the primary key could not be found
	 */
	@Override
	public RubricaGruppoNominativi fetchByPrimaryKey(
		RubricaGruppoNominativiPK rubricaGruppoNominativiPK) {

		return fetchByPrimaryKey((Serializable)rubricaGruppoNominativiPK);
	}

	/**
	 * Returns all the rubrica gruppo nominativis.
	 *
	 * @return the rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	@Override
	public List<RubricaGruppoNominativi> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppoNominativi> orderByComparator,
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

		List<RubricaGruppoNominativi> list = null;

		if (useFinderCache) {
			list = (List<RubricaGruppoNominativi>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICAGRUPPONOMINATIVI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAGRUPPONOMINATIVI;

				sql = sql.concat(
					RubricaGruppoNominativiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaGruppoNominativi>)QueryUtil.list(
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
	 * Removes all the rubrica gruppo nominativis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaGruppoNominativi rubricaGruppoNominativi : findAll()) {
			remove(rubricaGruppoNominativi);
		}
	}

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_RUBRICAGRUPPONOMINATIVI);

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
		return "rubricaGruppoNominativiPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICAGRUPPONOMINATIVI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaGruppoNominativiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica gruppo nominativi persistence.
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

		_finderPathWithPaginationFindByRubricaGruppoRuoloByNominativo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaGruppoRuoloByNominativo",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"FK_NOMINATIVO"}, true);

		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByNominativo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaGruppoRuoloByNominativo",
				new String[] {Long.class.getName()},
				new String[] {"FK_NOMINATIVO"}, true);

		_finderPathCountByRubricaGruppoRuoloByNominativo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoRuoloByNominativo",
			new String[] {Long.class.getName()}, new String[] {"FK_NOMINATIVO"},
			false);

		_finderPathWithPaginationFindByRubricaGruppoRuoloByGruppo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRubricaGruppoRuoloByGruppo",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"FK_GRUPPO"}, true);

		_finderPathWithoutPaginationFindByRubricaGruppoRuoloByGruppo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRubricaGruppoRuoloByGruppo",
				new String[] {Long.class.getName()}, new String[] {"FK_GRUPPO"},
				true);

		_finderPathCountByRubricaGruppoRuoloByGruppo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoRuoloByGruppo",
			new String[] {Long.class.getName()}, new String[] {"FK_GRUPPO"},
			false);

		RubricaGruppoNominativiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaGruppoNominativiUtil.setPersistence(null);

		dummyEntityCache.removeCache(
			RubricaGruppoNominativiImpl.class.getName());
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rubricaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_RUBRICAGRUPPONOMINATIVI =
		"SELECT rubricaGruppoNominativi FROM RubricaGruppoNominativi rubricaGruppoNominativi";

	private static final String _SQL_SELECT_RUBRICAGRUPPONOMINATIVI_WHERE =
		"SELECT rubricaGruppoNominativi FROM RubricaGruppoNominativi rubricaGruppoNominativi WHERE ";

	private static final String _SQL_COUNT_RUBRICAGRUPPONOMINATIVI =
		"SELECT COUNT(rubricaGruppoNominativi) FROM RubricaGruppoNominativi rubricaGruppoNominativi";

	private static final String _SQL_COUNT_RUBRICAGRUPPONOMINATIVI_WHERE =
		"SELECT COUNT(rubricaGruppoNominativi) FROM RubricaGruppoNominativi rubricaGruppoNominativi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"rubricaGruppoNominativi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaGruppoNominativi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaGruppoNominativi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaGruppoNominativiPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"FK_GRUPPO", "FK_NOMINATIVO"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}