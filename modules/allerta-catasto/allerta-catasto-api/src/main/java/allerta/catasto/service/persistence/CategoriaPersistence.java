/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence;

import allerta.catasto.exception.NoSuchCategoriaException;
import allerta.catasto.model.Categoria;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoriaUtil
 * @generated
 */
@ProviderType
public interface CategoriaPersistence extends BasePersistence<Categoria> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoriaUtil} to access the categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the categoria in the entity cache if it is enabled.
	 *
	 * @param categoria the categoria
	 */
	public void cacheResult(Categoria categoria);

	/**
	 * Caches the categorias in the entity cache if it is enabled.
	 *
	 * @param categorias the categorias
	 */
	public void cacheResult(java.util.List<Categoria> categorias);

	/**
	 * Creates a new categoria with the primary key. Does not add the categoria to the database.
	 *
	 * @param id the primary key for the new categoria
	 * @return the new categoria
	 */
	public Categoria create(long id);

	/**
	 * Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the categoria
	 * @return the categoria that was removed
	 * @throws NoSuchCategoriaException if a categoria with the primary key could not be found
	 */
	public Categoria remove(long id) throws NoSuchCategoriaException;

	public Categoria updateImpl(Categoria categoria);

	/**
	 * Returns the categoria with the primary key or throws a <code>NoSuchCategoriaException</code> if it could not be found.
	 *
	 * @param id the primary key of the categoria
	 * @return the categoria
	 * @throws NoSuchCategoriaException if a categoria with the primary key could not be found
	 */
	public Categoria findByPrimaryKey(long id) throws NoSuchCategoriaException;

	/**
	 * Returns the categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the categoria
	 * @return the categoria, or <code>null</code> if a categoria with the primary key could not be found
	 */
	public Categoria fetchByPrimaryKey(long id);

	/**
	 * Returns all the categorias.
	 *
	 * @return the categorias
	 */
	public java.util.List<Categoria> findAll();

	/**
	 * Returns a range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @return the range of categorias
	 */
	public java.util.List<Categoria> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categorias
	 */
	public java.util.List<Categoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Categoria>
			orderByComparator);

	/**
	 * Returns an ordered range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categorias
	 */
	public java.util.List<Categoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Categoria>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the categorias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of categorias.
	 *
	 * @return the number of categorias
	 */
	public int countAll();

}