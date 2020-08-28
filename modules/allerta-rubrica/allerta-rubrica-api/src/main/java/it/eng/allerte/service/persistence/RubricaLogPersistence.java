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

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaLogException;
import it.eng.allerte.model.RubricaLog;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaLogUtil
 * @generated
 */
@ProviderType
public interface RubricaLogPersistence extends BasePersistence<RubricaLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaLogUtil} to access the rubrica log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA);

	/**
	 * Returns a range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogUtenteModifica_First(
			long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the first rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogUtenteModifica_First(
		long FK_UTENTE_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the last rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogUtenteModifica_Last(
			long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the last rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogUtenteModifica_Last(
		long FK_UTENTE_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog[] findByRubricaLogUtenteModifica_PrevAndNext(
			long ID_LOG, long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Removes all the rubrica logs where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	public void removeByRubricaLogUtenteModifica(long FK_UTENTE_MODIFICA);

	/**
	 * Returns the number of rubrica logs where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica logs
	 */
	public int countByRubricaLogUtenteModifica(long FK_UTENTE_MODIFICA);

	/**
	 * Returns all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns a range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogDataModifica_First(
			Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the first rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogDataModifica_First(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the last rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogDataModifica_Last(
			Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the last rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogDataModifica_Last(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog[] findByRubricaLogDataModifica_PrevAndNext(
			long ID_LOG, Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Removes all the rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public void removeByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the number of rubrica logs where DATA_MODIFICA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public int countByRubricaLogDataModifica(
		Date DATA_MODIFICA, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns a range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogTabella_First(
			String TABELLA, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the first rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogTabella_First(
		String TABELLA, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the last rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogTabella_Last(
			String TABELLA, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the last rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogTabella_Last(
		String TABELLA, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog[] findByRubricaLogTabella_PrevAndNext(
			long ID_LOG, String TABELLA, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Removes all the rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public void removeByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the number of rubrica logs where TABELLA = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param TABELLA the tabella
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public int countByRubricaLogTabella(
		String TABELLA, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns a range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogIdOggetto_First(
			String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the first rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogIdOggetto_First(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the last rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogIdOggetto_Last(
			String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the last rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogIdOggetto_Last(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog[] findByRubricaLogIdOggetto_PrevAndNext(
			long ID_LOG, String ID_OGGETTO, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Removes all the rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public void removeByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the number of rubrica logs where ID_OGGETTO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_OGGETTO the id_oggetto
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public int countByRubricaLogIdOggetto(
		String ID_OGGETTO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO);

	/**
	 * Returns a range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica logs
	 */
	public java.util.List<RubricaLog> findByRubricaLogBySitoProprietario(
		long FK_SITO_PROPRIETARIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogBySitoProprietario_First(
			long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the first rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogBySitoProprietario_First(
		long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the last rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log
	 * @throws NoSuchRubricaLogException if a matching rubrica log could not be found
	 */
	public RubricaLog findByRubricaLogBySitoProprietario_Last(
			long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the last rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica log, or <code>null</code> if a matching rubrica log could not be found
	 */
	public RubricaLog fetchByRubricaLogBySitoProprietario_Last(
		long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns the rubrica logs before and after the current rubrica log in the ordered set where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_LOG the primary key of the current rubrica log
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog[] findByRubricaLogBySitoProprietario_PrevAndNext(
			long ID_LOG, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
				orderByComparator)
		throws NoSuchRubricaLogException;

	/**
	 * Removes all the rubrica logs where FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public void removeByRubricaLogBySitoProprietario(long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the number of rubrica logs where FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica logs
	 */
	public int countByRubricaLogBySitoProprietario(long FK_SITO_PROPRIETARIO);

	/**
	 * Caches the rubrica log in the entity cache if it is enabled.
	 *
	 * @param rubricaLog the rubrica log
	 */
	public void cacheResult(RubricaLog rubricaLog);

	/**
	 * Caches the rubrica logs in the entity cache if it is enabled.
	 *
	 * @param rubricaLogs the rubrica logs
	 */
	public void cacheResult(java.util.List<RubricaLog> rubricaLogs);

	/**
	 * Creates a new rubrica log with the primary key. Does not add the rubrica log to the database.
	 *
	 * @param ID_LOG the primary key for the new rubrica log
	 * @return the new rubrica log
	 */
	public RubricaLog create(long ID_LOG);

	/**
	 * Removes the rubrica log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log that was removed
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog remove(long ID_LOG) throws NoSuchRubricaLogException;

	public RubricaLog updateImpl(RubricaLog rubricaLog);

	/**
	 * Returns the rubrica log with the primary key or throws a <code>NoSuchRubricaLogException</code> if it could not be found.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log
	 * @throws NoSuchRubricaLogException if a rubrica log with the primary key could not be found
	 */
	public RubricaLog findByPrimaryKey(long ID_LOG)
		throws NoSuchRubricaLogException;

	/**
	 * Returns the rubrica log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_LOG the primary key of the rubrica log
	 * @return the rubrica log, or <code>null</code> if a rubrica log with the primary key could not be found
	 */
	public RubricaLog fetchByPrimaryKey(long ID_LOG);

	/**
	 * Returns all the rubrica logs.
	 *
	 * @return the rubrica logs
	 */
	public java.util.List<RubricaLog> findAll();

	/**
	 * Returns a range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @return the range of rubrica logs
	 */
	public java.util.List<RubricaLog> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica logs
	 */
	public java.util.List<RubricaLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica logs
	 * @param end the upper bound of the range of rubrica logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica logs
	 */
	public java.util.List<RubricaLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica logs.
	 *
	 * @return the number of rubrica logs
	 */
	public int countAll();

}