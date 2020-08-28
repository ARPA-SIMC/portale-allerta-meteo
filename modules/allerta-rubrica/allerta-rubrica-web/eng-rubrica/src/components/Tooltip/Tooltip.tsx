import React, {Component} from 'react';

export default class TableTooltip extends Component<any, any> {
  componentDidMount() {
    this.props.reactContainer.className = 'ag-tooltip';
  }

  render() {
    const data = this.props.api.getRowNode(this.props.rowIndex).data;
    return (
      <div>
        <p><span>{`[${data && data.table}]:`}</span></p>
        <p><span>{`${data && data.description}`}</span></p>
      </div>
    );
  }
}