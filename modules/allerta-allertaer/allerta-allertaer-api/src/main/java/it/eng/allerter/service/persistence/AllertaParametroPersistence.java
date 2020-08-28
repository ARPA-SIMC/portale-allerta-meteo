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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchAllertaParametroException;
import it.eng.allerter.model.AllertaParametro;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the allerta parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaParametroUtil
 * @generated
 */
@ProviderType
public interface AllertaParametroPersistence
	extends BasePersistence<AllertaParametro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllertaParametroUtil} to access the allerta parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AllertaParametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the allerta parametro in the entity cache if it is enabled.
	 *
	 * @param allertaParametro the allerta parametro
	 */
	public void cacheResult(AllertaParametro allertaParametro);

	/**
	 * Caches the allerta parametros in the entity cache if it is enabled.
	 *
	 * @param allertaParametros the allerta parametros
	 */
	public void cacheResult(java.util.List<AllertaParametro> allertaParametros);

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	public AllertaParametro create(String parametroId);

	/**
	 * Removes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	public AllertaParametro remove(String parametroId)
		throws NoSuchAllertaParametroException;

	public AllertaParametro updateImpl(AllertaParametro allertaParametro);

	/**
	 * Returns the allerta parametro with the primary key or throws a <code>NoSuchAllertaParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	public AllertaParametro findByPrimaryKey(String parametroId)
		throws NoSuchAllertaParametroException;

	/**
	 * Returns the allerta parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro, or <code>null</code> if a allerta parametro with the primary key could not be found
	 */
	public AllertaParametro fetchByPrimaryKey(String parametroId);

	/**
	 * Returns all the allerta parametros.
	 *
	 * @return the allerta parametros
	 */
	public java.util.List<AllertaParametro> findAll();

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	public java.util.List<AllertaParametro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta parametros
	 */
	public java.util.List<AllertaParametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaParametro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta parametros
	 */
	public java.util.List<AllertaParametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaParametro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the allerta parametros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	public int countAll();

}