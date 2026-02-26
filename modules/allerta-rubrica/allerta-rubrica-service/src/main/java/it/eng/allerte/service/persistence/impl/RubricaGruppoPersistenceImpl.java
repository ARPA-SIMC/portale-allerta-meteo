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
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoTable;
import it.eng.allerte.model.impl.RubricaGruppoImpl;
import it.eng.allerte.model.impl.RubricaGruppoModelImpl;
import it.eng.allerte.service.persistence.RubricaGruppoPersistence;
import it.eng.allerte.service.persistence.RubricaGruppoUtil;
import it.eng.allerte.service.persistence.impl.constants.rubricaPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the rubrica gruppo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @generated
 */
@Component(service = RubricaGruppoPersistence.class)
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
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ID_GRUPPO=");
			sb.append(ID_GRUPPO);

			sb.append(", FK_SITO_PROPRIETARIO=");
			sb.append(FK_SITO_PROPRIETARIO);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRubricaGruppoException(sb.toString());
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
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ID_GRUPPO, FK_SITO_PROPRIETARIO};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
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
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE);

			sb.append(_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_ID_GRUPPO_2);

			sb.append(
				_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ID_GRUPPO);

				queryPos.add(FK_SITO_PROPRIETARIO);

				List<RubricaGruppo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByRubricaGruppoSitoProprietario,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									ID_GRUPPO, FK_SITO_PROPRIETARIO
								};
							}

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
			catch (Exception exception) {
				throw processException(exception);
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

		RubricaGruppo rubricaGruppo = fetchByRubricaGruppoSitoProprietario(
			ID_GRUPPO, FK_SITO_PROPRIETARIO);

		if (rubricaGruppo == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_ID_GRUPPO_2 =
			"rubricaGruppo.ID_GRUPPO = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOSITOPROPRIETARIO_FK_SITO_PROPRIETARIO_2 =
			"rubricaGruppo.FK_SITO_PROPRIETARIO = ?";

	private FinderPath _finderPathFetchByRubricaGruppoForOwnerAndName;

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
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("FK_SITO_PROPRIETARIO=");
			sb.append(FK_SITO_PROPRIETARIO);

			sb.append(", NOME=");
			sb.append(NOME);

			sb.append(", DISABLED=");
			sb.append(DISABLED);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRubricaGruppoException(sb.toString());
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
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED,
		boolean useFinderCache) {

		NOME = Objects.toString(NOME, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {FK_SITO_PROPRIETARIO, NOME, DISABLED};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
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
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE);

			sb.append(
				_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_FK_SITO_PROPRIETARIO_2);

			boolean bindNOME = false;

			if (NOME.isEmpty()) {
				sb.append(_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_3);
			}
			else {
				bindNOME = true;

				sb.append(_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_NOME_2);
			}

			sb.append(_FINDER_COLUMN_RUBRICAGRUPPOFOROWNERANDNAME_DISABLED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_SITO_PROPRIETARIO);

				if (bindNOME) {
					queryPos.add(NOME);
				}

				queryPos.add(DISABLED);

				List<RubricaGruppo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByRubricaGruppoForOwnerAndName,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									FK_SITO_PROPRIETARIO, NOME, DISABLED
								};
							}

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
			catch (Exception exception) {
				throw processException(exception);
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

		RubricaGruppo rubricaGruppo = fetchByRubricaGruppoForOwnerAndName(
			FK_SITO_PROPRIETARIO, NOME, DISABLED);

		if (rubricaGruppo == null) {
			return 0;
		}

		return 1;
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
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("FK_CATEGORIA=");
			sb.append(FK_CATEGORIA);

			sb.append(", FK_SITO_PROPRIETARIO=");
			sb.append(FK_SITO_PROPRIETARIO);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRubricaGruppoException(sb.toString());
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
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	@Override
	public RubricaGruppo fetchByRubricaGruppoCategoria(
		long FK_CATEGORIA, long FK_SITO_PROPRIETARIO, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {FK_CATEGORIA, FK_SITO_PROPRIETARIO};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
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
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RUBRICAGRUPPO_WHERE);

			sb.append(_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_CATEGORIA_2);

			sb.append(
				_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_SITO_PROPRIETARIO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(FK_CATEGORIA);

				queryPos.add(FK_SITO_PROPRIETARIO);

				List<RubricaGruppo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByRubricaGruppoCategoria,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									FK_CATEGORIA, FK_SITO_PROPRIETARIO
								};
							}

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
			catch (Exception exception) {
				throw processException(exception);
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

		RubricaGruppo rubricaGruppo = fetchByRubricaGruppoCategoria(
			FK_CATEGORIA, FK_SITO_PROPRIETARIO);

		if (rubricaGruppo == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_CATEGORIA_2 =
			"rubricaGruppo.FK_CATEGORIA = ? AND ";

	private static final String
		_FINDER_COLUMN_RUBRICAGRUPPOCATEGORIA_FK_SITO_PROPRIETARIO_2 =
			"rubricaGruppo.FK_SITO_PROPRIETARIO = ?";

	public RubricaGruppoPersistenceImpl() {
		setModelClass(RubricaGruppo.class);

		setModelImplClass(RubricaGruppoImpl.class);
		setModelPKClass(long.class);

		setTable(RubricaGruppoTable.INSTANCE);
	}

	/**
	 * Caches the rubrica gruppo in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 */
	@Override
	public void cacheResult(RubricaGruppo rubricaGruppo) {
		dummyEntityCache.putResult(
			RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey(),
			rubricaGruppo);

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaGruppoSitoProprietario,
			new Object[] {
				rubricaGruppo.getID_GRUPPO(),
				rubricaGruppo.getFK_SITO_PROPRIETARIO()
			},
			rubricaGruppo);

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaGruppoForOwnerAndName,
			new Object[] {
				rubricaGruppo.getFK_SITO_PROPRIETARIO(),
				rubricaGruppo.getNOME(), rubricaGruppo.isDISABLED()
			},
			rubricaGruppo);

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaGruppoCategoria,
			new Object[] {
				rubricaGruppo.getFK_CATEGORIA(),
				rubricaGruppo.getFK_SITO_PROPRIETARIO()
			},
			rubricaGruppo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rubrica gruppos in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppos the rubrica gruppos
	 */
	@Override
	public void cacheResult(List<RubricaGruppo> rubricaGruppos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rubricaGruppos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RubricaGruppo rubricaGruppo : rubricaGruppos) {
			if (dummyEntityCache.getResult(
					RubricaGruppoImpl.class, rubricaGruppo.getPrimaryKey()) ==
						null) {

				cacheResult(rubricaGruppo);
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
		dummyEntityCache.clearCache(RubricaGruppoImpl.class);

		dummyFinderCache.clearCache(RubricaGruppoImpl.class);
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
		dummyEntityCache.removeResult(RubricaGruppoImpl.class, rubricaGruppo);
	}

	@Override
	public void clearCache(List<RubricaGruppo> rubricaGruppos) {
		for (RubricaGruppo rubricaGruppo : rubricaGruppos) {
			dummyEntityCache.removeResult(
				RubricaGruppoImpl.class, rubricaGruppo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(RubricaGruppoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(RubricaGruppoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RubricaGruppoModelImpl rubricaGruppoModelImpl) {

		Object[] args = new Object[] {
			rubricaGruppoModelImpl.getID_GRUPPO(),
			rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO()
		};

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaGruppoSitoProprietario, args,
			rubricaGruppoModelImpl);

		args = new Object[] {
			rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO(),
			rubricaGruppoModelImpl.getNOME(),
			rubricaGruppoModelImpl.isDISABLED()
		};

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaGruppoForOwnerAndName, args,
			rubricaGruppoModelImpl);

		args = new Object[] {
			rubricaGruppoModelImpl.getFK_CATEGORIA(),
			rubricaGruppoModelImpl.getFK_SITO_PROPRIETARIO()
		};

		dummyFinderCache.putResult(
			_finderPathFetchByRubricaGruppoCategoria, args,
			rubricaGruppoModelImpl);
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
		catch (NoSuchRubricaGruppoException noSuchEntityException) {
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
		catch (Exception exception) {
			throw processException(exception);
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

			if (isNew) {
				session.save(rubricaGruppo);
			}
			else {
				rubricaGruppo = (RubricaGruppo)session.merge(rubricaGruppo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			RubricaGruppoImpl.class, rubricaGruppoModelImpl, false, true);

		cacheUniqueFindersCache(rubricaGruppoModelImpl);

		if (isNew) {
			rubricaGruppo.setNew(false);
		}

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
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo, or <code>null</code> if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public RubricaGruppo fetchByPrimaryKey(long ID_GRUPPO) {
		return fetchByPrimaryKey((Serializable)ID_GRUPPO);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica gruppos
	 */
	@Override
	public List<RubricaGruppo> findAll(
		int start, int end, OrderByComparator<RubricaGruppo> orderByComparator,
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

		List<RubricaGruppo> list = null;

		if (useFinderCache) {
			list = (List<RubricaGruppo>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RUBRICAGRUPPO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RUBRICAGRUPPO;

				sql = sql.concat(RubricaGruppoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RubricaGruppo>)QueryUtil.list(
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
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RUBRICAGRUPPO);

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
		return "ID_GRUPPO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RUBRICAGRUPPO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RubricaGruppoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rubrica gruppo persistence.
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

		_finderPathFetchByRubricaGruppoSitoProprietario = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRubricaGruppoSitoProprietario",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"ID_GRUPPO", "FK_SITO_PROPRIETARIO"}, true);

		_finderPathFetchByRubricaGruppoForOwnerAndName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRubricaGruppoForOwnerAndName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"FK_SITO_PROPRIETARIO", "NOME", "DISABLED"}, true);

		_finderPathFetchByRubricaGruppoCategoria = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRubricaGruppoCategoria",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"FK_CATEGORIA", "FK_SITO_PROPRIETARIO"}, true);

		RubricaGruppoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RubricaGruppoUtil.setPersistence(null);

		dummyEntityCache.removeCache(RubricaGruppoImpl.class.getName());
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

	private static final String _SQL_SELECT_RUBRICAGRUPPO =
		"SELECT rubricaGruppo FROM RubricaGruppo rubricaGruppo";

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

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}