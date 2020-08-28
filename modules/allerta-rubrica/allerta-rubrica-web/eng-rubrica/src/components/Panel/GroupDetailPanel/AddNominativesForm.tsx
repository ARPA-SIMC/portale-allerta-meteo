import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import styles from '../ContactDetailPanel/ContactDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";
import { debounced } from '../../../utils';

export class AddNominativesForm extends Component<any, any> {
  state = {
    data: [],
    loading: true,
    error: undefined,
    timestamp: 0
  }

  generateValidationSchema = () => yup.object().shape({
    nominatives: yup.array().of(
      yup.object({
        nominativeId: yup.mixed().required(),
        role: yup.mixed().required()
      })
    )
  })

  onSubmitChange = async ({nominatives}: any) => {
    try {
        const result = await client.groups.setNominativesRole(this.props.group.id, nominatives)
        if(result.code === 201) {
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
    const data = await client.nominatives.all('', 100000, 0)
    if(data.code === 200) {
      this.setState({data: data.data, loading: false})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
  }

  handleSelection = (nominative, setFieldValue, {nominatives}) => (event) => {
    let selected = []
    if (nominatives.find(el => el.id === nominative.id) !== undefined) {
      selected = [...nominatives.filter(el => el .id !== nominative.id)]
    } else {
      selected = [...nominatives, {nominativeId: nominative.id, role: undefined}]
    }
    setFieldValue('nominatives', selected)
  }

  handleRole = (nominative, {nominatives}, setFieldValue) => (event) => {
    const pos = nominatives.findIndex(el => el.nominativeId === nominative.id)
    const values = [...nominatives]
    values[pos].role = event.target.value;
    setFieldValue('nominatives', values)
  }

  handleSpecifica = (nominative,  {nominatives}, setFieldValue) => (event) => {
    const pos = nominatives.findIndex(el => el.nominativeId === nominative.id)
    const values = [...nominatives]
    values[pos].specificaRuolo = event.target.value;
    setFieldValue('nominatives', values)
}

  filterData = async (e) => {
    let data = await client.nominatives.all(e.target.value, 100000, 0)
    if(data.code === 200) {
      if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
    if(e.target.value === '') {
      data = await client.nominatives.all('', 100000, 0)
      if(data.code === 200) {
        if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
      } else {
        this.setState({error: 'Errore API', loading: false})
      }
    }
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          nominatives: []
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
                    <span>{el.lastName} {el.firstName}</span>
                    {values.nominatives.find(nomin => nomin.nominativeId === el.id) !== undefined && (
                      <span>
                      <select onChange={this.handleRole(el, values, setFieldValue)} defaultValue="" style={{marginLeft: 'auto'}}>
                        <option value="">Seleziona ruolo e specifica</option>
                        {this.props.roles && this.props.roles.map(role => <option key={role.id} value={role.id}>{role.name}</option>)}
                      </select>
                      <input placeholder="Specifica ruolo" type="text" onChange={this.handleSpecifica(el, values, setFieldValue)} />
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
