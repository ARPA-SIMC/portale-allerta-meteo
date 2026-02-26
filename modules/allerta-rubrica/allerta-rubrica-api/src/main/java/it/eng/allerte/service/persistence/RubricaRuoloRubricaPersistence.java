/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaRuoloRubricaException;
import it.eng.allerte.model.RubricaRuoloRubrica;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rubrica ruolo rubrica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaUtil
 * @generated
 */
@ProviderType
public interface RubricaRuoloRubricaPersistence
	extends BasePersistence<RubricaRuoloRubrica> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaRuoloRubricaUtil} to access the rubrica ruolo rubrica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the rubrica ruolo rubrica in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 */
	public void cacheResult(RubricaRuoloRubrica rubricaRuoloRubrica);

	/**
	 * Caches the rubrica ruolo rubricas in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubricas the rubrica ruolo rubricas
	 */
	public void cacheResult(
		java.util.List<RubricaRuoloRubrica> rubricaRuoloRubricas);

	/**
	 * Creates a new rubrica ruolo rubrica with the primary key. Does not add the rubrica ruolo rubrica to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo rubrica
	 * @return the new rubrica ruolo rubrica
	 */
	public RubricaRuoloRubrica create(long ID_RUOLO);

	/**
	 * Removes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	public RubricaRuoloRubrica remove(long ID_RUOLO)
		throws NoSuchRubricaRuoloRubricaException;

	public RubricaRuoloRubrica updateImpl(
		RubricaRuoloRubrica rubricaRuoloRubrica);

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or throws a <code>NoSuchRubricaRuoloRubricaException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	public RubricaRuoloRubrica findByPrimaryKey(long ID_RUOLO)
		throws NoSuchRubricaRuoloRubricaException;

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica, or <code>null</code> if a rubrica ruolo rubrica with the primary key could not be found
	 */
	public RubricaRuoloRubrica fetchByPrimaryKey(long ID_RUOLO);

	/**
	 * Returns all the rubrica ruolo rubricas.
	 *
	 * @return the rubrica ruolo rubricas
	 */
	public java.util.List<RubricaRuoloRubrica> findAll();

	/**
	 * Returns a range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @return the range of rubrica ruolo rubricas
	 */
	public java.util.List<RubricaRuoloRubrica> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	public java.util.List<RubricaRuoloRubrica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloRubrica>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	public java.util.List<RubricaRuoloRubrica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaRuoloRubrica>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rubrica ruolo rubricas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica ruolo rubricas.
	 *
	 * @return the number of rubrica ruolo rubricas
	 */
	public int countAll();

}