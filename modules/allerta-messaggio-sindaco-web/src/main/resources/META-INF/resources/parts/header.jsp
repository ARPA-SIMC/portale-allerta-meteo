<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp"%>

<%
int view = ParamUtil.getInteger(request, "view");
%>

<c:choose>
	<c:when test="${ messaggioBean.sindaco }">

	<h2>Intestazione del messaggio</h2>
	
	<div class="row">
		<div class="col-12">
			<b> Allerta Emilia Romagna
			
			
			<c:if test="${messaggioBean.comuneDelSindaco.size() eq 1}">
				- Comune di
					${messaggioBean.comuneDelSindaco.entrySet().iterator().next().getValue()}
				<aui:input type="hidden" value="${messaggioBean.comuneDelSindaco.keySet().iterator().next() }" 
				name="comune[]"></aui:input>
				 
			</c:if>
			<c:if test="${messaggioBean.comuneDelSindaco.size() gt 1}">
				<c:forEach items="${messaggioBean.comuneDelSindaco.keySet() }" var="key">
					<c:choose>
						<c:when test="<%=view == 1 %>">
							${ messaggioBean.comuneDelSindaco.get(key)}
						</c:when>
						<c:otherwise>
						<div class="ml-3 my-1 custom-control custom-checkbox">
							<aui:input type="checkbox" value="${key }" cssClass="custom-control-input"
								name="comune[]" wrappedField="true"></aui:input> 
							<label class="custom-control-label">
								- ${ messaggioBean.comuneDelSindaco.get(key)}
							</label>
							</div>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>

			</c:if>
			</b>
		</div>
	</div>
	</c:when>
	<c:otherwise>
		<div class="notify-header-preview">
			${messaggioBean.organizationToStringView()}			
		</div>
	</c:otherwise>
	
</c:choose>

