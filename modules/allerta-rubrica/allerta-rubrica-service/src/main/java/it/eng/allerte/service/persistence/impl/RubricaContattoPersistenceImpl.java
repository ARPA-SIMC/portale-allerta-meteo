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

import it.eng.allerte.exception.NoSuchRubricaContattoException;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaContattoTable;
import it.eng.allerte.model.impl.RubricaContattoImpl;
import it.eng.allerte.model.impl.RubricaContattoModelImpl;
import it.eng.allerte.service.persistence.RubricaContattoPersistence;
import it.eng.allerte.service.persistence.RubricaContattoUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
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
 * The persistence implementation for the rubrica contatto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaContattoPersistence.class)
public class RubricaContattoPersistenceImpl
	extends BasePersistenceImpl<RubricaContatto>
	implements RubricaContattoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaContattoUtil</code> to access the rubrica contatto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaContattoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUtenteCreazioneContatto;
	private FinderPath
		_finderPathWithoutPaginationFindByUtenteCreazioneContatto;
	private FinderPath _finderPathCountByUtenteCreazioneContatto;

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE) {

		return findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end) {

		return findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUtenteCreazioneContatto;
				finderArgs = new Object[] {FK_UTENTE_CREAZIONE};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUtenteCreazioneContatto;
			finderArgs = new Object[] {
				FK_UTENTE_CREAZIONE, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (FK_UTENTE_CREAZIONE !=
							rubricaContatto.getFK_UTENTE_CREAZIONE()) {

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

			sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			sb.append(
				_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_UTENTE_CREAZIONE);

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteCreazioneContatto_First(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteCreazioneContatto_First(
			FK_UTENTE_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_UTENTE_CREAZIONE=");
		sb.append(FK_UTENTE_CREAZIONE);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteCreazioneContatto_First(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteCreazioneContatto_Last(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteCreazioneContatto_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_UTENTE_CREAZIONE=");
		sb.append(FK_UTENTE_CREAZIONE);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteCreazioneContatto_Last(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByUtenteCreazioneContatto(FK_UTENTE_CREAZIONE);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByUtenteCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByUtenteCreazioneContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_CREAZIONE,
				orderByComparator, true);

			array[1] = rubricaContatto;

			array[2] = getByUtenteCreazioneContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_CREAZIONE,
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

	protected RubricaContatto getByUtenteCreazioneContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto,
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		sb.append(_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2);

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
			sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_UTENTE_CREAZIONE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	@Override
	public void removeByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE) {
		for (RubricaContatto rubricaContatto :
				findByUtenteCreazioneContatto(
					FK_UTENTE_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE) {
		FinderPath finderPath = _finderPathCountByUtenteCreazioneContatto;

		Object[] finderArgs = new Object[] {FK_UTENTE_CREAZIONE};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			sb.append(
				_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_UTENTE_CREAZIONE);

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
		_FINDER_COLUMN_UTENTECREAZIONECONTATTO_FK_UTENTE_CREAZIONE_2 =
			"rubricaContatto.FK_UTENTE_CREAZIONE = ?";

	private FinderPath _finderPathWithPaginationFindByUtenteModificaContatto;
	private FinderPath _finderPathWithoutPaginationFindByUtenteModificaContatto;
	private FinderPath _finderPathCountByUtenteModificaContatto;

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA) {

		return findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUtenteModificaContatto;
				finderArgs = new Object[] {FK_UTENTE_MODIFICA};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUtenteModificaContatto;
			finderArgs = new Object[] {
				FK_UTENTE_MODIFICA, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (FK_UTENTE_MODIFICA !=
							rubricaContatto.getFK_UTENTE_MODIFICA()) {

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

			sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			sb.append(
				_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_UTENTE_MODIFICA);

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteModificaContatto_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteModificaContatto_First(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteModificaContatto_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByUtenteModificaContatto_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByUtenteModificaContatto_Last(
			FK_UTENTE_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_UTENTE_MODIFICA=");
		sb.append(FK_UTENTE_MODIFICA);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByUtenteModificaContatto_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByUtenteModificaContatto(FK_UTENTE_MODIFICA);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByUtenteModificaContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByUtenteModificaContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_MODIFICA, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByUtenteModificaContatto_PrevAndNext(
				session, rubricaContatto, FK_UTENTE_MODIFICA, orderByComparator,
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

	protected RubricaContatto getByUtenteModificaContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto,
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		sb.append(_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2);

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
			sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_UTENTE_MODIFICA);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	@Override
	public void removeByUtenteModificaContatto(long FK_UTENTE_MODIFICA) {
		for (RubricaContatto rubricaContatto :
				findByUtenteModificaContatto(
					FK_UTENTE_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByUtenteModificaContatto(long FK_UTENTE_MODIFICA) {
		FinderPath finderPath = _finderPathCountByUtenteModificaContatto;

		Object[] finderArgs = new Object[] {FK_UTENTE_MODIFICA};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			sb.append(
				_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_UTENTE_MODIFICA);

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
		_FINDER_COLUMN_UTENTEMODIFICACONTATTO_FK_UTENTE_MODIFICA_2 =
			"rubricaContatto.FK_UTENTE_MODIFICA = ?";

	private FinderPath _finderPathWithPaginationFindByContattoCanale;
	private FinderPath _finderPathWithoutPaginationFindByContattoCanale;
	private FinderPath _finderPathCountByContattoCanale;

	/**
	 * Returns all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(long FK_CANALE) {
		return findByContattoCanale(
			FK_CANALE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end) {

		return findByContattoCanale(FK_CANALE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByContattoCanale(
			FK_CANALE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContattoCanale;
				finderArgs = new Object[] {FK_CANALE};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContattoCanale;
			finderArgs = new Object[] {
				FK_CANALE, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (FK_CANALE != rubricaContatto.getFK_CANALE()) {
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

			sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			sb.append(_FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_CANALE);

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoCanale_First(
			long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoCanale_First(
			FK_CANALE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_CANALE=");
		sb.append(FK_CANALE);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoCanale_First(
		long FK_CANALE, OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByContattoCanale(
			FK_CANALE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoCanale_Last(
			long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoCanale_Last(
			FK_CANALE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_CANALE=");
		sb.append(FK_CANALE);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoCanale_Last(
		long FK_CANALE, OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByContattoCanale(FK_CANALE);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByContattoCanale(
			FK_CANALE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByContattoCanale_PrevAndNext(
			long ID_CONTATTO, long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByContattoCanale_PrevAndNext(
				session, rubricaContatto, FK_CANALE, orderByComparator, true);

			array[1] = rubricaContatto;

			array[2] = getByContattoCanale_PrevAndNext(
				session, rubricaContatto, FK_CANALE, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RubricaContatto getByContattoCanale_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, long FK_CANALE,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		sb.append(_FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2);

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
			sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(FK_CANALE);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_CANALE = &#63; from the database.
	 *
	 * @param FK_CANALE the fk_canale
	 */
	@Override
	public void removeByContattoCanale(long FK_CANALE) {
		for (RubricaContatto rubricaContatto :
				findByContattoCanale(
					FK_CANALE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByContattoCanale(long FK_CANALE) {
		FinderPath finderPath = _finderPathCountByContattoCanale;

		Object[] finderArgs = new Object[] {FK_CANALE};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			sb.append(_FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_CANALE);

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

	private static final String _FINDER_COLUMN_CONTATTOCANALE_FK_CANALE_2 =
		"rubricaContatto.FK_CANALE = ?";

	private FinderPath _finderPathWithPaginationFindByContattoNominativo;
	private FinderPath _finderPathWithoutPaginationFindByContattoNominativo;
	private FinderPath _finderPathCountByContattoNominativo;

	/**
	 * Returns all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(long FK_NOMINATIVO) {
		return findByContattoNominativo(
			FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end) {

		return findByContattoNominativo(FK_NOMINATIVO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByContattoNominativo(
			FK_NOMINATIVO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByContattoNominativo;
				finderArgs = new Object[] {FK_NOMINATIVO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContattoNominativo;
			finderArgs = new Object[] {
				FK_NOMINATIVO, start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (FK_NOMINATIVO != rubricaContatto.getFK_NOMINATIVO()) {
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

			sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			sb.append(_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_NOMINATIVO);

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoNominativo_First(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoNominativo_First(
			FK_NOMINATIVO, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_NOMINATIVO=");
		sb.append(FK_NOMINATIVO);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoNominativo_First(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByContattoNominativo(
			FK_NOMINATIVO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByContattoNominativo_Last(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByContattoNominativo_Last(
			FK_NOMINATIVO, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FK_NOMINATIVO=");
		sb.append(FK_NOMINATIVO);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByContattoNominativo_Last(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByContattoNominativo(FK_NOMINATIVO);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByContattoNominativo(
			FK_NOMINATIVO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByContattoNominativo_PrevAndNext(
			long ID_CONTATTO, long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByContattoNominativo_PrevAndNext(
				session, rubricaContatto, FK_NOMINATIVO, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByContattoNominativo_PrevAndNext(
				session, rubricaContatto, FK_NOMINATIVO, orderByComparator,
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

	protected RubricaContatto getByContattoNominativo_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		sb.append(_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2);

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
			sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
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
						rubricaContatto)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	@Override
	public void removeByContattoNominativo(long FK_NOMINATIVO) {
		for (RubricaContatto rubricaContatto :
				findByContattoNominativo(
					FK_NOMINATIVO, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByContattoNominativo(long FK_NOMINATIVO) {
		FinderPath finderPath = _finderPathCountByContattoNominativo;

		Object[] finderArgs = new Object[] {FK_NOMINATIVO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			sb.append(_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2);

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
		_FINDER_COLUMN_CONTATTONOMINATIVO_FK_NOMINATIVO_2 =
			"rubricaContatto.FK_NOMINATIVO = ?";

	private FinderPath _finderPathWithPaginationFindByDataCreazioneContatto;
	private FinderPath _finderPathWithoutPaginationFindByDataCreazioneContatto;
	private FinderPath _finderPathCountByDataCreazioneContatto;

	/**
	 * Returns all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE) {

		return findByDataCreazioneContatto(
			DATA_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end) {

		return findByDataCreazioneContatto(DATA_CREAZIONE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByDataCreazioneContatto(
			DATA_CREAZIONE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDataCreazioneContatto;
				finderArgs = new Object[] {_getTime(DATA_CREAZIONE)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataCreazioneContatto;
			finderArgs = new Object[] {
				_getTime(DATA_CREAZIONE), start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (!Objects.equals(
							DATA_CREAZIONE,
							rubricaContatto.getDATA_CREAZIONE())) {

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

			sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_CREAZIONE = false;

			if (DATA_CREAZIONE == null) {
				sb.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1);
			}
			else {
				bindDATA_CREAZIONE = true;

				sb.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDATA_CREAZIONE) {
					queryPos.add(new Timestamp(DATA_CREAZIONE.getTime()));
				}

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataCreazioneContatto_First(
			Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataCreazioneContatto_First(
			DATA_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("DATA_CREAZIONE=");
		sb.append(DATA_CREAZIONE);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataCreazioneContatto_First(
		Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByDataCreazioneContatto(
			DATA_CREAZIONE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataCreazioneContatto_Last(
			Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataCreazioneContatto_Last(
			DATA_CREAZIONE, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("DATA_CREAZIONE=");
		sb.append(DATA_CREAZIONE);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataCreazioneContatto_Last(
		Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByDataCreazioneContatto(DATA_CREAZIONE);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByDataCreazioneContatto(
			DATA_CREAZIONE, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByDataCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByDataCreazioneContatto_PrevAndNext(
				session, rubricaContatto, DATA_CREAZIONE, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByDataCreazioneContatto_PrevAndNext(
				session, rubricaContatto, DATA_CREAZIONE, orderByComparator,
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

	protected RubricaContatto getByDataCreazioneContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		boolean bindDATA_CREAZIONE = false;

		if (DATA_CREAZIONE == null) {
			sb.append(_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1);
		}
		else {
			bindDATA_CREAZIONE = true;

			sb.append(_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2);
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
			sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDATA_CREAZIONE) {
			queryPos.add(new Timestamp(DATA_CREAZIONE.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where DATA_CREAZIONE = &#63; from the database.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 */
	@Override
	public void removeByDataCreazioneContatto(Date DATA_CREAZIONE) {
		for (RubricaContatto rubricaContatto :
				findByDataCreazioneContatto(
					DATA_CREAZIONE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByDataCreazioneContatto(Date DATA_CREAZIONE) {
		FinderPath finderPath = _finderPathCountByDataCreazioneContatto;

		Object[] finderArgs = new Object[] {_getTime(DATA_CREAZIONE)};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_CREAZIONE = false;

			if (DATA_CREAZIONE == null) {
				sb.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1);
			}
			else {
				bindDATA_CREAZIONE = true;

				sb.append(
					_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDATA_CREAZIONE) {
					queryPos.add(new Timestamp(DATA_CREAZIONE.getTime()));
				}

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
		_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_1 =
			"rubricaContatto.DATA_CREAZIONE IS NULL";

	private static final String
		_FINDER_COLUMN_DATACREAZIONECONTATTO_DATA_CREAZIONE_2 =
			"rubricaContatto.DATA_CREAZIONE = ?";

	private FinderPath _finderPathWithPaginationFindByDataModificaContatto;
	private FinderPath _finderPathWithoutPaginationFindByDataModificaContatto;
	private FinderPath _finderPathCountByDataModificaContatto;

	/**
	 * Returns all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA) {

		return findByDataModificaContatto(
			DATA_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end) {

		return findByDataModificaContatto(DATA_MODIFICA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findByDataModificaContatto(
			DATA_MODIFICA, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDataModificaContatto;
				finderArgs = new Object[] {_getTime(DATA_MODIFICA)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataModificaContatto;
			finderArgs = new Object[] {
				_getTime(DATA_MODIFICA), start, end, orderByComparator
			};
		}

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RubricaContatto rubricaContatto : list) {
					if (!Objects.equals(
							DATA_MODIFICA,
							rubricaContatto.getDATA_MODIFICA())) {

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

			sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				sb.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				sb.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDATA_MODIFICA) {
					queryPos.add(new Timestamp(DATA_MODIFICA.getTime()));
				}

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataModificaContatto_First(
			Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataModificaContatto_First(
			DATA_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataModificaContatto_First(
		Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		List<RubricaContatto> list = findByDataModificaContatto(
			DATA_MODIFICA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto findByDataModificaContatto_Last(
			Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByDataModificaContatto_Last(
			DATA_MODIFICA, orderByComparator);

		if (rubricaContatto != null) {
			return rubricaContatto;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("DATA_MODIFICA=");
		sb.append(DATA_MODIFICA);

		sb.append("}");

		throw new NoSuchRubricaContattoException(sb.toString());
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	@Override
	public RubricaContatto fetchByDataModificaContatto_Last(
		Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		int count = countByDataModificaContatto(DATA_MODIFICA);

		if (count == 0) {
			return null;
		}

		List<RubricaContatto> list = findByDataModificaContatto(
			DATA_MODIFICA, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto[] findByDataModificaContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = findByPrimaryKey(ID_CONTATTO);

		Session session = null;

		try {
			session = openSession();

			RubricaContatto[] array = new RubricaContattoImpl[3];

			array[0] = getByDataModificaContatto_PrevAndNext(
				session, rubricaContatto, DATA_MODIFICA, orderByComparator,
				true);

			array[1] = rubricaContatto;

			array[2] = getByDataModificaContatto_PrevAndNext(
				session, rubricaContatto, DATA_MODIFICA, orderByComparator,
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

	protected RubricaContatto getByDataModificaContatto_PrevAndNext(
		Session session, RubricaContatto rubricaContatto, Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		sb.append(_SQL_SELECT_RUBRICACONTATTO_WHERE);

		boolean bindDATA_MODIFICA = false;

		if (DATA_MODIFICA == null) {
			sb.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1);
		}
		else {
			bindDATA_MODIFICA = true;

			sb.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2);
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
			sb.append(RubricaContattoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDATA_MODIFICA) {
			queryPos.add(new Timestamp(DATA_MODIFICA.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rubricaContatto)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RubricaContatto> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rubrica contattos where DATA_MODIFICA = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 */
	@Override
	public void removeByDataModificaContatto(Date DATA_MODIFICA) {
		for (RubricaContatto rubricaContatto :
				findByDataModificaContatto(
					DATA_MODIFICA, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the number of matching rubrica contattos
	 */
	@Override
	public int countByDataModificaContatto(Date DATA_MODIFICA) {
		FinderPath finderPath = _finderPathCountByDataModificaContatto;

		Object[] finderArgs = new Object[] {_getTime(DATA_MODIFICA)};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RUBRICACONTATTO_WHERE);

			boolean bindDATA_MODIFICA = false;

			if (DATA_MODIFICA == null) {
				sb.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1);
			}
			else {
				bindDATA_MODIFICA = true;

				sb.append(_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDATA_MODIFICA) {
					queryPos.add(new Timestamp(DATA_MODIFICA.getTime()));
				}

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
		_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_1 =
			"rubricaContatto.DATA_MODIFICA IS NULL";

	private static final String
		_FINDER_COLUMN_DATAMODIFICACONTATTO_DATA_MODIFICA_2 =
			"rubricaContatto.DATA_MODIFICA = ?";

	public RubricaContattoPersistenceImpl() {
		setModelClass(RubricaContatto.class);

		setModelImplClass(RubricaContattoImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaContattoTable.INSTANCE);
	}

	/**
	 * Caches the rubrica contatto in the entity cache if it is enabled.
	 *
	 * @param rubricaContatto the rubrica contatto
	 */
	@Override
	public void cacheResult(RubricaContatto rubricaContatto) {
		dummyEntityCache.putResult(
			RubricaContattoImpl.class, rubricaContatto.getPrimaryKey(),
			rubricaContatto);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica contattos in the entity cache if it is enabled.
	 *
	 * @param rubricaContattos the rubrica contattos
	 */
	@Override
	public void cacheResult(List<RubricaContatto> rubricaContattos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaContattos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaContatto rubricaContatto : rubricaContattos) {
			if (dummyEntityCache.getResult(
					RubricaContattoImpl.class,
					rubricaContatto.getPrimaryKey()) == null) {

				cacheResult(rubricaContatto);
			}
		}
	}

	/**
	 * Clears the cache for all rubrica contattos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(RubricaContattoImpl.class);

		dummyFinderCache.clearCache(RubricaContattoImpl.class);
	}

	/**
	 * Clears the cache for the rubrica contatto.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaContatto rubricaContatto) {
		dummyEntityCache.removeResult(
			RubricaContattoImpl.class, rubricaContatto);
	}

	@Override
	public void clearCache(List<RubricaContatto> rubricaContattos) {
		for (RubricaContatto rubricaContatto : rubricaContattos) {
			dummyEntityCache.removeResult(
				RubricaContattoImpl.class, rubricaContatto);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaContattoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				RubricaContattoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rubrica contatto with the primary key. Does not add the rubrica contatto to the database.
	 *
	 * @param ID_CONTATTO the primary key for the new rubrica contatto
	 * @return the new rubrica contatto
	 */
	@Override
	public RubricaContatto create(long ID_CONTATTO) {
		RubricaContatto rubricaContatto = new RubricaContattoImpl();

		rubricaContatto.setNew(true);
		rubricaContatto.setPrimaryKey(ID_CONTATTO);

		return rubricaContatto;
	}

	/**
	 * Removes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto remove(long ID_CONTATTO)
		throws NoSuchRubricaContattoException {

		return remove((Serializable)ID_CONTATTO);
	}

	/**
	 * Removes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto remove(Serializable primaryKey)
		throws NoSuchRubricaContattoException {

		Session session = null;

		try {
			session = openSession();

			RubricaContatto rubricaContatto = (RubricaContatto)session.get(
				RubricaContattoImpl.class, primaryKey);

			if (rubricaContatto == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaContattoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaContatto);
		}
		catch (NoSuchRubricaContattoException noSuchEntityException) {
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
	protected RubricaContatto removeImpl(RubricaContatto rubricaContatto) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaContatto)) {
				rubricaContatto = (RubricaContatto)session.get(
					RubricaContattoImpl.class,
					rubricaContatto.getPrimaryKeyObj());
			}

			if (rubricaContatto != null) {
				session.delete(rubricaContatto);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rubricaContatto != null) {
			clearCache(rubricaContatto);
		}

		return rubricaContatto;
	}

	@Override
	public RubricaContatto updateImpl(RubricaContatto rubricaContatto) {
		boolean isNew = rubricaContatto.isNew();

		if (!(rubricaContatto instanceof RubricaContattoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaContatto.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaContatto);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaContatto proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaContatto implementation " +
					rubricaContatto.getClass());
		}

		RubricaContattoModelImpl rubricaContattoModelImpl =
			(RubricaContattoModelImpl)rubricaContatto;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rubricaContatto);
			}
			else {
				rubricaContatto = (RubricaContatto)session.merge(
					rubricaContatto);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaContattoImpl.class, rubricaContattoModelImpl, false, true);

		if (isNew) {
			rubricaContatto.setNew(false);
		}

		rubricaContatto.resetOriginalValues();

		return rubricaContatto;
	}

	/**
	 * Returns the rubrica contatto with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaContattoException {

		RubricaContatto rubricaContatto = fetchByPrimaryKey(primaryKey);

		if (rubricaContatto == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaContattoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaContatto;
	}

	/**
	 * Returns the rubrica contatto with the primary key or throws a <code>NoSuchRubricaContattoException</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto findByPrimaryKey(long ID_CONTATTO)
		throws NoSuchRubricaContattoException {

		return findByPrimaryKey((Serializable)ID_CONTATTO);
	}

	/**
	 * Returns the rubrica contatto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto, or <code>null</code> if a rubrica contatto with the primary key could not be found
	 */
	@Override
	public RubricaContatto fetchByPrimaryKey(long ID_CONTATTO) {
		return fetchByPrimaryKey((Serializable)ID_CONTATTO);
	}

	/**
	 * Returns all the rubrica contattos.
	 *
	 * @return the rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll(
		int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica contattos
	 */
	@Override
	public List<RubricaContatto> findAll(
		int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
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

		List<RubricaContatto> list = null;

		if (useFinderCache) {
			list = (List<RubricaContatto>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICACONTATTO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICACONTATTO;

				sql = sql.concat(RubricaContattoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaContatto>)QueryUtil.list(
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
	 * Removes all the rubrica contattos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaContatto rubricaContatto : findAll()) {
			remove(rubricaContatto);
		}
	}

	/**
	 * Returns the number of rubrica contattos.
	 *
	 * @return the number of rubrica contattos
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICACONTATTO);

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
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID_CONTATTO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICACONTATTO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaContattoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica contatto persistence.
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

		_finderPathWithPaginationFindByUtenteCreazioneContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtenteCreazioneContatto",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"FK_UTENTE_CREAZIONE"}, true);

		_finderPathWithoutPaginationFindByUtenteCreazioneContatto =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUtenteCreazioneContatto",
				new String[] {Long.class.getName()},
				new String[] {"FK_UTENTE_CREAZIONE"}, true);

		_finderPathCountByUtenteCreazioneContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUtenteCreazioneContatto",
			new String[] {Long.class.getName()},
			new String[] {"FK_UTENTE_CREAZIONE"}, false);

		_finderPathWithPaginationFindByUtenteModificaContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUtenteModificaContatto",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"FK_UTENTE_MODIFICA"}, true);

		_finderPathWithoutPaginationFindByUtenteModificaContatto =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUtenteModificaContatto",
				new String[] {Long.class.getName()},
				new String[] {"FK_UTENTE_MODIFICA"}, true);

		_finderPathCountByUtenteModificaContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUtenteModificaContatto",
			new String[] {Long.class.getName()},
			new String[] {"FK_UTENTE_MODIFICA"}, false);

		_finderPathWithPaginationFindByContattoCanale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContattoCanale",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"FK_CANALE"}, true);

		_finderPathWithoutPaginationFindByContattoCanale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContattoCanale",
			new String[] {Long.class.getName()}, new String[] {"FK_CANALE"},
			true);

		_finderPathCountByContattoCanale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContattoCanale",
			new String[] {Long.class.getName()}, new String[] {"FK_CANALE"},
			false);

		_finderPathWithPaginationFindByContattoNominativo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContattoNominativo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"FK_NOMINATIVO"}, true);

		_finderPathWithoutPaginationFindByContattoNominativo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContattoNominativo", new String[] {Long.class.getName()},
			new String[] {"FK_NOMINATIVO"}, true);

		_finderPathCountByContattoNominativo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContattoNominativo", new String[] {Long.class.getName()},
			new String[] {"FK_NOMINATIVO"}, false);

		_finderPathWithPaginationFindByDataCreazioneContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDataCreazioneContatto",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"DATA_CREAZIONE"}, true);

		_finderPathWithoutPaginationFindByDataCreazioneContatto =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDataCreazioneContatto",
				new String[] {Date.class.getName()},
				new String[] {"DATA_CREAZIONE"}, true);

		_finderPathCountByDataCreazioneContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataCreazioneContatto", new String[] {Date.class.getName()},
			new String[] {"DATA_CREAZIONE"}, false);

		_finderPathWithPaginationFindByDataModificaContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDataModificaContatto",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"DATA_MODIFICA"}, true);

		_finderPathWithoutPaginationFindByDataModificaContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDataModificaContatto", new String[] {Date.class.getName()},
			new String[] {"DATA_MODIFICA"}, true);

		_finderPathCountByDataModificaContatto = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataModificaContatto", new String[] {Date.class.getName()},
			new String[] {"DATA_MODIFICA"}, false);

		RubricaContattoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaContattoUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaContattoImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_RUBRICACONTATTO =
		"SELECT rubricaContatto FROM RubricaContatto rubricaContatto";

	private static final String _SQL_SELECT_RUBRICACONTATTO_WHERE =
		"SELECT rubricaContatto FROM RubricaContatto rubricaContatto WHERE ";

	private static final String _SQL_COUNT_RUBRICACONTATTO =
		"SELECT COUNT(rubricaContatto) FROM RubricaContatto rubricaContatto";

	private static final String _SQL_COUNT_RUBRICACONTATTO_WHERE =
		"SELECT COUNT(rubricaContatto) FROM RubricaContatto rubricaContatto WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaContatto.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaContatto exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaContatto exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaContattoPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}