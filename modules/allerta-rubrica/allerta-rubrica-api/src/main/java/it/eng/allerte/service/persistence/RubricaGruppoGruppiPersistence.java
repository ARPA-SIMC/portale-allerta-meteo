/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException;
import it.eng.allerte.model.RubricaGruppoGruppi;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rubrica gruppo gruppi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiUtil
 * @generated
 */
@ProviderType
public interface RubricaGruppoGruppiPersistence
	extends BasePersistence<RubricaGruppoGruppi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaGruppoGruppiUtil} to access the rubrica gruppo gruppi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @return the matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE);

	/**
	 * Returns a range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findByRubricaGruppoGruppoByPadre(
		long FK_GRUPPO_PADRE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByPadre_First(
			long FK_GRUPPO_PADRE,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByPadre_First(
		long FK_GRUPPO_PADRE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator);

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByPadre_Last(
			long FK_GRUPPO_PADRE,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByPadre_Last(
		long FK_GRUPPO_PADRE,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator);

	/**
	 * Returns the rubrica gruppo gruppis before and after the current rubrica gruppo gruppi in the ordered set where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the current rubrica gruppo gruppi
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public RubricaGruppoGruppi[] findByRubricaGruppoGruppoByPadre_PrevAndNext(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK, long FK_GRUPPO_PADRE,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Removes all the rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63; from the database.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 */
	public void removeByRubricaGruppoGruppoByPadre(long FK_GRUPPO_PADRE);

	/**
	 * Returns the number of rubrica gruppo gruppis where FK_GRUPPO_PADRE = &#63;.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre
	 * @return the number of matching rubrica gruppo gruppis
	 */
	public int countByRubricaGruppoGruppoByPadre(long FK_GRUPPO_PADRE);

	/**
	 * Returns all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @return the matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi>
		findByRubricaGruppoGruppoByFiglio(long FK_GRUPPO_FIGLIO);

	/**
	 * Returns a range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi>
		findByRubricaGruppoGruppoByFiglio(
			long FK_GRUPPO_FIGLIO, int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi>
		findByRubricaGruppoGruppoByFiglio(
			long FK_GRUPPO_FIGLIO, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi>
		findByRubricaGruppoGruppoByFiglio(
			long FK_GRUPPO_FIGLIO, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByFiglio_First(
			long FK_GRUPPO_FIGLIO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Returns the first rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByFiglio_First(
		long FK_GRUPPO_FIGLIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator);

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi findByRubricaGruppoGruppoByFiglio_Last(
			long FK_GRUPPO_FIGLIO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Returns the last rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica gruppo gruppi, or <code>null</code> if a matching rubrica gruppo gruppi could not be found
	 */
	public RubricaGruppoGruppi fetchByRubricaGruppoGruppoByFiglio_Last(
		long FK_GRUPPO_FIGLIO,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator);

	/**
	 * Returns the rubrica gruppo gruppis before and after the current rubrica gruppo gruppi in the ordered set where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the current rubrica gruppo gruppi
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public RubricaGruppoGruppi[] findByRubricaGruppoGruppoByFiglio_PrevAndNext(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK, long FK_GRUPPO_FIGLIO,
			com.liferay.portal.kernel.util.OrderByComparator
				<RubricaGruppoGruppi> orderByComparator)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Removes all the rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63; from the database.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 */
	public void removeByRubricaGruppoGruppoByFiglio(long FK_GRUPPO_FIGLIO);

	/**
	 * Returns the number of rubrica gruppo gruppis where FK_GRUPPO_FIGLIO = &#63;.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio
	 * @return the number of matching rubrica gruppo gruppis
	 */
	public int countByRubricaGruppoGruppoByFiglio(long FK_GRUPPO_FIGLIO);

	/**
	 * Caches the rubrica gruppo gruppi in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoGruppi the rubrica gruppo gruppi
	 */
	public void cacheResult(RubricaGruppoGruppi rubricaGruppoGruppi);

	/**
	 * Caches the rubrica gruppo gruppis in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppoGruppis the rubrica gruppo gruppis
	 */
	public void cacheResult(
		java.util.List<RubricaGruppoGruppi> rubricaGruppoGruppis);

	/**
	 * Creates a new rubrica gruppo gruppi with the primary key. Does not add the rubrica gruppo gruppi to the database.
	 *
	 * @param rubricaGruppoGruppiPK the primary key for the new rubrica gruppo gruppi
	 * @return the new rubrica gruppo gruppi
	 */
	public RubricaGruppoGruppi create(
		RubricaGruppoGruppiPK rubricaGruppoGruppiPK);

	/**
	 * Removes the rubrica gruppo gruppi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi that was removed
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public RubricaGruppoGruppi remove(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK)
		throws NoSuchRubricaGruppoGruppiException;

	public RubricaGruppoGruppi updateImpl(
		RubricaGruppoGruppi rubricaGruppoGruppi);

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or throws a <code>NoSuchRubricaGruppoGruppiException</code> if it could not be found.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi
	 * @throws NoSuchRubricaGruppoGruppiException if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public RubricaGruppoGruppi findByPrimaryKey(
			RubricaGruppoGruppiPK rubricaGruppoGruppiPK)
		throws NoSuchRubricaGruppoGruppiException;

	/**
	 * Returns the rubrica gruppo gruppi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaGruppoGruppiPK the primary key of the rubrica gruppo gruppi
	 * @return the rubrica gruppo gruppi, or <code>null</code> if a rubrica gruppo gruppi with the primary key could not be found
	 */
	public RubricaGruppoGruppi fetchByPrimaryKey(
		RubricaGruppoGruppiPK rubricaGruppoGruppiPK);

	/**
	 * Returns all the rubrica gruppo gruppis.
	 *
	 * @return the rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findAll();

	/**
	 * Returns a range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @return the range of rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppo gruppis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaGruppoGruppiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppo gruppis
	 * @param end the upper bound of the range of rubrica gruppo gruppis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica gruppo gruppis
	 */
	public java.util.List<RubricaGruppoGruppi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppoGruppi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rubrica gruppo gruppis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica gruppo gruppis.
	 *
	 * @return the number of rubrica gruppo gruppis
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}