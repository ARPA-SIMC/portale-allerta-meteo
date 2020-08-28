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

package it.eng.parer.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.parer.exception.NoSuchDocumentiCollegatiException;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.model.impl.DocumentiCollegatiImpl;
import it.eng.parer.model.impl.DocumentiCollegatiModelImpl;
import it.eng.parer.service.persistence.DocumentiCollegatiPK;
import it.eng.parer.service.persistence.DocumentiCollegatiPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the documenti collegati service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class DocumentiCollegatiPersistenceImpl
	extends BasePersistenceImpl<DocumentiCollegati>
	implements DocumentiCollegatiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentiCollegatiUtil</code> to access the documenti collegati persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentiCollegatiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByDocumentiCollegatiByIdInvio;
	private FinderPath
		_finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio;
	private FinderPath _finderPathCountByDocumentiCollegatiByIdInvio;

	/**
	 * Returns all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the matching documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO) {

		return findByDocumentiCollegatiByIdInvio(
			ID_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of matching documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end) {

		return findByDocumentiCollegatiByIdInvio(ID_INVIO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return findByDocumentiCollegatiByIdInvio(
			ID_INVIO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio;
			finderArgs = new Object[] {ID_INVIO};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByDocumentiCollegatiByIdInvio;
			finderArgs = new Object[] {ID_INVIO, start, end, orderByComparator};
		}

		List<DocumentiCollegati> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentiCollegati>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentiCollegati documentiCollegati : list) {
					if ((ID_INVIO != documentiCollegati.getID_INVIO())) {
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

			query.append(_SQL_SELECT_DOCUMENTICOLLEGATI_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTICOLLEGATIBYIDINVIO_ID_INVIO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DocumentiCollegatiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ID_INVIO);

				if (!pagination) {
					list = (List<DocumentiCollegati>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentiCollegati>)QueryUtil.list(
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
	 * Returns the first documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a matching documenti collegati could not be found
	 */
	@Override
	public DocumentiCollegati findByDocumentiCollegatiByIdInvio_First(
			long ID_INVIO,
			OrderByComparator<DocumentiCollegati> orderByComparator)
		throws NoSuchDocumentiCollegatiException {

		DocumentiCollegati documentiCollegati =
			fetchByDocumentiCollegatiByIdInvio_First(
				ID_INVIO, orderByComparator);

		if (documentiCollegati != null) {
			return documentiCollegati;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ID_INVIO=");
		msg.append(ID_INVIO);

		msg.append("}");

		throw new NoSuchDocumentiCollegatiException(msg.toString());
	}

	/**
	 * Returns the first documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documenti collegati, or <code>null</code> if a matching documenti collegati could not be found
	 */
	@Override
	public DocumentiCollegati fetchByDocumentiCollegatiByIdInvio_First(
		long ID_INVIO,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		List<DocumentiCollegati> list = findByDocumentiCollegatiByIdInvio(
			ID_INVIO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a matching documenti collegati could not be found
	 */
	@Override
	public DocumentiCollegati findByDocumentiCollegatiByIdInvio_Last(
			long ID_INVIO,
			OrderByComparator<DocumentiCollegati> orderByComparator)
		throws NoSuchDocumentiCollegatiException {

		DocumentiCollegati documentiCollegati =
			fetchByDocumentiCollegatiByIdInvio_Last(
				ID_INVIO, orderByComparator);

		if (documentiCollegati != null) {
			return documentiCollegati;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ID_INVIO=");
		msg.append(ID_INVIO);

		msg.append("}");

		throw new NoSuchDocumentiCollegatiException(msg.toString());
	}

	/**
	 * Returns the last documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documenti collegati, or <code>null</code> if a matching documenti collegati could not be found
	 */
	@Override
	public DocumentiCollegati fetchByDocumentiCollegatiByIdInvio_Last(
		long ID_INVIO,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		int count = countByDocumentiCollegatiByIdInvio(ID_INVIO);

		if (count == 0) {
			return null;
		}

		List<DocumentiCollegati> list = findByDocumentiCollegatiByIdInvio(
			ID_INVIO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the documenti collegatis before and after the current documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param documentiCollegatiPK the primary key of the current documenti collegati
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati[] findByDocumentiCollegatiByIdInvio_PrevAndNext(
			DocumentiCollegatiPK documentiCollegatiPK, long ID_INVIO,
			OrderByComparator<DocumentiCollegati> orderByComparator)
		throws NoSuchDocumentiCollegatiException {

		DocumentiCollegati documentiCollegati = findByPrimaryKey(
			documentiCollegatiPK);

		Session session = null;

		try {
			session = openSession();

			DocumentiCollegati[] array = new DocumentiCollegatiImpl[3];

			array[0] = getByDocumentiCollegatiByIdInvio_PrevAndNext(
				session, documentiCollegati, ID_INVIO, orderByComparator, true);

			array[1] = documentiCollegati;

			array[2] = getByDocumentiCollegatiByIdInvio_PrevAndNext(
				session, documentiCollegati, ID_INVIO, orderByComparator,
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

	protected DocumentiCollegati getByDocumentiCollegatiByIdInvio_PrevAndNext(
		Session session, DocumentiCollegati documentiCollegati, long ID_INVIO,
		OrderByComparator<DocumentiCollegati> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENTICOLLEGATI_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTICOLLEGATIBYIDINVIO_ID_INVIO_2);

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
			query.append(DocumentiCollegatiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ID_INVIO);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						documentiCollegati)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DocumentiCollegati> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documenti collegatis where ID_INVIO = &#63; from the database.
	 *
	 * @param ID_INVIO the id_invio
	 */
	@Override
	public void removeByDocumentiCollegatiByIdInvio(long ID_INVIO) {
		for (DocumentiCollegati documentiCollegati :
				findByDocumentiCollegatiByIdInvio(
					ID_INVIO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentiCollegati);
		}
	}

	/**
	 * Returns the number of documenti collegatis where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the number of matching documenti collegatis
	 */
	@Override
	public int countByDocumentiCollegatiByIdInvio(long ID_INVIO) {
		FinderPath finderPath = _finderPathCountByDocumentiCollegatiByIdInvio;

		Object[] finderArgs = new Object[] {ID_INVIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTICOLLEGATI_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTICOLLEGATIBYIDINVIO_ID_INVIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ID_INVIO);

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
		_FINDER_COLUMN_DOCUMENTICOLLEGATIBYIDINVIO_ID_INVIO_2 =
			"documentiCollegati.id.ID_INVIO = ?";

	public DocumentiCollegatiPersistenceImpl() {
		setModelClass(DocumentiCollegati.class);
	}

	/**
	 * Caches the documenti collegati in the entity cache if it is enabled.
	 *
	 * @param documentiCollegati the documenti collegati
	 */
	@Override
	public void cacheResult(DocumentiCollegati documentiCollegati) {
		entityCache.putResult(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiImpl.class, documentiCollegati.getPrimaryKey(),
			documentiCollegati);

		documentiCollegati.resetOriginalValues();
	}

	/**
	 * Caches the documenti collegatis in the entity cache if it is enabled.
	 *
	 * @param documentiCollegatis the documenti collegatis
	 */
	@Override
	public void cacheResult(List<DocumentiCollegati> documentiCollegatis) {
		for (DocumentiCollegati documentiCollegati : documentiCollegatis) {
			if (entityCache.getResult(
					DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
					DocumentiCollegatiImpl.class,
					documentiCollegati.getPrimaryKey()) == null) {

				cacheResult(documentiCollegati);
			}
			else {
				documentiCollegati.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all documenti collegatis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentiCollegatiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the documenti collegati.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentiCollegati documentiCollegati) {
		entityCache.removeResult(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiImpl.class, documentiCollegati.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DocumentiCollegati> documentiCollegatis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentiCollegati documentiCollegati : documentiCollegatis) {
			entityCache.removeResult(
				DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
				DocumentiCollegatiImpl.class,
				documentiCollegati.getPrimaryKey());
		}
	}

	/**
	 * Creates a new documenti collegati with the primary key. Does not add the documenti collegati to the database.
	 *
	 * @param documentiCollegatiPK the primary key for the new documenti collegati
	 * @return the new documenti collegati
	 */
	@Override
	public DocumentiCollegati create(
		DocumentiCollegatiPK documentiCollegatiPK) {

		DocumentiCollegati documentiCollegati = new DocumentiCollegatiImpl();

		documentiCollegati.setNew(true);
		documentiCollegati.setPrimaryKey(documentiCollegatiPK);

		return documentiCollegati;
	}

	/**
	 * Removes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati remove(DocumentiCollegatiPK documentiCollegatiPK)
		throws NoSuchDocumentiCollegatiException {

		return remove((Serializable)documentiCollegatiPK);
	}

	/**
	 * Removes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati remove(Serializable primaryKey)
		throws NoSuchDocumentiCollegatiException {

		Session session = null;

		try {
			session = openSession();

			DocumentiCollegati documentiCollegati =
				(DocumentiCollegati)session.get(
					DocumentiCollegatiImpl.class, primaryKey);

			if (documentiCollegati == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentiCollegatiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentiCollegati);
		}
		catch (NoSuchDocumentiCollegatiException nsee) {
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
	protected DocumentiCollegati removeImpl(
		DocumentiCollegati documentiCollegati) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentiCollegati)) {
				documentiCollegati = (DocumentiCollegati)session.get(
					DocumentiCollegatiImpl.class,
					documentiCollegati.getPrimaryKeyObj());
			}

			if (documentiCollegati != null) {
				session.delete(documentiCollegati);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documentiCollegati != null) {
			clearCache(documentiCollegati);
		}

		return documentiCollegati;
	}

	@Override
	public DocumentiCollegati updateImpl(
		DocumentiCollegati documentiCollegati) {

		boolean isNew = documentiCollegati.isNew();

		if (!(documentiCollegati instanceof DocumentiCollegatiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentiCollegati.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentiCollegati);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentiCollegati proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentiCollegati implementation " +
					documentiCollegati.getClass());
		}

		DocumentiCollegatiModelImpl documentiCollegatiModelImpl =
			(DocumentiCollegatiModelImpl)documentiCollegati;

		Session session = null;

		try {
			session = openSession();

			if (documentiCollegati.isNew()) {
				session.save(documentiCollegati);

				documentiCollegati.setNew(false);
			}
			else {
				documentiCollegati = (DocumentiCollegati)session.merge(
					documentiCollegati);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DocumentiCollegatiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				documentiCollegatiModelImpl.getID_INVIO()
			};

			finderCache.removeResult(
				_finderPathCountByDocumentiCollegatiByIdInvio, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((documentiCollegatiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					documentiCollegatiModelImpl.getOriginalID_INVIO()
				};

				finderCache.removeResult(
					_finderPathCountByDocumentiCollegatiByIdInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio,
					args);

				args = new Object[] {documentiCollegatiModelImpl.getID_INVIO()};

				finderCache.removeResult(
					_finderPathCountByDocumentiCollegatiByIdInvio, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio,
					args);
			}
		}

		entityCache.putResult(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiImpl.class, documentiCollegati.getPrimaryKey(),
			documentiCollegati, false);

		documentiCollegati.resetOriginalValues();

		return documentiCollegati;
	}

	/**
	 * Returns the documenti collegati with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the documenti collegati
	 * @return the documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentiCollegatiException {

		DocumentiCollegati documentiCollegati = fetchByPrimaryKey(primaryKey);

		if (documentiCollegati == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentiCollegatiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentiCollegati;
	}

	/**
	 * Returns the documenti collegati with the primary key or throws a <code>NoSuchDocumentiCollegatiException</code> if it could not be found.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati findByPrimaryKey(
			DocumentiCollegatiPK documentiCollegatiPK)
		throws NoSuchDocumentiCollegatiException {

		return findByPrimaryKey((Serializable)documentiCollegatiPK);
	}

	/**
	 * Returns the documenti collegati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the documenti collegati
	 * @return the documenti collegati, or <code>null</code> if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DocumentiCollegati documentiCollegati =
			(DocumentiCollegati)serializable;

		if (documentiCollegati == null) {
			Session session = null;

			try {
				session = openSession();

				documentiCollegati = (DocumentiCollegati)session.get(
					DocumentiCollegatiImpl.class, primaryKey);

				if (documentiCollegati != null) {
					cacheResult(documentiCollegati);
				}
				else {
					entityCache.putResult(
						DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
						DocumentiCollegatiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
					DocumentiCollegatiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documentiCollegati;
	}

	/**
	 * Returns the documenti collegati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati, or <code>null</code> if a documenti collegati with the primary key could not be found
	 */
	@Override
	public DocumentiCollegati fetchByPrimaryKey(
		DocumentiCollegatiPK documentiCollegatiPK) {

		return fetchByPrimaryKey((Serializable)documentiCollegatiPK);
	}

	@Override
	public Map<Serializable, DocumentiCollegati> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DocumentiCollegati> map =
			new HashMap<Serializable, DocumentiCollegati>();

		for (Serializable primaryKey : primaryKeys) {
			DocumentiCollegati documentiCollegati = fetchByPrimaryKey(
				primaryKey);

			if (documentiCollegati != null) {
				map.put(primaryKey, documentiCollegati);
			}
		}

		return map;
	}

	/**
	 * Returns all the documenti collegatis.
	 *
	 * @return the documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findAll(
		int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of documenti collegatis
	 */
	@Override
	public List<DocumentiCollegati> findAll(
		int start, int end,
		OrderByComparator<DocumentiCollegati> orderByComparator,
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

		List<DocumentiCollegati> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentiCollegati>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCUMENTICOLLEGATI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTICOLLEGATI;

				if (pagination) {
					sql = sql.concat(DocumentiCollegatiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocumentiCollegati>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentiCollegati>)QueryUtil.list(
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
	 * Removes all the documenti collegatis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentiCollegati documentiCollegati : findAll()) {
			remove(documentiCollegati);
		}
	}

	/**
	 * Returns the number of documenti collegatis.
	 *
	 * @return the number of documenti collegatis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTICOLLEGATI);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentiCollegatiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the documenti collegati persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiModelImpl.FINDER_CACHE_ENABLED,
			DocumentiCollegatiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiModelImpl.FINDER_CACHE_ENABLED,
			DocumentiCollegatiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDocumentiCollegatiByIdInvio =
			new FinderPath(
				DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
				DocumentiCollegatiModelImpl.FINDER_CACHE_ENABLED,
				DocumentiCollegatiImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDocumentiCollegatiByIdInvio",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByDocumentiCollegatiByIdInvio =
			new FinderPath(
				DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
				DocumentiCollegatiModelImpl.FINDER_CACHE_ENABLED,
				DocumentiCollegatiImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDocumentiCollegatiByIdInvio",
				new String[] {Long.class.getName()},
				DocumentiCollegatiModelImpl.ID_INVIO_COLUMN_BITMASK);

		_finderPathCountByDocumentiCollegatiByIdInvio = new FinderPath(
			DocumentiCollegatiModelImpl.ENTITY_CACHE_ENABLED,
			DocumentiCollegatiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentiCollegatiByIdInvio",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(DocumentiCollegatiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DOCUMENTICOLLEGATI =
		"SELECT documentiCollegati FROM DocumentiCollegati documentiCollegati";

	private static final String _SQL_SELECT_DOCUMENTICOLLEGATI_WHERE =
		"SELECT documentiCollegati FROM DocumentiCollegati documentiCollegati WHERE ";

	private static final String _SQL_COUNT_DOCUMENTICOLLEGATI =
		"SELECT COUNT(documentiCollegati) FROM DocumentiCollegati documentiCollegati";

	private static final String _SQL_COUNT_DOCUMENTICOLLEGATI_WHERE =
		"SELECT COUNT(documentiCollegati) FROM DocumentiCollegati documentiCollegati WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentiCollegati.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentiCollegati exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentiCollegati exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentiCollegatiPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {
			"DOC_COLLEGATO_NUMERO", "DOC_COLLEGATO_ANNO",
			"DOC_COLLEGATO_TIPO_REGISTRO", "ID_INVIO"
		});

}