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

import it.eng.allerte.exception.NoSuchRubricaCategoriaException;
import it.eng.allerte.model.RubricaCategoria;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCategoriaUtil
 * @generated
 */
@ProviderType
public interface RubricaCategoriaPersistence
	extends BasePersistence<RubricaCategoria> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaCategoriaUtil} to access the rubrica categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaCategoria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the rubrica categoria in the entity cache if it is enabled.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 */
	public void cacheResult(RubricaCategoria rubricaCategoria);

	/**
	 * Caches the rubrica categorias in the entity cache if it is enabled.
	 *
	 * @param rubricaCategorias the rubrica categorias
	 */
	public void cacheResult(java.util.List<RubricaCategoria> rubricaCategorias);

	/**
	 * Creates a new rubrica categoria with the primary key. Does not add the rubrica categoria to the database.
	 *
	 * @param ID_CATEGORIA the primary key for the new rubrica categoria
	 * @return the new rubrica categoria
	 */
	public RubricaCategoria create(long ID_CATEGORIA);

	/**
	 * Removes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	public RubricaCategoria remove(long ID_CATEGORIA)
		throws NoSuchRubricaCategoriaException;

	public RubricaCategoria updateImpl(RubricaCategoria rubricaCategoria);

	/**
	 * Returns the rubrica categoria with the primary key or throws a <code>NoSuchRubricaCategoriaException</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	public RubricaCategoria findByPrimaryKey(long ID_CATEGORIA)
		throws NoSuchRubricaCategoriaException;

	/**
	 * Returns the rubrica categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria, or <code>null</code> if a rubrica categoria with the primary key could not be found
	 */
	public RubricaCategoria fetchByPrimaryKey(long ID_CATEGORIA);

	/**
	 * Returns all the rubrica categorias.
	 *
	 * @return the rubrica categorias
	 */
	public java.util.List<RubricaCategoria> findAll();

	/**
	 * Returns a range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @return the range of rubrica categorias
	 */
	public java.util.List<RubricaCategoria> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica categorias
	 */
	public java.util.List<RubricaCategoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaCategoria>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica categorias
	 */
	public java.util.List<RubricaCategoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaCategoria>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica categorias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica categorias.
	 *
	 * @return the number of rubrica categorias
	 */
	public int countAll();

}