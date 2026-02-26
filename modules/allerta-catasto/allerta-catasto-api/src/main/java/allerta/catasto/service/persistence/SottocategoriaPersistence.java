/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence;

import allerta.catasto.exception.NoSuchSottocategoriaException;
import allerta.catasto.model.Sottocategoria;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sottocategoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SottocategoriaUtil
 * @generated
 */
@ProviderType
public interface SottocategoriaPersistence
	extends BasePersistence<Sottocategoria> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SottocategoriaUtil} to access the sottocategoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sottocategoria in the entity cache if it is enabled.
	 *
	 * @param sottocategoria the sottocategoria
	 */
	public void cacheResult(Sottocategoria sottocategoria);

	/**
	 * Caches the sottocategorias in the entity cache if it is enabled.
	 *
	 * @param sottocategorias the sottocategorias
	 */
	public void cacheResult(java.util.List<Sottocategoria> sottocategorias);

	/**
	 * Creates a new sottocategoria with the primary key. Does not add the sottocategoria to the database.
	 *
	 * @param sottocategoriaPK the primary key for the new sottocategoria
	 * @return the new sottocategoria
	 */
	public Sottocategoria create(SottocategoriaPK sottocategoriaPK);

	/**
	 * Removes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	public Sottocategoria remove(SottocategoriaPK sottocategoriaPK)
		throws NoSuchSottocategoriaException;

	public Sottocategoria updateImpl(Sottocategoria sottocategoria);

	/**
	 * Returns the sottocategoria with the primary key or throws a <code>NoSuchSottocategoriaException</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	public Sottocategoria findByPrimaryKey(SottocategoriaPK sottocategoriaPK)
		throws NoSuchSottocategoriaException;

	/**
	 * Returns the sottocategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria, or <code>null</code> if a sottocategoria with the primary key could not be found
	 */
	public Sottocategoria fetchByPrimaryKey(SottocategoriaPK sottocategoriaPK);

	/**
	 * Returns all the sottocategorias.
	 *
	 * @return the sottocategorias
	 */
	public java.util.List<Sottocategoria> findAll();

	/**
	 * Returns a range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @return the range of sottocategorias
	 */
	public java.util.List<Sottocategoria> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sottocategorias
	 */
	public java.util.List<Sottocategoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sottocategoria>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sottocategorias
	 */
	public java.util.List<Sottocategoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sottocategoria>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sottocategorias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sottocategorias.
	 *
	 * @return the number of sottocategorias
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}