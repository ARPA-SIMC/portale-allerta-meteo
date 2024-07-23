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

package allerta.catasto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.exception.NoSuchFonteException;
import allerta.catasto.model.Fonte;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the fonte service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FonteUtil
 * @generated
 */
@ProviderType
public interface FontePersistence extends BasePersistence<Fonte> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FonteUtil} to access the fonte persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Fonte> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the fonte in the entity cache if it is enabled.
	 *
	 * @param fonte the fonte
	 */
	public void cacheResult(Fonte fonte);

	/**
	 * Caches the fontes in the entity cache if it is enabled.
	 *
	 * @param fontes the fontes
	 */
	public void cacheResult(java.util.List<Fonte> fontes);

	/**
	 * Creates a new fonte with the primary key. Does not add the fonte to the database.
	 *
	 * @param id the primary key for the new fonte
	 * @return the new fonte
	 */
	public Fonte create(long id);

	/**
	 * Removes the fonte with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte that was removed
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	public Fonte remove(long id) throws NoSuchFonteException;

	public Fonte updateImpl(Fonte fonte);

	/**
	 * Returns the fonte with the primary key or throws a <code>NoSuchFonteException</code> if it could not be found.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	public Fonte findByPrimaryKey(long id) throws NoSuchFonteException;

	/**
	 * Returns the fonte with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte, or <code>null</code> if a fonte with the primary key could not be found
	 */
	public Fonte fetchByPrimaryKey(long id);

	/**
	 * Returns all the fontes.
	 *
	 * @return the fontes
	 */
	public java.util.List<Fonte> findAll();

	/**
	 * Returns a range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @return the range of fontes
	 */
	public java.util.List<Fonte> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fontes
	 */
	public java.util.List<Fonte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Fonte>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fontes
	 */
	public java.util.List<Fonte> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Fonte>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the fontes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fontes.
	 *
	 * @return the number of fontes
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}