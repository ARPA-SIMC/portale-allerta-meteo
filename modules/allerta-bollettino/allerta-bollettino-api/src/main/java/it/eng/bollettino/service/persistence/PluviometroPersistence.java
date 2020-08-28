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

import it.eng.bollettino.exception.NoSuchPluviometroException;
import it.eng.bollettino.model.Pluviometro;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the pluviometro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see PluviometroUtil
 * @generated
 */
@ProviderType
public interface PluviometroPersistence extends BasePersistence<Pluviometro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PluviometroUtil} to access the pluviometro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Pluviometro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeGruppo(String nomeGruppo);

	/**
	 * Returns a range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end);

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pluviometros where nomeGruppo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeGruppo(
		String nomeGruppo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public Pluviometro findByNomeGruppo_First(
			String nomeGruppo,
			com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
				orderByComparator)
		throws NoSuchPluviometroException;

	/**
	 * Returns the first pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public Pluviometro fetchByNomeGruppo_First(
		String nomeGruppo,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public Pluviometro findByNomeGruppo_Last(
			String nomeGruppo,
			com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
				orderByComparator)
		throws NoSuchPluviometroException;

	/**
	 * Returns the last pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public Pluviometro fetchByNomeGruppo_Last(
		String nomeGruppo,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeGruppo = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeGruppo the nome gruppo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public Pluviometro[] findByNomeGruppo_PrevAndNext(
			String stazioneId, String nomeGruppo,
			com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
				orderByComparator)
		throws NoSuchPluviometroException;

	/**
	 * Removes all the pluviometros where nomeGruppo = &#63; from the database.
	 *
	 * @param nomeGruppo the nome gruppo
	 */
	public void removeByNomeGruppo(String nomeGruppo);

	/**
	 * Returns the number of pluviometros where nomeGruppo = &#63;.
	 *
	 * @param nomeGruppo the nome gruppo
	 * @return the number of matching pluviometros
	 */
	public int countByNomeGruppo(String nomeGruppo);

	/**
	 * Returns all the pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeRubrica(String nomeRubrica);

	/**
	 * Returns a range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end);

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pluviometros where nomeRubrica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pluviometros
	 */
	public java.util.List<Pluviometro> findByNomeRubrica(
		String nomeRubrica, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public Pluviometro findByNomeRubrica_First(
			String nomeRubrica,
			com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
				orderByComparator)
		throws NoSuchPluviometroException;

	/**
	 * Returns the first pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public Pluviometro fetchByNomeRubrica_First(
		String nomeRubrica,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro
	 * @throws NoSuchPluviometroException if a matching pluviometro could not be found
	 */
	public Pluviometro findByNomeRubrica_Last(
			String nomeRubrica,
			com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
				orderByComparator)
		throws NoSuchPluviometroException;

	/**
	 * Returns the last pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pluviometro, or <code>null</code> if a matching pluviometro could not be found
	 */
	public Pluviometro fetchByNomeRubrica_Last(
		String nomeRubrica,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns the pluviometros before and after the current pluviometro in the ordered set where nomeRubrica = &#63;.
	 *
	 * @param stazioneId the primary key of the current pluviometro
	 * @param nomeRubrica the nome rubrica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public Pluviometro[] findByNomeRubrica_PrevAndNext(
			String stazioneId, String nomeRubrica,
			com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
				orderByComparator)
		throws NoSuchPluviometroException;

	/**
	 * Removes all the pluviometros where nomeRubrica = &#63; from the database.
	 *
	 * @param nomeRubrica the nome rubrica
	 */
	public void removeByNomeRubrica(String nomeRubrica);

	/**
	 * Returns the number of pluviometros where nomeRubrica = &#63;.
	 *
	 * @param nomeRubrica the nome rubrica
	 * @return the number of matching pluviometros
	 */
	public int countByNomeRubrica(String nomeRubrica);

	/**
	 * Caches the pluviometro in the entity cache if it is enabled.
	 *
	 * @param pluviometro the pluviometro
	 */
	public void cacheResult(Pluviometro pluviometro);

	/**
	 * Caches the pluviometros in the entity cache if it is enabled.
	 *
	 * @param pluviometros the pluviometros
	 */
	public void cacheResult(java.util.List<Pluviometro> pluviometros);

	/**
	 * Creates a new pluviometro with the primary key. Does not add the pluviometro to the database.
	 *
	 * @param stazioneId the primary key for the new pluviometro
	 * @return the new pluviometro
	 */
	public Pluviometro create(String stazioneId);

	/**
	 * Removes the pluviometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro that was removed
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public Pluviometro remove(String stazioneId)
		throws NoSuchPluviometroException;

	public Pluviometro updateImpl(Pluviometro pluviometro);

	/**
	 * Returns the pluviometro with the primary key or throws a <code>NoSuchPluviometroException</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro
	 * @throws NoSuchPluviometroException if a pluviometro with the primary key could not be found
	 */
	public Pluviometro findByPrimaryKey(String stazioneId)
		throws NoSuchPluviometroException;

	/**
	 * Returns the pluviometro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stazioneId the primary key of the pluviometro
	 * @return the pluviometro, or <code>null</code> if a pluviometro with the primary key could not be found
	 */
	public Pluviometro fetchByPrimaryKey(String stazioneId);

	/**
	 * Returns all the pluviometros.
	 *
	 * @return the pluviometros
	 */
	public java.util.List<Pluviometro> findAll();

	/**
	 * Returns a range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @return the range of pluviometros
	 */
	public java.util.List<Pluviometro> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pluviometros
	 */
	public java.util.List<Pluviometro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pluviometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PluviometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pluviometros
	 * @param end the upper bound of the range of pluviometros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pluviometros
	 */
	public java.util.List<Pluviometro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pluviometro>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the pluviometros from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pluviometros.
	 *
	 * @return the number of pluviometros
	 */
	public int countAll();

}