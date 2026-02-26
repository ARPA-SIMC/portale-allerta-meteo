/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animazione.image.exception.NoSuchaltezzaOndaAdriacException;
import it.eng.animazione.image.model.altezzaOndaAdriac;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the altezza onda adriac service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaAdriacUtil
 * @generated
 */
@ProviderType
public interface altezzaOndaAdriacPersistence
	extends BasePersistence<altezzaOndaAdriac> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link altezzaOndaAdriacUtil} to access the altezza onda adriac persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the altezza onda adriac in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 */
	public void cacheResult(altezzaOndaAdriac altezzaOndaAdriac);

	/**
	 * Caches the altezza onda adriacs in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriacs the altezza onda adriacs
	 */
	public void cacheResult(
		java.util.List<altezzaOndaAdriac> altezzaOndaAdriacs);

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	public altezzaOndaAdriac create(long id);

	/**
	 * Removes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	public altezzaOndaAdriac remove(long id)
		throws NoSuchaltezzaOndaAdriacException;

	public altezzaOndaAdriac updateImpl(altezzaOndaAdriac altezzaOndaAdriac);

	/**
	 * Returns the altezza onda adriac with the primary key or throws a <code>NoSuchaltezzaOndaAdriacException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	public altezzaOndaAdriac findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaAdriacException;

	/**
	 * Returns the altezza onda adriac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac, or <code>null</code> if a altezza onda adriac with the primary key could not be found
	 */
	public altezzaOndaAdriac fetchByPrimaryKey(long id);

	/**
	 * Returns all the altezza onda adriacs.
	 *
	 * @return the altezza onda adriacs
	 */
	public java.util.List<altezzaOndaAdriac> findAll();

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	public java.util.List<altezzaOndaAdriac> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda adriacs
	 */
	public java.util.List<altezzaOndaAdriac> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<altezzaOndaAdriac>
			orderByComparator);

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza onda adriacs
	 */
	public java.util.List<altezzaOndaAdriac> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<altezzaOndaAdriac>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the altezza onda adriacs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	public int countAll();

}