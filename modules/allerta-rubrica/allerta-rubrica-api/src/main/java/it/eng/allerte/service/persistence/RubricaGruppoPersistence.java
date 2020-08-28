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

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the rubrica gruppo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoUtil
 * @generated
 */
@ProviderType
public interface RubricaGruppoPersistence
	extends BasePersistence<RubricaGruppo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaGruppoUtil} to access the rubrica gruppo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RubricaGruppo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	public RubricaGruppo findByRubricaGruppoSitoProprietario(
			long ID_GRUPPO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaGruppoException;

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public RubricaGruppo fetchByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO, boolean retrieveFromCache);

	/**
	 * Removes the rubrica gruppo where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63; from the database.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the rubrica gruppo that was removed
	 */
	public RubricaGruppo removeByRubricaGruppoSitoProprietario(
			long ID_GRUPPO, long FK_SITO_PROPRIETARIO)
		throws NoSuchRubricaGruppoException;

	/**
	 * Returns the number of rubrica gruppos where ID_GRUPPO = &#63; and FK_SITO_PROPRIETARIO = &#63;.
	 *
	 * @param ID_GRUPPO the id_gruppo
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @return the number of matching rubrica gruppos
	 */
	public int countByRubricaGruppoSitoProprietario(
		long ID_GRUPPO, long FK_SITO_PROPRIETARIO);

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the matching rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a matching rubrica gruppo could not be found
	 */
	public RubricaGruppo findByRubricaGruppoForOwnerAndName(
			long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED)
		throws NoSuchRubricaGruppoException;

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED);

	/**
	 * Returns the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica gruppo, or <code>null</code> if a matching rubrica gruppo could not be found
	 */
	public RubricaGruppo fetchByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED,
		boolean retrieveFromCache);

	/**
	 * Removes the rubrica gruppo where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63; from the database.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the rubrica gruppo that was removed
	 */
	public RubricaGruppo removeByRubricaGruppoForOwnerAndName(
			long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED)
		throws NoSuchRubricaGruppoException;

	/**
	 * Returns the number of rubrica gruppos where FK_SITO_PROPRIETARIO = &#63; and NOME = &#63; and DISABLED = &#63;.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario
	 * @param NOME the nome
	 * @param DISABLED the disabled
	 * @return the number of matching rubrica gruppos
	 */
	public int countByRubricaGruppoForOwnerAndName(
		long FK_SITO_PROPRIETARIO, String NOME, boolean DISABLED);

	/**
	 * Caches the rubrica gruppo in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 */
	public void cacheResult(RubricaGruppo rubricaGruppo);

	/**
	 * Caches the rubrica gruppos in the entity cache if it is enabled.
	 *
	 * @param rubricaGruppos the rubrica gruppos
	 */
	public void cacheResult(java.util.List<RubricaGruppo> rubricaGruppos);

	/**
	 * Creates a new rubrica gruppo with the primary key. Does not add the rubrica gruppo to the database.
	 *
	 * @param ID_GRUPPO the primary key for the new rubrica gruppo
	 * @return the new rubrica gruppo
	 */
	public RubricaGruppo create(long ID_GRUPPO);

	/**
	 * Removes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	public RubricaGruppo remove(long ID_GRUPPO)
		throws NoSuchRubricaGruppoException;

	public RubricaGruppo updateImpl(RubricaGruppo rubricaGruppo);

	/**
	 * Returns the rubrica gruppo with the primary key or throws a <code>NoSuchRubricaGruppoException</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws NoSuchRubricaGruppoException if a rubrica gruppo with the primary key could not be found
	 */
	public RubricaGruppo findByPrimaryKey(long ID_GRUPPO)
		throws NoSuchRubricaGruppoException;

	/**
	 * Returns the rubrica gruppo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo, or <code>null</code> if a rubrica gruppo with the primary key could not be found
	 */
	public RubricaGruppo fetchByPrimaryKey(long ID_GRUPPO);

	/**
	 * Returns all the rubrica gruppos.
	 *
	 * @return the rubrica gruppos
	 */
	public java.util.List<RubricaGruppo> findAll();

	/**
	 * Returns a range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @return the range of rubrica gruppos
	 */
	public java.util.List<RubricaGruppo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica gruppos
	 */
	public java.util.List<RubricaGruppo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica gruppos
	 */
	public java.util.List<RubricaGruppo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RubricaGruppo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the rubrica gruppos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rubrica gruppos.
	 *
	 * @return the number of rubrica gruppos
	 */
	public int countAll();

}