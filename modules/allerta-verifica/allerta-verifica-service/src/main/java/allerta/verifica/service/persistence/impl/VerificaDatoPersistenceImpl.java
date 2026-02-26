/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.impl;

import allerta.verifica.exception.NoSuchVerificaDatoException;
import allerta.verifica.model.VerificaDato;
import allerta.verifica.model.VerificaDatoTable;
import allerta.verifica.model.impl.VerificaDatoImpl;
import allerta.verifica.model.impl.VerificaDatoModelImpl;
import allerta.verifica.service.persistence.VerificaDatoPersistence;
import allerta.verifica.service.persistence.VerificaDatoUtil;
import allerta.verifica.service.persistence.impl.constants.VERIFICAPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
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
 * The persistence implementation for the verifica dato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VerificaDatoPersistence.class)
public class VerificaDatoPersistenceImpl
	extends BasePersistenceImpl<VerificaDato>
	implements VerificaDatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VerificaDatoUtil</code> to access the verifica dato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VerificaDatoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocumento;
	private FinderPath _finderPathWithoutPaginationFindByDocumento;
	private FinderPath _finderPathCountByDocumento;

	/**
	 * Returns all the verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(long documento) {
		return findByDocumento(
			documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(
		long documento, int start, int end) {

		return findByDocumento(documento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumento(documento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumento;
				finderArgs = new Object[] {documento};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumento;
			finderArgs = new Object[] {
				documento, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (documento != verificaDato.getDocumento()) {
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

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumento_First(
			long documento, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumento_First(
			documento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumento_First(
		long documento, OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumento(
			documento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumento_Last(
			long documento, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumento_Last(
			documento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumento_Last(
		long documento, OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumento(documento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumento(
			documento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumento_PrevAndNext(
				session, verificaDato, documento, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumento_PrevAndNext(
				session, verificaDato, documento, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected VerificaDato getByDocumento_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	@Override
	public void removeByDocumento(long documento) {
		for (VerificaDato verificaDato :
				findByDocumento(
					documento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumento(long documento) {
		FinderPath finderPath = _finderPathCountByDocumento;

		Object[] finderArgs = new Object[] {documento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

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

	private static final String _FINDER_COLUMN_DOCUMENTO_DOCUMENTO_2 =
		"verificaDato.documento = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiorno;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoGiorno;
	private FinderPath _finderPathCountByDocumentoGiorno;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno) {

		return findByDocumentoGiorno(
			documento, giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end) {

		return findByDocumentoGiorno(documento, giorno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiorno(
			documento, giorno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiorno(
		long documento, Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumentoGiorno;
				finderArgs = new Object[] {documento, _getTime(giorno)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentoGiorno;
			finderArgs = new Object[] {
				documento, _getTime(giorno), start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno())) {

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

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiorno_First(
			long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiorno_First(
			documento, giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiorno_First(
		long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiorno(
			documento, giorno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiorno_Last(
			long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiorno_Last(
			documento, giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiorno_Last(
		long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiorno(documento, giorno);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiorno(
			documento, giorno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiorno_PrevAndNext(
			long id, long documento, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiorno_PrevAndNext(
				session, verificaDato, documento, giorno, orderByComparator,
				true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiorno_PrevAndNext(
				session, verificaDato, documento, giorno, orderByComparator,
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

	protected VerificaDato getByDocumentoGiorno_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2);
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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 */
	@Override
	public void removeByDocumentoGiorno(long documento, Date giorno) {
		for (VerificaDato verificaDato :
				findByDocumentoGiorno(
					documento, giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiorno(long documento, Date giorno) {
		FinderPath finderPath = _finderPathCountByDocumentoGiorno;

		Object[] finderArgs = new Object[] {documento, _getTime(giorno)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
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

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNO_DOCUMENTO_2 =
		"verificaDato.documento = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_1 =
		"verificaDato.giorno IS NULL";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNO_GIORNO_2 =
		"verificaDato.giorno = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiornoEvento;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoGiornoEvento;
	private FinderPath _finderPathCountByDocumentoGiornoEvento;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		return findByDocumentoGiornoEvento(
			documento, giorno, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end) {

		return findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiornoEvento(
			documento, giorno, evento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoEvento(
		long documento, Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDocumentoGiornoEvento;
				finderArgs = new Object[] {documento, _getTime(giorno), evento};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentoGiornoEvento;
			finderArgs = new Object[] {
				documento, _getTime(giorno), evento, start, end,
				orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno()) ||
						(evento != verificaDato.getEvento())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2);
			}

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				queryPos.add(evento);

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoEvento_First(
			long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoEvento_First(
			documento, giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoEvento_First(
		long documento, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiornoEvento(
			documento, giorno, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoEvento_Last(
			long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoEvento_Last(
			documento, giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoEvento_Last(
		long documento, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiornoEvento(documento, giorno, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiornoEvento(
			documento, giorno, evento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiornoEvento_PrevAndNext(
			long id, long documento, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiornoEvento_PrevAndNext(
				session, verificaDato, documento, giorno, evento,
				orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiornoEvento_PrevAndNext(
				session, verificaDato, documento, giorno, evento,
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

	protected VerificaDato getByDocumentoGiornoEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		long evento, OrderByComparator<VerificaDato> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2);
		}

		sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2);

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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		queryPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	@Override
	public void removeByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		for (VerificaDato verificaDato :
				findByDocumentoGiornoEvento(
					documento, giorno, evento, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiornoEvento(
		long documento, Date giorno, long evento) {

		FinderPath finderPath = _finderPathCountByDocumentoGiornoEvento;

		Object[] finderArgs = new Object[] {
			documento, _getTime(giorno), evento
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2);
			}

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				queryPos.add(evento);

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
		_FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_DOCUMENTO_2 =
			"verificaDato.documento = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOEVENTO_EVENTO_2 =
		"verificaDato.evento = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiornoZona;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoGiornoZona;
	private FinderPath _finderPathCountByDocumentoGiornoZona;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		return findByDocumentoGiornoZona(
			documento, giorno, zona, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end) {

		return findByDocumentoGiornoZona(
			documento, giorno, zona, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiornoZona(
			documento, giorno, zona, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZona(
		long documento, Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDocumentoGiornoZona;
				finderArgs = new Object[] {documento, _getTime(giorno), zona};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentoGiornoZona;
			finderArgs = new Object[] {
				documento, _getTime(giorno), zona, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
				}

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZona_First(
			long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZona_First(
			documento, giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZona_First(
		long documento, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiornoZona(
			documento, giorno, zona, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZona_Last(
			long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZona_Last(
			documento, giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZona_Last(
		long documento, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiornoZona(documento, giorno, zona);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiornoZona(
			documento, giorno, zona, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiornoZona_PrevAndNext(
			long id, long documento, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiornoZona_PrevAndNext(
				session, verificaDato, documento, giorno, zona,
				orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiornoZona_PrevAndNext(
				session, verificaDato, documento, giorno, zona,
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

	protected VerificaDato getByDocumentoGiornoZona_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		String zona, OrderByComparator<VerificaDato> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3);
		}
		else {
			bindZona = true;

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2);
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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			queryPos.add(zona);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	@Override
	public void removeByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		for (VerificaDato verificaDato :
				findByDocumentoGiornoZona(
					documento, giorno, zona, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiornoZona(
		long documento, Date giorno, String zona) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByDocumentoGiornoZona;

		Object[] finderArgs = new Object[] {documento, _getTime(giorno), zona};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
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

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_DOCUMENTO_2 =
		"verificaDato.documento = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_2 =
		"verificaDato.zona = ?";

	private static final String _FINDER_COLUMN_DOCUMENTOGIORNOZONA_ZONA_3 =
		"(verificaDato.zona IS NULL OR verificaDato.zona = '')";

	private FinderPath _finderPathWithPaginationFindByDocumentoGiornoZonaEvento;
	private FinderPath
		_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento;
	private FinderPath _finderPathCountByDocumentoGiornoZonaEvento;

	/**
	 * Returns all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		return findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end) {

		return findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end, OrderByComparator<VerificaDato> orderByComparator) {

		return findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento, int start,
		int end, OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento;
				finderArgs = new Object[] {
					documento, _getTime(giorno), zona, evento
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDocumentoGiornoZonaEvento;
			finderArgs = new Object[] {
				documento, _getTime(giorno), zona, evento, start, end,
				orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if ((documento != verificaDato.getDocumento()) ||
						!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona()) ||
						(evento != verificaDato.getEvento())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2);
			}

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
				}

				queryPos.add(evento);

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZonaEvento_First(
			long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZonaEvento_First(
			documento, giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZonaEvento_First(
		long documento, Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByDocumentoGiornoZonaEvento_Last(
			long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByDocumentoGiornoZonaEvento_Last(
			documento, giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documento=");
		sb.append(documento);

		sb.append(", giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByDocumentoGiornoZonaEvento_Last(
		long documento, Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByDocumentoGiornoZonaEvento(
			documento, giorno, zona, evento, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByDocumentoGiornoZonaEvento_PrevAndNext(
			long id, long documento, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByDocumentoGiornoZonaEvento_PrevAndNext(
				session, verificaDato, documento, giorno, zona, evento,
				orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByDocumentoGiornoZonaEvento_PrevAndNext(
				session, verificaDato, documento, giorno, zona, evento,
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

	protected VerificaDato getByDocumentoGiornoZonaEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, long documento, Date giorno,
		String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3);
		}
		else {
			bindZona = true;

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2);
		}

		sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2);

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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documento);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			queryPos.add(zona);
		}

		queryPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	@Override
	public void removeByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		for (VerificaDato verificaDato :
				findByDocumentoGiornoZonaEvento(
					documento, giorno, zona, evento, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where documento = &#63; and giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param documento the documento
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByDocumentoGiornoZonaEvento(
		long documento, Date giorno, String zona, long evento) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByDocumentoGiornoZonaEvento;

		Object[] finderArgs = new Object[] {
			documento, _getTime(giorno), zona, evento
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2);
			}

			sb.append(_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documento);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
				}

				queryPos.add(evento);

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
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_DOCUMENTO_2 =
			"verificaDato.documento = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_1 =
			"verificaDato.giorno IS NULL AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_GIORNO_2 =
			"verificaDato.giorno = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_2 =
			"verificaDato.zona = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_ZONA_3 =
			"(verificaDato.zona IS NULL OR verificaDato.zona = '') AND ";

	private static final String
		_FINDER_COLUMN_DOCUMENTOGIORNOZONAEVENTO_EVENTO_2 =
			"verificaDato.evento = ?";

	private FinderPath _finderPathWithPaginationFindByGiorno;
	private FinderPath _finderPathWithoutPaginationFindByGiorno;
	private FinderPath _finderPathCountByGiorno;

	/**
	 * Returns all the verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(Date giorno) {
		return findByGiorno(giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(Date giorno, int start, int end) {
		return findByGiorno(giorno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiorno(giorno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiorno(
		Date giorno, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGiorno;
				finderArgs = new Object[] {_getTime(giorno)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGiorno;
			finderArgs = new Object[] {
				_getTime(giorno), start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno())) {
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

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNO_GIORNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiorno_First(
			Date giorno, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiorno_First(
			giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiorno_First(
		Date giorno, OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiorno(giorno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiorno_Last(
			Date giorno, OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiorno_Last(
			giorno, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiorno_Last(
		Date giorno, OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiorno(giorno);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiorno(
			giorno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiorno_PrevAndNext(
			long id, Date giorno,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiorno_PrevAndNext(
				session, verificaDato, giorno, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByGiorno_PrevAndNext(
				session, verificaDato, giorno, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected VerificaDato getByGiorno_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_GIORNO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_GIORNO_GIORNO_2);
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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; from the database.
	 *
	 * @param giorno the giorno
	 */
	@Override
	public void removeByGiorno(Date giorno) {
		for (VerificaDato verificaDato :
				findByGiorno(
					giorno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63;.
	 *
	 * @param giorno the giorno
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiorno(Date giorno) {
		FinderPath finderPath = _finderPathCountByGiorno;

		Object[] finderArgs = new Object[] {_getTime(giorno)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNO_GIORNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
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

	private static final String _FINDER_COLUMN_GIORNO_GIORNO_1 =
		"verificaDato.giorno IS NULL";

	private static final String _FINDER_COLUMN_GIORNO_GIORNO_2 =
		"verificaDato.giorno = ?";

	private FinderPath _finderPathWithPaginationFindByGiornoZona;
	private FinderPath _finderPathWithoutPaginationFindByGiornoZona;
	private FinderPath _finderPathCountByGiornoZona;

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(Date giorno, String zona) {
		return findByGiornoZona(
			giorno, zona, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end) {

		return findByGiornoZona(giorno, zona, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiornoZona(
			giorno, zona, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZona(
		Date giorno, String zona, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGiornoZona;
				finderArgs = new Object[] {_getTime(giorno), zona};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGiornoZona;
			finderArgs = new Object[] {
				_getTime(giorno), zona, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona())) {

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

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_GIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_GIORNOZONA_ZONA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
				}

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZona_First(
			Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZona_First(
			giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZona_First(
		Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiornoZona(
			giorno, zona, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZona_Last(
			Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZona_Last(
			giorno, zona, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZona_Last(
		Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiornoZona(giorno, zona);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiornoZona(
			giorno, zona, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and zona = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiornoZona_PrevAndNext(
			long id, Date giorno, String zona,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiornoZona_PrevAndNext(
				session, verificaDato, giorno, zona, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByGiornoZona_PrevAndNext(
				session, verificaDato, giorno, zona, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected VerificaDato getByGiornoZona_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno, String zona,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			sb.append(_FINDER_COLUMN_GIORNOZONA_ZONA_3);
		}
		else {
			bindZona = true;

			sb.append(_FINDER_COLUMN_GIORNOZONA_ZONA_2);
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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			queryPos.add(zona);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 */
	@Override
	public void removeByGiornoZona(Date giorno, String zona) {
		for (VerificaDato verificaDato :
				findByGiornoZona(
					giorno, zona, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiornoZona(Date giorno, String zona) {
		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByGiornoZona;

		Object[] finderArgs = new Object[] {_getTime(giorno), zona};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNOZONA_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_GIORNOZONA_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_GIORNOZONA_ZONA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
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

	private static final String _FINDER_COLUMN_GIORNOZONA_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_GIORNOZONA_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOZONA_ZONA_2 =
		"verificaDato.zona = ?";

	private static final String _FINDER_COLUMN_GIORNOZONA_ZONA_3 =
		"(verificaDato.zona IS NULL OR verificaDato.zona = '')";

	private FinderPath _finderPathWithPaginationFindByGiornoEvento;
	private FinderPath _finderPathWithoutPaginationFindByGiornoEvento;
	private FinderPath _finderPathCountByGiornoEvento;

	/**
	 * Returns all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(Date giorno, long evento) {
		return findByGiornoEvento(
			giorno, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end) {

		return findByGiornoEvento(giorno, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiornoEvento(
			giorno, evento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoEvento(
		Date giorno, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGiornoEvento;
				finderArgs = new Object[] {_getTime(giorno), evento};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGiornoEvento;
			finderArgs = new Object[] {
				_getTime(giorno), evento, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno()) ||
						(evento != verificaDato.getEvento())) {

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

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_2);
			}

			sb.append(_FINDER_COLUMN_GIORNOEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				queryPos.add(evento);

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoEvento_First(
			Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoEvento_First(
			giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoEvento_First(
		Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiornoEvento(
			giorno, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoEvento_Last(
			Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoEvento_Last(
			giorno, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoEvento_Last(
		Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiornoEvento(giorno, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiornoEvento(
			giorno, evento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiornoEvento_PrevAndNext(
			long id, Date giorno, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiornoEvento_PrevAndNext(
				session, verificaDato, giorno, evento, orderByComparator, true);

			array[1] = verificaDato;

			array[2] = getByGiornoEvento_PrevAndNext(
				session, verificaDato, giorno, evento, orderByComparator,
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

	protected VerificaDato getByGiornoEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno, long evento,
		OrderByComparator<VerificaDato> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_2);
		}

		sb.append(_FINDER_COLUMN_GIORNOEVENTO_EVENTO_2);

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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		queryPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 */
	@Override
	public void removeByGiornoEvento(Date giorno, long evento) {
		for (VerificaDato verificaDato :
				findByGiornoEvento(
					giorno, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiornoEvento(Date giorno, long evento) {
		FinderPath finderPath = _finderPathCountByGiornoEvento;

		Object[] finderArgs = new Object[] {_getTime(giorno), evento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNOEVENTO_GIORNO_2);
			}

			sb.append(_FINDER_COLUMN_GIORNOEVENTO_EVENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				queryPos.add(evento);

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

	private static final String _FINDER_COLUMN_GIORNOEVENTO_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_GIORNOEVENTO_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOEVENTO_EVENTO_2 =
		"verificaDato.evento = ?";

	private FinderPath _finderPathWithPaginationFindByGiornoZonaEvento;
	private FinderPath _finderPathWithoutPaginationFindByGiornoZonaEvento;
	private FinderPath _finderPathCountByGiornoZonaEvento;

	/**
	 * Returns all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		return findByGiornoZonaEvento(
			giorno, zona, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end) {

		return findByGiornoZonaEvento(giorno, zona, evento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator) {

		return findByGiornoZonaEvento(
			giorno, zona, evento, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verifica datos
	 */
	@Override
	public List<VerificaDato> findByGiornoZonaEvento(
		Date giorno, String zona, long evento, int start, int end,
		OrderByComparator<VerificaDato> orderByComparator,
		boolean useFinderCache) {

		zona = Objects.toString(zona, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGiornoZonaEvento;
				finderArgs = new Object[] {_getTime(giorno), zona, evento};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGiornoZonaEvento;
			finderArgs = new Object[] {
				_getTime(giorno), zona, evento, start, end, orderByComparator
			};
		}

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerificaDato verificaDato : list) {
					if (!Objects.equals(giorno, verificaDato.getGiorno()) ||
						!zona.equals(verificaDato.getZona()) ||
						(evento != verificaDato.getEvento())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2);
			}

			sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
				}

				queryPos.add(evento);

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZonaEvento_First(
			Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZonaEvento_First(
			giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the first verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZonaEvento_First(
		Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		List<VerificaDato> list = findByGiornoZonaEvento(
			giorno, zona, evento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato
	 * @throws NoSuchVerificaDatoException if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato findByGiornoZonaEvento_Last(
			Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByGiornoZonaEvento_Last(
			giorno, zona, evento, orderByComparator);

		if (verificaDato != null) {
			return verificaDato;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("giorno=");
		sb.append(giorno);

		sb.append(", zona=");
		sb.append(zona);

		sb.append(", evento=");
		sb.append(evento);

		sb.append("}");

		throw new NoSuchVerificaDatoException(sb.toString());
	}

	/**
	 * Returns the last verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verifica dato, or <code>null</code> if a matching verifica dato could not be found
	 */
	@Override
	public VerificaDato fetchByGiornoZonaEvento_Last(
		Date giorno, String zona, long evento,
		OrderByComparator<VerificaDato> orderByComparator) {

		int count = countByGiornoZonaEvento(giorno, zona, evento);

		if (count == 0) {
			return null;
		}

		List<VerificaDato> list = findByGiornoZonaEvento(
			giorno, zona, evento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verifica datos before and after the current verifica dato in the ordered set where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param id the primary key of the current verifica dato
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato[] findByGiornoZonaEvento_PrevAndNext(
			long id, Date giorno, String zona, long evento,
			OrderByComparator<VerificaDato> orderByComparator)
		throws NoSuchVerificaDatoException {

		zona = Objects.toString(zona, "");

		VerificaDato verificaDato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerificaDato[] array = new VerificaDatoImpl[3];

			array[0] = getByGiornoZonaEvento_PrevAndNext(
				session, verificaDato, giorno, zona, evento, orderByComparator,
				true);

			array[1] = verificaDato;

			array[2] = getByGiornoZonaEvento_PrevAndNext(
				session, verificaDato, giorno, zona, evento, orderByComparator,
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

	protected VerificaDato getByGiornoZonaEvento_PrevAndNext(
		Session session, VerificaDato verificaDato, Date giorno, String zona,
		long evento, OrderByComparator<VerificaDato> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_VERIFICADATO_WHERE);

		boolean bindGiorno = false;

		if (giorno == null) {
			sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1);
		}
		else {
			bindGiorno = true;

			sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2);
		}

		boolean bindZona = false;

		if (zona.isEmpty()) {
			sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3);
		}
		else {
			bindZona = true;

			sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2);
		}

		sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2);

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
			sb.append(VerificaDatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGiorno) {
			queryPos.add(new Timestamp(giorno.getTime()));
		}

		if (bindZona) {
			queryPos.add(zona);
		}

		queryPos.add(evento);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(verificaDato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerificaDato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verifica datos where giorno = &#63; and zona = &#63; and evento = &#63; from the database.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 */
	@Override
	public void removeByGiornoZonaEvento(
		Date giorno, String zona, long evento) {

		for (VerificaDato verificaDato :
				findByGiornoZonaEvento(
					giorno, zona, evento, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos where giorno = &#63; and zona = &#63; and evento = &#63;.
	 *
	 * @param giorno the giorno
	 * @param zona the zona
	 * @param evento the evento
	 * @return the number of matching verifica datos
	 */
	@Override
	public int countByGiornoZonaEvento(Date giorno, String zona, long evento) {
		zona = Objects.toString(zona, "");

		FinderPath finderPath = _finderPathCountByGiornoZonaEvento;

		Object[] finderArgs = new Object[] {_getTime(giorno), zona, evento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_VERIFICADATO_WHERE);

			boolean bindGiorno = false;

			if (giorno == null) {
				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1);
			}
			else {
				bindGiorno = true;

				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2);
			}

			boolean bindZona = false;

			if (zona.isEmpty()) {
				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3);
			}
			else {
				bindZona = true;

				sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2);
			}

			sb.append(_FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGiorno) {
					queryPos.add(new Timestamp(giorno.getTime()));
				}

				if (bindZona) {
					queryPos.add(zona);
				}

				queryPos.add(evento);

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

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_1 =
		"verificaDato.giorno IS NULL AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_GIORNO_2 =
		"verificaDato.giorno = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_2 =
		"verificaDato.zona = ? AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_ZONA_3 =
		"(verificaDato.zona IS NULL OR verificaDato.zona = '') AND ";

	private static final String _FINDER_COLUMN_GIORNOZONAEVENTO_EVENTO_2 =
		"verificaDato.evento = ?";

	public VerificaDatoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(VerificaDato.class);

		setModelImplClass(VerificaDatoImpl.class);
		setModelPKClass(long.class);

		setTable(VerificaDatoTable.INSTANCE);
	}

	/**
	 * Caches the verifica dato in the entity cache if it is enabled.
	 *
	 * @param verificaDato the verifica dato
	 */
	@Override
	public void cacheResult(VerificaDato verificaDato) {
		entityCache.putResult(
			VerificaDatoImpl.class, verificaDato.getPrimaryKey(), verificaDato);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the verifica datos in the entity cache if it is enabled.
	 *
	 * @param verificaDatos the verifica datos
	 */
	@Override
	public void cacheResult(List<VerificaDato> verificaDatos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (verificaDatos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VerificaDato verificaDato : verificaDatos) {
			if (entityCache.getResult(
					VerificaDatoImpl.class, verificaDato.getPrimaryKey()) ==
						null) {

				cacheResult(verificaDato);
			}
		}
	}

	/**
	 * Clears the cache for all verifica datos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VerificaDatoImpl.class);

		finderCache.clearCache(VerificaDatoImpl.class);
	}

	/**
	 * Clears the cache for the verifica dato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VerificaDato verificaDato) {
		entityCache.removeResult(VerificaDatoImpl.class, verificaDato);
	}

	@Override
	public void clearCache(List<VerificaDato> verificaDatos) {
		for (VerificaDato verificaDato : verificaDatos) {
			entityCache.removeResult(VerificaDatoImpl.class, verificaDato);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VerificaDatoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VerificaDatoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new verifica dato with the primary key. Does not add the verifica dato to the database.
	 *
	 * @param id the primary key for the new verifica dato
	 * @return the new verifica dato
	 */
	@Override
	public VerificaDato create(long id) {
		VerificaDato verificaDato = new VerificaDatoImpl();

		verificaDato.setNew(true);
		verificaDato.setPrimaryKey(id);

		return verificaDato;
	}

	/**
	 * Removes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato remove(long id) throws NoSuchVerificaDatoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the verifica dato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the verifica dato
	 * @return the verifica dato that was removed
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato remove(Serializable primaryKey)
		throws NoSuchVerificaDatoException {

		Session session = null;

		try {
			session = openSession();

			VerificaDato verificaDato = (VerificaDato)session.get(
				VerificaDatoImpl.class, primaryKey);

			if (verificaDato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVerificaDatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(verificaDato);
		}
		catch (NoSuchVerificaDatoException noSuchEntityException) {
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
	protected VerificaDato removeImpl(VerificaDato verificaDato) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(verificaDato)) {
				verificaDato = (VerificaDato)session.get(
					VerificaDatoImpl.class, verificaDato.getPrimaryKeyObj());
			}

			if (verificaDato != null) {
				session.delete(verificaDato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (verificaDato != null) {
			clearCache(verificaDato);
		}

		return verificaDato;
	}

	@Override
	public VerificaDato updateImpl(VerificaDato verificaDato) {
		boolean isNew = verificaDato.isNew();

		if (!(verificaDato instanceof VerificaDatoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(verificaDato.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					verificaDato);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in verificaDato proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VerificaDato implementation " +
					verificaDato.getClass());
		}

		VerificaDatoModelImpl verificaDatoModelImpl =
			(VerificaDatoModelImpl)verificaDato;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(verificaDato);
			}
			else {
				verificaDato = (VerificaDato)session.merge(verificaDato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VerificaDatoImpl.class, verificaDatoModelImpl, false, true);

		if (isNew) {
			verificaDato.setNew(false);
		}

		verificaDato.resetOriginalValues();

		return verificaDato;
	}

	/**
	 * Returns the verifica dato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVerificaDatoException {

		VerificaDato verificaDato = fetchByPrimaryKey(primaryKey);

		if (verificaDato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVerificaDatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return verificaDato;
	}

	/**
	 * Returns the verifica dato with the primary key or throws a <code>NoSuchVerificaDatoException</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato
	 * @throws NoSuchVerificaDatoException if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato findByPrimaryKey(long id)
		throws NoSuchVerificaDatoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the verifica dato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verifica dato
	 * @return the verifica dato, or <code>null</code> if a verifica dato with the primary key could not be found
	 */
	@Override
	public VerificaDato fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the verifica datos.
	 *
	 * @return the verifica datos
	 */
	@Override
	public List<VerificaDato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @return the range of verifica datos
	 */
	@Override
	public List<VerificaDato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verifica datos
	 */
	@Override
	public List<VerificaDato> findAll(
		int start, int end, OrderByComparator<VerificaDato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verifica datos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificaDatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verifica datos
	 * @param end the upper bound of the range of verifica datos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verifica datos
	 */
	@Override
	public List<VerificaDato> findAll(
		int start, int end, OrderByComparator<VerificaDato> orderByComparator,
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

		List<VerificaDato> list = null;

		if (useFinderCache) {
			list = (List<VerificaDato>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VERIFICADATO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VERIFICADATO;

				sql = sql.concat(VerificaDatoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VerificaDato>)QueryUtil.list(
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
	 * Removes all the verifica datos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VerificaDato verificaDato : findAll()) {
			remove(verificaDato);
		}
	}

	/**
	 * Returns the number of verifica datos.
	 *
	 * @return the number of verifica datos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VERIFICADATO);

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
		return _SQL_SELECT_VERIFICADATO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VerificaDatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the verifica dato persistence.
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

		_finderPathWithPaginationFindByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumento",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documento"}, true);

		_finderPathWithoutPaginationFindByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumento",
			new String[] {Long.class.getName()}, new String[] {"documento"},
			true);

		_finderPathCountByDocumento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumento",
			new String[] {Long.class.getName()}, new String[] {"documento"},
			false);

		_finderPathWithPaginationFindByDocumentoGiorno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentoGiorno",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"documento", "giorno"}, true);

		_finderPathWithoutPaginationFindByDocumentoGiorno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentoGiorno",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"documento", "giorno"}, true);

		_finderPathCountByDocumentoGiorno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentoGiorno",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"documento", "giorno"}, false);

		_finderPathWithPaginationFindByDocumentoGiornoEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDocumentoGiornoEvento",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documento", "giorno", "evento"}, true);

		_finderPathWithoutPaginationFindByDocumentoGiornoEvento =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDocumentoGiornoEvento",
				new String[] {
					Long.class.getName(), Date.class.getName(),
					Long.class.getName()
				},
				new String[] {"documento", "giorno", "evento"}, true);

		_finderPathCountByDocumentoGiornoEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoGiornoEvento",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName()
			},
			new String[] {"documento", "giorno", "evento"}, false);

		_finderPathWithPaginationFindByDocumentoGiornoZona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentoGiornoZona",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documento", "giorno", "zona"}, true);

		_finderPathWithoutPaginationFindByDocumentoGiornoZona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDocumentoGiornoZona",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName()
			},
			new String[] {"documento", "giorno", "zona"}, true);

		_finderPathCountByDocumentoGiornoZona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoGiornoZona",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName()
			},
			new String[] {"documento", "giorno", "zona"}, false);

		_finderPathWithPaginationFindByDocumentoGiornoZonaEvento =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDocumentoGiornoZonaEvento",
				new String[] {
					Long.class.getName(), Date.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"documento", "giorno", "zona", "evento"}, true);

		_finderPathWithoutPaginationFindByDocumentoGiornoZonaEvento =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDocumentoGiornoZonaEvento",
				new String[] {
					Long.class.getName(), Date.class.getName(),
					String.class.getName(), Long.class.getName()
				},
				new String[] {"documento", "giorno", "zona", "evento"}, true);

		_finderPathCountByDocumentoGiornoZonaEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoGiornoZonaEvento",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {"documento", "giorno", "zona", "evento"}, false);

		_finderPathWithPaginationFindByGiorno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiorno",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"giorno"}, true);

		_finderPathWithoutPaginationFindByGiorno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiorno",
			new String[] {Date.class.getName()}, new String[] {"giorno"}, true);

		_finderPathCountByGiorno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiorno",
			new String[] {Date.class.getName()}, new String[] {"giorno"},
			false);

		_finderPathWithPaginationFindByGiornoZona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiornoZona",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"giorno", "zona"}, true);

		_finderPathWithoutPaginationFindByGiornoZona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiornoZona",
			new String[] {Date.class.getName(), String.class.getName()},
			new String[] {"giorno", "zona"}, true);

		_finderPathCountByGiornoZona = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiornoZona",
			new String[] {Date.class.getName(), String.class.getName()},
			new String[] {"giorno", "zona"}, false);

		_finderPathWithPaginationFindByGiornoEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiornoEvento",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"giorno", "evento"}, true);

		_finderPathWithoutPaginationFindByGiornoEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiornoEvento",
			new String[] {Date.class.getName(), Long.class.getName()},
			new String[] {"giorno", "evento"}, true);

		_finderPathCountByGiornoEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGiornoEvento",
			new String[] {Date.class.getName(), Long.class.getName()},
			new String[] {"giorno", "evento"}, false);

		_finderPathWithPaginationFindByGiornoZonaEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGiornoZonaEvento",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"giorno", "zona", "evento"}, true);

		_finderPathWithoutPaginationFindByGiornoZonaEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGiornoZonaEvento",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"giorno", "zona", "evento"}, true);

		_finderPathCountByGiornoZonaEvento = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGiornoZonaEvento",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"giorno", "zona", "evento"}, false);

		VerificaDatoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		VerificaDatoUtil.setPersistence(null);

		entityCache.removeCache(VerificaDatoImpl.class.getName());
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = VERIFICAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_VERIFICADATO =
		"SELECT verificaDato FROM VerificaDato verificaDato";

	private static final String _SQL_SELECT_VERIFICADATO_WHERE =
		"SELECT verificaDato FROM VerificaDato verificaDato WHERE ";

	private static final String _SQL_COUNT_VERIFICADATO =
		"SELECT COUNT(verificaDato) FROM VerificaDato verificaDato";

	private static final String _SQL_COUNT_VERIFICADATO_WHERE =
		"SELECT COUNT(verificaDato) FROM VerificaDato verificaDato WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "verificaDato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VerificaDato exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VerificaDato exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VerificaDatoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}