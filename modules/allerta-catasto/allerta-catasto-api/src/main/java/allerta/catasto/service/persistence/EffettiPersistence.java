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

import allerta.catasto.exception.NoSuchEffettiException;
import allerta.catasto.model.Effetti;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the effetti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiUtil
 * @generated
 */
@ProviderType
public interface EffettiPersistence extends BasePersistence<Effetti> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EffettiUtil} to access the effetti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Effetti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the effetti in the entity cache if it is enabled.
	 *
	 * @param effetti the effetti
	 */
	public void cacheResult(Effetti effetti);

	/**
	 * Caches the effettis in the entity cache if it is enabled.
	 *
	 * @param effettis the effettis
	 */
	public void cacheResult(java.util.List<Effetti> effettis);

	/**
	 * Creates a new effetti with the primary key. Does not add the effetti to the database.
	 *
	 * @param id the primary key for the new effetti
	 * @return the new effetti
	 */
	public Effetti create(long id);

	/**
	 * Removes the effetti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti that was removed
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	public Effetti remove(long id) throws NoSuchEffettiException;

	public Effetti updateImpl(Effetti effetti);

	/**
	 * Returns the effetti with the primary key or throws a <code>NoSuchEffettiException</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	public Effetti findByPrimaryKey(long id) throws NoSuchEffettiException;

	/**
	 * Returns the effetti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti, or <code>null</code> if a effetti with the primary key could not be found
	 */
	public Effetti fetchByPrimaryKey(long id);

	/**
	 * Returns all the effettis.
	 *
	 * @return the effettis
	 */
	public java.util.List<Effetti> findAll();

	/**
	 * Returns a range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @return the range of effettis
	 */
	public java.util.List<Effetti> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effettis
	 */
	public java.util.List<Effetti> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Effetti>
			orderByComparator);

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of effettis
	 */
	public java.util.List<Effetti> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Effetti>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the effettis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of effettis.
	 *
	 * @return the number of effettis
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}