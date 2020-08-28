import React, {PureComponent} from 'react';
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { PanelContext } from '../../../context/panelContext';
import { PanelType } from '../../../types.d';
import cStyles from "../../../common.module.css";
import impStyles from "./ImportPanel.module.css";

export class ImportPanel extends PureComponent<any, any> {

     state = {
       comandi: null,
       selectedFile: null,
       risultato: null,
       note: null,
       warning: null
     }

     onFileChange = event => { 
     
      // Update the state 
      this.setState({ selectedFile: event.target.files[0], note:null, risultato:null }); 
     
    };

    onSubmit = async () => {

  const form = new FormData()
  form.append('comandi', JSON.stringify(this.state.comandi))
  //const aut = "p_auth="+window["Liferay"].authToken

  const fetchUrl = '/o/rubrica/upload/'

  const res = await fetch(fetchUrl, {
    headers:new Headers(),
    method: 'POST',
    credentials: "include",
    body: form
  })

   const data = await res.json()

    this.setState({comandi:null,selectedFile:null,note:data.note,risultato:data.risultato})
    } 
     
    // On file upload (click the upload button) 
    onFileUpload = async () => { 
     
      // Create an object of formData 
      const formData = new FormData(); 
      const headers = new Headers()
     
      // Update the formData object 
      formData.append( 
        "file", 
        this.state.selectedFile, 
        this.state.selectedFile.name 
      ); 
     
      // Details of the uploaded file 
      console.log(this.state.selectedFile); 
     
      // Request made to the backend api 
      // Send formData object 
      const res = await fetch('/o/rubrica/upload/', {
         headers,
         method: 'POST',
         credentials: "include",
         body: formData
        })

	const data = await res.json()
        console.log(data)
        this.setState({comandi:data,note:null,risultato:null,warning:this.trovaNominativiMultipli(data)})
    }; 

     trovaNominativiMultipli = (dati) => {

         var k
         var j
         var out = []
         var list = []

         for (k=0; k<dati.length; k++) {
             if (dati[k].chiedi && dati[k].decisione!='NOTHING') {
                   var trovato = false;
                   for (var i=0; i<list.length; i++) {
                       if (list[i]==dati[k].old) trovato = true;
                   }
                   if (trovato) continue;

                   var testo = dati[k].nome + ' ' + dati[k].cognome+' ('+dati[k].nomeGruppo;
                   var aggiungi = false;
                   for (j=k+1; j<dati.length; j++) {
                       if (dati[j].old==dati[k].old && dati[j].chiedi && dati[j].decisione!='NOTHING') {
                           testo+=', '+dati[j].nomeGruppo;
                           aggiungi = true;
                       }
                   }
                   if (aggiungi) {
                       out.push(testo+')');
                       list.push(dati[k].old)
                   }
             }
         }

         return out;
     }

     stileDecisione = (decisione) => {
        return impStyles[decisione?decisione.toLowerCase():'nothing'];
     }

     render() {
       return (<>
         {this.state.note &&
             <div className={this.state.risultato=='ok'?impStyles.noteok:impStyles.noteko}>
                {this.state.note}
             </div>
         }
         {!this.state.comandi &&
           <div> 
                <input type="file" onChange={this.onFileChange} /> 
                <button className={cStyles.button} onClick={this.onFileUpload}> 
                  Carica
                </button> 
           </div> 
         }
        {this.state.warning && this.state.warning.length>0 &&
             
           <div><b>Attenzione: il file contiene modifiche ai seguenti nominativi ripetuti in righe diverse. Se si sceglie 'Cambia ovunque' su più di una riga, solo l'ultima sarà presa in considerazione.</b>
           <ul>
               {this.state.warning.map(item => <li>{item}</li>)}
           </ul>
         </div>
        }
	{this.state.comandi &&
	  <div>
            <p>Saranno eseguite le seguenti modifiche alla rubrica:</p>
            <table className={`${impStyles.tabella}`}>
              <thead><tr><th style={{width:'20%'}}>Gruppo</th><th style={{width:'10%'}}>Azione</th><th style={{width:'15%'}}>Nominativo</th><th style={{width:'10%'}}>Ruolo</th><th style={{width:'10%'}}>Altri gruppi</th><th style={{width:'10%'}}>Indirizzo</th><th style={{width:'25%'}}>Contatti</th></tr></thead>
              <tbody>
           {this.state.comandi.map(cmd => <tr className={`${impStyles.riga}`}>
               <td className={`${impStyles.cella}`}>{cmd.nomeGruppo}</td>
               <td>{cmd.decisione!='NOTHING' && <span className={`${this.stileDecisione(cmd.decisione)}` }>{cmd.decisione}</span>}
               {cmd.chiedi && <div>
                     <select onChange={(e)=>{cmd.risposta=(e.target.value=='qui');}}>
                       <option value="ovunque">Cambia ovunque</option>
                       <option value="qui">Cambia solo qui</option>
                     </select>
               </div> }
               </td> 
               <td>{cmd.decisione=='UPDATE' &&  (cmd.nome!=cmd.oldNome || cmd.cognome!=cmd.oldCognome) &&
                   <span className={`${impStyles.deleted}` }>{cmd.oldNome} {cmd.oldCognome} <br/></span>}
                   {cmd.decisione=='DELETE' && <span>{cmd.oldNome} {cmd.oldCognome}</span>}
                   {cmd.nome} {cmd.cognome}</td>  
         
               <td>{cmd.decisione=='UPDATE' && (cmd.nomeRuolo!=cmd.oldNomeRuolo || cmd.specifica!=cmd.oldSpecifica) &&
                   <span className={`${impStyles.deleted}` }>{cmd.oldNomeRuolo} {cmd.oldSpecifica} <br/></span>}
                   {cmd.decisione=='DELETE' && <span>{cmd.oldNomeRuolo} {cmd.oldSpecifica}</span>}
                   {cmd.nomeRuolo} {cmd.specifica}</td> 

               <td>{cmd.nomiGruppiAppartenenza}</td>

               <td>{cmd.decisione=='UPDATE' && (cmd.indirizzo!=cmd.oldIndirizzo) &&
                   <span className={`${impStyles.deleted}` }>{cmd.oldIndirizzo}<br/></span>}
                   {cmd.indirizzo}</td>
               <td>
                  {cmd.contatti.map(cont => <div>
                         <span>{cont.nomeCanale} {cont.oldContatto} {cont.decisione!='NOTHING' && <span className={`${this.stileDecisione(cont.decisione)}` }> {cont.decisione}</span>}</span>
                         <br/>
                     </div> )}
               </td>
             </tr>

) }
           </tbody></table>

          <br/>
          <br/>
          <div style={{maxWidth:'250px',display:'flex',justifyContent:'space-between !important'}}>
          <button className={`${cStyles.button}`} onClick={this.onSubmit}>Conferma</button>
          <button className={`${cStyles.button}`} onClick={()=>{this.setState({comandi:null,selectedFile:null,warning:null})}}>Annulla</button>
          </div>
          </div>
	}

	
	</>)
     }

}