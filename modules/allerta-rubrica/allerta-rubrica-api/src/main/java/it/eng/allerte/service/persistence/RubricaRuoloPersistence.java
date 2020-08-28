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

import it.eng.allerte.exception.NoSuchRubricaRuoloException;
import it.eng.allerte.model.RubricaRuolo;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica ruolo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloUtil
 * @generated
 */
@ProviderType
public interface RubricaRuoloPersistence extends BasePersistence<RubricaRuolo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaRuoloUtil} to access the rubrica ruolo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaRuolo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a matching rubrica ruolo could not be found
	 */
	public RubricaRuolo findByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY)
		throws NoSuchRubricaRuoloException;

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	public RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY);

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	public RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY, boolean retrieveFromCache);

	/**
	 * Removes the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; from the database.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the rubrica ruolo that was removed
	 */
	public RubricaRuolo removeByRubricaRuoloByRuoloLiferay(
			long FK_RUOLO_LIFERAY)
		throws NoSuchRubricaRuoloException;

	/**
	 * Returns the number of rubrica ruolos where FK_RUOLO_LIFERAY = &#63;.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the number of matching rubrica ruolos
	 */
	public int countByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY);

	/**
	 * Caches the rubrica ruolo in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 */
	public void cacheResult(RubricaRuolo rubricaRuolo);

	/**
	 * Caches the rubrica ruolos in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolos the rubrica ruolos
	 */
	public void cacheResult(java.util.List<RubricaRuolo> rubricaRuolos);

	/**
	 * Creates a new rubrica ruolo with the primary key. Does not add the rubrica ruolo to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo
	 * @return the new rubrica ruolo
	 */
	public RubricaRuolo create(long ID_RUOLO);

	/**
	 * Removes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	public RubricaRuolo remove(long ID_RUOLO)
		throws NoSuchRubricaRuoloException;

	public RubricaRuolo updateImpl(RubricaRuolo rubricaRuolo);

	/**
	 * Returns the rubrica ruolo with the primary key or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	public RubricaRuolo findByPrimaryKey(long ID_RUOLO)
		throws NoSuchRubricaRuoloException;

	/**
	 * Returns the rubrica ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo, or <code>null</code> if a rubrica ruolo with the primary key could not be found
	 */
	public RubricaRuolo fetchByPrimaryKey(long ID_RUOLO);

	/**
	 * Returns all the rubrica ruolos.
	 *
	 * @return the rubrica ruolos
	 */
	public java.util.List<RubricaRuolo> findAll();

	/**
	 * Returns a range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @return the range of rubrica ruolos
	 */
	public java.util.List<RubricaRuolo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolos
	 */
	public java.util.List<RubricaRuolo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuolo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolos
	 */
	public java.util.List<RubricaRuolo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuolo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica ruolos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica ruolos.
	 *
	 * @return the number of rubrica ruolos
	 */
	public int countAll();

}