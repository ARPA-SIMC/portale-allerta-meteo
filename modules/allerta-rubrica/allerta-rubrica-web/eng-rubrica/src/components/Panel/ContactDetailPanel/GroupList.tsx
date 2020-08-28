import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import styles from '../ContactDetailPanel/ContactDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";
import { debounced } from '../../../utils';

export class GroupList extends Component<any, any> {
  state = {
    data: [],
    loading: true,
    error: undefined,
    timestamp: 0
  }

  generateValidationSchema = () => yup.object().shape({
    groups: yup.array().of(
      yup.object({
        id: yup.mixed().required(),
        roleId: yup.mixed().required()
      })
    )
  })

  onSubmitChange = async ({groups}: any) => {
    try {
      const result = await client.groups.setGroupsNominativeRole(this.props.nominative.id, groups)
      if(result.code >= 200 && result.code<300) {
        toast("Nominativi associati", {
          type: toast.TYPE.SUCCESS
        })
        Modal.hide()
        this.props.refetch()
      }
    } catch (error) {
      console.error(error)
      toast('Errore associazione', {
        type: toast.TYPE.ERROR
      })
    }
  }

  async componentDidMount() {
    const data = await client.groups.all('', 100000, 0)
    if(data.code === 200) {
      if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
  }

  filterData = async (e) => {
    let data = await client.groups.all(e.target.value, 100000, 0)
    if(data.code === 200) {
      if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
    if(e.target.value === '') {
      data = await client.groups.all('', 100000, 0)
      if(data.code === 200) {
        if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
      } else {
        this.setState({error: 'Errore API', loading: false})
      }
    }
  }

  handleSelection = (group, setFieldValue, {groups}) => (event) => {
    let selected = []
    if (groups.find(el => el.id === group.id) !== undefined) {
      selected = [...groups.filter(el => el .id !== group.id)]
    } else {
      selected = [...groups, {id: group.id, role: undefined}]
    }
    setFieldValue('groups', selected)
  }

  handleRole = (group, {groups}, setFieldValue) => (event) => {
    const pos = groups.findIndex(el => el.id === group.id)
    const values = [...groups]
    values[pos].roleId = Number(event.target.value);
    setFieldValue('groups', values)
  }

handleSpecifica = (nominative,  {groups}, setFieldValue) => (event) => {
    const pos = groups.findIndex(el => el.id === nominative.id)
    const values = [...groups]
    values[pos].specificaRuolo = event.target.value;
    setFieldValue('groups', values)
}

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          groups: []
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitChange}
      >
        {({isValid, setFieldValue, values}) => (
          <Form>
            <input type="text" onChange={debounced(this.filterData, 350)} />
            <ul className={cStyles.list}>
              {this.state.data && this.state.data.map(el => <React.Fragment key={el.id}>
                {(
                  <li style={{display: 'flex', alignItems: 'center', padding: '.5rem 0'}}>
                    <input type="checkbox" defaultChecked={false} onChange={this.handleSelection(el, setFieldValue, values)} />
                    <span>{el.name}</span>
                    {values.groups.find(group => group.id === el.id) !== undefined && (
                      <span>
                      <select onChange={this.handleRole(el, values, setFieldValue)} defaultValue="" style={{marginLeft: 'auto'}}>
                        <option value="">Seleziona ruolo</option>
                        {this.props.roles && this.props.roles.map(role => <option key={role.id} value={role.id}>{role.name}</option>)}
                      </select>
                      <input type="text" placeholder="Specifica ruolo" onChange={this.handleSpecifica(el, values, setFieldValue)} />
                      </span>
                    )}
                  </li>
                )}
                </React.Fragment>
              )}
            </ul>
            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Associa </button>
          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}
