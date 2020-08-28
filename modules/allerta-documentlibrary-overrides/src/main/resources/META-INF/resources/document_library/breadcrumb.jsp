<%@ include file="/document_library/init.jsp" %>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.theme.NavItem"%>

<%
Folder folder = (Folder)request.getAttribute("view.jsp-folder");



String base = "";
long scope = PortalUtil.getScopeGroupId(request);
if (scope>0 && scope!=20194 && scope!=20181) {
	PortalUtil.addPortletBreadcrumbEntry(request,"Home", "/");
	Group g = GroupLocalServiceUtil.getGroup(scope);
	base = "/web"+g.getFriendlyURL();
	if (g.getSite()) {
		PortalUtil.addPortletBreadcrumbEntry(request,g.getName(), base);
	}
}

Layout la = themeDisplay.getLayout();
NavItem ni = new NavItem(request, themeDisplay, la, null);
PortalUtil.addPortletBreadcrumbEntry(request,ni.getName(), ni.getURL());

	PortletURL portletURL = liferayPortletResponse.createRenderURL();

	List<Folder> ancestorFolders = Collections.emptyList();


	if ((folder != null) && (folder.getFolderId() != rootFolderId)) {
		ancestorFolders = folder.getAncestors();

		int indexOfRootFolder = -1;

		for (int i = 0; i < ancestorFolders.size(); i++) {
			Folder ancestorFolder = (Folder)ancestorFolders.get(i);

			if (rootFolderId == ancestorFolder.getFolderId()) {
				indexOfRootFolder = i;
			}
		}

		if (indexOfRootFolder > -1) {
			ancestorFolders = ancestorFolders.subList(0, indexOfRootFolder);
		}
	}

	Collections.reverse(ancestorFolders);

	for (Folder ancestorFolder : ancestorFolders) {
		portletURL.setParameter(
			"folderId", String.valueOf(ancestorFolder.getFolderId()));

		Map data = new HashMap<>();

		data.put("direction-right", Boolean.TRUE.toString());
		data.put("folder-id", ancestorFolder.getFolderId());

		PortalUtil.addPortletBreadcrumbEntry(
			request, ancestorFolder.getName(), portletURL.toString(), data);
	}

	long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	if (folder != null) {
		folderId = folder.getFolderId();
	}

	portletURL.setParameter("folderId", String.valueOf(folderId));

	if ((folderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) &&
		(folderId != rootFolderId)) {

		Folder unescapedFolder = folder.toUnescapedModel();

		Map data = new HashMap<>();

		data.put("direction-right", Boolean.TRUE.toString());
		data.put("folder-id", folderId);

		PortalUtil.addPortletBreadcrumbEntry(
			request, unescapedFolder.getName(), portletURL.toString(),
			data);
	}


%>
<div class="breadcrumb-container">
<liferay-ui:breadcrumb
	showCurrentGroup="<%= false %>"
	showGuestGroup="<%= false %>"
	showLayout="<%= false %>"
	showParentGroups="<%= false %>"
/>
</div>