/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence.impl;

import allerta.catasto.exception.NoSuchFonteException;
import allerta.catasto.model.Fonte;
import allerta.catasto.model.FonteTable;
import allerta.catasto.model.impl.FonteImpl;
import allerta.catasto.model.impl.FonteModelImpl;
import allerta.catasto.service.persistence.FontePersistence;
import allerta.catasto.service.persistence.FonteUtil;
import allerta.catasto.service.persistence.impl.constants.CATASTOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

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
 * The persistence implementation for the fonte service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FontePersistence.class)
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
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Fonte.class);

		setModelImplClass(FonteImpl.class);
		setModelPKClass(long.class);

		setTable(FonteTable.INSTANCE);
	}

	/**
	 * Caches the fonte in the entity cache if it is enabled.
	 *
	 * @param fonte the fonte
	 */
	@Override
	public void cacheResult(Fonte fonte) {
		entityCache.putResult(FonteImpl.class, fonte.getPrimaryKey(), fonte);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fontes in the entity cache if it is enabled.
	 *
	 * @param fontes the fontes
	 */
	@Override
	public void cacheResult(List<Fonte> fontes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fontes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Fonte fonte : fontes) {
			if (entityCache.getResult(FonteImpl.class, fonte.getPrimaryKey()) ==
					null) {

				cacheResult(fonte);
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

		finderCache.clearCache(FonteImpl.class);
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
		entityCache.removeResult(FonteImpl.class, fonte);
	}

	@Override
	public void clearCache(List<Fonte> fontes) {
		for (Fonte fonte : fontes) {
			entityCache.removeResult(FonteImpl.class, fonte);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FonteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FonteImpl.class, primaryKey);
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
		catch (NoSuchFonteException noSuchEntityException) {
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(fonte);
			}
			else {
				fonte = (Fonte)session.merge(fonte);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(FonteImpl.class, fonte, false, true);

		if (isNew) {
			fonte.setNew(false);
		}

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
	 * @param id the primary key of the fonte
	 * @return the fonte, or <code>null</code> if a fonte with the primary key could not be found
	 */
	@Override
	public Fonte fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fontes
	 */
	@Override
	public List<Fonte> findAll(
		int start, int end, OrderByComparator<Fonte> orderByComparator,
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

		List<Fonte> list = null;

		if (useFinderCache) {
			list = (List<Fonte>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FONTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FONTE;

				sql = sql.concat(FonteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Fonte>)QueryUtil.list(
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

				Query query = session.createQuery(_SQL_COUNT_FONTE);

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
		return _SQL_SELECT_FONTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FonteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fonte persistence.
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

		FonteUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FonteUtil.setPersistence(null);

		entityCache.removeCache(FonteImpl.class.getName());
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

	private static final String _SQL_SELECT_FONTE =
		"SELECT fonte FROM Fonte fonte";

	private static final String _SQL_COUNT_FONTE =
		"SELECT COUNT(fonte) FROM Fonte fonte";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fonte.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Fonte exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FontePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}