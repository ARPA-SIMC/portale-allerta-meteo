/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerter.model.Feed;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Feed in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class FeedCacheModel implements CacheModel<Feed>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FeedCacheModel)) {
			return false;
		}

		FeedCacheModel feedCacheModel = (FeedCacheModel)object;

		if (feedId.equals(feedCacheModel.feedId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, feedId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{feedId=");
		sb.append(feedId);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", link=");
		sb.append(link);
		sb.append(", autore=");
		sb.append(autore);
		sb.append(", query=");
		sb.append(query);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feed toEntityModel() {
		FeedImpl feedImpl = new FeedImpl();

		if (feedId == null) {
			feedImpl.setFeedId("");
		}
		else {
			feedImpl.setFeedId(feedId);
		}

		if (titolo == null) {
			feedImpl.setTitolo("");
		}
		else {
			feedImpl.setTitolo(titolo);
		}

		if (link == null) {
			feedImpl.setLink("");
		}
		else {
			feedImpl.setLink(link);
		}

		if (autore == null) {
			feedImpl.setAutore("");
		}
		else {
			feedImpl.setAutore(autore);
		}

		if (query == null) {
			feedImpl.setQuery("");
		}
		else {
			feedImpl.setQuery(query);
		}

		feedImpl.resetOriginalValues();

		return feedImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		feedId = objectInput.readUTF();
		titolo = objectInput.readUTF();
		link = objectInput.readUTF();
		autore = objectInput.readUTF();
		query = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (feedId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(feedId);
		}

		if (titolo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (autore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(autore);
		}

		if (query == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(query);
		}
	}

	public String feedId;
	public String titolo;
	public String link;
	public String autore;
	public String query;

}