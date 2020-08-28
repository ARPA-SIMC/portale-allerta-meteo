import React, {Component} from 'react';
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { PanelContext } from '../../../context/panelContext';
import styles from './ContactDetailPanel.module.css';
import { DetailForm } from './DetailForm';
import { CreateNominativeForm } from './CreateNominativeForm';
import { Modal } from '../../Modal/Modal';
import { toast } from 'react-toastify';
import { getResId, getChannelName } from '../../../utils';
import { PanelType } from '../../../types.d';
import { AddContactForm } from './AddContactForm';
import { ModifyContactForm } from './ModifyContactForm';
import { AddNominativeToGroupForm } from './AddNominativeToGroup';
import cStyles from "../../../common.module.css"
import { AddToGroupForm } from './AddToGroup';
import { emitKeypressEvents } from 'readline';
import { GroupList } from './GroupList';

import {DraggableComponent} from '../../DragDrop/DraggableComponent'

interface ContactDetailState {
  data: any;
  loading: boolean;
  error: string | null;
  selected: any[]; // contacts
  selectedGroups: any[];
  resId?: string;
  editedGroup: any;
}

export class ContactDetailPanel extends Component<any, ContactDetailState> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {
    data: ({} as any),
    loading: true,
    error: null,
    resId: undefined,
    selected: [],
    selectedGroups: [],
    editedGroup: null
  }

  async componentDidMount() {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    if(resId) {
      try {
        const {data} = await client.nominatives.getById(resId)
        this.setState({loading: false, data, error: null, resId})
      } catch(err) {
        this.setState({loading: false, data: null, error: 'API Error'})
      }
    }
  }

  componentDidUpdate(prevProps, prevState) {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    if(resId !== this.state.resId) {
      this.refetch()
    }
  }

toggleGroup = (g) => {
  console.log('toggle group '+g)
  this.setState({editedGroup: (g==this.state.editedGroup?null:g)})
}

  refetch = async () => {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    if(resId) {
      try {
        const {data} = await client.nominatives.getById(resId)
        this.setState({loading: false, data, error: null, resId})
      } catch(err) {
        this.setState({loading: false, data: null, error: 'API Error'})
      }
    }
  }



  removeContact = (id: any) => async () => {
    const response = await client.contacts.delete(id)
    if(response.code === 204) {
      toast("Contatto eliminato con successo", {
        type: toast.TYPE.SUCCESS
      })
      Modal.hide()
      this.refetch()
    } else {
      toast("Rimozione contatto fallita", {
        type: toast.TYPE.ERROR
      })
    }
  }

  onRemoveContact = (contact: any) => () => {
    Modal.show('Elimina Contatto', (
      <>
        Procedere con l'eliminazione del Contatto
        <br/>
        <b>{contact.value}</b> ?
      </>
    ), this.removeContact(contact.id))
  }

  addNominativeToGroup = (nominative: any) => () => {
    Modal.show('Associa a Gruppo',
      <GroupList refetch={this.refetch} nominative={nominative} roles={this.context.roles}/>
    )
  }

  removeNominativeFromGroup = (id: any) => async () => {
    const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
    const response = await client.groups.unsetNominativeRole(id, resId);
    if(response.code >= 200 && response.code<300) {
        toast("Nominativo dissociato con successo", {
        type: toast.TYPE.SUCCESS
      })
      Modal.hide()
      this.refetch()
    } else {
      toast("Dissociazione da gruppo fallita", {
        type: toast.TYPE.ERROR
      })
    }
  }

  onRemoveNominativeFromGroup = (group: any, nominative: any) => () => {
    Modal.show('Dissocia Nominativo', (
      <>
        Procedere con la dissociazione del nominativo:
        <br/>
        <b>{nominative.firstName} {nominative.lastName}</b>
        <br/>
        dal gruppo
        <br/>
        <b>{group.name}</b>
      </>
    ), this.removeNominativeFromGroup(group.id)
    )
  }

  onGroupDetail = (id: any) => () => {
    this.context.onSelect(PanelType.GROUP_DETAILS, this.props.id, id);
  }

  modifyNominative = (nominative) => () => {
    Modal.show('Modifica Nominativo', <DetailForm nominative={nominative} refetch={this.refetch}/>)
  }

  getRuoloIdFromName = (nome,roles) => {
	for (var k=0; k<roles.length; k++)
	  if (roles[k].name==nome) return roles[k].id
	return ""
}

  getMenuRuolo = (g) => {
   var ruolo = this.getRuoloSingolo(g)
   var specifica = this.getSpecificaRuoloSingolo(g)
    for (var k=0; k<this.state.data.groups.length; k++) {
      if (this.state.data.groups[k].id==g.id) {
	return (
		<span>
                      <select onChange={this.handleRole(g)} defaultValue={ruolo} style={{marginLeft: 'auto'}}>
                        <option value="">---</option>
                        {this.context.roles && this.context.roles.map(role => <option key={role.name} value={role.name}>{role.name}</option>)}
                      </select>
                      <input style={{display:'inline'}} className='mytext' value={specifica} placeholder="Specifica ruolo" type="text" onChange={this.handleSpecifica(g)} />
                      </span>
	)
     }
   }
}

handleRole = (group) => (event) => {
 var k
    var out
  
    for (k=0; k<this.state.data.groups.length; k++) {
      if (this.state.data.groups[k].id==group.id) {
         this.state.data.groups[k].role  = event.target.value  
	 const data2 = {...this.state.data}
	this.setState({data:data2})
	this.onSubmitChange(group.id,this.state.data.groups[k].role,this.state.data.groups[k].specificaRuolo)
	return
	 }
	}
	
}

handleSpecifica = (group) => (event) => {
 var k
    var out
    for (k=0; k<this.state.data.groups.length; k++) {
      if (this.state.data.groups[k].id==group.id) {
         this.state.data.groups[k].specificaRuolo  = event.target.value  
   	this.setState({data:this.state.data})
	 const data2 = {...this.state.data}
	this.setState({data:data2})
	this.onSubmitChange(group.id,this.state.data.groups[k].role,this.state.data.groups[k].specificaRuolo)
	return
  }
	 }
}

  onSubmitChange = async (group,ruolo,spec) => {
    try {
	const {panels} = this.context;
    const resId = getResId(panels, this.props.id);
	var param = {nominativeId:resId,
	role : this.getRuoloIdFromName(ruolo,this.context.roles),
	specificaRuolo : spec }
        const result = await client.groups.setNominativesRole(group, [param])
       
      } catch (error) {
        console.error(error)
        toast('Errore associzione', {
          type: toast.TYPE.ERROR
        })
      }
  }

 getRuolo = (group) => {
    var k
    var out
    for (k=0; k<this.state.data.groups.length; k++) {
      if (this.state.data.groups[k].id==group.id) {
         out = ' ' + this.state.data.groups[k].role
         if (this.state.data.groups[k].specificaRuolo) out += ' - ' + this.state.data.groups[k].specificaRuolo
 
         return out
	}
    }
    return ''
  }

  getRuoloSingolo = (group) => {
    var k
    var out
    for (k=0; k<this.state.data.groups.length; k++) {
      if (this.state.data.groups[k].id==group.id)
         return this.state.data.groups[k].role    
    }
    return ''
  }

  getSpecificaRuoloSingolo = (group) => {
    var k
    var out
    for (k=0; k<this.state.data.groups.length; k++) {
      if (this.state.data.groups[k].id==group.id)
         return this.state.data.groups[k].specificaRuolo  
    }
    return ''
  }

  addContact = (channels) => () => {
    Modal.show('Crea Contatto', <AddContactForm channels={channels} refetch={this.refetch} nominative={this.state.data}/>)
  }

  modifyContact = (channels, contact) => () => {
    Modal.show('Modifica Contatto', <ModifyContactForm channels={channels} refetch={this.refetch} contact={contact} nominative={this.state.data}/>)
  }

  deleteContacts = (contacts) => (event) => {
    Modal.show('Elimina Contatti', <div style={{textAlign: 'left'}}>
      <div style={{display: 'block', marginBottom: '1rem'}}> Eliminare i seguenti contatti: <br/></div>
      {contacts.map(el => <span key={el.id} style={{display: 'block', marginBottom: '.25rem'}}>
        <b>- {el.value}</b>
      </span>)}
      <button className={`${cStyles.button} ${cStyles.actionButton}`} onClick={this.removeContacts(this.state.selected)} > Elimina </button>
    </div>)
  }

  removeContacts = (ids: any) => async () => {
    const obj = ids.map(el => ({id: el.id}))
    const response = await client.contacts.deleteMulti(obj)
    if(response.code >= 200 && response.code<300) {
      toast("Contatti eliminati", {
        type: toast.TYPE.SUCCESS
      })
      Modal.hide()
      this.refetch()
    } else {
      toast("Rimozione contatti fallita", {
        type: toast.TYPE.ERROR
      })
    }
  }

  onRemoveGroups = (groups) => async (e) => {
    Modal.show('Elimina Contatti', <div style={{textAlign: 'left'}}>
      <div style={{display: 'block', marginBottom: '1rem'}}> Disassociare i seguenti gruppi: <br/></div>
      {groups.map(el => <span key={el.id} style={{display: 'block', marginBottom: '.25rem'}}>
        <b>- {el.name}</b>
      </span>)}
      <button className={`${cStyles.button} ${cStyles.actionButton}`} onClick={this.removeGroups(this.state.selectedGroups)} > Disassocia </button>
    </div>)
  }

  removeGroups = (ids: any) => async () => {
    const obj = ids.map(el => {
      return {
        id: el.id,
        roleId: this.context.roles.find(elm => elm.name === el.role).id
      }
    })
    const response = await client.groups.unsetGroupsRole(this.state.resId, obj)
    if(response.code < 300) {
      toast("Gruppi disassociati", {
          type: toast.TYPE.SUCCESS
      })
      Modal.hide()
      this.setState({selectedGroups: []}, this.refetch)
    } else {
      toast("Rimozione grouppo fallita", {
        type: toast.TYPE.SUCCESS
      })
    }
  }

  selectContact = (contact) => (event) => {
    let selected = []
    if (this.state.selected.find(el => el.id === contact.id) !== undefined) {
      selected = [...this.state.selected.filter(el => el .id !== contact.id)]
    }
    else {
      selected = [...this.state.selected, contact]
    }
    this.setState({selected})
  }

  selectGroup = (group) => (e) => {
    let selectedGroups = []
    if (this.state.selectedGroups.find(el => el.id === group.id) !== undefined) {
      selectedGroups = [...this.state.selected.filter(el => el .id !== group.id)]
    }
    else {
      selectedGroups = [...this.state.selectedGroups, group]
    }
    this.setState({selectedGroups})
  }

  render() {
    const {data, error, loading} = this.state
    const {channels} = this.context;
    const dat = new Date();
    dat.setTime(data.lastEdit);

    return (
    <>
      {loading && <Loader />}
      {!loading && !error && (
        <div className={styles.detailWrapper}>
          <div className={styles.detailData}>
            <h1>{data.firstName} {data.lastName}</h1>
            <div>
              ({data.contacts && data.contacts.length}) Contatti
              -
              ({data.groups && data.groups.length}) Gruppi
            </div>
            <div>
              Proprietario del nominativo: {data.owner}
            </div>
            <div>
              Ultima Modifica: {data.modifyUser} - {" " + dat.toLocaleString('it-IT')}
            </div>
            <button
              style={{marginTop: '1rem'}}
              className={cStyles.button}
              onClick={this.modifyNominative(data)}>Modifica Nominativo</button>
            <button
              style={{marginTop: '1rem',marginLeft: '1rem'}}
              className={cStyles.button}
              onClick={this.refetch}>Refresh</button>
          </div>

          <div>
            <h4 style={{marginTop: 0}}>Contatti</h4>
            <div style={{display: 'flex'}}>
              <button
                style={{marginBottom: '1rem'}}
                className={cStyles.button}
                onClick={this.addContact(channels)}
              >
                Aggiungi Contatto
              </button>
              {this.state.selected.length > 0 && (
                <button
                  style={{marginBottom: '1rem', marginLeft: '1rem'}}
                  className={cStyles.button}
                  onClick={this.deleteContacts(this.state.selected)}
                >
                  Rimuovi Contatti
                </button>
              )}
            </div>


            <div className={styles.dataList}>
              <ul className={styles.contactsList}>
                {data.contacts && data.contacts.map((el:any) => {
                  return (
                    <li key={el.id}>
                      <span className="mycheckbox"><input style={{'marginRight':'1rem'}} className="mycheckbox" type="checkbox" onChange={this.selectContact(el)} /></span>
                      <span>{getChannelName(channels, el.channelId)} - {el.value}</span>
                      <span style={{cursor:'pointer'}} onClick={this.modifyContact(channels, el)}> 📝</span>
                      <span style={{cursor:'pointer'}} onClick={this.onRemoveContact(el)}>❌</span>
                    </li>
                  )})
                }
              </ul>
            </div>
          </div>

          <div>
            <h4 style={{marginTop: 0}}>Gruppi</h4>
            <button
              style={{marginBottom: '1rem'}}
              className={cStyles.button}
              onClick={this.addNominativeToGroup(data)}>Aggiungi Nominativo a Gruppo</button>
            {this.state.selectedGroups.length !== 0 && (
              <button
                style={{marginBottom: '1rem', marginLeft: '1rem'}}
                className={cStyles.button}
                onClick={this.onRemoveGroups(this.state.selectedGroups)}
              >
                Dissocia Gruppi
              </button>
            )}
            <div className={styles.dataList}>
              <ul className={styles.groupsList}>
                {data.groups && data.groups.map((el:any, id:number) => {
                  return (
                    <li key={el.id}>
                      <span className="mycheckbox"><input className="mycheckbox" style={{width:'30px !important'}} type="checkbox" onChange={this.selectGroup(el)}/></span>
                      <span><DraggableComponent type='GROUP' data={el.id}><b><span style={{cursor:'pointer'}} onClick={(e)=>this.toggleGroup(el.id)}>{el.name}</span></b> -  {this.state.editedGroup==el.id?this.getMenuRuolo(el):this.getRuolo(el)}</DraggableComponent></span>
                      <span style={{cursor:'pointer'}} onClick={this.onGroupDetail(el.id)}> 🔍 </span>
                      <span style={{cursor:'pointer'}} onClick={this.onRemoveNominativeFromGroup(el, data)}> ❌ </span>
                    </li>
                    )})
                  }
              </ul>
            </div>
          </div>

          

        </div>
      )}
      {!loading && error && <div>{error}</div>}
    </>
    )
  }
}

