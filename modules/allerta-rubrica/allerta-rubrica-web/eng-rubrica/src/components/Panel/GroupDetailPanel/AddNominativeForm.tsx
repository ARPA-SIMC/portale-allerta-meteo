import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import styles from './GroupDetailPanel.module.css';
import AutocompleteNominative from '../../Autocomplete/AutocompleteNominative';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";

export class AddNominativeForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  generateValidationSchema = () => yup.object().shape({
    id: yup.mixed().required(),
    roleId: yup.mixed().required()
  })

  onSubgroupAdd = async (values: any, actions: any) => {
    try {
      const result = await client.groups.setNominativeRole(this.props.group.id, values.id, values.roleId)
      if(result.code === 201) {
        toast("Nominativo aggiunto al gruppo con successo", {
          type: toast.TYPE.SUCCESS
        })
        Modal.hide()
        this.props.refetch()
      }
    } catch (error) {
      console.error(error)
      toast(error, {
        type: toast.TYPE.ERROR
      })
    }
  }

  handleRoleSlection = (setFieldValue: any) => (e: any) => {
    setFieldValue('roleId', e.target.value)
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
        onSubmit={this.onSubgroupAdd}
      >
        {({isValid, setFieldValue, values}) => (
          <Form>
            <div>
              <label>
                <span>Nominativo da aggiungere: </span>
                <AutocompleteNominative update={setFieldValue} />
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
              disabled={!isValid}
              type="submit"
            >
              Associa
            </button>
          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}
