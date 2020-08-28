import React, { PureComponent } from "react";
import { AgGridReact } from 'ag-grid-react';
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { PanelContext } from "../../../context/panelContext";
import { CellClassParams, GridReadyEvent, GridApi } from "ag-grid-community";
import { PanelType } from "../../../types.d";
import { toast } from "react-toastify";
import { Modal } from "../../Modal/Modal";
import { CreateNominativeForm } from "../ContactDetailPanel/CreateNominativeForm";
import { CreateGreaterNominativeForm } from "../ContactDetailPanel/CreateGreaterNominativeForm";
import { MoveNominativeForm } from "./MoveNominativeForm";
import cStyles from "../../../common.module.css"
import lStyles from "../../Loader/Loader.module.css"
import { debounced } from '../../../utils';

import { DndProvider } from 'react-dnd'
import HTML5Backend from 'react-dnd-html5-backend'
import {DraggableComponent} from "../../DragDrop/DraggableComponent"


export class ContactPanel extends PureComponent<any,any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {
    loading: true,
    data: [],
    filter: '',
    error: null,
    timestamp: 0,
    selected: [],
    total: 0
  }

  gridApi: GridApi | null = null;

  onGridReady = (params: GridReadyEvent) => {
    this.gridApi = params.api;
    this.gridApi.sizeColumnsToFit();
  }

  onResize = () => {
    if(this.gridApi) {
      this.gridApi.sizeColumnsToFit();
    }
  }

  handleNewNominative = () => {
   /* Modal.show('Crea Nominativo', <CreateNominativeForm refetch={this.refetch} />, null, null)*/
    Modal.showTall('Crea Nominativo', (
      <CreateGreaterNominativeForm refetch={this.refetch} roles={this.context.roles} />
    ))
  
  }

  handleNominativeClick = (id: any) => () => this.context.onSelect(PanelType.CONTACT_DETAILS, this.props.id, id, this.state);

  handleNominativeRemoval = (id: any) => async () => {
    const response = await client.nominatives.delete(id)
    if(response.code === 204) {
      toast('Nominativo cancellato con successo', {
        type: toast.TYPE.SUCCESS
      })
      this.refetch()
      Modal.hide()
    } else {
      toast('Cancellazione fallita, riprova', {
        type: toast.TYPE.ERROR
      })
    }
  }

  handleNominativesRemoval = (nominatives) => async (event) => {
    const ids = Array.isArray(nominatives)? nominatives.map(({id}) => {
      return {id};
    }) : [].concat({"id":nominatives});
    const response = await client.nominatives.deleteMulti(ids)
    if(response.code >= 200 && response.code<300) {
      toast('Nominativi eliminati', {
        type: toast.TYPE.SUCCESS
      })
      this.setState({selected: []},()=> this.refetch())
    } else {
      toast('Eliminazione fallita, riprova', {
        type: toast.TYPE.ERROR
      })
    }
    Modal.hide()
  }

  handleRemoval = (nominative: any) => () => {
    Modal.show(
      'Eliminazione nominativo',
      <div className="leftAligned">
        Conferma la rimozione del nominativo:
        <br />
        <div className={cStyles.modalList}>
          <b>- {nominative.firstName} {nominative.lastName}</b>
        </div>
        <button
          className={`${cStyles.button} ${cStyles.actionButton}`}
          onClick={this.handleNominativesRemoval(nominative.id)}
        >
          ELIMINA
        </button>
      </div>,
    )
  }

  handleMultiRemoval = (nominatives) => () => {
    Modal.show(
      'Eliminazione nominativi',
      <div className={`leftAligned ${cStyles.listedContent}`}>
        Conferma la rimozione dei nominativi: <br />
        <div className={cStyles.modalList}>
          {nominatives.map((nominative)=>(
            <b key={nominative.id} className={cStyles.modalItem}> - {nominative.firstName} {nominative.lastName}<br/></b>
          ))}
        </div>
        <button
          className={`${cStyles.button} ${cStyles.actionButton}`}
          onClick={this.handleNominativesRemoval(nominatives)}
        >
          ELIMINA
        </button>
      </div>
    )
  }

  refetch = async () => {
    try {
      const data = await client.nominatives.all(this.state.filter, 100000, 0);
      if (data.timestamp<this.state.timestamp) return;
      this.setState({ loading: false, data: data.data, error: null, timestamp: data.timestamp})
      this.context.setCache(this.props.id,'contactData',data.data)
    }
    catch(err) {
      console.error(err);
      this.setState({loading: false, data: [], error: 'API Error'})
      this.context.setCache(this.props.id,'contactData',null)
    }
  }

  onSelectionChanged = () => {
    if (this.gridApi) {
      this.setState(p => ({...p, selected: this.gridApi.getSelectedRows() }))
    }
  }

  handleMove = () => {
    Modal.show(
      'Sposta nominativo/i',
      <MoveNominativeForm nominatives={this.state.selected}/>,
    )
  }

  async componentDidMount() {
    window.addEventListener('resize', this.onResize, {passive: true});
    var cacheData = this.context.getCache(this.props.id,'contactData')
    if (cacheData) this.setState({data: cacheData, loading:false})
    else {
    try {
      this.refetch()
    }
    catch(err) {
      console.error(err);
      this.setState({loading: false, data: [], error: 'API Error'})
    }
    }
  }

  componentWillUnmount() {
    window.removeEventListener('resize', this.onResize )
  }

 filterData = async (e) => {
    this.context.setCache(this.props.id,'contactFilter',e.target.value)
    this.setState({filter:e.target.value})
    this.refetch()
  }

  colDefs = [
    {headerName: "", checkboxSelection: true, width: 20},
    {headerName: "Nominativo" , 
cellRendererFramework: ({data}: CellClassParams) => {
	var gruppi = ''
	var k
	if (data && data.groups && data.groups.length>0) {
		for (k=0; k<data.groups.length; k++) {
			if (k>0) gruppi+=', '
			gruppi+=data.groups[k].name
		}
	}
	return  (<DndProvider backend={HTML5Backend}>
	    <DraggableComponent type='CONTACT' data={data.id}><div style={{'lineHeight':'23px'}}>
	{data && data.firstName} {data && data.lastName} {data && !data.firstName && !data.lastName && 'Senza nome'} <br/>
	{gruppi}
	</div></DraggableComponent>
		  </DndProvider>) 

}
},
    {headerName: "Contatti", width: 55, cellRenderer: ({data}: CellClassParams) => (`${data && data.contacts && data.contacts.length}`)},
    {headerName: "Ultima Modifica", width: 50, cellRenderer: ({data}: CellClassParams) => {
	const dat = new Date()
	if (data && data.lastEdit) {
        	dat.setTime(data.lastEdit)
		return dat.toLocaleString('it-IT')
	}
	return ''
	}},
    {headerName: "Azioni", width: 100, suppressSizeToFit: true, cellRendererFramework: ({data}: CellClassParams) => {
      return (
        <div className={cStyles.tabActions}>
          <div style={{cursor: 'pointer'}} onClick={this.handleNominativeClick(data.id)}> 🔍 </div>
          <div style={{cursor: 'pointer'}} onClick={(this.context.loggedUser && this.context.loggedUser.write) && this.handleRemoval(data)}> ❌ </div>
        </div>
      )
    }}
  ]

  render() {
    const {loading, error, selected} = this.state;

    var filt = this.context.getCache(this.props.id,'contactFilter')
    return (
      <>
        {loading && !this.context.loggedUser && (
          <Loader />
        )}
        {!loading && !error && this.context.loggedUser && (
          <>
          <div className={cStyles.buttonRow}>
            <button
              className={cStyles.button}
              disabled={this.context.loggedUser && !this.context.loggedUser.write}
              onClick={this.handleNewNominative}
            >
              Crea Nominativo
            </button>
            {selected && selected.length >= 1 && (
              <button
                className={cStyles.button}
                style={{marginLeft: '1rem'}}
                disabled={this.context.loggedUser && !this.context.loggedUser.write}
                onClick={this.handleMultiRemoval(selected)}
              >
                Elimina Nominativi
              </button>
            )}
          </div>
          <label htmlFor="filtro">Filtra:</label>
          <input id="filtro" defaultValue={filt? filt : ""} type="text" onChange={debounced(this.filterData, 350)} />
          <div className="ag-theme-material">
            <AgGridReact
              columnDefs={this.colDefs}
              rowSelection="multiple"
              suppressRowClickSelection={true}
              rowData={this.state.data}
              onSelectionChanged={this.onSelectionChanged}
              pagination={true}
              paginationPageSize={20}
              onFirstDataRendered={this.onGridReady}
            />
          </div>
          </>
        )}
        {!loading && error && (
          <div className={lStyles.loader}>{error}</div>
        )}
      </>
    )
  }
}
