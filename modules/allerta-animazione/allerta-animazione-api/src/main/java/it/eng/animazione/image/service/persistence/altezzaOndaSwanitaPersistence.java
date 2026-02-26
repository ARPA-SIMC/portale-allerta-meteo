/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animazione.image.exception.NoSuchaltezzaOndaSwanitaException;
import it.eng.animazione.image.model.altezzaOndaSwanita;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the altezza onda swanita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaSwanitaUtil
 * @generated
 */
@ProviderType
public interface altezzaOndaSwanitaPersistence
	extends BasePersistence<altezzaOndaSwanita> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link altezzaOndaSwanitaUtil} to access the altezza onda swanita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the altezza onda swanita in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 */
	public void cacheResult(altezzaOndaSwanita altezzaOndaSwanita);

	/**
	 * Caches the altezza onda swanitas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanitas the altezza onda swanitas
	 */
	public void cacheResult(
		java.util.List<altezzaOndaSwanita> altezzaOndaSwanitas);

	/**
	 * Creates a new altezza onda swanita with the primary key. Does not add the altezza onda swanita to the database.
	 *
	 * @param id the primary key for the new altezza onda swanita
	 * @return the new altezza onda swanita
	 */
	public altezzaOndaSwanita create(long id);

	/**
	 * Removes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	public altezzaOndaSwanita remove(long id)
		throws NoSuchaltezzaOndaSwanitaException;

	public altezzaOndaSwanita updateImpl(altezzaOndaSwanita altezzaOndaSwanita);

	/**
	 * Returns the altezza onda swanita with the primary key or throws a <code>NoSuchaltezzaOndaSwanitaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	public altezzaOndaSwanita findByPrimaryKey(long id)
		throws NoSuchaltezzaOndaSwanitaException;

	/**
	 * Returns the altezza onda swanita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita, or <code>null</code> if a altezza onda swanita with the primary key could not be found
	 */
	public altezzaOndaSwanita fetchByPrimaryKey(long id);

	/**
	 * Returns all the altezza onda swanitas.
	 *
	 * @return the altezza onda swanitas
	 */
	public java.util.List<altezzaOndaSwanita> findAll();

	/**
	 * Returns a range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @return the range of altezza onda swanitas
	 */
	public java.util.List<altezzaOndaSwanita> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda swanitas
	 */
	public java.util.List<altezzaOndaSwanita> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<altezzaOndaSwanita>
			orderByComparator);

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza onda swanitas
	 */
	public java.util.List<altezzaOndaSwanita> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<altezzaOndaSwanita>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the altezza onda swanitas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of altezza onda swanitas.
	 *
	 * @return the number of altezza onda swanitas
	 */
	public int countAll();

}