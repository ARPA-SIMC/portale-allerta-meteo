/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaUtenteSitoException;
import it.eng.allerte.model.RubricaUtenteSito;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rubrica utente sito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoUtil
 * @generated
 */
@ProviderType
public interface RubricaUtenteSitoPersistence
	extends BasePersistence<RubricaUtenteSito> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaUtenteSitoUtil} to access the rubrica utente sito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the rubrica utente sito in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 */
	public void cacheResult(RubricaUtenteSito rubricaUtenteSito);

	/**
	 * Caches the rubrica utente sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSitos the rubrica utente sitos
	 */
	public void cacheResult(
		java.util.List<RubricaUtenteSito> rubricaUtenteSitos);

	/**
	 * Creates a new rubrica utente sito with the primary key. Does not add the rubrica utente sito to the database.
	 *
	 * @param ID_UTENTE the primary key for the new rubrica utente sito
	 * @return the new rubrica utente sito
	 */
	public RubricaUtenteSito create(long ID_UTENTE);

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	public RubricaUtenteSito remove(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException;

	public RubricaUtenteSito updateImpl(RubricaUtenteSito rubricaUtenteSito);

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>NoSuchRubricaUtenteSitoException</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	public RubricaUtenteSito findByPrimaryKey(long ID_UTENTE)
		throws NoSuchRubricaUtenteSitoException;

	/**
	 * Returns the rubrica utente sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito, or <code>null</code> if a rubrica utente sito with the primary key could not be found
	 */
	public RubricaUtenteSito fetchByPrimaryKey(long ID_UTENTE);

	/**
	 * Returns all the rubrica utente sitos.
	 *
	 * @return the rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll();

	/**
	 * Returns a range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @return the range of rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaUtenteSito>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica utente sitos
	 */
	public java.util.List<RubricaUtenteSito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaUtenteSito>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rubrica utente sitos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica utente sitos.
	 *
	 * @return the number of rubrica utente sitos
	 */
	public int countAll();

}