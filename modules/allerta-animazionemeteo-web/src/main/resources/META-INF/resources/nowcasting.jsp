<%@page import="it.eng.allerta.animazione.bean.Nowcasting"%>
<%@ include file="./init.jsp" %>

<%
	Nowcasting nowcasting = new Nowcasting();
%>

<div class="page page--previsioni" id="main-content">

	<div class="page__head">
                
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-12" >Nowcasting: evoluzione degli echi radar</h1>
                
                <p class="col-12 lead">
                    
                </p>
            </div>

            
        </div>
        <div class="breadcrumb-container">
            <div class="container d-flex">
                <nav class="row" aria-label="Hai percorso">
                    <ol class="breadcrumb">
        
                       <li class="breadcrumb-item">
                           <a href="/">Home</a>
                       </li>
       
                       <li class="breadcrumb-item active" aria-current="page">Nowcasting</li>
        
                    </ol>
                </nav>
            </div>
        </div>
   </div>
   
</div>   
   
<div class="container page__body">

	<div class="row"> 

       	<div class="col-12 page__content" id="page-content">

			<p>
				La mappa evoluzione considera gli echi delle precipitazioni ad un dato
				istante e fornisce la previsione del loro spostamento a +1 ora (linea gialla), +2 ore (linea arancione) e +3 ore (linea rossa): in caso di
				situazione stazionaria la linea rossa ricopre le altre. Gli echi sono rappresentati in modo semplificato con due o tre
				diversi colori, dalle tonalità più scure per nubi debolmente precipitanti a colori più chiari per le precipitazioni più intense.
			</p>
			
			<div class="col-12">
				<h2>Mostra:</h2>
				<label> <input name="reteVie" onclick="visualizza('Lretevie');" type="checkbox" />Rete viaria</label> 
				<label> <input name="amministrativi" onclick="visualizza('Lamministrativi');" type="checkbox" />Confini amministrativi </label> 
				<label> <input name="idro" onclick="visualizza('Lidro');" type="checkbox" />Idrografia</label>
			</div>
			
			<div class="col-12">

				<div id="contenitore">
				
					<div id="immagineRadar">
						<img
							src="data:image/jpg;base64,<%=nowcasting.getImg("immagineRadar").getData()%>"
							alt="mappa evoluzione dal radar" />
					</div>
					<div id="Lretevie">
						<img
							src="data:image/jpg;base64,<%=nowcasting.getImg("Lretevie").getData()%>"
							alt="rete viaria" />
					</div>
					<div id="Lamministrativi">
						<img
							src="data:image/jpg;base64,<%=nowcasting.getImg("Lamministrativi").getData()%>"
							alt="confini amministrativi" />
					</div>
					<div id="Lidro">
						<img
							src="data:image/jpg;base64,<%=nowcasting.getImg("Lidro").getData()%>"
							alt="idrologia" />
					</div>
					
				</div>
					

			</div>
			
		</div>
	</div>
</div>	

<style>

#contenitore{
	position: relative; 
	width: 100%; 
	height: 559px; 
	margin: 0 auto;
	text-align: center;
	padding-bottom: 15px;
}

#immagineRadar {
	position: absolute;
}

#Lretevie {
	position: absolute;
	visibility: hidden;
}
#Lamministrativi {
	position: absolute;
	visibility: hidden;
}
#Lidro {
	position: absolute;
	visibility: hidden;
}
</style>

<script type="text/javascript">
	var a, b, c, temp;
	a = false
	b = false
	c = false

	function visualizza(par) {
		switch (par) {
		case 'Lretevie':
			a = !(a);
			temp = a;
			break;
		case 'Lamministrativi':
			b = !(b);
			temp = b;
			break;
		case 'Lidro':
			c = !(c);
			temp = c;
			break;
		}
		if (temp)
			document.getElementById(par).style.visibility = "visible";
		else
			document.getElementById(par).style.visibility = "hidden";
	}

	function linka() {
		stringa = "";
		if (a)
			stringa += "1";
		else
			stringa += "0";
		if (b)
			stringa += "1";
		else
			stringa += "0";
		if (c)
			stringa += "1";
		else
			stringa += "0";
		return stringa;
	}
</script>