import React, {PureComponent} from "react";
import { PanelType } from "../../../types.d";
import { PanelContext } from "../../../context/panelContext";
import styles from "./PanelSelector.module.css"
import { getResId } from "../../../utils";

type SelectorProps = {
  id: number | string,
  selected: PanelType  
}

type SelectorState = {
  open: boolean
}

export class PanelSelector extends PureComponent<SelectorProps, SelectorState> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>
  state = {
    open: false
  }

  handleOpening = () => this.setState(prevState => ({open: !prevState.open}));
  selectContact = () => this.context.onSelect(PanelType.CONTACTS, this.props.id);
  selectGroups = () => this.context.onSelect(PanelType.GROUPS, this.props.id);
  selectLogs = () => this.context.onSelect(PanelType.LOGS, this.props.id); 
  selectPermission = () => this.context.onSelect(PanelType.PERMISSION, this.props.id); 
  selectImport = () => this.context.onSelect(PanelType.IMPORT, this.props.id); 

  getNameFromPanelType = (panelType: PanelType) => {
    switch(panelType) {
      case PanelType.LOGS:
        return '🗂 LOGS'
      case PanelType.CONTACTS:
        return '📑 NOMINATIVI'
      case PanelType.CONTACT_DETAILS:
        return '📑 DET NOMINATIVO'
      case PanelType.GROUPS:
        return '🗃 GRUPPI'
      case PanelType.GROUP_DETAILS:
        return '🗃 DET GRUPPO'
      case PanelType.PERMISSION:
        return '⚙️ PERMESSI'
      case PanelType.IMPORT:
        return '🌟 IMPORTA'
    }
  }
  
  render() {
    const {selected} = this.props;
    const {open} = this.state;
    return (
      <div className={`${styles.panelSelector}`}>
        <ul onClick={this.handleOpening} className={`${styles.selectorOptions} ${open ? styles.opened : styles.closed} ${this.context.loggedUser && this.context.loggedUser.permission ? styles.admin : ''}`}>
        {open && (
          <>
            <li className={styles.selectorItem} onClick={this.selectContact}>{this.getNameFromPanelType(PanelType.CONTACTS)}</li>
            <li className={styles.selectorItem} onClick={this.selectGroups}>{this.getNameFromPanelType(PanelType.GROUPS)}</li>
            <li className={styles.selectorItem} onClick={this.selectLogs}>{this.getNameFromPanelType(PanelType.LOGS)}</li>
            {this.context.loggedUser.write && (
              <li className={styles.selectorItem} onClick={this.selectImport}>{this.getNameFromPanelType(PanelType.IMPORT)}</li>
            )}
          </>
        )}
        {!open && (
          <li className={styles.selectorItem}>{this.getNameFromPanelType(selected)}</li>
        )}
        </ul>
      </div>
    );
  }
}