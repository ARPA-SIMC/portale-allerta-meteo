import React, { Component } from "react";
import { AgGridReact  } from 'ag-grid-react';
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { PanelContext } from "../../../context/panelContext";
import { GridReadyEvent, GridApi, CellClassParams } from "ag-grid-community";
import { toast } from "react-toastify";
import { PanelType } from "../../../types.d";
import { Modal } from "../../Modal/Modal";
import { CreateGroupForm } from "../GroupDetailPanel/CreateGroupForm";
import cStyles from "../../../common.module.css";
import { debounced } from '../../../utils';



import {CustomGroupRenderer} from './CustomGroupRenderer'


export class GroupPanel extends Component<any,any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {

    
    selected: [],
    loading: false,
    filter: '',
    data: [],
    timestamp: 0,
    error: null,
    total: 0,
    
    /*dataSource: IDatasource = {
    getRows: (params: IGetRowsParams) => {

      // Use startRow and endRow for sending pagination to Backend
      // params.startRow : Start Page
      // params.endRow : End Page

      const response = await client.groups.all(this.state.filter,params.endRow-params.startRow,params.startRow);
        params.successCallback(
          response.data, response.total
        );

   
    }
  }*/
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

  getNodeChildDetails = (rowItem: any) => {
    if (rowItem.subgroupsCount) {
      return {
        group: true,
        children: rowItem.subgroups,
        key: rowItem.id
      };
    } else { return {group: false} }
  }

  async componentDidMount() {

    window.addEventListener('resize', this.onResize, {passive: true});
    var cacheData = this.context.getCache(this.props.id,'groupData')
    if (!cacheData ) {
    try {
      this.setState({ loading: true })
      this.refetch()
    }
    catch(err) {
      console.error(err);
      this.setState({loading: false, data: [], error: 'API Error', total: 0})
    }
    } else {
	this.setState({data: cacheData})
	}
  }

  componentWillUnmount() {
    window.removeEventListener('resize', this.onResize)
  }

  refetch = async () => {
    try {

      const {data, timestamp} = await client.groups.all(this.state.filter);
      console.log('Compare TS: ' + timestamp + ' and ' + this.state.timestamp)
      if (timestamp<this.state.timestamp) return;

      this.setState({loading: false, data, error: null, timestamp: timestamp})
      this.context.setCache(this.props.id,'groupData',data)
    }
    catch(err) {
      console.error(err);
      this.setState({loading: false, data: [], error: 'API Error'})
      this.context.setCache(this.props.id,'groupData',null)
    }
  }

  handleGroupDeletion = (id: any) => async () => {
    const response = await client.groups.delete(id);
    if(response.code === 204) {
      toast('Gruppo eliminato', {
        type: toast.TYPE.SUCCESS
      })
      Modal.hide()
      this.refetch()
    } else {
      toast('Eliminazione fallita, riprova', {
        type: toast.TYPE.ERROR
      })
    }
  }

  onRemoval = (group: any) => () => {
    Modal.show('Elimina Gruppo',
    <div>
      Procedere con l'eliminazione del Gruppo:
      <br />
      <b>{group.name}</b>
      <button
        className={`${cStyles.button} ${cStyles.actionButton}`}
        onClick={this.handleGroupDeletion(group.id)}
      >
        ELIMINA
      </button>
    </div>
    )
  }

  handleGroupDetail = (id: any) => () => {
    this.context.onSelect(PanelType.GROUP_DETAILS, this.props.id, id, this.state)
  }

  handleNewGroup = () => {
    Modal.show('Crea Gruppo',
      <CreateGroupForm refetch={this.refetch} />
    )
  }

  onSelectionChanged = () => {
    if(this.gridApi){
      const selected = this.gridApi.getSelectedRows()
      this.setState(p => ({...p, selected}))
    }
  }

  handleGroupsRemoval = (groups) => async (event) => {
    const ids = groups.map(({id}) => ({id}))
    const response = await client.groups.deleteMulti(ids)
    if(response.code === 204) {
      toast('Gruppi eliminati', {
        type: toast.TYPE.SUCCESS
      })
      this.setState({selected: []}, ()=> this.refetch())
    } else {
      toast('Eliminazione fallita, riprova', {
        type: toast.TYPE.ERROR
      })
    }
    Modal.hide()
  }

  handleMultiRemoval = (groups) => () => {
    Modal.show(
      'Elimina Gruppi',
      <div style={{textAlign: 'left'}}>
        Eliminare i gruppi: <br />
        {groups.map((group)=>(
          <b key={group.id}> - {group.name} <br/></b>
        ))}
        <button
          className={`${cStyles.button} ${cStyles.actionButton}`}
          onClick={this.handleGroupsRemoval(groups)}
        >
          ELIMINA
        </button>
      </div>
    )
  }

 filterData = async (e) => {
    this.context.setCache(this.props.id,'groupFilter',e.target.value)
    this.setState({filter:e.target.value})
    this.refetch()
  }

 

  render() {
    const {loading, error, selected} = this.state;
    console.log(this.context.loggedUser)
    var filt = this.context.getCache(this.props.id,'groupFilter')

    return (
      <>
        {loading && !this.context.loggedUser && <Loader />}
        {!loading && !error && this.context.loggedUser && (
          <>
          <div style={{alignItems: 'center'}}>
            {this.context.loggedUser.write && (
              <>
              <button
                style={{marginLeft: '.5rem', marginBottom: '.5rem'}}
                className={cStyles.button}
                onClick={this.handleNewGroup}>Crea Gruppo</button>
                {selected && selected.length > 1 && (
                  <button className={cStyles.button} style={{marginLeft: '1rem', marginBottom:'.5rem'}} onClick={this.handleMultiRemoval(selected)}>Elimina Gruppi</button>
                )}
                </>
            )}
          </div>
          <label htmlFor="filtro">Filtra:</label>
          <input defaultValue={filt? filt : ""} name="filtro-gruppo" id="filtro" type="text" onChange={debounced(this.filterData, 350)} />
          <div className="ag-theme-material" style={{flex: 1}}>
            <AgGridReact {...this.props}
              columnDefs={[
                {
                  checkboxSelection: this.context.loggedUser.write,
                  headerName: "Nome Gruppo",
                  field: "name",
                  cellRenderer: "agGroupCellRenderer",
		  cellRendererParams:{suppressCount: true, innerRendererFramework: CustomGroupRenderer },
		  cellStyle:{'textOverflow':'clip'},
                  groupId: "id",
                  //valueFormatter: ({data, value, node}) => {
                  //  if(data.id !== -1) {
                  //    return `📂 ${data.name} - (${data.subgroupsCount} Sottogruppi) - (${data.nominativeCount} Nominativi)`
                  //  } else {
                  //    node.setRowSelectable(false)
                  //    return `🌟 ${data.name} - (${data.nominativeCount} Nominativi)`
                  //  }
                  //},
                },
                {
                  headerName: 'Azioni',
                  width: 110,
                  suppressSizeToFit: true,
                  suppressAutoSize: true,
                  cellRendererFramework: ({data}: CellClassParams) => (
                   
                    <div style={{display: 'flex', justifyContent: 'space-between'}}>
                      <div style={{cursor: 'pointer'}} onClick={this.handleGroupDetail(data.id)}> 🔍
                      </div>
                      {data.id !== -1 &&
                        this.context.loggedUser.write &&
                        <div style={{cursor: 'pointer'}} onClick={this.onRemoval(data)}>
                        ❌
                        </div>
                      }
                    </div>
		  
                  )
                }
              ]}
              
		rowSelection="multiple"
              rowData={this.state.data}
              pagination={true}
              paginationPageSize={10}
              onSelectionChanged={this.onSelectionChanged}
              onFirstDataRendered={this.onGridReady}
              getNodeChildDetails={this.getNodeChildDetails}
            />
          </div>
          </>
        )}
        {!loading && error && ( <div>{error}</div> )}
      </>
    )
  }
}
