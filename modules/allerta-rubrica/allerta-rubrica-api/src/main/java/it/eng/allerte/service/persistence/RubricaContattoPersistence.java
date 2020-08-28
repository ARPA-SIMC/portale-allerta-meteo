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

import it.eng.allerte.exception.NoSuchRubricaContattoException;
import it.eng.allerte.model.RubricaContatto;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica contatto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaContattoUtil
 * @generated
 */
@ProviderType
public interface RubricaContattoPersistence
	extends BasePersistence<RubricaContatto> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaContattoUtil} to access the rubrica contatto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaContatto> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE);

	/**
	 * Returns a range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByUtenteCreazioneContatto_First(
			long FK_UTENTE_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByUtenteCreazioneContatto_First(
		long FK_UTENTE_CREAZIONE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByUtenteCreazioneContatto_Last(
			long FK_UTENTE_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByUtenteCreazioneContatto_Last(
		long FK_UTENTE_CREAZIONE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto[] findByUtenteCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	public void removeByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE);

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica contattos
	 */
	public int countByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE);

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA);

	/**
	 * Returns a range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByUtenteModificaContatto_First(
			long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByUtenteModificaContatto_First(
		long FK_UTENTE_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByUtenteModificaContatto_Last(
			long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByUtenteModificaContatto_Last(
		long FK_UTENTE_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto[] findByUtenteModificaContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	public void removeByUtenteModificaContatto(long FK_UTENTE_MODIFICA);

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica contattos
	 */
	public int countByUtenteModificaContatto(long FK_UTENTE_MODIFICA);

	/**
	 * Returns all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoCanale(long FK_CANALE);

	/**
	 * Returns a range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_CANALE the fk_canale
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByContattoCanale_First(
			long FK_CANALE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByContattoCanale_First(
		long FK_CANALE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByContattoCanale_Last(
			long FK_CANALE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByContattoCanale_Last(
		long FK_CANALE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto[] findByContattoCanale_PrevAndNext(
			long ID_CONTATTO, long FK_CANALE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Removes all the rubrica contattos where FK_CANALE = &#63; from the database.
	 *
	 * @param FK_CANALE the fk_canale
	 */
	public void removeByContattoCanale(long FK_CANALE);

	/**
	 * Returns the number of rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the number of matching rubrica contattos
	 */
	public int countByContattoCanale(long FK_CANALE);

	/**
	 * Returns all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO);

	/**
	 * Returns a range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByContattoNominativo_First(
			long FK_NOMINATIVO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByContattoNominativo_First(
		long FK_NOMINATIVO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByContattoNominativo_Last(
			long FK_NOMINATIVO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByContattoNominativo_Last(
		long FK_NOMINATIVO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto[] findByContattoNominativo_PrevAndNext(
			long ID_CONTATTO, long FK_NOMINATIVO,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Removes all the rubrica contattos where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	public void removeByContattoNominativo(long FK_NOMINATIVO);

	/**
	 * Returns the number of rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica contattos
	 */
	public int countByContattoNominativo(long FK_NOMINATIVO);

	/**
	 * Returns all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE);

	/**
	 * Returns a range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByDataCreazioneContatto_First(
			Date DATA_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByDataCreazioneContatto_First(
		Date DATA_CREAZIONE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByDataCreazioneContatto_Last(
			Date DATA_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByDataCreazioneContatto_Last(
		Date DATA_CREAZIONE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto[] findByDataCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_CREAZIONE,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Removes all the rubrica contattos where DATA_CREAZIONE = &#63; from the database.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 */
	public void removeByDataCreazioneContatto(Date DATA_CREAZIONE);

	/**
	 * Returns the number of rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the number of matching rubrica contattos
	 */
	public int countByDataCreazioneContatto(Date DATA_CREAZIONE);

	/**
	 * Returns all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA);

	/**
	 * Returns a range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica contattos
	 */
	public java.util.List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByDataModificaContatto_First(
			Date DATA_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByDataModificaContatto_First(
		Date DATA_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public RubricaContatto findByDataModificaContatto_Last(
			Date DATA_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public RubricaContatto fetchByDataModificaContatto_Last(
		Date DATA_MODIFICA,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto[] findByDataModificaContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_MODIFICA,
			com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
				orderByComparator)
		throws NoSuchRubricaContattoException;

	/**
	 * Removes all the rubrica contattos where DATA_MODIFICA = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 */
	public void removeByDataModificaContatto(Date DATA_MODIFICA);

	/**
	 * Returns the number of rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the number of matching rubrica contattos
	 */
	public int countByDataModificaContatto(Date DATA_MODIFICA);

	/**
	 * Caches the rubrica contatto in the entity cache if it is enabled.
	 *
	 * @param rubricaContatto the rubrica contatto
	 */
	public void cacheResult(RubricaContatto rubricaContatto);

	/**
	 * Caches the rubrica contattos in the entity cache if it is enabled.
	 *
	 * @param rubricaContattos the rubrica contattos
	 */
	public void cacheResult(java.util.List<RubricaContatto> rubricaContattos);

	/**
	 * Creates a new rubrica contatto with the primary key. Does not add the rubrica contatto to the database.
	 *
	 * @param ID_CONTATTO the primary key for the new rubrica contatto
	 * @return the new rubrica contatto
	 */
	public RubricaContatto create(long ID_CONTATTO);

	/**
	 * Removes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto remove(long ID_CONTATTO)
		throws NoSuchRubricaContattoException;

	public RubricaContatto updateImpl(RubricaContatto rubricaContatto);

	/**
	 * Returns the rubrica contatto with the primary key or throws a <code>NoSuchRubricaContattoException</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto findByPrimaryKey(long ID_CONTATTO)
		throws NoSuchRubricaContattoException;

	/**
	 * Returns the rubrica contatto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto, or <code>null</code> if a rubrica contatto with the primary key could not be found
	 */
	public RubricaContatto fetchByPrimaryKey(long ID_CONTATTO);

	/**
	 * Returns all the rubrica contattos.
	 *
	 * @return the rubrica contattos
	 */
	public java.util.List<RubricaContatto> findAll();

	/**
	 * Returns a range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @return the range of rubrica contattos
	 */
	public java.util.List<RubricaContatto> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica contattos
	 */
	public java.util.List<RubricaContatto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica contattos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaContattoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica contattos
	 * @param end the upper bound of the range of rubrica contattos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica contattos
	 */
	public java.util.List<RubricaContatto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaContatto>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica contattos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica contattos.
	 *
	 * @return the number of rubrica contattos
	 */
	public int countAll();

}