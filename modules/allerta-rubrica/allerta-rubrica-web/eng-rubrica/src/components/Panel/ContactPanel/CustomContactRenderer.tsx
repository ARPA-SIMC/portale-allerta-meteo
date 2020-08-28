import React, { Component } from "react";
import { DndProvider } from 'react-dnd'
import HTML5Backend from 'react-dnd-html5-backend'
import {DraggableComponent} from "../../DragDrop/DraggableComponent"


export class CustomContactRenderer extends Component<any,any> {
    constructor(props) {
        super(props);
    }

    render() {
       console.log(this.props)
       const data = this.props.node.data
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
		  </DndProvider> );
    }
};