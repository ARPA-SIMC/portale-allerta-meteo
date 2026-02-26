/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animazione.image.exception.NoSuchParametroException;
import it.eng.animazione.image.model.Parametro;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see ParametroUtil
 * @generated
 */
@ProviderType
public interface ParametroPersistence extends BasePersistence<Parametro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParametroUtil} to access the parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the parametro in the entity cache if it is enabled.
	 *
	 * @param parametro the parametro
	 */
	public void cacheResult(Parametro parametro);

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	public void cacheResult(java.util.List<Parametro> parametros);

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param key the primary key for the new parametro
	 * @return the new parametro
	 */
	public Parametro create(String key);

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	public Parametro remove(String key) throws NoSuchParametroException;

	public Parametro updateImpl(Parametro parametro);

	/**
	 * Returns the parametro with the primary key or throws a <code>NoSuchParametroException</code> if it could not be found.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro
	 * @throws NoSuchParametroException if a parametro with the primary key could not be found
	 */
	public Parametro findByPrimaryKey(String key)
		throws NoSuchParametroException;

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 */
	public Parametro fetchByPrimaryKey(String key);

	/**
	 * Returns all the parametros.
	 *
	 * @return the parametros
	 */
	public java.util.List<Parametro> findAll();

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 */
	public java.util.List<Parametro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametros
	 */
	public java.util.List<Parametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parametro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parametros
	 */
	public java.util.List<Parametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parametro>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the parametros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 */
	public int countAll();

}