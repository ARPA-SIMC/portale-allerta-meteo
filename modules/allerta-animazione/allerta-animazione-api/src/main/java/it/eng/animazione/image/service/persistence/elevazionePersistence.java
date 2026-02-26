/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animazione.image.exception.NoSuchelevazioneException;
import it.eng.animazione.image.model.elevazione;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the elevazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see elevazioneUtil
 * @generated
 */
@ProviderType
public interface elevazionePersistence extends BasePersistence<elevazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link elevazioneUtil} to access the elevazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the elevazione in the entity cache if it is enabled.
	 *
	 * @param elevazione the elevazione
	 */
	public void cacheResult(elevazione elevazione);

	/**
	 * Caches the elevaziones in the entity cache if it is enabled.
	 *
	 * @param elevaziones the elevaziones
	 */
	public void cacheResult(java.util.List<elevazione> elevaziones);

	/**
	 * Creates a new elevazione with the primary key. Does not add the elevazione to the database.
	 *
	 * @param id the primary key for the new elevazione
	 * @return the new elevazione
	 */
	public elevazione create(long id);

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	public elevazione remove(long id) throws NoSuchelevazioneException;

	public elevazione updateImpl(elevazione elevazione);

	/**
	 * Returns the elevazione with the primary key or throws a <code>NoSuchelevazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	public elevazione findByPrimaryKey(long id)
		throws NoSuchelevazioneException;

	/**
	 * Returns the elevazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione, or <code>null</code> if a elevazione with the primary key could not be found
	 */
	public elevazione fetchByPrimaryKey(long id);

	/**
	 * Returns all the elevaziones.
	 *
	 * @return the elevaziones
	 */
	public java.util.List<elevazione> findAll();

	/**
	 * Returns a range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @return the range of elevaziones
	 */
	public java.util.List<elevazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of elevaziones
	 */
	public java.util.List<elevazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<elevazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of elevaziones
	 */
	public java.util.List<elevazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<elevazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the elevaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of elevaziones.
	 *
	 * @return the number of elevaziones
	 */
	public int countAll();

}