<%@ include file="/init.jsp" %>

<script lang="text/javascript">
	function getObjectType() {
		return "<%= cf.oggetto() %>"
	}
	function getParams() {
		var nm
		var out = ""
		for (nm of getFilterIds()) {
			var ogg = $(".filtri").find("[name="+nm+"]")
			if (ogg.prop("tagName")=="INPUT" || ogg.prop("tagName")=="SELECT") {
					if (ogg.val()) out += nm+"="+ogg.val()+"&"
			
			}
		}
		return out
	}
	function getFilterIds() {
		return [<%=searchable.getFilterIds() %>]
	}
	function getVarMese() {
		return "<%=searchable.getMonthEquivalent()!=null?searchable.getMonthEquivalent():"month" %>"
	}
	function updateFeed() {
		$(".rss-filtrato")[0].href=
			"/o/feed/<%=cf.oggetto() %>?"+getParams();
	}
	function dueLivelli() {
		return <%=searchable.getMonthEquivalent()!=null %>
	}
	
</script>
<style>
	.pdf {
		margin-left: 1rem;
	}
	.pdf2 {
		font-family: "Titillium Web",sans-serif !important;
		margin-left: 0.3rem;
	}
	.filtri {
		border: 1px solid #ccc;
		padding: 10px;
	}
	.search-year {
		margin-bottom: 1rem;
	}
	#search-container {
		margin-left: 2rem;
	}
	#search-container .search-collapsed .expanded {
		display:none;
	}
	#search-container .search-expanded .collapsed {
		display:none;
	}
	#search-container .expanded {
		margin-left: 3rem;
	}
	#search-container h3 , #search-container h6, .search-collapser {
		display:inline;
	}
	#search-container .search-count {
		color: black;
		font-size: 0.9rem;
	}
	#search-container a {
		padding-left: 0.4rem;
		font-family: "Titillium Web",sans-serif;
		line-height: 1.3;
	}
	#search-container .search-collapser {
		margin-right: 0.4rem;
	}
</style>
<div class="container">
    <% if (searchable.shouldRenderFilters()) { %>
	<h3>Filtri di ricerca</h3>
	<div class="filtri">
		<%=searchable.renderFilters() %>
		<button type="button" onclick="countByYear()"
					class="btn btn-primary" style="margin: auto;">Aggiorna</button>
	</div>
	<% } %>
	
	<p>
		<h3>Archivio <%=searchable.getName() %></h3>
		<div id="search-container"></div>
		<a href="/o/feed/<%=cf.oggetto() %>" target="_blank" class="btn btn-transparent rss-filtrato" title="RSS filtrato secondo le opzioni scelte">
				     	<span class="icon i-rss" title="Icona RSS"></span> <span>RSS</span> 
				     	<span class="icon i-external-link-square u-open-external" title="RSS filtrato secondo le opzioni scelte"></span>
		</a>
	</p>
</div>