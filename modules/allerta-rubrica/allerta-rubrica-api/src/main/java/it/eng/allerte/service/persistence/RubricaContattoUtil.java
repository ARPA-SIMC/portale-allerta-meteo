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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaContatto;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica contatto service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaContattoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaContattoPersistence
 * @generated
 */
@ProviderType
public class RubricaContattoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(RubricaContatto rubricaContatto) {
		getPersistence().clearCache(rubricaContatto);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, RubricaContatto> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaContatto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaContatto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaContatto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaContatto update(RubricaContatto rubricaContatto) {
		return getPersistence().update(rubricaContatto);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaContatto update(
		RubricaContatto rubricaContatto, ServiceContext serviceContext) {

		return getPersistence().update(rubricaContatto, serviceContext);
	}

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the matching rubrica contattos
	 */
	public static List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE) {

		return getPersistence().findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE);
	}

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
	public static List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end) {

		return getPersistence().findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end);
	}

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
	public static List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByUtenteCreazioneContatto_First(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByUtenteCreazioneContatto_First(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByUtenteCreazioneContatto_First(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByUtenteCreazioneContatto_First(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByUtenteCreazioneContatto_Last(
			long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByUtenteCreazioneContatto_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByUtenteCreazioneContatto_Last(
		long FK_UTENTE_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByUtenteCreazioneContatto_Last(
			FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto[] findByUtenteCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByUtenteCreazioneContatto_PrevAndNext(
			ID_CONTATTO, FK_UTENTE_CREAZIONE, orderByComparator);
	}

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_CREAZIONE = &#63; from the database.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 */
	public static void removeByUtenteCreazioneContatto(
		long FK_UTENTE_CREAZIONE) {

		getPersistence().removeByUtenteCreazioneContatto(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_CREAZIONE = &#63;.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione
	 * @return the number of matching rubrica contattos
	 */
	public static int countByUtenteCreazioneContatto(long FK_UTENTE_CREAZIONE) {
		return getPersistence().countByUtenteCreazioneContatto(
			FK_UTENTE_CREAZIONE);
	}

	/**
	 * Returns all the rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the matching rubrica contattos
	 */
	public static List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA) {

		return getPersistence().findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA);
	}

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
	public static List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end) {

		return getPersistence().findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end);
	}

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
	public static List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findByUtenteModificaContatto(
		long FK_UTENTE_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUtenteModificaContatto(
			FK_UTENTE_MODIFICA, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByUtenteModificaContatto_First(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByUtenteModificaContatto_First(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByUtenteModificaContatto_First(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByUtenteModificaContatto_First(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByUtenteModificaContatto_Last(
			long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByUtenteModificaContatto_Last(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByUtenteModificaContatto_Last(
		long FK_UTENTE_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByUtenteModificaContatto_Last(
			FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto[] findByUtenteModificaContatto_PrevAndNext(
			long ID_CONTATTO, long FK_UTENTE_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByUtenteModificaContatto_PrevAndNext(
			ID_CONTATTO, FK_UTENTE_MODIFICA, orderByComparator);
	}

	/**
	 * Removes all the rubrica contattos where FK_UTENTE_MODIFICA = &#63; from the database.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 */
	public static void removeByUtenteModificaContatto(long FK_UTENTE_MODIFICA) {
		getPersistence().removeByUtenteModificaContatto(FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns the number of rubrica contattos where FK_UTENTE_MODIFICA = &#63;.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica
	 * @return the number of matching rubrica contattos
	 */
	public static int countByUtenteModificaContatto(long FK_UTENTE_MODIFICA) {
		return getPersistence().countByUtenteModificaContatto(
			FK_UTENTE_MODIFICA);
	}

	/**
	 * Returns all the rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the matching rubrica contattos
	 */
	public static List<RubricaContatto> findByContattoCanale(long FK_CANALE) {
		return getPersistence().findByContattoCanale(FK_CANALE);
	}

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
	public static List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end) {

		return getPersistence().findByContattoCanale(FK_CANALE, start, end);
	}

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
	public static List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findByContattoCanale(
			FK_CANALE, start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findByContattoCanale(
		long FK_CANALE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByContattoCanale(
			FK_CANALE, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByContattoCanale_First(
			long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByContattoCanale_First(
			FK_CANALE, orderByComparator);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByContattoCanale_First(
		long FK_CANALE, OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByContattoCanale_First(
			FK_CANALE, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByContattoCanale_Last(
			long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByContattoCanale_Last(
			FK_CANALE, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByContattoCanale_Last(
		long FK_CANALE, OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByContattoCanale_Last(
			FK_CANALE, orderByComparator);
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_CANALE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_CANALE the fk_canale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto[] findByContattoCanale_PrevAndNext(
			long ID_CONTATTO, long FK_CANALE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByContattoCanale_PrevAndNext(
			ID_CONTATTO, FK_CANALE, orderByComparator);
	}

	/**
	 * Removes all the rubrica contattos where FK_CANALE = &#63; from the database.
	 *
	 * @param FK_CANALE the fk_canale
	 */
	public static void removeByContattoCanale(long FK_CANALE) {
		getPersistence().removeByContattoCanale(FK_CANALE);
	}

	/**
	 * Returns the number of rubrica contattos where FK_CANALE = &#63;.
	 *
	 * @param FK_CANALE the fk_canale
	 * @return the number of matching rubrica contattos
	 */
	public static int countByContattoCanale(long FK_CANALE) {
		return getPersistence().countByContattoCanale(FK_CANALE);
	}

	/**
	 * Returns all the rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica contattos
	 */
	public static List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO) {

		return getPersistence().findByContattoNominativo(FK_NOMINATIVO);
	}

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
	public static List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end) {

		return getPersistence().findByContattoNominativo(
			FK_NOMINATIVO, start, end);
	}

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
	public static List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findByContattoNominativo(
			FK_NOMINATIVO, start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findByContattoNominativo(
		long FK_NOMINATIVO, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByContattoNominativo(
			FK_NOMINATIVO, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByContattoNominativo_First(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByContattoNominativo_First(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByContattoNominativo_First(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByContattoNominativo_First(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByContattoNominativo_Last(
			long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByContattoNominativo_Last(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByContattoNominativo_Last(
		long FK_NOMINATIVO,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByContattoNominativo_Last(
			FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto[] findByContattoNominativo_PrevAndNext(
			long ID_CONTATTO, long FK_NOMINATIVO,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByContattoNominativo_PrevAndNext(
			ID_CONTATTO, FK_NOMINATIVO, orderByComparator);
	}

	/**
	 * Removes all the rubrica contattos where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	public static void removeByContattoNominativo(long FK_NOMINATIVO) {
		getPersistence().removeByContattoNominativo(FK_NOMINATIVO);
	}

	/**
	 * Returns the number of rubrica contattos where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica contattos
	 */
	public static int countByContattoNominativo(long FK_NOMINATIVO) {
		return getPersistence().countByContattoNominativo(FK_NOMINATIVO);
	}

	/**
	 * Returns all the rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the matching rubrica contattos
	 */
	public static List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE) {

		return getPersistence().findByDataCreazioneContatto(DATA_CREAZIONE);
	}

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
	public static List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end) {

		return getPersistence().findByDataCreazioneContatto(
			DATA_CREAZIONE, start, end);
	}

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
	public static List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findByDataCreazioneContatto(
			DATA_CREAZIONE, start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findByDataCreazioneContatto(
		Date DATA_CREAZIONE, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataCreazioneContatto(
			DATA_CREAZIONE, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByDataCreazioneContatto_First(
			Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByDataCreazioneContatto_First(
			DATA_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByDataCreazioneContatto_First(
		Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByDataCreazioneContatto_First(
			DATA_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByDataCreazioneContatto_Last(
			Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByDataCreazioneContatto_Last(
			DATA_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByDataCreazioneContatto_Last(
		Date DATA_CREAZIONE,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByDataCreazioneContatto_Last(
			DATA_CREAZIONE, orderByComparator);
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_CREAZIONE = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_CREAZIONE the data_creazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto[] findByDataCreazioneContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_CREAZIONE,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByDataCreazioneContatto_PrevAndNext(
			ID_CONTATTO, DATA_CREAZIONE, orderByComparator);
	}

	/**
	 * Removes all the rubrica contattos where DATA_CREAZIONE = &#63; from the database.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 */
	public static void removeByDataCreazioneContatto(Date DATA_CREAZIONE) {
		getPersistence().removeByDataCreazioneContatto(DATA_CREAZIONE);
	}

	/**
	 * Returns the number of rubrica contattos where DATA_CREAZIONE = &#63;.
	 *
	 * @param DATA_CREAZIONE the data_creazione
	 * @return the number of matching rubrica contattos
	 */
	public static int countByDataCreazioneContatto(Date DATA_CREAZIONE) {
		return getPersistence().countByDataCreazioneContatto(DATA_CREAZIONE);
	}

	/**
	 * Returns all the rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the matching rubrica contattos
	 */
	public static List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA) {

		return getPersistence().findByDataModificaContatto(DATA_MODIFICA);
	}

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
	public static List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end) {

		return getPersistence().findByDataModificaContatto(
			DATA_MODIFICA, start, end);
	}

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
	public static List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findByDataModificaContatto(
			DATA_MODIFICA, start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findByDataModificaContatto(
		Date DATA_MODIFICA, int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataModificaContatto(
			DATA_MODIFICA, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByDataModificaContatto_First(
			Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByDataModificaContatto_First(
			DATA_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the first rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByDataModificaContatto_First(
		Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByDataModificaContatto_First(
			DATA_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto
	 * @throws NoSuchRubricaContattoException if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto findByDataModificaContatto_Last(
			Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByDataModificaContatto_Last(
			DATA_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the last rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica contatto, or <code>null</code> if a matching rubrica contatto could not be found
	 */
	public static RubricaContatto fetchByDataModificaContatto_Last(
		Date DATA_MODIFICA,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().fetchByDataModificaContatto_Last(
			DATA_MODIFICA, orderByComparator);
	}

	/**
	 * Returns the rubrica contattos before and after the current rubrica contatto in the ordered set where DATA_MODIFICA = &#63;.
	 *
	 * @param ID_CONTATTO the primary key of the current rubrica contatto
	 * @param DATA_MODIFICA the data_modifica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto[] findByDataModificaContatto_PrevAndNext(
			long ID_CONTATTO, Date DATA_MODIFICA,
			OrderByComparator<RubricaContatto> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByDataModificaContatto_PrevAndNext(
			ID_CONTATTO, DATA_MODIFICA, orderByComparator);
	}

	/**
	 * Removes all the rubrica contattos where DATA_MODIFICA = &#63; from the database.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 */
	public static void removeByDataModificaContatto(Date DATA_MODIFICA) {
		getPersistence().removeByDataModificaContatto(DATA_MODIFICA);
	}

	/**
	 * Returns the number of rubrica contattos where DATA_MODIFICA = &#63;.
	 *
	 * @param DATA_MODIFICA the data_modifica
	 * @return the number of matching rubrica contattos
	 */
	public static int countByDataModificaContatto(Date DATA_MODIFICA) {
		return getPersistence().countByDataModificaContatto(DATA_MODIFICA);
	}

	/**
	 * Caches the rubrica contatto in the entity cache if it is enabled.
	 *
	 * @param rubricaContatto the rubrica contatto
	 */
	public static void cacheResult(RubricaContatto rubricaContatto) {
		getPersistence().cacheResult(rubricaContatto);
	}

	/**
	 * Caches the rubrica contattos in the entity cache if it is enabled.
	 *
	 * @param rubricaContattos the rubrica contattos
	 */
	public static void cacheResult(List<RubricaContatto> rubricaContattos) {
		getPersistence().cacheResult(rubricaContattos);
	}

	/**
	 * Creates a new rubrica contatto with the primary key. Does not add the rubrica contatto to the database.
	 *
	 * @param ID_CONTATTO the primary key for the new rubrica contatto
	 * @return the new rubrica contatto
	 */
	public static RubricaContatto create(long ID_CONTATTO) {
		return getPersistence().create(ID_CONTATTO);
	}

	/**
	 * Removes the rubrica contatto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto that was removed
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto remove(long ID_CONTATTO)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().remove(ID_CONTATTO);
	}

	public static RubricaContatto updateImpl(RubricaContatto rubricaContatto) {
		return getPersistence().updateImpl(rubricaContatto);
	}

	/**
	 * Returns the rubrica contatto with the primary key or throws a <code>NoSuchRubricaContattoException</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto
	 * @throws NoSuchRubricaContattoException if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto findByPrimaryKey(long ID_CONTATTO)
		throws it.eng.allerte.exception.NoSuchRubricaContattoException {

		return getPersistence().findByPrimaryKey(ID_CONTATTO);
	}

	/**
	 * Returns the rubrica contatto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CONTATTO the primary key of the rubrica contatto
	 * @return the rubrica contatto, or <code>null</code> if a rubrica contatto with the primary key could not be found
	 */
	public static RubricaContatto fetchByPrimaryKey(long ID_CONTATTO) {
		return getPersistence().fetchByPrimaryKey(ID_CONTATTO);
	}

	/**
	 * Returns all the rubrica contattos.
	 *
	 * @return the rubrica contattos
	 */
	public static List<RubricaContatto> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<RubricaContatto> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<RubricaContatto> findAll(
		int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<RubricaContatto> findAll(
		int start, int end,
		OrderByComparator<RubricaContatto> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica contattos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica contattos.
	 *
	 * @return the number of rubrica contattos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaContattoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaContattoPersistence, RubricaContattoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaContattoPersistence.class);

		ServiceTracker<RubricaContattoPersistence, RubricaContattoPersistence>
			serviceTracker =
				new ServiceTracker
					<RubricaContattoPersistence, RubricaContattoPersistence>(
						bundle.getBundleContext(),
						RubricaContattoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}