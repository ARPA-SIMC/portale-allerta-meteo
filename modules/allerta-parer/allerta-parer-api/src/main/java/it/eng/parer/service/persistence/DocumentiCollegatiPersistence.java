/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.parer.exception.NoSuchDocumentiCollegatiException;
import it.eng.parer.model.DocumentiCollegati;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the documenti collegati service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see DocumentiCollegatiUtil
 * @generated
 */
@ProviderType
public interface DocumentiCollegatiPersistence
	extends BasePersistence<DocumentiCollegati> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentiCollegatiUtil} to access the documenti collegati persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the matching documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO);

	/**
	 * Returns a range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of matching documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end);

	/**
	 * Returns an ordered range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documenti collegatis where ID_INVIO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param ID_INVIO the id_invio
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findByDocumentiCollegatiByIdInvio(
		long ID_INVIO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a matching documenti collegati could not be found
	 */
	public DocumentiCollegati findByDocumentiCollegatiByIdInvio_First(
			long ID_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
				orderByComparator)
		throws NoSuchDocumentiCollegatiException;

	/**
	 * Returns the first documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documenti collegati, or <code>null</code> if a matching documenti collegati could not be found
	 */
	public DocumentiCollegati fetchByDocumentiCollegatiByIdInvio_First(
		long ID_INVIO,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
			orderByComparator);

	/**
	 * Returns the last documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a matching documenti collegati could not be found
	 */
	public DocumentiCollegati findByDocumentiCollegatiByIdInvio_Last(
			long ID_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
				orderByComparator)
		throws NoSuchDocumentiCollegatiException;

	/**
	 * Returns the last documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documenti collegati, or <code>null</code> if a matching documenti collegati could not be found
	 */
	public DocumentiCollegati fetchByDocumentiCollegatiByIdInvio_Last(
		long ID_INVIO,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
			orderByComparator);

	/**
	 * Returns the documenti collegatis before and after the current documenti collegati in the ordered set where ID_INVIO = &#63;.
	 *
	 * @param documentiCollegatiPK the primary key of the current documenti collegati
	 * @param ID_INVIO the id_invio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	public DocumentiCollegati[] findByDocumentiCollegatiByIdInvio_PrevAndNext(
			DocumentiCollegatiPK documentiCollegatiPK, long ID_INVIO,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
				orderByComparator)
		throws NoSuchDocumentiCollegatiException;

	/**
	 * Removes all the documenti collegatis where ID_INVIO = &#63; from the database.
	 *
	 * @param ID_INVIO the id_invio
	 */
	public void removeByDocumentiCollegatiByIdInvio(long ID_INVIO);

	/**
	 * Returns the number of documenti collegatis where ID_INVIO = &#63;.
	 *
	 * @param ID_INVIO the id_invio
	 * @return the number of matching documenti collegatis
	 */
	public int countByDocumentiCollegatiByIdInvio(long ID_INVIO);

	/**
	 * Caches the documenti collegati in the entity cache if it is enabled.
	 *
	 * @param documentiCollegati the documenti collegati
	 */
	public void cacheResult(DocumentiCollegati documentiCollegati);

	/**
	 * Caches the documenti collegatis in the entity cache if it is enabled.
	 *
	 * @param documentiCollegatis the documenti collegatis
	 */
	public void cacheResult(
		java.util.List<DocumentiCollegati> documentiCollegatis);

	/**
	 * Creates a new documenti collegati with the primary key. Does not add the documenti collegati to the database.
	 *
	 * @param documentiCollegatiPK the primary key for the new documenti collegati
	 * @return the new documenti collegati
	 */
	public DocumentiCollegati create(DocumentiCollegatiPK documentiCollegatiPK);

	/**
	 * Removes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	public DocumentiCollegati remove(DocumentiCollegatiPK documentiCollegatiPK)
		throws NoSuchDocumentiCollegatiException;

	public DocumentiCollegati updateImpl(DocumentiCollegati documentiCollegati);

	/**
	 * Returns the documenti collegati with the primary key or throws a <code>NoSuchDocumentiCollegatiException</code> if it could not be found.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati
	 * @throws NoSuchDocumentiCollegatiException if a documenti collegati with the primary key could not be found
	 */
	public DocumentiCollegati findByPrimaryKey(
			DocumentiCollegatiPK documentiCollegatiPK)
		throws NoSuchDocumentiCollegatiException;

	/**
	 * Returns the documenti collegati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati, or <code>null</code> if a documenti collegati with the primary key could not be found
	 */
	public DocumentiCollegati fetchByPrimaryKey(
		DocumentiCollegatiPK documentiCollegatiPK);

	/**
	 * Returns all the documenti collegatis.
	 *
	 * @return the documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findAll();

	/**
	 * Returns a range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentiCollegatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of documenti collegatis
	 */
	public java.util.List<DocumentiCollegati> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentiCollegati>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the documenti collegatis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of documenti collegatis.
	 *
	 * @return the number of documenti collegatis
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}