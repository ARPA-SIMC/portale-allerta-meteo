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

import it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException;
import it.eng.allerte.model.RubricaGruppoNominativi;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica gruppo nominativi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiUtil
 * @generated
 */
@ProviderType
public interface RubricaGruppoNominativiPersistence
	extends BasePersistence<RubricaGruppoNominativi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaGruppoNominativiUtil} to access the rubrica gruppo nominativi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaGruppoNominativi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO);

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(
			long FK_NOMINATIVO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(
			long FK_NOMINATIVO, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByNominativo(
			long FK_NOMINATIVO, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator,
			boolean retrieveFromCache);

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByNominativo_First(
			long FK_NOMINATIVO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByNominativo_First(
		long FK_NOMINATIVO,
		com.liferay.portal.kernel.util.OrderByComparator
			<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByNominativo_Last(
			long FK_NOMINATIVO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByNominativo_Last(
		long FK_NOMINATIVO,
		com.liferay.portal.kernel.util.OrderByComparator
			<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_NOMINATIVO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByNominativo_PrevAndNext(
				it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
					rubricaGruppoNominativiPK,
				long FK_NOMINATIVO,
				com.liferay.portal.kernel.util.OrderByComparator
					<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Removes all the rubrica gruppo nominativis where FK_NOMINATIVO = &#63; from the database.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 */
	public void removeByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO);

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_NOMINATIVO = &#63;.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	public int countByRubricaGruppoRuoloByNominativo(long FK_NOMINATIVO);

	/**
	 * Returns all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(long FK_GRUPPO);

	/**
	 * Returns a range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(long FK_GRUPPO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(
			long FK_GRUPPO, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi>
		findByRubricaGruppoRuoloByGruppo(
			long FK_GRUPPO, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator,
			boolean retrieveFromCache);

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_First(
			long FK_GRUPPO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Returns the first rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByGruppo_First(
		long FK_GRUPPO,
		com.liferay.portal.kernel.util.OrderByComparator
			<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi findByRubricaGruppoRuoloByGruppo_Last(
			long FK_GRUPPO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Returns the last rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo nominativi, or <code>null</code> if a matching rubrica gruppo nominativi could not be found
	 */
	public RubricaGruppoNominativi fetchByRubricaGruppoRuoloByGruppo_Last(
		long FK_GRUPPO,
		com.liferay.portal.kernel.util.OrderByComparator
			<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns the rubrica gruppo nominativis before and after the current rubrica gruppo nominativi in the ordered set where FK_GRUPPO = &#63;.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the current rubrica gruppo nominativi
	 * @param FK_GRUPPO the fk_gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public RubricaGruppoNominativi[]
			findByRubricaGruppoRuoloByGruppo_PrevAndNext(
				it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
					rubricaGruppoNominativiPK,
				long FK_GRUPPO,
				com.liferay.portal.kernel.util.OrderByComparator
					<RubricaGruppoNominativi> orderByComparator)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Removes all the rubrica gruppo nominativis where FK_GRUPPO = &#63; from the database.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 */
	public void removeByRubricaGruppoRuoloByGruppo(long FK_GRUPPO);

	/**
	 * Returns the number of rubrica gruppo nominativis where FK_GRUPPO = &#63;.
	 *
	 * @param FK_GRUPPO the fk_gruppo
	 * @return the number of matching rubrica gruppo nominativis
	 */
	public int countByRubricaGruppoRuoloByGruppo(long FK_GRUPPO);

	/**
	 * Caches the rubrica gruppo nominativi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativi the rubrica gruppo nominativi
	 */
	public void cacheResult(RubricaGruppoNominativi rubricaGruppoNominativi);

	/**
	 * Caches the rubrica gruppo nominativis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoNominativis the rubrica gruppo nominativis
	 */
	public void cacheResult(
		java.util.List<RubricaGruppoNominativi> rubricaGruppoNominativis);

	/**
	 * Creates a new rubrica gruppo nominativi with the primary key. Does not add the rubrica gruppo nominativi to the database.
	 *
	 * @param rubricaGruppoNominativiPK the primary key for the new rubrica gruppo nominativi
	 * @return the new rubrica gruppo nominativi
	 */
	public RubricaGruppoNominativi create(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			rubricaGruppoNominativiPK);

	/**
	 * Removes the rubrica gruppo nominativi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi that was removed
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public RubricaGruppoNominativi remove(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK)
		throws NoSuchRubricaGruppoNominativiException;

	public RubricaGruppoNominativi updateImpl(
		RubricaGruppoNominativi rubricaGruppoNominativi);

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or throws a <code>NoSuchRubricaGruppoNominativiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi
	 * @throws NoSuchRubricaGruppoNominativiException if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public RubricaGruppoNominativi findByPrimaryKey(
			it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
				rubricaGruppoNominativiPK)
		throws NoSuchRubricaGruppoNominativiException;

	/**
	 * Returns the rubrica gruppo nominativi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoNominativiPK the primary key of the rubrica gruppo nominativi
	 * @return the rubrica gruppo nominativi, or <code>null</code> if a rubrica gruppo nominativi with the primary key could not be found
	 */
	public RubricaGruppoNominativi fetchByPrimaryKey(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			rubricaGruppoNominativiPK);

	/**
	 * Returns all the rubrica gruppo nominativis.
	 *
	 * @return the rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi> findAll();

	/**
	 * Returns a range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @return the range of rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RubricaGruppoNominativi> orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppo nominativis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoNominativiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo nominativis
	 * @param end the upper bound of the range of rubrica gruppo nominativis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppo nominativis
	 */
	public java.util.List<RubricaGruppoNominativi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RubricaGruppoNominativi> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica gruppo nominativis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica gruppo nominativis.
	 *
	 * @return the number of rubrica gruppo nominativis
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}