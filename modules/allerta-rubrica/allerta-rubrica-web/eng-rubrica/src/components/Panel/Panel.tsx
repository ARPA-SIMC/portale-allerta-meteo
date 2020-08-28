import React, {PureComponent, MouseEvent} from "react";
import { PanelType } from "../../types.d";
import styles from "./Panel.module.css";
import { PanelContext } from "../../context/panelContext";
import { PanelSelector } from "./PanelSelector";
import { ContactPanel } from "./ContactPanel";
import { GroupPanel } from "./GroupPanel";
import { LogPanel } from "./LogPanel";
import { ContactDetailPanel } from "./ContactDetailPanel";
import { GroupDetailPanel } from "./GroupDetailPanel";
import { PermissionPanel } from "./PermissionPanel";
import { ImportPanel } from "./ImportPanel";

import { DroppableComponent } from "../DragDrop/DroppableComponent";

type PanelProps = {
  id: string,
  type: PanelType,
  currentState?: object;
}

export class Panel extends PureComponent<PanelProps,{inFocus: boolean}> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>
  panelRef = React.createRef<HTMLDivElement>()
  state = { 
    inFocus: true
  }

  focus = (e) => {
    if (this.props.id === this.context.focusedIndex) {
      this.setState({inFocus: true})
    } else {
      this.setState({inFocus: false})
    }
    this.context.focusId(this.props.id)
  }

  componentDidUpdate() {
    if (this.props.id !== this.context.focusedIndex) {
      this.setState({inFocus: false})
    } else {
      this.setState({inFocus: true})
    }
  }

  componentDidMount() {
    this.context.focusId(this.props.id)
    this.panelRef.current.addEventListener('click', this.focus)
  }

  componentWillUnmount() {
    this.panelRef.current.addEventListener('click', this.focus)
  }

  refCallback = (c) => {
            	if (c && c.props && c.props.id) {
            	 window['rubrica_panel_'+c.props.id] = c
            	 console.log('rubrica_panel_'+c.props.id)
            	 console.log(window['rubrica_panel_'+c.props.id].state)
            	 }
   }

  dropCallback = (item,monitor) => {
    console.log('dropCallback')
    if (!item || !item.type) return

    if (item.type==='GROUP') this.context.onSelect(PanelType.GROUP_DETAILS,this.props.id,item.data)
    if (item.type==='CONTACT') this.context.onSelect(PanelType.CONTACT_DETAILS,this.props.id,item.data)
  }

  render() {
    const {type} = this.props;    
    return (
     <DroppableComponent accept={['GROUP','CONTACT']} drop={this.dropCallback}>
      <div className={`${styles.panel} ${this.state.inFocus ? styles.inFocus : ''}` } ref={this.panelRef} data-id={this.props.id}>
        <div className={styles.panelHeader}>
          <PanelSelector id={this.props.id} selected={this.props.type}/>
          <div style={{display: 'flex'}}>
            {this.context.panels.find(el => el.id === this.props.id).history.length > 0 && (
              <div tabIndex={0} onClick={this.context.onGoBack(this.props.id)} style={{cursor: 'pointer', marginRight: '1rem'}}> 🔙 </div>
            )}
            <div tabIndex={0} onClick={this.context.onSplit} style={{cursor: 'pointer', marginRight: '1rem'}}> ➕ </div>
            <div tabIndex={0} onClick={this.context.onMerge} style={{cursor: 'pointer'}}> ➖ </div>
          </div> 
        </div>
        <div className={styles.panelBody}>
          {type === PanelType.CONTACTS && <ContactPanel id={this.props.id} currentState={this.props.currentState} />}
          {type === PanelType.CONTACT_DETAILS && <ContactDetailPanel id={this.props.id} currentState={this.props.currentState} />}
          {type === PanelType.GROUPS && <GroupPanel id={this.props.id} currentState={this.props.currentState}  />}
          {type === PanelType.GROUP_DETAILS && <GroupDetailPanel id={this.props.id} currentState={this.props.currentState} />}
          {type === PanelType.LOGS && <LogPanel id={this.props.id} currentState={this.props.currentState}  />}
          {type === PanelType.PERMISSION && <PermissionPanel id={this.props.id} currentState={this.props.currentState} />}
          {type === PanelType.IMPORT && <ImportPanel id={this.props.id} currentState={this.props.currentState} />}
        </div>
      </div>
     </DroppableComponent>
    )
  }
}