import React, {PureComponent} from 'react';
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { PanelContext } from '../../../context/panelContext';
import styles from './GroupDetailPanel.module.css';
import { CreateGroupForm } from './CreateGroupForm';
import { GroupForm } from './GroupForm';
import { AddSubgroupForm } from './AddSubgroupForm';
import { toast } from 'react-toastify';
import { AddNominativeForm } from './AddNominativeForm';
import { CreateGreaterNominativeForm } from '../ContactDetailPanel/CreateGreaterNominativeForm';
import { getResId } from '../../../utils';
import { PanelType } from '../../../types.d';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css"
import { GroupList } from './GroupList';
import { AddNominativesForm } from './AddNominativesForm';

import {DraggableComponent} from '../../DragDrop/DraggableComponent'

interface GroupDetailState {
  selectedGroups: any[];
  selectedSupergroups: any[];
  selectedNominatives: any[];
  data: any;
  editedNominative: any;
  loading: boolean;
  error: string | null;
  resId?: number;
}

export class GroupDetailPanel extends PureComponent<any, GroupDetailState> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {
    selectedGroups: [],
    selectedSupergroups: [],
    selectedNominatives: [],
    editedNominative: null,
    data: ({} as any),
    loading: true,
    error: null,
    resId: undefined
  }

  async componentDidMount() {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    if(resId) {
      try {
        const {data} = await client.groups.getById(resId)
        this.setState({loading: false, data, error: null, resId})
      } catch(err) {
        this.setState({loading: false, data: null, error: 'API Error'})
      }
    }
  }

toggleNominative = (nominative) => {
  console.log('toggle nominative '+nominative)
  this.setState({editedNominative: (nominative==this.state.editedNominative?null:nominative)})
}

  componentDidUpdate(prevProps, prevState) {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    if(resId !== this.state.resId) {
      this.refetch()
    }
  }

  refetch = async () => {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    if(resId) {
      try {
        const {data} = await client.groups.getById(resId)
        this.setState({loading: false, data, error: null, resId})
      } catch(err) {
        this.setState({loading: false, data: null, error: 'API Error'})
      }
    }
  }

  onGroupDetail = (id: any) => () => {
    this.context.onSelect(PanelType.GROUP_DETAILS, this.props.id, id)
    // this.refetch() // Needed or data props won't update
  }

  onNominativeDetail = (id: any) => () => {
    this.context.onSelect(PanelType.CONTACT_DETAILS, this.props.id, id)
    // this.refetch() // Needed or data props won't update
  }

  deleteSubgroup = (id: any) => async () => {
    const {data} = this.state;
    const response = await client.groups.removeSubgroup(data.id, id);
    if (response.code < 300) {
      toast('Sottogruppo eliminato con successo', {type: toast.TYPE.SUCCESS})
      Modal.hide();
      this.refetch()
    } else {
      toast('Errore eliminazione sottogruppo', {type: toast.TYPE.ERROR})
    }
  }

  onDeleteSubgroup = (group: any, fatherGroup: any) => async () => {
    Modal.show('Conferma disaddociazione gruppo', (
      <div>
        Confermi la disassociazione del gruppo:
        <br/>
        <b>{group.name}</b>
        <br />
        da
        <br />
        <b>{fatherGroup.name}</b>
      </div>
    ), this.deleteSubgroup(group.id))
  }

  modifyGroup = (group: any) => () => {
    Modal.show('Modifica Gruppo', <GroupForm refetch={this.refetch} group={group} />)
  }

  exportGroup = (group: any) => () => {
    window.open("/o/rubrica/gruppo/?gruppo="+group.id, "_blank")
}

  unsetNominative = (group, nominative) => async () => {
    const response = await client.groups.unsetNominativeRole(group.id, nominative.id);
    if (response.code < 300) {
      toast('Nominativo dissociato con successo', {type: toast.TYPE.SUCCESS})
      Modal.hide();
      this.refetch()
    } else {
      toast('Errore disassociazione nominativo', {type: toast.TYPE.ERROR})
    }
  }

  onUnsetNominative = (nominative: any, group: any) => () => {
    Modal.show('Disassocia Nominativo', (
      <div>
        Procedere con la dissociazione del nominativo <br/>
        <b>{nominative.firstName} {nominative.lastName}</b> <br/>
        dal gruppo: <br/>
        <b>{group.name} ?</b>
      </div>
    ), this.unsetNominative(group, nominative)
    )
  }

  onSetNominative = (group) => () => {
    Modal.show('Associa Nominativi', (
      <AddNominativesForm refetch={this.refetch} roles={this.context.roles} group={group} />
    ))
  }

onCreateNominative = (group) => () => {
    Modal.showTall('Crea Nominativo in Gruppo', (
      <CreateGreaterNominativeForm refetch={this.refetch} roles={this.context.roles} group={group} />
    ))
  }

  onAddSubgroup = (group) => () => {
    Modal.show('Associa Sottogruppi', (
      <GroupList refetch={this.refetch} group={group}/>
    ))
  }

  onAddSupergroup = (group) => () => {
    Modal.show('Aggiungi appartenenza', (
      <GroupList supergroup={true} refetch={this.refetch} group={group}/>
    ))
  }

  onRemoveSubgroups = (groups, parentId) => () => {
    Modal.show('Disassocia Sottogruppi', <div style={{textAlign: 'left'}}>
      Procedere con la disassociazione dei gruppi:
      {groups.map(el => (
        <div key={el.id} style={{margin: '.25rem 0', fontWeight: 'bold'}}>- {el.name}</div>
      ))}
      <button
        onClick={this.removeSubgroups(groups, parentId)}
        className={`${cStyles.button} ${cStyles.actionButton}`}
      >
        Disassocia
      </button>
    </div>)
  }

  onRemoveSupergroups = (groups, parentId) => () => {
    Modal.show('Rimuovi appartenenza', <div style={{textAlign: 'left'}}>
      Procedere con la rimozione delle appartenenze:
      {groups.map(el => (
        <div key={el.id} style={{margin: '.25rem 0', fontWeight: 'bold'}}>- {el.name}</div>
      ))}
      <button
        onClick={this.removeSupergroups(groups, parentId)}
        className={`${cStyles.button} ${cStyles.actionButton}`}
      >
        Rimuovi
      </button>
    </div>)
  }

  onRemoveNominatives = (nominatives, group) => () => {
    Modal.show('Disassocia Nominativi', <div style={{textAlign: 'left'}}>
      Procedere con la disassociazione dei nominativi:
      {nominatives.map(el => (
        <div key={el.id} style={{margin: '.25rem 0', fontWeight: 'bold'}}>- {el.firstName} {el.lastName}</div>
      ))}
      <div>Dal gruppo: {group.name} ?</div>
      <button
        onClick={this.removeNominatives(group.id, nominatives)}
        className={`${cStyles.button} ${cStyles.actionButton}`}
      >
        Disassocia
      </button>
    </div>)
  }

  removeNominatives = (id, nominatives) => async () => {
    const data = nominatives.map(el => ({nominativeId: el.id}))
    try {
      const response = await client.groups.unsetNominativesRole(id, data)
      if (response.code < 300) {
        toast('Nominativi disassociati', {type: toast.TYPE.SUCCESS})
        Modal.hide();
        this.refetch()
      } else {
        toast('Errore disassociazione nominativi', {type: toast.TYPE.ERROR})
      }
    } catch(err) {
      toast('Errore disassociazione nominativo', {type: toast.TYPE.ERROR})
    }
  }

  removeSubgroups = (groups, parentId) => async (event) => {
    const formattedRequest = groups.map(el => ({subgroupId: el.id}))
    const response = await client.groups.removeSubgroups(parentId, formattedRequest)
    if (response.code < 300) {
      this.setState({selectedGroups: []}, () => {
        toast('Gruppi disassociati', {type: toast.TYPE.SUCCESS})
        Modal.hide();
        this.refetch();
      })
    } else {
      console.error(response)
      toast('Errore disassociazione', {type: toast.TYPE.ERROR})
    }
  }

  removeSupergroups = (groups, parentId) => async (event) => {
    const formattedRequest = groups.map(el => ({subgroupId: el.id}))
    const response = await client.groups.removeSupergroups(parentId, formattedRequest)
    if (response.code < 300) {
      this.setState({selectedGroups: []}, () => {
        toast('Appartenenze rimosse', {type: toast.TYPE.SUCCESS})
        Modal.hide();
        this.refetch();
      })
    } else {
      console.error(response)
      toast('Errore disassociazione', {type: toast.TYPE.ERROR})
    }
  }

  handleGroupSelection = (group) => (event) => {
    let selectedGroups = []
    if (this.state.selectedGroups.find(el => el.id === group.id) !== undefined) {
      selectedGroups = [...this.state.selectedGroups.filter(el => el .id !== group.id)]
    }
    else {
      selectedGroups = [...this.state.selectedGroups, group]
    }
    this.setState({selectedGroups})
  }

   handleSupergroupSelection = (group) => (event) => {
    let selectedSupergroups = []
    if (this.state.selectedSupergroups.find(el => el.id === group.id) !== undefined) {
      selectedSupergroups = [...this.state.selectedSupergroups.filter(el => el .id !== group.id)]
    }
    else {
      selectedSupergroups = [...this.state.selectedSupergroups, group]
    }
    this.setState({selectedSupergroups})
  }

  handleNominativeSelection = (nominative) => (event) => {
    let selectedNominatives = []
    if (this.state.selectedNominatives.find(el => el.id === nominative.id) !== undefined) {
      selectedNominatives = [...this.state.selectedNominatives.filter(el => el .id !== nominative.id)]
    }
    else {
      selectedNominatives = [...this.state.selectedNominatives, nominative]
    }
    this.setState({selectedNominatives})
  }

  getRuoloIdFromName = (nome,roles) => {
	for (var k=0; k<roles.length; k++)
	  if (roles[k].name==nome) return roles[k].id
	return ""
}

  getMenuRuolo = (nominativo) => {
   var ruolo = this.getRuoloSingolo(nominativo)
   var specifica = this.getSpecificaRuoloSingolo(nominativo)
    for (var k=0; k<nominativo.groups.length; k++) {
      if (nominativo.groups[k].id==this.state.data.id) {
	return (
		<span>
                      <select onChange={this.handleRole(nominativo)} defaultValue={ruolo} style={{marginLeft: 'auto'}}>
                        <option value="">---</option>
                        {this.context.roles && this.context.roles.map(role => <option key={role.name} value={role.name}>{role.name}</option>)}
                      </select>
                      <input style={{display:'inline'}} className='mytext' value={specifica} placeholder="Specifica ruolo" type="text" onChange={this.handleSpecifica(nominativo)} />
                      </span>
	)
     }
   }
}

handleRole = (nominativo) => (event) => {
 var k
    var out
  
    for (k=0; k<nominativo.groups.length; k++) {
      if (nominativo.groups[k].id==this.state.data.id) {
         nominativo.groups[k].role  = event.target.value  
	 const data2 = {...this.state.data}
	this.setState({data:data2})
	this.onSubmitChange(nominativo.id,nominativo.groups[k].role,nominativo.groups[k].specificaRuolo)
	return
	 }
	}
	
}

handleSpecifica = (nominativo) => (event) => {
 var k
    var out
    for (k=0; k<nominativo.groups.length; k++) {
      if (nominativo.groups[k].id==this.state.data.id) {
         nominativo.groups[k].specificaRuolo  = event.target.value  
   	this.setState({data:this.state.data})
	 const data2 = {...this.state.data}
	this.setState({data:data2})
	this.onSubmitChange(nominativo.id,nominativo.groups[k].role,nominativo.groups[k].specificaRuolo)
	return
  }
	 }
}

  onSubmitChange = async (utente,ruolo,spec) => {
    try {
	var param = {nominativeId:utente,
	role : this.getRuoloIdFromName(ruolo,this.context.roles),
	specificaRuolo : spec }
        const result = await client.groups.setNominativesRole(this.state.data.id, [param])
       
      } catch (error) {
        console.error(error)
        toast('Errore associzione', {
          type: toast.TYPE.ERROR
        })
      }
  }

  getRuolo = (nominativo) => {
    var k
    var out
    for (k=0; k<nominativo.groups.length; k++) 
      if (nominativo.groups[k].id==this.state.data.id) {
         out = '- ' + nominativo.groups[k].role
         if (nominativo.groups[k].specificaRuolo) out += ' - ' + nominativo.groups[k].specificaRuolo
         return out
    }
    return ''
  }

  getRuoloSingolo = (nominativo) => {
    var k
    var out
    for (k=0; k<nominativo.groups.length; k++) {
      if (nominativo.groups[k].id==this.state.data.id)
         return nominativo.groups[k].role    
    }
    return ''
  }

  getSpecificaRuoloSingolo = (nominativo) => {
    var k
    var out
    for (k=0; k<nominativo.groups.length; k++) {
      if (nominativo.groups[k].id==this.state.data.id)
         return nominativo.groups[k].specificaRuolo  
    }
    return ''
  }

  render() {
    const {data, error, loading} = this.state
    const d = new Date()
    d.setTime(data.lastEdit)
    console.log(d)
    const ultimaMod = d.toLocaleString('it-IT')
    return (
    <>
      {loading && <Loader />}
      {!loading && !error && (
        <div className={styles.groupsWrapper}>
          <div className={styles.groupData}>
            <h1 style={{marginTop: 0}}>{data.name}</h1>
            <div>
              <span>
                <b>{data.nominativeCount}</b> Nominativi
              </span>
              &nbsp; - &nbsp;
              <span>
                <b>{data.subgroupsCount}</b> Sottogruppi
              </span>
              &nbsp; - &nbsp; Appartiene a &nbsp;
              <span>
                <b>{data.supergroupsCount}</b> gruppi
              </span>
              <div>Proprietario: {data.owner && data.owner.name}</div>
              <div>Ultima Modifica: {ultimaMod} - {data.lastEditUser && `${data.lastEditUser.firstName} ${data.lastEditUser.lastName}`}</div>
            </div>
          </div>
	  <button
              style={{marginTop: '.5rem',marginRight: '.5rem',marginBottom: '.5rem'}}
              className={cStyles.button}
              onClick={this.exportGroup(data)}> Esporta </button>
          {data.id !== -1 && (
            <button
              style={{marginTop: '.5rem',marginBottom: '.5rem'}}
              className={cStyles.button}
              onClick={this.modifyGroup(data)}> Modifica Gruppo </button>
          )}
	<br/>
	<br/>
	<div className={styles.subgroupsList}>
            <h4 style={{margin: 0}}>Nominativi</h4>
            {data.id !== -1 && (
              <>
              <button
                style={{marginTop: '.5rem', marginRight: '.5rem', marginBottom:'.5rem'}}
                className={cStyles.button}
                onClick={this.onCreateNominative(data)}
              >
                Crea Nominativo
              </button>
              <button
                style={{marginTop: '.5rem', marginBottom:'.5rem'}}
                className={cStyles.button}
                onClick={this.onSetNominative(data)}
              >
                Associa Nominativo
              </button>
              {this.state.selectedNominatives && this.state.selectedNominatives.length > 0 && (
                <button
                  style={{margin: '.5rem 0 .5rem 1rem'}}
                  className={cStyles.button}
                  onClick={this.onRemoveNominatives(this.state.selectedNominatives, data)}>Disassocia Nominativi</button>
              )}
              </>
            )}
            <ul className={styles.nominatives}>
              {data.nominatives && data.nominatives.length === 0 && <div>Non ci sono nominativi</div>}
              {data.nominatives && data.nominatives.map((nominative: any) => {
                return <li key={nominative.id}>
                  <span className="mycheckbox"><input type="checkbox" className="mycheckbox" defaultChecked={false} onChange={this.handleNominativeSelection(nominative)}/></span>
                  <span><DraggableComponent type='CONTACT' data={nominative.id}><b><span style={{cursor:'pointer'}} onClick={(e)=>this.toggleNominative(nominative.id)}>{nominative.firstName} {nominative.lastName}</span></b> {this.state.editedNominative==nominative.id?this.getMenuRuolo(nominative):this.getRuolo(nominative)} ({nominative.groups && nominative.groups.length} Gruppi) ({nominative.contacts && nominative.contacts.length} Contatti)</DraggableComponent></span>
                  {data.id !== -1 && <span style={{cursor:'pointer'}} onClick={this.onNominativeDetail(nominative.id)}> 🔍 </span>}
                  {data.id !== -1 && <span style={{cursor:'pointer'}} onClick={this.onUnsetNominative(nominative, data)}> ❌ </span>}
                </li>
              })}
            </ul>
          </div>

          {data.id !== -1 && (
            <div className={styles.subgroupsList}>
              <div>
                <h4 style={{margin: '1rem 0 0'}}>Appartiene ai gruppi</h4>
                <button
                  style={{margin: '.5rem 0'}}
                  className={cStyles.button}
                  onClick={this.onAddSupergroup(data)}>Aggiungi appartenenza</button>
                {this.state.selectedSupergroups && this.state.selectedSupergroups.length > 0 && (
                  <button
                    style={{margin: '.5rem 0 .5rem 1rem'}}
                    className={cStyles.button}
                    onClick={this.onRemoveSupergroups(this.state.selectedSupergroups, data.id)}>Rimuovi appartenenza</button>
                )}
              </div>
              <ul className={styles.subGroups}>
                {data.supergroups && data.supergroups.length === 0 && <div>Non appartiene ad alcun gruppo</div>}
                {data.supergroups && data.supergroups.map((group: any) => {
                  return (
                    <li key={group.id}>
                      <span className="mycheckbox"><input type="checkbox" className="mycheckbox" defaultChecked={false} onChange={this.handleSupergroupSelection(group)}/></span>
                      <span><DraggableComponent type='GROUP' data={group.id}>{group.name}</DraggableComponent></span>
                      <span style={{cursor:'pointer'}} onClick={this.onGroupDetail(group.id)}> 🔍</span>
                    </li>
                  )
                })}
              </ul>
            </div>
          )}

          {data.id !== -1 && (
            <div className={styles.subgroupsList}>
              <div>
                <h4 style={{margin: '1rem 0 0'}}>Sottogruppi</h4>
                <button
                  style={{margin: '.5rem 0'}}
                  className={cStyles.button}
                  onClick={this.onAddSubgroup(data)}>Associa Sottogruppo</button>
                {this.state.selectedGroups && this.state.selectedGroups.length > 0 && (
                  <button
                    style={{margin: '.5rem 0 .5rem 1rem'}}
                    className={cStyles.button}
                    onClick={this.onRemoveSubgroups(this.state.selectedGroups, data.id)}>Disassocia Sottogruppi</button>
                )}
              </div>
              <ul className={styles.subGroups}>
                {data.subgroups && data.subgroups.length === 0 && <div>Non ci sono sottogruppi</div>}
                {data.subgroups && data.subgroups.map((group: any) => {
                  return (
                    <li key={group.id}>
                      <span className="mycheckbox"><input type="checkbox" className="mycheckbox" defaultChecked={false} onChange={this.handleGroupSelection(group)}/></span>
                      <span><DraggableComponent type='GROUP' data={group.id}>{group.name} ({group.subgroupsCount} Sottogruppi) ({group.nominativeCount} Nominativi)</DraggableComponent></span>
                      <span style={{cursor:'pointer'}} onClick={this.onGroupDetail(group.id)}> 🔍</span>
                      <span style={{cursor:'pointer'}} onClick={this.onDeleteSubgroup(group, data)}> ❌</span>
                    </li>
                  )
                })}
              </ul>
            </div>
          )}

          
        </div>
      )}
      {!loading && error && <div>{error}</div>}
    </>
    )
  }
}

