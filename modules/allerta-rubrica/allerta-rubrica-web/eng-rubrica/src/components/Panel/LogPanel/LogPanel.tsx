import React, { Component } from "react";
import { AgGridReact } from 'ag-grid-react';
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { GridApi, GridReadyEvent } from "ag-grid-community";
import { TableTooltip } from "../../Tooltip";

type LogPanelState = {
  loading: boolean;
  data?: any;
  error?: string | null;
}

export class LogPanel extends Component<any, LogPanelState> {
  state = {
    loading: false,
    data: [],
    error: null
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

  async componentDidMount() {
    window.addEventListener('resize', this.onResize, {passive: true});
    try {
      this.setState({ loading: true })
      const {data} = await client.logs.all('', 1000, 0);
      this.setState({ loading: false, data, error: null})
    }
    catch(err) {
      console.error(err);
      this.setState({loading: false, data: [], error: 'API Error'})
    }    
  }

  componentWillUnmount() {
    window.removeEventListener('resize', this.onResize)
  }

  render() {
    const {loading, error} = this.state;
    return (
      <>
        {loading && <Loader />}
        {!loading && !error && (
          <div className="ag-theme-material" style={{height: '100%'}}>
            <AgGridReact 
              
              columnDefs={[
                {headerName: "Chi", width: 55, field: "editUser", tooltipField: "editUser", sortable: true, filter: true, cellRenderer: ({value}) => `${value && value.firstName} ${value && value.lastName}`},
                {headerName: "Quando", width: 55, field: "editDate", sortable: true, cellRenderer: ({value}) => {
		var d = new Date()
		d.setTime(value)
		return d.toLocaleString('it-IT')
		}},
                {headerName: "Cosa", tooltipComponent: "tooltip", tooltipField: "description", filter: true, sortable: true, cellRenderer: ({data}) => {
                  return `[${data && data.table}]: ${data && data.description}`
                }},
                {headerName: "Azione", width: 55, sortable: true, field: "operation"},
              ]}
              rowData={this.state.data} 
              pagination={true}
              paginationPageSize={10}
              onFirstDataRendered={this.onGridReady}
              frameworkComponents={{ tooltip: TableTooltip }}
              />
          </div>
        )}
        {!loading && error && ( <div>{error}</div> )}
      </>
    )
  }
}