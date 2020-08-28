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


export class CreateNominativeForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  generateValidationSchema = () => yup.object().shape({
    firstName: yup.string().required(),
    lastName: yup.string().required(),
    //address: yup.string().required(),
    contacts: yup.array(),
    groups: yup.array()
  })

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

  render() {
    return (
    <div className={styles.detailForm}>
      <Formik
        initialValues={{
          firstName: '',
          lastName: '',
          role: null,
          group: null,
          specificaRuolo: '',
          contacts: [],
          address: '',
          groups: [],
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitNominative}
      >
        {({values, isValid}) => (
          <Form>
            <div className={cStyles.field}>
              <label>
                <span>Nome</span>
                <Field type="text" name="firstName" />
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Cognome</span>
                <Field type="text" name="lastName" />
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Indirizzo</span>
                <Field type="text" name="address" />
              </label>
            </div>

            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Crea </button>

          </Form>
        )}
      </Formik>
    </div>
  )}
}
