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

import allerta.catasto.exception.NoSuchFonteException;
import allerta.catasto.model.Fonte;
import allerta.catasto.model.impl.FonteImpl;
import allerta.catasto.model.impl.FonteModelImpl;
import allerta.catasto.service.persistence.FontePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the fonte service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FontePersistenceImpl
	extends BasePersistenceImpl<Fonte> implements FontePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FonteUtil</code> to access the fonte persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FonteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FontePersistenceImpl() {
		setModelClass(Fonte.class);

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
	 * Caches the fonte in the entity cache if it is enabled.
	 *
	 * @param fonte the fonte
	 */
	@Override
	public void cacheResult(Fonte fonte) {
		entityCache.putResult(
			FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
			fonte.getPrimaryKey(), fonte);

		fonte.resetOriginalValues();
	}

	/**
	 * Caches the fontes in the entity cache if it is enabled.
	 *
	 * @param fontes the fontes
	 */
	@Override
	public void cacheResult(List<Fonte> fontes) {
		for (Fonte fonte : fontes) {
			if (entityCache.getResult(
					FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
					fonte.getPrimaryKey()) == null) {

				cacheResult(fonte);
			}
			else {
				fonte.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fontes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FonteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fonte.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Fonte fonte) {
		entityCache.removeResult(
			FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
			fonte.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Fonte> fontes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Fonte fonte : fontes) {
			entityCache.removeResult(
				FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
				fonte.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fonte with the primary key. Does not add the fonte to the database.
	 *
	 * @param id the primary key for the new fonte
	 * @return the new fonte
	 */
	@Override
	public Fonte create(long id) {
		Fonte fonte = new FonteImpl();

		fonte.setNew(true);
		fonte.setPrimaryKey(id);

		return fonte;
	}

	/**
	 * Removes the fonte with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte that was removed
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte remove(long id) throws NoSuchFonteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the fonte with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fonte
	 * @return the fonte that was removed
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte remove(Serializable primaryKey) throws NoSuchFonteException {
		Session session = null;

		try {
			session = openSession();

			Fonte fonte = (Fonte)session.get(FonteImpl.class, primaryKey);

			if (fonte == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFonteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fonte);
		}
		catch (NoSuchFonteException nsee) {
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
	protected Fonte removeImpl(Fonte fonte) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fonte)) {
				fonte = (Fonte)session.get(
					FonteImpl.class, fonte.getPrimaryKeyObj());
			}

			if (fonte != null) {
				session.delete(fonte);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fonte != null) {
			clearCache(fonte);
		}

		return fonte;
	}

	@Override
	public Fonte updateImpl(Fonte fonte) {
		boolean isNew = fonte.isNew();

		Session session = null;

		try {
			session = openSession();

			if (fonte.isNew()) {
				session.save(fonte);

				fonte.setNew(false);
			}
			else {
				fonte = (Fonte)session.merge(fonte);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
			fonte.getPrimaryKey(), fonte, false);

		fonte.resetOriginalValues();

		return fonte;
	}

	/**
	 * Returns the fonte with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fonte
	 * @return the fonte
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFonteException {

		Fonte fonte = fetchByPrimaryKey(primaryKey);

		if (fonte == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFonteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fonte;
	}

	/**
	 * Returns the fonte with the primary key or throws a <code>NoSuchFonteException</code> if it could not be found.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte findByPrimaryKey(long id) throws NoSuchFonteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the fonte with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fonte
	 * @return the fonte, or <code>null</code> if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Fonte fonte = (Fonte)serializable;

		if (fonte == null) {
			Session session = null;

			try {
				session = openSession();

				fonte = (Fonte)session.get(FonteImpl.class, primaryKey);

				if (fonte != null) {
					cacheResult(fonte);
				}
				else {
					entityCache.putResult(
						FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fonte;
	}

	/**
	 * Returns the fonte with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte, or <code>null</code> if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Fonte> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Fonte> map = new HashMap<Serializable, Fonte>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Fonte fonte = fetchByPrimaryKey(primaryKey);

			if (fonte != null) {
				map.put(primaryKey, fonte);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Fonte)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_FONTE_WHERE_PKS_IN);

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

			for (Fonte fonte : (List<Fonte>)q.list()) {
				map.put(fonte.getPrimaryKeyObj(), fonte);

				cacheResult(fonte);

				uncachedPrimaryKeys.remove(fonte.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					FonteModelImpl.ENTITY_CACHE_ENABLED, FonteImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the fontes.
	 *
	 * @return the fontes
	 */
	@Override
	public List<Fonte> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @return the range of fontes
	 */
	@Override
	public List<Fonte> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fontes
	 */
	@Override
	public List<Fonte> findAll(
		int start, int end, OrderByComparator<Fonte> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fontes
	 */
	@Override
	public List<Fonte> findAll(
		int start, int end, OrderByComparator<Fonte> orderByComparator,
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

		List<Fonte> list = null;

		if (retrieveFromCache) {
			list = (List<Fonte>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FONTE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FONTE;

				if (pagination) {
					sql = sql.concat(FonteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Fonte>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Fonte>)QueryUtil.list(
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
	 * Removes all the fontes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Fonte fonte : findAll()) {
			remove(fonte);
		}
	}

	/**
	 * Returns the number of fontes.
	 *
	 * @return the number of fontes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FONTE);

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
		return FonteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fonte persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			FonteModelImpl.ENTITY_CACHE_ENABLED,
			FonteModelImpl.FINDER_CACHE_ENABLED, FonteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FonteModelImpl.ENTITY_CACHE_ENABLED,
			FonteModelImpl.FINDER_CACHE_ENABLED, FonteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			FonteModelImpl.ENTITY_CACHE_ENABLED,
			FonteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(FonteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FONTE =
		"SELECT fonte FROM Fonte fonte";

	private static final String _SQL_SELECT_FONTE_WHERE_PKS_IN =
		"SELECT fonte FROM Fonte fonte WHERE id_ IN (";

	private static final String _SQL_COUNT_FONTE =
		"SELECT COUNT(fonte) FROM Fonte fonte";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fonte.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Fonte exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FontePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}