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

import it.eng.allerte.exception.NoSuchRubricaNominativoException;
import it.eng.allerte.model.RubricaNominativo;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica nominativo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaNominativoUtil
 * @generated
 */
@ProviderType
public interface RubricaNominativoPersistence
	extends BasePersistence<RubricaNominativo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaNominativoUtil} to access the rubrica nominativo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaNominativo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaNominativoException</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByNominativoPerSitoProprietario(
			long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO,
		boolean retrieveFromCache);

	/**
	 * Removes the rubrica nominativo where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica nominativo that was removed
	 */
	public RubricaNominativo removeByNominativoPerSitoProprietario(
			long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the number of rubrica nominativos where ID_NOMINATIVO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_NOMINATIVO the id_nominativo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica nominativos
	 */
	public int countByNominativoPerSitoProprietario(
		long ID_NOMINATIVO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @return the matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE);

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtentePortale(
		long FK_UTENTE_PORTALE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByUtentePortale_First(
			long FK_UTENTE_PORTALE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByUtentePortale_First(
		long FK_UTENTE_PORTALE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByUtentePortale_Last(
			long FK_UTENTE_PORTALE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByUtentePortale_Last(
		long FK_UTENTE_PORTALE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo[] findByUtentePortale_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_PORTALE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_PORTALE = &#63; from the database.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 */
	public void removeByUtentePortale(long FK_UTENTE_PORTALE);

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_PORTALE = &#63;.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale
	 * @return the number of matching rubrica nominativos
	 */
	public int countByUtentePortale(long FK_UTENTE_PORTALE);

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE);

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteCreazione(
		long FK_UTENTE_CREAZIONE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByUtenteCreazione_First(
			long FK_UTENTE_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByUtenteCreazione_First(
		long FK_UTENTE_CREAZIONE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByUtenteCreazione_Last(
			long FK_UTENTE_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByUtenteCreazione_Last(
		long FK_UTENTE_CREAZIONE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo[] findByUtenteCreazione_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	public void removeByUtenteCreazione(long FK_UTENTE_CREAZIONE);

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica nominativos
	 */
	public int countByUtenteCreazione(long FK_UTENTE_CREAZIONE);

	/**
	 * Returns all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA);

	/**
	 * Returns a range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findByUtenteModifica(
		long FK_UTENTE_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByUtenteModifica_First(
			long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the first rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByUtenteModifica_First(
		long FK_UTENTE_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByUtenteModifica_Last(
			long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the last rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByUtenteModifica_Last(
		long FK_UTENTE_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo[] findByUtenteModifica_PrevAndNext(
			long ID_NOMINATIVO, long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Removes all the rubrica nominativos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	public void removeByUtenteModifica(long FK_UTENTE_MODIFICA);

	/**
	 * Returns the number of rubrica nominativos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica nominativos
	 */
	public int countByUtenteModifica(long FK_UTENTE_MODIFICA);

	/**
	 * Returns all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns a range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
			int end);

	/**
	 * Returns an ordered range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica nominativos
	 */
	public java.util.List<RubricaNominativo>
		findByNominativoPerGruppoByNomeCognome(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator,
			boolean retrieveFromCache);

	/**
	 * Returns the first rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByNominativoPerGruppoByNomeCognome_First(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the first rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByNominativoPerGruppoByNomeCognome_First(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the last rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo findByNominativoPerGruppoByNomeCognome_Last(
			String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
				orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the last rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica nominativo, or <code>null</code> if a matching rubrica nominativo could not be found
	 */
	public RubricaNominativo fetchByNominativoPerGruppoByNomeCognome_Last(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns the rubrica nominativos before and after the current rubrica nominativo in the ordered set where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_NOMINATIVO the primary key of the current rubrica nominativo
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo[]
			findByNominativoPerGruppoByNomeCognome_PrevAndNext(
				long ID_NOMINATIVO, String COGNOME, String NOME,
				long FK_SITO_PROPRIETARIO,
				com.liferay.portal.kernel.util.OrderByComparator
					<RubricaNominativo> orderByComparator)
		throws NoSuchRubricaNominativoException;

	/**
	 * Removes all the rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 */
	public void removeByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the number of rubrica nominativos where COGNOME = &#63; and NOME = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param COGNOME the cognome
	 * @param NOME the nome
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica nominativos
	 */
	public int countByNominativoPerGruppoByNomeCognome(
		String COGNOME, String NOME, long FK_SITO_PROPRIETARIO);

	/**
	 * Caches the rubrica nominativo in the entity cache if it is enabled.
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 */
	public void cacheResult(RubricaNominativo rubricaNominativo);

	/**
	 * Caches the rubrica nominativos in the entity cache if it is enabled.
	 *
	 * @param rubricaNominativos the rubrica nominativos
	 */
	public void cacheResult(
		java.util.List<RubricaNominativo> rubricaNominativos);

	/**
	 * Creates a new rubrica nominativo with the primary key. Does not add the rubrica nominativo to the database.
	 *
	 * @param ID_NOMINATIVO the primary key for the new rubrica nominativo
	 * @return the new rubrica nominativo
	 */
	public RubricaNominativo create(long ID_NOMINATIVO);

	/**
	 * Removes the rubrica nominativo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo remove(long ID_NOMINATIVO)
		throws NoSuchRubricaNominativoException;

	public RubricaNominativo updateImpl(RubricaNominativo rubricaNominativo);

	/**
	 * Returns the rubrica nominativo with the primary key or throws a <code>NoSuchRubricaNominativoException</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo
	 * @throws NoSuchRubricaNominativoException if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo findByPrimaryKey(long ID_NOMINATIVO)
		throws NoSuchRubricaNominativoException;

	/**
	 * Returns the rubrica nominativo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo, or <code>null</code> if a rubrica nominativo with the primary key could not be found
	 */
	public RubricaNominativo fetchByPrimaryKey(long ID_NOMINATIVO);

	/**
	 * Returns all the rubrica nominativos.
	 *
	 * @return the rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findAll();

	/**
	 * Returns a range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaNominativoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica nominativos
	 */
	public java.util.List<RubricaNominativo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaNominativo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica nominativos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica nominativos.
	 *
	 * @return the number of rubrica nominativos
	 */
	public int countAll();

}