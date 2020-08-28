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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Feed}.
 * </p>
 *
 * @author GFAVINI
 * @see Feed
 * @generated
 */
@ProviderType
public class FeedWrapper implements Feed, ModelWrapper<Feed> {

	public FeedWrapper(Feed feed) {
		_feed = feed;
	}

	@Override
	public Class<?> getModelClass() {
		return Feed.class;
	}

	@Override
	public String getModelClassName() {
		return Feed.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedId", getFeedId());
		attributes.put("titolo", getTitolo());
		attributes.put("link", getLink());
		attributes.put("autore", getAutore());
		attributes.put("query", getQuery());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String feedId = (String)attributes.get("feedId");

		if (feedId != null) {
			setFeedId(feedId);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String autore = (String)attributes.get("autore");

		if (autore != null) {
			setAutore(autore);
		}

		String query = (String)attributes.get("query");

		if (query != null) {
			setQuery(query);
		}
	}

	@Override
	public Object clone() {
		return new FeedWrapper((Feed)_feed.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.Feed feed) {
		return _feed.compareTo(feed);
	}

	/**
	 * Returns the autore of this feed.
	 *
	 * @return the autore of this feed
	 */
	@Override
	public String getAutore() {
		return _feed.getAutore();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _feed.getExpandoBridge();
	}

	/**
	 * Returns the feed ID of this feed.
	 *
	 * @return the feed ID of this feed
	 */
	@Override
	public String getFeedId() {
		return _feed.getFeedId();
	}

	/**
	 * Returns the link of this feed.
	 *
	 * @return the link of this feed
	 */
	@Override
	public String getLink() {
		return _feed.getLink();
	}

	/**
	 * Returns the primary key of this feed.
	 *
	 * @return the primary key of this feed
	 */
	@Override
	public String getPrimaryKey() {
		return _feed.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feed.getPrimaryKeyObj();
	}

	/**
	 * Returns the query of this feed.
	 *
	 * @return the query of this feed
	 */
	@Override
	public String getQuery() {
		return _feed.getQuery();
	}

	/**
	 * Returns the titolo of this feed.
	 *
	 * @return the titolo of this feed
	 */
	@Override
	public String getTitolo() {
		return _feed.getTitolo();
	}

	@Override
	public int hashCode() {
		return _feed.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _feed.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _feed.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _feed.isNew();
	}

	@Override
	public void persist() {
		_feed.persist();
	}

	/**
	 * Sets the autore of this feed.
	 *
	 * @param autore the autore of this feed
	 */
	@Override
	public void setAutore(String autore) {
		_feed.setAutore(autore);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feed.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_feed.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_feed.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_feed.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the feed ID of this feed.
	 *
	 * @param feedId the feed ID of this feed
	 */
	@Override
	public void setFeedId(String feedId) {
		_feed.setFeedId(feedId);
	}

	/**
	 * Sets the link of this feed.
	 *
	 * @param link the link of this feed
	 */
	@Override
	public void setLink(String link) {
		_feed.setLink(link);
	}

	@Override
	public void setNew(boolean n) {
		_feed.setNew(n);
	}

	/**
	 * Sets the primary key of this feed.
	 *
	 * @param primaryKey the primary key of this feed
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_feed.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_feed.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the query of this feed.
	 *
	 * @param query the query of this feed
	 */
	@Override
	public void setQuery(String query) {
		_feed.setQuery(query);
	}

	/**
	 * Sets the titolo of this feed.
	 *
	 * @param titolo the titolo of this feed
	 */
	@Override
	public void setTitolo(String titolo) {
		_feed.setTitolo(titolo);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.Feed> toCacheModel() {

		return _feed.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.Feed toEscapedModel() {
		return new FeedWrapper(_feed.toEscapedModel());
	}

	@Override
	public String toString() {
		return _feed.toString();
	}

	@Override
	public it.eng.allerter.model.Feed toUnescapedModel() {
		return new FeedWrapper(_feed.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _feed.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedWrapper)) {
			return false;
		}

		FeedWrapper feedWrapper = (FeedWrapper)obj;

		if (Objects.equals(_feed, feedWrapper._feed)) {
			return true;
		}

		return false;
	}

	@Override
	public Feed getWrappedModel() {
		return _feed;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _feed.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _feed.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_feed.resetOriginalValues();
	}

	private final Feed _feed;

}