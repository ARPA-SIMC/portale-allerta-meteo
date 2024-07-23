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

package it.eng.cache.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.cache.model.Dati;
import it.eng.cache.model.DatiModel;
import it.eng.cache.model.DatiSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Dati service. Represents a row in the &quot;CACHE_Dati&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DatiModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DatiImpl}.
 * </p>
 *
 * @author GFAVINI
 * @see DatiImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DatiModelImpl extends BaseModelImpl<Dati> implements DatiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dati model instance should use the <code>Dati</code> interface instead.
	 */
	public static final String TABLE_NAME = "CACHE_Dati";

	public static final Object[][] TABLE_COLUMNS = {
		{"idDati", Types.VARCHAR}, {"dato", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("idDati", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dato", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CACHE_Dati (idDati VARCHAR(75) not null primary key,dato VARCHAR(75) null,createDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table CACHE_Dati";

	public static final String ORDER_BY_JPQL = " ORDER BY dati.dato ASC";

	public static final String ORDER_BY_SQL = " ORDER BY CACHE_Dati.dato ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.cache.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.eng.cache.model.Dati"),
		false);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.cache.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.eng.cache.model.Dati"),
		false);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Dati toModel(DatiSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Dati model = new DatiImpl();

		model.setIdDati(soapModel.getIdDati());
		model.setDato(soapModel.getDato());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Dati> toModels(DatiSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Dati> models = new ArrayList<Dati>(soapModels.length);

		for (DatiSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		it.eng.cache.service.util.ServiceProps.get(
			"lock.expiration.time.it.eng.cache.model.Dati"));

	public DatiModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _idDati;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setIdDati(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idDati;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Dati.class;
	}

	@Override
	public String getModelClassName() {
		return Dati.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Dati, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Dati, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Dati, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Dati)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Dati, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Dati, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Dati)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Dati, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Dati, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Dati, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Dati, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Dati, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Dati, Object>>();
		Map<String, BiConsumer<Dati, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Dati, ?>>();

		attributeGetterFunctions.put(
			"idDati",
			new Function<Dati, Object>() {

				@Override
				public Object apply(Dati dati) {
					return dati.getIdDati();
				}

			});
		attributeSetterBiConsumers.put(
			"idDati",
			new BiConsumer<Dati, Object>() {

				@Override
				public void accept(Dati dati, Object idDati) {
					dati.setIdDati((String)idDati);
				}

			});
		attributeGetterFunctions.put(
			"dato",
			new Function<Dati, Object>() {

				@Override
				public Object apply(Dati dati) {
					return dati.getDato();
				}

			});
		attributeSetterBiConsumers.put(
			"dato",
			new BiConsumer<Dati, Object>() {

				@Override
				public void accept(Dati dati, Object dato) {
					dati.setDato((String)dato);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Dati, Object>() {

				@Override
				public Object apply(Dati dati) {
					return dati.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Dati, Object>() {

				@Override
				public void accept(Dati dati, Object createDate) {
					dati.setCreateDate((Date)createDate);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getIdDati() {
		if (_idDati == null) {
			return "";
		}
		else {
			return _idDati;
		}
	}

	@Override
	public void setIdDati(String idDati) {
		_idDati = idDati;
	}

	@JSON
	@Override
	public String getDato() {
		if (_dato == null) {
			return "";
		}
		else {
			return _dato;
		}
	}

	@Override
	public void setDato(String dato) {
		_dato = dato;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Dati toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Dati)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DatiImpl datiImpl = new DatiImpl();

		datiImpl.setIdDati(getIdDati());
		datiImpl.setDato(getDato());
		datiImpl.setCreateDate(getCreateDate());

		datiImpl.resetOriginalValues();

		return datiImpl;
	}

	@Override
	public int compareTo(Dati dati) {
		int value = 0;

		value = getDato().compareTo(dati.getDato());

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

		if (!(obj instanceof Dati)) {
			return false;
		}

		Dati dati = (Dati)obj;

		String primaryKey = dati.getPrimaryKey();

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
	public CacheModel<Dati> toCacheModel() {
		DatiCacheModel datiCacheModel = new DatiCacheModel();

		datiCacheModel.idDati = getIdDati();

		String idDati = datiCacheModel.idDati;

		if ((idDati != null) && (idDati.length() == 0)) {
			datiCacheModel.idDati = null;
		}

		datiCacheModel.dato = getDato();

		String dato = datiCacheModel.dato;

		if ((dato != null) && (dato.length() == 0)) {
			datiCacheModel.dato = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			datiCacheModel.createDate = createDate.getTime();
		}
		else {
			datiCacheModel.createDate = Long.MIN_VALUE;
		}

		return datiCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Dati, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Dati, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Dati, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Dati)this));
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
		Map<String, Function<Dati, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Dati, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Dati, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Dati)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Dati.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Dati.class, ModelWrapper.class
	};

	private String _idDati;
	private String _dato;
	private Date _createDate;
	private Dati _escapedModel;

}