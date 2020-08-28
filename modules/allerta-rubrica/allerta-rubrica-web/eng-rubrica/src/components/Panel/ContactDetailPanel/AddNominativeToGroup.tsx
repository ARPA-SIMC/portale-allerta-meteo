import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import { NominativeInput, PanelType } from '../../../types.d';
import styles from './ContactDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import AutocompleteGroup from '../../Autocomplete/AutocompleteGroup';
import cStyles from "../../../common.module.css";


export class AddNominativeToGroupForm extends Component<any, any> {
  generateValidationSchema = () => yup.object().shape({
    id: yup.mixed().required(),
    roleId: yup.mixed().required()
  })

  handleRoleSlection = (setFieldValue: any) => (e: any) => {
    setFieldValue('roleId', e.target.value)
  }

  onSubmitChange = async (values: any) => {
    try {
        const result = await client.groups.setNominativeRole(values.id, this.props.nominative.id, values.roleId)
        if(result.code === 201) {
          toast("Nominativo aggiunto al gruppo con successo", {
            type: toast.TYPE.SUCCESS
          })
          Modal.hide()
          this.props.refetch()
        }
      } catch (error) {
        console.error(error)
        toast('Errore aggiunta nominativo al gruppo', {
          type: toast.TYPE.ERROR
        })
      }
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik 
        initialValues={{
            id: '',
            roleId: ''
        }} 
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitChange}
      >
        {({isValid, setFieldValue}) => (
          <Form>

            <div>
              <label>
                <span>Gruppo in cui aggiungere: </span>
                <AutocompleteGroup update={setFieldValue} />
              </label>
            </div>

            <div>
              <label>
                <span>Ruolo nominativo: </span>
                <select name="roleId" onChange={this.handleRoleSlection(setFieldValue)}>
                    <option value="">Scegli un ruolo</option>
                    {this.props.roles.map(role => <option key={role.id} value={role.id}>{role.name}</option>)}
                </select>
              </label>
            </div>

            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Save </button>

          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}