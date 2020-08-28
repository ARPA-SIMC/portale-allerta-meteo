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

package it.eng.bollettino.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchBollettinoParametroException;
import it.eng.bollettino.model.BollettinoParametro;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bollettino parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoParametroUtil
 * @generated
 */
@ProviderType
public interface BollettinoParametroPersistence
	extends BasePersistence<BollettinoParametro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BollettinoParametroUtil} to access the bollettino parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, BollettinoParametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the bollettino parametro in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametro the bollettino parametro
	 */
	public void cacheResult(BollettinoParametro bollettinoParametro);

	/**
	 * Caches the bollettino parametros in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametros the bollettino parametros
	 */
	public void cacheResult(
		java.util.List<BollettinoParametro> bollettinoParametros);

	/**
	 * Creates a new bollettino parametro with the primary key. Does not add the bollettino parametro to the database.
	 *
	 * @param parametroId the primary key for the new bollettino parametro
	 * @return the new bollettino parametro
	 */
	public BollettinoParametro create(String parametroId);

	/**
	 * Removes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	public BollettinoParametro remove(String parametroId)
		throws NoSuchBollettinoParametroException;

	public BollettinoParametro updateImpl(
		BollettinoParametro bollettinoParametro);

	/**
	 * Returns the bollettino parametro with the primary key or throws a <code>NoSuchBollettinoParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	public BollettinoParametro findByPrimaryKey(String parametroId)
		throws NoSuchBollettinoParametroException;

	/**
	 * Returns the bollettino parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro, or <code>null</code> if a bollettino parametro with the primary key could not be found
	 */
	public BollettinoParametro fetchByPrimaryKey(String parametroId);

	/**
	 * Returns all the bollettino parametros.
	 *
	 * @return the bollettino parametros
	 */
	public java.util.List<BollettinoParametro> findAll();

	/**
	 * Returns a range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @return the range of bollettino parametros
	 */
	public java.util.List<BollettinoParametro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino parametros
	 */
	public java.util.List<BollettinoParametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoParametro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino parametros
	 */
	public java.util.List<BollettinoParametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoParametro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bollettino parametros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bollettino parametros.
	 *
	 * @return the number of bollettino parametros
	 */
	public int countAll();

}