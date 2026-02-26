/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.parer.exception.NoSuchComponentiInvioException;
import it.eng.parer.model.ComponentiInvio;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the componenti invio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see ComponentiInvioUtil
 * @generated
 */
@ProviderType
public interface ComponentiInvioPersistence
	extends BasePersistence<ComponentiInvio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComponentiInvioUtil} to access the componenti invio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the componenti invios where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the matching componenti invios
	 */
	public java.util.List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO);

	/**
	 * Returns a range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of matching componenti invios
	 */
	public java.util.List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end);

	/**
	 * Returns an ordered range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching componenti invios
	 */
	public java.util.List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the componenti invios where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching componenti invios
	 */
	public java.util.List<ComponentiInvio> findByComponentiByIdInvio(
		long ID_INVIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching componenti invio
	 * @throws NoSuchComponentiInvioException if a matching componenti invio could not be found
	 */
	public ComponentiInvio findByComponentiByIdInvio_First(
			long ID_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
				orderByComparator)
		throws NoSuchComponentiInvioException;

	/**
	 * Returns the first componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching componenti invio, or <code>null</code> if a matching componenti invio could not be found
	 */
	public ComponentiInvio fetchByComponentiByIdInvio_First(
		long ID_INVIO,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
			orderByComparator);

	/**
	 * Returns the last componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching componenti invio
	 * @throws NoSuchComponentiInvioException if a matching componenti invio could not be found
	 */
	public ComponentiInvio findByComponentiByIdInvio_Last(
			long ID_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
				orderByComparator)
		throws NoSuchComponentiInvioException;

	/**
	 * Returns the last componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching componenti invio, or <code>null</code> if a matching componenti invio could not be found
	 */
	public ComponentiInvio fetchByComponentiByIdInvio_Last(
		long ID_INVIO,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
			orderByComparator);

	/**
	 * Returns the componenti invios before and after the current componenti invio in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param componentiInvioPK the primary key of the current componenti invio
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	public ComponentiInvio[] findByComponentiByIdInvio_PrevAndNext(
			ComponentiInvioPK componentiInvioPK, long ID_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
				orderByComparator)
		throws NoSuchComponentiInvioException;

	/**
	 * Removes all the componenti invios where ID_INVIO = &#63; from the database.
	 *
	 * @param ID_INVIO the id_invio
	 */
	public void removeByComponentiByIdInvio(long ID_INVIO);

	/**
	 * Returns the number of componenti invios where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the number of matching componenti invios
	 */
	public int countByComponentiByIdInvio(long ID_INVIO);

	/**
	 * Caches the componenti invio in the entity cache if it is enabled.
	 *
	 * @param componentiInvio the componenti invio
	 */
	public void cacheResult(ComponentiInvio componentiInvio);

	/**
	 * Caches the componenti invios in the entity cache if it is enabled.
	 *
	 * @param componentiInvios the componenti invios
	 */
	public void cacheResult(java.util.List<ComponentiInvio> componentiInvios);

	/**
	 * Creates a new componenti invio with the primary key. Does not add the componenti invio to the database.
	 *
	 * @param componentiInvioPK the primary key for the new componenti invio
	 * @return the new componenti invio
	 */
	public ComponentiInvio create(ComponentiInvioPK componentiInvioPK);

	/**
	 * Removes the componenti invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio that was removed
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	public ComponentiInvio remove(ComponentiInvioPK componentiInvioPK)
		throws NoSuchComponentiInvioException;

	public ComponentiInvio updateImpl(ComponentiInvio componentiInvio);

	/**
	 * Returns the componenti invio with the primary key or throws a <code>NoSuchComponentiInvioException</code> if it could not be found.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio
	 * @throws NoSuchComponentiInvioException if a componenti invio with the primary key could not be found
	 */
	public ComponentiInvio findByPrimaryKey(ComponentiInvioPK componentiInvioPK)
		throws NoSuchComponentiInvioException;

	/**
	 * Returns the componenti invio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio, or <code>null</code> if a componenti invio with the primary key could not be found
	 */
	public ComponentiInvio fetchByPrimaryKey(
		ComponentiInvioPK componentiInvioPK);

	/**
	 * Returns all the componenti invios.
	 *
	 * @return the componenti invios
	 */
	public java.util.List<ComponentiInvio> findAll();

	/**
	 * Returns a range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of componenti invios
	 */
	public java.util.List<ComponentiInvio> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of componenti invios
	 */
	public java.util.List<ComponentiInvio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of componenti invios
	 */
	public java.util.List<ComponentiInvio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentiInvio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the componenti invios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of componenti invios.
	 *
	 * @return the number of componenti invios
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}