import React, { Component, MouseEvent } from "react";
import { ToastContainer } from 'react-toastify';
import { IPanel, PanelType } from "../../types.d";
import { PanelContext } from "../../context/panelContext";
import { Panel } from "../Panel";
import { Timer } from "./Timer"
import { client } from "../../resources";

import styles from "./main.module.css";
import { genID } from "../../utils";
import 'react-toastify/dist/ReactToastify.css';

import { DndProvider } from 'react-dnd'
import HTML5Backend from 'react-dnd-html5-backend'

type MainState = {
  channels: any[]
  roles: any[]
  permissions: any[]
  rolesPermission: any[]
  focusedIndex: number | string
  panels: IPanel[]
  loggedUser: any,
  cache: any,
}

export class Main extends Component<{}, MainState> {
  state = {
    loggedUser: undefined,
    channels: [],
    roles: [],
    permissions: [],
    rolesPermission: [],  
    focusedIndex: '',
    cache: {},
    panels: new Array<IPanel>(
      {id: genID(), type: PanelType.GROUPS, history: []},
    ),
  };

  setCache = (panel: string, key: string, value: object) => {
    var cac = this.state.cache? {... this.state.cache} : {}
    cac[panel+'_'+key] = value
    this.setState({cache: cac})

  };

  getCache = (panel: string, key: string) => {
   return this.state.cache[panel+'_'+key]
  }
    
  onSplit = () => {
    const {panels} = this.state;
    if (panels.length === 2) { return };
    panels.push({
      id: genID(),
      type: PanelType.CONTACTS,
      history: [],
      resId: undefined
    })
    return this.setState({...this.state, panels}, () => {
      window.dispatchEvent(new UIEvent('resize'))
    })
  };

  onMerge = () => {
    const {panels, focusedIndex} = this.state;
    if (panels.length === 1) { return };
    const newPanels = panels.filter(panel => panel.id !== focusedIndex)
    return this.setState({...this.state, panels: newPanels}, () => {
      this.focusId((newPanels[0].id as string))
      window.dispatchEvent(new UIEvent('resize'))
    })
  };

  onFocus = (event: MouseEvent) => {
    event.persist();
    const id = (event.currentTarget as HTMLDivElement).dataset.id;
    this.setState(p => ({focusedIndex: id}))
  };

  focusId = (id: string) => {
    this.setState(p => ({focusedIndex: id}))
  };
  
  onSelect = (type: PanelType, id: number | string, resId?: number, currentState?: object) => {
    const {panels} = this.state;
    
    const newPanels = panels.map((panel: IPanel) => {
      if (panel.id === id) {
        panel.history.push({
          type: panel.type,
          resId: panel.resId,
          currentState: currentState
        })
        panel.type = type;
        panel.resId = resId;
      }
      return panel;
    })
    return this.setState({panels: newPanels, focusedIndex: id})
  };

  onNominative = (resId?: number, currentState?: object) => {
    this.onSelect(PanelType.CONTACT_DETAILS, this.state.focusedIndex, resId, currentState);
  };

  onGroup = (resId?: number, currentState?: object) => {
    this.onSelect(PanelType.GROUP_DETAILS, this.state.focusedIndex, resId, currentState);
  }

  onGoBack = (panelId) => (event: MouseEvent) => {
    const panel = this.state.panels.find(el => el.id === panelId)
    const panelHistory = panel.history
    const poppedElement: any = panelHistory.pop()
    const newPanels = this.state.panels.map(el => {
      if (el.id === panelId) {
        el.resId = poppedElement.resId
        el.type = poppedElement.type
        el.currentState = poppedElement.currentState
        return el 
      } else {
        return el
      }
    })
    this.setState(p => ({
      panels: newPanels
    }))
  }

  async componentDidMount() {
    const {data: channels } = await client.channels.all();
    const {data: roles} = await client.roles.all();
    const {data: permissions} = await client.permission.all();
    const {data: rolesPermission} = await client.rolesPermission.all();
    const {data: loggedUser} = await client.loggedUser();
    this.setState(p => ({...p, channels, roles, loggedUser, permissions, rolesPermission}));
  }

  render() {
    const {panels, channels, roles, loggedUser, focusedIndex, permissions, rolesPermission, cache} = this.state;
    console.log('Main.render')
    console.log(HTML5Backend)
    return (
      <DndProvider backend={HTML5Backend}>
      <main className={`${styles.mainWrapper}`}>
	<Timer />
        <section className={`${styles.panelsGrid} ${styles[`grid${panels.length}`]}`}>
          <PanelContext.Provider value={{
            loggedUser,
            roles,
            channels,
            panels,
            focusedIndex,	
            permissions,
            rolesPermission,
            getCache: this.getCache,
            setCache: this.setCache,
            onGoBack: this.onGoBack,
            onMerge: this.onMerge,
            onSplit: this.onSplit,
            onSelect: this.onSelect,
            onFocus: this.onFocus,
            focusId: this.focusId,
          }}>
            {panels.map(({id, type, currentState}) => <Panel key={`panel_${id}`} id={(id as string)} type={type} 
            	currentState={currentState}  />)}
          </PanelContext.Provider>
        </section>
        <ToastContainer />
      </main>
     </DndProvider>
    );
  }
}
