/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Feed service. Represents a row in the &quot;ALLERTER_Feed&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see FeedModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.FeedImpl")
@ProviderType
public interface Feed extends FeedModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.FeedImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Feed, String> FEED_ID_ACCESSOR =
		new Accessor<Feed, String>() {

			@Override
			public String get(Feed feed) {
				return feed.getFeedId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Feed> getTypeClass() {
				return Feed.class;
			}

		};

}