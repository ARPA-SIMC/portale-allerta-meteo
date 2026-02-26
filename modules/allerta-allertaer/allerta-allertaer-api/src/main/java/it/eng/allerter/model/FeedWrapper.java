/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Feed}.
 * </p>
 *
 * @author GFAVINI
 * @see Feed
 * @generated
 */
public class FeedWrapper
	extends BaseModelWrapper<Feed> implements Feed, ModelWrapper<Feed> {

	public FeedWrapper(Feed feed) {
		super(feed);
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
	public Feed cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the autore of this feed.
	 *
	 * @return the autore of this feed
	 */
	@Override
	public String getAutore() {
		return model.getAutore();
	}

	/**
	 * Returns the feed ID of this feed.
	 *
	 * @return the feed ID of this feed
	 */
	@Override
	public String getFeedId() {
		return model.getFeedId();
	}

	/**
	 * Returns the link of this feed.
	 *
	 * @return the link of this feed
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the primary key of this feed.
	 *
	 * @return the primary key of this feed
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the query of this feed.
	 *
	 * @return the query of this feed
	 */
	@Override
	public String getQuery() {
		return model.getQuery();
	}

	/**
	 * Returns the titolo of this feed.
	 *
	 * @return the titolo of this feed
	 */
	@Override
	public String getTitolo() {
		return model.getTitolo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the autore of this feed.
	 *
	 * @param autore the autore of this feed
	 */
	@Override
	public void setAutore(String autore) {
		model.setAutore(autore);
	}

	/**
	 * Sets the feed ID of this feed.
	 *
	 * @param feedId the feed ID of this feed
	 */
	@Override
	public void setFeedId(String feedId) {
		model.setFeedId(feedId);
	}

	/**
	 * Sets the link of this feed.
	 *
	 * @param link the link of this feed
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the primary key of this feed.
	 *
	 * @param primaryKey the primary key of this feed
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the query of this feed.
	 *
	 * @param query the query of this feed
	 */
	@Override
	public void setQuery(String query) {
		model.setQuery(query);
	}

	/**
	 * Sets the titolo of this feed.
	 *
	 * @param titolo the titolo of this feed
	 */
	@Override
	public void setTitolo(String titolo) {
		model.setTitolo(titolo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FeedWrapper wrap(Feed feed) {
		return new FeedWrapper(feed);
	}

}