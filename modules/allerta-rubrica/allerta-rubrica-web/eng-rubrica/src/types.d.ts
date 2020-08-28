export enum PanelType {
  GROUPS = "GROUPS",
  GROUP_DETAILS = "GROUP_DETAILS",
  LOGS = "LOGS",
  CONTACTS = "CONTACTS",
  CONTACT_DETAILS = "CONTACT_DETAIL",
  PERMISSION = "PERMISSIONS",
  IMPORT = "IMPORT"
}

export interface IPanel {
  id: number| string;
  type: PanelType;
  history?: object[];
  resId?: number;
  currentState?: object;
}

export interface RequestContext<P, F> {
  data: P
  loading: boolean
  error: string
  fetch: (url: any, filters: F | {}) => void
}

export interface Nominative {
  id: number
  firstName: string
  lastName: string
  address: string
  role?: string | null
  contacts: Contact[]
  modificaMinore: boolean
}

export interface Role {
  id: number
  name: string
}

export interface Channel {
  id: number
  name: string
}

export interface Contact {
  id: number
  channelId: number
  value: string
  warning: boolean
  modificaMinore: boolean
}

export interface GroupDetail {
  id?: number
  name?: string
  owner?: {
    id: number
    name: string
  }
  lastEdit?: number
  lastEditUser?: {
    id: number
    firstName: string
    lastName: string
  }
  subgroups?: GroupDetail[]
  nominatives?: Nominative[]
  subgroupsCount?: number
  nominativeCount?: number
}

export interface GroupInput {
  name: string
}

export interface ContactInput {
  nominativeId?: number
  channelId: number
  value: string
  warning: boolean
  modificaMinore?: boolean
}

export interface NominativeInput {
  firstName: string
  lastName: string
  address: string
  group: number
  role: number
  specificaRuolo: string
  telefono?: string
  modificaMinore?: boolean
  email?: string
  contacts?: Contact[]
  groups?: number[]
}

export interface Log {
  description: string
  objectId: number
  operation: string
  table: string
}

export interface PaginatedResponse<P> {
  data: P[]
  offset: number
  limit: number
  total: number
  code: string
}

export interface SimpleListResponse<P> {
  data: P[]
  code: string
}

export interface SimpleResponse<P> {
  code: string
  error?: string[] | string
  data?: P
}
