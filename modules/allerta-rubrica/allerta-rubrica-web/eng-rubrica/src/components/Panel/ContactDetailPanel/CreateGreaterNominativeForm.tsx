import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import { NominativeInput, PanelType } from '../../../types.d';
import styles from './ContactDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";
import { debounced } from '../../../utils';



export class CreateGreaterNominativeForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {
   loading:false,
   error:null,
   grouplist:null,
   groupFilter:'',
   timestamp: 0
  }

  generateValidationSchema = () => yup.object().shape({
    firstName: yup.string().required(),
    lastName: yup.string().required(),
    //address: yup.string().required(),
    contacts: yup.array(),
    groups: yup.array()
  })

  hasGroup = () => {
     return this.props.group
  }

  prefilledGroup = () => {
     return (this.props.group && this.props.group.name? this.props.group.name : null)
  }

  onSubmitNominative = async (values: NominativeInput) => {
    const result = await client.nominatives.create(values)
    if(result.code === 201) {
      toast("Nominativo creato con successo", {
        type: toast.TYPE.SUCCESS
      })
      Modal.hide()
      this.props.refetch();
    } else {
      toast("Creazione nominativo fallita, riprova", {
        type: toast.TYPE.ERROR
      })
      Modal.hide()
    }
  }

  handleRole = (values, setFieldValue) => (event) => {
    setFieldValue('role', event.target.value)
  }

  filterGroups = (setFieldValue) => async (e) => {
    setFieldValue('group',null)
    this.setState({groupFilter:e.target.value})
    if (!e.target.value || e.target.value.length<2) {
       this.setState({grouplist:null})
       return
    }
    let data = await client.groups.all(e.target.value, 3, 0)
    if(data.code === 200) {
      if (data.timestamp>this.state.timestamp) this.setState({grouplist: data.data, loading: false, timestamp: data.timestamp})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
  }

  handleGroupSelection = (group,setFieldValue) => (event) => {
    setFieldValue('group',group.id)
    this.setState({groupFilter:group.name,grouplist:null})
}

  render() {
    return (
    <div className={styles.detailForm}>
      <Formik
        initialValues={{
          firstName: '',
          lastName: '',
          role: null,
          group: this.hasGroup()?this.props.group.id:null,
          specificaRuolo: '',
          contacts: [],
          address: '',
          email: '',
          telefono: '',
          groups: [],
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitNominative}
      >
        {({values, setFieldValue, isValid}) => (
          <Form>
            <table style={{width:'100%'}}><tr><td>
            <div className={cStyles.field}>
              <label>
                <span>Nome</span>
                <Field type="text" name="firstName" />
              </label>
            </div></td><td>
            <div className={cStyles.field}>
              <label>
                <span>Cognome</span>
                <Field type="text" name="lastName" />
              </label>
            </div></td></tr><tr><td colSpan={2}>
            <div className={cStyles.field}>
              <label>
                <span>Indirizzo</span>
                <Field type="text" name="address" />
              </label>
            </div></td></tr><tr><td colSpan={2}>
            {this.hasGroup() &&
             <div className={cStyles.field}>
              <label>
                <span>Gruppo</span>
                <span><b>{this.prefilledGroup()}</b></span>
              </label>
             </div>
            }
            {!this.hasGroup() &&
             <div className={cStyles.field}>
              <label>
                <span>Gruppo</span>
                 <input value={this.state.groupFilter} type="text" onChange={this.filterGroups(setFieldValue)} />
           {this.state.grouplist &&
           <ul className={cStyles.list} style={{height:'120px'}}>
              {this.state.grouplist && this.state.grouplist.map(el => <React.Fragment key={el.id}>
                {el.id>=0 &&
                  <li style={{display: 'flex', alignItems: 'center', padding: '.5rem 0'}}>
                    <div style={{width:'90%',height:'16px',cursor:'pointer'}} onClick={this.handleGroupSelection(el,setFieldValue)}>{el.name}</div>
                  </li>
                }
                </React.Fragment>
              )}
            </ul>
            }
              </label>
             </div>
            }</td></tr><tr><td>
            <div className={cStyles.field}>
              <label>
                <span>Ruolo</span>
                <select onChange={this.handleRole(values, setFieldValue)} defaultValue="" style={{marginLeft: 'auto'}}>
                        <option value="">---</option>
                        {this.props.roles && this.props.roles.map(role => <option key={role.id} value={role.id}>{role.name}</option>)}
                </select>
              </label>
            </div></td><td>
            <div className={cStyles.field}>
              <label>
                <span>Specifica</span>
                <Field type="text" name="specificaRuolo" />
              </label>
            </div></td></tr><tr><td>
            <div className={cStyles.field}>
              <label>
                <span>Email</span>
                <Field type="text" name="email" />
              </label>
            </div></td><td>
<div className={cStyles.field}>
              <label>
                <span>Telefoni</span>
                <Field type="text" name="telefono" />
              </label>
            </div></td></tr></table>
            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Crea </button>

          </Form>
        )}
      </Formik>
    </div>
  )}
}
