/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaCanaleException;
import it.eng.allerte.model.RubricaCanale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rubrica canale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCanaleUtil
 * @generated
 */
@ProviderType
public interface RubricaCanalePersistence
	extends BasePersistence<RubricaCanale> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaCanaleUtil} to access the rubrica canale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the rubrica canale in the entity cache if it is enabled.
	 *
	 * @param rubricaCanale the rubrica canale
	 */
	public void cacheResult(RubricaCanale rubricaCanale);

	/**
	 * Caches the rubrica canales in the entity cache if it is enabled.
	 *
	 * @param rubricaCanales the rubrica canales
	 */
	public void cacheResult(java.util.List<RubricaCanale> rubricaCanales);

	/**
	 * Creates a new rubrica canale with the primary key. Does not add the rubrica canale to the database.
	 *
	 * @param ID_CANALE the primary key for the new rubrica canale
	 * @return the new rubrica canale
	 */
	public RubricaCanale create(long ID_CANALE);

	/**
	 * Removes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	public RubricaCanale remove(long ID_CANALE)
		throws NoSuchRubricaCanaleException;

	public RubricaCanale updateImpl(RubricaCanale rubricaCanale);

	/**
	 * Returns the rubrica canale with the primary key or throws a <code>NoSuchRubricaCanaleException</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	public RubricaCanale findByPrimaryKey(long ID_CANALE)
		throws NoSuchRubricaCanaleException;

	/**
	 * Returns the rubrica canale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale, or <code>null</code> if a rubrica canale with the primary key could not be found
	 */
	public RubricaCanale fetchByPrimaryKey(long ID_CANALE);

	/**
	 * Returns all the rubrica canales.
	 *
	 * @return the rubrica canales
	 */
	public java.util.List<RubricaCanale> findAll();

	/**
	 * Returns a range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @return the range of rubrica canales
	 */
	public java.util.List<RubricaCanale> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica canales
	 */
	public java.util.List<RubricaCanale> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaCanale>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica canales
	 */
	public java.util.List<RubricaCanale> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaCanale>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rubrica canales from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica canales.
	 *
	 * @return the number of rubrica canales
	 */
	public int countAll();

}