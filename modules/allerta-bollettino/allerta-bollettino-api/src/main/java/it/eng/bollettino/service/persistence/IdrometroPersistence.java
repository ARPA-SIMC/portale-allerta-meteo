/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.bollettino.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchIdrometroException;
import it.eng.bollettino.model.Idrometro;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the idrometro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see IdrometroUtil
 * @generated
 */
@ProviderType
public interface IdrometroPersistence extends BasePersistence<Idrometro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IdrometroUtil} to access the idrometro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Idrometro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeBacino(String nomeBacino);

	/**
	 * Returns a range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end);

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the idrometros where nomeBacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeBacino the nome bacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeBacino(
		String nomeBacino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public Idrometro findByNomeBacino_First(
			String nomeBacino,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Returns the first idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public Idrometro fetchByNomeBacino_First(
		String nomeBacino,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public Idrometro findByNomeBacino_Last(
			String nomeBacino,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Returns the last idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public Idrometro fetchByNomeBacino_Last(
		String nomeBacino,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeBacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeBacino the nome bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public Idrometro[] findByNomeBacino_PrevAndNext(
			String stazioneId, String nomeBacino,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Removes all the idrometros where nomeBacino = &#63; from the database.
	 *
	 * @param nomeBacino the nome bacino
	 */
	public void removeByNomeBacino(String nomeBacino);

	/**
	 * Returns the number of idrometros where nomeBacino = &#63;.
	 *
	 * @param nomeBacino the nome bacino
	 * @return the number of matching idrometros
	 */
	public int countByNomeBacino(String nomeBacino);

	/**
	 * Returns all the idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino);

	/**
	 * Returns a range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end);

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the idrometros where nomeSottobacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeSottobacino(
		String nomeSottobacino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public Idrometro findByNomeSottobacino_First(
			String nomeSottobacino,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Returns the first idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public Idrometro fetchByNomeSottobacino_First(
		String nomeSottobacino,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public Idrometro findByNomeSottobacino_Last(
			String nomeSottobacino,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Returns the last idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public Idrometro fetchByNomeSottobacino_Last(
		String nomeSottobacino,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeSottobacino = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeSottobacino the nome sottobacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public Idrometro[] findByNomeSottobacino_PrevAndNext(
			String stazioneId, String nomeSottobacino,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Removes all the idrometros where nomeSottobacino = &#63; from the database.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 */
	public void removeByNomeSottobacino(String nomeSottobacino);

	/**
	 * Returns the number of idrometros where nomeSottobacino = &#63;.
	 *
	 * @param nomeSottobacino the nome sottobacino
	 * @return the number of matching idrometros
	 */
	public int countByNomeSottobacino(String nomeSottobacino);

	/**
	 * Returns all the idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeRubrica(String nomeRubrica);

	/**
	 * Returns a range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end);

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the idrometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching idrometros
	 */
	public java.util.List<Idrometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public Idrometro findByNomeRubrica_First(
			String nomeRubrica,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Returns the first idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public Idrometro fetchByNomeRubrica_First(
		String nomeRubrica,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro
	 * @throws NoSuchIdrometroException if a matching idrometro could not be found
	 */
	public Idrometro findByNomeRubrica_Last(
			String nomeRubrica,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Returns the last idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching idrometro, or <code>null</code> if a matching idrometro could not be found
	 */
	public Idrometro fetchByNomeRubrica_Last(
		String nomeRubrica,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns the idrometros before and after the current idrometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current idrometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public Idrometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
				orderByComparator)
		throws NoSuchIdrometroException;

	/**
	 * Removes all the idrometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	public void removeByNomeRubrica(String nomeRubrica);

	/**
	 * Returns the number of idrometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching idrometros
	 */
	public int countByNomeRubrica(String nomeRubrica);

	/**
	 * Caches the idrometro in the entity cache if it is enabled.
	 *
	 * @param idrometro the idrometro
	 */
	public void cacheResult(Idrometro idrometro);

	/**
	 * Caches the idrometros in the entity cache if it is enabled.
	 *
	 * @param idrometros the idrometros
	 */
	public void cacheResult(java.util.List<Idrometro> idrometros);

	/**
	 * Creates a new idrometro with the primary key. Does not add the idrometro to the database.
	 *
	 * @param stazioneId the primary key for the new idrometro
	 * @return the new idrometro
	 */
	public Idrometro create(String stazioneId);

	/**
	 * Removes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public Idrometro remove(String stazioneId) throws NoSuchIdrometroException;

	public Idrometro updateImpl(Idrometro idrometro);

	/**
	 * Returns the idrometro with the primary key or throws a <code>NoSuchIdrometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro
	 * @throws NoSuchIdrometroException if a idrometro with the primary key could not be found
	 */
	public Idrometro findByPrimaryKey(String stazioneId)
		throws NoSuchIdrometroException;

	/**
	 * Returns the idrometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro, or <code>null</code> if a idrometro with the primary key could not be found
	 */
	public Idrometro fetchByPrimaryKey(String stazioneId);

	/**
	 * Returns all the idrometros.
	 *
	 * @return the idrometros
	 */
	public java.util.List<Idrometro> findAll();

	/**
	 * Returns a range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of idrometros
	 */
	public java.util.List<Idrometro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idrometros
	 */
	public java.util.List<Idrometro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of idrometros
	 */
	public java.util.List<Idrometro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Idrometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the idrometros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of idrometros.
	 *
	 * @return the number of idrometros
	 */
	public int countAll();

}