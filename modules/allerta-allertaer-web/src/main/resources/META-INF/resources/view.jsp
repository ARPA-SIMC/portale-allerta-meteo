<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalService"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="it.eng.allerter.model.Allerta"%>
<%@page	import="java.util.List"%>
	
<%@ include file="./init.jsp"%>

<style>
.taglib-search-iterator-page-iterator-top {
	display: none !important;
}
</style>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();

	OrderByComparator comparator = OrderByComparatorFactoryUtil.create("ALLERTER_Allerta", "dataInizio", "desc");
	
	SimpleDateFormat emissioneDateFormat = new SimpleDateFormat("dd MMM yyyy - hh:mm"); 
	SimpleDateFormat outDateFormat = new SimpleDateFormat("EEEEE, dd MMM yyyy "); 
%>


				<liferay-ui:search-container iteratorURL="<%=iteratorURL%>"
					total="<%=AllertaLocalServiceUtil.getAllertasCount()%>">

					<liferay-ui:search-container-results
						results="<%=AllertaLocalServiceUtil.getAllertasOrdered(searchContainer.getStart(),
						searchContainer.getEnd(), comparator)%>" />

					<liferay-ui:search-container-row
						className="it.eng.allerter.model.Allerta" modelVar="aAllerta">

						<%
							AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(Allerta.class.getName(),
											aAllerta.getAllertaId());
						%>

						<!-- Card Item -->
						<div class="card card--item  ">
							<a
								href="/web/guest/singola-allerta/-/asset_publisher/FZPQSb6AzKtJ/Allerta-Bollettino/id/<%=entry.getEntryId()%>"
								title="Vai alla pagina identificata da questo elemento">

								<div class="card-header">
									<div class="card__thumbnail">
										<span class="icon i-file-text-o" title="Allerta - Bollettino"></span>
									</div>
								</div>
								<div class="card-body">
									<div class="card__heading">
										<h3 class="card__title"><%=aAllerta.getTitolo()%></h3>
									</div>
									<div class="row card__data">
										<div class="col-12">
											Valido da
											<%= outDateFormat.format(aAllerta.getDataInizio())%>
											fino a
											<%= outDateFormat.format(aAllerta.getDataFine())%>
										</div>
										<div class="col-12 col-xl-6 card__data__item">
											<span class="icon i-clock-o card__data__icon"
												title="Emanato il"></span> <span class="card__data__value">
												<%= emissioneDateFormat.format(aAllerta.getDataEmissione())%>
											</span>
										</div>
									</div>
								</div>

							</a>
						</div>

					</liferay-ui:search-container-row>

					<liferay-ui:search-iterator />
					
				</liferay-ui:search-container>

			