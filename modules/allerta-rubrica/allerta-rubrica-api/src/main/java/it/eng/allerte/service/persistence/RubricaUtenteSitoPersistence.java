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

import it.eng.allerte.exception.NoSuchRubricaUtenteSitoException;
import it.eng.allerte.model.RubricaUtenteSito;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica utente sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoUtil
 * @generated
 */
@ProviderType
public interface RubricaUtenteSitoPersistence
	extends BasePersistence<RubricaUtenteSito> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaUtenteSitoUtil} to access the rubrica utente sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaUtenteSito> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the rubrica utente sito in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 */
	public void cacheResult(RubricaUtenteSito rubricaUtenteSito);

	/**
	 * Caches the rubrica utente sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSitos the rubrica utente sitos
	 */
	public void cacheResult(
		java.util.List<RubricaUtenteSito> rubricaUtenteSitos);

	/**
	 * Creates a new rubrica utente sito with the primary key. Does not add the rubrica utente sito to the database.
	 *
	 * @param ID_UTENTE the primary key for the new rubrica utente sito
	 * @return the new rubrica utente sito
	 */
	public RubricaUtenteSito create(long ID_UTENTE);

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	public RubricaUtenteSito remove(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException;

	public RubricaUtenteSito updateImpl(RubricaUtenteSito rubricaUtenteSito);

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>NoSuchRubricaUtenteSitoException</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	public RubricaUtenteSito findByPrimaryKey(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException;

	/**
	 * Returns the rubrica utente sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito, or <code>null</code> if a rubrica utente sito with the primary key could not be found
	 */
	public RubricaUtenteSito fetchByPrimaryKey(long ID_UTENTE);

	/**
	 * Returns all the rubrica utente sitos.
	 *
	 * @return the rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll();

	/**
	 * Returns a range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @return the range of rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaUtenteSito>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaUtenteSito>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica utente sitos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica utente sitos.
	 *
	 * @return the number of rubrica utente sitos
	 */
	public int countAll();

}