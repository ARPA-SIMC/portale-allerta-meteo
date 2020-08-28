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

import it.eng.allerte.exception.NoSuchRubricaPermessiException;
import it.eng.allerte.model.RubricaPermessi;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica permessi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaPermessiUtil
 * @generated
 */
@ProviderType
public interface RubricaPermessiPersistence
	extends BasePersistence<RubricaPermessi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaPermessiUtil} to access the rubrica permessi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaPermessi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the rubrica permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessi the rubrica permessi
	 */
	public void cacheResult(RubricaPermessi rubricaPermessi);

	/**
	 * Caches the rubrica permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessis the rubrica permessis
	 */
	public void cacheResult(java.util.List<RubricaPermessi> rubricaPermessis);

	/**
	 * Creates a new rubrica permessi with the primary key. Does not add the rubrica permessi to the database.
	 *
	 * @param ID_PERMESSO the primary key for the new rubrica permessi
	 * @return the new rubrica permessi
	 */
	public RubricaPermessi create(String ID_PERMESSO);

	/**
	 * Removes the rubrica permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi that was removed
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	public RubricaPermessi remove(String ID_PERMESSO)
		throws NoSuchRubricaPermessiException;

	public RubricaPermessi updateImpl(RubricaPermessi rubricaPermessi);

	/**
	 * Returns the rubrica permessi with the primary key or throws a <code>NoSuchRubricaPermessiException</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	public RubricaPermessi findByPrimaryKey(String ID_PERMESSO)
		throws NoSuchRubricaPermessiException;

	/**
	 * Returns the rubrica permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi, or <code>null</code> if a rubrica permessi with the primary key could not be found
	 */
	public RubricaPermessi fetchByPrimaryKey(String ID_PERMESSO);

	/**
	 * Returns all the rubrica permessis.
	 *
	 * @return the rubrica permessis
	 */
	public java.util.List<RubricaPermessi> findAll();

	/**
	 * Returns a range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @return the range of rubrica permessis
	 */
	public java.util.List<RubricaPermessi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica permessis
	 */
	public java.util.List<RubricaPermessi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaPermessi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica permessis
	 */
	public java.util.List<RubricaPermessi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaPermessi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica permessis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica permessis.
	 *
	 * @return the number of rubrica permessis
	 */
	public int countAll();

}