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

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import it.eng.parer.service.persistence.ComponentiInvioPK;

import java.io.Serializable;

/**
 * The base model interface for the ComponentiInvio service. Represents a row in the &quot;parer_ComponentiInvio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.parer.model.impl.ComponentiInvioModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.parer.model.impl.ComponentiInvioImpl</code>.
 * </p>
 *
 * @author Pratola_L
 * @see ComponentiInvio
 * @generated
 */
@ProviderType
public interface ComponentiInvioModel extends BaseModel<ComponentiInvio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a componenti invio model instance should use the {@link ComponentiInvio} interface instead.
	 */

	/**
	 * Returns the primary key of this componenti invio.
	 *
	 * @return the primary key of this componenti invio
	 */
	public ComponentiInvioPK getPrimaryKey();

	/**
	 * Sets the primary key of this componenti invio.
	 *
	 * @param primaryKey the primary key of this componenti invio
	 */
	public void setPrimaryKey(ComponentiInvioPK primaryKey);

	/**
	 * Returns the id_invio of this componenti invio.
	 *
	 * @return the id_invio of this componenti invio
	 */
	public long getID_INVIO();

	/**
	 * Sets the id_invio of this componenti invio.
	 *
	 * @param ID_INVIO the id_invio of this componenti invio
	 */
	public void setID_INVIO(long ID_INVIO);

	/**
	 * Returns the id_componente of this componenti invio.
	 *
	 * @return the id_componente of this componenti invio
	 */
	public long getID_COMPONENTE();

	/**
	 * Sets the id_componente of this componenti invio.
	 *
	 * @param ID_COMPONENTE the id_componente of this componenti invio
	 */
	public void setID_COMPONENTE(long ID_COMPONENTE);

	/**
	 * Returns the ordine_presentazione of this componenti invio.
	 *
	 * @return the ordine_presentazione of this componenti invio
	 */
	public long getORDINE_PRESENTAZIONE();

	/**
	 * Sets the ordine_presentazione of this componenti invio.
	 *
	 * @param ORDINE_PRESENTAZIONE the ordine_presentazione of this componenti invio
	 */
	public void setORDINE_PRESENTAZIONE(long ORDINE_PRESENTAZIONE);

	/**
	 * Returns the tipo_componente of this componenti invio.
	 *
	 * @return the tipo_componente of this componenti invio
	 */
	@AutoEscape
	public String getTIPO_COMPONENTE();

	/**
	 * Sets the tipo_componente of this componenti invio.
	 *
	 * @param TIPO_COMPONENTE the tipo_componente of this componenti invio
	 */
	public void setTIPO_COMPONENTE(String TIPO_COMPONENTE);

	/**
	 * Returns the tipo_supporto_componente of this componenti invio.
	 *
	 * @return the tipo_supporto_componente of this componenti invio
	 */
	@AutoEscape
	public String getTIPO_SUPPORTO_COMPONENTE();

	/**
	 * Sets the tipo_supporto_componente of this componenti invio.
	 *
	 * @param TIPO_SUPPORTO_COMPONENTE the tipo_supporto_componente of this componenti invio
	 */
	public void setTIPO_SUPPORTO_COMPONENTE(String TIPO_SUPPORTO_COMPONENTE);

	/**
	 * Returns the nome_componente of this componenti invio.
	 *
	 * @return the nome_componente of this componenti invio
	 */
	@AutoEscape
	public String getNOME_COMPONENTE();

	/**
	 * Sets the nome_componente of this componenti invio.
	 *
	 * @param NOME_COMPONENTE the nome_componente of this componenti invio
	 */
	public void setNOME_COMPONENTE(String NOME_COMPONENTE);

	/**
	 * Returns the formato_file_versato of this componenti invio.
	 *
	 * @return the formato_file_versato of this componenti invio
	 */
	@AutoEscape
	public String getFORMATO_FILE_VERSATO();

	/**
	 * Sets the formato_file_versato of this componenti invio.
	 *
	 * @param FORMATO_FILE_VERSATO the formato_file_versato of this componenti invio
	 */
	public void setFORMATO_FILE_VERSATO(String FORMATO_FILE_VERSATO);

	/**
	 * Returns the hash_versato of this componenti invio.
	 *
	 * @return the hash_versato of this componenti invio
	 */
	@AutoEscape
	public String getHASH_VERSATO();

	/**
	 * Sets the hash_versato of this componenti invio.
	 *
	 * @param HASH_VERSATO the hash_versato of this componenti invio
	 */
	public void setHASH_VERSATO(String HASH_VERSATO);

	/**
	 * Returns the urn_versato of this componenti invio.
	 *
	 * @return the urn_versato of this componenti invio
	 */
	@AutoEscape
	public String getURN_VERSATO();

	/**
	 * Sets the urn_versato of this componenti invio.
	 *
	 * @param URN_VERSATO the urn_versato of this componenti invio
	 */
	public void setURN_VERSATO(String URN_VERSATO);

	/**
	 * Returns the id_componente_versato of this componenti invio.
	 *
	 * @return the id_componente_versato of this componenti invio
	 */
	public long getID_COMPONENTE_VERSATO();

	/**
	 * Sets the id_componente_versato of this componenti invio.
	 *
	 * @param ID_COMPONENTE_VERSATO the id_componente_versato of this componenti invio
	 */
	public void setID_COMPONENTE_VERSATO(long ID_COMPONENTE_VERSATO);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(it.eng.parer.model.ComponentiInvio componentiInvio);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.parer.model.ComponentiInvio> toCacheModel();

	@Override
	public it.eng.parer.model.ComponentiInvio toEscapedModel();

	@Override
	public it.eng.parer.model.ComponentiInvio toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}