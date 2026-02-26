/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animazione.image.exception.NoSuchaltezzaOndaException;
import it.eng.animazione.image.model.altezzaOnda;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the altezza onda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaUtil
 * @generated
 */
@ProviderType
public interface altezzaOndaPersistence extends BasePersistence<altezzaOnda> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link altezzaOndaUtil} to access the altezza onda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the altezza onda in the entity cache if it is enabled.
	 *
	 * @param altezzaOnda the altezza onda
	 */
	public void cacheResult(altezzaOnda altezzaOnda);

	/**
	 * Caches the altezza ondas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndas the altezza ondas
	 */
	public void cacheResult(java.util.List<altezzaOnda> altezzaOndas);

	/**
	 * Creates a new altezza onda with the primary key. Does not add the altezza onda to the database.
	 *
	 * @param id the primary key for the new altezza onda
	 * @return the new altezza onda
	 */
	public altezzaOnda create(long id);

	/**
	 * Removes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	public altezzaOnda remove(long id) throws NoSuchaltezzaOndaException;

	public altezzaOnda updateImpl(altezzaOnda altezzaOnda);

	/**
	 * Returns the altezza onda with the primary key or throws a <code>NoSuchaltezzaOndaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	public altezzaOnda findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaException;

	/**
	 * Returns the altezza onda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda, or <code>null</code> if a altezza onda with the primary key could not be found
	 */
	public altezzaOnda fetchByPrimaryKey(long id);

	/**
	 * Returns all the altezza ondas.
	 *
	 * @return the altezza ondas
	 */
	public java.util.List<altezzaOnda> findAll();

	/**
	 * Returns a range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @return the range of altezza ondas
	 */
	public java.util.List<altezzaOnda> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza ondas
	 */
	public java.util.List<altezzaOnda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<altezzaOnda>
			orderByComparator);

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza ondas
	 */
	public java.util.List<altezzaOnda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<altezzaOnda>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the altezza ondas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of altezza ondas.
	 *
	 * @return the number of altezza ondas
	 */
	public int countAll();

}