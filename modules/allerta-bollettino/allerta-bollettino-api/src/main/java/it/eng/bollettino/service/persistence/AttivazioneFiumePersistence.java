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

import it.eng.bollettino.exception.NoSuchAttivazioneFiumeException;
import it.eng.bollettino.model.AttivazioneFiume;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the attivazione fiume service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AttivazioneFiumeUtil
 * @generated
 */
@ProviderType
public interface AttivazioneFiumePersistence
	extends BasePersistence<AttivazioneFiume> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttivazioneFiumeUtil} to access the attivazione fiume persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AttivazioneFiume> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the attivazione fiume in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiume the attivazione fiume
	 */
	public void cacheResult(AttivazioneFiume attivazioneFiume);

	/**
	 * Caches the attivazione fiumes in the entity cache if it is enabled.
	 *
	 * @param attivazioneFiumes the attivazione fiumes
	 */
	public void cacheResult(java.util.List<AttivazioneFiume> attivazioneFiumes);

	/**
	 * Creates a new attivazione fiume with the primary key. Does not add the attivazione fiume to the database.
	 *
	 * @param fiumeId the primary key for the new attivazione fiume
	 * @return the new attivazione fiume
	 */
	public AttivazioneFiume create(String fiumeId);

	/**
	 * Removes the attivazione fiume with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume that was removed
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	public AttivazioneFiume remove(String fiumeId)
		throws NoSuchAttivazioneFiumeException;

	public AttivazioneFiume updateImpl(AttivazioneFiume attivazioneFiume);

	/**
	 * Returns the attivazione fiume with the primary key or throws a <code>NoSuchAttivazioneFiumeException</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume
	 * @throws NoSuchAttivazioneFiumeException if a attivazione fiume with the primary key could not be found
	 */
	public AttivazioneFiume findByPrimaryKey(String fiumeId)
		throws NoSuchAttivazioneFiumeException;

	/**
	 * Returns the attivazione fiume with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fiumeId the primary key of the attivazione fiume
	 * @return the attivazione fiume, or <code>null</code> if a attivazione fiume with the primary key could not be found
	 */
	public AttivazioneFiume fetchByPrimaryKey(String fiumeId);

	/**
	 * Returns all the attivazione fiumes.
	 *
	 * @return the attivazione fiumes
	 */
	public java.util.List<AttivazioneFiume> findAll();

	/**
	 * Returns a range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @return the range of attivazione fiumes
	 */
	public java.util.List<AttivazioneFiume> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivazione fiumes
	 */
	public java.util.List<AttivazioneFiume> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivazioneFiume>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attivazione fiumes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AttivazioneFiumeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivazione fiumes
	 * @param end the upper bound of the range of attivazione fiumes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of attivazione fiumes
	 */
	public java.util.List<AttivazioneFiume> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttivazioneFiume>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the attivazione fiumes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attivazione fiumes.
	 *
	 * @return the number of attivazione fiumes
	 */
	public int countAll();

}