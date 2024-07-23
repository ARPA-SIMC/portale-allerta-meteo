/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package allerta.catasto.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.exception.NoSuchSegnalazioneException;
import allerta.catasto.model.Segnalazione;
import allerta.catasto.model.impl.SegnalazioneImpl;
import allerta.catasto.model.impl.SegnalazioneModelImpl;
import allerta.catasto.service.persistence.SegnalazionePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
@ProviderType
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentoAssociato the documento associato
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching segnalaziones
	 */
	@Override
	public List<Segnalazione> findByDocumentoAssociato(
		long documentoAssociato, int start, int end,
		OrderByComparator<Segnalazione> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDocumentoAssociato;
			finderArgs = new Object[] {documentoAssociato};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDocumentoAssociato;
			finderArgs = new Object[] {
				documentoAssociato, start, end, orderByComparator
			};
		}

		List<Segnalazione> list = null;

		if (retrieveFromCache) {
			list = (List<Segnalazione>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segnalazione segnalazione : list) {
					if ((documentoAssociato !=
							segnalazione.getDocumentoAssociato())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEGNALAZIONE_WHERE);

			query.append(
				_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SegnalazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentoAssociato);

				if (!pagination) {
					list = (List<Segnalazione>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Segnalazione>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
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

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documentoAssociato=");
		msg.append(documentoAssociato);

		msg.append("}");

		throw new NoSuchSegnalazioneException(msg.toString());
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

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documentoAssociato=");
		msg.append(documentoAssociato);

		msg.append("}");

		throw new NoSuchSegnalazioneException(msg.toString());
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
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segnalazione getByDocumentoAssociato_PrevAndNext(
		Session session, Segnalazione segnalazione, long documentoAssociato,
		OrderByComparator<Segnalazione> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEGNALAZIONE_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SegnalazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documentoAssociato);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segnalazione)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Segnalazione> list = q.list();

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
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEGNALAZIONE_WHERE);

			query.append(
				_FINDER_COLUMN_DOCUMENTOASSOCIATO_DOCUMENTOASSOCIATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentoAssociato);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
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
		setModelClass(Segnalazione.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the segnalazione in the entity cache if it is enabled.
	 *
	 * @param segnalazione the segnalazione
	 */
	@Override
	public void cacheResult(Segnalazione segnalazione) {
		entityCache.putResult(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED, SegnalazioneImpl.class,
			segnalazione.getPrimaryKey(), segnalazione);

		segnalazione.resetOriginalValues();
	}

	/**
	 * Caches the segnalaziones in the entity cache if it is enabled.
	 *
	 * @param segnalaziones the segnalaziones
	 */
	@Override
	public void cacheResult(List<Segnalazione> segnalaziones) {
		for (Segnalazione segnalazione : segnalaziones) {
			if (entityCache.getResult(
					SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
					SegnalazioneImpl.class, segnalazione.getPrimaryKey()) ==
						null) {

				cacheResult(segnalazione);
			}
			else {
				segnalazione.resetOriginalValues();
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

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
		entityCache.removeResult(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED, SegnalazioneImpl.class,
			segnalazione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segnalazione> segnalaziones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segnalazione segnalazione : segnalaziones) {
			entityCache.removeResult(
				SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
				SegnalazioneImpl.class, segnalazione.getPrimaryKey());
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

		segnalazione.setCompanyId(companyProvider.getCompanyId());

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
		catch (NoSuchSegnalazioneException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
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
		catch (Exception e) {
			throw processException(e);
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

		Date now = new Date();

		if (isNew && (segnalazione.getCreateDate() == null)) {
			if (serviceContext == null) {
				segnalazione.setCreateDate(now);
			}
			else {
				segnalazione.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!segnalazioneModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				segnalazione.setModifiedDate(now);
			}
			else {
				segnalazione.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (segnalazione.isNew()) {
				session.save(segnalazione);

				segnalazione.setNew(false);
			}
			else {
				segnalazione = (Segnalazione)session.merge(segnalazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SegnalazioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				segnalazioneModelImpl.getDocumentoAssociato()
			};

			finderCache.removeResult(
				_finderPathCountByDocumentoAssociato, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentoAssociato, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((segnalazioneModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentoAssociato.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					segnalazioneModelImpl.getOriginalDocumentoAssociato()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoAssociato, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoAssociato, args);

				args = new Object[] {
					segnalazioneModelImpl.getDocumentoAssociato()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentoAssociato, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentoAssociato, args);
			}
		}

		entityCache.putResult(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED, SegnalazioneImpl.class,
			segnalazione.getPrimaryKey(), segnalazione, false);

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
	 * @param primaryKey the primary key of the segnalazione
	 * @return the segnalazione, or <code>null</code> if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED, SegnalazioneImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Segnalazione segnalazione = (Segnalazione)serializable;

		if (segnalazione == null) {
			Session session = null;

			try {
				session = openSession();

				segnalazione = (Segnalazione)session.get(
					SegnalazioneImpl.class, primaryKey);

				if (segnalazione != null) {
					cacheResult(segnalazione);
				}
				else {
					entityCache.putResult(
						SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
						SegnalazioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
					SegnalazioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return segnalazione;
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

	@Override
	public Map<Serializable, Segnalazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Segnalazione> map =
			new HashMap<Serializable, Segnalazione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Segnalazione segnalazione = fetchByPrimaryKey(primaryKey);

			if (segnalazione != null) {
				map.put(primaryKey, segnalazione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
				SegnalazioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Segnalazione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_SEGNALAZIONE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Segnalazione segnalazione : (List<Segnalazione>)q.list()) {
				map.put(segnalazione.getPrimaryKeyObj(), segnalazione);

				cacheResult(segnalazione);

				uncachedPrimaryKeys.remove(segnalazione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
					SegnalazioneImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegnalazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(
		int start, int end, OrderByComparator<Segnalazione> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Segnalazione> list = null;

		if (retrieveFromCache) {
			list = (List<Segnalazione>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEGNALAZIONE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEGNALAZIONE;

				if (pagination) {
					sql = sql.concat(SegnalazioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Segnalazione>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Segnalazione>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
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

				Query q = session.createQuery(_SQL_COUNT_SEGNALAZIONE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return SegnalazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the segnalazione persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, SegnalazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, SegnalazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDocumentoAssociato = new FinderPath(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, SegnalazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumentoAssociato = new FinderPath(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, SegnalazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDocumentoAssociato", new String[] {Long.class.getName()},
			SegnalazioneModelImpl.DOCUMENTOASSOCIATO_COLUMN_BITMASK);

		_finderPathCountByDocumentoAssociato = new FinderPath(
			SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentoAssociato", new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(SegnalazioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SEGNALAZIONE =
		"SELECT segnalazione FROM Segnalazione segnalazione";

	private static final String _SQL_SELECT_SEGNALAZIONE_WHERE_PKS_IN =
		"SELECT segnalazione FROM Segnalazione segnalazione WHERE id_ IN (";

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

}