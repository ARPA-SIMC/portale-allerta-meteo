import { string } from "prop-types"
import { Nominative, GroupDetail, GroupInput, NominativeInput, ContactInput } from "./types";
import { userInfo } from "os";

//const host = "https://vm184lnx.ente.regione.emr.it:8443"
const host = ""
//const baseUrl = "/api/jsonws/Rubrica-portlet."
const baseUrl = "/api/jsonws/rubrica."

const endpoints = {
  groups:
    `${host + baseUrl}rubricagruppo/groups`,
  groupsMulti:
    `${host + baseUrl}rubricagruppo/groups-multi`,
  groupNominatives:
    `${host + baseUrl}rubricagrupponominativi/group-nominatives`,
  groupNominativesMulti:
    `${host + baseUrl}rubricagrupponominativi/group-nominatives-multi`,
  subgroups:
    `${host + baseUrl}rubricagruppogruppi/group-subgroups`,
  subgroupsMulti:
  `${host + baseUrl}rubricagruppogruppi/group-multi-subgroups`,
  supergroupsMulti:
    `${host + baseUrl}rubricagruppogruppi/group-multi-supergroups`,
  nominatives:
    `${host + baseUrl}rubricanominativo/nominatives`,
  nominativesMulti:
    `${host + baseUrl}rubricanominativo/nominatives-multi`,
  nominativesGroupsMulti:
    `${host + baseUrl}rubricanominativo/nominatives-groups-multi`,
  contacts:
    `${host + baseUrl}rubricacontatto/contacts`,
  contactsMulti:
    `${host + baseUrl}rubricacontatto/contacts-multi`,
  roles:
    `${host + baseUrl}rubricaruolorubrica/address-book-roles`,
  permission:
    `${host + baseUrl}rubricapermessi/permission`,
  rolePermission:
    `${host + baseUrl}rubricaruolopermessi/role-permission`,
  channels:
    `${host + baseUrl}rubricacanale/channels`,
  logs:
    `${host + baseUrl}rubricalog/logs`,
  loggedUser:
    `${host + baseUrl}rubricaruolopermessi/user-info`
}

const headers = new Headers()
headers.append('Cookie', 'JSESSIONID=1B406693174873A0DB2B429F9C4C4083.node01')
headers.append('Access-Control-Allow-Origin', 'https://vm184lnx.ente.regione.emr.it:8443')

const getFetch = async (url: string, params?: string) => {
  // to include session cookies, if does not work try using 'include'
  const res = await fetch(`${url}?${params}`, {
    headers,
    method: "GET",
    credentials: "include"
  })

  const data = await res.json()

  if (data.code !== 200) {
    console.error('api error:', data.error)
    throw new Error(data.error)
  }

  return data
}

const postFetch = async (url: string, obj: any, params?: string) => {
  const form = new FormData()
  form.append('data', JSON.stringify(obj))

  const fetchUrl = params ? `${url}?${params}` : url

  const res = await fetch(fetchUrl, {
    headers,
    method: 'POST',
    credentials: "include",
    body: form
  })

  const data = await res.json()
  if (data.code !== 201) {
    console.error('api error:', data.error)
    throw new Error(data.error)
  }
  console.log(data.success)
  return data
}

const putFetch = async (url: string, params: string, obj: any) => {
  const form = new FormData()
  form.append('data', JSON.stringify(obj))

  const res = await fetch(`${url}?${params}`, {
    headers,
    method: 'PUT',
    credentials: 'include',
    body: form
  })

  const data = await res.json()
  console.log(data)
  if (data.code !== 204) {
    console.error('api error:', data.error)
    throw new Error(data.error)
  }
  console.log(data.success)
  return data
}

const deleteFetch = async (url: string, params: string, obj?: any) => {
  let body

  if (obj) {
    const form = new FormData()
    form.append('data', JSON.stringify(obj))
    body = form
  }

  const res = await fetch(`${url}?${params}`, {
    headers,
    body,
    method: "DELETE",
    credentials: "include" // to include session cookies, if does not work try using 'include'
  })

  const data = await res.json()
  if (data.code!== 201 && data.code !== 204) {
    console.error('api error:', data.error)
    throw new Error(data.error)
  }
  console.log(data.success)
  return data
}

const getGroups = async (
  name: string = "",
  limit: number | string = 10000,
  offset: number | string = 0
) => {
  const params = new URLSearchParams()
  params.append("name", name)
  params.append("limit", limit.toString())
  params.append("offset", offset.toString())

  try {
    const data = await getFetch(endpoints.groups, params.toString())
    return data
  } catch(e) {
    throw e
  }
}

const getNominatives = async (
  name: string = "",
  limit: number | string = 10,
  offset: number | string = 0
) => {
  const params = new URLSearchParams()
  params.append("name", name)
  params.append("limit", limit.toString())
  params.append("offset", offset.toString())

  try {
    const data = await getFetch(endpoints.nominatives, params.toString())
    return data
  } catch(e) {
    throw e
  }
}

const getPermissions = async () => {
  try {
    const data = await getFetch(endpoints.permission)
    return data
  } catch(e) {
    throw e
  }
}

const getRolesPermission = async () => {
  try {
    const data = await getFetch(endpoints.rolePermission, '')
    return data
  } catch(e) {
    throw e
  }
}

const getRoles = async () => {
  try {
    const data = await getFetch(endpoints.roles)
    return data
  } catch(e) {
    throw e
  }
}

const getChannels = async () => {
  try {
    const data = await getFetch(endpoints.channels)
    return data
  } catch(e) {
    throw e
  }
}

const getLoggedUser = async () => {
  try {
    const data = await getFetch(endpoints.loggedUser)
    return data
  } catch(e) {
    throw e
  }
}

const getLogs = async (name: string, limit: number | string = 10, offset: number | string = 0) => {
  const params = new URLSearchParams()
  params.append("name", name)
  params.append("limit", limit.toString())
  params.append("offset", offset.toString())

  const data = await getFetch(endpoints.logs, params.toString())
  return data
}

const getNominativeById = async (id: number) => {
  const params = new URLSearchParams()
  params.append("id", id.toString())

  const data = await getFetch(endpoints.nominatives, params.toString())
  return data
}

const getGroupById = async (id: number) => {
  const params = new URLSearchParams()
  params.append("id", id.toString())

  const data = await getFetch(endpoints.groups, params.toString())
  return data
}

const postNominative = async (nominative: NominativeInput) => {
  const data = await postFetch(endpoints.nominatives, nominative)
  return data
}

const postContact = async (contact: ContactInput) => {
  const data = await postFetch(endpoints.contacts, contact)
  return data
}

const postGroup = async (group: GroupInput) => {
  const data = await postFetch(endpoints.groups, group)
  return data
}

const putContact = async (id: number, contact: ContactInput) => {
  const {channelId, nominativeId, value, warning, modificaMinore} = contact
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = {
    channelId,
    nominativeId,
    value,
    warning,
    modificaMinore
  }

  const res = await putFetch(endpoints.contacts, params.toString(), data)
  return res
}

const putNominative = async (id: number | string, nominative: NominativeInput) => {
  const {firstName, lastName, address, modificaMinore} = nominative
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = {
    firstName,
    lastName,
    address,
    modificaMinore
  }
  const res = await putFetch(endpoints.nominatives, params.toString(), data)
  return res
}

const setNominativeRole = async (groupId: number | string, nominativeId: number | string, roleId: number | string) => {
  const params = new URLSearchParams()
  params.append('id', groupId.toString())

  const data = await postFetch(endpoints.groupNominatives, {
    nominativeId,
    role: roleId
  }, params.toString())
  return data
}

const setNominativesRole = async (groupId: number | string, nominatives: any[]) => {
  const params = new URLSearchParams()
  params.append('id', groupId.toString())

  const data = await postFetch(endpoints.groupNominativesMulti, nominatives, params.toString())
  return data
}

const setGroupsNominativeRole = async (id: number | string, ids: any[]) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())

  const data = await postFetch(endpoints.nominativesGroupsMulti, ids, params.toString())
  return data
}



const updateRolePermission = async (roleId: number | string, permission: boolean, read: boolean, write: boolean) => {
  const obj = [{
    permission,
    read,
    write,
    roleId
  }]
  const data = await putFetch(endpoints.rolePermission, "", obj)
  return data
}

const unsetNominativeRole = async (groupId: number | string, nominativeId: number | string) => {
  const params = new URLSearchParams()
  params.append('id', groupId.toString())
  const data = await deleteFetch(endpoints.groupNominatives, params.toString(), {nominativeId})
  return data
}

const unsetNominativesRole = async (groupId: number | string, nominativeIds: number[] | string[]) => {
  const params = new URLSearchParams()
  params.append('id', groupId.toString())
  const data = await deleteFetch(endpoints.groupNominativesMulti, params.toString(), nominativeIds)
  return data
}

const unsetGroupsRole = async (groupId: number | string, nominatives: number[] | string[]) => {
  const params = new URLSearchParams()
  params.append('id', groupId.toString())
  const data = await deleteFetch(endpoints.nominativesGroupsMulti, params.toString(), nominatives)
  return data
}

const putGroup = async (id: number | string, group: GroupInput) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await putFetch(endpoints.groups, params.toString(), group)
  return data
}

const deleteGroup = async (id: number | string) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await deleteFetch(endpoints.groups, params.toString())
  return data
}

const deleteNominative = async (id: number | string) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await deleteFetch(endpoints.nominatives, params.toString())
  return data
}

const deleteNominatives = async (ids: number[] | string[]) => {
  const data = await deleteFetch(endpoints.nominativesMulti, "", ids)
  return data
}

const deleteGroups = async (ids: number[] | string[]) => {
  const data = await deleteFetch(endpoints.groupsMulti, "", ids)
  return data
}

const deleteContact = async (id: number | string) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await deleteFetch(endpoints.contacts, params.toString())
  return data
}

const deleteContacts = async (ids: {id: number|string}[]) => {
  // const params = new URLSearchParams()
  const data = await deleteFetch(endpoints.contactsMulti, "", ids)
  return data
}

const setSubgroup = async (id: number | string, subgroupId: number | string) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await postFetch(endpoints.subgroups, {subgroupId}, params.toString())
  return data
}
const setSubgroupMulti = async (id: number | string, subgroupIds: string[] | number[]) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await postFetch(endpoints.subgroupsMulti, subgroupIds, params.toString())
  return data
  }

  const setSupergroupMulti = async (id: number | string, subgroupIds: string[] | number[]) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await postFetch(endpoints.supergroupsMulti, subgroupIds, params.toString())
  return data
}

const removeSubgroup = async (id: number | string, subgroupId: number | string) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await deleteFetch(endpoints.subgroups, params.toString(), {subgroupId})
  return data
}

const removeSubgroups = async (id: number | string, subgroupIds: number[] | string[]) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await deleteFetch(endpoints.subgroupsMulti, params.toString(), subgroupIds)
  return data
  }

 const removeSupergroups = async (id: number | string, subgroupIds: number[] | string[]) => {
  const params = new URLSearchParams()
  params.append('id', id.toString())
  const data = await deleteFetch(endpoints.supergroupsMulti, params.toString(), subgroupIds)
  return data
}

const client = {
  groups: {
    setNominativeRole,
    setNominativesRole,
    setGroupsNominativeRole,
    unsetNominativeRole,
    unsetNominativesRole,
    unsetGroupsRole,
    setSubgroup,
    setSubgroupMulti,
    setSupergroupMulti,
    removeSubgroup,
    removeSubgroups,
    removeSupergroups,
    all: getGroups,
    getById: getGroupById,
    create: postGroup,
    update: putGroup,
    delete: deleteGroup,
    deleteMulti: deleteGroups
  },
  nominatives: {
    all: getNominatives,
    getById: getNominativeById,
    create: postNominative,
    update: putNominative,
    delete: deleteNominative,
    deleteMulti: deleteNominatives
  },
  contacts: {
    create: postContact,
    delete: deleteContact,
    deleteMulti: deleteContacts,
    update: putContact
  },
  permission: {
    all: getPermissions
  },
  rolesPermission: {
    all: getRolesPermission,
    update: updateRolePermission
  },
  roles: {
    all: getRoles
  },
  channels: {
    all: getChannels
  },
  logs: {
    all: getLogs
  },
  loggedUser: getLoggedUser
}

export default endpoints
export {
  headers,
  client
}
