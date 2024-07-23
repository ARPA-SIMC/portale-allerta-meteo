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

package it.eng.allerte.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.impl.RubricaGruppoImpl;
import it.eng.allerte.model.impl.RubricaGruppoModelImpl;
import it.eng.allerte.service.persistence.RubricaGruppoPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the rubrica gruppo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoPersistenceImpl
	extends BasePersistenceImpl<RubricaGruppo>
	implements RubricaGruppoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RubricaGruppoUtil</code> to access the rubrica gruppo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RubricaGruppoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByRubricaGruppoSitoProprietario;
	private FinderPath _finderPathCountByRubricaGruppoSitoProprietario;

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo findByRubricaGruppoSitoProprietario(
			long ID_GRUPPO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = fetchByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);

		if (rubricaGruppo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ID_GRUPPO=");
			msg.append(ID_GRUPPO);

			msg.append(", FK_SITO_PROPRIETARIO=");
			msg.append(FK_SITO_PROPRIETARIO);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRubricaGruppoException(msg.toString());
		}

		return rubricaGruppo;
	}

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO) {

		return fetchByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO, true);
	}

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {ID_GRUPPO, FK_SITO_PROPRIETARIO};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByRubricaGruppoSitoProprietario, finderArgs,
				this);
		}

		if (result instanceof RubricaGruppo) {
			RubricaGruppo rubricaGruppo = (RubricaGruppo)result;

			if ((ID_GRUPPO != rubricaGruppo.getID_GRUPPO()) ||
				(FK_SITO_PROPRIETARIO !=
					rubricaGruppo.getFK_SITO_PROPRIETARIO())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_ID_GRUPPO_2);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ID_GRUPPO);

				qPos.add(FK_SITO_PROPRIETARIO);

				List<RubricaGruppo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByRubricaGruppoSitoProprietario,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RubricaGruppoPersistenceImpl.fetchByRubricaGruppoSitoProprietario(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RubricaGruppo rubricaGruppo = list.get(0);

					result = rubricaGruppo;

					cacheResult(rubricaGruppo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByRubricaGruppoSitoProprietario,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RubricaGruppo)result;
		}
	}

	/**
	 * Removes the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica gruppo that was removed
	 */
	@Override
	public RubricaGruppo removeByRubricaGruppoSitoProprietario(
			long ID_GRUPPO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = findByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);

		return remove(rubricaGruppo);
	}

	/**
	 * Returns the number of rubrica gruppos where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica gruppos
	 */
	@Override
	public int countByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO) {

		FinderPath finderPath = _finderPathCountByRubricaGruppoSitoProprietario;

		Object[] finderArgs = new Object[] {ID_GRUPPO, FK_SITO_PROPRIETARIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RUBRICAGRUPPO_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_ID_GRUPPO_2);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ID_GRUPPO);

				qPos.add(FK_SITO_PROPRIETARIO);

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
		_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_ID_GRUPPO_2 =
			"rubricaGruppo.ID_GRUPPO = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2 =
			"rubricaGruppo.FK_SITO_PROPRIETARIO = ?";

	private FinderPath _finderPathFetchByRubricaGruppoForOwnerAndName;
	private FinderPath _finderPathCountByRubricaGruppoForOwnerAndName;

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo findByRubricaGruppoForOwnerAndName(
			long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = fetchByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);

		if (rubricaGruppo == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("FK_SITO_PROPRIETARIO=");
			msg.append(FK_SITO_PROPRIETARIO);

			msg.append(", NOME=");
			msg.append(NOME);

			msg.append(", DISABLED=");
			msg.append(DISABLED);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRubricaGruppoException(msg.toString());
		}

		return rubricaGruppo;
	}

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED) {

		return fetchByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED, true);
	}

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED,
		boolean retrieveFromCache) {

		NOME = Objects.toString(NOME, "");

		Object[] finderArgs = new Object[] {
			FK_SITO_PROPRIETARIO, NOME, DISABLED
		};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByRubricaGruppoForOwnerAndName, finderArgs,
				this);
		}

		if (result instanceof RubricaGruppo) {
			RubricaGruppo rubricaGruppo = (RubricaGruppo)result;

			if ((FK_SITO_PROPRIETARIO !=
					rubricaGruppo.getFK_SITO_PROPRIETARIO()) ||
				!Objects.equals(NOME, rubricaGruppo.getNOME()) ||
				(DISABLED != rubricaGruppo.isDISABLED())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_FK_SITO_PROPRIETARIO_2);

			boolean bindNOME = false;

			if (NOME.isEmpty()) {
				query.append(
					_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_3);
			}
			else {
				bindNOME = true;

				query.append(
					_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_DISABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_SITO_PROPRIETARIO);

				if (bindNOME) {
					qPos.add(NOME);
				}

				qPos.add(DISABLED);

				List<RubricaGruppo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByRubricaGruppoForOwnerAndName,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RubricaGruppoPersistenceImpl.fetchByRubricaGruppoForOwnerAndName(long, String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RubricaGruppo rubricaGruppo = list.get(0);

					result = rubricaGruppo;

					cacheResult(rubricaGruppo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByRubricaGruppoForOwnerAndName, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RubricaGruppo)result;
		}
	}

	/**
	 * Removes the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; from the database.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the rubrica gruppo that was removed
	 */
	@Override
	public RubricaGruppo removeByRubricaGruppoForOwnerAndName(
			long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = findByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);

		return remove(rubricaGruppo);
	}

	/**
	 * Returns the number of rubrica gruppos where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the number of matching rubrica gruppos
	 */
	@Override
	public int countByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED) {

		NOME = Objects.toString(NOME, "");

		FinderPath finderPath = _finderPathCountByRubricaGruppoForOwnerAndName;

		Object[] finderArgs = new Object[] {
			FK_SITO_PROPRIETARIO, NOME, DISABLED
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RUBRICAGRUPPO_WHERE);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_FK_SITO_PROPRIETARIO_2);

			boolean bindNOME = false;

			if (NOME.isEmpty()) {
				query.append(
					_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_3);
			}
			else {
				bindNOME = true;

				query.append(
					_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_2);
			}

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_DISABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_SITO_PROPRIETARIO);

				if (bindNOME) {
					qPos.add(NOME);
				}

				qPos.add(DISABLED);

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
		_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_FK_SITO_PROPRIETARIO_2 =
			"rubricaGruppo.FK_SITO_PROPRIETARIO = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_2 =
			"rubricaGruppo.NOME = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_3 =
			"(rubricaGruppo.NOME IS NULL OR rubricaGruppo.NOME = '') AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_DISABLED_2 =
			"rubricaGruppo.DISABLED = ?";

	private FinderPath _finderPathFetchByRubricaGruppoCategoria;
	private FinderPath _finderPathCountByRubricaGruppoCategoria;

	/**
	 * Returns the rubrica gruppo where FK_CATEGORIA = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param FK_CATEGORIA the fk_categoria
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo findByRubricaGruppoCategoria(
			long FK_CATEGORIA, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = fetchByRubricaGruppoCategoria(
			FK_CATEGORIA, FK_SITO_PROPRIETARIO);

		if (rubricaGruppo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("FK_CATEGORIA=");
			msg.append(FK_CATEGORIA);

			msg.append(", FK_SITO_PROPRIETARIO=");
			msg.append(FK_SITO_PROPRIETARIO);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRubricaGruppoException(msg.toString());
		}

		return rubricaGruppo;
	}

	/**
	 * Returns the rubrica gruppo where FK_CATEGORIA = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_CATEGORIA the fk_categoria
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoCategoria(
		long FK_CATEGORIA, long FK_SITO_PROPRIETARIO) {

		return fetchByRubricaGruppoCategoria(
			FK_CATEGORIA, FK_SITO_PROPRIETARIO, true);
	}

	/**
	 * Returns the rubrica gruppo where FK_CATEGORIA = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_CATEGORIA the fk_categoria
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoCategoria(
		long FK_CATEGORIA, long FK_SITO_PROPRIETARIO,
		boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {FK_CATEGORIA, FK_SITO_PROPRIETARIO};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByRubricaGruppoCategoria, finderArgs, this);
		}

		if (result instanceof RubricaGruppo) {
			RubricaGruppo rubricaGruppo = (RubricaGruppo)result;

			if ((FK_CATEGORIA != rubricaGruppo.getFK_CATEGORIA()) ||
				(FK_SITO_PROPRIETARIO !=
					rubricaGruppo.getFK_SITO_PROPRIETARIO())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE);

			query.append(_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_CATEGORIA_2);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_CATEGORIA);

				qPos.add(FK_SITO_PROPRIETARIO);

				List<RubricaGruppo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByRubricaGruppoCategoria, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RubricaGruppoPersistenceImpl.fetchByRubricaGruppoCategoria(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RubricaGruppo rubricaGruppo = list.get(0);

					result = rubricaGruppo;

					cacheResult(rubricaGruppo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByRubricaGruppoCategoria, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RubricaGruppo)result;
		}
	}

	/**
	 * Removes the rubrica gruppo where FK_CATEGORIA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param FK_CATEGORIA the fk_categoria
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica gruppo that was removed
	 */
	@Override
	public RubricaGruppo removeByRubricaGruppoCategoria(
			long FK_CATEGORIA, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = findByRubricaGruppoCategoria(
			FK_CATEGORIA, FK_SITO_PROPRIETARIO);

		return remove(rubricaGruppo);
	}

	/**
	 * Returns the number of rubrica gruppos where FK_CATEGORIA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_CATEGORIA the fk_categoria
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica gruppos
	 */
	@Override
	public int countByRubricaGruppoCategoria(
		long FK_CATEGORIA, long FK_SITO_PROPRIETARIO) {

		FinderPath finderPath = _finderPathCountByRubricaGruppoCategoria;

		Object[] finderArgs = new Object[] {FK_CATEGORIA, FK_SITO_PROPRIETARIO};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RUBRICAGRUPPO_WHERE);

			query.append(_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_CATEGORIA_2);

			query.append(
				_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_SITO_PROPRIETARIO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FK_CATEGORIA);

				qPos.add(FK_SITO_PROPRIETARIO);

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
		_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_CATEGORIA_2 =
			"rubricaGruppo.FK_CATEGORIA = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_SITO_PROPRIETARIO_2 =
			"rubricaGruppo.FK_SITO_PROPRIETARIO = ?";

	public RubricaGruppoPersistenceImpl() {
		setModelClass(RubricaGruppo.class);
	}

	/**
	 * Caches the rubrica gruppo in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 */
	@Override
	public void cacheResult(RubricaGruppo rubricaGruppo) {
		entityCache.putResult(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey(),
			rubricaGruppo);

		finderCache.putResult(
			_finderPathFetchByRubricaGruppoSitoProprietario,
			new Object[] {
				rubricaGruppo.getID_GRUPPO(),
				rubricaGruppo.getFK_SITO_PROPRIETARIO()
			},
			rubricaGruppo);

		finderCache.putResult(
			_finderPathFetchByRubricaGruppoForOwnerAndName,
			new Object[] {
				rubricaGruppo.getFK_SITO_PROPRIETARIO(),
				rubricaGruppo.getNOME(), rubricaGruppo.isDISABLED()
			},
			rubricaGruppo);

		finderCache.putResult(
			_finderPathFetchByRubricaGruppoCategoria,
			new Object[] {
				rubricaGruppo.getFK_CATEGORIA(),
				rubricaGruppo.getFK_SITO_PROPRIETARIO()
			},
			rubricaGruppo);

		rubricaGruppo.resetOriginalValues();
	}

	/**
	 * Caches the rubrica gruppos in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppos the rubrica gruppos
	 */
	@Override
	public void cacheResult(List<RubricaGruppo> rubricaGruppos) {
		for (RubricaGruppo rubricaGruppo : rubricaGruppos) {
			if (entityCache.getResult(
					RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaGruppo);
			}
			else {
				rubricaGruppo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rubrica gruppos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RubricaGruppoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rubrica gruppo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RubricaGruppo rubricaGruppo) {
		entityCache.removeResult(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((RubricaGruppoModelImpl)rubricaGruppo, true);
	}

	@Override
	public void clearCache(List<RubricaGruppo> rubricaGruppos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RubricaGruppo rubricaGruppo : rubricaGruppos) {
			entityCache.removeResult(
				RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey());

			clearUniqueFindersCache(
				(RubricaGruppoModelImpl)rubricaGruppo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		RubricaGruppoModelImpl rubricaGruppoModelImpl) {

		Object[] args = new Object[] {
			rubricaGruppoModelImpl.getID_GRUPPO(),
			rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO()
		};

		finderCache.putResult(
			_finderPathCountByRubricaGruppoSitoProprietario, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByRubricaGruppoSitoProprietario, args,
			rubricaGruppoModelImpl, false);

		args = new Object[] {
			rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO(),
			rubricaGruppoModelImpl.getNOME(),
			rubricaGruppoModelImpl.isDISABLED()
		};

		finderCache.putResult(
			_finderPathCountByRubricaGruppoForOwnerAndName, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByRubricaGruppoForOwnerAndName, args,
			rubricaGruppoModelImpl, false);

		args = new Object[] {
			rubricaGruppoModelImpl.getFK_CATEGORIA(),
			rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO()
		};

		finderCache.putResult(
			_finderPathCountByRubricaGruppoCategoria, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByRubricaGruppoCategoria, args,
			rubricaGruppoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		RubricaGruppoModelImpl rubricaGruppoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				rubricaGruppoModelImpl.getID_GRUPPO(),
				rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoSitoProprietario, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaGruppoSitoProprietario, args);
		}

		if ((rubricaGruppoModelImpl.getColumnBitmask() &
			 _finderPathFetchByRubricaGruppoSitoProprietario.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				rubricaGruppoModelImpl.getOriginalID_GRUPPO(),
				rubricaGruppoModelImpl.getOriginalFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoSitoProprietario, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaGruppoSitoProprietario, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO(),
				rubricaGruppoModelImpl.getNOME(),
				rubricaGruppoModelImpl.isDISABLED()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoForOwnerAndName, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaGruppoForOwnerAndName, args);
		}

		if ((rubricaGruppoModelImpl.getColumnBitmask() &
			 _finderPathFetchByRubricaGruppoForOwnerAndName.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				rubricaGruppoModelImpl.getOriginalFK_SITO_PROPRIETARIO(),
				rubricaGruppoModelImpl.getOriginalNOME(),
				rubricaGruppoModelImpl.getOriginalDISABLED()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoForOwnerAndName, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaGruppoForOwnerAndName, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				rubricaGruppoModelImpl.getFK_CATEGORIA(),
				rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoCategoria, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaGruppoCategoria, args);
		}

		if ((rubricaGruppoModelImpl.getColumnBitmask() &
			 _finderPathFetchByRubricaGruppoCategoria.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				rubricaGruppoModelImpl.getOriginalFK_CATEGORIA(),
				rubricaGruppoModelImpl.getOriginalFK_SITO_PROPRIETARIO()
			};

			finderCache.removeResult(
				_finderPathCountByRubricaGruppoCategoria, args);
			finderCache.removeResult(
				_finderPathFetchByRubricaGruppoCategoria, args);
		}
	}

	/**
	 * Creates a new rubrica gruppo with the primary key. Does not add the rubrica gruppo to the database.
	 *
	 * @param ID_GRUPPO the primary key for the new rubrica gruppo
	 * @return the new rubrica gruppo
	 */
	@Override
	public RubricaGruppo create(long ID_GRUPPO) {
		RubricaGruppo rubricaGruppo = new RubricaGruppoImpl();

		rubricaGruppo.setNew(true);
		rubricaGruppo.setPrimaryKey(ID_GRUPPO);

		return rubricaGruppo;
	}

	/**
	 * Removes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo remove(long ID_GRUPPO)
		throws NoSuchRubricaGruppoException {

		return remove((Serializable)ID_GRUPPO);
	}

	/**
	 * Removes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo remove(Serializable primaryKey)
		throws NoSuchRubricaGruppoException {

		Session session = null;

		try {
			session = openSession();

			RubricaGruppo rubricaGruppo = (RubricaGruppo)session.get(
				RubricaGruppoImpl.class, primaryKey);

			if (rubricaGruppo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRubricaGruppoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rubricaGruppo);
		}
		catch (NoSuchRubricaGruppoException nsee) {
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
	protected RubricaGruppo removeImpl(RubricaGruppo rubricaGruppo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rubricaGruppo)) {
				rubricaGruppo = (RubricaGruppo)session.get(
					RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKeyObj());
			}

			if (rubricaGruppo != null) {
				session.delete(rubricaGruppo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rubricaGruppo != null) {
			clearCache(rubricaGruppo);
		}

		return rubricaGruppo;
	}

	@Override
	public RubricaGruppo updateImpl(RubricaGruppo rubricaGruppo) {
		boolean isNew = rubricaGruppo.isNew();

		if (!(rubricaGruppo instanceof RubricaGruppoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rubricaGruppo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rubricaGruppo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rubricaGruppo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RubricaGruppo implementation " +
					rubricaGruppo.getClass());
		}

		RubricaGruppoModelImpl rubricaGruppoModelImpl =
			(RubricaGruppoModelImpl)rubricaGruppo;

		Session session = null;

		try {
			session = openSession();

			if (rubricaGruppo.isNew()) {
				session.save(rubricaGruppo);

				rubricaGruppo.setNew(false);
			}
			else {
				rubricaGruppo = (RubricaGruppo)session.merge(rubricaGruppo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RubricaGruppoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey(),
			rubricaGruppo, false);

		clearUniqueFindersCache(rubricaGruppoModelImpl, false);
		cacheUniqueFindersCache(rubricaGruppoModelImpl);

		rubricaGruppo.resetOriginalValues();

		return rubricaGruppo;
	}

	/**
	 * Returns the rubrica gruppo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRubricaGruppoException {

		RubricaGruppo rubricaGruppo = fetchByPrimaryKey(primaryKey);

		if (rubricaGruppo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRubricaGruppoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rubricaGruppo;
	}

	/**
	 * Returns the rubrica gruppo with the primary key or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo findByPrimaryKey(long ID_GRUPPO)
		throws NoSuchRubricaGruppoException {

		return findByPrimaryKey((Serializable)ID_GRUPPO);
	}

	/**
	 * Returns the rubrica gruppo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rubrica gruppo
	 * @return the rubrica gruppo, or <code>null</code> if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RubricaGruppo rubricaGruppo = (RubricaGruppo)serializable;

		if (rubricaGruppo == null) {
			Session session = null;

			try {
				session = openSession();

				rubricaGruppo = (RubricaGruppo)session.get(
					RubricaGruppoImpl.class, primaryKey);

				if (rubricaGruppo != null) {
					cacheResult(rubricaGruppo);
				}
				else {
					entityCache.putResult(
						RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
						RubricaGruppoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rubricaGruppo;
	}

	/**
	 * Returns the rubrica gruppo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo, or <code>null</code> if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo fetchByPrimaryKey(long ID_GRUPPO) {
		return fetchByPrimaryKey((Serializable)ID_GRUPPO);
	}

	@Override
	public Map<Serializable, RubricaGruppo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RubricaGruppo> map =
			new HashMap<Serializable, RubricaGruppo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RubricaGruppo rubricaGruppo = fetchByPrimaryKey(primaryKey);

			if (rubricaGruppo != null) {
				map.put(primaryKey, rubricaGruppo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
				RubricaGruppoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RubricaGruppo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE_PKS_IN);

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

			for (RubricaGruppo rubricaGruppo : (List<RubricaGruppo>)q.list()) {
				map.put(rubricaGruppo.getPrimaryKeyObj(), rubricaGruppo);

				cacheResult(rubricaGruppo);

				uncachedPrimaryKeys.remove(rubricaGruppo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
					RubricaGruppoImpl.class, primaryKey, nullModel);
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
	 * Returns all the rubrica gruppos.
	 *
	 * @return the rubrica gruppos
	 */
	@Override
	public List<RubricaGruppo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @return the range of rubrica gruppos
	 */
	@Override
	public List<RubricaGruppo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppos
	 */
	@Override
	public List<RubricaGruppo> findAll(
		int start, int end,
		OrderByComparator<RubricaGruppo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppos
	 */
	@Override
	public List<RubricaGruppo> findAll(
		int start, int end, OrderByComparator<RubricaGruppo> orderByComparator,
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

		List<RubricaGruppo> list = null;

		if (retrieveFromCache) {
			list = (List<RubricaGruppo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RUBRICAGRUPPO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAGRUPPO;

				if (pagination) {
					sql = sql.concat(RubricaGruppoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RubricaGruppo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RubricaGruppo>)QueryUtil.list(
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
	 * Removes all the rubrica gruppos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RubricaGruppo rubricaGruppo : findAll()) {
			remove(rubricaGruppo);
		}
	}

	/**
	 * Returns the number of rubrica gruppos.
	 *
	 * @return the number of rubrica gruppos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RUBRICAGRUPPO);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaGruppoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica gruppo persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByRubricaGruppoSitoProprietario = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByRubricaGruppoSitoProprietario",
			new String[] {Long.class.getName(), Long.class.getName()},
			RubricaGruppoModelImpl.ID_GRUPPO_COLUMN_BITMASK |
			RubricaGruppoModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoSitoProprietario = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoSitoProprietario",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByRubricaGruppoForOwnerAndName = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByRubricaGruppoForOwnerAndName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			RubricaGruppoModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK |
			RubricaGruppoModelImpl.NOME_COLUMN_BITMASK |
			RubricaGruppoModelImpl.DISABLED_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoForOwnerAndName = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoForOwnerAndName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

		_finderPathFetchByRubricaGruppoCategoria = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED,
			RubricaGruppoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByRubricaGruppoCategoria",
			new String[] {Long.class.getName(), Long.class.getName()},
			RubricaGruppoModelImpl.FK_CATEGORIA_COLUMN_BITMASK |
			RubricaGruppoModelImpl.FK_SITO_PROPRIETARIO_COLUMN_BITMASK);

		_finderPathCountByRubricaGruppoCategoria = new FinderPath(
			RubricaGruppoModelImpl.ENTITY_CACHE_ENABLED,
			RubricaGruppoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRubricaGruppoCategoria",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(RubricaGruppoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RUBRICAGRUPPO =
		"SELECT rubricaGruppo FROM RubricaGruppo rubricaGruppo";

	private static final String _SQL_SELECT_RUBRICAGRUPPO_WHERE_PKS_IN =
		"SELECT rubricaGruppo FROM RubricaGruppo rubricaGruppo WHERE ID_GRUPPO IN (";

	private static final String _SQL_SELECT_RUBRICAGRUPPO_WHERE =
		"SELECT rubricaGruppo FROM RubricaGruppo rubricaGruppo WHERE ";

	private static final String _SQL_COUNT_RUBRICAGRUPPO =
		"SELECT COUNT(rubricaGruppo) FROM RubricaGruppo rubricaGruppo";

	private static final String _SQL_COUNT_RUBRICAGRUPPO_WHERE =
		"SELECT COUNT(rubricaGruppo) FROM RubricaGruppo rubricaGruppo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rubricaGruppo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RubricaGruppo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RubricaGruppo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RubricaGruppoPersistenceImpl.class);

}