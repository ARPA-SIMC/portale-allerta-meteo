<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="it.eng.allerta.header.beans.LuoghiPreferitiBean"%>
<%@ include file="../init.jsp"%>

<%
LuoghiPreferitiBean lbean = new LuoghiPreferitiBean(themeDisplay.getUserId());
%>

<main class="page main" id="main-content">

	<div class="container page__body" >

		<div class="col-12">
		
			<input 
				type="search" 
				class="form-control input-sm" 
				id="cercaComune" 
				placeholder="Cerca un comune" />
			
			<br/><br/>
							
			<table id='tabella-luoghi' class="table table-hover">
			
				<thead>
					<tr>
						<th>Comune</th>
						<th>Iscrizione</th>
					</tr>

				</thead>
				
				<tbody>
				
					<%for( Group g : lbean.getElencoGruppiComuni()) { %>
					
						<tr>
							<td><%= g.getName() %></td>
							<td>
								
								<% if(UserLocalServiceUtil.hasGroupUser(g.getGroupId(), themeDisplay.getUserId())) { %>
									
									<img
										id="heart_<%= g.getGroupId()%>"
										src="<%=request.getContextPath() %>/images/Love_Heart_SVG.svg"
										style="height: 32px; width: 32px;" 
										data-attr-action='delete'
										data-attr-action-id=<%=g.getGroupId() %>
										 />										
										
								<%} else { %>
									
									<img 
										id="heart_<%= g.getGroupId()%>"
										src="<%=request.getContextPath() %>/images/Heart_empty_font_awesome.svg"
										style="height: 32px; width: 32px;" 
										data-attr-action='subscribe'
										data-attr-action-id=<%=g.getGroupId() %>
										 />
								<%} %>
							</td>
						</tr>
					
					<%} %>
				
				
				</tbody>
			
			</table>
			
		</div>
		
	</div>
	
	<style>
	 	#tabella-luoghi_filter {
	 		display:none;
	 	}
	 	
	 	.paginate_button {
	 		margin-left: 5px;
	 		margin-right: 5px;
	 	}
	</style>
	
	<script>
		jQuery( document ).ready(function() {
			
			var imgBasePath = '<%=request.getContextPath()%>/images/';
			
			$('img[id^="heart_"]').click(function(item) {
				
				var element = $(this);
				var action = $(this).attr('data-attr-action');
				var actionId = $(this).attr('data-attr-action-id');
				console.log('action', action);
				
				dataParams = [];
				dataParams.groupId = actionId;
				dataParams.userId = <%=themeDisplay.getUserId()%>;
				dataParams.cmd = action;
				
				 $.ajax({
					type:'get',
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					data: dataParams,
					contentType: "application/json; charset=utf-8",
					url: "/o/api/allerta/subscriptions?cmd="+action+"&groupId="+actionId+"&userId=<%=themeDisplay.getUserId()%>", 
					
					success: function(result) {
						
						if( action == 'delete') {
							
							console.log('delete', imgBasePath + 'Heart_empty_font_awesome.svg');
							
							element.attr('data-attr-action', 'subscribe');
							element.attr('src', imgBasePath + 'Heart_empty_font_awesome.svg');
							
							console.log( $(this).attr('src'),  $(this).attr('data-attr-action'));
							
						} else {
							console.log('subscribe', imgBasePath + 'Heart_empty_font_awesome.svg');
							
							element.attr('data-attr-action', 'delete');
							element.attr('src', imgBasePath + 'Love_Heart_SVG.svg');
							
							console.log( $(this).attr('src'),  $(this).attr('data-attr-action'));
						}
					}, 
					
					error: function(jqXHR, exception) {
						
						console.log('ERROR', jqXHR, exception);
					}
				 });
			});
			
			var tableLuoghi = jQuery('#tabella-luoghi').DataTable({
	            "order": [[ 0, "asc" ]],
                'columnDefs': [ {
                    'targets': [1], // column index (start from 0)
                    'orderable': false, // set orderable false for selected columns
                 }]
	        });
		 
			jQuery( '#cercaComune', this ).on( 'keyup', function () {
				tableLuoghi.search( this.value ).draw();
	        });
			
		
		});
	</script>
		
</main>