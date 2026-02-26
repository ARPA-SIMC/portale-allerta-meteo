/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.impl;

import allerta.catasto.exception.NoSuchSegnalazioneException;
import allerta.catasto.model.Segnalazione;
import allerta.catasto.model.SegnalazioneTable;
import allerta.catasto.model.impl.SegnalazioneImpl;
import allerta.catasto.model.impl.SegnalazioneModelImpl;
import allerta.catasto.service.persistence.SegnalazionePersistence;
import allerta.catasto.service.persistence.SegnalazioneUtil;
import allerta.catasto.service.persistence.impl.constants.CATASTOPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the segnalazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SegnalazionePersistence.class)
public class SegnalazionePersistenceImpl
	extends BasePersistenceImpl<Segnalazione>
	implements SegnalazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SegnalazioneUtil</code> to access the segnalazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SegnalazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocumentoAssociato;
	private FinderPath _finderPathWithoutPaginationFindByDocumentoAssociato;
	private FinderPath _finderPathCountByDocumentoAssociato;

	/**
	 * Returns all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @return the matching segnalaziones
	 */
	@Override
	public List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato) {

		return findByDocumentoAssociato(
			documentoAssociato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of matching segnalaziones
	 */
	@Override
	public List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end) {

		return findByDocumentoAssociato(documentoAssociato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segnalaziones
	 */
	@Override
	public List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		OrderByComparator<Segnalazione> orderByComparator) {

		return findByDocumentoAssociato(
			documentoAssociato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segnalaziones where documentoAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segnalaziones
	 */
	@Override
	public List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		OrderByComparator<Segnalazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDocumentoAssociato;
				finderArgs = new Object[] {documentoAssociato};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentoAssociato;
			finderArgs = new Object[] {
				documentoAssociato, start, end, orderByComparator
			};
		}

		List<Segnalazione> list = null;

		if (useFinderCache) {
			list = (List<Segnalazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segnalazione segnalazione : list) {
					if (documentoAssociato !=
							segnalazione.getDocumentoAssociato()) {

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

			sb.append(_SQL_SELECT_SEGNALAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegnalazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentoAssociato);

				list = (List<Segnalazione>)QueryUtil.list(
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
	 * Returns the first segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segnalazione
	 * @throws NoSuchSegnalazioneException if a matching segnalazione could not be found
	 */
	@Override
	public Segnalazione findByDocumentoAssociato_First(
			long documentoAssociato,
			OrderByComparator<Segnalazione> orderByComparator)
		throws NoSuchSegnalazioneException {

		Segnalazione segnalazione = fetchByDocumentoAssociato_First(
			documentoAssociato, orderByComparator);

		if (segnalazione != null) {
			return segnalazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentoAssociato=");
		sb.append(documentoAssociato);

		sb.append("}");

		throw new NoSuchSegnalazioneException(sb.toString());
	}

	/**
	 * Returns the first segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segnalazione, or <code>null</code> if a matching segnalazione could not be found
	 */
	@Override
	public Segnalazione fetchByDocumentoAssociato_First(
		long documentoAssociato,
		OrderByComparator<Segnalazione> orderByComparator) {

		List<Segnalazione> list = findByDocumentoAssociato(
			documentoAssociato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segnalazione
	 * @throws NoSuchSegnalazioneException if a matching segnalazione could not be found
	 */
	@Override
	public Segnalazione findByDocumentoAssociato_Last(
			long documentoAssociato,
			OrderByComparator<Segnalazione> orderByComparator)
		throws NoSuchSegnalazioneException {

		Segnalazione segnalazione = fetchByDocumentoAssociato_Last(
			documentoAssociato, orderByComparator);

		if (segnalazione != null) {
			return segnalazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentoAssociato=");
		sb.append(documentoAssociato);

		sb.append("}");

		throw new NoSuchSegnalazioneException(sb.toString());
	}

	/**
	 * Returns the last segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segnalazione, or <code>null</code> if a matching segnalazione could not be found
	 */
	@Override
	public Segnalazione fetchByDocumentoAssociato_Last(
		long documentoAssociato,
		OrderByComparator<Segnalazione> orderByComparator) {

		int count = countByDocumentoAssociato(documentoAssociato);

		if (count == 0) {
			return null;
		}

		List<Segnalazione> list = findByDocumentoAssociato(
			documentoAssociato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segnalaziones before and after the current segnalazione in the ordered set where documentoAssociato = &#63;.
	 *
	 * @param id the primary key of the current segnalazione
	 * @param documentoAssociato the documento associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione[] findByDocumentoAssociato_PrevAndNext(
			long id, long documentoAssociato,
			OrderByComparator<Segnalazione> orderByComparator)
		throws NoSuchSegnalazioneException {

		Segnalazione segnalazione = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Segnalazione[] array = new SegnalazioneImpl[3];

			array[0] = getByDocumentoAssociato_PrevAndNext(
				session, segnalazione, documentoAssociato, orderByComparator,
				true);

			array[1] = segnalazione;

			array[2] = getByDocumentoAssociato_PrevAndNext(
				session, segnalazione, documentoAssociato, orderByComparator,
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

	protected Segnalazione getByDocumentoAssociato_PrevAndNext(
		Session session, Segnalazione segnalazione, long documentoAssociato,
		OrderByComparator<Segnalazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGNALAZIONE_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2);

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
			sb.append(SegnalazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documentoAssociato);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segnalazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segnalazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segnalaziones where documentoAssociato = &#63; from the database.
	 *
	 * @param documentoAssociato the documento associato
	 */
	@Override
	public void removeByDocumentoAssociato(long documentoAssociato) {
		for (Segnalazione segnalazione :
				findByDocumentoAssociato(
					documentoAssociato, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(segnalazione);
		}
	}

	/**
	 * Returns the number of segnalaziones where documentoAssociato = &#63;.
	 *
	 * @param documentoAssociato the documento associato
	 * @return the number of matching segnalaziones
	 */
	@Override
	public int countByDocumentoAssociato(long documentoAssociato) {
		FinderPath finderPath = _finderPathCountByDocumentoAssociato;

		Object[] finderArgs = new Object[] {documentoAssociato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGNALAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentoAssociato);

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
		_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2 =
			"segnalazione.documentoAssociato = ?";

	public SegnalazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Segnalazione.class);

		setModelImplClass(SegnalazioneImpl.class);
		setModelPKClass(long.class);

		setTable(SegnalazioneTable.INSTANCE);
	}

	/**
	 * Caches the segnalazione in the entity cache if it is enabled.
	 *
	 * @param segnalazione the segnalazione
	 */
	@Override
	public void cacheResult(Segnalazione segnalazione) {
		entityCache.putResult(
			SegnalazioneImpl.class, segnalazione.getPrimaryKey(), segnalazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the segnalaziones in the entity cache if it is enabled.
	 *
	 * @param segnalaziones the segnalaziones
	 */
	@Override
	public void cacheResult(List<Segnalazione> segnalaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (segnalaziones.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Segnalazione segnalazione : segnalaziones) {
			if (entityCache.getResult(
					SegnalazioneImpl.class, segnalazione.getPrimaryKey()) ==
						null) {

				cacheResult(segnalazione);
			}
		}
	}

	/**
	 * Clears the cache for all segnalaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SegnalazioneImpl.class);

		finderCache.clearCache(SegnalazioneImpl.class);
	}

	/**
	 * Clears the cache for the segnalazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segnalazione segnalazione) {
		entityCache.removeResult(SegnalazioneImpl.class, segnalazione);
	}

	@Override
	public void clearCache(List<Segnalazione> segnalaziones) {
		for (Segnalazione segnalazione : segnalaziones) {
			entityCache.removeResult(SegnalazioneImpl.class, segnalazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SegnalazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SegnalazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	 *
	 * @param id the primary key for the new segnalazione
	 * @return the new segnalazione
	 */
	@Override
	public Segnalazione create(long id) {
		Segnalazione segnalazione = new SegnalazioneImpl();

		segnalazione.setNew(true);
		segnalazione.setPrimaryKey(id);

		segnalazione.setCompanyId(CompanyThreadLocal.getCompanyId());

		return segnalazione;
	}

	/**
	 * Removes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione remove(long id) throws NoSuchSegnalazioneException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione remove(Serializable primaryKey)
		throws NoSuchSegnalazioneException {

		Session session = null;

		try {
			session = openSession();

			Segnalazione segnalazione = (Segnalazione)session.get(
				SegnalazioneImpl.class, primaryKey);

			if (segnalazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegnalazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(segnalazione);
		}
		catch (NoSuchSegnalazioneException noSuchEntityException) {
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
	protected Segnalazione removeImpl(Segnalazione segnalazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segnalazione)) {
				segnalazione = (Segnalazione)session.get(
					SegnalazioneImpl.class, segnalazione.getPrimaryKeyObj());
			}

			if (segnalazione != null) {
				session.delete(segnalazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (segnalazione != null) {
			clearCache(segnalazione);
		}

		return segnalazione;
	}

	@Override
	public Segnalazione updateImpl(Segnalazione segnalazione) {
		boolean isNew = segnalazione.isNew();

		if (!(segnalazione instanceof SegnalazioneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(segnalazione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					segnalazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in segnalazione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Segnalazione implementation " +
					segnalazione.getClass());
		}

		SegnalazioneModelImpl segnalazioneModelImpl =
			(SegnalazioneModelImpl)segnalazione;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (segnalazione.getCreateDate() == null)) {
			if (serviceContext == null) {
				segnalazione.setCreateDate(date);
			}
			else {
				segnalazione.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!segnalazioneModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				segnalazione.setModifiedDate(date);
			}
			else {
				segnalazione.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(segnalazione);
			}
			else {
				segnalazione = (Segnalazione)session.merge(segnalazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SegnalazioneImpl.class, segnalazioneModelImpl, false, true);

		if (isNew) {
			segnalazione.setNew(false);
		}

		segnalazione.resetOriginalValues();

		return segnalazione;
	}

	/**
	 * Returns the segnalazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegnalazioneException {

		Segnalazione segnalazione = fetchByPrimaryKey(primaryKey);

		if (segnalazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegnalazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return segnalazione;
	}

	/**
	 * Returns the segnalazione with the primary key or throws a <code>NoSuchSegnalazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione findByPrimaryKey(long id)
		throws NoSuchSegnalazioneException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the segnalazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the segnalazione
	 * @return the segnalazione, or <code>null</code> if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the segnalaziones.
	 *
	 * @return the segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(
		int start, int end, OrderByComparator<Segnalazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(
		int start, int end, OrderByComparator<Segnalazione> orderByComparator,
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

		List<Segnalazione> list = null;

		if (useFinderCache) {
			list = (List<Segnalazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SEGNALAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SEGNALAZIONE;

				sql = sql.concat(SegnalazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Segnalazione>)QueryUtil.list(
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
	 * Removes all the segnalaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Segnalazione segnalazione : findAll()) {
			remove(segnalazione);
		}
	}

	/**
	 * Returns the number of segnalaziones.
	 *
	 * @return the number of segnalaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SEGNALAZIONE);

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
		return _SQL_SELECT_SEGNALAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SegnalazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the segnalazione persistence.
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

		_finderPathWithPaginationFindByDocumentoAssociato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documentoAssociato"}, true);

		_finderPathWithoutPaginationFindByDocumentoAssociato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDocumentoAssociato", new String[] {Long.class.getName()},
			new String[] {"documentoAssociato"}, true);

		_finderPathCountByDocumentoAssociato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoAssociato", new String[] {Long.class.getName()},
			new String[] {"documentoAssociato"}, false);

		SegnalazioneUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SegnalazioneUtil.setPersistence(null);

		entityCache.removeCache(SegnalazioneImpl.class.getName());
	}

	@Override
	@Reference(
		target = CATASTOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CATASTOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CATASTOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SEGNALAZIONE =
		"SELECT segnalazione FROM Segnalazione segnalazione";

	private static final String _SQL_SELECT_SEGNALAZIONE_WHERE =
		"SELECT segnalazione FROM Segnalazione segnalazione WHERE ";

	private static final String _SQL_COUNT_SEGNALAZIONE =
		"SELECT COUNT(segnalazione) FROM Segnalazione segnalazione";

	private static final String _SQL_COUNT_SEGNALAZIONE_WHERE =
		"SELECT COUNT(segnalazione) FROM Segnalazione segnalazione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "segnalazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Segnalazione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Segnalazione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SegnalazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}