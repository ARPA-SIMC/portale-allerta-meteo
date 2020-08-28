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

import it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException;
import it.eng.allerte.model.RubricaRuoloPermessi;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica ruolo permessi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiUtil
 * @generated
 */
@ProviderType
public interface RubricaRuoloPermessiPersistence
	extends BasePersistence<RubricaRuoloPermessi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaRuoloPermessiUtil} to access the rubrica ruolo permessi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaRuoloPermessi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the matching rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO);

	/**
	 * Returns a range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of matching rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloPermessi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloPermessi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	public RubricaRuoloPermessi findByRubricaPermessiByRuolo_First(
			long FK_ID_RUOLO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException;

	/**
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	public RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_First(
		long FK_ID_RUOLO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloPermessi>
			orderByComparator);

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	public RubricaRuoloPermessi findByRubricaPermessiByRuolo_Last(
			long FK_ID_RUOLO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException;

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	public RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_Last(
		long FK_ID_RUOLO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloPermessi>
			orderByComparator);

	/**
	 * Returns the rubrica ruolo permessis before and after the current rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the current rubrica ruolo permessi
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public RubricaRuoloPermessi[] findByRubricaPermessiByRuolo_PrevAndNext(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK,
			long FK_ID_RUOLO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaRuoloPermessi> orderByComparator)
		throws NoSuchRubricaRuoloPermessiException;

	/**
	 * Removes all the rubrica ruolo permessis where FK_ID_RUOLO = &#63; from the database.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 */
	public void removeByRubricaPermessiByRuolo(long FK_ID_RUOLO);

	/**
	 * Returns the number of rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the number of matching rubrica ruolo permessis
	 */
	public int countByRubricaPermessiByRuolo(long FK_ID_RUOLO);

	/**
	 * Caches the rubrica ruolo permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 */
	public void cacheResult(RubricaRuoloPermessi rubricaRuoloPermessi);

	/**
	 * Caches the rubrica ruolo permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessis the rubrica ruolo permessis
	 */
	public void cacheResult(
		java.util.List<RubricaRuoloPermessi> rubricaRuoloPermessis);

	/**
	 * Creates a new rubrica ruolo permessi with the primary key. Does not add the rubrica ruolo permessi to the database.
	 *
	 * @param rubricaRuoloPermessiPK the primary key for the new rubrica ruolo permessi
	 * @return the new rubrica ruolo permessi
	 */
	public RubricaRuoloPermessi create(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
			rubricaRuoloPermessiPK);

	/**
	 * Removes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public RubricaRuoloPermessi remove(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK)
		throws NoSuchRubricaRuoloPermessiException;

	public RubricaRuoloPermessi updateImpl(
		RubricaRuoloPermessi rubricaRuoloPermessi);

	/**
	 * Returns the rubrica ruolo permessi with the primary key or throws a <code>NoSuchRubricaRuoloPermessiException</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public RubricaRuoloPermessi findByPrimaryKey(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK)
		throws NoSuchRubricaRuoloPermessiException;

	/**
	 * Returns the rubrica ruolo permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi, or <code>null</code> if a rubrica ruolo permessi with the primary key could not be found
	 */
	public RubricaRuoloPermessi fetchByPrimaryKey(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
			rubricaRuoloPermessiPK);

	/**
	 * Returns all the rubrica ruolo permessis.
	 *
	 * @return the rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findAll();

	/**
	 * Returns a range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloPermessi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolo permessis
	 */
	public java.util.List<RubricaRuoloPermessi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloPermessi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica ruolo permessis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica ruolo permessis.
	 *
	 * @return the number of rubrica ruolo permessis
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}