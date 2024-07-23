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

package allerta.catasto.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.Sottocategoria;
import allerta.catasto.model.SottocategoriaModel;
import allerta.catasto.model.SottocategoriaSoap;
import allerta.catasto.service.persistence.SottocategoriaPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Sottocategoria service. Represents a row in the &quot;CATASTO_Sottocategoria&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>SottocategoriaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SottocategoriaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SottocategoriaImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SottocategoriaModelImpl
	extends BaseModelImpl<Sottocategoria> implements SottocategoriaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sottocategoria model instance should use the <code>Sottocategoria</code> interface instead.
	 */
	public static final String TABLE_NAME = "CATASTO_Sottocategoria";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"idCategoria", Types.BIGINT},
		{"descrizione", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("idCategoria", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CATASTO_Sottocategoria (id_ LONG not null,idCategoria LONG not null,descrizione VARCHAR(75) null,primary key (id_, idCategoria))";

	public static final String TABLE_SQL_DROP =
		"drop table CATASTO_Sottocategoria";

	public static final String ORDER_BY_JPQL =
		" ORDER BY sottocategoria.id.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CATASTO_Sottocategoria.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		allerta.catasto.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.allerta.catasto.model.Sottocategoria"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		allerta.catasto.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.allerta.catasto.model.Sottocategoria"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Sottocategoria toModel(SottocategoriaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Sottocategoria model = new SottocategoriaImpl();

		model.setId(soapModel.getId());
		model.setIdCategoria(soapModel.getIdCategoria());
		model.setDescrizione(soapModel.getDescrizione());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Sottocategoria> toModels(
		SottocategoriaSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<Sottocategoria> models = new ArrayList<Sottocategoria>(
			soapModels.length);

		for (SottocategoriaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		allerta.catasto.service.util.ServiceProps.get(
			"lock.expiration.time.allerta.catasto.model.Sottocategoria"));

	public SottocategoriaModelImpl() {
	}

	@Override
	public SottocategoriaPK getPrimaryKey() {
		return new SottocategoriaPK(_id, _idCategoria);
	}

	@Override
	public void setPrimaryKey(SottocategoriaPK primaryKey) {
		setId(primaryKey.id);
		setIdCategoria(primaryKey.idCategoria);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SottocategoriaPK(_id, _idCategoria);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SottocategoriaPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Sottocategoria.class;
	}

	@Override
	public String getModelClassName() {
		return Sottocategoria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Sottocategoria, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Sottocategoria, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Sottocategoria, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Sottocategoria)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Sottocategoria, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Sottocategoria, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Sottocategoria)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Sottocategoria, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Sottocategoria, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Sottocategoria, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Sottocategoria, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Sottocategoria, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Sottocategoria, Object>>();
		Map<String, BiConsumer<Sottocategoria, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Sottocategoria, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<Sottocategoria, Object>() {

				@Override
				public Object apply(Sottocategoria sottocategoria) {
					return sottocategoria.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Sottocategoria, Object>() {

				@Override
				public void accept(Sottocategoria sottocategoria, Object id) {
					sottocategoria.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"idCategoria",
			new Function<Sottocategoria, Object>() {

				@Override
				public Object apply(Sottocategoria sottocategoria) {
					return sottocategoria.getIdCategoria();
				}

			});
		attributeSetterBiConsumers.put(
			"idCategoria",
			new BiConsumer<Sottocategoria, Object>() {

				@Override
				public void accept(
					Sottocategoria sottocategoria, Object idCategoria) {

					sottocategoria.setIdCategoria((Long)idCategoria);
				}

			});
		attributeGetterFunctions.put(
			"descrizione",
			new Function<Sottocategoria, Object>() {

				@Override
				public Object apply(Sottocategoria sottocategoria) {
					return sottocategoria.getDescrizione();
				}

			});
		attributeSetterBiConsumers.put(
			"descrizione",
			new BiConsumer<Sottocategoria, Object>() {

				@Override
				public void accept(
					Sottocategoria sottocategoria, Object descrizione) {

					sottocategoria.setDescrizione((String)descrizione);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public long getIdCategoria() {
		return _idCategoria;
	}

	@Override
	public void setIdCategoria(long idCategoria) {
		_idCategoria = idCategoria;
	}

	@JSON
	@Override
	public String getDescrizione() {
		if (_descrizione == null) {
			return "";
		}
		else {
			return _descrizione;
		}
	}

	@Override
	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	@Override
	public Sottocategoria toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Sottocategoria)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SottocategoriaImpl sottocategoriaImpl = new SottocategoriaImpl();

		sottocategoriaImpl.setId(getId());
		sottocategoriaImpl.setIdCategoria(getIdCategoria());
		sottocategoriaImpl.setDescrizione(getDescrizione());

		sottocategoriaImpl.resetOriginalValues();

		return sottocategoriaImpl;
	}

	@Override
	public int compareTo(Sottocategoria sottocategoria) {
		int value = 0;

		if (getId() < sottocategoria.getId()) {
			value = -1;
		}
		else if (getId() > sottocategoria.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Sottocategoria)) {
			return false;
		}

		Sottocategoria sottocategoria = (Sottocategoria)obj;

		SottocategoriaPK primaryKey = sottocategoria.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Sottocategoria> toCacheModel() {
		SottocategoriaCacheModel sottocategoriaCacheModel =
			new SottocategoriaCacheModel();

		sottocategoriaCacheModel.sottocategoriaPK = getPrimaryKey();

		sottocategoriaCacheModel.id = getId();

		sottocategoriaCacheModel.idCategoria = getIdCategoria();

		sottocategoriaCacheModel.descrizione = getDescrizione();

		String descrizione = sottocategoriaCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			sottocategoriaCacheModel.descrizione = null;
		}

		return sottocategoriaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Sottocategoria, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Sottocategoria, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Sottocategoria, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Sottocategoria)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Sottocategoria, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Sottocategoria, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Sottocategoria, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Sottocategoria)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		Sottocategoria.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Sottocategoria.class, ModelWrapper.class
	};

	private long _id;
	private long _idCategoria;
	private String _descrizione;
	private Sottocategoria _escapedModel;

}