import React, { Component } from "react";
import { DndProvider } from 'react-dnd'
import HTML5Backend from 'react-dnd-html5-backend'
import {DraggableComponent} from "../../DragDrop/DraggableComponent"


export class CustomGroupRenderer extends Component<any,any> {
    constructor(props) {
        super(props);
    }

    render() {
       console.log(this.props)
       const data = this.props.node.data
        return (
	  <DndProvider backend={HTML5Backend}>
	    <DraggableComponent type='GROUP' data={data.id}>
            <span>📂 {data.name} - ({data.subgroupsCount} Sottogruppi) - ({data.nominativeCount} Nominativi)</span>
	  </DraggableComponent>
		  </DndProvider>
        );
    }
};