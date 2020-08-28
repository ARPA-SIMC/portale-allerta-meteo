import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import styles from './ContactDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";

export class AddToGroupForm extends Component<any, any> {
  state = {
    data: [],
    loading: true,
    error: undefined
  }

  generateValidationSchema = () => yup.object().shape({
    groups: yup.array().of(
      yup.object({
        id: yup.mixed().required(),
        role: yup.mixed().required()
      })
    )
  })

  onSubmitChange = async (values: any) => {
    try {
        const result = await client.groups.setNominativeRole("","","")
        if(result.code === 201) {
          toast("Nominativo associato ai gruppi", {
            type: toast.TYPE.SUCCESS
          })
          Modal.hide()
          this.props.refetch()
        }
      } catch (error) {
        console.error(error)
        toast('Errore associzione', {
          type: toast.TYPE.ERROR
        })
      }
  }

  async componentDidMount() {
    const data = await client.groups.all('', 100000, 0)
    if(data.code === 200) {
      this.setState({data: data.data, loading: false})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
  }

  handleSelection = (nominative, setFieldValue, {groups}) => (event) => {
    let selected = []
    if (groups.find(el => el.id === nominative.id) !== undefined) {
      selected = [...groups.filter(el => el .id !== nominative.id)]
    } else {
      selected = [...groups, {id: nominative.id, role: null}]
    }
    console.log(nominative, groups, selected)
    setFieldValue('groups', selected)
  }

  handleRole = (nominative, {groups}, setFieldValue) => (event) => {
    const pos = groups.findIndex(el => el.id === nominative.id)
    const values = [...groups]
    values[pos].role = event.target.value;
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

            <ul style={{height: '200px', overflow:'overlay', padding: 0, margin: '0', border: '1px solid rgba(0,0,0,.25)'}}>
              {this.state.data && this.state.data.map(el => <React.Fragment key={el.id}>
                {(
                  <li style={{display: 'flex', alignItems: 'center', padding: '.5rem 0'}}>
                    <input type="checkbox" defaultChecked={false} onChange={this.handleSelection(el, setFieldValue, values)} />
                    {el.name}
                    {values.groups.find(group => group.id === el.id) !== undefined && (
	              <span>
                      <select onChange={this.handleRole(el, values, setFieldValue)} defaultValue="" style={{marginLeft: 'auto'}}>
                        <option value="">Seleziona ruolo</option>
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
