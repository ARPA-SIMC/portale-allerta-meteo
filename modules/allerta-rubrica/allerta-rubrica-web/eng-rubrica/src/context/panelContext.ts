import { createContext, MouseEvent } from 'react';
import { PanelType, IPanel } from '../types';

const PanelContext = createContext({
  loggedUser: undefined,
  roles: new Array<any>(),
  rolesPermission: new Array<any>(),
  categories: new Array<any>(),
  permissions: new Array<any>(),
  channels: new Array<any>(),
  rubriche: new Array<any>(),
  panels: new Array<IPanel>(),
  focusedIndex: '',
  onGoBack: (panelId: string) => (event: MouseEvent) => {},
  onMerge: () => {},
  onSplit: () => {},
  onSelect: (type: PanelType, id: number | string, resId?: number, currentState?: object) => {},
  onFocus: (event: MouseEvent) => {},
  focusId: (id: string) => {},
  
  getCache: (panel: string, key:string) => { return null; },
  setCache: (panel: string, key: string, value: object) => {},
});

export {PanelContext};
